package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.detail.FeedDetailComment;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.detail.b;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedCommentDetailAdapter extends b {
    private List<Comment> commentsList;
    private int drawbackposition;
    private Drawable highLightDrawable;
    private boolean isEnableShrinkComment;
    private boolean isEssenceComment;
    private boolean isParticipate;
    private boolean isReply;
    private boolean isSharingAlbumData;
    private boolean isSupportSwitchSortWay;
    private LinearLayout layout;
    private Context mContext;
    private String mCustomHeaderText;
    private TextView mHeaderText;
    private TextView mSortSwitchText;
    private boolean needBackground;
    private boolean needDrawback;
    private Drawable normalDrawable;
    private g onFeedElementClickListener;
    private String replyid;
    private boolean showHeader;
    public boolean isAbleToReply = true;
    public boolean isReplyVisible = true;
    private int mShowBackgroudColorIndex = -1;
    public boolean isAbleToLike = true;
    public boolean isLikeVisible = true;
    private int mCommentRealNum = 0;
    boolean isUsePicureViewerLayout = false;
    private int mAvatarSize = com.qzone.adapter.feedcomponent.b.f41862i;

    public FeedCommentDetailAdapter(Context context, ViewGroup viewGroup, g gVar) {
        this.mContext = context;
        this.onFeedElementClickListener = gVar;
        this.highLightDrawable = context.getResources().getDrawable(j.h(702));
        this.normalDrawable = this.mContext.getResources().getDrawable(j.h(701));
    }

    private View obtainCommentView(View view, int i3) {
        FeedDetailComment feedDetailComment;
        String str;
        User user;
        Comment comment = (Comment) getItem(i3);
        if (view != null && (view.getTag() instanceof FeedDetailComment)) {
            feedDetailComment = (FeedDetailComment) view.getTag();
        } else {
            feedDetailComment = new FeedDetailComment(this.mContext, i3, this.mAvatarSize, this.onFeedElementClickListener, this.isUsePicureViewerLayout);
            feedDetailComment.getView().setTag(feedDetailComment);
        }
        if (comment == null) {
            return feedDetailComment.getView();
        }
        feedDetailComment.setPosition(i3);
        feedDetailComment.setUser(comment.user);
        feedDetailComment.setCommentData(comment);
        String str2 = comment.refer;
        if (str2 != null && str2.length() > 0) {
            str = " " + comment.refer;
        } else {
            str = "";
        }
        feedDetailComment.setPublishTimeDesc(c.d(comment.time) + str);
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (arrayList != null && arrayList.size() > 0) {
            feedDetailComment.setPicture(comment.commentPictureItems, true);
        } else {
            feedDetailComment.setPicture(comment.pictureItems, false);
        }
        if (this.needDrawback && i3 == this.drawbackposition && !this.isReply) {
            feedDetailComment.setContent(comment, true);
        } else {
            feedDetailComment.setContent(comment, false);
        }
        feedDetailComment.setReplyEnable(this.isAbleToReply && !comment.isFake);
        feedDetailComment.setReplyVisible((!this.isReplyVisible || comment.isFake || (user = comment.user) == null || user.uin == i.H().j0()) ? false : true);
        feedDetailComment.setPraiseEnable(this.isAbleToLike && !comment.isFake);
        feedDetailComment.setPraiseVisible(this.isLikeVisible && !comment.isFake);
        feedDetailComment.setLongClickEnable(true);
        feedDetailComment.setContentViewEnabled(this.isReplyVisible);
        feedDetailComment.setCommentDetailHeaderSeparator(false);
        feedDetailComment.setCommentItemSeparator(false, false);
        if (this.isParticipate) {
            if (this.mShowBackgroudColorIndex == i3) {
                if (this.highLightDrawable != null) {
                    feedDetailComment.getView().setBackground(this.highLightDrawable);
                }
            } else if (this.normalDrawable != null) {
                feedDetailComment.getView().setBackground(this.normalDrawable);
            }
        }
        User user2 = comment.user;
        if (user2 != null && !TextUtils.isEmpty(user2.nickName)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(comment.user.nickName + ", ");
            String str3 = c.d(comment.time) + str;
            if (!TextUtils.isEmpty(str3)) {
                sb5.append(str3 + ", ");
            }
            sb5.append("\u70b9\u51fb\u8fdb\u5165\u4ed6\u7684\u7a7a\u95f4");
            if (feedDetailComment.mViewHolder == null) {
                FeedDetailComment.ViewHolder viewHolder = new FeedDetailComment.ViewHolder();
                feedDetailComment.mViewHolder = viewHolder;
                viewHolder.userInfoView = feedDetailComment.getView().findViewById(j.O(j.O(2257)));
            }
            View view2 = feedDetailComment.mViewHolder.userInfoView;
            if (view2 != null) {
                view2.setContentDescription(sb5.toString());
            }
        }
        ArrayList<CellLikeInfo.LikeMan> arrayList2 = comment.likeMen;
        if (((arrayList2 != null && arrayList2.size() > 0) || comment.isliked) && !comment.isFake) {
            feedDetailComment.setPraiserVisible(true);
            feedDetailComment.setPraiser(comment.likeMen, comment.isliked);
        } else {
            feedDetailComment.setPraiserVisible(false);
        }
        feedDetailComment.setPraiserVisible(false);
        View view3 = feedDetailComment.getView();
        if (this.needBackground) {
            view3.setBackgroundColor(j.m());
        }
        return view3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Comment> list = this.commentsList;
        int i3 = 0;
        if (list != null && list.size() != 0 && this.commentsList.get(0) != null) {
            List<Reply> list2 = this.commentsList.get(0).replies;
            i3 = 1;
            if (list2 != null && list2.size() != 0) {
                return list2.size() + 1;
            }
        }
        return i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public List<Comment> getData() {
        return this.commentsList;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<Reply> list;
        List<Comment> list2 = this.commentsList;
        if (list2 == null || list2.size() == 0 || i3 < 0) {
            return null;
        }
        if (i3 == 0) {
            return this.commentsList.get(0);
        }
        Comment comment = this.commentsList.get(0);
        if (comment != null && (list = comment.replies) != null && i3 < list.size() + 1) {
            return list.get(i3 - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setCommentLikeAble(boolean z16) {
        this.isAbleToLike = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setCommentLikeVisible(boolean z16) {
        this.isLikeVisible = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setCommentRealNum(int i3) {
        this.mCommentRealNum = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setData(List<Comment> list) {
        this.commentsList = list;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setEnableShrinkComment(boolean z16) {
        this.isEnableShrinkComment = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setHeaderText(String str) {
        this.mCustomHeaderText = str;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsAbleToReply(boolean z16) {
        this.isAbleToReply = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsEssenceComment(boolean z16) {
        this.isEssenceComment = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsReplyVisible(boolean z16) {
        this.isReplyVisible = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsSharingAlbumData(boolean z16) {
        this.isSharingAlbumData = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsSupportSortComment(boolean z16) {
        this.isSupportSwitchSortWay = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setIsUsePicureViewerLayout(boolean z16) {
        this.isUsePicureViewerLayout = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setNeedBackground(boolean z16) {
        this.needBackground = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setParticipate(boolean z16) {
        this.isParticipate = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setShowBackgroudColorIndex(int i3) {
        this.mShowBackgroudColorIndex = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setShowHeader(boolean z16) {
        this.showHeader = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public void setback(int i3, boolean z16, String str, boolean z17) {
        this.needDrawback = z16;
        this.isReply = z17;
        this.drawbackposition = i3;
        this.replyid = str;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        FeedDetailComment feedDetailComment;
        String str;
        View view2;
        User user;
        if (i3 == 0) {
            view2 = obtainCommentView(view, i3);
        } else {
            Reply reply = (Reply) getItem(i3);
            if (view != null && (view.getTag() instanceof FeedDetailComment)) {
                feedDetailComment = (FeedDetailComment) view.getTag();
            } else {
                feedDetailComment = new FeedDetailComment(this.mContext, i3, this.mAvatarSize, this.onFeedElementClickListener, this.isUsePicureViewerLayout);
                feedDetailComment.getView().setTag(feedDetailComment);
            }
            if (reply == null) {
                view2 = feedDetailComment.getView();
            } else {
                feedDetailComment.setPosition(i3);
                feedDetailComment.setUser(reply.user);
                Comment comment = this.commentsList.get(0);
                if (comment == null) {
                    view2 = null;
                } else {
                    feedDetailComment.setCommentData(comment);
                    String str2 = reply.refer;
                    if (str2 != null && str2.length() > 0) {
                        str = " " + reply.refer;
                    } else {
                        str = "";
                    }
                    feedDetailComment.setPublishTimeDesc(c.d(reply.date) + str);
                    feedDetailComment.setReplyContent(reply, false);
                    feedDetailComment.setReplyEnable(this.isAbleToReply && !reply.isFake);
                    feedDetailComment.setReplyVisible((!FeedDetailComment.checkUseNewReplyStyle() || (user = reply.user) == null || user.uin == i.H().j0()) ? false : true);
                    feedDetailComment.setPraiseEnable(!reply.isFake);
                    feedDetailComment.setPraiseVisible(FeedDetailComment.checkUseNewReplyStyle());
                    feedDetailComment.setLongClickEnable(true);
                    feedDetailComment.setContentViewEnabled(this.isReplyVisible);
                    feedDetailComment.setCommentType(2);
                    List<Reply> list = comment.replies;
                    if (list != null && i3 < list.size()) {
                        feedDetailComment.setCommentItemSeparator(false, false);
                    } else {
                        feedDetailComment.setCommentItemSeparator(false, false);
                    }
                    feedDetailComment.setCommentDetailHeaderSeparator(false);
                    User user2 = reply.user;
                    if (user2 != null && !TextUtils.isEmpty(user2.nickName)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(reply.user.nickName + ", ");
                        String str3 = c.d(reply.date) + str;
                        if (!TextUtils.isEmpty(str3)) {
                            sb5.append(str3 + ", ");
                        }
                        sb5.append("\u70b9\u51fb\u8fdb\u5165\u4ed6\u7684\u7a7a\u95f4");
                        if (feedDetailComment.mViewHolder == null) {
                            FeedDetailComment.ViewHolder viewHolder = new FeedDetailComment.ViewHolder();
                            feedDetailComment.mViewHolder = viewHolder;
                            viewHolder.userInfoView = feedDetailComment.getView().findViewById(j.O(j.O(2257)));
                        }
                        View view3 = feedDetailComment.mViewHolder.userInfoView;
                        if (view3 != null) {
                            view3.setContentDescription(sb5.toString());
                        }
                    }
                    feedDetailComment.setPraiserVisible(false);
                    view2 = feedDetailComment.getView();
                    if (this.needBackground) {
                        view2.setBackgroundColor(j.m());
                    }
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }
}
