package com.tencent.aelight.camera.aioeditor.capture.control;

import android.os.Bundle;
import com.tencent.biz.troop.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import fr.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureAsyncStep$BindTroopMemberClient extends AsyncStep {

    /* renamed from: d, reason: collision with root package name */
    public b f66667d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ITroopMemberApiClientApi.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            String string = bundle.getString("nickName");
            if (string == null) {
                string = "";
            }
            AppInterface e16 = f.e();
            if (e16 instanceof PeakAppInterface) {
                ((PeakAppInterface) e16).k(string);
            }
            CaptureAsyncStep$BindTroopMemberClient.this.f66667d.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        b A = b.A();
        this.f66667d = A;
        A.p();
        this.f66667d.x(new a());
        return 7;
    }
}
