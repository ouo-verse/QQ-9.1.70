package com.tencent.qqnt.qwallet.aio;

import android.content.Context;
import android.view.View;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/a;", "Lrx3/a;", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "b", "Lcom/tencent/aio/api/runtime/a;", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "Lcom/tencent/qqnt/qwallet/aio/AIOComponentView;", "Lcom/tencent/qqnt/qwallet/aio/AIOComponentView;", "parentView", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements rx3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AIOComponentView parentView;

    @Override // rx3.a
    public void a(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AIOComponentView aIOComponentView = this.parentView;
        if (aIOComponentView != null) {
            if (aIOComponentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentView");
                aIOComponentView = null;
            }
            aIOComponentView.d(msgRecord);
        }
    }

    @Override // rx3.a
    @Nullable
    public View b() {
        AIOComponentView aIOComponentView = this.parentView;
        if (aIOComponentView == null) {
            return null;
        }
        if (aIOComponentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentView");
            aIOComponentView = null;
        }
        return aIOComponentView.c();
    }

    @Override // rx3.a
    @NotNull
    public View c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.parentView == null) {
            this.parentView = new AIOComponentView(context, null, 0, 0, 14, null);
        }
        AIOComponentView aIOComponentView = this.parentView;
        if (aIOComponentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentView");
            return null;
        }
        return aIOComponentView;
    }

    @Override // rx3.a
    public void d(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AIOComponentView aIOComponentView = this.parentView;
        if (aIOComponentView != null) {
            if (aIOComponentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentView");
                aIOComponentView = null;
            }
            aIOComponentView.b(context);
        }
    }
}
