package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.adapter.d;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.troop.flock.QeventPB$ActivityTime;
import tencent.im.troop.flock.QeventPB$Feed;
import tencent.im.troop.flock.QeventPB$FeedTagInfo;
import tencent.im.troop.flock.QeventPB$JoinInfo;
import tencent.im.troop.flock.QeventPB$PoiInfo;
import tencent.im.troop.flock.QeventPB$User;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J6\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\n\u0010\u000e\u001a\u00020\r*\u00020\fJ\n\u0010\u000f\u001a\u00020\u0004*\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\rJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\rJ,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\rJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\rJ\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\rJ\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u001f\u001a\u00020\u001eJ\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\r\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/AddContactReportHelper;", "", "Landroid/view/View;", DTConstants.TAG.ELEMENT, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, "", "params", "", "a", IECDtReport.ACTION_IDENTIFIER, "c", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "", "p", "o", "type", "position", "l", "j", "k", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "troopItem", "Ltencent/im/troop/flock/QeventPB$Feed;", "flockData", "recommendRank", "g", "f", "i", h.F, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "personItem", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactReportHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final AddContactReportHelper f180887a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        public static final /* synthetic */ int[] f180888a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49806);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180888a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f180887a = new AddContactReportHelper();
        }
    }

    AddContactReportHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(AddContactReportHelper addContactReportHelper, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        addContactReportHelper.a(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(AddContactReportHelper addContactReportHelper, View view, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        addContactReportHelper.c(view, str, str2, map);
    }

    public final void a(@NotNull View r75, @NotNull String r85, @Nullable Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, r75, r85, params);
            return;
        }
        Intrinsics.checkNotNullParameter(r75, "element");
        Intrinsics.checkNotNullParameter(r85, "reportKey");
        VideoReport.setElementId(r75, r85);
        if (params != null) {
            VideoReport.setElementParams(r75, params);
        }
        VideoReport.setElementExposePolicy(r75, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(r75, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(r75, ClickPolicy.REPORT_ALL);
    }

    public final void c(@NotNull View r56, @NotNull String r65, @NotNull String r75, @Nullable Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, r56, r65, r75, params);
            return;
        }
        Intrinsics.checkNotNullParameter(r56, "element");
        Intrinsics.checkNotNullParameter(r65, "reportKey");
        Intrinsics.checkNotNullParameter(r75, "identifier");
        a(r56, r65, params);
        VideoReport.setElementReuseIdentifier(r56, r75);
    }

    @NotNull
    public final Map<String, String> e(@NotNull QeventPB$Feed flockData, int recommendRank) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Object firstOrNull;
        String str6;
        Map<String, String> mapOf;
        PBStringField pBStringField;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Map) iPatchRedirector.redirect((short) 15, (Object) this, (Object) flockData, recommendRank);
        }
        Intrinsics.checkNotNullParameter(flockData, "flockData");
        QeventPB$JoinInfo qeventPB$JoinInfo = flockData.join_info.get();
        String str7 = "";
        if (qeventPB$JoinInfo == null || (pBUInt32Field = qeventPB$JoinInfo.count) == null || (str = Integer.valueOf(pBUInt32Field.get()).toString()) == null) {
            str = "";
        }
        QeventPB$PoiInfo qeventPB$PoiInfo = flockData.poi_info.get();
        if (qeventPB$PoiInfo == null || (pBStringField3 = qeventPB$PoiInfo.name) == null || (str2 = pBStringField3.get()) == null) {
            str2 = "";
        }
        QeventPB$User qeventPB$User = flockData.publisher.get();
        String str8 = null;
        if (qeventPB$User != null && (pBStringField2 = qeventPB$User.nick) != null) {
            str3 = pBStringField2.get();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        QeventPB$ActivityTime qeventPB$ActivityTime = flockData.activity_time.get();
        if (qeventPB$ActivityTime == null || (pBUInt64Field2 = qeventPB$ActivityTime.start_time) == null || (str4 = Long.valueOf(pBUInt64Field2.get()).toString()) == null) {
            str4 = "";
        }
        if (qeventPB$ActivityTime == null || (pBUInt64Field = qeventPB$ActivityTime.end_time) == null || (str5 = Long.valueOf(pBUInt64Field.get()).toString()) == null) {
            str5 = "";
        }
        List<QeventPB$FeedTagInfo> list = flockData.tag_infos.get();
        Intrinsics.checkNotNullExpressionValue(list, "flockData.tag_infos.get()");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        QeventPB$FeedTagInfo qeventPB$FeedTagInfo = (QeventPB$FeedTagInfo) firstOrNull;
        if (qeventPB$FeedTagInfo != null && (pBStringField = qeventPB$FeedTagInfo.tag_name) != null) {
            str6 = pBStringField.get();
        } else {
            str6 = null;
        }
        if (str6 == null) {
            str6 = "";
        }
        ByteStringMicro byteStringMicro = flockData.recom_trace.get();
        if (byteStringMicro != null) {
            str8 = byteStringMicro.toStringUtf8();
        }
        if (str8 != null) {
            str7 = str8;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("activity_result_id", flockData.f436058id.get()), TuplesKt.to("activity_name", flockData.title.get()), TuplesKt.to("participants_num", str), TuplesKt.to("activity_location", str2), TuplesKt.to("publisher_event_results", str3), TuplesKt.to("group_id", String.valueOf(flockData.group_id.get())), TuplesKt.to("activity_start_time", str4), TuplesKt.to("activity_end_time", str5), TuplesKt.to("activity_topic", str6), TuplesKt.to("recommand_rank", String.valueOf(recommendRank)), TuplesKt.to("activity_extension_field", str7));
        return mapOf;
    }

    @NotNull
    public final Map<String, String> f(@NotNull RecommendTroopItem troopItem) {
        String str;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopItem);
        }
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        if (troopItem.isJoined()) {
            str = "3";
        } else if (troopItem.hasRequestJoin) {
            str = "2";
        } else {
            str = "1";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, str));
        return mapOf;
    }

    @NotNull
    public final Map<String, String> g(@NotNull RecommendTroopItem troopItem, @Nullable QeventPB$Feed flockData, int recommendRank) {
        Object obj;
        String joinToString$default;
        String str;
        Map<String, String> mapOf;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, this, troopItem, flockData, Integer.valueOf(recommendRank));
        }
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("group_name", troopItem.name);
        String str2 = "1";
        if (d.b(troopItem)) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("group_state", obj);
        pairArr[2] = TuplesKt.to("group_id", troopItem.uin);
        List<oidb_0x9fb$Label> list = troopItem.labelList;
        Intrinsics.checkNotNullExpressionValue(list, "troopItem.labelList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, AddContactReportHelper$getGroupItemReportParams$1.INSTANCE, 30, null);
        pairArr[3] = TuplesKt.to("recommand_tag", joinToString$default);
        pairArr[4] = TuplesKt.to("recommand_rank", String.valueOf(recommendRank));
        if (flockData == null) {
            str2 = "0";
        }
        pairArr[5] = TuplesKt.to("is_new_group_subactivity", str2);
        if (flockData != null && (pBStringField = flockData.title) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[6] = TuplesKt.to("partner_tag", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @NotNull
    public final Map<String, String> h(@NotNull RecommendTroopItem troopItem) {
        String str;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopItem);
        }
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        if (troopItem.isJoined()) {
            str = "3";
        } else {
            str = "1";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, str));
        return mapOf;
    }

    @NotNull
    public final Map<String, String> i(@NotNull RecommendTroopItem troopItem, int recommendRank) {
        String joinToString$default;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopItem, recommendRank);
        }
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        List<oidb_0x9fb$Label> list = troopItem.labelList;
        Intrinsics.checkNotNullExpressionValue(list, "troopItem.labelList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, AddContactReportHelper$getGuildItemReportParams$1.INSTANCE, 30, null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, troopItem.name), TuplesKt.to("channel_active_status", String.valueOf(d.a(troopItem))), TuplesKt.to("channel_id", troopItem.uin), TuplesKt.to("recommand_tag", joinToString$default), TuplesKt.to("recommand_rank", String.valueOf(recommendRank)));
        return mapOf;
    }

    @NotNull
    public final String j(@NotNull AddContactDataType type, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) type, position);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        return type + "|content|" + position;
    }

    @NotNull
    public final String k(@NotNull AddContactDataType type, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) type, position);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        return type + "|del|" + position;
    }

    @NotNull
    public final String l(@NotNull AddContactDataType type, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) type, position);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        return type + "|op|" + position;
    }

    @NotNull
    public final Map<String, String> m(@NotNull MayKnowRecommend personItem) {
        String str;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Map) iPatchRedirector.redirect((short) 14, (Object) this, (Object) personItem);
        }
        Intrinsics.checkNotNullParameter(personItem, "personItem");
        int i3 = personItem.friendStatus;
        if (i3 != 1) {
            if (i3 != 2) {
                str = "1";
            } else {
                str = "3";
            }
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, str));
        return mapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        r11 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.AddContactReportHelper$getPersonItemReportParams$1.INSTANCE, 30, null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, String> n(@NotNull MayKnowRecommend personItem, int i3) {
        String str;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Map) iPatchRedirector.redirect((short) 13, (Object) this, (Object) personItem, i3);
        }
        Intrinsics.checkNotNullParameter(personItem, "personItem");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("nickname", personItem.nick);
        pairArr[1] = TuplesKt.to("touin", personItem.uin);
        List<MayKnowRecommend.MayKnowRecommendLabel> list = personItem.msgLabel;
        if (list == null || str == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("recommand_tag", str);
        pairArr[3] = TuplesKt.to("recommand_rank", String.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @NotNull
    public final String o(@NotNull AddContactDataType addContactDataType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) addContactDataType);
        }
        Intrinsics.checkNotNullParameter(addContactDataType, "<this>");
        int i3 = a.f180888a[addContactDataType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return "em_bas_search_events_possible_interest";
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "em_bas_search_channel_possible_interest";
            }
            return "em_bas_search_groups_possible_interest";
        }
        return "em_bas_search_person_possible_interest";
    }

    public final int p(@NotNull AddContactDataType addContactDataType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) addContactDataType)).intValue();
        }
        Intrinsics.checkNotNullParameter(addContactDataType, "<this>");
        int i3 = a.f180888a[addContactDataType.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    if (i3 == 4) {
                        return 4;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return i16;
    }
}
