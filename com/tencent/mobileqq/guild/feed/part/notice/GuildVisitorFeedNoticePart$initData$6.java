package com.tencent.mobileqq.guild.feed.part.notice;

import com.tencent.richframework.data.base.UIStateData;
import ij1.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildVisitorFeedNoticePart$initData$6 extends FunctionReferenceImpl implements Function1<UIStateData<List<v<?>>>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildVisitorFeedNoticePart$initData$6(Object obj) {
        super(1, obj, GuildVisitorFeedNoticePart.class, "handleUiStateChanged", "handleUiStateChanged(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<v<?>>> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<List<v<?>>> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildVisitorFeedNoticePart) this.receiver).F9(p06);
    }
}
