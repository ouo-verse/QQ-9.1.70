package com.tencent.mobileqq.wink.magicstudio.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/h;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/wink/magicstudio/p;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/p;", "jumpViewModel", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "close", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "title", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/p;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.magicstudio.p jumpViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView close;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    public h(@NotNull com.tencent.mobileqq.wink.magicstudio.p jumpViewModel) {
        Intrinsics.checkNotNullParameter(jumpViewModel, "jumpViewModel");
        this.jumpViewModel = jumpViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(final h this$0, View view) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        ImageView imageView = null;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (findFragmentByTag = supportFragmentManager.findFragmentByTag("AIGC_LOGIC")) != null) {
            MagicStudioLogicFragment.Companion companion = MagicStudioLogicFragment.INSTANCE;
            Activity activity2 = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            companion.c(activity2, findFragmentByTag, new Bundle());
        }
        ImageView imageView2 = this$0.close;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
        } else {
            imageView = imageView2;
        }
        imageView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.view.g
            @Override // java.lang.Runnable
            public final void run() {
                h.B9(h.this);
            }
        }, 300L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(h this$0) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        FragmentActivity fragmentActivity2;
        FragmentManager supportFragmentManager2;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (findFragmentByTag = supportFragmentManager.findFragmentByTag("AIGCImgCreate")) != null) {
            Activity activity2 = this$0.getActivity();
            if (activity2 instanceof FragmentActivity) {
                fragmentActivity2 = (FragmentActivity) activity2;
            } else {
                fragmentActivity2 = null;
            }
            if (fragmentActivity2 != null && (supportFragmentManager2 = fragmentActivity2.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager2.beginTransaction()) != null && (remove = beginTransaction.remove(findFragmentByTag)) != null) {
                remove.commit();
            }
            this$0.jumpViewModel.M1(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.close)");
        ImageView imageView = (ImageView) findViewById;
        this.close = imageView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_chevron_left);
        ImageView imageView2 = this.close;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.A9(h.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.f220202l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.pageTitle)");
        TextView textView2 = (TextView) findViewById2;
        this.title = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            textView = textView2;
        }
        textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
    }
}
