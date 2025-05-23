package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.e;
import com.tencent.mobileqq.qqexpand.utils.i;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientFootView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientTextView;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

/* loaded from: classes35.dex */
public class ProfileCardExtendFriendView extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    private static boolean D0 = false;
    private int A0;
    private ProfileContentTitleView B0;
    protected ExtendFriendGradientTextView C;
    private boolean C0;
    protected ImageView D;
    protected TextView E;
    protected TextView F;
    protected TextView G;
    protected OldExpandVoiceView H;
    public LinearLayout I;
    public TextView J;
    private LayoutInflater K;
    private String L;
    private boolean M;
    private boolean N;
    private boolean P;
    private Context Q;
    private Card R;
    private LinearLayout S;
    private LinearLayout T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f264013a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f264014b0;

    /* renamed from: c0, reason: collision with root package name */
    private FrameLayout f264015c0;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f264016d;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f264017d0;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f264018e;

    /* renamed from: e0, reason: collision with root package name */
    private ExtendFriendGradientFootView f264019e0;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f264020f;

    /* renamed from: f0, reason: collision with root package name */
    private Paint f264021f0;

    /* renamed from: g0, reason: collision with root package name */
    private Bitmap f264022g0;

    /* renamed from: h, reason: collision with root package name */
    protected ImageView f264023h;

    /* renamed from: h0, reason: collision with root package name */
    private RectF f264024h0;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f264025i;

    /* renamed from: i0, reason: collision with root package name */
    private float f264026i0;

    /* renamed from: j0, reason: collision with root package name */
    private GradientDrawable f264027j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f264028k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f264029l0;

    /* renamed from: m, reason: collision with root package name */
    protected LinearLayout f264030m;

    /* renamed from: m0, reason: collision with root package name */
    private ProfileCardTemplate f264031m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQAppInterface f264032n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f264033o0;

    /* renamed from: p0, reason: collision with root package name */
    private VasRes f264034p0;

    /* renamed from: q0, reason: collision with root package name */
    private ActionSheet f264035q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f264036r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f264037s0;

    /* renamed from: t0, reason: collision with root package name */
    int f264038t0;

    /* renamed from: u0, reason: collision with root package name */
    int f264039u0;

    /* renamed from: v0, reason: collision with root package name */
    int f264040v0;

    /* renamed from: w0, reason: collision with root package name */
    int f264041w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f264042x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f264043y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f264044z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (ProfileCardExtendFriendView.this.f264042x0) {
                if (ProfileCardExtendFriendView.this.f264042x0 && ProfileCardExtendFriendView.this.f264043y0 && ProfileCardExtendFriendView.this.f264044z0 == 0 && ProfileCardExtendFriendView.this.A0 == 0) {
                    int i29 = i18 - i16;
                    int i36 = i28 - i26;
                    ProfileCardExtendFriendView.this.A0 = Math.max(i29, i36);
                    ProfileCardExtendFriendView.this.f264044z0 = Math.min(i29, i36);
                    ProfileCardExtendFriendView.this.removeOnLayoutChangeListener(this);
                    ProfileCardExtendFriendView.this.o();
                    return;
                }
                return;
            }
            ProfileCardExtendFriendView.this.removeOnLayoutChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Card f264049d;

        c(Card card) {
            this.f264049d = card;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            long j3 = this.f264049d.authState;
            if (j3 == 1) {
                QQToast.makeText(ProfileCardExtendFriendView.this.getContext(), 0, R.string.x6s, 1).show();
            } else if (j3 == 0 || j3 == 3) {
                Activity activity = (Activity) ProfileCardExtendFriendView.this.Q;
                Card card = this.f264049d;
                CampusHelper.e(activity, card.idx, card.schoolName, card.schoolId);
            }
        }
    }

    public ProfileCardExtendFriendView(Context context) {
        super(context);
        this.W = false;
        this.f264013a0 = true;
        this.f264036r0 = false;
        this.f264037s0 = false;
        this.f264038t0 = -16777216;
        this.f264039u0 = -1;
        this.f264042x0 = false;
        this.f264043y0 = false;
        this.f264044z0 = 0;
        this.A0 = 0;
        this.B0 = null;
        this.Q = context;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ExtendFriendGradientTextView extendFriendGradientTextView = this.C;
        if (extendFriendGradientTextView != null) {
            this.W = true;
            if (this.f264042x0 && this.f264044z0 != 0 && this.B0 != null) {
                extendFriendGradientTextView.setFold(!true);
                this.B0.updateViewHeight(this.f264044z0);
            } else {
                extendFriendGradientTextView.setFold(true);
                this.f264043y0 = true;
            }
            this.f264019e0.setVisibility(0);
            this.D.setRotation(0.0f);
            ImageView imageView = this.D;
            imageView.setPadding(imageView.getPaddingLeft(), BaseAIOUtils.f(6.0f, getResources()), this.D.getPaddingRight(), BaseAIOUtils.f(16.0f, getResources()));
        }
    }

    private void p() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.K = from;
        View inflate = from.inflate(R.layout.f167379d04, (ViewGroup) this, true);
        this.f264014b0 = inflate;
        this.f264016d = (TextView) inflate.findViewById(R.id.p27);
        this.f264018e = (TextView) this.f264014b0.findViewById(R.id.p2a);
        this.f264020f = (TextView) this.f264014b0.findViewById(R.id.p28);
        this.f264023h = (ImageView) this.f264014b0.findViewById(R.id.f163228p02);
        this.f264025i = (LinearLayout) this.f264014b0.findViewById(R.id.p06);
        this.f264030m = (LinearLayout) this.f264014b0.findViewById(R.id.p07);
        ExtendFriendGradientTextView extendFriendGradientTextView = (ExtendFriendGradientTextView) this.f264014b0.findViewById(R.id.p26);
        this.C = extendFriendGradientTextView;
        extendFriendGradientTextView.setCardView(this);
        ImageView imageView = (ImageView) this.f264014b0.findViewById(R.id.f163229p03);
        this.D = imageView;
        imageView.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f264014b0.findViewById(R.id.oz7);
        this.I = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.oz8);
        this.J = textView;
        textView.setOnClickListener(this);
        OldExpandVoiceView oldExpandVoiceView = (OldExpandVoiceView) this.f264014b0.findViewById(R.id.f163227p01);
        this.H = oldExpandVoiceView;
        oldExpandVoiceView.f264299e = true;
        oldExpandVoiceView.setMode(2);
        this.H.setOnClickListener(this);
        this.H.setActivity((QBaseActivity) this.Q);
        TextView textView2 = (TextView) this.f264014b0.findViewById(R.id.p2_);
        this.E = textView2;
        textView2.setOnClickListener(this);
        this.F = (TextView) this.f264014b0.findViewById(R.id.p2b);
        this.G = (TextView) this.f264014b0.findViewById(R.id.p29);
        this.T = (LinearLayout) this.f264014b0.findViewById(R.id.oyy);
        this.f264015c0 = (FrameLayout) this.f264014b0.findViewById(R.id.ozd);
        this.f264017d0 = (ImageView) this.f264014b0.findViewById(R.id.p0_);
        this.f264019e0 = (ExtendFriendGradientFootView) this.f264014b0.findViewById(R.id.oze);
        View findViewById = this.f264014b0.findViewById(R.id.p2h);
        int f16 = (getResources().getDisplayMetrics().widthPixels / 2) - BaseAIOUtils.f(38.0f, getResources());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = f16;
        layoutParams.leftMargin = BaseAIOUtils.f(10.0f, getResources());
        findViewById.setLayoutParams(layoutParams);
        this.S = (LinearLayout) this.f264014b0.findViewById(R.id.p2h);
        this.f264026i0 = BaseAIOUtils.f(3.0f, getResources());
        addOnLayoutChangeListener(new a());
    }

    private void q() {
        Context context = this.Q;
        if (context instanceof QBaseActivity) {
            AllInOne allInOne = (AllInOne) ((QBaseActivity) context).getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
            if (allInOne != null && allInOne.f260789pa == 96 && this.C0) {
                this.Q.sendBroadcast(new Intent("com.tencent.mobileqq.search.finish"));
                ((QBaseActivity) this.Q).finish();
            } else {
                ((IExpandEntrance) QRoute.api(IExpandEntrance.class)).enterExpand(this.Q, this.f264032n0, 5);
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("6");
            }
        }
    }

    private void r() {
        String str;
        String[] strArr;
        String[] strArr2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 2;
        if (!TextUtils.isEmpty(this.L) && this.L.contains(ContainerUtils.KEY_VALUE_DELIMITER) && (strArr = e.f264089b) != null && strArr.length > 0 && (strArr2 = e.f264091d) != null && strArr2.length > 0) {
            str = strArr[this.L.substring(this.L.indexOf(61) + 1).toUpperCase().charAt(0) % strArr2.length];
        } else {
            str = "expand_summary_bg.png";
        }
        Bitmap a16 = e.a(e.e(str), options);
        if (a16 != null) {
            this.f264022g0 = com.tencent.mobileqq.qqexpand.utils.a.a(getResources(), a16, -2565928, 0.2f, false);
        } else {
            this.f264022g0 = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
            new Canvas(this.f264022g0).drawColor(-1);
        }
    }

    private void s(int i3) {
        float f16 = this.f264026i0;
        this.f264027j0 = i.a(i3, f16, f16, f16, f16);
    }

    private void v() {
        ProfileContentTitleView profileContentTitleView;
        ExtendFriendGradientTextView extendFriendGradientTextView = this.C;
        if (extendFriendGradientTextView != null) {
            this.W = false;
            extendFriendGradientTextView.setFold(false);
            if (this.f264042x0 && this.f264044z0 != 0 && (profileContentTitleView = this.B0) != null) {
                profileContentTitleView.updateViewHeight(this.A0);
            }
            this.f264019e0.setVisibility(8);
            this.D.setRotation(180.0f);
            ImageView imageView = this.D;
            imageView.setPadding(imageView.getPaddingLeft(), BaseAIOUtils.f(16.0f, getResources()), this.D.getPaddingRight(), BaseAIOUtils.f(6.0f, getResources()));
        }
    }

    private void w(View view, boolean z16, boolean z17) {
        int f16;
        float width;
        if (this.f264029l0 <= 0 || this.f264028k0 <= 0) {
            return;
        }
        if (this.f264024h0 == null) {
            this.f264024h0 = new RectF();
        }
        if (!this.M && this.P) {
            if (this.N) {
                f16 = BaseAIOUtils.f(20.0f, getResources());
            } else {
                f16 = BaseAIOUtils.f(44.0f, getResources());
            }
        } else {
            f16 = BaseAIOUtils.f(10.0f, getResources());
        }
        this.f264024h0.set(0, 0.0f, this.f264028k0 - 0, this.f264029l0 - f16);
        if (z16) {
            if (z17) {
                s(872415231);
                this.D.setImageResource(R.drawable.gf6);
                this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.gfb), (Drawable) null);
            } else {
                s(-1711276033);
            }
        } else if (z17) {
            this.D.setImageResource(R.drawable.gf8);
            this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.gfd), (Drawable) null);
            s(184549375);
        } else {
            if (this.f264021f0 == null) {
                Paint paint = new Paint(1);
                this.f264021f0 = paint;
                paint.setStyle(Paint.Style.FILL);
                this.f264021f0.setAntiAlias(true);
            }
            r();
            Bitmap bitmap = this.f264022g0;
            if (bitmap == null) {
                s(869849304);
                width = 1.0f;
            } else {
                width = this.f264028k0 / bitmap.getWidth();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(width, width);
            Bitmap bitmap2 = this.f264022g0;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            this.f264021f0.setShader(bitmapShader);
        }
        GradientDrawable gradientDrawable = this.f264027j0;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(0, 0, this.f264028k0 - 0, this.f264029l0 - f16);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f264017d0.getLayoutParams();
        layoutParams.width = this.f264028k0 - 0;
        layoutParams.height = this.f264029l0 - f16;
        this.f264017d0.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint;
        RectF rectF = this.f264024h0;
        if (rectF != null && (paint = this.f264021f0) != null && !this.f264042x0) {
            float f16 = this.f264026i0;
            canvas.drawRoundRect(rectF, f16, f16, paint);
        } else {
            GradientDrawable gradientDrawable = this.f264027j0;
            if (gradientDrawable != null) {
                gradientDrawable.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void m(Card card, QQAppInterface qQAppInterface) {
        String format;
        String str;
        this.R = card;
        this.f264016d.setText(String.format("%d", Integer.valueOf(card.popularity)));
        this.f264032n0 = qQAppInterface;
        QLog.d("BusinessCard_CardHandler", 1, "handleGetSummaryCard--vExtendCard 111 popularity=" + this.f264016d + " declaration=" + card.declaration + " voiceUrl=" + card.voiceUrl + " updateTime=" + card.updateTime + " duration=" + this.f264033o0 + "fontId = " + card.fontId + "fontType = " + card.fontType + "clothesId= " + card.clothesId);
        String str2 = this.C.O0;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = card.declaration;
        if (str3 != null && !str2.equals(str3)) {
            y(false);
            this.C.setContent(card.declaration);
        }
        this.P = ExpandChatUtil.C(qQAppInterface);
        this.L = card.voiceUrl;
        boolean equals = card.uin.equals(qQAppInterface.getCurrentAccountUin());
        this.M = equals;
        if (equals) {
            format = getContext().getString(R.string.x6y);
            this.f264015c0.setOnClickListener(this);
            this.f264015c0.setOnTouchListener(this);
        } else {
            format = String.format(getContext().getString(R.string.x6x), ((com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).z());
            this.f264015c0.setOnClickListener(this);
        }
        if (!TextUtils.isEmpty(this.L)) {
            this.S.setVisibility(0);
            this.H.setVoiceDuration(card.extendFriendVoiceDuration);
            this.f264033o0 = card.extendFriendVoiceDuration;
            this.H.setVoiceUrl(this.L);
        } else {
            this.S.setVisibility(8);
        }
        w(this.f264014b0, this.U, this.V);
        this.J.setText(format);
        if (!this.M && this.P) {
            if (this.N) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
        } else {
            this.I.setVisibility(8);
        }
        n(card, qQAppInterface);
        this.f264019e0.setColor(this.f264039u0);
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            setClothes(card.clothesId);
            setFont(card.fontId, card.fontType);
        }
        if (!this.f264037s0 && !this.f264036r0) {
            str = "1";
        } else {
            str = "2";
        }
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_show", "", 0, "", str);
    }

    public void n(final Card card, QQAppInterface qQAppInterface) {
        if (!TextUtils.isEmpty(card.schoolName) && !TextUtils.isEmpty(card.schoolId)) {
            this.f264025i.setVisibility(0);
            this.f264020f.setText(ProfileCardUtil.c0(card.schoolName, false, card.authState == 2 ? R.drawable.gez : R.drawable.f159764gf2, R.dimen.f10732v, R.dimen.f10722u, getContext(), qQAppInterface, this.M ? new c(card) : null));
            this.f264020f.setMovementMethod(LinkMovementMethod.getInstance());
            this.f264030m.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.4

                /* renamed from: com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView$4$a */
                /* loaded from: classes35.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        long j3 = card.authState;
                        if (j3 == 1) {
                            QQToast.makeText(ProfileCardExtendFriendView.this.getContext(), 0, R.string.x6s, 1).show();
                        } else if (j3 == 0 || j3 == 3) {
                            Activity activity = (Activity) ProfileCardExtendFriendView.this.Q;
                            Card card = card;
                            CampusHelper.e(activity, card.idx, card.schoolName, card.schoolId);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ProfileCardExtendFriendView profileCardExtendFriendView = ProfileCardExtendFriendView.this;
                    if (al.c(profileCardExtendFriendView.f264020f, profileCardExtendFriendView.f264030m.getWidth()) > 4) {
                        ProfileCardExtendFriendView.this.f264020f.setText(card.schoolName);
                        ProfileCardExtendFriendView.this.f264023h.setImageResource(card.authState == 2 ? R.drawable.gez : R.drawable.f159764gf2);
                        ProfileCardExtendFriendView.this.f264023h.setVisibility(0);
                        if (ProfileCardExtendFriendView.this.M) {
                            ProfileCardExtendFriendView.this.f264023h.setOnClickListener(new a());
                            return;
                        }
                        return;
                    }
                    ProfileCardExtendFriendView.this.f264023h.setVisibility(8);
                }
            });
            return;
        }
        this.f264025i.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VasRes vasRes = this.f264034p0;
        if (vasRes != null) {
            vasRes.recycle();
        }
        this.f264034p0 = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f264028k0 = i3;
        this.f264029l0 = i16;
        View view = this.f264014b0;
        if (view != null) {
            w(view, this.U, this.V);
        }
        invalidate();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f264017d0.setVisibility(0);
        } else if (action == 1 || action == 3) {
            this.f264017d0.setVisibility(8);
        }
        return false;
    }

    public void setDiyCard(boolean z16) {
        this.f264042x0 = z16;
    }

    public void setFold(boolean z16) {
        this.f264013a0 = z16;
    }

    public void setFromExtendFriend(boolean z16) {
        this.C0 = z16;
    }

    public void setIsFromLimitChat(boolean z16) {
        this.N = z16;
        if (this.M || !this.P) {
            this.I.setVisibility(8);
        } else if (z16) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
        }
    }

    public void setProfileCardFavorShowView(ProfileContentTitleView profileContentTitleView) {
        this.B0 = profileContentTitleView;
    }

    public void t() {
        OldExpandVoiceView oldExpandVoiceView = this.H;
        if (oldExpandVoiceView != null) {
            oldExpandVoiceView.p();
        }
    }

    public void u() {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        if (!D0) {
            Card r16 = ((FriendsManager) this.f264032n0.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f264032n0.getCurrentAccountUin());
            if (r16 != null && r16.declaration == null) {
                ((com.tencent.mobileqq.qqexpand.network.e) this.f264032n0.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.f264032n0.getCurrentAccountUin(), false);
            }
            D0 = false;
        }
        if (this.C == null) {
            return;
        }
        if (this.f264035q0 == null) {
            ActionSheet create = ActionSheet.create(this.Q);
            this.f264035q0 = create;
            create.addCancelButton(R.string.x6o);
            if (this.f264037s0) {
                this.f264035q0.addButton(R.string.x6z);
            }
            if (this.f264036r0) {
                this.f264035q0.addButton(R.string.f169715x70);
            }
            if (!this.f264036r0 && !this.f264037s0) {
                this.f264035q0.addButton(R.string.f169716x71);
            }
            this.f264035q0.setOnButtonClickListener(new b());
        }
        if (!((QBaseActivity) this.Q).isFinishing()) {
            this.f264035q0.show();
        }
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_click", "", 0, "", "");
    }

    public void x(ITemplateUtils iTemplateUtils) {
        ProfileCardTemplate profileCardTemplate = this.f264031m0;
        if (profileCardTemplate != null) {
            iTemplateUtils.updateViewAttr(this.E, "color", profileCardTemplate, "commonItemContentColor");
            iTemplateUtils.updateViewAttr(this.G, "color", profileCardTemplate, "commonItemContentColor");
            iTemplateUtils.updateViewAttr(this.F, "color", profileCardTemplate, "commonItemContentColor");
            iTemplateUtils.updateViewAttr(this.f264016d, "color", profileCardTemplate, "commonItemContentColor");
            iTemplateUtils.updateViewAttr(this.f264018e, "color", profileCardTemplate, "commonItemContentColor");
            iTemplateUtils.updateViewAttr(this.f264020f, "color", profileCardTemplate, "commonItemContentColor");
            Object obj = profileCardTemplate.templateAttr.get("commonItemContentColor");
            if (obj != null) {
                if (obj instanceof ColorStateList) {
                    this.C.setTextColor(((ColorStateList) obj).getDefaultColor());
                    return;
                } else {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.startsWith("#")) {
                            this.C.setTextColor(Color.parseColor(str));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.V) {
            this.E.setTextColor(getResources().getColor(R.color.skin_black));
            this.G.setTextColor(getResources().getColor(R.color.skin_black));
            this.F.setTextColor(getResources().getColor(R.color.skin_black));
            this.C.setTextColor(getResources().getColor(R.color.skin_black));
            this.f264016d.setTextColor(getResources().getColor(R.color.skin_black));
            this.f264018e.setTextColor(getResources().getColor(R.color.skin_black));
            this.f264020f.setTextColor(getResources().getColor(R.color.skin_black));
        }
    }

    public void z(boolean z16, boolean z17) {
        Card q16 = ((FriendsManager) this.f264032n0.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.f264032n0.getCurrentAccountUin());
        Intent intent = new Intent();
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo(q16);
        if (z16) {
            extendFriendInfo.D = this.f264040v0;
            extendFriendInfo.F = true;
        }
        if (z17) {
            extendFriendInfo.E = this.f264041w0;
            extendFriendInfo.G = true;
        }
        intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
        ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity) this.Q, intent, 4097);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.oz8) {
            if (this.M) {
                Intent intent = new Intent();
                if (this.R != null) {
                    ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo(this.R);
                    extendFriendInfo.f263496m = this.f264040v0;
                    extendFriendInfo.C = this.f264041w0;
                    intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
                }
                if (this.Q instanceof Activity) {
                    ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
                    ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity) this.Q, intent, 4097);
                    return;
                }
                return;
            }
            boolean C = ExpandChatUtil.C(this.f264032n0);
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardExtendFriendView", 2, "click extend_friend_more_text showEntry = " + C);
            }
            if (C) {
                ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092E5", "0X80092E5", this.C0 ? 1 : 2, 0, "", "", "", "");
                q();
                return;
            }
            return;
        }
        if (view.getId() == R.id.f163227p01) {
            if (this.H.j()) {
                this.H.p();
                return;
            }
            if (this.M) {
                ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092E4", "0X80092E4", ((this.f264033o0 - 1) / 10) + 1, 0, "", "", "", "");
            }
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#zl_voice", true, -1L, -1L, null, true, true);
            this.H.l();
            return;
        }
        if (view.getId() == R.id.f163229p03) {
            if (this.W) {
                v();
                return;
            } else {
                o();
                return;
            }
        }
        if (view.getId() == R.id.p2_) {
            if (this.M) {
                ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
            }
            Intent intent2 = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
            getContext().startActivity(intent2);
            return;
        }
        if (view.getId() == R.id.ozd) {
            if (this.M) {
                Intent intent3 = new Intent();
                if (this.R != null) {
                    ExtendFriendInfo extendFriendInfo2 = new ExtendFriendInfo(this.R);
                    extendFriendInfo2.f263496m = this.f264040v0;
                    extendFriendInfo2.C = this.f264041w0;
                    intent3.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo2);
                }
                if (this.Q instanceof Activity) {
                    ReportController.o(this.f264032n0, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
                    ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity) this.Q, intent3, 4097);
                    return;
                }
                return;
            }
            u();
        }
    }

    public void setETTextColorFromClothes(SignatureTemplateInfo signatureTemplateInfo) {
        String str;
        if (signatureTemplateInfo != null && !TextUtils.isEmpty(signatureTemplateInfo.fontColor)) {
            int parseColor = Color.parseColor(signatureTemplateInfo.fontColor);
            this.f264038t0 = parseColor;
            ExtendFriendGradientTextView extendFriendGradientTextView = this.C;
            if (extendFriendGradientTextView != null && parseColor != 0) {
                extendFriendGradientTextView.setTextColor(parseColor);
            }
        }
        if (signatureTemplateInfo == null || (str = signatureTemplateInfo.backgroundColor) == null || TextUtils.isEmpty(str)) {
            return;
        }
        int parseColor2 = Color.parseColor(signatureTemplateInfo.backgroundColor);
        this.f264039u0 = parseColor2;
        this.f264019e0.setColor(parseColor2);
        if (QQTheme.isColorDark(this.f264039u0)) {
            this.f264016d.setTextColor(-1);
            this.E.setTextColor(-1);
            this.F.setTextColor(-1);
            this.G.setTextColor(-1);
            this.f264018e.setTextColor(-1);
            this.f264020f.setTextColor(-1);
            return;
        }
        this.f264016d.setTextColor(-16777216);
        this.E.setTextColor(-16777216);
        this.F.setTextColor(-16777216);
        this.G.setTextColor(-16777216);
        this.f264018e.setTextColor(-16777216);
        this.f264020f.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (!ProfileCardExtendFriendView.this.f264037s0 || ProfileCardExtendFriendView.this.f264036r0) {
                if (ProfileCardExtendFriendView.this.f264037s0 || !ProfileCardExtendFriendView.this.f264036r0) {
                    if (ProfileCardExtendFriendView.this.f264036r0 && ProfileCardExtendFriendView.this.f264037s0) {
                        if (i3 == 0) {
                            ProfileCardExtendFriendView.this.z(false, true);
                            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
                        } else if (i3 == 1) {
                            ProfileCardExtendFriendView.this.z(true, false);
                            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
                        }
                    } else if (!ProfileCardExtendFriendView.this.f264037s0 && !ProfileCardExtendFriendView.this.f264036r0 && i3 == 0) {
                        ProfileCardExtendFriendView.this.z(false, false);
                        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "3");
                    }
                } else if (i3 == 0) {
                    ProfileCardExtendFriendView.this.z(true, false);
                    VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
                }
            } else if (i3 == 0) {
                ProfileCardExtendFriendView.this.z(false, true);
                VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
            }
            VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "4");
            ProfileCardExtendFriendView.this.f264035q0.cancel();
        }
    }

    public void y(boolean z16) {
        if (z16) {
            this.D.setVisibility(0);
            this.f264019e0.setVisibility(0);
            LinearLayout linearLayout = this.T;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), this.T.getPaddingTop(), this.T.getPaddingRight(), 0);
            if (this.f264013a0) {
                o();
                return;
            } else {
                v();
                return;
            }
        }
        if (z16 || this.D.getVisibility() == 0) {
            return;
        }
        ExtendFriendGradientTextView extendFriendGradientTextView = this.C;
        extendFriendGradientTextView.P0 = null;
        extendFriendGradientTextView.Q0 = false;
        extendFriendGradientTextView.setMaxLines(50);
        this.D.setVisibility(8);
        this.f264019e0.setVisibility(8);
        LinearLayout linearLayout2 = this.T;
        linearLayout2.setPadding(linearLayout2.getPaddingLeft(), this.T.getPaddingTop(), this.T.getPaddingRight(), BaseAIOUtils.f(16.0f, getResources()));
    }

    public ProfileCardExtendFriendView(Context context, ProfileCardTemplate profileCardTemplate, boolean z16) {
        super(context);
        this.W = false;
        this.f264013a0 = true;
        this.f264036r0 = false;
        this.f264037s0 = false;
        this.f264038t0 = -16777216;
        this.f264039u0 = -1;
        this.f264042x0 = false;
        this.f264043y0 = false;
        this.f264044z0 = 0;
        this.A0 = 0;
        this.B0 = null;
        this.Q = context;
        this.U = profileCardTemplate != null;
        this.V = z16;
        this.f264031m0 = profileCardTemplate;
        p();
    }

    public void setClothes(int i3) {
    }

    public void setFont(int i3, int i16) {
    }
}
