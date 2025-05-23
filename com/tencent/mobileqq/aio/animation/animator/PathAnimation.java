package com.tencent.mobileqq.aio.animation.animator;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.data.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002&'B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J0\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J'\u0010\r\u001a\u00020\u00022\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0013H\u0016R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0016j\b\u0012\u0004\u0012\u00020\u0011`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0018\u00010\u001aR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation;", "Lcom/tencent/mobileqq/aio/animation/f;", "", "changed", "", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/aio/animation/data/f$b;", "value", "", "t", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "values", "Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation$Animator;", "g", "Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation$Animator;", "mAnimator", "type", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", tl.h.F, "Animator", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class PathAnimation extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<f.b> values;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator mAnimator;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation$Animator;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation;)V", TencentLocation.RUN_MODE, "", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    private final class Animator implements Runnable {
        static IPatchRedirector $redirector_;

        public Animator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PathAnimation.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num;
            long intValue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList = PathAnimation.this.values;
            Intrinsics.checkNotNull(arrayList);
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "values!!.iterator()");
            long j3 = -1;
            while (it.hasNext()) {
                f.b bVar = (f.b) it.next();
                if (currentAnimationTimeMillis < bVar.i()) {
                    intValue = bVar.i() - currentAnimationTimeMillis;
                } else if (!bVar.f()) {
                    com.tencent.mobileqq.aio.animation.data.f b16 = bVar.b();
                    Intrinsics.checkNotNull(b16);
                    View j16 = bVar.j();
                    Intrinsics.checkNotNull(j16);
                    int width = j16.getWidth();
                    View j17 = bVar.j();
                    Intrinsics.checkNotNull(j17);
                    intValue = b16.b(bVar, width, j17.getHeight(), PathAnimation.this.b().getWidth(), PathAnimation.this.b().getHeight());
                    bVar.n(true);
                } else {
                    com.tencent.mobileqq.aio.animation.data.f b17 = bVar.b();
                    if (b17 != null) {
                        num = Integer.valueOf(b17.a(currentAnimationTimeMillis - bVar.i(), bVar));
                    } else {
                        num = null;
                    }
                    Intrinsics.checkNotNull(num);
                    intValue = num.intValue();
                }
                if (intValue >= 0) {
                    if (j3 < 0) {
                        j3 = intValue;
                    } else {
                        j3 = Math.min(j3, intValue);
                    }
                    PathAnimation pathAnimation = PathAnimation.this;
                    View j18 = bVar.j();
                    Intrinsics.checkNotNull(j18);
                    pathAnimation.t(j18, bVar);
                } else {
                    PathAnimation.this.b().removeViewInLayout(bVar.j());
                    it.remove();
                }
            }
            if (j3 >= 0) {
                PathAnimation.this.k(this, j3);
                PathAnimation.this.b().invalidate();
            } else {
                PathAnimation.this.h();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/PathAnimation$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.PathAnimation$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathAnimation(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
        } else {
            this.values = new ArrayList<>();
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[Catch: Exception -> 0x012a, TryCatch #0 {Exception -> 0x012a, blocks: (B:13:0x0029, B:15:0x002f, B:16:0x0045, B:18:0x006a, B:20:0x007a, B:21:0x0080, B:23:0x0094, B:26:0x00cf, B:29:0x00e5, B:31:0x00ee, B:33:0x0109, B:34:0x0105, B:36:0x00e1, B:37:0x00c8, B:39:0x0115, B:41:0x0119, B:45:0x0038), top: B:12:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: Exception -> 0x012a, TRY_LEAVE, TryCatch #0 {Exception -> 0x012a, blocks: (B:13:0x0029, B:15:0x002f, B:16:0x0045, B:18:0x006a, B:20:0x007a, B:21:0x0080, B:23:0x0094, B:26:0x00cf, B:29:0x00e5, B:31:0x00ee, B:33:0x0109, B:34:0x0105, B:36:0x00e1, B:37:0x00c8, B:39:0x0115, B:41:0x0119, B:45:0x0038), top: B:12:0x0029 }] */
    @Override // com.tencent.mobileqq.aio.animation.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(@NotNull Object... args) {
        Drawable[] drawableArr;
        Object obj;
        int i3;
        int random;
        com.tencent.mobileqq.aio.animation.data.f clone;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (c() == null) {
            return false;
        }
        try {
            Object obj2 = args[0];
            if (obj2 instanceof Object[]) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<android.graphics.drawable.Drawable>");
                drawableArr = (Drawable[]) obj2;
            } else {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                drawableArr = new Drawable[]{(Drawable) obj2};
            }
            Object obj3 = args[1];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Object obj4 = args[2];
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
            long longValue = ((Long) obj4).longValue();
            ClassLoader classLoader = PathAnimation.class.getClassLoader();
            if (classLoader != null) {
                Object obj5 = args[3];
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                Class<?> loadClass = classLoader.loadClass((String) obj5);
                if (loadClass != null) {
                    obj = loadClass.newInstance();
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.data.AnimationPath");
                    com.tencent.mobileqq.aio.animation.data.f fVar = (com.tencent.mobileqq.aio.animation.data.f) obj;
                    this.values.clear();
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    i3 = 0;
                    while (i3 < intValue) {
                        View view = new View(c().getContext());
                        long j3 = currentAnimationTimeMillis;
                        Drawable drawable = drawableArr[(int) (Math.random() * drawableArr.length)];
                        view.setBackgroundDrawable(drawable);
                        view.layout(-drawable.getIntrinsicWidth(), -drawable.getIntrinsicHeight(), 0, 0);
                        b().addView(view);
                        if (i3 == 0) {
                            random = 0;
                        } else {
                            random = (int) (Math.random() * longValue);
                        }
                        f.b bVar = new f.b();
                        bVar.o(j3 + random);
                        bVar.p(view);
                        if (i3 == 0) {
                            clone = fVar;
                        } else {
                            clone = fVar.clone();
                        }
                        bVar.m(clone);
                        if (VersionUtils.isHoneycomb()) {
                            view.setLayerType(2, null);
                            view.setPivotX(drawable.getIntrinsicWidth() / 2);
                            view.setPivotY(drawable.getIntrinsicHeight() / 2);
                        } else {
                            view.setTag(bVar);
                        }
                        this.values.add(bVar);
                        i3++;
                        currentAnimationTimeMillis = j3;
                    }
                    if (this.mAnimator == null) {
                        Animator animator = new Animator();
                        this.mAnimator = animator;
                        Intrinsics.checkNotNull(animator);
                        k(animator, 16L);
                    }
                    return true;
                }
            }
            obj = null;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.data.AnimationPath");
            com.tencent.mobileqq.aio.animation.data.f fVar2 = (com.tencent.mobileqq.aio.animation.data.f) obj;
            this.values.clear();
            long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
            i3 = 0;
            while (i3 < intValue) {
            }
            if (this.mAnimator == null) {
            }
            return true;
        } catch (Exception unused) {
            QLog.w("PathAnimation", 1, "[start] ");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Animator animator = this.mAnimator;
        if (animator != null) {
            l(animator);
            this.mAnimator = null;
        }
    }

    public final void t(@NotNull View view, @NotNull f.b value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!value.f()) {
            return;
        }
        int left = view.getLeft() + (view.getWidth() / 2);
        view.offsetTopAndBottom(value.l() - (view.getTop() + (view.getHeight() / 2)));
        view.offsetLeftAndRight(value.k() - left);
        if (VersionUtils.isHoneycomb()) {
            view.setAlpha(value.a());
            view.setRotation(value.c());
            view.setScaleX(value.g());
            view.setScaleY(value.h());
            view.setRotationX(value.d());
            view.setRotationY(value.e());
        }
    }
}
