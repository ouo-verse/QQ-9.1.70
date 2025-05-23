package com.tencent.gdtad.basics.motivevideo.data;

import androidx.annotation.Nullable;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveVideoAd extends GdtAd {
    private static final String TAG = "GdtMotiveVideoAd";
    private GdtMotiveVideoParams params;

    public GdtMotiveVideoAd(GdtMotiveVideoParams gdtMotiveVideoParams) {
        super(gdtMotiveVideoParams);
        this.params = gdtMotiveVideoParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    public int getErrorCode(@Nullable com.tencent.gdtad.aditem.GdtAd gdtAd, int i3, int i16, int i17) {
        int errorCode = super.getErrorCode(gdtAd, i3, i16, i17);
        if (errorCode != 0) {
            return errorCode;
        }
        if (gdtAd != null && isValid() && getMParams().requestParams != null) {
            if (GdtUIUtils.isMatchedMotiveVideoSize(gdtAd.getCreativeSize())) {
                return 0;
            }
            return 7;
        }
        GdtLog.e(TAG, "getErrorCode error");
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    /* renamed from: getParams */
    public GdtMotiveVideoParams getMParams() {
        return this.params;
    }
}
