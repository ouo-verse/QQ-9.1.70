package com.tencent.robot.profile.subscribe;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/subscribe/e;", "T", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/String;", "getTagText", "()Ljava/lang/String;", "X", "(Ljava/lang/String;)V", "tagText", "r", "Ljava/lang/Object;", "V", "()Ljava/lang/Object;", "W", "(Ljava/lang/Object;)V", "rawData", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e<T> extends x<x.b, x.c> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tagText;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T rawData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull x.b left, @NotNull x.c right) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        TextView textView = (TextView) view.findViewById(R.id.jmp);
        if (this.tagText != null && (O() instanceof x.c.C8997c)) {
            textView.setVisibility(0);
            textView.setText(this.tagText);
        } else {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: Q */
    public QUISingleLineListItem H(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QUISingleLineListItem H = super.H(parent);
        TextView textView = new TextView(parent.getContext(), null, 0, R.style.azv);
        textView.setId(R.id.jmp);
        textView.setGravity(17);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, textView.getResources().getDimensionPixelSize(R.dimen.f158711n0));
        marginLayoutParams.rightMargin = textView.getResources().getDimensionPixelOffset(R.dimen.f158728ni);
        textView.setLayoutParams(marginLayoutParams);
        int dimensionPixelSize = textView.getResources().getDimensionPixelSize(R.dimen.f158726ng);
        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        H.e(textView);
        return H;
    }

    @Nullable
    public final T V() {
        return this.rawData;
    }

    public final void W(@Nullable T t16) {
        this.rawData = t16;
    }

    public final void X(@Nullable String str) {
        this.tagText = str;
    }
}
