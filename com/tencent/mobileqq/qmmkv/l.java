package com.tencent.mobileqq.qmmkv;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ5\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0096\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/l;", "Lcom/tencent/mobileqq/qmmkv/e;", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "param", "", "report", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l implements e {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ n f262020a = n.f262021a;

    @Override // com.tencent.mobileqq.qmmkv.e
    public void report(@NotNull String eventName, @NotNull HashMap<String, String> param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(param, "param");
        this.f262020a.report(eventName, param);
    }
}
