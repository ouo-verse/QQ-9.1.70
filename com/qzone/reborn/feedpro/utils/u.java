package com.qzone.reborn.feedpro.utils;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/u;", "", "", "nickName", "", "needColon", "needAppendBlank", "c", "uin", "a", TtmlNode.ATTR_TTS_ORIGIN, "", com.tencent.luggage.wxa.c8.c.E, "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", QCircleAlphaUserReporter.KEY_USER, "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f54367a = new u();

    u() {
    }

    private final String d(String origin, int len) {
        if (origin == null || Intrinsics.areEqual(origin, "") || len < 1) {
            return "";
        }
        if (origin.length() <= len) {
            return origin;
        }
        String substring = origin.substring(0, len);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public final String b(CommonUser user, boolean needColon, boolean needAppendBlank) {
        String uin;
        if (user == null) {
            return "";
        }
        if (!TextUtils.isEmpty(user.getNick())) {
            uin = user.getNick();
        } else {
            uin = user.getUin();
        }
        if (uin == null) {
            uin = "";
        }
        String c16 = c(uin, needColon, needAppendBlank);
        String uin2 = user.getUin();
        return a(uin2 != null ? uin2 : "", c16);
    }

    private final String c(String nickName, boolean needColon, boolean needAppendBlank) {
        String str;
        String elipseStringWide = StringUtil.getElipseStringWide(nickName, 30);
        Intrinsics.checkNotNullExpressionValue(elipseStringWide, "getElipseStringWide(nickNameStr, 30)");
        if (needAppendBlank) {
            elipseStringWide = "        " + elipseStringWide + " ";
        }
        if (needColon) {
            str = MsgSummary.STR_COLON;
        } else {
            str = "";
        }
        return elipseStringWide + str;
    }

    private final String a(String uin, String nickName) {
        String d16 = d(nickName, Integer.MAX_VALUE);
        try {
            String encode = URLEncoder.encode(d16, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(finalName, \"UTF-8\")");
            d16 = encode;
        } catch (Exception e16) {
            QLog.e("QzoneFeedProNickUtils", 1, "buildNicknameString, build nickname partially failed", e16);
        }
        return "<uin:" + uin + ",nickname:" + d16 + ">";
    }
}
