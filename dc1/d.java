package dc1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.u;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f393544a;

    /* renamed from: b, reason: collision with root package name */
    private e f393545b;

    /* renamed from: e, reason: collision with root package name */
    private int f393548e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f393549f;

    /* renamed from: g, reason: collision with root package name */
    private String f393550g;

    /* renamed from: l, reason: collision with root package name */
    private int f393555l;

    /* renamed from: c, reason: collision with root package name */
    private boolean f393546c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f393547d = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f393552i = false;

    /* renamed from: j, reason: collision with root package name */
    private Class<?> f393553j = FileBrowserActivity.class;

    /* renamed from: h, reason: collision with root package name */
    private int f393551h = -1;

    /* renamed from: k, reason: collision with root package name */
    private Bundle f393554k = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f393556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f393557b;

        a(int i3, c cVar) {
            this.f393556a = i3;
            this.f393557b = cVar;
        }

        @Override // com.tencent.mobileqq.filemanager.util.u
        public void a() {
            d.this.j(this.f393556a, this.f393557b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a(Intent intent);
    }

    public d(Context context, e eVar) {
        this.f393544a = context;
        this.f393545b = eVar;
    }

    private boolean h() {
        int i3 = this.f393548e;
        if (i3 == 1 || i3 == 5 || i3 == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        j(-1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, c cVar) {
        if (this.f393545b.a() && k()) {
            return;
        }
        Intent d16 = this.f393545b.d();
        if (d16 == null) {
            QLog.i("FileBrowserCreator<FileAssistant>", 1, "openFileBrowser error, intent params is null.");
            return;
        }
        int i16 = this.f393551h;
        if (i16 != -1) {
            d16.setFlags(i16);
        }
        d16.setClass(this.f393544a, this.f393553j);
        d16.putExtra("file_enter_file_browser_type", this.f393548e);
        this.f393554k.putInt("file_enter_file_browser_type", this.f393548e);
        this.f393554k.putInt("enter_file_browser_optype", this.f393555l);
        this.f393554k.putBoolean("qfile_param_no_view_preview", this.f393552i);
        Rect rect = this.f393549f;
        if (rect != null) {
            this.f393554k.putParcelable("file_browser_params_thumb_bound", rect);
        }
        this.f393545b.k(this.f393554k);
        d16.putExtra("file_browser_extra_params", this.f393554k);
        if (!TextUtils.isEmpty(this.f393550g)) {
            d16.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.f393550g);
        }
        if (cVar != null) {
            cVar.a(d16);
        }
        if (i3 != -1) {
            ((Activity) this.f393544a).startActivityForResult(d16, i3);
        } else {
            this.f393544a.startActivity(d16);
        }
        Context context = this.f393544a;
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    private boolean k() {
        if (!h()) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser isFromAIO return false, mEntranceType:" + this.f393548e);
            }
            return false;
        }
        ChatMessage c16 = this.f393545b.c();
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getChatMessage return falase");
            }
            return false;
        }
        if (r05.a.c()) {
            QLog.d("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser oldSwitchOpen return false!");
            return false;
        }
        SessionInfo e16 = this.f393545b.e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getSessionInfo return falase");
            }
            return false;
        }
        if (this.f393545b.j()) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser set video resume, return true");
            }
            return true;
        }
        if (!this.f393545b.a()) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser canUseNewVideoBrowser is false, don't start new video browser");
            }
            return false;
        }
        QFileUtils.w(this.f393544a, this.f393549f, c16, e16, this.f393545b.g(), this.f393545b.h(), this.f393545b.i(), null, this.f393545b.f());
        return true;
    }

    private void t() {
        b bVar = new b();
        FMDialogUtil.c(this.f393544a, this.f393544a.getString(R.string.b_v), this.f393544a.getString(R.string.b_x), bVar);
    }

    public void d() {
        e(-1, null);
    }

    public void e(int i3, c cVar) {
        if (this.f393546c && this.f393545b.b()) {
            if (QFileUtils.u(this.f393544a, false, new a(i3, cVar))) {
                t();
                return;
            }
            return;
        }
        j(i3, cVar);
    }

    public void f(c cVar) {
        e(-1, cVar);
    }

    public Bundle g() {
        return this.f393554k;
    }

    public void l(boolean z16) {
        this.f393546c = z16;
    }

    public void m(int i3) {
        this.f393548e = i3;
    }

    public void n(Class<?> cls) {
        this.f393553j = cls;
    }

    public void o(boolean z16) {
        this.f393547d = z16;
    }

    public void p(boolean z16) {
        this.f393552i = z16;
    }

    public void q(int i3) {
        this.f393555l = i3;
    }

    public void r(Rect rect) {
        this.f393549f = rect;
    }

    public void s(int i3) {
        this.f393551h = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            if (d.this.f393544a != null) {
                d.this.i();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
