package com.tencent.biz.pubaccount.imagecollection;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    PublicAccountImageView f79682a0;

    /* renamed from: b0, reason: collision with root package name */
    RelativeLayout f79683b0;

    /* renamed from: c0, reason: collision with root package name */
    int f79684c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    protected Handler f79685d0 = new a();

    /* loaded from: classes32.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            PublicAccountImageCollectionActivity.this.G2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2() {
        finish();
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionActivity", 2, "activity finish");
        }
        PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = false;
        Handler handler = this.f79685d0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f79685d0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    private Drawable H2(String str, int i3, int i16) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            url = null;
        }
        com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
        bVar.f239004a = url;
        bVar.f239005b = i3;
        bVar.f239006c = i16;
        k52.b bitmap = ((IImageManager) QRoute.api(IImageManager.class)).getBitmap(bVar);
        if (bitmap != null) {
            return new d(bitmap.get());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168410vd);
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width = getWindowManager().getDefaultDisplay().getWidth();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("doubleBitMapPath");
        float[] floatArrayExtra = intent.getFloatArrayExtra("imageMatrix");
        int intExtra = intent.getIntExtra("urlImageWidth", 0);
        int intExtra2 = intent.getIntExtra("urlImageHeight", 0);
        int intExtra3 = intent.getIntExtra("urlImageWidthReal", 0);
        int intExtra4 = intent.getIntExtra("urlImageHeightReal", 0);
        Matrix matrix = new Matrix();
        if (floatArrayExtra != null) {
            matrix.setValues(floatArrayExtra);
        }
        this.f79682a0 = new PublicAccountImageView(this, this.f79685d0, matrix, this.f79684c0, intExtra3, intExtra4);
        this.f79683b0 = (RelativeLayout) findViewById(R.id.g4k);
        this.f79682a0.setImageDrawable(H2(stringExtra, intExtra, intExtra2));
        matrix.postScale(3.0f, 3.0f, intExtra3 / 2, intExtra4 / 2);
        matrix.postTranslate((width - intExtra3) / 2, (height - intExtra4) / 2);
        this.f79682a0.setImageMatrix(matrix);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10, -1);
        this.f79683b0.addView(this.f79682a0, layoutParams);
        return true;
    }
}
