package ht2;

import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.mobileqq.troop.troopbindguild.handler.TroopBindGuildHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BindGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupBindGuildsReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupBindGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GuildMapGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupBindGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupRelationToGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUnbindAllGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupRelationToGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupRelationToGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.UnbindAllGuildsReq;
import com.tencent.qqnt.kernel.nativeinterface.UnbindAllGuildsRsp;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ht2.a;
import ht2.b;
import ht2.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\t*\u00013\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001:B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0004H\u0014J.\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017R\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010#\u001a\u00020\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lht2/g;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lht2/a;", "Lht2/b;", "", "initData", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "g2", "", "guildId", "d2", FeedManager.LOAD_MORE, "S1", "T1", "b2", "userIntent", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "onCleared", "", "emId", "eventId", "", "", "params", "c2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopUin", "Lht2/b$c;", "D", "Lht2/b$c;", "X1", "()Lht2/b$c;", "mNoneValueIntent", "", "Lcom/tencent/qqnt/kernel/nativeinterface/BindGuildInfo;", "E", "Ljava/util/List;", "guildList", UserInfo.SEX_FEMALE, "Z", "hasMore", "G", "isSwitchOpen", "", "H", "I", "requestPageIndex", "needUnbindAllGuild", "ht2/g$b", "J", "Lht2/g$b;", "observer", "<init>", "(Ljava/lang/String;)V", "K", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends BaseViewModel<a, ht2.b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b.c mNoneValueIntent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<BindGuildInfo> guildList;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasMore;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isSwitchOpen;

    /* renamed from: H, reason: from kotlin metadata */
    private int requestPageIndex;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needUnbindAllGuild;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"ht2/g$b", "Lft2/a;", "", "isSuccess", "", "troopUin", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ft2.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(boolean z16, boolean z17, g this$0, String troopUin) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
            if (!z16) {
                QQToast.makeText(Foreground.getTopActivity(), HardCodeUtil.qqStr(R.string.f173052s4), 0).show();
                return;
            }
            if (z17) {
                this$0.T1();
                return;
            }
            if (this$0.needUnbindAllGuild) {
                this$0.needUnbindAllGuild = false;
                UnbindAllGuildsReq unbindAllGuildsReq = new UnbindAllGuildsReq();
                unbindAllGuildsReq.groupCode = Long.parseLong(troopUin);
                s groupService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupService();
                if (groupService != null) {
                    groupService.unbindAllGuilds(unbindAllGuildsReq, new IUnbindAllGuildsCallback() { // from class: ht2.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IUnbindAllGuildsCallback
                        public final void onResult(int i3, String str, UnbindAllGuildsRsp unbindAllGuildsRsp) {
                            g.b.f(i3, str, unbindAllGuildsRsp);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(int i3, String str, UnbindAllGuildsRsp unbindAllGuildsRsp) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopBindGuildSettingVM", 2, "unbindAllGuilds errCode=" + i3 + ", errMsg=" + str);
            }
        }

        @Override // ft2.a
        public void a(final boolean isSuccess, @NotNull final String troopUin, final boolean isOpen) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (QLog.isColorLevel()) {
                QLog.d("TroopBindGuildSettingVM", 2, "onSetBindGuildSwitch isSuccess=" + isSuccess + ", troopUin=" + troopUin + ", isOpen=" + isOpen);
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = g.this;
            uIHandlerV2.post(new Runnable() { // from class: ht2.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.e(isSuccess, isOpen, gVar, troopUin);
                }
            });
        }
    }

    public g(@NotNull String troopUin) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
        this.mNoneValueIntent = b.c.f406239a;
        this.guildList = new ArrayList();
        this.hasMore = true;
        b bVar = new b();
        this.observer = bVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(bVar);
        }
    }

    private final void S1() {
        this.guildList.clear();
        this.hasMore = true;
        this.requestPageIndex = 0;
        b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        GetGroupBindGuildsReq getGroupBindGuildsReq = new GetGroupBindGuildsReq();
        getGroupBindGuildsReq.groupCode = Long.parseLong(this.troopUin);
        getGroupBindGuildsReq.pageIndex = this.requestPageIndex;
        s groupService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupService();
        if (groupService != null) {
            groupService.getGroupBindGuilds(getGroupBindGuildsReq, new IGetGroupBindGuildsCallback() { // from class: ht2.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupBindGuildsCallback
                public final void onResult(int i3, String str, GetGroupBindGuildsRsp getGroupBindGuildsRsp) {
                    g.U1(g.this, i3, str, getGroupBindGuildsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(final g this$0, final int i3, final String str, final GetGroupBindGuildsRsp getGroupBindGuildsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ht2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.W1(i3, this$0, getGroupBindGuildsRsp, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(int i3, g this$0, GetGroupBindGuildsRsp getGroupBindGuildsRsp, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            List<BindGuildInfo> list = this$0.guildList;
            ArrayList<BindGuildInfo> bindingGuilds = getGroupBindGuildsRsp.getBindingGuilds();
            Intrinsics.checkNotNullExpressionValue(bindingGuilds, "rsp.getBindingGuilds()");
            list.addAll(bindingGuilds);
            this$0.hasMore = !getGroupBindGuildsRsp.isEnd;
            this$0.requestPageIndex++;
            this$0.b2();
            return;
        }
        QLog.e("TroopBindGuildSettingVM", 1, "fetchBindGuildList error, errCode = " + i3 + ", errMsg = " + str);
    }

    private final void b2() {
        ArrayList arrayList = new ArrayList();
        for (BindGuildInfo bindGuildInfo : this.guildList) {
            BindGuildInfo bindGuildInfo2 = new BindGuildInfo();
            bindGuildInfo2.guildId = bindGuildInfo.guildId;
            bindGuildInfo2.guildName = bindGuildInfo.guildName;
            bindGuildInfo2.faceSeq = bindGuildInfo.faceSeq;
            bindGuildInfo2.guildNumber = bindGuildInfo.guildNumber;
            bindGuildInfo2.joinSig = bindGuildInfo.joinSig;
            arrayList.add(bindGuildInfo2);
        }
        getMUiState().postValue(new a.BindGuildListUpdated(arrayList, this.hasMore, this.isSwitchOpen));
    }

    private final void d2(final long guildId) {
        ArrayList<GuildMapGroupInfo> arrayListOf;
        SetGroupRelationToGuildReq setGroupRelationToGuildReq = new SetGroupRelationToGuildReq();
        setGroupRelationToGuildReq.guildId = guildId;
        setGroupRelationToGuildReq.writeMode = 1;
        GuildMapGroupInfo guildMapGroupInfo = new GuildMapGroupInfo();
        guildMapGroupInfo.groupCode = Long.parseLong(this.troopUin);
        guildMapGroupInfo.operType = 2L;
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(guildMapGroupInfo);
        setGroupRelationToGuildReq.guildMapGroupInfoList = arrayListOf;
        s groupService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupService();
        if (groupService != null) {
            groupService.setGroupRelationToGuild(setGroupRelationToGuildReq, new ISetGroupRelationToGuildCallback() { // from class: ht2.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupRelationToGuildCallback
                public final void onResult(int i3, String str, SetGroupRelationToGuildRsp setGroupRelationToGuildRsp) {
                    g.e2(g.this, guildId, i3, str, setGroupRelationToGuildRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(final g this$0, final long j3, final int i3, final String str, SetGroupRelationToGuildRsp setGroupRelationToGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ht2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.f2(i3, this$0, j3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(int i3, g this$0, long j3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            Iterator<BindGuildInfo> it = this$0.guildList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BindGuildInfo next = it.next();
                if (next.guildId == j3) {
                    this$0.guildList.remove(next);
                    break;
                }
            }
            this$0.b2();
            return;
        }
        QQToast.makeText(Foreground.getTopActivity(), HardCodeUtil.qqStr(R.string.f146420u5), 0).show();
        QLog.e("TroopBindGuildSettingVM", 1, "unBindGuild error, errCode = " + i3 + ", errMsg = " + str);
    }

    private final void g2(boolean isOpen) {
        AppInterface appInterface;
        this.isSwitchOpen = isOpen;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopBindGuildHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopbindguild.handler.TroopBindGuildHandler");
        ((TroopBindGuildHandler) businessHandler).G2(this.troopUin, isOpen);
        if (!isOpen) {
            this.needUnbindAllGuild = !this.guildList.isEmpty();
            S1();
        }
    }

    private final void initData() {
        ITroopBindGuildApi.TroopBindGuildInfo bindGuildInfoFromExtInfo = ((ITroopBindGuildApi) QRoute.api(ITroopBindGuildApi.class)).getBindGuildInfoFromExtInfo(this.troopUin);
        if (bindGuildInfoFromExtInfo != null) {
            this.isSwitchOpen = bindGuildInfoFromExtInfo.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String();
            getMUiState().postValue(new a.BindGuildSwitchInitialized(this.isSwitchOpen));
        }
        if (this.isSwitchOpen) {
            T1();
        }
    }

    private final void loadMore() {
        T1();
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: X1, reason: from getter */
    public b.c getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull ht2.b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            initData();
            return;
        }
        if (userIntent instanceof b.UpdateSwitch) {
            g2(((b.UpdateSwitch) userIntent).getIsOpen());
        } else if (userIntent instanceof b.UnBindGuild) {
            d2(((b.UnBindGuild) userIntent).getGuildId());
        } else if (userIntent instanceof b.C10474b) {
            loadMore();
        }
    }

    public final boolean a2() {
        return this.guildList.isEmpty();
    }

    public final void c2(@NotNull String emId, @NotNull String eventId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(emId, "emId");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_group_channel_bind_set");
        linkedHashMap.put("pgid", "pg_group_channel_bind_set");
        linkedHashMap.put("group_id", this.troopUin);
        linkedHashMap.put("group_uin_type", "1");
        HashMap hashMap = new HashMap();
        if (params == null) {
            params = new LinkedHashMap<>();
        }
        hashMap.putAll(params);
        hashMap.put("dt_eid", emId);
        hashMap.put("eid", emId);
        hashMap.put("cur_pg", linkedHashMap);
        VideoReport.reportEvent(eventId, hashMap);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        AppInterface appInterface;
        super.onCleared();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.observer);
        }
    }
}
