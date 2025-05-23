package com.tencent.comic.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = BoodoHippyImageViewController.CLASS_NAME)
/* loaded from: classes32.dex */
public class BoodoHippyImageViewController extends HippyImageViewController {
    public static final String CLASS_NAME = "BoodoImage";

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        BoodoHippyImageView boodoHippyImageView = new BoodoHippyImageView(context);
        if (hippyMap != null) {
            boodoHippyImageView.setInitProps(hippyMap);
        }
        return boodoHippyImageView;
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "blurRadius")
    public void setBlurRadius(HippyImageView hippyImageView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "mBlurRadius", Integer.valueOf(i3));
        }
        if (hippyImageView instanceof BoodoHippyImageView) {
            ((BoodoHippyImageView) hippyImageView).setBlurRadius(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new BoodoHippyImageView(context);
    }
}
