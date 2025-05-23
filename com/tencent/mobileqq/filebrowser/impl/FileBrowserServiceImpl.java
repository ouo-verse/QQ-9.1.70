package com.tencent.mobileqq.filebrowser.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filebrowser.FileBrowserActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.f;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tbstool.fileview.TBSToolLocalTbsViewManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileBrowserServiceImpl implements IFileBrowserService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FileBrowserServiceImpl";
    private static Integer browseId;
    private final Map<Integer, e> fileModelMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Function0<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f205938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f205939e;

        a(e eVar, Intent intent) {
            this.f205938d = eVar;
            this.f205939e = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FileBrowserServiceImpl.this, eVar, intent);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            long[] x16 = this.f205938d.x();
            if (x16 != null) {
                this.f205939e.putExtra("forward_root_msg_ids", x16);
                if (this.f205938d.I() != null) {
                    this.f205939e.putExtra("forward_cur_msg_id", this.f205938d.I().ntSubMsgID);
                    return null;
                }
                QLog.i(FileBrowserServiceImpl.TAG, 1, "file model entity is null: " + this.f205938d);
                return null;
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            browseId = 0;
        }
    }

    public FileBrowserServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fileModelMap = new HashMap();
        }
    }

    private Bundle getExtraParams(f fVar) {
        Bundle bundle = new Bundle();
        if (fVar == null) {
            return bundle;
        }
        bundle.putInt(IFileBrowserService.FILE_BROWSER_PARAMS_ENTRANCE, fVar.getEntranceType());
        bundle.putInt("key_source", fVar.getSource());
        bundle.putInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM, fVar.a());
        bundle.putString("file_browser_extra_tbs_tool_action", fVar.b());
        if (fVar.c() != null) {
            bundle.putString("file_browser_extra_params_uin", fVar.c());
        }
        return bundle;
    }

    private void internalBrowserFile(Context context, int i3, e eVar, f fVar) {
        Integer valueOf = Integer.valueOf(browseId.intValue() + 1);
        browseId = valueOf;
        this.fileModelMap.put(valueOf, eVar);
        QLog.d("fileBrowser", 1, "browse file use new fileBrowser, entrance " + fVar.getEntranceType() + " browse Id" + browseId + ", fileModel:" + eVar);
        Intent intent = new Intent(context, (Class<?>) FileBrowserActivity.class);
        intent.putExtra(IFileBrowserService.STRING_BROWSE_ID, browseId);
        intent.putExtras(getExtraParams(fVar));
        com.tencent.mobileqq.filebrowser.toogle.a.c(new a(eVar, intent));
        if (i3 != -1) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            context.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public void browserFile(Context context, e eVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            internalBrowserFile(context, -1, eVar, fVar);
        } else {
            iPatchRedirector.redirect((short) 4, this, context, eVar, fVar);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public e getFileModel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return this.fileModelMap.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public void onDestroy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "onDestroy  browseId:" + i3);
        e remove = this.fileModelMap.remove(Integer.valueOf(i3));
        if (remove != null) {
            QLog.d(TAG, 1, "onDestroy  value:" + remove);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public int putFileModel(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar)).intValue();
        }
        browseId = Integer.valueOf(browseId.intValue() + 1);
        QLog.d(TAG, 1, "putFileModel  browseId:" + browseId + ", fileModel:" + eVar);
        this.fileModelMap.put(browseId, eVar);
        return browseId.intValue();
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public void reportQQBrowserDownloadEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            TBSToolLocalTbsViewManager.l().z(str);
            LocalTbsViewManager.k().w(str);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public void setCheckShowTbsReaderBar(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            TBSToolLocalTbsViewManager.l().B(z16);
            LocalTbsViewManager.k().z(z16);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.IFileBrowserService
    public void browserFile(Activity activity, int i3, e eVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            internalBrowserFile(activity, i3, eVar, fVar);
        } else {
            iPatchRedirector.redirect((short) 5, this, activity, Integer.valueOf(i3), eVar, fVar);
        }
    }
}
