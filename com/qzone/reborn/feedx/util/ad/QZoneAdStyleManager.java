package com.qzone.reborn.feedx.util.ad;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtTimeLineComponentData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedx/util/ad/QZoneAdStyleManager;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "c", "b", "", "", "d", "", "code", "a", "displayCode", "e", "<init>", "()V", "BottomAreaCode", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdStyleManager {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneAdStyleManager f55731a = new QZoneAdStyleManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/feedx/util/ad/QZoneAdStyleManager$BottomAreaCode;", "", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes37.dex */
    public @interface BottomAreaCode {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f55732a;
        public static final long DEFAULT = 1;
        public static final long TIME_LINE = 4;
        public static final long TIPS = 2;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/feedx/util/ad/QZoneAdStyleManager$BottomAreaCode$a;", "", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.qzone.reborn.feedx.util.ad.QZoneAdStyleManager$BottomAreaCode$a, reason: from kotlin metadata */
        /* loaded from: classes37.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f55732a = new Companion();

            Companion() {
            }
        }
    }

    QZoneAdStyleManager() {
    }

    private final boolean c(BusinessFeedData feedData) {
        List<GdtTimeLineComponentData> B = QZoneAdFeedUtils.f55717a.B(feedData);
        List<GdtTimeLineComponentData> list = B;
        if (list == null || list.isEmpty()) {
            QLog.e("QZoneAdStyleManager", 1, "[checkTimeLineParams] is empty");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            Collections.sort(B);
            int size = B.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                GdtTimeLineComponentData gdtTimeLineComponentData = B.get(i3);
                if (gdtTimeLineComponentData != null && gdtTimeLineComponentData.isValid()) {
                    if (gdtTimeLineComponentData.endTimeSeconds >= currentTimeMillis && gdtTimeLineComponentData.beginTimeSeconds <= currentTimeMillis) {
                        z16 = true;
                    }
                    if (i3 < B.size() - 1 && gdtTimeLineComponentData.endTimeSeconds > B.get(i3 + 1).beginTimeSeconds) {
                        QLog.e("QZoneAdStyleManager", 1, "[checkTimeLineParams] error components times");
                        return false;
                    }
                }
                QLog.e("QZoneAdStyleManager", 1, "[checkTimeLineParams] components error");
                return false;
            }
            return z16;
        } catch (Throwable unused) {
            QLog.e("QZoneAdStyleManager", 1, "[checkTimeLineParams] sort error");
            return false;
        }
    }

    private final List<String> d(BusinessFeedData feedData) {
        if (QZoneAdFeedUtils.f55717a.Z(feedData)) {
            if (!TextUtils.isEmpty(feedData != null ? feedData.getValueFromCurrencyPassField("display_code_list") : null)) {
                try {
                    LinkedList linkedList = new LinkedList();
                    JSONArray jSONArray = new JSONArray(feedData != null ? feedData.getValueFromCurrencyPassField("display_code_list") : null);
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String str = jSONArray.optString(i3);
                        if (!TextUtils.isEmpty(str)) {
                            Intrinsics.checkNotNullExpressionValue(str, "str");
                            linkedList.add(str);
                        }
                    }
                    return linkedList;
                } catch (Throwable th5) {
                    QLog.e("QZoneAdStyleManager", 1, "[getDisplayCodeList] error", th5);
                }
            }
        }
        return null;
    }

    public final boolean a(@BottomAreaCode long code, BusinessFeedData feedData) {
        return b(feedData) ? (code & 4) > 0 : (2 & code) > 0 || (code & 1) > 0;
    }

    public final boolean e(BusinessFeedData feedData, String displayCode) {
        List<String> d16;
        Intrinsics.checkNotNullParameter(displayCode, "displayCode");
        if (TextUtils.isEmpty(displayCode) || (d16 = d(feedData)) == null) {
            return false;
        }
        Iterator<String> it = d16.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(displayCode, it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean b(BusinessFeedData feedData) {
        Integer num;
        if (feedData != null) {
            num = Integer.valueOf(feedData.isGDTAdvFeed() ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(feedData) : Integer.MIN_VALUE);
        } else {
            num = null;
        }
        return ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) && c(feedData) && e(feedData, "TimelineWidget");
    }
}
