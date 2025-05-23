package com.tencent.mapsdk.engine.jni;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.annotation.Keep;
import com.tencent.map.lib.JNIInterfaceCallback;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.mapsdk.engine.jni.models.TextBitmapInfo;
import com.tencent.mapsdk.internal.bs;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mapsdk.internal.kt;
import com.tencent.mapsdk.internal.ku;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.lc;
import com.tencent.mapsdk.internal.lt;
import com.tencent.mapsdk.internal.na;
import com.tencent.mapsdk.internal.oo;
import com.tencent.mapsdk.internal.os;
import com.tencent.mapsdk.internal.ot;
import com.tencent.mapsdk.internal.ox;
import com.tencent.mapsdk.internal.oy;
import com.tencent.mapsdk.internal.oz;
import com.tencent.mapsdk.internal.pa;
import com.tencent.mapsdk.internal.pb;
import com.tencent.mapsdk.internal.pc;
import com.tencent.mapsdk.internal.pd;
import com.tencent.mapsdk.internal.pe;
import com.tencent.mapsdk.internal.w;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class JNICallback implements JNIInterfaceCallback {
    private static final int CB_TYPE_CAL_TEXT_SIZE = 2;
    private static final int CB_TYPE_CANCEL_DOWNLOAD = 10;
    private static final int CB_TYPE_DECODE_IMG = 11;
    private static final int CB_TYPE_DOWNLOAD = 3;
    private static final int CB_TYPE_DRAW_TEXT = 1;
    private static final int CB_TYPE_INDOOR_BUILDING_CHANGED = 8;
    private static final int CB_TYPE_LOAD_RES = 4;
    private static final int CB_TYPE_NOTIFY_SET_CENTER_AND_SCALE_ANIM_FINISHED = 9;
    private static final int CB_TYPE_REPORT_ENGINE_CRASH_INFO = 7;
    private static final int CB_TYPE_UPDATE_MAP_PARAM = 6;
    private static final int CB_TYPE_WRITE_FILE = 5;
    private static final int IMG_TYPE_SAT = 1;
    private os mCancelDownloadCallback;
    private oy mCbkGetGLContext;
    private ot mDownloadCallback;
    private final bs mEngineCrashInfoRecorder;
    private ox mIndoorBuildingChangeCallback;
    private final pa mMapAnimCallback;
    private oz mMapCameraChangeCallback;
    private final pe mMapLayerClickResultCallback;
    private final pb mMapLoadFinishedCallback;
    private pd mMapParamChangeCallback;
    private oo mRender;
    private w mResources;
    private Hashtable<Long, Paint> mTextPaints = new Hashtable<>();
    private Hashtable<Long, PointF> mTextSizeBuffers = new Hashtable<>();
    private Bitmap textCanvas;
    private final pc thisMapMarkerCollisionChangedCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private String f147662a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f147663b;

        a(String str, byte[] bArr) {
            this.f147662a = str;
            this.f147663b = bArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Void a() {
            FileOutputStream fileOutputStream;
            boolean z16;
            File file = new File(this.f147662a + ".tmp");
            FileOutputStream fileOutputStream2 = null;
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            try {
                try {
                    if (!file.exists()) {
                        kt.a(file);
                    }
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        fileOutputStream3.write(this.f147663b);
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        z16 = true;
                    } catch (FileNotFoundException e18) {
                        fileOutputStream = fileOutputStream3;
                        e = e18;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        z16 = false;
                        if (z16) {
                        }
                        return null;
                    } catch (IOException e19) {
                        fileOutputStream = fileOutputStream3;
                        e = e19;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        z16 = false;
                        if (z16) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (IOException e28) {
                    e = e28;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                }
                if (z16) {
                    file.renameTo(new File(this.f147662a));
                }
                return null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = fileOutputStream;
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            return a();
        }
    }

    public JNICallback(oo ooVar, w wVar, ot otVar, os osVar, pb pbVar, ox oxVar, pa paVar, bs bsVar, pd pdVar, oz ozVar, pe peVar, pc pcVar) {
        this.mRender = ooVar;
        this.mResources = wVar;
        this.mDownloadCallback = otVar;
        this.mCancelDownloadCallback = osVar;
        this.mMapLoadFinishedCallback = pbVar;
        this.mMapParamChangeCallback = pdVar;
        this.mIndoorBuildingChangeCallback = oxVar;
        this.mMapCameraChangeCallback = ozVar;
        this.mMapAnimCallback = paVar;
        this.mEngineCrashInfoRecorder = bsVar;
        this.mMapLayerClickResultCallback = peVar;
        this.thisMapMarkerCollisionChangedCallback = pcVar;
    }

    private void cacheTextPaint(Paint paint) {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable != null) {
            hashtable.put(Long.valueOf(Thread.currentThread().getId()), paint);
        }
    }

    private void cacheTextSize(PointF pointF) {
        Hashtable<Long, PointF> hashtable = this.mTextSizeBuffers;
        if (hashtable != null) {
            hashtable.put(Long.valueOf(Thread.currentThread().getId()), pointF);
        }
    }

    private PointF calTextSize(String str, int i3) {
        float measureText = initTextPaint(i3).measureText(str) + 1.0f;
        int i16 = i3 + 8;
        PointF textSize = getTextSize();
        if (textSize == null) {
            textSize = new PointF();
            cacheTextSize(textSize);
        }
        textSize.x = measureText;
        textSize.y = i16;
        return textSize;
    }

    private void cancelDownload(String str, lt ltVar) {
        if (this.mCancelDownloadCallback != null) {
            LogUtil.b("Engine callback cancel download:".concat(String.valueOf(str)));
            this.mCancelDownloadCallback.a(str, ltVar);
        }
    }

    private IconImageInfo decodeImage(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                iconImageInfo.bitmap = BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                iconImageInfo.scale = 1.0f;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                LogUtil.c("Engine callback decodeImg: failed to decode stream.");
            }
            return iconImageInfo;
        } finally {
            ku.a((Closeable) byteArrayInputStream);
        }
    }

    private void download(String str, lt ltVar) {
        if (this.mDownloadCallback != null) {
            LogUtil.b("Engine callback download:" + str + ":" + ltVar);
            this.mDownloadCallback.b(str, ltVar);
        }
    }

    private Bitmap drawText(int i3, String str, byte[] bArr) {
        TextBitmapInfo textBitmapInfo = new TextBitmapInfo();
        textBitmapInfo.fill(bArr);
        if (textBitmapInfo.width == 0 || textBitmapInfo.height == 0) {
            return null;
        }
        if (this.textCanvas == null) {
            this.textCanvas = Bitmap.createBitmap(400, 400, Bitmap.Config.ALPHA_8);
        }
        if (this.textCanvas == null) {
            return null;
        }
        Paint initTextPaint = initTextPaint(i3);
        this.textCanvas.eraseColor(0);
        Canvas canvas = new Canvas(this.textCanvas);
        float descent = 200.0f - ((initTextPaint.descent() + initTextPaint.ascent()) / 2.0f);
        initTextPaint.setFakeBoldText(textBitmapInfo.bold);
        canvas.drawText(str, 200.0f, descent, initTextPaint);
        return this.textCanvas;
    }

    private Paint getTextPaint() {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable == null) {
            return null;
        }
        return hashtable.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private PointF getTextSize() {
        Hashtable<Long, PointF> hashtable = this.mTextSizeBuffers;
        if (hashtable == null) {
            return null;
        }
        return hashtable.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private Paint initTextPaint(int i3) {
        Paint textPaint = getTextPaint();
        if (textPaint == null) {
            textPaint = new na(this.mResources.f151301a);
            textPaint.setTypeface(Typeface.DEFAULT);
            textPaint.setAntiAlias(true);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setLinearText(true);
            cacheTextPaint(textPaint);
        }
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(i3);
        return textPaint;
    }

    private IconImageInfo loadImage(int i3, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                String str = new String(bArr);
                if (i3 == 1) {
                    w wVar = this.mResources;
                    IconImageInfo iconImageInfo = new IconImageInfo();
                    iconImageInfo.scale = wVar.f151303c;
                    iconImageInfo.anchorPointX1 = 0.5f;
                    iconImageInfo.anchorPointY1 = 0.5f;
                    iconImageInfo.bitmap = wVar.a(str, Bitmap.Config.RGB_565);
                    return iconImageInfo;
                }
                return this.mResources.a(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    private void writeFile(String str, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        new a(str, bArr).execute(new Void[0]);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public Object callback(int i3, int i16, String str, byte[] bArr, Object obj) {
        JNIEvent jNIEvent = new JNIEvent();
        jNIEvent.f147664id = i16;
        jNIEvent.name = str;
        jNIEvent.data = bArr;
        jNIEvent.extra = obj;
        return callback(i3, jNIEvent);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public int callbackGetGLContext() {
        oy oyVar = this.mCbkGetGLContext;
        if (oyVar != null) {
            return oyVar.getEGLContextHash();
        }
        return 0;
    }

    public void destory() {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable != null) {
            hashtable.clear();
            this.mTextPaints = null;
        }
        Hashtable<Long, PointF> hashtable2 = this.mTextSizeBuffers;
        if (hashtable2 != null) {
            hashtable2.clear();
            this.mTextSizeBuffers = null;
        }
        this.mResources = null;
        this.mDownloadCallback = null;
        this.mCancelDownloadCallback = null;
        this.mMapParamChangeCallback = null;
        this.mIndoorBuildingChangeCallback = null;
        this.mMapCameraChangeCallback = null;
        this.mRender = null;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public boolean onJniCallbackRenderMapFrame(int i3) {
        oo ooVar = this.mRender;
        if (ooVar != null) {
            return ooVar.a(i3);
        }
        return false;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChangeStopped() {
        oz ozVar = this.mMapCameraChangeCallback;
        if (ozVar != null) {
            ozVar.k();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChanged() {
        oz ozVar = this.mMapCameraChangeCallback;
        if (ozVar != null) {
            ozVar.j();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapLoaded() {
        pb pbVar = this.mMapLoadFinishedCallback;
        if (pbVar != null) {
            pbVar.p_();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMarkerCollisionCallback(int[] iArr, int[] iArr2) {
        pc pcVar = this.thisMapMarkerCollisionChangedCallback;
        if (pcVar != null) {
            pcVar.a(iArr, iArr2);
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onVisualLayerClickResult(float f16, float f17, long j3, String str, String str2) {
        pe peVar = this.mMapLayerClickResultCallback;
        if (peVar != null) {
            peVar.a(f16, f17, j3, str, str2);
        }
    }

    public void setMapCallbackGetGLContext(oy oyVar) {
        this.mCbkGetGLContext = oyVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object callback(int i3, JNIEvent jNIEvent) {
        switch (i3) {
            case 1:
                return drawText(jNIEvent.f147664id, jNIEvent.name, jNIEvent.data);
            case 2:
                return calTextSize(jNIEvent.name, jNIEvent.f147664id);
            case 3:
                if (!hs.a(jNIEvent.name)) {
                    lt ltVar = new lt();
                    ltVar.f149262a = jNIEvent.f147664id;
                    Object obj = jNIEvent.extra;
                    if (obj instanceof MapTileID) {
                        MapTileID mapTileID = (MapTileID) obj;
                        ltVar.f149263b = mapTileID.getDataSource().getValue();
                        ltVar.f149264c = mapTileID.getPriority().getValue();
                    }
                    ltVar.f149265d = jNIEvent.extra;
                    download(jNIEvent.name, ltVar);
                }
                return null;
            case 4:
                IconImageInfo loadImage = loadImage(jNIEvent.f147664id, jNIEvent.data);
                byte[] bArr = jNIEvent.data;
                if (bArr == null) {
                    return loadImage;
                }
                new String(bArr);
                return loadImage;
            case 5:
                LogUtil.b(ky.f149101g, "CB_TYPE_WRITE_FILE:" + jNIEvent.name);
                writeFile(jNIEvent.name, jNIEvent.data);
                return null;
            case 6:
                pd pdVar = this.mMapParamChangeCallback;
                if (pdVar != null) {
                    pdVar.g();
                }
                return null;
            case 7:
                bs bsVar = this.mEngineCrashInfoRecorder;
                if (bsVar != null) {
                    bsVar.a(jNIEvent.name);
                }
                return null;
            case 8:
                ox oxVar = this.mIndoorBuildingChangeCallback;
                if (oxVar != null) {
                    oxVar.c();
                }
                return null;
            case 9:
                pa paVar = this.mMapAnimCallback;
                if (paVar != null) {
                    paVar.b(jNIEvent.f147664id > 0);
                }
                return null;
            case 10:
                lc.a("CB_TYPE_CANCEL_DOWNLOAD", jNIEvent);
                if (!hs.a(jNIEvent.name)) {
                    lt ltVar2 = new lt();
                    ltVar2.f149262a = jNIEvent.f147664id;
                    Object obj2 = jNIEvent.extra;
                    if (obj2 instanceof MapTileID) {
                        MapTileID mapTileID2 = (MapTileID) obj2;
                        ltVar2.f149263b = mapTileID2.getDataSource().getValue();
                        ltVar2.f149264c = mapTileID2.getPriority().getValue();
                    }
                    ltVar2.f149265d = jNIEvent.extra;
                    cancelDownload(jNIEvent.name, ltVar2);
                }
                return null;
            case 11:
                lc.a("CB_TYPE_DECODE_IMG", jNIEvent);
                return decodeImage(jNIEvent.data);
            default:
                return null;
        }
    }
}
