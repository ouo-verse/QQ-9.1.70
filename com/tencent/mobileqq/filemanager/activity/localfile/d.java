package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends ob1.d {
    private Context C;
    private BaseFileAssistantActivity D;
    private LayoutInflater E;
    private View.OnClickListener F;
    private View.OnClickListener G;
    private View.OnLongClickListener H;
    private View.OnClickListener I;
    private HashMap<Integer, Bitmap> J;
    private boolean K;
    private View.OnClickListener L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = (b) view.getTag();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(d.this.D, null, (FileInfo) bVar.F, view, ah.k1((FileInfo) bVar.F));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Cloneable {
        public AsyncImageView C;
        public TextView D;
        public TextView E;
        public Object F;

        /* renamed from: d, reason: collision with root package name */
        public int f206693d;

        /* renamed from: e, reason: collision with root package name */
        public int f206694e;

        /* renamed from: f, reason: collision with root package name */
        public RelativeLayout f206695f;

        /* renamed from: h, reason: collision with root package name */
        public CircleFileStateView f206696h;

        /* renamed from: i, reason: collision with root package name */
        public int f206697i;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox f206698m;

        public b() {
        }
    }

    public d(Context context, LinkedHashMap<String, List<FileInfo>> linkedHashMap, BaseFileAssistantActivity baseFileAssistantActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener3) {
        super(context, linkedHashMap);
        this.K = false;
        this.L = null;
        if (baseFileAssistantActivity.Y2() != -1) {
            this.K = true;
            m();
        }
        this.J = new HashMap<>();
        this.F = onClickListener;
        this.G = onClickListener2;
        this.H = onLongClickListener;
        this.I = onClickListener3;
        this.C = context;
        this.D = baseFileAssistantActivity;
        this.E = LayoutInflater.from(context);
    }

    private String k(FileInfo fileInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(fileInfo.e()));
        sb5.append("  ");
        if (this.D.v3()) {
            sb5.append("\u6765\u81ea\u5fae\u4fe1");
            sb5.append("  ");
        }
        sb5.append(q.g(fileInfo.l()));
        return sb5.toString();
    }

    private void l(String str, int i3, int i16, int i17, b bVar) {
        int hashCode = str.hashCode();
        if (this.J.containsKey(Integer.valueOf(hashCode))) {
            bVar.C.setAsyncClipSize(i16, i17);
            bVar.C.setImageBitmap(this.J.get(Integer.valueOf(hashCode)));
            return;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 5) {
                    bVar.C.setAsyncClipSize(i16, i17);
                    bVar.C.setImageResource(ah.d0(i3));
                    return;
                }
                bVar.C.setAsyncClipSize(i16, i17);
                bVar.C.setDefaultImage(R.drawable.filelook_apk);
                if (FileUtils.fileExistsAndNotEmpty(str)) {
                    bVar.C.setApkIconAsyncImage(str);
                    return;
                }
                return;
            }
            bVar.C.setAsyncClipSize(i16, i17);
            bVar.C.setDefaultImage(R.drawable.filelook_video);
            bVar.C.setAsyncImage(str);
            return;
        }
        bVar.C.setAsyncClipSize(i16, i17);
        bVar.C.setDefaultImage(R.drawable.filelook_image);
        bVar.C.setAsyncImage(str);
    }

    private void m() {
        if (this.L == null) {
            this.L = new a();
        }
    }

    @Override // ob1.d, com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        super.configHeaderView(view, i3);
        d.e eVar = (d.e) view.getTag();
        if (eVar != null) {
            if (this.D.Y2() == 1) {
                view.setEnabled(false);
                i(eVar, false);
            } else {
                view.setEnabled(true);
                i(eVar, true);
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        if (QLog.isDevelopLevel()) {
            QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + i3 + "],childPosition[" + i16 + "]");
        }
        if (i3 == 5 && i16 == 0 && QLog.isDevelopLevel()) {
            QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
        }
        FileInfo fileInfo = (FileInfo) getChild(i3, i16);
        try {
            if (view == null) {
                bVar = new b();
                view = this.E.inflate(R.layout.alg, viewGroup, false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i0x);
                bVar.f206695f = relativeLayout;
                relativeLayout.setOnClickListener(this.G);
                bVar.f206695f.setOnLongClickListener(this.H);
                bVar.f206695f.setTag(bVar);
                bVar.f206696h = (CircleFileStateView) view.findViewById(R.id.f163908c1);
                bVar.f206698m = (CheckBox) view.findViewById(R.id.c_i);
                AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.c_5);
                bVar.C = asyncImageView;
                asyncImageView.setOnClickListener(this.G);
                bVar.C.setTag(bVar);
                TextView textView = (TextView) view.findViewById(R.id.c_g);
                bVar.D = textView;
                textView.setGravity(48);
                bVar.D.setMaxLines(2);
                bVar.E = (TextView) view.findViewById(R.id.c_3);
                int dp2px = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.C.getResources());
                bVar.C.setAsyncClipSize(dp2px, dp2px);
                view.setTag(bVar);
                if (TokenResUtils.useTokenRes4()) {
                    bVar.f206698m.setBackgroundResource(R.drawable.qui_common_check_box);
                }
            } else {
                bVar = (b) view.getTag();
            }
            bVar2 = bVar;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (fileInfo == null) {
            return view;
        }
        bVar2.f206694e = i3;
        bVar2.f206693d = i16;
        fileInfo.u((String) getGroup(i3));
        bVar2.F = fileInfo;
        bVar2.f206696h.setOnClickListener(this.I);
        bVar2.f206696h.setTag(bVar2);
        if (this.K) {
            bVar2.C.setTag(bVar2);
            bVar2.C.setOnClickListener(this.L);
        }
        int height = bVar2.C.getHeight();
        int width = bVar2.C.getWidth();
        String k3 = fileInfo.k();
        d.InterfaceC10897d interfaceC10897d = this.f422339f;
        if (interfaceC10897d != null) {
            k3 = interfaceC10897d.g(fileInfo);
        }
        String str = k3;
        l(str, ah.o0(str), width, height, bVar2);
        bVar2.D.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        bVar2.D.setText(fileInfo.j());
        bVar2.D.setVisibility(0);
        bVar2.E.setText(k(fileInfo));
        bVar2.f206696h.setVisibility(4);
        bVar2.f206697i = 0;
        if (this.D.r3()) {
            bVar2.f206696h.setVisibility(8);
            bVar2.f206698m.setVisibility(8);
            bVar2.f206698m.setVisibility(0);
            bVar2.f206698m.setChecked(f.C(fileInfo));
        } else {
            bVar2.f206698m.setVisibility(8);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar2.E.getLayoutParams();
        layoutParams.topMargin = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.C.getResources());
        bVar2.E.setLineSpacing(TypedValue.applyDimension(1, 0.8f, this.C.getResources().getDisplayMetrics()), 1.0f);
        bVar2.E.setLayoutParams(layoutParams);
        bVar2.D.setLineSpacing(TypedValue.applyDimension(1, 0.25f, this.C.getResources().getDisplayMetrics()), 1.0f);
        return view;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        d.e eVar;
        View groupView = super.getGroupView(i3, z16, view, viewGroup);
        if (groupView != null) {
            eVar = (d.e) groupView.getTag();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            if (this.D.Y2() == 1) {
                groupView.setEnabled(false);
                onGroupExpanded(0);
                i(eVar, false);
            } else {
                groupView.setEnabled(true);
                i(eVar, true);
            }
        }
        return groupView;
    }
}
