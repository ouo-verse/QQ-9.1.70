package com.tencent.mobileqq.filemanager.kuikly.module;

import android.app.Activity;
import android.content.Intent;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JE\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0004JI\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/filemanager/kuikly/module/a;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "i", "j", "d", "l", "fileSetId", "fileSetName", "g", "filePath", "", "c", "finalize", "method", "call", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/filemanager/kuikly/module/a$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f208641e;

        b(Function1<Object, Unit> function1) {
            this.f208641e = function1;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            QLog.d("QQFlashTransferKuiklyModule", 1, "sendMsgToFriend result code: " + requestCode + " result: " + resultCode);
            if (requestCode != 103) {
                return;
            }
            a.this.removeKuiklyRenderLifeCycleCallback(this);
            if (resultCode == -1) {
                Function1<Object, Unit> function1 = this.f208641e;
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", 0);
                    jSONObject.put("msg", "success");
                    function1.invoke(jSONObject);
                    return;
                }
                return;
            }
            Function1<Object, Unit> function12 = this.f208641e;
            if (function12 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", -1);
                jSONObject2.put("msg", "sendMsgToFriend result: " + resultCode);
                function12.invoke(jSONObject2);
            }
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().c(params, getActivity());
    }

    private final boolean c(String filePath) {
        return FileUtils.fileExists(filePath);
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        String fileSaveRootDirectory = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFileSaveRootDirectory();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", true);
        jSONObject.put("rootDirectory", fileSaveRootDirectory);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void g(String fileSetId, String fileSetName, Function1<Object, Unit> callback) {
        Activity activity = getActivity();
        if (activity != null) {
            addKuiklyRenderLifecycleCallback(new b(callback));
            ((IFlashTransferHelperApi) QRoute.api(IFlashTransferHelperApi.class)).sendFlashTransferMsgToFriend(activity, fileSetId, fileSetName, 103);
        }
    }

    private final void j(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("fileSetId");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsJSON.optString(PARAM_FILESET_ID)");
        String fileSetName = jSONObject.optString("fileSetName", "QQ\u95ea\u4f20");
        String uploaderName = jSONObject.optString("uploaderName", "");
        Activity activity = getActivity();
        if (activity != null) {
            IFlashTransferHelperApi iFlashTransferHelperApi = (IFlashTransferHelperApi) QRoute.api(IFlashTransferHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(fileSetName, "fileSetName");
            Intrinsics.checkNotNullExpressionValue(uploaderName, "uploaderName");
            iFlashTransferHelperApi.shareFlashTransferMsg(activity, optString, fileSetName, uploaderName);
        }
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        boolean z16;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String fileSetId = k06.optString("fileSetId", "");
        int optInt = k06.optInt("shareAction", -1);
        String fileSetName = k06.optString("fileSetName", "");
        String uploaderName = k06.optString("uploaderName", "");
        String shareLink = k06.optString("shareLink", "");
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        if (fileSetId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", -1);
                jSONObject.put("msg", "empty fileSet id!");
                callback.invoke(jSONObject);
                return;
            }
            return;
        }
        if (optInt != 2) {
            if (optInt != 9) {
                if (optInt != 123 && callback != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", -1);
                    jSONObject2.put("msg", "action: " + optInt + " not impl!");
                    callback.invoke(jSONObject2);
                    return;
                }
                return;
            }
            IFlashTransferHelperApi iFlashTransferHelperApi = (IFlashTransferHelperApi) QRoute.api(IFlashTransferHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(shareLink, "shareLink");
            Intrinsics.checkNotNullExpressionValue(fileSetName, "fileSetName");
            Intrinsics.checkNotNullExpressionValue(uploaderName, "uploaderName");
            iFlashTransferHelperApi.shareFileSetLinkTextToWeChat(shareLink, fileSetName, uploaderName);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(fileSetName, "fileSetName");
        g(fileSetId, fileSetName, callback);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1582452229:
                if (method.equals("shareFile")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1273230233:
                if (method.equals("shareFileSet")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1222481689:
                if (method.equals("shareUploadedFileSet")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -991207076:
                if (method.equals("getFileSaveRootDirectory")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -164840666:
                if (method.equals("browseFile")) {
                    a(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1404291320:
                if (method.equals("fileExists")) {
                    return Boolean.valueOf(c(params));
                }
                break;
        }
        return super.call(method, params, callback);
    }

    protected final void finalize() {
        QLog.i("QQFlashTransferKuiklyModule", 1, "finalize.");
    }

    private final void i(String params, Function1<Object, Unit> callback) {
    }
}
