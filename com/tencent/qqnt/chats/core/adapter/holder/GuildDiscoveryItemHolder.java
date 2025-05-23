package com.tencent.qqnt.chats.core.adapter.holder;

import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.core.ui.highlight.HighLightUtilsKt;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b)\u0010*J&\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/GuildDiscoveryItemHolder;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "itemBuilder", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", ReportConstant.COSTREPORT_PREFIX, "", "", "payloads", "v", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "E", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "u", "()Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "Lcom/tencent/qqnt/chats/core/adapter/h;", "G", "Lcom/tencent/qqnt/chats/core/adapter/h;", "listener", "Lpw3/d;", "H", "Lpw3/d;", "discoveryBinding", "I", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "curChatItem", "", "J", "Z", "useAnimCtrl", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/builder/a;Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;Lcom/tencent/qqnt/chats/core/adapter/h;Lpw3/d;)V", "K", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildDiscoveryItemHolder extends b<com.tencent.qqnt.chats.core.adapter.itemdata.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.adapter.builder.a<GuildDiscoveryItemHolder> itemBuilder;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RecentContactItemBinding binding;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.chats.core.adapter.h listener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final pw3.d discoveryBinding;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.adapter.itemdata.b curChatItem;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean useAnimCtrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/GuildDiscoveryItemHolder$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildDiscoveryItemHolder(@NotNull com.tencent.qqnt.chats.core.adapter.builder.a<GuildDiscoveryItemHolder> itemBuilder, @NotNull RecentContactItemBinding binding, @Nullable com.tencent.qqnt.chats.core.adapter.h hVar, @NotNull pw3.d discoveryBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(itemBuilder, "itemBuilder");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(discoveryBinding, "discoveryBinding");
        RelativeLayout root = discoveryBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "discoveryBinding.root");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemBuilder, binding, hVar, discoveryBinding);
            return;
        }
        this.itemBuilder = itemBuilder;
        this.binding = binding;
        this.listener = hVar;
        this.discoveryBinding = discoveryBinding;
        this.useAnimCtrl = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(com.tencent.qqnt.chats.core.adapter.builder.a<GuildDiscoveryItemHolder> itemBuilder, final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final int position) {
        this.binding.a().getAvatarLayout().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildDiscoveryItemHolder.t(GuildDiscoveryItemHolder.this, position, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildDiscoveryItemHolder this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.g item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.listener;
        if (hVar != null) {
            hVar.a(i3, item, this$0.binding);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(com.tencent.qqnt.chats.core.adapter.itemdata.b item, List<? extends Object> payloads) {
        List list;
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) item;
        s(this.itemBuilder, gVar, getAdapterPosition());
        HashSet hashSet = new HashSet();
        for (Object obj : payloads) {
            if (obj instanceof List) {
                hashSet.addAll((Collection) obj);
            } else {
                hashSet.add(obj);
            }
        }
        if (QLog.isDevelopLevel()) {
            list = CollectionsKt___CollectionsKt.toList(hashSet);
            QLog.d("GuildDiscoveryItemHolder", 4, "updateWithPayload " + list);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.f) {
                this.itemBuilder.g(gVar, this);
            } else if (next instanceof List) {
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                v(item, (List) next);
            } else {
                QLog.d("GuildDiscoveryItemHolder", 1, "unknown payload: " + next);
            }
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void l(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("GuildDiscoveryItemHolder", 1, "name: " + ((com.tencent.qqnt.chats.core.adapter.itemdata.g) item).w().e() + " bindVH: " + this);
        final int adapterPosition = getAdapterPosition();
        com.tencent.qqnt.chats.utils.h hVar = com.tencent.qqnt.chats.utils.h.f355549a;
        hVar.e("bindEvent", QLog.isDebugVersion(), new Function0<Unit>(item, adapterPosition) { // from class: com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder$bind$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.b $item;
            final /* synthetic */ int $position;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$item = item;
                this.$position = adapterPosition;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GuildDiscoveryItemHolder.this, item, Integer.valueOf(adapterPosition));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.qqnt.chats.core.adapter.builder.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                GuildDiscoveryItemHolder guildDiscoveryItemHolder = GuildDiscoveryItemHolder.this;
                aVar = guildDiscoveryItemHolder.itemBuilder;
                guildDiscoveryItemHolder.s(aVar, (com.tencent.qqnt.chats.core.adapter.itemdata.g) this.$item, this.$position);
            }
        });
        hVar.e("updateAvatar", QLog.isDebugVersion(), new Function0<Unit>(item) { // from class: com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder$bind$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.b $item;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$item = item;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildDiscoveryItemHolder.this, (Object) item);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.qqnt.chats.core.adapter.builder.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    aVar = GuildDiscoveryItemHolder.this.itemBuilder;
                    aVar.c((com.tencent.qqnt.chats.core.adapter.itemdata.g) this.$item, GuildDiscoveryItemHolder.this);
                }
            }
        });
        hVar.e("updateBackground", QLog.isDebugVersion(), new Function0<Unit>(item) { // from class: com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder$bind$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.b $item;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$item = item;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildDiscoveryItemHolder.this, (Object) item);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.qqnt.chats.core.adapter.builder.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    aVar = GuildDiscoveryItemHolder.this.itemBuilder;
                    aVar.d((com.tencent.qqnt.chats.core.adapter.itemdata.g) this.$item, GuildDiscoveryItemHolder.this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void m(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) payloads);
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
            QLog.d("GuildDiscoveryItemHolder", 1, "name: " + ((com.tencent.qqnt.chats.core.adapter.itemdata.g) item).w().e() + ", payloadVH: " + this);
            v(item, payloads);
            return;
        }
        l(item);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            HighLightUtilsKt.d(this.binding.b(), this.binding.p());
        }
    }

    @NotNull
    public final RecentContactItemBinding u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactItemBinding) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.binding;
    }
}
