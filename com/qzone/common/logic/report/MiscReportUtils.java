package com.qzone.common.logic.report;

import android.text.TextUtils;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.business.lbsv2.business.c;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.report.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MiscReportUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46117a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f46117a = iArr;
            try {
                iArr[FeedElement.FEED_VIEW_EXPOSURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46117a[FeedElement.ADV_CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46117a[FeedElement.USER_AVATAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46117a[FeedElement.USER_DECORATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46117a[FeedElement.TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46117a[FeedElement.USER_NICKNAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46117a[FeedElement.URL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46117a[FeedElement.REFER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46117a[FeedElement.SUMMARY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46117a[FeedElement.CONTENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46117a[FeedElement.PHOTO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46117a[FeedElement.PRAISE_BUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46117a[FeedElement.FORWARD_BUTTON.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f46117a[FeedElement.LIKE_FOLLOW.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f46117a[FeedElement.AUTO_VIDEO_CLICK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f46117a[FeedElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f46117a[FeedElement.FEEDBACK.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static String e(int i3, int i16, int i17) {
        return f.j(i3, i16, i17);
    }

    public static void m(BusinessFeedData businessFeedData) {
        if (businessFeedData.isBabyAlbumFeed()) {
            ClickReport.m("565", "3", "");
        } else if (businessFeedData.isTravelAlbumFeed()) {
            ClickReport.m("565", "3", "");
        }
    }

    public static void n(BusinessFeedData businessFeedData) {
        if (businessFeedData.isBabyAlbumFeed()) {
            ClickReport.m("565", "4", "");
        } else if (businessFeedData.isTravelAlbumFeed()) {
            ClickReport.m("565", "4", "");
        }
    }

    public static void o(String str) {
        ClickReport.e(0, "", 302, 16, 1);
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(28, 1, 0);
        lpReportInfo_pf00064.info = str;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, true);
    }

    public static void b(CellGuiding cellGuiding) {
        if (cellGuiding != null) {
            int i3 = cellGuiding.guiding_type;
            if (i3 == 1) {
                LpReportInfo_pf00064.allReport(619, 4, 2);
            } else if (i3 == 4) {
                LpReportInfo_pf00064.allReport(619, 3, 2);
            }
        }
    }

    public static void c(CellGuiding cellGuiding) {
        if (cellGuiding != null) {
            int i3 = cellGuiding.guiding_type;
            if (i3 == 1) {
                LpReportInfo_pf00064.allReport(619, 4, 1);
                return;
            }
            if (i3 == 4) {
                LpReportInfo_pf00064.allReport(619, 3, 1);
                return;
            }
            int i16 = 2;
            if (i3 != 3) {
                if (i3 == 5) {
                    Map<String, String> map = cellGuiding.extendInfo;
                    if (map != null) {
                        String str = map.get("sub_guide_type");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                if (Integer.valueOf(str).intValue() == 1) {
                                    i16 = 1;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    LpReportInfo_pf00064.allReport(619, 15, 1, String.valueOf(i16));
                    return;
                }
                return;
            }
            ArrayList<User> arrayList = cellGuiding.vecUsers;
            if (arrayList != null) {
                if (arrayList.size() > 2) {
                    LpReportInfo_pf00064.allReport(619, 13, 1, "");
                    return;
                }
                Iterator<User> it = cellGuiding.vecUsers.iterator();
                while (it.hasNext()) {
                    User next = it.next();
                    if (next != null && next.uin > 0) {
                        long uin = LoginData.getInstance().getUin();
                        long j3 = next.uin;
                        if (uin != j3) {
                            LpReportInfo_pf00064.allReport(619, 7, 1, String.valueOf(j3));
                        }
                    }
                }
            }
        }
    }

    public static void g(View view, BusinessFeedData businessFeedData, VideoPlayInfo videoPlayInfo) {
        String str;
        int i3;
        String str2;
        String str3;
        if (businessFeedData == null || businessFeedData.getCellLive() == null || businessFeedData.getAllVideoInfo() == null) {
            return;
        }
        BaseVideo baseVideo = view instanceof BaseVideo ? (BaseVideo) view : null;
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo() != null ? businessFeedData.getOriginalInfo() : null;
        long j06 = i.H().j0();
        long j3 = businessFeedData.getUser() != null ? businessFeedData.getUser().uin : 0L;
        long j16 = (originalInfo == null || originalInfo.getUser() == null) ? 0L : originalInfo.getUser().uin;
        long j17 = (!(j16 == 0 && j06 == j3) && (j16 == 0 || j06 != j16)) ? 2L : 1L;
        if (businessFeedData.getIdInfo() == null) {
            str = "";
        } else {
            str = businessFeedData.getIdInfo().cellId;
        }
        int i16 = businessFeedData.getCellLive() != null ? businessFeedData.getCellLive().roomstat : 0;
        int i17 = 2;
        if (i16 == 2) {
            i16 = 3;
        } else if (i16 == 3) {
            i16 = 2;
        }
        if (j16 == 0) {
            j16 = j3;
        }
        businessFeedData.getAllVideoInfo().isAutoPlay();
        if (businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isFamousSpaceRecommFeed()) {
            i3 = businessFeedData.isThirdLiveVideoFeed() ? businessFeedData.getVideoInfo().videoSource : 1;
        } else {
            i3 = 3;
        }
        if (j16 == 0) {
            str2 = "";
        } else {
            str2 = j3 + "";
        }
        if (baseVideo != null && baseVideo.getState() == 3) {
            i17 = 1;
        }
        if (businessFeedData.getCellLive() == null) {
            str3 = "";
        } else {
            str3 = businessFeedData.getCellLive().roomid;
        }
        QZLog.i("FeedClickProcessor", "luo-log \u76f4\u64ad\u70b9\u51fb\u4e0a\u62a5 reserves3=");
        HashMap hashMap = new HashMap();
        hashMap.put("video_sources", i3 + "");
        hashMap.put("vid", str3);
        hashMap.put("author_uin", j16 + "");
        hashMap.put("shuoshuoid", str);
        hashMap.put("repost_uin", str2);
        hashMap.put("live_user_type", j17 + "");
        hashMap.put("live_state", i16 + "");
        hashMap.put("live_page", "4");
        hashMap.put("reserves3", "");
        LpReportInfo_dc00321.report(8, 113, i17, hashMap, c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
    }

    public static void i(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isFamousSpaceUserFeed()) {
            return;
        }
        ClickReport.d(1002, "2", "1", "1", true);
    }

    public static void j(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isFamousSpaceUserFeed()) {
            return;
        }
        ClickReport.d(1002, "2", "1", "2", true);
    }

    public static void l(BusinessFeedData businessFeedData, boolean z16) {
        if (z16) {
            n(businessFeedData);
        } else {
            m(businessFeedData);
        }
    }

    public static void a(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isCardFriendsRecommendContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 10, 1);
        } else if (businessFeedData.isSpecialCareInContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 11, 1);
        }
    }

    public static void f(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().isFamousRecommAdvFeed() || businessFeedData.getFeedCommInfo().isHotRecommFeed()) {
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(22, 1, i3);
            lpReportInfo_pf00064.info = businessFeedData.getFeedCommInfo().feedskey + "_" + businessFeedData.getFeedCommInfo().getTime();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
        }
    }

    public static void h(View view, BusinessFeedData businessFeedData, int i3, FeedElement feedElement) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        int i16 = a.f46117a[feedElement.ordinal()];
        if (i16 == 2) {
            ClickReport.p("465", "1", "" + (i3 + 1), null, true);
            ClickReport.p("465", "2", null, null, true);
            str = "5";
        } else if (i16 == 3 || i16 == 4 || i16 == 6) {
            str = "8";
        } else if (i16 == 11) {
            str = "7";
        } else if (i16 != 14) {
            if (i16 != 17) {
                str = "0";
            } else {
                str = "6";
            }
        } else if (businessFeedData.getFeedCommInfo().isFollowed) {
            str = "4";
        } else {
            str = "3";
        }
        ClickReport.p("465", str, null, null, true);
    }

    public static void d(View view, BusinessFeedData businessFeedData, int i3, FeedElement feedElement) {
        String valueOf;
        if (i3 < 0 || businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        long j3 = businessFeedData.getFeedCommInfo().recomreportid;
        if (j3 <= 0) {
            return;
        }
        String valueOf2 = String.valueOf(j3);
        String valueOf3 = String.valueOf(i3 + 1);
        switch (a.f46117a[feedElement.ordinal()]) {
            case 1:
            case 2:
                valueOf = String.valueOf(8);
                break;
            case 3:
            case 4:
                valueOf = String.valueOf(2);
                break;
            case 5:
            case 6:
                valueOf = String.valueOf(4);
                break;
            case 7:
                valueOf = String.valueOf(6);
                break;
            case 8:
                valueOf = String.valueOf(3);
                break;
            case 9:
            case 10:
                valueOf = String.valueOf(7);
                break;
            case 11:
                valueOf = String.valueOf(1);
                break;
            case 12:
                valueOf = String.valueOf(9);
                break;
            case 13:
                String valueOf4 = String.valueOf(5);
                if (businessFeedData.getVideoInfo() == null) {
                    valueOf = valueOf4;
                    break;
                } else {
                    valueOf = "13";
                    break;
                }
            case 14:
                if (businessFeedData.getFeedCommInfo().isFollowed) {
                    valueOf = "11";
                    break;
                } else {
                    valueOf = "10";
                    break;
                }
            case 15:
                valueOf = "12";
                break;
            case 16:
                valueOf = "14";
                break;
            default:
                valueOf = "";
                break;
        }
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        ClickReport.r("", "", "", true, valueOf2, valueOf3, valueOf, "0", "");
    }

    public static void k(final CellGuiding cellGuiding, final String str) {
        if (cellGuiding == null || str == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.logic.report.MiscReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String[] split;
                Map<String, String> map = CellGuiding.this.extendInfo;
                if (map == null || (str2 = map.get(str)) == null || (split = str2.split("_")) == null || split.length < 3) {
                    return;
                }
                ClickReport.q(split[0], split[1], split[2], true);
            }
        });
    }

    public static void p() {
    }
}
