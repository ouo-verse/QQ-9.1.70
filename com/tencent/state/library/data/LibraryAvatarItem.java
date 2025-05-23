package com.tencent.state.library.data;

import com.tencent.mobileqq.R;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/library/data/LibraryAvatarItem;", "Lcom/tencent/state/template/item/TemplateAvatarItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "(Lcom/tencent/state/template/data/User;)V", "defaultResourceId", "", "getDefaultResourceId", "()I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryAvatarItem extends TemplateAvatarItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryAvatarItem(User user) {
        super(user, null, 0, 4, null);
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.tencent.state.template.item.TemplateAvatarItem, com.tencent.state.map.MapPlayableItem
    public int getDefaultResourceId() {
        return getIsGenderMale() ? R.drawable.i_o : R.drawable.i_n;
    }
}
