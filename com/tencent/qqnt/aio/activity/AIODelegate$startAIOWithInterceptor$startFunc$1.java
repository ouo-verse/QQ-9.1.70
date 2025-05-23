package com.tencent.qqnt.aio.activity;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/activity/AIODelegate$startAIOWithInterceptor$startFunc$1", "Lkotlin/Function0;", "", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIODelegate$startAIOWithInterceptor$startFunc$1 implements Function0<Unit> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f348432d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AIODelegate f348433e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f348434f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f348435h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f348436i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIODelegate$startAIOWithInterceptor$startFunc$1(int i3, AIODelegate aIODelegate, String str, String str2, boolean z16) {
        this.f348432d = i3;
        this.f348433e = aIODelegate;
        this.f348434f = str;
        this.f348435h = str2;
        this.f348436i = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), aIODelegate, str, str2, Boolean.valueOf(z16));
        }
    }

    public void a() {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.interceptor.g a16 = com.tencent.qqnt.aio.interceptor.a.f351159a.a(this.f348432d);
        if (a16 != null) {
            AIODelegate aIODelegate = this.f348433e;
            int i3 = this.f348432d;
            String str = this.f348434f;
            String str2 = this.f348435h;
            long currentTimeMillis = System.currentTimeMillis();
            Object E = aIODelegate.E();
            if (E instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) E;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1(aIODelegate, i3, a16, currentTimeMillis, str, str2, null), 3, null);
            }
        }
        this.f348433e.x(this.f348434f, this.f348435h, this.f348432d, this.f348436i);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        a();
        return Unit.INSTANCE;
    }
}
