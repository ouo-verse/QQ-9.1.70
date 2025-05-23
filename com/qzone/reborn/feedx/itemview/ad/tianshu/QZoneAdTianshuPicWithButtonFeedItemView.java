package com.qzone.reborn.feedx.itemview.ad.tianshu;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellUniverse;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.ad.tianshu.QZoneAdTianshuPicWithButtonFeedItemView;
import com.qzone.util.ak;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r01.c;
import vg.a;
import yo.d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0007*\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00170\u0016H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010'R\u001c\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuPicWithButtonFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "D0", "", "", "G0", "", "isExposure", "F0", "C0", "", "getLayoutId", "getLogTag", "initView", "i", "n0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "Ljava/lang/Class;", "Lvg/a;", "s0", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "ivBackgroundView", UserInfo.SEX_FEMALE, "ivClose", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "H", "Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "I", "adId", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "J", "Ljava/lang/reflect/Type;", "type", "Lcom/google/gson/Gson;", "K", "Lcom/google/gson/Gson;", "gson", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdTianshuPicWithButtonFeedItemView extends QZoneBaseFeedItemView {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView ivBackgroundView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView ivClose;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton button;

    /* renamed from: H, reason: from kotlin metadata */
    private String jumpUrl;

    /* renamed from: I, reason: from kotlin metadata */
    private int adId;

    /* renamed from: J, reason: from kotlin metadata */
    private final Type type;

    /* renamed from: K, reason: from kotlin metadata */
    private final Gson gson;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuPicWithButtonFeedItemView$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdTianshuPicWithButtonFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.jumpUrl = "";
        this.type = new b().getType();
        this.gson = new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess()) {
            Animatable animatable = option.getAnimatable();
            c cVar = animatable instanceof c ? (c) animatable : null;
            if (cVar != null) {
                cVar.setLoopCount(1);
                cVar.start();
            }
        }
    }

    private final void C0() {
        int i3;
        EventCenter.getInstance().post("Feed", 27);
        EventCenter eventCenter = EventCenter.getInstance();
        String str = this.C.getFeedCommInfo().feedskey;
        Intrinsics.checkNotNullExpressionValue(str, "mFeedData.feedCommInfo.feedskey");
        eventCenter.post("WriteOperation", 38, str);
        Iterator<s_droplist_option> it = this.C.getFeedCommInfo().customDroplist.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = 81;
                break;
            }
            s_droplist_option next = it.next();
            if (next.actiontype == 42) {
                i3 = next.reporttype;
                break;
            }
        }
        QZoneWriteOperationService.v0().O(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler(), this.C.getUser().uin, i3, this.C.getOperationInfo().droplist_cookie, null);
    }

    private final void D0(final BusinessFeedData feedData) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: kf.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdTianshuPicWithButtonFeedItemView.E0(BusinessFeedData.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(BusinessFeedData businessFeedData, QZoneAdTianshuPicWithButtonFeedItemView this$0) {
        CellOperationInfo cellOperationInfo;
        Map<Integer, String> map;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fo.c.o(this$0.getRootView(), "em_qz_agent_card", new fo.b().l((businessFeedData == null || (cellOperationInfo = businessFeedData.cellOperationInfo) == null || (map = cellOperationInfo.feedReportCookie) == null || (str = map.get(33)) == null) ? null : this$0.G0(str)));
        fo.c.n(this$0.ivClose, "em_qz_close");
        fo.c.n(this$0.button, "em_qz_know_him");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167284ch3;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneAdTianshuPicWithButtonFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public void initView() {
        super.initView();
        this.ivBackgroundView = (ImageView) getRootView().findViewById(R.id.mw7);
        this.button = (QUIButton) getRootView().findViewById(R.id.mtc);
        ImageView imageView = (ImageView) getRootView().findViewById(R.id.mvu);
        this.ivClose = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        QUIButton qUIButton = this.button;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(this);
        }
        getRootView().setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(BusinessFeedData feedData, int i3) {
        CellUniverse cellUniverse;
        CellUniverse cellUniverse2;
        super.bindData(feedData, i3);
        String str = null;
        if (TextUtils.isEmpty((feedData == null || (cellUniverse2 = feedData.cellUniverse) == null) ? null : cellUniverse2.jsonTemplate)) {
            QLog.e(getTAG(), 1, "onBindData feed data is null");
            getRootView().setVisibility(8);
            return;
        }
        try {
            if (feedData != null && (cellUniverse = feedData.cellUniverse) != null) {
                str = cellUniverse.jsonTemplate;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("image");
            Intrinsics.checkNotNullExpressionValue(optString, "feedDataJsonObject.optString(\"image\")");
            String optString2 = jSONObject.optString("jump_url");
            Intrinsics.checkNotNullExpressionValue(optString2, "feedDataJsonObject.optString(\"jump_url\")");
            this.jumpUrl = optString2;
            String optString3 = jSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
            Intrinsics.checkNotNullExpressionValue(optString3, "feedDataJsonObject.optString(\"button_text\")");
            this.adId = jSONObject.optInt("ad_id");
            getRootView().setVisibility(0);
            F0(true);
            D0(feedData);
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(optString).setTargetView(this.ivBackgroundView), new IPicLoadStateListener() { // from class: kf.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QZoneAdTianshuPicWithButtonFeedItemView.B0(loadState, option);
                }
            });
            QUIButton qUIButton = this.button;
            if (qUIButton == null) {
                return;
            }
            qUIButton.setText(optString3);
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "onBindData failed:", e16);
            getRootView().setVisibility(8);
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.mvu) {
            C0();
        } else {
            String str = this.jumpUrl;
            ImageView imageView = this.ivBackgroundView;
            d.c(str, imageView != null ? imageView.getContext() : null);
            F0(false);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        return new ArrayList();
    }

    private final Map<String, String> G0(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return (Map) this.gson.fromJson(str, this.type);
        } catch (Exception unused) {
            QLog.d("QZoneAdTianshuPicWithButtonFeedItemView", 1, "String?.toMap() fail content:" + str);
            return null;
        }
    }

    private final void F0(boolean isExposure) {
        TianShuReportData a16 = ak.a(isExposure ? 101 : 102, this.adId, "");
        Intrinsics.checkNotNullExpressionValue(a16, "buildTianShuReportData(\n\u2026       adId.toLong(), \"\")");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(a16);
    }
}
