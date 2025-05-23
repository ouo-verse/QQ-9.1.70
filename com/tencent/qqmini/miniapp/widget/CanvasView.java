package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CanvasView extends CoverView {
    public static final String ACTION_ARC = "arc";
    public static final String ACTION_CLIP = "clip";
    public static final String ACTION_CLOSEPATH = "closePath";
    public static final String ACTION_CLRAERECT = "clearRect";
    public static final String ACTION_CREATE_PATTERN = "createPattern";
    public static final String ACTION_DRAWIMAGE = "drawImage";
    public static final String ACTION_FILLPATH = "fillPath";
    public static final String ACTION_FILLTEXT = "fillText";
    public static final String ACTION_LINER = "linear";
    public static final String ACTION_LINETO = "lineTo";
    public static final String ACTION_MOVETO = "moveTo";
    public static final String ACTION_PUT_IMAGE_DATA = "canvasPutImageData";
    public static final String ACTION_QBEZIER_CURVETO = "bezierCurveTo";
    public static final String ACTION_QUADRATIC_CURVETO = "quadraticCurveTo";
    public static final String ACTION_RADIAL = "radial";
    public static final String ACTION_RECT = "rect";
    public static final String ACTION_RESTORE = "restore";
    public static final String ACTION_ROTATE = "rotate";
    public static final String ACTION_SAVE = "save";
    public static final String ACTION_SCALE = "scale";
    public static final String ACTION_SETGLOBALCOMPOSITEOPERATION = "setGlobalCompositeOperation";
    public static final String ACTION_SET_BASELINE = "setTextBaseline";
    public static final String ACTION_SET_FILLSTYLE = "setFillStyle";
    public static final String ACTION_SET_FONT_FAMILY = "setFontFamily";
    public static final String ACTION_SET_FONT_SIZE = "setFontSize";
    public static final String ACTION_SET_FONT_STYLE = "setFontStyle";
    public static final String ACTION_SET_FONT_WEIGHT = "setFontWeight";
    public static final String ACTION_SET_GLOBALALPHA = "setGlobalAlpha";
    public static final String ACTION_SET_LINECAP = "setLineCap";
    public static final String ACTION_SET_LINEDASH = "setLineDash";
    public static final String ACTION_SET_LINEJOIN = "setLineJoin";
    public static final String ACTION_SET_LINEWIDTH = "setLineWidth";
    public static final String ACTION_SET_MITERLIMIT = "setMiterLimit";
    public static final String ACTION_SET_SHADOW = "setShadow";
    public static final String ACTION_SET_STROKESTYLE = "setStrokeStyle";
    public static final String ACTION_SET_TEXTALIGN = "setTextAlign";
    public static final String ACTION_SET_TRANSFORM = "setTransform";
    public static final String ACTION_STROKEPATH = "strokePath";
    public static final String ACTION_STROKETEXT = "strokeText";
    public static final String ACTION_TRANSFORM = "transform";
    public static final String ACTION_TRANSLATE = "translate";
    public static final String CUSTOM_ACTION_FILL = "fill";
    private static final int DEFAULT_PAINT_COLOR = -16777216;
    private static final int INVALIDATE_TIME_INTERVAL = 16;
    public static final String KEY_CALLBACK_ID = "callbackId";
    public static final String KEY_DATA = "data";
    public static final String KEY_METHOD = "method";
    private static final double REQUEST_IMAGE_MAX_SAFE_SIZE = 8985600.0d;
    private static final String TAG = "CanvasView";
    private HashMap<String, DrawAction> drawActions;
    private ApkgInfo mApkgInfo;
    private int mBitmapH;
    private int mBitmapW;
    private String mCanvasData;
    private int mCanvasId;
    private JSONArray mCurrentDrawActions;
    private float mDensity;
    private Boolean mDisableScroll;
    private final LinkedBlockingQueue<DrawActionCommand> mDrawActionCommandQueue;
    private int mFillColorAlpha;
    private Paint mFillPaint;
    private int mGlobalAlpha;
    private boolean mHasGuesture;
    private boolean mIsAttachedToWindow;
    private long mLastInvalidateTime;
    float mLastOnTouchMoveX;
    float mLastOnTouchMoveY;
    private IMiniAppContext mMiniAppContext;
    private RectF mOffScreenCacheRect;
    Path mPath;
    private long mPendingDrawTaskTime;
    private boolean mRepeatX;
    private boolean mRepeatY;
    private int mSaveBitmapH;
    private int mSaveBitmapW;
    private int mSaveFillColorAlpha;
    private Paint mSaveFillPaint;
    private int mSaveGlobalAlpha;
    private boolean mSaveRepeatX;
    private boolean mSaveRepeatY;
    private int mSaveStrokeColorAlpha;
    private Paint mSaveStrokePaint;
    private String mSaveTextBaseline;
    private IJsService mService;
    private int mStrokeColorAlpha;
    private Paint mStrokePaint;
    private String mTextBaseline;
    private boolean mUseHardwareAccelerate;
    Boolean mVivoEnableSplit;
    private final int mWebViewId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface DrawAction {
        void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DrawActionCommand {
        public JSONArray drawAction;
        public boolean reverse;
        public boolean useHardwareAccelerate;

        public DrawActionCommand() {
        }

        public DrawActionCommand(boolean z16, JSONArray jSONArray, boolean z17) {
            this.reverse = z16;
            this.drawAction = jSONArray;
            this.useHardwareAccelerate = z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class SetFillOrStrokeTextAction implements DrawAction {
        SetFillOrStrokeTextAction() {
        }

        @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            CanvasView.this.setFillOrStrokeText(canvas, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class SetPathOrClipAction implements DrawAction {
        SetPathOrClipAction() {
        }

        @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            CanvasView.this.setPathOrClip(canvas, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class SetStrokeOrFillStyleAction implements DrawAction {
        SetStrokeOrFillStyleAction() {
        }

        @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            CanvasView.this.setStrokeOrFillStyle(str, jSONArray);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class ShadowLayer {
        public int color;

        /* renamed from: dx, reason: collision with root package name */
        public float f346324dx;

        /* renamed from: dy, reason: collision with root package name */
        public float f346325dy;
        public float radius;

        public ShadowLayer() {
        }

        public ShadowLayer copy() {
            return new ShadowLayer(this.radius, this.f346324dx, this.f346325dy, this.color);
        }

        public ShadowLayer(float f16, float f17, float f18, int i3) {
            this.radius = f16;
            this.f346324dx = f17;
            this.f346325dy = f18;
            this.color = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class TransformAction implements DrawAction {
        TransformAction() {
        }

        @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
        public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
            CanvasView.this.transform(canvas, str, jSONArray);
        }
    }

    public CanvasView(IMiniAppContext iMiniAppContext, int i3, IJsService iJsService, ApkgInfo apkgInfo, String str, int i16, boolean z16, Boolean bool, boolean z17) {
        super(iMiniAppContext.getContext());
        this.mDrawActionCommandQueue = new LinkedBlockingQueue<>();
        this.mGlobalAlpha = 255;
        this.mFillColorAlpha = 255;
        this.mStrokeColorAlpha = 255;
        this.mTextBaseline = "normal";
        this.mRepeatX = false;
        this.mRepeatY = false;
        this.mBitmapW = 0;
        this.mBitmapH = 0;
        this.drawActions = new HashMap<>();
        this.mMiniAppContext = iMiniAppContext;
        this.mDensity = DisplayUtil.getDensity(iMiniAppContext.getContext());
        this.mService = iJsService;
        this.mWebViewId = i3;
        this.mApkgInfo = apkgInfo;
        this.mCanvasId = i16;
        Paint paint = new Paint(1);
        this.mFillPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mFillPaint.setColor(-16777216);
        Paint paint2 = new Paint(1);
        this.mStrokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setColor(-16777216);
        this.mDisableScroll = bool;
        this.mHasGuesture = z17;
        this.mCanvasData = str;
        setBackgroundResource(17170445);
        super.setIgnoreTouchEventToJS(true);
        initDrawActions();
    }

    private RectF addPathRect(float f16, float f17, float f18, float f19) {
        int i3;
        float f26;
        float f27;
        RectF rectF = new RectF();
        boolean z16 = this.mRepeatX;
        if ((!z16 && !this.mRepeatY) || ((i3 = this.mBitmapW) == 0 && this.mBitmapH == 0)) {
            rectF.left = f16;
            rectF.top = f17;
            rectF.right = f16 + f18;
            rectF.bottom = f17 + f19;
        } else {
            if (z16) {
                f16 = 0.0f;
            }
            rectF.left = f16;
            boolean z17 = this.mRepeatY;
            if (z17) {
                f17 = 0.0f;
            }
            rectF.top = f17;
            if (z16) {
                f26 = f16 + f18;
            } else {
                f26 = i3;
            }
            rectF.right = f26;
            if (z17) {
                f27 = f17 + f19;
            } else {
                f27 = this.mBitmapH;
            }
            rectF.bottom = f27;
        }
        this.mPath.addRect(rectF, Path.Direction.CW);
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRect(Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        float mpx2px = mpx2px(jSONArray.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(1, 0.0d));
        float mpx2px3 = mpx2px(jSONArray.optDouble(2, 0.0d));
        float mpx2px4 = mpx2px(jSONArray.optDouble(3, 0.0d));
        if (mpx2px3 <= 0.0f) {
            mpx2px += mpx2px3;
            mpx2px3 = -mpx2px3;
        }
        if (mpx2px4 <= 0.0f) {
            mpx2px2 += mpx2px4;
            mpx2px4 = -mpx2px4;
        }
        RectF rectF = new RectF();
        rectF.left = mpx2px;
        rectF.top = mpx2px2;
        rectF.right = mpx2px + mpx2px3;
        rectF.bottom = mpx2px2 + mpx2px4;
        canvas.clipRect(rectF);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compressAndSaveBitmap(int i3, int i16, int i17, int i18, int i19, int i26, Bitmap bitmap, JSONObject jSONObject, Bitmap bitmap2, String str, boolean z16, NativeViewRequestEvent nativeViewRequestEvent) throws IOException {
        FileOutputStream fileOutputStream;
        JSONObject jSONObject2;
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Rect rect = new Rect(0, 0, i19, i26);
        int mpx2pxInt = mpx2pxInt(jSONObject.optDouble(HippyTKDListViewAdapter.X, 0.0d));
        int mpx2pxInt2 = mpx2pxInt(jSONObject.optDouble("y", 0.0d));
        Rect rect2 = new Rect(mpx2pxInt, mpx2pxInt2, mpx2pxInt + i3, mpx2pxInt2 + i16);
        FileOutputStream fileOutputStream2 = null;
        canvas.drawBitmap(bitmap2, rect2, rect, (Paint) null);
        String tmpPath = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getTmpPath(str);
        try {
            fileOutputStream = new FileOutputStream(FileUtils.createFile(tmpPath));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            float f16 = ((i19 * i26) / i17) / i18;
            if (z16) {
                bitmap.compress(Bitmap.CompressFormat.PNG, (int) ((jSONObject.optDouble(CustomImageProps.QUALITY, 1.0d) / f16) * 100.0d), fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, (int) ((jSONObject.optDouble("jpgQuality", 1.0d) / f16) * 100.0d), fileOutputStream);
            }
            try {
                jSONObject2 = new JSONObject();
                jSONObject2.put("tempFilePath", ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath));
            } catch (JSONException e16) {
                e = e16;
            }
            try {
                nativeViewRequestEvent.ok(jSONObject2);
            } catch (JSONException e17) {
                e = e17;
                e.printStackTrace();
                nativeViewRequestEvent.fail();
                fileOutputStream.flush();
                fileOutputStream.close();
                if (bitmap2 == null) {
                } else {
                    return;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (bitmap2 == null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            throw th;
        }
    }

    private Bitmap decodeImage(String str, float f16, float f17, int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        double sqrt;
        options.inDither = true;
        Bitmap bitmap = null;
        if (i17 > 0 && i18 > 0) {
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, false);
                bitmap = newInstance.decodeRegion(getCropRect(i3, i16, i17, i18, options, i19), options);
                newInstance.recycle();
            } catch (Exception e16) {
                QMLog.e(TAG, "bitmapRegionDecoder newInstance exception: " + Log.getStackTraceString(e16));
            }
            return bitmap;
        }
        options.inJustDecodeBounds = false;
        float f18 = options.outWidth;
        float f19 = options.outHeight;
        float sqrt2 = (float) Math.sqrt(((f16 * f17) / r1) / r3);
        if (sqrt2 < 1.0f) {
            f18 *= sqrt2;
            f19 *= sqrt2;
        }
        if (ImageUtil.isPngFile(str)) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            sqrt = Math.sqrt(((REQUEST_IMAGE_MAX_SAFE_SIZE / f18) / f19) / 4.0d);
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            sqrt = Math.sqrt(((REQUEST_IMAGE_MAX_SAFE_SIZE / f18) / f19) / 2.0d);
        }
        float f26 = (float) sqrt;
        if (f26 < 1.0f) {
            options.inSampleSize = ImageUtil.calculateInSampleSize(options, f18 * f26, f19 * f26);
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Throwable unused) {
                QMLog.w(TAG, "getLocalBitmap error with inSampleSize error!try again with lower quality!");
            }
        } else {
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Throwable unused2) {
                QMLog.w(TAG, "getLocalBitmap error! try again with lower quality!");
            }
        }
        return decodeImageQuarter(str, options, bitmap);
    }

    private Bitmap decodeImageQuarter(String str, BitmapFactory.Options options, Bitmap bitmap) {
        if (bitmap == null) {
            int i3 = options.inSampleSize;
            if (i3 > 0) {
                options.inSampleSize = i3 * 2;
            } else {
                options.inSampleSize = 2;
            }
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (Throwable th5) {
                QMLog.e(TAG, "getLocalBitmap 2nd time error!", th5);
                return null;
            }
        }
        return bitmap;
    }

    private void doDraw(Canvas canvas, JSONArray jSONArray) throws Exception {
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            String optString = jSONObject.optString("method");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            DrawAction drawAction = this.drawActions.get(optString);
            if (drawAction != null) {
                drawAction.doAction(canvas, jSONObject, optString, optJSONArray);
            }
        }
        this.mFillPaint.setShader(null);
        this.mFillPaint.setColor(-16777216);
        this.mFillPaint.clearShadowLayer();
        this.mStrokePaint.setShader(null);
        this.mStrokePaint.setColor(-16777216);
        this.mStrokePaint.clearShadowLayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSaveBitmap(final boolean z16, final NativeViewRequestEvent nativeViewRequestEvent, final JSONObject jSONObject, final String str) {
        final Bitmap cacheBitmapFromView = getCacheBitmapFromView(this, z16);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.3
            /* JADX WARN: Removed duplicated region for block: B:32:0x00cf  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00ed A[Catch: all -> 0x010b, TryCatch #2 {all -> 0x010b, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0015, B:10:0x0037, B:13:0x0040, B:14:0x0046, B:16:0x005d, B:19:0x0067, B:20:0x0071, B:25:0x00a9, B:38:0x00ed, B:40:0x00f3, B:45:0x00e2, B:50:0x00c4, B:55:0x009f, B:34:0x00da, B:30:0x00bd, B:22:0x0097), top: B:2:0x0005, inners: #0, #1, #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00f3 A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #2 {all -> 0x010b, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0015, B:10:0x0037, B:13:0x0040, B:14:0x0046, B:16:0x005d, B:19:0x0067, B:20:0x0071, B:25:0x00a9, B:38:0x00ed, B:40:0x00f3, B:45:0x00e2, B:50:0x00c4, B:55:0x009f, B:34:0x00da, B:30:0x00bd, B:22:0x0097), top: B:2:0x0005, inners: #0, #1, #3 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                Bitmap bitmap;
                int i16;
                int i17;
                Bitmap bitmap2;
                try {
                    if (cacheBitmapFromView == null) {
                        QMLog.e(CanvasView.TAG, "canvas save image error!----getCacheBitmapFromView return null!");
                        nativeViewRequestEvent.fail();
                        return;
                    }
                    int mpx2pxInt = CanvasView.this.mpx2pxInt(jSONObject.optDouble("width", 0.0d));
                    int mpx2pxInt2 = CanvasView.this.mpx2pxInt(jSONObject.optDouble("height", 0.0d));
                    if (mpx2pxInt <= 0) {
                        mpx2pxInt = CanvasView.this.getWidth();
                    }
                    int i18 = mpx2pxInt;
                    if (mpx2pxInt2 <= 0) {
                        mpx2pxInt2 = CanvasView.this.getHeight();
                    }
                    int i19 = mpx2pxInt2;
                    int optDouble = (int) jSONObject.optDouble("destWidth", 0.0d);
                    int optDouble2 = (int) jSONObject.optDouble("destHeight", 0.0d);
                    if (optDouble <= 0) {
                        optDouble = CanvasView.this.px2mpxInt(i18);
                    }
                    int i26 = optDouble;
                    if (optDouble2 <= 0) {
                        i3 = CanvasView.this.px2mpxInt(i19);
                    } else {
                        i3 = optDouble2;
                    }
                    QMLog.d(CanvasView.TAG, "----saveBitmap---destWidth: " + i26 + "---destHeight: " + i3);
                    Bitmap.Config config = CanvasView.this.getConfig(z16);
                    try {
                        bitmap = Bitmap.createBitmap(i26, i3, config);
                    } catch (Throwable th5) {
                        QMLog.w(CanvasView.TAG, "saveBitmap() createBitmap error! try again use lower quality!", th5);
                        bitmap = null;
                    }
                    Bitmap bitmap3 = bitmap;
                    if (bitmap3 == null) {
                        float compressRadio = CanvasView.this.getCompressRadio(i26, i3, z16);
                        if (compressRadio < 1.0f) {
                            i16 = (int) (i26 * compressRadio);
                            i17 = (int) (i3 * compressRadio);
                            try {
                                bitmap3 = Bitmap.createBitmap(i16, i17, config);
                            } catch (Throwable th6) {
                                QMLog.w(CanvasView.TAG, "saveBitmap() createBitmap 2nd time error!try again use lower quality!", th6);
                            }
                            if (bitmap3 == null) {
                                i16 = (int) (i16 / 1.4d);
                                i17 = (int) (i17 / 1.4d);
                                try {
                                    bitmap2 = Bitmap.createBitmap(i16, i17, config);
                                } catch (Throwable th7) {
                                    QMLog.e(CanvasView.TAG, "saveBitmap() createBitmap 3rd time error!", th7);
                                }
                                int i27 = i16;
                                int i28 = i17;
                                if (bitmap2 != null) {
                                    CanvasView.this.compressAndSaveBitmap(i18, i19, i26, i3, i27, i28, bitmap2, jSONObject, cacheBitmapFromView, str, z16, nativeViewRequestEvent);
                                    return;
                                } else {
                                    nativeViewRequestEvent.fail();
                                    return;
                                }
                            }
                            bitmap2 = bitmap3;
                            int i272 = i16;
                            int i282 = i17;
                            if (bitmap2 != null) {
                            }
                        }
                    }
                    i16 = i26;
                    i17 = i3;
                    if (bitmap3 == null) {
                    }
                    bitmap2 = bitmap3;
                    int i2722 = i16;
                    int i2822 = i17;
                    if (bitmap2 != null) {
                    }
                } catch (Throwable th8) {
                    QMLog.e(CanvasView.TAG, "canvasToTempFilePath failed: " + Log.getStackTraceString(th8));
                    nativeViewRequestEvent.fail();
                }
            }
        });
    }

    private void drawBitmap(Canvas canvas, String str, float f16, float f17, float f18, float f19, int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        Bitmap decodeImage;
        if (f18 > 0.0f && f19 > 0.0f && (decodeImage = decodeImage(str, f18, f19, i3, i16, i17, i18, options, i19)) != null) {
            if (i19 != 0) {
                decodeImage = ImageUtil.rotaingImageView(i19, decodeImage);
            }
            RectF rectF = new RectF();
            rectF.left = mpx2px(f16);
            rectF.top = mpx2px(f17);
            rectF.right = rectF.left + mpx2px(f18);
            rectF.bottom = rectF.top + mpx2px(f19);
            canvas.drawBitmap(decodeImage, (Rect) null, rectF, (Paint) null);
            decodeImage.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawImage(Canvas canvas, JSONArray jSONArray) {
        int i3;
        String optString = jSONArray.optString(0);
        if (!StringUtil.isEmpty(optString)) {
            optString = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
        }
        String str = optString;
        if (!StringUtil.isEmpty(str)) {
            float optDouble = (float) jSONArray.optDouble(1, 0.0d);
            float optDouble2 = (float) jSONArray.optDouble(2, 0.0d);
            float optDouble3 = (float) jSONArray.optDouble(3, 0.0d);
            float optDouble4 = (float) jSONArray.optDouble(4, 0.0d);
            int optDouble5 = (int) jSONArray.optDouble(5, 0.0d);
            int optDouble6 = (int) jSONArray.optDouble(6, 0.0d);
            int optDouble7 = (int) jSONArray.optDouble(7, 0.0d);
            int optDouble8 = (int) jSONArray.optDouble(8, 0.0d);
            BitmapFactory.Options options = new BitmapFactory.Options();
            int exifOrientation = ImageUtil.getExifOrientation(str);
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (optDouble3 <= 0.0f || optDouble4 <= 0.0f) {
                    if (optDouble7 > 0 && optDouble8 > 0) {
                        optDouble3 = optDouble7;
                        optDouble4 = optDouble8;
                    } else {
                        if (exifOrientation != 90 && exifOrientation != 270) {
                            optDouble3 = options.outWidth;
                            i3 = options.outHeight;
                            optDouble4 = i3;
                        }
                        optDouble3 = options.outHeight;
                        i3 = options.outWidth;
                        optDouble4 = i3;
                    }
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "calculate image size error! " + Log.getStackTraceString(e16));
            }
            drawBitmap(canvas, str, optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6, optDouble7, optDouble8, options, exifOrientation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getCacheBitmapFromView(View view, boolean z16) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        try {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(false);
            view.buildDrawingCache(false);
            if (bitmap == null) {
                int width = view.getWidth();
                int height = view.getHeight();
                if (z16) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = Bitmap.createBitmap(width, height, config);
                view.draw(new Canvas(bitmap));
                return bitmap;
            }
            return bitmap;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getCacheBitmapFromView failed: " + Log.getStackTraceString(th5));
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColor(JSONArray jSONArray) {
        try {
            return Color.argb(jSONArray.optInt(3, 0), jSONArray.optInt(0, 0), jSONArray.optInt(1, 0), jSONArray.optInt(2, 0));
        } catch (Exception e16) {
            QMLog.e(TAG, Log.getStackTraceString(e16));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCompressRadio(int i3, int i16, boolean z16) {
        double sqrt;
        if (z16) {
            sqrt = Math.sqrt(((REQUEST_IMAGE_MAX_SAFE_SIZE / i3) / i16) / 2.0d);
        } else {
            sqrt = Math.sqrt(((REQUEST_IMAGE_MAX_SAFE_SIZE / i3) / i16) / 2.0d);
        }
        return (float) sqrt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap.Config getConfig(boolean z16) {
        if (z16) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGB_565;
    }

    private Rect getCropRect(int i3, int i16, int i17, int i18, BitmapFactory.Options options, int i19) {
        Rect rect = new Rect();
        if (i19 == 90) {
            rect.left = i16;
            int i26 = (options.outHeight - i3) - i17;
            rect.top = i26;
            rect.right = i16 + i18;
            rect.bottom = i26 + i17;
        } else if (i19 == 180) {
            int i27 = (options.outWidth - i3) - i17;
            rect.left = i27;
            int i28 = (options.outHeight - i16) - i18;
            rect.top = i28;
            rect.right = i27 + i17;
            rect.bottom = i28 + i18;
        } else if (i19 == 270) {
            int i29 = (options.outWidth - i16) - i18;
            rect.left = i29;
            rect.top = i3;
            rect.right = i29 + i18;
            rect.bottom = i3 + i17;
        } else {
            rect.left = i3;
            rect.top = i16;
            rect.right = i3 + i17;
            rect.bottom = i16 + i18;
        }
        return rect;
    }

    private Paint getCurrentPaint(String str) {
        if (str != null && str.contains(CUSTOM_ACTION_FILL)) {
            int i3 = this.mGlobalAlpha;
            if (i3 != -1 && i3 < this.mFillColorAlpha) {
                this.mFillPaint.setAlpha(i3);
            } else {
                this.mFillPaint.setAlpha(this.mFillColorAlpha);
            }
            return this.mFillPaint;
        }
        int i16 = this.mGlobalAlpha;
        if (i16 != -1 && i16 < this.mStrokeColorAlpha) {
            this.mStrokePaint.setAlpha(i16);
        } else {
            this.mStrokePaint.setAlpha(this.mStrokeColorAlpha);
        }
        return this.mStrokePaint;
    }

    private int getFontStyleItalic(Typeface typeface) {
        if (typeface != null && typeface.isBold()) {
            return 3;
        }
        return 2;
    }

    private int getFontStyleNormal(Typeface typeface) {
        if (typeface != null && typeface.isBold()) {
            return 1;
        }
        return 0;
    }

    private int getFontWeightBoldStyle(Typeface typeface) {
        if (typeface != null && typeface.isItalic()) {
            return 3;
        }
        return 1;
    }

    private int getFontWeightNormalStyle(Typeface typeface) {
        if (typeface != null && typeface.isItalic()) {
            return 2;
        }
        return 0;
    }

    private IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    private void handleTouchCancel(MotionEvent motionEvent, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, px2mpx(motionEvent.getX()));
            jSONObject2.put("y", px2mpx(motionEvent.getY()));
            jSONObject2.put("id", motionEvent.getPointerId(0));
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("data", this.mCanvasData);
            jSONObject.put("touches", jSONArray);
            evaluateSubcribeJS("onTouchCancel", jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchEvent(MotionEvent motionEvent, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, px2mpx(motionEvent.getX()));
            jSONObject2.put("y", px2mpx(motionEvent.getY()));
            jSONObject2.put("id", motionEvent.getPointerId(0));
            jSONObject.put("data", this.mCanvasData);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject2);
            evaluateSubcribeJS(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchMove(MotionEvent motionEvent, JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                float x16 = motionEvent.getX(i3);
                float y16 = motionEvent.getY(i3);
                if (Math.abs(x16 - this.mLastOnTouchMoveX) >= 0.5d || Math.abs(y16 - this.mLastOnTouchMoveY) >= 0.5d) {
                    this.mLastOnTouchMoveX = x16;
                    this.mLastOnTouchMoveY = y16;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(HippyTKDListViewAdapter.X, px2mpx(x16));
                    jSONObject2.put("y", px2mpx(y16));
                    jSONObject2.put("id", motionEvent.getPointerId(i3));
                    jSONArray.mo162put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", this.mCanvasData);
                jSONObject.put("touches", jSONArray);
                evaluateSubcribeJS("onTouchMove", jSONObject.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchPointerEvent(MotionEvent motionEvent, JSONObject jSONObject, String str) {
        try {
            int actionIndex = motionEvent.getActionIndex();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HippyTKDListViewAdapter.X, px2mpx(motionEvent.getX(actionIndex)));
            jSONObject2.put("y", px2mpx(motionEvent.getY(actionIndex)));
            jSONObject2.put("id", motionEvent.getPointerId(actionIndex));
            jSONObject.put("data", this.mCanvasData);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject2);
            evaluateSubcribeJS(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void initDrawActions() {
        this.drawActions.put(ACTION_DRAWIMAGE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.4
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.drawImage(canvas, jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_STROKESTYLE, new SetStrokeOrFillStyleAction());
        this.drawActions.put(ACTION_SET_FILLSTYLE, new SetStrokeOrFillStyleAction());
        this.drawActions.put(ACTION_STROKEPATH, new SetPathOrClipAction());
        this.drawActions.put(ACTION_FILLPATH, new SetPathOrClipAction());
        this.drawActions.put("clip", new SetPathOrClipAction());
        this.drawActions.put(ACTION_SET_FONT_SIZE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.5
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                float mpx2px = CanvasView.this.mpx2px(jSONArray.optDouble(0, 0.0d));
                CanvasView.this.mFillPaint.setTextSize(mpx2px);
                CanvasView.this.mStrokePaint.setTextSize(mpx2px);
            }
        });
        this.drawActions.put(ACTION_SET_FONT_STYLE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.6
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setFontStyle(jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_FONT_WEIGHT, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.7
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setFontWeight(jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_FONT_FAMILY, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.8
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                int i3;
                int i16 = 0;
                String optString = jSONArray.optString(0);
                Typeface typeface = CanvasView.this.mFillPaint.getTypeface();
                if (typeface != null) {
                    i3 = typeface.getStyle();
                } else {
                    i3 = 0;
                }
                CanvasView.this.mFillPaint.setTypeface(Typeface.create(optString, i3));
                Typeface typeface2 = CanvasView.this.mStrokePaint.getTypeface();
                if (typeface2 != null) {
                    i16 = typeface2.getStyle();
                }
                CanvasView.this.mStrokePaint.setTypeface(Typeface.create(typeface2, i16));
            }
        });
        this.drawActions.put(ACTION_SET_TEXTALIGN, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.9
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setTextAlign(jSONArray);
            }
        });
        this.drawActions.put(ACTION_FILLTEXT, new SetFillOrStrokeTextAction());
        this.drawActions.put(ACTION_STROKETEXT, new SetFillOrStrokeTextAction());
        this.drawActions.put(ACTION_SET_GLOBALALPHA, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.10
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.mGlobalAlpha = jSONArray.optInt(0, 0);
            }
        });
        this.drawActions.put(ACTION_RESTORE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.11
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                try {
                    canvas.restore();
                } catch (Exception e16) {
                    QMLog.e(CanvasView.TAG, "ACTION_RESTORE: " + Log.getStackTraceString(e16));
                }
                CanvasView canvasView = CanvasView.this;
                canvasView.mFillPaint = canvasView.mSaveFillPaint;
                CanvasView canvasView2 = CanvasView.this;
                canvasView2.mStrokePaint = canvasView2.mSaveStrokePaint;
                CanvasView canvasView3 = CanvasView.this;
                canvasView3.mGlobalAlpha = canvasView3.mSaveGlobalAlpha;
                CanvasView canvasView4 = CanvasView.this;
                canvasView4.mFillColorAlpha = canvasView4.mSaveFillColorAlpha;
                CanvasView canvasView5 = CanvasView.this;
                canvasView5.mStrokeColorAlpha = canvasView5.mSaveStrokeColorAlpha;
                CanvasView canvasView6 = CanvasView.this;
                canvasView6.mTextBaseline = canvasView6.mSaveTextBaseline;
                CanvasView canvasView7 = CanvasView.this;
                canvasView7.mRepeatX = canvasView7.mSaveRepeatX;
                CanvasView canvasView8 = CanvasView.this;
                canvasView8.mRepeatY = canvasView8.mSaveRepeatY;
                CanvasView canvasView9 = CanvasView.this;
                canvasView9.mBitmapW = canvasView9.mSaveBitmapW;
                CanvasView canvasView10 = CanvasView.this;
                canvasView10.mBitmapH = canvasView10.mSaveBitmapH;
            }
        });
        this.drawActions.put("save", new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.12
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                canvas.save();
                CanvasView.this.mSaveFillPaint = new Paint(CanvasView.this.mFillPaint);
                CanvasView.this.mSaveStrokePaint = new Paint(CanvasView.this.mStrokePaint);
                CanvasView canvasView = CanvasView.this;
                canvasView.mSaveGlobalAlpha = canvasView.mGlobalAlpha;
                CanvasView canvasView2 = CanvasView.this;
                canvasView2.mSaveFillColorAlpha = canvasView2.mFillColorAlpha;
                CanvasView canvasView3 = CanvasView.this;
                canvasView3.mSaveStrokeColorAlpha = canvasView3.mStrokeColorAlpha;
                CanvasView canvasView4 = CanvasView.this;
                canvasView4.mSaveTextBaseline = canvasView4.mTextBaseline;
                CanvasView canvasView5 = CanvasView.this;
                canvasView5.mSaveRepeatX = canvasView5.mRepeatX;
                CanvasView canvasView6 = CanvasView.this;
                canvasView6.mSaveRepeatY = canvasView6.mRepeatY;
                CanvasView canvasView7 = CanvasView.this;
                canvasView7.mSaveBitmapW = canvasView7.mBitmapW;
                CanvasView canvasView8 = CanvasView.this;
                canvasView8.mSaveBitmapH = canvasView8.mBitmapH;
            }
        });
        this.drawActions.put(ACTION_CLRAERECT, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.13
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.clearRect(canvas, jSONArray);
            }
        });
        this.drawActions.put(ACTION_SETGLOBALCOMPOSITEOPERATION, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.14
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setGlobalCompositeOperation(jSONArray);
            }
        });
        this.drawActions.put(ACTION_ROTATE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.15
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                canvas.rotate((float) ((jSONArray.optDouble(0, 0.0d) * 180.0d) / 3.141592653589793d));
            }
        });
        this.drawActions.put("scale", new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.16
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                canvas.scale((float) jSONArray.optDouble(0, 1.0d), (float) jSONArray.optDouble(1, 1.0d));
            }
        });
        this.drawActions.put(ACTION_TRANSLATE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.17
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                canvas.translate(CanvasView.this.mpx2px(jSONArray.optDouble(0, 0.0d)), CanvasView.this.mpx2px(jSONArray.optDouble(1, 0.0d)));
            }
        });
        this.drawActions.put(ACTION_SET_LINEWIDTH, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.18
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.mStrokePaint.setStrokeWidth(CanvasView.this.mpx2px(jSONArray.optDouble(0, 0.0d)));
            }
        });
        this.drawActions.put(ACTION_SET_SHADOW, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.19
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                ShadowLayer shadowLayer = new ShadowLayer();
                JSONArray optJSONArray = jSONArray.optJSONArray(3);
                float mpx2px = CanvasView.this.mpx2px(jSONArray.optDouble(2, 0.0d));
                float mpx2px2 = CanvasView.this.mpx2px(jSONArray.optDouble(0, 0.0d));
                float mpx2px3 = CanvasView.this.mpx2px(jSONArray.optDouble(1, 0.0d));
                shadowLayer.radius = mpx2px;
                shadowLayer.f346324dx = mpx2px2;
                shadowLayer.f346325dy = mpx2px3;
                shadowLayer.color = CanvasView.this.getColor(optJSONArray);
                CanvasView.this.mFillPaint.setShadowLayer(shadowLayer.radius, shadowLayer.f346324dx, shadowLayer.f346325dy, shadowLayer.color);
                CanvasView.this.mStrokePaint.setShadowLayer(shadowLayer.radius, shadowLayer.f346324dx, shadowLayer.f346325dy, shadowLayer.color);
            }
        });
        this.drawActions.put(ACTION_SET_LINECAP, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.20
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setLineCap(jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_LINEJOIN, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.21
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setLineJoin(jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_LINEDASH, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.22
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.setLineDash(jSONArray);
            }
        });
        this.drawActions.put(ACTION_SET_MITERLIMIT, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.23
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                float mpx2px = CanvasView.this.mpx2px(jSONArray.optDouble(0, 0.0d));
                CanvasView.this.mFillPaint.setStrokeMiter(mpx2px);
                CanvasView.this.mStrokePaint.setStrokeMiter(mpx2px);
            }
        });
        this.drawActions.put(ACTION_SET_TRANSFORM, new TransformAction());
        this.drawActions.put("transform", new TransformAction());
        this.drawActions.put(ACTION_SET_BASELINE, new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.24
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.mTextBaseline = jSONArray.optString(0);
            }
        });
        this.drawActions.put("canvasPutImageData", new DrawAction() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.25
            @Override // com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
            public void doAction(Canvas canvas, JSONObject jSONObject, String str, JSONArray jSONArray) {
                CanvasView.this.putImageData(canvas, str, jSONObject.optJSONObject("data"), jSONObject.optInt("callbackId"));
            }
        });
    }

    private void pathActionArc(JSONArray jSONArray, JSONArray jSONArray2) {
        float f16;
        float mpx2px = mpx2px(jSONArray2.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray2.optDouble(1, 0.0d));
        float mpx2px3 = mpx2px(jSONArray2.optDouble(2, 0.0d));
        double optDouble = jSONArray2.optDouble(3, 0.0d);
        double optDouble2 = jSONArray2.optDouble(4, 0.0d);
        float f17 = (float) ((optDouble / 3.141592653589793d) * 180.0d);
        float f18 = (float) ((optDouble2 / 3.141592653589793d) * 180.0d);
        boolean optBoolean = jSONArray.optBoolean(5);
        RectF rectF = new RectF(mpx2px - mpx2px3, mpx2px2 - mpx2px3, mpx2px + mpx2px3, mpx2px2 + mpx2px3);
        if (optBoolean) {
            f16 = f17 - f18;
        } else {
            f16 = f18 - f17;
        }
        float f19 = f16 % 360.0f;
        if (f19 <= 0.0f) {
            f19 += 360.0f;
        }
        if (this.mPath.isEmpty()) {
            this.mPath.addArc(rectF, f17, f19);
            return;
        }
        Math.cos(optDouble);
        Math.sin(optDouble);
        try {
            if (Math.abs(Math.abs(f19) - 360.0f) < 1.0E-14d) {
                this.mPath.addArc(rectF, f17, f19);
            } else {
                this.mPath.arcTo(rectF, f17, f19);
            }
        } catch (Exception e16) {
            QMLog.d(TAG, " --mPath.addArc-- e " + e16.getMessage());
        }
    }

    private void pathActionBezierCurveTo(JSONArray jSONArray) {
        float mpx2px = mpx2px(jSONArray.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(1, 0.0d));
        float mpx2px3 = mpx2px(jSONArray.optDouble(2, 0.0d));
        float mpx2px4 = mpx2px(jSONArray.optDouble(3, 0.0d));
        float mpx2px5 = mpx2px(jSONArray.optDouble(4, 0.0d));
        float mpx2px6 = mpx2px(jSONArray.optDouble(5, 0.0d));
        if (this.mPath.isEmpty()) {
            this.mPath.moveTo(mpx2px, mpx2px2);
        }
        this.mPath.cubicTo(mpx2px, mpx2px2, mpx2px3, mpx2px4, mpx2px5, mpx2px6);
    }

    private void pathActionLineTo(JSONArray jSONArray) {
        float mpx2px = mpx2px(jSONArray.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(1, 0.0d));
        if (this.mPath.isEmpty()) {
            this.mPath.moveTo(mpx2px, mpx2px2);
        } else {
            this.mPath.lineTo(mpx2px, mpx2px2);
        }
    }

    private void pathActionQuadraticCurveTo(JSONArray jSONArray) {
        float mpx2px = mpx2px(jSONArray.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(1, 0.0d));
        float mpx2px3 = mpx2px(jSONArray.optDouble(2, 0.0d));
        float mpx2px4 = mpx2px(jSONArray.optDouble(3, 0.0d));
        if (this.mPath.isEmpty()) {
            this.mPath.moveTo(mpx2px, mpx2px2);
        }
        this.mPath.quadTo(mpx2px, mpx2px2, mpx2px3, mpx2px4);
    }

    private void pathActionRect(JSONArray jSONArray) {
        float mpx2px = mpx2px(jSONArray.optDouble(0, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(1, 0.0d));
        float mpx2px3 = mpx2px(jSONArray.optDouble(2, 0.0d));
        float mpx2px4 = mpx2px(jSONArray.optDouble(3, 0.0d));
        if (mpx2px3 <= 0.0f) {
            mpx2px += mpx2px3;
            mpx2px3 = -mpx2px3;
        }
        if (mpx2px4 <= 0.0f) {
            mpx2px2 += mpx2px4;
            mpx2px4 = -mpx2px4;
        }
        addPathRect(mpx2px, mpx2px2, mpx2px3, mpx2px4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDrawActionCommands() {
        JSONArray jSONArray = this.mCurrentDrawActions;
        DrawActionCommand poll = this.mDrawActionCommandQueue.poll();
        while (poll != null) {
            boolean z16 = poll.reverse;
            JSONArray jSONArray2 = poll.drawAction;
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            if (jSONArray2.length() == 0) {
                jSONArray2.mo162put(new JSONObject());
            }
            if (z16 && jSONArray != null) {
                try {
                    if (jSONArray.length() != 0) {
                        jSONArray2 = JSONUtil.concatArray(jSONArray, jSONArray2);
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "process draw actions error! " + Log.getStackTraceString(th5));
                }
            }
            jSONArray = jSONArray2;
            poll = this.mDrawActionCommandQueue.poll();
        }
        this.mCurrentDrawActions = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putImageData(Canvas canvas, String str, JSONObject jSONObject, int i3) {
        boolean isRecycled;
        byte[] bArr;
        Bitmap bitmap = null;
        try {
            int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
            int optInt2 = jSONObject.optInt("y");
            int optInt3 = jSONObject.optInt("width");
            int optInt4 = jSONObject.optInt("height");
            NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(null, jSONObject, "data");
            if (unpackNativeBuffer != null) {
                try {
                    bArr = unpackNativeBuffer.buf;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QMLog.e(TAG, "putImageData failed: " + Log.getStackTraceString(th));
                        callbackJsEventFail(str, null, i3);
                        if (bitmap != null) {
                            if (isRecycled) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                }
            } else {
                bArr = null;
            }
            int[] iArr = new int[optInt3 * optInt4];
            for (int i16 = 0; i16 < optInt4; i16++) {
                for (int i17 = 0; i17 < optInt3; i17++) {
                    int i18 = (optInt3 * i16) + i17;
                    int i19 = i18 * 4;
                    iArr[i18] = Color.argb((bArr[i19 + 3] + 256) % 256, (bArr[i19] + 256) % 256, (bArr[i19 + 1] + 256) % 256, (bArr[i19 + 2] + 256) % 256);
                }
            }
            bitmap = Bitmap.createBitmap(optInt3, optInt4, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(iArr, 0, optInt3, 0, 0, optInt3, optInt4);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            float mpx2px = mpx2px(optInt);
            float mpx2px2 = mpx2px(optInt2);
            canvas.drawBitmap(bitmap, (Rect) null, new RectF(mpx2px, mpx2px2, mpx2px(optInt3) + mpx2px, mpx2px(optInt4) + mpx2px2), paint);
            callbackJsEventOK(str, null, i3);
            if (bitmap.isRecycled()) {
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFillOrStrokeText(Canvas canvas, String str, JSONArray jSONArray) {
        Paint currentPaint = getCurrentPaint(str);
        float descent = currentPaint.descent();
        float ascent = currentPaint.ascent();
        String optString = jSONArray.optString(0);
        float mpx2px = mpx2px(jSONArray.optDouble(1, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(2, 0.0d));
        float mpx2px3 = mpx2px(jSONArray.optDouble(3, -1.0d));
        if (this.mTextBaseline.equals("top")) {
            mpx2px2 -= ascent;
        } else {
            if (!this.mTextBaseline.equals("bottom")) {
                if (this.mTextBaseline.equals("middle")) {
                    descent = (descent + ascent) / 2.0f;
                }
            }
            mpx2px2 -= descent;
        }
        if (mpx2px3 > 0.0f) {
            canvas.save();
            float measureText = mpx2px3 / currentPaint.measureText(optString);
            if (measureText < 1.0f) {
                canvas.scale(measureText, 1.0f, mpx2px, mpx2px2);
            }
            canvas.drawText(optString, mpx2px, mpx2px2, currentPaint);
            canvas.restore();
            return;
        }
        canvas.drawText(optString, mpx2px, mpx2px2, currentPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontStyle(JSONArray jSONArray) {
        String optString = jSONArray.optString(0, "normal");
        if ("normal".equals(optString)) {
            Typeface typeface = this.mFillPaint.getTypeface();
            this.mFillPaint.setTypeface(Typeface.create(typeface, getFontStyleNormal(typeface)));
            Typeface typeface2 = this.mStrokePaint.getTypeface();
            this.mStrokePaint.setTypeface(Typeface.create(typeface2, getFontStyleNormal(typeface2)));
            return;
        }
        if ("italic".equals(optString) || "oblique".equals(optString)) {
            Typeface typeface3 = this.mFillPaint.getTypeface();
            this.mFillPaint.setTypeface(Typeface.create(typeface3, getFontStyleItalic(typeface3)));
            Typeface typeface4 = this.mStrokePaint.getTypeface();
            this.mStrokePaint.setTypeface(Typeface.create(typeface4, getFontStyleItalic(typeface4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontWeight(JSONArray jSONArray) {
        String optString = jSONArray.optString(0);
        if ("normal".equals(optString)) {
            Typeface typeface = this.mFillPaint.getTypeface();
            this.mFillPaint.setTypeface(Typeface.create(typeface, getFontWeightNormalStyle(typeface)));
            Typeface typeface2 = this.mStrokePaint.getTypeface();
            this.mStrokePaint.setTypeface(Typeface.create(typeface2, getFontWeightNormalStyle(typeface2)));
            return;
        }
        if ("bold".equals(optString)) {
            Typeface typeface3 = this.mFillPaint.getTypeface();
            this.mFillPaint.setTypeface(Typeface.create(typeface3, getFontWeightBoldStyle(typeface3)));
            Typeface typeface4 = this.mStrokePaint.getTypeface();
            this.mStrokePaint.setTypeface(Typeface.create(typeface4, getFontWeightBoldStyle(typeface4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGlobalCompositeOperation(JSONArray jSONArray) {
        PorterDuff.Mode mode;
        String optString = jSONArray.optString(0);
        if ("xor".equals(optString)) {
            mode = PorterDuff.Mode.XOR;
        } else if ("source-atop".equals(optString)) {
            mode = PorterDuff.Mode.SRC_ATOP;
        } else if ("destination-out".equals(optString)) {
            mode = PorterDuff.Mode.DST_OUT;
        } else if (!PTSNodeTextBase.WEIGHT_LIGHTER.equals(optString) && !"lighten".equals(optString) && !"hard-light".equals(optString)) {
            if ("overlay".equals(optString)) {
                mode = PorterDuff.Mode.OVERLAY;
            } else if ("darken".equals(optString)) {
                mode = PorterDuff.Mode.DARKEN;
            } else {
                mode = null;
            }
        } else {
            mode = PorterDuff.Mode.LIGHTEN;
        }
        if (mode != null) {
            this.mFillPaint.setXfermode(new PorterDuffXfermode(mode));
            this.mStrokePaint.setXfermode(new PorterDuffXfermode(mode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLineCap(JSONArray jSONArray) {
        Paint.Cap cap;
        String optString = jSONArray.optString(0);
        if ("butt".equals(optString)) {
            cap = Paint.Cap.BUTT;
        } else if ("round".equals(optString)) {
            cap = Paint.Cap.ROUND;
        } else if ("square".equals(optString)) {
            cap = Paint.Cap.SQUARE;
        } else {
            cap = null;
        }
        if (cap != null) {
            this.mStrokePaint.setStrokeCap(cap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLineDash(JSONArray jSONArray) {
        DashPathEffect dashPathEffect;
        JSONArray jSONArray2 = (JSONArray) jSONArray.opt(0);
        if (jSONArray2.length() > 0) {
            float mpx2px = mpx2px(jSONArray.optDouble(1, 0.0d));
            float[] fArr = new float[jSONArray2.length()];
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                fArr[i3] = mpx2px(jSONArray2.optDouble(i3, 0.0d));
            }
            dashPathEffect = new DashPathEffect(fArr, mpx2px);
        } else {
            dashPathEffect = null;
        }
        this.mFillPaint.setPathEffect(dashPathEffect);
        this.mStrokePaint.setPathEffect(dashPathEffect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLineJoin(JSONArray jSONArray) {
        Paint.Join join;
        String optString = jSONArray.optString(0);
        if ("bevel".equals(optString)) {
            join = Paint.Join.BEVEL;
        } else if ("round".equals(optString)) {
            join = Paint.Join.ROUND;
        } else if ("miter".equals(optString)) {
            join = Paint.Join.MITER;
        } else {
            join = null;
        }
        if (join != null) {
            this.mStrokePaint.setStrokeJoin(join);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathOrClip(Canvas canvas, String str, JSONArray jSONArray) {
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        this.mPath.reset();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                if (ACTION_RECT.equals(optString)) {
                    pathActionRect(optJSONArray);
                } else if (ACTION_MOVETO.equals(optString)) {
                    try {
                        this.mPath.moveTo(mpx2px(optJSONArray.optDouble(0, 0.0d)), mpx2px(optJSONArray.optDouble(1, 0.0d)));
                    } catch (Throwable th5) {
                        QMLog.e(TAG, Log.getStackTraceString(th5));
                    }
                } else if (ACTION_LINETO.equals(optString)) {
                    pathActionLineTo(optJSONArray);
                } else if (ACTION_CLOSEPATH.equals(optString)) {
                    this.mPath.close();
                } else if (ACTION_ARC.equals(optString)) {
                    pathActionArc(jSONArray, optJSONArray);
                } else if (ACTION_QUADRATIC_CURVETO.equals(optString)) {
                    pathActionQuadraticCurveTo(optJSONArray);
                } else if (ACTION_QBEZIER_CURVETO.equals(optString)) {
                    pathActionBezierCurveTo(optJSONArray);
                } else if (ACTION_TRANSLATE.equals(optString)) {
                    canvas.translate(mpx2px(optJSONArray.optDouble(0, 0.0d)), mpx2px(optJSONArray.optDouble(1, 0.0d)));
                }
            }
        }
        if ("clip".equals(str)) {
            canvas.clipPath(this.mPath);
        } else {
            canvas.drawPath(this.mPath, getCurrentPaint(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeOrFillStyle(String str, JSONArray jSONArray) {
        this.mRepeatX = false;
        this.mRepeatY = false;
        this.mBitmapW = 0;
        this.mBitmapH = 0;
        String optString = jSONArray.optString(0);
        if ("normal".equals(optString)) {
            setStyleColorTypeNormal(str, jSONArray);
            return;
        }
        if (ACTION_RADIAL.equals(optString)) {
            JSONArray optJSONArray = jSONArray.optJSONArray(1);
            JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
            RadialGradient radialGradient = new RadialGradient(mpx2px(optJSONArray.optDouble(0)), mpx2px(optJSONArray.optDouble(1)), mpx2px(optJSONArray.optDouble(2)), getColor(optJSONArray2.optJSONArray(0).optJSONArray(1)), getColor(optJSONArray2.optJSONArray(1).optJSONArray(1)), Shader.TileMode.CLAMP);
            if (ACTION_SET_STROKESTYLE.equals(str)) {
                this.mStrokePaint.setShader(radialGradient);
                return;
            } else {
                if (ACTION_SET_FILLSTYLE.equals(str)) {
                    this.mFillPaint.setShader(radialGradient);
                    return;
                }
                return;
            }
        }
        if (ACTION_LINER.equals(optString)) {
            JSONArray optJSONArray3 = jSONArray.optJSONArray(1);
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            LinearGradient linearGradient = new LinearGradient(mpx2px(optJSONArray3.optDouble(0)), mpx2px(optJSONArray3.optDouble(1)), mpx2px(optJSONArray3.optDouble(2)), mpx2px(optJSONArray3.optDouble(3)), getColor(optJSONArray4.optJSONArray(0).optJSONArray(1)), getColor(optJSONArray4.optJSONArray(1).optJSONArray(1)), Shader.TileMode.CLAMP);
            if (ACTION_SET_STROKESTYLE.equals(str)) {
                this.mStrokePaint.setShader(linearGradient);
                return;
            } else {
                if (ACTION_SET_FILLSTYLE.equals(str)) {
                    this.mFillPaint.setShader(linearGradient);
                    return;
                }
                return;
            }
        }
        if ("pattern".equals(optString)) {
            setStrokeOrFillStyleForTypePatten(jSONArray);
        }
    }

    private void setStrokeOrFillStyleForTypePatten(JSONArray jSONArray) {
        if (jSONArray.length() == 3) {
            String optString = jSONArray.optString(1);
            if (!StringUtil.isEmpty(optString)) {
                if (optString.startsWith("wxfile")) {
                    optString = ((MiniAppFileManager) getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                } else {
                    optString = this.mApkgInfo.getChildFileAbsolutePath(optString);
                }
            }
            String optString2 = jSONArray.optString(2);
            if ("repeat".equals(optString2)) {
                this.mRepeatX = true;
                this.mRepeatY = true;
            } else if ("repeat-x".equals(optString2)) {
                this.mRepeatX = true;
            } else if ("repeat-y".equals(optString2)) {
                this.mRepeatY = true;
            }
            setStylePatternBitmapShader(optString);
        }
    }

    private void setStyleColorTypeNormal(String str, JSONArray jSONArray) {
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (ACTION_SET_STROKESTYLE.equals(str)) {
            int color = getColor(optJSONArray);
            this.mStrokeColorAlpha = optJSONArray.optInt(3);
            this.mStrokePaint.setShader(null);
            this.mStrokePaint.setColor(color);
            return;
        }
        if (ACTION_SET_FILLSTYLE.equals(str)) {
            int color2 = getColor(optJSONArray);
            this.mFillColorAlpha = optJSONArray.optInt(3);
            this.mFillPaint.setShader(null);
            this.mFillPaint.setColor(color2);
        }
    }

    private void setStylePatternBitmapShader(String str) {
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
        if (!StringUtil.isEmpty(str)) {
            Bitmap localBitmap = ImageUtil.getLocalBitmap(str);
            if (localBitmap != null) {
                this.mBitmapW = localBitmap.getWidth();
                this.mBitmapH = localBitmap.getHeight();
            }
            Matrix matrix = new Matrix();
            float f16 = this.mDensity;
            matrix.postScale(f16, f16);
            Bitmap createBitmap = Bitmap.createBitmap(localBitmap, 0, 0, this.mBitmapW, this.mBitmapH, matrix, true);
            if (createBitmap != null) {
                this.mBitmapW = createBitmap.getWidth();
                this.mBitmapH = createBitmap.getHeight();
                if (this.mRepeatX) {
                    tileMode = Shader.TileMode.REPEAT;
                } else {
                    tileMode = Shader.TileMode.CLAMP;
                }
                if (this.mRepeatY) {
                    tileMode2 = Shader.TileMode.REPEAT;
                } else {
                    tileMode2 = Shader.TileMode.CLAMP;
                }
                BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode2);
                this.mFillPaint.setShader(bitmapShader);
                this.mStrokePaint.setShader(bitmapShader);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextAlign(JSONArray jSONArray) {
        Paint.Align align;
        String optString = jSONArray.optString(0);
        if ("center".equals(optString)) {
            align = Paint.Align.CENTER;
        } else if ("right".equals(optString)) {
            align = Paint.Align.RIGHT;
        } else {
            align = Paint.Align.LEFT;
        }
        this.mFillPaint.setTextAlign(align);
        this.mStrokePaint.setTextAlign(align);
    }

    private void setUseHardwareAccelerate(boolean z16) {
        this.mUseHardwareAccelerate = z16;
        int layerType = getLayerType();
        if (z16) {
            if (layerType != 2) {
                setLayerType(2, null);
            }
        } else if (layerType != 0) {
            setLayerType(1, null);
            setLayerType(0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transform(Canvas canvas, String str, JSONArray jSONArray) {
        float optDouble = (float) jSONArray.optDouble(0, 1.0d);
        float optDouble2 = (float) jSONArray.optDouble(3, 1.0d);
        float optDouble3 = (float) jSONArray.optDouble(2, 0.0d);
        float optDouble4 = (float) jSONArray.optDouble(1, 0.0d);
        float mpx2px = mpx2px(jSONArray.optDouble(4, 0.0d));
        float mpx2px2 = mpx2px(jSONArray.optDouble(5, 0.0d));
        float[] fArr = new float[9];
        try {
            fArr[2] = mpx2px;
            fArr[5] = mpx2px2;
            fArr[0] = optDouble;
            fArr[4] = optDouble2;
            fArr[1] = optDouble3;
            fArr[3] = optDouble4;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            if ("transform".equals(str)) {
                Matrix matrix = new Matrix();
                matrix.setValues(fArr);
                canvas.concat(matrix);
            } else {
                Matrix matrix2 = canvas.getMatrix();
                if (matrix2 == null) {
                    matrix2 = new Matrix();
                }
                matrix2.setValues(fArr);
                canvas.setMatrix(matrix2);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, Log.getStackTraceString(e16));
        }
    }

    public void addDrawActionCommand(DrawActionCommand drawActionCommand) {
        if (this.mIsAttachedToWindow && drawActionCommand != null) {
            this.mDrawActionCommandQueue.offer(drawActionCommand);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.mLastInvalidateTime;
            if (j3 == 0) {
                processDrawActionCommands();
                postInvalidate();
                this.mLastInvalidateTime = currentTimeMillis;
                return;
            }
            long j16 = currentTimeMillis - j3;
            if (j16 >= 16) {
                processDrawActionCommands();
                postInvalidate();
                this.mLastInvalidateTime = currentTimeMillis;
            } else if (this.mPendingDrawTaskTime == 0) {
                this.mPendingDrawTaskTime = currentTimeMillis;
                postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.26
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CanvasView.this.mIsAttachedToWindow && CanvasView.this.mLastInvalidateTime <= CanvasView.this.mPendingDrawTaskTime) {
                            CanvasView.this.processDrawActionCommands();
                            CanvasView.this.postInvalidate();
                            CanvasView.this.mLastInvalidateTime = System.currentTimeMillis();
                            CanvasView.this.mPendingDrawTaskTime = 0L;
                        }
                    }
                }, 16 - j16);
            }
        }
    }

    public void callbackJsEventFail(String str, JSONObject jSONObject, int i3) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            ServiceEvaluateCallbackAction.obtain(iMiniAppContext).callbackJsEventFail(str, jSONObject, i3);
        }
    }

    public void callbackJsEventOK(String str, JSONObject jSONObject, int i3) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            ServiceEvaluateCallbackAction.obtain(iMiniAppContext).callbackJsEventOK(str, jSONObject, i3);
        }
    }

    protected void evaluateSubcribeJS(String str, String str2) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, this.mWebViewId));
        }
    }

    public void getImageData(final JSONObject jSONObject, final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasView canvasView = CanvasView.this;
                final Bitmap cacheBitmapFromView = canvasView.getCacheBitmapFromView(canvasView, true);
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap createBitmap;
                        if (cacheBitmapFromView == null) {
                            nativeViewRequestEvent.fail();
                            return;
                        }
                        Bitmap bitmap = null;
                        try {
                            Matrix matrix = new Matrix();
                            float f16 = 1.0f / CanvasView.this.mDensity;
                            matrix.postScale(f16, f16);
                            Bitmap bitmap2 = cacheBitmapFromView;
                            createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), cacheBitmapFromView.getHeight(), matrix, true);
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            int optInt = jSONObject.optInt(HippyTKDListViewAdapter.X);
                            int optInt2 = jSONObject.optInt("y");
                            int optInt3 = jSONObject.optInt("width");
                            int optInt4 = jSONObject.optInt("height");
                            int i3 = optInt3 * optInt4;
                            int[] iArr = new int[i3];
                            createBitmap.getPixels(iArr, 0, optInt3, optInt, optInt2, optInt3, optInt4);
                            byte[] bArr = new byte[i3 * 4];
                            for (int i16 = 0; i16 < optInt4; i16++) {
                                for (int i17 = 0; i17 < optInt3; i17++) {
                                    int i18 = (optInt3 * i16) + i17;
                                    int i19 = i18 * 4;
                                    int i26 = iArr[i18];
                                    byte alpha = (byte) Color.alpha(i26);
                                    byte red = (byte) Color.red(i26);
                                    byte green = (byte) Color.green(i26);
                                    byte blue = (byte) Color.blue(i26);
                                    bArr[i19] = red;
                                    bArr[i19 + 1] = green;
                                    bArr[i19 + 2] = blue;
                                    bArr[i19 + 3] = alpha;
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("width", optInt3);
                            jSONObject2.put("height", optInt4);
                            NativeBuffer.packNativeBuffer(null, bArr, NativeBuffer.TYPE_BUFFER_BASE64, "data", jSONObject2);
                            nativeViewRequestEvent.ok(jSONObject2);
                            Bitmap bitmap3 = cacheBitmapFromView;
                            if (bitmap3 != null && !bitmap3.isRecycled()) {
                                cacheBitmapFromView.recycle();
                            }
                            if (!createBitmap.isRecycled()) {
                                createBitmap.recycle();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            bitmap = createBitmap;
                            try {
                                QMLog.e(CanvasView.TAG, "getImageData failed: " + Log.getStackTraceString(th));
                                nativeViewRequestEvent.fail();
                            } finally {
                                Bitmap bitmap4 = cacheBitmapFromView;
                                if (bitmap4 != null && !bitmap4.isRecycled()) {
                                    cacheBitmapFromView.recycle();
                                }
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    float mpx2px(double d16) {
        return (float) (d16 * this.mDensity);
    }

    int mpx2pxInt(double d16) {
        return (int) ((d16 * this.mDensity) + 0.5d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) || DeviceInfoUtil.getPhoneModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            try {
                String systemProperty = DisplayUtil.getSystemProperty("ro.vivo.os.version", null);
                if (systemProperty != null && "3.1".equals(systemProperty.trim())) {
                    Field declaredField = Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT");
                    if (this.mVivoEnableSplit == null) {
                        this.mVivoEnableSplit = Boolean.valueOf(declaredField.getBoolean(null));
                    }
                    declaredField.set(null, Boolean.FALSE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
        if (this.mVivoEnableSplit != null) {
            try {
                Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT").set(null, Boolean.valueOf(this.mVivoEnableSplit.booleanValue()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        try {
            if (getLayerType() == 0) {
                i3 = canvas.saveLayer(this.mOffScreenCacheRect, null, 31);
            } else {
                i3 = 0;
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            doDraw(canvas, this.mCurrentDrawActions);
            if (i3 > 0) {
                canvas.restoreToCount(i3);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QMLog.e(TAG, "doDraw failed! " + Log.getStackTraceString(th5));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.mOffScreenCacheRect = new RectF(0.0f, 0.0f, i3, i16);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Boolean bool;
        JSONObject jSONObject = new JSONObject();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                QMLog.d(TAG, "--ACTION_POINTER_UP--" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                                handleTouchPointerEvent(motionEvent, jSONObject, "onTouchEnd");
                            }
                        } else {
                            QMLog.d(TAG, "--ACTION_POINTER_DOWN--" + motionEvent.getPointerCount() + "   " + motionEvent.getActionIndex() + "   " + motionEvent.getPointerId(motionEvent.getActionIndex()));
                            handleTouchPointerEvent(motionEvent, jSONObject, e.c.NAME);
                        }
                    } else {
                        QMLog.d(TAG, "--ACTION_CANCEL--");
                        handleTouchCancel(motionEvent, jSONObject);
                    }
                } else {
                    handleTouchMove(motionEvent, jSONObject);
                }
            } else {
                QMLog.d(TAG, "--ACTION_UP--");
                handleTouchEvent(motionEvent, jSONObject, "onTouchEnd");
            }
        } else {
            QMLog.d(TAG, "--ACTION_DOWN--");
            handleTouchEvent(motionEvent, jSONObject, e.c.NAME);
        }
        if (this.mHasGuesture && (bool = this.mDisableScroll) != null && bool.booleanValue()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    float px2mpx(double d16) {
        return (float) (d16 / this.mDensity);
    }

    int px2mpxInt(double d16) {
        return (int) ((d16 / this.mDensity) + 0.5d);
    }

    public void saveBitmap(final NativeViewRequestEvent nativeViewRequestEvent, final JSONObject jSONObject) throws IOException {
        String optString;
        long j3;
        if (jSONObject == null) {
            optString = "png";
        } else {
            optString = jSONObject.optString(TagName.FILE_TYPE);
        }
        final String str = optString;
        final boolean z16 = !"jpg".equals(str);
        if (getWidth() != 0 && getHeight() != 0) {
            j3 = 0;
        } else {
            j3 = 300;
        }
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.CanvasView.2
            @Override // java.lang.Runnable
            public void run() {
                CanvasView.this.doSaveBitmap(z16, nativeViewRequestEvent, jSONObject, str);
            }
        }, j3);
    }
}
