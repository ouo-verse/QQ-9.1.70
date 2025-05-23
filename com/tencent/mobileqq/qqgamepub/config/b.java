package com.tencent.mobileqq.qqgamepub.config;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.distribute.data.DistributeConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGameConfigUtilImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/config/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "isFeedByWeb", "I", "c", "()I", "gamePubUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedUrl", "a", "<init>", "()V", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName("feedUrl")
    @NotNull
    private final String feedUrl;

    @SerializedName("gamePubUrl")
    @NotNull
    private final String gamePubUrl;

    @SerializedName("isFeedByWeb")
    private final int isFeedByWeb;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isFeedByWeb = 1;
        this.gamePubUrl = DistributeConstants.GAME_CENTER_URL;
        this.feedUrl = QQGameConfigUtilImpl.DEBUG_FEED_URL;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.feedUrl;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.gamePubUrl;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.isFeedByWeb;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QQGameH5ConfigBean(isFeedByWeb=" + this.isFeedByWeb + ", gamePubUrl='" + this.gamePubUrl + "', feedUrl='" + this.feedUrl + "')";
    }
}
