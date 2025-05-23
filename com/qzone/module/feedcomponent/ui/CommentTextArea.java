package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.module.feedcomponent.util.MaxCommentLineConfig;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentTextArea extends SubArea implements TextLayoutBase, DittoTextAreaCompat {
    protected static String REPLAY_COLON = ": ";
    public static String REPLAY_STR = " \u56de\u590d ";
    ViewArea.OnAreaClickedListener clickListener;
    public int commentIndex;
    public boolean isComment;
    ViewArea.OnAreaLongClickedListener longClickListener;
    ArrayList<TextCell> mCells;
    int mFontHeight;
    int mLinkColor;
    int mTextColor;
    protected Paint paint;
    public int replyIndex;
    TextCellLayout textLayout;
    boolean cellClickable = true;
    private boolean needUpdate = false;

    public CommentTextArea(int i3) {
        int i16;
        this.paint = new Paint(1);
        this.textLayout = new TextCellLayout(this);
        this.mType = i3;
        this.mLinkColor = com.qzone.adapter.feedcomponent.j.o();
        this.mTextColor = com.qzone.adapter.feedcomponent.j.o();
        this.paint = AreaManager.getInstance().getPaintForTextArea(i3);
        TextCellLayout textCellLayout = new TextCellLayout(this, this.paint);
        this.textLayout = textCellLayout;
        textCellLayout.setTextColorLink(this.mLinkColor);
        this.textLayout.setTextColor(this.mTextColor);
        this.textLayout.setLineSpace(com.qzone.proxy.feedcomponent.util.g.a(1.0f));
        setFontHeight(FeedGlobalEnv.g().getSpValue(AreaConst.commentTextSize));
        setTextSize(AreaConst.commentTextSize);
        TextCellLayout textCellLayout2 = this.textLayout;
        if (TextCellLayout.f50567b2) {
            i16 = MaxCommentLineConfig.MAX_COMMENT_LINE_MSG;
        } else {
            i16 = MaxCommentLineConfig.MAX_COMMENT_LINE_FEEDS;
        }
        textCellLayout2.setMaxCommentLine(i16);
    }

    public static String buildUinStringForComment(long j3, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        return "{uin:" + j3 + ",nick:" + str + ",who:1,auto:1}";
    }

    public static String builduinString(long j3, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        return "{uin:" + j3 + ",nick:" + str + ",who:1,auto:1}";
    }

    public static int getIndexByCodePoint(String str, int i3) {
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            i16 += Character.charCount(str.codePointAt(i16));
            i17++;
            if (i17 >= i3) {
                return i16;
            }
        }
        return length;
    }

    private TextCell getLikeCell(Comment comment) {
        if (comment.likeNum <= 0) {
            return null;
        }
        ColorTextCell colorTextCell = new ColorTextCell(0, "\u00b7" + comment.likeNum + "\u8d5e");
        colorTextCell.setTextColor(com.qzone.adapter.feedcomponent.j.c(11));
        return colorTextCell;
    }

    public static String parseCommentText(User user, String str) {
        StringBuilder sb5 = new StringBuilder();
        if (user != null) {
            sb5.append(buildUinStringForComment(user.uin, user.nickName));
            sb5.append("{text:");
            sb5.append(REPLAY_COLON);
            sb5.append(",color:");
            sb5.append(Integer.toHexString(com.qzone.adapter.feedcomponent.j.o()));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(str);
        }
        return sb5.toString();
    }

    private void setUserNameBold(TextCell textCell) {
        if (textCell instanceof UserNameCell) {
            ((UserNameCell) textCell).setTextBold(true);
        }
    }

    public static String substring(String str, int i3) {
        if (str == null || str.equals("") || i3 < 1) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        String subStringByCodePoint = subStringByCodePoint(str, i3);
        if (subStringByCodePoint.length() >= str.length()) {
            return str;
        }
        return subStringByCodePoint + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    protected void clearTouchTarget() {
        this.textLayout.clearTouchTarget();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        return this.textLayout.draw(this, canvas);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.replyIndex = this.replyIndex;
        clickedComment.cmtIndex = this.commentIndex;
        clickedComment.isComment = this.isComment;
        return clickedComment;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.tencent.ditto.widget.DittoTextAreaCompat
    public String getText() {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            return textCellLayout.getText();
        }
        return null;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    public boolean isNeedUpdate() {
        if (!this.needUpdate) {
            return false;
        }
        this.needUpdate = false;
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        measureInside(i3, i16);
    }

    void measureInside(int i3, int i16) {
        try {
            this.textLayout.measure(i3, i16);
            this.mHeight = this.textLayout.getMeausredHeight();
            this.mWidth = this.textLayout.getMeausredWidth();
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.d("Feed", "Text measure error!", th5);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public void onLongClick(ViewArea.OnAreaLongClickedListener onAreaLongClickedListener) {
        super.onLongClick(onAreaLongClickedListener);
        clearTouchTarget();
    }

    public void onRecycled() {
        this.textLayout.recycleTextRes();
    }

    public void onStateIdle() {
        this.textLayout.onStateIdle();
    }

    public void onStateScrolling() {
        this.textLayout.onStateScrolling();
    }

    public boolean onTouchEvent(MotionEvent motionEvent, ViewArea.OnAreaClickedListener onAreaClickedListener, boolean z16) {
        this.clickListener = onAreaClickedListener;
        return this.textLayout.onTouchEvent(motionEvent, SubArea.longClickHandler);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellClick(TextCell textCell) {
        ViewArea.OnAreaClickedListener onAreaClickedListener = this.clickListener;
        if (onAreaClickedListener != null) {
            onAreaClickedListener.onAreaClicked(this, textCell);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellLongClick() {
        if (this.clickListener != null) {
            Handler handler = SubArea.longClickHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0, this), 600L);
        }
    }

    public void reset() {
        this.textLayout.reset();
    }

    public void setColorBackground(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setColorBackground(i3);
        }
    }

    public void setData(Comment comment, Reply reply, int i3) {
        String disReplyStr = getDisReplyStr(comment, i3);
        if (TextUtils.isEmpty(disReplyStr)) {
            disReplyStr = parseReplyText(reply);
        }
        ArrayList<TextCell> parseContent = TextCellParser.parseContent(this, disReplyStr, this.mFontHeight, this.cellClickable);
        this.mCells = parseContent;
        preHandleCells(comment, parseContent);
        boolean z16 = comment.feedType == 4097;
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setFont(reply.getFontId(z16), reply.getFontUrl(z16), reply.getFontType(z16));
        setTextEffect(reply.getSuperFontInfo(false));
        this.textLayout.setText(this.mCells);
        measureInside(AreaConst.getCommentWidth(), 0);
        this.mCells = null;
    }

    void setFontHeight(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.mFontHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
    }

    public void setIsNeedLineSpace(boolean z16) {
        this.textLayout.setIsNeedLineSpace(Boolean.valueOf(z16));
    }

    public void setLineSpace(int i3) {
        this.textLayout.setLineSpace(i3);
    }

    public void setLinkColor(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setTextColorLink(i3);
        }
    }

    public void setLinkColorBackground(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setTextColorLinkBackground(i3);
        }
    }

    public void setTextColor(int i3) {
        TextCellLayout textCellLayout = this.textLayout;
        if (textCellLayout != null) {
            textCellLayout.setTextColor(i3);
            this.textLayout.setTextColorLinkBackground(i3);
        }
    }

    public void setTextSize(float f16) {
        float spValue = FeedGlobalEnv.g().getSpValue(f16);
        if (spValue != this.paint.getTextSize()) {
            this.paint.setTextSize(spValue);
        }
        this.textLayout.setTextSize(spValue);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        setPressed(false);
        SubArea.longClickHandler.removeMessages(0);
        this.longClickTrig = false;
        clearTouchTarget();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void invalidate() {
        this.needUpdate = true;
        super.invalidate();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void requestLayout() {
        this.needUpdate = true;
        super.requestLayout();
    }

    public static String getDisReplyStr(Comment comment, int i3) {
        if (i3 <= -1) {
            return null;
        }
        try {
            ArrayList<String> arrayList = comment.displayReplyStr;
            if (arrayList == null || i3 >= arrayList.size()) {
                return null;
            }
            return comment.displayReplyStr.get(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String parseReplyText(Reply reply) {
        if (reply == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        User user = reply.user;
        if (user != null) {
            sb5.append(builduinString(user.uin, user.nickName));
        }
        User user2 = reply.targetUser;
        if (user2 != null && user2.uin > 0 && !TextUtils.isEmpty(user2.nickName)) {
            sb5.append("{text:");
            sb5.append(REPLAY_STR);
            sb5.append(",color:");
            sb5.append(Integer.toHexString(com.qzone.adapter.feedcomponent.j.o()));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            User user3 = reply.targetUser;
            sb5.append(builduinString(user3.uin, user3.nickName));
        }
        sb5.append("{text:");
        sb5.append(REPLAY_COLON);
        sb5.append(",color:");
        sb5.append(Integer.toHexString(com.qzone.adapter.feedcomponent.j.o()));
        sb5.append(",useDefaultFont:1,useSuperFont:0}");
        sb5.append(reply.content);
        return sb5.toString();
    }

    private void preHandleCells(Comment comment, ArrayList<TextCell> arrayList) {
        if (comment == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TextCell textCell = arrayList.get(i3);
            if (textCell != null) {
                setUserNameBold(textCell);
            }
        }
    }

    private void setTextEffect(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            this.textLayout.setShadowLayer(0, 0, 0, 0);
            this.textLayout.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            this.textLayout.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            this.textLayout.setShadowLayer(com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowBlurRadius), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetX), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            this.textLayout.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            this.textLayout.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            this.textLayout.setTextColorAnimation(null, 0);
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
            this.textLayout.setGradientColor(iArr, fArr, orientation);
            return;
        }
        this.textLayout.setGradientColor(null, null, null);
    }

    public static String subStringByCodePoint(String str, int i3) {
        if (str == null) {
            return null;
        }
        int indexByCodePoint = getIndexByCodePoint(str, i3);
        return indexByCodePoint >= str.length() ? str : str.substring(0, indexByCodePoint);
    }

    public void setData(Comment comment) {
        String parseCommentText;
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo;
        ArrayList<TextCell> arrayList;
        int size;
        TextCell textCell;
        if (!TextUtils.isEmpty(comment.displayStr)) {
            parseCommentText = comment.displayStr;
        } else {
            parseCommentText = parseCommentText(comment.user, comment.comment);
        }
        this.mCells = TextCellParser.parseContent(this, comment.getPokeLikeComment(parseCommentText), this.mFontHeight, this.cellClickable, false);
        boolean z16 = comment.hasPokeLike() && (arrayList = this.mCells) != null && (size = arrayList.size()) > 0 && (textCell = this.mCells.get(size - 1)) != null && (TextUtils.isEmpty(textCell.text) || "\u2000".equals(textCell.text));
        preHandleCells(comment, this.mCells);
        this.textLayout.setFont(comment.getFontId(false), comment.getFontUrl(false), comment.getFontType(false));
        setTextEffect(comment.getSuperFontInfo(false));
        int i3 = comment.feedType;
        if (i3 != 4098) {
            barrageEffectInfo = comment.getBarrageEffectInfo(i3 == 4097);
        } else {
            barrageEffectInfo = null;
        }
        if (barrageEffectInfo != null && barrageEffectInfo.f51896id > 0 && !z16) {
            this.textLayout.setBarrageEffect(true, barrageEffectInfo);
        } else {
            this.textLayout.setBarrageEffect(false, null);
        }
        this.textLayout.setMeasuredTextCacheEnabled(false);
        this.textLayout.setText(this.mCells);
        measureInside(AreaConst.getCommentWidth(), 0);
        this.mCells = null;
    }
}
