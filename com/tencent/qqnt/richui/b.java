package com.tencent.qqnt.richui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.richui.view.RichImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/richui/b;", "Lcom/tencent/android/androidbypass/richui/view/e;", "Landroid/widget/ImageView;", "j", "", "src", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "c", "", "radius", "roundMode", "e", "", "ratio", "lpWidth", "lpHeight", "i", "Lcom/tencent/qqnt/richui/view/RichImageView;", "b", "Lcom/tencent/qqnt/richui/view/RichImageView;", "imageView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements com.tencent.android.androidbypass.richui.view.e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RichImageView imageView;

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageView = new RichImageView(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.e
    public void c(String src, ImageView.ScaleType scaleType) {
        Unit unit;
        Intrinsics.checkNotNullParameter(src, "src");
        Option option = Option.obtain().setUrl(src).setTargetView(this.imageView).setLoadingDrawable(new ColorDrawable(0));
        if (scaleType != null) {
            this.imageView.setScaleType(scaleType);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        iPicAIOApi.loadPic(option, null);
    }

    @Override // com.tencent.android.androidbypass.richui.view.e
    public void e(int radius, int roundMode) {
        this.imageView.setCornerRadiusAndMode(radius, roundMode);
    }

    @Override // com.tencent.android.androidbypass.richui.view.e
    public void i(float ratio, float lpWidth, float lpHeight) {
        this.imageView.setRatio(ratio, lpWidth, lpHeight);
    }

    @Override // com.tencent.android.androidbypass.richui.view.h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImageView getTextView() {
        return this.imageView;
    }
}
