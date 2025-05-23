package com.tencent.gdt.tangram.ad.qzone;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes31.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f108419a = "com.tencent.gdt.tangram.ad.qzone.c";

    /* compiled from: P */
    /* loaded from: classes31.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f108420a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f108420a = iArr;
            try {
                iArr[FeedElement.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f108420a[FeedElement.NOTHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f108420a[FeedElement.SUMMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f108420a[FeedElement.RECOMMAD_ACTION_STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f108420a[FeedElement.ACTION_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f108420a[FeedElement.RECOMM_HEADER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f108420a[FeedElement.RECOMM_HEADER_BUTTON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f108420a[FeedElement.TITLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f108420a[FeedElement.RECOMM_CLOSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f108420a[FeedElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f108420a[FeedElement.ADV_MICRO_VIDEO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f108420a[FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_MORE_FRIEND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f108420a[FeedElement.RECOMMEND_OPEN_CANVAS_CLICK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f108420a[FeedElement.LEFT_THUMB_PIC.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f108420a[FeedElement.LEFT_THUMB.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f108420a[FeedElement.CONTENT_EXTERNAL_URL_CLICK.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f108420a[FeedElement.CONTENT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f108420a[FeedElement.RECOMM_ACTION_LEFT_TEXT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f108420a[FeedElement.VISIT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f108420a[FeedElement.USER_AVATAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f108420a[FeedElement.LEFT_THUMB_VIEW_NICKNAME.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f108420a[FeedElement.USER_NICKNAME.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f108420a[FeedElement.AUTO_VIDEO_REPLAY.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f108420a[FeedElement.AUTO_VIDEO_CLICK.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f108420a[FeedElement.AUTO_VIDEO.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f108420a[FeedElement.LOCAL_AD_TITLE_INFO.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f108420a[FeedElement.LOGO_ATTACH.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f108420a[FeedElement.COMMENT_SHOW_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f108420a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f108420a[FeedElement.DETAIL_BOTTOM_AD_TEXT.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
        }
    }

    public static String a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return buildUpon.toString();
        }
        d.c(f108419a, "originalUrl:" + str + " params:" + map);
        return str;
    }

    public static String b(String str, yl0.a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("acttype", "55");
        hashMap.put("feeds_attachment", aVar.k());
        if (!TextUtils.isEmpty(aVar.j())) {
            hashMap.put(ReportConstant.COSTREPORT_PREFIX, aVar.j());
        }
        if (str.contains("__CLICK_LPP__")) {
            str = str.replaceAll("__CLICK_LPP__", aVar.m());
        }
        return a(str, hashMap);
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str + ContainerUtils.FIELD_DELIMITER + str2;
    }

    public static int d(FeedElement feedElement, BusinessFeedData businessFeedData, int i3) {
        switch (a.f108420a[feedElement.ordinal()]) {
            case 1:
                return 5;
            case 2:
                return 1000;
            case 3:
                return 4;
            case 4:
                return 20;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 6;
            case 12:
                return 7;
            case 13:
                return 28;
            case 14:
                return 22;
            case 15:
                return 23;
            case 16:
                return 27;
            case 17:
                return 25;
            case 18:
                return 7;
            case 19:
                return 29;
            case 20:
                return i3 == 3 ? 0 : 2;
            case 21:
                return 24;
            case 22:
                return i3 == 3 ? 0 : 3;
            case 23:
                return 21;
            case 24:
            case 25:
                return 6;
            case 26:
                return 30;
            case 27:
                return 12;
            case 28:
                return 26;
            case 29:
                return 31;
            case 30:
                return 1;
            default:
                return 0;
        }
    }

    public static Context e(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getActivity();
        }
        return null;
    }
}
