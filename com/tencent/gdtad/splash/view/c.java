package com.tencent.gdtad.splash.view;

import android.view.View;
import com.qq.e.tg.splash.adapter.TGSplashInterPage;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.event.OlympicInterPageCloseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/gdtad/splash/view/c;", "", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", "mInterView", "Lcom/qq/e/tg/splash/adapter/TGSplashInterPage$ViewClickListener;", "Lcom/qq/e/tg/splash/adapter/TGSplashInterPage$ViewClickListener;", "a", "()Lcom/qq/e/tg/splash/adapter/TGSplashInterPage$ViewClickListener;", "setMCloseListener", "(Lcom/qq/e/tg/splash/adapter/TGSplashInterPage$ViewClickListener;)V", "mCloseListener", "<init>", "()V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static View mInterView;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f109468a = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static TGSplashInterPage.ViewClickListener mCloseListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/gdtad/splash/view/c$a", "Lcom/qq/e/tg/splash/adapter/TGSplashInterPage$ViewClickListener;", "", "p0", "", "onClose", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements TGSplashInterPage.ViewClickListener {
        a() {
        }

        @Override // com.qq.e.tg.splash.adapter.TGSplashInterPage.ViewClickListener
        public void onClose(int p06) {
            SimpleEventBus.getInstance().dispatchEvent(new OlympicInterPageCloseEvent());
        }
    }

    c() {
    }

    @NotNull
    public final TGSplashInterPage.ViewClickListener a() {
        return mCloseListener;
    }

    @Nullable
    public final View b() {
        return mInterView;
    }

    public final void c(@Nullable View view) {
        mInterView = view;
    }
}
