package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cm extends u {
    private void A9(ImageView imageView) {
        Option loadingDrawableColor = Option.obtain().setUrl(QFSDynamicResourceManager.g().obtainTokenToDynamicUrl("qvideo_url_qcircle_watermark", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_logo_watermark_v4.png")).setRequestWidth(ImmersiveUtils.dpToPx(73.0f)).setRequestHeight(ImmersiveUtils.dpToPx(26.0f)).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    private void x9() {
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f45421ru);
        if (viewStub == null) {
            return;
        }
        A9((ImageView) viewStub.inflate().findViewById(R.id.f45411rt));
    }

    private void z9() {
        if (QCirclePluginUtil.getQCircleInitBean(getContext()).isMiddlePage()) {
            x9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageWatermarkViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !com.tencent.biz.qqcircle.utils.k.g("exp_xsj_search_button", "exp_xsj_search_button_B");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        z9();
    }
}
