package com.tencent.mobileqq.filemanageraux.link;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanageraux.link.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
final class e implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ActionSheet.OnButtonClickListenerV2 {
    static IPatchRedirector $redirector_;
    private final FormSimpleItem C;
    private final FormSwitchItem D;
    private ActionSheet E;

    /* renamed from: d, reason: collision with root package name */
    private final a f209648d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f209649e;

    /* renamed from: f, reason: collision with root package name */
    private final a.C7594a f209650f;

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f209651h;

    /* renamed from: i, reason: collision with root package name */
    private final FormSimpleItem f209652i;

    /* renamed from: m, reason: collision with root package name */
    private final FormSwitchItem f209653m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, View view, boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, view, Boolean.valueOf(z16));
            return;
        }
        this.f209648d = aVar;
        this.f209649e = z16;
        a.C7594a c7594a = new a.C7594a();
        this.f209650f = c7594a;
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        ArrayList arrayList = new ArrayList();
        this.f209651h = arrayList;
        arrayList.add(baseApplicationImpl.getString(R.string.vv7));
        arrayList.add(baseApplicationImpl.getString(R.string.vv6));
        arrayList.add(baseApplicationImpl.getString(R.string.vv8));
        FormSimpleItem formSimpleItem = (FormSimpleItem) view.findViewById(R.id.dvc);
        this.f209652i = formSimpleItem;
        if (z16) {
            i3 = R.string.w3z;
        } else {
            i3 = R.string.vv5;
        }
        formSimpleItem.setLeftText(baseApplicationImpl.getString(i3));
        formSimpleItem.setRightText((CharSequence) arrayList.get(a()));
        formSimpleItem.setOnClickListener(this);
        FormSwitchItem formSwitchItem = (FormSwitchItem) view.findViewById(R.id.f166861dv3);
        this.f209653m = formSwitchItem;
        this.C = (FormSimpleItem) view.findViewById(R.id.dvx);
        formSwitchItem.setChecked(c7594a.f209626b);
        formSwitchItem.setOnCheckedChangeListener(this);
        f(false);
        TextView textView = (TextView) view.findViewById(R.id.iip);
        if (z16) {
            i16 = R.string.f171454w40;
        } else {
            i16 = R.string.vv_;
        }
        textView.setText(baseApplicationImpl.getString(i16));
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) view.findViewById(R.id.duv);
        this.D = formSwitchItem2;
        formSwitchItem2.setChecked(c7594a.f209628d);
        formSwitchItem2.setOnCheckedChangeListener(this);
        formSwitchItem2.setVisibility(8);
        view.findViewById(R.id.f166860dv2).setVisibility(8);
        if (z16) {
            formSwitchItem.setVisibility(8);
            formSimpleItem.setBgType(0);
        }
    }

    private int a() {
        int i3 = this.f209650f.f209625a;
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        return 2;
    }

    private void e() {
        int i3;
        if (this.E == null) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this.f209648d.getBaseActivity(), null);
            this.E = actionSheet;
            if (this.f209649e) {
                i3 = R.string.w3z;
            } else {
                i3 = R.string.vv5;
            }
            actionSheet.setMainTitle(i3);
            Iterator<String> it = this.f209651h.iterator();
            while (it.hasNext()) {
                this.E.addRadioButton((CharSequence) it.next(), false);
            }
            this.E.addCancelButton(R.string.cancel);
            this.E.setOnButtonClickListenerV2(this);
        }
        this.E.clearAllRadioBtnCheckStatus();
        this.E.setRadioButtonChecked(a());
        if (!this.E.isShowing()) {
            this.E.show();
        }
    }

    private void f(boolean z16) {
        String str;
        int i3;
        int i16;
        FormSimpleItem formSimpleItem = this.C;
        a.C7594a c7594a = this.f209650f;
        if (c7594a.f209626b) {
            str = b.c(6);
        } else {
            str = "";
        }
        c7594a.f209627c = str;
        formSimpleItem.setRightText(str);
        FormSimpleItem formSimpleItem2 = this.C;
        if (this.f209650f.f209626b) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        formSimpleItem2.setVisibility(i3);
        FormSwitchItem formSwitchItem = this.f209653m;
        if (this.f209650f.f209626b) {
            i16 = 2;
        } else {
            i16 = 3;
        }
        formSwitchItem.setBgType(i16);
        if (z16) {
            this.f209648d.f4();
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
    public void OnClick(View view, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), str);
            return;
        }
        ActionSheet actionSheet = this.E;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.E.dismiss();
        }
        if (i3 == 0) {
            i16 = 1;
        } else if (i3 == 1) {
            i16 = 2;
        }
        a.C7594a c7594a = this.f209650f;
        if (i16 != c7594a.f209625a) {
            z16 = true;
        }
        c7594a.f209625a = i16;
        this.f209652i.setRightText(str);
        if (z16) {
            this.f209648d.f4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a.C7594a b() {
        return this.f209650f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        ActionSheet actionSheet = this.E;
        if (actionSheet != null) {
            actionSheet.superDismiss();
            this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z16) {
        FormSimpleItem formSimpleItem = this.f209652i;
        if (formSimpleItem != null) {
            formSimpleItem.setEnabled(z16);
        }
        FormSwitchItem formSwitchItem = this.f209653m;
        if (formSwitchItem != null) {
            formSwitchItem.setEnabled(z16);
        }
        FormSimpleItem formSimpleItem2 = this.C;
        if (formSimpleItem2 != null) {
            formSimpleItem2.setEnabled(z16);
        }
        FormSwitchItem formSwitchItem2 = this.D;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setEnabled(z16);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton.equals(this.f209653m.getSwitch())) {
            a.C7594a c7594a = this.f209650f;
            if (c7594a.f209626b == z16) {
                z17 = false;
            }
            c7594a.f209626b = z16;
            f(z17);
        } else if (compoundButton.equals(this.D.getSwitch())) {
            a.C7594a c7594a2 = this.f209650f;
            if (c7594a2.f209628d == z16) {
                z17 = false;
            }
            c7594a2.f209628d = z16;
            if (z17) {
                this.f209648d.f4();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else if (view.getId() == R.id.dvc) {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
