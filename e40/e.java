package e40;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import java.util.List;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public QQCircleTianShu$AdItem f395599a;

    public e(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
        this.f395599a = qQCircleTianShu$AdItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> a() {
        List<QQCircleTianShu$MapEntry> list;
        HashMap<String, String> hashMap = new HashMap<>();
        QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.f395599a;
        if (qQCircleTianShu$AdItem != null && qQCircleTianShu$AdItem.has() && (list = this.f395599a.argList.get()) != null && !list.isEmpty()) {
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                hashMap.put(qQCircleTianShu$MapEntry.key.get(), qQCircleTianShu$MapEntry.value.get());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append(QCircleScheme.AttrQQPublish.REVITALIZE);
        stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
        stringBuffer.append("1");
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append(QCircleScheme.AttrQQPublish.SELECT_PAGE_BANNER_ICON);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(Uri.encode(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append(QCircleScheme.AttrQQPublish.SELECT_PAGE_BANNER_TIP);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }

    public String c() {
        QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.f395599a;
        if (qQCircleTianShu$AdItem != null) {
            return String.valueOf(qQCircleTianShu$AdItem.iAdId.get());
        }
        return "";
    }
}
