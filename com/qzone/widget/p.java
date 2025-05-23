package com.qzone.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p extends ActionSheetHelper {
    public static o b(Context context, View view) {
        o n06 = o.n0(context);
        n06.setActionContentView(view, new LinearLayout.LayoutParams(-1, -1));
        return n06;
    }

    public static o a(Context context, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        return c(context, null, list, onButtonClickListener);
    }

    public static o c(Context context, o oVar, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        if (context == null || list == null || list.size() <= 0) {
            return null;
        }
        if (oVar == null) {
            oVar = b(context, null);
        } else {
            oVar.clear();
            oVar.updateUI();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            ActionMenuItem actionMenuItem = list.get(i3);
            if (actionMenuItem.visibility == 0) {
                int i16 = actionMenuItem.type;
                if (i16 == 1) {
                    oVar.addButton(actionMenuItem, 1);
                } else if (i16 == 2) {
                    oVar.addButton(actionMenuItem, 3);
                }
            }
        }
        oVar.setOnButtonClickListener(onButtonClickListener);
        return oVar;
    }
}
