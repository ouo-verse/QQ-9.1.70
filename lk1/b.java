package lk1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryImmersiveEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryShowHorGuideAnimEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.manager.f;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import fk1.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Llk1/b;", "Llk1/a;", "", "currentPosition", "", "l", "contentSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "c", "D", "I", "currentVerticalPosition", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryBaseItemView;", "E", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryBaseItemView;", "lastExposureItemView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends a {

    /* renamed from: D, reason: from kotlin metadata */
    private int currentVerticalPosition = Integer.MIN_VALUE;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryBaseItemView lastExposureItemView;

    private final void l(int currentPosition) {
        boolean z16;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (currentPosition > this.currentVerticalPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        simpleEventBus.dispatchEvent(new GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent(currentPosition, z16));
    }

    private final void m(int contentSize) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryShowHorGuideAnimEvent(contentSize));
    }

    @Override // lk1.a
    public void c(int position) {
        b.C10321b c10321b;
        GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView;
        Object orNull;
        int i3;
        String str;
        Object orNull2;
        GuildFeedGalleryInitBean initBean;
        String feedId;
        GuildFeedGalleryInitBean initBean2;
        GuildFeedGalleryInitBean initBean3;
        List<GuildFeedRichMediaData> richMediaDataList;
        super.c(position);
        if (this.currentVerticalPosition == position) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f414954e.findViewHolderForAdapterPosition(position);
        Unit unit = null;
        if (findViewHolderForAdapterPosition instanceof b.C10321b) {
            c10321b = (b.C10321b) findViewHolderForAdapterPosition;
        } else {
            c10321b = null;
        }
        if (c10321b == null) {
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryChildExposureScroller", 1, "[onPageSelected] galleryHolder is null! pos: " + position);
            return;
        }
        l(position);
        View view = c10321b.itemView;
        if (view instanceof GuildFeedGalleryBaseItemView) {
            guildFeedGalleryBaseItemView = (GuildFeedGalleryBaseItemView) view;
        } else {
            guildFeedGalleryBaseItemView = null;
        }
        List<jk1.a> dataList = this.f414957i.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "mAdapter.dataList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, position);
        jk1.a aVar = (jk1.a) orNull;
        if (aVar != null && (initBean3 = aVar.getInitBean()) != null && (richMediaDataList = initBean3.getRichMediaDataList()) != null) {
            i3 = richMediaDataList.size();
        } else {
            i3 = 0;
        }
        m(i3);
        f fVar = new f(position);
        String str2 = "";
        if (aVar == null || (initBean2 = aVar.getInitBean()) == null || (str = initBean2.getFeedId()) == null) {
            str = "";
        }
        fVar.d(str);
        fVar.e(aVar);
        if (guildFeedGalleryBaseItemView != null) {
            guildFeedGalleryBaseItemView.A0(fVar);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryChildExposureScroller", 1, "[onPageSelected] itemView is not valid ! pos: " + position + ", " + c10321b + ".itemView");
        }
        List<jk1.a> dataList2 = this.f414957i.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList2, "mAdapter.dataList");
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(dataList2, this.currentVerticalPosition);
        jk1.a aVar2 = (jk1.a) orNull2;
        f fVar2 = new f(this.currentVerticalPosition);
        if (aVar2 != null && (initBean = aVar2.getInitBean()) != null && (feedId = initBean.getFeedId()) != null) {
            str2 = feedId;
        }
        fVar2.d(str2);
        GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView2 = this.lastExposureItemView;
        if (guildFeedGalleryBaseItemView2 != null) {
            guildFeedGalleryBaseItemView2.B0(fVar2);
        }
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryChildExposureScroller", 1, "[onPageSelected] notify onFeedSelected[" + position + "] (" + fVar.a() + "), onFeedUnSelected[" + this.currentVerticalPosition + "]:  (" + fVar2.a() + ")");
        this.lastExposureItemView = guildFeedGalleryBaseItemView;
        this.currentVerticalPosition = position;
    }
}
