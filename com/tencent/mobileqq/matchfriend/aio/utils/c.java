package com.tencent.mobileqq.matchfriend.aio.utils;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.utils.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\tJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000bH\u0002J/\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\n\u0010\u0018\u001a\u00020\u0002*\u00020\u0017R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/utils/c;", "", "", "eid", "", "level", "tag", "", "g", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "e", "", "b", "a", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/util/Map;", "traceId", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "l", "k", "j", "i", "Lcom/tencent/aio/api/runtime/a;", "c", "Ljava/lang/String;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f243986a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String traceId = "";

    c() {
    }

    private final Map<String, Object> a(Long level, String tag) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (level != null) {
            linkedHashMap.put("kl_tag_level", Long.valueOf(level.longValue()));
        }
        if (tag != null) {
            linkedHashMap.put("kl_tag_id", tag);
        }
        return linkedHashMap;
    }

    private final Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        hashMap.put("kl_new_to_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getFriendOpenId());
        if (traceId.length() > 0) {
            hashMap.put("recom_trace", traceId);
        }
        return hashMap;
    }

    private final void e(String eid, Long level, String tag) {
        List<String> listOf;
        try {
            Result.Companion companion = Result.INSTANCE;
            d dVar = new d(QBaseActivity.sTopActivity);
            c cVar = f243986a;
            dVar.c("pg_kl_new_chat_page", cVar.b());
            listOf = CollectionsKt__CollectionsJVMKt.listOf(eid);
            dVar.b(listOf);
            dVar.e(eid, cVar.a(level, tag));
            Result.m476constructorimpl(dVar);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    private final void g(String eid, Long level, String tag) {
        List<String> listOf;
        try {
            Result.Companion companion = Result.INSTANCE;
            d dVar = new d(QBaseActivity.sTopActivity);
            c cVar = f243986a;
            dVar.c("pg_kl_new_chat_page", cVar.b());
            listOf = CollectionsKt__CollectionsJVMKt.listOf(eid);
            dVar.b(listOf);
            dVar.g(eid, cVar.a(level, tag));
            Result.m476constructorimpl(dVar);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final String c(com.tencent.aio.api.runtime.a aVar) {
        FragmentActivity activity;
        Intent intent;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Fragment c16 = aVar.c();
        String stringExtra = (c16 == null || (activity = c16.getActivity()) == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("recom_trace");
        return stringExtra == null ? "" : stringExtra;
    }

    public final void d(String traceId2) {
        Intrinsics.checkNotNullParameter(traceId2, "traceId");
        traceId = traceId2;
    }

    public final void f(long level, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        g("em_kl_get_intimate_tag", Long.valueOf(level), tag);
    }

    public final void i(long level, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        e("em_kl_intimate_tag_detail_pop", Long.valueOf(level), tag);
    }

    public final void j(long level, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        g("em_kl_intimate_tag_detail_pop", Long.valueOf(level), tag);
    }

    public final void k(long level, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        e("em_kl_nickname_tag", Long.valueOf(level), tag);
    }

    public final void l(long level, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        g("em_kl_nickname_tag", Long.valueOf(level), tag);
    }

    public final void m() {
        h(this, "em_kl_chat_value_tag", null, null, 6, null);
    }

    static /* synthetic */ void h(c cVar, String str, Long l3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            l3 = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        cVar.g(str, l3, str2);
    }
}
