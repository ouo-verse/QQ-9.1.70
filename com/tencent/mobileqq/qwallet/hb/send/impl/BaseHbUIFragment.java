package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseHbUIFragment extends BaseHbFragment {
    protected View K;
    protected Button L;
    protected TextView M;
    protected TextView N;
    protected TextView P;
    protected TextView Q;
    protected EditText R;
    protected EditText S;
    protected EditText T;
    protected View U;
    protected View V;
    protected View W;
    protected TextView X;
    protected HbInfo.a Y = new HbInfo.a();
    private boolean Z = true;

    /* renamed from: a0, reason: collision with root package name */
    protected TextWatcher f277644a0 = new b();

    /* renamed from: b0, reason: collision with root package name */
    protected TextWatcher f277645b0 = new c();

    /* renamed from: c0, reason: collision with root package name */
    protected TextWatcher f277646c0 = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends x05.b {
        a() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!BaseHbUIFragment.this.T.getText().toString().isEmpty() && BaseHbUIFragment.this.T.isFocused()) {
                BaseHbUIFragment.this.U.setVisibility(0);
                BaseHbUIFragment.this.W.setVisibility(8);
            } else {
                BaseHbUIFragment.this.U.setVisibility(8);
                BaseHbUIFragment.this.W.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends x05.b {
        b() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BaseHbUIFragment.this.Ah();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends x05.b {
        c() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z16;
            if (!BaseHbUIFragment.this.Z) {
                return;
            }
            String obj = BaseHbUIFragment.this.S.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            float i3 = x05.c.i(obj);
            int j3 = x05.c.j(BaseHbUIFragment.this.R.getText().toString().trim(), 0);
            if (x05.c.j(BaseHbUIFragment.this.Y.bus_type, 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !zk2.b.f452710a.k(i3)) {
                BaseHbUIFragment.this.Mh(true);
                return;
            }
            if (!z16 && j3 != 0 && !zk2.b.f452710a.k(i3 / j3)) {
                BaseHbUIFragment.this.Mh(true);
            } else if (!zk2.b.f452710a.i(i3)) {
                BaseHbUIFragment.this.Mh(true);
            } else {
                BaseHbUIFragment.this.Mh(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d extends x05.b {
        d() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!BaseHbUIFragment.this.Z) {
                return;
            }
            String obj = BaseHbUIFragment.this.R.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            if (!zk2.b.f452710a.m(x05.c.j(obj, 0))) {
                BaseHbUIFragment.this.Oh(true);
            } else {
                BaseHbUIFragment.this.Oh(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(View view, boolean z16) {
        if (!this.T.getText().toString().isEmpty() && this.T.isFocused()) {
            this.U.setVisibility(0);
            this.W.setVisibility(8);
        } else {
            this.U.setVisibility(8);
            this.W.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.T.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Kh(View view, MotionEvent motionEvent) {
        Fh();
        return false;
    }

    public boolean Ah() {
        String obj = this.R.getText().toString();
        float Bh = Bh();
        this.X.setText(new DecimalFormat(this.R.getResources().getString(R.string.f17939399)).format(Bh));
        if (x05.c.j(obj, 0) > 0 && Bh > 0.0f) {
            this.L.setEnabled(true);
            return true;
        }
        this.L.setEnabled(false);
        return false;
    }

    protected float Bh() {
        return x05.c.i(this.S.getText().toString());
    }

    protected abstract String Ch();

    public abstract int Dh();

    /* JADX INFO: Access modifiers changed from: protected */
    public String Eh() {
        return bl2.b.c(this.T);
    }

    protected void Fh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    protected void Gh() {
        EditText editText = this.T;
        if (editText != null && this.U != null && this.W != null) {
            editText.addTextChangedListener(new a());
            this.T.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.b
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    BaseHbUIFragment.this.Ih(view, z16);
                }
            });
            this.U.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseHbUIFragment.this.Jh(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void Hh(Bundle bundle) {
        HbInfo.c(bundle, this.Y);
        this.P = (TextView) this.K.findViewById(R.id.f167047md0);
        this.Q = (TextView) this.K.findViewById(R.id.f167048md1);
        EditText editText = (EditText) this.K.findViewById(R.id.f166442fc0);
        this.R = editText;
        editText.addTextChangedListener(new bl2.f(editText));
        this.R.addTextChangedListener(this.f277646c0);
        this.N = (TextView) this.K.findViewById(R.id.f167050md3);
        this.V = this.K.findViewById(R.id.yeh);
        this.M = (TextView) this.K.findViewById(R.id.mcz);
        EditText editText2 = (EditText) this.K.findViewById(R.id.f164306ro);
        this.S = editText2;
        editText2.addTextChangedListener(this.f277644a0);
        EditText editText3 = this.S;
        editText3.addTextChangedListener(new bl2.e(editText3));
        this.S.addTextChangedListener(this.f277645b0);
        this.X = (TextView) this.K.findViewById(R.id.f165664x71);
        Typeface createFromAsset = Typeface.createFromAsset(getQBaseActivity().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        this.X.setTypeface(createFromAsset);
        ((TextView) this.K.findViewById(R.id.f165663x70)).setTypeface(createFromAsset);
        this.L = (Button) this.K.findViewById(R.id.b7m);
        this.T = (EditText) this.K.findViewById(R.id.f166224ep1);
        this.U = this.K.findViewById(R.id.z2n);
        this.W = this.K.findViewById(R.id.z2o);
        Gh();
        if (QLog.isColorLevel()) {
            QLog.i("BaseHbUIFragment", 2, "bundleInfo: " + this.Y);
        }
        ScrollView scrollView = (ScrollView) this.K.findViewById(R.id.f66763bi);
        if (scrollView != null) {
            scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Kh;
                    Kh = BaseHbUIFragment.this.Kh(view, motionEvent);
                    return Kh;
                }
            });
        }
    }

    protected void Lh(@ColorInt int i3) {
        this.S.setTextColor(i3);
        this.N.setTextColor(i3);
        this.M.setTextColor(i3);
    }

    protected void Mh(boolean z16) {
        if (z16) {
            Lh(Color.parseColor("#FF5765"));
        } else {
            Lh(getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    protected void Nh(@ColorInt int i3) {
        this.R.setTextColor(i3);
        this.P.setTextColor(i3);
        this.Q.setTextColor(i3);
    }

    protected void Oh(boolean z16) {
        if (z16) {
            Nh(Color.parseColor("#FF5765"));
        } else {
            Nh(getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    protected void Ph() {
        QLog.i("BaseHbUIFragment", 2, "recv_type: " + this.Y.recv_type);
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
            this.R.addTextChangedListener(this.f277644a0);
            return;
        }
        if (HbInfo.f277195c.contains(this.Y.recv_type)) {
            this.R.setText("1");
            ((View) this.R.getParent()).setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.Y.people_num)) {
            TextView textView = (TextView) this.K.findViewById(R.id.f109926h5);
            textView.setText(HardCodeUtil.qqStr(R.string.jy_) + this.Y.people_num + HardCodeUtil.qqStr(R.string.jyb));
            textView.setVisibility(0);
        }
        this.R.addTextChangedListener(this.f277644a0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        if (this.T != null) {
            this.T.setHint(bl2.b.b(this.G, this.Y, Ch()));
        }
        Ph();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        QLog.i("BaseHbUIFragment", 2, "oncreate view enter...");
        this.K = layoutInflater.inflate(Dh(), (ViewGroup) null);
        Hh(getArguments());
        initData();
        View view = this.K;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        this.Z = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zh() {
        boolean z16;
        if (x05.c.f()) {
            return false;
        }
        String trim = this.S.getText().toString().trim();
        String trim2 = this.R.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            Mh(true);
            zk2.b.o("\u8bf7\u586b\u5199\u7ea2\u5305\u91d1\u989d");
            return false;
        }
        if (TextUtils.isEmpty(trim2)) {
            Oh(true);
            zk2.b.o("\u8bf7\u586b\u5199\u7ea2\u5305\u4e2a\u6570");
            return false;
        }
        int j3 = x05.c.j(trim2, 0);
        float i3 = x05.c.i(trim);
        zk2.b bVar = zk2.b.f452710a;
        if (!bVar.i(i3)) {
            Mh(true);
            return false;
        }
        if (!bVar.m(j3)) {
            Oh(true);
            return false;
        }
        if (x05.c.j(this.Y.bus_type, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 /= j3;
        }
        if (bVar.j(i3)) {
            return true;
        }
        Mh(true);
        return false;
    }
}
