package je;

import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ke.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017H\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lje/c;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", HippyTKDListViewAdapter.X, "", "", "v", "", "y", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", "u", "data", "position", "", "payload", "onBindData", "e", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "f", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "extraInfo", "Lke/d;", h.F, "Lke/d;", "viewModel", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends l<RFWLayerItemMediaInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWLayerItemMediaInfo mediaInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProLayerExtraInfoBean extraInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lje/c$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lje/c;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "section", "<init>", "(Lje/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<c> weakReference;

        public a(c section) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.weakReference = new WeakReference<>(section);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            c cVar = this.weakReference.get();
            if (cVar == null) {
                return new LinkedHashMap();
            }
            return cVar.u();
        }
    }

    private final Map<String, Object> v() {
        return u();
    }

    private final int w() {
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = this.extraInfo;
        Boolean valueOf = qzoneFeedProLayerExtraInfoBean != null ? Boolean.valueOf(qzoneFeedProLayerExtraInfoBean.getIsVideo()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue() ? 1 : 0;
    }

    private final String x() {
        return "pg_qz_dynamic_floating_layer";
    }

    private final int y() {
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = this.extraInfo;
        return !Intrinsics.areEqual(String.valueOf(qzoneFeedProLayerExtraInfoBean != null ? Long.valueOf(qzoneFeedProLayerExtraInfoBean.getOwnerUin()) : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(Object obj, int i3, List list) {
        onBindData((RFWLayerItemMediaInfo) obj, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        this.viewModel = (d) t(d.class);
        VideoReport.setPageId(containerView, x());
        VideoReport.setPageParams(containerView, new fo.a().d("QZoneBaseLayerFragment", v()));
        VideoReport.setEventDynamicParams(containerView, new a(this));
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        HashMap hashMap = new HashMap();
        pk.c cVar = (pk.c) RFWIocAbilityProvider.g().getIocInterface(pk.c.class, this.mRootView, null);
        int T7 = cVar != null ? cVar.T7() : 1;
        pk.c cVar2 = (pk.c) RFWIocAbilityProvider.g().getIocInterface(pk.c.class, this.mRootView, null);
        int currentPosition = cVar2 != null ? cVar2.getCurrentPosition() : 1;
        hashMap.put("pic_cnt", Integer.valueOf(T7));
        hashMap.put("is_last_page", Integer.valueOf(currentPosition != T7 ? 0 : 1));
        if (visible) {
            VideoReport.reportPgIn(this.mRootView);
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            b.c(hashMap, "em_qz_page_turning_floating", mRootView);
            return;
        }
        VideoReport.reportPgOut(this.mRootView);
        View mRootView2 = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView2, "mRootView");
        b.d(hashMap, "em_qz_page_turning_floating", mRootView2);
    }

    public final Map<String, Object> u() {
        String str;
        Object obj;
        String str2;
        CommonUnionID T1;
        String feedId;
        String albumId;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        HashMap hashMap = new HashMap();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mediaInfo;
        if (rFWLayerItemMediaInfo != null && this.extraInfo != null) {
            String str3 = "";
            if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str = currentPicInfo.getUrl()) == null) {
                str = "";
            }
            hashMap.put("pic_url", str);
            QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = this.extraInfo;
            if (qzoneFeedProLayerExtraInfoBean == null) {
                obj = "";
            } else {
                obj = Long.valueOf(qzoneFeedProLayerExtraInfoBean.getOwnerUin());
            }
            hashMap.put("framer_uin", obj);
            QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean2 = this.extraInfo;
            if (qzoneFeedProLayerExtraInfoBean2 == null || (str2 = qzoneFeedProLayerExtraInfoBean2.getAlbumId()) == null) {
                str2 = "";
            }
            hashMap.put("albumid", str2);
            hashMap.put("open_visit_state", Integer.valueOf(y()));
            hashMap.put("floating_layer_type", Integer.valueOf(w()));
            hashMap.put(QZoneDTLoginReporter.PAGE_STYLE, 1);
            QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean3 = this.extraInfo;
            boolean z16 = false;
            if (qzoneFeedProLayerExtraInfoBean3 != null && (albumId = qzoneFeedProLayerExtraInfoBean3.getAlbumId()) != null) {
                if (albumId.length() > 0) {
                    z16 = true;
                }
            }
            hashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, Integer.valueOf(z16 ? 2 : 1));
            d dVar = this.viewModel;
            if (dVar != null && (T1 = dVar.T1()) != null && (feedId = T1.getFeedId()) != null) {
                str3 = feedId;
            }
            hashMap.put("feedid", str3);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    protected void onBindData(RFWLayerItemMediaInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getExtraData() instanceof QzoneFeedProLayerExtraInfoBean) {
            Object extraData = data.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean");
            this.extraInfo = (QzoneFeedProLayerExtraInfoBean) extraData;
            this.mediaInfo = data;
        }
    }
}
