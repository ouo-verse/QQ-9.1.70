package com.tencent.qqnt.chats.core.ui.highlight;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class HighLightUtilsKt$highLightView$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ View $view;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HighLightUtilsKt$highLightView$1(View view) {
        super(0);
        this.$view = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        if (view.getParent() != null) {
            view.clearAnimation();
            if (QLog.isColorLevel()) {
                QLog.i("RecentContactItemHolder", 2, "onAnimationEnd-->clearAnimation");
            }
            Object tag = view.getTag(R.id.d26);
            if (tag instanceof Drawable) {
                view.setBackgroundDrawable((Drawable) tag);
                view.setTag(R.id.d26, null);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            final View view = this.$view;
            view.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.highlight.b
                @Override // java.lang.Runnable
                public final void run() {
                    HighLightUtilsKt$highLightView$1.b(view);
                }
            });
        }
    }
}
