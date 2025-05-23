package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.team.TeamLaneSelectView;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import java.util.concurrent.ConcurrentHashMap;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamLaneStateView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f379721d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f379722e;

    /* renamed from: f, reason: collision with root package name */
    private TimiGamePAGView f379723f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f379724h;

    /* renamed from: i, reason: collision with root package name */
    private int f379725i;

    /* renamed from: m, reason: collision with root package name */
    private CommonOuterClass$QQUserId f379726m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamLaneStateView.this.k();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements TeamLaneSelectView.b {
        b() {
        }

        @Override // com.tencent.timi.game.team.impl.team.TeamLaneSelectView.b
        public void a(View view, int i3) {
            TeamLaneStateView.this.f379725i = i3;
            TeamLaneStateView.this.f379722e.setText(ym4.a.e(i3, true));
            ym4.a.c(TeamLaneStateView.this.f379725i, TeamLaneStateView.this.f379726m);
            TeamLaneStateView teamLaneStateView = TeamLaneStateView.this;
            teamLaneStateView.t(view, teamLaneStateView.f379725i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements PopupWindow.OnDismissListener {
        c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            TeamLaneStateView.this.l();
        }
    }

    public TeamLaneStateView(Context context) {
        super(context);
        m();
    }

    private void i(int i3, int i16) {
        TimiGamePAGView timiGamePAGView = new TimiGamePAGView(getContext());
        this.f379723f = timiGamePAGView;
        timiGamePAGView.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
        this.f379723f.setVisibility(8);
        addView(this.f379723f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f379721d.setImageResource(R.drawable.f162575oa3);
        TeamLaneSelectView teamLaneSelectView = new TeamLaneSelectView(getContext());
        teamLaneSelectView.j(this.f379725i, this);
        teamLaneSelectView.setOnLaneSelectedListener(new b());
        teamLaneSelectView.setOnDismissListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f379721d.setImageResource(R.drawable.lti);
    }

    private void m() {
        o();
        r();
        p();
    }

    private void n() {
        ImageView imageView = new ImageView(getContext());
        this.f379721d = imageView;
        imageView.setId(R.id.f93415_i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ba.dp2px(getContext(), 7.0f), (int) ba.dp2px(getContext(), 4.0f));
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = (int) ba.dp2px(getContext(), 3.75f);
        layoutParams.addRule(15, -1);
        this.f379721d.setLayoutParams(layoutParams);
        this.f379721d.setImageResource(R.drawable.lti);
        addView(this.f379721d);
    }

    private void o() {
        setBackgroundResource(R.drawable.ltn);
        setGravity(1);
    }

    private void p() {
        setOnClickListener(new a());
    }

    private void q() {
        TextView textView = new TextView(getContext());
        this.f379722e = textView;
        textView.setTextColor(getResources().getColorStateList(R.color.cui));
        this.f379722e.setTextSize(9.0f);
        this.f379722e.setGravity(17);
        this.f379722e.setText(ym4.a.e(0, true));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(0, this.f379721d.getId());
        this.f379722e.setLayoutParams(layoutParams);
        addView(this.f379722e);
    }

    private void r() {
        n();
        q();
    }

    private PAGFile s() {
        PAGFile Load = PagViewMonitor.Load(eh4.a.b().getResources().getAssets(), "pag/tg_lane_slide.pag");
        if (Load == null) {
            return null;
        }
        Matrix totalMatrix = Load.getTotalMatrix();
        float dp2px = (ba.dp2px(getContext(), 54.0f) * 1.0f) / Load.width();
        totalMatrix.setScale(dp2px, dp2px);
        Load.setMatrix(totalMatrix);
        return Load;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view, int i3) {
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(1);
        if (j06 != null) {
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(j06);
            L.put("yes_user_branch", String.valueOf(i3));
            ((ug4.b) mm4.b.b(ug4.b.class)).c(view, true, "\u9009\u62e9\u5206\u8def\u5f39\u7a97\u9009\u62e9\u6309\u94ae", "em_yes_branch_win_choose", L);
        }
    }

    public void j() {
        setVisibility(8);
        setTag("");
    }

    public void setState(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        this.f379725i = i3;
        this.f379726m = commonOuterClass$QQUserId;
        boolean a16 = ll4.b.a(commonOuterClass$QQUserId, ((ll4.a) mm4.b.b(ll4.a.class)).E());
        this.f379724h = a16;
        if (a16) {
            this.f379721d.setVisibility(0);
            setEnabled(true);
            this.f379722e.setEnabled(true);
            setTag("TeamLaneStateView");
        } else {
            this.f379721d.setVisibility(8);
            setEnabled(false);
            this.f379722e.setEnabled(false);
            setTag("");
        }
        this.f379722e.setText(ym4.a.e(i3, this.f379724h));
        setVisibility(0);
    }

    public void setStateWithAnim(final String str) {
        PAGFile s16;
        if (!((hi4.b) mm4.b.b(hi4.b.class)).t()) {
            return;
        }
        int dp2px = (int) ba.dp2px(getContext(), 54.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 15.0f);
        i(dp2px, dp2px2);
        PAGComposition Make = PAGComposition.Make(dp2px, dp2px2);
        if (Make == null || (s16 = s()) == null) {
            return;
        }
        Make.addLayer(s16);
        this.f379723f.setComposition(Make);
        this.f379723f.setRepeatCount(1);
        this.f379723f.b(new PAGView.PAGViewListener() { // from class: com.tencent.timi.game.team.impl.team.TeamLaneStateView.4
            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationCancel(PAGView pAGView) {
                TeamLaneStateView.this.f379723f.setVisibility(8);
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationEnd(PAGView pAGView) {
                TeamLaneStateView.this.f379723f.setVisibility(8);
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationStart(PAGView pAGView) {
                TeamLaneStateView.this.f379723f.setVisibility(0);
                TeamLaneStateView.this.f379722e.postDelayed(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.TeamLaneStateView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TeamLaneStateView.this.f379722e.setText(str);
                    }
                }, 300L);
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationRepeat(PAGView pAGView) {
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationUpdate(PAGView pAGView) {
            }
        });
        this.f379723f.g();
    }

    public TeamLaneStateView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m();
    }

    public TeamLaneStateView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m();
    }
}
