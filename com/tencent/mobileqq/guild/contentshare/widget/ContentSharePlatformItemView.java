package com.tencent.mobileqq.guild.contentshare.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yg1.ItemData;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/widget/ContentSharePlatformItemView;", "Landroid/widget/LinearLayout;", "", "c", "d", "", "color", "b", "Lyg1/a;", "data", "e", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "name", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ContentSharePlatformItemView extends LinearLayout {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final int f216376h = Color.parseColor("#ff222222");

    /* renamed from: i, reason: collision with root package name */
    private static final int f216377i = Color.parseColor("#ffffffff");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView name;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/widget/ContentSharePlatformItemView$a;", "", "", "LIGHT_TEXT_COLOR", "I", "a", "()I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.contentshare.widget.ContentSharePlatformItemView$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ContentSharePlatformItemView.f216377i;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentSharePlatformItemView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.f8w, this);
        View findViewById = findViewById(R.id.x0i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_share_platform_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x0j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_share_platform_name)");
        this.name = (TextView) findViewById2;
        setOrientation(1);
        ImageView imageView = this.icon;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.guild_qr_code_button_bg_selector);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TextView textView2 = this.name;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
        } else {
            textView = textView2;
        }
        guildUIUtils.b(textView, R.color.qui_common_text_primary);
        d();
    }

    private final void d() {
        boolean z16;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "this.resources.displayMetrics");
        float f16 = displayMetrics.density / FontSettingManager.systemMetrics.density;
        if (f16 == 1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        TextView textView = this.name;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
            textView = null;
        }
        TextView textView3 = this.name;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
        } else {
            textView2 = textView3;
        }
        textView.setTextSize(ViewUtils.pxTosp(textView2.getTextSize()) / f16);
    }

    public final void b(int color) {
        TextView textView = this.name;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
            textView = null;
        }
        textView.setTextColor(color);
    }

    public final void e(@NotNull ItemData data) {
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
    public ContentSharePlatformItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentSharePlatformItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }
}
