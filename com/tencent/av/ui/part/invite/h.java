package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.m;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qphone.base.util.QLog;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends Part {

    /* renamed from: d, reason: collision with root package name */
    private Button f76457d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f76458e;

    /* renamed from: f, reason: collision with root package name */
    private m f76459f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76460h;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.f76459f.h(com.tencent.av.utils.e.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (h.this.f76457d != null) {
                h.this.f76457d.setEnabled(!bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (h.this.f76457d != null) {
                h.this.f76457d.setEnabled(!bool.booleanValue());
            }
        }
    }

    public h(boolean z16) {
        this.f76458e = z16;
    }

    private void A9() {
        Button button;
        RelativeLayout.LayoutParams layoutParams;
        if ((FontSettingManager.getFontLevel() != 20.0f && FontSettingManager.getFontLevel() != 18.0f && FontSettingManager.getFontLevel() != 17.0f) || FontSettingManager.getFontLevel() != 20.0f || this.f76460h || (button = this.f76457d) == null || (layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams()) == null) {
            return;
        }
        layoutParams.leftMargin = getActivity().getResources().getDimensionPixelSize(R.dimen.a1o);
        this.f76457d.setLayoutParams(layoutParams);
    }

    private void B9() {
        sw.a aVar = (sw.a) getViewModel(sw.a.class);
        if (aVar == null) {
            QLog.d("AVInviteRefusePart", 1, "getViewModel error.");
        } else {
            aVar.M1().observe(getPartHost().getLifecycleOwner(), new b());
            aVar.N1().observe(getPartHost().getLifecycleOwner(), new c());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteRefusePart", 1, "onInitView rootView is null");
            return;
        }
        QLog.d("AVInviteRefusePart", 1, "onInitView.");
        Button button = (Button) view.findViewById(m.l.f76066l);
        this.f76457d = button;
        if (button == null) {
            QLog.d("AVInviteRefusePart", 1, "onInitView. do not find refuse view");
        }
        if (this.f76457d != null && this.f76458e && getContext() != null && getContext().getResources() != null) {
            com.tencent.av.utils.e.a(getContext().getResources(), this.f76457d, R.drawable.dcb, R.color.f157463q4, R.color.f157463q4);
        }
        mw.m mVar = (mw.m) RFWIocAbilityProvider.g().getIocInterface(mw.m.class, getPartRootView(), null);
        this.f76459f = mVar;
        this.f76460h = mVar.f();
        Button button2 = this.f76457d;
        if (button2 != null) {
            button2.setOnClickListener(new a());
        }
        if (this.f76458e) {
            A9();
        } else if (this.f76460h) {
            SessionInfo sessionInfo = this.f76459f.getSessionInfo();
            if (sessionInfo != null) {
                ba.setAccText(this.f76457d, getContext().getString(R.string.f170488so), sessionInfo.f73063p);
            }
        } else {
            ba.setAccText(this.f76457d, getContext().getString(R.string.f238287jc));
        }
        B9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        Button button = this.f76457d;
        if (button != null) {
            button.setCompoundDrawables(null, null, null, null);
            this.f76457d = null;
        }
    }
}
