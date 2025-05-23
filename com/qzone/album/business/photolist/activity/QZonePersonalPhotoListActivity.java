package com.qzone.album.business.photolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.controller.MultipleModelController;
import com.qzone.album.business.photolist.controller.SingleModelController;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import com.qzone.album.business.photolist.controller.e;
import com.qzone.album.ui.widget.QzoneGestureSelectListView;
import com.qzone.album.util.m;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.utils.DownloadBoxForTitle;
import com.qzone.publish.utils.PublishBoxForTitle;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import p4.c;
import u4.h;

/* loaded from: classes39.dex */
public class QZonePersonalPhotoListActivity extends QZoneTitleBarActivity implements IObserver.main, h {
    public BasePhotoModelController K0;
    private c M0;
    private QzoneGestureSelectListView O0;
    private String P0;
    private RelativeLayout.LayoutParams Q0;
    private int R0;
    int L0 = -1;
    public boolean N0 = true;

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BasePhotoModelController basePhotoModelController = QZonePersonalPhotoListActivity.this.K0;
            if (basePhotoModelController != null) {
                basePhotoModelController.u0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void J3() {
        c cVar = this.M0;
        if (cVar == null || cVar.e() == null || this.M0.i() == null) {
            return;
        }
        this.M0.i().i(this.M0.e().e());
    }

    private void K3() {
        c cVar = this.M0;
        if (cVar == null || cVar.e() == null || this.M0.i() == null) {
            return;
        }
        PublishBoxForTitle i3 = this.M0.i();
        DownloadBoxForTitle e16 = this.M0.e();
        if (QZonePublishQueue.w().F()) {
            i3.j();
        } else if (QZonePublishQueue.w().A() != 0) {
            i3.k();
        }
        if (QZonePublishQueue.w().A() == 0) {
            if (DownloadQueue.j().m()) {
                e16.i();
            } else if (DownloadQueue.j().k() != 0) {
                e16.j();
            }
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public void A3(int i3) {
        BasePhotoModelController basePhotoModelController;
        super.A3(i3);
        if (this.f45407i0 == null || (basePhotoModelController = this.K0) == null || !(basePhotoModelController instanceof BasePhotoModelController)) {
            return;
        }
        if (basePhotoModelController.A1() == 9) {
            ViewGroup.LayoutParams layoutParams = this.f45407i0.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = ar.d(75.0f);
            this.f45407i0.setLayoutParams(layoutParams);
            this.f45407i0.setBackgroundDrawable(getResources().getDrawable(R.drawable.f162174fv1));
        }
        if (this.K0.A1() == 10) {
            super.A3(255);
        }
        int i16 = this.L0;
        if (i16 == 4 || i16 == 3) {
            super.A3(255);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b
    public ViewGroup B() {
        c cVar = this.M0;
        if (cVar != null) {
            return cVar.j();
        }
        return super.B();
    }

    @Override // u4.h
    public void E1(String str, String str2) {
        super.y3(str, str2);
    }

    public void F3(boolean z16, boolean z17) {
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 11, 8, 47, 50, 45, 7, 48);
        if (z16) {
            EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 3, 2, 6, 27, 30);
            return;
        }
        if (z17) {
            EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 1001, 3, 26, 27, 30);
            EventCenter.getInstance().addUIObserver(this, "Vip", 2);
            EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 4);
        } else {
            if (this.L0 == 4) {
                EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 29);
                EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 4);
                EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 5);
                EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 9);
                EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 30);
                return;
            }
            EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 3, 2, 5, 28, 7, 22, 23, 27, 30, 4);
            EventCenter.getInstance().addUIObserver(this, "Vip", 4);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.DownloadBoxForTitle.c
    public void Fe(boolean z16) {
        c cVar = this.M0;
        if (cVar == null) {
            return;
        }
        if (z16) {
            cVar.E();
        } else {
            cVar.p();
        }
    }

    public void G3() {
        EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 3, 21);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.DownloadBoxForTitle.c
    public ViewGroup G8() {
        c cVar = this.M0;
        if (cVar != null) {
            return cVar.d();
        }
        return super.G8();
    }

    public void H3() {
        EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 3, 2);
    }

    public void I3() {
        EventCenter.getInstance().addUIObserver(this, "QzoneAlbum", 20);
    }

    @Override // u4.h
    public void J() {
        if (Z2() == null || Z2().getBackground() == null || !(this.K0 instanceof ViewerModelController)) {
            return;
        }
        Z2().setAlpha(0.0f);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, u4.h
    public void J1() {
        ImageView k3;
        super.J1();
        com.qzone.album.env.common.a.m().c(this.TAG, "changeToSkinStyle");
        TextView textView = this.f45400b0;
        if (textView != null) {
            textView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = this.Q0;
            if (layoutParams != null) {
                layoutParams.addRule(0, R.id.dtb);
            }
        }
        K3();
        if (z2() != null && (k3 = z2().k()) != null && b.c() && SimpleUIUtil.useDarkResource()) {
            k3.setImageResource(R.drawable.hx7);
        }
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null && (basePhotoModelController instanceof ViewerModelController) && b.c() && SimpleUIUtil.useDarkResource()) {
            ((ViewerModelController) this.K0).S6();
        }
        BasePhotoModelController basePhotoModelController2 = this.K0;
        if (basePhotoModelController2 == null || !(basePhotoModelController2 instanceof ViewerModelController)) {
            return;
        }
        basePhotoModelController2.b1();
    }

    public void L3() {
        if (getActivity() == null) {
            return;
        }
        View findViewById = getActivity().findViewById(R.id.flp);
        int i3 = 1;
        if (findViewById == null) {
            QLog.i(this.TAG, 1, "reportDaTongRegister  titleRoot == null ");
            return;
        }
        VideoReport.setPageId(findViewById, "pg_qz_photo_list");
        HashMap hashMap = new HashMap();
        int i16 = this.R0;
        if (i16 == 5) {
            i3 = 3;
        } else if (i16 == 6) {
            i3 = 5;
        } else if (i16 == 8) {
            i3 = 4;
        } else if (i16 == 9) {
            i3 = 2;
        }
        hashMap.put("topic_type", Integer.valueOf(i3));
        VideoReport.setPageParams(findViewById, new fo.a().d(this.TAG, hashMap));
    }

    public void M3(View view) {
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.w0(view);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, u4.h
    public void P(int i3, View.OnClickListener onClickListener, boolean z16) {
        super.P(i3, onClickListener, z16);
    }

    public void P3(int i3) {
        ViewGroup viewGroup = this.B0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i3);
        }
    }

    @Override // u4.h
    public boolean X0() {
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            return basePhotoModelController.Z2();
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b
    public void b0(boolean z16) {
        c cVar = this.M0;
        if (cVar == null) {
            return;
        }
        if (z16) {
            cVar.q();
            this.M0.G();
        } else {
            cVar.r();
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.j
    public boolean checkNetworkConnect() {
        return super.checkNetworkConnect();
    }

    @Override // u4.h
    public void e1(int i3) {
        TextView textView = this.f45400b0;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public void e3() {
        this.f45413o0 = getResources().getColor(R.color.skin_bar_btn);
        this.f45414p0 = getResources().getColor(R.color.skin_bar_text);
        this.f45415q0 = getResources().getColor(R.color.skin_bar_btn);
        if (this.f45399a0 == null) {
            this.f45404f0 = (ViewGroup) findViewById(R.id.f166673ha1);
            this.B0 = (ViewGroup) findViewById(R.id.f166672ha0);
            this.f45407i0 = (ViewGroup) findViewById(R.id.h_w);
            ViewGroup viewGroup = this.B0;
            if (viewGroup != null) {
                viewGroup.post(new Runnable() { // from class: com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZonePersonalPhotoListActivity.this.w3();
                        ViewStub viewStub = (ViewStub) QZonePersonalPhotoListActivity.this.findViewById(R.id.ivTitleprogress);
                        ViewGroup.LayoutParams layoutParams = viewStub == null ? null : viewStub.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            QZonePersonalPhotoListActivity.this.Q0 = (RelativeLayout.LayoutParams) layoutParams;
                        } else {
                            QZLog.e(((BaseActivity) QZonePersonalPhotoListActivity.this).TAG, 1, "[initWithNoTitle] title process layout params is null.");
                        }
                    }
                });
            }
            QZoneTitleBarActivity.setLayerType(this.f45404f0);
            r3(this.f45404f0);
            u3(this.f45404f0);
            setLeftViewName(getIntent());
            onCreateCenterView();
            this.f45400b0.setMaxWidth(ar.d(150.0f));
            this.f45404f0.setOnClickListener(new a());
            View view = this.f45402d0;
            if (view != null) {
                view.setVisibility(8);
            }
            c cVar = new c(this.f45404f0);
            this.M0 = cVar;
            cVar.x();
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, u4.h
    public void g1() {
        ImageView k3;
        super.g1();
        com.qzone.album.env.common.a.m().c(this.TAG, "resetTitleBarStyle");
        TextView textView = this.f45400b0;
        if (textView != null) {
            textView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = this.Q0;
            if (layoutParams != null) {
                layoutParams.addRule(0, 0);
            }
        }
        K3();
        if (z2() != null && (k3 = z2().k()) != null) {
            k3.setImageResource(R.drawable.qzone_skin_album_photo_search);
        }
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null && (basePhotoModelController instanceof ViewerModelController)) {
            ((ViewerModelController) basePhotoModelController).J7();
        }
        BasePhotoModelController basePhotoModelController2 = this.K0;
        if (basePhotoModelController2 == null || !(basePhotoModelController2 instanceof ViewerModelController)) {
            return;
        }
        basePhotoModelController2.N3();
    }

    @Override // u4.h
    public QzoneGestureSelectListView getListView() {
        if (this.O0 == null) {
            this.O0 = (QzoneGestureSelectListView) findViewById(R.id.flq);
        }
        return this.O0;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public boolean h3() {
        return this.L0 == 0;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean i0() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean isEnableNightMask() {
        return !QZoneConfigHelper.O0();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    protected boolean l3() {
        return false;
    }

    @Override // u4.h
    public void m0(int i3) {
        if (Z2() == null || Z2().getBackground() == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        A3(i3);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, u4.h
    public void notifyAdapter(BaseAdapter baseAdapter) {
        super.notifyAdapter(baseAdapter);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.R(this, i3, i16, intent);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController == null || !basePhotoModelController.M(this)) {
            return super.onBackEvent();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean onBackPress() {
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController == null || !basePhotoModelController.M(this)) {
            return super.onBackPress();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        c cVar;
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.f158017al3);
        VideoReport.addToDetectionWhitelist(this);
        m.a();
        this.L0 = getIntent().getIntExtra("key_personal_album_enter_model", -1);
        this.P0 = getIntent().getStringExtra(PeakConstants.IS_FROM_XIAOWO);
        this.R0 = getIntent().getIntExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ANONYMITY, -1);
        int i3 = this.L0;
        if (i3 != 0) {
            if (i3 == 1) {
                this.K0 = new MultipleModelController(this, this);
            } else if (i3 == 2) {
                SingleModelController singleModelController = new SingleModelController(this, this);
                this.K0 = singleModelController;
                singleModelController.d5(this.P0);
            } else if (i3 != 3) {
                if (i3 != 4) {
                    QLog.e(this.TAG, 1, "onCreate wrong viewControllerType\uff01\uff01\uff01\uff01\uff01");
                    finish();
                    return;
                }
                this.K0 = new e(this, this);
            }
            this.K0.N(this);
            cVar = this.M0;
            if (cVar != null) {
                cVar.w(this, getTextTitle());
                this.M0.v(this, getTextTitle());
                this.M0.A();
                this.M0.z();
            }
            J3();
            EventCenter.getInstance().addUIObserver(this, "PageClose", 2);
        }
        this.K0 = new ViewerModelController(this, this);
        this.K0.N(this);
        cVar = this.M0;
        if (cVar != null) {
        }
        J3();
        EventCenter.getInstance().addUIObserver(this, "PageClose", 2);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    protected View onCreateCenterView() {
        super.onCreateCenterView();
        M3(this.f45404f0);
        return this.f45400b0;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m.b();
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.O(this);
        }
        u4.e.d().h();
        removeObserver();
        this.K0 = null;
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.J(s8.b.d(event));
        }
        if ("PageClose".equals(event.source.getName()) && event.what == 2 && !isFinishing()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (QZLog.isColorLevel()) {
            QZLog.d(this.TAG, 2, "Msg.what:" + message.what);
        }
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.K(s.c(unpack), message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.L(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.P(this);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.Q(this, bundle);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.S(this);
        }
        L3();
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.T(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.B3(this);
        }
    }

    public void removeObserver() {
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // u4.h
    public void setTitle(String str) {
        super.setTitle((CharSequence) str);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean shouldReportUsage() {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.A3();
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.A3();
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public TextView u() {
        return this.f45401c0;
    }

    @Override // u4.h
    public TextView v() {
        return this.f45400b0;
    }

    @Override // u4.h
    public TextView x() {
        return this.f45399a0;
    }

    @Override // u4.h
    public c z2() {
        return this.M0;
    }

    @Override // u4.h
    public void N1(s4.e eVar) {
        if (eVar != null) {
            U2(eVar);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b
    public int Sf() {
        return ar.e(36.0f);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.DownloadBoxForTitle.c
    public int bd() {
        return ar.e(34.0f);
    }

    @Override // u4.h
    public void i1(s4.e eVar) {
        if (eVar != null) {
            S2(eVar);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.f173580gi);
        com.tencent.mobileqq.theme.a.f(getWindow());
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.A3();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
        BasePhotoModelController basePhotoModelController = this.K0;
        if (basePhotoModelController != null) {
            basePhotoModelController.A3();
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b
    public void K4() {
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.publish.utils.PublishBoxForTitle.b
    public void Ng() {
    }
}
