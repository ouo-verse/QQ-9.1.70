package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/k;", "", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "arkMsgItem", "", "d", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "c", "b", "a", "", "", "Ljava/util/List;", "SUPPORT_FAV_APP_NAMES", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f191932a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> SUPPORT_FAV_APP_NAMES;

    static {
        List<String> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f191932a = new k();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.tencent.map", "com.tencent.structmsg", "com.tencent.miniapp_01", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP);
        SUPPORT_FAV_APP_NAMES = mutableListOf;
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull com.tencent.mobileqq.aio.msg.template.d templateMsgInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) templateMsgInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(templateMsgInfo, "templateMsgInfo");
        String a16 = templateMsgInfo.a();
        if (a16 == null) {
            return false;
        }
        String b16 = templateMsgInfo.b();
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            b j3 = TemplateMsgConfigManager.f191899a.j(a16, b16);
            if (j3 == null) {
                return false;
            }
            return j3.b();
        }
        return SUPPORT_FAV_APP_NAMES.contains(a16);
    }

    public final boolean b(@NotNull com.tencent.mobileqq.aio.msg.template.d templateMsgInfo) {
        Integer num;
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) templateMsgInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(templateMsgInfo, "templateMsgInfo");
        String a16 = templateMsgInfo.a();
        if (a16 == null) {
            return false;
        }
        com.tencent.mobileqq.aio.msg.template.c c16 = templateMsgInfo.c();
        if (c16 != null) {
            num = c16.a();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            return false;
        }
        TemplateMsgConfigManager templateMsgConfigManager = TemplateMsgConfigManager.f191899a;
        String b16 = templateMsgInfo.b();
        if (b16 == null) {
            b16 = "";
        }
        b j3 = templateMsgConfigManager.j(a16, b16);
        if (j3 == null) {
            return false;
        }
        if (!j3.a()) {
            contains = CollectionsKt___CollectionsKt.contains(j3.e(), templateMsgInfo.f());
            if (!contains) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(@NotNull com.tencent.mobileqq.aio.msg.template.d templateMsgInfo) {
        Integer b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) templateMsgInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(templateMsgInfo, "templateMsgInfo");
        if (!TextUtils.equals(ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP, templateMsgInfo.a())) {
            return true;
        }
        com.tencent.mobileqq.aio.msg.template.c c16 = templateMsgInfo.c();
        boolean z16 = false;
        if (c16 != null && (b16 = c16.b()) != null && b16.intValue() == 1) {
            z16 = true;
        }
        return !z16;
    }

    public final boolean d(@NotNull TemplateMsgItem arkMsgItem) {
        boolean canReplyByFreesia;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arkMsgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
        com.tencent.mobileqq.aio.msg.template.d n26 = arkMsgItem.n2();
        if (n26 == null) {
            return false;
        }
        String a16 = n26.a();
        String str = "";
        if (a16 == null) {
            a16 = "";
        }
        String f16 = n26.f();
        if (f16 == null) {
            f16 = "";
        }
        String b16 = n26.b();
        if (b16 != null) {
            str = b16;
        }
        if (!TextUtils.isEmpty(str)) {
            b j3 = TemplateMsgConfigManager.f191899a.j(a16, str);
            if (j3 == null) {
                return false;
            }
            canReplyByFreesia = j3.c();
        } else {
            canReplyByFreesia = ((IAIOArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOArkApi.class)).canReplyByFreesia(a16, f16);
        }
        if (!canReplyByFreesia) {
            return false;
        }
        int i3 = arkMsgItem.getMsgRecord().chatType;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
                return true;
            }
            return !arkMsgItem.isSelf();
        }
        if (arkMsgItem.getMsgRecord().sendStatus != 2) {
            return false;
        }
        return true;
    }
}
