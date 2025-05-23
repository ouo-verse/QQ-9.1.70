package com.qzone.adapter.feedcomponent;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellPicTextInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTheme;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.widget.x;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f41883a = h.b("QZoneSetting", "CommentBubbleNickMaxLen", 16);

    public static void c(CellCommentInfo cellCommentInfo) {
        try {
            ArrayList<Comment> arrayList = cellCommentInfo.commments;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator<Comment> it = cellCommentInfo.commments.iterator();
            while (it.hasNext()) {
                Comment next = it.next();
                next.feedType = cellCommentInfo.feedType;
                a(next);
                d(next);
            }
        } catch (Exception unused) {
        }
    }

    public static void h(CellPictureInfo cellPictureInfo, String str, String str2, boolean z16) {
        cellPictureInfo.displayStr = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("picture");
        if (z16) {
            sb5.append(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        }
        cellPictureInfo.uniKey = sb5.toString();
        i.H().P1(cellPictureInfo.displayStr);
    }

    public static void j(CellReferInfo cellReferInfo, String str) {
        if (TextUtils.isEmpty(cellReferInfo.appName)) {
            return;
        }
        String str2 = str + cellReferInfo.appName + CellReferInfo.REFER_TAB;
        cellReferInfo.uniKey = str2;
        cellReferInfo.integerUniKey = Integer.valueOf(str2.hashCode());
        i.H().P1(cellReferInfo.appName);
    }

    public static void q(CellQbossPsvAdv cellQbossPsvAdv, String str) {
        cellQbossPsvAdv.calucateText(str);
    }

    public static String r(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Matcher matcher = Pattern.compile("@?\\{uin:.*?\\}").matcher(str);
            str2 = str;
            while (matcher.find()) {
                try {
                    String group = matcher.group();
                    if (!TextUtils.isEmpty(group)) {
                        if (group.contains("nickname:")) {
                            str3 = "nickname:";
                        } else {
                            str3 = group.contains("nick:") ? "nick:" : null;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            int indexOf = group.indexOf(str3) + str3.length();
                            int indexOf2 = group.indexOf(",", indexOf);
                            if (indexOf2 < 0) {
                                indexOf2 = group.indexOf("}", indexOf);
                            }
                            str2 = str2.replace(group, "@" + group.substring(indexOf, indexOf2));
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    com.qzone.proxy.feedcomponent.b.d("Feed", "convertAtPattern error! content:" + str, th);
                    return str2;
                }
            }
            Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
            Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
            str2 = s(x.f61180j, s(x.f61179i, str2));
            return s(x.f61175e, str2);
        } catch (Throwable th6) {
            th = th6;
            str2 = str;
        }
    }

    private static String s(Pattern pattern, String str) {
        if (!TextUtils.isEmpty(str) && pattern != null && !TextUtils.isEmpty(pattern.pattern())) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    str = str.replace(group, "");
                }
            }
        }
        return str;
    }

    public static String t(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !str.contains(QzoneEmotionUtils.EMO_PREFIX)) {
            return str;
        }
        try {
            Matcher matcher = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]").matcher(str);
            str2 = str;
            while (matcher.find()) {
                try {
                    String group = matcher.group();
                    if (!TextUtils.isEmpty(group)) {
                        str2 = str2.replace(group, "");
                    }
                } catch (Throwable th5) {
                    th = th5;
                    com.qzone.proxy.feedcomponent.b.d("Feed", "filterEmPattern error! content:" + str, th);
                    return str2;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            str2 = str;
        }
        return str2;
    }

    private static String v(User user) {
        String replace;
        String replace2 = h.c("H5Url", "vipIconGifUrl", "").replace("{type}", "android");
        if (user == null) {
            return null;
        }
        if (user.isAnnualVip == 0) {
            replace = replace2.replace("{isAnnual}", "0");
        } else {
            replace = replace2.replace("{isAnnual}", "1");
        }
        return replace.replace("{vipLevel}", user.vipLevel + "");
    }

    public static void x(BusinessFeedData businessFeedData, boolean z16) {
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().preCalculateData(businessFeedData, z16);
        if (FeedGlobalEnv.g().isAccessibilityEnable()) {
            businessFeedData.preCalculateReadStr();
        }
    }

    public static void w(BusinessFeedData businessFeedData) {
        x(businessFeedData, true);
    }

    public static String b(BusinessFeedData businessFeedData) {
        User user;
        if (businessFeedData == null || (user = businessFeedData.getUser()) == null || TextUtils.isEmpty(user.nickName)) {
            return null;
        }
        return "\u56de\u590d" + user.nickName + ":";
    }

    public static void e(User user, String str) {
        if (user == null || TextUtils.isEmpty(user.qzoneDesc)) {
            return;
        }
        String str2 = str + User.USER_TAB;
        user.desuniKey = str2;
        user.integerDesuniKey = Integer.valueOf(str2.hashCode());
        i.H().P1(user.qzoneDesc);
    }

    public static void f(CellLbsInfo cellLbsInfo, String str, CellTheme cellTheme) {
        if (cellLbsInfo == null || TextUtils.isEmpty(cellLbsInfo.getLBSString())) {
            return;
        }
        String str2 = str + CellLbsInfo.LBS_TAB;
        cellLbsInfo.uniKey = str2;
        cellLbsInfo.integerUniKey = Integer.valueOf(str2.hashCode());
        i.H().P1(cellLbsInfo.getLBSString());
    }

    public static void n(User user) {
        if (user != null) {
            user.yellowDiamondUrl = v(user);
        }
    }

    public static void a(Comment comment) {
        String parseCommentTextAreaCommentText;
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo;
        if (comment == null) {
            return;
        }
        if (comment.user != null) {
            int i3 = comment.feedType;
            if (i3 != 4098) {
                barrageEffectInfo = comment.getBarrageEffectInfo(i3 == 4097);
            } else {
                barrageEffectInfo = null;
            }
            int i16 = (barrageEffectInfo == null || barrageEffectInfo.f51896id <= 0) ? Integer.MAX_VALUE : f41883a;
            StringBuilder sb5 = new StringBuilder();
            User user = comment.user;
            sb5.append(com.qzone.proxy.feedcomponent.util.h.c(user.uin, user.nickName, i16));
            sb5.append("{text:");
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.c(1)));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            String str = comment.comment;
            if (str != null) {
                sb5.append(str);
            }
            comment.displayStr = sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        Object obj = comment.feedKey;
        if (obj == null) {
            obj = UUID.randomUUID();
        }
        sb6.append(obj);
        sb6.append(comment.commentid);
        String sb7 = sb6.toString();
        comment.uniKey = sb7;
        comment.commentAreaCacheKey = Integer.valueOf((sb7 == null && (sb7 = comment.fakeUniKey) == null) ? -1 : sb7.hashCode());
        if (!TextUtils.isEmpty(comment.displayStr)) {
            parseCommentTextAreaCommentText = comment.displayStr;
        } else {
            parseCommentTextAreaCommentText = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().parseCommentTextAreaCommentText(comment.user, comment.comment);
        }
        i.H().P1(parseCommentTextAreaCommentText);
    }

    public static void d(Comment comment) {
        String str;
        if (comment == null) {
            return;
        }
        List<Reply> list = comment.replies;
        if (list != null && list.size() > 0) {
            comment.displayReplyStr = new ArrayList<>(comment.replies.size());
            for (int i3 = 0; i3 < comment.replies.size(); i3++) {
                Reply reply = comment.replies.get(i3);
                if (reply != null) {
                    if (reply.user == null) {
                        reply.user = new User();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    User user = reply.user;
                    sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user.uin, user.nickName));
                    User user2 = reply.targetUser;
                    if (user2 != null && user2.uin > 0 && !TextUtils.isEmpty(user2.nickName)) {
                        sb5.append("{text:");
                        sb5.append(" \u56de\u590d ");
                        sb5.append(",color:");
                        sb5.append(Integer.toHexString(j.c(1)));
                        sb5.append(",useDefaultFont:1,useSuperFont:0}");
                        User user3 = reply.targetUser;
                        sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user3.uin, user3.nickName));
                    }
                    sb5.append("{text:");
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append(",color:");
                    sb5.append(Integer.toHexString(j.c(1)));
                    sb5.append(",useDefaultFont:1,useSuperFont:0}");
                    sb5.append(reply.content);
                    comment.displayReplyStr.add(sb5.toString());
                    StringBuilder sb6 = new StringBuilder();
                    Object obj = comment.feedKey;
                    if (obj == null) {
                        obj = UUID.randomUUID();
                    }
                    sb6.append(obj);
                    sb6.append(comment.commentid);
                    sb6.append("_reply");
                    if (TextUtils.isEmpty(reply.replyId)) {
                        str = reply.content;
                    } else {
                        str = reply.replyId;
                    }
                    sb6.append(str);
                    String sb7 = sb6.toString();
                    reply.uinKey = sb7;
                    reply.replyAreaCacheKey = Integer.valueOf(sb7.hashCode());
                }
            }
            for (int i16 = 0; i16 < comment.replies.size(); i16++) {
                Reply reply2 = comment.replies.get(i16);
                com.qzone.proxy.feedcomponent.c cVar = com.qzone.proxy.feedcomponent.c.f50143a;
                String commentTextAreaDisReplyStr = cVar.getUiInterface().getCommentTextAreaDisReplyStr(comment, i16);
                if (TextUtils.isEmpty(commentTextAreaDisReplyStr)) {
                    commentTextAreaDisReplyStr = cVar.getUiInterface().parseCommentTextAreaReplyText(reply2);
                }
                i.H().P1(commentTextAreaDisReplyStr);
            }
            return;
        }
        comment.displayReplyStr = null;
    }

    public static void g(User user, String str) {
        if (user == null) {
            return;
        }
        user.nickNameAreaCacheKey = Integer.valueOf((user.uin + "_" + user.nickName + "_" + ((int) user.isNickNameFlash) + "_" + str).hashCode());
    }

    public static void i(CellPicTextInfo cellPicTextInfo, String str) {
        if (cellPicTextInfo == null) {
            return;
        }
        cellPicTextInfo.uniKeyLeft = str + CellPicTextInfo.PICTEXT_TAB_LEFT;
        cellPicTextInfo.uniKeyRight = str + CellPicTextInfo.PICTEXT_TAB_RIGHT;
        if (cellPicTextInfo.dataNum <= 0 || cellPicTextInfo.picTexts == null) {
            return;
        }
        for (int i3 = 0; i3 < cellPicTextInfo.picTexts.size(); i3++) {
            PicText picText = cellPicTextInfo.picTexts.get(i3);
            String str2 = picText.summary;
            if (i3 == 0) {
                i.H().P1(str2);
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().getAreaManagerInstance().getPicTextArea(str2, picText.postFix, cellPicTextInfo.uniKeyLeft);
            }
        }
    }

    public static void k(CellRemarkInfo cellRemarkInfo, String str, boolean z16) {
        if (cellRemarkInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(cellRemarkInfo.remark) && TextUtils.isEmpty(cellRemarkInfo.getShootInfoStringOrig())) {
            return;
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (!TextUtils.isEmpty(cellRemarkInfo.remark)) {
            sb5.append("remark");
            String sb6 = sb5.toString();
            cellRemarkInfo.unikeyRemark = sb6;
            cellRemarkInfo.integerUnikeyRemark = Integer.valueOf(sb6.hashCode());
            i.H().P1(cellRemarkInfo.getRemarkDisplayStr());
            sb5.delete((str.length() == 0 ? 1 : str.length()) - 1, sb5.length());
        }
        if (TextUtils.isEmpty(cellRemarkInfo.getShootInfoStringOrig())) {
            return;
        }
        sb5.append(CellRemarkInfo.SHOOTINFO_TAB);
        String sb7 = sb5.toString();
        cellRemarkInfo.unikeyShoot = sb7;
        cellRemarkInfo.integerUnikeyShoot = Integer.valueOf(sb7.hashCode());
        i.H().P1(cellRemarkInfo.getShootInfoStringOrig());
    }

    public static void m(CellTitleInfo cellTitleInfo, String str, String str2, boolean z16, boolean z17, boolean z18) {
        List<User> list;
        if (cellTitleInfo == null) {
            return;
        }
        cellTitleInfo.displayTitle = str;
        if (z17 && (list = cellTitleInfo.userList) != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (User user : cellTitleInfo.userList) {
                sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user.uin, user.nickName));
                sb5.append("\u3001");
            }
            cellTitleInfo.likeListStr = sb5.substring(0, sb5.lastIndexOf("\u3001"));
            int i3 = cellTitleInfo.userNum - 1;
            if (i3 <= 0) {
                i3 = cellTitleInfo.userList.size();
            }
            if (i3 != cellTitleInfo.userList.size()) {
                cellTitleInfo.likeListStr += "\u7b49" + i3 + "\u4eba\u4e5f\u89c9\u5f97\u5f88\u8d5e";
            } else {
                cellTitleInfo.likeListStr += "\u4e5f\u89c9\u5f97\u5f88\u8d5e";
            }
        } else {
            cellTitleInfo.likeListStr = null;
        }
        if (z17 || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str2);
        sb6.append("title");
        if (z16) {
            sb6.append(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        }
        String sb7 = sb6.toString();
        cellTitleInfo.uniKey = sb7;
        cellTitleInfo.integerUnikey = Integer.valueOf(sb7.hashCode());
        i.H().P1(cellTitleInfo.displayTitle);
    }

    public static void o(CellVisitorInfo cellVisitorInfo, String str, boolean z16) {
        if (cellVisitorInfo == null) {
            return;
        }
        if (cellVisitorInfo.viewCount > 0) {
            cellVisitorInfo.displayStr = "\u6d4f\u89c8" + com.qzone.proxy.feedcomponent.util.d.l(cellVisitorInfo.viewCount) + "\u6b21";
            cellVisitorInfo.visitorDecoDisplayStr = h.c("H5Url", "customBrowserString", "\u70ed\u5ea6") + " " + com.qzone.proxy.feedcomponent.util.d.l(cellVisitorInfo.viewCount) + "\u00b0C";
            return;
        }
        cellVisitorInfo.unikey = null;
    }

    public static void p(CellLeftThumb cellLeftThumb, String str, boolean z16, boolean z17, boolean z18) {
        if (cellLeftThumb == null) {
            return;
        }
        cellLeftThumb.calucateText(str, z16, z17, z18);
        cellLeftThumb.hasPic();
        i.H().P1(cellLeftThumb.getParseTitle());
        i.H().P1(cellLeftThumb.getParseSummary());
        cellLeftThumb.calPictureInfo(z16);
    }

    public static FeedPictureInfo[] u(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return null;
        }
        if (businessFeedData.photoMode != i3) {
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().calculatePic(businessFeedData);
        }
        return businessFeedData.pics;
    }

    public static void l(CellSummary cellSummary, String str, String str2, boolean z16, boolean z17, boolean z18, BusinessFeedData businessFeedData) {
        if (cellSummary == null) {
            return;
        }
        if (z17 && !TextUtils.isEmpty(cellSummary.customPraiseStr)) {
            cellSummary.displayStr = cellSummary.customPraiseStr + " " + str;
        } else if (businessFeedData != null && businessFeedData.getCellLuckyMoney() != null) {
            cellSummary.displayStr = businessFeedData.getCellLuckyMoney().calculateSummaryDisplayStr(str);
        } else {
            cellSummary.displayStr = str;
        }
        String r16 = r(cellSummary.displayStr);
        cellSummary.displayReadeableStr = r16;
        cellSummary.displayReadeableStr = t(r16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("summary");
        if (z16) {
            sb5.append(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        }
        if (businessFeedData != null && businessFeedData.isSubFeed) {
            sb5.append("_subfeed" + businessFeedData.containerIndex);
        }
        sb5.append("_type");
        sb5.append(businessFeedData != null ? businessFeedData.feedType : 0);
        sb5.append("_summary");
        sb5.append(str);
        String sb6 = sb5.toString();
        cellSummary.uniKey = sb6;
        cellSummary.summaryAreaCacheKey = Integer.valueOf(sb6.hashCode());
        i.H().P1(cellSummary.displayStr);
    }
}
