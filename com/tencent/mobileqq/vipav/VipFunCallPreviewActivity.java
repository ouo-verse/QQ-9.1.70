package com.tencent.mobileqq.vipav;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bp;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x4Req;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes20.dex */
public class VipFunCallPreviewActivity extends BaseActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    static IPatchRedirector $redirector_;
    long A0;
    Bundle B0;
    boolean C0;
    protected VipFunCallObserver D0;
    QQProgressDialog E0;

    /* renamed from: a0, reason: collision with root package name */
    public int f313046a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f313047b0;

    /* renamed from: c0, reason: collision with root package name */
    int f313048c0;

    /* renamed from: d0, reason: collision with root package name */
    VipFullScreenVideoView f313049d0;

    /* renamed from: e0, reason: collision with root package name */
    Button f313050e0;

    /* renamed from: f0, reason: collision with root package name */
    ImageView f313051f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f313052g0;

    /* renamed from: h0, reason: collision with root package name */
    TextView f313053h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f313054i0;

    /* renamed from: j0, reason: collision with root package name */
    TextView f313055j0;

    /* renamed from: k0, reason: collision with root package name */
    View f313056k0;

    /* renamed from: l0, reason: collision with root package name */
    final String f313057l0;

    /* renamed from: m0, reason: collision with root package name */
    View f313058m0;

    /* renamed from: n0, reason: collision with root package name */
    View f313059n0;

    /* renamed from: o0, reason: collision with root package name */
    View f313060o0;

    /* renamed from: p0, reason: collision with root package name */
    View f313061p0;

    /* renamed from: q0, reason: collision with root package name */
    View f313062q0;

    /* renamed from: r0, reason: collision with root package name */
    View f313063r0;

    /* renamed from: s0, reason: collision with root package name */
    ArrayList<String> f313064s0;

    /* renamed from: t0, reason: collision with root package name */
    String f313065t0;

    /* renamed from: u0, reason: collision with root package name */
    IFaceDecoder f313066u0;

    /* renamed from: v0, reason: collision with root package name */
    int f313067v0;

    /* renamed from: w0, reason: collision with root package name */
    bp f313068w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f313069x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f313070y0;

    /* renamed from: z0, reason: collision with root package name */
    Handler f313071z0;

    /* loaded from: classes20.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipFunCallPreviewActivity.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 50) {
                VipFunCallPreviewActivity.this.V2();
                return;
            }
            if (i3 == 51 && (obj = message.obj) != null && (obj instanceof BitmapDrawable)) {
                RelativeLayout relativeLayout = (RelativeLayout) VipFunCallPreviewActivity.this.findViewById(R.id.kys);
                BitmapDrawable bitmapDrawable = (BitmapDrawable) message.obj;
                if (bitmapDrawable != null && relativeLayout != null) {
                    relativeLayout.setBackgroundDrawable(bitmapDrawable);
                    if (message.arg1 == 1) {
                        VipFunCallPreviewActivity.this.f313049d0.setBackgroundDrawable(bitmapDrawable);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipFunCallPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* loaded from: classes20.dex */
    class c extends VipFunCallObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipFunCallPreviewActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.vipav.VipFunCallObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            if (i3 == 3 || i3 == 4) {
                Collections.sort(VipFunCallPreviewActivity.this.f313064s0);
                VipFunCallPreviewActivity vipFunCallPreviewActivity = VipFunCallPreviewActivity.this;
                vipFunCallPreviewActivity.f313065t0 = vipFunCallPreviewActivity.f313064s0.toString();
                VipFunCallPreviewActivity.this.n3(false, 0);
                VipFunCallPreviewActivity vipFunCallPreviewActivity2 = VipFunCallPreviewActivity.this;
                vipFunCallPreviewActivity2.f313070y0 = z16;
                if (!z16) {
                    vipFunCallPreviewActivity2.l3((Bundle) obj);
                }
                VipFunCallPreviewActivity.this.f313071z0.sendEmptyMessage(50);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f313076a;

        /* renamed from: b, reason: collision with root package name */
        String f313077b;

        /* renamed from: c, reason: collision with root package name */
        String f313078c;

        /* renamed from: d, reason: collision with root package name */
        String f313079d;

        /* renamed from: e, reason: collision with root package name */
        String f313080e;

        /* renamed from: f, reason: collision with root package name */
        String f313081f;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public VipFunCallPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f313046a0 = 0;
        this.f313057l0 = "FT";
        this.f313064s0 = new ArrayList<>();
        this.f313068w0 = bp.a();
        this.f313069x0 = 0;
        this.f313071z0 = new a(Looper.getMainLooper());
        this.D0 = new c();
    }

    private void H2() {
        SharedPreferences funCallSP = VipFunCallUtil.getFunCallSP(this.app, 1, null);
        if (funCallSP != null) {
            I2(U2(funCallSP, funCallSP.getString(VipFunCallConstants.KEY_GROUP, null), String.valueOf(this.f313046a0), null));
        }
    }

    private void I2(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length >= 3 && split[2].length() > 2) {
                String[] split2 = split[2].split("-");
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < split2.length; i3++) {
                    String str2 = split2[i3];
                    if (str2 != null && str2.length() > 4) {
                        arrayList.add(split2[i3]);
                    }
                }
                Collections.sort(arrayList);
                this.f313065t0 = arrayList.toString();
                r3(arrayList, true);
            }
        }
    }

    private void J2(int i3, String str) {
        if (i3 == 1 && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("isShowAd", false);
            super.startActivity(intent);
        }
    }

    private void K2(DialogInterface dialogInterface, int i3, int i16, int i17) {
        boolean z16;
        String str;
        if (i3 == 1) {
            int i18 = 12;
            if (12 != i16 && 11 != i16) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                i18 = 3;
            }
            StringBuilder sb5 = new StringBuilder();
            if (z16) {
                str = "mvip.g.a.ld_n_";
            } else {
                str = "mvip.g.a.ld_xq_";
            }
            sb5.append(str);
            sb5.append(i17);
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d("VipOpenVipDialog", 2, "onClick:aid=" + sb6);
            }
            if (1 != i16 && 11 != i16) {
                ff.b(this, true, i18, !z16, sb6);
            } else {
                ff.b(this, false, i18, !z16, sb6);
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    private void L2(boolean z16) {
        if (!z16) {
            onClick(this.f313060o0);
        }
    }

    private Bundle M2(Intent intent) {
        if (intent.hasExtra("callId") && intent.hasExtra(VipFunCallConstants.KEY_TO_UIN)) {
            this.f313047b0 = intent.getStringExtra(VipFunCallConstants.KEY_TO_UIN);
            this.f313046a0 = intent.getIntExtra("callId", 0);
        }
        if (intent.hasExtra(VipFunCallConstants.KEY_RING_ID)) {
            this.f313048c0 = intent.getIntExtra(VipFunCallConstants.KEY_RING_ID, 0);
        }
        return intent.getBundleExtra("bundle");
    }

    private int P2(ArrayList<String> arrayList, RelativeLayout relativeLayout, int i3) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                this.f313064s0.add(next);
                if (i3 < 5) {
                    ImageView imageView = new ImageView(this);
                    imageView.setTag("FT");
                    imageView.setImageBitmap(N2(next, 1));
                    relativeLayout.addView(imageView);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    int f16 = BaseAIOUtils.f(40.0f, getResources());
                    layoutParams.height = f16;
                    layoutParams.width = f16;
                    layoutParams.addRule(5, R.id.fuh);
                    layoutParams.addRule(6, R.id.fuh);
                    layoutParams.leftMargin = BaseAIOUtils.f(i3 * 30, getResources());
                    i3++;
                }
            }
        }
        return i3;
    }

    private void Q2(d dVar, int i3) {
        if (TextUtils.isEmpty(dVar.f313077b)) {
            if (i3 != 22001 && i3 != 6002) {
                if (i3 == 3002) {
                    dVar.f313077b = HardCodeUtil.qqStr(R.string.vff);
                    return;
                } else {
                    if (i3 == 8002) {
                        dVar.f313077b = HardCodeUtil.qqStr(R.string.vg6);
                        return;
                    }
                    return;
                }
            }
            dVar.f313077b = HardCodeUtil.qqStr(R.string.vfw);
        }
    }

    private void R2(d dVar, int i3) {
        if (TextUtils.isEmpty(dVar.f313080e)) {
            dVar.f313080e = HardCodeUtil.qqStr(i3);
        }
    }

    private String S2(Bundle bundle, String str) {
        if (str == null && bundle != null) {
            com.tencent.mobileqq.vipav.a.c(this.app, this.f313046a0, bundle, null, true);
            return VipFunCallUtil.getResourcePathByUrl(this.app, this.f313046a0, this.f313069x0, null);
        }
        return str;
    }

    private void T2(d dVar, boolean z16, int i3) {
        if (z16) {
            dVar.f313077b = HardCodeUtil.qqStr(i3);
        }
    }

    private String U2(SharedPreferences sharedPreferences, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (String str4 : str.split(",")) {
                if (str2.equals(str4)) {
                    return sharedPreferences.getString(VipFunCallConstants.KEY_GROUP_ONE + str2, null);
                }
            }
            return str3;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        if (this.f313064s0.size() > 0) {
            if (this.f313070y0) {
                View view = this.f313063r0;
                if (view instanceof Button) {
                    ((Button) view).setText(HardCodeUtil.qqStr(R.string.vfr));
                }
                this.f313063r0.setEnabled(false);
                return;
            }
            this.f313063r0.setEnabled(true);
            return;
        }
        if (this.f313070y0) {
            this.f313063r0.setVisibility(0);
            this.f313063r0.setEnabled(true);
            View view2 = this.f313063r0;
            if (view2 instanceof Button) {
                ((Button) view2).setText(HardCodeUtil.qqStr(R.string.vfl));
            }
            this.f313063r0.setEnabled(false);
            this.f313050e0.setVisibility(8);
            this.f313062q0.setVisibility(8);
            return;
        }
        this.f313050e0.setEnabled(true);
    }

    private boolean W2(boolean z16, boolean z17, String str) {
        if (!VipFunCallUtil.play(this, this.f313049d0, str, this.f313069x0, null, this.f313046a0, true, true)) {
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallConstants.play Error.");
            z17 = true;
        }
        if (z16) {
            u3();
        }
        return z17;
    }

    private boolean Y2(boolean z16, boolean z17, String str) {
        BitmapDrawable bitmapDrawable;
        Bitmap c16 = j.c(str);
        if (c16 != null) {
            bitmapDrawable = new BitmapDrawable(c16);
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            this.f313049d0.setBackgroundDrawable(bitmapDrawable);
        } else {
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
            z17 = true;
        }
        if (z16) {
            u3();
        }
        return z17;
    }

    private boolean Z2(boolean z16, boolean z17, String str) {
        int i3 = this.f313069x0;
        if (i3 == 6) {
            return W2(z16, z17, str);
        }
        if (i3 == 7) {
            return Y2(z16, z17, str);
        }
        return z17;
    }

    private boolean b3(int i3) {
        if (1 == i3 || 2 == i3 || 12 == i3 || 11 == i3) {
            return true;
        }
        return false;
    }

    private void c3(View view) {
        if (view == this.f313062q0) {
            String string = VipFunCallUtil.getFunCallSP(this.app, 1, null).getString(VipFunCallConstants.KEY_GROUP, null);
            String valueOf = String.valueOf(this.f313046a0);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(valueOf)) {
                String[] split = string.split(",");
                if (split.length >= 5) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < split.length) {
                            if (valueOf.equals(split[i3])) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 < 0) {
                        t3(6, this.f313046a0, null, HardCodeUtil.qqStr(R.string.vfs), null, null, null);
                        VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.f313046a0), "preview", "ClickGroupList", "1", new String[0]);
                        return;
                    }
                }
            }
        }
        VasWebviewTempUtil.reportVASTo00145(this.app, String.valueOf(this.f313046a0), "preview", "ClickGroupList", "0", new String[0]);
        Intent intent = new Intent(this, (Class<?>) ISelectMemberActivityConstants.class);
        intent.putExtra("param_type", AppConstants.VALUE.UIN_TYPE_FUN_CALL);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 22);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS, this.f313064s0);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, 20165);
    }

    private void d3() {
        VipFunCallAndRing$TSsoCmd0x4Req vipFunCallAndRing$TSsoCmd0x4Req = new VipFunCallAndRing$TSsoCmd0x4Req();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f313064s0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(it.next())));
        }
        vipFunCallAndRing$TSsoCmd0x4Req.rpt_uins.set(arrayList);
        vipFunCallAndRing$TSsoCmd0x4Req.i32_funcall_id.set(this.f313046a0);
        vipFunCallAndRing$TSsoCmd0x4Req.i32_ring_id.set(this.f313048c0);
        n3(true, R.string.f173205i02);
        ((VipSetFunCallHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).P2(4, vipFunCallAndRing$TSsoCmd0x4Req);
    }

    private void e3() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.A0 > 500) {
            this.A0 = currentTimeMillis;
            VipSetFunCallHandler vipSetFunCallHandler = (VipSetFunCallHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
            Bundle bundle = new Bundle();
            bundle.putInt("callId", this.f313046a0);
            bundle.putInt(VipFunCallConstants.KEY_RING_ID, this.f313048c0);
            bundle.putInt("from", 1);
            n3(true, R.string.f173205i02);
            vipSetFunCallHandler.P2(3, bundle);
        }
    }

    private void f3() {
        this.f313060o0.setVisibility(0);
        this.f313061p0.setVisibility(8);
        if (this.C0) {
            bp bpVar = this.f313068w0;
            if (bpVar != null && !bpVar.b()) {
                this.f313068w0.i();
            }
        } else {
            u3();
        }
        VipFunCallUtil.getFunCallSP(this.app, 0, null).edit().putBoolean(VipFunCallConstants.SP_KEY_FUN_CALL_SOUND, true).commit();
    }

    private void g3() {
        this.f313060o0.setVisibility(8);
        this.f313061p0.setVisibility(0);
        bp bpVar = this.f313068w0;
        if (bpVar != null && bpVar.b()) {
            this.f313068w0.c();
        }
        VipFunCallUtil.getFunCallSP(this.app, 0, null).edit().putBoolean(VipFunCallConstants.SP_KEY_FUN_CALL_SOUND, false).commit();
    }

    private void h3() {
        if (!onBackEvent()) {
            super.finish();
        }
    }

    private void i3(boolean z16) {
        ThreadManagerV2.post(new Runnable(z16 ? 1 : 0) { // from class: com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f313072d;

            {
                this.f313072d = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipFunCallPreviewActivity.this, r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                VipFunCallPreviewActivity vipFunCallPreviewActivity = VipFunCallPreviewActivity.this;
                BitmapDrawable bitmapDrawable = null;
                Bitmap c16 = j.c(VipFunCallUtil.getResourcePathByUrl(vipFunCallPreviewActivity.app, vipFunCallPreviewActivity.f313046a0, 9, null));
                if (c16 != null) {
                    bitmapDrawable = new BitmapDrawable(c16);
                }
                if (bitmapDrawable != null) {
                    Handler handler = VipFunCallPreviewActivity.this.f313071z0;
                    handler.sendMessage(Message.obtain(handler, 51, this.f313072d, 0, bitmapDrawable));
                }
            }
        }, 8, null, true);
    }

    private void j3(RelativeLayout relativeLayout) {
        for (int childCount = relativeLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = relativeLayout.getChildAt(childCount);
            if (childAt != null && (childAt instanceof ImageView) && "FT".equals(childAt.getTag())) {
                relativeLayout.removeView(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(Bundle bundle) {
        String str;
        d dVar = new d();
        int i3 = bundle.getInt("result");
        int i16 = bundle.getInt("callId", this.f313046a0);
        dVar.f313077b = bundle.getString("message");
        dVar.f313078c = bundle.getString(VipFunCallConstants.KEY_SV_URL);
        String string = bundle.getString(VipFunCallConstants.KEY_SV_ACTSTR);
        dVar.f313079d = string;
        dVar.f313076a = i3;
        dVar.f313080e = string;
        dVar.f313081f = null;
        if (i3 == 9002) {
            dVar.f313076a = 11;
            T2(dVar, TextUtils.isEmpty(dVar.f313077b), R.string.f172905vg2);
            R2(dVar, R.string.vfg);
        } else if (i3 == 9003) {
            dVar.f313076a = 12;
            T2(dVar, TextUtils.isEmpty(dVar.f313077b), R.string.vfj);
            R2(dVar, R.string.vfv);
        } else if (i3 != 1005011 && i3 != 5002) {
            if (i3 != 1005012 && i3 != 4002) {
                if (i3 == 461001) {
                    dVar.f313076a = 6;
                    dVar.f313077b = HardCodeUtil.qqStr(R.string.vg5);
                    R2(dVar, R.string.vfz);
                    dVar.f313081f = HardCodeUtil.qqStr(R.string.ket);
                    dVar.f313078c = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.FUNCALL_MINE);
                } else {
                    dVar.f313076a = 4;
                }
            } else {
                dVar.f313076a = 1;
                T2(dVar, TextUtils.isEmpty(dVar.f313077b), R.string.vfy);
                R2(dVar, R.string.vfq);
            }
        } else {
            dVar.f313076a = 2;
            T2(dVar, TextUtils.isEmpty(dVar.f313077b), R.string.vfp);
            R2(dVar, R.string.vft);
        }
        Q2(dVar, i3);
        int i17 = dVar.f313076a;
        String str2 = dVar.f313077b;
        String str3 = dVar.f313081f;
        if (!TextUtils.isEmpty(dVar.f313078c) && TextUtils.isEmpty(dVar.f313080e)) {
            str = HardCodeUtil.qqStr(R.string.f172904vg0);
        } else {
            str = dVar.f313080e;
        }
        t3(i17, i16, null, str2, str3, str, dVar.f313078c);
    }

    private void p3() {
        this.f313049d0.setOnTouchListener(new b());
    }

    private void s3() {
        this.f313063r0.setVisibility(0);
        View view = this.f313063r0;
        if (view instanceof Button) {
            ((Button) view).setText(HardCodeUtil.qqStr(R.string.vfn));
        }
        this.f313063r0.setEnabled(false);
        this.f313050e0.setVisibility(8);
        this.f313062q0.setVisibility(8);
    }

    Bitmap N2(String str, int i3) {
        Bitmap bitmapFromCache = this.f313066u0.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.f313066u0.isPausing()) {
            this.f313066u0.requestDecodeFace(str, i3, true);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 20165) {
            QLog.e("VipFunCallPreviewActivity", 1, "doOnActivityResult, requestCode = " + i3 + " resultCode = " + i16);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        String valueOf = String.valueOf(this.f313046a0);
        if (intent != null) {
            str = "0";
        } else {
            str = "1";
        }
        VasWebviewTempUtil.reportVASTo00145(qQAppInterface, valueOf, "preview", "ClickFriendsEdit", str, new String[0]);
        if (intent == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            arrayList = new ArrayList<>();
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                arrayList.add(((ResultRecord) it.next()).uin);
            }
        } else {
            arrayList = null;
        }
        r3(arrayList, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.c3c);
        this.f313066u0 = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        Intent intent = getIntent();
        if (intent != null) {
            bundle2 = M2(intent);
        } else {
            bundle2 = null;
        }
        if (this.f313046a0 <= 0) {
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
            super.finish();
            return true;
        }
        if (bundle2 != null) {
            this.f313067v0 = bundle2.getInt(VipFunCallConstants.KEY_FEET_TYPE);
        }
        this.f313049d0 = (VipFullScreenVideoView) super.findViewById(R.id.f167090kp4);
        boolean z17 = VipFunCallUtil.getFunCallSP(this.app, 0, null).getBoolean(VipFunCallConstants.SP_KEY_FUN_CALL_SOUND, true);
        if (this.f313049d0 != null) {
            int resourceType = VipFunCallUtil.getResourceType();
            this.f313069x0 = resourceType;
            String S2 = S2(bundle2, VipFunCallUtil.getResourcePathByUrl(this.app, this.f313046a0, resourceType, null));
            if (S2 == null) {
                QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
                t3(3, this.f313046a0, null, HardCodeUtil.qqStr(R.string.f172907vg4), null, null, null);
                return true;
            }
            z16 = Z2(z17, false, S2);
            p3();
        } else {
            z16 = false;
        }
        i3(z16);
        ImageView imageView = (ImageView) super.findViewById(R.id.a2d);
        this.f313051f0 = imageView;
        if (imageView != null) {
            imageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, this.f313047b0));
        }
        TextView textView = (TextView) super.findViewById(R.id.a2g);
        this.f313052g0 = textView;
        if (textView != null) {
            textView.setText(ac.G(this.app, this.f313047b0));
        }
        this.f313054i0 = (TextView) super.findViewById(R.id.a29);
        this.f313053h0 = (TextView) super.findViewById(R.id.c3t);
        this.f313056k0 = super.findViewById(R.id.jnu);
        TextView textView2 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        this.f313055j0 = textView2;
        textView2.setOnClickListener(this);
        this.f313058m0 = super.findViewById(R.id.fuh);
        this.f313059n0 = super.findViewById(R.id.kc6);
        this.f313060o0 = super.findViewById(R.id.dy_);
        this.f313061p0 = super.findViewById(R.id.dy9);
        this.f313062q0 = super.findViewById(R.id.ips);
        this.f313063r0 = super.findViewById(R.id.ipq);
        this.f313059n0.setOnClickListener(this);
        this.f313060o0.setOnClickListener(this);
        this.f313061p0.setOnClickListener(this);
        L2(z17);
        this.f313062q0.setOnClickListener(this);
        this.f313063r0.setOnClickListener(this);
        Button button = (Button) super.findViewById(R.id.ipr);
        this.f313050e0 = button;
        button.setOnClickListener(this);
        this.app.addObserver(this.D0, false);
        QQAppInterface qQAppInterface = this.app;
        if (VipFunCallUtil.getResIdByUin(qQAppInterface, qQAppInterface.getAccount(), 6, true, null) == this.f313046a0) {
            s3();
        } else {
            H2();
        }
        if (TextUtils.isEmpty(this.f313065t0)) {
            this.f313065t0 = this.f313064s0.toString();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeObserver(this.D0);
        IFaceDecoder iFaceDecoder = this.f313066u0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        bp bpVar = this.f313068w0;
        if (bpVar != null && !bpVar.b()) {
            this.f313068w0.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.doOnPause();
        VipFullScreenVideoView vipFullScreenVideoView = this.f313049d0;
        if (vipFullScreenVideoView != null && vipFullScreenVideoView.isPlaying() && this.f313069x0 == 6) {
            this.f313049d0.pause();
        }
        bp bpVar = this.f313068w0;
        if (bpVar != null && bpVar.b()) {
            this.f313068w0.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(9)
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnResume();
        VipFullScreenVideoView vipFullScreenVideoView = this.f313049d0;
        if (vipFullScreenVideoView != null && !vipFullScreenVideoView.isPlaying() && this.f313069x0 == 6) {
            this.f313049d0.resume();
        }
        bp bpVar = this.f313068w0;
        if (bpVar != null && !bpVar.b()) {
            this.f313068w0.i();
        }
    }

    void n3(boolean z16, int i3) {
        if (z16) {
            if (this.E0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.E0 = qQProgressDialog;
                qQProgressDialog.setCancelable(true);
            }
            this.E0.setMessage(i3);
            this.E0.show();
            return;
        }
        QQProgressDialog qQProgressDialog2 = this.E0;
        if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
            this.E0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Collections.sort(this.f313064s0);
        if (!this.f313064s0.toString().equals(this.f313065t0) && t3(5, this.f313046a0, null, HardCodeUtil.qqStr(R.string.vfm), null, null, null)) {
            return true;
        }
        super.onBackEvent();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (this.f313055j0 == view) {
            h3();
        } else if (view == this.f313060o0) {
            g3();
        } else if (view == this.f313061p0) {
            f3();
        } else if (view != this.f313059n0 && view != this.f313062q0) {
            if (view == this.f313050e0) {
                e3();
            } else if (view == this.f313063r0) {
                d3();
            }
        } else {
            c3(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (z16) {
            Rect rect = new Rect();
            super.getWindow().findViewById(android.R.id.content).getDrawingRect(rect);
            rect.width();
            rect.height();
            ProfileCardUtil.h(this, 102);
            int B = ProfileCardUtil.B(getResources());
            VipFullScreenVideoView vipFullScreenVideoView = this.f313049d0;
            if (vipFullScreenVideoView != null) {
                vipFullScreenVideoView.setVisibility(0);
            }
            View view = this.f313056k0;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    layoutParams.topMargin = B;
                }
                this.f313056k0.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f313051f0;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.topMargin = ProfileCardUtil.h(this, 25) + B + ((int) getResources().getDimension(R.dimen.title_bar_height));
                this.f313051f0.setLayoutParams(layoutParams2);
            }
            TextView textView = this.f313052g0;
            if (textView != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                layoutParams3.topMargin = ProfileCardUtil.h(this, 25);
                this.f313052g0.setLayoutParams(layoutParams3);
            }
            TextView textView2 = this.f313054i0;
            if (textView2 != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams4.topMargin = ProfileCardUtil.h(this, 10);
                this.f313054i0.setLayoutParams(layoutParams4);
            }
            TextView textView3 = this.f313053h0;
            if (textView3 != null) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
                layoutParams5.topMargin = ProfileCardUtil.h(this, 30);
                this.f313053h0.setLayoutParams(layoutParams5);
            }
        }
    }

    void r3(ArrayList<String> arrayList, boolean z16) {
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.i("VipFunCallPreviewActivity", 2, "showFriends uins == null");
                return;
            }
            return;
        }
        this.f313064s0.clear();
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.kys);
        j3(relativeLayout);
        int P2 = P2(arrayList, relativeLayout, 0);
        TextView textView = (TextView) super.findViewById(R.id.kc7);
        if (P2 > 0) {
            ((RelativeLayout.LayoutParams) textView.getLayoutParams()).leftMargin = BaseAIOUtils.f(((P2 - 1) * 30) + 40 + 10, getResources());
            if (5 < arrayList.size()) {
                textView.setText(String.format(HardCodeUtil.qqStr(R.string.vfu), Integer.valueOf(arrayList.size())));
            } else {
                textView.setText(HardCodeUtil.qqStr(R.string.vfk));
            }
            textView.setVisibility(0);
            this.f313059n0.setVisibility(0);
            this.f313063r0.setVisibility(0);
            this.f313062q0.setVisibility(8);
            this.f313050e0.setVisibility(8);
            if (z16) {
                View view = this.f313063r0;
                if (view instanceof Button) {
                    ((Button) view).setText(HardCodeUtil.qqStr(R.string.vfe));
                }
                this.f313063r0.setEnabled(false);
                return;
            }
            this.f313063r0.setEnabled(true);
            View view2 = this.f313063r0;
            if (view2 instanceof Button) {
                ((Button) view2).setText(HardCodeUtil.qqStr(R.string.vfh));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VipFunCallPreviewActivity", 2, "showFriends set views GONE");
        }
        textView.setVisibility(8);
        this.f313059n0.setVisibility(8);
        this.f313063r0.setVisibility(8);
        this.f313062q0.setVisibility(0);
        this.f313050e0.setVisibility(0);
    }

    boolean t3(int i3, int i16, String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        this.B0 = bundle;
        bundle.putInt("funcType", i3);
        this.B0.putString("url", str5);
        this.B0.putInt("fcID", i16);
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.f172906vg3);
        }
        String str6 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = HardCodeUtil.qqStr(R.string.vfi);
        }
        String str7 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = HardCodeUtil.qqStr(R.string.j6l);
        }
        String str8 = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = HardCodeUtil.qqStr(R.string.ket);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 0, str6, str7, str8, str4, this, this);
        if (createCustomDialog != null && !super.isFinishing()) {
            createCustomDialog.show();
            return true;
        }
        return false;
    }

    protected void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f313068w0 != null) {
            this.C0 = true;
            File file = new File(h.e(this.f313048c0, 3));
            if (file.exists()) {
                this.f313068w0.e(getApplicationContext(), Uri.fromFile(file));
            } else {
                this.f313068w0.e(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.f169426x));
            }
            this.f313068w0.g(true);
            this.f313068w0.i();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dialogInterface, i3);
            return;
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        Bundle bundle = this.B0;
        if (bundle == null) {
            return;
        }
        int i16 = bundle.getInt("funcType", 4);
        String string = this.B0.getString("url");
        int i17 = this.B0.getInt("fcID", this.f313046a0);
        if (QLog.isColorLevel()) {
            QLog.d("VipFunCallPreviewActivity", 1, "DialogInterface funcType=" + i16 + ", url:" + string);
        }
        if (b3(i16)) {
            K2(dialogInterface, i3, i16, i17);
            return;
        }
        if (5 == i16) {
            if (i3 == 1) {
                super.finish();
            }
        } else if (6 == i16 || 4 == i16) {
            J2(i3, string);
        } else if (3 == i16) {
            super.finish();
        }
    }
}
