package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends ob0.a {
    public static b c(Context context, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        return f(context, null, list, onButtonClickListener);
    }

    public static b d(Context context, View view) {
        b n06 = b.n0(context);
        n06.setActionContentView(view, new LinearLayout.LayoutParams(-1, -1));
        return n06;
    }

    public static am e(Context context) {
        return am.n0(context);
    }

    public static b f(Context context, b bVar, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        if (context == null || list == null || list.size() <= 0) {
            return null;
        }
        if (bVar == null) {
            bVar = d(context, null);
        } else {
            bVar.clear();
            bVar.updateUI();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            ActionMenuItem actionMenuItem = list.get(i3);
            if (actionMenuItem.visibility == 0) {
                int i16 = actionMenuItem.type;
                if (i16 == 1) {
                    bVar.addButton(actionMenuItem, 0);
                } else if (i16 == 2) {
                    bVar.addButton(actionMenuItem, 3);
                }
            }
        }
        bVar.setOnButtonClickListener(onButtonClickListener);
        return bVar;
    }
}
