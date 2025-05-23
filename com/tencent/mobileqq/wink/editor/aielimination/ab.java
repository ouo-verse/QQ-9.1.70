package com.tencent.mobileqq.wink.editor.aielimination;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.view.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/ab;", "Lcom/tencent/mobileqq/wink/view/ag;", "", "initView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "loadFailedText", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/view/ag$a;", "callback", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/view/ag$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ab extends ag {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView loadFailedText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(@NotNull Context context, @NotNull ag.a callback) {
        super(context, callback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ag
    public void initView() {
        super.initView();
        TextView textView = (TextView) this.E.findViewById(R.id.yrq);
        this.loadFailedText = textView;
        if (textView != null) {
            textView.setText(this.C.getText(R.string.f239947nu));
        }
    }
}
