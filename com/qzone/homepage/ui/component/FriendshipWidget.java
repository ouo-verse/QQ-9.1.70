package com.qzone.homepage.ui.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.business.vip.IntimacyRequest;
import com.qzone.misc.network.report.ClickReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;
import vo.c;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FriendshipWidget {

    /* renamed from: a, reason: collision with root package name */
    private Context f47688a;

    /* renamed from: b, reason: collision with root package name */
    private View f47689b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f47690c;

    /* renamed from: d, reason: collision with root package name */
    private String f47691d;

    /* renamed from: e, reason: collision with root package name */
    private long f47692e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f47693f;

    /* renamed from: g, reason: collision with root package name */
    private x6.a f47694g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47695h = true;

    /* renamed from: i, reason: collision with root package name */
    private long f47696i = 0;

    /* renamed from: j, reason: collision with root package name */
    private View.OnClickListener f47697j = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(FriendshipWidget.this.f47691d)) {
                if (FriendshipWidget.this.f47693f) {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 2, 2, "1");
                } else {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 2, 2);
                    ClickReport.e(1, "getActiveFeeds", 308, 17);
                }
                c.k(FriendshipWidget.this.f47688a, FriendshipWidget.this.f47691d, FriendshipWidget.this.f47692e);
                com.qzone.misc.network.report.a.h();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FriendshipWidget(Context context, boolean z16) {
        this.f47688a = context;
        this.f47693f = z16;
    }

    private void g() {
        x6.a aVar = this.f47694g;
        if (aVar != null) {
            if (aVar.isLimitRelationship() && this.f47693f) {
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 2, 1, "1");
            } else {
                if (this.f47694g.isLimitRelationship() || this.f47693f) {
                    return;
                }
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 2, 1);
            }
        }
    }

    public View e() {
        Context context = this.f47688a;
        if (context == null) {
            return null;
        }
        View view = this.f47689b;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.bjj, (ViewGroup) null);
        this.f47689b = inflate;
        this.f47690c = (TextView) inflate.findViewById(R.id.hil);
        this.f47689b.setOnClickListener(this.f47697j);
        return this.f47689b;
    }

    public void f() {
        if (this.f47695h) {
            this.f47695h = false;
        } else {
            j(this.f47694g);
        }
    }

    public void i(x6.a aVar, long j3) {
        if (aVar == null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("FriendshipWidget", 2, "BussinessUserInfoData is null");
                return;
            }
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("FriendshipWidget", 2, "isBothFriend: " + aVar.isBothFriend + "\t friendship: " + aVar.friendship + "\t jumpUrl:" + aVar.friendshipJumpUrl);
        }
        if (h(aVar) && this.f47689b != null) {
            if (aVar.isSameFriendShip(this.f47694g)) {
                j(aVar);
                return;
            }
            this.f47694g = aVar;
            this.f47691d = aVar.friendshipJumpUrl;
            this.f47692e = j3;
            this.f47689b.setVisibility(0);
            g();
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewScore", "\u4eb2\u5bc6\u5ea6");
            this.f47690c.setText(config + " " + String.valueOf(aVar.friendship));
            if (aVar.friendship > QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_HOMEPAGE_FREINDSHIP_THRESHOLD, 70)) {
                this.f47690c.setTextColor(-13056);
                this.f47690c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.g4a, 0, 0, 0);
            } else {
                this.f47690c.setTextColor(-1);
                this.f47690c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.g4_, 0, 0, 0);
            }
            j(aVar);
            return;
        }
        View view = this.f47689b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static boolean h(x6.a aVar) {
        return aVar != null && aVar.isBothFriend;
    }

    private void j(final x6.a aVar) {
        if (aVar == null || aVar.uin <= 0 || this.f47690c == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - this.f47696i) < 3000) {
            return;
        }
        this.f47696i = uptimeMillis;
        final WeakReference weakReference = new WeakReference(this.f47690c);
        Runnable runnable = new Runnable() { // from class: com.qzone.homepage.ui.component.FriendshipWidget.1

            /* compiled from: P */
            /* renamed from: com.qzone.homepage.ui.component.FriendshipWidget$1$a */
            /* loaded from: classes39.dex */
            class a implements IntimacyRequest.b {
                a() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.qzone.business.vip.IntimacyRequest.b
                public void a(Drawable drawable) {
                    TextView textView = (TextView) weakReference.get();
                    if (textView == null) {
                        return;
                    }
                    textView.setBackground(drawable);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.nwx, 0, 0, 0);
                    drawable.setCallback(textView);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IntimacyRequest.c(aVar.uin, new a());
            }
        };
        if (VasToggle.BUG_103975707.isEnable(true)) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }
}
