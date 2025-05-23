package com.qzone.reborn.message.part;

import bl.CommonNoticeBean;
import com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/message/part/l;", "Lcom/qzone/reborn/message/common/CommonQZoneNoticeBodyPart;", "Lcom/qzone/reborn/message/common/e;", "I9", "Lcom/qzone/reborn/base/h;", "Lbl/a;", "H9", "", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "uiStateData", "M9", "", "E", "Z", "needHighlightNewMsg", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends CommonQZoneNoticeBodyPart {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needHighlightNewMsg = true;

    @Override // com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart
    public com.qzone.reborn.base.h<CommonNoticeBean> H9() {
        return new al.c();
    }

    @Override // com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart
    public com.qzone.reborn.message.common.e I9() {
        Object viewModel = getViewModel(hl.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePassiv\u2026ageViewModel::class.java)");
        return (com.qzone.reborn.message.common.e) viewModel;
    }

    @Override // com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart
    public void M9(UIStateData<List<CommonNoticeBean>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.M9(uiStateData);
        if (this.needHighlightNewMsg) {
            gf.p pVar = (gf.p) getIocInterface(gf.p.class);
            O9(pVar != null ? pVar.U5() : 0);
            this.needHighlightNewMsg = false;
        }
    }

    @Override // com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart
    public void initViewModel() {
        super.initViewModel();
        ((hl.d) getViewModel(hl.d.class)).c2(getActivity().getIntent());
    }
}
