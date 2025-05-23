package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\b\t\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "type", "", "a", "<init>", "()V", "DefaultUIStateDataOperateImpl", "InsertType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class UIStateDataUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final UIStateDataUtils f219309a = new UIStateDataUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u00120\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000fH\u0016R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$DefaultUIStateDataOperateImpl;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/n;", "", "Lij1/g;", "newFeedList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "args", "", "J1", "modifyFeed", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/p;", "x1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/q;", "argsV2", "i1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/b;", "J0", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "feedsListData", "<init>", "(Landroidx/lifecycle/MutableLiveData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class DefaultUIStateDataOperateImpl implements com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<UIStateData<List<ij1.g>>> feedsListData;

        public DefaultUIStateDataOperateImpl(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> feedsListData) {
            Intrinsics.checkNotNullParameter(feedsListData, "feedsListData");
            this.feedsListData = feedsListData;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
        public void J0(@NotNull final DeleteFeedArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                s.b(this.feedsListData, args);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils$DefaultUIStateDataOperateImpl$deleteFeed$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.b(UIStateDataUtils.DefaultUIStateDataOperateImpl.this.feedsListData, args);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
        public void J1(@NotNull final List<? extends ij1.g> newFeedList, @NotNull final InsertFeedArgs args) {
            Intrinsics.checkNotNullParameter(newFeedList, "newFeedList");
            Intrinsics.checkNotNullParameter(args, "args");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                s.c(this.feedsListData, newFeedList, args);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils$DefaultUIStateDataOperateImpl$insertFeedList$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.c(UIStateDataUtils.DefaultUIStateDataOperateImpl.this.feedsListData, newFeedList, args);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
        public void i1(@NotNull final ModifyFeedArgsV2 argsV2) {
            Intrinsics.checkNotNullParameter(argsV2, "argsV2");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                s.d(this.feedsListData, argsV2);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils$DefaultUIStateDataOperateImpl$modifyFeed$$inlined$ensureUiThread$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.d(UIStateDataUtils.DefaultUIStateDataOperateImpl.this.feedsListData, argsV2);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
        public void x1(@NotNull final ij1.g modifyFeed, @NotNull final ModifyFeedArgs args) {
            Intrinsics.checkNotNullParameter(modifyFeed, "modifyFeed");
            Intrinsics.checkNotNullParameter(args, "args");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                s.e(this.feedsListData, modifyFeed, args);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils$DefaultUIStateDataOperateImpl$modifyFeed$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.e(UIStateDataUtils.DefaultUIStateDataOperateImpl.this.feedsListData, modifyFeed, args);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "", "(Ljava/lang/String;I)V", "NewFeed", "PublishFeed", "Other", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum InsertType {
        NewFeed,
        PublishFeed,
        Other
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "type", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class UIStateDataInsertType {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final InsertType type;

        public UIStateDataInsertType(@NotNull InsertType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final InsertType getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UIStateDataInsertType) && this.type == ((UIStateDataInsertType) other).type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "UIStateDataInsertType(type=" + this.type + ")";
        }
    }

    UIStateDataUtils() {
    }

    @NotNull
    public final byte[] a(@NotNull InsertType type) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            Result.Companion companion = Result.INSTANCE;
            String json = new Gson().toJson(new UIStateDataInsertType(type));
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(UIStateDataInsertType(type))");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            m476constructorimpl = Result.m476constructorimpl(bytes);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = new byte[0];
        }
        return (byte[]) m476constructorimpl;
    }
}
