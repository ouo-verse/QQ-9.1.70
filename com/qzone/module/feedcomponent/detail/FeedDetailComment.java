package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.b;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.module.feedcomponent.util.MaxCommentLineConfig;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.module.feedcomponent.view.ExtendGridView;
import com.qzone.module.feedcomponent.view.FeedGifView;
import com.qzone.module.feedcomponent.view.FeedImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.proxy.feedcomponent.ui.detail.c;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.l;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailComment extends c {
    public static final int BEFORE_DELETE_COMMENT = 153;
    public static final int BEFORE_REPLY = 152;
    public static final int COMMENT_CLICK = 408;
    public static final int COMMENT_LONG_CLICK = 406;
    public static final int COMMENT_TYPE = 1;
    public static final int DELETE_ENABLE = 1;
    public static final int PIC_LONG_CLICK = 512;
    protected static String REPLAY_STR = " \u56de\u590d ";
    public static final int REPLY_CLICK = 409;
    public static final int REPLY_LONG_CLICK = 407;
    public static final int REPLY_POS = 10000;
    public static final int REPLY_TYPE = 2;
    Comment comment;
    CellTextView commentAuthor;
    CellTextView commentContent;
    AvatarImageView commentImgUserIcon;
    private View commentItemSeparator;
    CellTextView commentMoreReply;
    AdapterView.OnItemClickListener commentPictureGridViewClickListener;
    AdapterView.OnItemLongClickListener commentPictureGridViewLongClickListener;
    TextView commentPraiser;
    TextView commentPublishDesciption;
    TextView commentReplyButton;
    LinearLayout commentReplyContainer;
    User commentUser;
    boolean contentClickEnable;
    Drawable defaultLikeDrawable;
    boolean isReplyVisible;
    boolean isUsePictureViewerLayout;
    long lastLikeClickTime;
    TextView likeTextView;
    int linkColor;
    boolean longClickEnable;
    int mAvatarSize;
    CommentImageAdapter mCommentImageAdapter;
    ExtendGridView mCommentPictureGridView;
    private int mCommentType;
    Context mContext;
    boolean mIsCommentImage;
    TextCellLayout.OnCellClickListener mOnCellClickListener;
    int mPicSize;
    int mReplyAvatarSize;
    ViewHolder mViewHolder;
    TextView newCommentReplyButton;
    int nickNameColor;
    View.OnClickListener onButtonClick;
    g onFeedElementClickListener;
    View.OnLongClickListener onLongClick;
    int position;
    LinearLayout publishTimeAndMoreReplyContainer;
    View publishTimeAndMoreReplySeparatorDot;
    View publishTimeReplyButtonContainer;
    private Set<FeedDetailReply> replies;
    private View replyDetailHeaderSeparator;
    SuperLikeView superLikeView;
    private static String likeText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentLike", "\u89c9\u5f97\u5f88\u8d5e");
    private static String soOnText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentLikeSoOn", "\u7b49");
    private static String manyLikeText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentManyLike", "\u4e2a\u4eba\u89c9\u5f97\u5f88\u8d5e");

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.detail.FeedDetailComment$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event;

        static {
            int[] iArr = new int[SuperLikeAnimator$Event.values().length];
            $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event = iArr;
            try {
                iArr[SuperLikeAnimator$Event.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class CommentImageAdapter extends BaseAdapter {
        ArrayList<PictureItem> imageInfos;

        CommentImageAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<PictureItem> arrayList = this.imageInfos;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public ArrayList<PictureItem> getImageInfoList() {
            return this.imageInfos;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void setImageInfos(ArrayList<PictureItem> arrayList) {
            if (this.imageInfos == null) {
                this.imageInfos = new ArrayList<>();
            }
            this.imageInfos.clear();
            if (arrayList != null) {
                Iterator<PictureItem> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.imageInfos.add(it.next());
                }
            }
            updateGridViewWidth();
            notifyDataSetChanged();
        }

        void updateGridViewWidth() {
            if (getCount() <= 0) {
                FeedDetailComment.this.mCommentPictureGridView.setVisibility(8);
            } else {
                FeedDetailComment.this.mCommentPictureGridView.setVisibility(0);
            }
            FeedDetailComment.this.mPicSize = b.b();
            FeedDetailComment feedDetailComment = FeedDetailComment.this;
            int i3 = feedDetailComment.mPicSize;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) feedDetailComment.mCommentPictureGridView.getLayoutParams();
            marginLayoutParams.width = (i3 * getCount()) + ((com.qzone.proxy.feedcomponent.util.g.a(10.0f) * getCount()) / 3);
            FeedDetailComment feedDetailComment2 = FeedDetailComment.this;
            marginLayoutParams.height = feedDetailComment2.mPicSize;
            feedDetailComment2.mCommentPictureGridView.setLayoutParams(marginLayoutParams);
            FeedDetailComment.this.mCommentPictureGridView.setNumColumns(getCount());
        }

        @Override // android.widget.Adapter
        public PictureItem getItem(int i3) {
            ArrayList<PictureItem> arrayList = this.imageInfos;
            if (arrayList == null || arrayList.size() <= i3) {
                return null;
            }
            return this.imageInfos.get(i3);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            FeedImageView.ImageType imageType;
            FeedGifView feedGifView = (FeedGifView) view;
            if (feedGifView == null) {
                feedGifView = new FeedGifView(FeedDetailComment.this.mContext);
            }
            PictureItem item = getItem(i3);
            if (item != null) {
                feedGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (item.isGif()) {
                    imageType = FeedImageView.ImageType.IMAGE_GIF;
                } else {
                    imageType = FeedImageView.ImageType.NORMAL;
                }
                feedGifView.setImageType(imageType);
                feedGifView.setAsyncDefaultImage(j.h(7));
                int i16 = FeedDetailComment.this.mPicSize;
                feedGifView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(i16, i16, item.pivotXRate, item.pivotYRate));
                int i17 = FeedDetailComment.this.mPicSize;
                feedGifView.setGifWH(i17, i17);
                int i18 = FeedDetailComment.this.mPicSize;
                feedGifView.setAsyncClipSize(i18, i18);
                feedGifView.setAsyncGif(item.currentUrl.url, item.bigUrl.url);
                feedGifView.playGif();
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) feedGifView.getLayoutParams();
            if (layoutParams == null) {
                int i19 = FeedDetailComment.this.mPicSize;
                layoutParams = new AbsListView.LayoutParams(i19, i19);
            } else {
                int i26 = FeedDetailComment.this.mPicSize;
                layoutParams.height = i26;
                layoutParams.width = i26;
            }
            feedGifView.setLayoutParams(layoutParams);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return feedGifView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class OnEventBack implements SuperLikeView.OnEventBack {
        OnEventBack() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
        public void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
            if (AnonymousClass7.$SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[superLikeAnimator$Event.ordinal()] != 1) {
                return;
            }
            view.performClick();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ViewHolder {
        public View userInfoView;
    }

    public FeedDetailComment(Context context, int i3, g gVar) {
        this(context, i3, -1, gVar);
    }

    public static boolean checkUseNewReplyStyle() {
        return i.H().P2();
    }

    private View getDetailReplyView(Reply reply, int i3, String str, boolean z16) {
        String str2;
        FeedDetailReply feedDetailReply = new FeedDetailReply(this.mContext, this.position, i3, this.mReplyAvatarSize, this.onFeedElementClickListener);
        feedDetailReply.setUser(reply.user, reply.targetUser);
        String str3 = reply.refer;
        if (str3 != null && str3.length() > 0) {
            str2 = " " + reply.refer;
        } else {
            str2 = "";
        }
        feedDetailReply.setPublishTimeDesc(com.qzone.proxy.feedcomponent.util.c.d(reply.date) + str2);
        feedDetailReply.setContent(this.comment, reply);
        feedDetailReply.setReplyData(this.comment, reply);
        feedDetailReply.setReplyEnable(reply.isFake ^ true);
        feedDetailReply.setReplyVisible((!this.isReplyVisible || reply.isFake || reply.user.uin == i.H().j0()) ? false : true);
        feedDetailReply.setPraiseEnable(!reply.isFake);
        feedDetailReply.setPraiseVisible(!reply.isFake);
        feedDetailReply.setLongClickEnable(true);
        feedDetailReply.setContentViewEnabled(this.isReplyVisible);
        User user = reply.user;
        if (user != null && !TextUtils.isEmpty(user.nickName)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(reply.user.nickName + ", ");
            String str4 = com.qzone.proxy.feedcomponent.util.c.d(reply.date) + str2;
            if (!TextUtils.isEmpty(str4)) {
                sb5.append(str4 + ", ");
            }
            sb5.append("\u70b9\u51fb\u8fdb\u5165\u4ed6\u7684\u7a7a\u95f4");
            if (feedDetailReply.mViewHolder == null) {
                ViewHolder viewHolder = new ViewHolder();
                feedDetailReply.mViewHolder = viewHolder;
                viewHolder.userInfoView = feedDetailReply.getView().findViewById(j.O(j.O(2257)));
            }
            View view = feedDetailReply.mViewHolder.userInfoView;
            if (view != null) {
                view.setContentDescription(sb5.toString());
            }
        }
        ArrayList<CellLikeInfo.LikeMan> arrayList = reply.likeMen;
        if (((arrayList != null && arrayList.size() > 0) || reply.isliked) && !reply.isFake) {
            feedDetailReply.setPraiserVisible(false);
            feedDetailReply.setPraiser(reply.likeMen, reply.isliked);
        } else {
            feedDetailReply.setPraiserVisible(false);
        }
        View view2 = feedDetailReply.getView();
        view2.setTag(this);
        return view2;
    }

    private View getPictureViewerReplyView(Reply reply, int i3, String str, boolean z16) {
        CellTextView cellTextView = new CellTextView(this.mContext);
        if (z16 && !TextUtils.isEmpty(str) && str.equals(reply.replyId)) {
            getView().setBackgroundResource(j.h(22));
        } else {
            getView().setBackgroundResource(0);
        }
        cellTextView.setBackgroundResource(j.h(716));
        float f16 = this.mContext.getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        cellTextView.setPadding(0, 0, (int) ((7.0f * f16) + 0.5f), (int) ((f16 * 2.5f) + 0.5f));
        cellTextView.setLayoutParams(layoutParams);
        if (this.isUsePictureViewerLayout) {
            cellTextView.setTextColor(j.c(32));
            cellTextView.setTextSize(FeedGlobalEnv.g().getSpValue(13.0f));
        } else {
            cellTextView.setTextColor(j.o());
            cellTextView.setTextSize(FeedGlobalEnv.g().getSpValue(15.0f));
        }
        cellTextView.setClickable(true);
        cellTextView.setId(((this.position + 1) * 10000) + i3 + 1);
        cellTextView.setDrawBackground(true);
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(this.comment);
        clickedComment.setReply(reply);
        cellTextView.setTag(clickedComment);
        cellTextView.setOnClickListener(this.onButtonClick);
        cellTextView.setLongClickable(true);
        cellTextView.setOnLongClickListener(this.onLongClick);
        StringBuilder sb5 = new StringBuilder();
        User user = reply.targetUser;
        if (user != null && user.uin != 0) {
            User user2 = reply.user;
            if (user2 != null) {
                if (user2.actiontype == 2) {
                    sb5.append(DetailUtil.buildActionUrlString(user2.actionurl, user2.nickName));
                } else {
                    sb5.append(DetailUtil.buildNicknameString(user2.uin, user2.nickName));
                }
            }
            if (!this.isUsePictureViewerLayout) {
                sb5.append("{text:");
                sb5.append(REPLAY_STR);
                sb5.append(",color:");
                sb5.append(Integer.toHexString(j.o()));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
            } else {
                sb5.append("{text:");
                sb5.append(REPLAY_STR);
                sb5.append(",color:");
                sb5.append(Integer.toHexString(j.c(31)));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
            }
            User user3 = reply.targetUser;
            if (user3.actiontype == 2) {
                sb5.append(DetailUtil.buildActionUrlString(user3.actionurl, user3.nickName));
            } else {
                sb5.append(DetailUtil.buildNicknameString(user3.uin, user3.nickName));
            }
        } else {
            User user4 = reply.user;
            if (user4 != null) {
                if (user4.actiontype == 2) {
                    sb5.append(DetailUtil.buildActionUrlString(user4.actionurl, user4.nickName));
                } else {
                    sb5.append(DetailUtil.buildNicknameString(user4.uin, user4.nickName));
                }
            }
        }
        if (this.isUsePictureViewerLayout) {
            sb5.append("{text:");
            sb5.append("\uff1a");
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.c(31)));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(reply.content);
        } else {
            sb5.append("{text:");
            sb5.append("\uff1a");
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.o()));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(reply.content);
        }
        cellTextView.setParseUrl(true);
        cellTextView.setUrlColorRes(this.linkColor);
        cellTextView.setTextColorLink(this.linkColor);
        cellTextView.setOnCellClickListener(this.mOnCellClickListener);
        ArrayList<TextCell> parseContent = cellTextView.parseContent(sb5.toString(), true);
        cellTextView.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        setTextEffect(cellTextView, reply.getSuperFontInfo(false));
        cellTextView.setText(parseContent);
        cellTextView.setFocusable(true);
        StringBuilder sb6 = new StringBuilder();
        User user5 = reply.targetUser;
        if (user5 != null && user5.uin != 0) {
            sb6.append(reply.user.nickName);
            sb6.append(REPLAY_STR);
            sb6.append(reply.targetUser.nickName);
        } else {
            sb6.append(reply.user.nickName);
        }
        sb6.append("\uff1a");
        sb6.append(reply.content);
        if (i.H().S0()) {
            cellTextView.setContentDescription(DetailUtil.EmoCode2Text(sb6.toString()));
        }
        return cellTextView;
    }

    private View getPlainDetailReplyView(Reply reply, int i3, String str, boolean z16) {
        CellTextView cellTextView = new CellTextView(this.mContext);
        if (z16 && !TextUtils.isEmpty(str) && str.equals(reply.replyId)) {
            getView().setBackgroundResource(j.h(22));
        } else {
            getView().setBackgroundResource(0);
        }
        cellTextView.setBackgroundResource(j.h(716));
        float f16 = this.mContext.getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        cellTextView.setPadding(0, 0, (int) ((7.0f * f16) + 0.5f), (int) ((f16 * 2.5f) + 0.5f));
        cellTextView.setLayoutParams(layoutParams);
        if (this.isUsePictureViewerLayout) {
            cellTextView.setTextColor(j.c(32));
            cellTextView.setTextSize(FeedGlobalEnv.g().getSpValue(13.0f));
        } else {
            cellTextView.setTextColor(j.o());
            cellTextView.setTextSize(FeedGlobalEnv.g().getSpValue(15.0f));
        }
        cellTextView.setClickable(true);
        cellTextView.setId(((this.position + 1) * 10000) + i3 + 1);
        cellTextView.setDrawBackground(true);
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(this.comment);
        clickedComment.setReply(reply);
        cellTextView.setTag(clickedComment);
        cellTextView.setOnClickListener(this.onButtonClick);
        cellTextView.setLongClickable(true);
        cellTextView.setOnLongClickListener(this.onLongClick);
        StringBuilder sb5 = new StringBuilder();
        User user = reply.targetUser;
        if (user != null && user.uin != 0) {
            User user2 = reply.user;
            if (user2 != null) {
                if (user2.actiontype == 2) {
                    sb5.append(DetailUtil.buildActionUrlString(user2.actionurl, user2.nickName));
                } else {
                    sb5.append(DetailUtil.buildNicknameString(user2.uin, user2.nickName));
                }
            }
            if (!this.isUsePictureViewerLayout) {
                sb5.append("{text:");
                sb5.append(REPLAY_STR);
                sb5.append(",color:");
                sb5.append(Integer.toHexString(j.o()));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
            } else {
                sb5.append("{text:");
                sb5.append(REPLAY_STR);
                sb5.append(",color:");
                sb5.append(Integer.toHexString(j.c(31)));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
            }
            User user3 = reply.targetUser;
            if (user3.actiontype == 2) {
                sb5.append(DetailUtil.buildActionUrlString(user3.actionurl, user3.nickName));
            } else {
                sb5.append(DetailUtil.buildNicknameString(user3.uin, user3.nickName));
            }
        } else {
            User user4 = reply.user;
            if (user4 != null) {
                if (user4.actiontype == 2) {
                    sb5.append(DetailUtil.buildActionUrlString(user4.actionurl, user4.nickName));
                } else {
                    sb5.append(DetailUtil.buildNicknameString(user4.uin, user4.nickName));
                }
            }
        }
        if (this.isUsePictureViewerLayout) {
            sb5.append("{text:");
            sb5.append("\uff1a");
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.c(31)));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(reply.content);
        } else {
            sb5.append("{text:");
            sb5.append("\uff1a");
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.o()));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(reply.content);
        }
        cellTextView.setParseUrl(true);
        cellTextView.setUrlColorRes(this.linkColor);
        cellTextView.setTextColorLink(this.linkColor);
        cellTextView.setOnCellClickListener(this.mOnCellClickListener);
        ArrayList<TextCell> parseContent = cellTextView.parseContent(sb5.toString(), true);
        cellTextView.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        setTextEffect(cellTextView, reply.getSuperFontInfo(false));
        cellTextView.setText(parseContent);
        cellTextView.setFocusable(true);
        StringBuilder sb6 = new StringBuilder();
        User user5 = reply.targetUser;
        if (user5 != null && user5.uin != 0) {
            sb6.append(reply.user.nickName);
            sb6.append(REPLAY_STR);
            sb6.append(reply.targetUser.nickName);
        } else {
            sb6.append(reply.user.nickName);
        }
        sb6.append("\uff1a");
        sb6.append(reply.content);
        if (i.H().S0()) {
            cellTextView.setContentDescription(DetailUtil.EmoCode2Text(sb6.toString()));
        }
        return cellTextView;
    }

    private void initUI() {
        ViewGroup.LayoutParams layoutParams;
        View view = getView();
        if (view == null) {
            return;
        }
        AvatarImageView avatarImageView = (AvatarImageView) view.findViewById(j.O(2250));
        this.commentImgUserIcon = avatarImageView;
        if (this.mAvatarSize > 0 && (layoutParams = avatarImageView.getLayoutParams()) != null) {
            int i3 = this.mAvatarSize;
            layoutParams.height = i3;
            layoutParams.width = i3;
            this.commentImgUserIcon.setLayoutParams(layoutParams);
        }
        CellTextView cellTextView = (CellTextView) view.findViewById(j.O(2251));
        this.commentAuthor = cellTextView;
        if (cellTextView != null) {
            cellTextView.setLongClickable(true);
            setLinkColor(this.commentAuthor);
        }
        this.commentPublishDesciption = (TextView) view.findViewById(j.O(2252));
        this.commentContent = (CellTextView) view.findViewById(j.O(2253));
        this.commentReplyContainer = (LinearLayout) view.findViewById(j.O(2254));
        this.commentReplyButton = (TextView) view.findViewById(j.O(2255));
        this.newCommentReplyButton = (TextView) view.findViewById(j.O(2839));
        this.mCommentPictureGridView = (ExtendGridView) view.findViewById(j.O(2256));
        CommentImageAdapter commentImageAdapter = new CommentImageAdapter();
        this.mCommentImageAdapter = commentImageAdapter;
        this.mCommentPictureGridView.setAdapter((ListAdapter) commentImageAdapter);
        this.mCommentPictureGridView.setOnItemClickListener(this.commentPictureGridViewClickListener);
        this.mCommentPictureGridView.setOnItemLongClickListener(this.commentPictureGridViewLongClickListener);
        this.commentPraiser = (TextView) view.findViewById(j.O(2665));
        this.publishTimeReplyButtonContainer = view.findViewById(j.O(2817));
        this.commentContent.setMaxCommentLine(MaxCommentLineConfig.MAX_COMMENT_LINE_DETAIL);
        this.commentContent.setClickable(true);
        CellTextView cellTextView2 = this.commentAuthor;
        if (cellTextView2 != null) {
            cellTextView2.setTextBold(false);
            this.commentAuthor.setTextSize(FeedGlobalEnv.g().getSpValue(15.0f));
        }
        this.superLikeView = (SuperLikeView) view.findViewById(j.O(2625));
        this.likeTextView = (TextView) view.findViewById(j.O(2626));
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setOnEventBack(new OnEventBack());
            this.defaultLikeDrawable = this.superLikeView.getDrawable();
        }
        this.publishTimeAndMoreReplyContainer = (LinearLayout) view.findViewById(j.O(2778));
        this.publishTimeAndMoreReplySeparatorDot = view.findViewById(j.O(2782));
        this.commentItemSeparator = view.findViewById(j.O(2784));
        this.replyDetailHeaderSeparator = view.findViewById(j.O(2785));
    }

    private void prepareForSuperLikeAnimation() {
        try {
            traversalParents(this.superLikeView, 0);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void setPraiseStatus(boolean z16) {
        if (!this.isUsePictureViewerLayout) {
            this.superLikeView.setImageDrawable(this.defaultLikeDrawable);
            return;
        }
        if (z16) {
            this.superLikeView.setImageDrawable(this.defaultLikeDrawable);
            this.superLikeView.setContentDescription(l.a(R.string.s3u));
        } else {
            this.superLikeView.setImageResource(R.drawable.qui_like);
            this.superLikeView.setContentDescription(l.a(R.string.f172561s45));
            com.tencent.mobileqq.qzone.picload.c.a().m(this.superLikeView, -1);
        }
    }

    private void setReplyContent(Reply reply) {
        User user;
        boolean isEmpty = TextUtils.isEmpty(reply.content);
        this.commentContent.setVisibility(isEmpty ? 8 : 0);
        if (this.isUsePictureViewerLayout) {
            this.commentContent.setTextColor(j.c(32));
        } else {
            this.commentContent.setTextColor(j.o());
        }
        this.commentContent.setUrlColorRes(this.linkColor);
        this.commentContent.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        setTextEffect(this.commentContent, reply.getSuperFontInfo(false));
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(this.comment);
        clickedComment.setReply(reply);
        this.commentContent.setTag(clickedComment);
        StringBuilder sb5 = new StringBuilder();
        User user2 = reply.targetUser;
        if (user2 != null && (user = this.comment.user) != null && user2.uin != user.uin) {
            sb5.append(REPLAY_STR);
            User user3 = reply.targetUser;
            if (user3.actiontype == 2) {
                sb5.append(DetailUtil.buildActionUrlString(user3.actionurl, user3.nickName));
            } else {
                sb5.append(DetailUtil.buildNicknameString(user3.uin, user3.nickName));
            }
            sb5.append("{text:");
            sb5.append("\uff1a");
            sb5.append(",color:");
            sb5.append(Integer.toHexString(j.o()));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
        }
        sb5.append(reply.content);
        this.commentContent.setRichText(isEmpty ? "" : sb5.toString());
        this.commentContent.setDrawBackground(true);
        if (i.H().S0()) {
            this.commentContent.setContentDescription(isEmpty ? "" : DetailUtil.EmoCode2Text(sb5.toString()));
        }
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setSelected(reply.isliked);
            int i3 = reply.likeNum;
            if (i3 > 0) {
                this.likeTextView.setText(d.l(i3));
            } else {
                this.likeTextView.setText((CharSequence) null);
            }
        }
    }

    void bindEvents() {
        AvatarImageView avatarImageView = this.commentImgUserIcon;
        if (avatarImageView != null) {
            avatarImageView.setOnClickListener(this.onButtonClick);
        }
        CellTextView cellTextView = this.commentAuthor;
        if (cellTextView != null) {
            cellTextView.setOnClickListener(this.onButtonClick);
        }
        TextView textView = this.commentReplyButton;
        if (textView != null) {
            textView.setOnClickListener(this.onButtonClick);
        }
        TextView textView2 = this.newCommentReplyButton;
        if (textView2 != null) {
            textView2.setOnClickListener(this.onButtonClick);
        }
        CellTextView cellTextView2 = this.commentContent;
        if (cellTextView2 != null) {
            cellTextView2.setOnClickListener(this.onButtonClick);
            this.commentContent.setParseUrl(true);
            this.commentContent.setUrlColorRes(this.linkColor);
            this.commentContent.setOnCellClickListener(this.mOnCellClickListener);
            this.commentContent.setLongClickable(true);
            this.commentContent.setOnLongClickListener(this.onLongClick);
        }
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setOnClickListener(this.onButtonClick);
            this.superLikeView.setFocusable(true);
        }
    }

    boolean canLikeClick() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastLikeClickTime <= 1000) {
            return false;
        }
        this.lastLikeClickTime = uptimeMillis;
        return true;
    }

    String getUserString(User user) {
        return DetailUtil.buildNicknameString(user.uin, user.nickName);
    }

    void initView() {
        if (this.isUsePictureViewerLayout) {
            this.linkColor = j.c(31);
        } else {
            this.linkColor = j.I();
        }
        setView(LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null));
    }

    void onPraiseViewClick() {
        Animation loadAnimation;
        if (this.superLikeView.isSelected()) {
            setPraiseStatus(false);
            return;
        }
        prepareForSuperLikeAnimation();
        setPraiseStatus(true);
        int b16 = j.b(4098);
        if (getContext() == null || (loadAnimation = AnimationUtils.loadAnimation(getContext(), b16)) == null) {
            return;
        }
        Log.d("FeedDetailComment", "click: " + this.superLikeView + ", dis=" + this.comment.displayStr);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Animation loadAnimation2;
                Log.d("FeedDetailComment", "start, onAnimationEnd: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
                int b17 = j.b(4099);
                if (FeedDetailComment.this.getContext() == null || (loadAnimation2 = AnimationUtils.loadAnimation(FeedDetailComment.this.getContext(), b17)) == null) {
                    return;
                }
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.6.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        Log.d("FeedDetailComment", "end, onAnimationEnd: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                        Log.d("FeedDetailComment", "end, onAnimationRepeat: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                        Log.d("FeedDetailComment", "end, onAnimationStart: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
                    }
                });
                FeedDetailComment.this.superLikeView.startAnimation(loadAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Log.d("FeedDetailComment", "start, onAnimationRepeat: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Log.d("FeedDetailComment", "start, onAnimationStart: " + FeedDetailComment.this.superLikeView + ", dis=" + FeedDetailComment.this.comment.displayStr);
            }
        });
        this.superLikeView.startAnimation(loadAnimation);
    }

    protected void openUrl(String str, String str2, String str3) {
        this.onFeedElementClickListener.onClick(null, FeedElement.URL, 0, new e(str, str3, 0));
    }

    void setAvatar(long j3) {
        this.commentImgUserIcon.loadAvatar(j3);
    }

    public void setCommentData(Comment comment) {
        this.comment = comment;
        if (comment == null || this.commentAuthor == null) {
            return;
        }
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(comment);
        CellTextView cellTextView = this.commentContent;
        if (cellTextView != null) {
            cellTextView.setTag(clickedComment);
        }
        TextView textView = this.newCommentReplyButton;
        if (textView != null) {
            textView.setTag(clickedComment);
        }
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setSelected(comment.isliked);
            setPraiseStatus(comment.isliked);
            int i3 = comment.likeNum;
            if (i3 > 0) {
                this.likeTextView.setText(d.l(i3));
            } else {
                this.likeTextView.setText((CharSequence) null);
            }
        }
        this.commentAuthor.resetSideDrawables();
        setStickIcon(comment);
        View view = getView();
        if (view == null) {
            return;
        }
        view.setBackgroundResource(0);
        if (!this.isUsePictureViewerLayout && checkUseNewReplyStyle()) {
            view.setPadding(view.getPaddingLeft(), AreaConst.dp10, view.getPaddingRight(), view.getPaddingBottom());
            LinearLayout linearLayout = this.commentReplyContainer;
            if (linearLayout != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).topMargin = AreaConst.dp6;
            }
            if (this.isReplyVisible) {
                this.publishTimeAndMoreReplySeparatorDot.setVisibility(0);
            } else {
                this.publishTimeAndMoreReplySeparatorDot.setVisibility(8);
            }
            ((ViewGroup.MarginLayoutParams) this.likeTextView.getLayoutParams()).leftMargin = AreaConst.f48747dp2;
            TextView textView2 = this.newCommentReplyButton;
            if (textView2 != null && this.isReplyVisible) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.commentReplyButton;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.commentPraiser;
            if (textView4 != null) {
                ViewGroup.LayoutParams layoutParams = textView4.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AreaConst.f48749dp4;
                    this.commentPraiser.setLayoutParams(layoutParams);
                }
            }
            View view2 = this.publishTimeReplyButtonContainer;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = AreaConst.dp6;
                    this.publishTimeReplyButtonContainer.setLayoutParams(layoutParams2);
                }
            }
            LinearLayout linearLayout2 = this.commentReplyContainer;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(linearLayout2.getPaddingLeft(), AreaConst.f48748dp3, this.commentReplyContainer.getPaddingRight(), this.commentReplyContainer.getPaddingBottom());
                return;
            }
            return;
        }
        TextView textView5 = this.newCommentReplyButton;
        if (textView5 != null && !this.isReplyVisible) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.commentReplyButton;
        if (textView6 == null || !this.isReplyVisible) {
            return;
        }
        textView6.setVisibility(0);
    }

    public void setCommentDetailHeaderSeparator(boolean z16) {
        View view = this.replyDetailHeaderSeparator;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setCommentItemSeparator(boolean z16, boolean z17) {
        View view = this.commentItemSeparator;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
            if (z16) {
                this.commentItemSeparator.setBackgroundColor(j.H());
            }
        }
    }

    public void setCommentType(int i3) {
        this.mCommentType = i3;
    }

    public void setContent(Comment comment) {
        boolean isEmpty = TextUtils.isEmpty(comment.comment);
        this.commentContent.setVisibility(isEmpty ? 8 : 0);
        if (isClickComment(comment)) {
            this.commentContent.setMaxCommentLine(0);
        } else {
            this.commentContent.setMaxCommentLine(MaxCommentLineConfig.MAX_COMMENT_LINE_DETAIL);
        }
        if (this.isUsePictureViewerLayout) {
            this.commentContent.setTextColor(j.c(32));
        } else {
            this.commentContent.setTextColor(j.o());
        }
        this.commentContent.setUrlColorRes(this.linkColor);
        this.commentContent.setFont(comment.getFontId(false), comment.getFontUrl(false), comment.getFontType(false));
        setTextEffect(this.commentContent, comment.getSuperFontInfo(false));
        boolean z16 = comment.hasPokeLike() && (TextUtils.isEmpty(comment.comment) || "\u2000".equals(comment.comment));
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = comment.getBarrageEffectInfo(comment.feedType == 4097);
        if (barrageEffectInfo != null && barrageEffectInfo.f51896id > 0 && !z16) {
            this.commentContent.setBarrageEffect(true, barrageEffectInfo);
        } else {
            this.commentContent.setBarrageEffect(false, null);
        }
        this.commentContent.setRichText(isEmpty ? "" : comment.getPokeLikeComment());
        this.commentContent.setDrawBackground(true);
        if (i.H().S0()) {
            this.commentContent.setContentDescription(isEmpty ? "" : DetailUtil.EmoCode2Text(comment.comment));
        }
    }

    public void setContentViewClickable(boolean z16) {
        CellTextView cellTextView = this.commentContent;
        if (cellTextView != null) {
            cellTextView.setClickable(z16);
        }
    }

    public void setContentViewEnabled(boolean z16) {
        CellTextView cellTextView = this.commentContent;
        if (cellTextView != null) {
            this.contentClickEnable = z16;
            cellTextView.setEnabled(z16);
        }
    }

    public void setLinkColor(CellTextView cellTextView) {
        if (AreaManager.IS_NIGHT_MODE) {
            cellTextView.setTextColorLink(-1);
        } else {
            cellTextView.setTextColorLink(-16777216);
        }
    }

    public void setLongClickEnable(boolean z16) {
        this.longClickEnable = z16;
    }

    public void setNickName(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.commentAuthor.setVisibility(isEmpty ? 8 : 0);
        this.commentAuthor.setParseUrl(false);
        CellTextView cellTextView = this.commentAuthor;
        String str2 = isEmpty ? "" : str;
        int i3 = this.nickNameColor;
        cellTextView.setRichText(str2, i3, i3, i3);
        this.commentAuthor.setDrawBackground(true);
        CellTextView cellTextView2 = this.commentAuthor;
        if (isEmpty) {
            str = "";
        }
        cellTextView2.setContentDescription(str);
    }

    public void setPicture(ArrayList<PictureItem> arrayList, boolean z16) {
        this.mCommentImageAdapter.setImageInfos(arrayList);
        this.mIsCommentImage = z16;
    }

    public void setPosition(int i3) {
        this.position = i3;
    }

    public void setPraiseEnable(boolean z16) {
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setEnabled(z16);
        }
    }

    public void setPraiseVisible(boolean z16) {
        SuperLikeView superLikeView = this.superLikeView;
        if (superLikeView != null) {
            superLikeView.setVisibility(z16 ? 0 : 8);
            this.likeTextView.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setPraiser(ArrayList<CellLikeInfo.LikeMan> arrayList, boolean z16) {
        User user;
        if (this.commentPraiser != null) {
            Drawable g16 = j.g(816);
            if (g16 != null) {
                g16.setBounds(0, 0, ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f));
            }
            this.commentPraiser.setCompoundDrawables(g16, null, null, null);
            this.commentPraiser.setCompoundDrawablePadding(ViewUtils.dpToPx(2.5f));
            StringBuilder sb5 = new StringBuilder();
            long j06 = i.H().j0();
            if (z16) {
                sb5.append(i.H().k0());
                if (arrayList != null && arrayList.size() != 0) {
                    sb5.append("\u3001");
                } else {
                    sb5.append(likeText);
                    this.commentPraiser.setText(sb5.toString());
                    return;
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            int min = Math.min(z16 ? 2 : 3, arrayList.size());
            boolean z17 = min > (z16 ? 2 : 3);
            Iterator<CellLikeInfo.LikeMan> it = arrayList.iterator();
            while (it.hasNext()) {
                CellLikeInfo.LikeMan next = it.next();
                if (next != null && (user = next.user) != null && user.uin != j06) {
                    sb5.append(user.nickName);
                    min--;
                    if (min > 0) {
                        sb5.append("\u3001");
                    } else {
                        if (z17) {
                            sb5.append(soOnText);
                            sb5.append(arrayList.size());
                            sb5.append(manyLikeText);
                        } else {
                            sb5.append(likeText);
                        }
                        this.commentPraiser.setText(sb5.toString());
                        return;
                    }
                }
            }
        }
    }

    public void setPraiserVisible(boolean z16) {
        TextView textView = this.commentPraiser;
        if (textView != null) {
            textView.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setPublishTimeDesc(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.commentPublishDesciption.setVisibility(isEmpty ? 8 : 0);
        TextView textView = this.commentPublishDesciption;
        if (isEmpty) {
            str = "";
        }
        textView.setText(str);
    }

    public void setReply(List<Reply> list, String str, boolean z16, boolean z17, int i3) {
        View view;
        LinearLayout.LayoutParams layoutParams;
        View plainDetailReplyView;
        if (list == null) {
            if (this.isUsePictureViewerLayout) {
                LinearLayout linearLayout = this.publishTimeAndMoreReplyContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                View view2 = this.publishTimeAndMoreReplySeparatorDot;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            this.commentReplyContainer.setVisibility(8);
            return;
        }
        int size = list.size();
        if (size > 0) {
            int min = (!z17 || i3 < 0) ? size : Math.min(size, i3);
            this.commentReplyContainer.setVisibility(0);
            this.commentReplyContainer.removeAllViews();
            LinearLayout linearLayout2 = this.publishTimeAndMoreReplyContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.publishTimeAndMoreReplyContainer.removeAllViews();
            }
            for (int i16 = 0; i16 < min; i16++) {
                Reply reply = list.get(i16);
                if (this.isUsePictureViewerLayout) {
                    this.commentReplyContainer.addView(getPictureViewerReplyView(reply, i16, str, z16));
                } else {
                    if (checkUseNewReplyStyle()) {
                        plainDetailReplyView = getDetailReplyView(reply, i16, str, z16);
                    } else {
                        plainDetailReplyView = getPlainDetailReplyView(reply, i16, str, z16);
                    }
                    this.commentReplyContainer.addView(plainDetailReplyView);
                }
            }
            if (min < size) {
                CellTextView cellTextView = new CellTextView(this.mContext);
                this.commentMoreReply = cellTextView;
                cellTextView.setClickable(true);
                this.commentMoreReply.setDrawBackground(true);
                this.commentMoreReply.setOnClickListener(this.onButtonClick);
                this.commentMoreReply.setText(this.commentMoreReply.parseContent(size + "\u6761\u56de\u590d", true));
                ImageView imageView = new ImageView(this.mContext);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageDrawable(j.g(882));
                if (this.isUsePictureViewerLayout) {
                    layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dpToPx(12.0f));
                    layoutParams.gravity = 16;
                    this.commentMoreReply.setTextSize(FeedGlobalEnv.g().getSpValue(13.0f));
                    this.commentMoreReply.setTextColor(-10987432);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = AreaConst.f48747dp2;
                    layoutParams.gravity = 16;
                    this.commentMoreReply.setTextSize(FeedGlobalEnv.g().getSpValue(10.0f));
                    this.commentMoreReply.setTextColor(j.F());
                }
                imageView.setLayoutParams(layoutParams);
                if (min == 0 && this.publishTimeAndMoreReplyContainer != null) {
                    if (this.isUsePictureViewerLayout) {
                        View view3 = this.publishTimeAndMoreReplySeparatorDot;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                    } else {
                        checkUseNewReplyStyle();
                    }
                    if (this.isUsePictureViewerLayout) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.gravity = 17;
                        layoutParams2.leftMargin = ViewUtils.dpToPx(10.0f);
                        this.publishTimeAndMoreReplyContainer.setLayoutParams(layoutParams2);
                    }
                    this.publishTimeAndMoreReplyContainer.setOrientation(0);
                    this.publishTimeAndMoreReplyContainer.addView(this.commentMoreReply);
                    this.publishTimeAndMoreReplyContainer.addView(imageView);
                    this.publishTimeAndMoreReplyContainer.setVisibility(0);
                    this.publishTimeAndMoreReplyContainer.setBackground(j.g(881));
                    return;
                }
                LinearLayout linearLayout3 = new LinearLayout(this.mContext);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 16;
                linearLayout3.setOrientation(0);
                linearLayout3.addView(this.commentMoreReply);
                linearLayout3.addView(imageView);
                linearLayout3.setBackground(j.g(881));
                if (!this.isUsePictureViewerLayout && checkUseNewReplyStyle()) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.commentMoreReply.getLayoutParams();
                    layoutParams4.gravity = 16;
                    this.commentMoreReply.setLayoutParams(layoutParams4);
                    layoutParams3.setMargins(this.mReplyAvatarSize + AreaConst.f48749dp4, AreaConst.dp8, 0, AreaConst.dp7);
                    layoutParams3.height = AreaConst.dp24;
                }
                linearLayout3.setLayoutParams(layoutParams3);
                this.commentReplyContainer.addView(linearLayout3);
                return;
            }
            return;
        }
        LinearLayout linearLayout4 = this.commentReplyContainer;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        LinearLayout linearLayout5 = this.publishTimeAndMoreReplyContainer;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        if (!this.isUsePictureViewerLayout || (view = this.publishTimeAndMoreReplySeparatorDot) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void setReplyEnable(boolean z16) {
        TextView textView = this.commentReplyButton;
        if (textView != null) {
            textView.setEnabled(z16);
        }
        TextView textView2 = this.newCommentReplyButton;
        if (textView2 != null) {
            textView2.setEnabled(z16);
        }
    }

    public void setReplyVisible(boolean z16) {
        this.isReplyVisible = z16;
        if (!this.isUsePictureViewerLayout && !checkUseNewReplyStyle()) {
            TextView textView = this.commentReplyButton;
            if (textView != null) {
                textView.setVisibility(z16 ? 0 : 8);
            }
            TextView textView2 = this.newCommentReplyButton;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = this.commentReplyButton;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.newCommentReplyButton;
        if (textView4 != null) {
            textView4.setVisibility(z16 ? 0 : 8);
        }
        View view = this.publishTimeAndMoreReplySeparatorDot;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.c
    public void setView(View view) {
        super.setView(view);
        initUI();
    }

    public void traversalParents(View view, int i3) {
        if (view.getParent() != null && i3 <= 5) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                viewGroup.setClipChildren(false);
                if (i3 == 5) {
                    viewGroup.setClipToPadding(false);
                }
            }
            if (view.getParent() instanceof View) {
                traversalParents((View) view.getParent(), i3 + 1);
            }
        }
    }

    public FeedDetailComment(Context context, int i3, int i16, g gVar) {
        this(context, i3, i16, gVar, false);
    }

    void setAvatar(String str) {
        if (str != null) {
            this.commentImgUserIcon.loadAvatar(str);
        }
    }

    public FeedDetailComment(Context context, int i3, int i16, g gVar, boolean z16) {
        this(context, false, i3, i16, gVar, z16);
    }

    private void setStickIcon(Comment comment) {
        if (comment == null || !comment.isStickTop) {
            return;
        }
        Drawable g16 = j.g(802);
        g16.setBounds(0, 0, com.qzone.proxy.feedcomponent.util.g.a(27.0f), AreaConst.dp15);
        this.commentAuthor.addRightDrawable(g16, 10001);
    }

    protected int getLayoutId() {
        return this.isUsePictureViewerLayout ? j.j(FSUploadConst.ERR_FILE_NOT_EXIST) : j.j(1654);
    }

    public FeedDetailComment(Context context, boolean z16, int i3, int i16, g gVar, boolean z17) {
        super(context);
        this.replies = new HashSet();
        this.mReplyAvatarSize = AreaConst.dp22;
        this.mPicSize = b.f41871r;
        this.longClickEnable = true;
        this.contentClickEnable = true;
        this.mCommentType = 1;
        this.commentPictureGridViewClickListener = new AdapterView.OnItemClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i17, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i17, j3);
                if (FeedDetailComment.this.mCommentImageAdapter != null) {
                    CellPictureInfo cellPictureInfo = new CellPictureInfo();
                    cellPictureInfo.balbum = false;
                    cellPictureInfo.albumnum = 1;
                    cellPictureInfo.uploadnum = 1;
                    cellPictureInfo.pics = FeedDetailComment.this.mCommentImageAdapter.getImageInfoList();
                    FeedDetailComment.this.onFeedElementClickListener.onClick(null, FeedElement.OPEN_PICTURE_VIEWER, 0, i.H().I(cellPictureInfo, i17));
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i17, j3);
            }
        };
        this.commentPictureGridViewLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i17, long j3) {
                EventCollector.getInstance().onItemLongClickBefore(adapterView, view, i17, j3);
                FeedDetailComment feedDetailComment = FeedDetailComment.this;
                if (feedDetailComment.mCommentImageAdapter != null) {
                    feedDetailComment.onFeedElementClickListener.onClick(feedDetailComment.commentContent, FeedElement.COMMENT_PIC_LONG_CLICK, 0, null);
                }
                EventCollector.getInstance().onItemLongClick(adapterView, view, i17, j3);
                return true;
            }
        };
        this.onLongClick = new View.OnLongClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                EventCollector.getInstance().onViewLongClickedBefore(view);
                FeedDetailComment feedDetailComment = FeedDetailComment.this;
                if (feedDetailComment.onFeedElementClickListener != null && feedDetailComment.longClickEnable) {
                    if (view.getId() == j.O(2253) && FeedDetailComment.this.mCommentType != 2) {
                        FeedDetailComment.this.onFeedElementClickListener.onClick(view, FeedElement.COMMENT_LONG_CLICK, 0, null);
                    } else {
                        FeedDetailComment.this.onFeedElementClickListener.onClick(view, FeedElement.REPLY_LONG_CLICK, 0, null);
                    }
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return true;
            }
        };
        this.onButtonClick = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int id5 = view.getId();
                if (id5 != j.O(2250) && id5 != j.O(2251)) {
                    if (id5 == j.O(2253)) {
                        FeedDetailComment feedDetailComment = FeedDetailComment.this;
                        if (feedDetailComment.commentUser != null) {
                            if (feedDetailComment.mCommentType == 2) {
                                FeedDetailComment feedDetailComment2 = FeedDetailComment.this;
                                g gVar2 = feedDetailComment2.onFeedElementClickListener;
                                FeedElement feedElement = FeedElement.REPLY_ITEM;
                                int i17 = feedDetailComment2.position;
                                gVar2.onClick(view, feedElement, i17, Integer.valueOf(i17));
                            } else {
                                FeedDetailComment feedDetailComment3 = FeedDetailComment.this;
                                g gVar3 = feedDetailComment3.onFeedElementClickListener;
                                FeedElement feedElement2 = FeedElement.COMMENT_ITEM;
                                int i18 = feedDetailComment3.position;
                                gVar3.onClick(view, feedElement2, i18, Integer.valueOf(i18));
                            }
                            if ("com.qzone.detail.ui.activity.QzoneCommentDetailActivity".equals(FeedDetailComment.this.mContext.getClass().getName())) {
                                i.H().f(209, 3, 10);
                            }
                        }
                    } else if (view != FeedDetailComment.this.newCommentReplyButton && id5 != j.O(2255)) {
                        FeedDetailComment feedDetailComment4 = FeedDetailComment.this;
                        if (view == feedDetailComment4.superLikeView) {
                            if (feedDetailComment4.canLikeClick()) {
                                FeedDetailComment.this.onPraiseViewClick();
                                Bundle bundle = new Bundle();
                                bundle.putInt("position", FeedDetailComment.this.position);
                                Comment comment = FeedDetailComment.this.comment;
                                if (comment != null) {
                                    bundle.putInt("commenttype", comment.commentType);
                                }
                                if (FeedDetailComment.this.mCommentType != 1) {
                                    if (FeedDetailComment.this.mCommentType == 2) {
                                        bundle.putInt("reply_pos", FeedDetailComment.this.position - 1);
                                        FeedDetailComment feedDetailComment5 = FeedDetailComment.this;
                                        feedDetailComment5.onFeedElementClickListener.onClick(feedDetailComment5.superLikeView, FeedElement.REPLY_PRAISE_BUTTON, 0, bundle);
                                    }
                                } else {
                                    FeedDetailComment feedDetailComment6 = FeedDetailComment.this;
                                    feedDetailComment6.onFeedElementClickListener.onClick(feedDetailComment6.superLikeView, FeedElement.COMMENT_PRAISE_BUTTON, 0, bundle);
                                }
                            }
                        } else {
                            CellTextView cellTextView = feedDetailComment4.commentMoreReply;
                            if (cellTextView != null && view == cellTextView) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("position", FeedDetailComment.this.position);
                                Comment comment2 = FeedDetailComment.this.comment;
                                if (comment2 != null) {
                                    bundle2.putInt("commenttype", comment2.commentType);
                                }
                                FeedDetailComment feedDetailComment7 = FeedDetailComment.this;
                                feedDetailComment7.onFeedElementClickListener.onClick(view, FeedElement.MORE_REPLY, feedDetailComment7.position, bundle2);
                            } else if (cellTextView != null && view == cellTextView) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putInt("position", FeedDetailComment.this.position);
                                Comment comment3 = FeedDetailComment.this.comment;
                                if (comment3 != null) {
                                    bundle3.putInt("commenttype", comment3.commentType);
                                }
                                FeedDetailComment feedDetailComment8 = FeedDetailComment.this;
                                feedDetailComment8.onFeedElementClickListener.onClick(view, FeedElement.MORE_REPLY, feedDetailComment8.position, bundle3);
                            } else {
                                g gVar4 = feedDetailComment4.onFeedElementClickListener;
                                FeedElement feedElement3 = FeedElement.REPLY_ITEM;
                                int i19 = feedDetailComment4.position;
                                gVar4.onClick(view, feedElement3, i19, Integer.valueOf(i19));
                                if ("com.qzone.detail.ui.activity.QzoneCommentDetailActivity".equals(FeedDetailComment.this.mContext.getClass().getName())) {
                                    i.H().f(209, 3, 10);
                                }
                            }
                        }
                    } else {
                        Bundle bundle4 = new Bundle();
                        bundle4.putInt("position", FeedDetailComment.this.position);
                        Comment comment4 = FeedDetailComment.this.comment;
                        if (comment4 != null) {
                            bundle4.putInt("commenttype", comment4.commentType);
                        }
                        FeedDetailComment feedDetailComment9 = FeedDetailComment.this;
                        feedDetailComment9.onFeedElementClickListener.onClick(feedDetailComment9.commentContent, FeedElement.REPLY_BUTTON, 0, bundle4);
                        if ("com.qzone.detail.ui.activity.QzoneCommentDetailActivity".equals(FeedDetailComment.this.mContext.getClass().getName())) {
                            i.H().f(209, 3, 8);
                        }
                    }
                } else {
                    FeedDetailComment feedDetailComment10 = FeedDetailComment.this;
                    User user = feedDetailComment10.commentUser;
                    if (user != null) {
                        int i26 = user.from;
                        if ("com.qzone.detail.ui.activity.QzoneCommentDetailActivity".equals(feedDetailComment10.mContext.getClass().getName())) {
                            if (id5 == j.O(2250)) {
                                i.H().f(209, 3, 2);
                            } else {
                                i.H().f(209, 3, 3);
                            }
                        }
                        FeedDetailComment feedDetailComment11 = FeedDetailComment.this;
                        feedDetailComment11.onFeedElementClickListener.onClick(null, FeedElement.FRIEND_NICKNAME, 0, feedDetailComment11.commentUser);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mOnCellClickListener = new TextCellLayout.OnCellClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailComment.5
            @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
            public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
                return false;
            }

            @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
            public void onClick(TextCell textCell, View view) {
                if (textCell == null) {
                    return;
                }
                try {
                    if (textCell instanceof UserNameCell) {
                        FeedDetailComment.this.onFeedElementClickListener.onClick(null, FeedElement.FRIEND_NICKNAME, 0, textCell.getUin());
                        return;
                    }
                    if (textCell instanceof UrlCell) {
                        FeedDetailComment.this.openUrl(((UrlCell) textCell).getUrl(), textCell.text, ((UrlCell) textCell).post);
                        return;
                    }
                    if (textCell.getType() == 8) {
                        int id5 = (view.getId() / 10000) - 1;
                        int id6 = view.getId();
                        int i17 = FeedDetailComment.this.position;
                        int i18 = (id6 - ((i17 + 1) * 10000)) - 1;
                        if (id5 != i17 || i18 < 0) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", FeedDetailComment.this.position);
                        bundle.putInt("delete_enable", 1);
                        bundle.putInt("reply_pos", i18);
                        FeedDetailComment.this.onFeedElementClickListener.onClick(view, FeedElement.REPLY_BUTTON, 0, bundle);
                        return;
                    }
                    if (textCell.getType() == 10) {
                        FeedDetailComment.this.onFeedElementClickListener.onClick(view, FeedElement.OPEN_MORE_COMMENT, 0, Float.valueOf(textCell.lastClickEvent.getRawY() - textCell.maxCommentHeight));
                        return;
                    }
                    if (textCell instanceof ComboNetImageCell) {
                        ComboNetImageCell comboNetImageCell = (ComboNetImageCell) textCell;
                        User user = FeedDetailComment.this.commentUser;
                        if (user != null) {
                            comboNetImageCell.setUin(Long.valueOf(user.uin));
                            comboNetImageCell.setNickname(FeedDetailComment.this.commentUser.nickName);
                        }
                        FeedDetailComment.this.onFeedElementClickListener.onClick(view, FeedElement.COMMENT_POKE_COMBO, 0, comboNetImageCell);
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.mContext = context;
        this.position = i3;
        this.mAvatarSize = i16;
        this.onFeedElementClickListener = gVar;
        this.isUsePictureViewerLayout = z17;
        if (!z16) {
            initView();
        }
        bindEvents();
        if (z17) {
            this.nickNameColor = j.c(31);
        } else {
            this.nickNameColor = j.I();
        }
    }

    private boolean isClickComment(Comment comment) {
        String str;
        User user;
        if (comment == null || (str = comment.commentid) == null || !str.equals(TextCellLayout.getJumpCmtId()) || !TextUtils.isEmpty(TextCellLayout.getJumpRepId())) {
            return false;
        }
        if (TextUtils.isEmpty(TextCellLayout.getClickSummary())) {
            return true;
        }
        if (comment.comment.equals(TextCellLayout.getClickSummary())) {
            return TextCellLayout.getClickSummaryUin() == 0 || (user = comment.user) == null || user.uin == TextCellLayout.getClickSummaryUin();
        }
        return false;
    }

    public void setUser(User user) {
        if (user == null) {
            return;
        }
        this.commentUser = user;
        int i3 = user.from;
        if (i3 == 0 || i3 == 1) {
            setAvatar(user.uin);
        } else if (i3 == 2) {
            setAvatar(user.logo);
        }
        setNickName(user.nickName);
    }

    private void setTextEffect(CellTextView cellTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            cellTextView.setShadowLayer(0, 0, 0, 0);
            cellTextView.setTextColorAnimation(null, 0);
            cellTextView.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            cellTextView.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            cellTextView.setShadowLayer(com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowBlurRadius), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetX), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            cellTextView.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            cellTextView.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            cellTextView.setTextColorAnimation(null, 0);
        }
        if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
            int size2 = superFontInfo.vecGradientColor.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
            }
            int size3 = superFontInfo.vecGradientPosition.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = superFontInfo.iGradientDirection;
            if (i18 != 0) {
                if (i18 == 1) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i18 == 2) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else if (i18 == 3) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
            }
            cellTextView.setGradientColor(iArr, fArr, orientation);
            return;
        }
        cellTextView.setGradientColor(null, null, null);
    }

    public void setContent(Comment comment, boolean z16) {
        setContent(comment);
        if (z16) {
            getView().setBackgroundResource(j.h(22));
        } else {
            getView().setBackgroundResource(0);
        }
        this.commentContent.setBackgroundResource(j.h(716));
    }

    public void setReplyContent(Reply reply, boolean z16) {
        setReplyContent(reply);
        if (z16) {
            getView().setBackgroundResource(j.h(22));
        } else {
            getView().setBackgroundResource(0);
        }
        this.commentContent.setBackgroundResource(j.h(716));
    }

    public void setReply(List<Reply> list) {
        setReply(list, "", false, false, 0);
    }
}
