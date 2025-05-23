package com.tencent.av.ui.notdisturb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.at;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GaInviteFloatBar implements View.OnTouchListener, View.OnClickListener {
    private TextView C;
    private Button D;
    private Button E;
    private TextView F;
    private View G;
    private TextView H;
    private ImageView I;
    WindowManager J;
    GestureDetector K;
    private GradientDrawable M;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    private Context f76143d;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f76145f;

    /* renamed from: h, reason: collision with root package name */
    private View f76146h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f76147i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f76148m;

    /* renamed from: e, reason: collision with root package name */
    private boolean f76144e = false;
    private SmallScreenActivityPlugin L = null;
    private QavUpdateAvatarViewHelper N = null;
    private boolean P = false;
    private int Q = 0;
    private String S = "";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            boolean z16 = (GaInviteFloatBar.this.Q == 0 || GaInviteFloatBar.this.Q == GaInviteFloatBar.this.u()) ? false : true;
            QLog.d("GaInviteFloatBar", 1, "onLayoutChange mCurLayoutWidth=" + GaInviteFloatBar.this.Q + " newWidth=" + GaInviteFloatBar.this.u() + " displayMetrics w=" + displayMetrics.widthPixels + " h=" + displayMetrics.heightPixels + " isChange=" + z16);
            if (!z16 || GaInviteFloatBar.this.f76145f == null || GaInviteFloatBar.this.f76146h == null) {
                return;
            }
            GaInviteFloatBar gaInviteFloatBar = GaInviteFloatBar.this;
            if (gaInviteFloatBar.J != null) {
                gaInviteFloatBar.f76145f.width = GaInviteFloatBar.this.u();
                GaInviteFloatBar gaInviteFloatBar2 = GaInviteFloatBar.this;
                gaInviteFloatBar2.J.updateViewLayout(gaInviteFloatBar2.f76146h, GaInviteFloatBar.this.f76145f);
                GaInviteFloatBar gaInviteFloatBar3 = GaInviteFloatBar.this;
                gaInviteFloatBar3.Q = gaInviteFloatBar3.f76145f.width;
                if (!TextUtils.isEmpty(GaInviteFloatBar.this.S)) {
                    GaInviteFloatBar gaInviteFloatBar4 = GaInviteFloatBar.this;
                    gaInviteFloatBar4.A(gaInviteFloatBar4.R, GaInviteFloatBar.this.S);
                }
                GaInviteFloatBar.this.r(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ew.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f76159d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f76160e;

        b(int i3, int i16) {
            this.f76159d = i3;
            this.f76160e = i16;
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            GaInviteFloatBar.this.P = false;
            if (GaInviteFloatBar.this.f76146h == null) {
                return;
            }
            View findViewById = GaInviteFloatBar.this.f76146h.findViewById(R.id.raw);
            if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.width = this.f76159d;
                layoutParams.height = this.f76160e;
                findViewById.setLayoutParams(layoutParams);
                findViewById.setBackground(drawable);
                findViewById.setVisibility(0);
            }
            View findViewById2 = GaInviteFloatBar.this.f76146h.findViewById(R.id.rax);
            if (findViewById2 != null) {
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                layoutParams2.width = this.f76159d;
                layoutParams2.height = this.f76160e;
                findViewById2.setLayoutParams(layoutParams2);
                findViewById2.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends RecyclerView.Adapter<a> {

        /* renamed from: m, reason: collision with root package name */
        private List<Bitmap> f76162m;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class a extends RecyclerView.ViewHolder {
            ImageView E;

            public a(View view) {
                super(view);
                this.E = (ImageView) view.findViewById(R.id.rb6);
            }
        }

        public c(List<Bitmap> list) {
            this.f76162m = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f76162m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i3) {
            aVar.E.setImageBitmap(this.f76162m.get(i3));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.di5, viewGroup, false));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            float x16 = motionEvent2.getX() - motionEvent.getX();
            float y16 = motionEvent2.getY() - motionEvent.getY();
            float abs = Math.abs(x16);
            float abs2 = Math.abs(y16);
            boolean z16 = abs < abs2 && y16 * (-1.0f) >= 20.0f;
            QLog.d("GaInviteFloatBar", 1, "onFling xOffset=" + abs + " yOffset=" + abs2 + " up=" + z16);
            if (!z16) {
                return false;
            }
            GaInviteFloatBar.this.x();
            GaInviteFloatBar.this.G();
            if (TraeHelper.I() != null) {
                TraeHelper.I().k0(e.d());
            }
            TraeHelper.n0(nw.b.b());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            long d16 = e.d();
            QLog.d("GaInviteFloatBar", 1, 1, "onSingleTapConfirmed...... seq=" + d16);
            Intent intent = new Intent();
            at.f(intent, d16);
            intent.setAction("tencent.video.notdisturb.invite.enter");
            GaInviteFloatBar.this.D.setClickable(false);
            GaInviteFloatBar.this.E.setClickable(false);
            intent.setPackage(GaInviteFloatBar.this.f76143d.getPackageName());
            GaInviteFloatBar.this.f76143d.sendBroadcast(intent);
            return true;
        }
    }

    public GaInviteFloatBar(Context context) {
        this.K = null;
        this.f76143d = context;
        this.J = (WindowManager) context.getSystemService("window");
        View inflate = ((LayoutInflater) this.f76143d.getSystemService("layout_inflater")).inflate(R.layout.f167475di4, (ViewGroup) null);
        this.f76146h = inflate;
        inflate.setOnTouchListener(this);
        this.f76146h.addOnLayoutChangeListener(new a());
        if (this.K == null) {
            this.K = new GestureDetector(this.f76143d, new d());
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.L == null) {
            this.L = SmallScreenActivityPlugin.a(VideoAppInterface.N());
        }
        r.h0().L2(true);
        r.h0().K2(false);
        SmallScreenActivityPlugin smallScreenActivityPlugin = this.L;
        if (smallScreenActivityPlugin != null) {
            smallScreenActivityPlugin.d();
            this.L.f(e.d(), false);
        }
    }

    private void H(int i3, int i16, int i17) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.rightMargin = i3;
        this.E.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams2.rightMargin = i16;
        this.D.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f76148m.getLayoutParams();
        layoutParams3.leftMargin = i17;
        this.f76148m.setLayoutParams(layoutParams3);
        this.E.invalidate();
        this.D.invalidate();
        this.f76148m.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16) {
        int u16 = u();
        float measureText = this.C.getPaint().measureText((String) this.C.getText());
        float f16 = u16;
        boolean z17 = f16 - ba.dp2px(this.f76143d, 236.0f) < measureText;
        QLog.d("GaInviteFloatBar", 1, "calculateMargin originTextWidth=" + measureText + " otherWidth=" + ba.dp2px(this.f76143d, 236.0f) + " isOverflow=" + z17);
        if (!z17) {
            if (z16) {
                int dimensionPixelSize = this.f76143d.getResources().getDimensionPixelSize(R.dimen.f12928s);
                H(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                return;
            }
            return;
        }
        int dimensionPixelSize2 = (int) ((((f16 - measureText) - (this.f76143d.getResources().getDimensionPixelSize(R.dimen.f12898p) * 3)) - (ba.dp2px(this.f76143d, 10.0f) * 2.0f)) / 4.0f);
        QLog.d("GaInviteFloatBar", 1, "calculateMargin marginLeft=" + dimensionPixelSize2);
        if (dimensionPixelSize2 <= 0) {
            return;
        }
        H(dimensionPixelSize2 * 2, dimensionPixelSize2, dimensionPixelSize2);
    }

    private int t() {
        return this.f76143d.getResources().getDimensionPixelSize(R.dimen.f12948u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        DisplayMetrics displayMetrics = this.f76143d.getResources().getDisplayMetrics();
        return (int) (Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) - (ba.dp2px(this.f76143d, 10.0f) * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v(int i3) {
        Resources resources = this.f76143d.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f12928s);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f12918r);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.f12908q);
        int i16 = (((this.f76145f.width - (dimensionPixelSize * 2)) - dimensionPixelSize2) / (dimensionPixelSize2 + dimensionPixelSize3)) + 1;
        QLog.d("GaInviteFloatBar", 1, "getMinDisplayListLen abilityNum=" + i16 + " floatBarMarginLeft=" + dimensionPixelSize + " listItemWidth=" + dimensionPixelSize2 + " listItemMarginRight=" + dimensionPixelSize3 + " with=" + this.f76145f.width);
        return Math.min(Math.min(i3, i16), 8);
    }

    private void z() {
        this.f76148m = (ImageView) this.f76146h.findViewById(R.id.rav);
        this.f76147i = (TextView) this.f76146h.findViewById(R.id.rb8);
        this.C = (TextView) this.f76146h.findViewById(R.id.rb7);
        this.D = (Button) this.f76146h.findViewById(R.id.f163654ra1);
        this.E = (Button) this.f76146h.findViewById(R.id.f163665rc2);
        this.F = (TextView) this.f76146h.findViewById(R.id.f163661rb3);
        this.G = this.f76146h.findViewById(R.id.f163659rb1);
        this.H = (TextView) this.f76146h.findViewById(R.id.f163660rb2);
        this.I = (ImageView) this.f76146h.findViewById(R.id.f163658rb0);
    }

    public void A(int i3, String str) {
        if (!TextUtils.isEmpty(str) && i3 >= 0 && this.f76146h != null) {
            this.R = i3;
            this.S = str;
            if (this.N == null) {
                this.N = new QavUpdateAvatarViewHelper();
            }
            int u16 = u();
            int t16 = t();
            int f16 = AVUtil.f(i3);
            Bitmap J = VideoAppInterface.N().J(f16, str, null, false, false);
            QLog.d("GaInviteFloatBar", 1, "refreshBg relationType=" + i3 + " inviterUin=" + str + " w=" + u16 + " h=" + t16 + " getMeasuredHeight=" + this.f76146h.getMeasuredHeight());
            ew.a aVar = new ew.a(f16, str, null, false);
            aVar.a(u16, t16);
            if (this.P) {
                return;
            }
            this.P = true;
            this.N.i(VideoAppInterface.N(), aVar, J, new b(u16, t16));
            return;
        }
        QLog.d("GaInviteFloatBar", 1, "refreshBg error. inviterUin=" + str + " relationType=" + i3 + " width=" + this.f76145f.width + " height=" + this.f76145f.height);
    }

    public void B(final long[] jArr, final long j3, final int i3) {
        View view = this.f76146h;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.raz);
        if (jArr.length > 0) {
            findViewById.setVisibility(0);
            final RecyclerView recyclerView = (RecyclerView) this.f76146h.findViewById(R.id.f163662rb4);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f76143d, 0, false));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.notdisturb.GaInviteFloatBar.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GaInviteFloatBar.this.f76146h == null) {
                        return;
                    }
                    final ArrayList arrayList = new ArrayList();
                    int v3 = GaInviteFloatBar.this.v(jArr.length);
                    final int length = jArr.length - v3;
                    if (length > 0) {
                        v3--;
                        length++;
                    }
                    for (int i16 = 0; i16 < v3; i16++) {
                        arrayList.add(r.h0().S(String.valueOf(jArr[i16]), String.valueOf(j3), i3, true, true));
                    }
                    QLog.d("GaInviteFloatBar", 1, "refreshMemberList bitmaps size=" + arrayList.size() + " realListNum=" + v3 + " totalNum=" + jArr.length + " restNum=" + length);
                    recyclerView.post(new Runnable() { // from class: com.tencent.av.ui.notdisturb.GaInviteFloatBar.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GaInviteFloatBar.this.f76146h == null) {
                                return;
                            }
                            GaInviteFloatBar.this.F(length);
                            recyclerView.setAdapter(new c(arrayList));
                            recyclerView.suppressLayout(true);
                        }
                    });
                }
            }, 16, null, false);
        }
    }

    public void C(Bitmap bitmap, String str, String str2) {
        this.f76148m.setImageBitmap(bitmap);
        this.f76147i.setText(str);
        s(str2);
    }

    public void D(String str) {
        this.C.setText(str);
        View view = this.f76146h;
        if (view != null) {
            view.invalidate();
        }
        q();
    }

    public void E() {
        QLog.w("GaInviteFloatBar", 1, "show.");
        if (this.f76144e) {
            return;
        }
        this.D.setClickable(true);
        this.E.setClickable(true);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.C.setText(this.f76143d.getResources().getString(R.string.f1773633r));
        y();
        q();
        com.tencent.av.ui.part.invite.multi.a.P9(!ad.m(this.f76143d));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f163654ra1) {
            long d16 = e.d();
            QLog.w("GaInviteFloatBar", 1, "onClick accept seq[" + d16 + "]");
            Intent intent = new Intent();
            at.f(intent, d16);
            intent.setAction("tencent.video.notdisturb.invite.gaaccept");
            this.D.setClickable(false);
            this.E.setClickable(false);
            intent.setPackage(this.f76143d.getPackageName());
            this.f76143d.sendBroadcast(intent);
            ReportController.o(null, "CliOper", "", "", "not_disturb", "0X8009E94", 0, 0, "", "", "", "");
            return;
        }
        if (id5 == R.id.f163665rc2) {
            long d17 = e.d();
            QLog.w("GaInviteFloatBar", 1, "onClick reject seq[" + d17 + "]");
            Intent intent2 = new Intent();
            at.f(intent2, d17);
            intent2.setAction("tencent.video.notdisturb.invite.gaignore");
            intent2.setPackage(this.f76143d.getPackageName());
            this.f76143d.sendBroadcast(intent2);
            x();
            ReportController.o(null, "CliOper", "", "", "not_disturb", "0X8009E93", 0, 0, "", "", "", "");
            return;
        }
        QLog.d("GaInviteFloatBar", 1, "onClick other view=" + view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.K;
        if (gestureDetector == null) {
            return true;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void s(final String str) {
        this.F.post(new Runnable() { // from class: com.tencent.av.ui.notdisturb.GaInviteFloatBar.3
            @Override // java.lang.Runnable
            public void run() {
                String format = String.format("\u7fa4\u804a(%s)\u53c2\u4e0e\u901a\u8bdd\u7684\u6709:", str);
                if (str != null) {
                    float width = GaInviteFloatBar.this.F.getWidth();
                    float f16 = 0.0f;
                    if (width > 0.0f && width < GaInviteFloatBar.this.F.getPaint().measureText(format)) {
                        f16 = Layout.getDesiredWidth("\u7fa4\u804a()\u53c2\u4e0e\u901a\u8bdd\u7684\u6709:", GaInviteFloatBar.this.F.getPaint());
                        format = String.format("\u7fa4\u804a(%s)\u53c2\u4e0e\u901a\u8bdd\u7684\u6709:", com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(GaInviteFloatBar.this.F, str, (int) (width - f16)));
                    }
                    QLog.d("GaInviteFloatBar", 1, "genGroupName groupName=" + str + " maxWidth=" + width + "ellipsizeWidth=" + f16 + " originText=" + format);
                }
                GaInviteFloatBar.this.F.setText(format);
            }
        });
    }

    public GradientDrawable w() {
        if (this.M == null) {
            int dimensionPixelSize = this.f76143d.getResources().getDimensionPixelSize(R.dimen.f12918r);
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.M = gradientDrawable;
            gradientDrawable.setShape(1);
            this.M.setColor(Color.parseColor("#F246505F"));
            this.M.setSize(dimensionPixelSize, dimensionPixelSize);
        }
        return this.M;
    }

    public void x() {
        Log.i("GaInviteFloatBar", "hide", new Throwable());
        if (this.f76144e) {
            this.f76144e = false;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("GaInviteFloatBar", 2, "hide removeView start");
                }
                WindowManager windowManager = this.J;
                if (windowManager != null) {
                    windowManager.removeView(this.f76146h);
                }
                this.f76146h = null;
                this.N = null;
                if (QLog.isColorLevel()) {
                    QLog.d("GaInviteFloatBar", 2, "hide removeView end");
                }
                com.tencent.av.ui.part.invite.multi.a.Q9(e.d());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("GaInviteFloatBar", 2, "hide error : " + e16);
                }
            }
        }
    }

    private void q() {
        r(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i3) {
        if (i3 > 0) {
            this.G.setVisibility(0);
            this.H.setText(String.format("%d+", Integer.valueOf(i3)));
            this.H.setVisibility(0);
            this.I.setImageDrawable(w());
            this.I.setVisibility(0);
            return;
        }
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    }

    void y() {
        if (QLog.isColorLevel()) {
            QLog.d("GaInviteFloatBar", 2, "initTN");
        }
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f76145f = layoutParams;
            layoutParams.height = -2;
            layoutParams.width = -1;
            layoutParams.flags = 2098088;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2010;
            }
            layoutParams.format = -3;
            layoutParams.flags = 2098088 | 67108864;
            layoutParams.gravity = 49;
            layoutParams.y = (int) (ImmersiveUtils.getStatusBarHeight(this.f76143d) + ba.dp2px(this.f76143d, 10.0f));
            this.f76145f.width = u();
            WindowManager.LayoutParams layoutParams2 = this.f76145f;
            this.Q = layoutParams2.width;
            layoutParams2.height = t();
            this.f76145f.windowAnimations = R.style.f243390o;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBar", 2, "startHandler addView start");
            }
            this.J.addView(this.f76146h, this.f76145f);
            this.f76144e = true;
            ReportController.o(null, "CliOper", "", "", "not_disturb", "0X8009E92", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBar", 2, "startHandler addView end");
            }
        } catch (WindowManager.BadTokenException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBar", 2, "startHandler error : " + e17);
            }
        } catch (IllegalStateException e18) {
            this.J.updateViewLayout(this.f76146h, this.f76145f);
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBar", 2, "startHandler error : " + e18);
            }
        } catch (SecurityException e19) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBar", 2, "startHandler error : " + e19);
            }
        } catch (Exception e26) {
            AVCoreLog.printErrorLog("GaInviteFloatBar", "startHandler error : " + e26);
        }
    }
}
