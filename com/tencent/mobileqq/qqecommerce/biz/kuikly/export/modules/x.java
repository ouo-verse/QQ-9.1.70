package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThreeDes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.JM\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0002J*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0004H\u0002JM\u0010 \u001a\u00020\f2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J?\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0002J?\u0010#\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0002J?\u0010$\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0002JI\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0016J\b\u0010(\u001a\u00020\fH\u0016R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/x;", "Li01/e;", "", "ret", "", "msg", "resData", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "path", "key", "host", "Lmqq/app/AppRuntime;", "appRuntime", "i", "uin", "Ljava/io/File;", "o", "pathDir", "encryptData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "rspObject", "hash", "file", "p", "jsonParams", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "j", "method", "params", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lqf2/a;", "d", "Lqf2/a;", "entityHelper", "<init>", "()V", "e", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class x extends i01.e {

    /* renamed from: f, reason: collision with root package name */
    private static final String f263067f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private qf2.a entityHelper = new qf2.a();

    static {
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qqgame/");
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "getSDKPrivatePath(AppCon\u2026.SDCARD_PATH + \"qqgame/\")");
        f263067f = sDKPrivatePath;
    }

    private final int i(String path, String key, String host, AppRuntime appRuntime) {
        if (TextUtils.isEmpty(path)) {
            return -6;
        }
        if (TextUtils.isEmpty(key)) {
            return -7;
        }
        if (TextUtils.isEmpty(host)) {
            return -13;
        }
        return (appRuntime == null || !appRuntime.isLogin()) ? -11 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [org.json.JSONObject, T] */
    private final void j(String jsonParams, final Function1<Object, Unit> callback) {
        if (jsonParams == null) {
            return;
        }
        try {
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            JSONObject jSONObject = new JSONObject(jsonParams);
            String optString = jSONObject.optString("callId", "");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_CALL_ID, \"\")");
            final String optString2 = jSONObject.optString("host");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_HOST)");
            final String optString3 = jSONObject.optString("path");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(KEY_PATH)");
            final String optString4 = jSONObject.optString("key");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(KEY_DATA_KEY)");
            final int optInt = jSONObject.optInt("delAllHostData", 0);
            int i3 = i(optString3, optString4, optString2, peekAppRuntime);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? jSONObject2 = new JSONObject();
            objectRef.element = jSONObject2;
            jSONObject2.put("callId", optString);
            if (i3 != 0) {
                String jSONObject3 = ((JSONObject) objectRef.element).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "resData.toString()");
                g(i3, "", jSONObject3, callback);
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.v
                @Override // java.lang.Runnable
                public final void run() {
                    x.l(AppRuntime.this, this, optString2, optString3, optString4, optInt, objectRef, callback);
                }
            }, 64, null, false);
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebDataModule", 1, "writeH5Data e:", e16);
            g(-1, "", "", callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(AppRuntime appRuntime, x this$0, String host, String path, String key, int i3, Ref.ObjectRef resData, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(resData, "$resData");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        this$0.entityHelper.a(host, path, key, i3 == 1);
        String str = f263067f + "/" + HexUtil.string2HexString(currentAccountUin) + "/" + host;
        if (i3 != 1) {
            str = str + "/" + HexUtil.string2HexString(path);
            if (!TextUtils.isEmpty(key)) {
                str = str + "/" + HexUtil.string2HexString(key);
            }
        }
        com.tencent.mobileqq.filemanager.util.q.c(new File(str));
        String jSONObject = ((JSONObject) resData.element).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "resData.toString()");
        this$0.g(0, "", jSONObject, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m(String key, File pathDir, String encryptData) {
        FileWriter fileWriter;
        IOException e16;
        File file = new File(pathDir, HexUtil.string2HexString(key));
        if (file.exists()) {
            file.delete();
        }
        int i3 = -9;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (IOException e17) {
                fileWriter = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileWriter2 != null) {
                }
                throw th;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        try {
            try {
                fileWriter.write(encryptData);
                fileWriter.close();
                i3 = 0;
            } catch (Throwable th6) {
                th = th6;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e26) {
            e16 = e26;
            e16.printStackTrace();
            if (fileWriter != null) {
                fileWriter.close();
            }
            return i3;
        }
        return i3;
    }

    private final File o(String host, String path, String uin) {
        File file = new File(f263067f + "/" + HexUtil.string2HexString(uin));
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        File file2 = new File(file, host);
        if (!file2.exists()) {
            file2.mkdirs();
        } else if (file2.isFile()) {
            file2.delete();
            file2.mkdirs();
        }
        File file3 = new File(file2, HexUtil.string2HexString(path));
        if (!file3.exists()) {
            file3.mkdirs();
        } else if (file3.isFile()) {
            file3.delete();
            file3.mkdirs();
        }
        return file3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.json.JSONObject, T] */
    private final void q(String jsonParams, final Function1<Object, Unit> callback) {
        if (jsonParams == null) {
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            JSONObject jSONObject = new JSONObject(jsonParams);
            String optString = jSONObject.optString("callId");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_CALL_ID)");
            final String optString2 = jSONObject.optString("host");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_HOST)");
            final String optString3 = jSONObject.optString("path");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(KEY_PATH)");
            final String optString4 = jSONObject.optString("key");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(KEY_DATA_KEY)");
            int i3 = i(optString3, optString4, optString2, peekAppRuntime);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? jSONObject2 = new JSONObject();
            objectRef.element = jSONObject2;
            jSONObject2.put("callId", optString);
            if (i3 != 0) {
                String jSONObject3 = ((JSONObject) objectRef.element).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "resData.toString()");
                g(i3, "", jSONObject3, callback);
            } else {
                final String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.r(x.this, optString2, optString3, optString4, objectRef, callback, currentAccountUin);
                    }
                }, 64, null, false);
            }
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebDataModule", 1, "readH5Data e:", e16);
            g(-1, "", "", callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(x this$0, String host, String path, String key, Ref.ObjectRef resData, Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(resData, "$resData");
        String d16 = this$0.entityHelper.d(host, path, key);
        if (TextUtils.isEmpty(d16)) {
            String jSONObject = ((JSONObject) resData.element).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "resData.toString()");
            this$0.g(-11, "hash is empty", jSONObject, function1);
            return;
        }
        File file = new File(f263067f + "/" + HexUtil.string2HexString(str) + "/" + host + "/" + HexUtil.string2HexString(path) + "/" + HexUtil.string2HexString(key));
        if (!file.exists()) {
            String jSONObject2 = ((JSONObject) resData.element).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "resData.toString()");
            this$0.g(-11, "file not exists", jSONObject2, function1);
        } else {
            JSONObject jSONObject3 = (JSONObject) resData.element;
            Intrinsics.checkNotNull(d16);
            this$0.p(function1, jSONObject3, d16, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(x this$0, String host, String path, String key, String hash, Ref.ObjectRef uin, String data, Ref.IntRef returnCode, Ref.ObjectRef resData, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(hash, "$hash");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(returnCode, "$returnCode");
        Intrinsics.checkNotNullParameter(resData, "$resData");
        if (this$0.entityHelper.e(host, path, key, hash)) {
            T uin2 = uin.element;
            Intrinsics.checkNotNullExpressionValue(uin2, "uin");
            File o16 = this$0.o(host, path, (String) uin2);
            String encryptData = ThreeDes.encode(data, hash);
            Intrinsics.checkNotNullExpressionValue(encryptData, "encryptData");
            returnCode.element = this$0.m(key, o16, encryptData);
        } else {
            returnCode.element = -1;
        }
        int i3 = returnCode.element;
        String jSONObject = ((JSONObject) resData.element).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "resData.toString()");
        this$0.g(i3, "success", jSONObject, function1);
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("QQKuiklyWebDataModule", 1, "call method=" + method + " params=" + params);
        int hashCode = method.hashCode();
        if (hashCode != -1134524510) {
            if (hashCode != -874676403) {
                if (hashCode == 1037755094 && method.equals(IH5DataCacheApi.METHOD_WRITE_H5_DATA)) {
                    t(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals(IH5DataCacheApi.METHOD_READ_H5_DATA)) {
                q(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals(IH5DataCacheApi.METHOD_DELETE_H5_DATA)) {
            j(params, callback);
        }
        return Unit.INSTANCE;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
    }

    private final void p(Function1<Object, Unit> callback, JSONObject rspObject, String hash, File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    synchronized (this) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                long length = file.length();
                                try {
                                    if (length <= 0) {
                                        String jSONObject = rspObject.toString();
                                        Intrinsics.checkNotNullExpressionValue(jSONObject, "rspObject.toString()");
                                        g(-11, "", jSONObject, callback);
                                        fileInputStream.close();
                                        return;
                                    }
                                    byte[] bArr = new byte[(int) length];
                                    fileInputStream.read(bArr);
                                    String str = new String(bArr, Charsets.UTF_8);
                                    if (TextUtils.isEmpty(str)) {
                                        String jSONObject2 = rspObject.toString();
                                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "rspObject.toString()");
                                        g(-11, "", jSONObject2, callback);
                                        QLog.e("QQKuiklyWebDataModule", 1, "readDataFile string is null, byteData = " + bArr);
                                        fileInputStream.close();
                                        return;
                                    }
                                    String decode = ThreeDes.decode(str, hash);
                                    if (decode == null) {
                                        String jSONObject3 = rspObject.toString();
                                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "rspObject.toString()");
                                        g(-11, "", jSONObject3, callback);
                                        fileInputStream.close();
                                        return;
                                    }
                                    rspObject.put("data", decode);
                                    String jSONObject4 = rspObject.toString();
                                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "rspObject.toString()");
                                    g(0, "", jSONObject4, callback);
                                    Unit unit = Unit.INSTANCE;
                                } catch (IOException unused) {
                                    fileInputStream2 = fileInputStream;
                                    String jSONObject5 = rspObject.toString();
                                    Intrinsics.checkNotNullExpressionValue(jSONObject5, "rspObject.toString()");
                                    g(-9, "", jSONObject5, callback);
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                fileInputStream2 = fileInputStream;
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private final void g(int ret, String msg2, String resData, Function1<Object, Unit> callback) {
        if (callback == null) {
            return;
        }
        if (ret != 0) {
            QLog.w("QQKuiklyWebDataModule", 1, "callBack, ret=" + ret + " msg=" + msg2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", ret);
            if (!TextUtils.isEmpty(msg2)) {
                jSONObject.put("message", msg2);
            }
            if (resData != null) {
                jSONObject.put("response", resData);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQKuiklyWebDataModule", 1, "callBack invoke=" + jSONObject);
            }
            callback.invoke(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebDataModule", 1, "callBack: exception=", e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [org.json.JSONObject, T] */
    private final void t(String jsonParams, final Function1<Object, Unit> callback) {
        if (jsonParams == null) {
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            JSONObject jSONObject = new JSONObject(jsonParams);
            String optString = jSONObject.optString("callId");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_CALL_ID)");
            final String optString2 = jSONObject.optString("host");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_HOST)");
            final String optString3 = jSONObject.optString("path");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(KEY_PATH)");
            final String optString4 = jSONObject.optString("key");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(KEY_DATA_KEY)");
            final String string = jSONObject.getString("data");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(KEY_DATA)");
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = i(optString3, optString4, optString2, peekAppRuntime);
            if (TextUtils.isEmpty(string)) {
                intRef.element = -8;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? jSONObject2 = new JSONObject();
            objectRef.element = jSONObject2;
            jSONObject2.put("callId", optString);
            int i3 = intRef.element;
            if (i3 != 0) {
                String jSONObject3 = ((JSONObject) objectRef.element).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "resData.toString()");
                g(i3, "", jSONObject3, callback);
                return;
            }
            QQKuiklyCommUtil.Companion companion = QQKuiklyCommUtil.INSTANCE;
            if (companion.a(f263067f) > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                intRef.element = -12;
            }
            int i16 = intRef.element;
            if (i16 != 0) {
                String jSONObject4 = ((JSONObject) objectRef.element).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject4, "resData.toString()");
                g(i16, "", jSONObject4, callback);
            } else {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = peekAppRuntime.getCurrentAccountUin();
                final String d16 = companion.d(string);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.u(x.this, optString2, optString3, optString4, d16, objectRef2, string, intRef, objectRef, callback);
                    }
                }, 64, null, false);
            }
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebDataModule", 1, "writeH5Data e:", e16);
            g(-1, "", "", callback);
        }
    }
}
