package androidx.vectordrawable.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.GuildComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class GuildVectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    public static final String LOGTAG = "GuildVectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private static final SparseIntArray sFlatColor2ColorResIdMap;
    private boolean mAllowCaching;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ReplacedColor {
        int mColor;
        ColorStateList mColorStateList;
        int mResId;

        ReplacedColor(ColorStateList colorStateList, int i3) {
            this.mResId = i3;
            this.mColorStateList = colorStateList;
            this.mColor = colorStateList.getDefaultColor();
        }

        private boolean isStateful() {
            ColorStateList colorStateList = this.mColorStateList;
            if (colorStateList != null && colorStateList.isStateful()) {
                return true;
            }
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            if (isStateful()) {
                ColorStateList colorStateList = this.mColorStateList;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != this.mColor) {
                    this.mColor = colorForState;
                    return true;
                }
            }
            return false;
        }

        public boolean willDraw() {
            if (this.mColor != 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class VClipPath extends VPath {
        VClipPath() {
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, P2VGlobalConfig.KEY_FILL_TYPE, 2, 0);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class VObject {
        VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = GuildVectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                this.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public boolean canReuseBitmap(int i3, int i16) {
            if (i3 == this.mCachedBitmap.getWidth() && i16 == this.mCachedBitmap.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean canReuseCache() {
            if (!this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void createCachedBitmapIfNeeded(int i3, int i16) {
            if (this.mCachedBitmap == null || !canReuseBitmap(i3, i16)) {
                this.mCachedBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.mCachedBitmap, (Rect) null, rect, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                Paint paint = new Paint();
                this.mTempPaint = paint;
                paint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            if (this.mVPathRenderer.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GuildVectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.mVPathRenderer.onStateChanged(iArr);
            this.mCacheDirty |= onStateChanged;
            return onStateChanged;
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(int i3, int i16, ColorFilter colorFilter) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), i3, i16, colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new GuildVectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = GuildVectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sFlatColor2ColorResIdMap = sparseIntArray;
        sparseIntArray.put(Color.parseColor("#0B0C0E"), R.color.qui_common_icon_primary);
        sparseIntArray.put(Color.parseColor("#5E5F62"), R.color.qui_common_icon_secondary);
        sparseIntArray.put(Color.parseColor("#CCCCCC"), R.color.qui_common_icon_tertiary);
        sparseIntArray.put(Color.parseColor("#FFFFFF"), R.color.qui_common_icon_allwhite_primary);
        sparseIntArray.put(Color.parseColor("#2B64F5"), R.color.qui_common_feedback_normal);
        sparseIntArray.put(Color.parseColor("#15D173"), R.color.qui_common_feedback_success);
        sparseIntArray.put(Color.parseColor("#FFB300"), R.color.qui_common_feedback_warning);
        sparseIntArray.put(Color.parseColor("#3E74FF"), R.color.qui_button_bg_primary_default);
        sparseIntArray.put(Color.parseColor("#F8F8F8"), R.color.qui_button_text_primary_default);
    }

    GuildVectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    static int applyAlpha(int i3, float f16) {
        return (i3 & 16777215) | (((int) (Color.alpha(i3) * f16)) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canTint(int i3) {
        if (i3 == -16777215) {
            return true;
        }
        return false;
    }

    @Nullable
    public static GuildVectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        int next;
        try {
            XmlResourceParser xml = resources.getXml(i3);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e16) {
            Log.e(LOGTAG, "parser error", e16);
            return null;
        } catch (XmlPullParserException e17) {
            Log.e(LOGTAG, "parser error", e17);
            return null;
        }
    }

    public static GuildVectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        GuildVectorDrawableCompat guildVectorDrawableCompat = new GuildVectorDrawableCompat();
        guildVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return guildVectorDrawableCompat;
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.mRootGroup);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z16 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vFullPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                    z16 = false;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vGroup2.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (!z16) {
        } else {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean needMirroring() {
        if (isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    private static PorterDuff.Mode parseTintModeCompat(int i3, PorterDuff.Mode mode) {
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 9) {
                    switch (i3) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void printGroupTree(VGroup vGroup, int i3) {
        String str = "";
        for (int i16 = 0; i16 < i3; i16++) {
            str = str + "    ";
        }
        Log.v(LOGTAG, str + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.mRotate);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("matrix is :");
        sb5.append(vGroup.getLocalMatrix().toString());
        Log.v(LOGTAG, sb5.toString());
        for (int i17 = 0; i17 < vGroup.mChildren.size(); i17++) {
            VObject vObject = vGroup.mChildren.get(i17);
            if (vObject instanceof VGroup) {
                printGroupTree((VGroup) vObject, i3 + 1);
            } else {
                ((VPath) vObject).printVPath(i3 + 1);
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        vectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            vectorDrawableCompatState.mTint = namedColorStateList;
        }
        vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
        vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
        vPathRenderer.mViewportHeight = namedFloat;
        if (vPathRenderer.mViewportWidth > 0.0f) {
            if (namedFloat > 0.0f) {
                vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
                float dimension = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
                vPathRenderer.mBaseHeight = dimension;
                if (vPathRenderer.mBaseWidth > 0.0f) {
                    if (dimension > 0.0f) {
                        vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, c.f123400v, 4, vPathRenderer.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            vPathRenderer.mRootName = string;
                            vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.canApplyTheme(drawable);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void clearOverrideStrokeWidth() {
        this.mVectorState.mVPathRenderer.mOverrideStrokeWidth = 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.mTmpBounds.width() * abs));
            int min2 = Math.min(2048, (int) (this.mTmpBounds.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.mTmpBounds;
                canvas.translate(rect.left, rect.top);
                if (needMirroring()) {
                    canvas.translate(this.mTmpBounds.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.createCachedBitmapIfNeeded(min, min2);
                if (!this.mAllowCaching) {
                    this.mVectorState.updateCachedBitmap(min, min2, colorFilter);
                } else if (!this.mVectorState.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(min, min2, colorFilter);
                    this.mVectorState.updateCacheStates();
                }
                this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, null, this.mTmpBounds);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        VPathRenderer vPathRenderer;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState != null && (vPathRenderer = vectorDrawableCompatState.mVPathRenderer) != null) {
            float f16 = vPathRenderer.mBaseWidth;
            if (f16 != 0.0f) {
                float f17 = vPathRenderer.mBaseHeight;
                if (f17 != 0.0f) {
                    float f18 = vPathRenderer.mViewportHeight;
                    if (f18 != 0.0f) {
                        float f19 = vPathRenderer.mViewportWidth;
                        if (f19 != 0.0f) {
                            return Math.min(f19 / f16, f18 / f17);
                        }
                        return 1.0f;
                    }
                    return 1.0f;
                }
                return 1.0f;
            }
            return 1.0f;
        }
        return 1.0f;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    Object getTargetByName(String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful() && ((vectorDrawableCompatState = this.mVectorState) == null || (!vectorDrawableCompatState.isStateful() && ((colorStateList = this.mVectorState.mTint) == null || !colorStateList.isStateful())))) {
            return false;
        }
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z16;
        PorterDuff.Mode mode;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (colorStateList != null && (mode = vectorDrawableCompatState.mTintMode) != null) {
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
            invalidateSelf();
            z16 = true;
        } else {
            z16 = false;
        }
        if (vectorDrawableCompatState.isStateful() && vectorDrawableCompatState.onStateChanged(iArr)) {
            invalidateSelf();
            return true;
        }
        return z16;
    }

    public void profileColor(Resources resources, Resources.Theme theme) {
        profileColor(this.mVectorState.mVPathRenderer.mRootGroup, resources, theme);
        this.mVectorState.mCacheDirty = true;
        invalidateSelf();
    }

    public void replaceWithColorResId(SparseIntArray sparseIntArray, Resources resources, Resources.Theme theme, boolean z16) {
        replaceWithColorResId(this.mVectorState.mVPathRenderer.mRootGroup, sparseIntArray, resources, theme, z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j3) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j3);
        } else {
            super.scheduleSelf(runnable, j3);
        }
    }

    void setAllowCaching(boolean z16) {
        this.mAllowCaching = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i3) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z16) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z16);
        } else {
            this.mVectorState.mAutoMirrored = z16;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z16) {
        super.setFilterBitmap(z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f16, float f17) {
        super.setHotspot(f16, f17);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i16, int i17, int i18) {
        super.setHotspotBounds(i3, i16, i17, i18);
    }

    public void setOverrideStrokeWidth(float f16) {
        this.mVectorState.mVPathRenderer.mOverrideStrokeWidth = f16;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i3) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i3);
        } else {
            setTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z16, z17);
        }
        return super.setVisible(z16, z17);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            GuildVectorDrawableCompat guildVectorDrawableCompat = new GuildVectorDrawableCompat();
            guildVectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return guildVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            GuildVectorDrawableCompat guildVectorDrawableCompat = new GuildVectorDrawableCompat();
            guildVectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return guildVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            GuildVectorDrawableCompat guildVectorDrawableCompat = new GuildVectorDrawableCompat();
            guildVectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return guildVectorDrawableCompat;
        }
    }

    private void replaceWithColorResId(VObject vObject, SparseIntArray sparseIntArray, Resources resources, Resources.Theme theme, boolean z16) {
        if (vObject instanceof VGroup) {
            VGroup vGroup = (VGroup) vObject;
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                replaceWithColorResId(vGroup.mChildren.get(i3), sparseIntArray, resources, theme, z16);
            }
            return;
        }
        if (vObject instanceof VFullPath) {
            VFullPath vFullPath = (VFullPath) vObject;
            GuildComplexColorCompat guildComplexColorCompat = vFullPath.mFillColor;
            if (!guildComplexColorCompat.isGradient() && !guildComplexColorCompat.isStateful()) {
                int i16 = sparseIntArray.get(guildComplexColorCompat.getColor());
                if (i16 != 0) {
                    vFullPath.mReplacedFillColor = new ReplacedColor(resources.getColorStateList(i16, theme), i16);
                } else if (z16) {
                    vFullPath.mReplacedFillColor = null;
                }
            }
            GuildComplexColorCompat guildComplexColorCompat2 = vFullPath.mStrokeColor;
            if (guildComplexColorCompat2.isGradient() || guildComplexColorCompat2.isStateful()) {
                return;
            }
            int i17 = sparseIntArray.get(guildComplexColorCompat2.getColor());
            if (i17 != 0) {
                vFullPath.mReplacedStrokeColor = new ReplacedColor(resources.getColorStateList(i17, theme), i17);
            } else if (z16) {
                vFullPath.mReplacedStrokeColor = null;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mColorFilter = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class VPath extends VObject {
        protected static final int FILL_TYPE_WINDING = 0;
        int mChangingConfigurations;
        int mFillRule;
        protected PathParser.PathDataNode[] mNodes;
        String mPathName;

        public VPath() {
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public String nodesToString(PathParser.PathDataNode[] pathDataNodeArr) {
            String str = " ";
            for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                str = str + pathDataNodeArr[i3].mType + ":";
                for (float f16 : pathDataNodeArr[i3].mParams) {
                    str = str + f16 + ",";
                }
            }
            return str;
        }

        public void printVPath(int i3) {
            String str = "";
            for (int i16 = 0; i16 < i3; i16++) {
                str = str + "    ";
            }
            Log.v(GuildVectorDrawableCompat.LOGTAG, str + "current path is :" + this.mPathName + " pathData is " + nodesToString(this.mNodes));
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.mNodes;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public VPath(VPath vPath) {
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void applyTheme(Resources.Theme theme) {
        }
    }

    private void profileColor(VObject vObject, Resources resources, Resources.Theme theme) {
        if (vObject instanceof VGroup) {
            VGroup vGroup = (VGroup) vObject;
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                profileColor(vGroup.mChildren.get(i3), resources, theme);
            }
            return;
        }
        if (vObject instanceof VFullPath) {
            VFullPath vFullPath = (VFullPath) vObject;
            ReplacedColor replacedColor = vFullPath.mReplacedFillColor;
            if (replacedColor != null) {
                replacedColor.mColorStateList = resources.getColorStateList(replacedColor.mResId, theme);
                ReplacedColor replacedColor2 = vFullPath.mReplacedFillColor;
                replacedColor2.mColor = replacedColor2.mColorStateList.getDefaultColor();
            } else if (vFullPath.mFillColor.isColorStateListFromResId()) {
                vFullPath.mFillColor = GuildComplexColorCompat.from(resources.getColorStateList(vFullPath.mFillColor.getColorResId(), theme), vFullPath.mFillColor.getColorResId());
            }
            ReplacedColor replacedColor3 = vFullPath.mReplacedStrokeColor;
            if (replacedColor3 != null) {
                replacedColor3.mColorStateList = resources.getColorStateList(replacedColor3.mResId, theme);
                ReplacedColor replacedColor4 = vFullPath.mReplacedStrokeColor;
                replacedColor4.mColor = replacedColor4.mColorStateList.getDefaultColor();
            } else if (vFullPath.mStrokeColor.isColorStateListFromResId()) {
                vFullPath.mStrokeColor = GuildComplexColorCompat.from(resources.getColorStateList(vFullPath.mStrokeColor.getColorResId(), theme), vFullPath.mStrokeColor.getColorResId());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
        vectorDrawableCompatState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    GuildVectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class VFullPath extends VPath {
        float mFillAlpha;
        GuildComplexColorCompat mFillColor;
        ReplacedColor mReplacedFillColor;
        ReplacedColor mReplacedStrokeColor;
        float mStrokeAlpha;
        GuildComplexColorCompat mStrokeColor;
        Paint.Cap mStrokeLineCap;
        Paint.Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        VFullPath() {
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        private Paint.Cap getStrokeLineCap(int i3, Paint.Cap cap) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int i3, Paint.Join join) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.mThemeAttrs = null;
            if (!TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                return;
            }
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillColor = ComplexColorUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            Resources resources = typedArray.getResources();
            if (!this.mFillColor.isGradient() && !this.mFillColor.isStateful()) {
                int i3 = GuildVectorDrawableCompat.sFlatColor2ColorResIdMap.get(this.mFillColor.getColor());
                if (i3 != 0) {
                    this.mReplacedFillColor = new ReplacedColor(resources.getColorStateList(i3, theme), i3);
                } else if (this.mFillColor.isColorStateListFromResId()) {
                    this.mFillColor = GuildComplexColorCompat.from(resources.getColorStateList(this.mFillColor.getColorResId(), theme), this.mFillColor.getColorResId());
                }
            }
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            GuildComplexColorCompat namedComplexColor = ComplexColorUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.mStrokeColor = namedComplexColor;
            if (!namedComplexColor.isGradient() && !this.mStrokeColor.isStateful()) {
                int i16 = GuildVectorDrawableCompat.sFlatColor2ColorResIdMap.get(this.mStrokeColor.getColor());
                if (i16 != 0) {
                    this.mReplacedStrokeColor = new ReplacedColor(resources.getColorStateList(i16, theme), i16);
                } else if (this.mStrokeColor.isColorStateListFromResId()) {
                    this.mStrokeColor = GuildComplexColorCompat.from(resources.getColorStateList(this.mStrokeColor.getColorResId(), theme), this.mStrokeColor.getColorResId());
                }
            }
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
            this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, P2VGlobalConfig.KEY_FILL_TYPE, 13, this.mFillRule);
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            if (this.mThemeAttrs != null) {
                return true;
            }
            return false;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        @ColorInt
        int getFillColor() {
            return this.mFillColor.getColor();
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        @ColorInt
        int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VObject
        public boolean isStateful() {
            if (!this.mFillColor.isStateful() && !this.mStrokeColor.isStateful()) {
                return false;
            }
            return true;
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged;
            boolean onStateChanged2;
            ReplacedColor replacedColor = this.mReplacedFillColor;
            if (replacedColor != null) {
                onStateChanged = replacedColor.onStateChanged(iArr);
            } else {
                onStateChanged = this.mFillColor.onStateChanged(iArr);
            }
            boolean z16 = onStateChanged | false;
            ReplacedColor replacedColor2 = this.mReplacedStrokeColor;
            if (replacedColor2 != null) {
                onStateChanged2 = replacedColor2.onStateChanged(iArr);
            } else {
                onStateChanged2 = this.mStrokeColor.onStateChanged(iArr);
            }
            return onStateChanged2 | z16;
        }

        void setFillAlpha(float f16) {
            this.mFillAlpha = f16;
        }

        void setFillColor(int i3) {
            this.mFillColor.setColor(i3);
        }

        void setStrokeAlpha(float f16) {
            this.mStrokeAlpha = f16;
        }

        void setStrokeColor(int i3) {
            this.mStrokeColor.setColor(i3);
        }

        void setStrokeWidth(float f16) {
            this.mStrokeWidth = f16;
        }

        void setTrimPathEnd(float f16) {
            this.mTrimPathEnd = f16;
        }

        void setTrimPathOffset(float f16) {
            this.mTrimPathOffset = f16;
        }

        void setTrimPathStart(float f16) {
            this.mTrimPathStart = f16;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mReplacedStrokeColor = vFullPath.mReplacedStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mReplacedFillColor = vFullPath.mReplacedFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme theme) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = new Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        Boolean mIsStateful;
        float mOverrideStrokeWidth;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mOverrideStrokeWidth = 0.0f;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        private static float cross(float f16, float f17, float f18, float f19) {
            return (f16 * f19) - (f17 * f18);
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i3, int i16, ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            for (int i17 = 0; i17 < vGroup.mChildren.size(); i17++) {
                VObject vObject = vGroup.mChildren.get(i17);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, vGroup.mStackedMatrix, canvas, i3, i16, colorFilter);
                } else if (vObject instanceof VPath) {
                    drawPath(vGroup, (VPath) vObject, canvas, i3, i16, colorFilter);
                }
            }
            canvas.restore();
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i3, int i16, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f16 = i3 / this.mViewportWidth;
            float f17 = i16 / this.mViewportHeight;
            float min = Math.min(f16, f17);
            Matrix matrix = vGroup.mStackedMatrix;
            this.mFinalPathMatrix.set(matrix);
            this.mFinalPathMatrix.postScale(f16, f17);
            float matrixScale = getMatrixScale(matrix);
            if (matrixScale == 0.0f) {
                return;
            }
            vPath.toPath(this.mPath);
            Path path = this.mPath;
            this.mRenderPath.reset();
            if (vPath.isClipPath()) {
                Path path2 = this.mRenderPath;
                if (vPath.mFillRule == 0) {
                    fillType2 = Path.FillType.WINDING;
                } else {
                    fillType2 = Path.FillType.EVEN_ODD;
                }
                path2.setFillType(fillType2);
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                canvas.clipPath(this.mRenderPath);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            float f18 = vFullPath.mTrimPathStart;
            if (f18 != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                float f19 = vFullPath.mTrimPathOffset;
                float f26 = (f18 + f19) % 1.0f;
                float f27 = (vFullPath.mTrimPathEnd + f19) % 1.0f;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                float length = this.mPathMeasure.getLength();
                float f28 = f26 * length;
                float f29 = f27 * length;
                path.reset();
                if (f28 > f29) {
                    this.mPathMeasure.getSegment(f28, length, path, true);
                    this.mPathMeasure.getSegment(0.0f, f29, path, true);
                } else {
                    this.mPathMeasure.getSegment(f28, f29, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            if (vFullPath.mFillColor.willDraw()) {
                GuildComplexColorCompat guildComplexColorCompat = vFullPath.mFillColor;
                if (this.mFillPaint == null) {
                    Paint paint = new Paint(1);
                    this.mFillPaint = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.mFillPaint;
                if (guildComplexColorCompat.isGradient()) {
                    Shader shader = guildComplexColorCompat.getShader();
                    shader.setLocalMatrix(this.mFinalPathMatrix);
                    paint2.setShader(shader);
                    paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    ReplacedColor replacedColor = vFullPath.mReplacedFillColor;
                    if (replacedColor != null) {
                        paint2.setColor(GuildVectorDrawableCompat.applyAlpha(replacedColor.mColor, vFullPath.mFillAlpha));
                    } else {
                        paint2.setColor(GuildVectorDrawableCompat.applyAlpha(guildComplexColorCompat.getColor(), vFullPath.mFillAlpha));
                    }
                }
                if (vFullPath.mReplacedFillColor == null && GuildVectorDrawableCompat.canTint(guildComplexColorCompat.getColor())) {
                    paint2.setColorFilter(colorFilter);
                } else {
                    paint2.setColorFilter(null);
                }
                Path path3 = this.mRenderPath;
                if (vFullPath.mFillRule == 0) {
                    fillType = Path.FillType.WINDING;
                } else {
                    fillType = Path.FillType.EVEN_ODD;
                }
                path3.setFillType(fillType);
                canvas.drawPath(this.mRenderPath, paint2);
            }
            if (vFullPath.mStrokeColor.willDraw()) {
                GuildComplexColorCompat guildComplexColorCompat2 = vFullPath.mStrokeColor;
                if (this.mStrokePaint == null) {
                    Paint paint3 = new Paint(1);
                    this.mStrokePaint = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.mStrokePaint;
                Paint.Join join = vFullPath.mStrokeLineJoin;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = vFullPath.mStrokeLineCap;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                if (guildComplexColorCompat2.isGradient()) {
                    Shader shader2 = guildComplexColorCompat2.getShader();
                    shader2.setLocalMatrix(this.mFinalPathMatrix);
                    paint4.setShader(shader2);
                    paint4.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    ReplacedColor replacedColor2 = vFullPath.mReplacedStrokeColor;
                    if (replacedColor2 != null) {
                        paint4.setColor(GuildVectorDrawableCompat.applyAlpha(replacedColor2.mColor, vFullPath.mStrokeAlpha));
                    } else {
                        paint4.setColor(GuildVectorDrawableCompat.applyAlpha(guildComplexColorCompat2.getColor(), vFullPath.mStrokeAlpha));
                    }
                }
                if (vFullPath.mReplacedStrokeColor == null && GuildVectorDrawableCompat.canTint(guildComplexColorCompat2.getColor())) {
                    paint4.setColorFilter(colorFilter);
                } else {
                    paint4.setColorFilter(null);
                }
                paint4.setStrokeWidth(getStrokeWidth(vFullPath.mStrokeWidth) * min * matrixScale);
                canvas.drawPath(this.mRenderPath, paint4);
            }
        }

        private float getMatrixScale(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float cross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max <= 0.0f) {
                return 0.0f;
            }
            return Math.abs(cross) / max;
        }

        private float getStrokeWidth(float f16) {
            if (f16 == 0.01f) {
                float f17 = this.mOverrideStrokeWidth;
                if (f17 <= 0.0f) {
                    return 0.0f;
                }
                return f17 - 1.0f;
            }
            float f18 = this.mOverrideStrokeWidth;
            if (f18 > 0.0f) {
                return f18;
            }
            return f16;
        }

        public void draw(Canvas canvas, int i3, int i16, ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i3, i16, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public boolean isStateful() {
            if (this.mIsStateful == null) {
                this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
            }
            return this.mIsStateful.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.mRootGroup.onStateChanged(iArr);
        }

        public void setAlpha(float f16) {
            setRootAlpha((int) (f16 * 255.0f));
        }

        public void setRootAlpha(int i3) {
            this.mRootAlpha = i3;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mOverrideStrokeWidth = 0.0f;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
            this.mOverrideStrokeWidth = vPathRenderer.mOverrideStrokeWidth;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class VGroup extends VObject {
        int mChangingConfigurations;
        final ArrayList<VObject> mChildren;
        private String mGroupName;
        final Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        float mRotate;
        private float mScaleX;
        private float mScaleY;
        final Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VPath vClipPath;
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix matrix = new Matrix();
            this.mLocalMatrix = matrix;
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.mLocalMatrix);
            ArrayList<VObject> arrayList = vGroup.mChildren;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                VObject vObject = arrayList.get(i3);
                if (vObject instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vClipPath);
                    String str2 = vClipPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vClipPath);
                    }
                }
            }
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, BasicAnimation.KeyPath.ROTATION, 5, this.mRotate);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, BasicAnimation.KeyPath.SCALE_X, 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, BasicAnimation.KeyPath.SCALE_Y, 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VObject
        public boolean isStateful() {
            for (int i3 = 0; i3 < this.mChildren.size(); i3++) {
                if (this.mChildren.get(i3).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean z16 = false;
            for (int i3 = 0; i3 < this.mChildren.size(); i3++) {
                z16 |= this.mChildren.get(i3).onStateChanged(iArr);
            }
            return z16;
        }

        public void setPivotX(float f16) {
            if (f16 != this.mPivotX) {
                this.mPivotX = f16;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f16) {
            if (f16 != this.mPivotY) {
                this.mPivotY = f16;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f16) {
            if (f16 != this.mRotate) {
                this.mRotate = f16;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f16) {
            if (f16 != this.mScaleX) {
                this.mScaleX = f16;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f16) {
            if (f16 != this.mScaleY) {
                this.mScaleY = f16;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f16) {
            if (f16 != this.mTranslateX) {
                this.mTranslateX = f16;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f16) {
            if (f16 != this.mTranslateY) {
                this.mTranslateY = f16;
                updateLocalMatrix();
            }
        }

        public VGroup() {
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }
    }
}
