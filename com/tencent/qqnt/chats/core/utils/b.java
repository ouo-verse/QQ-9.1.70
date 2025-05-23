package com.tencent.qqnt.chats.core.utils;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.kit.x2k.ChatRecentContactItemLayout;
import com.tencent.qqnt.chats.view.widget.DefaultRecentAvatarView;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pw3.d;
import pw3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002RH\u0010\u0014\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/core/utils/b;", "", "Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/tencent/qqnt/chats/kit/x2k/ChatRecentContactItemLayout;", "a", "Lpw3/e;", "b", "Lpw3/d;", "c", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lnw3/b;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getChatViewProviderClzMap", "()Ljava/util/HashMap;", "getChatViewProviderClzMap$annotations", "()V", "chatViewProviderClzMap", "", "", "Ljava/util/Map;", "chatViewProviderMap", "<init>", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f355092a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_PartViewProvider.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<nw3.b>> chatViewProviderClzMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, nw3.b> chatViewProviderMap;

    static {
        int mapCapacity;
        int mapCapacity2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f355092a = new b();
        HashMap<String, Class<nw3.b>> hashMap = new HashMap<>();
        chatViewProviderClzMap = hashMap;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(hashMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(Integer.parseInt((String) entry.getKey())), entry.getValue());
        }
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object newInstance = ((Class) entry2.getValue()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.ui.api.IChatViewProvider");
            linkedHashMap2.put(key, (nw3.b) newInstance);
        }
        chatViewProviderMap = linkedHashMap2;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r4 == null) goto L12;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ChatRecentContactItemLayout a(@NotNull LayoutInflater layoutInflater) {
        nw3.a defaultRecentAvatarView;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatRecentContactItemLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "layoutInflater.context");
        ChatRecentContactItemLayout chatRecentContactItemLayout = new ChatRecentContactItemLayout(context, null, i3, 0 == true ? 1 : 0);
        nw3.b bVar = chatViewProviderMap.get(1);
        if (bVar != null) {
            Context context2 = chatRecentContactItemLayout.f().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "avatar.context");
            defaultRecentAvatarView = bVar.a(context2);
        }
        Context context3 = chatRecentContactItemLayout.f().getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "avatar.context");
        defaultRecentAvatarView = new DefaultRecentAvatarView(context3);
        chatRecentContactItemLayout.f().m(defaultRecentAvatarView);
        return chatRecentContactItemLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        if (r0 == null) goto L12;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e b(@NotNull LayoutInflater layoutInflater) {
        nw3.a defaultRecentAvatarView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutInflater);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        e g16 = e.g(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        nw3.b bVar = chatViewProviderMap.get(1);
        if (bVar != null) {
            Context context = g16.f427811c.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "avatarLayout.context");
            defaultRecentAvatarView = bVar.a(context);
        }
        Context context2 = g16.f427811c.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "avatarLayout.context");
        defaultRecentAvatarView = new DefaultRecentAvatarView(context2);
        g16.f427811c.m(defaultRecentAvatarView);
        return g16;
    }

    @NotNull
    public final d c(@NotNull LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutInflater);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        d g16 = d.g(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        RecentAvatarViewWrapper recentAvatarViewWrapper = g16.f427805c;
        Context context = g16.f427805c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "avatarLayout.context");
        recentAvatarViewWrapper.m(new DefaultRecentAvatarView(context));
        return g16;
    }
}
