package com.tencent.mobileqq.filemanager.util;

import android.app.Dialog;
import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R<\u0010\u001c\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u00188\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00070\u00070\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/FileSelectComposeUploadRunnable;", "Ljava/lang/Runnable;", "Lkotlin/Function0;", "", "block", "", "f", "Landroid/content/Context;", "context", tl.h.F, "e", TencentLocation.RUN_MODE, "", "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "d", "Ljava/util/List;", "getFileList", "()Ljava/util/List;", "fileList", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "callback", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "contextRef", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "loadingDialog", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
final class FileSelectComposeUploadRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<FileInfo> fileList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Object, Unit> callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    private final boolean e() {
        return f(new Function0<Unit>() { // from class: com.tencent.mobileqq.filemanager.util.FileSelectComposeUploadRunnable$dismissLoadingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog;
                dialog = FileSelectComposeUploadRunnable.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                FileSelectComposeUploadRunnable.this.loadingDialog = null;
            }
        });
    }

    private final boolean f(final Function0<Unit> block) {
        return ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.o
            @Override // java.lang.Runnable
            public final void run() {
                FileSelectComposeUploadRunnable.g(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final boolean h(final Context context) {
        return f(new Function0<Unit>() { // from class: com.tencent.mobileqq.filemanager.util.FileSelectComposeUploadRunnable$showLoadingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog;
                Dialog dialog2;
                dialog = FileSelectComposeUploadRunnable.this.loadingDialog;
                if (dialog == null) {
                    FileSelectComposeUploadRunnable.this.loadingDialog = LoadingUtil.showLoadingDialog(context, "\u52a0\u8f7d\u4e2d", false);
                }
                dialog2 = FileSelectComposeUploadRunnable.this.loadingDialog;
                if (dialog2 != null) {
                    dialog2.show();
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.contextRef.get();
        if (context == null) {
            context = MobileQQ.sMobileQQ;
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        h(context);
        JSONObject jSONObject = new JSONObject();
        boolean z16 = false;
        jSONObject.put("result", 0);
        jSONObject.put("msg", "success");
        JSONObject jSONObject2 = new JSONObject();
        r rVar = r.f209402a;
        jSONObject2.put("name", rVar.c(this.fileList));
        jSONObject2.put("uploaders", rVar.d());
        jSONObject2.put("paths", rVar.a(this.fileList));
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject2.put(QQWinkConstants.COVER_PATH, rVar.b(context, this.fileList));
        jSONObject.put("uploadParam", jSONObject2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("do file upload callback cost: ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        sb5.append("ms callback null: ");
        if (this.callback == null) {
            z16 = true;
        }
        sb5.append(z16);
        com.tencent.xaction.log.b.a("FlashTransferFileSelectorUtils", 1, sb5.toString());
        e();
        Function1<Object, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
    }
}
