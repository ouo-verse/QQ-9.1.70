package com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import fi3.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0014J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataTabTitleView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataTabTitleView$a;", "", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "", "W", "data", "X", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "", "Y", "", "selected", "a0", "Z", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeDataTabTitleView extends BaseViewPagerTitleWithLineHint<a, Integer, ZPlanTabTitleData, BaseViewPagerTitleWithLineHint.c> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataTabTitleView$a;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "", "title", "", "c", "Lfi3/ag;", "b", "Lfi3/ag;", "()Lfi3/ag;", "binding", "<init>", "(Lfi3/ag;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends BaseViewPagerTitleWithLineHint.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ag binding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(ag binding) {
            super(r0);
            Intrinsics.checkNotNullParameter(binding, "binding");
            RelativeLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
        }

        /* renamed from: b, reason: from getter */
        public final ag getBinding() {
            return this.binding;
        }

        public final void c(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.binding.f398810b.setText(title);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmallHomeDataTabTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected String W() {
        return "SmallHomeLeaveMsgTitleView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public a q(ZPlanTabTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ag g16 = ag.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026om(context)\n            )");
        return new a(g16);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void B(int index, ZPlanTabTitleData data, LinearLayout container, a holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.c(data.getTitle());
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), new LinearLayout.LayoutParams(i.a(93.5f), i.b(27)));
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void C(a holder, int index, ZPlanTabTitleData data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void K(a holder, boolean selected) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (selected) {
            holder.getBinding().f398810b.setAlpha(1.0f);
            holder.getBinding().f398810b.setTextColor(-16777216);
        } else {
            holder.getBinding().f398810b.setAlpha(0.6f);
            holder.getBinding().f398810b.setTextColor(Color.parseColor("#868686"));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmallHomeDataTabTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SmallHomeDataTabTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint
    protected void n() {
        P(-16777216);
        Q(i.b(3));
        R(i.b(31));
        S(i.b(31));
        L(R.drawable.f159852h11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallHomeDataTabTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
