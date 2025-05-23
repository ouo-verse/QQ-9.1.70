package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.n;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment;
import com.tencent.av.ui.o;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.g;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import mw.l;

/* loaded from: classes32.dex */
public class GaInviteHeadNamePart extends Part {
    private int C;
    private long D;
    private long E;
    private int F;
    private long[] G;
    private long[] H;
    private String I;
    private boolean J;
    private View K;
    private Bitmap L;
    private final Runnable M;
    private ew.b N;
    private final MainThreadRunnableTask P;
    o Q;
    GetGaFaceRunnable R;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f76474d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f76475e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f76476f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f76477h;

    /* renamed from: i, reason: collision with root package name */
    private QavUpdateAvatarViewHelper f76478i;

    /* renamed from: m, reason: collision with root package name */
    private MqqHandler f76479m;

    /* loaded from: classes32.dex */
    public static class GetGaFaceRunnable implements Runnable {
        WeakReference<o> C;
        boolean D = false;

        /* renamed from: d, reason: collision with root package name */
        final String f76481d;

        /* renamed from: e, reason: collision with root package name */
        int f76482e;

        /* renamed from: f, reason: collision with root package name */
        long f76483f;

        /* renamed from: h, reason: collision with root package name */
        String f76484h;

        /* renamed from: i, reason: collision with root package name */
        int f76485i;

        /* renamed from: m, reason: collision with root package name */
        VideoAppInterface f76486m;

        public GetGaFaceRunnable(String str, VideoAppInterface videoAppInterface, int i3, int i16, long j3, long j16, o oVar) {
            this.f76481d = str;
            this.f76482e = i3;
            this.f76483f = j3;
            this.f76484h = Long.toString(j16);
            this.f76486m = videoAppInterface;
            this.f76485i = i16;
            this.C = new WeakReference<>(oVar);
        }

        public void a(String str) {
            if (this.D) {
                QLog.w(this.f76481d, 1, "refreshUI[" + str + "], WaitDelayPost");
                return;
            }
            b(str);
        }

        public void cancel() {
            this.f76486m.M().removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            b("Runnable");
        }

        void b(String str) {
            o oVar;
            this.D = false;
            int i3 = this.f76482e;
            String valueOf = String.valueOf(this.f76483f);
            Bitmap J = this.f76486m.J(i3, valueOf, null, true, false);
            int f16 = AVUtil.f(this.f76485i);
            String G = this.f76486m.G(i3, valueOf, null);
            boolean a16 = (J == null || TextUtils.equals(G, this.f76484h) || (oVar = this.C.get()) == null) ? false : oVar.a(J, G);
            if (!a16) {
                this.D = true;
                this.f76486m.M().postDelayed(this, 1500L);
            }
            String str2 = this.f76481d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setGaFace[");
            sb5.append(str);
            sb5.append("], mRelationType[");
            sb5.append(this.f76485i);
            sb5.append("], uinTypeGroup[");
            sb5.append(i3);
            sb5.append("], mGroupId[");
            sb5.append(LogUtil.getSafePrintUin(valueOf));
            sb5.append("], uinTypeInvite[");
            sb5.append(f16);
            sb5.append("], mInviterUin[");
            sb5.append(this.f76484h);
            sb5.append("], memberName[");
            sb5.append(G);
            sb5.append("], faceBitmap[");
            sb5.append(J != null);
            sb5.append("], mWaitDelayPost[");
            sb5.append(this.D);
            sb5.append("], result[");
            sb5.append(a16);
            sb5.append("]");
            QLog.w(str2, 1, sb5.toString());
        }
    }

    /* loaded from: classes32.dex */
    private class MainThreadRunnableTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f76487d;

        /* renamed from: e, reason: collision with root package name */
        private String f76488e;

        public MainThreadRunnableTask() {
        }

