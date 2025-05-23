package com.tencent.state.square.bubblesetting;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mt4.a;
import mt4.b;
import mt4.c;
import mt4.f;
import mt4.g;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fJ$\u0010\u000e\u001a\u00020\b2\u001c\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinService;", "", "()V", "TAG", "", "bubbleSkinService", "Lcom/tencent/state/square/bubblesetting/ISquareBubbleSkinService;", "dressBubbleSkin", "", "bubbleId", "", "callback", "Lkotlin/Function1;", "", "getBubbleSkin", "Lcom/tencent/state/service/ResultCallback;", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "Lkotlin/collections/ArrayList;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBubbleSkinService {
    private static final String TAG = "SquareBubbleSkinService";
    public static final SquareBubbleSkinService INSTANCE = new SquareBubbleSkinService();
    private static final ISquareBubbleSkinService bubbleSkinService = (ISquareBubbleSkinService) Square.INSTANCE.getConfig().getRapier().b(ISquareBubbleSkinService.class);

    SquareBubbleSkinService() {
    }

    public final void dressBubbleSkin(int bubbleId, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b();
        bVar.f417582a = bubbleId;
        bubbleSkinService.dressBubbleSkin(bVar).a(new com.tencent.rapier.b<c>() { // from class: com.tencent.state.square.bubblesetting.SquareBubbleSkinService$dressBubbleSkin$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareBubbleSkinService", "dressBubbleSkin: " + errorCode + ", " + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(c response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    public final void getBubbleSkin(final ResultCallback<ArrayList<SquareBubbleSkin>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        bubbleSkinService.getBubbleSkin(new f()).a(new com.tencent.rapier.b<g>() { // from class: com.tencent.state.square.bubblesetting.SquareBubbleSkinService$getBubbleSkin$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareBubbleSkinService", "getBubbleSkin: " + errorCode + ", " + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(g response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ArrayList arrayList = new ArrayList();
                for (a skin : response.f417585a) {
                    Intrinsics.checkNotNullExpressionValue(skin, "skin");
                    arrayList.add(SquareBubbleSkinKt.parse(skin));
                }
                ResultCallback.this.onResultSuccess(arrayList);
            }
        });
    }
}
