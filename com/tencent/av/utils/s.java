package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.about.AboutFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import cooperation.groupvideo.api.IGroupVideoHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: f, reason: collision with root package name */
    private static s f77162f = new s();

    /* renamed from: c, reason: collision with root package name */
    private long f77165c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, f> f77163a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f77164b = -1;

    /* renamed from: d, reason: collision with root package name */
    private LongSparseArray<d> f77166d = new LongSparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.app.av f77167e = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends com.tencent.mobileqq.app.av {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x009a  */
        @Override // com.tencent.mobileqq.app.av
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void b(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18, int i19, long j3) {
            String str5;
            int i26;
            d dVar = (d) s.this.f77166d.get(j3);
            if (!z16) {
                str5 = "GroupVideoManager.GVideoGrayConfig";
                d dVar2 = (d) s.this.f77166d.get(j3);
                if (dVar2 != null) {
                    dVar2.a(-1, null, i19);
                    s.this.f77166d.delete(j3);
                } else if (QLog.isColorLevel()) {
                    i26 = 2;
                    QLog.e(str5, 2, "mGVideoGrayConfigListener is null");
                    s sVar = s.this;
                    sVar.f77164b = i18;
                    s.b(sVar);
                    if (QLog.isColorLevel()) {
                        QLog.e(str5, i26, "mGVideoPreDownloadListener is null");
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.e(str5, 2, "onGetTroopHideWebConfig record gVideoStrategy:" + i17 + " isSucc:" + z16);
                        return;
                    }
                    return;
                }
            } else {
                s.this.f77165c = SystemClock.elapsedRealtime();
                str5 = "GroupVideoManager.GVideoGrayConfig";
                f fVar = new f(SystemClock.elapsedRealtime(), i17, str2, str3, str4);
                s.this.f77163a.put(str, fVar);
                if (dVar != null) {
                    dVar.a(i17, fVar, i19);
                    s.this.f77166d.delete(j3);
                } else if (QLog.isColorLevel()) {
                    QLog.e(str5, 2, "mGVideoGrayConfigListener is null");
                }
            }
            i26 = 2;
            s sVar2 = s.this;
            sVar2.f77164b = i18;
            s.b(sVar2);
            if (QLog.isColorLevel()) {
            }
            if (!QLog.isColorLevel()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f77169d;

        b(Context context) {
            this.f77169d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            s.i(this.f77169d);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f77170a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f77171b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f77172c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f77173d;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                com.tencent.mobileqq.intervideo.groupvideo.h hVar = (com.tencent.mobileqq.intervideo.groupvideo.h) c.this.f77170a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
                c cVar = c.this;
                hVar.b(cVar.f77171b, cVar.f77170a.getCurrentAccountUin(), c.this.f77173d, "4", "openRoom");
            }
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                c cVar = c.this;
                cVar.c(cVar.f77171b);
            }
        }

        c(QQAppInterface qQAppInterface, Context context, Intent intent, String str) {
            this.f77170a = qQAppInterface;
            this.f77171b = context;
            this.f77172c = intent;
            this.f77173d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Context context) {
            if (context instanceof JumpActivity) {
                ((Activity) context).finish();
            }
        }

        @Override // com.tencent.av.utils.s.d
        public void a(int i3, f fVar, int i16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                c(this.f77171b);
                                return;
                            }
                            Context context = this.f77171b;
                            if (context instanceof Activity) {
                                s.k(context, fVar.f77179d, fVar.f77180e, new b());
                                return;
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
                                    return;
                                }
                                return;
                            }
                        }
                        Context context2 = this.f77171b;
                        if (context2 instanceof Activity) {
                            s.k(context2, fVar.f77179d, fVar.f77180e, new a());
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
                                return;
                            }
                            return;
                        }
                    }
                    ((com.tencent.mobileqq.intervideo.groupvideo.h) this.f77170a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).b(this.f77171b, this.f77170a.getCurrentAccountUin(), this.f77173d, "4", "openRoom");
                    return;
                }
                Intent intent = new Intent(this.f77171b, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", fVar.f77178c);
                if (!(this.f77171b instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                this.f77171b.startActivity(intent);
                c(this.f77171b);
                return;
            }
            ((IGroupVideoHelper) QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(this.f77170a, this.f77171b, this.f77172c, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void a(int i3, f fVar, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public long f77176a;

        /* renamed from: b, reason: collision with root package name */
        public int f77177b;

        /* renamed from: c, reason: collision with root package name */
        public String f77178c;

        /* renamed from: d, reason: collision with root package name */
        public String f77179d;

        /* renamed from: e, reason: collision with root package name */
        public String f77180e;

        public f(long j3, int i3, String str, String str2, String str3) {
            this.f77176a = j3;
            this.f77177b = i3;
            this.f77178c = str;
            this.f77179d = str2;
            this.f77180e = str3;
        }
    }

    s() {
    }

    static /* bridge */ /* synthetic */ e b(s sVar) {
        sVar.getClass();
        return null;
    }

    public static s g() {
        return f77162f;
    }

    public static void h(QQAppInterface qQAppInterface, Context context, Intent intent, int i3) {
        String stringExtra = intent.getStringExtra("GroupId");
        g().j(qQAppInterface, stringExtra, new c(qQAppInterface, context, intent, stringExtra));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Context context) {
        Intent intent = new Intent();
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        } else {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, AboutFragment.class);
    }

    public static void k(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        DialogUtil.createCustomDialog(context, 230, str, str2, R.string.ddq, R.string.dds, new b(context), onClickListener).show();
    }

    public void f() {
        this.f77166d.clear();
    }

    public void j(AppInterface appInterface, String str, d dVar) {
        f fVar = this.f77163a.get(str);
        if (fVar != null && SystemClock.elapsedRealtime() - fVar.f77176a < 60000) {
            dVar.a(fVar.f77177b, fVar, 1000);
            return;
        }
        GVideoHandler gVideoHandler = (GVideoHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
        if (gVideoHandler != null) {
            appInterface.addObserver(this.f77167e);
            this.f77166d.put(gVideoHandler.Q2(az.d(appInterface, appInterface.getCurrentAccountUin(), str), Long.parseLong(str)), dVar);
        } else {
            dVar.a(-1, null, -1);
            if (QLog.isColorLevel()) {
                QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
            }
        }
    }
}
