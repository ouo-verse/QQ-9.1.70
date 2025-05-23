package com.tencent.sqshow.zootopia.recommend.characterV2.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.c;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.a;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanSmallHomeBubbleController;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.EnterAvatarMallEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.GetSmallHomeBubbleEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.OnRoleTouchTapClickEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRolePendantItemView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import gv4.e;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import n74.cm;
import org.libpag.PAGView;
import pu4.g;
import pv4.s;
import pv4.u;
import tl.h;
import uv4.w;

@Metadata(d1 = {"\u0000\u00a9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001Z\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001eB'\b\u0007\u0012\u0006\u0010^\u001a\u00020]\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010a\u001a\u00020 \u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010+\u001a\u00020 J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\rH\u0016J\u0018\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u0002002\u0006\u0010.\u001a\u00020\rH\u0016J\u001a\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u0012\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010<\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050:09j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050:`;H\u0016R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010DR\u0016\u0010G\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010FR\u0016\u0010H\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010FR\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010FR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010Q\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010DR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010FR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010[\u00a8\u0006f"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "f", "", "w", DomainData.DOMAIN_NAME, "g", "needPlay", "r", "l", "k", "available", "i", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "bubbleOwner", HippyTKDListViewAdapter.X, "j", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "avatarInterface", "setAvatarComponentInterface", "Lpv4/s;", "data", "", "index", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onResume", "o", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, h.F, "Luv4/u;", "rsp", "hasCacheData", "p", "Luv4/w;", "B", "errorCode", "errorMsg", "onFailed", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ln74/cm;", "d", "Ln74/cm;", "mBinding", "e", "Lpv4/s;", "mData", "I", "mIndex", "Z", "mUeAvailable", "mNativeUIAvailable", "mRenderCompelte", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "D", "mPagAnimStarted", "E", "mLastBubbleIndex", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController;", "mBubbleController", "G", "mPagNeedResumePlay", "H", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "com/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView$c", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView$c;", "mPagListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRolePendantItemView extends FrameLayout implements com.tencent.sqshow.zootopia.avatar.c, o, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ZplanViewReportHelper mReporter;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mPagAnimStarted;

    /* renamed from: E, reason: from kotlin metadata */
    private int mLastBubbleIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanSmallHomeBubbleController mBubbleController;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mPagNeedResumePlay;

    /* renamed from: H, reason: from kotlin metadata */
    private a avatarInterface;

    /* renamed from: I, reason: from kotlin metadata */
    private final c mPagListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final cm mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private s mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mUeAvailable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mNativeUIAvailable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mRenderCompelte;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            QLog.i("ZPlanRolePendantItemView_", 1, "onAnimationStart mPagAnimStarted:" + ZPlanRolePendantItemView.this.mPagAnimStarted);
            ZPlanRolePendantItemView.this.mPagAnimStarted = true;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView p06) {
            QLog.i("ZPlanRolePendantItemView_", 1, "onAnimationCancel");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.i("ZPlanRolePendantItemView_", 1, "onAnimationEnd");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView p06) {
            QLog.i("ZPlanRolePendantItemView_", 1, "onAnimationRepeat");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView p06) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantItemView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> f() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_element_id", String.valueOf(this.mData.f427690k));
        u uVar = this.mData.f427683d;
        String str = uVar != null ? uVar.f427702a : null;
        if (str == null) {
            str = "";
        }
        hashMap.put("zplan_element_name", str);
        e m3 = ZPlanRedDotManager.m(ZPlanRedDotManager.f373437a, this.mData.f427688i, 0, 2, null);
        hashMap.put("zplan_redpoint_type", Integer.valueOf(m3 != null ? m3.f403426b : 0));
        hashMap.put("zplan_loading_status", Integer.valueOf(this.mUeAvailable ? 1 : 0));
        return hashMap;
    }

    private final String g() {
        return "ZPlanAIGCNativeRedDot_V3_" + ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
    }

    private final void j() {
        boolean contains$default;
        if (h() == 4) {
            SimpleEventBus.getInstance().dispatchEvent(new EnterAvatarMallEvent());
            return;
        }
        String str = this.mData.f427682c;
        Intrinsics.checkNotNullExpressionValue(str, "mData.jumpUrl");
        if (str.length() == 0) {
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str2 = this.mData.f427682c;
        Intrinsics.checkNotNullExpressionValue(str2, "mData.jumpUrl");
        iSchemeApi.launchScheme(context, str2);
        String str3 = this.mData.f427682c;
        Intrinsics.checkNotNullExpressionValue(str3, "mData.jumpUrl");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "zplan/openHomeConnected", false, 2, (Object) null);
        if (contains$default) {
            QLog.i("ZPlanRolePendantItemView_", 1, String.valueOf(this.mData));
            a aVar = this.avatarInterface;
            if (aVar != null) {
                aVar.N0();
            }
        }
    }

    private final void k() {
        int i3 = this.mData.f427688i;
        QLog.d("ZPlanRolePendantItemView_", 1, "handleRedDotAfterClick, id: " + i3);
        if (this.mBinding.f419039f.f()) {
            QLog.d("ZPlanRolePendantItemView_", 1, "hit special reddot, id: " + i3 + ", hide immediately after click");
            this.mBinding.f419039f.setVisibility(4);
        }
    }

    private final void m() {
        this.mBinding.f419036c.setURLDrawableDownListener(new b());
    }

    private final boolean n() {
        int i3 = this.mData.f427688i;
        return i3 == 15 || i3 == 16;
    }

    private final void r(boolean needPlay) {
        s sVar = this.mData;
        g gVar = sVar.f427681b;
        if (gVar != null) {
            u uVar = sVar.f427683d;
            String str = uVar != null ? uVar.f427702a : null;
            QLog.i("ZPlanRolePendantItemView_", 1, "refreshView title:" + str + ", redPointIndex: " + sVar.f427688i + ", material:" + com.tencent.sqshow.zootopia.utils.o.l(gVar) + ", type:" + h());
            int color = getResources().getColor(R.color.qui_common_fill_light_tertiary);
            ImageView imageView = this.mBinding.f419035b;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color);
            gradientDrawable.setCornerRadius(i.e(10));
            imageView.setBackground(gradientDrawable);
            final boolean z16 = false;
            if (w()) {
                this.mBinding.f419038e.setVisibility(0);
            }
            g material = this.mBinding.f419036c.getMaterial();
            if (!(material != null && com.tencent.sqshow.zootopia.utils.o.d(material, gVar))) {
                ZPlanMediaView zPlanMediaView = this.mBinding.f419036c;
                zPlanMediaView.setDefaultDrawable(new ColorDrawable(0));
                if (Intrinsics.areEqual(gVar.f427435b, "pag")) {
                    zPlanMediaView.setPagListener(this.mPagListener);
                    zPlanMediaView.d(gVar);
                    if (needPlay && !this.mPagAnimStarted) {
                        this.mPagAnimStarted = false;
                        zPlanMediaView.I(gVar);
                    }
                } else {
                    zPlanMediaView.e(gVar);
                }
            }
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.mBinding.f419037d;
            Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "mBinding.nameTxv");
            m84.b.h(zplanExcludeFontPaddingTextView, this.mData.f427683d);
            if (!n()) {
                this.mBinding.f419039f.h(this.mData.f427688i);
            }
            if ((this.mUeAvailable || this.mRenderCompelte) && this.mNativeUIAvailable) {
                z16 = true;
            }
            if (h() == 4) {
                QLog.i("ZPlanRolePendantItemView_", 1, "available: " + z16 + ", mNativeUIAvailable: " + this.mNativeUIAvailable + ", mRenderCompelte: " + this.mRenderCompelte + ",mUeAvailable: " + this.mUeAvailable);
                this.mBinding.f419035b.setElevation(i.e(3));
                this.mBinding.f419036c.setAlpha(z16 ? 1.0f : 0.25f);
                this.mBinding.f419036c.invalidate();
                this.mBinding.f419037d.setAlpha(z16 ? 1.0f : 0.25f);
                aa.d(this, new View.OnClickListener() { // from class: bb4.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanRolePendantItemView.t(z16, this, view);
                    }
                });
            } else {
                setAlpha(1.0f);
                if (n()) {
                    this.mBinding.f419036c.setAlpha(z16 ? 1.0f : 0.25f);
                    this.mBinding.f419037d.setAlpha(z16 ? 1.0f : 0.25f);
                } else {
                    this.mBinding.f419036c.setAlpha(1.0f);
                    this.mBinding.f419037d.setAlpha(1.0f);
                }
                this.mBinding.f419036c.invalidate();
                aa.d(this, new View.OnClickListener() { // from class: bb4.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanRolePendantItemView.u(ZPlanRolePendantItemView.this, z16, view);
                    }
                });
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(boolean z16, ZPlanRolePendantItemView this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.mReporter.e(this$0, "em_zplan_navigation_entrance", this$0.f());
            this$0.j();
            this$0.k();
        } else {
            if (!this$0.mUeAvailable) {
                str = "\u6b63\u5728\u52a0\u8f7d\u89d2\u8272\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            } else {
                str = "\u6b63\u5728\u52a0\u8f7d\u5546\u57ce\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            QQToast.makeText(BaseApplication.context, 1, str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ZPlanRolePendantItemView this$0, boolean z16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mReporter.e(this$0, "em_zplan_navigation_entrance", this$0.f());
        if (this$0.n()) {
            this$0.i(z16);
        } else {
            this$0.j();
        }
    }

    private final boolean w() {
        return n() && ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(g(), true);
    }

    private final void x(final com.tencent.sqshow.zootopia.recommend.characterV2.controller.a bubbleOwner) {
        QLog.i("ZPlanRolePendantItemView_", 1, "triggerSmallHomeBubble bubbleIndex = " + this.mData.f427693n + ", mLastBubbleIndex:" + this.mLastBubbleIndex);
        int i3 = this.mData.f427693n;
        if (i3 == 0 || i3 == this.mLastBubbleIndex) {
            return;
        }
        this.mLastBubbleIndex = i3;
        post(new Runnable() { // from class: bb4.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRolePendantItemView.y(ZPlanRolePendantItemView.this, bubbleOwner);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZPlanRolePendantItemView this$0, com.tencent.sqshow.zootopia.recommend.characterV2.controller.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect rect = new Rect();
        this$0.getGlobalVisibleRect(rect);
        QLog.i("ZPlanRolePendantItemView_", 1, "triggerSmallHomeBubble r=" + rect + ", index: " + this$0.mData.f427693n + ", bubbleOwner =null " + (aVar == null));
        SimpleEventBus.getInstance().dispatchEvent(new GetSmallHomeBubbleEvent(rect, this$0.mData.f427693n));
        if (this$0.mBubbleController == null && aVar != null) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this$0.mBubbleController = new ZPlanSmallHomeBubbleController(context, aVar);
        }
        ZPlanSmallHomeBubbleController zPlanSmallHomeBubbleController = this$0.mBubbleController;
        if (zPlanSmallHomeBubbleController != null) {
            zPlanSmallHomeBubbleController.i(rect, this$0.mData.f427693n);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void B(w rsp, boolean hasCacheData) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mNativeUIAvailable = true;
        s(this, false, 1, null);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        c.a.a(this, z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(OnRoleTouchTapClickEvent.class);
        return arrayList;
    }

    public final int h() {
        pv4.o oVar = this.mData.f427684e;
        if (oVar != null) {
            return oVar.f427645c;
        }
        return 0;
    }

    public final void onDestroy() {
        this.mBinding.f419036c.stop();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ZPlanSmallHomeBubbleController zPlanSmallHomeBubbleController = this.mBubbleController;
        if (zPlanSmallHomeBubbleController != null) {
            zPlanSmallHomeBubbleController.f();
        }
        this.mBubbleController = null;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.mUeAvailable = true;
        s(this, false, 1, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof OnRoleTouchTapClickEvent) && h() == 4 && this.mUeAvailable && this.mNativeUIAvailable) {
            j();
        }
    }

    public final void onResume() {
        if (this.mPagNeedResumePlay) {
            g material = this.mBinding.f419036c.getMaterial();
            if (material != null) {
                this.mBinding.f419036c.I(material);
            }
            this.mPagNeedResumePlay = false;
        }
    }

    public final void onStop() {
        if (this.mBinding.f419036c.H()) {
            this.mBinding.f419036c.stop();
            this.mPagNeedResumePlay = true;
        }
    }

    public void p(uv4.u rsp, boolean hasCacheData) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mNativeUIAvailable = true;
        s(this, false, 1, null);
    }

    public final void q(s data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.mIndex = index;
        s(this, false, 1, null);
    }

    public final void setAvatarComponentInterface(a avatarInterface) {
        this.avatarInterface = avatarInterface;
    }

    public final void z(com.tencent.sqshow.zootopia.recommend.characterV2.controller.a bubbleOwner) {
        this.mReporter.g(this, "em_zplan_navigation_entrance", (r16 & 4) != 0 ? null : f(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        x(bubbleOwner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void o() {
        this.mRenderCompelte = true;
        s(this, false, 1, null);
    }

    public /* synthetic */ ZPlanRolePendantItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        cm f16 = cm.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mData = new s();
        this.mReporter = new ZplanViewReportHelper();
        this.mPagListener = new c();
        setClipChildren(false);
        SimpleEventBus.getInstance().registerReceiver(this);
        m();
    }

    private final void i(boolean available) {
        if (available) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(g(), false);
            this.mBinding.f419038e.setVisibility(8);
            j();
            return;
        }
        QQToast.makeText(BaseApplication.context, 1, getContext().getString(R.string.xbd), 0).show();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        if (!connect) {
            this.mUeAvailable = false;
        }
        s(this, false, 1, null);
    }

    static /* synthetic */ void s(ZPlanRolePendantItemView zPlanRolePendantItemView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        zPlanRolePendantItemView.r(z16);
    }

    private final void l() {
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView$b", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawableDownListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable drawable) {
            Drawable f16 = cn.f(drawable);
            if (f16 == null) {
                return;
            }
            f16.setColorFilter(ContextCompat.getColor(ZPlanRolePendantItemView.this.getContext(), R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable drawable, Throwable cause) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable drawable, InterruptedException e16) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable drawable, int progress) {
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void onFailed(int errorCode, String errorMsg) {
    }
}
