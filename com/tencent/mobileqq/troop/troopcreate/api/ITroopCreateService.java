package com.tencent.mobileqq.troop.troopcreate.api;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopCreateService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements Comparable<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f299975d;

        /* renamed from: e, reason: collision with root package name */
        public String f299976e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).intValue();
            }
            return this.f299976e.compareTo(aVar.f299976e);
        }
    }

    void createTroop(Activity activity, ITroopCreateInfoService.a aVar);

    void createTroop(ITroopCreateInfoService.a aVar, Activity activity, List<TroopCreateInfo.a> list);

    void jumpToAioAfterCreated(String str, String str2, boolean z16, boolean z17);

    void onReuseTroop(String str);

    void releaseCreateCallback(ITroopCreateInfoService.a aVar);

    void startCreateTroop(ITroopCreateInfoService.a aVar, Activity activity, ArrayList<ResultRecord> arrayList);

    void startCreateTroopSession(Activity activity, int i3);

    void startCreateTroopSession(Activity activity, int i3, String str);

    void terminateLogic();
}
