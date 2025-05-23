package com.tencent.qqnt.kernel.invorker;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyGroup;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgStatus;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTargetMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\f\u0010\u0010\u001a\u00020\r*\u00020\u000fH\u0002J\u001a\u0010\u0014\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0017\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u000f0\tj\b\u0012\u0004\u0012\u00020\u000f`\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\f\u0010\u0018\u001a\u00020\r*\u00020\u0015H\u0002J\u001c\u0010\u0019\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u000f0\tj\b\u0012\u0004\u0012\u00020\u000f`\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\f\u0010\u001d\u001a\u00020\r*\u00020\u001cH\u0002J,\u0010\"\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001cH\u0002J4\u0010$\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011H\u0002J\f\u0010%\u001a\u00020\r*\u00020\u0012H\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u0010*\u001a\u00020)*\u00020\u000f2\u0006\u0010!\u001a\u00020\u001cH\u0002J\f\u0010+\u001a\u00020\r*\u00020)H\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u0018R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020&0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00101\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KGroupInvorkService;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "", "I", "J", ExifInterface.LATITUDE_SOUTH, "T", "N", "M", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "", "", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "Y", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsgType;", "type", "e0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsgStatus;", "status", "d0", "Z", "W", "L", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "c0", "Lcom/tencent/qqnt/kernel/invorker/g$d;", "actioner", "action", "operateType", "O", "operateTypes", "P", "a0", "", "msgSeq", "U", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateMsg;", "X", "b0", "K", ReportConstant.COSTREPORT_PREFIX, "r", "u", "k", "Ljava/util/List;", "notifyMsgs", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "showCheckGroup", DomainData.DOMAIN_NAME, "checkGroupList", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KGroupInvorkService extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<GroupNotifyMsg> notifyMsgs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private IKernelGroupListener listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showCheckGroup;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> checkGroupList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359114a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f359115b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f359116c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54580);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupNotifyMsgStatus.values().length];
            try {
                iArr[GroupNotifyMsgStatus.KINIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupNotifyMsgStatus.KUNHANDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupNotifyMsgStatus.KAGREED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GroupNotifyMsgStatus.KREFUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GroupNotifyMsgStatus.KIGNORED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f359114a = iArr;
            int[] iArr2 = new int[GroupNotifyOperateType.values().length];
            try {
                iArr2[GroupNotifyOperateType.KAGREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GroupNotifyOperateType.KREFUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[GroupNotifyOperateType.KIGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[GroupNotifyOperateType.KDELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f359115b = iArr2;
            int[] iArr3 = new int[GroupNotifyMsgType.values().length];
            try {
                iArr3[GroupNotifyMsgType.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[GroupNotifyMsgType.INVITEDBYMEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[GroupNotifyMsgType.REFUSEINVITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[GroupNotifyMsgType.REFUSEDBYADMINISTRATOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[GroupNotifyMsgType.AGREEDTOJOINDIRECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[GroupNotifyMsgType.INVITEDNEEDADMINISTRATORPASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[GroupNotifyMsgType.AGREEDTOJOINBYADMINISTRATOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            f359116c = iArr3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000o\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J4\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0006H\u0016J,\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0004j\b\u0012\u0004\u0012\u00020\u0017`\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016JB\u0010$\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00042\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J<\u0010)\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\"\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"`'H\u0016\u00a8\u0006*"}, d2 = {"com/tencent/qqnt/kernel/invorker/KGroupInvorkService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "groupList", "", "onGroupListUpdate", "", "doubt", "", "nextStartSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "groupNotifys", "onGroupSingleScreenNotifies", "notifies", "onGroupNotifiesUpdated", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "onGroupDetailInfoChange", "groupCode", "", "membersUid", "onGroupConfMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListChangeInfo;", "info", "onMemberListChange", WadlProxyConsts.SCENE_ID, "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "ids", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "infos", "onSearchMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Lkotlin/collections/HashMap;", "members", "onMemberInfoChange", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
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
        public void onGroupConfMemberChange(long groupCode, @NotNull ArrayList<String> membersUid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(groupCode), membersUid);
            } else {
                Intrinsics.checkNotNullParameter(membersUid, "membersUid");
                KGroupInvorkService.this.t("onGroupConfMemberChange", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("groupCode", Long.valueOf(groupCode)), TuplesKt.to("membersUid", Integer.valueOf(membersUid.size()))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(@NotNull GroupDetailInfo groupDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) groupDetail);
            } else {
                Intrinsics.checkNotNullParameter(groupDetail, "groupDetail");
                KGroupInvorkService.this.t("onGroupDetailInfoChange", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("groupName", groupDetail.groupName), TuplesKt.to("groupCode", Long.valueOf(groupDetail.groupCode))));
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
        public void onGroupListUpdate(@NotNull GroupListUpdateType updateType, @NotNull ArrayList<GroupSimpleInfo> groupList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateType, (Object) groupList);
                return;
            }
            Intrinsics.checkNotNullParameter(updateType, "updateType");
            Intrinsics.checkNotNullParameter(groupList, "groupList");
            if (KGroupInvorkService.this.showCheckGroup) {
                KGroupInvorkService.this.t("addCheckGroup", "\u5728\u7fa4\u5217\u8868\uff1a");
                KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
                for (GroupSimpleInfo groupSimpleInfo : groupList) {
                    if (kGroupInvorkService.checkGroupList.contains(Long.valueOf(groupSimpleInfo.groupCode))) {
                        String str = groupSimpleInfo.groupName;
                        Intrinsics.checkNotNullExpressionValue(str, "it.groupName");
                        kGroupInvorkService.t(str, String.valueOf(groupSimpleInfo.groupCode));
                    }
                }
                KGroupInvorkService.this.showCheckGroup = false;
                return;
            }
            KGroupInvorkService kGroupInvorkService2 = KGroupInvorkService.this;
            kGroupInvorkService2.t("onGroupListChange", com.tencent.qqnt.kernel.internel.a.f359089a.a(kGroupInvorkService2.V(groupList)));
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
        public void onGroupNotifiesUpdated(boolean doubt, @Nullable ArrayList<GroupNotifyMsg> notifies) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(doubt), notifies);
                return;
            }
            KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            Object[] objArr = new Object[1];
            if (notifies != null) {
                str = kGroupInvorkService.W(notifies);
            } else {
                str = null;
            }
            objArr[0] = TuplesKt.to("notifies", str);
            kGroupInvorkService.t("onGroupNotifiesUpdated", aVar.b(objArr));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupSingleScreenNotifies(boolean doubt, long nextStartSeq, @Nullable ArrayList<GroupNotifyMsg> groupNotifys) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(doubt), Long.valueOf(nextStartSeq), groupNotifys);
                return;
            }
            KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            Object[] objArr = new Object[2];
            objArr[0] = TuplesKt.to("nextStartSeq", Long.valueOf(nextStartSeq));
            if (groupNotifys != null) {
                str = KGroupInvorkService.this.W(groupNotifys);
            } else {
                str = null;
            }
            objArr[1] = TuplesKt.to("msg", str);
            kGroupInvorkService.t("onGroupSingleScreenNotifies", aVar.b(objArr));
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
        public void onMemberInfoChange(long groupCode, @NotNull DataSource dataSource, @NotNull HashMap<String, MemberInfo> members) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Long.valueOf(groupCode), dataSource, members);
                return;
            }
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            Intrinsics.checkNotNullParameter(members, "members");
            KGroupInvorkService.this.t("onMemberInfoChange", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("groupCode", Long.valueOf(groupCode)), TuplesKt.to("dataSource", dataSource.name()), TuplesKt.to("members", Integer.valueOf(members.size()))));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onMemberListChange(@Nullable GroupMemberListChangeInfo info) {
            String str;
            HashMap<String, MemberInfo> hashMap;
            Collection<MemberInfo> values;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
                return;
            }
            KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            Object[] objArr = new Object[2];
            Integer num = null;
            if (info != null) {
                str = info.sceneId;
            } else {
                str = null;
            }
            objArr[0] = TuplesKt.to(WadlProxyConsts.SCENE_ID, str);
            if (info != null && (hashMap = info.infos) != null && (values = hashMap.values()) != null) {
                num = Integer.valueOf(values.size());
            }
            objArr[1] = TuplesKt.to("memberList", num);
            kGroupInvorkService.t("onMemberListChange", aVar.b(objArr));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onSearchMemberChange(@Nullable String sceneId, @Nullable String keyword, @Nullable ArrayList<GroupMemberInfoListId> ids, @Nullable HashMap<String, MemberInfo> infos) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, sceneId, keyword, ids, infos);
                return;
            }
            KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
            com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
            Object[] objArr = new Object[4];
            objArr[0] = TuplesKt.to(WadlProxyConsts.SCENE_ID, sceneId);
            objArr[1] = TuplesKt.to("keyword", keyword);
            Integer num2 = null;
            if (ids != null) {
                num = Integer.valueOf(ids.size());
            } else {
                num = null;
            }
            objArr[2] = TuplesKt.to("ids", num);
            if (infos != null) {
                num2 = Integer.valueOf(infos.size());
            }
            objArr[3] = TuplesKt.to("infos", num2);
            kGroupInvorkService.t("onSearchMemberChange", aVar.b(objArr));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            am.D(this, j3, arrayList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KGroupInvorkService(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super("\u7fa4", s.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
        } else {
            this.checkGroupList = new ArrayList();
        }
    }

    private final void I() {
        c("\u68c0\u6d4b\u662f\u5426\u5728\u7fa4\u5217\u8868\u4e2d", "\u8f93\u5165\u7fa4\u53f7\uff0c\u5982'code1 code2 ...'", new Function2<List<? extends Object>, List<? extends String>, Unit>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addCheckGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list, List<? extends String> list2) {
                invoke2(list, (List<String>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                    return;
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                KGroupInvorkService.this.checkGroupList.clear();
                KGroupInvorkService kGroupInvorkService = KGroupInvorkService.this;
                Iterator<T> it = cmds.iterator();
                while (it.hasNext()) {
                    kGroupInvorkService.checkGroupList.add(Long.valueOf(Long.parseLong((String) it.next())));
                }
                com.tencent.qqnt.kernel.api.j p16 = KGroupInvorkService.this.p();
                Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IGroupService");
                ((s) p16).getGroupList(true, null);
                KGroupInvorkService.this.showCheckGroup = true;
            }
        });
    }

    private final void J() {
        f("createGroup", "\u62c9\u4eba\u5efa\u7fa4", "\u8f93\u5165\u7fa4\u540d\u79f0\u548c\u597d\u53cbuid\u5217\u8868\uff0c\u5982'groupName uid1 uid2 ... '", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addCreateGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> list, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                if (cmds.size() < 2) {
                    return g.INSTANCE.b("may be lack of uid!");
                }
                arrayList.add(cmds.get(0));
                ArrayList arrayList2 = new ArrayList();
                int size = cmds.size();
                for (int i3 = 1; i3 < size; i3++) {
                    arrayList2.add(cmds.get(i3));
                }
                arrayList.add(arrayList2);
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void K() {
        f("getGroupAvatarUrl", "\u83b7\u53d6\u5934\u50cf", "\u8f93\u5165group code", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addGetGroupAvatarUrl$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void L() {
        f("getSingleScreenNotifies", "\u83b7\u53d6\u5355\u5c4f\u7fa4\u901a\u77e5\u5217\u8868", "\u8f93\u5165start_seq \u548c number", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addGetSingleScreenNotifies$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                arrayList.add(Integer.valueOf(Integer.parseInt(cmds.get(1))));
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void M() {
        f("inviteToGroup", "\u9080\u8bf7\u52a0\u7fa4", "\u8f93\u5165\u7fa4\u53f7\u7801\u548c\u597d\u53cbuid\u5217\u8868\uff0c\u5982'groupCode uid1 uid2 ... '", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addInviteToGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> list, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                if (cmds.size() < 2) {
                    return g.INSTANCE.b("may be lack of uid!");
                }
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                ArrayList arrayList2 = new ArrayList();
                int size = cmds.size();
                for (int i3 = 1; i3 < size; i3++) {
                    arrayList2.add(cmds.get(i3));
                }
                arrayList.add(arrayList2);
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void N() {
        f("modifyRemark", "\u8bbe\u7f6e\u7fa4\u5907\u6ce8", "\u8f93\u5165\u7fa4\u53f7\u7801\u548c\u7fa4\u5907\u6ce8", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addModifyRemark$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                if (cmds.isEmpty()) {
                    return g.INSTANCE.b("may be lack of uid!");
                }
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                arrayList.add(cmds.get(1));
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void O(g.d dVar, String str, String str2, GroupNotifyMsgType groupNotifyMsgType, GroupNotifyOperateType groupNotifyOperateType) {
        List<? extends Object> listOf;
        String str3 = str + "->" + c0(groupNotifyOperateType) + "\"" + str2 + "\"";
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Enum[]{groupNotifyMsgType, groupNotifyOperateType});
        dVar.b(str3, listOf);
    }

    private final void P(g.d dVar, String str, String str2, GroupNotifyMsgType groupNotifyMsgType, List<? extends GroupNotifyOperateType> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            O(dVar, str, str2, groupNotifyMsgType, (GroupNotifyOperateType) it.next());
        }
    }

    static /* synthetic */ void Q(KGroupInvorkService kGroupInvorkService, g.d dVar, String str, String str2, GroupNotifyMsgType groupNotifyMsgType, List list, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupNotifyOperateType[]{GroupNotifyOperateType.KAGREE, GroupNotifyOperateType.KREFUSE, GroupNotifyOperateType.KIGNORE, GroupNotifyOperateType.KDELETE});
        }
        kGroupInvorkService.P(dVar, str, str2, groupNotifyMsgType, list);
    }

    private final void R() {
        List<? extends GroupNotifyOperateType> listOf;
        List<? extends GroupNotifyOperateType> listOf2;
        List<? extends GroupNotifyOperateType> listOf3;
        List<? extends GroupNotifyOperateType> listOf4;
        g.d f16 = f("operateSysNotify", "\u5904\u7406\u7fa4\u901a\u77e5", "\u8f93\u5165\u6d88\u606fseq", new Function2<List<? extends Object>, List<? extends String>, g.a>(this) { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addOperateSysNotify$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ KGroupInvorkService $cb;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$cb = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                GroupNotifyMsg U;
                String Y;
                GroupNotifyOperateMsg X;
                String b06;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                Object obj = preParas.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType");
                U = KGroupInvorkService.this.U(Long.parseLong(cmds.get(0)), (GroupNotifyMsgType) obj);
                if (U == null) {
                    return g.INSTANCE.b("maybe no such msg seq / error seq type / error msg status!");
                }
                f o16 = KGroupInvorkService.this.o();
                Y = KGroupInvorkService.this.Y(U);
                o16.notify("", "\n" + Y);
                Object obj2 = preParas.get(1);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType");
                X = KGroupInvorkService.this.X(U, (GroupNotifyOperateType) obj2);
                f o17 = KGroupInvorkService.this.o();
                b06 = KGroupInvorkService.this.b0(X);
                o17.notify("", "\n" + b06);
                arrayList.add(X);
                arrayList.add(this.$cb);
                return g.INSTANCE.a(arrayList);
            }
        });
        Q(this, f16, "\u88ab\u9080\u8bf7\u65b9", "\u5165\u7fa4", GroupNotifyMsgType.INVITEDBYMEMBER, null, 8, null);
        GroupNotifyMsgType groupNotifyMsgType = GroupNotifyMsgType.REFUSEINVITED;
        GroupNotifyOperateType groupNotifyOperateType = GroupNotifyOperateType.KIGNORE;
        GroupNotifyOperateType groupNotifyOperateType2 = GroupNotifyOperateType.KDELETE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupNotifyOperateType[]{groupNotifyOperateType, groupNotifyOperateType2});
        P(f16, "\u9080\u8bf7\u65b9", "\u88ab\u9080\u8bf7\u65b9\u62d2\u7edd\u9080\u8bf7", groupNotifyMsgType, listOf);
        GroupNotifyMsgType groupNotifyMsgType2 = GroupNotifyMsgType.REFUSEDBYADMINISTRATOR;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupNotifyOperateType[]{groupNotifyOperateType, groupNotifyOperateType2});
        P(f16, "\u7533\u8bf7\u65b9", "\u7ba1\u7406\u5458\u62d2\u7edd\u52a0\u7fa4\u7533\u8bf7", groupNotifyMsgType2, listOf2);
        GroupNotifyMsgType groupNotifyMsgType3 = GroupNotifyMsgType.AGREEDTOJOINDIRECT;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupNotifyOperateType[]{groupNotifyOperateType, groupNotifyOperateType2});
        P(f16, "\u9080\u8bf7\u65b9", "\u88ab\u9080\u8bf7\u65b9\u540c\u610f\u9080\u8bf7\uff0c\u76f4\u63a5\u5165\u7fa4", groupNotifyMsgType3, listOf3);
        Q(this, f16, "\u7ba1\u7406\u5458", "\u88ab\u9080\u8bf7\u65b9\u540c\u610f\u9080\u8bf7\uff0c\u9700\u8981\u7ba1\u7406\u5458\u5ba1\u6279", GroupNotifyMsgType.INVITEDNEEDADMINISTRATORPASS, null, 8, null);
        GroupNotifyMsgType groupNotifyMsgType4 = GroupNotifyMsgType.AGREEDTOJOINBYADMINISTRATOR;
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupNotifyOperateType[]{groupNotifyOperateType, groupNotifyOperateType2});
        P(f16, "\u7533\u8bf7\u65b9", "\u7ba1\u7406\u5458\u540c\u610f\u52a0\u7fa4\u7533\u8bf7", groupNotifyMsgType4, listOf4);
    }

    private final void S() {
        f("quitGroup", "\u9000\u7fa4", "\u8f93\u5165\u7fa4\u53f7", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addQuitGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> list, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
    }

    private final void T() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        g.d f16 = f("setTop", "\u7f6e\u9876", "\u8f93\u5165\u7fa4\u53f7\u7801", new Function2<List<? extends Object>, List<? extends String>, g.a>() { // from class: com.tencent.qqnt.kernel.invorker.KGroupInvorkService$addSetTop$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KGroupInvorkService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ g.a invoke(List<? extends Object> list, List<? extends String> list2) {
                return invoke2(list, (List<String>) list2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final g.a invoke2(@NotNull List<? extends Object> preParas, @NotNull List<String> cmds) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (g.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preParas, (Object) cmds);
                }
                Intrinsics.checkNotNullParameter(preParas, "preParas");
                Intrinsics.checkNotNullParameter(cmds, "cmds");
                ArrayList arrayList = new ArrayList();
                if (cmds.isEmpty()) {
                    return g.INSTANCE.b("may be lack of uid!");
                }
                arrayList.add(Long.valueOf(Long.parseLong(cmds.get(0))));
                Object obj = preParas.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                arrayList.add(Boolean.valueOf(((Boolean) obj).booleanValue()));
                arrayList.add(KGroupInvorkService.this);
                return g.INSTANCE.a(arrayList);
            }
        });
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boolean.TRUE);
        f16.b("\u8bbe\u7f6e", listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Boolean.FALSE);
        f16.b("\u53d6\u6d88", listOf2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupNotifyMsg U(long msgSeq, GroupNotifyMsgType type) {
        List<GroupNotifyMsg> list = this.notifyMsgs;
        if (list != null) {
            for (GroupNotifyMsg groupNotifyMsg : list) {
                if (groupNotifyMsg.seq == msgSeq && groupNotifyMsg.type == type) {
                    return groupNotifyMsg;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> V(ArrayList<GroupSimpleInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("size(" + arrayList.size() + ")\n");
        for (GroupSimpleInfo groupSimpleInfo : arrayList) {
            arrayList2.add(com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("code", Long.valueOf(groupSimpleInfo.groupCode)), TuplesKt.to("name", groupSimpleInfo.groupName)) + "\n\n");
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String W(ArrayList<GroupNotifyMsg> arrayList) {
        String str = ("size(" + arrayList.size() + ")\n") + d0(arrayList, GroupNotifyMsgStatus.KINIT) + d0(arrayList, GroupNotifyMsgStatus.KUNHANDLE) + d0(arrayList, GroupNotifyMsgStatus.KAGREED) + d0(arrayList, GroupNotifyMsgStatus.KREFUSED) + d0(arrayList, GroupNotifyMsgStatus.KIGNORED);
        Intrinsics.checkNotNullExpressionValue(str, "msg.toString()");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupNotifyOperateMsg X(GroupNotifyMsg groupNotifyMsg, GroupNotifyOperateType groupNotifyOperateType) {
        GroupNotifyOperateMsg groupNotifyOperateMsg = new GroupNotifyOperateMsg();
        groupNotifyOperateMsg.operateType = groupNotifyOperateType;
        GroupNotifyTargetMsg groupNotifyTargetMsg = new GroupNotifyTargetMsg();
        groupNotifyTargetMsg.seq = groupNotifyMsg.seq;
        groupNotifyTargetMsg.type = groupNotifyMsg.type;
        groupNotifyTargetMsg.groupCode = groupNotifyMsg.group.groupCode;
        groupNotifyTargetMsg.postscript = groupNotifyMsg.postscript;
        groupNotifyOperateMsg.targetMsg = groupNotifyTargetMsg;
        return groupNotifyOperateMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Y(GroupNotifyMsg groupNotifyMsg) {
        com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
        GroupNotifyGroup groupNotifyGroup = groupNotifyMsg.group;
        return aVar.b(TuplesKt.to("seq", Long.valueOf(groupNotifyMsg.seq)), TuplesKt.to("msg type", groupNotifyMsg.type), TuplesKt.to(VipFunCallConstants.KEY_GROUP, groupNotifyGroup.groupName + "(" + groupNotifyGroup.groupCode + ")"), TuplesKt.to("user1", groupNotifyMsg.user1.nickName), TuplesKt.to("user2", groupNotifyMsg.user2.nickName), TuplesKt.to("actionUser", groupNotifyMsg.actionUser.nickName));
    }

    private final String Z(GroupNotifyMsgStatus groupNotifyMsgStatus) {
        int i3 = a.f359114a[groupNotifyMsgStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "\u521d\u59cb ";
                        }
                        return "\u5df2\u5ffd\u7565";
                    }
                    return "\u5df2\u62d2\u7edd";
                }
                return "\u5df2\u540c\u610f";
            }
            return "\u672a\u5904\u7406";
        }
        return "\u521d\u59cb";
    }

    private final String a0(GroupNotifyMsgType groupNotifyMsgType) {
        switch (a.f359116c[groupNotifyMsgType.ordinal()]) {
            case 1:
                return "\u65e0\u6548\u7c7b\u578b";
            case 2:
                return "\u88ab\u9080\u8bf7\u65b9<-\u88ab\u7fa4\u6210\u5458\u9080\u8bf7\u5165\u7fa4";
            case 3:
                return "\u9080\u8bf7\u65b9<-\u88ab\u9080\u8bf7\u65b9\u62d2\u7edd\u9080\u8bf7";
            case 4:
                return "\u7533\u8bf7\u65b9<-\u7ba1\u7406\u5458\u62d2\u7edd\u52a0\u7fa4\u7533\u8bf7";
            case 5:
                return "\u9080\u8bf7\u65b9<-\u88ab\u9080\u8bf7\u65b9\u540c\u610f\u9080\u8bf7\uff0c\u76f4\u63a5\u5165\u7fa4";
            case 6:
                return "\u7ba1\u7406\u5458<-\u88ab\u9080\u8bf7\u65b9\u540c\u610f\u9080\u8bf7\uff0c\u9700\u8981\u7ba1\u7406\u5458\u5ba1\u6279";
            case 7:
                return "\u7533\u8bf7\u65b9<-\u7ba1\u7406\u5458\u540c\u610f\u52a0\u7fa4\u7533\u8bf7";
            default:
                return "\u65e0\u6548\u7c7b\u578b ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b0(GroupNotifyOperateMsg groupNotifyOperateMsg) {
        com.tencent.qqnt.kernel.internel.a aVar = com.tencent.qqnt.kernel.internel.a.f359089a;
        GroupNotifyMsgType groupNotifyMsgType = groupNotifyOperateMsg.targetMsg.type;
        Intrinsics.checkNotNullExpressionValue(groupNotifyMsgType, "targetMsg.type");
        return aVar.b(TuplesKt.to("operateType", groupNotifyOperateMsg.operateType), TuplesKt.to("seq", Long.valueOf(groupNotifyOperateMsg.targetMsg.seq)), TuplesKt.to(QQBrowserActivity.KEY_MSG_TYPE, a0(groupNotifyMsgType)), TuplesKt.to("groupCode", Long.valueOf(groupNotifyOperateMsg.targetMsg.groupCode)), TuplesKt.to("postscript", groupNotifyOperateMsg.targetMsg.postscript));
    }

    private final String c0(GroupNotifyOperateType groupNotifyOperateType) {
        int i3 = a.f359115b[groupNotifyOperateType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "\u65e0\u6548\u7c7b\u578b";
                    }
                    return "\u5220\u9664";
                }
                return "\u5ffd\u7565";
            }
            return "\u62d2\u7edd";
        }
        return "\u540c\u610f";
    }

    private final String d0(ArrayList<GroupNotifyMsg> arrayList, GroupNotifyMsgStatus groupNotifyMsgStatus) {
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (GroupNotifyMsg groupNotifyMsg : arrayList) {
            if (groupNotifyMsg.status == groupNotifyMsgStatus) {
                arrayList2.add(groupNotifyMsg);
                i3++;
            }
        }
        if (arrayList2.isEmpty()) {
            return "";
        }
        sb5.append(e0(arrayList2, GroupNotifyMsgType.UNSPECIFIED));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.INVITEDBYMEMBER));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.REFUSEINVITED));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.REFUSEDBYADMINISTRATOR));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.AGREEDTOJOINDIRECT));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.INVITEDNEEDADMINISTRATORPASS));
        sb5.append(e0(arrayList2, GroupNotifyMsgType.AGREEDTOJOINBYADMINISTRATOR));
        return "--------" + Z(groupNotifyMsgStatus) + "(" + i3 + ")--------\n" + ((Object) sb5) + "\n";
    }

    private final String e0(List<GroupNotifyMsg> list, GroupNotifyMsgType groupNotifyMsgType) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        int i3 = 0;
        for (GroupNotifyMsg groupNotifyMsg : list) {
            if (groupNotifyMsg.type == groupNotifyMsgType) {
                sb5.append(Y(groupNotifyMsg) + "\n\n");
                i3++;
            }
        }
        if (sb5.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        return "--------" + a0(groupNotifyMsgType) + "(" + i3 + ")--------\n" + ((Object) sb5) + "\n";
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.listener = new b();
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IGroupService");
        s sVar = (s) p16;
        IKernelGroupListener iKernelGroupListener = this.listener;
        if (iKernelGroupListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelGroupListener = null;
        }
        sVar.D(iKernelGroupListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        List<? extends Object> listOf;
        List<? extends Object> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        g.d e16 = e("getGroupList", "\u83b7\u53d6\u7fa4\u5217\u8868");
        listOf = CollectionsKt__CollectionsKt.listOf(Boolean.TRUE, this);
        e16.b("\u5f3a\u5237", listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf(Boolean.FALSE, this);
        e16.b("\u975e\u5f3a\u5237", listOf2);
        I();
        J();
        S();
        M();
        L();
        R();
        K();
        T();
        N();
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IGroupService");
        s sVar = (s) p16;
        IKernelGroupListener iKernelGroupListener = this.listener;
        if (iKernelGroupListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelGroupListener = null;
        }
        sVar.x0(iKernelGroupListener);
    }
}
