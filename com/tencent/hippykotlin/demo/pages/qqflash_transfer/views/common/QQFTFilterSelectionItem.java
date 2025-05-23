package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIColor;
import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterSelectionItem {
    public final int index;
    public MutableState<Boolean> isSelected;
    public h normalTextColor;
    public h selectedTextColor;
    public final String title;

    public QQFTFilterSelectionItem(String str, int i3) {
        MutableState<Boolean> mutableStateOf$default;
        this.title = str;
        this.index = i3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isSelected = mutableStateOf$default;
        QUIColor qUIColor = QUIColor.INSTANCE;
        this.normalTextColor = qUIColor.getTextPrimary();
        this.selectedTextColor = qUIColor.getBrandStandard();
    }

    public final MutableState<Boolean> isSelected() {
        return this.isSelected;
    }

    public final void setNormalTextColor(h hVar) {
        this.normalTextColor = hVar;
    }

    public final void setSelectedTextColor(h hVar) {
        this.selectedTextColor = hVar;
    }
}
