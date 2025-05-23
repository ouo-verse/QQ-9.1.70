package com.tencent.mobileqq.search.searchdetail.multimedia;

import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public /* synthetic */ class NetSearchMultiMediaCard$showInterActiveInfo$1$interactiveDataList$1$3 extends FunctionReferenceImpl implements Function6<Long, String, String, Integer, SearchJump, Map<String, ? extends String>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NetSearchMultiMediaCard$showInterActiveInfo$1$interactiveDataList$1$3(Object obj) {
        super(6, obj, NetSearchMultiMediaCard.class, "onShareButtonClick", "onShareButtonClick(JLjava/lang/String;Ljava/lang/String;ILcom/tencent/qqnt/kernel/nativeinterface/SearchJump;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Unit invoke(Long l3, String str, String str2, Integer num, SearchJump searchJump, Map<String, ? extends String> map) {
        invoke(l3.longValue(), str, str2, num.intValue(), searchJump, (Map<String, String>) map);
        return Unit.INSTANCE;
    }

    public final void invoke(long j3, @NotNull String p16, @NotNull String p26, int i3, @Nullable SearchJump searchJump, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        ((NetSearchMultiMediaCard) this.receiver).O(j3, p16, p26, i3, searchJump, map);
    }
}
