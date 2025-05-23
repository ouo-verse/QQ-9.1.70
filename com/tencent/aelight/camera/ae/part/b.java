package com.tencent.aelight.camera.ae.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b {
    private static final String TAG = "VideoStoryBasePart";
    private volatile boolean hasInflated = false;
    protected Activity mActivity;
    protected c mPartManager;
    protected View mRootView;
    private ViewStub stub;

    @Deprecated
    public b(Activity activity, View view, c cVar) {
        this.mActivity = activity;
        this.mRootView = view;
        this.mPartManager = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ensureInflate() {
        ViewStub viewStub;
        if (!this.hasInflated && (viewStub = this.stub) != null) {
            View inflate = viewStub.inflate();
            this.hasInflated = true;
            initAfterInflation(inflate);
        } else {
            ms.a.a(TAG, "hasInflated: " + this.hasInflated + ", stub:" + this.stub);
        }
    }

    public <T> T get(int i3, Object... objArr) {
        return null;
    }

    public ViewStub getStub() {
        return this.stub;
    }

    public boolean hasInflated() {
        return this.hasInflated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void initView();

    public b(Activity activity, ViewStub viewStub, c cVar) {
        this.stub = viewStub;
        this.mActivity = activity;
        this.mPartManager = cVar;
    }

    protected void initAfterInflation(View view) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onActivityPause() {
    }

    public void onActivityResume() {
    }

    public void onActivityStart() {
    }

    public void onActivityStop() {
    }

    public void onDestroy() {
    }

    public void send(int i3, Object... objArr) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
