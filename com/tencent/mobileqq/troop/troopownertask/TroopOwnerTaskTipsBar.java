package com.tencent.mobileqq.troop.troopownertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskCacheRepo;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskRefreshDataEvent;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskRefreshUIEvent;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00025jB\u0007\u00a2\u0006\u0004\bp\u0010qJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J$\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0016\u0010\"\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0002J\u0016\u0010#\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002JS\u00100\u001a\u00020/2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070+H\u0002J)\u00105\u001a\u0004\u0018\u0001042\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102H\u0016\u00a2\u0006\u0004\b5\u00106J7\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\f2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102H\u0016\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010>\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J$\u0010B\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030@0?j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030@`AH\u0016J7\u0010E\u001a\u00020\u00072\u0006\u0010D\u001a\u00020C2\u0006\u00109\u001a\u00020\f2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102H\u0016\u00a2\u0006\u0004\bE\u0010FJ\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020%0\u0018H\u0016R\u0016\u0010J\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010PR\u0016\u0010U\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010VR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010YR\u0016\u0010\\\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\u000bR\u0016\u0010^\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010IR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010aR \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010YR\u0014\u0010f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010eR\u0016\u0010l\u001a\u0004\u0018\u00010i8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010kR \u0010o\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0m8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010n\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/TroopOwnerTaskTipsBar;", "Lcom/tencent/qqnt/aio/toptips/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskRefreshUIEvent;", "Lcom/tencent/mobileqq/aio/notification/d;", "Landroid/content/Context;", "context", "", "J", "", "url", "I", "", GdtGetUserInfoHandler.KEY_AREA, "K", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "task", "G", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/a;", "msg", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mobileqq/troop/troopownertask/TroopOwnerTaskTipsBar$b;", BdhLogUtil.LogTag.Tag_Conn, "H", "troopUin", "L", "P", HippyTKDListViewAdapter.X, "N", "O", "w", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "content", WadlProxyConsts.KEY_JUMP_URL, CacheTable.TABLE_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCloseClick", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "B", "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "eventType", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", h.F, "d", "Z", "needRefreshOnResume", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tipsContentText", "f", "Landroid/view/View;", "tipsJumpBtn", "tipsCloseBtn", "i", "Lcom/tencent/qqnt/aio/toptips/c;", "tipsManager", "Lcom/tencent/mobileqq/troop/troopownertask/TroopOwnerTaskTipsBar$b;", "currentTipsBarUIData", "", "Ljava/util/Map;", "taskReportParam", "D", "taskType", "E", "useNotification", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/notification/c;", "Ljava/lang/String;", "showingTaskNotificationToken", "showingMsgNotificationToken", "getType", "()I", "type", "j", "barPriority", "", "b", "()[I", "excludeTypes", "", "()Ljava/util/Map;", "reportParam", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopOwnerTaskTipsBar extends com.tencent.qqnt.aio.toptips.a implements SimpleEventReceiver<TroopOwnerTaskRefreshUIEvent>, com.tencent.mobileqq.aio.notification.d {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> taskReportParam;

    /* renamed from: D, reason: from kotlin metadata */
    private int taskType;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean useNotification;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.aio.notification.c notificationManager;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String showingTaskNotificationToken;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> showingMsgNotificationToken;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshOnResume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tipsContentText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View tipsJumpBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View tipsCloseBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.toptips.c tipsManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b currentTipsBarUIData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/TroopOwnerTaskTipsBar$a;", "", "", "ACTION_BTN_TEXT", "Ljava/lang/String;", "", "AREA_CLOSE_BTN", "I", "AREA_CONTENT", "AREA_JUMP_BTN", "TAG", "TYPE_MSG", "TYPE_TASK", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001BR\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001b\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010R2\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\u0017\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/TroopOwnerTaskTipsBar$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "f", "()I", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "", "c", "J", "()J", "latestTime", "d", WadlProxyConsts.KEY_JUMP_URL, "e", CacheTable.TABLE_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", GdtGetUserInfoHandler.KEY_AREA, "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "onCloseClick", "<init>", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long latestTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String jumpUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String reportInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Integer, Unit> onCloseClick;

        public b(int i3, @NotNull String content, long j3, @NotNull String jumpUrl, @NotNull String reportInfo, @NotNull Function1<? super Integer, Unit> onCloseClick) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), content, Long.valueOf(j3), jumpUrl, reportInfo, onCloseClick);
                return;
            }
            this.type = i3;
            this.content = content;
            this.latestTime = j3;
            this.jumpUrl = jumpUrl;
            this.reportInfo = reportInfo;
            this.onCloseClick = onCloseClick;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.jumpUrl;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.latestTime;
        }

        @NotNull
        public final Function1<Integer, Unit> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Function1) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.onCloseClick;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.reportInfo;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.type == bVar.type && Intrinsics.areEqual(this.content, bVar.content) && this.latestTime == bVar.latestTime && Intrinsics.areEqual(this.jumpUrl, bVar.jumpUrl) && Intrinsics.areEqual(this.reportInfo, bVar.reportInfo) && Intrinsics.areEqual(this.onCloseClick, bVar.onCloseClick)) {
                return true;
            }
            return false;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return (((((((((this.type * 31) + this.content.hashCode()) * 31) + androidx.fragment.app.a.a(this.latestTime)) * 31) + this.jumpUrl.hashCode()) * 31) + this.reportInfo.hashCode()) * 31) + this.onCloseClick.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "TipsBarUIData(type=" + this.type + ", content=" + this.content + ", latestTime=" + this.latestTime + ", jumpUrl=" + this.jumpUrl + ", reportInfo=" + this.reportInfo + ", onCloseClick=" + this.onCloseClick + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopOwnerTaskTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.taskReportParam = new LinkedHashMap();
        this.taskType = 116;
        this.showingTaskNotificationToken = "";
        this.showingMsgNotificationToken = new LinkedHashMap();
    }

    private final boolean A() {
        g gVar = g.f301003a;
        if (gVar.g() && gVar.d(H())) {
            return true;
        }
        return false;
    }

    private final IAIONotificationUIModel.b B(AIONotificationBusiId busiId, String taskId, String content, final String jumpUrl, final String reportInfo, final Function1<? super Integer, Unit> onCloseClick) {
        IAIONotificationUIModel.b bVar = new IAIONotificationUIModel.b(busiId, content, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(reportInfo, jumpUrl, onCloseClick) { // from class: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$createNotificationUI$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $jumpUrl;
            final /* synthetic */ Function1<Integer, Unit> $onCloseClick;
            final /* synthetic */ String $reportInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$reportInfo = reportInfo;
                this.$jumpUrl = jumpUrl;
                this.$onCloseClick = onCloseClick;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopOwnerTaskTipsBar.this, reportInfo, jumpUrl, onCloseClick);
                }
            }

            public final void invoke(@NotNull IAIONotificationUIModel uiModel, int i3) {
                Map map;
                com.tencent.mobileqq.aio.notification.c cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                int i16 = 2;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiModel, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(uiModel, "uiModel");
                map = TroopOwnerTaskTipsBar.this.taskReportParam;
                map.put("ext_info", this.$reportInfo);
                if (i3 == 1) {
                    TroopOwnerTaskTipsBar.this.I(this.$jumpUrl);
                    i16 = 3;
                } else if (i3 != 2 && i3 == 3) {
                    TroopOwnerTaskTipsBar.this.I(this.$jumpUrl);
                    i16 = 1;
                }
                TroopOwnerTaskTipsBar.this.Q(i16);
                this.$onCloseClick.invoke(Integer.valueOf(i16));
                cVar = TroopOwnerTaskTipsBar.this.notificationManager;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                    cVar = null;
                }
                cVar.g(uiModel.getToken());
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                invoke(iAIONotificationUIModel, num.intValue());
                return Unit.INSTANCE;
            }
        }, 24, null);
        bVar.a(busiId.getTag() + taskId);
        return bVar;
    }

    private final b C(final com.tencent.mobileqq.troop.troopownertask.api.impl.b task, List<com.tencent.mobileqq.troop.troopownertask.api.impl.a> msgList) {
        b bVar;
        final com.tencent.mobileqq.troop.troopownertask.api.impl.a h16;
        b bVar2 = null;
        if (task != null && task.c() > 0 && !z(task)) {
            bVar = new b(116, G(task), task.b(), task.a(), task.d(), new Function1<Integer, Unit>(task) { // from class: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$findNeedShowTips$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.troopownertask.api.impl.b $task;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$task = task;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOwnerTaskTipsBar.this, (Object) task);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    String H;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
                    H = TroopOwnerTaskTipsBar.this.H();
                    troopOwnerTaskCacheRepo.u(H, this.$task.b());
                }
            });
        } else {
            bVar = null;
        }
        boolean z16 = false;
        if (msgList != null && (!msgList.isEmpty())) {
            z16 = true;
        }
        if (z16 && (h16 = g.f301003a.h(msgList)) != null && !y(h16)) {
            bVar2 = new b(117, h16.a(), h16.c(), h16.b(), h16.e(), new Function1<Integer, Unit>(h16) { // from class: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$findNeedShowTips$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.troopownertask.api.impl.a $latestMsg;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$latestMsg = h16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOwnerTaskTipsBar.this, (Object) h16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    String H;
                    ArrayList arrayListOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
                    H = TroopOwnerTaskTipsBar.this.H();
                    troopOwnerTaskCacheRepo.a(H, this.$latestMsg);
                    com.tencent.mobileqq.troop.troopownertask.api.impl.e eVar = com.tencent.mobileqq.troop.troopownertask.api.impl.e.f300991a;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$latestMsg.d());
                    eVar.a(arrayListOf, i3);
                }
            });
        }
        if (bVar != null && bVar2 != null) {
            if (bVar.c() <= bVar2.c()) {
                return bVar2;
            }
            return bVar;
        }
        if (bVar == null) {
            return bVar2;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TroopOwnerTaskTipsBar this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J(context);
        this$0.Q(1);
        this$0.K(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TroopOwnerTaskTipsBar this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J(context);
        this$0.Q(3);
        this$0.K(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TroopOwnerTaskTipsBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q(2);
        this$0.K(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String G(com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        return "\u4f60\u6709" + task.c() + "\u4e2a\u7fa4\u4e3b\u4efb\u52a1\u5f85\u67e5\u770b";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H() {
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        return cVar.a().g().r().c().j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String url) {
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            cVar = null;
        }
        Context context = cVar.a().c().getContext();
        if (context != null) {
            g.f301003a.i(context, url);
        }
        this.needRefreshOnResume = true;
    }

    private final void J(Context context) {
        b bVar = this.currentTipsBarUIData;
        if (bVar != null) {
            g.f301003a.i(context, bVar.b());
        }
        this.needRefreshOnResume = true;
    }

    private final void K(int area) {
        Function1<Integer, Unit> d16;
        b bVar = this.currentTipsBarUIData;
        if (bVar != null && (d16 = bVar.d()) != null) {
            d16.invoke(Integer.valueOf(area));
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        cVar.i(this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(final String troopUin, final com.tencent.mobileqq.troop.troopownertask.api.impl.b task, final List<com.tencent.mobileqq.troop.troopownertask.api.impl.a> msgList) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopownertask.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopOwnerTaskTipsBar.M(TroopOwnerTaskTipsBar.this, msgList, task, troopUin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(TroopOwnerTaskTipsBar this$0, List list, com.tencent.mobileqq.troop.troopownertask.api.impl.b bVar, String troopUin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (this$0.A()) {
            if (this$0.useNotification) {
                if (list != null) {
                    this$0.O(list);
                    this$0.w(list);
                } else {
                    this$0.N();
                }
                if (bVar != null) {
                    this$0.x(bVar);
                } else {
                    this$0.P();
                }
            } else {
                b C = this$0.C(bVar, list);
                this$0.currentTipsBarUIData = C;
                if (C != null) {
                    this$0.taskType = C.f();
                    this$0.taskReportParam.put("ext_info", C.e());
                    com.tencent.qqnt.aio.toptips.c cVar = this$0.tipsManager;
                    AppInterface appInterface = null;
                    if (cVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
                        cVar = null;
                    }
                    cVar.e(this$0);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime instanceof AppInterface) {
                        appInterface = (AppInterface) peekAppRuntime;
                    }
                    if (appInterface != null) {
                        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(appInterface);
                    }
                }
            }
        }
        if (bVar != null) {
            g.f301003a.k(troopUin, bVar);
        }
    }

    private final void N() {
        for (Map.Entry<String, String> entry : this.showingMsgNotificationToken.entrySet()) {
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                cVar = null;
            }
            cVar.g(entry.getValue());
        }
    }

    private final void O(List<com.tencent.mobileqq.troop.troopownertask.api.impl.a> msgList) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.troopownertask.api.impl.a> it = msgList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e());
        }
        for (Map.Entry<String, String> entry : this.showingMsgNotificationToken.entrySet()) {
            if (!arrayList.contains(entry.getKey())) {
                com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                    cVar = null;
                }
                cVar.g(entry.getValue());
            }
        }
    }

    private final void P() {
        boolean z16;
        String str = this.showingTaskNotificationToken;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                cVar = null;
            }
            cVar.g(str);
        }
        this.showingTaskNotificationToken = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int area) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(d());
        hashMap.put("horizontal_service_id", Integer.valueOf(getType()));
        hashMap.put("horizontal_click_area", Integer.valueOf(area));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_horizontal", hashMap);
    }

    private final void w(List<com.tencent.mobileqq.troop.troopownertask.api.impl.a> msgList) {
        for (final com.tencent.mobileqq.troop.troopownertask.api.impl.a aVar : msgList) {
            if (!this.showingMsgNotificationToken.containsKey(aVar.e()) && !y(aVar)) {
                IAIONotificationUIModel.b B = B(AIONotificationBusiId.TROOP_OWNER_MSG, aVar.e(), aVar.a(), aVar.b(), aVar.e(), new Function1<Integer, Unit>(aVar) { // from class: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$addNewMsgNotification$notification$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.troop.troopownertask.api.impl.a $msg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$msg = aVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOwnerTaskTipsBar.this, (Object) aVar);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        String H;
                        ArrayList arrayListOf;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
                        H = TroopOwnerTaskTipsBar.this.H();
                        troopOwnerTaskCacheRepo.a(H, this.$msg);
                        com.tencent.mobileqq.troop.troopownertask.api.impl.e eVar = com.tencent.mobileqq.troop.troopownertask.api.impl.e.f300991a;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$msg.d());
                        eVar.a(arrayListOf, i3);
                    }
                });
                this.showingMsgNotificationToken.put(aVar.e(), B.getToken());
                com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                    cVar = null;
                }
                cVar.c(B);
            }
        }
    }

    private final void x(final com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        if (task.c() > 0 && !z(task)) {
            IAIONotificationUIModel.b B = B(AIONotificationBusiId.TROOP_OWNER_TASK, "", G(task), task.a(), task.d(), new Function1<Integer, Unit>(task) { // from class: com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar$addTaskNotification$notification$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.troopownertask.api.impl.b $task;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$task = task;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOwnerTaskTipsBar.this, (Object) task);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    String H;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
                    H = TroopOwnerTaskTipsBar.this.H();
                    troopOwnerTaskCacheRepo.u(H, this.$task.b());
                }
            });
            this.showingTaskNotificationToken = B.getToken();
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                cVar = null;
            }
            cVar.c(B);
        }
    }

    private final boolean y(com.tencent.mobileqq.troop.troopownertask.api.impl.a msg2) {
        if (TroopOwnerTaskCacheRepo.f300970a.e(H(), msg2)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskTipsBar", 2, "checkHasCloseCurrentMsg true msg=" + msg2.e());
                return true;
            }
            return true;
        }
        return false;
    }

    private final boolean z(com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        if (task.b() <= TroopOwnerTaskCacheRepo.f300970a.l(H())) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskTipsBar", 2, "checkHasCloseCurrentTask: true");
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.aio.toptips.c cVar = this.tipsManager;
        View view = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsManager");
            cVar = null;
        }
        final Context context = cVar.a().c().getContext();
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.i0j, (ViewGroup) new FrameLayout(context), false);
        View findViewById = inflate.findViewById(R.id.f1034460m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "barView.findViewById(R.i\u2026oop_ott_tips_bar_content)");
        this.tipsContentText = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f1034560n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "barView.findViewById(R.id.troop_ott_tips_bar_jump)");
        this.tipsJumpBtn = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f1034360l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "barView.findViewById(R.i\u2026troop_ott_tips_bar_close)");
        this.tipsCloseBtn = findViewById3;
        b bVar = this.currentTipsBarUIData;
        if (bVar != null) {
            TextView textView = this.tipsContentText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsContentText");
                textView = null;
            }
            textView.setText(bVar.a());
        }
        View view2 = this.tipsJumpBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsJumpBtn");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopownertask.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TroopOwnerTaskTipsBar.D(TroopOwnerTaskTipsBar.this, context, view3);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopownertask.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TroopOwnerTaskTipsBar.E(TroopOwnerTaskTipsBar.this, context, view3);
            }
        });
        View view3 = this.tipsCloseBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsCloseBtn");
        } else {
            view = view3;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopownertask.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                TroopOwnerTaskTipsBar.F(TroopOwnerTaskTipsBar.this, view4);
            }
        });
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.toptips.a, com.tencent.qqnt.aio.toptips.b
    @NotNull
    public Map<String, String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.taskReportParam;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, topTipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (topTipsManager.a().g().r().c().e() != 2) {
            return;
        }
        this.tipsManager = topTipsManager;
        if (!g.f301003a.g()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskTipsBar", 2, "onAIOEvent: not enable");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskTipsBar", 2, "onMoveToState state:" + eventType);
        }
        if (eventType != 1004) {
            if (eventType == 1007) {
                SimpleEventBus.getInstance().registerReceiver(this);
                if (this.needRefreshOnResume) {
                    SimpleEventBus.getInstance().dispatchEvent(new TroopOwnerTaskRefreshDataEvent(H()));
                    this.needRefreshOnResume = false;
                    return;
                }
                return;
            }
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<TroopOwnerTaskRefreshUIEvent>> getEventClass() {
        ArrayList<Class<TroopOwnerTaskRefreshUIEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopOwnerTaskRefreshUIEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.taskType;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AIONotificationBusiId[]{AIONotificationBusiId.TROOP_OWNER_TASK, AIONotificationBusiId.TROOP_OWNER_MSG});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        this.notificationManager = notificationManager;
        this.useNotification = true;
        if (eventType == com.tencent.mobileqq.aio.notification.d.INSTANCE.b()) {
            g((com.tencent.qqnt.aio.toptips.c) notificationManager, 1005, params);
        } else {
            g((com.tencent.qqnt.aio.toptips.c) notificationManager, eventType, params);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TroopOwnerTaskRefreshUIEvent) {
            troopOwnerTaskRefreshUIEvent = (TroopOwnerTaskRefreshUIEvent) event;
        } else {
            troopOwnerTaskRefreshUIEvent = null;
        }
        if (troopOwnerTaskRefreshUIEvent != null) {
            String H = H();
            if (!Intrinsics.areEqual(troopOwnerTaskRefreshUIEvent.getTroopUin(), H)) {
                return;
            }
            g.f301003a.b(H, new TroopOwnerTaskTipsBar$onReceiveEvent$1$1(this, H, troopOwnerTaskRefreshUIEvent));
        }
    }
}
