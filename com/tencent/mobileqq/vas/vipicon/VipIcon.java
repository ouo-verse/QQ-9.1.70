package com.tencent.mobileqq.vas.vipicon;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00042\u00020\u0001:\u0002CDBQ\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0016\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010)\u001a\u00020\b\u0012\b\b\u0002\u0010+\u001a\u00020\b\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001b\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020#028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010-R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010\u0004R\u0016\u0010>\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u0004R\u0016\u0010?\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001f\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable;", "Lcom/tencent/mobileqq/vas/image/c;", "", "K", "J", "Lcom/tencent/cachedrawable/dynamicdrawable/d;", "drawable", "L", "", "toString", "", CoverDBCacheData.URLS, "M", "([Ljava/lang/String;)V", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Lkotlin/Function1;", "block", "setLoadedListener", "", "getIntrinsicWidth", "getIntrinsicHeight", "loop", "setLoop", "d", "I", "width", "e", "height", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", tl.h.F, "Ljava/lang/String;", "scene", "i", "cacheKey", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "drawableLoaded", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "loadCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "D", "Ljava/util/concurrent/CopyOnWriteArrayList;", "allDrawable", "E", "[Ljava/lang/String;", UserInfo.SEX_FEMALE, "isLoadSuccess", "", "G", "startAnimTimeMillis", "H", "lastNum", "lastIndex", "urlsInvoke", "<init>", "(IILkotlin/jvm/functions/Function1;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.vipicon.VipIconDrawable, reason: from toString */
/* loaded from: classes20.dex */
public final class VipIcon extends com.tencent.mobileqq.vas.image.c {

    @NotNull
    private static final ConcurrentHashMap<String, String[]> K = new ConcurrentHashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Function1<? super VipIcon, Unit> loadCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<Drawable> allDrawable;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private String[] VipIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoadSuccess;

    /* renamed from: G, reason: from kotlin metadata */
    private final long startAnimTimeMillis;

    /* renamed from: H, reason: from kotlin metadata */
    private long lastNum;

