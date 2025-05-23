package com.tencent.mobileqq.troop.flame.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopFlameApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f296040a;

        /* renamed from: b, reason: collision with root package name */
        public int f296041b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f296042c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f296043d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f296043d = true;
            }
        }
    }

    void addLocalTroopFlameGrayTip(String str, int i3, int i16);

    void cacheFlameDataHasShow(TroopInfo troopInfo);

    Drawable createTroopFlameDrawable(Context context, a aVar);

    a getFlameViewDataFromPB(GroupExtFlameData groupExtFlameData);

    Class<?> getParserClass();

    void showTroopFlameDetailDialog(Context context, String str);
}
