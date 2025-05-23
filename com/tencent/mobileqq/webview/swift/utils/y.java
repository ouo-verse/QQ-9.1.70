package com.tencent.mobileqq.webview.swift.utils;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.h;
import com.tencent.mobileqq.webview.swift.utils.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.util.Pair;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes20.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Pair<Integer, String>> f314799f;

    /* renamed from: a, reason: collision with root package name */
    private Activity f314800a;

    /* renamed from: b, reason: collision with root package name */
    private PermissionRequest f314801b;

    /* renamed from: c, reason: collision with root package name */
    private String f314802c;

    /* renamed from: d, reason: collision with root package name */
    private Queue<String> f314803d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f314804e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(String str, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        HashMap hashMap = new HashMap();
        f314799f = hashMap;
        hashMap.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new Pair(Integer.valueOf(R.string.zge), QQPermissionConstants.Permission.RECORD_AUDIO));
        f314799f.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new Pair<>(Integer.valueOf(R.string.zgb), QQPermissionConstants.Permission.CAMERA));
    }

    public y(Activity activity, PermissionRequest permissionRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) permissionRequest);
            return;
        }
        this.f314800a = activity;
        this.f314801b = permissionRequest;
        this.f314803d = new LinkedList(Arrays.asList(permissionRequest.getResources()));
        this.f314802c = permissionRequest.getOrigin().getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + permissionRequest.getOrigin().getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str, String[] strArr, boolean z16) {
        QLog.d("WebViewPermissionCollector", 1, "requestAppPermission " + strArr[0] + " allGranted:" + z16);
        if (z16 || ContextCompat.checkSelfPermission(BaseApplication.getContext(), strArr[0]) == 0) {
            if (this.f314804e == null) {
                this.f314804e = new ArrayList();
            }
            this.f314804e.add(str);
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(final String str, boolean z16) {
        if (z16) {
            i(f314799f.get(str).second, new h.a() { // from class: com.tencent.mobileqq.webview.swift.utils.x
                @Override // com.tencent.mobileqq.webview.swift.injector.h.a
                public final void a(String[] strArr, boolean z17) {
                    y.this.e(str, strArr, z17);
                }
            });
        } else {
            j();
        }
    }

    private void i(String str, h.a aVar) {
        if (ContextCompat.checkSelfPermission(BaseApplication.getContext(), str) == 0) {
            aVar.a(new String[]{str}, true);
        } else {
            ((com.tencent.mobileqq.webview.swift.injector.h) aa.k(com.tencent.mobileqq.webview.swift.injector.h.class)).a(this.f314800a, new String[]{str}, aVar);
        }
    }

    private void k(Activity activity, final String str, final a aVar) {
        if (!f314799f.containsKey(str)) {
            aVar.a(str, false);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0);
        createCustomDialog.setTitle(R.string.zgg);
        createCustomDialog.setMessage(activity.getResources().getString(R.string.zgf, this.f314802c, activity.getString(f314799f.get(str).first.intValue())));
        createCustomDialog.setPositiveButton(R.string.zgd, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.webview.swift.utils.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                y.a.this.a(str, true);
            }
        });
        createCustomDialog.setNegativeButton(R.string.zgc, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.webview.swift.utils.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                y.a.this.a(str, false);
            }
        });
        createCustomDialog.setCanceledOnTouchOutside(false);
        if (!activity.isFinishing()) {
            createCustomDialog.show();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String poll = this.f314803d.poll();
        if (poll != null) {
            QLog.d("WebViewPermissionCollector", 1, "requestWebPermissions cur:" + poll);
            k(this.f314800a, poll, new a() { // from class: com.tencent.mobileqq.webview.swift.utils.u
                @Override // com.tencent.mobileqq.webview.swift.utils.y.a
                public final void a(String str, boolean z16) {
                    y.this.f(str, z16);
                }
            });
            return;
        }
        List<String> list = this.f314804e;
        if (list != null && list.size() > 0) {
            String[] strArr = new String[this.f314804e.size()];
            this.f314801b.grant((String[]) this.f314804e.toArray(strArr));
            QLog.d("WebViewPermissionCollector", 1, "requestWebPermissions grant:" + Arrays.toString(strArr));
            return;
        }
        this.f314801b.deny();
        QLog.d("WebViewPermissionCollector", 1, "requestWebPermissions all denied");
    }
}
