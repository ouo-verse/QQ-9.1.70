package hl3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lhl3/a;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "a", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "v", NodeProps.ON_CLICK, "Landroid/widget/Button;", "d", "Landroid/widget/Button;", "knowBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends Dialog implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Button knowBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.f2432309);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dbf, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        a(view);
        setContentView(view);
        setCanceledOnTouchOutside(false);
    }

    private final void a(View view) {
        Button button = (Button) view.findViewById(R.id.r8u);
        this.knowBtn = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
    }
}
