package com.tencent.mobileqq.wink.pubcover.template;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.view.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/c;", "Lcom/tencent/mobileqq/wink/view/x;", "Lcom/tencent/mobileqq/wink/view/x$a;", "categoryItemVH", "", "position", "", "v", "Landroid/content/res/ColorStateList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", BdhLogUtil.LogTag.Tag_Conn, "getTextColorSelected", "setTextColorSelected", "textColorSelected", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materialCategories", "Lcom/tencent/mobileqq/wink/view/x$b;", "itemListener", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/wink/view/x$b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends x {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ColorStateList textColorSelected;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList textColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@Nullable List<MetaCategory> list, @NotNull x.b itemListener) {
        super(list, itemListener);
        Intrinsics.checkNotNullParameter(itemListener, "itemListener");
        ColorStateList colorStateList = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "sMobileQQ.resources.getC\u2026ui_common_text_secondary)");
        this.textColor = colorStateList;
        ColorStateList colorStateList2 = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList2, "sMobileQQ.resources.getC\u2026.qui_common_text_primary)");
        this.textColorSelected = colorStateList2;
    }

    @Override // com.tencent.mobileqq.wink.view.x, android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v */
    public void onBindViewHolder(@Nullable x.a categoryItemVH, int position) {
        super.onBindViewHolder(categoryItemVH, position);
        if (categoryItemVH != null) {
            categoryItemVH.f327154d.setTypeface(Typeface.defaultFromStyle(1));
            if (this.f327153i == position) {
                categoryItemVH.f327154d.setTextColor(this.textColorSelected);
            } else {
                categoryItemVH.f327154d.setTextColor(this.textColor);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(categoryItemVH, position, getItemId(position));
    }
}
