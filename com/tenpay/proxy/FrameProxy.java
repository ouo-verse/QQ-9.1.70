package com.tenpay.proxy;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public class FrameProxy {
    private static final String TAG = "FrameProxy";
    private boolean destorywhenAnimationEnd = true;
    private AnimationView.AnimationInfo mAnimInfo;
    private AnimationView mAnimationView;

    /* loaded from: classes27.dex */
    private class ZipLoadingTask extends AsyncTask<String, Void, AnimationView.AnimationInfo> {
        ZipLoadingTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public AnimationView.AnimationInfo doInBackground(String... strArr) {
            return AnimationView.AnimationInfo.loadFromFolder(strArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(AnimationView.AnimationInfo animationInfo) {
            try {
                FrameProxy.this.mAnimInfo = animationInfo;
                if (animationInfo != null && FrameProxy.this.mAnimationView != null) {
                    FrameProxy.this.mAnimationView.setAnimationFromInfo(animationInfo);
                    FrameProxy.this.mAnimationView.setVisibility(0);
                    FrameProxy.this.mAnimationView.play();
                } else if (QLog.isColorLevel()) {
                    QLog.i(FrameProxy.TAG, 2, "AnimationInfo == null");
                }
            } catch (Throwable th5) {
                QLog.e(FrameProxy.TAG, 1, "", th5);
            }
        }
    }

    public void destory() {
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "destory()...");
            }
            AnimationView animationView = this.mAnimationView;
            if (animationView != null) {
                animationView.stop();
                this.mAnimationView.setImageDrawable(null);
                this.mAnimationView.setVisibility(8);
                AnimationView.AnimationInfo animationInfo = this.mAnimInfo;
                if (animationInfo != null) {
                    animationInfo.destoryBitmaps();
                    this.mAnimInfo = null;
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    public void setDestorywhenAnimationEnd(boolean z16) {
        this.destorywhenAnimationEnd = z16;
    }

    public void startHBAnimation(AnimationView animationView, String str) {
        if (animationView != null && !TextUtils.isEmpty(str)) {
            this.mAnimationView = animationView;
            animationView.setAnimationListener(new AnimationView.MyAnimationListener() { // from class: com.tenpay.proxy.FrameProxy.1
                @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
                public void onAnimationEnd(AnimationView animationView2) {
                    if (FrameProxy.this.destorywhenAnimationEnd) {
                        FrameProxy.this.destory();
                    }
                }

                @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
                public void onAnimationRepeat(AnimationView animationView2) {
                }

                @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
                public void onAnimationStart(AnimationView animationView2) {
                }
            });
            new ZipLoadingTask().execute(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "" + str);
        }
    }
}
