package com.tencent.mobileqq.emoticon;

import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/emoticon/d;", "", "", "type", "serverId", "", "getFullResPath", "Landroid/util/Pair;", "", "getSysFaceFullResPath", "aniStickerPackId", "aniStickerId", "getAniStickerResPath", "getAniStickerLoadingResPath", "resultId", "getAniStickerRandomResultFullResPath", "surpriseId", "isPadLandScape", "getAniStickerSurpriseFullResPath", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/emoticon/d$a;", "", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.d$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f204733a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31139);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f204733a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(31145), (Class<?>) d.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f204733a;
        }
    }

    @NotNull
    String getAniStickerLoadingResPath(int serverId);

    @NotNull
    String getAniStickerRandomResultFullResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId, @NotNull String resultId);

    @NotNull
    String getAniStickerResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId);

    @NotNull
    String getAniStickerSurpriseFullResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId, @NotNull String surpriseId, boolean isPadLandScape);

    @NotNull
    String getFullResPath(int type, int serverId);

    @NotNull
    Pair<String, Boolean> getSysFaceFullResPath(int type, int serverId);
}
