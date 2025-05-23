package com.tencent.luggage.wxa.ga;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f126663a;

    @Override // android.app.Activity
    public void finish() {
        com.tencent.luggage.wxa.fa.a.a().a(this);
        super.finish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i3) {
        com.tencent.luggage.wxa.fa.a.a().a(this);
        super.finishActivity(i3);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i3) {
        com.tencent.luggage.wxa.fa.a.a().a(activity);
        super.finishActivityFromChild(activity, i3);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        com.tencent.luggage.wxa.fa.a.a().a(this);
        super.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        com.tencent.luggage.wxa.fa.a.a().a(this);
        super.finishAndRemoveTask();
    }

    public Object getHellTag(int i3) {
        SparseArray sparseArray = this.f126663a;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z16) {
        com.tencent.luggage.wxa.fa.a.a().c(this, z16);
        return super.moveTaskToBack(z16);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.luggage.wxa.fa.a.a().a(this, 0);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.tencent.luggage.wxa.fa.a.a().a(this, 5);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.tencent.luggage.wxa.fa.a.a().a(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.tencent.luggage.wxa.fa.a.a().a(this, 3);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        com.tencent.luggage.wxa.fa.a.a().a(this, 6);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.tencent.luggage.wxa.fa.a.a().a(this, 2);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.tencent.luggage.wxa.fa.a.a().a(this, 4);
    }

    public void setHellTag(int i3, Object obj) {
        if (this.f126663a == null) {
            this.f126663a = new SparseArray(2);
        }
        this.f126663a.put(i3, obj);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        com.tencent.luggage.wxa.fa.a.a().a(this, intentArr);
        super.startActivities(intentArr, bundle);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        com.tencent.luggage.wxa.fa.a.a().b(this, intent);
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        com.tencent.luggage.wxa.fa.a.a().b(this, intent);
        super.startActivityFromFragment(fragment, intent, i3, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i3, Bundle bundle) {
        com.tencent.luggage.wxa.fa.a.a().b(this, intent);
        return super.startActivityIfNeeded(intent, i3, bundle);
    }
}
