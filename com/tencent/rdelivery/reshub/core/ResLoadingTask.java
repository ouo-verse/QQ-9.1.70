package com.tencent.rdelivery.reshub.core;

import androidx.annotation.GuardedBy;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.rdelivery.reshub.core.ResLoadingTask;
import com.tencent.rdelivery.reshub.util.ResLoadCallbackUtilKt;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001dj\b\u0012\u0004\u0012\u00020\u0002`\u001e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001fR$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001dj\b\u0012\u0004\u0012\u00020\u0005`\u001e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/ResLoadingTask;", "", "Lcom/tencent/rdelivery/reshub/core/k;", Const.BUNDLE_KEY_REQUEST, "", "Lcom/tencent/rdelivery/reshub/core/ResLoadingTask$a;", "progressRecords", "", "f", "", "status", "", "progress", tl.h.F, "c", "a", "b", "", "downloadSize", "totalSize", "g", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "e", "Ljz3/e;", "resConfig", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "requests", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResLoadingTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @GuardedBy("this")
    private final ArrayList<k> requests = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @GuardedBy("this")
    private final ArrayList<StatusProgressRecord> progressRecords = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/ResLoadingTask$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "status", "", UserInfo.SEX_FEMALE, "()F", "c", "(F)V", "progress", "<init>", "(IF)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.reshub.core.ResLoadingTask$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class StatusProgressRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private float progress;

        public StatusProgressRecord(int i3, float f16) {
            this.status = i3;
            this.progress = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getProgress() {
            return this.progress;
        }

        /* renamed from: b, reason: from getter */
        public final int getStatus() {
            return this.status;
        }

        public final void c(float f16) {
            this.progress = f16;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof StatusProgressRecord) {
                    StatusProgressRecord statusProgressRecord = (StatusProgressRecord) other;
                    if (this.status != statusProgressRecord.status || Float.compare(this.progress, statusProgressRecord.progress) != 0) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.status * 31) + Float.floatToIntBits(this.progress);
        }

        @NotNull
        public String toString() {
            return "StatusProgressRecord(status=" + this.status + ", progress=" + this.progress + ")";
        }
    }

    private final void c(final int status, final float progress) {
        final List<k> b16 = b();
        ThreadUtil.c(ThreadUtil.f364593c, "UpdateProgress", null, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoadingTask$callbackUserProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Iterator it = b16.iterator();
                while (it.hasNext()) {
                    com.tencent.rdelivery.reshub.api.h innerCallback = ((k) it.next()).getInnerCallback();
                    if (innerCallback != null) {
                        ResLoadCallbackUtilKt.g(innerCallback, status, progress);
                    }
                }
            }
        }, 2, null);
    }

    private final void f(final k request, final List<StatusProgressRecord> progressRecords) {
        ThreadUtil.c(ThreadUtil.f364593c, "UpdateProgress", null, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.core.ResLoadingTask$replayProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                for (ResLoadingTask.StatusProgressRecord statusProgressRecord : progressRecords) {
                    com.tencent.rdelivery.reshub.api.h innerCallback = request.getInnerCallback();
                    if (innerCallback != null) {
                        ResLoadCallbackUtilKt.g(innerCallback, statusProgressRecord.getStatus(), statusProgressRecord.getProgress());
                    }
                }
            }
        }, 2, null);
    }

    private final synchronized void h(int status, float progress) {
        Object last;
        Object last2;
        ArrayList<StatusProgressRecord> arrayList = this.progressRecords;
        if (!arrayList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            if (((StatusProgressRecord) last).getStatus() == status) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                ((StatusProgressRecord) last2).c(progress);
            }
        }
        arrayList.add(new StatusProgressRecord(status, progress));
    }

    public final synchronized void a(@NotNull k request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        this.requests.add(request);
        if (!this.progressRecords.isEmpty()) {
            f(request, new ArrayList(this.progressRecords));
        }
    }

    @NotNull
    public final synchronized List<k> b() {
        return new ArrayList(this.requests);
    }

    public final void d(@Nullable jz3.e resConfig) {
        boolean z16;
        com.tencent.rdelivery.reshub.report.a aVar;
        long a16 = com.tencent.rdelivery.reshub.report.d.a();
        if (resConfig != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aVar = com.tencent.rdelivery.reshub.report.b.a();
        } else {
            aVar = new com.tencent.rdelivery.reshub.report.a();
            aVar.e(1004);
        }
        com.tencent.rdelivery.reshub.report.a aVar2 = aVar;
        for (k kVar : b()) {
            kVar.z(z16, aVar2, a16);
            com.tencent.rdelivery.reshub.api.h innerCallback = kVar.getInnerCallback();
            if (innerCallback != null) {
                ResLoadCallbackUtilKt.f(innerCallback, z16, resConfig, null, 4, null);
            }
        }
    }

    public final void e(boolean isSuccess, @NotNull com.tencent.rdelivery.reshub.report.a errorInfo) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        long a16 = com.tencent.rdelivery.reshub.report.d.a();
        for (k kVar : b()) {
            Pair<jz3.e, String> D = kVar.D(!isSuccess);
            jz3.e component1 = D.component1();
            String component2 = D.component2();
            if (isSuccess && component1 == null) {
                errorInfo.e(4002);
                errorInfo.g(component2);
            }
            if (isSuccess && component1 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (kVar.getMode() == 1 && z16) {
                kVar.getConfigMap().t(kVar.x());
            }
            kVar.G(component1);
            kVar.z(z16, errorInfo, a16);
            com.tencent.rdelivery.reshub.api.h innerCallback = kVar.getInnerCallback();
            if (innerCallback != null) {
                ResLoadCallbackUtilKt.e(innerCallback, z16, component1, errorInfo);
            }
            if (z16) {
                kVar.getRefreshManager().e(component1);
            }
        }
    }

    public final void g(int status, long downloadSize, long totalSize) {
        float a16 = com.tencent.rdelivery.reshub.util.e.a(status, downloadSize, totalSize);
        h(status, a16);
        c(status, a16);
    }
}
