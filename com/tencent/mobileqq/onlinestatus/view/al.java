package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class al extends v {
    public static final int X = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.d5q);
    public static final int Y = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.d5r);
    public static final int Z = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.d5p);

    /* renamed from: a0, reason: collision with root package name */
    public static final int f256503a0 = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.d5s);
    private View J;
    private View K;
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private ImageView P;
    private ImageView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private Button U;
    private Activity V;
    private long W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            al.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements DecodeTaskCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IFaceDecoder f256506d;

        c(IFaceDecoder iFaceDecoder) {
            this.f256506d = iFaceDecoder;
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            if (bitmap != null) {
                al.this.N.setImageBitmap(BaseImageUtil.getRoundFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight()));
            }
            this.f256506d.setDecodeTaskCompletionListener(null);
            this.f256506d.destory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.onlinestatus.olympic.helper.c.e(al.this.W, al.this.V, (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), null);
            bv.a("0X800BD91");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public al(@NonNull Activity activity, long j3, v.a aVar) {
        super(activity, aVar);
        this.V = activity;
        this.W = j3;
        initUI();
    }

    private void d0() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        Bitmap bitmapFromCache = iQQAvatarService.getBitmapFromCache(1, appInterface.getCurrentAccountUin());
        if (bitmapFromCache != null) {
            this.N.setImageBitmap(BaseImageUtil.getRoundFaceBitmap(bitmapFromCache, bitmapFromCache.getWidth(), bitmapFromCache.getHeight()));
        } else {
            iQQAvatarService.requestDecodeFace(appInterface.getCurrentAccountUin(), 200, false, 1, true, (byte) 0, 4);
            iQQAvatarService.setDecodeTaskCompletionListener(new c(iQQAvatarService));
        }
    }

    private void e0() {
        URLDrawable drawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = X;
        obtain.mRequestWidth = Y;
        String str = com.tencent.mobileqq.onlinestatus.ab.a() + "/" + com.tencent.mobileqq.onlinestatus.olympic.helper.c.b(this.W) + "share_bg.png";
        if (com.tencent.mobileqq.onlinestatus.ab.b() && com.tencent.mobileqq.onlinestatus.olympic.helper.c.d(str)) {
            drawable = URLDrawable.getFileDrawable(str, obtain);
        } else {
            drawable = URLDrawable.getDrawable("https://static-res.qq.com/static-res/online_status/olympics_state/share_bg_default@2x.png", obtain);
        }
        drawable.setTag(com.tencent.mobileqq.onlinestatus.utils.ah.a(obtain.mRequestWidth, obtain.mRequestHeight, Utils.n(16.0f, getContext().getResources())));
        drawable.setDecodeHandler(com.tencent.mobileqq.onlinestatus.utils.ah.f256344d);
        this.L.setImageDrawable(drawable);
    }

    private void f0() {
        this.J.setOnClickListener(new a());
        this.K.setOnClickListener(new b());
    }

    private void g0() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.R.setText(com.tencent.mobileqq.onlinestatus.olympic.helper.c.a(appInterface, appInterface.getCurrentAccountUin()));
        this.R.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
    }

    private void i0() {
        String str = com.tencent.mobileqq.onlinestatus.ab.a() + "/share/share_mid_animation.png";
        if (com.tencent.mobileqq.onlinestatus.ab.b() && com.tencent.mobileqq.onlinestatus.olympic.helper.c.d(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = Y;
            obtain.mRequestHeight = Z;
            obtain.mUseApngImage = true;
            this.M.setImageDrawable(URLDrawable.getFileDrawable(str, obtain));
        }
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.V).inflate(R.layout.f168882h52, (ViewGroup) null);
        this.J = inflate;
        this.K = inflate.findViewById(R.id.f75813zz);
        this.L = (ImageView) this.J.findViewById(R.id.y0o);
        this.M = (ImageView) this.J.findViewById(R.id.y6f);
        this.N = (ImageView) this.J.findViewById(R.id.f165909du3);
        this.P = (ImageView) this.J.findViewById(R.id.y7n);
        this.R = (TextView) this.J.findViewById(R.id.k9t);
        this.Q = (ImageView) this.J.findViewById(R.id.y6g);
        this.S = (TextView) this.J.findViewById(R.id.f109716gk);
        this.T = (TextView) this.J.findViewById(R.id.k_q);
        this.U = (Button) this.J.findViewById(R.id.ak9);
        this.D = this.K;
        this.C = this.J;
        n0();
        setContentView(this.J);
    }

    private void j0() {
        String str;
        com.tencent.mobileqq.onlinestatus.au H = com.tencent.mobileqq.onlinestatus.af.C().H();
        String str2 = "";
        if (H == null) {
            str = "";
        } else {
            str = H.f255490c;
        }
        if (H != null) {
            str2 = H.f255491d;
        }
        if (TextUtils.isEmpty(str2)) {
            this.Q.setVisibility(8);
        } else {
            this.Q.setVisibility(0);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int i3 = f256503a0;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i3;
            this.Q.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
        }
        if (TextUtils.isEmpty(str)) {
            this.S.setText(R.string.f196794i_);
        } else {
            this.S.setText(str);
        }
        this.S.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
    }

    private void k0() {
        URLDrawable drawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = Utils.n(40.0f, getContext().getResources());
        obtain.mRequestWidth = Utils.n(100.0f, getContext().getResources());
        String str = com.tencent.mobileqq.onlinestatus.ab.a() + "/" + com.tencent.mobileqq.onlinestatus.olympic.helper.c.b(this.W) + "share_name_card.png";
        if (com.tencent.mobileqq.onlinestatus.ab.b() && com.tencent.mobileqq.onlinestatus.olympic.helper.c.d(str)) {
            obtain.mUseApngImage = true;
            drawable = URLDrawable.getFileDrawable(str, obtain);
        } else {
            drawable = URLDrawable.getDrawable("https://static-res.qq.com/static-res/online_status/olympics_state/share_name_card_default@2x.png", obtain);
        }
        this.P.setImageDrawable(drawable);
    }

    private void l0() {
        String str = "NO." + this.W;
        this.T.setTypeface(Typeface.create("sans-serif-condensed", 1));
        this.T.setText(str);
        this.T.setTextColor(Color.parseColor("#6a480b"));
    }

    private void m0() {
        this.U.setText(getContext().getResources().getString(R.string.f196804ia));
        this.U.setTextColor(Color.parseColor("#4249eb"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(Utils.n(6.0f, getContext().getResources()));
        gradientDrawable.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.U.setBackgroundDrawable(gradientDrawable);
        this.U.setOnClickListener(new d());
    }

    private void n0() {
        e0();
        i0();
        d0();
        g0();
        j0();
        k0();
        l0();
        m0();
        f0();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v
    protected void R(int[] iArr) {
        if (this.D.getWidth() != 0 && this.D.getHeight() != 0) {
            iArr[0] = this.D.getWidth();
            iArr[1] = this.D.getHeight();
        } else {
            iArr[0] = Y;
            iArr[1] = X;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
