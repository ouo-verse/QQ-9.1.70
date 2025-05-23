package com.qzone.proxy.personalitycomponent.util;

import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.vas.VipMMKV;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/proxy/personalitycomponent/util/QzoneVipDataMMKVUtil;", "", "", "uin", "Lcom/qzone/proxy/personalitycomponent/model/WidgetCacheQzoneVipData;", "getWidgetVipDataFromCache", "vipData", "", "saveQzoneVipCacheData", "Lcom/qzone/personalize/model/CustomHighFiveData;", "getCustomHighFiveData", "fiveData", "saveCustomHighFiveData", "Lcom/qzone/personalize/floatobject/business/model/FloatCacheData;", "getFloatItemFromCache", "saveFloatIntoCache", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QzoneVipDataMMKVUtil {
    public static final QzoneVipDataMMKVUtil INSTANCE = new QzoneVipDataMMKVUtil();

    QzoneVipDataMMKVUtil() {
    }

    public final CustomHighFiveData getCustomHighFiveData(long uin) {
        return (CustomHighFiveData) VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(uin)).decodeParcelable("qzone_custom_high_five_key", CustomHighFiveData.class, null);
    }

    public final FloatCacheData getFloatItemFromCache(long uin) {
        return (FloatCacheData) VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(uin)).decodeParcelable("qzone_float_cache_data_key", FloatCacheData.class, null);
    }

    public final WidgetCacheQzoneVipData getWidgetVipDataFromCache(long uin) {
        return (WidgetCacheQzoneVipData) VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(uin)).decodeParcelable("qzone_vipdata_key", WidgetCacheQzoneVipData.class, null);
    }

    public final void saveCustomHighFiveData(CustomHighFiveData fiveData) {
        if (fiveData == null) {
            return;
        }
        VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(fiveData.uin)).encodeParcelable("qzone_custom_high_five_key", fiveData);
    }

    public final void saveFloatIntoCache(FloatCacheData vipData) {
        if (vipData == null) {
            return;
        }
        VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(vipData.uin)).encodeParcelable("qzone_float_cache_data_key", vipData);
    }

    public final void saveQzoneVipCacheData(WidgetCacheQzoneVipData vipData) {
        if (vipData == null) {
            return;
        }
        VipMMKV.INSTANCE.getQzoneVipData(String.valueOf(vipData.uin)).encodeParcelable("qzone_vipdata_key", vipData);
    }
}
