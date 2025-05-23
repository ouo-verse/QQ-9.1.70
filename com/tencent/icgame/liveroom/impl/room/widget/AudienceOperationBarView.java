package com.tencent.icgame.liveroom.impl.room.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.app.event.AnchorAtEvent;
import com.tencent.icgame.game.liveroom.impl.room.bottombtn.RedPointIconView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 p2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0003qrsB'\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010m\u001a\u00020'\u00a2\u0006\u0004\bn\u0010oJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\"\u0010!\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001e\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u00100\u001a\u00020\u0007H\u0014J\b\u00101\u001a\u00020\u0007H\u0014J$\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030302j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000303`4H\u0016J\u0012\u00108\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000106H\u0016R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u000eR\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u000eR\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010UR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010UR\u0014\u0010X\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010UR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010]R\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010]R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010h\u001a\b\u0018\u00010eR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010g\u00a8\u0006t"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/icgame/game/app/event/AnchorAtEvent;", "", "", "show", "", "L", "K", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "", "roomId", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lyv0/a;", HippyTKDListViewAdapter.X, "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$b;", "listener", "setAnchorOperationViewListener", "Landroid/view/View;", "y", "Lvv0/a;", "operationBarSupport", "setOperationBarSupport", NodeProps.VISIBLE, "setTeamConditionSettingVisibility", "extraInfo", "w", "isAnchor", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "G", "E", UserInfo.SEX_FEMALE, MiniChatConstants.MINI_APP_LANDSCAPE, "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "type", "setRoomType", "B", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "anchorInfo", "H", "setContentByConfig", BdhLogUtil.LogTag.Tag_Conn, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "d", "Lyv0/a;", "bottomConfigModel", "e", "Z", "configShowVerInput", "f", "showOperaWebDialogCount", "Lcom/tencent/icgame/common/api/IAegisLogApi;", tl.h.F, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "i", "roomType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "curAnchorUid", "curRoomId", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "curAudienceRoom", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "curAnchorInfo", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "inputTv", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "teamIv", "linkMicIv", "quickGiftIv", "Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;", "Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;", "giftIv", "Lcom/tencent/icgame/game/liveroom/impl/room/bottombtn/RedPointIconView;", "Lcom/tencent/icgame/game/liveroom/impl/room/bottombtn/RedPointIconView;", "operateIv", "shareIvOrMoreIv", "M", "Lvv0/a;", "N", "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$b;", "iAudienceOperationViewListener", "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$GetTeamConditionSettingRectRunnable;", "P", "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$GetTeamConditionSettingRectRunnable;", "getTeamConditionSettingRectRunnable", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "GetTeamConditionSettingRectRunnable", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class AudienceOperationBarView extends FrameLayout implements SimpleEventReceiver<AnchorAtEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private long curRoomId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ILiveRoom curAudienceRoom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private LiveUserInfo curAnchorInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView inputTv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView teamIv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView linkMicIv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView quickGiftIv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GiftEntranceView giftIv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RedPointIconView operateIv;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final RedPointIconView shareIvOrMoreIv;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private vv0.a operationBarSupport;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private b iAudienceOperationViewListener;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private GetTeamConditionSettingRectRunnable getTeamConditionSettingRectRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private yv0.a bottomConfigModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean configShowVerInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int showOperaWebDialogCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long curAnchorUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$GetTeamConditionSettingRectRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lkotlin/Function1;", "Landroid/graphics/Rect;", "d", "Lkotlin/jvm/functions/Function1;", "cb", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public final class GetTeamConditionSettingRectRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Rect, Unit> cb;
        final /* synthetic */ AudienceOperationBarView this$0;

        @Override // java.lang.Runnable
        public void run() {
            int e16 = uu0.b.e(this.this$0.teamIv);
            int f16 = uu0.b.f(this.this$0.teamIv);
            Function1<Rect, Unit> function1 = this.cb;
            Rect rect = new Rect();
            AudienceOperationBarView audienceOperationBarView = this.this$0;
            rect.left = e16;
            rect.top = f16;
            rect.right = e16 + audienceOperationBarView.teamIv.getWidth();
            rect.bottom = f16 + audienceOperationBarView.teamIv.getHeight();
            function1.invoke(rect);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$b;", "", "", "c", "b", "j", "a", "g", tl.h.F, "d", "e", "i", "Lep4/b;", "freeLove", "f", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f(@NotNull ep4.b freeLove);

        void g();

        void h();

        void i();

        void j();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$c", "Lyv0/e;", "Lep4/d;", "rsp", "", "a", "", "code", "", "msg", "fail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements yv0.e<ep4.d> {
        c() {
        }

        @Override // yv0.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull ep4.d rsp) {
            Map<String, String> mutableMapOf;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            AudienceOperationBarView.this.log.i("ICGameAudienceOperationBarView", "getBottomConfig success");
            ep4.a aVar = rsp.f396948a;
            if (aVar != null) {
                AudienceOperationBarView audienceOperationBarView = AudienceOperationBarView.this;
                audienceOperationBarView.operateIv.C0(aVar.f396940e, aVar.f396936a, false);
                com.tencent.icgame.game.utils.g.h("ICGameAudienceOperationBarView", "\u8fd0\u8425\u6309\u94ae\u662f\u5426\u663e\u793a:" + aVar.f396940e + ", \u6bcf\u5929\u81ea\u52a8\u663e\u793a\u6b21\u6570:" + aVar.f396941f + ", \u5df2\u7ecf\u663e\u793a\u7684\u6b21\u6570:" + audienceOperationBarView.showOperaWebDialogCount);
                if (aVar.f396940e && audienceOperationBarView.showOperaWebDialogCount < aVar.f396941f) {
                    audienceOperationBarView.bottomConfigModel.l();
                    audienceOperationBarView.showOperaWebDialogCount++;
                    rx0.a.i("show_opera_count", audienceOperationBarView.showOperaWebDialogCount);
                    rx0.a.j("show_opera_time_stamp", System.currentTimeMillis());
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("icgame_function_name", aVar.f396937b));
                audienceOperationBarView.bottomConfigModel.g(audienceOperationBarView.operateIv, mutableMapOf);
            }
            AudienceOperationBarView.this.shareIvOrMoreIv.B0(true, R.drawable.o68, false);
            AudienceOperationBarView.this.bottomConfigModel.f(AudienceOperationBarView.this.shareIvOrMoreIv);
            if (AudienceOperationBarView.this.bottomConfigModel.k()) {
                GiftEntranceView giftEntranceView = AudienceOperationBarView.this.giftIv;
                if (giftEntranceView != null) {
                    giftEntranceView.setVisibility(0);
                }
            } else {
                GiftEntranceView giftEntranceView2 = AudienceOperationBarView.this.giftIv;
                if (giftEntranceView2 != null) {
                    giftEntranceView2.setVisibility(8);
                }
            }
            b bVar = AudienceOperationBarView.this.iAudienceOperationViewListener;
            if (bVar != null) {
                ep4.b bVar2 = rsp.f396952e;
                Intrinsics.checkNotNullExpressionValue(bVar2, "rsp.freelove");
                bVar.f(bVar2);
            }
        }

        @Override // yv0.e
        public void fail(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AudienceOperationBarView.this.log.e("ICGameAudienceOperationBarView", "getBottomConfig fail, code " + code + ", msg " + msg2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceOperationBarView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void I(LiveRoomExtraInfo roomExtraInfo, long roomId) {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            this.bottomConfigModel.m(sDKImpl.getProxySsoService());
            this.bottomConfigModel.h(roomId, roomExtraInfo.f114883h, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AudienceOperationBarView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j16 = this$0.curRoomId;
        if (j16 == j3) {
            com.tencent.icgame.game.utils.g.a("ICGameAudienceOperationBarView", "onConfigUpdate gift false");
            com.tencent.icgame.game.utils.g.h("ICGameAudienceOperationBarView", "showInput " + this$0.configShowVerInput);
            this$0.L(this$0.getConfigShowVerInput());
            return;
        }
        com.tencent.icgame.game.utils.g.d("ICGameAudienceOperationBarView", "onConfigUpdate error " + j3 + " " + j16);
    }

    /* renamed from: K, reason: from getter */
    private final boolean getConfigShowVerInput() {
        return this.configShowVerInput;
    }

    private final void L(boolean show) {
        int i3;
        TextView textView = this.inputTv;
        if (show) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        textView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AudienceOperationBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.iAudienceOperationViewListener;
        if (bVar != null) {
            bVar.c();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AudienceOperationBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bottomConfigModel.o()) {
            b bVar = this$0.iAudienceOperationViewListener;
            if (bVar != null) {
                bVar.b();
            }
        } else {
            b bVar2 = this$0.iAudienceOperationViewListener;
            if (bVar2 != null) {
                bVar2.e();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AudienceOperationBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bottomConfigModel.l();
        this$0.operateIv.z0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AudienceOperationBarView this$0, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("tag_gift_entrance") && (bVar = this$0.iAudienceOperationViewListener) != null) {
            bVar.g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AudienceOperationBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.iAudienceOperationViewListener;
        if (bVar != null) {
            bVar.h();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AudienceOperationBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.iAudienceOperationViewListener;
        if (bVar != null) {
            bVar.d();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z(long roomId) {
        IAudienceRoom N = ((fu0.c) qx0.a.b(fu0.c.class)).N(roomId);
        this.curAudienceRoom = N;
        if (N == null) {
            com.tencent.icgame.game.utils.g.d("ICGameAudienceOperationBarView", "audience room is null");
            return;
        }
        LiveInfo roomLiveInfo = N.getRoomLiveInfo();
        if (roomLiveInfo == null) {
            com.tencent.icgame.game.utils.g.d("ICGameAudienceOperationBarView", "liveInfo is null");
            return;
        }
        LiveAnchorInfo liveAnchorInfo = roomLiveInfo.anchorInfo;
        if (liveAnchorInfo == null) {
            com.tencent.icgame.game.utils.g.d("ICGameAudienceOperationBarView", "anchorInfo is null");
            return;
        }
        long anchorUid = liveAnchorInfo.getAnchorUid();
        this.curAnchorUid = anchorUid;
        LiveUserInfo liveUserInfo = this.curAnchorInfo;
        liveUserInfo.uid = anchorUid;
        liveUserInfo.headUrl = liveAnchorInfo.headUrl;
        liveUserInfo.nick = liveAnchorInfo.nickName;
        liveUserInfo.sex = liveAnchorInfo.sex;
        this.curRoomId = N.getRoomInfo().getRoomId();
    }

    public final void A() {
        this.giftIv.b();
    }

    public void B(long roomId, boolean isAnchor) {
        z(roomId);
    }

    public final void D(boolean isLandscape) {
        int i3;
        if (isLandscape) {
            this.giftIv.c();
            i3 = 8;
        } else {
            this.giftIv.b();
            i3 = 0;
        }
        setVisibility(i3);
    }

    public void E(long roomId) {
        this.giftIv.b();
    }

    public void F(long roomId) {
        this.giftIv.setVisibility(8);
        this.giftIv.c();
    }

    public void G(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        this.giftIv.b();
        this.curRoomId = roomId;
        com.tencent.icgame.game.utils.g.h("ICGameAudienceOperationBarView", "onPreload roomId " + roomId);
    }

    public final void H(@NotNull LiveRoomExtraInfo roomExtraInfo, @NotNull LiveAnchorInfo anchorInfo, long roomId) {
        Intrinsics.checkNotNullParameter(roomExtraInfo, "roomExtraInfo");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        I(roomExtraInfo, roomId);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<AnchorAtEvent>> getEventClass() {
        ArrayList<Class<AnchorAtEvent>> arrayList = new ArrayList<>();
        arrayList.add(AnchorAtEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        GetTeamConditionSettingRectRunnable getTeamConditionSettingRectRunnable = this.getTeamConditionSettingRectRunnable;
        if (getTeamConditionSettingRectRunnable != null) {
            this.teamIv.removeCallbacks(getTeamConditionSettingRectRunnable);
            com.tencent.icgame.game.utils.k.d(getTeamConditionSettingRectRunnable);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        b bVar = this.iAudienceOperationViewListener;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void setAnchorOperationViewListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.iAudienceOperationViewListener = listener;
    }

    public final void setContentByConfig(final long roomId) {
        post(new Runnable() { // from class: com.tencent.icgame.liveroom.impl.room.widget.k
            @Override // java.lang.Runnable
            public final void run() {
                AudienceOperationBarView.J(AudienceOperationBarView.this, roomId);
            }
        });
    }

    public final void setOperationBarSupport(@NotNull vv0.a operationBarSupport) {
        Intrinsics.checkNotNullParameter(operationBarSupport, "operationBarSupport");
        this.operationBarSupport = operationBarSupport;
    }

    public final void setRoomType(int type) {
        this.roomType = type;
    }

    public final void setTeamConditionSettingVisibility(boolean visible) {
        int i3;
        this.inputTv.setText("\u8bf4\u70b9\u4ec0\u4e48...");
        ImageView imageView = this.teamIv;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void w(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        Map mutableMapOf;
        Map mutableMapOf2;
        Map mutableMapOf3;
        Map mutableMapOf4;
        Map mutableMapOf5;
        Map mutableMapOf6;
        ConcurrentHashMap<String, String> f16 = xw0.b.f448881a.f(roomId, extraInfo);
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        aVar.b(this, "pg_icgame_audience", f16);
        mm4.a b16 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("icgame_screen_orientation", "0"));
        a.C11162a.a((ru0.a) b16, this, false, null, "em_icgame_bottom_bar", mutableMapOf, 6, null);
        mm4.a b17 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        ImageView imageView = this.teamIv;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("icgame_team_status", "0"), TuplesKt.to("icgame_team_seat", "1"));
        a.C11162a.a((ru0.a) b17, imageView, false, null, "em_icgame_play_entrance", mutableMapOf2, 6, null);
        mm4.a b18 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
        RedPointIconView redPointIconView = this.shareIvOrMoreIv;
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_icgame_bottom_bar"));
        a.C11162a.a((ru0.a) b18, redPointIconView, false, null, "em_icgame_more", mutableMapOf3, 6, null);
        mm4.a b19 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b19, "getService(ILiveReportService::class.java)");
        TextView textView = this.inputTv;
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_icgame_bottom_bar"));
        a.C11162a.a((ru0.a) b19, textView, false, null, "em_icgame_inputbar", mutableMapOf4, 6, null);
        mm4.a b26 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b26, "getService(ILiveReportService::class.java)");
        GiftEntranceView giftEntranceView = this.giftIv;
        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_icgame_bottom_bar"));
        a.C11162a.a((ru0.a) b26, giftEntranceView, false, null, "em_icgame_gift_entrance", mutableMapOf5, 6, null);
        mm4.a b27 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b27, "getService(ILiveReportService::class.java)");
        a.C11162a.a((ru0.a) b27, this.linkMicIv, false, null, "em_icgame_bottom_bar_connect", null, 22, null);
        mm4.a b28 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b28, "getService(ILiveReportService::class.java)");
        RedPointIconView redPointIconView2 = this.operateIv;
        mutableMapOf6 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_icgame_bottom_bar"));
        a.C11162a.a((ru0.a) b28, redPointIconView2, false, null, "em_icgame_regulation", mutableMapOf6, 6, null);
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final yv0.a getBottomConfigModel() {
        return this.bottomConfigModel;
    }

    @NotNull
    public final View y() {
        return this.shareIvOrMoreIv;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceOperationBarView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AudienceOperationBarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceOperationBarView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.bottomConfigModel = new yv0.a(getContext());
        this.configShowVerInput = true;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.curAnchorInfo = new LiveUserInfo();
        View.inflate(getContext(), R.layout.fbc, this);
        View findViewById = findViewById(R.id.vog);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.giftIv)");
        GiftEntranceView giftEntranceView = (GiftEntranceView) findViewById;
        this.giftIv = giftEntranceView;
        View findViewById2 = findViewById(R.id.f926858j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.teamIv)");
        ImageView imageView = (ImageView) findViewById2;
        this.teamIv = imageView;
        View findViewById3 = findViewById(R.id.xoe);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.inputTv)");
        TextView textView = (TextView) findViewById3;
        this.inputTv = textView;
        View findViewById4 = findViewById(R.id.yix);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.linkMicIv)");
        ImageView imageView2 = (ImageView) findViewById4;
        this.linkMicIv = imageView2;
        View findViewById5 = findViewById(R.id.zzg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.operateIv)");
        RedPointIconView redPointIconView = (RedPointIconView) findViewById5;
        this.operateIv = redPointIconView;
        View findViewById6 = findViewById(R.id.f66583b1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.quickGiftIv)");
        ImageView imageView3 = (ImageView) findViewById6;
        this.quickGiftIv = imageView3;
        View findViewById7 = findViewById(R.id.f84154lh);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.shareIvOrMoreIv)");
        RedPointIconView redPointIconView2 = (RedPointIconView) findViewById7;
        this.shareIvOrMoreIv = redPointIconView2;
        setClipChildren(false);
        L(getConfigShowVerInput());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.h(AudienceOperationBarView.this, view);
            }
        });
        redPointIconView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.i(AudienceOperationBarView.this, view);
            }
        });
        redPointIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.j(AudienceOperationBarView.this, view);
            }
        });
        if (System.currentTimeMillis() - rx0.a.d("show_opera_time_stamp", 0L) > 86400000) {
            this.showOperaWebDialogCount = 0;
            rx0.a.i("show_opera_count", 0);
        }
        this.showOperaWebDialogCount = rx0.a.c("show_opera_count", 0);
        giftEntranceView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.k(AudienceOperationBarView.this, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.l(AudienceOperationBarView.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceOperationBarView.m(AudienceOperationBarView.this, view);
            }
        });
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(8);
    }

    public void C(long roomId) {
    }
}
