package hb3;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import hb3.f;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lhb3/b;", "Lhb3/a;", "Lhb3/f$b;", "callback", "", "b", "success", "", "message", "", "c", "url", "filePath", "a", "clean", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbacks", "", "Ljava/lang/Object;", "copyLock", "Z", "hasCallback", "<init>", "()V", "d", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements hb3.a {

    /* renamed from: d, reason: collision with root package name */
    private static final a f404651d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<f.b> callbacks = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Object copyLock = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lhb3/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final boolean b(f.b callback) {
        synchronized (this.copyLock) {
            if (this.hasCallback) {
                if (callback != null) {
                    this.callbacks.add(callback);
                }
                return false;
            }
            if (callback != null) {
                this.callbacks.add(callback);
            }
            this.hasCallback = true;
            return true;
        }
    }

    private final void c(boolean success, String message) {
        synchronized (this.copyLock) {
            Iterator<f.b> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().a(success, message);
            }
            this.callbacks.clear();
            this.hasCallback = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // hb3.a
    public void a(String url, String filePath, f.b callback) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (startsWith$default) {
            QLog.e("[wxa-q]WxaAssetsDownloader", 1, "downloadPackage error in url");
            if (callback != null) {
                callback.a(false, "error url not in assets");
                return;
            }
            return;
        }
        if (f.h().e()) {
            QLog.i("[wxa-q]WxaAssetsDownloader", 1, "downloadDynamicPackage already exsit");
            if (callback != null) {
                callback.a(true, "already exsit");
                return;
            }
            return;
        }
        if (!b(callback)) {
            QLog.w("[wxa-q]WxaAssetsDownloader", 1, "downloadDynamicPackage is copying");
            return;
        }
        QLog.i("[wxa-q]WxaAssetsDownloader", 1, "downloadDynamicPackage start copy");
        File file = new File(filePath);
        if (file.exists()) {
            QLog.w("[wxa-q]WxaAssetsDownloader", 1, "downloadPackage file exist but not valid");
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileUtils.copyAssetToFile(BaseApplicationImpl.getApplication().getApplicationContext(), url, filePath);
        if (f.h().e()) {
            QLog.i("[wxa-q]WxaAssetsDownloader", 1, "downloadDynamicPackage copyAssetToFile success");
            c(true, "");
        } else {
            c(false, "copy failed");
        }
    }

    @Override // hb3.a
    public void clean() {
    }
}
