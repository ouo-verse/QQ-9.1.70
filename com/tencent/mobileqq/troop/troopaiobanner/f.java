package com.tencent.mobileqq.troop.troopaiobanner;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$GameTeamUpBanner;
import com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify.GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/trpcprotocol/iqun/group_top_banner_notify/group_top_banner_notify/GroupTopBannerNotifyPB$QueryTopBannerInfoRsp;", "", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {
    @NotNull
    public static final String a(@Nullable GroupTopBannerNotifyPB$QueryTopBannerInfoRsp groupTopBannerNotifyPB$QueryTopBannerInfoRsp) {
        Boolean bool;
        Long l3;
        String str;
        String str2;
        PBStringField pBStringField;
        String str3;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBUInt64Field pBUInt64Field;
        PBBoolField pBBoolField;
        if (groupTopBannerNotifyPB$QueryTopBannerInfoRsp != null) {
            GroupTopBannerNotifyPB$GameTeamUpBanner groupTopBannerNotifyPB$GameTeamUpBanner = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.team_up_banner.get();
            int i3 = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.biz_type.get();
            int i16 = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.banner_type.get();
            boolean z16 = groupTopBannerNotifyPB$QueryTopBannerInfoRsp.is_disappear.get();
            String str4 = null;
            if (groupTopBannerNotifyPB$GameTeamUpBanner != null && (pBBoolField = groupTopBannerNotifyPB$GameTeamUpBanner.is_multi) != null) {
                bool = Boolean.valueOf(pBBoolField.get());
            } else {
                bool = null;
            }
            if (groupTopBannerNotifyPB$GameTeamUpBanner != null && (pBUInt64Field = groupTopBannerNotifyPB$GameTeamUpBanner.team_leader) != null) {
                l3 = Long.valueOf(pBUInt64Field.get());
            } else {
                l3 = null;
            }
            if (groupTopBannerNotifyPB$GameTeamUpBanner != null && (pBStringField3 = groupTopBannerNotifyPB$GameTeamUpBanner.single_group_text) != null) {
                str = pBStringField3.get();
            } else {
                str = null;
            }
            if (groupTopBannerNotifyPB$GameTeamUpBanner != null && (pBStringField2 = groupTopBannerNotifyPB$GameTeamUpBanner.multi_group_text) != null) {
                str2 = pBStringField2.get();
            } else {
                str2 = null;
            }
            if (groupTopBannerNotifyPB$GameTeamUpBanner != null && (pBStringField = groupTopBannerNotifyPB$GameTeamUpBanner.url) != null && (str3 = pBStringField.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "get()");
                str4 = StringsKt__StringsKt.substringBefore$default(str3, '/', (String) null, 2, (Object) null);
            }
            String str5 = "{bizType:" + i3 + ", bannerType:" + i16 + ", isDisappear:" + z16 + ", isMulti:" + bool + ", teamLeader:" + l3 + ", singleText:" + str + ", multiText:" + str2 + ", url:" + str4 + "...}";
            if (str5 != null) {
                return str5;
            }
        }
        return "null";
    }
}