        public void a(String str, String str2) {
            this.f76487d = str;
            this.f76488e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GaInviteHeadNamePart.this.f76475e != null) {
                GaInviteHeadNamePart.this.f76475e.setText(this.f76488e);
            }
            l lVar = (l) RFWIocAbilityProvider.g().getIocInterface(l.class, GaInviteHeadNamePart.this.getPartRootView(), null);
            if (lVar != null) {
                lVar.O6(GaInviteHeadNamePart.this.F, GaInviteHeadNamePart.this.D, this.f76487d);
            }
        }
    }

    /* loaded from: classes32.dex */
    class a implements ew.b {
        a() {
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            View partRootView = GaInviteHeadNamePart.this.getPartRootView();
            partRootView.findViewById(R.id.g8t).setBackground(drawable);
            partRootView.findViewById(R.id.f30100nf).setVisibility(0);
        }
    }

    /* loaded from: classes32.dex */
    class b implements o {
        b() {
        }

        @Override // com.tencent.av.ui.o
        public boolean a(Bitmap bitmap, String str) {
            boolean P9 = GaInviteHeadNamePart.this.P9(bitmap, 6);
            if (GaInviteHeadNamePart.this.f76475e != null) {
                GaInviteHeadNamePart.this.f76475e.setText(NTGaInviteBaseFragment.th(nw.b.b(), GaInviteHeadNamePart.this.f76475e, str, GaInviteHeadNamePart.this.F, String.valueOf(GaInviteHeadNamePart.this.D), GaInviteHeadNamePart.this.G));
            }
            return P9;
        }
    }

    public GaInviteHeadNamePart(boolean z16, long j3, int i3, int i16, long j16, long[] jArr, long[] jArr2, String str, Bitmap bitmap) {
        this.f76474d = null;
        this.f76475e = null;
        this.f76476f = null;
        this.f76477h = null;
        this.f76478i = null;
        this.C = 0;
        this.D = 0L;
        this.E = 0L;
        this.F = 0;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = false;
        this.M = new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteHeadNamePart.1
            @Override // java.lang.Runnable
            public void run() {
                int i17 = GaInviteHeadNamePart.this.C;
                String valueOf = String.valueOf(GaInviteHeadNamePart.this.D);
                int f16 = AVUtil.f(GaInviteHeadNamePart.this.F);
                VideoAppInterface b16 = nw.b.b();
                if (b16 == null) {
                    QLog.e("GaInviteHeadNamePart", 1, "mAsyncSubThreadRunnable error");
                    return;
                }
                String G = b16.G(i17, valueOf, null);
                String G2 = b16.G(f16, String.valueOf(GaInviteHeadNamePart.this.E), String.valueOf(GaInviteHeadNamePart.this.D));
                if (QLog.isDebugVersion()) {
                    QLog.w("GaInviteHeadNamePart", 1, "mAsyncSubThreadRunnable[groupName," + G + "],[peerName," + G2 + "]");
                }
                if (GaInviteHeadNamePart.this.getActivity() != null && !GaInviteHeadNamePart.this.getActivity().isFinishing() && GaInviteHeadNamePart.this.f76479m != null) {
                    GaInviteHeadNamePart.this.f76479m.removeCallbacks(GaInviteHeadNamePart.this.P);
                    GaInviteHeadNamePart.this.P.a(G, G2);
                    GaInviteHeadNamePart.this.f76479m.post(GaInviteHeadNamePart.this.P);
                }
                if (GaInviteHeadNamePart.this.f76478i == null) {
                    GaInviteHeadNamePart.this.f76478i = new QavUpdateAvatarViewHelper();
                }
                GaInviteHeadNamePart.this.f76478i.h(b16, GaInviteHeadNamePart.this.f76474d, new ew.a(f16, String.valueOf(GaInviteHeadNamePart.this.E), null, true), null);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteHeadNamePart.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GaInviteHeadNamePart.this.getActivity() == null || GaInviteHeadNamePart.this.getActivity().isDestroyed()) {
                            return;
                        }
                        GaInviteHeadNamePart.this.M9();
                    }
                });
            }
        };
        this.N = new a();
        this.P = new MainThreadRunnableTask();
        this.Q = new b();
        this.R = null;
        this.D = j3;
        this.C = i16;
        this.F = i3;
        this.G = jArr;
        this.E = j16;
        this.J = z16;
        this.H = jArr2;
        this.I = str;
        this.L = bitmap;
    }

    private void K9() {
        QLog.w("GaInviteHeadNamePart", 1, "doAsyncGetHeadImgAndNickName");
        boolean P9 = P9(null, 1);
        if (this.f76475e != null) {
            this.f76475e.setText(Long.toString(this.E));
        } else {
            QLog.w("GaInviteHeadNamePart", 1, "doAsyncGetHeadImgAndNickName[], mCallersName\u4e3a\u7a7a");
            P9 = false;
        }
        if (P9) {
            ThreadManagerV2.removeJobFromThreadPool(this.M, 16);
            ThreadManagerV2.excute(this.M, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M9() {
        QLog.d("GaInviteHeadNamePart", 1, "refreshGassianBg lock");
        View partRootView = getPartRootView();
        View findViewById = partRootView.findViewById(R.id.g8t);
        if (n.e().f().f73035i == 3) {
            int f16 = AVUtil.f(this.F);
            VideoAppInterface b16 = nw.b.b();
            if (b16 == null) {
                QLog.e("GaInviteHeadNamePart", 1, "refreshGassianBg error.");
                return;
            }
            Bitmap J = b16.J(f16, String.valueOf(this.E), null, false, false);
            this.f76478i.i(b16, new ew.a(f16, String.valueOf(this.E), null, false), J, this.N);
            return;
        }
        findViewById.setBackground(null);
        Drawable drawable = this.f76476f;
        if (drawable != null) {
            findViewById.setBackgroundDrawable(drawable);
        } else {
            findViewById.setBackgroundResource(R.drawable.dbb);
        }
        partRootView.findViewById(R.id.f30100nf).setVisibility(8);
    }

    public void L9(String str) {
        QLog.w("GaInviteHeadNamePart", 1, "from:" + str);
        if (this.R == null) {
            P9(null, 2);
            if (this.f76475e != null) {
                this.f76475e.setText(Long.toString(this.E));
            } else {
                QLog.w("GaInviteHeadNamePart", 1, "refreshUI[" + str + "], mCallersName\u4e3a\u7a7a");
            }
            if (nw.b.b() == null) {
                QLog.e("GaInviteHeadNamePart", 1, "refreshGaFaceUI from:" + str + " error.");
                return;
            }
            this.R = new GetGaFaceRunnable("GaInviteHeadNamePart", nw.b.b(), this.C, this.F, this.D, this.E, this.Q);
        }
        this.R.a(str);
    }

    public void O9(View view) {
        this.K = view;
    }

    public boolean P9(Bitmap bitmap, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "updateAvatar, from = " + i3 + ", headView = " + this.f76474d + ", bitmap = " + bitmap);
        }
        ImageView imageView = this.f76474d;
        if (imageView == null) {
            return false;
        }
        if (i3 == 2 || i3 == 3 || i3 == 5) {
            imageView.setImageResource(R.drawable.common_default_discussion_icon);
            return true;
        }
        if (bitmap == null) {
            return true;
        }
        imageView.setImageBitmap(bitmap);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (this.J) {
            this.f76474d = (ImageView) this.K.findViewById(R.id.gap);
            TextView textView = (TextView) this.K.findViewById(R.id.gao);
            this.f76475e = textView;
            textView.setSingleLine();
            P9(this.L, 4);
            if (NTGaInviteBaseFragment.xh(this.C)) {
                this.f76475e.setText(this.I);
            } else {
                N9(this.f76475e);
            }
            if (ThemeUtil.isInNightMode(nw.b.b())) {
                this.f76475e.setTextColor(Color.parseColor("#A8A8A8"));
                return;
            }
            return;
        }
        this.f76474d = (ImageView) view.findViewById(R.id.g8p);
        this.f76475e = (TextView) view.findViewById(R.id.g8c);
        this.f76476f = g.a(getContext(), R.drawable.dbb);
        this.f76477h = (TextView) view.findViewById(R.id.f166571g91);
        View findViewById = view.findViewById(R.id.gcx);
        if (!NetworkUtil.isWifiConnected(getContext()) && (NetworkUtil.is3Gor4G(getContext()) || NetworkUtil.isMobileNetWork(getContext()))) {
            this.f76477h.setVisibility(0);
            findViewById.setVisibility(0);
            this.f76477h.setText(R.string.f171268dm2);
        }
        this.f76479m = ThreadManager.getUIHandler();
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        MqqHandler mqqHandler = this.f76479m;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacks(this.P);
            this.f76479m = null;
        }
        ThreadManagerV2.removeJobFromThreadPool(this.M, 16);
        GetGaFaceRunnable getGaFaceRunnable = this.R;
        if (getGaFaceRunnable != null) {
            getGaFaceRunnable.cancel();
            this.R = null;
        }
        this.L = null;
        this.f76478i = null;
        this.f76476f = null;
        this.f76475e = null;
        this.f76474d = null;
        this.f76477h = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.K = null;
    }

    void N9(TextView textView) {
        Context context;
        Resources resources;
        String str;
        int dimensionPixelSize;
        if (textView == null || (context = getContext()) == null || (resources = context.getResources()) == null) {
            return;
        }
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.a6y);
        if (NTGaInviteBaseFragment.xh(this.C)) {
            String valueOf = String.valueOf(this.D);
            String string = context.getString(R.string.dbc);
            VideoAppInterface b16 = nw.b.b();
            if (b16 == null) {
                QLog.d("GaInviteHeadNamePart", 1, "setCallersName error.");
                return;
            }
            int K = b16.K(this.F, valueOf);
            if (K == 0) {
                long[] jArr = this.H;
                K = jArr != null ? jArr.length + 1 : 1;
            }
            if (K > 999) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f159354a70);
            } else {
                if (K > 99) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.a6z);
                }
                str = ba.getNameMaxMaseaured(context, b16.G(this.C, valueOf, null), textView, dimensionPixelSize2) + String.format(string, Integer.valueOf(K));
            }
            dimensionPixelSize2 = dimensionPixelSize;
            str = ba.getNameMaxMaseaured(context, b16.G(this.C, valueOf, null), textView, dimensionPixelSize2) + String.format(string, Integer.valueOf(K));
        } else {
            str = this.I;
        }
        textView.setText(str);
    }

    public GaInviteHeadNamePart(long j3, int i3, int i16, long j16, long[] jArr) {
        this(false, j3, i3, i16, j16, jArr, null, null, null);
    }
}
