package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoTipOffRsp;
import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.network.DoTipOffRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96269d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f96270e;

        a(ActionSheet actionSheet, c cVar) {
            this.f96269d = actionSheet;
            this.f96270e = cVar;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            this.f96269d.dismiss();
            c cVar = this.f96270e;
            if (cVar != null) {
                cVar.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0972b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StUser f96271d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f96272e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f96273f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f96274h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96275i;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.subscribe.utils.b$b$a */
        /* loaded from: classes5.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoTipOffRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoTipOffRsp certifiedAccountWrite$StDoTipOffRsp) {
                boolean z17 = true;
                if (j3 == 0) {
                    QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest success");
                } else {
                    QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest failed retCode:" + j3);
                }
                d dVar = C0972b.this.f96273f;
                if (dVar != null) {
                    if (j3 != 0) {
                        z17 = false;
                    }
                    dVar.onResult(z17);
                }
            }
        }

        C0972b(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, d dVar, c cVar, ActionSheet actionSheet) {
            this.f96271d = certifiedAccountMeta$StUser;
            this.f96272e = certifiedAccountMeta$StFeed;
            this.f96273f = dVar;
            this.f96274h = cVar;
            this.f96275i = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                VSNetworkHelper.getInstance().sendRequest(new DoTipOffRequest(0, this.f96271d, this.f96272e, 2), new a());
                c cVar = this.f96274h;
                if (cVar != null) {
                    cVar.a(false);
                }
            }
            this.f96275i.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void onResult(boolean z16);
    }

    public static void a(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, d dVar, c cVar) {
        b(context, null, certifiedAccountMeta$StFeed, dVar, cVar);
    }

    private static void b(Context context, CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, d dVar, c cVar) {
        ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(context.getString(R.string.vsl));
        create.addButton(R.string.vsm, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new a(create, cVar));
        create.setOnButtonClickListener(new C0972b(certifiedAccountMeta$StUser, certifiedAccountMeta$StFeed, dVar, cVar, create));
        if (!create.isShowing()) {
            create.show();
        }
    }

    public static void c(Context context, CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, d dVar, c cVar) {
        b(context, certifiedAccountMeta$StUser, null, dVar, cVar);
    }
}
