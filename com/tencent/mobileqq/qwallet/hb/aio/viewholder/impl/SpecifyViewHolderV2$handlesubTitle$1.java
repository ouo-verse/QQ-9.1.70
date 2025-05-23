package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "name", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
final class SpecifyViewHolderV2$handlesubTitle$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ SpecifyViewHolderV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecifyViewHolderV2$handlesubTitle$1(SpecifyViewHolderV2 specifyViewHolderV2) {
        super(1);
        this.this$0 = specifyViewHolderV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SpecifyViewHolderV2 this$0, String name) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        TextView c16 = this$0.getParentViewHolder().c();
        if (c16 != null) {
            c16.setVisibility(0);
            c16.setTextSize(13.0f);
            c16.setMaxLines(2);
            c16.setGravity(17);
            c16.setText(c16.getContext().getString(R.string.f21745612, name));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final SpecifyViewHolderV2 specifyViewHolderV2 = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                SpecifyViewHolderV2$handlesubTitle$1.b(SpecifyViewHolderV2.this, name);
            }
        });
    }
}
