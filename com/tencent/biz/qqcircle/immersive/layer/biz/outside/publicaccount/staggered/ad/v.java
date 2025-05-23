package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderProxy;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/v;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "j", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, tl.h.F, "Lcom/tencent/mobileqq/vas/adv/api/MaskAdDisappearListener;", "disappearListener", "g", "f", "d", "e", "c", "()Ljava/lang/Boolean;", ViewStickEventHelper.IS_SHOW, "k", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;", "getMMaskProxy", "()Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;", "setMMaskProxy", "(Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;)V", "mMaskProxy", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f86780a = new v();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MaskAdRenderProxy mMaskProxy;

    v() {
    }

    private final boolean b(GdtAd ad5) {
        return uq3.k.a().i("exposedAidSet", new LinkedHashSet()).contains(ad5.getTraceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "$container");
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.startShow(container);
        }
    }

    private final void j(GdtAd ad5) {
        Set<String> i3 = uq3.k.a().i("exposedAidSet", new LinkedHashSet());
        i3.add(ad5.getTraceId());
        uq3.k.a().q("exposedAidSet", i3);
    }

    @Nullable
    public final Boolean c() {
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            return Boolean.valueOf(maskAdRenderProxy.getMIsShowing());
        }
        return null;
    }

    public final void d() {
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onPause();
        }
    }

    public final void e() {
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onDestroy();
        }
    }

    public final void f() {
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onResume();
        }
    }

    public final void g(@NotNull MaskAdDisappearListener disappearListener) {
        Intrinsics.checkNotNullParameter(disappearListener, "disappearListener");
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.setDisappearListener(disappearListener);
        }
    }

    public final void h(@Nullable Activity activity, @NotNull final ViewGroup container, @Nullable GdtAd ad5) {
        boolean z16;
        MaskAdRenderProxy maskAdRenderProxy;
        Intrinsics.checkNotNullParameter(container, "container");
        boolean z17 = true;
        if (com.tencent.biz.qqcircle.immersive.feed.ad.u.h(ad5) && ad5 != null) {
            if (b(ad5)) {
                QLog.e("QFSPublicAdMaskWorker", 1, "ad has exposed, traceid is " + ad5.getTraceId());
                return;
            }
            if (activity != null) {
                MaskAdRenderProxy maskAdRenderProxy2 = mMaskProxy;
                if (maskAdRenderProxy2 != null && maskAdRenderProxy2.getMIsShowing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.e("QFSPublicAdMaskWorker", 1, "ad is show, cancel show");
                    MaskAdRenderProxy maskAdRenderProxy3 = mMaskProxy;
                    if (maskAdRenderProxy3 != null) {
                        maskAdRenderProxy3.updateShowState(false);
                        return;
                    }
                    return;
                }
                ArrayList<JSONObject> maskAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.QFS_PUB);
                if (maskAdInfoList == null || true != (!maskAdInfoList.isEmpty())) {
                    z17 = false;
                }
                String str = "";
                if (z17) {
                    Iterator<JSONObject> it = maskAdInfoList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        JSONObject next = it.next();
                        if (next.optLong("aid", 0L) == ad5.getAId()) {
                            str = next.optString(AdHippyFragment.RES_PATH, "");
                            Intrinsics.checkNotNullExpressionValue(str, "json.optString(AdHippyFragment.RES_PATH, \"\")");
                            break;
                        }
                    }
                }
                qq_ad_get.QQAdGetRsp.AdInfo it22 = ad5.info;
                if (it22 != null) {
                    MaskAdvName maskAdvName = MaskAdvName.QFS_PUB;
                    Intrinsics.checkNotNullExpressionValue(it22, "it2");
                    maskAdRenderProxy = new MaskAdRenderProxy(activity, maskAdvName, str, it22);
                } else {
                    maskAdRenderProxy = null;
                }
                mMaskProxy = maskAdRenderProxy;
                if (maskAdRenderProxy != null) {
                    maskAdRenderProxy.setIsTianShuAd(false);
                }
                f86780a.j(ad5);
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.i(container);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("QFSPublicAdMaskWorker", 1, "not mask ad, cancel show");
    }

    public final void k(boolean isShow) {
        MaskAdRenderProxy maskAdRenderProxy = mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.updateShowState(isShow);
        }
    }
}
