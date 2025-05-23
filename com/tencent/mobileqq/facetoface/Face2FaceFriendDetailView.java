package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class Face2FaceFriendDetailView extends Face2FaceDetailBaseView {
    static IPatchRedirector $redirector_;
    private String L;
    private HashMap<String, String> M;
    private Face2FaceAddFriendActivity N;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceFriendDetailView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Face2FaceFriendDetailView.this.l();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public Face2FaceFriendDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.L = null;
        this.M = null;
        this.N = null;
    }

    @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f205680d = findViewById(R.id.cnm);
        this.f205681e = findViewById(R.id.f165298com);
        this.f205685m = findViewById(R.id.cng);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View view = this.f205685m;
            view.setPadding(BaseAIOUtils.f(10.0f, view.getResources()), BaseAIOUtils.f(15.0f, this.f205685m.getResources()) + ImmersiveUtils.getStatusBarHeight(this.f205685m.getContext()), BaseAIOUtils.f(10.0f, this.f205685m.getResources()), BaseAIOUtils.f(15.0f, this.f205685m.getResources()));
        }
        this.f205685m.setOnClickListener(new a());
    }

    @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        b();
        return true;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b();
        this.M.put(this.L, ((EditText) findViewById(R.id.cnl)).getText().toString());
        ((InputMethodManager) this.N.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
        this.N.l4();
    }

    public void m(Face2FaceAddFriendActivity face2FaceAddFriendActivity, View view, Face2FaceFriendBubbleView face2FaceFriendBubbleView, String str, HashMap<String, String> hashMap, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, face2FaceAddFriendActivity, view, face2FaceFriendBubbleView, str, hashMap, onClickListener);
            return;
        }
        this.N = face2FaceAddFriendActivity;
        this.L = str;
        this.M = hashMap;
        this.f205680d.setOnClickListener(onClickListener);
        super.k(view, face2FaceFriendBubbleView);
    }
}
