package com.tencent.timi.game.liveroom.impl.room.playtogether.widget;

import ag4.i;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0003)*\fB'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\t\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView;", "Landroid/widget/RelativeLayout;", "", "k", "Landroid/view/View;", "i", "Lkotlin/Function1;", "Ltrpc/yes/common/YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;", "cb", "setDefaultRoleChooseCb", "j", "Lnr2/e;", "d", "Lnr2/e;", "binding", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter;", "accountSwitchAdapter", "Lag4/i;", "kotlin.jvm.PlatformType", "f", "Lag4/i;", "smobaInfoService", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", tl.h.F, "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "defaultSmobaRoleInfo", "Lkotlin/jvm/functions/Function1;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "yesGameId", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "AccountSwitchAdapter", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorAccountSwitchView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.e binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AccountSwitchAdapter accountSwitchAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final i smobaInfoService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YesGameInfoOuterClass$YesGameRoleAbsInfo defaultSmobaRoleInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super YesGameInfoOuterClass$SetUserGameDefaultRoleRsp, Unit> cb;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int yesGameId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$a;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$b;", "listener", "", "m0", "", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$c;", "accountList", "setData", "Landroid/view/ViewGroup;", "p0", "", "p1", "l0", "k0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "accountSwitchList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$b;", "accountChooseListener", "<init>", "()V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class AccountSwitchAdapter extends RecyclerView.Adapter<a> {

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private b accountChooseListener;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<c> accountSwitchList = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$c;", "bean", "Lkotlin/Function1;", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnr2/d;", "E", "Lnr2/d;", "binding", "<init>", "(Lnr2/d;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final nr2.d binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull nr2.d binding) {
                super(binding.getRoot());
                Intrinsics.checkNotNullParameter(binding, "binding");
                this.binding = binding;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void n(Function1 cb5, c bean, View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Intrinsics.checkNotNullParameter(cb5, "$cb");
                Intrinsics.checkNotNullParameter(bean, "$bean");
                cb5.invoke(bean.getRoleAbsInfo());
                EventCollector.getInstance().onViewClicked(view);
            }

            public final void m(@NotNull final c bean, @NotNull final Function1<? super YesGameInfoOuterClass$YesGameRoleAbsInfo, Unit> cb5) {
                int i3;
                Intrinsics.checkNotNullParameter(bean, "bean");
                Intrinsics.checkNotNullParameter(cb5, "cb");
                View view = this.itemView;
                ImageView imageView = this.binding.f421044c;
                if (bean.getChosen()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                this.binding.f421045d.setText(bean.getRoleAbsInfo().role_name.get());
                this.binding.f421043b.setText(bean.getRoleAbsInfo().role_desc.get());
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AnchorAccountSwitchView.AccountSwitchAdapter.a.n(Function1.this, bean, view2);
                    }
                });
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$b;", "", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "role", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public interface b {
            void a(@NotNull YesGameInfoOuterClass$YesGameRoleAbsInfo role);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.accountSwitchList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull a p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.m(this.accountSwitchList.get(p16), new Function1<YesGameInfoOuterClass$YesGameRoleAbsInfo, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchView$AccountSwitchAdapter$onBindViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo) {
                    invoke2(yesGameInfoOuterClass$YesGameRoleAbsInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull YesGameInfoOuterClass$YesGameRoleAbsInfo it) {
                    AnchorAccountSwitchView.AccountSwitchAdapter.b bVar;
                    List list;
                    List list2;
                    List list3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    bVar = AnchorAccountSwitchView.AccountSwitchAdapter.this.accountChooseListener;
                    if (bVar != null) {
                        bVar.a(it);
                    }
                    list = AnchorAccountSwitchView.AccountSwitchAdapter.this.accountSwitchList;
                    Iterator it5 = list.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            i3 = -1;
                            break;
                        } else if (((AnchorAccountSwitchView.c) it5.next()).getChosen()) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 >= 0) {
                        list3 = AnchorAccountSwitchView.AccountSwitchAdapter.this.accountSwitchList;
                        ((AnchorAccountSwitchView.c) list3.get(i3)).c(false);
                    }
                    list2 = AnchorAccountSwitchView.AccountSwitchAdapter.this.accountSwitchList;
                    AnchorAccountSwitchView.AccountSwitchAdapter accountSwitchAdapter = AnchorAccountSwitchView.AccountSwitchAdapter.this;
                    int i16 = 0;
                    for (Object obj : list2) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        AnchorAccountSwitchView.c cVar = (AnchorAccountSwitchView.c) obj;
                        if (cVar.getRoleAbsInfo().partition.get() == it.partition.get()) {
                            cVar.c(true);
                            accountSwitchAdapter.notifyItemChanged(i3);
                            accountSwitchAdapter.notifyItemChanged(i16);
                        }
                        i16 = i17;
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            nr2.d g16 = nr2.d.g(LayoutInflater.from(p06.getContext()), p06, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026m(p0.context), p0, false)");
            return new a(g16);
        }

        public final void m0(@NotNull b listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.accountChooseListener = listener;
        }

        public final void setData(@NotNull List<c> accountList) {
            Intrinsics.checkNotNullParameter(accountList, "accountList");
            this.accountSwitchList.clear();
            this.accountSwitchList.addAll(accountList);
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$a", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$AccountSwitchAdapter$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "role", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements AccountSwitchAdapter.b {
        a() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchView.AccountSwitchAdapter.b
        public void a(@NotNull YesGameInfoOuterClass$YesGameRoleAbsInfo role) {
            Intrinsics.checkNotNullParameter(role, "role");
            AnchorAccountSwitchView.this.defaultSmobaRoleInfo = role;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$b", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> {
        b() {
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$SetUserGameDefaultRoleRsp rsp) {
            Function1 function1 = AnchorAccountSwitchView.this.cb;
            if (function1 != null) {
                function1.invoke(rsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$c;", "", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "a", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "b", "()Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "roleAbsInfo", "", "Z", "()Z", "c", "(Z)V", "chosen", "<init>", "(Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;Z)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final YesGameInfoOuterClass$YesGameRoleAbsInfo roleAbsInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean chosen;

        public c(@NotNull YesGameInfoOuterClass$YesGameRoleAbsInfo roleAbsInfo, boolean z16) {
            Intrinsics.checkNotNullParameter(roleAbsInfo, "roleAbsInfo");
            this.roleAbsInfo = roleAbsInfo;
            this.chosen = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getChosen() {
            return this.chosen;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final YesGameInfoOuterClass$YesGameRoleAbsInfo getRoleAbsInfo() {
            return this.roleAbsInfo;
        }

        public final void c(boolean z16) {
            this.chosen = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$e", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView$e$a", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AnchorAccountSwitchView f378400a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<YesGameInfoOuterClass$YesGameRoleAbsInfo> f378401b;

            a(AnchorAccountSwitchView anchorAccountSwitchView, List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list) {
                this.f378400a = anchorAccountSwitchView;
                this.f378401b = list;
            }

            @Override // ag4.i.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
                Object obj;
                int collectionSizeOrDefault;
                boolean z16;
                PBUInt32Field pBUInt32Field;
                boolean z17;
                YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
                YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2;
                PBUInt32Field pBUInt32Field2;
                if (!result) {
                    l.e("AnchorAccountSwitchView", "requestDefaultSmobaAccountFromServer # errorCode: " + errorCode + " errorMsg: " + errorMsg);
                    return;
                }
                wf4.a.f445618a.a(this.f378400a.getContext());
                AnchorAccountSwitchView anchorAccountSwitchView = this.f378400a;
                Iterator<T> it = this.f378401b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo = (YesGameInfoOuterClass$YesGameRoleAbsInfo) obj;
                        if (rsp != null && (yesGameInfoOuterClass$YesGameRoleInfo = rsp.role_info) != null && (yesGameInfoOuterClass$YesGameRoleInfo2 = yesGameInfoOuterClass$YesGameRoleInfo.get()) != null && (pBUInt32Field2 = yesGameInfoOuterClass$YesGameRoleInfo2.partition) != null && yesGameInfoOuterClass$YesGameRoleAbsInfo.partition.get() == pBUInt32Field2.get()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                anchorAccountSwitchView.defaultSmobaRoleInfo = (YesGameInfoOuterClass$YesGameRoleAbsInfo) obj;
                AccountSwitchAdapter accountSwitchAdapter = this.f378400a.accountSwitchAdapter;
                List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list = this.f378401b;
                AnchorAccountSwitchView anchorAccountSwitchView2 = this.f378400a;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (YesGameInfoOuterClass$YesGameRoleAbsInfo it5 : list) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo2 = anchorAccountSwitchView2.defaultSmobaRoleInfo;
                    if (yesGameInfoOuterClass$YesGameRoleAbsInfo2 != null && (pBUInt32Field = yesGameInfoOuterClass$YesGameRoleAbsInfo2.partition) != null && it5.partition.get() == pBUInt32Field.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    arrayList.add(new c(it5, z16));
                }
                accountSwitchAdapter.setData(arrayList);
            }
        }

        e() {
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list;
            PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAbsInfo> pBRepeatMessageField;
            if (!result) {
                l.e("AnchorAccountSwitchView", "requestGameRoleAbsInfoListFromServer # errorCode: " + errorCode + " errorMsg: " + errorMsg);
                return;
            }
            if (rsp != null && (pBRepeatMessageField = rsp.role_list) != null) {
                list = pBRepeatMessageField.get();
            } else {
                list = null;
            }
            if (list == null) {
                l.e("AnchorAccountSwitchView", "null role list");
                return;
            }
            if (list.isEmpty()) {
                l.e("AnchorAccountSwitchView", "empty role list");
                hg4.c cVar = hg4.c.f404865a;
                int i3 = AnchorAccountSwitchView.this.yesGameId;
                Context context = AnchorAccountSwitchView.this.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                cVar.r(i3, (QBaseActivity) context);
                wf4.a.f445618a.a(AnchorAccountSwitchView.this.getContext());
                return;
            }
            AnchorAccountSwitchView.this.smobaInfoService.m2(AnchorAccountSwitchView.this.yesGameId, new a(AnchorAccountSwitchView.this, list));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AnchorAccountSwitchView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo = this$0.defaultSmobaRoleInfo;
        if (yesGameInfoOuterClass$YesGameRoleAbsInfo != null && yesGameInfoOuterClass$YesGameRoleAbsInfo != null) {
            this$0.smobaInfoService.e1(this$0.yesGameId, yesGameInfoOuterClass$YesGameRoleAbsInfo, new b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k() {
        wf4.a.f445618a.c(getContext());
        this.smobaInfoService.s3(this.yesGameId, new e());
    }

    @NotNull
    public final View i() {
        MediumBoldTextView mediumBoldTextView = this.binding.f421048c;
        Intrinsics.checkNotNullExpressionValue(mediumBoldTextView, "binding.confirmBtn");
        return mediumBoldTextView;
    }

    @NotNull
    public final View j() {
        View view = this.binding.f421051f;
        Intrinsics.checkNotNullExpressionValue(view, "binding.touchDelegateView");
        return view;
    }

    public final void setDefaultRoleChooseCb(@NotNull Function1<? super YesGameInfoOuterClass$SetUserGameDefaultRoleRsp, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.cb = cb5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorAccountSwitchView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        nr2.e f16 = nr2.e.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.smobaInfoService = (i) mm4.b.b(i.class);
        this.yesGameId = 101;
        setBackgroundResource(R.drawable.f162532lq2);
        AccountSwitchAdapter accountSwitchAdapter = new AccountSwitchAdapter();
        this.accountSwitchAdapter = accountSwitchAdapter;
        f16.f421047b.setLayoutManager(new LinearLayoutManager(getContext()));
        f16.f421047b.setAdapter(accountSwitchAdapter);
        f16.f421047b.setHasFixedSize(true);
        f16.f421047b.setItemAnimator(null);
        accountSwitchAdapter.m0(new a());
        k();
        f16.f421048c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorAccountSwitchView.b(AnchorAccountSwitchView.this, view);
            }
        });
    }
}
