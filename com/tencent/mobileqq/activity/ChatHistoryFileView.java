package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatHistoryFileView;
import com.tencent.mobileqq.adapter.f;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.richmedia.FilePreviewLayerFragment;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatHistoryFileView extends ChatHistoryViewBase implements Handler.Callback, f.b {
    static IPatchRedirector $redirector_;
    XListView C;
    LinearLayout D;
    com.tencent.mobileqq.adapter.f E;
    boolean F;
    View.OnClickListener G;
    View.OnClickListener H;
    private String I;
    private List<Object> J;
    private FMObserver K;
    private int L;
    protected final MqqHandler M;

    /* renamed from: f, reason: collision with root package name */
    final String f175306f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f175307h;

    /* renamed from: i, reason: collision with root package name */
    Context f175308i;

    /* renamed from: m, reason: collision with root package name */
    View f175309m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatHistoryFileView$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LinkedHashMap linkedHashMap, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryFileView<FileAssistant>", 1, "local doc size: " + linkedHashMap.size());
                QLog.d("ChatHistoryFileView<FileAssistant>", 1, "rsp jsonObj: " + jSONObject.toString());
            }
            ChatHistoryFileView.this.p(jSONObject, linkedHashMap);
            FileWriter fileWriter = null;
            try {
                try {
                    try {
                        File file = new File(ChatHistoryFileView.this.f175308i.getCacheDir(), ".tencentdoccache");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter2 = new FileWriter(file);
                        try {
                            fileWriter2.write(jSONObject.toString());
                            fileWriter2.flush();
                            fileWriter2.close();
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            fileWriter = fileWriter2;
                            e.printStackTrace();
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                        } catch (IOException e17) {
                            e = e17;
                            fileWriter = fileWriter2;
                            e.printStackTrace();
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                    } catch (IOException e26) {
                        e = e26;
                    }
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            BufferedReader bufferedReader;
            JSONObject jSONObject;
            ?? hasPatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || (hasPatch = iPatchRedirector.hasPatch((short) 2)) == 0) {
                final LinkedHashMap o16 = ChatHistoryFileView.this.o();
                if (!NetworkUtil.isNetworkAvailable(ChatHistoryFileView.this.f175308i)) {
                    JSONObject jSONObject2 = null;
                    BufferedReader bufferedReader2 = null;
                    jSONObject2 = null;
                    jSONObject2 = null;
                    jSONObject2 = null;
                    jSONObject2 = null;
                    BufferedReader bufferedReader3 = null;
                    try {
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    try {
                        try {
                            File file = new File(ChatHistoryFileView.this.f175308i.getCacheDir(), ".tencentdoccache");
                            if (file.exists()) {
                                bufferedReader = new BufferedReader(new FileReader(file));
                                try {
                                    StringBuilder sb5 = new StringBuilder();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else {
                                            sb5.append(readLine);
                                        }
                                    }
                                    jSONObject = new JSONObject(sb5.toString());
                                    bufferedReader2 = bufferedReader;
                                } catch (FileNotFoundException e17) {
                                    e = e17;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    ChatHistoryFileView.this.p(jSONObject2, o16);
                                    return;
                                } catch (IOException e18) {
                                    e = e18;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    ChatHistoryFileView.this.p(jSONObject2, o16);
                                    return;
                                } catch (JSONException e19) {
                                    e = e19;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    ChatHistoryFileView.this.p(jSONObject2, o16);
                                    return;
                                }
                            } else {
                                jSONObject = null;
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            jSONObject2 = jSONObject;
                        } catch (FileNotFoundException e27) {
                            e = e27;
                            bufferedReader = null;
                        } catch (IOException e28) {
                            e = e28;
                            bufferedReader = null;
                        } catch (JSONException e29) {
                            e = e29;
                            bufferedReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (bufferedReader3 != null) {
                            }
                            throw th;
                        }
                        ChatHistoryFileView.this.p(jSONObject2, o16);
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader3 = hasPatch;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e36) {
                                e36.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                ((ITeamWorkHandler) ChatHistoryFileView.this.f175307h.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).getRecentFilesByHttp(ChatHistoryFileView.this.I, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.n
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        ChatHistoryFileView.AnonymousClass1.this.b(o16, obj);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Comparator<Object> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileView.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            if (obj instanceof FileManagerEntity) {
                if (obj2 instanceof FileManagerEntity) {
                    if (((FileManagerEntity) obj).srvTime > ((FileManagerEntity) obj2).srvTime) {
                        return -1;
                    }
                    return 1;
                }
                if (obj2 instanceof TencentDocData) {
                    if (((FileManagerEntity) obj).srvTime > ((TencentDocData) obj2).aioTime) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            if (obj instanceof TencentDocData) {
                if (obj2 instanceof FileManagerEntity) {
                    if (((TencentDocData) obj).aioTime > ((FileManagerEntity) obj2).srvTime) {
                        return -1;
                    }
                    return 1;
                }
                if (obj2 instanceof TencentDocData) {
                    if (((TencentDocData) obj).aioTime > ((TencentDocData) obj2).aioTime) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!(view.getTag() instanceof String)) {
                Object obj = ((f.a) view.getTag()).D;
                if (obj instanceof FileManagerEntity) {
                    ChatHistoryFileView.this.w((FileManagerEntity) obj);
                } else if (obj instanceof TencentDocData) {
                    ChatHistoryFileView.this.x((TencentDocData) obj);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements FMDialogUtil.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FileManagerEntity f175313a;

            a(FileManagerEntity fileManagerEntity) {
                this.f175313a = fileManagerEntity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) fileManagerEntity);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f175313a.getCloudType() == 0) {
                    ChatHistoryFileView.this.f175307h.getOnlineFileSessionCenter().v(this.f175313a.nSessionId);
                    return;
                }
                if (this.f175313a.getCloudType() == 6) {
                    DataLineHandler dataLineHandler = (DataLineHandler) ChatHistoryFileView.this.f175307h.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(this.f175313a.uniseq));
                    if (!dataLineHandler.c4(arrayList)) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_n);
                        return;
                    }
                    return;
                }
                ChatHistoryFileView.this.f175307h.getFileManagerEngine().t0(this.f175313a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements FMDialogUtil.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FileManagerEntity f175315a;

            b(FileManagerEntity fileManagerEntity) {
                this.f175315a = fileManagerEntity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) fileManagerEntity);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f175315a.getCloudType() == 0) {
                    ChatHistoryFileView.this.f175307h.getOnlineFileSessionCenter().x(this.f175315a.nSessionId);
                    return;
                }
                if (this.f175315a.getCloudType() == 6) {
                    DataLineHandler dataLineHandler = (DataLineHandler) ChatHistoryFileView.this.f175307h.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(this.f175315a.uniseq));
                    if (!dataLineHandler.c4(arrayList)) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_n);
                        return;
                    }
                    return;
                }
                ChatHistoryFileView.this.f175307h.getFileManagerEngine().o0(this.f175315a.nSessionId);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.a aVar = (f.a) view.getTag();
                FileManagerEntity fileManagerEntity = (FileManagerEntity) aVar.D;
                if (5 != fileManagerEntity.cloudType) {
                    FileManagerUtil.associateLocalWithCloud(fileManagerEntity);
                }
                int i3 = aVar.f187169f;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                                    com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                                } else {
                                    kc1.a.c(fileManagerEntity).d(fileManagerEntity.isSend(), ChatHistoryFileView.this.f175308i, new b(fileManagerEntity));
                                }
                            }
                        } else if (fileManagerEntity.getCloudType() == 0) {
                            ChatHistoryFileView.this.f175307h.getOnlineFileSessionCenter().u(fileManagerEntity.nSessionId);
                        } else if (fileManagerEntity.getCloudType() == 6) {
                            ((DataLineHandler) ChatHistoryFileView.this.f175307h.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).j3(0, fileManagerEntity.uniseq, false);
                        } else {
                            ChatHistoryFileView.this.f175307h.getFileManagerEngine().i0(fileManagerEntity.nSessionId);
                        }
                    } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                    } else {
                        kc1.a.c(fileManagerEntity).d(false, ChatHistoryFileView.this.f175308i, new a(fileManagerEntity));
                    }
                } else {
                    ChatHistoryFileView.this.w(fileManagerEntity);
                }
                ChatHistoryFileView.this.E.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends FMObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileView.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                ChatHistoryFileView.this.E.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean z16, long j3, long j16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
            } else {
                ChatHistoryFileView.this.E.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void U(long j3, long j16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
            } else {
                ChatHistoryFileView.this.E.notifyDataSetChanged();
            }
        }
    }

    public ChatHistoryFileView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175306f = "ChatHistoryFileView<FileAssistant>";
        this.F = false;
        this.K = null;
        this.M = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedHashMap<String, List<Object>> o() {
        String c16;
        ArrayList<FileManagerEntity> arrayList = new ArrayList(this.f175307h.getFileManagerProxy().T(this.I));
        LinkedHashMap<String, List<Object>> linkedHashMap = new LinkedHashMap<>();
        for (FileManagerEntity fileManagerEntity : arrayList) {
            if (fileManagerEntity != null && !fileManagerEntity.bDelInAio) {
                int i3 = this.L;
                if (i3 == 1) {
                    int i16 = fileManagerEntity.nFileType;
                    if (i16 != 3 && i16 != 9 && i16 != 7 && i16 != 6 && i16 != 10) {
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("ChatHistoryFileView<FileAssistant>", 1, "ChatHistory Query Entity[" + fileManagerEntity.getId() + "] SessionId:" + fileManagerEntity.nSessionId);
                    }
                    c16 = com.tencent.mobileqq.filemanager.util.ap.c(fileManagerEntity.srvTime);
                    if (!linkedHashMap.containsKey(c16)) {
                        linkedHashMap.put(c16, new ArrayList());
                    }
                    linkedHashMap.get(c16).add(fileManagerEntity);
                } else {
                    if (i3 == 3) {
                        int i17 = fileManagerEntity.nFileType;
                        if (i17 != 3 && i17 != 9 && i17 != 7 && i17 != 6 && i17 != 0 && i17 != 10 && i17 != 2) {
                        }
                    }
                    if (QLog.isDevelopLevel()) {
                    }
                    c16 = com.tencent.mobileqq.filemanager.util.ap.c(fileManagerEntity.srvTime);
                    if (!linkedHashMap.containsKey(c16)) {
                    }
                    linkedHashMap.get(c16).add(fileManagerEntity);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(JSONObject jSONObject, LinkedHashMap<String, List<Object>> linkedHashMap) {
        if (jSONObject != null) {
            ArrayList<TencentDocData> t16 = t(jSONObject);
            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(t16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryFileView<FileAssistant>", 1, "tencent doc size: " + t16.size());
                }
                Iterator<TencentDocData> it = t16.iterator();
                while (it.hasNext()) {
                    TencentDocData next = it.next();
                    String c16 = com.tencent.mobileqq.filemanager.util.ap.c(next.aioTime);
                    if (!linkedHashMap.containsKey(c16)) {
                        linkedHashMap.put(c16, new ArrayList());
                    }
                    linkedHashMap.get(c16).add(next);
                }
                FileManagerReporter.addData("0X8009A9E");
            }
            z(linkedHashMap);
        }
        Message message = new Message();
        message.what = 1;
        message.obj = linkedHashMap;
        this.M.sendMessage(message);
    }

    private void q() {
        if (this.G != null) {
            return;
        }
        this.G = new c();
    }

    private void r() {
        if (this.H != null) {
            return;
        }
        this.H = new b();
    }

    private void s() {
        List<Object> list = this.J;
        if (list != null && list.size() != 0) {
            this.D.setVisibility(8);
            this.C.setVisibility(0);
        } else {
            this.D.setVisibility(0);
            this.C.setVisibility(8);
        }
        this.f175309m.setVisibility(0);
        this.E.notifyDataSetChanged();
    }

    private ArrayList<TencentDocData> t(JSONObject jSONObject) {
        try {
            if (jSONObject.getInt("retcode") == 0) {
                ArrayList<TencentDocData> arrayList = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("recent_file_list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    TencentDocData tencentDocData = new TencentDocData();
                    JSONObject jSONObject3 = (JSONObject) jSONObject2.get("doc_info");
                    tencentDocData.peerTips = jSONObject2.getString("peer_tips");
                    TencentDocData.obtainFromJsonObject(jSONObject3, (JSONObject) jSONObject2.get("qq_share_common_msg"), tencentDocData);
                    arrayList.add(tencentDocData);
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ChatHistoryFileView<FileAssistant>", 1, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    private void u() {
        ThreadManagerV2.post(new AnonymousClass1(), 8, null, true);
    }

    private void v() {
        y(o());
        s();
    }

    private void y(LinkedHashMap<String, List<Object>> linkedHashMap) {
        List<Object> list;
        if (linkedHashMap != null && (list = this.J) != null) {
            list.clear();
            for (String str : linkedHashMap.keySet()) {
                this.J.add(str);
                this.J.addAll(linkedHashMap.get(str));
            }
        }
    }

    private void z(LinkedHashMap<String, List<Object>> linkedHashMap) {
        Iterator<List<Object>> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            Collections.sort(it.next(), new a());
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.F = false;
        this.E.b(false);
        this.E.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.F = true;
        this.E.b(true);
        this.E.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.K != null) {
            this.f175307h.getFileManagerNotifyCenter().deleteObserver(this.K);
            this.K = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (this.K != null) {
                return;
            }
            this.K = new d();
            this.f175307h.getFileManagerNotifyCenter().addObserver(this.K);
        }
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f175309m;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.F;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what != 1) {
            return false;
        }
        y((LinkedHashMap) message.obj);
        s();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.ChatHistoryViewBase
    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.L = i3;
        if (i3 == 1) {
            u();
        } else {
            v();
        }
    }

    @Override // com.tencent.mobileqq.adapter.f.b
    public boolean isSelected(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) fileManagerEntity)).booleanValue();
        }
        return this.f175325e.isSelected(fileManagerEntity);
    }

    public void n(Intent intent, QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, qQAppInterface, context);
            return;
        }
        this.f175307h = qQAppInterface;
        this.f175308i = context;
        q();
        r();
        this.I = intent.getStringExtra("uin");
        this.J = new ArrayList();
        com.tencent.mobileqq.adapter.f fVar = new com.tencent.mobileqq.adapter.f(this.f175308i, this.J, this.H, this.G, this);
        this.E = fVar;
        fVar.a(this);
        View inflate = View.inflate(this.f175308i, R.layout.als, null);
        this.f175309m = inflate;
        this.C = (XListView) inflate.findViewById(R.id.f166069ec1);
        this.D = (LinearLayout) this.f175309m.findViewById(R.id.fa9);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.C.setAdapter((ListAdapter) this.E);
        View findViewById = this.f175309m.findViewById(R.id.c_y);
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById.findViewById(R.id.gku);
        qUISearchBar.getInputWidget().setHint(R.string.f170725a14);
        findViewById.setVisibility(8);
        qUISearchBar.setVisibility(8);
    }

    public void w(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 6;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileManagerEntity);
            return;
        }
        this.f175307h.getFileManagerDataCenter().e0();
        if (g()) {
            if (this.f175325e.isSelected(fileManagerEntity)) {
                this.f175325e.removeSelected(fileManagerEntity);
            } else if (this.f175325e.R2()) {
                return;
            } else {
                this.f175325e.addSelected(fileManagerEntity);
            }
            if (fileManagerEntity.cloudType == 3 && !com.tencent.mobileqq.filemanager.util.q.f(fileManagerEntity.getFilePath())) {
                com.tencent.mobileqq.filemanager.util.d.f(FileManagerUtil.cutLongName(fileManagerEntity.fileName) + HardCodeUtil.qqStr(R.string.kde));
                this.f175325e.removeSelected(fileManagerEntity);
            }
            this.E.notifyDataSetChanged();
            return;
        }
        if (!f()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
                return;
            }
            return;
        }
        j();
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_viewer_in";
        aVar.f209158c = 73;
        aVar.f209159d = com.tencent.mobileqq.filemanager.util.q.j(fileManagerEntity.fileName);
        aVar.f209160e = fileManagerEntity.fileSize;
        FileManagerReporter.addData(this.f175307h.getCurrentAccountUin(), aVar);
        FileManagerReporter.addData("0X8004AE4");
        int i16 = fileManagerEntity.nFileType;
        if (i16 != 0 && i16 != 2) {
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d(this.f175307h, fileManagerEntity);
            int i17 = fileManagerEntity.peerType;
            if (i17 == 0) {
                i3 = 2;
            } else if (i17 != 3000) {
                i3 = 7;
            }
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(this.f175308i, dVar, new com.tencent.mobileqq.filemanager.openbrowser.c().d(i3).h(this.I));
            return;
        }
        com.tencent.mobileqq.filemanager.openbrowser.g gVar = new com.tencent.mobileqq.filemanager.openbrowser.g(this.f175307h, this.I, fileManagerEntity);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), gVar);
        eVar.g(com.tencent.mobileqq.richmedia.depend.a.class.getName(), gVar);
        List<RFWLayerItemMediaInfo> s16 = gVar.s();
        int p16 = gVar.p();
        ArrayList arrayList = new ArrayList();
        if (p16 < s16.size()) {
            arrayList.add(s16.get(p16));
            eVar.j(s16);
            eVar.i(p16);
            RFWLayerLaunchUtil.jumpToGallery(new ImageView(this.f175308i), arrayList, 0, QQGalleryActivity.class, FilePreviewLayerFragment.class, new Bundle());
            return;
        }
        QLog.i("ChatHistoryFileView<FileAssistant>", 1, "browserRichMedia exception: currentIndex=" + p16 + ", dataList size=" + arrayList.size());
    }

    public void x(TencentDocData tencentDocData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tencentDocData);
            return;
        }
        if (g()) {
            if (this.f175325e.T2(tencentDocData)) {
                this.f175325e.V2(tencentDocData);
            } else if (this.f175325e.R2()) {
                return;
            } else {
                this.f175325e.K2(tencentDocData);
            }
        } else {
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).clickWebTDDoc(tencentDocData.docUrl, this.f175308i);
            FileManagerReporter.addData("0X8009A9F");
        }
        this.E.notifyDataSetChanged();
    }
}
