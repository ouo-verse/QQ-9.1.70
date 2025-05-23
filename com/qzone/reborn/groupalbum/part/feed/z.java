package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerCommentEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u001c\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 H\u0016\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/z;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerCommentEvent;", "event", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "I9", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "lloc", "E9", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "videoPictureItem", "C9", "G9", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "F9", "H9", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "D9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class z extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {
    private final PictureItem C9(PictureItem videoPictureItem) {
        PictureItem pictureItem = new PictureItem();
        PictureUrl pictureUrl = videoPictureItem.videodata.coverUrl;
        pictureItem.bigUrl = pictureUrl;
        pictureItem.currentUrl = pictureUrl;
        pictureItem.lloc = videoPictureItem.lloc;
        pictureItem.opmask = videoPictureItem.opmask;
        pictureItem.piccategory = videoPictureItem.piccategory;
        return pictureItem;
    }

    private final void E9(BusinessFeedData feedData, Comment comment, String lloc) {
        CellCommentInfo commentInfo = feedData.getCommentInfo();
        CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
        if ((cellPictureInfo != null ? cellPictureInfo.pics : null) != null && cellPictureInfo.pics.size() > 1) {
            ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
            Intrinsics.checkNotNullExpressionValue(arrayList, "cellPicInfo.pics");
            for (PictureItem it : arrayList) {
                if (Intrinsics.areEqual(it.lloc, lloc)) {
                    ArrayList<PictureItem> arrayList2 = new ArrayList<>();
                    comment.pictureItems = arrayList2;
                    if (it.videoflag == 0) {
                        arrayList2.add(it);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        arrayList2.add(C9(it));
                    }
                }
            }
        }
        ArrayList<Comment> arrayList3 = commentInfo.commments;
        if (arrayList3 != null) {
            arrayList3.add(comment);
        }
        commentInfo.commentNum++;
        commentInfo.serverRspTotalCommentNum++;
        J9(feedData);
    }

    private final void F9(BusinessFeedData feedData, Comment comment, Reply reply) {
        ArrayList<Comment> arrayList;
        Object obj;
        CellCommentInfo commentInfo = feedData.getCommentInfo();
        if (commentInfo == null || (arrayList = commentInfo.commments) == null) {
            return;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(comment.commentid, ((Comment) obj).commentid)) {
                    break;
                }
            }
        }
        Comment comment2 = (Comment) obj;
        if (comment2 == null) {
            return;
        }
        List<Reply> list = comment2.replies;
        if (list != null) {
            list.add(reply);
        }
        comment2.replyNum++;
        J9(feedData);
    }

    private final void G9(BusinessFeedData feedData, Comment comment) {
        CellCommentInfo commentInfo = feedData.getCommentInfo();
        ArrayList<Comment> arrayList = new ArrayList<>();
        ArrayList<Comment> arrayList2 = commentInfo.commments;
        if (arrayList2 != null) {
            for (Comment comment2 : arrayList2) {
                if (!Intrinsics.areEqual(comment.commentid, comment2.commentid)) {
                    arrayList.add(comment2);
                }
            }
        }
        commentInfo.commments = arrayList;
        commentInfo.commentNum--;
        commentInfo.serverRspTotalCommentNum--;
        J9(feedData);
    }

    private final void H9(BusinessFeedData feedData, Comment comment, Reply reply) {
        Object obj;
        ArrayList<Comment> arrayList = feedData.getCommentInfo().commments;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((Comment) obj).commentid, comment.commentid)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Comment comment2 = (Comment) obj;
            if (comment2 == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            List<Reply> list = comment2.replies;
            if (list != null) {
                for (Reply reply2 : list) {
                    if (!Intrinsics.areEqual(reply.replyId, reply2.replyId)) {
                        arrayList2.add(reply2);
                    }
                }
            }
            comment2.replies = arrayList2;
            comment2.replyNum--;
            J9(feedData);
        }
    }

    private final void I9(GroupAlbumLayerCommentEvent event, BusinessFeedData feedData) {
        int action = event.getAction();
        if (action == 1) {
            Comment comment = event.getComment();
            Intrinsics.checkNotNull(comment);
            E9(feedData, comment, event.getLloc());
            return;
        }
        if (action == 2) {
            Comment comment2 = event.getComment();
            Intrinsics.checkNotNull(comment2);
            G9(feedData, comment2);
        } else {
            if (action == 3) {
                Comment comment3 = event.getComment();
                Intrinsics.checkNotNull(comment3);
                Reply reply = event.getReply();
                Intrinsics.checkNotNull(reply);
                F9(feedData, comment3, reply);
                return;
            }
            if (action != 4) {
                return;
            }
            Comment comment4 = event.getComment();
            Intrinsics.checkNotNull(comment4);
            Reply reply2 = event.getReply();
            Intrinsics.checkNotNull(reply2);
            H9(feedData, comment4, reply2);
        }
    }

    private final void J9(BusinessFeedData feedData) {
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(feedData), feedData.getCommentInfoV2()), true);
    }

    public abstract BusinessFeedData D9(GroupAlbumLayerCommentEvent event);

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        GroupAlbumLayerCommentEvent groupAlbumLayerCommentEvent;
        BusinessFeedData D9;
        if (!(event instanceof GroupAlbumLayerCommentEvent) || (D9 = D9((groupAlbumLayerCommentEvent = (GroupAlbumLayerCommentEvent) event))) == null) {
            return;
        }
        I9(groupAlbumLayerCommentEvent, D9);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumLayerCommentEvent.class);
        return arrayListOf;
    }
}
