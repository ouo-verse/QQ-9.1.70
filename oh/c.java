package oh;

import android.graphics.drawable.GradientDrawable;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    public static void a(CellTextView cellTextView, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        GradientDrawable.Orientation orientation;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            cellTextView.setShadowLayer(0, 0, 0, 0);
            cellTextView.setTextColorAnimation(null, 0);
            cellTextView.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            cellTextView.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            cellTextView.setShadowLayer(com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowBlurRadius), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetX), com.qzone.proxy.feedcomponent.util.g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            cellTextView.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            cellTextView.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            cellTextView.setTextColorAnimation(null, 0);
        }
        if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
            int size2 = superFontInfo.vecGradientColor.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
            }
            int size3 = superFontInfo.vecGradientPosition.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
            }
            int i18 = superFontInfo.iGradientDirection;
            if (i18 == 0) {
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            } else if (i18 == 1) {
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            } else if (i18 == 2) {
                orientation = GradientDrawable.Orientation.TL_BR;
            } else if (i18 != 3) {
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            } else {
                orientation = GradientDrawable.Orientation.BL_TR;
            }
            cellTextView.setGradientColor(iArr, fArr, orientation);
            return;
        }
        cellTextView.setGradientColor(null, null, null);
    }
}
