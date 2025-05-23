package com.tencent.qqnt.aio.predownload.video.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.utils.ap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.predownload.video.strategy.g;
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
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/strategy/g;", "", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "", "isFromAIO", "Lcom/tencent/qqnt/aio/predownload/video/strategy/f;", "b", "Lcom/tencent/qqnt/aio/predownload/video/strategy/a;", "callback", "", "a", "Lcom/tencent/qqnt/aio/predownload/video/strategy/b;", "d", "e", "c", "Lcom/tencent/qqnt/aio/predownload/video/strategy/c;", "preDownloadThumbCallback", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f351871a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/strategy/g$a", "Lcom/tencent/qqnt/aio/predownload/video/strategy/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "troopType", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.qqnt.aio.predownload.video.strategy.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.strategy.a f351872a;

        a(com.tencent.qqnt.aio.predownload.video.strategy.a aVar) {
            this.f351872a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qqnt.aio.predownload.video.strategy.b
        public void a(@NotNull GroupMsgMask troopType) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopType);
                return;
            }
            Intrinsics.checkNotNullParameter(troopType, "troopType");
            com.tencent.qqnt.aio.predownload.video.strategy.a aVar = this.f351872a;
            if (troopType == GroupMsgMask.NOTIFY) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.onResult(z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/strategy/g$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "", "onGroupDetailInfoChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f351873d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ s f351874e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ShortVideoMsgItem f351875f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.strategy.b f351876h;

        b(long j3, s sVar, ShortVideoMsgItem shortVideoMsgItem, com.tencent.qqnt.aio.predownload.video.strategy.b bVar) {
            this.f351873d = j3;
            this.f351874e = sVar;
            this.f351875f = shortVideoMsgItem;
            this.f351876h = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), sVar, shortVideoMsgItem, bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(com.tencent.qqnt.aio.predownload.video.strategy.b callback, GroupDetailInfo groupDetailInfo) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            GroupMsgMask groupMsgMask = groupDetailInfo.cmdUinMsgMask;
            Intrinsics.checkNotNullExpressionValue(groupMsgMask, "groupDetail.cmdUinMsgMask");
            callback.a(groupMsgMask);
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
        public void onGroupDetailInfoChange(@Nullable final GroupDetailInfo groupDetail) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupDetail);
                return;
            }
            if (groupDetail != null && this.f351873d == groupDetail.groupCode) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f351874e.x0(this);
                if (groupDetail.cmdUinMsgMask == GroupMsgMask.NOTIFY) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoPreDownloadStrategy", 2, "[getPreDownloadVideoSwitch.checkGroupOrDiscussVideoAutoDownload] msgId=" + this.f351875f.getMsgId() + " return " + z17, ", groupCode=" + Long.valueOf(groupDetail.groupCode) + ", GroupMsgMask=" + groupDetail.cmdUinMsgMask);
                }
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final com.tencent.qqnt.aio.predownload.video.strategy.b bVar = this.f351876h;
                uIHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.strategy.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b.b(b.this, groupDetail);
                    }
                });
            }
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/strategy/g$c", "Lcom/tencent/qqnt/aio/predownload/video/strategy/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "troopType", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.qqnt.aio.predownload.video.strategy.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShortVideoMsgItem f351877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.strategy.c f351878b;

        c(ShortVideoMsgItem shortVideoMsgItem, com.tencent.qqnt.aio.predownload.video.strategy.c cVar) {
            this.f351877a = shortVideoMsgItem;
            this.f351878b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) shortVideoMsgItem, (Object) cVar);
            }
        }

        @Override // com.tencent.qqnt.aio.predownload.video.strategy.b
        public void a(@NotNull GroupMsgMask troopType) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopType);
                return;
            }
            Intrinsics.checkNotNullParameter(troopType, "troopType");
            if (troopType == GroupMsgMask.NOTIFY) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + this.f351877a.getMsgId() + " return " + z16);
            }
            this.f351878b.onResult(z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f351871a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(ShortVideoMsgItem msgItem, com.tencent.qqnt.aio.predownload.video.strategy.a callback) {
        if (msgItem.p0() == 2) {
            d(msgItem, new a(callback));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloadStrategy", 2, "[getPreDownloadVideoSwitch.checkGroupOrDiscussVideoAutoDownload] msgId=" + msgItem.getMsgId() + " return true. ");
        }
        callback.onResult(true);
    }

    private final f b(ShortVideoMsgItem msgItem, boolean isFromAIO) {
        if (msgItem.E2().busiType == 0) {
            if (isFromAIO) {
                return d.f351863a.a().a();
            }
            return d.f351863a.a().b();
        }
        if (isFromAIO) {
            return d.f351863a.b().a();
        }
        return d.f351863a.b().b();
    }

    private final void d(ShortVideoMsgItem msgItem, com.tencent.qqnt.aio.predownload.video.strategy.b callback) {
        try {
            long parseLong = Long.parseLong(msgItem.r0());
            s c16 = com.tencent.qqnt.msg.f.c();
            if (c16 == null) {
                QLog.e("ShortVideoPreDownloadStrategy", 1, "[getPreDownloadVideoSwitch.checkGroupOrDiscussVideoAutoDownload] msgId=" + msgItem.getMsgId() + " return false, groupService is null!");
                callback.a(GroupMsgMask.UNSPECIFIED);
                return;
            }
            c16.D(new b(parseLong, c16, msgItem, callback));
            c16.getGroupDetailInfo(parseLong, GroupInfoSource.KAIO, null);
        } catch (NumberFormatException e16) {
            callback.a(GroupMsgMask.UNSPECIFIED);
            QLog.e("NT_ShortVideoPreDownloader", 1, "[getPreDownloadVideoSwitch.checkGroupOrDiscussVideoAutoDownload] msgId=" + msgItem.getMsgId() + " error. ", e16);
        }
    }

    public final void c(@NotNull ShortVideoMsgItem msgItem, boolean isFromAIO, @NotNull com.tencent.qqnt.aio.predownload.video.strategy.a callback) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msgItem, Boolean.valueOf(isFromAIO), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (msgItem.N2()) {
            QLog.w("ShortVideoPreDownloadStrategy", 1, "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " return false, short video has expired");
            callback.onResult(false);
            return;
        }
        if (TextUtils.isEmpty(msgItem.G2()) && TextUtils.isEmpty(msgItem.H2())) {
            QLog.e("ShortVideoPreDownloadStrategy", 1, "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " return false, msg.uuid and md5 are null");
            callback.onResult(false);
            return;
        }
        f b16 = b(msgItem, isFromAIO);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " isFromAIO=" + isFromAIO;
            if (msgItem.p0() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[1] = ", isC2C=" + z16;
            if (msgItem.E2().busiType == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr[2] = ", isShortVideo=" + z17;
            objArr[3] = ", config=" + b16;
            QLog.d("ShortVideoPreDownloadStrategy", 2, objArr);
        }
        if (!b16.c()) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " return false, not allow pre download video.");
            }
            callback.onResult(false);
            return;
        }
        if (msgItem.E2().busiType == 1 && ((System.currentTimeMillis() / 1000) - msgItem.getMsgRecord().msgTime) / 60 > b16.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " return false, out of validity. ", "msgTime=" + msgItem.getMsgRecord().msgTime + ", strategy.limitTimeInMinutes=" + b16.a());
            }
            callback.onResult(false);
            return;
        }
        int a16 = ap.f194113a.a();
        if (a16 != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[getPreDownloadVideoSwitch] msgId=" + msgItem.getMsgId() + " return false, Not Wifi, networkType=" + a16);
            }
            callback.onResult(false);
            return;
        }
        a(msgItem, callback);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            d.f351863a.c();
        }
    }

    public final void f(@NotNull ShortVideoMsgItem msgItem, boolean isFromAIO, @NotNull com.tencent.qqnt.aio.predownload.video.strategy.c preDownloadThumbCallback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msgItem, Boolean.valueOf(isFromAIO), preDownloadThumbCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(preDownloadThumbCallback, "preDownloadThumbCallback");
        if (msgItem.N2()) {
            QLog.d("ShortVideoPreDownloadStrategy", 1, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return false, short video thumb has expired");
            preDownloadThumbCallback.onResult(false);
            return;
        }
        f b16 = b(msgItem, isFromAIO);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " isFromAIO=" + isFromAIO;
            if (msgItem.p0() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[1] = ", isC2C=" + z16 + " config=" + b16;
            QLog.d("ShortVideoPreDownloadStrategy", 2, objArr);
        }
        if (!b16.b()) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return false, not allow pre download thumb.");
            }
            preDownloadThumbCallback.onResult(false);
            return;
        }
        if (((System.currentTimeMillis() / 1000) - msgItem.getMsgRecord().msgTime) / 60 > b16.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return false, out of time limit. ", "msgTime=" + msgItem.getMsgRecord().msgTime + ", strategy.limitTimeInMinutes=" + b16.a());
            }
            preDownloadThumbCallback.onResult(false);
            return;
        }
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        ap apVar = ap.f194113a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        boolean b17 = apVar.b(context);
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + ", isWifiConnected=" + b17 + " isAutoSetting=" + readValue);
        }
        if (msgItem.p0() == 2) {
            if (b17) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return true");
                }
                preDownloadThumbCallback.onResult(true);
                return;
            }
            if (readValue) {
                d(msgItem, new c(msgItem, preDownloadThumbCallback));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return false");
            }
            preDownloadThumbCallback.onResult(false);
            return;
        }
        if (b17 || readValue) {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloadStrategy", 2, "[isNeedPreDownloadThumb] msgId=" + msgItem.getMsgId() + " return " + z17);
        }
        preDownloadThumbCallback.onResult(z17);
    }
}
