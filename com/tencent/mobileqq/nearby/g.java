package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.nearby.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$Text;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$WarnMsg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class g implements Manager, com.tencent.mobileqq.nearby.c {

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f252586d;

    /* renamed from: e, reason: collision with root package name */
    protected c.C8137c f252587e = new c.C8137c();

    /* renamed from: f, reason: collision with root package name */
    protected HashMap<Long, c.a> f252588f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    protected HashSet<String> f252589h = new HashSet<>();

    /* renamed from: i, reason: collision with root package name */
    protected boolean f252590i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f252591m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f252592d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f252593e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.d f252594f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f252595h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f252596i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Activity f252597m;

        a(boolean z16, String str, c.d dVar, QQAppInterface qQAppInterface, String str2, Activity activity) {
            this.f252592d = z16;
            this.f252593e = str;
            this.f252594f = dVar;
            this.f252595h = qQAppInterface;
            this.f252596i = str2;
            this.f252597m = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f252592d) {
                g.this.g();
            } else {
                g.this.f();
            }
            if (g.this.n()) {
                g.this.q(Long.valueOf(this.f252593e).longValue(), 0, 1);
                this.f252594f.a(this.f252593e, false);
                ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.f252595h, "pay_like", this.f252593e, this.f252596i, "", "", "");
            } else {
                g.this.p(this.f252597m, this.f252596i);
                ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.f252595h, "exp_pay", this.f252596i);
            }
            ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.f252595h, "clk_no_warm", this.f252596i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f252598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f252599e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f252600f;

        b(Activity activity, QQAppInterface qQAppInterface, String str) {
            this.f252598d = activity;
            this.f252599e = qQAppInterface;
            this.f252600f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            c.C8137c c8137c = g.this.f252587e;
            if (c8137c != null && !TextUtils.isEmpty(c8137c.f252568d)) {
                Intent intent = new Intent(this.f252598d, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", c8137c.f252568d);
                this.f252598d.startActivity(intent);
            }
            ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.f252599e, "clk_up", this.f252600f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f252602d;

        c(Activity activity) {
            this.f252602d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            c.C8137c c8137c = g.this.f252587e;
            if (c8137c == null || TextUtils.isEmpty(c8137c.f252567c)) {
                return;
            }
            Intent intent = new Intent(this.f252602d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", c8137c.f252567c);
            this.f252602d.startActivityForResult(intent, 1028);
        }
    }

    public g(QQAppInterface qQAppInterface) {
        this.f252590i = true;
        this.f252591m = true;
        this.f252586d = qQAppInterface;
        String charSequence = DateFormat.format(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, System.currentTimeMillis()).toString();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0);
        this.f252590i = !sharedPreferences.getString("over_people_limit_tip_show_date" + qQAppInterface.getCurrentAccountUin(), "").equals(charSequence);
        this.f252591m = !sharedPreferences.getString("over_one_limit_tip_show_date" + qQAppInterface.getCurrentAccountUin(), "").equals(charSequence);
    }

    @Override // com.tencent.mobileqq.nearby.c
    public synchronized void a(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z16) {
            this.f252589h.remove(str);
        } else {
            this.f252589h.add(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "setNeedUpdateProfileCardFlag, key=" + str + ", isNeedUpdate=" + z16);
        }
    }

    @Override // com.tencent.mobileqq.nearby.c
    public synchronized void b(int i3, int i16, int i17) {
        c.C8137c c8137c = this.f252587e;
        if (c8137c != null) {
            c8137c.f252565a = i3;
            c8137c.f252570f = i16;
            c8137c.f252571g = i17;
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, level=" + i3 + ", freeLikePeopleLimit=" + i16 + ", freeLikeOneLimit=" + i17);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.c
    public synchronized void c(Object obj, List<Object> list, int i3) {
        this.f252587e = (c.C8137c) obj;
        if (i3 == 511) {
            this.f252588f.clear();
        }
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                c.a aVar = (c.a) it.next();
                this.f252588f.put(Long.valueOf(aVar.f252553a), aVar);
                if (QLog.isColorLevel()) {
                    sb5.append(aVar);
                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, mLimitInfo=" + this.f252587e + ", mLikeItemMap=[" + ((Object) sb5) + "]");
        }
    }

    @Override // com.tencent.mobileqq.nearby.c
    public synchronized boolean d(long j3) {
        c.a aVar = this.f252588f.get(Long.valueOf(j3));
        if (this.f252587e != null && aVar != null) {
            return aVar.f252555c > 0;
        }
        return false;
    }

    public void f() {
        String charSequence = DateFormat.format(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, System.currentTimeMillis()).toString();
        String str = "over_one_limit_tip_show_date" + this.f252586d.getCurrentAccountUin();
        BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str, charSequence).commit();
        this.f252591m = false;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "disableShowOverOneLimitTip, key=" + str);
        }
    }

    public void g() {
        String charSequence = DateFormat.format(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, System.currentTimeMillis()).toString();
        String str = "over_people_limit_tip_show_date" + this.f252586d.getCurrentAccountUin();
        BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str, charSequence).commit();
        this.f252590i = false;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "disableShowOverPeopleLimitTip, key=" + str);
        }
    }

    public SpannableString h() {
        Object obj;
        c.C8137c c8137c = this.f252587e;
        if (c8137c == null || (obj = c8137c.f252569e) == null) {
            return null;
        }
        return o(((oidb_0x8e7$WarnMsg) obj).rpt_msg_zan_limit_info.get());
    }

    public SpannableString i() {
        Object obj;
        c.C8137c c8137c = this.f252587e;
        if (c8137c == null || (obj = c8137c.f252569e) == null) {
            return null;
        }
        return o(((oidb_0x8e7$WarnMsg) obj).rpt_msg_user_num_limit_info.get());
    }

    public boolean j() {
        c.C8137c c8137c;
        boolean z16 = (!this.f252591m || (c8137c = this.f252587e) == null || c8137c.f252569e == null) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverOneLimitTip, ret=" + z16);
        }
        return z16;
    }

    public boolean k() {
        c.C8137c c8137c;
        boolean z16 = (!this.f252590i || (c8137c = this.f252587e) == null || c8137c.f252569e == null) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverPeopleLimitTip, ret=" + z16);
        }
        return z16;
    }

    public synchronized boolean l(long j3) {
        c.a aVar = this.f252588f.get(Long.valueOf(j3));
        c.C8137c c8137c = this.f252587e;
        boolean z16 = true;
        if (c8137c != null && aVar != null) {
            if (aVar.f252554b < c8137c.f252571g) {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "isOVerFreeLikeOneLimit, uin=" + j3 + ", ret=" + z16);
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isOVerFreeLikeOneLimit, mLimitInfo isNull=");
            sb5.append(this.f252587e == null);
            sb5.append(", item isNull=");
            if (aVar != null) {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", uin=");
            sb5.append(j3);
            sb5.append(", return false");
            QLog.d("NearbyLikeLimitManager", 2, sb5.toString());
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r0.f252573i >= r0.f252570f) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m(long j3) {
        boolean z16 = false;
        if (this.f252587e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, mLimitInfo==null, return false, uin=" + j3);
            }
            return false;
        }
        c.a aVar = this.f252588f.get(Long.valueOf(j3));
        if (aVar == null) {
            c.C8137c c8137c = this.f252587e;
        } else {
            c.C8137c c8137c2 = this.f252587e;
            if (c8137c2.f252573i >= c8137c2.f252570f && aVar.f252555c > 0 && aVar.f252554b == 0) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, ret=" + z16 + ", uin=" + j3);
            }
            return z16;
        }
    }

    public synchronized boolean n() {
        c.C8137c c8137c = this.f252587e;
        boolean z16 = true;
        if (c8137c == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, mLimitInfo == null, return true");
            }
            return true;
        }
        if (c8137c.f252572h < c8137c.f252566b) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, ret=" + z16);
        }
        return z16;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        synchronized (this) {
            this.f252587e = null;
            this.f252588f.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    public synchronized void q(long j3, int i3, int i16) {
        if (this.f252587e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyLikeLimitManager", 2, "updateItem, mLimitInfo == null, return");
            }
            return;
        }
        c.a aVar = this.f252588f.get(Long.valueOf(j3));
        if (aVar != null) {
            aVar.f252554b += i3;
            aVar.f252555c += i16;
            aVar.f252556d += this.f252587e.f252566b * i16;
            this.f252588f.put(Long.valueOf(j3), aVar);
            c.C8137c c8137c = this.f252587e;
            c8137c.f252572h -= c8137c.f252566b * i16;
        } else if (i3 > 0 || i16 > 0) {
            aVar = new c.a();
            aVar.f252553a = j3;
            aVar.f252554b += i3;
            aVar.f252555c += i16;
            aVar.f252556d += this.f252587e.f252566b * i16;
            this.f252588f.put(Long.valueOf(j3), aVar);
            c.C8137c c8137c2 = this.f252587e;
            c8137c2.f252573i++;
            c8137c2.f252572h -= c8137c2.f252566b * i16;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateItem, key=");
            sb5.append(j3);
            sb5.append(", freeLikeCount=");
            sb5.append(i3);
            sb5.append(", payLikeCount=");
            sb5.append(i16);
            sb5.append(", hasLikeBefore=");
            sb5.append(aVar != null);
            QLog.d("NearbyLikeLimitManager", 2, sb5.toString());
        }
        a(j3 + "", true);
    }

    protected void p(Activity activity, String str) {
        DialogUtil.createCustomDialog(activity, 230).setTitle(HardCodeUtil.qqStr(R.string.oh7)).setMessage(HardCodeUtil.qqStr(R.string.f172228oh3)).setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new d()).setPositiveButton(HardCodeUtil.qqStr(R.string.f172229oh4), new c(activity)).show();
    }

    private SpannableString o(List<oidb_0x8e7$Text> list) {
        SpannableString spannableString = null;
        if (list != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<oidb_0x8e7$Text> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().bytes_context.get().toStringUtf8());
            }
            if (sb5.length() == 0) {
                return null;
            }
            spannableString = new SpannableString(sb5.toString());
            int i3 = 0;
            for (oidb_0x8e7$Text oidb_0x8e7_text : list) {
                int length = oidb_0x8e7_text.bytes_context.get().toStringUtf8().length();
                if (oidb_0x8e7_text.uint32_color.has()) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(String.format("#%x", Integer.valueOf(oidb_0x8e7_text.uint32_color.get())))), i3, i3 + length, 33);
                }
                i3 += length;
            }
        }
        return spannableString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
    
        if (k() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r1 = i();
        ((com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil.class)).report(r11, "exp_uv_limit", r24);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0 A[Catch: all -> 0x013f, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0017, B:7:0x0044, B:11:0x0063, B:16:0x0075, B:18:0x007b, B:21:0x00b0, B:22:0x00fb, B:24:0x0101, B:25:0x012c, B:27:0x0090, B:29:0x0096), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fb A[Catch: all -> 0x013f, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0017, B:7:0x0044, B:11:0x0063, B:16:0x0075, B:18:0x007b, B:21:0x00b0, B:22:0x00fb, B:24:0x0101, B:25:0x012c, B:27:0x0090, B:29:0x0096), top: B:3:0x0009 }] */
    @Override // com.tencent.mobileqq.nearby.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(Activity activity, Object obj, String str, Object obj2, String str2) {
        SpannableString spannableString;
        boolean z16;
        QQAppInterface qQAppInterface = (QQAppInterface) obj;
        c.d dVar = (c.d) obj2;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "checkCanDoVote, uin=" + str + ", from=" + str2 + ", mLimitInfo=" + this.f252587e);
        }
        boolean m3 = m(Long.valueOf(str).longValue());
        boolean l3 = l(Long.valueOf(str).longValue());
        if (!m3 && !l3) {
            q(Long.valueOf(str).longValue(), 1, 0);
            dVar.a(str, true);
        }
        if (l3 && j()) {
            SpannableString h16 = h();
            ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(qQAppInterface, "exp_pv_limit", str2);
            spannableString = h16;
            z16 = true;
            if (!z16) {
            }
        } else {
            spannableString = null;
            z16 = false;
            if (!z16) {
                QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(activity, 0, null, spannableString, HardCodeUtil.qqStr(R.string.oh6), HardCodeUtil.qqStr(R.string.f172227oh2), HardCodeUtil.qqStr(R.string.j6l), new a(m3, str, dVar, qQAppInterface, str2, activity), new b(activity, qQAppInterface, str2));
                createVerticalThreeBtnDialog.getBtnLeft().setTextColor(-14698765);
                createVerticalThreeBtnDialog.show();
            } else if (n()) {
                q(Long.valueOf(str).longValue(), 0, 1);
                dVar.a(str, false);
                ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(qQAppInterface, "pay_like", str, str2, "", "", "");
            } else {
                p(activity, str2);
                ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).report(qQAppInterface, "exp_pay_like", str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
