package com.tencent.mobileqq.guild.feed.video;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u001c\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/a;", "", "", "targetUrl", "", "b", "a", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "BLI_VIDEO_SHORT_CHAIN", "c", "BLI_VIDEO_LONG_CHAIN", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f223983a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Pattern BLI_VIDEO_SHORT_CHAIN = Pattern.compile(".*(http|https)://(b23\\.tv|bili2233\\.cn)/[a-zA-Z0-9]{6,10}.*", 2);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Pattern BLI_VIDEO_LONG_CHAIN = Pattern.compile(".*https://www\\.bilibili\\.com/video/[a-zA-Z0-9]{4,500}.*", 2);

    a() {
    }

    @NotNull
    public final String a(@NotNull String targetUrl) {
        String group;
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Matcher matcher = Pattern.compile("https://(b23\\.tv|bili2233\\.cn)/[a-zA-Z0-9]{0,20}").matcher(targetUrl);
        Matcher matcher2 = Pattern.compile("https://www.bilibili.com/video/[a-zA-Z0-9/_=?!-/]{0,500}").matcher(targetUrl);
        if (matcher.find()) {
            String group2 = matcher.group(0);
            if (group2 == null) {
                return "";
            }
            return group2;
        }
        if (!matcher2.find() || (group = matcher2.group(0)) == null) {
            return "";
        }
        return group;
    }

    public final boolean b(@NotNull String targetUrl) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        if (!BLI_VIDEO_SHORT_CHAIN.matcher(targetUrl).matches() && !BLI_VIDEO_LONG_CHAIN.matcher(targetUrl).matches()) {
            return false;
        }
        return true;
    }
}
