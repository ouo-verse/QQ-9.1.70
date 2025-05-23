package com.tencent.tedger.config.parse;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.tedgecontext.b;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate;
import com.tencent.tedger.reshub.ResHubHelper;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class QCircleConfigParse extends b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f375144a;

    /* renamed from: b, reason: collision with root package name */
    private long f375145b;

    /* renamed from: c, reason: collision with root package name */
    private long f375146c;

    /* renamed from: d, reason: collision with root package name */
    private final String f375147d;

    /* renamed from: e, reason: collision with root package name */
    private final String f375148e;

    /* renamed from: f, reason: collision with root package name */
    private final String f375149f;

    /* renamed from: g, reason: collision with root package name */
    private final String f375150g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f375151h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f375152i;

    /* renamed from: j, reason: collision with root package name */
    long f375153j;

    /* renamed from: k, reason: collision with root package name */
    int f375154k;

    public QCircleConfigParse(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375145b = 4294967296L;
        this.f375146c = 6L;
        this.f375147d = "valid_device.min_mem";
        this.f375148e = "valid_device.min_core";
        this.f375149f = "device_level";
        this.f375150g = "global.low_performance_machine_use_policy";
        this.f375151h = false;
        this.f375152i = false;
        this.f375153j = 0L;
        this.f375154k = 0;
    }

    private void L(JsonObject jsonObject) {
        String str;
        boolean a16 = a();
        if (jsonObject != null && jsonObject.getAsJsonObject(ReadInJoyMMapKvStorage.NAME_DEFAULT) != null) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject(ReadInJoyMMapKvStorage.NAME_DEFAULT);
            if (a16) {
                str = "LOW";
            } else {
                str = "HIGH";
            }
            asJsonObject.addProperty("device_level", str);
            getContext().t(jsonObject.toString());
        }
    }

    @Override // com.tencent.tedger.config.parse.a
    public int B(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject)).intValue();
        }
        JsonObject jsonObject = (JsonObject) new Gson().fromJson(jSONObject.toString(), JsonObject.class);
        String asString = jsonObject.getAsJsonObject(ReadInJoyMMapKvStorage.NAME_DEFAULT).getAsJsonArray(DKConfiguration.Directory.RESOURCES).get(0).getAsJsonObject().get(DittoImageArea.RESOURCE_ID).getAsString();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        getContext().m().f375305c.asyncRunInRequestThread(new Runnable(asString, countDownLatch) { // from class: com.tencent.tedger.config.parse.QCircleConfigParse.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f375155d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f375156e;

            /* renamed from: com.tencent.tedger.config.parse.QCircleConfigParse$1$a */
            /* loaded from: classes26.dex */
            class a implements h {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.rdelivery.reshub.api.h
                public void onComplete(boolean z16, @Nullable g gVar, @NonNull n nVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        try {
                            ((b) QCircleConfigParse.this).mLog.d("QCircleParse", "loadLatest isSuccess:" + z16 + " iResLoadError:" + nVar.b() + " IResLoadMess:" + nVar.message());
                            if (z16) {
                                QCircleConfigParse.this.f375144a = gVar.e();
                            }
                        } catch (Exception e16) {
                            ((b) QCircleConfigParse.this).mLog.h("QCircleParse", "loadLatest error:" + e16);
                        }
                        AnonymousClass1.this.f375156e.countDown();
                        return;
                    }
                    iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), gVar, nVar);
                }

                @Override // com.tencent.rdelivery.reshub.api.h
                public void onProgress(float f16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
                    }
                }
            }

            {
                this.f375155d = asString;
                this.f375156e = countDownLatch;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QCircleConfigParse.this, asString, countDownLatch);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ResHubHelper.d().h(QCircleConfigParse.this.getContext(), this.f375155d, new a());
                }
            }
        });
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        if (!TextUtils.isEmpty(this.f375144a)) {
            M(jsonObject);
            K();
            return 0;
        }
        this.mLog.f("QCircleParse", 15, "parse config json have error: resHub download fail");
        return -6;
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (com.tencent.tedger.config.b.a(this.f375144a, this.mLog, getContext())) {
            getContext().m().f375306d.A(new EdgeStatus());
            this.mLog.d("QCircleParse", " markAllSamplesUnUsed ");
        }
    }

    public void M(JsonObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonObject);
            return;
        }
        File file = new File(this.f375144a);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length == 1 && listFiles[0].isDirectory()) {
                this.f375144a = listFiles[0].getAbsolutePath();
            } else {
                this.f375144a = file.getAbsolutePath();
            }
        }
        jsonObject.getAsJsonObject(ReadInJoyMMapKvStorage.NAME_DEFAULT).getAsJsonArray(DKConfiguration.Directory.RESOURCES).get(0).getAsJsonObject().addProperty("resource_dir", this.f375144a);
        getContext().t(jsonObject.toString());
        this.mLog.d("QCircleParse", "setResPathToConfig path:" + this.f375144a);
    }

    @Override // com.tencent.tedger.config.parse.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f375152i) {
            return this.f375151h;
        }
        ITEdgeRSSDKComponentDelegate.DeviceLevel b16 = getContext().d().b();
        boolean z16 = false;
        if (b16 == ITEdgeRSSDKComponentDelegate.DeviceLevel.HIGH_LEVEL) {
            this.f375151h = false;
        } else if (b16 == ITEdgeRSSDKComponentDelegate.DeviceLevel.LOW_LEVEL) {
            this.f375151h = true;
        } else if (b16 == ITEdgeRSSDKComponentDelegate.DeviceLevel.UNKNOWN) {
            this.f375153j = getContext().d().a();
            this.f375154k = getContext().d().h();
            this.mLog.d("QCircleParse", "curRawMem = " + this.f375153j + " curCoreNum = " + this.f375154k);
            if (this.f375153j <= this.f375145b || this.f375154k <= this.f375146c) {
                z16 = true;
            }
            this.f375151h = z16;
        }
        this.f375152i = true;
        return this.f375151h;
    }

    @Override // com.tencent.tedger.config.parse.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return getRouter().f375304b.i("global.low_performance_machine_use_policy", false);
    }

    @Override // com.tencent.tedger.config.parse.a
    public void parseConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f375145b = getRouter().f375304b.h("valid_device.min_mem", this.f375145b);
        this.f375146c = getRouter().f375304b.h("valid_device.min_core", this.f375146c);
        L((JsonObject) new Gson().fromJson(getContext().e(), JsonObject.class));
    }
}
