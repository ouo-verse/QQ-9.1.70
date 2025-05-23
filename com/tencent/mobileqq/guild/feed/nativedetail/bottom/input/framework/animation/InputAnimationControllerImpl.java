package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.util.Supplier;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u009c\u00012\u00020\u0001:\u000459/>B\u0019\u0012\u0006\u00107\u001a\u00020\u001f\u0012\u0006\u0010;\u001a\u000208\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J.\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J \u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0012\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0016\u00103\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u00104\u001a\u00020\u0002H\u0016R\u0014\u00107\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00106R*\u0010%\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00068\u0016@RX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010H\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010D\u001a\u0004\bE\u0010F\"\u0004\b>\u0010GR$\u0010O\u001a\u0004\u0018\u00010I8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\b5\u0010L\"\u0004\bM\u0010NR$\u0010R\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00068\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\bQ\u0010\u0011\u001a\u0004\bJ\u0010@R\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\u0011R\"\u0010V\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0011\u001a\u0004\bQ\u0010@\"\u0004\bU\u0010BR\"\u0010Y\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0011\u001a\u0004\bW\u0010@\"\u0004\bX\u0010BR$\u0010a\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010\u0011R\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010\u0011R\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001e\u0010t\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010x\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\bu\u0010\u0010\u0012\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010\u0010R\u0016\u0010|\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010\u0010R\u0016\u0010~\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010\u0010R\u0015\u0010\u0080\u0001\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u007f\u0010\u0011R\u0016\u0010\u0082\u0001\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u0011R/\u0010\u0084\u0001\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00168\u0016@VX\u0096\u000e\u00a2\u0006\u0016\n\u0005\b\u0083\u0001\u0010\u0010\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0005\bS\u0010\u0086\u0001R\u001c\u0010\u008a\u0001\u001a\u00070\u0087\u0001R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u00070\u008b\u0001R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0016\u0010\u0098\u0001\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010@R\u0015\u0010\u0099\u0001\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010@\u00a8\u0006\u009d\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "", ExifInterface.LATITUDE_SOUTH, UserInfo.SEX_FEMALE, "i0", "", "initialHeight", "targetHeight", "Lkotlin/Function0;", "calledIfAlreadyReach", "Landroid/animation/Animator$AnimatorListener;", "listener", "G", "start", "end", "Z", "I", "J", "panelId", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "isEnterIgnoredMode", "V", "hasInsetAnimation", "W", "Y", "c0", "H", "U", "", "reason", BdhLogUtil.LogTag.Tag_Req, "height", NodeProps.MAX_HEIGHT, "j0", "state", "K", "T", "foldState", "keyboardHeight", "X", "b0", "e", "why", "flag", "c", "Landroidx/core/util/Supplier;", "Landroid/content/res/Configuration;", "configProvider", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "Ljava/lang/String;", "tagPrefix", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "viewBinding", "logTag", "value", "d", "getState", "()I", "h0", "(I)V", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "O", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;)V", "stateUpdateListener", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "i", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;)V", "uiStateUpdater", "<set-?>", "g", "expandedHeight", h.F, "keyboardTargetHeight", "g0", "stableKeyboardShowHeight", "j", "e0", "currentMaxExpandedHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "k", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "M", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "f0", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;)V", "keyboardIgnoredModeDetector", "", "l", "[I", "lastKeyboardHeightApplied", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[Ljava/lang/Boolean;", "lastKeyboardVisibleState", DomainData.DOMAIN_NAME, "currentKeyboardHeight", "o", "curPanelId", "Landroid/animation/Animator;", "p", "Landroid/animation/Animator;", "selfAnimator", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/core/util/Supplier;", "configurationProvider", "r", "isUseSystemWindowInsetAnimation$annotations", "()V", "isUseSystemWindowInsetAnimation", ReportConstant.COSTREPORT_PREFIX, "isPrepareToAcceptInsetAnim", "t", "expandedHeightDecreaseLock", "u", "isKeyboardIgnoreMode", "v", "persistentInsetTypes", "w", "deferredInsetTypes", HippyTKDListViewAdapter.X, "isEnableInsetAnimationListener", "()Z", "(Z)V", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$c;", "y", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$c;", "rootViewDeferringInsetsCallback", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$d;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$d;", "inputTranslateDeferringInsetsCallback", "Lpz0/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lpz0/a;", "mmkvAdapter", "Lve1/b;", "B", "Lve1/b;", "mInterpolator", "N", "orientation", "normalPanelHeight", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InputAnimationControllerImpl implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e {

    /* renamed from: A, reason: from kotlin metadata */
    private pz0.a mmkvAdapter;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final ve1.b mInterpolator;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tagPrefix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e.c viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e.a stateUpdateListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e.b uiStateUpdater;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int expandedHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int keyboardTargetHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int stableKeyboardShowHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int currentMaxExpandedHeight;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b keyboardIgnoredModeDetector;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] lastKeyboardHeightApplied;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Boolean[] lastKeyboardVisibleState;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int currentKeyboardHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int curPanelId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator selfAnimator;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Supplier<Configuration> configurationProvider;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseSystemWindowInsetAnimation;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isPrepareToAcceptInsetAnim;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean expandedHeightDecreaseLock;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyboardIgnoreMode;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final int persistentInsetTypes;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final int deferredInsetTypes;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableInsetAnimationListener;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c rootViewDeferringInsetsCallback;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d inputTranslateDeferringInsetsCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "", "", "keyboardHeight", "", "isVisible", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        boolean a(int keyboardHeight, boolean isVisible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$c;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "a", "", "isKeyboardVisible", "keyboardHeight", "", "d", "hasInsetAnimation", "c", "Landroid/view/View;", "view", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "onPrepare", "", "runningAnimations", "onProgress", "onEnd", "Landroid/view/View;", "whichView", "e", "Landroidx/core/view/WindowInsetsCompat;", "lastWindowInset", "f", "Z", "needDeferInset", "", "b", "()Ljava/lang/String;", "logTag", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class c extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View whichView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WindowInsetsCompat lastWindowInset;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean needDeferInset;

        public c() {
            super(1);
            if ((InputAnimationControllerImpl.this.deferredInsetTypes & InputAnimationControllerImpl.this.persistentInsetTypes) == 0) {
            } else {
                throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values".toString());
            }
        }

        private final int a(WindowInsetsCompat insets) {
            InputAnimationControllerImpl inputAnimationControllerImpl = InputAnimationControllerImpl.this;
            return Insets.max(Insets.subtract(insets.getInsets(inputAnimationControllerImpl.deferredInsetTypes), insets.getInsets(inputAnimationControllerImpl.persistentInsetTypes)), Insets.NONE).bottom;
        }

        private final String b() {
            return InputAnimationControllerImpl.this.logTag + ".Root";
        }

        private final void c(boolean isKeyboardVisible, int keyboardHeight, boolean hasInsetAnimation) {
            if (!isKeyboardVisible) {
                InputAnimationControllerImpl.this.U(hasInsetAnimation);
            } else {
                InputAnimationControllerImpl.this.g0(keyboardHeight);
                InputAnimationControllerImpl.this.W(hasInsetAnimation);
            }
        }

        private final void d(boolean isKeyboardVisible, int keyboardHeight) {
            InputAnimationControllerImpl.this.keyboardTargetHeight = keyboardHeight;
            if (this.needDeferInset && (InputAnimationControllerImpl.this.lastKeyboardHeightApplied[1] != keyboardHeight || !Intrinsics.areEqual(InputAnimationControllerImpl.this.lastKeyboardVisibleState[1], Boolean.valueOf(isKeyboardVisible)))) {
                InputAnimationControllerImpl.this.lastKeyboardVisibleState[1] = Boolean.valueOf(isKeyboardVisible);
                InputAnimationControllerImpl.this.lastKeyboardHeightApplied[1] = keyboardHeight;
                c(isKeyboardVisible, keyboardHeight, true);
            } else if (!this.needDeferInset) {
                if (InputAnimationControllerImpl.this.lastKeyboardHeightApplied[0] != keyboardHeight || !Intrinsics.areEqual(InputAnimationControllerImpl.this.lastKeyboardVisibleState[0], Boolean.valueOf(isKeyboardVisible))) {
                    InputAnimationControllerImpl.this.lastKeyboardVisibleState[0] = Boolean.valueOf(isKeyboardVisible);
                    InputAnimationControllerImpl.this.lastKeyboardHeightApplied[0] = keyboardHeight;
                    c(isKeyboardVisible, keyboardHeight, false);
                }
            }
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NotNull
        public WindowInsetsCompat onApplyWindowInsets(@NotNull View view, @NotNull WindowInsetsCompat insets) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(insets, "insets");
            this.whichView = view;
            this.lastWindowInset = insets;
            Insets insets2 = insets.getInsets(InputAnimationControllerImpl.this.persistentInsetTypes);
            InputAnimationControllerImpl.this.viewBinding.getRoot().setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
            int a16 = a(insets);
            boolean z18 = false;
            if (!insets.isVisible(InputAnimationControllerImpl.this.deferredInsetTypes) && a16 <= 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (a16 == 0 && z16) {
                this.needDeferInset = false;
            }
            boolean z19 = InputAnimationControllerImpl.this.isKeyboardIgnoreMode;
            InputAnimationControllerImpl inputAnimationControllerImpl = InputAnimationControllerImpl.this;
            b keyboardIgnoredModeDetector = inputAnimationControllerImpl.getKeyboardIgnoredModeDetector();
            if (keyboardIgnoredModeDetector != null && keyboardIgnoredModeDetector.a(a16, z16)) {
                z17 = true;
            } else {
                z17 = false;
            }
            inputAnimationControllerImpl.isKeyboardIgnoreMode = z17;
            QLog.i(InputAnimationControllerImpl.this.logTag, 1, "onApplyWindowInset|" + InputAnimationControllerImpl.L(InputAnimationControllerImpl.this, 0, 1, null) + ", isKeyboardVisible=" + z16 + ", computeKeyboardHeight=" + a16 + ", needDeferInset=" + this.needDeferInset + ",  oldMode=" + z19 + ", newMode=" + InputAnimationControllerImpl.this.isKeyboardIgnoreMode);
            if (InputAnimationControllerImpl.this.isKeyboardIgnoreMode) {
                InputAnimationControllerImpl inputAnimationControllerImpl2 = InputAnimationControllerImpl.this;
                if (!z19 && inputAnimationControllerImpl2.isKeyboardIgnoreMode) {
                    z18 = true;
                }
                inputAnimationControllerImpl2.V(z18);
                WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
                Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
                return CONSUMED;
            }
            d(z16, a16);
            WindowInsetsCompat CONSUMED2 = WindowInsetsCompat.CONSUMED;
            Intrinsics.checkNotNullExpressionValue(CONSUMED2, "CONSUMED");
            return CONSUMED2;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
            View view;
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.needDeferInset && (animation.getTypeMask() & InputAnimationControllerImpl.this.deferredInsetTypes) != 0) {
                this.needDeferInset = false;
                InputAnimationControllerImpl.this.expandedHeightDecreaseLock = false;
                WindowInsetsCompat windowInsetsCompat = this.lastWindowInset;
                if (windowInsetsCompat != null && (view = this.whichView) != null) {
                    ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d(b(), 4, "onPrepare: animType=" + animation.getTypeMask() + ",needDefer=" + this.needDeferInset + ", debugInfo=" + InputAnimationControllerImpl.L(InputAnimationControllerImpl.this, 0, 1, null));
            if ((animation.getTypeMask() & InputAnimationControllerImpl.this.deferredInsetTypes) != 0) {
                this.needDeferInset = true;
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            return insets;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$d;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "", "msg", "", "a", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "onPrepare", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onStart", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "runningAnimations", "onProgress", "onEnd", "", "d", "Z", "isLocalPrepared", "b", "()Ljava/lang/String;", "logTag", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class d extends WindowInsetsAnimationCompat.Callback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isLocalPrepared;

        public d() {
            super(0);
            if ((InputAnimationControllerImpl.this.deferredInsetTypes & InputAnimationControllerImpl.this.persistentInsetTypes) == 0) {
            } else {
                throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values".toString());
            }
        }

        private final void a(String msg2) {
            QLog.d(b(), 4, msg2);
        }

        private final String b() {
            return InputAnimationControllerImpl.this.logTag + ".Input";
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.i(b(), 1, "[onEnd]: anim type: " + animation.getTypeMask() + " animFrac: " + animation.getFraction());
            if ((animation.getTypeMask() & InputAnimationControllerImpl.this.deferredInsetTypes) != 0) {
                this.isLocalPrepared = false;
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.i(b(), 1, "[onPrepare]: animType=" + animation.getTypeMask());
            if ((animation.getTypeMask() & InputAnimationControllerImpl.this.deferredInsetTypes) != 0) {
                this.isLocalPrepared = true;
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            if (this.isLocalPrepared && InputAnimationControllerImpl.this.isPrepareToAcceptInsetAnim) {
                Insets insets2 = insets.getInsets(InputAnimationControllerImpl.this.deferredInsetTypes);
                Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(deferredInsetTypes)");
                Insets insets3 = insets.getInsets(InputAnimationControllerImpl.this.persistentInsetTypes);
                Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(persistentInsetTypes)");
                Insets max = Insets.max(Insets.subtract(insets2, insets3), Insets.NONE);
                Intrinsics.checkNotNullExpressionValue(max, "subtract(typesInset, oth\u2026nsets.NONE)\n            }");
                int i3 = max.bottom - max.top;
                InputAnimationControllerImpl.this.currentKeyboardHeight = i3;
                if (i3 - InputAnimationControllerImpl.this.getExpandedHeight() < 0 && InputAnimationControllerImpl.this.expandedHeightDecreaseLock) {
                    a("[onProgress]: decrease expand height update, but it is ignored");
                    return insets;
                }
                InputAnimationControllerImpl inputAnimationControllerImpl = InputAnimationControllerImpl.this;
                inputAnimationControllerImpl.j0("onProgress", i3, inputAnimationControllerImpl.getStableKeyboardShowHeight());
                InputAnimationControllerImpl inputAnimationControllerImpl2 = InputAnimationControllerImpl.this;
                inputAnimationControllerImpl2.X(inputAnimationControllerImpl2.getState() & 7, i3);
            }
            return insets;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsAnimationCompat.BoundsCompat onStart(@NotNull WindowInsetsAnimationCompat animation, @NotNull WindowInsetsAnimationCompat.BoundsCompat bounds) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            QLog.d(b(), 1, "[onStart]: bounds=" + bounds + ", anim type: " + animation.getTypeMask());
            WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(animation, bounds);
            Intrinsics.checkNotNullExpressionValue(onStart, "super.onStart(animation, bounds)");
            return onStart;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "isCanceled", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isCanceled;

        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            this.isCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (!this.isCanceled && InputAnimationControllerImpl.this.getState() == 18) {
                QLog.i(InputAnimationControllerImpl.this.logTag, 1, "hidePanel onAnimationEnd");
                InputAnimationControllerImpl.this.c0();
                InputAnimationControllerImpl.this.h0(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$f", "Lpz0/a;", "", "key", "", "defValue", "decodeInt", "value", "", "encodeInt", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements pz0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f220572a;

        f(MMKVOptionEntity mMKVOptionEntity) {
            this.f220572a = mMKVOptionEntity;
        }

        @Override // pz0.a
        public int decodeInt(@NotNull String key, int defValue) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f220572a.decodeInt(key, defValue);
        }

        @Override // pz0.a
        public void encodeInt(@NotNull String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f220572a.encodeInt(key, value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "isCanceled", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isCanceled;

        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            this.isCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (!this.isCanceled && InputAnimationControllerImpl.this.getState() == 19) {
                InputAnimationControllerImpl.this.h0(17);
            }
        }
    }

    public InputAnimationControllerImpl(@NotNull String tagPrefix, @NotNull e.c viewBinding) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tagPrefix, "tagPrefix");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.tagPrefix = tagPrefix;
        this.viewBinding = viewBinding;
        this.logTag = tagPrefix + ".InputAnimationController";
        S();
        this.currentMaxExpandedHeight = b();
        this.lastKeyboardHeightApplied = new int[]{0, 0};
        this.lastKeyboardVisibleState = new Boolean[2];
        this.curPanelId = -1;
        if (Build.VERSION.SDK_INT >= 30) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isUseSystemWindowInsetAnimation = z16;
        this.isPrepareToAcceptInsetAnim = true;
        this.persistentInsetTypes = WindowInsetsCompat.Type.navigationBars();
        this.deferredInsetTypes = WindowInsetsCompat.Type.ime();
        c cVar = new c();
        this.rootViewDeferringInsetsCallback = cVar;
        this.inputTranslateDeferringInsetsCallback = new d();
        h(true);
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding.getRoot(), cVar);
        this.mInterpolator = new ve1.b(0.0f, 0.5f, 0.42f, 1.0f);
    }

    private final void F() {
        if (!this.isUseSystemWindowInsetAnimation) {
            return;
        }
        QLog.i(this.logTag, 1, "addWindowInsetsAnimationCallback");
        ViewCompat.setWindowInsetsAnimationCallback(this.viewBinding.getRoot(), this.rootViewDeferringInsetsCallback);
        ViewCompat.setWindowInsetsAnimationCallback(this.viewBinding.b(), this.inputTranslateDeferringInsetsCallback);
    }

    private final void G(int initialHeight, int targetHeight, Function0<Unit> calledIfAlreadyReach, Animator.AnimatorListener listener) {
        int coerceAtLeast;
        int coerceAtLeast2;
        if (initialHeight == targetHeight) {
            calledIfAlreadyReach.invoke();
            return;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(targetHeight, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(initialHeight, 0);
        Z(coerceAtLeast2, coerceAtLeast, listener);
    }

    private final void H() {
        if (getExpandedHeight() != this.keyboardTargetHeight) {
            this.expandedHeightDecreaseLock = true;
        }
    }

    private final void I() {
        QLog.i(this.logTag, 1, "[cancelAllAnimation]: isPrepareToAcceptInsetAnim=" + this.isPrepareToAcceptInsetAnim);
        J();
        this.isPrepareToAcceptInsetAnim = false;
    }

    private final void J() {
        Animator animator = this.selfAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.selfAnimator = null;
    }

    private final String K(int state) {
        String str;
        int i3 = state & 7;
        String str2 = "";
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        str = "";
                    } else {
                        str = "expanding";
                    }
                } else {
                    str = "folding";
                }
            } else {
                str = "expanded";
            }
        } else {
            str = "collapsed";
        }
        int i16 = state & (-8);
        if (i16 != 8) {
            if (i16 == 16) {
                str2 = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL;
            }
        } else {
            str2 = "keyboard";
        }
        return "expandedHeight=" + getExpandedHeight() + ", state=" + str2 + "." + str;
    }

    static /* synthetic */ String L(InputAnimationControllerImpl inputAnimationControllerImpl, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = inputAnimationControllerImpl.getState();
        }
        return inputAnimationControllerImpl.K(i3);
    }

    private final int N() {
        Configuration configuration;
        Supplier<Configuration> supplier = this.configurationProvider;
        if (supplier != null && (configuration = supplier.get()) != null) {
            return configuration.orientation;
        }
        return 1;
    }

    private final void P(int panelId) {
        int i3 = this.curPanelId;
        if (i3 == panelId && i3 != -1) {
            int state = getState();
            if (state == 17 || state == 19) {
                Q();
            }
        }
    }

    private final void Q() {
        I();
        h0(18);
        G(getExpandedHeight(), 0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl$hidePanelInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                InputAnimationControllerImpl.this.h0(0);
            }
        }, new e());
    }

    private final void R(String reason) {
        QLog.i(this.logTag, 1, "[hideSoftInput]: because " + reason);
        e.b uiStateUpdater = getUiStateUpdater();
        if (uiStateUpdater != null) {
            uiStateUpdater.b();
        }
    }

    private final void S() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.mmkvAdapter = new f(from);
    }

    private final boolean T() {
        int state = getState() & 7;
        if (state == 3 || state == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(boolean hasInsetAnimation) {
        if ((getState() & 8) == 0) {
            return;
        }
        if (!hasInsetAnimation) {
            this.currentKeyboardHeight = 0;
            j0("keyboardHide", 0, b());
            h0(0);
            X(0, 0);
            return;
        }
        this.isPrepareToAcceptInsetAnim = true;
        h0(10);
        X(2, this.currentKeyboardHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(boolean isEnterIgnoredMode) {
        if (!isEnterIgnoredMode) {
            return;
        }
        if (T() && (getState() & (-8)) == 16) {
            QLog.i(this.logTag, 1, "[moveStateWhenKeyboardIgnored]: " + L(this, 0, 1, null));
            return;
        }
        I();
        g0(0);
        j0("Enter keyboardIgnoredMode", 0, 0);
        e.b uiStateUpdater = getUiStateUpdater();
        if (uiStateUpdater != null) {
            uiStateUpdater.f();
        }
        this.curPanelId = 9999;
        h0(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(boolean hasInsetAnimation) {
        J();
        if (!hasInsetAnimation) {
            int i3 = this.keyboardTargetHeight;
            this.currentKeyboardHeight = i3;
            j0("keyboardShow", i3, i3);
            c0();
            h0(9);
            X(1, this.keyboardTargetHeight);
            return;
        }
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int foldState, int keyboardHeight) {
        int coerceAtLeast;
        if (foldState == 1 && keyboardHeight > 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(keyboardHeight, ViewUtils.dpToPx(280.0f));
            com.tencent.input.base.panelcontainer.keyboard.e eVar = com.tencent.input.base.panelcontainer.keyboard.e.f116886a;
            pz0.a aVar = this.mmkvAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mmkvAdapter");
                aVar = null;
            }
            eVar.d(aVar, coerceAtLeast, N());
        }
        e.a stateUpdateListener = getStateUpdateListener();
        if (stateUpdateListener != null) {
            stateUpdateListener.c(foldState, keyboardHeight);
        }
    }

    private final void Y() {
        switch (getState()) {
            case 17:
            case 19:
                c0();
                break;
            case 18:
                c0();
                H();
                break;
        }
        if (getExpandedHeight() == this.keyboardTargetHeight) {
            this.isPrepareToAcceptInsetAnim = false;
            h0(9);
        } else {
            this.isPrepareToAcceptInsetAnim = true;
            h0(11);
        }
    }

    private final void Z(final int start, int end, Animator.AnimatorListener listener) {
        final int i3 = end - start;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setDuration(285L);
        valueAnimator.setInterpolator(this.mInterpolator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                InputAnimationControllerImpl.a0(InputAnimationControllerImpl.this, start, i3, valueAnimator2);
            }
        });
        valueAnimator.addListener(listener);
        valueAnimator.start();
        this.selfAnimator = valueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(InputAnimationControllerImpl this$0, int i3, int i16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.j0("animatePanel", (int) (i3 + (i16 * ((Float) animatedValue).floatValue())), this$0.b());
    }

    private final void b0() {
        if (this.isUseSystemWindowInsetAnimation) {
            return;
        }
        QLog.i(this.logTag, 1, "removeInsetsAnimationCallback");
        ViewCompat.setWindowInsetsAnimationCallback(this.viewBinding.getRoot(), null);
        ViewCompat.setWindowInsetsAnimationCallback(this.viewBinding.b(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        if (this.curPanelId != -1) {
            this.curPanelId = -1;
            e.b uiStateUpdater = getUiStateUpdater();
            if (uiStateUpdater != null) {
                uiStateUpdater.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i3) {
        e.a stateUpdateListener;
        int i16 = this.state;
        this.state = i3;
        if (i3 == 0 && (stateUpdateListener = getStateUpdateListener()) != null) {
            stateUpdateListener.d();
        }
        if (i16 != i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d(this.logTag, 4, "onStateChanged|oldState={" + K(i16) + "},  newState={" + K(i3) + "}");
            }
            e.a stateUpdateListener2 = getStateUpdateListener();
            if (stateUpdateListener2 != null) {
                stateUpdateListener2.onStateChanged(i3);
            }
        }
    }

    private final void i0() {
        I();
        h0(19);
        G(getExpandedHeight(), b(), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl$showPanelInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                InputAnimationControllerImpl.this.h0(17);
            }
        }, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String reason, int height, int maxHeight) {
        this.expandedHeight = height;
        e0(maxHeight);
        e.b uiStateUpdater = getUiStateUpdater();
        if (uiStateUpdater != null) {
            uiStateUpdater.a(height, maxHeight);
        }
    }

    @Nullable
    /* renamed from: M, reason: from getter */
    public final b getKeyboardIgnoredModeDetector() {
        return this.keyboardIgnoredModeDetector;
    }

    @Nullable
    /* renamed from: O, reason: from getter */
    public e.a getStateUpdateListener() {
        return this.stateUpdateListener;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    @Nullable
    /* renamed from: a, reason: from getter */
    public e.b getUiStateUpdater() {
        return this.uiStateUpdater;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public int b() {
        int coerceAtLeast;
        com.tencent.input.base.panelcontainer.keyboard.e eVar = com.tencent.input.base.panelcontainer.keyboard.e.f116886a;
        pz0.a aVar = this.mmkvAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mmkvAdapter");
            aVar = null;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(eVar.a(aVar, N()), ViewUtils.dpToPx(280.0f));
        return coerceAtLeast;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void c(@NotNull String why, int flag) {
        Intrinsics.checkNotNullParameter(why, "why");
        QLog.i(this.logTag, 1, "[hideAllPanelAndKeyboard]: why=" + why + ", " + L(this, 0, 1, null) + ", flag=" + flag);
        e.b uiStateUpdater = getUiStateUpdater();
        if (uiStateUpdater != null) {
            uiStateUpdater.b();
        }
        if (getState() == 0) {
            e.a stateUpdateListener = getStateUpdateListener();
            if (stateUpdateListener != null) {
                stateUpdateListener.d();
                return;
            }
            return;
        }
        if (flag != 1) {
            if (flag != 2) {
                P(this.curPanelId);
                return;
            }
            throw new NotImplementedError("");
        }
        I();
        c0();
        j0("hideAllPanelAndKeyboard", 0, getCurrentMaxExpandedHeight());
        ArraysKt___ArraysJvmKt.fill$default(this.lastKeyboardHeightApplied, 0, 0, 0, 6, (Object) null);
        ArraysKt___ArraysJvmKt.fill$default(this.lastKeyboardVisibleState, Boolean.FALSE, 0, 0, 6, (Object) null);
        h0(0);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void d(@Nullable e.a aVar) {
        this.stateUpdateListener = aVar;
    }

    public void d0(@NotNull Supplier<Configuration> configProvider) {
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        this.configurationProvider = configProvider;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void e(int panelId) {
        if (panelId == -1) {
            QLog.e(this.logTag, 1, "[showPanel]: uses invalid panel id!");
            return;
        }
        QLog.i(this.logTag, 1, "[showPanel]: " + L(this, 0, 1, null));
        if (getState() == 17 && this.curPanelId != 9999) {
            QLog.d(this.logTag, 4, "[showPanel]: already showed");
            return;
        }
        this.curPanelId = panelId;
        e.b uiStateUpdater = getUiStateUpdater();
        if (uiStateUpdater != null) {
            uiStateUpdater.e(panelId, b());
        }
        R("showPanel");
        i0();
    }

    public void e0(int i3) {
        this.currentMaxExpandedHeight = i3;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    /* renamed from: f, reason: from getter */
    public int getExpandedHeight() {
        return this.expandedHeight;
    }

    public final void f0(@Nullable b bVar) {
        this.keyboardIgnoredModeDetector = bVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    /* renamed from: g, reason: from getter */
    public int getStableKeyboardShowHeight() {
        return this.stableKeyboardShowHeight;
    }

    public void g0(int i3) {
        this.stableKeyboardShowHeight = i3;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public int getState() {
        return this.state;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void h(boolean z16) {
        if (z16 == this.isEnableInsetAnimationListener) {
            return;
        }
        if (z16) {
            F();
        } else {
            b0();
        }
        this.isEnableInsetAnimationListener = z16;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void i(@Nullable e.b bVar) {
        this.uiStateUpdater = bVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    /* renamed from: j, reason: from getter */
    public int getCurrentMaxExpandedHeight() {
        return this.currentMaxExpandedHeight;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e
    public void onDestroy() {
        h(false);
        ViewCompat.setOnApplyWindowInsetsListener(this.viewBinding.getRoot(), null);
    }
}
