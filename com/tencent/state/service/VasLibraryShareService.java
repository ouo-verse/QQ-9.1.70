package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.service.ITemplateShareService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import ss4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/service/VasLibraryShareService;", "Lcom/tencent/state/template/service/ITemplateShareService;", "()V", "TAG", "", "shareService", "Lcom/tencent/state/service/IVasLibraryShareService;", "doShare", "", "uin", "", "groupId", "type", "", "callback", "Lkotlin/Function1;", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasLibraryShareService implements ITemplateShareService {
    private static final String TAG = "VasLibraryShareService";
    public static final VasLibraryShareService INSTANCE = new VasLibraryShareService();
    private static final IVasLibraryShareService shareService = (IVasLibraryShareService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryShareService.class);

    VasLibraryShareService() {
    }

    @Override // com.tencent.state.template.service.ITemplateShareService
    public void doShare(long uin, long groupId, int type, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        aVar.f434666a = uin;
        aVar.f434667b = groupId;
        aVar.f434668c = type;
        shareService.doLibraryShare(aVar).a(new b<ss4.b>() { // from class: com.tencent.state.service.VasLibraryShareService$doShare$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryShareService", "doLibraryShare error " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ss4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }
}
