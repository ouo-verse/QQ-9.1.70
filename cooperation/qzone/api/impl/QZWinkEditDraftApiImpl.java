package cooperation.qzone.api.impl;

import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import cooperation.qzone.api.IQZWinkEditDraftApi;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcooperation/qzone/api/impl/QZWinkEditDraftApiImpl;", "Lcooperation/qzone/api/IQZWinkEditDraftApi;", "()V", "getAllEditDraftMissionId", "", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public final class QZWinkEditDraftApiImpl implements IQZWinkEditDraftApi {
    @Override // cooperation.qzone.api.IQZWinkEditDraftApi
    public List<String> getAllEditDraftMissionId() {
        return QZWinkEditDraftUtil.f53839a.b();
    }
}
