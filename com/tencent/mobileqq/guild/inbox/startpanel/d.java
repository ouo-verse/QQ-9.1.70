package com.tencent.mobileqq.guild.inbox.startpanel;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.main.view.GuildSummaryView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.summary.GuildSummaryText;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import er1.DrawableType;
import er1.UnreadDotType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public static final int S = QQGuildUIUtil.f(43.0f);
    private GuildUserAvatarView E;
    private TextView F;
    private GuildSummaryView G;
    private GuildDragTextView H;
    private TextView I;
    private final b J;
    private final DragFrameLayout K;
    private View L;
    private View M;
    private boolean N;
    private SwipeMenuLayout P;
    private TextView Q;
    private ImageView R;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, p pVar);

        void b(View view, p pVar);

        void c(View view, p pVar);
    }

    public d(@NonNull View view, @NonNull b bVar, @NonNull DragFrameLayout dragFrameLayout) {
        super(view);
        this.J = bVar;
        this.K = dragFrameLayout;
        A();
    }

    private void A() {
        this.P = (SwipeMenuLayout) this.itemView.findViewById(R.id.tu6);
        this.M = this.itemView.findViewById(R.id.u8p);
        this.E = (GuildUserAvatarView) this.itemView.findViewById(R.id.xlr);
        this.F = (TextView) this.itemView.findViewById(R.id.xlv);
        this.G = (GuildSummaryView) this.itemView.findViewById(R.id.f165797xm4);
        this.H = (GuildDragTextView) this.itemView.findViewById(R.id.xm8);
        this.I = (TextView) this.itemView.findViewById(R.id.xm5);
        this.L = this.itemView.findViewById(R.id.kab);
        this.R = (ImageView) this.itemView.findViewById(R.id.xlw);
        TextView textView = (TextView) this.itemView.findViewById(R.id.z3z);
        this.Q = textView;
        textView.setOnClickListener(this);
        this.E.setLogTag("Guild.C2C.GuildInboxC2CNodeViewHolder");
        this.H.setOnModeChangeListener(this.K);
        this.H.setDragViewType(0, this.itemView);
        GuildUserAvatarView guildUserAvatarView = this.E;
        int i3 = S;
        guildUserAvatarView.setTag(R.id.w0_, Integer.valueOf(i3));
        this.E.setTag(R.id.f165436w01, Integer.valueOf(i3));
        this.M.setOnClickListener(this);
        this.M.setOnLongClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Bitmap bitmap) {
        if (bitmap != null && this.E.getTag(R.id.wit) == "https://downv6.qq.com/innovate/guild/icon/guild_inbox_assistant_icon.png") {
            this.E.setImageBitmap(bitmap);
        }
    }

    private Map<String, ?> C(p pVar) {
        return Collections.singletonMap("sgrp_red_tips_type", Integer.valueOf(pVar.C.b()));
    }

    private void D(String str, p pVar) {
        VideoReport.setElementReuseIdentifier(this.itemView, pVar.f226295d + pVar.f226296e);
        ch.Y0(this.itemView, str, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    private void n(p pVar) {
        this.E.setTag(R.id.wit, null);
        if (TextUtils.equals(pVar.f226296e, String.valueOf(6))) {
            this.E.setImageResource(R.drawable.guild_skin_inbox_notice_icon);
            this.E.setBackgroundResource(R.drawable.guild_inbox_item_bg);
            D("em_sgrp_private_list_manage_node", pVar);
            return;
        }
        if (TextUtils.equals(pVar.f226296e, String.valueOf(7))) {
            this.E.setTag(R.id.wit, "https://downv6.qq.com/innovate/guild/icon/guild_inbox_assistant_icon.png");
            v.f("https://downv6.qq.com/innovate/guild/icon/guild_inbox_assistant_icon.png", this.E.getMeasuredWidth(), this.E.getMeasuredHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.c
                @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
                public final void a(Bitmap bitmap) {
                    d.this.B(bitmap);
                }
            });
            D("em_sgrp_channel_assitant", pVar);
            return;
        }
        if (TextUtils.equals(pVar.f226296e, String.valueOf(5))) {
            this.E.setImageResource(R.drawable.guild_icon_inbox_income);
            D("em_sgrp_account_change_notice", pVar);
            VideoReport.setElementParams(this.itemView, C(pVar));
        } else {
            if (TextUtils.equals(pVar.f226296e, String.valueOf(8))) {
                this.E.setImageResource(R.drawable.guild_icon_inbox_notice);
                D("em_sgrp_interaction_notice_entry", pVar);
                VideoReport.setElementParams(this.itemView, C(pVar));
                return;
            }
            this.E.setAvatarTinyId(pVar.F, pVar.f226298h);
            D("em_sgrp_private_list_node", pVar);
            if (TextUtils.isEmpty(pVar.f226298h)) {
                this.E.setImageResource(R.drawable.f160830com);
            } else {
                VideoReport.setElementParam(this.itemView, "sgrp_touin", pVar.f226298h);
                VideoReport.setElementParam(this.itemView, "sgrp_channel_id", pVar.f226297f);
            }
        }
    }

    private void o(p pVar) {
        if (pVar.C.f230840d <= 0 && pVar.I) {
            this.R.setVisibility(0);
            this.R.setImageDrawable(GuildUIUtils.w(this.itemView.getContext(), R.drawable.qui_remind_mute_new, Integer.valueOf(R.color.qui_common_text_tertiary)));
        } else {
            this.R.setVisibility(8);
        }
    }

    private void p(p pVar) {
        this.L.setVisibility(8);
    }

    private void q(p pVar) {
        GuildSummaryUIData guildSummaryUIData = pVar.D;
        if (guildSummaryUIData != null && !guildSummaryUIData.h()) {
            this.G.setVisibility(0);
            this.G.setTextColor(R.color.qui_common_feedback_normal, R.color.qui_common_text_secondary_light);
            this.G.setSummaryData(guildSummaryUIData);
        } else {
            if (pVar.G == 1) {
                if (TextUtils.equals(pVar.f226299i, this.G.getContext().getString(R.string.f154131dz))) {
                    return;
                }
                this.G.setVisibility(0);
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new GuildSummaryText(String.format(this.G.getContext().getString(R.string.f153651co), pVar.f226299i), GuildSummaryText.TextStyle.NORMAL));
                GuildSummaryUIData guildSummaryUIData2 = new GuildSummaryUIData(false, LastMessage.SendState.SEND_SUCCESS, arrayList, 0L);
                this.G.setTextColor(R.color.qui_common_feedback_normal, R.color.qui_common_text_secondary_light);
                this.G.setSummaryData(guildSummaryUIData2);
                return;
            }
            this.G.setVisibility(4);
        }
    }

    private void r(long j3) {
        String p16 = en.p(1000 * j3, true, "yy-MM-dd");
        if (j3 != 0 && !TextUtils.isEmpty(p16)) {
            this.I.setVisibility(0);
            this.I.setText(p16);
        } else {
            this.I.setVisibility(8);
        }
    }

    private void s(IGuildUnreadCntService.b bVar) {
        UnreadDotType w3;
        if (bVar.f230840d <= 0) {
            this.H.setVisibility(8);
            return;
        }
        int i3 = bVar.f230841e;
        if (i3 == 3) {
            i3 = 2;
        }
        if (i3 == 2) {
            w3 = x();
        } else if (this.N) {
            w3 = v();
        } else {
            w3 = w();
        }
        QQGuildUIUtil.P(this.H, bVar.f230840d, w3);
    }

    private void u(p pVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_touin", pVar.f226298h);
        hashMap.put("sgrp_channel_id", pVar.f226296e);
        hashMap.put("sgrp_menu_action_item", 3);
        ch.Y0(this.Q, "em_sgrp_node_slides_left", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementParams(this.Q, hashMap);
        this.P.setSwipeListener(new a());
    }

    private UnreadDotType v() {
        return new UnreadDotType(new DrawableType(R.drawable.guild_page_strong_unread_red_bg, null), R.color.qui_common_text_allwhite_primary);
    }

    private UnreadDotType w() {
        return new UnreadDotType(new DrawableType(R.drawable.guild_page_strong_unread_bg, null), R.color.qui_common_text_allwhite_primary);
    }

    private UnreadDotType x() {
        return new UnreadDotType(new DrawableType(R.drawable.guild_page_gray_unread_bg, null), R.color.qui_common_text_allwhite_primary);
    }

    private void y(View view, p pVar, int i3) {
        String F = DirectMessageNodeRepository.F(pVar.f226296e);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_touin", pVar.f226298h);
        hashMap.put("sgrp_channel_id", F);
        hashMap.put("sgrp_click_type", String.valueOf(i3));
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private void z(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    public void E(boolean z16) {
        this.N = z16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.itemView.getTag() instanceof p) {
            p pVar = (p) this.itemView.getTag();
            if (QLog.isDevelopLevel()) {
                QLog.i("Guild.C2C.GuildInboxC2CNodeViewHolder", 4, "onCLick: " + pVar);
            }
            if (this.Q == view) {
                this.P.l();
                this.J.c(view, pVar);
                VideoReport.reportEvent("clck", this.Q, null);
            } else {
                b bVar = this.J;
                View view2 = this.itemView;
                bVar.b(view2, (p) view2.getTag());
                int i3 = pVar.f226295d;
                if (i3 == 1) {
                    z(this.itemView);
                } else if (i3 == 0) {
                    y(this.itemView, pVar, 0);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        if (this.itemView.getTag() instanceof p) {
            p pVar = (p) this.itemView.getTag();
            if (QLog.isDevelopLevel()) {
                QLog.i("Guild.C2C.GuildInboxC2CNodeViewHolder", 4, String.format("onLongClick: ", this.itemView.getTag()));
            }
            this.J.a(this.itemView, pVar);
            if (pVar.f226295d == 0) {
                y(this.itemView, pVar, 1);
            }
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    public void t(p pVar) {
        int i3;
        this.itemView.setTag(pVar);
        this.H.setTag(pVar);
        this.F.setText(pVar.f226299i);
        n(pVar);
        r(pVar.f226300m);
        q(pVar);
        s(pVar.C);
        o(pVar);
        p(pVar);
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.guild_inbox_item_select_vas_back;
        } else {
            i3 = R.drawable.guild_inbox_item_select_back;
        }
        com.tencent.mobileqq.guild.main.b.c(this.M, i3);
        u(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements SwipeMenuLayout.e {
        a() {
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void a() {
            VideoReport.reportEvent("imp", d.this.Q, null);
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void b() {
        }
    }
}
