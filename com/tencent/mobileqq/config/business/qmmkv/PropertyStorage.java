package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00038DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/PropertyStorage;", "T", "", "Ljava/io/File;", "a", "Lkotlin/Lazy;", "()Ljava/io/File;", "storageDir", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class PropertyStorage<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy storageDir;

    public PropertyStorage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.mobileqq.config.business.qmmkv.PropertyStorage$storageDir$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                File file = new File(MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/mmkv/property");
                try {
                    file.mkdirs();
                } catch (Throwable th5) {
                    QLog.e("QMMKV_PropertyStorage", 1, "get exception", th5);
                }
                return file;
            }
        });
        this.storageDir = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final File a() {
        return (File) this.storageDir.getValue();
    }
}
