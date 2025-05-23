package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.InviteFriendSimpleEvent;
import com.tencent.mobileqq.matchfriend.QQStrangerJumpJuBaoEvent;
import com.tencent.mobileqq.matchfriend.QQStrangerJumpProfilePageEvent;
import com.tencent.mobileqq.matchfriend.QQStrangerSimpleEvent;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\b\u0081\u0001\u0084\u0001\u0087\u0001\u008b\u0001\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\u0090\u0001B\t\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0003J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0018\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\bH\u0002J\b\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\bH\u0002J\b\u00104\u001a\u00020\u0006H\u0002J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0006H\u0002J\u001b\u0010:\u001a\u0002092\n\u00108\u001a\u0006\u0012\u0002\b\u000307H\u0002\u00a2\u0006\u0004\b:\u0010;J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u00020$H\u0016J\b\u0010?\u001a\u00020>H\u0016J\u000e\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020@J\u0010\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u00020CH\u0016J\u0010\u0010G\u001a\u00020\b2\u0006\u0010F\u001a\u000209H\u0016J\u0018\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$J\b\u0010J\u001a\u00020\u0006H\u0016J\u0012\u0010L\u001a\u00020\b2\b\u0010K\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040N0MH\u0016R\u0014\u0010R\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bT\u0010\u001aR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010cR\u0016\u0010f\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010kR\u0016\u0010m\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0016\u0010n\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0011R\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0016\u0010q\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001aR\u0018\u0010t\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010sR\u0016\u0010u\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010QR\u0018\u0010x\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010wR2\u0010|\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020.0yj\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020.`z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010{R\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u0082\u0001R\u0017\u0010\u0086\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0016\u0010\u008c\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/helper/MatchFriendGeneralHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/g;", "", "j0", "", "a0", "o0", "i0", "e0", "h0", "g0", "f0", "V", "Z", "Y", "onResume", BdhLogUtil.LogTag.Tag_Conn, DKHippyEvent.EVENT_STOP, "U", "n0", "G", "E", "J", HippyTKDListViewAdapter.X, "H", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "needDelay", "N", "Lcom/tencent/common/app/AppInterface;", "app", "", "openId", "b0", "I", "L", "u", "B", "y", "D", "M", "", "data", "w", "K", "X", "W", "P", "isSuccess", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "result", "", "v", "([Ljava/lang/Object;)I", "getId", "getTag", "", "interestedIn", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "isFromInvite", "d0", "onBackEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Ljava/lang/String;", "observerKey", "", "e", "closeAioDelayTime", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mAppInterface", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "mSelfInfo", "mFriendInfo", "mFriendTinyId", "Landroid/app/Activity;", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/matchfriend/voicechat/RoomInfo;", "Lcom/tencent/mobileqq/matchfriend/voicechat/RoomInfo;", "mVoiceChatRoomInfo", "mCurrentMatchSource", "mFirstMatchSource", "mIsFromNotification", "mNeedReportGreet", "mTopicId", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "mMatchFriendReportHelper", "mTraceId", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "kuiklyEventReceiver", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "params", "Lcom/tencent/relation/common/servlet/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/relation/common/servlet/b;", "mRelationObserver", "com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$d", "Lcom/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$d;", "mMsgListener", "com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$e", "Lcom/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$e;", "userInfoChangeListener", "com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$b", "T", "Lcom/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$b;", "action", "com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$c", "Lcom/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$c;", "mIAppNotifyCallback", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MatchFriendGeneralHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.runtime.emitter.a, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mvi.base.route.g {

    /* renamed from: C, reason: from kotlin metadata */
    private QQStrangerUserInfo mFriendInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private long mFriendTinyId;

    /* renamed from: E, reason: from kotlin metadata */
    private Activity mActivity;

    /* renamed from: F, reason: from kotlin metadata */
    private RoomInfo mVoiceChatRoomInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCurrentMatchSource;

    /* renamed from: H, reason: from kotlin metadata */
    private int mFirstMatchSource;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsFromNotification;

    /* renamed from: K, reason: from kotlin metadata */
    private long mTopicId;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.utils.d mMatchFriendReportHelper;

    /* renamed from: N, reason: from kotlin metadata */
    private BroadcastReceiver kuiklyEventReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mAppInterface;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QQStrangerUserInfo mSelfInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String observerKey = "MatchFriendGeneralHelper" + hashCode();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long closeAioDelayTime = 500;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mNeedReportGreet = true;

    /* renamed from: M, reason: from kotlin metadata */
    private String mTraceId = "";

    /* renamed from: P, reason: from kotlin metadata */
    private HashMap<String, Object> params = new HashMap<>();

    /* renamed from: Q, reason: from kotlin metadata */
    private final com.tencent.relation.common.servlet.b mRelationObserver = new com.tencent.relation.common.servlet.b() { // from class: com.tencent.qqnt.aio.helper.bm
        @Override // com.tencent.mobileqq.app.BusinessObserver
        public final void onUpdate(int i3, boolean z16, Object obj) {
            MatchFriendGeneralHelper.Q(MatchFriendGeneralHelper.this, i3, z16, obj);
        }
    };

    /* renamed from: R, reason: from kotlin metadata */
    private d mMsgListener = new d();

    /* renamed from: S, reason: from kotlin metadata */
    private final e userInfoChangeListener = new e();

    /* renamed from: T, reason: from kotlin metadata */
    private final b action = new b();

    /* renamed from: U, reason: from kotlin metadata */
    private final c mIAppNotifyCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            MatchFriendGeneralHelper.this.z(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$c", "Lcom/tencent/mobileqq/ark/module/g;", "", "appName", AdMetricTag.EVENT_NAME, "params", "", "notify", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.ark.module.g {
        c() {
        }

        @Override // com.tencent.mobileqq.ark.module.g
        public boolean notify(String appName, String eventName, String params) {
            com.tencent.mobileqq.matchfriend.utils.d dVar;
            QLog.i("MatchFriendGeneralHelper", 1, "notify, appName = " + appName + ", eventName : " + eventName + ", params : " + params);
            if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(eventName)) {
                if (Intrinsics.areEqual("com.tencent.mobileqq.qqstranger.icebreaktopic", appName)) {
                    if (Intrinsics.areEqual("SendTopicMessage", eventName)) {
                        IMatchFriendNTChatApi iMatchFriendNTChatApi = (IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class);
                        String valueOf = String.valueOf(MatchFriendGeneralHelper.this.mFriendTinyId);
                        IMatchFriendNTChatApi iMatchFriendNTChatApi2 = (IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class);
                        QQAppInterface qQAppInterface = MatchFriendGeneralHelper.this.mAppInterface;
                        Intrinsics.checkNotNull(qQAppInterface, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                        iMatchFriendNTChatApi.handleSendIcebreakerTopicMessage(params, valueOf, iMatchFriendNTChatApi2.getIceBreakTopicMsgId(qQAppInterface, MatchFriendGeneralHelper.this.mFriendTinyId));
                    }
                } else if (Intrinsics.areEqual("com.tencent.mobileqq.qqstranger.minicard", appName) && Intrinsics.areEqual("openProfileCard", eventName) && (dVar = MatchFriendGeneralHelper.this.mMatchFriendReportHelper) != null) {
                    dVar.d("em_kl_new_chat_page_mini_card");
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$e", "Lcom/tencent/mobileqq/matchfriend/api/d;", "", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "infoList", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.matchfriend.api.d {
        e() {
        }

        @Override // com.tencent.mobileqq.matchfriend.api.d
        public void a(List<QQStrangerUserInfo> infoList) {
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            Object orNull;
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            com.tencent.aio.api.runtime.a aVar = MatchFriendGeneralHelper.this.mAIOContext;
            if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) {
                return;
            }
            MatchFriendGeneralHelper matchFriendGeneralHelper = MatchFriendGeneralHelper.this;
            ArrayList arrayList = new ArrayList();
            for (Object obj : infoList) {
                if (Intrinsics.areEqual(String.valueOf(((QQStrangerUserInfo) obj).tinyId), c16.j())) {
                    arrayList.add(obj);
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            QQStrangerUserInfo qQStrangerUserInfo = (QQStrangerUserInfo) orNull;
            if (qQStrangerUserInfo != null) {
                matchFriendGeneralHelper.mFriendInfo = qQStrangerUserInfo;
                matchFriendGeneralHelper.x();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A(boolean isSuccess) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Long longOrNull;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (r0 = c16.j()) == null || longOrNull == null) {
            return;
        }
        long longValue = longOrNull.longValue();
        QLog.d("MatchFriendGeneralHelper", 1, "handleOnMsgSendEvent tinyId:" + longValue + " isSuccess:" + isSuccess);
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSimpleEvent.QQStrangerOnMsgSentEvent(longValue, isSuccess));
    }

    private final void B() {
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr;
        QQAppInterface qQAppInterface = this.mAppInterface;
        if (qQAppInterface == null || (iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) qQAppInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "")) == null) {
            return;
        }
        IQQStrangerUserInfoMgr.a.b(iQQStrangerUserInfoMgr, new com.tencent.mobileqq.matchfriend.bean.c(104, this.mFriendTinyId, null, 4, null), null, 2, null);
    }

    private final void C() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.qqstranger.minicard", this.mIAppNotifyCallback);
    }

    private final void D() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.qqstranger.icebreaktopic", this.mIAppNotifyCallback);
    }

    private final void E() {
        H();
    }

    private final void F() {
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        this.mIsFromNotification = intent.getBooleanExtra("key_match_friend_is_from_notification", false);
        this.mTopicId = intent.getLongExtra("key_match_friend_topic_id", 0L);
    }

    private final void G() {
        l91.a.a();
    }

    private final void H() {
        String str;
        if (TextUtils.isEmpty(String.valueOf(this.mFriendTinyId)) || P()) {
            return;
        }
        boolean S = S();
        boolean R = R();
        if (!S) {
            if (R) {
                QLog.d("MatchFriendGeneralHelper", 1, "getIceBreakingTopic tinyId:" + this.mFriendTinyId);
                ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getIceBreakingTopic(this.mAppInterface, this.mFriendTinyId, this.observerKey);
                return;
            }
            return;
        }
        QLog.d("MatchFriendGeneralHelper", 1, "getArkMiniProfileCardInfo tinyId:" + this.mFriendTinyId);
        IMatchFriendRequest iMatchFriendRequest = (IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class);
        QQAppInterface qQAppInterface = this.mAppInterface;
        QQStrangerUserInfo qQStrangerUserInfo = this.mSelfInfo;
        if (qQStrangerUserInfo == null || (str = Long.valueOf(qQStrangerUserInfo.tinyId).toString()) == null) {
            str = "";
        }
        iMatchFriendRequest.getArkMiniProfileCardInfo(qQAppInterface, str, String.valueOf(this.mFriendTinyId), this.mFirstMatchSource, R, this.observerKey);
    }

    private final void I() {
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.mVoiceChatRoomInfo = (RoomInfo) intent.getParcelableExtra("key_voice_chat_room_info");
            this.mCurrentMatchSource = intent.getIntExtra("key_match_friend_source", 0);
            Bundle extras = intent.getExtras();
            String string = extras != null ? extras.getString("recom_trace", "") : null;
            this.mTraceId = string != null ? string : "";
            QLog.d("MatchFriendGeneralHelper", 1, "[initIntentData] mCurrentMatchSource=" + this.mCurrentMatchSource);
            QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
            if (qQStrangerUserInfo != null) {
                Intrinsics.checkNotNull(qQStrangerUserInfo);
                if (com.tencent.mobileqq.matchfriend.utils.e.b(qQStrangerUserInfo.matchSource)) {
                    QQStrangerUserInfo qQStrangerUserInfo2 = this.mFriendInfo;
                    Intrinsics.checkNotNull(qQStrangerUserInfo2);
                    intent.putExtra("key_match_friend_source", qQStrangerUserInfo2.matchSource);
                    QQStrangerUserInfo qQStrangerUserInfo3 = this.mFriendInfo;
                    Intrinsics.checkNotNull(qQStrangerUserInfo3);
                    this.mFirstMatchSource = qQStrangerUserInfo3.matchSource;
                    QLog.d("MatchFriendGeneralHelper", 1, "[initIntentData] mFirstMatchSource=" + this.mFirstMatchSource);
                }
            }
            this.mFirstMatchSource = this.mCurrentMatchSource;
            QLog.d("MatchFriendGeneralHelper", 1, "[initIntentData] mFirstMatchSource=" + this.mFirstMatchSource);
        }
    }

    private final void J() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) {
            return;
        }
        QQAppInterface qQAppInterface = this.mAppInterface;
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = qQAppInterface != null ? (IQQStrangerUserInfoMgr) qQAppInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "") : null;
        this.mSelfInfo = iQQStrangerUserInfoMgr != null ? iQQStrangerUserInfoMgr.getSelfUserInfo() : null;
        this.mFriendInfo = iQQStrangerUserInfoMgr != null ? iQQStrangerUserInfoMgr.getUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(c16.e(), Long.parseLong(c16.j()), null, 4, null)) : null;
        if (iQQStrangerUserInfoMgr != null) {
            IQQStrangerUserInfoMgr.a.b(iQQStrangerUserInfoMgr, new com.tencent.mobileqq.matchfriend.bean.c(c16.e(), Long.parseLong(c16.j()), null, 4, null), null, 2, null);
        }
    }

    private final void K() {
        this.mMatchFriendReportHelper = new com.tencent.mobileqq.matchfriend.utils.d(this.mActivity);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        hashMap.put("kl_new_to_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getFriendOpenId());
        if (this.mTraceId.length() > 0) {
            hashMap.put("recom_trace", this.mTraceId);
        }
        this.params = hashMap;
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.mMatchFriendReportHelper;
        if (dVar != null) {
            dVar.c("pg_kl_new_chat_page", hashMap);
            dVar.i(this.params);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_kl_new_chat_page_mini_card");
        arrayList.add("em_bas_add_friends");
        com.tencent.mobileqq.matchfriend.utils.d dVar2 = this.mMatchFriendReportHelper;
        if (dVar2 != null) {
            dVar2.b(arrayList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (com.tencent.mobileqq.matchfriend.utils.e.b(r1.matchSource) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L() {
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).aioReport(this.mAppInterface, this.mFriendTinyId, 1, this.mCurrentMatchSource, this.mTopicId, this.observerKey);
        QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
        if (qQStrangerUserInfo != null) {
            Intrinsics.checkNotNull(qQStrangerUserInfo);
        }
        if (com.tencent.mobileqq.matchfriend.utils.e.b(this.mFirstMatchSource)) {
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).setFirstRelationOrigin(this.mAppInterface, this.mFriendTinyId, this.mFirstMatchSource, this.observerKey);
        }
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getCanGreet(this.mAppInterface, this.mFriendTinyId, this.observerKey);
    }

    private final void M() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        this.mFriendTinyId = (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) ? 0L : Long.parseLong(j3);
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getAioHint(this.mAppInterface, this.mFriendTinyId, this.observerKey);
    }

    private final void N(boolean needDelay) {
        Activity activity = this.mActivity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                QLog.d("MatchFriendGeneralHelper", 1, "[initToSendInviteMsg] method invoked");
                final boolean booleanExtra = intent.getBooleanExtra("key_from_invite", false);
                final String stringExtra = intent.getStringExtra("key_friend_open_id_from_invite");
                if (needDelay) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bk
                        @Override // java.lang.Runnable
                        public final void run() {
                            MatchFriendGeneralHelper.O(MatchFriendGeneralHelper.this, booleanExtra, stringExtra);
                        }
                    }, 1000L);
                    return;
                } else {
                    d0(booleanExtra, stringExtra);
                    return;
                }
            }
            QLog.d("MatchFriendGeneralHelper", 1, "[initToSendMsgByInvite] exception: intent is null");
            return;
        }
        QLog.d("MatchFriendGeneralHelper", 1, "[initToSendMsgByInvite] exception: mActivity is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(MatchFriendGeneralHelper this$0, boolean z16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0(z16, str);
    }

    private final boolean P() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null) {
            return ((IStrangerAssistantAdapterApi) QRoute.api(IStrangerAssistantAdapterApi.class)).isLittleAssistant(aVar.g().r().c());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MatchFriendGeneralHelper this$0, int i3, boolean z16, Object data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 2) {
            if (z16) {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Array<*>");
                Object[] objArr = (Object[]) data;
                Object obj = objArr[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                boolean booleanValue = ((Boolean) obj).booleanValue();
                Object obj2 = objArr[1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                int v3 = this$0.v(objArr);
                ((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).handleGetCanGreet(booleanValue, (String) obj2, v3, this$0.mActivity);
                return;
            }
            ((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).handleGetCanGreet(false, "", 0, this$0.mActivity);
            return;
        }
        if (i3 == 3) {
            if (z16) {
                this$0.y();
                return;
            }
            return;
        }
        if (i3 == 6) {
            com.tencent.mobileqq.matchfriend.utils.d dVar = this$0.mMatchFriendReportHelper;
            if (dVar != null) {
                dVar.f("em_kl_new_chat_page_mini_card");
                return;
            }
            return;
        }
        if (i3 == 15) {
            if (z16) {
                this$0.B();
            }
        } else if (i3 == 16 && z16) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            this$0.w(data);
        }
    }

    private final boolean R() {
        return false;
    }

    private final boolean S() {
        return !((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).getHaseMatchFriendMiniCardArk(this.mFriendTinyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MatchFriendGeneralHelper this$0) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new ExternalCommIntent("close_aio", new Bundle()));
    }

    private final void U() {
        com.tencent.mvi.base.route.j e16;
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        ((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).onDestroy();
        QQAppInterface qQAppInterface = this.mAppInterface;
        Object businessHandler = qQAppInterface != null ? qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).F(this.observerKey);
        n0();
        ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).setFlagFirstEnterSession(String.valueOf(this.mFriendTinyId), false);
        QQAppInterface qQAppInterface2 = this.mAppInterface;
        if (qQAppInterface2 != null && (iKernelService = (IKernelService) qQAppInterface2.getRuntimeService(IKernelService.class, "all")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.removeMsgListener(this.mMsgListener);
        }
        QQAppInterface qQAppInterface3 = this.mAppInterface;
        if (qQAppInterface3 != null && (iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) qQAppInterface3.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")) != null) {
            iQQStrangerUserInfoMgr.removeUserInfoListener(this.userInfoChangeListener);
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.action);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        o0();
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.mMatchFriendReportHelper;
        if (dVar != null) {
            dVar.j(this.params);
        }
    }

    private final void V() {
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.mMatchFriendReportHelper;
        if (dVar != null) {
            dVar.d("em_bas_add_friends");
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        Context context = this.mContext;
        QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
        iMatchFriendEntryApi.launchAddFriend(context, qQStrangerUserInfo != null ? qQStrangerUserInfo.tinyId : 0L);
    }

    private final void W() {
        QQAppInterface qQAppInterface = this.mAppInterface;
        if (qQAppInterface != null && this.mActivity != null && this.mFriendInfo != null) {
            IMatchFriendJubaoApi iMatchFriendJubaoApi = (IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class);
            QQAppInterface qQAppInterface2 = this.mAppInterface;
            Activity activity = this.mActivity;
            QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
            String l3 = qQStrangerUserInfo != null ? Long.valueOf(qQStrangerUserInfo.tinyId).toString() : null;
            QQStrangerUserInfo qQStrangerUserInfo2 = this.mFriendInfo;
            iMatchFriendJubaoApi.jumpMatchFriendJuBao(qQAppInterface2, activity, "10133", l3, qQStrangerUserInfo2 != null ? qQStrangerUserInfo2.nick : null);
            return;
        }
        QLog.e("MatchFriendGeneralHelper", 1, "[onQQStrangerJumpJuBaoEvent]mAppInterface=" + qQAppInterface + ", mActivity=" + this.mActivity + ", mFriendInfo=" + this.mFriendInfo);
    }

    private final void X() {
        QQAppInterface qQAppInterface = this.mAppInterface;
        if (qQAppInterface != null) {
            Activity activity = this.mActivity;
            Unit unit = null;
            if (activity != null) {
                QQStrangerUserInfo qQStrangerUserInfo = this.mSelfInfo;
                if (qQStrangerUserInfo != null) {
                    ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(qQAppInterface, activity, qQStrangerUserInfo.tinyId, 0, 10);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    QLog.i("MatchFriendGeneralHelper", 1, "[QQStrangerJumpProfilePageEvent] mSelfData|tinyId is null");
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i("MatchFriendGeneralHelper", 1, "[QQStrangerJumpProfilePageEvent] mActivity is null");
                return;
            }
            return;
        }
        QLog.i("MatchFriendGeneralHelper", 1, "[QQStrangerJumpProfilePageEvent] mAppInterface is null ");
    }

    private final void Y() {
        G();
        C();
        J();
        I();
        u();
        L();
        E();
    }

    private final void Z() {
        AIOParam g16;
        Bundle l3;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null || l3.getString("uin", "").equals("256111111111111111")) {
            return;
        }
        Y();
        onResume();
    }

    private final void a0() {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.qqnt.aio.helper.MatchFriendGeneralHelper$registerKuiklyEventReceiver$1
            /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
            
                r1 = r0.f350342a.mActivity;
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceive(Context context, Intent intent) {
                Activity activity;
                if (!Intrinsics.areEqual(intent != null ? com.tencent.kuikly.core.render.android.expand.module.l.a(intent) : null, "JIEBAN_OPEN_MY_PROFILE_EVENT") || activity == null) {
                    return;
                }
                activity.onBackPressed();
            }
        };
        this.kuiklyEventReceiver = broadcastReceiver;
        Context context = this.mContext;
        if (context != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.c(context, broadcastReceiver);
        }
    }

    private final void b0(final AppInterface app, final String openId) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bp
            @Override // java.lang.Runnable
            public final void run() {
                MatchFriendGeneralHelper.c0(AppInterface.this, openId);
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AppInterface app, String openId) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(openId, "$openId");
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).sendInviteGrayTip(app, openId);
    }

    private final void e0() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
        String str = qQStrangerUserInfo != null ? qQStrangerUserInfo.nick : null;
        if ((str == null || str.length() == 0) || (aVar = this.mAIOContext) == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.TitleResponseEvent(4, str));
    }

    private final void f0() {
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.UpdateRight1IvEvent(false, false, null, 5, null));
    }

    private final void g0() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        Context context = this.mContext;
        if (context == null || (aVar = this.mAIOContext) == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.UpdateRight2IvEvent(false, true, context.getResources().getDrawable(R.drawable.qui_add_friend_icon_navigation_01_selector), 1, "1"));
    }

    private final void h0() {
        String str;
        com.tencent.mvi.base.route.j e16;
        QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
        if (qQStrangerUserInfo == null || (str = qQStrangerUserInfo.onlineStatus) == null) {
            return;
        }
        if (str.length() == 0) {
            QLog.i("MatchFriendGeneralHelper", 1, "sendSubTitleUpdateMessage is error! title is invalid!");
            return;
        }
        com.tencent.mobileqq.aio.title.ai aiVar = new com.tencent.mobileqq.aio.title.ai(null, null, null, str, "5");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(aiVar));
    }

    private final void i0() {
        AIOParam g16;
        Bundle l3;
        AIOParam g17;
        AIOSession r16;
        AIOContact c16;
        QLog.i("MatchFriendGeneralHelper", 1, "[setTitleInfo]");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String g18 = (aVar == null || (g17 = aVar.g()) == null || (r16 = g17.r()) == null || (c16 = r16.c()) == null) ? null : c16.g();
        if (g18 == null || g18.length() == 0) {
            QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
            String str = qQStrangerUserInfo != null ? qQStrangerUserInfo.nick : null;
            if (!(str == null || str.length() == 0)) {
                e0();
            }
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (g16 = aVar2.g()) == null || (l3 = g16.l()) == null || l3.getString("uin", "").equals("256111111111111111") || P()) {
            return;
        }
        QQStrangerUserInfo qQStrangerUserInfo2 = this.mFriendInfo;
        if (qQStrangerUserInfo2 != null && qQStrangerUserInfo2.userType == 2) {
            f0();
        } else {
            h0();
            g0();
        }
    }

    private final boolean j0() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bl
            @Override // java.lang.Runnable
            public final void run() {
                MatchFriendGeneralHelper.k0(MatchFriendGeneralHelper.this);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(MatchFriendGeneralHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Activity activity = this$0.mActivity;
        if (activity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, "\u62b1\u6b49\uff0c\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u6682\u4e0d\u652f\u6301\u8bbf\u95ee", "\u6211\u77e5\u9053\u4e86", (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.bn
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MatchFriendGeneralHelper.l0(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026s()\n                    }");
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.aio.helper.bo
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MatchFriendGeneralHelper.m0(activity, dialogInterface);
                }
            });
            createCustomDialog.setCanceledOnTouchOutside(false);
            createCustomDialog.setThemeId(QQTheme.isNowThemeIsNight() ? 1002 : 1001);
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Activity activity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.onBackPressed();
    }

    private final void n0() {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).unregisterAppNotification("com.tencent.mobileqq.qqstranger.icebreaktopic");
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).unregisterAppNotification("com.tencent.mobileqq.qqstranger.minicard");
    }

    private final void o0() {
        BroadcastReceiver broadcastReceiver = this.kuiklyEventReceiver;
        if (broadcastReceiver != null) {
            Context context = this.mContext;
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
            this.kuiklyEventReceiver = null;
        }
    }

    private final void onResume() {
        AIOParam g16;
        Bundle l3;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null) {
            return;
        }
        QQStrangerUserInfo qQStrangerUserInfo = this.mFriendInfo;
        l3.putString("uinname", qQStrangerUserInfo != null ? qQStrangerUserInfo.nick : null);
        QQStrangerUserInfo qQStrangerUserInfo2 = this.mSelfInfo;
        l3.putString("key_match_friend_self_open_id", qQStrangerUserInfo2 != null ? qQStrangerUserInfo2.openId : null);
        QQStrangerUserInfo qQStrangerUserInfo3 = this.mFriendInfo;
        l3.putString("key_match_friend_open_id", qQStrangerUserInfo3 != null ? qQStrangerUserInfo3.openId : null);
        QQStrangerUserInfo qQStrangerUserInfo4 = this.mFriendInfo;
        l3.putString("key_match_friend_avatar_url", qQStrangerUserInfo4 != null ? qQStrangerUserInfo4.avatar : null);
        l3.putString("recom_trace", this.mTraceId);
        l3.putInt("key_match_friend_source", this.mFirstMatchSource);
        IMatchFriendChatApi iMatchFriendChatApi = (IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class);
        QQStrangerUserInfo qQStrangerUserInfo5 = this.mFriendInfo;
        iMatchFriendChatApi.setFriendOpenId(qQStrangerUserInfo5 != null ? qQStrangerUserInfo5.openId : null);
        K();
    }

    private final void onStop() {
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendGeneralHelper", 1, DKHippyEvent.EVENT_STOP);
        }
        n0();
    }

    private final void u() {
        ((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).checkEnterVoiceChatPage(this.mActivity, this.mVoiceChatRoomInfo);
    }

    private final int v(Object[] result) {
        if (result.length < 2) {
            return 0;
        }
        Object obj = result[2];
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final void w(Object data) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
        e16.h(new InputEditTextMsgIntent.SetHintToEditText((String) data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        if (this.mFriendInfo != null) {
            onResume();
            i0();
        }
    }

    public final void d0(boolean isFromInvite, String openId) {
        AIOParam g16;
        AIOSession r16;
        SessionInfo b16;
        Activity activity = this.mActivity;
        Unit unit = null;
        if (activity != null) {
            QLog.d("MatchFriendGeneralHelper", 1, "[sendInviteMsg] isFromInvite:" + isFromInvite + ", openId:" + openId);
            if (isFromInvite) {
                com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
                if (aVar != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (b16 = su3.b.b(r16)) != null) {
                    QQAppInterface qQAppInterface = this.mAppInterface;
                    if (qQAppInterface != null) {
                        com.tencent.mobileqq.forward.utils.f.f211079a.i(b16, activity.getString(R.string.f225146ku));
                        if (openId != null) {
                            b0(qQAppInterface, openId);
                        }
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        QLog.d("MatchFriendGeneralHelper", 1, "[sendInviteMsg] exception: mAppInterface is null");
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    QLog.d("MatchFriendGeneralHelper", 1, "[sendInviteMsg] exception: mAIOContext | aioParam | getSession | getSessionInfo is null");
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.d("MatchFriendGeneralHelper", 1, "[sendInviteMsg] exception: mActivity is null");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(InviteFriendSimpleEvent.class);
        arrayList.add(QQStrangerJumpProfilePageEvent.class);
        arrayList.add(QQStrangerJumpJuBaoEvent.class);
        return arrayList;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.G;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.AIOLifeCycleEvent.OnNewIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.Right2IvClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendSuccessEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendFailEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "MatchFriendGeneralHelper";
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        ml3.b b16;
        ml3.a a16;
        if (!this.mIsFromNotification) {
            return false;
        }
        QLog.i("MatchFriendGeneralHelper", 1, "onBackEvent is executed!");
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMsgListPage(this.mActivity, this.mAppInterface, 0, 0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.helper.bj
            @Override // java.lang.Runnable
            public final void run() {
                MatchFriendGeneralHelper.T(MatchFriendGeneralHelper.this);
            }
        }, this.closeAioDelayTime);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (b16 = aVar.b()) != null && (a16 = b16.a(com.tencent.aio.api.runtime.emitter.a.class)) != null) {
            a16.c(this);
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        Fragment c17;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Context requireContext = (a16 == null || (c17 = a16.c()) == null) ? null : c17.requireContext();
        Intrinsics.checkNotNull(requireContext);
        this.mContext = requireContext;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        this.mActivity = (aVar == null || (c16 = aVar.c()) == null) ? null : c16.getActivity();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.mAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (j0()) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.f(this, this.action);
        }
        QQAppInterface qQAppInterface = this.mAppInterface;
        Object businessHandler = qQAppInterface != null ? qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).z(this.observerKey, this.mRelationObserver);
        QQAppInterface qQAppInterface2 = this.mAppInterface;
        if (qQAppInterface2 != null && (iKernelService = (IKernelService) qQAppInterface2.getRuntimeService(IKernelService.class, "all")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.addMsgListener(this.mMsgListener);
        }
        QQAppInterface qQAppInterface3 = this.mAppInterface;
        if (qQAppInterface3 != null && (iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) qQAppInterface3.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")) != null) {
            iQQStrangerUserInfoMgr.addUserInfoListener(this.userInfoChangeListener);
        }
        D();
        M();
        F();
        N(true);
        param.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        a0();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof InviteFriendSimpleEvent) {
            InviteFriendSimpleEvent inviteFriendSimpleEvent = (InviteFriendSimpleEvent) event;
            d0(inviteFriendSimpleEvent.isFromInvite(), inviteFriendSimpleEvent.getOpenId());
        } else if (event instanceof QQStrangerJumpProfilePageEvent) {
            X();
        } else if (event instanceof QQStrangerJumpJuBaoEvent) {
            W();
        }
    }

    public final void z(MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIOLifeCycleEvent.OnNewIntent) {
            N(false);
            return;
        }
        if (i3 instanceof AIOTitleEvent.Right2IvClickEvent) {
            V();
        } else if (i3 instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
            A(true);
        } else if (i3 instanceof AIOMsgSendEvent.OnMsgSendFailEvent) {
            A(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/helper/MatchFriendGeneralHelper$d", "Lcom/tencent/qqnt/msg/i;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errorCode", "", "errorMsg", "", "onSendMsgError", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends com.tencent.qqnt.msg.i {
        d() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, Contact peer, int errorCode, String errorMsg) {
            if (errorCode == 0) {
                if (MatchFriendGeneralHelper.this.mNeedReportGreet) {
                    MatchFriendGeneralHelper.this.mNeedReportGreet = false;
                    ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).greetReport(MatchFriendGeneralHelper.this.mAppInterface, MatchFriendGeneralHelper.this.mFriendTinyId, MatchFriendGeneralHelper.this.observerKey);
                    return;
                }
                return;
            }
            QLog.e("IMsgListenerAdapter", 1, "onSendMsgError errorCode " + errorCode + " , errorMsg " + errorMsg);
        }
    }

    private final void y() {
        this.mNeedReportGreet = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 9, 1};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 1) {
            Z();
        } else if (state == 9) {
            onStop();
        } else {
            if (state != 12) {
                return;
            }
            U();
        }
    }
}
