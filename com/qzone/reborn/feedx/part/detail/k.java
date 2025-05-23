package com.qzone.reborn.feedx.part.detail;

import android.os.Handler;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart;
import com.qzone.reborn.feedx.viewmodel.h;
import com.qzone.util.ToastUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k extends QZoneFeedxCommentOperationPart implements h.b {
    private com.qzone.reborn.feedx.viewmodel.h G;

    @Override // com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart
    public BusinessFeedData K9(String str) {
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        if (hVar != null && hVar.X1() != null) {
            return hVar.X1();
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
        return null;
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailCommentOperationPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        if (this.G == null) {
            this.G = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        return this.G.g2();
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart, com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        this.G = hVar;
        hVar.P1(this);
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void K6(QZoneResult qZoneResult) {
    }
}
