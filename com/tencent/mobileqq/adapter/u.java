package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/adapter/u;", "", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "a", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "()Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "bean", "<init>", "(Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QQSettingMeBizBean bean;

    public u(@Nullable QQSettingMeBizBean qQSettingMeBizBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeBizBean);
        } else {
            this.bean = qQSettingMeBizBean;
        }
    }

    @Nullable
    public final QQSettingMeBizBean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQSettingMeBizBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bean;
    }
}
