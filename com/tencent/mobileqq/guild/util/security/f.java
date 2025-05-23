package com.tencent.mobileqq.guild.util.security;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.be;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u001e\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R(\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/util/security/f;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", "state", "", "g", "Landroidx/lifecycle/Observer;", "observer", "b", "f", "", "c", "d", "account", "onAccountChanged", "Ljava/util/concurrent/ConcurrentHashMap;", "Le12/e;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "mediaSpeakSwitchMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f f235633d = new f();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, e12.e<Integer>> mediaSpeakSwitchMap = new ConcurrentHashMap<>();

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String guildId, int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i("GuildMediaSecurityManager", 1, "pullMediaChannelSpeakSwitch: guildId:" + guildId + ", result:" + i3 + " errMsg:" + str + ", stateResultInfo:" + iGProChannelOpenStateResultInfo);
        if (i3 != 0) {
            return;
        }
        ArrayList<IGProSwitchInfo> switchInfoList = iGProChannelOpenStateResultInfo.getSwitchInfoList();
        Intrinsics.checkNotNullExpressionValue(switchInfoList, "stateResultInfo.switchInfoList");
        for (IGProSwitchInfo iGProSwitchInfo : switchInfoList) {
            if (iGProSwitchInfo.getSwitchType() == 14) {
                Logger.f235387a.d().i("GuildMediaSecurityManager", 1, "pullChannelSwitch  switchType = " + iGProSwitchInfo.getSwitchType() + ", switchState = " + iGProSwitchInfo.getSwitchState() + ", closeReason = " + iGProSwitchInfo.getCloseReason());
                f235633d.g(guildId, iGProSwitchInfo.getSwitchState());
            }
        }
    }

    private final void g(String guildId, int state) {
        ConcurrentHashMap<String, e12.e<Integer>> concurrentHashMap = mediaSpeakSwitchMap;
        if (!concurrentHashMap.containsKey(guildId)) {
            concurrentHashMap.put(guildId, new e12.e<>(Integer.valueOf(state)));
            return;
        }
        e12.e<Integer> eVar = concurrentHashMap.get(guildId);
        Intrinsics.checkNotNull(eVar);
        eVar.setValue(Integer.valueOf(state));
    }

    public final void b(@Nullable String guildId, @NotNull Observer<Integer> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (guildId == null) {
            QLog.i("GuildMediaSecurityManager", 1, "[addGuildMediaMuteObserver] guild is null");
            return;
        }
        ConcurrentHashMap<String, e12.e<Integer>> concurrentHashMap = mediaSpeakSwitchMap;
        boolean containsKey = concurrentHashMap.containsKey(guildId);
        QLog.i("GuildMediaSecurityManager", 1, "[addGuildMediaMuteObserver] guild = " + guildId + ", hasData = " + containsKey);
        if (!containsKey) {
            concurrentHashMap.clear();
            concurrentHashMap.put(guildId, new e12.e<>());
        }
        e12.e<Integer> eVar = concurrentHashMap.get(guildId);
        Intrinsics.checkNotNull(eVar);
        eVar.observeForever(observer);
    }

    public final boolean c(@Nullable String guildId) {
        Integer value;
        e12.e<Integer> eVar = mediaSpeakSwitchMap.get(guildId);
        if (eVar == null || (value = eVar.getValue()) == null || value.intValue() != 2) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull final String guildId) {
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("GuildMediaSecurityManager", 1, "[pullMediaChannelSpeakSwitch] guildId = " + guildId);
        if (TextUtils.isEmpty(guildId)) {
            return;
        }
        IRuntimeService runtimeService = ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface()\n         \u2026va, ProcessConstant.MAIN)");
        long parseLong = Long.parseLong(guildId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(14);
        ((IGPSService) runtimeService).fetchSpecifiedTypeChannelsOpenState(parseLong, arrayListOf, 0, new be() { // from class: com.tencent.mobileqq.guild.util.security.e
            @Override // wh2.be
            public final void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
                f.e(guildId, i3, str, iGProChannelOpenStateResultInfo);
            }
        });
    }

    public final void f(@Nullable String guildId, @NotNull Observer<Integer> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (guildId == null) {
            QLog.i("GuildMediaSecurityManager", 1, "[removeGuildMediaSpeakSwitchObserver] guild is null");
            return;
        }
        e12.e<Integer> eVar = mediaSpeakSwitchMap.get(guildId);
        QLog.i("GuildMediaSecurityManager", 1, "['removeGuildMediaMuteObserver'] guildId = " + guildId + ", muteMediaData = " + eVar + " ");
        if (eVar != null) {
            eVar.removeObserver(observer);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        mediaSpeakSwitchMap.clear();
    }
}
