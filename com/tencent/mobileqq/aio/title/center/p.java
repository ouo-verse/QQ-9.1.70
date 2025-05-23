package com.tencent.mobileqq.aio.title.center;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.stranger.api.IStrangerAIOApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.aa;
import com.tencent.mobileqq.aio.title.ae;
import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.aio.title.aj;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.an;
import com.tencent.mobileqq.aio.title.ao;
import com.tencent.mobileqq.aio.title.center.CenterUIState;
import com.tencent.mobileqq.aio.title.center.a;
import com.tencent.mobileqq.aio.title.center.j;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.x;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOAnonymousApi;
import com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleRichStatusApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0003EIO\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0005\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020/H\u0002J$\u00106\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u0001012\u0006\u00105\u001a\u000204H\u0002J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u000204H\u0002J\b\u0010<\u001a\u000204H\u0002J\b\u0010=\u001a\u000204H\u0002R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u0011R\u0016\u0010A\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010&R\u0016\u0010D\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010P\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/aio/title/center/p;", "Lcom/tencent/mobileqq/aio/title/al;", "Lcom/tencent/mobileqq/aio/title/center/a;", "Lcom/tencent/mobileqq/aio/title/center/CenterUIState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "L", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "y", "Lcom/tencent/qqnt/kernel/api/s;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/mobileqq/aio/title/m$d;", "K", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$GetMutualMarkLocationEvent;", "Lcom/tencent/mobileqq/aio/title/m$b;", "H", "Lcom/tencent/mobileqq/aio/title/an;", "data", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$GetNickEvent;", "J", "", "type", "", "P", "O", "c0", "", "B", "nick", HippyTKDListViewAdapter.X, "Z", UserInfo.SEX_FEMALE, "d0", "b0", "e0", "Landroid/content/Context;", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/mobileqq/aio/title/ai;", "N", "Lcom/tencent/mobileqq/aio/title/ae;", SemanticAttributes.DbCassandraConsistencyLevelValues.ONE, SemanticAttributes.DbCassandraConsistencyLevelValues.TWO, "", "needAnim", "M", "showEar", "G", "U", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "W", "T", "f", "mRoamLoadingStatus", tl.h.F, "isAlive", "i", "Ljava/lang/CharSequence;", "mainTitleText", "com/tencent/mobileqq/aio/title/center/p$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/title/center/p$b;", "mActionR", "com/tencent/mobileqq/aio/title/center/p$c", "Lcom/tencent/mobileqq/aio/title/center/p$c;", "mMemberListListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mRoamLoadingRunnable", "com/tencent/mobileqq/aio/title/center/p$d", "Lcom/tencent/mobileqq/aio/title/center/p$d;", "mRoamAction", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class p extends al<a, CenterUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int G = 0;
    private static final int H;
    private static final int I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mMemberListListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable mRoamLoadingRunnable;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final d mRoamAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mRoamLoadingStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAlive;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence mainTitleText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/center/p$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.center.p$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/center/p$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return p.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/center/p$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetailInfo", "", "onGroupDetailInfoChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            am.f(this, j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            am.i(this, j3, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(@Nullable GroupDetailInfo groupDetailInfo) {
            boolean z16;
            String nick;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupDetailInfo);
                return;
            }
            if (groupDetailInfo == null || !Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) p.this.getMContext()).g().r().c().j(), String.valueOf(groupDetailInfo.groupCode))) {
                return;
            }
            p.this.updateUI(new CenterUIState.UpdateGroupCount(groupDetailInfo.memberNum));
            String str = groupDetailInfo.remarkName;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                nick = groupDetailInfo.groupName;
            } else {
                nick = groupDetailInfo.remarkName;
            }
            if (TextUtils.isEmpty(nick)) {
                nick = String.valueOf(groupDetailInfo.groupCode);
            }
            p pVar = p.this;
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            pVar.mainTitleText = pVar.x(nick);
            p pVar2 = p.this;
            pVar2.updateUI(new CenterUIState.UpdateMainTitle(pVar2.mainTitleText));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
            am.l(this, groupExtListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            am.m(this, firstGroupBulletinInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            am.A(this, j3, dataSource, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            am.D(this, j3, arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/center/p$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (!(i3 instanceof AIOMsgListEvent.LoadRoamFirstMsgEvent)) {
                return;
            }
            AIOMsgListEvent.LoadRoamFirstMsgEvent loadRoamFirstMsgEvent = (AIOMsgListEvent.LoadRoamFirstMsgEvent) i3;
            QLog.d("CenterVM", 1, "call roamEvent" + loadRoamFirstMsgEvent.a());
            int a16 = loadRoamFirstMsgEvent.a();
            if (a16 == 2) {
                p.this.e0();
            } else if (a16 == 3) {
                p.this.d0();
            } else if (a16 == 4) {
                p.this.b0();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        H = 1;
        I = 2;
    }

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mRoamLoadingStatus = G;
        this.mainTitleText = "";
        this.mActionR = new b();
        this.mMemberListListener = new c();
        this.mRoamLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.l
            @Override // java.lang.Runnable
            public final void run() {
                p.X(p.this);
            }
        };
        this.mRoamAction = new d();
    }

    private final s A() {
        IKernelService iKernelService;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null && (iKernelService = (IKernelService) waitAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final CharSequence B() {
        CharSequence g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type kotlin.CharSequence");
        if (TextUtils.isEmpty(g16)) {
            g16 = com.tencent.mobileqq.aio.title.o.b((com.tencent.aio.api.runtime.a) getMContext());
            Intrinsics.checkNotNullExpressionValue(g16, "getNick(mContext)");
        }
        return x(g16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r0.equals("2971") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0.equals("2921") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r0.equals("1000") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r0.equals("3064") == false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Drawable C(Context context) {
        int i3;
        Drawable loadingDrawable;
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (currentThemeId != null) {
            i3 = 3;
            switch (currentThemeId.hashCode()) {
                case 56601:
                    if (currentThemeId.equals("999")) {
                        i3 = 2;
                        break;
                    }
                    break;
                case 1507423:
                    break;
                case 1545926:
                    break;
                case 1546081:
                    break;
                case 1567195:
                    break;
            }
            loadingDrawable = LoadingUtil.getLoadingDrawable(context, i3);
            if (loadingDrawable != null) {
                loadingDrawable.setBounds(0, 0, x.a(10.0f), x.a(10.0f));
            }
            return loadingDrawable;
        }
        i3 = 1;
        loadingDrawable = LoadingUtil.getLoadingDrawable(context, i3);
        if (loadingDrawable != null) {
        }
        return loadingDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int D() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return ((IAIOAnonymousApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAnonymousApi.class)).getRobotDrawableId(su3.c.b(g16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        if (R() || U()) {
            AIOMsgListEvent.FetchRoamStateEvent fetchRoamStateEvent = new AIOMsgListEvent.FetchRoamStateEvent(0);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(fetchRoamStateEvent);
            QLog.d("CenterVM", 1, "getSubTitle roamEvent" + fetchRoamStateEvent.a());
            int a16 = fetchRoamStateEvent.a();
            if (a16 != 1) {
                if (a16 == 3) {
                    d0();
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LoadRoamFirstMsgEvent.class)), this.mRoamAction);
                    return;
                }
            } else {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LoadRoamFirstMsgEvent.class)), this.mRoamAction);
            }
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleEvent.SubTitleRequestEvent(0));
    }

    private final void G(boolean showEar) {
        updateUI(new CenterUIState.UpdateEarIcon(showEar, W()));
    }

    private final m.b H(AIOTitleEvent.GetMutualMarkLocationEvent intent) {
        return new m.b((Point) fetchVBState(new j.a(intent.a())).b().getParcelable("mutual_mark_location"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (intent instanceof AIOTitleEvent.GetTitleHeightEvent) {
            return K();
        }
        if (intent instanceof AIOTitleEvent.GetMutualMarkLocationEvent) {
            return H((AIOTitleEvent.GetMutualMarkLocationEvent) intent);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void J(AIOTitleEvent.GetNickEvent intent) {
        boolean z16;
        CharSequence B;
        if (this.mainTitleText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            B = this.mainTitleText;
        } else {
            B = B();
        }
        intent.b(B);
    }

    private final m.d K() {
        return new m.d(fetchVBState(j.b.f193931a).b().getInt("title_height", 0));
    }

    private final void M(ae one, ae two, boolean needAnim) {
        updateUI(new CenterUIState.UpdateMutualMarkState(one, two, W(), needAnim));
    }

    private final void N(ai data) {
        updateUI(new CenterUIState.UpdateSubTitle(data, W()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0036, code lost:
    
        if (r0.isRobotUin(su3.c.b(r3)) != false) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void O(Object data) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        boolean z16 = true;
        if (su3.c.c(g16) != 1) {
            IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        }
        z16 = false;
        if (!z16) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.aio.title.VipData");
            updateUI(new CenterUIState.UpdateVIPState((ao) data, z16));
        }
    }

    private final void P(int type, Object data) {
        boolean z16;
        CharSequence charSequence;
        if (data == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("CenterVM", 1, "handleTitleResponseData type " + type + " data " + z16);
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type != 9) {
                            if (type == 11) {
                                updateUI(new CenterUIState.UpdateSubTitle(new ai(null, null, null, "", ""), W()));
                                return;
                            }
                            return;
                        } else {
                            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.aio.title.SubTitleRichData");
                            updateUI(new CenterUIState.UpdateResetSubTitleText((aj) data, W()));
                            return;
                        }
                    }
                    if (data instanceof CharSequence) {
                        charSequence = (CharSequence) data;
                    } else {
                        charSequence = null;
                    }
                    if (charSequence != null) {
                        CharSequence x16 = x(charSequence);
                        this.mainTitleText = x16;
                        updateUI(new CenterUIState.UpdateMainTitle(x16));
                        return;
                    }
                    return;
                }
                updateUI(new CenterUIState.UpdateSubTitleText((String) data));
                return;
            }
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
            CharSequence x17 = x((String) data);
            this.mainTitleText = x17;
            updateUI(new CenterUIState.UpdateMainTitle(x17));
            return;
        }
        O(data);
    }

    private final void Q(an data) {
        updateUI(new CenterUIState.UpdateTroopFlameState(data));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean R() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean S() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 102) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean T() {
        return ((IStrangerAIOApi) QRoute.api(IStrangerAIOApi.class)).isSupportAIOTitleMutual(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean U() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean W() {
        return AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) getMContext()).g().r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void X(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getContext();
        if (context == null) {
            return;
        }
        this$0.mRoamLoadingStatus = I;
        Drawable C = this$0.C(context);
        String string = context.getString(R.string.ytv);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.aio_subtitle_roam_state)");
        this$0.updateUI(new CenterUIState.UpdateSubTitle(new ai(null, C, null, string, "6"), this$0.W()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Z() {
        boolean z16;
        ai subTitleSync;
        AppRuntime appRuntime;
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IAIOTitleApi) companion.a(IAIOTitleApi.class)).isSupportEar((com.tencent.aio.api.runtime.a) getMContext())) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                appRuntime = mobileQQ.waitAppRuntime();
            } else {
                appRuntime = null;
            }
            if (!com.tencent.mobileqq.qqaudio.audioplayer.c.b(appRuntime)) {
                z16 = true;
                CharSequence B = B();
                this.mainTitleText = B;
                updateUI(new CenterUIState.UpdateDataUIState(new aa(B, z16, W(), D())));
                subTitleSync = ((IAIOSubTitleApi) companion.a(IAIOSubTitleApi.class)).getSubTitleSync((com.tencent.aio.api.runtime.a) getMContext());
                if (subTitleSync != null) {
                    updateUI(new CenterUIState.UpdateSubTitle(subTitleSync, W()));
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a0(p.this);
                    }
                });
            }
        }
        z16 = false;
        CharSequence B2 = B();
        this.mainTitleText = B2;
        updateUI(new CenterUIState.UpdateDataUIState(new aa(B2, z16, W(), D())));
        subTitleSync = ((IAIOSubTitleApi) companion.a(IAIOSubTitleApi.class)).getSubTitleSync((com.tencent.aio.api.runtime.a) getMContext());
        if (subTitleSync != null) {
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.k
            @Override // java.lang.Runnable
            public final void run() {
                p.a0(p.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a0(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F();
        if (this$0.R()) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new AIOTitleEvent.TitleRequestEvent(1, null));
            ((IAIOTitleRichStatusApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleRichStatusApi.class)).refreshRichStatusText((com.tencent.aio.api.runtime.a) this$0.getMContext());
        } else {
            if (!this$0.U() && !this$0.T()) {
                if (this$0.S()) {
                    ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new AIOTitleEvent.TitleRequestEvent(3, null));
                    return;
                }
                return;
            }
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(AIOTitleEvent.MutualMarkRequestEvent.f188494d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b0() {
        int i3 = this.mRoamLoadingStatus;
        if (i3 == I) {
            ((IAIOSubTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOSubTitleApi.class)).onRoamLoadingEnd((com.tencent.aio.api.runtime.a) getMContext());
        } else if (i3 == H) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mRoamLoadingRunnable);
            ((IAIOSubTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOSubTitleApi.class)).onRoamLoadingEnd((com.tencent.aio.api.runtime.a) getMContext());
        }
        this.mRoamLoadingStatus = G;
        e0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0() {
        ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).onNickClick((com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        this.mRoamLoadingStatus = H;
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mRoamLoadingRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.o
            @Override // java.lang.Runnable
            public final void run() {
                p.g0(p.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g0(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LoadRoamFirstMsgEvent.class)), this$0.mRoamAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence x(CharSequence nick) {
        CharSequence a16 = com.tencent.mobileqq.aio.title.o.a(nick);
        Intrinsics.checkNotNullExpressionValue(a16, "filterNick(nick)");
        return a16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        long a16 = su3.c.a(g16);
        if (a16 == 0) {
            try {
                a16 = Long.parseLong(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
            } catch (Exception e16) {
                QLog.e("CenterVM", 1, "getGroupDetailInfo", e16);
                return;
            }
        }
        s A = A();
        if (A != null) {
            A.getGroupDetailInfo(a16, GroupInfoSource.KAIO, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.title.center.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    p.z(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, String str) {
        QLog.d("CenterVM", 1, "getGroupDetailInfo result = " + i3 + " errMsg = " + str);
    }

    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOTitleEvent.SubTitleResponseEvent) {
            N(((AIOTitleEvent.SubTitleResponseEvent) intent).a());
            return;
        }
        if (intent instanceof AIOTitleEvent.MutualMarkResponseEvent) {
            AIOTitleEvent.MutualMarkResponseEvent mutualMarkResponseEvent = (AIOTitleEvent.MutualMarkResponseEvent) intent;
            M(mutualMarkResponseEvent.b(), mutualMarkResponseEvent.c(), mutualMarkResponseEvent.a());
            return;
        }
        if (intent instanceof AIOTitleEvent.TitleResponseEvent) {
            AIOTitleEvent.TitleResponseEvent titleResponseEvent = (AIOTitleEvent.TitleResponseEvent) intent;
            P(titleResponseEvent.b(), titleResponseEvent.a());
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateEarIconEvent) {
            G(((AIOTitleEvent.UpdateEarIconEvent) intent).a());
            return;
        }
        if (intent instanceof AIOTitleEvent.LyricsEvent) {
            AIOTitleEvent.LyricsEvent lyricsEvent = (AIOTitleEvent.LyricsEvent) intent;
            updateUI(new CenterUIState.UpdateLyricsState(lyricsEvent.a(), lyricsEvent.b()));
        } else if (intent instanceof AIOTitleEvent.GetNickEvent) {
            J((AIOTitleEvent.GetNickEvent) intent);
        } else if (intent instanceof AIOTitleEvent.PlayChatNickCoverAnimationEvent) {
            updateUI(new CenterUIState.PlayTitleCoverAnimation(0, 1, null));
        } else if (intent instanceof AIOTitleEvent.UpdateTroopFlameEvent) {
            Q(((AIOTitleEvent.UpdateTroopFlameEvent) intent).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7360a) {
            Z();
            return;
        }
        if (intent instanceof a.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.SubTitleClickEvent.f188503d);
            return;
        }
        if (intent instanceof a.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.SubTitle2ClickEvent.f188502d);
        } else if (intent instanceof a.d) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.SubTitleLeftIconClickEvent.f188504d);
        } else if (intent instanceof a.e) {
            c0();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleResponseEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.MutualMarkResponseEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.TitleResponseEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateEarIconEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.LyricsEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.GetNickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.PlayChatNickCoverAnimationEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateTroopFlameEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.GetTitleHeightEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.GetMutualMarkLocationEvent");
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al, com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        s A;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        this.isAlive = false;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
        if (U() && (A = A()) != null) {
            A.x0(this.mMemberListListener);
        }
        if (U() || R()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LoadRoamFirstMsgEvent.class)), this.mRoamAction);
        }
        this.mRoamLoadingStatus = G;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.isAlive = true;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
        if (U()) {
            s A = A();
            if (A != null) {
                A.D(this.mMemberListListener);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.m
                @Override // java.lang.Runnable
                public final void run() {
                    p.Y(p.this);
                }
            }, 16, null, false);
        }
        this.mRoamLoadingStatus = G;
    }
}
