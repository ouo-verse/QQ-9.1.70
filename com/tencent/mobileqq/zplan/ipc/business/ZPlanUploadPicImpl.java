package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mobileqq.zplan.ipc.business.e;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes34.dex */
public class ZPlanUploadPicImpl implements e {
    private static final String TAG = "ZPlanUploadPicImpl";

    @Override // com.tencent.mobileqq.zplan.ipc.business.e
    public void upLoadPic(String str, String str2, String str3, e.a aVar) {
        try {
            ZPlanAvatarShpImageUploadDownloadUtils.i().m(str, str2, ".jpg", new a(str3, Long.parseLong(str), aVar));
        } catch (NumberFormatException unused) {
            QLog.e(TAG, 1, "[upLoadPic] NumberFormatException");
        }
    }

    /* loaded from: classes34.dex */
    class a implements Function2<Boolean, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f333759d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f333760e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e.a f333761f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.mobileqq.zplan.ipc.business.ZPlanUploadPicImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public class C9180a extends nk3.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f333763a;

            C9180a(String str) {
                this.f333763a = str;
            }

            @Override // nk3.i
            public void onResultFailed() {
                a.this.f333761f.a(false, "");
            }

            @Override // nk3.i
            public void onResultForAddImage() {
                a.this.f333761f.a(true, this.f333763a);
            }
        }

        a(String str, long j3, e.a aVar) {
            this.f333759d = str;
            this.f333760e = j3;
            this.f333761f = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, String str) {
            if (bool.booleanValue()) {
                com.tencent.mobileqq.zplan.model.g gVar = new com.tencent.mobileqq.zplan.model.g(str, null, NetConnInfoCenter.getServerTime(), 2, "FROM_ZPLAN_BG_EDIT".equals(this.f333759d) ? 4 : 3, null);
                ArrayList arrayList = new ArrayList();
                arrayList.add(gVar);
                ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestAddDCBackImage(this.f333760e, 1, arrayList, new C9180a(str));
                return null;
            }
            this.f333761f.a(false, "");
            return null;
        }
    }
}
