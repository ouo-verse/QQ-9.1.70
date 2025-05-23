package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/SharePlatformItemView;", "Landroid/widget/LinearLayout;", "", "a", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/e;", "data", "c", "", "textColor", "b", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "name", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SharePlatformItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView name;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharePlatformItemView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.f8w, this);
        View findViewById = findViewById(R.id.x0i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_share_platform_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x0j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_share_platform_name)");
        this.name = (TextView) findViewById2;
        setOrientation(1);
    }

    public final void b(int textColor) {
        TextView textView = this.name;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
            textView = null;
        }
        textView.setTextColor(textColor);
    }

    public final void c(@NotNull SharePlatformItemData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.icon;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setImageResource(data.getPlatformIcon());
        TextView textView2 = this.name;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
        } else {
            textView = textView2;
        }
        textView.setText(data.getPlatformName());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharePlatformItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePlatformItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }
}
