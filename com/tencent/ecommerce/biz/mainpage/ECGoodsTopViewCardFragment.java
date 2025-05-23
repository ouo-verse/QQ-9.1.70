package com.tencent.ecommerce.biz.mainpage;

import ah0.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.consumer.factory.ECGoodsCardFactory;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0086\u0001\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u001a\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECGoodsTopViewCardFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "", "isTopViewPreload", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Uh", "", "delay", "", "Vh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getContentLayoutId", "getBusinessDescription", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", DKHippyEvent.EVENT_STOP, "P", "Ljava/lang/String;", "TAG", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "goodsView", BdhLogUtil.LogTag.Tag_Req, "goodsBigView", ExifInterface.LATITUDE_SOUTH, "topViewContainer", "T", "goodsViewContainer", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "U", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "topViewViewModel", "V", "goodsViewModel", "Lah0/a;", "W", "Lah0/a;", "ecAnimationSet", "Landroid/os/Handler;", "X", "Landroid/os/Handler;", "handler", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Llh0/b;", "Y", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "observer", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsTopViewCardFragment extends ECBaseFragment {

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout goodsView;

    /* renamed from: R, reason: from kotlin metadata */
    private FrameLayout goodsBigView;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout topViewContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private FrameLayout goodsViewContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private IECGoodsViewModel topViewViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private IECGoodsViewModel goodsViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private ah0.a ecAnimationSet;

    /* renamed from: P, reason: from kotlin metadata */
    private final String TAG = "ECGoodsTopViewCardFragment";

    /* renamed from: X, reason: from kotlin metadata */
    private final Handler handler = new Handler(new a());

    /* renamed from: Y, reason: from kotlin metadata */
    private final EventObserver<lh0.b> observer = new b();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Message;", "handleMessage"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            IECGoodsViewModel iECGoodsViewModel = ECGoodsTopViewCardFragment.this.topViewViewModel;
            if (iECGoodsViewModel != null) {
                iECGoodsViewModel.sendEvent(new lh0.b(1, new JSONObject()));
            }
            return true;
        }
    }

    public static final /* synthetic */ FrameLayout Lh(ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment) {
        FrameLayout frameLayout = eCGoodsTopViewCardFragment.goodsBigView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsBigView");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FrameLayout Mh(ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment) {
        FrameLayout frameLayout = eCGoodsTopViewCardFragment.goodsView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsView");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FrameLayout Ph(ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment) {
        FrameLayout frameLayout = eCGoodsTopViewCardFragment.topViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topViewContainer");
        }
        return frameLayout;
    }

    private final HashMap<String, String> Uh(String uniqueId, int businessId, String businessScene, String contentId, int contentScene, int videoIndex, String authorUin, String sealTransfer, String traceId, int pageId, boolean isTopViewPreload) {
        HashMap<String, String> hashMapOf;
        Pair[] pairArr = new Pair[11];
        pairArr[0] = new Pair("PARAM_UNIQUE_ID", uniqueId);
        pairArr[1] = new Pair("PARAM_BUSINESS_ID", String.valueOf(businessId));
        if (businessScene == null) {
            businessScene = "";
        }
        pairArr[2] = new Pair("PARAM_BUSINESS_SCENE", businessScene);
        if (contentId == null) {
            contentId = "";
        }
        pairArr[3] = new Pair("PARAM_CONTENT_ID", contentId);
        pairArr[4] = new Pair("PARAM_CONTENT_SCENE", String.valueOf(contentScene));
        pairArr[5] = new Pair("PARAM_VIDEO_INDEX", String.valueOf(videoIndex));
        if (authorUin == null) {
            authorUin = "";
        }
        pairArr[6] = new Pair("PARAM_AUTHOR_UIN", authorUin);
        if (sealTransfer == null) {
            sealTransfer = "";
        }
        pairArr[7] = new Pair("PARAM_SEAL_TRANSFER", sealTransfer);
        if (traceId == null) {
            traceId = "";
        }
        pairArr[8] = new Pair("PARAM_TRACE_ID", traceId);
        pairArr[9] = new Pair("PARAM_PAGE_ID", String.valueOf(pageId));
        pairArr[10] = new Pair("PARAM_IS_TOP_VIEW_PRELOAD", String.valueOf(isTopViewPreload));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }

    private final void Vh(long delay) {
        this.handler.sendEmptyMessageDelayed(0, delay);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167346ct4;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, lh0.b.class, this.observer);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LifecycleEventBus.f100688b.e(this.observer);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IECGoodsViewModel iECGoodsViewModel = this.topViewViewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.onWrapperViewAppear(true);
        }
        IECGoodsViewModel iECGoodsViewModel2 = this.goodsViewModel;
        if (iECGoodsViewModel2 != null) {
            iECGoodsViewModel2.onWrapperViewAppear(true);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        IECGoodsViewModel iECGoodsViewModel = this.topViewViewModel;
        if (iECGoodsViewModel != null) {
            iECGoodsViewModel.onWrapperViewDisappear();
        }
        IECGoodsViewModel iECGoodsViewModel2 = this.goodsViewModel;
        if (iECGoodsViewModel2 != null) {
            iECGoodsViewModel2.onWrapperViewDisappear();
        }
        ah0.a aVar = this.ecAnimationSet;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.topViewContainer = (FrameLayout) view.findViewById(R.id.ocq);
        this.goodsViewContainer = (FrameLayout) view.findViewById(R.id.o0c);
        this.goodsView = (FrameLayout) view.findViewById(R.id.nzc);
        this.goodsBigView = (FrameLayout) view.findViewById(R.id.nz7);
        FrameLayout frameLayout = this.goodsView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goodsView");
        }
        frameLayout.setAlpha(0.0f);
        HashMap<String, String> Uh = Uh("uniqueId1", 2, "", "B_h863ff463c7610e00cz8TcPoNdPkMcM0X5c", 8, 0, "745228153", "", "", 0, true);
        ECGoodsCardFactory eCGoodsCardFactory = ECGoodsCardFactory.f101594e;
        eCGoodsCardFactory.i(Uh, new ECGoodsTopViewCardFragment$onViewCreated$1(this));
        eCGoodsCardFactory.i(Uh("uniqueId2", 2, "", "B_h863ff463c7610e00cz8TcPoNdPkMcM0X5c", 2, 0, "745228153", "", "", 0, true), new ECGoodsTopViewCardFragment$onViewCreated$2(this));
        Vh(1000L);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Llh0/b;", "it", "", "a", "(Llh0/b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b<T> implements EventObserver<lh0.b> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(lh0.b bVar) {
            a.C0035a a16;
            LogUtil.QLog.d(ECGoodsTopViewCardFragment.this.TAG, 1, "action=" + bVar.getAction() + " params=" + bVar.getParams());
            if (bVar.getAction() == 3 || bVar.getAction() == 2 || bVar.getAction() == 6) {
                if (bVar.getParams().optBoolean("immediateHideContent")) {
                    ECGoodsTopViewCardFragment.Ph(ECGoodsTopViewCardFragment.this).setVisibility(8);
                } else {
                    int[] iArr = new int[2];
                    ECGoodsTopViewCardFragment.Mh(ECGoodsTopViewCardFragment.this).getLocationInWindow(iArr);
                    IECGoodsViewModel iECGoodsViewModel = ECGoodsTopViewCardFragment.this.topViewViewModel;
                    if (iECGoodsViewModel != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("goods_card_width", ECGoodsTopViewCardFragment.Mh(ECGoodsTopViewCardFragment.this).getWidth());
                        jSONObject.put("goods_card_height", ECGoodsTopViewCardFragment.Mh(ECGoodsTopViewCardFragment.this).getHeight());
                        jSONObject.put("location_x", iArr[0]);
                        jSONObject.put("location_y", iArr[1]);
                        Unit unit = Unit.INSTANCE;
                        iECGoodsViewModel.sendEvent(new lh0.b(8, jSONObject));
                    }
                    ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment = ECGoodsTopViewCardFragment.this;
                    a16 = r3.a(ECGoodsTopViewCardFragment.Mh(ECGoodsTopViewCardFragment.this), 0.0f, 1.0f, (r26 & 8) != 0 ? new a.C0035a(330L).duration : 0L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                    eCGoodsTopViewCardFragment.ecAnimationSet = a16.c().b();
                }
                IECGoodsViewModel iECGoodsViewModel2 = ECGoodsTopViewCardFragment.this.goodsViewModel;
                if (iECGoodsViewModel2 != null) {
                    iECGoodsViewModel2.sendEvent(new lh0.c(0, 10000));
                }
            }
        }
    }
}
