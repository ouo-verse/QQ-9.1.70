package com.tencent.qqnt.chats.core.ui;

import androidx.annotation.UiThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.ui.highlight.HighLightManager;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\n*B'\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00102\u001a\u000200\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J,\u0010\u0011\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0002J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fJ\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u0016\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0002J\u0010\u0010&\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010'\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00101R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00103R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00103R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010:R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010:R$\u0010A\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010=\u001a\u0004\b*\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "", "", "l", "", DomainData.DOMAIN_NAME, "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "data", "isAllUpdate", "a", "p", "", "serverCount", "partRefresh", "Lcom/tencent/qqnt/chats/data/a;", "changeInfo", ReportConstant.COSTREPORT_PREFIX, "o", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "dy", "fromEdge", "g", "newState", "i", "forUnread", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "contactInfo", "r", "d", com.tencent.luggage.wxa.c8.c.G, "offset", "e", "k", "j", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "b", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "adapter", "Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;", "highLightManager", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$b;", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$b;", "callback", "Z", "isTopDataLoading", "isBottomDataLoading", "isJumpLoading", tl.h.F, "isTopDataLoadEnabled", "isBottomDataLoadEnabled", "I", "firstLoadedPos", "lastLoadedPos", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "curUnreadInfo", "", "J", "loadReqTime", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;Lcom/tencent/qqnt/chats/core/ui/highlight/HighLightManager;Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$b;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
@UiThread
/* loaded from: classes24.dex */
public final class ChatsDataLoadHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView rv;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsListAdapter adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HighLightManager highLightManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isTopDataLoading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isBottomDataLoading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isJumpLoading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isTopDataLoadEnabled;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isBottomDataLoadEnabled;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int firstLoadedPos;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int lastLoadedPos;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecentContactInfo curUnreadInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long loadReqTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$a;", "", "", "COUNT", "I", "HALF_COUNT", "MIN_PRELOAD_COUNT", "PRELOAD_COUNT", "REQ_TIMEOUT_IN_MS", "", "TAG", "Ljava/lang/String;", "TAG_INDEX_END_NOT_FOUND", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.ChatsDataLoadHelper$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper$b;", "", "", "fetchOld", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "preLoadEnabled", "lastLoadEnabled", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a(boolean fetchOld, int pos, @Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g item);

        void b(boolean preLoadEnabled, boolean lastLoadEnabled);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsDataLoadHelper(@NotNull RecyclerView rv5, @NotNull ChatsListAdapter adapter, @NotNull HighLightManager highLightManager, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(rv5, "rv");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(highLightManager, "highLightManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rv5, adapter, highLightManager, callback);
            return;
        }
        this.rv = rv5;
        this.adapter = adapter;
        this.highLightManager = highLightManager;
        this.callback = callback;
        this.isBottomDataLoadEnabled = true;
        this.lastLoadedPos = 199;
        this.loadReqTime = System.currentTimeMillis();
    }

    public static /* synthetic */ void h(ChatsDataLoadHelper chatsDataLoadHelper, RecyclerView recyclerView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        chatsDataLoadHelper.g(recyclerView, i3, z16);
    }

    private final boolean l() {
        boolean z16;
        if (!this.isTopDataLoading && !this.isBottomDataLoading && !this.isJumpLoading) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && System.currentTimeMillis() - this.loadReqTime > 10000) {
            QLog.d("ChatsRecentContactLoadHelper", 1, "[isDataLoading] timeout. isTopDataLoading=" + this.isTopDataLoading + ", isBottomDataLoading=" + this.isBottomDataLoading + ", isJumpLoading=" + this.isJumpLoading);
            return false;
        }
        return z16;
    }

    private final void n() {
        this.loadReqTime = System.currentTimeMillis();
    }

    public final boolean a(@NotNull List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> data, boolean isAllUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, data, Boolean.valueOf(isAllUpdate))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if ((!this.isTopDataLoading && !this.isBottomDataLoading) || isAllUpdate) {
            return true;
        }
        return false;
    }

    @Nullable
    public final RecentContactInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.curUnreadInfo;
    }

    public final int c(boolean forUnread, @Nullable RecentContactInfo item) {
        Object orNull;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        Object orNull2;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2;
        Object orNull3;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(forUnread), item)).intValue();
        }
        RecyclerView.LayoutManager layoutManager = this.rv.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (forUnread) {
            if (!this.isBottomDataLoadEnabled) {
                if (findLastVisibleItemPosition != this.adapter.getCurrentList().size() - 1) {
                    int size = this.adapter.getCurrentList().size();
                    for (int i3 = findFirstVisibleItemPosition; i3 < size; i3++) {
                        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList = this.adapter.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
                        orNull3 = CollectionsKt___CollectionsKt.getOrNull(currentList, i3);
                        if (orNull3 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                            gVar3 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) orNull3;
                        } else {
                            gVar3 = null;
                        }
                        if (gVar3 != null && i3 != findFirstVisibleItemPosition && gVar3.x().b() > 0 && gVar3.x().c() == 1) {
                            return i3;
                        }
                    }
                }
                this.curUnreadInfo = null;
                return -2;
            }
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                int i16 = findFirstVisibleItemPosition;
                while (true) {
                    List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList2 = this.adapter.getCurrentList();
                    Intrinsics.checkNotNullExpressionValue(currentList2, "adapter.currentList");
                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(currentList2, i16);
                    if (orNull2 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                        gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) orNull2;
                    } else {
                        gVar2 = null;
                    }
                    if (gVar2 != null) {
                        if (i16 != findFirstVisibleItemPosition && gVar2.x().b() > 0 && gVar2.x().c() == 1) {
                            return i16;
                        }
                        if (i16 == findLastVisibleItemPosition) {
                            this.curUnreadInfo = gVar2.s();
                        }
                    }
                    if (i16 != findLastVisibleItemPosition) {
                        i16++;
                    } else {
                        return -1;
                    }
                }
            } else {
                return -1;
            }
        } else {
            if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                return -1;
            }
            while (true) {
                List<com.tencent.qqnt.chats.core.adapter.itemdata.b> currentList3 = this.adapter.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList3, "adapter.currentList");
                orNull = CollectionsKt___CollectionsKt.getOrNull(currentList3, findFirstVisibleItemPosition);
                if (orNull instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) orNull;
                } else {
                    gVar = null;
                }
                if (gVar != null && item != null && com.tencent.qqnt.chats.utils.f.f355547a.a(gVar, item)) {
                    return findFirstVisibleItemPosition;
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition++;
                } else {
                    return -1;
                }
            }
        }
    }

    public final boolean d(@NotNull RecentContactInfo item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (l()) {
            return false;
        }
        int c16 = c(false, item);
        this.highLightManager.k(item);
        if (c16 >= 0) {
            this.isJumpLoading = false;
            com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(this.rv, c16);
            ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).moveToNext(true);
            return false;
        }
        this.isJumpLoading = true;
        n();
        this.highLightManager.n(3);
        return true;
    }

    public final void e(int pos, int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(pos), Integer.valueOf(offset));
            return;
        }
        QLog.d("ChatsRecentContactLoadHelper", 1, "[handleScrollToCallback] curPos=" + pos + " offset=" + offset);
        if (pos > -1) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.rv.getLayoutManager();
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(pos, offset);
            }
            this.highLightManager.l(-1);
            this.highLightManager.m(0);
            this.highLightManager.n(0);
        }
    }

    public final void f(@Nullable final RecentContactInfo item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) item);
            return;
        }
        if (this.highLightManager.g() && !this.isTopDataLoadEnabled) {
            this.rv.scrollToPosition(0);
            this.highLightManager.j();
            return;
        }
        if (item == null) {
            this.highLightManager.j();
            this.isJumpLoading = false;
            return;
        }
        if (this.highLightManager.g()) {
            this.rv.scrollToPosition(0);
            this.highLightManager.j();
            this.isJumpLoading = false;
            return;
        }
        int u06 = this.adapter.u0(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>() { // from class: com.tencent.qqnt.chats.core.ui.ChatsDataLoadHelper$handleScrollToCallback$index$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
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
                return Boolean.valueOf(com.tencent.qqnt.chats.utils.f.f355547a.a(it, RecentContactInfo.this));
            }
        });
        this.highLightManager.k(item);
        if (u06 >= 0) {
            this.isJumpLoading = false;
            com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(this.rv, u06);
            if (this.highLightManager.f()) {
                ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).moveToNext(true);
            }
        }
    }

    public final void g(@NotNull RecyclerView rv5, int dy5, boolean fromEdge) {
        int i3;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        g.f w3;
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2;
        g.f w16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, rv5, Integer.valueOf(dy5), Boolean.valueOf(fromEdge));
            return;
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        String str = null;
        this.curUnreadInfo = null;
        if (GuildLayoutManager.f354256a.r()) {
            return;
        }
        int max = Math.max(this.adapter.getNUM_BACKGOURND_ICON() - 50, 75);
        if (dy5 < 0) {
            if (!l() && this.isTopDataLoadEnabled) {
                RecyclerView.LayoutManager layoutManager = rv5.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition - this.adapter.getHeaderCount() <= 50) {
                    int min = Math.min(150, this.adapter.A0());
                    com.tencent.qqnt.chats.core.adapter.itemdata.b y06 = this.adapter.y0(min);
                    if (y06 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                        gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) y06;
                    } else {
                        gVar2 = null;
                    }
                    this.isTopDataLoading = true;
                    n();
                    if (gVar2 != null && (w16 = gVar2.w()) != null) {
                        str = w16.e();
                    }
                    QLog.d("ChatsRecentContactLoadHelper", 1, "[handleScrollToLoadData] top-load startLoad: targetPos=" + min + ",topTriggerPreloadPos=50, curFirstPos=" + findFirstVisibleItemPosition + ", info=" + str + ", fromEdge=" + fromEdge);
                    this.callback.a(false, min, gVar2);
                    g.f354937a.c(0);
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("ChatsRecentContactLoadHelper-test", 4, "[handleScrollToLoadData] topPos=50, curFirst=" + findFirstVisibleItemPosition + ", fromEdge=" + fromEdge);
                    return;
                }
                return;
            }
            return;
        }
        if (dy5 > 0 && !l() && this.isBottomDataLoadEnabled) {
            RecyclerView.LayoutManager layoutManager2 = rv5.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
            if (findLastVisibleItemPosition != -1 && findLastVisibleItemPosition >= max) {
                int i16 = (max - 100) - 1;
                if (this.adapter.A0() < 100) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                int max2 = Math.max(i16, i3);
                com.tencent.qqnt.chats.core.adapter.itemdata.b y07 = this.adapter.y0(max2);
                if (y07 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                    gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) y07;
                } else {
                    gVar = null;
                }
                if (max2 == 0) {
                    this.isTopDataLoading = true;
                    this.isBottomDataLoading = false;
                } else {
                    this.isBottomDataLoading = true;
                }
                n();
                if (gVar != null && (w3 = gVar.w()) != null) {
                    str = w3.e();
                }
                QLog.d("ChatsRecentContactLoadHelper", 1, "[handleScrollToLoadData] bottom-load startLoad: targetPos=" + max2 + ", bottomTriggerPreloadPos=" + max + ", curLastPos=" + findLastVisibleItemPosition + ", info=" + str + ", fromEdge=" + fromEdge);
                this.callback.a(true, max2, gVar);
                g.f354937a.c(1);
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("ChatsRecentContactLoadHelper-test", 4, "[handleScrollToLoadData] bottomPos=" + max + ", curLastPos=" + findLastVisibleItemPosition + ", fromEdge=" + fromEdge);
            }
        }
    }

    public final void i(@NotNull RecyclerView rv5, int newState) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) rv5, newState);
            return;
        }
        Intrinsics.checkNotNullParameter(rv5, "rv");
        if (rv5.getY() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        g(rv5, -((int) rv5.getY()), true);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (l()) {
            return false;
        }
        int c16 = c(true, this.curUnreadInfo);
        if (c16 >= 0) {
            this.isJumpLoading = false;
            com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(this.rv, c16);
            return false;
        }
        if (c16 == -2) {
            this.isJumpLoading = false;
            k();
            return false;
        }
        this.isJumpLoading = true;
        n();
        this.highLightManager.n(2);
        return true;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (l()) {
            return;
        }
        if (!this.isTopDataLoadEnabled) {
            RecyclerView.LayoutManager layoutManager = this.rv.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() > 10) {
                this.rv.scrollToPosition(0);
            } else {
                com.tencent.qqnt.chats.core.ui.widget.b.INSTANCE.a(this.rv, 0);
            }
            this.isJumpLoading = false;
            return;
        }
        this.isTopDataLoadEnabled = false;
        this.isBottomDataLoadEnabled = true;
        this.callback.b(false, true);
        this.isJumpLoading = true;
        n();
        this.highLightManager.n(1);
        this.callback.a(true, 0, null);
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return !this.isTopDataLoadEnabled;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.isTopDataLoading = false;
        this.isBottomDataLoading = false;
        this.isJumpLoading = false;
        g.f354937a.b(false);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.isTopDataLoadEnabled) {
            this.isTopDataLoadEnabled = false;
            this.isBottomDataLoadEnabled = false;
            this.callback.b(false, false);
        }
    }

    public final void q(@Nullable RecentContactInfo recentContactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recentContactInfo);
        } else {
            this.curUnreadInfo = recentContactInfo;
        }
    }

    public final void r(@NotNull RecentContactInfo contactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) contactInfo);
        } else {
            Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
            this.highLightManager.k(contactInfo);
        }
    }

    public final void s(@NotNull List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> data, int serverCount, boolean partRefresh, @NotNull com.tencent.qqnt.chats.data.a changeInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, data, Integer.valueOf(serverCount), Boolean.valueOf(partRefresh), changeInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        if (partRefresh) {
            if (!this.isBottomDataLoadEnabled) {
                if (serverCount == 200) {
                    z17 = true;
                }
                this.isBottomDataLoadEnabled = z17;
            }
            QLog.d("ChatsRecentContactLoadHelper", 1, "[updateCurrentRange] partRefresh, actual bottom enabled=" + this.isBottomDataLoadEnabled);
            return;
        }
        if (GuildLayoutManager.f354256a.r()) {
            QLog.d("ChatsRecentContactLoadHelper", 1, "[updateCurrentRange] isDisplayGuildFrameLayoutCompletely");
            o();
            this.callback.b(false, false);
            return;
        }
        int headerCount = this.adapter.getHeaderCount();
        this.firstLoadedPos = headerCount;
        this.lastLoadedPos = headerCount + data.size();
        this.curUnreadInfo = null;
        QLog.d("ChatsRecentContactLoadHelper", 1, "[updateCurrentRange] allUpdate before, isTopDataLoading=" + this.isTopDataLoading + ", isBottomDataLoading=" + this.isBottomDataLoading + ", isJumpLoading=" + this.isJumpLoading + ", serverCount=" + serverCount + ", location=" + changeInfo.a() + ", moreAtBottom=" + changeInfo.b());
        int a16 = changeInfo.a();
        if (a16 != 0 && a16 != -1) {
            if (this.isTopDataLoading) {
                if (a16 != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isTopDataLoadEnabled = z16;
                if (serverCount >= 100) {
                    z17 = true;
                }
                this.isBottomDataLoadEnabled = z17;
            } else if (a16 == 1) {
                this.isTopDataLoadEnabled = false;
                if (serverCount == 200) {
                    z17 = true;
                }
                this.isBottomDataLoadEnabled = z17;
            } else {
                if (a16 != 2) {
                    z17 = true;
                }
                this.isBottomDataLoadEnabled = z17;
                this.isTopDataLoadEnabled = true;
            }
        }
        this.callback.b(this.isTopDataLoadEnabled, this.isBottomDataLoadEnabled);
        o();
        QLog.d("ChatsRecentContactLoadHelper", 1, "[updateCurrentRange] allUpdate after, isTopDataLoadEnabled=" + this.isTopDataLoadEnabled + ", isBottomDataLoadEnabled=" + this.isBottomDataLoadEnabled);
    }
}
