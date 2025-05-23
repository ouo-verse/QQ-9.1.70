package com.tencent.mobileqq.zplan.aio.couple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.zplan.ZPLanCoupleAvatarInterceptTouchLayout;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$appearanceKeyChangeObserver$2;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$requestSceneConfigListener$2;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.push.ZPlanNTPushHandler;
import com.tencent.mobileqq.zplan.servlet.m;
import com.tencent.mobileqq.zplan.utils.ax;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AvatarBgChangeEvent;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ku4.n;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x165.Submsgtype0x165$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003~\u0083\u0001\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001WB\u0019\u0012\u0006\u0010R\u001a\u00020\u0017\u0012\u0006\u0010c\u001a\u00020_\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0013\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0013\u0010\u0011\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0013\u0010\u001c\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010!\u001a\u00020 *\u00020\u001fH\u0002J\u0013\u0010\"\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u000bJ\u0013\u0010#\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u000bJ\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0013\u00100\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u000bJ#\u00103\u001a\u00020\u00032\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0017H\u0016J\u0018\u00109\u001a\u00020\u00032\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0002H\u0016J\u0018\u0010<\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020\u0003H\u0016J\b\u0010C\u001a\u00020\u0003H\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010F\u001a\u00020EH\u0016J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020 H\u0016J\u001a\u0010L\u001a\u00020\u00032\u0006\u0010K\u001a\u00020J2\b\u00105\u001a\u0004\u0018\u00010\u0017H\u0016J\u0013\u0010M\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u000bJ\u001a\u0010Q\u001a\u0004\u0018\u00010\u00172\u0006\u0010N\u001a\u00020\u00052\u0006\u0010P\u001a\u00020OH\u0016J(\u0010U\u001a\u00020T2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u001aH\u0016J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010V\u001a\u00020 H\u0016J\b\u0010X\u001a\u00020\u0005H\u0016J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\u0005H\u0016J\b\u0010[\u001a\u00020\u0003H\u0016R\u0017\u0010R\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b.\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010c\u001a\u00020_8\u0006\u00a2\u0006\f\n\u0004\bM\u0010`\u001a\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010hR\u0016\u0010k\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010jR \u0010n\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010\u001cR\u0018\u0010w\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010\u0019R\u0016\u0010{\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010\u0019R\u0016\u0010}\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010\u0019R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u0019\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001f\u0010\u0086\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\f\u0010\u007f\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0015\u0010\u0088\u0001R\u0016\u0010\u008b\u0001\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0014\u0010\u008a\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController;", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "", "O", "", "bothSceneId", "", "d0", "Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J", "Landroid/widget/FrameLayout$LayoutParams;", "T", "c0", "b0", "i0", "N", "M", "L", "K", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "I", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Req, "Z", "a0", "f0", "Lku4/n;", "Lle3/b;", "g0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "U", "", "V", "e0", "h0", "isInitFinished", "v", "state", "onMoveToState", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "scene", "d", "l", "o", "sceneConfig", "needPush", "b", "(Lle3/b;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "i", "coupleAvatarSubScene", "listener", "f", "width", "height", "c", "k", "register", "Lcom/tencent/mobileqq/zplan/push/a;", "observer", "u", "j", "t", "g", "Lcom/tencent/mobileqq/zplan/aio/couple/i$b;", "actionInfo", ReportConstant.COSTREPORT_PREFIX, "actionConfig", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayoutEvent;", "event", tl.h.F, "e", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/aio/couple/h;", "listner", "w", "peerUin", "context", "Landroid/widget/ImageView;", "p", "resourceConfig", "a", "r", "newID", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "X", "()Ljava/lang/String;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "W", "()Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayout;", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayout;", "coupleAvatarLayout", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPLanCoupleAvatarInterceptTouchLayout;", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPLanCoupleAvatarInterceptTouchLayout;", "aioCoupleAvatarLayoutContainer", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "eventListenerMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "initFinish", "D", "hasNetProcess", "E", "Lcom/tencent/mobileqq/zplan/aio/couple/i$b;", "cachedActionInfo", UserInfo.SEX_FEMALE, "currentSceneId", "G", "intimateSceneId", "H", "currentIntimateType", "com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$appearanceKeyChangeObserver$2$a", "Lkotlin/Lazy;", "P", "()Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$appearanceKeyChangeObserver$2$a;", "appearanceKeyChangeObserver", "com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$requestSceneConfigListener$2$1", "Y", "()Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$requestSceneConfigListener$2$1;", "requestSceneConfigListener", "Lcom/tencent/mobileqq/friends/intimate/d;", "Lcom/tencent/mobileqq/friends/intimate/d;", "intimateInfoObserver", "Lcom/tencent/mobileqq/zplan/push/a;", "zplanAIOSceneSyncPushObserver", "<init>", "(Ljava/lang/String;Lcom/tencent/aio/api/runtime/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CoupleAvatarViewController implements i, g {

    /* renamed from: C, reason: from kotlin metadata */
    private final AtomicBoolean initFinish;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasNetProcess;

    /* renamed from: E, reason: from kotlin metadata */
    private i.ZPlanActionInfo cachedActionInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentSceneId;

    /* renamed from: G, reason: from kotlin metadata */
    private int intimateSceneId;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentIntimateType;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy appearanceKeyChangeObserver;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy requestSceneConfigListener;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.friends.intimate.d intimateInfoObserver;

    /* renamed from: L, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zplan.push.a zplanAIOSceneSyncPushObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String peerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CoupleAvatarLayout coupleAvatarLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZPLanCoupleAvatarInterceptTouchLayout aioCoupleAvatarLayoutContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CoupleAvatarSubScene subScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<CoupleAvatarSubScene, g> eventListenerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\bR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 \u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$c", "Lle3/b;", "", "getId", "()I", "id", "", "getName", "()Ljava/lang/String;", "name", "c", "mainIconUrl", "d", "cornerIconUrl", tl.h.F, "aioBackgroundUrl", "k", "friendTimeBackgroundUrl", "getActionType", "actionType", "b", "friendViewId", "i", "aioBgBottomColor", "f", "friendTimeBgBottomColor", "g", "aioBgTopColor", "j", "friendTimeBgTopColor", "", "e", "()Z", "has", "a", "isNeedPay", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements le3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f330992a;

        c(n nVar) {
            this.f330992a = nVar;
        }

        @Override // le3.b
        public boolean a() {
            return this.f330992a.f413133n;
        }

        @Override // le3.b
        public int b() {
            return this.f330992a.f413127h;
        }

        @Override // le3.b
        public String c() {
            String str = this.f330992a.f413122c;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.mainIconUrl");
            return str;
        }

        @Override // le3.b
        public String d() {
            String str = this.f330992a.f413123d;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.cornerIconUrl");
            return str;
        }

        @Override // le3.b
        public boolean e() {
            return false;
        }

        @Override // le3.b
        public String f() {
            String str = this.f330992a.f413129j;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBgBottomColor");
            return str;
        }

        @Override // le3.b
        public String g() {
            String str = this.f330992a.f413130k;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBgTopColor");
            return str;
        }

        @Override // le3.b
        public int getActionType() {
            return this.f330992a.f413126g;
        }

        @Override // le3.b
        public int getId() {
            return this.f330992a.f413120a;
        }

        @Override // le3.b
        public String getName() {
            String str = this.f330992a.f413121b;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.name");
            return str;
        }

        @Override // le3.b
        public String h() {
            String str = this.f330992a.f413124e;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBackgroundUrl");
            return str;
        }

        @Override // le3.b
        public String i() {
            String str = this.f330992a.f413128i;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBgBottomColor");
            return str;
        }

        @Override // le3.b
        public String j() {
            String str = this.f330992a.f413131l;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBgTopColor");
            return str;
        }

        @Override // le3.b
        public String k() {
            String str = this.f330992a.f413125f;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBackgroundUrl");
            return str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$d", "Lcom/tencent/mobileqq/zplan/push/a;", "", "fromUin", "toUin", "", "body", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zplan.push.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.push.a
        public void a(long fromUin, long toUin, byte[] body) {
            Intrinsics.checkNotNullParameter(body, "body");
            QLog.i("CoupleAvatarViewController", 1, "zplanAIOSceneSyncPushObserver onReceivePush");
            if (ZPlanQQMC.INSTANCE.enableAIOSceneLinkage()) {
                if (!Intrinsics.areEqual(String.valueOf(fromUin), CoupleAvatarViewController.this.getPeerUin())) {
                    QLog.i("CoupleAvatarViewController", 1, "zplanAIOSceneSyncPushObserver not from current friend");
                    return;
                }
                Submsgtype0x165$MsgBody submsgtype0x165$MsgBody = new Submsgtype0x165$MsgBody();
                try {
                    submsgtype0x165$MsgBody.mergeFrom(body);
                    CoupleAvatarViewController.this.d0(submsgtype0x165$MsgBody.scene_id.get());
                } catch (Exception e16) {
                    QLog.e("CoupleAvatarViewController", 1, "zplanAIOSceneSyncPushObserver error:" + e16);
                }
            }
        }
    }

    public CoupleAvatarViewController(String peerUin, com.tencent.aio.api.runtime.a mAIOContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        this.peerUin = peerUin;
        this.mAIOContext = mAIOContext;
        this.subScene = CoupleAvatarSubScene.AIO;
        this.eventListenerMap = new ConcurrentHashMap<>();
        this.initFinish = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoupleAvatarViewController$appearanceKeyChangeObserver$2.a>() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$appearanceKeyChangeObserver$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$appearanceKeyChangeObserver$2$a", "Lcom/tencent/mobileqq/zplan/servlet/m;", "", "success", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a extends m {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ CoupleAvatarViewController f330990e;

                a(CoupleAvatarViewController coupleAvatarViewController) {
                    this.f330990e = coupleAvatarViewController;
                }

                @Override // com.tencent.mobileqq.zplan.servlet.m
                public void a(boolean success, List<String> uinList) {
                    Intrinsics.checkNotNullParameter(uinList, "uinList");
                    super.a(success, uinList);
                    this.f330990e.I(uinList);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(CoupleAvatarViewController.this);
            }
        });
        this.appearanceKeyChangeObserver = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoupleAvatarViewController$requestSceneConfigListener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$requestSceneConfigListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$requestSceneConfigListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final CoupleAvatarViewController coupleAvatarViewController = CoupleAvatarViewController.this;
                return new h() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$requestSceneConfigListener$2.1
                    @Override // com.tencent.mobileqq.zplan.aio.couple.h
                    public void a(boolean isSuccess) {
                        CoroutineScope f16;
                        if (!isSuccess || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e)) == null) {
                            return;
                        }
                        CorountineFunKt.e(f16, "zplan_CoupleAvatarViewController_\u66f4\u65b0\u80cc\u666f", null, null, null, new CoupleAvatarViewController$requestSceneConfigListener$2$1$onUpdate$1(CoupleAvatarViewController.this, null), 14, null);
                    }
                };
            }
        });
        this.requestSceneConfigListener = lazy2;
        this.intimateInfoObserver = new b();
        this.zplanAIOSceneSyncPushObserver = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(List<String> uinList) {
        boolean contains;
        CoupleAvatarLayout coupleAvatarLayout;
        contains = CollectionsKt___CollectionsKt.contains(uinList, bb.f335811a.e());
        if ((contains || uinList.contains(this.peerUin)) && (coupleAvatarLayout = this.coupleAvatarLayout) != null) {
            coupleAvatarLayout.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object J(Continuation<? super Unit> continuation) {
        CoupleAvatarViewController$checkIfNeedToChangeScene$1 coupleAvatarViewController$checkIfNeedToChangeScene$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        int intValue;
        CoupleAvatarLayout coupleAvatarLayout;
        CoroutineScope f16;
        if (continuation instanceof CoupleAvatarViewController$checkIfNeedToChangeScene$1) {
            coupleAvatarViewController$checkIfNeedToChangeScene$1 = (CoupleAvatarViewController$checkIfNeedToChangeScene$1) continuation;
            int i16 = coupleAvatarViewController$checkIfNeedToChangeScene$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$checkIfNeedToChangeScene$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$checkIfNeedToChangeScene$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$checkIfNeedToChangeScene$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.coupleAvatarLayout == null) {
                        return Unit.INSTANCE;
                    }
                    coupleAvatarViewController$checkIfNeedToChangeScene$1.L$0 = this;
                    coupleAvatarViewController$checkIfNeedToChangeScene$1.label = 1;
                    obj = e(coupleAvatarViewController$checkIfNeedToChangeScene$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarViewController = this;
                } else if (i3 == 1) {
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$checkIfNeedToChangeScene$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                intValue = ((Number) obj).intValue();
                CoupleAvatarLayout coupleAvatarLayout2 = coupleAvatarViewController.coupleAvatarLayout;
                QLog.i("CoupleAvatarViewController", 1, "checkIfNeedToChangeScene targetSceneId:" + intValue + " coupleAvatarLayout?.curSceneId:" + (coupleAvatarLayout2 == null ? Boxing.boxInt(coupleAvatarLayout2.getCurSceneId()) : null));
                coupleAvatarLayout = coupleAvatarViewController.coupleAvatarLayout;
                if (!(coupleAvatarLayout == null && coupleAvatarLayout.getCurSceneId() == intValue) && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e)) != null) {
                    CorountineFunKt.e(f16, "CoupleAvatarViewController_checkIfNeedToChangeScene", null, null, null, new CoupleAvatarViewController$checkIfNeedToChangeScene$2(coupleAvatarViewController, intValue, null), 14, null);
                }
                return Unit.INSTANCE;
            }
        }
        coupleAvatarViewController$checkIfNeedToChangeScene$1 = new CoupleAvatarViewController$checkIfNeedToChangeScene$1(this, continuation);
        Object obj2 = coupleAvatarViewController$checkIfNeedToChangeScene$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$checkIfNeedToChangeScene$1.label;
        if (i3 != 0) {
        }
        intValue = ((Number) obj2).intValue();
        CoupleAvatarLayout coupleAvatarLayout22 = coupleAvatarViewController.coupleAvatarLayout;
        if (coupleAvatarLayout22 == null) {
        }
        QLog.i("CoupleAvatarViewController", 1, "checkIfNeedToChangeScene targetSceneId:" + intValue + " coupleAvatarLayout?.curSceneId:" + (coupleAvatarLayout22 == null ? Boxing.boxInt(coupleAvatarLayout22.getCurSceneId()) : null));
        coupleAvatarLayout = coupleAvatarViewController.coupleAvatarLayout;
        if (!(coupleAvatarLayout == null && coupleAvatarLayout.getCurSceneId() == intValue)) {
            CorountineFunKt.e(f16, "CoupleAvatarViewController_checkIfNeedToChangeScene", null, null, null, new CoupleAvatarViewController$checkIfNeedToChangeScene$2(coupleAvatarViewController, intValue, null), 14, null);
        }
        return Unit.INSTANCE;
    }

    private final void K() {
        QLog.i("CoupleAvatarViewController", 1, "doOnDestroy " + this + ", coupleAvatarLayout: " + this.coupleAvatarLayout);
        this.mAIOContext.e().h(AIOMsgListEvent.RemoveAvatarAreaView.f188370d);
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            Intrinsics.checkNotNull(coupleAvatarLayout);
            coupleAvatarLayout.b0();
            this.coupleAvatarLayout = null;
        }
        this.aioCoupleAvatarLayoutContainer = null;
        this.eventListenerMap.clear();
        this.cachedActionInfo = null;
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.removeObserver(P());
        }
        if (c16 != null) {
            c16.removeObserver(this.intimateInfoObserver);
        }
        ZPlanNTPushHandler.f335027a.c(ZPlanNTPushHandler.PushType.SCENE_LINKAGE, this.zplanAIOSceneSyncPushObserver);
    }

    private final void L() {
        QLog.i("CoupleAvatarViewController", 1, "doOnPause " + this);
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            coupleAvatarLayout.c0();
        }
    }

    private final void M() {
        QLog.i("CoupleAvatarViewController", 1, "doOnResume " + this);
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            coupleAvatarLayout.d0();
        }
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.removeObserver(P());
        }
        if (c16 != null) {
            c16.addObserver(P());
        }
        if (c16 != null) {
            c16.removeObserver(this.intimateInfoObserver);
        }
        if (c16 != null) {
            c16.addObserver(this.intimateInfoObserver);
        }
        ZPlanNTPushHandler.f335027a.b(ZPlanNTPushHandler.PushType.SCENE_LINKAGE, this.zplanAIOSceneSyncPushObserver);
    }

    private final void N() {
        QLog.i("CoupleAvatarViewController", 1, "doOnStart " + this);
        ZPlanNTPushHandler.f335027a.b(ZPlanNTPushHandler.PushType.SCENE_LINKAGE, this.zplanAIOSceneSyncPushObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_CoupleAvatarViewController_doUpdateSceneWhenIntimateInfoChanged", null, null, null, new CoupleAvatarViewController$doUpdateSceneWhenIntimateInfoChanged$1(this, null), 14, null);
        }
    }

    private final CoupleAvatarViewController$appearanceKeyChangeObserver$2.a P() {
        return (CoupleAvatarViewController$appearanceKeyChangeObserver$2.a) this.appearanceKeyChangeObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q(Continuation<? super Integer> continuation) {
        CoupleAvatarViewController$getConfigDefaultSceneId$1 coupleAvatarViewController$getConfigDefaultSceneId$1;
        Object coroutine_suspended;
        int i3;
        Integer coupleAvatarDefaultScene;
        if (continuation instanceof CoupleAvatarViewController$getConfigDefaultSceneId$1) {
            coupleAvatarViewController$getConfigDefaultSceneId$1 = (CoupleAvatarViewController$getConfigDefaultSceneId$1) continuation;
            int i16 = coupleAvatarViewController$getConfigDefaultSceneId$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$getConfigDefaultSceneId$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$getConfigDefaultSceneId$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$getConfigDefaultSceneId$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    coupleAvatarViewController$getConfigDefaultSceneId$1.label = 1;
                    obj = U(coupleAvatarViewController$getConfigDefaultSceneId$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int intValue = ((Number) obj).intValue();
                QLog.i("CoupleAvatarViewController", 1, "getConfigDefaultSceneId intimateType:" + intValue);
                coupleAvatarDefaultScene = ZPlanQQMC.INSTANCE.getCoupleAvatarDefaultScene(String.valueOf(intValue));
                if (coupleAvatarDefaultScene == null) {
                    return Boxing.boxInt(coupleAvatarDefaultScene.intValue());
                }
                return Boxing.boxInt(50014);
            }
        }
        coupleAvatarViewController$getConfigDefaultSceneId$1 = new CoupleAvatarViewController$getConfigDefaultSceneId$1(this, continuation);
        Object obj2 = coupleAvatarViewController$getConfigDefaultSceneId$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$getConfigDefaultSceneId$1.label;
        if (i3 != 0) {
        }
        int intValue2 = ((Number) obj2).intValue();
        QLog.i("CoupleAvatarViewController", 1, "getConfigDefaultSceneId intimateType:" + intValue2);
        coupleAvatarDefaultScene = ZPlanQQMC.INSTANCE.getCoupleAvatarDefaultScene(String.valueOf(intValue2));
        if (coupleAvatarDefaultScene == null) {
        }
    }

    private final Context R() {
        Context context = this.mAIOContext.c().getContext();
        if (context != null) {
            return context;
        }
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object S(Continuation<? super View> continuation) {
        CoupleAvatarViewController$getCoupleAvatarLayout$1 coupleAvatarViewController$getCoupleAvatarLayout$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        CoupleAvatarLayout coupleAvatarLayout;
        if (continuation instanceof CoupleAvatarViewController$getCoupleAvatarLayout$1) {
            coupleAvatarViewController$getCoupleAvatarLayout$1 = (CoupleAvatarViewController$getCoupleAvatarLayout$1) continuation;
            int i16 = coupleAvatarViewController$getCoupleAvatarLayout$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$getCoupleAvatarLayout$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$getCoupleAvatarLayout$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$getCoupleAvatarLayout$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.coupleAvatarLayout == null) {
                        coupleAvatarViewController$getCoupleAvatarLayout$1.L$0 = this;
                        coupleAvatarViewController$getCoupleAvatarLayout$1.label = 1;
                        if (Z(coupleAvatarViewController$getCoupleAvatarLayout$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        coupleAvatarViewController$getCoupleAvatarLayout$1.L$0 = this;
                        coupleAvatarViewController$getCoupleAvatarLayout$1.label = 2;
                        if (J(coupleAvatarViewController$getCoupleAvatarLayout$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    coupleAvatarViewController = this;
                } else {
                    if (i3 != 1 && i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$getCoupleAvatarLayout$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                coupleAvatarViewController.a0();
                coupleAvatarLayout = coupleAvatarViewController.coupleAvatarLayout;
                Intrinsics.checkNotNull(coupleAvatarLayout);
                ZPLanCoupleAvatarInterceptTouchLayout zPLanCoupleAvatarInterceptTouchLayout = coupleAvatarViewController.aioCoupleAvatarLayoutContainer;
                Intrinsics.checkNotNull(zPLanCoupleAvatarInterceptTouchLayout);
                if (coupleAvatarLayout.getParent() != null) {
                    ViewParent parent = coupleAvatarLayout.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(coupleAvatarLayout);
                }
                zPLanCoupleAvatarInterceptTouchLayout.addView(coupleAvatarLayout, coupleAvatarViewController.T());
                return zPLanCoupleAvatarInterceptTouchLayout;
            }
        }
        coupleAvatarViewController$getCoupleAvatarLayout$1 = new CoupleAvatarViewController$getCoupleAvatarLayout$1(this, continuation);
        Object obj2 = coupleAvatarViewController$getCoupleAvatarLayout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$getCoupleAvatarLayout$1.label;
        if (i3 != 0) {
        }
        coupleAvatarViewController.a0();
        coupleAvatarLayout = coupleAvatarViewController.coupleAvatarLayout;
        Intrinsics.checkNotNull(coupleAvatarLayout);
        ZPLanCoupleAvatarInterceptTouchLayout zPLanCoupleAvatarInterceptTouchLayout2 = coupleAvatarViewController.aioCoupleAvatarLayoutContainer;
        Intrinsics.checkNotNull(zPLanCoupleAvatarInterceptTouchLayout2);
        if (coupleAvatarLayout.getParent() != null) {
        }
        zPLanCoupleAvatarInterceptTouchLayout2.addView(coupleAvatarLayout, coupleAvatarViewController.T());
        return zPLanCoupleAvatarInterceptTouchLayout2;
    }

    private final FrameLayout.LayoutParams T() {
        float a16 = ax.f335802a.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (0.82f * a16), (int) (a16 * 0.48f));
        layoutParams.gravity = 81;
        return layoutParams;
    }

    private final Object U(Continuation<? super Integer> continuation) {
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a b16;
        String peerUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.peerUin);
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        b16 = f.b(peerUid, "CoupleAvatarViewController");
        int j3 = b16 != null ? b16.j() : 0;
        this.currentIntimateType = j3;
        return Boxing.boxInt(j3);
    }

    private final long V() {
        try {
            return Long.parseLong(this.peerUin);
        } catch (NumberFormatException unused) {
            QLog.e("CoupleAvatarViewController", 1, "invalid uin:" + this.peerUin);
            return 0L;
        }
    }

    private final CoupleAvatarViewController$requestSceneConfigListener$2.AnonymousClass1 Y() {
        return (CoupleAvatarViewController$requestSceneConfigListener$2.AnonymousClass1) this.requestSceneConfigListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z(Continuation<? super Unit> continuation) {
        CoupleAvatarViewController$initCoupleAvatarLayout$1 coupleAvatarViewController$initCoupleAvatarLayout$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        String str;
        CoupleAvatarViewController coupleAvatarViewController2;
        if (continuation instanceof CoupleAvatarViewController$initCoupleAvatarLayout$1) {
            coupleAvatarViewController$initCoupleAvatarLayout$1 = (CoupleAvatarViewController$initCoupleAvatarLayout$1) continuation;
            int i16 = coupleAvatarViewController$initCoupleAvatarLayout$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$initCoupleAvatarLayout$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$initCoupleAvatarLayout$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$initCoupleAvatarLayout$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = this.peerUin;
                    coupleAvatarViewController$initCoupleAvatarLayout$1.L$0 = this;
                    coupleAvatarViewController$initCoupleAvatarLayout$1.L$1 = this;
                    coupleAvatarViewController$initCoupleAvatarLayout$1.L$2 = str2;
                    coupleAvatarViewController$initCoupleAvatarLayout$1.label = 1;
                    Object e16 = e(coupleAvatarViewController$initCoupleAvatarLayout$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarViewController = this;
                    str = str2;
                    obj = e16;
                    coupleAvatarViewController2 = coupleAvatarViewController;
                } else if (i3 == 1) {
                    String str3 = (String) coupleAvatarViewController$initCoupleAvatarLayout$1.L$2;
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$initCoupleAvatarLayout$1.L$1;
                    coupleAvatarViewController2 = (CoupleAvatarViewController) coupleAvatarViewController$initCoupleAvatarLayout$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str3;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coupleAvatarViewController.coupleAvatarLayout = new CoupleAvatarLayout(str, ((Number) obj).intValue(), coupleAvatarViewController2.R(), null, 0, 24, null);
                CoupleAvatarLayout coupleAvatarLayout = coupleAvatarViewController2.coupleAvatarLayout;
                Intrinsics.checkNotNull(coupleAvatarLayout);
                coupleAvatarLayout.setEventListener(coupleAvatarViewController2);
                CoupleAvatarLayout coupleAvatarLayout2 = coupleAvatarViewController2.coupleAvatarLayout;
                Intrinsics.checkNotNull(coupleAvatarLayout2);
                coupleAvatarLayout2.setSubScene(coupleAvatarViewController2.subScene);
                QLog.i("CoupleAvatarViewController", 1, "initCoupleAvatarLayout: " + coupleAvatarViewController2.coupleAvatarLayout + " subScene:" + coupleAvatarViewController2.subScene);
                return Unit.INSTANCE;
            }
        }
        coupleAvatarViewController$initCoupleAvatarLayout$1 = new CoupleAvatarViewController$initCoupleAvatarLayout$1(this, continuation);
        Object obj2 = coupleAvatarViewController$initCoupleAvatarLayout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$initCoupleAvatarLayout$1.label;
        if (i3 != 0) {
        }
        coupleAvatarViewController.coupleAvatarLayout = new CoupleAvatarLayout(str, ((Number) obj2).intValue(), coupleAvatarViewController2.R(), null, 0, 24, null);
        CoupleAvatarLayout coupleAvatarLayout3 = coupleAvatarViewController2.coupleAvatarLayout;
        Intrinsics.checkNotNull(coupleAvatarLayout3);
        coupleAvatarLayout3.setEventListener(coupleAvatarViewController2);
        CoupleAvatarLayout coupleAvatarLayout22 = coupleAvatarViewController2.coupleAvatarLayout;
        Intrinsics.checkNotNull(coupleAvatarLayout22);
        coupleAvatarLayout22.setSubScene(coupleAvatarViewController2.subScene);
        QLog.i("CoupleAvatarViewController", 1, "initCoupleAvatarLayout: " + coupleAvatarViewController2.coupleAvatarLayout + " subScene:" + coupleAvatarViewController2.subScene);
        return Unit.INSTANCE;
    }

    private final void a0() {
        ZPLanCoupleAvatarInterceptTouchLayout zPLanCoupleAvatarInterceptTouchLayout = this.aioCoupleAvatarLayoutContainer;
        if (zPLanCoupleAvatarInterceptTouchLayout == null) {
            QLog.i("CoupleAvatarViewController", 1, "initCoupleAvatarLayoutContainer: uin: " + this.peerUin);
            this.aioCoupleAvatarLayoutContainer = new ZPLanCoupleAvatarInterceptTouchLayout(R(), this.peerUin, null, 4, null);
            return;
        }
        Intrinsics.checkNotNull(zPLanCoupleAvatarInterceptTouchLayout);
        if (zPLanCoupleAvatarInterceptTouchLayout.getParent() != null) {
            ViewParent parent = zPLanCoupleAvatarInterceptTouchLayout.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.aioCoupleAvatarLayoutContainer);
        }
        zPLanCoupleAvatarInterceptTouchLayout.removeAllViews();
    }

    private final boolean b0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        ChatBackgroundManager chatBackgroundManager = manager instanceof ChatBackgroundManager ? (ChatBackgroundManager) manager : null;
        if (chatBackgroundManager == null) {
            return false;
        }
        String m3 = chatBackgroundManager.m(this.peerUin);
        QLog.i("CoupleAvatarViewController", 1, "isAvatarBackground, bgId: " + m3);
        return m3.equals("47967");
    }

    private final boolean c0() {
        if (!((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarSwitchConfig().getEnable()) {
            QLog.i("CoupleAvatarViewController", 1, "isAvatarBackground coupleAvatarSwitchConfig enable false");
            return false;
        }
        return ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(this.peerUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d0(int bothSceneId) {
        if (!ZPlanQQMC.INSTANCE.enableAIOSceneLinkage() || this.currentSceneId == bothSceneId || (!b0() && c0())) {
            return false;
        }
        f0(bothSceneId);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        float a16 = ax.f335802a.a();
        c((int) (0.82f * a16), (int) (a16 * 0.48f));
    }

    private final void f0(int bothSceneId) {
        this.currentSceneId = bothSceneId;
        CoupleAvatarSceneConfigManager.f330980a.i(this.peerUin, bothSceneId);
        QLog.i("CoupleAvatarViewController", 1, "switchToBothSceneIdAndChangeScene bothSceneId:" + bothSceneId);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "CoupleAvatarViewController_switchToBothSceneIdAndChangeScene", null, null, null, new CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1(bothSceneId, this, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final le3.b g0(n nVar) {
        return new c(nVar);
    }

    private final void h0() {
        i.ZPlanActionInfo zPlanActionInfo = this.cachedActionInfo;
        if (zPlanActionInfo == null) {
            return;
        }
        this.cachedActionInfo = null;
        QLog.i("CoupleAvatarViewController", 1, "tryPlayCachedAction, " + zPlanActionInfo);
        s(zPlanActionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i0(Continuation<? super Unit> continuation) {
        CoupleAvatarViewController$updateBackground$1 coupleAvatarViewController$updateBackground$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        n d16;
        if (continuation instanceof CoupleAvatarViewController$updateBackground$1) {
            coupleAvatarViewController$updateBackground$1 = (CoupleAvatarViewController$updateBackground$1) continuation;
            int i16 = coupleAvatarViewController$updateBackground$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$updateBackground$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$updateBackground$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$updateBackground$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    coupleAvatarViewController$updateBackground$1.L$0 = this;
                    coupleAvatarViewController$updateBackground$1.label = 1;
                    obj = e(coupleAvatarViewController$updateBackground$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarViewController = this;
                } else if (i3 == 1) {
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$updateBackground$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int intValue = ((Number) obj).intValue();
                CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager = CoupleAvatarSceneConfigManager.f330980a;
                d16 = coupleAvatarSceneConfigManager.d(intValue);
                if (d16 != null) {
                    coupleAvatarSceneConfigManager.h(intValue, coupleAvatarViewController.Y());
                    return Unit.INSTANCE;
                }
                String str = d16.f413124e;
                if (str == null) {
                    return Unit.INSTANCE;
                }
                AppInterface c16 = bb.f335811a.c();
                if (c16 == null) {
                    return Unit.INSTANCE;
                }
                String currentUin = c16.getCurrentUin();
                if (currentUin == null) {
                    return Unit.INSTANCE;
                }
                QLog.i("CoupleAvatarViewController", 1, "updateBackground, sceneId: " + intValue + ", url: " + str);
                Manager manager = c16.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.model.ChatBackgroundManager");
                ((ChatBackgroundManager) manager).A(currentUin, coupleAvatarViewController.peerUin, str, 0);
                if (coupleAvatarViewController.b0()) {
                    String peerUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(coupleAvatarViewController.peerUin);
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                    simpleEventBus.dispatchEvent(new AvatarBgChangeEvent(peerUid, false));
                }
                return Unit.INSTANCE;
            }
        }
        coupleAvatarViewController$updateBackground$1 = new CoupleAvatarViewController$updateBackground$1(this, continuation);
        Object obj2 = coupleAvatarViewController$updateBackground$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$updateBackground$1.label;
        if (i3 != 0) {
        }
        int intValue2 = ((Number) obj2).intValue();
        CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager2 = CoupleAvatarSceneConfigManager.f330980a;
        d16 = coupleAvatarSceneConfigManager2.d(intValue2);
        if (d16 != null) {
        }
    }

    /* renamed from: W, reason: from getter */
    public final com.tencent.aio.api.runtime.a getMAIOContext() {
        return this.mAIOContext;
    }

    /* renamed from: X, reason: from getter */
    public final String getPeerUin() {
        return this.peerUin;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void a(le3.b resourceConfig) {
        Intrinsics.checkNotNullParameter(resourceConfig, "resourceConfig");
        CoupleAvatarSceneConfigManager.f330980a.j(resourceConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(le3.b bVar, boolean z16, Continuation<? super Unit> continuation) {
        CoupleAvatarViewController$changeScene$1 coupleAvatarViewController$changeScene$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        long V;
        if (continuation instanceof CoupleAvatarViewController$changeScene$1) {
            coupleAvatarViewController$changeScene$1 = (CoupleAvatarViewController$changeScene$1) continuation;
            int i16 = coupleAvatarViewController$changeScene$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$changeScene$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$changeScene$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$changeScene$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int id5 = bVar.getId();
                    this.currentSceneId = id5;
                    CoupleAvatarSceneConfigManager.f330980a.i(this.peerUin, id5);
                    CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
                    if (coupleAvatarLayout != null) {
                        int id6 = bVar.getId();
                        coupleAvatarViewController$changeScene$1.L$0 = this;
                        coupleAvatarViewController$changeScene$1.L$1 = bVar;
                        coupleAvatarViewController$changeScene$1.Z$0 = z16;
                        coupleAvatarViewController$changeScene$1.label = 1;
                        if (coupleAvatarLayout.H(id6, coupleAvatarViewController$changeScene$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    coupleAvatarViewController = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z16 = coupleAvatarViewController$changeScene$1.Z$0;
                    bVar = (le3.b) coupleAvatarViewController$changeScene$1.L$1;
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$changeScene$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                V = coupleAvatarViewController.V();
                if (V > 0) {
                    return Unit.INSTANCE;
                }
                ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).setCoupleSceneId(V, coupleAvatarViewController.currentSceneId, z16);
                coupleAvatarViewController.a(bVar);
                QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
                if (((IZPlanCoupleSceneHelper) api).getCoupleAvatarSwitchState(coupleAvatarViewController.peerUin) && (coupleAvatarViewController.b0() || z16)) {
                    ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).switchAIOBackground(true, coupleAvatarViewController.peerUin, 0);
                    coupleAvatarViewController$changeScene$1.L$0 = null;
                    coupleAvatarViewController$changeScene$1.L$1 = null;
                    coupleAvatarViewController$changeScene$1.label = 2;
                    if (coupleAvatarViewController.i0(coupleAvatarViewController$changeScene$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        coupleAvatarViewController$changeScene$1 = new CoupleAvatarViewController$changeScene$1(this, continuation);
        Object obj2 = coupleAvatarViewController$changeScene$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$changeScene$1.label;
        if (i3 != 0) {
        }
        V = coupleAvatarViewController.V();
        if (V > 0) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void c(int width, int height) {
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            coupleAvatarLayout.setViewport(width, height);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void d(CoupleAvatarSubScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.subScene = scene;
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            coupleAvatarLayout.setSubScene(scene);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object e(Continuation<? super Integer> continuation) {
        CoupleAvatarViewController$getCurrentSceneId$1 coupleAvatarViewController$getCurrentSceneId$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        CoupleAvatarViewController coupleAvatarViewController2;
        CoupleAvatarViewController coupleAvatarViewController3;
        if (continuation instanceof CoupleAvatarViewController$getCurrentSceneId$1) {
            coupleAvatarViewController$getCurrentSceneId$1 = (CoupleAvatarViewController$getCurrentSceneId$1) continuation;
            int i16 = coupleAvatarViewController$getCurrentSceneId$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$getCurrentSceneId$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$getCurrentSceneId$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$getCurrentSceneId$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Integer c16 = CoupleAvatarSceneConfigManager.f330980a.c(this.peerUin);
                    int i17 = this.currentSceneId;
                    if (i17 != 0 && c16 != null && c16.intValue() == i17) {
                        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId has cache sceneId:" + this.currentSceneId);
                        return Boxing.boxInt(this.currentSceneId);
                    }
                    int coupleSceneId = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleSceneId(V());
                    if (c16 != null && c16.intValue() > 0 && c16.intValue() != coupleSceneId) {
                        if (b0() || !c0()) {
                            f0(c16.intValue());
                            int intValue = c16.intValue();
                            this.currentSceneId = intValue;
                            QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId switch to bothSceneId currentSceneId:" + intValue);
                            return Boxing.boxInt(this.currentSceneId);
                        }
                        if (coupleSceneId == 0) {
                            int intValue2 = c16.intValue();
                            this.currentSceneId = intValue2;
                            return Boxing.boxInt(intValue2);
                        }
                    }
                    if ((c16 == null || c16.intValue() == 0) && coupleSceneId == 0) {
                        coupleAvatarViewController$getCurrentSceneId$1.L$0 = this;
                        coupleAvatarViewController$getCurrentSceneId$1.label = 1;
                        obj = Q(coupleAvatarViewController$getCurrentSceneId$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coupleAvatarViewController = this;
                        int intValue3 = ((Number) obj).intValue();
                        coupleAvatarViewController.currentSceneId = intValue3;
                        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId getConfigDefaultSceneId currentSceneId:" + intValue3);
                        return Boxing.boxInt(coupleAvatarViewController.currentSceneId);
                    }
                    this.currentSceneId = coupleSceneId;
                    if (coupleSceneId <= 0) {
                        coupleAvatarViewController$getCurrentSceneId$1.L$0 = this;
                        coupleAvatarViewController$getCurrentSceneId$1.L$1 = this;
                        coupleAvatarViewController$getCurrentSceneId$1.label = 2;
                        obj = Q(coupleAvatarViewController$getCurrentSceneId$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coupleAvatarViewController2 = this;
                        coupleAvatarViewController3 = coupleAvatarViewController2;
                        coupleAvatarViewController3.currentSceneId = ((Number) obj).intValue();
                        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId error currentSceneId=0 changeToDefault");
                    } else {
                        coupleAvatarViewController2 = this;
                    }
                } else {
                    if (i3 == 1) {
                        coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$getCurrentSceneId$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        int intValue32 = ((Number) obj).intValue();
                        coupleAvatarViewController.currentSceneId = intValue32;
                        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId getConfigDefaultSceneId currentSceneId:" + intValue32);
                        return Boxing.boxInt(coupleAvatarViewController.currentSceneId);
                    }
                    if (i3 == 2) {
                        coupleAvatarViewController3 = (CoupleAvatarViewController) coupleAvatarViewController$getCurrentSceneId$1.L$1;
                        coupleAvatarViewController2 = (CoupleAvatarViewController) coupleAvatarViewController$getCurrentSceneId$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        coupleAvatarViewController3.currentSceneId = ((Number) obj).intValue();
                        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId error currentSceneId=0 changeToDefault");
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId currentSceneId:" + coupleAvatarViewController2.currentSceneId);
                return Boxing.boxInt(coupleAvatarViewController2.currentSceneId);
            }
        }
        coupleAvatarViewController$getCurrentSceneId$1 = new CoupleAvatarViewController$getCurrentSceneId$1(this, continuation);
        Object obj2 = coupleAvatarViewController$getCurrentSceneId$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$getCurrentSceneId$1.label;
        if (i3 != 0) {
        }
        QLog.i("CoupleAvatarViewController", 1, "getCurrentSceneId currentSceneId:" + coupleAvatarViewController2.currentSceneId);
        return Boxing.boxInt(coupleAvatarViewController2.currentSceneId);
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void f(CoupleAvatarSubScene coupleAvatarSubScene, g listener) {
        Intrinsics.checkNotNullParameter(coupleAvatarSubScene, "coupleAvatarSubScene");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.eventListenerMap.put(coupleAvatarSubScene, listener);
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void g() {
        QLog.i("CoupleAvatarViewController", 1, "hideInAIO " + this);
        this.mAIOContext.e().h(AIOMsgListEvent.RemoveAvatarAreaView.f188370d);
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.g
    public void h(CoupleAvatarLayoutEvent event, String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        g gVar = this.eventListenerMap.get(this.subScene);
        if (gVar != null) {
            gVar.h(event, data);
        }
        if (event != CoupleAvatarLayoutEvent.FIRST_RENDER || this.initFinish.get()) {
            return;
        }
        this.initFinish.set(true);
        h0();
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
        if (b16 == null) {
            return;
        }
        this.hasNetProcess = b16.optBoolean("hasNetProcess");
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void i(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
        if (coupleAvatarLayout != null) {
            coupleAvatarLayout.J(null, "requestRenderObjectNodePoint", data);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public boolean isInitFinished() {
        return this.initFinish.get();
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void j() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_CoupleAvatarViewController_showInAIO", null, null, null, new CoupleAvatarViewController$showInAIO$1(this, null), 14, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /* renamed from: l, reason: from getter */
    public CoupleAvatarSubScene getSubScene() {
        return this.subScene;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void m() {
        if (this.subScene == CoupleAvatarSubScene.AIO) {
            this.mAIOContext.e().h(AIOMsgListEvent.HideKeyBoardAndPanel.f188311d);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void n(le3.b actionConfig) {
        Intrinsics.checkNotNullParameter(actionConfig, "actionConfig");
        int id5 = actionConfig.getId();
        if (actionConfig.getActionType() == 2) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("coupleAnimationId", id5);
            CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
            if (coupleAvatarLayout != null) {
                coupleAvatarLayout.J(null, "CoupleAvatarScene.PlayCoupleAnimation", jSONObject.toString());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("avatarTarget", CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT);
        jSONObject2.put("singleAnimationId", id5);
        CoupleAvatarLayout coupleAvatarLayout2 = this.coupleAvatarLayout;
        if (coupleAvatarLayout2 != null) {
            coupleAvatarLayout2.J(null, "CoupleAvatarScene.PlaySingleAnimation", jSONObject2.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object o(Continuation<? super View> continuation) {
        CoupleAvatarViewController$getCoupleAvatarView$1 coupleAvatarViewController$getCoupleAvatarView$1;
        Object coroutine_suspended;
        int i3;
        CoupleAvatarViewController coupleAvatarViewController;
        if (continuation instanceof CoupleAvatarViewController$getCoupleAvatarView$1) {
            coupleAvatarViewController$getCoupleAvatarView$1 = (CoupleAvatarViewController$getCoupleAvatarView$1) continuation;
            int i16 = coupleAvatarViewController$getCoupleAvatarView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarViewController$getCoupleAvatarView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarViewController$getCoupleAvatarView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarViewController$getCoupleAvatarView$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.coupleAvatarLayout == null) {
                        coupleAvatarViewController$getCoupleAvatarView$1.L$0 = this;
                        coupleAvatarViewController$getCoupleAvatarView$1.label = 1;
                        if (Z(coupleAvatarViewController$getCoupleAvatarView$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        coupleAvatarViewController$getCoupleAvatarView$1.L$0 = this;
                        coupleAvatarViewController$getCoupleAvatarView$1.label = 2;
                        if (J(coupleAvatarViewController$getCoupleAvatarView$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    coupleAvatarViewController = this;
                } else {
                    if (i3 != 1 && i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coupleAvatarViewController = (CoupleAvatarViewController) coupleAvatarViewController$getCoupleAvatarView$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                CoupleAvatarLayout coupleAvatarLayout = coupleAvatarViewController.coupleAvatarLayout;
                Intrinsics.checkNotNull(coupleAvatarLayout);
                return coupleAvatarLayout;
            }
        }
        coupleAvatarViewController$getCoupleAvatarView$1 = new CoupleAvatarViewController$getCoupleAvatarView$1(this, continuation);
        Object obj2 = coupleAvatarViewController$getCoupleAvatarView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarViewController$getCoupleAvatarView$1.label;
        if (i3 != 0) {
        }
        CoupleAvatarLayout coupleAvatarLayout2 = coupleAvatarViewController.coupleAvatarLayout;
        Intrinsics.checkNotNull(coupleAvatarLayout2);
        return coupleAvatarLayout2;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public ImageView p(String peerUin, int width, int height, Context context) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(context, "context");
        return new CoupleAvatarFirstFrameImageView(peerUin, width, height, context, null, 16, null);
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void q(int newID) {
        this.intimateSceneId = newID;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /* renamed from: r, reason: from getter */
    public int getIntimateSceneId() {
        return this.intimateSceneId;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void s(i.ZPlanActionInfo actionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (!this.initFinish.get()) {
            i.ZPlanActionInfo b16 = i.ZPlanActionInfo.b(actionInfo, 0, null, false, false, 15, null);
            this.cachedActionInfo = b16;
            QLog.i("CoupleAvatarViewController", 1, "playAnimation, cache action data for init not finish, " + b16);
            return;
        }
        Pair pair = new Pair(Integer.valueOf(actionInfo.getActionId()), Boolean.valueOf(actionInfo.getIsMultiAction()));
        int intValue = ((Number) pair.component1()).intValue();
        if (((Boolean) pair.component2()).booleanValue()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("coupleAnimationId", intValue);
            CoupleAvatarLayout coupleAvatarLayout = this.coupleAvatarLayout;
            if (coupleAvatarLayout != null) {
                coupleAvatarLayout.J(null, "CoupleAvatarScene.PlayCoupleAnimation", jSONObject.toString());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        CoupleAvatarScene.AvatarTarget avatarTarget = CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT;
        jSONObject2.put("avatarTarget", avatarTarget);
        jSONObject2.put("singleAnimationId", intValue);
        if (!actionInfo.getIsSelf()) {
            avatarTarget = CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT;
        }
        jSONObject2.put("avatarTarget", avatarTarget);
        CoupleAvatarLayout coupleAvatarLayout2 = this.coupleAvatarLayout;
        if (coupleAvatarLayout2 != null) {
            coupleAvatarLayout2.J(null, "CoupleAvatarScene.PlaySingleAnimation", jSONObject2.toString());
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void u(boolean register, com.tencent.mobileqq.zplan.push.a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (register) {
            ZPlanNTPushHandler.f335027a.b(ZPlanNTPushHandler.PushType.SCENE_LINKAGE, observer);
        } else {
            ZPlanNTPushHandler.f335027a.c(ZPlanNTPushHandler.PushType.SCENE_LINKAGE, observer);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    /* renamed from: v, reason: from getter */
    public boolean getHasNetProcess() {
        return this.hasNetProcess;
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public String w(int sceneId, h listner) {
        Intrinsics.checkNotNullParameter(listner, "listner");
        CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager = CoupleAvatarSceneConfigManager.f330980a;
        n d16 = coupleAvatarSceneConfigManager.d(sceneId);
        if (d16 == null) {
            coupleAvatarSceneConfigManager.h(sceneId, listner);
            return null;
        }
        return d16.f413125f;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController$b", "Lcom/tencent/mobileqq/friends/intimate/d;", "", "isSuccess", "", "friendUin", "isPush", "", "onDisbandIntimateRelationship", "onBandIntimateRelationship", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.friends.intimate.d {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onBandIntimateRelationship(boolean isSuccess, String friendUin) {
            if (isSuccess && Intrinsics.areEqual(friendUin, CoupleAvatarViewController.this.getPeerUin())) {
                CoupleAvatarViewController.this.O();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onDisbandIntimateRelationship(boolean isSuccess, String friendUin, boolean isPush) {
            if (isSuccess && Intrinsics.areEqual(friendUin, CoupleAvatarViewController.this.getPeerUin())) {
                CoupleAvatarViewController.this.O();
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void k() {
        QLog.i("CoupleAvatarViewController", 1, "needToShowGrayTip");
        Integer c16 = CoupleAvatarSceneConfigManager.f330980a.c(this.peerUin);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_CoupleAvatarViewController_needToShowGrayTip", null, null, null, new CoupleAvatarViewController$needToShowGrayTip$1(c16, this, null), 14, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void t() {
        QLog.i("CoupleAvatarViewController", 1, "showFirstFrameInAIO");
        float a16 = ax.f335802a.a();
        int i3 = (int) (0.82f * a16);
        int i16 = (int) (a16 * 0.48f);
        CoupleAvatarFirstFrameImageView coupleAvatarFirstFrameImageView = new CoupleAvatarFirstFrameImageView(this.peerUin, i3, i16, R(), null, 16, null);
        coupleAvatarFirstFrameImageView.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
        coupleAvatarFirstFrameImageView.setMaxHeight(i16);
        this.mAIOContext.e().h(new AIOMsgListEvent.AddAvatarAreaView(coupleAvatarFirstFrameImageView));
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.i
    public void onMoveToState(int state) {
        if (state == 5) {
            N();
            return;
        }
        if (state == 7) {
            M();
        } else if (state == 11) {
            L();
        } else {
            if (state != 15) {
                return;
            }
            K();
        }
    }
}
