package com.tencent.mobileqq.groupvideo.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/FileEnvControl;", "Lcom/tencent/mobileqq/groupvideo/debug/l;", "", "isTestEnv", "enable", "", "a", "Ljava/io/File;", "Lkotlin/Lazy;", "b", "()Ljava/io/File;", "file", "", "filePath", "<init>", "(Ljava/lang/String;)V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileEnvControl implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy file;

    public FileEnvControl(@NotNull final String filePath) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>(filePath) { // from class: com.tencent.mobileqq.groupvideo.debug.FileEnvControl$file$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $filePath;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$filePath = filePath;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) filePath);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (File) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
                    Intrinsics.checkNotNull(externalFilesDir);
                    return new File(externalFilesDir.getAbsolutePath() + this.$filePath);
                }
            });
            this.file = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) filePath);
        }
    }

    private final File b() {
        return (File) this.file.getValue();
    }

    @Override // com.tencent.mobileqq.groupvideo.debug.l
    public void a(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, enable);
            return;
        }
        if (enable) {
            File parentFile = b().getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            b().createNewFile();
            return;
        }
        b().delete();
    }

    @Override // com.tencent.mobileqq.groupvideo.debug.l
    public boolean isTestEnv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return b().exists();
    }
}
