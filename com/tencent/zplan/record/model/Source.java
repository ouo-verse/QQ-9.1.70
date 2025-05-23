package com.tencent.zplan.record.model;

import com.tencent.zplan.record.provider.CloudCacheProvider;
import com.tencent.zplan.record.provider.LocalCacheProvider;
import com.tencent.zplan.record.provider.LocalRecordProvider;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/record/model/Source;", "", "Lcom/tencent/zplan/record/provider/a;", "toProvider", "source", "", QCircleDaTongConstant.ElementParamValue.PLUS, "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "LOCAL_CACHE", "CLOUD_CACHE", "LOCAL_RECORD", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public enum Source {
    LOCAL_CACHE,
    CLOUD_CACHE,
    LOCAL_RECORD;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/record/model/Source$a;", "", "", "Lcom/tencent/zplan/record/model/Source;", "Lcom/tencent/zplan/record/provider/a;", "a", "(Ljava/util/List;)Lcom/tencent/zplan/record/provider/a;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.model.Source$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final com.tencent.zplan.record.provider.a a(@NotNull List<? extends Source> toProviderChain) {
            List distinct;
            Intrinsics.checkNotNullParameter(toProviderChain, "$this$toProviderChain");
            distinct = CollectionsKt___CollectionsKt.distinct(toProviderChain);
            com.tencent.zplan.record.provider.a aVar = null;
            if (distinct.isEmpty()) {
                return null;
            }
            Iterator it = distinct.iterator();
            com.tencent.zplan.record.provider.a aVar2 = null;
            while (it.hasNext()) {
                com.tencent.zplan.record.provider.a provider = ((Source) it.next()).toProvider();
                if (aVar == null) {
                    aVar = provider;
                }
                if (aVar2 != null) {
                    aVar2.b(provider);
                }
                aVar2 = provider;
            }
            return aVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.zplan.record.provider.a toProvider() {
        int i3 = e.f386094a[ordinal()];
        int i16 = 1;
        com.tencent.zplan.record.provider.a aVar = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        byte b26 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return new LocalRecordProvider(aVar, i16, b26 == true ? 1 : 0);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new CloudCacheProvider(b19 == true ? 1 : 0, i16, b18 == true ? 1 : 0);
        }
        return new LocalCacheProvider(b17 == true ? 1 : 0, i16, b16 == true ? 1 : 0);
    }

    @NotNull
    public List<Source> plus(@NotNull Source source) {
        List<Source> listOf;
        Intrinsics.checkNotNullParameter(source, "source");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{this, source});
        return listOf;
    }
}
