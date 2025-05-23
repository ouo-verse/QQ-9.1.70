package com.tencent.mobileqq.emoticon.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.activity.aio.zhitu.GifEncoder;
import com.tencent.mobileqq.emoticon.api.IEmoticonGifUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmoticonGifUtilsImpl;", "Lcom/tencent/mobileqq/emoticon/api/IEmoticonGifUtils;", "", "loadGifSo", "isSoLoaded", "", "originPath", "Ljava/io/File;", "generatedFile", "staticImageToGif", "Z", "<init>", "()V", "Companion", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmoticonGifUtilsImpl implements IEmoticonGifUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String GIF_LIB_NAME;

    @NotNull
    private static final String TAG;
    private boolean isSoLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmoticonGifUtilsImpl$a;", "", "", "GIF_LIB_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.api.impl.EmoticonGifUtilsImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        TAG = "EmoticonConvertFileImpl";
        GIF_LIB_NAME = "zhitugif";
    }

    public EmoticonGifUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            loadGifSo();
        }
    }

    private final boolean loadGifSo() {
        if (this.isSoLoaded) {
            return true;
        }
        boolean loadSoByName = SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), GIF_LIB_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "load gif library, isSuccess:" + loadSoByName);
        }
        this.isSoLoaded = loadSoByName;
        return loadSoByName;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmoticonGifUtils
    public boolean isSoLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isSoLoaded;
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmoticonGifUtils
    @Nullable
    public String staticImageToGif(@NotNull String originPath, @NotNull File generatedFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) originPath, (Object) generatedFile);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Intrinsics.checkNotNullParameter(generatedFile, "generatedFile");
        if (!this.isSoLoaded) {
            QLog.e(TAG, 1, "so load failed");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (generatedFile.exists()) {
            generatedFile.delete();
        }
        GifEncoder gifEncoder = new GifEncoder();
        try {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(originPath);
                gifEncoder.c(decodeFile.getWidth(), decodeFile.getHeight(), generatedFile.getAbsolutePath(), 2);
                gifEncoder.b(decodeFile, 0);
                gifEncoder.a();
                QLog.i(TAG, 1, "staticImageToGif filePath:" + generatedFile.getAbsolutePath() + ", take time:" + (System.currentTimeMillis() - currentTimeMillis));
                return generatedFile.getAbsolutePath();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "staticImageToGif failed, filePath:" + generatedFile.getAbsolutePath(), e16);
                gifEncoder.a();
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e(TAG, 1, "staticImageToGif catch oom, filePath:" + generatedFile.getAbsolutePath(), e17);
                com.tencent.qqperf.monitor.crash.catchedexception.a.c(e17, "staticImageToGif catch oom");
                gifEncoder.a();
                return null;
            }
        } catch (Throwable th5) {
            gifEncoder.a();
            throw th5;
        }
    }
}
