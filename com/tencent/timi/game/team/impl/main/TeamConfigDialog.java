package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.TGDialogHelpCloseEvent;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectView;
import com.tencent.timi.game.team.impl.setting.ui.TeamConfigContainerView;
import com.tencent.timi.game.team.impl.setting.ui.VerticalNestedScrollView;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.k;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.u;
import fm4.TeamCreatePageParam;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;
import um4.h;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamConfigDialog extends BaseSlideUpDialog implements View.OnClickListener, k {
    private View T;
    private TextView U;
    private ImageView V;
    private TimiGamePageLoadingView W;
    private TextView X;
    private VerticalNestedScrollView Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private d f379535a0;

    /* renamed from: b0, reason: collision with root package name */
    private c f379536b0;

    /* renamed from: c0, reason: collision with root package name */
    private TeamConfigContainerView f379537c0;

    /* renamed from: d0, reason: collision with root package name */
    private StateListDrawable f379538d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f379539e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends com.tencent.timi.game.ui.e {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            TeamConfigDialog.this.I0(charSequence.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements GiftSelectView.c {
        b() {
        }

        @Override // com.tencent.timi.game.team.impl.giftteam.GiftSelectView.c
        public void a() {
            TeamConfigDialog.this.Y.fullScroll(130);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void a(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams);

        void b(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams);
    }

    TeamConfigDialog(Context context, int i3, d dVar, c cVar) {
        super(context);
        this.f379539e0 = -1;
        r0(i3, dVar, cVar);
    }

    private void A0() {
        EditText editText = (EditText) findViewById(R.id.f928258x);
        if (editText != null) {
            editText.addTextChangedListener(new a());
            I0(editText.getText().toString());
        }
    }

    private void B0() {
        this.V.setOnClickListener(this);
        this.U.setOnClickListener(this);
    }

    private void C0() {
        boolean D;
        String str;
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        HashMap<String, String> hashMap;
        if (this.Z == 0) {
            if (this.f379535a0.f379556a == 2) {
                D = true;
            } else {
                D = false;
            }
        } else {
            D = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379535a0.f379561f).D();
        }
        if (this.Z == 0) {
            if (D) {
                str = "pg_sgrp_smoba_cpdd";
            } else {
                str = "pg_kl_smoba_cpdd";
            }
        } else {
            str = "pg_yes_smoba_team";
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("yes_game_id", String.valueOf(this.f379535a0.f379563h));
        hashMap2.put("yes_user_from", String.valueOf(this.f379535a0.f379556a));
        ((ug4.b) mm4.b.b(ug4.b.class)).b(this, str, hashMap2);
        int i3 = this.Z;
        if (i3 == 0) {
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                hashMap = I0.getMReporterHelper().E();
            } else {
                hashMap = new HashMap<>();
            }
            HashMap<String, String> hashMap3 = hashMap;
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this.U, true, "\u521b\u5efa\u8f66\u961f\u6d6e\u5c42\u7acb\u5373\u521b\u5efa\u6309\u94ae", "em_yes_createteam_panel_submit", hashMap3);
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this.V, true, "\u521b\u5efa\u8f66\u961f\u6d6e\u5c42\u5173\u95ed\u6309\u94ae", "em_yes_createteam_panel_close", hashMap3);
            return;
        }
        if (i3 != 1 || this.f379535a0.f379561f == 0 || (roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379535a0.f379561f).getRoomInfo()) == null) {
            return;
        }
        ((ug4.b) mm4.b.b(ug4.b.class)).a(this.U, true, "\u8bbe\u7f6e\u6d6e\u5c42\u4fdd\u5b58\u4fee\u6539\u6309\u94ae", "em_yes_config_panel_confirm", YoloRoomUtil.L(roomInfo));
        ((ug4.b) mm4.b.b(ug4.b.class)).a(this.V, true, "\u8bbe\u7f6e\u6d6e\u5c42\u5173\u95ed\u6309\u94ae", "em_yes_config_panel_close", YoloRoomUtil.L(roomInfo));
    }

    private void D0() {
        x0();
        s0();
        E0();
        w0();
        u0();
    }

    private void E0() {
        String str = this.f379535a0.f379564i.team_info.text_hue.get();
        if (yn4.a.a(str)) {
            this.X.setTextColor(Color.parseColor(str));
        }
    }

    public static TeamConfigDialog F0(Context context, d dVar, c cVar) {
        return new TeamConfigDialog(context, 0, dVar, cVar);
    }

    public static TeamConfigDialog H0(Context context, d dVar, c cVar) {
        return new TeamConfigDialog(context, 1, dVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(String str) {
        if (str.length() > 0) {
            int i3 = this.Z;
            if (i3 == 0) {
                J0(R.string.f2310770v);
                return;
            } else {
                if (i3 == 1) {
                    J0(R.string.f2314571w);
                    return;
                }
                return;
            }
        }
        int i16 = this.Z;
        if (i16 == 0) {
            K0(R.string.f2310770v);
        } else if (i16 == 1) {
            K0(R.string.f2314571w);
        }
    }

    private void J0(int i3) {
        this.U.setText(i3);
        this.U.setBackgroundDrawable(this.f379538d0);
        this.U.setTextColor(this.f379539e0);
        this.U.setEnabled(true);
    }

    private void K0(int i3) {
        this.U.setText(i3);
        this.U.setBackgroundResource(R.drawable.lt7);
        this.U.setTextColor(-8750470);
        this.U.setEnabled(false);
    }

    private void initView() {
        l0();
        y0();
        f0();
    }

    private void l0() {
        this.W = (TimiGamePageLoadingView) findViewById(R.id.f93525_t);
        this.T = findViewById(R.id.f93515_s);
        this.U = (TextView) findViewById(R.id.f93505_r);
        this.V = (ImageView) findViewById(R.id.f93475_o);
        this.f379537c0 = (TeamConfigContainerView) findViewById(R.id.f927658r);
        this.X = (TextView) findViewById(R.id.f93535_u);
        VerticalNestedScrollView verticalNestedScrollView = (VerticalNestedScrollView) findViewById(R.id.u7x);
        this.Y = verticalNestedScrollView;
        verticalNestedScrollView.setOverScrollMode(2);
    }

    private YoloRoomOuterClass$YoloGameRoomParams m0() {
        return this.f379537c0.d();
    }

    private YoloRoomOuterClass$YoloRoomParams n0() {
        return this.f379537c0.f();
    }

    private void o0() {
        c cVar;
        YoloRoomOuterClass$YoloGameRoomParams m06 = m0();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            HashMap<String, String> E = I0.getMReporterHelper().E();
            YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = m06.gift_config.get();
            if (yoloRoomOuterClass$YoloGiftConfig.has()) {
                E.put("yes_team_type", "1");
                E.put("yes_gift_id", yoloRoomOuterClass$YoloGiftConfig.gift_id.get() + "");
                E.put("yes_gift_nums", yoloRoomOuterClass$YoloGiftConfig.gift_num.get() + "");
                E.put("yes_gift_price", yoloRoomOuterClass$YoloGiftConfig.gift_price.get() + "");
                h.f439233a = yoloRoomOuterClass$YoloGiftConfig.gift_id.get();
                h.f439234b = yoloRoomOuterClass$YoloGiftConfig.gift_num.get();
                h.f439235c = yoloRoomOuterClass$YoloGiftConfig.gift_price.get();
            } else {
                l.e("Team_Config", "handleCreateClick giftConfig is empty");
                E.put("yes_team_type", "0");
                E.put("yes_gift_id", "");
                E.put("yes_gift_nums", "");
                E.put("yes_gift_price", "");
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this.U, true, "\u521b\u5efa\u8f66\u961f\u6d6e\u5c42\u7acb\u5373\u521b\u5efa\u6309\u94ae", "em_yes_createteam_panel_submit", E);
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this.V, true, "\u521b\u5efa\u8f66\u961f\u6d6e\u5c42\u5173\u95ed\u6309\u94ae", "em_yes_createteam_panel_close", E);
        }
        if (!o.a() && (cVar = this.f379536b0) != null) {
            cVar.a(this, n0(), m06);
        }
    }

    private void p0() {
        GiftSelectView giftSelectView = (GiftSelectView) findViewById(R.id.f928058v);
        if (giftSelectView != null) {
            giftSelectView.setListener(new b());
        }
    }

    private void q0() {
        if (!o.a() && this.f379536b0 != null) {
            this.f379536b0.b(this, n0(), m0());
        }
    }

    private void r0(int i3, d dVar, c cVar) {
        this.Z = i3;
        this.f379535a0 = dVar;
        this.f379536b0 = cVar;
    }

    private void s0() {
        String str = this.f379535a0.f379564i.team_info.bg_hue.get();
        if (yn4.a.a(str)) {
            this.T.getBackground().setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_ATOP));
        }
    }

    private void u0() {
        String str = this.f379535a0.f379564i.team_info.main_hue.get();
        String str2 = this.f379535a0.f379564i.team_info.button_text_hue.get();
        if (yn4.a.a(str)) {
            this.f379538d0 = new StateListDrawable();
            Drawable drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.MULTIPLY));
                this.f379538d0.addState(new int[]{android.R.attr.state_pressed}, drawable);
            }
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC);
            Drawable drawable2 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.lt7, null);
            if (drawable2 != null) {
                drawable2.setColorFilter(porterDuffColorFilter);
                this.f379538d0.addState(new int[0], drawable2);
            }
        }
        if (yn4.a.a(str2)) {
            this.f379539e0 = Color.parseColor(str2);
        }
    }

    private void w0() {
        String str = this.f379535a0.f379564i.team_info.text_hue.get();
        if (yn4.a.a(str)) {
            this.V.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_ATOP));
        }
    }

    private void x0() {
        List<YesGameInfoOuterClass$GameConfigItem> list = this.f379535a0.f379564i.team_info.item_list.get();
        if (list.isEmpty()) {
            return;
        }
        this.f379537c0.i(this.f379535a0, this.Z);
        this.f379537c0.b(list);
    }

    private void y0() {
        this.f379537c0.setOverScrollMode(2);
        e0(this.T);
        this.T.setOnClickListener(this);
    }

    private void z0() {
        D0();
        A0();
        p0();
    }

    public void L0(int i3) {
        this.W.setHintText(getContext().getString(R.string.f23156727));
        this.W.d();
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        TeamCreatePageParam teamCreatePageParam;
        d dVar = this.f379535a0;
        if (dVar != null && (teamCreatePageParam = dVar.f379569n) != null && teamCreatePageParam.getBaseOnTempActivity()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.timi.game.team.impl.main.TeamConfigDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    TGDialogHelperFragment.INSTANCE.b();
                }
            }, 500L);
        }
        this.f379537c0.c();
        super.dismiss();
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.W;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f93475_o) {
            dismiss();
        } else if (view.getId() == R.id.f93505_r) {
            int i3 = this.Z;
            if (i3 == 0) {
                o0();
            } else if (i3 == 1) {
                q0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(48);
        if (((ag4.h) mm4.b.b(ag4.h.class)).l1(this.f379535a0.f379563h).style_mode.get() == 0) {
            u.e(getWindow());
        } else {
            u.d(getWindow());
        }
        setContentView(R.layout.hwp);
        initView();
        B0();
        z0();
        C0();
    }

    @Override // com.tencent.timi.game.ui.widget.b, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
    }

    public void showLoadingView() {
        L0(R.string.f23156727);
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String str) {
    }
}
