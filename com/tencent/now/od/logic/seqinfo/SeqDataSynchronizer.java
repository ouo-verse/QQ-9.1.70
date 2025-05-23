package com.tencent.now.od.logic.seqinfo;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import jr4.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kr4.c;
import ln3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/now/od/logic/seqinfo/SeqDataSynchronizer;", "", "a", "PeriodicFetchingSeqTask", "b", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SeqDataSynchronizer {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f338519a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/now/od/logic/seqinfo/SeqDataSynchronizer$PeriodicFetchingSeqTask;", "Lcom/tencent/now/od/logic/seqinfo/PeriodRunningTask;", "", "data", "", "l", "", "errCode", "", "errMsg", "k", "", "heartbeatTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "f", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public final class PeriodicFetchingSeqTask extends PeriodRunningTask {
        final /* synthetic */ SeqDataSynchronizer this$0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/od/logic/seqinfo/SeqDataSynchronizer$PeriodicFetchingSeqTask$a", "Lln3/a$a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes22.dex */
        public static final class a implements a.InterfaceC10739a {
            a() {
            }

            @Override // ln3.a.InterfaceC10739a
            public void onFail(int errCode, @Nullable String errMsg) {
                PeriodicFetchingSeqTask.this.k(errCode, errMsg);
            }

            @Override // ln3.a.InterfaceC10739a
            public void onReceive(@Nullable byte[] data) {
                PeriodicFetchingSeqTask.this.l(data);
            }
        }

        private final int[] j() {
            int collectionSizeOrDefault;
            int[] intArray;
            HashSet b16 = SeqDataSynchronizer.b(null);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = b16.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((b) it.next()).getSeqType()));
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            return intArray;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(int errCode, String errMsg) {
            mn3.a.f417045a.d("errCode: " + errCode + ", errMsg: " + errMsg, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(byte[] data) {
            mn3.a aVar = mn3.a.f417045a;
            aVar.b("", new Object[0]);
            if (data == null) {
                aVar.f("data is null", new Object[0]);
                return;
            }
            try {
                d c16 = d.c(data);
                m(c16.f410890a);
                c[] cVarArr = c16.f410891b;
                Intrinsics.checkNotNullExpressionValue(cVarArr, "rsp.seqInfos");
                SeqDataSynchronizer.c(null, cVarArr);
                aVar.c("fetch rsp:" + c16, new Object[0]);
            } catch (InvalidProtocolBufferNanoException e16) {
                mn3.a.f417045a.e("parse fetch rsp error", e16);
            }
        }

        private final void m(long heartbeatTime) {
            long millis = TimeUnit.SECONDS.toMillis(heartbeatTime);
            if (millis > 0 && millis != getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.INTERVAL java.lang.String()) {
                g(millis);
            }
        }

        @Override // com.tencent.now.od.logic.seqinfo.PeriodRunningTask
        public void f() {
            jr4.c cVar = new jr4.c();
            cVar.f410888a = SeqDataSynchronizer.a(null);
            cVar.f410889b = j();
            mn3.a.f417045a.a("interval:" + getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.INTERVAL java.lang.String() + ",req:" + cVar, new Object[0]);
            ln3.a b16 = kn3.a.INSTANCE.b();
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
            b16.a(byteArray, new a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/now/od/logic/seqinfo/SeqDataSynchronizer$a;", "", "", "DEF_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/od/logic/seqinfo/SeqDataSynchronizer$b;", "", "", "a", "I", "()I", "seqType", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int seqType;

        /* renamed from: a, reason: from getter */
        public final int getSeqType() {
            return this.seqType;
        }
    }

    public static final /* synthetic */ long a(SeqDataSynchronizer seqDataSynchronizer) {
        throw null;
    }

    public static final /* synthetic */ HashSet b(SeqDataSynchronizer seqDataSynchronizer) {
        throw null;
    }

    public static final /* synthetic */ void c(SeqDataSynchronizer seqDataSynchronizer, c[] cVarArr) {
        throw null;
    }
}
