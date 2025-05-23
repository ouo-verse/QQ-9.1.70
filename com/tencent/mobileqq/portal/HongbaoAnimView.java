package com.tencent.mobileqq.portal;

import android.animation.TimeAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.AnimConfig;
import com.tencent.mobileqq.springhb.entry.model.AnimConfigData;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.entry.ui.a;
import com.tencent.mobileqq.springhb.entry.worker.DemoteLevel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tenpay.sdk.net.NetParams;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0087\u00012\u00020\u0001:\u0013\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u001c\u008d\u0001$\b\u008e\u0001\u008f\u0001B!\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014R\"\u0010\"\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R0\u00103\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00108R\u0016\u0010;\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001dR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010I\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0014\u0010K\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010DR\u0014\u0010L\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010DR\u0014\u0010N\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010DR\u0014\u0010P\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010DR\u0014\u0010R\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010DR\u0014\u0010T\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010DR\u0014\u0010V\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010DR$\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u00060Wj\b\u0012\u0004\u0012\u00020\u0006`X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010j\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0017\u0010z\u001a\u00020u8\u0006\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0018\u0010\u0080\u0001\u001a\u00020{8\u0006\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\u00a8\u0006\u0090\u0001"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView;", "Landroid/view/View;", "", "t", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$RadishPosition;", DownloaderConstant.KEY_RANGE, "Lcom/tencent/mobileqq/portal/HongbaoAnimView$g;", tl.h.F, "f", "Lcom/tencent/mobileqq/springhb/entry/model/AnimConfig;", "Landroid/util/Size;", "i", "Lkotlin/Function1;", "", "block", "r", "w", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel;", "level", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "v", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "Z", "l", "()Z", "setWaitGift", "(Z)V", "isWaitGift", "<set-?>", "e", "k", "isAnimResume", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnGiftFired", "()Lkotlin/jvm/functions/Function0;", "setOnGiftFired", "(Lkotlin/jvm/functions/Function0;)V", "onGiftFired", "Lkotlin/jvm/functions/Function1;", "getOnAnimEnding", "()Lkotlin/jvm/functions/Function1;", "setOnAnimEnding", "(Lkotlin/jvm/functions/Function1;)V", "onAnimEnding", "Lcom/tencent/mobileqq/springhb/entry/ui/a;", "Lcom/tencent/mobileqq/springhb/entry/ui/a;", "springSysResHelper", "", "J", "lastFiredTimeMillis", BdhLogUtil.LogTag.Tag_Conn, "lastPauseTimeMillis", "D", "isStarting", "Landroid/os/Handler;", "E", "Landroid/os/Handler;", "mHandler", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "line", "G", "cat", "H", "rabbitNormal", "I", "rabbitFast", "starAppear", "K", "starFall", "L", "star", "M", "giftAppear", "N", "giftFall", "P", QCircleDaTongConstant.ElementParamValue.GIFT, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/ArrayList;", "allRadish", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$e;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/portal/HongbaoAnimView$e;", "lineSpring", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$FrameAnimSpirit;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/portal/HongbaoAnimView$FrameAnimSpirit;", "catSpring", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$c;", "T", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$c;", "rabbitSpring", "U", "Landroid/util/Size;", "catImgSize", "V", "rabbitImgSize", "Landroid/graphics/Paint;", "W", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Matrix;", "a0", "Landroid/graphics/Matrix;", "radishMatrix", "Landroid/animation/TimeAnimator;", "b0", "Landroid/animation/TimeAnimator;", "getAnim", "()Landroid/animation/TimeAnimator;", "anim", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$f;", "c0", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$f;", "getAnimListener", "()Lcom/tencent/mobileqq/portal/HongbaoAnimView$f;", "animListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d0", "a", "CatSpirit", "b", "c", "FrameAnimSpirit", "HitLevel", "RadishPosition", "g", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HongbaoAnimView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long lastPauseTimeMillis;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isStarting;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Handler mHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a line;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a cat;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a rabbitNormal;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a rabbitFast;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a starAppear;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a starFall;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a star;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a giftAppear;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a giftFall;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final a.C8605a gift;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<g> allRadish;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private e lineSpring;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final FrameAnimSpirit catSpring;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final c rabbitSpring;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Size catImgSize;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Size rabbitImgSize;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Matrix radishMatrix;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TimeAnimator anim;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f animListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isWaitGift;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimResume;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<Unit> onGiftFired;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> onAnimEnding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.ui.a springSysResHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastFiredTimeMillis;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0012\u0018\u0000 /2\u00020\u0001:\u00010B/\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0011\u0010\u001dR\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0014R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0014R\"\u0010*\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0017\u001a\u0004\b\f\u0010\u0019\"\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$CatSpirit;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$a;", "", "curTime", "", "f", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "c", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "()Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "", "d", UserInfo.SEX_FEMALE, "getStartX", "()F", "startX", "e", "getStartY", "setStartY", "(F)V", "startY", "", "I", "getStartResIndex", "()I", "startResIndex", "g", "Lkotlin/Lazy;", "()J", "startTime", tl.h.F, "getPositionX", "setPositionX", "positionX", "i", "getPositionY", "setPositionY", "positionY", "j", "setResIndex", "(I)V", WadlProxyConsts.RES_INDEX, "Landroid/content/res/Resources;", "res", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;FFI)V", "k", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static class CatSpirit extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a.C8605a imgs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float startX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float startY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int startResIndex;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy startTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float positionX;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private float positionY;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int resIndex;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$CatSpirit$a;", "", "", "ANIM_SELF_DURA", UserInfo.SEX_FEMALE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.portal.HongbaoAnimView$CatSpirit$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59548);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 14)) {
                redirector.redirect((short) 14);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CatSpirit(@NotNull Resources res, @NotNull a.C8605a imgs, float f16, float f17, int i3) {
            super(res);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3));
                return;
            }
            this.imgs = imgs;
            this.startX = f16;
            this.startY = f17;
            this.startResIndex = i3;
            lazy = LazyKt__LazyJVMKt.lazy(HongbaoAnimView$CatSpirit$startTime$2.INSTANCE);
            this.startTime = lazy;
            this.positionX = f16;
            this.positionY = this.startY;
        }

        private final long e() {
            return ((Number) this.startTime.getValue()).longValue();
        }

        @NotNull
        public final a.C8605a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a.C8605a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imgs;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.resIndex;
        }

        public boolean f(long curTime) {
            long coerceAtLeast;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(curTime - e(), 0L);
                if (this.imgs.c() == 0) {
                    this.resIndex = 0;
                    return true;
                }
                int round = Math.round(this.imgs.c() * (((float) coerceAtLeast) / 400.0f));
                this.resIndex = round;
                this.resIndex = round % this.imgs.c();
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, curTime)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b$\u0010!R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0017\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$FrameAnimSpirit;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$a;", "", "curTime", "", "i", "delay", "", tl.h.F, "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "c", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "()Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "", "d", UserInfo.SEX_FEMALE, "getCenterX", "()F", "centerX", "e", "getCenterY", "centerY", "f", "J", "getAnimDuration", "()J", "animDuration", "g", "Lkotlin/Lazy;", "startTime", "endTime", "setPositionX", "(F)V", "positionX", "j", "setPositionY", "positionY", "", "k", "I", "()I", "setResIndex", "(I)V", WadlProxyConsts.RES_INDEX, "Landroid/content/res/Resources;", "res", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;FFJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class FrameAnimSpirit extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a.C8605a imgs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float centerX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float centerY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long animDuration;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy startTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long endTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private float positionX;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private float positionY;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int resIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrameAnimSpirit(@NotNull Resources res, @NotNull a.C8605a imgs, float f16, float f17, long j3) {
            super(res);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3));
                return;
            }
            this.imgs = imgs;
            this.centerX = f16;
            this.centerY = f17;
            this.animDuration = j3;
            lazy = LazyKt__LazyJVMKt.lazy(HongbaoAnimView$FrameAnimSpirit$startTime$2.INSTANCE);
            this.startTime = lazy;
            this.endTime = Long.MAX_VALUE;
            this.positionX = f16;
            this.positionY = f17;
        }

        private final long g() {
            return ((Number) this.startTime.getValue()).longValue();
        }

        @NotNull
        public a.C8605a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a.C8605a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imgs;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.positionX;
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.positionY;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.resIndex;
        }

        public final void h(long delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, delay);
            } else {
                this.endTime = SystemClock.uptimeMillis() + delay;
            }
        }

        public boolean i(long curTime) {
            long coerceAtLeast;
            int roundToInt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, curTime)).booleanValue();
            }
            if (curTime < this.endTime) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(curTime - g(), 0L);
                if (c().c() != 0) {
                    long j3 = this.animDuration;
                    if (j3 != 0) {
                        roundToInt = MathKt__MathJVMKt.roundToInt(c().c() * (((float) coerceAtLeast) / ((float) j3)));
                        this.resIndex = roundToInt;
                        this.resIndex = roundToInt % c().c();
                        return true;
                    }
                }
                this.resIndex = 0;
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel;", "", "", "", "level", "I", "getLevel", "()I", "<init>", "(Ljava/lang/String;II)V", "SLOW", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, NetParams.FAST_CARD, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class HitLevel {
        private static final /* synthetic */ HitLevel[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final HitLevel FAST;
        public static final HitLevel NORMAL;
        public static final HitLevel SLOW;
        private final int level;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel$FAST;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel;", "left", "", "middle", "right", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        static final class FAST extends HitLevel {
            static IPatchRedirector $redirector_;

            FAST(String str, int i3) {
                super(str, i3, 3, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int left() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return 1;
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int middle() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return 1;
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int right() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return 1;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel$NORMAL;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel;", "left", "", "middle", "right", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        static final class NORMAL extends HitLevel {
            static IPatchRedirector $redirector_;

            NORMAL(String str, int i3) {
                super(str, i3, 2, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int left() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return Random.INSTANCE.nextInt(0, 2);
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int middle() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return 1;
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int right() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return Random.INSTANCE.nextInt(0, 2);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel$SLOW;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$HitLevel;", "left", "", "middle", "right", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        static final class SLOW extends HitLevel {
            static IPatchRedirector $redirector_;

            SLOW(String str, int i3) {
                super(str, i3, 1, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int left() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return Random.INSTANCE.nextInt(0, 2);
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int middle() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return 1;
            }

            @Override // com.tencent.mobileqq.portal.HongbaoAnimView.HitLevel
            public int right() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return 0;
            }
        }

        private static final /* synthetic */ HitLevel[] $values() {
            return new HitLevel[]{SLOW, NORMAL, FAST};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59587);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            SLOW = new SLOW("SLOW", 0);
            NORMAL = new NORMAL(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 1);
            FAST = new FAST(NetParams.FAST_CARD, 2);
            $VALUES = $values();
        }

        public /* synthetic */ HitLevel(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }

        public static HitLevel valueOf(String str) {
            return (HitLevel) Enum.valueOf(HitLevel.class, str);
        }

        public static HitLevel[] values() {
            return (HitLevel[]) $VALUES.clone();
        }

        public final int getLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.level;
        }

        public abstract /* synthetic */ int left();

        public abstract /* synthetic */ int middle();

        public abstract /* synthetic */ int right();

        HitLevel(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.level = i16;
            } else {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$RadishPosition;", "", "start", "", "end", CanvasView.ACTION_ROTATE, "", "(Ljava/lang/String;IIIF)V", "getEnd", "()I", "getRotate", "()F", "getStart", "LEFT", "MIDDLE", "RIGHT", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class RadishPosition {
        private static final /* synthetic */ RadishPosition[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RadishPosition LEFT;
        public static final RadishPosition MIDDLE;
        public static final RadishPosition RIGHT;
        private final int end;
        private final float rotate;
        private final int start;

        private static final /* synthetic */ RadishPosition[] $values() {
            return new RadishPosition[]{LEFT, MIDDLE, RIGHT};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59619);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            LEFT = new RadishPosition("LEFT", 0, 10, 15, -15.0f);
            MIDDLE = new RadishPosition("MIDDLE", 1, 44, 66, 0.0f);
            RIGHT = new RadishPosition("RIGHT", 2, 80, 90, 15.0f);
            $VALUES = $values();
        }

        RadishPosition(String str, int i3, int i16, int i17, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16));
                return;
            }
            this.start = i16;
            this.end = i17;
            this.rotate = f16;
        }

        public static RadishPosition valueOf(String str) {
            return (RadishPosition) Enum.valueOf(RadishPosition.class, str);
        }

        public static RadishPosition[] values() {
            return (RadishPosition[]) $VALUES.clone();
        }

        public final int getEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.end;
        }

        public final float getRotate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.rotate;
        }

        public final int getStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.start;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$a;", "", "", "a", UserInfo.SEX_FEMALE, "getBaseScale", "()F", "setBaseScale", "(F)V", "baseScale", "b", "scale", "Landroid/content/res/Resources;", "res", "<init>", "(Landroid/content/res/Resources;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float baseScale;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float scale;

        public a(@NotNull Resources res) {
            Intrinsics.checkNotNullParameter(res, "res");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) res);
            } else {
                this.baseScale = res.getDisplayMetrics().densityDpi / 320.0f;
                this.scale = 1.0f;
            }
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.scale * this.baseScale;
        }

        public final void b(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.scale = f16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$b;", "", "", "MSG_SHOW_NORMAL_RABBIT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.portal.HongbaoAnimView$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$c;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$FrameAnimSpirit;", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "l", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "c", "()Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "j", "(Lcom/tencent/mobileqq/springhb/entry/ui/a$a;)V", "imgs", "Landroid/content/res/Resources;", "res", "", "centerX", "centerY", "", "animDuration", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;FFJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends FrameAnimSpirit {
        static IPatchRedirector $redirector_;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private a.C8605a imgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull Resources res, @NotNull a.C8605a imgs, float f16, float f17, long j3) {
            super(res, imgs, f16, f17, j3);
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3));
            } else {
                this.imgs = imgs;
            }
        }

        @Override // com.tencent.mobileqq.portal.HongbaoAnimView.FrameAnimSpirit
        @NotNull
        public a.C8605a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a.C8605a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imgs;
        }

        public void j(@NotNull a.C8605a c8605a) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) c8605a);
            } else {
                Intrinsics.checkNotNullParameter(c8605a, "<set-?>");
                this.imgs = c8605a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$d;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$g;", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "", "startResIndex", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends g {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Resources res, @NotNull a.C8605a imgs, int i3) {
            super(res, imgs, i3);
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$e;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$CatSpirit;", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "", "startX", "startY", "", "startResIndex", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;FFI)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class e extends CatSpirit {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull Resources res, @NotNull a.C8605a imgs, float f16, float f17, int i3) {
            super(res, imgs, f16, f17, 0);
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$f;", "Landroid/animation/TimeAnimator$TimeListener;", "Landroid/animation/TimeAnimator;", "animation", "", "totalTime", "deltaTime", "", "onTimeUpdate", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView;", "a", "Lmqq/util/WeakReference;", "getViewRef", "()Lmqq/util/WeakReference;", "setViewRef", "(Lmqq/util/WeakReference;)V", "viewRef", "view", "<init>", "(Lcom/tencent/mobileqq/portal/HongbaoAnimView;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements TimeAnimator.TimeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<HongbaoAnimView> viewRef;

        public f(@NotNull HongbaoAnimView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                this.viewRef = new WeakReference<>(view);
            }
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(@Nullable TimeAnimator animation, long totalTime, long deltaTime) {
            HongbaoAnimView hongbaoAnimView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, animation, Long.valueOf(totalTime), Long.valueOf(deltaTime));
                return;
            }
            WeakReference<HongbaoAnimView> weakReference = this.viewRef;
            if (weakReference == null || (hongbaoAnimView = weakReference.get()) == null || !hongbaoAnimView.k()) {
                return;
            }
            hongbaoAnimView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000 \u00052\u00020\u0001:\u0001BB\u001f\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b@\u0010AJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010+\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b\u001a\u0010!\"\u0004\b*\u0010#R\"\u0010-\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b\u001e\u0010!\"\u0004\b,\u0010#R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b%\u0010\u0012\"\u0004\b.\u0010/R\"\u00103\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\"\u00106\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b\t\u0010!\"\u0004\b5\u0010#R\"\u00107\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001f\u001a\u0004\b)\u0010!\"\u0004\b4\u0010#R\"\u0010:\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010!\"\u0004\b8\u0010#R\"\u0010=\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001f\u001a\u0004\b<\u0010!\"\u0004\b;\u0010#\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$g;", "Lcom/tencent/mobileqq/portal/HongbaoAnimView$a;", "", "curTime", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "k", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "c", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "e", "()Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "", "d", "I", "getStartResIndex", "()I", "startResIndex", "J", "j", "()J", "setStartTime", "(J)V", "startTime", "f", "l", "delayTime", "", "g", UserInfo.SEX_FEMALE, "getEndX", "()F", "setEndX", "(F)V", "endX", tl.h.F, "getEndY", "setEndY", "endY", "i", "setPositionX", "positionX", "setPositionY", "positionY", "setResIndex", "(I)V", WadlProxyConsts.RES_INDEX, "getSpeed", DomainData.DOMAIN_NAME, "speed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, CanvasView.ACTION_ROTATE, "o", "getStartX", "startX", "p", "getStartY", "startY", "Landroid/content/res/Resources;", "res", "<init>", "(Landroid/content/res/Resources;Lcom/tencent/mobileqq/springhb/entry/ui/a$a;I)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class g extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: r, reason: collision with root package name */
        @NotNull
        private static final PathInterpolator f259215r;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a.C8605a imgs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int startResIndex;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long delayTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float endX;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float endY;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private float positionX;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private float positionY;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int resIndex;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private float speed;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private float alpha;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private float rotate;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private float startX;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private float startY;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/portal/HongbaoAnimView$g$a;", "", "", "ANIM_APPEAR", UserInfo.SEX_FEMALE, "ANIM_FALL", "ANIM_TOTAL", "Landroid/view/animation/PathInterpolator;", "interpolator", "Landroid/view/animation/PathInterpolator;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.portal.HongbaoAnimView$g$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59635);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 30)) {
                redirector.redirect((short) 30);
            } else {
                INSTANCE = new Companion(null);
                f259215r = new PathInterpolator(0.8f, 0.2f, 0.8f, 0.2f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull Resources res, @NotNull a.C8605a imgs, int i3) {
            super(res);
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, res, imgs, Integer.valueOf(i3));
                return;
            }
            this.imgs = imgs;
            this.startResIndex = i3;
            this.delayTime = Random.INSTANCE.nextLong(0L, 1600L);
            this.endX = 0.5f;
            this.endY = 1.0f;
            this.speed = 1.0f;
            this.alpha = 1.0f;
            k();
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Float) iPatchRedirector.redirect((short) 20, (Object) this)).floatValue();
            }
            return this.alpha;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.delayTime;
        }

        @NotNull
        public final a.C8605a e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a.C8605a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imgs;
        }

        public final float f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.positionX;
        }

        public final float g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
            }
            return this.positionY;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return this.resIndex;
        }

        public final float i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
            }
            return this.rotate;
        }

        public final long j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.startTime;
        }

        public final void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this);
                return;
            }
            this.startTime = SystemClock.uptimeMillis();
            this.delayTime = Random.INSTANCE.nextLong(0L, 2000L);
            this.rotate = r0.nextInt(-150, 150) / 100.0f;
            this.alpha = 1.0f;
        }

        public final void l(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            } else {
                this.delayTime = j3;
            }
        }

        public final void m(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
            } else {
                this.rotate = f16;
            }
        }

        public final void n(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
            } else {
                this.speed = f16;
            }
        }

        public final void o(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, this, Float.valueOf(f16));
            } else {
                this.startX = f16;
            }
        }

        public final void p(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, this, Float.valueOf(f16));
            } else {
                this.startY = f16;
            }
        }

        public final boolean q(long curTime) {
            int roundToInt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, curTime)).booleanValue();
            }
            float f16 = ((float) (curTime - (this.startTime + this.delayTime))) / (1600.0f / this.speed);
            if (this.resIndex >= this.startResIndex - 1) {
                float f17 = (f16 - 0.4375f) * 1.7777778f;
                float f18 = this.startX;
                this.positionX = f18 + ((this.endX - f18) * f17);
                float f19 = this.startY;
                this.positionY = f19 + ((this.endY - f19) * f259215r.getInterpolation(f17));
            } else {
                this.positionY = this.startY;
                this.positionX = this.startX;
            }
            if (this.imgs.c() != 0) {
                roundToInt = MathKt__MathJVMKt.roundToInt(this.imgs.c() * f16 * this.speed);
                this.resIndex = roundToInt;
                this.resIndex = roundToInt % this.imgs.c();
            } else {
                this.resIndex = 0;
            }
            double d16 = f16;
            if (d16 > 1599.5d) {
                this.alpha = (float) (1.0f - ((d16 - 1599.5d) / 0.3f));
            }
            if (this.alpha < 0.0f || d16 > 1.01d) {
                if (this instanceof d) {
                    return false;
                }
                k();
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f259230a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59640);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[HitLevel.values().length];
            try {
                iArr[HitLevel.SLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HitLevel.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HitLevel.FAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f259230a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HongbaoAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        AnimConfig animConfig;
        FrameAnimSpirit frameAnimSpirit;
        c cVar;
        Size i3;
        AnimConfigData animConfigData;
        Size i16;
        AnimConfigData animConfigData2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.isAnimResume = true;
        this.onGiftFired = HongbaoAnimView$onGiftFired$1.INSTANCE;
        this.springSysResHelper = new com.tencent.mobileqq.springhb.entry.ui.a();
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.portal.h
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean e16;
                e16 = HongbaoAnimView.e(HongbaoAnimView.this, message);
                return e16;
            }
        });
        a.C8605a c8605a = new a.C8605a("line");
        this.line = c8605a;
        a.C8605a c8605a2 = new a.C8605a("cat");
        this.cat = c8605a2;
        a.C8605a c8605a3 = new a.C8605a("rabbit_normal");
        this.rabbitNormal = c8605a3;
        this.rabbitFast = new a.C8605a("rabbit_fast");
        this.starAppear = new a.C8605a("star_appear");
        this.starFall = new a.C8605a("star_fall");
        this.star = new a.C8605a("star");
        this.giftAppear = new a.C8605a("gift_appear");
        this.giftFall = new a.C8605a("gift_fall");
        this.gift = new a.C8605a(QCircleDaTongConstant.ElementParamValue.GIFT);
        this.allRadish = new ArrayList<>();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.lineSpring = new e(resources, c8605a, 0.0f, 0.0f, 0);
        this.paint = new Paint();
        this.radishMatrix = new Matrix();
        TimeAnimator timeAnimator = new TimeAnimator();
        this.anim = timeAnimator;
        f fVar = new f(this);
        this.animListener = fVar;
        timeAnimator.setTimeListener(fVar);
        timeAnimator.start();
        OnGrabActivityData a16 = com.tencent.mobileqq.springhb.entry.helper.a.a();
        AnimConfig animConfig2 = null;
        if (a16 != null && (animConfigData2 = a16.animConfigData) != null) {
            animConfig = animConfigData2.getAnimConfig("cat");
        } else {
            animConfig = null;
        }
        if (animConfig != null) {
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            frameAnimSpirit = new FrameAnimSpirit(resources2, c8605a2, animConfig.getCenterX(), animConfig.getCenterY(), animConfig.getAnimDuration());
        } else {
            Resources resources3 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "resources");
            frameAnimSpirit = new FrameAnimSpirit(resources3, c8605a2, 0.5f, 0.3f, 1000L);
        }
        this.catSpring = frameAnimSpirit;
        this.catImgSize = (animConfig == null || (i16 = i(animConfig)) == null) ? new Size(400, 400) : i16;
        if (a16 != null && (animConfigData = a16.animConfigData) != null) {
            animConfig2 = animConfigData.getAnimConfig("rabbit");
        }
        if (animConfig2 != null) {
            Resources resources4 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources4, "resources");
            cVar = new c(resources4, c8605a3, animConfig2.getCenterX(), animConfig2.getCenterY(), animConfig2.getAnimDuration());
        } else {
            Resources resources5 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources5, "resources");
            cVar = new c(resources5, c8605a3, 0.5f, 0.45f, 1000L);
        }
        this.rabbitSpring = cVar;
        this.rabbitImgSize = (animConfig2 == null || (i3 = i(animConfig2)) == null) ? new Size(400, 400) : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(HongbaoAnimView this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.what == 1) {
            this$0.rabbitSpring.j(this$0.rabbitNormal);
        }
        return true;
    }

    private final g f(RadishPosition range) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        d dVar = new d(resources, this.gift, this.giftAppear.c());
        Random.Companion companion = Random.INSTANCE;
        dVar.n(companion.nextInt(80, 120) / 100.0f);
        dVar.p(0.2f);
        dVar.o(companion.nextInt(20, 80) / 100.0f);
        dVar.m(range.getRotate());
        dVar.b(1.0f);
        dVar.l(0L);
        return dVar;
    }

    static /* synthetic */ g g(HongbaoAnimView hongbaoAnimView, RadishPosition radishPosition, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            radishPosition = RadishPosition.MIDDLE;
        }
        return hongbaoAnimView.f(radishPosition);
    }

    private final g h(RadishPosition range) {
        int c16 = this.starAppear.c();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        g gVar = new g(resources, this.star, c16);
        Random.Companion companion = Random.INSTANCE;
        gVar.o(companion.nextInt(range.getStart(), range.getEnd()) / 100.0f);
        gVar.p(companion.nextInt(10, 40) / 100.0f);
        return gVar;
    }

    private final Size i(AnimConfig animConfig) {
        boolean z16;
        float aspectRatio;
        float e16 = ViewUtils.f352270a.e() * animConfig.getWidthRatio();
        if (animConfig.getAspectRatio() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aspectRatio = e16;
        } else {
            aspectRatio = e16 / animConfig.getAspectRatio();
        }
        return new Size((int) e16, (int) aspectRatio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(HongbaoAnimView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isWaitGift) {
            return;
        }
        this$0.onGiftFired.invoke();
        this$0.isWaitGift = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(HongbaoAnimView this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.onAnimEnding;
        if (function1 != null) {
            if (!this$0.isAnimResume && SystemClock.uptimeMillis() - this$0.lastPauseTimeMillis >= 500) {
                z16 = false;
            } else {
                z16 = true;
            }
            function1.invoke(Boolean.valueOf(z16));
        }
        this$0.onAnimEnding = null;
    }

    private final void t() {
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.portal.j
            @Override // java.lang.Runnable
            public final void run() {
                HongbaoAnimView.u(HongbaoAnimView.this);
            }
        });
        baseThread.setPriority(10);
        baseThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(HongbaoAnimView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.springSysResHelper.e(this$0.cat, this$0.catImgSize);
        this$0.springSysResHelper.e(this$0.rabbitNormal, this$0.rabbitImgSize);
        this$0.springSysResHelper.e(this$0.rabbitFast, this$0.rabbitImgSize);
        this$0.springSysResHelper.d(this$0.line);
        this$0.springSysResHelper.d(this$0.starAppear);
        this$0.springSysResHelper.d(this$0.starFall);
        this$0.springSysResHelper.d(this$0.giftAppear);
        this$0.springSysResHelper.d(this$0.giftFall);
        if (com.tencent.mobileqq.springhb.entry.worker.b.f289157a.c() == DemoteLevel.LV3) {
            this$0.gift.b().addAll(this$0.giftFall.b());
            this$0.star.b().addAll(this$0.starFall.b());
        } else {
            this$0.gift.b().addAll(this$0.giftAppear.b());
            this$0.gift.b().addAll(this$0.giftFall.b());
            this$0.star.b().addAll(this$0.starAppear.b());
            this$0.star.b().addAll(this$0.starFall.b());
        }
        ArrayList<g> arrayList = this$0.allRadish;
        RadishPosition radishPosition = RadishPosition.LEFT;
        arrayList.add(this$0.h(radishPosition));
        ArrayList<g> arrayList2 = this$0.allRadish;
        RadishPosition radishPosition2 = RadishPosition.RIGHT;
        arrayList2.add(this$0.h(radishPosition2));
        this$0.allRadish.add(this$0.h(RadishPosition.MIDDLE));
        this$0.allRadish.add(this$0.h(radishPosition2));
        this$0.allRadish.add(this$0.h(radishPosition));
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastFiredTimeMillis < 2000) {
            return;
        }
        this.lastFiredTimeMillis = uptimeMillis;
        this.isWaitGift = true;
        this.allRadish.add(g(this, null, 1, null));
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isAnimResume;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isWaitGift;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.lastPauseTimeMillis = SystemClock.uptimeMillis();
        if (!this.isAnimResume) {
            return;
        }
        this.isAnimResume = false;
        this.isWaitGift = false;
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (this.isAnimResume) {
                return;
            }
            this.isAnimResume = true;
            this.isWaitGift = false;
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.springSysResHelper.b().set(false);
        this.rabbitFast.e();
        this.rabbitNormal.e();
        this.starAppear.e();
        this.starFall.e();
        this.giftAppear.e();
        this.giftFall.e();
        this.anim.cancel();
        this.anim.setTimeListener(null);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        ISpringHbReportApi iSpringHbReportApi;
        Bitmap d16;
        Bitmap d17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.isStarting) {
                e eVar = this.lineSpring;
                if ("rabbit_fast".equals(this.rabbitSpring.c().a()) && eVar.f(uptimeMillis) && (d16 = eVar.c().d(eVar.d())) != null && !d16.isRecycled()) {
                    this.radishMatrix.reset();
                    float width = getWidth() / d16.getWidth();
                    this.radishMatrix.postScale(width, width);
                    this.radishMatrix.postTranslate(0.0f, 0.0f);
                    this.paint.setAlpha(255);
                    canvas.drawBitmap(d16, this.radishMatrix, this.paint);
                }
                FrameAnimSpirit frameAnimSpirit = this.catSpring;
                int width2 = getWidth();
                int height = getHeight();
                if (frameAnimSpirit.i(uptimeMillis) && (d17 = frameAnimSpirit.c().d(frameAnimSpirit.f())) != null && !d17.isRecycled()) {
                    this.radishMatrix.reset();
                    this.radishMatrix.postScale(frameAnimSpirit.a(), frameAnimSpirit.a());
                    this.radishMatrix.postTranslate((width2 * frameAnimSpirit.d()) - ((d17.getWidth() / 2) * frameAnimSpirit.a()), (height * frameAnimSpirit.e()) - ((d17.getHeight() / 2) * frameAnimSpirit.a()));
                    this.paint.setAlpha(255);
                    canvas.drawBitmap(d17, this.radishMatrix, this.paint);
                }
                c cVar = this.rabbitSpring;
                int width3 = getWidth();
                int height2 = getHeight();
                if (cVar.i(uptimeMillis)) {
                    Bitmap d18 = cVar.c().d(cVar.f());
                    if (d18 != null && !d18.isRecycled()) {
                        this.radishMatrix.reset();
                        this.radishMatrix.postScale(cVar.a(), cVar.a());
                        this.radishMatrix.postTranslate((width3 * cVar.d()) - ((d18.getWidth() / 2) * cVar.a()), (height2 * cVar.e()) - ((d18.getHeight() / 2) * cVar.a()));
                        this.paint.setAlpha(255);
                        canvas.drawBitmap(d18, this.radishMatrix, this.paint);
                    }
                } else {
                    setVisibility(8);
                }
            }
            int width4 = getWidth();
            float height3 = getHeight() * this.rabbitSpring.e();
            Iterator<g> it = this.allRadish.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "allRadish.iterator()");
            while (it.hasNext()) {
                g next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                g gVar = next;
                if (uptimeMillis - gVar.j() >= gVar.d()) {
                    if (gVar.q(uptimeMillis)) {
                        Bitmap d19 = gVar.e().d(gVar.h());
                        if (d19 != null && !d19.isRecycled()) {
                            this.radishMatrix.reset();
                            this.radishMatrix.postScale(gVar.a(), gVar.a());
                            float f16 = width4;
                            this.radishMatrix.postTranslate((gVar.f() * f16) - ((d19.getWidth() / 2) * gVar.a()), (gVar.g() * height3) - ((d19.getHeight() / 2) * gVar.a()));
                            this.radishMatrix.postRotate(gVar.i(), f16 * gVar.f(), gVar.g() * height3);
                            if (gVar.c() < 1.0f) {
                                this.paint.setAlpha((int) (gVar.c() * 255));
                            } else {
                                this.paint.setAlpha(255);
                            }
                            canvas.drawBitmap(d19, this.radishMatrix, this.paint);
                        }
                    } else {
                        if ((gVar instanceof d) && this.isWaitGift) {
                            post(new Runnable() { // from class: com.tencent.mobileqq.portal.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HongbaoAnimView.p(HongbaoAnimView.this);
                                }
                            });
                        }
                        it.remove();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("HongbaoAnimView", 1, th5, new Object[0]);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.reportExCatch(109, th5, new String[0]);
            }
        }
    }

    public final void q(@NotNull HitLevel level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) level);
            return;
        }
        Intrinsics.checkNotNullParameter(level, "level");
        this.mHandler.removeMessages(1);
        int i3 = h.f259230a[level.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.rabbitSpring.j(this.rabbitFast);
                    this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            }
            this.rabbitSpring.j(this.rabbitNormal);
            return;
        }
        this.rabbitSpring.j(this.rabbitNormal);
    }

    public final void r(@NotNull Function1<? super Boolean, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.onAnimEnding != null) {
            return;
        }
        this.onAnimEnding = block;
        this.catSpring.h(500L);
        this.rabbitSpring.h(500L);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.portal.k
            @Override // java.lang.Runnable
            public final void run() {
                HongbaoAnimView.s(HongbaoAnimView.this);
            }
        }, 3000L);
    }

    public final void setOnAnimEnding(@Nullable Function1<? super Boolean, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) function1);
        } else {
            this.onAnimEnding = function1;
        }
    }

    public final void setOnGiftFired(@NotNull Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) function0);
        } else {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onGiftFired = function0;
        }
    }

    public final void setWaitGift(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isWaitGift = z16;
        }
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            t();
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.isStarting = true;
        }
    }
}
