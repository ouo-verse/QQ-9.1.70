package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001AB'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\n\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001eR\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010$R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001eR\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010$\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildExpandableTextView;", "Landroid/widget/RelativeLayout;", "", "k", "", "text", "g", "j", "l", "t", "", "f", tl.h.F, "setContextText", "maxLine", "setMaxHeight", "Landroid/graphics/drawable/Drawable;", "drawable", "setExpandDrawable", "setCollapseDrawable", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mTvContent", "e", "mTvExpand", "", UserInfo.SEX_FEMALE, "mLineSpaceExtra", "", "Z", "mIsExpand", "i", "Ljava/lang/CharSequence;", "mOriginText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mDrawableSize", "Landroid/content/res/ColorStateList;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/res/ColorStateList;", "mContentColor", "D", "mTipsColor", "E", "mMaxLines", "Landroid/graphics/drawable/Drawable;", "mCollapseDrawable", "G", "mExpandDrawable", "H", "performedByUser", "mTextTotalWidth", "J", "mMeasured", "K", "mTipMarginTop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildExpandableTextView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ColorStateList mContentColor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ColorStateList mTipsColor;

    /* renamed from: E, reason: from kotlin metadata */
    private int mMaxLines;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Drawable mCollapseDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Drawable mExpandDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean performedByUser;

    /* renamed from: I, reason: from kotlin metadata */
    private int mTextTotalWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mMeasured;

    /* renamed from: K, reason: from kotlin metadata */
    private int mTipMarginTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mTvContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mTvExpand;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mLineSpaceExtra;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsExpand;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence mOriginText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mDrawableSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/widget/GuildExpandableTextView$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            GuildExpandableTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            if (GuildExpandableTextView.this.getWidth() != 0) {
                GuildExpandableTextView guildExpandableTextView = GuildExpandableTextView.this;
                guildExpandableTextView.mTextTotalWidth = (guildExpandableTextView.getWidth() - GuildExpandableTextView.this.getPaddingLeft()) - GuildExpandableTextView.this.getPaddingRight();
                QLog.w("GuildExpandableTextView", 1, "\u63a7\u4ef6\u5bbd\u5ea6\uff1a" + GuildExpandableTextView.this.mTextTotalWidth);
                GuildExpandableTextView.this.mMeasured = true;
                GuildExpandableTextView.this.l();
            }
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildExpandableTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int f(CharSequence t16) {
        if (t16 == null) {
            t16 = "";
        }
        CharSequence charSequence = t16;
        TextView textView = this.mTvContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView = null;
        }
        return new StaticLayout(charSequence, textView.getPaint(), this.mTextTotalWidth, Layout.Alignment.ALIGN_NORMAL, 0.0f, this.mLineSpaceExtra, false).getLineCount();
    }

    private final void g(CharSequence text) {
        if (text == null) {
            text = "";
        }
        this.mOriginText = text;
        TextView textView = this.mTvContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView = null;
        }
        textView.setText(this.mOriginText);
        if (!this.mMeasured && getViewTreeObserver() != null) {
            getViewTreeObserver().addOnPreDrawListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildExpandableTextView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.performedByUser = true;
        this$0.j();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        this.mIsExpand = !this.mIsExpand;
        l();
    }

    private final void k() {
        TextView textView = this.mTvExpand;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            textView = null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textView.getLayoutParams());
        layoutParams.topMargin = this.mTipMarginTop;
        layoutParams.addRule(3, R.id.k6s);
        TextView textView3 = this.mTvExpand;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        int f16 = f(this.mOriginText);
        TextView textView = this.mTvContent;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView = null;
        }
        textView.setText(this.mOriginText);
        if (f16 <= this.mMaxLines) {
            TextView textView3 = this.mTvContent;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                textView3 = null;
            }
            textView3.setMaxLines(Integer.MAX_VALUE);
            TextView textView4 = this.mTvExpand;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            } else {
                textView2 = textView4;
            }
            textView2.setVisibility(8);
        } else if (this.mIsExpand) {
            TextView textView5 = this.mTvContent;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                textView5 = null;
            }
            textView5.setMaxLines(Integer.MAX_VALUE);
            TextView textView6 = this.mTvExpand;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.mTvExpand;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
                textView7 = null;
            }
            textView7.setCompoundDrawables(null, null, this.mCollapseDrawable, null);
            TextView textView8 = this.mTvExpand;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            } else {
                textView2 = textView8;
            }
            textView2.setText("\u6536\u8d77");
        } else {
            TextView textView9 = this.mTvContent;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                textView9 = null;
            }
            textView9.setMaxLines(this.mMaxLines);
            TextView textView10 = this.mTvExpand;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
                textView10 = null;
            }
            textView10.setVisibility(0);
            TextView textView11 = this.mTvExpand;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
                textView11 = null;
            }
            textView11.setCompoundDrawables(null, null, this.mExpandDrawable, null);
            TextView textView12 = this.mTvExpand;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            } else {
                textView2 = textView12;
            }
            textView2.setText("\u5c55\u5f00");
        }
        invalidate();
    }

    public final void h() {
        LayoutInflater.from(getContext()).inflate(R.layout.emk, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.k6s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_content)");
        TextView textView = (TextView) findViewById;
        this.mTvContent = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView = null;
        }
        textView.setMaxLines(this.mMaxLines);
        View findViewById2 = findViewById(R.id.f1060867r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_arrow)");
        TextView textView3 = (TextView) findViewById2;
        this.mTvExpand = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            textView3 = null;
        }
        textView3.setTextColor(this.mTipsColor);
        TextView textView4 = this.mTvExpand;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            textView4 = null;
        }
        textView4.setCompoundDrawablePadding(bi.a(5.0f));
        TextView textView5 = this.mTvContent;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView5 = null;
        }
        textView5.setTextColor(this.mContentColor);
        TextView textView6 = this.mTvExpand;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
            textView6 = null;
        }
        textView6.setText("\u5c55\u5f00");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildExpandableTextView.i(GuildExpandableTextView.this, view);
            }
        };
        TextView textView7 = this.mTvExpand;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvExpand");
        } else {
            textView2 = textView7;
        }
        textView2.setOnClickListener(onClickListener);
        k();
    }

    public final void setCollapseDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            this.mCollapseDrawable = drawable;
            Intrinsics.checkNotNull(drawable);
            int i3 = this.mDrawableSize;
            drawable.setBounds(0, 0, i3, i3);
        }
    }

    public final void setContextText(@Nullable CharSequence text) {
        this.performedByUser = false;
        g(text);
    }

    public final void setExpandDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            this.mExpandDrawable = drawable;
            Intrinsics.checkNotNull(drawable);
            int i3 = this.mDrawableSize;
            drawable.setBounds(0, 0, i3, i3);
        }
    }

    public final void setMaxHeight(int maxLine) {
        this.mMaxLines = maxLine;
        TextView textView = this.mTvContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView = null;
        }
        textView.setMaxLines(this.mMaxLines);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildExpandableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildExpandableTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildExpandableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLineSpaceExtra = 30.0f;
        this.mOriginText = "";
        this.mDrawableSize = bi.a(14.0f);
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.BLACK)");
        this.mContentColor = valueOf;
        ColorStateList valueOf2 = ColorStateList.valueOf(SupportMenu.CATEGORY_MASK);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(Color.RED)");
        this.mTipsColor = valueOf2;
        this.mMaxLines = 5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.F3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.GuildExpandableTextView)");
        this.mTipMarginTop = obtainStyledAttributes.getDimensionPixelSize(up1.a.H3, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(up1.a.G3);
        this.mContentColor = colorStateList == null ? this.mContentColor : colorStateList;
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(up1.a.I3);
        this.mTipsColor = colorStateList2 == null ? this.mTipsColor : colorStateList2;
        obtainStyledAttributes.recycle();
        h();
    }
}
