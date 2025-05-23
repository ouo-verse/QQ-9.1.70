package com.tencent.mobileqq.aio.animation.animator;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.particlesystem.ParticleView;
import com.tencent.mobileqq.richmedia.particlesystem.b;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.aio.utils.o;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.NumberUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0002*IB\u001f\u0012\u0006\u0010)\u001a\u00020\b\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020D\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J0\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J'\u0010&\u001a\u00020\u001c2\u0016\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0016\u00a2\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\bH\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010,R\u0016\u00100\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00108\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/ParticleAnimator;", "Lcom/tencent/mobileqq/aio/animation/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "", "maxTriggerCount", "E", "Lcom/tencent/mobileqq/aio/animation/config/a;", "animationRule", "Lmm2/a;", "w", "Lcom/tencent/mobileqq/aio/animation/config/f;", "ruleImageInfo", "Lmm2/c;", "v", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", WadlProxyConsts.PARAM_FILENAME, "y", HippyTKDListViewAdapter.X, TransferConfig.ExtendParamFloats.KEY_RULE, "D", "imageInfo", "B", "", "changed", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", "type", "a", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView;", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView;", "mParticleView", "g", "Z", "isFirstAddView", tl.h.F, "I", "mCurRunCount", "i", "mMaxRunCount", "j", "Ljava/lang/Integer;", "mCurRunId", "Lcom/tencent/mobileqq/aio/animation/animator/ParticleAnimator$a;", "k", "Lcom/tencent/mobileqq/aio/animation/animator/ParticleAnimator$a;", "clickFrequencyLimiter", "l", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()F", "systemDensity", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ParticleAnimator extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final ArrayMap<Integer, Long> f187802n;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ParticleView mParticleView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstAddView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurRunCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mMaxRunCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mCurRunId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a clickFrequencyLimiter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy systemDensity;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/ParticleAnimator$a;", "", "", "a", "", "J", WidgetCacheConstellationData.INTERVAL, "b", "lastClickTime", "<init>", "(J)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long interval;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long lastClickTime;

        public a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            } else {
                this.interval = j3;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastClickTime < this.interval) {
                return true;
            }
            this.lastClickTime = currentTimeMillis;
            return false;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/ParticleAnimator$b;", "", "", "DEFAULT_MAX_RUNNING_COUNT_LOWER_LIMIT", "I", "DEFAULT_MAX_RUNNING_COUNT_UPPER_LIMIT", "", "PATH_LOTTIE_NAME", "Ljava/lang/String;", "TAG", "Landroid/util/ArrayMap;", "", "sIdToLastStartTime", "Landroid/util/ArrayMap;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.ParticleAnimator$b, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/ParticleAnimator$c", "Llm2/b;", "", ReportConstant.COSTREPORT_PREFIX, ICustomDataEditor.STRING_PARAM_1, "", "logD", "b", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements lm2.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // lm2.b
        public void a(@Nullable String s16, @Nullable String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16, (Object) s17);
            } else {
                QLog.w(s16, 1, s17);
            }
        }

        @Override // lm2.b
        public void b(@Nullable String s16, @Nullable String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) s16, (Object) s17);
            } else if (QLog.isColorLevel()) {
                QLog.i(s16, 2, s17);
            }
        }

        @Override // lm2.b
        public void logD(@Nullable String s16, @Nullable String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16, (Object) s17);
            } else if (QLog.isColorLevel()) {
                QLog.d(s16, 2, s17);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/ParticleAnimator$d", "Llm2/g;", "Ljava/lang/Runnable;", "runnable", "", Method.POST, "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements lm2.g {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // lm2.g
        public void post(@Nullable Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            } else {
                k.INSTANCE.a().d(runnable);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/ParticleAnimator$e", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView$b;", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView;", "particleView", "", "a", "c", "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements ParticleView.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParticleAnimator.this);
            }
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.ParticleView.b
        public void a(@Nullable ParticleView particleView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) particleView);
            } else {
                QLog.i("ParticleAnimator", 1, "AnimationEventListener: onStart");
            }
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.ParticleView.b
        public void b(@Nullable ParticleView particleView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) particleView);
                return;
            }
            ParticleAnimator particleAnimator = ParticleAnimator.this;
            particleAnimator.mCurRunCount--;
            QLog.i("ParticleAnimator", 1, "AnimationEventListener: onAnimationEnd, count=" + ParticleAnimator.this.mCurRunCount);
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.ParticleView.b
        public void c(@Nullable ParticleView particleView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) particleView);
            } else {
                QLog.i("ParticleAnimator", 1, "AnimationEventListener: onStop");
                ParticleAnimator.this.h();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/ParticleAnimator$f", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView$c;", "Lcom/tencent/mobileqq/richmedia/particlesystem/ParticleView;", "particleView", "", "userdata", "", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f implements ParticleView.c {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParticleAnimator.this);
            }
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.ParticleView.c
        public void a(@Nullable ParticleView particleView, @NotNull Object userdata) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) particleView, userdata);
                return;
            }
            Intrinsics.checkNotNullParameter(userdata, "userdata");
            if (userdata instanceof com.tencent.mobileqq.aio.animation.config.f) {
                ParticleAnimator.this.B((com.tencent.mobileqq.aio.animation.config.f) userdata);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            f187802n = new ArrayMap<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParticleAnimator(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
            return;
        }
        this.isFirstAddView = true;
        this.mMaxRunCount = 1;
        this.clickFrequencyLimiter = new a(3000L);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.mobileqq.aio.animation.animator.ParticleAnimator$systemDensity$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ParticleAnimator.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                float z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Float) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                z16 = ParticleAnimator.this.z();
                return Float.valueOf(z16);
            }
        });
        this.systemDensity = lazy;
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        C(context);
    }

    private final float A() {
        return ((Number) this.systemDensity.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(com.tencent.mobileqq.aio.animation.config.f imageInfo) {
        BaseQQAppInterface baseQQAppInterface;
        String e16 = imageInfo.e();
        if (TextUtils.isEmpty(e16)) {
            QLog.i("ParticleAnimator", 1, "handleAnimClickAction: content is not valid url");
            return;
        }
        if (this.clickFrequencyLimiter.a()) {
            QLog.i("ParticleAnimator", 1, "handleAnimClickAction: click too frequently, url=" + e16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        com.tencent.mobileqq.aio.animation.util.a aVar = com.tencent.mobileqq.aio.animation.util.a.f188158a;
        Context context = b().getContext();
        Intrinsics.checkNotNull(e16);
        boolean b16 = aVar.b(baseQQAppInterface, context, e16);
        QLog.i("ParticleAnimator", 1, "handleAnimClickAction: url=" + e16 + " handleClick=" + b16);
        if (!b16) {
            return;
        }
        i iVar = i.f187873a;
        String valueOf = String.valueOf(imageInfo.b());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(imageInfo.id)");
        iVar.a(valueOf);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            o.f352309a.a(topActivity);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("ParticleAnimator", 1, "close keyboard failed");
        }
    }

    private final void C(Context context) {
        d dVar = new d();
        com.tencent.mobileqq.richmedia.particlesystem.b a16 = new b.C8517b().b(new c()).d(dVar).c(dVar).a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder()\n            .s\u2026tor)\n            .build()");
        ParticleView.f(context, a16);
    }

    private final void D(com.tencent.mobileqq.aio.animation.config.a rule) {
        if (this.mParticleView != null) {
            return;
        }
        k.INSTANCE.a().c();
        QLog.i("ParticleAnimator", 1, "initParticleView is call");
        ParticleView particleView = new ParticleView(b().getContext());
        particleView.setInterceptTouchEvent(rule.b());
        b().addView(particleView, new ViewGroup.LayoutParams(-1, -1));
        this.isFirstAddView = true;
        particleView.setAnimationEventListener(new e());
        particleView.setOnClickParticleListener(new f());
        this.mParticleView = particleView;
    }

    private final void E(int maxTriggerCount) {
        int coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(maxTriggerCount, 1, 20);
        this.mMaxRunCount = coerceIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(String id5, ParticleView it, mm2.a data, ParticleAnimator this$0) {
        Intrinsics.checkNotNullParameter(id5, "$id");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.f187873a.b(id5);
        it.d(data);
        QLog.i("ParticleAnimator", 1, "start particle, count=" + this$0.mCurRunCount);
    }

    private final mm2.c v(com.tencent.mobileqq.aio.animation.config.f ruleImageInfo) {
        int d16 = ruleImageInfo.d();
        String c16 = ruleImageInfo.c();
        Intrinsics.checkNotNull(c16);
        String y16 = y(d16, c16);
        if (y16 == null) {
            return null;
        }
        mm2.c cVar = new mm2.c();
        cVar.f416996a = ruleImageInfo.d();
        cVar.f416997b = y16;
        cVar.f416998c = ruleImageInfo.g();
        int[] b16 = com.tencent.mobileqq.aio.animation.egg.b.f188090a.b(b(), (int) (ruleImageInfo.j() * A()), (int) (ruleImageInfo.a() * A()), ruleImageInfo.h());
        cVar.f416999d = b16[0];
        cVar.f417000e = b16[1];
        cVar.f417001f = ruleImageInfo.f();
        cVar.f417003h = ruleImageInfo;
        cVar.f417002g = ruleImageInfo.i();
        ruleImageInfo.e();
        return cVar;
    }

    private final mm2.a w(com.tencent.mobileqq.aio.animation.config.a animationRule) {
        mm2.a aVar = new mm2.a();
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = animationRule.i();
        if (i3 == null) {
            return aVar;
        }
        Iterator<com.tencent.mobileqq.aio.animation.config.e> it = i3.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.aio.animation.config.e jumpImageList = it.next();
            Intrinsics.checkNotNullExpressionValue(jumpImageList, "jumpImageList");
            com.tencent.mobileqq.aio.animation.config.e eVar = jumpImageList;
            com.tencent.mobileqq.aio.animation.config.d c16 = com.tencent.mobileqq.aio.animation.config.d.INSTANCE.c(eVar.i().i(), animationRule.d());
            if (!c16.f()) {
                QLog.w("ParticleAnimator", 1, "[createRule] emitter properties are not valid");
            } else {
                mm2.b bVar = new mm2.b();
                bVar.f416970a = c16.b();
                bVar.f416972c = c16.c();
                bVar.f416971b = c16.e();
                bVar.f416974e = c16.d();
                bVar.f416982m = eVar.d();
                bVar.f416980k = eVar.i().c();
                bVar.f416979j = eVar.i().e();
                bVar.f416976g = eVar.i().f();
                bVar.f416977h = eVar.i().g();
                bVar.f416978i = eVar.i().h();
                int d16 = eVar.i().d();
                bVar.f416975f = d16;
                if (d16 == 2) {
                    float a16 = l.a(bVar.f416976g);
                    bVar.f416976g = a16;
                    bVar.f416977h = l.a(a16);
                    bVar.f416979j = l.a(bVar.f416979j);
                    bVar.f416980k = l.a(bVar.f416980k);
                }
                bVar.f416983n = eVar.i().A();
                bVar.f416984o = eVar.i().B();
                bVar.f416986q = eVar.i().a();
                bVar.f416987r = eVar.i().b();
                bVar.f416988s = eVar.i().v();
                bVar.f416989t = eVar.i().w();
                bVar.f416990u = eVar.i().x();
                bVar.f416991v = eVar.i().r();
                bVar.f416992w = eVar.i().s();
                bVar.f416993x = eVar.i().t();
                bVar.f416994y = eVar.i().j();
                bVar.f416995z = eVar.i().k();
                bVar.A = eVar.i().l();
                bVar.B = eVar.i().n();
                bVar.C = eVar.i().o();
                bVar.D = eVar.i().p();
                bVar.E = eVar.i().m();
                bVar.F = eVar.i().q();
                bVar.G = eVar.i().u();
                bVar.f416981l = NumberUtil.stringToInt(eVar.e());
                bVar.f416985p = eVar.i().z();
                bVar.H = eVar.i().y();
                bVar.I = new ArrayList();
                aVar.f416969b.add(bVar);
                ArrayList<com.tencent.mobileqq.aio.animation.config.f> g16 = eVar.g();
                if (g16 != null) {
                    for (com.tencent.mobileqq.aio.animation.config.f fVar : g16) {
                        if (fVar.c() != null) {
                            bVar.f416973d = fVar.i();
                            mm2.c v3 = v(fVar);
                            if (v3 != null) {
                                bVar.I.add(v3);
                            }
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private final void x() {
        this.mCurRunId = null;
        if (this.mParticleView != null) {
            QLog.i("ParticleAnimator", 1, "stop particle");
            ParticleView particleView = this.mParticleView;
            Intrinsics.checkNotNull(particleView);
            particleView.e();
            ParticleView particleView2 = this.mParticleView;
            Intrinsics.checkNotNull(particleView2);
            ViewParent parent = particleView2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "mParticleView!!.parent");
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mParticleView);
            }
            this.mParticleView = null;
            k.INSTANCE.a().a();
        }
        this.mCurRunCount = 0;
    }

    private final String y(int imageType, String fileName) {
        if (imageType != 1 && imageType != 2) {
            if (imageType != 3) {
                QLog.w("ParticleAnimator", 1, "[generateImagePath] invalid image type " + imageType + ", file name is " + fileName);
                return null;
            }
            return com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + fileName + File.separator + LottieLoader.FILE_DATA_JSON;
        }
        return com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + fileName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float z() {
        DisplayMetrics displayMetrics = FontSettingManager.systemMetrics;
        if (displayMetrics != null) {
            float f16 = displayMetrics.density;
            if (f16 > 0.0f) {
                return f16;
            }
        }
        return BaseApplication.context.getResources().getDisplayMetrics().density;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, type)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
        }
        ParticleView particleView = this.mParticleView;
        if (particleView != null && (changed || this.isFirstAddView)) {
            this.isFirstAddView = false;
            int paddingLeft = b().getPaddingLeft();
            int paddingTop = b().getPaddingTop();
            int paddingLeft2 = ((right - left) - b().getPaddingLeft()) - b().getPaddingRight();
            int paddingTop2 = ((bottom - top) - b().getPaddingTop()) - b().getPaddingBottom();
            particleView.layout(paddingLeft, paddingTop, paddingLeft + paddingLeft2, paddingTop + paddingTop2);
            if (particleView.getChildCount() > 0) {
                for (int childCount = particleView.getChildCount() - 1; -1 < childCount; childCount--) {
                    particleView.getChildAt(childCount).layout(0, 0, paddingLeft2, paddingTop2);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length < 1) {
            QLog.d("ParticleAnimator", 1, "startAnim args is error!");
            return false;
        }
        Object obj = args[0];
        if (obj != null && (obj instanceof com.tencent.mobileqq.aio.animation.config.a)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.config.AioAnimationRule");
            com.tencent.mobileqq.aio.animation.config.a aVar = (com.tencent.mobileqq.aio.animation.config.a) obj;
            if (aVar.i() != null) {
                ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = aVar.i();
                Intrinsics.checkNotNull(i3);
                if (!i3.isEmpty()) {
                    int h16 = aVar.h();
                    Integer num = this.mCurRunId;
                    if ((num == null || h16 != num.intValue()) && this.mCurRunCount > 0) {
                        QLog.d("ParticleAnimator", 1, "startAnim fail, another anim is running");
                        return false;
                    }
                    if (aVar.g() > 0 && (l3 = f187802n.get(Integer.valueOf(aVar.h()))) != null && SystemClock.elapsedRealtime() - l3.longValue() < aVar.g()) {
                        QLog.d("ParticleAnimator", 1, aVar.h() + " startAnim fail, in frequency duration.");
                        return false;
                    }
                    E(aVar.p());
                    int i16 = this.mCurRunCount;
                    int i17 = this.mMaxRunCount;
                    if (i16 >= i17) {
                        QLog.d("ParticleAnimator", 1, "startAnim fail, exceed limit number. count = " + i16 + ", max = " + i17);
                        return false;
                    }
                    if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
                        QLog.i("ParticleAnimator", 1, "startAnim fail, study mode");
                        return true;
                    }
                    if (e(aVar)) {
                        return false;
                    }
                    final mm2.a w3 = w(aVar);
                    final String valueOf = String.valueOf(aVar.h());
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(rule.id)");
                    if (aVar.t()) {
                        i.f187873a.c(valueOf);
                    }
                    D(aVar);
                    this.mCurRunCount++;
                    f187802n.put(Integer.valueOf(aVar.h()), Long.valueOf(SystemClock.elapsedRealtime()));
                    this.mCurRunId = Integer.valueOf(aVar.h());
                    final ParticleView particleView = this.mParticleView;
                    if (particleView != null) {
                        particleView.post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.animator.j
                            @Override // java.lang.Runnable
                            public final void run() {
                                ParticleAnimator.F(valueOf, particleView, w3, this);
                            }
                        });
                    }
                    return true;
                }
            }
            QLog.d("ParticleAnimator", 1, "startAnim AioAnimationRule not valid");
            return false;
        }
        QLog.d("ParticleAnimator", 1, "startAnim args[0] is not valid AioAnimationRule instance");
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            x();
        }
    }
}
