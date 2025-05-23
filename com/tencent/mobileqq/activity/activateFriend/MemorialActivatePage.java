package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes9.dex */
public class MemorialActivatePage extends ActivateBasePage implements View.OnClickListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name */
    private static final String f177856f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final String f177857g0;

    /* renamed from: h0, reason: collision with root package name */
    private static String f177858h0;

    /* renamed from: i0, reason: collision with root package name */
    private static String f177859i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final String f177860j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final int f177861k0;
    private IFaceDecoder C;
    private AnyScaleTypeImageView D;
    private AnyScaleTypeImageView E;
    private AnyScaleTypeImageView F;
    private AnyScaleTypeImageView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private ImageView L;
    private ImageView M;
    private LetterSpacingTextView N;
    private LetterSpacingTextView P;
    private LetterSpacingTextView Q;
    String R;
    String S;
    int T;
    long U;
    String V;
    String W;

    /* renamed from: a0, reason: collision with root package name */
    String f177862a0;

    /* renamed from: b0, reason: collision with root package name */
    String f177863b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f177864c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f177865d0;

    /* renamed from: e0, reason: collision with root package name */
    int f177866e0;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f177867m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f177856f0 = HardCodeUtil.qqStr(R.string.nzm);
        f177857g0 = HardCodeUtil.qqStr(R.string.nzo);
        f177858h0 = "https://h5.qzone.qq.com/friend/day/%1$s/%2$s/friendDay?_wv=3&_proxy=1";
        f177859i0 = "https://h5.qzone.qq.com/lover/memosAct?_wv=1027&_proxy=1";
        f177860j0 = HardCodeUtil.qqStr(R.string.nzp);
        f177861k0 = ViewUtils.dpToPx(346.0f);
    }

    public MemorialActivatePage(Context context, QQAppInterface qQAppInterface, int i3, String str, int i16, String str2, String str3, String str4, String str5, int i17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, Integer.valueOf(i3), str, Integer.valueOf(i16), str2, str3, str4, str5, Integer.valueOf(i17));
            return;
        }
        this.f177867m = qQAppInterface;
        this.T = i3;
        this.R = str;
        long j3 = i16;
        this.U = j3;
        this.V = str2;
        this.W = str3;
        this.f177862a0 = str4;
        this.f177866e0 = i17;
        this.U = (j3 / 86400) * 86400;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.U * 1000);
        Calendar calendar2 = Calendar.getInstance();
        long currentTimeMillis = System.currentTimeMillis();
        calendar2.setTimeInMillis(currentTimeMillis);
        if (QLog.isColorLevel()) {
            QLog.d("MemorialActivatePage", 2, "time=" + calendar.toString());
        }
        String format = String.format(context.getString(R.string.f6c), Integer.valueOf(Math.abs(calendar2.get(1) - calendar.get(1))));
        this.f177863b0 = format + str5;
        if (this.C == null) {
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
            this.C = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }
        Bitmap bitmapFromCache = this.C.getBitmapFromCache(1, str);
        if (bitmapFromCache != null) {
            this.M.setImageBitmap(bitmapFromCache);
        } else if (!this.C.isPausing()) {
            this.C.requestDecodeFace(str, 1, true, (byte) 0);
        }
        Bitmap bitmapFromCache2 = this.C.getBitmapFromCache(1, qQAppInterface.getCurrentAccountUin());
        if (bitmapFromCache2 != null) {
            this.L.setImageBitmap(bitmapFromCache2);
        } else if (!this.C.isPausing()) {
            this.C.requestDecodeFace(this.f177867m.getCurrentAccountUin(), 1, true, (byte) 0);
        }
        this.N.setSpacing(0.75f);
        this.N.setText(format);
        int intValue = new Long(Math.abs(currentTimeMillis - (this.U * 1000)) / 86400000).intValue();
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_friend_info_text", f177856f0);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(intValue);
        objArr[1] = HardCodeUtil.qqStr(i17 == 1 ? R.string.nzn : R.string.nzq);
        String format2 = String.format(config, objArr);
        this.P.setSpacing(0.3f);
        this.P.setText(format2);
        this.H.setText(String.format("%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))));
        QQAppInterface qQAppInterface2 = this.f177867m;
        this.I.setText(com.tencent.mobileqq.utils.ac.H(qQAppInterface2, qQAppInterface2.getCurrentAccountUin()));
        this.J.setText(com.tencent.mobileqq.utils.ac.H(this.f177867m, str));
        if (this.T == 1) {
            this.S = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_friend", f177858h0), this.f177867m.getCurrentAccountUin(), this.R);
        } else {
            this.S = String.format(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_url_activate_lover", f177859i0), this.f177867m.getCurrentAccountUin(), this.R);
        }
        this.Q.setSpacing(0.8f);
        this.Q.setText(QzoneConfig.getInstance().getConfig("QZoneSetting", "key_text_activate_more_btn", f177857g0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        i(this.f177779e.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = i18 - i16;
        if (i28 - i26 != i29) {
            i(i29);
        }
    }

    private void i(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f177865d0.getLayoutParams();
        layoutParams.height = Math.min(f177861k0, (int) (i3 * 0.55f));
        this.f177865d0.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        View findViewById = this.f177779e.findViewById(R.id.z2r);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.kva);
        }
        this.N.setTextColor(-1);
        this.P.setTextColor(-1);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        View inflate = this.f177778d.inflate(R.layout.aqn, (ViewGroup) this, false);
        this.f177779e = inflate;
        AnyScaleTypeImageView anyScaleTypeImageView = (AnyScaleTypeImageView) inflate.findViewById(R.id.f166228ep4);
        this.D = anyScaleTypeImageView;
        if (anyScaleTypeImageView != null) {
            anyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.D.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_mcZzfPOOYR.png");
        }
        AnyScaleTypeImageView anyScaleTypeImageView2 = (AnyScaleTypeImageView) this.f177779e.findViewById(R.id.ep5);
        this.E = anyScaleTypeImageView2;
        if (anyScaleTypeImageView2 != null) {
            anyScaleTypeImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.E.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_cqHXaEsvc6.png");
        }
        AnyScaleTypeImageView anyScaleTypeImageView3 = (AnyScaleTypeImageView) this.f177779e.findViewById(R.id.epd);
        this.F = anyScaleTypeImageView3;
        if (anyScaleTypeImageView3 != null) {
            anyScaleTypeImageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.F.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_x6ZlQshbMQ.png");
        }
        AnyScaleTypeImageView anyScaleTypeImageView4 = (AnyScaleTypeImageView) this.f177779e.findViewById(R.id.f166227ep3);
        this.G = anyScaleTypeImageView4;
        if (anyScaleTypeImageView4 != null) {
            anyScaleTypeImageView4.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.G.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20190121165942_WTb508Bouk.png");
        }
        this.f177779e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.H = (TextView) this.f177779e.findViewById(R.id.jl7);
        this.N = (LetterSpacingTextView) this.f177779e.findViewById(R.id.djw);
        this.P = (LetterSpacingTextView) this.f177779e.findViewById(R.id.djx);
        this.L = (ImageView) this.f177779e.findViewById(R.id.imv);
        this.M = (ImageView) this.f177779e.findViewById(R.id.cnt);
        this.I = (TextView) this.f177779e.findViewById(R.id.imx);
        this.J = (TextView) this.f177779e.findViewById(R.id.coa);
        LetterSpacingTextView letterSpacingTextView = (LetterSpacingTextView) this.f177779e.findViewById(R.id.kwg);
        this.Q = letterSpacingTextView;
        letterSpacingTextView.setOnClickListener(this);
        this.f177780f = (TextView) this.f177779e.findViewById(R.id.f163953dg);
        this.K = (TextView) this.f177779e.findViewById(R.id.ljt);
        LinearLayout linearLayout = (LinearLayout) this.f177779e.findViewById(R.id.mfc);
        this.f177864c0 = linearLayout;
        linearLayout.setOnClickListener(this);
        boolean z16 = true;
        if (QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftEnable", 1) != 1) {
            z16 = false;
        }
        if (z16) {
            this.f177864c0.setVisibility(0);
        } else {
            this.f177864c0.setVisibility(8);
        }
        String config = QzoneConfig.getInstance().getConfig("qqsetting", "QQSendFriendsMemorialDayGiftText", f177860j0);
        if (!TextUtils.isEmpty(config)) {
            this.K.setText(config);
        }
        this.f177865d0 = this.f177779e.findViewById(R.id.z2q);
        this.f177779e.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.q
            @Override // java.lang.Runnable
            public final void run() {
                MemorialActivatePage.this.g();
            }
        });
        this.f177779e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.activateFriend.r
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                MemorialActivatePage.this.h(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        addView(this.f177779e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            LpReportInfo_pf00064.allReport(220, 4, 1);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.C;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        super.destroy();
    }

    public void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        this.f177780f.setText(en.d(getContext(), 3, j3));
        ReportController.o(this.f177867m, "dc00898", "", "", "0X8007AD6", "0X8007AD6", this.T, 0, "", "", "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.kwg) {
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", this.S);
                intent.putExtra("injectrecommend", true);
                intent.setData(Uri.parse(this.S));
                getContext().startActivity(intent);
                ReportController.o(this.f177867m, "dc00898", "", "", "0X8007AD7", "0X8007AD7", this.T, 0, "", "", "", "");
                LpReportInfo_pf00064.allReport(220, 4, 2);
                QZoneLoginReportHelper.reportLoginFromActivateFriend();
            } else if (id5 == R.id.mfc) {
                String str2 = this.R;
                String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(System.currentTimeMillis()));
                String config = QzoneConfig.getInstance().getConfig("H5Url", "SendFriendsMemorialDayGiftUrl", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
                if (!TextUtils.isEmpty(config)) {
                    str = config.replace("{to_uin}", str2 + "_" + format);
                } else {
                    str = null;
                }
                Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str);
                getContext().startActivity(intent2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (!this.C.isPausing()) {
            if (str.equalsIgnoreCase(this.f177867m.getCurrentAccountUin())) {
                this.L.setImageBitmap(bitmap);
            } else if (this.R.equalsIgnoreCase(str)) {
                this.M.setImageBitmap(bitmap);
            }
        }
    }
}
