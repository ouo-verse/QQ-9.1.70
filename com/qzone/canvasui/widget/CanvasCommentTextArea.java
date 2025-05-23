package com.qzone.canvasui.widget;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.d;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.CommentTextArea;
import com.qzone.module.feedcomponent.ui.DrawPicArea;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import com.tencent.mobileqq.mini.qbox.QBoxConfProcessor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasCommentTextArea extends DittoArea implements SubArea.ViewHost, DittoTextAreaCompat {
    private static final String DEFAULT_MAX_PRAISE_COUNT = "99+";
    private static final int DISPLAY_MAX_PRAISE_COUNT = 99;
    public static final int DOUBLE_CLICKED_TIME = 200;
    ViewArea.OnAreaClickedListener areaClickListener;
    ViewArea.OnAreaLongClickedListener areaLongClickListener;
    private CommentTextArea commentTextArea;
    private boolean isClickPraise;
    private boolean isClicked;
    public boolean isDoubleClick;
    private AlarmTask mAlarmTask;
    private Comment mComment;
    private DrawPicArea mPraiseButtonArea;
    private SubAreaShell mPraiseButtonShell;
    private FeedTextArea mPraiseCountArea;
    private SubAreaShell mPraiseCountShell;
    private Reply mReply;
    private int offsetX;
    private AlarmTask.OnAlarmListener onAlarmListener;
    Paint paint;
    private static final Drawable PRAISE_DRAWABLE = j.g(QBoxConfProcessor.TASK_TYPE_ID);
    private static final Drawable CANCEL_PRAISE_DRAWABLE = j.g(705);
    private static final int DRAWABLE_SIZE = AreaManager.dp16;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class LongListener implements ViewArea.OnAreaLongClickedListener {
        WeakReference<CanvasCommentTextArea> weakThis;

        public LongListener(CanvasCommentTextArea canvasCommentTextArea) {
            this.weakThis = new WeakReference<>(canvasCommentTextArea);
        }

        @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaLongClickedListener
        public void onLongClicked(ViewArea viewArea) {
            WeakReference<CanvasCommentTextArea> weakReference = this.weakThis;
            CanvasCommentTextArea canvasCommentTextArea = weakReference == null ? null : weakReference.get();
            if (canvasCommentTextArea == null || canvasCommentTextArea.longClickListener == null || !canvasCommentTextArea.isReal()) {
                return;
            }
            canvasCommentTextArea.longClickListener.onLongClick(canvasCommentTextArea, null, null);
        }
    }

    public CanvasCommentTextArea(DittoHost dittoHost) {
        super(dittoHost);
        this.isClickPraise = false;
        this.isClicked = false;
        this.isDoubleClick = false;
        this.areaClickListener = new ViewArea.OnAreaClickedListener() { // from class: com.qzone.canvasui.widget.CanvasCommentTextArea.1
            @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
            public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
                if (CanvasCommentTextArea.this.mComment != null && CanvasCommentTextArea.this.mComment.isliked) {
                    CanvasCommentTextArea canvasCommentTextArea = CanvasCommentTextArea.this;
                    if (canvasCommentTextArea.isDoubleClick) {
                        canvasCommentTextArea.isDoubleClick = false;
                        return;
                    }
                }
                CanvasCommentTextArea canvasCommentTextArea2 = CanvasCommentTextArea.this;
                if (canvasCommentTextArea2.clickListener == null || !canvasCommentTextArea2.isReal()) {
                    return;
                }
                CanvasCommentTextArea canvasCommentTextArea3 = CanvasCommentTextArea.this;
                canvasCommentTextArea3.clickListener.onClick(canvasCommentTextArea3, textCell != null ? textCell.lastClickEvent : null, textCell);
            }
        };
        this.areaLongClickListener = new LongListener(this);
        this.paint = new Paint();
        this.onAlarmListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.canvasui.widget.CanvasCommentTextArea.3
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (alarmTask != null) {
                    CanvasCommentTextArea.this.isClicked = false;
                    CanvasCommentTextArea.this.isClickPraise = false;
                    if (CanvasCommentTextArea.this.commentTextArea == null || alarmTask.mEvent == null) {
                        return;
                    }
                    CommentTextArea commentTextArea = CanvasCommentTextArea.this.commentTextArea;
                    MotionEvent motionEvent = alarmTask.mEvent;
                    CanvasCommentTextArea canvasCommentTextArea = CanvasCommentTextArea.this;
                    commentTextArea.onTouchEvent(motionEvent, canvasCommentTextArea.areaClickListener, canvasCommentTextArea.longClickListener != null);
                }
            }
        };
    }

    private void checkDoubleClickEvent(MotionEvent motionEvent) {
        if (this.mAlarmTask == null) {
            this.mAlarmTask = new AlarmTask();
        }
        AlarmTask alarmTask = this.mAlarmTask;
        alarmTask.mEvent = motionEvent;
        alarmTask.cancelAlarm();
        this.mAlarmTask.setAlarmListener(this.onAlarmListener);
        this.mAlarmTask.setTriggerTime(200L);
    }

    private boolean isBarrageEffectComment() {
        Map<String, byte[]> map;
        Comment comment = this.mComment;
        return (comment == null || (map = comment.bybass_extendInfo) == null || map.get(UNIVERSAL_MALL_QUAL.value) == null) ? false : true;
    }

    private boolean isClickPraiseButton(float f16, float f17) {
        if (this.mPraiseButtonShell == null || this.mPraiseCountShell == null) {
            return false;
        }
        if (!isBarrageEffectComment()) {
            return f16 >= ((float) this.mPraiseButtonShell.getLeft()) && f16 <= ((float) this.mPraiseCountShell.getRight()) && f17 > ((float) AreaManager.f48750dp1) && f17 < ((float) (this.mPraiseButtonShell.getBottom() + AreaManager.f48751dp2));
        }
        if (f16 < this.mPraiseButtonShell.getLeft() || f16 > this.mPraiseCountShell.getRight()) {
            return false;
        }
        int i3 = AreaManager.f48752dp3;
        return f17 >= ((float) i3) && f17 <= ((float) (getHeight() - i3));
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        return this.mHost.getContainerView();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public Object getData() {
        ClickedComment clickedComment = (ClickedComment) this.commentTextArea.getData();
        clickedComment.setComment(this.mComment);
        clickedComment.setReply(this.mReply);
        return clickedComment;
    }

    @Override // com.tencent.ditto.widget.DittoTextAreaCompat
    public String getText() {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            return commentTextArea.getText();
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.canvasui.widget.CanvasCommentTextArea.2
            @Override // java.lang.Runnable
            public void run() {
                CanvasCommentTextArea.this.invalidate();
            }
        }, j3);
    }

    public boolean isClickPraise() {
        return this.isClickPraise;
    }

    public boolean isReal() {
        if (this.mReply != null) {
            return !r0.isFake;
        }
        if (this.mComment != null) {
            return !r0.isFake;
        }
        return false;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        int i3;
        this.commentTextArea.draw(canvas, null);
        if (this.mPraiseButtonShell == null || this.mPraiseCountShell == null) {
            return;
        }
        if (isBarrageEffectComment()) {
            i3 = (this.commentTextArea.getHeight() - this.mPraiseButtonShell.getHeight()) / 2;
        } else {
            i3 = AreaManager.f48750dp1;
        }
        canvas.save();
        float f16 = i3;
        canvas.translate(this.offsetX, f16);
        this.mPraiseButtonShell.draw(canvas, this.paint);
        canvas.restore();
        canvas.save();
        canvas.translate(this.offsetX + AreaManager.dp20, f16);
        this.mPraiseCountShell.draw(canvas, this.paint);
        canvas.restore();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        if (this.mComment == null) {
            setMeasuredDimension(0, 0);
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        SubAreaShell subAreaShell = this.mPraiseButtonShell;
        if (subAreaShell != null) {
            int left = subAreaShell.getLeft() - AreaManager.dp22;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(left, mode);
            if (this.commentTextArea.getWidth() > left) {
                this.commentTextArea.measure(makeMeasureSpec, i16);
            }
        } else if (this.commentTextArea.getWidth() > size || this.commentTextArea.isNeedUpdate()) {
            this.commentTextArea.measure(i3, i16);
        }
        FeedTextArea feedTextArea = this.mPraiseCountArea;
        if (feedTextArea != null) {
            feedTextArea.measure(-2, -2);
        }
        if (this.mPraiseButtonShell != null) {
            setMeasuredDimension(size, this.commentTextArea.getHeight());
        } else {
            setMeasuredDimension(this.commentTextArea.getWidth(), this.commentTextArea.getHeight());
        }
    }

    public void onRecycled() {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.onRecycled();
        }
    }

    public void onStateIdle() {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.onStateIdle();
        }
    }

    public void onStateScrolling() {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.onStateScrolling();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.commentTextArea != null) {
            if (motionEvent.getAction() == 1) {
                if (this.mPraiseButtonShell != null && isClickPraiseButton(motionEvent.getX(), motionEvent.getY())) {
                    this.isClickPraise = true;
                    this.isDoubleClick = false;
                    return this.commentTextArea.onTouchEvent(motionEvent, this.areaClickListener, this.longClickListener != null);
                }
                if (!this.isClicked) {
                    checkDoubleClickEvent(motionEvent);
                    this.isClicked = true;
                } else {
                    AlarmTask alarmTask = this.mAlarmTask;
                    if (alarmTask != null) {
                        alarmTask.cancelAlarm();
                        this.isClicked = false;
                        this.isClickPraise = true;
                        this.isDoubleClick = true;
                        this.commentTextArea.onTouchEvent(motionEvent, this.areaClickListener, this.longClickListener != null);
                    }
                }
                return true;
            }
            return this.commentTextArea.onTouchEvent(motionEvent, this.areaClickListener, this.longClickListener != null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        if (this.mPraiseCountShell != null) {
            this.mPraiseCountShell = null;
        }
        if (this.mPraiseButtonShell != null) {
            this.mPraiseButtonShell = null;
        }
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.reset();
        }
    }

    public void setColorBackground(int i3) {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.setColorBackground(i3);
        }
    }

    public void setComment(Comment comment, int i3) {
        int i16;
        String valueOf;
        reset();
        this.mComment = comment;
        if (comment == null) {
            return;
        }
        Integer generateCommentCacheKey = generateCommentCacheKey(comment);
        CommentTextArea commentTextArea = (CommentTextArea) getAreaCache(generateCommentCacheKey, CommentTextArea.class);
        this.commentTextArea = commentTextArea;
        if (commentTextArea == null) {
            CommentTextArea commentTextArea2 = (CommentTextArea) AreaManager.getInstance().getCommentArea(comment, i3, comment.uniKey);
            this.commentTextArea = commentTextArea2;
            addAreaCache(generateCommentCacheKey, commentTextArea2);
        }
        CommentTextArea commentTextArea3 = this.commentTextArea;
        commentTextArea3.commentIndex = i3;
        commentTextArea3.setViewHost(this);
        this.commentTextArea.longClickedListener = this.areaLongClickListener;
        if (i.H().S0()) {
            String str = "";
            if (comment.user != null) {
                str = "" + comment.user.nickName + "\uff1a";
            }
            setContentDescription(d.t(d.r(str + comment.comment)));
        }
        if (!comment.needShowPraiseButton || (i16 = comment.likeNum) <= 0) {
            return;
        }
        if (i16 > 99) {
            this.offsetX = FeedGlobalEnv.g().getScreenWidth() - AreaManager.dp60;
            valueOf = DEFAULT_MAX_PRAISE_COUNT;
        } else {
            valueOf = String.valueOf(i16);
            this.offsetX = FeedGlobalEnv.g().getScreenWidth() - AreaManager.dp53;
        }
        DrawPicArea drawPicArea = new DrawPicArea();
        this.mPraiseButtonArea = drawPicArea;
        if (comment.isliked) {
            Drawable drawable = CANCEL_PRAISE_DRAWABLE;
            int i17 = DRAWABLE_SIZE;
            drawPicArea.setData(drawable, i17, i17);
        } else {
            Drawable drawable2 = PRAISE_DRAWABLE;
            int i18 = DRAWABLE_SIZE;
            drawPicArea.setData(drawable2, i18, i18);
        }
        this.mPraiseButtonArea.setViewHost(this);
        SubAreaShell obtain = SubAreaShell.obtain(this.mPraiseButtonArea);
        this.mPraiseButtonShell = obtain;
        obtain.setLeft(this.offsetX);
        FeedTextArea feedTextArea = new FeedTextArea(0);
        this.mPraiseCountArea = feedTextArea;
        feedTextArea.setLineSpace(0.0f);
        this.mPraiseCountArea.setTextSize(12.0f);
        if (comment.isliked) {
            this.mPraiseCountArea.setTextColor(Color.parseColor("#FFC100"));
        } else {
            this.mPraiseCountArea.setTextColor(Color.parseColor("#9E9E9E"));
        }
        this.mPraiseCountArea.setTextGravity(17);
        this.mPraiseCountArea.setData(valueOf, 0);
        this.mPraiseCountArea.setViewHost(this);
        SubAreaShell obtain2 = SubAreaShell.obtain(this.mPraiseCountArea);
        this.mPraiseCountShell = obtain2;
        obtain2.setLeft(this.offsetX + AreaManager.dp20);
        this.mPraiseCountShell.setPaddingTop(AreaManager.f48751dp2);
    }

    public void setLinkColorBackground(int i3) {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.setLinkColorBackground(i3);
        }
    }

    public void setTextColor(int i3, int i16) {
        CommentTextArea commentTextArea = this.commentTextArea;
        if (commentTextArea != null) {
            commentTextArea.setLinkColor(i3);
            this.commentTextArea.setTextColor(i16);
        }
    }

    private Integer generateCommentCacheKey(Comment comment) {
        if (comment == null) {
            return -1;
        }
        int screenWidth = FeedGlobalEnv.g().getScreenWidth();
        if (comment.commentAreaCacheKey.intValue() != -1) {
            if (screenWidth == comment.screenWidth) {
                return comment.commentAreaCacheKey;
            }
            DittoArea.removeAreaCache(comment.commentAreaCacheKey);
        }
        comment.screenWidth = screenWidth;
        StringBuilder sb5 = new StringBuilder();
        Object obj = comment.feedKey;
        if (obj == null) {
            obj = UUID.randomUUID();
        }
        sb5.append(obj);
        sb5.append(comment.commentid);
        sb5.append("_");
        sb5.append(screenWidth);
        return Integer.valueOf(sb5.toString().hashCode());
    }

    public void setReply(Comment comment, Reply reply, int i3, int i16) {
        int i17;
        String valueOf;
        if (reply == null) {
            return;
        }
        this.mComment = comment;
        this.mReply = reply;
        Integer generateReplyCacheKey = generateReplyCacheKey(comment, reply);
        CommentTextArea commentTextArea = (CommentTextArea) getAreaCache(generateReplyCacheKey, CommentTextArea.class);
        this.commentTextArea = commentTextArea;
        if (commentTextArea == null) {
            CommentTextArea commentTextArea2 = (CommentTextArea) AreaManager.getInstance().getReplyArea(comment, reply, i3, i16, reply.uinKey);
            this.commentTextArea = commentTextArea2;
            addAreaCache(generateReplyCacheKey, commentTextArea2);
        }
        CommentTextArea commentTextArea3 = this.commentTextArea;
        commentTextArea3.commentIndex = i3;
        commentTextArea3.replyIndex = i16;
        commentTextArea3.setViewHost(this);
        this.commentTextArea.longClickedListener = this.areaLongClickListener;
        if (i.H().S0()) {
            String str = "";
            if (reply.user != null) {
                str = "" + reply.user.nickName;
            }
            User user = reply.targetUser;
            if (user != null && user.uin > 0 && !TextUtils.isEmpty(user.nickName)) {
                str = str + "\u56de\u590d" + reply.targetUser.nickName;
            }
            setContentDescription(d.t(d.r(str + "\uff1a" + reply.content)));
        }
        if (!reply.showLikeIcon || (i17 = reply.likeNum) <= 0) {
            return;
        }
        if (i17 > 99) {
            this.offsetX = FeedGlobalEnv.g().getScreenWidth() - AreaManager.dp60;
            valueOf = DEFAULT_MAX_PRAISE_COUNT;
        } else {
            valueOf = String.valueOf(i17);
            this.offsetX = FeedGlobalEnv.g().getScreenWidth() - AreaManager.dp53;
        }
        DrawPicArea drawPicArea = new DrawPicArea();
        this.mPraiseButtonArea = drawPicArea;
        if (reply.isliked) {
            Drawable drawable = CANCEL_PRAISE_DRAWABLE;
            int i18 = DRAWABLE_SIZE;
            drawPicArea.setData(drawable, i18, i18);
        } else {
            Drawable drawable2 = PRAISE_DRAWABLE;
            int i19 = DRAWABLE_SIZE;
            drawPicArea.setData(drawable2, i19, i19);
        }
        this.mPraiseButtonArea.setViewHost(this);
        SubAreaShell obtain = SubAreaShell.obtain(this.mPraiseButtonArea);
        this.mPraiseButtonShell = obtain;
        obtain.setLeft(this.offsetX);
        FeedTextArea feedTextArea = new FeedTextArea(0);
        this.mPraiseCountArea = feedTextArea;
        feedTextArea.setLineSpace(0.0f);
        this.mPraiseCountArea.setTextSize(12.0f);
        if (reply.isliked) {
            this.mPraiseCountArea.setTextColor(Color.parseColor("#FFC100"));
        } else {
            this.mPraiseCountArea.setTextColor(Color.parseColor("#9E9E9E"));
        }
        this.mPraiseCountArea.setTextGravity(17);
        this.mPraiseCountArea.setData(valueOf, 0);
        this.mPraiseCountArea.setViewHost(this);
        SubAreaShell obtain2 = SubAreaShell.obtain(this.mPraiseCountArea);
        this.mPraiseCountShell = obtain2;
        obtain2.setLeft(this.offsetX + AreaManager.dp20);
        this.mPraiseCountShell.setPaddingTop(AreaManager.f48751dp2);
    }

    private Integer generateReplyCacheKey(Comment comment, Reply reply) {
        String str;
        if (comment != null && reply != null) {
            int screenWidth = FeedGlobalEnv.g().getScreenWidth();
            if (reply.replyAreaCacheKey.intValue() != -1) {
                if (screenWidth == reply.screenWidth) {
                    return reply.replyAreaCacheKey;
                }
                DittoArea.removeAreaCache(reply.replyAreaCacheKey);
            }
            reply.screenWidth = screenWidth;
            String str2 = "";
            if (comment.user == null) {
                str = "";
            } else {
                str = "_comment" + comment.user.nickName;
            }
            if (reply.user != null) {
                str2 = "_reply" + reply.user.nickName + "_" + reply.targetUser.nickName + "_" + reply.content + "_" + reply.uinKey;
            }
            return Integer.valueOf(("canvas_" + comment.uniKey + str + str2 + "_" + screenWidth).hashCode());
        }
        return -1;
    }

    public CanvasCommentTextArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.isClickPraise = false;
        this.isClicked = false;
        this.isDoubleClick = false;
        this.areaClickListener = new ViewArea.OnAreaClickedListener() { // from class: com.qzone.canvasui.widget.CanvasCommentTextArea.1
            @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
            public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
                if (CanvasCommentTextArea.this.mComment != null && CanvasCommentTextArea.this.mComment.isliked) {
                    CanvasCommentTextArea canvasCommentTextArea = CanvasCommentTextArea.this;
                    if (canvasCommentTextArea.isDoubleClick) {
                        canvasCommentTextArea.isDoubleClick = false;
                        return;
                    }
                }
                CanvasCommentTextArea canvasCommentTextArea2 = CanvasCommentTextArea.this;
                if (canvasCommentTextArea2.clickListener == null || !canvasCommentTextArea2.isReal()) {
                    return;
                }
                CanvasCommentTextArea canvasCommentTextArea3 = CanvasCommentTextArea.this;
                canvasCommentTextArea3.clickListener.onClick(canvasCommentTextArea3, textCell != null ? textCell.lastClickEvent : null, textCell);
            }
        };
        this.areaLongClickListener = new LongListener(this);
        this.paint = new Paint();
        this.onAlarmListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.canvasui.widget.CanvasCommentTextArea.3
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (alarmTask != null) {
                    CanvasCommentTextArea.this.isClicked = false;
                    CanvasCommentTextArea.this.isClickPraise = false;
                    if (CanvasCommentTextArea.this.commentTextArea == null || alarmTask.mEvent == null) {
                        return;
                    }
                    CommentTextArea commentTextArea = CanvasCommentTextArea.this.commentTextArea;
                    MotionEvent motionEvent = alarmTask.mEvent;
                    CanvasCommentTextArea canvasCommentTextArea = CanvasCommentTextArea.this;
                    commentTextArea.onTouchEvent(motionEvent, canvasCommentTextArea.areaClickListener, canvasCommentTextArea.longClickListener != null);
                }
            }
        };
    }
}
