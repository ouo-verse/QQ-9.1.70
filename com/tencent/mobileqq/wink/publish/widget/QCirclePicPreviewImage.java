package com.tencent.mobileqq.wink.publish.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.wink.publish.util.c;
import com.tencent.mobileqq.wink.publish.widget.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.mobileqq.wink.publish.widget.multitouchimg.j;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;

/* loaded from: classes21.dex */
public class QCirclePicPreviewImage extends PublishBaseWidgetView<k93.a> {

    /* renamed from: d, reason: collision with root package name */
    private QCircleMultiTouchImageView f326089d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements j {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.publish.widget.multitouchimg.j
        public void onScaleEnd(float f16) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f326091d;

        b(String str) {
            this.f326091d = str;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            QLog.d("QCirclePicPreviewImage", 1, "path:" + this.f326091d + "state callback:" + loadState);
        }
    }

    public QCirclePicPreviewImage(@NonNull Context context) {
        super(context);
        initView();
    }

    private Option l0(URLImageView uRLImageView, k93.a aVar) {
        Option option = new Option();
        option.setLoadingDrawable(getResources().getDrawable(R.drawable.trans));
        if (aVar != null && uRLImageView != null && aVar.a() != null) {
            int i3 = aVar.a().mediaHeight;
            int i16 = aVar.a().mediaWidth;
            if (i3 > 0 && i16 > 0) {
                int[] d16 = c.d(i16, i3);
                int i17 = d16[0];
                int i18 = d16[1];
                option.setRequestWidth(i17);
                option.setRequestHeight(i18);
            }
        }
        return option;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    protected void initView() {
        QCircleMultiTouchImageView qCircleMultiTouchImageView = new QCircleMultiTouchImageView(getContext());
        this.f326089d = qCircleMultiTouchImageView;
        qCircleMultiTouchImageView.setBackgroundColor(-16777216);
        addView(this.f326089d, new FrameLayout.LayoutParams(-1, -1));
        this.f326089d.setOnScaleEndListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(k93.a aVar, int i3) {
        DecodeFormat decodeFormat;
        if (this.f326089d != null && aVar != null) {
            String b16 = aVar.b();
            if (!TextUtils.isEmpty(b16)) {
                Option l06 = l0(this.f326089d, aVar);
                Option predecode = new Option().setTargetView(this.f326089d).setRequestHeight(l06.getRequestHeight()).setRequestWidth(l06.getRequestWidth()).setUrl(b16).setLoadingDrawable(getResources().getDrawable(R.drawable.trans)).setPredecode(true);
                if (QCircleDeviceInfoUtils.isLowDevice()) {
                    decodeFormat = DecodeFormat.PREFER_RGB_565;
                } else {
                    decodeFormat = DecodeFormat.PREFER_ARGB_8888;
                }
                QCircleFeedPicLoader.g().loadImage(predecode.setPreferDecodeFormat(decodeFormat), new b(b16));
                return;
            }
            QLog.d("QCirclePicPreviewImage", 1, "same url, not need load oncemore! url:" + b16);
        }
    }
}
