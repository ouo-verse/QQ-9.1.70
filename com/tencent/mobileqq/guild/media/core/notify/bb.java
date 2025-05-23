package com.tencent.mobileqq.guild.media.core.notify;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/bb;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hintText", "e", "a", "actionText", "f", "b", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bb implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hintText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultText;

    public bb() {
        this(null, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDefaultText() {
        return this.defaultText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getHintText() {
        return this.hintText;
    }

    public bb(@NotNull String hintText, @NotNull String actionText, @NotNull String defaultText) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        this.hintText = hintText;
        this.actionText = actionText;
        this.defaultText = defaultText;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ bb(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "" : str3);
        str = (i3 & 1) != 0 ? "" : str;
        if ((i3 & 2) != 0) {
            str2 = ch.i().getString(R.string.hen);
            Intrinsics.checkNotNullExpressionValue(str2, "appContext()\n           \u2026op.api.R.string.send_req)");
        }
    }
}
