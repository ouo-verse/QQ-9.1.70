package com.tencent.mobileqq.activity.photo.aiocomment;

import android.content.Intent;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.photo.aiocomment.b;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements b.c, View.OnClickListener, BrowserScaleView.a, BrowserRecyclerView.a {
    static IPatchRedirector $redirector_;
    protected TextView C;
    protected com.tencent.mobileqq.activity.photo.album.preview.view.c D;
    protected PhotoPreviewCustomizationAIO E;
    protected b F;
    private float G;
    private float H;

    /* renamed from: d, reason: collision with root package name */
    protected QBaseActivity f184164d;

    /* renamed from: e, reason: collision with root package name */
    protected PhotoPreviewAIOCommentGuide f184165e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f184166f;

    /* renamed from: h, reason: collision with root package name */
    protected String f184167h;

    /* renamed from: i, reason: collision with root package name */
    protected ETTextView f184168i;

    /* renamed from: m, reason: collision with root package name */
    protected CheckBox f184169m;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184165e = new PhotoPreviewAIOCommentGuide();
            this.f184166f = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.aiocomment.b.c
    public void a(String str) {
        com.tencent.mobileqq.activity.photo.album.preview.view.c cVar;
        PhotoPreviewCustomizationAIO photoPreviewCustomizationAIO;
        PhotoCommonBaseData<O> photoCommonBaseData;
        ArrayList<Integer> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && (cVar = this.D) != null && cVar.J != null && (photoPreviewCustomizationAIO = this.E) != null && (photoCommonBaseData = photoPreviewCustomizationAIO.f184334e) != 0 && ((arrayList = photoCommonBaseData.selectedIndex) == null || arrayList.isEmpty())) {
            this.D.J.performClick();
        }
        if (!TextUtils.isEmpty(str)) {
            d.b("0X800BEF9");
        }
        p(this.f184164d, this.D, true);
        this.f184167h = str;
        updateView();
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView.a
    public boolean b(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return i(motionEvent);
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView.a
    public boolean c(RectF rectF, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, rectF, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (m() && rectF.top < 0.0f && rectF.bottom < i16) {
            n();
        }
        return false;
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView.a
    public boolean d(float f16, float f17, int i3, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), motionEvent)).booleanValue();
        }
        if (m() && motionEvent != null && i3 == 1 && motionEvent.getPointerCount() == 1) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            float abs = Math.abs(x16 - f16);
            float abs2 = Math.abs(y16 - f17);
            QLog.i("PhotoPreviewAIOCommentEdit", 1, "onSignePhotoScrollCancel lastDownX=" + f16 + ",lastDownY=" + f17 + ",moveX=" + x16 + ",moveY=" + y16 + ",downAction=,upEvent=" + motionEvent.getAction());
            if (f17 > y16 && Math.abs(abs) < Math.abs(abs2) && abs2 > ViewUtils.dip2px(30.0f)) {
                n();
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView.a
    public boolean e(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return i(motionEvent);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (!k()) {
                return;
            }
            this.f184167h = null;
            updateView();
        }
    }

    public void g() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else if (l() && (bVar = this.F) != null) {
            bVar.e();
        }
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f184167h;
    }

    protected boolean i(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!m()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = motionEvent.getX();
            this.H = motionEvent.getY();
        } else if (actionMasked == 2) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            float abs = Math.abs(x16 - this.G);
            float abs2 = Math.abs(y16 - this.H);
            if (this.H > y16 && Math.abs(abs) < Math.abs(abs2) && abs2 > ViewUtils.dip2px(30.0f)) {
                n();
                return true;
            }
        }
        return false;
    }

    public void j(QBaseActivity qBaseActivity, com.tencent.mobileqq.activity.photo.album.preview.view.c cVar, PhotoPreviewCustomizationAIO photoPreviewCustomizationAIO) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, cVar, photoPreviewCustomizationAIO);
            return;
        }
        QLog.i("PhotoPreviewAIOCommentEdit", 1, "addViewToPreviewScene activity=" + qBaseActivity.toString() + ",scene=" + cVar.toString() + ",this=" + toString());
        if (!k()) {
            return;
        }
        this.D = cVar;
        this.f184164d = qBaseActivity;
        this.E = photoPreviewCustomizationAIO;
        View view = cVar.f184366i;
        if (view != null) {
            ETTextView eTTextView = (ETTextView) view.findViewById(R.id.k6h);
            this.f184168i = eTTextView;
            eTTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        }
        this.f184169m = cVar.D;
        this.C = cVar.E;
        this.f184165e.j(qBaseActivity, cVar);
        this.f184165e.h(this);
        cVar.brvTouchEventConsumer = this;
        cVar.bsvCustomLister = this;
        updateView();
        u(0);
    }

    protected boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f184166f;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        b bVar = this.F;
        if (bVar != null) {
            return bVar.i();
        }
        return false;
    }

    protected boolean m() {
        CheckBox checkBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!k() || this.f184165e.f() || (checkBox = this.f184169m) == null || checkBox.isChecked()) {
            return false;
        }
        return true;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.i("PhotoPreviewAIOCommentEdit", 1, "onUp");
        com.tencent.mobileqq.activity.photo.album.preview.view.c cVar = this.D;
        if (cVar != null) {
            cVar.h();
        }
        s();
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f184167h = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            s();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void p(QBaseActivity qBaseActivity, com.tencent.mobileqq.activity.photo.album.preview.view.c cVar, boolean z16) {
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, qBaseActivity, cVar, Boolean.valueOf(z16));
            return;
        }
        if (qBaseActivity != null && qBaseActivity.getWindow() != null && cVar != null) {
            View decorView = qBaseActivity.getWindow().getDecorView();
            if (decorView != null && (childAt = ((ViewGroup) decorView).getChildAt(0)) != null) {
                childAt.setFitsSystemWindows(z16);
                if (QLog.isColorLevel()) {
                    QLog.i("PhotoPreviewAIOCommentEdit", 2, "set decorView firstChild fitSystemWindow: " + z16);
                }
            }
            RelativeLayout relativeLayout = cVar.mRoot;
            if (relativeLayout != null) {
                relativeLayout.setFitsSystemWindows(z16);
                if (QLog.isColorLevel()) {
                    QLog.i("PhotoPreviewAIOCommentEdit", 2, "set scene.mRoot fitSystemWindow: " + z16);
                    return;
                }
                return;
            }
            return;
        }
        QLog.d("PhotoPreviewAIOCommentEdit", 1, "setFitSystemWindow err");
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f184166f = z16;
            this.f184165e.g(z16);
        }
    }

    public void r(boolean z16, BaseAdapter baseAdapter, View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), baseAdapter, view, view2);
            return;
        }
        if (k() && baseAdapter != null && view != null && view2 != null) {
            if (z16) {
                view2.setVisibility(0);
                view.setVisibility(0);
                baseAdapter.notifyDataSetChanged();
            } else {
                view2.setVisibility(8);
                view.setVisibility(8);
            }
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photo.album.preview.view.c cVar = this.D;
        if (cVar != null) {
            cVar.h();
        }
        if (this.F == null) {
            QBaseActivity qBaseActivity = this.f184164d;
            this.F = new b(qBaseActivity, qBaseActivity.getAppRuntime(), this);
        }
        p(this.f184164d, this.D, false);
        if (!l()) {
            this.F.j(this.f184167h);
            d.b("0X800BEF8");
        }
    }

    public void t(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else if (!TextUtils.isEmpty(this.f184167h)) {
            intent.putExtra(PeakConstants.SEND_COMMENT_CONTENT, this.f184167h);
            intent.putExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false);
        }
    }

    public void u(int i3) {
        PhotoPreviewCustomizationAIO photoPreviewCustomizationAIO;
        com.tencent.mobileqq.activity.photo.album.preview.view.c cVar;
        com.tencent.mobileqq.activity.photo.album.preview.presenter.c cVar2;
        com.tencent.mobileqq.activity.photo.album.preview.d dVar;
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (!k() || (photoPreviewCustomizationAIO = this.E) == null || (cVar = this.D) == null || cVar.L == null || (cVar2 = photoPreviewCustomizationAIO.f184337i) == null || (dVar = cVar2.f184343h) == null || dVar.f184327e) {
            return;
        }
        ArrayList<String> arrayList = dVar.f184324b;
        if (arrayList != null && arrayList.size() > 1) {
            qqStr = (i3 + 1) + " / " + dVar.f184324b.size();
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.d09);
        }
        QLog.i("PhotoPreviewAIOCommentEdit", 1, "updateTitle position=" + i3 + ",title=" + qqStr);
        this.D.L.setText(qqStr);
    }

    public void updateView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!k()) {
            return;
        }
        CheckBox checkBox = this.f184169m;
        if (checkBox != null && this.f184168i != null && this.C != null) {
            if (checkBox.isChecked()) {
                this.f184167h = null;
                this.f184168i.setVisibility(8);
                return;
            }
            if (TextUtils.isEmpty(this.f184167h)) {
                this.f184168i.setText("");
                this.f184168i.setVisibility(8);
                this.f184169m.setEnabled(true);
                this.f184169m.setClickable(true);
                this.C.setEnabled(true);
                this.C.setClickable(true);
                this.f184169m.setAlpha(1.0f);
                this.C.setAlpha(1.0f);
                return;
            }
            this.f184168i.setText(new QQText(this.f184167h, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP()));
            this.f184168i.setVisibility(0);
            this.f184168i.setOnClickListener(this);
            this.f184169m.setEnabled(false);
            this.f184169m.setClickable(false);
            this.C.setEnabled(false);
            this.C.setClickable(false);
            this.f184169m.setAlpha(0.3f);
            this.C.setAlpha(0.3f);
            return;
        }
        QLog.i("PhotoPreviewAIOCommentEdit", 1, "updateFlashView");
    }
}
