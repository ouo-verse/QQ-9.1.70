package com.tencent.hippykotlin.demo.pages.nearby.base.module;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQNearbyModule$getUserInfoFromNT$2 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ Function2<String, String, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQNearbyModule$getUserInfoFromNT$2(Function2<? super String, ? super String, Unit> function2) {
        super(1);
        this.$callback = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        if (eVar2 == null) {
            eVar2 = new e();
        }
        this.$callback.invoke(eVar2.p("nick"), eVar2.p(PhotoCategorySummaryInfo.AVATAR_URL));
        return Unit.INSTANCE;
    }
}
