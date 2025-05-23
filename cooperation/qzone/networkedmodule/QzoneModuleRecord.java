package cooperation.qzone.networkedmodule;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneModuleRecord {
    public final String mClassIds;
    public final int mClassIdsCount;
    public final String mKeyClassName;
    public final String mMD5;
    public final String mMainVersion;
    public long mModuleFileLength;
    public final String mModuleId;
    public QzoneModuleRecord mNewVersion;
    public final String mQua;
    public final String mUrl;
    public final String mVersion;

    public QzoneModuleRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, long j3, QzoneModuleRecord qzoneModuleRecord) {
        this.mModuleId = str;
        this.mVersion = str2;
        this.mMainVersion = str3;
        this.mQua = str3;
        this.mUrl = str4;
        this.mMD5 = str5;
        this.mKeyClassName = str6;
        this.mNewVersion = qzoneModuleRecord;
        this.mClassIds = str7;
        this.mClassIdsCount = i3;
        this.mModuleFileLength = j3;
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            if (obj2 == null && (obj instanceof String) && TextUtils.isEmpty((String) obj)) {
                return true;
            }
            return obj.equals(obj2);
        }
        if ((obj2 instanceof String) && TextUtils.isEmpty((String) obj2)) {
            return true;
        }
        return false;
    }

    public QzoneModuleRecord getDownloadRecord() {
        QzoneModuleRecord qzoneModuleRecord = this.mNewVersion;
        if (qzoneModuleRecord != null) {
            return qzoneModuleRecord;
        }
        return this;
    }

    public boolean hasNewConfig() {
        QzoneModuleRecord qzoneModuleRecord = this.mNewVersion;
        if (qzoneModuleRecord != null) {
            if (!isEqual(this.mVersion, qzoneModuleRecord.mVersion) || !isEqual(this.mMainVersion, this.mNewVersion.mMainVersion) || !isEqual(this.mUrl, this.mNewVersion.mUrl) || !isEqual(this.mMD5, this.mNewVersion.mMD5) || !isEqual(this.mKeyClassName, this.mNewVersion.mKeyClassName) || !isEqual(this.mQua, this.mNewVersion.mQua) || !isEqual(this.mClassIds, this.mNewVersion.mClassIds) || this.mClassIdsCount != this.mNewVersion.mClassIdsCount) {
                return true;
            }
            return false;
        }
        return false;
    }
}
