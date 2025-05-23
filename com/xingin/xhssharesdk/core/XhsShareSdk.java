package com.xingin.xhssharesdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.i.c;
import com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import cooperation.qzone.remote.ServiceConst;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import oz4.g;
import oz4.h;
import oz4.j;
import oz4.k;
import oz4.m;
import oz4.q;
import oz4.s;
import oz4.w;
import pz4.b;
import xz4.a;
import xz4.k;
import xz4.l;

/* compiled from: P */
/* loaded from: classes28.dex */
public class XhsShareSdk {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f389977a;

    /* renamed from: b, reason: collision with root package name */
    public static String f389978b;

    public static void a(XhsShareCallback xhsShareCallback, a aVar, int i3, String str) {
        if (xhsShareCallback != null) {
            xhsShareCallback.onError2(aVar.f449175a, i3, XhsShareConstants$XhsShareNoteErrorCode.REPEAT_SHARE, str, null);
        }
    }

    public static void b(String str, String str2) {
        if (f389977a != null) {
            f389977a.f389992n.d(str, str2);
        }
    }

    public static void c(String str, String str2, @Nullable Throwable th5) {
        if (f389977a != null) {
            f389977a.f389992n.e(str, str2, th5);
        }
    }

    public static void d(String str, String str2, @Nullable Throwable th5) {
        if (f389977a != null) {
            f389977a.f389992n.w(str, str2, th5);
        }
    }

    @Keep
    private static String getCachePath() {
        if (f389977a != null) {
            c cVar = f389977a;
            if (TextUtils.isEmpty(cVar.f389981c.getCacheDirPath())) {
                return XhsShareSdkTools.getDefaultCacheDirPath(cVar.f389979a);
            }
            return cVar.f389981c.getCacheDirPath();
        }
        return "";
    }

