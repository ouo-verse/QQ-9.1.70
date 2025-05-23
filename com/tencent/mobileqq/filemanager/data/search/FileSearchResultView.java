package com.tencent.mobileqq.filemanager.data.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntitySearchPCPart;
import com.tencent.mobileqq.richmedialist.widget.ProgressIcon;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeAuthenticationType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import com.tencent.qqnt.kernel.nativeinterface.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSearchResultView implements sn2.c {
    private static int F = -1;
    protected static Bundle G;
    private static HashMap<String, FileSearchResultView> H = new HashMap<>();
    private static FileSearchFragment I = null;
    private static IKernelFileBridgeClientListener J = new IKernelFileBridgeClientListener() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.1
        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onAuthenticationSuccess(FileBridgeAuthenticationType fileBridgeAuthenticationType) {
            ah.a(this, fileBridgeAuthenticationType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType) {
            ah.b(this, wiFiPhotoConnectionType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onDisconnected(int i3) {
            ah.c(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public void onFileDownloadComplete(final String str, final int i3, final String str2) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.1.3
                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    List<FileManagerEntity> list;
                    if (FileSearchResultView.H.containsKey(str)) {
                        c q16 = FileSearchResultView.q(str);
                        if (q16 != null && (list = q16.G) != null && list.get(0) != null) {
                            FileManagerEntity fileManagerEntity = q16.G.get(0);
                            if (i3 == 0) {
                                fileManagerEntity.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KCOMPLETE;
                            } else {
                                fileManagerEntity.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KFAILED;
                            }
                            fileManagerEntity.strFilePath = str2;
                        }
                        FileSearchResultView r16 = FileSearchResultView.r(str);
                        if (r16 != null && r16.D != null && r16.D.G != null && r16.D.G.size() > 0) {
                            FileManagerEntity fileManagerEntity2 = r16.D.G.get(0);
                            if (fileManagerEntity2.searchPCPart.f207685a.equalsIgnoreCase(str)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("onFileDownloadComplete. , filename: ");
                                if (q16 != null) {
                                    str3 = q16.G.get(0).fileName;
                                } else {
                                    str3 = "null";
                                }
                                sb5.append(str3);
                                sb5.append(", fileId: ");
                                sb5.append(str);
                                sb5.append(", error: ");
                                sb5.append(i3);
                                sb5.append(", localFilePath: ");
                                sb5.append(str2);
                                sb5.append(", fileSearchResultView: ");
                                sb5.append(r16);
                                QLog.d("FileSearchResultView", 1, sb5.toString());
                                if (i3 == 0) {
                                    fileManagerEntity2.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KCOMPLETE;
                                } else {
                                    fileManagerEntity2.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KFAILED;
                                }
                                fileManagerEntity2.strFilePath = str2;
                                if (fileManagerEntity2.searchPCPart.f()) {
                                    FileSearchResultView.H.remove(fileManagerEntity2.searchPCPart.f207685a);
                                }
                                TextView textView = r16.f207895i;
                                textView.setText(fileManagerEntity2.searchPCPart.a(textView.getContext(), fileManagerEntity2.fileSize));
                                int c16 = fileManagerEntity2.searchPCPart.c();
                                if (c16 != 0) {
                                    r16.C.setImageResource(c16);
                                    r16.f207896m.setVisibility(0);
                                } else {
                                    r16.C.setImageDrawable(null);
                                    r16.f207896m.setVisibility(4);
                                }
                            }
                        }
                    }
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public void onFileDownloadProgress(final String str, final long j3, final long j16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.1.2
                @Override // java.lang.Runnable
                public void run() {
                    List<FileManagerEntity> list;
                    if (FileSearchResultView.H.containsKey(str)) {
                        c q16 = FileSearchResultView.q(str);
                        if (q16 != null && (list = q16.G) != null && list.get(0) != null) {
                            FileManagerEntity fileManagerEntity = q16.G.get(0);
                            fileManagerEntity.searchPCPart.f207690f = j3;
                            fileManagerEntity.fileSize = j16;
                        }
                        FileSearchResultView r16 = FileSearchResultView.r(str);
                        String str2 = "null";
                        if (r16 == null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onFileDownloadProgress failed2. , filename: ");
                            if (q16 != null) {
                                str2 = q16.G.get(0).fileName;
                            }
                            sb5.append(str2);
                            sb5.append(", fileId: ");
                            sb5.append(str);
                            sb5.append(", fileSearchResultView: ");
                            sb5.append(r16);
                            QLog.e("FileSearchResultView", 1, sb5.toString());
                            return;
                        }
                        if (r16.D != null && r16.D.G != null && r16.D.G.size() > 0) {
                            FileManagerEntity fileManagerEntity2 = r16.D.G.get(0);
                            if (fileManagerEntity2.searchPCPart.f207685a.equalsIgnoreCase(str)) {
                                fileManagerEntity2.searchPCPart.f207690f = j3;
                                fileManagerEntity2.fileSize = j16;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("onFileDownloadProgress. , filename: ");
                                if (q16 != null) {
                                    str2 = q16.G.get(0).fileName;
                                }
                                sb6.append(str2);
                                sb6.append(", fileId: ");
                                sb6.append(str);
                                sb6.append(", current: ");
                                sb6.append(j3);
                                sb6.append(", total: ");
                                sb6.append(j16);
                                sb6.append(", progress: ");
                                sb6.append(fileManagerEntity2.searchPCPart.j(fileManagerEntity2.fileSize));
                                sb6.append(", fileSearchResultView: ");
                                sb6.append(r16);
                                QLog.d("FileSearchResultView", 1, sb6.toString());
                                r16.f207896m.c(fileManagerEntity2.searchPCPart.j(fileManagerEntity2.fileSize));
                                if (fileManagerEntity2.searchPCPart.j(fileManagerEntity2.fileSize) == 100) {
                                    if (fileManagerEntity2.searchPCPart.f()) {
                                        FileSearchResultView.H.remove(fileManagerEntity2.searchPCPart.f207685a);
                                    }
                                    TextView textView = r16.f207895i;
                                    textView.setText(fileManagerEntity2.searchPCPart.a(textView.getContext(), fileManagerEntity2.fileSize));
                                    int c16 = fileManagerEntity2.searchPCPart.c();
                                    if (c16 != 0) {
                                        r16.C.setImageResource(c16);
                                        r16.f207896m.setVisibility(0);
                                        return;
                                    } else {
                                        r16.C.setImageDrawable(null);
                                        r16.f207896m.setVisibility(4);
                                        return;
                                    }
                                }
                                return;
                            }
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("onFileDownloadProgress failed4. , filename: ");
                            if (q16 != null) {
                                str2 = q16.G.get(0).fileName;
                            }
                            sb7.append(str2);
                            sb7.append(", fileId: ");
                            sb7.append(str);
                            sb7.append(", fileId2: ");
                            sb7.append(fileManagerEntity2.searchPCPart.f207685a);
                            sb7.append(", fileSearchResultView: ");
                            sb7.append(r16);
                            QLog.e("FileSearchResultView", 1, sb7.toString());
                            return;
                        }
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("onFileDownloadProgress failed3. , filename: ");
                        if (q16 != null) {
                            str2 = q16.G.get(0).fileName;
                        }
                        sb8.append(str2);
                        sb8.append(", fileId: ");
                        sb8.append(str);
                        sb8.append(", fileSearchResultView: ");
                        sb8.append(r16);
                        QLog.e("FileSearchResultView", 1, sb8.toString());
                    }
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public void onFileDownloadSpeed(final String str, final long j3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    List<FileManagerEntity> list;
                    if (FileSearchResultView.H.containsKey(str)) {
                        c q16 = FileSearchResultView.q(str);
                        if (q16 != null && (list = q16.G) != null && list.get(0) != null) {
                            q16.G.get(0).searchPCPart.f207691g = j3;
                        }
                        FileSearchResultView r16 = FileSearchResultView.r(str);
                        if (r16 != null && r16.D != null && r16.D.G != null && r16.D.G.size() > 0) {
                            FileManagerEntity fileManagerEntity = r16.D.G.get(0);
                            if (fileManagerEntity.searchPCPart.f207685a.equalsIgnoreCase(str)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("onFileDownloadSpeed. , filename: ");
                                if (q16 != null) {
                                    str2 = q16.G.get(0).fileName;
                                } else {
                                    str2 = "null";
                                }
                                sb5.append(str2);
                                sb5.append(", fileId: ");
                                sb5.append(str);
                                sb5.append(", speed: ");
                                sb5.append(j3);
                                sb5.append(", fileSearchResultView: ");
                                sb5.append(r16);
                                QLog.d("FileSearchResultView", 1, sb5.toString());
                                FileManagerEntitySearchPCPart fileManagerEntitySearchPCPart = fileManagerEntity.searchPCPart;
                                fileManagerEntitySearchPCPart.f207691g = j3;
                                TextView textView = r16.f207895i;
                                textView.setText(fileManagerEntitySearchPCPart.a(textView.getContext(), fileManagerEntity.fileSize));
                            }
                        }
                    }
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onFileDownloadStateChange(String str, FileBridgeDownloadState fileBridgeDownloadState) {
            ah.g(this, str, fileBridgeDownloadState);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedHostSetPassword() {
            ah.h(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedShowDownloadCompleteToast() {
            ah.i(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onNeedUserInputPassword() {
            ah.j(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onReconnecting() {
            ah.k(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onSearchFolderForFiles(long j3, int i3, ArrayList arrayList) {
            ah.l(this, j3, i3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onStateChange(FileBridgeClientState fileBridgeClientState) {
            ah.m(this, fileBridgeClientState);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
        public /* synthetic */ void onThumbDownloadComplete(String str, int i3, String str2) {
            ah.n(this, str, i3, str2);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    protected int f207891d;

    /* renamed from: e, reason: collision with root package name */
    protected View f207892e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f207893f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f207894h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f207895i;

    /* renamed from: m, reason: collision with root package name */
    private ProgressIcon f207896m = null;
    private ImageView C = null;
    private c D = null;
    private View.OnClickListener E = new AnonymousClass2();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FileSearchResultView.this.D != null && FileSearchResultView.this.D.G != null && FileSearchResultView.this.D.G.size() > 0) {
                final FileManagerEntity fileManagerEntity = FileSearchResultView.this.D.G.get(0);
                QLog.d("FileSearchResultView", 1, "ProgressIcon onClick. fileName: " + fileManagerEntity.fileName + ", fileId: " + fileManagerEntity.searchPCPart.f207685a + ", downloadState: " + fileManagerEntity.searchPCPart.f207689e + ", isDirectory: " + fileManagerEntity.searchPCPart.e());
                if (fileManagerEntity.searchPCPart.e()) {
                    Intent intent = new Intent();
                    intent.putExtra("key_export_file_list_file_id", fileManagerEntity.searchPCPart.f207685a);
                    intent.putExtra("key_export_file_list_dir_name", fileManagerEntity.fileName);
                    QPublicFragmentActivity.start(view.getContext(), intent, (Class) FileSearchResultView.G.getSerializable("search_pc_file_list_fragment_cls"));
                } else if (fileManagerEntity.searchPCPart.g()) {
                    QLog.d("FileSearchResultView", 1, "ProgressIcon onClick. cancelGet.");
                    ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().cancelGet(fileManagerEntity.searchPCPart.f207685a);
                    fileManagerEntity.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.PAUSE;
                    FileSearchResultView.H.remove(fileManagerEntity.searchPCPart.f207685a);
                    fileManagerEntity.searchPCPart.f207690f = 0L;
                    FileSearchResultView.this.f207896m.c(fileManagerEntity.searchPCPart.j(fileManagerEntity.fileSize));
                    FileSearchResultView.this.C.setImageResource(fileManagerEntity.searchPCPart.c());
                } else {
                    QLog.d("FileSearchResultView", 1, "ProgressIcon onClick. getFile. fileId: " + fileManagerEntity.searchPCPart.f207685a + ", this: " + FileSearchResultView.this + ", filename: " + ((Object) FileSearchResultView.this.f207894h.getText()));
                    FileSearchResultView.this.v(true, 2, fileManagerEntity.fileSize, fileManagerEntity.nFileType);
                    FileSearchResultView.H.put(fileManagerEntity.searchPCPart.f207685a, FileSearchResultView.this);
                    ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().getFile(fileManagerEntity.searchPCPart.f207685a, new IOperateCallback() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.2.1
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public void onResult(final int i3, final String str) {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultView.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    FileBridgeDownloadState fileBridgeDownloadState;
                                    QLog.d("FileSearchResultView", 2, "mBtnDownload.onClick. getFile.onResult. , fileName: " + fileManagerEntity.fileName + ", fileid: " + fileManagerEntity.searchPCPart.f207685a + ", result: " + i3 + ", errMsg: " + str);
                                    if (i3 == 0) {
                                        fileBridgeDownloadState = FileBridgeDownloadState.KWAITING;
                                    } else {
                                        fileBridgeDownloadState = FileBridgeDownloadState.KFAILED;
                                    }
                                    if (fileBridgeDownloadState == FileBridgeDownloadState.KWAITING) {
                                        fileManagerEntity.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KDOWNLOADING;
                                    } else if (fileBridgeDownloadState == FileBridgeDownloadState.KFAILED) {
                                        fileManagerEntity.searchPCPart.f207689e = FileManagerEntitySearchPCPart.FileDownloadState.KFAILED;
                                        FileSearchResultView.H.remove(fileManagerEntity.searchPCPart.f207685a);
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    TextView textView = FileSearchResultView.this.f207895i;
                                    textView.setText(fileManagerEntity.searchPCPart.a(textView.getContext(), fileManagerEntity.fileSize));
                                    FileSearchResultView.this.C.setImageResource(fileManagerEntity.searchPCPart.c());
                                }
                            });
                        }
                    });
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FileSearchResultView(ViewGroup viewGroup) {
        this.f207891d = R.layout.hpp;
        int i3 = F;
        if (i3 == 22 || i3 == 23) {
            this.f207891d = R.layout.hpu;
        }
        this.f207892e = LayoutInflater.from(viewGroup.getContext()).inflate(this.f207891d, viewGroup, false);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c q(String str) {
        List<M> list;
        c cVar;
        List<FileManagerEntity> list2;
        FileSearchFragment fileSearchFragment = I;
        if (fileSearchFragment != null && (list = fileSearchFragment.mResultList) != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if ((list.get(i3) instanceof c) && (cVar = (c) list.get(i3)) != null && (list2 = cVar.G) != null && list2.size() > 0 && cVar.G.get(0).searchPCPart.f207685a.equalsIgnoreCase(str)) {
                    return cVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileSearchResultView r(String str) {
        c cVar;
        List<FileManagerEntity> list;
        FileSearchFragment fileSearchFragment = I;
        if (fileSearchFragment != null && fileSearchFragment.U != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= I.U.size()) {
                    break;
                }
                View view = I.U.get(i3);
                if (view.getTag(R.id.kxb) != null && (view.getTag(R.id.kxb) instanceof c) && (cVar = (c) view.getTag(R.id.kxb)) != null && (list = cVar.G) != null && list.size() > 0 && cVar.G.get(0).searchPCPart.f207685a.equalsIgnoreCase(str)) {
                    if (view.getTag(R.id.kxg) != null && (view.getTag(R.id.kxg) instanceof FileSearchResultView)) {
                        return (FileSearchResultView) view.getTag(R.id.kxg);
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    public static void s(int i3, Bundle bundle) {
        F = i3;
        G = bundle;
        ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().addKernelFileBridgeClientListener(J);
    }

    private void t(View view) {
        ProgressIcon progressIcon = (ProgressIcon) view.findViewById(R.id.f247209w);
        this.f207896m = progressIcon;
        progressIcon.setOnClickListener(this.E);
        this.C = (ImageView) view.findViewById(R.id.v5e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16, int i3, long j3, int i16) {
        String str;
        QLog.d("FileSearchResultView", 2, "reportResultListViewItem. isClick: " + z16 + ", clickEffect: " + i3 + ", fileSize: " + j3 + ", fileType: " + i16);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_search_result_entry");
        hashMap.put("click_effect", Integer.valueOf(i3));
        hashMap.put("file_size", Long.valueOf(j3));
        hashMap.put("filetype", Integer.valueOf(i16));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("have_result", 1);
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    public static void w(FileSearchFragment fileSearchFragment) {
        I = fileSearchFragment;
    }

    public static void x() {
        F = 0;
        G = null;
        I = null;
        ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().I0(J);
    }

    @Override // sn2.c
    public TextView b() {
        return this.f207894h;
    }

    @Override // sn2.c
    public TextView c() {
        return null;
    }

    @Override // sn2.c
    public TextView d() {
        return null;
    }

    @Override // sn2.a
    public ImageView f() {
        return this.f207893f;
    }

    @Override // sn2.c
    public ImageView g() {
        return null;
    }

    @Override // sn2.d
    public View getView() {
        return this.f207892e;
    }

    @Override // sn2.c
    public View h(String str) {
        return null;
    }

    @Override // sn2.c
    public TextView k() {
        return this.f207895i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.f207893f = (ImageView) this.f207892e.findViewById(R.id.image);
        TextView textView = (TextView) this.f207892e.findViewById(R.id.title);
        this.f207894h = textView;
        textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        this.f207895i = (TextView) this.f207892e.findViewById(R.id.bgt);
        this.f207892e.findViewById(R.id.jpr).setVisibility(8);
        int i3 = F;
        if (i3 == 22 || i3 == 23) {
            t(this.f207892e);
        }
    }

    public void y(y yVar) {
        List<FileManagerEntity> list;
        int i3 = F;
        if ((i3 == 22 || i3 == 23) && (yVar instanceof c)) {
            c cVar = (c) yVar;
            this.D = cVar;
            if (cVar != null && (list = cVar.G) != null && list.size() > 0) {
                FileManagerEntity fileManagerEntity = this.D.G.get(0);
                this.f207896m.c(fileManagerEntity.searchPCPart.j(fileManagerEntity.fileSize));
                if (fileManagerEntity.searchPCPart.f207689e == FileManagerEntitySearchPCPart.FileDownloadState.KCOMPLETE) {
                    this.f207896m.setVisibility(4);
                } else {
                    this.f207896m.setVisibility(0);
                }
                this.C.setImageResource(fileManagerEntity.searchPCPart.c());
            }
        }
    }

    public FileSearchResultView() {
    }
}
