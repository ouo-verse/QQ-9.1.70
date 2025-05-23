package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieTtsDataManager$getTtsIndexById$1 extends Lambda implements Function1<AdelieTtsInfo, Boolean> {
    public final /* synthetic */ String $ttsId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieTtsDataManager$getTtsIndexById$1(String str) {
        super(1);
        this.$ttsId = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(AdelieTtsInfo adelieTtsInfo) {
        return Boolean.valueOf(Intrinsics.areEqual(adelieTtsInfo.ttsId, this.$ttsId));
    }
}
