package com.tenpay.proxy;

import android.app.Dialog;
import android.content.Context;
import com.tencent.widget.ActionSheet;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes27.dex */
public class ASProxy {
    public static final int BLUE_STYLE_BTN = 5;
    public static final int DEFAULT_STYLE_BTN = 0;

    @Deprecated
    public static final int GREEN_STYLE_BTN = 2;

    @Deprecated
    public static final int GREY_STYLE_BTN = 4;
    public static final int RED_STYLE_BTN = 3;

    @Deprecated
    public static final int WHITE_STYLE_BTN = 1;

    public static Dialog createActionSheet(Context context, String str, LinkedHashMap<String, Integer> linkedHashMap, ActionSheet.OnButtonClickListener onButtonClickListener, ActionSheet.OnDismissListener onDismissListener) {
        ActionSheet create = ActionSheet.create(context);
        create.addCancelButton(str);
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            create.addButton(entry.getKey(), entry.getValue().intValue());
        }
        create.setOnButtonClickListener(onButtonClickListener);
        create.setOnDismissListener(onDismissListener);
        return create;
    }

    public static Dialog createActionSheetWithCheck(Context context, String str, String str2, LinkedHashMap<String, Boolean> linkedHashMap, ActionSheet.OnButtonClickListener onButtonClickListener, ActionSheet.OnDismissListener onDismissListener) {
        ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(str2);
        create.addCancelButton(str);
        for (Map.Entry<String, Boolean> entry : linkedHashMap.entrySet()) {
            create.addRadioButton(entry.getKey(), entry.getValue().booleanValue());
        }
        create.setOnButtonClickListener(onButtonClickListener);
        create.setOnDismissListener(onDismissListener);
        return create;
    }
}
