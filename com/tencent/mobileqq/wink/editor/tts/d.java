package com.tencent.mobileqq.wink.editor.tts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.tts.source.a;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tavcut.core.render.player.IPlayer;
import java.util.Map;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.enums.AudioSourceType;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends WinkEditorMenuPart {
    private e M;
    private RecyclerView N;
    private com.tencent.mobileqq.wink.editor.tts.b P;
    private StartPointSeekBar Q;
    private ImageView R;
    private ImageView S;
    private IPlayer.PlayerListener T = new a();
    private boolean U;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            d.this.P.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements StartPointSeekBar.a {

        /* renamed from: d, reason: collision with root package name */
        boolean f322566d = false;

        /* renamed from: e, reason: collision with root package name */
        float f322567e = -1.0f;

        c() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(StartPointSeekBar startPointSeekBar) {
            this.f322566d = false;
            d.this.Ma(this.f322567e);
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(StartPointSeekBar startPointSeekBar) {
            this.f322566d = true;
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(StartPointSeekBar startPointSeekBar, int i3) {
            float f16 = i3 / 50.0f;
            if (!this.f322566d) {
                d.this.Ma(f16);
            }
            this.f322567e = f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.tts.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C9046d implements a.InterfaceC9047a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkTTSDataInfo f322569a;

        C9046d(WinkTTSDataInfo winkTTSDataInfo) {
            this.f322569a = winkTTSDataInfo;
        }

        @Override // com.tencent.mobileqq.wink.editor.tts.source.a.InterfaceC9047a
        @SuppressLint({"NotifyDataSetChanged"})
        public void a(int i3, boolean[] zArr, int i16) {
            if (zArr != null || i16 != 1000009) {
                d.this.U = false;
                if (zArr == null || this.f322569a.getDownloadStatus() != 2) {
                    this.f322569a.setDownloadStatus(0);
                    w53.b.a("WinkTTSMenuPart", "handleDownloadCallback error show toast" + this.f322569a.getDisplayName());
                    QQToast.makeText(d.this.getContext(), 1, d.this.getContext().getString(R.string.f239877nn), 5000).show();
                }
                if (this.f322569a.isSelected()) {
                    d.this.Ga(this.f322569a);
                }
            } else {
                this.f322569a.setDownloadStatus(0);
                d.this.La();
            }
            if (d.this.M.R1() != null && !d.this.M.R1().isSelected()) {
                d.this.M.R1().setSelected(true);
                d dVar = d.this;
                dVar.Ga(dVar.M.R1());
            }
            if (d.this.P != null) {
                d.this.P.notifyDataSetChanged();
            }
        }
    }

    private void Fa(WinkTTSDataInfo winkTTSDataInfo) {
        if (winkTTSDataInfo == null) {
            return;
        }
        if (winkTTSDataInfo.getTemplateType() == TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
            winkTTSDataInfo.setSelected(true);
            return;
        }
        this.M.n2();
        if (this.M.d2()) {
            return;
        }
        if (!this.M.P1(winkTTSDataInfo).booleanValue()) {
            winkTTSDataInfo.setDownloadStatus(1);
            this.M.e2(winkTTSDataInfo, true, new C9046d(winkTTSDataInfo));
        } else if (winkTTSDataInfo.isSelected()) {
            Ga(winkTTSDataInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(WinkTTSDataInfo winkTTSDataInfo) {
        if (winkTTSDataInfo != null && winkTTSDataInfo.getTemplateType() != TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
            this.Q.setEnabled(true);
            this.Q.setProgress(winkTTSDataInfo.getVolume() * 50.0f);
            this.R.setVisibility(0);
            this.S.setVisibility(8);
            return;
        }
        this.Q.setEnabled(false);
        this.Q.setProgress(0.0d);
        this.R.setVisibility(8);
        this.S.setVisibility(0);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void Ha(View view) {
        this.N = (RecyclerView) view.findViewById(R.id.f1041962n);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.N.setLayoutManager(linearLayoutManager);
        com.tencent.mobileqq.wink.editor.tts.b bVar = new com.tencent.mobileqq.wink.editor.tts.b(getContext(), new com.tencent.mobileqq.wink.editor.tts.a() { // from class: com.tencent.mobileqq.wink.editor.tts.c
            @Override // com.tencent.mobileqq.wink.editor.tts.a
            public final void a(WinkTTSDataInfo winkTTSDataInfo, boolean z16) {
                d.this.Ia(winkTTSDataInfo, z16);
            }
        });
        this.P = bVar;
        bVar.m0(this.M.a2());
        this.N.setAdapter(this.P);
        this.Q = (StartPointSeekBar) view.findViewById(R.id.f1043162z);
        this.R = (ImageView) view.findViewById(R.id.f10433631);
        this.S = (ImageView) view.findViewById(R.id.f1202278z);
        this.Q.setOnSeekBarChangeListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(WinkTTSDataInfo winkTTSDataInfo, boolean z16) {
        if (this.U) {
            La();
            return;
        }
        if (winkTTSDataInfo.getTemplateType() == TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
            this.M.O1(winkTTSDataInfo);
            Ga(winkTTSDataInfo);
        } else if (this.M.R1() != null && winkTTSDataInfo.getTemplateType() == this.M.R1().getTemplateType()) {
            Ja();
        } else {
            Fa(winkTTSDataInfo);
        }
        com.tencent.mobileqq.wink.editor.tts.b bVar = this.P;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    private void Ja() {
        if (H9() instanceof WinkVideoTavCut) {
            WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) H9();
            Entity templateTTSEntity = winkVideoTavCut.getTemplateTTSEntity();
            long longValue = this.M.S1().longValue();
            if (templateTTSEntity != null && longValue >= 0) {
                winkVideoTavCut.seek(longValue);
                return;
            }
        }
        this.M.h2(true);
    }

    private void Ka(Boolean bool) {
        int i3;
        if (bool.booleanValue()) {
            i3 = 16;
        } else {
            i3 = 17;
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(i3, 103));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        this.U = true;
        QQToast.makeText(getContext(), 1, getContext().getString(R.string.f239887no), 5000).show();
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_NOT_SUP_TEXT_READ_TOAST);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.reportEvent("ev_xsj_camera_action", buildElementParams);
    }

    private void initViewModel() {
        w53.b.a("WinkTTSMenuPart", "initViewModel");
        e eVar = (e) getViewModel(e.class);
        this.M = eVar;
        eVar.b2();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f1042062o;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void L9(@Nullable Bundle bundle) {
        super.L9(bundle);
        if (H9() != null) {
            H9().addPlayerListener(this.T);
        }
        if (bundle != null) {
            TTSAudioInfo tTSAudioInfo = (TTSAudioInfo) bundle.getSerializable(QQWinkConstants.PICK_TEMPLATE_TTS_MODEL);
            if (tTSAudioInfo != null) {
                this.M.r2(tTSAudioInfo);
                WinkTTSDataInfo Z1 = this.M.Z1(tTSAudioInfo);
                if (tTSAudioInfo.getAudioItems() == null) {
                    Fa(Z1);
                } else {
                    if (tTSAudioInfo.getAudioItems() != null && tTSAudioInfo.getAudioItems().length == 1) {
                        boolean z16 = false;
                        AudioInfo audioInfo = tTSAudioInfo.getAudioItems()[0].getAudioInfo();
                        if (audioInfo != null) {
                            if (audioInfo.DataLen == 0) {
                                z16 = true;
                            }
                            this.U = z16;
                        }
                    }
                    if (this.M.R1() != null && !this.M.R1().isSelected()) {
                        this.M.R1().setSelected(true);
                    }
                }
                Ga(this.M.R1());
                Ja();
                com.tencent.mobileqq.wink.editor.tts.b bVar = this.P;
                if (bVar != null) {
                    bVar.notifyDataSetChanged();
                }
            }
            Ka(Boolean.TRUE);
        }
    }

    public void Ma(float f16) {
        if (H9() instanceof WinkVideoTavCut) {
            this.M.w2(f16);
            if (((WinkVideoTavCut) H9()).getTemplateTTSEntity() != null) {
                ((WinkVideoTavCut) H9()).G3(f16, AudioSourceType.TTS);
            } else {
                this.M.h2(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NonNull
    public MenuType ba() {
        return MenuType.TTS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NonNull View view) {
        w53.b.a("WinkTTSMenuPart", "initAfterInflation");
        super.initAfterInflation(view);
        Ha(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        Ka(Boolean.FALSE);
        this.U = false;
        if (H9() != null) {
            H9().removePlayerListener(this.T);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NonNull View view) {
        super.onInitView(view);
        initViewModel();
        this.M.J.observe(getHostFragment(), new b());
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        e eVar = this.M;
        if (eVar != null) {
            eVar.m2();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements IPlayer.PlayerListener {
        a() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            boolean z16;
            if (d.this.H9() != null && d.this.H9().getCurrentPlayer() != null) {
                z16 = d.this.H9().getCurrentPlayer().isPlaying();
            } else {
                z16 = true;
            }
            d.this.M.i2(j3, j16, z16);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NonNull IPlayer iPlayer) {
            d.this.M.j2(playerStatus);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NonNull IPlayer iPlayer) {
        }
    }
}
