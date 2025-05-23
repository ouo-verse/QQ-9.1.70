package com.tencent.guild.aio.article.msglist.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.en;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import dq0.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>B)\u0012\u0006\u0010+\u001a\u00020\u000b\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00105\u001a\u000200\u0012\b\b\u0002\u0010:\u001a\u00020$\u00a2\u0006\u0004\b;\u0010<J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0015H\u0002J&\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u001a\u0012\u0006\b\u0001\u0012\u00020\u001b0\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0016\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0003H\u0016J$\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010+\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/a;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "", "payloads", "", "h1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/view/View;", "view", "", "e1", "g1", "l1", "i1", ICustomDataEditor.NUMBER_PARAM_1, "m1", "k1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "j1", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "state", "f1", "", "position", "d1", "d", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "getFactoryProvider", "()Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", h.F, "I", "getViewType", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

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

    public a(@NotNull View itemView, @NotNull d componentProvider, @NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    private final void e1(com.tencent.aio.data.msglist.a msgItem, View view) {
        b.Companion companion = dq0.b.INSTANCE;
        companion.b(view);
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        String selfTid = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        MsgRecord msgRecord = ((GuildMsgItem) msgItem).getMsgRecord();
        Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
        if (MsgExtKt.F(msgRecord, selfTid)) {
            b.Companion.d(companion, view, 0L, 0, null, 14, null);
        }
    }

    private final boolean g1(com.tencent.aio.data.msglist.a msgItem) {
        boolean equals$default;
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default((GuildMsgItem) msgItem, "guild_article_is_main_msg", null, 2, null);
        if (!TextUtils.isEmpty(extInfoFromExtStr$default)) {
            equals$default = StringsKt__StringsJVMKt.equals$default(extInfoFromExtStr$default, "1", false, 2, null);
            if (!equals$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean h1(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(GuildMsgItemPayloadType.REPLAY_MSG_COMMENT_COUNT_PAYLOAD) != null) {
                z16 = false;
            }
        }
        return z16;
    }

    private final void i1() {
        View findViewById;
        try {
            int i3 = this.viewType;
            if (i3 != 26 && i3 != 25 && (findViewById = this.itemView.findViewById(R.id.f164907u83)) != null) {
                findViewById.setBackgroundResource(R.drawable.f162601b70);
            }
        } catch (Exception e16) {
            QLog.e("GuildBubbleMsgItemViewHolder", 1, "updateMainMsgItemBackground error! " + e16.getMessage());
        }
    }

    private final void j1(GuildMsgItem msgItem) {
        l1();
        i1();
        n1();
        m1(msgItem);
        k1();
    }

    private final void k1() {
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.f164907u83);
        if (linearLayout != null) {
            int i3 = this.viewType;
            if (i3 != 25 && i3 != 26) {
                linearLayout.setPadding(0, 0, 0, 0);
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).startToStart = R.id.zfr;
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams2).endToEnd = 0;
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams3).topToBottom = R.id.zfr;
            ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            wr0.a aVar = wr0.a.f446116a;
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams4)).rightMargin = aVar.b(16);
            ViewGroup.LayoutParams layoutParams5 = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams5)).topMargin = aVar.b(10);
        }
    }

    private final void l1() {
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = wr0.a.f446116a.b(10);
        View view = this.itemView;
        view.setPadding(view.getPaddingLeft(), 0, this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
    }

    private final void m1(com.tencent.aio.data.msglist.a msgItem) {
        TextView textView = new TextView(getMContext());
        textView.setIncludeFontPadding(false);
        textView.setId(R.id.vyr);
        GuildUIUtils.f235378a.b(textView, R.color.qui_common_text_secondary);
        ViewExtKt.f(textView, wr0.a.f446116a.b(3));
        textView.setTextSize(1, 12.0f);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getMContext().getResources().getString(R.string.f139740c3);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026uild_article_publish_msg)");
        Context mContext = getMContext();
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        String format = String.format(string, Arrays.copyOf(new Object[]{en.t(mContext, ((GuildMsgItem) msgItem).getMsgRecord().msgTime * 1000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToBottom = R.id.zg8;
        layoutParams.startToEnd = R.id.zfr;
        textView.setLayoutParams(layoutParams);
        ((ConstraintLayout) this.itemView.findViewById(R.id.root)).addView(textView);
        View findViewById = this.itemView.findViewById(R.id.vxt);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n1() {
        View findViewById = this.itemView.findViewById(R.id.vxp);
        if (findViewById != 0) {
            if (findViewById instanceof TextView) {
                TextView textView = (TextView) findViewById;
                textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_primary));
                textView.setLinkTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_link));
            } else if (findViewById instanceof com.tencent.aio.widget.textView.api.c) {
                com.tencent.aio.widget.textView.api.c cVar = (com.tencent.aio.widget.textView.api.c) findViewById;
                ColorStateList colorStateList = findViewById.getContext().getColorStateList(R.color.qui_common_text_primary);
                Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026.qui_common_text_primary)");
                cVar.setTextColor(colorStateList);
                ColorStateList colorStateList2 = findViewById.getContext().getColorStateList(R.color.qui_common_text_link);
                Intrinsics.checkNotNullExpressionValue(colorStateList2, "context.getColorStateLis\u2026lor.qui_common_text_link)");
                cVar.setLinkTextColor(colorStateList2);
            }
        }
    }

    @Override // com.tencent.aio.api.list.a
    @Nullable
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    public final void d1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                aVar.b1(position, msgItem, payloads);
            }
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        GuildCombineUtil.f111919a.u(this.itemView, guildMsgItem);
        if (guildMsgItem.getMsgRecord().msgType != 5 && guildMsgItem.getMsgRecord().msgType != 1) {
            t.e(this.componentProvider, this);
            t.h(this.componentProvider, this);
        }
        if (g1(msgItem)) {
            j1(guildMsgItem);
        } else if (h1(payloads)) {
            dq0.b.INSTANCE.b(this.itemView);
            e1(msgItem, this.itemView);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        d1(state.getPosition(), state.getData(), state.b());
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

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.itemView;
    }
}
