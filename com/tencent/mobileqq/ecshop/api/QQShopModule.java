package com.tencent.mobileqq.ecshop.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.message.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\t2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/ecshop/api/QQShopModule;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "lastMsg", "", "e", "Landroid/content/Context;", "context", "msgRecord", "", "g", "", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "hasRedPoint", "qggExt", "j", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/ecshop/api/QQShopModule$a;", "listener", "i", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "f", "b", "Ljava/lang/ref/WeakReference;", "mQQShopActivityResultListener", "<init>", "()V", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QQShopModule {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQShopModule f203940a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<a> mQQShopActivityResultListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/ecshop/api/QQShopModule$a;", "", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface a {
        void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29145);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f203940a = new QQShopModule();
        }
    }

    QQShopModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(MsgRecord lastMsg) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.qqshop.message.db.a h16;
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig;
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean != null && ecshopConfBean.forbidTransFirstPageData) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("QQShopModule", 1, "getFirstDbScreenData return forbidTransFirstPageData");
            return null;
        }
        if (lastMsg != null) {
            d dVar = d.f274478a;
            if (!dVar.h(lastMsg) && !dVar.w(lastMsg)) {
                EcshopConfBean ecshopConfBean2 = EcshopConfUtil.getEcshopConfBean();
                if (ecshopConfBean2 != null && (msgTabPageConfig = ecshopConfBean2.msgTabPageConfig) != null && msgTabPageConfig.shouldDisableLastUnreadDailyMsg) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    QLog.i("QQShopModule", 1, "getFirstDbScreenData return shouldDisableLastUnreadDailyMsg");
                    return null;
                }
                if (com.tencent.mobileqq.ecshop.utils.b.f203951a.a(lastMsg.msgTime, NetConnInfoCenter.getServerTime())) {
                    com.tencent.mobileqq.qqshop.message.a aVar = com.tencent.mobileqq.qqshop.message.a.f274473a;
                    if (aVar.r() && (h16 = aVar.h()) != null) {
                        try {
                            JSONObject s16 = aVar.s(h16);
                            if (s16 == null) {
                                return null;
                            }
                            s16.put("isADDeleted", com.tencent.mobileqq.qqshop.publicaccount.c.f274574a.c(lastMsg.msgId));
                            QLog.i("QQShopModule", 1, "getFirstDbScreenData return getLastDbMsgToday");
                            return s16.toString();
                        } catch (JSONException e16) {
                            QLog.d("QQShopModule", 1, e16, new Object[0]);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final Context context, final MsgRecord msgRecord) {
        if (msgRecord == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ecshop.api.b
            @Override // java.lang.Runnable
            public final void run() {
                QQShopModule.h(MsgRecord.this, context);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MsgRecord msgRecord, Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            qq_ad_get.QQAdGetRsp.AdInfo f16 = d.f274478a.f(msgRecord);
            if (f16 != null) {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(context, new GdtAd(f16));
            }
        } catch (Throwable th5) {
            QLog.e("QQShopModule", 1, QLog.getStackTraceString(th5));
        }
    }

    public static /* synthetic */ void k(QQShopModule qQShopModule, Context context, int i3, boolean z16, String str, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        if ((i16 & 8) != 0) {
            str = "";
        }
        qQShopModule.j(context, i3, z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).requestMaskAdAndDownloadFile();
    }

    public final void f(int requestCode, int resultCode, @Nullable Intent data) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        WeakReference<a> weakReference = mQQShopActivityResultListener;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void i(@Nullable WeakReference<a> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            mQQShopActivityResultListener = listener;
        }
    }

    public final void j(@NotNull Context context, int entrance, boolean hasRedPoint, @NotNull String qggExt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(entrance), Boolean.valueOf(hasRedPoint), qggExt);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(qggExt, "qggExt");
        long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ecshop.api.a
            @Override // java.lang.Runnable
            public final void run() {
                QQShopModule.l();
            }
        }, 128, null, false);
        d.f274478a.j(new QQShopModule$startQQShop$2(qggExt, entrance, hasRedPoint, currentTimeMillis, context));
    }
}
