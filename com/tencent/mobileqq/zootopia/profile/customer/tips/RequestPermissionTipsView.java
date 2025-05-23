package com.tencent.mobileqq.zootopia.profile.customer.tips;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import bd3.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.hippy.api.ZplanVasHippyCloseEvent;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.state.SquarePublicActivity;
import com.tencent.state.report.SquareReportConst;
import id3.d;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 G2\u00020\u0001:\u0001HB\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\b@\u0010DB#\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\u0006\u0010E\u001a\u00020\f\u00a2\u0006\u0004\b@\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J$\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0016\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\"\u0010)\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b*\u0010(R\"\u00103\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b'\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u0002048\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b1\u00105\u001a\u0004\b6\u00107\"\u0004\b#\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/zootopia/profile/customer/tips/RequestPermissionTipsView;", "Lcom/tencent/mobileqq/zootopia/profile/customer/tips/BaseTipsView;", "", BdhLogUtil.LogTag.Tag_Conn, "", "w", "v", "o", "masterUin", "masterNickName", "groupId", "p", "", ISchemeApi.KEY_GUILD_ID_TYPE, "", "guildId", "ownerUin", DomainData.DOMAIN_NAME, "uin", "type", "name", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", HippyTKDListViewAdapter.X, "Landroid/view/View;", "c", "j", h.F, "k", "i", "Landroid/widget/Button;", "D", "Landroid/widget/Button;", "u", "()Landroid/widget/Button;", UserInfo.SEX_FEMALE, "(Landroid/widget/Button;)V", "openBtn", "E", "t", "knownBtn", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/ImageView;", "G", "(Landroid/widget/ImageView;)V", "topIconImg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "desTv", "Lid3/d;", "H", "Lid3/d;", "reportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class RequestPermissionTipsView extends BaseTipsView {

    /* renamed from: D, reason: from kotlin metadata */
    protected Button openBtn;

    /* renamed from: E, reason: from kotlin metadata */
    protected Button knownBtn;

    /* renamed from: F, reason: from kotlin metadata */
    protected ImageView topIconImg;

    /* renamed from: G, reason: from kotlin metadata */
    protected TextView desTv;

    /* renamed from: H, reason: from kotlin metadata */
    private d reportHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestPermissionTipsView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        View tipsView;
        Map<String, Object> mutableMapOf;
        if (this.reportHelper == null && (tipsView = getTipsView()) != null) {
            Button u16 = u();
            Button t16 = t();
            d dVar = new d(null, 1, null);
            this.reportHelper = dVar;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "tContainer.context");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, y()), TuplesKt.to("zplan_ark_stranger_status", Integer.valueOf(x())));
            dVar.j(context, this, "pg_zplan_xiaowo_visit_request_popup", mutableMapOf);
            d dVar2 = this.reportHelper;
            if (dVar2 != null) {
                d.h(dVar2, tipsView, "em_zplan_xiaowo_visit_request_popup_notice", new LinkedHashMap(), false, false, null, 32, null);
            }
            d dVar3 = this.reportHelper;
            if (dVar3 != null) {
                d.h(dVar3, u16, "em_zplan_xiaowo_visit_request_popup_request", new LinkedHashMap(), false, false, null, 32, null);
            }
            d dVar4 = this.reportHelper;
            if (dVar4 != null) {
                d.h(dVar4, t16, "em_zplan_xiaowo_visit_request_popup_confirm", new LinkedHashMap(), false, false, null, 32, null);
            }
        }
    }

    private final boolean B() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity instanceof ChatActivity) {
            return ((ChatActivity) qBaseActivity).getIntent().getBooleanExtra("KEY_OPEN_MINI_CHAT", false);
        }
        return false;
    }

    private final void C() {
        m(this.reportHelper, getTipsView());
        m(this.reportHelper, u());
        m(this.reportHelper, t());
    }

    private final void n(int guildIdType, long guildId, long ownerUin) {
        ((IZootopiaResidenceAuthApi) QRoute.api(IZootopiaResidenceAuthApi.class)).sendChannelResidenceAuthArk(guildIdType, guildId, ownerUin, new Function3<Boolean, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.profile.customer.tips.RequestPermissionTipsView$doChannelRequest$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, String str) {
                invoke(bool.booleanValue(), bool2.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, boolean z17, String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (!z17) {
                    v.f373305a.c(z16 ? R.string.xdt : R.string.xhl, errMsg);
                }
                QLog.i("RequestPermissionTipsView", 1, "sendResidenceAuthArk " + z16 + ", " + errMsg);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toBigIntegerOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o() {
        Long longOrNull;
        BigInteger bigIntegerOrNull;
        e tipsData = getTipsData();
        if (tipsData == null) {
            return;
        }
        if (tipsData instanceof bd3.d) {
            bd3.d dVar = (bd3.d) tipsData;
            p(dVar.getMasterUin(), dVar.getMasterNickName(), null);
            return;
        }
        if (tipsData instanceof TransitPageInfo) {
            TransitPageInfo transitPageInfo = (TransitPageInfo) tipsData;
            if (transitPageInfo.getConfig().getTransitType() == 1) {
                int guildIdType = transitPageInfo.getMasterInfo().getGuildIdType();
                String guildId = transitPageInfo.getMasterInfo().getGuildId();
                long longValue = (guildId == null || bigIntegerOrNull == null) ? 0L : bigIntegerOrNull.longValue();
                String uin = transitPageInfo.getMasterInfo().getUin();
                long longValue2 = (uin == null || longOrNull == null) ? 0L : longOrNull.longValue();
                n(guildIdType, longValue, longValue2);
                return;
            }
            p(transitPageInfo.getMasterInfo().getUin(), transitPageInfo.getMasterInfo().getNickName(), transitPageInfo.getMasterInfo().getGroupId());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(String uin, int type, String name) {
        ZootopiaSource source;
        ZootopiaSource source2;
        boolean isBlank;
        ZootopiaSource source3;
        e tipsData = getTipsData();
        String str = null;
        boolean z16 = false;
        if (((tipsData == null || (source3 = tipsData.getSource()) == null) ? null : source3.getMainSource()) == Source.StatusSquare) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity instanceof SquarePublicActivity) {
                if (name != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(name);
                }
                z16 = true;
                l.Z(qBaseActivity, uin, type, z16 ? uin : name, null, 2);
                return;
            }
            e tipsData2 = getTipsData();
            Source mainSource = (tipsData2 == null || (source2 = tipsData2.getSource()) == null) ? null : source2.getMainSource();
            e tipsData3 = getTipsData();
            if (tipsData3 != null && (source = tipsData3.getSource()) != null) {
                str = source.getSubSource();
            }
            QLog.i("RequestPermissionTipsView", 1, "activity is not SquareActivity mainSource: " + mainSource + ", subSource: " + str);
            return;
        }
        r(uin, 0, name);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r(String uin, int type, String name) {
        Intent aliasIntent;
        boolean z16;
        boolean isBlank;
        if (B()) {
            aliasIntent = l.w(getContext(), SplashActivity.getAliasName());
        } else {
            aliasIntent = SplashActivity.getAliasIntent(getContext());
        }
        Intent m3 = BaseAIOUtils.m(aliasIntent, null);
        m3.putExtra("uin", uin);
        m3.putExtra("uintype", type);
        if (name != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(name);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    uin = name;
                }
                m3.putExtra("uinname", uin);
                if (!(getContext() instanceof Activity)) {
                    m3.addFlags(268435456);
                }
                getContext().startActivity(m3);
            }
        }
        z16 = true;
        if (!z16) {
        }
        m3.putExtra("uinname", uin);
        if (!(getContext() instanceof Activity)) {
        }
        getContext().startActivity(m3);
    }

    private final String v() {
        return "\u7533\u8bf7\u6743\u9650";
    }

    private final String w() {
        return "\u5c0f\u7a9d\u5173\u95e8\u5566\uff0c\u53ef\u4ee5\u7533\u8bf7\u62dc\u8bbf\u6743\u9650\u54e6";
    }

    private final int x() {
        e tipsData = getTipsData();
        String smallHomeMasterUin = tipsData != null ? tipsData.getSmallHomeMasterUin() : null;
        if (smallHomeMasterUin == null || smallHomeMasterUin.length() == 0) {
            return 0;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(smallHomeMasterUin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        return iFriendsInfoService.isFriend(uid, "RequestPermissionTipsView") ? 1 : 0;
    }

    private final String y() {
        ZootopiaSource source;
        String subSource;
        e tipsData = getTipsData();
        return (tipsData == null || (source = tipsData.getSource()) == null || (subSource = source.getSubSource()) == null) ? "null" : subSource;
    }

    protected final void D(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.desTv = textView;
    }

    protected final void E(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.knownBtn = button;
    }

    protected final void F(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.openBtn = button;
    }

    protected final void G(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.topIconImg = imageView;
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public View c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.d8t, (ViewGroup) this, false);
        View findViewById = inflate.findViewById(R.id.r19);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zootop\u2026equest_permission_btn_do)");
        F((Button) findViewById);
        View findViewById2 = inflate.findViewById(R.id.r1_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zootop\u2026est_permission_btn_known)");
        E((Button) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.r1e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zootop\u2026permission_tips_top_icon)");
        G((ImageView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.r1c);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zootop\u2026uest_permission_tips_des)");
        D((TextView) findViewById4);
        u().setText(v());
        s().setText(w());
        inflate.setOnClickListener(this);
        u().setOnClickListener(this);
        t().setOnClickListener(this);
        z().setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n \u2026issionTipsView)\n        }");
        return inflate;
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public void i() {
        A();
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public void j() {
        C();
    }

    protected final TextView s() {
        TextView textView = this.desTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("desTv");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Button t() {
        Button button = this.knownBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("knownBtn");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Button u() {
        Button button = this.openBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openBtn");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView z() {
        ImageView imageView = this.topIconImg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topIconImg");
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestPermissionTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(String masterUin, String masterNickName, String groupId) {
        Long longOrNull;
        q(masterUin, 0, masterNickName);
        IZootopiaResidenceAuthApi iZootopiaResidenceAuthApi = (IZootopiaResidenceAuthApi) QRoute.api(IZootopiaResidenceAuthApi.class);
        if (masterUin == null) {
            masterUin = "";
        }
        long longValue = (groupId == null || longOrNull == null) ? 0L : longOrNull.longValue();
        iZootopiaResidenceAuthApi.sendResidenceAuthArk(masterUin, longValue, new Function3<Boolean, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.profile.customer.tips.RequestPermissionTipsView$doUinRequest$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, String str) {
                invoke(bool.booleanValue(), bool2.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, boolean z17, String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("RequestPermissionTipsView", 1, "sendResidenceAuthArk " + z16 + ", " + errMsg + ", " + z17);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestPermissionTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public void k(View v3) {
        if (v3 == null) {
            return;
        }
        int id5 = v3.getId();
        if (id5 != R.id.r1e) {
            switch (id5) {
                case R.id.r19 /* 1997015413 */:
                    if (QLog.isColorLevel()) {
                        QLog.d("RequestPermissionTipsView", 1, "click permission do");
                    }
                    l(this.reportHelper, v3);
                    o();
                    SimpleEventBus.getInstance().dispatchEvent(new ZplanVasHippyCloseEvent());
                    a();
                    return;
                case R.id.r1_ /* 1997015414 */:
                    if (QLog.isColorLevel()) {
                        QLog.d("RequestPermissionTipsView", 1, "click permission known");
                    }
                    l(this.reportHelper, v3);
                    a();
                    return;
                case R.id.r1a /* 1997015415 */:
                    if (QLog.isColorLevel()) {
                        QLog.d("RequestPermissionTipsView", 1, "click permission content container");
                        return;
                    }
                    return;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.d("RequestPermissionTipsView", 1, "click unknown");
                        return;
                    }
                    return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RequestPermissionTipsView", 1, "click permission top image");
        }
        a();
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public void h() {
    }
}
