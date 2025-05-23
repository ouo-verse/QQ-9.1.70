package com.tencent.timi.game.gift.impl.timi;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.gift.impl.timi.ReceiverAdapter;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sh2.c;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$GiftMsg;
import trpc.yes.common.UserProxyCmdOuterClass$TinyIdUinPair;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bf\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\f*\u0003\\ad\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001nBK\u0012\b\u0010;\u001a\u0004\u0018\u000108\u0012\u0006\u0010=\u001a\u00020\u0012\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\b\u0010D\u001a\u0004\u0018\u00010A\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010O\u001a\u00020M\u0012\u0006\u0010R\u001a\u00020\"\u00a2\u0006\u0004\bk\u0010lJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J$\u0010\u0018\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\tJ\u0016\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\tJ\u0006\u0010%\u001a\u00020\u0005J\u0014\u0010'\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019J\u0006\u0010(\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\tJ\u0012\u0010.\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0017\u00100\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b0\u00101J\u000e\u00102\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0006\u00103\u001a\u00020\u0005J\u0014\u00104\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020605H\u0016R\u0016\u0010;\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u000eR\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u0004\u0018\u00010A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010NR\u0014\u0010R\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010SR\u0016\u0010T\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010QR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010WR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010_R\u0014\u0010c\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010bR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010eR\u001c\u0010j\u001a\n g*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010i\u00a8\u0006o"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "H", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/timi/game/gift/impl/event/GiftPanelControlEvent;", "event", "J", "", "Lyh4/b;", "receiverInfoModelList", "", "r", "M", "tinyIdList", "Lkotlin/Function0;", "callback", "v", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "memberList", "w", "Lyh4/a;", "listener", "G", "isCertain", "B", "", "subSceneId", "I", "t", "receiverList", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "giftBannerViewHolder", UserInfo.SEX_FEMALE, "isSdkDestroy", ReportConstant.COSTREPORT_PREFIX, "onReceiveEvent", "tinyId", HippyTKDListViewAdapter.X, "(Ljava/lang/Long;)J", "L", "K", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "d", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "giftSdkProvider", "e", "roomId", "f", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUid", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter;", tl.h.F, "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter;", "receiverAdapter", "Lai4/d;", "i", "Lai4/d;", "receiverCore", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;", "giftLayerView", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;", "receiverSelectorView", "D", "Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "Z", "resourcePath", "isGiftPanelVisible", "Lsh2/c;", "Lsh2/c;", "giftPanelView", "Ltrpc/yes/common/UserProxyCmdOuterClass$TinyIdUinPair;", "Ljava/util/List;", "tinyPairList", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$f", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$f;", "receiverUpdateCallback", "Lyh4/a;", "onSelectGiftToUserListener", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$d", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$d;", "msgListener", "com/tencent/timi/game/gift/impl/timi/TimiGiftController$e", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController$e;", "panelEventListener", "kotlin.jvm.PlatformType", "y", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "myUid", "<init>", "(Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;JLtrpc/yes/common/CommonOuterClass$QQUserId;Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter;Lai4/d;Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;Lcom/tencent/timi/game/gift/impl/timi/ReceiverSelectorView;Ljava/lang/String;)V", "N", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGiftController implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ReceiverSelectorView receiverSelectorView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCertain;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String resourcePath;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isGiftPanelVisible;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private sh2.c giftPanelView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private List<UserProxyCmdOuterClass$TinyIdUinPair> tinyPairList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final f receiverUpdateCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private yh4.a onSelectGiftToUserListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final d msgListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final e panelEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GiftSdkProvider giftSdkProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommonOuterClass$QQUserId selfUid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ReceiverAdapter receiverAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ai4.d receiverCore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TimiGiftLayerView giftLayerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$a", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter$b;", "Lyh4/b;", "receiverInfo", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ReceiverAdapter.b {
        a() {
        }

        @Override // com.tencent.timi.game.gift.impl.timi.ReceiverAdapter.b
        public void a(@NotNull ReceiverInfoModel receiverInfo) {
            Intrinsics.checkNotNullParameter(receiverInfo, "receiverInfo");
            TimiGiftController.this.receiverCore.b(receiverInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$c", "Lcom/tencent/timi/game/utils/IResultListener;", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$TinyIdUinPair;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<List<? extends UserProxyCmdOuterClass$TinyIdUinPair>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f377109b;

        c(Function0<Unit> function0) {
            this.f377109b = function0;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable List<UserProxyCmdOuterClass$TinyIdUinPair> result) {
            Long l3;
            UserProxyCmdOuterClass$TinyIdUinPair userProxyCmdOuterClass$TinyIdUinPair;
            PBUInt64Field pBUInt64Field;
            if (result != null && (userProxyCmdOuterClass$TinyIdUinPair = result.get(0)) != null && (pBUInt64Field = userProxyCmdOuterClass$TinyIdUinPair.uid) != null) {
                l3 = Long.valueOf(pBUInt64Field.get());
            } else {
                l3 = null;
            }
            com.tencent.timi.game.utils.l.i("TimiGiftPresenter", "getUinByTinyId success : " + l3);
            if (result != null && result.size() >= 1) {
                TimiGiftController.this.tinyPairList = result;
                this.f377109b.invoke();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "getUinByTinyId failed : errorCode == " + errorCode + ", errorMessage == " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$d", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "e", tl.h.F, "d", "b", "", "code", "", "desc", "f", "c", "msgId", "a", "", "historyMessages", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements com.tencent.timi.game.tim.api.message.b {
        d() {
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void a(@NotNull String msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0206, code lost:
        
            if (r1 == false) goto L54;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:36:0x022f A[RETURN] */
        @Override // com.tencent.timi.game.tim.api.message.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Object m476constructorimpl;
            IUserInfo iUserInfo;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b e16;
            byte b16;
            PBUInt64Field pBUInt64Field;
            byte b17;
            PBUInt64Field pBUInt64Field2;
            Object m476constructorimpl2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.type() == 48) {
                MessageOuterClass$GiftMsg messageOuterClass$GiftMsg = msg2.a().gift_msg.get();
                if (msg2.b() && messageOuterClass$GiftMsg.send_user_id_list.isEmpty()) {
                    return;
                }
                TimiGiftController timiGiftController = TimiGiftController.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, timiGiftController.sceneId);
                    com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
                    aVar.f264910a = messageOuterClass$GiftMsg.gift_id.get();
                    aVar.f264913d = messageOuterClass$GiftMsg.gift_name.get();
                    IUserInfo iUserInfo2 = null;
                    Object obj = null;
                    boolean z16 = true;
                    if (messageOuterClass$GiftMsg.send_user_id_list.isEmpty()) {
                        aVar.f264911b = messageOuterClass$GiftMsg.gift_type.get();
                        try {
                            m476constructorimpl2 = Result.m476constructorimpl(new JSONObject(messageOuterClass$GiftMsg.client_str.get()));
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        if (!Result.m482isFailureimpl(m476constructorimpl2)) {
                            obj = m476constructorimpl2;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            aVar.f264914e = jSONObject.getInt("material_id");
                            aVar.f264915f = messageOuterClass$GiftMsg.total_num.get();
                            aVar.f264918i = msg2.c().uid.get();
                            aVar.f264919j = jSONObject.getString("sender_nick");
                            aVar.f264922m = jSONObject.getString("sender_avatar");
                            aVar.f264921l = jSONObject.getString("receiver_nick");
                            aVar.f264923n = jSONObject.getString("receiver_avatar");
                            aVar.f264924o = jSONObject.getInt("effect_level");
                            aVar.f264925p = jSONObject.getLong("combo_seq");
                            aVar.f264926q = messageOuterClass$GiftMsg.combo_cnt.get();
                        }
                    } else {
                        CommonOuterClass$QQUserId receiverUid = messageOuterClass$GiftMsg.recv_user_id.get();
                        CommonOuterClass$QQUserId c16 = msg2.c();
                        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
                        Intrinsics.checkNotNullExpressionValue(receiverUid, "receiverUid");
                        LoadDataWrapper<? extends IUserInfo> value = dVar.w2(receiverUid).getValue();
                        if (value != null) {
                            iUserInfo = value.b();
                        } else {
                            iUserInfo = null;
                        }
                        LoadDataWrapper<? extends IUserInfo> value2 = ((bo4.d) mm4.b.b(bo4.d.class)).w2(c16).getValue();
                        if (value2 != null) {
                            iUserInfo2 = value2.b();
                        }
                        if (iUserInfo != null && iUserInfo2 != null) {
                            aVar.f264911b = 1;
                            aVar.f264914e = messageOuterClass$GiftMsg.gift_material_id.get();
                            aVar.f264915f = messageOuterClass$GiftMsg.total_num.get();
                            aVar.f264918i = c16.uid.get();
                            if (messageOuterClass$GiftMsg.send_user_id_list.size() > 1) {
                                aVar.f264919j = iUserInfo2.i(c16) + "\u7b49" + messageOuterClass$GiftMsg.send_user_id_list.size() + "\u4eba...";
                            } else {
                                aVar.f264919j = iUserInfo2.i(c16);
                            }
                            aVar.f264922m = iUserInfo2.f(c16);
                            aVar.f264921l = iUserInfo.i(receiverUid);
                            aVar.f264923n = iUserInfo.f(receiverUid);
                            aVar.f264924o = 0;
                            aVar.f264925p = messageOuterClass$GiftMsg.combo_seq.get();
                            aVar.f264926q = messageOuterClass$GiftMsg.total_num.get();
                        }
                        return;
                    }
                    gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(timiGiftController.roomId);
                    if (K0.Y().yolo_room_community_conf.wuji_yolo_room_community_conf.has() && !K0.Y().yolo_room_community_conf.wuji_yolo_room_community_conf.get().is_show_third_part_gift.get()) {
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId = messageOuterClass$GiftMsg.recv_user_id;
                        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "giftMsg.recv_user_id");
                        CommonOuterClass$QQUserId y16 = timiGiftController.y();
                        if (commonOuterClass$QQUserId.uid.get() != 0) {
                            if (y16 != null && (pBUInt64Field2 = y16.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field2.get()) {
                                b17 = true;
                            } else {
                                b17 = false;
                            }
                        }
                        if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
                            if (y16 != null && (pBUInt64Field = y16.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field.get()) {
                                b16 = true;
                            } else {
                                b16 = false;
                            }
                            if (b16 != false) {
                                if (!z16) {
                                    return;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    GiftSdkProvider giftSdkProvider = timiGiftController.giftSdkProvider;
                    if (giftSdkProvider != null && (e16 = giftSdkProvider.e()) != null) {
                        e16.d(aVar);
                    }
                    timiGiftController.giftLayerView.g();
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th6) {
                    Result.Companion companion3 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "new gift msg: " + Result.m479exceptionOrNullimpl(m476constructorimpl));
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void d(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int code, @Nullable String desc) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void g(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> historyMessages) {
            Intrinsics.checkNotNullParameter(historyMessages, "historyMessages");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$f", "Lai4/f;", "", "Lyh4/b;", "receiverList", "", "noAnimate", "", "onUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements ai4.f {
        f() {
        }

        @Override // ai4.f
        public void onUpdate(@NotNull List<ReceiverInfoModel> receiverList, boolean noAnimate) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(receiverList, "receiverList");
            ReceiverAdapter receiverAdapter = TimiGiftController.this.receiverAdapter;
            if (receiverAdapter != null) {
                receiverAdapter.k0(receiverList);
            }
            yh4.a aVar = TimiGiftController.this.onSelectGiftToUserListener;
            if (aVar != null) {
                List<ReceiverInfoModel> a16 = TimiGiftController.this.receiverCore.a();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = a16.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ReceiverInfoModel) it.next()).getUid());
                }
                aVar.a(arrayList, TimiGiftController.this.resourcePath);
            }
            sh2.c cVar = TimiGiftController.this.giftPanelView;
            if (cVar != null) {
                cVar.q(true);
            }
        }
    }

    public TimiGiftController(@Nullable GiftSdkProvider giftSdkProvider, long j3, @NotNull CommonOuterClass$QQUserId selfUid, @Nullable ReceiverAdapter receiverAdapter, @NotNull ai4.d receiverCore, @NotNull TimiGiftLayerView giftLayerView, @NotNull ReceiverSelectorView receiverSelectorView, @NotNull String sceneId) {
        Intrinsics.checkNotNullParameter(selfUid, "selfUid");
        Intrinsics.checkNotNullParameter(receiverCore, "receiverCore");
        Intrinsics.checkNotNullParameter(giftLayerView, "giftLayerView");
        Intrinsics.checkNotNullParameter(receiverSelectorView, "receiverSelectorView");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        this.giftSdkProvider = giftSdkProvider;
        this.roomId = j3;
        this.selfUid = selfUid;
        this.receiverAdapter = receiverAdapter;
        this.receiverCore = receiverCore;
        this.giftLayerView = giftLayerView;
        this.receiverSelectorView = receiverSelectorView;
        this.sceneId = sceneId;
        if (receiverAdapter != null) {
            receiverAdapter.p0(1);
        }
        this.resourcePath = "";
        f fVar = new f();
        this.receiverUpdateCallback = fVar;
        d dVar = new d();
        this.msgListener = dVar;
        this.panelEventListener = new e();
        receiverCore.c(fVar);
        if (receiverAdapter != null) {
            receiverAdapter.o0(new a());
        }
        ((kn4.b) mm4.b.b(kn4.b.class)).M(this.roomId).b(dVar);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.timi.game.gift.impl.timi.c.f377140a.b(zf4.c.f452468a.f(this.roomId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TimiGiftController this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j3 = this$0.roomId;
        GiftPanelControlEvent giftPanelControlEvent = (GiftPanelControlEvent) simpleBaseEvent;
        Long roomId = giftPanelControlEvent.getRoomId();
        if (roomId == null || j3 != roomId.longValue()) {
            return;
        }
        if (this$0.z()) {
            this$0.J(giftPanelControlEvent);
        } else {
            this$0.L(giftPanelControlEvent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r11 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(new yh4.ReceiverInfoModel(r11, 0, "", false, true, false, 40, null));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H(CommonOuterClass$QQUserId uid) {
        List<ReceiverInfoModel> emptyList;
        if (uid == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        E(emptyList);
    }

    private final void J(final GiftPanelControlEvent event) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        IUserInfo iUserInfo;
        CommonOuterClass$QQUserId chosenUid = event.getChosenUid();
        IUserInfo iUserInfo2 = null;
        if (chosenUid != null) {
            commonOuterClass$QQUserId = chosenUid.get();
        } else {
            commonOuterClass$QQUserId = null;
        }
        if (commonOuterClass$QQUserId == null) {
            return;
        }
        LoadDataWrapper<? extends IUserInfo> value = ((bo4.d) mm4.b.b(bo4.d.class)).w2(commonOuterClass$QQUserId).getValue();
        if (value != null) {
            iUserInfo = value.b();
        } else {
            iUserInfo = null;
        }
        LoadDataWrapper<? extends IUserInfo> value2 = ((bo4.d) mm4.b.b(bo4.d.class)).w2(this.selfUid).getValue();
        if (value2 != null) {
            iUserInfo2 = value2.b();
        }
        if (iUserInfo != null && iUserInfo2 != null) {
            ArrayList arrayList = new ArrayList();
            bo4.e d16 = iUserInfo.d();
            if (d16 != null) {
                arrayList.add(Long.valueOf(d16.b()));
            }
            bo4.e d17 = iUserInfo2.d();
            if (d17 != null) {
                arrayList.add(Long.valueOf(d17.b()));
            }
            v(arrayList, new Function0<Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.TimiGiftController$showGiftPanelFromNearBy$3
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
                    TimiGiftController.this.L(event);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(List<ReceiverInfoModel> receiverInfoModelList) {
        E(receiverInfoModelList);
        I("0", false);
    }

    private final List<Long> r(List<ReceiverInfoModel> receiverInfoModelList) {
        IUserInfo iUserInfo;
        bo4.e d16;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = receiverInfoModelList.iterator();
        while (it.hasNext()) {
            LoadDataWrapper<? extends IUserInfo> value = ((bo4.d) mm4.b.b(bo4.d.class)).w2(((ReceiverInfoModel) it.next()).getUid()).getValue();
            if (value != null) {
                iUserInfo = value.b();
            } else {
                iUserInfo = null;
            }
            if (iUserInfo != null && (d16 = iUserInfo.d()) != null) {
                arrayList.add(Long.valueOf(d16.b()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x007e, code lost:
    
        if (r11 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(com.tencent.mobileqq.qqgift.data.service.d data) {
        Object obj;
        Object orNull;
        CommonOuterClass$QQUserId uid;
        IUserInfo b16;
        IUserInfo b17;
        IUserInfo iUserInfo;
        oh2.b bVar;
        Long l3;
        Long l16;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        List<ReceiverInfoModel> a16 = this.receiverCore.a();
        if (a16.isEmpty()) {
            com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "none selected receiver");
            return true;
        }
        Iterator<T> it = a16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                CommonOuterClass$QQUserId uid2 = ((ReceiverInfoModel) obj).getUid();
                CommonOuterClass$QQUserId y16 = y();
                if (uid2.uid.get() != 0) {
                    if (y16 != null && (pBUInt64Field2 = y16.uid) != null && uid2.uid.get() == pBUInt64Field2.get()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                if (uid2.yes_uid.get() != 0) {
                    if (y16 != null && (pBUInt64Field = y16.yes_uid) != null && uid2.yes_uid.get() == pBUInt64Field.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                boolean z18 = false;
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(a16, 0);
            ReceiverInfoModel receiverInfoModel = (ReceiverInfoModel) orNull;
            if (receiverInfoModel == null || (uid = receiverInfoModel.getUid()) == null) {
                return true;
            }
            LoadDataWrapper<? extends IUserInfo> value = ((bo4.d) mm4.b.b(bo4.d.class)).w2(uid).getValue();
            if (value == null || (b16 = value.b()) == null) {
                return true;
            }
            LoadDataWrapper<? extends IUserInfo> value2 = ((bo4.d) mm4.b.b(bo4.d.class)).w2(this.selfUid).getValue();
            if (value2 == null || (b17 = value2.b()) == null) {
                return true;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            data.M = linkedHashMap;
            linkedHashMap.put("sender_nick", b17.i(this.selfUid));
            linkedHashMap.put("sender_avatar", b17.f(this.selfUid));
            linkedHashMap.put("receiver_nick", b16.i(uid));
            linkedHashMap.put("receiver_avatar", b16.f(uid));
            linkedHashMap.put("receiver_uin", String.valueOf(uid.uid.get()));
            com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
            if (z()) {
                bo4.e d16 = b17.d();
                if (d16 != null) {
                    l3 = Long.valueOf(d16.b());
                } else {
                    l3 = null;
                }
                cVar.f264860a = x(l3);
                bo4.e d17 = b16.d();
                if (d17 != null) {
                    l16 = Long.valueOf(d17.b());
                } else {
                    l16 = null;
                }
                long x16 = x(l16);
                cVar.f264861b = x16;
                iUserInfo = b16;
                if (cVar.f264860a == 0 || x16 == 0) {
                    com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "can not find uin by tiny id");
                    return true;
                }
            } else {
                iUserInfo = b16;
                cVar.f264860a = this.selfUid.uid.get();
                cVar.f264861b = uid.uid.get();
            }
            ConcurrentHashMap<String, String> concurrentHashMap = cVar.f264870k;
            concurrentHashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.roomId));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sender_user_from", this.selfUid.user_from.get());
            jSONObject.put("sender_guild_id", this.selfUid.guild_id.get());
            jSONObject.put("sender_nick", b17.i(this.selfUid));
            jSONObject.put("sender_avatar", b17.f(this.selfUid));
            jSONObject.put("receiver_user_from", uid.user_from.get());
            jSONObject.put("receiver_guild_id", uid.guild_id.get());
            IUserInfo iUserInfo2 = iUserInfo;
            jSONObject.put("receiver_nick", iUserInfo2.i(uid));
            jSONObject.put("receiver_avatar", iUserInfo2.f(uid));
            jSONObject.put("gift_name", data.f264876e);
            jSONObject.put("material_id", data.C);
            jSONObject.put("effect_level", data.f264883i);
            jSONObject.put("combo_seq", data.H);
            concurrentHashMap.put("client_str", jSONObject.toString());
            concurrentHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, String.valueOf(uid.user_from.get()));
            concurrentHashMap.put("guild_id", String.valueOf(uid.guild_id.get()));
            GiftSdkProvider giftSdkProvider = this.giftSdkProvider;
            if (giftSdkProvider != null) {
                bVar = giftSdkProvider.getGiftServerModule();
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.Q(cVar);
                return false;
            }
            return false;
        }
        com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "can not select self");
        com.tencent.timi.game.ui.widget.f.c("\u4e0d\u80fd\u7ed9\u81ea\u5df1\u8d60\u9001\u793c\u7269\u54df");
        return true;
    }

    private final void v(List<Long> tinyIdList, Function0<Unit> callback) {
        if (tinyIdList.size() == 0) {
            return;
        }
        go4.b.a(tinyIdList, new c(callback));
    }

    private final List<ReceiverInfoModel> w(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> memberList) {
        ArrayList arrayList = new ArrayList();
        int size = memberList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (memberList.get(i3).user_id.yes_uid.get() != 0) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = memberList.get(i3).user_id.get();
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "memberList[i].user_id.get()");
                arrayList.add(new ReceiverInfoModel(commonOuterClass$QQUserId, i3, "", false, false, false, 56, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonOuterClass$QQUserId y() {
        return ((ll4.a) mm4.b.b(ll4.a.class)).E();
    }

    private final boolean z() {
        if (this.selfUid.user_from.get() == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: A, reason: from getter */
    public final boolean getIsGiftPanelVisible() {
        return this.isGiftPanelVisible;
    }

    public final void B(boolean isCertain) {
        this.isGiftPanelVisible = true;
        this.isCertain = isCertain;
    }

    public final void C(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> memberList) {
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        final List<ReceiverInfoModel> w3 = w(memberList);
        List<Long> r16 = r(w3);
        if (z()) {
            v(r16, new Function0<Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.TimiGiftController$notifyGiftMemberChanged$1
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
                    TimiGiftController.this.E(w3);
                }
            });
        } else {
            E(w3);
        }
    }

    public final void E(@NotNull List<ReceiverInfoModel> receiverList) {
        Object orNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(receiverList, "receiverList");
        if (!this.isGiftPanelVisible) {
            return;
        }
        if (this.isCertain) {
            if (receiverList.size() <= 1) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(receiverList, 0);
                ReceiverInfoModel receiverInfoModel = (ReceiverInfoModel) orNull;
                if (receiverInfoModel != null && receiverInfoModel.getIsCertain()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
            } else {
                return;
            }
        }
        if (receiverList.size() == 1 && receiverList.get(0).getIsCertain()) {
            this.receiverSelectorView.setCertainReceiverNameVisibility(true);
            this.receiverSelectorView.setCertainReceiverName(receiverList.get(0).getUid());
        } else {
            this.receiverSelectorView.setCertainReceiverNameVisibility(false);
        }
        this.receiverCore.d(receiverList, false);
    }

    public final void F(@NotNull View giftBannerViewHolder) {
        Intrinsics.checkNotNullParameter(giftBannerViewHolder, "giftBannerViewHolder");
        this.giftLayerView.setGiftBannerViewHolder(giftBannerViewHolder);
    }

    public final void G(@NotNull yh4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectGiftToUserListener = listener;
    }

    public final void I(@NotNull String subSceneId, boolean isCertain) {
        sh2.c cVar;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(subSceneId, "subSceneId");
        GiftSdkProvider giftSdkProvider = this.giftSdkProvider;
        c.f fVar = null;
        if (giftSdkProvider != null) {
            cVar = giftSdkProvider.d();
        } else {
            cVar = null;
        }
        this.giftPanelView = cVar;
        if (cVar != null) {
            if (cVar != null) {
                fVar = cVar.l(this.panelEventListener);
            }
            cVar.setPanelEventListener(fVar);
        }
        ViewParent parent = this.receiverSelectorView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.receiverSelectorView);
        }
        sh2.c cVar2 = this.giftPanelView;
        if (cVar2 != null) {
            LinearLayout listHeaderView = cVar2.k();
            if (listHeaderView != null) {
                Intrinsics.checkNotNullExpressionValue(listHeaderView, "listHeaderView");
                cVar2.k().setPadding(listHeaderView.getPaddingLeft(), 0, listHeaderView.getPaddingRight(), listHeaderView.getPaddingBottom());
                listHeaderView.addView(this.receiverSelectorView, new ViewGroup.LayoutParams(-1, -2));
            }
            com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.a();
            aVar.f264935b = String.valueOf(this.selfUid.uid.get());
            aVar.f264937d = String.valueOf(this.roomId);
            aVar.f264942i = this.sceneId;
            aVar.f264943j = subSceneId;
            List<ReceiverInfoModel> a16 = this.receiverCore.a();
            if (a16.size() == 1 && a16.get(0).getIsCertain()) {
                aVar.f264936c = String.valueOf(a16.get(0).getUid().uid.get());
            }
            cVar2.setDtParams(aVar);
            cVar2.p(this.giftLayerView);
            yh4.a aVar2 = this.onSelectGiftToUserListener;
            if (aVar2 != null) {
                List<ReceiverInfoModel> a17 = this.receiverCore.a();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = a17.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ReceiverInfoModel) it.next()).getUid());
                }
                aVar2.a(arrayList, this.resourcePath);
            }
            this.giftLayerView.setGiftPanelView(cVar2.getContentView());
        }
    }

    public final void K() {
        B(false);
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> memberList = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).n();
        Intrinsics.checkNotNullExpressionValue(memberList, "memberList");
        final List<ReceiverInfoModel> w3 = w(memberList);
        if (z()) {
            v(r(w3), new Function0<Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.TimiGiftController$showGiftPanelMultiReceiver$1
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
                    TimiGiftController.this.M(w3);
                }
            });
        } else {
            M(w3);
        }
    }

    public final void L(@NotNull GiftPanelControlEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getShow()) {
            B(true);
            H(event.getChosenUid());
            I(event.getSubSceneId(), true);
            return;
        }
        t();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(GiftPanelControlEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        if (event instanceof GiftPanelControlEvent) {
            w.c(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.g
                @Override // java.lang.Runnable
                public final void run() {
                    TimiGiftController.D(TimiGiftController.this, event);
                }
            });
        }
    }

    public final void s(boolean isSdkDestroy) {
        GiftSdkProvider giftSdkProvider = this.giftSdkProvider;
        if (giftSdkProvider != null) {
            giftSdkProvider.c(isSdkDestroy);
        }
        ((kn4.b) mm4.b.b(kn4.b.class)).M(this.roomId).k(this.msgListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void t() {
        List<CommonOuterClass$QQUserId> emptyList;
        sh2.c cVar = this.giftPanelView;
        if (cVar != null) {
            cVar.hide();
        }
        this.resourcePath = "";
        yh4.a aVar = this.onSelectGiftToUserListener;
        if (aVar != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            aVar.a(emptyList, null);
        }
    }

    public final long x(@Nullable Long tinyId) {
        List<UserProxyCmdOuterClass$TinyIdUinPair> list = this.tinyPairList;
        if (list != null) {
            for (UserProxyCmdOuterClass$TinyIdUinPair userProxyCmdOuterClass$TinyIdUinPair : list) {
                long j3 = userProxyCmdOuterClass$TinyIdUinPair.tiny_id.get();
                if (tinyId != null && j3 == tinyId.longValue()) {
                    return userProxyCmdOuterClass$TinyIdUinPair.uid.get();
                }
            }
            return 0L;
        }
        return 0L;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J*\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0017\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$e", "Lsh2/c$f;", "", "f", "t", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "", "position", "h0", "w", "r", "u0", "O", "D", "isSuccess", "errCode", "", "errMsg", ICustomDataEditor.NUMBER_PARAM_1, "comboCnt", "cnt", "", "o1", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements c.f {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftController$e$a", "Lqh2/f;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements qh2.f {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TimiGiftController f377112d;

            a(TimiGiftController timiGiftController) {
                this.f377112d = timiGiftController;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(TimiGiftController this$0) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                yh4.a aVar = this$0.onSelectGiftToUserListener;
                if (aVar != null) {
                    List<ReceiverInfoModel> a16 = this$0.receiverCore.a();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = a16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((ReceiverInfoModel) it.next()).getUid());
                    }
                    aVar.a(arrayList, this$0.resourcePath);
                }
            }

            @Override // qh2.f
            public void c(int id5, @Nullable QQGiftPanelResource panelResource) {
                String str;
                TimiGiftController timiGiftController = this.f377112d;
                if (panelResource != null) {
                    str = panelResource.f265002b;
                } else {
                    str = null;
                }
                if (str != null) {
                    timiGiftController.resourcePath = str;
                    final TimiGiftController timiGiftController2 = this.f377112d;
                    w.c(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            TimiGiftController.e.a.b(TimiGiftController.this);
                        }
                    });
                }
            }

            @Override // qh2.g
            public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
                com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "errorCode: " + errorCode + "; errorMessage: " + errorMessage);
            }
        }

        e() {
        }

        @Override // sh2.c.f
        public boolean D() {
            return false;
        }

        @Override // sh2.c.f
        public boolean O(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            if (data == null) {
                return true;
            }
            boolean u16 = TimiGiftController.this.u(data);
            com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "intercept: " + u16);
            if (u16) {
                return true;
            }
            return false;
        }

        @Override // sh2.c.f
        public boolean f() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        
            if (r6 == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
        
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        
            if (r4 != false) goto L29;
         */
        @Override // sh2.c.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean h0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            Object obj;
            boolean z16;
            PBUInt64Field pBUInt64Field;
            boolean z17;
            PBUInt64Field pBUInt64Field2;
            List<ReceiverInfoModel> a16 = TimiGiftController.this.receiverCore.a();
            if (a16.isEmpty()) {
                com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "none selected receiver");
                return true;
            }
            TimiGiftController timiGiftController = TimiGiftController.this;
            Iterator<T> it = a16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    CommonOuterClass$QQUserId uid = ((ReceiverInfoModel) obj).getUid();
                    CommonOuterClass$QQUserId y16 = timiGiftController.y();
                    if (uid.uid.get() != 0) {
                        if (y16 != null && (pBUInt64Field2 = y16.uid) != null && uid.uid.get() == pBUInt64Field2.get()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    }
                    if (uid.yes_uid.get() != 0) {
                        if (y16 != null && (pBUInt64Field = y16.yes_uid) != null && uid.yes_uid.get() == pBUInt64Field.get()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                    }
                    boolean z18 = false;
                    if (z18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                return false;
            }
            com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "can not select self");
            com.tencent.timi.game.ui.widget.f.c("\u4e0d\u80fd\u7ed9\u81ea\u5df1\u8d60\u9001\u793c\u7269\u54df");
            return true;
        }

        @Override // sh2.c.f
        public boolean n1(boolean isSuccess, @Nullable com.tencent.mobileqq.qqgift.data.service.d data, int errCode, @NotNull String errMsg) {
            Map<String, String> map;
            String str;
            String str2;
            String str3;
            String str4;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b e16;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            com.tencent.timi.game.utils.l.e("TimiGiftPresenter", "onSendGiftCallback: " + isSuccess + " " + errCode);
            if (!isSuccess || data == null || (map = data.M) == null || (str = map.get("sender_nick")) == null || (str2 = data.M.get("sender_avatar")) == null || (str3 = data.M.get("receiver_uin")) == null) {
                return true;
            }
            long parseLong = Long.parseLong(str3);
            String str5 = data.M.get("receiver_nick");
            if (str5 == null || (str4 = data.M.get("receiver_avatar")) == null) {
                return true;
            }
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
            TimiGiftController timiGiftController = TimiGiftController.this;
            aVar.f264910a = data.f264874d;
            aVar.f264911b = data.f264881h;
            aVar.f264913d = data.f264876e;
            aVar.f264914e = data.C;
            aVar.f264915f = data.D;
            aVar.f264918i = timiGiftController.selfUid.uid.get();
            aVar.f264919j = str;
            aVar.f264922m = str2;
            aVar.f264920k = parseLong;
            aVar.f264921l = str5;
            aVar.f264923n = str4;
            aVar.f264924o = data.f264883i;
            aVar.f264925p = data.H;
            aVar.f264926q = data.J;
            aVar.f264916g = 100;
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, TimiGiftController.this.sceneId);
            GiftSdkProvider giftSdkProvider = TimiGiftController.this.giftSdkProvider;
            if (giftSdkProvider != null && (e16 = giftSdkProvider.e()) != null) {
                e16.d(aVar);
            }
            TimiGiftController.this.giftLayerView.g();
            if (data.f264881h == 1) {
                int i3 = data.f264883i;
                if (i3 == 1 || i3 == 2) {
                    TimiGiftController.this.t();
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // sh2.c.f
        public boolean r(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            return false;
        }

        @Override // sh2.c.f
        public boolean t() {
            TimiGiftController.this.receiverCore.reset();
            TimiGiftController.this.isGiftPanelVisible = false;
            TimiGiftController.this.giftLayerView.setGiftPanelView(null);
            return false;
        }

        @Override // sh2.c.f
        public boolean u0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            GiftSdkProvider giftSdkProvider;
            oh2.a giftResDownloadModule;
            if (data != null && (giftSdkProvider = TimiGiftController.this.giftSdkProvider) != null && (giftResDownloadModule = giftSdkProvider.getGiftResDownloadModule()) != null) {
                giftResDownloadModule.e(data.C, new a(TimiGiftController.this));
            }
            return false;
        }

        @Override // sh2.c.f
        public boolean w(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            return false;
        }

        @Override // sh2.c.f
        public void o1(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int comboCnt, int cnt) {
        }
    }
}
