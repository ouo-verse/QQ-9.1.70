package com.tencent.qqnt.chats.core.adapter.holder;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.ui.highlight.HighLightUtilsKt;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B'\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f\u0012\u0006\u0010&\u001a\u00020!\u0012\b\u0010*\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b=\u0010>J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\tH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "", "position", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "Landroid/view/View;", "views", "", HippyTKDListViewAdapter.X, "(ILcom/tencent/qqnt/chats/core/adapter/itemdata/b;[Landroid/view/View;)V", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "itemBuilder", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "t", "", "", "payloads", "E", "it", "v", "Lkotlin/Function0;", "block", BdhLogUtil.LogTag.Tag_Conn, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onRecycled", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "y", "()Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "Lcom/tencent/qqnt/chats/core/adapter/h;", "G", "Lcom/tencent/qqnt/chats/core/adapter/h;", "listener", "H", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "setCurChatItem", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;)V", "curChatItem", "I", "Z", "getUseAnimCtrl", "()Z", "D", "(Z)V", "useAnimCtrl", "Lcom/tencent/qphone/base/util/HighFreqLogUtil;", "J", "Lcom/tencent/qphone/base/util/HighFreqLogUtil;", "freLog", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/builder/a;Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;Lcom/tencent/qqnt/chats/core/adapter/h;)V", "K", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RecentContactItemHolder extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int L;
    private static final long M;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.adapter.builder.a<RecentContactItemHolder> itemBuilder;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RecentContactItemBinding binding;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.chats.core.adapter.h listener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.adapter.itemdata.b curChatItem;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean useAnimCtrl;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final HighFreqLogUtil freLog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder$b", "Lcom/tencent/qqnt/widget/SwipeMenuLayout$e;", "", "a", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements SwipeMenuLayout.e {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g f354492b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f354493c;

        b(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, int i3) {
            this.f354492b = gVar;
            this.f354493c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, RecentContactItemHolder.this, gVar, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.qqnt.chats.core.adapter.h hVar = RecentContactItemHolder.this.listener;
                if (hVar != null) {
                    hVar.e(this.f354492b, this.f354493c);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                com.tencent.qqnt.chats.core.adapter.h hVar = RecentContactItemHolder.this.listener;
                if (hVar != null) {
                    hVar.d(this.f354492b, this.f354493c);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        L = ViewUtils.dip2px(72.0f);
        M = 200L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentContactItemHolder(@NotNull com.tencent.qqnt.chats.core.adapter.builder.a<RecentContactItemHolder> itemBuilder, @NotNull RecentContactItemBinding binding, @Nullable com.tencent.qqnt.chats.core.adapter.h hVar) {
        super(binding.i());
        Intrinsics.checkNotNullParameter(itemBuilder, "itemBuilder");
        Intrinsics.checkNotNullParameter(binding, "binding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemBuilder, binding, hVar);
            return;
        }
        this.itemBuilder = itemBuilder;
        this.binding = binding;
        this.listener = hVar;
        this.useAnimCtrl = true;
        this.freLog = new HighFreqLogUtil(2);
    }

    private final void C(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Function0<Unit> block) {
        if (!item.q().getBoolean("is_local_cache_data", false)) {
            block.invoke();
            return;
        }
        this.freLog.d("RecentContactItemHolder", 2, item.w().e() + " process local data, skip bindEvent");
    }

    private final void E(final com.tencent.qqnt.chats.core.adapter.itemdata.b item, List<? extends Object> payloads) {
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) item;
        HashSet hashSet = new HashSet();
        for (Object obj : payloads) {
            if (obj instanceof Collection) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Any>");
                hashSet.addAll((Collection) obj);
            } else if (obj instanceof Object[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                for (Object obj2 : (Object[]) obj) {
                    hashSet.add(obj2);
                }
            } else {
                hashSet.add(obj);
            }
        }
        if (hashSet.contains(com.tencent.qqnt.chats.core.adapter.itemdata.payload.l.f354603a)) {
            l(item);
            return;
        }
        final int adapterPosition = getAdapterPosition();
        t(this.itemBuilder, gVar, adapterPosition);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.e) {
                this.itemBuilder.f(gVar, this, new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RecentContactItemHolder.H(RecentContactItemHolder.this, adapterPosition, item, view);
                    }
                });
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.h) {
                this.itemBuilder.h(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.i) {
                this.itemBuilder.i(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.m) {
                this.itemBuilder.l(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.b) {
                this.itemBuilder.d(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.j) {
                this.itemBuilder.j(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.f) {
                this.itemBuilder.g(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.a) {
                this.itemBuilder.c(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.n) {
                this.itemBuilder.e(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.k) {
                this.itemBuilder.k(gVar, this);
            } else if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.g) {
                this.itemBuilder.e(gVar, this);
            } else {
                this.freLog.d("RecentContactItemHolder", 2, "unknown payload: " + next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(RecentContactItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.b item, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.v(it, i3, item);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void t(com.tencent.qqnt.chats.core.adapter.builder.a<RecentContactItemHolder> itemBuilder, final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final int position) {
        this.freLog.d("RecentContactItemHolder", 1, "bindEvent start -- ");
        if (!item.q().getBoolean("is_first_data", false) || ChatsListConfig.f354433a.g()) {
            this.freLog.d("RecentContactItemHolder", 1, "bindEvent enableRegistSwipe: " + ChatsListConfig.f354433a + ".enableRegistSwipe");
            this.binding.i().setSwipeListener(new b(item, position));
            itemBuilder.f(item, this, new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecentContactItemHolder.u(RecentContactItemHolder.this, position, item, view);
                }
            });
        }
        RecentContactItemHolder$bindEvent$bindBlock$1 recentContactItemHolder$bindEvent$bindBlock$1 = new RecentContactItemHolder$bindEvent$bindBlock$1(this, position, item);
        if (ChatsListConfig.f354433a.e()) {
            recentContactItemHolder$bindEvent$bindBlock$1.invoke();
        } else {
            C(item, recentContactItemHolder$bindEvent$bindBlock$1);
        }
        com.tencent.qqnt.chats.core.itempart.c.c(item, this.binding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(RecentContactItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.v(it, i3, item);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void v(final View it, final int position, final com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        if (!(item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return;
        }
        if (it.getId() != R.id.epz) {
            this.binding.i().l();
            this.binding.i().postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.core.adapter.holder.j
                @Override // java.lang.Runnable
                public final void run() {
                    RecentContactItemHolder.w(RecentContactItemHolder.this, position, item, it);
                }
            }, M);
        } else {
            com.tencent.qqnt.chats.core.adapter.h hVar = this.listener;
            if (hVar != null) {
                hVar.c(position, (com.tencent.qqnt.chats.core.adapter.itemdata.g) item, this.binding, it.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RecentContactItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.b item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(it, "$it");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.listener;
        if (hVar != null) {
            hVar.c(i3, (com.tencent.qqnt.chats.core.adapter.itemdata.g) item, this$0.binding, it.getId());
        }
    }

    private final void x(int position, com.tencent.qqnt.chats.core.adapter.itemdata.b item, View[] views) {
        for (View view : views) {
            if (view != null) {
                view.setTag(R.id.f70883mn, Integer.valueOf(position));
                view.setTag(R.id.f70873mm, item);
            }
        }
    }

    public final boolean A() {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = this.curChatItem;
        if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 16) {
            return false;
        }
        return true;
    }

    public final boolean B() {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b bVar = this.curChatItem;
        if (bVar instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) bVar;
        } else {
            gVar = null;
        }
        boolean z16 = false;
        if (gVar != null && gVar.n() == 16) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(ex3.a.f(gVar.s()));
            GuildLayoutManager guildLayoutManager = GuildLayoutManager.f354256a;
            long n3 = guildLayoutManager.n();
            if (longOrNull != null && longOrNull.longValue() == n3) {
                z16 = true;
            }
            this.freLog.d("RecentContactItemHolder", 1, "isNewSubscribeGuildItem: " + ex3.a.f(gVar.s()) + " equals " + guildLayoutManager.n() + " = " + z16);
            return z16;
        }
        return false;
    }

    public final void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.useAnimCtrl = z16;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void l(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        StopWatch i3 = new StopWatch("RecentContactItemHolder-bind-" + item.id(), false).i();
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) item;
        int adapterPosition = getAdapterPosition();
        this.itemBuilder.c(gVar, this);
        i3.e("updateAvatar");
        this.itemBuilder.j(gVar, this);
        i3.e("updateTitle");
        this.itemBuilder.h(gVar, this);
        i3.e("updateSummary");
        this.itemBuilder.i(gVar, this);
        i3.e("updateTime");
        this.itemBuilder.l(gVar, this);
        i3.e("updateUnread");
        this.itemBuilder.d(gVar, this);
        i3.e("updateBackground");
        this.itemBuilder.g(gVar, this);
        i3.e("updateSelect");
        this.itemBuilder.e(gVar, this);
        i3.e("updateContent");
        t(this.itemBuilder, gVar, adapterPosition);
        i3.e("bindEvent");
        x(adapterPosition, item, new View[]{this.binding.o()});
        i3.b(this.itemBuilder + "-bind");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void m(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curChatItem = item;
        if (this.binding.a() instanceof nw3.c) {
            nw3.a a16 = this.binding.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.ui.api.IRecentAvatarViewWrapper");
            ((nw3.c) a16).e(item);
        }
        if (!payloads.isEmpty() && (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            E(item, payloads);
        } else {
            l(item);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            HighLightUtilsKt.d(this.binding.b(), this.binding.p());
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void onRecycled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (ChatsListConfig.f354433a.c()) {
            this.binding.a().getAvatarView().setImageDrawable(null);
        }
    }

    @NotNull
    public final RecentContactItemBinding y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactItemBinding) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.binding;
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.itemdata.b z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.curChatItem;
    }
}
