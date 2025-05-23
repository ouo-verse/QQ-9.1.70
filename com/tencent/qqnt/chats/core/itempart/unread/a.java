package com.tencent.qqnt.chats.core.itempart.unread;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.quibadge.a;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.process.b;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import fy.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/unread/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "", "c", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "view", "Landroid/view/View;", "root", "", "isAvatarUnread", "b", "unreadView", "isTypeDotRed", "a", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "d", "", "Lcom/tencent/qqnt/chats/inject/unread/a;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_UnreadPart.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.inject.unread.a>> f354812c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HighFreqLogUtil f354813d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.inject.unread.a> mProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/unread/a$a;", "", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/qphone/base/util/HighFreqLogUtil;", "freLog", "Lcom/tencent/qphone/base/util/HighFreqLogUtil;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.itempart.unread.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.inject.unread.a>> arrayList = new ArrayList<>();
        f354812c = arrayList;
        arrayList.add(b.class);
        arrayList.add(com.tencent.qqnt.chats.main.ui.processor.a.class);
        arrayList.add(c.class);
        arrayList.add(x.class);
        f354813d = new HighFreqLogUtil(2);
    }

    public a() {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.chats.inject.unread.a>> arrayList = f354812c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.inject.unread.IUnreadProcessor");
            arrayList2.add((com.tencent.qqnt.chats.inject.unread.a) newInstance);
        }
        this.mProcessorList = arrayList2;
    }

    private final void a(QUIBadge unreadView, boolean isTypeDotRed, boolean isAvatarUnread) {
        boolean z16;
        float f16;
        float f17;
        if (isAvatarUnread) {
            return;
        }
        if ((unreadView.getParent() instanceof FrameLayout) && unreadView.getId() == R.id.f114236ss) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = unreadView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (isTypeDotRed) {
            f16 = 4.0f;
        } else {
            f16 = 3.0f;
        }
        int dpToPx = ViewUtils.dpToPx(f16);
        if (isTypeDotRed) {
            f17 = 5.2f;
        } else {
            f17 = 2.0f;
        }
        int dpToPx2 = ViewUtils.dpToPx(f17);
        if (layoutParams2.topMargin != dpToPx || layoutParams2.getMarginEnd() != dpToPx2) {
            layoutParams2.topMargin = dpToPx;
            layoutParams2.setMarginEnd(dpToPx2);
            unreadView.setLayoutParams(layoutParams2);
        }
    }

    private final void b(g item, QUIBadge view, View root, boolean isAvatarUnread) {
        int b16 = (int) item.x().b();
        if (b16 > 0) {
            view.setTag(R.id.f114236ss, 1);
            view.setDragType(0);
            view.setVisibility(0);
        } else {
            view.setDragType(-1);
            view.setVisibility(8);
        }
        view.setFixMinSize();
        int c16 = item.x().c();
        if (c16 != 1) {
            if (c16 != 2) {
                view.setRedDot();
                a(view, true, isAvatarUnread);
                return;
            } else {
                view.setGrayNum(b16);
                a(view, false, isAvatarUnread);
                return;
            }
        }
        view.setRedNum(b16);
        a(view, false, isAvatarUnread);
    }

    private final void c(RecentContactItemBinding binding) {
        binding.o().setTag(R.id.f114236ss, null);
        a.C8448a.a(binding.o(), null, null, 3, null);
    }

    public final void d(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        QUIBadge avatarUnread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        String w3 = cq.w(item.w().e(), 3);
        f354813d.d("UnreadPart", 1, "[updateUnread] title=" + cq.w(w3, 2) + ",unreadCnt=" + item.s().unreadCnt + ", unread=" + item.x().b());
        RecentContactItemBinding y16 = holder.y();
        c(y16);
        int i3 = 0;
        b(item, y16.o(), y16.i(), false);
        y16.o().setTag(R.id.ucb, Long.valueOf(item.m()));
        com.tencent.qqnt.chats.utils.c.d(y16.o(), item);
        if ((y16.a() instanceof nw3.c) && (avatarUnread = y16.a().getAvatarUnread()) != null) {
            b(item, avatarUnread, y16.i(), true);
            GuildLayoutManager guildLayoutManager = GuildLayoutManager.f354256a;
            if (guildLayoutManager.s() && item.x().b() > 0) {
                float p16 = guildLayoutManager.p();
                float h16 = guildLayoutManager.h();
                avatarUnread.setPivotX(com.tencent.qqnt.chats.core.utils.c.INSTANCE.a((int) item.x().b()));
                avatarUnread.setScaleX(h16);
                avatarUnread.setScaleY(h16);
                avatarUnread.setAlpha(p16);
                y16.a().setTopRightHole(avatarUnread.getLayoutParams().width * p16, avatarUnread.getLayoutParams().height * p16, true);
                avatarUnread.setVisibility(0);
            } else {
                y16.a().setTopRightHole(0.0f, 0.0f, true);
                avatarUnread.setVisibility(8);
            }
        }
        List<com.tencent.qqnt.chats.inject.unread.a> list = this.mProcessorList;
        StringBuilder sb5 = new StringBuilder("UnreadPart");
        sb5.append('-');
        Intrinsics.checkNotNullExpressionValue(sb5, "StringBuilder(TAG).append('-')");
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.qqnt.chats.inject.unread.a) obj).a(item, y16.o(), y16.l());
            i3 = i16;
        }
        if (com.tencent.qqnt.chats.core.itempart.c.f(item, holder)) {
            holder.y().o().setVisibility(8);
        }
    }
}
