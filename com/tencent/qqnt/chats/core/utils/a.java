package com.tencent.qqnt.chats.core.utils;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.bizEvent.ChatBizConst$DTActionId;
import com.tencent.qqnt.chats.core.bizEvent.ChatBizEventManager;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/core/utils/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "", "b", "a", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "items", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;", "pageType", "c", "d", "e", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355091a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f355091a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        ChatBizEventManager a16 = ChatBizEventManager.INSTANCE.a();
        long m3 = item.m();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("click_recent_data", f355091a.f(item));
        Unit unit = Unit.INSTANCE;
        a16.g(new com.tencent.qqnt.chats.core.bizEvent.b(m3, linkedHashMap));
    }

    public final void b(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        ChatBizEventManager a16 = ChatBizEventManager.INSTANCE.a();
        long m3 = item.m();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("expo_recent_data", f355091a.f(item));
        Unit unit = Unit.INSTANCE;
        a16.i(new com.tencent.qqnt.chats.core.bizEvent.b(m3, linkedHashMap));
    }

    public final void c(@NotNull List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> items, @NotNull DTChatsConst.PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) items, (Object) pageType);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        if (pageType != DTChatsConst.PageType.MAIN) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.qqnt.chats.core.adapter.itemdata.b bVar : items) {
            if (bVar instanceof g) {
                a aVar = f355091a;
                g f16 = aVar.f((g) bVar);
                arrayList.add(f16);
                aVar.b(f16);
            }
        }
        ChatBizEventManager a16 = ChatBizEventManager.INSTANCE.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_action_id", ChatBizConst$DTActionId.ListExpo);
        linkedHashMap.put("dt_expo_data", arrayList);
        linkedHashMap.put("dt_expo_time", Long.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        a16.h(new com.tencent.qqnt.chats.core.bizEvent.b(68718498065L, linkedHashMap));
    }

    public final void d(@NotNull DTChatsConst.PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pageType);
            return;
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        if (pageType != DTChatsConst.PageType.MAIN) {
            return;
        }
        ChatBizEventManager a16 = ChatBizEventManager.INSTANCE.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_action_id", ChatBizConst$DTActionId.PageIn);
        linkedHashMap.put("dt_expo_time", Long.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        a16.h(new com.tencent.qqnt.chats.core.bizEvent.b(68718498065L, linkedHashMap));
    }

    public final void e(@NotNull DTChatsConst.PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pageType);
            return;
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        if (pageType != DTChatsConst.PageType.MAIN) {
            return;
        }
        ChatBizEventManager a16 = ChatBizEventManager.INSTANCE.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_action_id", ChatBizConst$DTActionId.PageOut);
        linkedHashMap.put("dt_expo_time", Long.valueOf(System.currentTimeMillis()));
        Unit unit = Unit.INSTANCE;
        a16.h(new com.tencent.qqnt.chats.core.bizEvent.b(68718498065L, linkedHashMap));
    }

    @NotNull
    public final g f(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        g f16 = item.f();
        f16.r().a(null);
        f16.U(new g.h());
        f16.R(new g.e(null, 1, null));
        f16.g().h(null);
        return f16;
    }
}
