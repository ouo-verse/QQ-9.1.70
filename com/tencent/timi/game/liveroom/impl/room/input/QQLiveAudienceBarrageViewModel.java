package com.tencent.timi.game.liveroom.impl.room.input;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.liveroom.impl.room.input.SendResult;
import com.tencent.timi.game.liveroom.impl.room.input.event.UpdateBarrageListEvent;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserPayLevelData;
import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import com.tencent.timi.game.sso.request.QQLiveGetBarrageDataSetRequest;
import com.tencent.timi.game.sso.request.QQLiveSendBarrageDataRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pk4.b;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 k2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001lB\u000f\u0012\u0006\u0010.\u001a\u00020\"\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u0018\u001a\u00020\u000b*\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010#\u001a\u00020\"J(\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010.\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R(\u0010<\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040A8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER#\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00150=8\u0006\u00a2\u0006\f\n\u0004\bG\u0010?\u001a\u0004\bH\u0010IR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020K0=8\u0006\u00a2\u0006\f\n\u0004\bL\u0010?\u001a\u0004\bM\u0010IR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0=8\u0006\u00a2\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bP\u0010IR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010S\u001a\u0004\bT\u0010UR(\u0010[\u001a\u0004\u0018\u00010\"2\b\u00107\u001a\u0004\u0018\u00010\"8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001c\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010g\u00a8\u0006m"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "fromFloatWindow", "", SemanticAttributes.DbSystemValues.H2, "P1", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "barrageData", "", "message", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/liveroom/impl/room/input/w;", "j2", "Q1", "O1", "Lur4/f;", "response", "", "f2", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "c2", "d2", "e2", "status", "k2", "", "position", "l2", "b2", "i2", "", "X1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "g2", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", "i", "J", "roomId", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest;", "requestApi", BdhLogUtil.LogTag.Tag_Conn, "Z", "onRoomEntered", "Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "<set-?>", "D", "Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "T1", "()Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "currentBarrage", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_barrageSwitchStatus", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "barrageSwitchStatus", "G", "R1", "()Landroidx/lifecycle/MutableLiveData;", "barrageDataSet", "Lcom/tencent/timi/game/liveroom/impl/room/input/v;", "H", "U1", "onBarrageCheckedAction", "I", "W1", "onBarrageSendAction", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "Lkotlin/Lazy;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "rankViewModel", "K", "Ljava/lang/Long;", "Z1", "()Ljava/lang/Long;", "payLevel", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "L", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "userLevelChangedListener", "", "M", "Ljava/util/Map;", "barrageIdToGiftId", "Lzi4/a;", "Ld55/j;", "N", "Lzi4/a;", "queryRankListCallback", "<init>", "(J)V", "P", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveAudienceBarrageViewModel extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean onRoomEntered;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private CurrentBarrage currentBarrage;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _barrageSwitchStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> barrageSwitchStatus;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<BarrageData>> barrageDataSet;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<OnBarrageCheckedAction> onBarrageCheckedAction;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<OnBarrageSendAction> onBarrageSendAction;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy rankViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Long payLevel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.userlevel.h userLevelChangedListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> barrageIdToGiftId;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final zi4.a<d55.j> queryRankListCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILiveNetRequest requestApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "roomId", "Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel$a$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9939a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f377784a;

            C9939a(long j3) {
                this.f377784a = j3;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                return modelClass.getConstructor(Long.TYPE).newInstance(Long.valueOf(this.f377784a));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QQLiveAudienceBarrageViewModel a(@NotNull ViewModelStoreOwner owner, long roomId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            ViewModel viewModel = new ViewModelProvider(owner, new C9939a(roomId)).get(QQLiveAudienceBarrageViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,\u2026ageViewModel::class.java)");
            return (QQLiveAudienceBarrageViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel$b", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/h;", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "payLevelData", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements com.tencent.timi.game.liveroom.impl.room.userlevel.h {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.userlevel.h
        public void a(@NotNull UserPayLevelData payLevelData) {
            Intrinsics.checkNotNullParameter(payLevelData, "payLevelData");
            QQLiveAudienceBarrageViewModel.this.payLevel = Long.valueOf(payLevelData.getCurPayLevel());
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "userLevelChanged", "payLevel=" + QQLiveAudienceBarrageViewModel.this.getPayLevel());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel$d", "Lzi4/a;", "Ld55/j;", "data", "", "a", "", "code", "", "msg", "fail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements zi4.a<d55.j> {
        d() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable d55.j data) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "getRankListForDetail success, data=" + data);
        }

        @Override // zi4.a
        public void fail(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "getRankListForDetail fail, code=" + code + ", msg=" + msg2);
        }
    }

    public QQLiveAudienceBarrageViewModel(long j3) {
        Lazy lazy;
        this.roomId = j3;
        QRouteApi api = QRoute.api(ILiveNetRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ILiveNetRequest::class.java)");
        this.requestApi = (ILiveNetRequest) api;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._barrageSwitchStatus = mutableLiveData;
        this.barrageSwitchStatus = mutableLiveData;
        this.barrageDataSet = new MutableLiveData<>();
        this.onBarrageCheckedAction = new MutableLiveData<>();
        this.onBarrageSendAction = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RankViewModel>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$rankViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RankViewModel invoke() {
                return new RankViewModel();
            }
        });
        this.rankViewModel = lazy;
        this.barrageIdToGiftId = new LinkedHashMap();
        this.queryRankListCallback = new d();
    }

    private final String O1(BarrageData barrageData) {
        boolean z16;
        BarrageLimit barrageLimit;
        Object firstOrNull;
        long j3;
        boolean z17;
        Object first;
        if (barrageData == null) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "barrageData is null");
            return "\u5f39\u5e55\u6570\u636e\u4e3a\u7a7a";
        }
        List<BarrageLimit> e16 = barrageData.e();
        if (e16 != null && !e16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Integer num = null;
        if (z16) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "barrageData.limits isNullOrEmpty");
            return null;
        }
        long X1 = X1();
        if (barrageData.h()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) barrageData.e());
            int roomLimitCounts = ((BarrageLimit) first).getRoomLimitCounts();
            if (X1 > roomLimitCounts) {
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "onlineCount:" + X1 + " > roomLimitCounts:" + roomLimitCounts);
                return barrageData.getConfig().getText() + "\u5f39\u5e55\u53ea\u80fd\u5728 " + roomLimitCounts + " \u4eba\u5185\u7684\u76f4\u64ad\u95f4\u4f7f\u7528";
            }
        } else if (barrageData.i()) {
            if (this.payLevel == null) {
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "payLevel is null");
                return "\u83b7\u53d6\u7b49\u7ea7\u5f02\u5e38";
            }
            List<BarrageLimit> e17 = barrageData.e();
            ListIterator<BarrageLimit> listIterator = e17.listIterator(e17.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    barrageLimit = listIterator.previous();
                    BarrageLimit barrageLimit2 = barrageLimit;
                    Long l3 = this.payLevel;
                    if (l3 != null) {
                        j3 = l3.longValue();
                    } else {
                        j3 = 0;
                    }
                    if (j3 >= barrageLimit2.getPayLimit()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    barrageLimit = null;
                    break;
                }
            }
            BarrageLimit barrageLimit3 = barrageLimit;
            if (barrageLimit3 == null) {
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "roomLimitCounts is null");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) barrageData.e());
                BarrageLimit barrageLimit4 = (BarrageLimit) firstOrNull;
                if (barrageLimit4 != null) {
                    num = Integer.valueOf(barrageLimit4.getPayLimit());
                }
                return "\u8d26\u53f7\u9700\u8981\u8fbe\u5230 " + num + " \u7ea7\u624d\u80fd\u89e3\u9501\u5f39\u5e55\u4f7f\u7528\u6743\u76ca";
            }
            int roomLimitCounts2 = barrageLimit3.getRoomLimitCounts();
            if (X1 > roomLimitCounts2) {
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "checkingBarrageData", "onlineCount:" + X1 + " > roomLimitCounts:" + roomLimitCounts2);
                return barrageData.getConfig().getText() + "\u5f39\u5e55\u53ea\u80fd\u5728 " + roomLimitCounts2 + " \u4eba\u5185\u7684\u76f4\u64ad\u95f4\u4f7f\u7528";
            }
        }
        return null;
    }

    private final void P1() {
        this.requestApi.sendRequest2(new QQLiveGetBarrageDataSetRequest(this.roomId), new Function1<QQLiveResponse<ur4.f>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$fetchBarrageInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ur4.f> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ur4.f> rsp) {
                ur4.d[] dVarArr;
                List<BarrageData> f26;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Audience|QQLiveAudienceBarrageViewModel", "fetchBarrageInfo", "isSuccess=" + rsp.isSuccess() + ", retCode=" + rsp.getRetCode() + ", errMsg=" + rsp.getErrMsg());
                ur4.f rsp2 = rsp.getRsp();
                if (!rsp.isFailed() && rsp2 != null) {
                    ur4.d[] dVarArr2 = rsp2.f439916a;
                    boolean z16 = true;
                    if (dVarArr2 != null) {
                        if (!(dVarArr2.length == 0)) {
                            z16 = false;
                        }
                    }
                    if (!z16) {
                        f26 = QQLiveAudienceBarrageViewModel.this.f2(rsp2);
                        if (f26 == null) {
                            return;
                        }
                        QQLiveAudienceBarrageViewModel.this.R1().postValue(f26);
                        return;
                    }
                }
                companion.i("Audience|QQLiveAudienceBarrageViewModel", "fetchBarrageInfo", "size=" + ((rsp2 == null || (dVarArr = rsp2.f439916a) == null) ? null : Integer.valueOf(dVarArr.length)));
            }
        });
    }

    private final void Q1() {
        b bVar = new b();
        com.tencent.timi.game.liveroom.impl.room.userlevel.i iVar = com.tencent.timi.game.liveroom.impl.room.userlevel.i.f378614a;
        iVar.i(bVar);
        this.userLevelChangedListener = bVar;
        UserPayLevelData g16 = iVar.g();
        if (g16 == null) {
            com.tencent.timi.game.liveroom.impl.room.userlevel.i.e(iVar, null, 1, null);
            return;
        }
        Long valueOf = Long.valueOf(g16.getCurPayLevel());
        this.payLevel = valueOf;
        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "fetchMyPayUserLevel", "payLevel=" + valueOf);
    }

    private final RankViewModel a2() {
        return (RankViewModel) this.rankViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c2(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        return "{giftID=" + dVar.f264874d + ", price=" + dVar.f264878f + ", ext=" + dVar.M + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BarrageData> f2(ur4.f response) {
        List<BarrageData> mutableList;
        boolean z16;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        boolean z17;
        int i3;
        int i16;
        ArrayList arrayList;
        try {
            ur4.d[] dVarArr = response.f439916a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "response.flutterChats");
            ArrayList arrayList2 = new ArrayList(dVarArr.length);
            for (ur4.d dVar : dVarArr) {
                String[] strArr = dVar.f439913h.f439893a;
                Intrinsics.checkNotNullExpressionValue(strArr, "it.chatConfig.backgroundColors");
                list = ArraysKt___ArraysKt.toList(strArr);
                int[] iArr = dVar.f439913h.f439894b;
                Intrinsics.checkNotNullExpressionValue(iArr, "it.chatConfig.backgroundLocations");
                list2 = ArraysKt___ArraysKt.toList(iArr);
                String[] strArr2 = dVar.f439913h.f439895c;
                Intrinsics.checkNotNullExpressionValue(strArr2, "it.chatConfig.frameColors");
                list3 = ArraysKt___ArraysKt.toList(strArr2);
                int[] iArr2 = dVar.f439913h.f439896d;
                Intrinsics.checkNotNullExpressionValue(iArr2, "it.chatConfig.frameLoactions");
                list4 = ArraysKt___ArraysKt.toList(iArr2);
                String[] strArr3 = dVar.f439913h.f439897e;
                Intrinsics.checkNotNullExpressionValue(strArr3, "it.chatConfig.wordColors");
                list5 = ArraysKt___ArraysKt.toList(strArr3);
                int[] iArr3 = dVar.f439913h.f439898f;
                Intrinsics.checkNotNullExpressionValue(iArr3, "it.chatConfig.wordLocations");
                list6 = ArraysKt___ArraysKt.toList(iArr3);
                ur4.b bVar = dVar.f439913h;
                String str = bVar.f439899g;
                if (!bVar.f439900h) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                String str2 = bVar.f439901i;
                Intrinsics.checkNotNullExpressionValue(str2, "it.chatConfig.text");
                BarrageConfig barrageConfig = new BarrageConfig(list, list2, list3, list4, list5, list6, str, z17, str2);
                int i17 = dVar.f439906a;
                int i18 = dVar.f439908c;
                int i19 = dVar.f439909d;
                ur4.r rVar = dVar.f439914i;
                if (rVar != null) {
                    i3 = rVar.f439953b;
                } else {
                    i3 = 0;
                }
                if (rVar != null) {
                    i16 = rVar.f439952a;
                } else {
                    i16 = 0;
                }
                ur4.j[] limits = dVar.f439910e;
                if (limits != null) {
                    Intrinsics.checkNotNullExpressionValue(limits, "limits");
                    ArrayList arrayList3 = new ArrayList(limits.length);
                    for (ur4.j jVar : limits) {
                        arrayList3.add(new BarrageLimit(jVar.f439923a, jVar.f439924b));
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                arrayList2.add(new BarrageData(i17, i18, i19, i3, i16, barrageConfig, arrayList, null, 128, null));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList2) {
                BarrageData barrageData = (BarrageData) obj;
                if (barrageData.h() && barrageData.getLeftCount() <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList4.add(obj);
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
            return mutableList;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "parseFlutterChats", "parseFlutterChats error", e16);
            return null;
        }
    }

    private final void h2(boolean fromFloatWindow) {
        boolean z16;
        BarrageDataCache a16 = x.f377844a.a(this.roomId);
        if (fromFloatWindow && a16 != null) {
            this._barrageSwitchStatus.setValue(Boolean.valueOf(a16.getBarrageSwitchStatus()));
            this.payLevel = a16.getPayLevel();
            List<BarrageData> a17 = a16.a();
            if (a17 != null && !a17.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.currentBarrage = a16.getCurrentBarrage();
                this.barrageDataSet.setValue(a16.a());
                this.onBarrageCheckedAction.postValue(new OnBarrageCheckedAction(this.currentBarrage, null, 2, null));
                return;
            }
            return;
        }
        this._barrageSwitchStatus.setValue(Boolean.FALSE);
        this.currentBarrage = null;
        this.barrageDataSet.setValue(new ArrayList());
    }

    private final OnBarrageSendAction j2(final BarrageData barrageData, final String message, final MessageOuterClass$MsgContent content) {
        final String str = this.roomId + "-" + barrageData.getId() + "-" + com.tencent.mobileqq.qqlive.sail.c.f272176a.G() + "-" + System.currentTimeMillis();
        QQLiveSendBarrageDataRequest qQLiveSendBarrageDataRequest = new QQLiveSendBarrageDataRequest(message, this.roomId, barrageData.getId(), str);
        barrageData.k(str);
        if (barrageData.h()) {
            barrageData.j(barrageData.getLeftCount() - 1);
            MutableLiveData<List<BarrageData>> mutableLiveData = this.barrageDataSet;
            mutableLiveData.setValue(mutableLiveData.getValue());
        }
        this.requestApi.sendRequest2(qQLiveSendBarrageDataRequest, new Function1<QQLiveResponse<ur4.p>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$sendBarrageMessageInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ur4.p> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ur4.p> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "sendBarrageMessage", "msgId=" + str + ", message=" + message + ", isSuccess=" + it.isSuccess() + ", retCode=" + it.getRetCode() + ", errMsg=" + it.getErrMsg());
                if (barrageData.h()) {
                    SendResult.Companion companion = SendResult.INSTANCE;
                    SendResult e16 = companion.e();
                    List<BarrageData> value = this.R1().getValue();
                    if (it.isFailed()) {
                        BarrageData barrageData2 = barrageData;
                        barrageData2.j(barrageData2.getLeftCount() + 1);
                        e16 = companion.a(it.getErrMsg());
                    } else if (value != null) {
                        CollectionsKt__MutableCollectionsKt.removeAll((List) value, (Function1) new Function1<BarrageData, Boolean>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$sendBarrageMessageInner$1.1
                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Boolean invoke(@NotNull BarrageData data) {
                                Intrinsics.checkNotNullParameter(data, "data");
                                return Boolean.valueOf(data.h() && data.getLeftCount() <= 0);
                            }
                        });
                    }
                    this.R1().postValue(value);
                    this.W1().postValue(new OnBarrageSendAction(e16, barrageData, message, content));
                    return;
                }
                if (barrageData.i()) {
                    SendResult.Companion companion2 = SendResult.INSTANCE;
                    SendResult c16 = companion2.c();
                    if (it.isFailed()) {
                        c16 = companion2.a(it.getErrMsg());
                    }
                    this.W1().postValue(new OnBarrageSendAction(c16, barrageData, message, content));
                }
            }
        });
        return new OnBarrageSendAction(SendResult.INSTANCE.b(), barrageData, message, content);
    }

    @NotNull
    public final MutableLiveData<List<BarrageData>> R1() {
        return this.barrageDataSet;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.barrageSwitchStatus;
    }

    @Nullable
    /* renamed from: T1, reason: from getter */
    public final CurrentBarrage getCurrentBarrage() {
        return this.currentBarrage;
    }

    @NotNull
    public final MutableLiveData<OnBarrageCheckedAction> U1() {
        return this.onBarrageCheckedAction;
    }

    @NotNull
    public final MutableLiveData<OnBarrageSendAction> W1() {
        return this.onBarrageSendAction;
    }

    public final long X1() {
        return com.tencent.timi.game.liveroom.impl.room.view.rank.c.c(a2().k()) - 1;
    }

    @Nullable
    /* renamed from: Z1, reason: from getter */
    public final Long getPayLevel() {
        return this.payLevel;
    }

    public final boolean b2() {
        if (Intrinsics.areEqual(this.barrageSwitchStatus.getValue(), Boolean.TRUE) && this.currentBarrage != null) {
            return true;
        }
        return false;
    }

    public final void d2(boolean fromFloatWindow) {
        if (this.onRoomEntered) {
            return;
        }
        this.onRoomEntered = true;
        h2(fromFloatWindow);
        P1();
        Q1();
        a2().x(this.roomId);
        a2().h(true, this.queryRankListCallback);
        this.barrageIdToGiftId.put(1001, Integer.valueOf(ht3.a.b("qqlive_barrage_1001_gift_id", 301467)));
        this.barrageIdToGiftId.put(1002, Integer.valueOf(ht3.a.b("qqlive_barrage_1002_gift_id", 301468)));
        this.barrageIdToGiftId.put(1003, Integer.valueOf(ht3.a.b("qqlive_barrage_1003_gift_id", 301469)));
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void e2() {
        this.onRoomEntered = false;
        a2().e();
        com.tencent.timi.game.liveroom.impl.room.userlevel.h hVar = this.userLevelChangedListener;
        if (hVar != null) {
            com.tencent.timi.game.liveroom.impl.room.userlevel.i.f378614a.j(hVar);
        }
        x xVar = x.f377844a;
        long j3 = this.roomId;
        Boolean value = this.barrageSwitchStatus.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        xVar.b(j3, new BarrageDataCache(value.booleanValue(), this.barrageDataSet.getValue(), this.currentBarrage, this.payLevel));
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void g2(@NotNull Activity activity, @NotNull BarrageData barrageData, @NotNull String message, @Nullable MessageOuterClass$MsgContent content) {
        int i3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(barrageData, "barrageData");
        Intrinsics.checkNotNullParameter(message, "message");
        com.tencent.mobileqq.qqgift.data.service.d dVar = new com.tencent.mobileqq.qqgift.data.service.d();
        if (SSODebugUtil.isTestEnv()) {
            i3 = 300221;
        } else {
            Integer num = this.barrageIdToGiftId.get(Integer.valueOf(barrageData.getId()));
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
        }
        dVar.f264874d = i3;
        dVar.f264878f = barrageData.getPrice();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("flutter_chat_id", String.valueOf(barrageData.getId()));
        linkedHashMap.put("flutter_msg_id", barrageData.getMsgId());
        dVar.M = linkedHashMap;
        pk4.b.n(activity, false, dVar, -1L, 0L, new c(dVar, barrageData, message, content));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateBarrageListEvent.class);
        return arrayList;
    }

    @NotNull
    public final OnBarrageSendAction i2(@NotNull String message, @Nullable MessageOuterClass$MsgContent content) {
        BarrageData barrageData;
        Intrinsics.checkNotNullParameter(message, "message");
        CurrentBarrage currentBarrage = this.currentBarrage;
        if (currentBarrage != null) {
            barrageData = currentBarrage.getBarrageData();
        } else {
            barrageData = null;
        }
        if (barrageData == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "sendBarrageMessage", "curBarrageData is null");
            return new OnBarrageSendAction(SendResult.INSTANCE.a("\u5f53\u524d\u5f39\u5e55\u4fe1\u606f\u4e3a\u7a7a"), null, null, null, 14, null);
        }
        String O1 = O1(barrageData);
        if (O1 != null) {
            return new OnBarrageSendAction(SendResult.INSTANCE.a(O1), null, null, null, 14, null);
        }
        if (ht3.a.e("qqlive_barrage_msg_real_name_auth_enable", true) && barrageData.i() && barrageData.getPrice() > 0) {
            zh4.d dVar = zh4.d.f452579a;
            AuthScene authScene = AuthScene.GIFT;
            if (dVar.k(authScene)) {
                final Activity topActivity = Foreground.getTopActivity();
                if (topActivity != null && !topActivity.isFinishing()) {
                    dVar.d(topActivity, authScene, new Function2<Boolean, String, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.QQLiveAudienceBarrageViewModel$sendBarrageMessage$1
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

                        public final void invoke(boolean z16, @Nullable String str) {
                            if (z16) {
                                QQToast.makeText(topActivity, str, 0).show();
                                AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "checkStatusAndAuth success", "errMsg:" + str);
                                return;
                            }
                            QQToast.makeText(topActivity, str, 0).show();
                            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "checkStatusAndAuth failed", "errMsg:" + str);
                        }
                    });
                    return new OnBarrageSendAction(SendResult.INSTANCE.d(), null, null, null, 14, null);
                }
                AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "sendBarrageMessage", "activity is invalid.");
                return new OnBarrageSendAction(SendResult.INSTANCE.a("\u5b9e\u540d\u8ba4\u8bc1activity\u5f02\u5e38"), null, null, null, 14, null);
            }
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "send isPayType:" + barrageData.i() + ", price:" + barrageData.getPrice());
        return j2(barrageData, message, content);
    }

    public final void k2(boolean status) {
        List<BarrageData> value;
        boolean z16;
        this._barrageSwitchStatus.setValue(Boolean.valueOf(status));
        if (this.currentBarrage == null && status && (value = this.barrageDataSet.getValue()) != null) {
            int i3 = 0;
            for (Object obj : value) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                BarrageData barrageData = (BarrageData) obj;
                String O1 = O1(barrageData);
                if (O1 != null && O1.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    CurrentBarrage currentBarrage = new CurrentBarrage(barrageData, i3);
                    this.currentBarrage = currentBarrage;
                    this.onBarrageCheckedAction.postValue(new OnBarrageCheckedAction(currentBarrage, null, 2, null));
                    return;
                }
                i3 = i16;
            }
        }
    }

    public final void l2(int position) {
        BarrageData barrageData;
        boolean z16;
        List<BarrageData> value = this.barrageDataSet.getValue();
        if (value != null) {
            barrageData = value.get(position);
        } else {
            barrageData = null;
        }
        if (barrageData == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBarrageViewModel", "setCurrentBarrage", "curBarrageData is null");
            return;
        }
        CurrentBarrage currentBarrage = this.currentBarrage;
        boolean z17 = true;
        if (currentBarrage != null && currentBarrage.getPosition() == position) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        String O1 = O1(barrageData);
        if (O1 != null && O1.length() != 0) {
            z17 = false;
        }
        if (z17) {
            CurrentBarrage currentBarrage2 = new CurrentBarrage(barrageData, position);
            this.currentBarrage = currentBarrage2;
            this.onBarrageCheckedAction.setValue(new OnBarrageCheckedAction(currentBarrage2, null, 2, null));
            return;
        }
        this.onBarrageCheckedAction.setValue(new OnBarrageCheckedAction(null, O1));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if ((event instanceof UpdateBarrageListEvent) && ((UpdateBarrageListEvent) event).getRoomId() == this.roomId) {
            P1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel$c", "Lpk4/b$k;", "", "errCode", "", "errMsg", "", "a", "f", "e", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "c", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements b.k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f377787b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BarrageData f377788c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f377789d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageOuterClass$MsgContent f377790e;

        c(com.tencent.mobileqq.qqgift.data.service.d dVar, BarrageData barrageData, String str, MessageOuterClass$MsgContent messageOuterClass$MsgContent) {
            this.f377787b = dVar;
            this.f377788c = barrageData;
            this.f377789d = str;
            this.f377790e = messageOuterClass$MsgContent;
        }

        @Override // pk4.b.k
        public void a(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "onPreCheckFail", "giftData=" + QQLiveAudienceBarrageViewModel.this.c2(this.f377787b) + ", errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // pk4.b.k
        public void b(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "onSendGiftFail", "giftData=" + QQLiveAudienceBarrageViewModel.this.c2(this.f377787b) + ", errCode=" + errCode + ", errMsg=" + errMsg);
            MutableLiveData<OnBarrageSendAction> W1 = QQLiveAudienceBarrageViewModel.this.W1();
            SendResult.Companion companion = SendResult.INSTANCE;
            if (errMsg == null) {
                errMsg = "\u652f\u4ed8\u5931\u8d25";
            }
            W1.postValue(new OnBarrageSendAction(companion.a(errMsg), null, null, null, 14, null));
        }

        @Override // pk4.b.k
        public void c(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "onSendGiftSuccess", "giftData=" + QQLiveAudienceBarrageViewModel.this.c2(this.f377787b));
            QQLiveAudienceBarrageViewModel.this.W1().postValue(new OnBarrageSendAction(SendResult.INSTANCE.f("\u6d88\u8017 " + this.f377788c.getPrice() + " \u91d1\u5e01\u53d1\u9001\u4e86\u4e00\u6761 " + this.f377788c.getConfig().getText() + " "), this.f377788c, this.f377789d, this.f377790e));
        }

        @Override // pk4.b.k
        public void e(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "onBalanceFail", "giftData=" + QQLiveAudienceBarrageViewModel.this.c2(this.f377787b) + ", errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // pk4.b.k
        public void f(@Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBarrageViewModel", "onIdentifyFail", "giftData=" + QQLiveAudienceBarrageViewModel.this.c2(this.f377787b) + ", errMsg=" + errMsg);
        }

        @Override // pk4.b.k
        public void d(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
        }
    }
}
