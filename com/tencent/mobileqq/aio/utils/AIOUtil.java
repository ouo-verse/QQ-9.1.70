package com.tencent.mobileqq.aio.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.activity.ChatSettingActivity;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.aio.api.IAIOBlurApi;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
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
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.setting.BuddyChatSettingDemoActivity;
import com.tencent.qqnt.setting.TroopSettingDemoActivity;
import com.tencent.video.decode.AVDecodeOption;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bT\u0010UJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0016\u001a\u00020\nJ0\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020\rJ\u0018\u0010+\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020)J\u0018\u0010/\u001a\f\u0012\u0006\b\u0001\u0012\u00020.\u0018\u00010-2\u0006\u0010,\u001a\u00020\rJ\u000e\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\n2\u0006\u00103\u001a\u000202J\u000e\u00105\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00108\u001a\u0002072\u0006\u00106\u001a\u00020\rJ'\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010A\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010?J\u000e\u0010B\u001a\u0002092\u0006\u0010\"\u001a\u00020\u000fJ$\u0010E\u001a\u00020\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\u000f2\b\u0010C\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010D\u001a\u000207J\u001a\u0010F\u001a\u00020\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\u000f2\b\u0010C\u001a\u0004\u0018\u00010\u0013J\u000e\u0010G\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010H\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u000fJ\u0006\u0010I\u001a\u00020\nR\u001b\u0010M\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010J\u001a\u0004\bK\u0010LR\u001b\u0010O\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010J\u001a\u0004\bN\u0010LR\u0015\u0010S\u001a\u00020\n*\u00020P8F\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/AIOUtil;", "", "Lcom/tencent/qqnt/kernel/api/s;", "g", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", tl.h.F, "Landroid/content/Context;", "context", "", "isScaleAIO", "isMiniAIO", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "r", "y", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "list", "p", "d", "Landroid/view/View;", "touchView", "top", "bottom", "left", "right", "", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "vb", ReportConstant.COSTREPORT_PREFIX, "aioContext", "b", "c", "D", "view", "resId", "G", "Landroid/graphics/drawable/Drawable;", "drawable", UserInfo.SEX_FEMALE, "chatType", "Ljava/lang/Class;", "Landroid/app/Activity;", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "u", "w", "totalSeconds", "", "I", "", "groupCode", "forceFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "i", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "text", "o", "k", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "from", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "t", "()Z", "isNTRuntime", "l", "mAvatarMarginSwitch", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "v", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;)Z", "isOwnerOrAdmin", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOUtil f194084a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isNTRuntime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mAvatarMarginSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/utils/AIOUtil$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "", "onGroupDetailInfoChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.kernel.api.s f194087d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<GroupDetailInfo> f194088e;

        /* JADX WARN: Multi-variable type inference failed */
        a(com.tencent.qqnt.kernel.api.s sVar, Continuation<? super GroupDetailInfo> continuation) {
            this.f194087d = sVar;
            this.f194088e = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sVar, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            com.tencent.qqnt.kernel.nativeinterface.am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            com.tencent.qqnt.kernel.nativeinterface.am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            com.tencent.qqnt.kernel.nativeinterface.am.f(this, j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.i(this, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(@Nullable GroupDetailInfo groupDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupDetail);
            } else {
                this.f194087d.x0(this);
                this.f194088e.resumeWith(Result.m476constructorimpl(groupDetail));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.l(this, groupExtListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.m(this, firstGroupBulletinInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            com.tencent.qqnt.kernel.nativeinterface.am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            com.tencent.qqnt.kernel.nativeinterface.am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.qqnt.kernel.nativeinterface.am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.qqnt.kernel.nativeinterface.am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            com.tencent.qqnt.kernel.nativeinterface.am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            com.tencent.qqnt.kernel.nativeinterface.am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.am.A(this, j3, dataSource, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.D(this, j3, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f194089a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65278);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f194089a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgElementFilePathExtUtil", 2, "[getGroupDetailInfo]: result=" + i3 + ", err=" + str);
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AVDecodeOption.ENCODING_PCM_16BIT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        f194084a = new AIOUtil();
        lazy = LazyKt__LazyJVMKt.lazy(AIOUtil$isNTRuntime$2.INSTANCE);
        isNTRuntime = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOUtil$mAvatarMarginSwitch$2.INSTANCE);
        mAvatarMarginSwitch = lazy2;
    }

    AIOUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void B(AIOUtil aIOUtil, com.tencent.aio.api.runtime.a aVar, AIOMsgItem aIOMsgItem, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "13";
        }
        aIOUtil.A(aVar, aIOMsgItem, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, int i3, int i16, int i17, int i18) {
        f194084a.e(view, i3, i16, i17, i18);
    }

    private final com.tencent.qqnt.kernel.api.s g() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    public static /* synthetic */ Object j(AIOUtil aIOUtil, long j3, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return aIOUtil.i(j3, z16, continuation);
    }

    private final boolean l() {
        return ((Boolean) mAvatarMarginSwitch.getValue()).booleanValue();
    }

    public final void A(@Nullable com.tencent.aio.api.runtime.a context, @Nullable AIOMsgItem item, @NotNull String from) {
        Fragment c16;
        Context context2;
        MsgRecord msgRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, context, item, from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (context != null && (c16 = context.c()) != null && (context2 = c16.getContext()) != null && item != null && (msgRecord = item.getMsgRecord()) != null) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
            int i3 = msgRecord.chatType;
            String str = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msg.peerUid");
            String str2 = msgRecord.peerName;
            Intrinsics.checkNotNullExpressionValue(str2, "msg.peerName");
            long j3 = msgRecord.senderUin;
            Bundle bundle = new Bundle();
            bundle.putLong("key_navigate_msgid", item.getMsgRecord().msgId);
            bundle.putLong("key_navigate_msgseq", item.getMsgRecord().msgSeq);
            bundle.putString("key_from", from);
            Unit unit = Unit.INSTANCE;
            iAIOStarterApi.navigateToAIOActivity(context2, i3, str, str2, j3, bundle);
        }
    }

    public final boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return l();
    }

    public final boolean D(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (!b(aioContext) && !c(aioContext)) {
            return false;
        }
        return true;
    }

    public final void E(@Nullable com.tencent.aio.api.runtime.a context, @Nullable AIOMsgItem item) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        String str;
        FileElement fileElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) context, (Object) item);
            return;
        }
        if (context != null && item != null && item.getMsgRecord() != null) {
            String str2 = "1";
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "1"), TuplesKt.to("group_id", item.getMsgRecord().peerUid));
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("qq_pgid", "pg_group_teacher_msg_detail"), TuplesKt.to("qq_eid", "em_bas_message_bubble"), TuplesKt.to("aio_information_type", String.valueOf(item.getMsgRecord().msgType)), TuplesKt.to("cur_pg", hashMapOf));
            if (d.x(item)) {
                MsgElement firstTypeElement = item.getFirstTypeElement(3);
                if (firstTypeElement != null && (fileElement = firstTypeElement.fileElement) != null) {
                    str = fileElement.filePath;
                } else {
                    str = null;
                }
                if (!com.tencent.qqnt.aio.utils.m.e(str)) {
                    str2 = "2";
                }
                hashMapOf2.put("file_status", str2);
            }
            VideoReport.reportEvent("dt_clck", hashMapOf2);
        }
    }

    public final void F(@Nullable View view, @NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (view == null) {
            return;
        }
        int paddingTop = view.getPaddingTop();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void G(@Nullable View view, int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, resId);
            return;
        }
        if (view == null) {
            return;
        }
        int paddingTop = view.getPaddingTop();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(resId);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void H(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        ViewPropertyAnimator animate = view.animate();
        animate.scaleX(1.0f);
        animate.scaleY(1.0f);
        animate.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), R.anim.f154976uj));
        animate.start();
    }

    @NotNull
    public final String I(int totalSeconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, totalSeconds);
        }
        if (totalSeconds <= 0) {
            return QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        }
        int i3 = totalSeconds % 60;
        int i16 = (totalSeconds / 60) % 60;
        int i17 = totalSeconds / 3600;
        if (i17 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i17), Integer.valueOf(i16), Integer.valueOf(i3)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i16), Integer.valueOf(i3)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    public final boolean b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Integer num;
        String str;
        boolean z16;
        AIOSession r16;
        AIOContact c16;
        AIOSession r17;
        AIOContact c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Long l3 = null;
        if (g16 != null && (r17 = g16.r()) != null && (c17 = r17.c()) != null) {
            num = Integer.valueOf(c17.e());
        } else {
            num = null;
        }
        AIOParam g17 = aioContext.g();
        if (g17 != null && (r16 = g17.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        } else {
            str = null;
        }
        AIOParam g18 = aioContext.g();
        if (g18 != null) {
            l3 = Long.valueOf(su3.c.a(g18));
        }
        if (!com.tencent.mobileqq.aio.a.d(aioContext) && !com.tencent.mobileqq.aio.a.c(aioContext)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return ((IAIOBlurApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOBlurApi.class)).enableBlur(new com.tencent.qqnt.aio.data.b(num, str, l3, z16));
    }

    public final boolean c(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        return ((IAIOImmersiveApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOImmersiveApi.class)).enableImmersive(aioContext);
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return ((IAIOConfig) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOConfig.class)).isFeatureSwitchOn(IAIOConfig.FEATURE_PHOTO_PANEL_BLUR);
    }

    public final void e(@Nullable final View touchView, final int top, final int bottom, final int left, final int right) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, touchView, Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(left), Integer.valueOf(right));
            return;
        }
        if (touchView == null) {
            return;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Object parent = touchView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).post(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.g
                @Override // java.lang.Runnable
                public final void run() {
                    AIOUtil.f(touchView, top, bottom, left, right);
                }
            });
            return;
        }
        Rect rect = new Rect();
        touchView.setEnabled(true);
        touchView.getHitRect(rect);
        rect.top -= top;
        rect.bottom += bottom;
        rect.left -= left;
        rect.right += right;
        if (QLog.isColorLevel()) {
            QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
        }
        TouchDelegate touchDelegate = new TouchDelegate(rect, touchView);
        if (View.class.isInstance(touchView.getParent())) {
            Object parent2 = touchView.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            ((View) parent2).setTouchDelegate(touchDelegate);
        }
    }

    @NotNull
    public final Contact h(@NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Contact) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioSession);
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return new Contact(aioSession.c().e(), aioSession.c().j(), aioSession.c().f());
    }

    @Nullable
    public final Object i(long j3, boolean z16, @NotNull Continuation<? super GroupDetailInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            com.tencent.qqnt.kernel.api.s g16 = f194084a.g();
            if (g16 == null) {
                safeContinuation.resumeWith(Result.m476constructorimpl(null));
            } else {
                g16.D(new a(g16, safeContinuation));
                g16.getGroupDetailInfo(j3, GroupInfoSource.KAIO, b.f194089a);
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 23, this, Long.valueOf(j3), Boolean.valueOf(z16), continuation);
    }

    public final long k(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this, (Object) aioContext)).longValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOMsgListEvent.GetLastMsgSeq getLastMsgSeq = new AIOMsgListEvent.GetLastMsgSeq(0L, 1, null);
        aioContext.e().h(getLastMsgSeq);
        return getLastMsgSeq.a();
    }

    public final int m(@NotNull Context context, boolean isScaleAIO, boolean isMiniAIO) {
        int dimension;
        float dimension2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(isScaleAIO), Boolean.valueOf(isMiniAIO))).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isScaleAIO && !isMiniAIO) {
            dimension = ImmersiveUtils.getStatusBarHeight(context);
            dimension2 = context.getResources().getDimension(R.dimen.f158287c11);
        } else {
            dimension = (int) context.getResources().getDimension(R.dimen.f158287c11);
            dimension2 = context.getResources().getDimension(R.dimen.dbx);
        }
        return dimension + ((int) dimension2);
    }

    @Nullable
    public final Class<? extends Activity> n(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Class) iPatchRedirector.redirect((short) 17, (Object) this, chatType);
        }
        if (chatType != 1) {
            if (chatType != 2) {
                if (chatType == 104 || chatType == 106 || chatType == 111) {
                    return ChatSettingActivity.class;
                }
                return null;
            }
            return TroopSettingDemoActivity.class;
        }
        return BuddyChatSettingDemoActivity.class;
    }

    @NotNull
    public final CharSequence o(@Nullable CharSequence text) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (CharSequence) iPatchRedirector.redirect((short) 25, (Object) this, (Object) text);
        }
        if (text != null) {
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return text.charAt(0) + "|" + text.length();
            }
        }
        return "0|0";
    }

    public final boolean p(@NotNull List<? extends AIOMsgItem> list) {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(list, "list");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        AIOMsgItem aIOMsgItem = (AIOMsgItem) lastOrNull;
        if (aIOMsgItem == null || !aIOMsgItem.H0()) {
            return false;
        }
        return true;
    }

    public final boolean q(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        aioContext.e().h(getCurFocusIndex);
        if (getCurFocusIndex.a() == -1) {
            return true;
        }
        return false;
    }

    public final boolean r(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.g().l().getBoolean("key_is_multiforward_page", false);
    }

    public final boolean s(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.c vb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) vb5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(vb5, "vb");
        d.m mVar = new d.m(false, 1, null);
        vb5.sendIntent(mVar);
        return mVar.a();
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) isNTRuntime.getValue()).booleanValue();
    }

    public final boolean u(@NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) aioParam)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        long j3 = aioParam.l().getLong("key_notify_app_id");
        int i3 = aioParam.l().getInt("key_notify_app_type");
        if (j3 == 0 || i3 == 0 || aioParam.r().c().e() != 201) {
            return false;
        }
        return true;
    }

    public final boolean v(@NotNull MemberRole memberRole) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) memberRole)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(memberRole, "<this>");
        if (memberRole != MemberRole.OWNER && memberRole != MemberRole.ADMIN) {
            return false;
        }
        return true;
    }

    public final boolean w(@NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) aioSession)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        String currentUid = MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUid();
        if (aioSession.c().e() == 1 && Intrinsics.areEqual(currentUid, aioSession.c().j())) {
            return true;
        }
        return false;
    }

    public final boolean x(@NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aioSession)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        if (aioSession.c().e() == 2 && ((IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class)).isGuildTroop(aioSession.c().j())) {
            return true;
        }
        return false;
    }

    public final boolean y(@Nullable com.tencent.aio.api.runtime.a context) {
        AIOParam g16;
        Bundle l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).booleanValue();
        }
        if (context == null || (g16 = context.g()) == null || (l3 = g16.l()) == null) {
            return false;
        }
        return l3.getBoolean("key_is_troop_history_msg_page", false);
    }

    public final boolean z(@NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) aioSession)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        if (aioSession.c().e() == 2 && ((ITroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITroopApi.class)).isTroopSquareSwitchOn(aioSession.c().j())) {
            return true;
        }
        return false;
    }
}