    /* renamed from: I, reason: from kotlin metadata */
    private int lastIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable defaultDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String cacheKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean drawableLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u0000 \u001f2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\"\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable$b;", "Lcom/tencent/mobileqq/vas/image/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "", "p", "c", "d", "Landroid/graphics/drawable/Drawable;", "getD1", "()Landroid/graphics/drawable/Drawable;", "d1", "e", "getD2", "d2", "f", UserInfo.SEX_FEMALE, "getAnimProgress", "()F", "setAnimProgress", "(F)V", "animProgress", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "g", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$b */
    /* loaded from: classes20.dex */
    public static final class b extends com.tencent.mobileqq.vas.image.d {

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private static final PathInterpolator f311301h = new PathInterpolator(0.0f, 0.65f, 0.35f, 1.0f);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable d1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable d2;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float animProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(@NotNull Drawable d16, @NotNull Drawable d26) {
            super(r0);
            List listOf;
            Intrinsics.checkNotNullParameter(d16, "d1");
            Intrinsics.checkNotNullParameter(d26, "d2");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Drawable[]{d16, d26});
            this.d1 = d16;
            this.d2 = d26;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.invalidateSelf();
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
            boolean z16;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            if (bounds == null) {
                rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            } else {
                rect = bounds;
            }
            if (this.animProgress == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Drawable drawable = drawableStack.get(1);
                drawable.setAlpha(255);
                drawable.setBounds(rect);
                drawable.draw(canvas);
                return;
            }
            Pair pair = TuplesKt.to(Integer.valueOf(rect.centerX()), Integer.valueOf(rect.centerY()));
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            Pair pair2 = TuplesKt.to(Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
            int intValue3 = ((Number) pair2.component1()).intValue();
            int intValue4 = ((Number) pair2.component2()).intValue();
            Drawable drawable2 = drawableStack.get(1);
            int i3 = (intValue * 5) / 18;
            PathInterpolator pathInterpolator = f311301h;
            float interpolation = 1.0f - pathInterpolator.getInterpolation(this.animProgress);
            float f16 = intValue;
            int i16 = (int) ((((intValue + i3) - intValue) * interpolation) + f16);
            float f17 = intValue2;
            float f18 = ((intValue / 30) + intValue2) - intValue2;
            int i17 = (int) ((f18 * interpolation) + f17);
            float f19 = intValue3;
            float f26 = ((intValue3 * 8) / 10) - intValue3;
            int i18 = (int) (f19 + (f26 * interpolation));
            float f27 = intValue4;
            float f28 = ((intValue4 * 8) / 10) - intValue4;
            int i19 = i18 / 2;
            int i26 = ((int) (f27 + (f28 * interpolation))) / 2;
            rect.set(i16 - i19, i17 - i26, i16 + i19, i17 + i26);
            float f29 = 255;
            float f36 = 1;
            drawable2.setAlpha((int) ((f36 - interpolation) * f29));
            drawable2.setBounds(rect);
            drawable2.draw(canvas);
            Drawable drawable3 = drawableStack.get(0);
            float interpolation2 = pathInterpolator.getInterpolation(this.animProgress);
            int i27 = (int) (f16 + (((intValue - i3) - intValue) * interpolation2));
            int i28 = (int) (f17 + (f18 * interpolation2));
            int i29 = ((int) (f19 + (f26 * interpolation2))) / 2;
            int i36 = ((int) (f27 + (f28 * interpolation2))) / 2;
            rect.set(i27 - i29, i28 - i36, i27 + i29, i28 + i36);
            drawable3.setAlpha((int) (f29 * (f36 - interpolation2)));
            drawable3.setBounds(rect);
            drawable3.draw(canvas);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x000b, code lost:
        
            if (r4 > 1.0f) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(float p16) {
            boolean z16;
            float f16 = 0.0f;
            if (p16 >= 0.0f) {
                f16 = 1.0f;
            }
            p16 = f16;
            if (this.animProgress == p16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.animProgress = p16;
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        VipIcon.b.d(VipIcon.b.this);
                    }
                }, 16L);
            }
        }
    }

    public VipIcon(int i3, int i16, @NotNull final Function1<? super VipIcon, String[]> urlsInvoke, @Nullable Drawable drawable, @NotNull String scene, @NotNull String cacheKey) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(urlsInvoke, "urlsInvoke");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.width = i3;
        this.height = i16;
        this.defaultDrawable = drawable;
        this.scene = scene;
        this.cacheKey = cacheKey;
        this.loadCallback = new Function1<VipIcon, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$loadCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VipIcon vipIcon) {
                invoke2(vipIcon);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VipIcon it) {
                Intrinsics.checkNotNullParameter(it, "it");
                VipIcon.this.drawableLoaded = true;
            }
        };
        this.allDrawable = new CopyOnWriteArrayList<>();
        this.VipIcon = new String[0];
        this.startAnimTimeMillis = SystemClock.uptimeMillis();
        if (cacheKey.length() == 0) {
            strArr = null;
        } else {
            strArr = K.get(cacheKey);
        }
        if (strArr == null) {
            postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VipIcon vipIcon = VipIcon.this;
                    vipIcon.VipIcon = urlsInvoke.invoke(vipIcon);
                    VipIcon.this.K();
                }
            });
            return;
        }
        this.VipIcon = strArr;
        postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                    String[] invoke = urlsInvoke.invoke(this);
                    VipIcon vipIcon = this;
                    int length = invoke.length;
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 < length) {
                        int i19 = i18 + 1;
                        String str = invoke[i17];
                        if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(str, vipIcon.VipIcon[i18])) {
                            QLog.e("AbsAsyncDrawable", 1, "\u68c0\u67e5url\u6570\u636e\u53d1\u751f\u9519\u8bef");
                        }
                        i17++;
                        i18 = i19;
                    }
                }
                String[] strArr2 = this.VipIcon;
                VipIcon vipIcon2 = this;
                for (String str2 : strArr2) {
                    if (!new File(str2).exists()) {
                        VasLogNtReporter.INSTANCE.getVipIcon().reportLow(str2 + " exists=" + new File(str2).exists());
                        VipIcon.K.remove(vipIcon2.cacheKey);
                        return;
                    }
                }
            }
        });
        J();
        this.isLoadSuccess = true;
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(VipIcon this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateSelf();
    }

    private final void J() {
        String[] strArr = this.VipIcon;
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            final String str = strArr[i3];
            int i17 = i16 + 1;
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(this.VipIcon[i16]).i(this.scene).h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$loadAllDrawable$1$drawable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.y(VipIcon.this.getNeedLoop() ? Integer.MAX_VALUE : 1);
                }
            }).a();
            if (i16 != 0) {
                a16.I(false);
                a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$loadAllDrawable$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (QLog.isDebugVersion()) {
                            VasLogNtReporter.INSTANCE.getVipIcon().reportLow("load " + str + " end [" + Thread.currentThread() + "]");
                        }
                    }
                });
            } else {
                a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$loadAllDrawable$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                        Function1 function1;
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1 = VipIcon.this.loadCallback;
                        function1.invoke(VipIcon.this);
                    }
                });
            }
            L(a16);
            this.allDrawable.add(a16);
            i3++;
            i16 = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        setFailedDrawableBuild(new Function0<FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$realInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FastDynamicDrawable invoke() {
                String str;
                a.C1005a d16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(VipIcon.this.VipIcon[0]);
                str = VipIcon.this.scene;
                a.C1005a i3 = d16.i(str);
                final VipIcon vipIcon = VipIcon.this;
                return i3.h(new Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$realInit$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                        invoke2(kVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
                        Drawable drawable;
                        Drawable drawable2;
                        Intrinsics.checkNotNullParameter(it, "it");
                        drawable = VipIcon.this.defaultDrawable;
                        if (drawable != null) {
                            drawable2 = VipIcon.this.defaultDrawable;
                            it.x(drawable2);
                        }
                    }
                }).a();
            }
        });
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.vipicon.VipIconDrawable$realInit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                copyOnWriteArrayList = VipIcon.this.allDrawable;
                return (Drawable) copyOnWriteArrayList.get(0);
            }
        });
        load(false);
    }

    private final void L(com.tencent.cachedrawable.dynamicdrawable.d drawable) {
        int i3;
        if (getNeedLoop()) {
            i3 = Integer.MAX_VALUE;
        } else {
            i3 = 1;
        }
        drawable.setLoopCount(i3);
    }

    public final void M(@NotNull String[] urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        this.VipIcon = urls;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        for (String str : this.VipIcon) {
            if (!new File(str).exists()) {
                VasLogNtReporter.INSTANCE.getVipIcon().reportLow(str + " exists=" + new File(str).exists());
                z16 = false;
            }
        }
        if (!z16) {
            return;
        }
        K.put(this.cacheKey, this.VipIcon);
        J();
        this.isLoadSuccess = true;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable != null) {
            currentDrawable.setAlpha(255);
        }
        super.draw(canvas);
        if (this.allDrawable.size() < 2) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startAnimTimeMillis;
        long j3 = uptimeMillis / 5400;
        if (!getNeedLoop() && j3 >= this.allDrawable.size()) {
            return;
        }
        long j16 = this.lastNum;
        if (j16 != j3) {
            Ref.IntRef intRef = new Ref.IntRef();
            int i3 = this.lastIndex + 1;
            intRef.element = i3;
            if (i3 >= this.allDrawable.size()) {
                intRef.element = 0;
            }
            setTargetDrawableBuild(new VipIconDrawable$draw$1(5400L, this, intRef));
            AbsAsyncDrawable.load$default(this, false, 1, null);
            this.lastNum = j3;
            this.lastIndex = intRef.element;
        } else if (j16 == 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.h
                @Override // java.lang.Runnable
                public final void run() {
                    VipIcon.I(VipIcon.this);
                }
            }, 5400L);
        }
        if (getCurrentDrawable() instanceof b) {
            Drawable currentDrawable2 = getCurrentDrawable();
            Intrinsics.checkNotNull(currentDrawable2, "null cannot be cast to non-null type com.tencent.mobileqq.vas.vipicon.VipIconDrawable.TwoVipIconDrawable");
            b bVar = (b) currentDrawable2;
            float f16 = ((float) (uptimeMillis % 5400)) / 400.0f;
            bVar.c(f16);
            if (f16 < 1.0f) {
                bVar.c(f16);
            } else {
                bVar.c(1.0f);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess, reason: from getter */
    public boolean getIsLoadSuccess() {
        return this.isLoadSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.image.c
    public void setLoadedListener(@NotNull Function1<? super com.tencent.mobileqq.vas.image.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
        if (this.drawableLoaded) {
            block.invoke(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void setLoop(boolean loop) {
        super.setLoop(loop);
        Iterator<Drawable> it = this.allDrawable.iterator();
        while (it.hasNext()) {
            Object obj = (Drawable) it.next();
            if (obj instanceof com.tencent.cachedrawable.dynamicdrawable.d) {
                com.tencent.cachedrawable.dynamicdrawable.d dVar = (com.tencent.cachedrawable.dynamicdrawable.d) obj;
                L(dVar);
                dVar.restart();
            }
        }
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.VipIcon);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return "VipIcon" + arrays;
    }
}
