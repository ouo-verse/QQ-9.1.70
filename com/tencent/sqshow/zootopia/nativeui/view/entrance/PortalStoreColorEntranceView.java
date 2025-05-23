package com.tencent.sqshow.zootopia.nativeui.view.entrance;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.entrance.PortalStoreColorEntranceView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import ha4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b$\u0010%*\u0004\b&\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/entrance/PortalStoreColorEntranceView;", "Landroid/widget/LinearLayout;", "", "b", "g", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "e", h.F, "d", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mColorEntranceView", "", "Z", "mShowColorEntrance", "Lha4/a;", "f", "Lha4/a;", "getClickListener", "()Lha4/a;", "setClickListener", "(Lha4/a;)V", "clickListener", "", "value", "Ljava/lang/String;", "getColorEntranceReportId", "()Ljava/lang/String;", "setColorEntranceReportId", "(Ljava/lang/String;)V", "colorEntranceReportId", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "i", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reporter", "c", "()Landroid/widget/ImageView;", "getGuideAnchorView$delegate", "(Lcom/tencent/sqshow/zootopia/nativeui/view/entrance/PortalStoreColorEntranceView;)Ljava/lang/Object;", "guideAnchorView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreColorEntranceView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView mColorEntranceView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShowColorEntrance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a clickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String colorEntranceReportId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reporter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreColorEntranceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        ZplanViewReportHelper zplanViewReportHelper = this.reporter;
        if (zplanViewReportHelper != null) {
            zplanViewReportHelper.g(this.mColorEntranceView, this.colorEntranceReportId, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PortalStoreColorEntranceView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reporter;
        if (zplanViewReportHelper != null) {
            ZplanViewReportHelper.f(zplanViewReportHelper, this$0.mColorEntranceView, this$0.colorEntranceReportId, null, 4, null);
        }
        a aVar = this$0.clickListener;
        if (aVar != null) {
            a.C10428a.a(aVar, 0, 1, null);
        }
    }

    private final void g() {
        boolean z16 = this.mShowColorEntrance;
        if (!z16) {
            setVisibility(8);
        } else {
            this.mColorEntranceView.setVisibility(z16 ? 0 : 8);
            setVisibility(0);
        }
    }

    /* renamed from: c, reason: from getter */
    public final ImageView getMColorEntranceView() {
        return this.mColorEntranceView;
    }

    public final void e(j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        setVisibility(8);
        setOrientation(0);
        setGravity(16);
        this.reporter = channel.getReporter().getMReporter();
        View view = new View(getContext());
        view.setBackground(new ColorDrawable(Color.parseColor("#1A000000")));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.b(1), i.b(14));
        layoutParams.rightMargin = i.b(4);
        addView(view, layoutParams);
        this.mColorEntranceView.setImageResource(R.drawable.iei);
        this.mColorEntranceView.setVisibility(4);
        aa.d(this.mColorEntranceView, new View.OnClickListener() { // from class: ha4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PortalStoreColorEntranceView.f(PortalStoreColorEntranceView.this, view2);
            }
        });
        this.mColorEntranceView.setPadding(i.b(4), i.b(4), i.b(4), i.b(4));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i.b(24), i.b(24));
        layoutParams2.rightMargin = i.b(8);
        addView(this.mColorEntranceView, layoutParams2);
        g();
        b();
    }

    public final void setClickListener(a aVar) {
        this.clickListener = aVar;
    }

    public final void setColorEntranceReportId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = this.colorEntranceReportId;
        this.colorEntranceReportId = value;
        if (Intrinsics.areEqual(str, value)) {
            return;
        }
        b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreColorEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void d() {
        this.mShowColorEntrance = false;
        g();
    }

    public final void h() {
        this.mShowColorEntrance = true;
        g();
    }

    public /* synthetic */ PortalStoreColorEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreColorEntranceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorEntranceView = new ImageView(context);
        this.colorEntranceReportId = "em_zplan_makeup_dye_entrance";
    }
}
