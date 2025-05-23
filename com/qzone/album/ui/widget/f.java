package com.qzone.album.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private View f44331a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f44332b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f44333c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f44334d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f44335e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f44336f;

    /* renamed from: g, reason: collision with root package name */
    private String f44337g;

    /* renamed from: h, reason: collision with root package name */
    private String f44338h;

    /* renamed from: i, reason: collision with root package name */
    private String f44339i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44340j = false;

    /* renamed from: k, reason: collision with root package name */
    private int[] f44341k;

    public f(View view, Activity activity) {
        View inflate = ((ViewStub) view.findViewById(R.id.ase)).inflate();
        this.f44331a = inflate;
        if (inflate == null || activity == null) {
            return;
        }
        this.f44332b = (TextView) inflate.findViewById(R.id.hdf);
        this.f44333c = (ViewGroup) this.f44331a.findViewById(R.id.hdd);
        this.f44334d = (TextView) this.f44331a.findViewById(R.id.hda);
        this.f44335e = (TextView) this.f44331a.findViewById(R.id.hdb);
        this.f44336f = (TextView) this.f44331a.findViewById(R.id.hdc);
        this.f44337g = activity.getString(R.string.gaz);
        this.f44338h = activity.getString(R.string.gbe);
        this.f44339i = activity.getString(R.string.gcb);
    }

    private void d(int i3) {
        int[] iArr;
        TextView textView = this.f44334d;
        if (textView == null || this.f44335e == null || this.f44336f == null || this.f44333c == null) {
            return;
        }
        int i16 = 0;
        if (i3 == 0) {
            textView.setVisibility(0);
            this.f44335e.setVisibility(0);
            this.f44336f.setVisibility(0);
        } else if (i3 == 1) {
            textView.setVisibility(8);
            this.f44335e.setVisibility(0);
            this.f44336f.setVisibility(0);
        } else if (i3 == 2) {
            textView.setVisibility(8);
            this.f44335e.setVisibility(8);
            this.f44336f.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f44335e.setVisibility(8);
            this.f44336f.setVisibility(8);
        }
        if (this.f44340j && (iArr = this.f44341k) != null && iArr.length == 3) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f44334d);
            arrayList.add(this.f44335e);
            arrayList.add(this.f44336f);
            while (true) {
                int[] iArr2 = this.f44341k;
                if (i16 >= iArr2.length) {
                    return;
                }
                if (iArr2[i16] == 0) {
                    ((TextView) arrayList.get(i16)).setVisibility(8);
                }
                i16++;
            }
        } else {
            ViewGroup viewGroup = this.f44333c;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        }
    }

    public void b(int[] iArr, int i3) {
        if (this.f44334d != null && this.f44335e != null && this.f44336f != null && iArr != null && iArr.length == 3) {
            String[] a16 = a(iArr);
            if (a16 != null && a16.length == 3) {
                this.f44341k = iArr;
                this.f44340j = true;
                this.f44334d.setText(a16[0] + this.f44337g);
                this.f44335e.setText(a16[1] + this.f44338h);
                this.f44336f.setText(a16[2] + this.f44339i);
                ViewGroup viewGroup = this.f44333c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                d(i3);
                return;
            }
            this.f44340j = false;
            return;
        }
        this.f44340j = false;
    }

    public void c(boolean z16) {
        this.f44331a.setVisibility(z16 ? 0 : 8);
    }

    public void e(int i3, String str) {
        TextView textView = this.f44332b;
        if (textView == null || this.f44333c == null) {
            return;
        }
        textView.setText(str);
        d(i3);
    }

    private String[] a(int[] iArr) {
        String str;
        if (iArr == null || iArr.length != 3) {
            return null;
        }
        String[] strArr = new String[3];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i16 = iArr[i3];
            int i17 = i16 / 10000;
            if (i17 > 0) {
                str = i17 + "W+";
            } else {
                try {
                    str = String.valueOf(i16);
                } catch (Exception e16) {
                    QZLog.e("TitleBarAlbumInfoPanel", "Error in casting album count info", e16);
                    str = "0";
                }
            }
            strArr[i3] = str;
        }
        return strArr;
    }
}
