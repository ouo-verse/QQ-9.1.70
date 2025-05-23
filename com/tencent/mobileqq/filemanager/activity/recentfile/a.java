package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.TokenResUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import ob1.d;
import ob1.h;

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
    private Set<Integer> J;
    private HashMap<Integer, ArrayList<C7543a>> K;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.recentfile.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7543a {

        /* renamed from: a, reason: collision with root package name */
        int f206773a;

        /* renamed from: b, reason: collision with root package name */
        int f206774b;

        C7543a() {
        }
    }

    public a(Context context, LinkedHashMap<String, List<FileManagerEntity>> linkedHashMap, BaseFileAssistantActivity baseFileAssistantActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnLongClickListener onLongClickListener, View.OnClickListener onClickListener3) {
        super(context, linkedHashMap);
        this.J = new HashSet();
        this.K = new HashMap<>();
        this.F = onClickListener;
        this.G = onClickListener2;
        this.H = onLongClickListener;
        this.I = onClickListener3;
        this.C = context;
        this.D = baseFileAssistantActivity;
        this.E = LayoutInflater.from(context);
    }

    private void j(FileManagerEntity fileManagerEntity) {
        Object obj;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_my_file");
        hashMap.put("dt_eid", "em_bas_file_entry");
        hashMap.put("file_size", Long.valueOf(fileManagerEntity.fileSize));
        hashMap.put("filetype", q.j(fileManagerEntity.fileName));
        String str = "0";
        String str2 = "1";
        if (!m(fileManagerEntity)) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("is_downloaded", obj);
        if (this.C.getString(R.string.mip).equals(ah.j1(fileManagerEntity.srvTime, fileManagerEntity.peerType))) {
            str = "1";
        }
        hashMap.put("is_expired", str);
        if (ah.g1(fileManagerEntity)) {
            str2 = "2";
        }
        hashMap.put("source_appid", str2);
        VideoReport.reportEvent("imp", hashMap);
    }

    private void k(FileManagerEntity fileManagerEntity, h hVar, boolean z16) {
        if (fileManagerEntity.bSend && z16) {
            hVar.f422358f.setState(3);
        } else {
            hVar.f422358f.setState(2);
        }
        hVar.f422358f.setVisibility(0);
        hVar.f422359h = 3;
    }

    private void l(FileManagerEntity fileManagerEntity, h hVar, boolean z16) {
        if (fileManagerEntity.getCloudType() != 3 && fileManagerEntity.getCloudType() != 5 && !z16) {
            hVar.f422358f.setVisibility(0);
            hVar.f422358f.setState(2);
            hVar.f422359h = 1;
            return;
        }
        hVar.f422358f.setVisibility(4);
    }

    private boolean m(FileManagerEntity fileManagerEntity) {
        int i3 = fileManagerEntity.status;
        if (i3 == 1 || i3 == 0 || i3 == 2 || i3 == 3) {
            return true;
        }
        if (!TextUtils.isEmpty(fileManagerEntity.getFilePath()) && new File(fileManagerEntity.getFilePath()).exists()) {
            return true;
        }
        return false;
    }

    private void n(FileManagerEntity fileManagerEntity, h hVar) {
        switch (fileManagerEntity.status) {
            case -1:
                hVar.f422358f.setVisibility(0);
                hVar.f422359h = 1;
                hVar.f422358f.setState(2);
                if (!q.f(fileManagerEntity.strFilePath)) {
                    fileManagerEntity.fProgress = 0.0f;
                    hVar.f422358f.setProgress(0);
                    break;
                }
                break;
            case 0:
                hVar.f422358f.setVisibility(0);
                hVar.f422359h = 3;
                boolean isFileExists = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isFileExists(fileManagerEntity.getFilePath());
                if (fileManagerEntity.bSend && isFileExists) {
                    hVar.f422358f.setState(3);
                    break;
                } else {
                    hVar.f422358f.setState(2);
                    break;
                }
            case 1:
                l(fileManagerEntity, hVar, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isFileExists(fileManagerEntity.getFilePath()));
                break;
            case 2:
            case 18:
                hVar.f422358f.setVisibility(0);
                hVar.f422358f.setState(1);
                hVar.f422359h = 2;
                break;
            case 3:
                k(fileManagerEntity, hVar, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isFileExists(fileManagerEntity.getFilePath()));
                break;
            case 4:
                hVar.f422359h = 1;
                hVar.f422358f.setVisibility(0);
                hVar.f422358f.setState(2);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                hVar.f422358f.setVisibility(4);
                break;
            case 9:
            case 12:
                hVar.f422358f.setVisibility(4);
                break;
            case 10:
            case 11:
                hVar.f422358f.setVisibility(4);
                break;
            case 13:
                hVar.f422358f.setVisibility(0);
                hVar.f422358f.setState(2);
                hVar.f422359h = 1;
                break;
            case 14:
            case 15:
                hVar.f422358f.setVisibility(4);
                break;
            case 16:
                hVar.f422358f.setVisibility(4);
                break;
            case 17:
            default:
                hVar.f422358f.setVisibility(4);
                break;
        }
        o(hVar);
    }

    private void o(h hVar) {
        CircleFileStateView circleFileStateView;
        String qqStr;
        if (hVar != null && (circleFileStateView = hVar.f422358f) != null) {
            int c16 = circleFileStateView.c();
            int b16 = (int) hVar.f422358f.b();
            if (c16 != 1) {
                if (c16 != 2) {
                    if (c16 != 3) {
                        qqStr = "";
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.el5);
                    }
                } else if (b16 == 0.0d) {
                    qqStr = HardCodeUtil.qqStr(R.string.f171382el1);
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f171385el4) + "," + HardCodeUtil.qqStr(R.string.f16271216) + b16 + "%";
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.ba7);
            }
            AccessibilityUtil.s(hVar.f422358f, qqStr);
        }
    }

    @Override // ob1.d
    public void g(boolean z16) {
        super.g(z16);
        if (!z16) {
            this.J.clear();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        FileManagerEntity fileManagerEntity;
        h hVar;
        if (this.D.r3()) {
            ArrayList<C7543a> arrayList = this.K.get(Integer.valueOf(i3));
            if (arrayList != null) {
                Iterator<C7543a> it = arrayList.iterator();
                fileManagerEntity = null;
                while (it.hasNext()) {
                    C7543a next = it.next();
                    if (next.f206773a == i16) {
                        fileManagerEntity = (FileManagerEntity) getChild(i3, next.f206774b);
                    }
                }
            } else {
                fileManagerEntity = null;
            }
        } else {
            fileManagerEntity = (FileManagerEntity) getChild(i3, i16);
        }
        if (fileManagerEntity == null) {
            return view;
        }
        try {
            if (view == null) {
                hVar = new h();
                view = this.E.inflate(R.layout.alg, viewGroup, false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i0x);
                hVar.f422356d = relativeLayout;
                relativeLayout.setOnLongClickListener(this.H);
                hVar.f422356d.setTag(hVar);
                hVar.f422357e = view.findViewById(R.id.enf);
                CircleFileStateView circleFileStateView = (CircleFileStateView) view.findViewById(R.id.f163908c1);
                hVar.f422358f = circleFileStateView;
                AccessibilityUtil.d(circleFileStateView, Button.class.getName());
                hVar.f422360i = (CheckBox) view.findViewById(R.id.c_i);
                AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.c_5);
                hVar.f422361m = asyncImageView;
                asyncImageView.setTag(hVar);
                TextView textView = (TextView) view.findViewById(R.id.c_g);
                hVar.C = textView;
                textView.setGravity(48);
                hVar.C.setMaxLines(2);
                hVar.D = (TextView) view.findViewById(R.id.c_3);
                int dp2px = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.C.getResources());
                hVar.f422361m.setAsyncClipSize(dp2px, dp2px);
                view.setTag(hVar);
                if (TokenResUtils.useTokenRes4()) {
                    hVar.f422360i.setBackgroundResource(R.drawable.qui_common_check_box);
                }
            } else {
                hVar = (h) view.getTag();
            }
            ah.L1(hVar.f422361m, fileManagerEntity);
            hVar.F = i3;
            hVar.G = i16;
            hVar.f422356d.setVisibility(0);
            if (ah.R0(this.C, fileManagerEntity)) {
                hVar.f422357e.setVisibility(0);
                hVar.f422356d.setOnClickListener(null);
            } else {
                hVar.f422357e.setVisibility(8);
                hVar.f422356d.setOnClickListener(this.G);
                hVar.f422361m.setOnClickListener(this.G);
            }
            hVar.E = fileManagerEntity;
            hVar.f422358f.setOnClickListener(this.I);
            hVar.f422358f.setTag(hVar);
            hVar.f422358f.setProgressRingWidth(3.0f);
            hVar.C.setText(fileManagerEntity.fileName);
            hVar.f422358f.setProgress((int) (fileManagerEntity.fProgress * 100.0f));
            if (5 != fileManagerEntity.cloudType) {
                ah.e(fileManagerEntity);
            }
            hVar.f422358f.setEnabled(true);
            n(fileManagerEntity, hVar);
            if (this.D.r3()) {
                hVar.f422358f.setVisibility(8);
                hVar.f422360i.setVisibility(0);
                hVar.f422360i.setChecked(f.D(fileManagerEntity));
            } else {
                hVar.f422360i.setVisibility(8);
            }
            if (fileManagerEntity.nFileType == 13 || fileManagerEntity.nOpType == 58) {
                hVar.f422358f.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.D.getLayoutParams();
            layoutParams.topMargin = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.C.getResources());
            hVar.D.setLineSpacing(TypedValue.applyDimension(1, 0.8f, this.C.getResources().getDisplayMetrics()), 1.0f);
            hVar.D.setLayoutParams(layoutParams);
            hVar.C.setLineSpacing(TypedValue.applyDimension(1, 0.25f, this.C.getResources().getDisplayMetrics()), 1.0f);
            ah.j(hVar.D, fileManagerEntity);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f422341i && !this.J.contains(Integer.valueOf(fileManagerEntity.hashCode()))) {
            j(fileManagerEntity);
            this.J.add(Integer.valueOf(fileManagerEntity.hashCode()));
        }
        return view;
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        List<Object> c16 = c(i3);
        int i16 = 0;
        if (c16 == null) {
            return 0;
        }
        if (!this.K.containsKey(Integer.valueOf(i3))) {
            this.K.put(Integer.valueOf(i3), new ArrayList<>());
        }
        ArrayList arrayList = (ArrayList) c16;
        if (this.D.r3()) {
            ArrayList<C7543a> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                FileManagerEntity fileManagerEntity = (FileManagerEntity) it.next();
                if (fileManagerEntity.getCloudType() != 0 && ((fileManagerEntity.getCloudType() != 5 || fileManagerEntity.bSend || fileManagerEntity.status == 1) && !fileManagerEntity.sendCloudUnsuccessful())) {
                    C7543a c7543a = new C7543a();
                    c7543a.f206773a = i17;
                    c7543a.f206774b = i17 + i16;
                    arrayList2.add(c7543a);
                    i17++;
                } else {
                    i16++;
                }
            }
            this.K.put(Integer.valueOf(i3), arrayList2);
            return arrayList.size() - i16;
        }
        this.K.clear();
        return arrayList.size();
    }
}
