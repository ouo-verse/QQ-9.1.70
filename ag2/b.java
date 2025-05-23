package ag2;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lag2/b;", "", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "messageTypeStatus", "", "a", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "", "Lzf2/c;", "getSettings", "()Landroidx/lifecycle/LiveData;", QCircleDaTongConstant.ElementParamValue.SETTINGS, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface b {
    Object a(MessageType messageType, e eVar, Continuation<? super Boolean> continuation);

    Object b(Continuation<? super Unit> continuation);

    LiveData<List<MessageSettingItem>> getSettings();
}
