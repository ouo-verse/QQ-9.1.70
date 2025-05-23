package com.tencent.mobileqq.activity.newsetting.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.business.group.general.b;
import com.tencent.mobileqq.activity.newsetting.business.group.general.c;
import com.tencent.mobileqq.activity.newsetting.business.group.general.d;
import com.tencent.mobileqq.activity.newsetting.business.group.general.e;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GeneralSettingView extends CustomSettingBaseView {
    static IPatchRedirector $redirector_;

    public GeneralSettingView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public QUIListItemStyle c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QUIListItemStyle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return super.c();
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public RecyclerView e(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        return (RecyclerView) view.findViewById(R.id.vnh);
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.gzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public List<a> g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        List<a> g16 = super.g(context);
        g16.add(new c(context));
        g16.add(new d(context));
        g16.add(new b(context));
        g16.add(new com.tencent.mobileqq.activity.newsetting.business.group.general.a(context));
        g16.add(new e(context));
        return g16;
    }

    public d j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (d) b(d.class);
    }

    public com.tencent.mobileqq.activity.newsetting.business.group.general.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.activity.newsetting.business.group.general.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (com.tencent.mobileqq.activity.newsetting.business.group.general.a) b(com.tencent.mobileqq.activity.newsetting.business.group.general.a.class);
    }

    public b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (b) b(b.class);
    }

    public c m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (c) b(c.class);
    }

    public e n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (e) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (e) b(e.class);
    }

    public GeneralSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GeneralSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
