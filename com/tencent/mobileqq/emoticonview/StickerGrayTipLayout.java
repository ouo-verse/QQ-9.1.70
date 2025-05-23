package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.v;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public class StickerGrayTipLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private boolean autoDismiss;
    private int bubbleLeft;
    private boolean doubleClicked;
    private MotionEvent lastUpEvent;
    MessageRecord message;
    public EmojiStickerManager.c stickerDoubleClickListener;
    private ArrayList<EmojiStickerManager.b> stickers;

    public StickerGrayTipLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.bubbleLeft = 0;
        this.autoDismiss = false;
        this.doubleClicked = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0016 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doAutomaticDismiss() {
        ArrayList<EmojiStickerManager.b> arrayList;
        if (this.autoDismiss && (arrayList = this.stickers) != null && arrayList.size() > 0) {
            Iterator<EmojiStickerManager.b> it = this.stickers.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                EmojiStickerManager.b next = it.next();
                if (next.f204614b + this.bubbleLeft + (next.f204616d / 2) < getMeasuredWidth() / 2) {
                    if (Math.abs(next.f204619g) > 200) {
                        int i3 = next.f204619g;
                        int i16 = EmojiStickerManager.f204587x;
                        next.f204619g = i3 - i16;
                        int abs = next.f204620h - Math.abs(i16 / 2);
                        next.f204620h = abs;
                        next.f204620h = Math.min(255, Math.max(0, abs));
                    } else {
                        int abs2 = next.f204620h + Math.abs(EmojiStickerManager.f204587x / 2);
                        next.f204620h = abs2;
                        next.f204620h = Math.min(255, Math.max(0, abs2));
                        next.f204619g += EmojiStickerManager.f204587x;
                    }
                    if (next.f204619g > 0) {
                        next.f204619g = 0;
                        next.f204620h = 255;
                        this.autoDismiss = false;
                        z16 = false;
                    }
                    if (next.f204619g < -400) {
                        next.f204619g = LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
                        next.f204620h = 0;
                        this.autoDismiss = false;
                        z16 = true;
                    }
                    if (next.f204619g <= 400) {
                        next.f204619g = 400;
                        next.f204620h = 0;
                        this.autoDismiss = false;
                        z16 = true;
                    }
                } else {
                    if (Math.abs(next.f204619g) < 200) {
                        int abs3 = next.f204620h + Math.abs(EmojiStickerManager.f204587x / 2);
                        next.f204620h = abs3;
                        next.f204620h = Math.min(255, Math.max(0, abs3));
                        next.f204619g -= EmojiStickerManager.f204587x;
                    } else {
                        int abs4 = next.f204620h - Math.abs(EmojiStickerManager.f204587x / 2);
                        next.f204620h = abs4;
                        next.f204620h = Math.min(255, Math.max(0, abs4));
                        next.f204619g += EmojiStickerManager.f204587x;
                    }
                    if (next.f204619g < 0) {
                        next.f204619g = 0;
                        next.f204620h = 255;
                        this.autoDismiss = false;
                        z16 = false;
                    }
                    if (next.f204619g < -400) {
                    }
                    if (next.f204619g <= 400) {
                    }
                }
            }
            MessageRecord messageRecord = this.message;
            if (messageRecord != null) {
                messageRecord.stickerHidden = z16;
            }
            invalidate();
        }
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getEventTime() - motionEvent.getEventTime() > 200) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent2.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent2.getY());
        if ((x16 * x16) + (y16 * y16) >= 10000) {
            return false;
        }
        return true;
    }

    private boolean isTouchedOnStickers(float f16, float f17) {
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<EmojiStickerManager.b> it = this.stickers.iterator();
            while (it.hasNext()) {
                EmojiStickerManager.b next = it.next();
                int i3 = next.f204614b + this.bubbleLeft;
                float f18 = next.f204624l;
                int i16 = next.f204616d;
                int i17 = next.f204617e;
                int i18 = (i3 + next.f204619g) - (((int) ((f18 - 1.0f) * i16)) / 2);
                int i19 = next.f204615c - (((int) ((f18 - 1.0f) * i17)) / 2);
                float f19 = i18;
                if (f16 > f19 && f16 < f19 + (i16 * f18)) {
                    float f26 = i19;
                    if (f17 > f26 && f17 < f26 + (f18 * i17)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean addSticker(Drawable drawable, int i3, int i16, int i17, int i18, double d16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, drawable, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16), str)).booleanValue();
        }
        if (this.stickers == null) {
            this.stickers = new ArrayList<>();
        }
        if (this.stickers.size() >= QVipStickerProcessor.sStickerMaxShowNum) {
            return false;
        }
        EmojiStickerManager.b bVar = new EmojiStickerManager.b();
        if (drawable != null) {
            bVar.f204613a = drawable.mutate();
            drawable.setCallback(this);
        }
        bVar.f204614b = i3;
        bVar.f204615c = i16;
        bVar.f204616d = i17;
        bVar.f204617e = i18;
        bVar.f204618f = d16;
        bVar.f204621i = str;
        this.stickers.add(bVar);
        return true;
    }

    public void adjustStickersVerticalPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null) {
            Iterator<EmojiStickerManager.b> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().f204615c += i3;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getTag() instanceof v.a) {
                this.message = ((v.a) viewGroup.getTag()).f180131a;
            }
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getId() == R.id.graybar) {
                this.bubbleLeft = childAt.getLeft();
            }
        }
        if (this.stickers != null) {
            for (int i16 = 0; i16 <= this.stickers.size() - 1; i16++) {
                EmojiStickerManager.b bVar = this.stickers.get(i16);
                MessageRecord messageRecord = this.message;
                if (messageRecord != null && messageRecord.stickerHidden) {
                    if (bVar.f204614b + this.bubbleLeft + (bVar.f204616d / 2) < getMeasuredWidth() / 2) {
                        i3 = LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
                    } else {
                        i3 = 400;
                    }
                    bVar.f204619g = i3;
                    bVar.f204620h = 0;
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.translate(bVar.f204614b + this.bubbleLeft + bVar.f204619g, bVar.f204615c);
                canvas.rotate((float) bVar.f204618f, bVar.f204616d / 2, bVar.f204617e / 2);
                bVar.f204613a.setAlpha(bVar.f204620h);
                bVar.f204613a.setBounds(0, 0, bVar.f204616d, bVar.f204617e);
                bVar.f204613a.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }
        doAutomaticDismiss();
    }

    public void doDismiss(int i3, int i16) {
        MessageRecord messageRecord;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null && arrayList.size() > 0) {
            MessageRecord messageRecord2 = this.message;
            if (messageRecord2 == null || !messageRecord2.stickerHidden) {
                z16 = false;
            }
            Iterator<EmojiStickerManager.b> it = this.stickers.iterator();
            while (it.hasNext()) {
                EmojiStickerManager.b next = it.next();
                if (this.message != null && z16) {
                    if (next.f204614b + this.bubbleLeft + (next.f204616d / 2) < getMeasuredWidth() / 2) {
                        i17 = -400;
                    } else {
                        i17 = 400;
                    }
                    next.f204619g = i17;
                    next.f204620h = 0;
                }
                if (i16 != EmojiStickerManager.f204586w || next.f204619g != 0) {
                    if (i16 == EmojiStickerManager.f204585v) {
                        if (next.f204614b + this.bubbleLeft + (next.f204616d / 2) < getMeasuredWidth() / 2) {
                            next.f204619g -= i3;
                        } else {
                            next.f204619g += i3;
                        }
                        int abs = next.f204620h - Math.abs(i3 / 2);
                        next.f204620h = abs;
                        next.f204620h = Math.min(255, Math.max(0, abs));
                    } else if (i16 == EmojiStickerManager.f204586w) {
                        if (next.f204614b + this.bubbleLeft + (next.f204616d / 2) < getMeasuredWidth() / 2) {
                            int i18 = next.f204619g + i3;
                            next.f204619g = i18;
                            if (i18 > 0) {
                                next.f204619g = 0;
                                next.f204620h = 255;
                            }
                        } else {
                            int i19 = next.f204619g - i3;
                            next.f204619g = i19;
                            if (i19 < 0) {
                                next.f204619g = 0;
                                next.f204620h = 255;
                            }
                        }
                        int abs2 = next.f204620h + Math.abs(i3 / 2);
                        next.f204620h = abs2;
                        next.f204620h = Math.min(255, Math.max(0, abs2));
                    }
                }
                if (next.f204619g < -400) {
                    next.f204619g = LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
                    next.f204620h = 0;
                }
                if (next.f204619g > 400) {
                    next.f204619g = 400;
                    next.f204620h = 0;
                }
            }
            if (z16 && (messageRecord = this.message) != null) {
                messageRecord.stickerHidden = false;
            }
            invalidate();
        }
    }

    public int getStickerCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean haveStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) drawable);
        } else {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (isTouchedOnStickers(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null && arrayList.size() > 0) {
            this.autoDismiss = false;
            int measuredHeight = getMeasuredHeight();
            boolean z16 = false;
            for (int i17 = 0; i17 < this.stickers.size(); i17++) {
                EmojiStickerManager.b bVar = this.stickers.get(i17);
                bVar.f204620h = 255;
                bVar.f204619g = 0;
                int i18 = bVar.f204615c;
                int i19 = bVar.f204617e;
                if (i18 + i19 > measuredHeight) {
                    z16 = true;
                    measuredHeight = i18 + i19;
                }
            }
            if (z16) {
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                if (QLog.isColorLevel()) {
                    QLog.d("StickerGrayTipLayout", 2, "onMeasure bubbleBottm = " + measuredHeight);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (isTouchedOnStickers(motionEvent.getX(), motionEvent.getY())) {
            if (motionEvent.getAction() == 0) {
                MotionEvent motionEvent2 = this.lastUpEvent;
                if (motionEvent2 != null && isConsideredDoubleTap(motionEvent2, motionEvent)) {
                    this.doubleClicked = true;
                }
            } else if (motionEvent.getAction() == 1) {
                this.lastUpEvent = MotionEvent.obtain(motionEvent);
                if (this.doubleClicked) {
                    this.doubleClicked = false;
                    this.lastUpEvent = null;
                }
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeAllStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ArrayList<EmojiStickerManager.b> arrayList = this.stickers;
        if (arrayList != null) {
            this.autoDismiss = false;
            arrayList.clear();
        }
    }

    public void startAutoDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.autoDismiss = true;
            invalidate();
        }
    }

    public StickerGrayTipLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.bubbleLeft = 0;
        this.autoDismiss = false;
        this.doubleClicked = false;
    }

    public StickerGrayTipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.bubbleLeft = 0;
        this.autoDismiss = false;
        this.doubleClicked = false;
    }
}
