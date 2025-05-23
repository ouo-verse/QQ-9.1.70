package com.tencent.mobileqq.wink.editor.music;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.ab;
import com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.session.ISessionListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ab extends WinkEditorMenuPart implements c73.a {
    private ViewPagerCompat M;
    private LinearLayout N;
    private TextView P;
    private TextView Q;
    private MarqueeTextView R;
    private RelativeLayout S;
    private NumberCheckBox T;
    private MusicMenuPagerAdapter U;
    private boolean V;
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a W;
    protected MusicSourceViewModel X;
    protected MusicVolumeControlViewModel Y;
    private com.tencent.mobileqq.wink.editor.template.x Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.recommend.b f320711a0;

    /* renamed from: g0, reason: collision with root package name */
    private View f320717g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f320718h0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f320712b0 = true;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f320713c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f320714d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f320715e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f320716f0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private BroadcastReceiver f320719i0 = new a();

    /* renamed from: j0, reason: collision with root package name */
    private final ISessionListener f320720j0 = new b();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ab.this.Bb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements MusicSelectFragment.c {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void pause() {
            if (ab.this.H9() instanceof WinkVideoTavCut) {
                ab.this.H9().pause();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void play() {
            if (ab.this.H9() instanceof WinkVideoTavCut) {
                ab.this.H9().play();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void seek(int i3) {
            if (ab.this.H9() instanceof WinkVideoTavCut) {
                ab.this.H9().seek(i3);
                ab.this.H9().play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ab.this.f320716f0 = true;
            w53.b.f(ab.this.getTAG(), "[observe]mOriginVolumeLayout onClick...");
            ab.this.Y.o2(!r0.T.isChecked(), ab.this.Z.getIsUseTemplate(), true);
            ab.this.Y.l2().postValue(Boolean.TRUE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Ab(View view, boolean z16) {
        String str;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_PANEL);
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        VideoReport.reportEvent(str, view, buildElementParams);
    }

    private void Cb(boolean z16) {
        MusicMenuPagerAdapter musicMenuPagerAdapter = this.U;
        if (musicMenuPagerAdapter != null && (musicMenuPagerAdapter.getItem(0) instanceof MusicSelectFragment)) {
            ((MusicSelectFragment) this.U.getItem(0)).Th(z16);
        }
    }

    private void Db() {
        MarqueeTextView marqueeTextView;
        WinkEditorViewModel winkEditorViewModel = this.winkEditorViewModel;
        if (winkEditorViewModel != null && winkEditorViewModel.getIsFromTemplateColl() && (marqueeTextView = this.R) != null) {
            marqueeTextView.setCloseBtnVisible(false);
            MusicMenuPagerAdapter musicMenuPagerAdapter = this.U;
            if (musicMenuPagerAdapter != null && (musicMenuPagerAdapter.getItem(0) instanceof MusicSelectFragment)) {
                ((MusicSelectFragment) this.U.getItem(0)).Sh(false);
            }
        }
    }

    private void Eb(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_music_name", str);
        hashMap.put("xsj_music_id", str2);
        WinkDatongCurrentParams.params.put("xsj_music_name", str);
        WinkDatongCurrentParams.params.put("xsj_music_id", str2);
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str3);
        WinkDatongCurrentParams.params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementParams(this.R, hashMap);
    }

    private void Fb(final WinkEditorMusicInfo winkEditorMusicInfo) {
        if (this.f320717g0 == null) {
            return;
        }
        if (winkEditorMusicInfo != null && !TextUtils.isEmpty(winkEditorMusicInfo.v())) {
            this.f320717g0.setVisibility(0);
            this.f320717g0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ab.this.xb(winkEditorMusicInfo, view);
                }
            });
            this.f320718h0.setText(winkEditorMusicInfo.v());
            VideoReport.setElementId(this.f320717g0, WinkDaTongReportConstant.ElementParamKey.EM_ACTIVITY_NOTICE_TIP_BAR);
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_text_content", winkEditorMusicInfo.v());
            VideoReport.setElementParams(this.f320717g0, buildElementParams);
            return;
        }
        this.f320717g0.setVisibility(4);
    }

    private void Hb(boolean z16) {
        WinkMusicUIData winkMusicUIData = (WinkMusicUIData) getUiData();
        if (winkMusicUIData == null) {
            return;
        }
        winkMusicUIData.putBoolean(WinkMusicUIData.IS_MUSIC_CLEARED, z16);
        w53.b.a(getTAG(), "isMusicCleared saved " + z16);
    }

    private void Ib(WinkEditorViewModel.EditMode editMode) {
        boolean z16;
        boolean z17;
        WinkEditorViewModel winkEditorViewModel = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
        if (this.S != null && winkEditorViewModel != null) {
            boolean z18 = false;
            if (winkEditorViewModel.getMFrom() == 1 && this.X.getCurrentMusic() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.V && com.tencent.videocut.render.extension.e.u(H9().V().videos)) {
                z17 = true;
            } else {
                z17 = false;
            }
            w53.b.a(getTAG(), "updateOriginVolumeLayout isFromMusicCamera:" + z16 + " isTavCutInit:" + this.V + " isAllImages:" + z17 + " hasEnterMusic:" + this.f320713c0 + " editMode:" + editMode);
            if (editMode == WinkEditorViewModel.EditMode.Video && !z17 && (!this.f320713c0 || !z16)) {
                z18 = true;
            }
            Gb(z18);
        }
    }

    private void Xa() {
        MusicSourceViewModel musicSourceViewModel = this.X;
        if (musicSourceViewModel == null) {
            return;
        }
        musicSourceViewModel.D2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.hb((MusicInfoWrapper) obj);
            }
        });
        this.X.t3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.ib((WinkEditorMusicInfo) obj);
            }
        });
        this.X.u3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.jb((Boolean) obj);
            }
        });
    }

    private void ab() {
        MusicSourceViewModel musicSourceViewModel = this.X;
        if (musicSourceViewModel != null) {
            musicSourceViewModel.x3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.aa
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ab.this.kb((Boolean) obj);
                }
            });
        }
    }

    private void bb() {
        MusicSourceViewModel musicSourceViewModel = this.X;
        if (musicSourceViewModel != null) {
            musicSourceViewModel.g3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ab.this.lb((WinkEditorMusicInfo) obj);
                }
            });
        }
    }

    private void cb(View view) {
        this.S = (RelativeLayout) view.findViewById(R.id.f644636a);
        this.T = (NumberCheckBox) view.findViewById(R.id.f644536_);
        this.S.setOnClickListener(new d());
        this.Y.k2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.mb((Boolean) obj);
            }
        });
        this.Y.h2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.ob((Float) obj);
            }
        });
        this.X.v3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.pb((Boolean) obj);
            }
        });
    }

    private void eb(View view) {
        com.tencent.mobileqq.wink.editor.music.viewmodel.f fVar = new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) view.getContext().getSystemService("audio"), Scene.EDIT);
        ViewModelStoreOwner Za = Za();
        if (Za != null) {
            this.W = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) new ViewModelProvider(Za, fVar).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        }
    }

    private void fb() {
        com.tencent.mobileqq.wink.editor.template.x xVar = (com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
        this.Z = xVar;
        xVar.P1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.qb((x.UpdateTemplateAction) obj);
            }
        });
    }

    private void gb(View view) {
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) view.findViewById(R.id.f12029796);
        this.M = viewPagerCompat;
        if (viewPagerCompat != null) {
            viewPagerCompat.setScrollable(false);
        }
        this.N = (LinearLayout) view.findViewById(R.id.f6444369);
        this.P = (TextView) view.findViewById(R.id.f122747es);
        TextView textView = (TextView) view.findViewById(R.id.f122757et);
        this.Q = textView;
        com.tencent.mobileqq.wink.report.a.f326259a.c(textView, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_VOLUME_BUTTON, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, null, null, null);
        this.f320717g0 = view.findViewById(R.id.zk5);
        this.f320718h0 = (TextView) view.findViewById(R.id.f166359zk4);
        cb(view);
        if (this.M != null && getHostFragment() != null) {
            this.U = new MusicMenuPagerAdapter(Ya(), Scene.EDIT, Za());
            Db();
            if (this.U.getItem(0) instanceof MusicSelectFragment) {
                ((MusicSelectFragment) this.U.getItem(0)).Vh(new c());
                ((MusicSelectFragment) this.U.getItem(0)).Uh(new MusicSelectFragment.b() { // from class: com.tencent.mobileqq.wink.editor.music.k
                });
            }
            this.M.setAdapter(this.U);
            this.P.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ab.this.sb(view2);
                }
            });
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ab.this.tb(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hb(MusicInfoWrapper musicInfoWrapper) {
        boolean z16;
        this.X.g3().postValue(musicInfoWrapper.getMusicInfo());
        if (this.X.getEditMode() == WinkEditorViewModel.EditMode.Image) {
            return;
        }
        if (musicInfoWrapper.getMusicInfo() != null && !TextUtils.isEmpty(musicInfoWrapper.getMusicInfo().q())) {
            String q16 = musicInfoWrapper.getMusicInfo().q();
            String p16 = musicInfoWrapper.getMusicInfo().p();
            Fb(musicInfoWrapper.getMusicInfo());
            Eb(q16, p16, musicInfoWrapper.getMusicInfo().E);
            this.R.n(q16);
            this.R.setCloseBtnVisible(true);
        } else {
            if (H9() != null) {
                z16 = H9().G();
            } else {
                z16 = false;
            }
            w53.b.a(getTAG(), "getBgmSourceLiveData update " + this.Z.getIsUseTemplate() + ", tavcut isUsingTemplate " + z16);
            if (!this.Z.getIsUseTemplate() && !z16) {
                this.R.a();
                Eb("", "", "");
            } else {
                this.R.n(getContext().getString(R.string.ym_));
                this.R.setCloseBtnVisible(true);
            }
            Fb(null);
        }
        Db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ib(WinkEditorMusicInfo winkEditorMusicInfo) {
        if (this.X.getEditMode() != WinkEditorViewModel.EditMode.Image) {
            return;
        }
        if (winkEditorMusicInfo == null) {
            this.R.a();
            Fb(null);
            Eb("", "", "");
        } else {
            String q16 = winkEditorMusicInfo.q();
            String p16 = winkEditorMusicInfo.p();
            this.R.n(q16);
            this.R.setCloseBtnVisible(false);
            Fb(winkEditorMusicInfo);
            Eb(q16, p16, winkEditorMusicInfo.E);
        }
    }

    private void initViewModel() {
        if (this.X != null) {
            J3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ab.this.rb((Long) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jb(Boolean bool) {
        boolean z16 = true;
        if (bool.booleanValue()) {
            this.R.n(getContext().getString(R.string.ym_));
            this.R.setCloseBtnVisible(true);
            Fb(null);
        } else if (this.X.getCurrentMusic() != null) {
            String q16 = this.X.getCurrentMusic().q();
            String p16 = this.X.getCurrentMusic().p();
            Fb(this.X.getCurrentMusic());
            Eb(q16, p16, this.X.getCurrentMusic().E);
            this.R.n(q16);
            MarqueeTextView marqueeTextView = this.R;
            if (this.X.getEditMode() == WinkEditorViewModel.EditMode.Image) {
                z16 = false;
            }
            marqueeTextView.setCloseBtnVisible(z16);
        } else {
            this.R.a();
            Fb(null);
        }
        if (this.Z.getIsUseTemplate() && !this.Y.getIsOriginalVolumeChangedManually()) {
            this.Y.K2(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kb(Boolean bool) {
        Hb(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lb(WinkEditorMusicInfo winkEditorMusicInfo) {
        if (!this.f320715e0) {
            this.f320715e0 = true;
            g73.a.f401518a.a(this.R, winkEditorMusicInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mb(Boolean bool) {
        this.T.setChecked(bool.booleanValue());
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SOUND_IS_ORIGIN, Integer.valueOf(bool.booleanValue() ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map nb(String str) {
        String str2;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        w53.b.f(getTAG(), "[observe] xsj event:" + str + " isChecked:" + this.T.isChecked());
        if ("imp".equals(str)) {
            if (this.T.isChecked()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            buildElementParams.put("xsj_is_tick", str2);
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ob(Float f16) {
        boolean z16;
        String str;
        w53.b.f(getTAG(), "[observe]getOriginLiveData update volume to " + f16);
        NumberCheckBox numberCheckBox = this.T;
        boolean z17 = true;
        if (f16.floatValue() != 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        numberCheckBox.setChecked(z16);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        aVar.c(this.S, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_ORIGIN_BUTTON, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.wink.editor.music.q
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map nb5;
                nb5 = ab.this.nb(str2);
                return nb5;
            }
        });
        if (this.f320716f0) {
            this.f320716f0 = false;
            Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            if (this.T.isChecked()) {
                str = "1";
            } else {
                str = "0";
            }
            buildElementParams.put("xsj_is_tick", str);
            aVar.e(this.S, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_ORIGIN_BUTTON, buildElementParams);
        }
        this.Y.E2(Boolean.valueOf(this.T.isChecked()));
        MusicVolumeControlViewModel musicVolumeControlViewModel = this.Y;
        if (f16.floatValue() == 0.0f) {
            z17 = false;
        }
        musicVolumeControlViewModel.I2(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pb(Boolean bool) {
        ViewGroup.LayoutParams layoutParams = this.S.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.S.getLayoutParams();
        if (bool.booleanValue()) {
            layoutParams2.bottomMargin = ViewUtils.dpToPx(247.0f);
        } else {
            layoutParams2.bottomMargin = ViewUtils.dpToPx(220.0f);
        }
        this.S.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qb(x.UpdateTemplateAction updateTemplateAction) {
        boolean z16;
        if (updateTemplateAction == null) {
            return;
        }
        if (H9() != null && com.tencent.videocut.render.extension.e.u(H9().g0())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(updateTemplateAction.getTemplatePath())) {
            if (z16) {
                this.Y.S1(0.0f, MusicVolumeControlViewModel.VolumeType.ORIGIN);
            } else {
                MusicVolumeControlViewModel musicVolumeControlViewModel = this.Y;
                musicVolumeControlViewModel.Q1(musicVolumeControlViewModel.d2());
            }
            this.Y.H2(!z16);
            this.Y.K2(true);
            MusicVolumeControlViewModel musicVolumeControlViewModel2 = this.Y;
            musicVolumeControlViewModel2.S1(musicVolumeControlViewModel2.Z1(), MusicVolumeControlViewModel.VolumeType.TEMPLATE);
            return;
        }
        if (!z16) {
            MusicVolumeControlViewModel musicVolumeControlViewModel3 = this.Y;
            musicVolumeControlViewModel3.Q1(musicVolumeControlViewModel3.d2());
            this.Y.H2(true);
        }
        this.Y.K2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rb(Long l3) {
        MusicMenuPagerAdapter musicMenuPagerAdapter = this.U;
        if (musicMenuPagerAdapter != null && (musicMenuPagerAdapter.getItem(0) instanceof MusicSelectFragment)) {
            ((MusicSelectFragment) this.U.getItem(0)).Yh(l3.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sb(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.M.setCurrentItem(0);
        this.P.setTextColor(getHostFragment().getResources().getColor(R.color.bfp));
        this.Q.setTextColor(getHostFragment().getResources().getColor(R.color.bfq));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tb(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.M.setCurrentItem(1);
        this.Q.setTextColor(getHostFragment().getResources().getColor(R.color.bfp));
        this.P.setTextColor(getHostFragment().getResources().getColor(R.color.bfq));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ub(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q9(null);
        this.X.E3();
        VideoReport.setElementId(this.R, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        buildElementParams.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.setElementParams(this.R, buildElementParams);
        VideoReport.setElementClickPolicy(this.R, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", this.R, buildElementParams);
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("xsp_xsj_fabuqi_qukushiyongxintuijian");
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_fabuqi_yinyuejieruqyinresou");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vb(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.X.y2();
        try {
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_MUSIC_CLOSE_BGM");
                WinkContext.Companion companion = WinkContext.INSTANCE;
                f16.b(eventId.traceId(companion.d().getTraceId()).getReportData(), companion.d().k().a());
            }
        } catch (Exception e16) {
            w53.b.e(getTAG(), e16);
        }
        w53.b.c(getTAG(), "click close button");
        this.R.d("dt_clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wb(MenuSwitchAction menuSwitchAction) {
        if (menuSwitchAction.getMenuType() == MenuType.BOTTOM_DASHBOARD && this.winkEditorViewModel.getIsEnableMusic()) {
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xb(WinkEditorMusicInfo winkEditorMusicInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.wink.f.l(getContext(), winkEditorMusicInfo.u());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void yb() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getActivity().registerReceiver(this.f320719i0, intentFilter);
        } catch (Exception e16) {
            w53.b.a(getTAG(), "registerReceiver " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zjr;
    }

    protected void Bb() {
        MusicSourceViewModel musicSourceViewModel;
        if (this.V && H9() != null && this.winkEditorViewModel != null && (musicSourceViewModel = this.X) != null && musicSourceViewModel.getGetCategoryMusicListFail()) {
            this.f320711a0.M1(H9().g0(), this.winkEditorViewModel.getIsAllImages(), H9().getDurationUs());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gb(boolean z16) {
        if (z16) {
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MutableLiveData<Long> J3() {
        return this.winkEditorViewModel.B2();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(WinkEditorViewModel.EditMode editMode) {
        super.J9(editMode);
        this.X.o4(editMode);
        MusicMenuPagerAdapter musicMenuPagerAdapter = this.U;
        if (musicMenuPagerAdapter != null) {
            Fragment item = musicMenuPagerAdapter.getItem(0);
            if (item instanceof MusicSelectFragment) {
                ((MusicSelectFragment) item).Jh(editMode);
            }
        }
        if (!this.V && (H9() instanceof WinkVideoTavCut)) {
            this.V = true;
        }
        Ib(editMode);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle bundle) {
        super.L9(bundle);
        Cb(true);
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.W;
        if (aVar != null) {
            aVar.O1();
            ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
            if (this.X.getEditMode() == WinkEditorViewModel.EditMode.Image) {
                TextView textView = this.Q;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.P;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                layoutParams.height = ViewUtils.dpToPx(162.0f);
            } else {
                TextView textView3 = this.Q;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.P;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                layoutParams.height = ViewUtils.dpToPx(208.0f);
            }
            this.N.setLayoutParams(layoutParams);
            this.N.requestLayout();
        }
        TextView textView5 = this.P;
        if (textView5 != null) {
            textView5.performClick();
        }
        Ib(this.X.getEditMode());
        Ab(this.N, true);
        this.Y.P1();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData winkEditUIData) {
        super.N9(winkEditUIData);
        if (winkEditUIData instanceof WinkMusicUIData) {
            WinkMusicUIData winkMusicUIData = (WinkMusicUIData) winkEditUIData;
            O9(winkMusicUIData);
            this.Y.F2(winkMusicUIData.getMediaClipVolumes());
            boolean isChangedManually = winkMusicUIData.getIsChangedManually();
            Pair<Boolean, Boolean> originalVolumeEnable = winkMusicUIData.getOriginalVolumeEnable();
            if (originalVolumeEnable != null) {
                this.Y.w2(originalVolumeEnable);
                if (isChangedManually && (originalVolumeEnable.getFirst().booleanValue() || originalVolumeEnable.getSecond().booleanValue())) {
                    this.Y.N2(this.Y.j2(winkMusicUIData.getMediaClipVolumes()));
                }
            }
            this.Y.L2(winkMusicUIData.getBGMVolume());
            this.Y.J2(isChangedManually);
            this.Y.x2(isChangedManually);
            boolean z16 = winkEditUIData.getBoolean(WinkMusicUIData.IS_MUSIC_CLEARED, false);
            w53.b.a(getTAG(), "isMusicCleared restored " + z16);
            if (z16) {
                this.X.y2();
            }
        }
    }

    @Override // c73.a
    public void W(long j3) {
        if (this.X != null && this.winkEditorViewModel.getIsEnableMusic()) {
            this.X.z4(j3 / 1000);
            if (getActivity() != null && getActivity().getIntent() != null && this.f320712b0) {
                this.f320712b0 = false;
                Intent intent = getActivity().getIntent();
                Parcelable parcelableExtra = intent.getParcelableExtra(QQWinkConstants.MUSIC_INFO);
                if (parcelableExtra instanceof WinkEditorMusicInfo) {
                    WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) parcelableExtra;
                    int intExtra = intent.getIntExtra(QQWinkConstants.MUSIC_START_TIME, winkEditorMusicInfo.s());
                    this.X.a4(winkEditorMusicInfo.p(), intExtra, true);
                    this.X.y4(Integer.valueOf(intExtra));
                    this.X.N3(winkEditorMusicInfo, 0, false, false);
                    float floatExtra = intent.getFloatExtra(QQWinkConstants.MUSIC_VOLUME, 1.0f);
                    this.Y.D2(floatExtra);
                    this.Y.y2(true, false);
                    this.Y.S1(floatExtra, MusicVolumeControlViewModel.VolumeType.BGM);
                    this.Y.H2(false);
                    this.f320713c0 = true;
                    return;
                }
                if (H9() instanceof WinkVideoTavCut) {
                    this.Y.H2(!((WinkVideoTavCut) H9()).f2());
                }
            }
        }
    }

    @Override // c73.a
    public void Y2() {
        if (!this.f320714d0) {
            this.f320714d0 = true;
            j1();
        }
    }

    protected FragmentManager Ya() {
        return getHostFragment().getChildFragmentManager();
    }

    protected ViewModelStoreOwner Za() {
        return getHostFragment().getActivity();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.MUSIC;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NonNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorMusicMenuPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View view) {
        super.initAfterInflation(view);
        w53.b.a(getTAG(), "initAfterInflation");
        eb(view);
        gb(view);
        initViewModel();
        if (H9() != null) {
            H9().F(this.f320720j0);
            W(H9().getDurationUs());
        }
    }

    @Override // c73.a
    public void j1() {
        w53.b.a(getTAG(), "start saveUiData");
        WinkMusicUIData winkMusicUIData = (WinkMusicUIData) getUiData();
        if (winkMusicUIData == null) {
            return;
        }
        winkMusicUIData.saveBGMVolume(Float.valueOf(this.Y.c2()));
        winkMusicUIData.saveOriginalVolumeEnable(this.Y.W1());
        winkMusicUIData.saveOriginalVolumeSwitch(this.Y.k2().getValue());
        winkMusicUIData.saveMediaClipVolumes(this.Y.e2());
        winkMusicUIData.saveIsChangedManually(Boolean.valueOf(this.Y.m2()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void la() {
        super.la();
        this.Y.l2().postValue(Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        Cb(false);
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.W;
        if (aVar != null) {
            aVar.P1();
        }
        Ab(this.N, false);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        w53.b.a(getTAG(), "onInitView");
        O9(new WinkMusicUIData(this));
        this.R = (MarqueeTextView) view.findViewById(R.id.zjp);
        ViewModelStoreOwner Za = Za();
        if (Za != null) {
            this.Y = (MusicVolumeControlViewModel) new ViewModelProvider(Za).get(MusicVolumeControlViewModel.class);
            this.X = (MusicSourceViewModel) new ViewModelProvider(Za).get(MusicSourceViewModel.class);
            this.f320711a0 = (com.tencent.mobileqq.wink.editor.recommend.b) getViewModel(com.tencent.mobileqq.wink.editor.recommend.b.class);
        }
        VideoReport.setElementExposePolicy(this.R, ExposurePolicy.REPORT_NONE);
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ab.this.ub(view2);
            }
        });
        this.R.setCloseButtonListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ab.this.vb(view2);
            }
        });
        ((WinkEditorViewModel) getViewModel(WinkEditorViewModel.class)).f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.wb((MenuSwitchAction) obj);
            }
        });
        fb();
        Xa();
        ab();
        bb();
        yb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        Wink.Companion companion = Wink.INSTANCE;
        if (companion != null && companion.e() != null) {
            companion.e().d(getContext());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        try {
            activity.unregisterReceiver(this.f320719i0);
        } catch (Exception e16) {
            w53.b.a(getTAG(), "unregisterReceiver" + e16.getMessage());
        }
        super.onPartDestroy(activity);
        Wink.Companion companion = Wink.INSTANCE;
        if (companion != null && companion.e() != null) {
            companion.e().b(getContext());
        }
        this.U = null;
        ViewPagerCompat viewPagerCompat = this.M;
        if (viewPagerCompat != null) {
            viewPagerCompat.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements ISessionListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(long j3, long j16) {
            if (j3 <= 0) {
                ab.this.W(j16);
            } else {
                ab.this.W(j3);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NonNull LAKRenderModel lAKRenderModel, final long j3, final long j16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ab.b.this.b(j16, j3);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void K9() {
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
