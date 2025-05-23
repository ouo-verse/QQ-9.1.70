package h00;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager;
import com.tencent.biz.pubaccount.weishi.util.ao;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends h00.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements OuterInterceptManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f403970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OuterInterceptManager.a f403971b;

        a(c cVar, OuterInterceptManager.a aVar) {
            this.f403970a = cVar;
            this.f403971b = aVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void a(Dialog dialog) {
            OuterInterceptManager.a aVar = this.f403971b;
            if (aVar != null) {
                aVar.a(dialog);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void b() {
            e.this.d(this.f403970a);
            OuterInterceptManager.a aVar = this.f403971b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void onNegativeClick() {
            OuterInterceptManager.a aVar = this.f403971b;
            if (aVar != null) {
                aVar.onNegativeClick();
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void onPositiveClick() {
            e.this.d(this.f403970a);
            OuterInterceptManager.a aVar = this.f403971b;
            if (aVar != null) {
                aVar.onPositiveClick();
            }
        }
    }

    public e(c cVar) {
        super(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        String str;
        if (!TextUtils.isEmpty(cVar.g().schema)) {
            str = cVar.g().schema;
        } else {
            str = "weishi://main";
        }
        ao.e(cVar.getContext(), "biz_src_jc_gzh_weishi", str);
        if (cVar.d() != null) {
            cVar.d().d();
        }
    }

    private void e(c cVar) {
        if (cVar.getContext() instanceof Activity) {
            OuterInterceptManager.a((Activity) cVar.getContext(), new a(cVar, cVar.f()));
        }
    }

    @Override // h00.a
    public boolean b(c cVar) {
        if (cVar.e()) {
            e(cVar);
            return true;
        }
        d(cVar);
        return true;
    }
}
