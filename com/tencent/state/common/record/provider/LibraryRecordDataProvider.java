package com.tencent.state.common.record.provider;

import com.tencent.rapier.b;
import com.tencent.state.common.record.IRecordDataProvider;
import com.tencent.state.common.record.RecordData;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qs4.a;
import qs4.c;
import qs4.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/common/record/provider/LibraryRecordDataProvider;", "Lcom/tencent/state/common/record/IRecordDataProvider;", "()V", "service", "Lcom/tencent/state/common/record/provider/ILibraryRecordService;", "getInteractionRecord", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/common/record/RecordData;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class LibraryRecordDataProvider implements IRecordDataProvider {
    private static final String TAG = "LibraryRecordDataProvider";
    private final ILibraryRecordService service = (ILibraryRecordService) Square.INSTANCE.getConfig().getRapier().b(ILibraryRecordService.class);

    @Override // com.tencent.state.common.record.IRecordDataProvider
    public void getInteractionRecord(final ResultCallback<List<RecordData>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final HashMap hashMap = new HashMap();
        final ArrayList arrayList = new ArrayList();
        ILibraryRecordService iLibraryRecordService = this.service;
        a aVar = new a();
        aVar.f429468a = 0L;
        Unit unit = Unit.INSTANCE;
        iLibraryRecordService.getInteractionRecord(aVar).a(new b<qs4.b>() { // from class: com.tencent.state.common.record.provider.LibraryRecordDataProvider$getInteractionRecord$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LibraryRecordDataProvider", "errorCode is " + errorCode + ", errorMsg is " + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(qs4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                for (d dVar : response.f429470b) {
                    HashMap hashMap2 = hashMap;
                    Integer valueOf = Integer.valueOf(dVar.f429480a);
                    String str = dVar.f429481b;
                    Intrinsics.checkNotNullExpressionValue(str, "item.text");
                    hashMap2.put(valueOf, str);
                }
                for (c info : response.f429469a) {
                    ArrayList arrayList2 = arrayList;
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    arrayList2.add(LibraryRecordDataProviderKt.formatLibraryRecord(info, (String) hashMap.get(Integer.valueOf(info.f429476d))));
                }
                ResultCallback.this.onResultSuccess(arrayList);
            }
        });
    }
}
