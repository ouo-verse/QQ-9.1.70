package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends Part {

    /* renamed from: d, reason: collision with root package name */
    private cw.a f76466d;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteTipsViewPart", 1, "onInitView rootView is null");
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root_layout);
        cw.a aVar = new cw.a();
        this.f76466d = aVar;
        aVar.u(nw.b.b(), relativeLayout);
        cw.a aVar2 = this.f76466d;
        if (aVar2 != null) {
            aVar2.z(getContext().getResources().getColor(R.color.f157526s4));
            this.f76466d.y(-1291845633);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cw.a aVar = this.f76466d;
        if (aVar != null) {
            aVar.v();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        cw.a aVar = this.f76466d;
        if (aVar != null) {
            aVar.w(nw.b.b());
        }
    }
}
