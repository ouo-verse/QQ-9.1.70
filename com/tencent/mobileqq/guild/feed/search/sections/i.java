package com.tencent.mobileqq.guild.feed.search.sections;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/i;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "d", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "p", "()Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "r", "(Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;)V", "mPlayView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends Section<pn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public GuildFeedListVideoItemWidgetView mPlayView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wba};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f11769725);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.video_item_widget_view)");
        r((GuildFeedListVideoItemWidgetView) findViewById);
    }

    @NotNull
    public final GuildFeedListVideoItemWidgetView p() {
        GuildFeedListVideoItemWidgetView guildFeedListVideoItemWidgetView = this.mPlayView;
        if (guildFeedListVideoItemWidgetView != null) {
            return guildFeedListVideoItemWidgetView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull pn1.a data, int position, @Nullable List<Object> payload) {
        GProStFeed gProStFeed;
        ArrayList<GProStVideo> arrayList;
        Object firstOrNull;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Object a16 = data.d().a();
        String str2 = null;
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        ij1.g gVar = new ij1.g(gProStFeed);
        GProStFeed b16 = gVar.b();
        if (b16 != null && (arrayList = b16.videos) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            GProStVideo gProStVideo = (GProStVideo) firstOrNull;
            if (gProStVideo != null) {
                p().setData(gVar, position);
                GuildFeedListVideoItemWidgetView p16 = p();
                GuildTaskProgressState p17 = gVar.p();
                if (p17 != null && (str = p17.mTaskId) != null) {
                    str2 = str + "_video";
                }
                p16.y0(gProStVideo, str2);
            }
        }
    }

    public final void r(@NotNull GuildFeedListVideoItemWidgetView guildFeedListVideoItemWidgetView) {
        Intrinsics.checkNotNullParameter(guildFeedListVideoItemWidgetView, "<set-?>");
        this.mPlayView = guildFeedListVideoItemWidgetView;
    }
}
