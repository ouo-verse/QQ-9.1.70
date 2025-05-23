package com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import az1.EmptyPageData;
import az1.GroupChatShowData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.a;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
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
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ao;
import wh2.ce;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002GHB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0018\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0013\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0014J\u0006\u0010\u001c\u001a\u00020\u0003J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0017\u0010\"\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010.\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R \u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00100/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u0004\u0018\u00010=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u001d\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00100A8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/theme/d;", "", "U1", "j2", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i2", "e2", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel$a;", "X1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "groupCodes", "", "Laz1/c;", "Z1", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g2", "W1", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "f2", "", "account", "onAccountChanged", "onCleared", SemanticAttributes.DbSystemValues.H2, "onThemeChanged", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/util/cn;", "", "D", "Lcom/tencent/mobileqq/guild/util/cn;", "c2", "()Lcom/tencent/mobileqq/guild/util/cn;", HippyReporter.RemoveEngineReason.THEME_CHANGED, "E", "Z", "d2", "()Z", "isCreator", "Landroidx/lifecycle/MutableLiveData;", "Laz1/a;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_dataList", "G", "Ljava/util/List;", "boundGroupList", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "groupListener", "I", "J", "lastRefreshTime", "Lcom/tencent/qqnt/kernel/api/s;", "b2", "()Lcom/tencent/qqnt/kernel/api/s;", "groupService", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/LiveData;", "dataList", "<init>", "(Ljava/lang/String;)V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGroupChatShowViewModel extends b implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> themeChanged;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isCreator;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<az1.a>> _dataList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<GroupChatShowData> boundGroupList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IKernelGroupListener groupListener;

    /* renamed from: I, reason: from kotlin metadata */
    private long lastRefreshTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel$b;", "", "", "b", "", "BOUND_GROUP_PAGE_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long b() {
            return System.nanoTime() / 1000000;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMemberGetBoundGroupRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMemberGetBoundGroupRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ce {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<BoundGroupsResult> f233458a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildGroupChatShowViewModel f233459b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super BoundGroupsResult> cancellableContinuation, GuildGroupChatShowViewModel guildGroupChatShowViewModel) {
            this.f233458a = cancellableContinuation;
            this.f233459b = guildGroupChatShowViewModel;
        }

        @Override // wh2.ce
        public final void a(int i3, String str, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
            int collectionSizeOrDefault;
            Set set;
            List emptyList;
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "fetchBoundGroupsFirstPage failed: " + i3 + "-" + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.NewHome.GuildGroupChatShowViewModel", 1, (String) it.next(), null);
                }
                CancellableContinuation<BoundGroupsResult> cancellableContinuation = this.f233458a;
                Result.Companion companion = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new BoundGroupsResult(false, emptyList, null, 4, null)));
                return;
            }
            ArrayList<IGProBindingGroup> bindingGroupList = iGProMemberGetBoundGroupRsp.getBindingGroupList();
            Intrinsics.checkNotNullExpressionValue(bindingGroupList, "rsp.bindingGroupList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(bindingGroupList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = bindingGroupList.iterator();
            while (it5.hasNext()) {
                arrayList.add(Long.valueOf(((IGProBindingGroup) it5.next()).getGroupCode()));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            ArrayList<Long> allBindGroupCodeList = iGProMemberGetBoundGroupRsp.getAllBindGroupCodeList();
            Intrinsics.checkNotNullExpressionValue(allBindGroupCodeList, "rsp.allBindGroupCodeList");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allBindGroupCodeList) {
                if (!set.contains((Long) obj)) {
                    arrayList2.add(obj);
                }
            }
            a.Companion companion2 = a.INSTANCE;
            ArrayList<IGProBindingGroup> bindingGroupList2 = iGProMemberGetBoundGroupRsp.getBindingGroupList();
            Intrinsics.checkNotNullExpressionValue(bindingGroupList2, "rsp.bindingGroupList");
            List<GroupChatShowData> a16 = companion2.a(bindingGroupList2, this.f233459b.getIsCreator());
            CancellableContinuation<BoundGroupsResult> cancellableContinuation2 = this.f233458a;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new BoundGroupsResult(true, a16, arrayList2)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel$d", "Lwh2/ao;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "boundGroups", "", "onFetchGuildBoundGroupsWithGroupCodes", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ao {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<GroupChatShowData>> f233460a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildGroupChatShowViewModel f233461b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList<Long> f233462c;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super List<GroupChatShowData>> continuation, GuildGroupChatShowViewModel guildGroupChatShowViewModel, ArrayList<Long> arrayList) {
            this.f233460a = continuation;
            this.f233461b = guildGroupChatShowViewModel;
            this.f233462c = arrayList;
        }

        @Override // wh2.ao
        public void onFetchGuildBoundGroupsWithGroupCodes(int result, @Nullable String errMsg, @Nullable ArrayList<IGProBindingGroup> boundGroups) {
            List emptyList;
            boolean z16;
            if (result == 0) {
                if (boundGroups != null && !boundGroups.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    this.f233460a.resumeWith(Result.m476constructorimpl(a.INSTANCE.a(boundGroups, this.f233461b.getIsCreator())));
                    Logger logger = Logger.f235387a;
                    ArrayList<Long> arrayList = this.f233462c;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.NewHome.GuildGroupChatShowViewModel", 2, "fetchRemainBoundGroups success " + arrayList + ", boundRemainGroupsSize:" + boundGroups.size());
                        return;
                    }
                    return;
                }
            }
            Continuation<List<GroupChatShowData>> continuation = this.f233460a;
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            continuation.resumeWith(Result.m476constructorimpl(emptyList));
            Logger logger2 = Logger.f235387a;
            ArrayList<Long> arrayList2 = this.f233462c;
            Logger.b bVar = new Logger.b();
            String str = "fetchRemainBoundGroups error " + arrayList2 + ", result:" + result + ", errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.GuildGroupChatShowViewModel", 1, (String) it.next(), null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel$e", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MemberRole;", "memberRole", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "groupList", "", "onGroupListUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements IKernelGroupListener {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f233464a;

            static {
                int[] iArr = new int[GroupListUpdateType.values().length];
                try {
                    iArr[GroupListUpdateType.REMOVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GroupListUpdateType.MODIFIED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f233464a = iArr;
            }
        }

        e() {
        }

        private final boolean a(MemberRole memberRole) {
            if (memberRole != MemberRole.MEMBER && memberRole != MemberRole.ADMIN && memberRole != MemberRole.OWNER) {
                return false;
            }
            return true;
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
        public void onGroupListUpdate(@NotNull GroupListUpdateType updateType, @NotNull ArrayList<GroupSimpleInfo> groupList) {
            int collectionSizeOrDefault;
            Set set;
            int collectionSizeOrDefault2;
            Set set2;
            boolean z16;
            Intrinsics.checkNotNullParameter(updateType, "updateType");
            Intrinsics.checkNotNullParameter(groupList, "groupList");
            int i3 = a.f233464a[updateType.ordinal()];
            boolean z17 = false;
            if (i3 == 1) {
                List list = GuildGroupChatShowViewModel.this.boundGroupList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((GroupChatShowData) obj).getIsGroupMember()) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((GroupChatShowData) it.next()).getGroupCode()));
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList2);
                if (!(groupList instanceof Collection) || !groupList.isEmpty()) {
                    Iterator<T> it5 = groupList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            if (set.contains(Long.valueOf(((GroupSimpleInfo) it5.next()).groupCode))) {
                                z17 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z17) {
                    GuildGroupChatShowViewModel.this.h2();
                    return;
                }
                return;
            }
            if (i3 == 2) {
                List list2 = GuildGroupChatShowViewModel.this.boundGroupList;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list2) {
                    if (!((GroupChatShowData) obj2).getIsGroupMember()) {
                        arrayList3.add(obj2);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    arrayList4.add(Long.valueOf(((GroupChatShowData) it6.next()).getGroupCode()));
                }
                set2 = CollectionsKt___CollectionsKt.toSet(arrayList4);
                if (!(groupList instanceof Collection) || !groupList.isEmpty()) {
                    Iterator<T> it7 = groupList.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            break;
                        }
                        GroupSimpleInfo groupSimpleInfo = (GroupSimpleInfo) it7.next();
                        MemberRole memberRole = groupSimpleInfo.memberRole;
                        Intrinsics.checkNotNullExpressionValue(memberRole, "it.memberRole");
                        if (a(memberRole) && set2.contains(Long.valueOf(groupSimpleInfo.groupCode))) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                if (z17) {
                    GuildGroupChatShowViewModel.this.h2();
                }
            }
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

    public GuildGroupChatShowViewModel(@NotNull String guildId) {
        List<GroupChatShowData> emptyList;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.themeChanged = new cn<>();
        this.isCreator = ch.n0(guildId);
        this._dataList = new MutableLiveData<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.boundGroupList = emptyList;
        this.groupListener = f2();
        this.lastRefreshTime = INSTANCE.b();
        U1();
        e2();
        GuildThemeManager.g(this);
    }

    private final void U1() {
        s b26 = b2();
        if (b26 != null) {
            b26.D(this.groupListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b W1() {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.GuildGroupChatShowViewModel fetchAllBoundGroups", Boolean.FALSE, null, Boolean.TRUE, new GuildGroupChatShowViewModel$fetchAllBoundGroups$1(this, null), 4, null);
        Intrinsics.checkNotNull(e16);
        Job a16 = e16.a();
        Intrinsics.checkNotNull(a16);
        a16.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel$fetchAllBoundGroups$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("Guild.NewHome.GuildGroupChatShowViewModel", 1, "fetchAllBoundGroups completed");
            }
        });
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X1(Continuation<? super BoundGroupsResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getGuildBoundGroupsFirstPage(getGuildId(), 50, new c(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z1(ArrayList<Long> arrayList, Continuation<? super List<GroupChatShowData>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildBoundGroupsWithGroupCodes(this.guildId, arrayList, new d(safeContinuation, this, arrayList));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final s b2() {
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IKernelService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IKernelService.class.getSimpleName() + ") calling...";
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return ((IKernelService) runtimeServiceHolder.b("", IKernelService.class)).getGroupService();
    }

    private final void e2() {
        List<az1.a> listOf;
        MutableLiveData<List<az1.a>> mutableLiveData = this._dataList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new az1.e());
        mutableLiveData.setValue(listOf);
    }

    private final IKernelGroupListener f2() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        List<az1.a> listOf;
        Logger.f235387a.d().i("Guild.NewHome.GuildGroupChatShowViewModel", 1, "notifyDataListChanged: dataSize=" + this.boundGroupList.size());
        if (this.boundGroupList.isEmpty()) {
            MutableLiveData<List<az1.a>> mutableLiveData = this._dataList;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmptyPageData(8, "\u6682\u672a\u6dfb\u52a0\u7fa4\u804a"));
            mutableLiveData.setValue(listOf);
            return;
        }
        this._dataList.setValue(this.boundGroupList);
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b i2() {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.GuildGroupChatShowViewModel refresh", null, null, Boolean.TRUE, new GuildGroupChatShowViewModel$refreshGroupChatList$1(this, null), 6, null);
        Intrinsics.checkNotNull(e16);
        Job a16 = e16.a();
        Intrinsics.checkNotNull(a16);
        a16.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel$refreshGroupChatList$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("Guild.NewHome.GuildGroupChatShowViewModel", 1, "refresh completed");
            }
        });
        return e16;
    }

    private final void j2() {
        s b26 = b2();
        if (b26 != null) {
            b26.x0(this.groupListener);
        }
    }

    @NotNull
    public final LiveData<List<az1.a>> a2() {
        return this._dataList;
    }

    @NotNull
    public final cn<Boolean> c2() {
        return this.themeChanged;
    }

    /* renamed from: d2, reason: from getter */
    public final boolean getIsCreator() {
        return this.isCreator;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final void h2() {
        i2();
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("Guild.NewHome.GuildGroupChatShowViewModel", 1, "onAccountChanged: " + account);
        j2();
        super.onAccountChanged(account);
        U1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        j2();
        GuildThemeManager.j(this);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        this.themeChanged.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/viewmodel/GuildGroupChatShowViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "loadSuccess", "", "Laz1/c;", "Ljava/util/List;", "()Ljava/util/List;", "boundGroupList", "", "c", "remainGroupCodes", "<init>", "(ZLjava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class BoundGroupsResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean loadSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<GroupChatShowData> boundGroupList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Long> remainGroupCodes;

        public BoundGroupsResult(boolean z16, @NotNull List<GroupChatShowData> boundGroupList, @NotNull List<Long> remainGroupCodes) {
            Intrinsics.checkNotNullParameter(boundGroupList, "boundGroupList");
            Intrinsics.checkNotNullParameter(remainGroupCodes, "remainGroupCodes");
            this.loadSuccess = z16;
            this.boundGroupList = boundGroupList;
            this.remainGroupCodes = remainGroupCodes;
        }

        @NotNull
        public final List<GroupChatShowData> a() {
            return this.boundGroupList;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getLoadSuccess() {
            return this.loadSuccess;
        }

        @NotNull
        public final List<Long> c() {
            return this.remainGroupCodes;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoundGroupsResult)) {
                return false;
            }
            BoundGroupsResult boundGroupsResult = (BoundGroupsResult) other;
            if (this.loadSuccess == boundGroupsResult.loadSuccess && Intrinsics.areEqual(this.boundGroupList, boundGroupsResult.boundGroupList) && Intrinsics.areEqual(this.remainGroupCodes, boundGroupsResult.remainGroupCodes)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.loadSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.boundGroupList.hashCode()) * 31) + this.remainGroupCodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "BoundGroupsResult(loadSuccess=" + this.loadSuccess + ", boundGroupList=" + this.boundGroupList + ", remainGroupCodes=" + this.remainGroupCodes + ")";
        }

        public /* synthetic */ BoundGroupsResult(boolean z16, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, list, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
        }
    }
}
