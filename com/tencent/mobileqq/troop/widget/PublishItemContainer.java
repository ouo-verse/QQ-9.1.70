package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class PublishItemContainer extends CustomHorizontalScrollView implements View.OnClickListener, VoicePlayer.a {
    static IPatchRedirector $redirector_;
    protected LinearLayout H;
    protected LinearLayout I;
    protected View J;
    protected ArrayList<String> K;
    protected Drawable L;
    protected CharSequence M;
    protected Activity N;
    private VoicePlayer P;
    public com.tencent.mobileqq.troop.data.b Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;

    /* renamed from: com.tencent.mobileqq.troop.widget.PublishItemContainer$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ PublishItemContainer this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.fullScroll(66);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.troop.widget.PublishItemContainer$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ PublishItemContainer this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.fullScroll(66);
            }
        }
    }

    public PublishItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.K = new ArrayList<>();
        this.L = null;
        this.M = null;
        this.R = 0;
        this.S = 9;
        this.T = false;
        this.U = false;
        this.L = getResources().getDrawable(R.drawable.asd);
        this.N = (Activity) context;
        this.M = BaseApplication.getContext().getResources().getText(R.string.gqq);
        LinearLayout linearLayout = new LinearLayout(context);
        this.I = linearLayout;
        addView(linearLayout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.I.setOrientation(0);
        this.I.setGravity(16);
        this.I.setLayoutParams(layoutParams);
        this.I.setPadding(0, 0, 0, (int) al.a(context, 7.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.H = linearLayout2;
        this.I.addView(linearLayout2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.H.setOrientation(0);
        this.H.setGravity(16);
        this.H.setLayoutParams(layoutParams2);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a2q, (ViewGroup) null);
        this.J = inflate;
        a(inflate);
        this.J.setVisibility(8);
        this.I.addView(this.J);
    }

    protected void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.dgw);
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.kkd);
        uRLImageView.setImageResource(R.drawable.f162291gb1);
        findViewById.setVisibility(8);
        uRLImageView.setAdjustViewBounds(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) uRLImageView.getLayoutParams();
        layoutParams.width = (int) al.a(getContext(), 50.0f);
        layoutParams.height = (int) al.a(getContext(), 50.0f);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        uRLImageView.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams2.topMargin = x.c(getContext(), 2.0f);
        layoutParams2.rightMargin = x.c(getContext(), 2.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) al.a(getContext(), 60.0f), (int) al.a(getContext(), 67.0f));
        layoutParams3.rightMargin = x.c(getContext(), 2.0f);
        layoutParams3.topMargin = x.c(getContext(), 4.0f);
        view.setLayoutParams(layoutParams3);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.R == 2) {
            com.tencent.mobileqq.troop.data.b bVar = this.Q;
            if (bVar instanceof AudioInfo) {
                AudioInfo audioInfo = (AudioInfo) bVar;
                audioInfo.mAudioIcon.setImageResource(R.drawable.skin_aio_ptt_action_l_3);
                Intent intent = new Intent("key_audio_playing_action");
                intent.putExtra("audio_local_path", audioInfo.path);
                BaseApplication.getContext().sendBroadcast(intent);
                if (this.P == null) {
                    VoicePlayer voicePlayer = new VoicePlayer(audioInfo.path, new Handler(), audioInfo.getAudioType());
                    this.P = voicePlayer;
                    voicePlayer.y(getContext());
                    this.P.z();
                    this.P.l(this);
                    this.P.A();
                    this.U = true;
                    AnimationDrawable animationDrawable = (AnimationDrawable) BaseApplicationImpl.getApplication().getResources().getDrawable(R.anim.f154860e9);
                    audioInfo.mAudioIcon.setImageDrawable(animationDrawable);
                    animationDrawable.start();
                }
            }
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        VoicePlayer voicePlayer = this.P;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.P = null;
            this.U = false;
            com.tencent.mobileqq.troop.data.b bVar = this.Q;
            if (!(bVar instanceof AudioInfo)) {
                return;
            }
            AudioInfo audioInfo = (AudioInfo) bVar;
            if (audioInfo.mAudioIcon.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) audioInfo.mAudioIcon.getDrawable()).stop();
            }
            audioInfo.mAudioIcon.setImageResource(R.drawable.skin_aio_ptt_action_l_3);
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.a0l) {
                c();
                BaseApplication.getContext().sendBroadcast(new Intent("key_audio_delete_action"));
                this.R = 0;
                this.Q = null;
            } else if (id5 == R.id.dgw) {
                int indexOf = this.K.indexOf((String) view.getTag());
                this.K.remove(indexOf);
                this.H.removeViewAt(indexOf);
                Intent intent = new Intent("key_photo_delete_action");
                intent.putExtra("key_photo_delete_position", indexOf);
                BaseApplication.getContext().sendBroadcast(intent);
                if (this.K.size() == 0) {
                    setVisibility(8);
                    this.J.setVisibility(8);
                    this.R = 0;
                } else {
                    this.J.setVisibility(0);
                }
            } else if (id5 == R.id.kkd) {
                if (view.getTag() != null) {
                    int indexOf2 = this.K.indexOf((String) view.getTag());
                    com.tencent.mobileqq.utils.e.e();
                    Intent intent2 = new Intent(this.N, (Class<?>) NewPhotoPreviewActivity.class);
                    intent2.putExtra(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
                    intent2.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                    intent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.N.getClass().getName());
                    intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.K);
                    intent2.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
                    intent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.K.size());
                    intent2.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, indexOf2);
                    intent2.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, true);
                    intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
                    intent2.putExtra("from_tribe_class_name", this.N.getClass().getSimpleName());
                    intent2.putExtra(PeakConstants.IS_OVERLOAD, false);
                    intent2.addFlags(603979776);
                    getContext().startActivity(intent2);
                    QAlbumUtil.anim(this.N, false, true);
                } else {
                    BaseApplication.getContext().sendBroadcast(new Intent("key_photo_add_action"));
                }
            } else if (id5 == R.id.a0j || id5 == R.id.a0k) {
                if (this.P == null) {
                    b();
                    if (!this.T) {
                        BaseApplication.getContext().sendBroadcast(new Intent("key_audio_play_action"));
                        this.T = true;
                    }
                } else {
                    c();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCurType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.R = i3;
        }
    }

    public void setItemEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.H.setEnabled(z16);
        if (this.R == 2) {
            View childAt = this.H.getChildAt(0);
            View findViewById = childAt.findViewById(R.id.a0k);
            View findViewById2 = childAt.findViewById(R.id.a0l);
            if (findViewById != null && findViewById2 != null) {
                findViewById.setEnabled(z16);
                findViewById2.setEnabled(z16);
            }
        }
        setEnabled(z16);
    }

    public void setMaxPicNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.S = i3;
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        } else {
            c();
        }
    }
}
