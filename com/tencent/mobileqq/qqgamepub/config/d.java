package com.tencent.mobileqq.qqgamepub.config;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR2\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/config/d;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "pushMsgSwitch", "I", "c", "()I", "setPushMsgSwitch", "(I)V", "pushMsgInterval", "b", "setPushMsgInterval", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "interceptAdIdList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setInterceptAdIdList", "(Ljava/util/ArrayList;)V", "<init>", "()V", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName("interceptAdIdList")
    @NotNull
    private ArrayList<String> interceptAdIdList;

    @SerializedName("pushMsgInterval")
    private int pushMsgInterval;

    @SerializedName("pushMsgSwitch")
    private int pushMsgSwitch;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pushMsgSwitch = 1;
        this.pushMsgInterval = 60;
        this.interceptAdIdList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.interceptAdIdList;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.pushMsgInterval;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.pushMsgSwitch;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "QQGamePushConfigBean(pushMsgSwitch=" + this.pushMsgSwitch + ", pushMsgInterval=" + this.pushMsgInterval + ", interceptAdIdList=" + this.interceptAdIdList + ')';
    }
}
