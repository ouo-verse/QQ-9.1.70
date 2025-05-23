package com.tencent.gdtad.basics.adbox;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements IGdtAdBox {

    /* renamed from: a, reason: collision with root package name */
    private GdtAdBoxData f108686a;

    /* renamed from: b, reason: collision with root package name */
    private Context f108687b;

    /* renamed from: c, reason: collision with root package name */
    private GdtAdBoxListener f108688c;

    /* renamed from: d, reason: collision with root package name */
    private GdtAdBoxListDialog f108689d;

    /* renamed from: e, reason: collision with root package name */
    private int f108690e = 0;

    private List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> b() {
        if (this.f108686a.getAds() != null && this.f108686a.getAds().size() >= 1) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.f108686a.getAds().get(0).info;
            ArrayList arrayList = new ArrayList();
            if (adInfo != null && !TextUtils.isEmpty(adInfo.ext_json.get())) {
                try {
                    qq_ad_get.QQAdGetRsp.AdInfo.Ext ext = (qq_ad_get.QQAdGetRsp.AdInfo.Ext) qq_ad_get.QQAdGetRsp.AdInfo.Ext.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), new JSONObject(adInfo.ext_json.get())));
                    if (ext != null) {
                        return ext.exp_map.get();
                    }
                } catch (Throwable th5) {
                    GdtLog.e("GdtAdBox", "getExpMap", th5);
                }
            }
            return arrayList;
        }
        return null;
    }

    private void d() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> b16 = b();
        if (b16 == null) {
            return;
        }
        for (int i3 = 0; i3 < b16.size(); i3++) {
            if (b16.get(i3).key.get() == 118442 && b16.get(i3).value.get().equals(String.valueOf(1))) {
                this.f108690e = Integer.parseInt(b16.get(i3).value.get());
                return;
            }
        }
    }

    public static b j(Context context) {
        return new b(context);
    }

    public GdtAdBoxListener a() {
        return this.f108688c;
    }

    public GdtAdBoxData c() {
        return this.f108686a;
    }

    @Override // com.tencent.gdtad.basics.adbox.IGdtAdBox
    public void destroy() {
        GdtAdBoxListDialog gdtAdBoxListDialog = this.f108689d;
        if (gdtAdBoxListDialog != null && gdtAdBoxListDialog.isShowing()) {
            this.f108689d.dismiss();
            this.f108689d = null;
        }
        this.f108688c = null;
        this.f108686a = null;
        this.f108687b = null;
    }

    public void e() {
        GdtAdBoxListener gdtAdBoxListener = this.f108688c;
        if (gdtAdBoxListener != null) {
            gdtAdBoxListener.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Context context) {
        this.f108687b = context;
    }

    public void g(GdtAdBoxData gdtAdBoxData) {
        this.f108686a = gdtAdBoxData;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(GdtAdBoxListener gdtAdBoxListener) {
        this.f108688c = gdtAdBoxListener;
    }

    public void i() {
        GdtAdBoxListDialog gdtAdBoxListDialog = new GdtAdBoxListDialog(this.f108687b);
        this.f108689d = gdtAdBoxListDialog;
        gdtAdBoxListDialog.Y(this);
        this.f108689d.show();
    }

    @Override // com.tencent.gdtad.basics.adbox.IGdtAdBox
    public void refresh(List<GdtAd> list) {
        GdtAdBoxData gdtAdBoxData;
        if (this.f108689d != null && (gdtAdBoxData = this.f108686a) != null) {
            gdtAdBoxData.setAds(list);
            this.f108689d.refresh();
        }
    }

    @Override // com.tencent.gdtad.basics.adbox.IGdtAdBox
    public void show() {
        i();
    }
}
