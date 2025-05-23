package com.qzone.reborn.feedx.util;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u {
    public static List<pg.a> b(BusinessFeedData businessFeedData) {
        ArrayList arrayList = new ArrayList();
        if (businessFeedData == null) {
            return arrayList;
        }
        if (!bl.b(businessFeedData.getCommentInfo().commments)) {
            int size = businessFeedData.getCommentInfo().commments.size();
            QLog.i("QZoneFeedxDetailCommentDataTransferUtils", 1, "updateDetailCommentData() addComment size = " + size);
            for (int i3 = 0; i3 < size; i3++) {
                a(businessFeedData, arrayList, businessFeedData.getCommentInfo().commments.get(i3), i3);
            }
        }
        if (businessFeedData.getCommentEssence() != null && !bl.b(businessFeedData.getCommentEssence().commments)) {
            int size2 = businessFeedData.getCommentEssence().commments.size();
            QLog.i("QZoneFeedxDetailCommentDataTransferUtils", 1, "updateDetailCommentData() addCommentEssence size = " + size2);
            for (int i16 = 0; i16 < size2; i16++) {
                a(businessFeedData, arrayList, businessFeedData.getCommentEssence().commments.get(i16), !bl.b(businessFeedData.getCommentInfo().commments) ? businessFeedData.getCommentInfo().commments.size() + i16 : i16);
            }
        }
        return arrayList;
    }

    private static void a(BusinessFeedData businessFeedData, List<pg.a> list, Comment comment, int i3) {
        if (list == null || comment == null) {
            return;
        }
        pg.a aVar = new pg.a(101, comment);
        aVar.f426124b = businessFeedData;
        aVar.f426127e = i3;
        list.add(aVar);
        if (bl.b(comment.replies)) {
            return;
        }
        int size = comment.replies.size();
        if (comment.isNeedShrink && comment.displayReplyNum >= 0) {
            size = Math.min(comment.replies.size(), comment.displayReplyNum);
        }
        for (int i16 = 0; i16 < size; i16++) {
            pg.a aVar2 = new pg.a(102, comment);
            aVar2.f426124b = businessFeedData;
            aVar2.f426127e = i3;
            aVar2.f426126d = comment.replies.get(i16);
            aVar2.f426128f = i16;
            list.add(aVar2);
        }
        if (size < comment.replies.size()) {
            pg.a aVar3 = new pg.a(103, comment);
            aVar3.f426124b = businessFeedData;
            aVar3.f426127e = i3;
            list.add(aVar3);
        }
    }
}
