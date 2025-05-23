package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ImageBase extends ViewBase {
    public static SparseArray<ImageView.ScaleType> IMAGE_SCALE_TYPE = null;
    private static final String TAG = "ImageBase_TMTEST";
    double[] mDynamicRate;
    public int mScaleType;
    private int mSizeChangeAccord;
    public String mSrc;

    static {
        SparseArray<ImageView.ScaleType> sparseArray = new SparseArray<>();
        IMAGE_SCALE_TYPE = sparseArray;
        sparseArray.put(1, ImageView.ScaleType.FIT_XY);
        IMAGE_SCALE_TYPE.put(2, ImageView.ScaleType.CENTER_CROP);
    }

    public ImageBase(VafContext vafContext) {
        super(vafContext);
        this.mSizeChangeAccord = 0;
        this.mDynamicRate = new double[1];
        this.mScaleType = 2;
    }

    public String getSrc() {
        return this.mSrc;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        Layout.Params params;
        int i3;
        int i16;
        super.onParseValueFinished();
        double d16 = this.mDynamicRate[0];
        if (d16 > 0.0d && (params = this.mParams) != null) {
            int i17 = this.mSizeChangeAccord;
            if (i17 == 1 && (i16 = params.mLayoutWidth) > 0) {
                params.mLayoutHeight = (int) (i16 / d16);
            } else if (i17 == 2 && (i3 = params.mLayoutHeight) > 0) {
                params.mLayoutWidth = (int) (i3 * d16);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        boolean attribute = super.setAttribute(i3, str);
        if (attribute) {
            return attribute;
        }
        if (i3 == 23) {
            this.mSrc = str;
        } else if (i3 == 24) {
            this.mSrc = str;
        } else {
            if (i3 != 51) {
                return false;
            }
            Integer integer = Utils.toInteger(str);
            if (integer != null) {
                this.mScaleType = integer.intValue();
            }
        }
        return true;
    }

    public void setBitmap(Bitmap bitmap) {
        setBitmap(bitmap, true);
    }

    public abstract void setBitmap(Bitmap bitmap, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, Object obj) {
        boolean attribute = super.setAttribute(i3, obj);
        if (attribute) {
            return attribute;
        }
        if (i3 == 23) {
            this.mSrc = JsonUtils.getStringValue(obj, 0);
        } else {
            if (i3 != 55) {
                return false;
            }
            this.mSizeChangeAccord = JsonUtils.getDynamicRateSize(this.mDynamicRate, obj);
        }
        return true;
    }

    public void loadImage(String str) {
    }

    public void setImageDrawable(Drawable drawable, boolean z16) {
    }
}
