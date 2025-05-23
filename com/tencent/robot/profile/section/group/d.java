package com.tencent.robot.profile.section.group;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.data.RobotProfileGroupCardData;
import com.tencent.robot.profile.data.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/profile/section/group/d;", "Ln44/f;", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "", "position", "", "", "payload", "p", "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTv", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String TAG = "RobotGroupTitleSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.jj7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.text_title)");
        this.titleTv = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable g data, int position, @Nullable List<Object> payload) {
        if (!(data instanceof RobotProfileGroupCardData)) {
            QLog.e(this.TAG, 1, "onBindData data is not RobotProfileGroupCardData");
            return;
        }
        getRootView().setBackground(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_common_bg_bottom_light_bg));
        String str = "\u5979";
        if (!Intrinsics.areEqual("\u5979", ((RobotProfileGroupCardData) data).getRobotCallName())) {
            str = "\u4ed6";
        }
        TextView textView = this.titleTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        TextView textView3 = this.titleTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView3 = null;
        }
        textView.setTextColor(textView3.getContext().getResources().getColor(R.color.qui_common_text_primary));
        TextView textView4 = this.titleTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView4 = null;
        }
        TextView textView5 = this.titleTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        } else {
            textView2 = textView5;
        }
        textView4.setText(textView2.getContext().getString(R.string.f222676e6, str));
    }
}
