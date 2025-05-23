package ng2;

import android.content.Context;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.api.IECToast;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\n\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lng2/a;", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "Landroid/content/Context;", "context", "", "msg", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "icon", "", "duration", "makeText", "", "show", "mode", "showQToast", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECToast {
    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    public IECToast makeText(Context context, CharSequence msg2, ECToastIcon icon, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(icon, "icon");
        QCircleToast.k(icon.getIcon(), msg2.toString(), duration, true);
        return this;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    public void showQToast(Context context, CharSequence msg2, int mode) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (mode != 0) {
            i3 = 2;
            if (mode != 1) {
                if (mode == 2) {
                    i3 = 1;
                }
            }
            QQToast.makeText(context, i3, msg2, 0).show();
        }
        i3 = 0;
        QQToast.makeText(context, i3, msg2, 0).show();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    public void show() {
    }
}
