package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class VerifyPwdView extends LinearLayout implements View.OnClickListener {
    private b C;
    private ImageView D;
    View E;
    private FMObserver F;

    /* renamed from: d, reason: collision with root package name */
    private BaseFileAssistantActivity f206407d;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f206408e;

    /* renamed from: f, reason: collision with root package name */
    private View f206409f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f206410h;

    /* renamed from: i, reason: collision with root package name */
    private Button f206411i;

    /* renamed from: m, reason: collision with root package name */
    private ProgressBar f206412m;

    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void K0(int i3, String str) {
            d.f(str);
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void L0() {
            VerifyPwdView.this.f();
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void f0(int i3, String str) {
            d.f(str);
            VerifyPwdView.this.h();
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void g0(boolean z16) {
            if (!z16) {
                VerifyPwdView.this.f();
            } else {
                VerifyPwdView.this.j();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void onSuccess();
    }

    public VerifyPwdView(Context context) {
        super(context);
        this.C = null;
        this.E = null;
        this.F = new a();
        BaseFileAssistantActivity baseFileAssistantActivity = (BaseFileAssistantActivity) context;
        this.f206407d = baseFileAssistantActivity;
        this.f206408e = baseFileAssistantActivity.D0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        b bVar = this.C;
        if (bVar != null) {
            bVar.onSuccess();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f206407d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f206412m.setVisibility(8);
    }

    private void i() {
        this.f206409f.setVisibility(8);
        this.f206412m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f206409f.setVisibility(0);
        this.f206412m.setVisibility(8);
    }

    public void d() {
        if (this.F != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.F);
            this.C = null;
        }
    }

    public View e(ViewGroup viewGroup, b bVar) {
        this.C = bVar;
        View findViewById = ((LayoutInflater) this.f206407d.getSystemService("layout_inflater")).inflate(R.layout.amx, (ViewGroup) null).findViewById(R.id.knp);
        this.E = findViewById;
        return findViewById;
    }

    public void g() {
        View findViewById = this.E.findViewById(R.id.imz);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f206409f = this.E.findViewById(R.id.kns);
        this.f206412m = (ProgressBar) this.E.findViewById(R.id.i5n);
        this.f206410h = (TextView) this.E.findViewById(R.id.f166560g63);
        Button button = (Button) this.E.findViewById(R.id.knq);
        this.f206411i = button;
        button.setOnClickListener(this);
        this.D = (ImageView) this.E.findViewById(R.id.l2s);
        if (ThemeUtil.isNowThemeIsNight(this.f206408e, false, null)) {
            this.D.setImageResource(R.drawable.f161616a94);
        } else {
            this.D.setImageResource(R.drawable.f161615a93);
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.F);
        IQQFileEngine iQQFileEngine = (IQQFileEngine) ((BaseQQAppInterface) this.f206408e).getRuntimeService(IQQFileEngine.class);
        if (iQQFileEngine.hasQueriedVerifyPassword()) {
            iQQFileEngine.queryNeedVerifyPwd();
        } else if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            i();
            iQQFileEngine.queryNeedVerifyPwd();
        } else {
            d.e(R.string.f187123t5);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String charSequence = this.f206410h.getText().toString();
        if (charSequence != null && !charSequence.equals("")) {
            ((IQQFileEngine) ((BaseQQAppInterface) this.f206408e).getRuntimeService(IQQFileEngine.class)).verifyPwd(charSequence);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
