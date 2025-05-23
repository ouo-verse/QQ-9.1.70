package ny1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.schedule.list.k;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ny1.c;
import uy1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements i {
    public static final double J = Math.pow(10.0d, 12.0d);
    private final com.tencent.mobileqq.guild.mainframe.a C;
    private final k D;
    private Context E;
    private py1.a F;
    private List<GuildScheduleInfo> G = new ArrayList();
    private final JumpGuildParam H = new JumpGuildParam("", "");

    @SuppressLint({"NotifyDataSetChanged"})
    private final Runnable I = new Runnable() { // from class: ny1.b
        @Override // java.lang.Runnable
        public final void run() {
            c.this.z0();
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private final AppInterface f421580m = ch.l();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.ViewHolder {
        private py1.a E;
        private final View F;
        private final View G;
        private final TextView H;
        private final TextView I;
        private final ImageView J;
        private final TextView K;
        private final TextView L;
        private final ImageView M;
        private final TextView N;
        private final View P;
        private final ViewGroup Q;
        private final TextView R;
        private final Button S;

        public b(@NonNull View view) {
            super(view);
            this.F = view.findViewById(R.id.wyx);
            this.G = view.findViewById(R.id.f165616wz1);
            this.H = (TextView) view.findViewById(R.id.f165615wz0);
            this.I = (TextView) view.findViewById(R.id.wyt);
            this.J = (ImageView) view.findViewById(R.id.f165617wz2);
            this.K = (TextView) view.findViewById(R.id.wyz);
            this.L = (TextView) view.findViewById(R.id.wyq);
            this.M = (ImageView) view.findViewById(R.id.wys);
            this.N = (TextView) view.findViewById(R.id.wyr);
            this.P = view.findViewById(R.id.wyw);
            this.Q = (ViewGroup) view.findViewById(R.id.wyv);
            this.R = (TextView) view.findViewById(R.id.wyu);
            Button button = (Button) view.findViewById(R.id.wyp);
            this.S = button;
            button.setOnClickListener(new View.OnClickListener() { // from class: ny1.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.this.t(view2);
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: ny1.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.this.u(view2);
                }
            });
        }

        private void A(View view) {
            if (!(view instanceof ImageView)) {
                return;
            }
            view.setVisibility(0);
            String B = B(((IGPSService) c.this.f421580m.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
            if (TextUtils.isEmpty(B)) {
                return;
            }
            String n3 = QQGuildUIUtil.n(c.this.D.z(), B, c.this.f421580m);
            if (TextUtils.isEmpty(n3)) {
                return;
            }
            ((ImageView) view).setImageDrawable(ch.J(n3, QQGuildUIUtil.f(20.0f), new BitmapDrawable(QQGuildUIUtil.j(true)), true));
        }

        private String B(String str) {
            if (str == null) {
                return "";
            }
            return str;
        }

        private void C(GuildScheduleInfo guildScheduleInfo) {
            int i3;
            Button button = this.S;
            if (n(guildScheduleInfo)) {
                i3 = R.string.f155171gs;
            } else {
                i3 = R.string.f155331h8;
            }
            button.setText(i3);
        }

        private void D(GuildScheduleInfo guildScheduleInfo) {
            boolean z16;
            String str;
            boolean s16 = s(guildScheduleInfo);
            int inviteStatus = guildScheduleInfo.getInviteStatus();
            if (guildScheduleInfo.getStatus() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (s16) {
                A(this.M);
                this.N.setText(R.string.f155121gn);
                if (z16) {
                    this.N.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_text_secondary));
                } else {
                    this.N.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_brand_standard));
                }
            } else {
                GuildScheduleUser creator = guildScheduleInfo.getCreator();
                if (creator == null) {
                    str = "";
                } else {
                    str = creator.getAvatar();
                }
                x(this.M, str);
                this.N.setText(R.string.f155111gm);
                if (inviteStatus == 2) {
                    this.G.setActivated(false);
                    if (z16) {
                        this.R.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_text_secondary));
                    } else {
                        this.R.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_feedback_error));
                    }
                    this.R.setText(R.string.f155201gv);
                    A(this.Q.getChildAt(0));
                } else if (inviteStatus == 1) {
                    if (z16) {
                        this.R.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_text_secondary));
                    } else {
                        this.R.setTextColor(AppCompatResources.getColorStateList(c.this.E, R.color.qui_common_brand_standard));
                    }
                    this.R.setText(R.string.f155191gu);
                    A(this.Q.getChildAt(0));
                }
            }
            if (s16 || inviteStatus == 0) {
                ArrayList<GuildScheduleUser> acceptedUser = guildScheduleInfo.getAcceptedUser();
                int acceptedNums = guildScheduleInfo.getAcceptedNums();
                if (acceptedNums > 0 && acceptedUser != null) {
                    this.R.setText(p(R.string.f155181gt, Integer.valueOf(acceptedNums)));
                    int min = Math.min(this.Q.getChildCount(), acceptedUser.size());
                    for (int i3 = 0; i3 < min; i3++) {
                        x(this.Q.getChildAt(i3), acceptedUser.get(i3).getAvatar());
                    }
                    return;
                }
                this.P.setVisibility(8);
                this.R.setText("");
            }
        }

        private void E(GuildScheduleInfo guildScheduleInfo) {
            boolean z16;
            boolean z17;
            int i3;
            int i16;
            int i17;
            float f16;
            QBaseActivity activity = c.this.C.getActivity();
            Resources resources = activity.getResources();
            Resources.Theme theme = activity.getTheme();
            int status = guildScheduleInfo.getStatus();
            boolean z18 = true;
            if (status != 3 && status != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (status == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (status != 1) {
                z18 = false;
            }
            Button button = this.S;
            int i18 = 8;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            button.setVisibility(i3);
            ImageView imageView = this.J;
            if (z18) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            this.itemView.setActivated(z16);
            if (z16) {
                Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.guild_schedule_list_item_light_shape);
                if (drawable != null) {
                    drawable.setAlpha(102);
                }
                this.itemView.setBackground(drawable);
            } else {
                this.itemView.setBackgroundResource(R.drawable.guild_schedule_list_item_shape);
            }
            this.G.setActivated(!z17);
            TextView textView = this.I;
            if (z16) {
                i18 = 0;
            }
            textView.setVisibility(i18);
            int i19 = R.color.qui_common_text_secondary;
            if (!z17) {
                i17 = R.color.qui_common_text_primary;
            } else {
                i17 = R.color.qui_common_text_secondary;
            }
            this.H.setTextColor(ResourcesCompat.getColorStateList(resources, i17, theme));
            this.K.setTextColor(ResourcesCompat.getColorStateList(resources, i17, theme));
            if (z16) {
                i19 = R.color.guild_schedule_item_activated_content;
            }
            this.L.setTextColor(ResourcesCompat.getColorStateList(resources, i19, theme));
            this.N.setTextColor(ResourcesCompat.getColorStateList(resources, i19, theme));
            this.R.setTextColor(ResourcesCompat.getColorStateList(resources, i19, theme));
            if (z17) {
                f16 = 0.6f;
            } else {
                f16 = 1.0f;
            }
            this.G.setAlpha(f16);
            this.L.setAlpha(f16);
            this.M.setAlpha(f16);
            this.N.setAlpha(f16);
            this.P.setAlpha(f16);
            this.Q.setAlpha(f16);
            this.R.setAlpha(f16);
            this.S.setAlpha(f16);
            if (status == 3) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(R.drawable.guild_schedule_indicator_started_tint, 0, 0, 0);
                this.I.setText(R.string.f155281h3);
                this.I.setTextColor(ContextCompat.getColorStateList(activity, R.color.qui_common_brand_standard));
                Drawable drawable2 = ContextCompat.getDrawable(activity, R.drawable.guild_schedule_list_item_indicator_background);
                if (drawable2 != null) {
                    drawable2.setAlpha(33);
                }
                this.I.setBackground(drawable2);
                return;
            }
            if (status == 2) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(R.drawable.guild_schedule_indicator_soon_new, 0, 0, 0);
                this.I.setText(R.string.f155271h2);
                this.G.setBackground(activity.getResources().getDrawable(R.drawable.guild_schedule_list_item_vertical_pending_line));
                this.I.setTextColor(activity.getResources().getColor(R.color.bu8));
                this.I.setBackground(activity.getResources().getDrawable(R.drawable.guild_schedule_list_item_indicator_ready_background));
                this.itemView.setBackground(activity.getResources().getDrawable(R.drawable.guild_schedule_list_item_background_orange));
            }
        }

        private void H(GuildScheduleInfo guildScheduleInfo) {
            int i3;
            w();
            this.H.setText(B(guildScheduleInfo.getTitle()));
            String B = B(guildScheduleInfo.getContent());
            boolean isEmpty = TextUtils.isEmpty(B);
            this.L.setText(B);
            TextView textView = this.L;
            if (isEmpty) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            E(guildScheduleInfo);
            this.K.setText(ty1.c.b(guildScheduleInfo.getStartTimeMs(), guildScheduleInfo.getEndTimeMs(), guildScheduleInfo.getDateMs()));
            D(guildScheduleInfo);
            C(guildScheduleInfo);
        }

        private boolean n(GuildScheduleInfo guildScheduleInfo) {
            boolean z16;
            if (guildScheduleInfo == null) {
                return false;
            }
            GuildScheduleChannelInfo channelInfo = guildScheduleInfo.getChannelInfo();
            if (channelInfo != null && channelInfo.getGuildId() != 0 && channelInfo.getChannelId() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            if (channelInfo.isPrivate() && !channelInfo.isHasJoin()) {
                return false;
            }
            return true;
        }

        private GuildScheduleInfo o() {
            int adapterPosition;
            if (c.this.G.isEmpty() || (adapterPosition = getAdapterPosition()) < 0 || adapterPosition >= c.this.G.size()) {
                return null;
            }
            return (GuildScheduleInfo) c.this.G.get(adapterPosition);
        }

        private void q(GuildScheduleInfo guildScheduleInfo) {
            String str;
            String[] strArr = new String[2];
            strArr[0] = "schedule_list_item_info";
            if (guildScheduleInfo != null) {
                str = guildScheduleInfo.toString();
            } else {
                str = "";
            }
            strArr[1] = str;
            ty1.a.b("gpro_quality#event#schedule_channel_list", "schedule_list_schedule_item_click", ty1.a.e(strArr));
            if (guildScheduleInfo == null) {
                return;
            }
            o02.a.f(4);
            Intent ai5 = GuildScheduleDetailFragment.ai(this.itemView.getContext(), guildScheduleInfo, c.this.D.z(), c.this.D.w(), String.valueOf(guildScheduleInfo.getScheduleId()), c.this.H);
            ty1.a.g("gpro_quality#event#schedule_channel_detail");
            GuildSplitViewUtils.f235370a.o(this.itemView.getContext(), ai5, GuildScheduleDetailFragment.class, LaunchMode.standard);
        }

        private void r(GuildScheduleInfo guildScheduleInfo) {
            if (guildScheduleInfo == null) {
                return;
            }
            if (n(guildScheduleInfo)) {
                v(guildScheduleInfo);
            } else {
                q(guildScheduleInfo);
            }
        }

        private boolean s(GuildScheduleInfo guildScheduleInfo) {
            String valueOf;
            if (guildScheduleInfo == null) {
                return false;
            }
            String B = B(((IGPSService) c.this.f421580m.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
            GuildScheduleUser creator = guildScheduleInfo.getCreator();
            if (creator == null) {
                valueOf = B;
            } else {
                valueOf = String.valueOf(creator.getTinyId());
            }
            return TextUtils.equals(B, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a(view)) {
                r(o());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a(view)) {
                q(o());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private void v(GuildScheduleInfo guildScheduleInfo) {
            gr1.a.b(c.this.C, String.valueOf(guildScheduleInfo.getChannelInfo().getGuildId()), ty1.d.b(c.this.f421580m, guildScheduleInfo, c.this.D.w()), o02.a.a(4));
        }

        private void w() {
            QBaseActivity activity = c.this.C.getActivity();
            Resources resources = activity.getResources();
            Resources.Theme theme = activity.getTheme();
            ViewCompat.setBackground(this.itemView, ResourcesCompat.getDrawable(resources, R.drawable.guild_schedule_list_item_shape, theme));
            ViewCompat.setBackground(this.G, ResourcesCompat.getDrawable(resources, R.drawable.guild_schedule_list_item_vertical_line, theme));
            ViewCompat.setBackground(this.J, ResourcesCompat.getDrawable(resources, R.drawable.guild_schedule_indicator_waiting, theme));
            ViewCompat.setBackground(this.I, ResourcesCompat.getDrawable(resources, R.drawable.guild_schedule_list_item_indicator_background, theme));
            ViewCompat.setBackground(this.S, ResourcesCompat.getDrawable(resources, R.drawable.guild_schedule_list_item_button_background, theme));
            this.P.setVisibility(0);
            int childCount = this.Q.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.Q.getChildAt(i3).setVisibility(8);
            }
        }

        private void x(View view, String str) {
            if (!(view instanceof ImageView)) {
                return;
            }
            view.setVisibility(0);
            int f16 = QQGuildUIUtil.f(20.0f);
            ((ImageView) view).setImageDrawable(((IQQGuildAvatarApi) c.this.f421580m.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str, f16, f16, (String) null));
        }

        private void y(GuildScheduleInfo guildScheduleInfo) {
            String str;
            long scheduleId = guildScheduleInfo.getScheduleId();
            boolean n3 = n(guildScheduleInfo);
            boolean s16 = s(guildScheduleInfo);
            int status = guildScheduleInfo.getStatus();
            int inviteStatus = guildScheduleInfo.getInviteStatus();
            if (n3) {
                str = "em_sgrp_join_event";
            } else {
                str = "em_sgrp_view_details";
            }
            VideoReport.setElementId(this.S, str);
            VideoReport.setElementReuseIdentifier(this.S, str + scheduleId);
            Button button = this.S;
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(button, clickPolicy);
            Button button2 = this.S;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(button2, exposurePolicy);
            Button button3 = this.S;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            VideoReport.setElementEndExposePolicy(button3, endExposurePolicy);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_acceptance_status", Integer.valueOf(inviteStatus));
            hashMap.put("sgrp_creator_status", Integer.valueOf(s16 ? 1 : 0));
            VideoReport.setElementParams(this.S, hashMap);
            VideoReport.setElementId(this.itemView, "em_sgrp_event_card");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sgrp_event_status", Integer.valueOf(status));
            hashMap2.put("sgrp_acceptance_status", Integer.valueOf(inviteStatus));
            hashMap2.put("sgrp_creator_status", Integer.valueOf(s16 ? 1 : 0));
            VideoReport.setElementReuseIdentifier(this.itemView, "em_sgrp_event_card" + scheduleId);
            VideoReport.setElementClickPolicy(this.itemView, clickPolicy);
            VideoReport.setElementExposePolicy(this.itemView, exposurePolicy);
            VideoReport.setElementEndExposePolicy(this.itemView, endExposurePolicy);
            VideoReport.setElementParams(this.itemView, hashMap2);
        }

        public String p(int i3, Object... objArr) {
            if (c.this.C != null && c.this.C.getActivity() != null) {
                return c.this.C.getActivity().getString(i3, objArr);
            }
            return "";
        }

        public void z(py1.a aVar, GuildScheduleInfo guildScheduleInfo) {
            if (aVar != null && guildScheduleInfo != null) {
                this.E = aVar;
                H(guildScheduleInfo);
                y(guildScheduleInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* renamed from: ny1.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C10871c extends RecyclerView.ViewHolder {
        TextView E;
        GuildScheduleInfo F;

        public C10871c(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.wxp);
            if (c.this.D.F()) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            this.E.setOnClickListener(new View.OnClickListener() { // from class: ny1.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.C10871c.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a(view)) {
                py1.a aVar = new py1.a();
                aVar.g(this.F.getDateMs());
                c.this.D.u(null, aVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void n(GuildScheduleInfo guildScheduleInfo) {
            this.F = guildScheduleInfo;
            ((ViewGroup) this.E.getParent()).setBackgroundResource(0);
            ((ViewGroup) this.E.getParent()).setBackgroundResource(R.drawable.lvj);
        }
    }

    public c(com.tencent.mobileqq.guild.mainframe.a aVar, k kVar) {
        this.C = aVar;
        this.D = kVar;
        this.E = aVar.getActivity();
    }

    private long C0() {
        long j3 = -1;
        if (this.G.isEmpty()) {
            return -1L;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        int size = this.G.size();
        long j16 = -1;
        long j17 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            GuildScheduleInfo guildScheduleInfo = this.G.get(i3);
            long startTimeMs = guildScheduleInfo.getStartTimeMs() - timeInMillis;
            long endTimeMs = guildScheduleInfo.getEndTimeMs() - timeInMillis;
            long reminderTimeMs = startTimeMs - guildScheduleInfo.reminderTimeMs();
            if (reminderTimeMs > 0 && (j3 < 0 || reminderTimeMs < j3)) {
                j3 = reminderTimeMs;
            }
            if (j17 < 0 && startTimeMs > 0) {
                j17 = startTimeMs;
            }
            if (endTimeMs > 0 && (j16 < 0 || endTimeMs < j16)) {
                j16 = endTimeMs;
            }
        }
        if (j3 < 0) {
            if (j17 > 0 && j16 > 0) {
                return Math.min(j17, j16);
            }
            return Math.max(j17, j16);
        }
        if (j17 < 0) {
            if (j16 > 0) {
                return Math.min(j3, j16);
            }
            return j3;
        }
        if (j16 < 0) {
            return Math.min(j3, j17);
        }
        return Math.min(j3, Math.min(j17, j16));
    }

    public static String D0(long j3, boolean z16) {
        LocalDate now;
        if (j3 <= J) {
            j3 *= 1000;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long j16 = serverTimeMillis / 86400000;
        long j17 = j3 / 86400000;
        if (Build.VERSION.SDK_INT >= 26) {
            now = LocalDate.now();
            now.atTime(0, 0, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(serverTimeMillis);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        int i18 = calendar2.get(1);
        int i19 = calendar2.get(2);
        int i26 = calendar2.get(5);
        if (i3 == i18 && i16 == i19 && i17 == i26) {
            return "\u4eca\u5929";
        }
        if (calendar.get(1) == calendar2.get(1)) {
            return new SimpleDateFormat("M\u6708d\u65e5").format(calendar.getTime()) + " " + y0(calendar);
        }
        return new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(calendar.getTime()) + " " + y0(calendar);
    }

    private void E0() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        uIHandlerV2.removeCallbacks(this.I);
        long C0 = C0();
        if (C0 >= 0 && C0 <= 86400000) {
            uIHandlerV2.postDelayed(this.I, C0 + 500);
        }
    }

    private List<Integer> v0(long j3) {
        ArrayList arrayList = new ArrayList();
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            if (this.G.get(i3).getScheduleId() == j3) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static String y0(Calendar calendar) {
        switch (calendar.get(7)) {
            case 1:
                return "\u5468\u65e5";
            case 2:
                return "\u5468\u4e00";
            case 3:
                return "\u5468\u4e8c";
            case 4:
                return "\u5468\u4e09";
            case 5:
                return "\u5468\u56db";
            case 6:
                return "\u5468\u4e94";
            case 7:
                return "\u5468\u516d";
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        notifyDataSetChanged();
        E0();
    }

    public void A0(GuildScheduleInfo guildScheduleInfo) {
        Iterator<Integer> it = v0(guildScheduleInfo.getScheduleId()).iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            try {
                GuildScheduleInfo guildScheduleInfo2 = (GuildScheduleInfo) guildScheduleInfo.clone();
                guildScheduleInfo2.setDateMs(this.G.get(intValue).getDateMs());
                this.G.set(intValue, guildScheduleInfo2);
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
            }
        }
        notifyDataSetChanged();
    }

    public void B0(long j3, int i3) {
        Iterator<Integer> it = v0(j3).iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            this.G.get(intValue).updateInviteStatus(i3);
            notifyItemChanged(intValue);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void F0(py1.a aVar, List<GuildScheduleInfo> list) {
        this.F = aVar;
        this.G.clear();
        notifyDataSetChanged();
        this.G.addAll(list);
        notifyDataSetChanged();
    }

    @Override // uy1.i
    public RecyclerView.ViewHolder I(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f7j, viewGroup, false));
    }

    @Override // uy1.i
    public void d(RecyclerView.ViewHolder viewHolder, int i3) {
        if (i3 >= 0 && i3 < this.G.size()) {
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.f165615wz0);
            String D0 = D0(this.G.get(i3).getDateMs(), true);
            textView.setText(D0);
            if (TextUtils.equals(D0, this.E.getString(R.string.f157751nr))) {
                textView.setTextColor(this.E.getResources().getColorStateList(R.color.qui_common_brand_standard));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.G.isEmpty()) {
            return this.G.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        GuildScheduleInfo guildScheduleInfo = this.G.get(i3);
        if (guildScheduleInfo != null && guildScheduleInfo.getScheduleId() == 1000) {
            return 1000;
        }
        return super.getItemViewType(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (i3 >= 0 && i3 < this.G.size()) {
            if (getItemViewType(i3) == 1000) {
                ((C10871c) viewHolder).n(this.G.get(i3));
            } else {
                ((b) viewHolder).z(this.F, this.G.get(i3));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(this.C.getActivity());
        if (i3 == 1000) {
            return new C10871c(from.inflate(R.layout.f7k, viewGroup, false));
        }
        View inflate = from.inflate(R.layout.f7i, viewGroup, false);
        com.tencent.mobileqq.guild.component.token.c.b(inflate, null);
        return new b(inflate);
    }

    public void p0(py1.a aVar, List<GuildScheduleInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.F = aVar;
            int size = this.G.size();
            this.G.addAll(size, list);
            notifyItemRangeInserted(size, list.size());
        }
    }

    public void q0(py1.a aVar, List<GuildScheduleInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.F = aVar;
            this.G.addAll(0, list);
            notifyItemRangeInserted(0, list.size());
        }
    }

    @Override // uy1.i
    public long r(int i3) {
        if (i3 >= this.G.size()) {
            return -1L;
        }
        return this.G.get(i3).getDateMs();
    }

    public void r0(GuildScheduleInfo guildScheduleInfo) {
        int i3 = 0;
        int i16 = -1;
        while (i3 < this.G.size()) {
            GuildScheduleInfo guildScheduleInfo2 = this.G.get(i3);
            if (guildScheduleInfo.getDateMs() < guildScheduleInfo2.getDateMs() && i16 == -1) {
                i16 = i3;
            }
            if (guildScheduleInfo2.getScheduleId() == 1000) {
                this.G.remove(i3);
                i3--;
            }
            i3++;
        }
        if (i16 == -1) {
            i16 = this.G.size();
        }
        this.G.add(i16, guildScheduleInfo);
        notifyDataSetChanged();
    }

    public void s0(GuildClientParams guildClientParams) {
        if (guildClientParams == null) {
            QLog.i("Guild.sch.GuildScheduleListAdapte", 1, "[configJoinGuildParams] launchParams is null");
            return;
        }
        this.H.guildId = guildClientParams.G();
        Bundle F = guildClientParams.F();
        if (F == null) {
            QLog.i("Guild.sch.GuildScheduleListAdapte", 1, "[configJoinGuildParams] guildExtra is null");
            return;
        }
        if (F.containsKey("guild_id")) {
            this.H.guildId = F.getString("guild_id");
        }
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) F.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        if (joinInfoParam != null) {
            this.H.setJoinInfoParam(joinInfoParam);
        }
    }

    public void t0(GuildScheduleInfo guildScheduleInfo) {
        List<Integer> v06 = v0(guildScheduleInfo.getScheduleId());
        if (v06.isEmpty()) {
            return;
        }
        for (int size = v06.size() - 1; size >= 0; size--) {
            this.G.remove(v06.get(size).intValue());
        }
        notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        if (r1 >= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
    
        r1 = getItemCount() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        return java.lang.Math.max(r1, 0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int u0(long j3, py1.a aVar) {
        int i3 = -1;
        if (j3 >= 0) {
            int itemCount = getItemCount();
            for (int i16 = 0; i16 < itemCount; i16++) {
                if (this.G.get(i16).getScheduleId() == j3) {
                    return i16;
                }
            }
            return -1;
        }
        int itemCount2 = getItemCount();
        int i17 = 0;
        while (true) {
            if (i17 >= itemCount2) {
                break;
            }
            GuildScheduleInfo guildScheduleInfo = this.G.get(i17);
            if (guildScheduleInfo.getDateMs() >= aVar.d() && guildScheduleInfo.getDateMs() < aVar.d() + 86400000) {
                if (guildScheduleInfo.getStatus() != 4) {
                    return i17;
                }
                if (i3 < 0) {
                    i3 = i17;
                }
            } else if (guildScheduleInfo.getDateMs() > aVar.d() && i3 < 0) {
                i3 = i17;
                break;
            }
            i17++;
        }
    }

    public GuildScheduleInfo w0(int i3) {
        List<GuildScheduleInfo> list = this.G;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.G.get(i3);
        }
        return null;
    }

    public List<GuildScheduleInfo> x0() {
        return this.G;
    }
}
