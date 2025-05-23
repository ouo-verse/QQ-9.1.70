package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.qzone.module.vipcomponent.common.VipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.a;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.theme.ThemeCleaner;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.util.IVasNamePlateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconClick;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$SpecialInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$SpeciesFlag;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ff {

    /* renamed from: a, reason: collision with root package name */
    static long f307772a;

    /* renamed from: b, reason: collision with root package name */
    static HashMap<String, Integer> f307773b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f307774d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307775e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f307776f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f307777h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f307778i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f307779m;

        a(boolean z16, String str, Context context, String str2, String str3, int i3) {
            this.f307774d = z16;
            this.f307775e = str;
            this.f307776f = context;
            this.f307777h = str2;
            this.f307778i = str3;
            this.f307779m = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!this.f307774d) {
                if (BigTroopExpiredNtTipsBar.G > 0 && this.f307775e.equals("expired_tips_bar")) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(this.f307776f, BigTroopExpiredNtTipsBar.B());
                } else {
                    String A = BigTroopExpiredNtTipsBar.A();
                    try {
                        if (A.contains("groupId=%s")) {
                            A = A.replace("groupId=%s", "groupId=" + this.f307777h);
                        }
                        if (A.contains("from=%s")) {
                            A = A.replace("from=%s", "from=group_aio_popup");
                        }
                    } catch (Exception e16) {
                        QLog.e(VipUtils.TAG, 1, "contentClick format exception", e16);
                    }
                    if (!A.startsWith("http") && !A.startsWith(com.tencent.mobileqq.msf.core.x.q.f250389u)) {
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(this.f307776f, A);
                    } else {
                        Intent intent = new Intent(this.f307776f, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", A);
                        intent.putExtra("hide_operation_bar", true);
                        if (this.f307776f instanceof Application) {
                            intent.setFlags(268435456);
                        }
                        this.f307776f.startActivity(intent);
                    }
                }
            } else {
                TroopManager.g.d(this.f307776f, this.f307777h, "group_aio_popup");
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((TroopManager) peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).m0(this.f307777h, 0);
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, this.f307778i, this.f307779m, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements Comparator<String> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str != null && str2 != null) {
                if (str.length() > str2.length()) {
                    return -1;
                }
                if (str.length() < str2.length()) {
                    return 1;
                }
                return 0;
            }
            if (str != null) {
                return -1;
            }
            if (str2 != null) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements IAddJsonGrayTipMsgCallback {
        d() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
        public void onResult(int i3, long j3) {
            QLog.i(VipUtils.TAG, 1, "addFriendGrayTips:" + i3 + " msgId:" + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e implements Comparable {
        public static final boolean C = com.tencent.mobileqq.vas.ar.b("shouyouye", "2024-07-08", "vas_bug_126208009").isEnable(true);

        /* renamed from: d, reason: collision with root package name */
        private final String f307780d;

        /* renamed from: e, reason: collision with root package name */
        private final int f307781e;

        /* renamed from: f, reason: collision with root package name */
        private final int f307782f;

        /* renamed from: h, reason: collision with root package name */
        private int f307783h = 0;

        /* renamed from: i, reason: collision with root package name */
        private String f307784i = "";

        /* renamed from: m, reason: collision with root package name */
        private com.tencent.qqnt.graytips.action.f f307785m = null;

        public e(String str, int i3, int i16) {
            this.f307780d = str;
            this.f307781e = i3;
            this.f307782f = i16;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            if (!(obj instanceof e)) {
                return -1;
            }
            return this.f307781e - ((e) obj).f307781e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag(R.id.f1198277w);
            if ((tag instanceof Integer) && (view.getContext() instanceof Activity)) {
                ff.f0(view.getContext(), ((Integer) tag).intValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public String f307786a;

        /* renamed from: b, reason: collision with root package name */
        public String f307787b;

        /* renamed from: c, reason: collision with root package name */
        public String f307788c;

        /* renamed from: d, reason: collision with root package name */
        public String f307789d;

        /* renamed from: e, reason: collision with root package name */
        public String f307790e;

        /* renamed from: f, reason: collision with root package name */
        public String f307791f;

        /* renamed from: g, reason: collision with root package name */
        public int f307792g = 1;

        /* renamed from: h, reason: collision with root package name */
        public boolean f307793h = true;

        h() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f307794a;

        /* renamed from: b, reason: collision with root package name */
        public int f307795b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f307796c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f307797d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f307798e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f307799f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f307800g = 0;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private static long[] f307801a = {0, 0};

        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class a extends b implements View.OnClickListener {
            a(QQAppInterface qQAppInterface, String str, String str2) {
                super(qQAppInterface, str, str2);
            }

            public static a f(QQAppInterface qQAppInterface, String str, String str2) {
                return new a(qQAppInterface, str, str2);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                super.onTouch(view, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class b implements View.OnTouchListener {

            /* renamed from: d, reason: collision with root package name */
            protected final WeakReference<AppRuntime> f307802d;

            /* renamed from: e, reason: collision with root package name */
            protected final String f307803e;

            /* renamed from: f, reason: collision with root package name */
            protected final String f307804f;

            /* renamed from: h, reason: collision with root package name */
            protected final String f307805h;

            /* renamed from: i, reason: collision with root package name */
            protected int f307806i = 0;

            /* renamed from: m, reason: collision with root package name */
            protected int f307807m = 0;
            protected int C = 0;
            protected boolean D = false;

            b(AppRuntime appRuntime, String str, String str2) {
                this.f307802d = new WeakReference<>(appRuntime);
                this.f307803e = str;
                this.f307804f = str2;
                if (str2.equals("VIA_AIO_CHATSETTINGS")) {
                    this.f307805h = "VIA_AIO_CHATSETTINGS";
                    return;
                }
                if (str2.equals("VIA_SETTINGME")) {
                    this.f307805h = "VIA_SETTINGME";
                    return;
                }
                if (str2.equals("VIA_PROFILECARD")) {
                    this.f307805h = "VIA_PROFILECARD";
                } else if (str2.equals("VIA_AIO_TITLE")) {
                    this.f307805h = "VIA_AIO_TITLE";
                } else {
                    this.f307805h = "";
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ String b(String str) {
                return ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(str, IVipTraceDetailReport.FROM.AIO_DIALOG_TOP_NAMEPLATE);
            }

            public static b c(AppRuntime appRuntime, String str, String str2) {
                return new b(appRuntime, str, str2);
            }

            private void e(AppRuntime appRuntime, String str) {
                EVIPSPEC evipspec;
                NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
                if (vasSimpleInfoWithUid != null) {
                    if (j.g(vasSimpleInfoWithUid.nameplateVipType)) {
                        com.tencent.mobileqq.vip.api.f b16 = com.tencent.mobileqq.vip.api.f.b(vasSimpleInfoWithUid.nameplateVipType);
                        this.C = j.h(vasSimpleInfoWithUid.grayNameplateFlag) ? 1 : 0;
                        this.f307806i = b16.f312805a;
                        if (b16 != com.tencent.mobileqq.vip.api.f.f312803g && b16 != com.tencent.mobileqq.vip.api.f.f312804h) {
                            if (b16 != com.tencent.mobileqq.vip.api.f.f312801e && b16 != com.tencent.mobileqq.vip.api.f.f312802f) {
                                if (b16 == com.tencent.mobileqq.vip.api.f.f312799c || b16 == com.tencent.mobileqq.vip.api.f.f312800d) {
                                    this.f307807m = 0;
                                    return;
                                }
                                return;
                            }
                            this.f307807m = vasSimpleInfoWithUid.superVipTemplateId;
                            return;
                        }
                        this.f307807m = vasSimpleInfoWithUid.bigClubTemplateId;
                        this.D = true;
                        return;
                    }
                    int q16 = ff.q(appRuntime, str) >> 8;
                    if (q16 == 3) {
                        evipspec = EVIPSPEC.E_SP_BIGCLUB;
                    } else if (q16 == 1) {
                        evipspec = EVIPSPEC.E_SP_QQVIP;
                    } else if (q16 == 2) {
                        evipspec = EVIPSPEC.E_SP_SUPERVIP;
                    } else {
                        evipspec = null;
                    }
                    EVIPSPEC evipspec2 = EVIPSPEC.E_SP_BIGCLUB;
                    if (evipspec == evipspec2) {
                        short s16 = ff.s(appRuntime, str, evipspec2);
                        this.f307806i = ((s16 & 15) << 8) | (s16 >> 8);
                        this.f307807m = vasSimpleInfoWithUid.bigClubTemplateId;
                        this.D = true;
                        return;
                    }
                    EVIPSPEC evipspec3 = EVIPSPEC.E_SP_SUPERVIP;
                    if (evipspec == evipspec3) {
                        short s17 = ff.s(appRuntime, str, evipspec3);
                        this.f307806i = ((s17 & 15) << 8) | (s17 >> 8);
                        this.f307807m = vasSimpleInfoWithUid.superVipTemplateId;
                        return;
                    }
                    EVIPSPEC evipspec4 = EVIPSPEC.E_SP_QQVIP;
                    if (evipspec == evipspec4) {
                        short s18 = ff.s(appRuntime, str, evipspec4);
                        this.f307806i = ((s18 & 15) << 8) | (s18 >> 8);
                        this.f307807m = 0;
                    }
                }
            }

            public void d() {
                boolean z16;
                String str = this.f307804f;
                int i3 = this.f307807m;
                if (this.C != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                j.k(str, i3, z16);
                AppRuntime appRuntime = this.f307802d.get();
                if (appRuntime == null) {
                    return;
                }
                e(appRuntime, this.f307803e);
                if (!TextUtils.isEmpty(this.f307805h)) {
                    ((IVipIconClick) QRoute.api(IVipIconClick.class)).report04586(this.f307807m, false, this.f307805h);
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AppRuntime appRuntime;
                boolean z16;
                String str;
                String str2;
                String str3;
                if ((!TextUtils.isEmpty(this.f307805h) && ((motionEvent == null || motionEvent.getAction() == 1) && ((IVipIconClick) QRoute.api(IVipIconClick.class)).onClick(view, this.f307803e, this.f307805h))) || (appRuntime = this.f307802d.get()) == null) {
                    return true;
                }
                e(appRuntime, this.f307803e);
                if (motionEvent != null && motionEvent.getAction() != 1) {
                    return true;
                }
                IVasNamePlateUtil.VipIconClickConfig findConfig = ((IVasNamePlateUtil) QRoute.api(IVasNamePlateUtil.class)).findConfig(this.f307806i, this.f307807m, this.C);
                String str4 = this.f307804f;
                int i3 = this.f307807m;
                if (this.C != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                j.j(str4, i3, z16);
                if (this.f307804f == "VIA_PROFILECARD") {
                    ProfileCardDtReportUtil.dtReportClick(view);
                }
                String currentAccountUin = appRuntime.getCurrentAccountUin();
                boolean equals = this.f307803e.equals(currentAccountUin);
                if (findConfig != null && !TextUtils.isEmpty(this.f307803e)) {
                    if ("VIA_SETTINGME".equals(this.f307804f)) {
                        str2 = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(findConfig.drawerUrl, IVipTraceDetailReport.FROM.QQSETTINGS_ICON);
                    } else if ("VIA_PROFILECARD".equals(this.f307804f)) {
                        if (equals) {
                            str2 = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(findConfig.vaProfileUrl, IVipTraceDetailReport.FROM.PROFILECARD_ICON);
                        } else {
                            str2 = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(findConfig.vaProfileGuestUrl, IVipTraceDetailReport.FROM.PROFILECARD_ICON_GUEST);
                        }
                    } else if ("VIA_AIO_TITLE".equals(this.f307804f)) {
                        if (equals) {
                            str3 = findConfig.ctocUrl;
                        } else {
                            str3 = findConfig.ctocGuestUrl;
                        }
                        str2 = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(str3, IVipTraceDetailReport.FROM.AIO_DIALOG_TOP_NAMEPLATE);
                    } else if ("VIA_AIO_CHATSETTINGS".equals(this.f307804f)) {
                        if (equals) {
                            str2 = findConfig.ctocSettingUrl;
                        } else {
                            str2 = findConfig.ctocSettingGuestUrl;
                        }
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (!equals) {
                            str2 = str2.replace("{uin}", this.f307803e);
                        }
                        Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("portraitOnly", true);
                        intent.putExtra("uin", currentAccountUin);
                        intent.putExtra("hide_operation_bar", true);
                        intent.putExtra("hide_more_button", true);
                        VasWebviewUtil.openQQBrowserWithoutAD(view.getContext(), str2, 256L, intent, false, -1);
                        return true;
                    }
                }
                if ("VIA_SETTINGME".equals(this.f307804f)) {
                    if (this.D) {
                        ff.K(appRuntime, view.getContext(), this.f307806i, this.f307803e, JsonWebSignature.CONTENT_TYPE);
                    } else {
                        ff.z(appRuntime, view.getContext(), JsonWebSignature.CONTENT_TYPE);
                    }
                } else if ("VIA_PROFILECARD".equals(this.f307804f)) {
                    String str5 = "zlk";
                    if (this.D) {
                        Context context = view.getContext();
                        int i16 = this.f307806i;
                        String str6 = this.f307803e;
                        if (!equals) {
                            str5 = "zlkkr";
                        }
                        ff.K(appRuntime, context, i16, str6, str5);
                    } else {
                        Context context2 = view.getContext();
                        if (!equals) {
                            str5 = "zlkkr";
                        }
                        ff.z(appRuntime, context2, str5);
                    }
                } else if ("VIA_AIO_TITLE".equals(this.f307804f)) {
                    k kVar = new k() { // from class: com.tencent.mobileqq.utils.fg
                        @Override // com.tencent.mobileqq.utils.ff.k
                        public final String a(String str7) {
                            String b16;
                            b16 = ff.j.b.b(str7);
                            return b16;
                        }
                    };
                    String str7 = "ctoc";
                    if (this.D) {
                        Context context3 = view.getContext();
                        int i17 = this.f307806i;
                        String str8 = this.f307803e;
                        if (equals) {
                            str = "ctoc";
                        } else {
                            str = "ctockr";
                        }
                        ff.L(appRuntime, context3, i17, str8, str, kVar);
                    } else {
                        Context context4 = view.getContext();
                        if (!equals) {
                            str7 = "ctockr";
                        }
                        ff.z(appRuntime, context4, str7);
                    }
                } else if ("VIA_AIO_CHATSETTINGS".equals(this.f307804f)) {
                    String str9 = "ctocset";
                    if (this.D) {
                        Context context5 = view.getContext();
                        int i18 = this.f307806i;
                        String str10 = this.f307803e;
                        if (!equals) {
                            str9 = "ctocsetkr";
                        }
                        ff.K(appRuntime, context5, i18, str10, str9);
                    } else {
                        Context context6 = view.getContext();
                        if (!equals) {
                            str9 = "ctocsetkr";
                        }
                        ff.z(appRuntime, context6, str9);
                    }
                } else if (this.D) {
                    ff.K(appRuntime, view.getContext(), this.f307806i, this.f307803e, QzoneWebMusicJsPlugin.EVENT_UNKOWN);
                } else {
                    ff.z(appRuntime, view.getContext(), QzoneWebMusicJsPlugin.EVENT_UNKOWN);
                }
                return true;
            }
        }

        public static int c(com.tencent.mobileqq.vip.api.f fVar) {
            return com.tencent.mobileqq.vip.api.c.a().getDefaultVipIcon(fVar);
        }

        public static int[] d(AppRuntime appRuntime, String str) {
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
            if (vasSimpleInfoWithUid != null) {
                return new int[]{vasSimpleInfoWithUid.nameplateVipType, vasSimpleInfoWithUid.grayNameplateFlag};
            }
            return new int[]{0, 0};
        }

        public static String[] e(AppRuntime appRuntime, String str, com.tencent.mobileqq.vip.api.f fVar, boolean z16) {
            return com.tencent.mobileqq.vip.api.c.a().getVIPIconUrl(((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG), fVar, z16);
        }

        public static String f(int i3, int i16, long j3) {
            return com.tencent.mobileqq.vip.api.c.a().getVipIconUrl(i3, i16, j3, false);
        }

        public static boolean g(int i3) {
            return com.tencent.mobileqq.vip.api.c.a().isDiyVipIcon(i3);
        }

        public static boolean h(int i3) {
            return com.tencent.mobileqq.vip.api.c.a().isGrayVipIcon(i3);
        }

        private static void i(String str, int i3, boolean z16) {
            int i16;
            if (z16) {
                i16 = 9;
            } else {
                i16 = 0;
            }
            ReportController.n(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, str, i16, 1, i3, "", "", "", "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(String str, int i3, boolean z16) {
            if ("VIA_SETTINGME".equals(str)) {
                i("0X800AA9D", i3, z16);
                return;
            }
            if ("VIA_PROFILECARD".equals(str)) {
                i("0X800AA9E", i3, z16);
            } else if ("VIA_AIO_TITLE".equals(str)) {
                i("0X800AA9F", i3, z16);
            } else if ("VIA_AIO_CHATSETTINGS".equals(str)) {
                i("0X800AAA0", i3, z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(String str, int i3, boolean z16) {
            if ("VIA_SETTINGME".equals(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - f307801a[0]) < 3000) {
                    return;
                }
                f307801a[0] = currentTimeMillis;
                i("0X800AA99", i3, z16);
                return;
            }
            if ("VIA_PROFILECARD".equals(str)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis2 - f307801a[1]) < 3000) {
                    return;
                }
                f307801a[1] = currentTimeMillis2;
                i("0X800AA9A", i3, z16);
                return;
            }
            if ("VIA_AIO_TITLE".equals(str)) {
                i("0X800AA9B", i3, z16);
            } else if ("VIA_AIO_CHATSETTINGS".equals(str)) {
                i("0X800AA9C", i3, z16);
            }
        }

        public static void l(Context context, ImageView imageView, int i3, int i16) {
            m(context, imageView, i3, i16, true);
        }

        public static void m(Context context, ImageView imageView, int i3, int i16, boolean z16) {
            if (context != null && imageView != null && i3 > 0) {
                imageView.setVisibility(0);
                imageView.setTag(R.id.f1198277w, Integer.valueOf(i3));
                com.tencent.mobileqq.vip.api.c.a().setVipExtIcon(imageView, i3, z16);
                if (i16 == 1) {
                    ff.S("0X800B922", i3);
                } else if (i16 == 2) {
                    ff.S("0X800B924", i3);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface k {
        String a(String str);
    }

    public static void A(AppRuntime appRuntime, Context context, String str, k kVar) {
        String string;
        boolean z16;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        if (VasToggle.BUG_102518313.isEnable(true)) {
            string = VasMMKV.getCommon(currentAccountUin).decodeString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
        } else {
            string = context.getSharedPreferences(currentAccountUin, 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
        }
        StringBuilder sb5 = new StringBuilder();
        int systemNetwork = NetworkUtil.getSystemNetwork(appRuntime.getApp().getApplicationContext());
        if (!string.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(string + "?platform=1&type=20001&networkInfo=" + systemNetwork + "&aid=" + str);
        } else {
            sb5.append(string + "&platform=1&type=20001&networkInfo=" + systemNetwork + "&aid=" + str);
        }
        String sb6 = sb5.toString();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
        String wrapperRedTouchUrl = iRedTouchManager.wrapperRedTouchUrl(sb6, appInfoByPath);
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0 && appInfoByPath.type.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra(QQBrowserActivity.BROADCAST_ACTION_KEY, QQBrowserActivity.ACTION_UPDATE_VIP_INFO);
        intent.putExtra("startOpenPageTime", currentTimeMillis);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, z16);
        intent.putExtra("leftBtnText", context.getResources().getString(R.string.account));
        if (kVar != null) {
            wrapperRedTouchUrl = kVar.a(wrapperRedTouchUrl);
        }
        String str2 = wrapperRedTouchUrl;
        if (QLog.isColorLevel()) {
            QLog.i(VipUtils.TAG, 2, "gotoVipCenterBrowser jumpUrl:" + str2);
        }
        VasWebviewUtil.openQQBrowserWithoutAD(context, str2, 256L, intent, false, -1);
    }

    public static void B(QQAppInterface qQAppInterface, SubMsgType0x120$MsgBody subMsgType0x120$MsgBody) {
        if (F(String.valueOf(subMsgType0x120$MsgBody.uint64_frd_uin.get()), subMsgType0x120$MsgBody.uint32_notice_time.get())) {
            if (QLog.isColorLevel()) {
                QLog.w(VipUtils.TAG, 2, "handle0x210_0x120push duplicate push, ignore.");
            }
        } else {
            if (subMsgType0x120$MsgBody.uint32_src_app_id.get() == 1 && subMsgType0x120$MsgBody.uint32_notice_type.get() == 14) {
                TroopKeywordManager.e(qQAppInterface).k();
                return;
            }
            if (subMsgType0x120$MsgBody.uint32_src_app_id.get() == 3 && subMsgType0x120$MsgBody.uint32_notice_type.get() == 15) {
                ThemeCleaner.asyncCleanTheme(qQAppInterface, String.valueOf(subMsgType0x120$MsgBody.uint32_clear_themeid.get()));
            }
            if (!com.tencent.mobileqq.mutualmark.alienation.f.i().n()) {
                if (QLog.isColorLevel()) {
                    QLog.w(VipUtils.TAG, 2, "handle0x210_0x120push not authorized user, ignore.");
                    return;
                }
                return;
            }
            a(qQAppInterface, subMsgType0x120$MsgBody);
        }
    }

    public static boolean C(int i3) {
        com.tencent.mobileqq.vip.api.f b16 = com.tencent.mobileqq.vip.api.f.b(i3);
        if (b16 != com.tencent.mobileqq.vip.api.f.f312803g && b16 != com.tencent.mobileqq.vip.api.f.f312804h) {
            return false;
        }
        return true;
    }

    public static boolean D() {
        return true;
    }

    private static boolean E(String str) {
        return str.startsWith(SchemaUtils.SCHEMA_MQQAPI);
    }

    public static synchronized boolean F(String str, int i3) {
        synchronized (ff.class) {
            if (f307773b == null) {
                f307773b = new HashMap<>();
            }
            Integer num = f307773b.get(str);
            if (num != null && num.intValue() == i3) {
                return true;
            }
            f307773b.put(str, Integer.valueOf(i3));
            return false;
        }
    }

    public static boolean G(int i3, int i16) {
        if (i3 == 0 || i16 == 0) {
            return false;
        }
        Date date = new Date(i3 * 1000);
        Date date2 = new Date(i16 * 1000);
        if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
            return false;
        }
        return true;
    }

    public static boolean H(int i3) {
        com.tencent.mobileqq.vip.api.f b16 = com.tencent.mobileqq.vip.api.f.b(i3);
        if (b16 != com.tencent.mobileqq.vip.api.f.f312801e && b16 != com.tencent.mobileqq.vip.api.f.f312802f) {
            return false;
        }
        return true;
    }

    public static void I(AppRuntime appRuntime, Context context, int i3, long j3, String str, k kVar) {
        J(appRuntime, context, i3, j3, str, NamePlateCfgInfo.getVipNamePlateJumUrl(appRuntime, appRuntime.getCurrentAccountUin(), i3, j3), kVar);
    }

    public static void J(AppRuntime appRuntime, Context context, int i3, long j3, String str, String str2, k kVar) {
        if (QLog.isColorLevel()) {
            QLog.i(VipUtils.TAG, 2, "NamePlate clickFriendVipIcon jumpUrl = " + str2 + " aid = " + str + " vipType = " + i3 + " namePlateId = " + j3);
        }
        if (j3 > 0) {
            NamePlateCfgInfo.vipNamePlateClickReport(appRuntime, j3);
        }
        if (TextUtils.isEmpty(str2)) {
            w(appRuntime, context, str);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (kVar != null) {
            str2 = kVar.a(str2);
        }
        intent.putExtra("url", str2);
        context.startActivity(intent);
    }

    public static void K(AppRuntime appRuntime, Context context, int i3, String str, String str2) {
        L(appRuntime, context, i3, str, str2, null);
    }

    public static void L(AppRuntime appRuntime, Context context, int i3, String str, String str2, k kVar) {
        int i16;
        if (MobileQQ.sProcessId == 1) {
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
            if (vasSimpleInfoWithUid != null) {
                i16 = vasSimpleInfoWithUid.bigClubTemplateId;
            } else {
                i16 = 0;
            }
            I(appRuntime, context, (i3 >> 8) | ((i3 & 15) << 8), i16, str2, kVar);
            return;
        }
        w(appRuntime, context, str2);
    }

    public static void M(View view, int i3, String str) {
        Context context = view.getContext();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if ((i3 >> 8) == 3) {
            w(qQAppInterface, context, "dhykl");
            return;
        }
        String str2 = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.NAMEPLATE_CLICK_SVIP) + "&source=kl&qq=" + str;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragmentStyle", 3);
        intent.putExtra("url", str2);
        intent.putExtra("isTransparentTitle", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        context.startActivity(intent);
    }

    public static void N(View view, com.tencent.mobileqq.qqexpand.bean.feed.b bVar) {
        int c16 = c(bVar);
        Context context = view.getContext();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            if (bVar.mIsMyFeed) {
                if ((c16 >> 8) == 3) {
                    w(qQAppInterface, context, "dhykl");
                } else {
                    x(context);
                }
            } else {
                M(view, c16, bVar.mUin);
            }
        } else {
            QLog.e(VipUtils.TAG, 1, "klClickVipIcon: app is null");
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009F0C", "0X8009F0C", 0, 0, "", "", "", "");
    }

    public static void O(Activity activity, h hVar) {
        if (hVar != null && activity != null && !TextUtils.isEmpty(hVar.f307786a) && !TextUtils.isEmpty(hVar.f307789d) && !TextUtils.isEmpty(hVar.f307790e) && !TextUtils.isEmpty(hVar.f307787b) && !TextUtils.isEmpty(hVar.f307788c) && hVar.f307792g >= 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("serviceCode", hVar.f307787b);
                jSONObject.put("aid", hVar.f307789d);
                jSONObject.put("openMonth", String.valueOf(hVar.f307792g));
                jSONObject.put("offerId", hVar.f307790e);
                jSONObject.put("serviceName", hVar.f307788c);
                jSONObject.put("userId", hVar.f307786a);
                if (!hVar.f307793h) {
                    jSONObject.put("isCanChange", false);
                }
                String jSONObject2 = jSONObject.toString();
                String str = hVar.f307791f;
                if (str == null) {
                    str = "";
                }
                PayBridgeActivity.tenpay(activity, jSONObject2, 4, str);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e(VipUtils.TAG, 2, "openRechargeDialog exception : " + e16.getMessage());
                }
            }
        }
    }

    public static Dialogue P(VipBaseInfo vipBaseInfo) {
        Dialogue dialogue = null;
        if (vipBaseInfo == null || TextUtils.isEmpty(vipBaseInfo.strExtendNameplateId)) {
            return null;
        }
        try {
            Dialogue dialogue2 = new Dialogue();
            try {
                if (VipBaseInfo.isEnableUtf8Bugfix) {
                    dialogue2.mergeFrom(vipBaseInfo.strExtendNameplateId.getBytes(Charsets.ISO_8859_1));
                } else {
                    dialogue2.mergeFrom(vipBaseInfo.strExtendNameplateId.getBytes());
                }
                return dialogue2;
            } catch (Exception e16) {
                e = e16;
                dialogue = dialogue2;
                e.printStackTrace();
                return dialogue;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void Q(QBaseActivity qBaseActivity, int i3, String str) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && i3 > 0) {
            h hVar = new h();
            hVar.f307786a = qBaseActivity.getAppRuntime().getCurrentAccountUin();
            hVar.f307789d = str;
            hVar.f307790e = "1450000516";
            hVar.f307787b = "CJCLUBT";
            hVar.f307788c = qBaseActivity.getString(R.string.f173184hu3);
            hVar.f307792g = i3;
            hVar.f307791f = "svip";
            O(qBaseActivity, hVar);
        }
    }

    public static void R(QBaseActivity qBaseActivity, int i3, String str) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && i3 > 0) {
            h hVar = new h();
            hVar.f307786a = qBaseActivity.getAppRuntime().getCurrentAccountUin();
            hVar.f307789d = str;
            hVar.f307790e = "1450000515";
            hVar.f307787b = "LTMCLUB";
            hVar.f307788c = qBaseActivity.getString(R.string.d2p);
            hVar.f307792g = i3;
            hVar.f307791f = "vip";
            O(qBaseActivity, hVar);
        }
    }

    public static void S(String str, int i3) {
        if (i3 <= 0) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "", str, 0, 0, String.valueOf(i3), "", "", "");
    }

    public static void T(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String... strArr) {
        fd.a(appInterface, str, str2, str3, i3, i16, strArr);
    }

    public static Drawable U(int i3, Drawable drawable) {
        if (drawable == null) {
            return drawable;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth != 0 && intrinsicHeight != 0) {
            drawable.setBounds(0, 0, (intrinsicWidth * i3) / intrinsicHeight, i3);
        }
        return drawable;
    }

    public static void V(boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface != null) {
            VasMMKV.getVipNamePlate(qQAppInterface.getCurrentUin()).encodeBool("SHOW_IN_SIMPLE_MODE", z16);
        }
    }

    public static void W(SingleLineTextView singleLineTextView, i iVar, QQAppInterface qQAppInterface, Context context) {
        X(singleLineTextView, iVar, qQAppInterface, context, null);
    }

    public static void X(SingleLineTextView singleLineTextView, i iVar, QQAppInterface qQAppInterface, Context context, f fVar) {
        boolean g16 = j.g(iVar.f307795b);
        if (g16) {
            if (!j.h(iVar.f307796c)) {
                com.tencent.mobileqq.vip.api.c.a().setVipIconForFriendList(singleLineTextView, iVar.f307794a);
            } else {
                singleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            }
        }
        if (!g16) {
            int i3 = iVar.f307797d;
            if (com.tencent.mobileqq.vip.api.d.a().getHighestVipType(new VipTypeParam(i3, i3, iVar.f307799f, iVar.f307800g)) == com.tencent.mobileqq.vip.api.f.f312798b) {
                singleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            } else {
                com.tencent.mobileqq.vip.api.c.a().setVipIconForFriendList(singleLineTextView, iVar.f307794a);
            }
        }
        if ((singleLineTextView.getRightDrawable() != null || singleLineTextView.getRightDrawableExt() != null) && fVar != null) {
            fVar.a(true);
        }
        if (singleLineTextView.getRightDrawable() == null && singleLineTextView.getRightDrawableExt() == null && fVar != null) {
            fVar.a(false);
        }
    }

    public static void Y(SingleLineTextView singleLineTextView, NTVasSimpleInfo nTVasSimpleInfo, QQAppInterface qQAppInterface, Context context) {
        i iVar = new i();
        iVar.f307794a = nTVasSimpleInfo.getUin();
        iVar.f307795b = nTVasSimpleInfo.nameplateVipType;
        iVar.f307796c = nTVasSimpleInfo.grayNameplateFlag;
        iVar.f307797d = nTVasSimpleInfo.qqVipInfo;
        iVar.f307799f = nTVasSimpleInfo.superVipInfo;
        iVar.f307798e = nTVasSimpleInfo.superQqInfo;
        iVar.f307800g = nTVasSimpleInfo.bigClubInfo;
        W(singleLineTextView, iVar, qQAppInterface, context);
    }

    public static void Z(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, ImageView imageView) {
        if (!D()) {
            return;
        }
        Resources resources = imageView.getResources();
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        int c16 = c(bVar);
        int i3 = ((c16 & 15) << 8) | (c16 >> 8);
        int i16 = i3 & 255;
        if (i16 == 3) {
            friendsVipData.setNamePlateId(bVar.mTemplateId);
            friendsVipData.setVipType(i3);
            friendsVipData.setVipLevel(bVar.mBigVipLevel);
        } else if (i16 == 2) {
            friendsVipData.setNamePlateId(bVar.mTemplateId);
            friendsVipData.setVipType(i3);
            friendsVipData.setVipLevel(bVar.mVipLevel);
        }
        com.tencent.mobileqq.vas.image.c icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(resources, "", friendsVipData);
        if (icon != null) {
            imageView.setImageDrawable(icon);
            imageView.setVisibility(0);
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(QQAppInterface qQAppInterface, SubMsgType0x120$MsgBody subMsgType0x120$MsgBody) {
        List<String> list;
        List<String> list2;
        String str;
        long j3;
        long j16;
        MessageForUniteGrayTip messageForUniteGrayTip;
        com.tencent.mobileqq.graytip.g gVar;
        String str2;
        List<String> list3;
        long j17;
        String str3;
        String str4;
        boolean z16;
        List<a.C8130a> list4;
        String str5;
        int i3 = subMsgType0x120$MsgBody.uint32_notice_type.get();
        String str6 = i3 + "";
        String h16 = com.tencent.mobileqq.mutualmark.alienation.f.h(str6);
        if (QLog.isColorLevel()) {
            QLog.i(VipUtils.TAG, 1, "type:" + str6 + "origin grayStr:" + h16);
        }
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.w(VipUtils.TAG, 2, "addFriendGrayTips grayStr is empty, ignore.");
                return;
            }
            return;
        }
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        long j18 = subMsgType0x120$MsgBody.uint64_frd_uin.get();
        String valueOf = String.valueOf(j18);
        String H = ac.H(qQAppInterface, valueOf);
        long j19 = subMsgType0x120$MsgBody.uint32_notice_time.get();
        long j26 = subMsgType0x120$MsgBody.uint32_notice_type.get();
        List<String> e16 = com.tencent.mobileqq.mutualmark.oldlogic.a.e(qQAppInterface, h16, H, friendsManager);
        List<String> c16 = com.tencent.mobileqq.mutualmark.oldlogic.a.c(qQAppInterface, e16.get(0), valueOf);
        List<a.C8130a> f16 = com.tencent.mobileqq.mutualmark.oldlogic.a.f(qQAppInterface.getApp(), c16.get(0));
        String str7 = f16.get(0).f252249a;
        e16.remove(0);
        c16.remove(0);
        f16.remove(0);
        if (e.C && i3 <= 13 && i3 > 0) {
            list2 = e16;
            list = c16;
            j3 = j26;
            j16 = j19;
            str = str7;
            try {
                e0(qQAppInterface, str7, j18, e16, c16, f16, ErrorCode.YT_SDK_NETWORK_ERROR);
                return;
            } catch (Exception e17) {
                QLog.e(VipUtils.TAG, 1, "tryAddGrayNew", e17);
            }
        } else {
            list = c16;
            list2 = e16;
            str = str7;
            j3 = j26;
            j16 = j19;
        }
        com.tencent.mobileqq.graytip.g gVar2 = new com.tencent.mobileqq.graytip.g(valueOf, valueOf, str, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, ErrorCode.YT_SDK_NETWORK_ERROR, com.tencent.mobileqq.service.message.e.K0());
        if (list.size() > 0) {
            int i16 = 0;
            while (i16 < list.size()) {
                Bundle bundle = new Bundle();
                List<String> list5 = list;
                String str8 = list5.get(i16);
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("image_resource", str8);
                    str5 = str;
                    int lastIndexOf = str5.lastIndexOf(str8);
                    if (lastIndexOf >= 0) {
                        gVar2.b(lastIndexOf, str8.length() + lastIndexOf, bundle);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str5 + "iconPos=" + lastIndexOf + "icon=" + str8 + "grayStr=" + str5);
                    }
                    list4 = f16;
                } else {
                    list4 = f16;
                    str5 = str;
                }
                i16++;
                f16 = list4;
                list = list5;
                str = str5;
            }
        }
        List<a.C8130a> list6 = f16;
        String str9 = str;
        if (list2.size() > 0) {
            List<String> list7 = list2;
            Collections.sort(list7, new c());
            ArrayList arrayList = new ArrayList();
            int i17 = 0;
            while (i17 < list7.size()) {
                Bundle bundle2 = new Bundle();
                String str10 = list7.get(i17);
                if (!TextUtils.isEmpty(str10)) {
                    list3 = list7;
                    bundle2.putInt("key_action", 11);
                    bundle2.putString("key_action_DATA", str10);
                    str3 = str6;
                    int i18 = 0;
                    while (true) {
                        int indexOf = str9.indexOf(str10, i18);
                        if (indexOf < 0) {
                            str2 = str9;
                            j17 = j16;
                            str4 = str10;
                        } else {
                            i18 = str10.length() + indexOf;
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    str4 = str10;
                                    Pair pair = (Pair) it.next();
                                    str2 = str9;
                                    if (indexOf >= ((Integer) pair.first).intValue() && indexOf < ((Integer) pair.second).intValue()) {
                                        z16 = true;
                                        break;
                                    } else {
                                        str10 = str4;
                                        str9 = str2;
                                    }
                                } else {
                                    str2 = str9;
                                    str4 = str10;
                                    z16 = false;
                                    break;
                                }
                            }
                            if (z16) {
                                j17 = j16;
                            } else {
                                j17 = j16;
                                arrayList.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(i18)));
                                if (indexOf >= 0) {
                                    gVar2.b(indexOf, i18, bundle2);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(VipUtils.TAG, 2, "spanPos=" + indexOf + " fromIndex=" + i18);
                                    }
                                }
                            }
                        }
                        if (indexOf < 0) {
                            break;
                        }
                        j16 = j17;
                        str10 = str4;
                        str9 = str2;
                    }
                } else {
                    str2 = str9;
                    list3 = list7;
                    j17 = j16;
                    str3 = str6;
                }
                i17++;
                str6 = str3;
                j16 = j17;
                list7 = list3;
                str9 = str2;
            }
        }
        String str11 = str9;
        long j27 = j16;
        String str12 = str6;
        for (int i19 = 0; i19 < list6.size(); i19++) {
            a.C8130a c8130a = list6.get(i19);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("key_action", 1);
            bundle3.putString("key_action_DATA", c8130a.f252250b.replace("{uin}", valueOf));
            int i26 = c8130a.f252251c;
            if (i26 >= 0) {
                gVar2.b(i26, c8130a.f252249a.length() + i26, bundle3);
            }
        }
        MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
        messageForUniteGrayTip2.hasRead = 0;
        messageForUniteGrayTip2.initGrayTipMsg(qQAppInterface, gVar2);
        StringBuilder sb5 = new StringBuilder(21);
        sb5.append(j27);
        sb5.append("_");
        sb5.append(j3);
        messageForUniteGrayTip2.saveExtInfoToExtStr("friendIconType", str12);
        messageForUniteGrayTip2.tipParam.f213693p = sb5.toString();
        List<MessageRecord> Q = qQAppInterface.getMessageFacade().Q(valueOf, 0);
        if (Q != null && !Q.isEmpty()) {
            MessageRecord messageRecord = Q.get(Q.size() - 1);
            if ((messageRecord instanceof MessageForUniteGrayTip) && (gVar = (messageForUniteGrayTip = (MessageForUniteGrayTip) messageRecord).tipParam) != null && messageForUniteGrayTip.subType == messageForUniteGrayTip2.subType && gVar.f213683f.equals(messageForUniteGrayTip2.tipParam.f213683f) && messageForUniteGrayTip2.tipParam.f213686i - messageForUniteGrayTip.tipParam.f213686i <= 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                    return;
                }
                return;
            }
        }
        VasWebviewUtil.reportCommercialDrainage(qQAppInterface.getCurrentAccountUin(), "friendspark", "aio_show", "", 0, 0, 0, "", str12, "", "", "", "", "", 0, 0, 0, 0);
        if (!TextUtils.isEmpty(str11)) {
            com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip2);
        }
    }

    public static void a0(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, int i3) {
        b0(context, str, str2, str3, onClickListener, str4, i3, false);
    }

    public static void b(QBaseActivity qBaseActivity, boolean z16, int i3, boolean z17, String str) {
        if (qBaseActivity != null && !TextUtils.isEmpty(str) && i3 > 0) {
            h hVar = new h();
            hVar.f307786a = qBaseActivity.getAppRuntime().getCurrentAccountUin();
            hVar.f307789d = str;
            hVar.f307792g = i3;
            hVar.f307793h = z17;
            if (z16) {
                hVar.f307790e = "1450000516";
                hVar.f307787b = "CJCLUBT";
                hVar.f307788c = qBaseActivity.getString(R.string.f173184hu3);
                hVar.f307791f = "svip";
            } else {
                hVar.f307790e = "1450000515";
                hVar.f307787b = "LTMCLUB";
                hVar.f307788c = qBaseActivity.getString(R.string.d2p);
                hVar.f307791f = "vip";
            }
            O(qBaseActivity, hVar);
        }
    }

    public static void b0(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, int i3, boolean z16) {
        c0(context, str, str2, str3, onClickListener, str4, i3, z16, "");
    }

    public static int c(com.tencent.mobileqq.qqexpand.bean.feed.b bVar) {
        int i3;
        int i16 = bVar.mVipType;
        if ((i16 & 2) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (bVar.mVipHide) {
            return 0;
        }
        if (!bVar.mBigVipHide && bVar.mBigVipLevel > 0) {
            return i3 + 768;
        }
        if ((i16 & 256) == 0 || bVar.mVipLevel <= 0) {
            return 0;
        }
        return i3 + 512;
    }

    public static void c0(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, int i3, boolean z16, String str5) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, HardCodeUtil.qqStr(R.string.vhd), str2, str3, HardCodeUtil.qqStr(R.string.vgt), new a(z16, str5, context, str, str4, i3), onClickListener);
        if (!createCustomDialog.isShowing()) {
            createCustomDialog.show();
        }
    }

    public static boolean d() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        boolean isEnable = VasToggle.isEnable("vas_show_nameplate_in_concisetheme", true);
        if (qQAppInterface != null) {
            if (VasMMKV.getVipNamePlate(qQAppInterface.getCurrentUin()).decodeBool("SHOW_IN_SIMPLE_MODE", true) && isEnable) {
                return true;
            }
            return false;
        }
        return isEnable;
    }

    public static void d0(Context context, boolean z16) {
        int i3;
        String qqStr = HardCodeUtil.qqStr(R.string.vhm);
        if (z16) {
            i3 = 16;
        } else {
            i3 = 9;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, qqStr, j(0, i3).toString(), HardCodeUtil.qqStr(R.string.vhs), (String) null, (DialogInterface.OnClickListener) null, new b());
        if (!createCustomDialog.isShowing()) {
            createCustomDialog.show();
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String replace = str.replace("-", "_");
        if (!replace.contains("_")) {
            return "jhan_" + replace;
        }
        return replace;
    }

    private static void e0(QQAppInterface qQAppInterface, String str, long j3, List<String> list, List<String> list2, List<a.C8130a> list3, int i3) {
        e eVar;
        int lastIndexOf;
        int lastIndexOf2;
        int lastIndexOf3;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), 1, i3, 1, true, false, null);
        ArrayList<e> arrayList = new ArrayList();
        if (list2.size() > 0) {
            for (String str2 : list2) {
                if (!TextUtils.isEmpty(str2) && (lastIndexOf3 = str.lastIndexOf(str2)) >= 0) {
                    e eVar2 = new e(str2, lastIndexOf3, str2.length() + lastIndexOf3);
                    eVar2.f307783h = 1;
                    arrayList.add(eVar2);
                }
            }
        }
        if (list.size() > 0) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3) && (lastIndexOf2 = str.lastIndexOf(str3)) >= 0) {
                    e eVar3 = new e(str3, lastIndexOf2, str3.length() + lastIndexOf2);
                    eVar3.f307784i = str3;
                    eVar3.f307783h = 2;
                    arrayList.add(eVar3);
                }
            }
        }
        if (list3.size() > 0) {
            for (a.C8130a c8130a : list3) {
                if (!TextUtils.isEmpty(c8130a.f252249a) && (lastIndexOf = str.lastIndexOf(c8130a.f252249a)) >= 0) {
                    String str4 = c8130a.f252249a;
                    e eVar4 = new e(str4, lastIndexOf, str4.length() + lastIndexOf);
                    eVar4.f307784i = c8130a.f252250b;
                    eVar4.f307783h = 2;
                    arrayList.add(eVar4);
                }
            }
        }
        if (arrayList.size() == 0) {
            localGrayTipBuilder.g(str, 1);
        } else {
            Collections.sort(arrayList);
            int size = arrayList.size();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                e eVar5 = (e) arrayList.get(i16);
                int i17 = size - 1;
                if (i16 < i17) {
                    eVar = (e) arrayList.get(i16 + 1);
                } else {
                    eVar = null;
                }
                if (i16 == 0 && eVar5.f307781e > 0) {
                    arrayList.add(new e(str.substring(0, eVar5.f307781e), 0, eVar5.f307781e));
                }
                if (i16 == i17 && eVar5.f307782f < str.length() - 1) {
                    arrayList.add(new e(str.substring(eVar5.f307782f), eVar5.f307782f, str.length()));
                }
                if (eVar != null && eVar.f307781e - eVar5.f307782f > 0) {
                    arrayList.add(new e(str.substring(eVar5.f307782f, eVar.f307781e), eVar5.f307782f, eVar.f307781e));
                }
            }
            Collections.sort(arrayList);
            for (e eVar6 : arrayList) {
                if (eVar6.f307783h == 0) {
                    localGrayTipBuilder.g(eVar6.f307780d, 1);
                } else if (eVar6.f307783h == 1) {
                    localGrayTipBuilder.c(eVar6.f307780d, eVar6.f307785m, "");
                } else if (eVar6.f307783h == 2) {
                    if (eVar6.f307784i.startsWith("http")) {
                        localGrayTipBuilder.a(eVar6.f307780d, eVar6.f307784i, 3);
                    } else {
                        localGrayTipBuilder.e(eVar6.f307780d, eVar6.f307784i, 3);
                    }
                }
            }
        }
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, localGrayTipBuilder.m(), new d());
    }

    public static int f(int i3) {
        if (i3 != 0 && i3 != -100) {
            if ((i3 & 2) != 0) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static void f0(Context context, int i3) {
        String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_EXTEND_ICON_URL + i3);
        if (TextUtils.isEmpty(url)) {
            url = "https://h5.qzone.qq.com/v2/vip/dhy/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32";
        }
        VasWebviewUtil.openQQBrowserActivity(context, url, 256L, null, false, -1);
    }

    public static int g(AppInterface appInterface, String str, long j3) {
        byte[] k3 = k(str);
        if (k3 != null && k3.length > 2) {
            submsgtype0xc7$SpecialInfo submsgtype0xc7_specialinfo = new submsgtype0xc7$SpecialInfo();
            try {
                submsgtype0xc7_specialinfo.mergeFrom(k3, 2, k3.length - 2);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isDebugVersion()) {
                    QLog.e(VipUtils.TAG, 1, "getCurSpecialType InvalidProtocolBufferMicroException : ", e16);
                }
            }
            for (submsgtype0xc7$SpeciesFlag submsgtype0xc7_speciesflag : submsgtype0xc7_specialinfo.list.get()) {
                if (submsgtype0xc7_speciesflag.flag_id.get() == j3) {
                    return submsgtype0xc7_speciesflag.special_type.get();
                }
            }
        }
        return 0;
    }

    public static String h(AppInterface appInterface, String str) {
        int privilegeFlags = VasUtil.getSignedService(appInterface).getVipStatus().getPrivilegeFlags(str);
        if ((privilegeFlags & 4) != 0) {
            return "2";
        }
        if ((privilegeFlags & 2) != 0) {
            return "1";
        }
        return "0";
    }

    public static int i(int i3, int i16) {
        Date date = new Date(i3 * 1000);
        Date date2 = new Date(i16 * 1000);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        date2.setHours(0);
        date2.setMinutes(0);
        date2.setSeconds(0);
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    public static SpannableString j(int i3, int i16) {
        String str;
        String str2;
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i17 = i(currentTimeMillis, i3);
        if (i17 >= 0) {
            if (i17 == 0) {
                str = HardCodeUtil.qqStr(R.string.vhe);
            } else if (i17 == 1) {
                str = HardCodeUtil.qqStr(R.string.vgz);
            } else if (i17 == 2) {
                str = HardCodeUtil.qqStr(R.string.vhn);
            } else {
                str = i17 + HardCodeUtil.qqStr(R.string.vhh);
            }
        } else {
            str = "";
        }
        String qqStr = HardCodeUtil.qqStr(R.string.vh7);
        switch (i16) {
            case 0:
                SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.vgx) + str + HardCodeUtil.qqStr(R.string.vhb) + qqStr);
                int length = spannableString.length() - qqStr.length();
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length, qqStr.length() + length, 34);
                return spannableString;
            case 1:
                SpannableString spannableString2 = new SpannableString(HardCodeUtil.qqStr(R.string.vhu) + str + HardCodeUtil.qqStr(R.string.vgv) + qqStr);
                int length2 = spannableString2.length() - qqStr.length();
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length2, qqStr.length() + length2, 34);
                return spannableString2;
            case 2:
                SpannableString spannableString3 = new SpannableString(HardCodeUtil.qqStr(R.string.f172912vh4) + qqStr);
                int length3 = spannableString3.length() - qqStr.length();
                spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length3, qqStr.length() + length3, 34);
                return spannableString3;
            case 3:
                SpannableString spannableString4 = new SpannableString(HardCodeUtil.qqStr(R.string.vhi) + qqStr);
                int length4 = spannableString4.length() - qqStr.length();
                spannableString4.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length4, qqStr.length() + length4, 34);
                return spannableString4;
            case 4:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vh_) + str + HardCodeUtil.qqStr(R.string.vhr));
            case 5:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vh5) + str + HardCodeUtil.qqStr(R.string.vgy));
            case 6:
                return new SpannableString(HardCodeUtil.qqStr(R.string.f172909vh1));
            case 7:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhg));
            case 8:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhj));
            case 9:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhc));
            case 10:
                SpannableString spannableString5 = new SpannableString(HardCodeUtil.qqStr(R.string.vho) + str + HardCodeUtil.qqStr(R.string.vgu) + qqStr);
                int length5 = spannableString5.length() - qqStr.length();
                spannableString5.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length5, qqStr.length() + length5, 34);
                return spannableString5;
            case 11:
                SpannableString spannableString6 = new SpannableString(HardCodeUtil.qqStr(R.string.vhp) + qqStr);
                int length6 = spannableString6.length() - qqStr.length();
                spannableString6.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length6, qqStr.length() + length6, 34);
                return spannableString6;
            case 12:
                int i18 = i(currentTimeMillis, i3) + 30;
                if (i18 >= 0) {
                    if (i18 == 0) {
                        str2 = HardCodeUtil.qqStr(R.string.f172911vh3);
                    } else if (i18 == 1) {
                        str2 = HardCodeUtil.qqStr(R.string.vht);
                    } else if (i18 == 2) {
                        str2 = HardCodeUtil.qqStr(R.string.vh9);
                    } else {
                        str2 = i18 + HardCodeUtil.qqStr(R.string.vh6);
                    }
                    SpannableString spannableString7 = new SpannableString(HardCodeUtil.qqStr(R.string.vhk) + str2 + HardCodeUtil.qqStr(R.string.vha) + qqStr);
                    int length7 = spannableString7.length() - qqStr.length();
                    spannableString7.setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), length7, qqStr.length() + length7, 34);
                    return spannableString7;
                }
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhk) + HardCodeUtil.qqStr(R.string.vgw) + HardCodeUtil.qqStr(R.string.vha));
            case 13:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vh8));
            case 14:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhf));
            case 15:
                return new SpannableString(HardCodeUtil.qqStr(R.string.vhl));
            case 16:
                return new SpannableString(HardCodeUtil.qqStr(R.string.f172908vh0));
            case 17:
                return new SpannableString(HardCodeUtil.qqStr(R.string.f214685tk) + str + HardCodeUtil.qqStr(R.string.f214695tl));
            default:
                return null;
        }
    }

    @Nullable
    private static byte[] k(String str) {
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService()) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (TextUtils.isEmpty(uidFromUin)) {
                return null;
            }
            new ArrayList().add(uidFromUin);
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, VipUtils.TAG);
            byte[] bArr = new byte[0];
            if (intimateSimpleInfoWithUid != null) {
                return intimateSimpleInfoWithUid.b();
            }
            return bArr;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid2 = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(ev.b(str), VipUtils.TAG);
        if (intimateSimpleInfoWithUid2 == null || intimateSimpleInfoWithUid2.b() == null) {
            return null;
        }
        return intimateSimpleInfoWithUid2.b();
    }

    public static int l(AppInterface appInterface, String str, int i3) {
        byte[] k3 = k(str);
        if (k3 == null) {
            return 0;
        }
        int o16 = o(i3, k3);
        if (QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : k3) {
                sb5.append("" + ((int) b16) + " ");
            }
            VasLogNtReporter.getMutualMark().reportDebug("getFriendRelationIconType uin=" + str + " relationType=" + i3 + " relationIconType=" + o16 + " vas_flags=" + ((Object) sb5));
        }
        return o16;
    }

    public static int m(int i3) {
        boolean z16;
        if (FontSettingManager.getFontLevel() > 17.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Resources resources = BaseApplicationImpl.getApplication().getResources();
        float f16 = 180.0f;
        if (i3 != 1) {
            if (!z16) {
                f16 = 200.0f;
            }
            return BaseAIOUtils.f(f16, resources);
        }
        if (z16) {
            f16 = 160.0f;
        }
        return BaseAIOUtils.f(f16, resources);
    }

    public static int n(AppRuntime appRuntime, String str) {
        int privilegeFlags = VasUtil.getSignedService(appRuntime).getVipStatus().getPrivilegeFlags(str);
        if ((privilegeFlags & 4) != 0) {
            return 2;
        }
        if ((privilegeFlags & 2) != 0) {
            return 1;
        }
        return 0;
    }

    private static int o(int i3, byte[] bArr) {
        int i16;
        if (bArr.length > 1) {
            i16 = (bArr[0] & 255) | (bArr[1] << 8);
        } else if (bArr.length == 1) {
            i16 = bArr[0];
        } else {
            i16 = 0;
        }
        if (QLog.isDebugVersion()) {
            VasLogNtReporter.getMutualMark().reportDebug("relationIconFlag " + Integer.toBinaryString(i16));
        }
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 == 5) {
                return (i16 >> (i3 * 2)) & 7;
            }
        } else if (com.tencent.mobileqq.mutualmark.alienation.f.i().n()) {
            return (i16 >> (i3 * 2)) & 3;
        }
        return 0;
    }

    public static int p(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null) {
            if (TextUtils.isEmpty(str)) {
                str = qQAppInterface.getCurrentAccountUin();
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
            if (vasSimpleInfoWithUid != null) {
                boolean c16 = com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_QQVIP);
                if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP)) {
                    return 3;
                }
                if (c16) {
                    return 2;
                }
                return 1;
            }
            if (QLog.isColorLevel()) {
                QLog.e(VipUtils.TAG, 2, "getUserStatus Friends is null");
            }
        }
        return -1;
    }

    public static short q(AppRuntime appRuntime, String str) {
        return r(appRuntime, str, true);
    }

    public static short r(AppRuntime appRuntime, String str, boolean z16) {
        int b16;
        int i3;
        if (appRuntime != null) {
            if (TextUtils.isEmpty(str)) {
                str = appRuntime.getAccount();
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
            if (vasSimpleInfoWithUid != null) {
                EVIPSPEC evipspec = EVIPSPEC.E_SP_BIGCLUB;
                if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec)) {
                    b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec);
                    i3 = 768;
                } else {
                    EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
                    if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec2)) {
                        b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec2);
                        i3 = 512;
                    } else {
                        EVIPSPEC evipspec3 = EVIPSPEC.E_SP_QQVIP;
                        if (com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec3)) {
                            b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec3);
                            i3 = 256;
                        }
                    }
                }
                return (short) (b16 | i3);
            }
            if (QLog.isColorLevel()) {
                QLog.e(VipUtils.TAG, 2, "getPrivilegeFlags Friends is null");
            }
        }
        return (short) 0;
    }

    public static short s(AppRuntime appRuntime, String str, EVIPSPEC evipspec) {
        int b16;
        int i3;
        if (appRuntime != null) {
            if (TextUtils.isEmpty(str)) {
                str = appRuntime.getAccount();
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), VipUtils.TAG);
            if (vasSimpleInfoWithUid != null) {
                EVIPSPEC evipspec2 = EVIPSPEC.E_SP_BIGCLUB;
                if (evipspec == evipspec2 && com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec2)) {
                    b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec2);
                    i3 = 768;
                } else {
                    EVIPSPEC evipspec3 = EVIPSPEC.E_SP_SUPERVIP;
                    if (evipspec == evipspec3 && com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec3)) {
                        b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec3);
                        i3 = 512;
                    } else {
                        EVIPSPEC evipspec4 = EVIPSPEC.E_SP_QQVIP;
                        if (evipspec == evipspec4 && com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec4)) {
                            b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec4);
                            i3 = 256;
                        }
                    }
                }
                return (short) (b16 | i3);
            }
            if (QLog.isColorLevel()) {
                QLog.e(VipUtils.TAG, 2, "getPrivilegeFlags Friends is null");
            }
        }
        return (short) 0;
    }

    public static String t(QQAppInterface qQAppInterface) {
        if (VasUtil.getSignedService(qQAppInterface).getVipStatus().isBigClub()) {
            return "bvip";
        }
        if (VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip()) {
            return "svip";
        }
        if (VasUtil.getSignedService(qQAppInterface).getVipStatus().isVip()) {
            return "vip";
        }
        return "normal";
    }

    public static int u(int i3) {
        if (i3 != 0 && i3 != -100) {
            if ((i3 & 2) != 0) {
                if ((i3 & 256) != 0) {
                    return 4;
                }
                return 3;
            }
            if ((i3 & 256) != 0) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static int v(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 == 12) {
                    return 1;
                }
                if (i3 == 19) {
                    return 5;
                }
                return -1;
            }
            return 0;
        }
        return 4;
    }

    public static void w(AppRuntime appRuntime, Context context, String str) {
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String format = String.format("https://h5.qzone.qq.com/bigVip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source=%s", str);
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(context, format, 256L, intent, false, -1);
    }

    public static void x(Context context) {
        y(0, IProfileCardConst.VIP_QQ_FROM_OTHER, "qita", IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.KUOLIE_PERSONAL_CARD_MASTER), context);
    }

    public static boolean y(int i3, String str, String str2, String str3, Context context) {
        if (context == null) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder(str3);
        if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append("&platform=1");
        } else {
            sb5.append("?platform=1");
        }
        sb5.append("&qq=0");
        sb5.append("&adtag=" + str2);
        sb5.append("&aid=" + str);
        if (i3 == 1) {
            sb5.append("&jumplevelset=1");
        }
        String sb6 = sb5.toString();
        long currentTimeMillis = System.currentTimeMillis();
        if (!ProfileUtils.isValidClick(f307772a, currentTimeMillis)) {
            return true;
        }
        f307772a = currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "gotoQQVipWeb() url = " + sb6);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (E(sb6)) {
            ax c16 = bi.c(qQAppInterface, context, sb6);
            if (c16 != null) {
                c16.b();
                return false;
            }
            QLog.e(VipUtils.TAG, 1, "gotoQQvipWeb, parse mqqAPI url failed.");
            return true;
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, sb6);
        } else {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
            intent.putExtra("url", sb6);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            context.startActivity(intent);
        }
        return false;
    }

    public static void z(AppRuntime appRuntime, Context context, String str) {
        A(appRuntime, context, str, null);
    }
}
