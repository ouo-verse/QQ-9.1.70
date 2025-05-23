package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LangSettingFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private static final List<Integer> F;
    private Dialog C;
    private ActionSheet D;
    private int E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f211161d;

        a(int i3) {
            this.f211161d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LangSettingFragment.this, i3);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else if (i3 == 0) {
                LangSettingFragment.this.Dh(this.f211161d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LangSettingFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LangSettingFragment.this.C.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f211164d;

        c(int i3) {
            this.f211164d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LangSettingFragment.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int i3 = this.f211164d;
                if (i3 >= 0 && i3 < LangSettingFragment.F.size()) {
                    LangSettingFragment.this.E = this.f211164d;
                    LangSettingFragment.this.Ah(((Integer) LangSettingFragment.F.get(this.f211164d)).intValue());
                }
                if (LangSettingFragment.this.C != null && LangSettingFragment.this.C.isShowing()) {
                    LangSettingFragment.this.C.dismiss();
                }
                if (LangSettingFragment.this.D != null && LangSettingFragment.this.D.isShowing()) {
                    LangSettingFragment.this.D.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f211167d;

            a(int i3) {
                this.f211167d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, i3);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QQAppInterface qQAppInterface;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (d.this.b(this.f211167d) && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null) {
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A612", "0X800A612", 0, 0, "", "", "", "");
                    }
                    if (LangSettingFragment.this.E != ((Integer) view.getTag()).intValue()) {
                        LangSettingFragment.this.Ch(((Integer) view.getTag()).intValue());
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LangSettingFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(int i3) {
            if (i3 >= LangSettingFragment.F.size() || i3 < 0 || ((Integer) LangSettingFragment.F.get(i3)).intValue() != 1033) {
                return false;
            }
            return true;
        }

        private View.OnClickListener c(int i3) {
            return new a(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return LangSettingFragment.F.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View] */
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            FormSimpleItem formSimpleItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                formSimpleItem = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                FormSimpleItem formSimpleItem2 = new FormSimpleItem(LangSettingFragment.this.getBaseActivity());
                if (i3 == LangSettingFragment.this.E) {
                    formSimpleItem2.setRightIcon(LangSettingFragment.this.getResources().getDrawable(R.drawable.qq_account_select_icon));
                } else {
                    formSimpleItem2.setRightIcon(null);
                }
                if (i3 < LangSettingFragment.F.size()) {
                    formSimpleItem2.setLeftText(LangSettingFragment.this.zh(i3, false));
                }
                formSimpleItem2.setTag(Integer.valueOf(i3));
                formSimpleItem2.setOnClickListener(c(i3));
                formSimpleItem2.setBgType(com.tencent.mobileqq.widget.o.c(getCount(), i3));
                formSimpleItem = formSimpleItem2;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return formSimpleItem;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            F = Arrays.asList(2052, 1033);
        }
    }

    public LangSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i3) {
        ThreadManagerV2.executeOnSubThread(new Runnable(i3, new Runnable() { // from class: com.tencent.mobileqq.fragment.LangSettingFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LangSettingFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                LocaleManager.restartOnLocaleUpdate(LangSettingFragment.this.getBaseActivity());
                LangSettingFragment.this.getBaseActivity().finish();
                com.tencent.mobileqq.app.nthiddenchat.b.a(LangSettingFragment.this.getBaseActivity(), GeneralSettingActivity.class);
            }
        }) { // from class: com.tencent.mobileqq.fragment.LangSettingFragment.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f211159d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Runnable f211160e;

            {
                this.f211159d = i3;
                this.f211160e = r7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, LangSettingFragment.this, Integer.valueOf(i3), r7);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    LocaleManager.setLocale(LangSettingFragment.this.getBaseActivity(), this.f211159d);
                    LangSettingFragment.this.getBaseActivity().runOnUiThread(this.f211160e);
                }
            }
        });
    }

    private void Bh() {
        int localeId = LocaleManager.getLocaleId();
        int i3 = 0;
        if (localeId == 0) {
            this.E = 0;
            return;
        }
        while (true) {
            List<Integer> list = F;
            if (i3 < list.size()) {
                if (list.get(i3).intValue() == localeId) {
                    this.E = i3;
                    return;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(int i3) {
        if (this.D == null) {
            this.D = ActionSheet.create(getBaseActivity());
        }
        this.D.setMainTitle(String.format(getResources().getString(R.string.irq), zh(i3, true)));
        this.D.addButton(String.format(getResources().getString(R.string.irp), zh(i3, true)));
        this.D.addCancelButton(getResources().getString(R.string.iro));
        this.D.setOnButtonClickListener(new a(i3));
        this.D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(int i3) {
        Dialog dialog;
        Dialog dialog2 = this.C;
        if (dialog2 != null && dialog2.isShowing()) {
            this.C.dismiss();
            this.C = null;
        }
        this.C = com.tencent.mobileqq.util.t.a(getBaseActivity(), R.string.bbh, R.string.bbf, R.string.bbe, R.string.bbg, new b(), new c(i3));
        if (!getBaseActivity().isFinishing() && (dialog = this.C) != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zh(int i3, boolean z16) {
        List<Integer> list = F;
        int intValue = list.get(0).intValue();
        if (i3 >= 0 && i3 < list.size()) {
            intValue = list.get(i3).intValue();
        }
        return LocaleManager.getLocaleLanName(intValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Bh();
        setTitle(getResources().getString(R.string.vqz));
        ((ListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lp5)).setAdapter((ListAdapter) new d());
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A611", "0X800A5A7", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cbv;
    }
}
