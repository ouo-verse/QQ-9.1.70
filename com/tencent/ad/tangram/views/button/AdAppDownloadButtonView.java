package com.tencent.ad.tangram.views.button;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnView;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
final class AdAppDownloadButtonView implements IAdAppDownloadButtonView {
    private static final String TAG = "AdAppDownloadButtonView";
    private Ad mAd;
    private AdCanvasAppBtnView view;

    public AdAppDownloadButtonView(Context context, Ad ad5, int i3, int i16) {
        this.mAd = ad5;
        AdCanvasAppBtnView.Params params = new AdCanvasAppBtnView.Params();
        double d16 = i3;
        params.textSize = Double.valueOf(0.0547945205479452d * d16).intValue();
        params.leftBackgroundColor = Color.parseColor("#00CAFC");
        params.leftTextColor = -1;
        params.rightBackgroundColor = Color.parseColor("#E5E5E5");
        params.rightTextColor = Color.parseColor("#B5B8C2");
        params.borderCornerRadius = Double.valueOf(d16 * 0.17123287671232876d).intValue();
        this.view = new AdCanvasAppBtnView(context, params);
    }

    public View getButtonView() {
        return this.view;
    }

    @Override // com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView
    public void update(int i3, int i16) {
        AdLog.i(TAG, String.format("updateViews status:%d progress:%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        this.view.setText(this.mAd.getButtonText(i3, i16));
        if (i3 != 0) {
            if (i3 != 9) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                this.view.setProgress(100);
                                return;
                            } else {
                                this.view.setProgress(100);
                                return;
                            }
                        }
                        this.view.setProgress(i16);
                        return;
                    }
                    this.view.setProgress(i16);
                    return;
                }
                this.view.setProgress(i16);
                return;
            }
            this.view.setProgress(100);
            return;
        }
        this.view.setProgress(100);
    }
}
