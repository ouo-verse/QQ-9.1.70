package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.FeedReferRequestArgs;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class LikeUI$handleLikeLayoutClick$2 extends FunctionReferenceImpl implements Function3<Integer, FeedReferRequestArgs, Object, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeUI$handleLikeLayoutClick$2(Object obj) {
        super(3, obj, LikeUI.class, "handleDoFeedPreferRsp", "handleDoFeedPreferRsp(ILcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/FeedReferRequestArgs;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, FeedReferRequestArgs feedReferRequestArgs, Object obj) {
        invoke(num.intValue(), feedReferRequestArgs, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, @NotNull FeedReferRequestArgs p16, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((LikeUI) this.receiver).o(i3, p16, obj);
    }
}
