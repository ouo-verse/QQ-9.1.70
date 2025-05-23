package com.qzone.feed.business.protocol;

import NS_MOBILE_FEEDS.SimpleComment;
import NS_MOBILE_FEEDS.mobile_single_feeds_req;
import NS_MOBILE_FEEDS.single_feeds_req_info;
import android.text.TextUtils;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneQueryFeedUpdateRequest extends QZoneRequest {
    private static final String CMD_STRING = "getUpdateFeeds";
    public String commentListDesc;

    public QzoneQueryFeedUpdateRequest(List<BusinessFeedData> list, int i3) {
        this(list, i3, false);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneQueryFeedUpdateRequest(List<BusinessFeedData> list, int i3, boolean z16) {
        super(CMD_STRING);
        this.commentListDesc = WiFiDash.NOT_AVALIBLE;
        mobile_single_feeds_req mobile_single_feeds_reqVar = new mobile_single_feeds_req();
        mobile_single_feeds_reqVar.get_type = i3;
        mobile_single_feeds_reqVar.req_feeds_info = new ArrayList<>();
        if (list != null) {
            for (BusinessFeedData businessFeedData : list) {
                single_feeds_req_info single_feeds_req_infoVar = new single_feeds_req_info();
                single_feeds_req_infoVar.uin = businessFeedData.getUser().uin;
                single_feeds_req_infoVar.appId = businessFeedData.getFeedCommInfo().appid;
                single_feeds_req_infoVar.feeds_time = businessFeedData.getFeedCommInfo().time / 1000;
                single_feeds_req_infoVar.ugc_key = businessFeedData.getFeedCommInfo().ugckey;
                if (!z16) {
                    ArrayList<SimpleComment> convertSimpleCommentList = convertSimpleCommentList(businessFeedData.getCommentInfoV2());
                    single_feeds_req_infoVar.all_commont_list = convertSimpleCommentList;
                    this.commentListDesc = getCommentListInfo(convertSimpleCommentList);
                    b.e("FeedUpdate", "getUpdateFeeds ugcKey:" + businessFeedData.getFeedCommInfo().ugckey + " comments:" + this.commentListDesc);
                }
                single_feeds_req_infoVar.pullAll = z16;
                mobile_single_feeds_reqVar.req_feeds_info.add(single_feeds_req_infoVar);
            }
        }
        this.req = mobile_single_feeds_reqVar;
    }

    private ArrayList<SimpleComment> convertSimpleCommentList(CellCommentInfo cellCommentInfo) {
        if (cellCommentInfo == null || cellCommentInfo.commments == null) {
            return null;
        }
        ArrayList<SimpleComment> arrayList = new ArrayList<>();
        try {
            Iterator<Comment> it = cellCommentInfo.commments.iterator();
            while (it.hasNext()) {
                Comment next = it.next();
                if (next != null && !TextUtils.isEmpty(next.commentid)) {
                    SimpleComment simpleComment = new SimpleComment();
                    simpleComment.f24981id = Integer.valueOf(next.commentid).intValue();
                    if (next.replies != null) {
                        simpleComment.reply_ids = new ArrayList<>();
                        Iterator<Reply> it5 = next.replies.iterator();
                        while (it5.hasNext()) {
                            simpleComment.reply_ids.add(Long.valueOf(it5.next().replyId));
                        }
                    }
                    arrayList.add(simpleComment);
                }
            }
        } catch (Exception e16) {
            QZLog.e("QzoneQueryFeedUpdateRequest", "", e16);
        }
        return arrayList;
    }

    public String getCommentListInfo(List<SimpleComment> list) {
        if (list == null) {
            return WiFiDash.NOT_AVALIBLE;
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("total_num:");
        stringBuffer.append(list.size());
        for (SimpleComment simpleComment : list) {
            stringBuffer.append("[");
            stringBuffer.append(simpleComment.f24981id);
            ArrayList<Long> arrayList = simpleComment.reply_ids;
            if (arrayList != null && arrayList.size() > 0) {
                stringBuffer.append("(");
                Iterator<Long> it = simpleComment.reply_ids.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                    stringBuffer.append(",");
                }
                stringBuffer.append(")");
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}
