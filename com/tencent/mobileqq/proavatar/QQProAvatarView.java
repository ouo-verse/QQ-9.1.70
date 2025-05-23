package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.proavatar.utils.ProAvatarLifecycleHolder;
import com.tencent.mobileqq.proavatar.utils.UiRunnableHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import com.tencent.qqnt.avatar.meta.b;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0095\u0001\u0096\u0001B7\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\t\b\u0003\u0010\u008e\u0001\u001a\u00020\u0016\u0012\t\b\u0003\u0010\u008f\u0001\u001a\u00020\u0016\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001B,\b\u0016\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\t\b\u0001\u0010\u008e\u0001\u001a\u00020\u0016\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0092\u0001B#\b\u0016\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0093\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u001e\u0010\u0015\u001a\u00020\r2\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u0011H\u0003J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!J\u0010\u0010%\u001a\u00020\r2\b\b\u0001\u0010$\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020&J\u0018\u0010+\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010)J$\u0010.\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,J\u0016\u0010/\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0007J\u0010\u00103\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010)J\u000e\u00104\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00106\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0016J\u0018\u00109\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0014J\b\u0010:\u001a\u0004\u0018\u00010\tJ\u0006\u0010;\u001a\u00020\u0016J\b\u0010<\u001a\u0004\u0018\u00010,J\u0006\u0010=\u001a\u00020)J\u0006\u0010>\u001a\u00020\rJ\u0010\u0010@\u001a\u00020\r2\b\b\u0001\u0010?\u001a\u00020\u0016J\u000e\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u000bJ\u000e\u0010C\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u000bJ\u001a\u0010C\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u00162\b\b\u0002\u0010E\u001a\u00020\u0016J\u000e\u0010G\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u000bJ\u000e\u0010I\u001a\u00020\r2\u0006\u0010H\u001a\u00020\u000bJ \u0010J\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\u0018\u00010\u0011H\u0016J\n\u0010K\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010P\u001a\u00020\r2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0016J\b\u0010Q\u001a\u00020\rH\u0014J\b\u0010R\u001a\u00020\rH\u0014J\u0010\u0010T\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u000bH\u0016J\b\u0010U\u001a\u0004\u0018\u00010)J\u000e\u0010X\u001a\u00020\r2\u0006\u0010W\u001a\u00020VR\u0016\u0010[\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010]R\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010jR\u0016\u0010l\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010ZR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\"\u0010w\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010ZR\"\u0010}\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\"\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0\u007f0~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bZ\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer$a;", "Lcom/tencent/qqnt/avatar/fetch/a;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/mobileqq/proavatar/bean/ZPlanOutboundAvatarInfo;", "avatarInfo", "Lcom/tencent/qqnt/avatar/meta/b;", "j", "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "", "forceSync", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/qqnt/avatar/layer/d;", "", "layerList", "l", "", "index", "Lcom/tencent/mobileqq/proavatar/QQProAvatarLayerImageView;", "t", "imageView", "u", "size", "v", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setImageBitmap", "resId", "setImageResource", "Landroid/widget/ImageView;", ReportConstant.COSTREPORT_PREFIX, "headType", "", "uin", "w", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "bean", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "url", "B", "y", "mode", "setDrawAreaMode", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", "r", "k", "color", "setMaskColor", "enable", "setEnableMask", "setEnableFrame", "frameSize", "frameColor", "asyncUpdate", "setAsyncUpdate", "disableVasSpecialShapeMask", "setDisableVasSpecialMask", "onResult", "onUpdate", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "hasFocus", "onWindowFocusChanged", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView$b;", "listener", "i", "d", "I", "curHeadType", "e", "Ljava/lang/String;", "curUin", "f", "Lcom/tencent/mobileqq/proavatar/e;", "curConfig", tl.h.F, "tag", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "Lcom/tencent/qqnt/avatar/core/ResourceOrganizer;", "resourceOrganizer", "Lcom/tencent/qqnt/avatar/fetch/c;", "curRequest", "Lcom/tencent/qqnt/avatar/resource/c;", "Lcom/tencent/qqnt/avatar/resource/c;", "viewStateChangeController", CustomAnimation.KeyPath.MASK_COLOR, "Landroid/graphics/ColorFilter;", "E", "Landroid/graphics/ColorFilter;", "maskColorFilter", UserInfo.SEX_FEMALE, "Z", "getDisableClipOnParents", "()Z", "setDisableClipOnParents", "(Z)V", "disableClipOnParents", "G", "drawAreaMode", "Ljava/util/concurrent/CopyOnWriteArrayList;", "H", "Ljava/util/concurrent/CopyOnWriteArrayList;", "resourceLayerList", "", "Ljava/lang/ref/SoftReference;", "Ljava/util/Set;", "listenerRefSet", "Lcom/tencent/mobileqq/proavatar/k;", "J", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder;", "K", "Lcom/tencent/mobileqq/proavatar/utils/ProAvatarLifecycleHolder;", "lifecycleHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "b", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQProAvatarView extends FrameLayout implements ResourceOrganizer.a, com.tencent.qqnt.avatar.fetch.a, LifecycleEventObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int M;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.resource.c viewStateChangeController;

    /* renamed from: D, reason: from kotlin metadata */
    @ColorInt
    private int maskColor;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ColorFilter maskColorFilter;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean disableClipOnParents;

    /* renamed from: G, reason: from kotlin metadata */
    private int drawAreaMode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.qqnt.avatar.layer.d<? extends Object>> resourceLayerList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Set<SoftReference<b>> listenerRefSet;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final k viewConfig;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ProAvatarLifecycleHolder lifecycleHolder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curHeadType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e curConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResourceOrganizer resourceOrganizer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.fetch.c curRequest;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarView$a;", "", "", "DRAW_AREA_MODE_DEFAULT", "I", "DRAW_AREA_MODE_WITH_INNER_PADDING", "", "INNER_PADDING_PERCENT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.QQProAvatarView$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarView$b;", "", "", "onLoadFinish", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void onLoadFinish();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            INSTANCE = new Companion(null);
            M = Color.argb(153, 255, 255, 255);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQProAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        int checkRadix;
        int checkRadix2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.curHeadType = -1;
        this.curUin = "";
        int hashCode = hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        String str = "QQProAvatarView_" + num;
        this.tag = str;
        ResourceOrganizer resourceOrganizer = new ResourceOrganizer();
        this.resourceOrganizer = resourceOrganizer;
        this.viewStateChangeController = new com.tencent.qqnt.avatar.resource.c(this);
        this.resourceLayerList = new CopyOnWriteArrayList<>();
        this.listenerRefSet = new LinkedHashSet();
        this.viewConfig = new k();
        this.lifecycleHolder = new ProAvatarLifecycleHolder();
        ProAvatarComponentUtils.g();
        resourceOrganizer.t(this);
        resourceOrganizer.v(this);
        t(0);
        if (QLog.isColorLevel()) {
            int hashCode2 = resourceOrganizer.hashCode();
            checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
            String num2 = Integer.toString(hashCode2, checkRadix2);
            Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
            QLog.d(str, 2, "createInstance organizer:" + num2);
        }
    }

    private final void C() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            try {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt instanceof QQProAvatarLayerImageView) {
                        ((QQProAvatarLayerImageView) childAt).setViewConfig$qqavatar_api_release(this.viewConfig);
                    }
                }
                return;
            } catch (Exception e16) {
                QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e16);
                return;
            }
        }
        if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewConfig$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        int childCount2 = QQProAvatarView.this.getChildCount();
                        for (int i16 = 0; i16 < childCount2; i16++) {
                            View childAt2 = QQProAvatarView.this.getChildAt(i16);
                            if (childAt2 instanceof QQProAvatarLayerImageView) {
                                ((QQProAvatarLayerImageView) childAt2).setViewConfig$qqavatar_api_release(QQProAvatarView.this.viewConfig);
                            }
                        }
                    } catch (Exception e17) {
                        QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                    }
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewConfig$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
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
                        try {
                            int childCount2 = QQProAvatarView.this.getChildCount();
                            for (int i16 = 0; i16 < childCount2; i16++) {
                                View childAt2 = QQProAvatarView.this.getChildAt(i16);
                                if (childAt2 instanceof QQProAvatarLayerImageView) {
                                    ((QQProAvatarLayerImageView) childAt2).setViewConfig$qqavatar_api_release(QQProAvatarView.this.viewConfig);
                                }
                            }
                        } catch (Exception e17) {
                            QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                        }
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewConfig$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            int childCount2 = QQProAvatarView.this.getChildCount();
                            for (int i16 = 0; i16 < childCount2; i16++) {
                                View childAt2 = QQProAvatarView.this.getChildAt(i16);
                                if (childAt2 instanceof QQProAvatarLayerImageView) {
                                    ((QQProAvatarLayerImageView) childAt2).setViewConfig$qqavatar_api_release(QQProAvatarView.this.viewConfig);
                                }
                            }
                        } catch (Exception e17) {
                            QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                        }
                    }
                });
            }
        }
    }

    private final void D() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            try {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt instanceof ImageView) {
                        ((ImageView) childAt).setColorFilter(this.maskColorFilter);
                    }
                }
                return;
            } catch (Exception e16) {
                QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e16);
                return;
            }
        }
        if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewMask$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        int childCount2 = QQProAvatarView.this.getChildCount();
                        for (int i16 = 0; i16 < childCount2; i16++) {
                            View childAt2 = QQProAvatarView.this.getChildAt(i16);
                            if (childAt2 instanceof ImageView) {
                                ((ImageView) childAt2).setColorFilter(QQProAvatarView.this.maskColorFilter);
                            }
                        }
                    } catch (Exception e17) {
                        QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                    }
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewMask$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
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
                        try {
                            int childCount2 = QQProAvatarView.this.getChildCount();
                            for (int i16 = 0; i16 < childCount2; i16++) {
                                View childAt2 = QQProAvatarView.this.getChildAt(i16);
                                if (childAt2 instanceof ImageView) {
                                    ((ImageView) childAt2).setColorFilter(QQProAvatarView.this.maskColorFilter);
                                }
                            }
                        } catch (Exception e17) {
                            QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                        }
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$updateChildViewMask$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            int childCount2 = QQProAvatarView.this.getChildCount();
                            for (int i16 = 0; i16 < childCount2; i16++) {
                                View childAt2 = QQProAvatarView.this.getChildAt(i16);
                                if (childAt2 instanceof ImageView) {
                                    ((ImageView) childAt2).setColorFilter(QQProAvatarView.this.maskColorFilter);
                                }
                            }
                        } catch (Exception e17) {
                            QLog.e("QQProAvatarView", 1, "updateChildViewMask ", e17);
                        }
                    }
                });
            }
        }
    }

    private final com.tencent.qqnt.avatar.meta.b j(ZPlanOutboundAvatarInfo avatarInfo) {
        b.a a16 = new b.a(1, "", 200, false).a("KEY_BEAN_KEY_SUFFIX", avatarInfo.a() + "_" + avatarInfo.b() + "_" + avatarInfo.f() + "_" + this.disableClipOnParents + "_" + avatarInfo.e()).a("key_zplan_outbound_avatar_info", avatarInfo).a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
        if (avatarInfo.e() > 0) {
            a16.a(FaceConstant.KEY_PRO_AVATAR_FRAME_SIZE, Integer.valueOf(avatarInfo.e()));
        }
        if (avatarInfo.c() > -1) {
            a16.a(FaceConstant.KEY_PRO_AVATAR_FRAME_COLOR, Integer.valueOf(avatarInfo.c()));
        }
        return a16.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void l(List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        this.resourceLayerList.clear();
        int i3 = 0;
        int i16 = 0;
        for (Object obj : layerList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.avatar.layer.d<? extends Object> dVar = (com.tencent.qqnt.avatar.layer.d) obj;
            Object d16 = dVar.d();
            if (d16 instanceof Bitmap) {
                QQProAvatarLayerImageView t16 = t(i16);
                t16.setCurLayer(dVar);
                t16.setResourceDrawConfig(dVar.c());
                Object d17 = dVar.d();
                Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type android.graphics.Bitmap");
                t16.setImageBitmap((Bitmap) d17);
                t16.setColorFilter(this.maskColorFilter);
                i3++;
                this.resourceLayerList.add(dVar);
            } else if (d16 instanceof Drawable) {
                QQProAvatarLayerImageView t17 = t(i16);
                if (dVar.d() instanceof URLDrawable) {
                    t17.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                t17.setCurLayer(dVar);
                t17.setResourceDrawConfig(dVar.c());
                Object d18 = dVar.d();
                Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                t17.setImageDrawable((Drawable) d18);
                t17.setColorFilter(this.maskColorFilter);
                i3++;
                this.resourceLayerList.add(dVar);
            } else {
                QLog.e(this.tag, 2, "onResult unKnown format [" + dVar.d());
            }
            i16 = i17;
        }
        v(i3);
        Iterator<SoftReference<b>> it = this.listenerRefSet.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                bVar.onLoadFinish();
            }
        }
        this.listenerRefSet.clear();
    }

    private final void m(com.tencent.qqnt.avatar.fetch.c request, boolean forceSync) {
        String str;
        com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
        if (cVar != null) {
            str = cVar.f();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, request.f())) {
            if (!forceSync && (!this.resourceLayerList.isEmpty())) {
                return;
            }
        } else {
            onResult(null);
            k();
        }
        this.curRequest = request;
        this.resourceOrganizer.u(getContext(), request);
    }

    public static /* synthetic */ void setEnableFrame$default(QQProAvatarView qQProAvatarView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = ViewUtils.dpToPx(1.0f);
        }
        if ((i17 & 2) != 0) {
            i16 = -1;
        }
        qQProAvatarView.setEnableFrame(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQProAvatarLayerImageView t(int index) {
        int i3 = 2;
        AttributeSet attributeSet = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (index >= getChildCount()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QQProAvatarLayerImageView qQProAvatarLayerImageView = new QQProAvatarLayerImageView(context, attributeSet, i3, b18 == true ? 1 : 0);
            addView(qQProAvatarLayerImageView, index, new FrameLayout.LayoutParams(-1, -1));
            u(qQProAvatarLayerImageView);
            return qQProAvatarLayerImageView;
        }
        View childAt = getChildAt(index);
        if (childAt instanceof QQProAvatarLayerImageView) {
            QQProAvatarLayerImageView qQProAvatarLayerImageView2 = (QQProAvatarLayerImageView) childAt;
            u(qQProAvatarLayerImageView2);
            return qQProAvatarLayerImageView2;
        }
        removeViewAt(index);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        QQProAvatarLayerImageView qQProAvatarLayerImageView3 = new QQProAvatarLayerImageView(context2, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
        addView(qQProAvatarLayerImageView3, index, new FrameLayout.LayoutParams(-1, -1));
        u(qQProAvatarLayerImageView3);
        return qQProAvatarLayerImageView3;
    }

    private final void u(QQProAvatarLayerImageView imageView) {
        imageView.setResourceDrawConfig(null);
        imageView.setVisibility(0);
        imageView.setColorFilter(this.maskColorFilter);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setViewConfig$qqavatar_api_release(this.viewConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int size) {
        int childCount = getChildCount();
        while (size < childCount) {
            View childAt = getChildAt(size);
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            size++;
        }
    }

    public final void A(@NotNull com.tencent.qqnt.avatar.meta.b bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bean);
        } else {
            Intrinsics.checkNotNullParameter(bean, "bean");
            m(new com.tencent.qqnt.avatar.fetch.c(bean, new ArrayList(), null, null, false, null, 60, null), false);
        }
    }

    public final void B(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) url);
        } else {
            if (url == null) {
                return;
            }
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            m(new com.tencent.qqnt.avatar.fetch.c(new b.a(parse, false, 2, (DefaultConstructorMarker) null).a("KEY_BEAN_KEY_SUFFIX", url).b(), null, BaseImageUtil.getDefaultFaceDrawable(), null, false, null, 58, null), false);
        }
    }

    public final void i(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listenerRefSet.add(new SoftReference<>(listener));
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.resourceOrganizer.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0065 A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #0 {Exception -> 0x006c, blocks: (B:13:0x001d, B:15:0x0025, B:17:0x002d, B:22:0x0036, B:24:0x003c, B:33:0x004b, B:35:0x0051, B:40:0x005a, B:42:0x0065), top: B:12:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String n() {
        com.tencent.qqnt.avatar.layer.d<? extends Object> f16;
        boolean z16;
        com.tencent.qqnt.avatar.meta.info.a[] a16;
        com.tencent.qqnt.avatar.meta.info.a aVar;
        Object b16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                View childAt = getChildAt(i3);
                if ((childAt instanceof QQProAvatarLayerImageView) && (f16 = ((QQProAvatarLayerImageView) childAt).f()) != null && (f16.b() instanceof a)) {
                    com.tencent.qqnt.avatar.meta.info.a[] a17 = f16.a();
                    if (a17 != null) {
                        if (a17.length == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            z16 = false;
                            if (!z16 && (a16 = f16.a()) != null && (aVar = (com.tencent.qqnt.avatar.meta.info.a) ArraysKt.getOrNull(a16, 0)) != null) {
                                b16 = aVar.b("bigUrl");
                                if (b16 instanceof String) {
                                    return null;
                                }
                                return (String) b16;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                        b16 = aVar.b("bigUrl");
                        if (b16 instanceof String) {
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQProAvatarView", 1, "findDynamicDrawableBigUrl exception", e16);
            }
        }
        return null;
    }

    @Nullable
    public final e o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (e) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.curConfig;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.viewStateChangeController.h(true);
        com.tencent.qqnt.avatar.g gVar = com.tencent.qqnt.avatar.g.f352801a;
        if (!gVar.u()) {
            this.lifecycleHolder.e(this, this, this.tag);
        }
        if (gVar.v()) {
            this.resourceOrganizer.s();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.viewStateChangeController.h(false);
        getViewTreeObserver().removeOnScrollChangedListener(this.viewStateChangeController);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        if (this.drawAreaMode == 1) {
            roundToInt = MathKt__MathJVMKt.roundToInt((RangesKt.coerceAtLeast(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec)) * 0.15f) / 1.3f);
            if (roundToInt > 0) {
                setPadding(roundToInt, roundToInt, roundToInt, roundToInt);
            } else {
                setPadding(0, 0, 0, 0);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // com.tencent.qqnt.avatar.core.ResourceOrganizer.a
    public void onResult(@Nullable final List<? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> layerList) {
        List list;
        Collection<com.tencent.qqnt.avatar.layer.d<? extends Object>> values;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) layerList);
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (layerList == null || layerList.isEmpty()) {
                com.tencent.qqnt.avatar.fetch.c cVar = this.curRequest;
                if (cVar != null) {
                    Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x16 = this.resourceOrganizer.x(cVar, false);
                    if (x16 != null && (values = x16.values()) != null) {
                        list = CollectionsKt___CollectionsKt.toList(values);
                    } else {
                        list = null;
                    }
                    if (list != null && (!list.isEmpty())) {
                        l(list);
                        return;
                    }
                }
                t(0).setImageDrawable(this.resourceOrganizer.q());
                v(1);
                return;
            }
            l(layerList);
            return;
        }
        if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable(layerList, this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$onResult$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f259526d;
                final /* synthetic */ QQProAvatarView this$0;

                {
                    this.f259526d = layerList;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) layerList, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List list2;
                    Collection<com.tencent.qqnt.avatar.layer.d<? extends Object>> values2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List list3 = this.f259526d;
                    if (list3 == null || list3.isEmpty()) {
                        com.tencent.qqnt.avatar.fetch.c cVar2 = this.this$0.curRequest;
                        if (cVar2 != null) {
                            Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x17 = this.this$0.resourceOrganizer.x(cVar2, false);
                            if (x17 != null && (values2 = x17.values()) != null) {
                                list2 = CollectionsKt___CollectionsKt.toList(values2);
                            } else {
                                list2 = null;
                            }
                            if (list2 != null && (!list2.isEmpty())) {
                                this.this$0.l(list2);
                                return;
                            }
                        }
                        this.this$0.t(0).setImageDrawable(this.this$0.resourceOrganizer.q());
                        this.this$0.v(1);
                        return;
                    }
                    this.this$0.l(this.f259526d);
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>(layerList, this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$onResult$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ List $layerList$inlined;
                    final /* synthetic */ QQProAvatarView this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$layerList$inlined = layerList;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) layerList, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Collection<com.tencent.qqnt.avatar.layer.d<? extends Object>> values2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        List list2 = this.$layerList$inlined;
                        if (list2 == null || list2.isEmpty()) {
                            com.tencent.qqnt.avatar.fetch.c cVar2 = this.this$0.curRequest;
                            if (cVar2 != null) {
                                Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x17 = this.this$0.resourceOrganizer.x(cVar2, false);
                                List list3 = (x17 == null || (values2 = x17.values()) == null) ? null : CollectionsKt___CollectionsKt.toList(values2);
                                if (list3 != null && (!list3.isEmpty())) {
                                    this.this$0.l(list3);
                                    return;
                                }
                            }
                            this.this$0.t(0).setImageDrawable(this.this$0.resourceOrganizer.q());
                            this.this$0.v(1);
                            return;
                        }
                        this.this$0.l(this.$layerList$inlined);
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(layerList, this) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$onResult$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f259527d;
                    final /* synthetic */ QQProAvatarView this$0;

                    {
                        this.f259527d = layerList;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) layerList, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        List list2;
                        Collection<com.tencent.qqnt.avatar.layer.d<? extends Object>> values2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        List list3 = this.f259527d;
                        if (list3 == null || list3.isEmpty()) {
                            com.tencent.qqnt.avatar.fetch.c cVar2 = this.this$0.curRequest;
                            if (cVar2 != null) {
                                Map<Integer, com.tencent.qqnt.avatar.layer.d<? extends Object>> x17 = this.this$0.resourceOrganizer.x(cVar2, false);
                                if (x17 != null && (values2 = x17.values()) != null) {
                                    list2 = CollectionsKt___CollectionsKt.toList(values2);
                                } else {
                                    list2 = null;
                                }
                                if (list2 != null && (!list2.isEmpty())) {
                                    this.this$0.l(list2);
                                    return;
                                }
                            }
                            this.this$0.t(0).setImageDrawable(this.this$0.resourceOrganizer.q());
                            this.this$0.v(1);
                            return;
                        }
                        this.this$0.l(this.f259527d);
                    }
                });
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) source, (Object) event);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.qqnt.avatar.fetch.c) iPatchRedirector.redirect((short) 35, (Object) this);
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
            return ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(bVar.a(), str, this.curConfig);
        }
        return this.curRequest;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, hasFocus);
            return;
        }
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getViewTreeObserver().addOnScrollChangedListener(this.viewStateChangeController);
        }
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.curHeadType;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.fetch.c q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (com.tencent.qqnt.avatar.fetch.c) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.curRequest;
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.curUin;
    }

    @NotNull
    public final ImageView s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ImageView) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return t(0);
    }

    public final void setAsyncUpdate(boolean asyncUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, asyncUpdate);
        } else {
            this.viewConfig.e(asyncUpdate);
        }
    }

    public final void setDisableClipOnParents(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.disableClipOnParents = z16;
        }
    }

    public final void setDisableVasSpecialMask(boolean disableVasSpecialShapeMask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, disableVasSpecialShapeMask);
            return;
        }
        this.viewConfig.f(disableVasSpecialShapeMask);
        C();
        if (this.curRequest != null) {
            invalidate();
        }
    }

    public final void setDrawAreaMode(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, mode);
            return;
        }
        if ((mode == 0 || mode == 1) && this.drawAreaMode != mode) {
            this.drawAreaMode = mode;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                requestLayout();
                invalidate();
            } else if (this.viewConfig.a()) {
                Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setDrawAreaMode$$inlined$runOnUiThread$1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQProAvatarView.this.requestLayout();
                            QQProAvatarView.this.invalidate();
                        }
                    }
                });
                obtain.setAsynchronous(true);
                ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
            } else {
                UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
                if (uiRunnableHelper.g()) {
                    uiRunnableHelper.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setDrawAreaMode$$inlined$runOnUiThread$2
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
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
                                QQProAvatarView.this.requestLayout();
                                QQProAvatarView.this.invalidate();
                            }
                        }
                    });
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setDrawAreaMode$$inlined$runOnUiThread$3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                QQProAvatarView.this.requestLayout();
                                QQProAvatarView.this.invalidate();
                            }
                        }
                    });
                }
            }
        }
    }

    public final void setEnableFrame(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, enable);
        } else if (enable) {
            setEnableFrame(ViewUtils.dpToPx(1.0f), -1);
        } else {
            setEnableFrame(0, -1);
        }
    }

    public final void setEnableMask(boolean enable) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, enable);
            return;
        }
        if (enable) {
            i3 = M;
        } else {
            i3 = 0;
        }
        setMaskColor(i3);
    }

    public final void setImageBitmap(@Nullable final Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
            return;
        }
        this.resourceOrganizer.i();
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQProAvatarLayerImageView t16 = t(0);
            v(1);
            t16.setImageBitmap(bitmap);
        } else if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable(bitmap) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageBitmap$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f259528d;

                {
                    this.f259528d = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        t17.setImageBitmap(this.f259528d);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>(bitmap) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageBitmap$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bitmap $bitmap$inlined;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$bitmap$inlined = bitmap;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) bitmap);
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
                            return;
                        }
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        t17.setImageBitmap(this.$bitmap$inlined);
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageBitmap$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Bitmap f259529d;

                    {
                        this.f259529d = bitmap;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) bitmap);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                            QQProAvatarView.this.v(1);
                            t17.setImageBitmap(this.f259529d);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }
    }

    public final void setImageDrawable(@Nullable final Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
            return;
        }
        this.resourceOrganizer.i();
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQProAvatarLayerImageView t16 = t(0);
            v(1);
            t16.setImageDrawable(drawable);
        } else if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable(drawable) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageDrawable$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f259530d;

                {
                    this.f259530d = drawable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) drawable);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        t17.setImageDrawable(this.f259530d);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>(drawable) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageDrawable$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Drawable $drawable$inlined;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$drawable$inlined = drawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) drawable);
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
                            return;
                        }
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        t17.setImageDrawable(this.$drawable$inlined);
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawable) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageDrawable$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Drawable f259531d;

                    {
                        this.f259531d = drawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, (Object) drawable);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                            QQProAvatarView.this.v(1);
                            t17.setImageDrawable(this.f259531d);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }
    }

    public final void setImageResource(@DrawableRes final int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, resId);
            return;
        }
        this.resourceOrganizer.i();
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQProAvatarLayerImageView t16 = t(0);
            v(1);
            try {
                t16.setImageResource(resId);
                return;
            } catch (Resources.NotFoundException e16) {
                QLog.e(this.tag, 1, "setImageResource notFoundException", e16);
                return;
            }
        }
        if (this.viewConfig.a()) {
            Message obtain = Message.obtain(ThreadManagerV2.getUIHandlerV2(), new Runnable(resId) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageResource$$inlined$runOnUiThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f259532d;

                {
                    this.f259532d = resId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, resId);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        try {
                            t17.setImageResource(this.f259532d);
                            return;
                        } catch (Resources.NotFoundException e17) {
                            QLog.e(QQProAvatarView.this.tag, 1, "setImageResource notFoundException", e17);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            obtain.setAsynchronous(true);
            ThreadManagerV2.getUIHandlerV2().sendMessage(obtain);
        } else {
            UiRunnableHelper uiRunnableHelper = UiRunnableHelper.f259710a;
            if (uiRunnableHelper.g()) {
                uiRunnableHelper.j(new Function0<Unit>(resId) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageResource$$inlined$runOnUiThread$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $resId$inlined;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$resId$inlined = resId;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, resId);
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
                            return;
                        }
                        QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                        QQProAvatarView.this.v(1);
                        try {
                            t17.setImageResource(this.$resId$inlined);
                        } catch (Resources.NotFoundException e17) {
                            QLog.e(QQProAvatarView.this.tag, 1, "setImageResource notFoundException", e17);
                        }
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(resId) { // from class: com.tencent.mobileqq.proavatar.QQProAvatarView$setImageResource$$inlined$runOnUiThread$3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f259533d;

                    {
                        this.f259533d = resId;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQProAvatarView.this, resId);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQProAvatarLayerImageView t17 = QQProAvatarView.this.t(0);
                            QQProAvatarView.this.v(1);
                            try {
                                t17.setImageResource(this.f259533d);
                                return;
                            } catch (Resources.NotFoundException e17) {
                                QLog.e(QQProAvatarView.this.tag, 1, "setImageResource notFoundException", e17);
                                return;
                            }
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }
    }

    public final void setMaskColor(@ColorInt int color) {
        PorterDuffColorFilter porterDuffColorFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, color);
            return;
        }
        if (this.maskColor != color) {
            this.maskColor = color;
            if (color == 0) {
                porterDuffColorFilter = null;
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }
            this.maskColorFilter = porterDuffColorFilter;
            if (getChildCount() > 0) {
                D();
                postInvalidate();
            }
        }
    }

    public final void w(int headType, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, headType, (Object) uin);
        } else {
            x(headType, uin, e.INSTANCE.a(headType, uin));
        }
    }

    public final void x(int headType, @Nullable String uin, @Nullable e config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(headType), uin, config);
            return;
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.curHeadType = headType;
        this.curUin = uin;
        this.curConfig = config;
        m(((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(headType, uin, config), false);
    }

    public final void y(@NotNull ZPlanOutboundAvatarInfo avatarInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) avatarInfo);
        } else {
            Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
            m(new com.tencent.qqnt.avatar.fetch.c(j(avatarInfo), null, BaseImageUtil.getDefaultFaceDrawable(), null, false, null, 58, null), true);
        }
    }

    public final void z(@NotNull com.tencent.qqnt.avatar.fetch.c request, boolean forceSync) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, request, Boolean.valueOf(forceSync));
        } else {
            Intrinsics.checkNotNullParameter(request, "request");
            m(request, forceSync);
        }
    }

    public final void setEnableFrame(int frameSize, int frameColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(frameSize), Integer.valueOf(frameColor));
            return;
        }
        this.viewConfig.h(frameSize);
        this.viewConfig.g(frameColor);
        C();
        if (this.curRequest != null) {
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQProAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQProAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ QQProAvatarView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
