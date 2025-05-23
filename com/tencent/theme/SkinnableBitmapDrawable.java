package com.tencent.theme;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SkinnableBitmapDrawable extends Drawable {
    static IPatchRedirector $redirector_ = null;
    private static final int[] BitmapDrawable;
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private static final String TAG = "SkinnableBitmapDrawable";
    private boolean mApplyGravity;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapState mBitmapState;
    private int mBitmapWidth;
    private ColorFilter mDiyColorFilter;
    private final Rect mDstRect;
    private boolean mMutated;
    private boolean mRebuildShader;
    private int mTargetDensity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class BitmapState extends BaseConstantState {
        static IPatchRedirector $redirector_;
        Bitmap mBitmap;
        boolean mBuildFromXml;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        int mTargetDensity;
        Shader.TileMode mTileModeX;
        Shader.TileMode mTileModeY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BitmapState(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
                return;
            }
            this.mGravity = 119;
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mBuildFromXml = false;
            this.mBitmap = bitmap;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new SkinnableBitmapDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.theme.BaseConstantState
        public void reloadTintColor() {
            SkinnableColorStateList loadColorStateList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            SkinData skinData = this.skinData;
            if (skinData == null || skinData.mTintColorResId == 0 || (loadColorStateList = SkinEngine.getInstances().loadColorStateList(this.skinData.mTintColorResId)) == null) {
                return;
            }
            this.mPaint.setColorFilter(new LightingColorFilter(0, loadColorStateList.getDefaultColor()));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new SkinnableBitmapDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) resources);
        }

        BitmapState(BitmapState bitmapState) {
            super(bitmapState);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmapState);
                return;
            }
            this.mGravity = 119;
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mBuildFromXml = false;
            this.mBitmap = bitmapState.mBitmap;
            this.mChangingConfigurations = bitmapState.mChangingConfigurations;
            this.mGravity = bitmapState.mGravity;
            this.mTileModeX = bitmapState.mTileModeX;
            this.mTileModeY = bitmapState.mTileModeY;
            this.mTargetDensity = bitmapState.mTargetDensity;
            this.mPaint = new Paint(bitmapState.mPaint);
            this.mBuildFromXml = bitmapState.mBuildFromXml;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            BitmapDrawable = new int[]{R.attr.src, R.attr.antialias, R.attr.filter, R.attr.dither, R.attr.gravity, R.attr.tileMode};
        }
    }

    SkinnableBitmapDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDstRect = new Rect();
            this.mBitmapState = new BitmapState((Bitmap) null);
        }
    }

    private void computeBitmapSize() {
        updateBitmap();
        int[] iArr = this.mBitmapState.mImageSizeWhenOOM;
        if (iArr != null) {
            this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[0], iArr[2], this.mTargetDensity);
            this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[1], iArr[2], this.mTargetDensity);
        } else {
            this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
            this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitmapState inflateBitmapState(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, AttributeSet attributeSet2, boolean z16) throws XmlPullParserException, IOException {
        int i3;
        int defaultColor;
        Paint paint;
        int defaultColor2;
        int attributeCount = attributeSet.getAttributeCount();
        BitmapState bitmapState = new BitmapState((Bitmap) null);
        bitmapState.skinData = new SkinData();
        bitmapState.mBuildFromXml = true;
        if (resources != null && resources.getDisplayMetrics() != null) {
            bitmapState.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        Paint paint2 = new Paint();
        bitmapState.mPaint = paint2;
        int i16 = 0;
        while (true) {
            float f16 = 0.5f;
            float f17 = 0.0f;
            if (i16 < attributeCount) {
                switch (attributeSet.getAttributeNameResource(i16)) {
                    case R.attr.gravity:
                        bitmapState.mGravity = attributeSet.getAttributeIntValue(i16, 119);
                        break;
                    case R.attr.src:
                        int attributeResourceValue = attributeSet.getAttributeResourceValue(i16, 0);
                        if (attributeResourceValue != 0) {
                            BitmapState bitmapState2 = (BitmapState) SkinEngine.getInstances().loadConstantState(attributeResourceValue);
                            bitmapState.mBitmap = bitmapState2.mBitmap;
                            if (Build.VERSION.SDK_INT <= 23) {
                                bitmapState.mChangingConfigurations = bitmapState2.mChangingConfigurations;
                                bitmapState.mTargetDensity = bitmapState2.mTargetDensity;
                            }
                            if (paint2.getColorFilter() == null && (paint = bitmapState2.mPaint) != null) {
                                paint2.setColorFilter(paint.getColorFilter());
                            }
                            bitmapState.mImageSizeWhenOOM = bitmapState2.mImageSizeWhenOOM;
                            break;
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
                        }
                        break;
                    case R.attr.antialias:
                        paint2.setAntiAlias(attributeSet.getAttributeBooleanValue(i16, paint2.isAntiAlias()));
                        break;
                    case R.attr.filter:
                        paint2.setFilterBitmap(attributeSet.getAttributeBooleanValue(i16, paint2.isFilterBitmap()));
                        break;
                    case R.attr.dither:
                        paint2.setDither(attributeSet.getAttributeBooleanValue(i16, paint2.isDither()));
                        break;
                    case R.attr.tint:
                        int attributeResourceValue2 = attributeSet.getAttributeResourceValue(i16, 0);
                        if (attributeResourceValue2 == 0) {
                            defaultColor2 = attributeSet.getAttributeIntValue(i16, 0);
                            if (defaultColor2 == 0) {
                                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <bitmap> requires a valid color");
                            }
                        } else {
                            SkinnableColorStateList loadColorStateList = SkinEngine.getInstances().loadColorStateList(attributeResourceValue2);
                            bitmapState.skinData.mTintColorResId = attributeResourceValue2;
                            defaultColor2 = loadColorStateList.getDefaultColor();
                        }
                        paint2.setColorFilter(new LightingColorFilter(0, defaultColor2));
                        break;
                    case R.attr.tileMode:
                        int attributeIntValue = attributeSet.getAttributeIntValue(i16, -1);
                        if (attributeIntValue == -1) {
                            break;
                        } else if (attributeIntValue != 0) {
                            if (attributeIntValue != 1) {
                                if (attributeIntValue != 2) {
                                    break;
                                } else {
                                    Shader.TileMode tileMode = Shader.TileMode.MIRROR;
                                    bitmapState.mTileModeX = tileMode;
                                    bitmapState.mTileModeY = tileMode;
                                    break;
                                }
                            } else {
                                Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                                bitmapState.mTileModeX = tileMode2;
                                bitmapState.mTileModeY = tileMode2;
                                break;
                            }
                        } else {
                            Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                            bitmapState.mTileModeX = tileMode3;
                            bitmapState.mTileModeY = tileMode3;
                            break;
                        }
                    case R.attr.alpha:
                        float attributeFloatValue = attributeSet.getAttributeFloatValue(i16, 0.0f);
                        if (attributeFloatValue != 0.0f) {
                            paint2.setAlpha((int) ((attributeFloatValue * 255.0f) + 0.5f));
                            break;
                        } else {
                            break;
                        }
                }
                i16++;
            } else {
                if (attributeSet2 != null) {
                    if (z16) {
                        int attributeCount2 = attributeSet2.getAttributeCount();
                        int i17 = 0;
                        while (i17 < attributeCount2) {
                            switch (attributeSet2.getAttributeNameResource(i17)) {
                                case R.attr.gravity:
                                    bitmapState.mGravity = attributeSet2.getAttributeIntValue(i17, 119);
                                    break;
                                case R.attr.antialias:
                                    paint2.setAntiAlias(attributeSet2.getAttributeBooleanValue(i17, paint2.isAntiAlias()));
                                    break;
                                case R.attr.filter:
                                    paint2.setFilterBitmap(attributeSet2.getAttributeBooleanValue(i17, paint2.isFilterBitmap()));
                                    break;
                                case R.attr.dither:
                                    paint2.setDither(attributeSet2.getAttributeBooleanValue(i17, paint2.isDither()));
                                    break;
                                case R.attr.tint:
                                    int attributeResourceValue3 = attributeSet.getAttributeResourceValue(i17, 0);
                                    if (attributeResourceValue3 == 0) {
                                        defaultColor = attributeSet.getAttributeIntValue(i17, 0);
                                        if (defaultColor == 0) {
                                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <bitmap> requires a valid color");
                                        }
                                    } else {
                                        defaultColor = SkinEngine.getInstances().loadColorStateList(attributeResourceValue3).getDefaultColor();
                                    }
                                    paint2.setColorFilter(new LightingColorFilter(0, defaultColor));
                                    break;
                                case R.attr.tileMode:
                                    int attributeIntValue2 = attributeSet2.getAttributeIntValue(i17, -2);
                                    if (attributeIntValue2 == -2) {
                                        break;
                                    } else if (attributeIntValue2 != -1) {
                                        if (attributeIntValue2 != 0) {
                                            if (attributeIntValue2 != 1) {
                                                if (attributeIntValue2 != 2) {
                                                    break;
                                                } else {
                                                    Shader.TileMode tileMode4 = Shader.TileMode.MIRROR;
                                                    bitmapState.mTileModeX = tileMode4;
                                                    bitmapState.mTileModeY = tileMode4;
                                                    break;
                                                }
                                            } else {
                                                Shader.TileMode tileMode5 = Shader.TileMode.REPEAT;
                                                bitmapState.mTileModeX = tileMode5;
                                                bitmapState.mTileModeY = tileMode5;
                                                break;
                                            }
                                        } else {
                                            Shader.TileMode tileMode6 = Shader.TileMode.CLAMP;
                                            bitmapState.mTileModeX = tileMode6;
                                            bitmapState.mTileModeY = tileMode6;
                                            break;
                                        }
                                    } else {
                                        bitmapState.mTileModeX = null;
                                        bitmapState.mTileModeY = null;
                                        break;
                                    }
                                case R.attr.alpha:
                                    float attributeFloatValue2 = attributeSet.getAttributeFloatValue(i17, f17);
                                    if (attributeFloatValue2 != f17) {
                                        paint2.setAlpha((int) ((attributeFloatValue2 * 255.0f) + f16));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                            i17++;
                            f17 = 0.0f;
                            f16 = 0.5f;
                        }
                    } else {
                        int attributeCount3 = attributeSet2.getAttributeCount();
                        for (int i18 = 0; i18 < attributeCount3; i18++) {
                            String attributeName = attributeSet2.getAttributeName(i18);
                            if ("antialias".equals(attributeName)) {
                                paint2.setAntiAlias(attributeSet2.getAttributeBooleanValue(i18, paint2.isAntiAlias()));
                            } else if ("filter".equals(attributeName)) {
                                paint2.setAntiAlias(attributeSet2.getAttributeBooleanValue(i18, paint2.isAntiAlias()));
                            } else if ("dither".equals(attributeName)) {
                                paint2.setAntiAlias(attributeSet2.getAttributeBooleanValue(i18, paint2.isAntiAlias()));
                            } else if (LayoutAttrDefine.Gravity.Gravity.equals(attributeName)) {
                                String attributeValue = attributeSet2.getAttributeValue(i18);
                                int i19 = 0;
                                for (String str : attributeValue.split("\\|")) {
                                    if ("top".equals(str)) {
                                        i19 |= 48;
                                    } else if ("bottom".equals(str)) {
                                        i19 |= 80;
                                    } else if ("left".equals(str)) {
                                        i19 |= 3;
                                    } else if ("right".equals(str)) {
                                        i19 |= 5;
                                    } else if ("center_vertical".equals(str)) {
                                        i19 |= 16;
                                    } else if ("fill_vertical".equals(str)) {
                                        i19 |= 112;
                                    } else if ("center_horizontal".equals(str)) {
                                        i19 |= 1;
                                    } else if ("fill_horizontal".equals(str)) {
                                        i19 |= 7;
                                    } else if ("center".equals(str)) {
                                        i19 |= 17;
                                    } else if (CanvasView.CUSTOM_ACTION_FILL.equals(str)) {
                                        i19 |= 119;
                                    } else if ("clip_vertical".equals(str)) {
                                        i19 |= 128;
                                    } else if ("clip_horizontal".equals(str)) {
                                        i19 |= 8;
                                    } else {
                                        if ("start".equals(str)) {
                                            i3 = 8388611;
                                        } else {
                                            if (!"end".equals(str)) {
                                                throw new XmlPullParserException("error attribute value: " + attributeValue);
                                            }
                                            i3 = 8388613;
                                        }
                                        i19 |= i3;
                                    }
                                }
                                bitmapState.mGravity = i19;
                            } else if ("tileMode".equals(attributeName)) {
                                String attributeValue2 = attributeSet2.getAttributeValue(i18);
                                if ("clamp".equals(attributeValue2)) {
                                    Shader.TileMode tileMode7 = Shader.TileMode.CLAMP;
                                    bitmapState.mTileModeX = tileMode7;
                                    bitmapState.mTileModeY = tileMode7;
                                } else if ("repeat".equals(attributeValue2)) {
                                    Shader.TileMode tileMode8 = Shader.TileMode.REPEAT;
                                    bitmapState.mTileModeX = tileMode8;
                                    bitmapState.mTileModeY = tileMode8;
                                } else if ("mirror".equals(attributeValue2)) {
                                    Shader.TileMode tileMode9 = Shader.TileMode.MIRROR;
                                    bitmapState.mTileModeX = tileMode9;
                                    bitmapState.mTileModeY = tileMode9;
                                } else if ("disabled".equals(attributeValue2)) {
                                    bitmapState.mTileModeX = null;
                                    bitmapState.mTileModeY = null;
                                } else {
                                    throw new XmlPullParserException("error attribute value: " + attributeValue2);
                                }
                            }
                        }
                    }
                }
                if (bitmapState.mBitmap != null || bitmapState.mImageSizeWhenOOM != null) {
                    return bitmapState;
                }
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
            }
        }
    }

    private void printNonPreMultipliedBitmapsViewInfo(Bitmap bitmap) {
        Drawable.Callback callback;
        if (bitmap != null) {
            try {
                if (!bitmap.isPremultiplied() && bitmap.getConfig() == Bitmap.Config.ARGB_8888 && bitmap.hasAlpha() && (callback = getCallback()) != null && (callback instanceof TextView)) {
                    TextView textView = (TextView) callback;
                    m.b(TAG, 2, "errorTextID:" + textView.getId() + "errorTextString: " + textView.getText().toString(), null);
                }
            } catch (Exception e16) {
                m.b(TAG, 2, e16.toString(), null);
            } catch (NoSuchMethodError e17) {
                m.b(TAG, 2, e17.toString(), null);
            }
        }
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
        } else {
            this.mBitmapHeight = -1;
            this.mBitmapWidth = -1;
        }
    }

    private void updateBitmap() {
        Bitmap bitmap = this.mBitmap;
        BitmapState bitmapState = this.mBitmapState;
        Bitmap bitmap2 = bitmapState.mBitmap;
        if (bitmap != bitmap2) {
            this.mBitmap = bitmap2;
            if (bitmapState.mBuildFromXml) {
                this.mRebuildShader = true;
                this.mApplyGravity = true;
            }
            int[] iArr = bitmapState.mImageSizeWhenOOM;
            if (iArr != null) {
                this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[0], iArr[2], this.mTargetDensity);
                this.mBitmapWidth = BaseConstantState.scaleFromDensity(iArr[1], iArr[2], this.mTargetDensity);
            } else {
                this.mBitmapWidth = bitmap2.getScaledWidth(this.mTargetDensity);
                this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) canvas);
            return;
        }
        updateBitmap();
        BitmapState bitmapState = this.mBitmapState;
        if (bitmapState.mImageSizeWhenOOM == null && (bitmap = this.mBitmap) != null) {
            if (bitmapState.bitmapType == 1) {
                setGravity(48);
                Rect imageDrawnRect = getImageDrawnRect(getBounds());
                if (imageDrawnRect.width() > 0 && imageDrawnRect.height() > 0) {
                    printNonPreMultipliedBitmapsViewInfo(this.mBitmap);
                    canvas.drawBitmap(this.mBitmap, imageDrawnRect, getBounds(), this.mBitmapState.mPaint);
                    return;
                }
                return;
            }
            if (this.mRebuildShader) {
                Shader.TileMode tileMode = bitmapState.mTileModeX;
                Shader.TileMode tileMode2 = bitmapState.mTileModeY;
                if (tileMode == null && tileMode2 == null) {
                    bitmapState.mPaint.setShader(null);
                } else {
                    if (tileMode == null) {
                        tileMode = Shader.TileMode.CLAMP;
                    }
                    if (tileMode2 == null) {
                        tileMode2 = Shader.TileMode.CLAMP;
                    }
                    bitmapState.mPaint.setShader(new BitmapShader(bitmap, tileMode, tileMode2));
                }
                this.mRebuildShader = false;
                copyBounds(this.mDstRect);
            }
            if (bitmapState.mPaint.getShader() == null) {
                if (this.mApplyGravity) {
                    Gravity.apply(bitmapState.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
                    this.mApplyGravity = false;
                }
                printNonPreMultipliedBitmapsViewInfo(bitmap);
                canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, bitmapState.mPaint);
                return;
            }
            if (this.mApplyGravity) {
                this.mDstRect.set(getBounds());
                this.mApplyGravity = false;
            }
            canvas.drawRect(this.mDstRect, bitmapState.mPaint);
        }
    }

    public final Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        updateBitmap();
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (ColorFilter) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mDiyColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.mBitmapState;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mBitmapState.mGravity;
    }

    protected Rect getImageDrawnRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Rect) iPatchRedirector.redirect((short) 27, (Object) this, (Object) rect);
        }
        int height = getBitmap().getHeight();
        int width = getBitmap().getWidth();
        if (rect == null) {
            return new Rect(0, 0, width, height);
        }
        if (rect.width() != 0 && rect.height() != 0) {
            if (rect.height() / rect.width() >= height / width) {
                int width2 = (rect.width() * height) / rect.height();
                int i3 = (int) ((width - width2) * 0.5d);
                return new Rect(i3, 0, width2 + i3, height);
            }
            return new Rect(0, 0, width, (rect.height() * width) / rect.width());
        }
        return rect;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        updateBitmap();
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        updateBitmap();
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        if (this.mBitmapState.mGravity != 119) {
            return -3;
        }
        updateBitmap();
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.mBitmapState.mPaint.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public final Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Paint) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mBitmapState.mPaint;
    }

    public Shader.TileMode getTileModeX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Shader.TileMode) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mBitmapState.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Shader.TileMode) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mBitmapState.mTileModeY;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Drawable) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this;
    }

    public Drawable mutate2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Drawable) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        Drawable newDrawable = new BitmapState(this.mBitmapState).newDrawable();
        if (newDrawable instanceof SkinnableBitmapDrawable) {
            ((SkinnableBitmapDrawable) newDrawable).mMutated = true;
        }
        return newDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.mApplyGravity = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            if (!this.mMutated && (iVar = SkinEngine.getInstances().mSkinLifecycle) != null && iVar.needBlockSetAlpha(this.mBitmapState, i3)) {
                return;
            }
            this.mBitmapState.mPaint.setAlpha(i3);
        }
    }

    public void setAntiAlias(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setAntiAlias(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) colorFilter);
        } else {
            if (!this.mMutated && (iVar = SkinEngine.getInstances().mSkinLifecycle) != null && iVar.needBlockSetColorFilter(this.mBitmapState, colorFilter)) {
                return;
            }
            this.mDiyColorFilter = colorFilter;
            this.mBitmapState.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setFilterBitmap(z16);
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mBitmapState.mGravity = i3;
            this.mApplyGravity = true;
        }
    }

    public void setTargetDensity(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            setTargetDensity(canvas.getDensity());
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) tileMode);
        } else {
            setTileModeXY(tileMode, this.mBitmapState.mTileModeY);
        }
    }

    public void setTileModeXY(Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) tileMode, (Object) tileMode2);
            return;
        }
        BitmapState bitmapState = this.mBitmapState;
        if (bitmapState.mPaint.getShader() == null || bitmapState.mTileModeX != tileMode || bitmapState.mTileModeY != tileMode2) {
            bitmapState.mTileModeX = tileMode;
            bitmapState.mTileModeY = tileMode2;
            this.mRebuildShader = true;
        }
    }

    public final void setTileModeY(Shader.TileMode tileMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) tileMode);
        } else {
            setTileModeXY(this.mBitmapState.mTileModeX, tileMode);
        }
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) displayMetrics);
            return;
        }
        this.mTargetDensity = displayMetrics.densityDpi;
        updateBitmap();
        if (this.mBitmap != null) {
            computeBitmapSize();
        }
    }

    public SkinnableBitmapDrawable(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        BitmapState bitmapState = new BitmapState((Bitmap) null);
        this.mBitmapState = bitmapState;
        bitmapState.mTargetDensity = this.mTargetDensity;
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            i3 = 160;
        }
        this.mTargetDensity = i3;
        updateBitmap();
        if (this.mBitmap != null) {
            computeBitmapSize();
        }
    }

    @Deprecated
    public SkinnableBitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
    }

    public SkinnableBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(new BitmapState(bitmap), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources, (Object) bitmap);
        } else {
            this.mBitmapState.mTargetDensity = this.mTargetDensity;
        }
    }

    @Deprecated
    public SkinnableBitmapDrawable(String str) {
        this(new BitmapState(BitmapFactory.decodeFile(str)), (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (this.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + str);
        }
    }

    public SkinnableBitmapDrawable(Resources resources, String str) {
        this(new BitmapState(BitmapFactory.decodeFile(str)), (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) resources, (Object) str);
            return;
        }
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
        if (this.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + str);
        }
    }

    @Deprecated
    public SkinnableBitmapDrawable(InputStream inputStream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputStream)), (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) inputStream);
        } else if (this.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + inputStream);
        }
    }

    public SkinnableBitmapDrawable(Resources resources, InputStream inputStream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputStream)), (Resources) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) resources, (Object) inputStream);
            return;
        }
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
        if (this.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + inputStream);
        }
    }

    SkinnableBitmapDrawable(BitmapState bitmapState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bitmapState, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        this.mBitmapState = bitmapState;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else if (bitmapState != null) {
            this.mTargetDensity = bitmapState.mTargetDensity;
        } else {
            this.mTargetDensity = 160;
        }
        setBitmap(bitmapState.mBitmap);
        if (bitmapState.mBuildFromXml) {
            this.mRebuildShader = true;
            this.mApplyGravity = true;
        }
    }
}
