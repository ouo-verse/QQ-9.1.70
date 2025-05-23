package com.tencent.timi.game.gift.impl.timi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
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
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftUtil;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog;
import com.tencent.timi.game.liveroom.impl.room.effectcombo.EffectGiftSendEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sh2.c;
import yi4.a;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002\u0090\u0001\u0018\u0000 \u0096\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\"B\t\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ*\u0010\u0014\u001a\u00020\t2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010 \u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010#\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J*\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\rH\u0016J*\u0010,\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u000bH\u0016J\"\u0010-\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001bH\u0016J*\u00102\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u00192\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001bH\u0016J\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020\tJ\b\u00105\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\u0010\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107H\u0002J\b\u0010:\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020;H\u0002J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010>\u001a\u00020=H\u0002JY\u0010H\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001bH\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010K\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0019H\u0002J\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\rH\u0002J\n\u0010N\u001a\u0004\u0018\u00010\rH\u0002J8\u0010Q\u001a\u00020\t2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001bH\u0002R\u0016\u0010T\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010KR\u0016\u0010Z\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010VR\u0016\u0010\\\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010KR\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010^R\u0016\u0010a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010KR\u0016\u0010b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010^R\u0016\u0010c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010^R*\u0010h\u001a\u0016\u0012\u0004\u0012\u00020e\u0018\u00010dj\n\u0012\u0004\u0012\u00020e\u0018\u0001`f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010gR\u0016\u0010i\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010^R\u0016\u0010j\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010^R\u0016\u0010k\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010^R\u0016\u0010l\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010^R\u0016\u0010m\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010^R\u0016\u0010n\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010^R\u0016\u0010p\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010VR\u0016\u0010q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010^R\u0016\u0010s\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010^R\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010^R\u0016\u0010v\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010^R\u0016\u0010w\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010^R\u0016\u0010y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010SR\u0018\u0010|\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010{R\u0018\u0010\u007f\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010~R\u001b\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bQ\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\n\u0010\u0084\u0001R\u0017\u0010\u0088\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bS\u0010\u0087\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanel;", "Lsh2/c$f;", "Lsh2/c$g;", "Lyi4/a$b;", "Lsh2/c$d;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "Y", "", "newReceiveUid", "", "newReceiveNick", "newReceiveHeadUrl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "W", "G", "", "f", "t", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "", "position", "h0", "w", "r", "u0", "tabId", "a", "O", "D", "isSuccess", "errCode", "errMsg", ICustomDataEditor.NUMBER_PARAM_1, "comboCnt", "allComboCnt", "hitSeq", "c", "o1", "actionedGiftInfo", "curComboSeq", "lastComboNum", "lastAllComboNum", "b", "P", "M", "V", "K", "", "Lcom/tencent/mobileqq/qqgift/data/service/e;", "B", "H", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/api/auth/AuthScene;", "authScene", "L", "giftId", "giftName", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "effectLevel", "giftType", "giftNum", "allHitCount", "price", "T", "(ILjava/lang/String;IIIIJILjava/lang/Integer;)V", "giftData", "J", ExifInterface.LATITUDE_SOUTH, "E", UserInfo.SEX_FEMALE, "action", "info", "X", "d", "Z", "rechargeViewShowing", "e", "I", "busId", "roomId", tl.h.F, "realRoomType", "i", AppConstants.Key.COLUMN_MSG_SENDER_UIN, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "senderNick", "senderHead", "receiverUin", "receiverNick", "receiverHead", "Ljava/util/ArrayList;", "Lcom/tencent/timi/game/gift/impl/timi/IGiftPanelExtBean;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "extBeanList", "source", "gameType", "programmeId", "appId", "traceDetail", VirtualAppProxy.KEY_GAME_ID, "N", "panelType", "subSceneId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "roomEnterId", BdhLogUtil.LogTag.Tag_Req, "roomType", GetAdInfoRequest.SOURCE_FROM, "itemType", "U", "isTablet", "Lnh2/c;", "Lnh2/c;", "giftSdk", "Lsh2/c;", "Lsh2/c;", "giftPanel", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lij4/b;", "Lij4/b;", "fansGroupPendant", "Lyi4/a;", "Lyi4/a;", "batchGiftPendant", "a0", "Landroidx/fragment/app/FragmentActivity;", "hostActivity", "Landroidx/lifecycle/LifecycleEventObserver;", "b0", "Landroidx/lifecycle/LifecycleEventObserver;", "activityLifecycleObserver", "com/tencent/timi/game/gift/impl/timi/TimiGiftPanel$c", "c0", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanel$c;", "payObserver", "<init>", "()V", "d0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGiftPanel implements c.f, c.g, a.b, c.d {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e0, reason: collision with root package name */
    @Nullable
    private static WeakReference<FragmentActivity> f377121e0;

    /* renamed from: f0, reason: collision with root package name */
    @Nullable
    private static WeakReference<TimiGiftPanel> f377122f0;

    /* renamed from: D, reason: from kotlin metadata */
    private long receiverUin;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArrayList<IGiftPanelExtBean> extBeanList;

    /* renamed from: N, reason: from kotlin metadata */
    private int panelType;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isTablet;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private nh2.c giftSdk;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private sh2.c giftPanel;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private FrameLayout rootView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FragmentActivity hostActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean rechargeViewShowing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int busId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int realRoomType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long senderUin;

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

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private ij4.b fansGroupPendant = new ij4.b();

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final yi4.a batchGiftPendant = new yi4.a();

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LifecycleEventObserver activityLifecycleObserver = new LifecycleEventObserver() { // from class: com.tencent.timi.game.gift.impl.timi.m
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            TimiGiftPanel.z(TimiGiftPanel.this, lifecycleOwner, event);
        }
    };

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c payObserver = new c();

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\be\u0010fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u00e4\u0001\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0007J\u001e\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J*\u0010.\u001a\u00020\u00062\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100+j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`,J\u0006\u0010/\u001a\u00020\u0006R*\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u0014\u0010<\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u0010?R\u0014\u0010A\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0014\u0010B\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010?R\u0014\u0010C\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0014\u0010D\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bD\u0010?R\u0014\u0010E\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u0014\u0010F\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bF\u0010?R\u0014\u0010G\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bG\u0010?R\u0014\u0010H\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bH\u0010?R\u0014\u0010I\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bI\u0010?R\u0014\u0010J\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bJ\u0010?R\u0014\u0010K\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bK\u0010?R\u0014\u0010L\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bL\u0010?R\u0014\u0010M\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bM\u0010?R\u0014\u0010N\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bN\u0010?R\u0014\u0010O\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bO\u0010?R\u0014\u0010P\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bP\u0010?R\u0014\u0010Q\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bQ\u0010?R\u0014\u0010R\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bR\u0010?R\u0014\u0010S\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bS\u0010?R\u0014\u0010T\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bT\u0010?R\u0014\u0010U\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bU\u0010?R\u0014\u0010V\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bV\u0010?R\u0014\u0010W\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bW\u0010?R\u0014\u0010X\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bX\u0010?R\u0014\u0010Y\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bY\u0010?R\u0014\u0010Z\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bZ\u0010?R\u0014\u0010[\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b[\u0010?R\u0014\u0010\\\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\\\u0010?R\u0014\u0010]\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b]\u0010?R\u0014\u0010^\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b^\u0010?R\u0014\u0010_\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b_\u0010?R\u0014\u0010`\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b`\u0010?R\u0014\u0010a\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\ba\u0010?R\u0014\u0010b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bb\u0010=R\u0014\u0010c\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bc\u0010=R\u0014\u0010d\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bd\u0010?\u00a8\u0006g"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanel$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "i", "", "landscape", "", "busId", "", "roomId", "realRoomType", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "senderNick", "senderHead", "receiverUin", "receiverNick", "receiverHead", "source", "gameType", "programmeId", "appId", "traceDetail", VirtualAppProxy.KEY_GAME_ID, "panelType", "subSceneId", "roomEnterId", GetAdInfoRequest.SOURCE_FROM, "itemType", "roomType", "Ljava/util/ArrayList;", "Lcom/tencent/timi/game/gift/impl/timi/IGiftPanelExtBean;", "Lkotlin/collections/ArrayList;", "extBeanList", "g", "newReceiveUid", "newReceiveNick", "newReceiveHeadUrl", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "d", "c", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "activityRef", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "e", "(Ljava/lang/ref/WeakReference;)V", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanel;", "giftPanelRef", "b", "f", "ERROR_CODE_WEIXIN_ANCHOR", "I", "EXT_ANCHOR_UID", "Ljava/lang/String;", "EXT_APP_ID", "EXT_BUS_ID", "EXT_EXT_DATA_LIST", "EXT_GAME_ID", "EXT_GAME_TYPE", "EXT_PANEL_TYPE", "EXT_PARAM_ANCHOR_UID", "EXT_PARAM_APP_VERSION", "EXT_PARAM_ITEM_TYPE", "EXT_PARAM_LANDSCAPE", "EXT_PARAM_OWNER_QQ", "EXT_PARAM_PROGRAM_ID", "EXT_PARAM_QQLIVE_ABTOKEN", "EXT_PARAM_QQLIVE_COMING_WAY", "EXT_PARAM_QQLIVE_START_SOURCE", "EXT_PARAM_ROOM_ENTER_ID", "EXT_PARAM_ROOM_ID", "EXT_PARAM_ROOM_TYPE", "EXT_PARAM_SOURCE_FROM", "EXT_PROGRAMME_ID", "EXT_RECEIVER_HEAD", "EXT_RECEIVER_NICK", "EXT_RECEIVER_UIN", "EXT_ROOM_ID", "EXT_ROOM_TYPE", "EXT_SENDER_HEAD", "EXT_SENDER_NICK", "EXT_SENDER_UIN", "EXT_SOURCE", "EXT_SUB_SCENE_ID", "EXT_TRACE_DETAIL", "KEY_SP_KEY_COUNT_DOWN_GIFT", "LAST_SEND", "MONITOR_TAG", "PANEL_DISMISS_EVENT", "PANEL_SHOW_EVENT", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.gift.impl.timi.TimiGiftPanel$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void i(Activity activity, Intent intent) {
            if (activity instanceof FragmentActivity) {
                e(new WeakReference<>(activity));
                TimiGiftPanel timiGiftPanel = new TimiGiftPanel();
                f(new WeakReference<>(timiGiftPanel));
                timiGiftPanel.Y((FragmentActivity) activity, intent);
            }
        }

        public final void a(long newReceiveUid, @NotNull String newReceiveNick, @NotNull String newReceiveHeadUrl) {
            TimiGiftPanel timiGiftPanel;
            Intrinsics.checkNotNullParameter(newReceiveNick, "newReceiveNick");
            Intrinsics.checkNotNullParameter(newReceiveHeadUrl, "newReceiveHeadUrl");
            WeakReference<TimiGiftPanel> b16 = b();
            if (b16 != null && (timiGiftPanel = b16.get()) != null) {
                timiGiftPanel.A(newReceiveUid, newReceiveNick, newReceiveHeadUrl);
            }
        }

        @Nullable
        public final WeakReference<TimiGiftPanel> b() {
            return TimiGiftPanel.f377122f0;
        }

        public final void c() {
            TimiGiftPanel timiGiftPanel;
            WeakReference<TimiGiftPanel> b16 = b();
            if (b16 != null && (timiGiftPanel = b16.get()) != null) {
                timiGiftPanel.G();
            }
        }

        public final void d(@NotNull HashMap<String, String> map) {
            TimiGiftPanel timiGiftPanel;
            Intrinsics.checkNotNullParameter(map, "map");
            WeakReference<TimiGiftPanel> b16 = b();
            if (b16 != null && (timiGiftPanel = b16.get()) != null) {
                timiGiftPanel.W(map);
            }
        }

        public final void e(@Nullable WeakReference<FragmentActivity> weakReference) {
            TimiGiftPanel.f377121e0 = weakReference;
        }

        public final void f(@Nullable WeakReference<TimiGiftPanel> weakReference) {
            TimiGiftPanel.f377122f0 = weakReference;
        }

        @JvmOverloads
        public final void g(@NotNull Activity activity, boolean landscape, int busId, long roomId, int realRoomType, long senderUin, @NotNull String senderNick, @NotNull String senderHead, long receiverUin, @NotNull String receiverNick, @NotNull String receiverHead, @NotNull String source, @NotNull String gameType, @NotNull String programmeId, @NotNull String appId, @Nullable String traceDetail, @NotNull String gameId, int panelType, int subSceneId, @NotNull String roomEnterId, @NotNull String sourceFrom, @NotNull String itemType, @NotNull String roomType, @Nullable ArrayList<IGiftPanelExtBean> extBeanList) {
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
                intent.putExtra("extra_programme_id", tk4.d.f436481a.q());
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
                AegisLogger.INSTANCE.e("Gift|TimiGiftPanel", "start", "giftSdk is null!");
                return;
            }
            IQQGiftCountDownModule g16 = sDKImpl.g();
            if (g16 != null) {
                g16.j(IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_PANEL);
            }
            AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "start", "startGiftPanel busId:" + busId + " roomId:" + roomId + " realRoomType:" + realRoomType + " senderUin:" + senderUin + " senderNick:" + senderNick + " senderHead:" + senderHead + " receiverUin:" + receiverUin + " receiverNick:" + receiverNick + " receiverHead:" + receiverHead + " source:" + source + " gameType:" + gameType + " programmeId:" + programmeId + " appId:" + appId + " traceDetail:" + traceDetail + " gameId:" + gameId + " panelType:" + panelType + " subSceneId:" + subSceneId + " roomEnterId:" + roomEnterId + " sourceFrom:" + sourceFrom + " itemType:" + itemType + " roomType:" + roomType + " landscape:" + landscape + " ");
            if (extBeanList != null) {
                for (IGiftPanelExtBean iGiftPanelExtBean : extBeanList) {
                    AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "start", "extBean:" + iGiftPanelExtBean.getKey() + " value:" + iGiftPanelExtBean.getValue());
                }
            }
            i(activity, intent);
            com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.e();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftPanel$b", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$a;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements QQLivePackageConfirmDialog.a {
        b() {
        }

        @Override // com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog.a
        public void a() {
            sh2.c cVar = TimiGiftPanel.this.giftPanel;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    private final List<com.tencent.mobileqq.qqgift.data.service.e> B() {
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

    private final com.tencent.mobileqq.qqgift.mvvm.business.data.b C() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true);
        if (K()) {
            bVar.f264962j = -1;
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, ScreenUtil.SCREEN_WIDTH, 0.0f, new int[]{0, Color.parseColor("#99191921"), Color.parseColor("#CC191921"), Color.parseColor("#F2191921"), Color.parseColor("#FF191921")}, new float[]{0.0f, 0.3f, 0.35f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
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

    private final String E() {
        String str;
        HashMap<String, String> l3;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null && (l3 = c16.l()) != null) {
            str = l3.get("from");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String F() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    private final void H() {
        final boolean z16;
        ViewGroup contentView;
        FragmentActivity fragmentActivity = this.hostActivity;
        final View view = null;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        if (fragmentActivity.getApplicationContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        sh2.c cVar = this.giftPanel;
        if (cVar != null && (contentView = cVar.getContentView()) != null) {
            view = contentView.getRootView();
        }
        if (view != null) {
            view.setSystemUiVisibility(2);
        }
        if (view != null) {
            view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.timi.game.gift.impl.timi.q
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i3) {
                    TimiGiftPanel.I(z16, view, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(boolean z16, View view, int i3) {
        if (!z16) {
            return;
        }
        wj4.c.b(view);
    }

    private final boolean J(com.tencent.mobileqq.qqgift.data.service.d giftData) {
        if (this.giftPanel == null) {
            return false;
        }
        int i3 = giftData.f264883i;
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K() {
        boolean z16;
        FragmentActivity fragmentActivity = this.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        if (fragmentActivity.getApplicationContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !this.isTablet) {
            return true;
        }
        return false;
    }

    private final boolean L(AuthScene authScene) {
        zh4.d dVar = zh4.d.f452579a;
        if (dVar.k(authScene)) {
            FragmentActivity fragmentActivity = this.hostActivity;
            if (fragmentActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                fragmentActivity = null;
            }
            dVar.d(fragmentActivity, authScene, new Function2<Boolean, String, Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.TimiGiftPanel$needRealNameAuth$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    if (z16) {
                        return;
                    }
                    FragmentActivity fragmentActivity2 = TimiGiftPanel.this.hostActivity;
                    if (fragmentActivity2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                        fragmentActivity2 = null;
                    }
                    QQToast.makeText(fragmentActivity2, errMsg, 0).show();
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(TimiGiftPanel this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftPanelEvent(this$0.roomId, 1, 0, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(TimiGiftPanel this$0, com.tencent.mobileqq.qqgift.data.service.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = dVar.f264874d;
        String str = dVar.f264876e;
        Intrinsics.checkNotNullExpressionValue(str, "data.giftName");
        this$0.T(i3, str, dVar.C, dVar.f264883i, dVar.f264881h, dVar.D, dVar.H, dVar.J, Integer.valueOf(dVar.f264878f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TimiGiftPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity fragmentActivity = this$0.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        QQToast.makeText(fragmentActivity.getApplicationContext(), R.string.zvo, 1).show();
    }

    private final void S() {
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onSendGiftCancel");
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            SimpleEventBus.getInstance().dispatchEvent(new TimiGiftPanelEvent(this.roomId, 2, cVar.getContentView().getWidth(), cVar.getContentView().getHeight()));
        }
        this.fansGroupPendant.k();
        FragmentActivity fragmentActivity = this.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        fragmentActivity.getLifecycle().removeObserver(this.activityLifecycleObserver);
    }

    private final void T(int giftId, String giftName, int materialId, int effectLevel, int giftType, int giftNum, long hitSeq, int allHitCount, Integer price) {
        long j3;
        AegisLogger.INSTANCE.d("Gift|TimiGiftPanel", "onSendGiftSuccess", "giftId: " + giftId + " giftName: " + giftName + " materialId: " + materialId + " effectLevel: " + effectLevel + " giftType: " + giftType + " giftNum: " + giftNum + " hitSeq: " + hitSeq + " allHitCount: " + allHitCount + " sender: " + LogUtil.wrapLogUin(String.valueOf(this.senderUin)) + " senderHead: " + this.senderHead + " sendNick: " + this.senderNick + " receiver: " + LogUtil.wrapLogUin(String.valueOf(this.receiverUin)) + " receiverHead: " + this.receiverHead + " receiverNick: " + this.receiverNick);
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
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.r
            @Override // java.lang.Runnable
            public final void run() {
                TimiGiftPanel.U(GiftMessage.this, this);
            }
        });
        this.fansGroupPendant.p(this.batchGiftPendant.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(GiftMessage giftMessage, TimiGiftPanel this$0) {
        Intrinsics.checkNotNullParameter(giftMessage, "$giftMessage");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftEvent(giftMessage, this$0.roomId, this$0.busId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        IQQGiftRechargeModule f16;
        sh2.c cVar;
        ph2.a d16;
        nh2.c cVar2 = this.giftSdk;
        if (cVar2 != null) {
            boolean z16 = false;
            if (cVar2 != null && !cVar2.isDestroyed()) {
                z16 = true;
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
                    sh2.c cVar4 = this.giftPanel;
                    if (cVar4 != null) {
                        cVar4.setTabSelectedListener(this);
                    }
                }
                sh2.c cVar5 = this.giftPanel;
                if (cVar5 != null) {
                    cVar5.setComboOverListener(this);
                }
                com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a();
                aVar.f264855a = this.panelType;
                aVar.f264856b = this.source;
                aVar.f264857c = this.gameType;
                aVar.f264858d = String.valueOf(this.receiverUin);
                sh2.c cVar6 = this.giftPanel;
                if (cVar6 != null) {
                    cVar6.setSceneData(aVar);
                }
                com.tencent.mobileqq.qqgift.mvvm.business.data.b C = C();
                sh2.c cVar7 = this.giftPanel;
                if (cVar7 != null) {
                    cVar7.setPanelStyle(C);
                }
                sh2.c cVar8 = this.giftPanel;
                if (cVar8 != null) {
                    com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar2 = new com.tencent.mobileqq.qqgift.mvvm.business.data.a();
                    String str = this.traceDetail;
                    aVar2.f264934a = str;
                    if (TextUtils.isEmpty(str)) {
                        aVar2.f264934a = tk4.d.f436481a.m();
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
                    String E = E();
                    if (E == null) {
                        E = "";
                    }
                    aVar2.f264948o = E;
                    aVar2.f264949p = aVar2.f264946m;
                    aVar2.f264950q = aVar2.f264934a;
                    cVar8.setDtParams(aVar2);
                }
                nh2.c cVar9 = this.giftSdk;
                if (cVar9 != null && (f16 = cVar9.f()) != null) {
                    f16.y(this.payObserver);
                }
                sh2.c cVar10 = this.giftPanel;
                if (cVar10 != null) {
                    cVar10.setCacheTabList(B());
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Send_Gift_Monitor|TimiGiftPanel", "openGiftPanel", "roomId=" + this.roomId + ", receiverUin=" + this.receiverUin + ", senderUin=" + this.senderUin + ", source=" + this.source, true);
                FrameLayout frameLayout = this.rootView;
                if (frameLayout != null) {
                    sh2.c cVar11 = this.giftPanel;
                    if (cVar11 != null) {
                        cVar11.h(frameLayout, true, K());
                    }
                    H();
                    return;
                }
                companion.e("Gift|TimiGiftPanel", "openGiftPanel", "rootView is null!");
            }
        }
    }

    private final void X(String action, String info, com.tencent.mobileqq.qqgift.data.service.d data, boolean isSuccess, int comboCnt, int allComboCnt) {
        Long l3;
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder ext10 = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId("").eventId(QQLiveReportConstants.Event.E_MONITOR_LOG_REPORT).roomId(String.valueOf(this.roomId)).roomType(this.roomType).retCode(String.valueOf(isSuccess)).ext6("Send_Gift_Monitor|TimiGiftPanel").ext7(action).ext8(info).ext9(String.valueOf(this.senderUin)).ext10(String.valueOf(this.receiverUin));
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            l3 = Long.valueOf(cVar.u());
        } else {
            l3 = null;
        }
        iQQLiveReportApi.qualityReport(ext10.ext11(String.valueOf(l3)).ext12(String.valueOf(data.f264874d)).ext13(String.valueOf(data.f264878f)).ext14(String.valueOf(data.F)).ext15(String.valueOf(data.C)).ext16(String.valueOf(data.f264883i)).ext17(String.valueOf(data.H)).ext18(String.valueOf(comboCnt)).ext19(String.valueOf(allComboCnt)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(TimiGiftPanel this$0, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Lifecycle.Event.ON_RESUME == event) {
            this$0.P();
        } else if (Lifecycle.Event.ON_DESTROY == event) {
            this$0.M();
        }
    }

    public final void A(long newReceiveUid, @NotNull String newReceiveNick, @NotNull String newReceiveHeadUrl) {
        Intrinsics.checkNotNullParameter(newReceiveNick, "newReceiveNick");
        Intrinsics.checkNotNullParameter(newReceiveHeadUrl, "newReceiveHeadUrl");
        this.receiverUin = newReceiveUid;
        this.receiverNick = newReceiveNick;
        this.receiverHead = newReceiveHeadUrl;
        AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "changeReceive", "newReceiveUid:" + newReceiveUid + " newReceiveNick:" + newReceiveNick + " newReceiveHeadUrl:" + newReceiveHeadUrl);
    }

    @Override // sh2.c.f
    public boolean D() {
        Long l3;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        boolean K = K();
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            l3 = Long.valueOf(cVar.u());
        } else {
            l3 = null;
        }
        companion.i("Send_Gift_Monitor|TimiGiftPanel", "onRechargeClick", "isLandscapeStyle=" + K + ", , curBalance=" + l3, true);
        if (K()) {
            G();
        }
        this.rechargeViewShowing = true;
        return L(AuthScene.RECHARGE);
    }

    public final void G() {
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            cVar.hide();
        }
        sh2.c cVar2 = this.giftPanel;
        if (cVar2 != null) {
            cVar2.setComboOverListener(null);
        }
    }

    public final void M() {
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.fansGroupPendant.k();
        FragmentActivity fragmentActivity = this.hostActivity;
        if (fragmentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
            fragmentActivity = null;
        }
        fragmentActivity.getLifecycle().removeObserver(this.activityLifecycleObserver);
    }

    @Override // sh2.c.f
    public boolean O(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        Long l3;
        oh2.b bVar;
        FragmentActivity fragmentActivity;
        String str;
        String str2;
        FragmentActivity fragmentActivity2;
        if (data == null) {
            AegisLogger.INSTANCE.e("Send_Gift_Monitor|TimiGiftPanel", "onSendGiftClick", "GiftServiceData is null", true);
            return true;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            l3 = Long.valueOf(cVar.u());
        } else {
            l3 = null;
        }
        companion.i("Send_Gift_Monitor|TimiGiftPanel", "onSendGiftClick", "position=" + position + ", curBalance=" + l3 + ", data=" + data);
        X("onSendGiftClick", "", data, true, data.I, data.J);
        if (L(AuthScene.GIFT) || this.fansGroupPendant.o(data)) {
            return true;
        }
        if (this.receiverUin <= 0) {
            if (Intrinsics.areEqual(ai4.c.f26122a.i(), Boolean.TRUE)) {
                str2 = "\u6536\u793c\u4eba\u4e0d\u5728\u53f0\u4e0a\uff0c\u8bf7\u9009\u62e9\u9001\u793c\u5bf9\u8c61";
            } else {
                str2 = "\u8bf7\u9009\u62e9\u9001\u793c\u5bf9\u8c61";
            }
            FragmentActivity fragmentActivity3 = this.hostActivity;
            if (fragmentActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                fragmentActivity2 = null;
            } else {
                fragmentActivity2 = fragmentActivity3;
            }
            QQToast.makeText(fragmentActivity2.getApplicationContext(), 1, str2, 0).show();
            return true;
        }
        com.tencent.mobileqq.qqgift.data.service.c cVar2 = new com.tencent.mobileqq.qqgift.data.service.c();
        cVar2.f264860a = this.senderUin;
        cVar2.f264861b = this.receiverUin;
        ConcurrentHashMap<String, String> concurrentHashMap = cVar2.f264870k;
        Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "giftSendReqData.extData");
        concurrentHashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.roomId));
        boolean areEqual = Intrinsics.areEqual("huya", com.tencent.mobileqq.qqlive.sail.c.f272176a.D(this.roomId, 1));
        if (areEqual) {
            com.tencent.mobileqq.qqlive.huya.c g16 = com.tencent.mobileqq.qqlive.huya.m.f271359a.g();
            if (g16 != null) {
                str = g16.b();
            } else {
                str = null;
            }
            if (str != null) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = cVar2.f264870k;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap2, "giftSendReqData.extData");
                concurrentHashMap2.put("huya_openid", g16.b());
            }
        }
        ArrayList<IGiftPanelExtBean> arrayList = this.extBeanList;
        if (arrayList != null) {
            for (IGiftPanelExtBean iGiftPanelExtBean : arrayList) {
                ConcurrentHashMap<String, String> concurrentHashMap3 = cVar2.f264870k;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap3, "giftSendReqData.extData");
                concurrentHashMap3.put(iGiftPanelExtBean.getKey(), iGiftPanelExtBean.getValue());
            }
        }
        String str3 = "0";
        if (Intrinsics.areEqual(cVar2.f264870k.get("AnchorUID"), "0")) {
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
            ConcurrentHashMap<String, String> concurrentHashMap4 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap4, "giftSendReqData.reportExt");
            concurrentHashMap4.put("program_id", this.programmeId);
            ConcurrentHashMap<String, String> concurrentHashMap5 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap5, "giftSendReqData.reportExt");
            concurrentHashMap5.put("anchor_uid", String.valueOf(this.receiverUin));
            ConcurrentHashMap<String, String> concurrentHashMap6 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap6, "giftSendReqData.reportExt");
            concurrentHashMap6.put("roomid", String.valueOf(this.roomId));
            ConcurrentHashMap<String, String> concurrentHashMap7 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap7, "giftSendReqData.reportExt");
            concurrentHashMap7.put("room_type", this.roomType);
            ConcurrentHashMap<String, String> concurrentHashMap8 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap8, "giftSendReqData.reportExt");
            concurrentHashMap8.put("room_enter_id", this.roomEnterId);
            ConcurrentHashMap<String, String> concurrentHashMap9 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap9, "giftSendReqData.reportExt");
            concurrentHashMap9.put("source_from", this.sourceFrom);
            ConcurrentHashMap<String, String> concurrentHashMap10 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap10, "giftSendReqData.reportExt");
            concurrentHashMap10.put("item_type", this.itemType);
            ConcurrentHashMap<String, String> concurrentHashMap11 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap11, "giftSendReqData.reportExt");
            concurrentHashMap11.put("ownerqq", String.valueOf(this.receiverUin));
            ConcurrentHashMap<String, String> concurrentHashMap12 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap12, "giftSendReqData.reportExt");
            concurrentHashMap12.put("qqlive_start_source", this.appId);
            ConcurrentHashMap<String, String> concurrentHashMap13 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap13, "giftSendReqData.reportExt");
            concurrentHashMap13.put("app_version", F());
            ConcurrentHashMap<String, String> concurrentHashMap14 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap14, "giftSendReqData.reportExt");
            concurrentHashMap14.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, this.traceDetail);
            ConcurrentHashMap<String, String> concurrentHashMap15 = cVar2.f264869j;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap15, "giftSendReqData.reportExt");
            concurrentHashMap15.put("qqlive_coming_way", E());
        }
        ConcurrentHashMap<String, String> concurrentHashMap16 = cVar2.f264869j;
        Intrinsics.checkNotNullExpressionValue(concurrentHashMap16, "giftSendReqData.reportExt");
        if (areEqual) {
            str3 = "1";
        }
        concurrentHashMap16.put("isHuya", str3);
        AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "onSendGiftClick", "senderUin:" + this.senderUin + " receiverUin:" + this.receiverUin + " roomId:" + this.roomId + " programmeId:" + this.programmeId + " roomType:" + this.roomType + " roomEnterId:" + this.roomEnterId + " sourceFrom:" + this.sourceFrom + " itemType:" + this.itemType + " appId:" + this.appId + " versionName:" + F() + " traceDetail:" + this.traceDetail + " comingWay:" + E());
        ArrayList<IGiftPanelExtBean> arrayList2 = this.extBeanList;
        if (arrayList2 != null) {
            for (IGiftPanelExtBean iGiftPanelExtBean2 : arrayList2) {
                AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "onSendGiftClick", "real send ext, key:" + iGiftPanelExtBean2.getKey() + " val:" + iGiftPanelExtBean2.getValue());
            }
        }
        nh2.c cVar3 = this.giftSdk;
        if (cVar3 != null) {
            bVar = cVar3.a();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.Q(cVar2);
            return false;
        }
        return false;
    }

    public final void P() {
        this.fansGroupPendant.l();
    }

    public final void W(@NotNull HashMap<String, String> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "map");
        if (this.extBeanList == null) {
            this.extBeanList = new ArrayList<>();
        }
        ArrayList<IGiftPanelExtBean> arrayList = this.extBeanList;
        if (arrayList != null) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "map.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                final Map.Entry entry = (Map.Entry) it.next();
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((IGiftPanelExtBean) obj).getKey(), entry.getKey())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                IGiftPanelExtBean iGiftPanelExtBean = (IGiftPanelExtBean) obj;
                if (iGiftPanelExtBean != null) {
                    arrayList.remove(iGiftPanelExtBean);
                }
                arrayList.add(new IGiftPanelExtBean() { // from class: com.tencent.timi.game.gift.impl.timi.TimiGiftPanel$replaceExtInfo$1$1$3
                    @Override // com.tencent.timi.game.gift.impl.timi.IGiftPanelExtBean
                    @NotNull
                    public String getKey() {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "e.key");
                        return key;
                    }

                    @Override // com.tencent.timi.game.gift.impl.timi.IGiftPanelExtBean
                    @NotNull
                    public String getValue() {
                        String value = entry.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "e.value");
                        return value;
                    }
                });
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "replaceExtInfo", "key:" + ((Object) entry2.getKey()) + " val:" + ((Object) entry2.getValue()));
        }
    }

    public final void Y(@NotNull FragmentActivity activity, @NotNull Intent intent) {
        ArrayList<IGiftPanelExtBean> arrayList;
        ViewGroup.LayoutParams layoutParams;
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
            this.traceDetail = tk4.d.f436481a.m();
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
        V();
        fragmentActivity3.getLifecycle().removeObserver(this.activityLifecycleObserver);
        fragmentActivity3.getLifecycle().addObserver(this.activityLifecycleObserver);
        yi4.a aVar = this.batchGiftPendant;
        FragmentActivity fragmentActivity4 = this.hostActivity;
        if (fragmentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
        } else {
            fragmentActivity = fragmentActivity4;
        }
        aVar.l(fragmentActivity, this.roomId);
        this.batchGiftPendant.r(this);
        zh4.d.f452579a.g();
    }

    @Override // sh2.c.g
    public void a(@Nullable String tabId) {
        WeakReference<FragmentActivity> weakReference;
        FragmentActivity fragmentActivity;
        boolean z16 = true;
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onTabSelected", "tabId=" + tabId, true);
        if (tabId == null || tabId.equals("PACKAGE_TAB_ID")) {
            z16 = false;
        }
        if (!z16 && (weakReference = f377121e0) != null && (fragmentActivity = weakReference.get()) != null) {
            QQLivePackageConfirmDialog.INSTANCE.b(fragmentActivity, new b());
        }
    }

    @Override // yi4.a.b
    public void b(@Nullable com.tencent.mobileqq.qqgift.data.service.d actionedGiftInfo, long curComboSeq, int lastComboNum, int lastAllComboNum) {
        if (actionedGiftInfo != null) {
            actionedGiftInfo.H = curComboSeq;
        }
        o1(actionedGiftInfo, lastComboNum, lastAllComboNum);
    }

    @Override // sh2.c.d
    public void c(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int comboCnt, int allComboCnt, long hitSeq) {
        Long l3;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            l3 = Long.valueOf(cVar.u());
        } else {
            l3 = null;
        }
        companion.i("Send_Gift_Monitor|TimiGiftPanel", "onComboOver", "comboCnt=" + comboCnt + ", allComboCnt=" + allComboCnt + ", hitSeq=" + hitSeq + ", curBalance=" + l3 + ", data=" + data);
        Intrinsics.checkNotNull(data);
        X("onSendGiftClick", "", data, true, comboCnt, allComboCnt);
    }

    @Override // sh2.c.f
    public boolean f() {
        int i3;
        LinearLayout linearLayout;
        LinearLayout k3;
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", VasPerfReportUtils.WHILE_ON_PANEL_SHOW, "", true);
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            if (cVar != null) {
                cVar.setOnPanelContentHeightChangeListener(new c.e() { // from class: com.tencent.timi.game.gift.impl.timi.n
                    @Override // sh2.c.e
                    public final void a(int i16, int i17) {
                        TimiGiftPanel.N(TimiGiftPanel.this, i16, i17);
                    }
                });
            }
            sh2.c cVar2 = this.giftPanel;
            if (cVar2 != null && (k3 = cVar2.k()) != null) {
                k3.setBackgroundColor(0);
            }
            ij4.b bVar = this.fansGroupPendant;
            int i16 = this.busId;
            long j3 = this.roomId;
            int i17 = this.realRoomType;
            long j16 = this.receiverUin;
            sh2.c cVar3 = this.giftPanel;
            if (cVar3 != null) {
                linearLayout = cVar3.k();
            } else {
                linearLayout = null;
            }
            bVar.m(i16, j3, i17, j16, linearLayout, K());
        }
        sh2.c cVar4 = this.giftPanel;
        if (cVar4 != null) {
            i3 = cVar4.hashCode();
        } else {
            i3 = 0;
        }
        lj4.a.c(i3, true);
        return false;
    }

    @Override // sh2.c.f
    public boolean h0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onPanelItemClick", "position=" + position + ", data=" + data, true);
        return false;
    }

    @Override // sh2.c.f
    public boolean n1(boolean isSuccess, @Nullable final com.tencent.mobileqq.qqgift.data.service.d data, int errCode, @NotNull String errMsg) {
        Long l3;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            l3 = Long.valueOf(cVar.u());
        } else {
            l3 = null;
        }
        companion.i("Send_Gift_Monitor|TimiGiftPanel", "onSendGiftCallback", isSuccess + ContainerUtils.KEY_VALUE_DELIMITER + errCode + ", curBalance=" + l3 + ", data=" + data);
        Intrinsics.checkNotNull(data);
        X("onSendGiftClick", "", data, isSuccess, data.I, data.J);
        if (isSuccess) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.o
                @Override // java.lang.Runnable
                public final void run() {
                    TimiGiftPanel.Q(TimiGiftPanel.this, data);
                }
            });
            return false;
        }
        if (errCode == -10013) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.gift.impl.timi.p
                @Override // java.lang.Runnable
                public final void run() {
                    TimiGiftPanel.R(TimiGiftPanel.this);
                }
            });
            return false;
        }
        return false;
    }

    @Override // sh2.c.f
    public void o1(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int comboCnt, int allComboCnt) {
        if (data != null && J(data)) {
            sh2.c cVar = this.giftPanel;
            if (cVar != null) {
                cVar.hide();
            }
            SimpleEventBus.getInstance().dispatchEvent(new EffectGiftSendEvent(data, comboCnt, allComboCnt));
            AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "onComboGiftSendStart", "new comboGift start send: " + data);
        }
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
                AegisLogger.INSTANCE.i("Gift|TimiGiftPanel", "onPanelItemTripleClick", "showBatchGiftPendant");
                this.fansGroupPendant.r(data, false, position);
                yi4.a aVar = this.batchGiftPendant;
                sh2.c cVar = this.giftPanel;
                if (cVar != null) {
                    linearLayout = cVar.k();
                }
                aVar.s(data, linearLayout, 2);
                yi4.b.f450450a.b(data.f264874d, 2);
            }
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean t() {
        int i3;
        AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onPanelHide", "", true);
        S();
        sh2.c cVar = this.giftPanel;
        if (cVar != null) {
            i3 = cVar.hashCode();
        } else {
            i3 = 0;
        }
        lj4.a.c(i3, false);
        return false;
    }

    @Override // sh2.c.f
    public boolean u0(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, int position) {
        if (data == null) {
            AegisLogger.INSTANCE.e("Send_Gift_Monitor|TimiGiftPanel", "onPanelItemSelected", "GiftServiceData is null", true);
        } else {
            AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onPanelItemSelected", "position=" + position + ", data=" + data, true);
        }
        if (this.batchGiftPendant.t(data) || this.fansGroupPendant.n(data, position)) {
            return true;
        }
        return false;
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
                AegisLogger.INSTANCE.i("Send_Gift_Monitor|TimiGiftPanel", "onPanelItemLongClick", "showBatchGiftPendant, position=" + position + ", data=" + data, true);
                this.fansGroupPendant.r(data, false, position);
                yi4.a aVar = this.batchGiftPendant;
                sh2.c cVar = this.giftPanel;
                if (cVar != null) {
                    linearLayout = cVar.k();
                }
                aVar.s(data, linearLayout, 1);
                yi4.b.f450450a.b(data.f264874d, 1);
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/gift/impl/timi/TimiGiftPanel$c", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IVasNativePayManager.PayObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            ViewGroup.LayoutParams layoutParams;
            if (TimiGiftPanel.this.rechargeViewShowing && TimiGiftPanel.this.K()) {
                FragmentActivity fragmentActivity = TimiGiftPanel.this.hostActivity;
                ViewGroup.LayoutParams layoutParams2 = null;
                if (fragmentActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
                    fragmentActivity = null;
                }
                TimiGiftPanel timiGiftPanel = TimiGiftPanel.this;
                timiGiftPanel.rootView = new FrameLayout(fragmentActivity);
                FrameLayout frameLayout = timiGiftPanel.rootView;
                if (frameLayout != null) {
                    layoutParams = frameLayout.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.width = -2;
                }
                FrameLayout frameLayout2 = timiGiftPanel.rootView;
                if (frameLayout2 != null) {
                    layoutParams2 = frameLayout2.getLayoutParams();
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = -2;
                }
                timiGiftPanel.V();
                fragmentActivity.getLifecycle().removeObserver(timiGiftPanel.activityLifecycleObserver);
                fragmentActivity.getLifecycle().addObserver(timiGiftPanel.activityLifecycleObserver);
            }
            TimiGiftPanel.this.rechargeViewShowing = false;
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
}
