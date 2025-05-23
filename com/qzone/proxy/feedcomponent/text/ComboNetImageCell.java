package com.qzone.proxy.feedcomponent.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ComboNetImageCell extends NetImageCell {
    private static final String TAG = "ComboNetImageCell";
    private Paint colorPaint;
    private final int combo;
    private Comment mComment;
    private String mNickname;
    private Bitmap signBitmap;
    private Paint textPaint;
    private Rect textRect;
    private static final int BORDER_PADDING = ar.e(4.0f);
    private static final int TIMES_SIGN_SIZE = ar.e(6.0f);
    private static final int TEXT_PADDING = ar.e(1.0f);
    private static final int TEXT_WIDTH = ar.e(0.8f);
    private static final int TEXT_SIZE = ar.e(11.0f);
    private static final int TOP_PADDING = ar.e(2.0f);
    private static int COLOR_BG = -657670;
    private static int COLOR_TEXT = -16578534;

    public ComboNetImageCell(String str, int i3) {
        super(str);
        this.combo = i3;
        initPaint();
    }

    private float getAddedWidth() {
        int i3 = BORDER_PADDING;
        return TIMES_SIGN_SIZE + i3 + TEXT_PADDING + this.textRect.width() + i3;
    }

    private String getNicknameFromComment() {
        String str;
        String valInStr;
        Comment comment = this.mComment;
        if (comment != null && (str = comment.displayStr) != null && (valInStr = getValInStr(str, "nickname")) != null) {
            try {
                return URLDecoder.decode(valInStr, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    private long getUinFromComment() {
        String str;
        String valInStr;
        Comment comment = this.mComment;
        if (comment != null && (str = comment.displayStr) != null && (valInStr = getValInStr(str, "uin")) != null) {
            try {
                return Long.parseLong(valInStr);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.util.j.b(TAG, 4, e16.getMessage(), e16);
            }
        }
        return 0L;
    }

    private String getValInStr(String str, String str2) {
        int indexOf;
        int indexOf2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(":", indexOf)) == -1) {
            return null;
        }
        int i3 = indexOf2 + 1;
        int indexOf3 = str.indexOf(",", i3);
        if (indexOf3 == -1) {
            indexOf3 = Integer.MAX_VALUE;
        }
        int indexOf4 = str.indexOf(">", i3);
        if (indexOf4 == -1) {
            indexOf4 = Integer.MAX_VALUE;
        }
        int min = Math.min(indexOf3, indexOf4);
        if (min != Integer.MAX_VALUE) {
            return str.substring(i3, min);
        }
        return null;
    }

    private void initPaint() {
        Resources resources = BaseApplication.getContext().getResources();
        COLOR_BG = resources.getColor(R.color.qzone_skin_feed_second_background_color);
        COLOR_TEXT = resources.getColor(R.color.qzone_skin_feed_content_text_color);
        Paint paint = new Paint();
        this.colorPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.colorPaint;
        int i3 = TEXT_WIDTH;
        paint2.setStrokeWidth(i3);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setColor(COLOR_TEXT);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setStrokeWidth(i3);
        this.textPaint.setTextSize(TEXT_SIZE);
        this.textRect = new Rect();
        String num = Integer.toString(this.combo);
        this.textPaint.getTextBounds(num, 0, num.length(), this.textRect);
        try {
            this.signBitmap = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), com.qzone.adapter.feedcomponent.i.H().p1() ? R.drawable.dfv : R.drawable.qzone_skin_feed_cell_combo_sign);
        } catch (Throwable unused) {
            this.signBitmap = null;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public void draw(Canvas canvas, Paint paint, int i3, Rect rect, int i16, int i17, Bitmap bitmap) {
        if (!(this.combo > 0) && !this.useDefaultFont && (paint instanceof d)) {
            d dVar = (d) paint;
            if (dVar.i() && !dVar.f50712d) {
                return;
            }
        }
        try {
            Drawable emoDrawable = getEmoDrawable();
            if (emoDrawable != null) {
                if (FeedGlobalEnv.g().isViewDebugMode()) {
                    canvas.drawRect(rect, TextCell.getShellDebugPaint());
                }
                int i18 = rect.left;
                int height = (rect.top - 1) + ((i3 - emoDrawable.getBounds().height()) / 2);
                int save = canvas.save();
                canvas.translate(i18, height);
                drawInline(canvas, emoDrawable);
                canvas.restoreToCount(save);
            }
        } catch (Exception e16) {
            Log.w(TAG, "draw: failed", e16);
        }
    }

    public int getCombo() {
        return this.combo;
    }

    public String getNickName() {
        if (this.mNickname == null) {
            this.mNickname = getNicknameFromComment();
        }
        return this.mNickname;
    }

    public String getPokeZipUrl() {
        if (TextUtils.isEmpty(this.emoUrl)) {
            return null;
        }
        int indexOf = this.emoUrl.indexOf("praise.png");
        if (indexOf != -1) {
            return this.emoUrl.substring(0, indexOf) + "praise.zip";
        }
        int indexOf2 = this.emoUrl.indexOf("praise_list.png");
        if (indexOf2 == -1) {
            return null;
        }
        return this.emoUrl.substring(0, indexOf2) + "praise.zip";
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public Long getUin() {
        Long uin = super.getUin();
        return (uin == null || uin.longValue() == 0) ? Long.valueOf(getUinFromComment()) : uin;
    }

    @Override // com.qzone.proxy.feedcomponent.text.NetImageCell, com.qzone.proxy.feedcomponent.text.NetEmoCell, com.qzone.proxy.feedcomponent.text.EmoCell, com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint paint) {
        return super.getWidth(paint) + getAddedWidth();
    }

    public void setComment(Comment comment) {
        this.mComment = comment;
    }

    public void setNickname(String str) {
        this.mNickname = str;
    }

    private void drawInline(Canvas canvas, Drawable drawable) {
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        float f16 = (height / 2.0f) + TOP_PADDING;
        this.colorPaint.setStyle(Paint.Style.FILL);
        this.colorPaint.setColor(COLOR_BG);
        float f17 = width;
        canvas.drawRoundRect(new RectF(0.0f, -r3, getAddedWidth() + f17, r3 + height), f16, f16, this.colorPaint);
        canvas.translate(BORDER_PADDING, 0.0f);
        drawable.draw(canvas);
        canvas.translate(f17, 0.0f);
        int i3 = TIMES_SIGN_SIZE;
        float e16 = ((height - i3) / 2.0f) + ar.e(1.0f);
        float f18 = e16 + i3;
        Bitmap bitmap = this.signBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, this.signBitmap.getWidth(), this.signBitmap.getHeight()), new RectF(0.0f, e16, i3, f18), this.colorPaint);
        } else {
            this.colorPaint.setStyle(Paint.Style.STROKE);
            this.colorPaint.setColor(COLOR_TEXT);
            canvas.drawLine(0.0f, e16, i3, f18, this.colorPaint);
            canvas.drawLine(0.0f, f18, i3, e16, this.colorPaint);
        }
        Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        canvas.translate(i3 + TEXT_PADDING, 0.0f);
        canvas.drawText(Integer.toString(this.combo), 0.0f, ((height - fontMetricsInt.bottom) - fontMetricsInt.top) / 2.0f, this.textPaint);
    }

    public ComboNetImageCell(String str, Drawable drawable, int i3) {
        super(str, drawable);
        this.combo = i3;
        initPaint();
    }
}