    @Keep
    public static void openUrlInXhs(Context context, String str) {
        Uri uri;
        String str2;
        try {
            uri = Uri.parse(str);
        } catch (Throwable th5) {
            c("XhsShare_Sdk", "Parse url error", th5);
            uri = null;
        }
        if (uri == null) {
            return;
        }
        if (XhsShareSdkTools.isXhsInstalled(context)) {
            String scheme = uri.getScheme();
            if (!TextUtils.equals("http", scheme) && !TextUtils.equals("https", scheme)) {
                c("XhsShare_Sdk", "Scheme must be http pr https url!", null);
                return;
            }
            try {
                Uri parse = Uri.parse(str.replace("https://", "xhsdiscover://webview/"));
                Intent intent = new Intent();
                intent.setData(parse);
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                    return;
                }
                throw new Exception("resolveActivity get null!");
            } catch (Throwable th6) {
                th = th6;
                str2 = "Open url in Xhs error!";
            }
        } else {
            try {
                context.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("https://www.xiaohongshu.com/activity/sem/walle?groupid=64a3b9a0656df000019fdfd3&template=A050001&nocache=nocache&source=openplatform_default")));
                return;
            } catch (Throwable th7) {
                th = th7;
                str2 = "Open download url error!";
            }
        }
        c("XhsShare_Sdk", str2, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void registerApp(Context context, String str, XhsShareGlobalConfig xhsShareGlobalConfig, XhsShareRegisterCallback xhsShareRegisterCallback) {
        int i3;
        g h16;
        if (f389977a != null) {
            d("XhsShare_Sdk", "The XhsShare has registered, can not register again!!", null);
        }
        b("XhsShare_Sdk", "Start register!");
        Context applicationContext = context.getApplicationContext();
        f389977a = new c(applicationContext, str, xhsShareGlobalConfig);
        c cVar = f389977a;
        cVar.f389983e = xhsShareRegisterCallback;
        if (TextUtils.isEmpty(cVar.f389980b)) {
            cVar.f389992n.e("XhsShare_Sdk", "Token can not be Empty!", null);
            XhsShareRegisterCallback xhsShareRegisterCallback2 = cVar.f389983e;
            if (xhsShareRegisterCallback2 != null) {
                xhsShareRegisterCallback2.onError(0, "Token can not be Empty!", null);
            }
        } else {
            c05.c.f30217a = cVar.f389992n;
            XhsShareRegisterCallback xhsShareRegisterCallback3 = cVar.f389983e;
            if (xhsShareRegisterCallback3 != null) {
                xhsShareRegisterCallback3.onSuccess();
            }
        }
        q.f424803a = new k();
        String str2 = "";
        try {
            i3 = XhsShareSdkTools.getCurrentAppVersionCode(applicationContext);
            try {
                str2 = XhsShareSdkTools.getCurrentAppVersionName(applicationContext);
            } catch (PackageManager.NameNotFoundException e16) {
                e = e16;
                d("XhsShare_Sdk", "GetVersion error", e);
                h16 = g.h();
                String model = DeviceInfoMonitor.getModel();
                String did = XhsShareSdkTools.getDid(applicationContext);
                int i16 = Build.VERSION.SDK_INT;
                String str3 = Build.VERSION.RELEASE;
                l lVar = new l();
                synchronized (h16) {
                }
            }
        } catch (PackageManager.NameNotFoundException e17) {
            e = e17;
            i3 = -1;
        }
        h16 = g.h();
        String model2 = DeviceInfoMonitor.getModel();
        String did2 = XhsShareSdkTools.getDid(applicationContext);
        int i162 = Build.VERSION.SDK_INT;
        String str32 = Build.VERSION.RELEASE;
        l lVar2 = new l();
        synchronized (h16) {
            if (h16.f424748a.compareAndSet(false, true)) {
                b.f428097a = 1663676756;
                h hVar = new h();
                hVar.f424756a = did2;
                hVar.f424758c = i162;
                hVar.f424757b = str32;
                hVar.f424759d = model2;
                hVar.f424763h = lVar2;
                hVar.f424762g = i3;
                hVar.f424760e = 26;
                hVar.f424761f = str2;
                h.f424755i = hVar;
                q.a("init() TrackerConfig=%s", hVar);
                m mVar = m.f424787m;
                mVar.f424788d = hVar.f424756a;
                mVar.f424789e = hVar.f424757b;
                mVar.f424790f = hVar.f424758c;
                mVar.f424791h = null;
                mVar.f424792i = hVar.f424759d;
                j jVar = j.f424770i;
                jVar.f424772e = hVar.f424760e;
                jVar.f424773f = hVar.f424761f;
                jVar.f424774h = hVar.f424762g;
                h16.f424752e = new s(applicationContext, h16.f424751d);
                h16.f424753f = new w(h16.f424751d, h16.f424752e);
                h16.c();
            } else {
                q.a(" %s tracker lite has been initialized", h16.f424751d.f389974a);
            }
        }
    }

    @Keep
    public static void setShareCallback(@Nullable XhsShareCallback xhsShareCallback) {
        if (f389977a != null) {
            f389977a.f389984f = xhsShareCallback;
        } else {
            c("XhsShare_Sdk", "setShareCallback invoke can not before registerApp invoke!", null);
        }
    }

    @NonNull
    @Keep
    public static String shareNote(Context context, XhsNote xhsNote) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str = "";
        if (f389977a == null) {
            c("XhsShare_Sdk", "shareNote invoke can not before registerApp invoke!", null);
            return "";
        }
        final a aVar = new a(xhsNote);
        try {
            str = xhsNote.toJsonForDeeplink().toString();
        } catch (JSONException e16) {
            d("XhsShare_Sdk", "note.toJsonForDeeplink() error!", e16);
        }
        String str2 = aVar.f449175a;
        String noteType = xhsNote.getNoteType();
        g h16 = g.h();
        k.a a16 = d05.a.a(context);
        a16.f424785c = 3;
        a16.f424784b = 30756;
        a16.f424786d.put(ServiceConst.PARA_SESSION_ID, str2);
        a16.f424786d.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "NOTE");
        a16.f424786d.put("note_type", noteType);
        a16.f424786d.put("note_data_json", str);
        h16.d(a16);
        c cVar = f389977a;
        a aVar2 = cVar.f389987i;
        boolean z26 = false;
        if (aVar2 == null) {
            z16 = false;
        } else {
            z16 = aVar2.f449177c;
        }
        if (z16) {
            z18 = false;
        } else {
            cVar.f389987i = aVar;
            aVar.f449177c = true;
            d05.b bVar = aVar.f449176b;
            String str3 = aVar.f449175a;
            if (!TextUtils.isEmpty(bVar.f392637a) && TextUtils.equals(str3, bVar.f392637a)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (bVar.f392638b != 0) {
                    d("ShareTimelineTracker", "startShareTimestamp has be assigned!", null);
                } else {
                    bVar.f392638b = System.currentTimeMillis();
                }
            }
            z18 = true;
        }
        if (!z18) {
            d("XhsShare_Sdk", "Last share flow has not end!, isNeedRegisterReceiverWithOutsideActivity = " + f389977a.f389981c.isNeedRegisterReceiverWithOutsideActivity(), null);
            if (f389977a.f389981c.isNeedRegisterReceiverWithOutsideActivity()) {
                f389977a.g(f389977a.c(), XhsShareConstants$XhsShareNoteNewErrorCode.SHARE_NOT_GET_RESULT_FROM_XHS, -10000001, "Replace by new share.", null, false);
                c cVar2 = f389977a;
                a aVar3 = cVar2.f389987i;
                if (aVar3 == null) {
                    z19 = false;
                } else {
                    z19 = aVar3.f449177c;
                }
                if (!z19) {
                    cVar2.f389987i = aVar;
                    aVar.f449177c = true;
                    d05.b bVar2 = aVar.f449176b;
                    String str4 = aVar.f449175a;
                    if (!TextUtils.isEmpty(bVar2.f392637a) && TextUtils.equals(str4, bVar2.f392637a)) {
                        z26 = true;
                    }
                    if (z26) {
                        if (bVar2.f392638b != 0) {
                            d("ShareTimelineTracker", "startShareTimestamp has be assigned!", null);
                        } else {
                            bVar2.f392638b = System.currentTimeMillis();
                        }
                    }
                    z26 = true;
                }
                b("XhsShare_Sdk", "setupShareContext Result is " + z26);
            } else {
                final String str5 = "Last share not over yet!!";
                d("XhsShare_Sdk", "Last share not over yet!!", null);
                d05.a.b(context, aVar.f449175a, false, XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE, "Last share not over yet!!", 0L);
                final XhsShareCallback xhsShareCallback = f389977a.f389984f;
                final int i3 = XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE;
                com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: rz4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        XhsShareSdk.a(XhsShareCallback.this, aVar, i3, str5);
                    }
                });
                return aVar.f449175a;
            }
        }
        b("XhsShare_Sdk", "Start Share, sessionId is " + aVar.f449175a);
        Intent intent = new Intent(context, (Class<?>) XhsShareActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("XHS_SHARE_NOTE_KEY", xhsNote);
        intent.putExtra("XHS_SHARE_SESSION_ID", aVar.f449175a);
        intent.putExtra("XHS_SHARE_START_TIMESTAMP", aVar.f449176b.f392638b);
        intent.putExtra("XHS_SHARE_FLAG", "SHARE");
        try {
            context.startActivity(intent);
            c cVar3 = f389977a;
            if (cVar3.f389981c.isNeedRegisterReceiverWithOutsideActivity() && (context instanceof Activity)) {
                cVar3.f389992n.d("XhsShare_Sdk", "setup OutsideActivity!");
                cVar3.f389991m = new WeakReference<>((Activity) context);
            }
        } catch (Throwable th5) {
            XhsShareCallback xhsShareCallback2 = f389977a.f389984f;
            if (xhsShareCallback2 != null) {
                xhsShareCallback2.onError2(aVar.f449175a, XhsShareConstants$XhsShareNoteNewErrorCode.OPEN_XHS_SHARE_ACTIVITY_ERROR, XhsShareConstants$XhsShareNoteErrorCode.START_ACTIVITY_ERROR, "startActivity error", th5);
            }
            f389977a.f389992n.e("XhsShare_Sdk", "startActivity error", th5);
        }
        return aVar.f449175a;
    }
}
