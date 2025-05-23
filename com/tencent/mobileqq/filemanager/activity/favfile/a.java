package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
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
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends d {
    private Context C;
    protected BaseFileAssistantActivity D;
    private LayoutInflater E;
    private View.OnClickListener F;
    private View.OnLongClickListener G;
    private View.OnClickListener H;
    private b I;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.favfile.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7532a implements Cloneable {
        public AsyncImageView C;
        public TextView D;
        public TextView E;
        public TextView F;
        public Object G;

        /* renamed from: d, reason: collision with root package name */
        public int f206560d;

        /* renamed from: e, reason: collision with root package name */
        public int f206561e;

        /* renamed from: f, reason: collision with root package name */
        public RelativeLayout f206562f;

        /* renamed from: h, reason: collision with root package name */
        public CircleFileStateView f206563h;

        /* renamed from: i, reason: collision with root package name */
        public int f206564i;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox f206565m;

        public C7532a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
    }

    public a(Context context, LinkedHashMap<String, List<FavFileInfo>> linkedHashMap, BaseFileAssistantActivity baseFileAssistantActivity, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener2, b bVar) {
        super(context, linkedHashMap);
        this.C = context;
        this.D = baseFileAssistantActivity;
        this.E = LayoutInflater.from(context);
        this.F = onClickListener;
        this.G = onLongClickListener;
        this.H = onClickListener2;
        this.I = bVar;
    }

    private String j(String str, String str2) {
        if (str2 == null || str2.equalsIgnoreCase("")) {
            return "";
        }
        return str + str2;
    }

    private String k(FavFileInfo favFileInfo) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(favFileInfo.C) + " " + favFileInfo.P + " " + q.g(favFileInfo.f207677m);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        C7532a c7532a;
        FavFileInfo favFileInfo = (FavFileInfo) getChild(i3, i16);
        if (favFileInfo == null) {
            return view;
        }
        try {
            if (view == null) {
                c7532a = new C7532a();
                view = this.E.inflate(R.layout.alg, viewGroup, false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i0x);
                c7532a.f206562f = relativeLayout;
                relativeLayout.setOnClickListener(this.F);
                c7532a.f206562f.setOnLongClickListener(this.G);
                c7532a.f206562f.setTag(c7532a);
                c7532a.f206563h = (CircleFileStateView) view.findViewById(R.id.f163908c1);
                c7532a.f206565m = (CheckBox) view.findViewById(R.id.c_i);
                AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.c_5);
                c7532a.C = asyncImageView;
                asyncImageView.setOnClickListener(this.F);
                c7532a.C.setTag(c7532a);
                TextView textView = (TextView) view.findViewById(R.id.c_g);
                c7532a.D = textView;
                textView.setGravity(48);
                c7532a.D.setMaxLines(2);
                c7532a.E = (TextView) view.findViewById(R.id.c_3);
                c7532a.F = (TextView) view.findViewById(R.id.lastMsgTime);
                int dp2px = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.C.getResources());
                c7532a.C.setAsyncClipSize(dp2px, dp2px);
                view.setTag(c7532a);
            } else {
                c7532a = (C7532a) view.getTag();
            }
            l(favFileInfo, c7532a.C);
            c7532a.f206561e = i3;
            c7532a.f206560d = i16;
            c7532a.G = favFileInfo;
            c7532a.f206563h.setOnClickListener(this.H);
            c7532a.f206563h.setState(2);
            c7532a.f206563h.setTag(c7532a);
            c7532a.f206564i = 1;
            c7532a.f206563h.setVisibility(8);
            c7532a.D.setText(favFileInfo.f207675h);
            c7532a.E.setText(k(favFileInfo));
            String string = this.D.getString(R.string.b7s);
            c7532a.F.setText(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(favFileInfo.C) + j(this.D.getString(R.string.b78), string));
            if (this.D.r3()) {
                c7532a.f206563h.setVisibility(8);
                c7532a.f206565m.setVisibility(0);
                c7532a.f206565m.setChecked(f.B(favFileInfo));
            } else {
                c7532a.f206565m.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c7532a.E.getLayoutParams();
            layoutParams.topMargin = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.C.getResources());
            c7532a.E.setLineSpacing(TypedValue.applyDimension(1, 0.8f, this.C.getResources().getDisplayMetrics()), 1.0f);
            c7532a.E.setLayoutParams(layoutParams);
            c7532a.D.setLineSpacing(TypedValue.applyDimension(1, 0.25f, this.C.getResources().getDisplayMetrics()), 1.0f);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return view;
    }

    protected void l(FavFileInfo favFileInfo, AsyncImageView asyncImageView) {
        String str;
        int o06 = ah.o0(favFileInfo.f207675h);
        if (o06 == 0 || o06 == 2) {
            if (FileUtils.fileExistsAndNotEmpty(favFileInfo.J)) {
                str = favFileInfo.J;
            } else if (FileUtils.fileExistsAndNotEmpty(favFileInfo.I)) {
                str = favFileInfo.I;
            } else if (FileUtils.fileExistsAndNotEmpty(favFileInfo.H)) {
                str = favFileInfo.H;
            } else if (FileUtils.fileExistsAndNotEmpty(favFileInfo.G)) {
                str = favFileInfo.G;
            } else if (FileUtils.fileExistsAndNotEmpty(favFileInfo.F)) {
                str = favFileInfo.F;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                asyncImageView.setAsyncImage(str);
                return;
            }
        }
        ah.M1(asyncImageView, favFileInfo.D, o06);
    }
}
