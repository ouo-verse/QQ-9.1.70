package cooperation.qwallet.plugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.util.x;

/* loaded from: classes28.dex */
public class RedPointHelper {
    public static final int MODE_ALIGN_ANCHOR = 0;
    public static final int MODE_ALIGN_ANCHOR_BOTTOM = 2;
    public static final int MODE_ALIGN_ANCHOR_CENTERX = 4;
    public static final int MODE_ALIGN_ANCHOR_CENTERY = 8;
    public static final int MODE_ALIGN_ANCHOR_RIGHT = 1;
    protected Context mContext;
    private PopupWindow popupWindow;

    public RedPointHelper(Context context) {
        this.mContext = context;
    }

    public RedPointHelper createPopView(Drawable drawable, int i3, int i16) {
        PopupWindow popupWindow = new PopupWindow(this.mContext);
        this.popupWindow = popupWindow;
        popupWindow.setWidth(i3);
        this.popupWindow.setHeight(i16);
        this.popupWindow.setBackgroundDrawable(new ColorDrawable(Color.argb(0, 0, 0, 0)));
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setTouchable(false);
        this.popupWindow.setFocusable(false);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageDrawable(drawable);
        this.popupWindow.setContentView(imageView);
        return this;
    }

    public void hidePoint() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public void showRedPoint(View view, int i3, int i16, int i17) {
        if (this.popupWindow != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = this.popupWindow.getWidth();
            int height = this.popupWindow.getHeight();
            int i18 = iArr[0];
            int i19 = iArr[1];
            if ((i3 & 1) != 0) {
                i18 = (i18 + view.getWidth()) - width;
            }
            if ((i3 & 2) != 0) {
                i19 = (i19 + view.getHeight()) - height;
            }
            if ((i3 & 4) != 0) {
                i18 = (i18 + (view.getWidth() / 2)) - (width / 2);
            }
            if ((i3 & 8) != 0) {
                i19 = (i19 + (view.getHeight() / 2)) - (height / 2);
            }
            this.popupWindow.showAtLocation(view, 0, i18 + x.c(this.mContext, i16), i19 + x.c(this.mContext, i17));
            return;
        }
        throw new RuntimeException("createSinglePopView should called first!");
    }
}
