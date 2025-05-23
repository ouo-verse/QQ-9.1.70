package ob1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TokenResUtils;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends d {
    protected Context C;
    private LinkedHashMap<String, List<FileInfo>> D;
    protected BaseFileAssistantActivity E;
    protected LayoutInflater F;
    private View.OnClickListener G;
    private View.OnClickListener H;
    private View.OnClickListener I;
    private View.OnLongClickListener J;
    private View.OnClickListener K;
    protected int L;
    private float M;
    private int N;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        View[] f422353a;

        b() {
            this.f422353a = new View[12];
        }
    }

    public e(BaseFileAssistantActivity baseFileAssistantActivity, Object obj, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener4) {
        super(baseFileAssistantActivity, obj);
        this.D = new LinkedHashMap<>();
        this.L = 50;
        this.M = 0.0f;
        this.N = 0;
        this.C = baseFileAssistantActivity;
        this.E = baseFileAssistantActivity;
        this.F = LayoutInflater.from(baseFileAssistantActivity);
        this.D = (LinkedHashMap) obj;
        this.G = onClickListener;
        this.I = onClickListener3;
        this.H = onClickListener2;
        this.J = onLongClickListener;
        this.K = onClickListener4;
        float f16 = this.C.getResources().getDisplayMetrics().density;
        this.M = f16;
        this.N = (int) (f16 * 2.0f);
        this.L = j(k());
    }

    private int j(int i3) {
        return ((int) (r0.widthPixels - (this.C.getResources().getDisplayMetrics().density * ((i3 - 1) * 2)))) / i3;
    }

    private LinearLayout m(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.C);
        linearLayout.setOrientation(0);
        linearLayout.setClickable(false);
        linearLayout.setLongClickable(false);
        linearLayout.setTag(new b());
        return linearLayout;
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
            View n3 = n(i3, i17 + i18, z16, bVar.f422353a[i18], viewGroup);
            if (n3 == null) {
                return linearLayout;
            }
            bVar.f422353a[i18] = n3;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) n3.getLayoutParams();
            if (layoutParams == null) {
                int i19 = this.L;
                layoutParams = new LinearLayout.LayoutParams(i19, i19);
            }
            int i26 = this.L;
            layoutParams.width = i26;
            layoutParams.height = i26;
            if (i18 != 0) {
                layoutParams.leftMargin = this.N;
            }
            layoutParams.topMargin = this.N;
            n3.setLayoutParams(layoutParams);
            linearLayout.addView(n3);
        }
        return linearLayout;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        int i17 = 0;
        for (String str : this.D.keySet()) {
            if (i17 == i3) {
                List<FileInfo> list = this.D.get(str);
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
        for (String str : this.D.keySet()) {
            if (i16 == i3) {
                return (this.D.get(str).size() / 4) + 1;
            }
            i16++;
        }
        return 0;
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
        return this.D.keySet().size();
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    protected int k() {
        return 4;
    }

    public int l() {
        return this.L + this.N;
    }

    protected View n(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        FileInfo fileInfo;
        c cVar;
        int i17;
        int i18;
        Object child = getChild(i3, i16);
        if (child != null) {
            fileInfo = (FileInfo) child;
        } else {
            fileInfo = null;
        }
        if (fileInfo == null) {
            return null;
        }
        try {
            if (view == null) {
                view = this.F.inflate(R.layout.alu, (ViewGroup) null);
                cVar = new c();
                cVar.f422326a = (AsyncImageView) view.findViewById(R.id.image);
                cVar.f422327b = (ImageView) view.findViewById(R.id.dc9);
                cVar.f422329d = (ImageView) view.findViewById(R.id.dc6);
                cVar.f422327b.setOnClickListener(this.H);
                cVar.f422326a.setTag(cVar);
                cVar.f422327b.setTag(cVar);
                cVar.f422326a.setOnClickListener(this.I);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            fileInfo.u((String) getGroup(i3));
            cVar.f422335j = fileInfo;
            cVar.f422333h = i16;
            cVar.f422334i = i3;
            cVar.f422326a.setAdjustViewBounds(false);
            cVar.f422326a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            cVar.f422326a.setDefaultImage(R.drawable.asd);
            AsyncImageView asyncImageView = cVar.f422326a;
            int i19 = this.L;
            asyncImageView.setAsyncClipSize(i19, i19);
            if (fileInfo.k() != null && fileInfo.k().length() > 0 && FileUtils.fileExistsAndNotEmpty(fileInfo.k())) {
                cVar.f422326a.setAsyncImage(fileInfo.k());
            }
            String str = this.E.getString(R.string.b7q) + fileInfo.j();
            cVar.f422326a.setContentDescription(str);
            if (this.E.r3()) {
                cVar.f422327b.setVisibility(0);
                if (com.tencent.mobileqq.filemanager.data.f.C(fileInfo)) {
                    str = str + this.E.getString(R.string.b7r);
                    if (TokenResUtils.useTokenRes4()) {
                        i18 = R.drawable.qui_common_check_box_checked_white_border;
                    } else {
                        i18 = R.drawable.list_checkbox_selected;
                    }
                    cVar.f422327b.setImageResource(i18);
                    view.setBackgroundColor(this.E.getResources().getColor(R.color.f158017al3));
                    view.setOnLongClickListener(null);
                } else {
                    str = str + HardCodeUtil.qqStr(R.string.zyw);
                    cVar.f422329d.setVisibility(4);
                    if (TokenResUtils.useTokenRes4()) {
                        i17 = R.drawable.qui_common_check_box_unchecked_white_border;
                    } else {
                        i17 = R.drawable.qq_pic_img_checkbox_deselect;
                    }
                    cVar.f422327b.setImageResource(i17);
                }
            } else {
                cVar.f422327b.setVisibility(8);
                cVar.f422329d.setVisibility(8);
            }
            cVar.f422327b.setContentDescription(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("#######", 1, e16.toString());
        }
        return view;
    }

    public void p() {
        this.L = j(k());
        notifyDataSetChanged();
    }
}
