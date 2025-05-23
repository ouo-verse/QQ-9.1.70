package com.tencent.luggage.wxa.ka;

import android.os.Bundle;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;

/* compiled from: P */
/* loaded from: classes8.dex */
class l implements f {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends m {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(Bundle bundle) {
        }
    }

    l() {
    }

    @Override // com.tencent.luggage.wxa.ka.f
    public void a(Bundle bundle, i iVar) {
        String string = bundle.getString(ZootopiaEnterParams.KEY_TOKEN);
        com.tencent.luggage.wxa.oa.b.a().b(bundle.getString("Event"), new a(string));
    }
}
