package com.tencent.mobileqq.aio.animation.animator;

import android.animation.ValueAnimator;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.util.QQViewCompatUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002.\u0016B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J'\u0010\u0010\u001a\u00020\u00022\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r\"\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R2\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0018\u00010 R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet;", "Lcom/tencent/mobileqq/aio/animation/f;", "", "v", "", "w", "changed", "", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", EventListener.KEY_DELTA, "i", "type", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/animation/animator/d;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "u", "()Ljava/util/ArrayList;", "setJumpers", "(Ljava/util/ArrayList;)V", "jumpers", "Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet$Animator;", "g", "Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet$Animator;", "mAnimator", "", tl.h.F, "J", "pauseTime", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "Animator", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FloorJumperSet extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    private static final long f187797j;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<d> jumpers;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator mAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long pauseTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet$Animator;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet;)V", TencentLocation.RUN_MODE, "", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public final class Animator implements Runnable {
        static IPatchRedirector $redirector_;

        public Animator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloorJumperSet.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator<d> it = FloorJumperSet.this.u().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "jumpers.iterator()");
            long j3 = -1;
            while (it.hasNext()) {
                d next = it.next();
                long F = next.F();
                if (F >= 0) {
                    if (j3 < 0) {
                        j3 = F;
                    } else {
                        j3 = Math.min(j3, F);
                    }
                } else {
                    it.remove();
                    if (QLog.isColorLevel()) {
                        QLog.d("FloorJumperSet", 2, "removed businessId:" + next.t());
                    }
                }
            }
            if (j3 < 0) {
                FloorJumperSet.this.h();
                FloorJumperSet.this.b().invalidate();
            } else {
                if (FloorJumperSet.this.pauseTime == 0) {
                    FloorJumperSet.this.k(this, j3);
                }
                FloorJumperSet.this.b().invalidate();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/FloorJumperSet$a;", "", "", "FRAME_DELAY", "J", "a", "()J", "", "JD_BUSINESS_ID", "I", "MAX_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.FloorJumperSet$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return FloorJumperSet.f187797j;
            }
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29300);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
            f187797j = ValueAnimator.getFrameDelay();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloorJumperSet(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
        } else {
            this.jumpers = new ArrayList<>(16);
        }
    }

    private final boolean v() {
        return true;
    }

    private final void w() {
        Iterator<T> it = this.jumpers.iterator();
        while (it.hasNext()) {
            ((d) it.next()).o();
        }
        this.jumpers.clear();
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, type)).booleanValue();
        }
        if (type == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
        }
        Iterator<d> it = this.jumpers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "jumpers.iterator()");
        while (it.hasNext()) {
            if (it.next().f(changed, left, top, right, bottom)) {
                z16 = true;
            } else {
                it.remove();
            }
        }
        if (!z16) {
            o();
            h();
        } else {
            b().invalidate();
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void i(int delta) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, delta);
            return;
        }
        Iterator<d> it = this.jumpers.iterator();
        while (it.hasNext()) {
            d next = it.next();
            next.D(next.v() - delta);
            next.E(next.w() - delta);
        }
        QQViewCompatUtil.refelctViewGroupOffsetChildrenTopAndBottom(b(), -delta);
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.d("FloorJumperSet", 2, "[start] argsSize=" + args.length);
        }
        if (this.jumpers.size() < 16) {
            if (v()) {
                d dVar = new d(d(), b(), c());
                if (args.length >= 3) {
                    Object obj = args[2];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    dVar.A(((Integer) obj).intValue());
                }
                this.jumpers.add(dVar);
                dVar.n(Arrays.copyOf(args, args.length));
            }
            if (this.mAnimator == null) {
                Animator animator = new Animator();
                this.mAnimator = animator;
                if (this.pauseTime == 0) {
                    Intrinsics.checkNotNull(animator);
                    k(animator, f187797j);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        w();
        Animator animator = this.mAnimator;
        if (animator != null) {
            l(animator);
            this.mAnimator = null;
        }
    }

    @NotNull
    public final ArrayList<d> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.jumpers;
    }
}
