package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0004\u0010\u001a\"\u0004\b\f\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/tianshu/observer/a;", "", "", "toString", "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "path", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "b", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "getRedDotInfo", "()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "setRedDotInfo", "(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V", "redDotInfo", "c", "getRedNumberInfo", "setRedNumberInfo", "redNumberInfo", "", "d", "Z", "()Z", "(Z)V", ViewStickEventHelper.IS_SHOW, "argPath", "argDotInfo", "argNumberInfo", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo redDotInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BusinessInfoCheckUpdate.AppInfo redNumberInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    public a(@NotNull String argPath, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo2) {
        Intrinsics.checkNotNullParameter(argPath, "argPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, argPath, appInfo, appInfo2);
            return;
        }
        this.path = argPath;
        this.redDotInfo = appInfo;
        this.redNumberInfo = appInfo2;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isShow;
    }

    public final void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isShow = z16;
        }
    }

    @NotNull
    public String toString() {
        PBUInt64Field pBUInt64Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("path");
        sb5.append(this.path);
        sb5.append("redDotVersion");
        BusinessInfoCheckUpdate.AppInfo appInfo = this.redDotInfo;
        PBUInt64Field pBUInt64Field2 = null;
        if (appInfo != null) {
            pBUInt64Field = appInfo.version;
        } else {
            pBUInt64Field = null;
        }
        sb5.append(pBUInt64Field);
        sb5.append("redNumberVersion");
        BusinessInfoCheckUpdate.AppInfo appInfo2 = this.redNumberInfo;
        if (appInfo2 != null) {
            pBUInt64Field2 = appInfo2.version;
        }
        sb5.append(pBUInt64Field2);
        return sb5.toString();
    }
}
