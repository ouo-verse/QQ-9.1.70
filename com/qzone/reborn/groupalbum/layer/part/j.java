package com.qzone.reborn.groupalbum.layer.part;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016JD\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016JD\u0010\u0015\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/j;", "Lcom/qzone/reborn/base/k;", "Lgf/e;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "y3", "view", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "w5", "elementId", "reuseIdentifier", "k5", "", "", "params", "f9", "dynamicParam", Constants.EMULATOR_INFO, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends com.qzone.reborn.base.k implements gf.e {
    @Override // gf.e
    public void G3(View view, String elementId, String reuseIdentifier, BusinessFeedData businessFeedData, final Map<String, ? extends Object> dynamicParam) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view == null) {
            return;
        }
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.groupalbum.layer.part.i
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map D9;
                D9 = j.D9(dynamicParam, str);
                return D9;
            }
        });
        bVar.i(reuseIdentifier);
        fo.c.o(view, elementId, bVar);
    }

    @Override // gf.e
    public void f9(View view, String elementId, String reuseIdentifier, Map<String, ? extends Object> params, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view == null) {
            return;
        }
        fo.b bVar = new fo.b();
        bVar.l(params);
        bVar.i(reuseIdentifier);
        fo.c.o(view, elementId, bVar);
    }

    @Override // gf.e
    public void k5(View view, String elementId, String reuseIdentifier, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view == null) {
            return;
        }
        fo.b bVar = new fo.b();
        bVar.i(reuseIdentifier);
        fo.c.o(view, elementId, bVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, gf.e.class);
    }

    @Override // gf.e
    /* renamed from: y3 */
    public String getDtPageId() {
        return "";
    }

    @Override // gf.e
    public void w5(View view, BusinessFeedData businessFeedData) {
        CellFeedCommInfo feedCommInfo;
        CellUserInfo cellUserInfo;
        User user;
        if (view == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = null;
        String l3 = (businessFeedData == null || (cellUserInfo = businessFeedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? null : Long.valueOf(user.uin).toString();
        if (l3 != null) {
            linkedHashMap.put("framer_uin", l3);
        }
        if (businessFeedData != null && (feedCommInfo = businessFeedData.getFeedCommInfo()) != null) {
            str = feedCommInfo.feedsid;
        }
        if (str != null) {
            linkedHashMap.put("feedid", str);
        }
        fo.b bVar = new fo.b();
        bVar.l(linkedHashMap);
        bVar.i(ef.b.a(businessFeedData));
        fo.c.o(view, "em_qz_feed", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map D9(Map map, String str) {
        return map;
    }
}
