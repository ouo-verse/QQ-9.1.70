package com.tencent.mobileqq.gamecenter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.servlet.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class QQGamePadFaceFragment extends PublicBaseFragment implements ArkAppContainer.b {
    private PadFaceAd C;
    private ArkAppView D;
    private ArkAppContainer E;
    private QQAppInterface F;
    private PadFaceManager G;
    private e H;
    private boolean I;

    /* loaded from: classes12.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (!QQGamePadFaceFragment.this.I && i17 - i3 > 0 && i18 - i16 > 0) {
                QQGamePadFaceFragment.this.I = true;
                QQGamePadFaceFragment.this.wh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements ArkViewImplement.LoadCallback {
        b() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int i3, int i16, String str, boolean z16) {
            onLoadState(i3);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int i3) {
            if (QLog.isColorLevel() || i3 == -1) {
                QLog.d("QQGamePadFaceFragment", 2, "onLoadFinish, ret=", Integer.valueOf(i3), ", ", QQGamePadFaceFragment.this.C);
            }
            if (i3 == 1) {
                QQGamePadFaceFragment.this.G.s(QQGamePadFaceFragment.this.C.padFaceId);
            } else if (i3 == -1) {
                QQGamePadFaceFragment.this.G.s(QQGamePadFaceFragment.this.C.padFaceId);
                QQGamePadFaceFragment.this.vh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        getBaseActivity().finish();
        getBaseActivity().overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        int i3;
        int i16;
        PadFaceAd padFaceAd = this.C;
        if (padFaceAd == null) {
            return;
        }
        ArkAppContainer arkAppContainer = new ArkAppContainer();
        this.E = arkAppContainer;
        arkAppContainer.h(padFaceAd.appName, padFaceAd.appView, "", padFaceAd.appVersion, padFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
        boolean z16 = true;
        try {
            if (new JSONObject(padFaceAd.arkMeta).optInt("fullScreen", 1) == 0) {
                z16 = false;
            }
        } catch (JSONException e16) {
            QLog.d("QQGamePadFaceFragment", 2, e16, new Object[0]);
        }
        if (z16) {
            i3 = this.D.getWidth();
            i16 = this.D.getHeight();
        } else {
            i3 = -1;
            i16 = -1;
        }
        this.E.setFixSize(i3, i16);
        this.E.setMaxSize(i3, i16);
        this.E.setHintSize(i3, i16);
        this.E.setMinSize(i3, i16);
        this.E.j(i3, i16);
        this.E.a(this);
        this.D.setLoadCallback(new b());
        this.D.a(this.E, null);
        this.D.setVisibility(0);
        ArkAppView arkAppView = this.D;
        arkAppView.setOnTouchListener(arkAppView);
    }

    public static void xh(Activity activity, PadFaceAd padFaceAd) {
        Intent u16 = PadFaceManager.u(padFaceAd, null);
        u16.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.b.d(activity, u16, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
    public boolean Fb(ArkAppContainer arkAppContainer) {
        vh();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
    public boolean U1(ArkAppContainer arkAppContainer, String str, String str2) {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        ArkAppContainer arkAppContainer = this.E;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        vh();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.F = qQAppInterface;
        e eVar = (e) qQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        this.H = eVar;
        this.G = eVar.b();
        PadFaceAd p16 = PadFaceManager.p(getBaseActivity().getIntent());
        this.C = p16;
        if (p16 == null) {
            getBaseActivity().finish();
            return;
        }
        if (!p16.isValid()) {
            int i3 = this.C.redPointId;
            if (i3 > 0) {
                this.C = this.G.l(i3);
            }
            PadFaceAd padFaceAd = this.C;
            if (padFaceAd == null || !padFaceAd.isValid()) {
                getBaseActivity().finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArkAppView arkAppView = new ArkAppView(getBaseActivity(), null);
        this.D = arkAppView;
        arkAppView.setBorderType(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        relativeLayout.addView(this.D, layoutParams);
        viewGroup.addView(relativeLayout, -1, -1);
        this.D.addOnLayoutChangeListener(new a());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, null);
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            View decorView = getBaseActivity().getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt.getClass() == View.class && childAt.getVisibility() == 0) {
                        viewGroup.removeViewAt(i3);
                        return;
                    }
                }
            }
        }
    }
}
