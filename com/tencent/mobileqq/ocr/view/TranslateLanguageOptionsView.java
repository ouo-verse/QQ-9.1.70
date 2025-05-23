package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TranslateLanguageOptionsView extends PopupWindow implements RadioGroup.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private RadioGroup f254919d;

    /* renamed from: e, reason: collision with root package name */
    private a f254920e;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(int i3, b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f254923a;

        /* renamed from: b, reason: collision with root package name */
        public String f254924b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    TranslateLanguageOptionsView(Context context, View view, int i3, int i16) {
        super(view, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.b_7);
        this.f254919d = radioGroup;
        radioGroup.setOnCheckedChangeListener(this);
    }

    public static TranslateLanguageOptionsView a(Activity activity, List<b> list, int i3, a aVar) {
        ViewGroup viewGroup = null;
        if (activity == null || list == null || list.size() <= 0) {
            return null;
        }
        activity.getResources();
        int c16 = x.c(activity, 36.0f);
        int c17 = x.c(activity, 150.0f);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.ayt, (ViewGroup) null);
        BounceScrollView bounceScrollView = (BounceScrollView) inflate.findViewById(R.id.ti9);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.b_7);
        int i16 = 78;
        RadioButton radioButton = null;
        int i17 = 0;
        while (i17 < list.size()) {
            b bVar = list.get(i17);
            RadioButton radioButton2 = (RadioButton) LayoutInflater.from(activity).inflate(R.layout.ays, viewGroup);
            radioButton2.setText(bVar.f254923a);
            radioButton2.setTag(bVar);
            radioButton2.setId(i17);
            if (i17 == i3) {
                radioButton2.setChecked(true);
                radioButton = radioButton2;
            }
            radioGroup.addView(radioButton2, i17, new LinearLayout.LayoutParams(-1, -2));
            i16 += c16;
            i17++;
            viewGroup = null;
        }
        if (i16 > x.c(activity, 300.0f)) {
            i16 = x.c(activity, 300.0f);
        }
        if (radioButton != null) {
            bounceScrollView.post(new Runnable(radioButton, bounceScrollView) { // from class: com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RadioButton f254921d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ BounceScrollView f254922e;

                {
                    this.f254921d = radioButton;
                    this.f254922e = bounceScrollView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) radioButton, (Object) bounceScrollView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    int bottom = (this.f254921d.getBottom() + this.f254921d.getPaddingBottom()) - this.f254922e.getHeight();
                    if (bottom > 0) {
                        this.f254922e.scrollBy(0, bottom);
                        if (QLog.isColorLevel()) {
                            QLog.d("TranslateLanguageOptionsView", 2, "compute detail, bottom:", Integer.valueOf(this.f254921d.getBottom()), " padding:", Integer.valueOf(this.f254921d.getPaddingBottom()), " viewHeight:", Integer.valueOf(this.f254922e.getHeight()), " scrollHeight:", Integer.valueOf(bottom));
                        }
                    }
                }
            });
        }
        TranslateLanguageOptionsView translateLanguageOptionsView = new TranslateLanguageOptionsView(activity, inflate, c17, i16);
        translateLanguageOptionsView.setAnimationStyle(R.style.f173310t);
        translateLanguageOptionsView.setBackgroundDrawable(new ColorDrawable(0));
        translateLanguageOptionsView.setFocusable(true);
        translateLanguageOptionsView.setOutsideTouchable(true);
        translateLanguageOptionsView.b(aVar);
        return translateLanguageOptionsView;
    }

    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f254920e = aVar;
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i3) {
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) radioGroup, i3);
        } else {
            try {
                b bVar = (b) ((RadioButton) radioGroup.getChildAt(i3)).getTag();
                a aVar = this.f254920e;
                if (aVar != null) {
                    aVar.a(i3, bVar);
                }
                dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
    }
}
