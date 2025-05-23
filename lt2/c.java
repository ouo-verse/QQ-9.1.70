package lt2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.event.CancelBindGuildEvent;
import com.tencent.mobileqq.troop.troopapps.event.UpdateBindGuildEvent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAIOBindGuildInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAIOBindGuildInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIOBindGuildInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAIOBindGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetAIOBindGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.SetAIOBindGuildRsp;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.troopguild.api.ITroopGuildApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 Z2\u00020\u0001:\u0001[B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\bY\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J.\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R.\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010*R*\u00103\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R-\u00109\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010@\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010F\u001a\b\u0012\u0004\u0012\u00020\n008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u00102\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010K\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0017\u001a\u0004\bH\u0010\u0019\"\u0004\bI\u0010JR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\n008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00102R(\u0010R\u001a\b\u0012\u0004\u0012\u00020\n048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u00106\u001a\u0004\bO\u00108\"\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\u0017R\"\u0010X\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010;\u001a\u0004\bV\u0010=\"\u0004\bW\u0010?\u00a8\u0006\\"}, d2 = {"Llt2/c;", "Landroidx/lifecycle/ViewModel;", "", "d2", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "guildInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "guildInfoList", "X1", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "f2", "W1", "", "emId", "eventId", "", "", "params", "Z1", "i", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "troopUin", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "N1", "()Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "e2", "(Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;)V", "curDisplayedGuild", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "guildIdSetHasDisplay", "D", "Ljava/util/ArrayList;", "mineGuildListHasDisplay", "E", "guildListHasDisplay", UserInfo.SEX_FEMALE, "guildListFromBack", "Landroidx/lifecycle/MutableLiveData;", "G", "Landroidx/lifecycle/MutableLiveData;", "_optGuildListLiveData", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "optGuildListLiveData", "I", "Z", "T1", "()Z", "setTroopGuild", "(Z)V", "isTroopGuild", "J", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setTroopGuildLivaData", "(Landroidx/lifecycle/MutableLiveData;)V", "isTroopGuildLivaData", "K", "P1", "setTroopName", "(Ljava/lang/String;)V", "troopName", "L", "_isLoadingLiveData", "M", "S1", "setLoadingLiveData", "(Landroidx/lifecycle/LiveData;)V", "isLoadingLiveData", "N", "lastCookie", "P", "R1", "setEnd", "isEnd", "<init>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Long> guildIdSetHasDisplay;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<AIOBindGuildInfo> mineGuildListHasDisplay;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<AIOBindGuildInfo> guildListHasDisplay;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<AIOBindGuildInfo> guildListFromBack;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<AIOBindGuildInfo>> _optGuildListLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<AIOBindGuildInfo>> optGuildListLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isTroopGuild;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isTroopGuildLivaData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String troopName;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _isLoadingLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private LiveData<Boolean> isLoadingLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String lastCookie;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOBindGuildInfo curDisplayedGuild;

    public c(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
        this.guildIdSetHasDisplay = new HashSet<>();
        this.mineGuildListHasDisplay = new ArrayList<>();
        this.guildListHasDisplay = new ArrayList<>();
        this.guildListFromBack = new ArrayList<>();
        MutableLiveData<ArrayList<AIOBindGuildInfo>> mutableLiveData = new MutableLiveData<>();
        this._optGuildListLiveData = mutableLiveData;
        this.optGuildListLiveData = mutableLiveData;
        this.isTroopGuild = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuildSwitchOpen(troopUin);
        this.isTroopGuildLivaData = new MutableLiveData<>();
        this.troopName = "";
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isLoadingLiveData = mutableLiveData2;
        this.isLoadingLiveData = mutableLiveData2;
        this.lastCookie = "";
    }

    private final void X1(AIOBindGuildInfo guildInfo, ArrayList<AIOBindGuildInfo> guildInfoList) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(guildInfoList, guildInfo);
        if (contains) {
            TypeIntrinsics.asMutableCollection(guildInfoList).remove(guildInfo);
            return;
        }
        if (guildInfo != null) {
            Iterator<AIOBindGuildInfo> it = guildInfoList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "guildInfoList.iterator()");
            while (it.hasNext()) {
                if (it.next().guildId == guildInfo.guildId) {
                    it.remove();
                }
            }
        }
    }

    public static /* synthetic */ void b2(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        cVar.a2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(c this$0, boolean z16, int i3, String str, GetAIOBindGuildInfoRsp getAIOBindGuildInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._isLoadingLiveData.postValue(Boolean.FALSE);
        if (i3 != 0) {
            QLog.e("TroopBindGuildListViewModel", 1, "[requestOptGuildList] troopUin = " + this$0.troopUin + ", cookies = " + this$0.lastCookie + " errCode = " + i3 + " errMsg = " + str);
            return;
        }
        Iterator<AIOBindGuildInfo> it = getAIOBindGuildInfoRsp.optGuilds.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "rsp.optGuilds.iterator()");
        while (it.hasNext()) {
            if (this$0.guildIdSetHasDisplay.contains(Long.valueOf(it.next().guildId))) {
                it.remove();
            }
        }
        if (!z16) {
            this$0.guildListFromBack.clear();
        }
        this$0.guildListFromBack.addAll(getAIOBindGuildInfoRsp.optGuilds);
        this$0.d2();
        this$0.W1(getAIOBindGuildInfoRsp.bindGuild);
        String str2 = getAIOBindGuildInfoRsp.cookies;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.cookies");
        this$0.lastCookie = str2;
        this$0.isEnd = getAIOBindGuildInfoRsp.isEnd;
    }

    private final void d2() {
        ArrayList<AIOBindGuildInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.mineGuildListHasDisplay);
        boolean z16 = false;
        for (AIOBindGuildInfo aIOBindGuildInfo : this.guildListFromBack) {
            if (aIOBindGuildInfo.isOwner) {
                arrayList.add(aIOBindGuildInfo);
            } else {
                if (!z16) {
                    arrayList.addAll(this.guildListHasDisplay);
                    z16 = true;
                }
                arrayList.add(aIOBindGuildInfo);
            }
        }
        if (this.isEnd && !z16) {
            arrayList.addAll(this.guildListHasDisplay);
        }
        this._optGuildListLiveData.postValue(arrayList);
    }

    private final void e2(AIOBindGuildInfo aIOBindGuildInfo) {
        this.curDisplayedGuild = aIOBindGuildInfo;
        if (aIOBindGuildInfo != null) {
            this.guildIdSetHasDisplay.add(Long.valueOf(aIOBindGuildInfo.guildId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(AIOBindGuildInfo guildInfo, c this$0, boolean z16, int i3, String str, SetAIOBindGuildRsp setAIOBindGuildRsp) {
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.e("TroopBindGuildListViewModel", 1, "[updateBindGuild] bindGuildId = " + guildInfo.guildId + " errCode = " + i3 + " errMsg = " + str);
            QQToast.makeText(BaseApplication.context, 1, "\u8be5\u9891\u9053\u72b6\u6001\u5f02\u5e38\uff0c\u6682\u4e0d\u652f\u6301\u8bbe\u7f6e", 0).show();
            return;
        }
        if (z16) {
            guildInfo = null;
        }
        this$0.W1(guildInfo);
        QQToast.makeText(BaseApplication.context, 2, "\u8bbe\u7f6e\u5b8c\u6210", 0).show();
        SimpleEventBus.getInstance().dispatchEvent(UpdateBindGuildEvent.INSTANCE);
    }

    @Nullable
    /* renamed from: N1, reason: from getter */
    public final AIOBindGuildInfo getCurDisplayedGuild() {
        return this.curDisplayedGuild;
    }

    @NotNull
    public final LiveData<ArrayList<AIOBindGuildInfo>> O1() {
        return this.optGuildListLiveData;
    }

    @NotNull
    /* renamed from: P1, reason: from getter */
    public final String getTroopName() {
        return this.troopName;
    }

    @NotNull
    /* renamed from: Q1, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: R1, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.isLoadingLiveData;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getIsTroopGuild() {
        return this.isTroopGuild;
    }

    @NotNull
    public final MutableLiveData<Boolean> U1() {
        return this.isTroopGuildLivaData;
    }

    public final void W1(@Nullable AIOBindGuildInfo guildInfo) {
        AIOBindGuildInfo aIOBindGuildInfo = this.curDisplayedGuild;
        if (aIOBindGuildInfo != null) {
            if (aIOBindGuildInfo.isOwner) {
                this.mineGuildListHasDisplay.add(0, aIOBindGuildInfo);
            } else {
                this.guildListHasDisplay.add(0, aIOBindGuildInfo);
            }
        }
        X1(guildInfo, this.guildListFromBack);
        X1(guildInfo, this.mineGuildListHasDisplay);
        X1(guildInfo, this.guildListHasDisplay);
        e2(guildInfo);
        d2();
    }

    public final void Z1(@NotNull String emId, @NotNull String eventId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(emId, "emId");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_group_app_channel_show");
        linkedHashMap.put("pgid", "pg_group_app_channel_show");
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

    public final void a2(final boolean isLoadMore) {
        Long longOrNull;
        if (!this.isEnd) {
            Boolean value = this._isLoadingLiveData.getValue();
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(value, bool)) {
                this._isLoadingLiveData.postValue(bool);
                GetAIOBindGuildInfoReq getAIOBindGuildInfoReq = new GetAIOBindGuildInfoReq();
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
                if (longOrNull != null) {
                    getAIOBindGuildInfoReq.groupCode = longOrNull.longValue();
                    getAIOBindGuildInfoReq.cookies = this.lastCookie;
                    s i3 = bg.i(null, 1, null);
                    if (i3 != null) {
                        i3.getAIOBindGuildInfo(getAIOBindGuildInfoReq, new IGetAIOBindGuildInfoCallback() { // from class: lt2.a
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAIOBindGuildInfoCallback
                            public final void onResult(int i16, String str, GetAIOBindGuildInfoRsp getAIOBindGuildInfoRsp) {
                                c.c2(c.this, isLoadMore, i16, str, getAIOBindGuildInfoRsp);
                            }
                        });
                    }
                }
            }
        }
    }

    public final void f2(@NotNull final AIOBindGuildInfo guildInfo) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        AIOBindGuildInfo aIOBindGuildInfo = this.curDisplayedGuild;
        final boolean z16 = false;
        if (aIOBindGuildInfo != null && guildInfo.guildId == aIOBindGuildInfo.guildId) {
            z16 = true;
        }
        SetAIOBindGuildReq setAIOBindGuildReq = new SetAIOBindGuildReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            setAIOBindGuildReq.groupCode = longOrNull.longValue();
            if (z16) {
                j3 = 0;
            } else {
                j3 = guildInfo.guildId;
            }
            setAIOBindGuildReq.guildId = j3;
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.setAIOBindGuild(setAIOBindGuildReq, new ISetAIOBindGuildCallback() { // from class: lt2.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAIOBindGuildCallback
                    public final void onResult(int i16, String str, SetAIOBindGuildRsp setAIOBindGuildRsp) {
                        c.g2(AIOBindGuildInfo.this, this, z16, i16, str, setAIOBindGuildRsp);
                    }
                });
            }
            if (z16) {
                SimpleEventBus.getInstance().dispatchEvent(CancelBindGuildEvent.INSTANCE);
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopAppService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
            ((ITroopAppService) runtimeService).setProfileAppListChangedFromWebOperate(true, this.troopUin);
        }
    }
}
