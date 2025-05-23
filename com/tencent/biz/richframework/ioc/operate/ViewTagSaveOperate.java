package com.tencent.biz.richframework.ioc.operate;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocUtils;
import com.tencent.biz.richframework.ioc.operate.api.IViewTagSaveOperate;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewTagSaveOperate implements IViewTagSaveOperate {
    @Override // com.tencent.biz.richframework.ioc.operate.api.IViewTagSaveOperate
    public void removeIocKeyFromViewTag(int i3, View view, String str) {
        if (view != null && i3 != 0 && !TextUtils.isEmpty(str)) {
            CopyOnWriteArrayList<String> object2CopyOnWriteArrayListOfString = RFWIocUtils.object2CopyOnWriteArrayListOfString(view.getTag(i3));
            if (object2CopyOnWriteArrayListOfString == null) {
                return;
            }
            object2CopyOnWriteArrayListOfString.remove(str);
            return;
        }
        RFWLog.e("qioc-ViewTagSaveOperate", RFWLog.USR, "removeIocKey params error");
    }

    @Override // com.tencent.biz.richframework.ioc.operate.api.IViewTagSaveOperate
    public void saveIocKeyToViewTag(int i3, View view, String str) {
        if (view != null && i3 != 0 && !TextUtils.isEmpty(str)) {
            CopyOnWriteArrayList<String> object2CopyOnWriteArrayListOfString = RFWIocUtils.object2CopyOnWriteArrayListOfString(view.getTag(i3));
            if (object2CopyOnWriteArrayListOfString == null) {
                object2CopyOnWriteArrayListOfString = new CopyOnWriteArrayList<>();
            }
            if (!object2CopyOnWriteArrayListOfString.contains(str)) {
                object2CopyOnWriteArrayListOfString.add(str);
            }
            view.setTag(i3, object2CopyOnWriteArrayListOfString);
            return;
        }
        RFWLog.e("qioc-ViewTagSaveOperate", RFWLog.USR, "saveIocKey params error");
    }
}
