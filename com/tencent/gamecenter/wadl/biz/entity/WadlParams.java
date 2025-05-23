package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class WadlParams implements Parcelable {
    public static final Parcelable.Creator<WadlParams> CREATOR = new a();
    public static final String TAG = "Wadl_WadlParams";
    public int actionCode;
    public String adtag;
    public String apkChannel;
    public String apkSign;
    public String apkUrl;
    public String appId;
    public String appName;
    public int channelNum;
    public boolean delayDownload;
    public int downloadType;
    public int dualSwitch;
    public int extFlags;
    public String extraData;
    public int flags;
    public int from;
    public String fromWebUrl;
    public String iconUrl;
    public int ignoreSpace;
    public volatile boolean isCancelRequest;
    public int isDirectUseDualWay;
    public boolean isDualDownload;
    public boolean isRes;
    public String jsonParams;
    public String launchVia;
    public long mieActId;
    public int noticeCount;
    public String packageName;
    public long pkgSize;
    public String reportData;
    public String resDir;
    public int resIndex;
    public String resMD5;
    public String resName;
    public int resType;
    public String resVersionName;
    public int scene;
    public String sceneId;
    public String sourceId;
    public int speedBuffer;
    public int versionCode;
    public String via;
    public WadlParamsExt wadlParamsExt;
    public WadlParamsPageInfo wadlParamsPageInfo;
    public long yyEndTime;
    public long yyStartTime;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<WadlParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WadlParams createFromParcel(Parcel parcel) {
            WadlParams wadlParams = new WadlParams("");
            wadlParams.readFromParcel(parcel);
            return wadlParams;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WadlParams[] newArray(int i3) {
            return new WadlParams[i3];
        }
    }

    public WadlParams() {
        this.downloadType = 1;
        this.appId = "";
        this.apkChannel = "";
        this.apkUrl = "";
        this.packageName = "";
        this.resIndex = -1;
        this.mieActId = 0L;
        this.appName = "";
        this.iconUrl = "";
        this.via = "";
        this.fromWebUrl = "";
        this.adtag = "";
        this.extraData = "";
        this.sourceId = "";
        this.sceneId = "3";
        this.isDirectUseDualWay = -1;
        this.dualSwitch = 0;
        this.wadlParamsExt = new WadlParamsExt();
        this.wadlParamsPageInfo = new WadlParamsPageInfo();
    }

    public static String createResId(String str, int i3, int i16, String str2) {
        if (i3 == 4) {
            return str + "_" + i3 + "_" + i16;
        }
        return str + "_" + i3 + "_" + i16 + "_" + str2;
    }

    private void setFlags(JSONObject jSONObject) {
        if (jSONObject.has("isAutoInstall") && jSONObject.optInt("isAutoInstall") == 0) {
            setFlagDisable(1);
        }
        if (jSONObject.has("showPageNotification") && jSONObject.optInt("showPageNotification") == 0) {
            setFlagDisable(2);
        }
        if (jSONObject.has("showSystemNotification") && jSONObject.optInt("showSystemNotification") == 0) {
            setFlagDisable(4);
        }
        if (jSONObject.has("requireWifi") && jSONObject.optBoolean("requireWifi", false)) {
            setFlags(8);
        }
        if (!jSONObject.has("showNetworkDiaLog") || jSONObject.optInt("showNetworkDiaLog") <= 0) {
            return;
        }
        setFlags(16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getFlagEnable(int i3) {
        if ((this.flags & i3) == i3) {
            return true;
        }
        return false;
    }

    public String getResId() {
        if (this.isRes) {
            return createResId(this.appId, this.resType, this.versionCode, this.resName);
        }
        return this.appId;
    }

    public boolean isExtFlagEnable(int i3) {
        if ((this.extFlags & i3) == i3) {
            return true;
        }
        return false;
    }

    public void parseFromJson(String str) {
        int i3;
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("actionCode");
            this.actionCode = optInt;
            if (optInt == 12) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            this.downloadType = i3;
            this.appId = jSONObject.optString("appId");
            this.apkSign = jSONObject.optString(WadlProxyConsts.APKSIGN);
            this.versionCode = jSONObject.optInt("versionCode");
            this.packageName = jSONObject.optString("packageName");
            this.appName = jSONObject.optString("appName");
            this.iconUrl = jSONObject.optString("iconUrl");
            if (jSONObject.optInt("delayDownload") > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.delayDownload = z16;
            this.fromWebUrl = jSONObject.optString("fromWebUrl");
            this.apkChannel = jSONObject.optString("apkChannel", WadlProxyConsts.APP_CHANNEL_GAMECENTER);
            this.via = jSONObject.optString("via");
            this.yyStartTime = jSONObject.optLong("downloadStartTime");
            this.yyEndTime = jSONObject.optLong("downloadEndTime");
            this.adtag = jSONObject.optString("adtag");
            this.from = jSONObject.optInt("from", 0);
            this.flags = jSONObject.optInt(WadlProxyConsts.FLAGS, pbenterroom.CMD_NEW_ACCESS);
            if (getFlagEnable(64)) {
                setFlagDisable(64);
                setFlags(1);
            }
            if (getFlagEnable(128)) {
                setFlagDisable(128);
            }
            this.extraData = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
            this.wadlParamsExt.b(jSONObject);
            this.wadlParamsPageInfo.b(jSONObject);
            this.appId = jSONObject.optString("appid", this.appId);
            this.fromWebUrl = jSONObject.optString("wadlSource", this.fromWebUrl);
            this.apkSign = jSONObject.optString("myAppId", this.apkSign);
            setFlags(jSONObject);
            this.sourceId = jSONObject.optString("sourceId");
            this.pkgSize = jSONObject.optLong(VirtualAppProxy.KEY_PKG_SIZE);
            boolean optBoolean = jSONObject.optBoolean(WadlResult.WEB_KEY_IS_RES);
            this.isRes = optBoolean;
            if (optBoolean) {
                this.apkUrl = jSONObject.optString(WadlProxyConsts.RES_URL);
            } else {
                String optString = jSONObject.optString("apkUrl");
                this.apkUrl = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.apkUrl = jSONObject.optString("url");
                }
            }
            this.resIndex = jSONObject.optInt(WadlProxyConsts.RES_INDEX);
            this.resVersionName = jSONObject.optString("resVersionCode");
            this.resName = jSONObject.optString("resName");
            this.resMD5 = jSONObject.optString(WadlResult.WEB_KEY_RES_MD5);
            this.scene = jSONObject.optInt("scene", 0);
            this.reportData = jSONObject.optString("report_data");
            this.launchVia = jSONObject.optString("launch_via");
            this.mieActId = jSONObject.optLong("mieActId");
            this.isDirectUseDualWay = jSONObject.optInt("isDirectUseDualWay", -1);
            if (this.appId == null) {
                this.appId = "";
            }
            this.speedBuffer = jSONObject.optInt(WadlProxyConsts.PARAM_SPEED_BUFFER, 0);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse json exception:", e16);
        }
    }

    public String parseToJsonStr() {
        if (!TextUtils.isEmpty(this.jsonParams)) {
            return this.jsonParams;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionCode", this.actionCode);
            jSONObject.putOpt("appId", this.appId);
            jSONObject.putOpt(WadlProxyConsts.APKSIGN, this.apkSign);
            jSONObject.put("versionCode", this.versionCode);
            jSONObject.putOpt("packageName", this.packageName);
            jSONObject.putOpt("appName", this.appName);
            jSONObject.putOpt("iconUrl", this.iconUrl);
            jSONObject.put("delayDownload", this.delayDownload);
            jSONObject.putOpt("fromWebUrl", this.fromWebUrl);
            jSONObject.putOpt("apkChannel", this.apkChannel);
            jSONObject.putOpt("via", this.via);
            jSONObject.putOpt("launch_via", this.launchVia);
            jSONObject.putOpt("scene", Integer.valueOf(this.scene));
            jSONObject.putOpt("report_data", this.reportData);
            jSONObject.put("downloadStartTime", this.yyStartTime);
            jSONObject.put("downloadEndTime", this.yyEndTime);
            jSONObject.putOpt("adtag", this.adtag);
            jSONObject.put("from", this.from);
            jSONObject.put(WadlProxyConsts.FLAGS, this.flags);
            jSONObject.putOpt(WadlProxyConsts.EXTRA_DATA, this.extraData);
            jSONObject.put("appointment_time", this.wadlParamsExt.f106733d);
            jSONObject.putOpt("sourceId", this.sourceId);
            jSONObject.put(VirtualAppProxy.KEY_PKG_SIZE, this.pkgSize);
            jSONObject.put(WadlResult.WEB_KEY_IS_RES, this.isRes);
            if (this.isRes) {
                jSONObject.putOpt(WadlProxyConsts.RES_URL, this.apkUrl);
                jSONObject.put(WadlProxyConsts.RES_INDEX, this.resIndex);
                jSONObject.putOpt("resVersionCode", this.resVersionName);
                jSONObject.putOpt("resName", this.resName);
                jSONObject.putOpt(WadlResult.WEB_KEY_RES_MD5, this.resMD5);
                jSONObject.putOpt("resDir", this.resDir);
            } else {
                jSONObject.putOpt("apkUrl", this.apkUrl);
            }
            jSONObject.put("isDirectUseDualWay", this.isDirectUseDualWay);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseToJsonStr json exception:", e16);
        }
        String jSONObject2 = jSONObject.toString();
        this.jsonParams = jSONObject2;
        return jSONObject2;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        if (parcel != null) {
            this.downloadType = parcel.readInt();
            this.actionCode = parcel.readInt();
            this.appId = parcel.readString();
            this.apkUrl = parcel.readString();
            this.apkSign = parcel.readString();
            this.versionCode = parcel.readInt();
            this.packageName = parcel.readString();
            this.appName = parcel.readString();
            this.iconUrl = parcel.readString();
            boolean z18 = false;
            if (parcel.readInt() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.delayDownload = z16;
            this.fromWebUrl = parcel.readString();
            this.apkChannel = parcel.readString();
            this.via = parcel.readString();
            this.yyStartTime = parcel.readLong();
            this.yyEndTime = parcel.readLong();
            this.adtag = parcel.readString();
            this.from = parcel.readInt();
            this.flags = parcel.readInt();
            this.extraData = parcel.readString();
            this.noticeCount = parcel.readInt();
            this.sourceId = parcel.readString();
            if (parcel.readInt() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.isRes = z17;
            this.resIndex = parcel.readInt();
            this.resVersionName = parcel.readString();
            this.resName = parcel.readString();
            this.resMD5 = parcel.readString();
            this.resType = parcel.readInt();
            this.mieActId = parcel.readLong();
            this.resDir = parcel.readString();
            this.pkgSize = parcel.readLong();
            this.ignoreSpace = parcel.readInt();
            this.channelNum = parcel.readInt();
            this.extFlags = parcel.readInt();
            if (parcel.readInt() == 1) {
                z18 = true;
            }
            this.isDualDownload = z18;
            this.sceneId = parcel.readString();
            this.scene = parcel.readInt();
            this.reportData = parcel.readString();
            this.launchVia = parcel.readString();
            this.wadlParamsExt = (WadlParamsExt) parcel.readParcelable(WadlParamsExt.class.getClassLoader());
            this.wadlParamsPageInfo = (WadlParamsPageInfo) parcel.readParcelable(WadlParamsPageInfo.class.getClassLoader());
            this.speedBuffer = parcel.readInt();
            this.isDirectUseDualWay = parcel.readInt();
            this.dualSwitch = parcel.readInt();
        }
    }

    public void removeExtFlags(int i3) {
        this.extFlags = (~i3) & this.extFlags;
    }

    public void setExtFlags(int i3) {
        this.extFlags = i3 | this.extFlags;
    }

    public void setFlagDisable(int i3) {
        this.flags = (~i3) & this.flags;
    }

    public String toString() {
        return "WadlParams{actionCode='" + this.actionCode + "', appId='" + this.appId + "', downloadType='" + this.downloadType + "', isRes='" + this.isRes + "', resType=" + this.resType + ", versionCode=" + this.versionCode + ", apkUrl='" + this.apkUrl + "', packageName='" + this.packageName + "', appName='" + this.appName + "', delayDownload=" + this.delayDownload + ", mieActId=" + this.mieActId + ", extraData='" + this.extraData + "', noticeCount='" + this.noticeCount + "', apkChannel='" + this.apkChannel + "', via='" + this.via + "', launchVia='" + this.launchVia + "', scene='" + this.scene + "', reportData='" + this.reportData + "', flags=" + this.flags + ", from=" + this.from + ", fromWebUrl=" + this.fromWebUrl + ", yyStartTime=" + this.yyStartTime + ", yyEndTime=" + this.yyEndTime + ", adtag='" + this.adtag + "', resName='" + this.resName + "', resIndex='" + this.resIndex + "', resMD5='" + this.resMD5 + "', resDir='" + this.resDir + "', pkgSize=" + this.pkgSize + ", ignoreSpace=" + this.ignoreSpace + ", channelNum=" + this.channelNum + ", isCancelRequest=" + this.isCancelRequest + ", extFlags=" + this.extFlags + ", isDualDownload=" + this.isDualDownload + ", isDirectUseDualWay=" + this.isDirectUseDualWay + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.downloadType);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.appId);
            parcel.writeString(this.apkUrl);
            parcel.writeString(this.apkSign);
            parcel.writeInt(this.versionCode);
            parcel.writeString(this.packageName);
            parcel.writeString(this.appName);
            parcel.writeString(this.iconUrl);
            parcel.writeInt(this.delayDownload ? 1 : 0);
            parcel.writeString(this.fromWebUrl);
            parcel.writeString(this.apkChannel);
            parcel.writeString(this.via);
            parcel.writeLong(this.yyStartTime);
            parcel.writeLong(this.yyEndTime);
            parcel.writeString(this.adtag);
            parcel.writeInt(this.from);
            parcel.writeInt(this.flags);
            parcel.writeString(this.extraData);
            parcel.writeInt(this.noticeCount);
            parcel.writeString(this.sourceId);
            parcel.writeInt(this.isRes ? 1 : 0);
            parcel.writeInt(this.resIndex);
            parcel.writeString(this.resVersionName);
            parcel.writeString(this.resName);
            parcel.writeString(this.resMD5);
            parcel.writeInt(this.resType);
            parcel.writeLong(this.mieActId);
            parcel.writeString(this.resDir);
            parcel.writeLong(this.pkgSize);
            parcel.writeInt(this.ignoreSpace);
            parcel.writeInt(this.channelNum);
            parcel.writeInt(this.extFlags);
            parcel.writeInt(this.isDualDownload ? 1 : 0);
            parcel.writeString(this.sceneId);
            parcel.writeInt(this.scene);
            parcel.writeString(this.reportData);
            parcel.writeString(this.launchVia);
            parcel.writeParcelable(this.wadlParamsExt, i3);
            parcel.writeParcelable(this.wadlParamsPageInfo, i3);
            parcel.writeInt(this.speedBuffer);
            parcel.writeInt(this.isDirectUseDualWay);
            parcel.writeInt(this.dualSwitch);
        }
    }

    public void setFlags(int i3) {
        this.flags = i3 | this.flags;
    }

    public WadlParams(String str, String str2) {
        this.downloadType = 1;
        this.appId = "";
        this.apkChannel = "";
        this.apkUrl = "";
        this.packageName = "";
        this.resIndex = -1;
        this.mieActId = 0L;
        this.appName = "";
        this.iconUrl = "";
        this.via = "";
        this.fromWebUrl = "";
        this.adtag = "";
        this.extraData = "";
        this.sourceId = "";
        this.sceneId = "3";
        this.isDirectUseDualWay = -1;
        this.dualSwitch = 0;
        this.wadlParamsExt = new WadlParamsExt();
        this.wadlParamsPageInfo = new WadlParamsPageInfo();
        this.appId = str == null ? "" : str;
        this.packageName = str2;
        this.flags = pbenterroom.CMD_NEW_ACCESS;
    }

    public WadlParams(String str) {
        this.downloadType = 1;
        this.appId = "";
        this.apkChannel = "";
        this.apkUrl = "";
        this.packageName = "";
        this.resIndex = -1;
        this.mieActId = 0L;
        this.appName = "";
        this.iconUrl = "";
        this.via = "";
        this.fromWebUrl = "";
        this.adtag = "";
        this.extraData = "";
        this.sourceId = "";
        this.sceneId = "3";
        this.isDirectUseDualWay = -1;
        this.dualSwitch = 0;
        this.wadlParamsExt = new WadlParamsExt();
        this.wadlParamsPageInfo = new WadlParamsPageInfo();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.jsonParams = str;
        parseFromJson(str);
    }
}
