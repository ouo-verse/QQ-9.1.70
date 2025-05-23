package com.tencent.mobileqq.emoticon.data;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/MarketFaceStorageUtil;", "", "()V", "Companion", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class MarketFaceStorageUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/MarketFaceStorageUtil$Companion;", "", "()V", "getAIOPreviewImagePath", "", EmojiManagerServiceProxy.EPID, "eId", "getEmoticonImagePath", "getPanelPreviewImagePath", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final String getAIOPreviewImagePath(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonAIOPreviewPath = MarketFaceConstants.emoticonAIOPreviewPath;
            Intrinsics.checkNotNullExpressionValue(emoticonAIOPreviewPath, "emoticonAIOPreviewPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonAIOPreviewPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String getEmoticonImagePath(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonEncryptPath = MarketFaceConstants.emoticonEncryptPath;
            Intrinsics.checkNotNullExpressionValue(emoticonEncryptPath, "emoticonEncryptPath");
            replace$default = StringsKt__StringsJVMKt.replace$default(emoticonEncryptPath, "[epId]", epId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", eId, false, 4, (Object) null);
            return replace$default2;
        }

        @JvmStatic
        @NotNull
        public final String getPanelPreviewImagePath(@NotNull String epId, @NotNull String eId) {
            String replace$default;
            String replace$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) epId, (Object) eId);
            }
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            String emoticonPreviewPath = MarketFaceConstants.emoticonPreviewPath;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MarketFaceStorageUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String getAIOPreviewImagePath(@NotNull String str, @NotNull String str2) {
        return INSTANCE.getAIOPreviewImagePath(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String getEmoticonImagePath(@NotNull String str, @NotNull String str2) {
        return INSTANCE.getEmoticonImagePath(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String getPanelPreviewImagePath(@NotNull String str, @NotNull String str2) {
        return INSTANCE.getPanelPreviewImagePath(str, str2);
    }
}
