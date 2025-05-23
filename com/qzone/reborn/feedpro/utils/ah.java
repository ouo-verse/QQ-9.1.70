package com.qzone.reborn.feedpro.utils;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/ah;", "", "Ljava/util/regex/MatchResult;", "result", "", "targetString", "", "c", "d", "b", HippyControllerProps.STRING, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "a", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "regex", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final ah f54303a = new ah();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Pattern regex = Pattern.compile("@\\{uin:(\\d+?),nick:([^}]+)\\}\\B|@\\{uin:(\\d+?),nick:([^}]+),who:(\\d+?)\\}|\\{url:([^}]+?),text:([^}]+?)\\}|#\\{topic:([^}]+?),url:([^}]+?)\\}");

    ah() {
    }

    private final Map<String, String> c(MatchResult result, String targetString) {
        Map<String, String> mapOf;
        Map<String, String> mapOf2;
        if (result.group(1) != null) {
            String group = result.group(1);
            if (group == null) {
                group = "";
            }
            String group2 = result.group(2);
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", group), TuplesKt.to("nick", group2 != null ? group2 : ""));
            return mapOf2;
        }
        if (result.group(3) == null) {
            return null;
        }
        String group3 = result.group(3);
        if (group3 == null) {
            group3 = "";
        }
        String group4 = result.group(4);
        if (group4 == null) {
            group4 = "";
        }
        String group5 = result.group(5);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", group3), TuplesKt.to("nick", group4), TuplesKt.to("who", group5 != null ? group5 : ""));
        return mapOf;
    }

    private final Map<String, String> d(MatchResult result, String targetString) {
        Map<String, String> mapOf;
        if (result.group(6) == null) {
            return null;
        }
        String group = result.group(6);
        if (group == null) {
            group = "";
        }
        String group2 = result.group(7);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("url", group), TuplesKt.to("text", group2 != null ? group2 : ""));
        return mapOf;
    }

    private final Map<String, String> b(MatchResult result, String targetString) {
        Map<String, String> mapOf;
        if (result.group(8) == null) {
            return null;
        }
        String group = result.group(8);
        if (group == null) {
            group = "";
        }
        String group2 = result.group(9);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("topic", group), TuplesKt.to("url", group2 != null ? group2 : ""));
        return mapOf;
    }

    public final List<CommonRichMsg> a(String string) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (string == null || string.length() == 0) {
            return new ArrayList();
        }
        Matcher matcher = regex.matcher(string);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (start > i3) {
                String substring = string.substring(i3, start);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                CommonRichMsg commonRichMsg = new CommonRichMsg();
                commonRichMsg.setType(0);
                commonRichMsg.setContent(substring);
                arrayList.add(commonRichMsg);
            }
            CommonRichMsg commonRichMsg2 = new CommonRichMsg();
            MatchResult matchResult = matcher.toMatchResult();
            Intrinsics.checkNotNullExpressionValue(matchResult, "matcher.toMatchResult()");
            Map<String, String> c16 = c(matchResult, string);
            if (c16 != null) {
                commonRichMsg2.setType(1);
                String str = c16.get("uin");
                if (str == null) {
                    str = "";
                }
                commonRichMsg2.setUin(str);
                String str2 = c16.get("nick");
                if (str2 == null) {
                    str2 = "";
                }
                commonRichMsg2.setName(str2);
                String str3 = c16.get("who");
                commonRichMsg2.setWho(str3 != null ? Integer.parseInt(str3) : 0);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                MatchResult matchResult2 = matcher.toMatchResult();
                Intrinsics.checkNotNullExpressionValue(matchResult2, "matcher.toMatchResult()");
                Map<String, String> d16 = d(matchResult2, string);
                if (d16 != null) {
                    commonRichMsg2.setType(2);
                    String str4 = d16.get("url");
                    if (str4 == null) {
                        str4 = "";
                    }
                    commonRichMsg2.setUrl(str4);
                    String str5 = d16.get("text");
                    if (str5 == null) {
                        str5 = "";
                    }
                    commonRichMsg2.setContent(str5);
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    MatchResult matchResult3 = matcher.toMatchResult();
                    Intrinsics.checkNotNullExpressionValue(matchResult3, "matcher.toMatchResult()");
                    Map<String, String> b16 = b(matchResult3, string);
                    if (b16 != null) {
                        commonRichMsg2.setType(4);
                        String str6 = b16.get("topic");
                        if (str6 == null) {
                            str6 = "";
                        }
                        commonRichMsg2.setContent(str6);
                        String str7 = b16.get("url");
                        commonRichMsg2.setUrl(str7 != null ? str7 : "");
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        commonRichMsg2.setType(0);
                        String substring2 = string.substring(start, end);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        commonRichMsg2.setContent(substring2);
                    }
                }
            }
            arrayList.add(commonRichMsg2);
            i3 = end;
        }
        if (i3 < string.length()) {
            String substring3 = string.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            CommonRichMsg commonRichMsg3 = new CommonRichMsg();
            commonRichMsg3.setType(0);
            commonRichMsg3.setContent(substring3);
            arrayList.add(commonRichMsg3);
        }
        return arrayList;
    }
}
