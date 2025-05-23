package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/layer/part/cr;", "Lcom/qzone/reborn/layer/part/ap;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "picInfo", "", "M9", "", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getPicType", "()Landroid/widget/TextView;", "setPicType", "(Landroid/widget/TextView;)V", "picType", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cr extends ap {

    /* renamed from: G, reason: from kotlin metadata */
    private TextView picType;

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && gd.a.f401926a.c("KEY_OPEN_SHOW_LAYER_PIC_TYPE", false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        TextView textView;
        super.onInitView(rootView);
        this.picType = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        TextView textView2 = this.picType;
        if (textView2 != null) {
            textView2.setLayoutParams(layoutParams);
        }
        TextView textView3 = this.picType;
        if (textView3 != null) {
            textView3.setTextSize(16.0f);
        }
        TextView textView4 = this.picType;
        if (textView4 != null) {
            textView4.setTextColor(-1);
        }
        if (!(rootView instanceof ViewGroup) || (textView = this.picType) == null) {
            return;
        }
        ((ViewGroup) rootView).addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        RFWLayerPicInfo layerPicInfo;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        boolean z16 = false;
        if (rFWLayerItemMediaInfo != null && !rFWLayerItemMediaInfo.isVideo()) {
            z16 = true;
        }
        if (!z16) {
            TextView textView = this.picType;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        M9((rFWLayerItemMediaInfo2 == null || (layerPicInfo = rFWLayerItemMediaInfo2.getLayerPicInfo()) == null) ? null : layerPicInfo.getCurrentPicInfo());
    }

    private final void M9(RFWLayerPicInfo.RFWPicInfo picInfo) {
        String str;
        if (picInfo == null) {
            RFWLog.e("QZonePicTypeInfoPart", RFWLog.USR, "pic info is null");
            return;
        }
        if (RFWFileUtils.getFileType(picInfo.getLocalPath()) != null) {
            TextView textView = this.picType;
            if (textView != null) {
                textView.setText("\u56fe\u7247\u683c\u5f0f\u4e3a " + RFWFileUtils.getFileType(picInfo.getLocalPath()) + "   so \u7248\u672c\u5e93\u4e3a " + com.tencent.qqsharpP.a.f363552b);
            }
            TextView textView2 = this.picType;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
            return;
        }
        if (!TextUtils.isEmpty(picInfo.getLocalPath())) {
            try {
                String localPath = picInfo.getLocalPath();
                Intrinsics.checkNotNull(localPath);
                File file = new File(localPath);
                TextView textView3 = this.picType;
                if (textView3 != null) {
                    if (SharpPUtil.isSharpPFile(file)) {
                        str = "\u56fe\u7247\u683c\u5f0f\u4e3aSharpP \n  so \u7248\u672c\u5e93\u4e3a " + com.tencent.qqsharpP.a.f363552b;
                    } else {
                        str = "\u56fe\u7247\u683c\u5f0f\u65e0\u6cd5\u8bc6\u522b";
                    }
                    textView3.setText(str);
                }
                TextView textView4 = this.picType;
                if (textView4 == null) {
                    return;
                }
                textView4.setVisibility(0);
                return;
            } catch (Exception e16) {
                TextView textView5 = this.picType;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                RFWLog.e("QZonePicTypeInfoPart", RFWLog.USR, "exception is " + e16);
                return;
            }
        }
        TextView textView6 = this.picType;
        if (textView6 == null) {
            return;
        }
        textView6.setVisibility(8);
    }
}
