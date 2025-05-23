package com.tencent.robot.adelie.homepage.mine.part.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0014J*\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/section/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "La24/e;", "Landroid/view/View;", "view", "", "height", "", "p", "", "getViewStubLayoutId", "containerView", "onInitView", "data", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "loadingContainer", tl.h.F, "Landroid/view/View;", "rootContainer", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends Section<a24.e> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView iconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout loadingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootContainer;

    private final void p(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        TextView textView;
        ImageView imageView;
        this.rootContainer = containerView;
        LinearLayout linearLayout = null;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.yt9);
        } else {
            textView = null;
        }
        this.textView = textView;
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.ysu);
        } else {
            imageView = null;
        }
        this.iconView = imageView;
        if (containerView != null) {
            linearLayout = (LinearLayout) containerView.findViewById(R.id.ef_);
        }
        this.loadingContainer = linearLayout;
        if (containerView != null) {
            ImageView imageView2 = this.iconView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(LoadingUtil.getLoadingDrawable(containerView.getContext(), 2));
            }
            FontSettingManager.resetViewSize2Normal(containerView.getContext(), this.loadingContainer);
        }
        QLog.i("AdelieCreateCenterItemFooterSection", 1, "onInitView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable a24.e data, int position, @Nullable List<Object> payload) {
        String str;
        if (data != null) {
            int i3 = 8;
            if (data.getNeedHide()) {
                View view = this.rootContainer;
                if (view != null) {
                    p(view, c24.a.a(8));
                }
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                View view2 = this.rootContainer;
                if (view2 != null) {
                    p(view2, c24.a.a(44));
                }
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.textView;
                if (textView3 != null) {
                    if (data.getIsEnd()) {
                        str = "\u6ca1\u6709\u66f4\u591a\u4e86";
                    } else {
                        str = "\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019\u2026";
                    }
                    textView3.setText(str);
                }
                ImageView imageView2 = this.iconView;
                if (imageView2 != null) {
                    if (!data.getIsEnd()) {
                        i3 = 0;
                    }
                    imageView2.setVisibility(i3);
                }
            }
        }
        QLog.i("AdelieCreateCenterItemFooterSection", 1, "Data=" + data);
    }
}
