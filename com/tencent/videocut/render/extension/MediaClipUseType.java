package com.tencent.videocut.render.extension;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/render/extension/MediaClipUseType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "OPENING", "ENDING", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class MediaClipUseType {
    private static final /* synthetic */ MediaClipUseType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MediaClipUseType ENDING;
    public static final MediaClipUseType NORMAL;
    public static final MediaClipUseType OPENING;

    @NotNull
    private final String type;

    private static final /* synthetic */ MediaClipUseType[] $values() {
        return new MediaClipUseType[]{NORMAL, OPENING, ENDING};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        NORMAL = new MediaClipUseType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0, QAdPlayStrategyDefine$PlayStrategyKey.NORMAL);
        OPENING = new MediaClipUseType("OPENING", 1, "OPENING");
        ENDING = new MediaClipUseType("ENDING", 2, "ENDING");
        $VALUES = $values();
    }

    MediaClipUseType(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.type = str2;
        }
    }

    public static MediaClipUseType valueOf(String str) {
        return (MediaClipUseType) Enum.valueOf(MediaClipUseType.class, str);
    }

    public static MediaClipUseType[] values() {
        return (MediaClipUseType[]) $VALUES.clone();
    }

    @NotNull
    public final String getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }
}
