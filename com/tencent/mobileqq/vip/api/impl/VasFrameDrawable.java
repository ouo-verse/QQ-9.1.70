package com.tencent.mobileqq.vip.api.impl;

import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B/\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020#\u0012\u0006\u0010+\u001a\u00020\u0003\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VasFrameDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lcom/tencent/mobileqq/vas/ui/c;", "", "frameDir", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "", "doLoadTask", "", "getIntrinsicHeight", "getIntrinsicWidth", "getDrawable", "stop", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", tl.h.F, "Lcom/tencent/mobileqq/vas/ui/d;", "invoke", "p", "d", "Ljava/lang/String;", "frameZipUrl", "e", "frameFileDir", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "f", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "getOptions", "()Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "getDecoder", "()Lcom/tencent/cachedrawable/dynamicdrawable/e;", "decoder", "i", "getBusiness", "()Ljava/lang/String;", "business", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isLoaded", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "endlistener", "D", "Lcom/tencent/mobileqq/vas/ui/d;", "loaderInvoke", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "E", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "curDrawable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;Lcom/tencent/cachedrawable/dynamicdrawable/e;Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasFrameDrawable extends AbsAsyncDrawable implements com.tencent.mobileqq.vas.ui.c {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d.a endlistener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.vas.ui.d loaderInvoke;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FastDynamicDrawable curDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String frameZipUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String frameFileDir;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k options;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cachedrawable.dynamicdrawable.e decoder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String business;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VasFrameDrawable$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VasFrameDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VasFrameDrawable(@NotNull String frameZipUrl, @NotNull String frameFileDir, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k options, @NotNull com.tencent.cachedrawable.dynamicdrawable.e decoder, @NotNull String business) {
        Intrinsics.checkNotNullParameter(frameZipUrl, "frameZipUrl");
        Intrinsics.checkNotNullParameter(frameFileDir, "frameFileDir");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(business, "business");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, frameZipUrl, frameFileDir, options, decoder, business);
            return;
        }
        this.frameZipUrl = frameZipUrl;
        this.frameFileDir = frameFileDir;
        this.options = options;
        this.decoder = decoder;
        this.business = business;
        postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vip.api.impl.VasFrameDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VasFrameDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AbsAsyncDrawable.load$default(VasFrameDrawable.this, false, 1, null);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CountDownLatch latch, boolean z16) {
        Intrinsics.checkNotNullParameter(latch, "$latch");
        latch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable C(String frameDir) {
        FastDynamicDrawable fastDynamicDrawable = new FastDynamicDrawable("", frameDir, this.decoder, this.options);
        this.curDrawable = fastDynamicDrawable;
        fastDynamicDrawable.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vip.api.impl.VasFrameDrawable$getZipDrawable$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VasFrameDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                com.tencent.mobileqq.vas.ui.d dVar;
                d.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                dVar = VasFrameDrawable.this.loaderInvoke;
                if (dVar != null) {
                    dVar.a(it);
                }
                aVar = VasFrameDrawable.this.endlistener;
                if (aVar != null) {
                    it.d(aVar);
                }
            }
        });
        d.a aVar = this.endlistener;
        if (aVar != null) {
            aVar.onStart();
        }
        return fastDynamicDrawable;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z17 = false;
        if (this.frameFileDir.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.isLoaded = true;
            setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vip.api.impl.VasFrameDrawable$doLoadTask$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VasFrameDrawable.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Drawable invoke() {
                    String str;
                    Drawable C;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    VasFrameDrawable vasFrameDrawable = VasFrameDrawable.this;
                    str = vasFrameDrawable.frameFileDir;
                    C = vasFrameDrawable.C(str);
                    return C;
                }
            });
            callback.onLoadSucceed();
            return;
        }
        if (this.frameZipUrl.length() > 0) {
            z17 = true;
        }
        if (z17) {
            final z zVar = new z(this.business);
            zVar.e(this.frameZipUrl);
            if (!new File(zVar.c()).exists()) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                zVar.g(new ZipLoadedListener() { // from class: com.tencent.mobileqq.vip.api.impl.n
                    @Override // cooperation.qzone.zipanimate.ZipLoadedListener
                    public final void onZipLoaded(boolean z18) {
                        VasFrameDrawable.B(countDownLatch, z18);
                    }
                });
                zVar.h();
                countDownLatch.await(10L, TimeUnit.SECONDS);
            }
            this.isLoaded = true;
            setTargetDrawableBuild(new Function0<Drawable>(zVar) { // from class: com.tencent.mobileqq.vip.api.impl.VasFrameDrawable$doLoadTask$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ z $loaders;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$loaders = zVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VasFrameDrawable.this, (Object) zVar);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Drawable invoke() {
                    Drawable C;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    C = VasFrameDrawable.this.C(this.$loaders.c());
                    return C;
                }
            });
            callback.onLoadSucceed();
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.IVipFrameDrawable
    @NotNull
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicHeight */
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.options.i();
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicWidth */
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.options.k();
    }

    @Override // com.tencent.mobileqq.vas.ui.c
    public void h(@NotNull d.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.endlistener = listener;
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isLoaded;
    }

    @Override // com.tencent.mobileqq.vas.ui.c
    public void p(@NotNull com.tencent.mobileqq.vas.ui.d invoke) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) invoke);
        } else {
            Intrinsics.checkNotNullParameter(invoke, "invoke");
            this.loaderInvoke = invoke;
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.c
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        FastDynamicDrawable fastDynamicDrawable = this.curDrawable;
        if (fastDynamicDrawable != null) {
            fastDynamicDrawable.stop();
        }
    }
}
