package com.tencent.mobileqq.guild.api.impl;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQGuildJubaoApiImpl implements IQQGuildJubaoApi {
    public static final String TAG = "QQGuildJubaoApiImpl";

    private String buildCommentAndReplyReportContent(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("feedid=");
        sb5.append(str);
        sb5.append("|commentid=");
        sb5.append(str2);
        if (str3 != null) {
            sb5.append("|replyid=");
            sb5.append(str3);
        }
        return sb5.toString();
    }

    private static long getLiveRoomId(Activity activity, String str) {
        IGProChannelInfo channelInfo;
        if (!(activity instanceof QBaseActivity) || (channelInfo = ((IGPSService) ((QBaseActivity) activity).getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(str)) == null) {
            return 0L;
        }
        return channelInfo.getLiveRoomId();
    }

    private boolean isGuildFeedReport(int i3) {
        if (i3 != 10123 && i3 != 10124 && i3 != 10125) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportGuildFeed$0(String str, String str2, String str3, Function1 function1, int i3) {
        QLog.d(TAG, 1, "reportGuildFeed cb  feedId:" + str + " g:" + str2 + " c:" + str3 + " s:" + i3);
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i3));
        }
    }

    private String stringToEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("stringToEncode %s", str), e16);
            }
            return str;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void actionSheetReport(QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, int i3, String str5, int i16, String str6, String str7, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("isdirectmsg", z16 ? 1 : 0);
        doAIOJumpReport(qBaseActivity, i3, str, str2, str3, getContentId(qBaseActivity, i3, str, str7), str5, str7, str3, i16, str6, bundle);
    }

    public void doAIOJumpReport(Context context, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i16, String str8, Bundle bundle) {
        try {
            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
            bVar.i(String.valueOf(i3));
            bVar.n(str);
            bVar.j(str2);
            bVar.r(str3);
            if (isGuildFeedReport(i3)) {
                bVar.m(str4);
                bVar.v(stringToEncode("chatmsg:"));
            } else {
                if (!TextUtils.isEmpty(str4)) {
                    bVar.m(str4);
                } else {
                    bVar.m("anonymousseq=0");
                }
                bVar.v(stringToEncode(str5));
            }
            bVar.l(str6);
            bVar.q(str7);
            bVar.k(String.valueOf(10014));
            if (!TextUtils.isEmpty(str8)) {
                bVar.u(str8);
                bVar.t(String.valueOf(i16));
            }
            bVar.o(2);
            bVar.s(0);
            bVar.x(stringToEncode("REPORT_IP=0&EVIL_IP=0"));
            if (bundle != null) {
                bVar.p(bundle);
            }
            ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doJumpReport exception: " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void reportGuild(QBaseActivity qBaseActivity, String str, String str2, int i3, boolean z16) {
        doJumpReport(qBaseActivity, i3, str, "0", str, "", "", str2, "");
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void reportGuildFeed(Context context, String str, final String str2, final String str3, final String str4, final Function1<Integer, Unit> function1) {
        try {
            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
            bVar.i(String.valueOf(100868));
            bVar.n(str);
            bVar.j("0");
            bVar.r(str3);
            bVar.m("feedid=" + str2);
            bVar.v(stringToEncode("chatmsg:"));
            bVar.l(str4);
            bVar.q(str3);
            bVar.k(String.valueOf(10014));
            bVar.o(2);
            bVar.s(0);
            bVar.x(stringToEncode("REPORT_IP=0&EVIL_IP=0"));
            ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar, new com.tencent.mobileqq.dt.api.d() { // from class: com.tencent.mobileqq.guild.api.impl.z
                @Override // com.tencent.mobileqq.dt.api.d
                public final void a(int i3) {
                    QQGuildJubaoApiImpl.lambda$reportGuildFeed$0(str2, str3, str4, function1, i3);
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "reportGuildFeed crazy error:" + e16);
        }
        QLog.d(TAG, 1, "reportGuildFeed: feedId:" + str2 + " g:" + str3 + " c:" + str4);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void reportGuildFeedCommentAndReply(Context context, String str, String str2, String str3, String str4, String str5, String str6, final Function1<Integer, Unit> function1) {
        try {
            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
            if (str6 == null) {
                bVar.i(String.valueOf(100897));
            } else {
                bVar.i(String.valueOf(100898));
            }
            bVar.n(str4);
            bVar.j("0");
            bVar.r(str);
            String buildCommentAndReplyReportContent = buildCommentAndReplyReportContent(str3, str5, str6);
            bVar.m(buildCommentAndReplyReportContent);
            bVar.v(stringToEncode("chatmsg:"));
            bVar.l(str2);
            bVar.q(str);
            bVar.k(String.valueOf(10014));
            bVar.o(2);
            bVar.s(1);
            bVar.x(stringToEncode("REPORT_IP=0&EVIL_IP=0"));
            QLog.d(TAG, 1, "reportGuildFeedCommentAndReply Info: evilUin=" + str4 + " contentId=" + buildCommentAndReplyReportContent);
            ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar, new com.tencent.mobileqq.dt.api.d() { // from class: com.tencent.mobileqq.guild.api.impl.aa
                @Override // com.tencent.mobileqq.dt.api.d
                public final void a(int i3) {
                    QQGuildJubaoApiImpl.lambda$reportGuildFeedCommentAndReply$1(Function1.this, i3);
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "reportGuildFeedCommentAndReply Error: " + e16.getMessage());
        }
    }

    public void doJumpReport(Context context, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        doAIOJumpReport(context, i3, str, str2, str3, str4, str5, str6, str7, 0, "", null);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void reportGuild(QBaseActivity qBaseActivity, String str, String str2, String str3, boolean z16, boolean z17) {
        Bundle bundle = new Bundle();
        if (z16) {
            bundle.putInt("is_need_open_channel_select_fragment", 1);
        } else {
            bundle.putInt("is_need_open_channel_select_fragment", 0);
        }
        bundle.putInt("isdirectmsg", z17 ? 1 : 0);
        doAIOJumpReport(qBaseActivity, COMM.mini_app_operation_admin, str3, "0", str, "", "", str2, str, 0, "", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportGuildFeedCommentAndReply$1(Function1 function1, int i3) {
        if (function1 != null) {
            QLog.d(TAG, 1, "reportGuildFeedCommentAndReply Callback: status=" + i3);
            function1.invoke(Integer.valueOf(i3));
        }
    }

    private String getContentId(Activity activity, int i3, String str, String str2) {
        if (i3 == 25099) {
            String str3 = "channel_id=" + str2 + "|tinyid=" + str;
            long liveRoomId = getLiveRoomId(activity, str2);
            if (liveRoomId == 0) {
                return str3;
            }
            return str3 + "|roomid=" + liveRoomId;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
    public void reportGuild(QBaseActivity qBaseActivity, String str, String str2, int i3, String str3, String str4) {
        doJumpReport(qBaseActivity, i3, str3, "0", str, str4, "", str2, str);
    }
}
