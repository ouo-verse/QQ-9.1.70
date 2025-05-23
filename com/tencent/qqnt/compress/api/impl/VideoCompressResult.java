package com.tencent.qqnt.compress.api.impl;

import com.epicgames.ue4.GameActivity;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0017B)\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0004\u0010\u0012\"\u0004\b\t\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult;", "", "", "toString", "a", "Ljava/lang/String;", "getVideoInputPath", "()Ljava/lang/String;", "videoInputPath", "b", "videoOutputPath", "", "c", "Z", "targetToH265", "Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;", "d", "Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;", "()Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;", "(Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;)V", "result", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;)V", GameActivity.DOWNLOAD_RETURN_NAME, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class VideoCompressResult {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoInputPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoOutputPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean targetToH265;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Result result;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult$Result;", "", "(Ljava/lang/String;I)V", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "FAIL_DEVICE_NOT_SUPPORT_H265", "FAIL_SRC_VIDEO_IS_NOT_H265", "FAIL_CONFIG_DISABLE_H265", "FAIL_ERROR_INTERRUPT", Tracker.FAIL, "SUCCESS", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class Result {
        private static final /* synthetic */ Result[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Result FAIL;
        public static final Result FAIL_CONFIG_DISABLE_H265;
        public static final Result FAIL_DEVICE_NOT_SUPPORT_H265;
        public static final Result FAIL_ERROR_INTERRUPT;
        public static final Result FAIL_SRC_VIDEO_IS_NOT_H265;
        public static final Result INIT;
        public static final Result SUCCESS;

        private static final /* synthetic */ Result[] $values() {
            return new Result[]{INIT, FAIL_DEVICE_NOT_SUPPORT_H265, FAIL_SRC_VIDEO_IS_NOT_H265, FAIL_CONFIG_DISABLE_H265, FAIL_ERROR_INTERRUPT, FAIL, SUCCESS};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63918);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            INIT = new Result(com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, 0);
            FAIL_DEVICE_NOT_SUPPORT_H265 = new Result("FAIL_DEVICE_NOT_SUPPORT_H265", 1);
            FAIL_SRC_VIDEO_IS_NOT_H265 = new Result("FAIL_SRC_VIDEO_IS_NOT_H265", 2);
            FAIL_CONFIG_DISABLE_H265 = new Result("FAIL_CONFIG_DISABLE_H265", 3);
            FAIL_ERROR_INTERRUPT = new Result("FAIL_ERROR_INTERRUPT", 4);
            FAIL = new Result(Tracker.FAIL, 5);
            SUCCESS = new Result("SUCCESS", 6);
            $VALUES = $values();
        }

        Result(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    public VideoCompressResult(@NotNull String videoInputPath, @NotNull String videoOutputPath, boolean z16, @NotNull Result result) {
        Intrinsics.checkNotNullParameter(videoInputPath, "videoInputPath");
        Intrinsics.checkNotNullParameter(videoOutputPath, "videoOutputPath");
        Intrinsics.checkNotNullParameter(result, "result");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, videoInputPath, videoOutputPath, Boolean.valueOf(z16), result);
            return;
        }
        this.videoInputPath = videoInputPath;
        this.videoOutputPath = videoOutputPath;
        this.targetToH265 = z16;
        this.result = result;
    }

    @NotNull
    public final Result a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Result) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.result;
    }

    public final void b(@NotNull Result result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(result, "<set-?>");
            this.result = result;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "VideoCompressResult(videoInputPath='" + this.videoInputPath + "', videoOutputPath='" + this.videoOutputPath + "', targetToH265=" + this.targetToH265 + ", result=" + this.result + ")";
    }

    public /* synthetic */ VideoCompressResult(String str, String str2, boolean z16, Result result, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z16, (i3 & 8) != 0 ? Result.INIT : result);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), result, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
