package com.tencent.state.square.resource;

import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.detail.MainScene;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jo\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/resource/ISquareRoleManager;", "", "addMultiRoles", "", "list", "", "Lcom/tencent/state/square/MoveItem;", "from", "", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "sceneType", "needToast", "", "needLocateTo", "callback", "Lkotlin/Function1;", "", "Lcom/tencent/state/square/MoveResult;", "(Ljava/util/List;ILcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;ZZLkotlin/jvm/functions/Function1;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareRoleManager {
    void addMultiRoles(List<MoveItem> list, int from, MainScene mainScene, Integer sceneType, boolean needToast, boolean needLocateTo, Function1<? super Map<MoveItem, MoveResult>, Unit> callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void addMultiRoles$default(ISquareRoleManager iSquareRoleManager, List list, int i3, MainScene mainScene, Integer num, boolean z16, boolean z17, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                iSquareRoleManager.addMultiRoles(list, i3, mainScene, (i16 & 8) != 0 ? null : num, (i16 & 16) != 0 ? true : z16, (i16 & 32) != 0 ? true : z17, (i16 & 64) != 0 ? null : function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMultiRoles");
        }
    }
}
