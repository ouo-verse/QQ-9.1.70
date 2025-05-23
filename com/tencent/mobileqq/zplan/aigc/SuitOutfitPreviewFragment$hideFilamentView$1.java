package com.tencent.mobileqq.zplan.aigc;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewFragment$hideFilamentView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewFragment$hideFilamentView$1(SuitOutfitPreviewFragment suitOutfitPreviewFragment) {
        super(0);
        this.this$0 = suitOutfitPreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final SuitOutfitPreviewFragment this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view = this$0.textureView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.aw
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment$hideFilamentView$1.d(SuitOutfitPreviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SuitOutfitPreviewFragment this$0) {
        TextView Uj;
        FrameLayout Dj;
        ImageView Xj;
        ImageView Wj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Uj = this$0.Uj();
        Uj.setText("\u7acb\u5373\u6295\u7a3f");
        Dj = this$0.Dj();
        if (Dj != null) {
            Dj.setVisibility(0);
        }
        Xj = this$0.Xj();
        if (Xj != null) {
            Xj.setVisibility(8);
        }
        Wj = this$0.Wj();
        if (Wj == null) {
            return;
        }
        Wj.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final SuitOutfitPreviewFragment suitOutfitPreviewFragment = this.this$0;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.av
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment$hideFilamentView$1.c(SuitOutfitPreviewFragment.this);
            }
        }, 16, null, false, 500L);
    }
}
