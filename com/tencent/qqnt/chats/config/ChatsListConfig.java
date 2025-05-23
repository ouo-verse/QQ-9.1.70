package com.tencent.qqnt.chats.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u001a\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u001c\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/config/ChatsListConfig;", "", "", "b", "Lkotlin/Lazy;", "a", "()Z", "alphaAnimSwitch", "c", "enableAnim", "d", "enableAvatarCacheReset", "e", "enableAvatarInvalidate", "f", "i", "enableTitleQQTxt", "g", h.F, "enableSaveRestoreState", "getEnableChangeItemUpdate", "enableChangeItemUpdate", "enablePreItemAnim", "j", "enableTroopHelperItemAnim", "k", "enableKeepRepo", "l", "enableRegistSwipe", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsListConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatsListConfig f354433a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy alphaAnimSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAvatarCacheReset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAvatarInvalidate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableTitleQQTxt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableSaveRestoreState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableChangeItemUpdate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enablePreItemAnim;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableTroopHelperItemAnim;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableKeepRepo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableRegistSwipe;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f354433a = new ChatsListConfig();
        lazy = LazyKt__LazyJVMKt.lazy(ChatsListConfig$alphaAnimSwitch$2.INSTANCE);
        alphaAnimSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ChatsListConfig$enableAnim$2.INSTANCE);
        enableAnim = lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableAvatarCacheReset$2.INSTANCE);
        enableAvatarCacheReset = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableAvatarInvalidate$2.INSTANCE);
        enableAvatarInvalidate = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(ChatsListConfig$enableTitleQQTxt$2.INSTANCE);
        enableTitleQQTxt = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableSaveRestoreState$2.INSTANCE);
        enableSaveRestoreState = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableChangeItemUpdate$2.INSTANCE);
        enableChangeItemUpdate = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(ChatsListConfig$enablePreItemAnim$2.INSTANCE);
        enablePreItemAnim = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableTroopHelperItemAnim$2.INSTANCE);
        enableTroopHelperItemAnim = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableKeepRepo$2.INSTANCE);
        enableKeepRepo = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatsListConfig$enableRegistSwipe$2.INSTANCE);
        enableRegistSwipe = lazy11;
    }

    ChatsListConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) alphaAnimSwitch.getValue()).booleanValue();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAnim.getValue()).booleanValue();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAvatarCacheReset.getValue()).booleanValue();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAvatarInvalidate.getValue()).booleanValue();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((Boolean) enableKeepRepo.getValue()).booleanValue();
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ((Boolean) enablePreItemAnim.getValue()).booleanValue();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return ((Boolean) enableRegistSwipe.getValue()).booleanValue();
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return ((Boolean) enableSaveRestoreState.getValue()).booleanValue();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return ((Boolean) enableTitleQQTxt.getValue()).booleanValue();
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return ((Boolean) enableTroopHelperItemAnim.getValue()).booleanValue();
    }
}
