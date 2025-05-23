package com.tencent.mobileqq.troopmanage.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManageRemoteHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AppInterface f303017a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f303018b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f303019c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f303020d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Bitmap> f303021e;

    /* renamed from: f, reason: collision with root package name */
    private final List<b> f303022f;

    /* renamed from: g, reason: collision with root package name */
    private final cooperation.troop.a f303023g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f303024h;

    /* renamed from: i, reason: collision with root package name */
    private final BroadcastReceiver f303025i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRemoteHandler.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && "com.tencent.qqhead.getheadresp".equals(intent.getAction())) {
                ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
                ArrayList<String> stringArrayList2 = intent.getExtras().getStringArrayList("headPathList");
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                if (stringArrayList != null && stringArrayList2 != null) {
                    for (int i16 = 0; i16 < stringArrayList.size(); i16++) {
                        String str = stringArrayList.get(i16);
                        String str2 = stringArrayList2.get(i16);
                        if (str2 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopManageRemoteHandler", 2, "com.tencent.qqhead.getheadresp: " + str2);
                            }
                            TroopManageRemoteHandler.this.f303020d.put(str, str2);
                            arrayList.add(str);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    while (i3 < TroopManageRemoteHandler.this.f303022f.size()) {
                        b bVar = (b) TroopManageRemoteHandler.this.f303022f.get(i3);
                        if (bVar != null) {
                            if (!bVar.a(arrayList)) {
                                TroopManageRemoteHandler.this.f303022f.remove(i3);
                            } else {
                                i3++;
                            }
                        } else {
                            TroopManageRemoteHandler.this.f303022f.remove(i3);
                        }
                        i3--;
                        i3++;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract boolean a(List<String> list);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(int i3, @Nullable Object obj);
    }

    public TroopManageRemoteHandler(Context context, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appInterface);
            return;
        }
        this.f303019c = new ArrayList<>();
        this.f303020d = new HashMap();
        this.f303021e = new HashMap();
        this.f303022f = new ArrayList();
        this.f303024h = new Runnable() { // from class: com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopManageRemoteHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Intent intent = new Intent("com.tencent.qqhead.getheadreq");
                intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, TroopManageRemoteHandler.this.f303019c);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopManageRemoteHandler", 2, "com.tencent.qqhead.getheadreq: " + TroopManageRemoteHandler.this.f303019c.size());
                }
                TroopManageRemoteHandler.this.f303018b.sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
                TroopManageRemoteHandler.this.f303019c.clear();
            }
        };
        a aVar = new a();
        this.f303025i = aVar;
        this.f303017a = appInterface;
        this.f303018b = context;
        this.f303023g = new cooperation.troop.a((QQAppInterface) appInterface);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadresp");
        context.registerReceiver(aVar, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
    }

    private void j(String str) {
        this.f303019c.add(str);
        if (QLog.isColorLevel()) {
            QLog.d("TroopManageRemoteHandler", 2, "requestBuddyFace: " + str);
        }
        if (this.f303019c.size() > 1) {
            return;
        }
        new Handler(Looper.myLooper()).postDelayed(this.f303024h, 200L);
    }

    public void e(@NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            if (this.f303022f.contains(bVar)) {
                return;
            }
            this.f303022f.add(bVar);
        }
    }

    public Bitmap f(String str) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        String str2 = this.f303020d.get(str);
        boolean z16 = true;
        if (str2 == null) {
            try {
                str2 = QQAppInterface.getBuddyFaceFilePath(str);
            } catch (VerifyError e16) {
                QLog.e("TroopManageRemoteHandler", 1, "getFaceBitmap: " + e16);
            }
            if (str2 != null) {
                this.f303020d.put(str, str2);
            }
        }
        if (str2 != null) {
            bitmap = this.f303021e.get(str2);
            if (bitmap == null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    j.a aVar = new j.a();
                    j.e(str2, options, aVar);
                    float f16 = this.f303018b.getResources().getDisplayMetrics().density;
                    int width = aVar.f306778a.getWidth();
                    if (width > 0) {
                        float f17 = width;
                        if (f17 < f16 * 50.0f) {
                            f16 = f17 / 50.0f;
                        }
                    }
                    int i3 = (int) (f16 * 50.0f);
                    bitmap = BaseImageUtil.getRoundedCornerBitmap(aVar.f306778a, i3, i3, i3);
                    if (bitmap != null) {
                        this.f303021e.put(str2, bitmap);
                    }
                } catch (Exception e17) {
                    QLog.e("TroopManageRemoteHandler", 1, "getFaceBitmap: " + e17);
                }
            }
        } else {
            bitmap = null;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFaceBitmap(");
            sb5.append(str);
            sb5.append("): ");
            sb5.append(str2);
            sb5.append(", request=");
            if (bitmap != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("TroopManageRemoteHandler", 2, sb5.toString());
        }
        if (bitmap == null) {
            Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
            j(str);
            return defaultFaceBitmap;
        }
        return bitmap;
    }

    public void g(int i3, @Nullable Bundle bundle, @Nullable c cVar) {
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bundle, cVar);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("req_sub_cmd", i3);
        Object obj = null;
        try {
            bundle2 = this.f303023g.invoke(bundle, null);
        } catch (Exception e16) {
            QLog.e("TroopManageRemoteHandler", 2, "exception happened! class = " + e16.getClass().getName() + " msg = " + e16.getMessage());
            bundle2 = null;
        }
        if (bundle2 == null) {
            if (cVar != null) {
                cVar.a(i3, null);
                return;
            }
            return;
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 7) {
                    obj = bundle2.getString("param_rsp_upgrade_troop_url");
                }
            } else {
                obj = bundle2.getString("param_rsp_troop_owmer_field");
            }
        } else {
            obj = Integer.valueOf(bundle2.getInt("rep_unique_title_flag"));
        }
        if (cVar != null) {
            cVar.a(i3, obj);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            this.f303018b.unregisterReceiver(this.f303025i);
        } catch (Exception e16) {
            QLog.e("TroopManageRemoteHandler", 1, "onDestroy exception: " + e16);
        }
    }

    public void i(@NonNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.f303022f.remove(bVar);
        }
    }
}
