package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
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
    private BaseFileAssistantActivity D;
    private LayoutInflater E;
    private View.OnClickListener F;
    private View.OnClickListener G;
    private View.OnLongClickListener H;
    private View.OnClickListener I;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.cloudfile.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7528a implements Cloneable {
        public AsyncImageView C;
        public TextView D;
        public TextView E;
        public TextView F;
        public Object G;

        /* renamed from: d, reason: collision with root package name */
        public int f206467d;

        /* renamed from: e, reason: collision with root package name */
        public int f206468e;

        /* renamed from: f, reason: collision with root package name */
        public RelativeLayout f206469f;

        /* renamed from: h, reason: collision with root package name */
        public CircleFileStateView f206470h;

        /* renamed from: i, reason: collision with root package name */
        public int f206471i;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox f206472m;

        public C7528a() {
        }
    }

    public a(Context context, LinkedHashMap<String, List<WeiYunFileInfo>> linkedHashMap, BaseFileAssistantActivity baseFileAssistantActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener3) {
        super(context, linkedHashMap);
        this.F = onClickListener;
        this.G = onClickListener2;
        this.H = onLongClickListener;
        this.I = onClickListener3;
        this.C = context;
        this.D = baseFileAssistantActivity;
        this.E = LayoutInflater.from(context);
    }

    private String j(String str, String str2) {
        if (str2 == null || str2.equalsIgnoreCase("")) {
            return "";
        }
        return str + str2;
    }

    private String k(WeiYunFileInfo weiYunFileInfo) {
        return q.g(weiYunFileInfo.f209606h);
    }

    private void l(AsyncImageView asyncImageView, String str) {
        asyncImageView.setDefaultImage(R.drawable.e9y);
        asyncImageView.setAsyncImage(str);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        C7528a c7528a;
        WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) getChild(i3, i16);
        if (weiYunFileInfo == null) {
            return view;
        }
        try {
            if (view == null) {
                c7528a = new C7528a();
                view = this.E.inflate(R.layout.alg, viewGroup, false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i0x);
                c7528a.f206469f = relativeLayout;
                relativeLayout.setOnClickListener(this.G);
                c7528a.f206469f.setOnLongClickListener(this.H);
                c7528a.f206469f.setTag(c7528a);
                c7528a.f206470h = (CircleFileStateView) view.findViewById(R.id.f163908c1);
                c7528a.f206472m = (CheckBox) view.findViewById(R.id.c_i);
                AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.c_5);
                c7528a.C = asyncImageView;
                asyncImageView.setOnClickListener(this.G);
                c7528a.C.setTag(c7528a);
                TextView textView = (TextView) view.findViewById(R.id.c_g);
                c7528a.D = textView;
                textView.setGravity(48);
                c7528a.D.setMaxLines(2);
                c7528a.E = (TextView) view.findViewById(R.id.c_3);
                c7528a.F = (TextView) view.findViewById(R.id.lastMsgTime);
                int dp2px = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.C.getResources());
                c7528a.C.setAsyncClipSize(dp2px, dp2px);
                view.setTag(c7528a);
            } else {
                c7528a = (C7528a) view.getTag();
            }
            ah.M1(c7528a.C, weiYunFileInfo.H, ah.o0(weiYunFileInfo.f209605f));
            c7528a.f206468e = i3;
            c7528a.f206467d = i16;
            c7528a.G = weiYunFileInfo;
            c7528a.f206470h.setOnClickListener(this.I);
            c7528a.f206470h.setState(2);
            c7528a.f206470h.setTag(c7528a);
            c7528a.f206471i = 1;
            if ((ah.o0(weiYunFileInfo.f209605f) == 0 || ah.o0(weiYunFileInfo.f209605f) == 2) && FileUtils.fileExistsAndNotEmpty(weiYunFileInfo.H)) {
                l(c7528a.C, weiYunFileInfo.H);
            }
            c7528a.D.setText(weiYunFileInfo.f209605f);
            c7528a.E.setText(k(weiYunFileInfo));
            String string = this.D.getString(R.string.b7s);
            c7528a.F.setText(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(weiYunFileInfo.f209607i) + j(this.D.getString(R.string.b78), string));
            BaseQQAppInterface app = this.D.getApp();
            FileManagerEntity queryFileEntityByFileId = ((IQQFileEngine) app.getRuntimeService(IQQFileEngine.class)).queryFileEntityByFileId(weiYunFileInfo.f209603d);
            if (queryFileEntityByFileId != null) {
                c7528a.f206470h.setVisibility(0);
                c7528a.f206470h.setState(1);
                c7528a.f206470h.setProgress((int) (queryFileEntityByFileId.fProgress * 100.0f));
                c7528a.f206471i = 2;
                c7528a.f206470h.d(true);
            } else {
                c7528a.f206470h.setVisibility(0);
                c7528a.f206470h.d(false);
            }
            if (queryFileEntityByFileId == null && (queryFileEntityByFileId = ((IQQFileDataCenter) app.getRuntimeService(IQQFileDataCenter.class)).queryByFileIdForMemory(weiYunFileInfo.f209603d)) != null && !FileUtils.fileExistsAndNotEmpty(queryFileEntityByFileId.getFilePath())) {
                queryFileEntityByFileId.setCloudType(2);
                if (queryFileEntityByFileId.getId() > 0) {
                    queryFileEntityByFileId.nOpType = 5;
                }
                if (queryFileEntityByFileId.status != 1) {
                    c7528a.f206470h.setProgress((int) (queryFileEntityByFileId.fProgress * 100.0f));
                    c7528a.f206470h.d(true);
                }
            }
            if (queryFileEntityByFileId != null) {
                int i17 = queryFileEntityByFileId.status;
                if (i17 != -1) {
                    if (i17 != 0) {
                        if (i17 != 1) {
                            if (i17 != 3) {
                            }
                        } else {
                            c7528a.f206470h.setVisibility(4);
                            c7528a.f206471i = 0;
                        }
                    }
                    c7528a.f206470h.setVisibility(0);
                    c7528a.f206470h.setState(2);
                    c7528a.f206471i = 3;
                } else {
                    c7528a.f206470h.setState(2);
                    c7528a.f206470h.setVisibility(0);
                    c7528a.f206471i = 1;
                }
            }
            if (this.D.r3()) {
                c7528a.f206470h.setVisibility(8);
                c7528a.f206472m.setVisibility(0);
                c7528a.f206472m.setChecked(f.E(weiYunFileInfo));
            } else {
                c7528a.f206472m.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c7528a.E.getLayoutParams();
            layoutParams.topMargin = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.C.getResources());
            c7528a.E.setLineSpacing(TypedValue.applyDimension(1, 0.8f, this.C.getResources().getDisplayMetrics()), 1.0f);
            c7528a.E.setLayoutParams(layoutParams);
            c7528a.D.setLineSpacing(TypedValue.applyDimension(1, 0.25f, this.C.getResources().getDisplayMetrics()), 1.0f);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return view;
    }
}
