package com.tencent.mobileqq.guild.setting.qrcode;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.share.GuildShareWrapper;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import vh2.at;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildQRCodeViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> {
    public static final int INIT_ERROR = 1;
    public static final int INIT_SUCCESS = 0;
    private static final String MAIN_SOURCE_KEY = "mainSourceId";
    private static final String MAIN_SOURCE_VALUE = "qr_code";
    private static final String SUB_SOURCE_KEY = "subSourceId";
    public static final int SWITCH_ERROR = 3;
    public static final int SWITCH_SUCCESS = 2;
    private static final String TAG = "Guild.share.GuildQRCodeViewModel";
    private GPServiceObserver mGPServiceObserver;
    public String mGuildId;
    public IGProGuildInfo mGuildInfo;

    @Nullable
    public IGProMedalInfo mMedalInfo;
    private MutableLiveData<PageState> mPageState;
    private String mQrCodeType;
    private MutableLiveData<IGProQRCodeShareInfo> mShareInfo;
    public String mSharerName;
    public String mTinyId;
    private MutableLiveData<IGProGuildInfo> mUpdateGuildInfo;
    private MutableLiveData<String> mUpdateQrCodeTipsStr;
    private MutableLiveData<String> mUpdateQrCodeUrl;
    private MutableLiveData<b> mUpdateType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public enum PageState {
        IDLE,
        END
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            super.onGuildInfoUpdated(str);
            if (TextUtils.equals(str, GuildQRCodeViewModel.this.mGuildId)) {
                IGProGuildInfo fetchInfo = GuildQRCodeViewModel.this.fetchInfo();
                if (fetchInfo == null) {
                    QLog.w(GuildQRCodeViewModel.TAG, 1, "onGuildInfoUpdated guildInfo is null");
                    GuildQRCodeViewModel.this.mPageState.setValue(PageState.END);
                } else {
                    GuildQRCodeViewModel guildQRCodeViewModel = GuildQRCodeViewModel.this;
                    guildQRCodeViewModel.updateValue(guildQRCodeViewModel.mUpdateGuildInfo, fetchInfo);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            super.onGuildListUpdated();
            if (((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(GuildQRCodeViewModel.this.mGuildId) == null) {
                QLog.w(GuildQRCodeViewModel.TAG, 1, "onGuildListUpdated guildInfo is null");
                GuildQRCodeViewModel.this.mPageState.setValue(PageState.END);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        Integer f234881a;

        /* renamed from: b, reason: collision with root package name */
        String f234882b;

        public b(Integer num, String str) {
            this.f234881a = num;
            this.f234882b = str;
        }
    }

    public GuildQRCodeViewModel(wy1.a aVar) {
        super(aVar);
        this.mGPServiceObserver = createObserver();
        this.mUpdateQrCodeTipsStr = new MutableLiveData<>();
        this.mUpdateQrCodeUrl = new MutableLiveData<>();
        this.mUpdateGuildInfo = new MutableLiveData<>();
        this.mUpdateType = new MutableLiveData<>();
        this.mShareInfo = new MutableLiveData<>();
        this.mPageState = new MutableLiveData<>();
    }

    private void addObserver() {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            QLog.w(TAG, 1, "appInterface is null");
        } else {
            ((IGPSService) l3.getRuntimeService(IGPSService.class, "")).addObserver(this.mGPServiceObserver);
        }
    }

    private GPServiceObserver createObserver() {
        return new a();
    }

    private IGProGuildInfo fetchGuildAndMedalInfo() {
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(this.mGuildId);
        if (guildInfo == null) {
            this.mPageState.setValue(PageState.END);
            return null;
        }
        this.mTinyId = ch.f();
        this.mSharerName = ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName(this.mGuildId, this.mTinyId);
        this.mGuildInfo = guildInfo;
        handleOfficialMedalInfo(guildInfo);
        return guildInfo;
    }

    private void fetchShareInfo() {
        if (ch.l() == null) {
            QLog.w(TAG, 1, "appInterface is null");
            return;
        }
        String str = this.mGuildId;
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "guildId is null");
        } else {
            GuildShareWrapper.g(str, "", 5, null, getUrlParams(this.mQrCodeType), new at() { // from class: com.tencent.mobileqq.guild.setting.qrcode.o
                @Override // vh2.at
                public final void a(int i3, String str2, String str3, String str4, IGProSecurityResult iGProSecurityResult, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str5) {
                    GuildQRCodeViewModel.this.lambda$fetchShareInfo$0(i3, str2, str3, str4, iGProSecurityResult, j3, iGProQRCodeShareInfo, iGProShareExtendInfo, str5);
                }
            });
        }
    }

    private int getDateDiffDays(long j3, long j16) {
        if (j3 > 0 && j16 > 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "date: " + com.tencent.mobileqq.remind.e.a(j3) + " - date2: " + com.tencent.mobileqq.remind.e.a(j16));
            }
            return (int) ((((Math.abs(j3 - j16) / 1000) / 60) / 60) / 24);
        }
        return -1;
    }

    private ArrayList<ey> getUrlParams(String str) {
        ArrayList<ey> arrayList = new ArrayList<>();
        ey eyVar = new ey();
        eyVar.c(MAIN_SOURCE_KEY);
        eyVar.d("qr_code");
        ey eyVar2 = new ey();
        eyVar2.c(SUB_SOURCE_KEY);
        eyVar2.d(str);
        ey eyVar3 = new ey();
        eyVar3.c("from");
        eyVar3.d(String.valueOf(246611));
        arrayList.add(eyVar);
        arrayList.add(eyVar2);
        arrayList.add(eyVar3);
        return arrayList;
    }

    private void handleOfficialMedalInfo(IGProGuildInfo iGProGuildInfo) {
        ArrayList<IGProMedalInfo> medalInfoList = iGProGuildInfo.getMedalInfoList();
        if (medalInfoList == null) {
            return;
        }
        Iterator<IGProMedalInfo> it = medalInfoList.iterator();
        while (it.hasNext()) {
            IGProMedalInfo next = it.next();
            if (next != null && next.getOfficialMedalInfoExt().getIsOffical() && (next.getExpireTime() == 0 || next.getExpireTime() > NetConnInfoCenter.getServerTime())) {
                this.mMedalInfo = next;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchShareInfo$0(int i3, String str, String str2, String str3, IGProSecurityResult iGProSecurityResult, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str4) {
        String str5 = "fetchShareInfo result: " + i3 + ", errMsg: " + str + ", shareUrl: " + str2 + ", shareInfo: " + str3 + "security:" + iGProSecurityResult + ", shareExpiredTime: " + j3 + "qrCodeShareInfo:" + iGProQRCodeShareInfo + ", shareExtendInfo: " + iGProShareExtendInfo;
        if (i3 == 0 && !TextUtils.isEmpty(str2) && iGProQRCodeShareInfo != null) {
            this.mUpdateType.setValue(new b(0, str));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str5);
            }
            updateQrCodeTime(j3);
            this.mUpdateQrCodeUrl.setValue(str2);
            this.mShareInfo.setValue(iGProQRCodeShareInfo);
            return;
        }
        QLog.e(TAG, 2, str5);
        this.mUpdateType.setValue(new b(1, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUrlByType$1(int i3, String str, String str2, String str3, IGProSecurityResult iGProSecurityResult, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str4) {
        String str5 = "getUrlByType result: " + i3 + ", errMsg: " + str + ", shareUrl: " + str2 + ", shareInfo: " + str3 + "security:" + iGProSecurityResult + ", shareExpiredTime: " + j3 + "qrCodeShareInfo:" + iGProQRCodeShareInfo + ", shareExtendInfo: " + iGProShareExtendInfo;
        if (i3 == 0 && !TextUtils.isEmpty(str2) && iGProQRCodeShareInfo != null) {
            this.mUpdateType.setValue(new b(2, str));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str5);
            }
            this.mUpdateQrCodeUrl.setValue(str2);
            return;
        }
        QLog.e(TAG, 2, str5);
        this.mUpdateType.setValue(new b(3, str));
    }

    private void removeObserver() {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            QLog.w(TAG, 1, "appInterface is null");
        } else {
            ((IGPSService) l3.getRuntimeService(IGPSService.class, "")).deleteObserver(this.mGPServiceObserver);
        }
    }

    private void updateQrCodeTime(long j3) {
        String format;
        if (j3 <= 0) {
            return;
        }
        long j16 = 1000 * j3;
        int dateDiffDays = getDateDiffDays(j16, NetConnInfoCenter.getServerTimeMillis());
        if (dateDiffDays <= -1) {
            QLog.i(TAG, 1, "updateQrCodeTime diffDays time:" + j3);
            return;
        }
        if (dateDiffDays <= 1) {
            format = String.format("24\u5c0f\u65f6\u5185\uff08%s\u524d\uff09\u6709\u6548", en.o(j16, "M\u6708d\u65e5HH\u65f6"));
        } else if (dateDiffDays > 30) {
            format = "";
        } else {
            format = String.format("%d\u5929\u5185\uff08%s\u524d\uff09\u6709\u6548", Integer.valueOf(dateDiffDays), en.o(j16, "M\u6708d\u65e5"));
        }
        this.mUpdateQrCodeTipsStr.setValue(format);
    }

    public IGProGuildInfo fetchInfo() {
        fetchShareInfo();
        return fetchGuildAndMedalInfo();
    }

    public MutableLiveData<PageState> getPageState() {
        return this.mPageState;
    }

    public MutableLiveData<IGProQRCodeShareInfo> getShareInfo() {
        return this.mShareInfo;
    }

    public MutableLiveData<IGProGuildInfo> getUpdateGuildInfo() {
        return this.mUpdateGuildInfo;
    }

    public MutableLiveData<String> getUpdateQrCodeTipStr() {
        return this.mUpdateQrCodeTipsStr;
    }

    public MutableLiveData<String> getUpdateQrCodeUrl() {
        return this.mUpdateQrCodeUrl;
    }

    public MutableLiveData<b> getUpdateType() {
        return this.mUpdateType;
    }

    @SuppressLint({"DefaultLocale"})
    public void init(String str, String str2) {
        this.mGuildId = str;
        this.mQrCodeType = str2;
        addObserver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeObserver();
    }

    public void updateUrlByType(String str) {
        this.mQrCodeType = str;
        GuildShareWrapper.g(this.mGuildId, "", 5, null, getUrlParams(str), new at() { // from class: com.tencent.mobileqq.guild.setting.qrcode.p
            @Override // vh2.at
            public final void a(int i3, String str2, String str3, String str4, IGProSecurityResult iGProSecurityResult, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str5) {
                GuildQRCodeViewModel.this.lambda$updateUrlByType$1(i3, str2, str3, str4, iGProSecurityResult, j3, iGProQRCodeShareInfo, iGProShareExtendInfo, str5);
            }
        });
    }
}
