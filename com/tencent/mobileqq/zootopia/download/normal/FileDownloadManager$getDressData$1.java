package com.tencent.mobileqq.zootopia.download.normal;

import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class FileDownloadManager$getDressData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<FileDownloadData, Unit> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileDownloadManager$getDressData$1(Function1<? super FileDownloadData, Unit> function1) {
        super(0);
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b bVar;
        List<FileDownloadEntity> d16;
        Object last;
        synchronized (FileDownloadManager.f328148a) {
            bVar = FileDownloadManager.dbHelper;
            d16 = bVar.d(ZPlanFileCategory.DRESS.getValue());
        }
        if (d16.isEmpty()) {
            this.$callback.invoke(null);
            return;
        }
        final AnonymousClass1 anonymousClass1 = new Function2<FileDownloadEntity, FileDownloadEntity, Integer>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$getDressData$1.1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(FileDownloadEntity fileDownloadEntity, FileDownloadEntity fileDownloadEntity2) {
                return Integer.valueOf(fileDownloadEntity.getId() > fileDownloadEntity2.getId() ? 1 : -1);
            }
        };
        Collections.sort(d16, new Comparator() { // from class: com.tencent.mobileqq.zootopia.download.normal.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b16;
                b16 = FileDownloadManager$getDressData$1.b(Function2.this, obj, obj2);
                return b16;
            }
        });
        com.tencent.mobileqq.zootopia.download.c cVar = com.tencent.mobileqq.zootopia.download.c.f328029a;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) d16);
        this.$callback.invoke(cVar.i((FileDownloadEntity) last));
    }
}
