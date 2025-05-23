package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcshopWebActivity extends QQBrowserActivity implements SwipListView.RightIconMenuListener {

    /* renamed from: a0, reason: collision with root package name */
    ViewGroup f79597a0;

    /* renamed from: b0, reason: collision with root package name */
    public List<RecentShopParcel> f79598b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f79599c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f79600d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f79601e0;

    /* renamed from: g0, reason: collision with root package name */
    public long f79603g0;

    /* renamed from: h0, reason: collision with root package name */
    boolean f79604h0;

    /* renamed from: i0, reason: collision with root package name */
    long f79605i0;

    /* renamed from: f0, reason: collision with root package name */
    boolean f79602f0 = false;

    /* renamed from: j0, reason: collision with root package name */
    Map<Rect, Boolean> f79606j0 = new HashMap();

    /* renamed from: k0, reason: collision with root package name */
    private long f79607k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    boolean f79608l0 = false;

    public EcshopWebActivity() {
        this.mFragmentClass = ShopWebViewFragment.class;
    }

    private boolean H2(int i3, int i16) {
        for (Map.Entry<Rect, Boolean> entry : this.f79606j0.entrySet()) {
            boolean booleanValue = entry.getValue().booleanValue();
            if (entry.getKey().contains(i3, i16)) {
                return booleanValue;
            }
        }
        return false;
    }

    public void G2(Rect rect, boolean z16) {
        if (rect != null) {
            if (z16 && this.f79606j0.containsKey(rect)) {
                this.f79606j0.remove(rect);
            }
            Iterator<Map.Entry<Rect, Boolean>> it = this.f79606j0.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Rect key = it.next().getKey();
                if (key.left == rect.left && key.top == rect.top) {
                    this.f79606j0.remove(key);
                    break;
                }
            }
            this.f79606j0.put(rect, Boolean.valueOf(z16));
        }
    }

    public void I2(String str) {
        List<RecentShopParcel> list;
        if (!TextUtils.isEmpty(str) && (list = this.f79598b0) != null && !list.isEmpty()) {
            Intent intent = new Intent("action_shop_set_read");
            intent.putExtra("uin", str);
            intent.putExtra("needDelete", false);
            sendBroadcast(intent);
            for (RecentShopParcel recentShopParcel : this.f79598b0) {
                if (str.equals(recentShopParcel.f79609d)) {
                    recentShopParcel.C = 0;
                }
            }
        }
    }

    void J2(Bundle bundle) {
        this.f79598b0 = bundle.getParcelableArrayList("datas");
        this.f79599c0 = bundle.getString("ad_logo");
        this.f79600d0 = bundle.getString("ad_jump");
        this.f79601e0 = bundle.getLong("ad_id", 0L);
        this.f79603g0 = bundle.getLong("latest_time", 0L);
        this.f79602f0 = bundle.getBoolean(TabDataHelper.SCENE_IS_TAB_SHOW, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r0 != 3) goto L34;
     */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        int action = motionEvent.getAction();
        if (this.f79597a0 == null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.l2a);
            this.f79597a0 = viewGroup;
            if (viewGroup == null) {
                this.f79597a0 = (ViewGroup) findViewById(R.id.b9v);
            }
            if (this.f79597a0 == null) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
                return dispatchTouchEvent;
            }
        }
        View findViewById = findViewById(R.id.rlCommenTitle);
        if (findViewById == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        } else {
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.f79608l0) {
                            this.f79597a0.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                this.f79608l0 = false;
            } else if (!this.f79602f0 && !this.f79604h0) {
                this.f79608l0 = false;
            } else if (this.f79604h0 || !H2((int) motionEvent.getX(), ((int) motionEvent.getY()) - findViewById.getBottom())) {
                this.f79608l0 = true;
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        Intent intent = new Intent("action_folder_destroy");
        intent.putExtra("stay_time", System.currentTimeMillis() - this.f79605i0);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        QQAppInterface qQAppInterface;
        super.doOnPause();
        Intent intent = new Intent("action_folder_set_read");
        if (!this.f79598b0.isEmpty()) {
            intent.putExtra("uin", this.f79598b0.get(0).f79609d);
        }
        sendBroadcast(intent);
        if (getAppRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) getAppRuntime();
        } else {
            qQAppInterface = null;
        }
        PublicAccountEventReport.p(qQAppInterface, "9970", 1, 4, System.currentTimeMillis() - this.f79607k0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        super.doOnRestoreInstanceState(bundle);
        Bundle bundle2 = bundle.getBundle("bundle");
        J2(bundle2);
        getIntent().putExtra("bundle", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.f79607k0 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        super.doOnSaveInstanceState(bundle);
        bundle.putBundle("bundle", getIntent().getBundleExtra("bundle"));
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            getIntent().putExtras(bundle);
        }
        super.onCreate(bundle);
        J2(getIntent().getBundleExtra("bundle"));
        this.f79605i0 = System.currentTimeMillis();
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuHide(View view) {
        this.f79604h0 = false;
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuShow(View view) {
        this.f79604h0 = true;
    }
}
