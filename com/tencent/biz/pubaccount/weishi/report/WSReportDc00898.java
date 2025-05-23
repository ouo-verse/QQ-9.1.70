package com.tencent.biz.pubaccount.weishi.report;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSPushOpModel;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSReportDc00898 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f81479a = {"frdvideoplay_clk", "frdvideoplay_clk_ws", "frdvideoplay_dl_ws", "frdvideoplay_dl_fin", "frdvideoplay_install"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f81480b = {"qzonevideo_exp_ws", "qzonevideo_clk_ws", "qzonevideo_dl_ws", "qzonevideo_dl_fin", "qzonevideo_install"};

    static /* bridge */ /* synthetic */ String a() {
        return g();
    }

    public static String e(String str, String str2, int i3, int i16, int i17) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        hashMap.put("feed_id", str2);
        hashMap.put("push_id", str);
        hashMap.put("preload_status", Integer.valueOf(i16));
        hashMap.put("feeds_list_type", Integer.valueOf(i17));
        hashMap.put("preload_count", Integer.valueOf(i3));
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, i());
        hashMap.put("ipAddress", p.d());
        return new JSONObject(hashMap).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String f(WSRedDotPushMsg wSRedDotPushMsg) {
        String str;
        int i3;
        String str2;
        HashMap hashMap = new HashMap();
        if (wSRedDotPushMsg != null) {
            str = wSRedDotPushMsg.mFeedIds;
            str2 = wSRedDotPushMsg.mPushId;
            i3 = bb.s(wSRedDotPushMsg);
        } else {
            str = "0";
            i3 = 0;
            str2 = "0";
        }
        hashMap.put("feed_id", str);
        hashMap.put("push_id", str2);
        hashMap.put("preload_status", Integer.valueOf(i3));
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, i());
        hashMap.put("ipAddress", p.d());
        return new JSONObject(hashMap).toString();
    }

    private static String g() {
        HashMap hashMap = new HashMap();
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, i());
        hashMap.put("ipAddress", p.d());
        return new JSONObject(hashMap).toString();
    }

    public static String i() {
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
        if (systemNetwork == 1) {
            return "WiFi";
        }
        if (systemNetwork == 2) {
            return "2G";
        }
        if (systemNetwork == 3) {
            return "3G";
        }
        if (systemNetwork == 4) {
            return "4G";
        }
        return "Other";
    }

    public static void k(int i3, int i16, String str) {
        n("officialacc_weishi", "gzh_clk_H5", i3, 0, i16, 0L, str, "");
    }

    public static void o(final int i3, final Object obj) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.report.WSReportDc00898.1
            @Override // java.lang.Runnable
            public void run() {
                String a16;
                String str;
                int i16;
                int i17 = i3;
                if (i17 == 6) {
                    Object obj2 = obj;
                    if (obj2 instanceof WSRedDotPushMsg) {
                        a16 = WSReportDc00898.f((WSRedDotPushMsg) obj2);
                    } else {
                        a16 = WSReportDc00898.a();
                    }
                    WSReportDc00898.n("officialacc_weishi", "feeds_exp", 0, 0, 0L, 0L, a16, "");
                    return;
                }
                if (i17 == 112) {
                    Object obj3 = obj;
                    if (obj3 instanceof String) {
                        WSReportDc00898.n("officialacc_weishi", "feeds_clk", 0, 0, 0L, 0L, (String) obj3, WSReportDc00898.d());
                        return;
                    }
                    if (obj3 instanceof Integer) {
                        int intValue = ((Integer) obj3).intValue();
                        if (intValue == 2) {
                            WSReportDc00898.n("officialacc_weishi", "feeds_clk_videoplay", 0, 0, 0L, 0L, "", WSReportDc00898.d());
                            return;
                        } else if (intValue == 114) {
                            WSReportDc00898.n("weishi_share_officialacc", "feeds_clk_ws", 0, 0, 0L, 0L, "", WSReportDc00898.d());
                            return;
                        } else {
                            if (intValue != 115) {
                                return;
                            }
                            WSReportDc00898.n("weishi_share_officialacc", "feeds_dl_ws", 0, 0, 0L, 0L, "", WSReportDc00898.d());
                            return;
                        }
                    }
                    return;
                }
                if (i17 == 115) {
                    Object obj4 = obj;
                    if ((obj4 instanceof Integer) && ((Integer) obj4).intValue() == 4) {
                        WSReportDc00898.n("weishi_share_officialacc", "dtest_dl_ws", 0, 0, 0L, 0L, "", WSReportDc00898.d());
                        return;
                    }
                    return;
                }
                if (i17 == 117) {
                    if (obj.getClass().isArray()) {
                        WSReportDc00898.n("officialacc_weishi", "officialacc_quit", 0, (int) ((Long) ((Object[]) obj)[0]).longValue(), ((Integer) r1[1]).intValue(), 0L, p.j(), "");
                        return;
                    }
                    return;
                }
                if (i17 != 141) {
                    switch (i17) {
                        case 301:
                            if (obj.getClass().isArray()) {
                                Object[] objArr = (Object[]) obj;
                                int intValue2 = ((Integer) objArr[0]).intValue();
                                String str2 = (String) objArr[1];
                                String str3 = (String) objArr[2];
                                int intValue3 = ((Integer) objArr[3]).intValue();
                                int intValue4 = ((Integer) objArr[4]).intValue();
                                int intValue5 = ((Integer) objArr[5]).intValue();
                                int intValue6 = ((Integer) objArr[6]).intValue();
                                String e16 = WSReportDc00898.e(str2, str3, intValue3, intValue4, intValue5);
                                if (intValue2 != 2) {
                                    WSReportDc00898.n("officialacc_weishi", "feeds_video_exp", 0, 0, 0L, 0L, p.j(), WSReportDc00898.d());
                                } else {
                                    WSReportDc00898.n("weishi_share_officialacc", "feeds_dl_exp", 0, 0, 0L, 0L, p.j(), WSReportDc00898.d());
                                }
                                i16 = intValue6;
                                str = e16;
                            } else {
                                str = "";
                                i16 = 0;
                            }
                            WSReportDc00898.n("officialacc_weishi", "feeds_exp_cpl", i16, 0, 0L, 0L, str, WSReportDc00898.d());
                            return;
                        case 302:
                            if (obj.getClass().isArray()) {
                                Object[] objArr2 = (Object[]) obj;
                                WSReportDc00898.n("officialacc_weishi", "feeds_load_fail", ((Integer) objArr2[0]).intValue(), 0, ((Long) objArr2[1]).longValue(), 0L, "", "");
                                return;
                            }
                            return;
                        case 303:
                            Object obj5 = obj;
                            if (obj5 instanceof String) {
                                WSReportDc00898.n("officialacc_weishi", "single_video_exp", 0, 0, 0L, 0L, (String) obj5, WSReportDc00898.d());
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                Object obj6 = obj;
                if (obj6 instanceof String) {
                    WSReportDc00898.n("officialacc_weishi", "push_video_clk", 0, 0, 0L, 0L, (String) obj6, WSReportDc00898.d());
                }
            }
        });
    }

    public static void p() {
        n("officialacc_weishi", "feeds_clk", 0, 0, -1L, 0L, "", d());
        n("weishi_share_officialacc", "feeds_clk_ws", 0, 0, -1L, 0L, "", d());
    }

    public static void q() {
        n(f.f(), "focus_exp", 0, 0, 0L, 0L, p.j(), bb.x(9));
    }

    public static void t(int i3, int i16, int i17) {
        x.l("898", "optionId:" + i17);
        String x16 = bb.x(4);
        String valueOf = String.valueOf(i17);
        if (i3 == 6) {
            n("weishi_share_officialacc", "msg_entry_exp", i16, 0, 0L, 0L, valueOf, x16);
            return;
        }
        if (i3 == 112) {
            n("weishi_share_officialacc", "msg_clk", i16, 0, 0L, 0L, valueOf, x16);
            return;
        }
        if (i3 == 140) {
            n("weishi_share_officialacc", "msg_clk_h5", i16, 0, 0L, 0L, valueOf, x16);
        } else if (i3 == 114) {
            n("weishi_share_officialacc", "msg_clk_ws", i16, 0, 0L, 0L, valueOf, x16);
        } else {
            if (i3 != 115) {
                return;
            }
            n("weishi_share_officialacc", "msg_dl_ws", i16, 0, 0L, 0L, valueOf, x16);
        }
    }

    public static void v(Map<String, String> map) {
        n(f.f(), "recommend_report_fail", 0, 0, 0L, 0L, new JSONObject(map).toString(), "");
    }

    public static void w(int i3, int i16, int i17) {
        x.f("898", "optionId:" + i17);
        String valueOf = String.valueOf(i17);
        if (i3 == 6) {
            n("weishi_share_officialacc", "feeds_popup_exp", i16, 0, 0L, 0L, valueOf, d());
            return;
        }
        if (i3 == 112) {
            n("weishi_share_officialacc", "feeds_popup_clk", i16, 0, 0L, 0L, valueOf, d());
            return;
        }
        if (i3 == 117) {
            n("officialacc_weishi", "feeds_popup_close", i16, 0, 0L, 0L, valueOf, d());
        } else if (i3 == 114) {
            n("weishi_share_officialacc", "feeds_popup_clk_ws", i16, 0, 0L, 0L, valueOf, d());
        } else {
            if (i3 != 115) {
                return;
            }
            n("weishi_share_officialacc", "feeds_popup_dl_ws", i16, 0, 0L, 0L, valueOf, d());
        }
    }

    public static void y(int i3) {
        n("trandstab_weishi", "trandstab_clk_H5", i3, 0, 0L, 0L, "", "");
    }

    public static void z() {
        n("trandstab_weishi", "push_clk", 0, 0, 0L, 0L, "", "");
    }

    public static String d() {
        return bb.x(1);
    }

    public static void n(String str, String str2, int i3, int i16, long j3, long j16, String str3, String str4) {
        ReportController.o(null, "dc00898", "", "", b(str), b(str2), i3, i16, String.valueOf(j3), String.valueOf(j16), str3, str4);
    }

    public static void A(WSRedDotPushMsg wSRedDotPushMsg) {
        int i3;
        String str;
        if (wSRedDotPushMsg != null) {
            IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
            if (iWSPushBaseStrategy instanceof WSPushStrategyInfo) {
                WSPushStrategyInfo wSPushStrategyInfo = (WSPushStrategyInfo) iWSPushBaseStrategy;
                WSPushOpModel wSPushOpModel = wSPushStrategyInfo.mWSPushModel;
                int i16 = wSPushOpModel != null ? wSPushOpModel.f81333d : 0;
                r2 = wSPushStrategyInfo.getType();
                i3 = i16;
            } else {
                i3 = 0;
            }
            if (r2 == 3) {
                r2 = 1;
            }
            int i17 = r2;
            long j3 = l.c(BaseApplicationImpl.getApplication().getApplicationContext()) ? 1L : 0L;
            long j16 = i3;
            String str2 = wSRedDotPushMsg.mPushId;
            if (iWSPushBaseStrategy != null) {
                str = iWSPushBaseStrategy.getAbTest();
            } else {
                str = "";
            }
            n("officialacc_weishi", "push_text_clk", i17, 0, j3, j16, str2, str);
        }
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static String h(int i3, stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null) {
            return "";
        }
        stWaterFallCardStyle stwaterfallcardstyle = stsimplemetafeed.waterFallCardStyle;
        HashMap hashMap = new HashMap();
        hashMap.put("position", Integer.valueOf(i3 + 1));
        hashMap.put("cardtype", Integer.valueOf(stwaterfallcardstyle != null ? stwaterfallcardstyle.cardType : 1));
        hashMap.put("feedid", stsimplemetafeed.f25129id);
        hashMap.put("poolType", Integer.valueOf(stsimplemetafeed.videoPoolType));
        hashMap.put("ratioW", Integer.valueOf(stwaterfallcardstyle != null ? stwaterfallcardstyle.ratioW : 0));
        hashMap.put("ratioH", Integer.valueOf(stwaterfallcardstyle != null ? stwaterfallcardstyle.ratioH : 0));
        hashMap.put("isFullSpan", Boolean.valueOf(stwaterfallcardstyle != null && stwaterfallcardstyle.isFullSpan));
        hashMap.put("dynamic_cover", 0);
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, bb.i(stsimplemetafeed));
        return new JSONObject(hashMap).toString();
    }

    public static void m(boolean z16) {
        if (z16) {
            n("officialacc_weishi", "blanktips_clk", 0, 0, 0L, 0L, "", "");
        } else {
            n("officialacc_weishi", "blanktips_exp", 0, 0, 0L, 0L, "", "");
        }
    }

    public static void r(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        if (eVar == null || eVar.f81127c == null) {
            return;
        }
        n(f.f(), "focus_video_play", 0, 0, 0L, 0L, new Gson().toJson(com.tencent.biz.pubaccount.weishi.report.dc898.d.a(eVar, z16)), bb.x(9));
    }

    public static void s(boolean z16) {
        if (z16) {
            n("weishi_share_zhibo", "zhibo_feeds_clk", 0, 0, 0L, 0L, "", d());
        } else {
            n("weishi_share_zhibo", "zhibo_feeds_exp", 0, 0, 0L, 0L, "", d());
        }
    }

    public static void u(int i3, int i16, int i17, int i18) {
        int i19 = i17 + 1;
        x.f("898", "optionId:" + i18);
        String valueOf = String.valueOf(i18);
        if (i3 == 6) {
            n("weishi_share_officialacc", "feeds_op_card_exp", i16, 0, i19, 0L, valueOf, d());
            return;
        }
        if (i3 == 112) {
            n("weishi_share_officialacc", "feeds_op_card_clk", i16, 0, i19, 0L, valueOf, d());
            return;
        }
        if (i3 == 140) {
            n("weishi_share_officialacc", "feeds_opcard_clk_h5", i16, 0, i19, 0L, valueOf, d());
        } else if (i3 == 114) {
            n("weishi_share_officialacc", "feeds_opcard_clk_ws", i16, 0, i19, 0L, valueOf, d());
        } else {
            if (i3 != 115) {
                return;
            }
            n("weishi_share_officialacc", "feeds_opcard_dl_ws", i16, 0, i19, 0L, valueOf, d());
        }
    }

    public static void x(WSRedDotPushMsg wSRedDotPushMsg, boolean z16) {
        String str;
        IWSPushBaseStrategy iWSPushBaseStrategy;
        int type = (wSRedDotPushMsg == null || (iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo) == null) ? 0 : iWSPushBaseStrategy.getType();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        n("trandstab_weishi", "trandstab_clk", type, 0, 0L, 0L, str, "");
    }

    private static String c(int i3) {
        if (i3 == 1) {
            return "weishi_share_officialacc";
        }
        if (i3 == 2) {
            return "weishi_share_trendstab";
        }
        return "";
    }

    public static void j(boolean z16, WSDownloadParams wSDownloadParams) {
        if (wSDownloadParams == null) {
            return;
        }
        String c16 = c(wSDownloadParams.mScene);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        if (z16) {
            n(c16, "dl_clk_QQdownloader", 0, 0, 0L, 0L, "", wSDownloadParams.mTestId);
        } else {
            n(c16, "dl_clk_officialdownloader", iz.a.g().b(), 0, 0L, 0L, "", wSDownloadParams.mTestId);
        }
    }

    public static void l(WSDownloadParams wSDownloadParams, int i3) {
        if (wSDownloadParams == null) {
            return;
        }
        n("weishi_share_officialacc", "start_dl_ws", i3, 0, iz.a.g().b(), 0L, "", wSDownloadParams.mTestId);
    }
}
