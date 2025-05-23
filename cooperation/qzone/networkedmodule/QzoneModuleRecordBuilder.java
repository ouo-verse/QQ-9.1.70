package cooperation.qzone.networkedmodule;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneModuleRecordBuilder {
    private String classIds;
    private int classIdsCount;
    private String mainVersion;
    private long moduleFileLength;
    private String moduleId;
    private QzoneModuleRecord newVersion;
    private String url;
    private String version;
    private String md5 = "";
    private String keyClassName = "";

    public QzoneModuleRecord build() {
        if (!TextUtils.isEmpty(this.moduleId)) {
            return new QzoneModuleRecord(this.moduleId, this.version, this.mainVersion, this.url, this.md5, this.keyClassName, this.classIds, this.classIdsCount, this.moduleFileLength, this.newVersion);
        }
        throw new IllegalArgumentException("moduleId can not be null");
    }

    public QzoneModuleRecordBuilder setClassIds(String str) {
        this.classIds = str;
        return this;
    }

    public QzoneModuleRecordBuilder setClassIdsCount(int i3) {
        this.classIdsCount = i3;
        return this;
    }

    public QzoneModuleRecordBuilder setKeyClassName(String str) {
        this.keyClassName = str;
        return this;
    }

    public QzoneModuleRecordBuilder setMD5(String str) {
        this.md5 = str;
        return this;
    }

    public QzoneModuleRecordBuilder setMainVersion(String str) {
        this.mainVersion = str;
        return this;
    }

    public QzoneModuleRecordBuilder setModuleFileLength(long j3) {
        this.moduleFileLength = j3;
        return this;
    }

    public QzoneModuleRecordBuilder setModuleId(String str) {
        this.moduleId = str;
        return this;
    }

    public QzoneModuleRecordBuilder setNewVersion(QzoneModuleRecord qzoneModuleRecord) {
        this.newVersion = qzoneModuleRecord;
        return this;
    }

    public QzoneModuleRecordBuilder setUrl(String str) {
        this.url = str;
        return this;
    }

    public QzoneModuleRecordBuilder setVersion(String str) {
        this.version = str;
        return this;
    }
}
