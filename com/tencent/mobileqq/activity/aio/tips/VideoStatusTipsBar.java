package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.sdk.util.UinConfigManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VideoStatusTipsBar implements f, View.OnClickListener {
    private LinearLayout C;
    private ImageView[] D;
    private LinearLayout E;
    private ImageView[] F;
    private RefreshMultiStateRunnable G;
    protected float H;

    /* renamed from: d, reason: collision with root package name */
    private final String f180086d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QQAppInterface> f180087e;

    /* renamed from: f, reason: collision with root package name */
    private p f180088f;

    /* renamed from: h, reason: collision with root package name */
    Context f180089h;

    /* renamed from: i, reason: collision with root package name */
    private MqqHandler f180090i;

    /* renamed from: m, reason: collision with root package name */
    private View f180091m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class RefreshMultiStateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<VideoStatusTipsBar> f180092d;

        public RefreshMultiStateRunnable(VideoStatusTipsBar videoStatusTipsBar) {
            this.f180092d = new WeakReference<>(videoStatusTipsBar);
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoStatusTipsBar videoStatusTipsBar = this.f180092d.get();
            if (videoStatusTipsBar != null) {
                videoStatusTipsBar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataReport.Y(false, false);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f180094a = null;

        /* renamed from: b, reason: collision with root package name */
        String f180095b = null;

        b() {
        }
    }

    private int b(int i3) {
        if (i3 == 20 || i3 == 21) {
            return 0;
        }
        if (i3 != 23) {
            return 3;
        }
        return 2;
    }

    private String d(long j3, int i3) {
        AVNotifyCenter.i iVar;
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null && this.f180087e.get().getAVNotifyCenter() != null) {
            iVar = this.f180087e.get().getAVNotifyCenter().Q(j3, i3);
        } else {
            iVar = null;
        }
        if (iVar != null && iVar.b()) {
            return this.f180089h.getString(R.string.fym);
        }
        if (iVar != null && iVar.c()) {
            return this.f180089h.getString(R.string.f170230yr4);
        }
        return this.f180089h.getString(R.string.f170252kb);
    }

    private String f(boolean z16, long j3, int i3, int i16, long j16) {
        AVNotifyCenter.i iVar;
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null && this.f180087e.get().getAVNotifyCenter() != null) {
            iVar = this.f180087e.get().getAVNotifyCenter().Q(j3, i3);
        } else {
            iVar = null;
        }
        if (z16) {
            if (this.f180088f.f179555d == 1) {
                if (iVar != null && iVar.b()) {
                    if (j16 > 99) {
                        return this.f180089h.getString(R.string.fyl);
                    }
                    return String.format(this.f180089h.getString(R.string.fyk), Long.valueOf(j16));
                }
                if (iVar != null && iVar.c()) {
                    if (j16 > 99) {
                        return this.f180089h.getString(R.string.f170254ys2);
                    }
                    return String.format(this.f180089h.getString(R.string.f170230yr4), Long.valueOf(j16));
                }
                return this.f180089h.getString(R.string.f170226jg);
            }
            if (i3 == 2 && j16 > 99) {
                if (iVar != null && iVar.b()) {
                    return this.f180089h.getString(R.string.fyl);
                }
                if (iVar != null && iVar.c()) {
                    return this.f180089h.getString(R.string.f170254ys2);
                }
                return this.f180089h.getString(R.string.f170253kc);
            }
        } else {
            if (this.f180088f.f179555d == 1) {
                if (iVar != null && iVar.b()) {
                    if (j16 > 99) {
                        return this.f180089h.getString(R.string.fyl);
                    }
                    return String.format(this.f180089h.getString(R.string.fyk), Long.valueOf(j16));
                }
                if (iVar != null && iVar.c()) {
                    if (j16 > 99) {
                        return this.f180089h.getString(R.string.f170254ys2);
                    }
                    return String.format(this.f180089h.getString(R.string.f170230yr4), Long.valueOf(j16));
                }
                return this.f180089h.getString(R.string.f170225jf);
            }
            if (i3 == 2 && j16 > 99) {
                if (iVar != null && iVar.b()) {
                    return this.f180089h.getString(R.string.fyl);
                }
                if (iVar != null && iVar.c()) {
                    return this.f180089h.getString(R.string.f170254ys2);
                }
                return this.f180089h.getString(R.string.f170233jl);
            }
        }
        return "";
    }

    private void i() {
        if (this.f180091m == null) {
            cp.c.h();
            View inflate = ((LayoutInflater) this.f180089h.getSystemService("layout_inflater")).inflate(R.layout.f167610bv, (ViewGroup) null);
            this.f180091m = inflate;
            inflate.setId(R.id.f29);
            View view = this.f180091m;
            float f16 = this.H;
            view.setPadding(0, (int) (f16 * 2.0f), 0, (int) (f16 * 2.0f));
            this.f180091m.setClickable(true);
            this.f180091m.setOnClickListener(this);
            this.f180091m.setOnTouchListener(ba.f77070d);
            WeakReference<QQAppInterface> weakReference = this.f180087e;
            if (weakReference != null && !ThemeUtil.isInNightMode(weakReference.get())) {
                this.f180091m.setBackgroundResource(R.drawable.common_tips_bg_white);
            } else {
                this.f180091m.setBackgroundColor(Color.parseColor("#1f1f1f"));
            }
            LinearLayout linearLayout = (LinearLayout) this.f180091m.findViewById(R.id.a3_);
            this.C = linearLayout;
            this.D[0] = (ImageView) linearLayout.findViewById(R.id.a2q);
            this.D[1] = (ImageView) this.C.findViewById(R.id.a2s);
            this.D[2] = (ImageView) this.C.findViewById(R.id.a2u);
            LinearLayout linearLayout2 = (LinearLayout) this.f180091m.findViewById(R.id.a3q);
            this.E = linearLayout2;
            this.F[0] = (ImageView) linearLayout2.findViewById(R.id.a3n);
            this.F[1] = (ImageView) this.E.findViewById(R.id.a3o);
            this.F[2] = (ImageView) this.E.findViewById(R.id.a3p);
        }
    }

    private boolean j() {
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference == null || weakReference.get() == null || !this.f180087e.get().getAVNotifyCenter().e0() || this.f180087e.get().isVideoChatting()) {
            return false;
        }
        DataReport.Y(false, true);
        if (QLog.isColorLevel()) {
            QLog.d(this.f180086d, 2, "startGroupAudio phone is calling!");
        }
        String string = this.f180089h.getString(R.string.dg9);
        DialogUtil.createCustomDialog(this.f180089h, 230, this.f180089h.getString(R.string.dfp), string, R.string.cancel, R.string.f171151ok, new a(), (DialogInterface.OnClickListener) null).show();
        return true;
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), this.f180086d);
    }

    public static void n(QQAppInterface qQAppInterface, Context context, int i3, String str, int i16, boolean z16, String str2) {
        boolean z17;
        long[] jArr;
        if (!NetworkUtil.isNetSupport(context.getApplicationContext())) {
            QQToast.makeText(context, R.string.cgc, 0).show(context.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (str == null) {
            return;
        }
        boolean i06 = qQAppInterface.getAVNotifyCenter().i0(str);
        if (i16 == 2 && !i06) {
            HashMap hashMap = new HashMap();
            hashMap.put("MultiAVType", String.valueOf(2));
            hashMap.put("from", "tipBar");
            GroupVideoEntrance.f360542a.I(qQAppInterface, context, i3, str, hashMap);
            return;
        }
        if (qQAppInterface.getAVNotifyCenter().L() == 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (qQAppInterface.getAVNotifyCenter().h(context, i3, str, z17)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) MultiVideoEnterPageActivity.class);
        intent.addFlags(262144);
        intent.addFlags(268435456);
        if (i3 == 3000) {
            ArrayList<DiscussionMemberInfo> m3 = ((n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(str);
            if (m3 != null) {
                int size = m3.size();
                jArr = new long[size];
                for (int i17 = 0; i17 < size; i17++) {
                    DiscussionMemberInfo discussionMemberInfo = m3.get(i17);
                    if (discussionMemberInfo != null) {
                        jArr[i17] = Long.valueOf(discussionMemberInfo.memberUin).longValue();
                    }
                }
            } else {
                jArr = null;
            }
            intent.putExtra("DiscussUinList", jArr);
        }
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("uin", str);
        intent.putExtra("uinType", i3);
        intent.putExtra("Type", 3);
        intent.putExtra("GroupId", str);
        intent.putExtra("openClass", z16);
        intent.putExtra("MultiAVType", i16);
        intent.putExtra("Fromwhere", str2);
        intent.putExtra("flag", i06);
        if (1 == i3) {
            intent.putExtra("groupInfo", cp.k(qQAppInterface, str));
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.activity.aio.tips.f
    public View a(Object... objArr) {
        return this.f180091m;
    }

    public void c() {
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            this.f180087e.get().getAVNotifyCenter().O0(true);
        }
        p pVar = this.f180088f;
        o("doRefreshMultiState", pVar.f179555d, pVar.f179557e, 0, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        if (r2.length() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        return r2 + com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo.APPNAME_SUFFIX;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String e(Context context, String str, TextView textView, float f16) {
        TextPaint paint = textView.getPaint();
        if (f16 > 0.0f) {
            float measureText = paint.measureText(str);
            if (measureText > f16) {
                float measureText2 = f16 - paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                String str2 = str;
                while (measureText2 > 0.0f && measureText > measureText2 && str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                    measureText = paint.measureText(str2);
                    if (measureText == 0.0f && str2.length() > 0) {
                        measureText = 1.0f + measureText2;
                    }
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public int g() {
        return 2;
    }

    protected Drawable h(String str) {
        QQAppInterface qQAppInterface;
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null) {
            qQAppInterface = weakReference.get();
        } else {
            qQAppInterface = null;
        }
        return FaceDrawable.getUserFaceDrawable(qQAppInterface, str, (byte) 4);
    }

    void l() {
        boolean z16;
        boolean z17;
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f180086d, 4, "onClick_double");
        }
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            QQAppInterface qQAppInterface = this.f180087e.get();
            int i3 = 1;
            if (qQAppInterface.getAVNotifyCenter().L() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (qQAppInterface.getAVNotifyCenter().d0(this.f180088f.f179557e)) {
                if (qQAppInterface.getAVNotifyCenter().C(this.f180088f.f179557e) == 1) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
                    z17 = true;
                } else {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
                    z17 = false;
                }
            } else {
                z17 = z16;
            }
            if (!z17) {
                i3 = 2;
            }
            AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
            Context context = this.f180089h;
            p pVar = this.f180088f;
            if (aVNotifyCenter.g(context, i3, pVar.f179555d, pVar.f179557e)) {
                return;
            }
            Context context2 = this.f180089h;
            p pVar2 = this.f180088f;
            ChatActivityUtils.h0(qQAppInterface, context2, pVar2.f179555d, pVar2.f179557e, pVar2.f179563i, null, z17, pVar2.f179559f, false, true, null, "from_internal");
            ReportController.o(qQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
        }
    }

    void m() {
        int l3;
        boolean z16;
        String str;
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f180086d, 4, "onClick_multi");
        }
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            QQAppInterface qQAppInterface = this.f180087e.get();
            int uinType2AVRelationType = ba.uinType2AVRelationType(this.f180088f.f179555d);
            long parseLong = Long.parseLong(this.f180088f.f179557e);
            HashMap hashMap = new HashMap();
            AVNotifyCenter.i p16 = qQAppInterface.getAVNotifyCenter().p(parseLong);
            boolean z17 = false;
            int i3 = 2;
            if (p16 != null) {
                int i16 = p16.f73810d;
                if (i16 == 2 && p16.f73812f == 2 && p16.f73813g == 4) {
                    z17 = true;
                }
                z16 = z17;
                l3 = i16;
            } else {
                l3 = qQAppInterface.getAVNotifyCenter().l(parseLong);
                z16 = false;
            }
            qQAppInterface.getAVNotifyCenter().B0(9, parseLong, l3);
            hashMap.put("MultiAVType", String.valueOf(l3));
            if (l3 == 2) {
                hashMap.put("Fromwhere", "SmallScreen");
                if (!qQAppInterface.getAVNotifyCenter().i0(this.f180088f.f179557e)) {
                    ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "Clk_video", 0, 0, this.f180088f.f179557e, "" + TroopUtils.j(qQAppInterface, this.f180088f.f179557e), "2", "");
                }
            }
            if (qQAppInterface.getAVNotifyCenter().W(uinType2AVRelationType, parseLong)) {
                if (qQAppInterface.getAVNotifyCenter().A(String.valueOf(parseLong)) == 14) {
                    hashMap.put("from", "tipBar");
                    GroupVideoEntrance groupVideoEntrance = GroupVideoEntrance.f360542a;
                    Context context = this.f180089h;
                    p pVar = this.f180088f;
                    groupVideoEntrance.I(qQAppInterface, context, pVar.f179555d, pVar.f179557e, hashMap);
                } else {
                    Context context2 = this.f180089h;
                    p pVar2 = this.f180088f;
                    ChatActivityUtils.d0(qQAppInterface, context2, pVar2.f179555d, pVar2.f179557e, true, true, null, hashMap);
                }
            } else {
                int M = qQAppInterface.getAVNotifyCenter().M(this.f180088f.f179557e);
                if (M != 4) {
                    i3 = 1;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(this.f180086d, 4, "onClick_multi, sessionType[" + M + "], enterType[" + i3 + "]");
                }
                AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
                Context context3 = this.f180089h;
                p pVar3 = this.f180088f;
                if (!aVNotifyCenter.g(context3, i3, pVar3.f179555d, pVar3.f179557e)) {
                    Context context4 = this.f180089h;
                    p pVar4 = this.f180088f;
                    n(qQAppInterface, context4, pVar4.f179555d, pVar4.f179557e, l3, z16, null);
                }
                if (this.f180088f.f179555d == 1) {
                    if (qQAppInterface.getAVNotifyCenter().l(parseLong) == 10) {
                        ReportController.o(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
                    }
                }
            }
            if (this.f180088f.f179555d == 3000) {
                if (qQAppInterface.getAVNotifyCenter().W(uinType2AVRelationType, parseLong)) {
                    str = "Cover_back";
                } else {
                    str = "Clk_discuss_floating";
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "Multi_call", str, 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x03e1, code lost:
    
        if (r1 == 2) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x06a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0697  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(String str, int i3, String str2, int i16, long j3) {
        int i17;
        long j16;
        long j17;
        int i18;
        int i19;
        long j18;
        int i26;
        int i27;
        int i28;
        long j19;
        int i29;
        long j26;
        AVNotifyCenter.i Q;
        boolean z16;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        int i36;
        QQAppInterface qQAppInterface;
        int i37;
        long j27;
        b q16;
        int i38;
        int i39;
        QQAppInterface qQAppInterface2;
        boolean z17;
        boolean z18;
        TextView textView2;
        int i46;
        Object obj;
        int i47;
        String string;
        String format;
        int i48;
        int i49;
        if (QQAudioHelper.j()) {
            String str3 = this.f180086d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshMultiVideoStatus[");
            sb5.append(str);
            sb5.append("], uinType[");
            sb5.append(i3);
            sb5.append("], uin[");
            sb5.append(str2);
            sb5.append("], type[");
            i17 = i16;
            sb5.append(i17);
            sb5.append("], memberUin[");
            sb5.append(j3);
            sb5.append("], curType[");
            sb5.append(this.f180088f.f179555d);
            sb5.append("]");
            QLog.w(str3, 1, sb5.toString());
        } else {
            i17 = i16;
        }
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            QQAppInterface qQAppInterface3 = this.f180087e.get();
            int i56 = this.f180088f.f179555d;
            if (i56 == 3000 || i56 == 1) {
                try {
                    j16 = Long.parseLong(str2);
                } catch (NumberFormatException unused) {
                    j16 = 0;
                }
                int uinType2AVRelationType = ba.uinType2AVRelationType(this.f180088f.f179555d);
                long y16 = qQAppInterface3.getAVNotifyCenter().y(uinType2AVRelationType, j16);
                Vector<AVNotifyCenter.h> s16 = qQAppInterface3.getAVNotifyCenter().s(j16);
                int l3 = qQAppInterface3.getAVNotifyCenter().l(j16);
                boolean W = qQAppInterface3.getAVNotifyCenter().W(uinType2AVRelationType, j16);
                if (uinType2AVRelationType != 1 || W || str2 == null || !TextUtils.isDigitsOnly(str2)) {
                    j17 = j16;
                } else {
                    try {
                        AVNotifyCenter.i p16 = qQAppInterface3.getAVNotifyCenter().p(Long.parseLong(str2));
                        if (p16 != null) {
                            if (p16.f73810d != 10 || p16.f73809c <= 0) {
                                j17 = j16;
                            } else {
                                j17 = j16;
                                try {
                                    if (System.currentTimeMillis() > p16.f73816j + 90000) {
                                        QLog.w(this.f180086d, 1, "refreshMultiVideoStatus, \u8dd1\u9a6c\u706f\u8d85\u65f6," + p16 + "]");
                                        p16.f73809c = 0;
                                        qQAppInterface3.getAVNotifyCenter().I0(14, uinType2AVRelationType, j17, null, 0L);
                                    }
                                } catch (NumberFormatException e16) {
                                    e = e16;
                                    if (QLog.isColorLevel()) {
                                        i18 = 2;
                                        QLog.e(this.f180086d, 2, "refreshMultiVideoStatus error : " + e);
                                        i19 = i17;
                                        j18 = y16;
                                        i26 = l3;
                                        i27 = 0;
                                        i28 = 10;
                                        if (i26 != i28) {
                                        }
                                        j19 = j17;
                                        qQAppInterface3.getAVNotifyCenter().H0(j19, i26, (int) j18);
                                        if (i26 == i18) {
                                        }
                                        i29 = uinType2AVRelationType;
                                        j26 = 0;
                                        if (j18 > j26) {
                                        }
                                        g();
                                        throw null;
                                    }
                                    i18 = 2;
                                    i19 = i17;
                                    j18 = y16;
                                    i26 = l3;
                                    i27 = 0;
                                    i28 = 10;
                                    if (i26 != i28) {
                                    }
                                    j19 = j17;
                                    qQAppInterface3.getAVNotifyCenter().H0(j19, i26, (int) j18);
                                    if (i26 == i18) {
                                    }
                                    i29 = uinType2AVRelationType;
                                    j26 = 0;
                                    if (j18 > j26) {
                                    }
                                    g();
                                    throw null;
                                }
                            }
                            i17 = b(p16.f73815i);
                            long j28 = p16.f73809c;
                            try {
                                l3 = p16.f73810d;
                                y16 = j28;
                                i49 = 1;
                            } catch (NumberFormatException e17) {
                                e = e17;
                                y16 = j28;
                                if (QLog.isColorLevel()) {
                                }
                                i18 = 2;
                                i19 = i17;
                                j18 = y16;
                                i26 = l3;
                                i27 = 0;
                                i28 = 10;
                                if (i26 != i28) {
                                }
                                j19 = j17;
                                qQAppInterface3.getAVNotifyCenter().H0(j19, i26, (int) j18);
                                if (i26 == i18) {
                                }
                                i29 = uinType2AVRelationType;
                                j26 = 0;
                                if (j18 > j26) {
                                }
                                g();
                                throw null;
                            }
                        } else {
                            j17 = j16;
                            i49 = 0;
                        }
                        j18 = y16;
                        i26 = l3;
                        i28 = 10;
                        i18 = 2;
                        int i57 = i17;
                        i27 = i49;
                        i19 = i57;
                    } catch (NumberFormatException e18) {
                        e = e18;
                        j17 = j16;
                    }
                    if (i26 != i28 || i26 == i18) {
                        j19 = j17;
                        qQAppInterface3.getAVNotifyCenter().H0(j19, i26, (int) j18);
                        if (i26 == i18 || (Q = qQAppInterface3.getAVNotifyCenter().Q(j19, i26)) == null) {
                            i29 = uinType2AVRelationType;
                        } else {
                            i29 = uinType2AVRelationType;
                            qQAppInterface3.getAVNotifyCenter().a1(2, j19, i26, Q.f73812f, Q.f73813g, Q.f73811e, Q.f73809c <= 0 ? 23 : 21, Q.f73809c);
                        }
                        j26 = 0;
                    } else {
                        j19 = j17;
                        j26 = 0;
                        i29 = uinType2AVRelationType;
                    }
                    if (j18 > j26) {
                        if (QLog.isDevelopLevel()) {
                            QLog.w(this.f180086d, 1, "refreshMultiVideoStatus, \u663e\u793a\u8dd1\u9a6c\u706f, memberNum[" + j18 + "], avtype[" + i26 + "], isChating[" + W + "], step[" + i27 + "]");
                        }
                        i();
                        TextView textView3 = (TextView) this.f180091m.findViewById(R.id.jhz);
                        ImageView imageView3 = (ImageView) this.f180091m.findViewById(R.id.d_u);
                        ImageView imageView4 = (ImageView) this.f180091m.findViewById(R.id.d_t);
                        if (W) {
                            i37 = i29;
                            z16 = W;
                            imageView = imageView4;
                            textView = textView3;
                            imageView2 = imageView3;
                            j27 = j19;
                            i36 = i26;
                            qQAppInterface = qQAppInterface3;
                            q16 = p(j3, j19, i26, i19, j18, textView, imageView2);
                        } else {
                            z16 = W;
                            imageView = imageView4;
                            textView = textView3;
                            imageView2 = imageView3;
                            i36 = i26;
                            qQAppInterface = qQAppInterface3;
                            i37 = i29;
                            j27 = j19;
                            q16 = q(i37, j27, i36, j18, textView3);
                        }
                        if (i19 != 1 && i19 != 2) {
                            r(90000L);
                        } else {
                            r(3000L);
                        }
                        int color = this.f180089h.getResources().getColor(R.color.f157969ah3);
                        s(q16.f180095b, q16.f180094a, color, String.valueOf(j27), i36);
                        TextView textView4 = textView;
                        textView4.setTextColor(color);
                        boolean isInNightMode = ThemeUtil.isInNightMode(qQAppInterface);
                        int i58 = i36;
                        if (i58 == 2 && !qQAppInterface.getAVNotifyCenter().i0(str2)) {
                            imageView.setImageDrawable(null);
                            String str4 = this.f180088f.f179557e;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("");
                            QQAppInterface qQAppInterface4 = qQAppInterface;
                            sb6.append(TroopUtils.j(qQAppInterface4, this.f180088f.f179557e));
                            ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "exp_aio", 0, 0, str4, sb6.toString(), "", "");
                            this.C.setVisibility(0);
                            if (s16 != null && s16.size() != 0) {
                                if (s16.size() == 1) {
                                    this.D[0].setVisibility(0);
                                    this.D[1].setVisibility(8);
                                    this.D[2].setVisibility(8);
                                    this.D[0].setImageDrawable(h(String.valueOf(s16.get(0).f73805a)));
                                    z17 = false;
                                    qQAppInterface2 = qQAppInterface4;
                                    z18 = true;
                                    if (!ThemeUtil.isInNightMode(qQAppInterface2)) {
                                    }
                                    t((qQAppInterface2.isVideoChatting() || !z16 || qQAppInterface2.getAVNotifyCenter().N() == 2) ? z18 : z17);
                                    return;
                                }
                                if (s16.size() != 2) {
                                    int i59 = 0;
                                    while (true) {
                                        ImageView[] imageViewArr = this.D;
                                        if (i59 >= imageViewArr.length) {
                                            break;
                                        }
                                        imageViewArr[i59].setVisibility(0);
                                        this.D[i59].setImageDrawable(h(String.valueOf(s16.get(i59).f73805a)));
                                        i59++;
                                    }
                                } else {
                                    this.D[0].setVisibility(0);
                                    this.D[1].setVisibility(0);
                                    this.D[2].setVisibility(8);
                                    this.D[0].setImageDrawable(h(String.valueOf(s16.get(0).f73805a)));
                                    this.D[1].setImageDrawable(h(String.valueOf(s16.get(1).f73805a)));
                                }
                            } else {
                                for (ImageView imageView5 : this.D) {
                                    imageView5.setVisibility(8);
                                }
                            }
                            qQAppInterface2 = qQAppInterface4;
                            z18 = true;
                            z17 = false;
                            if (!ThemeUtil.isInNightMode(qQAppInterface2)) {
                            }
                            t((qQAppInterface2.isVideoChatting() || !z16 || qQAppInterface2.getAVNotifyCenter().N() == 2) ? z18 : z17);
                            return;
                        }
                        QQAppInterface qQAppInterface5 = qQAppInterface;
                        ImageView imageView6 = imageView;
                        int i65 = R.drawable.gp9;
                        if (i58 == 10 || i58 == 1) {
                            i38 = i37;
                            i39 = 2;
                        } else {
                            i38 = i37;
                            i39 = 2;
                        }
                        if (!qQAppInterface5.getAVNotifyCenter().i0(str2)) {
                            Vector<AVNotifyCenter.h> x16 = i38 == i39 ? qQAppInterface5.getAVNotifyCenter().x(i38, j27) : s16;
                            boolean z19 = x16 != null && x16.size() == 1 && qQAppInterface5.getCurrentUin().equalsIgnoreCase(String.valueOf(x16.get(0).f73805a));
                            if (x16 != null && x16.size() != 0 && !z19) {
                                imageView6.setImageBitmap(null);
                                this.C.setVisibility(8);
                                this.E.setVisibility(0);
                                ArrayList arrayList = new ArrayList(3);
                                int i66 = 0;
                                while (true) {
                                    if (i66 >= x16.size()) {
                                        qQAppInterface2 = qQAppInterface5;
                                        break;
                                    }
                                    qQAppInterface2 = qQAppInterface5;
                                    if (k(String.valueOf(x16.get(i66).f73805a))) {
                                        arrayList.add(x16.get(i66));
                                    }
                                    if (arrayList.size() == 3) {
                                        break;
                                    }
                                    i66++;
                                    qQAppInterface5 = qQAppInterface2;
                                }
                                if (arrayList.size() == 0) {
                                    i46 = 0;
                                    obj = x16.get(0);
                                } else {
                                    i46 = 0;
                                    obj = arrayList.get(0);
                                }
                                String valueOf = String.valueOf(((AVNotifyCenter.h) obj).f73805a);
                                if (k(valueOf)) {
                                    if (arrayList.size() == 1) {
                                        this.F[i46].setVisibility(i46);
                                        this.F[1].setVisibility(8);
                                        this.F[2].setVisibility(8);
                                        this.F[i46].setImageDrawable(h(String.valueOf(((AVNotifyCenter.h) arrayList.get(i46)).f73805a)));
                                    } else if (arrayList.size() == 2) {
                                        this.F[i46].setVisibility(i46);
                                        this.F[1].setVisibility(i46);
                                        this.F[2].setVisibility(8);
                                        this.F[i46].setImageDrawable(h(String.valueOf(((AVNotifyCenter.h) arrayList.get(i46)).f73805a)));
                                        this.F[1].setImageDrawable(h(String.valueOf(((AVNotifyCenter.h) arrayList.get(1)).f73805a)));
                                    } else if (arrayList.size() == 3) {
                                        int i67 = 0;
                                        while (true) {
                                            ImageView[] imageViewArr2 = this.F;
                                            if (i67 >= imageViewArr2.length) {
                                                break;
                                            }
                                            imageViewArr2[i67].setVisibility(0);
                                            this.F[i67].setImageDrawable(h(String.valueOf(((AVNotifyCenter.h) arrayList.get(i67)).f73805a)));
                                            i67++;
                                        }
                                    } else {
                                        this.F[0].setVisibility(0);
                                        this.F[1].setVisibility(8);
                                        this.F[2].setVisibility(8);
                                        this.F[0].setImageDrawable(h(valueOf));
                                    }
                                } else {
                                    imageView6.setImageResource(isInNightMode ? R.drawable.hzp : R.drawable.gp9);
                                    this.E.setVisibility(8);
                                }
                                String e06 = ac.e0(qQAppInterface2, valueOf, str2, this.f180088f.f179555d == 1 ? 1 : 2, 50L);
                                if (j18 == 1) {
                                    format = this.f180089h.getString(R.string.f170264km);
                                    z17 = false;
                                } else {
                                    int i68 = this.f180088f.f179555d;
                                    if (i68 == 3000) {
                                        string = this.f180089h.getString(R.string.f170261kj);
                                        i47 = 1;
                                    } else {
                                        i47 = 1;
                                        string = i68 == 1 ? this.f180089h.getString(R.string.f170225jf) : null;
                                    }
                                    Object[] objArr = new Object[i47];
                                    z17 = false;
                                    objArr[0] = Long.valueOf(j18);
                                    format = String.format(string, objArr);
                                }
                                TextView textView5 = (TextView) this.f180091m.findViewById(R.id.g6i);
                                if (textView5 != null) {
                                    StringBuilder sb7 = new StringBuilder(ba.getNameMaxMaseaured(this.f180091m.getContext(), e06.toString(), textView5, this.f180091m.getResources().getDimensionPixelSize(R.dimen.f158923b64)));
                                    sb7.append(format);
                                    textView5.setText(sb7);
                                }
                                if (textView4.getVisibility() == 0) {
                                    i48 = 8;
                                    textView4.setVisibility(8);
                                } else {
                                    i48 = 8;
                                }
                                TextView textView6 = (TextView) this.f180091m.findViewById(R.id.f2e);
                                if (textView6 != null) {
                                    textView6.setVisibility(i48);
                                }
                                z18 = true;
                                if (!ThemeUtil.isInNightMode(qQAppInterface2)) {
                                }
                                t((qQAppInterface2.isVideoChatting() || !z16 || qQAppInterface2.getAVNotifyCenter().N() == 2) ? z18 : z17);
                                return;
                            }
                            qQAppInterface2 = qQAppInterface5;
                            z17 = false;
                            if (isInNightMode) {
                                i65 = R.drawable.hzp;
                            }
                            imageView6.setImageResource(i65);
                            if (z19 && (textView2 = (TextView) this.f180091m.findViewById(R.id.g6i)) != null) {
                                textView2.setText(this.f180089h.getString(R.string.f170260ki));
                            }
                            this.C.setVisibility(8);
                            this.E.setVisibility(8);
                            z18 = true;
                            QLog.w(this.f180086d, 1, "\u62ff\u4e0d\u5230\u7528\u6237\u6570\u636e\uff0c\u653e\u5f03\u5c55\u793a aloneStatus:" + z19);
                            if (!ThemeUtil.isInNightMode(qQAppInterface2)) {
                                imageView2.setImageResource(R.drawable.common_tips_arrow_gray);
                            } else {
                                imageView2.setImageResource(R.drawable.hmw);
                            }
                            t((qQAppInterface2.isVideoChatting() || !z16 || qQAppInterface2.getAVNotifyCenter().N() == 2) ? z18 : z17);
                            return;
                        }
                        qQAppInterface2 = qQAppInterface5;
                        z18 = true;
                        z17 = false;
                        if (isInNightMode) {
                            i65 = R.drawable.hzp;
                        }
                        imageView6.setImageResource(i65);
                        this.C.setVisibility(8);
                        this.E.setVisibility(8);
                        if (!ThemeUtil.isInNightMode(qQAppInterface2)) {
                        }
                        t((qQAppInterface2.isVideoChatting() || !z16 || qQAppInterface2.getAVNotifyCenter().N() == 2) ? z18 : z17);
                        return;
                    }
                }
                i18 = 2;
                i19 = i17;
                j18 = y16;
                i26 = l3;
                i27 = 0;
                i28 = 10;
                if (i26 != i28) {
                }
                j19 = j17;
                qQAppInterface3.getAVNotifyCenter().H0(j19, i26, (int) j18);
                if (i26 == i18) {
                }
                i29 = uinType2AVRelationType;
                j26 = 0;
                if (j18 > j26) {
                }
            }
        }
        g();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (r2 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        if (j() == false) goto L27;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int l3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f29) {
            int i3 = this.f180088f.f179555d;
            if (i3 != 3000 && i3 != 1) {
                if (!j()) {
                    l();
                }
            } else {
                WeakReference<QQAppInterface> weakReference = this.f180087e;
                if (weakReference != null && weakReference.get() != null) {
                    long parseLong = Long.parseLong(this.f180088f.f179557e);
                    boolean i06 = this.f180087e.get().getAVNotifyCenter().i0(this.f180088f.f179557e);
                    AVNotifyCenter.i p16 = this.f180087e.get().getAVNotifyCenter().p(parseLong);
                    if (p16 != null) {
                        l3 = p16.f73810d;
                    } else {
                        l3 = this.f180087e.get().getAVNotifyCenter().l(parseLong);
                    }
                    if (l3 == 10) {
                    }
                }
                m();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public b p(long j3, long j16, int i3, int i16, long j17, TextView textView, ImageView imageView) {
        String str;
        String str2;
        int i17;
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            QQAppInterface qQAppInterface = this.f180087e.get();
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String l3 = Long.toString(j3);
            String str3 = null;
            if (j3 != 0 && !currentAccountUin.equals(Long.valueOf(j3)) && i3 != 2) {
                String l16 = Long.toString(j16);
                if (this.f180088f.f179555d == 1) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                str2 = ac.s(qQAppInterface, l3, l16, i17, 0);
                if (i16 == 1) {
                    int i18 = this.f180088f.f179555d;
                    if (i18 == 3000) {
                        str3 = this.f180089h.getString(R.string.f170265kn);
                    } else if (i18 == 1) {
                        str3 = this.f180089h.getString(R.string.f170228jh);
                    }
                } else if (i16 == 2) {
                    int i19 = this.f180088f.f179555d;
                    if (i19 == 3000) {
                        str3 = this.f180089h.getString(R.string.f170266ko);
                    } else if (i19 == 1) {
                        str3 = this.f180089h.getString(R.string.f170229ji);
                    }
                }
                textView.setVisibility(8);
            } else {
                if (qQAppInterface.getAVNotifyCenter().k0()) {
                    str = this.f180089h.getString(R.string.f170267kp);
                    qQAppInterface.getAVNotifyCenter().O0(false);
                    if (i3 == 2) {
                        textView.setVisibility(8);
                    }
                } else {
                    int i26 = this.f180088f.f179555d;
                    if (i26 == 3000) {
                        str = this.f180089h.getString(R.string.f170259kg);
                    } else if (i26 == 1) {
                        str = d(j16, i3);
                    } else {
                        str = null;
                    }
                    qQAppInterface.getAVNotifyCenter().O0(true);
                    if (str != null) {
                        str = String.format(str, Long.valueOf(j17));
                    }
                    textView.setVisibility(0);
                }
                str2 = null;
                str3 = str;
            }
            int i27 = this.f180088f.f179555d;
            if (i27 == 3000) {
                ba.setAccText(this.f180091m, this.f180089h.getString(R.string.bhn));
            } else if (i27 == 1) {
                ba.setAccText(this.f180091m, this.f180089h.getString(R.string.bho), i3);
            }
            imageView.setVisibility(0);
            b bVar = new b();
            bVar.f180095b = str2;
            bVar.f180094a = str3;
            return bVar;
        }
        return new b();
    }

    public b q(int i3, long j3, int i16, long j16, TextView textView) {
        AVNotifyCenter.h hVar;
        int i17;
        int i18;
        int i19;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i26;
        String str7;
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            hVar = this.f180087e.get().getAVNotifyCenter().w(i3, j3);
        } else {
            hVar = null;
        }
        if (hVar == null) {
            int i27 = this.f180088f.f179555d;
            if (i27 == 3000) {
                str7 = this.f180089h.getString(R.string.f170262kk);
                i17 = 1;
                i26 = 2;
                i18 = 3000;
            } else if (i27 == 1) {
                i17 = 1;
                i26 = 2;
                i18 = 3000;
                str7 = f(true, j3, i16, i27, j16);
            } else {
                i17 = 1;
                i26 = 2;
                i18 = 3000;
                str7 = null;
            }
            Object[] objArr = new Object[i17];
            objArr[0] = Long.valueOf(j16);
            str2 = String.format(str7, objArr);
            if (i16 == i26 && j16 > 99) {
                str2 = f(true, j3, i16, this.f180088f.f179555d, j16);
            }
            str3 = null;
        } else {
            i17 = 1;
            i18 = 3000;
            if (hVar.f73806b) {
                WeakReference<QQAppInterface> weakReference2 = this.f180087e;
                if (weakReference2 != null && weakReference2.get() != null) {
                    str4 = this.f180087e.get().getAVNotifyCenter().z(hVar.f73805a);
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    int i28 = this.f180088f.f179555d;
                    if (i28 == 3000) {
                        str2 = this.f180089h.getString(R.string.f170262kk);
                    } else if (i28 == 1) {
                        str2 = this.f180089h.getString(R.string.f170226jg);
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = String.format(str2, Long.valueOf(j16));
                    }
                    if (i16 == 2 && j16 > 99) {
                        str2 = this.f180089h.getString(R.string.f170253kc);
                    }
                    str6 = null;
                } else {
                    if (j16 == 1) {
                        str5 = this.f180089h.getString(R.string.f170263kl);
                    } else {
                        int i29 = this.f180088f.f179555d;
                        if (i29 == 3000) {
                            str5 = this.f180089h.getString(R.string.f170261kj);
                        } else if (i29 == 1) {
                            str5 = this.f180089h.getString(R.string.f170225jf);
                        } else {
                            str5 = null;
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            str5 = String.format(str5, Long.valueOf(j16));
                        }
                        if (i16 == 2 && j16 > 99) {
                            str5 = this.f180089h.getString(R.string.f170233jl);
                        }
                    }
                    str6 = str4;
                    str2 = str5;
                }
                str3 = str6;
            } else {
                String l3 = Long.toString(hVar.f73805a);
                String l16 = Long.toString(j3);
                if (this.f180088f.f179555d == 1) {
                    i19 = 1;
                } else {
                    i19 = 2;
                }
                WeakReference<QQAppInterface> weakReference3 = this.f180087e;
                if (weakReference3 != null && weakReference3.get() != null) {
                    str = ac.s(this.f180087e.get(), l3, l16, i19, 0);
                } else {
                    str = null;
                }
                if (j16 == 1) {
                    str2 = this.f180089h.getString(R.string.f170263kl);
                } else {
                    int i36 = this.f180088f.f179555d;
                    if (i36 == 3000) {
                        str2 = this.f180089h.getString(R.string.f170261kj);
                    } else if (i36 == 1) {
                        str2 = f(false, j3, i16, i36, j16);
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = String.format(str2, Long.valueOf(j16));
                    }
                    if (i16 == 2 && j16 > 99) {
                        str2 = f(false, j3, i16, this.f180088f.f179555d, j16);
                    }
                }
                str3 = str;
            }
        }
        textView.setVisibility(8);
        int i37 = this.f180088f.f179555d;
        if (i37 == i18) {
            ba.setAccText(this.f180091m, this.f180089h.getString(R.string.dc5));
        } else if (i37 == i17) {
            ba.setAccText(this.f180091m, this.f180089h.getString(R.string.dct), i16);
        }
        b bVar = new b();
        bVar.f180095b = str3;
        bVar.f180094a = str2;
        return bVar;
    }

    void r(long j3) {
        RefreshMultiStateRunnable refreshMultiStateRunnable = this.G;
        if (refreshMultiStateRunnable == null) {
            this.G = new RefreshMultiStateRunnable(this);
        } else {
            MqqHandler mqqHandler = this.f180090i;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacks(refreshMultiStateRunnable);
            }
        }
        MqqHandler mqqHandler2 = this.f180090i;
        if (mqqHandler2 != null) {
            mqqHandler2.postDelayed(this.G, j3);
            WeakReference<QQAppInterface> weakReference = this.f180087e;
            if (weakReference != null && weakReference.get() != null) {
                this.f180087e.get().getAVNotifyCenter().O0(false);
            }
        }
    }

    public void s(String str, String str2, int i3, String str3, int i16) {
        int i17;
        int i18;
        LinearLayout linearLayout = (LinearLayout) this.f180091m.findViewById(R.id.jhy);
        linearLayout.removeAllViews();
        if (str != null) {
            TextView textView = new TextView(this.f180089h.getApplicationContext());
            textView.setId(R.id.f2e);
            String e16 = e(this.f180089h, str, textView, this.f180089h.getResources().getDimensionPixelSize(R.dimen.f159193wz));
            textView.setTextSize(14.0f);
            textView.setTextColor(i3);
            textView.setSingleLine();
            textView.setGravity(5);
            textView.setMaxWidth(this.f180089h.getResources().getDimensionPixelSize(R.dimen.f158932sr));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(e16);
            linearLayout.addView(textView);
        }
        TextView textView2 = new TextView(this.f180089h.getApplicationContext());
        textView2.setTextSize(14.0f);
        textView2.setTextColor(i3);
        WeakReference<QQAppInterface> weakReference = this.f180087e;
        if (weakReference != null && weakReference.get() != null) {
            if (i16 == 0) {
                try {
                    i16 = this.f180087e.get().getAVNotifyCenter().l(Long.valueOf(str3).longValue());
                } catch (Exception unused) {
                    i16 = 0;
                }
            }
            if (str2 != null) {
                String str4 = this.f180087e.get().getAVNotifyCenter().f73768n.get(str3);
                if (str4 != null) {
                    i18 = Integer.valueOf(str4.split(";")[0]).intValue();
                    i17 = Integer.valueOf(str4.split(";")[1]).intValue();
                } else {
                    i17 = 0;
                    i18 = 0;
                }
                if (i18 == 1) {
                    if (i17 > 99) {
                        str2 = this.f180087e.get().getApp().getString(R.string.ddp);
                    } else {
                        str2 = String.format(this.f180087e.get().getApp().getString(R.string.ddo), Integer.valueOf(i17));
                    }
                } else if (i16 == 2) {
                    str2 = str2.replace(this.f180087e.get().getApp().getString(R.string.f173216i41), this.f180087e.get().getApp().getString(R.string.f173217i42));
                }
            }
            textView2.setText(str2);
            textView2.setId(R.id.g6i);
            if (ThemeUtil.isInNightMode(this.f180087e.get())) {
                textView2.setTextColor(Color.parseColor("#A8A8A8"));
            }
            linearLayout.addView(textView2);
        }
    }

    public void t(boolean z16) {
        boolean z17;
        Context context = this.f180089h;
        if (context != null && (context instanceof BaseActivity)) {
            z17 = ((BaseActivity) context).isResume();
        } else {
            z17 = false;
        }
        SmallScreenUtils.E(this.f180091m, z16, z17);
    }
}
