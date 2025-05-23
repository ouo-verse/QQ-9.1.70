package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildSettingMuteAllItemLayout;", "Landroid/widget/RelativeLayout;", "Landroid/util/AttributeSet;", "attr", "", "a", "b", "", "title", "setTitle", "value", HippyTextInputController.COMMAND_setValue, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textTitle", "e", "textValue", "Landroid/view/View;", "f", "Landroid/view/View;", "imgArrow", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingMuteAllItemLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textValue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View imgArrow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSettingMuteAllItemLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(AttributeSet attr) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attr, up1.a.Z4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026SettingMuteAllItemLayout)");
        setTitle(obtainStyledAttributes.getString(up1.a.f439420a5));
    }

    private final void b() {
        View findViewById = findViewById(R.id.wrl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_mute_all_title)");
        this.textTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.wrm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_mute_all_value)");
        this.textValue = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.wrk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_mute_all_arrow)");
        this.imgArrow = findViewById3;
    }

    public final void setTitle(@Nullable String title) {
        TextView textView = this.textTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTitle");
            textView = null;
        }
        textView.setText(title);
    }

    public final void setValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TextView textView = this.textValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textValue");
            textView = null;
        }
        textView.setText(value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSettingMuteAllItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildSettingMuteAllItemLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSettingMuteAllItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.f_i, this);
        b();
        a(attributeSet);
    }
}
