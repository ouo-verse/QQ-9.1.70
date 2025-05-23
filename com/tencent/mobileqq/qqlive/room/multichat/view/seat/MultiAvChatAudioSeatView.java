package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.misc.widget.VoiceLinkMicEffect;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatAudioSeatView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private final Runnable C;

    /* renamed from: d, reason: collision with root package name */
    private MultiAvChatCornerImageView f271811d;

    /* renamed from: e, reason: collision with root package name */
    private URLDrawable.URLDrawableOptions f271812e;

    /* renamed from: f, reason: collision with root package name */
    private String f271813f;

    /* renamed from: h, reason: collision with root package name */
    private VoiceLinkMicEffect f271814h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f271815i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f271816m;

    public MultiAvChatAudioSeatView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271813f = "";
        this.f271815i = true;
        this.f271816m = false;
        this.C = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatAudioSeatView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiAvChatAudioSeatView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MultiAvChatAudioSeatView.this.f271814h.k();
                }
            }
        };
        b();
    }

    private void b() {
        View.inflate(getContext(), R.layout.f168915ha3, this);
        this.f271811d = (MultiAvChatCornerImageView) findViewById(R.id.f115266vk);
        this.f271814h = (VoiceLinkMicEffect) findViewById(R.id.f1200478h);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.a0h);
        setBackgroundColor(-11316397);
        frameLayout.setBackground(URLDrawable.getDrawable("https://dldir1v6.qq.com/huayang/multichat/multi_chat_audio_bkg.png", URLDrawable.URLDrawableOptions.obtain()));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        this.f271812e = obtain;
        obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.ovu);
        this.f271812e.mFailedDrawable = getResources().getDrawable(R.drawable.ovu);
        this.f271811d.setRadius(Utils.o(48.0f, getResources()));
        this.f271815i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (this.f271814h.i()) {
            this.f271814h.k();
        }
        this.f271814h.removeAllViews();
    }

    public void setHeadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str) || this.f271813f.equalsIgnoreCase(str)) {
            return;
        }
        this.f271813f = str;
        Drawable drawable = getResources().getDrawable(R.drawable.lqy);
        URLDrawable.URLDrawableOptions uRLDrawableOptions = this.f271812e;
        uRLDrawableOptions.mLoadingDrawable = drawable;
        uRLDrawableOptions.mFailedDrawable = drawable;
        this.f271811d.setImageDrawable(URLDrawable.getDrawable(str, uRLDrawableOptions));
    }

    public void setIsMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f271816m = z16;
        }
    }

    public MultiAvChatAudioSeatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271813f = "";
        this.f271815i = true;
        this.f271816m = false;
        this.C = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatAudioSeatView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiAvChatAudioSeatView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MultiAvChatAudioSeatView.this.f271814h.k();
                }
            }
        };
        b();
    }

    public MultiAvChatAudioSeatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f271813f = "";
        this.f271815i = true;
        this.f271816m = false;
        this.C = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatAudioSeatView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiAvChatAudioSeatView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MultiAvChatAudioSeatView.this.f271814h.k();
                }
            }
        };
        b();
    }
}
