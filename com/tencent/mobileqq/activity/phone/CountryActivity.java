package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CountryActivity extends IphoneTitleBarActivity implements IndexView.b, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private PinnedDividerListView f183832a0;

    /* renamed from: b0, reason: collision with root package name */
    IndexView f183833b0;

    /* renamed from: c0, reason: collision with root package name */
    private d f183834c0;

    /* renamed from: d0, reason: collision with root package name */
    ArrayList<PhoneCodeUtils.a> f183835d0;

    /* renamed from: e0, reason: collision with root package name */
    LinkedHashMap<String, Integer> f183836e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f183837f0;

    /* renamed from: g0, reason: collision with root package name */
    private EditText f183838g0;

    /* renamed from: h0, reason: collision with root package name */
    View f183839h0;

    /* renamed from: i0, reason: collision with root package name */
    View f183840i0;

    /* renamed from: j0, reason: collision with root package name */
    g f183841j0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountryActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else if (!CountryActivity.this.isFinishing()) {
                CountryActivity.this.f183841j0.show();
                CountryActivity.this.f183840i0.setAnimation(null);
                CountryActivity.this.f183839h0.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f183843d;

        b(int i3) {
            this.f183843d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountryActivity.this, i3);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            CountryActivity.this.f183840i0.setAnimation(null);
            CountryActivity.this.f183840i0.offsetTopAndBottom(this.f183843d);
            CountryActivity.this.f183840i0.requestLayout();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f183845d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f183846e;

        c(int i3, TranslateAnimation translateAnimation) {
            this.f183845d = i3;
            this.f183846e = translateAnimation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CountryActivity.this, Integer.valueOf(i3), translateAnimation);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            CountryActivity.this.f183840i0.offsetTopAndBottom(-this.f183845d);
            CountryActivity.this.f183839h0.setVisibility(0);
            CountryActivity.this.f183833b0.setVisibility(0);
            CountryActivity.this.f183840i0.startAnimation(this.f183846e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class d extends PinnedDividerListView.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
                return;
            }
            CountryActivity countryActivity = CountryActivity.this;
            ((TextView) view).setText(CountryActivity.this.f183835d0.get(countryActivity.f183836e0.get(countryActivity.f183835d0.get(i3).f307047a).intValue()).f307047a);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return CountryActivity.this.f183835d0.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return R.layout.f168366u3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return CountryActivity.this.f183835d0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return !CountryActivity.this.f183835d0.get(i3).f307048b ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                PhoneCodeUtils.a aVar = CountryActivity.this.f183835d0.get(i3);
                if (getItemViewType(i3) == 0) {
                    if (view == null) {
                        view = CountryActivity.this.getLayoutInflater().inflate(getDividerLayout(), viewGroup, false);
                    }
                    ((TextView) view).setText(aVar.f307047a);
                } else {
                    if (view == null) {
                        view = CountryActivity.I2(viewGroup, CountryActivity.this.getLayoutInflater(), false);
                        view.setOnClickListener(CountryActivity.this);
                    }
                    CountryActivity.H2(view, aVar);
                }
                view.setVisibility(0);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            return CountryActivity.this.f183835d0.get(i3).f307048b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f183849a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f183850b;

        /* renamed from: c, reason: collision with root package name */
        public PhoneCodeUtils.a f183851c;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<PhoneCodeUtils.a> f183852d;

        /* renamed from: e, reason: collision with root package name */
        private String f183853e;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountryActivity.this);
            } else {
                this.f183852d = CountryActivity.this.f183835d0;
                this.f183853e = "";
            }
        }

        private int a(PhoneCodeUtils.a aVar) {
            String str;
            if (aVar.f307048b || (str = this.f183853e) == null || str.equals("")) {
                return 0;
            }
            String str2 = aVar.f307050d;
            String str3 = aVar.f307049c;
            String str4 = aVar.f307051e;
            if (str4 != null) {
                str4 = str4.toLowerCase();
            }
            String d16 = ChnToSpell.d(str3, 1);
            String d17 = ChnToSpell.d(str3, 2);
            if (!str2.equals(this.f183853e) && !str3.equals(this.f183853e) && !d16.equals(this.f183853e) && !d17.equals(this.f183853e)) {
                if (str4 == null || !str4.equals(this.f183853e)) {
                    if (str2.indexOf(this.f183853e) == 0 || str3.indexOf(this.f183853e) == 0 || d16.indexOf(this.f183853e) == 0 || d17.indexOf(this.f183853e) == 0 || (str4 != null && str4.indexOf(this.f183853e) == 0)) {
                        return 2;
                    }
                    if (str2.indexOf(this.f183853e) <= 0 && str3.indexOf(this.f183853e) <= 0 && d16.indexOf(this.f183853e) <= 0 && d17.indexOf(this.f183853e) <= 0) {
                        return 0;
                    }
                    return 1;
                }
                return 3;
            }
            return 3;
        }

        public void b(String str) {
            ArrayList<PhoneCodeUtils.a> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.equals("hk")) {
                lowerCase = "xianggang";
            }
            if (lowerCase.equals("uk")) {
                lowerCase = "united kingdom";
            }
            if (lowerCase.startsWith(this.f183853e)) {
                arrayList = this.f183852d;
            } else {
                arrayList = CountryActivity.this.f183835d0;
            }
            this.f183853e = lowerCase;
            ArrayList<PhoneCodeUtils.a> arrayList2 = new ArrayList<>(8);
            Iterator<PhoneCodeUtils.a> it = arrayList.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                PhoneCodeUtils.a next = it.next();
                int a16 = a(next);
                if (a16 == 3) {
                    arrayList2.add(i3, next);
                    i3++;
                } else if (a16 == 2) {
                    arrayList2.add(i16 + i3, next);
                    i16++;
                } else if (a16 == 1) {
                    arrayList2.add(next);
                }
            }
            this.f183852d = arrayList2;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f183852d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = CountryActivity.I2(viewGroup, CountryActivity.this.getLayoutInflater(), true);
                    view.setOnClickListener(CountryActivity.this);
                }
                CountryActivity.H2(view, this.f183852d.get(i3));
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g extends ReportDialog implements View.OnClickListener, View.OnTouchListener, TextWatcher {
        static IPatchRedirector $redirector_;
        private ListView C;
        private f D;
        EditText E;
        private TextView F;
        private View G;
        ImageButton H;

        public g(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountryActivity.this, (Object) context);
                return;
            }
            requestWindowFeature(1);
            getWindow().setSoftInputMode(36);
            getWindow().setBackgroundDrawable(new ColorDrawable());
            setContentView(R.layout.f167811i7);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = -1;
            attributes.windowAnimations = android.R.style.Animation;
            attributes.gravity = 51;
            EditText editText = (EditText) findViewById(R.id.et_search_keyword);
            this.E = editText;
            editText.addTextChangedListener(this);
            this.E.setSelection(0);
            this.E.requestFocus();
            ImageButton imageButton = (ImageButton) findViewById(R.id.ib_clear_text);
            this.H = imageButton;
            imageButton.setOnClickListener(this);
            Button button = (Button) findViewById(R.id.btn_cancel_search);
            button.setVisibility(0);
            button.setOnClickListener(this);
            this.G = findViewById(R.id.result_layout);
            TextView textView = (TextView) findViewById(R.id.f166412fa0);
            this.F = textView;
            textView.setCompoundDrawables(null, null, null, null);
            this.F.setText(R.string.h_i);
            findViewById(R.id.ijs).setVisibility(8);
            this.C = (ListView) findViewById(R.id.search_result_list);
            f fVar = new f();
            this.D = fVar;
            this.C.setAdapter((ListAdapter) fVar);
            this.C.setOnTouchListener(this);
        }

        void N(String str) {
            if (!str.equals("") && str.trim().length() != 0) {
                this.G.setVisibility(0);
                this.D.b(str);
                if (this.D.getCount() == 0) {
                    this.F.setVisibility(0);
                } else {
                    this.F.setVisibility(8);
                }
                this.D.notifyDataSetChanged();
                return;
            }
            this.G.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) editable);
                return;
            }
            String trim = this.E.getText().toString().trim();
            N(trim);
            if (trim.equals("")) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                super.dismiss();
            } catch (Exception unused) {
            } catch (Throwable th5) {
                sy3.a.a(this);
                throw th5;
            }
            sy3.a.a(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.btn_cancel_search) {
                    dismiss();
                } else if (id5 == R.id.ib_clear_text) {
                    this.E.setText("");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((InputMethodManager) CountryActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    public CountryActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183835d0 = new ArrayList<>();
            this.f183836e0 = new LinkedHashMap<>();
        }
    }

    static void H2(View view, PhoneCodeUtils.a aVar) {
        e eVar = (e) view.getTag();
        eVar.f183849a.setText(aVar.f307049c);
        eVar.f183850b.setText(Marker.ANY_NON_NULL_MARKER + aVar.f307050d);
        eVar.f183851c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View I2(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168367u4, viewGroup, false);
        if (z16) {
            inflate.setPadding(inflate.getPaddingLeft(), inflate.getPaddingTop(), (int) al.a(BaseApplicationImpl.sApplication, 40.0f), inflate.getPaddingBottom());
        }
        e eVar = new e();
        eVar.f183849a = (TextView) inflate.findViewById(R.id.bar);
        eVar.f183850b = (TextView) inflate.findViewById(R.id.baq);
        inflate.setTag(eVar);
        return inflate;
    }

    public void J2(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        e eVar = (e) view.getTag();
        if (eVar.f183851c != null) {
            g gVar = this.f183841j0;
            if (gVar != null && gVar.isShowing() && !super.isFinishing()) {
                this.f183841j0.dismiss();
            }
            Intent intent = new Intent();
            intent.putExtra("k_name", eVar.f183851c.f307049c);
            intent.putExtra("k_code", eVar.f183851c.f307050d);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f168365u2);
        String[] stringArray = getResources().getStringArray(R.array.f155225bb);
        ArrayList<PhoneCodeUtils.a> g16 = PhoneCodeUtils.g(k.a(this, "internationalCode.json"));
        if (g16 == null) {
            g16 = this.f183835d0;
        }
        this.f183835d0 = g16;
        LinkedHashMap<String, Integer> e16 = PhoneCodeUtils.e(stringArray, g16);
        if (e16 == null) {
            e16 = this.f183836e0;
        }
        this.f183836e0 = e16;
        setTitle(HardCodeUtil.qqStr(R.string.l4v));
        this.leftView.setText(R.string.button_back);
        View findViewById = findViewById(R.id.rlCommenTitle);
        this.f183839h0 = findViewById;
        this.f183840i0 = (View) findViewById.getParent();
        this.f183832a0 = (PinnedDividerListView) findViewById(R.id.bas);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.search_box, (ViewGroup) this.f183832a0, false);
        this.f183837f0 = inflate;
        inflate.setPadding(0, 0, 40, 0);
        this.f183837f0.findViewById(R.id.btn_cancel_search).setVisibility(8);
        EditText editText = (EditText) this.f183837f0.findViewById(R.id.et_search_keyword);
        this.f183838g0 = editText;
        editText.setFocusableInTouchMode(false);
        this.f183838g0.setCursorVisible(false);
        this.f183838g0.setOnClickListener(this);
        AccessibilityUtil.h(this.f183837f0);
        this.f183832a0.addHeaderView(this.f183837f0);
        d dVar = new d();
        this.f183834c0 = dVar;
        this.f183832a0.setAdapter((ListAdapter) dVar);
        IndexView indexView = (IndexView) findViewById(R.id.djg);
        this.f183833b0 = indexView;
        indexView.setIndex(stringArray, true);
        this.f183833b0.setOnIndexChangedListener(this);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view == this.f183838g0) {
            g gVar = new g(this);
            this.f183841j0 = gVar;
            gVar.setCanceledOnTouchOutside(true);
            int height = this.f183839h0.getHeight();
            float f16 = -height;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
            translateAnimation.setDuration(300L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new a());
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
            translateAnimation2.setDuration(300L);
            translateAnimation2.setAnimationListener(new b(height));
            this.f183841j0.setOnDismissListener(new c(height, translateAnimation2));
            this.f183840i0.startAnimation(translateAnimation);
        } else {
            J2(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if ("$".equals(str)) {
            this.f183832a0.setSelection(0);
        } else {
            PinnedDividerListView pinnedDividerListView = this.f183832a0;
            pinnedDividerListView.setSelection(pinnedDividerListView.getHeaderViewsCount() + this.f183836e0.get(str).intValue());
        }
    }
}
