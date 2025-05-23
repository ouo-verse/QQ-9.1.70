package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class b implements com.tencent.mobileqq.filebrowser.e {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements QFileAppStorePromoteManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.b f208989a;

        a(e.b bVar) {
            this.f208989a = bVar;
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.e
        public void a() {
            this.f208989a.a();
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.e
        public void b() {
            this.f208989a.b();
        }
    }

    private QFileAppStorePromoteManager i0() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        return ((QQAppInterface) runtime).getFileManagerEngine().J();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String H(Context context) {
        int O;
        QFileAppStorePromoteManager i06 = i0();
        if (i06 == null || !E() || !i06.d() || TextUtils.isEmpty(D()) || (O = O()) == 6 || O == 2 || O == 4 || O == 5) {
            return null;
        }
        return i06.h(context);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void a0(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, QQBrowserActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void c0(Context context) {
        QFileAppStorePromoteManager i06 = i0();
        if (i06 == null) {
            return;
        }
        String D = D();
        if (i06.c()) {
            if (!TextUtils.isEmpty(D)) {
                QFileAppStorePromoteManager.p(D, 1);
                return;
            } else {
                QLog.i("FileBrowserModel", 1, "app store has installed, but apk package name is null!");
                return;
            }
        }
        i06.n(context, D);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean f0(Context context, e.b bVar) {
        QFileAppStorePromoteManager i06 = i0();
        if (i06 == null) {
            return false;
        }
        return i06.o(context, m(), new a(bVar));
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void h0(JSONObject jSONObject, String str, TeamWorkFileImportInfo teamWorkFileImportInfo, Activity activity) throws JSONException {
        TencentDocData tencentDocData = new TencentDocData();
        TencentDocData.obtainFromJsonObject(jSONObject, null, tencentDocData);
        tencentDocData.docUrl = str;
        TeamWorkUtils.c((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), activity, tencentDocData, teamWorkFileImportInfo);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void j(Activity activity, String str) {
        FileManagerUtil.openWithOtherApp(activity, str);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void q(Activity activity, int i3, String str) {
        MiniChatActivity.Q2(activity, i3, str, ac.R((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), str, i3));
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void v(JSONObject jSONObject, String str, Context context) throws JSONException {
        TencentDocData.obtainFromJsonObject(jSONObject, null, new TencentDocData());
        try {
            String string = jSONObject.getJSONObject("doc_meta").getString("title");
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", -1);
            bundle.putString(AppConstants.Key.FORWARD_TEXT, String.format("\u3010\u817e\u8baf\u6587\u6863\u3011\u9080\u8bf7\u4f60\u4e00\u8d77\u67e5\u770b\u6587\u6863\u300a%s\u300b\n%s", string, str));
            Intent intent = new Intent();
            intent.putExtra("isFromShare", true);
            intent.putExtras(bundle);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, true);
            RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
