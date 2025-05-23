package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AudioRecordFragment extends PublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected CommonRecordSoundPanel C;
    protected View D;
    protected QQAppInterface E;
    protected RelativeLayout F;
    protected View G;
    protected AudioInfo H;
    protected RelativeLayout I;
    public String J;
    public int K;
    public String L;
    public String M;
    protected boolean N;
    protected Handler P;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioRecordFragment.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                AudioRecordFragment.this.I.clearAnimation();
                AudioRecordFragment.this.G.setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioRecordFragment.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j3;
            String str;
            AudioRecordFragment audioRecordFragment;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (AudioRecordFragment.this.getBaseActivity() != null && !AudioRecordFragment.this.isDetached()) {
                int i3 = message.what;
                if (i3 != 3) {
                    if (i3 != 102) {
                        if (i3 == 103 && (str = AudioRecordFragment.this.J) != null && str.equals("publish") && (str2 = (audioRecordFragment = AudioRecordFragment.this).L) != null) {
                            s.b("pub_page", "preview_record", str2, audioRecordFragment.M, "", "");
                            return;
                        }
                        return;
                    }
                    String obj = message.obj.toString();
                    File file = new File(obj);
                    if (file.exists()) {
                        j3 = file.length();
                    } else {
                        j3 = 0;
                    }
                    AudioRecordFragment audioRecordFragment2 = AudioRecordFragment.this;
                    audioRecordFragment2.H = new AudioInfo(obj, (int) audioRecordFragment2.C.i(), j3);
                    AudioRecordFragment.this.C.setVisibility(8);
                    Intent intent = new Intent();
                    intent.putExtra("audio_info", AudioRecordFragment.this.H);
                    AudioRecordFragment.this.getBaseActivity().setResult(-1, intent);
                    AudioRecordFragment.this.getBaseActivity().finish();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAudioPanel", 2, "RECORD_TO_START =============");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "handleMessage,fragment is in a invalid state, return");
            }
        }
    }

    public AudioRecordFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = 0;
        this.L = null;
        this.M = null;
        this.N = true;
        this.P = new b();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean m3 = this.C.m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + m3);
        }
        this.C.onBackEvent();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view.getId() == R.id.jva && this.N) {
            getBaseActivity().setResult(0);
            getBaseActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            this.D = layoutInflater.inflate(R.layout.a2g, (ViewGroup) null);
            this.E = getBaseActivity().app;
            this.I = (RelativeLayout) this.D.findViewById(R.id.root);
            this.K = getArguments().getInt("audio_max_length", 60000);
            boolean z16 = getArguments().getBoolean("auto_start", false);
            String string = getArguments().getString("from");
            this.J = string;
            if (string != null && string.equals("publish")) {
                this.L = getArguments().getString("bid");
                this.M = getArguments().getString("fromflag");
            }
            this.N = getArguments().getBoolean("click_space_cancel", true);
            this.F = (RelativeLayout) this.D.findViewById(R.id.a0h);
            ph(getResources(), this.F);
            CommonRecordSoundPanel commonRecordSoundPanel = (CommonRecordSoundPanel) layoutInflater.inflate(R.layout.a18, (ViewGroup) null);
            this.C = commonRecordSoundPanel;
            commonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.C));
            this.F.addView(this.C);
            this.C.l(this.E, getBaseActivity(), this.P, 1, z16);
            this.C.reset();
            this.C.setTimeOutTime(this.K);
            this.C.setPermissionBusinessParams(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.QQ_EXPAND_FRIEND_PROFILE_RECORD_AUDIO);
            View findViewById = this.D.findViewById(R.id.jva);
            this.G = findViewById;
            findViewById.setOnClickListener(this);
            Animation loadAnimation = AnimationUtils.loadAnimation(getBaseActivity(), R.anim.f154424l);
            loadAnimation.setAnimationListener(new a());
            this.I.startAnimation(loadAnimation);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        boolean m3 = this.C.m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + m3);
        }
        this.C.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            getBaseActivity().overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        boolean m3 = this.C.m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + m3);
        }
        this.C.onPause();
    }

    protected void ph(Resources resources, View view) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) resources, (Object) view);
            return;
        }
        Drawable drawable = resources.getDrawable(R.drawable.skin_panel_background);
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof SkinnableBitmapDrawable) {
            bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setDither(true);
        view.setBackgroundDrawable(bitmapDrawable);
    }
}
