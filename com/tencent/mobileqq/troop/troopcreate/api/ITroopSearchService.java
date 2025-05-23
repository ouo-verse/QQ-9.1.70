package com.tencent.mobileqq.troop.troopcreate.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopSearchService extends IRuntimeService {
    public static final int MATCH_TYPE_ALL = 1;
    public static final int MATCH_TYPE_NOT_ALL = 2;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements Comparable<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public TroopInfo f299977d;

        /* renamed from: e, reason: collision with root package name */
        public int f299978e;

        /* renamed from: f, reason: collision with root package name */
        public String f299979f;

        /* renamed from: h, reason: collision with root package name */
        public int f299980h;

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
            int i3 = this.f299980h;
            int i16 = aVar.f299980h;
            if (i3 != i16) {
                return i3 - i16;
            }
            TroopInfo troopInfo = this.f299977d;
            long j3 = troopInfo.lastMsgTime;
            TroopInfo troopInfo2 = aVar.f299977d;
            long j16 = troopInfo2.lastMsgTime;
            if (j3 != j16) {
                return (int) (j16 - j3);
            }
            long j17 = troopInfo2.troopCreateTime;
            long j18 = troopInfo.troopCreateTime;
            if (j17 != j18) {
                return (int) (j17 - j18);
            }
            int i17 = this.f299978e;
            int i18 = aVar.f299978e;
            if (i17 != i18) {
                return i17 - i18;
            }
            return this.f299979f.compareTo(aVar.f299979f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void onResult(ArrayList<a> arrayList);
    }

    void search(ArrayList<ResultRecord> arrayList, boolean z16, b bVar);
}
