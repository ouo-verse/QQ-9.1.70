package av0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.AppSetting;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.gift.impl.timi.IGiftPanelExtBean;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftPanelEvent;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftUtil;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import sh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002\u0084\u0001\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008b\u0001B\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002JY\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0002J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u001a\u0010(\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\nH\u0016J\u001a\u0010)\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\nH\u0016J\u001a\u0010*\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\nH\u0016J\u001a\u0010+\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\nH\u0016J\u001a\u0010,\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\"H\u0016J*\u00101\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\fH\u0016J\"\u00104\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0016J\u0006\u00105\u001a\u00020\u0002R\u0016\u00108\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0019R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010;R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u0019R\u0016\u0010@\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010BR\u0016\u0010E\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010;R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010BR\u0016\u0010G\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010BR*\u0010L\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010Hj\n\u0012\u0004\u0012\u00020I\u0018\u0001`J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010KR\u0016\u0010N\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010BR\u0016\u0010P\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010BR\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010BR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010BR\u0016\u0010U\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010BR\u0016\u0010V\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010BR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010BR\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010BR\u0016\u0010\\\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010BR\u0016\u0010]\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010BR\u0016\u0010_\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u00107R\u0016\u0010a\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u00107R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lav0/l;", "Lsh2/c$f;", "", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/mobileqq/qqgift/data/service/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", "B", "", "giftId", "", "giftName", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "effectLevel", "giftType", "giftNum", "", "hitSeq", "allHitCount", "price", "P", "(ILjava/lang/String;IIIIJILjava/lang/Integer;)V", "N", "I", BdhLogUtil.LogTag.Tag_Conn, "E", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "T", UserInfo.SEX_FEMALE, "", "f", "t", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "position", "h0", "w", "r", "u0", "O", "D", "isSuccess", "errCode", "errMsg", ICustomDataEditor.NUMBER_PARAM_1, "comboCnt", "cnt", "o1", "K", "d", "Z", "rechargeViewShowing", "e", "busId", "J", "roomId", tl.h.F, "realRoomType", "i", AppConstants.Key.COLUMN_MSG_SENDER_UIN, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "senderNick", "senderHead", "receiverUin", "receiverNick", "receiverHead", "Ljava/util/ArrayList;", "Lcom/tencent/icgame/game/gift/impl/timi/IGiftPanelExtBean;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "extBeanList", "H", "source", "gameType", "programmeId", "appId", "L", "traceDetail", "M", VirtualAppProxy.KEY_GAME_ID, "panelType", "subSceneId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "roomEnterId", BdhLogUtil.LogTag.Tag_Req, "roomType", GetAdInfoRequest.SOURCE_FROM, "itemType", "U", MiniChatConstants.MINI_APP_LANDSCAPE, "V", "isTablet", "Lnh2/c;", "W", "Lnh2/c;", "giftSdk", "Lsh2/c;", "X", "Lsh2/c;", "giftPanel", "Landroid/widget/FrameLayout;", "Y", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lb32/e;", "Lb32/e;", "liveRoomStatusListener", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "a0", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "audienceRoom", "Law0/b;", "b0", "Law0/b;", "fansGroupPendant", "Lwv0/a;", "c0", "Lwv0/a;", "batchGiftPendant", "d0", "Landroidx/fragment/app/FragmentActivity;", "hostActivity", "Landroidx/lifecycle/LifecycleEventObserver;", "e0", "Landroidx/lifecycle/LifecycleEventObserver;", "activityLifecycleObserver", "av0/l$c", "f0", "Lav0/l$c;", "payObserver", "<init>", "()V", "g0", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class l implements c.f {

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    private static WeakReference<l> f26983h0;

    /* renamed from: D, reason: from kotlin metadata */
    private long receiverUin;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArrayList<IGiftPanelExtBean> extBeanList;

    /* renamed from: N, reason: from kotlin metadata */
    private int panelType;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isTablet;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private nh2.c giftSdk;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private sh2.c giftPanel;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private FrameLayout rootView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private b32.e liveRoomStatusListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IAudienceRoom audienceRoom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean rechargeViewShowing;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity hostActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int busId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int realRoomType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long senderUin;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static ICGameGiftPanelConfig f26984i0 = new ICGameGiftPanelConfig(0, 1, null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String senderNick = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String senderHead = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String receiverNick = "";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String receiverHead = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String source = "";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String gameType = "";

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String programmeId = "";

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String appId = "";

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String traceDetail = "";

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String gameId = "";

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String subSceneId = "0";

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String roomEnterId = "";

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String roomType = "";

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String sourceFrom = "";

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String itemType = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aw0.b fansGroupPendant = new aw0.b();

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wv0.a batchGiftPendant = new wv0.a();

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LifecycleEventObserver activityLifecycleObserver = new LifecycleEventObserver() { // from class: av0.e
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            l.z(l.this, lifecycleOwner, event);
        }
    };

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c payObserver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b]\u0010^J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u00e4\u0001\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0007J\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0006R*\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u00102R\u0014\u00104\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b6\u00105R\u0014\u00107\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u00105R\u0014\u00109\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0014\u0010:\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0014\u0010;\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0014\u0010<\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b<\u00105R\u0014\u0010=\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0014\u0010>\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0014\u0010?\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b?\u00105R\u0014\u0010@\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u00105R\u0014\u0010A\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u00105R\u0014\u0010B\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u00105R\u0014\u0010C\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0014\u0010D\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bD\u00105R\u0014\u0010E\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bE\u00105R\u0014\u0010F\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bF\u00105R\u0014\u0010G\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bG\u00105R\u0014\u0010H\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bH\u00105R\u0014\u0010I\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bI\u00105R\u0014\u0010J\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bJ\u00105R\u0014\u0010K\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bK\u00105R\u0014\u0010L\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bL\u00105R\u0014\u0010M\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bM\u00105R\u0014\u0010N\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bN\u00105R\u0014\u0010O\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bO\u00105R\u0014\u0010P\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bP\u00105R\u0014\u0010Q\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bQ\u00105R\u0014\u0010R\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bR\u00105R\u0014\u0010S\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bS\u00105R\u0014\u0010T\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bT\u00105R\u0014\u0010U\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bU\u00105R\u0014\u0010V\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bV\u00105R\u0014\u0010W\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bW\u00102R\u0014\u0010X\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bX\u00102R\u0014\u0010Y\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bY\u00105R\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006_"}, d2 = {"Lav0/l$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "g", "", "landscape", "", "busId", "", "roomId", "realRoomType", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "senderNick", "senderHead", "receiverUin", "receiverNick", "receiverHead", "source", "gameType", "programmeId", "appId", "traceDetail", VirtualAppProxy.KEY_GAME_ID, "panelType", "subSceneId", "roomEnterId", GetAdInfoRequest.SOURCE_FROM, "itemType", "roomType", "Ljava/util/ArrayList;", "Lcom/tencent/icgame/game/gift/impl/timi/IGiftPanelExtBean;", "Lkotlin/collections/ArrayList;", "extBeanList", "e", "b", "c", "Ljava/lang/ref/WeakReference;", "Lav0/l;", "giftPanelRef", "Ljava/lang/ref/WeakReference;", "a", "()Ljava/lang/ref/WeakReference;", "d", "(Ljava/lang/ref/WeakReference;)V", "DEFAULT_COMBO_SEND_DELAY_TIME", "I", "ERROR_CODE_WEIXIN_ANCHOR", "EXT_ANCHOR_UID", "Ljava/lang/String;", "EXT_APP_ID", "EXT_BUS_ID", "EXT_EXT_DATA_LIST", "EXT_GAME_ID", "EXT_GAME_TYPE", "EXT_PANEL_TYPE", "EXT_PARAM_ANCHOR_UID", "EXT_PARAM_APP_VERSION", "EXT_PARAM_ITEM_TYPE", "EXT_PARAM_LANDSCAPE", "EXT_PARAM_OWNER_QQ", "EXT_PARAM_PROGRAM_ID", "EXT_PARAM_QQLIVE_ABTOKEN", "EXT_PARAM_QQLIVE_COMING_WAY", "EXT_PARAM_QQLIVE_START_SOURCE", "EXT_PARAM_ROOM_ENTER_ID", "EXT_PARAM_ROOM_ID", "EXT_PARAM_ROOM_TYPE", "EXT_PARAM_SOURCE_FROM", "EXT_PROGRAMME_ID", "EXT_RECEIVER_HEAD", "EXT_RECEIVER_NICK", "EXT_RECEIVER_UIN", "EXT_ROOM_ID", "EXT_ROOM_TYPE", "EXT_SENDER_HEAD", "EXT_SENDER_NICK", "EXT_SENDER_UIN", "EXT_SOURCE", "EXT_SUB_SCENE_ID", "EXT_TRACE_DETAIL", "KEY_SP_KEY_COUNT_DOWN_GIFT", "LAST_SEND", "PANEL_DISMISS_EVENT", "PANEL_SHOW_EVENT", "TAG", "Lav0/a;", "giftPanelConfig", "Lav0/a;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: av0.l$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void g(Activity activity, Intent intent) {
            if (activity instanceof FragmentActivity) {
                l lVar = new l();
                d(new WeakReference<>(lVar));
                lVar.T((FragmentActivity) activity, intent);
            }
        }

        @Nullable
        public final WeakReference<l> a() {
            return l.f26983h0;
        }

        public final void b() {
            l lVar;
            WeakReference<l> a16 = a();
            if (a16 != null && (lVar = a16.get()) != null) {
                lVar.F();
            }
        }

        public final void c() {
            Object configBean = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_GIFT_PANEL_CONFIG, ICGameGiftPanelConfig.class, new ICGameGiftPanelConfig(0, 1, null));
            Intrinsics.checkNotNullExpressionValue(configBean, "api(\n                IIC\u2026,ICGameGiftPanelConfig())");
            l.f26984i0 = (ICGameGiftPanelConfig) configBean;
            rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "initComboSendDelayTime", "config " + l.f26984i0);
        }

        public final void d(@Nullable WeakReference<l> weakReference) {
            l.f26983h0 = weakReference;
        }

        @JvmOverloads
        public final void e(@NotNull Activity activity, boolean landscape, int busId, long roomId, int realRoomType, long senderUin, @NotNull String senderNick, @NotNull String senderHead, long receiverUin, @NotNull String receiverNick, @NotNull String receiverHead, @NotNull String source, @NotNull String gameType, @NotNull String programmeId, @NotNull String appId, @Nullable String traceDetail, @NotNull String gameId, int panelType, int subSceneId, @NotNull String roomEnterId, @NotNull String sourceFrom, @NotNull String itemType, @NotNull String roomType, @Nullable ArrayList<IGiftPanelExtBean> extBeanList) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(senderNick, "senderNick");
            Intrinsics.checkNotNullParameter(senderHead, "senderHead");
            Intrinsics.checkNotNullParameter(receiverNick, "receiverNick");
            Intrinsics.checkNotNullParameter(receiverHead, "receiverHead");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(gameType, "gameType");
            Intrinsics.checkNotNullParameter(programmeId, "programmeId");
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(gameId, "gameId");
            Intrinsics.checkNotNullParameter(roomEnterId, "roomEnterId");
            Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
            Intrinsics.checkNotNullParameter(itemType, "itemType");
            Intrinsics.checkNotNullParameter(roomType, "roomType");
            Intent intent = new Intent();
            intent.putExtra("extra_business_id", busId);
            intent.putExtra("extra_room_id", roomId);
            intent.putExtra("extra_room_type", realRoomType);
            intent.putExtra("extra_sender_uin", senderUin);
            intent.putExtra("extra_sender_nick", senderNick);
            intent.putExtra("extra_sender_head", senderHead);
            intent.putExtra("extra_receiver_uin", receiverUin);
            intent.putExtra("extra_receiver_nick", receiverNick);
            intent.putExtra("extra_receiver_head", receiverHead);
            intent.putExtra("extra_source", source);
            intent.putExtra("extra_game_type", gameType);
            if (!TextUtils.isEmpty(programmeId)) {
                intent.putExtra("extra_programme_id", programmeId);
            } else {
                intent.putExtra("extra_programme_id", xw0.b.f448881a.p());
            }
            intent.putExtra("extra_app_id", appId);
            intent.putExtra("extra_trace_detail", traceDetail);
            intent.putExtra("extra_game_id", gameId);
            intent.putExtra("panel_type", panelType);
            intent.putExtra("sub_scene_id", subSceneId);
            intent.putExtra("room_enter_id", roomEnterId);
            intent.putExtra("source_from", sourceFrom);
            intent.putExtra("item_type", itemType);
            intent.putExtra("room_type", roomType);
            intent.putExtra(KuiklyLaunchParams.PARAM_IS_LANDSCAPE, landscape);
            intent.putExtra("extra_ext_data_list", extBeanList);
            intent.putExtra("public_fragment_window_feature", 1);
            nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(busId);
            if (sDKImpl == null) {
                rt0.a.INSTANCE.h("ICGameGift|ICGameGiftPanel", "start", "giftSdk is null!");
                return;
            }
            IQQGiftCountDownModule g16 = sDKImpl.g();
            if (g16 != null) {
                g16.j(IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_PANEL);
            }
            rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "start", "startGiftPanel busId:" + busId + " roomId:" + roomId + " realRoomType:" + realRoomType + " senderUin:" + senderUin + " senderNick:" + senderNick + " senderHead:" + senderHead + " receiverUin:" + receiverUin + " receiverNick:" + receiverNick + " receiverHead:" + receiverHead + " source:" + source + " gameType:" + gameType + " programmeId:" + programmeId + " appId:" + appId + " traceDetail:" + traceDetail + " gameId:" + gameId + " panelType:" + panelType + " subSceneId:" + subSceneId + " roomEnterId:" + roomEnterId + " sourceFrom:" + sourceFrom + " itemType:" + itemType + " roomType:" + roomType + " landscape:" + landscape + " ");
            if (extBeanList != null) {
                for (IGiftPanelExtBean iGiftPanelExtBean : extBeanList) {
                    rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "start", "extBean:" + iGiftPanelExtBean.getKey() + " value:" + iGiftPanelExtBean.getValue());
                }
            }
            g(activity, intent);
            com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f.f();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"av0/l$b", "Lb32/e;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "onRoomOpen", "onRoomClose", "onRoomPause", "onRoomResume", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements b32.e {
        b() {
        }

        @Override // b32.e
        public void onRoomClose(@NotNull QQLiveRoomStatusInfo info) {
            sh2.c cVar;
            Intrinsics.checkNotNullParameter(info, "info");
            rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "onRoomClose", "closeType:" + info.closeType + ", closeReason:" + info.closeReason);
            if (info.uin == xw0.b.f448881a.d() && (cVar = l.this.giftPanel) != null) {
                cVar.hide();
            }
        }

        @Override // b32.e
        public void onRoomOpen(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // b32.e
        public void onRoomPause(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // b32.e
        public void onRoomResume(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    private final List<com.tencent.mobileqq.qqgift.data.service.e> A() {
        List<com.tencent.mobileqq.qqgift.data.service.e> list;
        Object firstOrNull;
        List<com.tencent.mobileqq.qqgift.data.service.d> list2;
        String str;
        com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig;
        oh2.b a16;
        nh2.c cVar = this.giftSdk;
        if (cVar != null && (a16 = cVar.a()) != null) {
            list = a16.H();
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            com.tencent.mobileqq.qqgift.data.service.e eVar = (com.tencent.mobileqq.qqgift.data.service.e) firstOrNull;
            if (eVar != null && (list2 = eVar.f264898e) != null) {
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : list2) {
                    IQQGiftUtil iQQGiftUtil = (IQQGiftUtil) QRoute.api(IQQGiftUtil.class);
                    nh2.c cVar2 = this.giftSdk;
                    if (cVar2 != null && (sDKConfig = cVar2.getSDKConfig()) != null) {
                        str = Integer.valueOf(sDKConfig.f264972a).toString();
                    } else {
                        str = null;
                    }
                    boolean isQQGiftCountDowning = iQQGiftUtil.isQQGiftCountDowning(dVar, str);
                    if (dVar.G != null && isQQGiftCountDowning) {
                        arrayList2.add(dVar);
                    } else {
                        arrayList.add(dVar);
                    }
                }
                list2.clear();
                list2.addAll(arrayList);
                list2.addAll(arrayList2);
            }
        }
        return list;
    }

    private final com.tencent.mobileqq.qqgift.mvvm.business.data.b B() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true);
        if (this.isLandscape && !this.isTablet) {
            bVar.f264962j = -1;
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, ScreenUtil.SCREEN_WIDTH, 0.0f, new int[]{0, 0, Color.parseColor("#99191921"), Color.parseColor("#CC191921"), Color.parseColor("#F2191921"), Color.parseColor("#FF191921")}, new float[]{0.0f, 0.5f, 0.55f, 0.58f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            PaintDrawable paintDrawable = new PaintDrawable();
            paintDrawable.getPaint().setShader(linearGradient);
            bVar.f264959g = paintDrawable;
            bVar.f264961i = ScreenUtil.dip2px(40.0f);
            bVar.f264953a = 0;
            bVar.f264963k = true;
        } else {
            bVar.f264963k = false;
            bVar.f264953a = Color.parseColor("#191912");
        }
        bVar.f264956d = Color.parseColor("#0099FF");
        return bVar;
    }

    private final String C() {
        LiveRoomExtraInfo liveRoomExtraInfo;
        LiveRoomInfo liveRoomInfo;
        Bundle bundle;
        LiveInfo d16 = ((fu0.c) qx0.a.b(fu0.c.class)).s().d(this.roomId);
        String str = null;
        if (d16 != null && (liveRoomInfo = d16.roomInfo) != null && (bundle = liveRoomInfo.extData) != null) {
            liveRoomExtraInfo = (LiveRoomExtraInfo) bundle.getParcelable("live_room_extra_data");
        } else {
            liveRoomExtraInfo = null;
        }
        if (liveRoomExtraInfo != null) {
            str = liveRoomExtraInfo.C;
        }
        if (str == null) {
            return "";
        }
        Intrinsics.checkNotNull(liveRoomExtraInfo);
        String str2 = liveRoomExtraInfo.C;
        Intrinsics.checkNotNullExpressionValue(str2, "roomExtraInfo!!.comingWay");
        return str2;
    }

    private final String E() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    private final void G() {
        final View view;
        ViewGroup contentView;
        if (!this.isLandscape) {
            return;
        }
        sh2.c cVar = this.giftPanel;
        if (cVar != null && (contentView = cVar.getContentView()) != null) {
            view = contentView.getRootView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setSystemUiVisibility(2);
        }
        if (view != null) {
            view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: av0.f
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i3) {
                    l.H(l.this, view, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(l this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isLandscape) {
            return;
        }
        m.c(view);
    }

    private final void I() {
        this.liveRoomStatusListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(l this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftPanelEvent(this$0.roomId, 1, 0, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(l this$0, com.tencent.mobileqq.qqgift.data.service.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = dVar.f264874d;
        String str = dVar.f264876e;
        Intrinsics.checkNotNullExpressionValue(str, "data.giftName");
        this$0.P(i3, str, dVar.C, dVar.f264883i, dVar.f264881h, dVar.D, dVar.H, dVar.J, Integer.valueOf(dVar.f264878f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity fragmentActivity = this$0.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        QQToast.makeText(fragmentActivity.getApplicationContext(), R.string.zvo, 1).show();
    }

    private final void N() {
        IAudienceRoom iAudienceRoom = this.audienceRoom;
        if (iAudienceRoom != null && iAudienceRoom != null) {
            iAudienceRoom.unRegisterRoomStatusListener(this.liveRoomStatusListener);
        }
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            SimpleEventBus.getInstance().dispatchEvent(new TimiGiftPanelEvent(this.roomId, 2, cVar.getContentView().getWidth(), cVar.getContentView().getHeight()));
        }
        this.fansGroupPendant.i();
        FragmentActivity fragmentActivity = this.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        fragmentActivity.getLifecycle().removeObserver(this.activityLifecycleObserver);
    }

    private final void P(int giftId, String giftName, int materialId, int effectLevel, int giftType, int giftNum, long hitSeq, int allHitCount, Integer price) {
        long j3;
        rt0.a.INSTANCE.g("ICGameGift|ICGameGiftPanel", "onSendGiftSuccess", "giftId: " + giftId + " giftName: " + giftName + " materialId: " + materialId + " effectLevel: " + effectLevel + " giftType: " + giftType + " giftNum: " + giftNum + " hitSeq: " + hitSeq + " allHitCount: " + allHitCount + " sender: " + LogUtil.wrapLogUin(String.valueOf(this.senderUin)) + " senderHead: " + this.senderHead + " sendNick: " + this.senderNick + " receiver: " + LogUtil.wrapLogUin(String.valueOf(this.receiverUin)) + " receiverHead: " + this.receiverHead + " receiverNick: " + this.receiverNick);
        final GiftMessage giftMessage = new GiftMessage();
        giftMessage.effectLevel = effectLevel;
        giftMessage.giftID = giftId;
        giftMessage.giftName = giftName;
        giftMessage.materialID = materialId;
        giftMessage.giftType = giftType;
        giftMessage.giftNum = giftNum;
        giftMessage.sender = this.senderUin;
        giftMessage.senderHead = this.senderHead;
        giftMessage.senderNick = this.senderNick;
        giftMessage.receiverNick = this.receiverNick;
        giftMessage.receiverHead = this.receiverHead;
        if (price != null) {
            j3 = price.intValue();
        } else {
            j3 = 0;
        }
        giftMessage.giftPrice = j3;
        giftMessage.comboSeq = hitSeq;
        giftMessage.allComboCnt = allHitCount;
        sh2.c cVar = this.giftPanel;
        if (cVar != null && giftType == 1 && (effectLevel == 1 || effectLevel == 2)) {
            if (cVar != null) {
                cVar.hide();
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: av0.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.Q(GiftMessage.this, this);
                }
            }, 500L);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: av0.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.R(GiftMessage.this, this);
                }
            });
        }
        this.fansGroupPendant.n(this.batchGiftPendant.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(GiftMessage giftMessage, l this$0) {
        Intrinsics.checkNotNullParameter(giftMessage, "$giftMessage");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftEvent(giftMessage, this$0.roomId, this$0.busId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(GiftMessage giftMessage, l this$0) {
        Intrinsics.checkNotNullParameter(giftMessage, "$giftMessage");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftEvent(giftMessage, this$0.roomId, this$0.busId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        boolean z16;
        IQQGiftRechargeModule f16;
        sh2.c cVar;
        ph2.a d16;
        nh2.c cVar2 = this.giftSdk;
        if (cVar2 != null) {
            boolean z17 = false;
            if (cVar2 != null && !cVar2.isDestroyed()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.giftPanel == null) {
                    nh2.c cVar3 = this.giftSdk;
                    c.f fVar = null;
                    if (cVar3 != null && (d16 = cVar3.d()) != null) {
                        FragmentActivity fragmentActivity = this.hostActivity;
                        if (fragmentActivity == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                            fragmentActivity = null;
                        }
                        cVar = d16.l(fragmentActivity, 1);
                    } else {
                        cVar = null;
                    }
                    this.giftPanel = cVar;
                    if (cVar != null) {
                        if (cVar != null) {
                            fVar = cVar.l(this);
                        }
                        cVar.setPanelEventListener(fVar);
                    }
                }
                com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a();
                aVar.f264855a = this.panelType;
                aVar.f264856b = this.source;
                aVar.f264857c = this.gameType;
                aVar.f264858d = String.valueOf(this.receiverUin);
                sh2.c cVar4 = this.giftPanel;
                if (cVar4 != null) {
                    cVar4.setSceneData(aVar);
                }
                com.tencent.mobileqq.qqgift.mvvm.business.data.b B = B();
                sh2.c cVar5 = this.giftPanel;
                if (cVar5 != null) {
                    cVar5.setPanelStyle(B);
                }
                sh2.c cVar6 = this.giftPanel;
                if (cVar6 != null) {
                    com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar2 = new com.tencent.mobileqq.qqgift.mvvm.business.data.a();
                    String str = this.traceDetail;
                    aVar2.f264934a = str;
                    if (TextUtils.isEmpty(str)) {
                        aVar2.f264934a = xw0.b.f448881a.l();
                    }
                    aVar2.f264935b = String.valueOf(this.senderUin);
                    aVar2.f264936c = String.valueOf(this.receiverUin);
                    aVar2.f264937d = String.valueOf(this.roomId);
                    aVar2.f264938e = this.programmeId;
                    aVar2.f264939f = "0";
                    aVar2.f264940g = this.gameId;
                    aVar2.f264941h = this.appId;
                    aVar2.f264942i = "0";
                    aVar2.f264943j = this.subSceneId;
                    String C = C();
                    if (C == null) {
                        C = "";
                    }
                    aVar2.f264948o = C;
                    aVar2.f264949p = aVar2.f264946m;
                    aVar2.f264950q = aVar2.f264934a;
                    cVar6.setDtParams(aVar2);
                }
                nh2.c cVar7 = this.giftSdk;
                if (cVar7 != null && (f16 = cVar7.f()) != null) {
                    f16.y(this.payObserver);
                }
                sh2.c cVar8 = this.giftPanel;
                if (cVar8 != null) {
                    cVar8.setCacheTabList(A());
                }
                sh2.c cVar9 = this.giftPanel;
                if (cVar9 != null) {
                    cVar9.setComboSendDelayTime(f26984i0.getComboSendDelayTime());
                }
                a.Companion companion = rt0.a.INSTANCE;
                companion.k("ICGameGift|ICGameGiftPanel", "openGiftPanel", "isLandscape:" + this.isLandscape);
                FrameLayout frameLayout = this.rootView;
                if (frameLayout != null) {
                    sh2.c cVar10 = this.giftPanel;
                    if (cVar10 != null) {
                        if (this.isLandscape && !this.isTablet) {
                            z17 = true;
                        }
                        cVar10.h(frameLayout, true, z17);
                    }
                    G();
                    return;
                }
                companion.h("ICGameGift|ICGameGiftPanel", "openGiftPanel", "rootView is null!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(l this$0, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Lifecycle.Event.ON_RESUME == event) {
            this$0.K();
        }
    }

    @Override // sh2.c.f
    public boolean D() {
        if (this.isLandscape && !this.isTablet) {
            F();
        }
        this.rechargeViewShowing = true;
        return false;
    }

    public final void F() {
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            cVar.hide();
        }
    }

    public final void K() {
        this.fansGroupPendant.j();
    }

    @Override // sh2.c.f
    public boolean O(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        oh2.b bVar;
        FragmentActivity fragmentActivity;
        String str;
        FragmentActivity fragmentActivity2;
        if (data == null) {
            rt0.a.INSTANCE.h("ICGameGift|ICGameGiftPanel", "onSendGiftClick", "GiftServiceData is null");
            return true;
        }
        rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "onSendGiftClick", data + " " + position);
        if (this.fansGroupPendant.m(data)) {
            return true;
        }
        if (this.receiverUin <= 0) {
            if (Intrinsics.areEqual(zu0.a.f453416a.b(), Boolean.TRUE)) {
                str = "\u6536\u793c\u4eba\u4e0d\u5728\u53f0\u4e0a\uff0c\u8bf7\u9009\u62e9\u9001\u793c\u5bf9\u8c61";
            } else {
                str = "\u8bf7\u9009\u62e9\u9001\u793c\u5bf9\u8c61";
            }
            FragmentActivity fragmentActivity3 = this.hostActivity;
            if (fragmentActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                fragmentActivity2 = null;
            } else {
                fragmentActivity2 = fragmentActivity3;
            }
            QQToast.makeText(fragmentActivity2.getApplicationContext(), 1, str, 0).show();
            return true;
        }
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        cVar.f264860a = this.senderUin;
        cVar.f264861b = this.receiverUin;
        ConcurrentHashMap<String, String> concurrentHashMap = cVar.f264870k;
        Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "giftSendReqData.extData");
        concurrentHashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.roomId));
        ArrayList<IGiftPanelExtBean> arrayList = this.extBeanList;
        if (arrayList != null) {
            for (IGiftPanelExtBean iGiftPanelExtBean : arrayList) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = cVar.f264870k;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap2, "giftSendReqData.extData");
                concurrentHashMap2.put(iGiftPanelExtBean.getKey(), iGiftPanelExtBean.getValue());
            }
        }
        if (Intrinsics.areEqual(cVar.f264870k.get("AnchorUID"), "0")) {
            FragmentActivity fragmentActivity4 = this.hostActivity;
            if (fragmentActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                fragmentActivity = null;
            } else {
                fragmentActivity = fragmentActivity4;
            }
            QQToast.makeText(fragmentActivity.getApplicationContext(), 1, "\u6570\u636e\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            return true;
        }
        if (!TextUtils.isEmpty(this.roomEnterId)) {
            ConcurrentHashMap<String, String> concurrentHashMap3 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap3, "giftSendReqData.reportExt");
            concurrentHashMap3.put("program_id", this.programmeId);
            ConcurrentHashMap<String, String> concurrentHashMap4 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap4, "giftSendReqData.reportExt");
            concurrentHashMap4.put("anchor_uid", String.valueOf(this.receiverUin));
            ConcurrentHashMap<String, String> concurrentHashMap5 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap5, "giftSendReqData.reportExt");
            concurrentHashMap5.put("roomid", String.valueOf(this.roomId));
            ConcurrentHashMap<String, String> concurrentHashMap6 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap6, "giftSendReqData.reportExt");
            concurrentHashMap6.put("room_type", this.roomType);
            ConcurrentHashMap<String, String> concurrentHashMap7 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap7, "giftSendReqData.reportExt");
            concurrentHashMap7.put("room_enter_id", this.roomEnterId);
            ConcurrentHashMap<String, String> concurrentHashMap8 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap8, "giftSendReqData.reportExt");
            concurrentHashMap8.put("source_from", this.sourceFrom);
            ConcurrentHashMap<String, String> concurrentHashMap9 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap9, "giftSendReqData.reportExt");
            concurrentHashMap9.put("item_type", this.itemType);
            ConcurrentHashMap<String, String> concurrentHashMap10 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap10, "giftSendReqData.reportExt");
            concurrentHashMap10.put("ownerqq", String.valueOf(this.receiverUin));
            ConcurrentHashMap<String, String> concurrentHashMap11 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap11, "giftSendReqData.reportExt");
            concurrentHashMap11.put("qqlive_start_source", this.appId);
            ConcurrentHashMap<String, String> concurrentHashMap12 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap12, "giftSendReqData.reportExt");
            concurrentHashMap12.put("app_version", E());
            ConcurrentHashMap<String, String> concurrentHashMap13 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap13, "giftSendReqData.reportExt");
            concurrentHashMap13.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, this.traceDetail);
            ConcurrentHashMap<String, String> concurrentHashMap14 = cVar.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap14, "giftSendReqData.reportExt");
            concurrentHashMap14.put("qqlive_coming_way", C());
        }
        rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "onSendGiftClick", "senderUin:" + this.senderUin + " receiverUin:" + this.receiverUin + " roomId:" + this.roomId + " programmeId:" + this.programmeId + " roomType:" + this.roomType + " roomEnterId:" + this.roomEnterId + " sourceFrom:" + this.sourceFrom + " itemType:" + this.itemType + " appId:" + this.appId + " versionName:" + E() + " traceDetail:" + this.traceDetail + " comingWay:" + C());
        ArrayList<IGiftPanelExtBean> arrayList2 = this.extBeanList;
        if (arrayList2 != null) {
            for (IGiftPanelExtBean iGiftPanelExtBean2 : arrayList2) {
                rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "onSendGiftClick", "real send ext, key:" + iGiftPanelExtBean2.getKey() + " val:" + iGiftPanelExtBean2.getValue());
            }
        }
        nh2.c cVar2 = this.giftSdk;
        if (cVar2 != null) {
            bVar = cVar2.a();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.Q(cVar);
            return false;
        }
        return false;
    }

    public final void T(@NotNull FragmentActivity activity, @NotNull Intent intent) {
        ArrayList<IGiftPanelExtBean> arrayList;
        ViewGroup.LayoutParams layoutParams;
        IAudienceRoom N;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.hostActivity = activity;
        this.busId = intent.getIntExtra("extra_business_id", 0);
        this.roomId = intent.getLongExtra("extra_room_id", 0L);
        this.realRoomType = intent.getIntExtra("extra_room_type", 0);
        this.senderUin = intent.getLongExtra("extra_sender_uin", 0L);
        String stringExtra = intent.getStringExtra("extra_sender_nick");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(EXT_SENDER_NICK) ?: \"\"");
        }
        this.senderNick = stringExtra;
        String stringExtra2 = intent.getStringExtra("extra_sender_head");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra2, "getStringExtra(EXT_SENDER_HEAD) ?: \"\"");
        }
        this.senderHead = stringExtra2;
        this.receiverUin = intent.getLongExtra("extra_receiver_uin", 0L);
        String stringExtra3 = intent.getStringExtra("extra_receiver_nick");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra3, "getStringExtra(EXT_RECEIVER_NICK) ?: \"\"");
        }
        this.receiverNick = stringExtra3;
        String stringExtra4 = intent.getStringExtra("extra_receiver_head");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra4, "getStringExtra(EXT_RECEIVER_HEAD) ?: \"\"");
        }
        this.receiverHead = stringExtra4;
        String stringExtra5 = intent.getStringExtra("extra_source");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra5, "getStringExtra(EXT_SOURCE) ?: \"\"");
        }
        this.source = stringExtra5;
        String stringExtra6 = intent.getStringExtra("extra_game_type");
        if (stringExtra6 == null) {
            stringExtra6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra6, "getStringExtra(EXT_GAME_TYPE) ?: \"\"");
        }
        this.gameType = stringExtra6;
        String stringExtra7 = intent.getStringExtra("extra_programme_id");
        if (stringExtra7 == null) {
            stringExtra7 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra7, "getStringExtra(EXT_PROGRAMME_ID) ?: \"\"");
        }
        this.programmeId = stringExtra7;
        String stringExtra8 = intent.getStringExtra("extra_app_id");
        if (stringExtra8 == null) {
            stringExtra8 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra8, "getStringExtra(EXT_APP_ID) ?: \"\"");
        }
        this.appId = stringExtra8;
        String stringExtra9 = intent.getStringExtra("extra_trace_detail");
        if (stringExtra9 == null) {
            stringExtra9 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra9, "getStringExtra(EXT_TRACE_DETAIL) ?: \"\"");
        }
        this.traceDetail = stringExtra9;
        if (TextUtils.isEmpty(stringExtra9)) {
            this.traceDetail = xw0.b.f448881a.l();
        }
        String stringExtra10 = intent.getStringExtra("extra_game_id");
        if (stringExtra10 == null) {
            stringExtra10 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra10, "getStringExtra(EXT_GAME_ID) ?: \"\"");
        }
        this.gameId = stringExtra10;
        this.panelType = intent.getIntExtra("panel_type", 2);
        this.subSceneId = String.valueOf(intent.getIntExtra("sub_scene_id", 0));
        String stringExtra11 = intent.getStringExtra("room_enter_id");
        if (stringExtra11 == null) {
            stringExtra11 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra11, "getStringExtra(EXT_PARAM_ROOM_ENTER_ID) ?: \"\"");
        }
        this.roomEnterId = stringExtra11;
        String stringExtra12 = intent.getStringExtra("room_type");
        if (stringExtra12 == null) {
            stringExtra12 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra12, "getStringExtra(EXT_PARAM_ROOM_TYPE) ?: \"\"");
        }
        this.roomType = stringExtra12;
        String stringExtra13 = intent.getStringExtra("source_from");
        if (stringExtra13 == null) {
            stringExtra13 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(stringExtra13, "getStringExtra(EXT_PARAM_SOURCE_FROM) ?: \"\"");
        }
        this.sourceFrom = stringExtra13;
        String stringExtra14 = intent.getStringExtra("item_type");
        if (stringExtra14 != null) {
            Intrinsics.checkNotNullExpressionValue(stringExtra14, "getStringExtra(EXT_PARAM_ITEM_TYPE) ?: \"\"");
            str = stringExtra14;
        }
        this.itemType = str;
        this.isLandscape = intent.getBooleanExtra(KuiklyLaunchParams.PARAM_IS_LANDSCAPE, false);
        Serializable serializableExtra = intent.getSerializableExtra("extra_ext_data_list");
        FragmentActivity fragmentActivity = null;
        if (serializableExtra instanceof ArrayList) {
            arrayList = (ArrayList) serializableExtra;
        } else {
            arrayList = null;
        }
        this.extBeanList = arrayList;
        IVasTempApi iVasTempApi = (IVasTempApi) QRoute.api(IVasTempApi.class);
        FragmentActivity fragmentActivity2 = this.hostActivity;
        if (fragmentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity2 = null;
        }
        Context applicationContext = fragmentActivity2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "hostActivity.applicationContext");
        this.isTablet = iVasTempApi.isTabletDevice(applicationContext);
        I();
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        if (cVar != null && (N = cVar.N(this.roomId)) != null) {
            N.registerRoomStatusListener(this.liveRoomStatusListener);
        }
        this.giftSdk = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(this.busId);
        FragmentActivity fragmentActivity3 = this.hostActivity;
        if (fragmentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity3 = null;
        }
        FrameLayout frameLayout = new FrameLayout(fragmentActivity3);
        this.rootView = frameLayout;
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
        }
        FrameLayout frameLayout2 = this.rootView;
        if (frameLayout2 != null) {
            layoutParams = frameLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        S();
        fragmentActivity3.getLifecycle().removeObserver(this.activityLifecycleObserver);
        fragmentActivity3.getLifecycle().addObserver(this.activityLifecycleObserver);
        wv0.a aVar = this.batchGiftPendant;
        FragmentActivity fragmentActivity4 = this.hostActivity;
        if (fragmentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
        } else {
            fragmentActivity = fragmentActivity4;
        }
        aVar.j(fragmentActivity, this.roomId);
    }

    @Override // sh2.c.f
    public boolean f() {
        int i3;
        LinearLayout linearLayout;
        LinearLayout k3;
        rt0.a.INSTANCE.j("ICGameGift|ICGameGiftPanel", VasPerfReportUtils.WHILE_ON_PANEL_SHOW);
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            if (cVar != null) {
                cVar.setOnPanelContentHeightChangeListener(new c.e() { // from class: av0.i
                    @Override // sh2.c.e
                    public final void a(int i16, int i17) {
                        l.J(l.this, i16, i17);
                    }
                });
            }
            sh2.c cVar2 = this.giftPanel;
            if (cVar2 != null && (k3 = cVar2.k()) != null) {
                k3.setBackgroundColor(0);
            }
            aw0.b bVar = this.fansGroupPendant;
            int i16 = this.busId;
            long j3 = this.roomId;
            int i17 = this.realRoomType;
            long j16 = this.receiverUin;
            fu0.c cVar3 = (fu0.c) qx0.a.b(fu0.c.class);
            sh2.c cVar4 = this.giftPanel;
            if (cVar4 != null) {
                linearLayout = cVar4.k();
            } else {
                linearLayout = null;
            }
            bVar.k(i16, j3, i17, j16, cVar3, linearLayout);
        }
        sh2.c cVar5 = this.giftPanel;
        if (cVar5 != null) {
            i3 = cVar5.hashCode();
        } else {
            i3 = 0;
        }
        com.tencent.icgame.game.liveroom.impl.room.followguide.a.c(i3, true);
        return false;
    }

    @Override // sh2.c.f
    public boolean h0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        return false;
    }

    @Override // sh2.c.f
    public boolean n1(boolean isSuccess, @Nullable final com.tencent.mobileqq.qqgift.data.service.d data, int errCode, @NotNull String errMsg) {
        String str;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        a.Companion companion = rt0.a.INSTANCE;
        if (data != null) {
            str = data.toString();
        } else {
            str = null;
        }
        companion.k("ICGameGift|ICGameGiftPanel", "onSendGiftCallback", isSuccess + " " + errCode + " data=" + str);
        if (isSuccess && data != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: av0.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.L(l.this, data);
                }
            });
            return false;
        }
        if (errCode == -10013) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: av0.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.M(l.this);
                }
            });
            return false;
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean r(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        List<d.a> list;
        boolean z16;
        List<d.a> list2;
        LinearLayout linearLayout = null;
        if (data != null) {
            list = data.P;
        } else {
            list = null;
        }
        if (list != null) {
            if (data != null && (list2 = data.P) != null && list2.size() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                rt0.a.INSTANCE.h("ICGameGift|ICGameGiftPanel", "onPanelItemTripleClick", "showBatchGiftPendant");
                this.fansGroupPendant.o(data, false, position);
                wv0.a aVar = this.batchGiftPendant;
                sh2.c cVar = this.giftPanel;
                if (cVar != null) {
                    linearLayout = cVar.k();
                }
                aVar.p(data, linearLayout, 2);
                wv0.b.f446564a.b(data.f264874d, 2);
            }
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean t() {
        int i3;
        rt0.a.INSTANCE.j("ICGameGift|ICGameGiftPanel", "onPanelHide");
        N();
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            i3 = cVar.hashCode();
        } else {
            i3 = 0;
        }
        com.tencent.icgame.game.liveroom.impl.room.followguide.a.c(i3, false);
        return false;
    }

    @Override // sh2.c.f
    public boolean u0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        if (data == null) {
            rt0.a.INSTANCE.h("ICGameGift|ICGameGiftPanel", "onPanelItemSelected", "GiftServiceData is null");
        } else {
            rt0.a.INSTANCE.k("ICGameGift|ICGameGiftPanel", "onPanelItemSelected", data + " " + position);
        }
        if (!this.batchGiftPendant.q(data) && !this.fansGroupPendant.l(data, position)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sh2.c.f
    public boolean w(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        List<d.a> list;
        byte b16;
        List<d.a> list2;
        FragmentActivity fragmentActivity = null;
        LinearLayout linearLayout = null;
        if (data != null) {
            list = data.P;
        } else {
            list = null;
        }
        if (list != null) {
            if (data != null && (list2 = data.P) != null && list2.size() == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                rt0.a.INSTANCE.h("ICGameGift|ICGameGiftPanel", "onPanelItemLongClick", "showBatchGiftPendant");
                this.fansGroupPendant.o(data, false, position);
                wv0.a aVar = this.batchGiftPendant;
                sh2.c cVar = this.giftPanel;
                if (cVar != null) {
                    linearLayout = cVar.k();
                }
                aVar.p(data, linearLayout, 1);
                wv0.b.f446564a.b(data.f264874d, 1);
                return false;
            }
        }
        FragmentActivity fragmentActivity2 = this.hostActivity;
        if (fragmentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
        } else {
            fragmentActivity = fragmentActivity2;
        }
        QQToast.makeText(fragmentActivity.getApplicationContext(), R.string.f199694q4, 1).show();
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"av0/l$c", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements IVasNativePayManager.PayObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            ViewGroup.LayoutParams layoutParams;
            if (l.this.rechargeViewShowing && l.this.isLandscape && !l.this.isTablet) {
                FragmentActivity fragmentActivity = l.this.hostActivity;
                ViewGroup.LayoutParams layoutParams2 = null;
                if (fragmentActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                    fragmentActivity = null;
                }
                l lVar = l.this;
                lVar.rootView = new FrameLayout(fragmentActivity);
                FrameLayout frameLayout = lVar.rootView;
                if (frameLayout != null) {
                    layoutParams = frameLayout.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.width = -2;
                }
                FrameLayout frameLayout2 = lVar.rootView;
                if (frameLayout2 != null) {
                    layoutParams2 = frameLayout2.getLayoutParams();
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = -2;
                }
                lVar.S();
                fragmentActivity.getLifecycle().removeObserver(lVar.activityLifecycleObserver);
                fragmentActivity.getLifecycle().addObserver(lVar.activityLifecycleObserver);
            }
            l.this.rechargeViewShowing = false;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
        }
    }

    @Override // sh2.c.f
    public void o1(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int comboCnt, int cnt) {
    }
}
