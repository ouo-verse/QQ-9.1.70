package com.tencent.guild.aio.msglist.holder.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\n*\u0001&\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Landroid/view/View;", "avatarView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "o1", "p1", "m1", "Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;", "style", "k1", "l1", "v", ICustomDataEditor.NUMBER_PARAM_1, "", "getTag", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "com/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$viewHolder$1", tl.h.F, "Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$viewHolder$1;", "viewHolder", "<init>", "(Landroid/view/View;)V", "i", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleAvatarComponent extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildBubbleAvatarComponent$viewHolder$1 viewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "setWithPendant", "(Z)V", "withPendant", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarComponent$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ViewStyle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean withPendant;

        public ViewStyle() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getWithPendant() {
            return this.withPendant;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ViewStyle) && this.withPendant == ((ViewStyle) other).withPendant) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.withPendant;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "ViewStyle(withPendant=" + this.withPendant + ")";
        }

        public ViewStyle(boolean z16) {
            this.withPendant = z16;
        }

        public /* synthetic */ ViewStyle(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    public GuildBubbleAvatarComponent(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.viewHolder = new GuildBubbleAvatarComponent$viewHolder$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View k1(ViewStyle style) {
        GuildUserAvatarView guildUserAvatarView;
        if (style.getWithPendant()) {
            Context context = this.root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = new GuildUserAvatarViewWithPendant(context, null, 2, false ? 1 : 0);
            guildUserAvatarViewWithPendant.getAvatarView().setScaleType(ImageView.ScaleType.FIT_XY);
            guildUserAvatarViewWithPendant.getPendantView().setScaleType(ImageView.ScaleType.FIT_XY);
            guildUserAvatarView = guildUserAvatarViewWithPendant;
        } else {
            GuildUserAvatarView guildUserAvatarView2 = new GuildUserAvatarView(this.root.getContext());
            guildUserAvatarView2.setScaleType(ImageView.ScaleType.FIT_XY);
            guildUserAvatarView = guildUserAvatarView2;
        }
        guildUserAvatarView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return guildUserAvatarView;
    }

    private final ViewStyle l1() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 1;
        g gVar = new g(null, 1, null);
        sendIntent(gVar);
        ViewStyle viewStyle = gVar.getViewStyle();
        if (viewStyle == null) {
            return new ViewStyle(false, i3, defaultConstructorMarker);
        }
        return viewStyle;
    }

    private final View m1() {
        if (this.viewHolder.getAvatarView() == null) {
            ViewStyle l16 = l1();
            if (!l16.getWithPendant()) {
                int dimensionPixelSize = this.root.getResources().getDimensionPixelSize(R.dimen.f158723nd);
                this.viewHolder.b().setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            }
            this.viewHolder.c(k1(l16));
            this.viewHolder.b().addView(this.viewHolder.getAvatarView());
        }
        View avatarView = this.viewHolder.getAvatarView();
        Intrinsics.checkNotNull(avatarView);
        return avatarView;
    }

    private final void n1(View v3, GuildMsgItem msgItem) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_touin", msgItem.getMsgRecord().senderUid);
        VideoReport.setElementId(v3, "em_aio_profile");
        VideoReport.setElementParams(v3, hashMap);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
    }

    private final void o1(View avatarView, GuildMsgItem msgItem) {
        if (avatarView instanceof GuildUserAvatarView) {
            ((GuildUserAvatarView) avatarView).setAvatarTinyId(com.tencent.guild.aio.util.ex.f.a(msgItem), msgItem.getMsgRecord().senderUid);
        } else if (avatarView instanceof GuildUserAvatarViewWithPendant) {
            String a16 = com.tencent.guild.aio.util.ex.f.a(msgItem);
            String str = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            ((GuildUserAvatarViewWithPendant) avatarView).setAvatarTinyId(a16, str);
        }
    }

    private final void p1(View avatarView, final GuildMsgItem msgItem) {
        avatarView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean q16;
                q16 = GuildBubbleAvatarComponent.q1(GuildMsgItem.this, this, view);
                return q16;
            }
        });
        avatarView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBubbleAvatarComponent.r1(GuildMsgItem.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q1(GuildMsgItem msgItem, GuildBubbleAvatarComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildBubbleAvatarComponent", 1, "avatar long-click, guildid: " + com.tencent.guild.aio.util.ex.f.a(msgItem) + "peerUid: " + msgItem.getMsgRecord().peerUid + ", sendUid: " + msgItem.getMsgRecord().senderUid);
        this$0.sendIntent(new GuildBubbleAvatarLongClickIntent(msgItem));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(GuildMsgItem msgItem, GuildBubbleAvatarComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildBubbleAvatarComponent", 1, "avatar click, guildId: " + com.tencent.guild.aio.util.ex.f.a(msgItem) + "peerUid: " + msgItem.getMsgRecord().peerUid + ", sendUid: " + msgItem.getMsgRecord().senderUid);
        this$0.sendIntent(new GuildBubbleAvatarClickIntent(msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        View m16 = m1();
        n1(m16, guildMsgItem);
        o1(m16, guildMsgItem);
        p1(m16, guildMsgItem);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.viewHolder.b();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new f();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildBubbleAvatarComponent";
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
