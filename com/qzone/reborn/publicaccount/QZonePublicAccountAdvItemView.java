package com.qzone.reborn.publicaccount;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.reborn.widget.QZoneRoundCorneredLayout;
import com.qzone.util.ak;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$PicInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\u00032\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\bH\u0014R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/qzone/reborn/publicaccount/QZonePublicAccountAdvItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lmm/a;", "", "q0", "initView", "o0", "p0", "", "u0", "s0", "C0", "", "isUserClickCloseIcon", "B0", "messageData", "E0", "A0", "", "Lnm/b;", "innerMessageBlockDataList", "F0", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$PicInfo;", "picInfo", "G0", "", WadlProxyConsts.KEY_JUMP_URL, "H0", "z0", "isExposure", "y0", "x0", "w0", "v0", "getLayoutId", "data", com.tencent.luggage.wxa.c8.c.G, "setData", "r0", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mAdvCloseIcon", "Lcom/qzone/reborn/widget/QZoneRoundCorneredLayout;", tl.h.F, "Lcom/qzone/reborn/widget/QZoneRoundCorneredLayout;", "mCardContainer", "i", "mCardView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmm/a;", "mMessageData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mTianShuAdId", "D", "mTianShuTraceInfo", "E", "I", "mInnerMessageType", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublicAccountAdvItemView extends QZoneBaseWidgetView<mm.a> {

    /* renamed from: C, reason: from kotlin metadata */
    private String mTianShuAdId;

    /* renamed from: D, reason: from kotlin metadata */
    private String mTianShuTraceInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private int mInnerMessageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mAdvCloseIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRoundCorneredLayout mCardContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mCardView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private mm.a mMessageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePublicAccountAdvItemView(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        q0();
        initView();
    }

    private final void B0(boolean isUserClickCloseIcon) {
        qm.a aVar = (qm.a) getIocInterface(qm.a.class);
        if (aVar == null) {
            RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "ioc is null, return");
            return;
        }
        if (isUserClickCloseIcon) {
            x0();
        }
        mm.a aVar2 = this.mMessageData;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageData");
            aVar2 = null;
        }
        aVar.T5(aVar2);
    }

    private final void C0() {
        ImageView imageView = this.mAdvCloseIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdvCloseIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.publicaccount.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePublicAccountAdvItemView.D0(QZonePublicAccountAdvItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(QZonePublicAccountAdvItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H0(final String jumpUrl) {
        if (TextUtils.isEmpty(jumpUrl)) {
            return;
        }
        QZoneRoundCorneredLayout qZoneRoundCorneredLayout = this.mCardContainer;
        if (qZoneRoundCorneredLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            qZoneRoundCorneredLayout = null;
        }
        qZoneRoundCorneredLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.publicaccount.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePublicAccountAdvItemView.I0(QZonePublicAccountAdvItemView.this, jumpUrl, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(QZonePublicAccountAdvItemView this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0(false);
        this$0.B0(false);
        yo.d.c(str, this$0.mContext);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0() {
        QZoneRoundCorneredLayout qZoneRoundCorneredLayout = this.mCardContainer;
        QZoneRoundCorneredLayout qZoneRoundCorneredLayout2 = null;
        if (qZoneRoundCorneredLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            qZoneRoundCorneredLayout = null;
        }
        int i3 = fd.a.f398302a;
        qZoneRoundCorneredLayout.setRadius(i3, i3, i3, i3);
        QZoneRoundCorneredLayout qZoneRoundCorneredLayout3 = this.mCardContainer;
        if (qZoneRoundCorneredLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
            qZoneRoundCorneredLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = qZoneRoundCorneredLayout3.getLayoutParams();
        layoutParams.width = u0();
        layoutParams.height = s0();
        QZoneRoundCorneredLayout qZoneRoundCorneredLayout4 = this.mCardContainer;
        if (qZoneRoundCorneredLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardContainer");
        } else {
            qZoneRoundCorneredLayout2 = qZoneRoundCorneredLayout4;
        }
        qZoneRoundCorneredLayout2.setLayoutParams(layoutParams);
    }

    private final void p0() {
        ImageView imageView = this.mCardView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardView");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = u0();
        layoutParams.height = s0();
        ImageView imageView3 = this.mCardView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setLayoutParams(layoutParams);
    }

    private final void q0() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(ar.e(16.0f), ar.e(16.0f), ar.e(16.0f), ar.e(8.0f));
        setLayoutParams(layoutParams);
    }

    private final int s0() {
        return (int) (u0() * 0.5625f);
    }

    private final int u0() {
        return ar.l() - ar.d(32.0f);
    }

    private final void v0() {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(15, 1);
        lpReportInfo_dc02880.reserves1 = String.valueOf(this.mInnerMessageType);
        String str = this.mTianShuAdId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
            str = null;
        }
        lpReportInfo_dc02880.reserves3 = str;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
    }

    private final void w0(boolean isExposure) {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(15, isExposure ? 1 : 2);
        lpReportInfo_dc02880.reserves1 = String.valueOf(this.mInnerMessageType);
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
    }

    private final void x0() {
        String str = this.mTianShuAdId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String str3 = this.mTianShuTraceInfo;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                v0();
                int i3 = RFWLog.USR;
                String str4 = this.mTianShuAdId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
                    str4 = null;
                }
                String str5 = this.mTianShuTraceInfo;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                    str5 = null;
                }
                RFWLog.i("QZonePublicAccountAdvItemView", i3, "close adv, tian shu ad id is " + str4 + " trace info is " + str5);
                String str6 = this.mTianShuAdId;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
                    str6 = null;
                }
                String str7 = this.mTianShuTraceInfo;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                } else {
                    str2 = str7;
                }
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(122, str6, str2));
                return;
            }
        }
        RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "tian shu info is null");
    }

    private final void y0(boolean isExposure) {
        String str = this.mTianShuAdId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String str3 = this.mTianShuTraceInfo;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                w0(isExposure);
                int i3 = RFWLog.USR;
                String str4 = this.mTianShuAdId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
                    str4 = null;
                }
                String str5 = this.mTianShuTraceInfo;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                    str5 = null;
                }
                RFWLog.i("QZonePublicAccountAdvItemView", i3, "is exposure " + isExposure + " tian shu ad id is " + str4 + " trace info is " + str5);
                int i16 = isExposure ? 101 : 102;
                String str6 = this.mTianShuAdId;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuAdId");
                    str6 = null;
                }
                String str7 = this.mTianShuTraceInfo;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTianShuTraceInfo");
                } else {
                    str2 = str7;
                }
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(i16, str6, str2));
                return;
            }
        }
        RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "tian shu info is null");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cng;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(mm.a messageData, int pos) {
        Intrinsics.checkNotNullParameter(messageData, "messageData");
        if (!E0(messageData)) {
            setVisibility(8);
            return;
        }
        z0();
        this.mMessageData = messageData;
        setVisibility(0);
        F0(messageData.c());
    }

    private final void F0(List<nm.b> innerMessageBlockDataList) {
        nm.b bVar;
        List<nm.b> list = innerMessageBlockDataList;
        if ((list == null || list.isEmpty()) || (bVar = innerMessageBlockDataList.get(0)) == null) {
            return;
        }
        G0(bVar.k());
        H0(bVar.i());
    }

    private final void z0() {
        y0(true);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setData(mm.a data, int pos) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.setData((QZonePublicAccountAdvItemView) data, pos);
    }

    private final void A0(mm.a messageData) {
        if (messageData == null) {
            return;
        }
        Pair<String, String> a16 = messageData.a();
        Object obj = a16.first;
        Intrinsics.checkNotNullExpressionValue(obj, "advMessageAdInfo.first");
        this.mTianShuAdId = (String) obj;
        Object obj2 = a16.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "advMessageAdInfo.second");
        this.mTianShuTraceInfo = (String) obj2;
    }

    private final void G0(QZoneOfficialAccountBase$PicInfo picInfo) {
        if (picInfo == null) {
            return;
        }
        String str = picInfo.pic_url.get();
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "card url is null");
            return;
        }
        Context context = this.mContext;
        ImageView imageView = this.mCardView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardView");
            imageView = null;
        }
        com.qzone.reborn.util.h.i(context, imageView, str, u0(), s0());
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f18693o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.adv_close_icon)");
        this.mAdvCloseIcon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f18673m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.adv_card_container)");
        this.mCardContainer = (QZoneRoundCorneredLayout) findViewById2;
        View findViewById3 = findViewById(R.id.f18683n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.adv_card_view)");
        this.mCardView = (ImageView) findViewById3;
        o0();
        p0();
        C0();
    }

    private final boolean E0(mm.a messageData) {
        if (messageData == null) {
            return false;
        }
        if (messageData.c().isEmpty()) {
            RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "inner message list null of empty");
            return false;
        }
        nm.b bVar = messageData.c().get(0);
        if (TextUtils.isEmpty(bVar.i())) {
            RFWLog.e("QZonePublicAccountAdvItemView", RFWLog.USR, "inner message block data(or jump url) is null");
            return false;
        }
        this.mInnerMessageType = bVar.j();
        A0(messageData);
        if (bVar.k() == null) {
            return false;
        }
        QZoneOfficialAccountBase$PicInfo k3 = bVar.k();
        Intrinsics.checkNotNull(k3);
        return !TextUtils.isEmpty(k3.pic_url.get());
    }
}
