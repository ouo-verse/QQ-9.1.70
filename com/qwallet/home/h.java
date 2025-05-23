package com.qwallet.home;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.home.NativePopViewModel;
import com.qwallet.home.b;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/qwallet/home/h;", "Lcom/qwallet/home/b;", "", "initView", "W", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mImageView", "H", "mCloseBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class h extends com.qwallet.home.b {

    /* renamed from: F, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private View mCloseBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qwallet/home/h$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + 100, ViewUtils.dip2px(12.0f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context) {
        super(context, R.style.azk);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void W() {
        boolean z16;
        NativePopViewModel.PopInfo mPopInfo = getMPopInfo();
        if (mPopInfo == null) {
            dismiss();
            return;
        }
        URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(mPopInfo.getImageUrl());
        ImageView imageView = this.mImageView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
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
        ImageView imageView2 = this.mImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView2 = null;
        }
        imageView2.setContentDescription(title);
        ImageView imageView3 = this.mImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView3 = null;
        }
        imageView3.setOutlineProvider(new b());
        ImageView imageView4 = this.mImageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView4 = null;
        }
        imageView4.setClipToOutline(true);
        ImageView imageView5 = this.mImageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView5 = null;
        }
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.home.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.X(h.this, view2);
            }
        });
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.home.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                h.Y(h.this, view3);
            }
        });
        View view3 = this.mCloseBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseBtn");
        } else {
            view = view3;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.home.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                h.Z(h.this, view4);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qwallet.home.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                h.a0(h.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(h this$0, View view) {
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
    public static final void Y(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.InterfaceC0306b mListener = this$0.getMListener();
        if (mListener != null) {
            mListener.a("click_other");
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.InterfaceC0306b mListener = this$0.getMListener();
        if (mListener != null) {
            mListener.a("click_close");
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(h this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.InterfaceC0306b mListener = this$0.getMListener();
        if (mListener != null) {
            mListener.a("cancel");
        }
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f67643dw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qwallet_pop_root)");
        this.mRootView = findViewById;
        View findViewById2 = findViewById(R.id.f67633dv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qwallet_pop_img)");
        this.mImageView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f67613dt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qwallet_pop_close_btn)");
        this.mCloseBtn = findViewById3;
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setLayout(-1, -1);
        }
        setContentView(R.layout.hjz);
        setCanceledOnTouchOutside(true);
        initView();
        W();
    }
}
