package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.mobileqq.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RedTouchExtendButton extends ExtendButton {
    public static final int leftInterval = 2;
    public static final int redImageSizeDp = 24;
    public static final int redPointSizeDp = 10;
    public static final int redTextBgIntervalDp = 0;
    public static final int redTextSizeDp = 11;
    public static final int rightInterval = 0;
    private RedInfo appInfo;
    public Drawable currentDrawable;
    public String imgUrl;
    private Rect mTextBounds;
    private Handler mUiHandler;
    private int realRedSizePix;
    private int redImageSizePix;
    private int redPointSizePix;
    private String redText;
    private int redType;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class RedInfo implements Parcelable {
        public static final Parcelable.Creator<RedInfo> CREATOR = new Parcelable.Creator<RedInfo>() { // from class: cooperation.qzone.widget.RedTouchExtendButton.RedInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RedInfo createFromParcel(Parcel parcel) {
                return new RedInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RedInfo[] newArray(int i3) {
                return new RedInfo[i3];
            }
        };
        public static final int RED_TOUCH_IMAGE = 3;
        public static final int RED_TOUCH_NONE = 100;
        public static final int RED_TOUCH_RED_POINT = 0;
        public static final int RED_TOUCH_TEXT = 4;
        public String desc;
        public boolean isNew;
        public String redText;
        public int redType;
        public int resId;
        public String resUrl;

        public RedInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RedInfo)) {
                return false;
            }
            RedInfo redInfo = (RedInfo) obj;
            return equals(Boolean.valueOf(redInfo.isNew), Boolean.valueOf(this.isNew)) && equals(redInfo.redText, this.redText) && equals(Integer.valueOf(redInfo.redType), Integer.valueOf(this.redType)) && equals(redInfo.resUrl, this.resUrl) && equals(redInfo.desc, this.desc) && equals(Integer.valueOf(redInfo.resId), Integer.valueOf(this.resId));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.isNew ? 1 : 0);
            parcel.writeInt(this.redType);
            parcel.writeInt(this.resId);
            parcel.writeString(this.redText);
            parcel.writeString(this.resUrl);
            parcel.writeString(this.desc);
        }

        public RedInfo(Parcel parcel) {
            this.isNew = parcel.readInt() == 1;
            this.redType = parcel.readInt();
            this.resId = parcel.readInt();
            this.redText = parcel.readString();
            this.resUrl = parcel.readString();
            this.desc = parcel.readString();
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return true;
            }
            return obj != null && obj.equals(obj2);
        }

        public RedInfo(RedInfo redInfo) {
            if (redInfo != null) {
                this.isNew = redInfo.isNew;
                this.redType = redInfo.redType;
                this.resId = redInfo.resId;
                this.redText = redInfo.redText;
                this.resUrl = redInfo.resUrl;
                this.desc = redInfo.desc;
            }
        }
    }

    public RedTouchExtendButton(Context context) {
        this(context, null);
    }

    private boolean checkIsEqual(RedInfo redInfo, RedInfo redInfo2) {
        return equals(redInfo, redInfo2);
    }

    private void drawRed(Canvas canvas) {
        if (isSupportRedTouch(this.appInfo)) {
            try {
                int startY = getStartY() - dipToPixels(4);
                int startX = getStartX() - dipToPixels(2);
                if (this.redType == 0) {
                    Drawable drawable = getResources().getDrawable(R.drawable.skin_tips_dot);
                    this.currentDrawable = drawable;
                    int i3 = this.realRedSizePix;
                    drawable.setBounds(startX, startY, startX + i3, i3 + startY);
                    this.currentDrawable.draw(canvas);
                }
                if (this.redType == 4) {
                    String str = this.appInfo.redText;
                    Paint paint = new Paint(1);
                    paint.setTextSize(dipToPixels(11));
                    paint.setTextAlign(Paint.Align.CENTER);
                    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                    int dipToPixels = dipToPixels(2) + startX;
                    int height = (getHeight() / 2) - ((this.realRedSizePix + (dipToPixels(0) * 2)) / 2);
                    Rect rect = new Rect();
                    rect.left = dipToPixels;
                    rect.top = height;
                    int dipToPixels2 = this.realRedSizePix + (dipToPixels(0) * 2);
                    rect.bottom = height + dipToPixels2;
                    rect.right = dipToPixels2 + dipToPixels;
                    float dipToPixels3 = (dipToPixels(0) + height) - fontMetrics.top;
                    Drawable drawable2 = getResources().getDrawable(R.drawable.skin_tips_dot);
                    drawable2.getBounds();
                    drawable2.setBounds(dipToPixels, height, rect.right, rect.bottom);
                    drawable2.draw(canvas);
                    paint.setColor(-1);
                    canvas.drawText(str, rect.left + (rect.width() / 2), dipToPixels3, paint);
                }
                if (this.redType == 3) {
                    Drawable drawable3 = getResources().getDrawable(R.drawable.g_w);
                    int dipToPixels4 = startX + dipToPixels(2);
                    int height2 = (getHeight() / 2) - (drawable3.getIntrinsicHeight() / 2);
                    drawable3.setBounds(dipToPixels4, height2, drawable3.getIntrinsicWidth() + dipToPixels4, drawable3.getIntrinsicHeight() + height2);
                    drawable3.draw(canvas);
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean equals(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    private int getDrawableViewHeight() {
        return getHeight();
    }

    private int getDrawableViewWidth() {
        return (getWidth() - getStartX()) - dipToPixels(0);
    }

    private int getStartX() {
        return (int) getLayout().getLineRight(0);
    }

    private int getStartY() {
        Rect rect = new Rect();
        getLineBounds(0, rect);
        int i3 = rect.top;
        if (i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private boolean isSupportRedImage() {
        if (getDrawableViewHeight() >= this.redImageSizePix && getDrawableViewWidth() >= this.redImageSizePix + dipToPixels(2)) {
            return true;
        }
        return false;
    }

    private boolean isSupportRedPoint() {
        if (getDrawableViewHeight() >= this.redPointSizePix && getDrawableViewWidth() + dipToPixels(2) >= this.redPointSizePix) {
            return true;
        }
        return false;
    }

    private boolean isSupportRedText(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(dipToPixels(11));
        int measureText = (int) textPaint.measureText(str);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        if (getDrawableViewWidth() < Math.max(measureText, (int) (fontMetrics.bottom - fontMetrics.top)) + (dipToPixels(0) * 2) + dipToPixels(2)) {
            return false;
        }
        return true;
    }

    private boolean isSupportRedTouch(RedInfo redInfo) {
        if (redInfo == null || !redInfo.isNew) {
            return false;
        }
        checkIsEqual(getAppInfo(), redInfo);
        int i3 = redInfo.redType;
        if (i3 == 3) {
            if (isSupportRedImage()) {
                this.realRedSizePix = this.redImageSizePix;
                this.imgUrl = redInfo.resUrl;
                this.redType = 3;
                return true;
            }
            if (isSupportRedPoint()) {
                this.realRedSizePix = this.redPointSizePix;
                this.redType = 0;
                return true;
            }
            this.realRedSizePix = 0;
            this.redType = 100;
            return false;
        }
        if (i3 == 4) {
            String str = redInfo.redText;
            this.redText = str;
            if (isSupportRedText(str)) {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(dipToPixels(11));
                int measureText = (int) textPaint.measureText(this.redText);
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                this.realRedSizePix = Math.max(measureText, (int) (fontMetrics.bottom - fontMetrics.top));
                this.redType = 4;
                return true;
            }
            if (isSupportRedPoint()) {
                this.realRedSizePix = this.redPointSizePix;
                this.redType = 0;
                return true;
            }
            this.realRedSizePix = 0;
            this.redType = 100;
            return false;
        }
        if (i3 == 0) {
            if (isSupportRedPoint()) {
                this.realRedSizePix = this.redPointSizePix;
                this.redType = 0;
                return true;
            }
            this.realRedSizePix = 0;
            this.redType = 100;
        }
        return false;
    }

    protected int dipToPixels(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    public RedInfo getAppInfo() {
        return this.appInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0014 -> B:8:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Bitmap getIconFromFile(File file) {
        Throwable th5;
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        FileInputStream fileInputStream2 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e17) {
                e = e17;
                fileInputStream = null;
            } catch (OutOfMemoryError e18) {
                e = e18;
                fileInputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (fileInputStream2 != null) {
                }
                throw th5;
            }
            try {
                bitmap = new BitmapDrawable(fileInputStream).getBitmap();
                fileInputStream.close();
            } catch (FileNotFoundException e19) {
                e = e19;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmap;
            } catch (OutOfMemoryError e26) {
                e = e26;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmap;
            }
            return bitmap;
        } catch (Throwable th7) {
            th5 = th7;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th5;
        }
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        this.currentDrawable = drawable;
        invalidateOnUiThread();
    }

    public void invalidateOnUiThread() {
        if (this.mUiHandler == null) {
            this.mUiHandler = new Handler(Looper.getMainLooper());
        }
        this.mUiHandler.post(new Runnable() { // from class: cooperation.qzone.widget.RedTouchExtendButton.1
            @Override // java.lang.Runnable
            public void run() {
                RedTouchExtendButton.this.invalidate();
            }
        });
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        drawRed(canvas);
        canvas.restore();
    }

    public void setAppInfo(RedInfo redInfo) {
        this.appInfo = redInfo;
        invalidate();
    }

    public RedTouchExtendButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedTouchExtendButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.redImageSizePix = 0;
        this.redPointSizePix = 0;
        this.realRedSizePix = 0;
        this.redType = 100;
        this.imgUrl = "";
        this.redText = "";
        this.mTextBounds = new Rect();
        this.redImageSizePix = dipToPixels(24);
        this.redPointSizePix = dipToPixels(10);
        this.realRedSizePix = dipToPixels(10);
    }
}
