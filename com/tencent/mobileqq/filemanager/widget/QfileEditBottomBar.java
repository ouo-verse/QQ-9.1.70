package com.tencent.mobileqq.filemanager.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.av;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileEditBottomBar extends RelativeLayout implements View.OnClickListener {
    ImageView C;
    ImageView D;
    ImageView E;
    private QQBlurView F;
    SparseArray<Integer> G;
    int H;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f209445d;

    /* renamed from: e, reason: collision with root package name */
    private Context f209446e;

    /* renamed from: f, reason: collision with root package name */
    private BaseFileAssistantActivity f209447f;

    /* renamed from: h, reason: collision with root package name */
    t f209448h;

    /* renamed from: i, reason: collision with root package name */
    ImageView f209449i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f209450m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f209451d;

        AnonymousClass1(ActionSheet actionSheet) {
            this.f209451d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IQQFileEngine) ((BaseQQAppInterface) QfileEditBottomBar.this.f209445d).getRuntimeService(IQQFileEngine.class)).delAllSelectedFiles(false);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QfileEditBottomBar.this.f209447f.A3();
                            QfileEditBottomBar.this.f209447f.J2(com.tencent.mobileqq.filemanager.data.f.q());
                            QfileEditBottomBar.this.f209447f.L2(com.tencent.mobileqq.filemanager.data.f.n());
                            QfileEditBottomBar.this.f209447f.K2(com.tencent.mobileqq.filemanager.data.f.v());
                            com.tencent.mobileqq.filemanager.data.f.k();
                            QfileEditBottomBar.this.f209447f.J3(false);
                            QfileEditBottomBar.this.f209447f.refreshUI();
                        }
                    });
                }
            });
            if (this.f209451d.isShowing()) {
                this.f209451d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileEditBottomBar.this.n();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileEditBottomBar.this.n();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements IGetExternalInterface.a {
        g() {
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.a
        public void a(List list) {
            QfileEditBottomBar.this.f209447f.R2().forward(list);
        }
    }

    public QfileEditBottomBar(Context context) {
        this(context, null);
    }

    private long f(ArrayList<ForwardFileInfo> arrayList, ArrayList<Uri> arrayList2) {
        ArrayList<WeiYunFileInfo> v3 = com.tencent.mobileqq.filemanager.data.f.v();
        IQQFileEngine iQQFileEngine = (IQQFileEngine) ((BaseQQAppInterface) this.f209445d).getRuntimeService(IQQFileEngine.class);
        IQQFileDataCenter iQQFileDataCenter = (IQQFileDataCenter) ((BaseQQAppInterface) this.f209445d).getRuntimeService(IQQFileDataCenter.class);
        long j3 = 0;
        for (WeiYunFileInfo weiYunFileInfo : v3) {
            FileManagerEntity queryFileEntityByFileId = iQQFileEngine.queryFileEntityByFileId(weiYunFileInfo.f209603d);
            if (queryFileEntityByFileId == null && (queryFileEntityByFileId = iQQFileDataCenter.queryByFileIdForMemory(weiYunFileInfo.f209603d)) == null) {
                queryFileEntityByFileId = ah.m1(weiYunFileInfo);
            }
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.N(10003);
            forwardFileInfo.w(queryFileEntityByFileId.getCloudType());
            forwardFileInfo.E(queryFileEntityByFileId.nSessionId);
            forwardFileInfo.y(queryFileEntityByFileId.fileName);
            forwardFileInfo.V(queryFileEntityByFileId.uniseq);
            forwardFileInfo.x(queryFileEntityByFileId.WeiYunFileId);
            forwardFileInfo.z(queryFileEntityByFileId.fileSize);
            forwardFileInfo.C(queryFileEntityByFileId.getFilePath());
            forwardFileInfo.Z(queryFileEntityByFileId.Uuid);
            j3 += forwardFileInfo.g();
            arrayList.add(forwardFileInfo);
            if (!TextUtils.isEmpty(queryFileEntityByFileId.strLargeThumPath)) {
                forwardFileInfo.G(queryFileEntityByFileId.strLargeThumPath);
            } else if (!TextUtils.isEmpty(queryFileEntityByFileId.strMiddleThumPath)) {
                forwardFileInfo.G(queryFileEntityByFileId.strMiddleThumPath);
            } else {
                forwardFileInfo.G(queryFileEntityByFileId.strThumbPath);
            }
            FileManagerEntity queryFileEntityByFileId2 = iQQFileEngine.queryFileEntityByFileId(weiYunFileInfo.f209603d);
            if (queryFileEntityByFileId2 == null) {
                queryFileEntityByFileId2 = iQQFileDataCenter.queryByFileIdForMemory(weiYunFileInfo.f209603d);
            }
            if (queryFileEntityByFileId2 != null && queryFileEntityByFileId2.getFilePath() != null && queryFileEntityByFileId2.getFilePath().length() > 0) {
                arrayList2.add(Uri.parse(queryFileEntityByFileId2.getFilePath()));
            } else {
                arrayList2.add(Uri.parse(""));
            }
        }
        return j3;
    }

    private void g() {
        boolean z16;
        ArrayList<ForwardFileInfo> arrayList = new ArrayList<>();
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        ArrayList<WeiYunFileInfo> v3 = com.tencent.mobileqq.filemanager.data.f.v();
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        boolean z17 = true;
        boolean z18 = false;
        if (com.tencent.mobileqq.teamwork.b.e(q16)) {
            for (FileManagerEntity fileManagerEntity : q16) {
                if (fileManagerEntity.nFileType == 13) {
                    arrayList3.add(fileManagerEntity);
                }
            }
            if (arrayList3.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!com.tencent.mobileqq.teamwork.b.e(n3) && !com.tencent.mobileqq.teamwork.b.e(v3) && q16.size() - arrayList3.size() <= 0) {
                z17 = false;
            }
            z18 = z16;
        } else if (!com.tencent.mobileqq.teamwork.b.e(n3) && !com.tencent.mobileqq.teamwork.b.e(v3)) {
            z17 = false;
        }
        if (z17 && z18) {
            DialogUtil.createCustomDialog(this.f209446e, 230).setMessage(this.f209446e.getString(R.string.b8d)).setNegativeButton(R.string.i5e, new f()).show();
        } else if (z17) {
            i(arrayList, n3, q16, v3, arrayList2);
        } else if (z18) {
            k(arrayList3);
        }
    }

    private long h(ArrayList<ForwardFileInfo> arrayList, ArrayList<Uri> arrayList2) {
        long j3 = 0;
        for (FileInfo fileInfo : com.tencent.mobileqq.filemanager.data.f.n()) {
            FileManagerEntity k16 = ah.k1(fileInfo);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.N(10000);
            forwardFileInfo.w(k16.getCloudType());
            forwardFileInfo.E(k16.nSessionId);
            forwardFileInfo.y(k16.fileName);
            forwardFileInfo.V(k16.uniseq);
            forwardFileInfo.x(k16.WeiYunFileId);
            forwardFileInfo.z(k16.fileSize);
            forwardFileInfo.C(k16.getFilePath());
            forwardFileInfo.Z(k16.Uuid);
            if (!TextUtils.isEmpty(k16.strLargeThumPath)) {
                forwardFileInfo.G(k16.strLargeThumPath);
            } else if (!TextUtils.isEmpty(k16.strMiddleThumPath)) {
                forwardFileInfo.G(k16.strMiddleThumPath);
            } else {
                forwardFileInfo.G(k16.strThumbPath);
            }
            arrayList2.add(Uri.parse(fileInfo.k()));
            j3 += forwardFileInfo.g();
            arrayList.add(forwardFileInfo);
        }
        return j3;
    }

    private void i(ArrayList<ForwardFileInfo> arrayList, Set<FileInfo> set, List<FileManagerEntity> list, List<WeiYunFileInfo> list2, ArrayList<Uri> arrayList2) {
        boolean z16;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        long j3 = 0;
        if (set != null && set.size() > 0) {
            j3 = 0 + h(arrayList, arrayList2);
        }
        if (list != null && list.size() > 0) {
            j3 += j(arrayList, arrayList2);
        }
        if (list2 != null && list2.size() > 0) {
            j3 += f(arrayList, arrayList2);
            z16 = false;
        } else {
            z16 = true;
        }
        bundle.putParcelableArrayList("fileinfo_array", arrayList);
        bundle.putBoolean("not_forward", true);
        intent.putExtra("sendMultiple", true);
        bundle.putParcelableArrayList("android.intent.extra.STREAM", arrayList2);
        intent.putExtras(bundle);
        intent.putExtra("foward_editbar", true);
        String qqStr = HardCodeUtil.qqStr(R.string.f187043sx);
        if (arrayList.size() == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.f186803s_) + ah.y(arrayList.get(0).f()) + HardCodeUtil.qqStr(R.string.f186833sc) + q.g(arrayList.get(0).g()) + "\u3002";
        } else if (arrayList.size() > 1) {
            qqStr = HardCodeUtil.qqStr(R.string.f186803s_) + ah.y(arrayList.get(0).f()) + HardCodeUtil.qqStr(R.string.f186823sb) + arrayList.size() + HardCodeUtil.qqStr(R.string.f186813sa) + q.g(j3) + "\u3002";
        }
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, qqStr);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startForwardByOriginFile(this.f209447f, intent, z16);
    }

    private long j(ArrayList<ForwardFileInfo> arrayList, ArrayList<Uri> arrayList2) {
        long j3 = 0;
        for (FileManagerEntity fileManagerEntity : com.tencent.mobileqq.filemanager.data.f.q()) {
            if (!fileManagerEntity.sendCloudUnsuccessful() && fileManagerEntity.nFileType != 13) {
                ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                forwardFileInfo.N(10001);
                forwardFileInfo.w(fileManagerEntity.getCloudType());
                forwardFileInfo.E(fileManagerEntity.nSessionId);
                forwardFileInfo.y(fileManagerEntity.fileName);
                forwardFileInfo.V(fileManagerEntity.uniseq);
                forwardFileInfo.x(fileManagerEntity.WeiYunFileId);
                forwardFileInfo.z(fileManagerEntity.fileSize);
                forwardFileInfo.C(fileManagerEntity.getFilePath());
                forwardFileInfo.Z(fileManagerEntity.Uuid);
                if (!TextUtils.isEmpty(fileManagerEntity.strLargeThumPath)) {
                    forwardFileInfo.G(fileManagerEntity.strLargeThumPath);
                } else if (!TextUtils.isEmpty(fileManagerEntity.strMiddleThumPath)) {
                    forwardFileInfo.G(fileManagerEntity.strMiddleThumPath);
                } else {
                    forwardFileInfo.G(fileManagerEntity.strThumbPath);
                }
                if (fileManagerEntity.getCloudType() == 3 && fileManagerEntity.getFilePath() != null && fileManagerEntity.getFilePath().length() > 0) {
                    arrayList2.add(Uri.parse(fileManagerEntity.getFilePath()));
                } else {
                    arrayList2.add(Uri.parse(""));
                }
                j3 += forwardFileInfo.g();
                arrayList.add(forwardFileInfo);
            }
        }
        return j3;
    }

    private void k(List<FileManagerEntity> list) {
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).forwardTencentDocs(this.f209445d, this.f209447f, list, new g());
    }

    private void m() {
        BaseFileAssistantActivity baseFileAssistantActivity = (BaseFileAssistantActivity) this.f209446e;
        this.f209447f = baseFileAssistantActivity;
        this.f209445d = baseFileAssistantActivity.getAppRuntime();
        this.f209449i = (ImageView) findViewById(R.id.upm);
        this.f209450m = (ImageView) findViewById(R.id.brq);
        this.C = (ImageView) findViewById(R.id.brw);
        this.D = (ImageView) findViewById(R.id.brr);
        this.E = (ImageView) findViewById(R.id.brp);
        this.f209449i.setImageResource(R.drawable.qui_collection_light_selector);
        this.f209450m.setImageResource(R.drawable.qui_download_light_selector);
        this.D.setImageResource(R.drawable.qui_share_light_selector);
        this.E.setImageResource(R.drawable.qui_delete_light_selector);
        this.C.setImageResource(R.drawable.qui_weiyun_light_selector);
        this.f209449i.setOnClickListener(this);
        this.f209450m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList<FileManagerEntity> saveAllSelectFileToWeiYun = ((IQQFileEngine) ((BaseQQAppInterface) this.f209445d).getRuntimeService(IQQFileEngine.class)).saveAllSelectFileToWeiYun();
        t tVar = this.f209448h;
        if (tVar != null) {
            tVar.d();
        }
        com.tencent.mobileqq.filemanager.data.f.k();
        this.f209447f.J3(false);
        this.f209447f.G2(saveAllSelectFileToWeiYun);
        this.f209447f.A3();
        this.f209447f.refreshUI();
        if (saveAllSelectFileToWeiYun.size() > 0) {
            com.tencent.mobileqq.filemanager.util.d.d(this.f209447f.getString(R.string.f170978be3));
        }
    }

    private void o(View view) {
        t(view);
        t tVar = this.f209448h;
        if (tVar != null) {
            tVar.a();
        }
    }

    private void p() {
        if (QLog.isColorLevel()) {
            QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + com.tencent.mobileqq.filemanager.data.f.v().size() + "], offline[" + com.tencent.mobileqq.filemanager.data.f.p().size() + "], recent[" + com.tencent.mobileqq.filemanager.data.f.q().size() + "], localfile[" + com.tencent.mobileqq.filemanager.data.f.n().size() + "]");
        }
        if (!NetworkUtil.isNetSupport(this.f209446e)) {
            com.tencent.mobileqq.filemanager.util.d.f(this.f209446e.getString(R.string.f187123t5));
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.f.r() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            ah.Q1(false, this.f209447f, new e());
            return;
        }
        ((IQQFileEngine) ((BaseQQAppInterface) this.f209445d).getRuntimeService(IQQFileEngine.class)).downLoadAllSelectFiles(this.f209446e);
        t tVar = this.f209448h;
        if (tVar != null) {
            tVar.b();
        }
        com.tencent.mobileqq.filemanager.data.f.k();
        this.f209447f.A3();
        this.f209447f.J3(false);
        this.f209447f.refreshUI();
    }

    private void q() {
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        Iterator<FileManagerEntity> it = q16.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            FileManagerEntity next = it.next();
            if (next.nFileType == 13) {
                this.f209445d.getCurrentUin();
                if (!((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favBuilderNewLink(this.f209447f, next.Uuid)) {
                    z16 = true;
                }
            } else if (!((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.f209447f, next)) {
                z16 = true;
            }
        }
        Iterator<FileInfo> it5 = n3.iterator();
        while (it5.hasNext()) {
            String k3 = it5.next().k();
            if (FileUtils.fileExistsAndNotEmpty(k3) && !((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favBuilderNewFile(this.f209447f, k3)) {
                z16 = true;
            }
        }
        if (z16) {
            com.tencent.mobileqq.filemanager.util.d.f(this.f209447f.getString(R.string.f187023sv));
        } else {
            com.tencent.mobileqq.filemanager.util.d.h(this.f209447f.getString(R.string.w8c));
        }
        com.tencent.mobileqq.filemanager.data.f.k();
        this.f209447f.J3(false);
        this.f209447f.refreshUI();
    }

    private void r() {
        if (!NetworkUtil.isNetSupport(this.f209446e)) {
            com.tencent.mobileqq.filemanager.util.d.f(this.f209446e.getString(R.string.f187123t5));
            return;
        }
        g();
        t tVar = this.f209448h;
        if (tVar != null) {
            tVar.c();
        }
        com.tencent.mobileqq.filemanager.data.f.k();
        this.f209447f.A3();
        this.f209447f.J3(false);
        this.f209447f.refreshUI();
    }

    private void s() {
        if (!NetworkUtil.isNetSupport(this.f209446e)) {
            com.tencent.mobileqq.filemanager.util.d.f(this.f209446e.getString(R.string.f187123t5));
            return;
        }
        if (ah.f(false, com.tencent.mobileqq.filemanager.data.f.q())) {
            if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.f209447f, new a())) {
                FMDialogUtil.a(this.f209447f, R.string.f187033sw, R.string.b_y, new b());
            }
        } else {
            if (com.tencent.mobileqq.filemanager.data.f.u() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize() && ah.X0()) {
                if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi(this.f209447f, new c())) {
                    FMDialogUtil.a(this.f209447f, R.string.f187033sw, R.string.b_y, new d());
                    return;
                }
                return;
            }
            n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ce, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00d0, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + r7 + "], Local[" + com.tencent.mobileqq.filemanager.util.ah.t1(r9) + "]");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        Iterator<FileManagerEntity> it = com.tencent.mobileqq.filemanager.data.f.q().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().fileSize > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        Iterator<FileInfo> it5 = com.tencent.mobileqq.filemanager.data.f.n().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            } else if (it5.next().l() > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                z16 = true;
                break;
            }
        }
        Iterator<FileManagerEntity> it6 = com.tencent.mobileqq.filemanager.data.f.q().iterator();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            FileManagerEntity next = it6.next();
            if (next.sendCloudUnsuccessful()) {
                i3++;
            } else if (next.getCloudType() != 3 && next.getCloudType() != 5) {
                if (next.getCloudType() == 2) {
                    if (i16 != 0) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + i17 + "], Local[" + ah.t1(next) + "]");
                        }
                    } else {
                        i17++;
                    }
                } else if (next.getCloudType() == 6 && !FileUtils.fileExistsAndNotEmpty(next.getFilePath())) {
                    if (i16 != 0 || i17 != 0) {
                        break;
                    } else {
                        i18++;
                    }
                }
            } else if (i17 != 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i16 + "] WeiYun [" + ah.t1(next) + "]");
                }
            } else {
                i16++;
            }
        }
        Iterator<FileManagerEntity> it7 = com.tencent.mobileqq.filemanager.data.f.q().iterator();
        while (true) {
            if (it7.hasNext()) {
                if (it7.next().nOpType == 58) {
                    z17 = true;
                    break;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() == i16) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() == i17) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() == i18) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() == i3) {
            z27 = true;
        } else {
            z27 = false;
        }
        this.f209450m.setEnabled(!z18);
        this.C.setEnabled(!z19);
        this.D.setEnabled(!z26);
        if (!z19 && !z16 && !z17) {
            z28 = true;
        } else {
            z28 = false;
        }
        this.f209449i.setEnabled(z28);
        if (z27) {
            z29 = false;
            this.f209450m.setEnabled(false);
            this.C.setEnabled(false);
            this.D.setEnabled(false);
            this.f209449i.setEnabled(false);
        } else {
            z29 = false;
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() > 0) {
            this.E.setEnabled(true);
        } else {
            this.E.setEnabled(z29);
        }
        if (com.tencent.mobileqq.filemanager.data.f.y()) {
            this.f209450m.setEnabled(z29);
            this.C.setEnabled(z29);
        }
    }

    @TargetApi(19)
    protected void l() {
        QQBlurView qQBlurView = this.F;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
            this.F = null;
        }
        QQBlurView qQBlurView2 = (QQBlurView) findViewById(R.id.kmg);
        this.F = qQBlurView2;
        qQBlurView2.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.upm) {
            q();
        } else if (id5 == R.id.brq) {
            p();
        } else if (id5 == R.id.brw) {
            s();
        } else if (id5 == R.id.brr) {
            r();
        } else if (id5 == R.id.brp) {
            o(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setClickListener(t tVar) {
        this.f209448h = tVar;
    }

    public void setEditBtnVisible(boolean z16, boolean z17, boolean z18, boolean z19) {
        int i3;
        int i16;
        int i17;
        int i18;
        ImageView imageView = this.f209449i;
        int i19 = 8;
        if (z18) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        ImageView imageView2 = this.f209450m;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView2.setVisibility(i16);
        ImageView imageView3 = this.C;
        if (z17) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        imageView3.setVisibility(i17);
        ImageView imageView4 = this.D;
        if (z18) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        imageView4.setVisibility(i18);
        ImageView imageView5 = this.E;
        if (z19) {
            i19 = 0;
        }
        imageView5.setVisibility(i19);
        ArrayList arrayList = new ArrayList();
        if (z16) {
            arrayList.add(this.f209450m);
        }
        if (z18) {
            arrayList.add(this.D);
        }
        arrayList.add(this.f209449i);
        if (z17) {
            arrayList.add(this.C);
        }
        if (z19) {
            arrayList.add(this.E);
        }
        av.a((ViewGroup) this.f209450m.getParent(), (View[]) arrayList.toArray(new View[0]));
        l();
    }

    public void setTabType(int i3) {
        this.H = i3;
    }

    void t(View view) {
        new ArrayList();
        boolean z16 = true;
        if (this.H != 1) {
            z16 = false;
        }
        ActionSheet create = ActionSheet.create(this.f209447f);
        create.addButton(R.string.b_d, 3);
        if (this.H != 3) {
            if (z16) {
                create.setMainTitle(HardCodeUtil.qqStr(R.string.f186943sn));
            } else {
                create.setMainTitle(HardCodeUtil.qqStr(R.string.f186913sk));
            }
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new AnonymousClass1(create));
        create.show();
    }

    public void u() {
        QQBlurView qQBlurView = this.F;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    public QfileEditBottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QfileEditBottomBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209445d = null;
        this.G = new SparseArray<>();
        this.H = -1;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ald, (ViewGroup) this, true);
        this.f209446e = context;
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QfileEditBottomBar.this.n();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements FMDialogUtil.c {
        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QfileEditBottomBar.this.n();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements FMDialogUtil.c {
        e() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ((IQQFileEngine) ((BaseQQAppInterface) QfileEditBottomBar.this.f209445d).getRuntimeService(IQQFileEngine.class)).downLoadAllSelectFiles(QfileEditBottomBar.this.f209446e);
            t tVar = QfileEditBottomBar.this.f209448h;
            if (tVar != null) {
                tVar.b();
            }
            com.tencent.mobileqq.filemanager.data.f.k();
            QfileEditBottomBar.this.f209447f.A3();
            QfileEditBottomBar.this.f209447f.J3(false);
            QfileEditBottomBar.this.f209447f.refreshUI();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
