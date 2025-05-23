package com.tencent.mobileqq.guild.base.view.colorpick;

import com.tencent.mobileqq.guild.base.view.colorpick.ColorPickDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
/* synthetic */ class ColorPickDialogFragment$ColorAdapter$onCreateViewHolder$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorPickDialogFragment$ColorAdapter$onCreateViewHolder$1(Object obj) {
        super(1, obj, ColorPickDialogFragment.ColorAdapter.class, "pick", "pick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        ((ColorPickDialogFragment.ColorAdapter) this.receiver).m0(i3);
    }
}
