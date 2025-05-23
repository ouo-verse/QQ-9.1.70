package com.tencent.gdtad.api.banner;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.GdtAdParams;
import java.util.HashSet;

/* loaded from: classes6.dex */
public final class GdtBannerParams extends GdtAdParams {
    public int orientation = Integer.MIN_VALUE;
    public int width = Integer.MIN_VALUE;
    public int height = Integer.MIN_VALUE;
    private final HashSet<Integer> screenOrientationSet = new HashSet<Integer>() { // from class: com.tencent.gdtad.api.banner.GdtBannerParams.1
        {
            add(1);
            add(0);
            add(8);
        }
    };
    long showTime = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    public boolean isRenderTypeKuikly = false;

    public static boolean isCreativeSizeValid(GdtAd gdtAd) {
        boolean z16;
        boolean z17 = false;
        if (gdtAd == null || !gdtAd.isValid()) {
            return false;
        }
        int creativeSize = gdtAd.getCreativeSize();
        if ((creativeSize != 65 && creativeSize != 184 && creativeSize != 194) || gdtAd.getImageData() == null || !gdtAd.getImageData().isValid()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (creativeSize == 285) {
            GdtImageData imageData = gdtAd.getImageData(0);
            GdtImageData imageData2 = gdtAd.getImageData(1);
            GdtImageData imageData3 = gdtAd.getImageData(2);
            if (imageData != null && imageData.isValid() && imageData2 != null && imageData2.isValid() && imageData3 != null && imageData3.isValid()) {
                z17 = true;
            }
        } else {
            z17 = z16;
        }
        if (creativeSize == 185) {
            return !TextUtils.isEmpty(gdtAd.getVideoUrl());
        }
        return z17;
    }

    private boolean isValidScreenParams() {
        if (this.screenOrientationSet.contains(Integer.valueOf(this.orientation)) && this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.api.GdtAdParams
    public boolean isValid() {
        if (super.isValid() && this.clickParams.isInitialized() && isValidScreenParams()) {
            return true;
        }
        return false;
    }
}
