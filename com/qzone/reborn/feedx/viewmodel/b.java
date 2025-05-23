package com.qzone.reborn.feedx.viewmodel;

import android.os.Message;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0004H&J\u001e\u0010\u0012\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/b;", "", "Landroid/os/Message;", "msg", "", "onHandleMessage", "p4", "Lcom/qzone/common/business/result/QZoneResult;", "result", "i5", "f7", "v0", "i6", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "loadType", "j7", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface b {
    void f7(QZoneResult result);

    void i5(QZoneResult result);

    void i6();

    void j7(List<? extends BusinessFeedData> feedsData, int loadType);

    void onHandleMessage(Message msg2);

    void p4();

    void v0(QZoneResult result);
}
