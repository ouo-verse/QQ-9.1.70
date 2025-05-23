package com.tencent.mobileqq.nearbypro.chats.repo;

import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002J5\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002J)\u0010\u0010\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "", "Lkotlin/Function1;", "Lpp4/b;", "Lkotlin/ParameterName;", "name", "rsp", "", "callback", "g", "", "withExtraInfo", "", "d", "Lcom/tencent/mobileqq/nearbypro/request/d;", "rspStatus", "i", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    public static /* synthetic */ void e(d dVar, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        dVar.d(z16, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, tp4.b bVar) {
        Integer num;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        ga2.a c16 = j.c();
        Integer num2 = null;
        if (bVar != null) {
            num = Integer.valueOf(bVar.f437068b);
        } else {
            num = null;
        }
        c16.e("AioListRepo", "status: " + rspStatus + ", count: " + num);
        if (bVar != null) {
            num2 = Integer.valueOf(bVar.f437068b);
        }
        callback.invoke(num2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, wp4.b bVar) {
        pp4.b bVar2;
        pp4.b[] bVarArr;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "<anonymous parameter 1>");
        if (bVar != null && (bVarArr = bVar.f446036b) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(bVarArr);
            bVar2 = (pp4.b) firstOrNull;
        } else {
            bVar2 = null;
        }
        callback.invoke(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, tp4.d dVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        callback.invoke(rspStatus);
    }

    public final void d(boolean withExtraInfo, @NotNull final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new NBPInteractiveGetUnreadMsgRequest(withExtraInfo), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.chats.repo.a
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                d.f(Function1.this, (NearbyProBaseRequest) obj, rspStatus, (tp4.b) obj2);
            }
        });
    }

    public final void g(@NotNull final Function1<? super pp4.b, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new NBPInteractiveRequest(1, new byte[0]), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.chats.repo.b
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                d.h(Function1.this, (NearbyProBaseRequest) obj, rspStatus, (wp4.b) obj2);
            }
        });
    }

    public final void i(@NotNull final Function1<? super RspStatus, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new NBPMarkAsReadRequest(), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.chats.repo.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                d.j(Function1.this, (NearbyProBaseRequest) obj, rspStatus, (tp4.d) obj2);
            }
        });
    }
}
