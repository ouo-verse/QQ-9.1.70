package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import circlesearch.CircleSearchExhibition$JumpInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua0.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J0\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J.\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/b;", "", "Landroid/content/Context;", "context", "Lcirclesearch/CircleSearchExhibition$JumpInfo;", "jumpInfo", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "", "block", "d", "", "url", "c", "Landroid/view/View;", "view", "Lfeedcloud/FeedCloudCommon$StCommonExt;", CacheTable.TABLE_NAME, "a", "info", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f89965a = new b();

    b() {
    }

    private final void c(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            QLog.w("QFSSearchPromptRankListHelper", 1, "[jumpToH5] url is empty");
        } else {
            QCircleSchemeLauncher.f(context, url);
        }
    }

    private final void d(Context context, CircleSearchExhibition$JumpInfo jumpInfo, Function1<? super QFSSearchInfo, Unit> block) {
        PartManager partManager;
        String str = jumpInfo.query.get();
        Intrinsics.checkNotNullExpressionValue(str, "jumpInfo.query.get()");
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSSearchPromptRankListHelper", 1, "[jumpToSearchResultPage] queryText is empty");
            return;
        }
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        qFSSearchInfo.k(str);
        if (jumpInfo.query_source.has()) {
            qFSSearchInfo.j(jumpInfo.query_source.get());
        }
        if (block != null) {
            block.invoke(qFSSearchInfo);
        }
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(context);
        if (qCircleBaseFragment != null && (partManager = qCircleBaseFragment.getPartManager()) != null) {
            partManager.broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
        }
    }

    public final void a(@Nullable View view, @Nullable FeedCloudCommon$StCommonExt reportInfo) {
        boolean isBlank;
        if (view == null || reportInfo == null || !reportInfo.has() || reportInfo.mapInfo.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<FeedCloudCommon$Entry> list = reportInfo.mapInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "reportInfo.mapInfo.get()");
        String str = "";
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            String key = feedCloudCommon$Entry.key.get();
            String value = feedCloudCommon$Entry.value.get();
            if (Intrinsics.areEqual(key, "elementId")) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                str = value;
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            hashMap.put(key, value);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            i.k(view, str, hashMap, reportInfo.hashCode());
        }
    }

    public final void b(@NotNull Context context, @NotNull CircleSearchExhibition$JumpInfo info, @Nullable Function1<? super QFSSearchInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        if (!info.type.has()) {
            QLog.w("QFSSearchPromptRankListHelper", 1, "[jump] no type");
            return;
        }
        QLog.d("QFSSearchPromptRankListHelper", 1, "[jump] type=" + info.type.get() + ", query=" + info.query.get() + ", url=" + info.url.get());
        int i3 = info.type.get();
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.w("QFSSearchPromptRankListHelper", 1, "[jump] invalid type, " + info.type.get());
                return;
            }
            String str = info.url.get();
            Intrinsics.checkNotNullExpressionValue(str, "info.url.get()");
            c(context, str);
            return;
        }
        d(context, info, block);
    }
}
