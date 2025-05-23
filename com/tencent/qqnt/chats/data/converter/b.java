package com.tencent.qqnt.chats.data.converter;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import com.dataline.nt.DataLineConvertProcessor;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.activateFriend.u;
import com.tencent.mobileqq.activity.recent.gamemsgbox.w;
import com.tencent.mobileqq.channel.node.ChannelConvertProcessor;
import com.tencent.mobileqq.chat.SubAccountAssistantConvertProcessor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.publicaccount.PublicAccountConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\t\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0019J1\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b#\u0010$R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chats/data/converter/b;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "charSequence", "", "j", "state", "l", "i", "", "Lcom/tencent/qqnt/chats/data/converter/f;", "dataPayLoad", "Lcom/tencent/qqnt/chats/data/converter/c;", "f", "([Lcom/tencent/qqnt/chats/data/converter/f;)Lcom/tencent/qqnt/chats/data/converter/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;", "ext", "a", "", "isTop", "", "e", "isDraft", "d", "isFirst", "g", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;[Lcom/tencent/qqnt/chats/data/converter/f;Z)Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "I", "c", "()I", "listType", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "getBeforeConvert", "()Lkotlin/jvm/functions/Function1;", "setBeforeConvert", "(Lkotlin/jvm/functions/Function1;)V", "beforeConvert", "Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "avatarPart", "<init>", "(I)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ConvertProcessor.yml", version = 9)
    @NotNull
    private static final ArrayList<Class<e>> f355112e;

    /* renamed from: f */
    @NotNull
    private static final List<e> f355113f;

    /* renamed from: a, reason: from kotlin metadata */
    private final int listType;

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Unit> beforeConvert;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.avatar.a avatarPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/data/converter/b$a;", "", "", "TAG", "Ljava/lang/String;", "", "Lcom/tencent/qqnt/chats/data/converter/e;", "processorList", "Ljava/util/List;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.data.converter.b$a, reason: from kotlin metadata */
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
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<e>> arrayList = new ArrayList<>();
        f355112e = arrayList;
        arrayList.add(SubAccountAssistantConvertProcessor.class);
        arrayList.add(com.tencent.qqnt.chats.data.processor.b.class);
        arrayList.add(com.tencent.qqnt.chats.data.processor.a.class);
        arrayList.add(PublicAccountConvertProcessor.class);
        arrayList.add(com.tencent.qqnt.chats.biz.guild.c.class);
        arrayList.add(com.tencent.qqnt.chats.biz.guildhelper.c.class);
        arrayList.add(hw3.b.class);
        arrayList.add(w.class);
        arrayList.add(com.tencent.mobileqq.activity.recent.gamemsgbox.c.class);
        arrayList.add(ChannelConvertProcessor.class);
        arrayList.add(com.tencent.mobileqq.activity.bless.b.class);
        arrayList.add(u.class);
        arrayList.add(DataLineConvertProcessor.class);
        arrayList.add(com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.d.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.data.converter.IConvertProcessor");
            arrayList2.add((e) newInstance);
        }
        f355113f = arrayList2;
    }

    public b() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    public static /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g b(b bVar, RecentContactInfo recentContactInfo, LocalChatsCacheDataSource.b bVar2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar2 = new LocalChatsCacheDataSource.b(false, false, null, false, false, 31, null);
        }
        return bVar.a(recentContactInfo, bVar2);
    }

    private final c f(f[] dataPayLoad) {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        c cVar = new c(context);
        cVar.f(dataPayLoad);
        cVar.e(this.listType);
        return cVar;
    }

    public static /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g h(b bVar, com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, f[] fVarArr, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return bVar.g(gVar, fVarArr, z16);
    }

    private final void i(com.tencent.qqnt.chats.core.adapter.itemdata.g r46) {
        for (com.tencent.qqnt.chats.inject.avatar.c cVar : this.avatarPart.b()) {
            if (cVar.b(r46)) {
                Drawable a16 = cVar.a(r46);
                if (a16 != null) {
                    r46.g().h(a16);
                    return;
                }
                return;
            }
        }
    }

    private final int j(CharSequence charSequence) {
        Spannable spannable;
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = null;
        }
        if (spannable == null) {
            return 0;
        }
        Object[] spans = spannable.getSpans(0, spannable.length(), IEmoticonSpanRefreshCallback.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(\n         \u2026:class.java\n            )");
        int i3 = 0;
        for (Object obj : spans) {
            if (((IEmoticonSpanRefreshCallback) obj).getDrawable() != null) {
                i3++;
            }
        }
        return i3;
    }

    private final void k(com.tencent.qqnt.chats.core.adapter.itemdata.g r16) {
        i(r16);
        m(r16);
        l(r16.v().h());
    }

    private final void l(int state) {
        com.tencent.qqnt.chats.utils.c cVar = com.tencent.qqnt.chats.utils.c.f355544a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        cVar.b(context, state);
    }

    private final void m(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        CharSequence charSequence;
        int j3 = j(gVar.v().f()) + 0;
        g.c c16 = gVar.v().c();
        if (c16 != null) {
            charSequence = c16.b();
        } else {
            charSequence = null;
        }
        int j16 = j3 + j(charSequence);
        if (QLog.isDebugVersion() && j16 > 0) {
            QLog.d("ChatsItemConverter", 4, "[preloadEmoji] count=" + j16);
        }
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.itemdata.g a(@NotNull RecentContactInfo contact, @NotNull LocalChatsCacheDataSource.b ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 6, (Object) this, (Object) contact, (Object) ext);
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(ext, "ext");
        long j3 = contact.contactId;
        int i3 = contact.chatType;
        String peerUid = contact.peerUid;
        String str = contact.avatarPath;
        Intrinsics.checkNotNullExpressionValue(str, "contact.avatarPath");
        g.a aVar = new g.a(0, str, null, null, 13, null);
        boolean e16 = e(contact.topFlag);
        int i16 = contact.sendStatus;
        boolean d16 = d(contact.draftFlag);
        ArrayList<Long> nestedSortedContactList = contact.nestedSortedContactList;
        ArrayList<RecentContactInfo> arrayList = contact.nestedChangedList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "contact.nestedChangedList");
        ArrayList arrayList2 = new ArrayList();
        for (RecentContactInfo it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.qqnt.chats.core.adapter.itemdata.g a16 = a(it, ext);
            if (a16 != null) {
                arrayList2.add(a16);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        boolean z16 = contact.isMsgDisturb;
        long j16 = contact.shieldFlag;
        byte b16 = contact.specialCareFlag;
        long j17 = contact.peerUin;
        ArrayList<RecentContactExtAttr> arrayList4 = contact.extAttrs;
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        Intrinsics.checkNotNullExpressionValue(nestedSortedContactList, "nestedSortedContactList");
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = new com.tencent.qqnt.chats.core.adapter.itemdata.g(contact, j3, i3, peerUid, aVar, null, null, null, null, null, e16, d16, i16, nestedSortedContactList, arrayList3, z16, j16, b16, j17, false, arrayList4, 525280, null);
        if (ext.b()) {
            gVar.q().putBoolean("is_first_data", true);
        }
        if (ext.d()) {
            gVar.q().putBoolean("is_local_cache_data", true);
        }
        Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Unit> function1 = this.beforeConvert;
        if (function1 != null) {
            function1.invoke(gVar);
        }
        return g(gVar, null, ext.b());
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.listType;
    }

    public final boolean d(byte isDraft) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Byte.valueOf(isDraft))).booleanValue();
        }
        if (1 != isDraft) {
            return false;
        }
        return true;
    }

    public final boolean e(byte isTop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Byte.valueOf(isTop))).booleanValue();
        }
        if (1 != isTop) {
            return false;
        }
        return true;
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.itemdata.g g(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g r65, @Nullable f[] dataPayLoad, boolean isFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.g) iPatchRedirector.redirect((short) 9, this, r65, dataPayLoad, Boolean.valueOf(isFirst));
        }
        Intrinsics.checkNotNullParameter(r65, "item");
        c f16 = f(dataPayLoad);
        try {
            for (e eVar : f355113f) {
                if (eVar.match(r65)) {
                    if (isFirst) {
                        eVar.update(r65, f16, true);
                    } else {
                        eVar.update(r65, f16);
                    }
                    k(r65);
                    return r65;
                }
            }
            QLog.d("ChatsItemConverter", 1, "[partUpdate] no processor match, item: {uid=" + r65.k() + ", uin=" + r65.l() + ", chatType=" + r65.n() + "}");
            return null;
        } catch (Throwable th5) {
            if (!QLog.isDebugVersion() && !QLog.isDevelopLevel()) {
                QLog.e("ChatsItemConverter", 1, "[partUpdate] throw exception: ", th5);
                return null;
            }
            throw th5;
        }
    }

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.listType = i3;
            this.avatarPart = new com.tencent.qqnt.chats.core.itempart.avatar.a();
        }
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
