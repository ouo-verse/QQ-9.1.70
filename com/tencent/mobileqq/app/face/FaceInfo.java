package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.avatar.api.IAvatarReportUtilApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceInfo implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<FaceInfo> CREATOR;
    public static int RESULT_FAIL = 0;
    public static int RESULT_PAUSE = 0;
    public static int RESULT_SUC = 0;
    public static int RESULT_TIMEOUT = 0;
    private static final String TAG = "Q.qqhead.FaceInfo";
    public static int TIME_BEGINE = 0;
    public static int TIME_BEGIN_DECODE = 0;
    public static int TIME_BEGIN_DOWNLOAD = 0;
    public static int TIME_BEGIN_DOWNLOADINFO = 0;
    public static int TIME_END_DECODE = 0;
    public static int TIME_END_DOWNLOAD = 0;
    public static int TIME_END_DOWNLOADINFO = 0;
    public static int TIME_REQ_END = 0;
    public static int TIME_REQ_READY = 0;
    public static int TIME_TYPE_COUNT = 0;
    public static final boolean TRACE_COST = true;
    public byte apngFaceFlag;
    public boolean appendToTail;
    public byte dynamicZplanFaceFlag;
    private boolean enableZplanOutbound;
    public String faceBmpCacheKey;
    public byte faceFileType;
    public String faceKey;
    private String faceUrlUniq;
    private AtomicBoolean hasUpdateFromSetting;
    public byte headLevel;
    public int headType;
    public int idType;
    public boolean isDynamicMode;
    public String localPath;
    public int mHasFaceInfo;
    public QQHeadInfo mHeadInfo;
    public long[] mTimes;
    public int shape;
    public int sizeType;
    public boolean smartMode;
    public byte staticZplanFaceFlag;
    public long timeStamp;
    public String uin;
    public String zplanFaceBgUrl;
    public int zplanFaceClipPercent;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<FaceInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaceInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FaceInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            FaceInfo faceInfo = new FaceInfo();
            faceInfo.readFromParcel(parcel);
            return faceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FaceInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FaceInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new FaceInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        CREATOR = new a();
        RESULT_SUC = 0;
        RESULT_FAIL = 1;
        RESULT_PAUSE = 2;
        RESULT_TIMEOUT = 3;
        TIME_BEGINE = 0;
        int i3 = 0 + 1;
        TIME_REQ_READY = i3;
        int i16 = i3 + 1;
        TIME_BEGIN_DOWNLOADINFO = i16;
        int i17 = i16 + 1;
        TIME_END_DOWNLOADINFO = i17;
        int i18 = i17 + 1;
        TIME_BEGIN_DOWNLOAD = i18;
        int i19 = i18 + 1;
        TIME_END_DOWNLOAD = i19;
        int i26 = i19 + 1;
        TIME_BEGIN_DECODE = i26;
        int i27 = i26 + 1;
        TIME_END_DECODE = i27;
        int i28 = i27 + 1;
        TIME_REQ_END = i28;
        TIME_TYPE_COUNT = i28 + 1;
    }

    public FaceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.mTimes = null;
        this.mHasFaceInfo = 0;
        this.hasUpdateFromSetting = new AtomicBoolean(false);
        if (this.mTimes == null) {
            this.mTimes = new long[TIME_TYPE_COUNT];
        }
        for (int i3 = 0; i3 < TIME_TYPE_COUNT; i3++) {
            this.mTimes[i3] = 0;
        }
    }

    private String getProcessName(int i3) {
        switch (i3) {
            case 0:
                return "TIME_BEGINE";
            case 1:
                return "TIME_REQ_READY";
            case 2:
                return "TIME_BEGIN_DOWNLOADINFO";
            case 3:
                return "TIME_END_DOWNLOADINFO";
            case 4:
                return "TIME_BEGIN_DOWNLOAD";
            case 5:
                return "TIME_END_DOWNLOAD";
            case 6:
                return "TIME_BEGIN_DECODE";
            case 7:
                return "TIME_END_DECODE";
            case 8:
                return "TIME_REQ_END";
            default:
                return null;
        }
    }

    private void printLog(int i3, long j3) {
        if (!QLog.isDevelopLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(260);
        sb5.append("id=");
        sb5.append(this.uin);
        sb5.append(",");
        sb5.append("idType=");
        sb5.append(this.idType);
        sb5.append(",");
        sb5.append("headType=");
        sb5.append(this.headType);
        sb5.append(",");
        sb5.append("shape=");
        sb5.append(this.shape);
        sb5.append(" ,Times={");
        long j16 = 0;
        for (int i16 = 0; i16 < this.mTimes.length; i16++) {
            sb5.append("[");
            sb5.append(getProcessName(i16));
            sb5.append(",");
            sb5.append(this.mTimes[i16]);
            sb5.append(",");
            long j17 = this.mTimes[i16];
            if (j17 > 0) {
                sb5.append(Math.abs(j16 - j17));
                sb5.append("]");
            } else {
                sb5.append("0");
                sb5.append("]");
            }
            long j18 = this.mTimes[i16];
            if (j18 > 0) {
                j16 = j18;
            }
        }
        sb5.append("}, cost = ");
        sb5.append(j3);
        sb5.append(", result = ");
        sb5.append(i3);
        QLog.i("FaceCost", 4, sb5.toString());
    }

    public void bindHeadInfo(QQHeadInfo qQHeadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQHeadInfo);
        } else {
            if (qQHeadInfo == null) {
                return;
            }
            this.mHeadInfo = qQHeadInfo;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, obj)).booleanValue();
        }
        FaceInfo faceInfo = (FaceInfo) obj;
        if (this.headType == faceInfo.headType && TextUtils.equals(this.uin, faceInfo.uin) && this.idType == faceInfo.idType && this.shape == faceInfo.shape) {
            return true;
        }
        return false;
    }

    public String getFaceBmpCacheKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.faceBmpCacheKey)) {
            this.faceBmpCacheKey = getFaceBmpCacheKey(this.headType, this.uin, this.idType, this.shape, this.sizeType);
        }
        return this.faceBmpCacheKey;
    }

    public String getFaceKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (TextUtils.isEmpty(this.faceKey)) {
            if (isUserHeadType() && isEnableZplanOutbound() && isSupportStaticZplanAvatarInfo()) {
                StringBuilder sb5 = new StringBuilder(100);
                sb5.append(this.headType);
                sb5.append("_");
                sb5.append(this.sizeType);
                sb5.append("_");
                sb5.append(this.uin);
                return sb5.toString();
            }
            this.faceKey = getFaceKey(this.headType, this.uin, this.idType, this.sizeType);
        }
        return this.faceKey;
    }

    public String getFaceUrlUniq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (TextUtils.isEmpty(this.faceUrlUniq)) {
            this.faceUrlUniq = getFaceUrlUniq(this.mHeadInfo, this.idType);
            if (this.headType == 1 && ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn()) {
                this.faceUrlUniq += "_" + isEnableZplanOutbound();
            }
        }
        return this.faceUrlUniq;
    }

    public byte getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Byte) iPatchRedirector.redirect((short) 11, (Object) this)).byteValue();
        }
        if (this.headLevel != 1) {
            return (byte) 1;
        }
        return (byte) 0;
    }

    public boolean hasUpdateFromSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.hasUpdateFromSetting.get();
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int i3 = this.headType;
        if (TextUtils.isEmpty(this.uin)) {
            hashCode = 0;
        } else {
            hashCode = this.uin.hashCode();
        }
        return i3 | hashCode;
    }

    public void init(int i3, String str, boolean z16, byte b16, int i16, boolean z17, int i17, int i18, boolean z18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z18), Integer.valueOf(i19));
            return;
        }
        this.isDynamicMode = z18;
        this.headType = i3;
        this.uin = str;
        this.appendToTail = z16;
        this.headLevel = b16;
        this.shape = i16;
        this.smartMode = z17;
        this.idType = i17;
        this.faceBmpCacheKey = null;
        this.faceKey = null;
        this.localPath = null;
        this.timeStamp = 0L;
        this.mHasFaceInfo = i18;
        this.sizeType = i19;
        if (this.mTimes == null) {
            this.mTimes = new long[TIME_TYPE_COUNT];
        }
        for (int i26 = 0; i26 < TIME_TYPE_COUNT; i26++) {
            this.mTimes[i26] = 0;
        }
    }

    public final boolean isEnableZplanOutbound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.enableZplanOutbound;
    }

    public final boolean isRealLoadZplanStaticAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (isEnableZplanOutbound() && isSupportStaticZplanAvatarInfo()) {
            return true;
        }
        return false;
    }

    public final boolean isSupportDynamicZplanAvatarInfo() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.dynamicZplanFaceFlag > 0 && (str = this.zplanFaceBgUrl) != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean isSupportStaticZplanAvatarInfo() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (this.staticZplanFaceFlag > 0 && (str = this.zplanFaceBgUrl) != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isTimeOut(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        long[] jArr = this.mTimes;
        if (jArr == null || i3 < 0 || i3 >= TIME_TYPE_COUNT) {
            return false;
        }
        if (jArr[i3] == 0) {
            if (!QLog.isDevelopLevel()) {
                return false;
            }
            QLog.i(TAG, 2, "isTimeOut");
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - this.mTimes[i3]) < j3) {
            z16 = false;
        }
        return z16;
    }

    public final boolean isUserHeadType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.headType == 1) {
            return true;
        }
        return false;
    }

    public void markTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            markTime(i3, 0);
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
            return;
        }
        this.headType = parcel.readInt();
        this.uin = parcel.readString();
        this.idType = parcel.readInt();
        this.shape = parcel.readInt();
        this.sizeType = parcel.readInt();
        this.headLevel = parcel.readByte();
        boolean z17 = false;
        if (parcel.readByte() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.smartMode = z16;
        this.localPath = parcel.readString();
        this.timeStamp = parcel.readLong();
        this.mHeadInfo = (QQHeadInfo) parcel.readParcelable(getClass().getClassLoader());
        if (parcel.readByte() == 1) {
            z17 = true;
        }
        this.enableZplanOutbound = z17;
        this.staticZplanFaceFlag = parcel.readByte();
        this.dynamicZplanFaceFlag = parcel.readByte();
        this.zplanFaceBgUrl = parcel.readString();
        this.zplanFaceClipPercent = parcel.readInt();
    }

    public void readSettingAndUpdate() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            if (hasUpdateFromSetting() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            updateZplanAvatarInfoFromSetting((Setting) ((IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(this.headType, this.uin, this.idType).second);
        }
    }

    public final void setEnableZplanOutbound(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            setEnableZplanOutbound(z16, 1);
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("[");
        sb5.append(this.headType);
        sb5.append(",");
        sb5.append(this.idType);
        sb5.append(",");
        sb5.append(this.uin);
        sb5.append(",");
        sb5.append(this.shape);
        sb5.append(",");
        sb5.append(this.sizeType);
        sb5.append(',');
        sb5.append("[zplan:");
        sb5.append("enableOut:");
        sb5.append(this.enableZplanOutbound);
        sb5.append(',');
        sb5.append((int) this.staticZplanFaceFlag);
        sb5.append(',');
        sb5.append((int) this.dynamicZplanFaceFlag);
        sb5.append(',');
        sb5.append(this.zplanFaceClipPercent);
        sb5.append(',');
        sb5.append(this.zplanFaceBgUrl);
        sb5.append("]");
        sb5.append("]");
        return sb5.toString();
    }

    public void updateZplanAvatarInfoFromSetting(Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) setting);
            return;
        }
        if (setting == null) {
            QLog.e(TAG, 1, "updateZplanAvatarInfoFromSetting setting is null");
            return;
        }
        if (isUserHeadType() && this.hasUpdateFromSetting.compareAndSet(false, true)) {
            this.staticZplanFaceFlag = setting.staticZplanFaceFlag;
            this.dynamicZplanFaceFlag = setting.dynamicZplanFaceFlag;
            this.zplanFaceBgUrl = setting.zplanFaceBgUrl;
            this.zplanFaceClipPercent = setting.zplanFaceClipPercent;
            if (isRealLoadZplanStaticAvatar()) {
                URLDrawable.getDrawable(this.zplanFaceBgUrl, URLDrawable.URLDrawableOptions.obtain()).startDownload(true);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.headType);
        parcel.writeString(this.uin);
        parcel.writeInt(this.idType);
        parcel.writeInt(this.shape);
        parcel.writeInt(this.sizeType);
        parcel.writeByte(this.headLevel);
        parcel.writeByte(this.smartMode ? (byte) 1 : (byte) 0);
        parcel.writeString(this.localPath);
        parcel.writeLong(this.timeStamp);
        parcel.writeParcelable(this.mHeadInfo, 0);
        parcel.writeByte(this.enableZplanOutbound ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.staticZplanFaceFlag);
        parcel.writeByte(this.dynamicZplanFaceFlag);
        parcel.writeString(this.zplanFaceBgUrl);
        parcel.writeInt(this.zplanFaceClipPercent);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void markTime(int i3, int i16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        long[] jArr = this.mTimes;
        if (jArr != null && i3 >= 0 && i3 < TIME_TYPE_COUNT) {
            jArr[i3] = System.currentTimeMillis();
            if (i3 == TIME_REQ_END && QLog.isColorLevel()) {
                long[] jArr2 = this.mTimes;
                long j16 = jArr2[TIME_REQ_END];
                if (j16 > 0) {
                    long j17 = jArr2[TIME_BEGINE];
                    if (j17 > 0) {
                        j3 = Math.abs(j16 - j17);
                        printLog(i16, j3);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("success", i16 != RESULT_SUC ? "true" : "false");
                        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
                        hashMap.put("head_type", String.valueOf(this.headType));
                        hashMap.put("head_id", this.headType != 11 ? "" : this.uin);
                        ((IAvatarReportUtilApi) QRoute.api(IAvatarReportUtilApi.class)).report(this.mTimes[TIME_BEGIN_DECODE] <= 0 ? "QQAvatarAsyncLoad" : "QQAvatarSyncLoad", i16 != RESULT_SUC, j3, hashMap);
                    }
                }
                j3 = 0;
                printLog(i16, j3);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("success", i16 != RESULT_SUC ? "true" : "false");
                hashMap2.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
                hashMap2.put("head_type", String.valueOf(this.headType));
                hashMap2.put("head_id", this.headType != 11 ? "" : this.uin);
                ((IAvatarReportUtilApi) QRoute.api(IAvatarReportUtilApi.class)).report(this.mTimes[TIME_BEGIN_DECODE] <= 0 ? "QQAvatarAsyncLoad" : "QQAvatarSyncLoad", i16 != RESULT_SUC, j3, hashMap2);
            }
        }
    }

    public final void setEnableZplanOutbound(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).checkOutboundHeadSceneEnable(i3)) {
            this.enableZplanOutbound = z16;
        }
    }

    public static String getFaceBmpCacheKey(int i3, String str, int i16, int i17, int i18) {
        StringBuilder sb5 = new StringBuilder(16);
        if (i3 == 4) {
            sb5.append("troop_");
        } else if (i3 == 16) {
            sb5.append("qcall_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (i3 == 32) {
            sb5.append("stranger_");
            sb5.append(Integer.toString(i16));
            sb5.append("_");
        } else if (i3 == 101) {
            sb5.append("dis_g_");
        } else if (i3 == 103) {
            sb5.append("sub_");
        } else if (i3 == 116) {
            sb5.append("apollo_");
            sb5.append(Integer.toString(i18));
            sb5.append("_");
        }
        sb5.append(str);
        if (i17 > 0) {
            sb5.append("_");
            sb5.append(i17);
        }
        return sb5.toString();
    }

    public static String getFaceUrlUniq(QQHeadInfo qQHeadInfo, int i3) {
        if (qQHeadInfo == null || TextUtils.isEmpty(qQHeadInfo.downLoadUrl)) {
            return "";
        }
        byte b16 = qQHeadInfo.dstUsrType;
        if (b16 == 116) {
            return qQHeadInfo.downLoadUrl + "_" + qQHeadInfo.sizeType + "_" + qQHeadInfo.uin;
        }
        if (b16 == 1) {
            if (qQHeadInfo.enableZplanOutbound) {
                if (qQHeadInfo.staticZplanFaceFlag > 0) {
                    return qQHeadInfo.downLoadUrl + "_sz" + qQHeadInfo.sizeType;
                }
                return qQHeadInfo.downLoadUrl + "_" + i3;
            }
            return qQHeadInfo.downLoadUrl + "_" + i3;
        }
        return qQHeadInfo.downLoadUrl + "_" + i3;
    }

    public static String getFaceKey(int i3, String str, int i16, int i17) {
        StringBuilder sb5 = new StringBuilder(100);
        if (i3 == 16 || i3 == 32) {
            sb5.append(i3);
            sb5.append("_");
            sb5.append(i16);
            sb5.append("_");
            sb5.append(str);
        } else if (i3 != 116) {
            sb5.append(i3);
            sb5.append("_");
            sb5.append(str);
        } else {
            sb5.append(i3);
            sb5.append("_");
            sb5.append(i17);
            sb5.append("_");
            sb5.append(str);
        }
        return sb5.toString();
    }

    public FaceInfo(int i3, String str, boolean z16, byte b16, int i16, boolean z17, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17));
            return;
        }
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.mTimes = null;
        this.mHasFaceInfo = 0;
        this.hasUpdateFromSetting = new AtomicBoolean(false);
        init(i3, str, z16, b16, i16, z17, i17, 0, false, 100);
    }

    public FaceInfo(int i3, String str, boolean z16, byte b16, int i16, boolean z17, int i17, boolean z18, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Boolean.valueOf(z18), Integer.valueOf(i18));
            return;
        }
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.mTimes = null;
        this.mHasFaceInfo = 0;
        this.hasUpdateFromSetting = new AtomicBoolean(false);
        init(i3, str, z16, b16, i16, z17, i17, 0, z18, i18);
    }

    public FaceInfo(int i3, String str, boolean z16, byte b16, int i16, boolean z17, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.mTimes = null;
        this.mHasFaceInfo = 0;
        this.hasUpdateFromSetting = new AtomicBoolean(false);
        init(i3, str, z16, b16, i16, z17, i17, i18, false, 100);
    }

    public FaceInfo(int i3, String str, boolean z16, byte b16, int i16, boolean z17, int i17, int i18, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(b16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z18));
            return;
        }
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.mTimes = null;
        this.mHasFaceInfo = 0;
        this.hasUpdateFromSetting = new AtomicBoolean(false);
        init(i3, str, z16, b16, i16, z17, i17, i18, z18, 100);
    }
}
