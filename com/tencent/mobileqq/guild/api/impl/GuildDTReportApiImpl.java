package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildDTReportApiImpl implements IGuildDTReportApi {
    private static final String TAG = "Guild.report.GuildDTReportApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNearestPageInfoWithPgId$0() {
        return "[getDTPageId] pageInfo is null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNearestPageInfoWithPgId$1() {
        return "[getDTPageId] realView is null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$reportDtEventManual$2(String str) {
        return "[reportDtEventManual] view is null, elementId:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$reportDtEventManual$3(String str) {
        return "[reportDtEventManual] pageInfo is null, elementId:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportDtEventManual$4(View view, final String str, String str2, String str3, Map map) {
        String str4;
        Map<String, Object> map2;
        PageInfo nearestPageInfoWithPgId = getNearestPageInfoWithPgId(view);
        if (nearestPageInfoWithPgId != null) {
            str4 = nearestPageInfoWithPgId.getPageId();
            map2 = getPageInfoParams(nearestPageInfoWithPgId);
        } else {
            Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$reportDtEventManual$3;
                    lambda$reportDtEventManual$3 = GuildDTReportApiImpl.lambda$reportDtEventManual$3(str);
                    return lambda$reportDtEventManual$3;
                }
            });
            str4 = "";
            map2 = null;
        }
        reportDtEventManual(view, str, str4, str2, str3, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$reportDtEventManual$5(String str, String str2, String str3, Map map, Map map2) {
        return "[reportDtEventManual] elementId:" + str + ", pageId:" + str2 + ", eventId:" + str3 + "\uff0cpageParams\uff1a" + map + "\uff0celementParams\uff1a" + map2;
    }

    private void setSourceParam(Map<String, Object> map, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        map.putAll(guildAppReportSourceInfo.getReportInfoMap());
    }

    public String convertToReportValue(int i3, String str) {
        if ("sgrp_user_type".equals(str)) {
            return String.valueOf(com.tencent.mobileqq.guild.data.v.b(i3));
        }
        if ("sgrp_subchannel_type".equals(str)) {
            return String.valueOf(i3);
        }
        if ("sgrp_sub_channel_limit".equals(str)) {
            return String.valueOf(i3);
        }
        return String.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void doReportEvent(String str, Map<String, Object> map) {
        VideoReport.reportEvent(str, map);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public PageInfo getNearestPageInfoWithPgId(View view) {
        ViewGroup viewGroup;
        if (view instanceof BaseWidgetView) {
            viewGroup = ((BaseWidgetView) view).getParentView();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            view = viewGroup;
        }
        if (view != null) {
            PageInfo pageInfo = VideoReport.getPageInfo(view);
            while (pageInfo != null && TextUtils.isEmpty(pageInfo.getPageId())) {
                pageInfo = pageInfo.getParentPage();
            }
            if (pageInfo != null) {
                return pageInfo;
            }
            Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$getNearestPageInfoWithPgId$0;
                    lambda$getNearestPageInfoWithPgId$0 = GuildDTReportApiImpl.lambda$getNearestPageInfoWithPgId$0();
                    return lambda$getNearestPageInfoWithPgId$0;
                }
            });
        } else {
            Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$getNearestPageInfoWithPgId$1;
                    lambda$getNearestPageInfoWithPgId$1 = GuildDTReportApiImpl.lambda$getNearestPageInfoWithPgId$1();
                    return lambda$getNearestPageInfoWithPgId$1;
                }
            });
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public Map<String, Object> getPageInfoParams(PageInfo pageInfo) {
        Object page;
        Map<String, ?> pageParams;
        if (pageInfo != null && (page = pageInfo.getPage()) != null && (pageParams = DataRWProxy.getPageParams(page)) != null) {
            return pageParams;
        }
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void reportDtEventManual(View view, String str, String str2, Map<String, Object> map) {
        reportDtEventManual(view, str, "", str2, map);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setChannelPageParams(View view, @NonNull String str, @NonNull String str2, Map<String, Object> map) {
        if (str2.length() != 0) {
            setChannelPageParams(view, ch.C(ch.m(), str, str2), map);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementClickParams(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementExposureAllAndClickParams(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementExposureAllAndClickPolicy(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementExposureAllPolicy(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementExposureAndClickDynamicParams(View view, String str, IDynamicParams iDynamicParams) {
        VideoReport.setElementId(view, str);
        if (iDynamicParams != null) {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementExposureAndClickParams(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementParams(View view, Map<String, Object> map) {
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setElementReport(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setGuildBasePageParams(String str, Map<String, Object> map) {
        IGProGuildInfo guildInfo;
        IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo == null || (guildInfo = iGPSService.getGuildInfo(channelInfo.getGuildId())) == null) {
            return;
        }
        map.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        map.put("sgrp_channel_id", guildInfo.getGuildID());
        map.put("sgrp_user_type", convertToReportValue(guildInfo.getUserType(), "sgrp_user_type"));
        map.put("sgrp_sub_channel_id", channelInfo.getChannelUin());
        map.put("sgrp_subchannel_type", convertToReportValue(channelInfo.getType(), "sgrp_subchannel_type"));
        map.put("sgrp_sub_channel_limit", convertToReportValue(channelInfo.getTalkPermission(), "sgrp_sub_channel_limit"));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setGuildPageParams(View view, String str, Map<String, Object> map) {
        com.tencent.mobileqq.guild.util.report.a.a(view, str, map);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setListItemElementExposureAndClickParams(View view, String str, String str2, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        String str3 = str2 + "#" + view.hashCode();
        VideoReport.setElementReuseIdentifier(view, str3);
        QLog.d(TAG, 4, "[setListItemElementExposureAndClickParams]  view = " + view + ", id = " + str + ", identifier = " + str3);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setLogicParent(View view, View view2) {
        VideoReport.setLogicParent(view, view2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setOpenGuildSourceParams(Bundle bundle, Map<String, Object> map) {
        if (bundle != null && map != null) {
            Parcelable parcelable = bundle.getParcelable("GuildAppReportSourceInfo");
            if (!(parcelable instanceof GuildAppReportSourceInfo)) {
                QLog.d(TAG, 1, "setOpenGuildSourceParams sourceExtra not exist!");
                return;
            }
            setSourceParam(map, (GuildAppReportSourceInfo) parcelable);
            String string = bundle.getString(JumpGuildParam.EXTRA_KEY_TRACE_ID, "");
            if (!string.isEmpty()) {
                map.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, string);
            }
            map.putAll(com.tencent.mobileqq.guild.report.b.d());
            return;
        }
        QLog.d(TAG, 1, "setOpenGuildSourceParams args error!");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void reportDtEventManual(final View view, final String str, final String str2, final String str3, final Map<String, Object> map) {
        if (view == null) {
            Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$reportDtEventManual$2;
                    lambda$reportDtEventManual$2 = GuildDTReportApiImpl.lambda$reportDtEventManual$2(str);
                    return lambda$reportDtEventManual$2;
                }
            });
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildDTReportApiImpl.this.lambda$reportDtEventManual$4(view, str, str2, str3, map);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void setChannelPageParams(View view, @NonNull IGProChannelInfo iGProChannelInfo, Map<String, Object> map) {
        if (iGProChannelInfo == null) {
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(iGProChannelInfo.getGuildId());
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        map.put("sgrp_sub_channel_id", iGProChannelInfo.getChannelUin());
        if (guildInfo != null) {
            map.put("sgrp_channel_id", guildInfo.getGuildID());
            map.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(guildInfo.getGuildID())));
        } else {
            QLog.e(TAG, 1, "setChannelPageParams error null guildInfo key:", iGProChannelInfo.getGuildId());
        }
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) map));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDTReportApi
    public void reportDtEventManual(View view, final String str, final String str2, String str3, final String str4, final Map<String, Object> map, final Map<String, Object> map2) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        HashMap hashMap2 = hashMap;
        hashMap2.put("dt_pgid", str2);
        if (map2 != null) {
            hashMap2.put("cur_pg", map2);
        }
        Logger.f235387a.b(TAG, new Function0() { // from class: com.tencent.mobileqq.guild.api.impl.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String lambda$reportDtEventManual$5;
                lambda$reportDtEventManual$5 = GuildDTReportApiImpl.lambda$reportDtEventManual$5(str, str2, str4, map2, map);
                return lambda$reportDtEventManual$5;
            }
        });
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str3);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent(str4, view, hashMap2);
    }
}
