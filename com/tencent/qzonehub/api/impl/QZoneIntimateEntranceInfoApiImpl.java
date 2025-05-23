package com.tencent.qzonehub.api.impl;

import com.qzone.reborn.configx.g;
import com.qzone.reborn.intimate.bean.QZoneIntimateEntranceAvatarBean;
import com.qzone.reborn.util.i;
import com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneIntimateEntranceInfoApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneIntimateEntranceInfoApi;", "Ljava/util/ArrayList;", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "saveEntranceAvatarUinList", "getEntranceAvatarUinList", "", "getEntranceAvatarShowInterval", "", "getEntranceAvatarShowTimes", "<init>", "()V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QZoneIntimateEntranceInfoApiImpl implements IQZoneIntimateEntranceInfoApi {
    private static final String SHOWN_ENTRANCE_AVATAR_LIST = "show_entrance_avatar_list";

    @Override // com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi
    public long getEntranceAvatarShowInterval() {
        return g.f53821a.b().Y0();
    }

    @Override // com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi
    public int getEntranceAvatarShowTimes() {
        return g.f53821a.b().Z0();
    }

    @Override // com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi
    public ArrayList<String> getEntranceAvatarUinList() {
        QZoneIntimateEntranceAvatarBean qZoneIntimateEntranceAvatarBean = (QZoneIntimateEntranceAvatarBean) i.b().i(SHOWN_ENTRANCE_AVATAR_LIST, QZoneIntimateEntranceAvatarBean.class, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (qZoneIntimateEntranceAvatarBean != null && !ArrayUtils.isOutOfArrayIndex(0, qZoneIntimateEntranceAvatarBean.a())) {
            arrayList.addAll(qZoneIntimateEntranceAvatarBean.a());
        }
        return arrayList;
    }

    @Override // com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi
    public void saveEntranceAvatarUinList(ArrayList<String> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        QZoneIntimateEntranceAvatarBean qZoneIntimateEntranceAvatarBean = new QZoneIntimateEntranceAvatarBean();
        qZoneIntimateEntranceAvatarBean.a().addAll(uinList);
        i.b().q(SHOWN_ENTRANCE_AVATAR_LIST, qZoneIntimateEntranceAvatarBean);
    }
}
