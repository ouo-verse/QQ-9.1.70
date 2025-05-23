package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.list.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u001a4\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f\u001a0\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u001a=\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a$\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"BEAN", "EXTRA", "Lcom/tencent/ecommerce/base/list/h;", "Lcom/tencent/ecommerce/base/list/IStateCenterView;", "stateView", "", "emptyTip", "errorMsg", "", "e", "Lcom/tencent/ecommerce/base/list/IStateRefreshView;", "refreshView", "", "visibleToList", "c", "Lcom/tencent/ecommerce/base/list/IStateListAdapter;", "adapter", "b", "Lcom/tencent/ecommerce/base/list/ISuspendStateListAdapter;", "g", "(Lcom/tencent/ecommerce/base/list/h;Lcom/tencent/ecommerce/base/list/ISuspendStateListAdapter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class UIStateKt {
    private static final <BEAN, EXTRA> boolean a(h<BEAN, EXTRA> hVar) {
        if (!hVar.a().isEmpty()) {
            c cVar = hVar.listUiState;
            if ((cVar instanceof c.g) || Intrinsics.areEqual(cVar, c.i.f100785a) || Intrinsics.areEqual(cVar, c.j.f100786a) || Intrinsics.areEqual(cVar, c.h.f100784a) || Intrinsics.areEqual(cVar, c.b.f100778a) || Intrinsics.areEqual(cVar, c.C1031c.f100779a) || Intrinsics.areEqual(cVar, c.a.f100777a)) {
                return true;
            }
        }
        return false;
    }

    public static final <BEAN, EXTRA> void b(h<BEAN, EXTRA> hVar, IStateListAdapter<BEAN> iStateListAdapter) {
        if (a(hVar)) {
            iStateListAdapter.setData(hVar.a());
        }
    }

    public static final <BEAN, EXTRA> void c(h<BEAN, EXTRA> hVar, IStateRefreshView iStateRefreshView, boolean z16) {
        iStateRefreshView.setVisible(a(hVar), z16);
        iStateRefreshView.updateHasMore(hVar.hasMore);
        c cVar = hVar.listUiState;
        if (cVar instanceof c.j) {
            iStateRefreshView.finishRefresh(true);
            return;
        }
        if (cVar instanceof c.h) {
            iStateRefreshView.finishRefresh(false);
            return;
        }
        if (cVar instanceof c.C1031c) {
            iStateRefreshView.finishLoadMore(true);
            return;
        }
        if (cVar instanceof c.a) {
            iStateRefreshView.finishLoadMore(false);
            return;
        }
        if (cVar instanceof c.d) {
            iStateRefreshView.finishRefresh(true);
        } else if (cVar instanceof c.g) {
            iStateRefreshView.finishRefresh(true);
        } else if (cVar instanceof c.e) {
            iStateRefreshView.finishRefresh(false);
        }
    }

    public static final <BEAN, EXTRA> void e(h<BEAN, EXTRA> hVar, IStateCenterView iStateCenterView, String str, String str2) {
        c cVar = hVar.listUiState;
        if (cVar instanceof c.f) {
            IStateCenterView.a.c(iStateCenterView, null, 1, null);
            return;
        }
        if (cVar instanceof c.d) {
            IStateCenterView.a.a(iStateCenterView, str, null, 0, 6, null);
            return;
        }
        if (cVar instanceof c.e) {
            iStateCenterView.setFailedState(str2);
        } else {
            if ((cVar instanceof c.i) || Intrinsics.areEqual(cVar, c.h.f100784a)) {
                return;
            }
            iStateCenterView.setSucceededState();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <BEAN, EXTRA> Object g(h<BEAN, EXTRA> hVar, ISuspendStateListAdapter<BEAN> iSuspendStateListAdapter, Continuation<? super Unit> continuation) {
        UIStateKt$updateToSuspendListAdapter$1 uIStateKt$updateToSuspendListAdapter$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof UIStateKt$updateToSuspendListAdapter$1) {
            uIStateKt$updateToSuspendListAdapter$1 = (UIStateKt$updateToSuspendListAdapter$1) continuation;
            int i16 = uIStateKt$updateToSuspendListAdapter$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                uIStateKt$updateToSuspendListAdapter$1.label = i16 - Integer.MIN_VALUE;
                Object obj = uIStateKt$updateToSuspendListAdapter$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = uIStateKt$updateToSuspendListAdapter$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (a(hVar)) {
                        List<BEAN> a16 = hVar.a();
                        uIStateKt$updateToSuspendListAdapter$1.label = 1;
                        if (iSuspendStateListAdapter.setData(a16, uIStateKt$updateToSuspendListAdapter$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        uIStateKt$updateToSuspendListAdapter$1 = new UIStateKt$updateToSuspendListAdapter$1(continuation);
        Object obj2 = uIStateKt$updateToSuspendListAdapter$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = uIStateKt$updateToSuspendListAdapter$1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void f(h hVar, IStateCenterView iStateCenterView, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        e(hVar, iStateCenterView, str, str2);
    }

    public static /* synthetic */ void d(h hVar, IStateRefreshView iStateRefreshView, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        c(hVar, iStateRefreshView, z16);
    }
}
