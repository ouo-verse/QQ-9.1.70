package com.tencent.mobileqq.aio.animation.business;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.business.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ds;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00025\u001dB\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J)\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J0\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J'\u0010\u0019\u001a\u00020\u00112\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u001c\u0010 \u001a\b\u0018\u00010\u001eR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\"R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation;", "Lcom/tencent/mobileqq/aio/animation/f;", "", "", "args", "Lcom/tencent/mobileqq/aio/animation/business/c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Ljava/lang/Object;)Lcom/tencent/mobileqq/aio/animation/business/c;", "", HippyTKDListViewAdapter.X, DTConstants.TAG.ELEMENT, "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "y", "Ljava/util/Queue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "B", "", "changed", "", "left", "top", "right", "bottom", "f", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", "type", "a", "Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$BusinessEggsQueueDriver;", "Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$BusinessEggsQueueDriver;", "mQueueDriver", "g", "Ljava/util/Queue;", "mAnimationWaitingQueue", tl.h.F, "mAnimationRunningQueue", "i", "mAnimationDeadQueue", "", "", "Lcom/tencent/mobileqq/aio/animation/config/a;", "j", "Ljava/util/Map;", "mRuleMapping", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "k", "BusinessEggsQueueDriver", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class BusinessEggsAnimation extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessEggsQueueDriver mQueueDriver;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<c> mAnimationWaitingQueue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<c> mAnimationRunningQueue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<c> mAnimationDeadQueue;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, com.tencent.mobileqq.aio.animation.config.a> mRuleMapping;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$BusinessEggsQueueDriver;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation;)V", TencentLocation.RUN_MODE, "", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    private final class BusinessEggsQueueDriver implements Runnable {
        static IPatchRedirector $redirector_;

        public BusinessEggsQueueDriver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessEggsAnimation.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (BusinessEggsAnimation.this.mAnimationWaitingQueue.isEmpty() && BusinessEggsAnimation.this.mAnimationDeadQueue.isEmpty() && BusinessEggsAnimation.this.mAnimationRunningQueue.isEmpty()) {
                BusinessEggsAnimation businessEggsAnimation = BusinessEggsAnimation.this;
                businessEggsAnimation.g(businessEggsAnimation.d());
                BusinessEggsAnimation.this.mQueueDriver = null;
                if (QLog.isColorLevel()) {
                    QLog.i("BusinessEggsAnimation", 2, "[BusinessEggsQueueDriver#run] all queues empty");
                    return;
                }
                return;
            }
            if (!BusinessEggsAnimation.this.mAnimationWaitingQueue.isEmpty()) {
                Object remove = BusinessEggsAnimation.this.mAnimationWaitingQueue.remove();
                Intrinsics.checkNotNullExpressionValue(remove, "mAnimationWaitingQueue.remove()");
                c cVar = (c) remove;
                BusinessEggsAnimation.this.mAnimationRunningQueue.add(cVar);
                cVar.n();
                if (QLog.isColorLevel()) {
                    QLog.i("BusinessEggsAnimation", 2, "[BusinessEggsQueueDriver#run] peak one then play");
                }
            }
            BusinessEggsAnimation businessEggsAnimation2 = BusinessEggsAnimation.this;
            businessEggsAnimation2.B(businessEggsAnimation2.mAnimationDeadQueue);
            BusinessEggsAnimation.this.k(this, 1000L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$a;", "", "", "MAX_QUEUE_LENGTH", "I", "", "SIN_X_SCALE", UserInfo.SEX_FEMALE, "SIN_Y_SCALE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.business.BusinessEggsAnimation$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$b", "Lcom/tencent/mobileqq/aio/animation/business/c$b;", "Landroid/graphics/Point;", "screenBoundaryPoint", "c", "Landroid/animation/ValueAnimator;", "animator", "", "a", "startPoint", "", "progress", "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements c.b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/animation/business/BusinessEggsAnimation$b$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a extends com.tencent.mobileqq.widget.f {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ BusinessEggsAnimation f187893d;

            a(BusinessEggsAnimation businessEggsAnimation) {
                this.f187893d = businessEggsAnimation;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessEggsAnimation);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                    return;
                }
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (!this.f187893d.mAnimationRunningQueue.isEmpty()) {
                    Object remove = this.f187893d.mAnimationRunningQueue.remove();
                    Intrinsics.checkNotNullExpressionValue(remove, "mAnimationRunningQueue.remove()");
                    c cVar = (c) remove;
                    this.f187893d.mAnimationDeadQueue.add(cVar);
                    cVar.o();
                    if (QLog.isColorLevel()) {
                        QLog.i("BusinessEggsAnimation", 2, "[onAnimationEnd]");
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessEggsAnimation.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.animation.business.c.b
        public void a(@NotNull ValueAnimator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            animator.setDuration(5500L);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.addListener(new a(BusinessEggsAnimation.this));
        }

        @Override // com.tencent.mobileqq.aio.animation.business.c.b
        @NotNull
        public Point b(@NotNull Point startPoint, @NotNull Point screenBoundaryPoint, float progress) {
            double cos;
            int a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Point) iPatchRedirector.redirect((short) 4, this, startPoint, screenBoundaryPoint, Float.valueOf(progress));
            }
            Intrinsics.checkNotNullParameter(startPoint, "startPoint");
            Intrinsics.checkNotNullParameter(screenBoundaryPoint, "screenBoundaryPoint");
            Point point = new Point();
            if (startPoint.x % 2 == 0) {
                cos = Math.sin(progress * 6.283185307179586d);
                a16 = ViewUtils.f352270a.a(60.0f);
            } else {
                cos = Math.cos(progress * 6.283185307179586d);
                a16 = ViewUtils.f352270a.a(60.0f);
            }
            point.x = (int) ((((int) (cos * a16)) * 1.5f) + startPoint.x);
            point.y = (int) (screenBoundaryPoint.y * 1.3f * progress);
            return point;
        }

        @Override // com.tencent.mobileqq.aio.animation.business.c.b
        @NotNull
        public Point c(@NotNull Point screenBoundaryPoint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Point) iPatchRedirector.redirect((short) 2, (Object) this, (Object) screenBoundaryPoint);
            }
            Intrinsics.checkNotNullParameter(screenBoundaryPoint, "screenBoundaryPoint");
            Point point = new Point();
            point.x = (int) ((screenBoundaryPoint.x / 2) + (ds.b(-1.0f, 1.0f) * ViewUtils.f352270a.a(50.0f)));
            point.y = 0;
            return point;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29521);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BusinessEggsAnimation(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
            return;
        }
        this.mAnimationWaitingQueue = new LinkedList();
        this.mAnimationRunningQueue = new LinkedList();
        this.mAnimationDeadQueue = new LinkedList();
        this.mRuleMapping = new HashMap();
    }

    private final c A(Object... args) {
        c cVar = new c(b(), c());
        try {
            Object obj = args[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
            Drawable drawable = (Drawable) obj;
            Object obj2 = args[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.config.AioAnimationRule");
            com.tencent.mobileqq.aio.animation.config.a aVar = (com.tencent.mobileqq.aio.animation.config.a) obj2;
            long e16 = ds.e();
            this.mRuleMapping.put(Long.valueOf(e16), aVar);
            cVar.l(e16);
            cVar.i(drawable);
            if (QLog.isColorLevel()) {
                QLog.d("BusinessEggsAnimation", 2, "[parseEggsAnimationInfo] sig: " + e16 + ", rule id: " + aVar.h());
            }
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Queue<c> queue) {
        if (!queue.isEmpty()) {
            for (c cVar : queue) {
                if (cVar.h()) {
                    cVar.o();
                }
                cVar.k(null);
                cVar.j(null);
            }
            queue.clear();
        }
    }

    private final void x() {
        if (!this.mAnimationWaitingQueue.isEmpty()) {
            this.mAnimationWaitingQueue.clear();
        }
        B(this.mAnimationRunningQueue);
        if (!this.mAnimationDeadQueue.isEmpty()) {
            this.mAnimationDeadQueue.clear();
        }
    }

    private final void y(c element, com.tencent.mobileqq.aio.animation.data.b message) {
        String str;
        final com.tencent.mobileqq.aio.animation.config.a aVar = this.mRuleMapping.get(Long.valueOf(element.c()));
        if (aVar != null) {
            str = aVar.k();
        } else {
            str = null;
        }
        if (str != null && aVar.l() != null) {
            element.j(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.animation.business.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BusinessEggsAnimation.z(com.tencent.mobileqq.aio.animation.config.a.this, view);
                }
            });
        }
        element.k(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(com.tencent.mobileqq.aio.animation.config.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (Intrinsics.areEqual("HTML", aVar.k())) {
            if (!TextUtils.isEmpty(aVar.l())) {
                IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                String l3 = aVar.l();
                Intrinsics.checkNotNull(l3);
                iAIOJumpAction.openBrowser(context, l3);
            }
        } else {
            QLog.e("BusinessEggsAnimation", 1, "[initElementPathStrategy] jump type not define: " + aVar.k());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, type)).booleanValue();
        }
        if (type == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        c A;
        com.tencent.mobileqq.aio.animation.data.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.i("BusinessEggsAnimation", 2, "[start] start animation");
        }
        if (this.mAnimationWaitingQueue.size() >= 10 || (A = A(Arrays.copyOf(args, args.length))) == null) {
            return false;
        }
        try {
            Object obj = args[2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.data.AIOMsg");
            bVar = (com.tencent.mobileqq.aio.animation.data.b) obj;
        } catch (Exception unused) {
            QLog.e("BusinessEggsAnimation", 1, "[start] message is null");
            bVar = null;
        }
        y(A, bVar);
        this.mAnimationWaitingQueue.add(A);
        if (this.mQueueDriver == null) {
            BusinessEggsQueueDriver businessEggsQueueDriver = new BusinessEggsQueueDriver();
            this.mQueueDriver = businessEggsQueueDriver;
            Intrinsics.checkNotNull(businessEggsQueueDriver);
            j(businessEggsQueueDriver);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BusinessEggsAnimation", 2, "[stop] stop animation");
        }
        x();
        l(this.mQueueDriver);
    }
}
