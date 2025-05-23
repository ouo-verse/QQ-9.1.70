package com.qzone.reborn.feedx.util;

import NS_MOBILE_FEEDS.cell_comm;
import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.feed.business.model.FeedHolidayCommentEvent;
import com.qzone.feed.business.model.FeedHolidayCommentInfo;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.feed.business.service.QZoneFeedUpdateService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedx/util/aa;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/feed/business/model/FeedHolidayCommentInfo;", "c", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "feedPosition", "", "b", "", "g", "d", tl.h.F, "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)Ljava/lang/Integer;", "f", "Lcom/qzone/feed/business/model/FeedHolidayCommentEvent;", "commentEvent", "e", "Lcom/qzone/proxy/feedcomponent/model/l;", "jceCellData", "i", "", "j", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    public static final aa f55707a = new aa();

    aa() {
    }

    private final FeedHolidayCommentInfo c(BusinessFeedData feedData) {
        return FeedHolidayCommentInfo.INSTANCE.a(feedData);
    }

    @JvmStatic
    public static final String d(BusinessFeedData feedData) {
        ArrayList<FeedHolidayCommentInfo.CommentRes.CommentInfo> commentInfo;
        String str;
        String str2;
        FeedHolidayCommentInfo.CommentRes commentRes = f55707a.c(feedData).getCommentRes();
        String str3 = null;
        if (commentRes != null && (commentInfo = commentRes.getCommentInfo()) != null) {
            for (FeedHolidayCommentInfo.CommentRes.CommentInfo commentInfo2 : commentInfo) {
                if (com.qzone.reborn.util.k.f59549a.f()) {
                    com.tencent.mobileqq.service.qzone.e eVar = com.tencent.mobileqq.service.qzone.e.f286406a;
                    FeedResourceInfo resInfo = commentInfo2.getResInfo();
                    if (resInfo == null || (str = resInfo.getBgDark()) == null) {
                        str = "";
                    }
                    str3 = eVar.a(str);
                } else {
                    com.tencent.mobileqq.service.qzone.e eVar2 = com.tencent.mobileqq.service.qzone.e.f286406a;
                    FeedResourceInfo resInfo2 = commentInfo2.getResInfo();
                    if (resInfo2 == null || (str2 = resInfo2.getBgLight()) == null) {
                        str2 = "";
                    }
                    str3 = eVar2.a(str2);
                }
            }
        }
        return str3 == null ? "" : str3;
    }

    @JvmStatic
    public static final String e(FeedHolidayCommentEvent commentEvent) {
        FeedResourceInfo tipsInfo;
        String text;
        return (!com.tencent.mobileqq.service.qzone.e.f286406a.c() || commentEvent == null || (tipsInfo = commentEvent.getTipsInfo()) == null || (text = tipsInfo.getText()) == null) ? "" : text;
    }

    @JvmStatic
    public static final String g(BusinessFeedData feedData) {
        FeedHolidayCommentInfo.CommentRes commentRes;
        FeedResourceInfo inputHit;
        String text;
        return (!com.tencent.mobileqq.service.qzone.e.f286406a.c() || (commentRes = f55707a.c(feedData).getCommentRes()) == null || (inputHit = commentRes.getInputHit()) == null || (text = inputHit.getText()) == null) ? "" : text;
    }

    @JvmStatic
    public static final Integer h(BusinessFeedData feedData) {
        String str;
        ArrayList<FeedHolidayCommentInfo.CommentRes.CommentInfo> commentInfo;
        FeedResourceInfo resInfo;
        String textColorLight;
        FeedResourceInfo resInfo2;
        FeedHolidayCommentInfo.CommentRes commentRes = f55707a.c(feedData).getCommentRes();
        if (commentRes == null || (commentInfo = commentRes.getCommentInfo()) == null) {
            str = null;
        } else {
            str = null;
            for (FeedHolidayCommentInfo.CommentRes.CommentInfo commentInfo2 : commentInfo) {
                String str2 = "";
                if (!com.qzone.reborn.util.k.f59549a.f() ? !((resInfo = commentInfo2.getResInfo()) == null || (textColorLight = resInfo.getTextColorLight()) == null) : !((resInfo2 = commentInfo2.getResInfo()) == null || (textColorLight = resInfo2.getTextColorDark()) == null)) {
                    str2 = textColorLight;
                }
                str = str2;
            }
        }
        if (str != null) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (Exception e16) {
                QLog.e("QZoneHolidayCommentManger", 1, "[getNickTextColor]  e = " + e16);
            }
        }
        return null;
    }

    @JvmStatic
    public static final boolean i(com.qzone.proxy.feedcomponent.model.l jceCellData) {
        cell_comm cell_commVar;
        Map<String, String> map;
        if (!com.tencent.mobileqq.service.qzone.e.f286406a.c() || !com.qzone.reborn.configx.g.f53821a.b().K() || jceCellData == null || (cell_commVar = jceCellData.f50340a) == null || (map = cell_commVar.extendInfo) == null) {
            return false;
        }
        boolean containsKey = map.containsKey("comment_res");
        QLog.i("QZoneHolidayCommentManger", 1, "is contain comment res is " + containsKey);
        if (containsKey) {
            QLog.i("QZoneHolidayCommentManger", 1, "comment res is" + jceCellData.f50340a.extendInfo.get("comment_res"));
        }
        return containsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(BusinessFeedData businessFeedData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(businessFeedData);
        QZoneFeedUpdateService.c().b(arrayList);
    }

    @JvmStatic
    public static final Comment f(BusinessFeedData feedData) {
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList = (feedData == null || (commentInfo = feedData.getCommentInfo()) == null) ? null : commentInfo.commments;
        if (bl.b(arrayList)) {
            return null;
        }
        Intrinsics.checkNotNull(arrayList);
        return arrayList.get(0);
    }

    @JvmStatic
    public static final void j(final BusinessFeedData feedData) {
        if (feedData != null && com.tencent.mobileqq.service.qzone.e.f286406a.c()) {
            com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
            if (gVar.b().K() && gVar.l().l()) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.util.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        aa.k(BusinessFeedData.this);
                    }
                });
            }
        }
    }

    @JvmStatic
    public static final boolean b(BusinessFeedData feedData, Comment comment, int feedPosition) {
        FeedHolidayCommentInfo.CommentRes commentRes;
        ArrayList<FeedHolidayCommentInfo.CommentRes.CommentInfo> commentInfo;
        if (feedPosition == 0 && com.tencent.mobileqq.service.qzone.e.f286406a.c() && !TextUtils.isEmpty(d(feedData)) && (commentRes = f55707a.c(feedData).getCommentRes()) != null && (commentInfo = commentRes.getCommentInfo()) != null) {
            for (FeedHolidayCommentInfo.CommentRes.CommentInfo commentInfo2 : commentInfo) {
                if (!TextUtils.isEmpty(commentInfo2.getCommentId())) {
                    if (TextUtils.equals(comment != null ? comment.commentid : null, commentInfo2.getCommentId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
