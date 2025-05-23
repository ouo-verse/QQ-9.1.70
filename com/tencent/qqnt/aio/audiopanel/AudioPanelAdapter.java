package com.tencent.qqnt.aio.audiopanel;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes34.dex */
public class AudioPanelAdapter extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f349531d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f349532e;

    /* renamed from: f, reason: collision with root package name */
    public AudioPanel f349533f;

    /* renamed from: h, reason: collision with root package name */
    public ViewGroup f349534h;

    /* renamed from: i, reason: collision with root package name */
    public ViewGroup f349535i;

    /* renamed from: m, reason: collision with root package name */
    private m f349536m;

    public AudioPanelAdapter(QQAppInterface qQAppInterface, AudioPanel audioPanel, ViewGroup viewGroup, m mVar) {
        this.f349531d = qQAppInterface;
        this.f349533f = audioPanel;
        this.f349532e = viewGroup;
        this.f349536m = mVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return 3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(View view, int i3, Object obj) {
        super.setPrimaryItem(view, i3, obj);
        if (obj instanceof ViewGroup) {
            this.f349534h = (ViewGroup) obj;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i3, Object obj) {
        if (obj == null) {
            return;
        }
        ((ViewGroup) view).removeView((View) obj);
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.destroyItem() is called,position is:" + i3);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(final View view, int i3) {
        if (i3 == 1) {
            ViewGroup frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(1001);
            PressToSpeakPanel pressToSpeakPanel = (PressToSpeakPanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvs, (ViewGroup) null);
            pressToSpeakPanel.F(this.f349531d, frameLayout, this.f349533f, this.f349532e, this.f349536m);
            ListenPanel listenPanel = (ListenPanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvp, (ViewGroup) null);
            listenPanel.i(this.f349531d, frameLayout, this.f349533f, this.f349532e, 1, this.f349536m);
            listenPanel.setNeedAudioData(true);
            frameLayout.addView(pressToSpeakPanel, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(listenPanel, new FrameLayout.LayoutParams(-1, -1));
            pressToSpeakPanel.N();
            pressToSpeakPanel.setVisibility(0);
            listenPanel.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            if (viewGroup == null) {
                ((ViewGroup) view).addView(frameLayout);
                return frameLayout;
            }
            if (viewGroup == view) {
                return frameLayout;
            }
            viewGroup.removeView(frameLayout);
            ((ViewGroup) view).addView(frameLayout);
            return frameLayout;
        }
        if (i3 == 0) {
            ViewGroup frameLayout2 = new FrameLayout(view.getContext());
            frameLayout2.setId(1000);
            PressToChangeVoicePanel pressToChangeVoicePanel = (PressToChangeVoicePanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvr, (ViewGroup) null);
            pressToChangeVoicePanel.m(this.f349531d, frameLayout2, this.f349533f, this.f349532e, this, this.f349536m);
            frameLayout2.addView(pressToChangeVoicePanel, new FrameLayout.LayoutParams(-1, -1));
            if (!Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) || !DeviceInfoMonitor.getModel().toUpperCase().startsWith("HM NOTE")) {
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.AudioPanelAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AudioPanelAdapter.this.f349535i == null) {
                            try {
                                ListenChangeVoicePanel listenChangeVoicePanel = (ListenChangeVoicePanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvo, (ViewGroup) null);
                                AudioPanelAdapter audioPanelAdapter = AudioPanelAdapter.this;
                                if (audioPanelAdapter.f349535i == null) {
                                    audioPanelAdapter.f349535i = listenChangeVoicePanel;
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AIOAudioPanel", 2, "inflate ListenPanel on subthread get exception " + e16 + " model=" + Build.MANUFACTURER + DeviceInfoMonitor.getModel());
                                }
                            }
                        }
                        AudioPanelAdapter.this.f349531d.getRuntimeService(IPttPreSendService.class);
                    }
                }, 100L);
            }
            pressToChangeVoicePanel.s();
            pressToChangeVoicePanel.setVisibility(0);
            ViewGroup viewGroup2 = (ViewGroup) frameLayout2.getParent();
            if (viewGroup2 == null) {
                ((ViewGroup) view).addView(frameLayout2);
            } else if (viewGroup2 != view) {
                viewGroup2.removeView(frameLayout2);
                ((ViewGroup) view).addView(frameLayout2);
            }
            return frameLayout2;
        }
        if (i3 != 2) {
            return null;
        }
        ViewGroup frameLayout3 = new FrameLayout(view.getContext());
        frameLayout3.setId(1002);
        RecordSoundPanel recordSoundPanel = (RecordSoundPanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvt, (ViewGroup) null);
        recordSoundPanel.g(this.f349531d, frameLayout3, this.f349533f, this.f349532e, this.f349536m);
        ListenPanel listenPanel2 = (ListenPanel) LayoutInflater.from(view.getContext()).inflate(R.layout.gvp, (ViewGroup) null);
        listenPanel2.i(this.f349531d, frameLayout3, this.f349533f, this.f349532e, 2, this.f349536m);
        listenPanel2.setNeedAudioData(true);
        frameLayout3.addView(recordSoundPanel, new FrameLayout.LayoutParams(-1, -1));
        frameLayout3.addView(listenPanel2, new FrameLayout.LayoutParams(-1, -1));
        recordSoundPanel.k();
        recordSoundPanel.setVisibility(0);
        listenPanel2.setVisibility(8);
        ViewGroup viewGroup3 = (ViewGroup) frameLayout3.getParent();
        if (viewGroup3 == null) {
            ((ViewGroup) view).addView(frameLayout3);
            return frameLayout3;
        }
        if (viewGroup3 == view) {
            return frameLayout3;
        }
        viewGroup3.removeView(frameLayout3);
        ((ViewGroup) view).addView(frameLayout3);
        return frameLayout3;
    }
}
