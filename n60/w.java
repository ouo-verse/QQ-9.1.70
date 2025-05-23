package n60;

import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class w extends b {

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f418512f;

    /* renamed from: h, reason: collision with root package name */
    private l60.a f418513h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t f418514i;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_base_user_busi_data", "key_update_version_main_basic_base_rsp", "key_update_version_main_basic_busi_base_data");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            w.this.v(wVar);
        }
    }

    public w(@NonNull n60.a aVar) {
        super(aVar);
        this.f418513h = new l60.a();
    }

    private void u() {
        if (this.f418512f.getParent() == null) {
            return;
        }
        this.f418513h.d(b(), this.f418512f.inflate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        boolean z16;
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        if (!wVar.z() && !wVar.b().medalWall.needShowEntrance.get()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        u();
        this.f418513h.a(wVar);
    }

    @Override // n60.b
    public void j(@NonNull QFSBaseFragment qFSBaseFragment) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) qFSBaseFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.f418514i = tVar;
        tVar.O1().c(qFSBaseFragment, new a());
    }

    @Override // n60.b
    public void l() {
        super.l();
        if (this.f418513h != null) {
            SimpleEventBus.getInstance().registerReceiver(this.f418513h);
        }
    }

    @Override // n60.b
    public void n() {
        super.n();
        if (this.f418513h != null) {
            SimpleEventBus.getInstance().unRegisterReceiver(this.f418513h);
        }
    }

    @Override // n60.b
    public void o() {
        this.f418512f = (ViewStub) a(R.id.f33070vg);
    }
}
