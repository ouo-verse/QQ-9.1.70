package bw2;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.data.AdDialogData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.QAdMiniProgramActionUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import java.util.HashMap;
import pw2.i;
import pw2.n;
import pw2.u;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b {

    /* renamed from: g, reason: collision with root package name */
    protected final String f29329g;

    /* renamed from: h, reason: collision with root package name */
    protected Dialog f29330h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoReportInfo f29331a;

        a(VideoReportInfo videoReportInfo) {
            this.f29331a = videoReportInfo;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void a(boolean z16, int i3) {
            n.e(h.this.f29329g, "onOpenResult, isSuccess:" + z16 + ", errorCode:" + i3);
            h.this.M(z16, this.f29331a);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void b() {
            n.a(h.this.f29329g, "doOpenMiniProgramItemWithDialog, onWillLaunch");
            h.this.g(10001);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onCancel() {
            h hVar = h.this;
            hVar.g(hVar.F());
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onConfirm() {
            h hVar = h.this;
            hVar.g(hVar.G());
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onShow() {
            n.a(h.this.f29329g, "open mini program with dialog show.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoReportInfo f29333a;

        b(VideoReportInfo videoReportInfo) {
            this.f29333a = videoReportInfo;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void a(boolean z16, int i3) {
            n.e(h.this.f29329g, "onLaunchResult: " + z16);
            h.this.M(z16, this.f29333a);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void b() {
            h.this.g(10001);
            n.a(h.this.f29329g, "doOpenMiniProgramItem, onWillLaunch");
        }
    }

    public h(Context context, wv2.a aVar) {
        super(context, aVar);
        this.f29329g = L() + hashCode();
    }

    private void B(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        String q16 = dVar.q();
        n.e(this.f29329g, "doClickCgiRequest clickUrl:" + q16);
        String f16 = u.f(q16);
        HashMap<String, String> g16 = u.g(q16);
        if (g16 != null && g16.size() != 0) {
            g16.put("rt", "1");
        }
        String j3 = u.j(f16, g16);
        if (TextUtils.isEmpty(j3)) {
            n.e(this.f29329g, "doClickCgiRequest fail: null urlReqDstLink");
        } else {
            i.p(j3, null, null);
            a(dVar);
        }
    }

    private void D(@Nullable AdOpenMiniProgramItem adOpenMiniProgramItem, VideoReportInfo videoReportInfo) {
        if (adOpenMiniProgramItem == null) {
            return;
        }
        n.a(this.f29329g, "doOpenMiniProgramItemWithDialog : name = " + adOpenMiniProgramItem.appName + " , url = " + adOpenMiniProgramItem.urlItem + " , token = " + adOpenMiniProgramItem.token + " , trace = " + adOpenMiniProgramItem.adTraceData);
        try {
            Dialog x16 = x(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.a.a(adOpenMiniProgramItem, "MiniProgram"), y(videoReportInfo));
            this.f29330h = x16;
            if (x16 != null) {
                g(K());
            }
        } catch (Throwable th5) {
            n.b(this.f29329g, th5.toString());
        }
    }

    private static Context E(Context context) {
        if (!(context instanceof Activity)) {
            return ev2.a.a();
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z16, VideoReportInfo videoReportInfo) {
        if (z16) {
            g(J());
        } else {
            g(H());
            QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: bw2.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.R();
                }
            });
        }
    }

    private boolean O() {
        if (I() != null && I().disableDialog) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String str) {
        Toast.makeText(this.f303964b, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d dVar, VideoReportInfo videoReportInfo) {
        OpenSdkManager.INSTANCE.launchMiniProgram(dVar, z(videoReportInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        Toast.makeText(this.f303964b, "\u8bf7\u66f4\u65b0\u5fae\u4fe1App\u540e\u4f53\u9a8c", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d dVar, DialogInterface dialogInterface, int i3) {
        if (eVar == null) {
            return;
        }
        eVar.onConfirm();
        OpenSdkManager.INSTANCE.launchMiniProgram(dVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar, DialogInterface dialogInterface, int i3) {
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar, DialogInterface dialogInterface) {
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar, DialogInterface dialogInterface) {
        if (eVar != null) {
            eVar.onShow();
        }
    }

    public static Dialog W(Context context, final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d dVar, final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar) {
        String str;
        Dialog dialog = null;
        if (context != null && dVar != null) {
            n.a("QAdMiniProgramActionHandler", "openMiniProgramWithDialog");
            hv2.f fVar = (hv2.f) dv2.b.d().a(hv2.f.class);
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: bw2.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    h.S(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e.this, dVar, dialogInterface, i3);
                }
            };
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: bw2.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    h.T(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e.this, dialogInterface, i3);
                }
            };
            DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: bw2.d
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    h.U(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e.this, dialogInterface);
                }
            };
            DialogInterface.OnShowListener onShowListener = new DialogInterface.OnShowListener() { // from class: bw2.e
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    h.V(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e.this, dialogInterface);
                }
            };
            Context E = E(context);
            String str2 = "\u5373\u5c06\u79bb\u5f00QQ\n\u6253\u5f00\"\u5fae\u4fe1\u5c0f\u7a0b\u5e8f\"";
            if ((E instanceof Activity) && fVar != null) {
                AdDialogData.Builder builder = new AdDialogData.Builder();
                if ("MiniProgram".equals(dVar.a())) {
                    str = "\u5373\u5c06\u79bb\u5f00QQ\n\u6253\u5f00\"\u5fae\u4fe1\u5c0f\u7a0b\u5e8f\"";
                } else {
                    str = "\u5373\u5c06\u79bb\u5f00QQ\n\u8fdb\u5165\"\u5fae\u4fe1\u5c0f\u6e38\u620f\"";
                }
                dialog = fVar.d((Activity) E, builder.setMessage(str).setPositiveText("\u5141\u8bb8").setPositiveListener(onClickListener).setNegativeText("\u53d6\u6d88").setNegativeListener(onClickListener2).setCancelListener(onCancelListener).setOnShowListener(onShowListener).build());
            }
            if (dialog == null) {
                try {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(E);
                    if (!"MiniProgram".equals(dVar.a())) {
                        str2 = "\u5373\u5c06\u79bb\u5f00QQ\n\u8fdb\u5165\"\u5fae\u4fe1\u5c0f\u6e38\u620f\"";
                    }
                    dialog = builder2.setMessage(str2).setPositiveButton("\u5141\u8bb8", onClickListener).setNegativeButton("\u53d6\u6d88", onClickListener2).setOnCancelListener(onCancelListener).create();
                    dialog.setOnShowListener(onShowListener);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    TextView textView = (TextView) dialog.findViewById(R.id.message);
                    if (textView != null) {
                        textView.setGravity(17);
                    }
                } catch (Throwable th5) {
                    n.b("QAdMiniProgramActionHandler", "openMiniProgramWithDialog, create dialog error." + th5.getMessage());
                }
            }
        }
        return dialog;
    }

    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e y(@NonNull VideoReportInfo videoReportInfo) {
        return new a(videoReportInfo);
    }

    public void A(boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g gVar) {
        final String str;
        if (!N(dVar)) {
            n.e(this.f29329g, "doClick, action item invalid");
            return;
        }
        n.e(this.f29329g, "doClick, directPing:" + z16 + ", parseType:" + this.f303963a.f446565a.parseType);
        if (this.f303963a.f446565a.parseType == 1) {
            z16 = true;
        }
        if (z16) {
            B(dVar);
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.i(dVar.f304048a, dVar.b(), gVar);
        }
        int c16 = QAdMiniProgramActionUtils.c(I(), dVar);
        if (c16 == 0) {
            if (!z16) {
                b(dVar, gVar);
            }
            if (O()) {
                C(I(), null);
                return;
            } else {
                D(I(), null);
                return;
            }
        }
        g(H());
        if (c16 == 3) {
            return;
        }
        boolean isWXInstalled = OpenSdkManager.INSTANCE.isWXInstalled();
        n.h(this.f29329g, "MINI_PROGRAM_OPEN_FAIL isWeixinInstalled:" + isWXInstalled);
        if (z16) {
            if (isWXInstalled) {
                str = "\u8bf7\u66f4\u65b0\u5fae\u4fe1App\u540e\u4f53\u9a8c";
            } else {
                str = "\u8bf7\u5b89\u88c5\u5fae\u4fe1App\u540e\u4f53\u9a8c";
            }
            QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: bw2.a
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.P(str);
                }
            });
            return;
        }
        e(dVar, gVar);
    }

    protected void C(AdOpenMiniProgramItem adOpenMiniProgramItem, final VideoReportInfo videoReportInfo) {
        final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d a16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.a.a(adOpenMiniProgramItem, "MiniProgram");
        QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: bw2.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Q(a16, videoReportInfo);
            }
        });
    }

    protected int F() {
        return 2;
    }

    protected int G() {
        return 20;
    }

    protected int H() {
        return 1;
    }

    @Nullable
    protected AdOpenMiniProgramItem I() {
        AdActionItem adActionItem;
        AdOpenMiniProgramItem adOpenMiniProgramItem;
        wv2.a aVar = this.f303963a;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenMiniProgramItem = adActionItem.adOpenMiniProgram) != null) {
            return adOpenMiniProgramItem;
        }
        n.h(this.f29329g, "getOpenMiniItem: is null");
        return null;
    }

    protected int J() {
        return 3;
    }

    protected int K() {
        return 4;
    }

    @NonNull
    protected String L() {
        return "QADMiniProgramActionHandler";
    }

    protected boolean N(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        wv2.a aVar;
        if (dVar != null && (aVar = this.f303963a) != null && aVar.f446565a != null) {
            return true;
        }
        n.b(this.f29329g, "doClick with no actionItem");
        return false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g gVar) {
        n.e(this.f29329g, "doClick");
        A(false, dVar, gVar);
    }

    protected Dialog x(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.d dVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e eVar) {
        return W(this.f303964b, dVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c z(VideoReportInfo videoReportInfo) {
        return new b(videoReportInfo);
    }
}
