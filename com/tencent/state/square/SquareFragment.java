package com.tencent.state.square;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareDebug;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.data.Image;
import com.tencent.state.event.Event;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.ISquareViewDetectorCallback;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.perf.PerfMonitor;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.PatchAddToSquareItem;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.service.SquarePageInfo;
import com.tencent.state.service.VasSquareDataProvider;
import com.tencent.state.service.VasSquarePatchAddService;
import com.tencent.state.service.VasSquareSceneService;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.AudioMessageListener;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.MusicChangeListener;
import com.tencent.state.square.api.PttMessage;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTempMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.chatland.component.ChatLandPKComponent;
import com.tencent.state.square.chatland.component.ChatLandSquareComponent;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.components.SquareGroupFloatingComponent;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.components.SquareGroupUiComponent;
import com.tencent.state.square.components.fragment.ChatAddUinComponent;
import com.tencent.state.square.components.fragment.ISquareEventListener;
import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.square.components.fragment.SquareBlindBoxComponent;
import com.tencent.state.square.components.fragment.SquareBubbleSkinComponent;
import com.tencent.state.square.components.fragment.SquareBuildingComponent;
import com.tencent.state.square.components.fragment.SquareCommonEntranceComponent;
import com.tencent.state.square.components.fragment.SquareDebugComponent;
import com.tencent.state.square.components.fragment.SquareEntryComponent;
import com.tencent.state.square.components.fragment.SquareEventBusComponent;
import com.tencent.state.square.components.fragment.SquareFilamentCoverComponent;
import com.tencent.state.square.components.fragment.SquareFlowerComponent;
import com.tencent.state.square.components.fragment.SquareFlowerReportComponent;
import com.tencent.state.square.components.fragment.SquareFootLabelComponent;
import com.tencent.state.square.components.fragment.SquareFragComponent;
import com.tencent.state.square.components.fragment.SquareFriendStatusPanelComponent;
import com.tencent.state.square.components.fragment.SquareHomeScreenComponent;
import com.tencent.state.square.components.fragment.SquareInteractionComponent;
import com.tencent.state.square.components.fragment.SquareIntimateComponent;
import com.tencent.state.square.components.fragment.SquareJSComponent;
import com.tencent.state.square.components.fragment.SquareLibraryComponent;
import com.tencent.state.square.components.fragment.SquareMsgBoxComponent;
import com.tencent.state.square.components.fragment.SquareMultiPoseComponent;
import com.tencent.state.square.components.fragment.SquareNoviceGuideComponent;
import com.tencent.state.square.components.fragment.SquareOnlineStatusComponent;
import com.tencent.state.square.components.fragment.SquareQuickPublishEntryComponent;
import com.tencent.state.square.components.fragment.SquareRecommendComponent;
import com.tencent.state.square.components.fragment.SquareResPreloadComponent;
import com.tencent.state.square.components.fragment.SquareScaleAnimComponent;
import com.tencent.state.square.components.fragment.SquareServiceProvider;
import com.tencent.state.square.components.fragment.SquareSettingsMenuComponent;
import com.tencent.state.square.components.fragment.SquareShareComponent;
import com.tencent.state.square.components.fragment.SquareStatusComponent;
import com.tencent.state.square.components.fragment.SquareWhiteListComponent;
import com.tencent.state.square.components.fragment.SquareZPlanEntranceComponent;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAnchorEntrance;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareDetailIntent;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareMayKnowItem;
import com.tencent.state.square.data.SquareStyleInfo;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.detail.DetailBaseSelectFragment;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.DetailGuestFragmentConfig;
import com.tencent.state.square.detail.DetailLaunchParams;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import com.tencent.state.square.flower.FlowerLayoutView;
import com.tencent.state.square.friendsetting.CommonSettingWindowController;
import com.tencent.state.square.friendsetting.SettingTipsController;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.layout.MoveRequest;
import com.tencent.state.square.like.LikeDataManager;
import com.tencent.state.square.mayknow.VasMayKnowFragment;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.message.box.IMsgBoxManager;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.resource.FilamentCoverRecordHelper;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.square.resource.ISquareViewBridge;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.VMUtils;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00d5\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002\u00d5\u0001B\u0005\u00a2\u0006\u0002\u0010\nJg\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001052\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2 \u0010;\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020>0=\u0012\u0004\u0012\u000200\u0018\u00010<H\u0016\u00a2\u0006\u0002\u0010?JO\u0010@\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001a2\b\u0010F\u001a\u0004\u0018\u0001052\b\u0010G\u001a\u0004\u0018\u0001052\b\u0010H\u001a\u0004\u0018\u0001052\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J\u00a2\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u001aH\u0002J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020O02H\u0014J\b\u0010P\u001a\u00020\u0013H\u0016J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u0004\u0018\u00010TJ\b\u0010U\u001a\u0004\u0018\u00010TJ\n\u0010V\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010W\u001a\u0004\u0018\u00010XH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0018\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u0002052\u0006\u0010M\u001a\u00020\u001aH\u0002J\n\u0010]\u001a\u0004\u0018\u00010^H\u0016J\n\u0010_\u001a\u0004\u0018\u00010`H\u0016J.\u0010a\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u001a2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002J \u0010e\u001a\u0002002\u0006\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u0013H\u0002J\u0012\u0010j\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010kH\u0002J\b\u0010l\u001a\u000200H\u0002J\u001e\u0010m\u001a\u0002002\u0006\u0010n\u001a\u00020o2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020B02H\u0014J\b\u0010q\u001a\u000200H\u0002J\b\u0010r\u001a\u000200H\u0002J\u001a\u0010s\u001a\u0002002\u0006\u0010f\u001a\u00020\u00132\b\u0010t\u001a\u0004\u0018\u00010uH\u0016JC\u0010v\u001a\u0002002\f\u0010w\u001a\b\u0012\u0004\u0012\u000203022\b\b\u0002\u0010:\u001a\u00020\u001a2#\u0010x\u001a\u001f\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\by\u0012\b\bz\u0012\u0004\b\b({\u0012\u0004\u0012\u000200\u0018\u00010<J\u000e\u0010|\u001a\u0002002\u0006\u0010A\u001a\u00020uJ\b\u0010}\u001a\u00020\u001aH\u0016J\u0006\u0010~\u001a\u000200J-\u0010\u007f\u001a\u0002002\u0007\u0010\u0080\u0001\u001a\u00020\u001a2\u0007\u0010\u0081\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0011\u0010\u0083\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u0013H\u0016J\u0014\u0010\u0084\u0001\u001a\u0002002\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010uH\u0016J,\u0010\u0086\u0001\u001a\u0004\u0018\u00010T2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010uH\u0016J\t\u0010\u008b\u0001\u001a\u000200H\u0016J\t\u0010\u008c\u0001\u001a\u000200H\u0016J\t\u0010\u008d\u0001\u001a\u000200H\u0016J\t\u0010\u008e\u0001\u001a\u000200H\u0016J8\u0010\u008f\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0007\u0010\u0093\u0001\u001a\u000205H\u0016J\u0011\u0010\u0094\u0001\u001a\u0002002\u0006\u0010M\u001a\u00020\u001aH\u0016J/\u0010\u0095\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0011\u0010\u0096\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u0013H\u0016J/\u0010\u0097\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J8\u0010\u0097\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0007\u0010\u0098\u0001\u001a\u000205H\u0016JD\u0010\u0099\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0007\u0010\u0093\u0001\u001a\u0002052\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J8\u0010\u009c\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0007\u0010\u0093\u0001\u001a\u000205H\u0016J\u001f\u0010\u009d\u0001\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010B2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u0002002\b\u0010\u009f\u0001\u001a\u00030\u00a0\u0001H\u0002J\t\u0010\u00a1\u0001\u001a\u000200H\u0016J\u0012\u0010\u00a2\u0001\u001a\u0002002\u0007\u0010\u00a3\u0001\u001a\u00020\u001aH\u0016J%\u0010\u00a4\u0001\u001a\u0002002\u0007\u0010\u00a5\u0001\u001a\u0002052\b\u0010\u00a6\u0001\u001a\u00030\u00a7\u00012\u0007\u0010\u00a3\u0001\u001a\u00020\u001aH\u0016J\u001d\u0010\u00a8\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u00132\n\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00aa\u0001H\u0016J\u0012\u0010\u00ab\u0001\u001a\u0002002\u0007\u0010\u00ac\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u00ad\u0001\u001a\u0002002\u0007\u0010\u00ae\u0001\u001a\u00020\u0014H\u0016J\u0011\u0010\u00af\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u0013H\u0016J\u0011\u0010\u00b0\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u0013H\u0016J\u0011\u0010\u00b1\u0001\u001a\u0002002\u0006\u0010f\u001a\u00020\u0013H\u0016J\u0013\u0010\u00b2\u0001\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010kH\u0002J\u0012\u0010\u00b3\u0001\u001a\u0002002\u0007\u0010A\u001a\u00030\u00b4\u0001H\u0016J\u0017\u0010\u00b5\u0001\u001a\u0002002\f\u0010A\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\u0017\u0010\u00b6\u0001\u001a\u0002002\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001302H\u0016J\u001e\u0010\u00b7\u0001\u001a\u0002002\b\u0010\u00b8\u0001\u001a\u00030\u00b9\u00012\t\u0010;\u001a\u0005\u0018\u00010\u00ba\u0001H\u0016J\u0013\u0010\u00bb\u0001\u001a\u0002002\b\u0010\u00ae\u0001\u001a\u00030\u00bc\u0001H\u0002J\u0013\u0010\u00bd\u0001\u001a\u0002002\b\u0010\u00ae\u0001\u001a\u00030\u00be\u0001H\u0002J\u0013\u0010\u00bf\u0001\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010kH\u0002J\u0013\u0010\u00c0\u0001\u001a\u0002002\b\u0010\u00ae\u0001\u001a\u00030\u00c1\u0001H\u0002J\u001d\u0010\u00c2\u0001\u001a\u0002002\u0007\u0010\u0081\u0001\u001a\u00020T2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010uH\u0016J\u001a\u0010\u00c3\u0001\u001a\u0002002\u0007\u0010\u00c4\u0001\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u0013H\u0016J/\u0010\u00c5\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J/\u0010\u00c6\u0001\u001a\u0002002\u0011\u0010\u0090\u0001\u001a\f\u0012\u0002\b\u00030\u0091\u0001j\u0003`\u0092\u00012\u0007\u0010\u0082\u0001\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J8\u0010\u00c7\u0001\u001a\u0002002\b\u0010\u00c8\u0001\u001a\u00030\u00a0\u00012\u0006\u00106\u001a\u0002072\u000b\b\u0002\u0010\u00c9\u0001\u001a\u0004\u0018\u0001052\b\b\u0002\u00109\u001a\u00020\u001aH\u0002\u00a2\u0006\u0003\u0010\u00ca\u0001J\u0012\u0010\u00cb\u0001\u001a\u0002002\u0007\u0010\u00cc\u0001\u001a\u00020\u001aH\u0014J\u001c\u0010\u00cd\u0001\u001a\u0002002\u0007\u0010\u00ce\u0001\u001a\u00020\u00132\b\b\u0002\u00109\u001a\u00020\u001aH\u0002J\u001f\u0010\u00cf\u0001\u001a\u0002002\u0006\u0010n\u001a\u00020o2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020B02H\u0014J\u0012\u0010\u00d0\u0001\u001a\u0002002\u0007\u0010A\u001a\u00030\u00d1\u0001H\u0002J\u0015\u0010\u00d2\u0001\u001a\u0002002\n\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00d4\u0001H\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014`\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b,\u0010-\u00a8\u0006\u00d6\u0001"}, d2 = {"Lcom/tencent/state/square/SquareFragment;", "Lcom/tencent/state/map/MapFragment;", "Lcom/tencent/state/square/SquareView;", "Lcom/tencent/state/square/SquareMapViewModel;", "Lcom/tencent/state/square/api/ISquarePushListener;", "Lcom/tencent/state/square/api/AudioMessageListener;", "Lcom/tencent/state/square/api/MusicChangeListener;", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "Lcom/tencent/state/square/resource/ISquareRoleManager;", "Lcom/tencent/state/map/ISquareViewDetectorCallback;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "setBinding", "(Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;)V", "currentPlayMessage", "Ljava/util/HashMap;", "", "Lcom/tencent/state/square/api/PttMessage;", "Lkotlin/collections/HashMap;", "currentPlayUin", "detailParams", "Lcom/tencent/state/square/detail/DetailLaunchParams;", "isBuildingChange", "", "mapView", "getMapView", "()Lcom/tencent/state/square/SquareView;", "provider", "Lcom/tencent/state/service/VasSquareDataProvider;", "serviceProvider", "Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "getServiceProvider", "()Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "serviceProvider$delegate", "Lkotlin/Lazy;", "settingController", "Lcom/tencent/state/square/friendsetting/CommonSettingWindowController;", "getSettingController", "()Lcom/tencent/state/square/friendsetting/CommonSettingWindowController;", "settingController$delegate", "vm", "getVm", "()Lcom/tencent/state/square/SquareMapViewModel;", "vm$delegate", "addMultiRoles", "", "list", "", "Lcom/tencent/state/square/MoveItem;", "from", "", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "sceneType", "needToast", "needLocateTo", "callback", "Lkotlin/Function1;", "", "Lcom/tencent/state/square/MoveResult;", "(Ljava/util/List;ILcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;ZZLkotlin/jvm/functions/Function1;)V", "doGotoDetailPage", "data", "Lcom/tencent/state/map/MapItem;", "source", "Lcom/tencent/state/square/detail/EntranceSource;", "autoEnterEditState", "curStatusId", "curRichStatusId", "curActionId", "intent", "Lcom/tencent/state/square/data/SquareDetailIntent;", "(Lcom/tencent/state/map/MapItem;Lcom/tencent/state/square/detail/EntranceSource;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/state/square/data/SquareDetailIntent;)V", "doOnDressKeyChangeWithNewGender", "isMale", "getComponents", "Lcom/tencent/state/FragmentComponent;", "getPageId", "getScreenViewManager", "Lcom/tencent/state/map/IMapItemViewManager;", "getSelectIconContainer", "Landroid/view/View;", "getSquareLocateIcon", "getSquareRoleManager", "getSquareViewAbility", "Lcom/tencent/state/map/IMapViewManipulator;", "getSquareViewUpdater", "Lcom/tencent/state/square/ISquareViewUpdater;", "getStringWithGender", "resId", "getTipsController", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "getViewBridge", "Lcom/tencent/state/square/resource/ISquareViewBridge;", "gotoDetailPage", "subSource", "Lcom/tencent/state/square/detail/SubScene;", "enterEditState", "handleOpenMiniAio", "uin", "type", "Lcom/tencent/state/square/api/MessageRecordType;", "nickName", "handlePlayPtt", "Lcom/tencent/state/square/data/SquareAvatarItem;", "initBuildingStyle", "initMapView", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "initPushService", "initViewModels", "locateFailOnTryScaleToDetail", "bundle", "Landroid/os/Bundle;", "locateToNewLocation", VideoTemplateParser.ITEM_LIST, "endCallback", "Lkotlin/ParameterName;", "name", "success", "onBackFromDetail", "onBackPressed", "onBackPressedNotCheck", "onCenterScaled", "isScaleToCenter", "view", "index", "onComplete", "onCreate", Constants.FILE_INSTANCE_STATE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "onDetectorScale", "onDetectorScroll", "onDoubleClick", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "onDressKeyChange", "onInVisible", "onInterrupt", "onItemBind", "event", "onItemClicked", "extra", "", "onItemLongClick", "onItemRecordCover", "onLocalAddRoleInterrupt", "resultInfo", "Lcom/tencent/state/square/LocalAddRoleResultInfo;", "onMapSizeInitReady", "onMapZoom", "isZoomIn", "onMapZoomEnd", "zoomLevel", "scale", "", "onMusicInfoChange", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "onMusicPlayStateChange", "songMid", "onNewMessagePlay", "message", "onPlayError", "onPlayPause", HippyQQPagView.EventName.ON_PLAY_START, "onPttMessageBubbleClick", "onResult", "", "onRoleAdded", "onRoleRemoved", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "Lcom/tencent/state/square/resource/IResourceCallback;", "onTempMessageNotify", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "onTroopMessageNotify", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "onUnreadMessageBubbleClick", "onUnreadMessageNotify", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onVisibilityChanged", "isVisible", "onVisible", "onZoomOverOut", "patchAddToSquareOnServer", "localResultInfo", "scene", "(Lcom/tencent/state/square/LocalAddRoleResultInfo;Lcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;Z)V", "sendMapDataRequest", "isRefresh", "showAddRoleToast", "tips", "updateMapView", "updateSceneBuilding", "Lcom/tencent/state/square/data/SquareEntranceItem;", "updateTopBar", "backgroundInfo", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFragment extends MapFragment<SquareView, SquareMapViewModel> implements ISquarePushListener, AudioMessageListener, MusicChangeListener, ISquareViewManagerProxy, ISquareRoleManager, ISquareViewDetectorCallback {
    private static final String TAG = "SquareFragment";
    private VasSquareFragmentSquareBinding binding;
    private HashMap<String, PttMessage> currentPlayMessage;
    private String currentPlayUin;
    private DetailLaunchParams detailParams;
    private boolean isBuildingChange;
    private VasSquareDataProvider provider;

    /* renamed from: serviceProvider$delegate, reason: from kotlin metadata */
    private final Lazy serviceProvider;

    /* renamed from: settingController$delegate, reason: from kotlin metadata */
    private final Lazy settingController;

    /* renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int chatLandAppId = 1004;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/SquareFragment$Companion;", "", "()V", "TAG", "", "chatLandAppId", "", "getChatLandAppId", "()I", "setChatLandAppId", "(I)V", "newInstance", "Lcom/tencent/state/square/SquareFragment;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final int getChatLandAppId() {
            return SquareFragment.chatLandAppId;
        }

        public final SquareFragment newInstance() {
            return new SquareFragment();
        }

        public final void setChatLandAppId(int i3) {
            SquareFragment.chatLandAppId = i3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MessageRecordType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageRecordType.RECORD_TYPE_SQUARE_TEMP.ordinal()] = 1;
            int[] iArr2 = new int[PlayState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PlayState.INIT.ordinal()] = 1;
            iArr2[PlayState.PLAY.ordinal()] = 2;
        }
    }

    public SquareFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareMapViewModel>() { // from class: com.tencent.state.square.SquareFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareMapViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(SquareFragment.this).get(SquareMapViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026MapViewModel::class.java]");
                return (SquareMapViewModel) viewModel;
            }
        });
        this.vm = lazy;
        this.currentPlayMessage = new HashMap<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CommonSettingWindowController>() { // from class: com.tencent.state.square.SquareFragment$settingController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CommonSettingWindowController invoke() {
                return new CommonSettingWindowController(SquareGroupReportComponentKt.getSourceFrom(SquareFragment.this.getActivity()), new Function1<MapItem, Unit>() { // from class: com.tencent.state.square.SquareFragment$settingController$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MapItem mapItem) {
                        invoke2(mapItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapItem mapItem) {
                        SquareInteractionComponent squareInteractionComponent = (SquareInteractionComponent) SquareFragment.this.getComponent(SquareInteractionComponent.class, null, null);
                        if (squareInteractionComponent != null) {
                            squareInteractionComponent.tryOpenInteractionDialog(mapItem, true);
                        }
                    }
                });
            }
        });
        this.settingController = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SquareServiceProvider>() { // from class: com.tencent.state.square.SquareFragment$serviceProvider$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.SquareFragment$serviceProvider$2$1, reason: invalid class name */
            /* loaded from: classes38.dex */
            public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SquareBaseMessageRecord, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareBaseMessageRecord squareBaseMessageRecord) {
                    invoke2(squareBaseMessageRecord);
                    return Unit.INSTANCE;
                }

                AnonymousClass1(SquareFragment squareFragment) {
                    super(1, squareFragment, SquareFragment.class, "onUnreadMessageNotify", "onUnreadMessageNotify(Lcom/tencent/state/square/api/SquareBaseMessageRecord;)V", 0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareBaseMessageRecord p16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((SquareFragment) this.receiver).onUnreadMessageNotify(p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.SquareFragment$serviceProvider$2$2, reason: invalid class name */
            /* loaded from: classes38.dex */
            public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SquareTempMessageRecord, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareTempMessageRecord squareTempMessageRecord) {
                    invoke2(squareTempMessageRecord);
                    return Unit.INSTANCE;
                }

                AnonymousClass2(SquareFragment squareFragment) {
                    super(1, squareFragment, SquareFragment.class, "onTempMessageNotify", "onTempMessageNotify(Lcom/tencent/state/square/api/SquareTempMessageRecord;)V", 0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareTempMessageRecord p16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((SquareFragment) this.receiver).onTempMessageNotify(p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.SquareFragment$serviceProvider$2$3, reason: invalid class name */
            /* loaded from: classes38.dex */
            public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<SquareTroopMessageRecord, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareTroopMessageRecord squareTroopMessageRecord) {
                    invoke2(squareTroopMessageRecord);
                    return Unit.INSTANCE;
                }

                AnonymousClass3(SquareFragment squareFragment) {
                    super(1, squareFragment, SquareFragment.class, "onTroopMessageNotify", "onTroopMessageNotify(Lcom/tencent/state/square/api/SquareTroopMessageRecord;)V", 0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareTroopMessageRecord p16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((SquareFragment) this.receiver).onTroopMessageNotify(p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareServiceProvider invoke() {
                return new SquareServiceProvider(null, new AnonymousClass1(SquareFragment.this), new AnonymousClass2(SquareFragment.this), new AnonymousClass3(SquareFragment.this), 1, null);
            }
        });
        this.serviceProvider = lazy3;
    }

    private final void doOnDressKeyChangeWithNewGender(final boolean isMale) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.state.square.SquareFragment$doOnDressKeyChangeWithNewGender$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                VasStatusSquareService.INSTANCE.getUserActionInfo(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), new ResultCallback<List<? extends AvatarAction>>() { // from class: com.tencent.state.square.SquareFragment$doOnDressKeyChangeWithNewGender$1.1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public /* bridge */ /* synthetic */ void onResultSuccess(List<? extends AvatarAction> list) {
                        onResultSuccess2((List<AvatarAction>) list);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        ISquareViewUpdater updater;
                        Boolean valueOf = Boolean.valueOf(isMale);
                        SquareView mapView = SquareFragment.this.getMapView();
                        if (Intrinsics.areEqual(valueOf, (mapView == null || (updater = mapView.getUpdater()) == null) ? null : updater.getCurAvatarGender())) {
                            return;
                        }
                        SquareFragment$doOnDressKeyChangeWithNewGender$1 squareFragment$doOnDressKeyChangeWithNewGender$1 = SquareFragment$doOnDressKeyChangeWithNewGender$1.this;
                        SquareFragment.this.doOnDressKeyChange(isMale);
                    }

                    /* renamed from: onResultSuccess, reason: avoid collision after fix types in other method */
                    public void onResultSuccess2(List<AvatarAction> result) {
                        Integer num;
                        Object firstOrNull;
                        AvatarAction avatarAction;
                        SquareView mapView;
                        ISquareViewUpdater updater;
                        Resource lookFront;
                        Object firstOrNull2;
                        Resource lookFront2;
                        ISquareViewUpdater updater2;
                        ISquareViewUpdater updater3;
                        Intrinsics.checkNotNullParameter(result, "result");
                        Boolean valueOf = Boolean.valueOf(isMale);
                        SquareView mapView2 = SquareFragment.this.getMapView();
                        Integer num2 = null;
                        if (Intrinsics.areEqual(valueOf, (mapView2 == null || (updater3 = mapView2.getUpdater()) == null) ? null : updater3.getCurAvatarGender())) {
                            return;
                        }
                        SquareView mapView3 = SquareFragment.this.getMapView();
                        List<AvatarAction> curMeActions = (mapView3 == null || (updater2 = mapView3.getUpdater()) == null) ? null : updater2.getCurMeActions();
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onDressKeyChange, oldActionId:");
                        if (curMeActions != null) {
                            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) curMeActions);
                            AvatarAction avatarAction2 = (AvatarAction) firstOrNull2;
                            if (avatarAction2 != null && (lookFront2 = avatarAction2.getLookFront()) != null) {
                                num = Integer.valueOf(lookFront2.getActionId());
                                sb5.append(num);
                                sb5.append(", newActionId:");
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) result);
                                avatarAction = (AvatarAction) firstOrNull;
                                if (avatarAction != null && (lookFront = avatarAction.getLookFront()) != null) {
                                    num2 = Integer.valueOf(lookFront.getActionId());
                                }
                                sb5.append(num2);
                                squareLog.i("SquareFragment", sb5.toString());
                                mapView = SquareFragment.this.getMapView();
                                if (mapView != null && (updater = mapView.getUpdater()) != null) {
                                    updater.setMeActions(result);
                                }
                                SquareFragment$doOnDressKeyChangeWithNewGender$1 squareFragment$doOnDressKeyChangeWithNewGender$1 = SquareFragment$doOnDressKeyChangeWithNewGender$1.this;
                                SquareFragment.this.doOnDressKeyChange(isMale);
                            }
                        }
                        num = null;
                        sb5.append(num);
                        sb5.append(", newActionId:");
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) result);
                        avatarAction = (AvatarAction) firstOrNull;
                        if (avatarAction != null) {
                            num2 = Integer.valueOf(lookFront.getActionId());
                        }
                        sb5.append(num2);
                        squareLog.i("SquareFragment", sb5.toString());
                        mapView = SquareFragment.this.getMapView();
                        if (mapView != null) {
                            updater.setMeActions(result);
                        }
                        SquareFragment$doOnDressKeyChangeWithNewGender$1 squareFragment$doOnDressKeyChangeWithNewGender$12 = SquareFragment$doOnDressKeyChangeWithNewGender$1.this;
                        SquareFragment.this.doOnDressKeyChange(isMale);
                    }
                });
            }
        }, 128, null, true, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareServiceProvider getServiceProvider() {
        return (SquareServiceProvider) this.serviceProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonSettingWindowController getSettingController() {
        return (CommonSettingWindowController) this.settingController.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void gotoDetailPage(MapItem data, SubScene subSource, boolean enterEditState, SquareDetailIntent intent) {
        FragmentActivity activity;
        Integer num;
        Integer curRichStatusId;
        if (!(data instanceof SquareAvatarItem) || (activity = getActivity()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
        EntranceSource entranceSource = new EntranceSource(MainScene.SQUARE, subSource, SquareGroupReportComponentKt.getSourceFrom(activity));
        DetailLaunchParams detailLaunchParams = this.detailParams;
        boolean z16 = (detailLaunchParams != null && detailLaunchParams.getAutoEnterEditState()) || enterEditState;
        SquareStatusComponent squareStatusComponent = (SquareStatusComponent) getComponent(SquareStatusComponent.class, null, null);
        Integer curStatusId = squareStatusComponent != null ? squareStatusComponent.getCurStatusId() : null;
        SquareStatusComponent squareStatusComponent2 = (SquareStatusComponent) getComponent(SquareStatusComponent.class, null, null);
        if (squareStatusComponent2 == null || (curRichStatusId = squareStatusComponent2.getCurRichStatusId()) == null) {
            DetailLaunchParams detailLaunchParams2 = this.detailParams;
            if (detailLaunchParams2 != null) {
                curRichStatusId = detailLaunchParams2.getCurRichStatusId();
            } else {
                num = null;
                DetailLaunchParams detailLaunchParams3 = this.detailParams;
                doGotoDetailPage(data, entranceSource, z16, curStatusId, num, detailLaunchParams3 == null ? detailLaunchParams3.getCurActionId() : null, intent);
                if (this.detailParams == null) {
                    this.detailParams = null;
                    return;
                }
                return;
            }
        }
        num = curRichStatusId;
        DetailLaunchParams detailLaunchParams32 = this.detailParams;
        doGotoDetailPage(data, entranceSource, z16, curStatusId, num, detailLaunchParams32 == null ? detailLaunchParams32.getCurActionId() : null, intent);
        if (this.detailParams == null) {
        }
    }

    private final void initBuildingStyle() {
        if (getVm().getBuildingInfos().getValue() == null) {
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$initBuildingStyle$1

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/data/SquareStyleInfo;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 4, 1})
                /* renamed from: com.tencent.state.square.SquareFragment$initBuildingStyle$1$1, reason: invalid class name */
                /* loaded from: classes38.dex */
                public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ArrayList<SquareStyleInfo>, Unit> {
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareStyleInfo> arrayList) {
                        invoke2(arrayList);
                        return Unit.INSTANCE;
                    }

                    AnonymousClass1(SquareMapViewModel squareMapViewModel) {
                        super(1, squareMapViewModel, SquareMapViewModel.class, "updateBuildingInfos", "updateBuildingInfos(Ljava/util/ArrayList;)V", 0);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ArrayList<SquareStyleInfo> arrayList) {
                        ((SquareMapViewModel) this.receiver).updateBuildingInfos(arrayList);
                    }
                }

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
                    VasSquareSceneService.INSTANCE.getAllBuildingStyle(new AnonymousClass1(SquareFragment.this.getVm()));
                }
            });
        }
    }

    private final void initPushService() {
        ISquarePttMessageService pttMessageService = getServiceProvider().getPttMessageService();
        if (pttMessageService != null) {
            pttMessageService.addAudioMessageListener(this);
        }
        ISquarePushService pushService = getServiceProvider().getPushService();
        if (pushService != null) {
            pushService.addListener(2, this);
        }
        ISquareMusicService musicService = getServiceProvider().getMusicService();
        if (musicService != null) {
            musicService.addMusicChangeListener(this);
        }
        ISquarePushService pushService2 = getServiceProvider().getPushService();
        if (pushService2 != null) {
            LikeDataManager.INSTANCE.init(pushService2);
        }
    }

    private final void initViewModels() {
        VasBaseGroupFragment groupFragment;
        SquareViewModel squareViewModel;
        if (getActivity() == null || (groupFragment = getGroupFragment()) == null || (squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class)) == null) {
            return;
        }
        squareViewModel.getResourceOfMe().observe(getViewLifecycleOwner(), new Observer<Event<Resource>>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Event<Resource> event) {
                SquareView mapView;
                ISquareViewUpdater updater;
                Resource content = event.getContent();
                if (content == null || (mapView = SquareFragment.this.getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                IMapViewUpdater.DefaultImpls.updateMeResource$default(updater, content, false, 2, null);
            }
        });
        squareViewModel.getStatusUpdateData().observe(getViewLifecycleOwner(), new Observer<Event<StatusUpdateData>>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Event<StatusUpdateData> event) {
                SquareView mapView;
                ISquareViewUpdater updater;
                StatusUpdateData content = event.getContent();
                if (content == null || (mapView = SquareFragment.this.getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updateMeStatus(content);
            }
        });
        squareViewModel.getResourceOfUin().observe(getViewLifecycleOwner(), new Observer<Event<Pair<? extends String, ? extends Resource>>>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$3
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Event<Pair<? extends String, ? extends Resource>> event) {
                onChanged2((Event<Pair<String, Resource>>) event);
            }

            /* renamed from: onChanged, reason: avoid collision after fix types in other method */
            public final void onChanged2(Event<Pair<String, Resource>> event) {
                SquareView mapView;
                ISquareViewUpdater updater;
                Pair<String, Resource> content = event.getContent();
                if (content == null || (mapView = SquareFragment.this.getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                IMapViewUpdater.DefaultImpls.updateTargetResource$default(updater, content.getFirst(), content.getSecond(), false, 4, null);
            }
        });
        squareViewModel.getFeedsInfoOfUin().observe(getViewLifecycleOwner(), new Observer<Event<Pair<? extends String, ? extends QZoneFeedsInfo>>>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$4
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Event<Pair<? extends String, ? extends QZoneFeedsInfo>> event) {
                onChanged2((Event<Pair<String, QZoneFeedsInfo>>) event);
            }

            /* renamed from: onChanged, reason: avoid collision after fix types in other method */
            public final void onChanged2(Event<Pair<String, QZoneFeedsInfo>> event) {
                SquareView mapView;
                ISquareViewUpdater updater;
                Pair<String, QZoneFeedsInfo> content = event.getContent();
                if (content == null || (mapView = SquareFragment.this.getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updateFeedsBubble(content.getFirst(), content.getSecond());
            }
        });
        getVm().getData().observe(getViewLifecycleOwner(), new Observer<MapData>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(final MapData mapData) {
                SquareFragment.this.forEachComponent(ISquareEventListener.class, null, null, new Function1<ISquareEventListener, Unit>() { // from class: com.tencent.state.square.SquareFragment$initViewModels$5.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ISquareEventListener iSquareEventListener) {
                        invoke2(iSquareEventListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ISquareEventListener it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        MapData data = MapData.this;
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        it.onMapDataReceived(data);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLocalAddRoleInterrupt(LocalAddRoleResultInfo resultInfo) {
        String string;
        if (!resultInfo.getSourceList().isEmpty() && !resultInfo.getLocalResultMap().isEmpty()) {
            if (resultInfo.getNoPlaceCount() > 0 && resultInfo.getLocalResultMap().size() - resultInfo.getAlreadyInCount() == resultInfo.getNoPlaceCount()) {
                string = getString(com.tencent.mobileqq.R.string.xek);
            } else if (resultInfo.getAlreadyInCount() > 0) {
                int unitType = resultInfo.getSourceList().get(0).getUnitType();
                if (unitType == 1) {
                    string = getString(com.tencent.mobileqq.R.string.xf8);
                } else if (unitType != 2) {
                    string = getString(com.tencent.mobileqq.R.string.xf6);
                } else {
                    string = getString(com.tencent.mobileqq.R.string.xeo);
                }
            } else {
                string = getString(com.tencent.mobileqq.R.string.xej);
            }
            Intrinsics.checkNotNullExpressionValue(string, "when {\n                a\u2026les_failed)\n            }");
            showAddRoleToast$default(this, string, false, 2, null);
            return;
        }
        String string2 = getString(com.tencent.mobileqq.R.string.xej);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.vas_square_add_roles_failed)");
        showAddRoleToast$default(this, string2, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTempMessageNotify(SquareTempMessageRecord message) {
        SquareView mapView;
        ISquareViewUpdater updater;
        ISquareViewUpdater updater2;
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "onTempMessageNotify, " + message + ", " + message.getUin() + ", " + message.getUnreadCount());
        }
        VasSquareDataProvider vasSquareDataProvider = this.provider;
        boolean updatePageAvatarUnreadCount = vasSquareDataProvider != null ? vasSquareDataProvider.updatePageAvatarUnreadCount(message) : false;
        SquareView mapView2 = getMapView();
        if (mapView2 != null && (updater2 = mapView2.getUpdater()) != null) {
            updater2.onUnreadMessageNotify(message);
        }
        if (!updatePageAvatarUnreadCount || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.pauseAndEnsurePlay(message.getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTroopMessageNotify(SquareTroopMessageRecord message) {
        ISquareViewUpdater updater;
        VasSquareDataProvider vasSquareDataProvider = this.provider;
        if (vasSquareDataProvider != null) {
            vasSquareDataProvider.updatePageTroopUnreadCount(message);
        }
        SquareView mapView = getMapView();
        if (mapView == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.onTroopUnreadMessageNotify(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUnreadMessageNotify(SquareBaseMessageRecord message) {
        SquareView mapView;
        ISquareViewUpdater updater;
        ISquareViewUpdater updater2;
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "onUnreadMessageNotify, " + (message instanceof SquareMessageRecord) + ", " + message.getUin() + ", " + message.getUnreadCount());
        }
        if ((message instanceof SquareMessageRecord) || (message instanceof SquareTempMessageRecord)) {
            VasSquareDataProvider vasSquareDataProvider = this.provider;
            boolean z16 = false;
            boolean updatePageAvatarUnreadCount = vasSquareDataProvider != null ? vasSquareDataProvider.updatePageAvatarUnreadCount(message) : false;
            ISquarePttMessageService pttMessageService = getServiceProvider().getPttMessageService();
            if (pttMessageService != null && pttMessageService.hasUnreadPttMessage(message.getUin())) {
                z16 = true;
            }
            message.setHasUnreadPtt(z16);
            SquareView mapView2 = getMapView();
            if (mapView2 != null && (updater2 = mapView2.getUpdater()) != null) {
                updater2.onUnreadMessageNotify(message);
            }
            if (!updatePageAvatarUnreadCount || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
                return;
            }
            updater.pauseAndEnsurePlay(message.getUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void patchAddToSquareOnServer(final LocalAddRoleResultInfo localResultInfo, MainScene mainScene, Integer scene, final boolean needToast) {
        SquareBaseKt.getSquareLog().i(TAG, "[addRoles] patchAddToSquareOnServer, list.size:" + localResultInfo.getServerReqList().size());
        new VasSquarePatchAddService().patchAddToSquare(localResultInfo.getServerReqList(), mainScene, scene, new Function3<List<? extends PatchAddToSquareItem>, Integer, String, Unit>() { // from class: com.tencent.state.square.SquareFragment$patchAddToSquareOnServer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PatchAddToSquareItem> list, Integer num, String str) {
                invoke((List<PatchAddToSquareItem>) list, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(List<PatchAddToSquareItem> resultList, int i3, String str) {
                String string;
                Map<String, Object> mutableMapOf;
                Object first;
                Intrinsics.checkNotNullParameter(resultList, "resultList");
                SquareBaseKt.getSquareLog().i("SquareFragment", "[addRoles] patchAddToSquare result, size=" + resultList.size() + ", errCode=" + i3 + ", errMsg=" + str);
                SquareFragment squareFragment = SquareFragment.this;
                if (i3 == 0 && !resultList.isEmpty()) {
                    if (localResultInfo.getNoPlaceCount() > 0) {
                        string = SquareFragment.this.getString(com.tencent.mobileqq.R.string.xel);
                    } else if (localResultInfo.getServerReqList().get(0).getType() == 2) {
                        SquareFragment squareFragment2 = SquareFragment.this;
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) localResultInfo.getSourceList());
                        string = squareFragment2.getStringWithGender(com.tencent.mobileqq.R.string.xem, ((MoveItem) first).isMale());
                    } else {
                        string = resultList.get(0).getType() == 4 ? SquareFragment.this.getString(com.tencent.mobileqq.R.string.xeh) : SquareFragment.this.getString(com.tencent.mobileqq.R.string.xeg);
                    }
                } else {
                    string = SquareFragment.this.getString(com.tencent.mobileqq.R.string.xej);
                }
                Intrinsics.checkNotNullExpressionValue(string, "when {\n                 \u2026uccess)\n                }");
                squareFragment.showAddRoleToast(string, needToast);
                for (PatchAddToSquareItem patchAddToSquareItem : resultList) {
                    IReporter reporter = Square.INSTANCE.getConfig().getReporter();
                    Pair[] pairArr = new Pair[4];
                    int i16 = 1;
                    pairArr[0] = TuplesKt.to("zplan_is_friend_or_group", Integer.valueOf(patchAddToSquareItem.getType() == 4 ? 1 : 0));
                    pairArr[1] = TuplesKt.to("zplan_other_user_qq", patchAddToSquareItem.getUin());
                    if (i3 != 0) {
                        i16 = 0;
                    }
                    pairArr[2] = TuplesKt.to("zplan_action_result", Integer.valueOf(i16));
                    pairArr[3] = TuplesKt.to("zplan_action_fail_reason", Integer.valueOf(i3));
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_ADD_FRIEND, mutableMapOf);
                }
            }
        });
    }

    private final void updateSceneBuilding(SquareEntranceItem data) {
        Object obj;
        ListIterator<SquareStyleInfo> listIterator;
        Object first;
        SquareStyleInfo squareStyleInfo;
        ISquareViewUpdater updater;
        ArrayList<SquareStyleInfo> value = getVm().getBuildingInfos().getValue();
        if (data.getEntranceType() == 10 && value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((SquareStyleInfo) obj).getStyleId() == data.getStyleId()) {
                        break;
                    }
                }
            }
            SquareStyleInfo squareStyleInfo2 = (SquareStyleInfo) obj;
            if (squareStyleInfo2 == null || (listIterator = value.listIterator(value.indexOf(squareStyleInfo2) + 1)) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(listIterator, "buildingInfos?.listIterator(index + 1) ?: return");
            if (!listIterator.hasNext()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value);
                squareStyleInfo = (SquareStyleInfo) first;
            } else {
                squareStyleInfo = listIterator.next();
            }
            if (squareStyleInfo != null) {
                Intrinsics.checkNotNullExpressionValue(squareStyleInfo, "if (iterator.hasNext()) \u2026rst()\n        } ?: return");
                SquareView mapView = getMapView();
                if (mapView != null && (updater = mapView.getUpdater()) != null) {
                    updater.updateBuildingStyle(data, squareStyleInfo);
                }
                this.isBuildingChange = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTopBar(SquarePageBackgroundInfo backgroundInfo) {
        View view;
        View view2;
        VasSquareFragmentSquareBinding binding = getBinding();
        if (binding != null && (view2 = binding.squareTopBar) != null) {
            view2.setVisibility(0);
        }
        if (backgroundInfo != null) {
            final String topUrl = backgroundInfo.getTopUrl();
            if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, topUrl, false, 2, null)) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "updateTopBar " + topUrl + " is null", null, 4, null);
                return;
            }
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            VasSquareFragmentSquareBinding binding2 = getBinding();
            final WeakReference weakReference = new WeakReference(binding2 != null ? binding2.squareTopBar : null);
            URLDrawable drawable = URLDrawable.getDrawable(topUrl, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.SquareFragment$$special$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareFragment", "onLoadFailed " + topUrl, null, 4, null);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    View view3 = (View) weakReference.get();
                    if (view3 != null) {
                        view3.setBackground(drawable2);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            drawable.startDownload();
            VasSquareFragmentSquareBinding binding3 = getBinding();
            if (binding3 == null || (view = binding3.squareTopBar) == null) {
                return;
            }
            view.setBackground(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void doGotoDetailPage(MapItem data, EntranceSource source, boolean autoEnterEditState, Integer curStatusId, Integer curRichStatusId, Integer curActionId, SquareDetailIntent intent) {
        VasBaseGroupFragment groupFragment;
        DetailGuestFragmentConfig detailGuestFragmentConfig;
        IMsgBoxManager msgBoxManager;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        Intrinsics.checkNotNullParameter(source, "source");
        if ((data instanceof SquareAvatarItem) && (groupFragment = getGroupFragment()) != null) {
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
            if (squareAvatarItem.isMe()) {
                DetailMeFragmentConfig detailMeFragmentConfig = new DetailMeFragmentConfig();
                detailMeFragmentConfig.setEnterWithScaleAnim(true);
                detailMeFragmentConfig.setMultiMotionId(intent != null ? intent.getTargetMotionId() : null);
                detailMeFragmentConfig.setAutoEnterEditState(autoEnterEditState);
                detailMeFragmentConfig.setCurStatusId(curStatusId);
                detailMeFragmentConfig.setCurRichStatusId(curRichStatusId);
                detailMeFragmentConfig.setCurActionId(curActionId);
                SquareViewModel squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class);
                detailMeFragmentConfig.setNoviceGuideRecord((squareViewModel == null || (noviceGuideRecord = squareViewModel.getNoviceGuideRecord()) == null || (value = noviceGuideRecord.getValue()) == null) ? null : SquareNoviceGuideRecord.getReportParamsForDetailPage$default(value, false, 1, null));
                detailGuestFragmentConfig = detailMeFragmentConfig;
            } else {
                DetailGuestFragmentConfig detailGuestFragmentConfig2 = new DetailGuestFragmentConfig();
                detailGuestFragmentConfig2.setEnterWithScaleAnim(true);
                detailGuestFragmentConfig = detailGuestFragmentConfig2;
            }
            SquareAvatarExtra extra = squareAvatarItem.getExtra();
            VasSquareDataProvider vasSquareDataProvider = this.provider;
            extra.setDetailBackgroundInfo(vasSquareDataProvider != null ? vasSquareDataProvider.getBackgroundInfo() : null);
            if (squareAvatarItem.isMe()) {
                DetailFragmentLauncher.INSTANCE.launch(this, source, squareAvatarItem, detailGuestFragmentConfig);
                SquareStatusComponent squareStatusComponent = (SquareStatusComponent) getComponent(SquareStatusComponent.class, null, null);
                if (squareStatusComponent != null) {
                    squareStatusComponent.clearStatus();
                }
            } else {
                DetailFragmentLauncher.INSTANCE.launch(this, source, squareAvatarItem, detailGuestFragmentConfig);
            }
            SquareMsgBoxComponent squareMsgBoxComponent = (SquareMsgBoxComponent) getComponent(SquareMsgBoxComponent.class, null, null);
            if (squareMsgBoxComponent != null && (msgBoxManager = squareMsgBoxComponent.getMsgBoxManager()) != null) {
                msgBoxManager.jumpToDetailPage();
            }
            forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$doGotoDetailPage$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                    invoke2(squareBaseComponent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareBaseComponent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onGoToDetail();
                }
            });
        }
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_SQUARE;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public SettingTipsController getTipsController() {
        return getSettingController().getTipsController();
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public SquareMapViewModel getVm() {
        return (SquareMapViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public void initMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            Intent intent = activity.getIntent();
            Integer num = null;
            SquareFilamentCoverComponent squareFilamentCoverComponent = (SquareFilamentCoverComponent) getComponent(SquareFilamentCoverComponent.class, null, null);
            if (squareFilamentCoverComponent != null) {
                squareFilamentCoverComponent.initialize();
            }
            SquareFragComponent squareFragComponent = (SquareFragComponent) getComponent(SquareFragComponent.class, null, null);
            if (squareFragComponent != null) {
                squareFragComponent.initialize(config, dataList, this);
            }
            SquareStatusComponent squareStatusComponent = (SquareStatusComponent) getComponent(SquareStatusComponent.class, null, null);
            if (squareStatusComponent != null) {
                squareStatusComponent.initialize(config, dataList, this);
            }
            SquareFootLabelComponent squareFootLabelComponent = (SquareFootLabelComponent) getComponent(SquareFootLabelComponent.class, null, null);
            if (squareFootLabelComponent != null) {
                squareFootLabelComponent.refreshAvatarFootLabel();
            }
            SquareNoviceGuideComponent squareNoviceGuideComponent = (SquareNoviceGuideComponent) getComponent(SquareNoviceGuideComponent.class, null, null);
            if (squareNoviceGuideComponent != null) {
                squareNoviceGuideComponent.initialize();
            }
            SquareMultiPoseComponent squareMultiPoseComponent = (SquareMultiPoseComponent) getComponent(SquareMultiPoseComponent.class, null, null);
            if (squareMultiPoseComponent != null) {
                squareMultiPoseComponent.initialize();
            }
            SquareIntimateComponent squareIntimateComponent = (SquareIntimateComponent) getComponent(SquareIntimateComponent.class, null, null);
            if (squareIntimateComponent != null) {
                squareIntimateComponent.initialize();
            }
            initBuildingStyle();
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$initMapView$1
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
                    CommonSettingWindowController settingController;
                    PerfMonitor perfMonitor = (PerfMonitor) SquareFragment.this.getComponent(PerfMonitor.class, null, null);
                    if (perfMonitor != null) {
                        perfMonitor.exposureStep(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_EXPOSURE_TIME);
                    }
                    Context it = SquareFragment.this.getContext();
                    if (it != null) {
                        settingController = SquareFragment.this.getSettingController();
                        SettingTipsController tipsController = settingController.getTipsController();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        tipsController.showFirstToastIfNeed(it);
                    }
                }
            });
            boolean areEqual = Intrinsics.areEqual(intent != null ? intent.getStringExtra(DetailMeFragmentConfig.NEED_OPEN_PANEL) : null, "1");
            Integer intOrNull = (intent == null || (stringExtra3 = intent.getStringExtra(DetailMeFragmentConfig.CURRENT_STATUS_ID)) == null) ? null : StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra3);
            Integer intOrNull2 = (intent == null || (stringExtra2 = intent.getStringExtra(DetailMeFragmentConfig.CURRENT_RICH_ID)) == null) ? null : StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra2);
            if (intent != null && (stringExtra = intent.getStringExtra("actionId")) != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra);
            }
            this.detailParams = new DetailLaunchParams(areEqual, intOrNull, intOrNull2, num);
        }
    }

    @Override // com.tencent.state.map.MapFragment
    public void locateFailOnTryScaleToDetail(String uin, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        DetailFragmentLauncher.launch$default(DetailFragmentLauncher.INSTANCE, this, EntranceSource.INSTANCE.covertFromScheme(bundle), uin, null, null, 24, null);
    }

    public final void locateToNewLocation(List<MoveItem> itemList, boolean needLocateTo, Function1<? super Boolean, Unit> endCallback) {
        int collectionSizeOrDefault;
        Object first;
        IMapViewManipulator manipulator;
        IDynamicLayoutComponent iDynamicLayoutComponent;
        List<MoveRequest> findMoveToIndexList;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        if (!needLocateTo) {
            if (endCallback != null) {
                endCallback.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (itemList.isEmpty()) {
            return;
        }
        SquareView mapView = getMapView();
        MapAdapter adapter = mapView != null ? mapView.getAdapter() : null;
        if (adapter == null) {
            ChatAddUinComponent chatAddUinComponent = (ChatAddUinComponent) VasBaseLifecycleFragment.getComponent$default(this, ChatAddUinComponent.class, null, null, 6, null);
            if (chatAddUinComponent != null) {
                chatAddUinComponent.pendingAdd(itemList);
                return;
            }
            return;
        }
        List<MoveItem> list = itemList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (final MoveItem moveItem : list) {
            arrayList.add(Integer.valueOf(adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareFragment$locateToNewLocation$indexList$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), MoveItem.this.getUin()) && it.getUnitType() == MoveItem.this.getUnitType() && it.getType() != 10;
                }
            })));
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        int intValue = ((Number) first).intValue();
        if (intValue < 0) {
            SquareView mapView2 = getMapView();
            if (mapView2 != null && (iDynamicLayoutComponent = (IDynamicLayoutComponent) mapView2.getComponent(IDynamicLayoutComponent.class)) != null && (findMoveToIndexList = iDynamicLayoutComponent.findMoveToIndexList(arrayList)) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) findMoveToIndexList);
                MoveRequest moveRequest = (MoveRequest) firstOrNull;
                if (moveRequest != null) {
                    intValue = moveRequest.getDstIndex();
                }
            }
            intValue = -1;
        }
        SquareView mapView3 = getMapView();
        if (mapView3 == null || (manipulator = mapView3.getManipulator()) == null) {
            return;
        }
        manipulator.locateTo(intValue, endCallback);
    }

    public final void onBackFromDetail(final Bundle data) {
        IMsgBoxManager msgBoxManager;
        Intrinsics.checkNotNullParameter(data, "data");
        int i3 = data.getInt(SquareConstants.DETAIL_FRAGMENT_HASH);
        Fragment topFragment = getTopFragment();
        if (topFragment != null) {
            if (!(topFragment instanceof DetailBaseSelectFragment)) {
                SquareInteractionComponent squareInteractionComponent = (SquareInteractionComponent) getComponent(SquareInteractionComponent.class, null, null);
                if (squareInteractionComponent != null) {
                    squareInteractionComponent.onBackFromDetail(data);
                    return;
                }
                return;
            }
            if (i3 != 0 && topFragment.hashCode() != i3) {
                return;
            }
        }
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.onBackFromDetail();
        }
        SquareMsgBoxComponent squareMsgBoxComponent = (SquareMsgBoxComponent) getComponent(SquareMsgBoxComponent.class, null, null);
        if (squareMsgBoxComponent != null && (msgBoxManager = squareMsgBoxComponent.getMsgBoxManager()) != null) {
            msgBoxManager.backToMainSquare();
        }
        forEachComponent(ISquareEventListener.class, null, null, new Function1<ISquareEventListener, Unit>() { // from class: com.tencent.state.square.SquareFragment$onBackFromDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ISquareEventListener iSquareEventListener) {
                invoke2(iSquareEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ISquareEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onBackFromDetail(data);
            }
        });
    }

    public final void onBackPressedNotCheck() {
        super.onBackPressed();
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(final boolean isScaleToCenter, final View view, final int index, final MapItem data) {
        SquareView mapView;
        ISquareViewUpdater updater;
        List<Integer> listOf;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCenterScaled(isScaleToCenter, view, index, data);
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onCenterScaled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onCenterScaled(isScaleToCenter, view, index, data);
            }
        });
        if (!isScaleToCenter || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2});
        updater.clearNewInfo(index, listOf);
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onComplete(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onComplete$1
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
                HashMap hashMap;
                ISquareViewUpdater updater;
                SquareFragment.this.currentPlayUin = null;
                hashMap = SquareFragment.this.currentPlayMessage;
                hashMap.remove(uin);
                SquareFragComponent squareFragComponent = (SquareFragComponent) SquareFragment.this.getComponent(SquareFragComponent.class, null, null);
                if (squareFragComponent != null) {
                    squareFragComponent.hideSpeakerMode();
                }
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updatePttPlayState(uin, PlayState.INIT);
            }
        });
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context it = getContext();
        if (it != null) {
            ImageService.Companion companion = ImageService.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            companion.initImageLoader(it);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(VasSquareFragmentSquareBinding.inflate(getLayoutInflater()));
        VasSquareFragmentSquareBinding binding = getBinding();
        if (binding != null && (view = binding.squareTopBar) != null) {
            view.setVisibility(8);
        }
        VasSquareFragmentSquareBinding binding2 = getBinding();
        if (binding2 != null) {
            return binding2.getMContainer();
        }
        return null;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        SquarePageInfo currentPageInfo;
        super.onDestroy();
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.setDetectorCallback(null);
        }
        ISquarePttMessageService pttMessageService = getServiceProvider().getPttMessageService();
        if (pttMessageService != null) {
            pttMessageService.deleteAudioMessageListener(this);
        }
        LikeDataManager.INSTANCE.onDestroy();
        int i3 = 0;
        SquareBatteryStatusManager.INSTANCE.destroy(false);
        SquareMedia.INSTANCE.getCommonPlayerPool().destroy();
        FlowerLayoutView.INSTANCE.recycle();
        SquareBase squareBase = SquareBase.INSTANCE;
        squareBase.getConfig().getAvatarUtils().clean();
        ImageService.INSTANCE.destroy();
        FilamentCoverRecordHelper.INSTANCE.cleanup();
        CacheFileUtils cacheFileUtils = CacheFileUtils.INSTANCE;
        FragmentActivity activity = getActivity();
        if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
            str = "";
        }
        VasSquareDataProvider vasSquareDataProvider = this.provider;
        List<SquareBaseMessageRecord> unreadMsgList = vasSquareDataProvider != null ? vasSquareDataProvider.getUnreadMsgList() : null;
        VasSquareDataProvider vasSquareDataProvider2 = this.provider;
        List<String> recentUserList = vasSquareDataProvider2 != null ? vasSquareDataProvider2.getRecentUserList() : null;
        VasSquareDataProvider vasSquareDataProvider3 = this.provider;
        if (vasSquareDataProvider3 != null && (currentPageInfo = vasSquareDataProvider3.getCurrentPageInfo()) != null) {
            i3 = currentPageInfo.getMapId();
        }
        cacheFileUtils.updateIndexCacheIfNeed(str, unreadMsgList, recentUserList, Integer.valueOf(i3));
        SquareRecordManager.INSTANCE.cleanup();
        squareBase.cleanup();
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ISquarePushService pushService = getServiceProvider().getPushService();
        if (pushService != null) {
            pushService.removeListener(2, this);
        }
        ISquareMusicService musicService = getServiceProvider().getMusicService();
        if (musicService != null) {
            musicService.removeMusicChangeListener(this);
        }
    }

    @Override // com.tencent.state.map.ISquareViewDetectorCallback
    public void onDetectorScale() {
        getSettingController().dismiss();
    }

    @Override // com.tencent.state.map.ISquareViewDetectorCallback
    public void onDetectorScroll() {
        getSettingController().dismiss();
        forEachComponent(ChatLandSquareComponent.class, null, null, new Function1<ChatLandSquareComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onDetectorScroll$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandSquareComponent chatLandSquareComponent) {
                invoke2(chatLandSquareComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandSquareComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.hideMsgHeaderPanel();
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onDoubleClick(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onDoubleClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onDoubleClick(MapViewHolder.this, index, data, viewId);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.square.api.IDressKeyChangeListener
    public void onDressKeyChange(boolean isMale) {
        ISquareViewUpdater iSquareViewUpdater;
        SquareView mapView = getMapView();
        if (mapView == null || (iSquareViewUpdater = (ISquareViewUpdater) mapView.getComponent(ISquareViewUpdater.class)) == null) {
            return;
        }
        Boolean curAvatarGender = iSquareViewUpdater.getCurAvatarGender();
        SquareBaseKt.getSquareLog().i(TAG, "onDressKeyChange isMale:" + isMale + ", curGender:" + curAvatarGender);
        if (Intrinsics.areEqual(curAvatarGender, Boolean.valueOf(isMale))) {
            doOnDressKeyChange(isMale);
        } else {
            doOnDressKeyChangeWithNewGender(isMale);
        }
        SquareBatteryStatusManager.INSTANCE.onDressKeyChange(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), isMale, SquareRecordManager.INSTANCE.getDressKey(), TAG);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onInVisible(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onInVisible$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onInVisible(MapViewHolder.this, index, data);
            }
        });
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onInterrupt(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onInterrupt$1
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
                ISquareViewUpdater updater;
                SquareFragment.this.currentPlayUin = null;
                SquareFragComponent squareFragComponent = (SquareFragComponent) SquareFragment.this.getComponent(SquareFragComponent.class, null, null);
                if (squareFragComponent != null) {
                    squareFragComponent.hideSpeakerMode();
                }
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updatePttPlayState(uin, PlayState.PLAY);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onItemBind(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemBind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemBind(MapViewHolder.this, index, data);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemClicked(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId, final Object extra) {
        SquareAvatarExtra extra2;
        ChatLandAvatarItem meAvatarItemInLands;
        ChatLandPKComponent chatLandPKComponent;
        ISquareBaseMessageService messageService;
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        SquareBaseKt.getSquareLog().i(TAG, "onItemClicked: index=" + index + ", data=" + data + ", clickViewType=" + viewId);
        CommonFootLabel commonFootLabel = null;
        commonFootLabel = null;
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemClicked(MapViewHolder.this, index, data, viewId, extra);
            }
        });
        if (data == null) {
            return;
        }
        if (viewId == 15) {
            gotoDetailPage$default(this, data, SubScene.SQUARE_BUBBLE_INTERACTION, false, null, 8, null);
            return;
        }
        if (viewId == 16) {
            SquareFootLabelComponent squareFootLabelComponent = (SquareFootLabelComponent) getComponent(SquareFootLabelComponent.class, null, null);
            if (squareFootLabelComponent != null) {
                SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(data instanceof SquareAvatarItem) ? null : data);
                if (squareAvatarItem != null && (extra2 = squareAvatarItem.getExtra()) != null) {
                    commonFootLabel = extra2.getFootLabel();
                }
                squareFootLabelComponent.handleClickLabel(commonFootLabel, data.getUin());
                return;
            }
            return;
        }
        if (viewId != 21) {
            switch (viewId) {
                case 1:
                    onUnreadMessageBubbleClick((SquareAvatarItem) (data instanceof SquareAvatarItem ? data : null));
                    return;
                case 2:
                    onPttMessageBubbleClick((SquareAvatarItem) (data instanceof SquareAvatarItem ? data : null));
                    return;
                case 3:
                    gotoDetailPage(data, SubScene.SQUARE_BUBBLE, true, (SquareDetailIntent) (extra instanceof SquareDetailIntent ? extra : null));
                    return;
                case 4:
                    gotoDetailPage$default(this, data, SubScene.SQUARE_BUBBLE, false, null, 8, null);
                    return;
                case 5:
                    boolean z16 = data instanceof SquareAvatarItem;
                    if (!z16 || ((SquareAvatarItem) data).getExtra().unReadCount() <= 0) {
                        return;
                    }
                    onUnreadMessageBubbleClick((SquareAvatarItem) (z16 ? data : null));
                    return;
                case 6:
                    if (!(data instanceof SquareTroopItem) || getActivity() == null || (messageService = getServiceProvider().getMessageService()) == null) {
                        return;
                    }
                    ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, this, 0, data.getUin(), MessageRecordType.RECORD_TYPE_TROOP, false, false, null, null, null, w.CTRL_INDEX, null);
                    return;
                case 7:
                    pushFragment(VasMayKnowFragment.INSTANCE.newInstance());
                    VasBaseFragmentKt.setFragmentResultListener(this, VasMayKnowFragment.DO_BACK_EVENT, new Function2<String, Bundle, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemClicked$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                            invoke2(str, bundle);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String key, Bundle bundle) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(bundle, "<anonymous parameter 1>");
                            if (Intrinsics.areEqual(key, VasMayKnowFragment.DO_BACK_EVENT)) {
                                SquareFragment.this.onVisibilityChanged(true, VasMayKnowFragment.DO_BACK_EVENT);
                            }
                        }
                    });
                    return;
                case 8:
                    gotoDetailPage$default(this, data, SubScene.SQUARE_AVATAR, extra instanceof SquareAnchorEntrance, null, 8, null);
                    return;
                case 9:
                    if (data instanceof SquareAvatarItem) {
                        SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) data;
                        squareAvatarItem2.getFeedInfo().setHasNew(false);
                        SquareView mapView = getMapView();
                        if (mapView == null || (updater = mapView.getUpdater()) == null) {
                            return;
                        }
                        updater.updateFeedsBubble(data.getUin(), squareAvatarItem2.getFeedInfo());
                        return;
                    }
                    return;
                case 10:
                    if (data instanceof SquareEntranceItem) {
                        updateSceneBuilding((SquareEntranceItem) data);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        ChatLandPKComponent chatLandPKComponent2 = (ChatLandPKComponent) getComponent(ChatLandPKComponent.class, null, null);
        if (chatLandPKComponent2 == null || (meAvatarItemInLands = chatLandPKComponent2.getMeAvatarItemInLands()) == null || (chatLandPKComponent = (ChatLandPKComponent) getComponent(ChatLandPKComponent.class, null, Integer.valueOf(meAvatarItemInLands.getAppId()))) == null) {
            return;
        }
        chatLandPKComponent.showPKPanelIfNeeded(true);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemLongClick(final MapViewHolder<?> vh5, final int index, final MapItem data, final int viewId) {
        Context it;
        SquareView mapView;
        SquareView mapView2;
        SquareView mapView3;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemLongClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                it5.onItemLongClick(MapViewHolder.this, index, data, viewId);
            }
        });
        if (data instanceof SquareAvatarItem) {
            Context it5 = getContext();
            if (it5 == null || (mapView3 = getMapView()) == null) {
                return;
            }
            CommonSettingWindowController settingController = getSettingController();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            settingController.show(mapView3, vh5, data, it5, 1);
            return;
        }
        if (data instanceof SquareTroopItem) {
            Context it6 = getContext();
            if (it6 == null || (mapView2 = getMapView()) == null) {
                return;
            }
            CommonSettingWindowController settingController2 = getSettingController();
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            settingController2.show(mapView2, vh5, data, it6, 4);
            return;
        }
        if (!(data instanceof SquareMayKnowItem) || (it = getContext()) == null || (mapView = getMapView()) == null) {
            return;
        }
        CommonSettingWindowController settingController3 = getSettingController();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        settingController3.show(mapView, vh5, data, it, 7);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(final MapItem data, final Object extra) {
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemRecordCover$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemRecordCover(MapItem.this, extra);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onMapSizeInitReady() {
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onMapSizeInitReady$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapSizeInitReady();
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(final boolean isZoomIn) {
        String str;
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onMapZoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapZoom(isZoomIn);
            }
        });
        if (isZoomIn) {
            str = SquareReportConst.CustomEventId.EVENT_ID_SMALL_MAP;
        } else {
            str = SquareReportConst.CustomEventId.EVENT_ID_BIG_MAP;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(getActivity()));
        Unit unit = Unit.INSTANCE;
        squareReporter.reportEvent(str, linkedHashMap);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(final int zoomLevel, final float scale, final boolean isZoomIn) {
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onMapZoomEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapZoomEnd(zoomLevel, scale, isZoomIn);
            }
        });
        forEachComponent(ITemplateMapEvent.class, null, null, new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onMapZoomEnd$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMapZoomEnd(zoomLevel, scale, isZoomIn);
            }
        });
    }

    @Override // com.tencent.state.square.api.MusicChangeListener
    public void onMusicInfoChange(String uin, SongInfo songInfo) {
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareView mapView = getMapView();
        if (mapView == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.updateUserSongInfo(uin, songInfo);
    }

    @Override // com.tencent.state.square.api.MusicChangeListener
    public void onMusicPlayStateChange(String songMid) {
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        SquareView mapView = getMapView();
        if (mapView == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.updateMusicPlayState(songMid);
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onNewMessagePlay(final PttMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onNewMessagePlay$1
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
                HashMap hashMap;
                hashMap = SquareFragment.this.currentPlayMessage;
                hashMap.put(message.getUin(), message);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onPlayError(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onPlayError$1
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
                HashMap hashMap;
                ISquareViewUpdater updater;
                SquareFragment.this.currentPlayUin = null;
                hashMap = SquareFragment.this.currentPlayMessage;
                hashMap.remove(uin);
                SquareFragComponent squareFragComponent = (SquareFragComponent) SquareFragment.this.getComponent(SquareFragComponent.class, null, null);
                if (squareFragComponent != null) {
                    squareFragComponent.hideSpeakerMode();
                }
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updatePttPlayState(uin, PlayState.PLAY);
            }
        });
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onPlayPause(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onPlayPause$1
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
                ISquareViewUpdater updater;
                SquareFragComponent squareFragComponent = (SquareFragComponent) SquareFragment.this.getComponent(SquareFragComponent.class, null, null);
                if (squareFragComponent != null) {
                    squareFragComponent.hideSpeakerMode();
                }
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updatePttPlayState(uin, PlayState.PLAY);
            }
        });
    }

    @Override // com.tencent.state.square.api.AudioMessageListener
    public void onPlayStart(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onPlayStart$1
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
                ISquareViewUpdater updater;
                SquareServiceProvider serviceProvider;
                SquareFragment.this.currentPlayUin = uin;
                SquareFragComponent squareFragComponent = (SquareFragComponent) SquareFragment.this.getComponent(SquareFragComponent.class, null, null);
                if (squareFragComponent != null) {
                    serviceProvider = SquareFragment.this.getServiceProvider();
                    ISquarePttMessageService pttMessageService = serviceProvider.getPttMessageService();
                    squareFragComponent.showSpeakerMode(pttMessageService != null ? pttMessageService.getLoudSpeakerState() : false);
                }
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView == null || (updater = mapView.getUpdater()) == null) {
                    return;
                }
                updater.updatePttPlayState(uin, PlayState.PLAYING);
            }
        });
    }

    @Override // com.tencent.state.square.api.ISquarePushListener
    public void onResult(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            final au4.a c16 = au4.a.c(data);
            Intrinsics.checkNotNullExpressionValue(c16, "CustomTextBeatNotice.parseFrom(data)");
            SquareBaseKt.getSquareLog().w(TAG, "[beatText] onResult: {" + c16 + '}');
            SquareBase.INSTANCE.getConfig().getThreadManager().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onResult$1
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
                    ISquareViewUpdater updater;
                    SquareBaseKt.getSquareLog().w("SquareFragment", "[beatText] onResult, post: {" + c16.f26962c + '}');
                    SquareView mapView = SquareFragment.this.getMapView();
                    if (mapView == null || (updater = mapView.getUpdater()) == null) {
                        return;
                    }
                    String str = c16.f26962c;
                    Intrinsics.checkNotNullExpressionValue(str, "result.customTextMd5");
                    updater.updateMeCustomText(str);
                }
            });
        } catch (Exception e16) {
            SquareBaseKt.getSquareLog().e(TAG, "[beatText] onResult, CustomTextBeatNotice parse error", e16);
        }
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onRoleAdded(final List<MoveItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onRoleAdded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onRoleAdded(data);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onRoleRemoved(final List<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onRoleRemoved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onRoleRemoved(data);
            }
        });
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onStartRecord(final Resource resource, final IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onStartRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onStartRecord(Resource.this, callback);
            }
        });
        getRecorder().startRecord(getServiceProvider().getInviter(), resource, false, callback);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.setDetectorCallback(this);
        }
        initPushService();
        initViewModels();
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseLifecycleFragment
    public void onVisibilityChanged(boolean isVisible, String from) {
        ISquarePttMessageService pttMessageService;
        Intrinsics.checkNotNullParameter(from, "from");
        super.onVisibilityChanged(isVisible, from);
        if (this.currentPlayUin != null && (pttMessageService = getServiceProvider().getPttMessageService()) != null) {
            String str = this.currentPlayUin;
            Intrinsics.checkNotNull(str);
            pttMessageService.pause(str);
        }
        if (isVisible) {
            SquareQZoneFeedsManager.INSTANCE.checkAndShowQZonePrivacyDialog(getContext());
        }
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onVisible(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onVisible$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onVisible(MapViewHolder.this, index, data);
            }
        });
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onZoomOverOut(final MapViewHolder<?> vh5, final int index, final MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onZoomOverOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onZoomOverOut(MapViewHolder.this, index, data);
            }
        });
        gotoDetailPage$default(this, data, SubScene.SQUARE_AVATAR, false, null, 8, null);
    }

    @Override // com.tencent.state.map.MapFragment
    protected void sendMapDataRequest(final boolean isRefresh) {
        String str;
        FragmentActivity activity = getActivity();
        if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
            str = "";
        }
        VasSquareDataProvider vasSquareDataProvider = new VasSquareDataProvider(str, getServiceProvider().getMessageService(), getServiceProvider().getPttMessageService());
        this.provider = vasSquareDataProvider;
        vasSquareDataProvider.getSquareNextPage(new Function5<List<? extends MapItem>, Boolean, Image, Boolean, Boolean, Unit>() { // from class: com.tencent.state.square.SquareFragment$sendMapDataRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MapItem> list, Boolean bool, Image image, Boolean bool2, Boolean bool3) {
                invoke(list, bool.booleanValue(), image, bool2.booleanValue(), bool3.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends MapItem> dataList, boolean z16, Image map, boolean z17, boolean z18) {
                VasSquareDataProvider vasSquareDataProvider2;
                VasSquareDataProvider vasSquareDataProvider3;
                VasSquareDataProvider vasSquareDataProvider4;
                Intrinsics.checkNotNullParameter(dataList, "dataList");
                Intrinsics.checkNotNullParameter(map, "map");
                if (z18) {
                    SquareGroupUiComponent squareGroupUiComponent = (SquareGroupUiComponent) SquareFragment.this.getComponent(SquareGroupUiComponent.class, null, null);
                    if (squareGroupUiComponent != null) {
                        squareGroupUiComponent.forbidDialog();
                        return;
                    }
                    return;
                }
                SquareFragment.this.getVm().updateMapData(new MapData(dataList, map, isRefresh, z17));
                SquareMapViewModel vm5 = SquareFragment.this.getVm();
                vasSquareDataProvider2 = SquareFragment.this.provider;
                vm5.updateTipType(vasSquareDataProvider2 != null ? Integer.valueOf(vasSquareDataProvider2.getTipType()) : null);
                SquareView mapView = SquareFragment.this.getMapView();
                if (mapView != null) {
                    vasSquareDataProvider4 = SquareFragment.this.provider;
                    mapView.setBackgroundInfo(vasSquareDataProvider4 != null ? vasSquareDataProvider4.getBackgroundInfo() : null);
                }
                SquareFragment squareFragment = SquareFragment.this;
                vasSquareDataProvider3 = squareFragment.provider;
                squareFragment.updateTopBar(vasSquareDataProvider3 != null ? vasSquareDataProvider3.getBackgroundInfo() : null);
            }
        });
    }

    public void setBinding(VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding) {
        this.binding = vasSquareFragmentSquareBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public void updateMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        SquareFragComponent squareFragComponent = (SquareFragComponent) getComponent(SquareFragComponent.class, null, null);
        if (squareFragComponent != null) {
            squareFragComponent.updateDataList(config, dataList, this);
        }
        SquareFootLabelComponent squareFootLabelComponent = (SquareFootLabelComponent) getComponent(SquareFootLabelComponent.class, null, null);
        if (squareFootLabelComponent != null) {
            squareFootLabelComponent.refreshAvatarFootLabel();
        }
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStringWithGender(int resId, boolean isMale) {
        String str;
        Object[] objArr = new Object[1];
        if (isMale) {
            str = "\u4ed6";
        } else {
            str = "\u5979";
        }
        objArr[0] = str;
        String string = getString(resId, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "getString(resId, if (isMale) \"\u4ed6\" else \"\u5979\")");
        return string;
    }

    @Override // com.tencent.state.map.MapFragment
    public VasSquareFragmentSquareBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapFragment
    public SquareView getMapView() {
        VasSquareFragmentSquareBinding binding = getBinding();
        if (binding != null) {
            return binding.squareView;
        }
        return null;
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public IMapItemViewManager getScreenViewManager() {
        try {
            SquareView mapView = getMapView();
            if (mapView != null) {
                return mapView.getItemViewManager();
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getScreenViewManager err.", th5);
            return null;
        }
    }

    public final View getSelectIconContainer() {
        try {
            VasSquareFragmentSquareBinding binding = getBinding();
            if (binding != null) {
                return binding.leftContainer;
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSelectIconContainer, err.", th5);
            return null;
        }
    }

    public final View getSquareLocateIcon() {
        try {
            VasSquareFragmentSquareBinding binding = getBinding();
            if (binding != null) {
                return binding.location;
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSquareAddIcon, err.", th5);
            return null;
        }
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public IMapViewManipulator getSquareViewAbility() {
        try {
            SquareView mapView = getMapView();
            if (mapView != null) {
                return mapView.getManipulator();
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSquareViewAbility err.", th5);
            return null;
        }
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareViewUpdater getSquareViewUpdater() {
        try {
            SquareView mapView = getMapView();
            if (mapView != null) {
                return mapView.getUpdater();
            }
            return null;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getSquareViewUpdater err.", th5);
            return null;
        }
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareViewBridge getViewBridge() {
        return (ISquareViewBridge) getComponent(SquareMsgBoxComponent.class, null, null);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        SquareView mapView;
        ISquareViewUpdater updater;
        SquareWhiteListComponent squareWhiteListComponent = (SquareWhiteListComponent) getComponent(SquareWhiteListComponent.class, null, null);
        if (squareWhiteListComponent != null) {
            squareWhiteListComponent.showWhiteDialog(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.SquareFragment$onBackPressed$1
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
                    SquareGroupFloatingComponent squareGroupFloatingComponent = (SquareGroupFloatingComponent) VasBaseLifecycleFragment.getComponent$default(SquareFragment.this, SquareGroupFloatingComponent.class, null, null, 6, null);
                    if (squareGroupFloatingComponent != null) {
                        squareGroupFloatingComponent.exitSquareEndFocusDialog(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$onBackPressed$1.1
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
                                super/*com.tencent.state.map.MapFragment*/.onBackPressed();
                            }
                        });
                    }
                }
            });
        }
        if (!this.isBuildingChange || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return true;
        }
        updater.saveBuildingChange();
        return true;
    }

    private final void handleOpenMiniAio(String uin, MessageRecordType type, String nickName) {
        SquareBaseMessageRecord squareTempMessageRecord;
        ISquareViewUpdater updater;
        PttMessage pttMessage = this.currentPlayMessage.get(uin);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            ISquareBaseMessageService messageService = getServiceProvider().getMessageService();
            if (messageService != null) {
                ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, this, 0, uin, type, false, false, pttMessage, nickName, null, 256, null);
            }
            ISquarePttMessageService pttMessageService = getServiceProvider().getPttMessageService();
            if (pttMessageService != null) {
                pttMessageService.clearTargetUinMessage(uin);
            }
            this.currentPlayMessage.remove(uin);
            int i3 = 2;
            MessageRecordType messageRecordType = null;
            byte b16 = 0;
            byte b17 = 0;
            byte b18 = 0;
            if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] != 1) {
                squareTempMessageRecord = new SquareMessageRecord(uin, messageRecordType, i3, b18 == true ? 1 : 0);
            } else {
                squareTempMessageRecord = new SquareTempMessageRecord(uin, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
            }
            SquareView mapView = getMapView();
            if (mapView == null || (updater = mapView.getUpdater()) == null) {
                return;
            }
            updater.onUnreadMessageNotify(squareTempMessageRecord);
        }
    }

    private final void handlePlayPtt(SquareAvatarItem data) {
        String uin;
        if (data == null || (uin = data.getUin()) == null) {
            return;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[data.getExtra().getIsPlayingPtt().ordinal()];
        if (i3 != 1 && i3 != 2) {
            ISquarePttMessageService pttMessageService = getServiceProvider().getPttMessageService();
            if (pttMessageService != null) {
                pttMessageService.pause(uin);
                return;
            }
            return;
        }
        ISquarePttMessageService pttMessageService2 = getServiceProvider().getPttMessageService();
        if (pttMessageService2 != null) {
            pttMessageService2.requestPlay(uin);
        }
    }

    private final void onPttMessageBubbleClick(SquareAvatarItem data) {
        String uin = data != null ? data.getUin() : null;
        if (TextUtils.isEmpty(uin)) {
            SquareBaseKt.getSquareLog().w(TAG, "onPttMessageBubbleClick uin:" + uin);
            return;
        }
        handlePlayPtt(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{getServiceProvider(), new SquareFragComponent(), new SquareMsgBoxComponent(), new SquareLibraryComponent(), new PerfMonitor(PerformanceReportConst.Param.EM_SCENE_MAP, new WeakReference(getServiceProvider())), new SquareEntryComponent(), new SquareDebugComponent(), new SquareBuildingComponent(), new SquareRecommendComponent(), new SquareCommonEntranceComponent(), new SquareInteractionComponent(), new SquareStatusComponent(), new SquareResPreloadComponent(), new SquareFlowerComponent(), new SquareFlowerReportComponent(), new SquareEventBusComponent(), new SquareBlindBoxComponent(), new SquareNoviceGuideComponent(), new SquareZPlanEntranceComponent(), new SquareWhiteListComponent(), new SquareScaleAnimComponent(), new SquareMultiPoseComponent(), new SquareShareComponent(), new SquareFootLabelComponent(), new SquareOnlineStatusComponent(), new SquareFriendStatusPanelComponent(), new SquareBubbleSkinComponent(), new SquareJSComponent(), new ChatAddUinComponent(), new SquareQuickPublishEntryComponent(), new SquareFilamentCoverComponent(), new SquareIntimateComponent(), new SquareHomeScreenComponent(), new SquareSettingsMenuComponent()});
        return listOf;
    }

    @Override // com.tencent.state.map.MapFragment, com.tencent.state.map.IMapViewListener
    public void onItemBind(final MapViewHolder<?> vh5, final int index, final MapItem data, final int event) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        forEachComponent(SquareBaseComponent.class, null, null, new Function1<SquareBaseComponent, Unit>() { // from class: com.tencent.state.square.SquareFragment$onItemBind$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareBaseComponent squareBaseComponent) {
                invoke2(squareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onItemBind(MapViewHolder.this, index, data, event);
            }
        });
    }

    private final void onUnreadMessageBubbleClick(SquareAvatarItem data) {
        MessageRecordType messageRecordType;
        SquareBaseMessageRecord squareMessageRecord;
        MessageRecordType messageRecordType2 = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        String uin = data != null ? data.getUin() : null;
        if (uin != null && !TextUtils.isEmpty(uin)) {
            if (data.getExtra().isFriend()) {
                messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
            } else if (data.getExtra().isStranger()) {
                messageRecordType = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
            } else {
                messageRecordType = MessageRecordType.RECORD_TYPE_NONE;
            }
            handleOpenMiniAio(uin, messageRecordType, data.getNickName());
            int i3 = 2;
            if (data.getExtra().isStranger()) {
                squareMessageRecord = new SquareTempMessageRecord(uin, messageRecordType2, i3, b18 == true ? 1 : 0);
            } else {
                squareMessageRecord = new SquareMessageRecord(uin, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
            }
            onUnreadMessageNotify(squareMessageRecord);
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "onUnreadMessageBubbleClick uin:" + uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddRoleToast(final String tips, boolean needToast) {
        if (needToast) {
            SquareBaseKt.getSquareLog().i(TAG, "[addRoles] showAddRoleToast, text:" + tips);
            Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.SquareFragment$showAddRoleToast$1
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
                    Context it = SquareFragment.this.getContext();
                    if (it != null) {
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        ICommonUtils.DefaultImpls.showToast$default(squareCommon, it, tips, 0, 4, (Object) null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.resource.ISquareRoleManager
    public void addMultiRoles(final List<MoveItem> list, final int from, final MainScene mainScene, final Integer sceneType, final boolean needToast, boolean needLocateTo, final Function1<? super Map<MoveItem, MoveResult>, Unit> callback) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(mainScene, "mainScene");
        SquareDebug.INSTANCE.printMoveItemInfo("[addRoles] addMultiRoles, scene:" + mainScene.name() + ", sceneType:" + sceneType + ", needToast:" + needToast + ", needLocateTo:" + needLocateTo, list);
        if (list.isEmpty()) {
            return;
        }
        locateToNewLocation(list, needLocateTo, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.SquareFragment$addMultiRoles$1
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
                CommonSettingWindowController settingController;
                String stringWithGender;
                SquareView mapView = SquareFragment.this.getMapView();
                ISquareViewUpdater updater = mapView != null ? mapView.getUpdater() : null;
                if (updater == null) {
                    SquareFragment squareFragment = SquareFragment.this;
                    stringWithGender = squareFragment.getStringWithGender(com.tencent.mobileqq.R.string.xem, ((MoveItem) list.get(0)).isMale());
                    squareFragment.showAddRoleToast(stringWithGender, needToast);
                    ChatAddUinComponent chatAddUinComponent = (ChatAddUinComponent) VasBaseLifecycleFragment.getComponent$default(SquareFragment.this, ChatAddUinComponent.class, null, null, 6, null);
                    if (chatAddUinComponent != null) {
                        chatAddUinComponent.pendingAdd(list);
                        return;
                    }
                    return;
                }
                SquareBaseKt.getSquareLog().i("SquareFragment", "[addRoles] addMultiRoles, locateTo.success:" + z16);
                Map<MoveItem, MoveResult> doAirborneLanding = updater.doAirborneLanding(list);
                if (doAirborneLanding != null) {
                    settingController = SquareFragment.this.getSettingController();
                    settingController.getTipsController().setHasAddTroop(from == 0);
                    Function1 function1 = callback;
                    if (function1 != null) {
                    }
                    LocalAddRoleResultInfo localAddRoleResultInfo = new LocalAddRoleResultInfo(list, doAirborneLanding);
                    if (localAddRoleResultInfo.getServerReqList().isEmpty()) {
                        SquareFragment.this.onLocalAddRoleInterrupt(localAddRoleResultInfo);
                    } else if (SquareDebug.INSTANCE.getEnableAddMulti()) {
                        SquareFragment.this.patchAddToSquareOnServer(localAddRoleResultInfo, mainScene, sceneType, needToast);
                    }
                }
            }
        });
    }

    static /* synthetic */ void gotoDetailPage$default(SquareFragment squareFragment, MapItem mapItem, SubScene subScene, boolean z16, SquareDetailIntent squareDetailIntent, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            squareDetailIntent = null;
        }
        squareFragment.gotoDetailPage(mapItem, subScene, z16, squareDetailIntent);
    }

    public static /* synthetic */ void locateToNewLocation$default(SquareFragment squareFragment, List list, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        squareFragment.locateToNewLocation(list, z16, function1);
    }

    static /* synthetic */ void showAddRoleToast$default(SquareFragment squareFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        squareFragment.showAddRoleToast(str, z16);
    }

    static /* synthetic */ void patchAddToSquareOnServer$default(SquareFragment squareFragment, LocalAddRoleResultInfo localAddRoleResultInfo, MainScene mainScene, Integer num, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        squareFragment.patchAddToSquareOnServer(localAddRoleResultInfo, mainScene, num, z16);
    }

    @Override // com.tencent.state.square.resource.ISquareViewManagerProxy
    public ISquareRoleManager getSquareRoleManager() {
        return this;
    }
}
