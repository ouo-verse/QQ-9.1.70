package com.tencent.mobileqq.springhb.preload;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/e;", "Lcom/tencent/mobileqq/springhb/preload/g;", "", "", "", "keyDrawableIdMap", "", "f", "keyPathMap", "e", "keyUrlMap", "g", tl.h.F, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final e f289500f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f289500f = new e();
        }
    }

    e() {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.springhb.preload.g
    public void e(@NotNull Map<String, String> keyPathMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) keyPathMap);
        } else {
            Intrinsics.checkNotNullParameter(keyPathMap, "keyPathMap");
        }
    }

    @Override // com.tencent.mobileqq.springhb.preload.g
    public void f(@NotNull Map<String, Integer> keyDrawableIdMap) {
        Map<? extends String, ? extends Integer> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyDrawableIdMap);
            return;
        }
        Intrinsics.checkNotNullParameter(keyDrawableIdMap, "keyDrawableIdMap");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("spring_detail_prize_cash_bg.png", Integer.valueOf(R.drawable.o3o)), TuplesKt.to("spring_detail_logo_golden_border.png", Integer.valueOf(R.drawable.o3m)), TuplesKt.to("spring_detail_merchant_logo_default.png", Integer.valueOf(R.drawable.o3n)), TuplesKt.to("spring_detail_video_mute_off.png", Integer.valueOf(R.drawable.mgz)), TuplesKt.to("spring_detail_video_mute_on.png", Integer.valueOf(R.drawable.f162482mh0)), TuplesKt.to("spring_detail_prize_video_play_btn.png", Integer.valueOf(R.drawable.mgy)));
        keyDrawableIdMap.putAll(mapOf);
    }

    @Override // com.tencent.mobileqq.springhb.preload.g
    public void g(@NotNull Map<String, String> keyUrlMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) keyUrlMap);
        } else {
            Intrinsics.checkNotNullParameter(keyUrlMap, "keyUrlMap");
        }
    }

    @Override // com.tencent.mobileqq.springhb.preload.g
    public void h(@NotNull Map<String, String> keyUrlMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) keyUrlMap);
        } else {
            Intrinsics.checkNotNullParameter(keyUrlMap, "keyUrlMap");
        }
    }
}
