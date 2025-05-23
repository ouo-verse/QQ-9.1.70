package com.tencent.ecommerce.biz.consumer.factory;

import android.content.Context;
import com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.ECCommentGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.ECDefaultGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.ECNGCardView;
import com.tencent.ecommerce.biz.consumer.view.ECNGGradientCardView;
import com.tencent.ecommerce.biz.consumer.view.ECNGWeakenCardView;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.mediumcard.ECNGVideoMediumCardView;
import com.tencent.ecommerce.biz.consumer.view.topview.ECBottomFloatingCardView;
import com.tencent.ecommerce.biz.consumer.view.topview.ECTopViewCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView;
import com.tencent.ecommerce.repo.consumer.resp.PlayInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/factory/a;", "", "Landroid/content/Context;", "context", "", "uiType", "", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "videoPlayInfoList", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f101595a = new a();

    a() {
    }

    public final IECGoodsCardView a(Context context, int uiType, List<PlayInfo> videoPlayInfoList) {
        Iterator<PlayInfo> it = videoPlayInfoList.iterator();
        while (it.hasNext()) {
            int uiType2 = it.next().getUi().getUiType();
            if (uiType2 == 10400 || uiType2 == 10401) {
                return new ECNGWeakenCardView(context);
            }
            if (uiType2 == 10500 || uiType2 == 10501) {
                return new ECNGGradientCardView(context);
            }
            if (uiType2 != 10600) {
                switch (uiType2) {
                    case 10300:
                    case 10301:
                    case 10302:
                        return new ECActivityGoodsCardView(context);
                }
            }
            return new ECNGVideoMediumCardView(context);
        }
        if (uiType != 300) {
            if (uiType != 301) {
                if (uiType != 400) {
                    if (uiType != 401) {
                        if (uiType == 420 || uiType == 421) {
                            return new ECXingHuanGameCardView(context);
                        }
                        if (uiType == 500 || uiType == 600) {
                            return new ECVideoFeedsGoodsCardView(context);
                        }
                        if (uiType != 700) {
                            if (uiType != 10000 && uiType != 10100) {
                                switch (uiType) {
                                    case 10600:
                                        break;
                                    case PlayUI.UIType.TOP_VIEW /* 10601 */:
                                        return new ECTopViewCardView(context);
                                    case PlayUI.UIType.BOTTOM_FLOATING_CARD /* 10602 */:
                                        return new ECBottomFloatingCardView(context);
                                    default:
                                        return new ECDefaultGoodsCardView(context);
                                }
                            }
                            return new ECNGCardView(context);
                        }
                        return new ECCommentGoodsCardView(context);
                    }
                }
            }
            return new ECVideoFeedsMiniGameCardView(context);
        }
        return new ECVideoFeedsGameCardView(context);
    }
}
