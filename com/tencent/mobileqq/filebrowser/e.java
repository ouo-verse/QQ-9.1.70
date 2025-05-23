package com.tencent.mobileqq.filebrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void b();

        void d();

        void m();

        void n();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void A();

        void onFinished();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void h(int i3, String str, String str2, Bundle bundle);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.e$e, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC7518e {
        void k(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void a(float f16);

        void e();

        void f();

        void j();

        void l();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void c(long j3);

        void g(List<h> list, String str, String str2, String str3, String str4, boolean z16, String str5, short s16);

        void i(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f205934a;

        /* renamed from: b, reason: collision with root package name */
        public long f205935b;

        /* renamed from: c, reason: collision with root package name */
        public String f205936c;

        /* renamed from: d, reason: collision with root package name */
        public long f205937d;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    String A();

    MsgRecordParams B();

    void C(g gVar);

    String D();

    boolean E();

    float F();

    void G(int i3);

    String H(Context context);

    FileManagerEntity I();

    boolean J();

    TeamWorkFileImportInfo K();

    String L();

    int M();

    void N(a aVar);

    int O();

    void P(f fVar);

    String Q();

    boolean R();

    void S(Bundle bundle);

    void T();

    ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] U();

    boolean V();

    void W(Context context);

    void X(c cVar);

    void Y(InterfaceC7518e interfaceC7518e);

    boolean Z();

    void a();

    void a0(Context context, String str);

    void b();

    String b0();

    void c();

    void c0(Context context);

    void d(FileManagerEntity fileManagerEntity);

    com.tencent.mobileqq.filebrowser.c d0();

    void doOnDestroy();

    void doOnPause();

    void doOnResume();

    void e();

    boolean e0();

    void f();

    boolean f0(Context context, b bVar);

    String g();

    boolean g0();

    String getCurrentAccountUin();

    boolean h();

    void h0(JSONObject jSONObject, String str, TeamWorkFileImportInfo teamWorkFileImportInfo, Activity activity) throws JSONException;

    int i();

    void j(Activity activity, String str);

    void k();

    void l(d dVar);

    String m();

    int n();

    boolean o();

    String p();

    void q(Activity activity, int i3, String str);

    void r(f fVar);

    BaseAdapter s();

    void setActivity(Activity activity);

    Intent t();

    void u(a aVar);

    void v(JSONObject jSONObject, String str, Context context) throws JSONException;

    void w(ShareActionSheetBuilder.ActionSheetItem actionSheetItem);

    long[] x();

    int y();

    com.tencent.mobileqq.colornote.f z();
}
