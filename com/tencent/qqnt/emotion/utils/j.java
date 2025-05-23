package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/emotion/utils/j;", "", "a", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/utils/j$a;", "", "", EmojiManagerServiceProxy.EPID, "eId", "f", "a", "c", "e", "b", "d", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.utils.j$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final String a(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonAIOPreviewPath = com.tencent.qqnt.emotion.constant.d.f356215m;
            Intrinsics.checkNotNullExpressionValue(emoticonAIOPreviewPath, "emoticonAIOPreviewPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonAIOPreviewPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String b(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonAPNGPath = com.tencent.qqnt.emotion.constant.d.f356211i;
            Intrinsics.checkNotNullExpressionValue(emoticonAPNGPath, "emoticonAPNGPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonAPNGPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String c(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonImagePath = com.tencent.qqnt.emotion.constant.d.f356212j;
            Intrinsics.checkNotNullExpressionValue(emoticonImagePath, "emoticonImagePath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonImagePath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String d(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonSoundPath = com.tencent.qqnt.emotion.constant.d.f356217o;
            Intrinsics.checkNotNullExpressionValue(emoticonSoundPath, "emoticonSoundPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonSoundPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String e(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonImagePath = com.tencent.qqnt.emotion.constant.d.f356212j;
            Intrinsics.checkNotNullExpressionValue(emoticonImagePath, "emoticonImagePath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonImagePath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String f(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonPreviewPath = com.tencent.qqnt.emotion.constant.d.f356216n;
            Intrinsics.checkNotNullExpressionValue(emoticonPreviewPath, "emoticonPreviewPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonPreviewPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String str, @NotNull String str2) {
        return INSTANCE.a(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String str, @NotNull String str2) {
        return INSTANCE.b(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull String str, @NotNull String str2) {
        return INSTANCE.c(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String d(@NotNull String str, @NotNull String str2) {
        return INSTANCE.d(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull String str, @NotNull String str2) {
        return INSTANCE.e(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String f(@NotNull String str, @NotNull String str2) {
        return INSTANCE.f(str, str2);
    }
}
