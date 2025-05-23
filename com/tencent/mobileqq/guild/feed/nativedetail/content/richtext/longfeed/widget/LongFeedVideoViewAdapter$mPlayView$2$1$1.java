package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class LongFeedVideoViewAdapter$mPlayView$2$1$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LongFeedVideoViewAdapter$mPlayView$2$1$1(Object obj) {
        super(1, obj, LongFeedVideoViewAdapter.class, "launchGallery", "launchGallery(Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((LongFeedVideoViewAdapter) this.receiver).A(p06);
    }
}
