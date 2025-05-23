package com.tencent.mobileqq.activity.newsetting.business.view.c2c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.b;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.c;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.d;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SpecialCareSettingView extends CustomSettingBaseView {
    static IPatchRedirector $redirector_;

    public SpecialCareSettingView(@NonNull Context context) {
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
        return R.layout.e27;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    protected List<a> g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        List<a> g16 = super.g(context);
        g16.add(new b(context));
        g16.add(new d(context));
        g16.add(new com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a(context));
        g16.add(new c(context));
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public QUISettingsRecyclerView e(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        return (QUISettingsRecyclerView) view.findViewById(R.id.ttq);
    }

    public com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a) b(com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a.class);
    }

    public b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (b) b(b.class);
    }

    public c m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (c) b(c.class);
    }

    public d n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (d) b(d.class);
    }

    public SpecialCareSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SpecialCareSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
