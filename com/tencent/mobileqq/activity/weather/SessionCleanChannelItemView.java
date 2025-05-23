package com.tencent.mobileqq.activity.weather;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.messageclean.v;
import com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SessionCleanChannelItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private CheckBox f186637d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f186638e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f186639f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f186640h;

    public SessionCleanChannelItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            b();
        }
    }

    private void b() {
        View inflate = View.inflate(getContext(), R.layout.hq7, this);
        this.f186639f = (TextView) inflate.findViewById(R.id.f94705d0);
        this.f186640h = (TextView) inflate.findViewById(R.id.f94925dl);
        this.f186637d = (CheckBox) inflate.findViewById(R.id.axa);
        this.f186638e = (ImageView) inflate.findViewById(R.id.icon);
    }

    public void a(com.tencent.mobileqq.app.message.messageclean.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
            return;
        }
        if (gVar.f196216a != 10001) {
            QLog.e("SessionCleanGuildItemView", 1, "bindData entry : type " + gVar.f196216a + " invalid");
            return;
        }
        v vVar = (v) gVar;
        ((IGuildChannelIconTypeApi) QRoute.api(IGuildChannelIconTypeApi.class)).setChannelIcon(this.f186638e, vVar.f196248g, vVar.f196249h);
        this.f186639f.setText(vVar.f196218c);
        this.f186640h.setText(vVar.f196219d);
        this.f186637d.setChecked(vVar.f196220e);
    }
}
