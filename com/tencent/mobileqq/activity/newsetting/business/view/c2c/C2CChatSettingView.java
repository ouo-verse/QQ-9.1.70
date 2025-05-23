package com.tencent.mobileqq.activity.newsetting.business.view.c2c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.b;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.c;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.d;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.e;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.f;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.g;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.h;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.i;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class C2CChatSettingView extends CustomSettingBaseView {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f183641f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f183642h;

    /* renamed from: i, reason: collision with root package name */
    private View f183643i;

    /* renamed from: m, reason: collision with root package name */
    private QUISettingsRecyclerView f183644m;

    public C2CChatSettingView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        super.a(view);
        this.f183641f = (ViewGroup) view.findViewById(R.id.iem);
        this.f183642h = (TextView) view.findViewById(R.id.ien);
        this.f183643i = view.findViewById(R.id.ieg);
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.e2d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    public List<a> g(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        List<a> g16 = super.g(context);
        g16.add(new f(context));
        g16.add(new c(context));
        g16.add(new h(context));
        g16.add(new g(context));
        g16.add(new b(context));
        g16.add(new e(context));
        g16.add(new i(context));
        g16.add((a) ((IRobotExtApi) QRoute.api(IRobotExtApi.class)).createRobotSettingGroup(context));
        g16.add(new d(context));
        g16.add(new com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a(context));
        return g16;
    }

    public QUISettingsRecyclerView j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f183644m;
    }

    public com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return (com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a) b(com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a.class);
    }

    public d l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (d) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return (d) b(d.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.view.CustomSettingBaseView
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public QUISettingsRecyclerView e(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        if (view == null) {
            return null;
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) view.findViewById(R.id.f83734kc);
        this.f183644m = qUISettingsRecyclerView;
        return qUISettingsRecyclerView;
    }

    public View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f183643i;
    }

    public com.tencent.qqnt.robot.chatsetting.a o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.qqnt.robot.chatsetting.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return (com.tencent.qqnt.robot.chatsetting.a) b(((IRobotExtApi) QRoute.api(IRobotExtApi.class)).getRobotSettingGroupClass());
    }

    public b p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (b) b(b.class);
    }

    public c q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (c) b(c.class);
    }

    public e r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (e) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return (e) b(e.class);
    }

    public f s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (f) b(f.class);
    }

    public g t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (g) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (g) b(g.class);
    }

    public h u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (h) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (h) b(h.class);
    }

    public i v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (i) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (i) b(i.class);
    }

    public ViewGroup w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f183641f;
    }

    public TextView x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TextView) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f183642h;
    }

    public C2CChatSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public C2CChatSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
