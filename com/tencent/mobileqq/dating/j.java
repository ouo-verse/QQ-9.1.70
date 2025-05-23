package com.tencent.mobileqq.dating;

import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.SingleLineTextView;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j extends AnimateUtils.AnimationAdapter implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static final int[] T;
    private static Typeface U;
    private int C;
    private int D;
    private double E;
    public MqqHandler F;
    private Animation G;
    private Animation H;
    private AppInterface I;
    public boolean J;
    public boolean K;
    public b L;
    public List<TPraiseInfo> M;
    public boolean N;
    public boolean P;
    private Random Q;
    private int R;
    private int S;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.hotchat.ui.b f203433d;

    /* renamed from: e, reason: collision with root package name */
    private int f203434e;

    /* renamed from: f, reason: collision with root package name */
    private int f203435f;

    /* renamed from: h, reason: collision with root package name */
    private int f203436h;

    /* renamed from: i, reason: collision with root package name */
    private int f203437i;

    /* renamed from: m, reason: collision with root package name */
    private int f203438m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements PraiseManager.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f203439d;

        a(int i3) {
            this.f203439d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
        public void M0(int i3, com.tencent.mobileqq.profile.like.d dVar, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), dVar, Integer.valueOf(i16), str);
            } else if (j.this.F.hasMessages(0)) {
                j.this.F.removeMessages(0);
                j.this.F.obtainMessage(0, this.f203439d, 0).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f203441a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f203442b;

        /* renamed from: c, reason: collision with root package name */
        public View f203443c;

        /* renamed from: d, reason: collision with root package name */
        public RelativeLayout f203444d;

        /* renamed from: e, reason: collision with root package name */
        public HeartLayout f203445e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean a(View view, TextView textView, View view2, RelativeLayout relativeLayout, HeartLayout heartLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, textView, view2, relativeLayout, heartLayout)).booleanValue();
            }
            if (this.f203441a == view && this.f203442b == textView && this.f203443c == view2 && this.f203444d == relativeLayout && this.f203445e == heartLayout) {
                return true;
            }
            return false;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f203441a != null && this.f203442b != null && this.f203443c != null) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            T = new int[]{10, 25, 45, 60, 75, 100};
        }
    }

    public j(Context context, AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, Integer.valueOf(i3));
            return;
        }
        this.J = false;
        this.K = false;
        this.N = false;
        this.P = false;
        this.R = -1;
        this.S = 0;
        this.F = new ad(Looper.getMainLooper(), this);
        this.I = appInterface;
        this.E = context.getResources().getDisplayMetrics().density;
        this.f203436h = i3;
        this.L = new b();
    }

    public static String c(int i3) {
        DecimalFormat decimalFormat;
        if (i3 / 10000 >= 1.0d) {
            if (i3 % 10000 > 1000) {
                decimalFormat = new DecimalFormat("#.#");
            } else {
                decimalFormat = new DecimalFormat("#");
            }
            return decimalFormat.format(i3 / 10000.0f) + HardCodeUtil.qqStr(R.string.orp);
        }
        return String.valueOf(i3);
    }

    private void e(TextView textView) {
        try {
            if (U == null) {
                U = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
            }
            textView.setTypeface(U);
        } catch (Exception e16) {
            QLog.e("NewVoteAnimHelper", 1, "setTypeFace wrong: " + e16);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(boolean z16, boolean z17, int i3) {
        ViewGroup.LayoutParams layoutParams;
        int i16;
        int i17;
        int i18;
        String valueOf;
        if (!this.L.b()) {
            return;
        }
        if (this.f203436h == 1) {
            b bVar = this.L;
            RelativeLayout relativeLayout = bVar.f203444d;
            if (relativeLayout != null) {
                layoutParams = relativeLayout.getLayoutParams();
            } else {
                layoutParams = bVar.f203443c.getLayoutParams();
            }
        } else {
            layoutParams = null;
        }
        if (!z16) {
            this.L.f203441a.setVisibility(8);
            this.L.f203442b.setVisibility(8);
            i18 = this.f203437i;
            if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = 0;
            }
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.L.f203441a.getLayoutParams();
            if (z17) {
                int i19 = this.f203436h;
                if (i19 == 0) {
                    marginLayoutParams.topMargin = (int) (this.E * 7.0d);
                } else if (i19 == 1) {
                    marginLayoutParams.topMargin = 0;
                    marginLayoutParams.rightMargin = (int) ((this.E * 3.0d) + 0.5d);
                } else if (i19 == 2) {
                    if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) marginLayoutParams).addRule(15, 0);
                    }
                    marginLayoutParams.leftMargin = 0;
                }
                double d16 = this.E;
                marginLayoutParams.width = (int) ((d16 * 6.0d) + 0.5d);
                marginLayoutParams.height = (int) ((d16 * 6.0d) + 0.5d);
                this.L.f203442b.setVisibility(8);
                i17 = this.f203437i;
                if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = 0;
                }
                i16 = R.drawable.skin_tips_dot_small;
            } else {
                int i26 = this.f203436h;
                if (i26 == 0) {
                    marginLayoutParams.topMargin = 0;
                } else {
                    if (i26 == 1) {
                        marginLayoutParams.topMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    } else if (i26 == 2) {
                        if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) marginLayoutParams).addRule(15);
                        }
                        marginLayoutParams.leftMargin = x.c(this.I.getApplication(), 4.0f);
                    } else if (i26 == 3) {
                        i16 = R.drawable.h1w;
                        marginLayoutParams.width = -2;
                        marginLayoutParams.height = -2;
                        this.L.f203442b.setVisibility(i3);
                        if (this.S == 2) {
                            this.L.f203442b.setText(Marker.ANY_NON_NULL_MARKER + c(this.f203438m));
                        } else {
                            this.L.f203442b.setText(Marker.ANY_NON_NULL_MARKER + this.f203438m);
                        }
                        i17 = this.f203437i - this.f203438m;
                        if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                            ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) ((this.E * 15.0d) + 0.5d);
                        }
                    }
                    i16 = R.drawable.skin_tips_newmessage;
                    marginLayoutParams.width = -2;
                    marginLayoutParams.height = -2;
                    this.L.f203442b.setVisibility(i3);
                    if (this.S == 2) {
                    }
                    i17 = this.f203437i - this.f203438m;
                    if (layoutParams != null) {
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) ((this.E * 15.0d) + 0.5d);
                    }
                }
                i16 = R.drawable.f162476h20;
                marginLayoutParams.width = -2;
                marginLayoutParams.height = -2;
                this.L.f203442b.setVisibility(i3);
                if (this.S == 2) {
                }
                i17 = this.f203437i - this.f203438m;
                if (layoutParams != null) {
                }
            }
            this.L.f203441a.setBackgroundResource(i16);
            this.L.f203441a.setLayoutParams(marginLayoutParams);
            this.L.f203441a.setVisibility(i3);
            i18 = i17;
        }
        TextView textView = this.L.f203442b;
        if (textView != null && textView.getVisibility() == 0) {
            e(this.L.f203442b);
        }
        if (this.S == 2) {
            valueOf = c(i18);
        } else {
            valueOf = String.valueOf(i18);
        }
        View view = this.L.f203443c;
        if (view instanceof TextView) {
            ((TextView) view).setText(valueOf);
        } else if (view instanceof SingleLineTextView) {
            ((SingleLineTextView) view).setText(valueOf);
        }
        if (layoutParams != null) {
            b bVar2 = this.L;
            RelativeLayout relativeLayout2 = bVar2.f203444d;
            if (relativeLayout2 != null) {
                relativeLayout2.setLayoutParams(layoutParams);
            } else {
                bVar2.f203443c.setLayoutParams(layoutParams);
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d("NewVoteAnimHelper", 4, "updateRedDotView,strVoteNum=" + valueOf + ",mVoteIncrement=" + this.f203438m);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f.j("voteAnim", "endAnim", Integer.valueOf(this.f203434e), Integer.valueOf(this.f203435f));
        if (this.f203434e == 1) {
            int i3 = this.f203435f;
            if (i3 == 2) {
                b();
            } else if (i3 == 0) {
                d();
            } else {
                this.F.removeCallbacksAndMessages(null);
                b();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f.j("voteAnim", "finishAnim");
        this.f203434e = 2;
        this.f203435f = 0;
        if (this.L.b() && !this.P) {
            this.L.f203442b.clearAnimation();
            this.L.f203441a.clearAnimation();
        }
        f(true, false, 0);
        if (!this.J) {
            this.J = true;
            AppInterface appInterface = this.I;
            if (appInterface instanceof INearbyAppInterface) {
                ((INearbyAppInterface) appInterface).reportClickEventAsync("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
            } else {
                com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f.j("voteAnim", "reset");
        this.F.removeCallbacksAndMessages(null);
        this.f203434e = 0;
        this.f203435f = 0;
        if (this.L.b() && !this.P) {
            this.L.f203442b.clearAnimation();
            this.L.f203441a.clearAnimation();
        }
        f(false, false, 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Type inference failed for: r14v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i3, int i16, View view, TextView textView, View view2, RelativeLayout relativeLayout, HeartLayout heartLayout) {
        int i17;
        int i18;
        int i19;
        boolean z16;
        int i26;
        ?? r142;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        boolean z17;
        List<TPraiseInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), view, textView, view2, relativeLayout, heartLayout);
            return;
        }
        if (view != null && textView != null && view2 != null) {
            if (heartLayout != null) {
                this.P = true;
            }
            if (i3 >= 0) {
                i17 = i3;
            } else {
                i17 = this.f203437i;
            }
            if (i16 >= 0) {
                i18 = i16;
            } else {
                i18 = this.f203438m;
            }
            if (i18 > i17) {
                i18 = i17 % 20;
            } else if (i18 < 0) {
                i18 = 0;
            }
            f.j("voteAnim", "updateVoteNum", Integer.valueOf(i3), Integer.valueOf(i16));
            if (i18 <= 0) {
                if (this.f203434e != 0) {
                    d();
                }
            } else if (this.f203437i == i17 && this.f203438m == i18) {
                if (this.f203434e == 2 && (this.K || this.N)) {
                    this.f203434e = 3;
                }
            } else {
                if (this.f203434e == 1) {
                    i19 = i17;
                    i26 = i18;
                    z16 = true;
                    if (this.L.a(view, textView, view2, relativeLayout, heartLayout)) {
                        this.C = i3;
                        this.D = i16;
                        if (this.P && !VersionUtils.isHoneycomb()) {
                            d();
                            return;
                        } else {
                            if (!this.F.hasMessages(1)) {
                                this.F.sendEmptyMessageDelayed(1, 3000L);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    i19 = i17;
                    z16 = true;
                    i26 = i18;
                }
                d();
                r142 = z16;
                Object[] objArr = new Object[6];
                objArr[0] = "updateVoteNum";
                objArr[r142] = Integer.valueOf(this.f203437i);
                objArr[2] = Integer.valueOf(this.f203438m);
                objArr[3] = Integer.valueOf(this.f203434e);
                objArr[4] = Integer.valueOf(i19);
                objArr[5] = Integer.valueOf(i26);
                f.j("voteAnim", objArr);
                this.f203437i = i19;
                i27 = this.f203438m;
                i28 = i26;
                if (i28 - i27 <= 0) {
                    i29 = i28 - i27;
                } else {
                    i29 = 0;
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("NewVoteAnimHelper", 4, "voteAnim_voteAnim,mVoteIncrement=" + this.f203438m + ",increment=" + i28 + ",voteIncrementDelta=" + i29);
                }
                this.f203438m = i28;
                b bVar = this.L;
                bVar.f203443c = view2;
                bVar.f203444d = relativeLayout;
                bVar.f203442b = textView;
                bVar.f203441a = view;
                bVar.f203445e = heartLayout;
                com.tencent.mobileqq.hotchat.ui.b.d(heartLayout);
                i36 = this.f203434e;
                if (i36 == 0) {
                    if (i36 != 2) {
                        if (i36 == 3) {
                            f(r142, r142, 0);
                            return;
                        }
                        return;
                    }
                    f(r142, false, 0);
                    return;
                }
                if (this.f203438m > 0) {
                    if (this.N) {
                        f(r142, r142, 0);
                        return;
                    }
                    if (this.P) {
                        i37 = 0;
                    } else {
                        i37 = 4;
                    }
                    f(r142, false, i37);
                    if (this.P && (i29 <= 0 || !VersionUtils.isHoneycomb())) {
                        z17 = false;
                    } else {
                        z17 = r142;
                    }
                    if (z17) {
                        this.F.removeMessages(0);
                        Message obtainMessage = this.F.obtainMessage(0, i29, 0);
                        long j3 = 1000;
                        if (this.P && (list = this.M) != null && !list.isEmpty()) {
                            PraiseManager praiseManager = (PraiseManager) this.I.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
                            HashSet hashSet = new HashSet();
                            Iterator<TPraiseInfo> it = this.M.iterator();
                            while (it.hasNext()) {
                                long j16 = it.next().uCustomId;
                                if (j16 > 0) {
                                    hashSet.add(Integer.valueOf((int) j16));
                                }
                            }
                            if (praiseManager.e(hashSet, new a(i29))) {
                                this.F.sendMessageDelayed(obtainMessage, 1000L);
                            } else {
                                this.F.sendMessageDelayed(obtainMessage, com.tencent.mobileqq.profile.like.c.f260226e);
                            }
                        } else {
                            MqqHandler mqqHandler = this.F;
                            if (!this.P) {
                                j3 = 1500;
                            }
                            mqqHandler.sendMessageDelayed(obtainMessage, j3);
                        }
                        this.f203434e = r142;
                        this.f203435f = 0;
                        return;
                    }
                    return;
                }
                f(false, false, 8);
                return;
            }
            i19 = i17;
            r142 = 1;
            i26 = i18;
            Object[] objArr2 = new Object[6];
            objArr2[0] = "updateVoteNum";
            objArr2[r142] = Integer.valueOf(this.f203437i);
            objArr2[2] = Integer.valueOf(this.f203438m);
            objArr2[3] = Integer.valueOf(this.f203434e);
            objArr2[4] = Integer.valueOf(i19);
            objArr2[5] = Integer.valueOf(i26);
            f.j("voteAnim", objArr2);
            this.f203437i = i19;
            i27 = this.f203438m;
            i28 = i26;
            if (i28 - i27 <= 0) {
            }
            if (QLog.isDebugVersion()) {
            }
            this.f203438m = i28;
            b bVar2 = this.L;
            bVar2.f203443c = view2;
            bVar2.f203444d = relativeLayout;
            bVar2.f203442b = textView;
            bVar2.f203441a = view;
            bVar2.f203445e = heartLayout;
            com.tencent.mobileqq.hotchat.ui.b.d(heartLayout);
            i36 = this.f203434e;
            if (i36 == 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0141  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        float f16;
        long j3;
        int compoundPaddingLeft;
        com.tencent.mobileqq.profile.like.d dVar;
        int i3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        float f17 = 0.0f;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        int i17 = message.arg1;
                        if (i17 > 0) {
                            int[] iArr = new int[2];
                            b bVar = this.L;
                            RelativeLayout relativeLayout = bVar.f203444d;
                            if (relativeLayout != null) {
                                relativeLayout.getLocationInWindow(iArr);
                                if (this.L.f203444d.findViewById(R.id.fxu) != null) {
                                    f17 = (r0.getWidth() + this.L.f203444d.getPaddingLeft()) * 0.5f;
                                }
                            } else {
                                bVar.f203443c.getLocationInWindow(iArr);
                                View view = this.L.f203443c;
                                if (view instanceof SingleLineTextView) {
                                    compoundPaddingLeft = ((SingleLineTextView) view).getCompoundPaddingLeft();
                                } else if (view instanceof TextView) {
                                    compoundPaddingLeft = ((TextView) view).getCompoundPaddingLeft();
                                }
                                f17 = compoundPaddingLeft * 0.5f;
                            }
                            float f18 = f17 + iArr[0];
                            if (this.f203433d == null) {
                                this.f203433d = new com.tencent.mobileqq.hotchat.ui.b(this.I.getApplication(), R.drawable.f5m);
                            }
                            List<TPraiseInfo> list = this.M;
                            Bitmap bitmap = null;
                            if (list != null && i17 - 1 < list.size()) {
                                List<TPraiseInfo> list2 = this.M;
                                TPraiseInfo tPraiseInfo = list2.get(list2.size() - i17);
                                if (tPraiseInfo == null) {
                                    j16 = 0;
                                } else {
                                    j16 = tPraiseInfo.uCustomId;
                                }
                                if (j16 > 0) {
                                    dVar = ((PraiseManager) this.I.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).g((int) j16, true, "from_profile_card");
                                    if (dVar != null && (tPraiseInfo.iIsPayed <= 0 || (bitmap = dVar.f260242j) == null)) {
                                        bitmap = dVar.f260240h;
                                    }
                                } else if (tPraiseInfo != null && tPraiseInfo.iIsPayed > 0) {
                                    try {
                                        dVar = null;
                                        bitmap = BitmapFactory.decodeResource(this.I.getApp().getResources(), R.drawable.f161451bs2);
                                    } catch (OutOfMemoryError e16) {
                                        QLog.e("NewVoteAnimHelper", 1, e16, new Object[0]);
                                    }
                                }
                                if (bitmap == null) {
                                    bitmap = this.f203433d.e();
                                }
                                this.L.f203445e.e(dVar, bitmap, f18, iArr[1]);
                                i3 = i17 - 1;
                                if (i3 <= 0) {
                                    Message obtainMessage = this.F.obtainMessage(3, i3, 0);
                                    if (this.Q == null) {
                                        this.Q = new Random();
                                    }
                                    int[] iArr2 = T;
                                    int i18 = iArr2[this.Q.nextInt(iArr2.length)];
                                    if (i3 < 10.0d) {
                                        i18 *= 2;
                                    }
                                    this.F.sendMessageDelayed(obtainMessage, i18);
                                } else {
                                    this.F.sendEmptyMessageDelayed(2, 3100L);
                                }
                            }
                            dVar = null;
                            if (bitmap == null) {
                            }
                            this.L.f203445e.e(dVar, bitmap, f18, iArr[1]);
                            i3 = i17 - 1;
                            if (i3 <= 0) {
                            }
                        } else {
                            this.F.sendEmptyMessageDelayed(2, 100L);
                        }
                    }
                } else if (this.f203434e == 1 && this.f203435f == 1) {
                    this.f203435f = 2;
                    b();
                } else {
                    a();
                }
            } else {
                int i19 = this.C;
                int i26 = this.D;
                b bVar2 = this.L;
                g(i19, i26, bVar2.f203441a, bVar2.f203442b, bVar2.f203443c, bVar2.f203444d, bVar2.f203445e);
            }
        } else {
            if (this.f203434e == 1 && this.f203435f == 0 && this.L.b()) {
                this.f203435f = 1;
                if (this.P) {
                    int i27 = message.arg1;
                    if (i27 > 0) {
                        if (i27 > 20) {
                            i27 = 20;
                        }
                        int i28 = this.S;
                        if (i28 != 1 && i28 != 2) {
                            this.F.obtainMessage(3, i27, 0).sendToTarget();
                        } else {
                            if (this.R == -1) {
                                this.R = this.I.getApp().getSharedPreferences(this.I.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.PROFILECARD_HOST_LAST_NEWVOTE_ANIMATION_NUM, 0);
                            }
                            int i29 = this.f203438m;
                            if (i29 > 0 && i29 != this.R) {
                                this.F.obtainMessage(3, i27, 0).sendToTarget();
                                this.R = this.f203438m;
                                this.I.getApp().getSharedPreferences(this.I.getCurrentAccountUin(), 0).edit().putInt(AppConstants.Preferences.PROFILECARD_HOST_LAST_NEWVOTE_ANIMATION_NUM, this.R).commit();
                            }
                        }
                    } else {
                        d();
                    }
                } else {
                    if (this.f203436h == 2) {
                        f16 = 0.5f;
                    } else {
                        f16 = 1.0f;
                    }
                    float f19 = f16;
                    Animation animation = this.G;
                    if (animation == null) {
                        j3 = 400;
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, f16, 1, f19);
                        this.G = scaleAnimation;
                        scaleAnimation.setAnimationListener(this);
                        this.G.setFillEnabled(true);
                        this.G.setFillBefore(true);
                        this.G.setDuration(400L);
                    } else {
                        j3 = 400;
                        animation.reset();
                    }
                    this.L.f203441a.clearAnimation();
                    this.L.f203441a.startAnimation(this.G);
                    Animation animation2 = this.H;
                    if (animation2 == null) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        this.H = alphaAnimation;
                        alphaAnimation.setAnimationListener(this);
                        this.H.setFillEnabled(true);
                        this.H.setFillBefore(true);
                        this.H.setDuration(j3);
                    } else {
                        animation2.reset();
                    }
                    this.L.f203442b.clearAnimation();
                    this.L.f203442b.startAnimation(this.H);
                    this.F.sendEmptyMessageDelayed(2, 1100L);
                }
            } else {
                d();
            }
            f.j("voteAnim", "MSG_ANIM_1", Integer.valueOf(this.f203434e), Integer.valueOf(this.f203435f), this.L);
        }
        return false;
    }

    @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) animation);
            return;
        }
        if (animation != null) {
            Animation animation2 = this.G;
            if (animation == animation2 || animation == this.H) {
                Object[] objArr = new Object[3];
                boolean z17 = false;
                objArr[0] = "end";
                if (animation == animation2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[1] = Boolean.valueOf(z16);
                if (animation == this.H) {
                    z17 = true;
                }
                objArr[2] = Boolean.valueOf(z17);
                f.j("voteAnim", objArr);
                this.F.removeMessages(2);
                if (this.f203435f == 1 && this.f203434e == 1) {
                    this.f203435f = 2;
                    b();
                }
            }
        }
    }

    @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animation);
            return;
        }
        if (animation != null && this.L.b()) {
            if (animation == this.G) {
                f.j("voteAnim", "start", "anim1_1");
                this.L.f203441a.setVisibility(0);
            } else if (animation == this.H) {
                f.j("voteAnim", "start", "anim1_2");
                this.L.f203442b.setVisibility(0);
            }
        }
    }

    public j(Context context, AppInterface appInterface, int i3, int i16) {
        this(context, appInterface, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.S = i16;
        } else {
            iPatchRedirector.redirect((short) 2, this, context, appInterface, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
