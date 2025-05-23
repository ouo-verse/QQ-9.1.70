package com.tencent.mobileqq.qqnews.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqnews.api.IQQNewsCommApi;
import com.tencent.mobileqq.qqnews.utils.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J4\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqnews/api/impl/QQNewsCommApiImpl;", "Lcom/tencent/mobileqq/qqnews/api/IQQNewsCommApi;", "()V", "isQQNewsPa", "", "uin", "", "startHippy", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startQQNewsPA", "startQQNewsPAIfMatched", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQNewsCommApiImpl implements IQQNewsCommApi {
    static IPatchRedirector $redirector_;

    public QQNewsCommApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsCommApi
    public boolean isQQNewsPa(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return Intrinsics.areEqual(uin, "2909288299");
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsCommApi
    public boolean startHippy(@NotNull Context context, @NotNull HashMap<String, String> attrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attrs)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (attrs.get(OpenHippyInfo.EXTRA_KEY_BUNDLE_URL) != null) {
            return new OpenHippyInfo(attrs).openHippy(context);
        }
        return c.j(context, null, 2, null);
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsCommApi
    public boolean startQQNewsPA(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return c.j(context, null, 2, null);
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsCommApi
    public boolean startQQNewsPAIfMatched(@NotNull Context context, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (isQQNewsPa(uin)) {
            return startQQNewsPA(context);
        }
        return false;
    }
}
