package com.tencent.guild.aio.component.combinestyle;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.SparseArrayKt;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mvi.base.mvi.MviUIState;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>B)\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u00105\u001a\u000200\u0012\b\b\u0002\u0010:\u001a\u00020\u001e\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00150\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J&\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u0006\u0010%\u001a\u00020\u0006R\u001a\u0010\u000b\u001a\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010/\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00105\u001a\u0002008\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u0010:\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/t;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/view/View;", "view", "", "j1", "f1", "itemView", "", "isMultiSelectMode", "fullScreen", ICustomDataEditor.NUMBER_PARAM_1, "m1", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "state", "k1", "", "position", "", "", "payloads", "e1", "l1", "h1", "d", "Landroid/view/View;", "i1", "()Landroid/view/View;", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "getComponentProvider", "()Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "getFactoryProvider", "()Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", tl.h.F, "I", "getViewType", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class t extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    public t(@NotNull View itemView, @NotNull com.tencent.guild.aio.msglist.holder.config.d componentProvider, @NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    private final void f1() {
        List listOf;
        View containerView;
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.s
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean g16;
                g16 = t.g1(t.this, view);
                return g16;
            }
        };
        h1().setOnLongClickListener(onLongClickListener);
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
    public static final boolean g1(t this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.d(this$0.h1()));
        return true;
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

    private final boolean m1(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem instanceof GuildMsgItem) {
            int i3 = ((GuildMsgItem) msgItem).getMsgRecord().msgType;
            if (i3 == 5 || i3 == 14) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final void n1(View itemView, com.tencent.aio.data.msglist.a msgItem, boolean isMultiSelectMode, boolean fullScreen) {
        int i3;
        View h16 = h1();
        if (h16 == null) {
            return;
        }
        if (isMultiSelectMode && !m1(msgItem)) {
            if (fullScreen) {
                i3 = R.drawable.guild_live_channel_aio_item_show_full_screen_select_bg;
            } else {
                i3 = R.drawable.guild_live_channel_aio_item_show_select_bg;
            }
            if (h16 instanceof ViewGroup) {
                ((ViewGroup) h16).setClipToPadding(false);
            }
        } else {
            if (fullScreen) {
                i3 = R.drawable.guild_live_channel_aio_item_full_screen_bg;
            } else {
                i3 = R.drawable.guild_live_channel_aio_item_bg;
            }
            if (h16 instanceof ViewGroup) {
                ((ViewGroup) h16).setClipToPadding(true);
            }
        }
        h16.setBackgroundResource(i3);
    }

    @Override // com.tencent.aio.api.list.a
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    public void e1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean z17 = msgItem instanceof GuildMsgItem;
        if (z17) {
            VideoReport.setElementReuseIdentifier(this.itemView, "em_aio_message" + msgItem.hashCode());
            HashMap hashMap = new HashMap();
            hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, Integer.valueOf(((GuildMsgItem) msgItem).getMsgRecord().msgType));
            hashMap.put("dt_pgid", "pg_sgrp_avchannel_aio");
            com.tencent.guild.aio.util.h.f112401a.C(this.itemView, "em_aio_message", hashMap);
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
        if (!l1()) {
            n1(this.itemView, msgItem, z16, guildLiveVideoIsFullScreenState);
        }
        f1();
        j1(msgItem, this.itemView);
    }

    @NotNull
    public final View h1() {
        View findViewById = this.itemView.findViewById(R.id.b9t);
        if (findViewById == null) {
            return getHostView();
        }
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i1, reason: from getter */
    public final View getItemView() {
        return this.itemView;
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

    public boolean l1() {
        return false;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.itemView;
    }
}
