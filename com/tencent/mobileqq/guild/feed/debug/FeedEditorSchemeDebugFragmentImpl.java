package com.tencent.mobileqq.guild.feed.debug;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/debug/FeedEditorSchemeDebugFragmentImpl;", "Lcom/tencent/mobileqq/guild/feed/api/e;", "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "b", "Landroidx/activity/result/ActivityResultCallback;", "getMediaAdapterActivityCallback", "()Landroidx/activity/result/ActivityResultCallback;", "mediaAdapterActivityCallback", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "c", "Landroidx/lifecycle/MutableLiveData;", "_guildIdLiveData", "d", "_channelIdLiveData", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "e", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "mediaAdapter", "Lcom/tencent/mobileqq/guild/feed/partpanel/ui/b;", "f", "Lcom/tencent/mobileqq/guild/feed/partpanel/ui/b;", "partPanelManager", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorSchemeDebugFragmentImpl implements com.tencent.mobileqq.guild.feed.api.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ActivityResultCallback<ActivityResult> mediaAdapterActivityCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _guildIdLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _channelIdLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FeedPostMediaPreviewAdapter mediaAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.partpanel.ui.b partPanelManager;

    public FeedEditorSchemeDebugFragmentImpl(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.mediaAdapterActivityCallback = new ActivityResultCallback() { // from class: com.tencent.mobileqq.guild.feed.debug.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FeedEditorSchemeDebugFragmentImpl.d(FeedEditorSchemeDebugFragmentImpl.this, (ActivityResult) obj);
            }
        };
        this._guildIdLiveData = new MutableLiveData<>("");
        this._channelIdLiveData = new MutableLiveData<>("");
        fragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.feed.debug.FeedEditorSchemeDebugFragmentImpl.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    FeedEditorSchemeDebugFragmentImpl.b(FeedEditorSchemeDebugFragmentImpl.this);
                    com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar = FeedEditorSchemeDebugFragmentImpl.this.partPanelManager;
                    if (bVar != null) {
                        bVar.u();
                    }
                }
            }
        });
    }

    public static final /* synthetic */ nk1.b b(FeedEditorSchemeDebugFragmentImpl feedEditorSchemeDebugFragmentImpl) {
        feedEditorSchemeDebugFragmentImpl.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedEditorSchemeDebugFragmentImpl this$0, ActivityResult result) {
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildFeedMediaApi iGuildFeedMediaApi = (IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        List<Object> mediaInfoList = iGuildFeedMediaApi.getMediaInfoList(result);
        List<Object> list = mediaInfoList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this$0.mediaAdapter;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        List<Object> list2 = mediaInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) it.next();
            int i3 = AlbumThumbDownloader.THUMB_WIDHT;
            localMediaInfo.thumbWidth = i3;
            localMediaInfo.thumbHeight = i3;
            arrayList.add(new fm1.c(localMediaInfo, com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b()));
        }
        feedPostMediaPreviewAdapter.x0(arrayList);
    }
}
