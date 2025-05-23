package ff;

import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import ef.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ4\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0003J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0015J \u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a8\u0006\u001f"}, d2 = {"Lff/a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "commentPics", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "c", "comment", "groupUin", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "", "g", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "clickedComment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "e", "reply", "b", h.F, "LNS_MOBILE_OPERATION/MediaInfo;", "mediaInfo", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f398543a = new a();

    a() {
    }

    private final ArrayList<PictureItem> d(ArrayList<String> commentPics) {
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        if (commentPics != null) {
            for (String str : commentPics) {
                if (!TextUtils.isEmpty(str)) {
                    BitmapFactory.Options D = f.D(str);
                    PictureItem pictureItem = new PictureItem();
                    pictureItem.piccategory = 2;
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem.currentUrl = pictureUrl;
                    pictureUrl.url = str;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str);
                    PictureUrl pictureUrl2 = pictureItem.currentUrl;
                    pictureUrl2.width = D.outWidth;
                    pictureUrl2.height = D.outHeight;
                    pictureItem.bigUrl = pictureUrl2;
                    pictureItem.originUrl = pictureUrl2;
                    pictureItem.downloadUrl = pictureUrl2;
                    pictureItem.localFileUrl = str;
                    f.E(pictureItem);
                    arrayList.add(pictureItem);
                }
            }
        }
        return arrayList;
    }

    public final Comment a(Comment comment, String groupUin) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        comment.user = oj.a.f423008a.b(groupUin);
        comment.isTempData = true;
        return comment;
    }

    public final Reply b(Reply reply, String groupUin) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        reply.user = oj.a.f423008a.b(groupUin);
        return reply;
    }

    public final Comment c(QZoneCommentPanelResultBean commentResultBean) {
        Intrinsics.checkNotNullParameter(commentResultBean, "commentResultBean");
        Comment comment = new Comment();
        comment.commentid = "fakeId_" + System.currentTimeMillis();
        comment.clientKey = "fakeClientKey_" + System.currentTimeMillis();
        comment.comment = commentResultBean.getInputContent();
        comment.time = (int) (System.currentTimeMillis() / ((long) 1000));
        ArrayList<String> g16 = commentResultBean.g();
        if (!(g16 == null || g16.isEmpty())) {
            comment.commentPictureItems = d(commentResultBean.g());
        }
        comment.isFake = true;
        comment.isTempData = true;
        comment.user = oj.a.f423008a.e();
        return comment;
    }

    public final Reply e(QZoneCommentPanelResultBean commentResultBean, ClickedComment clickedComment) {
        Intrinsics.checkNotNullParameter(commentResultBean, "commentResultBean");
        Reply reply = new Reply();
        reply.replyId = "fakeId_" + System.currentTimeMillis();
        reply.clientKey = "fakeClientKey_" + System.currentTimeMillis();
        reply.content = commentResultBean.getInputContent();
        reply.date = (int) (System.currentTimeMillis() / ((long) 1000));
        reply.isFake = true;
        reply.isTempData = true;
        if (clickedComment != null && clickedComment.getReply() != null) {
            reply.targetUser = clickedComment.getReply().user;
        } else if (clickedComment != null && clickedComment.getComment() != null) {
            reply.targetUser = clickedComment.getComment().user;
        }
        reply.user = oj.a.f423008a.e();
        return reply;
    }

    public final ArrayList<PictureItem> f(MediaInfo mediaInfo) {
        ArrayList<PicInfo> arrayList;
        ArrayList<PictureItem> arrayList2 = new ArrayList<>();
        if (mediaInfo != null && (arrayList = mediaInfo.picinfolist) != null) {
            for (PicInfo picInfo : arrayList) {
                if (picInfo != null) {
                    PictureItem pictureItem = new PictureItem();
                    pictureItem.piccategory = 2;
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem.currentUrl = pictureUrl;
                    String str = picInfo.pic_url;
                    pictureUrl.url = str;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str);
                    PictureUrl pictureUrl2 = pictureItem.currentUrl;
                    pictureUrl2.width = picInfo.picwidth;
                    pictureUrl2.height = picInfo.picheight;
                    pictureItem.bigUrl = pictureUrl2;
                    pictureItem.originUrl = pictureUrl2;
                    pictureItem.downloadUrl = pictureUrl2;
                    arrayList2.add(pictureItem);
                }
            }
        }
        return arrayList2;
    }

    public final void g(BusinessFeedData businessFeedData, Comment comment) {
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        CellCommentInfo commentInfo = businessFeedData.getCommentInfo();
        ArrayList<Comment> arrayList = commentInfo.commments;
        if (arrayList != null) {
            arrayList.add(comment);
        }
        commentInfo.commentNum++;
        commentInfo.serverRspTotalCommentNum++;
        RFWLog.i("QZoneFakeCommentManager", RFWLog.USR, "insertFakeCommentToList: " + b.a(businessFeedData));
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(b.a(businessFeedData), commentInfo), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(BusinessFeedData businessFeedData, ClickedComment clickedComment, Reply reply) {
        List<Reply> list;
        ArrayList<Comment> arrayList;
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        Intrinsics.checkNotNullParameter(reply, "reply");
        if (clickedComment == null || clickedComment.getComment() == null) {
            return;
        }
        CellCommentInfo commentInfo = businessFeedData.getCommentInfo();
        Comment comment = null;
        if (commentInfo != null && (arrayList = commentInfo.commments) != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(clickedComment.getComment().commentid, ((Comment) next).commentid)) {
                    comment = next;
                    break;
                }
            }
            comment = comment;
        }
        if (comment != null && (list = comment.replies) != null) {
            list.add(reply);
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(b.a(businessFeedData), commentInfo), true);
    }
}
