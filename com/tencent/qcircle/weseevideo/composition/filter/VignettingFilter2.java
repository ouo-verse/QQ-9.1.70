package com.tencent.qcircle.weseevideo.composition.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.VignettingFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.FeatureUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VignettingFilter2 extends VignettingFilter {
    public VignettingFilter2() {
        Bitmap encryptedBitmap = FeatureUtils.getEncryptedBitmap("assets://raw/sh/", FeatureManager.getResourceDir(), "darkcornermask_revert_s.png");
        if (BitmapUtils.isLegal(encryptedBitmap)) {
            addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", encryptedBitmap, 33986, true));
        }
    }
}
