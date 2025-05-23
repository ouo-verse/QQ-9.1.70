package com.tencent.guild.aio.msglist.reaction.ui.reactionholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.aio.util.ae;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0002!\"B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H$J\b\u0010\f\u001a\u00020\bH\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/guild/aio/util/ex/c;", "Lgq0/d;", "guildReactionItem", "", "", "payloads", "", DomainData.DOMAIN_NAME, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "E", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "p", "()Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "adapter", UserInfo.SEX_FEMALE, "Lgq0/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lgq0/d;", "r", "(Lgq0/d;)V", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;)V", "G", "a", "PayloadType", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class BaseReactionHolder extends RecyclerView.ViewHolder implements com.tencent.guild.aio.util.ex.c {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final d adapter;

    /* renamed from: F, reason: from kotlin metadata */
    public gq0.d guildReactionItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder$PayloadType;", "", "(Ljava/lang/String;I)V", "ITEM_BG_REFRESH_PAYLOAD", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum PayloadType {
        ITEM_BG_REFRESH_PAYLOAD
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f111850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f111851e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f111852f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ BaseReactionHolder f111853h;

        public b(long j3, View view, View view2, BaseReactionHolder baseReactionHolder) {
            this.f111850d = j3;
            this.f111851e = view;
            this.f111852f = view2;
            this.f111853h = baseReactionHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - ReactionUtilsKt.h() > this.f111850d) {
                ReactionUtilsKt.m(currentTimeMillis);
                View view2 = this.f111851e;
                ae aeVar = ae.f112367a;
                Context context = this.f111852f.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                ae.d(aeVar, context, 0L, 2, null);
                this.f111853h.onClick(view2);
            } else {
                QQToast.makeText(this.f111851e.getContext(), this.f111851e.getContext().getString(R.string.f2172360g), 1).show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseReactionHolder(@NotNull final View itemView, @NotNull d adapter) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        itemView.setOnClickListener(new b(1500L, itemView, itemView, this));
        itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m3;
                m3 = BaseReactionHolder.m(itemView, this, view);
                return m3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(View itemView, BaseReactionHolder this$0, View it) {
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ae aeVar = ae.f112367a;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        ae.d(aeVar, context, 0L, 2, null);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return this$0.onLongClick(it);
    }

    public final void n(@NotNull gq0.d guildReactionItem, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(guildReactionItem, "guildReactionItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        r(guildReactionItem);
        if (!payloads.isEmpty()) {
            o(guildReactionItem, payloads);
            return;
        }
        s();
        View view = this.itemView;
        FlexboxLayoutManager.LayoutParams layoutParams = new FlexboxLayoutManager.LayoutParams(-2, x.a(28.0f));
        layoutParams.setMarginEnd(x.a(6.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = x.a(5.0f);
        view.setLayoutParams(layoutParams);
        o(guildReactionItem, payloads);
    }

    protected abstract void o(@NotNull gq0.d item, @NotNull List<? extends Object> payloads);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        EventCollector.getInstance().onViewLongClicked(v3);
        return false;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final d getAdapter() {
        return this.adapter;
    }

    @NotNull
    public final gq0.d q() {
        gq0.d dVar = this.guildReactionItem;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildReactionItem");
        return null;
    }

    public final void r(@NotNull gq0.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.guildReactionItem = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        Resources resources = this.itemView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "itemView.resources");
        Drawable e16 = ReactionUtilsKt.e(resources, MsgExtKt.S(q().getMsg()));
        this.itemView.setBackground(e16);
        this.itemView.invalidateDrawable(e16);
    }
}
