package com.qzone.reborn.feedx.widget.header.dragon;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.widget.header.d;
import com.qzone.reborn.util.i;
import com.qzone.reborn.util.k;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.AppSetting;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QzoneActivityPB$DisplayCfg;
import qzone.QzoneActivityPB$ReadUserActivityInfoRsp;
import qzone.QzoneActivityPB$ResourceInfo;
import qzone.QzoneActivityPB$UserActivityInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010,\u001a\u00020!\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedx/widget/header/dragon/c;", "Lcom/qzone/reborn/feedx/widget/header/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lqzone/QzoneActivityPB$UserActivityInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "t", "v", "Lqzone/QzoneActivityPB$ResourceInfo;", "bubbleResInfo", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "dragonImageView", "", "entryState", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "", BdhLogUtil.LogTag.Tag_Conn, "", "dumpKey", "y", "D", "B", "l", "j", "Lcom/qzone/common/business/result/QZoneResult;", "result", "a0", "f", "Z", "mShouldShowBubble", "Landroid/view/View;", h.F, "Landroid/view/View;", "mDragonContainer", "i", "Landroid/widget/ImageView;", "mDragonImageView", "Landroid/view/ViewStub;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewStub;", "mDragonStub", "containerView", "<init>", "(Landroid/view/View;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mShouldShowBubble;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mDragonContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mDragonImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewStub mDragonStub;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedx/widget/header/dragon/c$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QzoneActivityPB$ReadUserActivityInfoRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QzoneActivityPB$ReadUserActivityInfoRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, QzoneActivityPB$ReadUserActivityInfoRsp rsp) {
            try {
                boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
                QLog.d("QZoneFeedxHeaderDragonElement", 1, hashCode() + " | requestDragonInfo onReceive: dispatch Success:" + isSuccess + " | traceId:" + (baseRequest != null ? baseRequest.getTraceId() : null) + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | isCache:" + isProtocolCache);
                if (isSuccess && retCode == 0 && rsp != null) {
                    c.this.t(rsp.user_info);
                }
            } catch (Throwable th5) {
                RFWLog.e("QZoneFeedxHeaderDragonElement", RFWLog.USR, th5);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mza);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026.qzone_feedx_dragon_stub)");
        this.mDragonStub = (ViewStub) findViewById;
    }

    private final void A() {
        VSNetworkHelper.getInstance().sendRequest(new QZoneFeedxActivityInfoRequest(), new b());
    }

    private final boolean B() {
        com.tencent.mobileqq.service.qzone.bean.d d16;
        return (pl.a.f426446a.x() || (d16 = com.tencent.mobileqq.service.qzone.a.f286399a.d()) == null || !d16.a()) ? false : true;
    }

    private final void q() {
        if (B()) {
            QLog.d("QZoneFeedxHeaderDragonElement", 1, "shouldRequestDragon");
            A();
        } else {
            QLog.d("QZoneFeedxHeaderDragonElement", 1, "dont need request");
        }
    }

    private final void s(QzoneActivityPB$ResourceInfo bubbleResInfo) {
        if (C(bubbleResInfo)) {
            this.mShouldShowBubble = true;
            u(bubbleResInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(QzoneActivityPB$UserActivityInfo userInfo) {
        if (D(userInfo)) {
            if (this.mDragonImageView == null) {
                View inflate = this.mDragonStub.inflate();
                this.mDragonContainer = inflate;
                this.mDragonImageView = inflate != null ? (ImageView) inflate.findViewById(R.id.f162873n31) : null;
            }
            v(userInfo);
        }
    }

    private final void u(QzoneActivityPB$ResourceInfo bubbleResInfo) {
        PBStringField pBStringField;
        boolean z16 = true;
        if (this.mDragonContainer != null && bubbleResInfo != null) {
            String str = bubbleResInfo.text.get();
            if (!(str == null || str.length() == 0)) {
                QUIDefaultBubbleTip.r(g()).S(this.mDragonContainer).m0(4).o0(bubbleResInfo.text.get()).R(0).k0(2).i0(24.0f, 0.0f).s0();
                Set<String> k3 = i.b().k("qz_dragon_bubble_shown_key", new LinkedHashSet());
                QzoneActivityPB$DisplayCfg qzoneActivityPB$DisplayCfg = bubbleResInfo.display_cfg;
                String str2 = (qzoneActivityPB$DisplayCfg == null || (pBStringField = qzoneActivityPB$DisplayCfg.dump_key) == null) ? null : pBStringField.get();
                QLog.d("QZoneFeedxHeaderDragonElement", 1, hashCode() + " doShowBubble: " + bubbleResInfo.text.get() + ", key: " + str2);
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                if (k3 == null) {
                    k3 = new LinkedHashSet<>();
                }
                k3.add(str2);
                i.b().s("qz_dragon_bubble_shown_key", k3);
                return;
            }
        }
        QLog.d("QZoneFeedxHeaderDragonElement", 1, hashCode() + " doShowBubble error");
    }

    private final void v(final QzoneActivityPB$UserActivityInfo userInfo) {
        QzoneActivityPB$ResourceInfo qzoneActivityPB$ResourceInfo;
        String str;
        PBStringField pBStringField;
        QLog.d("QZoneFeedxHeaderDragonElement", 1, hashCode() + " doShowDragon ");
        if (this.mDragonImageView == null || userInfo == null || (qzoneActivityPB$ResourceInfo = userInfo.cover_res_info) == null) {
            return;
        }
        if (k.f59549a.f()) {
            str = qzoneActivityPB$ResourceInfo.bg_dark.get();
        } else {
            str = qzoneActivityPB$ResourceInfo.bg_light.get();
        }
        e eVar = e.f286406a;
        String a16 = eVar.a(str);
        QzoneActivityPB$ResourceInfo qzoneActivityPB$ResourceInfo2 = userInfo.cover_res_info;
        String str2 = (qzoneActivityPB$ResourceInfo2 == null || (pBStringField = qzoneActivityPB$ResourceInfo2.jump_url) == null) ? null : pBStringField.get();
        final String a17 = eVar.a(str2);
        QLog.d("QZoneFeedxHeaderDragonElement", 1, hashCode() + " , doShowDragon, state: " + userInfo.activity_state.get() + ", resId: " + str + ", url: " + a16 + ", jumpRes: " + str2 + ", jumpUrl: " + a17);
        if (a16 == null || a16.length() == 0) {
            return;
        }
        Option option = Option.obtain().setPreferDecoder(com.tencent.libra.extension.a.class).setUrl(a16).setTargetView(this.mDragonImageView);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.widget.header.dragon.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                c.w(c.this, userInfo, a17, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final c this$0, QzoneActivityPB$UserActivityInfo qzoneActivityPB$UserActivityInfo, final String str, LoadState loadState, Option option) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState != null && loadState.isFinishSuccess()) {
            if ((option != null ? option.getAnimatable() : null) instanceof r01.c) {
                QLog.d("QZoneFeedxHeaderDragonElement", 1, this$0.hashCode() + " anim load success");
                Animatable animatable = option.getAnimatable();
                Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                r01.c cVar = (r01.c) animatable;
                cVar.setLoopCount(100);
                cVar.start();
                this$0.s(qzoneActivityPB$UserActivityInfo.text_res_info);
                this$0.z(this$0.mDragonImageView, qzoneActivityPB$UserActivityInfo.activity_state.get());
                if ((str == null || str.length() == 0) || (imageView = this$0.mDragonImageView) == null) {
                    return;
                }
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.dragon.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.x(c.this, str, view);
                    }
                });
                return;
            }
        }
        QLog.d("QZoneFeedxHeaderDragonElement", 1, this$0.hashCode() + " anim load error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(c this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.q(this$0.g(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean y(String dumpKey) {
        Set<String> k3 = i.b().k("qz_dragon_bubble_shown_key", new LinkedHashSet());
        if (k3 != null) {
            return k3.contains(dumpKey);
        }
        return false;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult result) {
        if (g.f53821a.b().G1()) {
            q();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderDragonElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        q();
    }

    private final boolean C(QzoneActivityPB$ResourceInfo bubbleResInfo) {
        PBStringField pBStringField;
        if (bubbleResInfo != null) {
            String str = bubbleResInfo.text.get();
            if (!(str == null || str.length() == 0)) {
                if (AppSetting.isDebugVersion()) {
                    return true;
                }
                QzoneActivityPB$DisplayCfg qzoneActivityPB$DisplayCfg = bubbleResInfo.display_cfg;
                String str2 = (qzoneActivityPB$DisplayCfg == null || (pBStringField = qzoneActivityPB$DisplayCfg.dump_key) == null) ? null : pBStringField.get();
                return ((str2 == null || str2.length() == 0) || y(str2)) ? false : true;
            }
        }
        return false;
    }

    private final boolean D(QzoneActivityPB$UserActivityInfo userInfo) {
        if (userInfo == null || userInfo.cover_res_info.get() == null || userInfo.cover_res_info.get().bg_light == null) {
            return false;
        }
        String str = userInfo.cover_res_info.get().bg_light.get();
        return !(str == null || str.length() == 0);
    }

    private final void z(ImageView dragonImageView, int entryState) {
        String str;
        Map<String, Object> mutableMapOf;
        if (dragonImageView != null) {
            Pair[] pairArr = new Pair[2];
            if (this.mShouldShowBubble) {
                str = "1";
            } else {
                str = "0";
            }
            pairArr[0] = TuplesKt.to("is_bubble", str);
            pairArr[1] = TuplesKt.to("entry_state", Integer.valueOf(entryState));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            fo.c.o(dragonImageView, "em_qz_mobile_entrance", new fo.b().l(mutableMapOf));
        }
    }
}
