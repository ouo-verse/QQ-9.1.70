package com.qzone.reborn.feedx.part;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class f extends com.qzone.reborn.base.k implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    protected IColorNoteController f55262d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements ha1.a {
        a() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            f.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements com.tencent.mobileqq.colornote.swipe.a {
        b() {
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void a() {
            QLog.d("QZoneBaseColorNotePart", 1, "onPageSwipeNotClose");
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void onPageSwipeClose() {
            QLog.d("QZoneBaseColorNotePart", 1, "onPageSwipeClose");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C9() {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f55262d = iColorNoteController;
        if (iColorNoteController == null) {
            return;
        }
        iColorNoteController.init(getActivity(), true, false, null, true, true, R.color.f156954am1);
        this.f55262d.attachToActivity(getActivity());
        this.f55262d.setServiceInfo(this);
        this.f55262d.setOnColorNoteAnimFinishListener(new a());
        this.f55262d.setOnPageSwipeListener(new b());
        this.f55262d.onResume();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IColorNoteController iColorNoteController = this.f55262d;
        if (iColorNoteController != null) {
            iColorNoteController.exitAnimation();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        IColorNoteController iColorNoteController = this.f55262d;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IColorNoteController iColorNoteController = this.f55262d;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IColorNoteController iColorNoteController = this.f55262d;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }
}
