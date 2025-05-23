package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import com.qzone.proxy.covercomponent.model.PhotoLoadedListener;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverSuperImageView extends CoverBaseView implements PhotoLoadedListener {
    public boolean init() {
        invalidate();
        return true;
    }

    public CoverSuperImageView() {
        super(7);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
        canvas.drawColor(0);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData) {
        Intent coverPreviewIntent;
        if (coverCacheData != null && coverCacheData.uin != CoverEnv.getLoginUin() && CoverEnv.isUserHomeActivity(activity) && !coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_ACTIVITY_COVER_URL)) {
            CoverEnv.RDMCollector.addNoramlClickAction(CoverBaseView.TAG, view);
            if (TextUtils.isEmpty(coverCacheData.coverId)) {
                coverPreviewIntent = CoverJumpAction.getCoverStoreIntent(2, QzoneCoverConst.REFER_USERHOME, coverCacheData.uin);
            } else {
                coverPreviewIntent = CoverJumpAction.getCoverPreviewIntent(coverCacheData.coverId, 2, QzoneCoverConst.REFER_USERHOME, coverCacheData.uin);
            }
            Intent coverClickedIntentFromJceData = CoverJumpAction.getCoverClickedIntentFromJceData(coverCacheData.uin);
            if (coverClickedIntentFromJceData != null) {
                coverPreviewIntent = coverClickedIntentFromJceData;
            }
            activity.startActivity(coverPreviewIntent);
            return true;
        }
        return super.onTouchEvent(activity, view, motionEvent, coverCacheData);
    }

    @Override // com.qzone.proxy.covercomponent.model.PhotoLoadedListener
    public void onLoadSuccess(LoadPhotoState loadPhotoState, Drawable drawable) {
    }
}
