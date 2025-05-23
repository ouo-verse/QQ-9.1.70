package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLTextView extends GLImageView {
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private boolean mNeedDrawText;
    private ArrayList<StringItem> mStringList;
    private Paint paint;
    private int pixelHeightSize;
    private float totalWidth;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class StringItem {
        public int color;
        public int count;
        public String data;
        public float measureSize;

        public StringItem() {
        }
    }

    public GLTextView(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.paint = new Paint();
        this.pixelHeightSize = 0;
        this.totalWidth = 0.0f;
        this.mStringList = new ArrayList<>();
        initView(4);
    }

    private void drawText() {
        float textWidth = getTextWidth();
        int i3 = this.pixelHeightSize;
        if (i3 == 0) {
            return;
        }
        this.mBitmap = Bitmap.createBitmap((int) textWidth, i3, Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);
        this.paint.setTextSize(this.pixelHeightSize);
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        float abs = Math.abs(this.paint.getFontMetrics().ascent);
        Iterator<StringItem> it = this.mStringList.iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            StringItem next = it.next();
            this.paint.setColor(next.color);
            this.mCanvas.drawText(next.data, f16, abs, this.paint);
            f16 += next.measureSize;
        }
        super.setImageBitmap(this.mBitmap);
        this.mNeedDrawText = false;
    }

    public void clearTextCache() {
        this.mStringList.clear();
        this.totalWidth = 0.0f;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        if (this.mNeedDrawText) {
            drawText();
        }
        super.draw();
    }

    public int getTextHeight() {
        return this.pixelHeightSize;
    }

    public float getTextWidth() {
        if (this.totalWidth == 0.0f) {
            this.paint.setTextSize(this.pixelHeightSize);
            Iterator<StringItem> it = this.mStringList.iterator();
            while (it.hasNext()) {
                StringItem next = it.next();
                float measureText = this.paint.measureText(next.data);
                next.measureSize = measureText;
                this.totalWidth += measureText;
            }
        }
        return this.totalWidth;
    }

    public void setText(String str, int i3, int i16) {
        StringItem stringItem = new StringItem();
        stringItem.data = str;
        stringItem.count = i3;
        stringItem.color = i16;
        this.mStringList.add(stringItem);
        this.mNeedDrawText = true;
    }

    public void setTextSize(int i3) {
        this.pixelHeightSize = i3;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
    public void setImageBitmap(Bitmap bitmap) {
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
    public void setImageRes(String str) {
    }
}
