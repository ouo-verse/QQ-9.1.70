package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.CacheStateManager;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001.B+\b\u0016\u0012\u0006\u00101\u001a\u00020\u001e\u0012\u0006\u00109\u001a\u00020\u001e\u0012\u0006\u0010=\u001a\u00020:\u0012\b\b\u0002\u0010A\u001a\u00020>\u00a2\u0006\u0004\bK\u0010LB3\b\u0016\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00107\u001a\u00020\u001e\u0012\u0006\u00109\u001a\u00020\u001e\u0012\u0006\u0010=\u001a\u00020:\u0012\b\b\u0002\u0010A\u001a\u00020>\u00a2\u0006\u0004\bK\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fJ\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u00101\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/d;", "", "Y", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "curCacheState", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable;", "e0", "V", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/m;", "callback", "U", "X", "W", "Lkotlin/Function1;", "block", "c0", "", HippyTKDListViewAdapter.X, "B", DomainData.DOMAIN_NAME, "stop", "restart", "", "loopCount", "setLoopCount", "Landroid/graphics/Rect;", "padding", "d0", "", "align", "Z", "fitStyle", "a0", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "selfDrawHelper", "b", "isMirror", "b0", "getHeight", "getFrameCount", "c", "a", "K", "Ljava/lang/String;", "urlStr", "", "L", "J", "bid", "M", "scid", "N", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "P", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "factory", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/jvm/functions/Function1;", "loadCallback", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "T", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "downloaderFactory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/e;Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;)V", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/e;Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class FastDynamicDrawable extends AbsAsyncDrawable implements com.tencent.cachedrawable.dynamicdrawable.d {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String urlStr;

    /* renamed from: L, reason: from kotlin metadata */
    private long bid;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String scid;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String filePath;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private com.tencent.cachedrawable.dynamicdrawable.e factory;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private k options;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.cachedrawable.dynamicdrawable.d, Unit> loadCallback;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private CacheDrawable.CacheState curCacheState;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.cachedrawable.dynamicdrawable.c downloaderFactory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10710);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FastDynamicDrawable(@NotNull String urlStr, @NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e factory, @NotNull k options) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, urlStr, filePath, factory, options);
            return;
        }
        this.urlStr = "";
        this.scid = "";
        this.filePath = "";
        new k();
        this.urlStr = urlStr;
        this.filePath = filePath;
        this.factory = factory;
        this.options = options;
        Y();
    }

    private final void U(final m callback) {
        boolean z16;
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>(this) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$downloadFile$downloadCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ FastDynamicDrawable this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String filePath) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) filePath);
                    return;
                }
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                if (i3 == 0) {
                    m mVar = m.this;
                    if (mVar == null) {
                        return;
                    }
                    this.this$0.W(mVar);
                    return;
                }
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FastDynamicDrawable", "downLoad file errorCode : " + i3 + " , filePath : " + filePath);
            }
        };
        boolean z17 = true;
        if (this.urlStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.cachedrawable.dynamicdrawable.c cVar = null;
        if (z16) {
            com.tencent.cachedrawable.dynamicdrawable.c cVar2 = this.downloaderFactory;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloaderFactory");
            } else {
                cVar = cVar2;
            }
            cVar.a().a(this.urlStr, this.filePath, function2);
            return;
        }
        if (this.scid.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            com.tencent.cachedrawable.dynamicdrawable.c cVar3 = this.downloaderFactory;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloaderFactory");
            } else {
                cVar = cVar3;
            }
            cVar.a().b(this.bid, this.scid, this.filePath, function2);
        }
    }

    private final CacheDrawable V() {
        try {
            Drawable o16 = o();
            if (o16 != null) {
                return (CacheDrawable) o16;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final m callback) {
        if (this.options.p()) {
            CacheStateManager.INSTANCE.a().d(k.INSTANCE.a(this.options.n(), this.options.a()), this.filePath, this.factory, this.options.o(), new Function1<CacheDrawable.CacheState, Unit>(callback) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$getCacheState$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ m $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FastDynamicDrawable.this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CacheDrawable.CacheState cacheState) {
                    invoke2(cacheState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CacheDrawable.CacheState it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    FastDynamicDrawable.this.curCacheState = it;
                    if (FastDynamicDrawable.this.x()) {
                        this.$callback.onLoadSucceed();
                    }
                }
            });
        } else {
            CacheStateManager.INSTANCE.a().f(this.filePath, this.factory, this.options.o(), new Function1<CacheDrawable.CacheState, Unit>(callback) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$getCacheState$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ m $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FastDynamicDrawable.this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CacheDrawable.CacheState cacheState) {
                    invoke2(cacheState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CacheDrawable.CacheState it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    FastDynamicDrawable.this.curCacheState = it;
                    if (FastDynamicDrawable.this.x()) {
                        this.$callback.onLoadSucceed();
                    }
                }
            });
        }
    }

    private final CacheDrawable.CacheState X() {
        String a16 = k.INSTANCE.a(this.options.n(), this.options.a());
        if (this.options.p()) {
            return CacheStateManager.INSTANCE.a().e(a16, this.filePath);
        }
        return null;
    }

    private final void Y() {
        if (this.options.k() > 0) {
            K(this.options.k());
        }
        if (this.options.i() > 0) {
            J(this.options.i());
        }
        I(this.options.j());
        this.downloaderFactory = this.options.c();
        H(new Function0<Drawable>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$initDrawable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FastDynamicDrawable.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                k kVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                kVar = FastDynamicDrawable.this.options;
                return kVar.e();
            }
        });
        M(new Function0<CacheDrawable>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$initDrawable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FastDynamicDrawable.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final CacheDrawable invoke() {
                CacheDrawable.CacheState cacheState;
                CacheDrawable e06;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (CacheDrawable) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                cacheState = FastDynamicDrawable.this.curCacheState;
                if (cacheState == null) {
                    return null;
                }
                e06 = FastDynamicDrawable.this.e0(cacheState);
                return e06;
            }
        });
        CacheDrawable.CacheState X = X();
        this.curCacheState = X;
        if (X != null) {
            y(false);
        } else {
            y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CacheDrawable e0(CacheDrawable.CacheState curCacheState) {
        CacheDrawable newDrawable = curCacheState.newDrawable();
        newDrawable.l(this.options.s());
        newDrawable.setLoopCount(this.options.f());
        newDrawable.o(this.options.l(), this.options.m());
        newDrawable.j(this.options.q());
        newDrawable.i(this.options.d());
        newDrawable.k(this.options.r());
        if (this.options.b()) {
            newDrawable.f();
        }
        if (this.options.g() != null && this.options.h() != null) {
            int[] g16 = this.options.g();
            Intrinsics.checkNotNull(g16);
            int[] h16 = this.options.h();
            Intrinsics.checkNotNull(h16);
            newDrawable.m(g16, h16);
        }
        newDrawable.p(e.f98943a.a(k.INSTANCE.a(this.options.n(), this.options.a())));
        return newDrawable;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (V() != null) {
            E(new Function0<Unit>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$onLoadSuccess$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FastDynamicDrawable.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1 function1;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    function1 = FastDynamicDrawable.this.loadCallback;
                    if (function1 == null) {
                        return;
                    }
                    function1.invoke(FastDynamicDrawable.this);
                }
            });
        }
    }

    public void Z(@NotNull String align) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) align);
            return;
        }
        Intrinsics.checkNotNullParameter(align, "align");
        CacheDrawable V = V();
        if (V != null) {
            V.h(align);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    @Nullable
    public CacheDrawable.CacheState a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (CacheDrawable.CacheState) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        CacheDrawable V = V();
        if (V == null) {
            return null;
        }
        return V.a();
    }

    public void a0(int fitStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, fitStyle);
            return;
        }
        CacheDrawable V = V();
        if (V != null) {
            V.i(fitStyle);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void b(@NotNull d.b selfDrawHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) selfDrawHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(selfDrawHelper, "selfDrawHelper");
        CacheDrawable V = V();
        if (V != null) {
            V.b(selfDrawHelper);
        }
    }

    public void b0(boolean isMirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, isMirror);
            return;
        }
        CacheDrawable V = V();
        if (V != null) {
            V.k(isMirror);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        CacheDrawable V = V();
        if (V == null) {
            return 0;
        }
        return V.c();
    }

    public final void c0(@NotNull final Function1<? super com.tencent.cachedrawable.dynamicdrawable.d, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
        if (V() != null) {
            E(new Function0<Unit>(block, this) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable$setLoadedListener$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit> $block;
                final /* synthetic */ FastDynamicDrawable this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$block = block;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) block, (Object) this);
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
                        this.$block.invoke(this.this$0);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void d(@NotNull d.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CacheDrawable V = V();
        if (V != null) {
            V.d(listener);
        }
    }

    public void d0(@NotNull Rect padding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) padding);
            return;
        }
        Intrinsics.checkNotNullParameter(padding, "padding");
        CacheDrawable V = V();
        if (V != null) {
            V.n(padding);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int getFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        CacheDrawable V = V();
        if (V == null) {
            return 1;
        }
        return V.getFrameCount();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        CacheDrawable V = V();
        if (V == null) {
            return 0;
        }
        return V.getHeight();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public void n(@NotNull m callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!new File(this.filePath).exists()) {
            U(callback);
        } else {
            W(callback);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        CacheDrawable V = V();
        if (V != null) {
            V.restart();
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void setLoopCount(int loopCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, loopCount);
            return;
        }
        CacheDrawable V = V();
        if (V != null) {
            V.setLoopCount(loopCount);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        CacheDrawable V = V();
        if (V != null) {
            V.stop();
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.curCacheState == null && (!new File(this.filePath).exists() || this.curCacheState == null)) {
            return false;
        }
        return true;
    }

    public FastDynamicDrawable(long j3, @NotNull String scid, @NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e factory, @NotNull k options) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), scid, filePath, factory, options);
            return;
        }
        this.urlStr = "";
        this.scid = "";
        this.filePath = "";
        new k();
        this.bid = j3;
        this.scid = scid;
        this.filePath = filePath;
        this.factory = factory;
        this.options = options;
        Y();
    }
}
