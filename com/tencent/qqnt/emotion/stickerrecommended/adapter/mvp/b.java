package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.stickerrecommended.view.emotionintegrate.EmotionKeywordLayout;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b implements e, View.OnClickListener {
    static IPatchRedirector $redirector_;
    TextView C;
    Animator D;
    ImageView E;
    Drawable F;
    EditText G;
    private StickerRecKeywordFrom H;

    /* renamed from: d, reason: collision with root package name */
    public int f356482d;

    /* renamed from: e, reason: collision with root package name */
    public int f356483e;

    /* renamed from: f, reason: collision with root package name */
    public int f356484f;

    /* renamed from: h, reason: collision with root package name */
    public RoundCornerImageView f356485h;

    /* renamed from: i, reason: collision with root package name */
    a f356486i;

    /* renamed from: m, reason: collision with root package name */
    RelativeLayout f356487m;

    public b(d dVar, Context context, com.tencent.aio.api.runtime.a aVar, ViewGroup viewGroup, EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, context, aVar, viewGroup, editText);
            return;
        }
        this.f356486i = (a) dVar;
        this.G = editText;
        this.F = context.getResources().getDrawable(R.drawable.f160231dr);
        float f16 = context.getResources().getDisplayMetrics().density;
        int i3 = (int) (64.0f * f16);
        this.f356482d = i3;
        this.f356483e = i3;
        this.f356484f = (int) (6.0f * f16);
        int i16 = (int) (7.0f * f16);
        this.f356487m = new EmotionKeywordLayout(context, aVar, viewGroup);
        this.f356487m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f356487m.setPadding(i16, (int) (9.0f * f16), i16, (int) (f16 * 8.0f));
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(context);
        this.f356485h = roundCornerImageView;
        roundCornerImageView.setCorner(this.f356484f);
        this.f356485h.setBackgroundResource(R.drawable.qui_common_bg_top_light_bg_selector);
        this.f356485h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f356485h.setId(R.id.df9);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f356483e, this.f356482d);
        layoutParams.addRule(13, -1);
        this.f356487m.addView(this.f356485h, layoutParams);
        TextView textView = new TextView(context);
        this.C = textView;
        textView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.gxf));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, R.id.df9);
        layoutParams2.addRule(8, R.id.df9);
        this.C.setText(R.string.f170877in1);
        this.C.setTextColor(context.getResources().getColor(R.color.skin_white));
        this.C.setTextSize(1, 12.0f);
        this.f356487m.addView(this.C, layoutParams2);
        ImageView imageView = new ImageView(context);
        this.E = imageView;
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bft));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, R.id.df9);
        layoutParams3.addRule(8, R.id.df9);
        this.f356487m.addView(this.E, layoutParams3);
        this.E.setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f356485h, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        this.D = ofFloat;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e
    public void a(StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) stickerRecKeywordFrom);
        } else {
            this.H = stickerRecKeywordFrom;
        }
    }

    public Drawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.F;
    }

    public void c(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.f356485h.getLayoutParams().width = this.f356486i.l();
        int i16 = 0;
        this.f356485h.setVisibility(0);
        if (z16) {
            this.f356487m.setOnClickListener(this);
            this.D.start();
        } else {
            this.f356485h.setImageDrawable(this.F);
        }
        TextView textView = this.C;
        if (this.f356486i.r()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        ImageView imageView = this.E;
        if (!this.f356486i.s()) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        this.f356485h.setContentDescription(this.f356486i.n());
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e
    public StickerRecKeywordFrom getFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (StickerRecKeywordFrom) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.H;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e
    public d getPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f356486i;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f356487m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("CommonStickerRec", 2, NodeProps.ON_CLICK);
            }
            if (this.G == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("CommonStickerRec", 2, "onClick input == null");
                }
            } else if (this.f356486i.q()) {
                this.G.getEditableText().clear();
                this.G.setText("");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
