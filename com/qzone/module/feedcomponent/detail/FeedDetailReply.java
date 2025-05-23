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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.b;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.module.feedcomponent.detail.FeedDetailComment;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.module.feedcomponent.util.MaxCommentLineConfig;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.proxy.feedcomponent.ui.detail.c;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailReply extends c {
    public static final int BEFORE_DELETE_COMMENT = 153;
    public static final int BEFORE_REPLY = 152;
    public static final int COMMENT_CLICK = 408;
    public static final int COMMENT_LONG_CLICK = 406;
    public static final int COMMENT_TYPE = 1;
    public static final int DELETE_ENABLE = 1;
    public static final int PIC_LONG_CLICK = 512;
    public static final int REPLY_CLICK = 409;
    public static final int REPLY_LONG_CLICK = 407;
    public static final int REPLY_POS = 10000;
    protected static String REPLY_STR = "\u56de\u590d";
    public static final int REPLY_TYPE = 2;
    private static final String TAG = "FeedDetailReply";
    private Comment comment;
    CellTextView commentAuthor;
    CellTextView commentContent;
    AvatarImageView commentImgUserIcon;
    private View commentItemSeparator;
    CellTextView commentMoreReply;
    int commentPosition;
    TextView commentPraiseCount;
    TextView commentPublishDesciption;
    TextView commentReplyButton;
    LinearLayout commentReplyContainer;
    User commentUser;
    boolean contentClickEnable;
    Drawable defaultLikeDrawable;
    boolean isReplyVisible;
    long lastLikeClickTime;
    TextView likeTextView;
    int linkColor;
    boolean longClickEnable;
    int mAvatarSize;
    private int mCommentType;
    Context mContext;
    boolean mIsCommentImage;
    TextCellLayout.OnCellClickListener mOnCellClickListener;
    int mPicSize;
    int mReplyAvatarSize;
    FeedDetailComment.ViewHolder mViewHolder;
    int nickNameColor;
    View.OnClickListener onButtonClick;
    g onFeedElementClickListener;
    View.OnLongClickListener onLongClick;
    LinearLayout publishTimeAndMoreReplyContainer;
    View publishTimeAndMoreReplySeparatorDot;
    private Reply reply;
    private View replyDetailHeaderSeparator;
    int replyPosition;
    SuperLikeView superLikeView;
    private static String likeText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentLike", "\u89c9\u5f97\u5f88\u8d5e");
    private static String soOnText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentLikeSoOn", "\u7b49");
    private static String manyLikeText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentManyLike", "\u4e2a\u4eba\u89c9\u5f97\u5f88\u8d5e");

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.detail.FeedDetailReply$5, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass5 {
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
    public class OnEventBack implements SuperLikeView.OnEventBack {
        OnEventBack() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
        public void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
            if (AnonymousClass5.$SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[superLikeAnimator$Event.ordinal()] != 1) {
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

    public FeedDetailReply(Context context, int i3, int i16, int i17, g gVar) {
        super(context);
        this.mReplyAvatarSize = AreaConst.dp22;
        this.mPicSize = b.f41871r;
        this.longClickEnable = true;
        this.contentClickEnable = true;
        this.mCommentType = 2;
        this.onLongClick = new View.OnLongClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailReply.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                EventCollector.getInstance().onViewLongClickedBefore(view);
                FeedDetailReply feedDetailReply = FeedDetailReply.this;
                if (feedDetailReply.onFeedElementClickListener != null && feedDetailReply.longClickEnable) {
                    if (view.getId() == j.O(2253) && FeedDetailReply.this.mCommentType != 2) {
                        FeedDetailReply.this.onFeedElementClickListener.onClick(view, FeedElement.COMMENT_LONG_CLICK, 0, null);
                    } else {
                        FeedDetailReply.this.onFeedElementClickListener.onClick(view, FeedElement.REPLY_LONG_CLICK, 0, null);
                    }
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return true;
            }
        };
        this.onButtonClick = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailReply.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int id5 = view.getId();
                if (id5 != j.O(2250) && id5 != j.O(2251)) {
                    if (id5 == j.O(2253)) {
                        FeedDetailReply feedDetailReply = FeedDetailReply.this;
                        if (feedDetailReply.commentUser != null) {
                            if (feedDetailReply.mCommentType == 2) {
                                FeedDetailReply feedDetailReply2 = FeedDetailReply.this;
                                g gVar2 = feedDetailReply2.onFeedElementClickListener;
                                FeedElement feedElement = FeedElement.REPLY_ITEM;
                                int i18 = feedDetailReply2.commentPosition;
                                gVar2.onClick(view, feedElement, i18, Integer.valueOf(i18));
                            } else {
                                FeedDetailReply feedDetailReply3 = FeedDetailReply.this;
                                g gVar3 = feedDetailReply3.onFeedElementClickListener;
                                FeedElement feedElement2 = FeedElement.COMMENT_ITEM;
                                int i19 = feedDetailReply3.commentPosition;
                                gVar3.onClick(view, feedElement2, i19, Integer.valueOf(i19));
                            }
                        }
                    } else if (id5 == j.O(2255)) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", FeedDetailReply.this.commentPosition);
                        bundle.putInt("reply_pos", FeedDetailReply.this.replyPosition);
                        FeedDetailReply feedDetailReply4 = FeedDetailReply.this;
                        feedDetailReply4.onFeedElementClickListener.onClick(feedDetailReply4.commentContent, FeedElement.REPLY_BUTTON, 0, bundle);
                    } else {
                        FeedDetailReply feedDetailReply5 = FeedDetailReply.this;
                        if (view == feedDetailReply5.superLikeView) {
                            if (feedDetailReply5.canLikeClick()) {
                                FeedDetailReply.this.onPraiseViewClick();
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("position", FeedDetailReply.this.commentPosition);
                                bundle2.putInt("reply_pos", FeedDetailReply.this.replyPosition);
                                FeedDetailReply feedDetailReply6 = FeedDetailReply.this;
                                feedDetailReply6.onFeedElementClickListener.onClick(feedDetailReply6.superLikeView, FeedElement.REPLY_PRAISE_BUTTON, 0, bundle2);
                            }
                        } else {
                            CellTextView cellTextView = feedDetailReply5.commentMoreReply;
                            if (cellTextView != null && view == cellTextView) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putInt("position", FeedDetailReply.this.commentPosition);
                                FeedDetailReply feedDetailReply7 = FeedDetailReply.this;
                                feedDetailReply7.onFeedElementClickListener.onClick(view, FeedElement.MORE_REPLY, feedDetailReply7.commentPosition, bundle3);
                            } else if (cellTextView != null && view == cellTextView) {
                                Bundle bundle4 = new Bundle();
                                bundle4.putInt("position", FeedDetailReply.this.commentPosition);
                                FeedDetailReply feedDetailReply8 = FeedDetailReply.this;
                                feedDetailReply8.onFeedElementClickListener.onClick(view, FeedElement.MORE_REPLY, feedDetailReply8.commentPosition, bundle4);
                            } else {
                                g gVar4 = feedDetailReply5.onFeedElementClickListener;
                                FeedElement feedElement3 = FeedElement.REPLY_ITEM;
                                int i26 = feedDetailReply5.commentPosition;
                                gVar4.onClick(view, feedElement3, i26, Integer.valueOf(i26));
                            }
                        }
                    }
                } else if (FeedDetailReply.this.commentUser != null) {
                    if (id5 == j.O(2250)) {
                        i.H().f(209, 2, 1);
                    } else {
                        i.H().f(209, 2, 2);
                    }
                    FeedDetailReply feedDetailReply9 = FeedDetailReply.this;
                    feedDetailReply9.onFeedElementClickListener.onClick(null, FeedElement.FRIEND_NICKNAME, 0, feedDetailReply9.commentUser);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mOnCellClickListener = new TextCellLayout.OnCellClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailReply.3
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
                        FeedDetailReply.this.onFeedElementClickListener.onClick(null, FeedElement.FRIEND_NICKNAME, 0, textCell.getUin());
                    } else if (textCell instanceof UrlCell) {
                        FeedDetailReply.this.openUrl(((UrlCell) textCell).getUrl(), textCell.text, ((UrlCell) textCell).post);
                    } else if (textCell.getType() == 8) {
                        int id5 = (view.getId() / 10000) - 1;
                        int id6 = view.getId();
                        int i18 = FeedDetailReply.this.commentPosition;
                        int i19 = (id6 - ((i18 + 1) * 10000)) - 1;
                        if (id5 == i18 && i19 >= 0) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("position", FeedDetailReply.this.commentPosition);
                            bundle.putInt("delete_enable", 1);
                            bundle.putInt("reply_pos", i19);
                            FeedDetailReply.this.onFeedElementClickListener.onClick(view, FeedElement.REPLY_BUTTON, 0, bundle);
                        }
                    } else if (textCell.getType() == 10) {
                        FeedDetailReply.this.onFeedElementClickListener.onClick(view, FeedElement.OPEN_MORE_COMMENT, 0, Float.valueOf(textCell.lastClickEvent.getRawY() - textCell.maxCommentHeight));
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.mContext = context;
        this.commentPosition = i3;
        this.mAvatarSize = i17;
        this.onFeedElementClickListener = gVar;
        this.replyPosition = i16;
        initView();
        bindEvents();
        this.nickNameColor = j.I();
    }

    private void initUI() {
        ViewGroup.LayoutParams layoutParams;
        View view = getView();
        if (view == null) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), AreaConst.dp7_5);
        AvatarImageView avatarImageView = (AvatarImageView) view.findViewById(j.O(2250));
        this.commentImgUserIcon = avatarImageView;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) avatarImageView.getLayoutParams();
        layoutParams2.leftMargin = 0;
        this.commentImgUserIcon.setLayoutParams(layoutParams2);
        if (this.mAvatarSize > 0 && (layoutParams = this.commentImgUserIcon.getLayoutParams()) != null) {
            int i3 = this.mAvatarSize;
            layoutParams.height = i3;
            layoutParams.width = i3;
            this.commentImgUserIcon.setLayoutParams(layoutParams);
        }
        CellTextView cellTextView = (CellTextView) view.findViewById(j.O(2251));
        this.commentAuthor = cellTextView;
        cellTextView.setLongClickable(true);
        this.commentPublishDesciption = (TextView) view.findViewById(j.O(2252));
        this.commentContent = (CellTextView) view.findViewById(j.O(2253));
        this.commentReplyContainer = (LinearLayout) view.findViewById(j.O(2254));
        this.commentReplyButton = (TextView) view.findViewById(j.O(2839));
        View findViewById = view.findViewById(j.O(2255));
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.commentPraiseCount = (TextView) view.findViewById(j.O(2665));
        try {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName("\u6309\u94ae");
            this.commentReplyButton.onInitializeAccessibilityNodeInfo(obtain);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d(TAG, "err catched:", e16);
        }
        this.commentContent.setMaxCommentLine(MaxCommentLineConfig.MAX_COMMENT_LINE_DETAIL);
        this.commentContent.setClickable(true);
        this.commentAuthor.setTextBold(false);
        this.commentAuthor.setTextSize(FeedGlobalEnv.g().getSpValue(15.0f));
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
        this.publishTimeAndMoreReplySeparatorDot.setVisibility(0);
        View findViewById2 = view.findViewById(j.O(2815));
        if (findViewById2 != null) {
            ViewGroup.LayoutParams layoutParams3 = findViewById2.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams.rightMargin = 0;
                findViewById2.setLayoutParams(marginLayoutParams);
            }
        }
        View findViewById3 = view.findViewById(j.O(2817));
        if (findViewById3 != null) {
            ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams2.topMargin = AreaConst.dp6;
                findViewById3.setLayoutParams(marginLayoutParams2);
            }
        }
        ((ViewGroup.MarginLayoutParams) this.likeTextView.getLayoutParams()).leftMargin = AreaConst.f48747dp2;
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    void bindEvents() {
        AvatarImageView avatarImageView = this.commentImgUserIcon;
        if (avatarImageView != null) {
            avatarImageView.setOnClickListener(this.onButtonClick);
        }
        CellTextView cellTextView = this.commentAuthor;
        if (cellTextView != null) {
            cellTextView.setOnCellClickListener(this.mOnCellClickListener);
        }
        TextView textView = this.commentReplyButton;
        if (textView != null) {
            textView.setOnClickListener(this.onButtonClick);
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
        this.linkColor = j.I();
        setView(LayoutInflater.from(this.mContext).inflate(j.j(1654), (ViewGroup) null));
    }

    void onPraiseViewClick() {
        Animation loadAnimation;
        if (this.superLikeView.isSelected()) {
            this.superLikeView.setImageDrawable(this.defaultLikeDrawable);
            return;
        }
        this.superLikeView.setImageDrawable(this.defaultLikeDrawable);
        int b16 = j.b(4098);
        if (getContext() == null || (loadAnimation = AnimationUtils.loadAnimation(getContext(), b16)) == null) {
            return;
        }
        Log.d(TAG, "click: " + this.superLikeView + ", dis=" + this.reply.content);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailReply.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Animation loadAnimation2;
                Log.d(FeedDetailReply.TAG, "start, onAnimationEnd: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
                int b17 = j.b(4099);
                if (FeedDetailReply.this.getContext() == null || (loadAnimation2 = AnimationUtils.loadAnimation(FeedDetailReply.this.getContext(), b17)) == null) {
                    return;
                }
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailReply.4.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        Log.d(FeedDetailReply.TAG, "end, onAnimationEnd: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                        Log.d(FeedDetailReply.TAG, "end, onAnimationRepeat: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                        Log.d(FeedDetailReply.TAG, "end, onAnimationStart: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
                    }
                });
                FeedDetailReply.this.superLikeView.startAnimation(loadAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Log.d(FeedDetailReply.TAG, "start, onAnimationRepeat: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Log.d(FeedDetailReply.TAG, "start, onAnimationStart: " + FeedDetailReply.this.superLikeView + ", dis=" + FeedDetailReply.this.reply.content);
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

    public void setCommentDetailHeaderSeparator(boolean z16) {
        View view = this.replyDetailHeaderSeparator;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setCommentType(int i3) {
        this.mCommentType = i3;
    }

    public void setContent(Comment comment, Reply reply) {
        String sb5;
        User user;
        boolean isEmpty = TextUtils.isEmpty(reply.content);
        this.commentContent.setVisibility(isEmpty ? 8 : 0);
        this.commentContent.setTextColor(j.o());
        this.commentContent.setUrlColorRes(this.linkColor);
        this.commentContent.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        setTextEffect(this.commentContent, reply.getSuperFontInfo(false));
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setReply(reply);
        this.commentContent.setTag(clickedComment);
        StringBuilder sb6 = new StringBuilder();
        if (comment != null && (user = reply.targetUser) != null && comment.user.uin != user.uin) {
            sb6.append("{text:");
            sb6.append(REPLY_STR);
            sb6.append(",color:");
            sb6.append(Integer.toHexString(j.o()));
            sb6.append(",useDefaultFont:1,useSuperFont:0}");
            User user2 = reply.targetUser;
            if (user2.actiontype == 2) {
                sb6.append(DetailUtil.buildActionUrlString(user2.actionurl, user2.nickName));
            } else {
                sb6.append(DetailUtil.buildNicknameString(user2.uin, user2.nickName));
            }
            sb6.append("{text:");
            sb6.append("\uff1a");
            sb6.append(",color:");
            sb6.append(Integer.toHexString(j.o()));
            sb6.append(",useDefaultFont:1,useSuperFont:0}");
        }
        sb6.append(reply.content);
        CellTextView cellTextView = this.commentContent;
        String str = "";
        if (isEmpty) {
            sb5 = "";
        } else {
            sb5 = sb6.toString();
        }
        cellTextView.setRichText(sb5);
        this.commentContent.setDrawBackground(true);
        if (i.H().S0()) {
            CellTextView cellTextView2 = this.commentContent;
            if (!isEmpty) {
                str = DetailUtil.EmoCode2Text(reply.content);
            }
            cellTextView2.setContentDescription(str);
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

    public void setLongClickEnable(boolean z16) {
        this.longClickEnable = z16;
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
        if (this.commentPraiseCount != null) {
            Drawable g16 = j.g(816);
            if (g16 != null) {
                g16.setBounds(0, 0, ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f));
            }
            this.commentPraiseCount.setCompoundDrawables(g16, null, null, null);
            this.commentPraiseCount.setCompoundDrawablePadding(ViewUtils.dpToPx(2.5f));
            StringBuilder sb5 = new StringBuilder();
            long j06 = i.H().j0();
            if (z16) {
                sb5.append(i.H().k0());
                if (arrayList != null && arrayList.size() != 0) {
                    sb5.append("\u3001");
                } else {
                    sb5.append(likeText);
                    this.commentPraiseCount.setText(sb5.toString());
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
                        this.commentPraiseCount.setText(sb5.toString());
                        return;
                    }
                }
            }
        }
    }

    public void setPraiserVisible(boolean z16) {
        TextView textView = this.commentPraiseCount;
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

    public void setReplyData(Comment comment, Reply reply) {
        this.comment = comment;
        this.reply = reply;
        if (reply == null || this.commentAuthor == null) {
            return;
        }
        this.commentContent.setMaxCommentLine(MaxCommentLineConfig.MAX_COMMENT_LINE_DETAIL);
        String str = comment.commentid;
        if (str != null && reply.replyId != null && str.equals(TextCellLayout.getJumpCmtId())) {
            if (TextUtils.isEmpty(TextCellLayout.getJumpRepId()) && reply.content.equals(TextCellLayout.getClickSummary()) && (TextCellLayout.getClickSummaryUin() == 0 || reply.user == null || TextCellLayout.getClickSummaryUin() == reply.user.uin)) {
                TextCellLayout.setJumpRepId(reply.replyId);
            }
            if (reply.replyId.equals(TextCellLayout.getJumpRepId())) {
                this.commentContent.setMaxCommentLine(0);
                TextCellLayout.setJumpRep(this);
            }
        }
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setComment(comment);
        clickedComment.setReply(reply);
        this.commentContent.setTag(clickedComment);
        this.commentReplyButton.setTag(clickedComment);
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
        this.commentAuthor.resetSideDrawables();
    }

    public void setReplyEnable(boolean z16) {
        TextView textView = this.commentReplyButton;
        if (textView != null) {
            textView.setEnabled(z16);
        }
    }

    public void setReplyVisible(boolean z16) {
        this.isReplyVisible = z16;
        TextView textView = this.commentReplyButton;
        if (textView != null) {
            textView.setVisibility(z16 ? 0 : 8);
            this.publishTimeAndMoreReplySeparatorDot.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.c
    public void setView(View view) {
        super.setView(view);
        initUI();
        bindEvents();
    }

    void setAvatar(String str) {
        if (str != null) {
            this.commentImgUserIcon.loadAvatar(str);
        }
    }

    private void setTextEffect(CellTextView cellTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            cellTextView.setShadowLayer(0, 0, 0, 0);
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

    public void setUser(User user, User user2) {
        String EmoCode2Text;
        AvatarImageView avatarImageView;
        int i3;
        if (user == null || user2 == null) {
            return;
        }
        this.commentUser = user;
        int i16 = user.from;
        if (i16 == 0 || i16 == 1) {
            setAvatar(user.uin);
        } else if (i16 == 2) {
            setAvatar(user.logo);
        }
        User user3 = this.commentUser;
        if (user3 != null && (avatarImageView = this.commentImgUserIcon) != null) {
            byte b16 = user.vipShowType;
            if (b16 != 4 && b16 != 8) {
                i3 = AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
            } else {
                i3 = AsyncCanvasImageArea.DEFAULT_FAMOUS_ICON_HEIGHT;
            }
            UserMedal userMedal = user3.famousSpaceMedal;
            avatarImageView.setRightCornerIcon(userMedal != null ? userMedal.imageUrl : null, userMedal != null ? userMedal.picUrl : null, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        long j3 = user2.uin;
        long j16 = user.uin;
        if (j3 != j16) {
            if (user.actiontype == 2) {
                sb5.append(DetailUtil.buildActionUrlString(user.actionurl, user.nickName));
            } else {
                sb5.append(DetailUtil.buildNicknameString(j16, user.nickName));
            }
        }
        String sb6 = sb5.toString();
        this.commentAuthor.setRichText(sb6);
        if (i.H().S0()) {
            CellTextView cellTextView = this.commentAuthor;
            if (TextUtils.isEmpty(sb6)) {
                EmoCode2Text = "";
            } else {
                EmoCode2Text = DetailUtil.EmoCode2Text(user.nickName + REPLY_STR + user2.nickName);
            }
            cellTextView.setContentDescription(EmoCode2Text);
        }
    }
}
