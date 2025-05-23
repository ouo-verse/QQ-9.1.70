package com.tencent.superplayer.preload;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* loaded from: classes26.dex */
public class PreloadUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ISPlayerVideoView createCleanTextureView(Activity activity) {
        final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        final ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(activity);
        createPlayerVideoView.addViewCallBack(new ISPlayerVideoView.IVideoViewCallBack() { // from class: com.tencent.superplayer.preload.PreloadUtils.1
            @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
            public void onSurfaceCreated(Object obj) {
                viewGroup.post(new Runnable() { // from class: com.tencent.superplayer.preload.PreloadUtils.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        createPlayerVideoView.disableViewCallback();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        viewGroup.removeView((View) createPlayerVideoView);
                    }
                });
            }

            @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
            public void onSurfaceChanged(Object obj) {
            }

            @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
            public void onSurfaceDestroy(Object obj) {
            }
        });
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.preload.PreloadUtils.2
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView((View) createPlayerVideoView);
            }
        });
        return createPlayerVideoView;
    }
}
