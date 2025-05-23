package com.tencent.qqnt.aio.adapter.toppopup;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.x;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/toppopup/DebugTopPopupView;", "Lcom/tencent/qqnt/aio/toppopup/a;", "Landroid/content/Context;", "context", "", "uid", "", "param", "", "a", "", "getHeight", "Landroid/widget/FrameLayout;", "f", "Landroid/content/Context;", "mContext", "b", "Lkotlin/Lazy;", "d", "()Landroid/widget/FrameLayout;", "mContent", "Landroid/widget/TextView;", "c", "e", "()Landroid/widget/TextView;", "mPrompt", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DebugTopPopupView implements com.tencent.qqnt.aio.toppopup.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPrompt;

    public DebugTopPopupView() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new DebugTopPopupView$mContent$2(this));
            this.mContent = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.qqnt.aio.adapter.toppopup.DebugTopPopupView$mPrompt$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DebugTopPopupView.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    Context context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    context = DebugTopPopupView.this.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context = null;
                    }
                    TextView textView = new TextView(context);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    textView.setText("AIO\u9876\u90e8Title\u5f39\u7a97");
                    textView.setTextSize(17.0f);
                    textView.setTextColor(-16777216);
                    textView.setGravity(17);
                    return textView;
                }
            });
            this.mPrompt = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final FrameLayout d() {
        return (FrameLayout) this.mContent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView e() {
        return (TextView) this.mPrompt.getValue();
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    public void a(@NotNull Context context, @NotNull String uid, @Nullable Object param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, uid, param);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.mContext = context;
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return d();
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return x.a(50.0f);
    }
}
