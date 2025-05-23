package com.tencent.mobileqq.activity.newsetting.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.business.group.notify.c;
import com.tencent.mobileqq.activity.newsetting.business.group.notify.d;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import java.util.List;

/* loaded from: classes10.dex */
public class NotifyPushSettingView extends CustomSettingBaseView {
    static IPatchRedirector $redirector_;

    public NotifyPushSettingView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.gzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public List<a> g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        List<a> g16 = super.g(context);
        g16.add(new d(context));
        m();
        if (!((IGrowthPushSwitchApi) QRoute.api(IGrowthPushSwitchApi.class)).isContrastGroup()) {
            g16.add(((IGrowthPushSwitchApi) QRoute.api(IGrowthPushSwitchApi.class)).createSettingGroup(context));
        }
        return g16;
    }

    public com.tencent.mobileqq.activity.newsetting.business.group.notify.a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.activity.newsetting.business.group.notify.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (com.tencent.mobileqq.activity.newsetting.business.group.notify.a) b(com.tencent.mobileqq.activity.newsetting.business.group.notify.a.class);
    }

    public c k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (c) b(c.class);
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public QUISettingsRecyclerView e(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        return (QUISettingsRecyclerView) view.findViewById(R.id.f29370lg);
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.wechatMsgAgent.a aVar = (com.tencent.mobileqq.wechatMsgAgent.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105418");
        if (aVar == null || !aVar.f315066d) {
            return false;
        }
        return true;
    }

    public NotifyPushSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public NotifyPushSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
