package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.kandian.base.utils.f;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSViewDecorationUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes33.dex */
public class PTSImageView extends ZImageView implements IView {
    private static final String TAG = "PTSImageView";
    private String mPath;
    private URL mPathUrl;
    private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;

    public PTSImageView(Context context) {
        super(context);
        this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveCount = this.mRoundedCorner.getSaveCount(canvas);
        this.mRoundedCorner.clipPath(canvas);
        super.draw(canvas);
        this.mRoundedCorner.drawCorner(canvas, saveCount);
        this.mRoundedCorner.drawBorder(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b g16 = this.mController.g();
        if ((g16 == null || g16.f239007d) && !TextUtils.isEmpty(this.mPath)) {
            setImageSrc(this.mPath);
        }
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        this.mRoundedCorner.onBindNodeInfo(pTSNodeInfo);
    }

    public void setImageSrc(String str) {
        try {
            String str2 = this.mPath;
            if (str2 == null || !str2.equalsIgnoreCase(str) || this.mPathUrl == null) {
                this.mPath = str;
                this.mPathUrl = new URL(this.mPath);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[setImageSrc], mPathUrl = " + this.mPathUrl);
            }
            f.c(this, this.mPathUrl, getContext());
        } catch (MalformedURLException e16) {
            this.mPathUrl = null;
            QLog.e(TAG, 1, "[setImageSrc] ex = " + e16);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.view.View
    public void onFinishTemporaryDetach() {
    }
}
