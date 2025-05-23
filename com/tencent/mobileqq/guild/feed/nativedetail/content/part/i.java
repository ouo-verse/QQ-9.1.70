package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.CommentLoadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/i;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lil1/c;", "z9", "", "A9", "", "args", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "", "action", "getMessage", "handleBroadcastMessage", "d", "Lil1/c;", "loadMoreAdapter", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends Part implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private il1.c loadMoreAdapter;

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A9() {
        il1.c cVar;
        boolean z16;
        CommentLoadInfo commentLoadInfo = null;
        Object broadcastGetMessage = broadcastGetMessage("action_get_comment_load_info", null);
        if (broadcastGetMessage instanceof CommentLoadInfo) {
            commentLoadInfo = (CommentLoadInfo) broadcastGetMessage;
        }
        if (commentLoadInfo != null) {
            if (commentLoadInfo.getListSize() == 0) {
                il1.c cVar2 = this.loadMoreAdapter;
                if (cVar2 != null && cVar2.getIsFeedAllowSendComment()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    il1.c cVar3 = this.loadMoreAdapter;
                    if (cVar3 != null) {
                        cVar3.hide();
                    }
                    cVar = this.loadMoreAdapter;
                    if (cVar == null) {
                        cVar.setLoadState(false, !commentLoadInfo.getIsFinish());
                        cVar.onLoadMoreEnd(!commentLoadInfo.getIsFinish());
                        return;
                    }
                    return;
                }
            }
            il1.c cVar4 = this.loadMoreAdapter;
            if (cVar4 != null) {
                cVar4.show();
            }
            cVar = this.loadMoreAdapter;
            if (cVar == null) {
            }
        }
    }

    private final void x9(Object args) {
        il1.c cVar;
        if ((args instanceof g.UpdateFeedAllowCommentMessage) && (cVar = this.loadMoreAdapter) != null) {
            cVar.r0(((g.UpdateFeedAllowCommentMessage) args).getIsAllowComment());
        }
    }

    private final il1.c z9() {
        if (this.loadMoreAdapter == null) {
            il1.c cVar = new il1.c();
            cVar.setHasStableIds(true);
            cVar.registerLoadMoreListener(this);
            this.loadMoreAdapter = cVar;
        }
        il1.c cVar2 = this.loadMoreAdapter;
        Intrinsics.checkNotNull(cVar2);
        return cVar2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "action_get_comment_load_more_adapter")) {
            return z9();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        il1.c cVar;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1531933525) {
                if (hashCode != -1392452505) {
                    if (hashCode == -35842170 && action.equals("message_update_feed_allow_comment")) {
                        x9(args);
                        return;
                    }
                    return;
                }
                if (action.equals("message_update_load_more_view_visible")) {
                    A9();
                    return;
                }
                return;
            }
            if (action.equals("message_on_reload_begin") && (cVar = this.loadMoreAdapter) != null) {
                cVar.hide();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.i("FeedNativeDetail.ContentCommentLoadMorePart", 1, "broadcastMessage MESSAGE_LOAD_MORE");
        broadcastMessage("message_load_more", new g.LoadMoreMessage("FeedNativeDetail.ContentCommentLoadMorePart", null, 2, null));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        il1.c cVar = this.loadMoreAdapter;
        if (cVar != null) {
            cVar.unRegisterLoadMoreListener(this);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
