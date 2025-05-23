package com.qzone.album.business.albumlist.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QZoneQUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController;
import com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment;
import com.qzone.album.ui.widget.AlbumTimeLineView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.reborn.feedx.util.ae;
import com.qzone.util.P2VUtil;
import com.qzone.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.immersive.a;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.util.QUIProfileConstants;
import com.tencent.widget.AbsListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import s8.b;

/* loaded from: classes39.dex */
public class QZonePersonalAlbumActivity extends BaseActivity implements IObserver.main, AlbumBaseTabFragment.j {

    /* renamed from: f0, reason: collision with root package name */
    public static String f42065f0;

    /* renamed from: a0, reason: collision with root package name */
    public QzonePersonalAlbumViewController f42066a0;

    /* renamed from: b0, reason: collision with root package name */
    private Resources f42067b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private LayoutInflater f42068c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    protected ProgressBar f42069d0;

    /* renamed from: e0, reason: collision with root package name */
    long f42070e0;

    public QZonePersonalAlbumActivity() {
        if (a.g().booleanValue()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getClass());
        QUIImmersiveHelper.f(arrayList);
    }

    public static String Q2() {
        return f42065f0;
    }

    public static String R2() {
        if (!TextUtils.isEmpty(f42065f0)) {
            if (f42065f0.equals("getActiveFeeds")) {
                return QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM_PHOTO;
            }
            if (f42065f0.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                return QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM_PHOTO;
            }
            return QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM_PHOTO;
        }
        return "";
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public void A0(int i3, int i16, Intent intent) {
        onActivityResult(i3, i16, intent);
    }

    public final boolean S2() {
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController != null) {
            return qzonePersonalAlbumViewController.K1();
        }
        return false;
    }

    public Activity T2() {
        return getActivity();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public long U() {
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController == null) {
            return 0L;
        }
        return qzonePersonalAlbumViewController.e1();
    }

    public void U2(BaseAdapter baseAdapter) {
        notifyAdapter(baseAdapter);
    }

    public void V2() {
        showNoNetworkTips();
    }

    public void W2() {
        if (this.f42069d0 != null) {
            return;
        }
        this.f42069d0 = (ProgressBar) ((ViewStub) findViewById(R.id.ivTitleprogress)).inflate();
        y();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public boolean checkNetworkConnect() {
        return super.checkNetworkConnect();
    }

    protected boolean enableUseQUIProfileForQZone() {
        return ae.b();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (enableUseQUIProfileForQZone()) {
            if (this.f42067b0 == null) {
                this.f42067b0 = new QZoneQUIProfileResources(super.getResources(), this, "qzone");
                be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
            }
            return this.f42067b0;
        }
        return super.getResources();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if ((systemService instanceof LayoutInflater) && enableUseQUIProfileForQZone()) {
                if (this.f42068c0 == null) {
                    this.f42068c0 = new QUIProfileLayoutInflater((LayoutInflater) systemService, this, "qzone");
                    be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
                }
                return this.f42068c0;
            }
        }
        return super.getSystemService(str);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needCheckCreditLevel() {
        return this.f42070e0 == LoginData.getInstance().getUin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.f42066a0.R(this, i3, i16, intent);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f42066a0.O(this);
        this.f42066a0 = null;
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController != null) {
            qzonePersonalAlbumViewController.J(b.d(event));
        }
        if ("PageClose".equals(event.source.getName()) && event.what == 1 && !isFinishing()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        ArrayList<Fragment> arrayList;
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController == null || (arrayList = qzonePersonalAlbumViewController.V) == null) {
            return;
        }
        Fragment fragment = arrayList.get(qzonePersonalAlbumViewController.G);
        if (fragment instanceof AlbumBaseTabFragment) {
            ((AlbumBaseTabFragment) fragment).ii(s.c(QZoneResult.unpack(message)), message.what);
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        Pair<Boolean, Boolean> l26 = this.f42066a0.l2(this, i3, keyEvent);
        return ((Boolean) l26.first).booleanValue() ? super.onKeyDown(i3, keyEvent) : ((Boolean) l26.second).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController != null) {
            qzonePersonalAlbumViewController.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f42066a0.Q(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (QZoneUnreadServletLogic.o(LoginData.getInstance().getUin()) == 2) {
            e.a(getActivity(), true);
        }
        this.f42066a0.S(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f42066a0.T(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        this.f42066a0.m2(z16);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean shouldReportUsage() {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public void showNoNetworkTips() {
        super.showNoNetworkTips();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public final void t() {
        W2();
        ProgressBar progressBar = this.f42069d0;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public AlbumTimeLineView v1() {
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController == null) {
            j.c("recentPhotoTimeLine", "viewController == null");
            return null;
        }
        return qzonePersonalAlbumViewController.d1();
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public void x0(AbsListView absListView, int i3, int i16, int i17) {
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = this.f42066a0;
        if (qzonePersonalAlbumViewController == null) {
            j.c("recentPhotoTimeLine", "viewController == null");
        } else {
            qzonePersonalAlbumViewController.M2(i3, i16, i17);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public final void y() {
        ProgressBar progressBar = this.f42069d0;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle2 != null) {
                bundle2.remove("android:support:fragments");
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            disableFragmentRestore(bundle);
            bundle.remove("android:support:next_request_index");
            bundle.remove("android:support:request_indicies");
            bundle.remove("android:support:request_fragment_who");
            bundle.clear();
        }
        this.f42070e0 = getIntent().getLongExtra("key_album_owner_uin", 0L);
        super.onCreate(bundle);
        f42065f0 = getIntent().getStringExtra("refer");
        QzonePersonalAlbumViewController qzonePersonalAlbumViewController = new QzonePersonalAlbumViewController(this);
        this.f42066a0 = qzonePersonalAlbumViewController;
        qzonePersonalAlbumViewController.N(this);
        if (P2VUtil.d().g()) {
            P2VUtil.d().j(getActivity().getApplicationContext());
        }
        EventCenter.getInstance().addUIObserver(this, "PageClose", 1);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.f173580gi);
        com.tencent.mobileqq.theme.a.f(getWindow());
    }

    @Override // com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public Activity getHostActivity() {
        return this;
    }
}
