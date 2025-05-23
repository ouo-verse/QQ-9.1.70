package com.tencent.qqnt.aio.toptip;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.location.a;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.TipsBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.toptip.LocationShareTipsBar;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006*\u0001R\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB\u0007\u00a2\u0006\u0004\bg\u0010hJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fJ)\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ7\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00142\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0012\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010+\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0)J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0)H\u0016J\b\u0010/\u001a\u00020.H\u0016J7\u00102\u001a\u00020\b2\u0006\u00101\u001a\u0002002\u0006\u0010 \u001a\u00020\u00142\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00108R\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010+R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010VR\u001a\u0010Z\u001a\u00020\u00148\u0016X\u0096D\u00a2\u0006\f\n\u0004\b+\u0010+\u001a\u0004\bX\u0010YR\u001c\u0010`\u001a\u0004\u0018\u00010[8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010c\u001a\u00020\u00148\u0016X\u0096D\u00a2\u0006\f\n\u0004\ba\u0010+\u001a\u0004\bb\u0010YR\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010\\\u00a8\u0006j"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/LocationShareTipsBar;", "Lcom/tencent/qqnt/aio/toptips/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/notification/e;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "newStatus", "", "H", "Lcom/tencent/mobileqq/location/data/LocationRoom$b;", "roomKey", "", "uin", "Lkotlin/Function1;", "callback", HippyTKDListViewAdapter.X, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "sessionUin", "B", "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "eventType", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "v", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_CLICK, "userName", "count", "", SquareJSConst.Params.PARAMS_UIN_LIST, "I", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", tl.h.F, "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "Lcom/tencent/mobileqq/qqui/widget/TipsBar;", "d", "Lcom/tencent/mobileqq/qqui/widget/TipsBar;", "mTipsBarView", "Z", "mHasReportedShown", "f", "Lcom/tencent/qqnt/aio/toptips/c;", "mManager", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "i", "Lcom/tencent/mobileqq/location/data/LocationRoom$b;", "mRoomKey", "isShowing", BdhLogUtil.LogTag.Tag_Conn, "memberCnt", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "D", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "notification", "Lcom/tencent/mobileqq/location/a$a;", "E", "Lcom/tencent/mobileqq/location/a$a;", "mLocationListener", "Lcom/tencent/mobileqq/location/callback/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/location/callback/d;", "mFloatMapCallback", "com/tencent/qqnt/aio/toptip/LocationShareTipsBar$c", "Lcom/tencent/qqnt/aio/toptip/LocationShareTipsBar$c;", "troopObserver", "Lcom/tencent/mobileqq/location/h;", "Lcom/tencent/mobileqq/location/h;", "mUpdateListener", "j", "()I", "barPriority", "", "J", "[I", "b", "()[I", "excludeTypes", "K", "getType", "type", "", "L", "sLastLaunchTime", "<init>", "()V", "M", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LocationShareTipsBar extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener, com.tencent.mobileqq.aio.notification.e {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int memberCnt;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IAIONotificationUIModel.b notification;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a.InterfaceC7969a mLocationListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.location.callback.d mFloatMapCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final c troopObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.location.h mUpdateListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final int barPriority;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final int[] excludeTypes;

    /* renamed from: K, reason: from kotlin metadata */
    private final int type;

    /* renamed from: L, reason: from kotlin metadata */
    private long sLastLaunchTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TipsBar mTipsBarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasReportedShown;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.toptips.c mManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocationRoom.b mRoomKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/LocationShareTipsBar$a;", "", "", "TAG", "Ljava/lang/String;", "", "TIME_INTERVAL", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.toptip.LocationShareTipsBar$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/aio/toptip/LocationShareTipsBar$b", "Lcom/tencent/mobileqq/location/callback/d;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/location/data/LocationRoom$b;", "roomKey", "", "b", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mobileqq.location.callback.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareTipsBar.this);
            }
        }

        @Override // com.tencent.mobileqq.location.callback.d
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.location.callback.d
        public boolean b(@NotNull QBaseActivity activity, @NotNull LocationRoom.b roomKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) roomKey)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(roomKey, "roomKey");
            QLog.i("LocationShareTipsBar", 2, "onEnterFloat have show float hideLocationShareTips");
            LocationRoom.b bVar = LocationShareTipsBar.this.mRoomKey;
            if (bVar != null) {
                LocationShareTipsBar locationShareTipsBar = LocationShareTipsBar.this;
                if (Intrinsics.areEqual(bVar, roomKey)) {
                    locationShareTipsBar.A();
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.location.callback.d
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/aio/toptip/LocationShareTipsBar$c", "Lcom/tencent/mobileqq/troop/api/observer/e;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "info", "", "c", "", "isSuc", "", "uin", "onGetTroopInfoResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareTipsBar.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0, TroopInfo troopInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c(troopInfo);
        }

        private final void c(TroopInfo info) {
            String str;
            com.tencent.aio.api.runtime.a aVar = null;
            if (info != null) {
                str = info.troopuin;
            } else {
                str = null;
            }
            com.tencent.aio.api.runtime.a aVar2 = LocationShareTipsBar.this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            if (Intrinsics.areEqual(str, aVar2.g().r().c().j())) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                ILocationShareService b16 = com.tencent.mobileqq.location.e.b((QQAppInterface) peekAppRuntime);
                LocationRoom.b bVar = LocationShareTipsBar.this.mRoomKey;
                if (bVar != null) {
                    LocationShareTipsBar locationShareTipsBar = LocationShareTipsBar.this;
                    com.tencent.aio.api.runtime.a aVar3 = locationShareTipsBar.mAIOContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar = aVar3;
                    }
                    j e16 = aVar.e();
                    String c16 = bVar.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "it.sessionUin");
                    e16.h(new AIOMsgListEvent.UpdateLocationShare(c16, b16.isSessionSharingLocation(bVar.b(), bVar.c())));
                    locationShareTipsBar.w();
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean isSuc, @Nullable String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), uin);
                return;
            }
            if (uin == null) {
                return;
            }
            final TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(uin);
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                c(troopInfoFromCache);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationShareTipsBar.c.b(LocationShareTipsBar.c.this, troopInfoFromCache);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LocationShareTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLocationListener = new a.InterfaceC7969a() { // from class: com.tencent.qqnt.aio.toptip.b
            @Override // com.tencent.mobileqq.location.a.InterfaceC7969a
            public final void a(Contact contact, Boolean bool) {
                LocationShareTipsBar.C(LocationShareTipsBar.this, contact, bool);
            }
        };
        this.mFloatMapCallback = new b();
        this.troopObserver = new c();
        this.mUpdateListener = new com.tencent.mobileqq.location.h() { // from class: com.tencent.qqnt.aio.toptip.LocationShareTipsBar$mUpdateListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareTipsBar.this);
                }
            }

            @Override // com.tencent.mobileqq.location.h
            public void a(@Nullable LocationRoom.b roomKey, int clientType) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) roomKey, clientType);
                    return;
                }
                LocationShareTipsBar locationShareTipsBar = LocationShareTipsBar.this;
                Intrinsics.checkNotNull(roomKey);
                int b16 = roomKey.b();
                String c16 = roomKey.c();
                Intrinsics.checkNotNullExpressionValue(c16, "roomKey.sessionUin");
                if (locationShareTipsBar.B(b16, c16)) {
                    com.tencent.aio.api.runtime.a aVar = LocationShareTipsBar.this.mAIOContext;
                    com.tencent.aio.api.runtime.a aVar2 = null;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar = null;
                    }
                    j e16 = aVar.e();
                    com.tencent.aio.api.runtime.a aVar3 = LocationShareTipsBar.this.mAIOContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar2 = aVar3;
                    }
                    e16.h(new AIOMsgListEvent.UpdateLocationShare(aVar2.g().r().c().j(), false));
                    LocationShareTipsBar.this.A();
                }
            }

            @Override // com.tencent.mobileqq.location.h
            public void b(@Nullable LocationRoom.b roomKey, int reason) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) roomKey, reason);
                    return;
                }
                LocationShareTipsBar locationShareTipsBar = LocationShareTipsBar.this;
                Intrinsics.checkNotNull(roomKey);
                int b16 = roomKey.b();
                String c16 = roomKey.c();
                Intrinsics.checkNotNullExpressionValue(c16, "roomKey.sessionUin");
                if (locationShareTipsBar.B(b16, c16)) {
                    com.tencent.aio.api.runtime.a aVar = LocationShareTipsBar.this.mAIOContext;
                    com.tencent.aio.api.runtime.a aVar2 = null;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar = null;
                    }
                    j e16 = aVar.e();
                    com.tencent.aio.api.runtime.a aVar3 = LocationShareTipsBar.this.mAIOContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar2 = aVar3;
                    }
                    e16.h(new AIOMsgListEvent.UpdateLocationShare(aVar2.g().r().c().j(), false));
                    LocationShareTipsBar.this.A();
                }
            }

            @Override // com.tencent.mobileqq.location.h
            public void c(@Nullable LocationRoom.b roomKey, int errorCode, int operateType) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, roomKey, Integer.valueOf(errorCode), Integer.valueOf(operateType));
                } else {
                    QLog.i("LocationShareTipsBar", 2, "onOperateRoomResponse $");
                }
            }

            @Override // com.tencent.mobileqq.location.h
            public void d(@Nullable LocationRoom.b roomKey, @Nullable LocationRoom.Venue venue, @Nullable final List<com.tencent.mobileqq.location.data.a> itemList) {
                String str;
                Integer num;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, roomKey, venue, itemList);
                    return;
                }
                com.tencent.aio.api.runtime.a aVar = null;
                if (QLog.isColorLevel()) {
                    if (roomKey != null) {
                        str = roomKey.c();
                    } else {
                        str = null;
                    }
                    if (itemList != null) {
                        num = Integer.valueOf(itemList.size());
                    } else {
                        num = null;
                    }
                    QLog.d("LocationShareTipsBar", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin:" + str + " itemList: " + num);
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                IFloatMapService a16 = com.tencent.mobileqq.location.e.a(qQAppInterface);
                Intrinsics.checkNotNullExpressionValue(a16, "floatMapService(app)");
                LocationRoom.b currentFloatWindowVisibleRoomKey = a16.currentFloatWindowVisibleRoomKey();
                Intrinsics.checkNotNullExpressionValue(currentFloatWindowVisibleRoomKey, "floatMapService.currentFloatWindowVisibleRoomKey()");
                LocationShareTipsBar locationShareTipsBar = LocationShareTipsBar.this;
                Intrinsics.checkNotNull(roomKey);
                int b16 = roomKey.b();
                String c16 = roomKey.c();
                Intrinsics.checkNotNullExpressionValue(c16, "roomKey.sessionUin");
                if (!locationShareTipsBar.B(b16, c16)) {
                    return;
                }
                if (itemList != null && !itemList.isEmpty()) {
                    final ArrayList arrayList = new ArrayList();
                    int size = itemList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.add(itemList.get(i3).d());
                    }
                    com.tencent.aio.api.runtime.a aVar2 = LocationShareTipsBar.this.mAIOContext;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar2 = null;
                    }
                    j e16 = aVar2.e();
                    com.tencent.aio.api.runtime.a aVar3 = LocationShareTipsBar.this.mAIOContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar = aVar3;
                    }
                    e16.h(new AIOMsgListEvent.UpdateLocationShare(aVar.g().r().c().j(), true));
                    if (arrayList.contains(qQAppInterface.getCurrentUin())) {
                        return;
                    }
                    if (Intrinsics.areEqual(currentFloatWindowVisibleRoomKey, roomKey)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("LocationShareTipsBar", 2, "onUpdateUserLocations: invoked. roomKey: " + roomKey + " currentFloatWindowVisibleRoomKey:" + currentFloatWindowVisibleRoomKey);
                            return;
                        }
                        return;
                    }
                    LocationShareTipsBar locationShareTipsBar2 = LocationShareTipsBar.this;
                    Object obj = arrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "uinList[0]");
                    final LocationShareTipsBar locationShareTipsBar3 = LocationShareTipsBar.this;
                    locationShareTipsBar2.x(roomKey, (String) obj, new Function1<String, Unit>(itemList, arrayList) { // from class: com.tencent.qqnt.aio.toptip.LocationShareTipsBar$mUpdateListener$1$onUpdateUserLocations$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ List<com.tencent.mobileqq.location.data.a> $itemList;
                        final /* synthetic */ ArrayList<String> $uinList;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$itemList = itemList;
                            this.$uinList = arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, LocationShareTipsBar.this, itemList, arrayList);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String it) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            LocationShareTipsBar.this.I(it, this.$itemList.size(), this.$uinList);
                            LocationShareTipsBar.this.G();
                        }
                    });
                    return;
                }
                QLog.i("LocationShareTipsBar", 2, "onUpdateUserLocations send updateLocationShareIntent");
                LocationShareTipsBar.this.A();
            }
        };
        this.barPriority = 3;
        this.excludeTypes = new int[0];
        this.type = 102;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final LocationShareTipsBar this$0, final Contact contact, final Boolean newStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Intrinsics.checkNotNullExpressionValue(contact, "contact");
            Intrinsics.checkNotNullExpressionValue(newStatus, "newStatus");
            this$0.H(contact, newStatus.booleanValue());
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.c
            @Override // java.lang.Runnable
            public final void run() {
                LocationShareTipsBar.D(LocationShareTipsBar.this, contact, newStatus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(LocationShareTipsBar this$0, Contact contact, Boolean newStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(contact, "contact");
        Intrinsics.checkNotNullExpressionValue(newStatus, "newStatus");
        this$0.H(contact, newStatus.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final LocationShareTipsBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.location.a.e(this$0.mLocationListener);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        ILocationShareService b16 = com.tencent.mobileqq.location.e.b(qQAppInterface);
        IFloatMapService a16 = com.tencent.mobileqq.location.e.a(qQAppInterface);
        b16.addLocationUpdateListener(this$0.mUpdateListener);
        a16.addFloatMapCallback(this$0.mFloatMapCallback);
        qQAppInterface.addObserver(this$0.troopObserver);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.e
            @Override // java.lang.Runnable
            public final void run() {
                LocationShareTipsBar.F(LocationShareTipsBar.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(LocationShareTipsBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    private final void H(Contact contact, boolean newStatus) {
        int i3 = contact.chatType;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        if (i3 == com.tencent.guild.aio.util.a.e(g16)) {
            String str = contact.peerUid;
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            if (Intrinsics.areEqual(str, aVar3.g().r().c().j())) {
                com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar2 = aVar4;
                }
                j e16 = aVar2.e();
                String str2 = contact.peerUid;
                Intrinsics.checkNotNullExpressionValue(str2, "contact.peerUid");
                e16.h(new AIOMsgListEvent.UpdateLocationShare(str2, newStatus));
            }
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ILocationShareService b16 = com.tencent.mobileqq.location.e.b((QQAppInterface) peekAppRuntime);
        LocationRoom.b bVar = this.mRoomKey;
        if (bVar != null && !b16.isSessionSharingLocation(bVar.b(), bVar.c())) {
            A();
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        SessionInfo a16 = su3.b.a(g16);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        AIOParam g17 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAIOContext.aioParam");
        Integer p16 = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(g17)));
        Intrinsics.checkNotNullExpressionValue(p16, "getOldUinType(mAIOContext.aioParam.getChatType())");
        int intValue = p16.intValue();
        String str = a16.f179557e;
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
        this.mRoomKey = new LocationRoom.b(intValue, str);
        if (b16.isSessionSharingLocation(intValue, str)) {
            if (QLog.isColorLevel()) {
                LocationRoom.b bVar2 = this.mRoomKey;
                Intrinsics.checkNotNull(bVar2);
                QLog.d("LocationShareTipsBar", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + bVar2.c());
            }
            b16.requestQueryRoom(intValue, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(LocationRoom.b roomKey, String uin, final Function1<? super String, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (roomKey.b() == 0) {
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
            aVar.d(uidFromUin);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (nameWithConfig == null) {
                nameWithConfig = "";
            }
            callback.invoke(nameWithConfig);
            return;
        }
        if (roomKey.b() == 1) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(roomKey.c(), uin, "LocationShareTipsBar", new Function1<TroopMemberNickInfo, Unit>(callback) { // from class: com.tencent.qqnt.aio.toptip.LocationShareTipsBar$getNickName$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<String, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                    invoke2(troopMemberNickInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                        return;
                    }
                    Function1<String, Unit> function1 = this.$callback;
                    if (troopMemberNickInfo == null || (str = troopMemberNickInfo.getShowName()) == null) {
                        str = "";
                    }
                    function1.invoke(str);
                }
            });
            return;
        }
        String nickName = ac.Q(qQAppInterface, uin, 0);
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        callback.invoke(nickName);
    }

    private final String y() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (aVar.g().r().c().e() == 1) {
            return "\u5bf9\u65b9\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e";
        }
        return this.memberCnt + "\u4eba\u6b63\u5728\u5171\u4eab\u4f4d\u7f6e";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ILocationShareService b16 = com.tencent.mobileqq.location.e.b((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        AIOParam g16 = aVar3.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        int i3 = su3.b.a(g16).f179555d;
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar4;
        }
        AIOParam g17 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAIOContext.aioParam");
        b16.launchShareUi(activity, i3, su3.b.a(g17).f179557e, 3);
        ReportController.o(null, "CliOper", "", "", "0X800A768", "0X800A768", 0, 0, "", "0", "0", "");
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.isShowing) {
            QLog.i("LocationShareTipsBar", 1, "hideLocationShareTips.");
            com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
            if (cVar != null) {
                cVar.h(this);
            }
        }
        this.isShowing = false;
    }

    public final boolean B(int sessionType, @NotNull String sessionUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, sessionType, (Object) sessionUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sessionUin, "sessionUin");
        if (this.mRoomKey == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareTipsBar", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + sessionType + " sessionUin: " + sessionUin + " [mRoomKey] null ");
                return false;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            LocationRoom.b bVar = this.mRoomKey;
            Intrinsics.checkNotNull(bVar);
            int b16 = bVar.b();
            LocationRoom.b bVar2 = this.mRoomKey;
            Intrinsics.checkNotNull(bVar2);
            QLog.d("LocationShareTipsBar", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + sessionType + " sessionUin: " + sessionUin + " [mRoomKey] sessionType: " + b16 + " [mRoomKey] sessionUin: " + bVar2.c());
        }
        LocationRoom.b bVar3 = this.mRoomKey;
        Intrinsics.checkNotNull(bVar3);
        return bVar3.a(sessionType, sessionUin);
    }

    public final void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!this.isShowing) {
            QLog.i("LocationShareTipsBar", 1, "showLocationShareTips.");
            com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
            if (cVar != null) {
                cVar.e(this);
            }
        }
        this.isShowing = true;
    }

    public final void I(@Nullable String userName, int count, @NotNull List<String> uinList) {
        FragmentActivity fragmentActivity;
        boolean z16;
        String str;
        TipsBar tipsBar;
        TipsBar tipsBar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, userName, Integer.valueOf(count), uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String str2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (aVar.c() != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            if (aVar2.c().getContext() != null) {
                if (this.mTipsBarView == null) {
                    com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar3 = null;
                    }
                    TipsBar tipsBar3 = new TipsBar(aVar3.c().getContext());
                    tipsBar3.C(true);
                    tipsBar3.setBarType(2);
                    this.mTipsBarView = tipsBar3;
                }
                this.memberCnt = count;
                TipsBar tipsBar4 = this.mTipsBarView;
                if (tipsBar4 != null) {
                    tipsBar4.setOnClickListener(this);
                }
                com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar4 = null;
                }
                Fragment c16 = aVar4.c();
                if (c16 != null) {
                    fragmentActivity = c16.getActivity();
                } else {
                    fragmentActivity = null;
                }
                if (userName != null && userName.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    str = y();
                } else {
                    if (count == 1) {
                        if (fragmentActivity != null) {
                            str2 = fragmentActivity.getString(R.string.iwg);
                        }
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Intrinsics.checkNotNull(fragmentActivity);
                        String string = fragmentActivity.getString(R.string.iwf);
                        Intrinsics.checkNotNullExpressionValue(string, "activity!!.getString(R.s\u2026are_tips_suffix_multiple)");
                        str2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    }
                    str = userName + str2;
                }
                TipsBar tipsBar5 = this.mTipsBarView;
                if (tipsBar5 != null) {
                    tipsBar5.setTipsText(str);
                }
                if (!this.mHasReportedShown) {
                    ReportController.o(null, "CliOper", "", "", "0X800A767", "0X800A767", 2, 0, "", "0", "0", "");
                    this.mHasReportedShown = true;
                }
                if (AppSetting.f99565y && (tipsBar2 = this.mTipsBarView) != null) {
                    tipsBar2.setContentDescription(str + " \u70b9\u51fb\u52a0\u5165\u4f4d\u7f6e\u5171\u4eab");
                }
                if ((!uinList.isEmpty()) && !TextUtils.isEmpty(uinList.get(0)) && (tipsBar = this.mTipsBarView) != null) {
                    Object[] array = uinList.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    tipsBar.setAvatarUins((String[]) array);
                }
                IAIONotificationUIModel.b bVar = this.notification;
                if (bVar != null) {
                    bVar.h(y());
                    com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
                    Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationManager");
                    ((com.tencent.mobileqq.aio.notification.c) cVar).j(bVar.getToken(), bVar);
                }
                QLog.d("LocationShareTipsBar", 2, "updateTipView, memberCnt=" + this.memberCnt);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return this.mTipsBarView;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.excludeTypes;
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NotNull
    public IAIONotificationUIModel e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        QLog.i("LocationShareTipsBar", 1, "getNotificationUIModel");
        if (this.notification == null) {
            this.notification = new IAIONotificationUIModel.b(AIONotificationBusiId.SHARE_LOCATION, y(), IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>() { // from class: com.tencent.qqnt.aio.toptip.LocationShareTipsBar$getNotificationUIModel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareTipsBar.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                    invoke(iAIONotificationUIModel, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i3);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                    if (i3 == 1 || i3 == 2) {
                        LocationShareTipsBar.this.z();
                    }
                }
            }, 24, null);
        }
        IAIONotificationUIModel.b bVar = this.notification;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel");
        return bVar;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, topTipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (eventType != 1004) {
            if (eventType == 1005) {
                this.mManager = topTipsManager;
                Intrinsics.checkNotNull(topTipsManager);
                this.mAIOContext = topTipsManager.a();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationShareTipsBar.E(LocationShareTipsBar.this);
                    }
                }, 16, null, true);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIONotificationBusiId.SHARE_LOCATION);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 15, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.barPriority;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        g((com.tencent.qqnt.aio.toptips.c) notificationManager, eventType, params);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else if (System.currentTimeMillis() - this.sLastLaunchTime >= 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationShareTipsBar", 2, "onClick: invoked. ", "v: ", v3);
            }
            this.sLastLaunchTime = System.currentTimeMillis();
            z();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i("LocationShareTipsBar", 2, "doOnDestroy");
        A();
        this.memberCnt = 0;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        ILocationShareService b16 = com.tencent.mobileqq.location.e.b(qQAppInterface);
        IFloatMapService a16 = com.tencent.mobileqq.location.e.a(qQAppInterface);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        SessionInfo a17 = su3.b.a(g16);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        AIOParam g17 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAIOContext.aioParam");
        Integer p16 = IceBreakingUtil.p(Integer.valueOf(com.tencent.guild.aio.util.a.e(g17)));
        Intrinsics.checkNotNullExpressionValue(p16, "getOldUinType(mAIOContext.aioParam.getChatType())");
        p16.intValue();
        Intrinsics.checkNotNullExpressionValue(a17.f179557e, "sessionInfo.curFriendUin");
        b16.removeLocationUpdateListener(this.mUpdateListener);
        a16.removeFloatMapCallback(this.mFloatMapCallback);
        com.tencent.mobileqq.location.a.f(this.mLocationListener);
        qQAppInterface.removeObserver(this.troopObserver);
    }
}
