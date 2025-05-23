package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIColor;
import com.tencent.kuikly.core.base.h;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterSelectionViewModel {
    public float height;
    public ArrayList<QQFTFilterSelectionItem> items;
    public h normalTextColor;
    public h selectedTextColor;
    public final String[] titles;

    public QQFTFilterSelectionViewModel(String[] strArr) {
        this.titles = strArr;
        QUIColor qUIColor = QUIColor.INSTANCE;
        this.normalTextColor = qUIColor.getTextPrimary();
        this.selectedTextColor = qUIColor.getBrandStandard();
        this.height = 32;
        this.items = new ArrayList<>();
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            QQFTFilterSelectionItem qQFTFilterSelectionItem = new QQFTFilterSelectionItem(this.titles[i3], i3);
            qQFTFilterSelectionItem.isSelected().setValue(Boolean.valueOf(i3 == 0));
            qQFTFilterSelectionItem.setNormalTextColor(this.normalTextColor);
            qQFTFilterSelectionItem.setSelectedTextColor(this.selectedTextColor);
            this.items.add(qQFTFilterSelectionItem);
            i3++;
        }
    }

    public final void selectItem(int i3) {
        Iterator<QQFTFilterSelectionItem> it = this.items.iterator();
        while (it.hasNext()) {
            QQFTFilterSelectionItem next = it.next();
            next.isSelected.setValue(Boolean.valueOf(next.index == i3));
        }
    }
}
