package com.tencent.mobileqq.qqlive.widget.input;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/TimiInputUtil;", "", "", "isLand", "", "d", "", "height", "", "e", "c", "b", "Lkotlin/Lazy;", "()I", "defaultKeyBoardHeightPortrait", "a", "defaultKeyBoardHeightLand", "I", "keyboardHeight", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TimiInputUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TimiInputUtil f273991a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy defaultKeyBoardHeightPortrait;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy defaultKeyBoardHeightLand;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int keyboardHeight;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f273991a = new TimiInputUtil();
        lazy = LazyKt__LazyJVMKt.lazy(TimiInputUtil$defaultKeyBoardHeightPortrait$2.INSTANCE);
        defaultKeyBoardHeightPortrait = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TimiInputUtil$defaultKeyBoardHeightLand$2.INSTANCE);
        defaultKeyBoardHeightLand = lazy2;
        keyboardHeight = -1;
    }

    TimiInputUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a() {
        return ((Number) defaultKeyBoardHeightLand.getValue()).intValue();
    }

    private final int b() {
        return ((Number) defaultKeyBoardHeightPortrait.getValue()).intValue();
    }

    private final String d(boolean isLand) {
        String str;
        if (isLand) {
            str = "land";
        } else {
            str = "portrait";
        }
        return "key_timi_game_keyboard_height_" + str;
    }

    public final int c(boolean isLand) {
        int b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, isLand)).intValue();
        }
        if (keyboardHeight == -1) {
            if (isLand) {
                b16 = a();
            } else {
                b16 = b();
            }
            keyboardHeight = ct3.a.g(d(isLand), b16);
        }
        return keyboardHeight;
    }

    public final void e(int height, boolean isLand) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(height), Boolean.valueOf(isLand));
        } else {
            keyboardHeight = height;
            ct3.a.p(d(isLand), height);
        }
    }
}
