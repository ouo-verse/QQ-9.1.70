package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalPushFeedBoxItemView extends QFSPersonalBaseFeedItemView {
    private ImageView C;

    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<com.tencent.biz.qqcircle.immersive.personal.bean.e> f89322a;

        public a(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
            this.f89322a = new WeakReference<>(eVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            com.tencent.biz.qqcircle.immersive.personal.bean.e eVar = this.f89322a.get();
            if (eVar != null) {
                int i3 = 1;
                if (eVar.f().boxType.get() != 1) {
                    i3 = 2;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_OPENED_BOX_INNER_NUM, Integer.valueOf(i3));
            }
            return buildElementParams;
        }
    }

    public QFSPersonalPushFeedBoxItemView(@NonNull Context context) {
        super(context);
    }

    private void x0(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_BOX_BUTTON);
        VideoReport.setEventDynamicParams(this, new a(eVar));
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: n0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        super.bindData(eVar, i3);
        x0(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.C = (ImageView) view.findViewById(R.id.f44161of);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_baoxiang")).setTargetView(this.C));
    }
}
