package com.tencent.biz.subscribe.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.utils.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeDraftManager {

    /* renamed from: e, reason: collision with root package name */
    public static String f96210e = "SubscribeDraftManager";

    /* renamed from: f, reason: collision with root package name */
    private static SubscribeDraftManager f96211f;

    /* renamed from: a, reason: collision with root package name */
    private String f96212a = AppConstants.SUBSCRIBE_DRAFT;

    /* renamed from: b, reason: collision with root package name */
    private String f96213b = AppConstants.SUBSCRIBE_DRAFT_SIMPLE;

    /* renamed from: c, reason: collision with root package name */
    private String f96214c = ".draft";

    /* renamed from: d, reason: collision with root package name */
    private bc f96215d = ThreadManagerV2.newHandlerRecycleThread("SubscribeDraftManager", 0).b();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.utils.SubscribeDraftManager$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f96225f;
        final /* synthetic */ SubscribeDraftManager this$0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            Pair g16 = this.this$0.g(this.f96223d, this.f96224e);
            if (g16 != null) {
                String h16 = this.this$0.h((String) g16.second);
                if (!TextUtils.isEmpty(h16)) {
                    SubscribeDraftBean subscribeDraftBean = (SubscribeDraftBean) com.tencent.biz.pubaccount.util.d.b().a(h16, SubscribeDraftBean.class);
                    if (subscribeDraftBean != null && (cVar = this.f96225f) != null) {
                        cVar.a(5, true, this.f96224e, subscribeDraftBean);
                        return;
                    }
                    return;
                }
                c cVar2 = this.f96225f;
                if (cVar2 != null) {
                    cVar2.a(5, false, this.f96224e, null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j.f f96232d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96233e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96234f;

        a(j.f fVar, String str, ActionSheet actionSheet) {
            this.f96232d = fVar;
            this.f96233e = str;
            this.f96234f = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f96232d.a(false, this.f96233e, true);
            this.f96234f.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96236d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96237e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j.f f96238f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ActionSheet f96239h;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements c {
            a() {
            }

            @Override // com.tencent.biz.subscribe.utils.SubscribeDraftManager.c
            public void a(int i3, boolean z16, String str, Object... objArr) {
                b bVar = b.this;
                j.f fVar = bVar.f96238f;
                if (fVar != null) {
                    fVar.a(z16, bVar.f96236d, false);
                }
            }
        }

        b(String str, String str2, j.f fVar, ActionSheet actionSheet) {
            this.f96236d = str;
            this.f96237e = str2;
            this.f96238f = fVar;
            this.f96239h = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                if (hf0.a.a("subScribe_delete_draft")) {
                    return;
                } else {
                    SubscribeDraftManager.this.e(this.f96236d, this.f96237e, new a());
                }
            }
            this.f96239h.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(int i3, boolean z16, String str, Object... objArr);
    }

    SubscribeDraftManager() {
    }

    private Pair<String, String> d(String str) {
        String md5 = MD5Utils.toMD5(str);
        String str2 = this.f96212a + md5;
        String str3 = this.f96213b + md5;
        QLog.d(f96210e, 2, "createDraftDirectory currentFolder:" + str2 + " currentSimpleFolder:" + str3);
        try {
            FileUtils.createDirectory(str2);
            FileUtils.createDirectory(str3);
            return new Pair<>(str2, str3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static synchronized SubscribeDraftManager f() {
        SubscribeDraftManager subscribeDraftManager;
        synchronized (SubscribeDraftManager.class) {
            if (f96211f == null) {
                f96211f = new SubscribeDraftManager();
            }
            subscribeDraftManager = f96211f;
        }
        return subscribeDraftManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String, String> g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(f96210e, 4, "generate draft failed UID is empty");
            return null;
        }
        Pair<String, String> d16 = d(str);
        if (d16 != null) {
            QLog.d(f96210e, 4, "generate draft id:" + str2 + "\n,mUid =" + str + ", md5 = " + Md5Utils.getMD5(str));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(d16.first);
            sb5.append("/");
            sb5.append(str2);
            sb5.append(this.f96214c);
            return new Pair<>(sb5.toString(), d16.second + "/" + str2 + this.f96214c);
        }
        QLog.d(f96210e, 4, "generate draft failed UID ,SDCARD generate folder failed");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    public String h(String str) {
        Exception e16;
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder();
        ?? r16 = 0;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(new File(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                        } catch (Exception e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb5.toString();
                        }
                    }
                    bufferedReader.close();
                } catch (Exception e18) {
                    e16 = e18;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e26.printStackTrace();
            }
            return sb5.toString();
        } catch (Throwable th6) {
            th = th6;
            r16 = str;
        }
    }

    public void e(final String str, final String str2, final c cVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f96215d.post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Pair g16 = SubscribeDraftManager.this.g(str, str2);
                    if (g16 != null) {
                        FileUtils.deleteFile((String) g16.first);
                        FileUtils.deleteFile((String) g16.second);
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.a(2, true, str2, new Object[0]);
                            return;
                        }
                        return;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.a(2, false, str2, new Object[0]);
                    }
                }
            });
        } else {
            QLog.d(f96210e, 4, "deletDraft failed because uin or draftID is empty");
        }
    }

    public boolean i(String str) {
        File[] listFiles;
        Pair<String, String> d16 = d(str);
        if (d16 == null) {
            return false;
        }
        File file = new File(d16.second);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return false;
        }
        return true;
    }

    public void j(final String str, final c cVar) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(f96210e, 4, "qureyAllSimpleDraft failed because uin is empty");
        } else {
            this.f96215d.post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.SubscribeDraftManager.2
                @Override // java.lang.Runnable
                public void run() {
                    SubscribeDraftBean subscribeDraftBean;
                    File file = new File(SubscribeDraftManager.this.f96213b + Md5Utils.getMD5(str));
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        QLog.d(SubscribeDraftManager.f96210e, 4, "qureyAllSimpleDraft count:" + listFiles.length);
                        ArrayList arrayList = new ArrayList();
                        int length = listFiles.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            try {
                                String h16 = SubscribeDraftManager.this.h(listFiles[i3].getAbsolutePath());
                                if (!TextUtils.isEmpty(h16) && (subscribeDraftBean = (SubscribeDraftBean) com.tencent.biz.pubaccount.util.d.b().a(h16, SubscribeDraftBean.class)) != null) {
                                    arrayList.add(subscribeDraftBean);
                                }
                            } catch (Exception unused) {
                                QLog.d(SubscribeDraftManager.f96210e, 4, "readString failed:");
                            }
                        }
                        Collections.sort(arrayList);
                        if (!arrayList.isEmpty()) {
                            c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a(4, true, "", arrayList);
                                return;
                            }
                            return;
                        }
                        c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.a(4, false, "", null);
                            return;
                        }
                        return;
                    }
                    c cVar4 = cVar;
                    if (cVar4 != null) {
                        cVar4.a(4, false, "", null);
                    }
                }
            });
        }
    }

    public void k(final String str, final String str2, final c cVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f96215d.post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.SubscribeDraftManager.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Pair g16 = SubscribeDraftManager.this.g(str, str2);
                    if (g16 != null) {
                        String h16 = SubscribeDraftManager.this.h((String) g16.first);
                        if (!TextUtils.isEmpty(h16)) {
                            c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a(6, true, str2, h16);
                                return;
                            }
                            return;
                        }
                        c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.a(6, false, str2, null);
                        }
                    }
                }
            });
        } else {
            QLog.d(f96210e, 4, "deletDraft failed because uin or draftID is empty");
        }
    }

    public void l(Activity activity, final String str, final String str2, final String str3, final String str4, final c cVar) {
        if (!PermissionUtils.isStorePermissionEnable(activity)) {
            DialogUtil.showPermissionDialogForStorage(activity);
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
            if (cVar != null) {
                cVar.a(3, false, str2, new Object[0]);
            }
            QLog.d(f96210e, 4, "modifyDraft failed because something is empty");
            return;
        }
        this.f96215d.post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                Pair g16 = SubscribeDraftManager.this.g(str, str2);
                if (g16 != null) {
                    if (SubscribeDraftManager.this.n((String) g16.first, str3) && SubscribeDraftManager.this.n((String) g16.second, str4)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.a(3, true, str2, new Object[0]);
                            return;
                        }
                        return;
                    }
                    FileUtils.deleteFile((String) g16.first);
                    FileUtils.deleteFile((String) g16.second);
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.a(3, false, str2, new Object[0]);
                        return;
                    }
                    return;
                }
                c cVar4 = cVar;
                if (cVar4 != null) {
                    cVar4.a(3, false, str2, new Object[0]);
                }
                QLog.d(SubscribeDraftManager.f96210e, 4, "modify new draft failed because cat't new folder");
            }
        });
    }

    public void m(Context context, String str, String str2, int i3, j.f fVar) {
        if (context == null) {
            return;
        }
        ActionSheet create = ActionSheet.create(context);
        create.addButton(i3, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnBottomCancelListener(new a(fVar, str, create));
        create.setOnButtonClickListener(new b(str, str2, fVar, create));
        if (!create.isShowing()) {
            create.show();
        }
    }

    public boolean n(String str, String str2) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, false);
        } catch (Throwable unused) {
        }
        try {
            fileWriter.write(str2);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Throwable unused2) {
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException unused3) {
                }
            }
            return false;
        }
    }
}
