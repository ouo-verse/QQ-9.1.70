package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.URLUtil;
import com.vivo.push.PushClientConstants;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchUtils extends com.tencent.mobileqq.search.util.a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f284952a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f284953b = false;

    /* renamed from: c, reason: collision with root package name */
    public static long f284954c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static long f284955d = -1;

    /* renamed from: l, reason: collision with root package name */
    public static long f284963l;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<String, String> f284956e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public static long f284957f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f284958g = 11;

    /* renamed from: h, reason: collision with root package name */
    public static int f284959h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static char[] f284960i = {',', '.', Typography.ellipsis, '\uff0c', '\u3002', '\uff1f', '\uff01', '\uff5e', '#', '\uff1a', '\u3001', Typography.leftDoubleQuote, Typography.rightDoubleQuote, Typography.leftSingleQuote, Typography.rightSingleQuote, '\uff08', '\uff09', '-', Typography.mdash, '\uff1b', '@', '@', '#', Typography.times, '%', '%', '.', Typography.middleDot, '/', '\\', '\u300a', '\u300b', '\u3010', '\u3011', Typography.less, Typography.greater};

    /* renamed from: j, reason: collision with root package name */
    public static int f284961j = 0;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public static Paint f284962k = null;

    /* renamed from: m, reason: collision with root package name */
    public static HashMap<com.tencent.mobileqq.search.model.y, d> f284964m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap<com.tencent.mobileqq.search.model.v, d> f284965n = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f284969a = Long.MIN_VALUE;

        /* renamed from: b, reason: collision with root package name */
        public int f284970b;

        /* renamed from: c, reason: collision with root package name */
        public String f284971c;

        /* renamed from: d, reason: collision with root package name */
        public String f284972d;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f284976a;

        /* renamed from: b, reason: collision with root package name */
        public long f284977b;

        /* renamed from: c, reason: collision with root package name */
        public int f284978c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f284979d;

        /* renamed from: e, reason: collision with root package name */
        public String f284980e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f284981f;
    }

    public static int A() {
        int color = MobileQQ.sMobileQQ.getResources().getColor(R.color.f157941an0);
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, "")) {
            return MobileQQ.sMobileQQ.getResources().getColor(R.color.f157942an1);
        }
        return color;
    }

    public static void A0(Context context, int i3, int i16) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).handleFeatureJump(context, i3, i16);
    }

    public static c B(CharSequence charSequence, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessage" + ((Object) charSequence) + "|" + str);
        }
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(str)) {
            String lowerCase = charSequence.toString().toLowerCase();
            int indexOf = lowerCase.indexOf(str);
            int length = str.length();
            if (indexOf < 0 && (indexOf = lowerCase.indexOf((str = str.toLowerCase()))) < 0) {
                if (z16) {
                    int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, str, 1);
                    int i3 = d16[0];
                    if (i3 >= 0) {
                        length = d16[1];
                        indexOf = i3;
                    } else {
                        int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, str, 2);
                        indexOf = d17[0];
                        if (indexOf >= 0) {
                            length = d17[1];
                        } else {
                            return new c(charSequence);
                        }
                    }
                } else {
                    return new c(charSequence);
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int i16 = indexOf;
            while (i16 >= 0 && i16 < spannableStringBuilder.length()) {
                int i17 = i16 + length;
                if (i17 > spannableStringBuilder.length() || length <= 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), i16, i17, 17);
                i16 = lowerCase.indexOf(str, i17);
            }
            return new c(spannableStringBuilder, indexOf, length);
        }
        return new c(charSequence);
    }

    public static boolean B0(AppInterface appInterface, String str, boolean z16) {
        return ((IAddFriendServiceApi) appInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, z16, false);
    }

    public static CharSequence C(String str, String str2) {
        return D(str, str2, 10);
    }

    public static boolean C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!Pattern.compile("^#[0-9a-fA-F]{3}|^#[0-9a-fA-F]{6}$|^#[0-9a-fA-F]{8}$").matcher(str.trim()).matches()) {
            return false;
        }
        return true;
    }

    public static CharSequence D(String str, String str2, int i3) {
        return E(str, str2, i3, true);
    }

    public static boolean D0(long j3) {
        return ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).isEntityGroup(j3);
    }

    public static CharSequence E(String str, String str2, int i3, boolean z16) {
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf(str2);
        int length = str2.length();
        if (indexOf < 0 && (indexOf = lowerCase.indexOf((str2 = str2.toLowerCase()))) < 0) {
            if (z16) {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, str2, 1);
                int i16 = d16[0];
                if (i16 >= 0) {
                    length = d16[1];
                    indexOf = i16;
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, str2, 2);
                    int i17 = d17[0];
                    if (i17 >= 0) {
                        int i18 = d17[1];
                        indexOf = i17;
                        length = i18;
                    } else {
                        return new SpannableStringBuilder(str);
                    }
                }
            } else {
                return new SpannableStringBuilder(str);
            }
        }
        if (indexOf > i3 || (indexOf > 4 && indexOf + length > i3)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u2026");
            int i19 = indexOf - 4;
            sb5.append(str.substring(i19));
            str = sb5.toString();
            lowerCase = "\u2026" + lowerCase.substring(i19);
            indexOf = 5;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (indexOf >= 0) {
            int i26 = length + indexOf;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), indexOf, i26, 17);
            indexOf = lowerCase.indexOf(str2, i26);
            length = str2.length();
        }
        return spannableStringBuilder;
    }

    public static boolean E0(AppInterface appInterface, String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "Q.uniteSearch.SearchUtils");
    }

    public static CharSequence F(CharSequence charSequence, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessage" + ((Object) charSequence) + "|" + str);
        }
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(str)) {
            String lowerCase = charSequence.toString().toLowerCase();
            int indexOf = lowerCase.indexOf(str);
            int length = str.length();
            if (indexOf < 0 && (indexOf = lowerCase.indexOf((str = str.toLowerCase()))) < 0) {
                if (z16) {
                    int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, str, 1);
                    int i3 = d16[0];
                    if (i3 >= 0) {
                        length = d16[1];
                        indexOf = i3;
                    } else {
                        int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, str, 2);
                        indexOf = d17[0];
                        if (indexOf >= 0) {
                            length = d17[1];
                        }
                    }
                }
                return charSequence;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            while (indexOf >= 0 && indexOf < spannableStringBuilder.length()) {
                int i16 = indexOf + length;
                if (i16 > spannableStringBuilder.length() || length <= 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(A()), indexOf, i16, 17);
                indexOf = lowerCase.indexOf(str, i16);
            }
            return spannableStringBuilder;
        }
        return charSequence;
    }

    public static boolean F0(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 10 || i3 == 28 || i3 == 21 || i3 == 22) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static CharSequence G(String str, String str2, boolean z16) {
        boolean z17;
        int i3;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int indexOf = lowerCase.indexOf(lowerCase2);
        int length = lowerCase2.length();
        if (indexOf < 0) {
            if (z16) {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 1);
                indexOf = d16[0];
                if (indexOf >= 0) {
                    i3 = d16[1];
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 2);
                    indexOf = d17[0];
                    if (indexOf >= 0) {
                        i3 = d17[1];
                    } else {
                        return new SpannableStringBuilder(str);
                    }
                }
                length = i3;
                z17 = false;
            } else {
                return new SpannableStringBuilder(str);
            }
        } else {
            z17 = true;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (true) {
            int i16 = indexOf + length;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), indexOf, i16, 17);
            if (z17) {
                indexOf = lowerCase.indexOf(lowerCase2, i16);
                length = lowerCase2.length();
                if (indexOf >= 0) {
                    z17 = true;
                } else {
                    return spannableStringBuilder;
                }
            } else {
                int[] d18 = com.tencent.mobileqq.search.util.a.d(lowerCase.substring(i16), lowerCase2, 1);
                int i17 = d18[0];
                if (i17 >= 0) {
                    int i18 = i17 + indexOf + length;
                    length = d18[1];
                    indexOf = i18;
                } else {
                    int[] d19 = com.tencent.mobileqq.search.util.a.d(lowerCase.substring(i16), lowerCase2, 2);
                    int i19 = d19[0];
                    if (i19 >= 0) {
                        int i26 = i19 + indexOf + length;
                        length = d19[1];
                        indexOf = i26;
                    } else {
                        return spannableStringBuilder;
                    }
                }
            }
        }
    }

    public static boolean G0(com.tencent.mobileqq.search.model.y yVar) {
        return ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).isGuildModel(yVar);
    }

    public static CharSequence H(AppInterface appInterface, String str, String str2, int i3) {
        int i16;
        String str3 = str;
        if (f284962k == null) {
            f284962k = ((TextView) LayoutInflater.from(appInterface.getApp()).inflate(R.layout.bxl, (ViewGroup) null).findViewById(R.id.title)).getPaint();
            if (f284961j == 0) {
                f284961j = appInterface.getApp().getResources().getDimensionPixelOffset(R.dimen.aj_);
            }
        }
        if (f284962k == null) {
            return new SpannableStringBuilder(str3);
        }
        String lowerCase = str.toLowerCase();
        String str4 = str2;
        int indexOf = lowerCase.indexOf(str4);
        int length = str2.length();
        int i17 = 0;
        if (indexOf < 0 && (indexOf = lowerCase.indexOf((str4 = str2.toLowerCase()))) < 0) {
            int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, str4, 1);
            int i18 = d16[0];
            if (i18 >= 0) {
                i16 = d16[1];
            } else {
                int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, str4, 2);
                i18 = d17[0];
                if (i18 >= 0) {
                    i16 = d17[1];
                } else {
                    return new SpannableStringBuilder(str3);
                }
            }
            int i19 = i18;
            length = i16;
            indexOf = i19;
        }
        float measureText = f284962k.measureText(str3);
        float measureText2 = f284962k.measureText(str4);
        if (measureText >= f284961j && indexOf > 0) {
            String str5 = "\u2026";
            float min = f284961j - Math.min(measureText2 + (f284962k.measureText("\u2026") * 2.0f), measureText);
            String substring = str3.substring(0, indexOf);
            int length2 = substring.length();
            float[] fArr = new float[length2];
            f284962k.getTextWidths(substring, fArr);
            int i26 = 0;
            float f16 = 0.0f;
            for (int i27 = length2 - 1; i27 >= 0; i27--) {
                i26++;
                f16 += fArr[i27];
                if (f16 > min || i26 >= i3) {
                    if (min > 0.0f) {
                        i17 = i26;
                    }
                    int i28 = indexOf - i17;
                    if (i28 == 0) {
                        str5 = "";
                    }
                    str3 = str5 + str3.substring(i28);
                    lowerCase = str5 + lowerCase.substring(i28);
                    if (!TextUtils.isEmpty(str5)) {
                        indexOf = i17 + 1;
                    } else {
                        indexOf = i17;
                    }
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int a16 = com.tencent.mobileqq.search.util.a.a();
        while (indexOf >= 0) {
            int i29 = length + indexOf;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(a16), indexOf, i29, 17);
            indexOf = lowerCase.indexOf(str4, i29);
            length = str4.length();
        }
        return spannableStringBuilder;
    }

    public static boolean H0(String str) {
        Map<String, String> argumentsFromURL;
        if (TextUtils.isEmpty(str) || !str.startsWith(N()) || (argumentsFromURL = URLUtil.getArgumentsFromURL(str)) == null || !argumentsFromURL.containsKey(h0()) || TextUtils.isEmpty(argumentsFromURL.get(h0()))) {
            return false;
        }
        return true;
    }

    public static CharSequence I(TextView textView, float f16, int i3, CharSequence charSequence, List<String> list, boolean z16, boolean z17) {
        return J(textView, f16, i3, charSequence, list, z16, z17, false);
    }

    public static boolean I0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return z0(str).endsWith("qq.com");
    }

    public static CharSequence J(TextView textView, float f16, int i3, CharSequence charSequence, List<String> list, boolean z16, boolean z17, boolean z18) {
        int i16;
        int i17;
        int i18;
        CharSequence charSequence2 = charSequence;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessageWithWidth" + ((Object) charSequence2));
        }
        float t06 = (i3 * f16) - ((i3 - 1) * t0(textView, HardCodeUtil.qqStr(R.string.t7w)));
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            float f17 = 0.0f;
            if (t06 > 0.0f) {
                if (list != null && list.size() != 0) {
                    int i19 = -1;
                    int i26 = 0;
                    for (int i27 = 0; i27 < list.size(); i27++) {
                        String str = list.get(i27);
                        if (!TextUtils.isEmpty(str)) {
                            if (i19 >= 0 && i26 > 1 && str.length() == 1) {
                                break;
                            }
                            c B = B(charSequence2, str, z16);
                            CharSequence charSequence3 = B.f284973a;
                            if (i19 == -1 && i26 == 0 && (i17 = B.f284974b) != -1 && (i18 = B.f284975c) > 0) {
                                i26 = i18;
                                charSequence2 = charSequence3;
                                i19 = i17;
                            } else {
                                charSequence2 = charSequence3;
                            }
                        }
                    }
                    if (t0(textView, charSequence2) <= t06) {
                        return charSequence2;
                    }
                    if (!TextUtils.isEmpty(charSequence2) && i19 >= 0 && (i16 = i19 + i26) <= charSequence2.length()) {
                        CharSequence subSequence = charSequence2.subSequence(0, i16);
                        if (i16 < charSequence2.length()) {
                            subSequence = ((Object) subSequence) + "\u2026";
                        }
                        if (t0(textView, subSequence) <= t06) {
                            if (z18) {
                                return X(textView, t06, charSequence2);
                            }
                            return charSequence2;
                        }
                        if (i3 != 1 && z17) {
                            float f18 = f16 / 2.0f;
                            if (f18 > t0(textView, charSequence2)) {
                                return charSequence2;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            int i28 = 0;
                            while (true) {
                                if (f17 >= f18 || i28 >= charSequence2.length()) {
                                    break;
                                }
                                sb5.append(charSequence2.charAt(i28));
                                f17 = t0(textView, sb5.toString());
                                if (f17 > f18) {
                                    sb5.deleteCharAt(i28);
                                    i28--;
                                    break;
                                }
                                if (f17 == f18) {
                                    break;
                                }
                                i28++;
                            }
                            int i29 = i28 + 1;
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2.subSequence(0, i29));
                            float t07 = t06 - t0(textView, sb5.toString());
                            if (i29 < charSequence2.length()) {
                                CharSequence subSequence2 = charSequence2.subSequence(i29, charSequence2.length());
                                if (i29 >= i19) {
                                    CharSequence X = X(textView, t07, subSequence2);
                                    if (i29 < i16) {
                                        int min = Math.min(X.length(), i26 - (i29 - i19));
                                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(X);
                                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), 0, min, 17);
                                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                                    } else {
                                        spannableStringBuilder.append(X);
                                    }
                                } else {
                                    spannableStringBuilder.append(L(textView, t07, subSequence2, i19 - i29, i26));
                                }
                            }
                            return spannableStringBuilder;
                        }
                        return L(textView, t06, charSequence2, i19, i26);
                    }
                    if (z18) {
                        return X(textView, t06, charSequence2);
                    }
                    return charSequence2;
                }
                if (z18) {
                    return X(textView, t06, charSequence2);
                }
                return charSequence2;
            }
            return "";
        }
        return "";
    }

    public static boolean J0(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static CharSequence K(TextView textView, float f16, int i3, String str, String str2, boolean z16, boolean z17, boolean z18) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        return J(textView, f16, i3, str, arrayList, z16, z17, z18);
    }

    public static boolean K0(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 21) {
            return true;
        }
        return false;
    }

    public static CharSequence L(TextView textView, float f16, CharSequence charSequence, int i3, int i16) {
        int i17;
        if (!TextUtils.isEmpty(charSequence) && textView != null && f16 > 0.0f) {
            if (i3 >= 0 && (i17 = i16 + i3) <= charSequence.length()) {
                CharSequence subSequence = charSequence.subSequence(i3, i17);
                float t06 = t0(textView, subSequence.toString());
                StringBuilder sb5 = new StringBuilder(subSequence);
                if (t06 < f16) {
                    int i18 = 0;
                    while (true) {
                        if (t06 >= f16 || (i3 <= 0 && i17 >= charSequence.length())) {
                            break;
                        }
                        int i19 = i18 % 2;
                        if (i19 == 0 && i3 > 0) {
                            i3--;
                            sb5.insert(0, charSequence.charAt(i3));
                            t06 = t0(textView, sb5.toString());
                            if (t06 > f16) {
                                i3++;
                                sb5.deleteCharAt(0);
                                break;
                            }
                        }
                        if (i19 != 0 && i17 < charSequence.length()) {
                            i17++;
                            sb5.insert(sb5.length(), charSequence.charAt(i17 - 1));
                            t06 = t0(textView, sb5.toString());
                            if (t06 > f16) {
                                sb5.deleteCharAt(sb5.length() - 1);
                                i17--;
                                break;
                            }
                        }
                        i18++;
                    }
                } else {
                    while (t06 > f16 && i17 > i3) {
                        sb5.deleteCharAt((i17 - i3) - 1);
                        i17--;
                        t06 = t0(textView, sb5.toString());
                    }
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence.subSequence(i3, i17));
                if (i3 > 0 && !TextUtils.isEmpty(spannableStringBuilder)) {
                    spannableStringBuilder.delete(0, 1);
                    spannableStringBuilder = new SpannableStringBuilder("\u2026").append((CharSequence) spannableStringBuilder);
                }
                if (i17 < charSequence.length() && !TextUtils.isEmpty(spannableStringBuilder)) {
                    spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                    spannableStringBuilder.append((CharSequence) "\u2026");
                }
                return spannableStringBuilder;
            }
            return X(textView, f16, charSequence);
        }
        return "";
    }

    public static boolean L0(Activity activity) {
        return activity.getClass().getName().equals(((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getSplashActivityName());
    }

    public static String M(String str) {
        Map<String, String> argumentsFromURL;
        if (!TextUtils.isEmpty(str) && str.startsWith(N()) && (argumentsFromURL = URLUtil.getArgumentsFromURL(str)) != null && argumentsFromURL.containsKey(h0())) {
            String str2 = argumentsFromURL.get(h0());
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static boolean M0(com.tencent.mobileqq.search.model.y yVar) {
        if (!(yVar instanceof wn2.a) && !(yVar instanceof wn2.f) && !(yVar instanceof wn2.i) && !(yVar instanceof wn2.q) && !(yVar instanceof ContactSearchModelNtTroop)) {
            return false;
        }
        return true;
    }

    private static String N() {
        String c16 = f.b().c();
        if (TextUtils.isEmpty(c16)) {
            return "https://so.html5.qq.com/page/real/kd_result";
        }
        int indexOf = c16.indexOf(63);
        if (indexOf > 0) {
            return c16.substring(0, indexOf);
        }
        return c16;
    }

    private static boolean N0(Context context) {
        return ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).isUniteSearchActivity(context);
    }

    private static long O(int i3, int i16, int i17, boolean z16, boolean z17) {
        if (i3 >= 0) {
            if (i16 == i17) {
                if (z17) {
                    return com.tencent.mobileqq.search.j.E;
                }
                return com.tencent.mobileqq.search.j.f283438z;
            }
            if (i3 == 0) {
                if (z17) {
                    return com.tencent.mobileqq.search.j.E;
                }
                return com.tencent.mobileqq.search.j.C;
            }
            if (!z16) {
                return com.tencent.mobileqq.search.j.E;
            }
        }
        return Long.MIN_VALUE;
    }

    public static boolean O0(long j3) {
        return ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).isValidGroupMask(j3);
    }

    private static long P(String str, ChnToSpell.b bVar, boolean z16) {
        int[] c16 = com.tencent.mobileqq.search.util.a.c(bVar, str);
        return O(c16[0], c16[1], bVar.f306908c.size(), false, z16);
    }

    public static void P0(AppInterface appInterface, Context context, String str, int i3, int i16) {
        String str2;
        QLog.d("Q.uniteSearch.SearchUtils", 1, "[jumpSearchDetailPage] keyword: " + af.a(str, 5) + " querySource: " + i3 + " userSource: " + i16);
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            QLog.e("Q.uniteSearch.SearchUtils", 1, "[jumpSearchDetailPage] encode keyword failed, because UTF-8 is unknown");
            str2 = "";
        }
        String builder = Uri.parse("mqqapi://kuikly/open?src_type=internal&version=1&source=1&target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", com.tencent.biz.qqcircle.immersive.views.search.util.p.r()).appendQueryParameter("keyword", str2).appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, String.valueOf(i3)).appendQueryParameter("user_source", String.valueOf(i16)).appendQueryParameter("study_mode_status", String.valueOf(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())).appendQueryParameter("start_search_stamp", String.valueOf(System.currentTimeMillis())).toString();
        Q0(appInterface, context, builder);
        j1(str, builder);
    }

    private static long Q(String str, String str2, boolean z16, boolean z17) {
        return O(str2.indexOf(str), str.length(), str2.length(), z16, z17);
    }

    public static void Q0(AppInterface appInterface, Context context, String str) {
        if (appInterface == null) {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        if (appInterface != null && context != null && !TextUtils.isEmpty(str)) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                if (str.startsWith("tel://")) {
                    context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str.substring(6))));
                    return;
                }
                com.tencent.mobileqq.utils.ax c16 = bi.c((BaseQQAppInterface) appInterface, context, str);
                if (c16 != null) {
                    c16.b();
                    return;
                } else {
                    context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str)));
                    return;
                }
            }
            if (H0(str)) {
                ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(context, M(str), str);
                return;
            } else {
                ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).jumpQQBrowserActivity(context, str);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
        }
    }

    public static long R(boolean z16, String str, String str2, long j3) {
        if (z16) {
            return o0(str, str2, j3, true, false, false);
        }
        return j0(str, str2, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R0(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar, List list) {
        Iterator it = eVar.b().iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = (com.tencent.qqnt.ntrelation.otherinfo.bean.a) it.next();
            wn2.c n3 = n(aVar.getUid(), list);
            if (n3 != null) {
                n3.d0(aVar.a0());
            }
        }
    }

    private static long S(int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, boolean z19) {
        if (i3 < 0) {
            return Long.MIN_VALUE;
        }
        if (i16 == i17) {
            if (z17) {
                return com.tencent.mobileqq.search.j.E;
            }
            return com.tencent.mobileqq.search.j.f283438z;
        }
        if (i3 == 0) {
            if (z17) {
                return com.tencent.mobileqq.search.j.E;
            }
            if (z19) {
                return com.tencent.mobileqq.search.j.A;
            }
            return com.tencent.mobileqq.search.j.C;
        }
        if (z16) {
            return Long.MIN_VALUE;
        }
        if (z18 && z19) {
            return com.tencent.mobileqq.search.j.B;
        }
        if (z18) {
            return com.tencent.mobileqq.search.j.D;
        }
        return com.tencent.mobileqq.search.j.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S0(final List list, final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
        if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.util.av
                @Override // java.lang.Runnable
                public final void run() {
                    SearchUtils.R0(com.tencent.qqnt.ntrelation.friendsinfo.bean.e.this, list);
                }
            }, 16, null, true);
        }
    }

    private static long T(String str, ChnToSpell.b bVar, boolean z16) {
        boolean z17;
        int[] c16 = com.tencent.mobileqq.search.util.a.c(bVar, str);
        int i3 = c16[0];
        int i16 = c16[1];
        int indexOf = bVar.f306907b.indexOf(str);
        int indexOf2 = bVar.f306907b.indexOf(str);
        boolean contains = bVar.f306909d.contains(Integer.valueOf(indexOf));
        if (i3 >= 0 && bVar.f306909d.contains(Integer.valueOf(indexOf2 + str.length()))) {
            z17 = true;
        } else {
            z17 = false;
        }
        return S(i3, i16, bVar.f306908c.size(), false, z16, contains, z17);
    }

    @Nullable
    public static b T0(boolean z16, TroopInfo troopInfo, String str) {
        b bVar = new b();
        long j3 = Long.MIN_VALUE;
        if (!TextUtils.isEmpty(troopInfo.troopRemark)) {
            long R = R(z16, str, troopInfo.troopRemark, com.tencent.mobileqq.search.j.f283422j);
            if (R > Long.MIN_VALUE) {
                bVar.f284970b = 3;
                bVar.f284971c = troopInfo.troopRemark;
                bVar.f284972d = "remark";
                j3 = R;
            }
        }
        String newTroopNameOrTroopName = troopInfo.getNewTroopNameOrTroopName();
        long R2 = R(z16, str, newTroopNameOrTroopName, com.tencent.mobileqq.search.j.f283422j);
        if (R2 > j3) {
            bVar.f284970b = 1;
            bVar.f284971c = newTroopNameOrTroopName;
            bVar.f284972d = "name";
            if (troopInfo.isNewTroop() && !troopInfo.hasSetTroopName()) {
                return null;
            }
            j3 = R2;
        }
        long k06 = k0(str, troopInfo.troopuin, com.tencent.mobileqq.search.j.f283432t, false);
        if (k06 > j3) {
            if (troopInfo.isQidianPrivateTroop()) {
                return null;
            }
            bVar.f284970b = 2;
            bVar.f284971c = troopInfo.troopuin;
            bVar.f284972d = "uin";
            j3 = k06;
        }
        bVar.f284969a = j3;
        return bVar;
    }

    private static long U(String str, String str2, ChnToSpell.b bVar, boolean z16, boolean z17) {
        boolean z18;
        int indexOf = str2.indexOf(str);
        int length = str.length();
        boolean contains = bVar.f306910e.contains(Integer.valueOf(indexOf));
        if (indexOf >= 0 && bVar.f306910e.contains(Integer.valueOf(indexOf + length))) {
            z18 = true;
        } else {
            z18 = false;
        }
        return S(indexOf, length, str2.length(), z16, z17, contains, z18);
    }

    public static void U0(String str, String str2, int i3, int i16, String... strArr) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).report(str, str2, i3, i16, strArr);
    }

    public static CharSequence V(@NonNull TroopInfo troopInfo, String str, int i3) {
        if (i3 == 2) {
            return new SpannableStringBuilder("\u7fa4\u53f7\uff1a").append(C(troopInfo.troopuin, str));
        }
        if (i3 == 1 && !TextUtils.isEmpty(troopInfo.troopRemark)) {
            return new SpannableStringBuilder("\u7fa4\u804a\u540d\u79f0\uff1a").append(C(troopInfo.getNewTroopNameOrTroopName(), str));
        }
        return null;
    }

    public static void V0(String str, String str2, String str3, int i3, int i16, String... strArr) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).report(str, str2, str3, i3, i16, strArr);
    }

    public static CharSequence W(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "(").append(charSequence).append((CharSequence) ")");
        return spannableStringBuilder;
    }

    public static void W0(String str, String str2, String... strArr) {
        U0(str, str2, 0, 0, strArr);
    }

    public static CharSequence X(TextView textView, float f16, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            float f17 = 0.0f;
            if (f16 > 0.0f) {
                if (f16 > t0(textView, charSequence)) {
                    return charSequence;
                }
                StringBuilder sb5 = new StringBuilder();
                int i3 = 0;
                while (true) {
                    if (f17 >= f16 || i3 >= charSequence.length()) {
                        break;
                    }
                    sb5.append(charSequence.charAt(i3));
                    f17 = t0(textView, sb5.toString());
                    if (f17 > f16) {
                        sb5.deleteCharAt(i3);
                        i3--;
                        break;
                    }
                    if (f17 == f16) {
                        break;
                    }
                    i3++;
                }
                int i16 = i3 + 1;
                CharSequence subSequence = charSequence.subSequence(0, i16);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(subSequence);
                if (i3 < charSequence.length() - 1) {
                    spannableStringBuilder.delete(i3, i16);
                    spannableStringBuilder.append((CharSequence) "\u2026", 0, 1);
                    return spannableStringBuilder;
                }
                return new SpannableStringBuilder(subSequence);
            }
            return "";
        }
        return "";
    }

    public static void X0(final com.tencent.mobileqq.search.model.k kVar, final View view) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.util.SearchUtils.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String str;
                AppInterface appInterface;
                HashMap hashMap = new HashMap();
                Integer num = (Integer) view.getTag(R.id.kxc);
                int i16 = -1;
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = -1;
                }
                hashMap.put("itemLinePosition", String.valueOf(i3 + 1));
                hashMap.put("matchDegree", String.valueOf(kVar.I()));
                hashMap.put(PushClientConstants.TAG_CLASS_NAME, kVar.getClass().getSimpleName());
                hashMap.put("keyword", kVar.getKeywords());
                HashMap<String, String> hashMap2 = kVar.V;
                if (hashMap2 != null) {
                    hashMap.putAll(hashMap2);
                }
                com.tencent.mobileqq.search.model.k kVar2 = kVar;
                if (kVar2 instanceof wn2.g) {
                    str = ((wn2.g) kVar2).X;
                } else if (kVar2 instanceof wn2.f) {
                    str = ((wn2.f) kVar2).X;
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str) && (appInterface = kVar.G) != null) {
                    GroupMsgMask x06 = SearchUtils.x0(appInterface, str);
                    hashMap.put("troopMask", String.valueOf(SearchUtils.x0(kVar.G, str)));
                    TroopInfo w06 = SearchUtils.w0(kVar.G, str);
                    if (w06 != null) {
                        i16 = w06.wMemberNum;
                    }
                    hashMap.put("troopMask", String.valueOf(x06.ordinal()));
                    hashMap.put("troopMemberNum", String.valueOf(i16));
                    if (QLog.isColorLevel()) {
                        QLog.d("searchUtils", 2, "Report troop member click, troopMask:" + x06 + " troopMemberNum:" + i16);
                    }
                }
                StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance((String) null, "ContactSearchMatchDegree", true, 0L, 0L, SearchUtils.a0(hashMap), "", false);
            }
        }, null, true);
    }

    public static CharSequence Y(String str, int i3, Collection<String> collection) {
        int i16;
        if (str == null) {
            return null;
        }
        if (i3 >= 0 && collection != null && !collection.isEmpty()) {
            byte[] bytes = str.getBytes();
            if (i3 >= bytes.length) {
                return new SpannableStringBuilder(str);
            }
            int i17 = 0;
            if (i3 > 0) {
                byte[] bArr = new byte[i3];
                System.arraycopy(bytes, 0, bArr, 0, i3);
                i16 = new String(bArr).length();
            } else {
                i16 = 0;
            }
            Iterator<String> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str.toLowerCase().indexOf(next.toLowerCase()) == i16) {
                    i17 = next.length();
                    break;
                }
            }
            if (i16 > 10 || (i16 > 6 && i17 + i16 > 10)) {
                str = "\u2026" + str.substring(i16 - 6);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            for (String str2 : collection) {
                int indexOf = str.toLowerCase().indexOf(str2.toLowerCase());
                if (indexOf >= 0) {
                    int length = str2.length();
                    while (indexOf >= 0) {
                        int i18 = indexOf + length;
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), indexOf, i18, 17);
                        indexOf = str.toLowerCase().indexOf(str2.toLowerCase(), i18);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(str);
    }

    public static void Y0(String str) {
        int i3;
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(" ")) != null) {
            i3 = split.length;
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "discuss -searchKey:" + str + " count:" + i3);
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, "" + i3, "", "", "");
        }
    }

    public static CharSequence Z(String str, ArrayList<String> arrayList, int i3) {
        Iterator<String> it = arrayList.iterator();
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            String next = it.next();
            String lowerCase = str.toLowerCase();
            int indexOf = lowerCase.indexOf(next);
            int length = next.length();
            if (indexOf >= 0) {
                i16 = indexOf;
            } else {
                i16 = lowerCase.indexOf(next.toLowerCase());
                if (i16 < 0) {
                    i17 = length;
                }
            }
            i17 = length;
        }
        if (i16 < 0) {
            return new SpannableStringBuilder(str);
        }
        if (i16 > i3 || (i16 > 6 && i17 + i16 > i3)) {
            str = "\u2026" + str.substring(i16 - 6);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Iterator<String> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            String next2 = it5.next();
            String lowerCase2 = str.toLowerCase();
            int indexOf2 = lowerCase2.indexOf(next2);
            int length2 = next2.length();
            if (indexOf2 >= 0 || (indexOf2 = lowerCase2.indexOf(next2.toLowerCase())) >= 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), indexOf2, length2 + indexOf2, 17);
            }
        }
        return spannableStringBuilder;
    }

    public static void Z0(String str, int i3, View view, boolean z16) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).reportJumpToAIOorProfile(str, i3, view, z16);
    }

    public static HashMap<String, String> a0(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("input_type", String.valueOf(f284957f));
        hashMap.put("support_sougou_ime", String.valueOf(f284953b));
        return hashMap;
    }

    public static void a1(int i3, int i16, int i17, boolean z16, String str, String str2, int i18) {
        int i19;
        String str3;
        switch (i3) {
            case 80000000:
                i19 = 70;
                break;
            case 80000001:
                i19 = 80;
                break;
            case 80000002:
                i19 = 90;
                break;
            default:
                i19 = -1;
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "moduleType:" + i19 + " moduleIndex:" + i16 + " itemLinePosition:" + i17 + " isGroupSearch:" + z16);
        }
        if (z16) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("moduleType", Integer.toString(i19));
            hashMap.put("moduleIndex", Integer.toString(i16));
            hashMap.put("itemLinePosition", Integer.toString(i17));
            hashMap.put("toUin", str);
            hashMap.put("keyword", str2);
            if (i18 == 12) {
                hashMap.put("isFolder", "1");
            } else {
                hashMap.put("isFolder", "0");
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "NetGroupSearchItemClick", true, 0L, 0L, hashMap, null);
        } else {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("moduleType", Integer.toString(i19));
            hashMap2.put("itemLinePosition", Integer.toString(i17));
            hashMap2.put("toUin", str);
            hashMap2.put("keyword", str2);
            if (i18 == 12) {
                hashMap2.put("isFolder", "1");
            } else {
                hashMap2.put("isFolder", "0");
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "NetModelSearchItemClick", true, 0L, 0L, hashMap2, null);
        }
        switch (i3) {
            case 80000000:
                if (i17 == 0) {
                    str3 = "0X80061BA";
                    break;
                } else {
                    str3 = "0X80061B9";
                    break;
                }
            case 80000001:
                if (i17 == 0) {
                    str3 = "0X80061BD";
                    break;
                } else {
                    str3 = "0X80061BC";
                    break;
                }
            case 80000002:
                if (i17 == 0) {
                    str3 = "0X80061C0";
                    break;
                } else {
                    str3 = "0X80061BF";
                    break;
                }
            case 80000003:
                if (i17 == 0) {
                    str3 = "0X80061C3";
                    break;
                } else {
                    str3 = "0X80061C2";
                    break;
                }
            default:
                str3 = "";
                break;
        }
        String str4 = str3;
        ReportController.o(null, "CliOper", "", "", str4, str4, 0, 0, String.valueOf(i17), "", "", "");
    }

    public static String b0(int i3) {
        if (i3 == 1) {
            return "1";
        }
        if (i3 == 2) {
            return "2";
        }
        if (i3 == 21) {
            return "3";
        }
        return "-1";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b1() {
        boolean z16;
        int i3;
        int i16 = 70;
        boolean z17 = true;
        if (rn2.d.b(70) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (rn2.d.b(80) == 0) {
            z17 = false;
        }
        if (z16 && z17) {
            i16 = 90;
        } else if (!z16) {
            if (z17) {
                i3 = 80;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                ReportController.o(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i3, 0, "", "", "", "");
                return;
            }
            return;
        }
        i3 = i16;
        if (i3 == 0) {
        }
    }

    private static String c0(String str, long[] jArr) throws RuntimeException {
        return MobileQQ.sMobileQQ.peekAppRuntime().getAccount() + "#" + str + "#" + i(jArr);
    }

    public static void c1(String str, int i3, int i16, View view) {
        boolean N0 = N0(view.getContext());
        int intValue = ((Integer) view.getTag(R.id.kxc)).intValue() + 1;
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "moduleType:" + i3 + " itemLinePosition:" + intValue);
        }
        if (N0) {
            int b16 = rn2.d.b(i3);
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "moduleIndex:" + b16 + " searchKey:" + str);
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E10", "0X8005E10", i3, 0, String.valueOf(b16), String.valueOf(intValue), String.valueOf(i16), "");
            HashMap hashMap = new HashMap();
            hashMap.put("moduleType", Integer.toString(i3));
            hashMap.put("moduleIndex", Integer.toString(b16));
            hashMap.put("moduleChildType", Integer.toString(i16));
            hashMap.put("itemLinePosition", Integer.toString(intValue));
            hashMap.put("keyword", str);
            if (f284955d != -1) {
                hashMap.put("stay_time", String.valueOf(System.currentTimeMillis() - f284955d));
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a0(hashMap), null);
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E11", "0X8005E11", i3, 0, "", String.valueOf(intValue), String.valueOf(i16), "");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("moduleType", Integer.toString(i3));
        hashMap2.put("moduleChildType", Integer.toString(i16));
        hashMap2.put("itemLinePosition", Integer.toString(intValue));
        hashMap2.put("keyword", str);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, hashMap2, null);
    }

    public static String d0(List<Long> list) {
        return p(k(list), "::");
    }

    public static void d1(String str, int i3, int i16, View view, String str2, boolean z16, int i17) {
        String str3;
        Object obj;
        boolean N0 = N0(view.getContext());
        int intValue = ((Integer) view.getTag(R.id.kxc)).intValue() + 1;
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "moduleType:" + i3 + " itemLinePosition:" + intValue);
        }
        if (N0) {
            int b16 = rn2.d.b(i3);
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "moduleIndex:" + b16 + " searchKey:" + str);
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E10", "0X8005E10", i3, 0, String.valueOf(b16), String.valueOf(intValue), String.valueOf(i16), "");
            HashMap hashMap = new HashMap();
            hashMap.put("moduleType", Integer.toString(i3));
            hashMap.put("moduleIndex", Integer.toString(b16));
            hashMap.put("moduleChildType", Integer.toString(i16));
            hashMap.put("itemLinePosition", Integer.toString(intValue));
            hashMap.put("toUin", str2);
            hashMap.put("keyword", str);
            if (z16) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISOFFLINE, obj);
            if (i17 == 12) {
                hashMap.put("isFolder", "1");
            } else {
                hashMap.put("isFolder", "0");
            }
            if (f284955d != -1) {
                hashMap.put("stay_time", String.valueOf(System.currentTimeMillis() - f284955d));
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a0(hashMap), null);
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E11", "0X8005E11", i3, 0, "", String.valueOf(intValue), String.valueOf(i16), "");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("moduleType", Integer.toString(i3));
        hashMap2.put("moduleChildType", Integer.toString(i16));
        hashMap2.put("itemLinePosition", Integer.toString(intValue));
        hashMap2.put("keyword", str);
        hashMap2.put("toUin", str2);
        if (z16) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap2.put(IPublicAccountDetailReportUtil.KEY_ISOFFLINE, str3);
        if (i17 == 12) {
            hashMap2.put("isFolder", "1");
        } else {
            hashMap2.put("isFolder", "0");
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, hashMap2, null);
    }

    public static String e0(long[] jArr) {
        return p(jArr, "::");
    }

    public static void e1(String str, int i3, int i16, int i17, View view) {
        boolean N0 = N0(view.getContext());
        int i18 = i17 + 1;
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "moduleType:" + i3 + " itemLinePosition:" + i18);
        }
        if (N0) {
            int b16 = rn2.d.b(i3);
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "moduleIndex:" + b16 + " searchKey:" + str);
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E10", "0X8005E10", i3, 0, String.valueOf(b16), String.valueOf(i18), String.valueOf(i16), "");
            HashMap hashMap = new HashMap();
            hashMap.put("moduleType", Integer.toString(i3));
            hashMap.put("moduleIndex", Integer.toString(b16));
            hashMap.put("moduleChildType", Integer.toString(i16));
            hashMap.put("itemLinePosition", Integer.toString(i18));
            hashMap.put("keyword", str);
            if (f284955d != -1) {
                hashMap.put("stay_time", String.valueOf(System.currentTimeMillis() - f284955d));
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "GroupSearchItemClick", true, 0L, 0L, a0(hashMap), null);
            return;
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E11", "0X8005E11", i3, 0, "", String.valueOf(i18), String.valueOf(i16), "");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("moduleType", Integer.toString(i3));
        hashMap2.put("moduleChildType", Integer.toString(i16));
        hashMap2.put("itemLinePosition", Integer.toString(i18));
        hashMap2.put("keyword", str);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, "ModelSearchItemClick", true, 0L, 0L, hashMap2, null);
    }

    public static String f0(String str, List<Long> list) {
        return g0(str, k(list));
    }

    public static void f1(AppInterface appInterface, String str, String str2, String str3, int i3) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).saveSearchHistory(appInterface, str, str2, str3, i3);
    }

    public static String g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Uri.parse(str).buildUpon().appendQueryParameter("sessionId", com.tencent.biz.qqcircle.immersive.views.search.util.p.r()).toString();
        }
        return str;
    }

    public static String g0(String str, long[] jArr) {
        try {
            String str2 = f284956e.get(c0(str, jArr));
            if (str2 == null) {
                return "";
            }
            return str2;
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils getReportVersion", 2, e16.toString());
            }
            return "";
        }
    }

    public static void g1(String str, int i3, String str2, String str3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).saveSearchHistory((AppInterface) peekAppRuntime, str, peekAppRuntime.getCurrentAccountUin(), str2, i3, str3);
    }

    public static void h() {
        f284964m.clear();
        f284965n.clear();
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchUtils", 2, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        }
    }

    public static String h0() {
        String d16 = f.b().d();
        if (TextUtils.isEmpty(d16)) {
            return QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB;
        }
        return d16;
    }

    public static void h1(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Utils.KEY_BUSINESS_ID, str);
            jSONObject.putOpt("iconUrl", str3);
            jSONObject.putOpt("name", str2);
            jSONObject.putOpt(WadlProxyConsts.KEY_JUMP_URL, str4);
            g1(str2, 10024, "", jSONObject.toString());
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }

    private static String i(long[] jArr) {
        return p(jArr, ":");
    }

    public static String i0(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(charSequence).replaceAll("");
    }

    public static void i1(String str) {
        k1(str, String.valueOf(20), String.valueOf(20), "");
    }

    public static List<Long> j(long[] jArr) {
        if (jArr != null) {
            ArrayList arrayList = new ArrayList(jArr.length);
            for (long j3 : jArr) {
                arrayList.add(Long.valueOf(j3));
            }
            return arrayList;
        }
        throw new RuntimeException("convertIntArrayToLongList. array can not be null.");
    }

    public static long j0(String str, String str2, long j3) {
        return k0(str, str2, j3, true);
    }

    public static void j1(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(WadlProxyConsts.KEY_JUMP_URL, str2);
            jSONObject.putOpt("name", str);
            g1(str, 10025, "", jSONObject.toString());
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }

    public static long[] k(List<Long> list) {
        if (list != null) {
            long[] jArr = new long[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                jArr[i3] = list.get(i3).longValue();
            }
            return jArr;
        }
        throw new RuntimeException("convertLongList2longArray. list can not be null.");
    }

    public static long k0(String str, String str2, long j3, boolean z16) {
        return l0(str, str2, j3, z16, false, false);
    }

    public static void k1(String str, String str2, String str3, String str4) {
        String str5;
        QLog.d("Q.uniteSearch.SearchUtils", 1, "[saveSearchHistoryForNetSearch] keyword: ", cq.w(str, 2), " targetPageMode", str4);
        try {
            str5 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            QLog.e("Q.uniteSearch.SearchUtils", 1, "[saveSearchHistoryForNetSearch] encode keyword failed, because UTF-8 is unknown");
            str5 = str;
        }
        Uri.Builder appendQueryParameter = Uri.parse("mqqapi://kuikly/open?src_type=internal&version=1&source=1&target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", com.tencent.biz.qqcircle.immersive.views.search.util.p.r()).appendQueryParameter("keyword", str5).appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, str2).appendQueryParameter("user_source", str3);
        if (!TextUtils.isEmpty(str4)) {
            appendQueryParameter.appendQueryParameter("voice_ai_mode", str4);
        }
        j1(str, appendQueryParameter.toString());
    }

    public static final int l(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static long l0(String str, String str2, long j3, boolean z16, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            long Q = Q(lowerCase, lowerCase2, z17, z18);
            if (Q != Long.MIN_VALUE) {
                return Q + com.tencent.mobileqq.search.j.f283435w + j3;
            }
            if (z16) {
                ChnToSpell.b e16 = ChnToSpell.e(lowerCase2, 1);
                if (true ^ lowerCase2.equals(e16.f306907b)) {
                    long P = P(lowerCase, e16, z18);
                    if (P != Long.MIN_VALUE) {
                        return P + com.tencent.mobileqq.search.j.f283436x + j3;
                    }
                    long P2 = P(lowerCase, ChnToSpell.e(lowerCase2, 2), z18);
                    if (P2 != Long.MIN_VALUE) {
                        return P2 + com.tencent.mobileqq.search.j.f283436x + j3;
                    }
                }
            }
        }
        return Long.MIN_VALUE;
    }

    public static void l1(View view, com.tencent.mobileqq.search.model.k kVar) {
        String uin;
        Activity activity = (Activity) view.getContext();
        if (activity == null) {
            return;
        }
        if (!(kVar instanceof wn2.a) && !(kVar instanceof wn2.q) && !(kVar instanceof wn2.i)) {
            if (kVar instanceof wn2.b) {
                uin = ((wn2.b) kVar).d();
            } else if (kVar instanceof wn2.j) {
                uin = ((wn2.j) kVar).X;
            } else if (kVar instanceof wn2.n) {
                uin = ((wn2.n) kVar).getTroopUin();
            } else {
                uin = "";
            }
        } else {
            uin = kVar.getUin();
        }
        String str = uin;
        if (AppSetting.t(activity) && L0(activity)) {
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
            ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(view.getContext(), kVar.getUin(), str, kVar.M(), kVar.G.getCurrentNickname(), false, null, null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("contactSearchResultUin", kVar.getUin());
        intent.putExtra("contactSearchResultUinType", kVar.M());
        intent.putExtra("contactSearchResultName", kVar.getTitle());
        intent.putExtra("contactSearchResultNick", kVar.K());
        if (kVar instanceof wn2.m) {
            wn2.m mVar = (wn2.m) kVar;
            intent.putExtra("contactSearchResultPhoneContactOriginBinder", mVar.X.originBinder);
            String str2 = mVar.X.mobileCode;
            if (TextUtils.isEmpty(str2)) {
                str2 = mVar.X.mobileNo;
            }
            intent.putExtra("contactSearchResultPhoneContactMobileCode", str2);
            intent.putExtra("contactSearchResultPhoneContactNationCode", mVar.X.nationCode);
            intent.putExtra("contactSearchResultPhoneContactAbility", mVar.X.ability);
        }
        intent.putExtra("contactSearchResultTroopUin", str);
        activity.setResult(-1, intent);
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    public static String m(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static long m0(String str, String str2, ChnToSpell.b bVar, ChnToSpell.b bVar2, long j3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            long Q = Q(lowerCase, str2.toLowerCase(), false, false);
            if (Q != Long.MIN_VALUE) {
                return Q + com.tencent.mobileqq.search.j.f283435w + j3;
            }
            if (bVar != null && bVar2 != null && (!r7.equals(bVar.f306907b))) {
                long P = P(lowerCase, bVar, false);
                if (P != Long.MIN_VALUE) {
                    return P + com.tencent.mobileqq.search.j.f283436x + j3;
                }
                long P2 = P(lowerCase, bVar2, false);
                if (P2 != Long.MIN_VALUE) {
                    return P2 + com.tencent.mobileqq.search.j.f283436x + j3;
                }
            }
        }
        return Long.MIN_VALUE;
    }

    public static Map<Integer, com.tencent.qqnt.ntrelation.friendsinfo.bean.a> m1() {
        Map<Integer, com.tencent.qqnt.ntrelation.friendsinfo.bean.a> associateBy;
        associateBy = CollectionsKt___CollectionsKt.associateBy(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryBaseInfo("Q.uniteSearch.SearchUtils"), new Function1() { // from class: com.tencent.mobileqq.search.util.au
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(((com.tencent.qqnt.ntrelation.friendsinfo.bean.a) obj).b());
            }
        });
        return associateBy;
    }

    private static wn2.c n(String str, List<wn2.c> list) {
        for (wn2.c cVar : list) {
            if (TextUtils.equals(cVar.S().getUid(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public static long n0(String str, String str2, long j3) {
        return l0(str, str2, j3, true, false, true);
    }

    public static void n1(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.util.SearchUtils.1
            @Override // java.lang.Runnable
            public void run() {
                TextUtils.isEmpty(str);
            }
        });
    }

    public static com.tencent.qqnt.ntrelation.friendsinfo.bean.d o(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "Q.uniteSearch.SearchUtils");
    }

    public static long o0(String str, String str2, long j3, boolean z16, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            ChnToSpell.b e16 = ChnToSpell.e(lowerCase2, 1);
            long U = U(lowerCase, lowerCase2, e16, z17, z18);
            if (U != Long.MIN_VALUE) {
                return U + com.tencent.mobileqq.search.j.f283435w + j3;
            }
            if (z16 && (!lowerCase2.equals(e16.f306907b))) {
                long T = T(lowerCase, e16, z18);
                if (T != Long.MIN_VALUE) {
                    return T + com.tencent.mobileqq.search.j.f283436x + j3;
                }
                long P = P(lowerCase, ChnToSpell.e(lowerCase2, 2), z18);
                if (P != Long.MIN_VALUE) {
                    return P + com.tencent.mobileqq.search.j.f283436x + j3;
                }
            }
        }
        return Long.MIN_VALUE;
    }

    public static void o1(AppInterface appInterface, String str, String str2, String str3, int i3) {
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).updateItemUsed(appInterface, str, str2, str3, i3);
    }

    public static String p(long[] jArr, String str) {
        if (jArr == null && QLog.isDevelopLevel()) {
            throw new RuntimeException("generateMaskString. masks can not be null.");
        }
        if (jArr == null) {
            QLog.e("Q.uniteSearch.SearchUtils", 1, "generateMaskString mask is null");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (long j3 : jArr) {
            sb5.append(j3);
            sb5.append(str);
        }
        if (sb5.length() <= 0) {
            return "";
        }
        return sb5.substring(0, sb5.length() - str.length());
    }

    public static long p0(String str, String str2, ChnToSpell.b bVar, ChnToSpell.b bVar2, long j3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && bVar != null) {
            String lowerCase = str.toLowerCase();
            long U = U(lowerCase, str2.toLowerCase(), bVar, false, false);
            if (U != Long.MIN_VALUE) {
                return U + com.tencent.mobileqq.search.j.f283435w + j3;
            }
            if (bVar2 != null && (!r7.equals(bVar.f306907b))) {
                long T = T(lowerCase, bVar, false);
                if (T != Long.MIN_VALUE) {
                    return T + com.tencent.mobileqq.search.j.f283436x + j3;
                }
                long P = P(lowerCase, bVar2, false);
                if (P != Long.MIN_VALUE) {
                    return P + com.tencent.mobileqq.search.j.f283436x + j3;
                }
            }
        }
        return Long.MIN_VALUE;
    }

    public static void p1(String str, long[] jArr, String str2) {
        try {
            f284956e.put(c0(str, jArr), str2);
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils updateReportVersion", 2, e16.toString());
            }
        }
    }

    public static CharSequence q(JSONArray jSONArray) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("word");
                String optString2 = optJSONObject.optString("color");
                if (!TextUtils.isEmpty(optString)) {
                    SpannableString spannableString = new SpannableString(optString);
                    try {
                        if (!TextUtils.isEmpty(optString2)) {
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(optString2)), 0, optString.length(), 17);
                        }
                    } catch (IllegalArgumentException unused) {
                        QLog.e("Q.uniteSearch.SearchUtils", 1, " color value is not valid. colorStr = " + optString2);
                    }
                    spannableStringBuilder.append((CharSequence) spannableString);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static int[] q0(String str, String str2, boolean z16) {
        int[] iArr = {-1, 0, 0};
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            int indexOf = lowerCase2.indexOf(lowerCase);
            iArr[0] = indexOf;
            if (indexOf != -1) {
                iArr[1] = lowerCase.length();
                iArr[2] = 3;
                return iArr;
            }
            if (z16) {
                ChnToSpell.b e16 = ChnToSpell.e(lowerCase2, 1);
                if (!lowerCase2.equals(e16.f306907b)) {
                    int[] c16 = com.tencent.mobileqq.search.util.a.c(e16, lowerCase);
                    int i3 = c16[0];
                    iArr[0] = i3;
                    iArr[1] = c16[1];
                    if (i3 != -1) {
                        iArr[2] = 2;
                        return iArr;
                    }
                    int[] c17 = com.tencent.mobileqq.search.util.a.c(ChnToSpell.e(lowerCase2, 2), lowerCase);
                    int i16 = c17[0];
                    iArr[0] = i16;
                    iArr[1] = c17[1];
                    if (i16 != -1) {
                        iArr[2] = 1;
                    }
                }
            }
        }
        return iArr;
    }

    public static String r() {
        String accountId = VSNetworkHelper.getInstance().getNetworkImpl().getAccountId();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.nanoTime());
        sb5.append(accountId);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    public static Drawable r0(Bitmap bitmap) {
        Drawable drawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.icon_cover_recent_subaccount);
        if (drawable instanceof SkinnableBitmapDrawable) {
            ((SkinnableBitmapDrawable) drawable).setGravity(81);
        }
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).setGravity(81);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return new LayerDrawable(new Drawable[]{new BitmapDrawable(bitmap), drawable});
    }

    public static List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> s() {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("Q.uniteSearch.SearchUtils");
    }

    public static CharSequence s0(String str, String str2, int i3, boolean z16) {
        String sb5;
        String str3;
        int i16;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int indexOf = lowerCase.indexOf(lowerCase2);
        int length = lowerCase2.length();
        if (indexOf < 0) {
            if (z16) {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 1);
                indexOf = d16[0];
                if (indexOf >= 0) {
                    length = d16[1];
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 2);
                    int i17 = d17[0];
                    if (i17 >= 0) {
                        length = d17[1];
                        indexOf = i17;
                    } else {
                        return new SpannableStringBuilder(str);
                    }
                }
            } else {
                return new SpannableStringBuilder(str);
            }
        }
        if (indexOf <= i3 && (indexOf <= 6 || indexOf + length <= i3)) {
            sb5 = "(" + str + ")";
            str3 = "(" + lowerCase + ")";
            i16 = indexOf + 1;
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("(\u2026");
            int i18 = indexOf - 6;
            sb6.append(str.substring(i18));
            sb6.append(")");
            sb5 = sb6.toString();
            str3 = "(\u2026" + lowerCase.substring(i18) + ")";
            i16 = 8;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb5);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(MobileQQ.sMobileQQ.getResources().getColor(R.color.skin_gray2_item)), 0, sb5.length(), 17);
        while (i16 >= 0) {
            int i19 = length + i16;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), i16, i19, 17);
            i16 = str3.indexOf(str2, i19);
            length = str2.length();
        }
        return spannableStringBuilder;
    }

    public static String t(Context context, DiscussionInfo discussionInfo) {
        String str;
        if (discussionInfo != null) {
            str = discussionInfo.discussionName;
        } else {
            str = "";
        }
        if (str == null || str.length() == 0) {
            return context.getResources().getString(R.string.as8);
        }
        return str;
    }

    public static float t0(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            return textView.getPaint().measureText(charSequence.toString());
        }
        return 0.0f;
    }

    public static Drawable u(IFaceDecoder iFaceDecoder, com.tencent.mobileqq.search.model.t tVar) {
        return v(iFaceDecoder, tVar.getUin(), tVar.k());
    }

    public static CharSequence u0(String str, String str2, int i3, boolean z16) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int indexOf = lowerCase.indexOf(lowerCase2);
        int length = lowerCase2.length();
        if (indexOf < 0) {
            if (z16) {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 1);
                int i16 = d16[0];
                if (i16 >= 0) {
                    length = d16[1];
                    indexOf = i16;
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(lowerCase, lowerCase2, 2);
                    indexOf = d17[0];
                    if (indexOf >= 0) {
                        length = d17[1];
                    } else {
                        return new SpannableStringBuilder(str);
                    }
                }
            } else {
                return new SpannableStringBuilder(str);
            }
        }
        if (indexOf > i3 || (indexOf > 6 && indexOf + length > i3)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u2026");
            int i17 = indexOf - 6;
            sb5.append(str.substring(i17));
            str = sb5.toString();
            lowerCase = "\u2026" + lowerCase.substring(i17);
            indexOf = 7;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (indexOf >= 0) {
            int i18 = length + indexOf;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a()), indexOf, i18, 17);
            indexOf = lowerCase.indexOf(str2, i18);
            length = str2.length();
        }
        return spannableStringBuilder;
    }

    public static Drawable v(IFaceDecoder iFaceDecoder, String str, int i3) {
        return ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).getFaceBitmap(iFaceDecoder, str, i3);
    }

    public static String v0(AppInterface appInterface, String str) {
        return ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(str);
    }

    public static String w(String... strArr) {
        if (strArr == null) {
            return null;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (!TextUtils.isEmpty(strArr[i3])) {
                return strArr[i3];
            }
        }
        return null;
    }

    public static TroopInfo w0(AppInterface appInterface, String str) {
        return ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
    }

    public static String x(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        if (!TextUtils.isEmpty(dVar.r())) {
            return dVar.r();
        }
        if (!TextUtils.isEmpty(dVar.p())) {
            return dVar.p();
        }
        if (!TextUtils.isEmpty(dVar.c())) {
            return dVar.c();
        }
        return dVar.x();
    }

    public static GroupMsgMask x0(AppInterface appInterface, String str) {
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(appInterface, str);
    }

    public static void y(ArrayList<String> arrayList, final List<wn2.c> list) {
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(arrayList, "Q.uniteSearch.SearchUtils", new hx3.b() { // from class: com.tencent.mobileqq.search.util.at
            @Override // hx3.b
            public final void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                SearchUtils.S0(list, eVar);
            }
        });
    }

    public static String y0(AppInterface appInterface, String str) {
        return ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(str);
    }

    public static CharSequence z(AppInterface appInterface, String str, String str2, int i3, com.tencent.mobileqq.search.model.al alVar) {
        return new SpannableStringBuilder(str);
    }

    @NonNull
    private static String z0(String str) {
        String str2;
        try {
            str2 = new URL(str).getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f284973a;

        /* renamed from: b, reason: collision with root package name */
        public int f284974b;

        /* renamed from: c, reason: collision with root package name */
        public int f284975c;

        public c(CharSequence charSequence) {
            this.f284973a = charSequence;
            this.f284974b = -1;
            this.f284975c = 0;
        }

        public c(CharSequence charSequence, int i3, int i16) {
            this.f284973a = charSequence;
            this.f284974b = i3;
            this.f284975c = i16;
        }
    }
}
