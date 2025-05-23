package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0011\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSQUIPersonalEditTitlePart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "title", "A9", "getLogTag", "z9", "", "onBackEvent", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "mTitleBar", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "x9", "()Ljava/lang/Runnable;", "setMRightRunnable", "(Ljava/lang/Runnable;)V", "mRightRunnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSQUIPersonalEditTitlePart extends com.tencent.biz.qqcircle.immersive.part.u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "QFSQUIPersonalEditTitlePart";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar mTitleBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mRightRunnable;

    public final void A9(@Nullable String title) {
        QUISecNavBar qUISecNavBar = this.mTitleBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setCenterText(title);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        z9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f55572i_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_title)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.mTitleBar = qUISecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left);
        QUISecNavBar qUISecNavBar3 = this.mTitleBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            qUISecNavBar3 = null;
        }
        qUISecNavBar3.setAutoAdaptTransparent(true);
        QUISecNavBar qUISecNavBar4 = this.mTitleBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            qUISecNavBar4 = null;
        }
        qUISecNavBar4.setTitleAlpha(0.0f);
        QUISecNavBar qUISecNavBar5 = this.mTitleBar;
        if (qUISecNavBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            qUISecNavBar2 = qUISecNavBar5;
        }
        qUISecNavBar2.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSQUIPersonalEditTitlePart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view, @NotNull BaseAction baseAction) {
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                    QFSQUIPersonalEditTitlePart.this.z9();
                } else {
                    if (baseAction != BaseAction.ACTION_RIGHT_TEXT || QFSQUIPersonalEditTitlePart.this.getMRightRunnable() == null) {
                        return;
                    }
                    Runnable mRightRunnable = QFSQUIPersonalEditTitlePart.this.getMRightRunnable();
                    Intrinsics.checkNotNull(mRightRunnable);
                    mRightRunnable.run();
                }
            }
        });
    }

    @Nullable
    /* renamed from: x9, reason: from getter */
    public final Runnable getMRightRunnable() {
        return this.mRightRunnable;
    }

    public final void z9() {
        getActivity().finish();
    }
}
