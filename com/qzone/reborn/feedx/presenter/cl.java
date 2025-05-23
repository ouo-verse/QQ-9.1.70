package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cl extends vg.a {
    private ImageView F;
    private TextView G;

    private void H() {
        ImageView imageView = this.F;
        if (imageView == null) {
            return;
        }
        imageView.setColorFilter(i().getColor(R.color.qui_common_text_secondary));
        this.F.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_DIVIMAGE_URL, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DIVIMAGE_URL)).setTargetView(this.F).setRequestHeight(ImmersiveUtils.dpToPx(43.0f)));
    }

    private void I() {
        String str;
        if (this.G != null && com.qzone.reborn.feedx.util.y.e()) {
            TextView textView = this.G;
            if (TextUtils.isEmpty(QZoneFeedService.f47178j0)) {
                str = y6.e.H;
            } else {
                str = QZoneFeedService.f47178j0;
            }
            textView.setText(str);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneGuestMemorySealFeedPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnr;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View view) {
        if (view == null) {
            return;
        }
        this.F = (ImageView) view.findViewById(R.id.f162899n74);
        this.G = (TextView) view.findViewById(R.id.mgu);
        H();
        I();
    }
}
