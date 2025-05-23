package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile;
import com.tencent.hippy.qq.update.tool.v.VersionConfiguration;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class QarHelper {
    protected HashMap<String, Long> checkSum = new HashMap<>();
    protected QarHeader proxyHeader = new QarHeader();
    protected QarBody proxyBody = new QarBody();
    protected List<String> exceptFiles = null;
    protected List<String> uncompressFiles = null;

    protected abstract List<ExtensionFiled> addExBody(QarBody qarBody);

    protected abstract List<ExtensionFiled> addExHeader(QarHeader qarHeader);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkSum(String str) {
        PrintStream printStream;
        StringBuilder sb5;
        boolean z16 = false;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    Enumeration<ZipEntry> entries = zipFile2.getEntries();
                    while (true) {
                        if (entries.hasMoreElements()) {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.getName().contains("../")) {
                                if (nextElement.getCrc() != this.checkSum.get(nextElement.getName()).longValue()) {
                                    break;
                                }
                            }
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    this.checkSum.clear();
                } catch (IOException e16) {
                    e = e16;
                    zipFile = zipFile2;
                    System.out.println("Error opening zip file" + e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e17) {
                            e = e17;
                            printStream = System.out;
                            sb5 = new StringBuilder();
                            sb5.append("Error while closing zip file");
                            sb5.append(e);
                            printStream.println(sb5.toString());
                            return z16;
                        }
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e18) {
                            System.out.println("Error while closing zip file" + e18);
                        }
                    }
                    throw th;
                }
                try {
                    zipFile2.close();
                } catch (IOException e19) {
                    e = e19;
                    printStream = System.out;
                    sb5 = new StringBuilder();
                    sb5.append("Error while closing zip file");
                    sb5.append(e);
                    printStream.println(sb5.toString());
                    return z16;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getQarMd5(File file);

    /* JADX INFO: Access modifiers changed from: protected */
    public void md5Body(MessageDigest messageDigest, ZipEntry zipEntry, int i3) throws IOException {
        this.proxyBody.setBody(i3, zipEntry.getName(), zipEntry.getSize(), zipEntry.getCrc(), zipEntry.getMethod());
        QarBody qarBody = this.proxyBody;
        qarBody.setExtensionFileds(addExBody(qarBody));
        this.proxyBody.md5Body(messageDigest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void md5BodyData(MessageDigest messageDigest, InputStream inputStream, byte[] bArr) throws IOException {
        this.proxyBody.md5BodyData(messageDigest, inputStream, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void md5Header(MessageDigest messageDigest) throws IOException {
        this.proxyHeader.setHeader(VersionConfiguration.CURRENT_VERSION);
        QarHeader qarHeader = this.proxyHeader;
        qarHeader.setExtensionFileds(addExHeader(qarHeader));
        this.proxyHeader.md5Header(messageDigest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean read(String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExceptFiles(List<String> list) {
        this.exceptFiles = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUncompressList(List<String> list) {
        this.uncompressFiles = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean write(File file, File file2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeBody(BufferedOutputStream bufferedOutputStream, ZipEntry zipEntry, int i3) throws IOException {
        this.proxyBody.setBody(i3, zipEntry.getName(), zipEntry.getSize(), zipEntry.getCrc(), zipEntry.getMethod());
        QarBody qarBody = this.proxyBody;
        qarBody.setExtensionFileds(addExBody(qarBody));
        this.proxyBody.writeBody(bufferedOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeBodyData(BufferedOutputStream bufferedOutputStream, InputStream inputStream, byte[] bArr) throws IOException {
        this.proxyBody.writeBodyData(bufferedOutputStream, inputStream, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeHeader(BufferedOutputStream bufferedOutputStream) throws IOException {
        this.proxyHeader.setHeader(VersionConfiguration.CURRENT_VERSION);
        QarHeader qarHeader = this.proxyHeader;
        qarHeader.setExtensionFileds(addExHeader(qarHeader));
        this.proxyHeader.writeHeader(bufferedOutputStream);
    }
}
