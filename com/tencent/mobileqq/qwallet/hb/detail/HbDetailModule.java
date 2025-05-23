package com.tencent.mobileqq.qwallet.hb.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.tenpay.sdk.activity.HbDetailActivity;
import com.tenpay.sdk.util.HBUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J*\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u0007R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbDetailModule;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "finish", "", "k", "isDefaultSkin", "i", "j", "f", DomainData.DOMAIN_NAME, "", "skinId", "", "outerSkinId", "skinFrom", "Landroid/os/ResultReceiver;", "callback", "g", "action", "r2", "r3", "r5", "l", "b", "Z", "isEnteringDetail", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbDetailModule {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HbDetailModule f277296a = new HbDetailModule();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnteringDetail;

    HbDetailModule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.finish();
        }
    }

    private final void g(final int skinId, final String outerSkinId, final int skinFrom, final ResultReceiver callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.w
            @Override // java.lang.Runnable
            public final void run() {
                HbDetailModule.h(skinId, outerSkinId, skinFrom, callback);
            }
        }, 160, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str, int i16, ResultReceiver callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((IHbSkinApi) QRoute.apiIPCSync(IHbSkinApi.class)).ipcGetSkinType(i3, str, i16, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Context context, Intent intent, boolean isDefaultSkin) {
        Integer supportNTCompose;
        boolean isGuildAIO = ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isGuildAIO(intent.getStringExtra("grouptype"));
        int i3 = -1;
        try {
            String stringExtra = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            if (stringExtra != null) {
                i3 = Integer.parseInt(stringExtra);
            }
        } catch (NumberFormatException unused) {
        }
        boolean isHbForFaceToFace = HBUtil.isHbForFaceToFace(i3);
        QWalletDetailNTComposeConfig qWalletDetailNTComposeConfig = (QWalletDetailNTComposeConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_ENABLE_COMPOSE_DEFAULT_SKIN_HB_DETAIL, QWalletDetailNTComposeConfig.INSTANCE.a());
        QLog.d("HbDetailModule", 2, "launchDefaultSkinHbDetail, isDefaultSkin=" + isDefaultSkin + ", isGuildAIO=" + isGuildAIO + ", isFace2Face=" + isHbForFaceToFace + " config=" + qWalletDetailNTComposeConfig);
        if (isDefaultSkin && !isGuildAIO && !isHbForFaceToFace && (supportNTCompose = qWalletDetailNTComposeConfig.getSupportNTCompose()) != null && supportNTCompose.intValue() == 1) {
            j(context, intent);
            return;
        }
        Integer switchHbDetailFragment = qWalletDetailNTComposeConfig.getSwitchHbDetailFragment();
        if (switchHbDetailFragment != null && switchHbDetailFragment.intValue() == 1) {
            com.tencent.mobileqq.base.c.f(context, intent, HbDetailFragment.class, false, 8, null);
        } else {
            com.tencent.mobileqq.base.c.f(context, intent, HbDetailActivity.class, false, 8, null);
        }
    }

    private final void j(Context context, Intent intent) {
        QLog.d("HbDetailModule", 2, "openHbDetail: final detail class NtCompose HbDetailPager");
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listId", intent.getStringExtra("listid"));
        jSONObject.put("authKey", intent.getStringExtra("authkey"));
        jSONObject.put(NotifyMsgApiImpl.KEY_GROUP_TYPE, intent.getStringExtra("grouptype"));
        jSONObject.put("groupId", intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
        Unit unit = Unit.INSTANCE;
        bundle.putString("HbDetailStartupData", jSONObject.toString());
        bundle.putString("page_name", "qwallet_hb_detail");
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, bundle);
    }

    @JvmStatic
    public static final void k(@Nullable final Context context, @NotNull final Intent intent, final boolean finish) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (context == null) {
            return;
        }
        if (isEnteringDetail) {
            QLog.w("HbDetailModule", 1, "[openHbDetail] ignored: is entering!");
            return;
        }
        HbDetailModule hbDetailModule = f277296a;
        hbDetailModule.n();
        int intExtra = intent.getIntExtra("skin_id", -1);
        String stringExtra = intent.getStringExtra("outer_skin_id");
        int intExtra2 = intent.getIntExtra("skin_from", 0);
        final boolean isDefaultRedPocketSkin = ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isDefaultRedPocketSkin(intExtra, stringExtra, intExtra2);
        if (!((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isValidRedPocketSkin(intExtra, stringExtra, intExtra2)) {
            hbDetailModule.i(context, intent, isDefaultRedPocketSkin);
            isEnteringDetail = false;
            if (finish) {
                hbDetailModule.f(context);
                return;
            }
            return;
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        hbDetailModule.g(intExtra, stringExtra, intExtra2, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule$openHbDetail$skinTypeCallback$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                int i3 = resultData.getInt("skin_type");
                if (resultCode != 0 || !((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isSupportSkinStory(i3)) {
                    HbDetailModule.f277296a.i(context, intent, isDefaultRedPocketSkin);
                } else {
                    QLog.d("HbDetailModule", 2, "openHbDetail: skinType " + i3 + ", final detail class HbDetailFragment");
                    com.tencent.mobileqq.base.c.f(context, intent, HbDetailFragment.class, false, 8, null);
                }
                HbDetailModule.isEnteringDetail = false;
                if (finish) {
                    HbDetailModule.f277296a.f(context);
                }
            }
        });
    }

    @JvmStatic
    public static final void l(@NotNull String action, @NotNull String r26, @NotNull String r36, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r56, "r5");
        com.tencent.mobileqq.qwallet.c.e(action, r26, r36, "", r56);
    }

    public static /* synthetic */ void m(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        l(str, str2, str3, str4);
    }

    private final void n() {
        isEnteringDetail = true;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.x
            @Override // java.lang.Runnable
            public final void run() {
                HbDetailModule.o();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        isEnteringDetail = false;
    }
}
