package com.tencent.qqnt.chats.core.itempart.avatar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.avatar.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.inject.avatar.c;
import com.tencent.qqnt.chats.main.lightbusiness.reveal.LIAWorldRingRevealProcessor;
import com.tencent.qqnt.chats.view.api.IRecentAvatarApi;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jv1.b;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "", "Lnw3/a;", "avatar", "", "a", "c", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "d", "", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Ljava/util/List;", "b", "()Ljava/util/List;", "mProviderList", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "mProcessorList", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_AvatarPart.yml", version = 7)
    @NotNull
    private static final ArrayList<Class<c>> f354775d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_AvatarPart.yml", version = 7)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.inject.avatar.a>> f354776e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> mProviderList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.inject.avatar.a> mProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/avatar/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.itempart.avatar.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<c>> arrayList = new ArrayList<>();
        f354775d = arrayList;
        arrayList.add(zz2.a.class);
        arrayList.add(com.tencent.qqnt.chats.core.itempart.avatar.processor.a.class);
        arrayList.add(b.class);
        arrayList.add(ic2.a.class);
        arrayList.add(com.tencent.qqnt.chats.main.lightbusiness.reveal.a.class);
        arrayList.add(LIAWorldRingRevealProcessor.class);
        arrayList.add(com.tencent.mobileqq.activity.recent.gamemsgbox.a.class);
        arrayList.add(com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.b.class);
        ArrayList<Class<com.tencent.qqnt.chats.inject.avatar.a>> arrayList2 = new ArrayList<>();
        f354776e = arrayList2;
        arrayList2.add(com.tencent.qqnt.chats.core.itempart.avatar.provider.a.class);
        arrayList2.add(com.tencent.qqnt.chats.core.itempart.avatar.provider.c.class);
        arrayList2.add(com.tencent.mobileqq.activity.bless.a.class);
        arrayList2.add(ja2.a.class);
        arrayList2.add(com.tencent.mobileqq.activity.notifyservice.b.class);
        arrayList2.add(d.class);
        arrayList2.add(com.tencent.mobileqq.activity.recent.gamemsgbox.b.class);
        arrayList2.add(com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.c.class);
        arrayList2.add(com.tencent.qqnt.chats.core.itempart.avatar.provider.b.class);
    }

    public a() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Object first;
        Object first2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.chats.inject.avatar.a>> arrayList = f354776e;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first2 = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first2).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.inject.avatar.IAvatarProvider");
            arrayList2.add((c) newInstance);
        }
        this.mProviderList = arrayList2;
        ArrayList<Class<c>> arrayList3 = f354775d;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            Constructor<?>[] constructors2 = ((Class) it5.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors2, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors2);
            Object newInstance2 = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type com.tencent.qqnt.chats.inject.avatar.IAvatarProcessor");
            arrayList4.add((com.tencent.qqnt.chats.inject.avatar.a) newInstance2);
        }
        this.mProcessorList = arrayList4;
    }

    private final void a(nw3.a avatar) {
        ViewParent parent = avatar.getAvatarLayout().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup.getLayerType() == 2 && viewGroup.isHardwareAccelerated()) {
            viewGroup.invalidate();
        }
    }

    private final void c(nw3.a avatar) {
        boolean z16;
        ImageView d16;
        ViewGroup.LayoutParams layoutParams;
        IRecentAvatarApi iRecentAvatarApi = (IRecentAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRecentAvatarApi.class);
        Context context = avatar.getAvatarLayout().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "avatar.getAvatarLayout().context");
        int recentAvatarSize = iRecentAvatarApi.getRecentAvatarSize(context);
        if (avatar instanceof nw3.c) {
            nw3.c cVar = (nw3.c) avatar;
            Object c16 = cVar.c();
            if ((c16 instanceof View) && (layoutParams = ((View) c16).getLayoutParams()) != null) {
                layoutParams.width = recentAvatarSize;
                layoutParams.height = recentAvatarSize;
            }
            if (cVar.f()) {
                ImageView d17 = cVar.d();
                if (d17 != null && d17.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (d16 = cVar.d()) != null) {
                    d16.setImageResource(0);
                    d16.setBackgroundResource(0);
                    d16.setVisibility(8);
                }
            }
        }
        ViewGroup.LayoutParams layoutParams2 = avatar.getAvatarView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = recentAvatarSize;
            layoutParams2.height = recentAvatarSize;
        }
        ImageView avatarView = avatar.getAvatarView();
        if (avatarView instanceof RoundRectImageView) {
            ((RoundRectImageView) avatarView).setCornerRadiusAndMode(0, 0);
        }
    }

    @NotNull
    public final List<c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mProviderList;
    }

    public final void d(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        nw3.a a16 = holder.y().a();
        c(a16);
        a16.getAvatarView().setTag(R.id.x8s, Long.valueOf(item.l()));
        com.tencent.qqnt.chats.utils.c.d(a16.getAvatarView(), item);
        Iterator<c> it = this.mProviderList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (next.b(item)) {
                next.c(item, a16.getAvatarView());
                break;
            }
        }
        List<com.tencent.qqnt.chats.inject.avatar.a> list = this.mProcessorList;
        StringBuilder sb5 = new StringBuilder("AvatarPart");
        sb5.append("-Proc-");
        Intrinsics.checkNotNullExpressionValue(sb5, "StringBuilder(TAG).append(\"-Proc-\")");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.qqnt.chats.inject.avatar.a) obj).a(item, a16);
            i3 = i16;
        }
        if (ChatsListConfig.f354433a.d()) {
            a(a16);
        }
    }
}
