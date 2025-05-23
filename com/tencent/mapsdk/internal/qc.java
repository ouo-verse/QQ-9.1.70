package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.so;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qc extends AsyncTask<Object, Void, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f149772a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<a> f149773b;

    /* renamed from: c, reason: collision with root package name */
    private final so f149774c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z16, so soVar);
    }

    public qc(bi biVar, a aVar) {
        this.f149772a = new WeakReference<>(biVar.f147820c);
        this.f149774c = biVar.f147819b.f151054k.f150369b;
        this.f149773b = new WeakReference<>(aVar);
    }

    private Boolean a() {
        boolean z16;
        sv svVar;
        boolean z17;
        boolean z18;
        if (this.f149772a.get() == null) {
            return Boolean.FALSE;
        }
        Context context = this.f149772a.get();
        try {
            dg dgVar = (dg) ((dv) cr.a(dv.class)).i();
            String a16 = ho.a();
            String i3 = ho.i();
            int i16 = this.f149774c.f150352d;
            String d16 = ho.d();
            so soVar = this.f149774c;
            int i17 = soVar.f150354f;
            int[] iArr = so.AnonymousClass3.f150366a;
            int i18 = iArr[soVar.f150357i.ordinal()];
            NetResponse checkAuth = dgVar.checkAuth(a16, i3, i16, d16, i17, 3, i18 != 1 ? i18 != 2 ? 0 : 1 : 2);
            if (checkAuth != null && checkAuth.available()) {
                String netResponse = checkAuth.toString();
                if (netResponse != null && netResponse.length() != 0) {
                    so soVar2 = this.f149774c;
                    LogUtil.c(ky.f149103i, "\u5f00\u59cb\u66f4\u65b0\u914d\u7f6e\uff1a".concat(netResponse));
                    sw swVar = (sw) JsonUtils.parseToModel(netResponse, sw.class, new Object[0]);
                    if (swVar != null && (svVar = swVar.f150412b) != null) {
                        if (swVar.f150411a != 0) {
                            boolean z19 = soVar2.f150353e;
                            soVar2.f150353e = false;
                            z17 = z19;
                            z18 = true;
                        } else {
                            if (soVar2.f150353e) {
                                z17 = false;
                                z18 = true;
                            } else {
                                z18 = true;
                                z17 = true;
                            }
                            soVar2.f150353e = z18;
                        }
                        LogUtil.c(ky.f149103i, "\u6743\u9650\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z17)));
                        boolean z26 = svVar.f150407g != soVar2.f150352d ? z18 : false;
                        LogUtil.c(ky.f149103i, "\u534f\u8bae\u7248\u672c\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z26)));
                        if (z26 | z17) {
                            sr a17 = soVar2.a(svVar);
                            if (a17 != null) {
                                int i19 = a17.f150383d;
                                sx sxVar = a17.f150384e;
                                if (sxVar != null) {
                                    int i26 = sxVar.f150416d;
                                    int i27 = sxVar.f150414b;
                                    LogUtil.c(ky.f149103i, "\u7248\u672c\u5bf9\u6bd4: old[" + soVar2.f150351c + "]-new[" + i26 + "]");
                                    LogUtil.c(ky.f149103i, "\u6837\u5f0f\u5bf9\u6bd4: old[" + soVar2.f150350b + "]-new[" + i27 + "]");
                                    if (i26 != soVar2.f150351c || i27 != soVar2.f150350b || i19 != soVar2.f150349a) {
                                        File file = new File(mz.a(context, (TencentMapOptions) null).b(), soVar2.a());
                                        if (file.exists()) {
                                            kt.b(file);
                                            LogUtil.c(ky.f149103i, "\u5220\u9664\u6d77\u5916\u56fe\u7f13\u5b58\u76ee\u5f55: ".concat(String.valueOf(file)));
                                        }
                                    }
                                }
                            }
                            su suVar = svVar.f150408h;
                            if (suVar != null) {
                                String str = suVar.f150400b;
                                LogUtil.c(ky.f149103i, "\u914d\u7f6e\u8fb9\u754c\u7ebf: ".concat(String.valueOf(str)));
                                soVar2.a(str);
                                suVar.f150399a = soVar2.f150354f;
                            }
                            soVar2.f150355g = swVar;
                            OverSeaSource overSeaSource = soVar2.f150357i;
                            my a18 = my.a(context);
                            int i28 = iArr[overSeaSource.ordinal()];
                            if (i28 == z18) {
                                a18.a(et.f148304g, netResponse);
                            } else if (i28 == 2) {
                                a18.a("worldMapConfig_BING", netResponse);
                            }
                            soVar2.a(soVar2.f150355g);
                            LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u5b8c\u6210");
                            z16 = z18;
                            return Boolean.valueOf(z16);
                        }
                    }
                    LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u6570\u636e\u89e3\u6790\u5931\u8d25\uff0c\u4f7f\u7528\u4e0a\u6b21\u7684\u914d\u7f6e");
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
            return Boolean.FALSE;
        } catch (Throwable th5) {
            LogUtil.a(th5.getMessage(), th5);
            return Boolean.FALSE;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Boolean doInBackground(Object[] objArr) {
        return a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Boolean bool) {
        Boolean bool2 = bool;
        super.onPostExecute(bool2);
        WeakReference<a> weakReference = this.f149773b;
        if (weakReference != null && weakReference.get() != null) {
            this.f149773b.get().a(bool2.booleanValue(), this.f149774c);
        }
    }

    private void a(Boolean bool) {
        super.onPostExecute(bool);
        WeakReference<a> weakReference = this.f149773b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f149773b.get().a(bool.booleanValue(), this.f149774c);
    }

    private boolean a(Context context, String str) {
        sv svVar;
        boolean z16;
        if (str != null && str.length() != 0) {
            so soVar = this.f149774c;
            LogUtil.c(ky.f149103i, "\u5f00\u59cb\u66f4\u65b0\u914d\u7f6e\uff1a".concat(str));
            sw swVar = (sw) JsonUtils.parseToModel(str, sw.class, new Object[0]);
            if (swVar != null && (svVar = swVar.f150412b) != null) {
                if (swVar.f150411a != 0) {
                    z16 = soVar.f150353e;
                    soVar.f150353e = false;
                } else {
                    z16 = !soVar.f150353e;
                    soVar.f150353e = true;
                }
                LogUtil.c(ky.f149103i, "\u6743\u9650\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z16)));
                boolean z17 = svVar.f150407g != soVar.f150352d;
                LogUtil.c(ky.f149103i, "\u534f\u8bae\u7248\u672c\u662f\u5426\u66f4\u65b0\uff1a".concat(String.valueOf(z17)));
                if (!z16 && !z17) {
                    return false;
                }
                sr a16 = soVar.a(svVar);
                if (a16 != null) {
                    int i3 = a16.f150383d;
                    sx sxVar = a16.f150384e;
                    if (sxVar != null) {
                        int i16 = sxVar.f150416d;
                        int i17 = sxVar.f150414b;
                        LogUtil.c(ky.f149103i, "\u7248\u672c\u5bf9\u6bd4: old[" + soVar.f150351c + "]-new[" + i16 + "]");
                        LogUtil.c(ky.f149103i, "\u6837\u5f0f\u5bf9\u6bd4: old[" + soVar.f150350b + "]-new[" + i17 + "]");
                        if (i16 != soVar.f150351c || i17 != soVar.f150350b || i3 != soVar.f150349a) {
                            File file = new File(mz.a(context, (TencentMapOptions) null).b(), soVar.a());
                            if (file.exists()) {
                                kt.b(file);
                                LogUtil.c(ky.f149103i, "\u5220\u9664\u6d77\u5916\u56fe\u7f13\u5b58\u76ee\u5f55: ".concat(String.valueOf(file)));
                            }
                        }
                    }
                }
                su suVar = svVar.f150408h;
                if (suVar != null) {
                    String str2 = suVar.f150400b;
                    LogUtil.c(ky.f149103i, "\u914d\u7f6e\u8fb9\u754c\u7ebf: ".concat(String.valueOf(str2)));
                    soVar.a(str2);
                    suVar.f150399a = soVar.f150354f;
                }
                soVar.f150355g = swVar;
                OverSeaSource overSeaSource = soVar.f150357i;
                my a17 = my.a(context);
                int i18 = so.AnonymousClass3.f150366a[overSeaSource.ordinal()];
                if (i18 == 1) {
                    a17.a(et.f148304g, str);
                } else if (i18 == 2) {
                    a17.a("worldMapConfig_BING", str);
                }
                soVar.a(soVar.f150355g);
                LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u5b8c\u6210");
                return true;
            }
            LogUtil.c(ky.f149103i, "\u914d\u7f6e\u66f4\u65b0\u6570\u636e\u89e3\u6790\u5931\u8d25\uff0c\u4f7f\u7528\u4e0a\u6b21\u7684\u914d\u7f6e");
        }
        return false;
    }
}
