package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "k", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "memberInfoCache", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility$b;", "groupListener", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NickNameAbility extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, MemberInfo> memberInfoCache;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b groupListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.NickNameAbility$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tH\u0016R%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "", "onMemberInfoChange", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getWeak", "()Ljava/lang/ref/WeakReference;", "weak", "self", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/msgrepo/NickNameAbility;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class b implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<NickNameAbility> weak;

        public b(@NotNull NickNameAbility self) {
            Intrinsics.checkNotNullParameter(self, "self");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) self);
            } else {
                this.weak = new WeakReference<>(self);
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

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
            am.j(this, groupDetailInfo);
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
        public void onMemberInfoChange(long groupCode, @NotNull DataSource dataSource, @NotNull HashMap<String, MemberInfo> members) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(groupCode), dataSource, members);
                return;
            }
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            Intrinsics.checkNotNullParameter(members, "members");
            NickNameAbility nickNameAbility = this.weak.get();
            if (nickNameAbility != null) {
                nickNameAbility.s(groupCode, dataSource, members);
            }
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickNameAbility(@NotNull BaseMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        } else {
            this.memberInfoCache = new ConcurrentHashMap<>();
            this.groupListener = new b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOMsgItem q(AIOMsgItem msgItem) {
        if (!Intrinsics.areEqual(msgItem.v0().toString(), com.tencent.mobileqq.aio.utils.d.i(msgItem).toString())) {
            AIOMsgItem cloneNewInstance = msgItem.cloneNewInstance();
            cloneNewInstance.W1(com.tencent.mobileqq.aio.utils.d.i(cloneNewInstance));
            com.tencent.qqnt.aio.nick.j jVar = com.tencent.qqnt.aio.nick.j.f351725a;
            if (jVar.d(cloneNewInstance)) {
                cloneNewInstance.H1(jVar.b(cloneNewInstance.v0()));
                return cloneNewInstance;
            }
            return cloneNewInstance;
        }
        return null;
    }

    private final void r() {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new NickNameAbility$handleMemberInfoChange$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(long groupCode, DataSource dataSource, HashMap<String, MemberInfo> members) {
        String str;
        if (!Intrinsics.areEqual(String.valueOf(groupCode), d().g().r().c().j())) {
            return;
        }
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, MemberInfo>> it = members.entrySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, MemberInfo> next = it.next();
            MemberInfo memberInfo = this.memberInfoCache.get(next.getKey());
            if (memberInfo != null) {
                Intrinsics.checkNotNullExpressionValue(memberInfo, "memberInfoCache[it.key]");
                str = com.tencent.mobileqq.aio.utils.d.k(memberInfo, false, 1, null);
            } else {
                str = null;
            }
            if (str != null && str.equals(String.valueOf(com.tencent.mobileqq.aio.utils.d.k(next.getValue(), false, 1, null)))) {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap != null) {
            hashMap.putAll(linkedHashMap);
        }
        this.memberInfoCache.putAll(members);
        if (hashMap.size() > 0) {
            r();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        List list;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItemList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        if (d().g().r().c().e() != 2) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (com.tencent.aio.data.msglist.a aVar : msgItemList) {
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                String str = aIOMsgItem.getMsgRecord().senderUid;
                MemberInfo memberInfo = this.memberInfoCache.get(str);
                if (memberInfo == null && !TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
                aIOMsgItem.t1(memberInfo);
            }
        }
        ArrayList arrayList = new ArrayList();
        list = CollectionsKt___CollectionsKt.toList(hashSet);
        arrayList.addAll(list);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(d().g().r().c().j());
        if ((!arrayList.isEmpty()) && longOrNull != null) {
            BuildersKt__Builders_commonKt.launch$default(f(), Dispatchers.getIO(), null, new NickNameAbility$doInjectBusinessData$2(longOrNull, arrayList, null), 2, null);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.j();
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.D(this.groupListener);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.k();
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.x0(this.groupListener);
        }
    }
}
