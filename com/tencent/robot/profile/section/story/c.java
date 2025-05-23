package com.tencent.robot.profile.section.story;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.robot.profile.data.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/profile/section/story/c;", "Ln44/f;", "Landroid/content/Context;", "", "drawableResId", "Landroid/graphics/drawable/Drawable;", "p", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "storyTitleView", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView storyTitleView;

    private final Drawable p(Context context, @DrawableRes int i3) {
        Drawable drawable = ContextCompat.getDrawable(context, i3);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
            return drawable;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f28220ic);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026R.id.profile_story_title)");
        this.storyTitleView = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable g data, int position, @Nullable List<Object> payload) {
        TextView textView = this.storyTitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyTitleView");
            textView = null;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f222806ei));
        TextView textView2 = this.storyTitleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyTitleView");
            textView2 = null;
        }
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "storyTitleView.context");
        Drawable p16 = p(context, R.drawable.qui_robot_story_icon_primary);
        TextView textView3 = this.storyTitleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyTitleView");
            textView3 = null;
        }
        textView3.setCompoundDrawables(p16, null, null, null);
        getRootView().setBackground(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.liw));
    }
}
