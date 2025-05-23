package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.Settings;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.mobileqq.vas.kuikly.reader.FontWeight;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002JA\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J8\u0010,\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\tH\u0016J?\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0016R2\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190/j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0019`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasReaderApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasReaderApi;", "Ljava/io/File;", "dirFile", "", "deleteDir", QzoneZipCacheHelper.DIR, "", "calculateFileSize", "", NodeProps.MAX_WIDTH, "measureWidth", "length", "", "textSize", "getTextSpacingFixed", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "callback", "", "remove", "Lcom/tencent/mobileqq/vas/api/impl/VasReaderApiImpl$b;", "getVolumeKeyCallBack", "getDeviceBrightness", "brightness", "setDeviceBrightness", "", "absolutePath", XWalkReaderBasePlugin.READ_METHOD_NAME, "isAppend", "data", "writeFile", "getFileList", "deleteFile", "getFileSize", "getAvailableSpace", "fontFamily", "textContent", "textSpacing", "fontWeight", "measureText", "isOn", "setVolumeKeyListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "volumeCallbacks", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasReaderApiImpl implements IVasReaderApi {

    @NotNull
    private static final String TAG = "VasReaderApiImpl";

    @NotNull
    private HashMap<String, b> volumeCallbacks = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B,\u0012#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R4\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasReaderApiImpl$b;", "Lcom/tencent/mobileqq/app/lifecycle/DefaultBaseActivityLifecycleCallback;", "Landroid/view/KeyEvent;", "event", "", "doOnDispatchKeyEvent", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "", "d", "Lkotlin/jvm/functions/Function1;", "getVolumeCallback", "()Lkotlin/jvm/functions/Function1;", "volumeCallback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends DefaultBaseActivityLifecycleCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function1<Integer, Unit> volumeCallback;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable Function1<? super Integer, Unit> function1) {
            this.volumeCallback = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0057  */
        @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean doOnDispatchKeyEvent(@Nullable KeyEvent event) {
            int i3;
            if (event != null) {
                if (event.getAction() == 0) {
                    if (event.getKeyCode() == 24) {
                        i3 = IVasReaderApi.VolumeKey.VOLUME_UP.ordinal();
                        QLog.d(VasReaderApiImpl.TAG, 2, "VolumeKeyCallBack: KEYCODE_VOLUME_UP " + i3);
                    } else if (event.getKeyCode() == 25) {
                        i3 = IVasReaderApi.VolumeKey.VOLUME_DOWN.ordinal();
                        QLog.d(VasReaderApiImpl.TAG, 2, "VolumeKeyCallBack: KEYCODE_VOLUME_DOWN " + i3);
                    }
                    if (i3 >= 0) {
                        Function1<Integer, Unit> function1 = this.volumeCallback;
                        if (function1 != null) {
                            function1.invoke(Integer.valueOf(i3));
                            return true;
                        }
                        return true;
                    }
                }
                i3 = -1;
                if (i3 >= 0) {
                }
            }
            return super.doOnDispatchKeyEvent(event);
        }
    }

    private final long calculateFileSize(File dir) {
        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            long j3 = 0;
            if (listFiles == null) {
                return 0L;
            }
            for (File file : listFiles) {
                Intrinsics.checkNotNullExpressionValue(file, "file");
                j3 += calculateFileSize(file);
            }
            return j3;
        }
        return dir.length();
    }

    private final void deleteDir(File dirFile) {
        File[] listFiles = dirFile.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    Intrinsics.checkNotNullExpressionValue(file, "file");
                    deleteDir(file);
                }
            }
        }
        dirFile.delete();
    }

    private final float getTextSpacingFixed(int maxWidth, int measureWidth, int length, float textSize) {
        float f16 = maxWidth - measureWidth;
        if (f16 <= textSize) {
            return (f16 / (length - 1)) / textSize;
        }
        return 0.0f;
    }

    private final b getVolumeKeyCallBack(Activity activity, Function1<? super Integer, Unit> callback, boolean remove) {
        Integer num;
        if (activity != null) {
            num = Integer.valueOf(activity.hashCode());
        } else {
            num = null;
        }
        String valueOf = String.valueOf(num);
        b bVar = this.volumeCallbacks.get(valueOf);
        if (bVar == null) {
            bVar = new b(callback);
            this.volumeCallbacks.put(valueOf, bVar);
        }
        if (remove) {
            this.volumeCallbacks.remove(valueOf);
        }
        return bVar;
    }

    static /* synthetic */ b getVolumeKeyCallBack$default(VasReaderApiImpl vasReaderApiImpl, Activity activity, Function1 function1, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return vasReaderApiImpl.getVolumeKeyCallBack(activity, function1, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDeviceBrightness$lambda$0(Activity activity, float f16) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f16;
        activity.getWindow().setAttributes(attributes);
        QLog.d(TAG, 1, "setDeviceBrightness:" + f16);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int deleteFile(@NotNull String absolutePath) {
        boolean z16;
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        File file = new File(absolutePath);
        int i3 = 0;
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
            i3 = -1;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                deleteDir(file);
            } else {
                z16 = file.delete();
                if (!z16) {
                    i3 = -3;
                }
                QLog.d(TAG, 1, "deleteFile:" + absolutePath + " " + i3);
                return i3;
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.d(TAG, 1, "deleteFile:" + absolutePath + " " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    @NotNull
    public String getAvailableSpace() {
        long j3;
        long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            j3 = SdCardUtil.getAvailableExternalMemorySize(peekAppRuntime.getApplication());
        } else {
            j3 = 0;
        }
        long j16 = availableInternalMemorySize + j3;
        QLog.d(TAG, 1, "getAvailableSpace:" + j16);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            jSONObject.put("data", String.valueOf(j16));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    public float getDeviceBrightness(@Nullable Activity activity) {
        float f16;
        if (activity != null) {
            f16 = activity.getWindow().getAttributes().screenBrightness;
            if (f16 <= 0.0f) {
                try {
                    f16 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness") / 255.0f;
                } catch (Settings.SettingNotFoundException e16) {
                    QLog.e(TAG, 1, e16.getMessage());
                }
            }
        } else {
            f16 = -1.0f;
        }
        QLog.d(TAG, 1, "getDeviceBrightness:" + f16);
        return f16;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    @NotNull
    public String getFileList(@NotNull String absolutePath) {
        String str;
        String[] strArr;
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        try {
            File file = new File(absolutePath);
            if (file.exists() && file.isDirectory()) {
                strArr = file.list();
            } else {
                strArr = null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", 0);
                JSONArray jSONArray = new JSONArray();
                if (strArr != null) {
                    Iterator it = ArrayIteratorKt.iterator(strArr);
                    while (it.hasNext()) {
                        jSONArray.mo162put((String) it.next());
                    }
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16.getCause(), new Object[0]);
            }
            str = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(str, "json.toString()");
        } catch (Exception e17) {
            QLog.e(TAG, 1, e17.getCause(), new Object[0]);
            str = "";
        }
        QLog.d(TAG, 1, "getFileList:" + absolutePath + " " + str);
        return str;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    @NotNull
    public String getFileSize(@NotNull String absolutePath) {
        long j3;
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        File file = new File(absolutePath);
        if (file.exists()) {
            j3 = calculateFileSize(file);
        } else {
            j3 = 0;
        }
        QLog.d(TAG, 1, "getFileSize:" + j3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            jSONObject.put("data", String.valueOf(j3));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    @NotNull
    public String measureText(float textSize, @NotNull String fontFamily, @NotNull String textContent, int maxWidth, float textSpacing, final int fontWeight) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        final TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(ViewUtils.dpToPx(textSize));
        if (fontFamily.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.vas.kuikly.reader.a.f309900a.a(fontFamily, new Function1<Typeface, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasReaderApiImpl$measureText$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Typeface typeface) {
                    invoke2(typeface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Typeface typeface) {
                    Typeface create;
                    int i3 = fontWeight;
                    if (i3 == FontWeight.BOLD.ordinal()) {
                        textPaint.setTypeface(Typeface.create(typeface, 1));
                        return;
                    }
                    if (i3 == FontWeight.THIN.ordinal()) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            TextPaint textPaint2 = textPaint;
                            create = Typeface.create(typeface, 100, false);
                            textPaint2.setTypeface(create);
                            return;
                        }
                        return;
                    }
                    if (i3 == FontWeight.NORMAL.ordinal()) {
                        textPaint.setTypeface(typeface);
                    }
                }
            });
        }
        if (textSpacing > 0.0f) {
            textPaint.setLetterSpacing(textSpacing);
        }
        float[] fArr = new float[1];
        int breakText = textPaint.breakText(textContent, true, maxWidth, fArr);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int i3 = (int) fArr[0];
        float f16 = fontMetrics.bottom - fontMetrics.top;
        float textSpacingFixed = getTextSpacingFixed(maxWidth, i3, breakText, textPaint.getTextSize());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("length", breakText);
        jSONObject.put("measureWidth", i3);
        jSONObject.put("measureHeight", ViewUtils.pxToDp(f16));
        jSONObject.put("textSpacing", String.valueOf(textSpacingFixed));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026g())\n        }.toString()");
        QLog.d(TAG, 2, "measureText: textSize=" + textPaint.getTextSize() + ",fontPath=" + fontFamily + ",textContent=" + textContent + ",maxWidth=" + maxWidth + ",textSpacing=" + textSpacing + ",result=" + jSONObject2);
        return jSONObject2;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    @NotNull
    public String readFile(@NotNull String absolutePath) {
        int i3;
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        String str = "";
        File file = new File(absolutePath);
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    i3 = -3;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            Charset UTF_8 = StandardCharsets.UTF_8;
                            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                            sb5.append(new String(bArr, 0, read, UTF_8));
                        }
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
                        str = sb6;
                        i3 = 0;
                        fileInputStream = fileInputStream2;
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        QLog.e(TAG, 1, e.getCause(), new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                QLog.e(TAG, 1, e17.getCause(), new Object[0]);
                            }
                        }
                        i3 = -4;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ret", i3);
                        jSONObject.put("data", str);
                        QLog.d(TAG, 1, "readFile:" + absolutePath);
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                        return jSONObject2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                QLog.e(TAG, 1, e18.getCause(), new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        QLog.e(TAG, 1, e19.getCause(), new Object[0]);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("ret", i3);
            jSONObject3.put("data", str);
        } catch (JSONException e27) {
            QLog.e(TAG, 1, e27.getCause(), new Object[0]);
        }
        QLog.d(TAG, 1, "readFile:" + absolutePath);
        String jSONObject22 = jSONObject3.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject22, "json.toString()");
        return jSONObject22;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    public int setDeviceBrightness(@Nullable final Activity activity, final float brightness) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.ao
                @Override // java.lang.Runnable
                public final void run() {
                    VasReaderApiImpl.setDeviceBrightness$lambda$0(activity, brightness);
                }
            });
            return 0;
        }
        QLog.d(TAG, 1, "setDeviceBrightness fail");
        return -1;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    public void setVolumeKeyListener(boolean isOn, @Nullable Activity activity, @Nullable Function1<? super Integer, Unit> callback) {
        if (activity instanceof QBaseActivity) {
            if (isOn) {
                ((QBaseActivity) activity).registerActivityLifecycleCallbacks(getVolumeKeyCallBack$default(this, activity, callback, false, 4, null));
            } else {
                ((QBaseActivity) activity).unregisterActivityLifecycleCallbacks(getVolumeKeyCallBack(activity, callback, true));
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasReaderApi
    public int writeFile(@NotNull String absolutePath, boolean isAppend, @NotNull String data) {
        Intrinsics.checkNotNullParameter(absolutePath, "absolutePath");
        Intrinsics.checkNotNullParameter(data, "data");
        File file = new File(absolutePath);
        int i3 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                }
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = data.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, isAppend);
                try {
                    fileOutputStream2.write(bytes);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        QLog.e(TAG, 1, e16.getCause(), new Object[0]);
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    QLog.e(TAG, 1, e.getCause(), new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            QLog.e(TAG, 1, e18.getCause(), new Object[0]);
                        }
                    }
                    i3 = -3;
                    QLog.d(TAG, 1, "writeFile:" + absolutePath + " " + i3);
                    return i3;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            QLog.e(TAG, 1, e19.getCause(), new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
        QLog.d(TAG, 1, "writeFile:" + absolutePath + " " + i3);
        return i3;
    }
}
