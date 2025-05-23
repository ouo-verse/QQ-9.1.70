package com.tencent.paysdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/paysdk/util/FileUtil;", "", "b", "Companion", "a", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class FileUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f342059a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J%\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/paysdk/util/FileUtil$Companion;", "", "", "urlPath", "destFilePath", "Lcom/tencent/paysdk/util/FileUtil$a;", "listener", "Lkotlinx/coroutines/Job;", "b", "Ljava/io/File;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "voiceUrl", "c", "filePath", "", "d", "FILE_PREFIX", "Ljava/lang/String;", "TAG", "sCachePath", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ Object a(String str, String str2, Continuation<? super File> continuation) throws Exception {
            return BuildersKt.withContext(Dispatchers.getIO(), new FileUtil$Companion$downloadFile$2(str2, str, null), continuation);
        }

        @NotNull
        public final Job b(@NotNull String urlPath, @NotNull String destFilePath, @NotNull a listener) {
            Job launch$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Job) iPatchRedirector.redirect((short) 3, this, urlPath, destFilePath, listener);
            }
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(destFilePath, "destFilePath");
            Intrinsics.checkNotNullParameter(listener, "listener");
            launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FileUtil$Companion$downloadFile$job$1(urlPath, destFilePath, listener, null), 2, null);
            return launch$default;
        }

        @NotNull
        public final String c(@NotNull String voiceUrl) {
            int lastIndexOf$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) voiceUrl);
            }
            Intrinsics.checkNotNullParameter(voiceUrl, "voiceUrl");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) voiceUrl, '/', 0, false, 6, (Object) null);
            if (lastIndexOf$default != -1 && lastIndexOf$default < voiceUrl.length() - 1) {
                String substring = voiceUrl.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            return voiceUrl;
        }

        public final boolean d(@NotNull String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) filePath)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new File(filePath).exists();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/paysdk/util/FileUtil$a;", "", "Ljava/io/File;", "file", "", "a", "", "errCode", "", "errMsg", "onFailed", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@Nullable File file);

        void onFailed(int errCode, @Nullable String errMsg);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
