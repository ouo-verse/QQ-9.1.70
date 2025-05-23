package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import javax.annotation.Nullable;

/* loaded from: classes16.dex */
public class ProfilePermissionSettingFragment extends IphoneTitleBarFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private static final int S;
    private static final int T;
    private Context C;
    private QQAppInterface D;
    private FormSimpleItem E;
    private FormSimpleItem F;
    private FormSwitchItem G;
    private FormSwitchItem H;
    private LinearLayout I;
    private LinearLayout J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    IFriendHandlerService P;
    private String Q;
    private final com.tencent.mobileqq.friend.observer.a R;

    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePermissionSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateFetchFriendPermission(boolean z16, HashMap<String, Integer> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            if (z16 && hashMap != null) {
                Integer num = hashMap.get(ProfilePermissionSettingFragment.this.Q);
                QLog.i("ProfileQZonePermissionSettingFragment", 1, "onUpdateFetchFriendPermission status is " + num);
                if (num != null) {
                    ProfilePermissionSettingFragment.this.yh(num.intValue());
                    return;
                }
                return;
            }
            QLog.d("ProfileQZonePermissionSettingFragment", 1, "onUpdateFriendQZonePermission| update permission is fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePermissionSettingFragment.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePermissionSettingFragment.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePermissionSettingFragment.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePermissionSettingFragment.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setSelected(true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            S = ViewUtils.dip2px(16.0f);
            T = ViewUtils.dip2px(12.0f);
        }
    }

    public ProfilePermissionSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.R = new a();
    }

    private int getStatus() {
        boolean z16 = this.L;
        boolean z17 = this.M;
        boolean z18 = this.N;
        if (z16) {
            return z16 ? 1 : 0;
        }
        return ((z17 ? 1 : 0) << 1) + ((z18 ? 1 : 0) << 2);
    }

    private void initData() {
        this.P = (IFriendHandlerService) this.D.getRuntimeService(IFriendHandlerService.class, "");
        if (getActivity().getIntent() != null) {
            this.Q = getActivity().getIntent().getStringExtra("uin");
        } else {
            onDestroy();
        }
        sh();
    }

    private void initUI() {
        setTitle(this.C.getString(R.string.f175502yq));
        this.J = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f239907x);
        this.E = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwm);
        this.F = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwk);
        this.G = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwj);
        this.H = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.xwl);
        this.I = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f68293fn);
        this.G.setOnCheckedChangeListener(this);
        this.H.setOnCheckedChangeListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
    }

    private void sh() {
        if (!NetworkUtil.isNetSupport(this.C)) {
            QQToastUtil.showQQToast(1, R.string.cjm);
        } else {
            this.P.getSingleFriendPermission(this.Q);
        }
    }

    private void th() {
        this.E.setRightIcon(null);
        vh(this.F);
        this.I.setVisibility(8);
        this.G.setChecked(true);
        this.H.setChecked(true);
        this.M = true;
        this.N = true;
        this.L = true;
        this.K = false;
    }

    private void uh() {
        if (!this.K) {
            this.F.setRightIcon(null);
            vh(this.E);
            this.L = false;
            this.M = false;
            this.N = false;
            this.G.setChecked(false);
            this.H.setChecked(false);
            this.I.setVisibility(0);
        }
        this.K = true;
    }

    private void vh(FormSimpleItem formSimpleItem) {
        formSimpleItem.setRightIcon(this.C.getDrawable(R.drawable.kws), S, T);
    }

    private void wh() {
        ViewCompat.setAccessibilityDelegate(this.F, new b());
        ViewCompat.setAccessibilityDelegate(this.E, new c());
    }

    private void xh() {
        ViewCompat.setAccessibilityDelegate(this.F, new d());
        ViewCompat.setAccessibilityDelegate(this.E, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.L = z16;
        if (((i3 >> 1) & 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.M = z17;
        if (((i3 >> 2) & 1) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.N = z18;
        this.K = !z16;
        this.J.setVisibility(0);
        if (this.L) {
            wh();
            vh(this.F);
            this.I.setVisibility(8);
        } else {
            xh();
            vh(this.E);
            this.G.setChecked(this.M);
            this.H.setChecked(this.N);
            this.I.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = getContext();
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.D = qQAppInterface;
        qQAppInterface.addObserver(this.R);
        initData();
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f168394fs3;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        ((IFriendHandlerService) this.D.getRuntimeService(IFriendHandlerService.class, "")).setFriendPermission(this.Q, getStatus());
        return super.onBackEvent();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.G.getSwitch()) {
            this.M = z16;
        } else if (compoundButton == this.H.getSwitch()) {
            this.N = z16;
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.xwm) {
                xh();
                uh();
            } else if (id5 == R.id.xwk) {
                wh();
                th();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            this.D.removeObserver(this.R);
        }
    }
}
