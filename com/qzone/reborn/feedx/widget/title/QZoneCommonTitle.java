package com.qzone.reborn.feedx.widget.title;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import uh.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0014\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\u001c\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "Landroid/widget/FrameLayout;", "", "j", "", "forceTxtDark", "i", "Luh/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "c", "e", "Landroid/view/ViewGroup;", "view", "d", "k", "g", h.F, "enable", "setProgressBarEnable", "", "height", "setupTitleHeight", "Z", "mIsProgressBarEnable", "Landroid/view/View;", "mProgressBar", "", "f", "Ljava/util/Map;", "mRightItemCache", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBtnBack", "mTitleHost", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setMCenterTitle", "(Landroid/widget/TextView;)V", "mCenterTitle", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mRightBtnContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommonTitle extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup mRightBtnContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsProgressBarEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mProgressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, d> mRightItemCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mBtnBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mTitleHost;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mCenterTitle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommonTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZoneCommonTitle this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(boolean forceTxtDark) {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ImmersiveUtils.setStatusTextColor(forceTxtDark, ((Activity) context).getWindow());
        }
    }

    public final View c(d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FadeIconImageView fadeIconImageView = new FadeIconImageView(getContext());
        AccessibilityUtil.s(fadeIconImageView, item.getContentDescription());
        fadeIconImageView.setImageResource(item.getDrawableId());
        fadeIconImageView.setOnClickListener(item.getOnClickListener());
        fadeIconImageView.setOnLongClickListener(item.getOnLongClickListener());
        fadeIconImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ef.d.b(25), ef.d.b(25));
        layoutParams.setMargins(ef.d.b(10), 0, 0, 0);
        fadeIconImageView.setLayoutParams(layoutParams);
        this.mRightBtnContainer.addView(fadeIconImageView);
        this.mRightItemCache.put(Integer.valueOf(this.mRightBtnContainer.getChildCount() - 1), item);
        return fadeIconImageView;
    }

    public final void d(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mRightBtnContainer.addView(view);
    }

    public final View e(d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = new TextView(getContext());
        textView.setGravity(1);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        textView.setOnClickListener(item.getOnClickListener());
        textView.setText(item.getContentDescription());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, ef.d.b(2), 0);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        this.mRightBtnContainer.addView(textView);
        this.mRightItemCache.put(Integer.valueOf(this.mRightBtnContainer.getChildCount() - 1), item);
        return textView;
    }

    /* renamed from: f, reason: from getter */
    public final TextView getMCenterTitle() {
        return this.mCenterTitle;
    }

    public final void g() {
        if (this.mIsProgressBarEnable) {
            if (this.mProgressBar == null) {
                h();
            }
            View view = this.mProgressBar;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public final void k() {
        if (this.mIsProgressBarEnable) {
            if (this.mProgressBar == null) {
                h();
            }
            View view = this.mProgressBar;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    public final void setMCenterTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mCenterTitle = textView;
    }

    public final void setProgressBarEnable(boolean enable) {
        this.mIsProgressBarEnable = enable;
        View view = this.mProgressBar;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void setupTitleHeight(int height) {
        if (getLayoutParams() == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, height));
        } else {
            getLayoutParams().height = height;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommonTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void j() {
        i(true);
        this.mBtnBack.setImageResource(R.drawable.qui_chevron_left_icon_nav_secondary);
        for (Map.Entry<Integer, d> entry : this.mRightItemCache.entrySet()) {
            int intValue = entry.getKey().intValue();
            d value = entry.getValue();
            View childAt = this.mRightBtnContainer.getChildAt(intValue);
            if (childAt instanceof ImageView) {
                ((ImageView) childAt).setImageResource(value.getDrawableId());
            }
        }
    }

    public /* synthetic */ QZoneCommonTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneCommonTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsProgressBarEnable = true;
        this.mRightItemCache = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.f129546c, this);
        View findViewById = findViewById(R.id.mt9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_common_title_container)");
        this.mTitleHost = findViewById;
        View findViewById2 = findViewById(R.id.mt8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_common_title_back)");
        this.mBtnBack = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.mtb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_common_title_text)");
        this.mCenterTitle = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.mta);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_\u2026itle_right_btn_container)");
        this.mRightBtnContainer = (ViewGroup) findViewById4;
        this.mTitleHost.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: uh.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneCommonTitle.b(QZoneCommonTitle.this, view);
            }
        });
        j();
        AccessibilityUtil.s(this.mBtnBack, HardCodeUtil.qqStr(R.string.f2201668d));
    }

    public final void h() {
        this.mProgressBar = ((ViewStub) findViewById(R.id.mt_)).inflate();
    }
}
