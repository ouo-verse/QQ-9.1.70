package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class j extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f349696d;

    /* renamed from: e, reason: collision with root package name */
    Context f349697e;

    /* renamed from: f, reason: collision with root package name */
    public int f349698f;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f349699h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<com.tencent.mobileqq.voicechange.c> f349700i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f349701m;

    public j(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f349696d = 4;
        this.f349701m = false;
        this.f349697e = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ArrayList<com.tencent.mobileqq.voicechange.c> arrayList = this.f349700i;
        if (arrayList != null) {
            int size = arrayList.size();
            return ((size + r1) - 1) / this.f349696d;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        ArrayList<com.tencent.mobileqq.voicechange.c> arrayList = this.f349700i;
        if (arrayList != null && arrayList.size() > i3) {
            return this.f349700i.get(i3);
        }
        return null;
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
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.widget.LinearLayout, android.view.ViewGroup] */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        com.tencent.mobileqq.voicechange.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            int i16 = this.f349696d * i3;
            if (view == 0) {
                view = new LinearLayout(this.f349697e, null);
                view.setOrientation(0);
                LayoutInflater from = LayoutInflater.from(this.f349697e);
                for (int i17 = 0; i17 < this.f349696d; i17++) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 1.0f;
                    if (from == null) {
                        from = LayoutInflater.from(this.f349697e);
                    }
                    view.addView(new ab().b(this.f349697e), layoutParams);
                }
            }
            ViewGroup viewGroup2 = view;
            if (i3 == 0) {
                viewGroup2.setPadding(BaseAIOUtils.f(15.0f, this.f349697e.getResources()), BaseAIOUtils.f(14.0f, this.f349697e.getResources()), BaseAIOUtils.f(15.0f, this.f349697e.getResources()), BaseAIOUtils.f(8.0f, this.f349697e.getResources()));
            } else {
                viewGroup2.setPadding(BaseAIOUtils.f(15.0f, this.f349697e.getResources()), BaseAIOUtils.f(7.0f, this.f349697e.getResources()), BaseAIOUtils.f(15.0f, this.f349697e.getResources()), BaseAIOUtils.f(8.0f, this.f349697e.getResources()));
            }
            for (int i18 = 0; i18 < this.f349696d; i18++) {
                int i19 = i16 + i18;
                ChangeVoiceView changeVoiceView = (ChangeVoiceView) viewGroup2.getChildAt(i18);
                if (changeVoiceView == null) {
                    QLog.e("ChangeVoiceListAdapter", 1, "getView view == null,view=" + viewGroup2.getChildAt(i18));
                } else {
                    changeVoiceView.E = this.f349698f;
                    ArrayList<com.tencent.mobileqq.voicechange.c> arrayList = this.f349700i;
                    if (arrayList != null && i19 < arrayList.size()) {
                        cVar = this.f349700i.get(i19);
                    } else {
                        cVar = null;
                    }
                    changeVoiceView.e(cVar);
                    if (this.f349701m) {
                        changeVoiceView.f();
                    }
                    if (cVar != null) {
                        changeVoiceView.setOnClickListener(this.f349699h);
                    } else {
                        changeVoiceView.setOnClickListener(null);
                    }
                }
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
