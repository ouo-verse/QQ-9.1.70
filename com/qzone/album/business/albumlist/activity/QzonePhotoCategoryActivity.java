package com.qzone.album.business.albumlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.albumlist.controller.PhotoCategoryController;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import i4.a;
import s8.b;

/* loaded from: classes39.dex */
public class QzonePhotoCategoryActivity extends QZoneTitleBarActivity implements IObserver.main {
    public a K0;

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
        PhotoCategoryController photoCategoryController = new PhotoCategoryController(this);
        this.K0 = photoCategoryController;
        photoCategoryController.N(this);
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
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.K0.S(this);
    }

    public TextView x() {
        return this.f45399a0;
    }
}
