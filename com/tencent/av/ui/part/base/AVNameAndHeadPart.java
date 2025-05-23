package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class AVNameAndHeadPart extends nw.a {
    private QavUpdateAvatarViewHelper D;
    protected WeakReference<VideoAppInterface> E;
    private WeakReference<Context> F;

    /* renamed from: e, reason: collision with root package name */
    private boolean f76202e;

    /* renamed from: f, reason: collision with root package name */
    private String f76203f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f76204h = null;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f76205i = null;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f76206m = null;
    protected View C = null;

    public AVNameAndHeadPart(boolean z16) {
        this.f76202e = z16;
    }

    private void E9(String str) {
        QavUpdateAvatarViewHelper qavUpdateAvatarViewHelper = this.D;
        if (qavUpdateAvatarViewHelper != null) {
            qavUpdateAvatarViewHelper.d(str);
            this.D = null;
        }
    }

    private boolean J9(AppRuntime appRuntime, SessionInfo sessionInfo) {
        if (sessionInfo.f73043k != 4 && sessionInfo.E() && sessionInfo.f73035i == 1) {
            return !TextUtils.isEmpty(VipFunCallUtil.getResourcePathByUrl(appRuntime, kw.a.a(appRuntime, sessionInfo.f73091w, true, true), VipFunCallUtil.getResourceType(), null));
        }
        return false;
    }

    public View F9() {
        return this.C;
    }

    public View G9() {
        return this.f76205i;
    }

    public void H9() {
        ViewGroup viewGroup;
        AVActivity x95 = x9(this.F);
        if (x95 == null || (viewGroup = (ViewGroup) x95.findViewById(R.id.bok)) == null) {
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.f30100nf);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        viewGroup.setBackground(null);
    }

    public boolean I9() {
        ImageView imageView = this.f76206m;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void K9() {
        WeakReference<VideoAppInterface> weakReference;
        WeakReference<VideoAppInterface> weakReference2 = this.E;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        final AVActivity x95 = x9(this.F);
        final SessionInfo f16 = n.e().f();
        if (f16 == null || x95 == null || (weakReference = this.E) == null) {
            return;
        }
        if (f16.f73035i == 1 && !J9(weakReference.get(), f16) && !f16.f73098x2 && !f16.f73102y2) {
            final int i3 = f16.f73067q;
            final String str = f16.f73091w;
            String str2 = f16.f73103z;
            String str3 = f16.B;
            final String str4 = str3 != null ? str3 : str2;
            final ew.a aVar = new ew.a(i3, str, str2, false);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.base.AVNameAndHeadPart.1

                /* renamed from: com.tencent.av.ui.part.base.AVNameAndHeadPart$1$a */
                /* loaded from: classes32.dex */
                class a implements ew.b {
                    a() {
                    }

                    @Override // ew.b
                    public void D1(ew.a aVar, Drawable drawable) {
                        QLog.d(((nw.a) AVNameAndHeadPart.this).f421444d, 1, "onGetFaceDrawable sessionType=" + f16.f73035i + " isInZplanAvatar=" + f16.J());
                        if (f16.P() || f16.J()) {
                            QLog.d(((nw.a) AVNameAndHeadPart.this).f421444d, 1, "onGetFaceDrawable setBackground error. sessionType=" + f16.f73035i + " isInZplanAvatar=" + f16.J());
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) x95.findViewById(R.id.bok);
                        if (viewGroup != null) {
                            viewGroup.setBackground(drawable);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    WeakReference<VideoAppInterface> weakReference3 = AVNameAndHeadPart.this.E;
                    if (weakReference3 == null || weakReference3.get() == null || AVNameAndHeadPart.this.D == null) {
                        return;
                    }
                    Bitmap J = AVNameAndHeadPart.this.E.get().J(i3, str, str4, false, false);
                    WeakReference<VideoAppInterface> weakReference4 = AVNameAndHeadPart.this.E;
                    if (weakReference4 == null || weakReference4.get() == null || AVNameAndHeadPart.this.D == null) {
                        return;
                    }
                    AVNameAndHeadPart.this.D.i(AVNameAndHeadPart.this.E.get(), aVar, J, new a());
                }
            }, 16, null, false);
            ((ViewGroup) x95.findViewById(R.id.bok)).findViewById(R.id.f30100nf).setVisibility(0);
            return;
        }
        H9();
    }

    public boolean L9(ViewGroup viewGroup) {
        Bitmap bitmap;
        WeakReference<VideoAppInterface> weakReference = this.E;
        boolean z16 = false;
        if (weakReference == null) {
            return false;
        }
        VideoAppInterface videoAppInterface = weakReference.get();
        if (videoAppInterface != null && r.h0() != null) {
            SessionInfo f16 = n.e().f();
            if (f16 == null) {
                return false;
            }
            int i3 = f16.f73067q;
            String str = f16.f73091w;
            String str2 = f16.f73103z;
            String str3 = f16.f73099y;
            if (f16.G) {
                str3 = videoAppInterface.G(i3, str, str2);
                f16.f73099y = str3;
            }
            if (this.f76206m == null) {
                this.f76206m = (ImageView) viewGroup.findViewById(R.id.g85);
            }
            if (this.f76205i == null) {
                this.f76205i = (TextView) viewGroup.findViewById(R.id.g86);
            }
            if (this.f76204h == null) {
                this.f76204h = (TextView) viewGroup.findViewById(R.id.f5e);
                z16 = true;
            }
            if (f16.f73067q == 25) {
                String str4 = f16.B;
                if (str4 == null) {
                    str4 = f16.f73103z;
                }
                String G = videoAppInterface.G(i3, str, str4);
                bitmap = videoAppInterface.J(i3, str, str4, true, true);
                if (G.equals(f16.f73091w) && str4 != null) {
                    TextView textView = this.f76205i;
                    if (textView != null) {
                        textView.setText(str4);
                    }
                    TextView textView2 = this.f76204h;
                    if (textView2 != null) {
                        textView2.setText(str4);
                    }
                } else {
                    TextView textView3 = this.f76205i;
                    if (textView3 != null) {
                        textView3.setText(G);
                    }
                    TextView textView4 = this.f76204h;
                    if (textView4 != null) {
                        textView4.setText(G);
                    }
                }
            } else {
                TextView textView5 = this.f76205i;
                if (textView5 != null) {
                    textView5.setText(str3);
                }
                TextView textView6 = this.f76204h;
                if (textView6 != null) {
                    textView6.setText(str3);
                }
                bitmap = null;
            }
            this.D.h(videoAppInterface, this.f76206m, new ew.a(i3, str, str2, true), bitmap);
        }
        return z16;
    }

    public void M9(String str, Bitmap bitmap) {
        SessionInfo f16;
        if (this.E == null || r.h0() == null || (f16 = n.e().f()) == null || f16.f73067q != 25) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f421444d, 2, "setQCallHead uin = " + str);
        }
        this.D.h(this.E.get(), this.f76206m, new ew.a(f16.f73067q, str, f16.f73103z, true), bitmap);
    }

    @Override // nw.a
    public void onDestroy() {
        if (this.E != null && r.h0() != null) {
            E9(n.e().f().f73091w);
        }
        this.f76204h = null;
        this.f76205i = null;
        this.C = null;
        ImageView imageView = this.f76206m;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f76206m = null;
        }
        this.E = null;
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        z9(getContext(), nw.b.b());
        if (this.f76202e) {
            P9();
            return;
        }
        this.f76204h = (TextView) view.findViewById(R.id.f5e);
        this.f76206m = (ImageView) view.findViewById(R.id.g85);
        this.f76205i = (TextView) view.findViewById(R.id.g86);
        this.D = new QavUpdateAvatarViewHelper();
        View findViewById = view.findViewById(R.id.f166569g84);
        this.C = findViewById;
        if (findViewById != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            int i3 = view.getResources().getDisplayMetrics().heightPixels;
            if (view.getResources().getConfiguration().orientation == 2) {
                i3 = view.getResources().getDisplayMetrics().widthPixels;
            }
            layoutParams.topMargin = (int) (i3 * 0.18f);
            this.C.requestLayout();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.E = new WeakReference<>((VideoAppInterface) appInterface);
        this.F = new WeakReference<>(context);
    }

    public void N9(String str, SessionInfo sessionInfo) {
        if (sessionInfo == null || sessionInfo.f73067q != 25) {
            return;
        }
        sessionInfo.f73099y = str;
        if (QLog.isColorLevel()) {
            QLog.d(this.f421444d, 2, "setQCallNickName");
        }
        TextView textView = this.f76205i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void P9() {
        SessionInfo f16 = n.e().f();
        if (f16.f73067q == -1) {
            f16.f73067q = 0;
        }
        if (TextUtils.isEmpty(f16.f73091w)) {
            QLog.e(this.f421444d, 1, "updateHeadBitmap peerUin is empty.");
            f16.f73091w = this.f76203f;
        } else {
            this.f76203f = f16.f73091w;
        }
        int i3 = f16.f73067q;
        String str = f16.f73091w;
        Bitmap J = this.E.get().J(i3, str, null, true, true);
        String G = this.E.get().G(i3, str, null);
        if (QLog.isColorLevel()) {
            QLog.i(this.f421444d, 2, "updateHeadBitmap, uinType[" + i3 + "], peerUin[" + str + "], name[" + G + "]");
        }
        if (getPartRootView() == null) {
            QLog.i(this.f421444d, 1, "updateHeadBitmap rootView is null");
            return;
        }
        if (this.f76206m == null) {
            this.f76206m = (ImageView) getPartRootView().findViewById(R.id.g85);
        }
        if (this.f76205i == null) {
            this.f76205i = (TextView) getPartRootView().findViewById(R.id.g86);
        }
        O9(true);
        ImageView imageView = this.f76206m;
        if (imageView != null) {
            imageView.setImageBitmap(J);
        }
        TextView textView = this.f76205i;
        if (textView != null) {
            textView.getText().toString();
        }
        if (TextUtils.equals("", G)) {
            return;
        }
        TextView textView2 = this.f76205i;
        if (textView2 != null) {
            textView2.setText(G);
        }
        mw.g gVar = (mw.g) RFWIocAbilityProvider.g().getIocInterface(mw.g.class, getPartRootView(), null);
        if (gVar != null) {
            gVar.l5(f16.f73030h, G, J, String.valueOf(f16.P0), 48, 0, f16.f73035i);
        }
    }

    public void D9(int i3) {
        if (i3 == 2) {
            ImageView imageView = this.f76206m;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.f76205i;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (i3 == 1) {
            ImageView imageView2 = this.f76206m;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView2 = this.f76205i;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public void O9(boolean z16) {
        float f16;
        float f17;
        if (z16) {
            f16 = 108.0f;
            f17 = 16.0f;
        } else {
            f16 = 140.0f;
            f17 = 34.0f;
        }
        float f18 = f17;
        float f19 = f16;
        Resources resources = getContext().getResources();
        ImageView imageView = this.f76206m;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = BaseAIOUtils.f(f16, resources);
            layoutParams.height = BaseAIOUtils.f(f19, resources);
            this.f76206m.setLayoutParams(layoutParams);
        }
        TextView textView = this.f76205i;
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.topMargin = BaseAIOUtils.f(f18, resources);
            this.f76205i.setLayoutParams(layoutParams2);
        }
    }
}
