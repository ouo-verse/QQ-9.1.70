package com.tencent.mobileqq.zootopia.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/z;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "d", "Z", "cancelable", "e", "cancelableOnTouchOutSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class z extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean cancelable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean cancelableOnTouchOutSize;

    public /* synthetic */ z(Context context, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        super.onCreate(savedInstanceState);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.d8r, (ViewGroup) null);
        Window window = getWindow();
        if (window != null) {
            window.setContentView(inflate);
        }
        Window window2 = getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 17;
        }
        setCanceledOnTouchOutside(this.cancelableOnTouchOutSize);
        setCancelable(this.cancelable);
        Window window3 = getWindow();
        if (window3 != null) {
            window3.addFlags(Integer.MIN_VALUE);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.addFlags(67108864);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setStatusBarColor(0);
        }
        ImmersiveUtils.setTranslucentStatus(getWindow());
        Window window6 = getWindow();
        if (window6 != null) {
            com.tencent.sqshow.zootopia.utils.r.c(window6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context, boolean z16, boolean z17) {
        super(context, R.style.f2432006);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cancelable = z16;
        this.cancelableOnTouchOutSize = z17;
    }
}
