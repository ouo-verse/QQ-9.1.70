package com.tencent.state.square.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.perf.PerfMonitor;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.InviteGender;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.service.VasMultiMotionService;
import com.tencent.state.service.VasSquareNewStatusRedDotService;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IDressKeyChangeListener;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.bubblesetting.BubbleSettingSheet;
import com.tencent.state.square.components.SquareGroupServiceComponent;
import com.tencent.state.square.components.fragment.SquareBubbleSkinComponent;
import com.tencent.state.square.components.fragment.SquareFilamentCoverComponent;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentDataUtilsKt;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.PanelInfo;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareJudgeRecordData;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.data.StatusLockInfo;
import com.tencent.state.square.data.StickerType;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareDetailMeViewBinding;
import com.tencent.state.square.detail.DetailMeListener;
import com.tencent.state.square.detail.StatusPublishHelper;
import com.tencent.state.square.detail.StatusReportHelper;
import com.tencent.state.square.detail.components.DetailFlowerComponent;
import com.tencent.state.square.detail.components.IDetailEventListener;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.detail.event.DetailMeBackEvent;
import com.tencent.state.square.detail.event.DetailMeGetNoviceGuideConfigResultEvent;
import com.tencent.state.square.detail.event.DetailMeUpdateResourceEvent;
import com.tencent.state.square.detail.event.DetailMeUpdateStatusEvent;
import com.tencent.state.square.event.OpenTaskEvent;
import com.tencent.state.square.event.UpdateBubbleSkinEvent;
import com.tencent.state.square.guide.NoviceGuideRecordForReport;
import com.tencent.state.square.guide.SquareRolePageResultEvent;
import com.tencent.state.square.interaction.InteractionSettingsDialog;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import com.tencent.state.square.interaction.record.InteractionRecordDialog;
import com.tencent.state.square.interaction.record.InteractionRecordUnReadCaseForFragment;
import com.tencent.state.square.invite.ISelectFriendCallback;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.square.location.AvatarPoiHandler;
import com.tencent.state.square.location.IPoiHandler;
import com.tencent.state.square.pickfriend.PickFriendView;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.status.NewStatusInfo;
import com.tencent.state.status.SquareOnlineStatusMultiActionPanelHelper;
import com.tencent.state.status.SquareStatusViewModel;
import com.tencent.state.utils.BundleParamsUtils;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.StringFormatUtils;
import com.tencent.state.view.SquareImageView;
import com.tencent.zplan.common.utils.d;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u009b\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u009b\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020.H\u0016JD\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001a2\"\b\u0002\u00103\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020.\u0018\u000104H\u0002J\b\u00105\u001a\u00020.H\u0016J\u0016\u00106\u001a\u00020.2\f\u00107\u001a\b\u0012\u0004\u0012\u00020.08H\u0002JE\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u00100\u001a\u00020\u000b2!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020.0?H\u0002J\u001c\u0010C\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\u001aH\u0002J\u001e\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020.08H\u0002J8\u0010L\u001a\u00020.2\u0006\u0010J\u001a\u00020=2\u0006\u00101\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u000b2\u0016\b\u0002\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0018\u00010?H\u0002J\"\u0010N\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010M\u001a\u00020\u000bH\u0002J\"\u0010Q\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010M\u001a\u00020\u000bH\u0002J\u000e\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u001aJ\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UH\u0014J\u0014\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020Y0XH\u0016J&\u0010Z\u001a\u00020.2\b\u0010[\u001a\u0004\u0018\u00010\u000b2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020.0?H\u0002J$\u0010]\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150^j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015`_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u00020.H\u0002J\b\u0010c\u001a\u00020\u000bH\u0016J \u0010d\u001a\u00020.2\u0006\u0010e\u001a\u00020\b2\u0006\u0010f\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010gJ1\u0010h\u001a\u00020.2'\u0010>\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020i0U\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020.0?H\u0002J\b\u0010k\u001a\u00020.H\u0016J\u0010\u0010l\u001a\u00020.2\u0006\u0010m\u001a\u00020,H\u0002J\b\u0010n\u001a\u00020.H\u0016J\b\u0010o\u001a\u00020.H\u0016J\u0012\u0010p\u001a\u00020.2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0012\u0010s\u001a\u00020.2\b\u0010t\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010u\u001a\u00020.2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\b\u0010x\u001a\u00020.H\u0016J\b\u0010y\u001a\u00020.H\u0016J\u0010\u0010z\u001a\u00020.2\u0006\u0010{\u001a\u00020\u001aH\u0016J\u0010\u0010|\u001a\u00020.2\u0006\u0010}\u001a\u00020FH\u0014J\u001b\u0010~\u001a\u00020.2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u000bH\u0002J#\u0010\u0081\u0001\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010M\u001a\u00020\u000bH\u0016J\u0014\u0010\u0082\u0001\u001a\u00020.2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020.2\u0007\u0010<\u001a\u00030\u0085\u0001H\u0016J\u001b\u0010\u0086\u0001\u001a\u00020.2\u0006\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020.2\u0007\u0010\u0088\u0001\u001a\u00020iH\u0016J\t\u0010\u0089\u0001\u001a\u00020.H\u0016J\u001e\u0010\u008a\u0001\u001a\u00020.2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u001e\u0010\u008b\u0001\u001a\u00020.2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u008c\u0001\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\u0006\u0010O\u001a\u00020PH\u0016J\u001c\u0010\u008d\u0001\u001a\u00020.2\u0007\u0010m\u001a\u00030\u008e\u00012\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\u001b\u0010\u008f\u0001\u001a\u00020.2\u0007\u0010\u0090\u0001\u001a\u00020\u001a2\u0007\u0010\u0091\u0001\u001a\u00020\u000bH\u0014J'\u0010\u0092\u0001\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\u0014\u0010>\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020.0?H\u0016JA\u0010\u0093\u0001\u001a\u00020.2\b\u0010[\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010J\u001a\u0004\u0018\u00010=2\u0007\u0010>\u001a\u00030\u0095\u0001H\u0016\u00a2\u0006\u0003\u0010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\t\u0010\u0098\u0001\u001a\u00020.H\u0016J\t\u0010\u0099\u0001\u001a\u00020.H\u0002J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000bH\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R:\u0010\u0013\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00170\u0014j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectMeFragment;", "Lcom/tencent/state/square/detail/DetailBaseSelectFragment;", "Lcom/tencent/state/square/detail/DetailMeFragmentConfig;", "Lcom/tencent/state/square/detail/DetailMeListener;", "Lcom/tencent/state/square/api/ISquarePushListener;", "Lcom/tencent/state/square/api/IDressKeyChangeListener;", "()V", "currentFriendGender", "", "Ljava/lang/Integer;", "currentFriendUin", "", "eventBus", "Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "kotlin.jvm.PlatformType", "getEventBus", "()Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "setEventBus", "(Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;)V", "eventMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "isDressKeyChange", "", "isEditorPage", "isFirstSetFriendUin", "lastSelectedFriend", "newStatusService", "Lcom/tencent/state/service/VasSquareNewStatusRedDotService;", "poiHandler", "Lcom/tencent/state/square/location/AvatarPoiHandler;", "publishHelper", "Lcom/tencent/state/square/detail/StatusPublishHelper;", "published", "recorder", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "reporter", "Lcom/tencent/state/square/IReporter;", "selectFriendCallback", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "selectedView", "Lcom/tencent/state/square/detail/DetailSelectMeView;", "afterOnCreateView", "", "changeMultiActionWithCheckFriendPermission", "uin", "motionId", "fromSelectFriend", "onCheckEnd", "Lkotlin/Function3;", "checkAndDoSchemeAction", "checkAndPublishMultiStatus", "onPublishAction", "Lkotlin/Function0;", "checkRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "data", "Lcom/tencent/state/square/data/OnlineStatus;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needRecord", "clickShareMultiPoster", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "doDressKeyChange", "isGenderChange", "doEndMultiStatus", "status", "onMultiStatusEnd", "doPublish", "customText", "doPublishStatus", "motion", "Lcom/tencent/state/square/data/BaseResourceInfo;", "doSendInvite", "doStatusChange", "isSuccess", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getDetailCommonPageInfo", "", "", "getDressKeys", "friendUin", "Lcom/tencent/state/square/data/DressKeys;", "getEventClass", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFragmentView", "Lcom/tencent/state/square/detail/IDetailParentView;", "getNewStatus", "getPageId", "getPoiInfo", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "getRecentList", "", "recentUins", "goToMall", "initInteractionUnRead", "view", "initInviteState", "initService", "onClickLockMotion", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "onConfigInteraction", "avatarItem", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetailBackPressed", "onDressKeyChange", "isMale", "onGetInviteDetail", "detail", "onInviteRequestFailed", "prompt", "defaultPrompt", "onPublishClick", "onReceiveEvent", "event", "onResult", "", "onSelectFriendClick", "onSetNewStatus", "redDotId", "onSharePosterClick", "onShowFailDialog", "onShowFailPrompt", "onStatusSelected", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/view/View;", "onVisibilityChanged", "isVisible", "from", "playAvatar", "recordAvatar", "friendGender", "Lcom/tencent/state/square/resource/IResourceCallback;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/OnlineStatus;Lcom/tencent/state/square/resource/IResourceCallback;)V", "recordAvatarCover", "refreshStatusPanel", "showInteractionRecordDialog", "topBarUrl", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeFragment extends DetailBaseSelectFragment<DetailMeFragmentConfig> implements DetailMeListener, ISquarePushListener, IDressKeyChangeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DetailSelectMeFragment";
    private Integer currentFriendGender;
    private String currentFriendUin;
    private SimpleEventBus eventBus;
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;
    private boolean isDressKeyChange;
    private boolean isEditorPage;
    private boolean isFirstSetFriendUin;
    private String lastSelectedFriend;
    private boolean published;
    private ISelectFriendCallback selectFriendCallback;
    private DetailSelectMeView selectedView;
    private final StatusPublishHelper publishHelper = new StatusPublishHelper();
    private final MeResourceRecorder recorder = new MeResourceRecorder();
    private final IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private AvatarPoiHandler poiHandler = new AvatarPoiHandler();
    private final VasSquareNewStatusRedDotService newStatusService = new VasSquareNewStatusRedDotService();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectMeFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/square/detail/DetailSelectMeFragment;", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "source", "Lcom/tencent/state/square/detail/EntranceSource;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final DetailSelectMeFragment newInstance(SquareAvatarItem data, EntranceSource source, BaseDetailFragmentConfig config) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(source, "source");
            DetailSelectMeFragment detailSelectMeFragment = new DetailSelectMeFragment();
            detailSelectMeFragment.setSquareItem(SquareAvatarItemKt.copyAvatarItem(data));
            detailSelectMeFragment.setEntranceSource(source);
            if (!(config instanceof DetailMeFragmentConfig)) {
                config = null;
            }
            detailSelectMeFragment.setEntranceConfig((DetailMeFragmentConfig) config);
            DetailMeFragmentConfig entranceConfig = detailSelectMeFragment.getEntranceConfig();
            detailSelectMeFragment.isEditorPage = entranceConfig != null ? entranceConfig.getAutoEnterEditState() : false;
            return detailSelectMeFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ DetailSelectMeFragment newInstance$default(Companion companion, SquareAvatarItem squareAvatarItem, EntranceSource entranceSource, BaseDetailFragmentConfig baseDetailFragmentConfig, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                baseDetailFragmentConfig = null;
            }
            return companion.newInstance(squareAvatarItem, entranceSource, baseDetailFragmentConfig);
        }
    }

    public DetailSelectMeFragment() {
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, DetailMeGetNoviceGuideConfigResultEvent.class, new Function1<DetailMeGetNoviceGuideConfigResultEvent, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailMeGetNoviceGuideConfigResultEvent detailMeGetNoviceGuideConfigResultEvent) {
                invoke2(detailMeGetNoviceGuideConfigResultEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final DetailMeGetNoviceGuideConfigResultEvent it) {
                DetailSelectMeView detailSelectMeView;
                Intrinsics.checkNotNullParameter(it, "it");
                detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView != null) {
                    detailSelectMeView.post(new Runnable() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DetailSelectMeView detailSelectMeView2;
                            detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                            if (detailSelectMeView2 != null) {
                                detailSelectMeView2.refreshCreateRoleRedDot(DetailSelectMeFragment.this.getActivity(), DetailSelectMeFragment.this, it.getRegistered(), it.getConfig());
                            }
                        }
                    });
                }
            }
        });
        EventBusUtilsKt.register(hashMap, SquareRolePageResultEvent.class, new Function1<SquareRolePageResultEvent, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareRolePageResultEvent squareRolePageResultEvent) {
                invoke2(squareRolePageResultEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SquareRolePageResultEvent it) {
                DetailSelectMeView detailSelectMeView;
                Intrinsics.checkNotNullParameter(it, "it");
                detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView != null) {
                    detailSelectMeView.post(new Runnable() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DetailSelectMeView detailSelectMeView2;
                            detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                            if (detailSelectMeView2 != null) {
                                detailSelectMeView2.syncRolePageResult(it.getRegistered());
                            }
                        }
                    });
                }
            }
        });
        EventBusUtilsKt.register(hashMap, UpdateBubbleSkinEvent.class, new DetailSelectMeFragment$$special$$inlined$apply$lambda$3(this));
        EventBusUtilsKt.register(hashMap, OpenTaskEvent.class, new Function1<OpenTaskEvent, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OpenTaskEvent openTaskEvent) {
                invoke2(openTaskEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OpenTaskEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DetailBaseSelectFragment.doBackToSquare$default(DetailSelectMeFragment.this, null, 1, null);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.eventMap = hashMap;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        simpleEventBus.registerReceiver(this);
        this.eventBus = simpleEventBus;
        this.lastSelectedFriend = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeMultiActionWithCheckFriendPermission(final String uin, final int motionId, final boolean fromSelectFriend, final Function3<? super Integer, ? super Boolean, ? super String, Unit> onCheckEnd) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            VasMultiMotionService.INSTANCE.checkInvitePermission(longOrNull.longValue(), motionId, new ResultCallback<InviteGender>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$changeMultiActionWithCheckFriendPermission$1
                private final SquareAvatarItem currentSquareItem() {
                    DetailSelectMeView detailSelectMeView;
                    detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView != null) {
                        return DetailSelectMeView.curSelectedAvatarItem$default(detailSelectMeView, false, 1, null);
                    }
                    return null;
                }

                private final boolean isSelectedFriendChange(String uin2, String targetUin) {
                    return !Intrinsics.areEqual(uin2, targetUin);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
                }

                /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
                
                    if (r9 == null) goto L30;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
                
                    r10 = java.lang.Integer.valueOf(r2);
                    r11 = java.lang.Boolean.FALSE;
                    r0 = new java.lang.StringBuilder();
                    r0.append("friend uin change, ");
                    r1 = r8.this$0.currentFriendUin;
                    r0.append(r1);
                    r9 = (kotlin.Unit) r9.invoke(r10, r11, r0.toString());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
                
                    if (isSelectedFriendChange(r0, r1) != false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
                
                    if (isTargetUinChange(r0, r1) == false) goto L11;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
                
                    r9 = r3;
                 */
                @Override // com.tencent.state.service.ResultCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResultFailure(int error, String message, String prompt) {
                    DetailSelectMeView detailSelectMeView;
                    Integer num;
                    String str;
                    String str2;
                    SquareAvatarItem currentSquareItem = currentSquareItem();
                    if (currentSquareItem != null && isSameMotionId(currentSquareItem, motionId)) {
                        if (!fromSelectFriend) {
                            String str3 = uin;
                            str2 = DetailSelectMeFragment.this.currentFriendUin;
                        }
                        if (fromSelectFriend) {
                            String str4 = uin;
                            str = DetailSelectMeFragment.this.lastSelectedFriend;
                        }
                        DetailSelectMeFragment.this.currentFriendUin = null;
                        DetailSelectMeFragment.this.currentFriendGender = null;
                        detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                        if (detailSelectMeView != null) {
                            num = DetailSelectMeFragment.this.currentFriendGender;
                            DetailSelectMeView.onFriendSelected$default(detailSelectMeView, null, false, num, 2, null);
                        }
                        DetailSelectMeFragment.this.onShowFailDialog(prompt, null);
                        Function3 function3 = onCheckEnd;
                        if (function3 != null) {
                            return;
                        }
                        return;
                    }
                    Function3 function32 = onCheckEnd;
                    if (function32 != null) {
                    }
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(InviteGender inviteGender) {
                    DetailSelectMeView detailSelectMeView;
                    DetailSelectMeView detailSelectMeView2;
                    Intrinsics.checkNotNullParameter(inviteGender, "inviteGender");
                    SquareAvatarItem currentSquareItem = currentSquareItem();
                    if (currentSquareItem != null && isSameMotionId(currentSquareItem, motionId)) {
                        DetailSelectMeFragment.this.currentFriendUin = uin;
                        DetailSelectMeFragment.this.currentFriendGender = Integer.valueOf(inviteGender.getReceiverGender());
                        DetailSelectMeFragment.this.recordAvatarCover(currentSquareItem.getUserResource());
                        detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                        if (detailSelectMeView != null) {
                            DetailSelectMeView.onFriendSelected$default(detailSelectMeView, uin, false, Integer.valueOf(inviteGender.getReceiverGender()), 2, null);
                        }
                        detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                        if (detailSelectMeView2 != null) {
                            DetailSelectMeView.recordAvatar$default(detailSelectMeView2, uin, Integer.valueOf(inviteGender.getReceiverGender()), currentSquareItem.getUserResource(), currentSquareItem.getExtra().getOnlineStatus(), false, null, 48, null);
                        }
                        Function3 function3 = onCheckEnd;
                        if (function3 != null) {
                            return;
                        }
                        return;
                    }
                    Function3 function32 = onCheckEnd;
                    if (function32 != null) {
                    }
                }

                private final boolean isSameMotionId(SquareAvatarItem item, int motionId2) {
                    Resource userResource;
                    return (item == null || (userResource = item.getUserResource()) == null || motionId2 != userResource.getActionId()) ? false : true;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                private final boolean isTargetUinChange(String uin2, String targetUin) {
                    boolean z16;
                    boolean isBlank;
                    if (targetUin != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(targetUin);
                        if (!isBlank) {
                            z16 = false;
                            if (z16) {
                                return !Intrinsics.areEqual(uin2, targetUin);
                            }
                            return false;
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
            });
        }
    }

    private final void checkAndPublishMultiStatus(Function0<Unit> onPublishAction) {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
            DetailDialogs.INSTANCE.checkAndPublishMultiStatus(context, 0, onPublishAction, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$checkAndPublishMultiStatus$1
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
                    DetailSelectMeView detailSelectMeView;
                    SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "user canceled publish multi action.");
                    detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView != null) {
                        detailSelectMeView.failPublish();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkRecord(Resource resource, final OnlineStatus data, final String uin, final Function1<? super Boolean, Unit> callback) {
        Long longOrNull;
        Long longOrNull2;
        List<Long> listOf;
        String selfUin = RecordIdentifier.INSTANCE.getSelfUin();
        SquareBaseKt.getSquareLog().i(TAG, "checkRecord: self=" + selfUin + " uin=" + uin);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(selfUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            if (longOrNull2 != null) {
                long longValue2 = longOrNull2.longValue();
                VasStatusSquareService vasStatusSquareService = VasStatusSquareService.INSTANCE;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(longValue), Long.valueOf(longValue2)});
                vasStatusSquareService.isMotionNeedRecord(resource, listOf, new ResultCallback<SquareJudgeRecordData>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$checkRecord$1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str, String str2) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        callback.invoke(Boolean.TRUE);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(SquareJudgeRecordData result) {
                        DetailSelectMeView detailSelectMeView;
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (result.isRecorded()) {
                            callback.invoke(Boolean.FALSE);
                            detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                            if (detailSelectMeView != null) {
                                DetailSelectMeView.doRecordSuccess$default(detailSelectMeView, new RecordRequest(result.getResource(), new RecordExtra(data, uin), 0, 4, null), false, 2, null);
                                return;
                            }
                            return;
                        }
                        callback.invoke(Boolean.TRUE);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDressKeyChange(boolean isGenderChange) {
        SquareAvatarItem squareItem;
        Resource resource;
        DetailSelectMeView detailSelectMeView;
        DetailSelectMeView detailSelectMeView2 = this.selectedView;
        Resource curResource = detailSelectMeView2 != null ? detailSelectMeView2.getCurResource() : null;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDressKeyChange, curActionId:");
        sb5.append(curResource != null ? Integer.valueOf(curResource.getActionId()) : null);
        squareLog.i(TAG, sb5.toString());
        DetailSelectMeView detailSelectMeView3 = this.selectedView;
        if (detailSelectMeView3 != null) {
            detailSelectMeView3.resetCurrentResource();
        }
        SquareBaseKt.getSquareLog().i(TAG, "onDressKeyChange dressKey:" + SquareRecordManager.INSTANCE.getDressKey());
        Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doDressKeyChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
            
                r1 = r3.this$0.selectedView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                Resource resource2;
                DetailSelectMeView detailSelectMeView4;
                DetailCommonView commonView;
                SquareAvatarItem squareItem2 = DetailSelectMeFragment.this.getSquareItem();
                if (squareItem2 == null || (resource2 = SquareResourceManagerKt.getResource(squareItem2)) == null || detailSelectMeView4 == null || (commonView = detailSelectMeView4.getCommonView()) == null) {
                    return;
                }
                commonView.updateAvatar(resource2, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doDressKeyChange$1$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        SquareAvatarItem squareItem2 = getSquareItem();
        if (squareItem2 != null && (detailSelectMeView = this.selectedView) != null) {
            DetailSelectMeView.recordAvatar$default(detailSelectMeView, null, null, curResource, squareItem2.getExtra().getOnlineStatus(), true, null, 32, null);
        }
        if (!isGenderChange || (squareItem = getSquareItem()) == null || (resource = SquareResourceManagerKt.getResource(squareItem)) == null) {
            return;
        }
        getEventBus().dispatchEvent(new DetailMeUpdateResourceEvent(resource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doEndMultiStatus(final SquareMultiMotionDetailData status, final Function0<Unit> onMultiStatusEnd) {
        SquareBaseKt.getSquareLog().i(TAG, "do end multi status: " + status.getBillNum());
        VasMultiMotionService.endInvite$default(VasMultiMotionService.INSTANCE, status.getBillNum(), 0, new ResultCallback<Resource>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doEndMultiStatus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                DetailSelectMeView detailSelectMeView;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "DetailSelectMeFragment", "do end multi status failed: " + status.getBillNum() + ", error=" + error + ", message=" + message, null, 4, null);
                DetailSelectMeFragment.this.onInviteRequestFailed(prompt, "\u7ec8\u6b62\u9080\u8bf7\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView != null) {
                    detailSelectMeView.failPublish();
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(Resource result) {
                DetailSelectMeView detailSelectMeView;
                SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "do end multi status success: " + status.getBillNum());
                status.setInviteStatus(2);
                detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView != null) {
                    detailSelectMeView.onInviteStateChanged(status);
                }
                onMultiStatusEnd.invoke();
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPublish(final OnlineStatus status, int motionId, String customText, final Function1<? super Boolean, Unit> callback) {
        SquareBaseKt.getSquareLog().d(TAG, "doPublish, status:" + status.getId() + ", motionId:" + motionId);
        StatusPublishHelper statusPublishHelper = this.publishHelper;
        Context context = getContext();
        AvatarPoiHandler avatarPoiHandler = this.poiHandler;
        statusPublishHelper.doPublish(context, status, motionId, customText, avatarPoiHandler != null ? avatarPoiHandler.getSelectPoi() : null, new Function1<StatusPublishHelper.PublishResult, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doPublish$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StatusPublishHelper.PublishResult publishResult) {
                invoke2(publishResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
            
                r4 = r3.this$0.selectedView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(StatusPublishHelper.PublishResult result) {
                DetailSelectMeView detailSelectMeView;
                DetailSelectMeView detailSelectMeView2;
                DetailSelectMeView detailSelectMeView3;
                Integer errCode;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getCode() != 0) {
                    detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView != null) {
                        detailSelectMeView.failPublish();
                    }
                    detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView2 != null) {
                        SquareErrorData data = result.getData();
                        detailSelectMeView2.reportPublish(false, (data == null || (errCode = data.getErrCode()) == null) ? -1 : errCode.intValue());
                    }
                    if (result.getCode() == 2 && detailSelectMeView3 != null) {
                        detailSelectMeView3.updateBubbleView(status);
                    }
                    Function1 function1 = callback;
                    if (function1 != null) {
                        return;
                    }
                    return;
                }
                DetailSelectMeFragment.this.doStatusChange(result.isStatusSuccess());
                Function1 function12 = callback;
                if (function12 != null) {
                }
            }
        });
    }

    private final void getNewStatus() {
        this.newStatusService.getNewStatus(new ResultCallback<NewStatusInfo>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$getNewStatus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(NewStatusInfo result) {
                boolean startsWith;
                DetailSelectMeView detailSelectMeView;
                DetailSelectMeView detailSelectMeView2;
                DetailSelectMeView detailSelectMeView3;
                DetailSelectMeView detailSelectMeView4;
                SquareOnlineStatusMultiActionPanelHelper multiActionPanelHelper;
                DetailSelectMeView detailSelectMeView5;
                NewStatusInfo newStatusInfo;
                DetailSelectMeView detailSelectMeView6;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getRedDotImg().length() > 0) {
                    startsWith = StringsKt__StringsJVMKt.startsWith(result.getRedDotImg(), "http", true);
                    if (!startsWith) {
                        detailSelectMeView6 = DetailSelectMeFragment.this.selectedView;
                        if (detailSelectMeView6 != null) {
                            detailSelectMeView6.reportNewStatusData("imp");
                            return;
                        }
                        return;
                    }
                    detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView != null) {
                        detailSelectMeView.setNewStatusInfo(result);
                    }
                    detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView2 != null && (multiActionPanelHelper = detailSelectMeView2.getMultiActionPanelHelper()) != null) {
                        detailSelectMeView5 = DetailSelectMeFragment.this.selectedView;
                        multiActionPanelHelper.setActionId((detailSelectMeView5 == null || (newStatusInfo = detailSelectMeView5.getNewStatusInfo()) == null) ? null : newStatusInfo.getMotionId());
                    }
                    detailSelectMeView3 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView3 != null) {
                        detailSelectMeView3.handleNewStatusUI(result.getRedDotImg());
                    }
                    detailSelectMeView4 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView4 != null) {
                        detailSelectMeView4.reportNewStatusData("imp");
                    }
                }
            }
        });
    }

    private final void initInteractionUnRead(final DetailSelectMeView view) {
        new InteractionRecordUnReadCaseForFragment(2, this, new Function1<InteractionUnreadInfo, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$initInteractionUnRead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractionUnreadInfo interactionUnreadInfo) {
                invoke2(interactionUnreadInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InteractionUnreadInfo info) {
                IReporter iReporter;
                Intrinsics.checkNotNullParameter(info, "info");
                FrameLayout mContainer = view.getInteractionRecordBinding().getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "view.getInteractionRecordBinding().root");
                SquareImageView squareImageView = view.getInteractionRecordBinding().interactionRecordUnreadPoint;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "view.getInteractionRecor\u2026eractionRecordUnreadPoint");
                if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, info.getUnReadIcon(), false, 2, null)) {
                    mContainer.setVisibility(8);
                    return;
                }
                view.getInteractionRecordBinding().interactionRecordIcon.setImageDrawable(URLDrawable.getDrawable(info.getUnReadIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
                if (mContainer.getVisibility() != 0) {
                    mContainer.setVisibility(0);
                    iReporter = DetailSelectMeFragment.this.reporter;
                    iReporter.reportEvent("imp", mContainer, new LinkedHashMap());
                }
                if (info.getUnReadNum() > 0) {
                    squareImageView.setVisibility(0);
                } else {
                    squareImageView.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInviteRequestFailed(String prompt, String defaultPrompt) {
        onShowFailPrompt(prompt, defaultPrompt);
        ISquareInviteManager inviter = getServiceProvider().getInviter();
        if (inviter != null) {
            inviter.getInviteStatus(true, getGetInviteStatusCallback());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShowFailDialog(String prompt, String defaultPrompt) {
        Context it = getContext();
        if (it != null) {
            String str = prompt == null || prompt.length() == 0 ? defaultPrompt : prompt;
            if (str != null) {
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareCommon.showDialog(it, str, "\u6211\u77e5\u9053\u4e86", (String) null, true, (Function0<Unit>) new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onShowFailDialog$1$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }

    private final void onShowFailPrompt(String prompt, String defaultPrompt) {
        Context it = getContext();
        if (it != null) {
            if (prompt == null || prompt.length() == 0) {
                prompt = defaultPrompt;
            }
            if (prompt != null) {
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareCommon.showToast(it, prompt, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordAvatarCover(final Resource resource) {
        final SquareAvatarItem squareItem;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("recordAvatarCover: ");
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        sb5.append(", ");
        sb5.append(this.currentFriendUin);
        squareLog.i(TAG, sb5.toString());
        if (resource == null || (squareItem = getSquareItem()) == null) {
            return;
        }
        if (resource.isMultiAction() && this.currentFriendUin == null) {
            return;
        }
        final String str = resource.isMultiAction() ? this.currentFriendUin : null;
        getDressKeys(str, new Function1<DressKeys, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$recordAvatarCover$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DressKeys dressKeys) {
                invoke2(dressKeys);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DressKeys dressKeys) {
                Resource copyResource;
                Intrinsics.checkNotNullParameter(dressKeys, "dressKeys");
                SquareBaseKt.getSquareLog().d("DetailSelectMeFragment", "doRecordAvatarCover, " + resource.getActionId() + ", " + str + ", dressKeys:" + dressKeys);
                SquareFilamentCoverComponent squareFilamentCoverComponent = (SquareFilamentCoverComponent) DetailSelectMeFragment.this.getComponent(SquareFilamentCoverComponent.class, null, null);
                if (squareFilamentCoverComponent != null) {
                    String filamentId = FilamentDataUtilsKt.getFilamentId(squareItem);
                    String uin = squareItem.getUin();
                    Resource resource2 = resource;
                    copyResource = SquareItemKt.copyResource(resource2, (r21 & 1) != 0 ? resource2.getActionId() : 0, (r21 & 2) != 0 ? resource2.getDynamic() : null, (r21 & 4) != 0 ? resource2.getStatic() : null, (r21 & 8) != 0 ? resource2.getShowSize() : null, (r21 & 16) != 0 ? resource2.getRecordSize() : null, (r21 & 32) != 0 ? resource2.getIsDefault() : false, (r21 & 64) != 0 ? resource2.getBubbleCoordinate() : null, (r21 & 128) != 0 ? resource2.getActionType() : 0, (r21 & 256) != 0 ? resource2.getActionStyle() : 0, (r21 & 512) != 0 ? resource2.getFilament() : FilamentResource.copy$default(resource2.getFilament(), null, null, dressKeys, null, 11, null));
                    squareFilamentCoverComponent.updateAvatarCover(filamentId, uin, copyResource, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInteractionRecordDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            final WeakReference weakReference = new WeakReference(this);
            new InteractionRecordDialog(activity, new Function2<Long, Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$showInteractionRecordDialog$dialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l3, Boolean bool) {
                    invoke(l3.longValue(), bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3, boolean z16) {
                    IDetailParentView fragmentView;
                    DetailCommonView commonView;
                    ISquareAvatarView avatarView;
                    DetailSelectMeFragment detailSelectMeFragment = (DetailSelectMeFragment) weakReference.get();
                    if (detailSelectMeFragment != null && (fragmentView = detailSelectMeFragment.getFragmentView()) != null && (commonView = fragmentView.getCommonView()) != null && (avatarView = commonView.getAvatarView()) != null) {
                        avatarView.setAlpha(0.0f);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(SquareConstants.LOCATE_TO_UIN, String.valueOf(j3));
                    bundle.putBoolean(SquareConstants.IS_IN_SQUARE, z16);
                    DetailSelectMeFragment detailSelectMeFragment2 = (DetailSelectMeFragment) weakReference.get();
                    if (detailSelectMeFragment2 != null) {
                        detailSelectMeFragment2.doBackToSquare(bundle);
                    }
                }
            }).show();
            SquareAvatarItem squareItem = getSquareItem();
            if (squareItem != null) {
                squareItem.getStickers().markReaded(StickerType.Interact);
                SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(squareItem.getUin(), squareItem.getStickers()));
            }
            DetailSelectMeView detailSelectMeView = this.selectedView;
            if (detailSelectMeView != null) {
                detailSelectMeView.bindLikeListBanner();
            }
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void afterOnCreateView() {
        Integer multiMotionId;
        VasSquareDetailMeViewBinding binding;
        PickFriendView pickFriendView;
        LinearLayout btn;
        DetailSelectMeView detailSelectMeView;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null && (detailSelectMeView = this.selectedView) != null) {
            detailSelectMeView.initView(getEntranceSource(), getEntranceConfig(), squareItem, this.isEditorPage, this);
        }
        DetailSelectMeView detailSelectMeView2 = this.selectedView;
        if (detailSelectMeView2 != null) {
            detailSelectMeView2.setPoiHandler(this.poiHandler);
        }
        DetailSelectMeView detailSelectMeView3 = this.selectedView;
        if (detailSelectMeView3 != null && (binding = detailSelectMeView3.getBinding()) != null && (pickFriendView = binding.selector) != null && (btn = pickFriendView.getBtn()) != null) {
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$afterOnCreateView$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DetailSelectMeView detailSelectMeView4;
                    DetailSelectMeView detailSelectMeView5;
                    DetailSelectMeView detailSelectMeView6;
                    DetailSelectMeView detailSelectMeView7;
                    VasSquareDetailMeViewBinding binding2;
                    PickFriendView pickFriendView2;
                    detailSelectMeView4 = DetailSelectMeFragment.this.selectedView;
                    String str = null;
                    Integer currentSelectedActionId = detailSelectMeView4 != null ? detailSelectMeView4.currentSelectedActionId() : null;
                    detailSelectMeView5 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView5 == null || !detailSelectMeView5.getPublishButTexToChoseFriend() || currentSelectedActionId == null) {
                        detailSelectMeView6 = DetailSelectMeFragment.this.selectedView;
                        if (detailSelectMeView6 == null || detailSelectMeView6.getPublishButTexToChoseFriend() || currentSelectedActionId == null) {
                            return;
                        }
                        DetailSelectMeFragment.this.onSelectFriendClick(currentSelectedActionId.intValue(), null);
                        return;
                    }
                    detailSelectMeView7 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView7 != null && (binding2 = detailSelectMeView7.getBinding()) != null && (pickFriendView2 = binding2.selector) != null) {
                        str = pickFriendView2.getFirstRecomUin();
                    }
                    DetailSelectMeFragment.this.onSelectFriendClick(currentSelectedActionId.intValue(), str);
                }
            });
        }
        final SquareStatusViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.getPanelInfo().observe(getViewLifecycleOwner(), new Observer<PanelInfo>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$afterOnCreateView$$inlined$apply$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(PanelInfo it) {
                    DetailSelectMeView detailSelectMeView4;
                    boolean z16;
                    detailSelectMeView4 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView4 != null) {
                        WeakReference<VasBaseFragment> weakReference = new WeakReference<>(DetailSelectMeFragment.this);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        detailSelectMeView4.initData(weakReference, it);
                    }
                    z16 = DetailSelectMeFragment.this.isDressKeyChange;
                    if (z16) {
                        DetailSelectMeFragment.this.doDressKeyChange(true);
                        DetailSelectMeFragment.this.isDressKeyChange = false;
                    }
                }
            });
            final SquareAvatarItem squareItem2 = getSquareItem();
            if (squareItem2 != null) {
                getRecentList(new Function1<List<? extends Long>, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$afterOnCreateView$$inlined$apply$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
                        invoke2((List<Long>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<Long> recentUins) {
                        Intrinsics.checkNotNullParameter(recentUins, "recentUins");
                        SquareStatusViewModel squareStatusViewModel = viewModel;
                        boolean isGenderMale = SquareAvatarItem.this.getIsGenderMale();
                        OnlineStatus onlineStatus = SquareAvatarItem.this.getExtra().getOnlineStatus();
                        int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : -1;
                        OnlineStatus onlineStatus2 = SquareAvatarItem.this.getExtra().getOnlineStatus();
                        squareStatusViewModel.loadStatusListData(isGenderMale, topStatusId, onlineStatus2 != null ? onlineStatus2.getRichStatus() : -1, recentUins);
                    }
                });
            }
        }
        initService();
        DetailMeFragmentConfig entranceConfig = getEntranceConfig();
        if (entranceConfig != null && (multiMotionId = entranceConfig.getMultiMotionId()) != null) {
            DetailMeListener.DefaultImpls.onSelectFriendClick$default(this, multiMotionId.intValue(), null, 2, null);
        }
        getMenuController().bindSquareView(getSquareItem());
        getNewStatus();
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void checkAndDoSchemeAction() {
        Context context;
        super.checkAndDoSchemeAction();
        DetailMeFragmentConfig entranceConfig = getEntranceConfig();
        if (entranceConfig != null) {
            if (entranceConfig.getOpenInteractionRecordPanel()) {
                showInteractionRecordDialog();
                return;
            }
            if (entranceConfig.getOpenSeedPanel()) {
                DetailFlowerComponent detailFlowerComponent = (DetailFlowerComponent) getComponent(DetailFlowerComponent.class, null, null);
                if (detailFlowerComponent != null) {
                    detailFlowerComponent.openFlowerFragment();
                    return;
                }
                return;
            }
            if (!entranceConfig.getOpenBubblePanel() || (context = getContext()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(context, "context");
            new BubbleSettingSheet(context).show();
        }
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void clickShareMultiPoster(SquareAvatarItem data, SquareMultiMotionDetailData inviteState) {
        showFragment(SquareMultiPosterFragment.INSTANCE.newInstance(data, inviteState));
    }

    public final void doStatusChange(final boolean isSuccess) {
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView != null) {
            DetailSelectMeView.reportPublish$default(detailSelectMeView, isSuccess, 0, 2, null);
        }
        Square.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doStatusChange$1
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
                DetailSelectMeView detailSelectMeView2;
                DetailSelectMeView detailSelectMeView3;
                DetailSelectMeView detailSelectMeView4;
                SquareAvatarItem curSelectedAvatarItem;
                Object firstOrNull;
                if (isSuccess) {
                    detailSelectMeView3 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView3 != null && (curSelectedAvatarItem = detailSelectMeView3.curSelectedAvatarItem(true)) != null) {
                        SimpleEventBus eventBus = DetailSelectMeFragment.this.getEventBus();
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) curSelectedAvatarItem.getActions());
                        eventBus.dispatchEvent(new DetailMeUpdateStatusEvent(new StatusUpdateData((AvatarAction) firstOrNull, curSelectedAvatarItem.getExtra().getOnlineStatus())));
                        DetailSelectMeFragment.this.setSquareItem(curSelectedAvatarItem);
                    }
                    Context it = DetailSelectMeFragment.this.getContext();
                    if (it != null) {
                        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        commonUtils.showToast(it, DetailSelectMeFragment.this.getResources().getString(R.string.xd7), 2);
                    }
                    detailSelectMeView4 = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView4 != null) {
                        detailSelectMeView4.updateDraftSp(true);
                    }
                    DetailBaseSelectFragment.doBackToSquare$default(DetailSelectMeFragment.this, null, 1, null);
                    return;
                }
                Context it5 = DetailSelectMeFragment.this.getContext();
                if (it5 != null) {
                    ICommonUtils commonUtils2 = Square.INSTANCE.getConfig().getCommonUtils();
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    commonUtils2.showToast(it5, DetailSelectMeFragment.this.getResources().getString(R.string.xd6), 1);
                }
                detailSelectMeView2 = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView2 != null) {
                    detailSelectMeView2.failPublish();
                }
            }
        });
        DetailSelectMeView detailSelectMeView2 = this.selectedView;
        if (detailSelectMeView2 != null) {
            detailSelectMeView2.onStatusChange(isSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List listOf;
        List<FragmentComponent> plus;
        List<FragmentComponent> components = super.getComponents();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new PerfMonitor(PerformanceReportConst.Param.EM_SCENE_HOST_STATUS, new WeakReference(getServiceProvider())), new DetailFlowerComponent(), new SquareBubbleSkinComponent(), new SquareFilamentCoverComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public Map<String, Object> getDetailCommonPageInfo() {
        NoviceGuideRecordForReport noviceGuideRecord;
        Map<String, Object> detailCommonPageInfo = super.getDetailCommonPageInfo();
        DetailMeFragmentConfig entranceConfig = getEntranceConfig();
        detailCommonPageInfo.put(SquareReportConst.Key.KEY_ZPLAN_DYNAMIC_TYPE, Integer.valueOf((entranceConfig == null || (noviceGuideRecord = entranceConfig.getNoviceGuideRecord()) == null) ? 0 : noviceGuideRecord.getDynamicType()));
        detailCommonPageInfo.put(SquareReportConst.Key.KEY_IS_FRIEND, 0);
        EntranceSource entranceSource = getEntranceSource();
        detailCommonPageInfo.put(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf((entranceSource != null ? Integer.valueOf(entranceSource.getReportSourceId()) : null).intValue()));
        return detailCommonPageInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public SimpleEventBus getEventBus() {
        return this.eventBus;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public IDetailParentView getFragmentView() {
        DetailSelectMeView detailSelectMeView;
        if (this.selectedView == null) {
            Context it = getContext();
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectMeView = new DetailSelectMeView(it);
                initInteractionUnRead(detailSelectMeView);
            } else {
                detailSelectMeView = null;
            }
            this.selectedView = detailSelectMeView;
            final WeakReference weakReference = new WeakReference(this);
            DetailSelectMeView detailSelectMeView2 = this.selectedView;
            if (detailSelectMeView2 != null) {
                detailSelectMeView2.setShowInteractionRecord(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$getFragmentView$2
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
                        DetailSelectMeFragment detailSelectMeFragment = (DetailSelectMeFragment) weakReference.get();
                        if (detailSelectMeFragment != null) {
                            detailSelectMeFragment.showInteractionRecordDialog();
                        }
                    }
                });
            }
            DetailSelectMeView detailSelectMeView3 = this.selectedView;
            if (detailSelectMeView3 != null) {
                DetailMeFragmentConfig entranceConfig = getEntranceConfig();
                Integer curStatusId = entranceConfig != null ? entranceConfig.getCurStatusId() : null;
                DetailMeFragmentConfig entranceConfig2 = getEntranceConfig();
                Integer curRichStatusId = entranceConfig2 != null ? entranceConfig2.getCurRichStatusId() : null;
                DetailMeFragmentConfig entranceConfig3 = getEntranceConfig();
                detailSelectMeView3.setSelectStatusId(curStatusId, curRichStatusId, entranceConfig3 != null ? entranceConfig3.getCurActionId() : null);
            }
        }
        return this.selectedView;
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_HOST_DETAIL;
    }

    public final void getPoiInfo(int requestCode, int resultCode, Intent data) {
        AvatarPoiHandler avatarPoiHandler = this.poiHandler;
        if (avatarPoiHandler != null) {
            avatarPoiHandler.getPoiInfo(requestCode, resultCode, data, new IPoiHandler() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$getPoiInfo$1
                @Override // com.tencent.state.square.location.IPoiHandler
                public void poiChange(AvatarLocationInfo locationInfo, boolean isChange) {
                    DetailSelectMeView detailSelectMeView;
                    Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
                    detailSelectMeView = DetailSelectMeFragment.this.selectedView;
                    if (detailSelectMeView != null) {
                        detailSelectMeView.updatePoiUI(locationInfo, isChange);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.square.detail.DetailCommonListener
    public void goToMall() {
        Context it = getContext();
        if (it != null) {
            IRouter router = Square.INSTANCE.getConfig().getRouter();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            router.routeToZplanPortal(it, BundleParamsUtils.INSTANCE.getMallBundle(), SquareReportConst.SubSource.SQUARE_HOST_PURCHASE_SOURCE);
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void initInviteState() {
        ISquareInviteManager inviter = getServiceProvider().getInviter();
        if (inviter != null) {
            inviter.getInviteStatus(true, getGetInviteStatusCallback());
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void initService() {
        this.publishHelper.init();
        ISquarePushService pushService = getServiceProvider().getPushService();
        if (pushService != null) {
            pushService.addListener(2, this);
        }
        SquareRecordManager.INSTANCE.setDressKeyChangeListener(this);
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onClickLockMotion(StatusLockInfo lockInfo) {
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.changeLockStatus(lockInfo);
        }
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SquareFilamentCoverComponent squareFilamentCoverComponent = (SquareFilamentCoverComponent) getComponent(SquareFilamentCoverComponent.class, null, null);
        if (squareFilamentCoverComponent != null) {
            squareFilamentCoverComponent.initialize();
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ISelectFriendCallback iSelectFriendCallback = this.selectFriendCallback;
        if (iSelectFriendCallback != null) {
            getServiceProvider().deleteSelectFriendCallback(iSelectFriendCallback);
        }
        SquareRecordManager.INSTANCE.removeDressKeyChangeListener(this);
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.destroy();
        }
        ISquarePushService pushService = getServiceProvider().getPushService();
        if (pushService != null) {
            pushService.removeListener(2, this);
        }
        this.publishHelper.destroy();
        this.recorder.onDestroy();
        getEventBus().dispatchEvent(new DetailMeBackEvent(this.poiHandler.copy(), this.published));
        getEventBus().unRegisterReceiver(this);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void onDetailBackPressed() {
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.updateDraftSp(false);
        }
    }

    @Override // com.tencent.state.square.api.IDressKeyChangeListener
    public void onDressKeyChange(boolean isMale) {
        SquareAvatarItem curSelectedAvatarItem$default;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null) {
            SquareBatteryStatusManager.INSTANCE.onDressKeyChange(squareItem.getUin(), isMale, SquareRecordManager.INSTANCE.getDressKey(), "detail_me");
        }
        SquareAvatarItem squareItem2 = getSquareItem();
        boolean z16 = squareItem2 == null || isMale != squareItem2.getIsGenderMale();
        SquareBaseKt.getSquareLog().i(TAG, "onDressKeyChange: " + z16);
        if (z16) {
            SquareAvatarItem squareItem3 = getSquareItem();
            if (squareItem3 != null) {
                squareItem3.updateGender(isMale);
            }
            DetailSelectMeView detailSelectMeView = this.selectedView;
            if (detailSelectMeView != null && (curSelectedAvatarItem$default = DetailSelectMeView.curSelectedAvatarItem$default(detailSelectMeView, false, 1, null)) != null) {
                curSelectedAvatarItem$default.updateGender(isMale);
            }
            DetailSelectMeView detailSelectMeView2 = this.selectedView;
            if (detailSelectMeView2 != null) {
                detailSelectMeView2.resetPanelView();
            }
            this.isDressKeyChange = true;
            refreshStatusPanel();
        } else {
            DetailSelectMeView detailSelectMeView3 = this.selectedView;
            if (detailSelectMeView3 != null) {
                detailSelectMeView3.resetAvatarAction();
            }
            doDressKeyChange(false);
        }
        SquareAvatarItem squareItem4 = getSquareItem();
        if (squareItem4 != null) {
            squareItem4.updateDressKey(SquareRecordManager.INSTANCE.getDressKey());
        }
        SquareAvatarItem squareItem5 = getSquareItem();
        recordAvatarCover(squareItem5 != null ? squareItem5.getUserResource() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void onGetInviteDetail(SquareMultiMotionDetailData detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (this.currentFriendUin == null && !this.isFirstSetFriendUin) {
            this.isFirstSetFriendUin = true;
            Long successOtherUin = detail.getSuccessOtherUin();
            String valueOf = successOtherUin != null ? String.valueOf(successOtherUin.longValue()) : null;
            this.currentFriendUin = valueOf;
            DetailSelectMeView detailSelectMeView = this.selectedView;
            if (detailSelectMeView != null) {
                DetailSelectMeView.onFriendSelected$default(detailSelectMeView, valueOf, true, null, 4, null);
            }
        }
        super.onGetInviteDetail(detail);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onPublishClick(final OnlineStatus data, final BaseResourceInfo motion, final String customText) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customText, "customText");
        if (motion != null && motion.getIsMultiAction()) {
            DetailSelectMeView detailSelectMeView = this.selectedView;
            Integer currentSelectedActionId = detailSelectMeView != null ? detailSelectMeView.currentSelectedActionId() : null;
            DetailSelectMeView detailSelectMeView2 = this.selectedView;
            if (detailSelectMeView2 != null && detailSelectMeView2.getPublishButTexToChoseFriend() && currentSelectedActionId != null) {
                onSelectFriendClick(currentSelectedActionId.intValue(), null);
            } else {
                checkAndPublishMultiStatus(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onPublishClick$1
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
                        ISquareInviteManager inviter = DetailSelectMeFragment.this.getServiceProvider().getInviter();
                        SquareMultiMotionDetailData currentStatus = inviter != null ? inviter.getCurrentStatus() : null;
                        if (currentStatus == null || !currentStatus.isInviteSuccess()) {
                            DetailSelectMeFragment.this.doPublishStatus(data, motion, customText);
                        } else {
                            DetailSelectMeFragment.this.doEndMultiStatus(currentStatus, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onPublishClick$1.1
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
                                    DetailSelectMeFragment$onPublishClick$1 detailSelectMeFragment$onPublishClick$1 = DetailSelectMeFragment$onPublishClick$1.this;
                                    DetailSelectMeFragment.this.doPublishStatus(data, motion, customText);
                                }
                            });
                        }
                    }
                });
            }
        } else {
            doPublishStatus(data, motion, customText);
        }
        SimpleEventBus.getInstance().dispatchEvent(new DetailGuestUpdateStickersEvent(RecordIdentifier.INSTANCE.getSelfUin(), Stickers.INSTANCE.parse(null)));
    }

    @Override // com.tencent.state.square.api.ISquarePushListener
    public void onResult(byte[] data) {
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        Intrinsics.checkNotNullParameter(data, "data");
        final SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null) {
            try {
                au4.a c16 = au4.a.c(data);
                StringFormatUtils stringFormatUtils = StringFormatUtils.INSTANCE;
                OnlineStatus onlineStatus2 = squareItem.getExtra().getOnlineStatus();
                String str = null;
                String formatString = stringFormatUtils.formatString(onlineStatus2 != null ? onlineStatus2.getCustomText() : null);
                DetailSelectMeView detailSelectMeView = this.selectedView;
                final SquareAvatarItem curSelectedAvatarItem = detailSelectMeView != null ? detailSelectMeView.curSelectedAvatarItem(false) : null;
                if (curSelectedAvatarItem != null && (extra = curSelectedAvatarItem.getExtra()) != null && (onlineStatus = extra.getOnlineStatus()) != null) {
                    str = onlineStatus.getCustomText();
                }
                String formatString2 = stringFormatUtils.formatString(str);
                if (!(formatString.length() > 0) || !Intrinsics.areEqual(c16.f26962c, d.c(formatString))) {
                    if (!(formatString2.length() > 0) || !Intrinsics.areEqual(c16.f26962c, d.c(formatString2))) {
                        return;
                    }
                }
                SquareBase.INSTANCE.getConfig().getThreadManager().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onResult$1
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

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
                    
                        r2 = r3.this$0.selectedView;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        SquareAvatarExtra extra2;
                        OnlineStatus onlineStatus3;
                        DetailSelectMeView detailSelectMeView2;
                        OnlineStatus onlineStatus4 = squareItem.getExtra().getOnlineStatus();
                        if (onlineStatus4 != null) {
                            onlineStatus4.setCustomText("");
                        }
                        OnlineStatus onlineStatus5 = squareItem.getExtra().getOnlineStatus();
                        if (onlineStatus5 != null && detailSelectMeView2 != null) {
                            detailSelectMeView2.updateBubbleView(onlineStatus5);
                        }
                        SquareAvatarItem squareAvatarItem = curSelectedAvatarItem;
                        if (squareAvatarItem == null || (extra2 = squareAvatarItem.getExtra()) == null || (onlineStatus3 = extra2.getOnlineStatus()) == null) {
                            return;
                        }
                        onlineStatus3.setCustomText("");
                    }
                });
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "CustomTextBeatNotice error", th5);
            }
        }
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onSetNewStatus(long redDotId) {
        VasSquareNewStatusRedDotService.setNewStatus$default(this.newStatusService, redDotId, null, 2, null);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.square.detail.DetailCommonListener
    public void onSharePosterClick() {
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.onSharePoster();
        }
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onStatusSelected(OnlineStatus data, BaseResourceInfo motion) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(motion, "motion");
        RecordResourceInfo displayResource$default = BaseResourceInfo.getDisplayResource$default(motion, getSquareItem(), null, null, null, 14, null);
        if (displayResource$default != null) {
            recordAvatarCover(displayResource$default.getResource());
            final String str = this.currentFriendUin;
            if (str == null || !motion.getIsMultiAction()) {
                return;
            }
            changeMultiActionWithCheckFriendPermission(str, displayResource$default.getResource().getActionId(), false, new Function3<Integer, Boolean, String, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onStatusSelected$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool, String str2) {
                    invoke(num.intValue(), bool.booleanValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, boolean z16, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "onStatusSelected, permission result: " + i3 + ", " + str + ", " + z16 + ", " + msg2);
                }
            });
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        forEachComponent(IDetailEventListener.class, null, null, new Function1<IDetailEventListener, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDetailEventListener iDetailEventListener) {
                invoke2(iDetailEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IDetailEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onFragmentEnter(DetailSelectMeFragment.this.getSquareItem());
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseLifecycleFragment
    public void onVisibilityChanged(boolean isVisible, String from) {
        DetailSelectMeView detailSelectMeView;
        Intrinsics.checkNotNullParameter(from, "from");
        super.onVisibilityChanged(isVisible, from);
        if (!isVisible || (detailSelectMeView = this.selectedView) == null) {
            return;
        }
        detailSelectMeView.showUnLockToast();
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void playAvatar(Resource resource, final Function1<? super Boolean, Unit> callback) {
        DetailCommonView commonView;
        SquareAvatarItem curSelectedAvatarItem$default;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DetailSelectMeView detailSelectMeView = this.selectedView;
        final Integer num = null;
        if (detailSelectMeView != null && (curSelectedAvatarItem$default = DetailSelectMeView.curSelectedAvatarItem$default(detailSelectMeView, false, 1, null)) != null) {
            num = SquareResourceManagerKt.getOnlineStatusId(curSelectedAvatarItem$default);
        }
        DetailSelectMeView detailSelectMeView2 = this.selectedView;
        if (detailSelectMeView2 == null || (commonView = detailSelectMeView2.getCommonView()) == null) {
            return;
        }
        commonView.updateAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$playAvatar$1
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
                DetailSelectMeView detailSelectMeView3;
                Context it;
                detailSelectMeView3 = DetailSelectMeFragment.this.selectedView;
                if (detailSelectMeView3 != null && detailSelectMeView3.isCurStatus(num, Boolean.TRUE) && Intrinsics.areEqual(bool, Boolean.FALSE) && (it = DetailSelectMeFragment.this.getContext()) != null) {
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    commonUtils.showToast(it, R.string.xe5, 1);
                }
                callback.invoke(bool);
            }
        });
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void refreshStatusPanel() {
        getRecentList(new Function1<List<? extends Long>, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$refreshStatusPanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
                invoke2((List<Long>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Long> recentUins) {
                SquareStatusViewModel viewModel;
                Intrinsics.checkNotNullParameter(recentUins, "recentUins");
                SquareAvatarItem squareItem = DetailSelectMeFragment.this.getSquareItem();
                if (squareItem == null || (viewModel = DetailSelectMeFragment.this.getViewModel()) == null) {
                    return;
                }
                boolean genGenderIsMale = SquareRecordManager.INSTANCE.genGenderIsMale();
                OnlineStatus onlineStatus = squareItem.getExtra().getOnlineStatus();
                int topStatusId = onlineStatus != null ? onlineStatus.getTopStatusId() : -1;
                OnlineStatus onlineStatus2 = squareItem.getExtra().getOnlineStatus();
                viewModel.loadStatusListData(genGenderIsMale, topStatusId, onlineStatus2 != null ? onlineStatus2.getRichStatus() : -1, recentUins);
            }
        });
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    protected void setEventBus(SimpleEventBus simpleEventBus) {
        this.eventBus = simpleEventBus;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public String topBarUrl() {
        SquareAvatarExtra extra;
        SquarePageBackgroundInfo detailBackgroundInfo;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem == null || (extra = squareItem.getExtra()) == null || (detailBackgroundInfo = extra.getDetailBackgroundInfo()) == null) {
            return null;
        }
        return detailBackgroundInfo.getTopUrl();
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    private final void getRecentList(final Function1<? super List<Long>, Unit> callback) {
        List emptyList;
        ISquareBaseMessageService messageService;
        SquareGroupServiceComponent squareGroupServiceComponent = (SquareGroupServiceComponent) getComponent(SquareGroupServiceComponent.class, null, null);
        if (squareGroupServiceComponent == null || (messageService = squareGroupServiceComponent.getMessageService()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        } else {
            ISquareBaseMessageService.DefaultImpls.getRecentMsgListSyncAioTable$default(messageService, 0, null, new Function1<List<? extends SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$getRecentList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends SquareBaseMessageRecord> msgs) {
                    int collectionSizeOrDefault;
                    Intrinsics.checkNotNullParameter(msgs, "msgs");
                    Function1 function1 = Function1.this;
                    List<? extends SquareBaseMessageRecord> list = msgs;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(Long.parseLong(((SquareBaseMessageRecord) it.next()).getUin())));
                    }
                    function1.invoke(arrayList);
                }
            }, 3, null);
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPublishStatus(OnlineStatus data, BaseResourceInfo motion, String customText) {
        if (motion != null && motion.getIsMultiAction()) {
            doSendInvite(data, motion, customText);
        } else {
            doPublish(data, motion != null ? motion.getMotionIdForPublish() : 0, customText, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$doPublishStatus$1
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
                    if (z16) {
                        DetailSelectMeFragment.this.published = true;
                        StatusReportHelper.INSTANCE.reportPublishSuccess(StatusReportHelper.PublishScene.SINGLE);
                    }
                }
            });
        }
    }

    private final void doSendInvite(OnlineStatus data, BaseResourceInfo motion, String customText) {
        RecordResourceInfo recordResourceInfo;
        Long longOrNull;
        Resource resource;
        String str = this.currentFriendUin;
        if (str == null) {
            Context it = getContext();
            if (it != null) {
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ICommonUtils.DefaultImpls.showToast$default(squareCommon, it, "\u672a\u9009\u62e9\u597d\u53cb", 0, 4, (Object) null);
            }
            DetailSelectMeView detailSelectMeView = this.selectedView;
            if (detailSelectMeView != null) {
                detailSelectMeView.failPublish();
                return;
            }
            return;
        }
        Integer num = null;
        if (motion != null) {
            SquareAvatarItem squareItem = getSquareItem();
            ISquareInviteManager inviter = getServiceProvider().getInviter();
            recordResourceInfo = BaseResourceInfo.getDisplayResource$default(motion, squareItem, inviter != null ? inviter.getCurrentStatus() : null, null, null, 12, null);
        } else {
            recordResourceInfo = null;
        }
        SquareBaseKt.getSquareLog().i(TAG, "doSendInvite: uin: " + str + ", action: " + recordResourceInfo);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (recordResourceInfo == null) {
                Context it5 = getContext();
                if (it5 != null) {
                    ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    ICommonUtils.DefaultImpls.showToast$default(squareCommon2, it5, "\u8be5\u72b6\u6001\u6ca1\u6709\u6709\u6548\u7684\u53cc\u4eba\u52a8\u4f5c\u7d20\u6750", 0, 4, (Object) null);
                }
                DetailSelectMeView detailSelectMeView2 = this.selectedView;
                if (detailSelectMeView2 != null) {
                    detailSelectMeView2.failPublish();
                    return;
                }
                return;
            }
            VasMultiMotionService vasMultiMotionService = VasMultiMotionService.INSTANCE;
            int actionId = recordResourceInfo.getResource().getActionId();
            RecordResourceInfo singleMotionResource = motion.getSingleMotionResource();
            if (singleMotionResource != null && (resource = singleMotionResource.getResource()) != null) {
                num = Integer.valueOf(resource.getActionId());
            }
            vasMultiMotionService.sendInviteArk(longValue, actionId, num, data, customText, new DetailSelectMeFragment$doSendInvite$3(this, data, motion, customText, recordResourceInfo, str));
        }
    }

    private final void getDressKeys(final String friendUin, final Function1<? super DressKeys, Unit> callback) {
        if (friendUin == null) {
            callback.invoke(new DressKeys(SquareRecordManager.INSTANCE.getDressKey(), ""));
        } else {
            SquareBase.INSTANCE.getConfig().getRecorder().requestUserDressKey(friendUin, new Function2<Boolean, String, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$getDressKeys$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, String dressKey) {
                    boolean isBlank;
                    Intrinsics.checkNotNullParameter(dressKey, "dressKey");
                    SquareBaseKt.getSquareLog().d("DetailSelectMeFragment", "requestDressKey uin:" + friendUin + " success:" + z16);
                    Function1 function1 = callback;
                    String dressKey2 = SquareRecordManager.INSTANCE.getDressKey();
                    isBlank = StringsKt__StringsJVMKt.isBlank(dressKey);
                    if (isBlank) {
                        dressKey = friendUin;
                    }
                    function1.invoke(new DressKeys(dressKey2, dressKey));
                }
            });
        }
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onConfigInteraction(SquareAvatarItem avatarItem) {
        if (avatarItem == null || !avatarItem.isMe()) {
            return;
        }
        InteractionSettingsDialog.INSTANCE.showDialog(new WeakReference<>(this), SquareAvatarItemKt.copyAvatarItem(avatarItem), new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onConfigInteraction$onShow$1
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
                DetailCommonView commonView;
                ISquareAvatarView avatarView;
                IDetailParentView fragmentView = DetailSelectMeFragment.this.getFragmentView();
                if (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
                    return;
                }
                avatarView.pause();
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onConfigInteraction$onDismiss$1
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
                DetailCommonView commonView;
                ISquareAvatarView avatarView;
                IDetailParentView fragmentView = DetailSelectMeFragment.this.getFragmentView();
                if (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
                    return;
                }
                avatarView.resume();
            }
        }, 3, getEntranceSource());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IEventHandler iEventHandler;
        if (event == null || (iEventHandler = this.eventMap.get(event.getClass())) == null) {
            return;
        }
        iEventHandler.handleEvent(event);
    }

    @Override // com.tencent.state.square.detail.DetailMeListener
    public void onSelectFriendClick(final int motionId, final String uin) {
        if (uin != null) {
            if ((uin.length() > 0) && (!Intrinsics.areEqual(uin, "null"))) {
                this.lastSelectedFriend = uin;
                changeMultiActionWithCheckFriendPermission(uin, motionId, true, new Function3<Integer, Boolean, String, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onSelectFriendClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool, String str) {
                        invoke(num.intValue(), bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, boolean z16, String msg2) {
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "onSelectFriendClick, has uin: " + i3 + ", " + uin + ", " + z16 + ", " + msg2);
                    }
                });
                return;
            }
        }
        ISelectFriendCallback iSelectFriendCallback = this.selectFriendCallback;
        if (iSelectFriendCallback != null) {
            getServiceProvider().deleteSelectFriendCallback(iSelectFriendCallback);
        }
        ISelectFriendCallback iSelectFriendCallback2 = new ISelectFriendCallback() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onSelectFriendClick$3
            @Override // com.tencent.state.square.invite.ISelectFriendCallback
            public void onSelectFriend(final String uin2, boolean isTroop) {
                Intrinsics.checkNotNullParameter(uin2, "uin");
                DetailSelectMeFragment.this.lastSelectedFriend = uin2;
                DetailSelectMeFragment.this.getServiceProvider().deleteSelectFriendCallback(this);
                DetailSelectMeFragment.this.changeMultiActionWithCheckFriendPermission(uin2, motionId, true, new Function3<Integer, Boolean, String, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$onSelectFriendClick$3$onSelectFriend$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool, String str) {
                        invoke(num.intValue(), bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, boolean z16, String msg2) {
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        SquareBaseKt.getSquareLog().i("DetailSelectMeFragment", "onSelectFriendClick, permission result: " + i3 + ", " + uin2 + ", " + z16 + ", " + msg2);
                    }
                });
            }
        };
        getServiceProvider().addSelectFriendCallback(iSelectFriendCallback2);
        Unit unit = Unit.INSTANCE;
        this.selectFriendCallback = iSelectFriendCallback2;
        ISquareBaseMessageService messageService = getServiceProvider().getMessageService();
        if (messageService != null) {
            messageService.openMiniSelectPage(this, 1002, false, false, "\u8054\u7cfb\u4eba");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void changeMultiActionWithCheckFriendPermission$default(DetailSelectMeFragment detailSelectMeFragment, String str, int i3, boolean z16, Function3 function3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            function3 = null;
        }
        detailSelectMeFragment.changeMultiActionWithCheckFriendPermission(str, i3, z16, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void doPublish$default(DetailSelectMeFragment detailSelectMeFragment, OnlineStatus onlineStatus, int i3, String str, Function1 function1, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            function1 = null;
        }
        detailSelectMeFragment.doPublish(onlineStatus, i3, str, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    @Override // com.tencent.state.square.detail.DetailMeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void recordAvatar(String friendUin, Integer friendGender, final Resource resource, final OnlineStatus status, final IResourceCallback callback) {
        String str;
        SquareMultiMotionDetailData currentStatus;
        Integer num;
        SquareMultiMotionDetailData currentStatus2;
        String str2 = friendUin;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("recordAvatar: ");
        sb5.append(resource != null ? Integer.valueOf(resource.getActionId()) : null);
        sb5.append(", ");
        sb5.append(friendUin);
        sb5.append(", ");
        sb5.append(friendGender);
        squareLog.i(TAG, sb5.toString());
        if (resource != null && resource.isMultiAction()) {
            ISquareInviteManager inviter = getServiceProvider().getInviter();
            if (str2 == null) {
                if (status != null) {
                    Long successOtherUin = (inviter == null || (currentStatus = inviter.getCurrentStatus()) == null) ? null : currentStatus.getSuccessOtherUin(status.getId());
                    if (successOtherUin != null) {
                        str2 = String.valueOf(successOtherUin.longValue());
                    }
                }
                str = null;
                if (friendGender == null) {
                    num = friendGender;
                } else if (status != null) {
                    num = (inviter == null || (currentStatus2 = inviter.getCurrentStatus()) == null) ? null : currentStatus2.getSuccessOtherGender(status.getId());
                } else {
                    num = null;
                }
                String currentAccountUin = Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
                SquareBaseKt.getSquareLog().i(TAG, "recordAvatar, fixed: " + resource.getActionId() + ", " + str + ", " + num + ", " + currentAccountUin);
                if (str == null && !Intrinsics.areEqual(currentAccountUin, str)) {
                    final String str3 = str;
                    final Integer num2 = num;
                    checkRecord(resource, status, str, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$recordAvatar$1
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
                            MeResourceRecorder meResourceRecorder;
                            List listOf;
                            if (z16) {
                                meResourceRecorder = DetailSelectMeFragment.this.recorder;
                                RecordRequest recordRequest = new RecordRequest(resource, new RecordExtra(status, str3), 0, 4, null);
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(new UserIdentifier(str3, num2));
                                MeResourceRecorder.startRecord$default(meResourceRecorder, recordRequest, (String) null, listOf, callback, 2, (Object) null);
                                return;
                            }
                            callback.onRecordStart(resource, false);
                        }
                    });
                    return;
                }
                callback.onRecordStart(resource, false);
                return;
            }
            str = str2;
            if (friendGender == null) {
            }
            String currentAccountUin2 = Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
            SquareBaseKt.getSquareLog().i(TAG, "recordAvatar, fixed: " + resource.getActionId() + ", " + str + ", " + num + ", " + currentAccountUin2);
            if (str == null) {
            }
            callback.onRecordStart(resource, false);
            return;
        }
        MeResourceRecorder.startRecord$default(this.recorder, new RecordRequest(resource, new RecordExtra(status, null), 0, 4, null), (String) null, (List) null, callback, 6, (Object) null);
    }
}
