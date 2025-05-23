package com.tencent.guild.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.IGuildAioPopupPanelConfigApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.be;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/impl/GuildAioPopupPanelConfigApiImpl;", "Lcom/tencent/guild/api/IGuildAioPopupPanelConfigApi;", "", "enable", "", "saveSwitchToMMKV", "Lcom/tencent/common/app/AppInterface;", "qqAppInterface", "", "guildId", "Lkotlin/Function1;", "fetchCallback", "fetchTroopListSwitch", "isEnableTroopList", "<init>", "()V", "Companion", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioPopupPanelConfigApiImpl implements IGuildAioPopupPanelConfigApi {

    @NotNull
    private static final String MMKV_PANEL_ENABLE_TROOP_LIST = "mmkv_panel_enable_troop_list";
    private static final int REQUEST_INTERVAL = 3600000;

    @NotNull
    private static final String TAG = "GuildAioPopupPanelConfigApiImpl";
    private static long sLastRequestTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopListSwitch$lambda$3(GuildAioPopupPanelConfigApiImpl this$0, Function1 function1, int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
        ArrayList<IGProSwitchInfo> arrayList;
        int collectionSizeOrDefault;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        if (iGProChannelOpenStateResultInfo != null) {
            arrayList = iGProChannelOpenStateResultInfo.getSwitchInfoList();
        } else {
            arrayList = null;
        }
        boolean z16 = true;
        d16.d(TAG, 1, "[fetchTroopListSwitch] result " + i3 + " errMsg " + str + " rsp " + arrayList);
        ArrayList<IGProSwitchInfo> switchInfoList = iGProChannelOpenStateResultInfo.getSwitchInfoList();
        Intrinsics.checkNotNullExpressionValue(switchInfoList, "stateResultInfo.switchInfoList");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = switchInfoList.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((IGProSwitchInfo) next).getSwitchType() == 16) {
                z17 = true;
            }
            if (z17) {
                arrayList2.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(Integer.valueOf(((IGProSwitchInfo) it5.next()).getSwitchState()));
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
        Integer num = (Integer) firstOrNull;
        if (num != null && num.intValue() == 2) {
            z16 = false;
        }
        this$0.saveSwitchToMMKV(z16);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    private final void saveSwitchToMMKV(boolean enable) {
        Logger.f235387a.d().d(TAG, 1, "[saveSwitchToMMKV] enable " + enable);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean(MMKV_PANEL_ENABLE_TROOP_LIST, enable);
    }

    @Override // com.tencent.guild.api.IGuildAioPopupPanelConfigApi
    public void fetchTroopListSwitch(@NotNull AppInterface qqAppInterface, long guildId, @Nullable final Function1<? super Boolean, Unit> fetchCallback) {
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(qqAppInterface, "qqAppInterface");
        if (System.currentTimeMillis() - sLastRequestTime < 3600000) {
            if (fetchCallback != null) {
                fetchCallback.invoke(Boolean.valueOf(isEnableTroopList()));
            }
        } else {
            sLastRequestTime = System.currentTimeMillis();
            IRuntimeService runtimeService = qqAppInterface.getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "qqAppInterface.getRuntim\u2026va, ProcessConstant.MAIN)");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(16);
            ((IGPSService) runtimeService).fetchSpecifiedTypeChannelsOpenState(guildId, arrayListOf, 0, new be() { // from class: com.tencent.guild.api.impl.c
                @Override // wh2.be
                public final void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
                    GuildAioPopupPanelConfigApiImpl.fetchTroopListSwitch$lambda$3(GuildAioPopupPanelConfigApiImpl.this, fetchCallback, i3, str, iGProChannelOpenStateResultInfo);
                }
            });
        }
    }

    @Override // com.tencent.guild.api.IGuildAioPopupPanelConfigApi
    public boolean isEnableTroopList() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return fromV2.getBoolean(MMKV_PANEL_ENABLE_TROOP_LIST, false);
    }
}
