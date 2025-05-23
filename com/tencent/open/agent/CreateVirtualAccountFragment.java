package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ap;
import com.tencent.mobileqq.config.business.aq;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_OPENSDK_AUTH, scene = QQPermissionConstants.Business.SCENE.OPENSDK_CREATE_VIRTUAL_ACCOUNT)
/* loaded from: classes22.dex */
public class CreateVirtualAccountFragment extends QPublicBaseFragment implements View.OnClickListener, TextWatcher, ep3.m {
    private View D;
    private View E;
    private View F;
    private URLImageView G;
    private EditText H;
    private View I;
    private QQProgressDialog J;
    private Uri M;
    private String Q;
    private List<ap.b> R;
    private boolean U;
    private ep3.l V;
    private QQPermission W;
    private final String C = "CreateVirtualAccountFragment";
    private final int K = 1000;
    private long L = 0;
    private final int N = 11;
    private final String P = "1001_0cab6b944b59d75644e53b70de2f5d5a";
    private long S = 0;
    private int T = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements InputFilter {
        a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int length = 12 - (spanned.length() - (i18 - i17));
            if (length <= 0) {
                AuthUIUtil.l(CreateVirtualAccountFragment.this.getActivity(), "\u6635\u79f0\u6700\u591a\u53ef\u8f93\u516512\u4e2a\u5b57", false);
                return "";
            }
            if (length >= i16 - i3) {
                return null;
            }
            int i19 = length + i3;
            if (Character.isHighSurrogate(charSequence.charAt(i19 - 1)) && i19 - 1 == i3) {
                AuthUIUtil.l(CreateVirtualAccountFragment.this.getActivity(), "\u6635\u79f0\u6700\u591a\u53ef\u8f93\u516512\u4e2a\u5b57", false);
                return "";
            }
            AuthUIUtil.l(CreateVirtualAccountFragment.this.getActivity(), "\u6635\u79f0\u6700\u591a\u53ef\u8f93\u516512\u4e2a\u5b57", false);
            return charSequence.subSequence(i3, i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f339777d;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                CreateVirtualAccountFragment createVirtualAccountFragment = CreateVirtualAccountFragment.this;
                createVirtualAccountFragment.M = com.tencent.open.agent.util.p.e(createVirtualAccountFragment.getActivity());
            }
        }

