package a7;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.homepage.diy.jsoninflate.widget.DIYAsyncImageView;
import com.qzone.widget.AsyncImageView;
import com.tencent.ditto.widget.DittoImageArea;
import e15.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends f {
    private AsyncImageView C;

    public a(String str, View view) {
        super(str, view);
        if (view == null || !(view instanceof DIYAsyncImageView)) {
            return;
        }
        this.C = ((DIYAsyncImageView) view).a();
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

    @Override // e15.f
    public void p() {
        super.p();
        View view = this.f395367e;
        if (view == null || this.C == null) {
            return;
        }
        if (view.getParent() != null && (this.f395367e.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f395367e.getParent()).setClipChildren(false);
        }
        ViewGroup.LayoutParams layoutParams = this.f395367e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
        if (layoutParams == null || layoutParams2 == null) {
            return;
        }
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.C.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (this.C == null) {
            return;
        }
        if ("content".equals(str)) {
            this.C.setAsyncImage(str2);
        } else if (DittoImageArea.SCALE_TYPE.equals(str)) {
            this.C.setScaleType(u(str2));
        }
    }
}
