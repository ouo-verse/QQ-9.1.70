package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_comment_essence;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCommentEssence implements SmartParcelable {

    @NeedParcel
    public String attachInfo = "";

    @NeedParcel
    public int commentNum;

    @NeedParcel
    public String commentNumInfoFoldText;

    @NeedParcel
    public ArrayList<Comment> commments;
    public boolean enableSwitchSort;

    @NeedParcel
    public int realCount;
    public boolean showHeader;

    public void deleteRepeatComment(String str) {
        Comment comment;
        if (TextUtils.isEmpty(str) || this.commments == null) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= this.commments.size()) {
                comment = null;
                break;
            } else {
                if (this.commments.get(i3) != null && str.equals(this.commments.get(i3).commentid) && (i16 = i16 + 1) >= 2) {
                    comment = this.commments.get(i3);
                    break;
                }
                i3++;
            }
        }
        if (comment != null) {
            this.commments.remove(comment);
        }
    }

    public static CellCommentEssence create(l lVar) {
        if (lVar == null || lVar.Y == null) {
            return null;
        }
        String str = UUID.randomUUID() + "";
        CellCommentEssence cellCommentEssence = new CellCommentEssence();
        cell_comment_essence cell_comment_essenceVar = lVar.Y;
        cellCommentEssence.commentNum = cell_comment_essenceVar.num;
        cellCommentEssence.commentNumInfoFoldText = cell_comment_essenceVar.txt;
        if (cell_comment_essenceVar.commments != null) {
            cellCommentEssence.commments = new ArrayList<>();
            int size = lVar.Y.commments.size();
            for (int i3 = 0; i3 < size; i3++) {
                Comment e16 = com.qzone.proxy.feedcomponent.util.e.e(lVar.Y.commments.get(i3), str);
                e16.commentType = 1;
                cellCommentEssence.commments.add(e16);
            }
        }
        cell_comment cell_commentVar = lVar.f50362l;
        if (cell_commentVar != null) {
            cellCommentEssence.realCount = cell_commentVar.iRealCount;
        }
        int i16 = lVar.Y.displayflag;
        cellCommentEssence.enableSwitchSort = (i16 & 1) != 0;
        cellCommentEssence.showHeader = (i16 & 2) != 0;
        return cellCommentEssence;
    }
}
