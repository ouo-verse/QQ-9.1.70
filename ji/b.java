package ji;

import android.view.View;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lji/b;", "Lcom/qzone/reborn/base/k;", "Lil/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "view", "Lkl/a;", "businessFeedData", "C1", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends k implements il.a {
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, il.a.class);
    }

    @Override // il.a
    public void C1(View view, kl.a businessFeedData) {
        if (view == null || businessFeedData == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String feedId = businessFeedData.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feed.cellCommon.feedId;
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        linkedHashMap.put("feedid", feedId);
        String uin = businessFeedData.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().opUser.uin;
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        linkedHashMap.put("to_uin", uin);
        fo.b bVar = new fo.b();
        bVar.l(linkedHashMap);
        bVar.i(feedId);
        fo.c.o(view, "em_qz_feed", bVar);
    }
}
