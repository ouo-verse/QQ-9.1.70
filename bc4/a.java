package bc4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lbc4/a;", "", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "b", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "", "c", "[I", "getOffset", "()[I", "offset", "", "d", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", SecretUtils.DES, "<init>", "(Landroid/content/Context;Landroid/view/View;[ILjava/lang/String;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int[] offset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String des;

    public a(Context context, View view, int[] offset, String des) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(des, "des");
        this.context = context;
        this.view = view;
        this.offset = offset;
        this.des = des;
    }

    public void a() {
        QLog.d("NormalTipsAction", 1, "tips=" + this.des);
        if (this.des.length() == 0) {
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.dgl, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026y_reward_tips_view, null)");
        ((TextView) inflate.findViewById(R.id.qr5)).setText(this.des);
        inflate.measure(0, 0);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        int[] iArr = new int[2];
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        this.view.getLocationOnScreen(iArr);
        View view = this.view;
        int width = (iArr[0] + (view.getWidth() / 2)) - (measuredWidth / 2);
        int[] iArr2 = this.offset;
        popupWindow.showAtLocation(view, 0, width + iArr2[0], (iArr[1] - measuredHeight) + iArr2[1]);
    }
}
