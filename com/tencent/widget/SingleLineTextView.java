package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import com.tencent.theme.SkinnableColorStateList;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SingleLineTextView extends View implements Handler.Callback, ISkinSetTypeface {
    static IPatchRedirector $redirector_ = null;
    public static final int EXTEND_TXT_LEFT = 1;
    public static final int EXTEND_TXT_RIGHT = 2;
    public static final int EXTEND_TXT_TIMESTAMP = 0;
    private static final int Icon_Target_Height_For_MsgList_Denoise;
    private static final int Icons_Separator_Drawable_Height;
    private static final int Icons_Separator_Drawable_Padding;
    private static final int Icons_Separator_Drawable_Width;
    private static final int MAX_TXT_LEN = 168;
    private static final int MSG_CHECK_LAYOUT = 1;
    private static final int MSG_INVALIDATE = 2;
    private static final BoringLayout.Metrics UNKNOWN_BORING;
    private static final int VERY_WIDE = 16384;
    private boolean mBlockRelayout;
    private BoringLayout.Metrics mBoring;
    private int mCompoundLeft;
    private int mCompoundRight;
    private int mCurTextColor;
    private int mDefaultTextColor;
    private Drawables mDrawables;
    private TextUtils.TruncateAt mEllipsize;
    private final ExtendText[] mExtendTexts;
    private boolean mForMsgListDenoise;
    private int mGravity;
    private final Handler mHandler;
    private boolean mHorizontallyScrolling;
    private int mIconDrawableGap;
    ArrayList<IconDrawableInfo> mIconDrawableInfos;
    private int mIconDrawablePadding;
    protected IconDrawable[] mIconDrawables;
    private Drawable mIconsSeparatorDrawable;
    private boolean mIncludePad;
    private boolean mIsNoCompoundPaddingRight;
    private boolean mIsShowDrawable;
    private boolean mIsShowTimeStamp;
    protected Layout mLayout;
    private int mMaxWidth;
    private int mOverLengthCutDirection;
    private BoringLayout mSavedLayout;
    private float mSpacingAdd;
    private float mSpacingMult;
    private CharSequence mText;
    private ColorStateList mTextColor;
    private int mTextDesiredWith;
    private final TextPaint mTextPaint;
    private TransformationMethod mTransformation;
    private CharSequence mTransformed;
    private boolean needCheckDrawablesWhenMeasureForMsgListDenoise;
    protected boolean needCheckIconDrawablesWhenMeasure;
    protected boolean needCheckIconDrawablesWhenMeasureForMsgListDenoise;
    private com.tencent.qqnt.classadapter.c nickName;
    private boolean typeFaceSwitch;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Drawables {
        static IPatchRedirector $redirector_;
        final Rect mCompoundRect;
        int mDrawableHeightLeft;
        int mDrawableHeightRight;
        int mDrawableHeightRight2;
        int mDrawableHeightRightExt;
        Drawable mDrawableLeft;
        int mDrawableLeftMarginRight;
        int mDrawablePadding;
        Drawable mDrawableRight;
        Drawable mDrawableRight2;
        int[] mDrawableRight2ExtPosition;
        int[] mDrawableRight2Position;
        Drawable mDrawableRightExt;
        int[] mDrawableRightPosition;
        float mDrawableScaleLeft;
        float mDrawableScaleRight;
        float mDrawableScaleRight2;
        float mDrawableScaleRightExt;
        int mDrawableSizeLeft;
        int mDrawableSizeRight;
        int mDrawableSizeRight2;
        int mDrawableSizeRightExt;

        Drawables() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mCompoundRect = new Rect();
            this.mDrawableScaleLeft = 1.0f;
            this.mDrawableScaleRight = 1.0f;
            this.mDrawableScaleRightExt = 1.0f;
            this.mDrawableScaleRight2 = 1.0f;
            this.mDrawableRightPosition = new int[2];
            this.mDrawableRight2Position = new int[2];
            this.mDrawableRight2ExtPosition = new int[2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ExtendText {
        static IPatchRedirector $redirector_;
        private static boolean mColorStateListErrorReported;
        int mCurTextColor;
        int mDesiredTextHeight;
        int mDesiredTextWidth;
        boolean mEmpty;
        private Paint.FontMetrics mFM;
        int mPadding;
        String mText;
        ColorStateList mTextColor;
        final TextPaint mTextPaint;
        float mTextSize;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55446);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 11)) {
                redirector.redirect((short) 11);
            } else {
                mColorStateListErrorReported = false;
            }
        }

        ExtendText(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources);
                return;
            }
            TextPaint textPaint = new TextPaint(1);
            this.mTextPaint = textPaint;
            textPaint.setTypeface(Typeface.SANS_SERIF);
            textPaint.density = resources.getDisplayMetrics().density;
            this.mPadding = 0;
            ColorStateList valueOf = ColorStateList.valueOf(-7829368);
            this.mTextColor = valueOf;
            this.mCurTextColor = valueOf.getDefaultColor();
            reset();
        }

        public void draw(Canvas canvas, int[] iArr, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, canvas, iArr, Float.valueOf(f16), Float.valueOf(f17));
            } else if (canvas != null) {
                this.mTextPaint.setColor(this.mCurTextColor);
                TextPaint textPaint = this.mTextPaint;
                textPaint.drawableState = iArr;
                canvas.drawText(this.mText, f16, f17, textPaint);
            }
        }

        public int getDesiredHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            if (this.mEmpty) {
                return 0;
            }
            if (this.mDesiredTextHeight < 0) {
                this.mDesiredTextHeight = Math.round(this.mTextPaint.getFontMetricsInt(null));
            }
            return this.mDesiredTextHeight;
        }

        public int getDesiredWith() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (this.mEmpty) {
                return 0;
            }
            if (this.mDesiredTextWidth < 0) {
                this.mDesiredTextWidth = (int) Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint));
            }
            return this.mDesiredTextWidth;
        }

        public Paint.FontMetrics getFontMetrics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Paint.FontMetrics) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            if (this.mFM == null) {
                this.mFM = this.mTextPaint.getFontMetrics();
            }
            return this.mFM;
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            this.mEmpty = true;
            this.mText = "";
            this.mDesiredTextWidth = 0;
            this.mPadding = 0;
        }

        public boolean setTextColor(ColorStateList colorStateList, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) colorStateList, (Object) iArr)).booleanValue();
            }
            if (colorStateList == null) {
                return false;
            }
            this.mTextColor = colorStateList;
            return updateTextColors(iArr);
        }

        public boolean setTextSize(float f16, Context context) {
            Resources resources;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), context)).booleanValue();
            }
            if (Math.abs(this.mTextSize - f16) <= 0.01f) {
                return false;
            }
            this.mTextSize = f16;
            if (context == null) {
                resources = Resources.getSystem();
            } else {
                resources = context.getResources();
            }
            float applyDimension = TypedValue.applyDimension(1, f16, resources.getDisplayMetrics());
            if (applyDimension == this.mTextPaint.getTextSize()) {
                return false;
            }
            this.mTextPaint.setTextSize(applyDimension);
            this.mDesiredTextWidth = -1;
            this.mDesiredTextHeight = -1;
            this.mFM = null;
            return true;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            String str = this.mText;
            if (str == null) {
                return "";
            }
            return str;
        }

        public boolean updateTextColors(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iArr)).booleanValue();
            }
            int colorForState = this.mTextColor.getColorForState(iArr, 0);
            ColorStateList colorStateList = this.mTextColor;
            if (colorStateList instanceof SkinnableColorStateList) {
                if (colorForState == 0) {
                    colorForState = colorStateList.getColorForState(iArr, 0);
                }
                ((SkinnableColorStateList) this.mTextColor).reset();
            }
            if (colorForState == this.mCurTextColor) {
                return false;
            }
            this.mCurTextColor = colorForState;
            this.mTextPaint.setColor(colorForState);
            this.mTextPaint.drawableState = iArr;
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ExtraDynamicLayout extends DynamicLayout {
        static IPatchRedirector $redirector_;

        public ExtraDynamicLayout(CharSequence charSequence, CharSequence charSequence2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i16) {
            super(charSequence, charSequence2, textPaint, i3, alignment, f16, f17, z16, truncateAt, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, charSequence, charSequence2, textPaint, Integer.valueOf(i3), alignment, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i16));
            }
        }

        @Override // android.text.DynamicLayout, android.text.Layout
        public int getParagraphDirection(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ExtraStaticLayout extends StaticLayout {
        static IPatchRedirector $redirector_;

        public ExtraStaticLayout(CharSequence charSequence, TextPaint textPaint, int i3, Layout.Alignment alignment, float f16, float f17, boolean z16) {
            super(charSequence, textPaint, i3, alignment, f16, f17, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, charSequence, textPaint, Integer.valueOf(i3), alignment, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16));
        }

        @Override // android.text.StaticLayout, android.text.Layout
        public int getParagraphDirection(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            return 1;
        }

        public ExtraStaticLayout(CharSequence charSequence, int i3, int i16, TextPaint textPaint, int i17, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i18) {
            super(charSequence, i3, i16, textPaint, i17, alignment, f16, f17, z16, truncateAt, i18);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), textPaint, Integer.valueOf(i17), alignment, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i18));
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class IconDrawable {
        static IPatchRedirector $redirector_;
        boolean can_not_be_hide;
        final Rect mCompoundRect;
        Drawable mDrawable;
        int mDrawableHeight;
        int mDrawableSize;
        float mScale;

        public IconDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mCompoundRect = new Rect();
                this.mScale = 1.0f;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class IconDrawableInfo {
        static IPatchRedirector $redirector_;
        public boolean can_not_be_hide;
        public String iconDynamicUrl;
        public int iconResId;
        public String iconUrl;
        public String icon_static_url;
        public float icon_status_alpha;
        public int markVersion;

        public IconDrawableInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.icon_status_alpha = 1.0f;
            }
        }

        public boolean equals(IconDrawableInfo iconDrawableInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iconDrawableInfo)).booleanValue();
            }
            if (iconDrawableInfo != null && this.iconResId == iconDrawableInfo.iconResId && TextUtils.equals(this.icon_static_url, iconDrawableInfo.icon_static_url) && Math.abs(this.icon_status_alpha - iconDrawableInfo.icon_status_alpha) < 0.001f && TextUtils.equals(this.iconUrl, iconDrawableInfo.iconUrl)) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "markVersion: " + this.markVersion + " iconUrl: " + this.iconUrl + " iconDynamicUrl" + this.iconDynamicUrl + "  icon_static_url" + this.icon_static_url;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface MutualMarkOverLengthCutDirection {
        public static final int CUT_DIRECTION_END = 1;
        public static final int CUT_DIRECTION_START = 0;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55462);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 70)) {
            redirector.redirect((short) 70);
            return;
        }
        UNKNOWN_BORING = new BoringLayout.Metrics();
        Icon_Target_Height_For_MsgList_Denoise = ViewUtils.dpToPx(16.0f);
        Icons_Separator_Drawable_Width = ViewUtils.dpToPx(1.0f);
        Icons_Separator_Drawable_Height = ViewUtils.dpToPx(8.0f);
        Icons_Separator_Drawable_Padding = ViewUtils.dpToPx(4.0f);
    }

    public SingleLineTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void checkForRelayout() {
        int width;
        this.mHandler.removeMessages(1);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width != -2 && (width = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) > 0) {
            int height = this.mLayout.getHeight();
            makeSingleLayout(this.mLayout.getWidth(), UNKNOWN_BORING, width);
            int i3 = layoutParams.height;
            if (i3 != -2 && i3 != -1) {
                invalidate();
                return;
            } else if (this.mLayout.getHeight() == height) {
                invalidate();
                return;
            } else {
                requestLayout();
                invalidate();
                return;
            }
        }
        nullLayouts();
        requestLayout();
        invalidate();
    }

    private boolean checkIfNeedHideSomeIconDrawables(int i3) {
        boolean z16;
        float f16;
        int min;
        IconDrawable[] iconDrawableArr;
        if (this.mForMsgListDenoise) {
            int min2 = Math.min(getDesiredWidth(), (int) Math.ceil(this.mTextPaint.measureText("\u6d4b\u8bd5....")));
            if (i3 >= min2) {
                return false;
            }
            boolean mutualMarkCutForMsgListDenoise = mutualMarkCutForMsgListDenoise(i3, min2);
            refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure();
            refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
            return mutualMarkCutForMsgListDenoise;
        }
        int iconDrawablesWidth = getIconDrawablesWidth();
        if (iconDrawablesWidth > 0) {
            if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isSplitViewMode(getContext()) && getResources().getConfiguration().orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                f16 = 63.0f;
            } else {
                f16 = 105.0f;
            }
            if (iconDrawablesWidth > ViewUtils.dpToPx(f16) && i3 < (min = Math.min(getDesiredWidth(), getResources().getDimensionPixelSize(R.dimen.b5z))) && (iconDrawableArr = this.mIconDrawables) != null) {
                int i16 = this.mOverLengthCutDirection;
                if (i16 != 0) {
                    if (i16 == 1 && mutualMarkCutEndDirection(i3, min, iconDrawableArr)) {
                        return true;
                    }
                } else if (mutualMarkCutStartDirection(i3, min, iconDrawableArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void compoundDrawableUnifyHeightHandle(Drawables drawables, Drawable drawable, Rect rect) {
        float f16;
        int i3;
        int width = rect.width();
        int height = rect.height();
        if (this.mForMsgListDenoise && height != (i3 = Icon_Target_Height_For_MsgList_Denoise)) {
            f16 = i3 / height;
            width = (int) Math.ceil(width * f16);
            height = (int) Math.ceil(r7 * f16);
        } else {
            f16 = 1.0f;
        }
        if (drawable == drawables.mDrawableLeft) {
            drawables.mDrawableSizeLeft = width;
            drawables.mDrawableHeightLeft = height;
            drawables.mDrawableScaleLeft = f16;
            return;
        }
        if (drawable == drawables.mDrawableRight) {
            drawables.mDrawableSizeRight = width;
            drawables.mDrawableHeightRight = height;
            drawables.mDrawableScaleRight = f16;
        } else if (drawable == drawables.mDrawableRightExt) {
            drawables.mDrawableSizeRightExt = width;
            drawables.mDrawableHeightRightExt = height;
            drawables.mDrawableScaleRightExt = f16;
        } else if (drawable == drawables.mDrawableRight2) {
            drawables.mDrawableSizeRight2 = width;
            drawables.mDrawableHeightRight2 = height;
            drawables.mDrawableScaleRight2 = f16;
        }
    }

    private int getDesiredWidth() {
        if (this.mTextDesiredWith < 0) {
            this.mTextDesiredWith = (int) Math.ceil(Layout.getDesiredWidth(this.mTransformed, this.mTextPaint));
        }
        return this.mTextDesiredWith;
    }

    private int getDrawablesWidth() {
        Drawables drawables = this.mDrawables;
        int i3 = 0;
        if (drawables == null) {
            return 0;
        }
        if (drawables.mDrawableLeft != null) {
            i3 = 0 + drawables.mDrawableSizeLeft;
        }
        if (drawables.mDrawableRight != null) {
            i3 += drawables.mDrawableSizeRight;
        }
        if (drawables.mDrawableRightExt != null) {
            i3 += drawables.mDrawableSizeRightExt;
        }
        if (drawables.mDrawableRight2 != null) {
            return i3 + drawables.mDrawableSizeRight2;
        }
        return i3;
    }

    private int getIconDrawablesWidth() {
        int i3;
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        if (iconDrawableArr == null || !this.mIsShowDrawable) {
            return 0;
        }
        boolean z16 = false;
        int i16 = 0;
        for (IconDrawable iconDrawable : iconDrawableArr) {
            if (iconDrawable.mDrawable != null && (i3 = iconDrawable.mDrawableSize) > 0) {
                i16 += this.mIconDrawablePadding + i3;
                z16 = true;
            }
        }
        if (z16) {
            return i16 + this.mIconDrawableGap;
        }
        return i16;
    }

    private int getVerticalOffset() {
        int measuredHeight;
        int height;
        int i3 = this.mGravity & 112;
        Layout layout = this.mLayout;
        if (i3 != 48 && (height = layout.getHeight()) < (measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom())) {
            if (i3 == 80) {
                return measuredHeight - height;
            }
            return (measuredHeight - height) >> 1;
        }
        return 0;
    }

    private Drawable getmIconsSeparatorDrawable() {
        if (this.mIconsSeparatorDrawable == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.qui_icon_single_line_text_view_drawable_separator);
            this.mIconsSeparatorDrawable = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mIconsSeparatorDrawable.getIntrinsicHeight());
                this.mIconsSeparatorDrawable.setState(getDrawableState());
            }
        }
        return this.mIconsSeparatorDrawable;
    }

    private void iconDrawableUnifyHeightHandle(IconDrawable iconDrawable, Rect rect) {
        float f16;
        int i3;
        int width = rect.width();
        int height = rect.height();
        if (this.mForMsgListDenoise && height != (i3 = Icon_Target_Height_For_MsgList_Denoise)) {
            f16 = i3 / height;
            width = (int) Math.ceil(width * f16);
            height = (int) Math.ceil(r6 * f16);
        } else {
            f16 = 1.0f;
        }
        iconDrawable.mDrawableSize = width;
        iconDrawable.mDrawableHeight = height;
        iconDrawable.mScale = f16;
    }

    private void invlidateSpan(Object obj) {
        CharSequence text = getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            int spanStart = spannable.getSpanStart(obj);
            int spanEnd = spannable.getSpanEnd(obj);
            SpanWatcher[] spanWatcherArr = (SpanWatcher[]) spannable.getSpans(spanStart, spanEnd, SpanWatcher.class);
            if (spanWatcherArr != null && spanWatcherArr.length > 0) {
                for (SpanWatcher spanWatcher : spanWatcherArr) {
                    try {
                        spanWatcher.onSpanChanged(spannable, obj, spanStart, spanEnd, spanStart, spanEnd);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SingleLineTextView", 2, "Exception: " + e16.getMessage());
                        }
                    }
                }
            }
        }
    }

    private boolean mIconDrawablesNeedLeftPadding() {
        Drawables drawables;
        boolean z16;
        boolean z17;
        if (!this.mForMsgListDenoise) {
            return false;
        }
        ExtendText extendText = this.mExtendTexts[2];
        if ((extendText != null && !extendText.mEmpty) || (drawables = this.mDrawables) == null) {
            return false;
        }
        if ((drawables.mDrawableRight != null && drawables.mDrawableSizeRight > 0) || ((drawables.mDrawableRightExt != null && drawables.mDrawableSizeRightExt > 0) || (drawables.mDrawableRight2 != null && drawables.mDrawableSizeRight2 > 0))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getIconDrawablesWidth() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || !z17) {
            return false;
        }
        return true;
    }

    private boolean mutualMarkCutEndDirection(int i3, int i16, IconDrawable[] iconDrawableArr) {
        int i17;
        for (IconDrawable iconDrawable : iconDrawableArr) {
            if (iconDrawable != null && iconDrawable.mDrawable != null && !iconDrawable.can_not_be_hide && (i17 = iconDrawable.mDrawableSize) > 0) {
                i3 += i17;
                iconDrawable.mDrawableSize = 0;
                if (i3 >= i16) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean mutualMarkCutForMsgListDenoise(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        if (!this.mForMsgListDenoise) {
            return false;
        }
        Drawables drawables = this.mDrawables;
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        if (drawables == null && iconDrawableArr == null) {
            return false;
        }
        boolean needShowIconsSeparator = needShowIconsSeparator();
        if (iconDrawableArr != null) {
            int i29 = this.mOverLengthCutDirection;
            if (i29 != 0) {
                if (i29 == 1) {
                    for (IconDrawable iconDrawable : iconDrawableArr) {
                        if (iconDrawable != null && iconDrawable.mDrawable != null && (i28 = iconDrawable.mDrawableSize) > 0) {
                            i3 += i28 + this.mIconDrawablePadding;
                            iconDrawable.mDrawableSize = 0;
                            if (i3 >= i16) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                for (int length = iconDrawableArr.length - 1; length >= 0; length--) {
                    IconDrawable iconDrawable2 = iconDrawableArr[length];
                    if (iconDrawable2 != null && iconDrawable2.mDrawable != null && (i27 = iconDrawable2.mDrawableSize) > 0) {
                        i3 += i27 + this.mIconDrawablePadding;
                        iconDrawable2.mDrawableSize = 0;
                        if (i3 >= i16) {
                            return true;
                        }
                    }
                }
            }
        }
        if (needShowIconsSeparator && (i3 = i3 + Icons_Separator_Drawable_Width + Icons_Separator_Drawable_Padding) >= i16) {
            return true;
        }
        if (drawables != null) {
            Drawable drawable = drawables.mDrawableLeft;
            if (drawable != null && (i26 = drawables.mDrawableSizeLeft) > 0) {
                i3 += i26 + drawables.mDrawablePadding + drawables.mDrawableLeftMarginRight;
                drawable.setCallback(null);
                drawables.mDrawableLeft = null;
                drawables.mDrawableHeightLeft = 0;
                drawables.mDrawableSizeLeft = 0;
                drawables.mDrawableScaleLeft = 1.0f;
                if (i3 >= i16) {
                    return true;
                }
            }
            Drawable drawable2 = drawables.mDrawableRightExt;
            if (drawable2 != null && (i19 = drawables.mDrawableSizeRightExt) > 0) {
                i3 += i19 + drawables.mDrawablePadding;
                drawable2.setCallback(null);
                drawables.mDrawableRightExt = null;
                drawables.mDrawableHeightRightExt = 0;
                drawables.mDrawableSizeRightExt = 0;
                drawables.mDrawableScaleRightExt = 1.0f;
                if (i3 >= i16) {
                    return true;
                }
            }
            Drawable drawable3 = drawables.mDrawableRight2;
            if (drawable3 != null && (i18 = drawables.mDrawableSizeRight2) > 0) {
                i3 += i18 + drawables.mDrawablePadding;
                drawable3.setCallback(null);
                drawables.mDrawableRight2 = null;
                drawables.mDrawableHeightRight2 = 0;
                drawables.mDrawableSizeRight2 = 0;
                drawables.mDrawableScaleRight2 = 1.0f;
                if (i3 >= i16) {
                    return true;
                }
            }
            Drawable drawable4 = drawables.mDrawableRight;
            if (drawable4 != null && (i17 = drawables.mDrawableSizeRight) > 0) {
                int i36 = i3 + i17 + drawables.mDrawablePadding;
                drawable4.setCallback(null);
                drawables.mDrawableRight = null;
                drawables.mDrawableHeightRight = 0;
                drawables.mDrawableSizeRight = 0;
                drawables.mDrawableScaleRight = 1.0f;
                if (i36 >= i16) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean mutualMarkCutStartDirection(int i3, int i16, IconDrawable[] iconDrawableArr) {
        int i17;
        for (int length = iconDrawableArr.length - 1; length >= 0; length--) {
            IconDrawable iconDrawable = iconDrawableArr[length];
            if (iconDrawable != null && iconDrawable.mDrawable != null && !iconDrawable.can_not_be_hide && (i17 = iconDrawable.mDrawableSize) > 0) {
                i3 += i17;
                iconDrawable.mDrawableSize = 0;
                if (i3 >= i16) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean needShowIconsSeparator() {
        boolean z16;
        boolean z17;
        boolean z18;
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mDrawableRight != null && drawables.mDrawableSizeRight > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getIconDrawablesWidth() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getmIconsSeparatorDrawable() != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.mForMsgListDenoise && z16 && z17 && z18) {
            return true;
        }
        return false;
    }

    private void nullLayouts() {
        Layout layout = this.mLayout;
        if ((layout instanceof BoringLayout) && this.mSavedLayout == null) {
            this.mSavedLayout = (BoringLayout) layout;
        }
        this.mLayout = null;
    }

    private void refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure() {
        boolean z16 = false;
        if (!this.mForMsgListDenoise) {
            this.needCheckDrawablesWhenMeasureForMsgListDenoise = false;
            return;
        }
        if (getDrawablesWidth() > 0) {
            z16 = true;
        }
        this.needCheckDrawablesWhenMeasureForMsgListDenoise = z16;
    }

    private void refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure() {
        boolean z16 = false;
        if (!this.mForMsgListDenoise) {
            this.needCheckIconDrawablesWhenMeasureForMsgListDenoise = false;
            return;
        }
        if (getIconDrawablesWidth() > 0) {
            z16 = true;
        }
        this.needCheckIconDrawablesWhenMeasureForMsgListDenoise = z16;
    }

    private void updateTextColors() {
        int colorForState = this.mTextColor.getColorForState(getDrawableState(), this.mDefaultTextColor);
        if (colorForState != this.mCurTextColor) {
            this.mCurTextColor = colorForState;
            invalidate();
        }
    }

    protected void drawText(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Drawables drawables;
        int i26;
        int i27;
        int[] iArr;
        int i28;
        int i29;
        int i36;
        int i37;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) canvas);
            return;
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        if (this.mLayout == null) {
            int i38 = ((right - left) - compoundPaddingLeft) - compoundPaddingRight;
            if (i38 < 1) {
                i38 = 0;
            }
            if (this.mHorizontallyScrolling) {
                i37 = 16384;
            } else {
                i37 = i38;
            }
            makeSingleLayout(i37, UNKNOWN_BORING, i38);
        }
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i39 = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
        int lineTop = this.mLayout.getLineTop(1) - this.mLayout.getLineDescent(0);
        if ((this.mGravity & 112) != 48) {
            i3 = getVerticalOffset();
            i16 = getVerticalOffset();
        } else {
            i3 = 0;
            i16 = 0;
        }
        int[] drawableState = getDrawableState();
        Drawables drawables2 = this.mDrawables;
        if (drawables2 != null) {
            i18 = extendedPaddingBottom;
            if (drawables2.mDrawableLeft != null) {
                canvas.save();
                i17 = compoundPaddingTop;
                canvas.translate(getPaddingLeft() + scrollX, scrollY + compoundPaddingTop + ((i39 - drawables2.mDrawableHeightLeft) / 2));
                if (this.mForMsgListDenoise) {
                    float f16 = drawables2.mDrawableScaleLeft;
                    canvas.scale(f16, f16);
                }
                drawables2.mDrawableLeft.draw(canvas);
                canvas.restore();
            } else {
                i17 = compoundPaddingTop;
            }
        } else {
            i17 = compoundPaddingTop;
            i18 = extendedPaddingBottom;
        }
        ExtendText extendText = this.mExtendTexts[1];
        if (extendText != null && !extendText.mEmpty) {
            canvas.save();
            i19 = i39;
            canvas.translate((scrollX + compoundPaddingLeft) - extendText.getDesiredWith(), extendedPaddingTop + i3);
            Paint.FontMetrics fontMetrics = extendText.getFontMetrics();
            float f17 = lineTop;
            drawables = drawables2;
            if (fontMetrics != null) {
                i26 = lineTop;
                if (f17 > getMeasuredHeight() - fontMetrics.bottom) {
                    f17 = (int) (getMeasuredHeight() - fontMetrics.bottom);
                }
            } else {
                i26 = lineTop;
            }
            extendText.draw(canvas, drawableState, 0.0f, f17);
            canvas.restore();
        } else {
            i19 = i39;
            drawables = drawables2;
            i26 = lineTop;
        }
        Layout layout = this.mLayout;
        this.mTextPaint.setColor(this.mCurTextColor);
        this.mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int i46 = compoundPaddingLeft + scrollX;
        canvas.clipRect(i46, extendedPaddingTop + scrollY, ((right - left) - compoundPaddingRight) + scrollX, (r10 - i18) + scrollY);
        float f18 = extendedPaddingTop + i3;
        canvas.translate(compoundPaddingLeft, f18);
        layout.draw(canvas, null, null, i16 - i3);
        canvas.restore();
        int min = i46 + Math.min(getDesiredWidth(), layout.getEllipsizedWidth());
        ExtendText extendText2 = this.mExtendTexts[2];
        if (extendText2 != null && !extendText2.mEmpty) {
            canvas.save();
            int desiredWidth = getDesiredWidth() + 0 + extendText2.mPadding;
            int i47 = (((scrollX + right) - left) - compoundPaddingRight) + 0;
            i29 = extendText2.getDesiredWith() + extendText2.mPadding + 0;
            if (i47 <= desiredWidth) {
                desiredWidth = i47;
            }
            canvas.translate(desiredWidth, f18);
            Paint.FontMetrics fontMetrics2 = extendText2.getFontMetrics();
            i28 = i26;
            float f19 = i28;
            if (fontMetrics2 != null) {
                i27 = min;
                if (f19 > getMeasuredHeight() - fontMetrics2.bottom) {
                    f19 = (int) (extendText2.getDesiredHeight() - fontMetrics2.bottom);
                }
            } else {
                i27 = min;
            }
            iArr = drawableState;
            extendText2.draw(canvas, iArr, 0.0f, f19);
            canvas.restore();
            if (this.mForMsgListDenoise) {
                i27 = extendText2.mPadding + desiredWidth + extendText2.getDesiredWith();
            }
        } else {
            i27 = min;
            iArr = drawableState;
            i28 = i26;
            i29 = 0;
        }
        Drawables drawables3 = drawables;
        if (drawables != null && drawables3.mDrawableRight2 != null) {
            canvas.save();
            int desiredWidth2 = getDesiredWidth() + i29;
            int i48 = drawables3.mDrawablePadding;
            int i49 = desiredWidth2 + i48;
            int i56 = (((scrollX + right) - left) - compoundPaddingRight) + i29 + i48;
            i29 += drawables3.mDrawableSizeRight2 + i48;
            if (i56 <= i49) {
                i49 = i56;
            }
            int i57 = scrollY + i17 + ((i19 - drawables3.mDrawableHeightRight2) / 2);
            canvas.translate(i49, i57);
            if (this.mForMsgListDenoise) {
                float f26 = drawables3.mDrawableScaleRight2;
                canvas.scale(f26, f26);
            }
            int[] iArr2 = drawables3.mDrawableRight2Position;
            iArr2[0] = i49;
            iArr2[1] = i57;
            drawables3.mDrawableRight2.draw(canvas);
            canvas.restore();
            if (this.mForMsgListDenoise) {
                i27 = i49 + drawables3.mDrawableSizeRight2 + drawables3.mDrawablePadding;
            }
        }
        if (drawables3 != null && drawables3.mDrawableRight != null) {
            canvas.save();
            int desiredWidth3 = getDesiredWidth() + i29;
            int i58 = drawables3.mDrawablePadding;
            int i59 = desiredWidth3 + i58;
            int i65 = (((scrollX + right) - left) - compoundPaddingRight) + i29 + i58;
            i29 += drawables3.mDrawableSizeRight + i58;
            if (i65 <= i59) {
                i59 = i65;
            }
            int i66 = scrollY + i17 + ((i19 - drawables3.mDrawableHeightRight) / 2);
            canvas.translate(i59, i66);
            if (this.mForMsgListDenoise) {
                float f27 = drawables3.mDrawableScaleRight;
                canvas.scale(f27, f27);
            }
            int[] iArr3 = drawables3.mDrawableRightPosition;
            iArr3[0] = i59;
            iArr3[1] = i66;
            drawables3.mDrawableRight.draw(canvas);
            canvas.restore();
            if (this.mForMsgListDenoise) {
                i27 = i59 + drawables3.mDrawableSizeRight + drawables3.mDrawablePadding;
            }
        }
        if (drawables3 != null && drawables3.mDrawableRightExt != null) {
            canvas.save();
            int desiredWidth4 = getDesiredWidth() + i29;
            int i67 = drawables3.mDrawablePadding;
            int i68 = desiredWidth4 + i67;
            int i69 = (((scrollX + right) - left) - compoundPaddingRight) + i29 + i67;
            i29 += drawables3.mDrawableSizeRightExt + i67;
            if (i69 <= i68) {
                i68 = i69;
            }
            int i75 = scrollY + i17 + ((i19 - drawables3.mDrawableHeightRightExt) / 2);
            canvas.translate(i68, i75);
            if (this.mForMsgListDenoise) {
                float f28 = drawables3.mDrawableScaleRightExt;
                canvas.scale(f28, f28);
            }
            int[] iArr4 = drawables3.mDrawableRight2ExtPosition;
            iArr4[0] = i68;
            iArr4[1] = i75;
            drawables3.mDrawableRightExt.draw(canvas);
            canvas.restore();
            if (this.mForMsgListDenoise) {
                i27 = i68 + drawables3.mDrawableSizeRightExt + drawables3.mDrawablePadding;
            }
        }
        if (needShowIconsSeparator()) {
            canvas.save();
            int i76 = Icons_Separator_Drawable_Padding;
            int i77 = Icons_Separator_Drawable_Width + i76;
            int desiredWidth5 = getDesiredWidth() + i29 + i76;
            int i78 = (((scrollX + right) - left) - compoundPaddingRight) + i29 + i76;
            if (i78 <= desiredWidth5) {
                desiredWidth5 = i78;
            }
            canvas.translate(desiredWidth5, scrollY + i17 + ((i19 - Icons_Separator_Drawable_Height) / 2));
            Drawable drawable = getmIconsSeparatorDrawable();
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.restore();
            if (this.mForMsgListDenoise) {
                i27 = desiredWidth5 + i77;
            }
        }
        ExtendText extendText3 = this.mExtendTexts[0];
        if (this.mIsShowTimeStamp && extendText3 != null && !extendText3.mEmpty) {
            canvas.save();
            canvas.translate((((scrollX + right) - left) - extendText3.getDesiredWith()) - getPaddingRight(), f18);
            extendText3.draw(canvas, iArr, 0.0f, i28);
            canvas.restore();
            i36 = extendText3.getDesiredWith();
        } else {
            i36 = 0;
        }
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        if (iconDrawableArr != null && this.mIsShowDrawable) {
            if (this.mForMsgListDenoise) {
                if (drawables3 != null && mIconDrawablesNeedLeftPadding()) {
                    i27 += drawables3.mDrawablePadding;
                }
                int i79 = i27;
                for (IconDrawable iconDrawable : iconDrawableArr) {
                    if (iconDrawable.mDrawable != null && iconDrawable.mDrawableSize != 0) {
                        canvas.save();
                        canvas.translate(i79, scrollY + i17 + ((i19 - iconDrawable.mDrawableHeight) / 2));
                        float f29 = iconDrawable.mScale;
                        canvas.scale(f29, f29);
                        iconDrawable.mDrawable.draw(canvas);
                        canvas.restore();
                        i79 += iconDrawable.mDrawableSize + this.mIconDrawablePadding;
                    }
                }
                return;
            }
            int paddingRight = ((((scrollX + right) - left) - i36) - getPaddingRight()) - this.mIconDrawableGap;
            for (int length = iconDrawableArr.length - 1; length >= 0; length--) {
                IconDrawable iconDrawable2 = iconDrawableArr[length];
                if (iconDrawable2.mDrawable != null && iconDrawable2.mDrawableSize != 0) {
                    canvas.save();
                    paddingRight = (paddingRight - this.mIconDrawablePadding) - iconDrawableArr[length].mDrawableSize;
                    canvas.translate(paddingRight, scrollY + i17 + ((i19 - r3.mDrawableHeight) / 2));
                    iconDrawableArr[length].mDrawable.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        super.drawableStateChanged();
        ColorStateList colorStateList = this.mTextColor;
        if (colorStateList != null && colorStateList.isStateful()) {
            updateTextColors();
        }
        int[] drawableState = getDrawableState();
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            Drawable drawable2 = drawables.mDrawableLeft;
            if (drawable2 != null && drawable2.isStateful()) {
                drawables.mDrawableLeft.setState(drawableState);
            }
            Drawable drawable3 = drawables.mDrawableRight;
            if (drawable3 != null && drawable3.isStateful()) {
                drawables.mDrawableRight.setState(drawableState);
            }
            Drawable drawable4 = drawables.mDrawableRightExt;
            if (drawable4 != null && drawable4.isStateful()) {
                drawables.mDrawableRightExt.setState(drawableState);
            }
            Drawable drawable5 = drawables.mDrawableRight2;
            if (drawable5 != null && drawable5.isStateful()) {
                drawables.mDrawableRight2.setState(drawableState);
            }
        }
        if (needShowIconsSeparator() && (drawable = getmIconsSeparatorDrawable()) != null) {
            drawable.setState(drawableState);
        }
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        int i3 = 0;
        if (iconDrawableArr != null && this.mIsShowDrawable) {
            for (IconDrawable iconDrawable : iconDrawableArr) {
                Drawable drawable6 = iconDrawable.mDrawable;
                if (drawable6 != null && drawable6.isStateful()) {
                    iconDrawable.mDrawable.setState(drawableState);
                }
            }
        }
        boolean z16 = false;
        while (true) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i3 >= extendTextArr.length) {
                break;
            }
            ExtendText extendText = extendTextArr[i3];
            if (extendText != null && extendText.updateTextColors(drawableState)) {
                z16 = true;
            }
            i3++;
        }
        if (z16) {
            invalidate();
        }
    }

    public int getCompoundDrawablePadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            return drawables.mDrawablePadding;
        }
        return 0;
    }

    public int getCompoundPaddingBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return getPaddingBottom();
    }

    public int getCompoundPaddingLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        int paddingLeft = getPaddingLeft();
        Drawables drawables = this.mDrawables;
        if (drawables != null && drawables.mDrawableLeft != null) {
            paddingLeft = paddingLeft + drawables.mDrawablePadding + drawables.mDrawableSizeLeft + drawables.mDrawableLeftMarginRight;
        }
        ExtendText extendText = this.mExtendTexts[1];
        if (extendText != null && !extendText.mEmpty) {
            return paddingLeft + extendText.mPadding + extendText.getDesiredWith();
        }
        return paddingLeft;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r6.mIsNoCompoundPaddingRight != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r0 = r0 + (r4 + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r6.mIsNoCompoundPaddingRight != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCompoundPaddingRight() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        int paddingRight = getPaddingRight();
        Drawables drawables = this.mDrawables;
        if (drawables != null && mIconDrawablesNeedLeftPadding()) {
            paddingRight += drawables.mDrawablePadding;
        }
        if (drawables != null && drawables.mDrawableRight != null) {
            if (drawables.mDrawableRightExt != null) {
                i3 = drawables.mDrawablePadding;
                i16 = drawables.mDrawableSizeRight + i3 + i3 + drawables.mDrawableSizeRightExt;
            } else {
                i3 = drawables.mDrawablePadding;
                i16 = drawables.mDrawableSizeRight + i3;
            }
        }
        if (drawables != null && drawables.mDrawableRight2 != null) {
            if (drawables.mDrawableRight != null) {
                paddingRight += drawables.mDrawableSizeRight2 + drawables.mDrawablePadding;
            } else {
                int i17 = drawables.mDrawablePadding;
                paddingRight += drawables.mDrawableSizeRight2 + i17 + i17;
            }
        }
        if (needShowIconsSeparator()) {
            paddingRight += Icons_Separator_Drawable_Width + Icons_Separator_Drawable_Padding;
        }
        ExtendText extendText = this.mExtendTexts[2];
        if (extendText != null && !extendText.mEmpty) {
            paddingRight += extendText.mPadding + extendText.getDesiredWith();
        }
        ExtendText extendText2 = this.mExtendTexts[0];
        if (this.mIsShowTimeStamp && extendText2 != null && !extendText2.mEmpty) {
            paddingRight += extendText2.mPadding + extendText2.getDesiredWith();
        }
        return paddingRight + getIconDrawablesWidth();
    }

    public int getCompoundPaddingTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return getPaddingTop();
    }

    public ColorStateList getExtendTextColor(int i3) {
        ExtendText extendText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
        if (i3 >= 0) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i3 < extendTextArr.length && (extendText = extendTextArr[i3]) != null) {
                return extendText.mTextColor;
            }
        }
        return null;
    }

    public int getExtendTextCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }
        return this.mExtendTexts.length;
    }

    public int getExtendedPaddingBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        if (this.mLayout.getLineCount() <= 1) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int height = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.mLayout.getLineTop(1);
        if (lineTop >= height) {
            return compoundPaddingBottom;
        }
        int i3 = this.mGravity & 112;
        if (i3 == 48) {
            return (compoundPaddingBottom + height) - lineTop;
        }
        if (i3 == 80) {
            return compoundPaddingBottom;
        }
        return compoundPaddingBottom + ((height - lineTop) / 2);
    }

    public int getExtendedPaddingTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        if (this.mLayout.getLineCount() <= 1) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.mLayout.getLineTop(1);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i3 = this.mGravity & 112;
        if (i3 == 48) {
            return compoundPaddingTop;
        }
        if (i3 == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    protected Drawable getIconDrawableWithStatus(Context context, IconDrawableInfo iconDrawableInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Drawable) iPatchRedirector.redirect((short) 34, (Object) this, (Object) context, (Object) iconDrawableInfo);
        }
        return null;
    }

    public int getLineHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        return Math.round((this.mTextPaint.getFontMetricsInt(null) * this.mSpacingMult) + this.mSpacingAdd);
    }

    public final Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Paint) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mTextPaint;
    }

    public Drawable getRightDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Drawable) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            return drawables.mDrawableRight;
        }
        return null;
    }

    public Drawable getRightDrawableExt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Drawable) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            return drawables.mDrawableRightExt;
        }
        return null;
    }

    public final CharSequence getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mText;
    }

    public ColorStateList getTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mTextColor;
    }

    public float getTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.mTextPaint.getTextSize();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                invalidateDrawableDelayed((Drawable) message.obj);
            }
        } else if (this.mLayout != null) {
            checkForRelayout();
        }
        return true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) drawable);
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            Drawables drawables = this.mDrawables;
            int i16 = 0;
            if (drawables != null) {
                if (drawable == drawables.mDrawableLeft) {
                    int compoundPaddingTop = getCompoundPaddingTop();
                    int height = (getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop;
                    scrollX += getPaddingLeft();
                    scrollY += compoundPaddingTop + ((height - drawables.mDrawableHeightLeft) / 2);
                } else {
                    if (drawable == drawables.mDrawableRight) {
                        int[] iArr = drawables.mDrawableRightPosition;
                        scrollX += iArr[0];
                        i3 = iArr[1];
                    } else if (drawable == drawables.mDrawableRightExt) {
                        int[] iArr2 = drawables.mDrawableRight2ExtPosition;
                        scrollX += iArr2[0];
                        i3 = iArr2[1];
                    } else if (drawable == drawables.mDrawableRight2) {
                        int[] iArr3 = drawables.mDrawableRight2Position;
                        scrollX += iArr3[0];
                        i3 = iArr3[1];
                    }
                    scrollY += i3;
                }
            }
            IconDrawable[] iconDrawableArr = this.mIconDrawables;
            if (iconDrawableArr != null && this.mIsShowDrawable) {
                ExtendText extendText = this.mExtendTexts[0];
                int width = (getWidth() - getPaddingRight()) - this.mIconDrawableGap;
                if (this.mIsShowTimeStamp && extendText != null && !extendText.mEmpty) {
                    width -= extendText.getDesiredWith() + extendText.mPadding;
                }
                while (true) {
                    if (i16 >= iconDrawableArr.length) {
                        break;
                    }
                    if (isSameDrawable(drawable, iconDrawableArr[i16])) {
                        Rect rect = iconDrawableArr[i16].mCompoundRect;
                        drawable.copyBounds(rect);
                        iconDrawableUnifyHeightHandle(iconDrawableArr[i16], rect);
                        int compoundPaddingTop2 = getCompoundPaddingTop();
                        int height2 = (getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop2;
                        for (int i17 = i16 + 1; i17 < iconDrawableArr.length; i17++) {
                            IconDrawable iconDrawable = iconDrawableArr[i17];
                            if (iconDrawable.mDrawable != null) {
                                width -= iconDrawable.mDrawableSize - this.mIconDrawablePadding;
                            }
                            scrollX += (width - iconDrawableArr[i16].mDrawableSize) - this.mIconDrawablePadding;
                        }
                        IconDrawable iconDrawable2 = iconDrawableArr[i16];
                        scrollX += (width - iconDrawable2.mDrawableSize) - this.mIconDrawablePadding;
                        scrollY += compoundPaddingTop2 + ((height2 - iconDrawable2.mDrawableHeight) / 2);
                    } else {
                        i16++;
                    }
                }
            }
            if (scrollX == 0 && scrollY == 0) {
                invalidate();
            } else {
                invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            }
            if (ViewCompat.isAttachedToWindow(this)) {
                Message obtainMessage = this.mHandler.obtainMessage(2);
                obtainMessage.obj = drawable;
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(obtainMessage, 100L);
            }
        }
    }

    public void invalidateDrawableDelayed(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) drawable);
            return;
        }
        CharSequence text = getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            IEmoticonSpanRefreshCallback[] iEmoticonSpanRefreshCallbackArr = (IEmoticonSpanRefreshCallback[]) spannable.getSpans(0, spannable.length(), IEmoticonSpanRefreshCallback.class);
            if (iEmoticonSpanRefreshCallbackArr != null && iEmoticonSpanRefreshCallbackArr.length > 0) {
                this.mBlockRelayout = true;
                for (IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback : iEmoticonSpanRefreshCallbackArr) {
                    if (iEmoticonSpanRefreshCallback.getDrawable() == drawable) {
                        invlidateSpan(iEmoticonSpanRefreshCallback);
                    }
                }
                this.mBlockRelayout = false;
            }
        }
    }

    protected boolean isSameDrawable(Drawable drawable, IconDrawable iconDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, (Object) drawable, (Object) iconDrawable)).booleanValue();
        }
        if (drawable == iconDrawable.mDrawable) {
            return true;
        }
        return false;
    }

    protected void makeSingleLayout(int i3, BoringLayout.Metrics metrics, int i16) {
        int i17;
        Layout.Alignment alignment;
        BoringLayout.Metrics metrics2 = metrics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Integer.valueOf(i3), metrics2, Integer.valueOf(i16));
            return;
        }
        if (i3 < 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        int i18 = this.mGravity & 7;
        if (i18 != 1) {
            if (i18 != 5) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
        } else {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        if (this.mText instanceof Spannable) {
            this.mLayout = new ExtraDynamicLayout(this.mText, this.mTransformed, this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, i16);
            return;
        }
        if (metrics2 == UNKNOWN_BORING && (metrics2 = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring)) != null) {
            this.mBoring = metrics2;
        }
        if (metrics2 != null) {
            int i19 = metrics2.width;
            if (i19 <= i17 && i19 <= i16) {
                BoringLayout boringLayout = this.mSavedLayout;
                if (boringLayout != null) {
                    this.mLayout = boringLayout.replaceOrMake(this.mTransformed, this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad);
                } else {
                    this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad);
                }
                this.mSavedLayout = (BoringLayout) this.mLayout;
                return;
            }
            if (i19 <= i17) {
                BoringLayout boringLayout2 = this.mSavedLayout;
                if (boringLayout2 != null) {
                    this.mLayout = boringLayout2.replaceOrMake(this.mTransformed, this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad, this.mEllipsize, i16);
                    return;
                } else {
                    this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad, this.mEllipsize, i16);
                    return;
                }
            }
            CharSequence charSequence = this.mTransformed;
            this.mLayout = new ExtraStaticLayout(charSequence, 0, charSequence.length(), this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, i16);
            return;
        }
        CharSequence charSequence2 = this.mTransformed;
        this.mLayout = new ExtraStaticLayout(charSequence2, 0, charSequence2.length(), this.mTextPaint, i17, alignment2, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, i16);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this);
        } else {
            super.onAttachedToWindow();
            setTypeface(Typeface.SANS_SERIF);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        drawText(canvas);
        com.tencent.qqnt.classadapter.c cVar = this.nickName;
        if (cVar != null && !cVar.k()) {
            int height = getHeight();
            float j3 = this.nickName.j();
            if (height == 0) {
                height = this.nickName.i();
            }
            canvas.saveLayerAlpha(0.0f, 0.0f, j3, height, 255);
            drawText(canvas);
            this.nickName.h(canvas);
            canvas.restore();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r9.needCheckIconDrawablesWhenMeasureForMsgListDenoise == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0099, code lost:
    
        if (checkIfNeedHideSomeIconDrawables(r0) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x009b, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00ab, code lost:
    
        if (checkIfNeedHideSomeIconDrawables(r0) != false) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        int desiredWidth;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        int i26 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        BoringLayout.Metrics metrics = UNKNOWN_BORING;
        if (mode != 1073741824) {
            BoringLayout.Metrics isBoring = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
            if (isBoring != null) {
                this.mBoring = isBoring;
            }
            if (isBoring != null && isBoring != metrics) {
                desiredWidth = isBoring.width;
            } else {
                desiredWidth = getDesiredWidth();
            }
            int max = Math.max(Math.min(desiredWidth + getCompoundPaddingLeft() + getCompoundPaddingRight(), this.mMaxWidth), getSuggestedMinimumWidth());
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, max);
            } else {
                size = max;
            }
            metrics = isBoring;
        }
        int compoundPaddingLeft = (size - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (this.mForMsgListDenoise) {
            refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure();
            refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
            if (!this.needCheckDrawablesWhenMeasureForMsgListDenoise) {
            }
        } else {
            if (this.mIsShowDrawable) {
                if (this.needCheckIconDrawablesWhenMeasure) {
                }
            }
            z16 = false;
        }
        if (z16) {
            compoundPaddingLeft = (size - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (this.mHorizontallyScrolling) {
            i17 = 16384;
        } else {
            i17 = compoundPaddingLeft;
        }
        Layout layout = this.mLayout;
        if (layout == null) {
            makeSingleLayout(i17, metrics, compoundPaddingLeft);
        } else if (layout.getWidth() != i17 || this.mLayout.getEllipsizedWidth() != compoundPaddingLeft) {
            makeSingleLayout(i17, metrics, compoundPaddingLeft);
        }
        if (mode2 != 1073741824) {
            int compoundPaddingTop = getCompoundPaddingTop() + getCompoundPaddingBottom();
            Layout layout2 = this.mLayout;
            if (layout2 != null) {
                int lineCount = layout2.getLineCount();
                if (lineCount <= 1) {
                    i26 = lineCount;
                }
                i18 = this.mLayout.getLineTop(i26);
            } else {
                i18 = 0;
            }
            int i27 = i18 + compoundPaddingTop;
            Drawables drawables = this.mDrawables;
            if (drawables != null) {
                i27 = Math.max(Math.max(i27, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
            }
            IconDrawable[] iconDrawableArr = this.mIconDrawables;
            if (iconDrawableArr != null && this.mIsShowDrawable) {
                for (IconDrawable iconDrawable : iconDrawableArr) {
                    i27 = Math.max(i27, iconDrawable.mDrawableHeight);
                }
            }
            if (i27 == compoundPaddingTop) {
                while (true) {
                    ExtendText[] extendTextArr = this.mExtendTexts;
                    if (i19 >= extendTextArr.length) {
                        break;
                    }
                    ExtendText extendText = extendTextArr[i19];
                    if (extendText != null && !extendText.mEmpty) {
                        i27 = Math.max(i27, extendText.getDesiredHeight());
                    }
                    i19++;
                }
            }
            size2 = Math.max(i27, getSuggestedMinimumHeight());
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
        } else if (!this.mBlockRelayout) {
            super.requestLayout();
        }
    }

    public void resetDefaultTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.mTextColor = ColorStateList.valueOf(this.mDefaultTextColor);
            updateTextColors();
        }
    }

    public void setCompoundDrawablePadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        Drawables drawables = this.mDrawables;
        if (i3 == 0) {
            if (drawables != null) {
                drawables.mDrawablePadding = i3;
            }
        } else {
            if (drawables == null) {
                drawables = new Drawables();
                this.mDrawables = drawables;
            }
            drawables.mDrawablePadding = i3;
        }
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            setCompoundDrawables(drawable, drawable2, null);
        } else {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) drawable, (Object) drawable2);
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i16) {
        Drawables drawables;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 0 && i16 == 0 && (drawables = this.mDrawables) != null && (drawables.mDrawableLeft != null || drawables.mDrawableRight != null)) {
            this.mCompoundLeft = 0;
            this.mCompoundRight = 0;
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null);
        } else {
            if (this.mCompoundLeft == i3 && this.mCompoundRight == i16) {
                return;
            }
            this.mCompoundLeft = i3;
            this.mCompoundRight = i16;
            Resources resources = getContext().getResources();
            setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? resources.getDrawable(i3) : null, i16 != 0 ? resources.getDrawable(i16) : null);
        }
    }

    public void setDefaultTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mDefaultTextColor = i3;
            updateTextColors();
        }
    }

    public void setDrawableRight2(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) drawable);
            return;
        }
        Drawables drawables = this.mDrawables;
        if (drawable == null) {
            if (drawables != null) {
                Drawable drawable2 = drawables.mDrawableRight2;
                if (drawable2 != null) {
                    drawable2.setCallback(null);
                }
                drawables.mDrawableRight2 = null;
                drawables.mDrawableHeightRight2 = 0;
                drawables.mDrawableSizeRight2 = 0;
                drawables.mDrawableScaleRight2 = 1.0f;
            }
        } else {
            if (drawables == null) {
                drawables = new Drawables();
                this.mDrawables = drawables;
            }
            Drawable drawable3 = drawables.mDrawableRight2;
            if (drawable3 != drawable && drawable3 != null) {
                drawable3.setCallback(null);
            }
            drawables.mDrawableRight2 = drawable;
            Rect rect = drawables.mCompoundRect;
            drawable.setState(getDrawableState());
            drawable.copyBounds(rect);
            drawable.setCallback(this);
            compoundDrawableUnifyHeightHandle(drawables, drawable, rect);
        }
        refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure();
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setDrawableRight2WithIntrinsicBounds(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) drawable);
            return;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        setDrawableRight2(drawable);
    }

    public void setExtendText(String str, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str, i3);
            return;
        }
        if (i3 >= 0) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i3 < extendTextArr.length) {
                ExtendText extendText = extendTextArr[i3];
                boolean isEmpty = TextUtils.isEmpty(str);
                if (isEmpty && (extendText == null || extendText.mEmpty)) {
                    return;
                }
                if (isEmpty && extendText != null && !extendText.mEmpty) {
                    extendText.reset();
                } else {
                    z16 = false;
                    if (!isEmpty) {
                        if (extendText == null) {
                            extendText = new ExtendText(getResources());
                            this.mExtendTexts[i3] = extendText;
                        }
                        if (!str.equals(extendText.mText)) {
                            extendText.mText = str;
                            extendText.mDesiredTextWidth = -1;
                            extendText.mEmpty = false;
                        }
                    }
                    if (i3 == 0 && z16) {
                        postInvalidate();
                    }
                    if (!z16 && !this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                        return;
                    }
                }
                z16 = true;
                if (i3 == 0) {
                    postInvalidate();
                }
                if (!z16) {
                }
            }
        }
    }

    public void setExtendTextColor(ColorStateList colorStateList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) colorStateList, i3);
            return;
        }
        if (i3 >= 0) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i3 < extendTextArr.length) {
                ExtendText extendText = extendTextArr[i3];
                if (extendText == null) {
                    extendText = new ExtendText(getResources());
                    this.mExtendTexts[i3] = extendText;
                }
                if (extendText.setTextColor(colorStateList, getDrawableState())) {
                    postInvalidate();
                }
            }
        }
    }

    public void setExtendTextPadding(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 >= 0) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i16 < extendTextArr.length) {
                ExtendText extendText = extendTextArr[i16];
                if (i3 <= 0 && (extendText == null || extendText.mEmpty)) {
                    return;
                }
                if (extendText == null) {
                    extendText = new ExtendText(getResources());
                    this.mExtendTexts[i16] = extendText;
                }
                extendText.mPadding = i3;
            }
        }
    }

    public void setExtendTextSize(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        if (i3 >= 0) {
            ExtendText[] extendTextArr = this.mExtendTexts;
            if (i3 < extendTextArr.length) {
                ExtendText extendText = extendTextArr[i3];
                if (extendText == null) {
                    extendText = new ExtendText(getResources());
                    this.mExtendTexts[i3] = extendText;
                }
                if (extendText.setTextSize(f16, getContext()) && !this.mHandler.hasMessages(1)) {
                    this.mHandler.sendEmptyMessage(1);
                }
            }
        }
    }

    public void setForMsgListDenoise(boolean z16) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
            return;
        }
        if (z16 == this.mForMsgListDenoise) {
            return;
        }
        this.mForMsgListDenoise = z16;
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            setCompoundDrawables(drawables.mDrawableLeft, drawables.mDrawableRight, drawables.mDrawableRightExt);
            setDrawableRight2(this.mDrawables.mDrawableRight2);
        }
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        if (iconDrawableArr != null) {
            ArrayList arrayList = new ArrayList();
            for (IconDrawable iconDrawable : iconDrawableArr) {
                if (iconDrawable != null && (drawable = iconDrawable.mDrawable) != null) {
                    arrayList.add(drawable);
                }
            }
            setIconDrawables((Drawable[]) arrayList.toArray(new Drawable[0]), !arrayList.isEmpty());
        }
        refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure();
        refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setGravity(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        if ((i3 & 7) == 0) {
            i3 |= 3;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        int i16 = i3 & 7;
        int i17 = this.mGravity;
        if (i16 != (i17 & 7)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != i17) {
            invalidate();
        }
        this.mGravity = i3;
        Layout layout = this.mLayout;
        if (layout != null && z16) {
            makeSingleLayout(layout.getWidth(), UNKNOWN_BORING, (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    public void setIconDrawablePadding(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == this.mIconDrawablePadding && i16 == this.mIconDrawableGap) {
            return;
        }
        this.mIconDrawablePadding = i3;
        this.mIconDrawableGap = i16;
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setIconDrawables(Drawable[] drawableArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, drawableArr, Boolean.valueOf(z16));
            return;
        }
        IconDrawable[] iconDrawableArr = this.mIconDrawables;
        if (z16 && drawableArr != null && drawableArr.length != 0) {
            if (iconDrawableArr == null || iconDrawableArr.length != drawableArr.length) {
                int length = drawableArr.length;
                iconDrawableArr = new IconDrawable[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iconDrawableArr[i3] = new IconDrawable();
                }
            }
            int[] drawableState = getDrawableState();
            for (int i16 = 0; i16 < iconDrawableArr.length; i16++) {
                Drawable drawable = iconDrawableArr[i16].mDrawable;
                if (drawable != null && drawable != drawableArr[i16]) {
                    drawable.setCallback(null);
                }
                IconDrawable iconDrawable = iconDrawableArr[i16];
                Drawable drawable2 = drawableArr[i16];
                iconDrawable.mDrawable = drawable2;
                iconDrawable.can_not_be_hide = false;
                Rect rect = iconDrawable.mCompoundRect;
                if (drawable2 != null) {
                    drawable2.setState(drawableState);
                    drawableArr[i16].copyBounds(rect);
                    drawableArr[i16].setCallback(this);
                    iconDrawableUnifyHeightHandle(iconDrawableArr[i16], rect);
                } else {
                    iconDrawable.mDrawableHeight = 0;
                    iconDrawable.mDrawableSize = 0;
                }
            }
            this.mIconDrawables = iconDrawableArr;
            this.needCheckIconDrawablesWhenMeasure = true;
        } else if (iconDrawableArr != null) {
            for (IconDrawable iconDrawable2 : iconDrawableArr) {
                Drawable drawable3 = iconDrawable2.mDrawable;
                if (drawable3 != null) {
                    drawable3.setCallback(null);
                }
                iconDrawable2.mDrawable = null;
                iconDrawable2.mDrawableSize = 0;
                iconDrawable2.mDrawableHeight = 0;
                iconDrawable2.can_not_be_hide = false;
                iconDrawable2.mScale = 1.0f;
            }
            this.mIconDrawables = null;
            this.needCheckIconDrawablesWhenMeasure = false;
        }
        refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setIconDrawablesWithIntrinsicBounds(ArrayList<IconDrawableInfo> arrayList) {
        int i3;
        int i16;
        boolean z16;
        Drawable[] drawableArr;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        ArrayList<IconDrawableInfo> arrayList2 = this.mIconDrawableInfos;
        if (arrayList2 != null) {
            i16 = arrayList2.size();
        } else {
            i16 = 0;
        }
        if (i3 == i16) {
            if (i3 > 0 && arrayList != null && this.mIconDrawableInfos != null) {
                for (int i17 = 0; i17 < i3; i17++) {
                    if (this.mIconDrawableInfos.get(i17).equals(arrayList.get(i17))) {
                    }
                }
            }
            z16 = false;
            if (z16) {
                if (i3 > 0) {
                    drawableArr = new Drawable[i3];
                    z17 = false;
                    for (int i18 = 0; i18 < i3; i18++) {
                        Drawable iconDrawableWithStatus = getIconDrawableWithStatus(getContext(), arrayList.get(i18));
                        drawableArr[i18] = iconDrawableWithStatus;
                        if (iconDrawableWithStatus != null) {
                            z17 = true;
                        }
                    }
                } else {
                    drawableArr = null;
                    z17 = false;
                }
                this.mIconDrawableInfos = arrayList;
                setIconDrawables(drawableArr, z17);
                IconDrawable[] iconDrawableArr = this.mIconDrawables;
                if (iconDrawableArr != null && arrayList != null) {
                    for (int i19 = 0; i19 < iconDrawableArr.length && i19 < arrayList.size(); i19++) {
                        if (iconDrawableArr[i19] != null && arrayList.get(i19) != null) {
                            iconDrawableArr[i19].can_not_be_hide = arrayList.get(i19).can_not_be_hide;
                        }
                    }
                }
            }
            this.needCheckIconDrawablesWhenMeasure = true;
            refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
        }
        z16 = true;
        if (z16) {
        }
        this.needCheckIconDrawablesWhenMeasure = true;
        refreshNeedCheckIconDrawablesForMsgListDenoiseWhenMeasure();
    }

    public void setIncludeFontPadding(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (this.mIncludePad != z16) {
            this.mIncludePad = z16;
        }
    }

    protected void setLayoutChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
        } else {
            this.mHandler.removeMessages(1);
        }
    }

    public void setLeftIconMarginRight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            drawables.mDrawableLeftMarginRight = i3;
        }
    }

    public final void setMaxWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (this.mMaxWidth != i3) {
            this.mMaxWidth = i3;
            requestLayout();
            invalidate();
        }
    }

    public void setNoCompoundPaddingRight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mIsNoCompoundPaddingRight = z16;
        }
    }

    public void setOverLengthCutDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, i3);
        } else {
            this.mOverLengthCutDirection = i3;
        }
    }

    public void setShowIconDrawable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, z16);
            return;
        }
        boolean z17 = this.mIsShowDrawable;
        this.mIsShowDrawable = z16;
        if (z17 != z16 && !this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setShowTimeStamp(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
            return;
        }
        boolean z17 = this.mIsShowTimeStamp;
        this.mIsShowTimeStamp = z16;
        if (z17 != z16 && !this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public final void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (charSequence.equals(this.mText)) {
            return;
        }
        if (charSequence.length() > 168) {
            try {
                charSequence = charSequence.subSequence(0, 168);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        this.mText = charSequence;
        this.mTransformed = this.mTransformation.getTransformation(charSequence, this);
        if (charSequence instanceof Spannable) {
            ((Spannable) charSequence).setSpan(this.mTransformation, 0, charSequence.length(), 18);
        }
        this.mTextDesiredWith = -1;
        if (this.mLayout != null) {
            checkForRelayout();
        }
        getText();
        if (getText() instanceof Spannable) {
            Spannable spannable = (Spannable) getText();
            for (IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback : (IEmoticonSpanRefreshCallback[]) spannable.getSpans(0, spannable.length(), IEmoticonSpanRefreshCallback.class)) {
                Drawable drawable = iEmoticonSpanRefreshCallback.getDrawable();
                if (drawable != null) {
                    drawable.setCallback(this);
                }
            }
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mTextColor = ColorStateList.valueOf(i3);
            updateTextColors();
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            setTextSize(1, f16);
        } else {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.theme.ISkinSetTypeface
    public void setTypeface(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            setTypeface(typeface, true);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) typeface);
        }
    }

    public void startScanning(int i3, int i16, String str, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bool);
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = new com.tencent.qqnt.classadapter.c(i3, i16, str, bool.booleanValue(), this);
        this.nickName = cVar;
        cVar.l(1);
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = this.nickName;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) drawable)).booleanValue();
        }
        return true;
    }

    public SingleLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, drawable, drawable2, drawable3);
            return;
        }
        Drawables drawables = this.mDrawables;
        if ((drawable == null && drawable2 == null) ? false : true) {
            if (drawables == null) {
                drawables = new Drawables();
                this.mDrawables = drawables;
            }
            Drawable drawable4 = drawables.mDrawableLeft;
            if (drawable4 != drawable && drawable4 != null) {
                drawable4.setCallback(null);
            }
            drawables.mDrawableLeft = drawable;
            Drawable drawable5 = drawables.mDrawableRight;
            if (drawable5 != drawable && drawable5 != null) {
                drawable5.setCallback(null);
            }
            drawables.mDrawableRight = drawable2;
            Drawable drawable6 = drawables.mDrawableRightExt;
            if (drawable6 != drawable3 && drawable6 != null) {
                drawable6.setCallback(null);
            }
            drawables.mDrawableRightExt = drawable3;
            Rect rect = drawables.mCompoundRect;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                compoundDrawableUnifyHeightHandle(drawables, drawable, rect);
            } else {
                drawables.mDrawableHeightLeft = 0;
                drawables.mDrawableSizeLeft = 0;
                drawables.mDrawableScaleLeft = 1.0f;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                compoundDrawableUnifyHeightHandle(drawables, drawable2, rect);
            } else {
                drawables.mDrawableHeightRight = 0;
                drawables.mDrawableSizeRight = 0;
                drawables.mDrawableScaleRight = 1.0f;
            }
            if (drawable3 != null) {
                drawable3.setState(drawableState);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                compoundDrawableUnifyHeightHandle(drawables, drawable3, rect);
            } else {
                drawables.mDrawableHeightRightExt = 0;
                drawables.mDrawableSizeRightExt = 0;
                drawables.mDrawableScaleRightExt = 1.0f;
            }
        } else if (drawables != null) {
            if (drawables.mDrawablePadding == 0) {
                this.mDrawables = null;
            } else {
                Drawable drawable7 = drawables.mDrawableLeft;
                if (drawable7 != null) {
                    drawable7.setCallback(null);
                }
                drawables.mDrawableLeft = null;
                Drawable drawable8 = drawables.mDrawableRight;
                if (drawable8 != null) {
                    drawable8.setCallback(null);
                }
                drawables.mDrawableRight = null;
                Drawable drawable9 = drawables.mDrawableRightExt;
                if (drawable9 != null) {
                    drawable9.setCallback(null);
                }
                drawables.mDrawableRightExt = null;
                drawables.mDrawableHeightLeft = 0;
                drawables.mDrawableSizeLeft = 0;
                drawables.mDrawableHeightRight = 0;
                drawables.mDrawableSizeRight = 0;
                drawables.mDrawableHeightRightExt = 0;
                drawables.mDrawableSizeRightExt = 0;
                drawables.mDrawableScaleRightExt = 1.0f;
                drawables.mDrawableScaleRight = 1.0f;
                drawables.mDrawableScaleLeft = 1.0f;
            }
        }
        refreshNeedCheckDrawablesForMsgListDenoiseWhenMeasure();
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void setTextSize(int i3, float f16) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
        if (applyDimension != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(applyDimension);
            this.mTextDesiredWith = -1;
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void setTypeface(Typeface typeface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, typeface, Boolean.valueOf(z16));
            return;
        }
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            if (z16) {
                for (ExtendText extendText : this.mExtendTexts) {
                    if (extendText != null) {
                        extendText.mTextPaint.setTypeface(typeface);
                    }
                }
            }
            this.mTextDesiredWith = -1;
            nullLayouts();
            requestLayout();
            invalidate();
        }
    }

    public SingleLineTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mDefaultTextColor = -16777216;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mOverLengthCutDirection = 1;
        this.mGravity = 16;
        this.mEllipsize = null;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mIncludePad = true;
        this.mIsShowDrawable = true;
        this.mIsShowTimeStamp = true;
        this.needCheckIconDrawablesWhenMeasure = false;
        this.typeFaceSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103098", true);
        this.mForMsgListDenoise = false;
        this.mIconsSeparatorDrawable = null;
        this.needCheckDrawablesWhenMeasureForMsgListDenoise = false;
        this.needCheckIconDrawablesWhenMeasureForMsgListDenoise = false;
        this.mIsNoCompoundPaddingRight = false;
        this.mBlockRelayout = false;
        Resources resources = getResources();
        this.mText = "";
        this.mTransformed = "";
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTypeface(this.typeFaceSwitch ? Typeface.DEFAULT : Typeface.SANS_SERIF);
        textPaint.density = resources.getDisplayMetrics().density;
        this.mTransformation = SingleLineTransformationMethod.getInstance();
        this.mEllipsize = TextUtils.TruncateAt.END;
        this.mHorizontallyScrolling = true;
        this.mTextDesiredWith = -1;
        this.mExtendTexts = new ExtendText[3];
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mCompoundLeft = 0;
        this.mCompoundRight = 0;
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        this.mTextColor = valueOf;
        this.mCurTextColor = valueOf.getDefaultColor();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.H7);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(jj2.b.I7, ViewUtils.dip2px(12.0f));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(jj2.b.J7);
            String string = obtainStyledAttributes.getString(jj2.b.L7);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(jj2.b.K7, Integer.MAX_VALUE);
            textPaint.setTextSize(dimensionPixelSize);
            setTextColor(colorStateList);
            setText(string);
            this.mIncludePad = obtainStyledAttributes.getBoolean(jj2.b.M7, true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) colorStateList);
        } else {
            if (colorStateList == null) {
                return;
            }
            this.mTextColor = colorStateList;
            updateTextColors();
        }
    }

    public void startScanning(int i3, int i16, String str, Boolean bool, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bool, Integer.valueOf(i17));
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = new com.tencent.qqnt.classadapter.c(i3, i16, str, bool.booleanValue(), this);
        this.nickName = cVar;
        cVar.l(i17);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) drawable, (Object) drawable2);
            return;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        setCompoundDrawables(drawable, drawable2);
    }
}
