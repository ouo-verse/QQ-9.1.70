package com.tencent.ams.mosaic.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.utils.PTSFileUtil;
import cooperation.photoplus.sticker.Sticker;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DebugUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final DebugUtils f71529b;

    /* renamed from: a, reason: collision with root package name */
    private String f71530a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59165);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f71529b = new DebugUtils();
        }
    }

    DebugUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71530a = "11.166.36.114";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return "http://" + this.f71530a + ":8088/";
    }

    public static DebugUtils d() {
        return f71529b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context) {
        Toast.makeText(context, "DebugTemplate\u6a21\u5f0f\uff0c\u8bf7\u4f20\u5165\u4e00\u4e2aActivity\u7c7b\u578b\u7684context", 0).show();
    }

    private String[] g(String str) {
        String W = MosaicUtils.W(c() + str, 2000);
        if (TextUtils.isEmpty(W)) {
            return null;
        }
        return W.split("\n");
    }

    private List<com.tencent.ams.mosaic.j> h(String str) {
        Object obj;
        String[] g16 = g(str);
        if (g16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : g16) {
            if (!TextUtils.isEmpty(str2)) {
                String substring = str2.substring(str2.lastIndexOf("/") + 1);
                if (str2.endsWith(PTSFileUtil.JS_FORMAT)) {
                    obj = MosaicUtils.W(c() + str2, 2000);
                    f.a("DebugUtils", "readCommonJs String fileName: " + substring);
                } else if (str2.endsWith(".lgtc")) {
                    obj = MosaicUtils.g(c() + str2, 2000);
                    f.a("DebugUtils", "readCommonJs bytes fileName: " + substring);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(new com.tencent.ams.mosaic.j(obj, substring));
                }
            }
        }
        return arrayList;
    }

    public List<com.tencent.ams.mosaic.j> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        f.e("DebugUtils", "readCommonJs begin");
        return h("vendor-js-android");
    }

    public void i(final Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        String d16 = com.tencent.ams.mosaic.f.k().d();
        if (TextUtils.isEmpty(d16)) {
            d16 = "template";
        }
        String[] g16 = g(d16);
        if (g16 == null) {
            return;
        }
        if (g16.length == 1) {
            String str = g16[0];
            if (!TextUtils.isEmpty(str) && str.endsWith(Sticker.JSON_SUFFIX)) {
                String W = MosaicUtils.W(c() + str, 2000);
                if (aVar != null) {
                    aVar.a(W);
                    return;
                }
                return;
            }
            return;
        }
        Activity m3 = MosaicUtils.m(context);
        if (m3 == null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    DebugUtils.e(context);
                }
            });
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(m3);
        ArrayList arrayList = new ArrayList();
        for (String str2 : g16) {
            arrayList.add(str2.replace("template/", ""));
        }
        builder.setTitle("\u9009\u62e9\u6a21\u7248").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(g16, aVar) { // from class: com.tencent.ams.mosaic.utils.DebugUtils.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String[] f71531d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f71532e;

            {
                this.f71531d = g16;
                this.f71532e = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DebugUtils.this, g16, aVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    MosaicUtils.F(new Runnable(i3) { // from class: com.tencent.ams.mosaic.utils.DebugUtils.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f71534d;

                        {
                            this.f71534d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str3 = AnonymousClass1.this.f71531d[this.f71534d];
                            if (!TextUtils.isEmpty(str3) && str3.endsWith(Sticker.JSON_SUFFIX)) {
                                String W2 = MosaicUtils.W(DebugUtils.this.c() + str3, 2000);
                                a aVar2 = AnonymousClass1.this.f71532e;
                                if (aVar2 != null) {
                                    aVar2.a(W2);
                                }
                            }
                        }
                    });
                }
            }
        });
        MosaicUtils.I(new Runnable(builder) { // from class: com.tencent.ams.mosaic.utils.DebugUtils.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertDialog.Builder f71536d;

            {
                this.f71536d = builder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DebugUtils.this, (Object) builder);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.f71536d.create().show();
                }
            }
        });
    }

    public List<com.tencent.ams.mosaic.j> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        f.e("DebugUtils", "readTemplateJsList begin");
        return h("index-js-android/" + com.tencent.ams.mosaic.f.k().c());
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f71530a = str;
        }
    }
}
