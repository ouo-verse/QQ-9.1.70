package com.tencent.mobileqq.wink.editor;

import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorFragment$onHiddenOptionFromClip$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isClipChange;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$onHiddenOptionFromClip$1(boolean z16, WinkEditorFragment winkEditorFragment) {
        super(0);
        this.$isClipChange = z16;
        this.this$0 = winkEditorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorFragment this$0) {
        m63.d Uk;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Uk = this$0.Uk();
        if (Uk != null) {
            Uk.n2();
        }
        cx cxVar = this$0.partManager;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partManager");
            cxVar = null;
        }
        cxVar.m().nc();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isClipChange && this.this$0.Hm()) {
            final WinkEditorFragment winkEditorFragment = this.this$0;
            UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cj
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment$onHiddenOptionFromClip$1.b(WinkEditorFragment.this);
                }
            });
        }
    }
}