        b(ActionSheet actionSheet) {
            this.f339777d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                boolean z16 = true;
                if (i3 == 1) {
                    if (CreateVirtualAccountFragment.this.W == null) {
                        CreateVirtualAccountFragment createVirtualAccountFragment = CreateVirtualAccountFragment.this;
                        createVirtualAccountFragment.W = QQPermissionFactory.getQQPermission(createVirtualAccountFragment);
                    }
                    if (CreateVirtualAccountFragment.this.W != null) {
                        if (CreateVirtualAccountFragment.this.W.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
                            z16 = false;
                        }
                        if (z16) {
                            CreateVirtualAccountFragment.this.W.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
                        } else {
                            CreateVirtualAccountFragment createVirtualAccountFragment2 = CreateVirtualAccountFragment.this;
                            createVirtualAccountFragment2.M = com.tencent.open.agent.util.p.e(createVirtualAccountFragment2.getActivity());
                        }
                    } else {
                        t.e("CreateVirtualAccountFragment", "click camera QQPermission is null");
                    }
                }
            } else {
                com.tencent.open.agent.util.p.o(CreateVirtualAccountFragment.this.getActivity());
            }
            try {
                this.f339777d.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void Ah(URLImageView uRLImageView, String str) {
        Drawable drawable;
        if (uRLImageView == null) {
            return;
        }
        try {
            drawable = getResources().getDrawable(R.drawable.f160830com);
        } catch (OutOfMemoryError e16) {
            t.d("CreateVirtualAccountFragment", "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2 == null) {
            return;
        }
        drawable2.setDecodeHandler(com.tencent.open.agent.util.p.j());
        if (drawable2.getStatus() == 2) {
            t.b("CreateVirtualAccountFragment", "setVirtualIcon restartDownload");
            drawable2.restartDownload();
        } else {
            t.b("CreateVirtualAccountFragment", "setVirtualIcon success");
            uRLImageView.setImageDrawable(drawable2);
        }
    }

    private void Ch() {
        t.b("CreateVirtualAccountFragment", "uploadAvatar localPath = " + this.Q);
        final String valueOf = String.valueOf(this.S);
        com.tencent.open.model.a b16 = hp3.b.e().b(valueOf);
        if (!TextUtils.isEmpty(this.Q) && b16 != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.CreateVirtualAccountFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    String c16 = com.tencent.open.agent.util.p.c(CreateVirtualAccountFragment.this.Q);
                    t.b("CreateVirtualAccountFragment", "uploadAvatar appId=", valueOf);
                    CreateVirtualAccountFragment.this.V.c(valueOf, CreateVirtualAccountFragment.this.Q, com.tencent.open.agent.util.p.m(), c16);
                }
            });
        } else {
            t.b("CreateVirtualAccountFragment", "uploadAvatar params error");
            pe(false, this.Q, null, -1);
        }
    }

    private void showLoading() {
        this.J = AuthUIUtil.k(getActivity(), this.J, R.layout.b17);
    }

    private String uh(String str) {
        for (ap.b bVar : this.R) {
            if (TextUtils.equals(bVar.f202521c, str)) {
                return bVar.f202520b;
            }
        }
        return "";
    }

    private boolean vh(String str) {
        List<ap.b> list = this.R;
        if (list == null) {
            return false;
        }
        Iterator<ap.b> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f202521c, str)) {
                return true;
            }
        }
        return false;
    }

    private void wh(Activity activity, int i3) {
        if (i3 == 151) {
            AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213545qh), false);
            Intent intent = new Intent();
            intent.putExtra("createVirtualAccount", 2);
            activity.setResult(101, intent);
            activity.finish();
            return;
        }
        if (i3 == 10670) {
            AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213585ql), false);
            return;
        }
        if (i3 == 10710) {
            AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213595qm), false);
            return;
        }
        AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.l57) + i3, false);
    }

    private void xh(Activity activity, long j3) {
        AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f171818l55), true);
        Intent intent = new Intent();
        intent.putExtra("createVirtualAccount", 1);
        intent.putExtra("createVirtualVid", j3);
        activity.setResult(101, intent);
        activity.finish();
    }

    private void yh() {
        Editable text = this.H.getText();
        t.b("CreateVirtualAccountFragment", "onSaveBtnClick name=", text, ", mCurrentIconLocalPath=", this.Q);
        if (System.currentTimeMillis() - this.L <= 1000) {
            t.b("CreateVirtualAccountFragment", "onSaveBtnClick repeat click");
            return;
        }
        this.L = System.currentTimeMillis();
        if (TextUtils.isEmpty(text)) {
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l56), false);
            return;
        }
        hideSoftInput();
        showLoading();
        String obj = text.toString();
        if (TextUtils.isEmpty(this.Q)) {
            this.V.b(this.S, obj, "1001_0cab6b944b59d75644e53b70de2f5d5a", com.tencent.open.agent.util.p.m());
        } else if (vh(this.Q)) {
            this.V.b(this.S, obj, uh(this.Q), com.tencent.open.agent.util.p.m());
        } else {
            Ch();
        }
    }

    private void zh() {
        List<ap.b> list = this.R;
        if (list != null && list.size() != 0) {
            ap.b bVar = this.R.get(this.T % this.R.size());
            if (bVar == null) {
                t.b("CreateVirtualAccountFragment", " current randomInfo is null");
                return;
            }
            this.H.setText(bVar.f202519a);
            if (!TextUtils.isEmpty(bVar.f202521c)) {
                String str = bVar.f202521c;
                this.Q = str;
                Ah(this.G, str);
            }
            this.T++;
            return;
        }
        AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l59), false);
        t.b("CreateVirtualAccountFragment", "randomInfo config is null");
    }

    public void Bh() {
        if (getActivity() == null) {
            t.e("CreateVirtualAccountFragment", "showSoftInput activity is null");
            return;
        }
        EditText editText = this.H;
        if (editText == null) {
            return;
        }
        editText.setFocusable(true);
        this.H.setFocusableInTouchMode(true);
        this.H.setCursorVisible(true);
        this.H.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getQBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.showSoftInput(this.H, 0);
        t.b("CreateVirtualAccountFragment", "showSoftInput, ", this.H.getWindowToken());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.E.setEnabled(!TextUtils.isEmpty(editable));
    }

    @Override // ep3.m
    public void df(boolean z16, long j3, int i3) {
        t.b("CreateVirtualAccountFragment", "onCreateVirtual success=", Boolean.valueOf(z16), ", virtualId=", j3 + ", code=", Integer.valueOf(i3));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            t.e("CreateVirtualAccountFragment", "onCreateVirtual activity is null");
            return;
        }
        AuthUIUtil.c(activity, this.J);
        if (z16) {
            xh(activity, j3);
        } else {
            wh(activity, i3);
        }
    }

    public void hideSoftInput() {
        if (getActivity() == null) {
            t.e("CreateVirtualAccountFragment", "hideSoftInput activity is null");
            return;
        }
        EditText editText = this.H;
        if (editText == null) {
            return;
        }
        editText.clearFocus();
        this.H.setCursorVisible(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getQBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.H.getWindowToken(), 0);
        t.b("CreateVirtualAccountFragment", "hideSoftInput, ", this.H.getWindowToken());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        t.b("CreateVirtualAccountFragment", "onActivityResult resultCode=", Integer.valueOf(i16));
        AuthUIUtil.c(getActivity(), this.J);
        if (i16 != -1) {
            return;
        }
        com.tencent.open.agent.util.p.n(i3, getQBaseActivity(), this.M);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.E) {
            yh();
        } else if (view == this.F) {
            hideSoftInput();
            zh();
        } else if (view == this.D) {
            showActionSheet();
        } else if (view == this.I) {
            if (getActivity() != null) {
                getActivity().finish();
            }
            onBackEvent();
        } else if (view == this.H) {
            Bh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ep3.a.e(this);
        View inflate = layoutInflater.inflate(R.layout.f168463wu, viewGroup, false);
        this.I = inflate.findViewById(R.id.a47);
        this.D = inflate.findViewById(R.id.d_b);
        this.F = inflate.findViewById(R.id.hv5);
        this.E = inflate.findViewById(R.id.f166821ig2);
        this.G = (URLImageView) inflate.findViewById(R.id.kzc);
        EditText editText = (EditText) inflate.findViewById(R.id.kzg);
        this.H = editText;
        editText.addTextChangedListener(this);
        ((ImmersiveTitleBar2) inflate.findViewById(R.id.jq6)).setBackgroundColor(0);
        this.I.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        ap a16 = aq.a();
        if (a16.a() != null) {
            ArrayList<ap.b> arrayList = a16.a().f202518a;
            this.R = arrayList;
            if (arrayList != null && arrayList.size() > 0) {
                this.T = Math.abs(new Random().nextInt(this.R.size()));
            }
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), 0, R.layout.b17, 17);
        this.J = qQProgressDialog;
        qQProgressDialog.setHeightParams(-1);
        long c16 = com.tencent.open.agent.util.o.c(com.tencent.open.agent.util.c.k(getActivity(), "appid"));
        this.S = c16;
        t.b("CreateVirtualAccountFragment", "onCreateView appId=", Long.valueOf(c16), ", mRandIndex=", Integer.valueOf(this.T));
        this.H.setFilters(new InputFilter[]{new a()});
        this.H.postDelayed(new Runnable() { // from class: com.tencent.open.agent.CreateVirtualAccountFragment.2
            @Override // java.lang.Runnable
            public void run() {
                CreateVirtualAccountFragment.this.Bh();
            }
        }, 300L);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        t.b("CreateVirtualAccountFragment", "doOnNewIntent====");
        super.onNewIntent(intent);
        AuthUIUtil.c(getActivity(), this.J);
        this.V.a(com.tencent.open.agent.util.p.k(intent), this.G.getWidth(), this.G.getHeight());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        StringBuilder sb5 = new StringBuilder();
        String str = Build.MANUFACTURER;
        sb5.append(str);
        sb5.append(DeviceInfoMonitor.getModel());
        String sb6 = sb5.toString();
        t.f("CreateVirtualAccountFragment", "MANUFACTURER = " + str + ", MODEL = " + DeviceInfoMonitor.getModel());
        if (!"MeizuPRO 7-S".equals(sb6) && !"MeizuM711C".equalsIgnoreCase(sb6)) {
            ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
        } else {
            ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
        }
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        if (this.U) {
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) getActivity(), true, getResources().getColor(R.color.f158017al3));
            systemBarCompact.setStatusBarColor(getResources().getColor(R.color.f158017al3));
            systemBarCompact.init();
        }
        this.U = true;
    }

    @Override // ep3.m
    public void pe(boolean z16, String str, String str2, int i3) {
        t.b("CreateVirtualAccountFragment", "onUploadAvatar success=", Boolean.valueOf(z16), ", filePath=", str, ", headId=" + str2, ", code=", Integer.valueOf(i3));
        if (getActivity() == null) {
            t.e("CreateVirtualAccountFragment", "onUploadAvatar activity is null");
            return;
        }
        AuthUIUtil.c(getActivity(), this.J);
        if (!z16) {
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l5_) + i3, false);
            return;
        }
        Editable text = this.H.getText();
        if (TextUtils.isEmpty(text)) {
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l58), false);
        } else {
            showLoading();
            this.V.b(this.S, text.toString(), str2, com.tencent.open.agent.util.p.m());
        }
    }

    @Override // ep3.m
    public void s3(Bitmap bitmap, String str) {
        this.G.setImageBitmap(bitmap);
        this.Q = str;
    }

    public void showActionSheet() {
        ActionSheet b16 = AuthUIUtil.b(getActivity(), null);
        com.tencent.open.agent.util.p.b(b16);
        b16.setOnButtonClickListener(new b(b16));
        try {
            if (!getActivity().isFinishing()) {
                b16.show();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // ep3.m
    public void tf(ep3.l lVar) {
        this.V = lVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
