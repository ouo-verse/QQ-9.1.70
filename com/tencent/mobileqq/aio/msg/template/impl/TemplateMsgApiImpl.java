package com.tencent.mobileqq.aio.msg.template.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.aio.msg.template.a;
import com.tencent.mobileqq.aio.msglist.holder.component.template.business.e;
import com.tencent.mobileqq.aio.msglist.holder.component.template.freesia.TemplateMsgFreesiaConfigParser;
import com.tencent.mobileqq.aio.msglist.holder.component.template.freesia.TemplateMsgRemoteSwitch;
import com.tencent.mobileqq.aio.msglist.holder.component.template.share.TemplateMsgView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0019\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/impl/TemplateMsgApiImpl;", "Lcom/tencent/mobileqq/aio/msg/template/ITemplateMsgApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/template/a;", "createTemplateMsgView", "", "appName", "bizName", "viewName", "", "isTemplateMsg", "isDebug", "", "setIsDebug", "getIsDebug", "", "msgRecordChatType", "convertMsgRecordChatType", "(Ljava/lang/Integer;)I", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/freesia/TemplateMsgRemoteSwitch;", "getConfig", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgApiImpl implements ITemplateMsgApi {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/template/impl/TemplateMsgApiImpl$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.template.impl.TemplateMsgApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57718);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TemplateMsgApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi
    public int convertMsgRecordChatType(@Nullable Integer msgRecordChatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgRecordChatType)).intValue();
        }
        if (msgRecordChatType == null) {
            return -1;
        }
        msgRecordChatType.intValue();
        int intValue = msgRecordChatType.intValue();
        int i3 = 2;
        if (intValue != 1) {
            if (intValue == 2) {
                return 3;
            }
            i3 = 4;
            if (intValue != 3) {
                if (intValue != 4) {
                    if (intValue != 100) {
                        if (intValue != 113) {
                            if (intValue == 103) {
                                return 1;
                            }
                            if (intValue != 104) {
                                return -1;
                            }
                            return 8;
                        }
                        return 9;
                    }
                    return 5;
                }
                return 7;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi
    @Nullable
    public a createTemplateMsgView(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        if (context == null) {
            return null;
        }
        return new TemplateMsgView(context, null, 0, 6, null);
    }

    @NotNull
    public final TemplateMsgRemoteSwitch getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TemplateMsgRemoteSwitch) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return TemplateMsgFreesiaConfigParser.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi
    public boolean getIsDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isTemplateMsg(@Nullable String appName, @Nullable String bizName, @Nullable String viewName) {
        boolean z16;
        boolean z17;
        boolean contains;
        boolean contains2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appName, bizName, viewName)).booleanValue();
        }
        TemplateMsgRemoteSwitch config = getConfig();
        if (!config.isTotalUse()) {
            return false;
        }
        if (e.INSTANCE.a(appName, viewName) && config.getForceOldMiniApp()) {
            return true;
        }
        List<String> appNames = getConfig().getAppNames();
        if (appNames != null) {
            contains2 = CollectionsKt___CollectionsKt.contains(appNames, appName);
            if (contains2) {
                z16 = true;
                if (!z16) {
                    List<String> bizNameList = getConfig().getBizNameList();
                    if (bizNameList != null) {
                        contains = CollectionsKt___CollectionsKt.contains(bizNameList, bizName);
                        if (contains) {
                            z17 = true;
                            if (!z17) {
                                return false;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi
    public void setIsDebug(boolean isDebug) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isDebug);
        } else {
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a.f(isDebug);
        }
    }
}
