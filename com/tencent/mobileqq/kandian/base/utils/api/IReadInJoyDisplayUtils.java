package com.tencent.mobileqq.kandian.base.utils.api;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015J\u001a\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&J\u001a\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&J&\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J.\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u001c\u0010\u0013\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDisplayUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/util/Pair;", "", "getReadinjoyFeedsBigPictureSize", "getReadinjoyFeedsSmallPictureSize", "duration", "", "getDisplayDuration", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "imageView", "Ljava/net/URL;", "picUrl", "Landroid/content/Context;", "context", "", "configImage", "", "blackPlaceHolder", "shouldShowPlaceHolder", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyDisplayUtils extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239076a;

    @NotNull
    public static final String ELLIPSIZE_END_CHAR = "\u2026";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDisplayUtils$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239076a = new Companion();

        Companion() {
        }
    }

    void configImage(@Nullable KandianUrlImageView imageView, @Nullable URL picUrl, @Nullable Context context);

    void configImage(@Nullable KandianUrlImageView imageView, @Nullable URL picUrl, @Nullable Context context, boolean blackPlaceHolder);

    @Nullable
    String getDisplayDuration(int duration);

    @Nullable
    Pair<Integer, Integer> getReadinjoyFeedsBigPictureSize();

    @Nullable
    Pair<Integer, Integer> getReadinjoyFeedsSmallPictureSize();

    boolean shouldShowPlaceHolder(@Nullable Context context, @Nullable URL picUrl);
}
