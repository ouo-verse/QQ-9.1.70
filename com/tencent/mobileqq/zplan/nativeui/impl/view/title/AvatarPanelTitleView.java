package com.tencent.mobileqq.zplan.nativeui.impl.view.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.data.title.AvatarPanelTitleData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle;
import gj3.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J,\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0014J\u001e\u0010\u0013\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J0\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/nativeui/impl/view/title/AvatarPanelTitleView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle;", "Lgj3/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/AvatarPanelTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "", "titleList", "", "N", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "H", "G", "I", "", "selectedPos", "setTitleData", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", "J", "", "selected", "clearLastRedDot", "M", "K", "L", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lgj3/a;", "currentViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPanelTitleView extends BaseViewPagerTitle<a, String, AvatarPanelTitleData, BaseViewPagerTitle.c> {

    /* renamed from: K, reason: from kotlin metadata */
    private Drawable defaultDrawable;

    /* renamed from: L, reason: from kotlin metadata */
    private j mChannel;

    /* renamed from: M, reason: from kotlin metadata */
    private a currentViewHolder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> H(AvatarPanelTitleData data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getCategoryCfg().f440171a;
        Intrinsics.checkNotNullExpressionValue(str, "data.categoryCfg.id");
        hashMap.put("zplan_tab_id", str);
        hashMap.put("zplan_tab_level", 1);
        return hashMap;
    }

    private final void N(List<AvatarPanelTitleData> titleList) {
        for (AvatarPanelTitleData avatarPanelTitleData : titleList) {
            String icon = avatarPanelTitleData.getCategoryCfg().f440174d;
            if (icon != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                CommonExKt.o(icon, null, null, 3, null);
            }
            String activeIcon = avatarPanelTitleData.getCategoryCfg().f440175e;
            if (activeIcon != null) {
                Intrinsics.checkNotNullExpressionValue(activeIcon, "activeIcon");
                CommonExKt.o(activeIcon, null, null, 3, null);
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    protected String G() {
        return "AvatarPanelTitleView_";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public a l(AvatarPanelTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.dad, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        a aVar = new a(itemView);
        aVar.getTitleIconIgv().setImageDrawable(this.defaultDrawable);
        return aVar;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void u(int index, AvatarPanelTitleData data, LinearLayout container, a holder) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        float dimension = getContext().getResources().getDimension(R.dimen.f115755);
        float dimension2 = getContext().getResources().getDimension(R.dimen.f115856);
        holder.b(data.getCategoryCfg().f440179i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) dimension2, (int) dimension);
        if (index == 0) {
            layoutParams.leftMargin = i.b(4);
        } else if (index == p().size() - 1) {
            layoutParams.rightMargin = i.b(4);
        }
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().g(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : H(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void v(a holder, int index, AvatarPanelTitleData data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        a aVar = this.currentViewHolder;
        if (aVar != null) {
            aVar.c();
        }
        holder.d(data.getCategoryCfg().f440179i);
        this.currentViewHolder = holder;
        j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().e(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", H(data));
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void w(a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.w(holder);
        QLog.d(G(), 1, "onItemViewSelected, holder: " + holder);
        a aVar = this.currentViewHolder;
        if (aVar != null) {
            aVar.c();
        }
        holder.c();
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void C(a holder, boolean selected, int index, AvatarPanelTitleData data, boolean clearLastRedDot) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        URLImageView titleIconIgv = holder.getTitleIconIgv();
        Intrinsics.checkNotNullExpressionValue(titleIconIgv, "holder.titleIconIgv");
        if (selected) {
            this.currentViewHolder = holder;
            holder.getTitleIconIgv().setAlpha(1.0f);
            str = data.getCategoryCfg().f440175e;
        } else {
            holder.getTitleIconIgv().setAlpha(0.6f);
            str = data.getCategoryCfg().f440174d;
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "if (selected) {\n        \u2026oryCfg.icon\n            }");
        CommonExKt.w(titleIconIgv, str2, this.defaultDrawable, null, 4, null);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle, vc4.i
    public void setTitleData(List<AvatarPanelTitleData> titleList, int selectedPos) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        N(titleList);
        super.setTitleData(titleList, selectedPos);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AvatarPanelTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultDrawable = q.b(R.drawable.h4b);
    }
}
