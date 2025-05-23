package com.tencent.qqnt.aio.gallery.pic;

import android.net.Uri;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.base.model.UriModel;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 \"2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u001a\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/pic/a;", "Lcom/tencent/libra/IPicLoader;", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "loadImage", "download", "", "getPicLocalPath", "release", "getDownloadRootPath", "getDownloadCommonRootPath", "Lcom/tencent/libra/decode/LibraRequestKey;", "getRequestKey", "removeCache", "", "hasCache", "getDownloadTmpRootPath", "deleteSdCacheIfNeed", "cancelDownload", "a", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "()Lcom/tencent/libra/IPicLoader;", "picLoader", "b", "Z", "getLayerRotateDisabled", "()Z", "layerRotateDisabled", "<init>", "(Lcom/tencent/libra/IPicLoader;)V", "c", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements IPicLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPicLoader picLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean layerRotateDisabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/pic/a$a;", "", "", "DISABLE_LAYER_ROTATE", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.gallery.pic.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull IPicLoader picLoader) {
        Intrinsics.checkNotNullParameter(picLoader, "picLoader");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) picLoader);
        } else {
            this.picLoader = picLoader;
            this.layerRotateDisabled = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("DISABLE_LAYER_ROTATE", false);
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void cancelDownload(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) option);
        } else {
            Intrinsics.checkNotNullParameter(option, "option");
            this.picLoader.cancelDownload(option);
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void deleteSdCacheIfNeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.picLoader.deleteSdCacheIfNeed();
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void download(@NotNull Option option, @Nullable IPicLoadStateListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) option, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(option, "option");
            this.picLoader.download(option, listener);
        }
    }

    @Override // com.tencent.libra.IPicLoader
    @NotNull
    public String getDownloadCommonRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String downloadCommonRootPath = this.picLoader.getDownloadCommonRootPath();
        Intrinsics.checkNotNullExpressionValue(downloadCommonRootPath, "picLoader.downloadCommonRootPath");
        return downloadCommonRootPath;
    }

    @Override // com.tencent.libra.IPicLoader
    @NotNull
    public String getDownloadRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String downloadRootPath = this.picLoader.getDownloadRootPath();
        Intrinsics.checkNotNullExpressionValue(downloadRootPath, "picLoader.downloadRootPath");
        return downloadRootPath;
    }

    @Override // com.tencent.libra.IPicLoader
    @NotNull
    public String getDownloadTmpRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        String downloadTmpRootPath = this.picLoader.getDownloadTmpRootPath();
        Intrinsics.checkNotNullExpressionValue(downloadTmpRootPath, "picLoader.downloadTmpRootPath");
        return downloadTmpRootPath;
    }

    @Override // com.tencent.libra.IPicLoader
    @NotNull
    public String getPicLocalPath(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) option);
        }
        Intrinsics.checkNotNullParameter(option, "option");
        String picLocalPath = this.picLoader.getPicLocalPath(option);
        Intrinsics.checkNotNullExpressionValue(picLocalPath, "picLoader.getPicLocalPath(option)");
        return picLocalPath;
    }

    @Override // com.tencent.libra.IPicLoader
    @NotNull
    public LibraRequestKey getRequestKey(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LibraRequestKey) iPatchRedirector.redirect((short) 10, (Object) this, (Object) option);
        }
        Intrinsics.checkNotNullParameter(option, "option");
        LibraRequestKey requestKey = this.picLoader.getRequestKey(option);
        Intrinsics.checkNotNullExpressionValue(requestKey, "picLoader.getRequestKey(option)");
        return requestKey;
    }

    @Override // com.tencent.libra.IPicLoader
    public boolean hasCache(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) option)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(option, "option");
        return this.picLoader.hasCache(option);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        if (r0 == true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r3 != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    @Override // com.tencent.libra.IPicLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadImage(@NotNull Option option, @Nullable IPicLoadStateListener listener) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) option, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        String url = option.getUrl();
        boolean z17 = true;
        if (url != null) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "content://", false, 2, null);
            if (startsWith$default2) {
                z16 = true;
                if (!z16) {
                    String url2 = option.getUrl();
                    if (url2 != null) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url2, "file://", false, 2, null);
                    }
                    z17 = false;
                }
                Uri parse = Uri.parse(option.getUrl());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(option.url)");
                option.setModel(new UriModel(parse));
                if (this.layerRotateDisabled) {
                    option.disableRotate();
                }
                this.picLoader.loadImage(option, listener);
            }
        }
        z16 = false;
        if (!z16) {
        }
        Uri parse2 = Uri.parse(option.getUrl());
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(option.url)");
        option.setModel(new UriModel(parse2));
        if (this.layerRotateDisabled) {
        }
        this.picLoader.loadImage(option, listener);
    }

    @Override // com.tencent.libra.IPicLoader
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.picLoader.release();
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void removeCache(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) option);
        } else {
            Intrinsics.checkNotNullParameter(option, "option");
            this.picLoader.removeCache(option);
        }
    }
}
