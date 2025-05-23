package lk;

import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.section.selectalbum.CommonSelectAlbumItemContentSection;
import com.qzone.reborn.albumx.common.viewmodel.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"Llk/a;", "Lcom/qzone/reborn/albumx/common/section/selectalbum/CommonSelectAlbumItemContentSection;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", UserInfo.SEX_FEMALE, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends CommonSelectAlbumItemContentSection {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.section.selectalbum.CommonSelectAlbumItemContentSection
    public l F() {
        ViewModel t16 = t(bb.class);
        Intrinsics.checkNotNullExpressionValue(t16, "getViewModel(QZoneIntima\u2026bumViewModel::class.java)");
        return (l) t16;
    }
}
