package pf2;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.utils.HippyFileManagerUtil;
import com.tencent.hippy.qq.utils.HippyResultCodeCallback;
import com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$JG\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JG\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002JV\u0010\u001b\u001a\u00020\n*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJE\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bJE\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bJE\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b\u00a8\u0006&"}, d2 = {"Lpf2/j;", "", "", "code", "", "imgPath", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "content", "r", "", "imgData", ReportConstant.COSTREPORT_PREFIX, "outMimeType", "j", "i", "msg", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "f", "(Lkotlin/jvm/functions/Function1;ILjava/lang/String;Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule;", "module", "params", "t", "k", "l", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final String f426092b = AppConstants.SDCARD_FILE_SAVE_PATH + "Hippy/Photo/";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"pf2/j$b", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/c$b;", "", "result", "", "filePath", "", "callback", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements c.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f426094b;

        b(Function1<Object, Unit> function1) {
            this.f426094b = function1;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.c.b
        public void callback(int result, String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            j.this.h(result, filePath, this.f426094b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"pf2/j$c", "Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$ScreenShotResultCallBack;", "", "result", "", "filePath", "", "callback", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements ScreenShotHelper.ScreenShotResultCallBack {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f426096b;

        c(Function1<Object, Unit> function1) {
            this.f426096b = function1;
        }

        @Override // com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper.ScreenShotResultCallBack
        public void callback(int result, String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            j.this.h(result, filePath, this.f426096b);
        }
    }

    private final String i() {
        int random = (int) (Math.random() * 10);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "img_%d_%02d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(random)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r9, '/', 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String j(String outMimeType) {
        int indexOf$default;
        if (TextUtils.isEmpty(outMimeType) || indexOf$default == -1) {
            return "";
        }
        String substring = outMimeType.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return "." + substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(j this$0, String imgPath, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imgPath, "$imgPath");
        this$0.q(imgPath, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(j this$0, QQUIModule module, String content, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(module, "$module");
        Intrinsics.checkNotNullParameter(content, "$content");
        this$0.r(module.getContext(), content, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String content, final Function1 function1) {
        Intrinsics.checkNotNullParameter(content, "$content");
        HippyFileManagerUtil.saveImageByBase64(content, function1 != null ? new HippyResultCodeCallback() { // from class: pf2.i
            @Override // com.tencent.hippy.qq.utils.HippyResultCodeCallback
            public final void callBack(HippyMap hippyMap) {
                j.p(Function1.this, hippyMap);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, HippyMap hippyMap) {
        function1.invoke(hippyMap);
    }

    private final void q(String imgPath, Function1<Object, Unit> callback) {
        try {
            if (TextUtils.isEmpty(((IFilePathUtil) QRoute.api(IFilePathUtil.class)).copyImageFileToMediaStorage(imgPath))) {
                if (callback != null) {
                    g(this, callback, -1, ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC, null, 4, null);
                }
            } else if (callback != null) {
                g(this, callback, 0, "\u4fdd\u5b58\u6210\u529f", null, 4, null);
            }
        } catch (Exception unused) {
            if (callback != null) {
                g(this, callback, -2, "\u65e0\u6548\u6570\u636e", null, 4, null);
            }
        } catch (OutOfMemoryError unused2) {
            if (callback != null) {
                g(this, callback, -5, "\u4fdd\u5b58\u5931\u8d25", null, 4, null);
            }
        }
    }

    private final String s(byte[] imgData, Function1<Object, Unit> callback) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(imgData, 0, imgData.length, options);
        String str = options.outMimeType;
        Intrinsics.checkNotNullExpressionValue(str, "opt.outMimeType");
        String j3 = j(str);
        if (TextUtils.isEmpty(j3)) {
            if (callback != null) {
                g(this, callback, -2, "\u65e0\u6548\u6570\u636e", null, 4, null);
            }
            return "";
        }
        try {
            String str2 = f426092b;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = str2 + i() + j3;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
            fileOutputStream.write(imgData);
            fileOutputStream.close();
            return str3;
        } catch (IOException unused) {
            if (callback != null) {
                g(this, callback, -5, "\u4fdd\u5b58\u5931\u8d25", null, 4, null);
            }
            return "";
        }
    }

    public final void k(QQUIModule module, String params, Function1<Object, Unit> callback) {
        Window window;
        Intrinsics.checkNotNullParameter(module, "module");
        if (TextUtils.isEmpty(params)) {
            h(-1, "", callback);
            return;
        }
        try {
            Intrinsics.checkNotNull(params);
            JSONObject jSONObject = new JSONObject(params);
            int i3 = jSONObject.getInt("rootViewId");
            Activity activity = module.getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            if (decorView == null) {
                h(-1, "", callback);
                return;
            }
            View findViewById = decorView.findViewById(i3);
            if (findViewById == null) {
                findViewById = module.viewWithTag(i3);
            }
            if (findViewById != null) {
                decorView = findViewById;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("hideViewIds");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    View viewWithTag = module.viewWithTag(optJSONArray.getInt(i16));
                    if (viewWithTag != null) {
                        arrayList.add(viewWithTag);
                    }
                }
            }
            new com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.c().o(decorView, arrayList, new b(callback));
        } catch (Exception e16) {
            QLog.e("ImageProcessImpl", 1, "longScreenShot exception", e16);
            h(-1, "", callback);
        }
    }

    public final void l(final QQUIModule module, String params, final Function1<Object, Unit> callback) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(module, "module");
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                g(this, callback, -2, "\u65e0\u6548\u6570\u636e", null, 4, null);
                return;
            }
            return;
        }
        if (!BaseForwardUtil.b(module.getActivity())) {
            if (callback != null) {
                g(this, callback, -3, "\u65e0\u76f8\u518c\u8bbf\u95ee\u6743\u9650", null, 4, null);
                return;
            }
            return;
        }
        try {
            Intrinsics.checkNotNull(params);
            JSONObject jSONObject = new JSONObject(params);
            final String optString = jSONObject.optString("imgPath", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(IMG_PATH, \"\")");
            final String optString2 = jSONObject.optString("content", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(CONTENT, \"\")");
            if (TextUtils.isEmpty(optString)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(optString2, "http://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(optString2, "https://", false, 2, null);
                    if (!startsWith$default2) {
                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(optString2, "data:", false, 2, null);
                        if (startsWith$default3) {
                            ThreadManagerV2.excute(new Runnable() { // from class: pf2.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    j.o(optString2, callback);
                                }
                            }, 64, null, true);
                        } else if (callback != null) {
                            g(this, callback, -2, "\u65e0\u6548\u6570\u636e", null, 4, null);
                        }
                    }
                }
                ThreadManagerV2.excute(new Runnable() { // from class: pf2.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.n(j.this, module, optString2, callback);
                    }
                }, 128, null, true);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: pf2.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.m(j.this, optString, callback);
                    }
                }, 64, null, true);
            }
        } catch (Exception unused) {
            if (callback != null) {
                g(this, callback, -5, "\u4fdd\u5b58\u5931\u8d25", null, 4, null);
            }
        }
    }

    public final void t(QQUIModule module, String params, Function1<Object, Unit> callback) {
        Window window;
        Intrinsics.checkNotNullParameter(module, "module");
        if (TextUtils.isEmpty(params)) {
            h(-1, "", callback);
            return;
        }
        try {
            Intrinsics.checkNotNull(params);
            int i3 = new JSONObject(params).getInt("rootViewId");
            Activity activity = module.getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            if (decorView == null) {
                h(-1, "", callback);
                return;
            }
            View findViewById = decorView.findViewById(i3);
            if (findViewById == null) {
                findViewById = module.viewWithTag(i3);
            }
            if (findViewById != null) {
                decorView = findViewById;
            }
            new ScreenShotHelper().screenShot(decorView, new c(callback));
        } catch (Exception e16) {
            QLog.e("ImageProcessImpl", 1, "screenShot exception", e16);
            h(-1, "", callback);
        }
    }

    private final void f(Function1<Object, Unit> function1, int i3, String str, Integer num) {
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", i3);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (num != null) {
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, num.intValue());
            }
            function1.invoke(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int code, String imgPath, Function1<Object, Unit> callback) {
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", code);
            jSONObject.put("imgPath", imgPath);
            callback.invoke(jSONObject.toString());
        }
    }

    static /* synthetic */ void g(j jVar, Function1 function1, int i3, String str, Integer num, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        if ((i16 & 4) != 0) {
            num = null;
        }
        jVar.f(function1, i3, str, num);
    }

    private final void r(Context context, String content, Function1<Object, Unit> callback) {
        try {
            HttpResponse openRequest = HttpUtil.openRequest(context, content, null, "GET", null, null);
            int statusCode = openRequest != null ? openRequest.getStatusLine().getStatusCode() : 0;
            if (statusCode == 200) {
                byte[] imgData = HttpUtil.readHttpResponseSteam(openRequest).toByteArray();
                Intrinsics.checkNotNullExpressionValue(imgData, "imgData");
                String s16 = s(imgData, callback);
                if (!TextUtils.isEmpty(s16)) {
                    q(s16, callback);
                    return;
                }
            } else if (callback != null) {
                f(callback, -4, "\u4e0b\u8f7d\u5931\u8d25", Integer.valueOf(statusCode));
            }
            if (callback != null) {
                g(this, callback, -5, "\u4fdd\u5b58\u5931\u8d25", null, 4, null);
            }
        } catch (IOException unused) {
            if (callback != null) {
                g(this, callback, -5, "\u4fdd\u5b58\u5931\u8d25", null, 4, null);
            }
        } catch (IllegalArgumentException unused2) {
            if (callback != null) {
                g(this, callback, -2, "\u65e0\u6548\u6570\u636e", null, 4, null);
            }
        }
    }
}
