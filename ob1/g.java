package ob1;

import android.content.Context;
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
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends d {
    public final int C;
    public final int D;
    private Context E;
    private LinkedHashMap<String, List<WeiYunFileInfo>> F;
    private BaseFileAssistantActivity G;
    private LayoutInflater H;
    private View.OnClickListener I;
    private View.OnClickListener J;
    private View.OnClickListener K;
    private View.OnLongClickListener L;
    private View.OnClickListener M;
    private QfileCloudFileTabView.g N;
    private int P;
    private float Q;
    private int R;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        View[] f422355a;

        b() {
            this.f422355a = new View[12];
        }
    }

    public g(QfileCloudFileTabView.g gVar, BaseFileAssistantActivity baseFileAssistantActivity, Object obj, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener4) {
        super(baseFileAssistantActivity, obj);
        this.C = 1;
        this.D = 2;
        this.F = new LinkedHashMap<>();
        this.P = 50;
        this.Q = 0.0f;
        this.R = 0;
        this.E = baseFileAssistantActivity;
        this.G = baseFileAssistantActivity;
        this.H = LayoutInflater.from(baseFileAssistantActivity);
        this.F = (LinkedHashMap) obj;
        this.I = onClickListener;
        this.J = onClickListener2;
        this.K = onClickListener3;
        this.L = onLongClickListener;
        this.M = onClickListener4;
        this.N = gVar;
        float f16 = this.E.getResources().getDisplayMetrics().density;
        this.Q = f16;
        this.R = (int) (f16 * 2.0f);
        this.P = j();
    }

    private int j() {
        return ((int) (r0.widthPixels - (this.E.getResources().getDisplayMetrics().density * 6.0f))) / 4;
    }

    private LinearLayout m(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.E);
        linearLayout.setOrientation(0);
        linearLayout.setClickable(false);
        linearLayout.setLongClickable(false);
        linearLayout.setTag(new b());
        return linearLayout;
    }

    private View n(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        WeiYunFileInfo weiYunFileInfo;
        c cVar;
        Object child = getChild(i3, i16);
        if (child != null) {
            weiYunFileInfo = (WeiYunFileInfo) child;
        } else {
            weiYunFileInfo = null;
        }
        if (weiYunFileInfo == null) {
            if (k(i3, i16) == 1 || this.N.isEnd()) {
                return null;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("@#@#@#", 4, "groupPosition[" + i3 + "],position[" + i16 + "] add getMoreButton");
            }
            c cVar2 = new c();
            View inflate = this.H.inflate(R.layout.all, (ViewGroup) null);
            inflate.setClickable(true);
            cVar2.f422330e = (TextView) inflate.findViewById(R.id.kxk);
            cVar2.f422331f = (ProgressBar) inflate.findViewById(R.id.i5n);
            cVar2.f422332g = (ImageView) inflate.findViewById(R.id.eex);
            cVar2.f422336k = true;
            cVar2.f422334i = i3;
            cVar2.f422333h = i16;
            inflate.setOnClickListener(this.N.a(cVar2.f422330e));
            inflate.setTag(cVar2);
            if (this.F.size() == 0 && !this.N.c()) {
                inflate.setVisibility(8);
            } else {
                inflate.setVisibility(0);
            }
            if (this.N.b()) {
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
                view = this.H.inflate(R.layout.alu, (ViewGroup) null);
                cVar = new c();
                cVar.f422326a = (AsyncImageView) view.findViewById(R.id.image);
                cVar.f422328c = (QUICheckBox) view.findViewById(R.id.tuy);
                cVar.f422329d = (ImageView) view.findViewById(R.id.dc6);
                cVar.f422326a.setOnClickListener(this.K);
                cVar.f422328c.setOnClickListener(this.J);
                cVar.f422326a.setTag(cVar);
                cVar.f422328c.setTag(cVar);
                cVar.f422336k = false;
                view.setTag(cVar);
            } else {
                c cVar3 = (c) view.getTag();
                if (cVar3.f422336k) {
                    view = this.H.inflate(R.layout.alu, (ViewGroup) null);
                    cVar = new c();
                    cVar.f422326a = (AsyncImageView) view.findViewById(R.id.image);
                    cVar.f422328c = (QUICheckBox) view.findViewById(R.id.tuy);
                    cVar.f422329d = (ImageView) view.findViewById(R.id.dc6);
                    cVar.f422326a.setOnClickListener(this.K);
                    cVar.f422328c.setOnClickListener(this.J);
                    cVar.f422326a.setTag(cVar);
                    cVar.f422328c.setTag(cVar);
                    view.setTag(cVar);
                } else {
                    cVar = cVar3;
                }
            }
            cVar.f422335j = weiYunFileInfo;
            cVar.f422334i = i3;
            cVar.f422333h = i16;
            cVar.f422326a.setAdjustViewBounds(false);
            cVar.f422326a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            cVar.f422326a.setDefaultImage(R.drawable.asd);
            AsyncImageView asyncImageView = cVar.f422326a;
            int i17 = this.P;
            asyncImageView.setAsyncClipSize(i17, i17);
            cVar.f422336k = false;
            String str = weiYunFileInfo.H;
            if (str != null && str.length() > 0 && FileUtils.fileExistsAndNotEmpty(weiYunFileInfo.H)) {
                cVar.f422326a.setAsyncImage(weiYunFileInfo.H);
            }
            String str2 = this.G.getString(R.string.b7q) + weiYunFileInfo.f209605f;
            cVar.f422326a.setContentDescription(str2);
            if (this.G.r3()) {
                cVar.f422328c.setVisibility(0);
                if (com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo)) {
                    str2 = str2 + this.G.getString(R.string.b7r);
                    cVar.f422328c.setSelected(true);
                    view.setBackgroundColor(this.G.getResources().getColor(R.color.f158017al3));
                    view.setOnLongClickListener(null);
                } else {
                    str2 = str2 + HardCodeUtil.qqStr(R.string.zyw);
                    cVar.f422329d.setVisibility(4);
                    cVar.f422328c.setSelected(false);
                    view.setOnLongClickListener(this.L);
                }
            } else {
                cVar.f422328c.setVisibility(8);
                cVar.f422329d.setVisibility(8);
            }
            cVar.f422328c.setContentDescription(str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("#######", 1, e16.toString());
        }
        return view;
    }

    private View o(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout == null) {
            linearLayout = m(viewGroup);
        }
        linearLayout.removeAllViews();
        b bVar = (b) linearLayout.getTag();
        int i17 = i16 * 4;
        for (int i18 = 0; i18 < 4; i18++) {
            View n3 = n(i3, i17 + i18, z16, bVar.f422355a[i18], viewGroup);
            if (n3 == null) {
                return linearLayout;
            }
            bVar.f422355a[i18] = n3;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) n3.getLayoutParams();
            if (layoutParams == null) {
                int i19 = this.P;
                layoutParams = new LinearLayout.LayoutParams(i19, i19);
            }
            int i26 = this.P;
            layoutParams.width = i26;
            layoutParams.height = i26;
            if (i18 != 0) {
                layoutParams.leftMargin = this.R;
            }
            layoutParams.topMargin = this.R;
            n3.setLayoutParams(layoutParams);
            linearLayout.addView(n3);
        }
        return linearLayout;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        int i17 = 0;
        for (String str : this.F.keySet()) {
            if (i17 == i3) {
                List<WeiYunFileInfo> list = this.F.get(str);
                if (i16 >= list.size()) {
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
        return o(i3, i16, z16, view, viewGroup);
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        int i16 = 0;
        for (String str : this.F.keySet()) {
            if (i16 == i3) {
                int size = this.F.get(str).size();
                if (size < 4) {
                    return 1;
                }
                return (size / 4) + 1;
            }
            i16++;
        }
        if (this.N.isEnd()) {
            return 0;
        }
        return 1;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        int i16 = 0;
        for (String str : this.F.keySet()) {
            if (i16 == i3) {
                return str;
            }
            i16++;
        }
        return null;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public int getGroupCount() {
        if (this.F.keySet().size() > 0) {
            return this.F.keySet().size();
        }
        if (!this.N.isEnd()) {
            return 1;
        }
        return 0;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    public int k(int i3, int i16) {
        if (i3 + 1 < this.F.keySet().size()) {
            return 1;
        }
        List<WeiYunFileInfo> list = this.F.get(getGroup(i3));
        if (list != null || i16 != 0) {
            if (list == null || i16 != list.size()) {
                return 1;
            }
            return 2;
        }
        return 2;
    }

    public int l() {
        return this.P + this.R;
    }

    public void p() {
        this.P = j();
        notifyDataSetChanged();
    }
}
