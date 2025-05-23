package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class AEPlayShowTabView extends QIMSlidingTabView {
    private int curIndex;
    private ArrayList<QIMSlidingTabView.d> dataList;

    public AEPlayShowTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dataList = null;
    }

    public int getCurIndex() {
        return this.curIndex;
    }

    public ArrayList<QIMSlidingTabView.d> getDataList() {
        return this.dataList;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView
    public void initTabItemsWithRedDot(ArrayList<QIMSlidingTabView.d> arrayList) {
        this.dataList = arrayList;
        super.initTabItemsWithRedDot(arrayList);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView
    public void onTabChecked(int i3) {
        super.onTabChecked(i3);
        this.curIndex = i3;
        ArrayList<View> arrayList = getmTabItemList();
        if (arrayList == null) {
            return;
        }
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            View view = arrayList.get(i16);
            if (i16 == i3) {
                view.setScaleX(1.143f);
                view.setScaleY(1.143f);
            } else {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
        }
    }
}
