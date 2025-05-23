package com.tencent.mobileqq.qqlive.room.gamedownloader.card;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "SUBSCRIBE_FROM_GAME_CENTER", "SUBSCRIBE_FROM_CUSTOM_H5", "DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY", "DOWNLOAD_FROM_GAME_CENTER", "DOWNLOAD_FROM_CUSTOM_H5", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class CardMode {
    private static final /* synthetic */ CardMode[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final CardMode DOWNLOAD_FROM_CUSTOM_H5;
    public static final CardMode DOWNLOAD_FROM_GAME_CENTER;
    public static final CardMode DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY;
    public static final CardMode SUBSCRIBE_FROM_CUSTOM_H5;
    public static final CardMode SUBSCRIBE_FROM_GAME_CENTER;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode$a;", "", "", "taskType", "androidSubscribeModel", "androidDownloadModel", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode;", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.gamedownloader.card.CardMode$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        public final CardMode a(int taskType, int androidSubscribeModel, int androidDownloadModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CardMode) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(taskType), Integer.valueOf(androidSubscribeModel), Integer.valueOf(androidDownloadModel));
            }
            if (taskType == 1) {
                if (androidSubscribeModel == 1) {
                    return CardMode.SUBSCRIBE_FROM_GAME_CENTER;
                }
                return CardMode.SUBSCRIBE_FROM_CUSTOM_H5;
            }
            if (androidDownloadModel != 1) {
                if (androidDownloadModel != 2) {
                    return CardMode.DOWNLOAD_FROM_CUSTOM_H5;
                }
                return CardMode.DOWNLOAD_FROM_GAME_CENTER;
            }
            return CardMode.DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ CardMode[] $values() {
        return new CardMode[]{SUBSCRIBE_FROM_GAME_CENTER, SUBSCRIBE_FROM_CUSTOM_H5, DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY, DOWNLOAD_FROM_GAME_CENTER, DOWNLOAD_FROM_CUSTOM_H5};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SUBSCRIBE_FROM_GAME_CENTER = new CardMode("SUBSCRIBE_FROM_GAME_CENTER", 0, 1);
        SUBSCRIBE_FROM_CUSTOM_H5 = new CardMode("SUBSCRIBE_FROM_CUSTOM_H5", 1, 2);
        DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY = new CardMode("DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY", 2, 1);
        DOWNLOAD_FROM_GAME_CENTER = new CardMode("DOWNLOAD_FROM_GAME_CENTER", 3, 2);
        DOWNLOAD_FROM_CUSTOM_H5 = new CardMode("DOWNLOAD_FROM_CUSTOM_H5", 4, 3);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    CardMode(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static CardMode valueOf(String str) {
        return (CardMode) Enum.valueOf(CardMode.class, str);
    }

    public static CardMode[] values() {
        return (CardMode[]) $VALUES.clone();
    }
}
