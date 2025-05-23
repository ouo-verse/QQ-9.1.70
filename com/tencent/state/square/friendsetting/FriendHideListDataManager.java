package com.tencent.state.square.friendsetting;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ls4.c;
import ls4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#JR\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JJ\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JK\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00072%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/friendsetting/FriendHideListDataManager;", "", "", "uin", "", "type", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "errorCode", "", "callback", "hide", "cancelHide", "pageSize", "lastId", "onlyUin", "Lkotlin/Function1;", "Lls4/c;", "getHideList", "MAX_HIDE_COUNT", "I", "curHideCount", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "uinSet", "Ljava/util/HashSet;", "Lcom/tencent/state/square/friendsetting/SettingService;", "service", "Lcom/tencent/state/square/friendsetting/SettingService;", "getService", "()Lcom/tencent/state/square/friendsetting/SettingService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FriendHideListDataManager {
    private static final int MAX_HIDE_COUNT = 30;
    private static int curHideCount;
    public static final FriendHideListDataManager INSTANCE = new FriendHideListDataManager();
    private static HashSet<Long> uinSet = new HashSet<>();
    private static final SettingService service = new SettingService();

    FriendHideListDataManager() {
    }

    public final void cancelHide(long uin, Function2<? super Boolean, ? super Integer, Unit> callback) {
        service.cancelHide(uin, callback);
    }

    public final void getHideList(int pageSize, long lastId, boolean onlyUin, final Function1<? super c, Unit> callback) {
        service.getHideList(pageSize, lastId, onlyUin, new Function1<c, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendHideListDataManager$getHideList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c cVar) {
                f[] fVarArr;
                HashSet hashSet;
                HashSet hashSet2;
                if (cVar != null && (fVarArr = cVar.f415518a) != null) {
                    FriendHideListDataManager friendHideListDataManager = FriendHideListDataManager.INSTANCE;
                    FriendHideListDataManager.curHideCount = fVarArr.length;
                    hashSet = FriendHideListDataManager.uinSet;
                    hashSet.clear();
                    for (f fVar : fVarArr) {
                        FriendHideListDataManager friendHideListDataManager2 = FriendHideListDataManager.INSTANCE;
                        hashSet2 = FriendHideListDataManager.uinSet;
                        hashSet2.add(Long.valueOf(fVar.f415524a));
                    }
                }
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }
        });
    }

    public final SettingService getService() {
        return service;
    }

    public final void hide(long uin, int type, Function2<? super Boolean, ? super Integer, Unit> callback) {
        service.hide(uin, type, callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cancelHide$default(FriendHideListDataManager friendHideListDataManager, long j3, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        friendHideListDataManager.cancelHide(j3, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hide$default(FriendHideListDataManager friendHideListDataManager, long j3, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        friendHideListDataManager.hide(j3, i3, function2);
    }

    public static /* synthetic */ void getHideList$default(FriendHideListDataManager friendHideListDataManager, int i3, long j3, boolean z16, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 30;
        }
        int i17 = i3;
        if ((i16 & 2) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        friendHideListDataManager.getHideList(i17, j16, z16, function1);
    }
}
