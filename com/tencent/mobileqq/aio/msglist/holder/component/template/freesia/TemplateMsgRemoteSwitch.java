package com.tencent.mobileqq.aio.msglist.holder.component.template.freesia;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u000eR&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgRemoteSwitch;", "Lcom/tencent/freesia/IConfigData;", "()V", "appNames", "", "", "getAppNames", "()Ljava/util/List;", "setAppNames", "(Ljava/util/List;)V", "bizNameList", "getBizNameList", "setBizNameList", "forceOldMiniApp", "", "getForceOldMiniApp", "()Z", "setForceOldMiniApp", "(Z)V", "totalSwitch", "", "getTotalSwitch", "()I", "setTotalSwitch", "(I)V", "isTotalUse", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class TemplateMsgRemoteSwitch implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName("app_name")
    @Nullable
    private List<String> appNames;

    @SerializedName(QCircleDaTongConstant.ElementParamKey.XSJ_BIZ_NAME)
    @Nullable
    private List<String> bizNameList;

    @SerializedName("trans_old_mini")
    private boolean forceOldMiniApp;

    @SerializedName("use_markdown_render")
    private int totalSwitch;

    public TemplateMsgRemoteSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.bizNameList = new ArrayList();
        this.appNames = new ArrayList();
        this.forceOldMiniApp = true;
    }

    @Nullable
    public final List<String> getAppNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.appNames;
    }

    @Nullable
    public final List<String> getBizNameList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bizNameList;
    }

    public final boolean getForceOldMiniApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.forceOldMiniApp;
    }

    public final int getTotalSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.totalSwitch;
    }

    public final boolean isTotalUse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.totalSwitch == 1) {
            return true;
        }
        return false;
    }

    public final void setAppNames(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.appNames = list;
        }
    }

    public final void setBizNameList(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.bizNameList = list;
        }
    }

    public final void setForceOldMiniApp(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.forceOldMiniApp = z16;
        }
    }

    public final void setTotalSwitch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.totalSwitch = i3;
        }
    }
}
