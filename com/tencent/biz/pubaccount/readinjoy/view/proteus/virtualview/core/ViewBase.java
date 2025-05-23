package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ViewBase implements IView {
    private static final String TAG = "ViewBase";
    public static final String TYPE = "type";
    protected String mBackgroundImagePath;
    protected Paint mBackgroundPaint;
    protected Paint mBorderPaint;
    protected String mClickEvnet;
    protected Rect mContentRect;
    protected VafContext mContext;
    protected int mDrawLeft;
    protected int mDrawTop;
    protected String mEventAttachedData;
    protected View mHolderView;
    protected boolean mIsDrawed;
    private SimpleArrayMap<String, Object> mKeyedTags;
    protected int mMeasuredHeight;
    protected int mMeasuredWidth;
    private OnClickListener mOnClickListener;
    protected Paint mPaint;
    protected Layout.Params mParams;
    protected Layout mParent;
    protected Object mTag;
    protected Bitmap mBackgroundImage = null;
    protected Matrix mMatrixBG = null;
    private boolean mIsSoftwareRender = false;
    protected int mBorderWidth = 0;
    protected int mBorderColor = -16777216;
    protected int mBorderRadius = 0;
    protected int mBorderTopLeftRadius = 0;
    protected int mBorderTopRightRadius = 0;
    protected int mBorderBottomLeftRadius = 0;
    protected int mBorderBottomRightRadius = 0;
    protected float mAlpha = -1.0f;
    protected int mVisibility = 0;
    protected int mAutoDimDirection = 0;
    protected float mAutoDimX = 1.0f;
    protected float mAutoDimY = 1.0f;
    protected int mBackground = 0;
    protected int mGravity = 9;
    protected int mFlag = 0;
    protected int mPaddingLeft = 0;
    protected int mPaddingTop = 0;
    protected int mPaddingRight = 0;
    protected int mPaddingBottom = 0;
    protected int mMinWidth = 0;
    protected int mMinHeight = 0;
    protected String mName = "";
    protected String mViewType = "";
    protected int mUuid = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface IBuilder {
        ViewBase build(VafContext vafContext);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface OnClickListener {
        void onClick(ViewBase viewBase);
    }

    public ViewBase(VafContext vafContext) {
        this.mContext = vafContext;
    }

    private boolean changeVisibility() {
        View nativeView = getNativeView();
        if (nativeView != null) {
            int i3 = this.mVisibility;
            if (i3 != 0) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        return true;
                    }
                    nativeView.setVisibility(8);
                    return true;
                }
                nativeView.setVisibility(4);
                return true;
            }
            nativeView.setVisibility(0);
            return true;
        }
        if (!isContainer()) {
            return false;
        }
        int i16 = this.mVisibility;
        if (i16 != 0) {
            if (i16 != 4) {
                if (i16 != 8) {
                    return true;
                }
                this.mHolderView.setVisibility(8);
                return true;
            }
            this.mHolderView.setVisibility(4);
            return true;
        }
        this.mHolderView.setVisibility(0);
        return true;
    }

    private void setBorderRadiusArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(0);
        String optString = jSONArray.optString(1, ParseCommon.LAYOUT_PARAMS_RELATIVE);
        if (optJSONArray != null) {
            double optDouble = optJSONArray.optDouble(0, 0.0d);
            double optDouble2 = optJSONArray.optDouble(1, 0.0d);
            double optDouble3 = optJSONArray.optDouble(2, 0.0d);
            double optDouble4 = optJSONArray.optDouble(3, 0.0d);
            if (ParseCommon.LAYOUT_PARAMS_ABSOLUTELY.equals(optString)) {
                this.mBorderTopLeftRadius = Utils.dp2px(optDouble);
                this.mBorderTopRightRadius = Utils.dp2px(optDouble2);
                this.mBorderBottomRightRadius = Utils.dp2px(optDouble3);
                this.mBorderBottomLeftRadius = Utils.dp2px(optDouble4);
                return;
            }
            this.mBorderTopLeftRadius = Utils.rp2px(optDouble);
            this.mBorderTopRightRadius = Utils.rp2px(optDouble2);
            this.mBorderBottomRightRadius = Utils.rp2px(optDouble3);
            this.mBorderBottomLeftRadius = Utils.rp2px(optDouble4);
        }
    }

    public void bindDynamicValue(ViewBean viewBean) {
        ValueBean valueBean;
        Map<String, Object> map;
        clearDynamicData();
        if (viewBean != null && (valueBean = viewBean.valueBean) != null && (map = valueBean.dynamicValue) != null) {
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            if (!entrySet.isEmpty()) {
                for (Map.Entry<String, Object> entry : entrySet) {
                    setValue(entry.getKey(), entry.getValue());
                }
                if (this.mVisibility != 8) {
                    onParseValueFinished();
                }
            }
            if (LogUtil.QLog.isColorLevel()) {
                LogUtil.QLog.d(TAG, 2, "[viewBase] bind dynamicValue " + viewBean.valueBean.dynamicValue + " viewId = " + viewBean.viewId);
            }
        }
    }

    public void bindNormalValue(ViewBean viewBean) {
        ValueBean valueBean;
        Map<String, Object> map;
        if (viewBean != null && (valueBean = viewBean.valueBean) != null && (map = valueBean.normalValue) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                setValue(entry.getKey(), entry.getValue());
            }
            if (this.mVisibility != 8) {
                onParseValueFinished();
            }
            if (LogUtil.QLog.isColorLevel()) {
                LogUtil.QLog.d(TAG, 2, "[viewBase] bind normalValue " + viewBean.valueBean.normalValue + " viewId = " + viewBean.viewId);
            }
        }
    }

    @Deprecated
    public final boolean canHandleEvent() {
        return false;
    }

    public void comDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mDrawLeft, this.mDrawTop);
        onComDraw(canvas);
        canvas.restore();
        this.mIsDrawed = true;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public final void comLayout(int i3, int i16, int i17, int i18) {
        this.mDrawLeft = i3;
        this.mDrawTop = i16;
        onComLayout(true, i3, i16, i17, i18);
    }

    public void destroy() {
        this.mContext = null;
    }

    public ViewBase findViewBaseByName(String str) {
        if (TextUtils.equals(this.mName, str)) {
            return this;
        }
        return null;
    }

    public int getAlign() {
        return this.mGravity;
    }

    public int getBackground() {
        return this.mBackground;
    }

    public Paint getBackgroundPaint() {
        return this.mBackgroundPaint;
    }

    public int getBorderRadius() {
        return this.mBorderRadius;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public ViewBase getChild(int i3) {
        return null;
    }

    public String getClickEvnet() {
        return this.mClickEvnet;
    }

    public Layout.Params getComLayoutParams() {
        return this.mParams;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public final int getComMeasuredHeightWithMargin() {
        int comMeasuredHeight = getComMeasuredHeight();
        Layout.Params params = this.mParams;
        return comMeasuredHeight + params.mLayoutMarginTop + params.mLayoutMarginBottom;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public final int getComMeasuredWidthWithMargin() {
        int comMeasuredWidth = getComMeasuredWidth();
        Layout.Params params = this.mParams;
        return comMeasuredWidth + params.mLayoutMarginLeft + params.mLayoutMarginRight;
    }

    public final int getComPaddingBottom() {
        return this.mPaddingBottom;
    }

    public final int getComPaddingLeft() {
        return this.mPaddingLeft;
    }

    public final int getComPaddingRight() {
        return this.mPaddingRight;
    }

    public final int getComPaddingTop() {
        return this.mPaddingTop;
    }

    public final int getDrawLeft() {
        if (this.mDrawLeft == 0 && getNativeView() != null) {
            this.mDrawLeft = getNativeView().getLeft();
        }
        return this.mDrawLeft;
    }

    public final int getDrawTop() {
        if (this.mDrawTop == 0 && getNativeView() != null) {
            this.mDrawTop = getNativeView().getTop();
        }
        return this.mDrawTop;
    }

    public String getEventAttachedData() {
        return this.mEventAttachedData;
    }

    public int getHeight() {
        return this.mMeasuredHeight;
    }

    public String getName() {
        return this.mName;
    }

    public View getNativeView() {
        return null;
    }

    public ViewBase getParent() {
        Layout layout = this.mParent;
        if (layout == null) {
            return ((IContainer) this.mHolderView.getParent()).getVirtualView();
        }
        return layout;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getUuid() {
        return this.mUuid;
    }

    public String getViewId() {
        return this.mName;
    }

    public String getViewType() {
        return this.mViewType;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        return this.mMeasuredWidth;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final boolean isClickable() {
        if ((this.mFlag & 32) != 0) {
            return true;
        }
        return false;
    }

    public boolean isContainer() {
        return false;
    }

    public boolean isGone() {
        if (this.mVisibility == 8) {
            return true;
        }
        return false;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public final boolean isVisible() {
        if (this.mVisibility == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public final void measureComponent(int i3, int i16) {
        int i17 = this.mAutoDimDirection;
        if (i17 > 0) {
            if (i17 != 1) {
                if (i17 == 2 && 1073741824 == View.MeasureSpec.getMode(i16)) {
                    i3 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i16) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i3)) {
                i16 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i3) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        onComMeasure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onClick() {
        OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onComDraw(Canvas canvas) {
        if (getNativeView() == null) {
            if (this.mBackground != 0) {
                VirtualViewUtils.drawBackground(canvas, this.mBackgroundPaint, this.mMeasuredWidth, this.mMeasuredHeight, this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
                return;
            }
            if (this.mBackgroundImage != null) {
                this.mMatrixBG.setScale(this.mMeasuredWidth / r0.getWidth(), this.mMeasuredHeight / this.mBackgroundImage.getHeight());
                canvas.drawBitmap(this.mBackgroundImage, this.mMatrixBG, this.mBackgroundPaint);
            }
        }
    }

    public void onParseValueFinished() {
        View nativeView = getNativeView();
        if (nativeView != null && softwareRender()) {
            nativeView.setLayerType(1, null);
        }
        if (nativeView != null) {
            float f16 = this.mAlpha;
            if (f16 >= 0.0f && f16 <= 1.001f) {
                nativeView.setAlpha(f16);
            }
        }
    }

    public void refresh() {
        int i3 = this.mDrawLeft;
        int i16 = this.mDrawTop;
        refresh(i3, i16, this.mMeasuredWidth + i3, this.mMeasuredHeight + i16);
    }

    public void reset() {
        this.mContentRect = null;
        this.mIsDrawed = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setAttribute(int i3, Object obj) {
        if (i3 == 63) {
            if (!(obj instanceof JSONArray)) {
                return true;
            }
            setBorderRadiusArray((JSONArray) obj);
            return true;
        }
        if (i3 != 72) {
            return false;
        }
        IProteusDtReporter dtReporter = Proteus.getInstance().getDtReporter();
        if (dtReporter == null) {
            return true;
        }
        String str = (String) JsonUtils.getObjectFromJsonArray(obj, 0);
        if (TextUtils.isEmpty(str)) {
            if (!LogUtil.QLog.isColorLevel()) {
                return true;
            }
            LogUtil.QLog.i(TAG, 2, "setDtElement fail, id can't empty! viewID: " + getViewId());
            return true;
        }
        dtReporter.setDtElementIdWithParams(getNativeView(), str, JsonUtils.covertJsonObjectToMap(JsonUtils.getObjectFromJsonArray(obj, 1)));
        return true;
    }

    public void setBackground(int i3) {
        this.mBackground = i3;
        refresh();
    }

    protected void setBackgroundColor(int i3) {
        this.mBackground = i3;
        View nativeView = getNativeView();
        if (nativeView != null) {
            nativeView.setBackgroundColor(i3);
            return;
        }
        if (this.mBackgroundPaint == null) {
            this.mBackgroundPaint = new Paint();
        }
        this.mBackgroundPaint.setColor(this.mBackground);
    }

    protected void setBackgroundImage(Bitmap bitmap) {
        this.mBackgroundImage = bitmap;
        refresh();
    }

    public void setBorderColor(int i3) {
        this.mBorderColor = i3;
        if (this.mBorderPaint == null) {
            Paint paint = new Paint();
            this.mBorderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
        }
        this.mBorderPaint.setColor(this.mBorderColor);
        refresh();
    }

    public void setBorderWidth(int i3) {
        this.mBorderWidth = i3;
        if (this.mBorderPaint == null) {
            Paint paint = new Paint();
            this.mBorderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
        }
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        refresh();
    }

    public void setClickable(boolean z16) {
        if (z16) {
            this.mFlag |= 32;
        } else {
            this.mFlag &= -33;
        }
        if (getNativeView() != null) {
            getNativeView().setFocusable(false);
            getNativeView().setClickable(z16);
        }
    }

    public final void setComLayoutParams(Layout.Params params) {
        this.mParams = params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setComMeasuredDimension(int i3, int i16) {
        this.mMeasuredWidth = i3;
        this.mMeasuredHeight = i16;
    }

    public final void setHoldView(View view) {
        this.mHolderView = view;
        if (softwareRender()) {
            view.setLayerType(1, null);
        }
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (onClickListener == null) {
            setClickable(false);
            this.mOnClickListener = null;
            return;
        }
        this.mOnClickListener = onClickListener;
        setClickable(true);
        if (getNativeView() != null) {
            getNativeView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ViewBase.this.onClick();
                    if (Proteus.getInstance().getDtReporter() != null) {
                        Proteus.getInstance().getDtReporter().handleProteusViewClick(view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public final boolean setValue(int i3, String str) {
        Layout.Params params;
        View nativeView;
        boolean attribute = setAttribute(i3, str);
        if (!attribute && (params = this.mParams) != null && (attribute = params.setAttribute(i3, str)) && (nativeView = getNativeView()) != null) {
            nativeView.requestLayout();
        }
        return attribute;
    }

    public void setViewType(String str) {
        this.mViewType = str;
    }

    public void setVisibility(int i3) {
        if (this.mVisibility != i3) {
            this.mVisibility = i3;
            if (!changeVisibility()) {
                refresh();
            }
        }
    }

    public boolean shouldDraw() {
        if (this.mVisibility == 0) {
            return true;
        }
        return false;
    }

    public boolean softwareRender() {
        return this.mIsSoftwareRender;
    }

    private void setTag(String str, Object obj) {
        if (this.mKeyedTags == null) {
            this.mKeyedTags = new SimpleArrayMap<>();
        }
        this.mKeyedTags.put(str, obj);
    }

    public Object getTag(String str) {
        SimpleArrayMap<String, Object> simpleArrayMap = this.mKeyedTags;
        if (simpleArrayMap != null) {
            return simpleArrayMap.get(str);
        }
        return null;
    }

    public void refresh(int i3, int i16, int i17, int i18) {
        View view = this.mHolderView;
        if (view != null) {
            view.invalidate(i3, i16, i17, i18);
        } else {
            LogUtil.QLog.d(TAG, 2, "refresh holdView is null");
        }
    }

    public void setBackgroundImage(String str) {
        this.mBackgroundImagePath = str;
        this.mBackgroundImage = null;
        if (this.mBackgroundPaint == null) {
            this.mBackgroundPaint = new Paint();
        }
        if (this.mMatrixBG == null) {
            this.mMatrixBG = new Matrix();
        }
    }

    private boolean setValue(String str, Object obj) {
        return setValue(StringCommon.getStrIdFromString(str), obj);
    }

    private boolean setValue(int i3, Object obj) {
        Layout.Params params;
        if (obj instanceof String) {
            return setValue(i3, (String) obj);
        }
        boolean attribute = setAttribute(i3, obj);
        return (attribute || (params = this.mParams) == null) ? attribute : params.setAttribute(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setAttribute(int i3, String str) {
        if (i3 == 53) {
            return true;
        }
        if (i3 == 62) {
            if ("YES".equals(str)) {
                this.mIsSoftwareRender = true;
                return true;
            }
            this.mIsSoftwareRender = false;
            return true;
        }
        if (i3 != 73) {
            switch (i3) {
                case 7:
                    int rp2px = Utils.rp2px(Double.valueOf(str).doubleValue());
                    this.mPaddingBottom = rp2px;
                    this.mPaddingTop = rp2px;
                    this.mPaddingRight = rp2px;
                    this.mPaddingLeft = rp2px;
                    return true;
                case 8:
                    this.mPaddingLeft = Utils.rp2px(Double.valueOf(str).doubleValue());
                    return true;
                case 9:
                    this.mPaddingRight = Utils.rp2px(Double.valueOf(str).doubleValue());
                    return true;
                case 10:
                    this.mPaddingTop = Utils.rp2px(Double.valueOf(str).doubleValue());
                    return true;
                case 11:
                    this.mPaddingBottom = Utils.rp2px(Double.valueOf(str).doubleValue());
                    return true;
                default:
                    switch (i3) {
                        case 14:
                            setBackgroundColor(Utils.parseColor(str));
                            return true;
                        case 15:
                            this.mBorderWidth = Utils.rp2px(Double.valueOf(str).doubleValue());
                            return true;
                        case 16:
                            this.mBorderColor = Utils.parseColor(str);
                            return true;
                        case 17:
                            int rp2px2 = Utils.rp2px(Double.valueOf(str).doubleValue());
                            this.mBorderRadius = rp2px2;
                            this.mBorderTopLeftRadius = rp2px2;
                            this.mBorderTopRightRadius = rp2px2;
                            this.mBorderBottomLeftRadius = rp2px2;
                            this.mBorderBottomRightRadius = rp2px2;
                            return true;
                        default:
                            switch (i3) {
                                case 36:
                                    this.mClickEvnet = str;
                                    return true;
                                case 37:
                                    if (ParseCommon.VISIBLE.equals(str)) {
                                        setVisibility(0);
                                        return true;
                                    }
                                    setVisibility(8);
                                    return true;
                                case 38:
                                    this.mEventAttachedData = str;
                                    return true;
                                default:
                                    return false;
                            }
                    }
            }
        }
        getNativeView().setContentDescription(str);
        return true;
    }

    public void clearDynamicData() {
    }
}
