package com.tencent.mobileqq.guild.feed.topic;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.part.RecyclerViewGifAutoPlayPart;
import com.tencent.mobileqq.guild.feed.part.at;
import com.tencent.mobileqq.guild.feed.topic.part.TopicListPart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicListScrollerPart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicVideoAutoPlayPart;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "", "qh", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedBeforePartInit", "onBackEvent", "", "ph", "", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/topic/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/topic/d;", "topicListSession", "Lcom/tencent/mobileqq/guild/feed/topic/c;", "D", "Lcom/tencent/mobileqq/guild/feed/topic/c;", "topicListDepends", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicListFragment extends BasePartFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private d topicListSession;

    /* renamed from: D, reason: from kotlin metadata */
    private c topicListDepends;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragment$a;", "", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", ISchemeApi.KEY_PAGE_DATA, "Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.TopicListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TopicListFragment a(@NotNull PageData pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            TopicListFragment topicListFragment = new TopicListFragment();
            topicListFragment.setArguments(new TopicListFragmentArgs(pageData).b());
            return topicListFragment;
        }

        Companion() {
        }
    }

    private final boolean qh() {
        e eVar;
        a aVar;
        b bVar;
        TopicListFragmentArgs a16 = TopicListFragmentArgs.INSTANCE.a(getArguments());
        if (a16 == null || (eVar = (e) PartFragmentIOCKt.getIocInterface(this, e.class)) == null || (aVar = (a) PartFragmentIOCKt.getIocInterface(this, a.class)) == null || (bVar = (b) PartFragmentIOCKt.getIocInterface(this, b.class)) == null) {
            return false;
        }
        this.topicListSession = TopicContextKt.f(eVar, a16.getPageData());
        this.topicListDepends = TopicContextKt.d(aVar, bVar);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ List assembleParts() {
        return (List) ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f95;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PartFragmentIOCKt.unregisterIoc(this, c.class);
        PartFragmentIOCKt.unregisterIoc(this, d.class);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        List<Part> listOf;
        FragmentActivity activity;
        if (!qh()) {
            QLog.e("GTopic_TopicListFragment", 1, "restoreData fail " + getArguments());
            if (!GuildSplitViewUtils.f235370a.n(getActivity()) && (activity = getActivity()) != null) {
                activity.finish();
                return;
            }
            return;
        }
        PartManager partManager = getPartManager();
        if (partManager != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{new RecyclerViewGifAutoPlayPart(R.id.f100245rz), new at(R.id.f100245rz), new TopicVideoAutoPlayPart(), new TopicListPart(), new TopicListScrollerPart(), new TopicListReservePart()});
            partManager.registerPart(listOf);
        }
        d dVar = this.topicListSession;
        c cVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicListSession");
            dVar = null;
        }
        PartFragmentIOCKt.registerIoc(this, dVar, d.class);
        c cVar2 = this.topicListDepends;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicListDepends");
        } else {
            cVar = cVar2;
        }
        PartFragmentIOCKt.registerIoc(this, cVar, c.class);
    }

    @Nullable
    public Void ph() {
        return null;
    }
}
