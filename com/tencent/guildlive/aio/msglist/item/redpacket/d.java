package com.tencent.guildlive.aio.msglist.item.redpacket;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\n\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/redpacket/d;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "K1", "currentMsgItem", "", "I1", "J1", "Landroid/view/View;", "d1", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "", "w1", "A1", "z1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "nickNameTv", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "nickView", "<init>", "(Landroid/view/View;)V", "G", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends AbsGuildLiveComponent {
    private static final int H = ViewUtils.dip2px(5.5f);
    private static final float I = ViewUtils.dip2px(14.0f);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView nickNameTv;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout nickView;

    public d(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        LinearLayout linearLayout = new LinearLayout(root.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        Context context = root.getContext();
        ViewExtKt.f(linearLayout, H);
        TextView textView = new TextView(context);
        this.nickNameTv = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        float f16 = I;
        textView.setTextSize(0, f16);
        linearLayout.addView(this.nickNameTv);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText("\uff1a");
        textView2.setTextColor(J1());
        textView2.setTextSize(0, f16);
        linearLayout.addView(textView2);
        this.nickView = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(d this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            yr0.a.l((Activity) mContext, (GuildMsgItem) msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int I1(GuildMsgItem currentMsgItem) {
        int h16 = h.f112401a.h(currentMsgItem, 4278190080L);
        if (h16 == -1 || h16 == -16777216) {
            return J1();
        }
        return h16;
    }

    private final int J1() {
        return this.root.getContext().getResources().getColor(R.color.bpx);
    }

    private final void K1(GuildMsgItem msgItem) {
        String str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        com.tencent.guildlive.aio.msglist.b bVar = new com.tencent.guildlive.aio.msglist.b(this.nickNameTv);
        String d16 = bVar.d(msgItem);
        if (yr0.a.k(msgItem)) {
            str = bVar.b(msgItem);
        } else {
            str = "";
        }
        spannableStringBuilder.insert(0, (CharSequence) (d16 + str));
        bVar.h(spannableStringBuilder, d16, I1(msgItem));
        if (!TextUtils.isEmpty(str)) {
            bVar.j(spannableStringBuilder, d16.length(), d16.length() + str.length(), I1(msgItem));
        }
        this.nickNameTv.setText(spannableStringBuilder);
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        K1(currentMsgItem);
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            this.nickNameTv.setTextIsSelectable(true);
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            z1(guildMsgItem);
            A1(guildMsgItem);
            this.nickNameTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.H1(d.this, msgItem, view);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.nickView;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected boolean w1() {
        return true;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        K1(currentMsgItem);
    }
}
