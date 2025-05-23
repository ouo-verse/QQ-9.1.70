package com.tencent.qqnt.graytips.decoder;

import android.util.SparseArray;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/GrayTipsDecoderProvider;", "Lyv3/a;", "Landroid/util/SparseArray;", "Lcom/tencent/qqnt/graytips/decoder/f;", "b", "<init>", "()V", "c", "a", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GrayTipsDecoderProvider implements yv3.a<SparseArray<f>> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<SparseArray<f>> f356824d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/GrayTipsDecoderProvider$a;", "", "Landroid/util/SparseArray;", "Lcom/tencent/qqnt/graytips/decoder/f;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Landroid/util/SparseArray;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.decoder.GrayTipsDecoderProvider$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final SparseArray<f> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (SparseArray) GrayTipsDecoderProvider.f356824d.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<SparseArray<f>> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(GrayTipsDecoderProvider$Companion$instance$2.INSTANCE);
        f356824d = lazy;
    }

    public GrayTipsDecoderProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public SparseArray<f> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SparseArray<f> sparseArray = new SparseArray<>();
        sparseArray.put(4, new e());
        sparseArray.put(5, new b());
        sparseArray.put(1, new g());
        sparseArray.put(14, new a());
        sparseArray.put(10, new c());
        return sparseArray;
    }
}
