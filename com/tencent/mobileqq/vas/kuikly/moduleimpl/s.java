package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import eipc.EIPCCallback;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b$\u0010%J;\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJE\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ3\u0010\u0010\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ3\u0010\u0013\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ3\u0010\u0019\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ3\u0010\u001c\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ;\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/s;", "", "", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "M", "B", "iconId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "E", ColorRingJsPlugin.Method_SetUp, "I", "id", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "G", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "params", "D", "u", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "a", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "report", "<init>", "()V", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasJsbCommonReport report = VasJsbCommonReport.INSTANCE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void B(@Nullable final Function1<Object, Unit> callback) {
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.q
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.C(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.quickSwitchDefaultMode(a16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.graphics.Bitmap$CompressFormat] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(@NotNull String params, @Nullable Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Bitmap decodeFile;
        Map mapOf3;
        String str;
        long j3;
        boolean z16;
        ?? r36;
        Object obj;
        ?? r26;
        Map mapOf4;
        Map mapOf5;
        Map mapOf6;
        Map mapOf7;
        ?? r37 = "msg";
        ?? r46 = "result";
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            QLog.i("GXH", 1, "setBackgroundPhoto=" + jSONObject);
            String decode = URLDecoder.decode(jSONObject.optString("imagePath"), "utf-8");
            try {
                if (!new File(decode).exists()) {
                    QLog.e("GXH", 1, "file[" + decode + "] not exists");
                    if (callback != null) {
                        mapOf7 = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "1"), TuplesKt.to("msg", "\u56fe\u7247\u4e0d\u5b58\u5728\uff0c\u8bf7\u66f4\u6362\u56fe\u7247"));
                        callback.invoke(mapOf7);
                        return;
                    }
                    return;
                }
                try {
                    if (com.tencent.mobileqq.vas.ar.INSTANCE.b("linkliang", "2024-08-16", "vas_bug_128652515").isEnable(true)) {
                        decodeFile = BitmapUtil.decodeFile(decode);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(decode);
                    }
                    int width = decodeFile.getWidth();
                    int height = decodeFile.getHeight();
                    String optString = jSONObject.optString("left");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"left\")");
                    float parseFloat = Float.parseFloat(optString);
                    String optString2 = jSONObject.optString("top");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"top\")");
                    float parseFloat2 = Float.parseFloat(optString2);
                    String optString3 = jSONObject.optString("right");
                    Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"right\")");
                    float parseFloat3 = Float.parseFloat(optString3);
                    String optString4 = jSONObject.optString("bottom");
                    Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"bottom\")");
                    float parseFloat4 = Float.parseFloat(optString4);
                    int optInt = jSONObject.optInt("effectID");
                    boolean optBoolean = jSONObject.optBoolean("isNormalSize");
                    String uin = jSONObject.optString("friendUin");
                    int optInt2 = jSONObject.optInt("uinType");
                    float f16 = 0;
                    float f17 = width;
                    float f18 = height;
                    Pair pair = TuplesKt.to(Integer.valueOf((int) ((parseFloat * f17) + f16)), Integer.valueOf((int) (f16 + (parseFloat2 * f18))));
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    Pair pair2 = TuplesKt.to(Integer.valueOf((int) (f17 - (parseFloat3 * f17))), Integer.valueOf((int) (f18 - (parseFloat4 * f18))));
                    int intValue3 = ((Number) pair2.component1()).intValue();
                    int intValue4 = ((Number) pair2.component2()).intValue();
                    if (parseFloat >= 0.01f || parseFloat2 >= 0.01f || parseFloat3 >= 0.01f || parseFloat4 >= 0.01f) {
                        try {
                            decodeFile = Bitmap.createBitmap(decodeFile, intValue, intValue2, intValue3 - intValue, intValue4 - intValue2);
                        } catch (Throwable th5) {
                            QLog.e("GXH", 1, th5, new Object[0]);
                            if (callback != null) {
                                mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "3"), TuplesKt.to("msg", "\u5185\u5b58\u4e0d\u8db3\uff0c\u8bf7\u6e05\u7406\u5185\u5b58\u540e\u91cd\u8bd5"));
                                callback.invoke(mapOf3);
                                return;
                            }
                            return;
                        }
                    }
                    Bitmap bitmap = decodeFile;
                    if (ThemeDiyStyleLogic.isNewCustomBackground) {
                        str = ThemeDiyStyleLogic.getNewCustomBackgroundPath();
                    } else {
                        str = ThemeDiyStyleLogic.getDataDIYDir() + System.currentTimeMillis() + ".jpg";
                    }
                    String savePath = str;
                    QLog.i("GXH", 1, "savePath = " + savePath);
                    File file = new File(savePath);
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                    if (!file.exists()) {
                        if (callback != null) {
                            mapOf6 = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "4"), TuplesKt.to("msg", "\u6587\u4ef6\u9519\u8bef"));
                            callback.invoke(mapOf6);
                            return;
                        }
                        return;
                    }
                    long j16 = JoinTimeType.THIRTY_MINUTES;
                    if (optBoolean) {
                        j3 = 900;
                    } else {
                        j3 = 1800;
                    }
                    if (!optBoolean) {
                        j16 = 3600;
                    }
                    long width2 = bitmap.getWidth();
                    long height2 = bitmap.getHeight();
                    if (width2 > j3) {
                        try {
                            z16 = true;
                            r36 = (height2 * j3) / width2;
                        } catch (Throwable unused) {
                            r46 = "msg";
                            r37 = "result";
                            if (callback != null) {
                                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(r37, "100"), TuplesKt.to(r46, "\u8bf7\u66f4\u6362\u56fe\u7247\u540e\u91cd\u8bd5"));
                                callback.invoke(mapOf);
                                return;
                            }
                            return;
                        }
                    } else {
                        j3 = width2;
                        z16 = false;
                        r36 = height2;
                    }
                    if ((r36 == true ? 1L : 0L) > j16) {
                        j3 = (j3 * j16) / (r36 == true ? 1L : 0L);
                        z16 = true;
                    } else {
                        j16 = r36 == true ? 1 : 0;
                    }
                    if (!z16) {
                        obj = "msg";
                        r26 = bitmap;
                        r37 = r36;
                        r46 = r46;
                    } else {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap((int) j3, (int) j16, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            obj = "msg";
                            try {
                                r37 = 0;
                                canvas.drawBitmap(bitmap, rect, new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), (Paint) null);
                                bitmap.recycle();
                                try {
                                    QLog.i("GXH", 1, "scale to " + j3 + " - " + j16);
                                    r26 = createBitmap;
                                    r46 = rect;
                                } catch (Throwable th6) {
                                    th = th6;
                                    bitmap = createBitmap;
                                    try {
                                        Object[] objArr = new Object[0];
                                        r37 = 1;
                                        QLog.e("GXH", 1, th, objArr);
                                        r26 = bitmap;
                                        r46 = objArr;
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            r37 = Bitmap.CompressFormat.JPEG;
                                            r46 = 100;
                                            r26.compress(r37, 100, fileOutputStream);
                                            fileOutputStream.flush();
                                            fileOutputStream.close();
                                            IGXHManager gxh = VasUtil.getService().getGxh();
                                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                                            Intrinsics.checkNotNullExpressionValue(savePath, "savePath");
                                            IGXHManager.b.a(gxh, uin, savePath, optInt, optInt2, false, 16, null);
                                            if (callback == null) {
                                            }
                                        } catch (Throwable th7) {
                                            QLog.e("GXH", 1, th7, new Object[0]);
                                            if (callback != null) {
                                                Pair[] pairArr = new Pair[2];
                                                pairArr[0] = TuplesKt.to("result", "5");
                                                pairArr[1] = TuplesKt.to(obj, "\u8bbe\u5907\u7a7a\u95f4\u4e0d\u8db3\uff0c\u8bf7\u6e05\u7406\u7f13\u5b58\u540e\u91cd\u8bd5");
                                                mapOf4 = MapsKt__MapsKt.mapOf(pairArr);
                                                callback.invoke(mapOf4);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable unused2) {
                                        r37 = "result";
                                        r46 = obj;
                                        if (callback != null) {
                                        }
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            obj = "msg";
                        }
                    }
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        r37 = Bitmap.CompressFormat.JPEG;
                        r46 = 100;
                        r26.compress(r37, 100, fileOutputStream2);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        IGXHManager gxh2 = VasUtil.getService().getGxh();
                        Intrinsics.checkNotNullExpressionValue(uin, "uin");
                        Intrinsics.checkNotNullExpressionValue(savePath, "savePath");
                        IGXHManager.b.a(gxh2, uin, savePath, optInt, optInt2, false, 16, null);
                        if (callback == null) {
                            mapOf5 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", "0"));
                            callback.invoke(mapOf5);
                        }
                    } catch (Throwable unused3) {
                        r46 = obj;
                        if (callback != null) {
                        }
                    }
                } catch (Throwable th10) {
                    QLog.e("GXH", 1, th10, new Object[0]);
                    if (callback != null) {
                        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "2"), TuplesKt.to("msg", "\u5185\u5b58\u4e0d\u8db3\uff0c\u8bf7\u6e05\u7406\u5185\u5b58\u540e\u91cd\u8bd5"));
                        callback.invoke(mapOf2);
                    }
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            r46 = "msg";
            r37 = "result";
        }
    }

    public final void E(@NotNull String iconId, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(iconId, "iconId");
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.n
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.F(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.setClientAppIconId(iconId, a16);
    }

    public final void G(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        VasUtil.getService().getGxh().setLocalToggleStatus(jsonString, EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.l
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.H(Function1.this, str);
            }
        }));
    }

    public final void I(@NotNull String setup, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(setup, "setup");
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.m
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.J(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.setMagicFont(setup, a16);
    }

    public final void K(@NotNull String id5, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.r
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.L(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.setMagicFontType(id5, a16);
    }

    public final void M(@Nullable Activity activity, @NotNull String jsonString, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "queryDownloadStatus " + jsonString);
        String optString = new JSONObject(jsonString).optString("id");
        if (callback != null) {
            callback.invoke(VasInjectApi.getInstance().wallpaperSetChatBg(activity, optString));
        }
    }

    public final void m(@NotNull String iconId, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(iconId, "iconId");
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.i
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.n(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.checkAppIconEnable(iconId, a16);
    }

    public final void o(@Nullable final Function1<Object, Unit> callback) {
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.k
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.p(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.getClientAppIconId(a16);
    }

    public final void q(@Nullable final Function1<Object, Unit> callback) {
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.o
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.r(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.getCustomBgList(a16);
    }

    public final void s(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        VasUtil.getService().getGxh().getLocalToggleStatus(jsonString, EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.h
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.t(Function1.this, str);
            }
        }));
    }

    public final void u(@NotNull String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String troopUin = jSONObject.optString("troopUin");
            String memberUin = jSONObject.optString("memberUin");
            ITroopIdentityApi iTroopIdentityApi = (ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class);
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            Intrinsics.checkNotNullExpressionValue(memberUin, "memberUin");
            JSONObject cachedIdentityTitleInfo = iTroopIdentityApi.getCachedIdentityTitleInfo(troopUin, memberUin);
            if (callback != null) {
                callback.invoke(cachedIdentityTitleInfo);
            }
        } catch (Exception e16) {
            QLog.e("GXH", 1, "[getMemberTitleInfo] params = " + params + " exception = " + e16);
            if (callback != null) {
                callback.invoke(new JSONObject());
            }
        }
    }

    public final void v(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "queryDownloadStatus " + jsonString);
        JSONObject jSONObject = new JSONObject(jsonString);
        IGXHManager gxh = VasUtil.getService().getGxh();
        String optString = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"setKey\")");
        String optString2 = jSONObject.optString("business");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"business\")");
        String jSONObject2 = jSONObject.optJSONObject("data").toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.optJSONObject(\"data\").toString()");
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.j
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.w(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.notify(optString, optString2, jSONObject2, a16);
    }

    public final void x(@Nullable final Function1<Object, Unit> callback) {
        IGXHManager gxh = VasUtil.getService().getGxh();
        EIPCCallbackWrapper newInstance = EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.g
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.y(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance {\n          \u2026.invoke(it)\n            }");
        gxh.openMobilePhotoSelect(newInstance);
    }

    public final void z(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "queryDownloadStatus " + jsonString);
        JSONObject jSONObject = new JSONObject(jsonString);
        IGXHManager gxh = VasUtil.getService().getGxh();
        String optString = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"setKey\")");
        int optInt = jSONObject.optInt("itemId");
        String optString2 = jSONObject.optString("business");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"business\")");
        long parseLong = Long.parseLong(optString2);
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.p
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                s.A(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.queryInfo(optString, optInt, parseLong, a16);
    }
}
