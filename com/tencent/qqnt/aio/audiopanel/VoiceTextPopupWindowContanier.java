package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/VoiceTextPopupWindowContanier;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fitSystemWindows", "", "insets", "Landroid/graphics/Rect;", NodeProps.ON_ATTACHED_TO_WINDOW, "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class VoiceTextPopupWindowContanier extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceTextPopupWindowContanier(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        insets.top = 0;
        return super.fitSystemWindows(insets);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.mobileqq.qui.b.f276860a.m(this);
    }
}
