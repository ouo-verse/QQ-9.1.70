package cx1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.robot.components.base.widget.LinearCircleCommonGuildLayout;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPanelList;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotImageInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x106a.oidb_0x106a$RobotInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ba implements c, d {

    /* renamed from: a, reason: collision with root package name */
    private b f392217a;

    /* renamed from: b, reason: collision with root package name */
    private e f392218b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f392219c;

    /* renamed from: d, reason: collision with root package name */
    private GProGuildRobotInfoRsp f392220d;

    /* renamed from: e, reason: collision with root package name */
    private RobotInfo f392221e;

    /* renamed from: f, reason: collision with root package name */
    private GProGuildRobotData f392222f;

    /* renamed from: g, reason: collision with root package name */
    private int f392223g;

    /* renamed from: h, reason: collision with root package name */
    private cx1.a f392224h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, Object> f392225i;

    /* renamed from: j, reason: collision with root package name */
    private dx1.e f392226j;

    /* renamed from: k, reason: collision with root package name */
    private dx1.f f392227k;

    /* renamed from: l, reason: collision with root package name */
    private dx1.a f392228l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f392229m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f392230n = true;

    /* renamed from: o, reason: collision with root package name */
    private a f392231o;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class a implements com.tencent.mobileqq.guild.theme.d {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ba> f392232d;

        public a(WeakReference<ba> weakReference) {
            this.f392232d = weakReference;
        }

        @Override // com.tencent.mobileqq.guild.theme.d
        public void onThemeChanged() {
            if (this.f392232d.get() != null) {
                com.tencent.mobileqq.guild.theme.c.a(this.f392232d.get().f392217a.f392242j);
                com.tencent.mobileqq.guild.theme.c.a(this.f392232d.get().f392217a.f392242j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {
        private RelativeLayout A;
        private ImageView B;
        private TextView C;
        private TextView D;
        private TextView E;
        private TextView F;
        private LinearLayout G;
        private LinearLayout H;

        /* renamed from: a, reason: collision with root package name */
        private View f392233a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f392234b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f392235c;

        /* renamed from: d, reason: collision with root package name */
        private QUIButton f392236d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f392237e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f392238f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f392239g;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f392240h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f392241i;

        /* renamed from: j, reason: collision with root package name */
        private RecyclerView f392242j;

        /* renamed from: k, reason: collision with root package name */
        private LinearLayout f392243k;

        /* renamed from: l, reason: collision with root package name */
        private RecyclerView f392244l;

        /* renamed from: m, reason: collision with root package name */
        private LinearLayout f392245m;

        /* renamed from: n, reason: collision with root package name */
        private TipsBar f392246n;

        /* renamed from: o, reason: collision with root package name */
        private FrameLayout f392247o;

        /* renamed from: p, reason: collision with root package name */
        private TextView f392248p;

        /* renamed from: q, reason: collision with root package name */
        private View f392249q;

        /* renamed from: r, reason: collision with root package name */
        private View f392250r;

        /* renamed from: s, reason: collision with root package name */
        private LinearLayout f392251s;

        /* renamed from: t, reason: collision with root package name */
        private QUIButton f392252t;

        /* renamed from: u, reason: collision with root package name */
        private QUIButton f392253u;

        /* renamed from: v, reason: collision with root package name */
        private LinearLayout f392254v;

        /* renamed from: w, reason: collision with root package name */
        private TextView f392255w;

        /* renamed from: x, reason: collision with root package name */
        private LinearLayout f392256x;

        /* renamed from: y, reason: collision with root package name */
        private RecyclerView f392257y;

        /* renamed from: z, reason: collision with root package name */
        private ImageView f392258z;

        b() {
        }
    }

    public ba(e eVar, View view) {
        this.f392218b = eVar;
        this.f392219c = new WeakReference<>(this.f392218b.b());
        this.f392218b.t(this);
        this.f392221e = eVar.k();
        U(view);
    }

    private void A0() {
        if (this.f392217a.f392249q != null) {
            this.f392217a.f392249q.setVisibility(0);
        }
    }

    private void B0(int i3) {
        this.f392217a.f392246n.setTipsText(this.f392217a.f392246n.getResources().getString(i3));
        this.f392217a.f392246n.setVisibility(0);
    }

    private void C0(GProGuildRobotData gProGuildRobotData, int i3) {
        boolean z16;
        String g16 = this.f392218b.g();
        if (!g16.isEmpty()) {
            z16 = com.tencent.mobileqq.guild.util.as.h(g16, 100002);
            QLog.d("RobotInfoUI", 4, "updateBlackBtn hasPermission=", Boolean.valueOf(z16));
        } else {
            z16 = false;
        }
        if (z16) {
            z0(true);
        } else {
            z0(false);
        }
    }

    private void E0(GProGuildRobotData gProGuildRobotData, int i3) {
        boolean z16;
        String g16 = this.f392218b.g();
        if (!g16.isEmpty()) {
            z16 = com.tencent.mobileqq.guild.util.as.h(g16, 100001);
            if (!z16) {
                z16 = com.tencent.mobileqq.guild.util.as.h(g16, 100002);
            }
            QLog.d("RobotInfoUI", 4, "updateRemoveBtn hasPermission=", Boolean.valueOf(z16));
        } else {
            z16 = false;
        }
        if (z16) {
            this.f392217a.f392237e.setVisibility(0);
        } else {
            this.f392217a.f392237e.setVisibility(8);
        }
    }

    private void F0(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        if (this.f392219c.get() == null) {
            return;
        }
        O();
        if (gProGuildRobotInfoRsp != null) {
            this.f392217a.f392250r.setVisibility(0);
            this.f392220d = gProGuildRobotInfoRsp;
            Q();
            x0(gProGuildRobotInfoRsp.getPanelDataList());
            v0(gProGuildRobotInfoRsp.getCommands());
            S();
            R();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 4, R.string.f154081du, 0).show();
        this.f392218b.a();
    }

    private void G(int i3) {
        this.f392217a.f392251s.setVisibility(0);
        this.f392217a.f392236d.setVisibility(8);
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
        this.f392217a.f392253u.setOnClickListener(new View.OnClickListener() { // from class: cx1.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.V(view);
            }
        });
        if (i3 == 0) {
            this.f392217a.f392252t.setText(R.string.f153391bz);
            this.f392217a.f392252t.setOnClickListener(new View.OnClickListener() { // from class: cx1.ap
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.W(view);
                }
            });
        } else {
            this.f392217a.f392252t.setText(R.string.f153431c3);
            this.f392217a.f392252t.setOnClickListener(new View.OnClickListener() { // from class: cx1.aq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.X(view);
                }
            });
        }
        rx1.a.a(this.f392217a.f392253u, "em_qqrobot_private");
    }

    private void G0(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        String panelTitle = gProGuildRobotInfoRsp.getPanelTitle();
        TextView textView = (TextView) this.f392217a.f392250r.findViewById(R.id.f111236ko);
        if (!TextUtils.isEmpty(panelTitle)) {
            textView.setText(panelTitle);
        }
        TextView textView2 = (TextView) this.f392217a.f392250r.findViewById(R.id.f110096hl);
        String previewImagesTitle = gProGuildRobotInfoRsp.getPreviewImagesTitle();
        if (!TextUtils.isEmpty(previewImagesTitle)) {
            textView2.setText(previewImagesTitle);
        }
    }

    private void H(final int i3) {
        int i16;
        this.f392217a.f392236d.setVisibility(0);
        this.f392217a.f392251s.setVisibility(8);
        if (i3 != 0) {
            i16 = R.string.f153431c3;
        } else {
            i16 = R.string.f153421c2;
        }
        this.f392217a.f392236d.setText(i16);
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
        this.f392217a.f392236d.setOnClickListener(new View.OnClickListener() { // from class: cx1.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.Y(i3, view);
            }
        });
    }

    private void I(boolean z16, boolean z17, GProGuildRobotData gProGuildRobotData, int i3) {
        int i16;
        String str;
        if (!z16) {
            rx1.a.a(this.f392217a.f392236d, "em_qqrobot_add_channel");
            if (this.f392223g > 0) {
                G(i3);
                return;
            } else {
                H(i3);
                return;
            }
        }
        this.f392217a.f392251s.setVisibility(0);
        this.f392217a.f392236d.setVisibility(8);
        if (this.f392218b.l(gProGuildRobotData)) {
            i16 = R.string.f143350lu;
        } else {
            i16 = R.string.f158121or;
        }
        this.f392217a.f392252t.setText(i16);
        this.f392217a.f392252t.setOnClickListener(new View.OnClickListener() { // from class: cx1.ay
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.Z(view);
            }
        });
        if (i3 != 0) {
            QUIButton qUIButton = this.f392217a.f392236d;
            if (this.f392218b.l(gProGuildRobotData)) {
                str = "em_qqrobot_microphone_down";
            } else {
                str = "em_qqrobot_microphone_up";
            }
            rx1.a.a(qUIButton, str);
            this.f392217a.f392253u.setOnClickListener(new View.OnClickListener() { // from class: cx1.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.b0(view);
                }
            });
            this.f392217a.f392237e.setOnClickListener(new View.OnClickListener() { // from class: cx1.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.c0(view);
                }
            });
            this.f392217a.f392238f.setOnClickListener(new View.OnClickListener() { // from class: cx1.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.d0(view);
                }
            });
            rx1.a.a(this.f392217a.f392253u, "em_qqrobot_private");
            E0(gProGuildRobotData, i3);
            C0(gProGuildRobotData, i3);
            return;
        }
        this.f392217a.f392253u.setOnClickListener(new View.OnClickListener() { // from class: cx1.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.a0(view);
            }
        });
        rx1.a.a(this.f392217a.f392253u, "em_qqrobot_private");
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
    }

    private void J() {
        this.f392217a.f392251s.setVisibility(8);
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
        this.f392217a.f392236d.setText(R.string.f153401c0);
        this.f392217a.f392236d.setOnClickListener(new View.OnClickListener() { // from class: cx1.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.e0(view);
            }
        });
    }

    private void K(final int i3) {
        this.f392217a.f392251s.setVisibility(0);
        this.f392217a.f392236d.setVisibility(8);
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
        if (i3 != 0) {
            this.f392217a.f392252t.setText(R.string.f153431c3);
        } else {
            this.f392217a.f392252t.setText(R.string.f153391bz);
        }
        this.f392217a.f392252t.setOnClickListener(new View.OnClickListener() { // from class: cx1.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.f0(i3, view);
            }
        });
        this.f392217a.f392253u.setOnClickListener(new View.OnClickListener() { // from class: cx1.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.g0(view);
            }
        });
    }

    private void L(final int i3) {
        int i16;
        this.f392217a.f392251s.setVisibility(8);
        this.f392217a.f392236d.setVisibility(0);
        this.f392217a.f392237e.setVisibility(8);
        z0(false);
        if (i3 != 0) {
            i16 = R.string.f153441c4;
        } else {
            i16 = R.string.f153421c2;
        }
        this.f392217a.f392236d.setText(i16);
        this.f392217a.f392236d.setOnClickListener(new View.OnClickListener() { // from class: cx1.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.h0(i3, view);
            }
        });
    }

    private void M(boolean z16, boolean z17, GProGuildRobotData gProGuildRobotData, int i3) {
        if (z16) {
            this.f392217a.f392251s.setVisibility(0);
            this.f392217a.f392236d.setVisibility(8);
            if (i3 != 0) {
                this.f392217a.f392252t.setText(R.string.f153401c0);
            } else {
                this.f392217a.f392252t.setText(R.string.f153391bz);
            }
            this.f392217a.f392252t.setOnClickListener(new View.OnClickListener() { // from class: cx1.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.i0(view);
                }
            });
            this.f392217a.f392237e.setOnClickListener(new View.OnClickListener() { // from class: cx1.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.j0(view);
                }
            });
            this.f392217a.f392238f.setOnClickListener(new View.OnClickListener() { // from class: cx1.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.k0(view);
                }
            });
            this.f392217a.f392253u.setOnClickListener(new View.OnClickListener() { // from class: cx1.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ba.this.l0(view);
                }
            });
            rx1.a.a(this.f392217a.f392253u, "em_qqrobot_private");
            E0(gProGuildRobotData, i3);
            C0(gProGuildRobotData, i3);
        } else if (this.f392223g > 0) {
            K(i3);
        } else {
            L(i3);
        }
        String str = "em_qqrobot_remove_channel";
        if (z17) {
            TextView textView = this.f392217a.f392237e;
            if (!z16) {
                str = "em_qqrobot_add_channel";
            }
            rx1.a.a(textView, str);
        } else {
            QUIButton qUIButton = this.f392217a.f392236d;
            if (!z16) {
                str = "em_qqrobot_add_personal";
            }
            rx1.a.a(qUIButton, str);
        }
        rx1.a.a(this.f392217a.f392252t, "em_qqrobot_add_personal");
    }

    private void O() {
        if (this.f392217a.f392249q != null) {
            this.f392217a.f392249q.setVisibility(8);
        }
    }

    private void P() {
        final Context applicationContext = this.f392218b.b().getApplicationContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(applicationContext, 2);
        this.f392217a.F.setVisibility(8);
        this.f392217a.f392244l.setLayoutManager(gridLayoutManager);
        this.f392228l = new dx1.a();
        this.f392217a.f392244l.setAdapter(this.f392228l);
        this.f392217a.f392245m.setOnClickListener(new View.OnClickListener() { // from class: cx1.ax
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.m0(applicationContext, view);
            }
        });
    }

    private void Q() {
        VideoReport.addToDetectionWhitelist(this.f392219c.get());
        VideoReport.setPageId(this.f392217a.f392233a, "pg_qqrobot_card");
        VideoReport.setElementExposePolicy(this.f392217a.f392233a, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f392217a.f392233a, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.f392217a.f392233a, EndExposurePolicy.REPORT_ALL);
        if (this.f392220d != null) {
            String str = "";
            IGProGuildInfo guildInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(this.f392218b.g());
            if (guildInfo != null) {
                str = guildInfo.getGuildName();
            }
            this.f392225i = new HashMap<>();
            GProGuildRobotData robotData = this.f392220d.getRobotData();
            this.f392225i.put("qq_robot_invite_state", Integer.valueOf(robotData.getShowInvite()));
            this.f392225i.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
            this.f392225i.put("qq_robot_role_type", Integer.valueOf(this.f392220d.getRole()));
            this.f392225i.put("qq_robot_robot_id", Long.valueOf(robotData.getRobotUin()));
            this.f392225i.put("qq_robot_user_from", this.f392218b.d());
            this.f392225i.put("qq_robot_robot_role_type", Integer.valueOf(this.f392220d.getRole()));
            this.f392225i.put("qq_robot_channel_id", this.f392218b.g());
            this.f392225i.put("qq_robot_channel_name", str);
            this.f392225i.put("robot_import_source", Integer.valueOf(this.f392218b.j()));
            VideoReport.setPageParams(this.f392217a.f392233a, new PageParams(this.f392225i));
        }
        rx1.a.a(this.f392217a.f392240h, "em_qqrobot_more_btn");
        rx1.a.a(this.f392217a.f392254v, "em_qqrobot_robot_common_channel");
        y.f(this.f392217a.f392233a.findViewById(R.id.ypm), "em_qqrobot_channel_jump", this.f392225i);
        y.c(this.f392217a.f392243k, "em_qqrobot_robot_order_more", this.f392225i, this.f392229m);
        y.c(this.f392217a.f392245m, "em_qqrobot_function_more", this.f392225i, this.f392230n);
        y.e(this.f392217a.f392238f, "em_sgrp_block_remove_channel", this.f392225i, new HashMap());
        rx1.a.a(this.f392217a.f392238f, "em_sgrp_block_remove_channel");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R() {
        GProGuildRobotData gProGuildRobotData;
        String str;
        final String str2;
        String str3;
        GProRobotGuildInfo officialGuild;
        String valueOf;
        LinearLayout linearLayout = (LinearLayout) this.f392217a.f392233a.findViewById(R.id.ypm);
        TextView textView = (TextView) this.f392217a.f392233a.findViewById(R.id.f109706gj);
        TextView textView2 = (TextView) this.f392217a.f392233a.findViewById(R.id.f109696gi);
        GProGuildRobotInfoRsp gProGuildRobotInfoRsp = this.f392220d;
        final String str4 = null;
        if (gProGuildRobotInfoRsp != null) {
            gProGuildRobotData = gProGuildRobotInfoRsp.getRobotData();
        } else {
            gProGuildRobotData = null;
        }
        if (textView != null && textView2 != null && linearLayout != null && gProGuildRobotData != null && this.f392220d.getRobotData().getOfficialGuild() != null) {
            try {
                officialGuild = gProGuildRobotData.getOfficialGuild();
                valueOf = String.valueOf(officialGuild.getGuildId());
                str = StringsKt__StringsJVMKt.decodeToString(officialGuild.getGuildName());
                try {
                    str2 = StringsKt__StringsJVMKt.decodeToString(officialGuild.getJoinGuildSig());
                } catch (NumberFormatException | UnsupportedOperationException e16) {
                    e = e16;
                    str2 = null;
                }
            } catch (NumberFormatException | UnsupportedOperationException e17) {
                e = e17;
                str = null;
                str2 = null;
            }
            try {
                str3 = officialGuild.getPrefixText();
                str4 = valueOf;
            } catch (NumberFormatException e18) {
                e = e18;
                QLog.e("RobotInfoUI", 1, "initGuildLink| exception= " + e.getMessage());
                str3 = null;
                if (!TextUtils.isEmpty(str4)) {
                    return;
                } else {
                    return;
                }
            } catch (UnsupportedOperationException e19) {
                e = e19;
                QLog.e("RobotInfoUI", 1, "initGuildLink| exception= " + e.getMessage());
                str3 = null;
                if (!TextUtils.isEmpty(str4)) {
                }
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                linearLayout.setVisibility(0);
                textView.setText(str3);
                textView2.setText("#" + str);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: cx1.af
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ba.this.n0(str4, str2, view);
                    }
                });
            }
        }
    }

    private void S() {
        if (this.f392220d != null && this.f392217a.f392248p != null) {
            this.f392217a.f392247o.setBackgroundResource(0);
            ArrayList<String> tags = this.f392220d.getRobotData().getTags();
            if (!tags.isEmpty()) {
                this.f392217a.f392248p.setVisibility(0);
                this.f392217a.f392248p.setText(tags.get(0));
                this.f392217a.f392248p.setBackgroundResource(R.drawable.guild_robot_global_flag);
            } else if (this.f392220d.getRobotTestStatus() == 1) {
                this.f392217a.f392248p.setVisibility(0);
                this.f392217a.f392248p.setText(R.string.f153871d_);
                this.f392217a.f392248p.setBackgroundResource(R.drawable.guild_robot_develop_flag);
            } else {
                if (this.f392220d.getRobotTestStatus() == 2) {
                    this.f392217a.f392248p.setVisibility(0);
                    this.f392217a.f392248p.setText(R.string.f153881da);
                    this.f392217a.f392248p.setBackgroundResource(R.drawable.guild_robot_review_flag);
                    return;
                }
                this.f392217a.f392248p.setVisibility(8);
            }
        }
    }

    private void T() {
        final Context applicationContext = this.f392218b.b().getApplicationContext();
        this.f392217a.f392242j.setLayoutManager(new LinearLayoutManager(applicationContext, 1, false));
        this.f392217a.E.setVisibility(8);
        this.f392227k = new dx1.f();
        this.f392217a.f392242j.setAdapter(this.f392227k);
        this.f392217a.f392243k.setOnClickListener(new View.OnClickListener() { // from class: cx1.aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ba.this.o0(applicationContext, view);
            }
        });
    }

    private void U(View view) {
        b bVar = new b();
        this.f392217a = bVar;
        bVar.f392233a = view;
        this.f392217a.f392234b = (TextView) view.findViewById(R.id.f110846jm);
        this.f392217a.f392235c = (TextView) view.findViewById(R.id.f110826jk);
        this.f392217a.f392236d = (QUIButton) view.findViewById(R.id.f108136ca);
        this.f392217a.f392237e = (TextView) view.findViewById(R.id.f110676j6);
        this.f392217a.f392238f = (TextView) view.findViewById(R.id.f10586676);
        this.f392217a.f392239g = (TextView) view.findViewById(R.id.f10587677);
        this.f392217a.f392240h = (ImageView) view.findViewById(R.id.dwf);
        this.f392217a.f392241i = (ImageView) view.findViewById(R.id.y8h);
        this.f392217a.f392242j = (RecyclerView) view.findViewById(R.id.f83434jj);
        this.f392217a.f392243k = (LinearLayout) view.findViewById(R.id.ypd);
        this.f392217a.f392244l = (RecyclerView) view.findViewById(R.id.u1c);
        this.f392217a.f392245m = (LinearLayout) view.findViewById(R.id.ypa);
        this.f392217a.f392250r = view.findViewById(R.id.b_7);
        this.f392217a.f392249q = view.findViewById(R.id.efs);
        this.f392217a.f392248p = (TextView) view.findViewById(R.id.f767342g);
        this.f392217a.f392247o = (FrameLayout) view.findViewById(R.id.f165228v90);
        this.f392217a.f392253u = (QUIButton) view.findViewById(R.id.f765341x);
        this.f392217a.f392252t = (QUIButton) view.findViewById(R.id.sdp);
        this.f392217a.f392251s = (LinearLayout) view.findViewById(R.id.a0h);
        this.f392217a.f392254v = (LinearLayout) view.findViewById(R.id.f764541p);
        this.f392217a.f392255w = (TextView) view.findViewById(R.id.u2i);
        this.f392217a.f392256x = (LinearLayout) view.findViewById(R.id.f165312vh4);
        this.f392217a.f392257y = (RecyclerView) view.findViewById(R.id.f165311vh3);
        this.f392217a.f392258z = (ImageView) view.findViewById(R.id.f165970y94);
        this.f392217a.f392250r.setVisibility(8);
        this.f392217a.D = (TextView) view.findViewById(R.id.f7696433);
        this.f392217a.A = (RelativeLayout) view.findViewById(R.id.f7697434);
        this.f392217a.B = (ImageView) view.findViewById(R.id.f165967y92);
        this.f392217a.C = (TextView) view.findViewById(R.id.f165968y93);
        this.f392217a.E = (TextView) view.findViewById(R.id.f111216km);
        this.f392217a.F = (TextView) view.findViewById(R.id.f106936_2);
        this.f392217a.G = (LinearLayout) view.findViewById(R.id.f106926_1);
        this.f392217a.H = (LinearLayout) view.findViewById(R.id.f111206kl);
        this.f392217a.f392246n = (TipsBar) view.findViewById(R.id.f97835lg);
        this.f392217a.f392246n.z(true);
        this.f392217a.f392246n.setCloseListener(new View.OnClickListener() { // from class: cx1.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.p0(view2);
            }
        });
        this.f392217a.f392240h.setOnClickListener(new View.OnClickListener() { // from class: cx1.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.q0(view2);
            }
        });
        this.f392217a.f392236d.setOnClickListener(new View.OnClickListener() { // from class: cx1.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.r0(view2);
            }
        });
        this.f392217a.f392254v.setOnClickListener(new View.OnClickListener() { // from class: cx1.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.s0(view2);
            }
        });
        this.f392217a.f392258z.setOnClickListener(new View.OnClickListener() { // from class: cx1.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.t0(view2);
            }
        });
        this.f392217a.A.setOnClickListener(new View.OnClickListener() { // from class: cx1.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ba.this.u0(view2);
            }
        });
        rx1.a.a(this.f392217a.A, "em_qqrpbot_push_settings");
        rx1.a.a(this.f392217a.f392258z, "em_qqrobot_stream_star_share");
        if (this.f392218b.q()) {
            this.f392217a.A.setVisibility(8);
            this.f392217a.D.setVisibility(8);
        } else {
            this.f392217a.A.setVisibility(0);
            this.f392217a.D.setVisibility(0);
        }
        T();
        P();
        N();
        A0();
        y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        sx1.f.a();
        this.f392224h.o(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (i3 != 0) {
            this.f392224h.i();
        } else {
            this.f392224h.r();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f392218b.o() && this.f392224h.h()) {
            oidb_0x106a$RobotInfo oidb_0x106a_robotinfo = new oidb_0x106a$RobotInfo();
            oidb_0x106a_robotinfo.robot_uin.set(this.f392222f.getRobotUin());
            oidb_0x106a_robotinfo.robot_tid.set(this.f392222f.getRobotTid());
            if (this.f392218b.l(this.f392222f)) {
                this.f392224h.k();
            } else {
                this.f392224h.a();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        sx1.f.a();
        this.f392224h.o(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        sx1.f.a();
        this.f392224h.o(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.m();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (i3 != 0) {
            this.f392224h.i();
        } else {
            this.f392224h.r();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.o(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (i3 != 0) {
            this.f392224h.i();
        } else {
            this.f392224h.r();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.m();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.o(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Context context, View view) {
        String string;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            this.f392230n = !this.f392230n;
            v0(this.f392220d.getCommands());
            if (this.f392230n) {
                string = context.getString(R.string.f154101dw);
            } else {
                string = context.getString(R.string.f154301ef);
            }
            ((TextView) this.f392217a.f392245m.findViewById(R.id.zeh)).setText(string);
            if (this.f392230n) {
                i3 = 0;
            } else {
                i3 = 180;
            }
            ((ImageView) this.f392217a.f392245m.findViewById(R.id.zef)).setRotation(i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, String str2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392218b.a();
        GuildJumpUtil.j(this.f392218b.b().getApplicationContext(), str, "", str2, "bot_profile", "developers_official");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(Context context, View view) {
        String string;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            this.f392229m = !this.f392229m;
            x0(this.f392220d.getPanelDataList());
            if (this.f392229m) {
                string = context.getString(R.string.f154121dy);
            } else {
                string = context.getString(R.string.f154301ef);
            }
            ((TextView) this.f392217a.f392243k.findViewById(R.id.f166321zf2)).setText(string);
            if (this.f392229m) {
                i3 = 0;
            } else {
                i3 = 180;
            }
            ((ImageView) this.f392217a.f392243k.findViewById(R.id.f166319zf0)).setRotation(i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            this.f392224h.b(this.f392217a.f392245m);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f392224h.c();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void v0(List<GProGuildRobotFeatureInfo> list) {
        int i3;
        if (list.isEmpty()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        this.f392217a.f392244l.setVisibility(i3);
        this.f392217a.f392250r.findViewById(R.id.f106956_4).setVisibility(i3);
        this.f392217a.G.setVisibility(i3);
        if (!list.isEmpty() && !this.f392224h.h()) {
            this.f392217a.F.setVisibility(0);
        } else {
            this.f392217a.F.setVisibility(8);
        }
        if (list.size() > 4) {
            this.f392217a.f392245m.setVisibility(0);
        }
        this.f392228l.k0(list, this.f392224h, this.f392230n);
    }

    private void x0(List<GProGuildRobotPanelList> list) {
        int i3;
        if (list.isEmpty()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        this.f392217a.f392250r.findViewById(R.id.f111236ko).setVisibility(i3);
        this.f392217a.f392242j.setVisibility(i3);
        this.f392217a.H.setVisibility(i3);
        if (!list.isEmpty() && !this.f392224h.h()) {
            this.f392217a.E.setVisibility(0);
        } else {
            this.f392217a.E.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<GProGuildRobotPanelList> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getItems());
        }
        if (arrayList.size() > 3) {
            this.f392217a.f392243k.setVisibility(0);
        }
        this.f392227k.k0(arrayList, this.f392224h, this.f392229m);
    }

    private void y0() {
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
            this.f392217a.f392241i.setForeground(null);
        } else {
            this.f392217a.f392241i.setForeground(this.f392219c.get().getDrawable(R.drawable.guild_skin_robot_avatar_mask_bg));
        }
    }

    private void z0(boolean z16) {
        if (z16) {
            this.f392217a.f392238f.setVisibility(0);
            this.f392217a.f392239g.setVisibility(0);
        } else {
            this.f392217a.f392238f.setVisibility(8);
            this.f392217a.f392239g.setVisibility(8);
        }
    }

    public void D0(GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        if (this.f392217a.f392255w != null) {
            this.f392223g = gProRobotCommonGuildRsp.getTotal();
            this.f392217a.f392255w.setText(gProRobotCommonGuildRsp.getTotal() + "");
            LinearCircleCommonGuildLayout linearCircleCommonGuildLayout = (LinearCircleCommonGuildLayout) this.f392217a.f392254v.findViewById(R.id.f767742k);
            if (this.f392223g <= 0) {
                linearCircleCommonGuildLayout.setVisibility(8);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            linearCircleCommonGuildLayout.setVisibility(0);
            linearCircleCommonGuildLayout.c(peekAppRuntime, gProRobotCommonGuildRsp.getGuilds(), 5);
        }
    }

    public void N() {
        this.f392217a.f392246n.setVisibility(8);
    }

    @Override // cx1.d
    public HashMap<String, Object> a() {
        return this.f392225i;
    }

    @Override // cx1.d
    public void b() {
        if (this.f392217a.f392233a != null) {
            this.f392217a.f392233a.setVisibility(0);
        }
    }

    @Override // cx1.d
    public void c() {
        if (this.f392217a.f392233a != null) {
            this.f392217a.f392233a.setVisibility(8);
        }
    }

    @Override // cx1.d
    public void d(int i3, Object obj) {
        if (i3 > 0) {
            if (i3 == 1) {
                B0(((Integer) obj).intValue());
                return;
            } else {
                if (i3 == 2) {
                    N();
                    return;
                }
                return;
            }
        }
        if (obj instanceof GProGuildRobotInfoRsp) {
            GProGuildRobotInfoRsp gProGuildRobotInfoRsp = (GProGuildRobotInfoRsp) obj;
            F0(gProGuildRobotInfoRsp);
            w0(gProGuildRobotInfoRsp.getRobotData(), this.f392220d.getRole());
            G0(gProGuildRobotInfoRsp);
            return;
        }
        if (obj instanceof GProRobotCommonGuildRsp) {
            D0((GProRobotCommonGuildRsp) obj);
        } else {
            this.f392218b.a();
        }
    }

    @Override // cx1.c
    public void onCreateView() {
        this.f392224h = this.f392218b.h();
    }

    @Override // cx1.c
    public void onDestroy() {
        this.f392231o = null;
    }

    @Override // cx1.c
    public void onResume() {
        a aVar = new a(new WeakReference(this));
        this.f392231o = aVar;
        GuildThemeManager.g(aVar);
        ((ViewGroup) this.f392217a.f392233a.getParent()).setBackgroundColor(0);
        ViewGroup.LayoutParams layoutParams = this.f392217a.f392249q.getLayoutParams();
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(this.f392218b.b().getApplicationContext());
        if (layoutParams == null) {
            this.f392217a.f392249q.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (instantScreenHeight * 0.6d)));
        } else {
            layoutParams.height = (int) (instantScreenHeight * 0.6d);
        }
    }

    @Override // cx1.c
    public void onStop() {
        a aVar = this.f392231o;
        if (aVar != null) {
            GuildThemeManager.j(aVar);
        }
    }

    @Override // cx1.c
    public /* synthetic */ void p() {
        cx1.b.a(this);
    }

    public void w0(GProGuildRobotData gProGuildRobotData, int i3) {
        this.f392222f = gProGuildRobotData;
        this.f392221e.u(gProGuildRobotData.getRobotUin());
        if (this.f392221e.k() == 0) {
            this.f392221e.t(gProGuildRobotData.getRobotTid());
        }
        ArrayList<GProRobotImageInfo> previewImages = gProGuildRobotData.getPreviewImages();
        if (previewImages.size() == 0) {
            this.f392217a.f392256x.setVisibility(8);
        } else {
            this.f392217a.f392256x.setVisibility(0);
            Context applicationContext = this.f392218b.b().getApplicationContext();
            this.f392226j = new dx1.e(previewImages, applicationContext);
            this.f392217a.f392257y.setAdapter(this.f392226j);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(applicationContext);
            linearLayoutManager.setOrientation(0);
            this.f392217a.f392257y.setNestedScrollingEnabled(false);
            this.f392217a.f392257y.setLayoutManager(linearLayoutManager);
        }
        this.f392221e.s(gProGuildRobotData.getRobotName());
        this.f392221e.q(gProGuildRobotData.getRobotAvatar());
        this.f392221e.r(gProGuildRobotData.getRobotDesc());
        this.f392221e.m(gProGuildRobotData.getAppid());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            this.f392217a.f392241i.setImageDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getFaceDrawableByUser((AppInterface) peekAppRuntime, String.valueOf(gProGuildRobotData.getRobotUin())));
        } else {
            QLog.e("RobotInfoUI", 2, "\u8bbe\u7f6e\u673a\u5668\u4eba\u5934\u50cf\u5931\u8d25");
        }
        this.f392217a.f392234b.setText(gProGuildRobotData.getRobotName());
        this.f392217a.f392235c.setText(gProGuildRobotData.getRobotDesc());
        boolean z16 = true;
        if (gProGuildRobotData.getStatus() != 1) {
            z16 = false;
        }
        boolean i16 = sx1.f.i(i3, gProGuildRobotData.getRobotRole());
        if (this.f392218b.o()) {
            I(z16, i16, gProGuildRobotData, i3);
        } else if (this.f392218b.q()) {
            J();
        } else {
            M(z16, i16, gProGuildRobotData, i3);
        }
        if (i3 != 0) {
            this.f392217a.B.setVisibility(0);
            this.f392217a.C.setVisibility(8);
        } else {
            this.f392217a.B.setVisibility(8);
            this.f392217a.C.setVisibility(0);
        }
    }

    @Override // cx1.c
    public void onPause() {
    }
}
