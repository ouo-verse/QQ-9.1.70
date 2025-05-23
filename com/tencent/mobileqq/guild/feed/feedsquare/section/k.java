package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0004B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lij1/g;", "", "b", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "d", "data", "", "position", "", "", "payload", "c", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "depend", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "e", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "a", "()Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "(Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;)V", "mPlayView", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends a<ij1.g> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depend;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public GuildFeedListVideoItemWidgetView mPlayView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "", "", "c", "Landroid/view/View;", "v", "", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        @Nullable
        GuildFeedBaseInitBean a();

        void b(@NotNull View v3);

        int c();
    }

    public k(@NotNull b depend) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.depend = depend;
    }

    @NotNull
    public final GuildFeedListVideoItemWidgetView a() {
        GuildFeedListVideoItemWidgetView guildFeedListVideoItemWidgetView = this.mPlayView;
        if (guildFeedListVideoItemWidgetView != null) {
            return guildFeedListVideoItemWidgetView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        return null;
    }

    @NotNull
    public int[] b() {
        return new int[]{R.id.wba};
    }

    public void c(@NotNull ij1.g data, int position, @Nullable List<Object> payload) {
        ArrayList<GProStVideo> arrayList;
        Object firstOrNull;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        GProStFeed b16 = data.b();
        if (b16 != null && (arrayList = b16.videos) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            GProStVideo gProStVideo = (GProStVideo) firstOrNull;
            if (gProStVideo != null) {
                a().setData(data, position);
                a().setInitBean(this.depend.a());
                a().setSortMode(this.depend.c());
                GuildFeedListVideoItemWidgetView a16 = a();
                GuildTaskProgressState p16 = data.p();
                if (p16 != null && (str2 = p16.mTaskId) != null) {
                    str = str2 + "_video";
                } else {
                    str = null;
                }
                a16.y0(gProStVideo, str);
                QLog.d("GuildFeedSquareSingleVideoSection", 1, "[onBindData] pos = " + position + ", this is " + hashCode());
                b bVar = this.depend;
                View F0 = a().F0();
                Intrinsics.checkNotNullExpressionValue(F0, "mPlayView.videoContainer");
                bVar.b(F0);
            }
        }
    }

    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f11769725);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.video_item_widget_view)");
        e((GuildFeedListVideoItemWidgetView) findViewById);
    }

    public final void e(@NotNull GuildFeedListVideoItemWidgetView guildFeedListVideoItemWidgetView) {
        Intrinsics.checkNotNullParameter(guildFeedListVideoItemWidgetView, "<set-?>");
        this.mPlayView = guildFeedListVideoItemWidgetView;
    }
}
