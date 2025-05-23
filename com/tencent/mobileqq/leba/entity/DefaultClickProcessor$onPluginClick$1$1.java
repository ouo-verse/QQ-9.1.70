package com.tencent.mobileqq.leba.entity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class DefaultClickProcessor$onPluginClick$1$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f240461d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ n f240462e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ View f240463f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ f f240464h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Activity f240465i;
    final /* synthetic */ DefaultClickProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultClickProcessor$onPluginClick$1$1(SharedPreferences sharedPreferences, n nVar, DefaultClickProcessor defaultClickProcessor, View view, f fVar, Activity activity) {
        this.f240461d = sharedPreferences;
        this.f240462e = nVar;
        this.this$0 = defaultClickProcessor;
        this.f240463f = view;
        this.f240464h = fVar;
        this.f240465i = activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sharedPreferences, nVar, defaultClickProcessor, view, fVar, activity);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        final SharedPreferences sharedPreferences = this.f240461d;
        final n nVar = this.f240462e;
        final DefaultClickProcessor defaultClickProcessor = this.this$0;
        final View view = this.f240463f;
        final f fVar = this.f240464h;
        final Activity activity = this.f240465i;
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            com.tencent.mobileqq.leba.util.a.c(new Runnable(sharedPreferences, nVar, defaultClickProcessor, view, fVar, activity) { // from class: com.tencent.mobileqq.leba.entity.DefaultClickProcessor$onPluginClick$1$1$run$$inlined$runOnWorkThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SharedPreferences f240437d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ n f240438e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ View f240439f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ f f240440h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Activity f240441i;
                final /* synthetic */ DefaultClickProcessor this$0;

                {
                    this.f240437d = sharedPreferences;
                    this.f240438e = nVar;
                    this.this$0 = defaultClickProcessor;
                    this.f240439f = view;
                    this.f240440h = fVar;
                    this.f240441i = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, sharedPreferences, nVar, defaultClickProcessor, view, fVar, activity);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SharedPreferences.Editor edit = this.f240437d.edit();
                    LebaPluginInfo lebaPluginInfo = this.f240438e.f240505b;
                    if (lebaPluginInfo != null) {
                        str2 = lebaPluginInfo.strGotoUrl;
                    } else {
                        str2 = null;
                    }
                    edit.putBoolean(str2, true).apply();
                    DefaultClickProcessor.a c16 = this.this$0.c(this.f240439f, this.f240438e, this.f240440h);
                    this.this$0.j(this.f240438e, this.f240440h);
                    this.this$0.g(this.f240441i, c16);
                }
            });
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        LebaPluginInfo lebaPluginInfo = nVar.f240505b;
        if (lebaPluginInfo != null) {
            str = lebaPluginInfo.strGotoUrl;
        } else {
            str = null;
        }
        edit.putBoolean(str, true).apply();
        DefaultClickProcessor.a c16 = defaultClickProcessor.c(view, nVar, fVar);
        defaultClickProcessor.j(nVar, fVar);
        defaultClickProcessor.g(activity, c16);
    }
}
