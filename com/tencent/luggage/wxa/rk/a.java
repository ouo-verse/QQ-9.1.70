package com.tencent.luggage.wxa.rk;

import com.tencent.luggage.wxa.hn.ae;
import com.tencent.luggage.wxa.hn.fi;
import com.tencent.luggage.wxa.hn.gi;
import com.tencent.luggage.wxa.hn.n9;
import com.tencent.luggage.wxa.i5.c;
import com.tencent.luggage.wxa.i5.d;
import com.tencent.luggage.wxa.tn.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f139822a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f139823b = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6689a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f139824a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f139825b;

        /* renamed from: d, reason: collision with root package name */
        public int f139827d;

        public C6689a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f139825b = obj;
            this.f139827d |= Integer.MIN_VALUE;
            return a.this.a((String) null, this);
        }
    }

    public final boolean a(int i3) {
        return i3 == 0 || 1 == i3 || 7 == i3;
    }

    public final void a(String str, fi fiVar) {
        w.d("MicroMsg.AppBrand.UserInfoRevokeRepository", "injectCachedUsageInfo, appId: " + str);
        if (str == null || fiVar == null) {
            return;
        }
        f139823b.put(str, fiVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation continuation) {
        C6689a c6689a;
        Object coroutine_suspended;
        int i3;
        fi fiVar;
        if (continuation instanceof C6689a) {
            c6689a = (C6689a) continuation;
            int i16 = c6689a.f139827d;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                c6689a.f139827d = i16 - Integer.MIN_VALUE;
                Object obj = c6689a.f139825b;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = c6689a.f139827d;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    w.d("MicroMsg.AppBrand.UserInfoRevokeRepository", "getUsageInfo, appId: " + str);
                    fi fiVar2 = (fi) f139823b.get(str);
                    if (fiVar2 != null) {
                        w.d("MicroMsg.AppBrand.UserInfoRevokeRepository", "getUsageInfo, cache hit");
                        return fiVar2;
                    }
                    c cVar = c.f129475b;
                    c6689a.f139824a = str;
                    c6689a.f139827d = 1;
                    obj = cVar.a(str, c6689a);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) c6689a.f139824a;
                    ResultKt.throwOnFailure(obj);
                }
                fiVar = ((ae) obj).f127301g;
                if (fiVar == null) {
                    f139823b.put(str, fiVar);
                    return fiVar;
                }
                throw new IOException("use_user_info is null");
            }
        }
        c6689a = new C6689a(continuation);
        Object obj2 = c6689a.f139825b;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = c6689a.f139827d;
        if (i3 != 0) {
        }
        fiVar = ((ae) obj2).f127301g;
        if (fiVar == null) {
        }
    }

    public final boolean a(fi fiVar) {
        boolean z16;
        LinkedList<gi> linkedList;
        LinkedList linkedList2;
        LinkedList scope_item_list;
        LinkedList linkedList3;
        LinkedList linkedList4;
        if (fiVar == null || !a(fiVar.f127650d)) {
            return false;
        }
        gi giVar = fiVar.f127650d;
        if (giVar != null && (linkedList4 = giVar.f127728g) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : linkedList4) {
                if (f139822a.a((n9) obj)) {
                    arrayList.add(obj);
                }
            }
            linkedList4.clear();
            linkedList4.addAll(arrayList);
        }
        gi giVar2 = fiVar.f127650d;
        boolean z17 = (giVar2 == null || (linkedList3 = giVar2.f127728g) == null || linkedList3.isEmpty()) ? false : true;
        LinkedList linkedList5 = fiVar.f127651e;
        if (!((linkedList5 == null || linkedList5.isEmpty()) ? false : true) || (linkedList = fiVar.f127651e) == null) {
            z16 = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : linkedList) {
                if (f139822a.a((gi) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            linkedList.clear();
            linkedList.addAll(arrayList2);
            z16 = false;
            for (gi giVar3 : linkedList) {
                if (giVar3 != null && (scope_item_list = giVar3.f127728g) != null) {
                    Intrinsics.checkNotNullExpressionValue(scope_item_list, "scope_item_list");
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : scope_item_list) {
                        if (f139822a.a((n9) obj3)) {
                            arrayList3.add(obj3);
                        }
                    }
                    scope_item_list.clear();
                    scope_item_list.addAll(arrayList3);
                }
                if ((giVar3 == null || (linkedList2 = giVar3.f127728g) == null || linkedList2.isEmpty()) ? false : true) {
                    z16 = true;
                }
            }
        }
        return z17 || z16;
    }

    public final boolean a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        String str = giVar.f127725d;
        return !(str == null || str.length() == 0);
    }

    public final boolean a(n9 n9Var) {
        if (n9Var == null) {
            return false;
        }
        String str = n9Var.f128271d;
        return !(str == null || str.length() == 0) && a(n9Var.f128273f);
    }

    public final Object a(String str, String str2, Continuation continuation) {
        Object coroutine_suspended;
        w.d("MicroMsg.AppBrand.UserInfoRevokeRepository", "revokeAppUseUserInfo, appId: " + str + ", scope: " + str2);
        if (str != null && str2 != null) {
            Object a16 = d.f129477b.a(str, str2, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return a16 == coroutine_suspended ? a16 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object a(String str, String str2, String str3, Continuation continuation) {
        Object coroutine_suspended;
        w.d("MicroMsg.AppBrand.UserInfoRevokeRepository", "revokePluginUseUserInfo, appId: " + str + ", pluginAppId: " + str2 + ", scope: " + str3);
        if (str != null && str2 != null && str3 != null) {
            Object a16 = d.f129477b.a(str, str2, str3, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return a16 == coroutine_suspended ? a16 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
