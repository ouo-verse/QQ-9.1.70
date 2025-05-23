package com.tencent.square.debugger;

import android.content.Context;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/square/debugger/FormSwitchItem;", "Landroid/widget/RelativeLayout;", "", "c", "b", "a", "", "checked", "d", "", "text", IECSearchBar.METHOD_SET_TEXT, "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "l", "setOnCheckedChangeListener", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTextView", "Landroid/widget/Switch;", "e", "Landroid/widget/Switch;", "mSwitch", "", "f", "I", "marginDp", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FormSwitchItem extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Switch mSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int marginDp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSwitchItem(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.marginDp = ViewExtensionsKt.dip(context, 10.0f);
        c();
    }

    private final void a() {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setTrackResource(R.drawable.gwg);
        }
    }

    private final void b() {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setChecked(false);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mSwitch, layoutParams);
        a();
    }

    public final void d(boolean checked) {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setChecked(checked);
            sendAccessibilityEvent(1);
        }
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setOnCheckedChangeListener(l3);
        }
    }

    public final void setText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(text);
        }
    }

    private final void c() {
        setBackgroundColor(-16776961);
        TextView textView = new TextView(getContext());
        textView.setSingleLine(true);
        textView.setTextSize(0, ViewExtensionsKt.dip(textView.getContext(), 20.0f));
        textView.setGravity(19);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(-1);
        Unit unit = Unit.INSTANCE;
        this.mTextView = textView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        int i3 = this.marginDp;
        layoutParams.setMargins(i3, i3, i3, i3);
        addView(this.mTextView, layoutParams);
        this.mSwitch = new Switch(getContext());
        b();
    }
}
