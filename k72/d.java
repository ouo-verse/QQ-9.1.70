package k72;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.detailcard.b;
import com.tencent.mobileqq.mutualmark.widget.detailcard.i;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lk72/d;", "Landroid/app/Dialog;", "", "e", "show", "dismiss", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "model", "k72/d$b", "Lk72/d$b;", "onButtonGroupClickListener", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;)V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerInteractiveMarkModel model;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b onButtonGroupClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J.\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"k72/d$b", "Lcom/tencent/mobileqq/mutualmark/widget/detailcard/b$d;", "Landroid/view/View;", "v", "", "url", "Lcom/tencent/mobileqq/mutualmark/model/MutualMarkModel$Button;", "button", "", com.tencent.luggage.wxa.c8.c.G, "", "b", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements b.d {
        b() {
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.b.d
        public boolean a(View v3, String url, MutualMarkModel.Button button, int pos) {
            return false;
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.b.d
        public boolean b(View v3, String url, MutualMarkModel.Button button, int pos) {
            com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a.i(d.this.model.level, d.this.model.subtype);
            d.this.dismiss();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context ctx, QQStrangerInteractiveMarkModel model) {
        super(ctx, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        b bVar = new b();
        this.onButtonGroupClickListener = bVar;
        e();
        FrameLayout frameLayout = new FrameLayout(ctx);
        frameLayout.setBackgroundResource(R.color.f7243q);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: k72.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(d.this, view);
            }
        });
        View inflate = LayoutInflater.from(ctx).inflate(R.layout.f168825gz2, (ViewGroup) frameLayout, false);
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: k72.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g16;
                g16 = d.g(view, motionEvent);
                return g16;
            }
        });
        View findViewById = inflate.findViewById(R.id.f166366zl0);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: k72.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.h(d.this, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        layoutParams2 = layoutParams2 == null ? new FrameLayout.LayoutParams(l.b(320), l.b(k.CTRL_INDEX)) : layoutParams2;
        layoutParams2.gravity = 17;
        inflate.setLayoutParams(layoutParams2);
        i iVar = new i(ctx, inflate);
        iVar.q(com.tencent.mobileqq.matchfriend.reborn.mark.c.g(model));
        iVar.t(bVar);
        frameLayout.addView(inflate);
        setContentView(frameLayout);
    }

    private final void e() {
        Window window = getWindow();
        if (window == null) {
            QLog.d("RelationShipGainMutualMarkDetailDialog", 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        window.getAttributes().gravity = 17;
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("RelationShipGainMutualMarkDetailDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }
}
