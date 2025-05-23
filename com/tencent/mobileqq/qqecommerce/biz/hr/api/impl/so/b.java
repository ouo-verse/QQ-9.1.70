package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/h;", "", "f", "d", "", "c", "path", "Ljava/io/File;", "b", "filepath", "", tl.h.F, "e", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "", "loadLibrary", "a", "Z", "loadSuccess", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loadSuccess;

    private final File b(String path) {
        File file = new File(path);
        if (file.exists()) {
            FileUtils.deleteFile(path);
        }
        return file;
    }

    private final int c() {
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            return 897;
        }
        Intrinsics.checkNotNull(d16);
        File b16 = b(d16);
        if (!HttpDownloadUtil.download((AppRuntime) null, f(), b16) || !b16.exists()) {
            return 898;
        }
        if (!h(d16)) {
            return 899;
        }
        System.load(e() + "libj2v8.so");
        return 900;
    }

    private final String d() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY + "viola/j2v8.zip");
    }

    private final String e() {
        return BaseApplication.context.getFilesDir().getParent() + "/txlib/nativevue/arm64-v8a/";
    }

    private final String f() {
        return "https://kd.qpic.cn/kamlin/libj2v8_64_e4623432.zip";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            int c16 = this$0.c();
            if (c16 == 900) {
                this$0.loadSuccess = true;
                if (hVar != null) {
                    hVar.b(c16);
                }
            } else {
                this$0.loadSuccess = false;
                if (hVar != null) {
                    hVar.onError(c16);
                }
            }
        } catch (Throwable th5) {
            QLog.e("CDNLoader", 1, "cdn load so error: " + th5.getMessage());
            if (hVar != null) {
                hVar.onError(896);
            }
        }
    }

    private final boolean h(String filepath) {
        boolean z16;
        synchronized (this) {
            z16 = true;
            try {
                FileUtils.uncompressZip(filepath, e(), false);
            } catch (Exception e16) {
                QLog.e("ViolaCdnSoLoader", 1, "unzip error: " + e16);
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.h
    public void loadLibrary(String from, final com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (!this.loadSuccess) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.g(b.this, callback);
                }
            }, 128, null, false);
        } else if (callback != null) {
            callback.b(900);
        }
    }
}
