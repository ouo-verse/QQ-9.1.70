package com.qwallet.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.home.NativePopViewModel;
import com.qwallet.home.b;
import com.qwallet.utils.QWalletUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/qwallet/home/PopDialog;", "Lcom/qwallet/home/b;", "", "initView", "W", "Lcom/qwallet/home/NativePopViewModel$b;", "popInfo", "U", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mImage", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mCountdownText", "Landroid/view/View;", "H", "Landroid/view/View;", "mCloseBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class PopDialog extends b {

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mImage;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mCountdownText;

    /* renamed from: H, reason: from kotlin metadata */
    private View mCloseBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopDialog(@NotNull Context context) {
        super(context, R.style.azk);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void U(NativePopViewModel.PopInfo popInfo) {
        Ref.IntRef intRef = new Ref.IntRef();
        int min = Math.min(popInfo.getShowSeconds(), 60);
        intRef.element = min;
        TextView textView = null;
        if (min == 0) {
            TextView textView2 = this.mCountdownText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCountdownText");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mCountdownText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCountdownText");
        } else {
            textView = textView3;
        }
        QWalletUtils.v(textView, 13.0f);
        BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new PopDialog$initCountdown$1(intRef, baseTimer, this), 0L, 1000L);
    }

    private final void W() {
        boolean z16;
        NativePopViewModel.PopInfo mPopInfo = getMPopInfo();
        if (mPopInfo == null) {
            dismiss();
            return;
        }
        View view = null;
        URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(mPopInfo.getImageUrl(), null, null);
        U(mPopInfo);
        ImageView imageView = this.mImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            imageView = null;
        }
        imageView.setImageDrawable(netDrawableForQWallet);
        String title = mPopInfo.getTitle();
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            title = getContext().getString(R.string.f2174260z);
            Intrinsics.checkNotNullExpressionValue(title, "context.getString(com.te\u2026let_home_pop_description)");
        }
        ImageView imageView2 = this.mImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            imageView2 = null;
        }
        imageView2.setContentDescription(title);
        ImageView imageView3 = this.mImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            imageView3 = null;
        }
        QWalletUtils.v(imageView3, 6.0f);
        ImageView imageView4 = this.mImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImage");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.home.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PopDialog.X(PopDialog.this, view2);
            }
        });
        View view2 = this.mCloseBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.home.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PopDialog.Y(PopDialog.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(PopDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.InterfaceC0306b mListener = this$0.getMListener();
        if (mListener != null) {
            mListener.onClick();
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(PopDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.InterfaceC0306b mListener = this$0.getMListener();
        if (mListener != null) {
            mListener.a("click_close");
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f67633dv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qwallet_pop_img)");
        this.mImage = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f67623du);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qwallet_pop_countdown)");
        this.mCountdownText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f67613dt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qwallet_pop_close_btn)");
        this.mCloseBtn = findViewById3;
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f168981hk0);
        setCanceledOnTouchOutside(false);
        initView();
        W();
    }
}
