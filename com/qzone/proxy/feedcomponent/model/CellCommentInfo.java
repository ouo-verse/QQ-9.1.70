package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_plug_in_comment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCommentInfo implements Parcelable {
    public static final Parcelable.Creator<CellCommentInfo> CREATOR = new a();
    private static final String TAG = "CellCommentInfo";

    @NeedParcel
    public int actionType;

    @NeedParcel
    public CellCommentPlugin cellCommentPlugin;

    @NeedParcel
    public int commentAndReplyNum;

    @NeedParcel
    public int commentNum;

    @NeedParcel
    public String commentNumInfoFoldText;

    @NeedParcel
    public ArrayList<Comment> commments;

    @NeedParcel
    public boolean enableSwitchSort;

    @NeedParcel
    public int feedType;

    @NeedParcel
    public String feedkey;

    @NeedParcel
    public Integer integerUnikeyCommentRealCount;

    @NeedParcel
    public Comment mainComment;

    @NeedParcel
    public byte moreCommentHasLoaded;

    @NeedParcel
    public int realCount;

    @NeedParcel
    public int serverRspTotalCommentNum;

    @NeedParcel
    public boolean showHeader;

    @NeedParcel
    public String unikeyCommentRealCount;

    @NeedParcel
    public int unreadCnt;

    @NeedParcel
    public int unreadCount;

    @NeedParcel
    public String attachInfo = "";

    @NeedParcel
    public CommentState commentState = CommentState.FOLDED;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum CommentState {
        FOLDED,
        UNFOLD,
        LOADING,
        NONE
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<CellCommentInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CellCommentInfo createFromParcel(Parcel parcel) {
            CellCommentInfo cellCommentInfo = new CellCommentInfo();
            cellCommentInfo.commentNum = parcel.readInt();
            cellCommentInfo.unreadCnt = parcel.readInt();
            cellCommentInfo.commments = ParcelableWrapper.createArrayListFromParcel(parcel);
            cellCommentInfo.mainComment = (Comment) ParcelableWrapper.createDataFromParcel(parcel);
            cellCommentInfo.attachInfo = parcel.readString();
            cellCommentInfo.moreCommentHasLoaded = parcel.readByte();
            int readInt = parcel.readInt();
            if (readInt == 0) {
                cellCommentInfo.commentState = CommentState.FOLDED;
            } else if (readInt == 1) {
                cellCommentInfo.commentState = CommentState.UNFOLD;
            } else if (readInt == 2) {
                cellCommentInfo.commentState = CommentState.LOADING;
            } else if (readInt != 3) {
                cellCommentInfo.commentState = CommentState.FOLDED;
            } else {
                cellCommentInfo.commentState = CommentState.NONE;
            }
            cellCommentInfo.unreadCount = parcel.readInt();
            cellCommentInfo.actionType = parcel.readInt();
            cellCommentInfo.realCount = parcel.readInt();
            cellCommentInfo.commentNumInfoFoldText = parcel.readString();
            cellCommentInfo.cellCommentPlugin = (CellCommentPlugin) ParcelableWrapper.createDataFromParcel(parcel);
            cellCommentInfo.commentAndReplyNum = parcel.readInt();
            return cellCommentInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CellCommentInfo[] newArray(int i3) {
            return null;
        }
    }

    public static CellCommentInfo read(l lVar) {
        return null;
    }

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
                if (str.equals(this.commments.get(i3).commentid) && (i16 = i16 + 1) >= 2) {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean hasComments() {
        ArrayList<Comment> arrayList = this.commments;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean hasFakeComments() {
        if (!hasComments()) {
            return false;
        }
        Iterator<Comment> it = this.commments.iterator();
        while (it.hasNext()) {
            if (it.next().isFake) {
                return true;
            }
        }
        return false;
    }

    public void mergeComment(List<s_commment> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        s_commment s_commmentVar = null;
        for (s_commment s_commmentVar2 : list) {
            mergeComment(s_commmentVar2, s_commmentVar != null ? s_commmentVar.commentid : null);
            s_commmentVar = s_commmentVar2;
        }
    }

    public void preCalculate() {
        try {
            ArrayList<Comment> arrayList = this.commments;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator<Comment> it = this.commments.iterator();
            while (it.hasNext()) {
                Comment next = it.next();
                com.qzone.adapter.feedcomponent.d.a(next);
                com.qzone.adapter.feedcomponent.d.d(next);
            }
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "CellCommentInfo@" + hashCode() + " { commentNum: " + this.commentNum + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.commentNum);
        parcel.writeInt(this.unreadCnt);
        ParcelableWrapper.writeArrayListToParcel(parcel, i3, this.commments != null ? new ArrayList(this.commments) : null);
        ParcelableWrapper.writeDataToParcel(parcel, i3, this.mainComment);
        parcel.writeString(this.attachInfo);
        parcel.writeByte(this.moreCommentHasLoaded);
        parcel.writeInt(this.commentState.ordinal());
        parcel.writeInt(this.unreadCount);
        parcel.writeInt(this.actionType);
        parcel.writeInt(this.realCount);
        parcel.writeString(this.commentNumInfoFoldText);
        ParcelableWrapper.writeDataToParcel(parcel, i3, this.cellCommentPlugin);
        parcel.writeInt(this.commentAndReplyNum);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CellCommentInfo create(l lVar) {
        String str;
        s_plug_in_comment s_plug_in_commentVar;
        int i3;
        if (lVar == null || lVar.f50362l == null) {
            return null;
        }
        cell_comm cell_commVar = lVar.f50340a;
        if (cell_commVar != null && !TextUtils.isEmpty(cell_commVar.feedskey)) {
            str = lVar.f50340a.feedskey;
        } else {
            str = UUID.randomUUID() + "";
        }
        CellCommentInfo cellCommentInfo = new CellCommentInfo();
        cellCommentInfo.feedkey = str;
        cell_comment cell_commentVar = lVar.f50362l;
        cellCommentInfo.commentNum = cell_commentVar.num;
        cellCommentInfo.unreadCnt = cell_commentVar.unreadCnt;
        cellCommentInfo.mainComment = com.qzone.proxy.feedcomponent.util.e.e(cell_commentVar.main_comment, str);
        cell_comment cell_commentVar2 = lVar.f50362l;
        cellCommentInfo.commentNumInfoFoldText = cell_commentVar2.txt;
        cellCommentInfo.commentAndReplyNum = cell_commentVar2.comment_and_reply_num;
        if (cell_commentVar2.commments != null) {
            cellCommentInfo.commments = new ArrayList<>();
            try {
                int size = lVar.f50362l.commments.size();
                i3 = 0;
                while (i3 < size) {
                    try {
                        cellCommentInfo.commments.add(com.qzone.proxy.feedcomponent.util.e.e(lVar.f50362l.commments.get(i3), str));
                        i3++;
                    } catch (Throwable th5) {
                        th = th5;
                        com.qzone.proxy.feedcomponent.b.d(TAG, "Parse comment error! Current comment index is " + i3, th);
                        s_plug_in_commentVar = lVar.f50362l.plug_in_info;
                        if (s_plug_in_commentVar != null) {
                        }
                        cell_comment cell_commentVar3 = lVar.f50362l;
                        cellCommentInfo.unreadCount = cell_commentVar3.unreadCnt;
                        cellCommentInfo.actionType = cell_commentVar3.actiontype;
                        cellCommentInfo.realCount = cell_commentVar3.iRealCount;
                        int i16 = cell_commentVar3.displayflag;
                        cellCommentInfo.enableSwitchSort = (i16 & 1) == 0;
                        cellCommentInfo.showHeader = (i16 & 2) != 0;
                        String str2 = str + "_comment_real_count_" + cellCommentInfo.realCount;
                        cellCommentInfo.unikeyCommentRealCount = str2;
                        cellCommentInfo.integerUnikeyCommentRealCount = Integer.valueOf(str2.hashCode());
                        return cellCommentInfo;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                i3 = 0;
            }
        }
        s_plug_in_commentVar = lVar.f50362l.plug_in_info;
        if (s_plug_in_commentVar != null) {
            cellCommentInfo.cellCommentPlugin = CellCommentPlugin.create(s_plug_in_commentVar);
        }
        cell_comment cell_commentVar32 = lVar.f50362l;
        cellCommentInfo.unreadCount = cell_commentVar32.unreadCnt;
        cellCommentInfo.actionType = cell_commentVar32.actiontype;
        cellCommentInfo.realCount = cell_commentVar32.iRealCount;
        int i162 = cell_commentVar32.displayflag;
        cellCommentInfo.enableSwitchSort = (i162 & 1) == 0;
        cellCommentInfo.showHeader = (i162 & 2) != 0;
        String str22 = str + "_comment_real_count_" + cellCommentInfo.realCount;
        cellCommentInfo.unikeyCommentRealCount = str22;
        cellCommentInfo.integerUnikeyCommentRealCount = Integer.valueOf(str22.hashCode());
        return cellCommentInfo;
    }

    public void mergeComment(s_commment s_commmentVar) {
        mergeComment(s_commmentVar, "anything");
    }

    public void mergeComment(s_commment s_commmentVar, String str) {
        boolean z16;
        boolean z17;
        if (s_commmentVar == null || TextUtils.isEmpty(s_commmentVar.commentid)) {
            return;
        }
        Comment e16 = com.qzone.proxy.feedcomponent.util.e.e(s_commmentVar, this.feedkey);
        if (this.commments == null) {
            this.commments = new ArrayList<>();
        }
        Iterator<Comment> it = this.commments.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            Comment next = it.next();
            String str2 = next.commentid;
            if (str2 != null && str2.equals(e16.commentid)) {
                if (e16.isDeleted) {
                    this.commments.remove(next);
                } else {
                    List<Reply> list = e16.replies;
                    if (list != null) {
                        if (next.replies == null && list.size() > 0) {
                            next.replies = new ArrayList();
                        }
                        for (Reply reply : e16.replies) {
                            if (reply.isDeleted) {
                                Iterator<Reply> it5 = next.replies.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        Reply next2 = it5.next();
                                        String str3 = reply.replyId;
                                        if (str3 != null && str3.equals(next2.replyId)) {
                                            next.replies.remove(next2);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                int i3 = 0;
                                for (int i16 = 0; i16 < next.replies.size(); i16++) {
                                    if (reply.date <= next.replies.get(i16).date) {
                                        break;
                                    }
                                    i3++;
                                }
                                if (!has(next.replies, reply)) {
                                    User user = reply.targetUser;
                                    if (user == null || user.uin <= 0) {
                                        reply.targetUser = next.user;
                                    }
                                    if (i3 < next.replies.size() - 1) {
                                        next.replies.add(i3, reply);
                                    } else {
                                        next.replies.add(reply);
                                    }
                                    next.replyNum++;
                                }
                                if (next.replies.size() > 30) {
                                    next.replies.remove(0);
                                    next.replyNum--;
                                }
                            }
                        }
                    }
                }
                z16 = true;
            }
        }
        if (!z16 && !e16.isDeleted) {
            if (TextUtils.isEmpty(str)) {
                this.commments.add(0, e16);
            } else {
                int i17 = 0;
                while (true) {
                    if (i17 >= this.commments.size()) {
                        z17 = false;
                        break;
                    } else {
                        if (str.equals(this.commments.get(i17).commentid)) {
                            this.commments.add(i17 + 1, e16);
                            z17 = true;
                            break;
                        }
                        i17++;
                    }
                }
                if (!z17) {
                    this.commments.add(e16);
                }
            }
            List<Reply> list2 = e16.replies;
            if (list2 != null) {
                for (int size = list2.size() - 1; size >= 0; size--) {
                    Reply reply2 = e16.replies.get(size);
                    if (reply2.isDeleted) {
                        e16.replies.remove(reply2);
                    }
                }
            }
        }
        ArrayList<Comment> arrayList = this.commments;
        if (arrayList == null || arrayList.size() <= 30) {
            return;
        }
        this.commments.remove(0);
    }

    private boolean has(List<Reply> list, Reply reply) {
        if (list != null && reply != null) {
            Iterator<Reply> it = list.iterator();
            while (it.hasNext()) {
                String str = it.next().replyId;
                if (str != null && str.equals(reply.replyId)) {
                    return true;
                }
            }
        }
        return false;
    }
}
