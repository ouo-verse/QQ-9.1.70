package com.tencent.qqnt.aio.anisticker.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.aio.anisticker.view.e;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001mB\u0013\b\u0016\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u00a2\u0006\u0004\bf\u0010gB\u001d\b\u0016\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u00a2\u0006\u0004\bf\u0010jB%\b\u0016\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u0012\u0006\u0010k\u001a\u00020$\u00a2\u0006\u0004\bf\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0007J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\u0010\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0010H\u0014J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\"\u0010&\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\u0002J\u0006\u0010(\u001a\u00020\u0002R\"\u0010/\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00109\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010E\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R(\u0010J\u001a\u0004\u0018\u00010\u00102\b\u0010F\u001a\u0004\u0018\u00010\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bC\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010*R$\u0010N\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00104\u001a\u0004\b;\u00106\"\u0004\bM\u00108R\"\u0010S\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u00100\u001a\u0004\bK\u0010P\"\u0004\bQ\u0010RR$\u0010V\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u00104\u001a\u0004\bO\u00106\"\u0004\bU\u00108R$\u0010X\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00104\u001a\u0004\bT\u00106\"\u0004\bW\u00108R\"\u0010Z\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00100\u001a\u0004\bB\u0010P\"\u0004\bY\u0010RR\u0016\u0010[\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010*R\u0016\u0010]\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010^R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010^R\u0016\u0010_\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010*R\u0014\u0010a\u001a\u00020$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010PR\u0011\u0010b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\bb\u0010,R\u0011\u0010c\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\\\u0010,\u00a8\u0006n"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "D", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "lottieDrawable", "T", "pauseAnimation", "clearLoadingDrawable", "cancelAnimation", "resumeAnimation", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "secondLottieDrawable", "B", "enableOrDisableHardwareLayer", "clearLottieDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "setLoadingDrawable", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "aniStickerLottieView", BdhLogUtil.LogTag.Tag_Conn, "reDraw", "dr", "", "verifyDrawable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QZoneJsConstants.METHOD_PLAY, BdhLogUtil.LogTag.Tag_Req, "onDraw", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "stickerInfo", "", "repeatCount", "setSecondLottieDrawable", "clearSecondLottieDrawable", ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "M", "()Z", "setShowLastFrame", "(Z)V", "showLastFrame", "I", "setPlayFrameFinish", "playFrameFinish", "", "Ljava/lang/String;", "O", "()Ljava/lang/String;", "setSurpriseId", "(Ljava/lang/String;)V", "surpriseId", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "E", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "L", "()Lcom/tencent/qqnt/aio/anisticker/view/a;", "setSecondRandomResultPlayListener", "(Lcom/tencent/qqnt/aio/anisticker/view/a;)V", "secondRandomResultPlayListener", UserInfo.SEX_FEMALE, "G", "setDefaultRandomResultPlayListener", "defaultRandomResultPlayListener", "<set-?>", "Landroid/graphics/drawable/Drawable;", "N", "()Landroid/graphics/drawable/Drawable;", "stickerLoadingDrawable", "H", "isInPendingAction", "setCacheKey", "cacheKey", "J", "()I", "setLocalId", "(I)V", "localId", "K", "setRandomKey", "randomKey", "setResultId", "resultId", "setDefaultLoadingRes", "defaultLoadingRes", "wasAnimatingWhenDetached", "P", "wasDetached", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", UIJsPlugin.EVENT_SHOW_LOADING, "getFrame", AIInput.KEY_FRAME, "isAnimating", "isEnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AniStickerLottieView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final ArrayList<WeakReference<AniStickerLottieView>> U;
    private static boolean V;

    @Nullable
    private static HashSet<String> W;

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, String> f348840a0;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean playFrameFinish;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String surpriseId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private a secondRandomResultPlayListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a defaultRandomResultPlayListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Drawable stickerLoadingDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isInPendingAction;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String cacheKey;

    /* renamed from: J, reason: from kotlin metadata */
    private int localId;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String randomKey;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String resultId;

    /* renamed from: M, reason: from kotlin metadata */
    private int defaultLoadingRes;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean wasAnimatingWhenDetached;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean wasDetached;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.anisticker.drawable.f secondLottieDrawable;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean showLoading;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showLastFrame;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006R$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R*\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView$a;", "", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "lottieView", "", "d", "", "resultId", "", "g", "e", "f", "cacheKey", "b", "a", tl.h.F, "<set-?>", "isAllPause", "Z", "c", "()Z", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "PENDING_ACTIONS", "Ljava/util/ArrayList;", "", "PENDING_ACTION_CAPACITY", "I", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "sRandomMapResult", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sReloadCacheKeySet", "Ljava/util/HashSet;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) defaultConstructorMarker);
        }

        private final boolean d(AniStickerLottieView lottieView) {
            if (lottieView != null && !TextUtils.isEmpty(lottieView.K()) && (lottieView.I() || lottieView.M())) {
                return true;
            }
            return false;
        }

        public final synchronized void a(@NotNull String cacheKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) cacheKey);
                return;
            }
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            if (AniStickerLottieView.W == null) {
                AniStickerLottieView.W = new HashSet();
            }
            HashSet hashSet = AniStickerLottieView.W;
            Intrinsics.checkNotNull(hashSet);
            hashSet.add(cacheKey);
        }

        public final boolean b(@Nullable AniStickerLottieView lottieView, @Nullable String cacheKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) lottieView, (Object) cacheKey)).booleanValue();
            }
            if (lottieView == null || lottieView.P() || cacheKey == null || !TextUtils.isEmpty(lottieView.O()) || ((!TextUtils.isEmpty(lottieView.K()) && !d(lottieView)) || Build.VERSION.SDK_INT >= 26)) {
                return false;
            }
            lottieView.setCacheKey(cacheKey);
            lottieView.showLoading = true;
            lottieView.isInPendingAction = false;
            a(cacheKey);
            lottieView.C(lottieView);
            return true;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AniStickerLottieView.V;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                AniStickerLottieView.V = true;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        public final synchronized void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            QLog.d("AniStickerLottieView", 2, "resumeAll.");
            AniStickerLottieView.V = false;
            if (AniStickerLottieView.W != null) {
                HashSet hashSet = AniStickerLottieView.W;
                Intrinsics.checkNotNull(hashSet);
                if (!hashSet.isEmpty()) {
                    HashSet hashSet2 = AniStickerLottieView.W;
                    Intrinsics.checkNotNull(hashSet2);
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "sReloadCacheKeySet!!");
                        String str = (String) next;
                        h(str);
                        if (QLog.isColorLevel()) {
                            QLog.d("AniStickerLottieView", 2, "startReloadDrawable cacheKey : " + str);
                        }
                    }
                    HashSet hashSet3 = AniStickerLottieView.W;
                    Intrinsics.checkNotNull(hashSet3);
                    hashSet3.clear();
                }
            }
            int size = AniStickerLottieView.U.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    AniStickerLottieView aniStickerLottieView = (AniStickerLottieView) ((WeakReference) AniStickerLottieView.U.get(size)).get();
                    if (aniStickerLottieView == null) {
                        AniStickerLottieView.U.remove(size);
                    } else if (aniStickerLottieView.P()) {
                        AniStickerLottieView.U.remove(size);
                        if (!aniStickerLottieView.wasDetached) {
                            aniStickerLottieView.reDraw();
                        }
                    }
                    if (i3 < 0) {
                        break;
                    } else {
                        size = i3;
                    }
                }
            }
        }

        public final void g(@Nullable AniStickerLottieView lottieView, @NotNull String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) lottieView, (Object) resultId);
                return;
            }
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            if (lottieView != null) {
                ConcurrentHashMap concurrentHashMap = AniStickerLottieView.f348840a0;
                String J = lottieView.J();
                Intrinsics.checkNotNull(J);
                concurrentHashMap.put(J, resultId);
                return;
            }
            QLog.e("AniStickerLottieView", 2, "setAniStickerRandomResult lottieView is null.");
        }

        public final synchronized void h(@Nullable String cacheKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) cacheKey);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerLottieView", 2, "startReloadDrawable : " + cacheKey);
            }
            if (cacheKey == null) {
                return;
            }
            if (c()) {
                a(cacheKey);
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerLottieView", 2, "addReloadCacheKey cacheKey : " + cacheKey);
                }
                return;
            }
            int size = AniStickerLottieView.U.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    AniStickerLottieView aniStickerLottieView = (AniStickerLottieView) ((WeakReference) AniStickerLottieView.U.get(size)).get();
                    if (aniStickerLottieView == null) {
                        AniStickerLottieView.U.remove(size);
                    } else if (aniStickerLottieView.P() && Intrinsics.areEqual(cacheKey, aniStickerLottieView.E())) {
                        AniStickerLottieView.U.remove(size);
                        if (QLog.isColorLevel()) {
                            QLog.d("AniStickerLottieView", 2, "startReloadDrawable key: " + cacheKey);
                        }
                        aniStickerLottieView.isInPendingAction = false;
                        if (d(aniStickerLottieView)) {
                            e.f348849a.m(new e.a(aniStickerLottieView).r(aniStickerLottieView.H()).s(aniStickerLottieView.F()).w(aniStickerLottieView.K()).a());
                        } else {
                            e.f348849a.r(new e.a(aniStickerLottieView).r(aniStickerLottieView.H()).s(aniStickerLottieView.F()).y(aniStickerLottieView.showLoading).a());
                        }
                    }
                    if (i3 < 0) {
                        break;
                    } else {
                        size = i3;
                    }
                }
            }
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/AniStickerLottieView$b", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "", "repeatedCount", "", "a", "", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.aio.anisticker.drawable.g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AniStickerLottieView.this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void a(int repeatedCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, repeatedCount);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                AniStickerLottieView.this.Q();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStop(boolean endAnimation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, endAnimation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/AniStickerLottieView$c", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "", "onStart", "", "repeatedCount", "a", "", "endAnimation", DKHippyEvent.EVENT_STOP, "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.qqnt.aio.anisticker.drawable.g {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.anisticker.drawable.f f348844b;

        c(com.tencent.qqnt.aio.anisticker.drawable.f fVar) {
            this.f348844b = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AniStickerLottieView.this, (Object) fVar);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void a(int repeatedCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, repeatedCount);
                return;
            }
            if (TextUtils.isEmpty(AniStickerLottieView.this.O()) && AniStickerLottieView.this.J() != null && AniStickerLottieView.f348840a0.containsKey(AniStickerLottieView.this.J()) && AniStickerLottieView.this.secondLottieDrawable != null) {
                this.f348844b.stop();
                TypeIntrinsics.asMutableMap(AniStickerLottieView.f348840a0).remove(AniStickerLottieView.this.J());
                AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                com.tencent.qqnt.aio.anisticker.drawable.f fVar = aniStickerLottieView.secondLottieDrawable;
                Intrinsics.checkNotNull(fVar);
                aniStickerLottieView.B(fVar);
                AniStickerLottieView aniStickerLottieView2 = AniStickerLottieView.this;
                com.tencent.qqnt.aio.anisticker.drawable.f fVar2 = aniStickerLottieView2.secondLottieDrawable;
                Intrinsics.checkNotNull(fVar2);
                aniStickerLottieView2.R(fVar2);
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerLottieView", 2, "play second LottieAnimation: ", Integer.valueOf(AniStickerLottieView.this.H()), " randomKey:", AniStickerLottieView.this.J());
                }
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerLottieView", 2, "on start playing, hide loading drawable, localId=" + AniStickerLottieView.this.H() + ", randomKey:" + AniStickerLottieView.this.J());
            }
            a G = AniStickerLottieView.this.G();
            if (G != null) {
                G.onAnimationStart(AniStickerLottieView.this.H(), AniStickerLottieView.this.K());
            }
            AniStickerLottieView.this.Q();
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStop(boolean endAnimation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, endAnimation);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerLottieView", 2, "def onAnimationEnd. ");
            }
            a G = AniStickerLottieView.this.G();
            if (G != null) {
                G.onAnimationEnd(AniStickerLottieView.this.H(), AniStickerLottieView.this.K());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/AniStickerLottieView$d", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "", "repeatedCount", "", "a", "", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements com.tencent.qqnt.aio.anisticker.drawable.g {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AniStickerLottieView.this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void a(int repeatedCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, repeatedCount);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            a L = AniStickerLottieView.this.L();
            if (L != null) {
                L.onAnimationStart(AniStickerLottieView.this.H(), AniStickerLottieView.this.K());
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStop(boolean endAnimation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, endAnimation);
                return;
            }
            if (endAnimation) {
                AniStickerLottieView.this.setPlayFrameFinish(true);
                a L = AniStickerLottieView.this.L();
                if (L != null) {
                    L.onAnimationEnd(AniStickerLottieView.this.H(), AniStickerLottieView.this.K());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
            return;
        }
        INSTANCE = new Companion(null);
        U = new ArrayList<WeakReference<AniStickerLottieView>>() { // from class: com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView$Companion$PENDING_ACTIONS$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            private final void d() {
                if (size() > 30) {
                    removeRange(0, (r0 - 30) - 1);
                }
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean contains(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
                }
                if (obj instanceof WeakReference) {
                    return contains((WeakReference<AniStickerLottieView>) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
                }
                return super.size();
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, obj)).intValue();
                }
                if (obj instanceof WeakReference) {
                    return indexOf((WeakReference<AniStickerLottieView>) obj);
                }
                return -1;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, obj)).intValue();
                }
                if (obj instanceof WeakReference) {
                    return lastIndexOf((WeakReference<AniStickerLottieView>) obj);
                }
                return -1;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ WeakReference<AniStickerLottieView> remove(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? removeAt(i3) : (WeakReference) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }

            public /* bridge */ WeakReference<AniStickerLottieView> removeAt(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (WeakReference) iPatchRedirector.redirect((short) 7, (Object) this, i3);
                }
                return (WeakReference) super.remove(i3);
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ int size() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
                }
                return getSize();
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(@NotNull WeakReference<AniStickerLottieView> o16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) o16)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(o16, "o");
                boolean add = super.add((AniStickerLottieView$Companion$PENDING_ACTIONS$1) o16);
                d();
                return add;
            }

            public /* bridge */ boolean contains(WeakReference<AniStickerLottieView> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? super.contains((Object) weakReference) : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) weakReference)).booleanValue();
            }

            public /* bridge */ int indexOf(WeakReference<AniStickerLottieView> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? super.indexOf((Object) weakReference) : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) weakReference)).intValue();
            }

            public /* bridge */ int lastIndexOf(WeakReference<AniStickerLottieView> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? super.lastIndexOf((Object) weakReference) : ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) weakReference)).intValue();
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean remove(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
                }
                if (obj instanceof WeakReference) {
                    return remove((WeakReference<AniStickerLottieView>) obj);
                }
                return false;
            }

            public /* bridge */ boolean remove(WeakReference<AniStickerLottieView> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? super.remove((Object) weakReference) : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference)).booleanValue();
            }
        };
        f348840a0 = new ConcurrentHashMap<>(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniStickerLottieView(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
        } else {
            this.localId = -1;
            this.defaultLoadingRes = R.drawable.c0i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(com.tencent.qqnt.aio.anisticker.drawable.f secondLottieDrawable) {
        secondLottieDrawable.g(new d());
    }

    private final void D() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException("method should be called in main thread");
        QLog.i("AniStickerLottieView", 1, "[checkIsMainThread] fail, stack=" + QLog.getStackTraceString(runtimeException));
        if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
        } else {
            throw runtimeException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        clearLoadingDrawable();
    }

    @MainThread
    private final void T(com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable) {
        Drawable drawable;
        D();
        if (lottieDrawable != null) {
            drawable = lottieDrawable.getDrawable();
        } else {
            drawable = null;
        }
        if (lottieDrawable != null) {
            if (!Intrinsics.areEqual(this.lottieDrawable, lottieDrawable)) {
                clearLottieDrawable();
            }
            this.lottieDrawable = lottieDrawable;
        }
        super.setImageDrawable(drawable);
    }

    private final void cancelAnimation() {
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            this.wasAnimatingWhenDetached = false;
            Intrinsics.checkNotNull(fVar);
            fVar.stop();
        }
    }

    private final void clearLoadingDrawable() {
        this.stickerLoadingDrawable = null;
    }

    @SuppressLint({"RestrictedApi"})
    private final void enableOrDisableHardwareLayer() {
        boolean z16;
        if (this.lottieDrawable == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("AniStickerLottieView", 2, "enableOrDisableHardwareLayer useHardwareLayer: " + z16);
    }

    private final int getFrame() {
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            return fVar.d();
        }
        return 0;
    }

    private final void pauseAnimation() {
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.stop();
        }
    }

    private final void resumeAnimation() {
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.start();
        }
    }

    public final void A(@NotNull com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) lottieDrawable);
            return;
        }
        Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
        if (this.randomKey != null && !this.showLastFrame) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(this.surpriseId);
        if (!z16 && !isEmpty) {
            if (QLog.isColorLevel()) {
                QLog.i("AniStickerLottieView", 2, "addPreAnimatorListener do nothing");
            }
            lottieDrawable.g(new b());
            return;
        }
        lottieDrawable.g(new c(lottieDrawable));
    }

    public final void C(@Nullable AniStickerLottieView aniStickerLottieView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) aniStickerLottieView);
            return;
        }
        if (aniStickerLottieView != null && !this.isInPendingAction) {
            int size = U.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (U.get(size).get() == aniStickerLottieView) {
                        return;
                    }
                    if (i3 < 0) {
                        break;
                    } else {
                        size = i3;
                    }
                }
            }
            U.add(new WeakReference<>(aniStickerLottieView));
            this.isInPendingAction = true;
        }
    }

    @Nullable
    public final String E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.cacheKey;
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.defaultLoadingRes;
    }

    @Nullable
    public final a G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.defaultRandomResultPlayListener;
    }

    public final int H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.localId;
    }

    public final boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.playFrameFinish;
    }

    @Nullable
    public final String J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.randomKey;
    }

    @Nullable
    public final String K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.resultId;
    }

    @Nullable
    public final a L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.secondRandomResultPlayListener;
    }

    public final boolean M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.showLastFrame;
    }

    @Nullable
    public final Drawable N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.stickerLoadingDrawable;
    }

    @Nullable
    public final String O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.surpriseId;
    }

    public final boolean P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (V && this.surpriseId == null) {
            return false;
        }
        return true;
    }

    public final void R(@NotNull com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) lottieDrawable);
            return;
        }
        Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
        long currentTimeMillis = System.currentTimeMillis();
        enableOrDisableHardwareLayer();
        this.showLoading = false;
        T(lottieDrawable);
        this.isInPendingAction = false;
        if (this.showLastFrame) {
            lottieDrawable.a(lottieDrawable.f() - 1);
            playAnimation();
        } else if (!P()) {
            C(this);
        } else {
            playAnimation();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AniStickerLottieView", 2, "playLottieAnimation cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        clearLottieDrawable();
        clearSecondLottieDrawable();
        T(null);
    }

    @MainThread
    public final void clearLottieDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        D();
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            fVar.recycle();
            fVar.e(null);
        }
        this.lottieDrawable = null;
    }

    public final void clearSecondLottieDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.secondLottieDrawable;
        if (fVar != null && this.lottieDrawable != fVar) {
            Intrinsics.checkNotNull(fVar);
            fVar.recycle();
            com.tencent.qqnt.aio.anisticker.drawable.f fVar2 = this.secondLottieDrawable;
            Intrinsics.checkNotNull(fVar2);
            fVar2.e(null);
            this.secondLottieDrawable = null;
        }
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.stickerLoadingDrawable;
        if (drawable != null) {
            if (getLayerType() != 1 && Build.VERSION.SDK_INT < 28) {
                setLayerType(1, null);
                return;
            } else {
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.draw(canvas);
            }
        }
        super.draw(canvas);
        if (!P() && this.lottieDrawable != null && getFrame() >= 1) {
            pauseAnimation();
            C(this);
        }
    }

    public final boolean isAnimating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            return fVar.isRunning();
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        com.tencent.qqnt.aio.anisticker.drawable.f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.wasDetached = false;
        if (!isInEditMode() && (fVar = this.lottieDrawable) != null && this.wasAnimatingWhenDetached) {
            Intrinsics.checkNotNull(fVar);
            if (!fVar.isRunning()) {
                com.tencent.qqnt.aio.anisticker.drawable.f fVar2 = this.lottieDrawable;
                Intrinsics.checkNotNull(fVar2);
                fVar2.start();
            }
            this.wasAnimatingWhenDetached = false;
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerLottieView", 2, "onAttachedToWindow playAnimation : " + this.localId);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerLottieView", 2, "onDetachedFromWindow cancelAnimation : " + this.localId);
            }
        }
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).isFinishing()) {
                clearLottieDrawable();
                clearSecondLottieDrawable();
                clearLoadingDrawable();
                this.localId = -1;
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerLottieView", 2, "onDetachedFromWindow clear res.");
                }
            }
        }
        this.wasDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (QQSysFaceSwitcher.f204652a.f() && !FontSettingManager.isFontSizeNormal() && ((i3 = Build.VERSION.SDK_INT) == 24 || i3 == 25)) {
            int density = canvas.getDensity();
            canvas.setDensity(0);
            try {
                super.onDraw(canvas);
                return;
            } finally {
                canvas.setDensity(density);
            }
        }
        super.onDraw(canvas);
    }

    public final void playAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.anisticker.drawable.f fVar = this.lottieDrawable;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.start();
        }
    }

    public final void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        this.isInPendingAction = false;
        if (!this.showLastFrame && !this.playFrameFinish && TextUtils.isEmpty(this.surpriseId)) {
            if (!isAnimating()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerLottieView", 2, "resumeAnimation");
                }
                resumeAnimation();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AniStickerLottieView", 2, "reDraw return, showLastFrame:" + this.showLastFrame + " playFrameFinish:" + this.playFrameFinish + " surpriseId:" + this.surpriseId);
        }
    }

    public final void setCacheKey(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.cacheKey = str;
        }
    }

    public final void setDefaultLoadingRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.defaultLoadingRes = i3;
        }
    }

    public final void setDefaultRandomResultPlayListener(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        } else {
            this.defaultRandomResultPlayListener = aVar;
        }
    }

    public final void setLoadingDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) drawable);
        } else {
            D();
            this.stickerLoadingDrawable = drawable;
        }
    }

    public final void setLocalId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.localId = i3;
        }
    }

    public final void setPlayFrameFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.playFrameFinish = z16;
        }
    }

    public final void setRandomKey(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.randomKey = str;
        }
    }

    public final void setResultId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.resultId = str;
        }
    }

    public final void setSecondLottieDrawable(@Nullable AniStickerInfo stickerInfo, @Nullable com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable, int repeatCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, stickerInfo, lottieDrawable, Integer.valueOf(repeatCount));
            return;
        }
        if (stickerInfo == null) {
            return;
        }
        if (lottieDrawable != null) {
            if (this.secondLottieDrawable == lottieDrawable) {
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerLottieView", 2, "secondLottieDrawable composition can reuse");
                    return;
                }
                return;
            }
            clearSecondLottieDrawable();
            lottieDrawable.h(repeatCount);
            lottieDrawable.c(true);
            if (e.f348849a.j(this, stickerInfo)) {
                QLog.d("AniStickerLottieView", 2, "view load other res. id: " + stickerInfo.localId);
                return;
            }
            this.secondLottieDrawable = lottieDrawable;
            return;
        }
        QLog.e("AniStickerLottieView", 2, "lottie composition is null. ");
    }

    public final void setSecondRandomResultPlayListener(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.secondRandomResultPlayListener = aVar;
        }
    }

    public final void setShowLastFrame(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.showLastFrame = z16;
        }
    }

    public final void setSurpriseId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.surpriseId = str;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(@NotNull Drawable dr5) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) dr5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dr5, "dr");
        if (!super.verifyDrawable(dr5) && ((drawable = this.stickerLoadingDrawable) == null || dr5 != drawable)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniStickerLottieView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.localId = -1;
            this.defaultLoadingRes = R.drawable.c0i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniStickerLottieView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.localId = -1;
            this.defaultLoadingRes = R.drawable.c0i;
        }
    }
}
