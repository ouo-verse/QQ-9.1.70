package com.tencent.mobileqq.zplan.nameplate;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.NameplateClickJumpTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/ZPlanNameplateManager;", "Lcom/tencent/mobileqq/zplan/nameplate/a;", "Lcom/tencent/mobileqq/zplan/nameplate/c;", "data", "", "d", "Lcom/tencent/mobileqq/zplan/nameplate/d;", "params", "a", "Lmqq/util/WeakReference;", "Landroid/widget/RelativeLayout;", "Lmqq/util/WeakReference;", "containerRef", "", "Lcom/tencent/image/URLImageView;", "b", "Ljava/util/List;", "views", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lmqq/util/WeakReference;)V", ParseCommon.CONTAINER, "(Landroid/widget/RelativeLayout;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanNameplateManager implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<RelativeLayout> containerRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<URLImageView> views;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    public ZPlanNameplateManager(WeakReference<RelativeLayout> containerRef) {
        Intrinsics.checkNotNullParameter(containerRef, "containerRef");
        this.containerRef = containerRef;
        this.views = new ArrayList();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        this.scope = f16;
        if (f16 == null) {
            QLog.e("ZPlanNameplateManager", 1, "\u83b7\u53d6NET Scope\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(Nameplates data) {
        Map mutableMapOf;
        URLImageView uRLImageView;
        int lastIndex;
        Iterator<T> it = this.views.iterator();
        while (it.hasNext()) {
            ((URLImageView) it.next()).setVisibility(8);
        }
        int i3 = 0;
        for (Object obj : data.a()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final Nameplate nameplate = (Nameplate) obj;
            List<URLImageView> list = this.views;
            if (i3 >= 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
                if (i3 <= lastIndex) {
                    uRLImageView = list.get(i3);
                    final URLImageView uRLImageView2 = uRLImageView;
                    String file = nameplate.getIcon().toString();
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = new ColorDrawable(0);
                    Unit unit = Unit.INSTANCE;
                    uRLImageView2.setImageDrawable(URLDrawable.getFileDrawable(file, obtain));
                    uRLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nameplate.h
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ZPlanNameplateManager.e(Nameplate.this, uRLImageView2, view);
                        }
                    });
                    uRLImageView2.setVisibility(0);
                    if (i3 != this.views.size()) {
                        this.views.add(uRLImageView2);
                    }
                    i3 = i16;
                }
            }
            RelativeLayout relativeLayout = this.containerRef.get();
            if (relativeLayout == null) {
                i3 = i16;
            } else {
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "containerRef.get() ?: return@forEachIndexed");
                URLImageView uRLImageView3 = new URLImageView(relativeLayout.getContext());
                kotlin.g gVar = kotlin.g.f433789a;
                Resources resources = uRLImageView3.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                int b16 = gVar.b(60.0f, resources);
                Resources resources2 = uRLImageView3.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
                uRLImageView3.setLayoutParams(new RelativeLayout.LayoutParams(b16, gVar.b(23.0f, resources2)));
                relativeLayout.addView(uRLImageView3);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, "2"), TuplesKt.to(ProfileCardDtReportUtil.DT_REPORT_ZPLAN_NAMEPLATE_TYPE, String.valueOf(nameplate.getId())));
                ProfileCardDtReportUtil.initElementWithExposureClickAndParams(uRLImageView3, ProfileCardDtReportUtil.DT_REPORT_NAMEPLATE, mutableMapOf);
                VideoReport.setElementEndExposePolicy(uRLImageView3, EndExposurePolicy.REPORT_ALL);
                uRLImageView = uRLImageView3;
                final URLImageView uRLImageView22 = uRLImageView;
                String file2 = nameplate.getIcon().toString();
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mLoadingDrawable = new ColorDrawable(0);
                Unit unit2 = Unit.INSTANCE;
                uRLImageView22.setImageDrawable(URLDrawable.getFileDrawable(file2, obtain2));
                uRLImageView22.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nameplate.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanNameplateManager.e(Nameplate.this, uRLImageView22, view);
                    }
                });
                uRLImageView22.setVisibility(0);
                if (i3 != this.views.size()) {
                }
                i3 = i16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Nameplate nameplate, URLImageView this_apply, View view) {
        Intrinsics.checkNotNullParameter(nameplate, "$nameplate");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Uri jumpTo = nameplate.getJumpTo();
        if (jumpTo != null) {
            this_apply.getContext().startActivity(new Intent("android.intent.action.EDIT", jumpTo));
        }
        VideoReport.reportEvent("clck", view, new LinkedHashMap());
    }

    @Override // com.tencent.mobileqq.zplan.nameplate.a
    public void a(UpdateParams params) {
        String get_zplan_guest_nameplate_click_jump_to;
        String replace$default;
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        Card card = params.getCard();
        Integer valueOf = (card == null || (str = card.zplanNameplateId) == null) ? null : Integer.valueOf(Integer.parseInt(str));
        Card card2 = params.getCard();
        String str2 = card2 != null ? card2.uin : null;
        boolean areEqual = Intrinsics.areEqual(MobileQQ.sMobileQQ.getLastLoginUin(), str2);
        if (valueOf != null && str2 != null) {
            NameplateClickJumpTo nameplateClickJumpTo = ZPlanQQMC.INSTANCE.getNameplateClickJumpTo();
            if (areEqual) {
                get_zplan_guest_nameplate_click_jump_to = nameplateClickJumpTo.getGet_zplan_my_nameplate_click_jump_to();
            } else {
                get_zplan_guest_nameplate_click_jump_to = nameplateClickJumpTo.getGet_zplan_guest_nameplate_click_jump_to();
            }
            replace$default = StringsKt__StringsJVMKt.replace$default(get_zplan_guest_nameplate_click_jump_to, "{nameplate_id}", valueOf.toString(), false, 4, (Object) null);
            QLog.i("ZPlanNameplateManager", 1, "\u8df3\u8f6c\u94fe\u63a5 " + nameplateClickJumpTo);
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                CorountineFunKt.e(coroutineScope, "zplan S\u7ea7\u6d3b\u52a8\u94ed\u724c", null, null, null, new ZPlanNameplateManager$update$1(valueOf, this, replace$default, null), 14, null);
                return;
            }
            return;
        }
        QLog.e("ZPlanNameplateManager", 1, "nameplateId=" + valueOf + " uin=" + str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanNameplateManager(RelativeLayout container) {
        this((WeakReference<RelativeLayout>) new WeakReference(container));
        Intrinsics.checkNotNullParameter(container, "container");
    }
}
