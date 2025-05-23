package com.tencent.state.square.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.battery.ISquareBatteryStatusObserver;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasBlindBoxService;
import com.tencent.state.service.VasGetPosterService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.MultiMotionUser;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.PanelCategoryInfo;
import com.tencent.state.square.data.PanelInfo;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.data.SquareOnlineStatusDataKt;
import com.tencent.state.square.data.SquarePosterInfo;
import com.tencent.state.square.data.StatusActionInfo;
import com.tencent.state.square.data.StatusLockInfo;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareDatailMultiOperatorBinding;
import com.tencent.state.square.databinding.VasSquareDetailMeViewBinding;
import com.tencent.state.square.databinding.VasSquareInteractionRecordLayoutBinding;
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import com.tencent.state.square.guide.NoviceGuideRecordForReport;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.like.LikeAnimationPagView;
import com.tencent.state.square.like.LikeData;
import com.tencent.state.square.like.LikeDataManager;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.square.like.LikeListPanel;
import com.tencent.state.square.location.AvatarPoiHandler;
import com.tencent.state.square.location.LocationGuide;
import com.tencent.state.square.location.LocationIconView;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.mmkv.SMMKV;
import com.tencent.state.square.pickfriend.PickFriendView;
import com.tencent.state.square.pickfriend.service.FriendData;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.status.ISquareOnlineStatusPanelListener;
import com.tencent.state.status.NewStatusInfo;
import com.tencent.state.status.ReportData;
import com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper;
import com.tencent.state.status.SquareOnlineStatusViewPanel;
import com.tencent.state.status.StatusPanelData;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.SimplePagDownloadListener;
import com.tencent.state.utils.SquarePagFileUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.BubbleEditListener;
import com.tencent.state.view.BubbleStickersBanner;
import com.tencent.state.view.OnlineStatusBubbleViewHelper;
import com.tencent.state.view.OnlineStatusBubbleViewHelperKt;
import com.tencent.state.view.SquareImageView;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import vs4.o;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00c1\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u00c1\u0002B\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eB\u001f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010^\u001a\u00020SJ\b\u0010_\u001a\u00020SH\u0002J\b\u0010`\u001a\u00020SH\u0002J\u0006\u0010a\u001a\u00020SJ\u0006\u0010b\u001a\u00020SJ\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020eH\u0002J\u0018\u0010g\u001a\u00020S2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020\u001dH\u0002J\u0010\u0010j\u001a\u00020S2\b\u0010k\u001a\u0004\u0018\u00010lJ\u0018\u0010m\u001a\u00020S2\u0006\u0010d\u001a\u00020e2\b\b\u0002\u0010n\u001a\u00020\u001bJ\b\u0010o\u001a\u00020SH\u0002J\u0010\u0010p\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020rH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010t\u001a\u00020\u001bJ\n\u0010u\u001a\u0004\u0018\u00010!H\u0002J\n\u0010v\u001a\u0004\u0018\u00010\u001dH\u0002J\r\u0010w\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010xJ\u0006\u0010y\u001a\u00020SJ\b\u0010z\u001a\u00020SH\u0002J\b\u0010{\u001a\u00020SH\u0002J\u0018\u0010|\u001a\u00020S2\u0006\u0010q\u001a\u00020r2\b\b\u0002\u0010}\u001a\u00020\u001bJ\b\u0010~\u001a\u00020SH\u0016J\b\u0010\u007f\u001a\u00020SH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020SJ\u0017\u0010\u0081\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001H\u0002J\n\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010!J\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u001dH\u0002J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0017\u0010\u008d\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001H\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0010H\u0002J\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u00020\u001d2\u0007\u0010\u0092\u0001\u001a\u00020\u001d2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010\u0094\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u0001H\u0002J\"\u0010\u0095\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u00012\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u001bH\u0002J\u0017\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u00012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u001bH\u0002J\u0016\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020L0K2\u0007\u0010\u009b\u0001\u001a\u00020\u0010J\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010YJ\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001J%\u0010\u009f\u0001\u001a\u0004\u0018\u00010L2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00102\t\b\u0002\u0010\u00a0\u0001\u001a\u00020\u001b\u00a2\u0006\u0003\u0010\u00a1\u0001J\n\u0010\u00a2\u0001\u001a\u00030\u00a3\u0001H\u0016J\u0013\u0010\u00a4\u0001\u001a\u00020\u001b2\b\u0010\u00a5\u0001\u001a\u00030\u00a6\u0001H\u0016J\u0010\u0010\u00a7\u0001\u001a\u00020S2\u0007\u0010\u00a8\u0001\u001a\u00020\u001dJ\u0007\u0010\u00a9\u0001\u001a\u00020SJ\u0014\u0010\u00aa\u0001\u001a\u00020S2\t\b\u0002\u0010\u00ab\u0001\u001a\u00020\u001bH\u0002J\u0011\u0010\u00ac\u0001\u001a\u00020S2\u0006\u0010i\u001a\u00020\u001dH\u0002J\t\u0010\u00ad\u0001\u001a\u00020SH\u0002J\t\u0010\u00ae\u0001\u001a\u00020SH\u0002J\u001f\u0010\u00af\u0001\u001a\u00020S2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u0001J\t\u0010\u00b2\u0001\u001a\u00020SH\u0002J\t\u0010\u00b3\u0001\u001a\u00020SH\u0002J\t\u0010\u00b4\u0001\u001a\u00020SH\u0002J4\u0010\u00b5\u0001\u001a\u00020S2\u0007\u0010\u00b6\u0001\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'2\u0007\u0010\u00b7\u0001\u001a\u00020!2\u0006\u00104\u001a\u00020\u001b2\u0007\u0010\u00b8\u0001\u001a\u00020YJ\u001b\u0010\u00b9\u0001\u001a\u00020S2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0003\u0010\u00ba\u0001J%\u0010\u00bb\u0001\u001a\u00020\u001b2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00102\u000b\b\u0002\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0003\u0010\u00bd\u0001J\u0018\u0010\u00be\u0001\u001a\u00020S2\r\u0010\u00bf\u0001\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002J\t\u0010\u00c0\u0001\u001a\u00020SH\u0002J\t\u0010\u00c1\u0001\u001a\u00020SH\u0002J\t\u0010\u00c2\u0001\u001a\u00020SH\u0016J$\u0010\u00c3\u0001\u001a\u00020S2\u0007\u0010\u00c4\u0001\u001a\u00020\u00102\u0007\u0010\u00c5\u0001\u001a\u00020\u001b2\u0007\u0010\u00c6\u0001\u001a\u00020\u001bH\u0016J\t\u0010\u00c7\u0001\u001a\u00020SH\u0002J\u001e\u0010\u00c8\u0001\u001a\u00020S2\u0007\u0010\u00c9\u0001\u001a\u00020\u001d2\n\u0010\u00ca\u0001\u001a\u0005\u0018\u00010\u00cb\u0001H\u0016J\t\u0010\u00cc\u0001\u001a\u00020SH\u0016J\u0013\u0010\u00cc\u0001\u001a\u00020S2\b\u0010\u00cd\u0001\u001a\u00030\u00ce\u0001H\u0016J\t\u0010\u00cf\u0001\u001a\u00020SH\u0016J\u0013\u0010\u00d0\u0001\u001a\u00020S2\b\u0010\u00d1\u0001\u001a\u00030\u00a3\u0001H\u0002J\t\u0010\u00d2\u0001\u001a\u00020SH\u0016J\u0012\u0010\u00d3\u0001\u001a\u00020S2\u0007\u0010\u00d4\u0001\u001a\u00020\u001dH\u0016J/\u0010\u00d5\u0001\u001a\u00020S2\t\u0010\u00c9\u0001\u001a\u0004\u0018\u00010\u001d2\t\b\u0002\u0010\u00d6\u0001\u001a\u00020\u001b2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0003\u0010\u00d7\u0001J\u001b\u0010\u00d8\u0001\u001a\u00020S2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0003\u0010\u00ba\u0001J\u0012\u0010\u00d9\u0001\u001a\u00020S2\u0007\u0010\u00da\u0001\u001a\u000200H\u0016J\t\u0010\u00db\u0001\u001a\u00020\u001bH\u0016J\t\u0010\u00dc\u0001\u001a\u00020SH\u0016J\t\u0010\u00dd\u0001\u001a\u00020SH\u0016J\u0012\u0010\u00de\u0001\u001a\u00020S2\u0007\u0010\u00df\u0001\u001a\u00020\u001bH\u0016J#\u0010\u00e0\u0001\u001a\u00020S2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\t\u0010\u00e1\u0001\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0003\u0010\u00e2\u0001J\u0016\u0010\u00e3\u0001\u001a\u00020S2\u000b\b\u0002\u0010\u00c9\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010\u00e4\u0001\u001a\u00020SH\u0002J\u0007\u0010\u00e5\u0001\u001a\u00020SJ\u0013\u0010\u00e6\u0001\u001a\u00020S2\b\u0010\u00cd\u0001\u001a\u00030\u00ce\u0001H\u0016J\u0010\u0010\u00e7\u0001\u001a\u00020S2\u0007\u0010\u00e8\u0001\u001a\u00020\u001bJ0\u0010\u00e9\u0001\u001a\u00020S2\u0006\u0010d\u001a\u00020e2\u0007\u0010\u00ea\u0001\u001a\u00020\u001b2\u0014\u0010\u00bf\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020S0\u00eb\u0001H\u0016J\u0012\u0010\u00ec\u0001\u001a\u00020S2\u0007\u0010\u00ed\u0001\u001a\u00020\u0010H\u0016J#\u0010\u00ee\u0001\u001a\u00020S2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\t\u0010\u00e1\u0001\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0003\u0010\u00e2\u0001J$\u0010\u00ef\u0001\u001a\u00020S2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010\u00f0\u0001\u001a\u00030\u0088\u0001H\u0002\u00a2\u0006\u0003\u0010\u00f1\u0001J\u0012\u0010\u00f2\u0001\u001a\u00020S2\u0007\u0010\u00f3\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u00f4\u0001\u001a\u00020SH\u0002J&\u0010\u00f5\u0001\u001a\u00020S2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010\u00f0\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u00f6\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u00f7\u0001\u001a\u00020SH\u0002Jl\u0010\u00f8\u0001\u001a\u00020S2\t\u0010\u00f9\u0001\u001a\u0004\u0018\u00010\u001d2\t\u0010\u00fa\u0001\u001a\u0004\u0018\u00010\u00102\n\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u0088\u00012\b\u0010d\u001a\u0004\u0018\u00010e2\b\b\u0002\u0010}\u001a\u00020\u001b2'\b\u0002\u0010\u00fb\u0001\u001a \u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020S\u0018\u00010\u00fc\u0001\u00a2\u0006\u0003\u0010\u00fd\u0001J2\u0010\u00fe\u0001\u001a\u00020S2\n\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u0080\u00022\b\u0010*\u001a\u0004\u0018\u00010,2\u0007\u0010\u0081\u0002\u001a\u00020\u001b2\n\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002J\u0012\u0010\u0084\u0002\u001a\u00020S2\u0007\u0010\u0085\u0002\u001a\u00020\u001dH\u0002J\t\u0010\u0086\u0002\u001a\u00020SH\u0002J\u0010\u0010\u0087\u0002\u001a\u00020S2\u0007\u0010\u0088\u0002\u001a\u00020\u001dJ\u001b\u0010\u0089\u0002\u001a\u00020S2\u0007\u0010\u00e8\u0001\u001a\u00020\u001b2\t\b\u0002\u0010\u008a\u0002\u001a\u00020\u0010J\u0007\u0010\u008b\u0002\u001a\u00020SJ\u0007\u0010\u008c\u0002\u001a\u00020SJ\u001f\u0010\u008d\u0002\u001a\u00020S2\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\n\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0002J\u0007\u0010\u0090\u0002\u001a\u00020SJ\u0017\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u00022\t\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010\u0093\u0002\u001a\u00020SH\u0002J\u000f\u0010\u0094\u0002\u001a\u00020S2\u0006\u0010B\u001a\u00020CJ.\u0010\u0095\u0002\u001a\u00020S2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00102\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00102\t\u0010\u00e1\u0001\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0003\u0010\u0097\u0002J\u0011\u0010\u0098\u0002\u001a\u00020S2\u0006\u0010d\u001a\u00020eH\u0002J\t\u0010\u0099\u0002\u001a\u00020SH\u0002J\u0011\u0010\u009a\u0002\u001a\u00020S2\u0006\u0010d\u001a\u00020eH\u0002J\u0012\u0010\u009b\u0002\u001a\u00020S2\u0007\u0010\u00a8\u0001\u001a\u00020\u001dH\u0002J\u0012\u0010\u009c\u0002\u001a\u00020S2\u0007\u0010\u00a8\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u009d\u0002\u001a\u00020SH\u0002J\u0007\u0010\u009e\u0002\u001a\u00020SJ\u0012\u0010\u009f\u0002\u001a\u00020S2\u0007\u0010\u00a0\u0002\u001a\u00020\u001bH\u0002J\u0007\u0010\u00a1\u0002\u001a\u00020SJ\u0010\u0010\u00a2\u0002\u001a\u00020S2\u0007\u0010\u0081\u0002\u001a\u00020\u001bJ \u0010\u00a3\u0002\u001a\u00020S2\t\u0010\u00b7\u0001\u001a\u0004\u0018\u00010!2\n\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0002J\u0010\u0010\u00a4\u0002\u001a\u00020S2\u0007\u0010\u00a5\u0002\u001a\u00020\u001bJ\t\u0010\u00a6\u0002\u001a\u00020SH\u0002J\u0011\u0010\u00a7\u0002\u001a\u00020S2\b\u0010\u00a8\u0002\u001a\u00030\u00a9\u0002J\u0012\u0010\u00aa\u0002\u001a\u00020S2\u0007\u0010\u00ab\u0002\u001a\u00020eH\u0016J\u0010\u0010\u00ac\u0002\u001a\u00020S2\u0007\u0010\u00ad\u0002\u001a\u00020\u001bJ\t\u0010\u00ae\u0002\u001a\u00020SH\u0002J\u0014\u0010\u00af\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010LH\u0002J\u001e\u0010\u00b1\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010L2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001e\u0010\u00b2\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010L2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001e\u0010\u00b3\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010L2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001e\u0010\u00b4\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010L2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0011\u0010\u00b5\u0002\u001a\u00020S2\b\u0010k\u001a\u0004\u0018\u00010lJ\t\u0010\u00b6\u0002\u001a\u00020SH\u0002J\u0012\u0010\u00b7\u0002\u001a\u00020S2\u0007\u0010\u00b7\u0001\u001a\u00020!H\u0016J\u001a\u0010\u00b8\u0002\u001a\u00020S2\b\u0010\u00b9\u0002\u001a\u00030\u00ba\u00022\u0007\u0010\u00bb\u0002\u001a\u00020\u001bJ0\u0010\u00bc\u0002\u001a\u00020S2\t\u0010\u00b0\u0002\u001a\u0004\u0018\u00010L2\b\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0003\u0010\u00bd\u0002J\u0012\u0010\u00be\u0002\u001a\u00020S2\u0007\u0010\u00a0\u0002\u001a\u00020\u001bH\u0002J\u000f\u0010\u00bf\u0002\u001a\u0004\u0018\u00010\u001d*\u00020rH\u0002J\r\u0010\u00c0\u0002\u001a\u00020\u0010*\u00020rH\u0002R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u00106\u001a\u000207\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR6\u0010I\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K0Jj\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K`MX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010Q\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010RX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\\\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010]\u00a8\u0006\u00c2\u0002"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectMeView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/status/SquareOnlineStatusViewPanel$PanelItemClickListener;", "Lcom/tencent/state/status/ISquareOnlineStatusPanelListener;", "Landroid/os/Handler$Callback;", "Lcom/tencent/state/view/BubbleEditListener;", "Lcom/tencent/state/square/detail/IDetailParentView;", "Lcom/tencent/state/square/detail/DetailCommonView$CommonListener;", "Lcom/tencent/state/battery/ISquareBatteryStatusObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationPopWindow", "Lcom/tencent/state/square/like/LikeAnimationPagView;", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailMeViewBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareDetailMeViewBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "curMotionLock", "", "curRequestText", "", "currentBlindBoxUrl", "currentFriendUin", "currentSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "disableClick", "dressBubbleHelper", "Lcom/tencent/state/square/detail/DetailMeDressBubbleHelper;", "enableBatteryInfo", "entranceConfig", "Lcom/tencent/state/square/detail/DetailMeFragmentConfig;", "entranceSource", "Lcom/tencent/state/square/detail/EntranceSource;", "fragment", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/VasBaseFragment;", "hasBatteryLevelChangeInEditorPage", "hasPublish", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "inviteStatus", "isBlindBoxShow", "isEditing", "isEditorPage", "motionUnLockTip", "multiActionPanelHelper", "Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelHelper;", "getMultiActionPanelHelper", "()Lcom/tencent/state/status/SquareOnlineStatusMultiActionPanelHelper;", "myHandler", "Landroid/os/Handler;", "newStatusInfo", "Lcom/tencent/state/status/NewStatusInfo;", "getNewStatusInfo", "()Lcom/tencent/state/status/NewStatusInfo;", "setNewStatusInfo", "(Lcom/tencent/state/status/NewStatusInfo;)V", "poiHandler", "Lcom/tencent/state/square/location/AvatarPoiHandler;", "publishButTexToChoseFriend", "getPublishButTexToChoseFriend", "()Z", "setPublishButTexToChoseFriend", "(Z)V", "recordResourceMap", "Ljava/util/HashMap;", "", "Lcom/tencent/state/square/data/BaseResourceInfo;", "Lkotlin/collections/HashMap;", "reporter", "Lcom/tencent/state/square/IReporter;", "selectedAvatarItem", "showInteractionRecord", "Lkotlin/Function0;", "", "getShowInteractionRecord", "()Lkotlin/jvm/functions/Function0;", "setShowInteractionRecord", "(Lkotlin/jvm/functions/Function0;)V", "socialStatusListener", "Lcom/tencent/state/square/detail/DetailMeListener;", "squarePagRootView", "Lcom/tencent/state/square/api/ISquarePagView;", "withModelGender", "Ljava/lang/Integer;", "bindChangeStatusView", "bindElementInfo", "bindHostSimpleView", "bindLikeListBanner", "breakEdit", "canShowBatteryDialog", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "canShowMusicDialog", "changeClickFlag", "disable", "from", "changeLockStatus", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "changeStatus", "fromClick", "checkAndUpdatePublishButton", "checkPlayAvatar", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/RecordRequest;", "curSelectedAvatarItem", "needUpdateText", "currentPlayingAvatar", "currentReceiverUin", "currentSelectedActionId", "()Ljava/lang/Integer;", "destroy", "dismissCurAnimationPopWindow", "doEditBubble", "doRecordSuccess", "isBuyTheSame", "enterEdit", "enterEditTextView", "failPublish", "getAddStatusBtnReportParams", "", "", "getCommonView", "Lcom/tencent/state/square/detail/DetailCommonView;", "getCurAvatarItem", "getCurResource", "Lcom/tencent/state/square/data/Resource;", "getCurTextScale", "getCurrentMapPlayableSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "getCurrentResourceInfo", "getDressIconReportParams", "getEditTextLength", "getInteractionRecordBinding", "Lcom/tencent/state/square/databinding/VasSquareInteractionRecordLayoutBinding;", "getLimitNickName", "name", "limit", "getLocationReportData", "getPublishBtnReportParams", "isMultiAction", "getRealAvatarLocation", "Lcom/tencent/state/map/Location;", "isEditor", "getResourceList", DetailMeFragmentConfig.CURRENT_STATUS_ID, "getSocialStatusListener", "getStatusPanelView", "Lcom/tencent/state/status/SquareOnlineStatusViewPanel;", "getTargetActionFromActionGroup", "targetPicked", "(Ljava/lang/Integer;Z)Lcom/tencent/state/square/data/BaseResourceInfo;", "getView", "Landroid/view/View;", "handleMessage", "msg", "Landroid/os/Message;", "handleNewStatusUI", "url", "hideRecordLoading", "initBaseView", "forceShowBubble", "initBatteryObserverIfNeeded", "initBlindBoxEntrance", "initClickListener", "initData", "panelInfo", "Lcom/tencent/state/square/data/PanelInfo;", "initPagView", "initSelectAvatarItem", "initTouchEvent", "initView", "source", "data", "listener", "invalidateAllMultiResource", "(Ljava/lang/Integer;)V", "isCurStatus", "needCheckSelectAndPick", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Z", "loadPosterInfo", "callback", "needUpdateCustomText", "onBack", "onBackEvent", "onBatteryInfoChange", "capacity", "levelChange", "powerConnect", "onConfigInteraction", "onDecodeComplete", "uin", "avatar", "Landroid/graphics/Bitmap;", "onDoubleClickEvent", "e", "Landroid/view/MotionEvent;", "onEditTextChange", "onEnterQZoneClick", "view", "onEnterScaleAnimEnd", "onFragmentShowToast", "tip", "onFriendSelected", "isUpdateUinOnly", "(Ljava/lang/String;ZLjava/lang/Integer;)V", "onInvalidateInviteUI", "onInviteStateChanged", "state", "onIsEditEnter", "onLoadClick", "onMenuClick", "onPublicButtonStatus", "enable", "onResetStatus", "actionId", "(ILjava/lang/Integer;)V", "onSelectFriendClick", "onSelectLocation", "onSharePoster", "onSingleClickEvent", "onStatusChange", "success", "onStatusClick", "motionLock", "Lkotlin/Function1;", "onStatusPanelPageSelected", "pageIndex", "onStatusSelected", "playAvatar", "resource", "(Ljava/lang/Integer;Lcom/tencent/state/square/data/Resource;)V", "playLikeAnimation", "likeType", "playMultiMotionIfNeed", "playResource", "hasRecord", "recalculatePosition", "recordAvatar", "friendUin", "friendGender", "onRecordStart", "Lkotlin/Function3;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/OnlineStatus;ZLkotlin/jvm/functions/Function3;)V", "refreshCreateRoleRedDot", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "registered", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "reportConfigInteraction", "actionType", "reportConfigInteractionBtnShow", "reportNewStatusData", "eventId", "reportPublish", "errorCode", "resetAvatarAction", "resetCurrentResource", "resetDefaultResource", "action", "Lcom/tencent/state/square/data/AvatarAction;", "resetPanelView", "setImageUrl", "Landroid/graphics/drawable/Drawable;", "setLocationViewInfo", "setPoiHandler", "setSelectStatusId", DetailMeFragmentConfig.CURRENT_RICH_ID, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "showBatteryDialog", "showLikePanel", "showMusicDialog", "showPagUI", "showPngUI", "showPublishButton", "showRecordLoading", "showStatusPanel", ViewStickEventHelper.IS_SHOW, "showUnLockToast", "syncRolePageResult", "updateAvatarResource", "updateBlindBoxTips", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "updateBubbleLocation", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateBubbleView", "onlineStatus", "updateDraftSp", "isClear", "updateEditorBubbleLocation", "updateInteractionUI", "info", "updateInviteButton", "updateInviteSuccessUI", "updateInviteTips", "updateInviteUI", "updateLockStatus", "updateOperationIconsLocation", "updatePlayState", "updatePoiUI", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "isChange", "updateResourceAndPlay", "(Lcom/tencent/state/square/data/BaseResourceInfo;Lcom/tencent/state/square/data/SquareMultiMotionDetailData;Ljava/lang/Integer;)V", "updateSelectLocationUI", "getReceiverUin", "getStatusId", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeView extends FrameLayout implements SquareOnlineStatusViewPanel.PanelItemClickListener, ISquareOnlineStatusPanelListener, Handler.Callback, BubbleEditListener, IDetailParentView, DetailCommonView.CommonListener, ISquareBatteryStatusObserver {
    private static final long CHANGE_DRESS_DELAY_TIPS = 3000;
    private static final int COMMON_MARGIN = 45;
    private static final String CONFIG_INTERACTION_ICON_URL = "https://vat-zplan-1251316161.file.myqcloud.com/square/interact/poke_setting.png";
    private static final int LIMIT_MARGIN = 18;
    public static final int MAX_TEXT_NUM = 32;
    private static final int MESSAGE_CLICK = 1;
    private static final int NEW_STATUS_HEIGHT = 80;
    private static final int OPERATION_ICONS_HEIGHT = 107;
    private static final String TAG = "DetailSelectMeView";
    private LikeAnimationPagView animationPopWindow;
    private final VasSquareDetailMeViewBinding binding;
    private final FastClickUtils clickUtils;
    private boolean curMotionLock;
    private String curRequestText;
    private String currentBlindBoxUrl;
    private String currentFriendUin;
    private SquareAvatarItem currentSquareItem;
    private boolean disableClick;
    private final DetailMeDressBubbleHelper dressBubbleHelper;
    private final boolean enableBatteryInfo;
    private DetailMeFragmentConfig entranceConfig;
    private EntranceSource entranceSource;
    private WeakReference<VasBaseFragment> fragment;
    private boolean hasBatteryLevelChangeInEditorPage;
    private boolean hasPublish;
    private SquareMultiMotionDetailData inviteState;
    private int inviteStatus;
    private boolean isBlindBoxShow;
    private boolean isEditing;
    private boolean isEditorPage;
    private String motionUnLockTip;
    private final SquareOnlineStatusMultiActionPanelHelper multiActionPanelHelper;
    private Handler myHandler;
    private NewStatusInfo newStatusInfo;
    private AvatarPoiHandler poiHandler;
    private boolean publishButTexToChoseFriend;
    private HashMap<Integer, List<BaseResourceInfo>> recordResourceMap;
    private IReporter reporter;
    private SquareAvatarItem selectedAvatarItem;
    private Function0<Unit> showInteractionRecord;
    private DetailMeListener socialStatusListener;
    private ISquarePagView squarePagRootView;
    private Integer withModelGender;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectMeView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareDetailMeViewBinding inflate = VasSquareDetailMeViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeViewBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        FrameLayout frameLayout = inflate.onlineStatusMultiActionPanelContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.onlineStatusMultiActionPanelContainer");
        RecyclerView recyclerView = inflate.onlineStatusMultiActionPanel;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.onlineStatusMultiActionPanel");
        this.multiActionPanelHelper = new SquareOnlineStatusMultiActionPanelHelper(context2, this, frameLayout, recyclerView);
        this.recordResourceMap = new HashMap<>();
        this.clickUtils = new FastClickUtils(800L);
        this.curRequestText = "";
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.motionUnLockTip = "";
        this.dressBubbleHelper = new DetailMeDressBubbleHelper(this);
        initClickListener();
        recalculatePosition();
        inflate.onlineStatusPanel.setPanelListener(this);
        this.enableBatteryInfo = true;
    }

    private final void bindElementInfo() {
        IReporter iReporter = this.reporter;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
        Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
        iReporter.setElementInfo(avatarOnlineStatusDetailBubble, SquareReportConst.ElementId.ELEMENT_ID_STATE_BUBBLE, new LinkedHashMap(), false, false);
        IReporter iReporter2 = this.reporter;
        LinearLayout linearLayout = this.binding.changeStatusContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.changeStatusContainer");
        iReporter2.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_ADD_NEW_STATE, new LinkedHashMap(), false, false);
        IReporter iReporter3 = this.reporter;
        RelativeLayout relativeLayout = this.binding.operatorContainer.operatorEnterSmallHomeContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
        iReporter3.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_SMALL_HOME, new LinkedHashMap(), false, false);
        IReporter iReporter4 = this.reporter;
        Button button = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
        iReporter4.setElementInfo(button, SquareReportConst.ElementId.ELEMENT_ID_PUBLISH, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(this.binding.selector.getBtn(), SquareReportConst.ElementId.ELEMENT_ID_CHOOSE_FRIEND, new LinkedHashMap(), false, false);
        IReporter iReporter5 = this.reporter;
        Button button2 = this.binding.textEditComplete;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.textEditComplete");
        iReporter5.setElementInfo(button2, SquareReportConst.ElementId.ELEMENT_ID_EDIT_COMPLETE, new LinkedHashMap(), false, false);
        IReporter iReporter6 = this.reporter;
        View view = this.binding.darkView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
        iReporter6.setElementInfo(view, SquareReportConst.ElementId.ELEMENT_ID_EDIT_BLANK, new LinkedHashMap(), false, false);
        IReporter iReporter7 = this.reporter;
        SquareImageView squareImageView = this.binding.editCustomClearIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.editCustomClearIcon");
        iReporter7.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_EDIT_CLEAR, new LinkedHashMap(), false, false);
        IReporter iReporter8 = this.reporter;
        RelativeLayout relativeLayout2 = this.binding.operatorContainer.operatorEnterDressMallContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContaine\u2026orEnterDressMallContainer");
        iReporter8.setElementInfo(relativeLayout2, "em_zplan_mall_icon", new LinkedHashMap(), false, false);
        IReporter iReporter9 = this.reporter;
        RelativeLayout relativeLayout3 = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        iReporter9.setElementInfo(relativeLayout3, SquareReportConst.ElementId.ELEMENT_ID_SPACE_ENTRANCE, new LinkedHashMap(), false, false);
        IReporter iReporter10 = this.reporter;
        RelativeLayout relativeLayout4 = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContainer.singleOperatorContainer");
        iReporter10.setElementInfo(relativeLayout4, SquareReportConst.ElementId.ELEMENT_ID_SPACE_ENTRANCE, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(this.binding.commonView.getSetting(), SquareReportConst.ElementId.ELEMENT_ID_MORE_OPTIONS, new LinkedHashMap(), true, true);
        IReporter iReporter11 = this.reporter;
        LocationIconView locationIconView = this.binding.selectLocationBar;
        Intrinsics.checkNotNullExpressionValue(locationIconView, "binding.selectLocationBar");
        iReporter11.setElementInfo(locationIconView, SquareReportConst.ElementId.ELEMENT_ID_LOCATION_CHOOSE, new LinkedHashMap(), false, false);
        IReporter iReporter12 = this.reporter;
        VasSquareInteractionRecordLayoutBinding vasSquareInteractionRecordLayoutBinding = this.binding.interactionRecord;
        Intrinsics.checkNotNullExpressionValue(vasSquareInteractionRecordLayoutBinding, "binding.interactionRecord");
        FrameLayout mRv = vasSquareInteractionRecordLayoutBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.interactionRecord.root");
        iReporter12.setElementInfo(mRv, SquareReportConst.ElementId.ELEMENT_ID_SQUARE_BROWSE_HUDONG, new LinkedHashMap(), false, false);
        this.reporter.setElementInfo(this.binding.commonView.getPosterShare(), SquareReportConst.ElementId.ELEMENT_ID_POSTER_CREATE, new LinkedHashMap(), false, true);
        IReporter iReporter13 = this.reporter;
        RelativeLayout relativeLayout5 = this.binding.posterLoadingView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout5, "binding.posterLoadingView");
        iReporter13.setElementInfo(relativeLayout5, SquareReportConst.ElementId.ELEMENT_ID_POSTER_LOADING, new LinkedHashMap(), false, true);
        IReporter iReporter14 = this.reporter;
        FrameLayout frameLayout = this.binding.btnBlindBox;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.btnBlindBox");
        iReporter14.setElementInfo(frameLayout, SquareReportConst.ElementId.ELEMENT_ID_SQUARE_BLIND_BOX, new LinkedHashMap(), false, true);
        IReporter iReporter15 = this.reporter;
        BubbleStickersBanner bubbleStickersBanner = this.binding.stickersBanner;
        Intrinsics.checkNotNullExpressionValue(bubbleStickersBanner, "binding.stickersBanner");
        iReporter15.setElementInfo(bubbleStickersBanner, SquareReportConst.ElementId.ELEMENT_ID_STICKERS_BANNER, new LinkedHashMap(), false, false);
    }

    private final boolean canShowBatteryDialog(OnlineStatus status) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || !OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus)) {
            return OnlineStatusBubbleViewHelperKt.isBatteryStatus(status) && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_SHOW_BATTERY_STATUS_DIALOG, false, null, false, 12, null);
        }
        return false;
    }

    private final boolean canShowMusicDialog(OnlineStatus status) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || !SquareAvatarItemKt.isMusicStatus(onlineStatus)) {
            return SquareAvatarItemKt.isMusicStatus(status) && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.DIALOG_KEY_MUSIC_STATUS, false, null, false, 12, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeClickFlag(boolean disable, String from) {
        this.disableClick = disable;
        SquareBaseKt.getSquareLog().d(TAG, "[DMV] changeClickFlag, disable:" + disable + ", " + from);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkAndUpdatePublishButton() {
        boolean z16;
        SquareAvatarItem squareAvatarItem;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SquareAvatarExtra extra2;
        OnlineStatus onlineStatus2;
        SquareAvatarExtra extra3;
        OnlineStatus onlineStatus3;
        SquareAvatarExtra extra4;
        OnlineStatus onlineStatus4;
        SquareAvatarExtra extra5;
        OnlineStatus onlineStatus5;
        SquareAvatarExtra extra6;
        SquareAvatarItem squareAvatarItem2 = this.selectedAvatarItem;
        Integer num = null;
        boolean z17 = false;
        boolean z18 = ((squareAvatarItem2 == null || (extra6 = squareAvatarItem2.getExtra()) == null) ? null : extra6.getOnlineStatus()) != null;
        SquareAvatarItem squareAvatarItem3 = this.selectedAvatarItem;
        Integer valueOf = (squareAvatarItem3 == null || (extra5 = squareAvatarItem3.getExtra()) == null || (onlineStatus5 = extra5.getOnlineStatus()) == null) ? null : Integer.valueOf(onlineStatus5.getId());
        SquareAvatarItem squareAvatarItem4 = this.currentSquareItem;
        if (!(!Intrinsics.areEqual(valueOf, (squareAvatarItem4 == null || (extra4 = squareAvatarItem4.getExtra()) == null || (onlineStatus4 = extra4.getOnlineStatus()) == null) ? null : Integer.valueOf(onlineStatus4.getId())))) {
            SquareAvatarItem squareAvatarItem5 = this.currentSquareItem;
            BaseResourceInfo targetActionFromActionGroup = getTargetActionFromActionGroup((squareAvatarItem5 == null || (extra3 = squareAvatarItem5.getExtra()) == null || (onlineStatus3 = extra3.getOnlineStatus()) == null) ? null : Integer.valueOf(onlineStatus3.getId()), false);
            SquareAvatarItem squareAvatarItem6 = this.currentSquareItem;
            if (squareAvatarItem6 != null && (extra2 = squareAvatarItem6.getExtra()) != null && (onlineStatus2 = extra2.getOnlineStatus()) != null) {
                num = Integer.valueOf(onlineStatus2.getId());
            }
            if (!(!Intrinsics.areEqual(targetActionFromActionGroup, getTargetActionFromActionGroup(num, true)))) {
                z16 = false;
                String trulyText = this.binding.avatarBubble.getTrulyText();
                squareAvatarItem = this.currentSquareItem;
                if (squareAvatarItem != null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || (r5 = onlineStatus.getCustomText()) == null) {
                    String str = "";
                }
                boolean z19 = !Intrinsics.areEqual(trulyText, str);
                BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
                boolean z26 = currentResourceInfo == null && currentResourceInfo.getIsMultiAction() && this.currentFriendUin != null;
                AvatarPoiHandler avatarPoiHandler = this.poiHandler;
                boolean z27 = avatarPoiHandler == null && avatarPoiHandler.getIsPoiChange();
                BaseResourceInfo currentResourceInfo2 = getCurrentResourceInfo();
                boolean z28 = currentResourceInfo2 == null && currentResourceInfo2.getIsLock();
                if (z18 && ((z16 || z19 || z26 || z27) && !z28)) {
                    z17 = true;
                }
                if (z17) {
                    z17 = !this.curMotionLock;
                }
                onPublicButtonStatus((this.publishButTexToChoseFriend || currentSelectedActionId() == null) ? z17 : true);
            }
        }
        z16 = true;
        String trulyText2 = this.binding.avatarBubble.getTrulyText();
        squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
        }
        String str2 = "";
        boolean z192 = !Intrinsics.areEqual(trulyText2, str2);
        BaseResourceInfo currentResourceInfo3 = getCurrentResourceInfo();
        if (currentResourceInfo3 == null) {
        }
        AvatarPoiHandler avatarPoiHandler2 = this.poiHandler;
        if (avatarPoiHandler2 == null) {
        }
        BaseResourceInfo currentResourceInfo22 = getCurrentResourceInfo();
        if (currentResourceInfo22 == null) {
        }
        if (z18) {
            z17 = true;
        }
        if (z17) {
        }
        onPublicButtonStatus((this.publishButTexToChoseFriend || currentSelectedActionId() == null) ? z17 : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkPlayAvatar(RecordRequest request) {
        Resource resource;
        Resource resource2;
        if (isCurStatus$default(this, Integer.valueOf(getStatusId(request)), null, 2, null)) {
            BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(getStatusId(request)), false, 2, null);
            RecordResourceInfo displayResource$default = targetActionFromActionGroup$default != null ? BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, this.inviteState, this.currentFriendUin, null, 8, null) : null;
            Integer valueOf = (displayResource$default == null || (resource2 = displayResource$default.getResource()) == null) ? null : Integer.valueOf(resource2.getActionId());
            Resource resource3 = request.getResource();
            if (Intrinsics.areEqual(valueOf, resource3 != null ? Integer.valueOf(resource3.getActionId()) : null)) {
                if (displayResource$default == null || (resource = displayResource$default.getResource()) == null || !resource.isMultiAction()) {
                    return true;
                }
                return Intrinsics.areEqual(currentReceiverUin(), getReceiverUin(request));
            }
        }
        return false;
    }

    private final SquareAvatarItem currentPlayingAvatar() {
        if (this.isEditorPage) {
            return this.selectedAvatarItem;
        }
        return this.currentSquareItem;
    }

    private final String currentReceiverUin() {
        String str = this.currentFriendUin;
        if (str != null) {
            return str;
        }
        SquareMultiMotionDetailData squareMultiMotionDetailData = this.inviteState;
        if (squareMultiMotionDetailData != null) {
            return String.valueOf(squareMultiMotionDetailData.getOtherUin());
        }
        return null;
    }

    private final void dismissCurAnimationPopWindow() {
        try {
            LikeAnimationPagView likeAnimationPagView = this.animationPopWindow;
            if (likeAnimationPagView != null && likeAnimationPagView.isShowing()) {
                likeAnimationPagView.dismiss();
            }
            this.animationPopWindow = null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "dimiss animationPopWindow err.", th5);
        }
    }

    private final void doEditBubble() {
        if (this.isEditorPage) {
            View mainContainer = this.binding.avatarBubble.getMainContainer();
            if (mainContainer != null) {
                this.reporter.reportEvent("clck", mainContainer, new LinkedHashMap());
            }
        } else {
            bindChangeStatusView();
            IReporter iReporter = this.reporter;
            AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
            iReporter.reportEvent("clck", avatarOnlineStatusDetailBubble, new LinkedHashMap());
        }
        enterEditTextView();
    }

    private final void enterEditTextView() {
        int i3;
        Map<String, Object> mutableMapOf;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        String customText;
        checkAndUpdatePublishButton();
        updateInviteButton(getCurrentResourceInfo(), this.inviteState);
        updateInteractionUI(getCurrentResourceInfo());
        View view = this.binding.darkView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
        view.setVisibility(0);
        LinearLayout linearLayout = this.binding.customTextTitleGroup;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customTextTitleGroup");
        linearLayout.setVisibility(0);
        SquareImageView squareImageView = this.binding.editCustomClearIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.editCustomClearIcon");
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null && (onlineStatus = extra.getOnlineStatus()) != null && (customText = onlineStatus.getCustomText()) != null) {
            if (customText.length() == 0) {
                i3 = 8;
                squareImageView.setVisibility(i3);
                TextView textView = this.binding.editCustomTextNum;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.editCustomTextNum");
                textView.setText(getCurTextScale());
                Button button = this.binding.textEditComplete;
                Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
                button.setVisibility(0);
                AvatarOnlineStatusDetailBubble.showEditedView$default(this.binding.avatarBubble, IMMKV.DefaultImpls.decodeString$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, "", null, false, 12, null), false, 2, null);
                IReporter iReporter = this.reporter;
                Button button2 = this.binding.textEditComplete;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.textEditComplete");
                Pair[] pairArr = new Pair[1];
                String textString = this.binding.avatarBubble.getTextString();
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_SET_CUSTOMIZE_TEXT, Integer.valueOf(1 ^ ((textString != null || textString.length() == 0) ? 1 : 0)));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                iReporter.reportEvent("imp", button2, mutableMapOf);
            }
        }
        i3 = 0;
        squareImageView.setVisibility(i3);
        TextView textView2 = this.binding.editCustomTextNum;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.editCustomTextNum");
        textView2.setText(getCurTextScale());
        Button button3 = this.binding.textEditComplete;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.textEditComplete");
        button3.setVisibility(0);
        AvatarOnlineStatusDetailBubble.showEditedView$default(this.binding.avatarBubble, IMMKV.DefaultImpls.decodeString$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, "", null, false, 12, null), false, 2, null);
        IReporter iReporter2 = this.reporter;
        Button button22 = this.binding.textEditComplete;
        Intrinsics.checkNotNullExpressionValue(button22, "binding.textEditComplete");
        Pair[] pairArr2 = new Pair[1];
        String textString2 = this.binding.avatarBubble.getTextString();
        pairArr2[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_SET_CUSTOMIZE_TEXT, Integer.valueOf(1 ^ ((textString2 != null || textString2.length() == 0) ? 1 : 0)));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr2);
        iReporter2.reportEvent("imp", button22, mutableMapOf);
    }

    private final String getCurTextScale() {
        int editTextLength = getEditTextLength();
        if (editTextLength > 32) {
            String string = getResources().getString(R.string.xe7);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026social_edit_max_num_tips)");
            return string;
        }
        return editTextLength + "/32";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseResourceInfo getCurrentResourceInfo() {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        if (squareAvatarItem == null) {
            squareAvatarItem = this.currentSquareItem;
        }
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null) {
            return null;
        }
        return getTargetActionFromActionGroup$default(this, Integer.valueOf(onlineStatus.getId()), false, 2, null);
    }

    private final int getEditTextLength() {
        return OnlineStatusBubbleViewHelper.INSTANCE.getEditTextLength(this.binding.avatarBubble.getTextString());
    }

    private final String getLimitNickName(String name, int limit) {
        if (name.length() <= limit) {
            return name;
        }
        StringBuilder sb5 = new StringBuilder();
        String substring = name.substring(0, limit);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        sb5.append(substring);
        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        return sb5.toString();
    }

    private final Map<String, Object> getLocationReportData() {
        String str;
        String str2;
        Map<String, Object> mutableMapOf;
        AvatarPoiHandler avatarPoiHandler = this.poiHandler;
        if (avatarPoiHandler != null) {
            if (avatarPoiHandler == null) {
                str = "";
                str2 = str;
            } else {
                str2 = avatarPoiHandler.getSelectPoi().getPoiId();
                str = avatarPoiHandler.getSelectPoi().getPoi();
            }
            String str3 = Intrinsics.areEqual(str2, AvatarPoiHandler.INSTANCE.getINVALIDE_POI_ID()) ? "" : str2;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_SET_LOCATION, Integer.valueOf((str3.length() == 0 ? 1 : 0) ^ 1));
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_ID, str3);
            pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POI_NAME, str);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    private final String getReceiverUin(RecordRequest recordRequest) {
        Object extra = recordRequest.getExtra();
        if (!(extra instanceof RecordExtra)) {
            extra = null;
        }
        RecordExtra recordExtra = (RecordExtra) extra;
        if (recordExtra != null) {
            return recordExtra.getUin();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getStatusId(RecordRequest recordRequest) {
        OnlineStatus status;
        Object extra = recordRequest.getExtra();
        if (!(extra instanceof RecordExtra)) {
            extra = null;
        }
        RecordExtra recordExtra = (RecordExtra) extra;
        if (recordExtra == null || (status = recordExtra.getStatus()) == null) {
            return -1;
        }
        return status.getId();
    }

    private final void initBaseView(final boolean forceShowBubble) {
        SquareBaseKt.getSquareLog().i(TAG, "initBaseView");
        bindElementInfo();
        initTouchEvent();
        initPagView();
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initBaseView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
            
                if (r0 != false) goto L12;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                SquareAvatarItem squareAvatarItem;
                boolean z16;
                EntranceSource entranceSource;
                Function0<Unit> showInteractionRecord;
                boolean z17;
                SquareAvatarExtra extra;
                DetailSelectMeView.this.updateBubbleLocation();
                squareAvatarItem = DetailSelectMeView.this.currentSquareItem;
                if (((squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null) ? null : extra.getOnlineStatus()) == null) {
                    z17 = DetailSelectMeView.this.isEditorPage;
                }
                RelativeLayout relativeLayout = DetailSelectMeView.this.getBinding().avatarLocationView;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
                relativeLayout.setVisibility(0);
                DetailCommonView detailCommonView = DetailSelectMeView.this.getBinding().commonView;
                AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = DetailSelectMeView.this.getBinding().avatarBubble;
                Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
                DetailCommonView.initBubbleView$default(detailCommonView, avatarOnlineStatusDetailBubble, forceShowBubble, null, 4, null);
                DetailSelectMeView.this.getBinding().avatarBubble.setEditListener(DetailSelectMeView.this);
                z16 = DetailSelectMeView.this.isEditorPage;
                if (!z16) {
                    DetailSelectMeView.this.bindHostSimpleView();
                } else {
                    DetailSelectMeView.this.bindChangeStatusView();
                }
                DetailSelectMeView.this.getBinding().commonView.getMultiParent().setVisibility(0);
                entranceSource = DetailSelectMeView.this.entranceSource;
                if ((entranceSource != null ? entranceSource.getSub() : null) != SubScene.SQUARE_BUBBLE_INTERACTION || (showInteractionRecord = DetailSelectMeView.this.getShowInteractionRecord()) == null) {
                    return;
                }
                showInteractionRecord.invoke();
            }
        });
        this.binding.commonView.getSetting().setVisibility(0);
        this.binding.commonView.getPosterShare().setVisibility(0);
        this.binding.stickersBanner.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initBaseView$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                SquareAvatarItem squareAvatarItem;
                SquareAvatarItem squareAvatarItem2;
                Map<String, Object> mutableMapOf;
                Stickers stickers;
                Stickers stickers2;
                iReporter = DetailSelectMeView.this.reporter;
                BubbleStickersBanner bubbleStickersBanner = DetailSelectMeView.this.getBinding().stickersBanner;
                Intrinsics.checkNotNullExpressionValue(bubbleStickersBanner, "binding.stickersBanner");
                Pair[] pairArr = new Pair[2];
                squareAvatarItem = DetailSelectMeView.this.currentSquareItem;
                int i3 = 0;
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_LIKES, Integer.valueOf((squareAvatarItem == null || (stickers2 = squareAvatarItem.getStickers()) == null) ? 0 : stickers2.getLikeNum()));
                squareAvatarItem2 = DetailSelectMeView.this.currentSquareItem;
                if (squareAvatarItem2 != null && (stickers = squareAvatarItem2.getStickers()) != null) {
                    i3 = stickers.getNewLikeNum();
                }
                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_NEW_LIKES, Integer.valueOf(i3));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                iReporter.reportEvent("clck", bubbleStickersBanner, mutableMapOf);
                DetailSelectMeView.this.showLikePanel();
            }
        });
        setVisibility(0);
    }

    private final void initBatteryObserverIfNeeded(String from) {
        if (this.enableBatteryInfo) {
            SquareAvatarItem squareAvatarItem = this.currentSquareItem;
            if (squareAvatarItem != null) {
                SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                squareBatteryStatusManager.onStatusChange(squareAvatarItem.getUin(), squareAvatarItem.getIsGenderMale(), squareAvatarItem.getExtra().getOnlineStatus(), from);
                OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
                if (onlineStatus != null && OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus)) {
                    squareBatteryStatusManager.addObserver(this);
                    return;
                } else {
                    squareBatteryStatusManager.removeObserver(this);
                    return;
                }
            }
            SquareBatteryStatusManager.INSTANCE.removeObserver(this);
        }
    }

    private final void initBlindBoxEntrance() {
        VasBlindBoxService.INSTANCE.getBlindBoxEntrance(2, new DetailSelectMeView$initBlindBoxEntrance$1(this));
    }

    private final void initClickListener() {
        this.binding.onlineStatusPanel.setClickListener(this);
        this.binding.textEditComplete.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf;
                iReporter = DetailSelectMeView.this.reporter;
                Button button = DetailSelectMeView.this.getBinding().textEditComplete;
                Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
                Pair[] pairArr = new Pair[1];
                String textString = DetailSelectMeView.this.getBinding().avatarBubble.getTextString();
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_SET_CUSTOMIZE_TEXT, Integer.valueOf(1 ^ ((textString == null || textString.length() == 0) ? 1 : 0)));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                iReporter.reportEvent("clck", button, mutableMapOf);
                DetailSelectMeView.this.breakEdit();
            }
        });
        this.binding.darkView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf;
                iReporter = DetailSelectMeView.this.reporter;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Pair[] pairArr = new Pair[1];
                String textString = DetailSelectMeView.this.getBinding().avatarBubble.getTextString();
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_HAS_SET_CUSTOMIZE_TEXT, Integer.valueOf(1 ^ ((textString == null || textString.length() == 0) ? 1 : 0)));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                iReporter.reportEvent("clck", it, mutableMapOf);
                DetailSelectMeView.this.breakEdit();
            }
        });
        this.binding.changeStatusContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                IReporter iReporter;
                Map<String, Object> addStatusBtnReportParams;
                fastClickUtils = DetailSelectMeView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                iReporter = DetailSelectMeView.this.reporter;
                LinearLayout linearLayout = DetailSelectMeView.this.getBinding().changeStatusContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.changeStatusContainer");
                addStatusBtnReportParams = DetailSelectMeView.this.getAddStatusBtnReportParams();
                iReporter.reportEvent("clck", linearLayout, addStatusBtnReportParams);
                DetailSelectMeView.this.bindChangeStatusView();
                FrameLayout frameLayout = DetailSelectMeView.this.getBinding().avatarBubbleContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarBubbleContainer");
                if (frameLayout.getVisibility() != 0) {
                    FrameLayout frameLayout2 = DetailSelectMeView.this.getBinding().avatarBubbleContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarBubbleContainer");
                    frameLayout2.setVisibility(0);
                }
                RelativeLayout relativeLayout = DetailSelectMeView.this.getBinding().avatarLocationView;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
                relativeLayout.setVisibility(0);
            }
        });
        this.binding.operatorContainer.operatorEnterSmallHomeContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                IReporter iReporter;
                DetailMeListener detailMeListener;
                fastClickUtils = DetailSelectMeView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                iReporter = DetailSelectMeView.this.reporter;
                RelativeLayout relativeLayout = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterSmallHomeContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                iReporter.reportEvent("clck", relativeLayout, new LinkedHashMap());
                detailMeListener = DetailSelectMeView.this.socialStatusListener;
                if (detailMeListener != null) {
                    detailMeListener.goToSmallHome();
                }
            }
        });
        this.binding.publish.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$5
            /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
            
                r7 = r6.this$0.selectedAvatarItem;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View it) {
                DetailMeDressBubbleHelper detailMeDressBubbleHelper;
                FastClickUtils fastClickUtils;
                boolean z16;
                SquareAvatarItem squareAvatarItem;
                SquareAvatarExtra extra;
                OnlineStatus onlineStatus;
                DetailMeListener detailMeListener;
                IReporter iReporter;
                Map<String, Object> publishBtnReportParams;
                String str;
                detailMeDressBubbleHelper = DetailSelectMeView.this.dressBubbleHelper;
                detailMeDressBubbleHelper.recordPublishStatus();
                fastClickUtils = DetailSelectMeView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                z16 = DetailSelectMeView.this.hasPublish;
                if (z16) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.isEnabled() || squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null) {
                    return;
                }
                DetailSelectMeView detailSelectMeView = DetailSelectMeView.this;
                detailSelectMeView.curRequestText = String.valueOf(detailSelectMeView.getBinding().avatarBubble.getTextString());
                if (!DetailSelectMeView.this.getPublishButTexToChoseFriend()) {
                    DetailSelectMeView.this.hasPublish = true;
                }
                BaseResourceInfo targetActionFromActionGroup$default = DetailSelectMeView.getTargetActionFromActionGroup$default(DetailSelectMeView.this, Integer.valueOf(onlineStatus.getId()), false, 2, null);
                detailMeListener = DetailSelectMeView.this.socialStatusListener;
                if (detailMeListener != null) {
                    str = DetailSelectMeView.this.curRequestText;
                    detailMeListener.onPublishClick(onlineStatus, targetActionFromActionGroup$default, str);
                }
                iReporter = DetailSelectMeView.this.reporter;
                Button button = DetailSelectMeView.this.getBinding().publish;
                Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
                publishBtnReportParams = DetailSelectMeView.this.getPublishBtnReportParams(targetActionFromActionGroup$default != null && targetActionFromActionGroup$default.getIsMultiAction());
                iReporter.reportEvent("clck", button, publishBtnReportParams);
            }
        });
        this.binding.selectLocationBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailSelectMeView.this.onSelectLocation();
            }
        });
        this.binding.selector.setBtnClickCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$7
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
                DetailSelectMeView.onSelectFriendClick$default(DetailSelectMeView.this, null, 1, null);
            }
        });
        this.binding.selector.setPanelItemClickCallback(new Function1<String, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DetailSelectMeView.this.onSelectFriendClick(it);
            }
        });
        this.binding.operatorContainer.operatorEnterDressMallContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter iReporter;
                Map<String, Object> dressIconReportParams;
                DetailMeDressBubbleHelper detailMeDressBubbleHelper;
                iReporter = DetailSelectMeView.this.reporter;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                dressIconReportParams = DetailSelectMeView.this.getDressIconReportParams();
                iReporter.reportEvent("clck", it, dressIconReportParams);
                detailMeDressBubbleHelper = DetailSelectMeView.this.dressBubbleHelper;
                detailMeDressBubbleHelper.clickDressIcon();
            }
        });
        this.binding.editCustomClearIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                DetailSelectMeView.this.getBinding().avatarBubble.clearText();
                iReporter = DetailSelectMeView.this.reporter;
                SquareImageView squareImageView = DetailSelectMeView.this.getBinding().editCustomClearIcon;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.editCustomClearIcon");
                iReporter.reportEvent("clck", squareImageView, new LinkedHashMap());
            }
        });
        VasSquareInteractionRecordLayoutBinding vasSquareInteractionRecordLayoutBinding = this.binding.interactionRecord;
        Intrinsics.checkNotNullExpressionValue(vasSquareInteractionRecordLayoutBinding, "binding.interactionRecord");
        vasSquareInteractionRecordLayoutBinding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$11
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                FastClickUtils fastClickUtils;
                IReporter iReporter;
                fastClickUtils = DetailSelectMeView.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                Function0<Unit> showInteractionRecord = DetailSelectMeView.this.getShowInteractionRecord();
                if (showInteractionRecord != null) {
                    showInteractionRecord.invoke();
                }
                iReporter = DetailSelectMeView.this.reporter;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                iReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
        this.binding.operatorContainer.operatorEnterQzoneContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view != null) {
                    DetailSelectMeView.this.onEnterQZoneClick(view);
                }
            }
        });
        this.binding.operatorContainer.singleOperatorContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view != null) {
                    DetailSelectMeView.this.onEnterQZoneClick(view);
                }
            }
        });
        this.binding.configInteraction.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailSelectMeView.this.onConfigInteraction();
            }
        });
        this.binding.goBlindBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initClickListener$15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                str = DetailSelectMeView.this.currentBlindBoxUrl;
                if (str != null) {
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    Context context = DetailSelectMeView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    router.routeLink(context, new EntranceLink(str, 2));
                }
            }
        });
    }

    private final void initPagView() {
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        this.squarePagRootView = pagView;
        if (pagView != null) {
            pagView.setPagFile(R.raw.f131015);
        }
        LinearLayout linearLayout = this.binding.stateLoadingView;
        ISquarePagView iSquarePagView = this.squarePagRootView;
        linearLayout.addView(iSquarePagView != null ? iSquarePagView.getView() : null, 0, new FrameLayout.LayoutParams(ViewExtensionsKt.dip(getContext(), 12), ViewExtensionsKt.dip(getContext(), 12)));
    }

    private final void initSelectAvatarItem() {
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        this.selectedAvatarItem = squareAvatarItem != null ? SquareAvatarItemKt.copyAvatarItem(squareAvatarItem) : null;
    }

    private final void initTouchEvent() {
        if (this.currentSquareItem != null) {
            final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initTouchEvent$$inlined$let$lambda$1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent e16) {
                    return super.onDoubleTap(e16);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent e16) {
                    boolean z16;
                    boolean z17;
                    z16 = DetailSelectMeView.this.isEditorPage;
                    if (z16) {
                        DetailSelectMeView.this.breakEdit();
                    }
                    if (e16 != null) {
                        DetailCommonView detailCommonView = DetailSelectMeView.this.getBinding().commonView;
                        z17 = DetailSelectMeView.this.isEditorPage;
                        if (!detailCommonView.isClickAvatar(e16, z17)) {
                            DetailSelectMeView.this.onBack();
                        }
                    }
                    return super.onSingleTapConfirmed(e16);
                }
            });
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initTouchEvent$$inlined$let$lambda$2
                /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
                
                    r2 = r1.this$0.socialStatusListener;
                 */
                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onScaleEnd(ScaleGestureDetector detector) {
                    DetailMeListener detailMeListener;
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    if (detector.getScaleFactor() >= 1.0f || detailMeListener == null) {
                        return;
                    }
                    detailMeListener.onBackClick();
                }
            });
            setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initTouchEvent$1$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    gestureDetector.onTouchEvent(motionEvent);
                    scaleGestureDetector.onTouchEvent(motionEvent);
                    return true;
                }
            });
        }
    }

    private final void invalidateAllMultiResource(Integer withModelGender) {
        Collection<List<BaseResourceInfo>> values = this.recordResourceMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "recordResourceMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            List actionList = (List) it.next();
            Intrinsics.checkNotNullExpressionValue(actionList, "actionList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : actionList) {
                if (((BaseResourceInfo) obj).getIsMultiAction()) {
                    arrayList.add(obj);
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                RecordResourceInfo displayResource$default = BaseResourceInfo.getDisplayResource$default((BaseResourceInfo) it5.next(), this.currentSquareItem, null, null, withModelGender, 6, null);
                if (displayResource$default != null && !displayResource$default.getResource().getIsDefault()) {
                    displayResource$default.getResource().resetDefault();
                }
            }
        }
    }

    private final void loadPosterInfo(final Function0<Unit> callback) {
        Resource resource;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (resource = SquareResourceManagerKt.getResource(squareAvatarItem)) == null) {
            return;
        }
        int actionId = resource.getActionId();
        RelativeLayout relativeLayout = this.binding.posterLoadingView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.posterLoadingView");
        relativeLayout.setVisibility(0);
        VasGetPosterService.INSTANCE.getPosterData(actionId, new ResultCallback<SquarePosterInfo>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$loadPosterInfo$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                RelativeLayout relativeLayout2 = DetailSelectMeView.this.getBinding().posterLoadingView;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.posterLoadingView");
                relativeLayout2.setVisibility(8);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquarePosterInfo result) {
                SquareAvatarItem squareAvatarItem2;
                SquareAvatarExtra extra;
                Intrinsics.checkNotNullParameter(result, "result");
                squareAvatarItem2 = DetailSelectMeView.this.currentSquareItem;
                if (squareAvatarItem2 != null && (extra = squareAvatarItem2.getExtra()) != null) {
                    extra.setPosterInfo(result);
                }
                callback.invoke();
                RelativeLayout relativeLayout2 = DetailSelectMeView.this.getBinding().posterLoadingView;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.posterLoadingView");
                relativeLayout2.setVisibility(8);
            }
        });
    }

    private final void needUpdateCustomText() {
        OnlineStatus onlineStatus;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        if (squareAvatarItem == null || (onlineStatus = squareAvatarItem.getExtra().getOnlineStatus()) == null) {
            return;
        }
        onlineStatus.setCustomText(this.curRequestText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBack() {
        if (this.isEditorPage) {
            bindHostSimpleView();
            showStatusPanel(false);
            Button button = this.binding.publish;
            Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
            button.setVisibility(8);
            FrameLayout frameLayout = this.binding.configInteraction;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.configInteraction");
            frameLayout.setVisibility(8);
            hideRecordLoading();
            return;
        }
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.onBackClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConfigInteraction() {
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.onConfigInteraction(currentPlayingAvatar());
        }
        reportConfigInteraction("click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEnterQZoneClick(View view) {
        Long longOrNull;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
            SquareQZoneFeedsManager squareQZoneFeedsManager = SquareQZoneFeedsManager.INSTANCE;
            String qZoneHomePageUrl = squareQZoneFeedsManager.getQZoneHomePageUrl(squareAvatarItem.getUin(), squareAvatarItem.getUin());
            View mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            Context context = mRv.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(squareAvatarItem.getUin());
            squareQZoneFeedsManager.doJumpToQZone(context, longOrNull, qZoneHomePageUrl, 2, (r17 & 16) != 0 ? "" : null, (r17 & 32) != 0 ? true : true, (r17 & 64) != 0);
        }
        this.reporter.reportEvent("clck", view, new LinkedHashMap());
    }

    private final void onInvalidateInviteUI(Integer withModelGender) {
        BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
        updateInviteUI(currentResourceInfo, this.inviteState);
        if (this.isEditorPage) {
            updateResourceAndPlay(currentResourceInfo, this.inviteState, withModelGender);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectFriendClick(String uin) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        BaseResourceInfo targetActionFromActionGroup$default;
        RecordResourceInfo displayResource$default;
        Resource resource;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || (targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(onlineStatus.getId()), false, 2, null)) == null || (displayResource$default = BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, null, null, null, 14, null)) == null || (resource = displayResource$default.getResource()) == null) {
            return;
        }
        int actionId = resource.getActionId();
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.onSelectFriendClick(actionId, uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectLocation() {
        AvatarLocationInfo selectPoi;
        LocationGuide locationGuide = new LocationGuide();
        AvatarPoiHandler avatarPoiHandler = this.poiHandler;
        if (avatarPoiHandler != null && (selectPoi = avatarPoiHandler.getSelectPoi()) != null) {
            WeakReference<VasBaseFragment> weakReference = this.fragment;
            locationGuide.open(weakReference != null ? weakReference.get() : null, selectPoi.getPoiId());
        }
        IReporter iReporter = this.reporter;
        LocationIconView locationIconView = this.binding.selectLocationBar;
        Intrinsics.checkNotNullExpressionValue(locationIconView, "binding.selectLocationBar");
        iReporter.reportEvent("clck", locationIconView, getLocationReportData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playAvatar(final Integer statusId, final Resource resource) {
        changeClickFlag(true, "playAvatar, id:" + statusId + ", res:" + resource);
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.playAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$playAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    Handler handler;
                    handler = DetailSelectMeView.this.myHandler;
                    if (handler != null) {
                        handler.removeMessages(1);
                    }
                    if (DetailSelectMeView.isCurStatus$default(DetailSelectMeView.this, statusId, null, 2, null) && Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        DetailSelectMeView.this.hideRecordLoading();
                    }
                    if (SquareSwitchUtils.INSTANCE.enableFilamentDetail() && Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        DetailSelectMeView.this.hideRecordLoading();
                    }
                    DetailSelectMeView.this.changeClickFlag(false, "playAvatar, id:" + statusId + ", res:" + resource);
                }
            });
        }
        Handler handler = this.myHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Handler handler2 = this.myHandler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private final void playMultiMotionIfNeed() {
        BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
        if (currentResourceInfo == null || !currentResourceInfo.getIsMultiAction()) {
            return;
        }
        updateResourceAndPlay(currentResourceInfo, this.inviteState, this.withModelGender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playResource(final OnlineStatus status, final Resource resource, boolean hasRecord) {
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[DMV] playResource, ");
        sb5.append(status != null ? status.getShortDes() : null);
        sb5.append(", hasRecord:");
        sb5.append(hasRecord);
        sb5.append(", res:");
        sb5.append(resource);
        squareLog.d(TAG, sb5.toString());
        showRecordLoading();
        if (hasRecord) {
            playAvatar(status != null ? Integer.valueOf(status.getId()) : null, resource);
            return;
        }
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.playAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$playResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("[DMV] playResource, ");
                    OnlineStatus onlineStatus = status;
                    sb6.append(onlineStatus != null ? onlineStatus.getShortDes() : null);
                    sb6.append(", play.success:");
                    sb6.append(bool);
                    sb6.append(", res:");
                    sb6.append(resource);
                    squareLog2.d("DetailSelectMeView", sb6.toString());
                    if (Intrinsics.areEqual(bool, Boolean.TRUE) && SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                        DetailSelectMeView.this.hideRecordLoading();
                    }
                }
            });
        }
    }

    private final void recalculatePosition() {
        int coerceAtLeast;
        Button button = this.binding.textEditComplete;
        Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(squareUtil.getStatusBarHeight(context), (int) com.tencent.state.ViewExtensionsKt.dip((View) this, 20.0f));
            layoutParams2.topMargin = coerceAtLeast + ViewExtensionsKt.dip(getContext(), 6.0f);
        }
        int heightOutScreen = DetailAvatarConfig.INSTANCE.getHeightOutScreen();
        if (heightOutScreen == 0) {
            return;
        }
        RelativeLayout relativeLayout = this.binding.pageButtons;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.pageButtons");
        ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
        if (!(layoutParams3 instanceof FrameLayout.LayoutParams)) {
            layoutParams3 = null;
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        if (layoutParams4 != null) {
            layoutParams4.bottomMargin -= heightOutScreen;
        }
        LinearLayout linearLayout = this.binding.stateLoadingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLoadingView");
        ViewGroup.LayoutParams layoutParams5 = linearLayout.getLayoutParams();
        if (!(layoutParams5 instanceof FrameLayout.LayoutParams)) {
            layoutParams5 = null;
        }
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
        if (layoutParams6 != null) {
            layoutParams6.bottomMargin -= heightOutScreen;
        }
        FrameLayout frameLayout = this.binding.onlineStatusMultiActionPanelContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.onlineStatusMultiActionPanelContainer");
        ViewGroup.LayoutParams layoutParams7 = frameLayout.getLayoutParams();
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) (layoutParams7 instanceof FrameLayout.LayoutParams ? layoutParams7 : null);
        if (layoutParams8 != null) {
            layoutParams8.bottomMargin -= heightOutScreen;
        }
    }

    private final void reportConfigInteraction(String actionType) {
        OnlineStatus onlineStatus;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        if (squareAvatarItem != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_action_type", actionType);
            SquareAvatarExtra extra = squareAvatarItem.getExtra();
            linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf((extra == null || (onlineStatus = extra.getOnlineStatus()) == null) ? 0 : onlineStatus.getTopStatusId()));
            Integer richStatusId = SquareResourceManagerKt.getRichStatusId(squareAvatarItem);
            linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
            Resource userResource = squareAvatarItem.getUserResource();
            linkedHashMap.put(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(userResource != null ? userResource.getActionId() : 0));
            this.reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HUDONG_SET_BTN, linkedHashMap);
        }
    }

    private final void reportConfigInteractionBtnShow() {
        FrameLayout frameLayout = this.binding.configInteraction;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.configInteraction");
        if (frameLayout.getVisibility() == 0) {
            reportConfigInteraction("imp");
        }
    }

    private final Drawable setImageUrl(String url) {
        if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            return null;
        }
        URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
        urlDrawableOptions$default.mPlayGifImage = true;
        urlDrawableOptions$default.mUseApngImage = true;
        urlDrawableOptions$default.mUseMemoryCache = true;
        URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        if (drawable.getStatus() != 1) {
            drawable.startDownload();
        }
        return drawable;
    }

    private final void setLocationViewInfo() {
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
        if (squareOnlineStatusViewPanel.getVisibility() == 0) {
            return;
        }
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        AvatarLocationInfo locationInfo = squareAvatarItem != null ? squareAvatarItem.getLocationInfo() : null;
        if (locationInfo != null) {
            DetailCommonView detailCommonView = this.binding.commonView;
            detailCommonView.updateLocationView(locationInfo, detailCommonView.getMultiTitleContainer().getVisibility() == 0);
        }
    }

    private final void showBatteryDialog(final OnlineStatus status) {
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String string = getResources().getString(R.string.xce);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026quare_dialog_battery_msg)");
        String string2 = getResources().getString(R.string.xch);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ng.square_dialog_confirm)");
        String string3 = getResources().getString(R.string.xcg);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.square_dialog_cancel)");
        commonUtils.showDialog(context, string, string2, string3, getResources().getString(R.string.xcf), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$showBatteryDialog$1
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

            public final void invoke(boolean z16) {
                if (z16) {
                    IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_SHOW_BATTERY_STATUS_DIALOG, true, null, false, 12, null);
                    DetailSelectMeView.this.changeStatus(status, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLikePanel() {
        List<LikeData> list;
        LikeDataManager likeDataManager = LikeDataManager.INSTANCE;
        LikeListInfo likeListInfo = likeDataManager.getLikeListInfo();
        if (likeListInfo != null && (list = likeListInfo.getList()) != null && (!list.isEmpty())) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LikeListPanel likeListPanel = new LikeListPanel(context);
            likeListPanel.setData(likeListInfo);
            likeListPanel.show();
        }
        likeDataManager.reportReadLikeList();
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null) {
            squareAvatarItem.getStickers().markReaded(StickerType.Like);
            SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(squareAvatarItem.getUin(), squareAvatarItem.getStickers()));
        }
        bindLikeListBanner();
    }

    private final void showMusicDialog(final OnlineStatus status) {
        Map<String, Object> mutableMapOf;
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String string = getResources().getString(R.string.xcj);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.square_dialog_music_msg)");
        String string2 = getResources().getString(R.string.xch);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ng.square_dialog_confirm)");
        String string3 = getResources().getString(R.string.xcg);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.square_dialog_cancel)");
        commonUtils.showDialog(context, string, string2, string3, getResources().getString(R.string.xck), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$showMusicDialog$1
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

            public final void invoke(boolean z16) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf2;
                iReporter = DetailSelectMeView.this.reporter;
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_action_result", Integer.valueOf(z16 ? 1 : 0)));
                iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_SWITCH, mutableMapOf2);
                if (z16) {
                    IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.DIALOG_KEY_MUSIC_STATUS, true, null, false, 12, null);
                    DetailSelectMeView.this.changeStatus(status, true);
                }
            }
        });
        IReporter iReporter = this.reporter;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_SWITCH, mutableMapOf);
    }

    private final void showPagUI(String url) {
        SquareImageView squareImageView = this.binding.newStatusImage;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.newStatusImage");
        squareImageView.setVisibility(8);
        SquarePagFileUtils.INSTANCE.downloadPagFile(url, new SimplePagDownloadListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$showPagUI$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                Context context = DetailSelectMeView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ISquarePagView pagView = commonUtils.getPagView(context);
                if (pagView != null) {
                    String absolutePath = resultFile.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                    pagView.setPagFile(absolutePath);
                    DetailSelectMeView.this.getBinding().newStatusRedDotContainer.addView(pagView.getView(), 0, new FrameLayout.LayoutParams(-1, -1));
                    ISquarePagView.DefaultImpls.playPag$default(pagView, 0, 1, null);
                    pagView.getView().setVisibility(0);
                    RelativeLayout relativeLayout = DetailSelectMeView.this.getBinding().newStatusRedDotContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.newStatusRedDotContainer");
                    relativeLayout.setVisibility(0);
                }
            }
        });
    }

    private final void showPngUI(String url) {
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            RelativeLayout relativeLayout = this.binding.newStatusRedDotContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.newStatusRedDotContainer");
            relativeLayout.setVisibility(0);
            URLDrawable drawable = URLDrawable.getDrawable(url, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            this.binding.newStatusImage.setImageDrawable(drawable);
            SquareImageView squareImageView = this.binding.newStatusImage;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.newStatusImage");
            squareImageView.setVisibility(0);
        }
    }

    private final void showPublishButton() {
        Button button = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
        if (button.getVisibility() != 0) {
            if (!this.recordResourceMap.isEmpty()) {
                Button button2 = this.binding.publish;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.publish");
                com.tencent.state.ViewExtensionsKt.setVisibility(button2, true);
                IReporter iReporter = this.reporter;
                Button button3 = this.binding.publish;
                Intrinsics.checkNotNullExpressionValue(button3, "binding.publish");
                BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
                iReporter.reportEvent("imp", button3, getPublishBtnReportParams(currentResourceInfo != null && currentResourceInfo.getIsMultiAction()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(java.lang.String.valueOf((r1 == null || (r1 = r1.getReceiver()) == null) ? null : java.lang.Long.valueOf(r1.f443328a)), r10.currentFriendUin)) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        if (r3 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014e, code lost:
    
        if (r6 == false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showStatusPanel(boolean isShow) {
        boolean z16;
        SquareAvatarItem squareAvatarItem;
        SquareAvatarItem squareAvatarItem2;
        Resource userResource;
        SquareAvatarExtra extra;
        SquareAvatarExtra extra2;
        OnlineStatus onlineStatus;
        o receiver;
        Integer onlineStatusId;
        SquareAvatarExtra extra3;
        OnlineStatus onlineStatus2;
        SquareAvatarExtra extra4;
        this.binding.commonView.getPosterShare().setVisibility(isShow ? 8 : 0);
        FrameLayout frameLayout = this.binding.flowerEntry;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flowerEntry");
        com.tencent.state.ViewExtensionsKt.setVisibility(frameLayout, !isShow);
        FrameLayout frameLayout2 = this.binding.btnBlindBox;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.btnBlindBox");
        boolean z17 = true;
        com.tencent.state.ViewExtensionsKt.setVisibility(frameLayout2, !isShow && this.isBlindBoxShow);
        OnlineStatus onlineStatus3 = null;
        if (isShow) {
            this.binding.onlineStatusPanel.openPanelWithAnima();
            this.binding.commonView.startEditorAnima(true);
            updateEditorBubbleLocation();
            SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
            Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
            squareOnlineStatusViewPanel.setVisibility(0);
            playMultiMotionIfNeed();
            BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
            if (currentResourceInfo != null && currentResourceInfo.getIsMultiAction()) {
                SquareMultiMotionDetailData squareMultiMotionDetailData = this.inviteState;
            }
            z17 = false;
            SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
            if (isCurStatus(squareAvatarItem3 != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem3) : null, Boolean.TRUE)) {
                SquareAvatarItem squareAvatarItem4 = this.currentSquareItem;
                if (((squareAvatarItem4 == null || (extra4 = squareAvatarItem4.getExtra()) == null) ? null : extra4.getOnlineStatus()) != null) {
                }
            }
            SquareAvatarItem squareAvatarItem5 = this.selectedAvatarItem;
            if (squareAvatarItem5 != null && (extra3 = squareAvatarItem5.getExtra()) != null && (onlineStatus2 = extra3.getOnlineStatus()) != null) {
                changeStatus$default(this, onlineStatus2, false, 2, null);
            }
        } else {
            SquareOnlineStatusMultiActionPanelHelper squareOnlineStatusMultiActionPanelHelper = this.multiActionPanelHelper;
            SquareAvatarItem squareAvatarItem6 = this.currentSquareItem;
            boolean isChangeSelectedByUser = squareOnlineStatusMultiActionPanelHelper.isChangeSelectedByUser((squareAvatarItem6 == null || (onlineStatusId = SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem6)) == null) ? -1 : onlineStatusId.intValue());
            checkAndUpdatePublishButton();
            BaseResourceInfo currentResourceInfo2 = getCurrentResourceInfo();
            if (currentResourceInfo2 != null && currentResourceInfo2.getIsMultiAction()) {
                SquareMultiMotionDetailData squareMultiMotionDetailData2 = this.inviteState;
                if (!Intrinsics.areEqual(String.valueOf((squareMultiMotionDetailData2 == null || (receiver = squareMultiMotionDetailData2.getReceiver()) == null) ? null : Long.valueOf(receiver.f443328a)), this.currentFriendUin)) {
                    z16 = true;
                    SquareAvatarItem squareAvatarItem7 = this.currentSquareItem;
                    boolean z18 = squareAvatarItem7 == null && (extra2 = squareAvatarItem7.getExtra()) != null && (onlineStatus = extra2.getOnlineStatus()) != null && OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus) && this.hasBatteryLevelChangeInEditorPage;
                    squareAvatarItem = this.currentSquareItem;
                    if (isCurStatus$default(this, squareAvatarItem == null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem) : null, null, 2, null)) {
                        SquareAvatarItem squareAvatarItem8 = this.currentSquareItem;
                        if (squareAvatarItem8 != null && (extra = squareAvatarItem8.getExtra()) != null) {
                            onlineStatus3 = extra.getOnlineStatus();
                        }
                        if (onlineStatus3 != null) {
                            if (!z18) {
                                if (!z16) {
                                }
                            }
                        }
                    }
                    this.hasBatteryLevelChangeInEditorPage = false;
                    squareAvatarItem2 = this.currentSquareItem;
                    if (squareAvatarItem2 != null && (userResource = squareAvatarItem2.getUserResource()) != null) {
                        playAvatar(SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem2), userResource);
                    }
                    updateBubbleLocation();
                    this.binding.onlineStatusPanel.hidePanelWithAnima();
                    this.multiActionPanelHelper.hidePanel(true);
                    this.binding.commonView.startEditorAnima(false);
                    SquareOnlineStatusViewPanel squareOnlineStatusViewPanel2 = this.binding.onlineStatusPanel;
                    Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel2, "binding.onlineStatusPanel");
                    squareOnlineStatusViewPanel2.setVisibility(8);
                }
            }
            z16 = false;
            SquareAvatarItem squareAvatarItem72 = this.currentSquareItem;
            if (squareAvatarItem72 == null) {
            }
            squareAvatarItem = this.currentSquareItem;
            if (isCurStatus$default(this, squareAvatarItem == null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem) : null, null, 2, null)) {
            }
            this.hasBatteryLevelChangeInEditorPage = false;
            squareAvatarItem2 = this.currentSquareItem;
            if (squareAvatarItem2 != null) {
                playAvatar(SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem2), userResource);
            }
            updateBubbleLocation();
            this.binding.onlineStatusPanel.hidePanelWithAnima();
            this.multiActionPanelHelper.hidePanel(true);
            this.binding.commonView.startEditorAnima(false);
            SquareOnlineStatusViewPanel squareOnlineStatusViewPanel22 = this.binding.onlineStatusPanel;
            Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel22, "binding.onlineStatusPanel");
            squareOnlineStatusViewPanel22.setVisibility(8);
        }
        updateInviteUI(getCurrentResourceInfo(), this.inviteState);
        updateSelectLocationUI(isShow);
    }

    private final void updateInteractionUI(BaseResourceInfo info) {
        if (this.isEditorPage) {
            FrameLayout frameLayout = this.binding.interactionRecordBtnContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.interactionRecordBtnContainer");
            frameLayout.setVisibility(8);
            FrameLayout frameLayout2 = this.binding.configInteraction;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.configInteraction");
            frameLayout2.setVisibility(0);
            SquareImageView squareImageView = this.binding.configInteractionIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.configInteractionIcon");
            if (squareImageView.getDrawable() == null) {
                this.binding.configInteractionIcon.setImageDrawable(URLDrawable.getDrawable(CONFIG_INTERACTION_ICON_URL, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            }
        } else {
            FrameLayout frameLayout3 = this.binding.interactionRecordBtnContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.interactionRecordBtnContainer");
            frameLayout3.setVisibility(0);
            FrameLayout frameLayout4 = this.binding.configInteraction;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.configInteraction");
            frameLayout4.setVisibility(8);
        }
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            FrameLayout frameLayout5 = this.binding.interactionRecordBtnContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.interactionRecordBtnContainer");
            frameLayout5.setVisibility(8);
            FrameLayout frameLayout6 = this.binding.configInteraction;
            Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.configInteraction");
            frameLayout6.setVisibility(8);
        }
    }

    private final void updateInviteSuccessUI(BaseResourceInfo info, SquareMultiMotionDetailData inviteState) {
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
        boolean z16 = squareOnlineStatusViewPanel.getVisibility() == 0;
        if (inviteState != null && inviteState.isInviteSuccess() && !z16) {
            this.binding.commonView.getMultiTitleContainer().setVisibility(0);
            this.binding.commonView.getMultiTitle().setText("\u6211\u548c " + getLimitNickName$default(this, inviteState.getOtherNick(), 0, 2, null) + " \u7684\u53cc\u4ebaPOSE");
            this.binding.commonView.getMultiCountDown().setText(APLogFileUtil.SEPARATOR_LOG + inviteState.getCountdown());
            this.binding.commonView.getMultiCountDown().setVisibility(0);
        } else {
            this.binding.commonView.getMultiTitleContainer().setVisibility(8);
        }
        if (z16) {
            this.binding.commonView.getLocationInfo().setVisibility(8);
        } else {
            setLocationViewInfo();
        }
    }

    private final void updateInviteTips(BaseResourceInfo info, SquareMultiMotionDetailData inviteState) {
        this.binding.selector.hideButton();
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
        if (com.tencent.state.ViewExtensionsKt.isVisible(squareOnlineStatusViewPanel)) {
            showPublishButton();
            if (info != null && info.getIsMultiAction()) {
                this.binding.selector.showButton();
                PickFriendView pickFriendView = this.binding.selector;
                String str = this.currentFriendUin;
                if (str == null) {
                    str = "";
                }
                pickFriendView.setBtnInfo(str);
                return;
            }
            this.binding.selector.hideButton();
            return;
        }
        this.binding.selector.hideButton();
        Button button = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
        com.tencent.state.ViewExtensionsKt.setVisibility(button, false);
    }

    private final void updateInviteUI(BaseResourceInfo info, SquareMultiMotionDetailData inviteState) {
        SquareBaseKt.getSquareLog().i(TAG, "[DMV] updateInviteUI: info=" + info + ", inviteState=" + inviteState);
        checkAndUpdatePublishButton();
        updateInviteButton(info, inviteState);
        updateInteractionUI(getCurrentResourceInfo());
        updateInviteTips(info, inviteState);
        updateInviteSuccessUI(info, inviteState);
    }

    private final void updateOperationIconsLocation() {
        Resources resources;
        DisplayMetrics displayMetrics;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        int i3 = displayMetrics.heightPixels;
        Location realAvatarLocation$default = getRealAvatarLocation$default(this, false, 1, null);
        if (realAvatarLocation$default != null) {
            VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding = this.binding.operatorContainer;
            Intrinsics.checkNotNullExpressionValue(vasSquareDatailMultiOperatorBinding, "binding.operatorContainer");
            FrameLayout mRv = vasSquareDatailMultiOperatorBinding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.operatorContainer.root");
            ViewGroup.LayoutParams layoutParams = mRv.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) (layoutParams instanceof LinearLayout.LayoutParams ? layoutParams : null);
            if (layoutParams2 == null) {
                layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            }
            if (((i3 - (realAvatarLocation$default.getY() + realAvatarLocation$default.getHeight())) - com.tencent.state.ViewExtensionsKt.dip((View) this, 80)) - this.binding.commonView.getMultiParent().getHeight() <= com.tencent.state.ViewExtensionsKt.dip((View) this, 107)) {
                layoutParams2.bottomMargin = com.tencent.state.ViewExtensionsKt.dip((View) this, 18);
            } else {
                layoutParams2.bottomMargin = com.tencent.state.ViewExtensionsKt.dip((View) this, 45);
            }
            VasSquareDatailMultiOperatorBinding vasSquareDatailMultiOperatorBinding2 = this.binding.operatorContainer;
            Intrinsics.checkNotNullExpressionValue(vasSquareDatailMultiOperatorBinding2, "binding.operatorContainer");
            FrameLayout mRv2 = vasSquareDatailMultiOperatorBinding2.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv2, "binding.operatorContainer.root");
            mRv2.setLayoutParams(layoutParams2);
        }
    }

    private final void updateSelectLocationUI(boolean isShow) {
        String str;
        LocationIconView locationIconView = this.binding.selectLocationBar;
        Intrinsics.checkNotNullExpressionValue(locationIconView, "binding.selectLocationBar");
        locationIconView.setVisibility(isShow ? 0 : 8);
        if (isShow) {
            str = "imp";
        } else {
            str = "imp_end";
        }
        IReporter iReporter = this.reporter;
        LocationIconView locationIconView2 = this.binding.selectLocationBar;
        Intrinsics.checkNotNullExpressionValue(locationIconView2, "binding.selectLocationBar");
        iReporter.reportEvent(str, locationIconView2, getLocationReportData());
    }

    public final void bindChangeStatusView() {
        SquareAvatarExtra extra;
        NewStatusInfo newStatusInfo = this.newStatusInfo;
        OnlineStatus onlineStatus = null;
        if (newStatusInfo != null) {
            SquareOnlineStatusViewPanel.setMotionSelect$default(this.binding.onlineStatusPanel, Integer.valueOf(newStatusInfo.getStatusId()), Integer.valueOf(newStatusInfo.getRichStatusId()), null, 4, null);
            DetailMeListener detailMeListener = this.socialStatusListener;
            if (detailMeListener != null) {
                detailMeListener.onSetNewStatus(newStatusInfo.getRedDotId());
            }
            this.multiActionPanelHelper.clearActionId();
            RelativeLayout relativeLayout = this.binding.newStatusRedDotContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.newStatusRedDotContainer");
            relativeLayout.setVisibility(8);
            SquareImageView squareImageView = this.binding.newStatusImage;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.newStatusImage");
            squareImageView.setVisibility(8);
            reportNewStatusData("clck");
            reportNewStatusData("imp_end");
            this.newStatusInfo = null;
        }
        if (this.myHandler == null) {
            this.myHandler = new Handler(Looper.getMainLooper(), this);
        }
        this.isEditorPage = true;
        DetailMeDressBubbleHelper detailMeDressBubbleHelper = this.dressBubbleHelper;
        if (detailMeDressBubbleHelper != null) {
            detailMeDressBubbleHelper.hideBubble("enterEdit");
        }
        showStatusPanel(true);
        LinearLayout linearLayout = this.binding.hostFocusView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.hostFocusView");
        linearLayout.setVisibility(8);
        View mainContainer = this.binding.avatarBubble.getMainContainer();
        if (mainContainer != null) {
            this.reporter.reportEvent("imp", mainContainer, new LinkedHashMap());
        }
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
            onlineStatus = extra.getOnlineStatus();
        }
        if (onlineStatus == null) {
            checkAndUpdatePublishButton();
        }
        this.binding.avatarBubble.showChangeStatusView();
        this.binding.stickersBanner.hide();
        reportConfigInteractionBtnShow();
    }

    public final void bindLikeListBanner() {
        Map<String, Object> mutableMapOf;
        Stickers stickers;
        Stickers stickers2;
        BubbleStickersBanner bubbleStickersBanner = this.binding.stickersBanner;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        Stickers stickers3 = squareAvatarItem != null ? squareAvatarItem.getStickers() : null;
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        int i3 = 0;
        bubbleStickersBanner.bindData(stickers3, squareAvatarItem2 != null ? squareAvatarItem2.isMe() : false);
        IReporter iReporter = this.reporter;
        BubbleStickersBanner bubbleStickersBanner2 = this.binding.stickersBanner;
        Intrinsics.checkNotNullExpressionValue(bubbleStickersBanner2, "binding.stickersBanner");
        Pair[] pairArr = new Pair[2];
        SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_LIKES, Integer.valueOf((squareAvatarItem3 == null || (stickers2 = squareAvatarItem3.getStickers()) == null) ? 0 : stickers2.getLikeNum()));
        SquareAvatarItem squareAvatarItem4 = this.currentSquareItem;
        if (squareAvatarItem4 != null && (stickers = squareAvatarItem4.getStickers()) != null) {
            i3 = stickers.getNewLikeNum();
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_STICKER_NUMBER_OF_NEW_LIKES, Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iReporter.reportEvent("imp", bubbleStickersBanner2, mutableMapOf);
    }

    public final void breakEdit() {
        if (this.isEditing) {
            this.isEditing = false;
            this.binding.avatarBubble.clearFocus();
            Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            View view = this.binding.darkView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
            view.setVisibility(8);
            LinearLayout linearLayout = this.binding.customTextTitleGroup;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customTextTitleGroup");
            linearLayout.setVisibility(8);
            checkAndUpdatePublishButton();
            updateInviteButton(getCurrentResourceInfo(), this.inviteState);
            updateInteractionUI(getCurrentResourceInfo());
            Button button = this.binding.textEditComplete;
            Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
            button.setVisibility(8);
            SMMKV squareMMKV = SquareBaseKt.getSquareMMKV();
            String textString = this.binding.avatarBubble.getTextString();
            if (textString == null) {
                textString = "";
            }
            IMMKV.DefaultImpls.encodeString$default(squareMMKV, SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, textString, null, false, 12, null);
            this.binding.avatarBubble.showChangeStatusView();
            this.binding.selector.setListAlphaNormal();
        }
    }

    public final void changeLockStatus(StatusLockInfo lockInfo) {
        if (lockInfo != null && SquareOnlineStatusDataKt.isLock(lockInfo)) {
            TextView textView = this.binding.blindBoxTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.blindBoxTips");
            textView.setText(lockInfo.getTip());
            TextView textView2 = this.binding.goBlindBox;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.goBlindBox");
            textView2.setText(lockInfo.getButtonText());
            this.currentBlindBoxUrl = lockInfo.getLinkUrl();
            RelativeLayout relativeLayout = this.binding.blindBoxContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.blindBoxContainer");
            relativeLayout.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout2 = this.binding.blindBoxContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.blindBoxContainer");
        relativeLayout2.setVisibility(8);
    }

    public final void changeStatus(OnlineStatus status, boolean fromClick) {
        SquareAvatarExtra extra;
        Intrinsics.checkNotNullParameter(status, "status");
        SquareBaseKt.getSquareLog().d(TAG, "[DMV] changeStatus, fromClick:" + fromClick + ", " + status.getShortDes() + ", disableClick:" + this.disableClick);
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail() || !this.disableClick) {
            this.binding.avatarBubble.updateStatusIcon(status);
            BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(status.getId()), false, 2, null);
            if (targetActionFromActionGroup$default != null) {
                if (targetActionFromActionGroup$default.getRecordResources().isEmpty()) {
                    SquareBaseKt.getSquareLog().d(TAG, "[DMV] changeStatus, fromClick:" + fromClick + ", " + status.getShortDes() + ", res.record null");
                    return;
                }
                SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
                if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
                    extra.setOnlineStatus(status);
                }
                updateResourceAndPlay(targetActionFromActionGroup$default, this.inviteState, targetActionFromActionGroup$default.getIsMultiAction() ? this.withModelGender : null);
                updateInviteUI(targetActionFromActionGroup$default, this.inviteState);
                DetailMeListener detailMeListener = this.socialStatusListener;
                if (detailMeListener != null) {
                    detailMeListener.onStatusSelected(status, targetActionFromActionGroup$default);
                    return;
                }
                return;
            }
            SquareBaseKt.getSquareLog().d(TAG, "[DMV] changeStatus, fromClick:" + fromClick + ", " + status.getShortDes() + ", res null");
        }
    }

    public final Integer currentSelectedActionId() {
        Resource resource;
        SquareAvatarItem currentPlayingAvatar = currentPlayingAvatar();
        if (currentPlayingAvatar == null || (resource = SquareResourceManagerKt.getResource(currentPlayingAvatar)) == null) {
            return null;
        }
        return Integer.valueOf(resource.getActionId());
    }

    public final void destroy() {
        SquareBatteryStatusManager.INSTANCE.removeObserver(this);
        this.binding.commonView.destroy();
        Handler handler = this.myHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.socialStatusListener = null;
        if (this.newStatusInfo != null) {
            reportNewStatusData("imp_end");
        }
        this.dressBubbleHelper.onDestroy();
    }

    public final void doRecordSuccess(final RecordRequest request, final boolean isBuyTheSame) {
        List<RecordResourceInfo> recordResources;
        Intrinsics.checkNotNullParameter(request, "request");
        final Resource resource = request.getResource();
        if (resource != null) {
            BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(getStatusId(request)), false, 2, null);
            if (targetActionFromActionGroup$default != null && (recordResources = targetActionFromActionGroup$default.getRecordResources()) != null) {
                for (RecordResourceInfo recordResourceInfo : recordResources) {
                    if (recordResourceInfo.getResource().getActionId() == resource.getActionId()) {
                        recordResourceInfo.setResource(resource);
                        recordResourceInfo.setHasDynamicRecord(true);
                    }
                }
            }
            Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$doRecordSuccess$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    boolean checkPlayAvatar;
                    SquareAvatarItem squareAvatarItem;
                    int statusId;
                    boolean checkPlayAvatar2;
                    DetailMeListener detailMeListener;
                    SquareAvatarItem squareAvatarItem2;
                    boolean z16;
                    if (isBuyTheSame) {
                        checkPlayAvatar2 = DetailSelectMeView.this.checkPlayAvatar(request);
                        if (!checkPlayAvatar2) {
                            squareAvatarItem2 = DetailSelectMeView.this.selectedAvatarItem;
                            if (squareAvatarItem2 != null) {
                                z16 = DetailSelectMeView.this.isEditorPage;
                                if (z16) {
                                    return;
                                }
                            }
                        }
                        detailMeListener = DetailSelectMeView.this.socialStatusListener;
                        if (detailMeListener != null) {
                            detailMeListener.playAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$doRecordSuccess$2.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Boolean bool) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke2(bool);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    checkPlayAvatar = DetailSelectMeView.this.checkPlayAvatar(request);
                    if (checkPlayAvatar) {
                        DetailSelectMeView detailSelectMeView = DetailSelectMeView.this;
                        squareAvatarItem = detailSelectMeView.selectedAvatarItem;
                        detailSelectMeView.updateAvatarResource(squareAvatarItem, resource);
                        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                            return;
                        }
                        DetailSelectMeView detailSelectMeView2 = DetailSelectMeView.this;
                        statusId = detailSelectMeView2.getStatusId(request);
                        detailSelectMeView2.playAvatar(Integer.valueOf(statusId), resource);
                    }
                }
            });
        }
    }

    public final VasSquareDetailMeViewBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public DetailCommonView getCommonView() {
        DetailCommonView detailCommonView = this.binding.commonView;
        Intrinsics.checkNotNullExpressionValue(detailCommonView, "binding.commonView");
        return detailCommonView;
    }

    /* renamed from: getCurAvatarItem, reason: from getter */
    public final SquareAvatarItem getCurrentSquareItem() {
        return this.currentSquareItem;
    }

    public final Resource getCurResource() {
        RecordResourceInfo displayResource$default;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, squareAvatarItem != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem) : null, false, 2, null);
        if (targetActionFromActionGroup$default == null || (displayResource$default = BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, this.inviteState, this.currentFriendUin, null, 8, null)) == null) {
            return null;
        }
        return displayResource$default.getResource();
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public MapPlayableSource getCurrentMapPlayableSource() {
        BaseResourceInfo targetActionFromActionGroup$default;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        RecordResourceInfo singleMotionResource;
        Resource resource;
        Resource resource2;
        if (this.isEditorPage) {
            targetActionFromActionGroup$default = getCurrentResourceInfo();
        } else {
            SquareAvatarItem squareAvatarItem = this.currentSquareItem;
            targetActionFromActionGroup$default = (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null) ? null : getTargetActionFromActionGroup$default(this, Integer.valueOf(onlineStatus.getId()), false, 2, null);
        }
        if (targetActionFromActionGroup$default != null && targetActionFromActionGroup$default.getIsMultiAction()) {
            singleMotionResource = targetActionFromActionGroup$default.getDisplayResource(this.currentSquareItem, this.inviteState, this.currentFriendUin, this.withModelGender);
        } else {
            singleMotionResource = targetActionFromActionGroup$default != null ? targetActionFromActionGroup$default.getSingleMotionResource() : null;
        }
        if (!SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            if (singleMotionResource == null || (resource = singleMotionResource.getResource()) == null) {
                return null;
            }
            return SquareItemKt.toMapPlayableSource$default(resource, null, 1, null);
        }
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        if (squareAvatarItem2 == null || singleMotionResource == null || (resource2 = singleMotionResource.getResource()) == null) {
            return null;
        }
        return SquareItemKt.toMapPlayableSource$default(resource2, MapResourceType.Filament, squareAvatarItem2.getUin(), null, 4, null);
    }

    public final VasSquareInteractionRecordLayoutBinding getInteractionRecordBinding() {
        VasSquareInteractionRecordLayoutBinding vasSquareInteractionRecordLayoutBinding = this.binding.interactionRecord;
        Intrinsics.checkNotNullExpressionValue(vasSquareInteractionRecordLayoutBinding, "binding.interactionRecord");
        return vasSquareInteractionRecordLayoutBinding;
    }

    public final SquareOnlineStatusMultiActionPanelHelper getMultiActionPanelHelper() {
        return this.multiActionPanelHelper;
    }

    public final NewStatusInfo getNewStatusInfo() {
        return this.newStatusInfo;
    }

    public final boolean getPublishButTexToChoseFriend() {
        return this.publishButTexToChoseFriend;
    }

    public final List<BaseResourceInfo> getResourceList(int statusId) {
        List<BaseResourceInfo> emptyList;
        List<BaseResourceInfo> list = this.recordResourceMap.get(Integer.valueOf(statusId));
        if (list != null) {
            return list;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public final Function0<Unit> getShowInteractionRecord() {
        return this.showInteractionRecord;
    }

    public final DetailMeListener getSocialStatusListener() {
        return this.socialStatusListener;
    }

    public final SquareOnlineStatusViewPanel getStatusPanelView() {
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
        return squareOnlineStatusViewPanel;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            changeClickFlag(false, "handleMessage");
        }
        return true;
    }

    public final void handleNewStatusUI(String url) {
        int lastIndexOf$default;
        List split$default;
        boolean equals;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, "/", 0, false, 6, (Object) null);
            String substring = url.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null);
            equals = StringsKt__StringsJVMKt.equals((String) split$default.get(1), "pag", true);
            if (equals) {
                showPagUI(url);
            } else {
                showPngUI(url);
            }
        } catch (Exception e16) {
            SquareBaseKt.getSquareLog().e(TAG, "handle new status ui:", e16);
        }
    }

    public final void hideRecordLoading() {
        View view;
        ISquarePagView iSquarePagView = this.squarePagRootView;
        if (iSquarePagView != null && (view = iSquarePagView.getView()) != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.binding.stateLoadingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLoadingView");
        linearLayout.setVisibility(8);
    }

    public final void initView(EntranceSource source, DetailMeFragmentConfig entranceConfig, final SquareAvatarItem data, boolean isEditorPage, DetailMeListener listener) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.isEditorPage = isEditorPage;
        this.socialStatusListener = listener;
        this.entranceSource = source;
        this.entranceConfig = entranceConfig;
        this.currentSquareItem = data;
        this.binding.commonView.initView(data, source, listener, this);
        initBaseView(isEditorPage);
        LocationIconView locationIconView = this.binding.selectLocationBar;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        locationIconView.initLocation(squareAvatarItem != null ? squareAvatarItem.getLocationInfo() : null);
        initBatteryObserverIfNeeded("detail_init");
        if (this.isEditorPage) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initView$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    DetailMeListener detailMeListener;
                    SquareBaseKt.getSquareLog().i("DetailSelectMeView", "[IsEditorPage] hideSquareAvatar");
                    detailMeListener = DetailSelectMeView.this.socialStatusListener;
                    if (detailMeListener != null) {
                        detailMeListener.hideSquareAvatar();
                    }
                    DetailSelectMeView.this.getBinding().commonView.getAvatarView().setStaticSource(data.getPlayableSource(), true);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isCurStatus(Integer statusId, Boolean needCheckSelectAndPick) {
        boolean z16;
        Iterator<T> it;
        Object obj;
        BaseResourceInfo baseResourceInfo;
        OnlineStatus status;
        int i3;
        SquareAvatarExtra extra;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        Integer num = null;
        Boolean valueOf = squareAvatarItem != null ? Boolean.valueOf(Intrinsics.areEqual(SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem), statusId)) : null;
        SquareAvatarItem squareAvatarItem2 = this.selectedAvatarItem;
        if (squareAvatarItem2 != null && (extra = squareAvatarItem2.getExtra()) != null) {
            extra.getIsMultiMotion();
        }
        if (!Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
            return false;
        }
        List<BaseResourceInfo> resourceList = statusId != null ? getResourceList(statusId.intValue()) : null;
        if (resourceList != null && resourceList.size() > 1) {
            if (needCheckSelectAndPick != null) {
                Iterator<BaseResourceInfo> it5 = resourceList.iterator();
                int i16 = 0;
                while (true) {
                    i3 = -1;
                    if (!it5.hasNext()) {
                        i16 = -1;
                        break;
                    }
                    if (it5.next().getHasSelected()) {
                        break;
                    }
                    i16++;
                }
                Iterator<BaseResourceInfo> it6 = resourceList.iterator();
                int i17 = 0;
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    if (it6.next().getHasPick()) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
                if (i16 != i3) {
                    z16 = false;
                    it = resourceList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((BaseResourceInfo) obj).getHasSelected()) {
                            break;
                        }
                    }
                    baseResourceInfo = (BaseResourceInfo) obj;
                    if (baseResourceInfo != null && (status = baseResourceInfo.getStatus()) != null) {
                        num = Integer.valueOf(status.getId());
                    }
                    if (Intrinsics.areEqual(num, statusId) || !z16) {
                    }
                }
            }
            z16 = true;
            it = resourceList.iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            baseResourceInfo = (BaseResourceInfo) obj;
            if (baseResourceInfo != null) {
                num = Integer.valueOf(status.getId());
            }
            return Intrinsics.areEqual(num, statusId) ? false : false;
        }
        return true;
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onBackEvent() {
        onBack();
    }

    @Override // com.tencent.state.battery.ISquareBatteryStatusObserver
    public void onBatteryInfoChange(int capacity, boolean levelChange, boolean powerConnect) {
        OnlineStatus onlineStatus;
        Resource userResource;
        if (this.isEditorPage) {
            if (!levelChange || this.hasBatteryLevelChangeInEditorPage) {
                return;
            }
            this.hasBatteryLevelChangeInEditorPage = true;
            return;
        }
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (onlineStatus = squareAvatarItem.getExtra().getOnlineStatus()) == null) {
            return;
        }
        updateBubbleView(onlineStatus);
        if (!levelChange || (userResource = squareAvatarItem.getUserResource()) == null) {
            return;
        }
        playAvatar(Integer.valueOf(onlineStatus.getId()), userResource);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, (r0 == null || (r0 = r0.getReceiver()) == null) ? null : java.lang.String.valueOf(r0.f443328a)) == false) goto L16;
     */
    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDecodeComplete(String uin, Bitmap avatar) {
        o sender;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!Intrinsics.areEqual(this.currentFriendUin, uin)) {
            SquareMultiMotionDetailData squareMultiMotionDetailData = this.inviteState;
            String str = null;
            if (squareMultiMotionDetailData != null && squareMultiMotionDetailData.isMeSender()) {
                SquareMultiMotionDetailData squareMultiMotionDetailData2 = this.inviteState;
            }
            SquareMultiMotionDetailData squareMultiMotionDetailData3 = this.inviteState;
            if (squareMultiMotionDetailData3 == null || !squareMultiMotionDetailData3.isMeReceiver()) {
                return;
            }
            SquareMultiMotionDetailData squareMultiMotionDetailData4 = this.inviteState;
            if (squareMultiMotionDetailData4 != null && (sender = squareMultiMotionDetailData4.getSender()) != null) {
                str = String.valueOf(sender.f443328a);
            }
            if (!Intrinsics.areEqual(uin, str)) {
                return;
            }
        }
        this.binding.selector.getImage().setImageBitmap(avatar);
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onDoubleClickEvent() {
    }

    @Override // com.tencent.state.view.BubbleEditListener
    public void onEditTextChange() {
        TextView textView = this.binding.editCustomTextNum;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.editCustomTextNum");
        textView.setText(getCurTextScale());
        SquareImageView squareImageView = this.binding.editCustomClearIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.editCustomClearIcon");
        squareImageView.setVisibility(getEditTextLength() > 0 ? 0 : 8);
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onEnterScaleAnimEnd() {
        SquareBaseKt.getSquareLog().i(TAG, "[SquareScaleDetail] hideSquareAvatar");
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.hideSquareAvatar();
        }
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onFragmentShowToast(String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.motionUnLockTip = tip;
    }

    public final void onFriendSelected(String uin, boolean isUpdateUinOnly, Integer withModelGender) {
        if (!Intrinsics.areEqual(this.currentFriendUin, uin)) {
            this.currentFriendUin = uin;
            this.withModelGender = withModelGender;
            if (isUpdateUinOnly) {
                return;
            }
            invalidateAllMultiResource(withModelGender);
            onInvalidateInviteUI(withModelGender);
        }
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void onInviteStateChanged(SquareMultiMotionDetailData state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SquareBaseKt.getSquareLog().i(TAG, "onInviteStateChanged: currentStatus=" + this.inviteStatus + ", state=" + state);
        if (state.getInviteStatus() != this.inviteStatus) {
            this.inviteStatus = state.getInviteStatus();
            this.inviteState = state;
            onInvalidateInviteUI$default(this, null, 1, null);
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    /* renamed from: onIsEditEnter, reason: from getter */
    public boolean getIsEditorPage() {
        return this.isEditorPage;
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onLoadClick() {
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.refreshStatusPanel();
        }
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void onMenuClick() {
        this.reporter.reportEvent("clck", this.binding.commonView.getSetting(), new LinkedHashMap());
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onPublicButtonStatus(boolean enable) {
        Button button = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
        button.setEnabled(enable);
        LinearLayout btn = this.binding.selector.getBtn();
        if (enable) {
            BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
            if (currentResourceInfo != null && currentResourceInfo.getIsMultiAction()) {
                btn.setBackgroundResource(R.drawable.grd);
            }
            this.publishButTexToChoseFriend = false;
            Button button2 = this.binding.publish;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.publish");
            button2.setText(getResources().getString(R.string.f169752xe4));
            this.binding.publish.setTextColor(-1);
            return;
        }
        BaseResourceInfo currentResourceInfo2 = getCurrentResourceInfo();
        if (currentResourceInfo2 == null || !currentResourceInfo2.getIsMultiAction()) {
            return;
        }
        this.publishButTexToChoseFriend = true;
        Button button3 = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.publish");
        button3.setEnabled(true);
        Button button4 = this.binding.publish;
        Intrinsics.checkNotNullExpressionValue(button4, "binding.publish");
        button4.setText(getResources().getString(R.string.xhf));
        btn.setBackgroundResource(R.drawable.grc);
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onResetStatus(int statusId, Integer actionId) {
        Object obj;
        SquareAvatarExtra extra;
        Iterator<T> it = getResourceList(statusId).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            BaseResourceInfo baseResourceInfo = (BaseResourceInfo) obj;
            boolean z16 = true;
            boolean z17 = baseResourceInfo.getStatus().getId() == statusId;
            if (actionId == null) {
                z16 = z17;
            } else if (!Intrinsics.areEqual(baseResourceInfo.getActionId(), actionId) || !z17) {
                z16 = false;
            }
            if (z16) {
                break;
            }
        }
        BaseResourceInfo baseResourceInfo2 = (BaseResourceInfo) obj;
        OnlineStatus status = baseResourceInfo2 != null ? baseResourceInfo2.getStatus() : null;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null) {
            return;
        }
        extra.setOnlineStatus(status);
    }

    public final void onSharePoster() {
        loadPosterInfo(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$onSharePoster$1
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
                DetailMeListener detailMeListener;
                SquareAvatarItem squareAvatarItem;
                SquareMultiMotionDetailData squareMultiMotionDetailData;
                detailMeListener = DetailSelectMeView.this.socialStatusListener;
                if (detailMeListener != null) {
                    squareAvatarItem = DetailSelectMeView.this.currentSquareItem;
                    squareMultiMotionDetailData = DetailSelectMeView.this.inviteState;
                    detailMeListener.clickShareMultiPoster(squareAvatarItem, squareMultiMotionDetailData);
                }
            }
        });
        this.reporter.reportEvent("clck", this.binding.commonView.getPosterShare(), new LinkedHashMap());
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onSingleClickEvent(MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.isEditorPage) {
            breakEdit();
        }
        if (this.binding.commonView.isClickAvatar(e16, this.isEditorPage)) {
            return;
        }
        onBack();
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onStatusClick(OnlineStatus status, boolean motionLock, Function1<? super Boolean, Unit> callback) {
        RecordResourceInfo displayResource$default;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[DMV][SC] onStatusClick start, ");
        sb5.append(status.getShortDes());
        sb5.append(", lock:");
        sb5.append(motionLock);
        sb5.append(", hasPublish:");
        sb5.append(this.hasPublish);
        sb5.append(", visible:");
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
        sb5.append(com.tencent.state.ViewExtensionsKt.isVisible(squareOnlineStatusViewPanel));
        squareLog.d(TAG, sb5.toString());
        if (this.hasPublish) {
            return;
        }
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel2 = this.binding.onlineStatusPanel;
        Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel2, "binding.onlineStatusPanel");
        if (squareOnlineStatusViewPanel2.getVisibility() != 0) {
            return;
        }
        this.curMotionLock = motionLock;
        boolean z16 = false;
        BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(status.getId()), false, 2, null);
        if (targetActionFromActionGroup$default != null && (displayResource$default = BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, this.inviteState, this.currentFriendUin, null, 8, null)) != null) {
            z16 = displayResource$default.getHasDynamicRecord();
        }
        if (canShowBatteryDialog(status)) {
            showBatteryDialog(status);
        } else if (canShowMusicDialog(status)) {
            showMusicDialog(status);
        } else {
            changeStatus(status, true);
        }
        SquareBaseKt.getSquareLog().d(TAG, "[DMV][SC] onStatusClick end, " + status.getShortDes());
        callback.invoke(Boolean.valueOf(z16));
    }

    @Override // com.tencent.state.status.ISquareOnlineStatusPanelListener
    public void onStatusPanelPageSelected(int pageIndex) {
        this.multiActionPanelHelper.onStatusPanelPageSelected(pageIndex);
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel.PanelItemClickListener
    public void onStatusSelected(int statusId, Integer actionId) {
        this.multiActionPanelHelper.showPanel(getResourceList(statusId), actionId);
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void playLikeAnimation(int likeType) {
        dismissCurAnimationPopWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LikeAnimationPagView likeAnimationPagView = new LikeAnimationPagView(context, likeType, false, 4, null);
        likeAnimationPagView.setWidth(-1);
        likeAnimationPagView.setHeight(-2);
        Unit unit = Unit.INSTANCE;
        this.animationPopWindow = likeAnimationPagView;
        likeAnimationPagView.showAsDropDown(this.binding.avatarBubble);
    }

    public final void recordAvatar(String friendUin, Integer friendGender, Resource resource, OnlineStatus status, boolean isBuyTheSame, Function3<? super OnlineStatus, ? super Resource, ? super Boolean, Unit> onRecordStart) {
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.recordAvatar(friendUin, friendGender, resource, status, new DetailSelectMeView$recordAvatar$1(this, onRecordStart, status, isBuyTheSame));
        }
    }

    public final void refreshCreateRoleRedDot(FragmentActivity activity, VasBaseFragment fragment, boolean registered, SquareNoviceGuideConfig config) {
        this.dressBubbleHelper.refreshCreateRoleRedDot(activity, fragment, registered, config);
    }

    public final void reportNewStatusData(String eventId) {
        String str;
        Map<String, Object> mutableMapOf;
        Integer motionId;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        IReporter iReporter = this.reporter;
        LinearLayout linearLayout = this.binding.changeStatusContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.changeStatusContainer");
        Pair[] pairArr = new Pair[5];
        NewStatusInfo newStatusInfo = this.newStatusInfo;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_RED_ID, Long.valueOf(newStatusInfo != null ? newStatusInfo.getRedDotId() : 0L));
        NewStatusInfo newStatusInfo2 = this.newStatusInfo;
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_RED_ACTION_ID, Integer.valueOf((newStatusInfo2 == null || (motionId = newStatusInfo2.getMotionId()) == null) ? 0 : motionId.intValue()));
        NewStatusInfo newStatusInfo3 = this.newStatusInfo;
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_REDPOINT_STATE_ID, Integer.valueOf(newStatusInfo3 != null ? newStatusInfo3.getStatusId() : 0));
        NewStatusInfo newStatusInfo4 = this.newStatusInfo;
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_REDPOINT_RICH_STATE_ID, Integer.valueOf(newStatusInfo4 != null ? newStatusInfo4.getRichStatusId() : 0));
        NewStatusInfo newStatusInfo5 = this.newStatusInfo;
        if (newStatusInfo5 == null || (str = newStatusInfo5.getCategoryId()) == null) {
            str = "";
        }
        pairArr[4] = TuplesKt.to("zplan_choose_tab_id", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iReporter.reportEvent(eventId, linearLayout, mutableMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportPublish(boolean success, int errorCode) {
        String sourceFrom;
        Object obj;
        Map<String, Object> mutableMapOf;
        Resource userResource;
        Integer richStatusId;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        RecordResourceInfo displayResource$default;
        SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
        BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, squareAvatarItem != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem) : null, false, 2, null);
        int hasDynamicRecord = (targetActionFromActionGroup$default == null || (displayResource$default = BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, this.inviteState, this.currentFriendUin, null, 8, null)) == null) ? 0 : displayResource$default.getHasDynamicRecord();
        IReporter iReporter = this.reporter;
        Pair[] pairArr = new Pair[11];
        SquareAvatarItem squareAvatarItem2 = this.selectedAvatarItem;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf((squareAvatarItem2 == null || (extra = squareAvatarItem2.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null) ? 0 : onlineStatus.getTopStatusId()));
        SquareAvatarItem squareAvatarItem3 = this.selectedAvatarItem;
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf((squareAvatarItem3 == null || (richStatusId = SquareResourceManagerKt.getRichStatusId(squareAvatarItem3)) == null) ? 0 : richStatusId.intValue()));
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_NEED_LOADING, Integer.valueOf(hasDynamicRecord ^ 1));
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_IS_SET_CUSTOMIZE_TEXT, Integer.valueOf((this.curRequestText.length() == 0 ? 1 : 0) ^ 1));
        pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_CUSTOMIZE_TEXT_NUM, Integer.valueOf(OnlineStatusBubbleViewHelper.INSTANCE.getEditTextLength(this.curRequestText)));
        pairArr[5] = TuplesKt.to("zplan_action_result", Integer.valueOf(success ? 1 : 0));
        pairArr[6] = TuplesKt.to("zplan_action_fail_reason", Integer.valueOf(errorCode));
        EntranceSource entranceSource = this.entranceSource;
        if (entranceSource == null || (sourceFrom = entranceSource.getRefSource()) == null) {
            sourceFrom = SquareGroupReportComponentKt.getSourceFrom(getContext());
        }
        pairArr[7] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, sourceFrom);
        SquareAvatarItem squareAvatarItem4 = this.selectedAvatarItem;
        pairArr[8] = TuplesKt.to(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf((squareAvatarItem4 == null || (userResource = squareAvatarItem4.getUserResource()) == null) ? 0 : userResource.getActionId()));
        pairArr[9] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_STATE_PUBLISH_SCENE, 0);
        DetailMeFragmentConfig detailMeFragmentConfig = this.entranceConfig;
        if (detailMeFragmentConfig == null || (obj = detailMeFragmentConfig.getCurRichStatusId()) == null) {
            obj = "";
        }
        pairArr[10] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_GUIDE_STATUS_ID, obj);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_PUBLISH, mutableMapOf);
    }

    public final void resetAvatarAction() {
        Iterator<Map.Entry<Integer, List<BaseResourceInfo>>> it = this.recordResourceMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                for (RecordResourceInfo recordResourceInfo : ((BaseResourceInfo) it5.next()).getRecordResources()) {
                    recordResourceInfo.setHasDynamicRecord(false);
                    recordResourceInfo.getResource().resetDefault();
                }
            }
        }
    }

    public final void resetCurrentResource() {
        List<AvatarAction> standActions;
        List<AvatarAction> actions;
        Resource curResource = getCurResource();
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem != null && (actions = squareAvatarItem.getActions()) != null) {
            Iterator<T> it = actions.iterator();
            while (it.hasNext()) {
                resetDefaultResource((AvatarAction) it.next(), curResource);
            }
        }
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        if (squareAvatarItem2 == null || (standActions = squareAvatarItem2.getStandActions()) == null) {
            return;
        }
        Iterator<T> it5 = standActions.iterator();
        while (it5.hasNext()) {
            resetDefaultResource((AvatarAction) it5.next(), curResource);
        }
    }

    public final void resetPanelView() {
        this.binding.onlineStatusPanel.resetPanelView();
    }

    public final void setNewStatusInfo(NewStatusInfo newStatusInfo) {
        this.newStatusInfo = newStatusInfo;
    }

    public final void setPoiHandler(AvatarPoiHandler poiHandler) {
        AvatarLocationInfo locationInfo;
        AvatarPoiHandler avatarPoiHandler;
        Intrinsics.checkNotNullParameter(poiHandler, "poiHandler");
        this.poiHandler = poiHandler;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (squareAvatarItem == null || (locationInfo = squareAvatarItem.getLocationInfo()) == null || (avatarPoiHandler = this.poiHandler) == null) {
            return;
        }
        avatarPoiHandler.setPoiInfo(locationInfo);
    }

    public final void setPublishButTexToChoseFriend(boolean z16) {
        this.publishButTexToChoseFriend = z16;
    }

    public final void setSelectStatusId(Integer statusId, Integer richStatusId, Integer actionId) {
        this.binding.onlineStatusPanel.setMotionSelect(statusId, richStatusId, actionId);
    }

    public final void setShowInteractionRecord(Function0<Unit> function0) {
        this.showInteractionRecord = function0;
    }

    public final void showRecordLoading() {
        View view;
        if (!this.isEditorPage) {
            SquareBaseKt.getSquareLog().i(TAG, "isEditorPage is " + this.isEditorPage);
            return;
        }
        BaseResourceInfo currentResourceInfo = getCurrentResourceInfo();
        if (currentResourceInfo != null && currentResourceInfo.getIsMultiAction() && !SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            LinearLayout linearLayout = this.binding.stateLoadingView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLoadingView");
            linearLayout.setVisibility(8);
            return;
        }
        ISquarePagView iSquarePagView = this.squarePagRootView;
        if (iSquarePagView != null) {
            ISquarePagView.DefaultImpls.playPag$default(iSquarePagView, 0, 1, null);
        }
        ISquarePagView iSquarePagView2 = this.squarePagRootView;
        if (iSquarePagView2 != null && (view = iSquarePagView2.getView()) != null) {
            view.setVisibility(0);
        }
        TextView textView = this.binding.stateLoadingTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.stateLoadingTips");
        textView.setText("\u6362\u88c5\u4e2d");
        LinearLayout linearLayout2 = this.binding.stateLoadingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.stateLoadingView");
        linearLayout2.setVisibility(0);
        BaseResourceInfo currentResourceInfo2 = getCurrentResourceInfo();
        if (currentResourceInfo2 == null || !currentResourceInfo2.getIsMultiAction()) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnUiDelayed(3000L, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$showRecordLoading$1
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
                LinearLayout linearLayout3 = DetailSelectMeView.this.getBinding().stateLoadingView;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.stateLoadingView");
                if (linearLayout3.getVisibility() == 0) {
                    TextView textView2 = DetailSelectMeView.this.getBinding().stateLoadingTips;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.stateLoadingTips");
                    textView2.setText("\u6362\u88c5\u65f6\u53ef\u76f4\u63a5\u53d1\u5e03");
                }
            }
        });
    }

    public final void showUnLockToast() {
        if (this.motionUnLockTip.length() > 0) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            commonUtils.showToast(context, this.motionUnLockTip, 2);
        }
        this.motionUnLockTip = "";
    }

    public final void syncRolePageResult(boolean registered) {
        DetailMeDressBubbleHelper detailMeDressBubbleHelper = this.dressBubbleHelper;
        if (detailMeDressBubbleHelper != null) {
            detailMeDressBubbleHelper.syncRolePageResult(registered);
        }
    }

    public final void updateBlindBoxTips(boolean canShow) {
        RelativeLayout relativeLayout = this.binding.blindBoxContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.blindBoxContainer");
        relativeLayout.setVisibility(canShow ? 0 : 8);
    }

    public final void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.binding.avatarBubble.updateBubbleSkin(bubbleInfo);
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void updateBubbleView(OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        if (this.isEditorPage) {
            if (this.isEditing) {
                AvatarOnlineStatusDetailBubble.showEditedView$default(this.binding.avatarBubble, null, false, 3, null);
                return;
            } else {
                this.binding.avatarBubble.showChangeStatusView();
                return;
            }
        }
        AvatarOnlineStatusDetailBubble.showCommonView$default(this.binding.avatarBubble, onlineStatus, false, 2, null);
    }

    public final void updateLockStatus(StatusLockInfo lockInfo) {
        DetailMeListener detailMeListener = this.socialStatusListener;
        if (detailMeListener != null) {
            detailMeListener.onClickLockMotion(lockInfo);
        }
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public void updatePlayState(SquareAvatarItem data) {
        SpecialStatus extraData;
        SongInfo songInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
        OnlineStatus onlineStatus = data.getExtra().getOnlineStatus();
        avatarOnlineStatusDetailBubble.updatePlayIcon((onlineStatus == null || (extraData = onlineStatus.getExtraData()) == null || (songInfo = extraData.getSongInfo()) == null) ? null : songInfo.getSongId(), data.isMe());
    }

    public final void updatePoiUI(AvatarLocationInfo locationInfo, boolean isChange) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SquareAvatarExtra extra2;
        OnlineStatus onlineStatus2;
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        if (this.binding.onlineStatusPanel.isMotionLockBarShow()) {
            isChange = false;
        } else {
            SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
            Integer num = null;
            Integer valueOf = (squareAvatarItem == null || (extra2 = squareAvatarItem.getExtra()) == null || (onlineStatus2 = extra2.getOnlineStatus()) == null) ? null : Integer.valueOf(onlineStatus2.getId());
            SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
            if (squareAvatarItem2 != null && (extra = squareAvatarItem2.getExtra()) != null && (onlineStatus = extra.getOnlineStatus()) != null) {
                num = Integer.valueOf(onlineStatus.getId());
            }
            if (!Intrinsics.areEqual(valueOf, num)) {
                isChange = true;
            }
        }
        onPublicButtonStatus(isChange);
        this.binding.selectLocationBar.updateLocation(locationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindHostSimpleView() {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        String uin;
        SquareAvatarExtra extra2;
        this.isEditorPage = false;
        SquareAvatarItem squareAvatarItem = this.currentSquareItem;
        if (((squareAvatarItem == null || (extra2 = squareAvatarItem.getExtra()) == null) ? null : extra2.getOnlineStatus()) == null) {
            FrameLayout frameLayout = this.binding.avatarBubbleContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarBubbleContainer");
            frameLayout.setVisibility(8);
        }
        this.binding.avatarBubble.setFocus(true);
        bindLikeListBanner();
        SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
        if (squareAvatarItem2 != null && (uin = squareAvatarItem2.getUin()) != null) {
            RelativeLayout relativeLayout = this.binding.operatorContainer.singleOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.operatorContainer.singleOperatorContainer");
            relativeLayout.setVisibility(0);
            LinearLayout linearLayout = this.binding.operatorContainer.multiOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.operatorContainer.multiOperatorContainer");
            linearLayout.setVisibility(8);
            View view = this.binding.operatorContainer.singleOperatorQzoneRedDot;
            Intrinsics.checkNotNullExpressionValue(view, "binding.operatorContaine\u2026singleOperatorQzoneRedDot");
            view.setVisibility(8);
            View view2 = this.binding.operatorContainer.operatorDressMallRedDot;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.operatorContainer.operatorDressMallRedDot");
            view2.setVisibility(8);
            Square square = Square.INSTANCE;
            if (square.getConfig().getCommonUtils().checkZplanAccessible(uin)) {
                RelativeLayout relativeLayout2 = this.binding.operatorContainer.singleOperatorContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.operatorContainer.singleOperatorContainer");
                if (relativeLayout2.getVisibility() == 0) {
                    RelativeLayout relativeLayout3 = this.binding.operatorContainer.singleOperatorContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.operatorContainer.singleOperatorContainer");
                    relativeLayout3.setVisibility(8);
                    LinearLayout linearLayout2 = this.binding.operatorContainer.multiOperatorContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.operatorContainer.multiOperatorContainer");
                    linearLayout2.setVisibility(0);
                    RelativeLayout relativeLayout4 = this.binding.operatorContainer.operatorEnterQzoneContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
                    relativeLayout4.setVisibility(0);
                }
                RelativeLayout relativeLayout5 = this.binding.operatorContainer.operatorEnterDressMallContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout5, "binding.operatorContaine\u2026orEnterDressMallContainer");
                relativeLayout5.setVisibility(0);
            } else {
                RelativeLayout relativeLayout6 = this.binding.operatorContainer.operatorEnterDressMallContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout6, "binding.operatorContaine\u2026orEnterDressMallContainer");
                relativeLayout6.setVisibility(8);
            }
            square.getConfig().getCommonUtils().shouldShowSmallHomeEntry(uin, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$bindHostSimpleView$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IReporter iReporter;
                    if (z16) {
                        RelativeLayout relativeLayout7 = DetailSelectMeView.this.getBinding().operatorContainer.singleOperatorContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout7, "binding.operatorContainer.singleOperatorContainer");
                        if (relativeLayout7.getVisibility() == 0) {
                            RelativeLayout relativeLayout8 = DetailSelectMeView.this.getBinding().operatorContainer.singleOperatorContainer;
                            Intrinsics.checkNotNullExpressionValue(relativeLayout8, "binding.operatorContainer.singleOperatorContainer");
                            relativeLayout8.setVisibility(8);
                            LinearLayout linearLayout3 = DetailSelectMeView.this.getBinding().operatorContainer.multiOperatorContainer;
                            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.operatorContainer.multiOperatorContainer");
                            linearLayout3.setVisibility(0);
                            RelativeLayout relativeLayout9 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterQzoneContainer;
                            Intrinsics.checkNotNullExpressionValue(relativeLayout9, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
                            relativeLayout9.setVisibility(0);
                        }
                        RelativeLayout relativeLayout10 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterSmallHomeContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout10, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                        relativeLayout10.setVisibility(0);
                        iReporter = DetailSelectMeView.this.reporter;
                        RelativeLayout relativeLayout11 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterSmallHomeContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout11, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                        iReporter.reportEvent("imp", relativeLayout11, new LinkedHashMap());
                        return;
                    }
                    RelativeLayout relativeLayout12 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterSmallHomeContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout12, "binding.operatorContaine\u2026orEnterSmallHomeContainer");
                    relativeLayout12.setVisibility(8);
                }
            });
            if (!this.isEditorPage) {
                LinearLayout linearLayout3 = this.binding.hostFocusView;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.hostFocusView");
                linearLayout3.setVisibility(0);
                updateOperationIconsLocation();
            }
        }
        SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
        if (squareAvatarItem3 != null && (extra = squareAvatarItem3.getExtra()) != null && (onlineStatus = extra.getOnlineStatus()) != null) {
            AvatarOnlineStatusDetailBubble.showCommonView$default(this.binding.avatarBubble, onlineStatus, false, 2, null);
        }
        RelativeLayout relativeLayout7 = this.binding.operatorContainer.singleOperatorContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout7, "binding.operatorContainer.singleOperatorContainer");
        if (relativeLayout7.getVisibility() == 0) {
            IReporter iReporter = this.reporter;
            RelativeLayout relativeLayout8 = this.binding.operatorContainer.singleOperatorContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout8, "binding.operatorContainer.singleOperatorContainer");
            iReporter.reportEvent("imp", relativeLayout8, new LinkedHashMap());
        }
        RelativeLayout relativeLayout9 = this.binding.operatorContainer.operatorEnterQzoneContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout9, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
        if (relativeLayout9.getVisibility() == 0) {
            IReporter iReporter2 = this.reporter;
            RelativeLayout relativeLayout10 = this.binding.operatorContainer.operatorEnterQzoneContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout10, "binding.operatorContaine\u2026eratorEnterQzoneContainer");
            iReporter2.reportEvent("imp", relativeLayout10, new LinkedHashMap());
        }
        this.binding.getMRv().postDelayed(new Runnable() { // from class: com.tencent.state.square.detail.DetailSelectMeView$bindHostSimpleView$3
            @Override // java.lang.Runnable
            public final void run() {
                IReporter iReporter3;
                Map<String, Object> addStatusBtnReportParams;
                IReporter iReporter4;
                Map<String, Object> dressIconReportParams;
                RelativeLayout relativeLayout11 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterDressMallContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout11, "binding.operatorContaine\u2026orEnterDressMallContainer");
                if (com.tencent.state.ViewExtensionsKt.isVisible(relativeLayout11)) {
                    iReporter4 = DetailSelectMeView.this.reporter;
                    RelativeLayout relativeLayout12 = DetailSelectMeView.this.getBinding().operatorContainer.operatorEnterDressMallContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout12, "binding.operatorContaine\u2026orEnterDressMallContainer");
                    dressIconReportParams = DetailSelectMeView.this.getDressIconReportParams();
                    iReporter4.reportEvent("imp", relativeLayout12, dressIconReportParams);
                }
                iReporter3 = DetailSelectMeView.this.reporter;
                LinearLayout linearLayout4 = DetailSelectMeView.this.getBinding().changeStatusContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.changeStatusContainer");
                addStatusBtnReportParams = DetailSelectMeView.this.getAddStatusBtnReportParams();
                iReporter3.reportEvent("imp", linearLayout4, addStatusBtnReportParams);
            }
        }, 300L);
        this.dressBubbleHelper.initConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getAddStatusBtnReportParams() {
        Map<String, Object> mutableMapOf;
        NoviceGuideRecordForReport noviceGuideRecord;
        Pair[] pairArr = new Pair[2];
        DetailMeFragmentConfig detailMeFragmentConfig = this.entranceConfig;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_DYNAMIC, Integer.valueOf((detailMeFragmentConfig == null || (noviceGuideRecord = detailMeFragmentConfig.getNoviceGuideRecord()) == null) ? 0 : noviceGuideRecord.getPublishStatusDynamicType()));
        StringBuilder sb5 = new StringBuilder();
        sb5.append('+');
        TextView textView = this.binding.chatOrStatusText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.chatOrStatusText");
        sb5.append(textView.getText());
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ADD_TEXT_BTN, sb5.toString());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getDressIconReportParams() {
        Map<String, Object> mutableMapOf;
        View view = this.binding.operatorContainer.operatorDressMallRedDot;
        Intrinsics.checkNotNullExpressionValue(view, "binding.operatorContainer.operatorDressMallRedDot");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_redpoint", Integer.valueOf(com.tencent.state.ViewExtensionsKt.isVisible(view) ? 1 : 0)));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getPublishBtnReportParams(boolean isMultiAction) {
        Map<String, Object> mutableMapOf;
        NoviceGuideRecordForReport noviceGuideRecord;
        Pair[] pairArr = new Pair[2];
        DetailMeFragmentConfig detailMeFragmentConfig = this.entranceConfig;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_DYNAMIC, Integer.valueOf((detailMeFragmentConfig == null || (noviceGuideRecord = detailMeFragmentConfig.getNoviceGuideRecord()) == null) ? 0 : noviceGuideRecord.getPublishStatusDynamicType()));
        pairArr[1] = TuplesKt.to("zplan_is_single_or_double_pose", Integer.valueOf(isMultiAction ? 1 : 0));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void updateEditorBubbleLocation() {
        Location realAvatarLocation = getRealAvatarLocation(true);
        if (realAvatarLocation != null) {
            RelativeLayout relativeLayout = this.binding.avatarLocationView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
            float y16 = realAvatarLocation.getY();
            Intrinsics.checkNotNullExpressionValue(this.binding.avatarLocationView, "binding.avatarLocationView");
            relativeLayout.setY((y16 - r4.getHeight()) + com.tencent.state.ViewExtensionsKt.dip((View) this, 8));
            this.binding.commonView.getMultiParent().setY(realAvatarLocation.getY() + realAvatarLocation.getHeight() + com.tencent.state.ViewExtensionsKt.dip((View) this, 10));
        }
    }

    @Override // com.tencent.state.view.BubbleEditListener
    public void enterEdit() {
        this.isEditing = true;
        doEditBubble();
        this.binding.selector.setListAlphaGray();
    }

    public final void failPublish() {
        this.hasPublish = false;
    }

    @Override // com.tencent.state.square.detail.DetailCommonView.CommonListener
    public void onDoubleClickEvent(MotionEvent e16) {
        DetailMeListener detailMeListener;
        Intrinsics.checkNotNullParameter(e16, "e");
        DetailCommonView.CommonListener.DefaultImpls.onDoubleClickEvent(this, e16);
        if (this.clickUtils.isFastDoubleClick() || (detailMeListener = this.socialStatusListener) == null || !detailMeListener.isClickAvatar(e16, false)) {
            return;
        }
        onConfigInteraction();
    }

    private final Location getRealAvatarLocation(boolean isEditor) {
        if (isEditor) {
            return this.binding.commonView.getEditorAvatarLocation();
        }
        return this.binding.commonView.getAvatarLocation();
    }

    private final void resetDefaultResource(AvatarAction action, Resource resource) {
        if (resource == null) {
            action.getLookFront().resetDefault();
            return;
        }
        action.getLookFront().setDefault(true);
        action.getLookFront().getDynamic().setUrl(resource.getDynamic().getDefaultUrl());
        action.getLookFront().getDynamic().setMd5(resource.getDynamic().getDefaultMd5());
        action.getLookFront().getStatic().setUrl(resource.getStatic().getDefaultUrl());
        action.getLookFront().getStatic().setMd5(resource.getStatic().getDefaultMd5());
    }

    private final void updateInviteButton(BaseResourceInfo info, SquareMultiMotionDetailData inviteState) {
        if (info != null && info.getIsMultiAction()) {
            this.binding.selector.showButton();
            if (this.currentFriendUin != null) {
                showPublishButton();
                return;
            } else {
                onPublicButtonStatus(false);
                return;
            }
        }
        showPublishButton();
        this.binding.selector.hideButton();
    }

    public final SquareAvatarItem curSelectedAvatarItem(boolean needUpdateText) {
        if (needUpdateText) {
            needUpdateCustomText();
        }
        return this.selectedAvatarItem;
    }

    public final void onStatusChange(boolean success) {
        SquareAvatarExtra extra;
        if (success) {
            AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
            SquareAvatarItem squareAvatarItem = this.currentSquareItem;
            OnlineStatus onlineStatus = (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null) ? null : extra.getOnlineStatus();
            SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
            avatarOnlineStatusDetailBubble.onStatusChange(onlineStatus, squareAvatarItem2 != null ? squareAvatarItem2.isMe() : false);
            initBatteryObserverIfNeeded("detail_status_change");
        }
    }

    public final void updateDraftSp(boolean isClear) {
        if (isClear) {
            IMMKV.DefaultImpls.encodeString$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, "", null, false, 12, null);
            return;
        }
        View view = this.binding.darkView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
        if (view.getVisibility() == 0) {
            SMMKV squareMMKV = SquareBaseKt.getSquareMMKV();
            String textString = this.binding.avatarBubble.getTextString();
            if (textString == null) {
                textString = "";
            }
            IMMKV.DefaultImpls.encodeString$default(squareMMKV, SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, textString, null, false, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBubbleLocation() {
        Location realAvatarLocation$default = getRealAvatarLocation$default(this, false, 1, null);
        if (realAvatarLocation$default != null) {
            RelativeLayout relativeLayout = this.binding.avatarLocationView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.avatarLocationView");
            float y16 = realAvatarLocation$default.getY();
            Intrinsics.checkNotNullExpressionValue(this.binding.avatarLocationView, "binding.avatarLocationView");
            relativeLayout.setY((y16 - r4.getHeight()) + com.tencent.state.ViewExtensionsKt.dip((View) this, 8));
            this.binding.commonView.getMultiParent().setY(realAvatarLocation$default.getY() + realAvatarLocation$default.getHeight() + com.tencent.state.ViewExtensionsKt.dip((View) this, 10));
        }
    }

    public final BaseResourceInfo getTargetActionFromActionGroup(Integer statusId, boolean targetPicked) {
        if (statusId == null) {
            return null;
        }
        statusId.intValue();
        List<BaseResourceInfo> list = this.recordResourceMap.get(statusId);
        List<BaseResourceInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            SquareBaseKt.getSquareLog().d(TAG, "[DMV] getTargetActionFromActionGroup, id:" + statusId + ", targetPicked:" + targetPicked + ", list empty");
            return null;
        }
        for (BaseResourceInfo baseResourceInfo : list) {
            if (targetPicked && baseResourceInfo.getHasPick()) {
                return baseResourceInfo;
            }
            if (!targetPicked && baseResourceInfo.getHasSelected()) {
                return baseResourceInfo;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAvatarResource(SquareAvatarItem data, Resource resource) {
        if (resource == null || data == null) {
            return;
        }
        Iterator<T> it = data.getActions().iterator();
        while (it.hasNext()) {
            ((AvatarAction) it.next()).setLookFront(resource);
        }
        data.setLocation(MapItemKt.relocation(data.getLocation(), resource.getShowSize()));
    }

    private final void updateResourceAndPlay(final BaseResourceInfo info, SquareMultiMotionDetailData inviteState, final Integer withModelGender) {
        OnlineStatus status;
        final RecordResourceInfo displayResource;
        if (info != null && (displayResource = info.getDisplayResource(this.currentSquareItem, inviteState, this.currentFriendUin, withModelGender)) != null) {
            final SquareAvatarItem squareAvatarItem = this.selectedAvatarItem;
            if (squareAvatarItem != null) {
                SquareBaseKt.getSquareLog().i(TAG, "[DMV] updateResourceAndPlay, displayResource=" + displayResource);
                updateAvatarResource(squareAvatarItem, displayResource.getResource());
                MultiMotionUser multiUser = displayResource.getResource().getFilament().getMultiUser();
                if (multiUser != null) {
                    multiUser.setSelectUin(this.currentFriendUin);
                }
                if (info.getIsMultiAction() && (!info.getIsMultiAction() || this.currentFriendUin != null)) {
                    if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                        playResource(squareAvatarItem.getExtra().getOnlineStatus(), displayResource.getResource(), displayResource.getHasDynamicRecord());
                    }
                } else {
                    playResource(squareAvatarItem.getExtra().getOnlineStatus(), displayResource.getResource(), displayResource.getHasDynamicRecord());
                }
                if (!displayResource.getHasDynamicRecord() && (!info.getIsMultiAction() || (info.getIsMultiAction() && this.currentFriendUin != null))) {
                    recordAvatar$default(this, this.currentFriendUin, withModelGender, displayResource.getResource(), squareAvatarItem.getExtra().getOnlineStatus(), false, new Function3<OnlineStatus, Resource, Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeView$updateResourceAndPlay$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(OnlineStatus onlineStatus, Resource resource, Boolean bool) {
                            invoke(onlineStatus, resource, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(OnlineStatus onlineStatus, Resource resource, boolean z16) {
                            BaseResourceInfo currentResourceInfo;
                            Intrinsics.checkNotNullParameter(resource, "<anonymous parameter 1>");
                            if (z16) {
                                currentResourceInfo = this.getCurrentResourceInfo();
                                boolean areEqual = Intrinsics.areEqual(currentResourceInfo, info);
                                SquareBaseKt.getSquareLog().i("DetailSelectMeView", "[DMV] updateResourceAndPlay, isSame:" + areEqual + ", info:" + info + ", displayResource=" + displayResource);
                                if (info.getIsMultiAction() && areEqual) {
                                    this.playResource(SquareAvatarItem.this.getExtra().getOnlineStatus(), displayResource.getResource(), displayResource.getHasDynamicRecord());
                                }
                            } else {
                                SquareBaseKt.getSquareLog().i("DetailSelectMeView", "[DMV] updateResourceAndPlay, not start, info:" + info + ", displayResource=" + displayResource);
                            }
                            if (z16) {
                                return;
                            }
                            if (DetailSelectMeView.isCurStatus$default(this, onlineStatus != null ? Integer.valueOf(onlineStatus.getId()) : null, null, 2, null)) {
                                this.hideRecordLoading();
                            }
                        }
                    }, 16, null);
                }
                List<RecordResourceInfo> recordResources = info.getRecordResources();
                ArrayList arrayList = new ArrayList();
                for (Object obj : recordResources) {
                    RecordResourceInfo recordResourceInfo = (RecordResourceInfo) obj;
                    if ((Intrinsics.areEqual(recordResourceInfo, displayResource) ^ true) && !recordResourceInfo.getHasDynamicRecord()) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    recordAvatar$default(this, null, null, ((RecordResourceInfo) it.next()).getResource(), squareAvatarItem.getExtra().getOnlineStatus(), false, null, 48, null);
                }
                return;
            }
            return;
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[DMV] updateResourceAndPlay, ");
        sb5.append((info == null || (status = info.getStatus()) == null) ? null : status.getShortDes());
        sb5.append(", displayResource null");
        squareLog.d(TAG, sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initData(WeakReference<VasBaseFragment> fragment, PanelInfo panelInfo) {
        int collectionSizeOrDefault;
        Object firstOrNull;
        Object firstOrNull2;
        int i3;
        boolean z16;
        ResourceIdentify resourceIdentify;
        ResourceIdentify dynamic;
        RecordResourceInfo displayResource$default;
        String str;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(panelInfo, "panelInfo");
        List<PanelCategoryInfo> categoryList = panelInfo.getCategoryList();
        this.fragment = fragment;
        this.recordResourceMap.clear();
        List<PanelCategoryInfo> list = categoryList;
        boolean z17 = false;
        if (list == null || list.isEmpty()) {
            this.binding.onlineStatusPanel.panelLoadFailVisible(0);
            Button button = this.binding.publish;
            Intrinsics.checkNotNullExpressionValue(button, "binding.publish");
            button.setVisibility(8);
            FrameLayout frameLayout = this.binding.configInteraction;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.configInteraction");
            frameLayout.setVisibility(8);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i16 = 0;
        while (true) {
            Resource resource = null;
            if (i16 >= size) {
                break;
            }
            arrayList.add(categoryList.get(i16).getTip());
            Integer valueOf = Integer.valueOf(i16);
            List<StatusActionInfo> panelData = categoryList.get(i16).getPanelData();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(panelData, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (StatusActionInfo statusActionInfo : panelData) {
                this.recordResourceMap.put(Integer.valueOf(statusActionInfo.getStatusInfo().getId()), statusActionInfo.getActionList());
                if (OnlineStatusBubbleViewHelperKt.isBatteryStatus(statusActionInfo.getStatusInfo())) {
                    SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                    SquareAvatarItem squareAvatarItem = this.currentSquareItem;
                    if (squareAvatarItem == null || (str = squareAvatarItem.getUin()) == null) {
                        str = "";
                    }
                    SquareAvatarItem squareAvatarItem2 = this.currentSquareItem;
                    squareBatteryStatusManager.syncBatteryInfoIfNeeded(str, squareAvatarItem2 != null ? squareAvatarItem2.getIsGenderMale() : z17, "detail_panel");
                }
                BaseResourceInfo targetActionFromActionGroup$default = getTargetActionFromActionGroup$default(this, Integer.valueOf(statusActionInfo.getStatusInfo().getId()), z17, 2, resource);
                Resource resource2 = (targetActionFromActionGroup$default == null || (displayResource$default = BaseResourceInfo.getDisplayResource$default(targetActionFromActionGroup$default, this.currentSquareItem, null, null, null, 14, null)) == null) ? resource : displayResource$default.getResource();
                String id5 = categoryList.get(i16).getId();
                String name = categoryList.get(i16).getName();
                OnlineStatus statusInfo = statusActionInfo.getStatusInfo();
                String cornerUrl = statusActionInfo.getCornerUrl();
                SquareAvatarItem squareAvatarItem3 = this.currentSquareItem;
                Integer onlineStatusId = squareAvatarItem3 != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem3) : resource;
                boolean z18 = onlineStatusId != 0 && onlineStatusId.intValue() == statusActionInfo.getStatusInfo().getId();
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) statusActionInfo.getActionList());
                BaseResourceInfo baseResourceInfo = (BaseResourceInfo) firstOrNull;
                boolean isMultiAction = baseResourceInfo != null ? baseResourceInfo.getIsMultiAction() : true;
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) statusActionInfo.getActionList());
                BaseResourceInfo baseResourceInfo2 = (BaseResourceInfo) firstOrNull2;
                if (baseResourceInfo2 != null) {
                    i3 = size;
                    RecordResourceInfo displayResource$default2 = BaseResourceInfo.getDisplayResource$default(baseResourceInfo2, this.currentSquareItem, this.inviteState, this.currentFriendUin, null, 8, null);
                    if (displayResource$default2 != null && !displayResource$default2.getHasDynamicRecord()) {
                        z16 = true;
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(new StatusPanelData(i16, id5, name, statusInfo, cornerUrl, z18, new ReportData(isMultiAction, z16, statusActionInfo.getCornerName(), resource2 == null ? resource2.getActionId() : 0, (resource2 != null || (dynamic = resource2.getDynamic()) == null) ? 0 : dynamic.getSrc(), (resource2 != null || (resourceIdentify = resource2.getStatic()) == null) ? 0 : resourceIdentify.getSrc()), statusActionInfo.getShowMultiActionPickIcon(), statusActionInfo.getMultiActionPickIcon(), statusActionInfo.getPanelStatusTaskInfo(), null, 1024, null));
                        valueOf = valueOf;
                        arrayList2 = arrayList3;
                        categoryList = categoryList;
                        i16 = i16;
                        size = i3;
                        z17 = false;
                        resource = null;
                    }
                } else {
                    i3 = size;
                }
                z16 = false;
                ArrayList arrayList32 = arrayList2;
                arrayList32.add(new StatusPanelData(i16, id5, name, statusInfo, cornerUrl, z18, new ReportData(isMultiAction, z16, statusActionInfo.getCornerName(), resource2 == null ? resource2.getActionId() : 0, (resource2 != null || (dynamic = resource2.getDynamic()) == null) ? 0 : dynamic.getSrc(), (resource2 != null || (resourceIdentify = resource2.getStatic()) == null) ? 0 : resourceIdentify.getSrc()), statusActionInfo.getShowMultiActionPickIcon(), statusActionInfo.getMultiActionPickIcon(), statusActionInfo.getPanelStatusTaskInfo(), null, 1024, null));
                valueOf = valueOf;
                arrayList2 = arrayList32;
                categoryList = categoryList;
                i16 = i16;
                size = i3;
                z17 = false;
                resource = null;
            }
            linkedHashMap.put(valueOf, arrayList2);
            i16++;
            categoryList = categoryList;
            z17 = false;
        }
        initSelectAvatarItem();
        initBlindBoxEntrance();
        SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.binding.onlineStatusPanel;
        SquareAvatarItem squareAvatarItem4 = this.currentSquareItem;
        squareOnlineStatusViewPanel.fillList(linkedHashMap, squareAvatarItem4 != null ? SquareResourceManagerKt.getOnlineStatusId(squareAvatarItem4) : null, arrayList);
        this.binding.onlineStatusPanel.panelLoadFailVisible(8);
        PickFriendView pickFriendView = this.binding.selector;
        List<FriendData> pickFriendList = panelInfo.getPickFriendList();
        EntranceSource entranceSource = this.entranceSource;
        pickFriendView.initPickFriendData(pickFriendList, entranceSource != null ? entranceSource.getRefSource() : null);
        onInvalidateInviteUI$default(this, null, 1, null);
    }

    public static /* synthetic */ void changeStatus$default(DetailSelectMeView detailSelectMeView, OnlineStatus onlineStatus, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        detailSelectMeView.changeStatus(onlineStatus, z16);
    }

    public static /* synthetic */ SquareAvatarItem curSelectedAvatarItem$default(DetailSelectMeView detailSelectMeView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return detailSelectMeView.curSelectedAvatarItem(z16);
    }

    public static /* synthetic */ void doRecordSuccess$default(DetailSelectMeView detailSelectMeView, RecordRequest recordRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        detailSelectMeView.doRecordSuccess(recordRequest, z16);
    }

    static /* synthetic */ Map getPublishBtnReportParams$default(DetailSelectMeView detailSelectMeView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return detailSelectMeView.getPublishBtnReportParams(z16);
    }

    static /* synthetic */ Location getRealAvatarLocation$default(DetailSelectMeView detailSelectMeView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return detailSelectMeView.getRealAvatarLocation(z16);
    }

    public static /* synthetic */ BaseResourceInfo getTargetActionFromActionGroup$default(DetailSelectMeView detailSelectMeView, Integer num, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return detailSelectMeView.getTargetActionFromActionGroup(num, z16);
    }

    static /* synthetic */ void initBaseView$default(DetailSelectMeView detailSelectMeView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        detailSelectMeView.initBaseView(z16);
    }

    static /* synthetic */ void invalidateAllMultiResource$default(DetailSelectMeView detailSelectMeView, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        detailSelectMeView.invalidateAllMultiResource(num);
    }

    public static /* synthetic */ boolean isCurStatus$default(DetailSelectMeView detailSelectMeView, Integer num, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        return detailSelectMeView.isCurStatus(num, bool);
    }

    static /* synthetic */ void onInvalidateInviteUI$default(DetailSelectMeView detailSelectMeView, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        detailSelectMeView.onInvalidateInviteUI(num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onSelectFriendClick$default(DetailSelectMeView detailSelectMeView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        detailSelectMeView.onSelectFriendClick(str);
    }

    public static /* synthetic */ void reportPublish$default(DetailSelectMeView detailSelectMeView, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        detailSelectMeView.reportPublish(z16, i3);
    }

    static /* synthetic */ void updateResourceAndPlay$default(DetailSelectMeView detailSelectMeView, BaseResourceInfo baseResourceInfo, SquareMultiMotionDetailData squareMultiMotionDetailData, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        detailSelectMeView.updateResourceAndPlay(baseResourceInfo, squareMultiMotionDetailData, num);
    }

    static /* synthetic */ String getLimitNickName$default(DetailSelectMeView detailSelectMeView, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 8;
        }
        return detailSelectMeView.getLimitNickName(str, i3);
    }

    public static /* synthetic */ void onFriendSelected$default(DetailSelectMeView detailSelectMeView, String str, boolean z16, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        detailSelectMeView.onFriendSelected(str, z16, num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectMeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareDetailMeViewBinding inflate = VasSquareDetailMeViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeViewBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        FrameLayout frameLayout = inflate.onlineStatusMultiActionPanelContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.onlineStatusMultiActionPanelContainer");
        RecyclerView recyclerView = inflate.onlineStatusMultiActionPanel;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.onlineStatusMultiActionPanel");
        this.multiActionPanelHelper = new SquareOnlineStatusMultiActionPanelHelper(context2, this, frameLayout, recyclerView);
        this.recordResourceMap = new HashMap<>();
        this.clickUtils = new FastClickUtils(800L);
        this.curRequestText = "";
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.motionUnLockTip = "";
        this.dressBubbleHelper = new DetailMeDressBubbleHelper(this);
        initClickListener();
        recalculatePosition();
        inflate.onlineStatusPanel.setPanelListener(this);
        this.enableBatteryInfo = true;
    }

    public static /* synthetic */ void recordAvatar$default(DetailSelectMeView detailSelectMeView, String str, Integer num, Resource resource, OnlineStatus onlineStatus, boolean z16, Function3 function3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 32) != 0) {
            function3 = null;
        }
        detailSelectMeView.recordAvatar(str, num, resource, onlineStatus, z17, function3);
    }

    @Override // com.tencent.state.square.detail.IDetailParentView
    public View getView() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectMeView(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareDetailMeViewBinding inflate = VasSquareDetailMeViewBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeViewBin\u2026ater.from(context), this)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        FrameLayout frameLayout = inflate.onlineStatusMultiActionPanelContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.onlineStatusMultiActionPanelContainer");
        RecyclerView recyclerView = inflate.onlineStatusMultiActionPanel;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.onlineStatusMultiActionPanel");
        this.multiActionPanelHelper = new SquareOnlineStatusMultiActionPanelHelper(context2, this, frameLayout, recyclerView);
        this.recordResourceMap = new HashMap<>();
        this.clickUtils = new FastClickUtils(800L);
        this.curRequestText = "";
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        this.inviteStatus = -1;
        this.motionUnLockTip = "";
        this.dressBubbleHelper = new DetailMeDressBubbleHelper(this);
        initClickListener();
        recalculatePosition();
        inflate.onlineStatusPanel.setPanelListener(this);
        this.enableBatteryInfo = true;
    }
}
