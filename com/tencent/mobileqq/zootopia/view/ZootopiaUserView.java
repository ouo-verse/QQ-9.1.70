package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.data.ZootopiaUserData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaUserView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/sqshow/zootopia/data/z;", "userData", "", "a", "Lfi3/ah;", "d", "Lfi3/ah;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaUserView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final fi3.ah binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaUserView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(ZootopiaUserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (TextUtils.isEmpty(userData.getAvatar())) {
            if (userData.getDefaultDarkStyle()) {
                this.binding.f398812b.setImageResource(R.drawable.ik6);
            } else {
                this.binding.f398812b.setImageResource(R.drawable.ik7);
            }
        } else {
            this.binding.f398812b.setImageDrawable(URLDrawable.getDrawable(userData.getAvatar(), obtain));
        }
        this.binding.f398814d.setText(userData.getName());
        if (TextUtils.isEmpty(userData.getLabel())) {
            this.binding.f398813c.setVisibility(8);
        } else {
            this.binding.f398813c.setVisibility(0);
            this.binding.f398813c.setText(userData.getLabel());
        }
        if (TextUtils.isEmpty(userData.getSubText())) {
            this.binding.f398815e.setVisibility(8);
        } else {
            this.binding.f398815e.setVisibility(0);
            this.binding.f398815e.setText(userData.getSubText());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaUserView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaUserView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.ah f16 = fi3.ah.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(0);
    }
}
