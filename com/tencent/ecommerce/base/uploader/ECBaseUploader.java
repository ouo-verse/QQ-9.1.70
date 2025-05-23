package com.tencent.ecommerce.base.uploader;

import androidx.annotation.MainThread;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.uploader.IECUploaderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \u00072\u00020\u0001:\u0002\u0004\u0015B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "", "", "f", "a", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;", "d", "()Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;", "e", "(Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;)V", "uploadListener", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "c", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "IUploaderListener", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class ECBaseUploader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IUploaderListener uploadListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String filePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0087\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$a;", "", "", "filePath", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory$UploaderType;", "type", "scene", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "a", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.uploader.ECBaseUploader$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @MainThread
        @NotNull
        public final ECBaseUploader a(@NotNull String filePath, @NotNull IECUploaderFactory.UploaderType type, @NotNull String scene) {
            return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getUploaderFactory().createUploaderByType(filePath, type, scene);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECBaseUploader(@NotNull String str, @NotNull String str2) {
        this.filePath = str;
        this.scene = str2;
    }

    public abstract void a();

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IUploaderListener getUploadListener() {
        return this.uploadListener;
    }

    public final void e(@Nullable IUploaderListener iUploaderListener) {
        this.uploadListener = iUploaderListener;
    }

    public abstract void f();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;", "", "onPauseFailed", "", "onPauseSucceed", "onUploadCancelled", "onUploadFailed", "errCode", "", "errMsg", "", "onUploadProgress", "uploadedFileSizeByte", "", "totalFileSizeByte", "onUploadStarted", "onUploadSucceed", "url", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface IUploaderListener {
        void onPauseFailed();

        void onPauseSucceed();

        void onUploadCancelled();

        void onUploadFailed(int errCode, @NotNull String errMsg);

        void onUploadProgress(long uploadedFileSizeByte, long totalFileSizeByte);

        void onUploadStarted();

        void onUploadSucceed(@NotNull String url);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes5.dex */
        public static final class a {
            public static void a(@NotNull IUploaderListener iUploaderListener) {
            }
        }
    }
}
