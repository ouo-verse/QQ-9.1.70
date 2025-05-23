package com.tencent.local_edit.andserver.http.multipart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class StandardMultipartFile implements b, Serializable {
    private final FileItem fileItem;
    private final long size;

    public StandardMultipartFile(FileItem fileItem) {
        this.fileItem = fileItem;
        this.size = fileItem.getSize();
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.b
    public byte[] getBytes() {
        if (isAvailable()) {
            byte[] bArr = this.fileItem.get();
            if (bArr == null) {
                return new byte[0];
            }
            return bArr;
        }
        throw new IllegalStateException("File has been moved - cannot be read again.");
    }

    @NonNull
    public MediaType getContentType() {
        try {
            return MediaType.parseMediaType(this.fileItem.getContentType());
        } catch (Exception unused) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    public final FileItem getFileItem() {
        return this.fileItem;
    }

    @Nullable
    public String getFilename() {
        String name = this.fileItem.getName();
        if (name == null) {
            return "";
        }
        int lastIndexOf = name.lastIndexOf("/");
        int lastIndexOf2 = name.lastIndexOf("\\");
        if (lastIndexOf2 > lastIndexOf) {
            lastIndexOf = lastIndexOf2;
        }
        if (lastIndexOf != -1) {
            return name.substring(lastIndexOf + 1);
        }
        return name;
    }

    @NonNull
    public String getName() {
        return this.fileItem.getFieldName();
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.b
    public long getSize() {
        return this.size;
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.b
    @NonNull
    public InputStream getStream() throws IOException {
        if (isAvailable()) {
            InputStream inputStream = this.fileItem.getInputStream();
            if (inputStream == null) {
                return com.tencent.local_edit.andserver.util.d.b();
            }
            return inputStream;
        }
        throw new IllegalStateException("File has been moved - cannot be read again.");
    }

    protected boolean isAvailable() {
        if (this.fileItem.isInMemory()) {
            return true;
        }
        FileItem fileItem = this.fileItem;
        if (fileItem instanceof DiskFileItem) {
            return ((DiskFileItem) fileItem).getStoreLocation().exists();
        }
        if (fileItem.getSize() == this.size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void transferTo(@NonNull File file) throws IOException, IllegalStateException {
        if (isAvailable()) {
            if (file.exists() && !file.delete()) {
                throw new IOException("Destination file [" + file.getAbsolutePath() + "] already exists and could not be deleted.");
            }
            try {
                this.fileItem.write(file);
                return;
            } catch (IOException e16) {
                throw e16;
            } catch (IllegalStateException e17) {
                throw e17;
            } catch (FileUploadException e18) {
                throw new IllegalStateException(e18.getMessage(), e18);
            } catch (Exception e19) {
                throw new IOException("File transfer failed", e19);
            }
        }
        throw new IllegalStateException("File has already been moved - cannot be transferred again.");
    }
}
