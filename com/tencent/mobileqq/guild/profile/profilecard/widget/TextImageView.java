package com.tencent.mobileqq.guild.profile.profilecard.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import up1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!B\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b \u0010\"B!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/widget/TextImageView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "e", "Landroid/graphics/drawable/Drawable;", "drawable", "", "width", "height", "a", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "init", h.F, "I", "mStartWidth", "i", "mStartHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTopWidth", BdhLogUtil.LogTag.Tag_Conn, "mTopHeight", "D", "mEndWidth", "E", "mEndHeight", UserInfo.SEX_FEMALE, "mBottomWidth", "G", "mBottomHeight", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TextImageView extends AppCompatTextView {

    /* renamed from: C, reason: from kotlin metadata */
    private int mTopHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int mEndWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int mEndHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private int mBottomWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int mBottomHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mStartWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mStartHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTopWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Drawable drawable, int width, int height) {
        if (drawable != null) {
            drawable.setBounds(0, 0, width, height);
            if (width == 0 || height == 0) {
                double intrinsicHeight = drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth();
                Rect bounds = drawable.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
                if (width == 0 && height != 0) {
                    bounds.right = ((Integer) Double.valueOf(bounds.bottom / intrinsicHeight)).intValue();
                    drawable.setBounds(bounds);
                }
                if (width != 0 && height == 0) {
                    bounds.bottom = ((Integer) Double.valueOf(bounds.right * intrinsicHeight)).intValue();
                    drawable.setBounds(bounds);
                }
            }
        }
    }

    private final void e() {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "compoundDrawablesRelative");
        int length = compoundDrawablesRelative.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            a(compoundDrawablesRelative[3], this.mBottomWidth, this.mBottomHeight);
                        }
                    } else {
                        a(compoundDrawablesRelative[2], this.mEndWidth, this.mEndHeight);
                    }
                } else {
                    a(compoundDrawablesRelative[1], this.mTopWidth, this.mTopHeight);
                }
            } else {
                a(compoundDrawablesRelative[0], this.mStartWidth, this.mStartHeight);
            }
        }
        setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public final void init(@NotNull Context context, @NotNull AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, a.Ob);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le.guild_text_image_view)");
        this.mStartWidth = obtainStyledAttributes.getDimensionPixelOffset(a.Ub, 0);
        this.mStartHeight = obtainStyledAttributes.getDimensionPixelOffset(a.Tb, 0);
        this.mTopWidth = obtainStyledAttributes.getDimensionPixelOffset(a.Wb, 0);
        this.mTopHeight = obtainStyledAttributes.getDimensionPixelOffset(a.Vb, 0);
        this.mEndWidth = obtainStyledAttributes.getDimensionPixelOffset(a.Sb, 0);
        this.mEndHeight = obtainStyledAttributes.getDimensionPixelOffset(a.Rb, 0);
        this.mBottomWidth = obtainStyledAttributes.getDimensionPixelOffset(a.Qb, 0);
        this.mBottomHeight = obtainStyledAttributes.getDimensionPixelOffset(a.Pb, 0);
        obtainStyledAttributes.recycle();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init(context, attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextImageView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init(context, attrs);
    }
}
