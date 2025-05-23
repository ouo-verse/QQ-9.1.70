package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.detail.FeedDetailComment;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.detail.b;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.c;
import com.qzone.widget.MoreCommentPanel;
import com.tencent.luggage.wxa.uf.k;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailCommentAdapter extends b {
    public static final String COMMENT_HEADER_BG_COLOR = "#FFF8F8F8";
    List<Comment> commentsList;
    int drawbackposition;
    Drawable highLightDrawable;
    boolean isEnableShrinkComment;
    boolean isEssenceComment;
    boolean isParticipate;
    boolean isReply;
    boolean isSharingAlbumData;
    boolean isSupportSwitchSortWay;
    LinearLayout layout;
    Context mContext;
    private String mCustomHeaderText;
    TextView mHeaderText;
    TextView mSortSwitchText;
    boolean needBackground;
    boolean needDrawback;
    Drawable normalDrawable;
    g onFeedElementClickListener;
    String replyid;
    boolean showHeader;
    private static String mFriendHeaderText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentFriendComment", "\u597d\u53cb\u8bc4\u8bba");
    private static String mEssenceHeaderText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentEssenceComment", "\u7cbe\u534e\u8bc4\u8bba");
    private static String mCommentText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentAllCommentReply", "\u6761\u8bc4\u8bba\u56de\u590d");
    private static String sortByHot = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentSortByHot", "\u6309\u70ed\u5ea6");
    private static String shareFriendComment = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentShareFriendComment", "\u5171\u4eab\u4eba\u7684\u597d\u53cb\u8bc4\u8bba");
    public boolean isAbleToReply = true;
    public boolean isReplyVisible = true;
    int mShowBackgroudColorIndex = -1;
    public boolean isAbleToLike = true;
    public boolean isLikeVisible = true;
    int mCommentRealNum = 0;
    boolean isUsePicureViewerLayout = false;
    int mAvatarSize = com.qzone.adapter.feedcomponent.b.f41862i;

    public FeedDetailCommentAdapter(Context context, ViewGroup viewGroup, g gVar) {
        this.mContext = context;
        this.onFeedElementClickListener = gVar;
        this.highLightDrawable = context.getResources().getDrawable(j.h(702));
        this.normalDrawable = this.mContext.getResources().getDrawable(j.h(701));
        initConfig();
    }

    private void initConfig() {
        mEssenceHeaderText = i.H().T("QZoneSetting", "ESSENCECOMENT_TEXT", "\u5168\u90e8\u8bc4\u8bba\u56de\u590d");
        mFriendHeaderText = i.H().T("QZoneSetting", "FRIENDCOMENT_TEXT", "\u597d\u53cb\u8bc4\u8bba");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Comment> list = this.commentsList;
        if (list == null || list.size() == 0) {
            return 0;
        }
        if (this.showHeader) {
            return this.commentsList.size() + 1;
        }
        return this.commentsList.size();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.b
    public List<Comment> getData() {
        return this.commentsList;
    }

    View getHeaderEssenceTextView() {
        TextView textView;
        if (this.layout == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(36.0f)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            TextView textView2 = new TextView(this.mContext);
            this.mHeaderText = textView2;
            textView2.setPadding(com.qzone.proxy.feedcomponent.util.g.a(12.0f), 0, 0, 0);
            this.mHeaderText.setTextSize(14.0f);
            this.mHeaderText.setText(mEssenceHeaderText);
            relativeLayout.addView(this.mHeaderText, layoutParams);
            if (this.isSupportSwitchSortWay && this.mSortSwitchText == null) {
                this.mSortSwitchText = new TextView(this.mContext);
                this.mSortSwitchText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, j.g(k.CTRL_INDEX), (Drawable) null);
                this.mSortSwitchText.setCompoundDrawablePadding(ViewUtils.dpToPx(8.0f));
                this.mSortSwitchText.setPadding(0, 0, ViewUtils.dpToPx(12.5f), 0);
                this.mSortSwitchText.setText(sortByHot);
                this.mSortSwitchText.setTextSize(14.0f);
                this.mSortSwitchText.setTextColor(j.F());
                this.mSortSwitchText.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailCommentAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        g gVar = FeedDetailCommentAdapter.this.onFeedElementClickListener;
                        if (gVar != null) {
                            gVar.onClick(view, FeedElement.SORT_SWITCH_ICON, 0, null);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                relativeLayout.addView(this.mSortSwitchText, layoutParams2);
            }
            if (this.isUsePicureViewerLayout) {
                relativeLayout.setBackgroundColor(Color.parseColor(COMMENT_HEADER_BG_COLOR));
            } else {
                relativeLayout.setBackgroundColor(j.E());
            }
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            this.layout = linearLayout;
            linearLayout.setOrientation(1);
            View view = new View(this.mContext);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams3.setMargins(0, 0, 0, ViewUtils.dpToPx(7.0f));
            view.setLayoutParams(layoutParams3);
            this.layout.addView(relativeLayout);
            this.layout.addView(view);
            if (!this.isUsePicureViewerLayout) {
                view.setBackgroundColor(j.H());
                this.mHeaderText.setTextColor(j.F());
                this.layout.setBackgroundColor(j.m());
            } else {
                view.setBackgroundDrawable(j.g(811));
                this.mHeaderText.setTextColor(j.c(31));
            }
        }
        if (!this.isUsePicureViewerLayout && this.mCommentRealNum > 0 && (textView = this.mHeaderText) != null) {
            textView.setText(this.mCommentRealNum + mCommentText);
        }
        if (this.mHeaderText != null && !TextUtils.isEmpty(this.mCustomHeaderText)) {
            this.mHeaderText.setText(this.mCustomHeaderText);
        }
        return this.layout;
    }

    View getHeaderTextView() {
        TextView textView;
        String str;
        if (this.mHeaderText == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(36.0f)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            TextView textView2 = new TextView(this.mContext);
            this.mHeaderText = textView2;
            textView2.setPadding(com.qzone.proxy.feedcomponent.util.g.a(12.0f), 0, 0, 0);
            this.mHeaderText.setTextSize(14.0f);
            relativeLayout.addView(this.mHeaderText, layoutParams);
            if (this.isSharingAlbumData) {
                this.mHeaderText.setText(shareFriendComment);
            } else {
                TextView textView3 = this.mHeaderText;
                if (this.isEssenceComment) {
                    str = mEssenceHeaderText;
                } else {
                    str = mFriendHeaderText;
                }
                textView3.setText(str);
            }
            if (this.isSupportSwitchSortWay && this.mSortSwitchText == null) {
                this.mSortSwitchText = new TextView(this.mContext);
                this.mSortSwitchText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, j.g(k.CTRL_INDEX), (Drawable) null);
                this.mSortSwitchText.setCompoundDrawablePadding(ViewUtils.dpToPx(8.0f));
                this.mSortSwitchText.setPadding(0, 0, ViewUtils.dpToPx(12.5f), 0);
                this.mSortSwitchText.setText(sortByHot);
                this.mSortSwitchText.setTextSize(14.0f);
                this.mSortSwitchText.setTextColor(j.F());
                this.mSortSwitchText.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailCommentAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        g gVar = FeedDetailCommentAdapter.this.onFeedElementClickListener;
                        if (gVar != null) {
                            gVar.onClick(view, FeedElement.SORT_SWITCH_ICON, 0, null);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                relativeLayout.addView(this.mSortSwitchText, layoutParams2);
            }
            if (this.isUsePicureViewerLayout) {
                relativeLayout.setBackgroundColor(Color.parseColor(COMMENT_HEADER_BG_COLOR));
            } else {
                relativeLayout.setBackgroundColor(j.E());
            }
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            this.layout = linearLayout;
            linearLayout.setOrientation(1);
            View view = new View(this.mContext);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams3.setMargins(0, 0, 0, ViewUtils.dpToPx(7.0f));
            view.setLayoutParams(layoutParams3);
            if (!this.isUsePicureViewerLayout) {
                view.setBackgroundColor(j.H());
            }
            this.layout.addView(relativeLayout);
            this.layout.addView(view);
            if (!this.isUsePicureViewerLayout) {
                this.mHeaderText.setTextColor(j.F());
                this.layout.setBackgroundColor(j.m());
            } else {
                this.mHeaderText.setTextColor(j.c(31));
            }
        }
        if (!this.isUsePicureViewerLayout && this.mCommentRealNum > 0 && (textView = this.mHeaderText) != null) {
            textView.setText(this.mCommentRealNum + mCommentText);
        }
        if (this.mHeaderText != null && !TextUtils.isEmpty(this.mCustomHeaderText)) {
            this.mHeaderText.setText(this.mCustomHeaderText);
        }
        return this.layout;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<Comment> list = this.commentsList;
        if (list != null && i3 >= 0 && list.size() > i3) {
            return this.commentsList.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    public int getShowBackgroudColorIndex() {
        return this.mShowBackgroudColorIndex;
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
        if (this.commentsList == null) {
            this.commentsList = new ArrayList();
        }
        this.commentsList.clear();
        if (list != null) {
            this.commentsList.addAll(list);
        }
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
        User user;
        View view2;
        int i16;
        View view3;
        Map<String, String> map;
        boolean z16 = this.showHeader;
        if (z16 && i3 == 0) {
            if (this.isEssenceComment) {
                view3 = getHeaderEssenceTextView();
            } else {
                view3 = getHeaderTextView();
            }
            i16 = i3;
        } else {
            final int i17 = z16 ? i3 - 1 : i3;
            Comment comment = (Comment) getItem(i17);
            if (comment != null && (map = comment.extendInfo) != null && map.get("weishi_comment_guide") != null) {
                MoreCommentPanel moreCommentPanel = new MoreCommentPanel(this.mContext, true);
                moreCommentPanel.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailCommentAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        EventCollector.getInstance().onViewClickedBefore(view4);
                        g gVar = FeedDetailCommentAdapter.this.onFeedElementClickListener;
                        if (gVar != null) {
                            gVar.onClick(view4, FeedElement.COMMENT_SHOW_MORE, i17, null);
                        }
                        EventCollector.getInstance().onViewClicked(view4);
                    }
                });
                moreCommentPanel.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                moreCommentPanel.setHintText(comment.comment);
                view2 = moreCommentPanel;
            } else {
                if (view != null && (view.getTag() instanceof FeedDetailComment)) {
                    feedDetailComment = (FeedDetailComment) view.getTag();
                } else {
                    FeedDetailComment feedDetailComment2 = new FeedDetailComment(this.mContext, i17, this.mAvatarSize, this.onFeedElementClickListener, this.isUsePicureViewerLayout);
                    feedDetailComment2.getView().setTag(feedDetailComment2);
                    feedDetailComment = feedDetailComment2;
                }
                if (comment == null) {
                    view2 = feedDetailComment.getView();
                } else {
                    feedDetailComment.setPosition(i17);
                    feedDetailComment.setUser(comment.user);
                    feedDetailComment.setCommentData(comment);
                    String str2 = comment.refer;
                    if (str2 != null && str2.length() > 0) {
                        str = " " + comment.refer;
                    } else {
                        str = "";
                    }
                    feedDetailComment.setReplyEnable(this.isAbleToReply && !comment.isFake);
                    feedDetailComment.setReplyVisible((!this.isReplyVisible || comment.isFake || (user = comment.user) == null || user.uin == i.H().j0()) ? false : true);
                    feedDetailComment.setPraiseEnable(this.isAbleToLike && !comment.isFake);
                    feedDetailComment.setPraiseVisible(this.isLikeVisible && !comment.isFake);
                    feedDetailComment.setPublishTimeDesc(c.d(comment.time) + str);
                    ArrayList<PictureItem> arrayList = comment.commentPictureItems;
                    if (arrayList != null && arrayList.size() > 0) {
                        feedDetailComment.setPicture(comment.commentPictureItems, true);
                    } else {
                        feedDetailComment.setPicture(comment.pictureItems, false);
                    }
                    if (this.needDrawback && i17 == this.drawbackposition && !this.isReply) {
                        feedDetailComment.setContent(comment, true);
                    } else {
                        feedDetailComment.setContent(comment, false);
                    }
                    boolean z17 = this.needDrawback;
                    if (z17 && i17 == this.drawbackposition && this.isReply) {
                        feedDetailComment.setReply(comment.replies, this.replyid, z17, this.isEnableShrinkComment && comment.isNeedShrink, comment.displayReplyNum);
                    } else {
                        feedDetailComment.setReply(comment.replies, this.replyid, false, this.isEnableShrinkComment && comment.isNeedShrink, comment.displayReplyNum);
                    }
                    feedDetailComment.setLongClickEnable(true);
                    feedDetailComment.setContentViewEnabled(this.isReplyVisible);
                    List<Comment> list = this.commentsList;
                    if (list != null && i17 < list.size() - 1) {
                        feedDetailComment.setCommentItemSeparator(true, true);
                    } else {
                        feedDetailComment.setCommentItemSeparator(false, true);
                    }
                    if (this.isParticipate) {
                        if (this.mShowBackgroudColorIndex == i17) {
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
                        View view4 = feedDetailComment.mViewHolder.userInfoView;
                        if (view4 != null) {
                            view4.setContentDescription(sb5.toString());
                        }
                    }
                    ArrayList<CellLikeInfo.LikeMan> arrayList2 = comment.likeMen;
                    if (((arrayList2 != null && arrayList2.size() > 0) || comment.isliked) && !comment.isFake) {
                        feedDetailComment.setPraiserVisible(true);
                        feedDetailComment.setPraiser(comment.likeMen, comment.isliked);
                    } else {
                        feedDetailComment.setPraiserVisible(false);
                    }
                    View view5 = feedDetailComment.getView();
                    view2 = view5;
                    if (this.needBackground) {
                        view5.setBackgroundColor(j.m());
                        view2 = view5;
                    }
                }
            }
            i16 = i17;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i16, view, viewGroup, getItemId(i16));
        return view3;
    }

    public void appendData(List<Comment> list) {
        if (list == null) {
            return;
        }
        if (this.commentsList == null) {
            this.commentsList = new ArrayList();
        }
        this.commentsList.addAll(list);
    }
}
