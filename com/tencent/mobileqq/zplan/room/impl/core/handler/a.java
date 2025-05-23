package com.tencent.mobileqq.zplan.room.impl.core.handler;

import com.tencent.qphone.base.util.QLog;
import iv4.f;
import iv4.l;
import jk3.c;
import jv4.e;
import jv4.k;
import jv4.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/core/handler/a;", "", "Ljv4/e;", "roomAction", "Ljk3/c;", "roomManager", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f335173a = new a();

    a() {
    }

    public final void a(e roomAction, c roomManager) {
        f fVar;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        Intrinsics.checkNotNullParameter(roomAction, "roomAction");
        Intrinsics.checkNotNullParameter(roomManager, "roomManager");
        QLog.i("ZPlanRoom_Manager_ActionHandler", 1, "handleRoomAction, actionType= " + roomAction.f411021c + ", actionId= " + roomAction.f411019a + ", version= " + roomAction.f411020b + "");
        switch (roomAction.f411021c) {
            case 100:
                k kVar = roomAction.f411022d;
                if (kVar == null || (fVar = kVar.f411039a) == null) {
                    return;
                }
                roomManager.E(fVar);
                return;
            case 101:
                jv4.l lVar5 = roomAction.f411023e;
                if (lVar5 == null || (lVar = lVar5.f411040a) == null) {
                    return;
                }
                roomManager.F(lVar);
                return;
            case 102:
                jk3.a.f410333a.g(roomManager.getRoomId());
                return;
            case 103:
                jv4.a aVar = roomAction.f411025g;
                if (aVar == null || (lVar2 = aVar.f411012a) == null) {
                    return;
                }
                roomManager.F(lVar2);
                return;
            case 104:
                jv4.c cVar = roomAction.f411026h;
                if (cVar == null || (lVar3 = cVar.f411014a) == null) {
                    return;
                }
                roomManager.F(lVar3);
                return;
            case 105:
                m mVar = roomAction.f411027i;
                if (mVar == null || (lVar4 = mVar.f411041a) == null) {
                    return;
                }
                roomManager.F(lVar4);
                return;
            default:
                return;
        }
    }
}
