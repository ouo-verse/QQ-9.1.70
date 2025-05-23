package com.tencent.qqnt.richui;

import android.content.Context;
import com.tencent.android.androidbypass.richui.view.g;
import com.tencent.android.androidbypass.richui.view.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/richui/e;", "Lcom/tencent/android/androidbypass/richui/view/i;", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/c;", "d", "Lcom/tencent/android/androidbypass/richui/view/d;", "c", "Lcom/tencent/android/androidbypass/richui/view/e;", "b", "Lcom/tencent/android/androidbypass/richui/view/f;", "a", "Lcom/tencent/android/androidbypass/richui/view/g;", "e", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final e f362064a = new e();

    e() {
    }

    @Override // com.tencent.android.androidbypass.richui.view.i
    public com.tencent.android.androidbypass.richui.view.f a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new c(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.i
    public com.tencent.android.androidbypass.richui.view.e b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.i
    public com.tencent.android.androidbypass.richui.view.d c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CircularProgressDelegate(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.i
    public com.tencent.android.androidbypass.richui.view.c d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(context);
    }

    @Override // com.tencent.android.androidbypass.richui.view.i
    public g e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new f(context);
    }
}
