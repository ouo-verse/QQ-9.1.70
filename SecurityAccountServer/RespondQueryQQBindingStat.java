package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespondQueryQQBindingStat extends JceStruct {
    static int cache_type;
    public String MobileUniqueNo;
    public long bindingTime;
    public boolean continueUploadNotbind;
    public boolean isPhoneSwitched;
    public long isRecommend;
    public boolean isStopFindMatch;
    public long lastUsedFlag;
    public String mobileNo;
    public String nationCode;
    public boolean noBindUploadContacts;
    public boolean noBindUploadContactsLocal;
    public long originBinder;
    public int type;

    public RespondQueryQQBindingStat() {
        this.nationCode = "";
        this.mobileNo = "";
        this.MobileUniqueNo = "";
        this.isRecommend = 0L;
        this.originBinder = 0L;
        this.bindingTime = 0L;
        this.lastUsedFlag = 1L;
        this.type = 0;
        this.isStopFindMatch = false;
        this.isPhoneSwitched = false;
        this.noBindUploadContacts = false;
        this.noBindUploadContactsLocal = false;
        this.continueUploadNotbind = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nationCode = jceInputStream.readString(0, true);
        this.mobileNo = jceInputStream.readString(1, true);
        this.MobileUniqueNo = jceInputStream.readString(2, true);
        this.isRecommend = jceInputStream.read(this.isRecommend, 3, true);
        this.originBinder = jceInputStream.read(this.originBinder, 4, true);
        this.bindingTime = jceInputStream.read(this.bindingTime, 5, false);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 6, false);
        this.type = jceInputStream.read(this.type, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "[" + this.MobileUniqueNo + ", " + this.nationCode + ", " + this.mobileNo + ", " + this.lastUsedFlag + ", " + this.isStopFindMatch + ", " + this.isPhoneSwitched + ", " + this.noBindUploadContacts + ", " + this.noBindUploadContactsLocal + ", " + this.continueUploadNotbind + "]";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nationCode, 0);
        jceOutputStream.write(this.mobileNo, 1);
        jceOutputStream.write(this.MobileUniqueNo, 2);
        jceOutputStream.write(this.isRecommend, 3);
        jceOutputStream.write(this.originBinder, 4);
        jceOutputStream.write(this.bindingTime, 5);
        jceOutputStream.write(this.lastUsedFlag, 6);
        jceOutputStream.write(this.type, 7);
    }

    public RespondQueryQQBindingStat(String str, String str2, String str3, long j3, long j16, long j17, long j18, int i3) {
        this.isStopFindMatch = false;
        this.isPhoneSwitched = false;
        this.noBindUploadContacts = false;
        this.noBindUploadContactsLocal = false;
        this.continueUploadNotbind = false;
        this.nationCode = str;
        this.mobileNo = str2;
        this.MobileUniqueNo = str3;
        this.isRecommend = j3;
        this.originBinder = j16;
        this.bindingTime = j17;
        this.lastUsedFlag = j18;
        this.type = i3;
    }
}
