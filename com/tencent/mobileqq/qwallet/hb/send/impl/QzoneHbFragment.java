package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.qwallet.hb.view.RollNumberView;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QzoneHbFragment extends BaseHbFragment implements View.OnClickListener, RollNumberView.a, k {
    private View K;
    private ImageView L;
    private TextView M;
    private EditText N;
    private Button P;
    private Button Q;
    private String S;
    private View T;
    private Animation U;
    private String W;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f277665a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f277666b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f277667c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f277668d0;

    /* renamed from: e0, reason: collision with root package name */
    private RollNumberView f277669e0;
    private JSONArray R = new JSONArray();
    private boolean V = false;
    private String X = "1.00";

    /* renamed from: f0, reason: collision with root package name */
    private long f277670f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f277671g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private e f277672h0 = new e(this);

    /* renamed from: i0, reason: collision with root package name */
    private SharedPreferences f277673i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    private int f277674j0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    protected TextWatcher f277675k0 = new a();

    /* renamed from: l0, reason: collision with root package name */
    IPreloadImgApi.a f277676l0 = new c();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment$6, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f277677d;
        final /* synthetic */ QzoneHbFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f277677d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(0, 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends x05.b {
        a() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            QzoneHbFragment.this.Q.setEnabled(QzoneHbFragment.this.Jh());
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f277683d;

        d(Activity activity) {
            this.f277683d = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Button button = this.f277683d.getWindowManager().getDefaultDisplay().getWidth() <= 480 ? QzoneHbFragment.this.P : QzoneHbFragment.this.Q;
            Rect rect = new Rect();
            this.f277683d.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = this.f277683d.getWindow().getDecorView().getRootView().getHeight();
            int i3 = height - rect.bottom;
            if (i3 - QzoneHbFragment.this.Ih(this.f277683d) == 0) {
                i3 = 0;
            }
            int scrollY = QzoneHbFragment.this.D.getWindow().getDecorView().getScrollY();
            if (button != null && i3 != 0) {
                int[] iArr = new int[2];
                button.getLocationOnScreen(iArr);
                int measuredHeight = ((i3 + (iArr[1] + button.getMeasuredHeight())) - height) - scrollY;
                if (measuredHeight > 0) {
                    QzoneHbFragment.this.D.getWindow().getDecorView().scrollBy(0, measuredHeight + 5);
                }
                QzoneHbFragment.this.f277671g0 = true;
                return;
            }
            if (i3 == 0) {
                QzoneHbFragment.this.D.getWindow().getDecorView().scrollBy(0, -scrollY);
                QzoneHbFragment.this.f277671g0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QzoneHbFragment> f277685a;

        e(QzoneHbFragment qzoneHbFragment) {
            this.f277685a = new WeakReference<>(qzoneHbFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QzoneHbFragment qzoneHbFragment = this.f277685a.get();
            if (qzoneHbFragment == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 100) {
                if (i3 == 101 && !TextUtils.isEmpty(qzoneHbFragment.W)) {
                    qzoneHbFragment.N.setText(qzoneHbFragment.W);
                    qzoneHbFragment.f277669e0.setVisibility(8);
                    qzoneHbFragment.N.setVisibility(0);
                    qzoneHbFragment.P.setEnabled(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("QzoneHbFragment", 2, "MSG_ROLL_STOP AmountBtn.setEnabled(true)---");
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----1");
            }
            if (qzoneHbFragment.f277669e0 != null && !TextUtils.isEmpty(qzoneHbFragment.W)) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----in mModifyAmountBtn.setEnabled(false)");
                    }
                    qzoneHbFragment.f277669e0.f(Double.parseDouble(qzoneHbFragment.W));
                    qzoneHbFragment.f277669e0.setVisibility(0);
                    qzoneHbFragment.N.setVisibility(8);
                    qzoneHbFragment.f277669e0.g();
                    qzoneHbFragment.P.setEnabled(false);
                } catch (Exception e16) {
                    QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
                }
            }
        }
    }

    private void Fh() {
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            this.f277668d0.getViewTreeObserver().addOnGlobalLayoutListener(new d(activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jh() {
        int length = this.N.getText().length();
        String obj = this.N.getText().toString();
        if (length == 0 || obj.startsWith(".") || obj.endsWith(".") || TextUtils.isEmpty(obj) || obj.indexOf(46) == 0) {
            return false;
        }
        if (obj.indexOf(46) > 0 && obj.indexOf(46) < obj.length() - 3) {
            String string = getString(R.string.e7z);
            if (string != null) {
                this.D.showQzoneHbToast(string);
            }
            return false;
        }
        try {
            if (Double.valueOf(obj).doubleValue() <= 0.0d) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean Kh() {
        this.f277674j0 = 1;
        if (Integer.valueOf(x05.c.l(this.W)).intValue() >= this.f277674j0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: Exception -> 0x0073, TryCatch #1 {Exception -> 0x0073, blocks: (B:7:0x0022, B:9:0x002e, B:13:0x0043, B:14:0x0049, B:16:0x0051, B:18:0x0057), top: B:6:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String Mh() {
        int length;
        String string;
        JSONArray jSONArray;
        new JSONArray();
        JSONArray jSONArray2 = this.R;
        if (jSONArray2 == null || (length = jSONArray2.length()) <= 0) {
            return "";
        }
        Random random = new Random();
        int i3 = 0;
        try {
            string = this.f277673i0.getString("hb_key_rand_amount", "");
        } catch (Exception e16) {
            QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
            SharedPreferences.Editor edit = this.f277673i0.edit();
            edit.remove("hb_key_rand_amount");
            edit.commit();
        }
        try {
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
                if (jSONArray.length() == this.R.length()) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                        for (int i16 = 0; i16 < this.R.length(); i16++) {
                            jSONArray.put(i16, 0);
                        }
                    }
                    i3 = Gh(jSONArray, random.nextInt(length));
                    jSONArray.put(i3, 1);
                    SharedPreferences.Editor edit2 = this.f277673i0.edit();
                    edit2.putString("hb_key_rand_amount", jSONArray.toString());
                    edit2.commit();
                    return this.R.get(i3).toString();
                }
            }
            return this.R.get(i3).toString();
        } catch (Exception e17) {
            QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e17);
            return "";
        }
        jSONArray = null;
        if (jSONArray == null) {
        }
        i3 = Gh(jSONArray, random.nextInt(length));
        jSONArray.put(i3, 1);
        SharedPreferences.Editor edit22 = this.f277673i0.edit();
        edit22.putString("hb_key_rand_amount", jSONArray.toString());
        edit22.commit();
    }

    public static void Nh(Handler handler, final EditText editText) {
        if (handler != null && editText != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
                    editText.dispatchTouchEvent(obtain);
                    MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
                    editText.dispatchTouchEvent(obtain2);
                    obtain.recycle();
                    obtain2.recycle();
                }
            }, 100L);
        }
    }

    private void initListener() {
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.f277668d0.setOnClickListener(this);
        this.f277669e0.setLisener(this);
        this.N.addTextChangedListener(this.f277675k0);
    }

    private void initParam() {
        this.f277673i0 = getActivity().getPreferences(0);
        try {
            this.R.mo162put("1.00");
        } catch (Exception e16) {
            QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f277665a0 = arguments.getString("recv_name");
            this.f277666b0 = arguments.getString("feedsid");
            this.Y = arguments.getString("recv_uin");
            String string = arguments.getString("recv_type");
            this.f277667c0 = string;
            if (32768 == this.G && !string.equals("1")) {
                this.Y = arguments.getString("grab_uin_list");
            }
            this.Z = arguments.getString("send_uin");
            if (!TextUtils.isEmpty(this.f277665a0)) {
                if (this.f277665a0.length() > 8) {
                    this.f277665a0 = this.f277665a0.substring(0, 7) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.M.setText(this.f277665a0);
            }
            this.W = "1.00";
            this.N.setText("1.00");
        }
        this.N.setEnabled(false);
        this.L.setImageDrawable(FaceDrawable.getFaceDrawable(this.E, 1, this.Y));
        this.f277672h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QzoneHbFragment.this.T.startAnimation(QzoneHbFragment.this.U);
            }
        }, 10L);
        this.f277669e0.setVisibility(8);
        this.N.setVisibility(0);
    }

    private void initView(View view) {
        if (view == null) {
            return;
        }
        this.K = view.findViewById(R.id.ggh);
        this.L = (ImageView) view.findViewById(R.id.ghb);
        this.M = (TextView) view.findViewById(R.id.ggi);
        this.N = (EditText) view.findViewById(R.id.ggf);
        this.P = (Button) view.findViewById(R.id.ggg);
        this.Q = (Button) view.findViewById(R.id.in_);
        this.f277668d0 = view.findViewById(R.id.root_layout);
        this.U = AnimationUtils.loadAnimation(getActivity(), R.anim.f154874eo);
        this.T = view.findViewById(R.id.d1h);
        this.f277669e0 = (RollNumberView) view.findViewById(R.id.ghc);
    }

    public int Gh(JSONArray jSONArray, int i3) {
        int i16;
        int i17 = 0;
        if (jSONArray == null || jSONArray.length() <= i3 || i3 < 0) {
            return 0;
        }
        try {
            int length = jSONArray.length();
            int i18 = 0;
            while (true) {
                if (i18 < length) {
                    i16 = (i3 + i18) % length;
                    if (jSONArray.optInt(i16) == 0) {
                        break;
                    }
                    i18++;
                } else {
                    i16 = 0;
                    break;
                }
            }
            if (i18 == length) {
                for (int i19 = 0; i19 < length; i19++) {
                    try {
                        jSONArray.put(i19, 0);
                    } catch (Exception e16) {
                        e = e16;
                        i17 = i16;
                        QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e);
                        return i17;
                    }
                }
            } else {
                i3 = i16;
            }
            try {
                jSONArray.put(i3, 1);
                return i3;
            } catch (Exception e17) {
                e = e17;
                i17 = i3;
                QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e);
                return i17;
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    public void Hh() {
        if (!isAdded()) {
            return;
        }
        getActivity();
        final String str = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + this.Z + "/hbThemeConfig.cfg";
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.7
            @Override // java.lang.Runnable
            public void run() {
                String configCache = ((IHbThemeConfigApi) QRoute.api(IHbThemeConfigApi.class)).getConfigCache();
                if (!TextUtils.isEmpty(configCache)) {
                    try {
                        QzoneHbFragment.this.Lh(new JSONObject(new String(Base64.decode(configCache.toString(), 0))));
                        return;
                    } catch (Exception e16) {
                        ((IHbThemeConfigApi) QRoute.api(IHbThemeConfigApi.class)).setConfigCache("");
                        QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
                    }
                }
                File file = new File(str);
                if (file.exists()) {
                    FileInputStream fileInputStream = null;
                    try {
                        byte[] bArr = new byte[1024];
                        StringBuilder sb5 = new StringBuilder();
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bArr);
                                if (read > 0) {
                                    sb5.append(new String(bArr, 0, read));
                                } else {
                                    fileInputStream2.close();
                                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(sb5.toString(), 0)));
                                    ((IHbThemeConfigApi) QRoute.api(IHbThemeConfigApi.class)).setConfigCache(sb5.toString());
                                    QzoneHbFragment.this.Lh(jSONObject);
                                    return;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e18) {
                                        QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e18);
                                    }
                                }
                                QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e);
                                return;
                            }
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                }
            }
        });
    }

    protected int Ih(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        } catch (Exception e16) {
            QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
            return 0;
        }
    }

    public void Lh(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (this.G == 32768) {
            optJSONObject = jSONObject.optJSONObject("mk_svideo_hb");
        } else {
            optJSONObject = jSONObject.optJSONObject("mk_qzone_hb");
        }
        if (optJSONObject == null) {
            return;
        }
        try {
            this.S = optJSONObject.optString("comment");
            this.R = optJSONObject.optJSONArray("money_array");
            String Mh = Mh();
            this.W = Mh;
            if (!TextUtils.isEmpty(Mh)) {
                this.X = this.W;
            }
            Message obtainMessage = this.f277672h0.obtainMessage();
            obtainMessage.what = 100;
            this.f277672h0.sendMessage(obtainMessage);
        } catch (Exception e16) {
            QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.k
    public void Zc() {
        this.f277670f0 = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.view.RollNumberView.a
    public void complete() {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneHbFragment", 2, "complete---");
        }
        Message obtainMessage = this.f277672h0.obtainMessage();
        obtainMessage.what = 101;
        this.f277672h0.sendMessage(obtainMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ggh) {
            if (isAdded()) {
                try {
                    ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.T.getWindowToken(), 0);
                } catch (Exception e16) {
                    QLog.e("QzoneHbFragment", 1, "error msg in qqpay-impl module: ", e16);
                }
                this.D.cancelCallBack();
                this.D.finish();
                this.D.overridePendingTransition(0, 0);
                if (this.G != 32768) {
                    this.D.addQZoneHbUploadData(300, "rewardhongbao.wrap.close", 2);
                }
            }
        } else if (id5 == R.id.ggg) {
            if (!this.V) {
                this.V = true;
                this.P.setText(HardCodeUtil.qqStr(R.string.j6l));
                this.N.setEnabled(true);
                this.N.setFocusable(true);
                this.N.setText("");
                if (this.G != 32768) {
                    this.D.addQZoneHbUploadData(300, "rewardhongbao.wrap.custom", 2);
                }
                Nh(this.f277672h0, this.N);
            } else {
                this.V = false;
                this.N.setText(this.X);
                this.N.setEnabled(false);
                this.P.setText(HardCodeUtil.qqStr(R.string.rx5));
                this.N.setSelection(0);
            }
        } else if (id5 == R.id.in_) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f277670f0 == 0 || System.currentTimeMillis() - this.f277670f0 >= 1000) {
                this.f277670f0 = currentTimeMillis;
                EditText editText = this.N;
                if (editText != null) {
                    this.W = editText.getText().toString();
                }
                Map<String, String> mapPacketExtra = this.D.getMapPacketExtra();
                mapPacketExtra.put("total_num", "1");
                mapPacketExtra.put("total_amount", x05.c.l(this.W));
                mapPacketExtra.put("wishing", "");
                mapPacketExtra.put(WadlProxyConsts.CHANNEL, this.G + "");
                mapPacketExtra.put("feeds_name", this.f277665a0);
                mapPacketExtra.put("feeds_sid", this.f277666b0);
                if (this.G == 32768) {
                    if (!Kh()) {
                        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, HardCodeUtil.qqStr(R.string.rx8) + x05.c.k(this.f277674j0 + "", 0, true) + HardCodeUtil.qqStr(R.string.rx6), (String) null, getString(R.string.dvt), new b(), (DialogInterface.OnClickListener) null).show();
                    } else {
                        if (this.f277667c0.equals("1")) {
                            mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(1));
                            mapPacketExtra.put("bus_type", "1");
                        } else {
                            mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(1024));
                        }
                        mapPacketExtra.put("type", String.valueOf(1));
                    }
                }
                this.F.b(mapPacketExtra);
                this.D.overridePendingTransition(0, 0);
                if (this.G != 32768) {
                    this.D.addQZoneHbUploadData(300, "rewardhongbao.wrap.send", 2);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.D.getWindow().setSoftInputMode(32);
        View inflate = layoutInflater.inflate(R.layout.ccj, (ViewGroup) null);
        initView(inflate);
        initParam();
        initListener();
        Hh();
        Fh();
        if (this.G != 32768) {
            this.D.addQZoneHbUploadData(300, "rewardhongbao.wrap.show", 2);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        TextWatcher textWatcher;
        EditText editText = this.N;
        if (editText != null && (textWatcher = this.f277675k0) != null) {
            editText.removeTextChangedListener(textWatcher);
            this.f277675k0 = null;
        }
        super.onDestroyView();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements IPreloadImgApi.a {
        c() {
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.a
        public void b(Object obj) {
            if (obj instanceof Bitmap) {
                Message obtainMessage = QzoneHbFragment.this.f277672h0.obtainMessage();
                obtainMessage.what = 102;
                QzoneHbFragment.this.f277672h0.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.a
        public void a() {
        }
    }
}
