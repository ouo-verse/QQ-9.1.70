package com.qzone.reborn.message.common;

import androidx.lifecycle.LiveData;
import bl.CommonNoticeBean;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/message/common/e;", "", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lbl/a;", "v", "", UserInfo.SEX_FEMALE, "S0", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface e {
    void F();

    void S0();

    LiveData<UIStateData<List<CommonNoticeBean>>> v();
}
