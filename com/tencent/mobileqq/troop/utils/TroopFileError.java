package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileError {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference<d> f301868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f301875d;

        a(long j3) {
            this.f301875d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    TroopFileTransferManager.h0(this.f301875d);
                }
            } else {
                TroopFileTransferManager.W();
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        long a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301868a = new WeakReference<>(null);
        }
    }

    public static void a(QQAppInterface qQAppInterface, d dVar) {
        WeakReference<d> weakReference = f301868a;
        if (weakReference != null && weakReference.get() != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable(f301868a.get()) { // from class: com.tencent.mobileqq.troop.utils.TroopFileError.3
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ d f301874e;

                {
                    this.f301874e = r5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQAppInterface.this.removeObserver(this.f301874e);
                    }
                }
            });
            f301868a = null;
        }
        f301868a = new WeakReference<>(dVar);
        qQAppInterface.addObserver(dVar);
    }

    private static String b(QQAppInterface qQAppInterface, int i3, Object... objArr) {
        return String.format(c(qQAppInterface, i3), objArr);
    }

    private static String c(QQAppInterface qQAppInterface, int i3) {
        return qQAppInterface.getApplication().getResources().getString(i3);
    }

    private static void d(QQAppInterface qQAppInterface, Context context, String str, int i3) {
        if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).isAllRequestFinished()) {
            if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips()) {
                ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(qQAppInterface);
            } else {
                l(context, str, i3);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x004e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(b bVar, long j3, QQAppInterface qQAppInterface, Context context) {
        String c16;
        int i3;
        String str;
        int i16;
        if (bVar == null || context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(bVar.f301880e)) {
            l(context, bVar.f301880e, 1);
            return true;
        }
        String p16 = TroopFileUtils.p(bVar.f301878c);
        int i17 = bVar.f301877b;
        if (i17 != -139 && i17 != -138) {
            if (i17 != -136) {
                if (i17 != 1) {
                    switch (i17) {
                        case 101:
                            c16 = c(qQAppInterface, R.string.eto);
                            break;
                        default:
                            switch (i17) {
                                case 105:
                                    if (com.tencent.mobileqq.troop.data.a.b(bVar.f301879d)) {
                                        str = b(qQAppInterface, R.string.ewd, p16);
                                        break;
                                    } else {
                                        str = b(qQAppInterface, R.string.ekk, p16);
                                        break;
                                    }
                                case 106:
                                    c16 = c(qQAppInterface, R.string.ers);
                                    break;
                                case 107:
                                    m(context, j3);
                                    c16 = null;
                                    break;
                                default:
                                    switch (i17) {
                                        case 201:
                                            c16 = b(qQAppInterface, R.string.ewj, p16);
                                            break;
                                        case 202:
                                            c16 = c(qQAppInterface, R.string.euw);
                                            break;
                                        case 203:
                                            break;
                                        case 204:
                                            c16 = b(qQAppInterface, R.string.ewg, p16);
                                            break;
                                        case 205:
                                            c16 = b(qQAppInterface, R.string.ewf, p16);
                                            break;
                                        case 206:
                                            c16 = b(qQAppInterface, R.string.ewe, p16);
                                            break;
                                        case 207:
                                        case 209:
                                            str = c(qQAppInterface, R.string.evv);
                                            break;
                                        case 208:
                                            str = c(qQAppInterface, R.string.eto);
                                            break;
                                        case 210:
                                            String c17 = c(qQAppInterface, R.string.ewl);
                                            ReportController.o(qQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", Long.valueOf(j3)), "2", "", "");
                                            i3 = 1;
                                            str = c17;
                                            break;
                                        default:
                                            switch (i17) {
                                                case 301:
                                                    str = b(qQAppInterface, R.string.ekn, p16);
                                                    break;
                                                case 302:
                                                    str = b(qQAppInterface, R.string.eko, 302);
                                                    break;
                                                case 303:
                                                case 304:
                                                case 305:
                                                case 307:
                                                    break;
                                                case 306:
                                                    str = c(qQAppInterface, R.string.ekp);
                                                    break;
                                                case 308:
                                                    str = c(qQAppInterface, R.string.ekl);
                                                    break;
                                                case 309:
                                                    c16 = b(qQAppInterface, R.string.ekm, p16);
                                                    break;
                                                default:
                                                    switch (i17) {
                                                        case 401:
                                                            str = c(qQAppInterface, R.string.ek8);
                                                            break;
                                                        case 402:
                                                            c16 = c(qQAppInterface, R.string.ek7);
                                                            break;
                                                        case 403:
                                                            c16 = b(qQAppInterface, R.string.ek9, p16);
                                                            break;
                                                        default:
                                                            i3 = 2;
                                                            switch (i17) {
                                                                case 501:
                                                                    str = c(qQAppInterface, R.string.evz);
                                                                    break;
                                                                case 502:
                                                                    c16 = b(qQAppInterface, R.string.f171421ew0, p16);
                                                                    break;
                                                                case 503:
                                                                    c16 = b(qQAppInterface, R.string.f171423ew2, p16);
                                                                    break;
                                                                case 504:
                                                                    c16 = c(qQAppInterface, R.string.f171422ew1);
                                                                    break;
                                                                case 505:
                                                                    str = c(qQAppInterface, R.string.f171424ew3);
                                                                    break;
                                                                default:
                                                                    switch (i17) {
                                                                        case 600:
                                                                            c16 = c(qQAppInterface, R.string.f171387em2);
                                                                            break;
                                                                        case 601:
                                                                            c16 = c(qQAppInterface, R.string.f171388em3);
                                                                            break;
                                                                        case 602:
                                                                            com.tencent.mobileqq.filemanager.util.an.j();
                                                                            str = c(qQAppInterface, R.string.em6);
                                                                            break;
                                                                        case 603:
                                                                            str = c(qQAppInterface, R.string.em7);
                                                                            break;
                                                                        case 604:
                                                                            com.tencent.mobileqq.filemanager.util.an.j();
                                                                            str = c(qQAppInterface, R.string.em5);
                                                                            break;
                                                                        case 605:
                                                                            c16 = c(qQAppInterface, R.string.f171389em4);
                                                                            break;
                                                                        default:
                                                                            switch (i17) {
                                                                                case 701:
                                                                                    str = c(qQAppInterface, R.string.em8);
                                                                                    break;
                                                                                case 702:
                                                                                    c16 = c(qQAppInterface, R.string.em_);
                                                                                    break;
                                                                                case 703:
                                                                                    c16 = c(qQAppInterface, R.string.em9);
                                                                                    break;
                                                                                case 704:
                                                                                    c16 = bVar.f301880e;
                                                                                    break;
                                                                                case 705:
                                                                                    str = c(qQAppInterface, R.string.ema);
                                                                                    break;
                                                                                case 706:
                                                                                    if (!TextUtils.isEmpty(bVar.f301880e)) {
                                                                                        str = bVar.f301880e;
                                                                                        break;
                                                                                    } else {
                                                                                        str = c(qQAppInterface, R.string.emb);
                                                                                        break;
                                                                                    }
                                                                                default:
                                                                                    c16 = null;
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        case 102:
                        case 103:
                            str = c(qQAppInterface, R.string.evv);
                            break;
                    }
                    i16 = bVar.f301877b;
                    if (i16 == 601 && i16 != 605 && i16 != 802 && i16 != 604 && i16 != 702) {
                        return l(context, str, i3);
                    }
                    QLog.i(RichMediaBrowserConstants.TROOP_FILE_ERROR, 1, "call weiyun task: err = " + bVar.f301877b);
                    d(qQAppInterface, context, str, i3);
                    return true;
                }
                str = c(qQAppInterface, R.string.evv);
            } else {
                str = c(qQAppInterface, R.string.elo);
            }
            i3 = 1;
            i16 = bVar.f301877b;
            if (i16 == 601) {
            }
            QLog.i(RichMediaBrowserConstants.TROOP_FILE_ERROR, 1, "call weiyun task: err = " + bVar.f301877b);
            d(qQAppInterface, context, str, i3);
            return true;
        }
        c16 = c(qQAppInterface, R.string.elp);
        i3 = 0;
        str = c16;
        i16 = bVar.f301877b;
        if (i16 == 601) {
        }
        QLog.i(RichMediaBrowserConstants.TROOP_FILE_ERROR, 1, "call weiyun task: err = " + bVar.f301877b);
        d(qQAppInterface, context, str, i3);
        return true;
    }

    public static void f(QQAppInterface qQAppInterface, d dVar) {
        qQAppInterface.removeObserver(dVar);
        WeakReference<d> weakReference = f301868a;
        if (weakReference != null && weakReference.get() == dVar) {
            f301868a = null;
        }
    }

    public static void g(QQAppInterface qQAppInterface, b bVar) {
        TroopFileHandler troopFileHandler;
        if (qQAppInterface != null && bVar != null && bVar.f301877b != 0 && (troopFileHandler = (TroopFileHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)) != null) {
            troopFileHandler.I2(bVar);
        }
    }

    public static void h(QQAppInterface qQAppInterface, long j3, int i3) {
        i(qQAppInterface, j3, 7, i3);
    }

    public static void i(QQAppInterface qQAppInterface, long j3, int i3, int i16) {
        j(qQAppInterface, j3, null, i3, i16);
    }

    public static void j(QQAppInterface qQAppInterface, long j3, String str, int i3, int i16) {
        if (qQAppInterface != null && i16 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e(RichMediaBrowserConstants.TROOP_FILE_ERROR, 2, "reportSimpleError==> troopUin:" + j3 + ",filename:" + str + ",status:" + i3 + ",errorCode:" + i16);
            }
            TroopFileHandler troopFileHandler = (TroopFileHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
            if (troopFileHandler != null) {
                troopFileHandler.I2(new b(str, j3, i3, i16));
            }
        }
    }

    public static void k(Context context, String str) {
        l(context, str, 0);
    }

    public static boolean l(Context context, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            if (Looper.getMainLooper() != Looper.myLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(context, i3, str, dimensionPixelSize) { // from class: com.tencent.mobileqq.troop.utils.TroopFileError.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Context f301869d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f301870e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f301871f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f301872h;

                    {
                        this.f301869d = context;
                        this.f301870e = i3;
                        this.f301871f = str;
                        this.f301872h = dimensionPixelSize;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), str, Integer.valueOf(dimensionPixelSize));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            QQToast.makeText(this.f301869d, this.f301870e, this.f301871f, 0).show(this.f301872h);
                        }
                    }
                });
            } else {
                QQToast.makeText(context, i3, str, 0).show(dimensionPixelSize);
            }
            return true;
        } catch (Exception e16) {
            QLog.e(RichMediaBrowserConstants.TROOP_FILE_ERROR, 1, "showTipsToast error!", e16);
            return false;
        }
    }

    private static void m(Context context, long j3) {
        a aVar = new a(j3);
        DialogUtil.createCustomDialog(context, 230, context.getResources().getString(R.string.erq), context.getResources().getString(R.string.err), R.string.f171408et1, R.string.ejv, aVar, aVar).show();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f301876a;

        /* renamed from: b, reason: collision with root package name */
        public int f301877b;

        /* renamed from: c, reason: collision with root package name */
        public String f301878c;

        /* renamed from: d, reason: collision with root package name */
        public int f301879d;

        /* renamed from: e, reason: collision with root package name */
        public String f301880e;

        public b(String str, long j3, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f301878c = str;
            this.f301876a = j3;
            this.f301877b = i16;
            this.f301879d = i3;
        }

        public b(String str, long j3, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str2);
                return;
            }
            this.f301878c = str;
            this.f301876a = j3;
            this.f301877b = i16;
            this.f301879d = i3;
            this.f301880e = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d extends com.tencent.mobileqq.app.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Context> f301881d;

        /* renamed from: e, reason: collision with root package name */
        private long f301882e;

        /* renamed from: f, reason: collision with root package name */
        private QQAppInterface f301883f;

        /* renamed from: h, reason: collision with root package name */
        private c f301884h;

        /* renamed from: i, reason: collision with root package name */
        int f301885i;

        public d(Context context, long j3, QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), qQAppInterface);
                return;
            }
            this.f301885i = 0;
            this.f301881d = new WeakReference<>(context);
            this.f301882e = j3;
            this.f301883f = qQAppInterface;
            this.f301885i = 0;
        }

        @Override // com.tencent.mobileqq.app.c
        protected void e(Object obj) {
            c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                Context context = this.f301881d.get();
                long j3 = this.f301882e;
                if (j3 == 0 && (cVar = this.f301884h) != null) {
                    j3 = cVar.a();
                }
                if (context != null) {
                    TroopFileError.e(bVar, j3, this.f301883f, context);
                }
            }
        }

        public d(Context context, c cVar, QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, cVar, qQAppInterface);
                return;
            }
            this.f301885i = 0;
            this.f301881d = new WeakReference<>(context);
            this.f301884h = cVar;
            this.f301883f = qQAppInterface;
            this.f301885i = 0;
        }
    }
}
