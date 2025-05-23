package com.tencent.mobileqq.wink.inference;

import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\f\u0003\u0006B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/b;", "", "", "b", "Ljava/lang/String;", "PRIVATE_BASE_PATH", "c", "INFERENCE_MODEL_PATH", "d", "INFERENCE_MODEL_DOWNLOAD_PATH", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f322963a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PRIVATE_BASE_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String INFERENCE_MODEL_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String INFERENCE_MODEL_DOWNLOAD_PATH;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/b$a;", "", "", "b", "Ljava/lang/String;", "DATA_DIRECTORY", "c", "NCNN_SO_PATH", "d", "CRYPTO_SO_PATH", "e", "SSL_SO_PATH", "f", "OMP_SO_PATH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f322967a = new a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String DATA_DIRECTORY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String NCNN_SO_PATH;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String CRYPTO_SO_PATH;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String SSL_SO_PATH;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String OMP_SO_PATH;

        static {
            String str = b.INFERENCE_MODEL_PATH + "base/";
            DATA_DIRECTORY = str;
            NCNN_SO_PATH = str + "libncnn.so";
            CRYPTO_SO_PATH = str + "libcrypto.so";
            SSL_SO_PATH = str + "libssl.so";
            OMP_SO_PATH = str + "libomp.so";
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/b$b;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "DATA_DIRECTORY", "c", "WECLIP_SO_PATH", "d", "MODEL_NCNN_BIN", "e", "MODEL_NCNN_PARAM", "f", "ALBUM_MEMORY_INFO", "g", "ALBUM_TEXT_FEATURE", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.inference.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9051b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C9051b f322973a = new C9051b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String DATA_DIRECTORY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String WECLIP_SO_PATH;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String MODEL_NCNN_BIN;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String MODEL_NCNN_PARAM;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String ALBUM_MEMORY_INFO;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String ALBUM_TEXT_FEATURE;

        static {
            String str = b.INFERENCE_MODEL_PATH + "clip/";
            DATA_DIRECTORY = str;
            WECLIP_SO_PATH = str + "libWEClip.so";
            MODEL_NCNN_BIN = str + "5gsw3nfb.bin.enc";
            MODEL_NCNN_PARAM = str + "5gsw3nfb.param.enc";
            ALBUM_MEMORY_INFO = str + "memory_info.json";
            ALBUM_TEXT_FEATURE = str + "text_feature.json";
        }

        C9051b() {
        }

        @NotNull
        public final String a() {
            return DATA_DIRECTORY;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/b$c;", "", "", "b", "Ljava/lang/String;", "DATA_DIRECTORY", "c", "WEYAMNET_PARAM_PATH", "d", "WEYAMNET_BIN_PATH", "e", "WEYAMNET_SO_PATH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f322980a = new c();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String DATA_DIRECTORY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String WEYAMNET_PARAM_PATH;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String WEYAMNET_BIN_PATH;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public static final String WEYAMNET_SO_PATH;

        static {
            String str = b.INFERENCE_MODEL_PATH + "yamnet/";
            DATA_DIRECTORY = str;
            WEYAMNET_PARAM_PATH = str + "WEYamnetModel.ncnn.param";
            WEYAMNET_BIN_PATH = str + "WEYamnetModel.ncnn.bin";
            WEYAMNET_SO_PATH = str + "libWEYamnet.so";
        }

        c() {
        }
    }

    static {
        String str = BaseApplication.getContext().getFilesDir().getParent() + "/";
        PRIVATE_BASE_PATH = str;
        INFERENCE_MODEL_PATH = str + "app_lib/inference/";
        INFERENCE_MODEL_DOWNLOAD_PATH = str + "app_lib/inference/download/";
    }

    b() {
    }
}
