package com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "DispatchContext", "Payload", "", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "a", "(Ljava/lang/Object;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Ljava/lang/Object;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface b<DispatchContext, Payload> {
    void a(DispatchContext ctx, @NotNull InlineBtnView<DispatchContext, Payload> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable Payload payload);
}
