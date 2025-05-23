package com.tencent.mobileqq.weather;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends av {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.weather.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C8963a extends ax {
        static IPatchRedirector $redirector_;

        protected C8963a(BaseQQAppInterface baseQQAppInterface, Context context) {
            super(baseQQAppInterface, context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.utils.ax
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).openWeatherMainPage(this.f307437b, this.f307441f);
            return true;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        return com.tencent.avgame.util.b.a(new C8963a(baseQQAppInterface, context), str, "qqweather", "open");
    }
}
