package com.qzone.album.ui.widget;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f44330a;

    static {
        f44330a = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHARE_ALBUM_ALLOW_INVITE_TO_FEEDS, 1) == 1;
    }

    public static ActionSheet a(Context context, ActionSheet.OnButtonClickListener onButtonClickListener) {
        ActionMenuItem actionMenuItem = new ActionMenuItem(207, ActionSheetHelper.getStringById(context, R.string.gam), 207, 0);
        ActionMenuItem actionMenuItem2 = new ActionMenuItem(208, ActionSheetHelper.getStringById(context, R.string.gai), 208, 0, 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(actionMenuItem);
        arrayList.add(actionMenuItem2);
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(context, arrayList, onButtonClickListener);
        createActionSheet.addCancelButton(R.string.cancel);
        return createActionSheet;
    }

    public static ActionSheet b(Context context, ActionSheet.OnButtonClickListener onButtonClickListener, int i3) {
        ActionMenuItem actionMenuItem = new ActionMenuItem(204, ActionSheetHelper.getStringById(context, R.string.gar), 204, 0);
        ActionMenuItem actionMenuItem2 = new ActionMenuItem(205, ActionSheetHelper.getStringById(context, R.string.gat), 205, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(actionMenuItem);
        arrayList.add(actionMenuItem2);
        if (i3 == 12 && f44330a) {
            arrayList.add(new ActionMenuItem(206, ActionSheetHelper.getStringById(context, R.string.gas), 206, 0));
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(context, arrayList, onButtonClickListener);
        createActionSheet.addCancelButton(R.string.cancel);
        return createActionSheet;
    }
}
