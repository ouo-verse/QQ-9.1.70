package cw2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdOpenAppItem;
import com.tencent.qqlive.ona.protocol.jce.PackageAction;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends c {
    public b(Context context, wv2.a aVar) {
        super(context, aVar);
    }

    @Override // cw2.c
    protected boolean N(d dVar) {
        if (dVar != null && mw2.a.p(this.f303963a)) {
            return true;
        }
        return false;
    }

    @Override // cw2.c
    protected boolean u() {
        PackageAction packageAction;
        AdOpenAppItem adOpenAppItem = this.f303963a.f446565a.adOpenApp;
        if (adOpenAppItem != null && (packageAction = adOpenAppItem.packageAction) != null) {
            String str = packageAction.url;
            if (TextUtils.isEmpty(adOpenAppItem.appName)) {
                adOpenAppItem.appName = uv2.b.b(this.f303964b, adOpenAppItem.packageAction.url);
            }
            return uv2.b.c(this.f303964b, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cw2.c
    public void w(d dVar, g gVar) {
        this.f303963a.f446579o = true;
        super.w(dVar, gVar);
    }
}
