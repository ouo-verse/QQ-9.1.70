package org.apache.commons.fileupload.disk;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import oicq.wlogin_sdk.tools.util;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ParameterParser;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.DeferredFileOutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DiskFileItem implements FileItem {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    private byte[] cachedContent;
    private final String contentType;
    private transient DeferredFileOutputStream dfos;
    private String fieldName;
    private final String fileName;
    private FileItemHeaders headers;
    private boolean isFormField;
    private final File repository;
    private final int sizeThreshold;
    private transient File tempFile;
    private static final String UID = UUID.randomUUID().toString().replace('-', util.base64_pad_url);
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private long size = -1;
    private String defaultCharset = "ISO-8859-1";

    public DiskFileItem(String str, String str2, boolean z16, String str3, int i3, File file) {
        this.fieldName = str;
        this.contentType = str2;
        this.isFormField = z16;
        this.fileName = str3;
        this.sizeThreshold = i3;
        this.repository = file;
    }

    private static String getUniqueId() {
        int andIncrement = COUNTER.getAndIncrement();
        String num = Integer.toString(andIncrement);
        if (andIncrement < 100000000) {
            return ("00000000" + num).substring(num.length());
        }
        return num;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public void delete() {
        this.cachedContent = null;
        File storeLocation = getStoreLocation();
        if (storeLocation != null && !isInMemory() && storeLocation.exists()) {
            storeLocation.delete();
        }
    }

    protected void finalize() {
        File file;
        DeferredFileOutputStream deferredFileOutputStream = this.dfos;
        if (deferredFileOutputStream != null && !deferredFileOutputStream.isInMemory() && (file = this.dfos.getFile()) != null && file.exists()) {
            file.delete();
        }
    }

    @Override // org.apache.commons.fileupload.FileItem
    public byte[] get() {
        FileInputStream fileInputStream;
        DeferredFileOutputStream deferredFileOutputStream;
        if (isInMemory()) {
            if (this.cachedContent == null && (deferredFileOutputStream = this.dfos) != null) {
                this.cachedContent = deferredFileOutputStream.getData();
            }
            return this.cachedContent;
        }
        byte[] bArr = new byte[(int) getSize()];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.dfos.getFile());
            try {
                IOUtils.readFully(fileInputStream, bArr);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return bArr;
            } catch (IOException unused) {
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly((InputStream) fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String getCharSet() {
        ParameterParser parameterParser = new ParameterParser();
        parameterParser.setLowerCaseNames(true);
        return parameterParser.parse(getContentType(), ';').get(HttpMsg.CHARSET);
    }

    @Override // org.apache.commons.fileupload.FileItem
    public String getContentType() {
        return this.contentType;
    }

    public String getDefaultCharset() {
        return this.defaultCharset;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public String getFieldName() {
        return this.fieldName;
    }

    @Override // org.apache.commons.fileupload.FileItemHeadersSupport
    public FileItemHeaders getHeaders() {
        return this.headers;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public InputStream getInputStream() throws IOException {
        if (!isInMemory()) {
            return new FileInputStream(this.dfos.getFile());
        }
        if (this.cachedContent == null) {
            this.cachedContent = this.dfos.getData();
        }
        return new ByteArrayInputStream(this.cachedContent);
    }

    @Override // org.apache.commons.fileupload.FileItem
    public String getName() {
        return Streams.checkFileName(this.fileName);
    }

    @Override // org.apache.commons.fileupload.FileItem
    public OutputStream getOutputStream() throws IOException {
        if (this.dfos == null) {
            this.dfos = new DeferredFileOutputStream(this.sizeThreshold, getTempFile());
        }
        return this.dfos;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public long getSize() {
        long j3 = this.size;
        if (j3 >= 0) {
            return j3;
        }
        if (this.cachedContent != null) {
            return r0.length;
        }
        if (this.dfos.isInMemory()) {
            return this.dfos.getData().length;
        }
        return this.dfos.getFile().length();
    }

    public File getStoreLocation() {
        if (this.dfos == null || isInMemory()) {
            return null;
        }
        return this.dfos.getFile();
    }

    @Override // org.apache.commons.fileupload.FileItem
    public String getString(String str) throws UnsupportedEncodingException {
        return new String(get(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File getTempFile() {
        if (this.tempFile == null) {
            File file = this.repository;
            if (file == null) {
                file = new File(System.getProperty("java.io.tmpdir"));
            }
            this.tempFile = new File(file, String.format("upload_%s_%s.tmp", UID, getUniqueId()));
        }
        return this.tempFile;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public boolean isFormField() {
        return this.isFormField;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public boolean isInMemory() {
        if (this.cachedContent != null) {
            return true;
        }
        return this.dfos.isInMemory();
    }

    public void setDefaultCharset(String str) {
        this.defaultCharset = str;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public void setFieldName(String str) {
        this.fieldName = str;
    }

    @Override // org.apache.commons.fileupload.FileItem
    public void setFormField(boolean z16) {
        this.isFormField = z16;
    }

    @Override // org.apache.commons.fileupload.FileItemHeadersSupport
    public void setHeaders(FileItemHeaders fileItemHeaders) {
        this.headers = fileItemHeaders;
    }

    public String toString() {
        return String.format("name=%s, StoreLocation=%s, size=%s bytes, isFormField=%s, FieldName=%s", getName(), getStoreLocation(), Long.valueOf(getSize()), Boolean.valueOf(isFormField()), getFieldName());
    }

    @Override // org.apache.commons.fileupload.FileItem
    public void write(File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (isInMemory()) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(get());
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                return;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                throw th;
            }
        }
        File storeLocation = getStoreLocation();
        if (storeLocation != null) {
            this.size = storeLocation.length();
            FileUtils.moveFile(storeLocation, file);
            return;
        }
        throw new FileUploadException("Cannot write uploaded file to disk!");
    }

    @Override // org.apache.commons.fileupload.FileItem
    public String getString() {
        byte[] bArr = get();
        String charSet = getCharSet();
        if (charSet == null) {
            charSet = this.defaultCharset;
        }
        try {
            return new String(bArr, charSet);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }
}
