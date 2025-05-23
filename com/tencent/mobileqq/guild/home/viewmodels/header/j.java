package com.tencent.mobileqq.guild.home.viewmodels.header;

import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bf;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/j;", "", "", "guildId", "from", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f225420a = new j();

    j() {
    }

    public final boolean a(@NotNull String guildId, @NotNull String from) {
        ArrayList<Integer> arrayListOf;
        IGProCategoryChannelInfoList iGProCategoryChannelInfoList;
        ArrayList<IGProChannel> arrayList;
        boolean z16;
        boolean z17;
        boolean z18;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(from, "from");
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        boolean a16 = bf.f235464a.a();
        long longOrDefault = Util.toLongOrDefault(guildId, 0L);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        ArrayList<IGProCategoryChannelInfoList> categoryChannelInfoListByCategoryType = iGPSService.getCategoryChannelInfoListByCategoryType(longOrDefault, arrayListOf);
        Long l3 = null;
        if (categoryChannelInfoListByCategoryType != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) categoryChannelInfoListByCategoryType);
            iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) firstOrNull;
        } else {
            iGProCategoryChannelInfoList = null;
        }
        if (iGProCategoryChannelInfoList != null) {
            arrayList = iGProCategoryChannelInfoList.getChannelInfoList();
        } else {
            arrayList = null;
        }
        if (iGProCategoryChannelInfoList != null) {
            l3 = Long.valueOf(iGProCategoryChannelInfoList.getCategoryId());
        }
        if (l3 == null) {
            z16 = r.p().getGuildPermission(guildId).a(20001);
        } else if (!r.p().getGuildPermission(guildId).a(20001) && !r.p().getCategoryPermission(guildId, l3.toString()).a(20001)) {
            z16 = false;
        } else {
            z16 = true;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            if (arrayList != null && !arrayList.isEmpty()) {
                z18 = false;
            } else {
                z18 = true;
            }
            d16.d("GuildHomeHeaderGroupChatHelper", 1, "update guildId: " + guildId + ", from:" + from + ", categoryId:" + l3 + " canCreate: " + z16 + " && " + a16 + ", isEmpty:" + z18);
        }
        if (l3 != null) {
            if (z16 && a16) {
                return true;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                return true;
            }
        }
        return false;
    }
}
