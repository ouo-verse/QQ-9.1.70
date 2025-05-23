package com.tencent.robot.aio.helper;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.AioConfig;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.bk;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.aio.share.event.CloseSpecifiedRobotSplashAIOEvent;
import com.tencent.robot.aio.story.event.CloseSplashAIOEvent;
import com.tencent.robot.api.IRobotPersonalInfoService;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\b*\u0004HLUX\b\u0007\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020'H\u0016J\b\u00101\u001a\u000200H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020-H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030:09H\u0016R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010G\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010MR&\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020H0P0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010QR&\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020L0P0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotProfileHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "", "t", "Lcom/tencent/mvi/base/route/k;", "r", "Lcom/tencent/mobileqq/aio/event/e$c;", "o", "w", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "y", "v", "u", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "robotFeature", HippyTKDListViewAdapter.X, "", QQWinkConstants.STORY_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "storyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotAIOEvent;", "event", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "robotUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Z", "mSupportWideScreen", "f", "mSupportNewInteraction", tl.h.F, "J", "mRobotListenerId", "com/tencent/robot/aio/helper/RobotProfileHelper$d", "i", "Lcom/tencent/robot/aio/helper/RobotProfileHelper$d;", "mAction", "com/tencent/robot/aio/helper/RobotProfileHelper$e", "Lcom/tencent/robot/aio/helper/RobotProfileHelper$e;", "mActionR", "", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "D", "mMessageListR", "com/tencent/robot/aio/helper/RobotProfileHelper$f", "Lcom/tencent/robot/aio/helper/RobotProfileHelper$f;", "mRobotListener", "com/tencent/robot/aio/helper/RobotProfileHelper$g", "Lcom/tencent/robot/aio/helper/RobotProfileHelper$g;", "robotListener", "<init>", "()V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotProfileHelper implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, d>> mMessageList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, e>> mMessageListR;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final f mRobotListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g robotListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mSupportWideScreen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mSupportNewInteraction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mRobotListenerId = Long.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mActionR;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$b", "Lcom/tencent/mvi/base/route/k;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.k {
        b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$c", "Lcom/tencent/mvi/base/route/k;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.k {
        c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            RobotProfileHelper.this.s(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$e", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.mvi.base.route.b {
        e() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            return RobotProfileHelper.this.r(msgIntent);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$f", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotAIOEvent;", "event", "", "onRobotAIOEventChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements IKernelRobotListener {
        f() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public void onRobotAIOEventChanged(@Nullable RobotAIOEvent event) {
            bk.a(this, event);
            com.tencent.aio.api.runtime.a aVar = RobotProfileHelper.this.mAIOContext;
            String str = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            String j3 = aVar.g().r().c().j();
            com.tencent.aio.api.runtime.a aVar2 = RobotProfileHelper.this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            long j16 = aVar2.g().l().getLong("key_robot_story_id", 0L);
            if (event != null) {
                str = event.uid;
            }
            if (!Intrinsics.areEqual(j3, str)) {
                QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged peerUid=" + j3 + ", storyId=" + j16 + ", event = " + event);
                return;
            }
            StoryBaseInfo q16 = StoryUtils.f366640a.q(j3);
            QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged peerUid=" + j3 + ", storyId=" + j16 + ", event = " + event + ", " + q16);
            RobotProfileHelper.this.A(j16, q16, event);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotCoreInfoChanged(RobotCoreInfo robotCoreInfo) {
            bk.b(this, robotCoreInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile) {
            bk.c(this, groupRobotProfile);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotFriendListChanged() {
            bk.d(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotListChanged() {
            bk.e(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotProfileChanged(GroupRobotProfile groupRobotProfile) {
            bk.f(this, groupRobotProfile);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotTabListChanged(String str) {
            bk.g(this, str);
        }

        @NotNull
        public String toString() {
            return String.valueOf(hashCode());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotProfileHelper$g", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "info", "", "onRobotCoreInfoChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g implements IKernelRobotListener {
        g() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotAIOEventChanged(RobotAIOEvent robotAIOEvent) {
            bk.a(this, robotAIOEvent);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public void onRobotCoreInfoChanged(@Nullable RobotCoreInfo info) {
            bk.b(this, info);
            QLog.i("RobotProfileHelper", 1, "onRobotCoreInfoChanged");
            if (info != null) {
                RobotProfileHelper.this.y(info);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile) {
            bk.c(this, groupRobotProfile);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotFriendListChanged() {
            bk.d(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotListChanged() {
            bk.e(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotProfileChanged(GroupRobotProfile groupRobotProfile) {
            bk.f(this, groupRobotProfile);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotTabListChanged(String str) {
            bk.g(this, str);
        }
    }

    public RobotProfileHelper() {
        List<Pair<String, d>> listOf;
        List<Pair<String, e>> listOf2;
        d dVar = new d();
        this.mAction = dVar;
        e eVar = new e();
        this.mActionR = eVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.OnDeleteMsgRecordEvent.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.ClickTtsMenuItem.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.IsTtsPlaying.class)), dVar)});
        this.mMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.GetSupportWideScreen.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.EnableSelectMsg.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.NeedHideTopTtsBtn.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotMsgIntent.GetSupportNewInteraction.class)), eVar)});
        this.mMessageListR = listOf2;
        this.mRobotListener = new f();
        this.robotListener = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(long storyId, StoryBaseInfo storyInfo, RobotAIOEvent event) {
        int i3 = event.changeId;
        com.tencent.aio.api.runtime.a aVar = null;
        if (i3 == 2) {
            if (storyId == 0) {
                QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged, not currently in a story, exit the story");
                return;
            }
            if (storyInfo == null) {
                QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged, local exit the story");
                return;
            }
            QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged, remote exit the story, " + storyInfo.name);
            StoryUtils storyUtils = StoryUtils.f366640a;
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            storyUtils.l(aVar);
            return;
        }
        if (i3 == 1 && storyInfo != null) {
            if (storyId == storyInfo.storyId) {
                QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged, enter the story, already in the target story");
                return;
            }
            QLog.i("RobotProfileHelper", 1, "onRobotAIOEventChanged remote enter the story already");
            StoryUtils storyUtils2 = StoryUtils.f366640a;
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar3;
            }
            storyUtils2.w(storyInfo, aVar, false);
        }
    }

    private final void B() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        LifecycleOwner d16 = aVar.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "RobotProfileHelperupdateRobotPersonalInfo", Boolean.TRUE, null, null, new RobotProfileHelper$updateRobotPersonalInfo$1(this, null), 12, null);
    }

    private final void C() {
        QLog.i("RobotProfileHelper", 1, "updateRobotProfileFromLocal");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(q(), "", new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.aio.helper.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotProfileHelper.D(RobotProfileHelper.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(RobotProfileHelper this$0, int i3, String str, GroupRobotProfile robotProfile) {
        Long l3;
        RobotBaseInfo robotBaseInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (robotProfile != null && (robotBaseInfo = robotProfile.robotData) != null) {
            l3 = Long.valueOf(robotBaseInfo.robotUin);
        } else {
            l3 = null;
        }
        QLog.i("RobotProfileHelper", 1, "updateRobotProfileFromLocal result=" + i3 + " uin=" + l3);
        Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
        this$0.z(robotProfile);
    }

    private final void E() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        if (l3.containsKey("key_support_wide_sceen")) {
            this.mSupportWideScreen = l3.getBoolean("key_support_wide_sceen");
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        AIOParam g16 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        RobotCoreInfo robotCoreInfoFromFriendsCache = ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).getRobotCoreInfoFromFriendsCache(su3.c.b(g16));
        if (robotCoreInfoFromFriendsCache != null) {
            z16 = u64.b.c(robotCoreInfoFromFriendsCache);
        } else {
            z16 = false;
        }
        this.mSupportWideScreen = z16;
    }

    private final void F(GroupRobotProfile robotProfile) {
        boolean z16;
        if (robotProfile != null) {
            z16 = u64.d.c(robotProfile);
        } else {
            z16 = false;
        }
        this.mSupportNewInteraction = z16;
        QLog.i("RobotProfileHelper", 1, "updateUseNewInteraction: " + z16);
    }

    private final void m(long robotUin) {
        if (Intrinsics.areEqual(String.valueOf(robotUin), q())) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_force_close_aio", true);
            Unit unit = Unit.INSTANCE;
            e16.h(new ExternalCommIntent("close_aio", bundle));
        }
    }

    private final void n() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (aVar.g().l().getBoolean("key_from_splash_activity")) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_force_close_aio", true);
            Unit unit = Unit.INSTANCE;
            e16.h(new ExternalCommIntent("close_aio", bundle));
        }
    }

    private final e.c o() {
        return new e.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        return aVar.g().r().c().j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        return su3.c.b(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k r(MsgIntent msgIntent) {
        if (msgIntent instanceof RobotMsgIntent.GetSupportWideScreen) {
            return new e.g(this.mSupportWideScreen);
        }
        if (msgIntent instanceof RobotMsgIntent.EnableSelectMsg) {
            if (((RobotMsgIntent.EnableSelectMsg) msgIntent).a() instanceof AIOMsgItem) {
                return new e.a(true);
            }
            return new b();
        }
        if (msgIntent instanceof RobotMsgIntent.NeedHideTopTtsBtn) {
            return o();
        }
        if (msgIntent instanceof RobotMsgIntent.GetSupportNewInteraction) {
            return new e.f(this.mSupportNewInteraction);
        }
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgSendEvent.OnDeleteMsgRecordEvent) {
            w();
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.ClickTtsMenuItem) {
            RobotMsgIntent.ClickTtsMenuItem clickTtsMenuItem = (RobotMsgIntent.ClickTtsMenuItem) msgIntent;
            com.tencent.aio.api.runtime.a aVar = null;
            if (t(clickTtsMenuItem.a())) {
                com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar = aVar2;
                }
                aVar.e().h(new TtsMsgIntent.ActiveTriggerStopTtsMsgIntent(clickTtsMenuItem.a()));
                return;
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(new TtsMsgIntent.ActiveTriggerPlayTtsMsgIntent(clickTtsMenuItem.a()));
            return;
        }
        if (msgIntent instanceof RobotMsgIntent.IsTtsPlaying) {
            RobotMsgIntent.IsTtsPlaying isTtsPlaying = (RobotMsgIntent.IsTtsPlaying) msgIntent;
            isTtsPlaying.b(t(isTtsPlaying.a()));
        }
    }

    private final boolean t(AIOMsgItem aioMsgItem) {
        return com.tencent.qqnt.audio.tts.ui.e.INSTANCE.b().m(aioMsgItem.getMsgId());
    }

    private final void u(RobotCoreInfo robotCoreInfo) {
        if (Intrinsics.areEqual(String.valueOf(robotCoreInfo.robotUin), q())) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new RobotProfileMsgIntent.OnRobotCoreInfoUpdated(robotCoreInfo));
        }
    }

    private final void v(GroupRobotProfile robotProfile) {
        if (Intrinsics.areEqual(String.valueOf(robotProfile.robotData.robotUin), q())) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new RobotProfileMsgIntent.OnRobotProfileUpdate(robotProfile));
        }
    }

    private final void w() {
        AdelieUtils adelieUtils = AdelieUtils.f365929a;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (adelieUtils.T(aVar)) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            String j3 = aVar2.g().r().c().j();
            IRobotPersonalInfoService r16 = StoryUtils.f366640a.r();
            if (r16 != null) {
                r16.putMsgRecordStatus(j3, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(RobotFeature robotFeature) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (!aVar.g().l().getBoolean("key_robot_story_aio_initiative")) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            long j3 = aVar3.g().l().getLong("key_robot_story_id", 0L);
            StoryBaseInfo storyBaseInfo = robotFeature.storyInfo;
            if (j3 != storyBaseInfo.storyId) {
                QLog.e("RobotProfileHelper", 1, "updateRobotPersonalInfo, current story status is inconsistent with the remote. synchronize to the remote, storyId=" + j3 + ", " + storyBaseInfo);
                StoryBaseInfo storyBaseInfo2 = robotFeature.storyInfo;
                if (storyBaseInfo2.storyId == 0) {
                    StoryUtils storyUtils = StoryUtils.f366640a;
                    com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar2 = aVar4;
                    }
                    storyUtils.l(aVar2);
                    return;
                }
                StoryUtils storyUtils2 = StoryUtils.f366640a;
                com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar2 = aVar5;
                }
                storyUtils2.w(storyBaseInfo2, aVar2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(RobotCoreInfo robotCoreInfo) {
        AioConfig aioConfig = robotCoreInfo.aioConfig;
        boolean z16 = false;
        if (aioConfig != null && aioConfig.supportNewInteraction == 1) {
            z16 = true;
        }
        this.mSupportNewInteraction = z16;
        u(robotCoreInfo);
    }

    private final void z(GroupRobotProfile robotProfile) {
        F(robotProfile);
        v(robotProfile);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CloseSplashAIOEvent.class, CloseSpecifiedRobotSplashAIOEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.B1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotProfileHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        long j3;
        IRobotPersonalInfoService iRobotPersonalInfoService;
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mAIOContext = param.a();
        C();
        B();
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (aVar.g().l().getBoolean("key_robot_story_aio_initiative")) {
            StoryUtils.f366640a.D(p(), false);
        }
        E();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            aVar3.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.mMessageListR.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar4 = null;
            }
            aVar4.e().j((String) pair2.getFirst(), (com.tencent.mvi.base.route.b) pair2.getSecond());
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iRobotPersonalInfoService = (IRobotPersonalInfoService) peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "")) != null) {
            com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar5;
            }
            iRobotPersonalInfoService.addRobotListener(aVar2.g().r().c().j(), this.mRobotListener);
        }
        ac a16 = u64.h.a();
        if (a16 != null) {
            j3 = a16.addKernelRobotListener(this.robotListener);
        } else {
            j3 = Long.MIN_VALUE;
        }
        this.mRobotListenerId = j3;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IRobotPersonalInfoService iRobotPersonalInfoService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iRobotPersonalInfoService = (IRobotPersonalInfoService) peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "")) != null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            iRobotPersonalInfoService.removeRobotListener(aVar.g().r().c().j(), this.mRobotListener);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            aVar2.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.mMessageListR.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            aVar3.e().a((String) pair2.getFirst());
        }
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.removeKernelRobotListener(this.mRobotListenerId);
        }
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            StoryUtils storyUtils = StoryUtils.f366640a;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            storyUtils.t(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof CloseSplashAIOEvent) {
            n();
        } else if (event instanceof CloseSpecifiedRobotSplashAIOEvent) {
            m(((CloseSpecifiedRobotSplashAIOEvent) event).getRobotUin());
        }
    }
}
