package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.widget.bubble.ZPlanBubbleView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bu;
import uv4.af;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleView;", "Landroid/widget/FrameLayout;", "", "c", "Luv4/af;", "bubbleInfo", "setBubbleInfo", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "b", "e", "f", "d", "Ln74/bu;", "Ln74/bu;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreCreateRoleBubbleView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bu mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreCreateRoleBubbleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(af bubbleInfo, PortalStoreCreateRoleBubbleView this$0, View view) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "$bubbleInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PortalStoreCreateRoleBubbleHelper.f371421a.j();
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_stay_in_page_when_has_registered", true);
        xb4.b bVar = xb4.b.f447772a;
        String str = bubbleInfo.f440127f;
        Intrinsics.checkNotNullExpressionValue(str, "bubbleInfo.jumpUrl");
        String d16 = bVar.d(str, bundle);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, d16);
        this$0.d();
        this$0.f();
    }

    public final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        c();
    }

    public final void d() {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        LinearLayout linearLayout = this.mBinding.f418935b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.bubbleContainer");
        mReporter.e(linearLayout, "em_zplan_create_character_bubble", new LinkedHashMap());
    }

    public final void e() {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        LinearLayout linearLayout = this.mBinding.f418935b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.bubbleContainer");
        mReporter.g(linearLayout, "em_zplan_create_character_bubble", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    public final void f() {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        LinearLayout linearLayout = this.mBinding.f418935b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.bubbleContainer");
        ZplanViewReportHelper.j(mReporter, linearLayout, "em_zplan_create_character_bubble", new LinkedHashMap(), false, null, 16, null);
    }

    public final void setBubbleInfo(final af bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        ZPlanBubbleView zPlanBubbleView = this.mBinding.f418936c;
        Intrinsics.checkNotNullExpressionValue(zPlanBubbleView, "mBinding.bubbleView");
        pu4.g gVar = new pu4.g();
        gVar.f427434a = bubbleInfo.f440124c;
        gVar.f427441h = (int) bubbleInfo.f440126e;
        String str = bubbleInfo.f440125d;
        Intrinsics.checkNotNullExpressionValue(str, "bubbleInfo.richText");
        zPlanBubbleView.b(gVar, str);
        com.tencent.sqshow.zootopia.utils.aa.d(zPlanBubbleView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreCreateRoleBubbleView.g(af.this, this, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreCreateRoleBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreCreateRoleBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreCreateRoleBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bu f16 = bu.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
    }
}
