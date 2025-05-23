package com.tencent.qqnt.chats.core.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b.\u0010/J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J#\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015H\u0016R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R(\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010'R(\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsVBUpdateControlHelper;", "Lcom/tencent/qqnt/chats/core/ui/o;", "", "uin", "", "", "payload", "", "j", "(Ljava/lang/String;[Ljava/lang/Object;)V", "uid", "k", "l", "onBackground", "onForeground", "", "b", "f", "([Ljava/lang/Object;)V", "a", "c", "", "uins", "e", "uids", "d", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "list", "g", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "_adapter", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "_rv", "Z", "_isBackground", "", "", "Ljava/util/Map;", "_cacheUinMap", "_cacheUidMap", "_notifyAllUpdate", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "_updateAction", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;Landroidx/recyclerview/widget/RecyclerView;)V", tl.h.F, "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsVBUpdateControlHelper implements o {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsListAdapter _adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView _rv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean _isBackground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Set<Object>> _cacheUinMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Set<Object>> _cacheUidMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean _notifyAllUpdate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable _updateAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsVBUpdateControlHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.ChatsVBUpdateControlHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsVBUpdateControlHelper(@NotNull ChatsListAdapter _adapter, @NotNull RecyclerView _rv) {
        Intrinsics.checkNotNullParameter(_adapter, "_adapter");
        Intrinsics.checkNotNullParameter(_rv, "_rv");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) _adapter, (Object) _rv);
            return;
        }
        this._adapter = _adapter;
        this._rv = _rv;
        this._isBackground = true;
        this._cacheUinMap = new LinkedHashMap();
        this._cacheUidMap = new LinkedHashMap();
        this._updateAction = new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                ChatsVBUpdateControlHelper.i(ChatsVBUpdateControlHelper.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ChatsVBUpdateControlHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0._notifyAllUpdate && this$0._cacheUidMap.isEmpty() && this$0._cacheUinMap.isEmpty()) {
            return;
        }
        ChatsListAdapter chatsListAdapter = this$0._adapter;
        chatsListAdapter.submitList(chatsListAdapter.z0());
    }

    private final void j(String uin, Object... payload) {
        Set<Object> set = this._cacheUinMap.get(uin);
        if (set == null) {
            set = new LinkedHashSet<>();
            this._cacheUinMap.put(uin, set);
        }
        CollectionsKt__MutableCollectionsKt.addAll(set, payload);
    }

    private final void k(String uid, Object... payload) {
        Set<Object> set = this._cacheUidMap.get(uid);
        if (set == null) {
            set = new LinkedHashSet<>();
            this._cacheUidMap.put(uid, set);
        }
        CollectionsKt__MutableCollectionsKt.addAll(set, payload);
    }

    private final void l(Object payload) {
        RecyclerView.LayoutManager layoutManager = this._rv.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager2 = this._rv.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        this._adapter.notifyItemRangeChanged(Math.max(0, findFirstVisibleItemPosition - 2), (Math.min(((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition() + 2, this._adapter.getNUM_BACKGOURND_ICON()) - findFirstVisibleItemPosition) + 1, payload);
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void a(@NotNull final String uin, @Nullable Object payload) {
        List<Object> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (this._isBackground) {
            if (!this._notifyAllUpdate) {
                Object[] objArr = new Object[1];
                if (payload == null) {
                    payload = com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a;
                }
                objArr[0] = payload;
                j(uin, objArr);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatsVBUpdateControlHelper", 2, "[notifyItemPartChanged] call when background");
                return;
            }
            return;
        }
        ChatsListAdapter chatsListAdapter = this._adapter;
        RecyclerView recyclerView = this._rv;
        Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> function1 = new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>(uin) { // from class: com.tencent.qqnt.chats.core.ui.ChatsVBUpdateControlHelper$notifyItemPartChanged$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uin = uin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) uin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(it.l()), this.$uin));
            }
        };
        if (payload != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(payload);
        } else {
            mutableListOf = null;
        }
        chatsListAdapter.I0(recyclerView, function1, mutableListOf);
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this._isBackground;
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void c(@NotNull final String uid, @Nullable Object payload) {
        List<Object> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uid, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (this._isBackground) {
            if (!this._notifyAllUpdate) {
                Object[] objArr = new Object[1];
                if (payload == null) {
                    payload = com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a;
                }
                objArr[0] = payload;
                k(uid, objArr);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatsVBUpdateControlHelper", 2, "[notifyItemPartChangedByUid] call when background");
                return;
            }
            return;
        }
        ChatsListAdapter chatsListAdapter = this._adapter;
        RecyclerView recyclerView = this._rv;
        Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> function1 = new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>(uid) { // from class: com.tencent.qqnt.chats.core.ui.ChatsVBUpdateControlHelper$notifyItemPartChangedByUid$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uid = uid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) uid);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.k(), this.$uid));
            }
        };
        if (payload != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(payload);
        } else {
            mutableListOf = null;
        }
        chatsListAdapter.I0(recyclerView, function1, mutableListOf);
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void d(@NotNull List<String> uids, @Nullable Object payload) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uids, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        if (uids.isEmpty()) {
            return;
        }
        if (this._isBackground) {
            if (!this._notifyAllUpdate) {
                for (String str : uids) {
                    Object[] objArr = new Object[1];
                    if (payload == null) {
                        obj = com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a;
                    } else {
                        obj = payload;
                    }
                    objArr[0] = obj;
                    k(str, objArr);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatsVBUpdateControlHelper", 2, "[notifyItemRangePartChangedByUid] call when background");
                return;
            }
            return;
        }
        if (uids.size() < 4) {
            Iterator<T> it = uids.iterator();
            while (it.hasNext()) {
                c((String) it.next(), payload);
            }
            return;
        }
        l(payload);
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void e(@NotNull List<String> uins, @Nullable Object payload) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uins, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        if (uins.isEmpty()) {
            return;
        }
        if (this._isBackground) {
            if (!this._notifyAllUpdate) {
                for (String str : uins) {
                    Object[] objArr = new Object[1];
                    if (payload == null) {
                        obj = com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a;
                    } else {
                        obj = payload;
                    }
                    objArr[0] = obj;
                    j(str, objArr);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatsVBUpdateControlHelper", 2, "[notifyItemRangePartChanged] call when background");
                return;
            }
            return;
        }
        if (uins.size() < 4) {
            Iterator<T> it = uins.iterator();
            while (it.hasNext()) {
                a((String) it.next(), payload);
            }
            return;
        }
        l(payload);
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void f(@NotNull Object... payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) payload);
            return;
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        boolean z16 = true;
        if (this._isBackground) {
            this._notifyAllUpdate = true;
            return;
        }
        if (payload.length != 0) {
            z16 = false;
        }
        if (z16) {
            this._adapter.notifyDataSetChanged();
            return;
        }
        for (Object obj : payload) {
            this._adapter.H0(obj);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void g(@Nullable List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        if (!this._notifyAllUpdate && this._cacheUidMap.isEmpty() && this._cacheUinMap.isEmpty()) {
            return;
        }
        QLog.d("ChatsVBUpdateControlHelper", 1, "[preHandleSubmitList] need to update");
        StopWatch i3 = new StopWatch("ChatsVBUpdateControlHelper-ChatsVBUpdateControlHelper", !com.tencent.qqnt.util.b.f362976b.isPublicVersion()).i();
        if (list != null) {
            for (com.tencent.qqnt.chats.core.adapter.itemdata.b bVar : list) {
                if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    if (this._notifyAllUpdate) {
                        ((com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar).j().add(com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a);
                    } else {
                        if (!this._cacheUidMap.isEmpty()) {
                            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
                            Set<Object> set = this._cacheUidMap.get(gVar.k());
                            if (set != null) {
                                gVar.j().addAll(set);
                            }
                        }
                        if (!this._cacheUinMap.isEmpty()) {
                            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
                            Set<Object> set2 = this._cacheUinMap.get(String.valueOf(gVar2.l()));
                            if (set2 != null) {
                                gVar2.j().addAll(set2);
                            }
                        }
                    }
                }
            }
        }
        this._notifyAllUpdate = false;
        this._cacheUidMap.clear();
        this._cacheUinMap.clear();
        i3.b("preHandleSubmitList");
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void onBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this._isBackground = true;
            this._rv.removeCallbacks(this._updateAction);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.o
    public void onForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this._isBackground = false;
        if (this._notifyAllUpdate || (!this._cacheUinMap.isEmpty()) || (!this._cacheUidMap.isEmpty())) {
            this._rv.postDelayed(this._updateAction, 200L);
        }
    }
}
