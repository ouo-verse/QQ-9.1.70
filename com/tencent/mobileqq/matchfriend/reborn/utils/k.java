package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/k;", "", "", "i", "Ljava/lang/Runnable;", "runnable", "", "k", "g", "showed", "l", "c", "Landroid/view/View;", "anchorView", "Lcom/tencent/biz/richframework/order/IOrderElement;", DTConstants.TAG.ELEMENT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", tl.h.F, "", "key", "d", "", "e", "entryView", "f", "j", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f245485a = new k();

    k() {
    }

    private final boolean i() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("jieban_to_nearby", false);
        QLog.i("QQStrangerNearbyEntryHelper", 1, "nearbyEntrySwitch isSwitchOn=" + isSwitchOn);
        return isSwitchOn;
    }

    private final void k(Runnable runnable) {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View view, final IOrderElement element) {
        Intrinsics.checkNotNullParameter(element, "$element");
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(view.getContext());
        r16.S(view);
        r16.o0("\u53d1\u73b0\u9644\u8fd1\u65b0\u9c9c\u4e8b");
        r16.k0(1);
        r16.R(2);
        r16.m0(3);
        r16.b0(5L);
        r16.g0(false);
        r16.s0();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.j
            @Override // java.lang.Runnable
            public final void run() {
                k.o(IOrderElement.this);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(IOrderElement element) {
        Intrinsics.checkNotNullParameter(element, "$element");
        m82.a.f416439a.b().inactivateElement(element);
    }

    public final boolean c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime2 != null ? peekAppRuntime2.getCurrentUin() : null;
        if (currentUin == null || currentUin.length() == 0) {
            QLog.e("QQStrangerNearbyEntryHelper", 1, "[canShowNearbyEntry] uin is null or empty.");
            return false;
        }
        if (!i()) {
            QLog.i("QQStrangerNearbyEntryHelper", 1, "[canShowNearbyEntry] switch off.");
            return false;
        }
        return ((INearbyProEntryService) peekAppRuntime.getRuntimeService(INearbyProEntryService.class, "")).isShowNearbyProEntry();
    }

    public final String d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    public final int e() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(d("qqstranger_nearby_entry_show_times"), 0);
    }

    public final void f(View entryView) {
        Intrinsics.checkNotNullParameter(entryView, "entryView");
        VideoReport.setElementId(entryView, "em_kl_nearby_en_icon");
        VideoReport.setElementExposePolicy(entryView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(entryView, ClickPolicy.REPORT_ALL);
    }

    public final boolean g() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(d("qqstranger_nearby_entry_merged_guide_showed"), false);
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("QQStrangerNearbyEntryHelper", 1, "jumpToNearby.");
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearbypro_main&source=2");
    }

    public final void j(View entryView) {
        Intrinsics.checkNotNullParameter(entryView, "entryView");
        VideoReport.reportEvent("dt_clck", entryView, new HashMap());
    }

    public final void l(boolean showed) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(d("qqstranger_nearby_entry_merged_guide_showed"), showed);
    }

    public final void m(final View anchorView, final IOrderElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (anchorView == null) {
            QLog.i("QQStrangerNearbyEntryHelper", 1, "[showGuideBubbleTips] anchorView is null.");
            return;
        }
        k(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                k.n(anchorView, element);
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerNearbyEntryHelper", 2, "Set has show nearby entry guide");
        }
        ScheduleManager.b(m82.a.f416439a.a(), element, null, null, 6, null);
    }
}
