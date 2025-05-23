package com.tencent.qqnt.richui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.android.androidbypass.richui.view.g;
import com.tencent.mobileqq.text.QQText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/richui/f;", "Lcom/tencent/android/androidbypass/richui/view/g;", "Landroid/widget/TextView;", "j", "", "text", "", "emoSize", "", h.F, "b", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    public f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.textView = new TextView(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.g
    public void h(String text, int emoSize) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.textView.setText(new QQText(text, 3, emoSize));
    }

    @Override // com.tencent.android.androidbypass.richui.view.h
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public TextView getView() {
        return this.textView;
    }
}
