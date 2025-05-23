package com.tencent.sqshow.zootopia.nativeui.view.entrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.entrance.PortalStoreFilterEntranceView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import ha4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/entrance/PortalStoreFilterEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "b", "f", "d", "g", "c", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mFilterEntranceView", "", "e", "Z", "mShowFilterEntrance", "Lha4/a;", "Lha4/a;", "getClickListener", "()Lha4/a;", "setClickListener", "(Lha4/a;)V", "clickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreFilterEntranceView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView mFilterEntranceView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShowFilterEntrance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a clickListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreFilterEntranceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(j channel) {
        channel.getReporter().getMReporter().g(this.mFilterEntranceView, "em_zplan_filter_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(this.mFilterEntranceView, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(j channel, PortalStoreFilterEntranceView this$0, View view) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper.f(channel.getReporter().getMReporter(), this$0.mFilterEntranceView, "em_zplan_filter_btn", null, 4, null);
        a aVar = this$0.clickListener;
        if (aVar != null) {
            aVar.e();
        }
    }

    private final void f() {
        boolean z16 = this.mShowFilterEntrance;
        if (!z16) {
            setVisibility(8);
        } else {
            this.mFilterEntranceView.setVisibility(z16 ? 0 : 8);
            setVisibility(0);
        }
    }

    public final void d(final j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        setVisibility(8);
        setOrientation(0);
        setGravity(16);
        aa.d(this.mFilterEntranceView, new View.OnClickListener() { // from class: ha4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreFilterEntranceView.e(j.this, this, view);
            }
        });
        this.mFilterEntranceView.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.iej, R.color.qui_common_icon_secondary, 1000));
        this.mFilterEntranceView.setVisibility(4);
        this.mFilterEntranceView.setPadding(i.b(4), i.b(4), i.b(4), i.b(4));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.b(24), i.b(24));
        layoutParams.rightMargin = i.b(8);
        addView(this.mFilterEntranceView, layoutParams);
        f();
        b(channel);
    }

    public final void setClickListener(a aVar) {
        this.clickListener = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreFilterEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void c() {
        this.mShowFilterEntrance = false;
        f();
    }

    public final void g() {
        this.mShowFilterEntrance = true;
        f();
    }

    public /* synthetic */ PortalStoreFilterEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreFilterEntranceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFilterEntranceView = new ImageView(context);
    }
}
