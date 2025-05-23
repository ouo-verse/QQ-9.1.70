package com.tencent.qqnt.chats.core.itempart.summary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.nt.chat.b;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jv1.c;
import jv1.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/summary/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "", "a", "", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_SummaryPart.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.inject.summary.a>> f354802c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.inject.summary.a> mProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/summary/a$a;", "", "Landroid/view/View;", "view", "", "resetSummary", "", "a", "", "TAG", "Ljava/lang/String;", "Landroid/content/res/ColorStateList;", "textColor", "Landroid/content/res/ColorStateList;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.itempart.summary.a$a, reason: collision with other inner class name and from kotlin metadata */
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

        public static /* synthetic */ void b(Companion companion, View view, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            companion.a(view, z16);
        }

        public final void a(@NotNull View view, boolean resetSummary) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(resetSummary));
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            ColorStateList g16 = chatsColorCache.g(context);
            if (view instanceof SingleLineTextView) {
                SingleLineTextView singleLineTextView = (SingleLineTextView) view;
                singleLineTextView.setExtendTextPadding((int) (com.tencent.qqnt.chats.tmp.a.a() * 2), 1);
                singleLineTextView.setExtendTextSize(14.0f, 1);
                singleLineTextView.setExtendText("", 1);
                singleLineTextView.setTextColor(g16);
                singleLineTextView.setExtendTextColor(g16, 1);
                singleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                return;
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setTextColor(g16);
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (view instanceof com.tencent.qqnt.chats.view.a) {
                ((com.tencent.qqnt.chats.view.a) view).b(resetSummary);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46831);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.inject.summary.a>> arrayList = new ArrayList<>();
        f354802c = arrayList;
        arrayList.add(com.tencent.qqnt.chats.core.itempart.summary.processor.a.class);
        arrayList.add(d.class);
        arrayList.add(u23.a.class);
        arrayList.add(c.class);
        arrayList.add(j.class);
        arrayList.add(b.class);
    }

    public a() {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.chats.inject.summary.a>> arrayList = f354802c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.inject.summary.ISummaryProcessor");
            arrayList2.add((com.tencent.qqnt.chats.inject.summary.a) newInstance);
        }
        this.mProcessorList = arrayList2;
    }

    public final void a(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        INSTANCE.a(holder.y().k(), !com.tencent.qqnt.chats.core.itempart.c.f(item, holder));
        com.tencent.qqnt.chats.utils.c.d(holder.y().k(), item);
        if (com.tencent.qqnt.chats.core.itempart.c.f(item, holder)) {
            return;
        }
        List<com.tencent.qqnt.chats.inject.summary.a> list = this.mProcessorList;
        StringBuilder sb5 = new StringBuilder("SummaryPart");
        sb5.append('-');
        Intrinsics.checkNotNullExpressionValue(sb5, "StringBuilder(TAG).append('-')");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.qqnt.chats.inject.summary.a) obj).a(item, holder.y().k());
            i3 = i16;
        }
    }
}
