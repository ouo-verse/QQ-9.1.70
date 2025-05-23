package com.tencent.mobileqq.vas.pay.page;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.pay.page.ak;
import com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.URLUtil;
import e23.MonthlyPayData;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u0001d\u0018\u0000 P2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0014\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u001dJ\u001a\u0010 \u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\u0006R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010,R$\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u00102R$\u00108\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\t098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010@\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105R%\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020A\u0018\u0001090\u000e8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001f\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\u000e8\u0006\u00a2\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010ER\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0\u000e8\u0006\u00a2\u0006\f\n\u0004\bK\u0010C\u001a\u0004\bL\u0010ER\u001f\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u000e8\u0006\u00a2\u0006\f\n\u0004\bO\u0010C\u001a\u0004\bP\u0010ER\u001f\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\bR\u0010C\u001a\u0004\bS\u0010ER\u001f\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010C\u001a\u0004\bV\u0010ER\u001f\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0\u000e8\u0006\u00a2\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bX\u0010ER\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020Z0\u000e8\u0006\u00a2\u0006\f\n\u0004\b%\u0010C\u001a\u0004\b[\u0010ER\u0016\u0010^\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010]R\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u0010R$\u0010b\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b`\u0010\u0010\u001a\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010]R\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/ak;", "Lh23/b;", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "p", "Lh23/c;", "selectItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "K", "", "type", "code", "E", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "liveData", "I", "B", "", "source", "D", "O", "H", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "N", "Lj23/g;", HippyTKDListViewAdapter.X, "J", "", BdhLogUtil.LogTag.Tag_Conn, "isCheckPhonePay", "P", BdhLogUtil.LogTag.Tag_Req, "a", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "o", "M", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/vas/pay/page/ao;", "Lcom/tencent/mobileqq/vas/pay/page/ao;", "model", "Ldu4/i;", "Ldu4/i;", "lastRequestData", "", "<set-?>", "c", "getClickFlag", "()J", "clickFlag", "d", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "aid", "", "e", "Ljava/util/List;", "businessTypeList", "f", "policyId", "g", "hippyTrace", "Lj23/a;", tl.h.F, "Landroidx/lifecycle/MutableLiveData;", "t", "()Landroidx/lifecycle/MutableLiveData;", VideoTemplateParser.ITEM_LIST, "i", "y", "selectedItem", "Lj23/e;", "j", "v", "personalInfo", "Lj23/b;", "k", "u", "payItemInfo", "l", ReportConstant.COSTREPORT_PREFIX, IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "w", "phonePayCallDialog", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "_2099CallDialog", "Lh23/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "showSelectPayTypeDialog", "Z", "isAutoStartPay", "selectPayType", "r", "()I", "curPageVipType", "isReportPayModuleExposure", "com/tencent/mobileqq/vas/pay/page/ak$b", "Lcom/tencent/mobileqq/vas/pay/page/ak$b;", "friendUpdateListener", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ak implements h23.b {

    /* renamed from: v, reason: collision with root package name */
    private static boolean f310364v;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private du4.i lastRequestData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> businessTypeList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String policyId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String hippyTrace;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<j23.a>> itemList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<j23.a> selectedItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<j23.e> personalInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<j23.b> payItemInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<OpenHippyInfo> hippyInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<RenewalPageToggleConfig.DialogCall> phonePayCallDialog;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<RenewalPageToggleConfig.DialogCall> _2099CallDialog;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<h23.a> showSelectPayTypeDialog;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoStartPay;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int selectPayType;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int curPageVipType;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isReportPayModuleExposure;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b friendUpdateListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ao model = new ao();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long clickFlag = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String aid = "mvip.p.a.fc_spcc";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/pay/page/ak$b", "Lcom/tencent/mobileqq/vas/pay/page/n;", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements n {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Friends friend, ak this$0) {
            AppRuntime appRuntime;
            Intrinsics.checkNotNullParameter(friend, "$friend");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                appRuntime = mobileQQ.peekAppRuntime();
            } else {
                appRuntime = null;
            }
            if (appRuntime != null && TextUtils.equals(friend.uin, appRuntime.getCurrentAccountUin())) {
                QLog.i("VipExpiredPayViewModel", 1, "friend data updated!");
                this$0.I(this$0.v());
            }
        }

        @Override // com.tencent.mobileqq.vas.pay.page.n
        public void a(@NotNull final Friends friend) {
            Intrinsics.checkNotNullParameter(friend, "friend");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ak akVar = ak.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.al
                @Override // java.lang.Runnable
                public final void run() {
                    ak.b.c(Friends.this, akVar);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/vas/pay/page/ak$c", "Lh23/d;", "Ldu4/i;", "result", "", "d", "rsp", "b", "", "data", "c", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements h23.d<du4.i> {
        c() {
        }

        private final void b(du4.i rsp) {
            QLog.i("VipExpiredPayViewModel", 1, "replaceDefPayInfo payInfo!! use default data!");
            Map<Integer, du4.d> payInfo = j.INSTANCE.e().getPayInfo();
            if (payInfo != null) {
                rsp.f394990b = payInfo;
            }
        }

        private final void d(du4.i result) {
            String str;
            du4.d dVar;
            du4.c[] monthInfo;
            ArrayList<j23.a> arrayList = new ArrayList();
            Map<Integer, du4.d> map = result.f394990b;
            if (map != null && (dVar = map.get(Integer.valueOf(ak.this.getCurPageVipType()))) != null && (monthInfo = dVar.f394966k) != null) {
                Intrinsics.checkNotNullExpressionValue(monthInfo, "monthInfo");
                int length = monthInfo.length;
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    du4.c monthInfo2 = monthInfo[i3];
                    Intrinsics.checkNotNullExpressionValue(monthInfo2, "monthInfo");
                    arrayList.add(new j23.a(i16, monthInfo2, false, 4, null));
                    i3++;
                    i16++;
                }
            }
            MutableLiveData<List<j23.a>> t16 = ak.this.t();
            ak akVar = ak.this;
            l lVar = l.f310417a;
            String aid = akVar.getAid();
            String str2 = akVar.policyId;
            String str3 = j.INSTANCE.g().get(Integer.valueOf(akVar.getCurPageVipType()));
            if (str3 == null) {
                str3 = "";
            }
            l.g(lVar, 111, "", aid, str2, str3, 0, 0, 96, null);
            for (j23.a aVar : arrayList) {
                l lVar2 = l.f310417a;
                String aid2 = akVar.getAid();
                String str4 = akVar.policyId;
                String str5 = j.INSTANCE.g().get(Integer.valueOf(akVar.getCurPageVipType()));
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                l.g(lVar2, 101, "", aid2, str4, str, aVar.getMonthInfo().f394941h, 0, 64, null);
            }
            t16.setValue(arrayList);
        }

        @Override // h23.d
        public void a(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("VipExpiredPayViewModel", 1, "request failure");
            du4.i iVar = new du4.i();
            b(iVar);
            d(iVar);
        }

        @Override // h23.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull du4.i result, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            ak.this.lastRequestData = result;
            QLog.i("VipExpiredPayViewModel", 1, "request success: " + result);
            Map<Integer, du4.k> map = result.f394989a;
            if (map != null) {
                ak akVar = ak.this;
                du4.k kVar = map.get(Integer.valueOf(akVar.getCurPageVipType()));
                if (kVar != null) {
                    MutableLiveData<j23.e> v3 = akVar.v();
                    j23.e eVar = new j23.e(kVar);
                    l lVar = l.f310417a;
                    lVar.d(akVar.getCurPageVipType(), eVar.getVipState().f395000g, eVar.getVipState().f394999f);
                    lVar.c(111, eVar.getVipState().f395000g);
                    lVar.c(101, eVar.getVipState().f395000g);
                    v3.setValue(eVar);
                }
            }
            if (result.f394990b == null) {
                QLog.i("VipExpiredPayViewModel", 1, "request success but no payInfo!! use default data!");
                b(result);
            }
            d(result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/pay/page/ak$d", "Lcom/tencent/mobileqq/vip/api/k;", "", "code", "", "a", "", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.mobileqq.vip.api.k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f310388b;

        d(int i3) {
            this.f310388b = i3;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            ak.this.F();
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ak.this.E(this.f310388b, code);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/pay/page/ak$e", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements com.tencent.mobileqq.vip.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e23.c f310390b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f310391c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f310392d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/pay/page/ak$e$a", "Lh23/a;", "", "action", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements h23.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ak f310393a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f310394b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e23.c f310395c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f310396d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f310397e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f310398f;

            a(ak akVar, String str, e23.c cVar, String str2, String str3, String str4) {
                this.f310393a = akVar;
                this.f310394b = str;
                this.f310395c = cVar;
                this.f310396d = str2;
                this.f310397e = str3;
                this.f310398f = str4;
            }

            @Override // h23.a
            public void action() {
                int i3;
                String str;
                du4.c monthInfo;
                this.f310393a.isAutoStartPay = true;
                JSONObject jSONObject = new JSONObject(this.f310394b);
                String offerId = jSONObject.optString("app_id");
                String optString = jSONObject.optString("productid");
                String serviceType = jSONObject.optString("serviceType");
                int optInt = jSONObject.optInt("month");
                String reportData = jSONObject.optString("reportData");
                e23.c cVar = this.f310395c;
                Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                Intrinsics.checkNotNullExpressionValue(serviceType, "serviceType");
                String uin = this.f310396d;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                j23.a value = this.f310393a.y().getValue();
                if (value != null && (monthInfo = value.getMonthInfo()) != null) {
                    i3 = monthInfo.f394941h;
                } else {
                    i3 = 0;
                }
                int i16 = i3;
                JSONObject jSONObject2 = new JSONObject();
                String str2 = this.f310398f;
                jSONObject2.put("apf", "2");
                jSONObject2.put("preorder_bill", str2);
                Unit unit = Unit.INSTANCE;
                String encode = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(JSONObject().appl\u2026   }.toString(), \"utf-8\")");
                String str3 = this.f310397e;
                String str4 = this.f310398f;
                if (optInt != 1) {
                    str = optInt + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
                cVar.a(new e23.a(offerId, serviceType, serviceType, uin, i16, encode, null, null, null, null, null, null, null, null, null, null, optString, str3, str4, str, null, reportData, 1114048, null), this.f310393a.selectPayType);
            }
        }

        e(e23.c cVar, String str, int i3) {
            this.f310390b = cVar;
            this.f310391c = str;
            this.f310392d = i3;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            ak.this.F();
        }

        @Override // com.tencent.mobileqq.vip.api.h
        public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
            Intrinsics.checkNotNullParameter(vipMa, "vipMa");
            Intrinsics.checkNotNullParameter(billno, "billno");
            Intrinsics.checkNotNullParameter(payStr, "payStr");
            ak.this.z().setValue(null);
            ak.this.z().setValue(new a(ak.this, payStr, this.f310390b, this.f310391c, vipMa, billno));
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ak.this.E(this.f310392d, code);
        }
    }

    public ak() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        this.businessTypeList = arrayList;
        this.policyId = "XLT10";
        this.hippyTrace = "";
        this.itemList = new MutableLiveData<>();
        this.selectedItem = new MutableLiveData<>();
        this.personalInfo = new MutableLiveData<>();
        this.payItemInfo = new MutableLiveData<>();
        this.hippyInfo = new MutableLiveData<>();
        this.phonePayCallDialog = new MutableLiveData<>();
        this._2099CallDialog = new MutableLiveData<>();
        this.showSelectPayTypeDialog = new MutableLiveData<>();
        this.curPageVipType = 3;
        this.friendUpdateListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int type, int code) {
        QLog.e("VipExpiredPayViewModel", 1, "pay error type: " + type + ", code: " + code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        f310364v = true;
        QQToast.makeText(BaseApplication.context, 2, "\u652f\u4ed8\u6210\u529f", 1).show();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.ai
            @Override // java.lang.Runnable
            public final void run() {
                ak.G(ak.this);
            }
        }, 16, null, false, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(MutableLiveData<?> liveData) {
        Object value = liveData.getValue();
        if (value == 0) {
            return;
        }
        liveData.setValue(null);
        liveData.setValue(value);
    }

    private final void K() {
        if (VasNormalToggle.VAS_PAY_PAGE_DELAY_REFRESH_PERSONAL.isEnable(true)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.aj
                @Override // java.lang.Runnable
                public final void run() {
                    ak.L(ak.this);
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I(this$0.personalInfo);
    }

    public static /* synthetic */ void Q(ak akVar, Activity activity, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        akVar.P(activity, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
        this$0.K();
    }

    private final void m(h23.c selectItem) {
        String str;
        String str2;
        List<j23.a> value = this.itemList.getValue();
        if (value != null) {
            int i3 = 0;
            for (Object obj : value) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                j23.a aVar = (j23.a) obj;
                aVar.setSelected(Intrinsics.areEqual(selectItem, aVar));
                if (aVar.getIsSelected()) {
                    this.selectedItem.setValue(aVar);
                    this.payItemInfo.setValue(new j23.b(aVar.getMonthInfo()));
                    if (!this.isReportPayModuleExposure) {
                        l lVar = l.f310417a;
                        String str3 = this.aid;
                        String str4 = this.policyId;
                        String str5 = j.INSTANCE.g().get(Integer.valueOf(this.curPageVipType));
                        if (str5 == null) {
                            str2 = "";
                        } else {
                            str2 = str5;
                        }
                        lVar.e(111, "", str3, str4, str2);
                        this.isReportPayModuleExposure = true;
                    }
                    l lVar2 = l.f310417a;
                    String str6 = this.aid;
                    String str7 = this.policyId;
                    String str8 = j.INSTANCE.g().get(Integer.valueOf(this.curPageVipType));
                    if (str8 == null) {
                        str = "";
                    } else {
                        str = str8;
                    }
                    lVar2.e(101, "", str6, str7, str);
                }
                i3 = i16;
            }
        }
    }

    private final OpenHippyInfo p() {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        j.Companion companion = j.INSTANCE;
        openHippyInfo.bundleName = companion.j();
        openHippyInfo.domain = companion.i();
        openHippyInfo.processName = "main";
        openHippyInfo.isDisablePreload = true;
        openHippyInfo.from = "vas_pay";
        openHippyInfo.url = URLUtil.addParameter("page=cuifei", "traceDetail", this.hippyTrace);
        return openHippyInfo;
    }

    @NotNull
    public final MutableLiveData<RenewalPageToggleConfig.DialogCall> A() {
        return this._2099CallDialog;
    }

    public final void B() {
        QVipRenewalFriendProcessor.INSTANCE.a(this.friendUpdateListener);
    }

    public final boolean C() {
        du4.c monthInfo;
        j23.a value = this.selectedItem.getValue();
        if (value == null || (monthInfo = value.getMonthInfo()) == null || monthInfo.f394938e != 1) {
            return false;
        }
        return true;
    }

    public final void D(@NotNull String source) {
        List split$default;
        Intrinsics.checkNotNullParameter(source, "source");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(source);
        String str = argumentsFromURL.get("aid");
        if (str != null && !TextUtils.isEmpty(str)) {
            this.aid = str;
        }
        String str2 = argumentsFromURL.get("businessType");
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                Integer num = j.INSTANCE.f().get((String) it.next());
                if (num != null) {
                    arrayList.add(Integer.valueOf(num.intValue()));
                }
            }
            if (!arrayList.isEmpty()) {
                this.businessTypeList = arrayList;
            }
        }
        String str3 = argumentsFromURL.get("policyID");
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            this.policyId = str3;
        }
        String str4 = argumentsFromURL.get("hippyTrace");
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            this.hippyTrace = str4;
        }
    }

    public final void H() {
        I(this.itemList);
        I(this.selectedItem);
        I(this.personalInfo);
        I(this.payItemInfo);
        I(this.hippyInfo);
    }

    public final void J() {
        ao aoVar = this.model;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        aoVar.c(peekAppRuntime, this.aid, this.businessTypeList, this.policyId, new c());
    }

    public final void M(int type) {
        this.selectPayType = type;
    }

    public final void N(@Nullable Activity activity) {
        j23.e value = this.personalInfo.getValue();
        if (value == null || value.getVipState().f395000g != 0) {
            return;
        }
        j23.e value2 = this.personalInfo.getValue();
        if (value2 != null) {
            l.f310417a.c(102, value2.getVipState().f395000g);
        }
        List<j23.a> value3 = this.itemList.getValue();
        if (value3 != null) {
            for (j23.a aVar : value3) {
                if (aVar.getMonthInfo().f394938e == 2) {
                    b(aVar);
                    Q(this, activity, false, 2, null);
                    return;
                }
            }
        }
    }

    public final void O() {
        OpenHippyInfo openHippyInfo;
        j.Companion companion = j.INSTANCE;
        if (companion.e().getHippy() != null) {
            RenewalPageToggleConfig.Hippy hippy = companion.e().getHippy();
            boolean z16 = false;
            if (hippy != null && hippy.getSwitch() == 1) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
        }
        RenewalPageToggleConfig.Hippy hippy2 = companion.e().getHippy();
        if (hippy2 != null) {
            openHippyInfo = hippy2.getHippyInfo();
        } else {
            openHippyInfo = null;
        }
        if (openHippyInfo != null && !TextUtils.isEmpty(openHippyInfo.bundleName) && !TextUtils.isEmpty(openHippyInfo.domain)) {
            openHippyInfo.url = URLUtil.addParameter(openHippyInfo.url, "traceDetail", this.hippyTrace);
            this.hippyInfo.setValue(openHippyInfo);
        } else {
            this.hippyInfo.setValue(p());
        }
    }

    public final void P(@Nullable Activity activity, boolean isCheckPhonePay) {
        boolean z16;
        du4.c monthInfo;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        du4.c monthInfo2;
        du4.c monthInfo3;
        du4.g gVar;
        du4.c monthInfo4;
        du4.c monthInfo5;
        du4.g gVar2;
        du4.c monthInfo6;
        du4.g gVar3;
        du4.c monthInfo7;
        du4.g gVar4;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        du4.c monthInfo8;
        du4.g gVar5;
        du4.c monthInfo9;
        du4.g gVar6;
        du4.c monthInfo10;
        du4.g gVar7;
        du4.c monthInfo11;
        du4.c monthInfo12;
        du4.g gVar8;
        du4.c monthInfo13;
        du4.j jVar;
        boolean z17;
        du4.k vipState;
        if (activity == null) {
            return;
        }
        String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        int i3 = 0;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        e23.c cVar = new e23.c(activity);
        j23.a value = this.selectedItem.getValue();
        if (value != null && (monthInfo = value.getMonthInfo()) != null) {
            int i16 = monthInfo.f394938e;
            du4.i iVar = this.lastRequestData;
            String str19 = null;
            if (iVar != null) {
                if (isCheckPhonePay) {
                    j23.e value2 = this.personalInfo.getValue();
                    if (value2 != null && (vipState = value2.getVipState()) != null && vipState.f394998e) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        this.phonePayCallDialog.setValue(null);
                        this.phonePayCallDialog.setValue(j.INSTANCE.e().getPhoneCall());
                        return;
                    }
                }
                du4.k kVar = iVar.f394989a.get(4);
                if (kVar != null && kVar.f395000g == 2) {
                    Calendar calendar = Calendar.getInstance();
                    j.Companion companion = j.INSTANCE;
                    calendar.set(1, companion.e().getMaxYear().getMaxYear());
                    calendar.set(2, 0);
                    calendar.set(5, 1);
                    if (kVar.f394995b * 1000 >= calendar.getTime().getTime()) {
                        this._2099CallDialog.setValue(null);
                        this._2099CallDialog.setValue(companion.e().getMaxYear().getDialog());
                        return;
                    }
                }
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 5) {
                            QLog.i("VipExpiredPayViewModel", 1, "\u652f\u4ed8\u7c7b\u578b\u6682\u4e0d\u652f\u6301");
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(uin, "uin");
                        String str20 = this.aid;
                        j23.a value3 = this.selectedItem.getValue();
                        if (value3 != null && (monthInfo13 = value3.getMonthInfo()) != null && (jVar = monthInfo13.f394934a) != null) {
                            str19 = jVar.f394992b;
                        }
                        if (str19 == null) {
                            str19 = "";
                        }
                        cVar.b(uin, str20, str19, new e(cVar, uin, i16));
                    }
                }
                j23.a value4 = this.selectedItem.getValue();
                if (value4 != null && (monthInfo12 = value4.getMonthInfo()) != null && (gVar8 = monthInfo12.f394948o) != null) {
                    str12 = gVar8.f394983b;
                } else {
                    str12 = null;
                }
                if (str12 == null) {
                    str13 = "";
                } else {
                    str13 = str12;
                }
                j23.a value5 = this.selectedItem.getValue();
                if (value5 != null && (monthInfo11 = value5.getMonthInfo()) != null) {
                    i3 = monthInfo11.f394941h;
                }
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                j23.a value6 = this.selectedItem.getValue();
                if (value6 != null && (monthInfo10 = value6.getMonthInfo()) != null && (gVar7 = monthInfo10.f394948o) != null) {
                    str14 = gVar7.f394982a;
                } else {
                    str14 = null;
                }
                if (str14 == null) {
                    str15 = "";
                } else {
                    str15 = str14;
                }
                j23.a value7 = this.selectedItem.getValue();
                if (value7 != null && (monthInfo9 = value7.getMonthInfo()) != null && (gVar6 = monthInfo9.f394948o) != null) {
                    str16 = gVar6.f394985d;
                } else {
                    str16 = null;
                }
                if (str16 == null) {
                    str17 = "";
                } else {
                    str17 = str16;
                }
                String str21 = this.aid;
                j23.a value8 = this.selectedItem.getValue();
                if (value8 != null && (monthInfo8 = value8.getMonthInfo()) != null && (gVar5 = monthInfo8.f394948o) != null) {
                    str18 = gVar5.f394984c;
                } else {
                    str18 = null;
                }
                cVar.c(new MonthlyPayData(str13, i3, uin, str15, str17, str21, null, false, null, null, false, null, str18, 4032, null), new d(i16));
            } else {
                this.isAutoStartPay = true;
                j23.a value9 = this.selectedItem.getValue();
                if (value9 != null && (monthInfo7 = value9.getMonthInfo()) != null && (gVar4 = monthInfo7.f394948o) != null) {
                    str = gVar4.f394983b;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                j23.a value10 = this.selectedItem.getValue();
                if (value10 != null && (monthInfo6 = value10.getMonthInfo()) != null && (gVar3 = monthInfo6.f394948o) != null) {
                    str3 = gVar3.f394982a;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str4 = "";
                } else {
                    str4 = str3;
                }
                j23.a value11 = this.selectedItem.getValue();
                if (value11 != null && (monthInfo5 = value11.getMonthInfo()) != null && (gVar2 = monthInfo5.f394948o) != null) {
                    str5 = gVar2.f394985d;
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    str6 = "";
                } else {
                    str6 = str5;
                }
                j23.a value12 = this.selectedItem.getValue();
                if (value12 != null && (monthInfo4 = value12.getMonthInfo()) != null) {
                    i3 = monthInfo4.f394941h;
                }
                String str22 = this.aid;
                j23.a value13 = this.selectedItem.getValue();
                if (value13 != null && (monthInfo3 = value13.getMonthInfo()) != null && (gVar = monthInfo3.f394948o) != null) {
                    str7 = gVar.f394984c;
                } else {
                    str7 = null;
                }
                if (str7 == null) {
                    str8 = "";
                } else {
                    str8 = str7;
                }
                j23.a value14 = this.selectedItem.getValue();
                if (value14 != null && (monthInfo2 = value14.getMonthInfo()) != null) {
                    str19 = monthInfo2.f394954u;
                }
                if (str19 == null) {
                    str9 = "";
                } else {
                    str9 = str19;
                }
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                cVar.a(new e23.a(str2, str4, str6, uin, i3, str22, null, null, null, null, null, null, null, null, null, str9, str8, null, null, null, null, null, 4095936, null), this.selectPayType);
            }
            l lVar = l.f310417a;
            String str23 = this.aid;
            String str24 = this.policyId;
            j.Companion companion2 = j.INSTANCE;
            String str25 = companion2.g().get(Integer.valueOf(this.curPageVipType));
            if (str25 == null) {
                str10 = "";
            } else {
                str10 = str25;
            }
            lVar.e(102, "", str23, str24, str10);
            String str26 = this.aid;
            String str27 = this.policyId;
            String str28 = companion2.g().get(Integer.valueOf(this.curPageVipType));
            if (str28 == null) {
                str11 = "";
            } else {
                str11 = str28;
            }
            lVar.e(109, "", str26, str27, str11);
        }
    }

    public final void R() {
        if (this.isAutoStartPay) {
            this.isAutoStartPay = false;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ak.S(ak.this);
                }
            }, 16, null, false, 1000L);
        }
    }

    @Override // h23.b
    public boolean a() {
        if (this.clickFlag > 0) {
            return true;
        }
        return false;
    }

    @Override // h23.b
    public void b(@NotNull h23.c item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.clickFlag = System.currentTimeMillis();
        m(item);
        l lVar = l.f310417a;
        String str = this.aid;
        String str2 = this.policyId;
        String str3 = j.INSTANCE.g().get(Integer.valueOf(this.curPageVipType));
        if (str3 == null) {
            str3 = "";
        }
        l.g(lVar, 102, "", str, str2, str3, item.c(), 0, 64, null);
    }

    public final void n() {
        QVipRenewalFriendProcessor.INSTANCE.b(this.friendUpdateListener);
        f310364v = false;
    }

    public boolean o() {
        if (this.clickFlag != -1 && System.currentTimeMillis() - this.clickFlag > 300) {
            this.clickFlag = -1L;
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    /* renamed from: r, reason: from getter */
    public final int getCurPageVipType() {
        return this.curPageVipType;
    }

    @NotNull
    public final MutableLiveData<OpenHippyInfo> s() {
        return this.hippyInfo;
    }

    @NotNull
    public final MutableLiveData<List<j23.a>> t() {
        return this.itemList;
    }

    @NotNull
    public final MutableLiveData<j23.b> u() {
        return this.payItemInfo;
    }

    @NotNull
    public final MutableLiveData<j23.e> v() {
        return this.personalInfo;
    }

    @NotNull
    public final MutableLiveData<RenewalPageToggleConfig.DialogCall> w() {
        return this.phonePayCallDialog;
    }

    @Nullable
    public final j23.g x() {
        RenewalPageToggleConfig.RetentionInfo.RetentionCell expire;
        boolean contains$default;
        if (f310364v) {
            return null;
        }
        j.Companion companion = j.INSTANCE;
        if (companion.e().getRetention().getSvipRetentionInfo().getSwitch() != 1) {
            return null;
        }
        RenewalPageToggleConfig.RetentionInfo svipRetentionInfo = companion.e().getRetention().getSvipRetentionInfo();
        j23.e value = this.personalInfo.getValue();
        if (value == null) {
            return null;
        }
        du4.k vipState = value.getVipState();
        int c16 = value.c();
        int i3 = vipState.f395000g;
        if (i3 == 2) {
            QLog.i("VipExpiredPayViewModel", 1, "state AVALIABLE , diff days: " + c16);
            if (c16 >= svipRetentionInfo.getToday().getStart() && c16 <= svipRetentionInfo.getToday().getEnd()) {
                expire = svipRetentionInfo.getToday();
            } else {
                if (c16 >= svipRetentionInfo.getAvaliable().getStart() && c16 <= svipRetentionInfo.getAvaliable().getEnd()) {
                    expire = svipRetentionInfo.getAvaliable();
                }
                expire = null;
            }
        } else {
            if (i3 == 1) {
                QLog.i("VipExpiredPayViewModel", 1, "state EXPIRED , diff days: " + c16);
                if (c16 >= svipRetentionInfo.getExpire().getStart() && c16 <= svipRetentionInfo.getExpire().getEnd()) {
                    expire = svipRetentionInfo.getExpire();
                }
            }
            expire = null;
        }
        if (expire == null) {
            return null;
        }
        String textValue = expire.getTextValue();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) textValue, (CharSequence) "%s", false, 2, (Object) null);
        if (contains$default) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            int abs = Math.abs(c16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(abs);
            textValue = String.format(textValue, Arrays.copyOf(new Object[]{sb5.toString()}, 1));
            Intrinsics.checkNotNullExpressionValue(textValue, "format(format, *args)");
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format = String.format(textValue, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return new j23.g(format, expire.getLeftText(), expire.getRightText());
    }

    @NotNull
    public final MutableLiveData<j23.a> y() {
        return this.selectedItem;
    }

    @NotNull
    public final MutableLiveData<h23.a> z() {
        return this.showSelectPayTypeDialog;
    }
}
