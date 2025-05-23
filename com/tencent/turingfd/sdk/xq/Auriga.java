package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.Aquila;
import com.tencent.turingfd.sdk.xq.Filbert;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Auriga implements Callable<Canesatici> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<Integer, FutureTask<Aquila>> f382579e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f382580a;

    /* renamed from: b, reason: collision with root package name */
    public final int f382581b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382582c;

    /* renamed from: d, reason: collision with root package name */
    public final Pitaya f382583d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382579e = new HashMap<>();
        }
    }

    public Auriga(int i3, boolean z16, String str, Pitaya pitaya) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), str, pitaya);
            return;
        }
        this.f382581b = i3;
        this.f382580a = z16;
        this.f382582c = str;
        this.f382583d = pitaya;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Canesatici a(Aquila.Cif cif, AtomicReference<String> atomicReference) throws JSONException {
        String jSONObject;
        Bullace bullace;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Canesatici) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cif, (Object) atomicReference);
        }
        if (cif.f382572f == null) {
            jSONObject = null;
        } else {
            synchronized (cif.f382567a) {
                jSONObject = cif.f382572f.toString();
            }
        }
        if (TextUtils.isEmpty(jSONObject)) {
            return new Canesatici(-50012);
        }
        try {
            Filbert.Cdo a16 = new Filbert.Cdo("https://tdid.m.qq.com/gw_parse/phone_mask").a(jSONObject);
            a16.f382762f = 10000;
            a16.f382763g = 10000;
            Ginkgo a17 = Crux.a(new Filbert(a16));
            int i3 = a17.f382780a;
            if (i3 != 200) {
                return new Canesatici((-52000) - i3);
            }
            if (a17.f382783d) {
                return new Canesatici(-50021);
            }
            byte[] bArr = a17.f382781b;
            if (bArr != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(bArr, "utf-8"));
                    bullace = new Bullace(jSONObject2.getInt("ret"), jSONObject2.optString("phone_mask"), jSONObject2.optString(SessionDbHelper.SESSION_ID));
                } catch (UnsupportedEncodingException | JSONException unused) {
                    bullace = null;
                }
                if (bullace != null) {
                    return new Canesatici(-50016);
                }
                int i16 = bullace.f382615a;
                if (i16 != 0) {
                    return new Canesatici(i16 - 60000);
                }
                if (TextUtils.isEmpty(bullace.f382616b)) {
                    return new Canesatici(-50017);
                }
                if (TextUtils.isEmpty(bullace.f382617c)) {
                    return new Canesatici(-50018);
                }
                cif.a(bullace.f382617c);
                atomicReference.set(bullace.f382616b);
                return null;
            }
            bullace = null;
            if (bullace != null) {
            }
        } catch (SocketTimeoutException unused2) {
            return new Canesatici(-50013);
        } catch (UnknownHostException unused3) {
            return new Canesatici(-50014);
        } catch (IOException unused4) {
            return new Canesatici(-50015);
        }
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object, com.tencent.turingfd.sdk.xq.Canesatici] */
    @Override // java.util.concurrent.Callable
    public Canesatici call() throws Exception {
        FutureTask<Aquila> futureTask;
        Aquila aquila;
        Aquila aquila2;
        Canesatici canesatici;
        String jSONObject;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap<Integer, FutureTask<Aquila>> hashMap = f382579e;
        synchronized (hashMap) {
            futureTask = hashMap.get(Integer.valueOf(this.f382581b));
            if (futureTask != null && !futureTask.isDone()) {
                aquila = null;
            }
            Aquila aquila3 = new Aquila(this.f382581b);
            FutureTask<Aquila> futureTask2 = new FutureTask<>(new Cinterface(this.f382581b, this.f382582c, aquila3, this.f382583d));
            Cstrictfp.f383431a.submit(futureTask2);
            hashMap.put(Integer.valueOf(this.f382581b), futureTask2);
            aquila = aquila3;
            futureTask = futureTask2;
        }
        FutureTask futureTask3 = new FutureTask(new Ara(this));
        Cstrictfp.f383431a.submit(futureTask3);
        try {
            Haw haw = (Haw) futureTask3.get();
            int i16 = haw.f382807a;
            if (i16 != 0) {
                return new Canesatici(i16);
            }
            try {
                aquila2 = futureTask.get();
            } catch (Throwable th5) {
                if (aquila == null) {
                    aquila = new Aquila(this.f382581b);
                }
                aquila.a().a(-50005, th5.toString());
                aquila2 = aquila;
            }
            String str = haw.f382808b;
            synchronized (aquila2.f382561b) {
                aquila2.f382560a.put(RemoteMessageConst.DEVICE_TOKEN, str);
            }
            AtomicReference<String> atomicReference = new AtomicReference<>(null);
            if ((this.f382581b & 2) != 0) {
                Aquila.Cif a16 = aquila2.a();
                synchronized (a16.f382567a) {
                    i3 = a16.f382569c;
                }
                if (i3 != 0) {
                    return new Canesatici(i3, a16.b(), null);
                }
                Pitaya pitaya = this.f382583d;
                pitaya.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                pitaya.f383024f = currentTimeMillis;
                pitaya.a("EId_UId_GMask_Start", currentTimeMillis);
                canesatici = a(a16, atomicReference);
                if (canesatici != null) {
                    Pitaya pitaya2 = this.f382583d;
                    pitaya2.a("EId_UId_GMask_End", pitaya2.f383024f, canesatici.f382619a, null);
                    return canesatici;
                }
                Pitaya pitaya3 = this.f382583d;
                pitaya3.a("EId_UId_GMask_End", pitaya3.f383024f, 0, null);
            }
            synchronized (aquila2.f382561b) {
                jSONObject = aquila2.f382560a.toString();
            }
            canesatici = new Canesatici(0, null, aquila2.f382563d + new String(Base64.encode(Cstatic.a(jSONObject.getBytes(StandardCharsets.UTF_8)), 2)));
            if (!TextUtils.isEmpty(atomicReference.get())) {
                canesatici.f382622d = atomicReference.get();
            }
            return canesatici;
        } catch (Throwable unused) {
            return new Canesatici(HiHealthStatusCodes.NO_DATA_COLLECTOR_ERROR);
        }
    }
}
