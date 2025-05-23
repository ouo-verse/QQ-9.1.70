package com.qzone.reborn.feedx.widget.homepage;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R,\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTopEntranceFactory;", "", "", "type", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTopEntrancePanelItemView;", "a", "", "Lkotlin/Function1;", "b", "Ljava/util/Map;", "sTopEntranceViewMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneHomePageTopEntranceFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneHomePageTopEntranceFactory f56381a = new QZoneHomePageTopEntranceFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, Function1<Context, QZoneHomePageTopEntrancePanelItemView>> sTopEntranceViewMap;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        sTopEntranceViewMap = linkedHashMap;
        linkedHashMap.put(16, new Function1<Context, QZoneHomePageTopIntimateEntranceView>() { // from class: com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntranceFactory.1
            @Override // kotlin.jvm.functions.Function1
            public final QZoneHomePageTopIntimateEntranceView invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new QZoneHomePageTopIntimateEntranceView(context);
            }
        });
    }

    QZoneHomePageTopEntranceFactory() {
    }

    public final QZoneHomePageTopEntrancePanelItemView a(int type, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Function1<Context, QZoneHomePageTopEntrancePanelItemView> function1 = sTopEntranceViewMap.get(Integer.valueOf(type));
            if (function1 == null) {
                return null;
            }
            return function1.invoke(context);
        } catch (Exception e16) {
            QLog.e("QZoneHomePageTopEntranceFactory", 1, "exception is " + e16);
            return null;
        }
    }
}
