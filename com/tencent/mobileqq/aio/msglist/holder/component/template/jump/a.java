package com.tencent.mobileqq.aio.msglist.holder.component.template.jump;

import android.app.Activity;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/b;", "", "url", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "a", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "getMsgItem", "()Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateMsgItem msgItem;

    public a(@NotNull TemplateMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
        } else {
            this.msgItem = msgItem;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.jump.b
    public boolean a(@NotNull String url) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "com.tencent.miniapp_01");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.jump.b
    public boolean b(@NotNull String url, @Nullable Activity activity) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) activity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (activity == null) {
            QLog.e("AIOMsgItem", 1, "handleUrl but activity is null");
            return false;
        }
        com.tencent.qqnt.aio.adapter.api.b bVar = new com.tencent.qqnt.aio.adapter.api.b();
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        if (n26 == null || (str = n26.a()) == null) {
            str = "";
        }
        bVar.f(str);
        com.tencent.mobileqq.aio.msg.template.d n27 = this.msgItem.n2();
        if (n27 != null) {
            str2 = n27.b();
        } else {
            str2 = null;
        }
        bVar.g(str2);
        ((IAIOArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOArkApi.class)).jumpUrl(url, this.msgItem.getMsgRecord(), activity, bVar);
        return true;
    }
}
