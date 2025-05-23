package com.tencent.mobileqq.filemanager.activity.favfile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends d {
    private Context C;
    private LinkedHashMap<String, List<FavFileInfo>> D;
    private BaseFileAssistantActivity E;
    private LayoutInflater F;
    private View.OnClickListener G;
    private View.OnClickListener H;
    private View.OnLongClickListener I;
    private c J;
    private int K;
    private int L;
    private boolean M;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.favfile.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7533b {

        /* renamed from: a, reason: collision with root package name */
        View[] f206566a;

        C7533b() {
            this.f206566a = new View[12];
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        View.OnClickListener a(TextView textView);

        boolean b();

        boolean c(FavFileInfo favFileInfo);

        boolean d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, BaseFileAssistantActivity baseFileAssistantActivity, Object obj, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnLongClickListener onLongClickListener) {
        super(baseFileAssistantActivity, obj);
        this.M = false;
        this.C = baseFileAssistantActivity;
        this.E = baseFileAssistantActivity;
        this.F = LayoutInflater.from(baseFileAssistantActivity);
        this.D = (LinkedHashMap) obj;
        this.G = onClickListener;
        this.H = onClickListener2;
        this.I = onLongClickListener;
        this.J = cVar;
        this.L = (int) (this.C.getResources().getDisplayMetrics().density * 2.0f);
        this.K = j();
    }

    private int j() {
        return ((int) (r0.widthPixels - (this.C.getResources().getDisplayMetrics().density * 6.0f))) / 4;
    }

    private int k(int i3, int i16) {
        if (i3 + 1 < this.D.keySet().size()) {
            return 1;
        }
        List<FavFileInfo> list = this.D.get(getGroup(i3));
        if (list != null || i16 != 0) {
            if (list == null || i16 != list.size()) {
                return 1;
            }
            return 2;
        }
        return 2;
    }

    private LinearLayout n() {
        LinearLayout linearLayout = new LinearLayout(this.C);
        linearLayout.setOrientation(0);
        linearLayout.setClickable(false);
        linearLayout.setLongClickable(false);
        linearLayout.setTag(new C7533b());
        return linearLayout;
    }

    @SuppressLint({"InflateParams"})
    private View o(int i3, int i16, View view) {
        FavFileInfo favFileInfo;
        ob1.c cVar;
        Object child = getChild(i3, i16);
        if (child != null) {
            favFileInfo = (FavFileInfo) child;
        } else {
            favFileInfo = null;
        }
        this.M = false;
        if (favFileInfo == null) {
            if (k(i3, i16) == 1 || this.J.d()) {
                return null;
            }
            ob1.c cVar2 = new ob1.c();
            View inflate = this.F.inflate(R.layout.all, (ViewGroup) null);
            inflate.setClickable(true);
            cVar2.f422330e = (TextView) inflate.findViewById(R.id.kxk);
            cVar2.f422331f = (ProgressBar) inflate.findViewById(R.id.i5n);
            cVar2.f422332g = (ImageView) inflate.findViewById(R.id.eex);
            cVar2.f422336k = true;
            cVar2.f422334i = i3;
            cVar2.f422333h = i16;
            inflate.setOnClickListener(this.J.a(cVar2.f422330e));
            inflate.setTag(cVar2);
            if (this.D.size() == 0) {
                inflate.setVisibility(8);
            } else {
                inflate.setVisibility(0);
                this.M = true;
            }
            if (this.J.b()) {
                cVar2.f422331f.setVisibility(0);
                cVar2.f422332g.setVisibility(8);
                cVar2.f422330e.setText(R.string.bat);
            } else {
                cVar2.f422331f.setVisibility(8);
                cVar2.f422332g.setVisibility(0);
                cVar2.f422330e.setText(R.string.b7p);
            }
            return inflate;
        }
        try {
            if (view == null) {
                view = this.F.inflate(R.layout.alu, (ViewGroup) null);
                cVar = new ob1.c();
                cVar.f422326a = (AsyncImageView) view.findViewById(R.id.image);
                cVar.f422328c = (QUICheckBox) view.findViewById(R.id.tuy);
                cVar.f422329d = (ImageView) view.findViewById(R.id.dc6);
                cVar.f422326a.setOnClickListener(this.H);
                cVar.f422328c.setOnClickListener(this.G);
                cVar.f422326a.setTag(cVar);
                cVar.f422328c.setTag(cVar);
                cVar.f422336k = false;
                view.setTag(cVar);
            } else {
                ob1.c cVar3 = (ob1.c) view.getTag();
                if (cVar3.f422336k) {
                    view = this.F.inflate(R.layout.alu, (ViewGroup) null);
                    cVar = new ob1.c();
                    cVar.f422326a = (AsyncImageView) view.findViewById(R.id.image);
                    cVar.f422328c = (QUICheckBox) view.findViewById(R.id.tuy);
                    cVar.f422329d = (ImageView) view.findViewById(R.id.dc6);
                    cVar.f422326a.setOnClickListener(this.H);
                    cVar.f422328c.setOnClickListener(this.G);
                    cVar.f422326a.setTag(cVar);
                    cVar.f422328c.setTag(cVar);
                    view.setTag(cVar);
                } else {
                    cVar = cVar3;
                }
            }
            cVar.f422335j = favFileInfo;
            cVar.f422334i = i3;
            cVar.f422333h = i16;
            cVar.f422326a.setAdjustViewBounds(false);
            cVar.f422326a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            cVar.f422326a.setDefaultImage(R.drawable.asd);
            AsyncImageView asyncImageView = cVar.f422326a;
            int i17 = this.K;
            asyncImageView.setAsyncClipSize(i17, i17);
            cVar.f422336k = false;
            r(favFileInfo, cVar.f422326a);
            String str = this.E.getString(R.string.b7q) + favFileInfo.f207675h;
            cVar.f422326a.setContentDescription(str);
            if (this.E.r3()) {
                cVar.f422328c.setVisibility(0);
                cVar.f422328c.setClickable(true);
                if (this.J.c(favFileInfo)) {
                    str = str + this.E.getString(R.string.zyv);
                    cVar.f422329d.setVisibility(4);
                    cVar.f422328c.setEnabled(false);
                    cVar.f422328c.setClickable(false);
                } else if (f.B(favFileInfo)) {
                    str = str + this.E.getString(R.string.b7r);
                    cVar.f422328c.setChecked(true);
                    view.setBackgroundColor(this.E.getResources().getColor(R.color.f158017al3));
                    view.setOnLongClickListener(null);
                } else {
                    str = str + HardCodeUtil.qqStr(R.string.zyw);
                    cVar.f422329d.setVisibility(4);
                    cVar.f422328c.setChecked(false);
                    view.setOnLongClickListener(this.I);
                }
            } else {
                cVar.f422328c.setVisibility(8);
                cVar.f422329d.setVisibility(8);
            }
            cVar.f422328c.setContentDescription(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("#######", 1, e16.toString());
        }
        return view;
    }

    private View p(int i3, int i16, View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null) {
            linearLayout = n();
        }
        linearLayout.removeAllViews();
        C7533b c7533b = (C7533b) linearLayout.getTag();
        int i17 = i16 * 4;
        for (int i18 = 0; i18 < 4; i18++) {
            View o16 = o(i3, i17 + i18, c7533b.f206566a[i18]);
            if (o16 == null) {
                return linearLayout;
            }
            c7533b.f206566a[i18] = o16;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o16.getLayoutParams();
            if (layoutParams == null) {
                int i19 = this.K;
                layoutParams = new LinearLayout.LayoutParams(i19, i19);
            }
            int i26 = this.K;
            layoutParams.width = i26;
            layoutParams.height = i26;
            if (i18 != 0) {
                layoutParams.leftMargin = this.L;
            }
            layoutParams.topMargin = this.L;
            o16.setLayoutParams(layoutParams);
            linearLayout.addView(o16);
        }
        return linearLayout;
    }

    private void r(FavFileInfo favFileInfo, AsyncImageView asyncImageView) {
        String str;
        if (!TextUtils.isEmpty(favFileInfo.D) && FileUtils.fileExistsAndNotEmpty(favFileInfo.D)) {
            asyncImageView.setAsyncImage(favFileInfo.D);
            return;
        }
        boolean z16 = false;
        if (!TextUtils.isEmpty(favFileInfo.J) && FileUtils.fileExistsAndNotEmpty(favFileInfo.J)) {
            str = favFileInfo.J;
        } else if (!TextUtils.isEmpty(favFileInfo.I) && FileUtils.fileExistsAndNotEmpty(favFileInfo.I)) {
            str = favFileInfo.I;
        } else if (!TextUtils.isEmpty(favFileInfo.H) && FileUtils.fileExistsAndNotEmpty(favFileInfo.H)) {
            str = favFileInfo.H;
        } else if (!TextUtils.isEmpty(favFileInfo.G) && FileUtils.fileExistsAndNotEmpty(favFileInfo.G)) {
            str = favFileInfo.G;
        } else {
            z16 = true;
            if (!TextUtils.isEmpty(favFileInfo.F) && FileUtils.fileExistsAndNotEmpty(favFileInfo.F)) {
                str = favFileInfo.F;
            } else if (!TextUtils.isEmpty(favFileInfo.E) && FileUtils.fileExistsAndNotEmpty(favFileInfo.E)) {
                str = favFileInfo.E;
            } else {
                str = "";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            asyncImageView.setAsyncImage(str);
            if (!z16) {
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - favFileInfo.a(2) > 30000) {
            ((IQQFileEngine) this.E.D0.getRuntimeService(IQQFileEngine.class)).favProxydownloadThumb(favFileInfo, 2);
            favFileInfo.c(2, currentTimeMillis);
        }
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        int i17 = 0;
        for (String str : this.D.keySet()) {
            if (i17 == i3) {
                List<FavFileInfo> list = this.D.get(str);
                if (list == null || i16 >= list.size()) {
                    return null;
                }
                return list.get(i16);
            }
            i17++;
        }
        return null;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        return p(i3, i16, view);
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        int i16 = 0;
        for (String str : this.D.keySet()) {
            if (i16 == i3) {
                int size = this.D.get(str).size();
                if (size < 4) {
                    return 1;
                }
                return (size / 4) + 1;
            }
            i16++;
        }
        if (this.J.d()) {
            return 0;
        }
        return 1;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        int i16 = 0;
        for (String str : this.D.keySet()) {
            if (i16 == i3) {
                return str;
            }
            i16++;
        }
        return null;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public int getGroupCount() {
        if (this.D.keySet().size() > 0) {
            return this.D.keySet().size();
        }
        return 0;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.K + this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.M;
    }

    public void q() {
        this.K = j();
        notifyDataSetChanged();
    }
}
