package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l extends com.tencent.mobileqq.filemanager.data.a {
    private LocalFileBrowserActivity C;
    private final int D;
    private final int E;

    /* renamed from: h, reason: collision with root package name */
    private List<FileInfo> f207815h;

    /* renamed from: i, reason: collision with root package name */
    private Context f207816i;

    /* renamed from: m, reason: collision with root package name */
    private LayoutInflater f207817m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Cloneable {
        public TextView C;
        public TextView D;
        public CircleFileStateView E;
        public FileInfo F;
        public int G;

        /* renamed from: d, reason: collision with root package name */
        public RelativeLayout f207818d;

        /* renamed from: e, reason: collision with root package name */
        public CheckBox f207819e;

        /* renamed from: f, reason: collision with root package name */
        public AsyncImageView f207820f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f207821h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f207822i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f207823m;

        public a() {
        }
    }

    public l(Context context, List<FileInfo> list, LocalFileBrowserActivity localFileBrowserActivity) {
        super(context);
        this.C = null;
        this.D = -1;
        this.E = 1;
        this.f207816i = context;
        this.f207815h = list;
        this.f207817m = LayoutInflater.from(context);
        this.C = localFileBrowserActivity;
    }

    private View c(FileInfo fileInfo, ViewGroup viewGroup) {
        View inflate;
        a aVar = new a();
        if (!fileInfo.m()) {
            inflate = this.f207817m.inflate(R.layout.alg, viewGroup, false);
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            aVar.f207818d = relativeLayout;
            relativeLayout.setOnClickListener(this.C.f206313r1);
            aVar.f207818d.setOnLongClickListener(this.C.f206312q1);
            aVar.f207818d.setTag(aVar);
            aVar.f207819e = (CheckBox) inflate.findViewById(R.id.c_i);
            AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.c_5);
            aVar.f207820f = asyncImageView;
            asyncImageView.setOnClickListener(this.C.f206313r1);
            aVar.f207820f.setTag(aVar);
            aVar.f207821h = (ImageView) inflate.findViewById(R.id.i_c);
            TextView textView = (TextView) inflate.findViewById(R.id.c_g);
            aVar.f207822i = textView;
            textView.setMaxLines(2);
            aVar.f207823m = (TextView) inflate.findViewById(R.id.c_j);
            aVar.C = (TextView) inflate.findViewById(R.id.c_3);
            aVar.D = (TextView) inflate.findViewById(R.id.lastMsgTime);
            CircleFileStateView circleFileStateView = (CircleFileStateView) inflate.findViewById(R.id.f163908c1);
            aVar.E = circleFileStateView;
            circleFileStateView.setOnClickListener(this.C.f206313r1);
        } else {
            inflate = this.f207817m.inflate(R.layout.aln, viewGroup, false);
            inflate.setOnClickListener(this.C.f206313r1);
            aVar.f207820f = (AsyncImageView) inflate.findViewById(R.id.c_u);
            aVar.f207821h = (ImageView) inflate.findViewById(R.id.i_m);
            aVar.f207822i = (EllipsizingTextView) inflate.findViewById(R.id.c_x);
        }
        inflate.setTag(aVar);
        return inflate;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f207815h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f207815h.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (this.f207815h.get(i3).m()) {
            return -1;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        int i16;
        FileInfo fileInfo = this.f207815h.get(i3);
        if (fileInfo == null) {
            view2 = view;
            view = null;
        } else {
            if (view == null) {
                try {
                    view = c(fileInfo, viewGroup);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            a aVar = (a) view.getTag();
            aVar.F = fileInfo;
            if (fileInfo.m()) {
                aVar.f207820f.setDefaultImage(R.drawable.e9e);
                aVar.f207821h.setVisibility(0);
                aVar.f207822i.setText(fileInfo.j());
                aVar.G = i3;
                aVar.f207820f.setContentDescription(HardCodeUtil.qqStr(R.string.f1354001c));
            } else {
                aVar.f207821h.setVisibility(8);
                ah.M1(aVar.f207820f, fileInfo.k(), ah.o0(fileInfo.k()));
                aVar.f207822i.setText(fileInfo.j());
                String str = HardCodeUtil.qqStr(R.string.b7q) + fileInfo.j();
                aVar.f207820f.setContentDescription(str);
                if (this.C.r3()) {
                    aVar.f207819e.setVisibility(0);
                    aVar.f207819e.setChecked(f.C(fileInfo));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    if (aVar.f207819e.isChecked()) {
                        i16 = R.string.b7r;
                    } else {
                        i16 = R.string.zyw;
                    }
                    sb5.append(HardCodeUtil.qqStr(i16));
                    aVar.f207819e.setContentDescription(sb5.toString());
                } else {
                    aVar.f207819e.setVisibility(8);
                }
                String formatNewRefreshTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(fileInfo.e());
                String string = this.C.getString(R.string.b78);
                aVar.C.setText(formatNewRefreshTime + string + q.g(fileInfo.l()));
                aVar.G = i3;
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
