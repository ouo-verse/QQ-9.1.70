package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.CacheStateManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010M\u001a\u00020$\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010P\u001a\u00020\u0010\u00a2\u0006\u0004\bQ\u0010RJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0017J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001d\u00108\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010@R\u0016\u0010H\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00101R\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010JR\u0016\u0010L\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00101R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00101\u00a8\u0006S"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheFrameProducer;", "Lcom/tencent/cachedrawable/dynamicdrawable/h;", "", "index", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "", "j", "t", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", DomainData.DOMAIN_NAME, "k", "l", "Lkotlin/Pair;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "r", "", "isUseHardware", "w", "isUse2BitmapMode", "v", "b", "", "time", "c", "consumer", "u", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "animTimeLine", HippyTKDListViewAdapter.X, "", "p", "a", "destroy", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Ljava/lang/String;", "mFilePath", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mConsumerRef", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", "mConsumer", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/f;", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/f;", "mFrameCacheManager", "e", "Z", "mIsUseHardware", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "f", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "mFileDecoder", "g", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "mAnimTimeLine", tl.h.F, "[I", "frameDelayList", "i", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "firstFrameAnimData", "Landroid/os/Handler;", "Landroid/os/Handler;", "decoderHandler", "curFrameAnimData", "nextFrameAnimData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nextFrameIsCost", "", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "isBigBitmap", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "fileDecoder", "useFileCache", "<init>", "(Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/e;Z)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class CacheFrameProducer implements com.tencent.cachedrawable.dynamicdrawable.h {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFilePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.cachedrawable.dynamicdrawable.b> mConsumerRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.b mConsumer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.f mFrameCacheManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsUseHardware;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFileDecoder;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.a mAnimTimeLine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] frameDelayList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b firstFrameAnimData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler decoderHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b curFrameAnimData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b nextFrameAnimData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean nextFrameIsCost;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object lock;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isBigBitmap;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isUse2BitmapMode;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheFrameProducer$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheFrameProducer$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheFrameProducer$b", "Lcom/tencent/cachedrawable/dynamicdrawable/g;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameData", "", "a", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class b implements com.tencent.cachedrawable.dynamicdrawable.g {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f98930b;

        b(int i3) {
            this.f98930b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CacheFrameProducer.this, i3);
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.g
        public void a(@Nullable com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) frameData);
                return;
            }
            if (frameData != null) {
                Object obj = CacheFrameProducer.this.lock;
                CacheFrameProducer cacheFrameProducer = CacheFrameProducer.this;
                synchronized (obj) {
                    cacheFrameProducer.nextFrameAnimData = frameData;
                    cacheFrameProducer.nextFrameIsCost = false;
                    Unit unit = Unit.INSTANCE;
                }
                CacheFrameProducer.this.j(this.f98930b, frameData);
                return;
            }
            com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.b();
            CacheFrameProducer.this.l(this.f98930b);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CacheFrameProducer(@NotNull final String filePath, @NotNull final com.tencent.cachedrawable.dynamicdrawable.e fileDecoder, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileDecoder, "fileDecoder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, filePath, fileDecoder, Boolean.valueOf(z16));
            return;
        }
        this.mFilePath = filePath;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AbsFileDecoder>(filePath) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheFrameProducer$mFileDecoder$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $filePath;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$filePath = filePath;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.cachedrawable.dynamicdrawable.e.this, (Object) filePath);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AbsFileDecoder invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AbsFileDecoder) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                com.tencent.cachedrawable.dynamicdrawable.e.this.a(this.$filePath).e(new Function1<AbsFileDecoder, Unit>(objectRef, countDownLatch) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheFrameProducer$mFileDecoder$2$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CountDownLatch $latch;
                    final /* synthetic */ Ref.ObjectRef<AbsFileDecoder> $newDecoder;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$newDecoder = objectRef;
                        this.$latch = countDownLatch;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) objectRef, (Object) countDownLatch);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AbsFileDecoder absFileDecoder) {
                        invoke2(absFileDecoder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull AbsFileDecoder it) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.$newDecoder.element = it;
                        this.$latch.countDown();
                    }
                });
                countDownLatch.await(5L, TimeUnit.SECONDS);
                com.tencent.cachedrawable.dynamicdrawable.logcat.a aVar = com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a;
                aVar.b("CacheFrameProducer", "decoder init success");
                if (objectRef.element == 0) {
                    aVar.b("CacheFrameProducer", "decoder error : init error");
                }
                return (AbsFileDecoder) objectRef.element;
            }
        });
        this.mFileDecoder = lazy;
        this.decoderHandler = new Handler(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.h.f99037a.a().getLooper());
        this.nextFrameIsCost = true;
        this.lock = new Object();
        this.mFrameCacheManager = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.f(this.mFilePath, z16);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int index, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        if (this.frameDelayList == null && frameAnimData.c() > 0) {
            this.frameDelayList = new int[frameAnimData.c()];
        }
        int[] iArr = this.frameDelayList;
        if (iArr != null) {
            int d16 = frameAnimData.d();
            if (index == 0) {
                iArr[0] = d16;
                return;
            }
            int i3 = iArr[index];
            int i16 = iArr[index - 1];
            if (i3 != d16 + i16) {
                iArr[index] = d16 + i16;
            }
        }
    }

    @SuppressLint({"LongLogTag"})
    private final void k(int index) {
        Bitmap a16;
        b bVar = new b(index);
        if (this.isBigBitmap) {
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.f fVar = this.mFrameCacheManager;
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar2 = this.nextFrameAnimData;
            if (bVar2 == null) {
                a16 = null;
            } else {
                a16 = bVar2.a();
            }
            fVar.g(index, bVar, a16);
            return;
        }
        this.mFrameCacheManager.e(index, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final int index) {
        this.decoderHandler.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.g
            @Override // java.lang.Runnable
            public final void run() {
                CacheFrameProducer.m(CacheFrameProducer.this, index);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(CacheFrameProducer this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair<AbsFileDecoder.a, Integer> r16 = this$0.r(i3);
        AbsFileDecoder.a first = r16.getFirst();
        if (first != null) {
            Bitmap a16 = first.a();
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b(a16, r16.getSecond().intValue(), (int) first.b(), a16.getWidth(), a16.getHeight());
            if (!bVar.i()) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheFrameProducer", Intrinsics.stringPlus("decoder error : frameCount <= 0 path : ", this$0.mFilePath));
                return;
            }
            this$0.j(i3, bVar);
            if (this$0.isBigBitmap) {
                this$0.mFrameCacheManager.r(bVar, i3);
            } else {
                this$0.mFrameCacheManager.n(bVar, i3);
            }
            synchronized (this$0.lock) {
                this$0.nextFrameAnimData = bVar;
                this$0.nextFrameIsCost = false;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final com.tencent.cachedrawable.dynamicdrawable.b n() {
        com.tencent.cachedrawable.dynamicdrawable.b bVar = this.mConsumer;
        if (bVar != null) {
            return bVar;
        }
        WeakReference<com.tencent.cachedrawable.dynamicdrawable.b> weakReference = this.mConsumerRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: OutOfMemoryError -> 0x006e, Exception -> 0x00a3, TryCatch #3 {Exception -> 0x00a3, OutOfMemoryError -> 0x006e, blocks: (B:8:0x001c, B:10:0x0020, B:13:0x0025, B:14:0x002b, B:16:0x0031, B:18:0x003e, B:20:0x0046, B:22:0x004a, B:24:0x0065), top: B:7:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: OutOfMemoryError -> 0x006e, Exception -> 0x00a3, TryCatch #3 {Exception -> 0x00a3, OutOfMemoryError -> 0x006e, blocks: (B:8:0x001c, B:10:0x0020, B:13:0x0025, B:14:0x002b, B:16:0x0031, B:18:0x003e, B:20:0x0046, B:22:0x004a, B:24:0x0065), top: B:7:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<AbsFileDecoder.a, Integer> r(int index) {
        Bitmap bitmap;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar;
        Bitmap bitmap2;
        AbsFileDecoder.a c16;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar2;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar3;
        AbsFileDecoder s16 = s();
        if (s16 == null) {
            return TuplesKt.to(null, 0);
        }
        s16.f(this.mIsUseHardware);
        try {
        } catch (Exception e16) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("CacheFrameProducer", "decoder Exception : e : ", e16);
        } catch (OutOfMemoryError e17) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("CacheFrameProducer", "decoder OutOfMemoryError : e : ", e17);
            com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.a();
            try {
                if (this.isBigBitmap && (bVar = this.nextFrameAnimData) != null) {
                    bitmap = bVar.a();
                    return TuplesKt.to(s16.c(index, bitmap), Integer.valueOf(s16.getMFrameCount()));
                }
                bitmap = null;
                return TuplesKt.to(s16.c(index, bitmap), Integer.valueOf(s16.getMFrameCount()));
            } catch (Throwable th5) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("CacheFrameProducer", "decoder Exception : e : ", th5);
            }
        }
        if (this.isBigBitmap && (bVar3 = this.nextFrameAnimData) != null) {
            bitmap2 = bVar3.a();
            c16 = s16.c(index, bitmap2);
            if (c16 == null) {
                return TuplesKt.to(c16, Integer.valueOf(s16.getMFrameCount()));
            }
            if (com.tencent.cachedrawable.dynamicdrawable.utils.d.f99062a.d() && (bVar2 = this.curFrameAnimData) != null) {
                return TuplesKt.to(new AbsFileDecoder.a(bVar2.a(), bVar2.d()), Integer.valueOf(s16.getMFrameCount()));
            }
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheFrameProducer", "decoder error : frameData == null");
            CacheStateManager.INSTANCE.a().g(this.mFilePath);
            return TuplesKt.to(null, 0);
        }
        bitmap2 = null;
        c16 = s16.c(index, bitmap2);
        if (c16 == null) {
        }
    }

    private final AbsFileDecoder s() {
        return (AbsFileDecoder) this.mFileDecoder.getValue();
    }

    @SuppressLint({"LongLogTag"})
    private final void t() {
        Pair<AbsFileDecoder.a, Integer> r16;
        AbsFileDecoder.a first;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b d16 = this.mFrameCacheManager.d(0);
        this.firstFrameAnimData = d16;
        if (d16 == null && (first = (r16 = r(0)).getFirst()) != null) {
            Bitmap a16 = first.a();
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b(a16, r16.getSecond().intValue(), (int) first.b(), a16.getWidth(), a16.getHeight());
            if (!bVar.i()) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", Intrinsics.stringPlus("decoder error : frameCount <= 0 path : ", this.mFilePath));
                bVar = null;
            }
            this.firstFrameAnimData = bVar;
        }
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar2 = this.firstFrameAnimData;
        if (bVar2 != null) {
            this.curFrameAnimData = bVar2;
            if (bVar2.g() > 5242880 || this.isUse2BitmapMode) {
                this.isBigBitmap = true;
            }
            if (this.isBigBitmap) {
                this.mFrameCacheManager.r(bVar2, 0);
            } else {
                this.mFrameCacheManager.n(bVar2, 0);
            }
            int[] iArr = new int[bVar2.c()];
            this.frameDelayList = iArr;
            Intrinsics.checkNotNull(iArr);
            iArr[0] = bVar2.d();
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.cachedrawable.dynamicdrawable.b n3 = n();
        if (n3 != null) {
            n3.a();
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    @SuppressLint({"LongLogTag"})
    public void b(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, index);
            return;
        }
        k(index);
        com.tencent.cachedrawable.dynamicdrawable.a aVar = this.mAnimTimeLine;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    @SuppressLint({"LongLogTag"})
    public boolean c(long time) {
        boolean z16;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, time)).booleanValue();
        }
        com.tencent.cachedrawable.dynamicdrawable.b n3 = n();
        if (n3 == null || !n3.b(time)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            synchronized (this.lock) {
                if (!this.nextFrameIsCost && (bVar = this.nextFrameAnimData) != null) {
                    com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar2 = this.curFrameAnimData;
                    this.curFrameAnimData = bVar;
                    this.nextFrameAnimData = bVar2;
                    com.tencent.cachedrawable.dynamicdrawable.b n16 = n();
                    if (n16 != null) {
                        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar3 = this.curFrameAnimData;
                        Intrinsics.checkNotNull(bVar3);
                        n16.c(bVar3);
                    }
                    this.nextFrameIsCost = true;
                    return true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return false;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public void destroy() {
        AbsFileDecoder s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.g() && (s16 = s()) != null) {
            s16.a();
        }
    }

    @Nullable
    public com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.firstFrameAnimData;
    }

    @Nullable
    public int[] p(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this, index);
        }
        return this.frameDelayList;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.firstFrameAnimData;
        if (bVar == null) {
            return 0;
        }
        return bVar.c();
    }

    public void u(@NotNull com.tencent.cachedrawable.dynamicdrawable.b consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) consumer);
            return;
        }
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.g()) {
            this.mConsumerRef = new WeakReference<>(consumer);
        } else {
            this.mConsumer = consumer;
        }
    }

    public void v(boolean isUse2BitmapMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isUse2BitmapMode);
        } else {
            this.isUse2BitmapMode = isUse2BitmapMode;
        }
    }

    public final void w(boolean isUseHardware) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isUseHardware);
        } else {
            this.mIsUseHardware = isUseHardware;
            this.mFrameCacheManager.u(isUseHardware);
        }
    }

    public void x(@NotNull com.tencent.cachedrawable.dynamicdrawable.a animTimeLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animTimeLine);
        } else {
            Intrinsics.checkNotNullParameter(animTimeLine, "animTimeLine");
            this.mAnimTimeLine = animTimeLine;
        }
    }
}
