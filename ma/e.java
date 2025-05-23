package ma;

import android.app.Activity;
import android.graphics.NinePatch;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneVasTopTipsView;
import com.qzone.reborn.base.l;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.util.VasUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$Button;
import qzone.QZonePhotoDegrade$NotifyMsg;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import qzone.QZonePhotoDegrade$Text;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00100\u00a8\u00066"}, d2 = {"Lma/e;", "Lcom/qzone/reborn/base/l;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "", "text", "", "H", "Lqzone/QZonePhotoDegrade$Button;", "buttonInfo", UserInfo.SEX_FEMALE, "y", "", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", HippyTKDListViewAdapter.X, "D", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "queryNotifyMsgRsp", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzone/vas/d;", "e", "Lcom/qzone/reborn/albumx/qzone/vas/d;", "mViewModel", "f", "Landroid/view/View;", "mContainer", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneVasTopTipsView;", h.F, "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneVasTopTipsView;", "mFinishTips", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTvContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBtnPay", "Z", "mIsPaySuccess", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "mCallback", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends l<QZonePhotoDegrade$QueryNotifyMsgRsp> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsPaySuccess;

    /* renamed from: D, reason: from kotlin metadata */
    private IVasYellowDiamondPay.a mCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.qzone.vas.d mViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneVasTopTipsView mFinishTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mBtnPay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"ma/e$b", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IVasYellowDiamondPay.a {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            RFWLog.d("QZonePhotoDegradeTopTipsSection", RFWLog.USR, "yellow vip pay result: " + isSuccess);
            if (isSuccess) {
                e.this.D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(e this$0, LoadState state, Option option1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option1, "option1");
        if (state.isFinishSuccess() && option1.getResultBitMap() != null && NinePatch.isNinePatchChunk(option1.getResultBitMap().getNinePatchChunk())) {
            View view = this$0.mContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view = null;
            }
            view.setBackground(RFWNinePatchUtils.getNinePatchDrawable(option1.getResultBitMap()));
        }
    }

    private final boolean B() {
        com.qzone.reborn.albumx.qzone.vas.d dVar = this.mViewModel;
        return dVar != null && dVar.Q1() == 0;
    }

    private final void F(String text, final QZonePhotoDegrade$Button buttonInfo) {
        View view = this.mContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(0);
        QZoneVasTopTipsView qZoneVasTopTipsView = this.mFinishTips;
        if (qZoneVasTopTipsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
            qZoneVasTopTipsView = null;
        }
        qZoneVasTopTipsView.setVisibility(8);
        TextView textView2 = this.mTvContent;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView2 = null;
        }
        textView2.setText(text);
        TextView textView3 = this.mBtnPay;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPay");
            textView3 = null;
        }
        textView3.setText(buttonInfo.f430341msg.get());
        TextView textView4 = this.mBtnPay;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPay");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: ma.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.G(e.this, buttonInfo, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(e this$0, QZonePhotoDegrade$Button buttonInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(buttonInfo, "$buttonInfo");
        if (this$0.B()) {
            ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).addPayCallback(this$0.x());
        }
        IVasHybridRoute vasHybridRoute = VasUtil.getService().getVasHybridRoute();
        Activity p16 = this$0.p();
        String str = buttonInfo.url.get();
        Intrinsics.checkNotNullExpressionValue(str, "buttonInfo.url.get()");
        vasHybridRoute.openSchema(p16, str);
    }

    private final void H(String text) {
        View view = this.mContainer;
        QZoneVasTopTipsView qZoneVasTopTipsView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(8);
        QZoneVasTopTipsView qZoneVasTopTipsView2 = this.mFinishTips;
        if (qZoneVasTopTipsView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
            qZoneVasTopTipsView2 = null;
        }
        qZoneVasTopTipsView2.setVisibility(0);
        QZoneVasTopTipsView qZoneVasTopTipsView3 = this.mFinishTips;
        if (qZoneVasTopTipsView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
        } else {
            qZoneVasTopTipsView = qZoneVasTopTipsView3;
        }
        qZoneVasTopTipsView.setContent(text);
    }

    private final IVasYellowDiamondPay.a x() {
        if (this.mCallback == null) {
            this.mCallback = new b();
        }
        IVasYellowDiamondPay.a aVar = this.mCallback;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    private final void y() {
        View view = this.mContainer;
        QZoneVasTopTipsView qZoneVasTopTipsView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(8);
        QZoneVasTopTipsView qZoneVasTopTipsView2 = this.mFinishTips;
        if (qZoneVasTopTipsView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
        } else {
            qZoneVasTopTipsView = qZoneVasTopTipsView2;
        }
        qZoneVasTopTipsView.setVisibility(8);
    }

    private final void z() {
        String str;
        View findViewById = getRootView().findViewById(R.id.f162909n94);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026to_degrade_list_top_tips)");
        this.mFinishTips = (QZoneVasTopTipsView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f162906n91);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026de_list_notify_container)");
        this.mContainer = findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f162907n92);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026rade_list_notify_content)");
        this.mTvContent = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.f162908n93);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026oto_degrade_list_pay_btn)");
        TextView textView = (TextView) findViewById4;
        this.mBtnPay = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPay");
            textView = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        j33.a aVar = j33.a.f409200a;
        gradientDrawable.setColor(aVar.c());
        gradientDrawable.setStroke(1, aVar.d());
        gradientDrawable.setCornerRadius(ef.d.b(4));
        textView.setBackground(gradientDrawable);
        TextView textView3 = this.mBtnPay;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPay");
            textView3 = null;
        }
        textView3.setTextColor(aVar.e());
        TextView textView4 = this.mTvContent;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            textView4 = null;
        }
        textView4.setTextColor(aVar.g());
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/qzone_photo_degrade_list_notify_bg_night.9.png";
        } else {
            str = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/qzone_photo_degrade_list_notify_bg.9.png";
        }
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        obtain.setIsNinePatch(true);
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: ma.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                e.A(e.this, loadState, option);
            }
        });
        QZoneVasTopTipsView qZoneVasTopTipsView = this.mFinishTips;
        if (qZoneVasTopTipsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
            qZoneVasTopTipsView = null;
        }
        qZoneVasTopTipsView.setIcon(R.drawable.f17169x);
        QZoneVasTopTipsView qZoneVasTopTipsView2 = this.mFinishTips;
        if (qZoneVasTopTipsView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFinishTips");
            qZoneVasTopTipsView2 = null;
        }
        qZoneVasTopTipsView2.setActionTextVisible(false);
        TextView textView5 = this.mBtnPay;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnPay");
        } else {
            textView2 = textView5;
        }
        fo.c.n(textView2, "em_qz_notice_strip");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZonePhotoDegrade$QueryNotifyMsgRsp queryNotifyMsgRsp, int position, List<Object> payload) {
        QZonePhotoDegrade$NotifyMsg qZonePhotoDegrade$NotifyMsg;
        if (this.mIsPaySuccess || queryNotifyMsgRsp == null || (qZonePhotoDegrade$NotifyMsg = queryNotifyMsgRsp.f430342msg) == null) {
            return;
        }
        na.c cVar = na.c.f419539a;
        List<QZonePhotoDegrade$Text> list = qZonePhotoDegrade$NotifyMsg.texts.get();
        Intrinsics.checkNotNullExpressionValue(list, "queryNotifyMsgRsp.msg.texts.get()");
        String j3 = cVar.j(list);
        RFWLog.d("QZonePhotoDegradeTopTipsSection", RFWLog.USR, "onBindData: " + j3 + ", " + queryNotifyMsgRsp.f430342msg.buttons.size());
        if (!TextUtils.isEmpty(j3)) {
            if (queryNotifyMsgRsp.f430342msg.buttons.size() > 0) {
                QZonePhotoDegrade$Button buttonInfo = queryNotifyMsgRsp.f430342msg.buttons.get(0);
                Intrinsics.checkNotNullExpressionValue(buttonInfo, "buttonInfo");
                F(j3, buttonInfo);
                return;
            }
            H(j3);
            return;
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        this.mViewModel = (com.qzone.reborn.albumx.qzone.vas.d) t(com.qzone.reborn.albumx.qzone.vas.d.class);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        this.mIsPaySuccess = true;
        H("\u9ec4\u94bb\u7eed\u8d39\u6210\u529f! \u4ee5\u4e0b\u7167\u7247\u5c06\u4fdd\u7559\u539f\u56fe\u753b\u8d28\u3002");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        QZonePhotoDegradeEvent qZonePhotoDegradeEvent = new QZonePhotoDegradeEvent();
        qZonePhotoDegradeEvent.setForceClose(true);
        simpleEventBus.dispatchEvent(qZonePhotoDegradeEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n95};
    }
}
