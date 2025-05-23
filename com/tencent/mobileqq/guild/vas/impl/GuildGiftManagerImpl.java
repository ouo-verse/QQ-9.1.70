package com.tencent.mobileqq.guild.vas.impl;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.r;
import com.tencent.mobileqq.guild.t;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.guild.vas.panel.GiftPanelController;
import com.tencent.mobileqq.guild.vas.panel.GiftPanelControllerV2;
import com.tencent.mobileqq.guild.vas.panel.b;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import k12.c;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildGiftManagerImpl implements IGuildGiftManager, t {
    private static final String TAG = "GuildGiftManager";
    private final c mGiftDataController;
    private r mGiftPanelAction;
    private WeakReference<com.tencent.mobileqq.guild.vas.panel.b> mPanelController;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements b.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.vas.panel.b.a
        public void a() {
            GuildGiftManagerImpl.this.mGiftDataController.d("");
        }
    }

    public GuildGiftManagerImpl() {
        initPanelController();
        this.mGiftDataController = new k12.a(this);
    }

    public static IGProChannelInfo getChannelInfo(String str, String str2) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        return ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
    }

    private com.tencent.mobileqq.guild.vas.panel.b getPanelController() {
        com.tencent.mobileqq.guild.vas.panel.b bVar = this.mPanelController.get();
        if (bVar != null) {
            return bVar;
        }
        initPanelController();
        return this.mPanelController.get();
    }

    private void initPanelController() {
        WeakReference<com.tencent.mobileqq.guild.vas.panel.b> weakReference = this.mPanelController;
        if (weakReference == null || weakReference.get() == null) {
            if (newPanelEnable()) {
                this.mPanelController = new WeakReference<>(new GiftPanelControllerV2(this));
            } else {
                this.mPanelController = new WeakReference<>(new GiftPanelController(this));
            }
        }
    }

    private static boolean isGuest(String str) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return ((IGPSService) ((QQAppInterface) runtime).getRuntimeService(IGPSService.class)).isGuest(str);
        }
        return false;
    }

    private boolean newPanelEnable() {
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            return false;
        }
        return ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_guild_gift_panel", true);
    }

    @Override // com.tencent.mobileqq.guild.t
    public void closeGiftPanel() {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.a();
    }

    @Override // com.tencent.mobileqq.guild.t
    public void getCoins() {
        if (newPanelEnable()) {
            return;
        }
        this.mGiftDataController.getCoins();
    }

    @Override // com.tencent.mobileqq.guild.t
    public r getGiftPanelAction() {
        return this.mGiftPanelAction;
    }

    @Override // com.tencent.mobileqq.guild.t
    public com.tencent.mobileqq.qqgift.data.service.c getGiftSendReq(long j3, int i3) {
        return this.mGiftDataController.a(j3, i3);
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void hideGiftPanel() {
        closeGiftPanel();
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void initGiftPanel(com.tencent.aio.api.runtime.a aVar, ActivityResultCallback<ActivityResult> activityResultCallback) {
        ((IGuildGiftManager) QRoute.api(IGuildGiftManager.class)).setGiftPanelAction(new a(aVar.g().r().c().f(), aVar.g().r().c().j(), new WeakReference(aVar), activityResultCallback));
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void onFreeGiftCountDownEnd() {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.onFreeGiftCountDownEnd();
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void onFreeGiftCountDownStart() {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.onFreeGiftCountDownStart();
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void preLoadGiftData(String str) {
        if (!newPanelEnable()) {
            this.mGiftDataController.preLoadGiftData("");
            this.mGiftDataController.getCoins();
        } else {
            com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
            if (panelController == null) {
                return;
            }
            panelController.b();
        }
    }

    @Override // com.tencent.mobileqq.guild.t
    public void sendGift(long j3, int i3, int i16) {
        if (newPanelEnable()) {
            return;
        }
        this.mGiftDataController.sendGift(j3, i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void setGiftPanelAction(r rVar) {
        this.mGiftPanelAction = rVar;
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void setReceiverInfo(String str, String str2, Drawable drawable) {
        String guildId = this.mGiftPanelAction.getGuildId();
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.d(guildId, str, str2, drawable);
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void showGiftPanel(Activity activity) {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        if (!newPanelEnable()) {
            this.mGiftDataController.preLoadGiftData("");
            panelController.g(activity, this.mGiftDataController.b(""), new b(), this.mGiftDataController.c());
        } else {
            panelController.g(activity, null, null, 0L);
        }
    }

    @Override // com.tencent.mobileqq.guild.t
    public void toRechargePanel(String str) {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.toRechargePanel(str);
    }

    @Override // com.tencent.mobileqq.guild.t
    public void toastSendError() {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.toastSendError();
    }

    @Override // com.tencent.mobileqq.guild.t
    public void updateCoins(long j3, String str) {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController == null) {
            return;
        }
        panelController.updateCoins(j3, str);
    }

    @Override // com.tencent.mobileqq.guild.t
    public void updateGiftPanel(List list) {
        com.tencent.mobileqq.guild.vas.panel.b panelController = getPanelController();
        if (panelController != null) {
            panelController.updateGiftPanel(list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f235712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f235713b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f235714c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActivityResultCallback f235715d;

        a(String str, String str2, WeakReference weakReference, ActivityResultCallback activityResultCallback) {
            this.f235712a = str;
            this.f235713b = str2;
            this.f235714c = weakReference;
            this.f235715d = activityResultCallback;
        }

        @Override // com.tencent.mobileqq.guild.r
        public long a() {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!(runtime instanceof QQAppInterface)) {
                return 0L;
            }
            String selfTinyId = ((IGPSService) ((QQAppInterface) runtime).getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (TextUtils.isEmpty(selfTinyId) || Long.decode(selfTinyId) == null) {
                return 0L;
            }
            return Long.decode(selfTinyId).longValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.r
        public void b() {
            com.tencent.aio.api.runtime.a aVar;
            try {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if ((runtime instanceof QQAppInterface) && (aVar = (com.tencent.aio.api.runtime.a) this.f235714c.get()) != null) {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openSingleMemberSelector(aVar.c().getActivity(), (QQAppInterface) runtime, this.f235712a, this.f235713b, 30000, aVar.f(), this.f235715d);
                }
            } catch (Exception e16) {
                QLog.e(GuildGiftManagerImpl.TAG, 2, "open select panel error", e16);
            }
        }

        @Override // com.tencent.mobileqq.guild.r
        public String c() {
            try {
                return VasSkey.getPSkey(BaseApplicationImpl.getApplication().getRuntime(), "qzone.qq.com");
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }

        @Override // com.tencent.mobileqq.guild.r
        public int getChannelType() {
            IGProChannelInfo channelInfo = GuildGiftManagerImpl.getChannelInfo(this.f235712a, this.f235713b);
            if (channelInfo == null) {
                return 0;
            }
            return channelInfo.getType();
        }

        @Override // com.tencent.mobileqq.guild.r
        public String getGuildId() {
            try {
                if (TextUtils.isEmpty(this.f235712a)) {
                    return "0";
                }
                return this.f235712a;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e(GuildGiftManagerImpl.TAG, 2, e16.getMessage());
                return "0";
            }
        }

        @Override // com.tencent.mobileqq.guild.r
        public int isNightMode() {
            return ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()) ? 1 : 0;
        }

        @Override // com.tencent.mobileqq.guild.r
        public long getChannelId() {
            try {
                if (Long.decode(this.f235713b) == null) {
                    return 0L;
                }
                return Long.decode(this.f235713b).longValue();
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e(GuildGiftManagerImpl.TAG, 2, e16.getMessage());
                return 0L;
            }
        }

        @Override // com.tencent.mobileqq.guild.r
        public long getGroupId() {
            try {
                if (!TextUtils.isEmpty(this.f235712a) && Long.decode(this.f235712a) != null) {
                    return Long.decode(this.f235712a).longValue();
                }
                return 0L;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e(GuildGiftManagerImpl.TAG, 2, e16.getMessage());
                return 0L;
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void playGiftAnim() {
    }

    @Override // com.tencent.mobileqq.guild.vas.IGuildGiftManager
    public void stopGiftAnim() {
    }
}
