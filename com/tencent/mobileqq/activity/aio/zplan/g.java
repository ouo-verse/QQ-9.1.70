package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/g;", "Landroid/widget/PopupWindow;", "Landroid/widget/TextView;", "b", "Landroid/widget/ImageView;", "a", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "bubbleContentView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends PopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View bubbleContentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169210i92, (ViewGroup) null);
        this.bubbleContentView = inflate;
        setContentView(inflate);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(ContextCompat.getDrawable(context, 17170445));
    }

    @Nullable
    public final ImageView a() {
        return (ImageView) getContentView().findViewById(R.id.ti6);
    }

    @Nullable
    public final TextView b() {
        return (TextView) getContentView().findViewById(R.id.ti_);
    }
}
