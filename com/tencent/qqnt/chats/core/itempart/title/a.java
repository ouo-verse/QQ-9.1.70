package com.tencent.qqnt.chats.core.itempart.title;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.recent.gamemsgbox.i;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerChatTitleProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.TroopEmotionTitleProcessor;
import com.tencent.mobileqq.troop.recent.TroopIconTitleProcessor;
import com.tencent.mobileqq.vas.vipicon.RecentVipIconProcessor;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.utils.c;
import com.tencent.qqnt.classadapter.SingleLineTextView;
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
import u23.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/title/a;", "", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "titleView", "", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "b", "", "Lcom/tencent/qqnt/chats/inject/title/a;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_TitlePart.yml", version = 7)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.inject.title.a>> f354809c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.inject.title.a> mProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/title/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.itempart.title.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.inject.title.a>> arrayList = new ArrayList<>();
        f354809c = arrayList;
        arrayList.add(com.tencent.qqnt.mutualmark.processor.a.class);
        arrayList.add(gx3.a.class);
        arrayList.add(i.class);
        arrayList.add(QQStrangerChatTitleProcessor.class);
        arrayList.add(TroopIconTitleProcessor.class);
        arrayList.add(b.class);
        arrayList.add(RecentVipIconProcessor.class);
        arrayList.add(com.tencent.qqnt.chats.biz.guild.i.class);
        arrayList.add(jv1.a.class);
        arrayList.add(TroopEmotionTitleProcessor.class);
        arrayList.add(com.tencent.mobileqq.troop.flame.processor.a.class);
        arrayList.add(com.tencent.mobileqq.troop.troopmedal.b.class);
    }

    public a() {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.chats.inject.title.a>> arrayList = f354809c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.inject.title.ITitleProcessor");
            arrayList2.add((com.tencent.qqnt.chats.inject.title.a) newInstance);
        }
        this.mProcessorList = arrayList2;
    }

    private final void a(SingleLineTextView titleView) {
        titleView.setForMsgListDenoise(true);
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        Context context = titleView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
        titleView.setTextColor(chatsColorCache.h(context));
        Context context2 = titleView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "titleView.context");
        titleView.setExtendTextColor(chatsColorCache.i(context2), 0);
        titleView.setIconDrawables(null, false);
        titleView.setCompoundDrawables(null, null, null);
        titleView.setDrawableRight2(null);
        titleView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        titleView.getPaint().setShader(null);
        titleView.setTypeface(Typeface.defaultFromStyle(0));
        titleView.stop();
    }

    public final void b(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        SingleLineTextView m3 = holder.y().m();
        ImageView n3 = holder.y().n();
        float a16 = com.tencent.qqnt.chats.tmp.a.a();
        a(m3);
        m3.setGravity(16);
        m3.setForMsgListDenoise(true);
        int i3 = (int) (4 * a16);
        m3.setCompoundDrawablePadding(i3);
        m3.setIconDrawablePadding(i3, (int) (1 * a16));
        int i16 = 0;
        m3.setExtendTextPadding((int) (a16 * 5), 0);
        m3.setExtendTextSize(17.0f, 2);
        m3.setText(item.w().e());
        c.d(m3, item);
        if (item.w().b() == null) {
            b16 = "";
        } else {
            b16 = item.w().b();
        }
        m3.setExtendText(b16, 2);
        if (n3 != null) {
            if (item.w().c() != null) {
                Integer c16 = item.w().c();
                Intrinsics.checkNotNull(c16);
                n3.setImageResource(c16.intValue());
                n3.setVisibility(0);
            } else {
                n3.setVisibility(8);
                n3.setColorFilter((ColorFilter) null);
            }
        }
        if (item.q().getBoolean("is_first_data", false)) {
            return;
        }
        List<com.tencent.qqnt.chats.inject.title.a> list = this.mProcessorList;
        StringBuilder sb5 = new StringBuilder("TitlePart");
        sb5.append('-');
        Intrinsics.checkNotNullExpressionValue(sb5, "StringBuilder(TAG).append('-')");
        for (Object obj : list) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.qqnt.chats.inject.title.a) obj).a(item, m3);
            i16 = i17;
        }
    }
}
