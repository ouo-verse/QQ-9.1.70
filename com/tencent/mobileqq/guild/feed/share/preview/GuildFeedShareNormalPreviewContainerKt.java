package com.tencent.mobileqq.guild.feed.share.preview;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\u0002\"\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/libra/request/Option;", "", "e", "", "g", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "f", "Ljava/text/SimpleDateFormat;", "a", "Lkotlin/Lazy;", "d", "()Ljava/text/SimpleDateFormat;", "formatter", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainerKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f223433a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainerKt$formatter$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("yyyy.MM.dd");
            }
        });
        f223433a = lazy;
    }

    private static final SimpleDateFormat d() {
        return (SimpleDateFormat) f223433a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(Option option) {
        return (Objects.hash(option.getUrl(), option.getTargetView()) << 32) | (Objects.hash(option.getLoadingDrawable()) & 4294967295L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(FeedDetailMainDisplayableParser feedDetailMainDisplayableParser) {
        if (feedDetailMainDisplayableParser.getCreateTime() < 0) {
            return "";
        }
        long millis = TimeUnit.SECONDS.toMillis(feedDetailMainDisplayableParser.getCreateTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        String format = d().format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(calendar.time)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(long j3) {
        if (j3 <= 0) {
            return "";
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j3);
        long j16 = 60;
        long j17 = seconds / j16;
        long j18 = seconds % j16;
        if (j17 >= 60) {
            long j19 = j17 / j16;
            long j26 = j17 % j16;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j18)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17), Long.valueOf(j18)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }
}
