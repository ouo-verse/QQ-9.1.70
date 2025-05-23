package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewSingleLine;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.b;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MoreLyricLayout extends LinearLayout implements WinkSlidingUpPanelLayout.d, LyricWithBuoyView.d {
    private long C;
    private boolean D;
    private com.tencent.mobileqq.wink.editor.music.lyric.interaction.a E;
    private LinearLayout F;
    private RelativeLayout G;
    private d H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f320912d;

    /* renamed from: e, reason: collision with root package name */
    private LyricViewSingleLine f320913e;

    /* renamed from: f, reason: collision with root package name */
    private LyricViewController f320914f;

    /* renamed from: h, reason: collision with root package name */
    private c f320915h;

    /* renamed from: i, reason: collision with root package name */
    private LyricWithBuoyView f320916i;

    /* renamed from: m, reason: collision with root package name */
    private WinkSlidingUpPanelLayout f320917m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MoreLyricLayout.this.f320917m.setPanelState(WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements b.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.b.a
        public void a(long j3) {
            ms.a.a("MoreLyricLayout", "onScroll() position => " + j3);
            MoreLyricLayout.this.n();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.b.a
        public void b(long j3, long j16) {
            TextView textView;
            MoreLyricLayout.this.C = j3;
            String h16 = LyricWithBuoyView.h((int) j3);
            if (MoreLyricLayout.this.f320916i != null) {
                textView = MoreLyricLayout.this.f320916i.b();
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(h16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface d {
        void a(boolean z16);
    }

    public MoreLyricLayout(Context context) {
        super(context);
        this.f320912d = null;
        this.f320913e = null;
        this.f320914f = null;
        this.f320915h = new c();
        this.f320916i = null;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = 0;
        l();
    }

    private void h(boolean z16) {
        int i3;
        int i16;
        int i17;
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout == null) {
            ms.a.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
        } else {
            int i18 = 8;
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            relativeLayout.setVisibility(i3);
            LyricWithBuoyView lyricWithBuoyView = this.f320916i;
            if (z16) {
                i16 = 4;
            } else {
                i16 = 0;
            }
            lyricWithBuoyView.setVisibility(i16);
            LyricViewSingleLine lyricViewSingleLine = this.f320913e;
            if (z16) {
                i18 = 0;
            }
            lyricViewSingleLine.setVisibility(i18);
            ImageView imageView = this.f320912d;
            if (z16) {
                i17 = R.drawable.onv;
            } else {
                i17 = R.drawable.onu;
            }
            imageView.setImageResource(i17);
        }
        d dVar = this.H;
        if (dVar != null) {
            dVar.a(z16);
        }
    }

    private void j() {
        LyricWithBuoyView lyricWithBuoyView = this.f320916i;
        if (lyricWithBuoyView == null) {
            ms.a.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
        } else {
            lyricWithBuoyView.c();
        }
    }

    private void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.hdo, (ViewGroup) this, true);
        this.f320912d = (ImageView) findViewById(R.id.zjx);
        this.f320913e = (LyricViewSingleLine) findViewById(R.id.zjz);
        this.f320914f = new LyricViewController(this.f320913e);
        LyricWithBuoyView lyricWithBuoyView = (LyricWithBuoyView) findViewById(R.id.zjy);
        this.f320916i = lyricWithBuoyView;
        if (lyricWithBuoyView != null) {
            lyricWithBuoyView.f(this.f320915h);
        }
        WinkSlidingUpPanelLayout winkSlidingUpPanelLayout = (WinkSlidingUpPanelLayout) findViewById(R.id.zex);
        this.f320917m = winkSlidingUpPanelLayout;
        winkSlidingUpPanelLayout.o(this);
        this.f320917m.setFadeOnClickListener(new a());
        this.F = (LinearLayout) findViewById(R.id.zjv);
        this.G = (RelativeLayout) findViewById(R.id.zew);
        VideoReport.setElementId(this.f320917m, WinkDaTongReportConstant.ElementId.EM_XSJ_SONG_PANEL);
        i(true);
    }

    private void o(int i3) {
        com.tencent.mobileqq.wink.editor.music.lyric.interaction.a aVar = this.E;
        if (aVar == null) {
            ms.a.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
        } else {
            aVar.a(i3);
        }
    }

    private void t() {
        WinkSlidingUpPanelLayout winkSlidingUpPanelLayout = this.f320917m;
        if (winkSlidingUpPanelLayout == null) {
            ms.a.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
        } else {
            winkSlidingUpPanelLayout.setPanelState(WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
        }
        j();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView.d
    public void a(int i3) {
        com.tencent.mobileqq.wink.editor.music.lyric.interaction.a aVar = this.E;
        if (aVar != null) {
            aVar.onLyricClick(i3);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout.d
    public void b(View view, WinkSlidingUpPanelLayout.PanelState panelState, WinkSlidingUpPanelLayout.PanelState panelState2) {
        ms.a.a("MoreLyricLayout", "onPanelStateChanged() newState => " + panelState2);
        if (panelState2 == WinkSlidingUpPanelLayout.PanelState.DRAGGING) {
            h(false);
            p();
            return;
        }
        if (panelState2 == WinkSlidingUpPanelLayout.PanelState.COLLAPSED) {
            h(true);
            j();
            q(false);
        } else {
            if (panelState2 == WinkSlidingUpPanelLayout.PanelState.ANCHORED) {
                t();
                return;
            }
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
            buildElementParams.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
            VideoReport.reportEvent("ev_xsj_camera_action", this.f320917m, buildElementParams);
            h(false);
            q(true);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView.d
    public void c() {
        o((int) this.C);
    }

    public void i(boolean z16) {
        int i3;
        ms.a.a("MoreLyricLayout", "hideLyricLayout() hide > " + z16);
        boolean z17 = false;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        setVisibility(i3);
        t();
        if (getVisibility() == 0) {
            z17 = true;
        }
        m(z17);
    }

    public void k(WinkEditorMusicInfo winkEditorMusicInfo, int i3, boolean z16, boolean z17) {
        d73.b bVar;
        if (winkEditorMusicInfo == null) {
            ms.a.i("MoreLyricLayout", "initLyricView() mData == null.");
            return;
        }
        t();
        String k3 = winkEditorMusicInfo.k();
        String l3 = winkEditorMusicInfo.l();
        this.D = false;
        if (TextUtils.isEmpty(k3) || TextUtils.isEmpty(k3.trim()) || k3.equals("[00:00:00]\u8be5\u97f3\u4e50\u6682\u65e0\u6b4c\u8bcd")) {
            l3 = LyricParseHelper.LYRIC_FROMAT_LRC;
            k3 = "[00:00:00]\u8be5\u97f3\u4e50\u6682\u65e0\u6b4c\u8bcd";
        }
        if (!TextUtils.isEmpty(k3) && !TextUtils.isEmpty(l3)) {
            LyricViewController lyricViewController = this.f320914f;
            if (lyricViewController != null) {
                lyricViewController.s();
            }
            if (TextUtils.equals(l3.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_LRC)) {
                bVar = com.tencent.mobileqq.wink.editor.music.lyric.a.b(k3, false);
                LyricViewController lyricViewController2 = this.f320914f;
                if (lyricViewController2 != null) {
                    lyricViewController2.p(null, bVar, null);
                }
            } else if (TextUtils.equals(l3.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_QRC)) {
                bVar = com.tencent.mobileqq.wink.editor.music.lyric.a.b(k3, true);
                LyricViewController lyricViewController3 = this.f320914f;
                if (lyricViewController3 != null) {
                    lyricViewController3.p(bVar, null, null);
                }
            } else {
                bVar = null;
            }
            if (bVar != null) {
                ms.a.a("MoreLyricLayout", "initLyricView() startTime => " + i3 + ",lyricFormat:" + l3);
                LyricViewController lyricViewController4 = this.f320914f;
                if (lyricViewController4 != null) {
                    lyricViewController4.o(false);
                    this.f320914f.n(i3, true);
                    this.f320914f.q(null);
                }
                this.D = true;
                i(!z16);
                LyricWithBuoyView lyricWithBuoyView = this.f320916i;
                if (lyricWithBuoyView != null) {
                    lyricWithBuoyView.d(k3, l3, i3, null);
                    this.f320916i.setOnLyricWithBuoyViewOperationListener(this);
                }
                if (z16) {
                    s();
                }
            } else {
                i(true);
            }
            if (this.D && bVar.l() > 1) {
                try {
                    if (cx.INSTANCE.f()) {
                        this.f320917m.setPanelState(WinkSlidingUpPanelLayout.PanelState.EXPANDED);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    w53.b.e("MoreLyricLayout", e16);
                    this.f320917m.setPanelState(WinkSlidingUpPanelLayout.PanelState.EXPANDED);
                    return;
                }
            }
            return;
        }
        ms.a.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
        i(true);
    }

    public void r(int i3) {
        if (this.I == i3) {
            return;
        }
        this.I = i3;
        LyricViewController lyricViewController = this.f320914f;
        if (lyricViewController != null) {
            lyricViewController.g(i3);
        }
        LyricWithBuoyView lyricWithBuoyView = this.f320916i;
        if (lyricWithBuoyView != null) {
            lyricWithBuoyView.e(i3);
        }
    }

    public void setLyricSeek(int i3) {
        if (!this.D) {
            ms.a.i("MoreLyricLayout", "setLyricSeek() current not lyric.");
            return;
        }
        LyricViewController lyricViewController = this.f320914f;
        if (lyricViewController == null) {
            ms.a.i("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
        } else {
            lyricViewController.n(i3, false);
        }
        LyricWithBuoyView lyricWithBuoyView = this.f320916i;
        if (lyricWithBuoyView == null) {
            ms.a.i("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
            return;
        }
        lyricWithBuoyView.setSelectedFlag(i3, false);
        TextView b16 = this.f320916i.b();
        if (b16 != null) {
            b16.setText(LyricWithBuoyView.h(i3));
        }
    }

    public void setMoreBackground(Drawable drawable) {
        if (drawable == null) {
            ms.a.i("MoreLyricLayout", "setMoreBackground() drawable == null.");
            return;
        }
        LinearLayout linearLayout = this.F;
        if (linearLayout == null) {
            ms.a.i("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
        } else {
            linearLayout.setBackgroundDrawable(drawable);
        }
    }

    public void setOnDragCallback(d dVar) {
        this.H = dVar;
    }

    public void setOnMoreLyricLayoutActionListener(com.tencent.mobileqq.wink.editor.music.lyric.interaction.a aVar) {
        this.E = aVar;
    }

    public MoreLyricLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f320912d = null;
        this.f320913e = null;
        this.f320914f = null;
        this.f320915h = new c();
        this.f320916i = null;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = 0;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
    }

    private void p() {
    }

    private void s() {
    }

    private void m(boolean z16) {
    }

    private void q(boolean z16) {
    }

    public void setLyricBackgroundEffect(b bVar) {
    }

    public MoreLyricLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f320912d = null;
        this.f320913e = null;
        this.f320914f = null;
        this.f320915h = new c();
        this.f320916i = null;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = 0;
        l();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout.d
    public void onPanelSlide(View view, float f16) {
    }
}
