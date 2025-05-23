package hl;

import android.app.Activity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import bl.CommonNoticeBean;
import bl.f;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.message.common.e;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ay;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\bR&\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lhl/c;", "Lnk/ay;", "Lcom/qzone/reborn/message/common/e;", "", "getLogTag", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lbl/a;", "v", "", UserInfo.SEX_FEMALE, "S0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "noticeBean", "f2", "E", "Landroidx/lifecycle/LiveData;", "mNoticeListData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends ay implements e {

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<UIStateData<List<CommonNoticeBean>>> mNoticeListData;

    public c() {
        LiveData<UIStateData<List<CommonNoticeBean>>> map = Transformations.map(W1(), new Function() { // from class: hl.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                UIStateData g26;
                g26 = c.g2((UIStateData) obj);
                return g26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(mMessageListData) {\n\u2026n@map stateData\n        }");
        this.mNoticeListData = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UIStateData g2(UIStateData uIStateData) {
        UIStateData obtainSuccess = UIStateData.obtainSuccess(uIStateData.isCacheData());
        obtainSuccess.setState(uIStateData.getState());
        obtainSuccess.setFinish(uIStateData.getIsFinish());
        obtainSuccess.setLatestModifyRecord(uIStateData.getLatestModifyRecord());
        if (uIStateData.getData() != null) {
            com.qzone.reborn.message.data.b bVar = com.qzone.reborn.message.data.b.f58255a;
            Object data = uIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "it.data");
            obtainSuccess.setData(uIStateData.getIsLoadMore(), bVar.a((List) data));
        }
        return obtainSuccess;
    }

    @Override // com.qzone.reborn.message.common.e
    public void F() {
        a2();
    }

    @Override // com.qzone.reborn.message.common.e
    public void S0() {
        d2();
    }

    public final void f2(Activity activity, CommonNoticeBean noticeBean) {
        f notice;
        Intrinsics.checkNotNullParameter(activity, "activity");
        UIStateData<List<com.qzone.reborn.message.data.a>> value = W1().getValue();
        Object obj = null;
        List<com.qzone.reborn.message.data.a> data = value != null ? value.getData() : null;
        List<com.qzone.reborn.message.data.a> list = data;
        if (list == null || list.isEmpty()) {
            RFWLog.e(getTAG(), RFWLog.USR, "[deleteMessageFromNoticeBean] message list is empty");
            return;
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((com.qzone.reborn.message.data.a) next).getStNotice().notice_id.get(), (noticeBean == null || (notice = noticeBean.getNotice()) == null) ? null : notice.getNoticeId())) {
                obj = next;
                break;
            }
        }
        P1(activity, (com.qzone.reborn.message.data.a) obj);
    }

    @Override // nk.ay, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateMessageNewViewModel";
    }

    @Override // com.qzone.reborn.message.common.e
    public LiveData<UIStateData<List<CommonNoticeBean>>> v() {
        return this.mNoticeListData;
    }
}
