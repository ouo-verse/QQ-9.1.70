package cd;

import android.text.TextUtils;
import com.qzone.common.activities.base.aj;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.util.am;
import com.tencent.mobileqq.R;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007R\u001f\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcd/b;", "", "", "a", "", "str", "c", "content", "", "Lcom/qzone/common/friend/business/model/Friend;", "atUserList", "b", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "getPATTERN_EMO", "()Ljava/util/regex/Pattern;", "PATTERN_EMO", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f30654a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Pattern PATTERN_EMO = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);

    b() {
    }

    @JvmStatic
    public static final boolean a() {
        gd.a.f401926a.c("KEY_ENABLE_USE_NEW_COMMENT_PANEL", true);
        return com.qzone.reborn.configx.g.f53821a.b().v0();
    }

    @JvmStatic
    public static final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        StringBuilder sb5 = new StringBuilder(length);
        Matcher matcher = PATTERN_EMO.matcher(str);
        int i3 = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (start > i3) {
                String substring = str.substring(i3, start);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
            }
            String substring2 = str.substring(start, end);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String emCodeToQQcode = QzoneEmotionUtils.emCodeToQQcode(substring2);
            if (!TextUtils.isEmpty(emCodeToQQcode)) {
                sb5.append(emCodeToQQcode);
            } else {
                String substring3 = str.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb5.append(substring3);
            }
            i3 = end;
        }
        if (length > i3) {
            String substring4 = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
            sb5.append(substring4);
        }
        return sb5.toString();
    }

    @JvmStatic
    public static final String b(String content, List<? extends Friend> atUserList) {
        String formatNick;
        String formatNick2;
        String replace$default;
        boolean contains$default;
        if (content == null) {
            return "";
        }
        List<? extends Friend> list = atUserList;
        if (list == null || list.isEmpty()) {
            return content;
        }
        String str = content;
        for (Friend friend : atUserList) {
            String str2 = friend.mName;
            if (str2 == null) {
                long j3 = friend.mUin;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                str2 = sb5.toString();
            }
            String formatNick3 = str2;
            Intrinsics.checkNotNullExpressionValue(formatNick3, "formatNick");
            formatNick = StringsKt__StringsJVMKt.replace$default(formatNick3, "%", "%25", false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(formatNick, "formatNick");
            formatNick2 = StringsKt__StringsJVMKt.replace$default(formatNick, ",", "%2C", false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(formatNick2, "formatNick");
            replace$default = StringsKt__StringsJVMKt.replace$default(formatNick2, "}", "%7D", false, 4, (Object) null);
            String str3 = "@{uin:" + friend.mUin + ",nick:" + replace$default + "}";
            String str4 = "@" + aj.m(friend.mName);
            if (!TextUtils.isEmpty(friend.mName)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str4, false, 2, (Object) null);
                if (contains$default) {
                    str = am.j(str4, str, str3);
                    Intrinsics.checkNotNullExpressionValue(str, "replaceFirst(nickName, tmpStr, format)");
                }
            }
        }
        String a16 = com.qzone.util.l.a(R.string.m5g);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026.qqstr_emoeditp_555dedf7)");
        Regex regex = new Regex(a16);
        String a17 = com.qzone.util.l.a(R.string.m5p);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(com.tencent.mobile\u2026.qqstr_emoeditp_c5e9ac47)");
        String replace = regex.replace(str, a17);
        String a18 = com.qzone.util.l.a(R.string.m5m);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(com.tencent.mobile\u2026.qqstr_emoeditp_b0a99a5b)");
        return new Regex(a18).replace(replace, "/MM");
    }
}
