package com.qzone.album.business.albumlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import com.tencent.mobileqq.R;
import i4.a;
import s8.b;

/* loaded from: classes39.dex */
public class QzonePhotoCategoryDetailsActivity extends QZoneTitleBarActivity implements IObserver.main {
    public a K0;

    public ImageView C3() {
        return this.f45403e0;
    }

    public boolean D3() {
        return checkNetworkConnect();
    }

    public void E3() {
        showNoNetworkTips();
    }

    public void F3(View.OnClickListener onClickListener) {
        View view = this.f45402d0;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void G3(int i3) {
        ImageView imageView = this.f45403e0;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.K0.R(this, i3, i16, intent);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (this.K0.M(this)) {
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean onBackPress() {
        if (this.K0.M(this)) {
            return true;
        }
        return super.onBackPress();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PhotoCategoryDetailsController photoCategoryDetailsController = new PhotoCategoryDetailsController(this);
        this.K0 = photoCategoryDetailsController;
        photoCategoryDetailsController.N(this);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.K0.O(this);
        this.K0 = null;
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        a aVar = this.K0;
        if (aVar != null) {
            aVar.J(b.d(event));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (this.K0 != null) {
            this.K0.K(s.c(QZoneResult.unpack(message)), message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        a aVar = this.K0;
        if (aVar != null) {
            aVar.L(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.K0.S(this);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public void t3() {
        super.t3();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public TextView u() {
        return this.f45401c0;
    }

    public TextView x() {
        return this.f45399a0;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.f173580gi);
        com.tencent.mobileqq.theme.a.f(getWindow());
    }
}
