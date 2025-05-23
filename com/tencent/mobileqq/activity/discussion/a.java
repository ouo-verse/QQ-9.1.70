package com.tencent.mobileqq.activity.discussion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BaseActivity f181870a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.discussion.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C7162a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        C7162a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 6;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int i16;
            int i17;
            int i18;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                view2 = (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(a.this.f181870a).inflate(R.layout.c1l, (ViewGroup) null);
                }
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 5) {
                                    i17 = R.drawable.ccg;
                                    i16 = R.string.f173139hj3;
                                    i18 = R.string.hw_;
                                } else {
                                    i16 = R.string.f172949g21;
                                    i17 = R.drawable.die;
                                    i18 = R.string.f172949g21;
                                }
                            } else {
                                i16 = R.string.hjd;
                                i17 = R.drawable.cci;
                                i18 = R.string.hwg;
                            }
                        } else {
                            i16 = R.string.hjo;
                            i17 = R.drawable.cco;
                            i18 = R.string.hwx;
                        }
                    } else {
                        i16 = R.string.hji;
                        i17 = R.drawable.ccl;
                        i18 = R.string.hwq;
                    }
                } else {
                    i16 = R.string.hjg;
                    i17 = R.drawable.cck;
                    i18 = R.string.hwp;
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.f164379vi);
                TextView textView = (TextView) view.findViewById(R.id.f164389w0);
                imageView.setImageResource(i17);
                textView.setText(i16);
                if (AppSetting.f99565y) {
                    view.setContentDescription(a.this.f181870a.getString(i18));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public a(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity);
        } else {
            this.f181870a = baseActivity;
        }
    }

    public ActionSheet b(AdapterView.OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ActionSheet) iPatchRedirector.redirect((short) 2, (Object) this, (Object) onItemClickListener);
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f181870a, null);
        GridView gridView = (GridView) View.inflate(this.f181870a, R.layout.c2_, null);
        gridView.setBackgroundDrawable(this.f181870a.getResources().getDrawable(R.drawable.actionsheet_bottom_normal));
        gridView.setAdapter((ListAdapter) new C7162a());
        gridView.setOnItemClickListener(onItemClickListener);
        actionSheet.addView(gridView);
        actionSheet.addCancelButton(R.string.cancel);
        return actionSheet;
    }
}
