package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.CanvasCommentTextArea;
import com.qzone.canvasui.widget.CanvasMultiGifArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.module.feedcomponent.util.CommentSpanData;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasCellCommentView extends QzoneCanvasAreaView implements DittoArea.ClickListener, DittoArea.LongClickListener {
    private static final int ITEM_MARGIN_BOTTOM = AreaConst.dp2_5;
    public static final int Mode_MoreComment = 257;
    public static final int Mode_MoreReply = 258;
    private static final String TAG = "CanvasCellCommentView";
    private DittoArea clickedArea;

    @DittoField("commentList")
    DittoListArea commList;
    protected BusinessFeedData feedData;
    private boolean isClicked;
    boolean isPassive;
    boolean isPraiseListIsVisibility;
    boolean isRedBonusListVisibility;
    boolean isSpaceRedBonusListVisibility;
    private DittoListArea.ListAreaAdapter mAdapter;
    private AlarmTask mAlarmTask;
    private CellCommentInfo mCellCommentInfo;
    private AlarmTask mCommentPraiseGuideAlarm;
    private CellCommentInfo.CommentState mCommentState;
    protected int mIndex;
    private boolean mLongClickedMultiGifArea;
    private int mMode;
    private AlarmTask.OnAlarmListener onAlarmListener;
    protected g onFeedElementClickListener;
    protected int photoMode;
    private int showCount;

    public CanvasCellCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.showCount = 0;
        this.mLongClickedMultiGifArea = false;
        this.isClicked = false;
        this.mAdapter = new DittoListArea.ListAreaAdapterWithSection() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView.1
            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public DittoArea getArea(DittoListArea dittoListArea, int i3, int i16) {
                try {
                    Comment comment = CanvasCellCommentView.this.mCellCommentInfo.commments.get(i3);
                    if (i16 == 0) {
                        return CanvasCellCommentView.this.getCommentArea(comment, i3);
                    }
                    if (i16 == 1 && CanvasCellCommentView.this.needShowPhoto(comment)) {
                        return CanvasCellCommentView.this.getPhotoArea(comment, i3, i16);
                    }
                    return CanvasCellCommentView.this.getReplyArea(comment, i3, i16 - (CanvasCellCommentView.this.needShowPhoto(comment) ? 2 : 1));
                } catch (Exception e16) {
                    b.d("Feed", "CanvasCellCommentView get comment area error. section=" + i3 + " row=" + i16, e16);
                    return null;
                }
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public int numberOfRows(DittoListArea dittoListArea, int i3) {
                if (CanvasCellCommentView.this.mCellCommentInfo == null || CanvasCellCommentView.this.mCellCommentInfo.commments == null || CanvasCellCommentView.this.mCellCommentInfo.commments.size() <= i3) {
                    return 0;
                }
                Comment comment = CanvasCellCommentView.this.mCellCommentInfo.commments.get(i3);
                int i16 = CanvasCellCommentView.this.needShowPhoto(comment) ? 2 : 1;
                List<Reply> list = comment.replies;
                if (list == null) {
                    return i16;
                }
                if (comment.replyNum == 0) {
                    comment.replyNum = list.size();
                }
                return i16 + CanvasCellCommentView.this.getReplyShowCount(comment);
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapterWithSection
            public int numberOfSections(DittoListArea dittoListArea) {
                return CanvasCellCommentView.this.showCount;
            }
        };
        this.onAlarmListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView.2
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (alarmTask != null) {
                    CanvasCellCommentView canvasCellCommentView = CanvasCellCommentView.this;
                    if (canvasCellCommentView.onFeedElementClickListener != null) {
                        canvasCellCommentView.isClicked = false;
                        CanvasCellCommentView canvasCellCommentView2 = CanvasCellCommentView.this;
                        canvasCellCommentView2.onFeedElementClickListener.onClick(canvasCellCommentView2, FeedElement.NOTHING, ((QzoneCanvasAreaView) canvasCellCommentView2).feedPosition, Integer.valueOf(((QzoneCanvasAreaView) CanvasCellCommentView.this).feedPosition));
                    }
                }
            }
        };
    }

    private void checkDoubleClickEvent(MotionEvent motionEvent) {
        if (this.mLongClickedMultiGifArea) {
            this.mLongClickedMultiGifArea = false;
            return;
        }
        if (this.mAlarmTask == null) {
            this.mAlarmTask = new AlarmTask();
        }
        AlarmTask alarmTask = this.mAlarmTask;
        alarmTask.mEvent = motionEvent;
        alarmTask.cancelAlarm();
        this.mAlarmTask.setAlarmListener(this.onAlarmListener);
        this.mAlarmTask.setTriggerTime(200L);
    }

    static int getFoldSize(int i3, int i16, boolean z16) {
        int i17;
        if (z16) {
            if (i3 == 258) {
                i17 = 3;
            } else {
                i17 = 30;
            }
        } else {
            i17 = i16;
        }
        if (i17 < i16) {
            return i17;
        }
        return i16;
    }

    private int getPicSize(Comment comment) {
        int i3;
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (arrayList != null && arrayList.size() > 0) {
            int i16 = comment.commentPictureItems.get(0).piccategory;
            if (i16 == 1) {
                i3 = com.qzone.adapter.feedcomponent.b.f41871r;
            } else if (i16 == 2) {
                if (comment.commentPictureItems.size() == 1) {
                    i3 = com.qzone.adapter.feedcomponent.b.f41872s;
                } else {
                    i3 = com.qzone.adapter.feedcomponent.b.f41873t;
                }
            } else {
                i3 = com.qzone.adapter.feedcomponent.b.f41872s;
            }
            return i3;
        }
        ArrayList<PictureItem> arrayList2 = comment.pictureItems;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return 0;
        }
        int i17 = comment.pictureItems.get(0).piccategory;
        if (i17 == 1) {
            return com.qzone.adapter.feedcomponent.b.f41871r;
        }
        if (i17 == 2) {
            if (comment.pictureItems.size() == 1) {
                return com.qzone.adapter.feedcomponent.b.f41872s;
            }
            return com.qzone.adapter.feedcomponent.b.f41873t;
        }
        return com.qzone.adapter.feedcomponent.b.f41872s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getReplyShowCount(Comment comment) {
        int size = comment.replies.size();
        int i3 = this.mMode;
        int size2 = comment.replies.size();
        CellCommentInfo cellCommentInfo = this.mCellCommentInfo;
        boolean z16 = false;
        if (cellCommentInfo != null && cellCommentInfo.moreCommentHasLoaded > 0) {
            z16 = true;
        }
        int foldSize = getFoldSize(i3, size2, z16);
        return (this.mCommentState != CellCommentInfo.CommentState.FOLDED || size <= foldSize) ? size : foldSize;
    }

    private boolean isClickPicCommentArea(MotionEvent motionEvent, int i3, int i16) {
        return motionEvent.getY() >= ((float) i3) && motionEvent.getY() <= ((float) i16);
    }

    public DittoArea getClickedArea() {
        return this.clickedArea;
    }

    protected CanvasCommentTextArea getCommentArea(Comment comment, int i3) {
        int i16;
        CanvasCommentTextArea canvasCommentTextArea = new CanvasCommentTextArea(this, new LayoutAttrSet());
        canvasCommentTextArea.getLayoutAttr().width = -1;
        canvasCommentTextArea.setComment(comment, i3);
        int i17 = this.showCount;
        if (i3 == i17) {
            if (this.mMode != 258 && i3 != i17) {
                i16 = AreaConst.f48746dp1;
            } else if (!this.isPraiseListIsVisibility && !this.isRedBonusListVisibility && !this.isSpaceRedBonusListVisibility) {
                i16 = AreaConst.dp1_5;
            }
            canvasCommentTextArea.setPadding(0, i16, 0, ITEM_MARGIN_BOTTOM);
            canvasCommentTextArea.longClickListener = this;
            canvasCommentTextArea.clickListener = this;
            canvasCommentTextArea.setTag(1);
            return canvasCommentTextArea;
        }
        i16 = 0;
        canvasCommentTextArea.setPadding(0, i16, 0, ITEM_MARGIN_BOTTOM);
        canvasCommentTextArea.longClickListener = this;
        canvasCommentTextArea.clickListener = this;
        canvasCommentTextArea.setTag(1);
        return canvasCommentTextArea;
    }

    protected CanvasMultiGifArea getPhotoArea(Comment comment, int i3, int i16) {
        int picSize = getPicSize(comment);
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.height = picSize;
        layoutAttrSet.mAttrs.put("singal_image_size", Integer.valueOf(picSize));
        CanvasMultiGifArea canvasMultiGifArea = new CanvasMultiGifArea(this, layoutAttrSet);
        ArrayList<PictureItem> arrayList = comment.pictureItems;
        if (arrayList == null) {
            arrayList = comment.commentPictureItems;
        }
        canvasMultiGifArea.setPicItemHeight(picSize);
        canvasMultiGifArea.setPicItemWidth(picSize);
        canvasMultiGifArea.setAttachedObject(comment);
        canvasMultiGifArea.setPictureItems(arrayList, this.feedData.isInterestMessageFeeds());
        canvasMultiGifArea.setMargin(0, 0, 0, 11);
        canvasMultiGifArea.clickListener = this;
        canvasMultiGifArea.longClickListener = this;
        canvasMultiGifArea.setTag(3);
        return canvasMultiGifArea;
    }

    protected CanvasCommentTextArea getReplyArea(Comment comment, int i3, int i16) {
        int size = (comment.replies.size() - getReplyShowCount(comment)) + i16;
        if (size >= comment.replies.size()) {
            return new CanvasCommentTextArea(this);
        }
        Reply reply = comment.replies.get(size);
        if (reply == null) {
            b.c("CANVASLOG", "reply is null");
        }
        CanvasCommentTextArea canvasCommentTextArea = new CanvasCommentTextArea(this, new LayoutAttrSet());
        canvasCommentTextArea.getLayoutAttr().width = -1;
        canvasCommentTextArea.setReply(comment, reply, i3, i16);
        canvasCommentTextArea.setPadding(0, 0, 0, ITEM_MARGIN_BOTTOM);
        canvasCommentTextArea.longClickListener = this;
        canvasCommentTextArea.clickListener = this;
        canvasCommentTextArea.setTag(2);
        return canvasCommentTextArea;
    }

    boolean needShowPhoto(Comment comment) {
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (arrayList != null && arrayList.size() > 0) {
            return picItemNotNull(comment.commentPictureItems);
        }
        ArrayList<PictureItem> arrayList2 = comment.pictureItems;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return false;
        }
        return picItemNotNull(comment.pictureItems);
    }

    @Override // com.tencent.ditto.area.DittoArea.ClickListener
    public void onClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        ArrayList<Comment> arrayList;
        ArrayList<Comment> arrayList2;
        Comment comment;
        List<Reply> list;
        if (this.onFeedElementClickListener == null) {
            return;
        }
        TextCell textCell = (TextCell) obj;
        int intValue = ((Integer) dittoArea.getTag()).intValue();
        this.clickedArea = dittoArea;
        if (obj == null) {
            performClick();
            if (intValue == 1) {
                CanvasCommentTextArea canvasCommentTextArea = (CanvasCommentTextArea) dittoArea;
                ClickedComment clickedComment = (ClickedComment) canvasCommentTextArea.getData();
                clickedComment.clickedPoint = new ClickedPoint(dittoArea.getLeft(), dittoArea.getTop(), 0, 0, dittoArea.getHeight(), dittoArea.getHeight());
                CellCommentInfo cellCommentInfo = this.mCellCommentInfo;
                if (cellCommentInfo == null || (arrayList = cellCommentInfo.commments) == null || arrayList.size() <= clickedComment.cmtIndex) {
                    return;
                }
                clickedComment.setPosition(this.feedPosition);
                clickedComment.setComment(this.mCellCommentInfo.commments.get(clickedComment.cmtIndex));
                if (canvasCommentTextArea.isDoubleClick) {
                    clickedComment.isDoubleClickComment = true;
                }
                if (canvasCommentTextArea.isClickPraise()) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PRAISE_BUTTON, this.feedPosition, clickedComment);
                    return;
                } else {
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_ITEM, this.feedPosition, clickedComment);
                    return;
                }
            }
            if (intValue == 2) {
                CanvasCommentTextArea canvasCommentTextArea2 = (CanvasCommentTextArea) dittoArea;
                ClickedComment clickedComment2 = (ClickedComment) canvasCommentTextArea2.getData();
                clickedComment2.clickedPoint = new ClickedPoint(dittoArea.getLeft(), dittoArea.getTop(), 0, 0, dittoArea.getHeight(), dittoArea.getHeight());
                CellCommentInfo cellCommentInfo2 = this.mCellCommentInfo;
                if (cellCommentInfo2 == null || (arrayList2 = cellCommentInfo2.commments) == null) {
                    return;
                }
                int size = arrayList2.size();
                int i3 = clickedComment2.cmtIndex;
                if (size <= i3 || (list = (comment = this.mCellCommentInfo.commments.get(i3)).replies) == null || list.size() <= clickedComment2.replyIndex) {
                    return;
                }
                clickedComment2.setPosition(this.feedPosition);
                clickedComment2.setComment(comment);
                clickedComment2.setReply(comment.replies.get(clickedComment2.replyIndex));
                if (canvasCommentTextArea2.isDoubleClick) {
                    clickedComment2.isDoubleClickComment = true;
                }
                if (canvasCommentTextArea2.isClickPraise()) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.REPLY_PRAISE_BUTTON, this.feedPosition, clickedComment2);
                    return;
                } else {
                    this.onFeedElementClickListener.onClick(this, FeedElement.REPLY_ITEM, this.feedPosition, clickedComment2);
                    return;
                }
            }
            if (intValue != 3) {
                if (intValue == 4) {
                    this.onFeedElementClickListener.onClick(this, (FeedElement) ((CanvasCommentTextArea) dittoArea).getData(), this.feedPosition, new ClickedPoint(dittoArea.getLeft(), dittoArea.getTop(), 0, 0, dittoArea.getWidth(), dittoArea.getHeight()));
                    return;
                } else {
                    if (intValue != 27) {
                        return;
                    }
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_SHOW_ALL, this.feedPosition, Boolean.FALSE);
                    return;
                }
            }
            Comment comment2 = (Comment) dittoArea.getAttachedObject();
            if (comment2 != null) {
                ClickedComment clickedComment3 = new ClickedComment();
                clickedComment3.setPosition(this.feedPosition);
                clickedComment3.setComment(comment2);
                CellPictureInfo cellPictureInfo = new CellPictureInfo();
                cellPictureInfo.balbum = false;
                cellPictureInfo.albumnum = 1;
                cellPictureInfo.uploadnum = 1;
                if (dittoArea instanceof CanvasMultiGifArea) {
                    CanvasMultiGifArea canvasMultiGifArea = (CanvasMultiGifArea) dittoArea;
                    CanvasMultiGifArea.ClickedPos clickPos = canvasMultiGifArea.getClickPos();
                    cellPictureInfo.pics = canvasMultiGifArea.mPictureItems;
                    this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PIC, this.feedPosition, i.H().I(cellPictureInfo, clickPos.selectedPos));
                    return;
                }
                return;
            }
            return;
        }
        g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            if (textCell instanceof UserNameCell) {
                gVar.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                return;
            }
            if (textCell.clickable() && textCell.getType() == 7) {
                this.onFeedElementClickListener.onClick(this, FeedElement.REPLY_ITEM, this.feedPosition, ((CanvasCommentTextArea) dittoArea).getData());
                return;
            }
            if (textCell.clickable() && textCell.getType() == 5) {
                this.onFeedElementClickListener.onClick(this, FeedElement.NOTHING, this.feedPosition, Boolean.FALSE);
                return;
            }
            if (textCell instanceof UrlCell) {
                UrlCell urlCell = (UrlCell) textCell;
                if (urlCell.getAction() == 2) {
                    g gVar2 = this.onFeedElementClickListener;
                    FeedElement feedElement = FeedElement.CONTENT;
                    int i16 = this.feedPosition;
                    gVar2.onClick(this, feedElement, i16, Integer.valueOf(i16));
                    return;
                }
                if (intValue == 62) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.LBS_INFO, this.feedPosition, this.feedData.getLbsInfoV2());
                    return;
                } else {
                    this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, new e(urlCell.getUrl(), urlCell.post, this.feedPosition));
                    return;
                }
            }
            if (textCell.getType() == 10) {
                this.onFeedElementClickListener.onClick(this, FeedElement.OPEN_MORE_COMMENT, this.feedPosition, new CommentSpanData((ClickedComment) dittoArea.getData(), motionEvent.getRawY() - textCell.maxCommentHeight));
                return;
            }
            if (textCell instanceof ComboNetImageCell) {
                ComboNetImageCell comboNetImageCell = (ComboNetImageCell) textCell;
                if (dittoArea instanceof CanvasCommentTextArea) {
                    Object data = ((CanvasCommentTextArea) dittoArea).getData();
                    if (data instanceof ClickedComment) {
                        comboNetImageCell.setComment(this.mCellCommentInfo.commments.get(((ClickedComment) data).cmtIndex));
                        this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_POKE_COMBO, this.feedPosition, comboNetImageCell);
                    }
                }
            }
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoArea.LongClickListener
    public void onLongClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        CellCommentInfo cellCommentInfo;
        ArrayList<Comment> arrayList;
        CellCommentInfo cellCommentInfo2;
        ArrayList<Comment> arrayList2;
        Comment comment;
        List<Reply> list;
        Comment comment2;
        if (this.onFeedElementClickListener == null) {
            return;
        }
        this.clickedArea = dittoArea;
        int intValue = ((Integer) dittoArea.getTag()).intValue();
        if (intValue == 1) {
            ClickedComment clickedComment = (ClickedComment) dittoArea.getData();
            if (clickedComment == null || (cellCommentInfo = this.mCellCommentInfo) == null || (arrayList = cellCommentInfo.commments) == null || arrayList.size() <= clickedComment.cmtIndex) {
                return;
            }
            clickedComment.setPosition(this.feedPosition);
            clickedComment.setComment(this.mCellCommentInfo.commments.get(clickedComment.cmtIndex));
            this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_LONG_CLICK, this.feedPosition, clickedComment);
            return;
        }
        if (intValue != 2) {
            if (intValue == 3 && (comment2 = (Comment) dittoArea.getAttachedObject()) != null) {
                ClickedComment clickedComment2 = new ClickedComment();
                clickedComment2.setPosition(this.feedPosition);
                clickedComment2.setComment(comment2);
                this.mLongClickedMultiGifArea = true;
                this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PIC_LONG_CLICK, this.feedPosition, clickedComment2);
                return;
            }
            return;
        }
        ClickedComment clickedComment3 = (ClickedComment) dittoArea.getData();
        if (clickedComment3 == null || (cellCommentInfo2 = this.mCellCommentInfo) == null || (arrayList2 = cellCommentInfo2.commments) == null) {
            return;
        }
        int size = arrayList2.size();
        int i3 = clickedComment3.cmtIndex;
        if (size <= i3 || (list = (comment = this.mCellCommentInfo.commments.get(i3)).replies) == null || list.size() <= clickedComment3.replyIndex) {
            return;
        }
        clickedComment3.setPosition(this.feedPosition);
        clickedComment3.setComment(comment);
        clickedComment3.setReply(comment.replies.get(clickedComment3.replyIndex));
        this.onFeedElementClickListener.onClick(this, FeedElement.REPLY_LONG_CLICK, this.feedPosition, clickedComment3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void onPause() {
        DittoListArea dittoListArea = this.commList;
        if (dittoListArea == null) {
            return;
        }
        int childCount = dittoListArea.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            DittoArea childAt = this.commList.getChildAt(i3);
            if (childAt != null && (childAt instanceof CanvasMultiGifArea)) {
                ((CanvasMultiGifArea) childAt).onPause();
            } else if (childAt != null && (childAt instanceof CanvasCommentTextArea)) {
                ((CanvasCommentTextArea) childAt).onStateScrolling();
            }
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        DittoListArea dittoListArea = this.commList;
        if (dittoListArea != null) {
            int childCount = dittoListArea.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                DittoArea childAt = this.commList.getChildAt(i3);
                if (childAt != null && (childAt instanceof CanvasCommentTextArea)) {
                    ((CanvasCommentTextArea) childAt).onRecycled();
                }
            }
            this.commList.removeAllChildren();
        }
        super.onRecycled();
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void onStateIdle() {
        DittoListArea dittoListArea = this.commList;
        if (dittoListArea == null) {
            return;
        }
        int childCount = dittoListArea.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            DittoArea childAt = this.commList.getChildAt(i3);
            if (childAt != null && (childAt instanceof CanvasMultiGifArea)) {
                ((CanvasMultiGifArea) childAt).onGifStateIdle();
            } else if (childAt != null && (childAt instanceof CanvasCommentTextArea)) {
                ((CanvasCommentTextArea) childAt).onStateIdle();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int childCount = this.commList.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                DittoArea childAt = this.commList.getChildAt(i3);
                if (childAt != null && (childAt instanceof CanvasMultiGifArea)) {
                    CanvasMultiGifArea canvasMultiGifArea = (CanvasMultiGifArea) childAt;
                    if (!isClickPicCommentArea(motionEvent, canvasMultiGifArea.getTop(), canvasMultiGifArea.getBottom())) {
                        continue;
                    } else {
                        if (!this.isClicked) {
                            checkDoubleClickEvent(motionEvent);
                            this.isClicked = true;
                            break;
                        }
                        AlarmTask alarmTask = this.mAlarmTask;
                        if (alarmTask != null) {
                            alarmTask.cancelAlarm();
                            this.isClicked = false;
                            commentPraise((Comment) canvasMultiGifArea.getAttachedObject());
                        }
                    }
                }
                i3++;
            }
        }
        return true;
    }

    boolean picItemNotNull(ArrayList<PictureItem> arrayList) {
        Iterator<PictureItem> it = arrayList.iterator();
        while (it.hasNext()) {
            PictureItem next = it.next();
            if (next.getCurrentUrl() != null && !TextUtils.isEmpty(next.getCurrentUrl().url)) {
                return true;
            }
        }
        return false;
    }

    public boolean setCommentInfo(CellCommentInfo cellCommentInfo, CellCommentInfo.CommentState commentState, int i3, boolean z16) {
        ArrayList<Comment> arrayList;
        ArrayList<Comment> arrayList2;
        setContentAreaForJsonFile("qzone_canvas_ui_comment_view.json");
        this.mCellCommentInfo = cellCommentInfo;
        int size = (cellCommentInfo == null || (arrayList2 = cellCommentInfo.commments) == null) ? 0 : arrayList2.size();
        int i16 = cellCommentInfo != null ? cellCommentInfo.commentNum : 0;
        if (i16 <= 0) {
            i16 = size;
        }
        this.mCommentState = commentState;
        this.mMode = i3;
        this.showCount = size;
        int foldSize = getFoldSize(i3, size, cellCommentInfo != null && cellCommentInfo.moreCommentHasLoaded > 0);
        if (i16 > foldSize) {
            if (CellCommentInfo.CommentState.FOLDED == commentState) {
                this.showCount = foldSize;
            } else {
                CellCommentInfo.CommentState commentState2 = CellCommentInfo.CommentState.FOLDED;
            }
        }
        if (commentState == CellCommentInfo.CommentState.FOLDED && i16 > foldSize) {
            this.showCount = foldSize;
        }
        if (cellCommentInfo != null && (arrayList = cellCommentInfo.commments) != null && this.showCount > arrayList.size()) {
            this.showCount = cellCommentInfo.commments.size();
        }
        DittoListArea dittoListArea = this.commList;
        if (dittoListArea != null) {
            dittoListArea.setAdapter(this.mAdapter);
        }
        requestLayout();
        int i17 = this.showCount != 0 ? 0 : 8;
        if (getVisibility() != i17) {
            setVisibility(i17);
        }
        updateAccessibility();
        return false;
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.feedData = businessFeedData;
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setFeedPosition(int i3, int i16) {
        this.feedPosition = i3;
        this.mIndex = i16;
        setTag(j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
    }

    public void setIsPassive(boolean z16) {
        this.isPassive = z16;
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setOnFeedElementClickListener(g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setPhotoMode(int i3) {
        this.photoMode = i3;
    }

    public void setPraiseListIsVisibility(boolean z16) {
        this.isPraiseListIsVisibility = z16;
    }

    public void setRedBonusListIsVisibility(boolean z16) {
        this.isRedBonusListVisibility = z16;
    }

    public void setSpaceRedBonusListIsVisibility(boolean z16) {
        this.isSpaceRedBonusListVisibility = z16;
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        this.mCellCommentInfo = null;
        this.clickedArea = null;
        this.photoMode = 0;
        this.mIndex = 0;
        this.isPassive = false;
        DittoListArea dittoListArea = this.commList;
        if (dittoListArea != null) {
            int childCount = dittoListArea.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                DittoArea childAt = this.commList.getChildAt(i3);
                if (childAt != null && (childAt instanceof CanvasCommentTextArea)) {
                    ((CanvasCommentTextArea) childAt).reset();
                }
            }
            this.commList.removeAllChildren();
        }
    }

    private void commentPraise(Comment comment) {
        if (comment == null || comment.isliked || this.onFeedElementClickListener == null) {
            return;
        }
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setPosition(this.feedPosition);
        clickedComment.setComment(comment);
        this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PRAISE_BUTTON, this.feedPosition, clickedComment);
    }
}
