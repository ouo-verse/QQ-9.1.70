package org.apache.commons.fileupload.disk;

import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.io.FileCleaningTracker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DiskFileItemFactory implements FileItemFactory {
    public static final int DEFAULT_SIZE_THRESHOLD = 10240;
    private String defaultCharset;
    private FileCleaningTracker fileCleaningTracker;
    private File repository;
    private int sizeThreshold;

    public DiskFileItemFactory() {
        this(10240, null);
    }

    @Override // org.apache.commons.fileupload.FileItemFactory
    public FileItem createItem(String str, String str2, boolean z16, String str3) {
        DiskFileItem diskFileItem = new DiskFileItem(str, str2, z16, str3, this.sizeThreshold, this.repository);
        diskFileItem.setDefaultCharset(this.defaultCharset);
        FileCleaningTracker fileCleaningTracker = getFileCleaningTracker();
        if (fileCleaningTracker != null) {
            fileCleaningTracker.track(diskFileItem.getTempFile(), diskFileItem);
        }
        return diskFileItem;
    }

    public String getDefaultCharset() {
        return this.defaultCharset;
    }

    public FileCleaningTracker getFileCleaningTracker() {
        return this.fileCleaningTracker;
    }

    public File getRepository() {
        return this.repository;
    }

    public int getSizeThreshold() {
        return this.sizeThreshold;
    }

    public void setDefaultCharset(String str) {
        this.defaultCharset = str;
    }

    public void setFileCleaningTracker(FileCleaningTracker fileCleaningTracker) {
        this.fileCleaningTracker = fileCleaningTracker;
    }

    public void setRepository(File file) {
        this.repository = file;
    }

    public void setSizeThreshold(int i3) {
        this.sizeThreshold = i3;
    }

    public DiskFileItemFactory(int i3, File file) {
        this.defaultCharset = "ISO-8859-1";
        this.sizeThreshold = i3;
        this.repository = file;
    }
}
