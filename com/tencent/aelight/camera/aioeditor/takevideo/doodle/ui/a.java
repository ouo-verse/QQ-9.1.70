package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.v;
import com.tencent.aelight.camera.aioeditor.capture.text.w;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends EditTextDialog {

    /* renamed from: z0, reason: collision with root package name */
    private static final int f68131z0 = ViewUtils.dip2px(4.0f);

    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    protected void D0(int i3) {
        Iterator<Integer> it = com.tencent.aelight.camera.aioeditor.takevideo.a.f67929b.iterator();
        int i16 = 0;
        while (it.hasNext() && i3 != it.next().intValue()) {
            i16++;
        }
        this.H.c(com.tencent.aelight.camera.aioeditor.takevideo.a.f67929b, i16, true);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    protected void E0() {
        this.f68106t0.z();
        if (this.P != 1) {
            if (this.f68106t0.v() == 0) {
                DynamicTextItem dynamicTextItem = this.f68106t0;
                if (dynamicTextItem instanceof w) {
                    w wVar = (w) dynamicTextItem;
                    wVar.O(wVar.h(), true);
                    wVar.K(wVar.R());
                }
            }
            if (this.f68106t0.v() == 32) {
                DynamicTextItem dynamicTextItem2 = this.f68106t0;
                if (dynamicTextItem2 instanceof v) {
                    ((v) dynamicTextItem2).Y(f68131z0);
                }
            }
        }
        this.f68091e0.invalidate();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.d
    public void J(int i3) {
        DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean = new DynamicTextConfigManager.DynamicTextConfigBean();
        dynamicTextConfigBean.text_id = i3;
        F(dynamicTextConfigBean, -1);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    public void e0(boolean z16) {
        boolean z17;
        if (isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.i("EditTextDialog", 2, "dismiss isCancel:" + z16);
            }
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.C.getWindowToken(), 0);
            this.Q.c(false);
            this.Q.b(j0(), k0());
            this.f68091e0.setPreViewDrawer(null);
            int i3 = this.f68095i0;
            if (i3 == 0 && !(z17 = this.f68098l0)) {
                this.Q.a(this.f68106t0, false, i3, z17);
            } else {
                this.Q.a(this.f68106t0, !z16, i3, this.f68098l0);
            }
            this.f68098l0 = false;
            super.dismiss();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    protected int g0() {
        return R.layout.e6f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    public void s0(String str) {
        if (this.f68095i0 != 0 || this.f68098l0) {
            super.s0(str);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    protected void u0() {
        this.F.addTextChangedListener(new C0610a());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
    public void z0(DynamicTextItem dynamicTextItem, int i3) {
        super.z0(dynamicTextItem, i3);
        E0();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0610a implements TextWatcher {
        C0610a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            a aVar = a.this;
            if (aVar.Q == null || charSequence == null) {
                return;
            }
            aVar.f68098l0 = true;
            if (aVar.f68106t0 != null) {
                if (charSequence.length() > 0) {
                    a aVar2 = a.this;
                    aVar2.f68091e0.setText(aVar2.f68106t0.h(), charSequence.toString());
                } else {
                    a aVar3 = a.this;
                    aVar3.f68091e0.setText(aVar3.f68106t0.h(), (String) a.this.F.getHint());
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() > 120) {
                QQToast.makeText(a.this.getContext(), R.string.y8o, 0).show();
                String charSequence = editable.subSequence(0, 120).toString();
                a.this.F.setText(charSequence);
                a.this.F.setSelection(charSequence.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.d
    public void c(int i3, int i16) {
        if (i3 == 1) {
            this.Y.f443186b = i16;
            this.W = i16;
            DynamicTextItem dynamicTextItem = this.f68106t0;
            if (dynamicTextItem instanceof w) {
                w wVar = (w) dynamicTextItem;
                wVar.V(i16);
                wVar.K(i16);
                this.f68091e0.invalidate();
            }
        }
    }
}
