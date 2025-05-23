package com.tencent.mobileqq.guild.feed.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedImagePreDecoder;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "get", "Landroid/graphics/drawable/Drawable;", "allUrlList", "", "", "putIfAbsent", "", "drawable", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedImagePreDecoder extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(IGuildFeedImagePreDecoder iGuildFeedImagePreDecoder, List list, Drawable drawable, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    drawable = null;
                }
                iGuildFeedImagePreDecoder.putIfAbsent(list, drawable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putIfAbsent");
        }
    }

    @Nullable
    Drawable get(@NotNull List<String> allUrlList);

    void putIfAbsent(@NotNull List<String> allUrlList, @Nullable Drawable drawable);
}
