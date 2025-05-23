package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = HippyTKDGifImageViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyTKDGifImageViewController extends HippyViewController<HippyTKDGifImageView> {
    public static final String CLASS_NAME = "TKDGifImageView";
    public static final String PROPS_GIFINFO = "gifInfo";
    public static final String PROPS_GIFURL = "gifUrl";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTKDGifImageView(context);
    }

    @HippyControllerProps(defaultType = "map", name = "clipInfo")
    public void setClipInfo(HippyTKDGifImageView hippyTKDGifImageView, HippyMap hippyMap) {
        if (hippyTKDGifImageView instanceof HippyTKDGifImageView) {
            hippyTKDGifImageView.setClipInfo(hippyMap);
        }
    }

    @HippyControllerProps(defaultType = "map", name = PROPS_GIFINFO)
    public void setGifInfo(HippyTKDGifImageView hippyTKDGifImageView, HippyMap hippyMap) {
        boolean z16;
        if (hippyMap != null) {
            if (hippyMap.containsKey("enableNoPicMode")) {
                hippyTKDGifImageView.setNoPicModeOption(hippyMap.getBoolean("enableNoPicMode"));
            }
            if (hippyMap.containsKey("sustainedPlay")) {
                hippyTKDGifImageView.setSustainedPlay(hippyMap.getBoolean("sustainedPlay"));
            }
            if (hippyMap.containsKey("startPlay")) {
                z16 = hippyMap.getBoolean("startPlay");
            } else {
                z16 = true;
            }
            if (hippyMap.containsKey(PROPS_GIFURL)) {
                String string = hippyMap.getString(PROPS_GIFURL);
                if (hippyTKDGifImageView.getUrl() == null || !hippyTKDGifImageView.getUrl().equals(string)) {
                    hippyTKDGifImageView.mGIFUrl = string;
                    hippyTKDGifImageView.setGifUrl(string);
                }
            }
        } else {
            z16 = true;
        }
        if (z16) {
            hippyTKDGifImageView.mUserRequestPlay = true;
            hippyTKDGifImageView.startPlay();
        } else {
            hippyTKDGifImageView.mUserRequestPlay = false;
            hippyTKDGifImageView.stopPlay();
        }
    }

    @HippyControllerProps(defaultType = "map", name = "reportData")
    public void setReportData(HippyTKDGifImageView hippyTKDGifImageView, HippyMap hippyMap) {
        if (hippyTKDGifImageView instanceof HippyTKDGifImageView) {
            hippyTKDGifImageView.setReportData(hippyMap);
        }
    }
}
