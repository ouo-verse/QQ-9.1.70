package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.pts.util.d;
import com.tencent.mobileqq.urldrawable.a;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qphone.base.util.QLog;
import q62.b;

/* loaded from: classes33.dex */
public class PTSNodeImage extends PTSNodeVirtual {
    public static final String TAG = "PTSNodeImage";
    private float blurRadius;
    private String imageUrl;
    private String mode;
    private Drawable normalDrawable;
    private Drawable pressedDrawable;

    /* loaded from: classes33.dex */
    public static class Builder implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSImageView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new PTSNodeImage(pTSAppInstance);
        }
    }

    PTSNodeImage(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "img", null);
        this.blurRadius = 0.0f;
    }

    private String addSmartCrop(String str) {
        int width = getNodeInfo().getStyle().getWidth();
        int height = getNodeInfo().getStyle().getHeight();
        return (width <= 0 || height <= 0) ? str : b.b(str, width, height);
    }

    private void setImageMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PTSImageView pTSImageView = (PTSImageView) getView();
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1362001767:
                if (str.equals("aspectFit")) {
                    c16 = 1;
                    break;
                }
                break;
            case -797304696:
                if (str.equals(PTSNodeAttributeConstant.MODE_SCALE_TO_FILL)) {
                    c16 = 2;
                    break;
                }
                break;
            case 727618043:
                if (str.equals("aspectFill")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                pTSImageView.setScaleType(ImageView.ScaleType.CENTER);
                return;
            case 1:
                pTSImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 2:
                pTSImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            case 3:
                pTSImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return;
            default:
                return;
        }
    }

    private void setImageSrc(String str) {
        ((PTSImageView) getView()).setImageDrawable(getView().getResources().getDrawable(R.drawable.d7y));
        if (!TextUtils.isEmpty(str)) {
            if (d.d(str)) {
                setNetWorkImage(str);
            } else if (d.c(str)) {
                d.e((PTSImageView) getView(), str);
            }
        } else {
            QLog.i("PTSNodeImage", 1, "[setImageSrc] imageUrl is null.");
        }
        if (QLog.isColorLevel()) {
            QLog.i("PTSNodeImage", 1, "[setImageSrc], imageUrl = " + str);
        }
    }

    private void setNetWorkImage(String str) {
        String addSmartCrop = addSmartCrop(str);
        QLog.i("PTSNodeImage", 1, "[setImageSrc], cropUrl = " + addSmartCrop + ", blurRadius = " + this.blurRadius);
        if (this.blurRadius > 0.0f) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = getView().getResources().getDrawable(R.drawable.d7y);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(addSmartCrop, obtain);
            drawable2.setDecodeHandler(new a.w((int) this.blurRadius));
            ((PTSImageView) getView()).setImageDrawable(drawable2);
            return;
        }
        ((PTSImageView) getView()).setImageSrc(addSmartCrop);
    }

    private void updatePtsOnPressedSrc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("PTSNodeImage", 1, "[updatePtsOnPressedSrc], imageUrl = " + this.imageUrl + ", onPressedSrc = " + str + ", blurRadius = " + this.blurRadius);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.normalDrawable = d.a(getContext(), addSmartCrop(this.imageUrl), (int) this.blurRadius);
        Drawable a16 = d.a(getContext(), addSmartCrop(str), (int) this.blurRadius);
        this.pressedDrawable = a16;
        if (this.normalDrawable == null || a16 == null) {
            return;
        }
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, a16);
        stateListDrawable.addState(new int[0], this.normalDrawable);
        ((PTSImageView) getView()).setImageDrawable(stateListDrawable);
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        setImageSrc(this.imageUrl);
        setImageMode(this.mode);
        updatePtsOnPressedSrc(getPtsOnPressSrc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        boolean attribute = super.setAttribute(str, obj);
        if ("src".equals(str)) {
            this.imageUrl = PTSValueConvertUtil.getString(obj);
        } else {
            if (!"mode".equals(str)) {
                return attribute;
            }
            this.mode = PTSValueConvertUtil.getString(obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setStyle(String str, Object obj) {
        boolean style = super.setStyle(str, obj);
        if ("filter".equalsIgnoreCase(str)) {
            this.blurRadius = PTSValueConvertUtil.getFloat(obj);
        }
        return style;
    }
}
