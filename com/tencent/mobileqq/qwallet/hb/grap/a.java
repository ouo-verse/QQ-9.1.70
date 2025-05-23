package com.tencent.mobileqq.qwallet.hb.grap;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.fh;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b#\u0010$J \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0014J \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0014J\u0016\u0010\u000f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0014R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R8\u0010\u0018\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R8\u0010\u0019\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R8\u0010\u001b\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/grap/a;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "", "tinyIds", "Ljava/util/HashMap;", "f", "guildId", "tinyId", "", "onGuildUserAvatarUrlUpdate", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/fh;", "list", "onBatchGuildMemberNameUpdate", "onBatchGuildUserNickUpdate", "d", "Ljava/lang/String;", "mGuildId", "", "kotlin.jvm.PlatformType", "", "e", "Ljava/util/Set;", "avatarUrlSet", "nickNameSet", h.F, "memberNameSet", "Lmqq/app/AppRuntime;", "b", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "<init>", "(Ljava/lang/String;)V", "i", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends GPServiceObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Set<String> avatarUrlSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Set<String> nickNameSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Set<String> memberNameSet;

    public a(@NotNull String mGuildId) {
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.mGuildId = mGuildId;
        this.avatarUrlSet = Collections.synchronizedSet(new HashSet());
        this.nickNameSet = Collections.synchronizedSet(new HashSet());
        this.memberNameSet = Collections.synchronizedSet(new HashSet());
        e().addObserver(this);
    }

    private final AppRuntime b() {
        AppRuntime g16 = d.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getAppRuntime()");
        return g16;
    }

    private final IGPSService e() {
        IRuntimeService runtimeService = b().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (IGPSService) runtimeService;
    }

    @NotNull
    public final HashMap<String, String> f(@NotNull List<String> tinyIds) {
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        List<String> list = tinyIds;
        this.avatarUrlSet.addAll(list);
        ArrayList arrayList = new ArrayList(list);
        HashMap<String, String> hashMap = new HashMap<>();
        Map<String, String> guildUserAvatarUrls = e().getGuildUserAvatarUrls(this.mGuildId, arrayList, 0);
        if (guildUserAvatarUrls == null) {
            return hashMap;
        }
        QLog.i("QWalletGuildObserver", 1, "getGuildAvatarUrls tinyIds = " + tinyIds + " guildUsersAvatars = " + guildUserAvatarUrls);
        if (!guildUserAvatarUrls.isEmpty()) {
            for (String str : tinyIds) {
                String str2 = guildUserAvatarUrls.get(str);
                if (str2 != null && !TextUtils.isEmpty(str2)) {
                    hashMap.put(str, str2);
                }
            }
        }
        Set<String> set = this.avatarUrlSet;
        Set<String> keySet = hashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "tinyId2AvatarUrl.keys");
        set.removeAll(keySet);
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> g(@NotNull List<String> tinyIds) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        List<String> list = tinyIds;
        this.nickNameSet.addAll(list);
        this.memberNameSet.addAll(list);
        ArrayList arrayList = new ArrayList(list);
        Map<String, String> guildMemberNames = e().getGuildMemberNames(this.mGuildId, arrayList);
        Intrinsics.checkNotNullExpressionValue(guildMemberNames, "gProService.getGuildMemb\u2026mes(mGuildId, copyTinyId)");
        Map<String, String> guildUsersNicks = e().getGuildUsersNicks(this.mGuildId, arrayList);
        Intrinsics.checkNotNullExpressionValue(guildUsersNicks, "gProService.getGuildUser\u2026cks(mGuildId, copyTinyId)");
        HashMap<String, String> hashMap = new HashMap<>();
        if ((!guildMemberNames.isEmpty()) || (!guildUsersNicks.isEmpty())) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : tinyIds) {
                String str2 = guildMemberNames.get(str);
                String str3 = guildUsersNicks.get(str);
                boolean z17 = false;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    hashMap.put(str, str2);
                    this.memberNameSet.remove(str);
                    this.nickNameSet.remove(str);
                    arrayList2.add(str);
                } else {
                    if (str3 == null || str3.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        hashMap.put(str, str3);
                        this.nickNameSet.remove(str);
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onBatchGuildMemberNameUpdate(@NotNull String guildId, @NotNull List<? extends fh> list) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(list, "list");
        super.onBatchGuildMemberNameUpdate(guildId, list);
        if (Intrinsics.areEqual(this.mGuildId, guildId) && !this.memberNameSet.isEmpty() && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator<? extends fh> it = list.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                fh next = it.next();
                String tinyId = next.b();
                if (this.memberNameSet.contains(tinyId)) {
                    String a16 = next.a();
                    if (a16 != null && a16.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
                        String a17 = next.a();
                        Intrinsics.checkNotNullExpressionValue(a17, "nickNameInfo.name");
                        hashMap.put(tinyId, a17);
                        this.memberNameSet.remove(tinyId);
                        this.nickNameSet.remove(tinyId);
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mobileqq.qwallet.guild.nicknames");
                intent.putExtra("guildId", this.mGuildId);
                intent.putExtra("guildNickNames", hashMap);
                MobileQQ.sMobileQQ.sendBroadcast(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onBatchGuildUserNickUpdate(@NotNull List<? extends fh> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.onBatchGuildUserNickUpdate(list);
        if (!this.nickNameSet.isEmpty() && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (fh fhVar : list) {
                String tinyId = fhVar.b();
                if (this.nickNameSet.contains(tinyId) && !TextUtils.isEmpty(fhVar.a())) {
                    Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
                    String a16 = fhVar.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "nickNameInfo.name");
                    hashMap.put(tinyId, a16);
                    this.nickNameSet.remove(tinyId);
                }
            }
            if (!hashMap.isEmpty()) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mobileqq.qwallet.guild.nicknames");
                intent.putExtra("guildId", this.mGuildId);
                intent.putExtra("guildNickNames", hashMap);
                MobileQQ.sMobileQQ.sendBroadcast(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onGuildUserAvatarUrlUpdate(@NotNull String guildId, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        super.onGuildUserAvatarUrlUpdate(guildId, tinyId);
        if (this.avatarUrlSet.contains(tinyId)) {
            if (Intrinsics.areEqual(this.mGuildId, guildId) || Intrinsics.areEqual("0", guildId)) {
                boolean z16 = false;
                String fullGuildUserUserAvatarUrl = e().getFullGuildUserUserAvatarUrl(guildId, tinyId, 0);
                if (fullGuildUserUserAvatarUrl == null) {
                    return;
                }
                QLog.i("QWalletGuildObserver", 1, "onGuildUserAvatarUrlUpdate guildId = " + guildId + " tinyId = " + tinyId + " guildAvatarUrl = " + fullGuildUserUserAvatarUrl);
                if (fullGuildUserUserAvatarUrl.length() > 0) {
                    z16 = true;
                }
                if (z16) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mobileqq.qwallet.guild.avatarurl");
                    intent.putExtra("guildId", this.mGuildId);
                    intent.putExtra("tinyId", tinyId);
                    intent.putExtra("guildAvatarUrl", fullGuildUserUserAvatarUrl);
                    MobileQQ.sMobileQQ.sendBroadcast(intent);
                    this.avatarUrlSet.remove(tinyId);
                }
            }
        }
    }
}
