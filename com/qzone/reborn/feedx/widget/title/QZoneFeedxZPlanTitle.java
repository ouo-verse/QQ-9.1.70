package com.qzone.reborn.feedx.widget.title;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.b;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uh.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneFeedxZPlanTitle;", "Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;", "Luh/a;", "", "a", "visibility", "", "setConciseLeftTitleVisibility", "", "currentThemeId", "setAdaptToConcise", c.f123400v, "setTitleBarTranslate", "color", "b", "Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, "t", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "y", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxZPlanTitle extends QZoneFriendFeedxTitle implements a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxZPlanTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // uh.a
    public int a() {
        return getMCurAlpha();
    }

    @Override // uh.a
    public void b(int color) {
        M(color);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public int l() {
        return getContext().getColor(R.color.qui_common_icon_nav_primary);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public int q() {
        return getContext().getColor(R.color.qui_common_text_nav_primary);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public Drawable s() {
        return ContextCompat.getDrawable(getContext(), R.drawable.qui_bg_nav_primary);
    }

    @Override // uh.a
    public void setAdaptToConcise(String currentThemeId) {
        b(l());
    }

    @Override // uh.a
    public void setConciseLeftTitleVisibility(int visibility) {
        getMLeftTitle().setVisibility(visibility);
    }

    @Override // uh.a
    public void setTitleBarTranslate(int alpha) {
        setTitleAlpha(alpha);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public Drawable t() {
        if (b.c()) {
            return new ColorDrawable(SimpleUIUtil.getSimpleUiBgColor());
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return new ColorDrawable(-16777216);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.skin_header_bar_bg);
    }

    @Override // com.qzone.reborn.feedx.widget.title.QZoneBaseFeedxTitle
    public boolean y() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxZPlanTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFeedxZPlanTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxZPlanTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
