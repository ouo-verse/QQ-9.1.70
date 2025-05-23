package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes5.dex */
public class IQFSphonePickerView extends IphonePickerView {
    public IQFSphonePickerView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
    public void initialize(IphonePickerView.PickerViewAdapter pickerViewAdapter) {
        super.initialize(pickerViewAdapter);
        Resources resources = getContext().getResources();
        setBackgroundColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate));
        View findViewById = findViewById(R.id.jls);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.cbd));
        }
        View findViewById2 = findViewById(R.id.e_x);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(resources.getColor(R.color.cbe));
        }
        View findViewById3 = findViewById(R.id.e_b);
        if (findViewById3 != null) {
            findViewById3.setBackgroundColor(resources.getColor(R.color.cbe));
        }
    }

    public IQFSphonePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
