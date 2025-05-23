package nx1;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lnx1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "b", "Landroid/view/View;", "d", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "c", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "channelId", "e", "Z", "()Z", "isDirectMsg", "<init>", "(Landroid/app/Activity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nx1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ReportPageArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View rootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDirectMsg;

    public ReportPageArgs(@NotNull Activity activity, @NotNull View rootView, @NotNull String guildId, @NotNull String channelId, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.activity = activity;
        this.rootView = rootView;
        this.guildId = guildId;
        this.channelId = channelId;
        this.isDirectMsg = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsDirectMsg() {
        return this.isDirectMsg;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportPageArgs)) {
            return false;
        }
        ReportPageArgs reportPageArgs = (ReportPageArgs) other;
        if (Intrinsics.areEqual(this.activity, reportPageArgs.activity) && Intrinsics.areEqual(this.rootView, reportPageArgs.rootView) && Intrinsics.areEqual(this.guildId, reportPageArgs.guildId) && Intrinsics.areEqual(this.channelId, reportPageArgs.channelId) && this.isDirectMsg == reportPageArgs.isDirectMsg) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.activity.hashCode() * 31) + this.rootView.hashCode()) * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31;
        boolean z16 = this.isDirectMsg;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ReportPageArgs(activity=" + this.activity + ", rootView=" + this.rootView + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", isDirectMsg=" + this.isDirectMsg + ")";
    }
}
