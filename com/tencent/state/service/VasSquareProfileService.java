package com.tencent.state.service;

import com.tencent.rapier.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import ns4.a;
import ns4.c;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b2&\u0010\f\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000b\u0012\u0004\u0012\u00020\b0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/service/VasSquareProfileService;", "", "()V", "TAG", "", "service", "Lcom/tencent/state/service/IVasUserProfileService;", "getUserProfile", "", "uins", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/square/data/SquareUserInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareProfileService {
    private static final String TAG = "VasSquareProfileService";
    public static final VasSquareProfileService INSTANCE = new VasSquareProfileService();
    private static final IVasUserProfileService service = (IVasUserProfileService) Square.INSTANCE.getConfig().getRapier().b(IVasUserProfileService.class);

    VasSquareProfileService() {
    }

    public final void getUserProfile(ArrayList<String> uins, final Function1<? super ArrayList<SquareUserInfo>, Unit> callback) {
        long[] longArray;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = uins.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(Long.valueOf(longOrNull.longValue()));
            }
        }
        IVasUserProfileService iVasUserProfileService = service;
        a aVar = new a();
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        aVar.f421247a = longArray;
        Unit unit = Unit.INSTANCE;
        iVasUserProfileService.getUserProfiles(aVar).a(new b<ns4.b>() { // from class: com.tencent.state.service.VasSquareProfileService$getUserProfile$2
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareProfileService", "getUserProfile errCode: " + errorCode + ", errMsg: " + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(ns4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ArrayList arrayList2 = new ArrayList();
                c[] cVarArr = response.f421248a;
                Intrinsics.checkNotNullExpressionValue(cVarArr, "response.userInfos");
                for (c it5 : cVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    arrayList2.add(UserFormatKt.formatSquareUserInfo(it5));
                }
                Function1.this.invoke(arrayList2);
            }
        });
    }
}
