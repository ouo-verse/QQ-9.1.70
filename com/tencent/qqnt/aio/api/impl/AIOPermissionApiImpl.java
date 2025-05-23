package com.tencent.qqnt.aio.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.api.IAIOPermissionApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOPermissionApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOPermissionApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "business", "", "permissions", "", "notifyType", "Lcom/tencent/qqnt/aio/api/IAIOPermissionApi$a;", "listener", "", "requestPermission", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;ILcom/tencent/qqnt/aio/api/IAIOPermissionApi$a;)V", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOPermissionApiImpl implements IAIOPermissionApi {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOPermissionApiImpl$a", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "c", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends com.tencent.qqnt.aio.shortcutbar.j {
        static IPatchRedirector $redirector_;

        a(IAIOPermissionApi.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            throw null;
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void c(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            throw null;
        }
    }

    public AIOPermissionApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOPermissionApi
    public void requestPermission(@NotNull Activity activity, @NotNull String business, @NotNull String[] permissions, int notifyType, @Nullable IAIOPermissionApi.a listener) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, business, permissions, Integer.valueOf(notifyType), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (listener != null) {
            aVar = new a(listener);
        } else {
            aVar = null;
        }
        com.tencent.mobileqq.aio.shortcurtbar.permission.a.f193758a.a(activity, business, permissions, notifyType, aVar);
    }
}
