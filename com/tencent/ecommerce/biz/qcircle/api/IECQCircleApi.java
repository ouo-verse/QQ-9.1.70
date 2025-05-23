package com.tencent.ecommerce.biz.qcircle.api;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\u0014H&J\b\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001e\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\tH&J<\u0010!\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\tH&J2\u0010!\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'H&J2\u0010!\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120(2\u0006\u0010 \u001a\u00020\t2\u0006\u0010)\u001a\u00020*H&J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tH&J\u0014\u0010/\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H&J\u0014\u00100\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H&J\u0014\u00101\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H&J\u001c\u00102\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u00103\u001a\u00020\tH&JH\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2\"\u00107\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n2\n\u00108\u001a\u0006\u0012\u0002\b\u00030\u0012H&J@\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\t2\"\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n2\n\u00108\u001a\u0006\u0012\u0002\b\u00030\u0012H&\u00a8\u0006<"}, d2 = {"Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "", "calculateQCircleRichTextHeight", "", "context", "Landroid/content/Context;", "viewWidth", "propMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createQCircleAvatarView", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleAvatarView;", "createQCircleRichTextView", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "feedRequestDoLike", "", "feedPb", "Lcom/tencent/mobileqq/pb/MessageMicro;", "isPraise", "", "getDateFormat", "time", "", "getDeviceInfo", "getFeedMuteConfig", "getPluginQua", "getQQCirCurrentTabIndex", "", "getQQTabCurrentIndex", "getQua", "ktvPageClose", "pageToken", "launchQCircleFeed", "source", "subSource", "playPos", "pageName", "videoView", "Landroid/view/View;", "", "params", "Lorg/json/JSONObject;", "loadFeedImage", "imageView", "Landroid/widget/ImageView;", "url", "openQCircleComment", "openQCirclePersonalDetailPage", "openQCircleSharePanel", "preDownloadVideo", "pageId", "reportToDc5507", "actionType", "subActionType", "extra", "stfeed", "reportToDt", AdMetricTag.EVENT_NAME, "toStringMap", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECQCircleApi {
    float calculateQCircleRichTextHeight(@NotNull Context context, float viewWidth, @NotNull HashMap<String, Object> propMap);

    @Nullable
    IECQCircleAvatarView createQCircleAvatarView(@NotNull Context context);

    @Nullable
    IECQCircleRichTextView createQCircleRichTextView(@NotNull Context context);

    void feedRequestDoLike(@NotNull MessageMicro<?> feedPb, boolean isPraise);

    @NotNull
    String getDateFormat(long time);

    @NotNull
    String getDeviceInfo();

    boolean getFeedMuteConfig();

    @NotNull
    String getPluginQua();

    int getQQCirCurrentTabIndex();

    int getQQTabCurrentIndex();

    @NotNull
    String getQua();

    void ktvPageClose(@NotNull String pageToken);

    void launchQCircleFeed(@NotNull Context context, int source, int subSource, @NotNull String pageName, @Nullable View videoView);

    void launchQCircleFeed(@NotNull Context context, @NotNull MessageMicro<?> feedPb, int source, int subSource, long playPos, @NotNull String pageName);

    void launchQCircleFeed(@NotNull Context context, @NotNull List<? extends MessageMicro<?>> feedPb, @NotNull String pageToken, @NotNull JSONObject params);

    void loadFeedImage(@NotNull ImageView imageView, @NotNull String url);

    void openQCircleComment(@NotNull MessageMicro<?> feedPb);

    void openQCirclePersonalDetailPage(@NotNull MessageMicro<?> feedPb);

    void openQCircleSharePanel(@NotNull MessageMicro<?> feedPb);

    void preDownloadVideo(@NotNull MessageMicro<?> feedPb, @NotNull String pageId);

    void reportToDc5507(int actionType, int subActionType, @NotNull HashMap<String, String> extra, @NotNull MessageMicro<?> stfeed);

    void reportToDt(@NotNull String eventName, @NotNull HashMap<String, String> toStringMap, @NotNull MessageMicro<?> stfeed);
}
