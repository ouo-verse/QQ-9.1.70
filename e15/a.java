package e15;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.image.URLDrawable;
import com.tencent.util.URLUtil;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends f {
    public a(String str, View view) {
        super(str, view);
    }

    private ImageView.ScaleType u(String str) {
        if (TextUtils.isEmpty(str)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if ("center_crop".equals(str)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if ("fit_center".equals(str)) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        return ImageView.ScaleType.CENTER_CROP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        super.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (!(this.f395367e instanceof ImageView)) {
            return;
        }
        if ("content".equals(str)) {
            v(str2);
        } else if (DittoImageArea.SCALE_TYPE.equals(str)) {
            ((ImageView) this.f395367e).setScaleType(u(str2));
        }
    }

    protected void v(String str) {
        int i3;
        if (!URLUtil.isValidUrl(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int i16 = this.f395369h;
        if (i16 > 0 && (i3 = this.f395370i) > 0) {
            obtain.mRequestWidth = i16;
            obtain.mRequestHeight = i3;
        }
        obtain.mPlayGifImage = false;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable != null) {
            ((ImageView) this.f395367e).setImageDrawable(drawable);
        }
    }
}
