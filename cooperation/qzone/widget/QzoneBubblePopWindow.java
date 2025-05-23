package cooperation.qzone.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

/* loaded from: classes28.dex */
public class QzoneBubblePopWindow extends PopupWindow {
    private WeakReference<Context> mContext;

    public QzoneBubblePopWindow(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = new WeakReference<>(context);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (this.mContext.get() == null) {
            return;
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        if (this.mContext.get() == null) {
            return;
        }
        super.showAtLocation(view, i3, i16, i17);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        if (this.mContext.get() == null) {
            return;
        }
        super.showAsDropDown(view, i3, i16);
    }
}
