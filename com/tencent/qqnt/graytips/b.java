package com.tencent.qqnt.graytips;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqnt.graytips.handler.CommonMsgNavActionHandler;
import com.tencent.qqnt.graytips.handler.GroupMemberTempChatGroupProfileActionHandler;
import com.tencent.qqnt.graytips.handler.GroupMemberTempChatSettingActionHandler;
import com.tencent.qqnt.graytips.handler.PttGuideGrayActionHandler;
import com.tencent.qqnt.graytips.handler.SchemeActionHandler;
import com.tencent.qqnt.graytips.handler.UploadFileVipPerceptionOver1GHandler;
import com.tencent.qqnt.graytips.handler.UploadFileVipPerceptionOverLimitHandler;
import com.tencent.qqnt.graytips.handler.UserForAddFriendActionHandler;
import com.tencent.qqnt.graytips.handler.WebActionHandler;
import com.tencent.qqnt.graytips.handler.e;
import com.tencent.qqnt.graytips.handler.f;
import com.tencent.qqnt.graytips.handler.g;
import com.tencent.qqnt.graytips.handler.h;
import com.tencent.qqnt.graytips.handler.i;
import com.tencent.qqnt.graytips.handler.j;
import com.tencent.qqnt.graytips.handler.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR*\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R2\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/graytips/b;", "", "", "actionType", "Lcom/tencent/qqnt/graytips/handler/b;", "a", "Lcom/tencent/qqnt/graytips/action/h;", "actionInfo", "Lcom/tencent/qqnt/graytips/handler/c;", "b", "", "c", "Lcom/tencent/qqnt/graytips/d;", "Lcom/tencent/qqnt/graytips/d;", "actionHandlerProvider", "", "Ljava/lang/Class;", "Ljava/util/Map;", "actionClzMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "actionHandlerMap", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f356812a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/AIO/tips/gray_tips_inject_config.yml", version = 1)
    @Nullable
    private static d actionHandlerProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<Integer, Class<? extends com.tencent.qqnt.graytips.handler.b>> actionClzMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Integer, com.tencent.qqnt.graytips.handler.b> actionHandlerMap;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList f356816e;

    static {
        Map<Integer, Class<? extends com.tencent.qqnt.graytips.handler.b>> mutableMapOf;
        Map<Integer, Class<? extends com.tencent.qqnt.graytips.handler.b>> a16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f356816e = arrayList;
        arrayList.add(com.tencent.qqnt.msg.graytip.a.class);
        b bVar = new b();
        f356812a = bVar;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, WebActionHandler.class), TuplesKt.to(3, SchemeActionHandler.class), TuplesKt.to(78, j.class), TuplesKt.to(44, g.class), TuplesKt.to(70, UserForAddFriendActionHandler.class), TuplesKt.to(82, GroupMemberTempChatGroupProfileActionHandler.class), TuplesKt.to(85, GroupMemberTempChatSettingActionHandler.class), TuplesKt.to(79, i.class), TuplesKt.to(80, h.class), TuplesKt.to(64, f.class), TuplesKt.to(41, PttGuideGrayActionHandler.class), TuplesKt.to(84, e.class), TuplesKt.to(90, UploadFileVipPerceptionOverLimitHandler.class), TuplesKt.to(91, UploadFileVipPerceptionOver1GHandler.class), TuplesKt.to(93, CommonMsgNavActionHandler.class), TuplesKt.to(100, k.class), TuplesKt.to(101, com.tencent.qqnt.graytips.handler.d.class));
        actionClzMap = mutableMapOf;
        actionHandlerMap = new HashMap<>();
        bVar.c();
        d dVar = actionHandlerProvider;
        if (dVar != null && (a16 = dVar.a()) != null) {
            actionClzMap.putAll(a16);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final com.tencent.qqnt.graytips.handler.b a(int actionType) {
        com.tencent.qqnt.graytips.handler.b bVar = actionHandlerMap.get(Integer.valueOf(actionType));
        if (bVar != null) {
            return bVar;
        }
        Class<? extends com.tencent.qqnt.graytips.handler.b> cls = actionClzMap.get(Integer.valueOf(actionType));
        if (cls == null) {
            return null;
        }
        synchronized (f356812a) {
            com.tencent.qqnt.graytips.handler.b bVar2 = actionHandlerMap.get(Integer.valueOf(actionType));
            if (bVar2 != null) {
                return bVar2;
            }
            com.tencent.qqnt.graytips.handler.b newInstance = cls.newInstance();
            if (newInstance == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(newInstance, "clz.newInstance() ?: return null");
            actionHandlerMap.put(Integer.valueOf(actionType), newInstance);
            return newInstance;
        }
    }

    @JvmStatic
    @Nullable
    public static final com.tencent.qqnt.graytips.handler.c b(@NotNull com.tencent.qqnt.graytips.action.h actionInfo) {
        Map<Long, com.tencent.qqnt.graytips.handler.c> c16;
        Map<Long, com.tencent.qqnt.graytips.handler.c> b16;
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (actionInfo.a().isServer) {
            d dVar = actionHandlerProvider;
            if (dVar == null || (b16 = dVar.b()) == null) {
                return null;
            }
            return b16.get(Long.valueOf(actionInfo.a().busiId));
        }
        d dVar2 = actionHandlerProvider;
        if (dVar2 == null || (c16 = dVar2.c()) == null) {
            return null;
        }
        return c16.get(Long.valueOf(actionInfo.a().busiId));
    }

    @QAutoInitMethod
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            actionHandlerProvider = (d) com.tencent.mobileqq.qroute.utils.b.a(f356816e);
        }
    }
}
