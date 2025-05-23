package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.uihierarchy.TextViewCompat;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonImageView extends URLImageView implements TextViewCompat {
    static IPatchRedirector $redirector_;
    private static boolean sDisableNewIcon;
    private static Rect sDstRect;
    private static Bitmap sNewIcon;
    private static Rect sSrcRect;
    private boolean mNewIconVisible;
    private Paint mPaint;

    public EmoticonImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    public static void disableNewIcon(boolean z16) {
        sDisableNewIcon = z16;
    }

    public static boolean isNewIconDisable() {
        return sDisableNewIcon;
    }

    @Override // com.tencent.mobileqq.utils.uihierarchy.TextViewCompat
    public CharSequence getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Object tag = getTag();
        if (tag instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) tag;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(emotionType:");
            sb5.append(systemAndEmojiEmoticonInfo.emotionType);
            sb5.append(" emotionCode:");
            sb5.append(systemAndEmojiEmoticonInfo.code);
            sb5.append(")");
            return sb5;
        }
        return null;
    }

    public boolean isNewIconVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mNewIconVisible;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (!sDisableNewIcon && this.mNewIconVisible) {
            if (sNewIcon == null) {
                try {
                    sNewIcon = BitmapFactory.decodeResource(super.getResources(), R.drawable.o4f);
                } catch (Exception unused) {
                }
            }
            Bitmap bitmap = sNewIcon;
            if (bitmap != null) {
                if (sSrcRect == null) {
                    int width = bitmap.getWidth();
                    int height = sNewIcon.getHeight();
                    int width2 = super.getWidth();
                    int height2 = super.getHeight();
                    sSrcRect = new Rect(0, 0, width, height);
                    int i3 = (width2 - width) / 2;
                    int i16 = (int) (height2 - (super.getResources().getDisplayMetrics().density * 13.0f));
                    sDstRect = new Rect(i3, i16, width + i3, height + i16);
                }
                if (this.mPaint == null) {
                    this.mPaint = new Paint();
                }
                canvas.drawBitmap(sNewIcon, sSrcRect, sDstRect, this.mPaint);
            }
        }
    }

    public void setNewIconVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mNewIconVisible = z16;
        }
    }

    public EmoticonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public EmoticonImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
