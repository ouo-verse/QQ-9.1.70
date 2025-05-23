package bc;

import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.base.l;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import fj.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pk.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H\u0014J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lbc/a;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", "", "", "v", HippyTKDListViewAdapter.X, "", "y", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", "data", "position", "", "payload", "onBindData", "u", "e", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getMediaInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "setMediaInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "mediaInfo", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "f", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "getExtraInfo", "()Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "setExtraInfo", "(Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;)V", "extraInfo", h.F, "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "feedId", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends l<RFWLayerItemMediaInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWLayerItemMediaInfo mediaInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxLayerExtraInfoBean extraInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String feedId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lbc/a$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lbc/a;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "section", "<init>", "(Lbc/a;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bc.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    private static final class C0117a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<a> weakReference;

        public C0117a(a section) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.weakReference = new WeakReference<>(section);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            a aVar = this.weakReference.get();
            if (aVar == null) {
                return new LinkedHashMap();
            }
            return aVar.u();
        }
    }

    private final Map<String, Object> v() {
        return u();
    }

    private final int w() {
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = this.extraInfo;
        Boolean valueOf = qZAlbumxLayerExtraInfoBean != null ? Boolean.valueOf(qZAlbumxLayerExtraInfoBean.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue() ? 1 : 0;
    }

    private final String x() {
        return "pg_qz_dynamic_floating_layer";
    }

    private final int y() {
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = this.extraInfo;
        return !Intrinsics.areEqual(String.valueOf(qZAlbumxLayerExtraInfoBean != null ? qZAlbumxLayerExtraInfoBean.getUploadUid() : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(Object obj, int i3, List list) {
        onBindData((RFWLayerItemMediaInfo) obj, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        VideoReport.setPageId(containerView, x());
        VideoReport.setPageParams(containerView, new fo.a().d("QZoneBaseLayerFragment", v()));
        VideoReport.setEventDynamicParams(containerView, new C0117a(this));
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        HashMap hashMap = new HashMap();
        c cVar = (c) RFWIocAbilityProvider.g().getIocInterface(c.class, this.mRootView, null);
        int T7 = cVar != null ? cVar.T7() : 1;
        c cVar2 = (c) RFWIocAbilityProvider.g().getIocInterface(c.class, this.mRootView, null);
        int currentPosition = cVar2 != null ? cVar2.getCurrentPosition() : 1;
        hashMap.put("pic_cnt", Integer.valueOf(T7));
        hashMap.put("is_last_page", Integer.valueOf(currentPosition != T7 ? 0 : 1));
        if (visible) {
            VideoReport.reportPgIn(this.mRootView);
            q qVar = q.f399468a;
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            qVar.c(hashMap, "em_qz_page_turning_floating", mRootView);
            return;
        }
        VideoReport.reportPgOut(this.mRootView);
        q qVar2 = q.f399468a;
        View mRootView2 = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView2, "mRootView");
        qVar2.d(hashMap, "em_qz_page_turning_floating", mRootView2);
    }

    public final Map<String, Object> u() {
        String str;
        String str2;
        String str3;
        String albumId;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        HashMap hashMap = new HashMap();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mediaInfo;
        if (rFWLayerItemMediaInfo != null && this.extraInfo != null) {
            String str4 = "";
            if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str = currentPicInfo.getUrl()) == null) {
                str = "";
            }
            hashMap.put("pic_url", str);
            QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = this.extraInfo;
            if (qZAlbumxLayerExtraInfoBean == null || (str2 = qZAlbumxLayerExtraInfoBean.getUploadUid()) == null) {
                str2 = "";
            }
            hashMap.put("framer_uin", str2);
            QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean2 = this.extraInfo;
            if (qZAlbumxLayerExtraInfoBean2 == null || (str3 = qZAlbumxLayerExtraInfoBean2.getUin()) == null) {
                str3 = "";
            }
            hashMap.put("group_uin", str3);
            QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean3 = this.extraInfo;
            if (qZAlbumxLayerExtraInfoBean3 != null && (albumId = qZAlbumxLayerExtraInfoBean3.getAlbumId()) != null) {
                str4 = albumId;
            }
            hashMap.put("albumid", str4);
            hashMap.put("open_visit_state", Integer.valueOf(y()));
            hashMap.put("floating_layer_type", Integer.valueOf(w()));
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
        if (data.getExtraData() instanceof QZAlbumxLayerExtraInfoBean) {
            Object extraData = data.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean");
            this.extraInfo = (QZAlbumxLayerExtraInfoBean) extraData;
            this.mediaInfo = data;
        }
    }
}
