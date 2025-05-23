package com.tencent.mobileqq.guild.util.trace;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/MenuItem;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/guild/util/trace/l;", "subMenu", "", "b", "", "dpValue", "", "a", "d", "I", "padding", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "vImage", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "vTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MenuItem extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int padding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView vImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView vTitle;

    @JvmOverloads
    public MenuItem(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    public final int a(float dpValue) {
        return (int) ((dpValue * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(@NotNull l subMenu) {
        Intrinsics.checkNotNullParameter(subMenu, "subMenu");
        this.vImage.setImageResource(subMenu.getImageRes());
        this.vTitle.setText(subMenu.getTitle());
        setOnClickListener(subMenu.getOnClickListener());
    }

    @JvmOverloads
    public MenuItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MenuItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @JvmOverloads
    public MenuItem(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int a16 = a(5.0f);
        this.padding = a16;
        View.inflate(context, R.layout.f_5, this);
        setGravity(17);
        setOrientation(1);
        setPadding(a16, 0, a16, 0);
        setTranslationY(a(2.0f));
        View findViewById = findViewById(R.id.image);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.vImage = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.title);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.vTitle = (TextView) findViewById2;
    }
}
