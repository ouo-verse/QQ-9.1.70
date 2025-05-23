package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.mobileqq.utils.s;
import com.tencent.qqnt.selectable.i;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CommonMenuWrapper implements com.tencent.qqnt.textpreview.inject.a {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static final int f186110l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f186111m;

    /* renamed from: a, reason: collision with root package name */
    private i f186112a;

    /* renamed from: b, reason: collision with root package name */
    private BubblePopupWindow f186113b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnClickListener f186114c;

    /* renamed from: d, reason: collision with root package name */
    private BubblePopupWindow.OnDismissListener f186115d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.utils.dialogutils.a f186116e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.utils.dialogutils.a f186117f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.utils.dialogutils.a f186118g;

    /* renamed from: h, reason: collision with root package name */
    private int f186119h;

    /* renamed from: i, reason: collision with root package name */
    private int f186120i;

    /* renamed from: j, reason: collision with root package name */
    public int f186121j;

    /* renamed from: k, reason: collision with root package name */
    public int f186122k;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69330);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            f186110l = ViewUtils.dpToPx(72.0f);
            f186111m = ViewUtils.dpToPx(63.0f);
        }
    }

    public CommonMenuWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void j() {
        if (this.f186112a != null) {
        } else {
            throw new IllegalStateException("Delegate has not bound.");
        }
    }

    public static int[] k(View view) {
        int[] iArr = {0, ViewUtils.getScreenWidth()};
        if (view != null && view.getRootView() != null) {
            Context context = view.getContext();
            if (!(context instanceof QBaseActivity)) {
                return iArr;
            }
            FragmentManager supportFragmentManager = ((QBaseActivity) context).getSupportFragmentManager();
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.ve_);
            if (findFragmentById == null) {
                findFragmentById = supportFragmentManager.findFragmentById(R.id.ve8);
            }
            Fragment findFragmentById2 = supportFragmentManager.findFragmentById(R.id.vea);
            if (findFragmentById != null && findFragmentById.isVisible() && findFragmentById.getView() != null && findFragmentById2 != null && findFragmentById2.isVisible() && findFragmentById2.getView() != null && view.getRootView().getWidth() != findFragmentById.getView().getWidth()) {
                iArr[0] = findFragmentById2.getView().getWidth();
                iArr[1] = findFragmentById.getView().getWidth();
            }
        }
        return iArr;
    }

    @Override // com.tencent.qqnt.selectable.k
    public void a(View view, int i3, int i16, int i17) {
        com.tencent.mobileqq.utils.dialogutils.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        j();
        if (this.f186112a.isSelected()) {
            if (this.f186112a.length() == this.f186112a.f() - this.f186112a.q()) {
                aVar = this.f186116e;
            } else {
                aVar = this.f186117f;
                if (aVar == null) {
                    if (this.f186118g == null) {
                        this.f186118g = new com.tencent.mobileqq.utils.dialogutils.a();
                        l();
                    }
                    aVar = this.f186118g;
                }
            }
        } else {
            aVar = this.f186116e;
        }
        q(aVar, view, i3, i16, i17);
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f186121j;
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.f186122k;
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            m(i3);
            n(i16);
        }
    }

    @Override // com.tencent.qqnt.selectable.k
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f186113b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.f186113b.dismiss();
        }
    }

    @Override // com.tencent.qqnt.selectable.k
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f186120i;
    }

    @Override // com.tencent.qqnt.selectable.k
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f186119h;
    }

    @Override // com.tencent.qqnt.selectable.k
    public void g(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
        } else {
            this.f186112a = iVar;
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public void h(com.tencent.mobileqq.utils.dialogutils.a aVar, boolean z16) {
        com.tencent.mobileqq.utils.dialogutils.b[] i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, aVar, Boolean.valueOf(z16));
            return;
        }
        this.f186116e = aVar;
        this.f186117f = null;
        if (z16 && aVar != null && (i3 = aVar.i()) != null && i3.length > 0) {
            ArrayList arrayList = new ArrayList(Arrays.asList(i3));
            int i17 = 0;
            while (true) {
                if (i17 >= i3.length) {
                    break;
                }
                if (i3[i17].b() == R.id.bbi) {
                    i16 = i17;
                    break;
                }
                i17++;
            }
            com.tencent.mobileqq.utils.dialogutils.b bVar = new com.tencent.mobileqq.utils.dialogutils.b(R.id.ilw, HardCodeUtil.qqStr(R.string.kur));
            bVar.d(R.drawable.cbm);
            arrayList.add(i16 + 1, bVar);
            this.f186117f = new com.tencent.mobileqq.utils.dialogutils.a();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f186117f.c((com.tencent.mobileqq.utils.dialogutils.b) it.next());
            }
        }
    }

    @Override // com.tencent.qqnt.selectable.k
    public boolean isShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        BubblePopupWindow bubblePopupWindow = this.f186113b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.utils.dialogutils.a aVar = this.f186118g;
        if (aVar != null) {
            aVar.b(R.id.bbi, HardCodeUtil.qqStr(R.string.kuq), R.drawable.cb5);
            this.f186118g.b(R.id.ilw, HardCodeUtil.qqStr(R.string.kuo), R.drawable.cbm);
            this.f186118g.b(R.id.cjs, HardCodeUtil.qqStr(R.string.kus), R.drawable.cbd);
            this.f186118g.b(R.id.c39, HardCodeUtil.qqStr(R.string.kup), R.drawable.cbc);
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f186119h = i3;
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f186120i = i3;
        }
    }

    protected void o(View view, int i3, int i16, com.tencent.mobileqq.utils.dialogutils.a aVar, int i17, boolean z16, Activity activity, boolean z17, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, view, Integer.valueOf(i3), Integer.valueOf(i16), aVar, Integer.valueOf(i17), Boolean.valueOf(z16), activity, Boolean.valueOf(z17), num);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f186113b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.f186113b.dismiss();
            this.f186113b = null;
        }
        BubblePopupWindow bubblePopupWindow2 = new BubblePopupWindow(-2, -2);
        this.f186113b = bubblePopupWindow2;
        QQCustomMenuNoIconLayout a16 = s.a(bubblePopupWindow2, view.getContext(), aVar, this.f186114c);
        a16.setIgnoreTouchLocation(z17);
        a16.setContainerBottom(num);
        this.f186113b.setContentView(a16);
        this.f186113b.setBackgroundDrawable(new ColorDrawable(0));
        this.f186113b.setOutsideTouchable(z16);
        if (z16) {
            this.f186113b.setFocusable(true);
        }
        this.f186113b.setSoftInputMode(1);
        this.f186113b.setInputMethodMode(2);
        BubblePopupWindow bubblePopupWindow3 = this.f186113b;
        if (i17 == 1) {
            z18 = true;
        }
        bubblePopupWindow3.setKeepAbove(z18);
        this.f186113b.setOnDismissListener(this.f186115d);
        view.post(new Runnable(activity, view, i3, i16) { // from class: com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f186123d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f186124e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f186125f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f186126h;

            {
                this.f186123d = activity;
                this.f186124e = view;
                this.f186125f = i3;
                this.f186126h = i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, CommonMenuWrapper.this, activity, view, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f186123d;
                if (activity2 != null) {
                    if (!activity2.isFinishing() && !this.f186123d.isDestroyed()) {
                        int[] k3 = CommonMenuWrapper.k(this.f186124e);
                        CommonMenuWrapper.this.f186113b.showAtLocation(this.f186124e, this.f186125f, this.f186126h, true, k3[0], k3[1]);
                        return;
                    }
                    return;
                }
                Context context = this.f186124e.getContext();
                if (context instanceof Activity) {
                    Activity activity3 = (Activity) context;
                    if (!activity3.isFinishing() && !activity3.isDestroyed()) {
                        int[] k16 = CommonMenuWrapper.k(this.f186124e);
                        CommonMenuWrapper.this.f186113b.showAtLocation(this.f186124e, this.f186125f, this.f186126h, true, k16[0], k16[1]);
                    }
                }
            }
        });
        this.f186119h = i3;
        this.f186120i = i16;
    }

    protected void p(View view, int i3, int i16, com.tencent.mobileqq.utils.dialogutils.a aVar, int i17, boolean z16, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, view, Integer.valueOf(i3), Integer.valueOf(i16), aVar, Integer.valueOf(i17), Boolean.valueOf(z16), num);
        } else {
            o(view, i3, i16, aVar, i17, z16, null, true, num);
        }
    }

    void q(com.tencent.mobileqq.utils.dialogutils.a aVar, View view, int i3, int i16, int i17) {
        p(view, i3, i16, aVar, i17, false, null);
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onClickListener);
        } else {
            this.f186114c = onClickListener;
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.a
    public void setPoint(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f186122k = i3;
            this.f186121j = i16;
        }
    }
}
