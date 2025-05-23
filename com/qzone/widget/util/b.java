package com.qzone.widget.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f61115a;

    /* renamed from: b, reason: collision with root package name */
    private static String f61116b;

    /* renamed from: c, reason: collision with root package name */
    private static String f61117c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean C;
        final /* synthetic */ e D;
        final /* synthetic */ boolean E;
        final /* synthetic */ h F;
        final /* synthetic */ String G;
        final /* synthetic */ String H;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f61118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f61119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f61120f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f61121h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f61122i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ f f61123m;

        a(String[] strArr, g gVar, d dVar, CellTextView.OnTextOperater onTextOperater, boolean z16, f fVar, boolean z17, e eVar, boolean z18, h hVar, String str, String str2) {
            this.f61118d = strArr;
            this.f61119e = gVar;
            this.f61120f = dVar;
            this.f61121h = onTextOperater;
            this.f61122i = z16;
            this.f61123m = fVar;
            this.C = z17;
            this.D = eVar;
            this.E = z18;
            this.F = hVar;
            this.G = str;
            this.H = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str = this.f61118d[i3];
            if ("+1".equals(str)) {
                g gVar = this.f61119e;
                if (gVar != null) {
                    gVar.a();
                    return;
                }
                return;
            }
            if (!l.a(R.string.lmj).equals(str)) {
                if (b.f61115a != null && b.f61115a.equals(str)) {
                    CellTextView.OnTextOperater onTextOperater = this.f61121h;
                    if (onTextOperater != null) {
                        onTextOperater.onCopy();
                        return;
                    }
                    return;
                }
                if (this.f61122i && b.f61117c != null && b.f61117c.equals(str)) {
                    f fVar = this.f61123m;
                    if (fVar != null) {
                        fVar.a();
                        return;
                    }
                    return;
                }
                if (this.C && b.f61116b != null && b.f61116b.equals(str)) {
                    e eVar = this.D;
                    if (eVar != null) {
                        eVar.a();
                        return;
                    }
                    return;
                }
                if (!this.E || this.F == null) {
                    return;
                }
                if (this.G.equals(str) || this.H.equals(str)) {
                    this.F.a();
                    return;
                }
                return;
            }
            d dVar = this.f61120f;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.widget.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public class DialogInterfaceOnCancelListenerC0505b implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f61124d;

        DialogInterfaceOnCancelListenerC0505b(CellTextView.OnTextOperater onTextOperater) {
            this.f61124d = onTextOperater;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f61124d.onCancle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class c extends ReportDialog {
        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        public void setTitle(String str) {
            ((TextView) findViewById(R.id.title)).setText(str);
        }

        @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
        public void show() {
            try {
                super.show();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }

        @Override // android.app.Dialog
        public void setTitle(int i3) {
            setTitle(i3 == 0 ? null : getContext().getResources().getString(i3));
        }

        c(Context context) {
            super(context, R.style.f174063on);
            setContentView(R.layout.f169003bk1);
            getWindow().setFlags(1024, 2048);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface f {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface g {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface h {
        void a();

        boolean b();
    }

    public static c d(Context context) {
        return new c(context);
    }

    private static void f(Context context, CellTextView.OnTextOperater onTextOperater, boolean z16, f fVar, boolean z17, e eVar, boolean z18, g gVar, d dVar, boolean z19, h hVar) {
        g(context, onTextOperater, z16, fVar, z17, eVar, z18, gVar, dVar, z19, hVar, Boolean.TRUE);
    }

    public static void h(Context context, CellTextView.OnTextOperater onTextOperater) {
        e(context, onTextOperater, false, null, false, null);
    }

    private static void g(Context context, CellTextView.OnTextOperater onTextOperater, boolean z16, f fVar, boolean z17, e eVar, boolean z18, g gVar, d dVar, boolean z19, h hVar, Boolean bool) {
        AlertDialog.Builder builder;
        if (onTextOperater == null || context == null) {
            return;
        }
        try {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                builder = new AlertDialog.Builder(context, R.style.f173588dd);
            } else {
                builder = new AlertDialog.Builder(context);
            }
            AlertDialog.Builder builder2 = builder;
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCopy", "\u590d\u5236");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogJubao", "\u4e3e\u62a5");
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogDelete", "\u5220\u9664");
            String config4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPraise", "\u70b9\u8d5e");
            String config5 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPraise", "\u53d6\u6d88\u8d5e");
            ArrayList arrayList = new ArrayList();
            if (f61115a == null) {
                f61115a = config;
            }
            if (bool.booleanValue()) {
                arrayList.add(f61115a);
            }
            if (z16) {
                if (f61117c == null) {
                    f61117c = config2;
                }
                arrayList.add(f61117c);
            }
            if (z17) {
                if (f61116b == null) {
                    f61116b = config3;
                }
                arrayList.add(f61116b);
            }
            if (z18) {
                arrayList.add("+1");
            }
            if (dVar != null) {
                arrayList.add(l.a(R.string.f171879lm3));
            }
            if (z19 && hVar != null) {
                if (hVar.b()) {
                    arrayList.add(config5);
                } else {
                    arrayList.add(config4);
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            builder2.setAdapter(new ArrayAdapter(context, R.layout.anx, R.id.dr5, strArr), new a(strArr, gVar, dVar, onTextOperater, z16, fVar, z17, eVar, z19, hVar, config4, config5));
            builder2.setOnCancelListener(new DialogInterfaceOnCancelListenerC0505b(onTextOperater));
            AlertDialog create = builder2.create();
            create.setCanceledOnTouchOutside(true);
            try {
                create.show();
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.e("DialogUtils", e16.toString());
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            QZLog.e("DialogUtils.showAlert", e17.toString());
        }
    }

    private static void e(Context context, CellTextView.OnTextOperater onTextOperater, boolean z16, f fVar, boolean z17, e eVar) {
        f(context, onTextOperater, z16, fVar, z17, eVar, false, null, null, false, null);
    }

    public static void l(Context context, CellTextView.OnTextOperater onTextOperater, f fVar, g gVar, d dVar) {
        f(context, onTextOperater, true, fVar, false, null, gVar != null, gVar, dVar, false, null);
    }

    public static void m(Context context, CellTextView.OnTextOperater onTextOperater, f fVar, e eVar, g gVar, d dVar) {
        f(context, onTextOperater, true, fVar, true, eVar, gVar != null, gVar, dVar, false, null);
    }

    public static void i(Context context, CellTextView.OnTextOperater onTextOperater, g gVar, d dVar, h hVar) {
        f(context, onTextOperater, false, null, false, null, gVar != null, gVar, dVar, hVar != null, hVar);
    }

    public static void k(Context context, CellTextView.OnTextOperater onTextOperater, e eVar, g gVar, d dVar, h hVar) {
        f(context, onTextOperater, false, null, true, eVar, gVar != null, gVar, dVar, hVar != null, hVar);
    }

    public static void j(Context context, CellTextView.OnTextOperater onTextOperater, g gVar, d dVar, h hVar, Boolean bool) {
        g(context, onTextOperater, false, null, false, null, gVar != null, gVar, dVar, hVar != null, hVar, bool);
    }
}
