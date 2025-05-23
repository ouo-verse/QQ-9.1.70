package com.tencent.mobileqq.vas.profilecard.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.profilecard.VasTipsData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/view/VasProfileTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonView", "Landroid/widget/TextView;", "leftIcon", "Landroid/widget/ImageView;", "listener", "Lcom/tencent/mobileqq/vas/profilecard/view/OnTipsClickListener;", "vipTipsText", VasPerfReportUtils.WHILE_UPDATE_ITEM, "", "data", "Lcom/tencent/mobileqq/vas/profilecard/VasTipsData;", "isDiy", "", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasProfileTipsView extends RelativeLayout {

    @NotNull
    private TextView buttonView;

    @NotNull
    private ImageView leftIcon;

    @Nullable
    private OnTipsClickListener listener;

    @NotNull
    private TextView vipTipsText;
    private static final int DP_8 = ViewUtils.dpToPx(8.0f);
    private static final int DP_6 = ViewUtils.dpToPx(6.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VasProfileTipsView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(VasProfileTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnTipsClickListener onTipsClickListener = this$0.listener;
        if (onTipsClickListener != null) {
            onTipsClickListener.onCloseClick();
        }
        this$0.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void updateView(@Nullable VasTipsData data, boolean isDiy, @NotNull OnTipsClickListener listener) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String picBg;
        int dpToPx;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (data != null) {
            boolean z26 = true;
            if (data.getLeftIcon().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (data.getPicBg().length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (data.getDiyPicBg().length() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        if (data.getTextContent().length() == 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (!z19) {
                            this.listener = listener;
                            ImageView imageView = this.leftIcon;
                            a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
                            VasDynamicDrawableCache vasDynamicDrawableCache = VasDynamicDrawableCache.INSTANCE;
                            imageView.setImageDrawable(a16.l(vasDynamicDrawableCache).k(data.getLeftIcon()).a());
                            TextView textView = this.vipTipsText;
                            textView.setText(data.getTextContent());
                            textView.setTextColor(data.getTextColor());
                            TextView textView2 = this.buttonView;
                            if (data.getRightButtonText().length() != 0) {
                                z26 = false;
                            }
                            if (z26) {
                                this.buttonView.setVisibility(8);
                            }
                            textView2.setText(data.getRightButtonText());
                            textView2.setTextColor(data.getRightButtonColor());
                            textView2.setBackground(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(vasDynamicDrawableCache).k(data.getButtonBg()).a());
                            a.C1005a l3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(vasDynamicDrawableCache);
                            if (isDiy) {
                                picBg = data.getDiyPicBg();
                            } else {
                                picBg = data.getPicBg();
                            }
                            setBackground(l3.k(picBg).a());
                            ViewGroup.LayoutParams layoutParams = getLayoutParams();
                            ViewGroup.LayoutParams layoutParams2 = layoutParams;
                            if (layoutParams == null) {
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                                layoutParams3.height = ViewUtils.dpToPx(42.0f);
                                if (isDiy) {
                                    dpToPx = ViewUtils.dpToPx(359.0f);
                                } else {
                                    dpToPx = ViewUtils.dpToPx(303.0f);
                                }
                                layoutParams3.width = dpToPx;
                                layoutParams2 = layoutParams3;
                            }
                            setLayoutParams(layoutParams2);
                            setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    public /* synthetic */ VasProfileTipsView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VasProfileTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.yhn);
        this.leftIcon = imageView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(56.0f), ViewUtils.dpToPx(40.0f));
        layoutParams.topMargin = ViewUtils.dpToPx(2.0f);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ngg));
        imageView2.setId(R.id.azb);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(21);
        int i3 = DP_8;
        layoutParams2.rightMargin = i3;
        layoutParams2.leftMargin = ViewUtils.dpToPx(16.0f);
        TextView textView = new TextView(context);
        textView.setDuplicateParentStateEnabled(true);
        textView.setSingleLine(true);
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        textView.setMaxEms(4);
        textView.setId(R.id.f74583wn);
        this.buttonView = textView;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(68.0f), ViewUtils.dpToPx(24.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, imageView2.getId());
        layoutParams3.leftMargin = i3;
        TextView textView2 = new TextView(context);
        textView2.setDuplicateParentStateEnabled(true);
        textView2.setSingleLine(true);
        textView2.setTextColor(-16777216);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView2.setGravity(3);
        textView2.setTextSize(12.0f);
        textView2.setSelected(true);
        textView2.setFocusable(true);
        textView2.setMarqueeRepeatLimit(-1);
        this.vipTipsText = textView2;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, this.buttonView.getId());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.addView(this.vipTipsText, layoutParams4);
        relativeLayout.addView(imageView2, layoutParams2);
        relativeLayout.addView(this.buttonView, layoutParams3);
        addView(this.leftIcon, layoutParams);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(36.0f));
        layoutParams5.topMargin = DP_6;
        layoutParams5.addRule(1, this.leftIcon.getId());
        Unit unit = Unit.INSTANCE;
        addView(relativeLayout, layoutParams5);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.profilecard.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasProfileTipsView._init_$lambda$9(VasProfileTipsView.this, view);
            }
        });
    }
}
