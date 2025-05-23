package com.tencent.mobileqq.wink.editor.music.lyric;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicWaveView;
import com.tencent.mobileqq.wink.editor.music.lyric.i;
import com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends ReportDialog implements View.OnClickListener, i.b, WinkMusicWaveView.a {
    private final WinkEditorPanelDialogDelegate C;
    private final FrameLayout D;
    private MoreLyricLayout E;
    private final TextView F;
    private final TextView G;
    private final WinkMusicWaveView H;
    private final RelativeLayout I;
    private final TextView J;
    private final TextView K;
    private final View L;
    private final View M;
    private InterfaceC9031d N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements com.tencent.mobileqq.wink.editor.music.lyric.interaction.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.a
        public void a(int i3) {
            d.this.W(i3);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.a
        public void onLyricClick(int i3) {
            if (d.this.N != null) {
                d.this.N.onLyricClick(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b implements MoreLyricLayout.d {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout.d
        public void a(boolean z16) {
            int i3;
            RelativeLayout relativeLayout = d.this.I;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            relativeLayout.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c implements WinkEditorPanelDialogDelegate.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.a
        public void a() {
            d.super.show();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.a
        public void b() {
            d.super.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.music.lyric.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9031d {
        void onBlankClick();

        void onClickCancelBtn(boolean z16);

        void onClickConfirmBtn();

        void onIndicatorDragged(int i3);

        void onLyricClick(int i3);

        void onMusicWaveMoveEnd(boolean z16);

        void onMusicWaveMoveStart();

        void onMusicWaveMoving(int i3, int i16);

        void onResetMusicRangeToRecommend(int i3);

        void show(boolean z16);
    }

    public d(@NonNull Context context) {
        super(context, R.style.f243811t);
        this.E = null;
        this.T = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hd8, (ViewGroup) null);
        this.D = (FrameLayout) inflate.findViewById(R.id.v8q);
        this.E = (MoreLyricLayout) inflate.findViewById(R.id.f166296zc1);
        this.F = (TextView) inflate.findViewById(R.id.f111476lb);
        this.G = (TextView) inflate.findViewById(R.id.f107726b7);
        WinkMusicWaveView winkMusicWaveView = (WinkMusicWaveView) inflate.findViewById(R.id.f164058sf3);
        this.H = winkMusicWaveView;
        this.I = (RelativeLayout) inflate.findViewById(R.id.yvr);
        this.J = (TextView) inflate.findViewById(R.id.kbq);
        TextView textView = (TextView) inflate.findViewById(R.id.f110726ja);
        this.K = textView;
        this.M = this.E.findViewById(R.id.zjx);
        this.E.setOnMoreLyricLayoutActionListener(new a());
        this.E.setOnDragCallback(new b());
        winkMusicWaveView.setDragIndicatorListener(this);
        View findViewById = inflate.findViewById(R.id.y1t);
        this.L = findViewById;
        findViewById.setOnClickListener(this);
        VideoReport.setElementId(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CUT_FINISH);
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_ALL);
        inflate.findViewById(R.id.y17).setOnClickListener(this);
        inflate.findViewById(R.id.y5u).setOnClickListener(this);
        inflate.findViewById(R.id.y5v).setOnClickListener(this);
        textView.setOnClickListener(this);
        setContentView(inflate);
        this.C = new WinkEditorPanelDialogDelegate(this, inflate, new c());
    }

    private void S() {
        U(false);
    }

    private void U(boolean z16) {
        if (!X() && !z16) {
            this.J.setVisibility(8);
            this.K.setVisibility(0);
        } else {
            this.J.setVisibility(0);
            this.K.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i3) {
        int i16 = this.S + i3;
        b0(i3);
        MoreLyricLayout moreLyricLayout = this.E;
        if (moreLyricLayout != null) {
            moreLyricLayout.setLyricSeek(i3);
        }
        this.Q = i3;
        InterfaceC9031d interfaceC9031d = this.N;
        if (interfaceC9031d != null) {
            interfaceC9031d.onMusicWaveMoving(i3, i16);
            S();
            this.N.onMusicWaveMoveEnd(true);
        }
    }

    private boolean X() {
        if (this.Q == this.P) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.b
    public void C(int i3, int i16) {
        this.T = true;
        this.Q = i3;
        InterfaceC9031d interfaceC9031d = this.N;
        if (interfaceC9031d != null) {
            interfaceC9031d.onMusicWaveMoving(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.b
    public void G() {
        if (this.N != null) {
            S();
            this.N.onMusicWaveMoveEnd(this.T);
        }
        this.T = false;
    }

    public void Y(@Nullable InterfaceC9031d interfaceC9031d) {
        this.N = interfaceC9031d;
    }

    public void Z(int i3, int i16) {
        WinkMusicWaveView winkMusicWaveView = this.H;
        if (winkMusicWaveView != null && !winkMusicWaveView.h()) {
            this.H.setIndicatorIndexByVideo(i3, i16);
            this.H.setCurrentPosition(i3, i16);
        }
        MoreLyricLayout moreLyricLayout = this.E;
        if (moreLyricLayout != null) {
            moreLyricLayout.r((int) e.a().c(false));
        }
    }

    public void a0(int i3, int i16) {
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.wink.editor.music.a.b(com.tencent.mobileqq.wink.editor.music.a.f320709a, i3));
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setText(com.tencent.mobileqq.wink.editor.music.a.b(com.tencent.mobileqq.wink.editor.music.a.f320709a, Math.min(i16, this.R)));
        }
    }

    public void b0(int i3) {
        WinkMusicWaveView winkMusicWaveView = this.H;
        if (winkMusicWaveView != null) {
            winkMusicWaveView.m(i3);
        }
    }

    public void c0(@NonNull WinkEditorMusicInfo winkEditorMusicInfo, int i3, int i16, int i17, int i18, boolean z16) {
        this.P = winkEditorMusicInfo.s();
        this.R = winkEditorMusicInfo.n();
        this.S = i16;
        this.Q = i3;
        e.a().d(i3, Math.min(i3 + i16, this.R));
        WinkMusicWaveView winkMusicWaveView = this.H;
        if (winkMusicWaveView != null) {
            winkMusicWaveView.g(winkEditorMusicInfo.p(), WinkEditorMusicHelper.o(winkEditorMusicInfo), winkEditorMusicInfo.n(), i16, false, i17, i18, true, z16);
            this.H.setOnMusicMoveListener(this);
            b0(i3);
        }
        MoreLyricLayout moreLyricLayout = this.E;
        if (moreLyricLayout != null) {
            moreLyricLayout.setVisibility(0);
            this.E.k(winkEditorMusicInfo, i3, true, false);
        }
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            frameLayout.setAlpha(1.0f);
        }
        S();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.C.d();
        this.N.show(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC9031d interfaceC9031d;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.y17 && id5 != R.id.y5u) {
            if (id5 != R.id.y1t && id5 != R.id.y5v) {
                if (id5 == R.id.f110726ja && !X() && (interfaceC9031d = this.N) != null) {
                    interfaceC9031d.onResetMusicRangeToRecommend(this.P);
                    U(true);
                }
            } else {
                InterfaceC9031d interfaceC9031d2 = this.N;
                if (interfaceC9031d2 != null) {
                    interfaceC9031d2.onClickConfirmBtn();
                }
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
                buildElementParams.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
                VideoReport.reportEvent("dt_clck", this.L, buildElementParams);
                dismiss();
            }
        } else {
            InterfaceC9031d interfaceC9031d3 = this.N;
            if (interfaceC9031d3 != null) {
                interfaceC9031d3.onClickCancelBtn(false);
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C.e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC9031d interfaceC9031d = this.N;
        if (interfaceC9031d != null) {
            interfaceC9031d.onClickCancelBtn(true);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicWaveView.a
    public void onIndicatorDragged(int i3) {
        InterfaceC9031d interfaceC9031d;
        WinkMusicWaveView winkMusicWaveView = this.H;
        if (winkMusicWaveView != null && (interfaceC9031d = this.N) != null) {
            interfaceC9031d.onIndicatorDragged(winkMusicWaveView.e(this.S));
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            try {
                float rawY = motionEvent.getRawY();
                this.M.getLocationInWindow(new int[2]);
                if (rawY < r2[1]) {
                    this.N.onBlankClick();
                }
            } catch (Exception e16) {
                w53.b.e("WinkLyricPanelDialog", e16);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.i.b
    public void s() {
        InterfaceC9031d interfaceC9031d = this.N;
        if (interfaceC9031d != null) {
            interfaceC9031d.onMusicWaveMoveStart();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.C.f();
        this.N.show(true);
    }
}
