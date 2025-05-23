package com.tencent.mobileqq.zplan.card.impl.view.videoCard;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanBaseDownloadButtonItemView;
import com.tencent.mobileqq.zplan.card.impl.view.videoCard.ZootopiaBigVideoView;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.widget.RoundFrameLayout;
import com.tencent.sqshow.zootopia.portal.home.ParadiseLifecycleAdapter;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import pa4.a;
import pu4.g;
import pv4.n;
import pv4.q;
import pv4.s;
import pv4.u;
import pv4.v;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001[B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010.\u001a\u00020#\u0012\u0006\u00104\u001a\u00020/\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0005J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0017\u0010.\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010=R\u0016\u0010@\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010H\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00107R\u0016\u0010J\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00107R\u0016\u0010L\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010CR\u0016\u0010N\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010=R\u0016\u0010P\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u00107R\u0014\u0010S\u001a\u00020Q8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bR\u0010?R\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/videoCard/ZootopiaBigVideoView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanBaseDownloadButtonItemView;", "Lpa4/a;", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", HippyTKDListViewAdapter.X, "Lpv4/s;", "data", ReportConstant.COSTREPORT_PREFIX, "v", "Lpv4/v;", "r", "w", "t", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lpv4/n;", DomainData.DOMAIN_NAME, "", "visibility", "B", "campData", BdhLogUtil.LogTag.Tag_Conn, "Lpv4/u;", "sourceData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View$OnClickListener;", "listener", "setContentClickListener", "p", "Landroidx/lifecycle/LifecycleOwner;", "owner", DKHippyEvent.EVENT_STOP, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Loa4/a;", h.F, "Loa4/a;", "getMapResViewModel", "()Loa4/a;", "mapResViewModel", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/widget/RoundFrameLayout;", "Lcom/tencent/sqshow/widget/RoundFrameLayout;", "containView", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "videoView", "D", "iconView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleDescView", UserInfo.SEX_FEMALE, "modNameView", "G", "tagsView", "H", "friendsIconView", "I", "campaignTimer", "J", "campaignBg", "K", "backgroundView", "", "L", "rate", "Landroid/os/CountDownTimer;", "M", "Landroid/os/CountDownTimer;", "campaignBeginTimer", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;)V", "N", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaBigVideoView extends ZplanBaseDownloadButtonItemView implements a {
    private static final int P = ViewUtils.dpToPx(4.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private ZPlanMediaView videoView;

    /* renamed from: D, reason: from kotlin metadata */
    private ZPlanMediaView iconView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView titleDescView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView modNameView;

    /* renamed from: G, reason: from kotlin metadata */
    private View tagsView;

    /* renamed from: H, reason: from kotlin metadata */
    private View friendsIconView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView campaignTimer;

    /* renamed from: J, reason: from kotlin metadata */
    private ZPlanMediaView campaignBg;

    /* renamed from: K, reason: from kotlin metadata */
    private View backgroundView;

    /* renamed from: L, reason: from kotlin metadata */
    private final double rate;

    /* renamed from: M, reason: from kotlin metadata */
    private CountDownTimer campaignBeginTimer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundFrameLayout containView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/videoCard/ZootopiaBigVideoView$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZootopiaBigVideoView f332435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f332436b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f332437c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, ZootopiaBigVideoView zootopiaBigVideoView, n nVar, s sVar) {
            super(j3, 1000L);
            this.f332435a = zootopiaBigVideoView;
            this.f332436b = nVar;
            this.f332437c = sVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f332435a.q(this.f332437c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            this.f332435a.C(this.f332436b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaBigVideoView(Context context, LifecycleOwner lifecycleOwner, oa4.a mapResViewModel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        this.lifecycleOwner = lifecycleOwner;
        this.mapResViewModel = mapResViewModel;
        this.rate = 0.6965317919075145d;
        o(context);
        lifecycleOwner.getLifecycle().addObserver(new ParadiseLifecycleAdapter(this, lifecycleOwner));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ZootopiaBigVideoView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b().getVisibility() == 0) {
            this$0.b().performClick();
            return;
        }
        ZPlanMediaView zPlanMediaView = this$0.videoView;
        if (zPlanMediaView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView = null;
        }
        zPlanMediaView.performClick();
    }

    private final void B(int visibility) {
        TextView textView = this.campaignTimer;
        ZPlanMediaView zPlanMediaView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("campaignTimer");
            textView = null;
        }
        textView.setVisibility(visibility);
        ZPlanMediaView zPlanMediaView2 = this.campaignBg;
        if (zPlanMediaView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("campaignBg");
        } else {
            zPlanMediaView = zPlanMediaView2;
        }
        zPlanMediaView.setVisibility(visibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView] */
    public final void C(n campData) {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime < campData.f427636a) {
            B(4);
            return;
        }
        TextView textView = null;
        if (campData.f427639d <= serverTime) {
            long j3 = campData.f427640e;
            if (j3 >= serverTime) {
                String c16 = t.f373300a.c(j3 - serverTime);
                u m3 = m(campData.f427641f);
                String str = m3.f427702a;
                m3.f427702a = str != null ? StringsKt__StringsJVMKt.replace$default(str, "{TIME}", c16, false, 4, (Object) null) : null;
                B(0);
                TextView textView2 = this.campaignTimer;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("campaignTimer");
                } else {
                    textView = textView2;
                }
                m84.b.h(textView, m3);
                return;
            }
        }
        TextView textView3 = this.campaignTimer;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("campaignTimer");
            textView3 = null;
        }
        textView3.setVisibility(4);
        ?? r152 = this.campaignBg;
        if (r152 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("campaignBg");
        } else {
            textView = r152;
        }
        textView.setVisibility(getVisibility());
    }

    private final u m(u sourceData) {
        u uVar = new u();
        uVar.f427702a = sourceData != null ? sourceData.f427702a : null;
        uVar.f427704c = sourceData != null ? sourceData.f427704c : null;
        return uVar;
    }

    private final n n(s data) {
        n[] nVarArr = data.f427691l;
        if (nVarArr == null) {
            return null;
        }
        if (nVarArr.length == 0) {
            return null;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        for (n nVar : nVarArr) {
            if (serverTime < nVar.f427637b) {
                return nVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(s data) {
        n n3 = n(data);
        if (n3 != null) {
            B(0);
            ZPlanMediaView zPlanMediaView = this.campaignBg;
            if (zPlanMediaView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("campaignBg");
                zPlanMediaView = null;
            }
            g gVar = n3.f427638c;
            Intrinsics.checkNotNullExpressionValue(gVar, "campaign.icon");
            zPlanMediaView.e(gVar);
            long serverTime = NetConnInfoCenter.getServerTime();
            long j3 = n3.f427636a;
            long j16 = n3.f427637b;
            u uVar = n3.f427641f;
            String str = uVar != null ? uVar.f427702a : null;
            QLog.d("ZootopiaBigVideoView", 1, "campaign info begin: " + j3 + " - end: " + j16 + " now :" + serverTime + "  , title => " + str + " , countStart: " + n3.f427639d + " , countdownEnd: " + n3.f427640e);
            long j17 = (n3.f427637b - serverTime) * 1000;
            CountDownTimer countDownTimer = this.campaignBeginTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            b bVar = new b(j17, this, n3, data);
            this.campaignBeginTimer = bVar;
            bVar.start();
            return;
        }
        CountDownTimer countDownTimer2 = this.campaignBeginTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        B(8);
    }

    private final void r(v data) {
        List listOf;
        View view = this.friendsIconView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
            view = null;
        }
        view.setVisibility(0);
        g[] gVarArr = data.f427706a;
        int length = gVarArr != null ? gVarArr.length : 0;
        if (length <= 0) {
            View view3 = this.friendsIconView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
            } else {
                view2 = view3;
            }
            view2.setVisibility(8);
            return;
        }
        ZPlanMediaView[] zPlanMediaViewArr = new ZPlanMediaView[3];
        View view4 = this.friendsIconView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
            view4 = null;
        }
        View findViewById = view4.findViewById(R.id.r5q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "friendsIconView.findView\u2026Id(R.id.zplan_icon_first)");
        zPlanMediaViewArr[0] = (ZPlanMediaView) findViewById;
        View view5 = this.friendsIconView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
            view5 = null;
        }
        View findViewById2 = view5.findViewById(R.id.r5s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "friendsIconView.findViewById(R.id.zplan_icon_mid)");
        zPlanMediaViewArr[1] = (ZPlanMediaView) findViewById2;
        View view6 = this.friendsIconView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
            view6 = null;
        }
        View findViewById3 = view6.findViewById(R.id.r5r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "friendsIconView.findViewById(R.id.zplan_icon_last)");
        zPlanMediaViewArr[2] = (ZPlanMediaView) findViewById3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) zPlanMediaViewArr);
        int size = listOf.size();
        for (int i3 = 0; i3 < size; i3++) {
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) listOf.get(i3);
            if (length > i3) {
                zPlanMediaView.setRadius(9);
                g gVar = data.f427706a[i3];
                Intrinsics.checkNotNullExpressionValue(gVar, "data.icons[i]");
                zPlanMediaView.e(gVar);
            } else {
                zPlanMediaView.setVisibility(8);
            }
        }
        View view7 = this.friendsIconView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
        } else {
            view2 = view7;
        }
        TextView renderFriendInfo$lambda$2 = (TextView) view2.findViewById(R.id.f163652r94);
        Intrinsics.checkNotNullExpressionValue(renderFriendInfo$lambda$2, "renderFriendInfo$lambda$2");
        m84.b.h(renderFriendInfo$lambda$2, data.f427707b);
    }

    private final void s(s data) {
        v vVar = data.f427692m;
        View view = null;
        if (vVar != null) {
            g[] gVarArr = vVar.f427706a;
            boolean z16 = false;
            if (gVarArr != null) {
                if (gVarArr.length == 0) {
                    z16 = true;
                }
            }
            if (!z16) {
                View view2 = this.tagsView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsView");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                r(vVar);
                return;
            }
        }
        View view3 = this.friendsIconView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
        } else {
            view = view3;
        }
        view.setVisibility(8);
        v(data);
    }

    private final void t(s data) {
        g gVar;
        ZPlanMediaView zPlanMediaView = this.iconView;
        ZPlanMediaView zPlanMediaView2 = null;
        if (zPlanMediaView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            zPlanMediaView = null;
        }
        zPlanMediaView.setRadius(8);
        q qVar = data.f427686g;
        if (qVar == null || (gVar = qVar.f427653a) == null) {
            return;
        }
        ZPlanMediaView zPlanMediaView3 = this.iconView;
        if (zPlanMediaView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        } else {
            zPlanMediaView2 = zPlanMediaView3;
        }
        zPlanMediaView2.e(gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(s data) {
        TextView textView;
        u uVar = data.f427683d;
        TextView textView2 = null;
        if (uVar != null) {
            TextView textView3 = this.modNameView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modNameView");
                textView3 = null;
            }
            m84.b.h(textView3, uVar);
        }
        TextView textView4 = this.modNameView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modNameView");
            textView4 = null;
        }
        ViewGroup.LayoutParams layoutParams = textView4.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topToTop = R.id.r3c;
        }
        View view = this.tagsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsView");
            view = null;
        }
        if (view.getVisibility() != 0) {
            View view2 = this.friendsIconView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsIconView");
                view2 = null;
            }
            if (view2.getVisibility() != 0) {
                if (layoutParams2 != null) {
                    layoutParams2.bottomToBottom = R.id.r3c;
                }
                if (layoutParams2 != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i.b(5);
                }
                textView = this.modNameView;
                if (textView != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modNameView");
                } else {
                    textView2 = textView;
                }
                textView2.setLayoutParams(layoutParams2);
            }
        }
        if (layoutParams2 != null) {
            layoutParams2.bottomToBottom = -1;
        }
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i.b(4);
        }
        textView = this.modNameView;
        if (textView != null) {
        }
        textView2.setLayoutParams(layoutParams2);
    }

    private final void v(s data) {
        List listOf;
        u[] uVarArr = data.f427689j;
        View view = null;
        if (uVarArr != null) {
            if (!(uVarArr.length == 0)) {
                View view2 = this.tagsView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsView");
                    view2 = null;
                }
                view2.setVisibility(0);
                TextView[] textViewArr = new TextView[3];
                View view3 = this.tagsView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsView");
                    view3 = null;
                }
                View findViewById = view3.findViewById(R.id.r8o);
                Intrinsics.checkNotNullExpressionValue(findViewById, "tagsView.findViewById(R.id.zplan_tag_first)");
                textViewArr[0] = (TextView) findViewById;
                View view4 = this.tagsView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsView");
                    view4 = null;
                }
                View findViewById2 = view4.findViewById(R.id.r8r);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "tagsView.findViewById(R.id.zplan_tag_mid)");
                textViewArr[1] = (TextView) findViewById2;
                View view5 = this.tagsView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsView");
                } else {
                    view = view5;
                }
                View findViewById3 = view.findViewById(R.id.r8p);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "tagsView.findViewById(R.id.zplan_tag_last)");
                textViewArr[2] = (TextView) findViewById3;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) textViewArr);
                int length = uVarArr.length;
                int size = listOf.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (length > i3) {
                        m84.b.h((TextView) listOf.get(i3), uVarArr[i3]);
                    } else {
                        ((TextView) listOf.get(i3)).setVisibility(8);
                    }
                }
                return;
            }
        }
        View view6 = this.tagsView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsView");
        } else {
            view = view6;
        }
        view.setVisibility(8);
    }

    private final void w(s data) {
        TextView textView = this.titleDescView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleDescView");
            textView = null;
        }
        m84.b.h(textView, data.f427680a);
    }

    private final void x(g material) {
        ZPlanMediaView zPlanMediaView;
        final int c16 = t74.u.INSTANCE.c(getContext()) - (getResources().getDimensionPixelSize(R.dimen.f12046e) * 2);
        int i3 = (int) (c16 * this.rate);
        ZPlanMediaView zPlanMediaView2 = this.videoView;
        ZPlanMediaView zPlanMediaView3 = null;
        if (zPlanMediaView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView = null;
        } else {
            zPlanMediaView = zPlanMediaView2;
        }
        m84.b.c(zPlanMediaView, c16, i3, null, 4, null);
        ZPlanMediaView zPlanMediaView4 = this.videoView;
        if (zPlanMediaView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView4 = null;
        }
        zPlanMediaView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ZPlanMediaView zPlanMediaView5 = this.videoView;
        if (zPlanMediaView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView5 = null;
        }
        zPlanMediaView5.setTag(material);
        ZPlanMediaView zPlanMediaView6 = this.videoView;
        if (zPlanMediaView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView6 = null;
        }
        zPlanMediaView6.J(material);
        RoundFrameLayout roundFrameLayout = this.containView;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containView");
            roundFrameLayout = null;
        }
        roundFrameLayout.setRadius(i.b(5));
        ZPlanMediaView zPlanMediaView7 = this.videoView;
        if (zPlanMediaView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            zPlanMediaView3 = zPlanMediaView7;
        }
        zPlanMediaView3.post(new Runnable() { // from class: cg3.c
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaBigVideoView.y(ZootopiaBigVideoView.this, c16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZootopiaBigVideoView this$0, int i3) {
        ZPlanMediaView zPlanMediaView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.backgroundView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
            view = null;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (measuredWidth != i3) {
            QLog.d("ZootopiaBigVideoView", 1, "backWidth: " + measuredWidth + " , viewWidth: " + i3 + " , screenWidth: " + t74.u.INSTANCE.c(this$0.getContext()) + ", 15dp: " + this$0.getResources().getDimensionPixelSize(R.dimen.f12046e));
            int i16 = (int) (((double) measuredWidth) * this$0.rate);
            ZPlanMediaView zPlanMediaView2 = this$0.videoView;
            if (zPlanMediaView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                zPlanMediaView = null;
            } else {
                zPlanMediaView = zPlanMediaView2;
            }
            m84.b.c(zPlanMediaView, measuredWidth, i16, null, 4, null);
        }
    }

    public final void o(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dal, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026g_video_card, this, true)");
        this.view = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.r46);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.zplan_download_button)");
        g((ZplanCommonButton) findViewById);
        View view2 = this.view;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.r6r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.zplan_media_wrap)");
        this.containView = (RoundFrameLayout) findViewById2;
        View view3 = this.view;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.r9x);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.zplan_video)");
        this.videoView = (ZPlanMediaView) findViewById3;
        View view4 = this.view;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.r9b);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.zplan_tv_title)");
        this.titleDescView = (TextView) findViewById4;
        View view5 = this.view;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.r5o);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.zplan_icon)");
        this.iconView = (ZPlanMediaView) findViewById5;
        View view6 = this.view;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.r98);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.zplan_tv_name)");
        this.modNameView = (TextView) findViewById6;
        View view7 = this.view;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.r8q);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.zplan_tag_list)");
        this.tagsView = findViewById7;
        View view8 = this.view;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.r4s);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.zplan_friend_icon)");
        this.friendsIconView = findViewById8;
        View view9 = this.view;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.f163650r92);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.zplan_tv_campaign_timer)");
        this.campaignTimer = (TextView) findViewById9;
        View view10 = this.view;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view10 = null;
        }
        View findViewById10 = view10.findViewById(R.id.r3i);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.zplan_campaign_bg)");
        this.campaignBg = (ZPlanMediaView) findViewById10;
        View view11 = this.view;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            view = view11;
        }
        View findViewById11 = view.findViewById(R.id.r3c);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.zplan_bg_container)");
        this.backgroundView = findViewById11;
        setDownloadButtonBinder(new ZootopiaDownloadButtonBinder(context, this.lifecycleOwner, this.mapResViewModel));
    }

    @Override // pa4.a
    public void onDestroy(LifecycleOwner owner) {
        CountDownTimer countDownTimer = this.campaignBeginTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void p() {
        ZPlanMediaView zPlanMediaView = this.videoView;
        ZPlanMediaView zPlanMediaView2 = null;
        if (zPlanMediaView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView = null;
        }
        Object tag = zPlanMediaView.getTag();
        g gVar = tag instanceof g ? (g) tag : null;
        if (gVar == null) {
            return;
        }
        ZPlanMediaView zPlanMediaView3 = this.videoView;
        if (zPlanMediaView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            zPlanMediaView2 = zPlanMediaView3;
        }
        zPlanMediaView2.e(gVar);
    }

    public final void setContentClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanMediaView zPlanMediaView = this.videoView;
        if (zPlanMediaView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            zPlanMediaView = null;
        }
        aa.d(zPlanMediaView, listener);
    }

    public final void z(s data) {
        Intrinsics.checkNotNullParameter(data, "data");
        g gVar = data.f427681b;
        Intrinsics.checkNotNullExpressionValue(gVar, "data.material");
        x(gVar);
        w(data);
        t(data);
        q(data);
        s(data);
        u(data);
        View view = this.backgroundView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
            view = null;
        }
        aa.d(view, new View.OnClickListener() { // from class: cg3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaBigVideoView.A(ZootopiaBigVideoView.this, view2);
            }
        });
    }

    @Override // pa4.a
    public void onPause(LifecycleOwner owner) {
    }

    @Override // pa4.a
    public void onResume(LifecycleOwner owner) {
    }

    @Override // pa4.a
    public void onStart(LifecycleOwner owner) {
    }

    @Override // pa4.a
    public void onStop(LifecycleOwner owner) {
    }
}
