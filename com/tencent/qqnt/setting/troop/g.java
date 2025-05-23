package com.tencent.qqnt.setting.troop;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.api.w;
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
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.setting.troop.a;
import com.tencent.qqnt.setting.troop.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00015B\u0017\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b2\u00103J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\"\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00101\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/setting/troop/g;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/setting/troop/a;", "Lcom/tencent/qqnt/setting/troop/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/api/s;", "T1", "Lcom/tencent/qqnt/kernel/api/w;", "W1", "", "R1", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isTop", "c2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "mark", ICustomDataEditor.STRING_ARRAY_PARAM_2, "P1", "", "msg", "Z1", "userIntent", "X1", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "onGroupDetailInfoChange", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMPeerId", "()Ljava/lang/String;", "setMPeerId", "(Ljava/lang/String;)V", "mPeerId", "", "D", "I", "getMChatType", "()I", "mChatType", "Lmqq/app/AppRuntime;", "E", "Lmqq/app/AppRuntime;", "mAppRuntime", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/setting/troop/b;", "U1", "()Lcom/tencent/qqnt/setting/troop/b;", "mNoneValueIntent", "<init>", "(Ljava/lang/String;I)V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends BaseViewModel<a, b> implements IKernelGroupListener {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mPeerId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int mChatType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AppRuntime mAppRuntime;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/setting/troop/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.setting.troop.g$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull String mPeerId, int i3) {
        Intrinsics.checkNotNullParameter(mPeerId, "mPeerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mPeerId, i3);
            return;
        }
        this.mPeerId = mPeerId;
        this.mChatType = i3;
        this.mNoneValueIntent = b.c.f362185a;
    }

    private final void P1() {
        w W1 = W1();
        if (W1 != null) {
            W1.clearMsgRecords(new Contact(this.mChatType, this.mPeerId, ""), new IClearMsgRecordsCallback() { // from class: com.tencent.qqnt.setting.troop.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public final void onResult(int i3, String str, long j3) {
                    g.Q1(g.this, i3, str, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(g this$0, int i3, String str, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z1("clearMsgRecords result: " + i3 + ", error: " + str + ", delLastSeq: " + j3);
        MutableLiveData<a> mUiState = this$0.getMUiState();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mUiState.postValue(new a.C9698a(z16));
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.c(this$0.mPeerId, this$0.mChatType, false));
    }

    private final void R1() {
        Z1("getGroupDetailInfo start");
        s T1 = T1();
        if (T1 != null) {
            T1.getGroupDetailInfo(Long.parseLong(this.mPeerId), GroupInfoSource.KDATACARD, new IOperateCallback() { // from class: com.tencent.qqnt.setting.troop.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    g.S1(g.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(g this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z1("getGroupDetailInfo result: " + i3 + ", error: " + str);
    }

    private final s T1() {
        if (this.mAppRuntime == null) {
            this.mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getGroupService();
    }

    private final w W1() {
        if (this.mAppRuntime == null) {
            this.mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    private final void Z1(String msg2) {
        QLog.i("TroopSettingViewModel", 1, msg2);
    }

    private final void a2(GroupMsgMask mark) {
        Z1("setGroupMsgMask mark=" + mark);
        s T1 = T1();
        if (T1 != null) {
            T1.setGroupMsgMask(Long.parseLong(this.mPeerId), mark, new IOperateCallback() { // from class: com.tencent.qqnt.setting.troop.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    g.b2(g.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(g this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z1("setGroupMsgMask result: " + i3 + ", error: " + str);
    }

    private final void c2(boolean isTop) {
        Z1("setTop isTop=" + isTop);
        s T1 = T1();
        if (T1 != null) {
            T1.setTop(Long.parseLong(this.mPeerId), isTop, new IOperateCallback() { // from class: com.tencent.qqnt.setting.troop.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    g.d2(g.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(g this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z1("setTop result: " + i3 + ", error: " + str);
    }

    private final void onCreate() {
        s T1 = T1();
        if (T1 != null) {
            T1.D(this);
        }
    }

    private final void onDestroy() {
        s T1 = T1();
        if (T1 != null) {
            T1.x0(this);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.d) {
            onCreate();
            return;
        }
        if (userIntent instanceof b.e) {
            onDestroy();
            return;
        }
        if (userIntent instanceof b.C9699b) {
            R1();
            return;
        }
        if (userIntent instanceof b.g) {
            c2(((b.g) userIntent).a());
            return;
        }
        if (userIntent instanceof b.f) {
            a2(((b.f) userIntent).a());
            return;
        }
        if (userIntent instanceof b.a) {
            P1();
            return;
        }
        Z1("handleIntent un support " + userIntent);
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

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupDetailInfoChange(@Nullable GroupDetailInfo groupDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) groupDetail);
            return;
        }
        if (groupDetail == null) {
            Z1("onGroupDetailInfoChange groupDetail == null");
            return;
        }
        if (!Intrinsics.areEqual(String.valueOf(groupDetail.groupCode), this.mPeerId)) {
            Z1("onProfileSimpleChanged groupCode error == null");
            return;
        }
        Z1("onProfileSimpleChanged groupDetail=" + groupDetail);
        getMUiState().postValue(new a.b(groupDetail));
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
