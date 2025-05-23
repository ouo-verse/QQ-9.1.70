package cooperation.qzone.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQZWinkEditDraftApi extends QRouteApi {
    List<String> getAllEditDraftMissionId();
}
