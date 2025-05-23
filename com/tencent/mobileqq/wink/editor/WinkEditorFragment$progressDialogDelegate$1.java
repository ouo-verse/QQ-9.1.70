package com.tencent.mobileqq.wink.editor;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/k;", "invoke", "()Lcom/tencent/mobileqq/wink/editor/hdr/k;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
final class WinkEditorFragment$progressDialogDelegate$1 extends Lambda implements Function0<com.tencent.mobileqq.wink.editor.hdr.k> {
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$progressDialogDelegate$1(WinkEditorFragment winkEditorFragment) {
        super(0);
        this.this$0 = winkEditorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ll();
        this$0.Kj();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.wink.editor.hdr.k invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        com.tencent.mobileqq.wink.editor.hdr.k kVar = new com.tencent.mobileqq.wink.editor.hdr.k(requireContext);
        final WinkEditorFragment winkEditorFragment = this.this$0;
        kVar.i(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cm
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorFragment$progressDialogDelegate$1.b(WinkEditorFragment.this);
            }
        });
        kVar.g(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.WinkEditorFragment$progressDialogDelegate$1$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                WinkEditorFragment.this.ll();
                WinkEditorFragment.this.Kj();
                dr drVar = WinkEditorFragment.this.curTavCut;
                if (drVar != null) {
                    drVar.play();
                }
                return Boolean.FALSE;
            }
        });
        return kVar;
    }
}
