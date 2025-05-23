package com.tencent.mobileqq.vip.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.zipanimate.ZipLoadedListener;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "i", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipFrameIconDrawable$doLoadTask$download$1 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ z[] $loaders;
    final /* synthetic */ ArrayList<String> $localFiles;
    final /* synthetic */ VipFrameIconDrawable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFrameIconDrawable$doLoadTask$download$1(z[] zVarArr, VipFrameIconDrawable vipFrameIconDrawable, ArrayList<String> arrayList) {
        super(1);
        this.$loaders = zVarArr;
        this.this$0 = vipFrameIconDrawable;
        this.$localFiles = arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, zVarArr, vipFrameIconDrawable, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CountDownLatch latch, boolean z16) {
        Intrinsics.checkNotNullParameter(latch, "$latch");
        latch.countDown();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        z zVar = this.$loaders[i3];
        String str = this.this$0.B().get(i3);
        Intrinsics.checkNotNullExpressionValue(str, "urlStrs[i]");
        zVar.e(str);
        if (!new File(zVar.c()).exists()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            zVar.g(new ZipLoadedListener() { // from class: com.tencent.mobileqq.vip.api.impl.w
                @Override // cooperation.qzone.zipanimate.ZipLoadedListener
                public final void onZipLoaded(boolean z16) {
                    VipFrameIconDrawable$doLoadTask$download$1.b(countDownLatch, z16);
                }
            });
            zVar.h();
            countDownLatch.await(10L, TimeUnit.SECONDS);
        }
        this.$localFiles.add(zVar.c());
    }
}
