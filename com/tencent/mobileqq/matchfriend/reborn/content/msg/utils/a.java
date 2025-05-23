package com.tencent.mobileqq.matchfriend.reborn.content.msg.utils;

import android.content.Context;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.utils.d;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/utils/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "a", "", "elementId", "", "params", "", "d", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f244870a = new a();

    a() {
    }

    private final d a(Context context) {
        Map<String, Object> mapOf;
        d dVar = new d(context);
        String selfOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId();
        if (selfOpenId == null) {
            selfOpenId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(selfOpenId, "QRoute.api(IMatchFriendC\u2026ss.java).selfOpenId ?: \"\"");
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_new_from_openid", selfOpenId));
        dVar.c("pg_kl_new_chat_list", mapOf);
        return dVar;
    }

    public final void b(Context context, String elementId, Map<String, String> params) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        d a16 = a(context);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(elementId);
        a16.b(listOf);
        a16.e(elementId, params);
    }

    public final void d(Context context, String elementId, Map<String, String> params) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        d a16 = a(context);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(elementId);
        a16.b(listOf);
        a16.g(elementId, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, Context context, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.b(context, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(a aVar, Context context, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.d(context, str, map);
    }
}
