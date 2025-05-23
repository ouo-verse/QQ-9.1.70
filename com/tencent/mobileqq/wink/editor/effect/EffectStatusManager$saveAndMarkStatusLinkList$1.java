package com.tencent.mobileqq.wink.editor.effect;

import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public /* synthetic */ class EffectStatusManager$saveAndMarkStatusLinkList$1 extends FunctionReferenceImpl implements Function1<ArrayList<EffectStatusManager.AppliedEffect>, ArrayList<EffectStatusManager.AppliedEffect>> {
    public static final EffectStatusManager$saveAndMarkStatusLinkList$1 INSTANCE = new EffectStatusManager$saveAndMarkStatusLinkList$1();

    EffectStatusManager$saveAndMarkStatusLinkList$1() {
        super(1, EffectStatusManagerKt.class, "copy", "copy(Ljava/util/ArrayList;)Ljava/util/ArrayList;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final ArrayList<EffectStatusManager.AppliedEffect> invoke(@NotNull ArrayList<EffectStatusManager.AppliedEffect> p06) {
        ArrayList<EffectStatusManager.AppliedEffect> b16;
        Intrinsics.checkNotNullParameter(p06, "p0");
        b16 = EffectStatusManagerKt.b(p06);
        return b16;
    }
}
