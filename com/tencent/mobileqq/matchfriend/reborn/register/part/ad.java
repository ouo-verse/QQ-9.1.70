package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/ad;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "B9", "D9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "partRootView", "Landroid/view/View$OnTouchListener;", "e", "Landroid/view/View$OnTouchListener;", "buttonTouchListener", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ad extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View partRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View.OnTouchListener buttonTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.ac
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean A9;
            A9 = ad.A9(view, motionEvent);
            return A9;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A9(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    private final void B9() {
        View view = this.partRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.oig);
        findViewById.setOnTouchListener(this.buttonTouchListener);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ad.C9(ad.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(ad this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
    }

    private final void D9() {
        int i3 = QQTheme.isNowThemeIsNight() ? R.drawable.g5d : R.drawable.f159756g54;
        View view = this.partRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        ((ImageView) view.findViewById(R.id.ork)).setBackground(getContext().getResources().getDrawable(i3));
    }

    private final void E9() {
        B9();
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QQStrangerRegisterTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        View findViewById = rootView != null ? rootView.findViewById(R.id.oqi) : null;
        if (findViewById == null) {
            return;
        }
        this.partRootView = findViewById;
        E9();
    }
}
