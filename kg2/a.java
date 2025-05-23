package kg2;

import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSFeedInfoViewShowEvent;
import com.tencent.biz.qqcircle.events.QFSVideoControlEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lkg2/a;", "Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "", "littleWorldFeedId", "", "isPause", "", "sendVideoControlEvent", ViewStickEventHelper.IS_SHOW, "isNeedAnim", "sendVideoInfoViewShowEvent", "isShowing", "sendQCirclePanelStateEvent", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECVideoControlDelegate {
    @Override // com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate
    public void sendQCirclePanelStateEvent(String littleWorldFeedId, boolean isShowing) {
        Intrinsics.checkNotNullParameter(littleWorldFeedId, "littleWorldFeedId");
        QLog.d("ECVideoControlDelegate", 2, "ECVideoControlDelegate sendQCirclePanelStateEvent = " + littleWorldFeedId + " isShow = " + isShowing);
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(8, littleWorldFeedId, isShowing));
    }

    @Override // com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate
    public void sendVideoControlEvent(String littleWorldFeedId, boolean isPause) {
        Intrinsics.checkNotNullParameter(littleWorldFeedId, "littleWorldFeedId");
        QLog.d("ECVideoControlDelegate", 2, "ECVideoControlDelegate sendVideoControlEvent = " + littleWorldFeedId + " isPause = " + isPause);
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoControlEvent(littleWorldFeedId, isPause ^ true));
    }

    @Override // com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate
    public void sendVideoInfoViewShowEvent(String littleWorldFeedId, boolean isShow, boolean isNeedAnim) {
        Intrinsics.checkNotNullParameter(littleWorldFeedId, "littleWorldFeedId");
        QLog.d("ECVideoControlDelegate", 2, "ECVideoControlDelegate sendVideoInfoViewShowEvent = " + littleWorldFeedId + " isShow = " + isShow + " isNeedAnim = " + isNeedAnim);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFeedInfoViewShowEvent(littleWorldFeedId, isShow, isNeedAnim));
    }
}
