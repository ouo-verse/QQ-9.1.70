package com.tencent.state.square.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.SquareDebug;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.battery.ISquareBatteryStatusObserver;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.MsgType;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.NickName;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.StickerItem;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareItemAvatarBinding;
import com.tencent.state.square.databinding.VasSquareQzoneFeedBubbleBinding;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.square.holder.component.view.BlindBoxView;
import com.tencent.state.square.holder.component.view.DebugTipsView;
import com.tencent.state.square.holder.component.view.FixedIconView;
import com.tencent.state.square.holder.component.view.NewDressIconView;
import com.tencent.state.square.holder.component.view.NewInteractIconView;
import com.tencent.state.square.like.IStickersChangedListener;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.square.like.SquareOperateLikePanel;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.resource.IBaseResourceManager;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.square.resource.PagPreloadManager;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.data.FootLabelInfo;
import com.tencent.state.template.data.UniFootLabelStyleInfo;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import com.tencent.state.view.BubbleElementEventListener;
import com.tencent.state.view.IAvatarBubble;
import com.tencent.state.view.OnlineStatusBubbleViewHelperKt;
import com.tencent.state.view.SquareImageView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import wx4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00bc\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u00bc\u0001B\r\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019H\u0002J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0014J\u0010\u0010B\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010E\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020HH\u0002J\u001a\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020K2\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010L\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\b\b\u0002\u0010M\u001a\u000204H\u0002J\u0010\u0010N\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0018\u0010O\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\b\u0010S\u001a\u00020>H\u0002J\u0012\u0010T\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010U\u001a\u00020>2\u0006\u0010V\u001a\u0002042\u0006\u0010W\u001a\u000204H\u0002J\u0010\u0010X\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0018\u0010Y\u001a\u00020>2\u0006\u0010Z\u001a\u0002042\u0006\u0010W\u001a\u000204H\u0002J\u001c\u0010[\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010\u00022\b\u0010?\u001a\u0004\u0018\u00010\u0019H\u0002J.\u0010\\\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\b\u0010]\u001a\u0004\u0018\u00010^2\b\b\u0002\u0010_\u001a\u0002042\b\b\u0002\u0010M\u001a\u000204H\u0002J\u0010\u0010`\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010a\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\b\u0010b\u001a\u00020>H\u0002J\u0010\u0010c\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\"\u0010d\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010e\u001a\u00020^2\b\u0010f\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010g\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0016J\u0018\u0010l\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010J\u001a\u00020KH\u0014J \u0010l\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010J\u001a\u00020K2\u0006\u0010m\u001a\u00020KH\u0014J\u0010\u0010n\u001a\u00020>2\u0006\u0010o\u001a\u00020pH\u0002J\u001c\u0010q\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020t0r2\u0006\u0010A\u001a\u00020\u0002H\u0002J%\u0010u\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020t0r2\u0006\u0010A\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020\rH\u0016J,\u0010x\u001a\u00020>2\u0006\u0010y\u001a\u00020s2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010f\u001a\u0004\u0018\u00010\b2\u0006\u0010|\u001a\u00020}H\u0002J\b\u0010~\u001a\u00020>H\u0016J#\u0010\u007f\u001a\u00020>2\u0007\u0010\u0080\u0001\u001a\u00020K2\u0007\u0010\u0081\u0001\u001a\u0002042\u0007\u0010\u0082\u0001\u001a\u000204H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u001b\u0010\u0084\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u0002042\u0007\u0010\u0086\u0001\u001a\u000204H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019H\u0016J\u0014\u0010\u0088\u0001\u001a\u00020>2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010+H\u0016J\u0014\u0010\u008a\u0001\u001a\u00020>2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010+H\u0002J\u001a\u0010\u008b\u0001\u001a\u00020>2\u0007\u0010A\u001a\u00030\u008c\u00012\u0006\u0010J\u001a\u00020KH\u0016J\u0014\u0010\u008d\u0001\u001a\u0002042\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020>2\u0007\u0010\u008f\u0001\u001a\u000204H\u0016J5\u0010\u0090\u0001\u001a\u00020>2\u0007\u0010\u0091\u0001\u001a\u00020K2\u0007\u0010\u0092\u0001\u001a\u00020i2\u0007\u0010\u0093\u0001\u001a\u0002042\t\u0010\u0094\u0001\u001a\u0004\u0018\u000104H\u0016\u00a2\u0006\u0003\u0010\u0095\u0001J\u0013\u0010\u0096\u0001\u001a\u00020>2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020>H\u0016J\t\u0010\u009a\u0001\u001a\u000204H\u0016J(\u0010\u009b\u0001\u001a\u00020>2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010+2\u0007\u0010\u009d\u0001\u001a\u0002042\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010sH\u0016J%\u0010\u009f\u0001\u001a\u00020>2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010+2\u0006\u0010V\u001a\u0002042\u0007\u0010\u009d\u0001\u001a\u000204H\u0016J\u0019\u0010\u00a0\u0001\u001a\u00020>2\u0006\u0010y\u001a\u00020s2\u0006\u0010z\u001a\u00020{H\u0016J\u0019\u0010\u00a1\u0001\u001a\u00020>2\u0006\u0010J\u001a\u00020K2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00a2\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00a3\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0012\u0010\u00a4\u0001\u001a\u00020>2\u0007\u0010\u00a5\u0001\u001a\u000204H\u0016J\t\u0010\u00a6\u0001\u001a\u00020>H\u0016J\t\u0010\u00a7\u0001\u001a\u00020>H\u0016J@\u0010\u00a8\u0001\u001a\u00020>2\u0007\u0010\u00a9\u0001\u001a\u00020s2\u0006\u0010y\u001a\u00020s2\u0007\u0010\u00aa\u0001\u001a\u00020K2\u0007\u0010\u00ab\u0001\u001a\u0002042\u0007\u0010\u00ac\u0001\u001a\u00020K2\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010+J\u0011\u0010\u00ae\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00af\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00b0\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0016J\u0011\u0010\u00b1\u0001\u001a\u00020>2\u0006\u0010j\u001a\u00020kH\u0002J/\u0010\u00b2\u0001\u001a\u00020>2\u0007\u0010\u009c\u0001\u001a\u00020+2\u0007\u0010\u00b3\u0001\u001a\u0002042\u0012\b\u0002\u0010\u00b4\u0001\u001a\u000b\u0012\u0004\u0012\u00020>\u0018\u00010\u00b5\u0001H\u0002J\u0012\u0010\u00b6\u0001\u001a\u00020>2\u0007\u0010\u009c\u0001\u001a\u00020+H\u0002J\u0014\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010A\u001a\u00030\u008c\u0001H\u0014J\u0011\u0010\u00b8\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00b9\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00ba\u0001\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0011\u0010\u00bb\u0001\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019H\u0002R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/state/square/holder/AvatarViewHolder;", "Lcom/tencent/state/map/MapPlayableViewHolder;", "Lcom/tencent/state/square/data/SquareAvatarItem;", "Lcom/tencent/state/square/resource/IResourceCallback;", "Lcom/tencent/state/view/BubbleElementEventListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/state/battery/ISquareBatteryStatusObserver;", "Lcom/tencent/state/square/like/IStickersChangedListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;)V", "avatar", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "getAvatar", "()Lcom/tencent/state/square/avatar/SquareAvatarView;", "avatarGestureDetector", "Landroid/view/GestureDetector;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemAvatarBinding;", "blindBoxView", "Lcom/tencent/state/square/holder/component/view/BlindBoxView;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "currentResource", "Lcom/tencent/state/square/data/Resource;", "debugTipsView", "Lcom/tencent/state/square/holder/component/view/DebugTipsView;", "fixedIconView", "Lcom/tencent/state/square/holder/component/view/FixedIconView;", "iconNewDress", "Lcom/tencent/state/square/holder/component/view/NewDressIconView;", "intimateBackPagView", "Lcom/tencent/state/square/api/ISquarePagView;", "getIntimateBackPagView", "()Lcom/tencent/state/square/api/ISquarePagView;", "setIntimateBackPagView", "(Lcom/tencent/state/square/api/ISquarePagView;)V", "intimateFrontPagView", "getIntimateFrontPagView", "setIntimateFrontPagView", "meLocationPag", "name", "Landroid/view/View;", "getName", "()Landroid/view/View;", "newInteractIconView", "Lcom/tencent/state/square/holder/component/view/NewInteractIconView;", "reporter", "Lcom/tencent/state/square/IReporter;", "ringPagView", "squareAvatarLikeContainerCanShow", "", "squareOperateLikePanel", "Lcom/tencent/state/square/like/SquareOperateLikePanel;", "unReadMessageHelper", "Lcom/tencent/state/square/holder/AvatarViewMessageHelper;", "getUnReadMessageHelper", "()Lcom/tencent/state/square/holder/AvatarViewMessageHelper;", "setUnReadMessageHelper", "(Lcom/tencent/state/square/holder/AvatarViewMessageHelper;)V", "adjustBubbleLocation", "", "resource", "bindAvatar", "data", "bindAvatarImageShow", "bindBatteryObserver", "bindBlindBox", "bindBubbleSkin", "bindComposedAvatarContainer", ParseCommon.CONTAINER, "Landroid/widget/RelativeLayout;", "bindDebugTips", "index", "", "bindExtraBubble", "needAnimation", "bindFixed", "bindFootLabel", "label", "Lcom/tencent/state/template/data/FootLabelInfo;", "bindFootLabelText", "bindListeners", "bindLocation", "bindNewDressLabel", NodeProps.VISIBLE, "isMe", "bindNewInfo", "bindNewInteractLabel", "show", "bindNickName", "bindOnlineStatusBubble", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "isZoom", "bindOthers", "bindPlayIcon", "bindReportElement", "bindRingAnim", "bindSquareAvatarHeartContainer", "status", "stickersChangedListener", "bindStickersBanner", "calculateElevation", "", "location", "Lcom/tencent/state/map/Location;", "doBind", "event", "doBindBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "getAvatarBaseParams", "", "", "", "getAvatarIconReportParams", "(Lcom/tencent/state/square/data/SquareAvatarItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerView", "initOperateLikePanel", "uin", c.B, "Lcom/tencent/state/square/data/Stickers;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "onBackFromDetail", "onBatteryInfoChange", "capacity", "levelChange", "powerConnect", "onBeatCustomText", "onCenterScaled", "isScaleToCenter", "isAnimeEnd", "onChangeSource", NodeProps.ON_CLICK, "v", "onDoubleClick", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_LONG_CLICK, "onMapMinimum", "isMin", "onMapZoomEnd", "zoomLevel", "scale", "isZoomIn", "doMinView", "(IFZLjava/lang/Boolean;)V", "onRecordSuccess", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "onRecycled", "onScaleToDetail", "onSongIconClick", "view", "isPlaying", "songMid", "onSongIconExpose", "onStickersChanged", "onUpdateAvatarStatus", "onUpdateFixedState", "onUpdateUnreadMessage", "onVisibilityChanged", "isVisible", "onVisible", "onZoomOverOut", "reportBubbleEvent", "eventKey", "unReadNum", "isPtt", "from", "targetView", "reportStateBubbleExp", "resetAvatarAlpha", "resizeAvatar", "resizeFlowerViewSize", "startAlphaAnimation", ViewStickEventHelper.IS_SHOW, "animationEnd", "Lkotlin/Function0;", "startBubbleAnimation", "transform", "updateAvatarLabel", "updateFlower", "updateForRoleBornAnim", "updateNewSize", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarViewHolder extends MapPlayableViewHolder<SquareAvatarItem> implements IResourceCallback, BubbleElementEventListener, View.OnClickListener, View.OnLongClickListener, ISquareBatteryStatusObserver, IStickersChangedListener {
    private static final float INIT_ALPHA = 1.0f;
    private static final float MIN_ALPHA = 0.0f;
    private static final String TAG = "Square_AvatarViewHolder";
    public static final int UNREAD_FROM_BUBBLE = 0;
    public static final int UNREAD_FROM_NAME_READ_DOT = 1;
    private final GestureDetector avatarGestureDetector;
    private final VasSquareItemAvatarBinding binding;
    private BlindBoxView blindBoxView;
    private final FastClickUtils clickUtils;
    private Resource currentResource;
    private DebugTipsView debugTipsView;
    private FixedIconView fixedIconView;
    private NewDressIconView iconNewDress;
    private ISquarePagView intimateBackPagView;
    private ISquarePagView intimateFrontPagView;
    private ISquarePagView meLocationPag;
    private NewInteractIconView newInteractIconView;
    private IReporter reporter;
    private ISquarePagView ringPagView;
    private boolean squareAvatarLikeContainerCanShow;
    private SquareOperateLikePanel squareOperateLikePanel;
    private AvatarViewMessageHelper unReadMessageHelper;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AvatarViewHolder(VasSquareItemAvatarBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        FrameLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this.avatarGestureDetector = new GestureDetector(itemView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.square.holder.AvatarViewHolder$avatarGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e16) {
                AvatarViewHolder avatarViewHolder = AvatarViewHolder.this;
                avatarViewHolder.onDoubleClick(avatarViewHolder.getAvatar());
                return super.onDoubleTap(e16);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e16) {
                super.onLongPress(e16);
                AvatarViewHolder avatarViewHolder = AvatarViewHolder.this;
                avatarViewHolder.onLongClick(avatarViewHolder.getAvatar());
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e16) {
                AvatarViewHolder avatarViewHolder = AvatarViewHolder.this;
                avatarViewHolder.onClick(avatarViewHolder.getAvatar());
                return super.onSingleTapConfirmed(e16);
            }
        });
        this.unReadMessageHelper = new AvatarViewMessageHelper(this);
        bindReportElement();
        this.clickUtils = new FastClickUtils(800L);
    }

    private final void adjustBubbleLocation(final Resource resource) {
        FrameLayout frameLayout = this.binding.avatarTopContentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarTopContentContainer");
        ViewExtensionsKt.updateLayoutParams(frameLayout, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$adjustBubbleLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                invoke2(marginLayoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                int i3 = resource.getBubbleCoordinate().y;
                View itemView = AvatarViewHolder.this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                receiver.bottomMargin = i3 - ViewExtensionsKt.dip(itemView, 8);
            }
        });
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
        ViewExtensionsKt.updatePadding$default(avatarOnlineStatusSimpleBubble, resource.getBubbleCoordinate().x, 0, 0, 0, 14, null);
        LinearLayout linearLayout = this.binding.squareAvatarBubbleTop;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.squareAvatarBubbleTop");
        ViewExtensionsKt.updatePadding$default(linearLayout, resource.getBubbleCoordinate().x, 0, 0, 0, 14, null);
        LinearLayout linearLayout2 = this.binding.floatFlagsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.floatFlagsContainer");
        ViewExtensionsKt.updateLayoutParams(linearLayout2, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$adjustBubbleLocation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                invoke2(marginLayoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.topMargin = -Resource.this.getBubbleCoordinate().y;
            }
        });
    }

    private final void bindAvatarImageShow(SquareAvatarItem data) {
        Boolean changeAvatarImageVisible = data.getExtra().getChangeAvatarImageVisible();
        if (changeAvatarImageVisible != null) {
            boolean booleanValue = changeAvatarImageVisible.booleanValue();
            getAvatar().setImageViewVisibility(booleanValue);
            onItemCoverRecord(!booleanValue);
            data.getExtra().setChangeAvatarImageVisible(null);
        }
    }

    private final void bindBatteryObserver(SquareAvatarItem data) {
        if (!data.isMe()) {
            SquareBatteryStatusManager.INSTANCE.removeObserver(this);
            return;
        }
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        if (onlineStatus != null) {
            if (OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus)) {
                SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                squareBatteryStatusManager.onStatusChange(data.getUin(), data.getIsGenderMale(), onlineStatus, "avatarHolder");
                squareBatteryStatusManager.addObserver(this);
                return;
            }
            SquareBatteryStatusManager.INSTANCE.removeObserver(this);
            return;
        }
        SquareBatteryStatusManager.INSTANCE.removeObserver(this);
    }

    private final void bindBlindBox(SquareAvatarItem data) {
        if (data.isMe()) {
            FrameLayout frameLayout = this.binding.bornPag;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bornPag");
            if (frameLayout.getVisibility() != 0) {
                SquareBlindBoxEntranceInfo blindBoxEntranceInfo = data.getExtra().getBlindBoxEntranceInfo();
                if (blindBoxEntranceInfo != null) {
                    if (this.blindBoxView == null) {
                        View itemView = this.itemView;
                        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                        Context context = itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                        BlindBoxView blindBoxView = new BlindBoxView(context, null, 0, 6, null);
                        this.blindBoxView = blindBoxView;
                        this.binding.avatarContainer.addView(blindBoxView);
                        BlindBoxView blindBoxView2 = this.blindBoxView;
                        if (blindBoxView2 != null) {
                            blindBoxView2.updateLayout(R.id.plj);
                        }
                    }
                    BlindBoxView blindBoxView3 = this.blindBoxView;
                    if (blindBoxView3 != null) {
                        blindBoxView3.updateData(blindBoxEntranceInfo);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        BlindBoxView blindBoxView4 = this.blindBoxView;
        if (blindBoxView4 != null) {
            blindBoxView4.hide();
        }
    }

    private final void bindBubbleSkin(SquareAvatarItem data) {
        final SquareBubbleInfo bubbleInfo = data.getExtra().getBubbleInfo();
        if (bubbleInfo != null) {
            if (SquareBubbleSkinKt.isReady(bubbleInfo)) {
                doBindBubbleSkin(bubbleInfo);
                return;
            } else {
                BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(bubbleInfo.getSkinLink(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$bindBubbleSkin$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                        invoke2(bitmap);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Bitmap bubbleBitmap) {
                        Intrinsics.checkNotNullParameter(bubbleBitmap, "bubbleBitmap");
                        SquareBubbleInfo.this.setBitmap(bubbleBitmap);
                        this.doBindBubbleSkin(SquareBubbleInfo.this);
                    }
                });
                return;
            }
        }
        doBindBubbleSkin(new SquareBubbleInfo(0, null, null, null, null, null, null, 126, null));
    }

    private final void bindComposedAvatarContainer(RelativeLayout container) {
        SquareOperateLikePanel squareOperateLikePanel = this.squareOperateLikePanel;
        if (squareOperateLikePanel != null) {
            squareOperateLikePanel.bindComposedAvatarContainer(container);
        }
    }

    private final void bindFixed(SquareAvatarItem data) {
        if (data.getExtra().getIsFixed()) {
            if (this.fixedIconView == null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                FixedIconView fixedIconView = new FixedIconView(context, null, 0, 6, null);
                this.fixedIconView = fixedIconView;
                this.binding.avatarContainer.addView(fixedIconView);
                FixedIconView fixedIconView2 = this.fixedIconView;
                if (fixedIconView2 != null) {
                    fixedIconView2.updateLayout(R.id.plj);
                }
            }
            FixedIconView fixedIconView3 = this.fixedIconView;
            if (fixedIconView3 != null) {
                fixedIconView3.showStaticIcon();
                return;
            }
            return;
        }
        FixedIconView fixedIconView4 = this.fixedIconView;
        if (fixedIconView4 != null) {
            fixedIconView4.hideAll();
        }
    }

    private final void bindFootLabel(SquareAvatarItem data, FootLabelInfo label) {
        Map<String, Object> mutableMapOf;
        UniFootLabelStyleInfo info = label.getInfo();
        String iconUrl = info != null ? info.getIconUrl() : null;
        SquareImageView squareImageView = this.binding.flIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.flIcon");
        ViewExtensionsKt.setUri(squareImageView, iconUrl);
        TextView textView = this.binding.flText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.flText");
        UniFootLabelStyleInfo info2 = label.getInfo();
        String tipText = info2 != null ? info2.getTipText() : null;
        if (tipText == null) {
            tipText = "";
        }
        textView.setText(tipText);
        FootLabelInfo.Companion.LabelType labelType = label.getLabelType();
        FootLabelInfo.Companion.LabelType labelType2 = FootLabelInfo.Companion.LabelType.SYNC;
        int i3 = labelType == labelType2 ? 1 : 2;
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        IReporter iReporter = this.reporter;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("zplan_other_user_qq", data.getUin());
        pairArr[1] = TuplesKt.to("zplan_footer_type", Integer.valueOf(i3));
        pairArr[2] = TuplesKt.to("zplan_action_type", "imp");
        pairArr[3] = TuplesKt.to("dt_pgid", checkNearby);
        pairArr[4] = TuplesKt.to("pgid", checkNearby);
        pairArr[5] = TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(label.getScene() == FootLabelInfo.Companion.SourceScene.LIBRARY ? 1 : 2));
        pairArr[6] = TuplesKt.to("zplan_footer_type", Integer.valueOf(label.getLabelType() != labelType2 ? 2 : 1));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_AVATAR_LIBRARY_ICON, mutableMapOf);
    }

    private final void bindFootLabelText(SquareAvatarItem data) {
        CommonFootLabel footLabel = data.getExtra().getFootLabel();
        String tipText = footLabel != null ? footLabel.tipText() : null;
        if (tipText == null || tipText.length() == 0) {
            LinearLayout linearLayout = this.binding.avatarLabelContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.avatarLabelContainer");
            ViewExtensionsKt.setVisibility(linearLayout, false);
        } else {
            TextView textView = this.binding.footLabelText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.footLabelText");
            textView.setText(tipText);
            TextView textView2 = this.binding.footLabelText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.footLabelText");
            textView2.setVisibility(0);
        }
    }

    private final void bindListeners() {
        this.unReadMessageHelper.setClickProxy(this);
        this.binding.avatarPublishStatusBubble.setOnClickListener(this);
        this.binding.squareAvatarBubble.setOnClickListener(this);
        getAvatar().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.holder.AvatarViewHolder$bindListeners$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                GestureDetector gestureDetector;
                gestureDetector = AvatarViewHolder.this.avatarGestureDetector;
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        getName().setOnClickListener(this);
        VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = this.binding.squareAvatarFeedsBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
        vasSquareQzoneFeedBubbleBinding.getMRv().setOnClickListener(this);
        this.binding.footLabel.setOnClickListener(this);
    }

    private final void bindNewInfo(SquareAvatarItem data) {
        Object obj;
        boolean hasNewFlag = (data.isMe() || data.isStranger()) ? false : data.hasNewFlag(1);
        SquareImageView squareImageView = this.binding.iconNewStatus;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconNewStatus");
        squareImageView.setVisibility(hasNewFlag ? 0 : 8);
        if (hasNewFlag) {
            SquareBaseKt.getSquareLog().i(TAG, "Show iconNewStatus " + data.getUin() + "(isMe: " + data.isMe() + ')');
        }
        Iterator<T> it = data.getStickers().getItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            StickerItem stickerItem = (StickerItem) obj;
            if (stickerItem.getType() == StickerType.Like && stickerItem.isMe()) {
                break;
            }
        }
        if ((((StickerItem) obj) != null) && hasNewFlag) {
            SquareImageView squareImageView2 = this.binding.iconNewStatus;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.iconNewStatus");
            squareImageView2.setVisibility(8);
            SquareBaseKt.getSquareLog().i(TAG, "SquareAvatarHeart Hide iconNewStatus " + data.getUin() + "(isMe: " + data.isMe() + ')');
        }
        if (hasNewFlag && Square.INSTANCE.getConfig().getNeedScaleAnimation()) {
            return;
        }
        data.getExtra().setNeedBubbleAnim(false);
    }

    private final void bindNewInteractLabel(boolean show, boolean isMe) {
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail() || isMe) {
            show = false;
        }
        if (show) {
            if (this.newInteractIconView == null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                NewInteractIconView newInteractIconView = new NewInteractIconView(context, null, 0, 6, null);
                this.newInteractIconView = newInteractIconView;
                this.binding.floatFlagsContainer.addView(newInteractIconView);
                NewInteractIconView newInteractIconView2 = this.newInteractIconView;
                if (newInteractIconView2 != null) {
                    newInteractIconView2.updateLayout();
                }
            }
            NewInteractIconView newInteractIconView3 = this.newInteractIconView;
            if (newInteractIconView3 != null) {
                newInteractIconView3.show();
                return;
            }
            return;
        }
        NewInteractIconView newInteractIconView4 = this.newInteractIconView;
        if (newInteractIconView4 != null) {
            newInteractIconView4.hide();
        }
    }

    private final void bindOnlineStatusBubble(SquareAvatarItem data, OnlineStatus onlineStatus, boolean isZoom, boolean needAnimation) {
        reportStateBubbleExp(data);
        if (onlineStatus != null) {
            this.binding.squareAvatarBubble.setElementEventListener(this);
            IAvatarBubble.DefaultImpls.setData$default(this.binding.squareAvatarBubble, data.getUin(), onlineStatus, data.getStickers(), null, data.getExtra().getRelationType(), needAnimation, false, data.getLocationInfo(), 64, null);
            bindSquareAvatarHeartContainer(data, onlineStatus, null);
            RelativeLayout relativeLayout = this.binding.avatarContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarContainer");
            bindComposedAvatarContainer(relativeLayout);
            if (data.isMe() && SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[beatText] bindOnlineStatusBubble, cusText: ");
                OnlineStatus onlineStatus2 = data.getExtra().getOnlineStatus();
                sb5.append(onlineStatus2 != null ? onlineStatus2.getCustomText() : null);
                squareLog.d(TAG, sb5.toString());
            }
            bindNewInfo(data);
            bindStickersBanner(data);
        }
    }

    private final void bindOthers(SquareAvatarItem data) {
        MapItemController controller;
        View view;
        if (data.isMe()) {
            FrameLayout frameLayout = this.binding.bornPag;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bornPag");
            if (frameLayout.getVisibility() != 0 && ((controller = getController()) == null || controller.getHasCheckRoleBornAnim())) {
                if (this.meLocationPag == null) {
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    ISquarePagView pagImageView = commonUtils.getPagImageView(context);
                    this.meLocationPag = pagImageView;
                    if (pagImageView != null) {
                        pagImageView.setPagFile(R.raw.f130993);
                    }
                    ISquarePagView iSquarePagView = this.meLocationPag;
                    if (iSquarePagView != null) {
                        this.binding.avatarLocation.addView(iSquarePagView.getView(), 0, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
                ISquarePagView iSquarePagView2 = this.meLocationPag;
                if (iSquarePagView2 != null) {
                    ISquarePagView.DefaultImpls.playPag$default(iSquarePagView2, 0, 1, null);
                }
                ISquarePagView iSquarePagView3 = this.meLocationPag;
                if (iSquarePagView3 != null && (view = iSquarePagView3.getView()) != null) {
                    view.setVisibility(0);
                }
                FrameLayout frameLayout2 = this.binding.avatarLocation;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarLocation");
                frameLayout2.setVisibility(0);
                return;
            }
            FrameLayout frameLayout3 = this.binding.avatarLocation;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.avatarLocation");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = this.binding.avatarLocation;
        Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.avatarLocation");
        frameLayout4.setVisibility(8);
    }

    private final void bindPlayIcon(SquareAvatarItem data) {
        SpecialStatus extraData;
        SongInfo songInfo;
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        avatarOnlineStatusSimpleBubble.updatePlayIcon((onlineStatus == null || (extraData = onlineStatus.getExtraData()) == null || (songInfo = extraData.getSongInfo()) == null) ? null : songInfo.getSongId(), data.isMe());
    }

    private final void bindReportElement() {
        IReporter iReporter = this.reporter;
        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
        iReporter.setElementInfo(avatarOnlineStatusSimpleBubble, SquareReportConst.ElementId.ELEMENT_ID_STATE_BUBBLE, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(getName(), SquareReportConst.ElementId.ELEMENT_ID_MESSAGE_BUBBLE, new LinkedHashMap(), false, false);
    }

    private final void bindRingAnim(SquareAvatarItem data) {
        if (data.getExtra().getNeedRingPagAnim()) {
            String str = "[addRoles] bindRingAnim, " + data.getUin() + ", " + data.getTroopName();
            SquareBaseKt.getSquareLog().i(TAG, str + ", needRing");
            data.getExtra().setNeedRingPagAnim(false);
            if (this.ringPagView == null) {
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                ISquarePagView pagImageView = commonUtils.getPagImageView(context);
                this.ringPagView = pagImageView;
                if (pagImageView != null) {
                    this.binding.ringPag.addView(pagImageView.getView(), new FrameLayout.LayoutParams(-1, -1));
                    pagImageView.setPagViewListener(new SimpleSquarePagViewListener(str));
                }
            }
            ISquarePagView iSquarePagView = this.ringPagView;
            if (iSquarePagView != null) {
                PAGLoader.INSTANCE.playPAG(PagPreloadManager.AVATAR_RING_PAG, PagPreloadManager.RING_PAG_FILE_NAME, iSquarePagView, new PAGLoaderOption(2));
            }
        }
    }

    private final void bindSquareAvatarHeartContainer(SquareAvatarItem data, OnlineStatus status, IStickersChangedListener stickersChangedListener) {
        Object obj;
        IMapItemViewManager viewManager;
        MapItemController controller = getController();
        int currentZoomLevel = (controller == null || (viewManager = controller.getViewManager()) == null) ? 0 : viewManager.getCurrentZoomLevel();
        if (!data.isMe() && currentZoomLevel >= 2) {
            String uin = data.getUin();
            Stickers stickers = data.getStickers();
            RelationType relationType = data.getExtra().getRelationType();
            boolean z16 = relationType != RelationType.STRANGER;
            Iterator<T> it = stickers.getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                StickerItem stickerItem = (StickerItem) obj;
                if ((stickerItem.getType() == StickerType.Like || stickerItem.getType() == StickerType.Interact) && stickerItem.isMe()) {
                    break;
                }
            }
            boolean z17 = ((StickerItem) obj) != null;
            SquareBaseKt.getSquareLog().i(TAG, "SquareAvatarHeart uin=" + uin + ", hasMeLike=" + z17 + ", richStatus=" + status.getRichStatus() + ", title=" + status.getTitle());
            if (!SquareAvatarItemKt.isBasicStatus(status) && z16 && !z17) {
                this.squareAvatarLikeContainerCanShow = true;
                FrameLayout frameLayout = this.binding.squareAvatarHeartContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarHeartContainer");
                frameLayout.setVisibility(0);
                if (stickersChangedListener == null) {
                    stickersChangedListener = this;
                }
                initOperateLikePanel(uin, stickers, stickersChangedListener, relationType);
            } else {
                this.squareAvatarLikeContainerCanShow = false;
                FrameLayout frameLayout2 = this.binding.squareAvatarHeartContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.squareAvatarHeartContainer");
                frameLayout2.setVisibility(8);
            }
            SquareOperateLikePanel squareOperateLikePanel = this.squareOperateLikePanel;
            if (squareOperateLikePanel != null) {
                squareOperateLikePanel.updateView();
                return;
            }
            return;
        }
        FrameLayout frameLayout3 = this.binding.squareAvatarHeartContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.squareAvatarHeartContainer");
        ViewExtensionsKt.setVisibility(frameLayout3, false);
    }

    private final void bindStickersBanner(SquareAvatarItem data) {
        this.binding.stickersBanner.bindData(data.getStickers(), data.isMe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doBindBubbleSkin(final SquareBubbleInfo bubbleInfo) {
        this.binding.squareAvatarBubble.updateBubbleSkin(bubbleInfo);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        final Context context = itemView.getContext();
        if (!SquareBubbleSkinKt.useDefault(bubbleInfo)) {
            final int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 9);
            final int dip2 = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 1);
            BubbleSkinDownloadManager bubbleSkinDownloadManager = BubbleSkinDownloadManager.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bubbleSkinDownloadManager.loadBubbleNinePatchDrawable(context, new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$doBindBubbleSkin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Bitmap bitmap) {
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    View itemView2 = AvatarViewHolder.this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                    Context context2 = itemView2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                    NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context2.getResources(), bubbleInfo.getBitmap(), bitmap.getNinePatchChunk(), null, null);
                    LinearLayout linearLayout = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble.bubbleBg;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.squareAvatarFeedsBubble.bubbleBg");
                    linearLayout.setBackground(ninePatchDrawable);
                    ViewUtils viewUtils = ViewUtils.INSTANCE;
                    String arrow = bubbleInfo.getArrow();
                    SquareImageView squareImageView = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble.bubbleArrow;
                    Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.squareAvatarFeedsBubble.bubbleArrow");
                    viewUtils.loadImageDrawable(arrow, squareImageView);
                    LinearLayout linearLayout2 = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble.bubbleBg;
                    int i3 = dip;
                    int i16 = dip2;
                    linearLayout2.setPadding(i3, i16, i3, i16);
                    LinearLayout linearLayout3 = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble.bubbleBg;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.squareAvatarFeedsBubble.bubbleBg");
                    linearLayout3.setMinimumWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 153));
                    FrameLayout frameLayout = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble.bubbleIcon;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarFeedsBubble.bubbleIcon");
                    Drawable background = frameLayout.getBackground();
                    if (!(background instanceof GradientDrawable)) {
                        background = null;
                    }
                    GradientDrawable gradientDrawable = (GradientDrawable) background;
                    if (gradientDrawable != null) {
                        float dip3 = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 6);
                        gradientDrawable.setCornerRadii(new float[]{dip3, dip3, 0.0f, 0.0f, 0.0f, 0.0f, dip3, dip3});
                    }
                }
            });
            FrameLayout frameLayout = this.binding.squareAvatarHeartContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarHeartContainer");
            ViewExtensionsKt.updateLayoutParams(frameLayout, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$doBindBubbleSkin$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                    invoke2(marginLayoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.leftMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(context, -9.0f);
                    receiver.bottomMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 5.0f);
                }
            });
            return;
        }
        LinearLayout linearLayout = this.binding.squareAvatarFeedsBubble.bubbleBg;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.squareAvatarFeedsBubble.bubbleBg");
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        linearLayout.setBackground(itemView2.getContext().getDrawable(R.drawable.gvs));
        SquareImageView squareImageView = this.binding.squareAvatarFeedsBubble.bubbleArrow;
        View itemView3 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
        squareImageView.setImageDrawable(itemView3.getContext().getDrawable(R.drawable.gw9));
        this.binding.squareAvatarFeedsBubble.bubbleBg.setPadding(0, 0, 0, 0);
        LinearLayout linearLayout2 = this.binding.squareAvatarFeedsBubble.bubbleBg;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.squareAvatarFeedsBubble.bubbleBg");
        linearLayout2.setMinimumWidth(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 133));
        FrameLayout frameLayout2 = this.binding.squareAvatarFeedsBubble.bubbleIcon;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.squareAvatarFeedsBubble.bubbleIcon");
        Drawable background = frameLayout2.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = null;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (gradientDrawable != null) {
            float dip3 = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 9);
            gradientDrawable.setCornerRadii(new float[]{dip3, dip3, 0.0f, 0.0f, 0.0f, 0.0f, dip3, dip3});
        }
        FrameLayout frameLayout3 = this.binding.squareAvatarHeartContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.squareAvatarHeartContainer");
        ViewExtensionsKt.updateLayoutParams(frameLayout3, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$doBindBubbleSkin$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                invoke2(marginLayoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.leftMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(context, -1.0f);
                receiver.bottomMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 16.0f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getAvatarBaseParams(SquareAvatarItem data) {
        LikeListInfo likeUnReadInfo;
        LikeListInfo likeUnReadInfo2;
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_zhutai_ketai", Integer.valueOf(!data.isMe() ? 1 : 0));
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(onlineStatus != null ? onlineStatus.getTopStatusId() : 0));
        Integer richStatusId = SquareResourceManagerKt.getRichStatusId(data);
        linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
        linkedHashMap.put("zplan_other_user_qq", data.getUin());
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_BUILDING_AREA, Integer.valueOf(data.getLocation().getArea()));
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_BUILDING_RANK, Integer.valueOf(data.getLocation().getRank()));
        linkedHashMap.put(SquareReportConst.Key.KEY_STICKER_BEAT_COUNT, Integer.valueOf(data.getStickers().getInteractNum()));
        linkedHashMap.put(SquareReportConst.Key.KEY_STICKER_NEW_BEAT_COUNT, Integer.valueOf(data.getStickers().getNewInteractNum()));
        linkedHashMap.put(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_LIKES, Integer.valueOf(data.getStickers().getLikeNum()));
        linkedHashMap.put(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_NEW_LIKES, Integer.valueOf(data.getStickers().getNewLikeNum()));
        linkedHashMap.put(SquareReportConst.Key.KEY_STICKER_IS_SUBJECT_LIKE, Integer.valueOf(data.getStickers().hasMyLike() ? 1 : 0));
        if (data.isMe()) {
            SquareAvatarExtra extra = data.getExtra();
            int unReadCount = (extra == null || (likeUnReadInfo2 = extra.getLikeUnReadInfo()) == null) ? 0 : likeUnReadInfo2.getUnReadCount();
            SquareAvatarExtra extra2 = data.getExtra();
            linkedHashMap.put(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf((unReadCount <= 0 || ((extra2 == null || (likeUnReadInfo = extra2.getLikeUnReadInfo()) == null) ? false : likeUnReadInfo.getHasReaded())) ? 0 : 1));
            linkedHashMap.put("zplan_unread_message_number", Integer.valueOf(unReadCount));
        } else {
            linkedHashMap.put(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf(data.getExtra().unReadCount() > 0 ? 1 : 0));
            linkedHashMap.put("zplan_unread_message_number", Integer.valueOf(data.getExtra().unReadCount()));
        }
        linkedHashMap.put(SquareReportConst.Key.KEY_IS_CHANGE_NEW_TIPS, Integer.valueOf((data.hasNewFlag(1) || data.hasNewFlag(2)) ? 1 : 0));
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_IS_DYNAMIC, Integer.valueOf(data.isMe() ? 1 : 0));
        linkedHashMap.put(SquareReportConst.Key.KEY_IS_NEW_DRESS, Integer.valueOf(data.hasNewFlag(2) ? 1 : 0));
        linkedHashMap.put(SquareReportConst.Key.KEY_IS_NEW_STATUS, Integer.valueOf(data.hasNewFlag(1) ? 1 : 0));
        linkedHashMap.put("pgid", checkNearby);
        linkedHashMap.put("dt_pgid", checkNearby);
        return linkedHashMap;
    }

    private final void initOperateLikePanel(String uin, Stickers stickers, IStickersChangedListener stickersChangedListener, RelationType relationType) {
        if (this.squareOperateLikePanel == null && relationType != RelationType.SELF) {
            boolean z16 = relationType != RelationType.STRANGER;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            SquareOperateLikePanel squareOperateLikePanel = new SquareOperateLikePanel(context, null, uin, z16, stickers, stickersChangedListener);
            this.squareOperateLikePanel = squareOperateLikePanel;
            this.binding.squareAvatarHeartContainer.removeAllViews();
            this.binding.squareAvatarHeartContainer.addView(squareOperateLikePanel, new LinearLayout.LayoutParams(-2, -1));
        }
    }

    private final void onBeatCustomText(SquareAvatarItem data) {
        String customText;
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        if (onlineStatus == null || (customText = onlineStatus.getCustomText()) == null) {
            return;
        }
        if (customText.length() > 0) {
            if (data.isMe()) {
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                commonUtils.showToast(context, R.string.xed, 1);
            }
            OnlineStatus onlineStatus2 = data.getExtra().getOnlineStatus();
            if (onlineStatus2 != null) {
                onlineStatus2.setCustomText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDoubleClick(View v3) {
        MapItemController controller;
        IMapViewListener listener;
        if (this.clickUtils.isFastDoubleClick() || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        listener.onDoubleClick(this, getIndex(), getData(), 8);
    }

    private final void onUpdateAvatarStatus(int index, SquareAvatarItem data) {
        FilamentAvatarCoverUri filamentCoverUrl;
        IMapLocator locator;
        SquareBaseKt.getSquareLog().i(TAG, "onUpdateAvatarStatus: index=" + index + ", name=" + data.getNickName() + ", resource=" + SquareResourceManagerKt.getResource(data));
        MapItemController controller = getController();
        if (controller != null && (locator = controller.getLocator()) != null) {
            setLayoutParams(locator.getItemPosition(index));
        }
        resizeAvatar(data);
        String str = null;
        bindExtraBubble$default(this, data, false, 2, null);
        Resource resource = SquareResourceManagerKt.getResource(data);
        this.currentResource = resource;
        bindNickName(data, resource);
        IBaseResourceManager.DefaultImpls.showAvatar$default(getRm(), data, resource, null, 4, null);
        getAvatar().setVideoViewVisibility(false);
        IBaseResourceManager.DefaultImpls.playAvatar$default(getRm(), data, resource, new IAvatarAnimListener() { // from class: com.tencent.state.square.holder.AvatarViewHolder$onUpdateAvatarStatus$2
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                AvatarViewHolder.this.getAvatar().setVideoViewVisibility(true);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int i3) {
                IAvatarAnimListener.DefaultImpls.onPlayError(this, i3);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IAvatarAnimListener.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
            }
        }, 0L, false, 8, null);
        if (resource != null && resource.getIsDefault()) {
            getRm().startRecord(data, this);
        }
        Resource userResource = data.getUserResource();
        if (userResource != null && (filamentCoverUrl = userResource.getFilamentCoverUrl()) != null) {
            str = filamentCoverUrl.encode();
        }
        updateCover(str);
    }

    private final void onUpdateFixedState(SquareAvatarItem data) {
        if (this.fixedIconView == null) {
            bindFixed(data);
        }
        FixedIconView fixedIconView = this.fixedIconView;
        if (fixedIconView != null) {
            fixedIconView.onUpdateFixedState(data);
        }
    }

    private final void reportStateBubbleExp(SquareAvatarItem data) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AvatarViewHolder$reportStateBubbleExp$1(this, data, null), 3, null);
    }

    private final void resetAvatarAlpha(SquareAvatarItem data) {
        float f16 = 1.0f;
        if (!data.isMe()) {
            getAvatar().setAlpha(1.0f);
            return;
        }
        FrameLayout frameLayout = this.binding.bornPag;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bornPag");
        if (frameLayout.getVisibility() == 0) {
            return;
        }
        SquareAvatarView avatar = getAvatar();
        MapItemController controller = getController();
        if (controller != null && !controller.getHasCheckRoleBornAnim()) {
            f16 = 0.0f;
        }
        avatar.setAlpha(f16);
    }

    private final void resizeFlowerViewSize(final Location location) {
        FlowerLayoutView flowerLayoutView = this.binding.flowerView;
        Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
        ViewExtensionsKt.updateLayoutParams(flowerLayoutView, new Function1<ViewGroup.LayoutParams, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$resizeFlowerViewSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGroup.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.height = Location.this.getWidth() / 3;
            }
        });
    }

    private final void startAlphaAnimation(final View view, final boolean isShow, final Function0<Unit> animationEnd) {
        Object tag = view.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        view.setTag(AnimationUtils.INSTANCE.startAlphaAnimation(view, isShow, 400L, new AnimatorListenerAdapter() { // from class: com.tencent.state.square.holder.AvatarViewHolder$startAlphaAnimation$alpha$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(isShow ? 0 : 4);
                view.setAlpha(1.0f);
                Function0 function0 = animationEnd;
                if (function0 != null) {
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                view.setAlpha(isShow ? 0.0f : 1.0f);
                view.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }
        }));
    }

    private final void updateAvatarLabel(SquareAvatarItem data) {
        if (data.getIsFromCache()) {
            return;
        }
        LinearLayout linearLayout = this.binding.flagsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flagsContainer");
        ViewExtensionsKt.setVisibility(linearLayout, true);
        LinearLayout linearLayout2 = this.binding.flagsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.flagsContainer");
        com.tencent.state.square.common.ViewExtensionsKt.forEachChild(linearLayout2, new Function1<View, Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$updateAvatarLabel$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setVisibility(8);
            }
        });
        if (!SquareResourceManagerKt.hasUnreadMessage(data) || data.isMe()) {
            CommonFootLabel footLabel = data.getExtra().getFootLabel();
            FootLabelInfo label = footLabel != null ? footLabel.getLabel() : null;
            if (label == null) {
                LinearLayout linearLayout3 = this.binding.avatarLabelContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.avatarLabelContainer");
                ViewExtensionsKt.setVisibility(linearLayout3, false);
                LinearLayout linearLayout4 = this.binding.footLabel;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.footLabel");
                ViewExtensionsKt.setVisibility(linearLayout4, false);
            } else if (label.getLabelType() == FootLabelInfo.Companion.LabelType.STRANGER) {
                LinearLayout linearLayout5 = this.binding.avatarLabelContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.avatarLabelContainer");
                ViewExtensionsKt.setVisibility(linearLayout5, true);
                LinearLayout linearLayout6 = this.binding.footLabel;
                Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.footLabel");
                ViewExtensionsKt.setVisibility(linearLayout6, false);
                bindFootLabelText(data);
            } else {
                LinearLayout linearLayout7 = this.binding.avatarLabelContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.avatarLabelContainer");
                ViewExtensionsKt.setVisibility(linearLayout7, false);
                LinearLayout linearLayout8 = this.binding.footLabel;
                Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.footLabel");
                ViewExtensionsKt.setVisibility(linearLayout8, true);
                bindFootLabel(data, label);
            }
        }
        bindNewInteractLabel(data.shouldShowNewInteractFlag(), data.isMe());
        bindNewDressLabel(data.shouldShowNewDressFlag(), data.isMe());
        updateFlower(data);
    }

    private final void updateFlower(SquareAvatarItem data) {
        if (!data.isMe() && data.getExtra().getFlowerCount() <= 0) {
            LinearLayout linearLayout = this.binding.flowerLabel;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flowerLabel");
            ViewExtensionsKt.setVisibility(linearLayout, false);
        } else {
            TextView textView = this.binding.flowerCount;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.flowerCount");
            textView.setText(String.valueOf(data.getExtra().getFlowerCount()));
            LinearLayout linearLayout2 = this.binding.flowerLabel;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.flowerLabel");
            ViewExtensionsKt.setVisibility(linearLayout2, true);
            this.binding.flowerLabel.setOnClickListener(this);
        }
        if (data.getExtra().getFlowerCount() > 0) {
            FlowerLayoutView flowerLayoutView = this.binding.flowerView;
            Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
            ViewExtensionsKt.setVisibility(flowerLayoutView, true);
            this.binding.flowerView.setFlowerCount(data.getExtra().getFlowerCount());
            return;
        }
        FlowerLayoutView flowerLayoutView2 = this.binding.flowerView;
        Intrinsics.checkNotNullExpressionValue(flowerLayoutView2, "binding.flowerView");
        ViewExtensionsKt.setVisibility(flowerLayoutView2, false);
    }

    private final void updateForRoleBornAnim(SquareAvatarItem data) {
        updateFlower(data);
        bindBlindBox(data);
        bindOthers(data);
        resetAvatarAlpha(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateNewSize(Resource resource) {
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem == null || SquareResourceManagerKt.isSameSize(squareAvatarItem, resource)) {
            return;
        }
        Size showSize = resource.getShowSize();
        squareAvatarItem.setLocation(MapItemKt.relocation(squareAvatarItem.getLocation(), showSize));
        setLayoutParams(squareAvatarItem.getItemViewLocation());
        resizeAvatar(showSize.getWidth(), showSize.getHeight());
    }

    public final void bindDebugTips(int index, SquareAvatarItem data) {
        if (SquareDebug.INSTANCE.getEnableAvatarDebugInfo()) {
            if (this.debugTipsView == null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                DebugTipsView debugTipsView = new DebugTipsView(context, null, 0, 6, null);
                this.debugTipsView = debugTipsView;
                this.binding.avatarContainer.addView(debugTipsView);
            }
            DebugTipsView debugTipsView2 = this.debugTipsView;
            if (debugTipsView2 != null) {
                View itemView2 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                debugTipsView2.setTipsText(index, data, itemView2.getZ());
            }
            DebugTipsView debugTipsView3 = this.debugTipsView;
            if (debugTipsView3 != null) {
                debugTipsView3.updateLayout(R.id.plj);
                return;
            }
            return;
        }
        DebugTipsView debugTipsView4 = this.debugTipsView;
        if (debugTipsView4 != null) {
            debugTipsView4.hide();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public float calculateElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem != null && squareAvatarItem.isMe()) {
            return location.getCenterY() + location.getHeight();
        }
        return location.getCenterY();
    }

    public final SquareAvatarView getAvatar() {
        return this.binding.composedAvatar.getAvatar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object getAvatarIconReportParams(SquareAvatarItem squareAvatarItem, Continuation<? super Map<String, Object>> continuation) {
        Object firstOrNull;
        int i3;
        Resource lookFront;
        if (squareAvatarItem.isDefault()) {
            i3 = 2;
        } else {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) squareAvatarItem.getActions());
            AvatarAction avatarAction = (AvatarAction) firstOrNull;
            i3 = (avatarAction == null || (lookFront = avatarAction.getLookFront()) == null || !lookFront.getIsDefault()) ? 1 : 0;
        }
        int i16 = squareAvatarItem.isStranger() ? -1 : 0;
        Map<String, Object> avatarBaseParams = getAvatarBaseParams(squareAvatarItem);
        avatarBaseParams.put(SquareReportConst.Key.KEY_AVATAR_TYPE, Boxing.boxInt(i3));
        avatarBaseParams.put(SquareReportConst.Key.KEY_UPDATE_BUBBLE, Boxing.boxInt(SquareResourceManagerKt.hasFeedsNewMessage(squareAvatarItem) ? 1 : 0));
        avatarBaseParams.put(SquareReportConst.Key.KEY_AVATAR_RELATIONSHIP, Boxing.boxInt(i16));
        return avatarBaseParams;
    }

    public final VasSquareItemAvatarBinding getBinding() {
        return this.binding;
    }

    public final ISquarePagView getIntimateBackPagView() {
        return this.intimateBackPagView;
    }

    public final ISquarePagView getIntimateFrontPagView() {
        return this.intimateFrontPagView;
    }

    public final View getName() {
        return this.binding.composedAvatar.getName();
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public SquareAvatarView getPlayerView() {
        return getAvatar();
    }

    public final AvatarViewMessageHelper getUnReadMessageHelper() {
        return this.unReadMessageHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onBackFromDetail() {
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem != null) {
            getName().setVisibility(0);
            bindFixed(squareAvatarItem);
            bindExtraBubble$default(this, squareAvatarItem, false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.battery.ISquareBatteryStatusObserver
    public void onBatteryInfoChange(int capacity, boolean levelChange, boolean powerConnect) {
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem == null || !squareAvatarItem.isMe()) {
            return;
        }
        boolean areEqual = Intrinsics.areEqual(this.currentResource, SquareBatteryStatusManager.INSTANCE.getCurBatteryLevelResource(squareAvatarItem.getUin(), squareAvatarItem.getIsGenderMale(), SquareRecordManager.INSTANCE.getDressKey()));
        if (!levelChange && areEqual) {
            doBind(squareAvatarItem, getIndex(), 12);
        } else {
            doBind(squareAvatarItem, getIndex(), 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onCenterScaled(boolean isScaleToCenter, boolean isAnimeEnd) {
        View view;
        AvatarLocationInfo locationInfo;
        String poi;
        View view2;
        if (!isAnimeEnd) {
            if (isScaleToCenter) {
                ISquarePagView iSquarePagView = this.meLocationPag;
                if (iSquarePagView != null && (view = iSquarePagView.getView()) != null) {
                    view.setVisibility(4);
                }
                FlowerLayoutView flowerLayoutView = this.binding.flowerView;
                Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
                flowerLayoutView.setVisibility(4);
                BlindBoxView blindBoxView = this.blindBoxView;
                if (blindBoxView != null) {
                    blindBoxView.hide();
                    return;
                }
                return;
            }
            getAvatar().resume();
            return;
        }
        if (isScaleToCenter) {
            if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                return;
            }
            getAvatar().pause();
            return;
        }
        ISquarePagView iSquarePagView2 = this.meLocationPag;
        if (iSquarePagView2 != null && (view2 = iSquarePagView2.getView()) != null) {
            view2.setVisibility(0);
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem != null && (locationInfo = squareAvatarItem.getLocationInfo()) != null && (poi = locationInfo.getPoi()) != null) {
            if (poi.length() > 0) {
                this.binding.squareAvatarBubble.showLocation();
            }
        }
        FlowerLayoutView flowerLayoutView2 = this.binding.flowerView;
        Intrinsics.checkNotNullExpressionValue(flowerLayoutView2, "binding.flowerView");
        flowerLayoutView2.setVisibility(0);
        SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) getData();
        if (squareAvatarItem2 != null) {
            bindBlindBox(squareAvatarItem2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void onChangeSource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        updateNewSize(resource);
        adjustBubbleLocation(resource);
        bindNickName((SquareAvatarItem) getData(), resource);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IResourceCallback.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        MapItemController controller = getController();
        if (controller == null || controller.getIsWelcomeScaleAnimDone()) {
            if (isMapMinimum()) {
                onMapMinimum(true);
                return;
            }
            SquareAvatarItem transform = transform(data);
            if (transform != null) {
                bindExtraBubble$default(this, transform, false, 2, null);
                bindOthers(transform);
                bindDebugTips(index, transform);
                bindFixed(transform);
                bindRingAnim(transform);
                bindLocation(transform);
                updateAvatarLabel(transform);
                bindBlindBox(transform);
                bindAvatarImageShow(transform);
                updateFlower(transform);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v3) {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return true;
        }
        listener.onItemLongClick(this, getIndex(), getData(), 8);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onMapMinimum(boolean isMin) {
        AvatarLocationInfo locationInfo;
        String poi;
        View view;
        View view2;
        if (isMin) {
            stop(true);
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
                getAvatar().setImageViewVisibility(true);
            }
            FixedIconView fixedIconView = this.fixedIconView;
            if (fixedIconView != null) {
                fixedIconView.hideAll();
            }
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
            avatarOnlineStatusSimpleBubble.setVisibility(8);
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv = vasSquareQzoneFeedBubbleBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.squareAvatarFeedsBubble.root");
            mRv.setVisibility(8);
            this.unReadMessageHelper.setContainerVisibility(8);
            FrameLayout frameLayout = this.binding.avatarPublishStatusBubble;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarPublishStatusBubble");
            frameLayout.setVisibility(8);
            LinearLayout linearLayout = this.binding.flagsContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flagsContainer");
            linearLayout.setVisibility(4);
            FrameLayout frameLayout2 = this.binding.squareAvatarHeartContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.squareAvatarHeartContainer");
            frameLayout2.setVisibility(8);
            this.binding.stickersBanner.hide();
            ISquarePagView iSquarePagView = this.meLocationPag;
            if (iSquarePagView != null && (view2 = iSquarePagView.getView()) != null) {
                view2.setVisibility(4);
            }
            FlowerLayoutView flowerLayoutView = this.binding.flowerView;
            Intrinsics.checkNotNullExpressionValue(flowerLayoutView, "binding.flowerView");
            flowerLayoutView.setVisibility(4);
            BlindBoxView blindBoxView = this.blindBoxView;
            if (blindBoxView != null) {
                blindBoxView.hide();
                return;
            }
            return;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem != null) {
            bindFixed(squareAvatarItem);
            bindExtraBubble$default(this, squareAvatarItem, false, 2, null);
            ISquarePagView iSquarePagView2 = this.meLocationPag;
            if (iSquarePagView2 != null && (view = iSquarePagView2.getView()) != null) {
                view.setVisibility(0);
            }
            SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) getData();
            if (squareAvatarItem2 != null && (locationInfo = squareAvatarItem2.getLocationInfo()) != null && (poi = locationInfo.getPoi()) != null) {
                if (poi.length() > 0) {
                    this.binding.squareAvatarBubble.showLocation();
                }
            }
            FlowerLayoutView flowerLayoutView2 = this.binding.flowerView;
            Intrinsics.checkNotNullExpressionValue(flowerLayoutView2, "binding.flowerView");
            flowerLayoutView2.setVisibility(0);
            bindBlindBox(squareAvatarItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn, Boolean doMinView) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        super.onMapZoomEnd(zoomLevel, scale, isZoomIn, doMinView);
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || !SquareAvatarItemKt.isBasicStatus(onlineStatus)) {
            if (zoomLevel >= 2) {
                FrameLayout frameLayout = this.binding.squareAvatarHeartContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarHeartContainer");
                frameLayout.setVisibility(this.squareAvatarLikeContainerCanShow ? 0 : 8);
            } else {
                FrameLayout frameLayout2 = this.binding.squareAvatarHeartContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.squareAvatarHeartContainer");
                frameLayout2.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IResourceCallback.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IResourceCallback.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IResourceCallback.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordError(int i3, RecordRequest request, int i16) {
        Intrinsics.checkNotNullParameter(request, "request");
        IResourceCallback.DefaultImpls.onRecordError(this, i3, request, i16);
    }

    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordStart(Resource resource, boolean z16) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        IResourceCallback.DefaultImpls.onRecordStart(this, resource, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.resource.IResourceCallback
    public void onRecordSuccess(RecordRequest request) {
        MapItemController controller;
        IMapPlayManager rpm;
        Resource resource;
        Intrinsics.checkNotNullParameter(request, "request");
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        Integer valueOf = (squareAvatarItem == null || (resource = SquareResourceManagerKt.getResource(squareAvatarItem)) == null) ? null : Integer.valueOf(resource.getActionId());
        Resource resource2 = request.getResource();
        if (!Intrinsics.areEqual(valueOf, resource2 != null ? Integer.valueOf(resource2.getActionId()) : null) || (controller = getController()) == null || (rpm = controller.getRpm()) == null) {
            return;
        }
        rpm.pauseAndEnsurePlay(getIndex());
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder, com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        this.binding.composedAvatar.bindNickName(new NickName("", false, null, 4, null));
        this.binding.flIcon.setImageDrawable(null);
        SquareImageView squareImageView = this.binding.iconNewStatus;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconNewStatus");
        squareImageView.setVisibility(8);
        FrameLayout frameLayout = this.binding.squareAvatarHeartContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarHeartContainer");
        frameLayout.setVisibility(8);
        SquareBatteryStatusManager.INSTANCE.removeObserver(this);
        this.unReadMessageHelper.onRecycled();
        this.currentResource = null;
        setPlayError(false);
        getAvatar().destroy();
        this.squareOperateLikePanel = null;
        super.onRecycled();
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IResourceCallback.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public boolean onScaleToDetail() {
        boolean onScaleToDetail = super.onScaleToDetail();
        if (onScaleToDetail) {
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
                getAvatar().setImageViewVisibility(true);
            }
            FixedIconView fixedIconView = this.fixedIconView;
            if (fixedIconView != null) {
                fixedIconView.hideAll();
            }
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
            avatarOnlineStatusSimpleBubble.setVisibility(8);
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv = vasSquareQzoneFeedBubbleBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.squareAvatarFeedsBubble.root");
            mRv.setVisibility(8);
            this.unReadMessageHelper.setContainerVisibility(8);
            FrameLayout frameLayout = this.binding.avatarPublishStatusBubble;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarPublishStatusBubble");
            frameLayout.setVisibility(8);
            LinearLayout linearLayout = this.binding.flagsContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flagsContainer");
            linearLayout.setVisibility(4);
            getName().setVisibility(4);
            FrameLayout frameLayout2 = this.binding.squareAvatarHeartContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.squareAvatarHeartContainer");
            frameLayout2.setVisibility(8);
            this.binding.stickersBanner.hide();
        }
        return onScaleToDetail;
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IResourceCallback.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IResourceCallback.DefaultImpls.onStaticSuccess(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.like.IStickersChangedListener
    public void onStickersChanged(String uin, Stickers stickers) {
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        Iterator<T> it = stickers.getItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            StickerItem stickerItem = (StickerItem) obj;
            if (stickerItem.getType() == StickerType.Like && stickerItem.isMe()) {
                break;
            }
        }
        if (((StickerItem) obj) != null) {
            SquareImageView squareImageView = this.binding.iconNewStatus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconNewStatus");
            if (squareImageView.getVisibility() == 0) {
                SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
                if (squareAvatarItem != null) {
                    squareAvatarItem.updateNewFlag(1, false);
                }
                SquareImageView squareImageView2 = this.binding.iconNewStatus;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.iconNewStatus");
                squareImageView2.setVisibility(8);
                SquareBaseKt.getSquareLog().i(TAG, "SquareAvatarHeart Hide iconNewStatus uin=" + uin);
            }
        }
        SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) getData();
        if (squareAvatarItem2 != null) {
            squareAvatarItem2.updateNewFlag(3, false);
            squareAvatarItem2.updateNewFlag(2, false);
            bindNewInteractLabel(false, squareAvatarItem2.isMe());
            bindNewDressLabel(false, squareAvatarItem2.isMe());
        }
        SquareOperateLikePanel squareOperateLikePanel = this.squareOperateLikePanel;
        if (squareOperateLikePanel != null) {
            squareOperateLikePanel.updateView();
        }
        SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(uin, stickers));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onVisible() {
        super.onVisible();
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem == null || !squareAvatarItem.getExtra().getNeedBubbleAnim()) {
            return;
        }
        squareAvatarItem.getExtra().setNeedBubbleAnim(false);
        this.binding.squareAvatarBubble.post(new Runnable() { // from class: com.tencent.state.square.holder.AvatarViewHolder$onVisible$1
            @Override // java.lang.Runnable
            public final void run() {
                AvatarViewHolder avatarViewHolder = AvatarViewHolder.this;
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = avatarViewHolder.getBinding().squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
                avatarViewHolder.startBubbleAnimation(avatarOnlineStatusSimpleBubble);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onZoomOverOut() {
        MapItemController controller;
        IMapViewListener listener;
        if (onScaleToDetail() && (controller = getController()) != null && (listener = controller.getListener()) != null) {
            listener.onZoomOverOut(this, getIndex(), getData());
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) getData();
        if (squareAvatarItem != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1(squareAvatarItem, null, this), 3, null);
        }
    }

    public final void setIntimateBackPagView(ISquarePagView iSquarePagView) {
        this.intimateBackPagView = iSquarePagView;
    }

    public final void setIntimateFrontPagView(ISquarePagView iSquarePagView) {
        this.intimateFrontPagView = iSquarePagView;
    }

    public final void setUnReadMessageHelper(AvatarViewMessageHelper avatarViewMessageHelper) {
        Intrinsics.checkNotNullParameter(avatarViewMessageHelper, "<set-?>");
        this.unReadMessageHelper = avatarViewMessageHelper;
    }

    private final void onUpdateUnreadMessage(SquareAvatarItem data) {
        bindExtraBubble(data, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBubbleAnimation(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 65.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setRepeatCount(1);
        anim.setDuration(330L);
        anim.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void bindAvatar(SquareAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareAvatarView avatar = getAvatar();
        Resource userResource = data.getUserResource();
        if (avatar.checkIsChange(userResource != null ? SquareItemKt.toMapPlayableSource$default(userResource, null, 1, null) : null)) {
            TextView textView = this.binding.avatarError;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarError");
            textView.setText("");
            getRm().setAvatarResource(data, false, this);
            resetAvatarAlpha(data);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AvatarViewHolder$bindAvatar$1(this, data, null), 3, null);
        }
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void resizeAvatar(SquareAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Location location = data.getLocation();
        resizeAvatar(location.getWidth(), location.getHeight());
        resizeFlowerViewSize(location);
        Resource userResource = data.getUserResource();
        if (userResource != null) {
            adjustBubbleLocation(userResource);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public SquareAvatarItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof SquareAvatarItem)) {
            data = null;
        }
        return (SquareAvatarItem) data;
    }

    private final void bindExtraBubble(SquareAvatarItem data, boolean needAnimation) {
        Long longOrNull;
        if (data.getIsFromCache()) {
            return;
        }
        int unReadCount = data.getExtra().unReadCount();
        this.unReadMessageHelper.bindUnreadCount(unReadCount);
        FrameLayout frameLayout = this.binding.squareAvatarHeartContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.squareAvatarHeartContainer");
        frameLayout.setVisibility(8);
        if (unReadCount > 0 && !data.isMe()) {
            SquareBaseKt.getSquareLog().i(TAG, "bindExtraBubble show unReadMessage");
            if (needAnimation && !this.unReadMessageHelper.isContainerVisible()) {
                startAlphaAnimation$default(this, this.unReadMessageHelper.getContainerView(), true, null, 4, null);
            } else {
                Object tag = this.unReadMessageHelper.getContainerView().getTag();
                if (!(tag instanceof ObjectAnimator)) {
                    tag = null;
                }
                ObjectAnimator objectAnimator = (ObjectAnimator) tag;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.unReadMessageHelper.setContainerVisibility(0);
            }
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble, "binding.squareAvatarBubble");
            Object tag2 = avatarOnlineStatusSimpleBubble.getTag();
            if (!(tag2 instanceof ObjectAnimator)) {
                tag2 = null;
            }
            ObjectAnimator objectAnimator2 = (ObjectAnimator) tag2;
            boolean z16 = true;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                z16 = false;
            }
            if (needAnimation) {
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble2 = this.binding.squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble2, "binding.squareAvatarBubble");
                if (avatarOnlineStatusSimpleBubble2.getVisibility() == 0 && z16) {
                    AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble3 = this.binding.squareAvatarBubble;
                    Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble3, "binding.squareAvatarBubble");
                    startAlphaAnimation(avatarOnlineStatusSimpleBubble3, false, new Function0<Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$bindExtraBubble$1
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
                            AvatarViewHolder.this.getBinding().stickersBanner.hide();
                            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble;
                            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
                            LinearLayout mRv = vasSquareQzoneFeedBubbleBinding.getMRv();
                            Intrinsics.checkNotNullExpressionValue(mRv, "binding.squareAvatarFeedsBubble.root");
                            mRv.setVisibility(8);
                            SquareImageView squareImageView = AvatarViewHolder.this.getBinding().iconNewStatus;
                            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconNewStatus");
                            squareImageView.setVisibility(8);
                        }
                    });
                    this.unReadMessageHelper.bindUnreadMsg(data);
                }
            }
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble4 = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble4, "binding.squareAvatarBubble");
            Object tag3 = avatarOnlineStatusSimpleBubble4.getTag();
            ObjectAnimator objectAnimator3 = (ObjectAnimator) (tag3 instanceof ObjectAnimator ? tag3 : null);
            if (objectAnimator3 != null) {
                objectAnimator3.cancel();
            }
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble5 = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble5, "binding.squareAvatarBubble");
            avatarOnlineStatusSimpleBubble5.setVisibility(8);
            this.binding.stickersBanner.hide();
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv = vasSquareQzoneFeedBubbleBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.squareAvatarFeedsBubble.root");
            mRv.setVisibility(8);
            SquareImageView squareImageView = this.binding.iconNewStatus;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconNewStatus");
            squareImageView.setVisibility(8);
            this.unReadMessageHelper.bindUnreadMsg(data);
        } else if (SquareResourceManagerKt.hasFeedsNewMessage(data)) {
            SquareBaseKt.getSquareLog().i(TAG, "bindExtraBubble show feedsNewMessage");
            TextView textView = this.binding.squareAvatarFeedsBubble.feedsNewTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.squareAvatarFeedsBubble.feedsNewTips");
            textView.setText(Square.INSTANCE.getConfig().getCommonUtils().getQZoneFeedsBubbleText());
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding2 = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding2, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv2 = vasSquareQzoneFeedBubbleBinding2.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv2, "binding.squareAvatarFeedsBubble.root");
            mRv2.setVisibility(0);
            FrameLayout frameLayout2 = this.binding.avatarPublishStatusBubble;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarPublishStatusBubble");
            frameLayout2.setVisibility(8);
            AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble6 = this.binding.squareAvatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble6, "binding.squareAvatarBubble");
            avatarOnlineStatusSimpleBubble6.setVisibility(8);
            this.binding.stickersBanner.hide();
            SquareImageView squareImageView2 = this.binding.iconNewStatus;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.iconNewStatus");
            squareImageView2.setVisibility(8);
            this.unReadMessageHelper.setContainerVisibility(8);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(data.getUin());
            if (longOrNull != null) {
                SquareQZoneFeedsManager.INSTANCE.reportFeedsBubbleExpose(longOrNull.longValue(), data.getFeedInfo().getId());
            }
            IReporter iReporter = this.reporter;
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding3 = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding3, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv3 = vasSquareQzoneFeedBubbleBinding3.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv3, "binding.squareAvatarFeedsBubble.root");
            iReporter.setElementInfo(mRv3, SquareReportConst.ElementId.ELEMENT_ID_SPACE_UPDATE_BUBBLE, new LinkedHashMap(), false, false);
            IReporter iReporter2 = this.reporter;
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding4 = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding4, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv4 = vasSquareQzoneFeedBubbleBinding4.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv4, "binding.squareAvatarFeedsBubble.root");
            iReporter2.reportEvent("imp", mRv4, new LinkedHashMap());
        } else {
            if (needAnimation && this.unReadMessageHelper.isContainerVisible()) {
                startAlphaAnimation(this.unReadMessageHelper.getContainerView(), false, new Function0<Unit>() { // from class: com.tencent.state.square.holder.AvatarViewHolder$bindExtraBubble$3
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
                        AvatarViewHolder.this.getUnReadMessageHelper().hideMessageContent();
                        VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding5 = AvatarViewHolder.this.getBinding().squareAvatarFeedsBubble;
                        Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding5, "binding.squareAvatarFeedsBubble");
                        LinearLayout mRv5 = vasSquareQzoneFeedBubbleBinding5.getMRv();
                        Intrinsics.checkNotNullExpressionValue(mRv5, "binding.squareAvatarFeedsBubble.root");
                        mRv5.setVisibility(8);
                    }
                });
            } else {
                this.unReadMessageHelper.hideMessageContent();
                VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding5 = this.binding.squareAvatarFeedsBubble;
                Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding5, "binding.squareAvatarFeedsBubble");
                LinearLayout mRv5 = vasSquareQzoneFeedBubbleBinding5.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv5, "binding.squareAvatarFeedsBubble.root");
                mRv5.setVisibility(8);
            }
            OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
            if (onlineStatus == null) {
                if (data.isMe()) {
                    if (needAnimation) {
                        FrameLayout frameLayout3 = this.binding.avatarPublishStatusBubble;
                        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.avatarPublishStatusBubble");
                        if (frameLayout3.getVisibility() != 0) {
                            FrameLayout frameLayout4 = this.binding.avatarPublishStatusBubble;
                            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.avatarPublishStatusBubble");
                            startAlphaAnimation$default(this, frameLayout4, true, null, 4, null);
                            FrameLayout frameLayout5 = this.binding.squareAvatarHeartContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.squareAvatarHeartContainer");
                            frameLayout5.setVisibility(8);
                        }
                    }
                    FrameLayout frameLayout6 = this.binding.avatarPublishStatusBubble;
                    Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.avatarPublishStatusBubble");
                    frameLayout6.setVisibility(0);
                    FrameLayout frameLayout52 = this.binding.squareAvatarHeartContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout52, "binding.squareAvatarHeartContainer");
                    frameLayout52.setVisibility(8);
                }
                if (needAnimation) {
                    AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble7 = this.binding.squareAvatarBubble;
                    Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble7, "binding.squareAvatarBubble");
                    if (avatarOnlineStatusSimpleBubble7.getVisibility() == 0) {
                        AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble8 = this.binding.squareAvatarBubble;
                        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble8, "binding.squareAvatarBubble");
                        startAlphaAnimation$default(this, avatarOnlineStatusSimpleBubble8, false, null, 4, null);
                        SquareImageView squareImageView3 = this.binding.iconNewStatus;
                        Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.iconNewStatus");
                        squareImageView3.setVisibility(8);
                    }
                }
                AvatarOnlineStatusSimpleBubble avatarOnlineStatusSimpleBubble9 = this.binding.squareAvatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusSimpleBubble9, "binding.squareAvatarBubble");
                avatarOnlineStatusSimpleBubble9.setVisibility(8);
                this.binding.stickersBanner.hide();
                SquareImageView squareImageView32 = this.binding.iconNewStatus;
                Intrinsics.checkNotNullExpressionValue(squareImageView32, "binding.iconNewStatus");
                squareImageView32.setVisibility(8);
            } else {
                if (needAnimation) {
                    FrameLayout frameLayout7 = this.binding.avatarPublishStatusBubble;
                    Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.avatarPublishStatusBubble");
                    if (frameLayout7.getVisibility() == 0) {
                        FrameLayout frameLayout8 = this.binding.avatarPublishStatusBubble;
                        Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.avatarPublishStatusBubble");
                        startAlphaAnimation$default(this, frameLayout8, false, null, 4, null);
                        bindOnlineStatusBubble$default(this, data, onlineStatus, false, needAnimation, 4, null);
                    }
                }
                FrameLayout frameLayout9 = this.binding.avatarPublishStatusBubble;
                Intrinsics.checkNotNullExpressionValue(frameLayout9, "binding.avatarPublishStatusBubble");
                frameLayout9.setVisibility(8);
                bindOnlineStatusBubble$default(this, data, onlineStatus, false, needAnimation, 4, null);
            }
        }
        bindBatteryObserver(data);
        updateAvatarLabel(data);
        bindBubbleSkin(data);
    }

    private final void bindLocation(SquareAvatarItem data) {
        if (data != null) {
            AvatarLocationInfo locationInfo = data.getLocationInfo();
            this.binding.squareAvatarBubble.bindLocationInfo(data.getUin(), locationInfo);
            if (locationInfo.getPoiId().length() > 0) {
                this.binding.squareAvatarBubble.reportLocation(data.getUin(), locationInfo.getPoiId());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.tencent.state.map.MapItem] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.state.map.MapItem] */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        MapItemController controller;
        IMapViewListener listener;
        IMapViewListener listener2;
        Long longOrNull;
        boolean doJumpToQZone;
        MapItemController controller2;
        IMapViewListener listener3;
        QZoneFeedsInfo feedInfo;
        IMapViewListener listener4;
        SquareAvatarItem squareAvatarItem;
        SquareAvatarExtra extra;
        IMapViewListener listener5;
        IMapViewListener listener6;
        SquareAvatarExtra extra2;
        OnlineStatus onlineStatus;
        SpecialStatus extraData;
        SongInfo songInfo;
        String songId;
        if (this.clickUtils.isFastDoubleClick()) {
            return;
        }
        String str = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pbs) {
            SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) getData();
            if (squareAvatarItem2 == null || (extra2 = squareAvatarItem2.getExtra()) == null || (onlineStatus = extra2.getOnlineStatus()) == null || (extraData = onlineStatus.getExtraData()) == null || (songInfo = extraData.getSongInfo()) == null || (songId = songInfo.getSongId()) == null) {
                return;
            }
            IRouter router = Square.INSTANCE.getConfig().getRouter();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            router.routeToSongPage(context, songId);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pc6) {
            MapItemController controller3 = getController();
            if (controller3 == null || (listener6 = controller3.getListener()) == null) {
                return;
            }
            IMapViewListener.DefaultImpls.onItemClicked$default(listener6, this, getIndex(), getData(), 1, null, 16, null);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pcj) {
            MapItemController controller4 = getController();
            if (controller4 == null || (listener5 = controller4.getListener()) == null) {
                return;
            }
            IMapViewListener.DefaultImpls.onItemClicked$default(listener5, this, getIndex(), getData(), 2, null, 16, null);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pcg) {
            SquareAvatarItem squareAvatarItem3 = (SquareAvatarItem) getData();
            if (((squareAvatarItem3 == null || (extra = squareAvatarItem3.getExtra()) == null) ? 0 : extra.unReadCount()) > 0 && (squareAvatarItem = (SquareAvatarItem) getData()) != null) {
                reportBubbleEvent$default(this, "clck", squareAvatarItem.getUin(), squareAvatarItem.getExtra().unReadCount(), squareAvatarItem.getExtra().messageType() == MsgType.PTT, 1, null, 32, null);
            }
            MapItemController controller5 = getController();
            if (controller5 == null || (listener4 = controller5.getListener()) == null) {
                return;
            }
            IMapViewListener.DefaultImpls.onItemClicked$default(listener4, this, getIndex(), getData(), 5, null, 16, null);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pcl) {
            MapViewHolder.doScaleToDetail$default(this, 3, null, 2, null);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.qmx) {
            SquareAvatarItem squareAvatarItem4 = (SquareAvatarItem) getData();
            if (squareAvatarItem4 != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AvatarViewHolder$onClick$$inlined$let$lambda$1(squareAvatarItem4, null, this), 3, null);
            }
            MapViewHolder.doScaleToDetail$default(this, 4, null, 2, null);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pbz) {
            MapViewHolder.doScaleToDetail$default(this, 8, null, 2, null);
            SquareAvatarItem squareAvatarItem5 = (SquareAvatarItem) getData();
            if (squareAvatarItem5 != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AvatarViewHolder$onClick$$inlined$let$lambda$2(squareAvatarItem5, null, this), 3, null);
                return;
            }
            return;
        }
        VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding = this.binding.squareAvatarFeedsBubble;
        Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding, "binding.squareAvatarFeedsBubble");
        LinearLayout mRv = vasSquareQzoneFeedBubbleBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.squareAvatarFeedsBubble.root");
        int id5 = mRv.getId();
        if (valueOf != null && valueOf.intValue() == id5) {
            SquareAvatarItem squareAvatarItem6 = (SquareAvatarItem) getData();
            if (squareAvatarItem6 != null) {
                SquareQZoneFeedsManager squareQZoneFeedsManager = SquareQZoneFeedsManager.INSTANCE;
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(squareAvatarItem6.getUin());
                SquareAvatarItem squareAvatarItem7 = (SquareAvatarItem) getData();
                if (squareAvatarItem7 != null && (feedInfo = squareAvatarItem7.getFeedInfo()) != null) {
                    str = feedInfo.getJumpUrl();
                }
                doJumpToQZone = squareQZoneFeedsManager.doJumpToQZone(context2, longOrNull, str, 1, (r17 & 16) != 0 ? "" : squareAvatarItem6.getFeedInfo().getId(), (r17 & 32) != 0, (r17 & 64) != 0);
                if (doJumpToQZone && (controller2 = getController()) != null && (listener3 = controller2.getListener()) != null) {
                    IMapViewListener.DefaultImpls.onItemClicked$default(listener3, this, getIndex(), getData(), 9, null, 16, null);
                }
            }
            IReporter iReporter = this.reporter;
            VasSquareQzoneFeedBubbleBinding vasSquareQzoneFeedBubbleBinding2 = this.binding.squareAvatarFeedsBubble;
            Intrinsics.checkNotNullExpressionValue(vasSquareQzoneFeedBubbleBinding2, "binding.squareAvatarFeedsBubble");
            LinearLayout mRv2 = vasSquareQzoneFeedBubbleBinding2.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv2, "binding.squareAvatarFeedsBubble.root");
            iReporter.reportEvent("clck", mRv2, new LinkedHashMap());
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.pvh) {
            MapItemController controller6 = getController();
            if (controller6 == null || (listener2 = controller6.getListener()) == null) {
                return;
            }
            IMapViewListener.DefaultImpls.onItemClicked$default(listener2, this, getIndex(), getData(), 16, null, 16, null);
            return;
        }
        if (valueOf == null || valueOf.intValue() != R.id.f163386pv0 || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        IMapViewListener.DefaultImpls.onItemClicked$default(listener, this, getIndex(), getData(), 14, null, 16, null);
    }

    @Override // com.tencent.state.view.BubbleElementEventListener
    public void onSongIconExpose(View view, boolean visible, boolean isPlaying) {
        Map<String, Object> mutableMapOf;
        if (view != null) {
            this.reporter.setElementInfo(view, SquareReportConst.ElementId.ELEMENT_ID_LISTEN_TO_MUSIC, new LinkedHashMap(), false, false);
            IReporter iReporter = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_button_display_type", String.valueOf(d.INSTANCE.b(isPlaying))));
            iReporter.reportEvent("imp", view, mutableMapOf);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onVisibilityChanged(boolean isVisible) {
        SquareAvatarItem squareAvatarItem;
        if (!isVisible || getAvatar().isPlaying() || (squareAvatarItem = (SquareAvatarItem) getData()) == null) {
            return;
        }
        bindAvatar(squareAvatarItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(SquareAvatarItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().i(TAG, "onBindViewHolder: index=" + index + ", data=" + data + " - " + data.getLocation());
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "this.itemView");
        view.setVisibility(0);
        if (Square.INSTANCE.getConfig().isDebug()) {
            TextView textView = this.binding.avatarError;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarError");
            textView.setVisibility(0);
        }
        getAvatar().setData(data);
        setLayoutParams(data.getItemViewLocation());
        resizeAvatar(data);
        bindAvatar(data);
        bindNickName(data, SquareResourceManagerKt.getResource(data));
        bindListeners();
        onFirstScreenCompleted(data, index);
    }

    private final void bindNickName(SquareAvatarItem data, Resource resource) {
        if (data == null || resource == null) {
            return;
        }
        this.binding.composedAvatar.bindNickName(new NickName(data.getNickName(), data.isMe(), null, 4, null));
    }

    @Override // com.tencent.state.view.BubbleElementEventListener
    public void onSongIconClick(View view, boolean isPlaying, String songMid) {
        Map<String, Object> mutableMapOf;
        if (view != null) {
            if (songMid != null) {
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                router.routeToSongPage(context, songMid);
            }
            IReporter iReporter = this.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_button_display_type", String.valueOf(d.INSTANCE.b(isPlaying))));
            iReporter.reportEvent("clck", view, mutableMapOf);
        }
    }

    static /* synthetic */ void bindExtraBubble$default(AvatarViewHolder avatarViewHolder, SquareAvatarItem squareAvatarItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        avatarViewHolder.bindExtraBubble(squareAvatarItem, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void startAlphaAnimation$default(AvatarViewHolder avatarViewHolder, View view, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        avatarViewHolder.startAlphaAnimation(view, z16, function0);
    }

    private final void bindNewDressLabel(boolean visible, boolean isMe) {
        if (isMe) {
            visible = false;
        }
        if (visible) {
            if (this.iconNewDress == null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                NewDressIconView newDressIconView = new NewDressIconView(context, null, 0, 6, null);
                this.iconNewDress = newDressIconView;
                this.binding.floatFlagsContainer.addView(newDressIconView, 0);
                NewDressIconView newDressIconView2 = this.iconNewDress;
                if (newDressIconView2 != null) {
                    newDressIconView2.updateLayout();
                }
            }
            NewDressIconView newDressIconView3 = this.iconNewDress;
            if (newDressIconView3 != null) {
                newDressIconView3.show();
                return;
            }
            return;
        }
        NewDressIconView newDressIconView4 = this.iconNewDress;
        if (newDressIconView4 != null) {
            newDressIconView4.hide();
        }
    }

    public final void reportBubbleEvent(String eventKey, String uin, int unReadNum, boolean isPtt, int from, View targetView) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(uin, "uin");
        String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        IReporter iReporter = this.reporter;
        View name = targetView != null ? targetView : getName();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to("zplan_unread_message_number", Integer.valueOf(unReadNum)), TuplesKt.to(SquareReportConst.Key.KEY_MESSAGE_BUBBLE_IS_PTT, Integer.valueOf(isPtt ? 1 : 0)), TuplesKt.to(SquareReportConst.Key.KEY_TAP_MESSAGE_BADGE_FROM, Integer.valueOf(from)), TuplesKt.to("dt_pgid", checkNearby), TuplesKt.to("pgid", checkNearby));
        iReporter.reportEvent(eventKey, name, mutableMapOf);
        if (Intrinsics.areEqual(eventKey, "clck")) {
            IReporter iReporter2 = this.reporter;
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_friend_or_group", 0), TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to("zplan_unread_message_number", Integer.valueOf(unReadNum)), TuplesKt.to(SquareReportConst.Key.KEY_HANDLE_MESSAGE_METHOD, 1), TuplesKt.to(SquareReportConst.Key.KEY_TAP_MESSAGE_BADGE_FROM, Integer.valueOf(from)));
            iReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HANDLE_MESSAGE, mutableMapOf2);
        }
    }

    static /* synthetic */ void bindOnlineStatusBubble$default(AvatarViewHolder avatarViewHolder, SquareAvatarItem squareAvatarItem, OnlineStatus onlineStatus, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        avatarViewHolder.bindOnlineStatusBubble(squareAvatarItem, onlineStatus, z16, z17);
    }

    public static /* synthetic */ void reportBubbleEvent$default(AvatarViewHolder avatarViewHolder, String str, String str2, int i3, boolean z16, int i16, View view, int i17, Object obj) {
        if ((i17 & 32) != 0) {
            view = null;
        }
        avatarViewHolder.reportBubbleEvent(str, str2, i3, z16, i16, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void doBind(SquareAvatarItem data, int index, int event) {
        FilamentAvatarCoverUri filamentCoverUrl;
        Intrinsics.checkNotNullParameter(data, "data");
        super.doBind((AvatarViewHolder) data, index, event);
        if (isMapMinimum()) {
            return;
        }
        switch (event) {
            case 2:
                onUpdateAvatarStatus(index, data);
                return;
            case 3:
                onUpdateUnreadMessage(data);
                return;
            case 4:
            case 5:
            case 10:
            case 14:
            case 17:
            case 18:
            case 19:
            case 21:
            case 27:
            case 28:
            default:
                return;
            case 6:
                onBeatCustomText(data);
                return;
            case 7:
                this.unReadMessageHelper.onUpdatePlayPttState(data);
                return;
            case 8:
                onUpdateFixedState(data);
                return;
            case 9:
                bindRingAnim(data);
                return;
            case 11:
                bindPlayIcon(data);
                return;
            case 12:
                bindNickName(data, SquareResourceManagerKt.getResource(data));
                bindExtraBubble(data, true);
                return;
            case 13:
                bindNewInfo(data);
                updateAvatarLabel(data);
                return;
            case 15:
                updateAvatarLabel(data);
                return;
            case 16:
                bindExtraBubble(data, false);
                return;
            case 20:
                bindLocation(data);
                return;
            case 22:
                updateFlower(data);
                return;
            case 23:
                bindBlindBox(data);
                return;
            case 24:
                updateForRoleBornAnim(data);
                return;
            case 25:
                bindStickersBanner(data);
                return;
            case 26:
                bindBubbleSkin(data);
                return;
            case 29:
                bindAvatarImageShow(data);
                return;
            case 30:
                Resource userResource = data.getUserResource();
                updateCover((userResource == null || (filamentCoverUrl = userResource.getFilamentCoverUrl()) == null) ? null : filamentCoverUrl.encode());
                return;
        }
    }
}
