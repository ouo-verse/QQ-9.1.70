package com.tencent.qqnt.compress.api.impl;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IPicCompressApi;
import com.tencent.qqnt.compress.pic.impl.Compress;
import com.tencent.qqnt.compress.pic.impl.constraint.d;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/PicCompressApiNtImpl;", "Lcom/tencent/qqnt/compress/api/IPicCompressApi;", "", CustomImageProps.QUALITY, "", "originPath", "compressPic", "generateThumbPic", "", "picCompressLongEdge$delegate", "Lkotlin/Lazy;", "getPicCompressLongEdge", "()I", "picCompressLongEdge", "<init>", "()V", "Companion", "a", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class PicCompressApiNtImpl implements IPicCompressApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "PicCompressApiNtImpl";

    /* renamed from: picCompressLongEdge$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy picCompressLongEdge;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/PicCompressApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.api.impl.PicCompressApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PicCompressApiNtImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PicCompressApiNtImpl$picCompressLongEdge$2.INSTANCE);
            this.picCompressLongEdge = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPicCompressLongEdge() {
        return ((Number) this.picCompressLongEdge.getValue()).intValue();
    }

    @Override // com.tencent.qqnt.compress.api.IPicCompressApi
    @NotNull
    public String compressPic(boolean quality, @NotNull String originPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(quality), originPath);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        QLog.d(TAG, 1, "NT compress pic: " + originPath);
        return originPath;
    }

    @Override // com.tencent.qqnt.compress.api.IPicCompressApi
    @NotNull
    public String generateThumbPic(@NotNull String originPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) originPath);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Compress compress = Compress.f355729a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        File e16 = compress.e(context, new File(originPath), new Function1<com.tencent.qqnt.compress.pic.impl.constraint.a, Unit>() { // from class: com.tencent.qqnt.compress.api.impl.PicCompressApiNtImpl$generateThumbPic$thumbFile$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicCompressApiNtImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.compress.pic.impl.constraint.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.compress.pic.impl.constraint.a compressV2) {
                int picCompressLongEdge;
                int picCompressLongEdge2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) compressV2);
                    return;
                }
                Intrinsics.checkNotNullParameter(compressV2, "$this$compressV2");
                picCompressLongEdge = PicCompressApiNtImpl.this.getPicCompressLongEdge();
                picCompressLongEdge2 = PicCompressApiNtImpl.this.getPicCompressLongEdge();
                d.b(compressV2, picCompressLongEdge, picCompressLongEdge2, null, 80, 4, null);
            }
        });
        if (e16 != null && e16.exists()) {
            originPath = e16.getAbsolutePath();
        }
        QLog.d(TAG, 1, "NT generate thumb picture: " + originPath);
        Intrinsics.checkNotNullExpressionValue(originPath, "compressedPath");
        return originPath;
    }
}
