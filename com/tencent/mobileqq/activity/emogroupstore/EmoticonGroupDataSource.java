package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\rB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "input", "", "Lcom/tencent/mobileqq/data/EmoticonFromGroupEntity;", "c", "", "requestCount", "", "requestFilterMsgFromTime", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$b;", "b", "(IJ)Lkotlinx/coroutines/flow/Flow;", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class EmoticonGroupDataSource {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u0011\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/data/EmoticonFromGroupEntity;", "a", "Ljava/util/List;", "d", "()Ljava/util/List;", "resultEmoList", "", "b", "J", "e", "()J", "resultLastMsgTime", "c", "Z", "()Z", "hasMoreData", "I", "()I", "requestCount", "requestFilterMsgFromTime", "<init>", "(Ljava/util/List;JZIJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<EmoticonFromGroupEntity> resultEmoList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long resultLastMsgTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean hasMoreData;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long requestFilterMsgFromTime;

        public b(@NotNull List<? extends EmoticonFromGroupEntity> resultEmoList, long j3, boolean z16, int i3, long j16) {
            Intrinsics.checkNotNullParameter(resultEmoList, "resultEmoList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, resultEmoList, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j16));
                return;
            }
            this.resultEmoList = resultEmoList;
            this.resultLastMsgTime = j3;
            this.hasMoreData = z16;
            this.requestCount = i3;
            this.requestFilterMsgFromTime = j16;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.hasMoreData;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.requestCount;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.requestFilterMsgFromTime;
        }

        @NotNull
        public final List<EmoticonFromGroupEntity> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.resultEmoList;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.resultLastMsgTime;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.resultEmoList, bVar.resultEmoList) && this.resultLastMsgTime == bVar.resultLastMsgTime && this.hasMoreData == bVar.hasMoreData && this.requestCount == bVar.requestCount && this.requestFilterMsgFromTime == bVar.requestFilterMsgFromTime) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int hashCode = ((this.resultEmoList.hashCode() * 31) + androidx.fragment.app.a.a(this.resultLastMsgTime)) * 31;
            boolean z16 = this.hasMoreData;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((hashCode + i3) * 31) + this.requestCount) * 31) + androidx.fragment.app.a.a(this.requestFilterMsgFromTime);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "EmoListResult(resultEmoList=" + this.resultEmoList + ", resultLastMsgTime=" + this.resultLastMsgTime + ", hasMoreData=" + this.hasMoreData + ", requestCount=" + this.requestCount + ", requestFilterMsgFromTime=" + this.requestFilterMsgFromTime + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonGroupDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<EmoticonFromGroupEntity> c(MsgRecord input) {
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> arrayList2 = input.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "input.elements");
        for (MsgElement msgElement : arrayList2) {
            if (msgElement.picElement != null) {
                try {
                    EmoticonFromGroupEntity emoticonFromGroupEntity = new EmoticonFromGroupEntity();
                    emoticonFromGroupEntity.timestamp = input.msgTime;
                    emoticonFromGroupEntity.troopUin = String.valueOf(input.peerUin);
                    emoticonFromGroupEntity.msgRecord = input;
                    emoticonFromGroupEntity.msgElement = msgElement;
                    emoticonFromGroupEntity.fromType = input.msgType;
                    PicElement picElement = msgElement.picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement, "it.picElement");
                    emoticonFromGroupEntity.gifImg = MsgExtKt.x(picElement);
                    PicElement picElement2 = msgElement.picElement;
                    emoticonFromGroupEntity.md5 = picElement2.md5HexStr;
                    Intrinsics.checkNotNullExpressionValue(picElement2, "it.picElement");
                    emoticonFromGroupEntity.thumbURL = aj.b(picElement2, 198);
                    PicElement picElement3 = msgElement.picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement3, "it.picElement");
                    String a16 = aj.a(picElement3);
                    emoticonFromGroupEntity.bigURL = a16;
                    if (emoticonFromGroupEntity.thumbURL == null && a16 == null) {
                        QLog.e("EmoticonGroupDataSource", 2, "Error Entity: " + emoticonFromGroupEntity);
                    } else {
                        arrayList.add(emoticonFromGroupEntity);
                    }
                } catch (Exception e16) {
                    QLog.e("EmoticonGroupDataSource", 2, e16, new Object[0]);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final Flow<b> b(int requestCount, long requestFilterMsgFromTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(requestCount), Long.valueOf(requestFilterMsgFromTime));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(7);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new MsgTypeFilter(2, arrayList));
        return FlowKt.callbackFlow(new EmoticonGroupDataSource$getEmoList$2(arrayList2, requestFilterMsgFromTime, requestCount, this, null));
    }
}
