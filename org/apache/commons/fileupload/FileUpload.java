package org.apache.commons.fileupload;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileUpload extends FileUploadBase {
    private FileItemFactory fileItemFactory;

    public FileUpload() {
    }

    @Override // org.apache.commons.fileupload.FileUploadBase
    public FileItemFactory getFileItemFactory() {
        return this.fileItemFactory;
    }

    @Override // org.apache.commons.fileupload.FileUploadBase
    public void setFileItemFactory(FileItemFactory fileItemFactory) {
        this.fileItemFactory = fileItemFactory;
    }

    public FileUpload(FileItemFactory fileItemFactory) {
        this.fileItemFactory = fileItemFactory;
    }
}
