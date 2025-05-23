package com.tencent.gdtad.api.halfscreen;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
class b extends DownloadCardDialog {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f108561d;

    public b(@NonNull Context context) {
        super(context);
        if (!(context instanceof Activity)) {
            GdtLog.e("GdtHalfScreenDownloadDialog", "context should be Activity");
        } else {
            this.f108561d = new WeakReference<>((Activity) context);
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f108561d;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        if (!this.mShowing) {
            GdtLog.i("GdtHalfScreenDownloadDialog", "[dismiss] view is not showing");
            return;
        }
        this.mShowing = false;
        hideCardView();
        hideShadowView();
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog
    public void show() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f108561d;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        if (this.mShowing) {
            GdtLog.i("GdtHalfScreenDownloadDialog", "[show] view is showing");
            return;
        }
        this.mShowing = true;
        showCardView();
        showShadowView();
    }
}
