package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer;

/* compiled from: P */
/* loaded from: classes24.dex */
public class h extends b {
    static IPatchRedirector $redirector_;
    public INTZPlanPlayer I;

    public h(d dVar, Context context, com.tencent.aio.api.runtime.a aVar, ViewGroup viewGroup, EditText editText, AppInterface appInterface) {
        super(dVar, context, aVar, viewGroup, editText);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, context, aVar, viewGroup, editText, appInterface);
            return;
        }
        INTZPlanPlayer iNTZPlanPlayer = (INTZPlanPlayer) com.tencent.qqnt.aio.adapter.a.b(INTZPlanPlayer.class);
        this.I = iNTZPlanPlayer;
        iNTZPlanPlayer.init(context.getApplicationContext(), this.f356483e, this.f356482d, appInterface);
        View view = this.I.getView();
        view.setId(R.id.f126867px);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f356483e, this.f356482d);
        layoutParams.addRule(13, -1);
        this.f356487m.addView(view, layoutParams);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.b
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        super.c(false);
        if (z16) {
            this.f356485h.setVisibility(4);
            INTZPlanPlayer iNTZPlanPlayer = this.I;
            if (iNTZPlanPlayer != null) {
                iNTZPlanPlayer.getView().setVisibility(0);
            }
            this.f356487m.setOnClickListener(this);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        INTZPlanPlayer iNTZPlanPlayer = this.I;
        if (iNTZPlanPlayer != null && iNTZPlanPlayer.getView().getVisibility() == 0 && this.I.isReady()) {
            this.I.play();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        INTZPlanPlayer iNTZPlanPlayer = this.I;
        if (iNTZPlanPlayer != null && iNTZPlanPlayer.isPlaying()) {
            this.I.pause();
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.b, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
