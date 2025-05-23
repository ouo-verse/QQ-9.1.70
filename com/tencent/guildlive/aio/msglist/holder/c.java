package com.tencent.guildlive.aio.msglist.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.SparseArrayKt;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.GuildLivePushMsgItemViewHolderFactoryProvider;
import com.tencent.guildlive.widget.GuildLiveMsgItemRelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import dq0.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B)\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u0012\b\b\u0002\u00104\u001a\u00020!\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nH\u0002J&\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u00180\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J$\u0010&\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#R\u0014\u0010)\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/c;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "l1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "f1", "Lcom/tencent/aio/data/msglist/a;", "Landroid/view/View;", "view", "j1", "g1", "i1", "isMultiSelectMode", "fullScreen", ICustomDataEditor.NUMBER_PARAM_1, "m1", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "state", "k1", "", "position", "", "", "payloads", "e1", "d", "Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", h.F, "I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    public c(@NotNull View itemView, @NotNull d componentProvider, @NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    private final void f1(GuildMsgItem msgItem) {
        VideoReport.setElementReuseIdentifier(this.itemView, "em_aio_message" + msgItem.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, Integer.valueOf(msgItem.getMsgRecord().msgType));
        hashMap.put("dt_pgid", "pg_sgrp_stream_aio");
        yr0.a.p(this.itemView, "em_aio_message", hashMap);
        yr0.a.n("imp", this.itemView, hashMap);
    }

    private final void g1() {
        List listOf;
        View containerView;
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean h16;
                h16 = c.h1(c.this, view);
                return h16;
            }
        };
        i1().setOnLongClickListener(onLongClickListener);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 8});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = this.componentProvider.get().get(((Number) it.next()).intValue());
            if (aVar != null && (containerView = aVar.getContainerView()) != null) {
                containerView.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h1(c this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.d(this$0.i1()));
        return true;
    }

    private final View i1() {
        View findViewById = this.itemView.findViewById(R.id.b9t);
        if (findViewById == null) {
            return getHostView();
        }
        return findViewById;
    }

    private final void j1(com.tencent.aio.data.msglist.a msgItem, View view) {
        String selfTid = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        if (msgItem instanceof GuildMsgItem) {
            MsgRecord msgRecord = ((GuildMsgItem) msgItem).getMsgRecord();
            Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
            if (MsgExtKt.F(msgRecord, selfTid)) {
                d.Companion companion = dq0.d.INSTANCE;
                companion.b(this.itemView);
                companion.c(view);
            }
        }
    }

    private final boolean l1() {
        String str;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
            str = g16.n();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, com.tencent.guildlive.aio.factory.b.class.getName());
    }

    private final boolean m1(com.tencent.aio.data.msglist.a msgItem) {
        return !GuildLivePushMsgItemViewHolderFactoryProvider.f112780a.e().contains(Integer.valueOf(msgItem.getViewType()));
    }

    private final void n1(com.tencent.aio.data.msglist.a msgItem, boolean isMultiSelectMode, boolean fullScreen) {
        int i3;
        View i16 = i1();
        if (i16 == null) {
            return;
        }
        if (isMultiSelectMode && !m1(msgItem)) {
            if (fullScreen) {
                i3 = R.drawable.guild_live_channel_aio_item_show_full_screen_select_bg;
            } else {
                i3 = R.drawable.guild_live_channel_aio_item_show_select_bg;
            }
            if (i16 instanceof ViewGroup) {
                ((ViewGroup) i16).setClipToPadding(false);
            }
        } else {
            if (fullScreen) {
                i3 = R.drawable.guild_live_channel_aio_item_full_screen_bg;
            } else {
                i3 = R.drawable.guild_live_channel_aio_item_bg;
            }
            if (i16 instanceof ViewGroup) {
                ((ViewGroup) i16).setClipToPadding(true);
            }
        }
        i16.setBackgroundResource(i3);
    }

    @Override // com.tencent.aio.api.list.a
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    public final void e1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean z17 = msgItem instanceof GuildMsgItem;
        if (z17) {
            f1((GuildMsgItem) msgItem);
        }
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                aVar.b1(position, msgItem, payloads);
            }
        }
        if (z17) {
            z16 = UIUtil.f112434a.z(payloads);
        } else {
            z16 = false;
        }
        boolean guildLiveVideoIsFullScreenState = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsFullScreenState();
        View view = this.itemView;
        if (view instanceof GuildLiveMsgItemRelativeLayout) {
            ((GuildLiveMsgItemRelativeLayout) view).setMultiSelectState(z16);
        }
        if (!l1()) {
            n1(msgItem, z16, guildLiveVideoIsFullScreenState);
        }
        g1();
        j1(msgItem, this.itemView);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        View view;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                view = aVar.getContainerView();
            } else {
                view = null;
            }
            if (view != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        e1(state.getPosition(), state.getData(), state.b());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View view = this.itemView;
        view.setTag(R.id.zfk, Integer.valueOf(this.viewType));
        return view;
    }
}
