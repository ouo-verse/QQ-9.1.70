package com.tencent.luggage.wxa.ka;

import android.os.Bundle;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;

/* compiled from: P */
/* loaded from: classes8.dex */
class k implements f {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends m {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f131853b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, i iVar) {
            super(str);
            this.f131853b = iVar;
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(Bundle bundle) {
            this.f131853b.a(bundle);
        }
    }

    k() {
    }

    @Override // com.tencent.luggage.wxa.ka.f
    public void a(Bundle bundle, i iVar) {
        String string = bundle.getString(ZootopiaEnterParams.KEY_TOKEN);
        com.tencent.luggage.wxa.oa.b.a().a(bundle.getString("Event"), new a(string, iVar));
    }
}
