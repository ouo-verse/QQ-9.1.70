package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.IZplanOutboundAvatar;
import com.tencent.mobileqq.app.face.ZplanAvatarAnimateDrawable;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.utils.ProAvatarLifecycleHolder;
import com.tencent.mobileqq.proavatar.utils.QQProAvatarViewHelper;
import com.tencent.mobileqq.proavatar.utils.UiRunnableHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001{B\u0007\u00a2\u0006\u0004\bx\u0010yJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J@\u0010\u0015\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u001e\u0010\u001f\u001a\u00020\u001e2\u0014\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u001cH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,J\"\u00103\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000101J.\u00104\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,J\u0018\u00105\u001a\u00020\t2\u0006\u00100\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000101J\u0018\u00107\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u0016J\u0010\u00108\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010;\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0001H\u0016J \u0010B\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010?\u001a\u00020>H\u0016J \u0010D\u001a\u00020\t2\u0016\u0010\u001d\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0018\u00010\u001cH\u0016J\n\u0010E\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010H\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000fJ\u0010\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020@H\u0016J\u0010\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020@H\u0016J\b\u0010M\u001a\u00020\u001eH\u0016J\b\u0010N\u001a\u00020\u001eH\u0016J\n\u0010O\u001a\u0004\u0018\u000101H\u0016J\b\u0010P\u001a\u00020\tH\u0017J\u0018\u0010U\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020SH\u0016R\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\"\u0010c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010hR\u0014\u0010l\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010v\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", "Lcom/tencent/mobileqq/app/face/IZplanOutboundAvatar;", "Lcom/tencent/qqnt/avatar/fetch/a;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "k", "j", "Lcom/tencent/qqnt/avatar/layer/d;", "", "curLayer", "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lkotlin/Function0;", "invoke", "t", "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "w", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "layerList", "", "o", "p", "l", "Lcom/tencent/qqnt/avatar/meta/info/a;", DomainData.DOMAIN_NAME, "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, HippyTKDListViewAdapter.X, "context", "headType", "", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "v", "resourceFetchRequest", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.VISIBLE, "restart", "setVisible", "who", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "onResult", "onUpdate", CanvasView.ACTION_RECT, "resourceRect", "u", "hideMaxDuration", "hideZplanAvatar", "animateDuration", "showZplanAvatar", "isShowZplanOutboundAvatar", "isSupportZPlanOutboundAvatar", "getZPlanAvatarBackgroundUrl", "preloadOutboundResource", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "d", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "resourceOrganizer", "e", "Lcom/tencent/qqnt/avatar/fetch/c;", "curRequest", "f", "Lcom/tencent/mobileqq/proavatar/e;", "curConfig", "Ljava/util/concurrent/CopyOnWriteArrayList;", tl.h.F, "Ljava/util/concurrent/CopyOnWriteArrayList;", "resourceLayerList", "i", "Landroid/graphics/Paint;", "bitmapPaint", "Lcom/tencent/mobileqq/proavatar/m;", "Lcom/tencent/mobileqq/proavatar/m;", "zplanOutboundAvatar", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "tag", "Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder;", "D", "Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder;", "lifecycleHolder", "E", "J", "lastTimeLoadWhenDraw", "Lcom/tencent/mobileqq/proavatar/k;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "<init>", "()V", "G", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQProAvatarDrawable extends Drawable implements Drawable.Callback, ResourceOrganizer.a, IZplanOutboundAvatar, com.tencent.qqnt.avatar.fetch.a, LifecycleEventObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static boolean H;

    @NotNull
    private static final Lazy<Boolean> I;

    @NotNull
    private static final Lazy<Boolean> J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ProAvatarLifecycleHolder lifecycleHolder;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastTimeLoadWhenDraw;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final k viewConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResourceOrganizer resourceOrganizer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.fetch.c curRequest;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e curConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.qqnt.avatar.layer.d<? extends Object>> resourceLayerList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint bitmapPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m zplanOutboundAvatar;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarDrawable$a;", "", "", "tag", "Lkotlin/Function0;", "block", "", "b", "", "LOAD_WHEN_DRAW_LIMIT_SWITCH$delegate", "Lkotlin/Lazy;", "d", "()Z", "LOAD_WHEN_DRAW_LIMIT_SWITCH", "DEBUG", "Z", "c", "setDEBUG", "(Z)V", "", "LOAD_WHEN_DRAW_LIMIT_TIME", "J", "", "MAX_HARDWARE_FIND_TIMES", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) QQProAvatarDrawable.J.getValue()).booleanValue();
        }

        public final void b(@NotNull String tag, @NotNull Function0<String> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) block);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(block, "block");
            if (c()) {
                QLog.d(tag, 1, block.invoke());
            }
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QQProAvatarDrawable.H;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/proavatar/QQProAvatarDrawable$b", "Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$AvatarAnimatorListener;", "", "onShowComplete", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements ZplanAvatarAnimateDrawable.AvatarAnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
            }
        }

        @Override // com.tencent.mobileqq.app.face.ZplanAvatarAnimateDrawable.AvatarAnimatorListener
        public void onShowComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQProAvatarDrawable.this.zplanOutboundAvatar = null;
                QQProAvatarDrawable.this.p();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        INSTANCE = new Companion(null);
        H = ProAvatarComponentUtils.j();
        lazy = LazyKt__LazyJVMKt.lazy(QQProAvatarDrawable$Companion$DRAW_REFACTOR_SWITCH$1.INSTANCE);
        I = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QQProAvatarDrawable$Companion$LOAD_WHEN_DRAW_LIMIT_SWITCH$2.INSTANCE);
        J = lazy2;
    }

    public QQProAvatarDrawable() {
        int checkRadix;
        int checkRadix2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ResourceOrganizer resourceOrganizer = new ResourceOrganizer();
        this.resourceOrganizer = resourceOrganizer;
        this.resourceLayerList = new CopyOnWriteArrayList<>();
        Paint paint = new Paint(1);
        this.bitmapPaint = paint;
        int hashCode = hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        String str = "QQProAvatarDrawable_" + num + "]";
        this.tag = str;
        this.lifecycleHolder = new ProAvatarLifecycleHolder();
        this.viewConfig = new k();
        ProAvatarComponentUtils.g();
        paint.setFilterBitmap(true);
        paint.setDither(true);
        int hashCode2 = resourceOrganizer.hashCode();
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
        String num2 = Integer.toString(hashCode2, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
        QLog.d(str, 2, "createInstance. organizer: " + num2);
        resourceOrganizer.t(this);
        resourceOrganizer.v(this);
        if (com.tencent.qqnt.avatar.g.f352801a.v()) {
            resourceOrganizer.s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(final Canvas canvas) {
        final Rect rect;
        Rect rect2;
        Rect rect3;
        final Rect rect4;
        Rect rect5;
        Rect rect6;
        Drawable q16;
        Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x16;
        List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> list;
        INSTANCE.b(this.tag, new Function0<String>(canvas) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Canvas $canvas;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$canvas = canvas;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this, (Object) canvas);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                com.tencent.qqnt.avatar.fetch.c cVar;
                CopyOnWriteArrayList copyOnWriteArrayList;
                com.tencent.qqnt.avatar.meta.b c16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                cVar = QQProAvatarDrawable.this.curRequest;
                String d16 = (cVar == null || (c16 = cVar.c()) == null) ? null : c16.d();
                copyOnWriteArrayList = QQProAvatarDrawable.this.resourceLayerList;
                return "[" + d16 + "] draw: " + copyOnWriteArrayList.size() + ",bounds: " + QQProAvatarDrawable.this.getBounds() + ", canvas: " + this.$canvas;
            }
        });
        if (this.resourceLayerList.isEmpty()) {
            com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
            if (cVar != null && (x16 = this.resourceOrganizer.x(cVar, false)) != null && (r0 = x16.values()) != null && list != null) {
                o(list);
            }
            s();
            if (this.resourceLayerList.isEmpty()) {
                com.tencent.qqnt.avatar.fetch.c cVar2 = this.curRequest;
                if (cVar2 == null || (q16 = cVar2.e()) == null) {
                    q16 = this.resourceOrganizer.q();
                }
                q16.setBounds(getBounds());
                q16.draw(canvas);
                return;
            }
        }
        for (final com.tencent.qqnt.avatar.layer.d<? extends Object> it : this.resourceLayerList) {
            Object d16 = it.d();
            if (d16 instanceof Bitmap) {
                com.tencent.qqnt.avatar.layer.c c16 = it.c();
                if (c16 != null) {
                    rect = c16.b();
                } else {
                    rect = null;
                }
                INSTANCE.b(this.tag, new Function0<String>(it, rect) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                    final /* synthetic */ Rect $rect;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$it = it;
                        this.$rect = rect;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) it, (Object) rect);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        int checkRadix;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        int hashCode = this.$it.d().hashCode();
                        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                        String num = Integer.toString(hashCode, checkRadix);
                        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                        return "draw bitmap[" + num + "] rect: " + this.$rect;
                    }
                });
                if (rect != null && rect.width() > 0 && rect.height() > 0) {
                    com.tencent.qqnt.avatar.layer.c c17 = it.c();
                    if (c17 == null || (rect2 = c17.c()) == null) {
                        Object d17 = it.d();
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type android.graphics.Bitmap");
                        int width = ((Bitmap) d17).getWidth();
                        Object d18 = it.d();
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type android.graphics.Bitmap");
                        rect2 = new Rect(0, 0, width, ((Bitmap) d18).getHeight());
                    }
                    final Rect rect7 = rect2;
                    if (ProAvatarComponentUtils.k()) {
                        rect3 = getBounds();
                    } else {
                        rect3 = rect7;
                    }
                    Intrinsics.checkNotNullExpressionValue(rect3, "if (ProAvatarComponentUt\u2026                        }");
                    if (I.getValue().booleanValue()) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        final Rect rect8 = rect;
                        t(it, canvas, rect3, this.bitmapPaint, new Function0<Unit>(canvas, rect8, rect7, it) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Canvas $canvas;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                            final /* synthetic */ Rect $rect;
                            final /* synthetic */ Rect $resourceRect;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$canvas = canvas;
                                this.$rect = rect8;
                                this.$resourceRect = rect7;
                                this.$it = it;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, QQProAvatarDrawable.this, canvas, rect8, rect7, it);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Paint paint;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                com.tencent.mobileqq.proavatar.utils.a.e(com.tencent.mobileqq.proavatar.utils.a.f259716a, QQProAvatarDrawable.this, 0.0f, 2, null);
                                this.$canvas.save();
                                QQProAvatarDrawable qQProAvatarDrawable = QQProAvatarDrawable.this;
                                Canvas canvas2 = this.$canvas;
                                Rect bounds = qQProAvatarDrawable.getBounds();
                                Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
                                qQProAvatarDrawable.u(canvas2, bounds, this.$rect, this.$resourceRect);
                                Canvas canvas3 = this.$canvas;
                                Object d19 = this.$it.d();
                                Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type android.graphics.Bitmap");
                                Rect bounds2 = QQProAvatarDrawable.this.getBounds();
                                paint = QQProAvatarDrawable.this.bitmapPaint;
                                canvas3.drawBitmap((Bitmap) d19, (Rect) null, bounds2, paint);
                                this.$canvas.restore();
                            }
                        });
                    } else {
                        com.tencent.mobileqq.proavatar.utils.a.e(com.tencent.mobileqq.proavatar.utils.a.f259716a, this, 0.0f, 2, null);
                        canvas.save();
                        Rect bounds = getBounds();
                        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
                        u(canvas, bounds, rect, rect7);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        t(it, canvas, rect3, this.bitmapPaint, new Function0<Unit>(canvas, it, this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$3
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Canvas $canvas;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                            final /* synthetic */ QQProAvatarDrawable this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$canvas = canvas;
                                this.$it = it;
                                this.this$0 = this;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, canvas, it, this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Paint paint;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Canvas canvas2 = this.$canvas;
                                Object d19 = this.$it.d();
                                Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type android.graphics.Bitmap");
                                Rect bounds2 = this.this$0.getBounds();
                                paint = this.this$0.bitmapPaint;
                                canvas2.drawBitmap((Bitmap) d19, (Rect) null, bounds2, paint);
                            }
                        });
                        canvas.restore();
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Rect bounds2 = getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds2, "bounds");
                    t(it, canvas, bounds2, this.bitmapPaint, new Function0<Unit>(canvas, it, this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Canvas $canvas;
                        final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                        final /* synthetic */ QQProAvatarDrawable this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$canvas = canvas;
                            this.$it = it;
                            this.this$0 = this;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, canvas, it, this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Paint paint;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            Canvas canvas2 = this.$canvas;
                            Object d19 = this.$it.d();
                            Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type android.graphics.Bitmap");
                            Rect bounds3 = this.this$0.getBounds();
                            paint = this.this$0.bitmapPaint;
                            canvas2.drawBitmap((Bitmap) d19, (Rect) null, bounds3, paint);
                        }
                    });
                }
            } else if (d16 instanceof Drawable) {
                Object d19 = it.d();
                Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                ((Drawable) d19).setCallback(this);
                Object d26 = it.d();
                Intrinsics.checkNotNull(d26, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                ((Drawable) d26).setBounds(getBounds());
                com.tencent.qqnt.avatar.layer.c c18 = it.c();
                if (c18 != null) {
                    rect4 = c18.b();
                } else {
                    rect4 = null;
                }
                INSTANCE.b(this.tag, new Function0<String>(it, rect4) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                    final /* synthetic */ Rect $rect;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$it = it;
                        this.$rect = rect4;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) it, (Object) rect4);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        int checkRadix;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        int hashCode = this.$it.d().hashCode();
                        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                        String num = Integer.toString(hashCode, checkRadix);
                        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                        return "draw drawable[" + num + "] rect: " + this.$rect;
                    }
                });
                if (rect4 != null && rect4.width() > 0 && rect4.height() > 0) {
                    com.tencent.qqnt.avatar.layer.c c19 = it.c();
                    if (c19 == null || (rect5 = c19.c()) == null) {
                        Object d27 = it.d();
                        Intrinsics.checkNotNull(d27, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        int intrinsicWidth = ((Drawable) d27).getIntrinsicWidth();
                        Object d28 = it.d();
                        Intrinsics.checkNotNull(d28, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        rect5 = new Rect(0, 0, intrinsicWidth, ((Drawable) d28).getIntrinsicHeight());
                    }
                    final Rect rect9 = rect5;
                    if (ProAvatarComponentUtils.k()) {
                        rect6 = getBounds();
                    } else {
                        rect6 = rect9;
                    }
                    Intrinsics.checkNotNullExpressionValue(rect6, "if (ProAvatarComponentUt\u2026                        }");
                    if (I.getValue().booleanValue()) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        final Rect rect10 = rect4;
                        t(it, canvas, rect6, null, new Function0<Unit>(canvas, rect10, rect9, it) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$6
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Canvas $canvas;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                            final /* synthetic */ Rect $rect;
                            final /* synthetic */ Rect $resourceRect;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$canvas = canvas;
                                this.$rect = rect10;
                                this.$resourceRect = rect9;
                                this.$it = it;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, QQProAvatarDrawable.this, canvas, rect10, rect9, it);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                com.tencent.mobileqq.proavatar.utils.a.e(com.tencent.mobileqq.proavatar.utils.a.f259716a, QQProAvatarDrawable.this, 0.0f, 2, null);
                                this.$canvas.save();
                                QQProAvatarDrawable qQProAvatarDrawable = QQProAvatarDrawable.this;
                                Canvas canvas2 = this.$canvas;
                                Rect bounds3 = qQProAvatarDrawable.getBounds();
                                Intrinsics.checkNotNullExpressionValue(bounds3, "bounds");
                                qQProAvatarDrawable.u(canvas2, bounds3, this.$rect, this.$resourceRect);
                                Object d29 = this.$it.d();
                                Intrinsics.checkNotNull(d29, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                                ((Drawable) d29).draw(this.$canvas);
                                this.$canvas.restore();
                            }
                        });
                    } else {
                        com.tencent.mobileqq.proavatar.utils.a.e(com.tencent.mobileqq.proavatar.utils.a.f259716a, this, 0.0f, 2, null);
                        canvas.save();
                        Rect bounds3 = getBounds();
                        Intrinsics.checkNotNullExpressionValue(bounds3, "bounds");
                        u(canvas, bounds3, rect4, rect9);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        t(it, canvas, rect6, null, new Function0<Unit>(it, canvas) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$7
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Canvas $canvas;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$it = it;
                                this.$canvas = canvas;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) it, (Object) canvas);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Object d29 = this.$it.d();
                                Intrinsics.checkNotNull(d29, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                                ((Drawable) d29).draw(this.$canvas);
                            }
                        });
                        canvas.restore();
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Rect bounds4 = getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds4, "bounds");
                    t(it, canvas, bounds4, null, new Function0<Unit>(it, canvas) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doDraw$3$8
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Canvas $canvas;
                        final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$it = it;
                            this.$canvas = canvas;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) it, (Object) canvas);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            Object d29 = this.$it.d();
                            Intrinsics.checkNotNull(d29, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                            ((Drawable) d29).draw(this.$canvas);
                        }
                    });
                }
            }
        }
    }

    private final void k(Canvas canvas) {
        m mVar = this.zplanOutboundAvatar;
        if (mVar != null) {
            mVar.a(canvas);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.view.ViewParent, T] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private final void l() {
        View view;
        final View view2;
        boolean z16;
        Drawable.Callback callback = getCallback();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (callback instanceof View) {
            View view3 = (View) callback;
            if (view3.isHardwareAccelerated()) {
                Object parent = view3.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                } else {
                    view2 = 0;
                }
                Iterator<Integer> it = new IntRange(0, 5).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    final int nextInt = ((IntIterator) it).nextInt();
                    View view4 = (View) view2;
                    if (view4 != null) {
                        view2 = view4.getParent();
                    } else {
                        view2 = 0;
                    }
                    INSTANCE.b(this.tag, new Function0<String>(nextInt, view2) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doInvalidateHardwardLayerView$1$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int $it;
                        final /* synthetic */ ViewParent $viewParent;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$it = nextInt;
                            this.$viewParent = view2;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, nextInt, (Object) view2);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "invalidateCurrentView[" + this.$it + "] viewParent: " + this.$viewParent;
                        }
                    });
                    if (!(view2 instanceof View)) {
                        break;
                    }
                    View view5 = view2;
                    if (!view5.isHardwareAccelerated()) {
                        break;
                    }
                    if (view5.getLayerType() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        objectRef.element = view2;
                        break;
                    }
                }
            }
        }
        INSTANCE.b(this.tag, new Function0<String>(objectRef) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$doInvalidateHardwardLayerView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<View> $hardwareLayerView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$hardwareLayerView = objectRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "invalidateCurrentView viewGroup: " + this.$hardwareLayerView.element;
            }
        });
        Object obj = objectRef.element;
        if (obj != null && (view = (View) obj) != null) {
            view.invalidate();
        }
    }

    private final Context m() {
        View view;
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            view = (View) callback;
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        return view.getContext();
    }

    private final com.tencent.qqnt.avatar.meta.info.a n() {
        Object obj;
        com.tencent.qqnt.avatar.meta.info.a[] a16;
        Object firstOrNull;
        boolean z16;
        if (this.resourceLayerList.isEmpty()) {
            return null;
        }
        Iterator<T> it = this.resourceLayerList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.qqnt.avatar.layer.d) obj).b().b() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.avatar.layer.d dVar = (com.tencent.qqnt.avatar.layer.d) obj;
        if (dVar != null && (a16 = dVar.a()) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(a16);
            return (com.tencent.qqnt.avatar.meta.info.a) firstOrNull;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean o(List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        byte b16;
        com.tencent.qqnt.avatar.meta.b c16;
        String str;
        com.tencent.qqnt.avatar.meta.b c17;
        com.tencent.qqnt.avatar.meta.b c18;
        com.tencent.qqnt.avatar.meta.b c19;
        INSTANCE.b(this.tag, QQProAvatarDrawable$handle$1.INSTANCE);
        if (Intrinsics.areEqual(this.resourceLayerList, layerList)) {
            if (QLog.isDevelopLevel()) {
                QLog.i(this.tag, 4, "onResult but layerList is same. list size: " + this.resourceLayerList.size());
            }
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (final com.tencent.qqnt.avatar.layer.d<? extends Object> dVar : layerList) {
            com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
            if (cVar != null && (c19 = cVar.c()) != null && dVar.b().a() == c19.a()) {
                b16 = true;
            } else {
                b16 = false;
            }
            Integer num = null;
            r8 = null;
            String str2 = null;
            num = null;
            if (b16 == false) {
                if (QLog.isDevelopLevel()) {
                    int a16 = dVar.b().a();
                    com.tencent.qqnt.avatar.fetch.c cVar2 = this.curRequest;
                    if (cVar2 != null && (c16 = cVar2.c()) != null) {
                        num = Integer.valueOf(c16.a());
                    }
                    QLog.e("QQProAvatarDrawable", 1, "handle not same type. " + a16 + ", " + num + ", request: " + this.curRequest);
                }
            } else {
                if (dVar.b().c() != null) {
                    String c26 = dVar.b().c();
                    com.tencent.qqnt.avatar.fetch.c cVar3 = this.curRequest;
                    if (cVar3 != null && (c18 = cVar3.c()) != null) {
                        str = c18.c();
                    } else {
                        str = null;
                    }
                    if (!Intrinsics.areEqual(c26, str)) {
                        if (QLog.isDevelopLevel()) {
                            String c27 = dVar.b().c();
                            com.tencent.qqnt.avatar.fetch.c cVar4 = this.curRequest;
                            if (cVar4 != null && (c17 = cVar4.c()) != null) {
                                str2 = c17.c();
                            }
                            QLog.e("QQProAvatarDrawable", 1, "handle not same id. " + c27 + ", " + str2 + ", request: " + this.curRequest);
                        }
                    }
                }
                Object d16 = dVar.d();
                if (d16 instanceof Bitmap) {
                    final com.tencent.qqnt.avatar.layer.b a17 = QQProAvatarViewHelper.f259708a.a(dVar);
                    if (a17 != null) {
                        arrayList.add(a17);
                        INSTANCE.b(this.tag, new Function0<String>(dVar, a17) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$handle$2$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.b $layer;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$it = dVar;
                                this.$layer = a17;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) a17);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                                }
                                return "onResult bitmap:[" + this.$it.b().b() + "] " + this.$it.d() + ". bitmapDrawable: " + this.$layer.d();
                            }
                        });
                    } else {
                        arrayList.add(dVar);
                        INSTANCE.b(this.tag, new Function0<String>(dVar) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$handle$2$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$it = dVar;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                                }
                                return "onResult bitmap:[" + this.$it.b().b() + "] " + this.$it.d();
                            }
                        });
                    }
                } else if (d16 instanceof Drawable) {
                    arrayList.add(dVar);
                    INSTANCE.b(this.tag, new Function0<String>(dVar) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$handle$2$3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.qqnt.avatar.layer.d<? extends Object> $it;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$it = dVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "onResult drawable:[" + this.$it.b().b() + "] " + this.$it.d();
                        }
                    });
                } else if (d16 instanceof Uri) {
                    QLog.e(this.tag, 1, "onResult unKnown format [" + dVar.d());
                } else {
                    QLog.e(this.tag, 1, "onResult unKnown format [" + dVar.d());
                }
            }
        }
        Companion companion = INSTANCE;
        companion.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$handle$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                copyOnWriteArrayList = QQProAvatarDrawable.this.resourceLayerList;
                return "onResult drawableList: " + copyOnWriteArrayList.size();
            }
        });
        if (!arrayList.isEmpty()) {
            companion.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$handle$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    com.tencent.qqnt.avatar.fetch.c cVar5;
                    com.tencent.qqnt.avatar.meta.b c28;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    cVar5 = QQProAvatarDrawable.this.curRequest;
                    return "onResult [" + ((cVar5 == null || (c28 = cVar5.c()) == null) ? null : c28.d()) + "] cb= " + QQProAvatarDrawable.this.getCallback();
                }
            });
            this.resourceLayerList.clear();
            this.resourceLayerList.addAll(arrayList);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        l();
        invalidateSelf();
    }

    private final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        if (INSTANCE.d()) {
            long j3 = this.lastTimeLoadWhenDraw;
            if (currentTimeMillis > j3 && currentTimeMillis - j3 < 300) {
                return;
            }
        }
        z(m());
        this.lastTimeLoadWhenDraw = currentTimeMillis;
    }

    private final void t(com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer, Canvas canvas, Rect bounds, Paint paint, Function0<Unit> invoke) {
        if (!i.f259610a.b(curLayer, canvas, bounds, paint, this.viewConfig, invoke, new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$maskLayer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQProAvatarDrawable.this.p();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        })) {
            invoke.invoke();
        }
    }

    private final synchronized void w(final com.tencent.qqnt.avatar.fetch.c request) {
        String str;
        if (request != null) {
            INSTANCE.b(this.tag, new Function0<String>(this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$setAvatarRequest$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QQProAvatarDrawable this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.fetch.c.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    com.tencent.qqnt.avatar.fetch.c cVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    String f16 = com.tencent.qqnt.avatar.fetch.c.this.f();
                    cVar = this.this$0.curRequest;
                    return "setRequest: " + f16 + ", cur:" + (cVar != null ? cVar.f() : null);
                }
            });
            com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
            if (cVar != null) {
                str = cVar.f();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, request.f())) {
                this.resourceLayerList.clear();
                this.zplanOutboundAvatar = null;
                this.lastTimeLoadWhenDraw = 0L;
                this.curRequest = request;
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    p();
                } else {
                    UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
                    if (uiRunnableHelper.g()) {
                        uiRunnableHelper.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$setAvatarRequest$$inlined$runOnUiThread$1
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                    QQProAvatarDrawable.this.p();
                                } else {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$setAvatarRequest$$inlined$runOnUiThread$2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                    QQProAvatarDrawable.this.p();
                                } else {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull final Canvas canvas) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            if (this.zplanOutboundAvatar != null) {
                k(canvas);
            } else {
                j(canvas);
            }
            INSTANCE.b(this.tag, new Function0<String>(currentTimeMillis, canvas) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$draw$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Canvas $canvas;
                final /* synthetic */ long $start;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$start = currentTimeMillis;
                    this.$canvas = canvas;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(currentTimeMillis), canvas);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "draw cost: " + (System.currentTimeMillis() - this.$start) + ", canvas: " + this.$canvas;
                }
            });
        } catch (Throwable th5) {
            String str2 = this.tag;
            com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
            if (cVar != null) {
                str = cVar.f();
            } else {
                str = null;
            }
            QLog.e(str2, 1, "draw catch exception. curRequest: " + str, th5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    @Nullable
    public String getZPlanAvatarBackgroundUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        INSTANCE.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$getZPlanAvatarBackgroundUrl$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                m mVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                mVar = QQProAvatarDrawable.this.zplanOutboundAvatar;
                return "getZplanAvatarBackgroundUrl " + (mVar != null ? mVar.b() : null);
            }
        });
        m mVar = this.zplanOutboundAvatar;
        if (mVar != null) {
            return mVar.b();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void hideZplanAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            IZplanOutboundAvatar.DefaultImpls.hideZplanAvatar(this);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) who);
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
        l();
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public boolean isShowZplanOutboundAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        INSTANCE.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$isShowZplanOutboundAvatar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                m mVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                mVar = QQProAvatarDrawable.this.zplanOutboundAvatar;
                return "isShowZplanOutboundAvatar " + (mVar != null);
            }
        });
        if (this.zplanOutboundAvatar != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public boolean isSupportZPlanOutboundAvatar() {
        com.tencent.qqnt.avatar.meta.b c16;
        com.tencent.qqnt.avatar.meta.info.a[] d16;
        Object firstOrNull;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.zplanOutboundAvatar != null) {
            return true;
        }
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null && (c16 = cVar.c()) != null && (d16 = ResourceOrganizer.INSTANCE.d(c16)) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(d16);
            com.tencent.qqnt.avatar.meta.info.a aVar = (com.tencent.qqnt.avatar.meta.info.a) firstOrNull;
            if (aVar != null) {
                Object b16 = aVar.b(FaceConstant.ZPLAN_OUT_BOUND_BG_URL);
                if (b16 instanceof String) {
                    str = (String) b16;
                } else {
                    str = null;
                }
                if (str != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.avatar.core.ResourceOrganizer.a
    public void onResult(@Nullable final List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) layerList);
            return;
        }
        if (layerList != null && (!layerList.isEmpty())) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                o(layerList);
                p();
                return;
            }
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>(layerList) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$onResult$$inlined$runOnUiThread$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ List $layerList$inlined;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$layerList$inlined = layerList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this, (Object) layerList);
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
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQProAvatarDrawable.this.o(this.$layerList$inlined);
                            QQProAvatarDrawable.this.p();
                        }
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(layerList) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$onResult$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f259511d;

                    {
                        this.f259511d = layerList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this, (Object) layerList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQProAvatarDrawable.this.o(this.f259511d);
                            QQProAvatarDrawable.this.p();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.resourceOrganizer.i();
            this.resourceOrganizer.t(null);
            this.resourceOrganizer.v(null);
            source.getLifecycle().removeObserver(this);
            this.lifecycleHolder.d();
            if (ProAvatarLifecycleHolder.INSTANCE.a()) {
                this.curRequest = null;
            }
        }
    }

    @Override // com.tencent.qqnt.avatar.fetch.a
    @Nullable
    public com.tencent.qqnt.avatar.fetch.c onUpdate() {
        com.tencent.qqnt.avatar.meta.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.qqnt.avatar.fetch.c) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        String str = null;
        if (cVar != null) {
            bVar = cVar.c();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            str = bVar.c();
        }
        if (str != null && this.curConfig != null) {
            final com.tencent.qqnt.avatar.fetch.c buildResourceFetchRequest = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(bVar.a(), str, this.curConfig, true);
            INSTANCE.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$onUpdate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.fetch.c.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "onUpdate. newRequest: " + com.tencent.qqnt.avatar.fetch.c.this.f() + ", extendList: " + com.tencent.qqnt.avatar.fetch.c.this.d();
                }
            });
            return buildResourceFetchRequest;
        }
        return this.curRequest;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    @WorkerThread
    public void preloadOutboundResource() {
        String str;
        Integer num;
        int i3;
        boolean z16;
        com.tencent.qqnt.avatar.meta.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        com.tencent.qqnt.avatar.meta.info.a n3 = n();
        if (n3 == null) {
            QLog.e(this.tag, 1, "preloadOutboundResource avatarInfo is null");
            return;
        }
        Object b16 = n3.b(FaceConstant.ZPLAN_OUT_BOUND_BG_URL);
        Integer num2 = null;
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        Object b17 = n3.b(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_CLIP_PERCENT);
        if (b17 instanceof Integer) {
            num = (Integer) b17;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 25;
        }
        int i16 = i3;
        QLog.i(this.tag, 2, "preloadOutboundResource bgUrl: " + str + ", clipPercent: " + i16);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Context m3 = m();
        if (m3 == null) {
            QLog.e(this.tag, 1, "preloadOutboundResource context is null");
            return;
        }
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            bVar = cVar.c();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            QLog.e(this.tag, 1, "preloadOutboundResource bean is null");
            return;
        }
        ResourceOrganizer.Companion companion = ResourceOrganizer.INSTANCE;
        com.tencent.qqnt.avatar.meta.info.a[] d16 = companion.d(bVar);
        if (d16 != null && d16.length == 2) {
            Bitmap[] c16 = companion.c(m3, bVar, d16);
            if (c16 != null && c16.length == 2) {
                Resources resources = m3.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                m mVar = new m(resources, this, c16[0], c16[1], str, i16, false, 64, null);
                mVar.d(new b());
                this.zplanOutboundAvatar = mVar;
                return;
            }
            String str2 = this.tag;
            if (c16 != null) {
                num2 = Integer.valueOf(c16.length);
            }
            QLog.e(str2, 1, "preloadOutboundResource bitmapArr size: " + num2);
            return;
        }
        String str3 = this.tag;
        if (d16 != null) {
            num2 = Integer.valueOf(d16.length);
        }
        QLog.e(str3, 1, "preloadOutboundResource infoArr size: " + num2);
    }

    public final void q(@Nullable Context context, int headType, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(headType), uin);
        } else {
            r(context, headType, uin, null);
        }
    }

    public final void r(@Nullable Context context, int headType, @Nullable String uin, @Nullable e config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, Integer.valueOf(headType), uin, config);
            return;
        }
        if (uin == null || uin.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.e("QQProAvatarDrawable", 1, "loadAvatar uin is null or empty");
        } else {
            this.curConfig = config;
            y(context, ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(headType, uin, config));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, who, what, Long.valueOf(when));
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
        l();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, alpha);
            return;
        }
        Iterator<T> it = this.resourceLayerList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.avatar.layer.d dVar = (com.tencent.qqnt.avatar.layer.d) it.next();
            if (dVar.d() instanceof Drawable) {
                Object d16 = dVar.d();
                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                ((Drawable) d16).setAlpha(alpha);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorFilter);
            return;
        }
        Iterator<T> it = this.resourceLayerList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.avatar.layer.d dVar = (com.tencent.qqnt.avatar.layer.d) it.next();
            if (dVar.d() instanceof Drawable) {
                Object d16 = dVar.d();
                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                ((Drawable) d16).setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(visible), Boolean.valueOf(restart))).booleanValue();
        }
        boolean visible2 = super.setVisible(visible, restart);
        if (!com.tencent.qqnt.avatar.g.f352801a.u() && visible) {
            Drawable.Callback callback = getCallback();
            if (callback instanceof View) {
                view = (View) callback;
            } else {
                view = null;
            }
            if (view != null) {
                this.lifecycleHolder.e(view, this, this.tag);
            }
        }
        return visible2;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void showZplanAvatar(final long animateDuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, animateDuration);
            return;
        }
        INSTANCE.b(this.tag, new Function0<String>(animateDuration) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$showZplanAvatar$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $animateDuration;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$animateDuration = animateDuration;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, animateDuration);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "showZplanAvatar " + this.$animateDuration;
            }
        });
        m mVar = this.zplanOutboundAvatar;
        if (mVar != null) {
            mVar.e(animateDuration);
        }
    }

    public final void u(@NotNull Canvas canvas, @NotNull Rect bounds, @NotNull Rect rect, @NotNull Rect resourceRect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, canvas, bounds, rect, resourceRect);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(resourceRect, "resourceRect");
        canvas.scale(resourceRect.width() / rect.width(), resourceRect.height() / rect.height());
        canvas.translate(-((bounds.width() * (rect.left - resourceRect.left)) / resourceRect.width()), -((bounds.height() * (rect.top - resourceRect.top)) / resourceRect.height()));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) who, (Object) what);
            return;
        }
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    public final void v(int headType, @Nullable String uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, headType, (Object) uin);
            return;
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QQProAvatarDrawable", 1, "loadAvatar uin is null or empty");
        } else {
            w(((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(headType, uin, null));
        }
    }

    public final void x(@Nullable e config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) config);
        } else {
            this.curConfig = config;
        }
    }

    public final synchronized void y(@Nullable Context context, @NotNull final com.tencent.qqnt.avatar.fetch.c resourceFetchRequest) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) resourceFetchRequest);
            return;
        }
        Intrinsics.checkNotNullParameter(resourceFetchRequest, "resourceFetchRequest");
        INSTANCE.b(this.tag, new Function0<String>(resourceFetchRequest) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$setRequestAndStartLoad$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.avatar.fetch.c $resourceFetchRequest;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$resourceFetchRequest = resourceFetchRequest;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this, (Object) resourceFetchRequest);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[" + QQProAvatarDrawable.this.hashCode() + "]setAvatar: " + this.$resourceFetchRequest.f();
            }
        });
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            str = cVar.f();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, resourceFetchRequest.f())) {
            w(resourceFetchRequest);
            z(context);
        } else if (this.resourceLayerList.isEmpty()) {
            z(context);
        }
    }

    public final void z(@Nullable Context context) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            QLog.e(this.tag, 1, "startLoadAvatar error. context is null");
            return;
        }
        INSTANCE.b(this.tag, new Function0<String>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$startLoadAvatar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                com.tencent.qqnt.avatar.fetch.c cVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                cVar = QQProAvatarDrawable.this.curRequest;
                return "startLoad: " + (cVar != null ? cVar.f() : null);
            }
        });
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            this.resourceOrganizer.w(context, cVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(this.tag, 1, "startLoadAvatar error. curRequest is null");
        }
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void hideZplanAvatar(final long hideMaxDuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, hideMaxDuration);
            return;
        }
        INSTANCE.b(this.tag, new Function0<String>(hideMaxDuration) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarDrawable$hideZplanAvatar$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $hideMaxDuration;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$hideMaxDuration = hideMaxDuration;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, hideMaxDuration);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "hideZplanAvatar " + this.$hideMaxDuration;
            }
        });
        m mVar = this.zplanOutboundAvatar;
        if (mVar != null) {
            mVar.c(hideMaxDuration);
        }
    }
}
