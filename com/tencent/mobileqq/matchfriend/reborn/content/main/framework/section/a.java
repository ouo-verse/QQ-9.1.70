package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareDTReportClickEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareDTReportExposureEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003R\u0011\u0010\u0011\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "", "", "params", "r", "", "resId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "elementId", "", "u", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "p", "()Landroid/content/Context;", "context", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class a extends Section<FeedPB$Feed> {
    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> r(Map<String, String> params) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FeedPB$Feed feedPB$Feed = (FeedPB$Feed) this.mData;
        if (feedPB$Feed != null) {
            linkedHashMap.put("kl_feed_id", u72.a.b(feedPB$Feed));
            linkedHashMap.put("kl_author_id", u72.a.g(feedPB$Feed));
            linkedHashMap.put("kl_recom_trace", u72.a.h(feedPB$Feed));
        }
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        return linkedHashMap;
    }

    public final Context p() {
        Context context = getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        return context;
    }

    public final String q(int resId) {
        String string = p().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    public final void s(String elementId, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSquareDTReportClickEvent(elementId, r(params)));
    }

    public final void u(String elementId, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSquareDTReportExposureEvent(elementId, r(params), false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(a aVar, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                map = null;
            }
            aVar.s(str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(a aVar, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                map = null;
            }
            aVar.u(str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExpose");
    }
}
