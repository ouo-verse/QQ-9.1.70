package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.component.multitouchimg.PhotoViewAttacher;
import com.tencent.mobileqq.guild.component.multitouchimg.p;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryImmersiveEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryShowSourceImageEvent;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.temp.api.IGuildGalleryApi;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.LoadingCircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008e\u0001B\u0013\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018`\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\u0006\u0010\u001e\u001a\u00020\u0004J\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001c\u0010$\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0002J+\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010'H\u0002\u00a2\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0003J\u0010\u00104\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0003J\u001a\u0010;\u001a\u00020\u00042\u0006\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u00020#H\u0002J4\u0010A\u001a\u00020\u00042\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\b\b\u0002\u0010?\u001a\u00020#2\b\b\u0002\u0010@\u001a\u00020#H\u0002J\u0018\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\u0006\u0010?\u001a\u00020#H\u0002J\u0010\u0010F\u001a\u00020#2\u0006\u0010E\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010<\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020#H\u0002J\b\u0010L\u001a\u00020\u0004H\u0002J\b\u0010M\u001a\u00020\u0004H\u0002J\u0012\u0010P\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0010\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0002H\u0002J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u000206H\u0002J\u0010\u0010U\u001a\u00020#2\u0006\u0010S\u001a\u000206H\u0002R\u0014\u0010X\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010cR\u0018\u0010S\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010J\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010:\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010qR\u0016\u0010w\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010vR\u0018\u0010{\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0082\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R!\u0010\u0088\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerBaseImageItemViewV2;", "", com.tencent.luggage.wxa.c8.c.G, "", "setDisplayVerticalPos", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/k;", "clickOperationListener", "setClickOperationListener", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "c1", "setGuildFeed", ICustomDataEditor.STRING_ARRAY_PARAM_1, "getLayoutId", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "data", "F0", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "b1", "Landroid/widget/ImageView;", "V0", "oldFeed", "newFeed", "", "Y0", "", "from", "", "positionX", "positionY", "U0", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "Landroid/view/MotionEvent;", "S0", "T0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "X0", "J0", "H0", "O0", "N0", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "it", "d1", "info", "isResume", "h1", "coverUrl", "width", "height", "showSourceImage", "hasCache", "D0", "Lcom/tencent/libra/request/Option;", "option", "l1", "url", "Z0", "G0", "Landroid/graphics/drawable/Drawable;", "Q0", NodeProps.CUSTOM_PROP_ISGIF, ICustomDataEditor.NUMBER_PARAM_1, "j1", "k1", "Lcom/tencent/libra/LoadState;", "state", "m1", "progress", "f1", "curImageInfo", "e1", "g1", "d", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/guild/component/multitouchimg/MultiTouchImageView;", "e", "Lcom/tencent/mobileqq/guild/component/multitouchimg/MultiTouchImageView;", "contentImageView", "Lcom/tencent/image/URLImageView;", "f", "Lcom/tencent/image/URLImageView;", "contentGifImageView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "showLongImageTv", "i", "Landroid/view/View;", "loadingProgressContainer", "Lcom/tencent/mobileqq/widget/LoadingCircleProgress;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/LoadingCircleProgress;", "loadingProgress", BdhLogUtil.LogTag.Tag_Conn, "loadingProgressTv", "D", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "E", "Z", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/k;", "G", "H", "I", "displayPos", "displayVerticalPos", "J", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "mediaData", "K", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "guildFeed", "Lkk1/c;", "L", "Lkk1/c;", "picScaleDetector", "Landroid/view/GestureDetector;", "M", "Lkotlin/Lazy;", "W0", "()Landroid/view/GestureDetector;", "gestureDetector", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "N", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildBannerImageItemViewV2 extends GuildBannerBaseImageItemViewV2 {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ConcurrentHashMap<Long, String> P = new ConcurrentHashMap<>();

    @NotNull
    private static final HashMap<LoadState, Integer> Q;

    @NotNull
    private static final HashSet<LoadState> R;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView loadingProgressTv;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GProStImage curImageInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isGif;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private k clickOperationListener;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: H, reason: from kotlin metadata */
    private int displayPos;

    /* renamed from: I, reason: from kotlin metadata */
    private int displayVerticalPos;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GuildFeedRichMediaData mediaData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GProStFeed guildFeed;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private kk1.c picScaleDetector;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy gestureDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MultiTouchImageView contentImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView contentGifImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView showLongImageTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingProgressContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LoadingCircleProgress loadingProgress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2$a;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "LONG_IMAGE_URL_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;", "setLONG_IMAGE_URL_MAP", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "Ljava/util/HashSet;", "Lcom/tencent/libra/LoadState;", "Lkotlin/collections/HashSet;", "FAIL_STATE_SET", "Ljava/util/HashSet;", "", "IMG_SIZE", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "PROGRESS_MAP", "Ljava/util/HashMap;", "PROGRESS_MAX", "I", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConcurrentHashMap<Long, String> a() {
            return GuildBannerImageItemViewV2.P;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f219905e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f219906f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ GuildBannerImageItemViewV2 f219907h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, boolean z17, GuildBannerImageItemViewV2 guildBannerImageItemViewV2) {
            super(true);
            this.f219905e = z16;
            this.f219906f = z17;
            this.f219907h = guildBannerImageItemViewV2;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            if (this.f219905e && !this.f219906f) {
                this.f219907h.m1(state);
            }
            boolean z16 = false;
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
            boolean j3 = com.tencent.mobileqq.guild.feed.gallery.b.j(option);
            boolean e16 = com.tencent.mobileqq.guild.feed.gallery.b.e(option);
            if (!j3 && !e16) {
                QLog.e(this.f219907h.TAG, 1, "bindCover loadImage error");
                return;
            }
            if (this.f219905e) {
                Intrinsics.checkNotNull(option);
                com.tencent.mobileqq.guild.feed.gallery.b.m(option.getUrl());
            }
            GuildBannerImageItemViewV2 guildBannerImageItemViewV2 = this.f219907h;
            Intrinsics.checkNotNull(option);
            guildBannerImageItemViewV2.l1(option, this.f219905e);
        }
    }

    static {
        HashMap<LoadState, Integer> hashMap = new HashMap<>();
        hashMap.put(LoadState.STATE_PREPARE, 10);
        hashMap.put(LoadState.STATE_DOWNLOADING, 20);
        hashMap.put(LoadState.STATE_DOWNLOAD_SUCCESS, 60);
        hashMap.put(LoadState.STATE_DECODING, 70);
        Q = hashMap;
        HashSet<LoadState> hashSet = new HashSet<>();
        hashSet.add(LoadState.STATE_DOWNLOAD_FAILED);
        hashSet.add(LoadState.STATE_DECODE_FAILED);
        hashSet.add(LoadState.STATE_URL_ILLEGAL);
        R = hashSet;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBannerImageItemViewV2(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "Guild_Feed_GAL_GuildBannerImageItemViewV2_" + hashCode();
        this.displayPos = -1;
        this.displayVerticalPos = -1;
        this.picScaleDetector = new kk1.c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2$gestureDetector$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/item/GuildBannerImageItemViewV2$gestureDetector$2$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDoubleTap", "", e.a.NAME, "", "d", "Ljava/lang/String;", "gifImageTag", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends GestureDetector.SimpleOnGestureListener {

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final String gifImageTag = "contentGifImageView";

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GuildBannerImageItemViewV2 f219909e;

                a(GuildBannerImageItemViewV2 guildBannerImageItemViewV2) {
                    this.f219909e = guildBannerImageItemViewV2;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(@Nullable MotionEvent e16) {
                    this.f219909e.S0(this.gifImageTag, e16);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(@Nullable MotionEvent e16) {
                    this.f219909e.T0(this.gifImageTag);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
                    Float f16;
                    GuildBannerImageItemViewV2 guildBannerImageItemViewV2 = this.f219909e;
                    String str = this.gifImageTag;
                    Float f17 = null;
                    if (e16 != null) {
                        f16 = Float.valueOf(e16.getX());
                    } else {
                        f16 = null;
                    }
                    if (e16 != null) {
                        f17 = Float.valueOf(e16.getY());
                    }
                    guildBannerImageItemViewV2.U0(str, f16, f17);
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                return new GestureDetector(context, new a(this));
            }
        });
        this.gestureDetector = lazy;
        P.clear();
        X0(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D0(String coverUrl, int width, int height, boolean showSourceImage, boolean hasCache) {
        boolean z16;
        MultiTouchImageView multiTouchImageView;
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        boolean z17;
        MultiTouchImageView multiTouchImageView2;
        GProStImage gProStImage;
        BitmapDrawable bitmapDrawable2;
        Bitmap bitmap;
        boolean z18;
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[bindCover] displayVerticalPos " + this.displayVerticalPos + ", pos: " + this.displayPos + ", code:" + hashCode() + ", coverUrl:" + coverUrl.hashCode() + ", width:" + width + ", height:" + height + ", isGif:" + this.isGif + ", showSourceImage:" + showSourceImage);
        }
        if (this.isGif) {
            n1(true);
            G0(coverUrl);
            return;
        }
        int i3 = 0;
        n1(false);
        if (!showSourceImage) {
            if (coverUrl.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && Z0(coverUrl)) {
                z16 = true;
                multiTouchImageView = this.contentImageView;
                String str2 = null;
                if (multiTouchImageView == null) {
                    drawable = multiTouchImageView.getDrawable();
                } else {
                    drawable = null;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    bitmapDrawable = (BitmapDrawable) drawable;
                } else {
                    bitmapDrawable = null;
                }
                if (bitmapDrawable == null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                    z17 = bitmap.isRecycled();
                } else {
                    z17 = false;
                }
                if (!z16 && !z17) {
                    String str3 = this.TAG;
                    if (QLog.isDevelopLevel()) {
                        Log.d(str3, "[bindCover] skip by same url");
                        return;
                    }
                    return;
                }
                String d16 = com.tencent.mobileqq.guild.picload.e.d(coverUrl);
                multiTouchImageView2 = this.contentImageView;
                if (multiTouchImageView2 != null) {
                    multiTouchImageView2.setTag(R.id.wcn, d16);
                }
                Option b16 = com.tencent.mobileqq.guild.feed.gallery.b.b(coverUrl, width, height, showSourceImage);
                gProStImage = this.curImageInfo;
                if (gProStImage == null) {
                    bitmapDrawable2 = GuildFeedImagePreDecoder.INSTANCE.get(bm.a(gProStImage));
                } else {
                    bitmapDrawable2 = null;
                }
                if (bitmapDrawable2 == null) {
                    String str4 = this.TAG;
                    GProStImage gProStImage2 = this.curImageInfo;
                    if (gProStImage2 != null) {
                        str2 = gProStImage2.picUrl;
                    }
                    QLog.i(str4, 1, "[preloadBitmap] hit img " + str2);
                    b16.setLoadingDrawable(bitmapDrawable2);
                    MultiTouchImageView multiTouchImageView3 = this.contentImageView;
                    if (multiTouchImageView3 != null) {
                        multiTouchImageView3.setImageDrawable(b16.getLoadingDrawable());
                    }
                } else {
                    MultiTouchImageView multiTouchImageView4 = this.contentImageView;
                    if (multiTouchImageView4 != null) {
                        multiTouchImageView4.setImageDrawable(d30.a.b(R.drawable.f162601b70));
                    }
                }
                String str5 = this.TAG;
                if (QLog.isDevelopLevel()) {
                    MultiTouchImageView multiTouchImageView5 = this.contentImageView;
                    if (multiTouchImageView5 != null) {
                        i3 = multiTouchImageView5.hashCode();
                    }
                    Log.d(str5, "[bindCover] " + i3 + " url: " + coverUrl);
                }
                com.tencent.mobileqq.guild.picload.e.a().f(b16, new b(showSourceImage, hasCache, this));
            }
        }
        z16 = false;
        multiTouchImageView = this.contentImageView;
        String str22 = null;
        if (multiTouchImageView == null) {
        }
        if (!(drawable instanceof BitmapDrawable)) {
        }
        if (bitmapDrawable == null) {
        }
        z17 = false;
        if (!z16) {
        }
        String d162 = com.tencent.mobileqq.guild.picload.e.d(coverUrl);
        multiTouchImageView2 = this.contentImageView;
        if (multiTouchImageView2 != null) {
        }
        Option b162 = com.tencent.mobileqq.guild.feed.gallery.b.b(coverUrl, width, height, showSourceImage);
        gProStImage = this.curImageInfo;
        if (gProStImage == null) {
        }
        if (bitmapDrawable2 == null) {
        }
        String str52 = this.TAG;
        if (QLog.isDevelopLevel()) {
        }
        com.tencent.mobileqq.guild.picload.e.a().f(b162, new b(showSourceImage, hasCache, this));
    }

    static /* synthetic */ void E0(GuildBannerImageItemViewV2 guildBannerImageItemViewV2, String str, int i3, int i16, boolean z16, boolean z17, int i17, Object obj) {
        boolean z18;
        boolean z19;
        if ((i17 & 8) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i17 & 16) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        guildBannerImageItemViewV2.D0(str, i3, i16, z18, z19);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void G0(String coverUrl) {
        URLDrawable uRLDrawable;
        URLDrawable uRLDrawable2;
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "[bindGifImageCover] code:" + hashCode() + ", coverUrl:" + coverUrl.hashCode());
        }
        n1(true);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        Drawable Q0 = Q0();
        URLImageView uRLImageView = this.contentGifImageView;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(Q0);
        }
        obtain.mLoadingDrawable = Q0;
        try {
            if (!URLUtil.isNetworkUrl(coverUrl)) {
                uRLDrawable2 = URLDrawable.getFileDrawable(coverUrl, obtain);
            } else {
                uRLDrawable2 = URLDrawable.getDrawable(coverUrl, obtain);
            }
        } catch (Exception e16) {
            e = e16;
            uRLDrawable = null;
        }
        try {
            URLDrawable.resume();
        } catch (Exception e17) {
            uRLDrawable = uRLDrawable2;
            e = e17;
            Logger logger2 = Logger.f235387a;
            String str2 = this.TAG;
            Logger.b bVar = new Logger.b();
            String str3 = "[showGifImage] get exception! " + e;
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str2, 1, (String) it.next(), null);
            }
            uRLDrawable2 = uRLDrawable;
            if (uRLDrawable2 != null) {
            }
        }
        if (uRLDrawable2 != null) {
            Logger logger3 = Logger.f235387a;
            String str4 = this.TAG;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[showGifImage] drawable is null!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e(str4, 1, (String) it5.next(), null);
            }
            return;
        }
        URLImageView uRLImageView2 = this.contentGifImageView;
        if (uRLImageView2 != null) {
            uRLImageView2.setImageDrawable(uRLDrawable2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void H0(View rootView) {
        URLImageView uRLImageView = (URLImageView) rootView.findViewById(R.id.v1t);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        uRLImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean I0;
                I0 = GuildBannerImageItemViewV2.I0(GuildBannerImageItemViewV2.this, view, motionEvent);
                return I0;
            }
        });
        this.contentGifImageView = uRLImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I0(GuildBannerImageItemViewV2 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W0().onTouchEvent(motionEvent);
        return true;
    }

    private final void J0(View rootView) {
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) rootView.findViewById(R.id.wcn);
        this.contentImageView = multiTouchImageView;
        if (multiTouchImageView != null) {
            multiTouchImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        MultiTouchImageView multiTouchImageView2 = this.contentImageView;
        final String str = "contentImageView";
        if (multiTouchImageView2 != null) {
            multiTouchImageView2.setOnViewTapListener(new p() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.e
                @Override // com.tencent.mobileqq.guild.component.multitouchimg.p
                public final void onViewTap(View view, float f16, float f17) {
                    GuildBannerImageItemViewV2.K0(GuildBannerImageItemViewV2.this, str, view, f16, f17);
                }
            });
        }
        MultiTouchImageView multiTouchImageView3 = this.contentImageView;
        if (multiTouchImageView3 != null) {
            multiTouchImageView3.setOnDoubleTabListener(new com.tencent.mobileqq.guild.component.multitouchimg.d() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.f
                @Override // com.tencent.mobileqq.guild.component.multitouchimg.d
                public final void onDoubleTap(MotionEvent motionEvent) {
                    GuildBannerImageItemViewV2.L0(GuildBannerImageItemViewV2.this, str, motionEvent);
                }
            });
        }
        MultiTouchImageView multiTouchImageView4 = this.contentImageView;
        if (multiTouchImageView4 != null) {
            multiTouchImageView4.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.g
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean M0;
                    M0 = GuildBannerImageItemViewV2.M0(GuildBannerImageItemViewV2.this, str, view);
                    return M0;
                }
            });
        }
        MultiTouchImageView multiTouchImageView5 = this.contentImageView;
        if (multiTouchImageView5 != null) {
            this.picScaleDetector.d(multiTouchImageView5);
        }
        ImageViewPorterDuffUtils.f235385a.c(this.contentImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(GuildBannerImageItemViewV2 this$0, String imageTag, View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageTag, "$imageTag");
        this$0.U0(imageTag, Float.valueOf(f16), Float.valueOf(f17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(GuildBannerImageItemViewV2 this$0, String imageTag, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageTag, "$imageTag");
        this$0.S0(imageTag, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M0(GuildBannerImageItemViewV2 this$0, String imageTag, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageTag, "$imageTag");
        this$0.T0(imageTag);
        return true;
    }

    private final void N0(View rootView) {
        this.loadingProgressContainer = rootView.findViewById(R.id.v1v);
        this.loadingProgress = (LoadingCircleProgress) rootView.findViewById(R.id.v1w);
        this.loadingProgressTv = (TextView) rootView.findViewById(R.id.v1x);
    }

    private final void O0(View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.f165169v25);
        this.showLongImageTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildBannerImageItemViewV2.P0(GuildBannerImageItemViewV2.this, view);
                }
            });
            if (Build.VERSION.SDK_INT >= 26) {
                textView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(textView.getContext(), R.animator.f155134n));
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = ViewUtils.dpToPx(20.0f);
        rootView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(GuildBannerImageItemViewV2 this$0, View view) {
        GProStImage gProStImage;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick(this$0.TAG) && (gProStImage = this$0.curImageInfo) != null) {
            this$0.d1(gProStImage);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable Q0() {
        BitmapDrawable bitmapDrawable;
        GProStImage gProStImage = this.curImageInfo;
        String str = null;
        if (gProStImage != null) {
            bitmapDrawable = GuildFeedImagePreDecoder.INSTANCE.get(bm.a(gProStImage));
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            String str2 = this.TAG;
            GProStImage gProStImage2 = this.curImageInfo;
            if (gProStImage2 != null) {
                str = gProStImage2.picUrl;
            }
            QLog.i(str2, 1, "[createLoadingDrawable] hit img " + str);
            return bitmapDrawable;
        }
        Drawable b16 = d30.a.b(R.drawable.f162601b70);
        Intrinsics.checkNotNullExpressionValue(b16, "{\n            QCircleDra\u2026.transparent_2)\n        }");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(String from, MotionEvent event) {
        Logger logger = Logger.f235387a;
        logger.d().i(this.TAG, 1, "[doDoubleTapLike] from:from");
        k kVar = this.clickOperationListener;
        if (kVar != null) {
            kVar.c(from, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(String from) {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().i(str, 1, "[doLongClick] from:" + from);
        k kVar = this.clickOperationListener;
        if (kVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            kVar.a(context, from);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(String from, Float positionX, Float positionY) {
        Float f16;
        PhotoViewAttacher l3;
        MultiTouchImageView multiTouchImageView = this.contentImageView;
        if (multiTouchImageView != null && (l3 = multiTouchImageView.l()) != null) {
            f16 = Float.valueOf(l3.I());
        } else {
            f16 = null;
        }
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        logger.d().i(str, 1, "[doSingleTapClose] from:" + from + " scale=" + f16);
        if (!Intrinsics.areEqual(f16, 1.0f)) {
            MultiTouchImageView multiTouchImageView2 = this.contentImageView;
            if (multiTouchImageView2 != null) {
                multiTouchImageView2.setScale(1.0f, true);
                return;
            }
            return;
        }
        k kVar = this.clickOperationListener;
        if (kVar != null) {
            kVar.b(from, positionX, positionY);
        }
    }

    private final GestureDetector W0() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    private final void X0(View rootView) {
        J0(rootView);
        H0(rootView);
        O0(rootView);
        N0(rootView);
    }

    private final boolean Y0(GProStFeed oldFeed, GProStFeed newFeed) {
        if (oldFeed == null || newFeed == null || !com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(oldFeed) || com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(newFeed) || Intrinsics.areEqual(oldFeed.idd, newFeed.idd)) {
            return false;
        }
        return true;
    }

    private final boolean Z0(String url) {
        Object obj;
        String d16 = com.tencent.mobileqq.guild.picload.e.d(url);
        MultiTouchImageView multiTouchImageView = this.contentImageView;
        String str = null;
        if (multiTouchImageView != null) {
            obj = multiTouchImageView.getTag(R.id.wcn);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = "";
        }
        return Intrinsics.areEqual(d16, str);
    }

    @Deprecated(message = "The image preview API called by this function is not implemented.")
    private final void d1(GProStImage it) {
        Integer num;
        String str = it.picUrl;
        Logger logger = Logger.f235387a;
        String str2 = this.TAG;
        Logger.a d16 = logger.d();
        if (str != null) {
            num = Integer.valueOf(str.hashCode());
        } else {
            num = null;
        }
        boolean z16 = true;
        d16.i(str2, 1, "[previewSuperWHImage] url:" + num);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        long hashCode = str.hashCode();
        P.put(Long.valueOf(hashCode), str);
        IGuildGalleryApi iGuildGalleryApi = (IGuildGalleryApi) QRoute.api(IGuildGalleryApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str3 = it.picUrl;
        Intrinsics.checkNotNullExpressionValue(str3, "it.picUrl");
        iGuildGalleryApi.openImagePreview(peekAppRuntime, context, str3, it.width, it.height, hashCode);
    }

    private final void e1(GProStImage curImageInfo) {
        Float f16;
        float f17 = 3.5f;
        if (com.tencent.mobileqq.guild.feed.gallery.b.k(curImageInfo.width, curImageInfo.height)) {
            float screenWidth = DisplayUtil.getScreenWidth();
            float screenHeight = curImageInfo.height / DisplayUtil.getScreenHeight();
            MultiTouchImageView multiTouchImageView = this.contentImageView;
            if (multiTouchImageView != null) {
                if (screenHeight < multiTouchImageView.getMinimumScale()) {
                    screenHeight = multiTouchImageView.getMinimumScale();
                }
                float f18 = (screenHeight * screenWidth) / curImageInfo.width;
                if (multiTouchImageView.m() < f18 && multiTouchImageView.getMinimumScale() < f18) {
                    f17 = f18;
                }
                multiTouchImageView.setMaximumScale(f17);
            }
        } else {
            MultiTouchImageView multiTouchImageView2 = this.contentImageView;
            if (multiTouchImageView2 != null) {
                multiTouchImageView2.setMaximumScale(3.5f);
            }
        }
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            MultiTouchImageView multiTouchImageView3 = this.contentImageView;
            if (multiTouchImageView3 != null) {
                f16 = Float.valueOf(multiTouchImageView3.getMaximumScale());
            } else {
                f16 = null;
            }
            Log.d(str, "[setImageMaxScale] :" + f16);
        }
    }

    private final void f1(int progress) {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[setProgress] progress:" + progress);
        }
        LoadingCircleProgress loadingCircleProgress = this.loadingProgress;
        if (loadingCircleProgress != null) {
            loadingCircleProgress.setLoadingProgress(progress);
        }
        TextView textView = this.loadingProgressTv;
        if (textView != null) {
            textView.setText(progress + "%");
        }
        if (progress == 100) {
            View view = this.loadingProgressContainer;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.loadingProgressContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private final boolean g1(GProStImage curImageInfo) {
        return com.tencent.mobileqq.guild.feed.gallery.b.k(curImageInfo.width, curImageInfo.height);
    }

    private final void h1(final GProStImage info, boolean isResume) {
        boolean z16;
        boolean z17 = false;
        if (isResume) {
            GuildFeedRichMediaData guildFeedRichMediaData = this.mediaData;
            if (guildFeedRichMediaData != null && guildFeedRichMediaData.isLoadOriginal()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (com.tencent.mobileqq.guild.feed.gallery.b.f(info, z16)) {
                Logger.f235387a.d().i(this.TAG, 1, "[tryToBindCoverWithTrueSize] bind source");
                String str = info.picUrl;
                Intrinsics.checkNotNullExpressionValue(str, "info.picUrl");
                D0(str, info.width, info.height, true, true);
                return;
            }
        }
        Logger logger = Logger.f235387a;
        String str2 = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str2, "[tryToBindCoverWithTrueSize] code:" + hashCode() + ", isResume:" + isResume);
        }
        String i3 = bm.i(info);
        Pair<Integer, Integer> j3 = bm.j(info);
        boolean g16 = g1(info);
        Object obj = j3.first;
        Intrinsics.checkNotNullExpressionValue(obj, "imageSize.first");
        int intValue = ((Number) obj).intValue();
        Object obj2 = j3.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "imageSize.second");
        E0(this, i3, intValue, ((Number) obj2).intValue(), g16, false, 16, null);
        if (isResume) {
            GuildFeedRichMediaData guildFeedRichMediaData2 = this.mediaData;
            if (guildFeedRichMediaData2 != null && guildFeedRichMediaData2.isLoadOriginal()) {
                z17 = true;
            }
            com.tencent.mobileqq.guild.feed.gallery.b.g(info, z17, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2$tryToBindCoverWithTrueSize$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z18) {
                    if (z18) {
                        Logger logger2 = Logger.f235387a;
                        logger2.d().i(GuildBannerImageItemViewV2.this.TAG, 1, "[tryToBindCoverWithTrueSize] bind source on async check, hasCache");
                        final GuildBannerImageItemViewV2 guildBannerImageItemViewV2 = GuildBannerImageItemViewV2.this;
                        final GProStImage gProStImage = info;
                        kotlin.Function0.d(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2$tryToBindCoverWithTrueSize$3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                GuildBannerImageItemViewV2 guildBannerImageItemViewV22 = GuildBannerImageItemViewV2.this;
                                String str3 = gProStImage.picUrl;
                                Intrinsics.checkNotNullExpressionValue(str3, "info.picUrl");
                                GProStImage gProStImage2 = gProStImage;
                                guildBannerImageItemViewV22.D0(str3, gProStImage2.width, gProStImage2.height, true, true);
                            }
                        });
                    }
                }
            });
        }
    }

    static /* synthetic */ void i1(GuildBannerImageItemViewV2 guildBannerImageItemViewV2, GProStImage gProStImage, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildBannerImageItemViewV2.h1(gProStImage, z16);
    }

    private final void j1() {
        URLImageView uRLImageView = this.contentGifImageView;
        boolean z16 = false;
        if (uRLImageView != null && uRLImageView.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            AbstractGifImage.resumeAll();
        }
    }

    private final void k1() {
        GProStImage gProStImage = this.curImageInfo;
        if (gProStImage != null) {
            h1(gProStImage, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(Option option, boolean showSourceImage) {
        MultiTouchImageView multiTouchImageView;
        Object obj;
        Option option2;
        Integer num;
        GuildFeedRichMediaData guildFeedRichMediaData;
        String url = option.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "option.url");
        Integer num2 = null;
        if (!Z0(url)) {
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                resultBitMap.recycle();
            }
            option.setResultBitMap(null);
            com.tencent.mobileqq.guild.picload.e.a().h(option);
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "[onStateChangeCallback] wrong url callback! displayVerticalPos " + this.displayVerticalPos + ", pos: " + this.displayPos + ", code:" + hashCode() + ", option: " + option + ", coverUrl:" + option.getUrl().hashCode());
                return;
            }
            return;
        }
        if (showSourceImage && (guildFeedRichMediaData = this.mediaData) != null) {
            guildFeedRichMediaData.setLoadOriginal();
        }
        if (com.tencent.mobileqq.guild.feed.gallery.b.j(option)) {
            MultiTouchImageView multiTouchImageView2 = this.contentImageView;
            if (multiTouchImageView2 != null) {
                multiTouchImageView2.setImageBitmap(option.getResultBitMap());
            }
        } else if (com.tencent.mobileqq.guild.feed.gallery.b.e(option) && (multiTouchImageView = this.contentImageView) != null) {
            Object animatable = option.getAnimatable();
            Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
            multiTouchImageView.setImageDrawable((Drawable) animatable);
        }
        MultiTouchImageView multiTouchImageView3 = this.contentImageView;
        if (multiTouchImageView3 != null) {
            obj = multiTouchImageView3.getTag(R.id.w8s);
        } else {
            obj = null;
        }
        if (obj instanceof Option) {
            option2 = (Option) obj;
        } else {
            option2 = null;
        }
        if (option2 != null) {
            com.tencent.mobileqq.guild.picload.e.a().h(option2);
            Logger logger2 = Logger.f235387a;
            String str2 = this.TAG;
            if (QLog.isDevelopLevel()) {
                Log.d(str2, "[onStateChangeCallback] remove old option displayVerticalPos " + this.displayVerticalPos + ", pos: " + this.displayPos + ", code:" + hashCode() + ", old option: " + option2 + " ");
            }
        }
        MultiTouchImageView multiTouchImageView4 = this.contentImageView;
        if (multiTouchImageView4 != null) {
            multiTouchImageView4.setTag(R.id.w8s, option);
        }
        mk1.b.f416885a.a(getContext().hashCode()).a(option);
        Logger logger3 = Logger.f235387a;
        String str3 = this.TAG;
        if (QLog.isDevelopLevel()) {
            int i3 = this.displayVerticalPos;
            int i16 = this.displayPos;
            int hashCode = hashCode();
            int hashCode2 = option.getUrl().hashCode();
            int requestWidth = option.getRequestWidth();
            int requestHeight = option.getRequestHeight();
            Bitmap resultBitMap2 = option.getResultBitMap();
            if (resultBitMap2 != null) {
                num = Integer.valueOf(resultBitMap2.getWidth());
            } else {
                num = null;
            }
            Bitmap resultBitMap3 = option.getResultBitMap();
            if (resultBitMap3 != null) {
                num2 = Integer.valueOf(resultBitMap3.getHeight());
            }
            Log.d(str3, "[onStateChangeCallback] displayVerticalPos " + i3 + ", pos: " + i16 + ", code:" + hashCode + ", option: " + option + ", coverUrl:" + hashCode2 + ", optionWH[" + requestWidth + ", " + requestHeight + "], bitmapWH[" + num + ", " + num2 + "], img size: " + ((Object) 0) + " mb! ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(LoadState state) {
        boolean contains;
        HashMap<LoadState, Integer> hashMap = Q;
        if (hashMap.containsKey(state)) {
            Integer num = hashMap.get(state);
            Intrinsics.checkNotNull(num);
            f1(num.intValue());
        } else {
            f1(100);
        }
        contains = CollectionsKt___CollectionsKt.contains(R, state);
        if (contains) {
            QQToast.makeText(getContext(), R.string.f144190o4, 0).show();
        }
    }

    private final void n1(boolean isGif) {
        if (isGif) {
            URLImageView uRLImageView = this.contentGifImageView;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            MultiTouchImageView multiTouchImageView = this.contentImageView;
            if (multiTouchImageView != null) {
                multiTouchImageView.setVisibility(8);
                return;
            }
            return;
        }
        URLImageView uRLImageView2 = this.contentGifImageView;
        if (uRLImageView2 != null) {
            uRLImageView2.setVisibility(8);
        }
        MultiTouchImageView multiTouchImageView2 = this.contentImageView;
        if (multiTouchImageView2 != null) {
            multiTouchImageView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable GuildFeedRichMediaData data, int pos) {
        GProStImage gProStImage;
        boolean z16;
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[bindData] displayVerticalPos " + this.displayVerticalPos + ",  pos " + pos + ", isResume:" + this.isResume + ", code:" + hashCode());
        }
        this.mediaData = data;
        this.displayPos = pos;
        TextView textView = this.showLongImageTv;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.loadingProgressContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        GuildFeedRichMediaData guildFeedRichMediaData = this.mediaData;
        if (guildFeedRichMediaData != null) {
            gProStImage = guildFeedRichMediaData.getImage();
        } else {
            gProStImage = null;
        }
        this.curImageInfo = gProStImage;
        if (gProStImage != null) {
            z16 = gProStImage.isGif;
        } else {
            z16 = false;
        }
        this.isGif = z16;
        if (gProStImage != null) {
            String str2 = this.TAG;
            if (QLog.isDevelopLevel()) {
                Log.d(str2, "[bindData] curImageInfo width=" + gProStImage.width + ",  height=" + gProStImage.height);
            }
            i1(this, gProStImage, false, 2, null);
            e1(gProStImage);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if (r0 == true) goto L18;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImageView V0() {
        boolean z16;
        boolean z17;
        GProStImage gProStImage = this.curImageInfo;
        boolean z18 = true;
        if (gProStImage != null && gProStImage.isGif) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            URLImageView uRLImageView = this.contentGifImageView;
            if (uRLImageView != null) {
                if (uRLImageView.getVisibility() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z18 = false;
            if (z18) {
                return this.contentGifImageView;
            }
        }
        return this.contentImageView;
    }

    public final void a1() {
        Object obj;
        Option option;
        MultiTouchImageView multiTouchImageView = this.contentImageView;
        if (multiTouchImageView != null) {
            obj = multiTouchImageView.getTag(R.id.w8s);
        } else {
            obj = null;
        }
        if (obj instanceof Option) {
            option = (Option) obj;
        } else {
            option = null;
        }
        if (option == null) {
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().h(option);
        mk1.b.f416885a.a(getContext().hashCode()).c(option);
        try {
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                resultBitMap.recycle();
            }
            option.setResultBitMap(null);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            Logger.b bVar = new Logger.b();
            String str2 = "notifyRecycle recycle bitmap error! " + th5;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str, 1, (String) it.next(), th5);
            }
        }
        Logger logger2 = Logger.f235387a;
        String str3 = this.TAG;
        if (QLog.isColorLevel()) {
            logger2.d().d(str3, 2, "[notifyRecycle] displayVerticalPos: " + this.displayVerticalPos + ",  pos " + this.displayPos + ", isResume:" + this.isResume + ", code:" + hashCode() + ", option: " + option);
        }
        MultiTouchImageView multiTouchImageView2 = this.contentImageView;
        if (multiTouchImageView2 != null) {
            multiTouchImageView2.setImageResource(R.drawable.f162601b70);
        }
        MultiTouchImageView multiTouchImageView3 = this.contentImageView;
        if (multiTouchImageView3 != null) {
            multiTouchImageView3.setTag(R.id.wcn, "");
        }
        MultiTouchImageView multiTouchImageView4 = this.contentImageView;
        if (multiTouchImageView4 != null) {
            multiTouchImageView4.setTag(R.id.w8s, null);
        }
        URLImageView uRLImageView = this.contentGifImageView;
        if (uRLImageView != null) {
            uRLImageView.setImageResource(R.drawable.f162601b70);
        }
    }

    public final void b1() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "[onDetachedFromVerticalWindow] displayVerticalPos " + this.displayVerticalPos + ", pos " + this.displayPos + ", isResume:" + this.isResume + ", code:" + hashCode());
        }
        a1();
    }

    public final void c1(@Nullable GProStFeed feed) {
        Object orNull;
        GProStImage gProStImage;
        Integer num;
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            int hashCode = hashCode();
            int i3 = this.displayVerticalPos;
            int i16 = this.displayPos;
            boolean z16 = this.isResume;
            if (feed != null) {
                num = Integer.valueOf(feed.hashCode());
            } else {
                num = null;
            }
            d16.d(str, 2, "[onFeedDataReady] code:" + hashCode + ", displayVerticalPos " + i3 + ", displayPos " + i16 + ", isResume:" + z16 + ", feed.hashcode:" + num);
        }
        GProStFeed gProStFeed = this.guildFeed;
        this.guildFeed = feed;
        if (Y0(gProStFeed, feed)) {
            logger.d().i(this.TAG, 1, "[onFeedDataReady] isPublishingCompleted, not need to update image !");
            return;
        }
        if (feed != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(com.tencent.mobileqq.guild.feed.gallery.b.d(feed), this.displayPos);
            GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) orNull;
            this.mediaData = guildFeedRichMediaData;
            if (guildFeedRichMediaData == null || (gProStImage = guildFeedRichMediaData.getImage()) == null) {
                gProStImage = this.curImageInfo;
            }
            this.curImageInfo = gProStImage;
        }
        if (this.isResume) {
            k1();
        }
        GProStImage gProStImage2 = this.curImageInfo;
        if (gProStImage2 != null) {
            String str2 = this.TAG;
            logger.d().i(str2, 1, "[onFeedDataReady] curImageInfo width=" + gProStImage2.width + ",  height=" + gProStImage2.height);
            e1(gProStImage2);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerBaseImageItemViewV2, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryShowSourceImageEvent.class);
        eventClass.add(GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.eng;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[onAttachedToWindow] displayVerticalPos " + this.displayVerticalPos + ", pos " + this.displayPos + ", isResume:" + this.isResume + ", code:" + hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[onViewDetachedFromWindow] displayVerticalPos " + this.displayVerticalPos + ", pos " + this.displayPos + ", isResume:" + this.isResume + ", code:" + hashCode());
        }
    }

    public final void onPause() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "[onPause] code:" + hashCode());
        }
        this.isResume = false;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerBaseImageItemViewV2, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        GProStImage gProStImage;
        if (event instanceof GuildFeedGalleryShowSourceImageEvent) {
            String url = ((GuildFeedGalleryShowSourceImageEvent) event).getUrl();
            GProStImage gProStImage2 = this.curImageInfo;
            if (gProStImage2 != null) {
                str = gProStImage2.picUrl;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(url, str) && this.isResume && (gProStImage = this.curImageInfo) != null) {
                Logger logger = Logger.f235387a;
                String str2 = this.TAG;
                logger.d().i(str2, 1, "[onReceiveEvent] show source image, url:" + gProStImage.picUrl.hashCode());
                String str3 = gProStImage.picUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "it.picUrl");
                E0(this, str3, gProStImage.width, gProStImage.height, true, false, 16, null);
                return;
            }
            return;
        }
        if ((event instanceof GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent) && ((GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent) event).getVerticalPosition() - this.displayVerticalPos >= 3) {
            a1();
        }
    }

    public final void onResume() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "[onResume] displayVerticalPos " + this.displayVerticalPos + ", pos " + this.displayPos + ", isResume:" + this.isResume + ", code:" + hashCode());
        }
        this.isResume = true;
        j1();
        k1();
    }

    public final void setClickOperationListener(@NotNull k clickOperationListener) {
        Intrinsics.checkNotNullParameter(clickOperationListener, "clickOperationListener");
        this.clickOperationListener = clickOperationListener;
    }

    public final void setDisplayVerticalPos(int pos) {
        this.displayVerticalPos = pos;
    }

    public final void setGuildFeed(@Nullable GProStFeed feed) {
        this.guildFeed = feed;
        GProStImage gProStImage = this.curImageInfo;
        if (gProStImage != null) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            if (QLog.isDevelopLevel()) {
                Log.d(str, "[setGuildFeed] curImageInfo width=" + gProStImage.width + ",  height=" + gProStImage.height);
            }
            i1(this, gProStImage, false, 2, null);
            e1(gProStImage);
        }
    }
}
