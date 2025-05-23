package com.tencent.mobileqq.aio.msglist.holder.component.template.jump;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/b;", "", "url", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "a", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "getMsgItem", "()Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateMsgItem msgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/d$a;", "", "", "appName", "viewName", "", "a", "DEFAULT_TITLE", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.jump.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        public final boolean a(@Nullable String appName, @Nullable String viewName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appName, (Object) viewName)).booleanValue();
            }
            if (Intrinsics.areEqual(appName, "com.tencent.multimsg") && Intrinsics.areEqual(viewName, "contact")) {
                return true;
            }
            return false;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull TemplateMsgItem msgItem) {
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
        return Intrinsics.areEqual(str, "com.tencent.multimsg");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.jump.b
    public boolean b(@NotNull String url, @Nullable Activity activity) {
        String str;
        FragmentActivity fragmentActivity;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) activity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        AIOContact aIOContact = null;
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "com.tencent.multimsg")) {
            return false;
        }
        if (activity == null) {
            QLog.e("TemMsg.MultiMsg", 1, "click multimsg but activity is null!");
            return true;
        }
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            aIOContact = com.tencent.qqnt.aio.utils.a.f352276a.a(fragmentActivity);
        }
        if (aIOContact == null) {
            QLog.e("TemMsg.MultiMsg", 1, "invoke fail\uff0c null aioContact, activity is " + activity);
            return true;
        }
        String j3 = aIOContact.j();
        int e16 = aIOContact.e();
        String e17 = m.f191935a.e(this.msgItem.n2());
        long j16 = this.msgItem.getMsgRecord().msgId;
        try {
            String optString = new JSONObject(e17).optString("source", "\u8f6c\u53d1\u7684\u804a\u5929\u8bb0\u5f55");
            Intrinsics.checkNotNullExpressionValue(optString, "innerDataObject.optString(\"source\", DEFAULT_TITLE)");
            str2 = optString;
        } catch (Exception e18) {
            QLog.e("TemMsg.MultiMsg", 1, "click but parse origin data error:" + e18);
            str2 = "\u8f6c\u53d1\u7684\u804a\u5929\u8bb0\u5f55";
        }
        t.f352318a.d(activity, j3, e16, str2, j16, this.msgItem.getMsgRecord(), new Intent());
        return true;
    }
}
