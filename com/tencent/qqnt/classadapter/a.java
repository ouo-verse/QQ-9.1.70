package com.tencent.qqnt.classadapter;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/classadapter/a;", "", "", "a", NodeProps.ENABLED, "", "b", "Ljava/lang/Boolean;", "getSIsSpecialCareBarEnabled", "()Ljava/lang/Boolean;", "setSIsSpecialCareBarEnabled", "(Ljava/lang/Boolean;)V", "sIsSpecialCareBarEnabled", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355682a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean sIsSpecialCareBarEnabled;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355682a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a() {
        Boolean bool = sIsSpecialCareBarEnabled;
        if (bool == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof BaseQQAppInterface) {
                bool = Boolean.valueOf(SettingCloneUtil.readValue((Context) peekAppRuntime.getApplication(), peekAppRuntime.getCurrentUin(), (String) null, AppConstants.QQSETTING_SPECIAL_CARE_BAR, true));
            } else {
                bool = Boolean.TRUE;
            }
            sIsSpecialCareBarEnabled = bool;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static final void b(boolean enabled) {
        sIsSpecialCareBarEnabled = Boolean.valueOf(enabled);
    }
}
