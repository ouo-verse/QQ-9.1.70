package com.tencent.richmediabrowser.core;

import android.content.Intent;
import com.tencent.richmediabrowser.log.BrowserLogHelper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserDirector {
    private static final String TAG = "BrowserDirector";
    public long buildParamsTime = 0;
    public long buildPresenterTime = 0;
    public long buildViewTime = 0;
    public long buildModelTime = 0;
    public long buildCompleteTime = 0;

    public void construct(IBrowserBuilder iBrowserBuilder, Intent intent) {
        if (iBrowserBuilder != null) {
            long currentTimeMillis = System.currentTimeMillis();
            iBrowserBuilder.buildPresenter();
            long currentTimeMillis2 = System.currentTimeMillis();
            this.buildParamsTime = currentTimeMillis2 - currentTimeMillis;
            iBrowserBuilder.buildParams(intent);
            long currentTimeMillis3 = System.currentTimeMillis();
            this.buildPresenterTime = currentTimeMillis3 - currentTimeMillis2;
            iBrowserBuilder.buildView();
            long currentTimeMillis4 = System.currentTimeMillis();
            this.buildViewTime = currentTimeMillis4 - currentTimeMillis3;
            iBrowserBuilder.buildModel();
            long currentTimeMillis5 = System.currentTimeMillis();
            this.buildModelTime = currentTimeMillis5 - currentTimeMillis4;
            iBrowserBuilder.buildComplete();
            this.buildCompleteTime = System.currentTimeMillis() - currentTimeMillis5;
            if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel()) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildParamsTime : " + this.buildParamsTime + ", buildPresenterTime " + this.buildPresenterTime + ", buildViewTime " + this.buildViewTime + ", buildModelTime " + this.buildModelTime + ", buildCompleteTime " + this.buildCompleteTime);
                return;
            }
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "Browser builder is null!");
    }

    public void constructItemView(IViewBuilder iViewBuilder, Intent intent) {
        if (iViewBuilder != null) {
            long currentTimeMillis = System.currentTimeMillis();
            iViewBuilder.buildInit();
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = currentTimeMillis2 - currentTimeMillis;
            iViewBuilder.buildParams(intent);
            long currentTimeMillis3 = System.currentTimeMillis();
            this.buildParamsTime = currentTimeMillis3 - currentTimeMillis2;
            iViewBuilder.buildView();
            long currentTimeMillis4 = System.currentTimeMillis();
            this.buildViewTime = currentTimeMillis4 - currentTimeMillis3;
            iViewBuilder.buildComplete();
            this.buildCompleteTime = System.currentTimeMillis() - currentTimeMillis4;
            if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel()) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildInitTime : " + j3 + ", buildParamsTime " + this.buildParamsTime + ", buildViewTime " + this.buildViewTime + ", buildCompleteTime " + this.buildCompleteTime);
                return;
            }
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "viewBuilder is null!");
    }
}
