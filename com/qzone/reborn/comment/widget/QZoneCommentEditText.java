package com.qzone.reborn.comment.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.QQTextBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0017R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "Lcom/qzone/widget/ExtendEditText;", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyPreIme", "f", "", "c", "e", "d", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;", "getOnKeyDownListener", "()Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;", "setOnKeyDownListener", "(Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;)V", "onKeyDownListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentEditText extends ExtendEditText {

    /* renamed from: Q, reason: from kotlin metadata */
    private a onKeyDownListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;", "", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
        void onKeyDown(int keyCode, KeyEvent event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommentEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.widget.ExtendEditText
    public boolean f() {
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        if (getText() instanceof QQTextBuilder) {
            Editable text = getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type com.tencent.mobileqq.text.QQTextBuilder");
            QQTextBuilder qQTextBuilder = (QQTextBuilder) text;
            if (!TextUtils.isEmpty(qQTextBuilder.toPlainText())) {
                info.setText(qQTextBuilder.toPlainText());
                info.setContentDescription(qQTextBuilder.toPlainText());
            } else {
                if (TextUtils.isEmpty(getHint())) {
                    return;
                }
                info.setText(getHint());
                info.setContentDescription(getHint());
            }
        }
    }

    @Override // com.qzone.widget.ExtendEditText, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 4 && event.getAction() == 0) {
            a aVar = this.onKeyDownListener;
            if (aVar == null) {
                return true;
            }
            aVar.onKeyDown(keyCode, event);
            return true;
        }
        return super.onKeyPreIme(keyCode, event);
    }

    public final void setOnKeyDownListener(a aVar) {
        this.onKeyDownListener = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommentEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneCommentEditText(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneCommentEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void c() {
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void d() {
    }

    @Override // com.qzone.widget.ExtendEditText
    protected void e() {
    }
}
