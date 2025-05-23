package com.tencent.mobileqq.guild.setting.member.selector;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleToMemberListModel;
import com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ec;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002YZB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0019\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0014J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003R\u0017\u0010\"\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00100\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00050\u00050*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,R \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010,R\"\u00104\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00150\u00150*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010,R\"\u00106\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00150\u00150*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00105R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020$0F8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050F8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010HR\u001d\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0F8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010HR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050F8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010HR\u001d\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0F8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010HR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00150F8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010HR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00150F8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010H\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$b;", "", SemanticAttributes.DbSystemValues.H2, "", "isSearchMode", "T1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "users", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "W1", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "listModel", "U1", "X1", "Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$PullStep;", "step", "", "totalMemberNum", "h1", "onCleared", "", "keyWord", "j2", "g2", FeedManager.LOAD_MORE, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "D", "Lcom/tencent/mobileqq/guild/util/cn;", "_toastEvent", "E", "_loadMoreFinishEvent", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_memberListLiveData", "kotlin.jvm.PlatformType", "G", "_isSearchModeLiveData", "H", "_searchResultLiveData", "I", "_loadStateLiveData", "J", "_searchLoadStateLiveData", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller;", "K", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller;", "mMemberPuller", "Lkotlinx/coroutines/flow/MutableStateFlow;", "L", "Lkotlinx/coroutines/flow/MutableStateFlow;", "searchKeyFlow", "Lkotlinx/coroutines/Job;", "M", "Lkotlinx/coroutines/Job;", "collectJob", "", "N", "nextPos", "Landroidx/lifecycle/LiveData;", "getToastEvent", "()Landroidx/lifecycle/LiveData;", "toastEvent", ICustomDataEditor.STRING_ARRAY_PARAM_2, "loadMoreFinishEvent", "c2", "memberListLiveData", "f2", "isSearchModeLiveData", "e2", "searchResultLiveData", "b2", "loadStateLiveData", "d2", "searchLoadStateLiveData", "<init>", "(Ljava/lang/String;)V", "P", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberSelectorViewModel extends ef1.b implements GuildMemberPuller.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> _toastEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _loadMoreFinishEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a>> _memberListLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isSearchModeLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a>> _searchResultLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _loadStateLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _searchLoadStateLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GuildMemberPuller mMemberPuller;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<String> searchKeyFlow;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Job collectJob;

    /* renamed from: N, reason: from kotlin metadata */
    private long nextPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorViewModel$b;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        private static int f234657b;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        private static int f234658c = 1;

        /* renamed from: d, reason: collision with root package name */
        private static int f234659d = 2;

        /* renamed from: e, reason: collision with root package name */
        private static int f234660e = 3;

        /* renamed from: f, reason: collision with root package name */
        private static int f234661f = 4;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorViewModel$b$a;", "", "", "IDLE", "I", "c", "()I", "setIDLE", "(I)V", "LOADING", "d", "setLOADING", "HAS_MORE", "b", "setHAS_MORE", QzoneDataUpdateAction.LOAD_MORE, "e", "setLOAD_MORE", "END", "a", "setEND", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorViewModel$b$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f234661f;
            }

            public final int b() {
                return b.f234659d;
            }

            public final int c() {
                return b.f234657b;
            }

            public final int d() {
                return b.f234658c;
            }

            public final int e() {
                return b.f234660e;
            }

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f234662a;

        static {
            int[] iArr = new int[GuildMemberPuller.PullStep.values().length];
            try {
                iArr[GuildMemberPuller.PullStep.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildMemberPuller.PullStep.HAS_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildMemberPuller.PullStep.PULL_ENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f234662a = iArr;
        }
    }

    public GuildMemberSelectorViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._toastEvent = new cn<>();
        this._loadMoreFinishEvent = new cn<>();
        this._memberListLiveData = new MutableLiveData<>();
        this._isSearchModeLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._searchResultLiveData = new MutableLiveData<>();
        b.Companion companion = b.INSTANCE;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(Integer.valueOf(companion.c()));
        this._loadStateLiveData = mutableLiveData;
        this._searchLoadStateLiveData = new MutableLiveData<>(Integer.valueOf(companion.c()));
        this.searchKeyFlow = StateFlowKt.MutableStateFlow("");
        mutableLiveData.setValue(Integer.valueOf(companion.d()));
        GuildMemberPuller guildMemberPuller = new GuildMemberPuller(guildId, "", new WeakReference(this));
        this.mMemberPuller = guildMemberPuller;
        guildMemberPuller.h();
        GuildMemberPuller.g(guildMemberPuller, false, 1, null);
        X1();
    }

    private final void T1(boolean isSearchMode) {
        List<a> emptyList;
        if (!Intrinsics.areEqual(this._isSearchModeLiveData.getValue(), Boolean.valueOf(isSearchMode))) {
            this._isSearchModeLiveData.setValue(Boolean.valueOf(isSearchMode));
            if (isSearchMode) {
                Job job = this.collectJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.collectJob = FlowKt.launchIn(FlowKt.onEach(FlowKt.debounce(this.searchKeyFlow, 300L), new GuildMemberSelectorViewModel$changeSearchModeIfNeed$1(this, null)), ViewModelKt.getViewModelScope(this));
                return;
            }
            MutableLiveData<List<a>> mutableLiveData = this._searchResultLiveData;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.setValue(emptyList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<a> U1(RoleToMemberListModel listModel) {
        int i3;
        String name;
        int color;
        int i16;
        boolean z16;
        boolean z17;
        IGProClientIdentityInfo clientIdentity;
        String str;
        GuildMemberSelectorViewModel guildMemberSelectorViewModel = this;
        ArrayList arrayList = new ArrayList();
        RoleGroupModel roleGroupModel = listModel.h().get("2");
        if (roleGroupModel != null) {
            i3 = roleGroupModel.getColor();
        } else {
            i3 = 0;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.mobileqq.guild.rolegroup.model.data.f fVar : listModel.g().values()) {
            arrayList2.clear();
            for (IGProUserInfo iGProUserInfo : fVar.d()) {
                if (!linkedHashSet.contains(iGProUserInfo.getTinyId())) {
                    String tinyId = iGProUserInfo.getTinyId();
                    Intrinsics.checkNotNullExpressionValue(tinyId, "gProUser.tinyId");
                    linkedHashSet.add(tinyId);
                    if (iGProUserInfo.getRoleManagementTag() != null && iGProUserInfo.getRoleManagementTag().getColor() != 0) {
                        color = GuildUIUtils.f235378a.g(iGProUserInfo.getRoleManagementTag().getColor());
                    } else if (fVar.getRole().getRoleType() == 3 && iGProUserInfo.getUserType() == 1) {
                        i16 = i3;
                        String str2 = guildMemberSelectorViewModel.guildId;
                        String tinyId2 = iGProUserInfo.getTinyId();
                        Intrinsics.checkNotNullExpressionValue(tinyId2, "gProUser.tinyId");
                        int userType = iGProUserInfo.getUserType();
                        String d06 = ch.d0(iGProUserInfo);
                        Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(gProUser)");
                        if (iGProUserInfo.getUserOnlineState() != 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (iGProUserInfo.getRobotType() != 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        byte[] vasPlateData = iGProUserInfo.getVasPlateData();
                        String url = iGProUserInfo.getPersonalMedal().getUrl();
                        IGProIdentityInfo b16 = GuildClientIdentityView.INSTANCE.b(iGProUserInfo);
                        clientIdentity = iGProUserInfo.getClientIdentity();
                        if (clientIdentity == null) {
                            str = clientIdentity.getDesc();
                        } else {
                            str = null;
                        }
                        String str3 = str;
                        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
                        IRuntimeService S0 = ch.S0(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
                        arrayList2.add(new MemberData(str2, tinyId2, userType, d06, i16, z16, z17, vasPlateData, url, b16, str3, ((IGPSService) S0).getMemberLevelRole(guildMemberSelectorViewModel.guildId, iGProUserInfo.getTinyId(), String.valueOf(iGProUserInfo.getLevelRoleId())), iGProUserInfo.getRoleManagementTag()));
                    } else {
                        color = fVar.getRole().getColor();
                    }
                    i16 = color;
                    String str22 = guildMemberSelectorViewModel.guildId;
                    String tinyId22 = iGProUserInfo.getTinyId();
                    Intrinsics.checkNotNullExpressionValue(tinyId22, "gProUser.tinyId");
                    int userType2 = iGProUserInfo.getUserType();
                    String d062 = ch.d0(iGProUserInfo);
                    Intrinsics.checkNotNullExpressionValue(d062, "getUserShowName(gProUser)");
                    if (iGProUserInfo.getUserOnlineState() != 1) {
                    }
                    if (iGProUserInfo.getRobotType() != 1) {
                    }
                    byte[] vasPlateData2 = iGProUserInfo.getVasPlateData();
                    String url2 = iGProUserInfo.getPersonalMedal().getUrl();
                    IGProIdentityInfo b162 = GuildClientIdentityView.INSTANCE.b(iGProUserInfo);
                    clientIdentity = iGProUserInfo.getClientIdentity();
                    if (clientIdentity == null) {
                    }
                    String str32 = str;
                    com.tencent.mobileqq.guild.base.extension.r rVar2 = com.tencent.mobileqq.guild.base.extension.r.f214743a;
                    IRuntimeService S02 = ch.S0(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(T::class.java, process)");
                    arrayList2.add(new MemberData(str22, tinyId22, userType2, d062, i16, z16, z17, vasPlateData2, url2, b162, str32, ((IGPSService) S02).getMemberLevelRole(guildMemberSelectorViewModel.guildId, iGProUserInfo.getTinyId(), String.valueOf(iGProUserInfo.getLevelRoleId())), iGProUserInfo.getRoleManagementTag()));
                }
                guildMemberSelectorViewModel = this;
            }
            if (!arrayList2.isEmpty()) {
                if (fVar.getRole().w()) {
                    name = "\u666e\u901a\u6210\u5458";
                } else {
                    name = fVar.getRole().getName();
                }
                arrayList.add(new RoleTitleData(name));
                arrayList.addAll(arrayList2);
            }
            guildMemberSelectorViewModel = this;
        }
        return arrayList;
    }

    private final List<a> W1(List<? extends IGProUserInfo> users) {
        int collectionSizeOrDefault;
        boolean z16;
        List<? extends IGProUserInfo> list = users;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProUserInfo iGProUserInfo : list) {
            String str = this.guildId;
            String tinyId = iGProUserInfo.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            int userType = iGProUserInfo.getUserType();
            String d06 = ch.d0(iGProUserInfo);
            Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(it)");
            if (iGProUserInfo.getRobotType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList.add(new MemberData(str, tinyId, userType, d06, 0, false, z16, null, null, null, null, null, null, 8064, null));
        }
        return arrayList;
    }

    private final void X1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.selector.p
            @Override // java.lang.Runnable
            public final void run() {
                GuildMemberSelectorViewModel.Z1(GuildMemberSelectorViewModel.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(GuildMemberSelectorViewModel this$0) {
        List<a> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer value = this$0.b2().getValue();
        int d16 = b.INSTANCE.d();
        if (value == null || value.intValue() != d16) {
            Logger.f235387a.d().i("GuildMemberSelectorViewModel", 1, "no need show loading");
            return;
        }
        MutableLiveData<List<a>> mutableLiveData = this$0._memberListLiveData;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new r());
        mutableLiveData.setValue(listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        Integer value = this._searchLoadStateLiveData.getValue();
        b.Companion companion = b.INSTANCE;
        int c16 = companion.c();
        if (value != null && value.intValue() == c16) {
            this._searchLoadStateLiveData.setValue(Integer.valueOf(companion.d()));
        } else {
            int b16 = companion.b();
            if (value != null && value.intValue() == b16) {
                this._searchLoadStateLiveData.setValue(Integer.valueOf(companion.e()));
            } else {
                return;
            }
        }
        final String value2 = this.searchKeyFlow.getValue();
        cl clVar = new cl();
        clVar.p(GProGuildMemberSearchSourceId.ALL_MEMBER.ordinal());
        clVar.l(com.tencent.guild.aio.input.at.utils.g.a(this.guildId, 0L));
        clVar.k(1000);
        clVar.m(value2);
        clVar.n(this.nextPos);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGPSService) S0).searchGuildMembersBySourceId(clVar, new ec() { // from class: com.tencent.mobileqq.guild.setting.member.selector.o
            @Override // wh2.ec
            public final void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
                GuildMemberSelectorViewModel.i2(GuildMemberSelectorViewModel.this, value2, i3, str, iGProGuildMemberSearchResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(GuildMemberSelectorViewModel this$0, String text, int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        boolean z16 = true;
        if (Intrinsics.areEqual(this$0._isSearchModeLiveData.getValue(), Boolean.FALSE)) {
            this$0._searchLoadStateLiveData.setValue(Integer.valueOf(b.INSTANCE.c()));
            Logger.f235387a.d().w("GuildMemberSelectorViewModel", 1, "searchMember(" + text + ") valid: current is not search mode");
            return;
        }
        if (i3 != 0) {
            List<a> value = this$0._searchResultLiveData.getValue();
            if (value != null && !value.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                this$0._searchLoadStateLiveData.setValue(Integer.valueOf(b.INSTANCE.c()));
            } else {
                this$0._searchLoadStateLiveData.setValue(Integer.valueOf(b.INSTANCE.b()));
            }
            this$0._toastEvent.setValue(new cf1.b(i3, str, null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<a> value2 = this$0._searchResultLiveData.getValue();
        if (this$0.nextPos != 0 && value2 != null) {
            arrayList.addAll(value2);
            CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
        }
        ArrayList<IGProUserInfo> members = iGProGuildMemberSearchResult.getMembers();
        Intrinsics.checkNotNullExpressionValue(members, "searchResult.members");
        arrayList.addAll(this$0.W1(members));
        if (arrayList.isEmpty()) {
            arrayList.add(new com.tencent.mobileqq.guild.setting.member.selector.b());
        } else {
            arrayList.add(new com.tencent.mobileqq.guild.setting.member.selector.c());
        }
        this$0.nextPos = iGProGuildMemberSearchResult.getNextPos();
        this$0._searchResultLiveData.setValue(arrayList);
        MutableLiveData<Integer> mutableLiveData = this$0._searchLoadStateLiveData;
        if (iGProGuildMemberSearchResult.getNextPos() != 0 && !iGProGuildMemberSearchResult.getMembers().isEmpty()) {
            valueOf = Integer.valueOf(b.INSTANCE.b());
        } else {
            valueOf = Integer.valueOf(b.INSTANCE.a());
        }
        mutableLiveData.setValue(valueOf);
    }

    @NotNull
    public final LiveData<Boolean> a2() {
        return this._loadMoreFinishEvent;
    }

    @NotNull
    public final LiveData<Integer> b2() {
        return this._loadStateLiveData;
    }

    @NotNull
    public final LiveData<List<a>> c2() {
        return this._memberListLiveData;
    }

    @NotNull
    public final LiveData<Integer> d2() {
        return this._searchLoadStateLiveData;
    }

    @NotNull
    public final LiveData<List<a>> e2() {
        return this._searchResultLiveData;
    }

    @NotNull
    public final LiveData<Boolean> f2() {
        return this._isSearchModeLiveData;
    }

    public final void g2() {
        h2();
    }

    @NotNull
    public final LiveData<cf1.b> getToastEvent() {
        return this._toastEvent;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller.b
    public void h1(@NotNull ri1.a error, @NotNull GuildMemberPuller.PullStep step, @Nullable RoleToMemberListModel listModel, int totalMemberNum) {
        List<a> emptyList;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(step, "step");
        Integer value = this._loadStateLiveData.getValue();
        b.Companion companion = b.INSTANCE;
        int e16 = companion.e();
        if (value != null && value.intValue() == e16) {
            this._loadMoreFinishEvent.setValue(Boolean.TRUE);
        }
        if (!error.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "Failed pulling guildMembers, error: " + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMemberSelectorViewModel", 1, (String) it.next(), null);
            }
            this._toastEvent.setValue(new cf1.b(error.f431477a, error.f431478b, null));
            return;
        }
        int i3 = c.f234662a[step.ordinal()];
        if (i3 != 2) {
            if (i3 == 3) {
                this._loadStateLiveData.setValue(Integer.valueOf(companion.a()));
            }
        } else {
            this._loadStateLiveData.setValue(Integer.valueOf(companion.b()));
        }
        if (listModel == null) {
            MutableLiveData<List<a>> mutableLiveData = this._memberListLiveData;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.setValue(emptyList);
            return;
        }
        this._memberListLiveData.setValue(U1(listModel));
    }

    public final void j2(@NotNull String keyWord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        if (keyWord.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        T1(z16);
        this.searchKeyFlow.setValue(keyWord);
    }

    public final void loadMore() {
        Integer value = b2().getValue();
        b.Companion companion = b.INSTANCE;
        int b16 = companion.b();
        if (value != null && value.intValue() == b16) {
            GuildMemberPuller.g(this.mMemberPuller, false, 1, null);
            this._loadStateLiveData.setValue(Integer.valueOf(companion.e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Job job = this.collectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
