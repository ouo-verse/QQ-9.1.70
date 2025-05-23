package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameNoticeInfo implements Cloneable, Parcelable {
    public static final Parcelable.Creator<GameNoticeInfo> CREATOR = new a();
    public long C;
    public int D;
    public String E;
    public int F;
    public long G;
    public String H;
    public String I;
    public long J;
    public long K;
    public long L;

    /* renamed from: d, reason: collision with root package name */
    public String f106722d;

    /* renamed from: e, reason: collision with root package name */
    public String f106723e;

    /* renamed from: f, reason: collision with root package name */
    public String f106724f;

    /* renamed from: h, reason: collision with root package name */
    public int f106725h;

    /* renamed from: i, reason: collision with root package name */
    public String f106726i;

    /* renamed from: m, reason: collision with root package name */
    public String f106727m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<GameNoticeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameNoticeInfo createFromParcel(Parcel parcel) {
            GameNoticeInfo gameNoticeInfo = new GameNoticeInfo();
            gameNoticeInfo.k(parcel);
            return gameNoticeInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameNoticeInfo[] newArray(int i3) {
            return new GameNoticeInfo[i3];
        }
    }

    public GameNoticeInfo() {
        this.f106722d = "";
    }

    public static int b(WadlResult wadlResult) {
        if (wadlResult.taskStatus == 6 && FileUtils.fileExists(wadlResult.downloadFilePath)) {
            return 1;
        }
        if (wadlResult.taskStatus == 5) {
            return 3;
        }
        return 0;
    }

    private IQQGameDownloadService c() {
        return (IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
    }

    private boolean f() {
        IQQGameDownloadService c16 = c();
        if (c16 != null) {
            return c16.isApkFileExpire(this.f106722d, this.f106727m);
        }
        return true;
    }

    public static void l(GameNoticeInfo gameNoticeInfo, GameNoticeInfo gameNoticeInfo2) {
        if (gameNoticeInfo != null && gameNoticeInfo2 != null) {
            gameNoticeInfo.f106722d = gameNoticeInfo2.f106722d;
            gameNoticeInfo.f106724f = gameNoticeInfo2.f106724f;
            gameNoticeInfo.f106725h = gameNoticeInfo2.f106725h;
            gameNoticeInfo.f106726i = gameNoticeInfo2.f106726i;
            gameNoticeInfo.f106723e = gameNoticeInfo2.f106723e;
            gameNoticeInfo.f106727m = gameNoticeInfo2.f106727m;
            gameNoticeInfo.F = gameNoticeInfo2.F;
            gameNoticeInfo.H = gameNoticeInfo2.H;
            gameNoticeInfo.J = gameNoticeInfo2.J;
            gameNoticeInfo.K = gameNoticeInfo2.K;
            gameNoticeInfo.C = gameNoticeInfo2.C;
            gameNoticeInfo.E = gameNoticeInfo2.E;
            gameNoticeInfo.D = gameNoticeInfo2.D;
            gameNoticeInfo.L = gameNoticeInfo2.L;
            gameNoticeInfo.G = gameNoticeInfo2.G;
        }
    }

    private void m() {
        String str;
        if (!TextUtils.isEmpty(this.f106727m)) {
            File file = new File(this.f106727m);
            if (file.exists()) {
                this.L = file.lastModified();
                i nextTipsInfo = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getNextTipsInfo(this, true);
                if (nextTipsInfo != null) {
                    long j3 = this.L;
                    this.J = nextTipsInfo.f106833a + j3;
                    this.K = j3 + nextTipsInfo.f106834b;
                    this.H = nextTipsInfo.f106835c;
                } else {
                    long j16 = this.L;
                    this.J = MiniBoxNoticeInfo.MIN_5 + j16;
                    this.K = j16 + MiniBoxNoticeInfo.HOUR_8;
                    this.H = com.tencent.open.adapter.a.f().e().getString(R.string.mwz, this.f106723e);
                }
                this.I = WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME;
                g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                if (gVar != null) {
                    str = gVar.b(this.D);
                } else {
                    int i3 = this.D;
                    if (i3 == 1) {
                        str = com.tencent.open.adapter.a.f().e().getString(R.string.f171122mw);
                    } else if (i3 == 3) {
                        str = com.tencent.open.adapter.a.f().e().getString(R.string.f171132mx);
                    } else {
                        str = null;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    this.H = str + this.H;
                }
            }
        }
        QLog.d("Wadl_GameNoticeInfo", 1, "setInstallTipsInfo this=" + this);
    }

    private void n() {
        long j3 = this.C;
        this.L = j3;
        if (j3 > 0) {
            i nextTipsInfo = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getNextTipsInfo(this, true);
            if (nextTipsInfo != null) {
                long j16 = this.L;
                this.J = nextTipsInfo.f106833a + j16;
                this.K = j16 + nextTipsInfo.f106834b;
                this.H = nextTipsInfo.f106835c;
            } else {
                long j17 = this.L;
                this.J = MiniBoxNoticeInfo.MIN_5 + j17;
                this.K = j17 + MiniBoxNoticeInfo.HOUR_8;
                this.H = com.tencent.open.adapter.a.f().e().getString(R.string.f209855gj, this.f106723e);
            }
            this.I = WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME;
        }
        QLog.d("Wadl_GameNoticeInfo", 1, "setPauseTipsInfo this=" + this);
    }

    public int a() {
        if (!TextUtils.isEmpty(this.f106722d) && this.F != 0 && this.J >= 1 && this.K >= 1 && !TextUtils.isEmpty(this.H)) {
            if (this.K < NetConnInfoCenter.getServerTimeMillis()) {
                QLog.w("Wadl_GameNoticeInfo", 1, "checkStatus bannerType=" + this.F + " time expired");
                return 1;
            }
            int i3 = this.F;
            if (i3 == 1) {
                if (!GameCenterUtil.fileExists(this.f106727m)) {
                    QLog.w("Wadl_GameNoticeInfo", 1, "checkStatus file not exists, filePath=" + this.f106727m);
                    return -1;
                }
                com.tencent.gamecenter.wadl.biz.entity.a installInfo = GameCenterUtil.getInstallInfo(this.f106722d, this.f106724f);
                if (installInfo.f106749d && installInfo.f106751f > 0) {
                    boolean f16 = f();
                    QLog.d("Wadl_GameNoticeInfo", 1, "checkStatus installVersion=" + installInfo.f106751f + ",versionCode=" + this.f106725h + ",isTaskExpire=" + f16);
                    if (!f16 && this.f106725h >= installInfo.f106751f) {
                        try {
                            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
                            if (TextUtils.isEmpty(loadAsString) || new JSONObject(loadAsString).optInt("hulianIgnoreCheckSwitch", 1) == 1) {
                                f queryFullPkgTask = c().queryFullPkgTask(this.f106724f);
                                QLog.d("Wadl_GameNoticeInfo", 1, "checkStatus wadlBaseTask=" + queryFullPkgTask);
                                if (queryFullPkgTask != null && (queryFullPkgTask.flags & 1048576) == 1048576) {
                                    QLog.d("Wadl_GameNoticeInfo", 1, "checkStatus is from hulian ,just ignore");
                                    return 0;
                                }
                            }
                        } catch (Throwable th5) {
                            QLog.e("Wadl_GameNoticeInfo", 1, th5, new Object[0]);
                        }
                        if (this.f106725h > installInfo.f106751f) {
                            return 0;
                        }
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).checkInstallChannel(4, 0, this.f106722d, this.f106724f, installInfo.f106748c);
                    } else {
                        IQQGameDownloadService c16 = c();
                        if (c16 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("actionFrom", 9);
                            c16.doAppSystemReceiver(WadlProxyConsts.REMOTE_CMD_APP_INSTALLED, this.f106724f, bundle);
                        }
                        return -1;
                    }
                }
                return 0;
            }
            if (i3 == 3) {
                return 0;
            }
        }
        return -1;
    }

    public Object clone() {
        GameNoticeInfo gameNoticeInfo;
        try {
            gameNoticeInfo = (GameNoticeInfo) super.clone();
        } catch (CloneNotSupportedException e16) {
            QLog.e("Wadl_GameNoticeInfo", 1, "clone exception", e16);
            gameNoticeInfo = null;
        }
        l(gameNoticeInfo, this);
        return gameNoticeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        int i3 = this.D;
        if (i3 == 1) {
            return "2";
        }
        if (i3 == 3) {
            return "1";
        }
        return "0";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GameNoticeInfo gameNoticeInfo = (GameNoticeInfo) obj;
            if (this.F == gameNoticeInfo.F && this.C == gameNoticeInfo.C) {
                return this.f106722d.equals(gameNoticeInfo.f106722d);
            }
        }
        return false;
    }

    public boolean j() {
        i nextTipsInfo = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getNextTipsInfo(this, true);
        if (nextTipsInfo != null) {
            long j3 = this.L;
            this.J = nextTipsInfo.f106833a + j3;
            this.K = j3 + nextTipsInfo.f106834b;
            QLog.w("Wadl_GameNoticeInfo", 1, "optUpdate success, this=" + this);
            return true;
        }
        return false;
    }

    public void k(Parcel parcel) {
        if (parcel != null) {
            this.f106722d = parcel.readString();
            this.f106724f = parcel.readString();
            this.f106725h = parcel.readInt();
            this.f106726i = parcel.readString();
            this.f106723e = parcel.readString();
            this.f106727m = parcel.readString();
            this.F = parcel.readInt();
            this.H = parcel.readString();
            this.I = parcel.readString();
            this.J = parcel.readLong();
            this.K = parcel.readLong();
            this.C = parcel.readLong();
            this.D = parcel.readInt();
            this.E = parcel.readString();
            this.L = parcel.readLong();
            this.G = parcel.readLong();
        }
    }

    public void o() {
        int i3 = this.F;
        if (i3 == 0) {
            return;
        }
        if (i3 == 3) {
            n();
        } else if (i3 == 1) {
            m();
        }
    }

    public String p() {
        return "GameNoticeInfo {bannerType=" + this.F + ",appId=" + this.f106722d + ",startTime=" + this.J + ",endTime=" + this.K + "}";
    }

    public String toString() {
        return "GameNoticeInfo {bannerType=" + this.F + ",appId=" + this.f106722d + ",startTime=" + this.J + ",endTime=" + this.K + ",packageName=" + this.f106724f + ",appName=" + this.f106723e + ",createTime=" + this.C + ",baseTime=" + this.L + ",downloadType=" + this.D + ",title=" + this.H + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeString(this.f106722d);
            parcel.writeString(this.f106724f);
            parcel.writeInt(this.f106725h);
            parcel.writeString(this.f106726i);
            parcel.writeString(this.f106723e);
            parcel.writeString(this.f106727m);
            parcel.writeInt(this.F);
            parcel.writeString(this.H);
            parcel.writeString(this.I);
            parcel.writeLong(this.J);
            parcel.writeLong(this.K);
            parcel.writeLong(this.C);
            parcel.writeInt(this.D);
            parcel.writeString(this.E);
            parcel.writeLong(this.L);
            parcel.writeLong(this.G);
        }
    }

    public GameNoticeInfo(WadlResult wadlResult) {
        this.f106722d = "";
        WadlParams wadlParams = wadlResult.wadlParams;
        this.f106722d = wadlParams.appId;
        this.f106723e = wadlParams.appName;
        this.f106724f = wadlParams.packageName;
        this.f106725h = wadlParams.versionCode;
        this.f106726i = wadlParams.apkChannel;
        this.f106727m = wadlResult.downloadFilePath;
        this.C = wadlResult.createTime;
        this.D = wadlParams.from;
        this.E = wadlParams.iconUrl;
        this.F = b(wadlResult);
        o();
    }
}
