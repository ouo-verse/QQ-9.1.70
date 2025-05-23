package com.tencent.biz.qqcircle.aioshare;

import androidx.lifecycle.MutableLiveData;
import com.qq.wx.voice.util.ErrorCode;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0006R#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R?\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u0015j\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/QFSAIOSendDataManager;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "add", "", "e", "", "sourceType", "", "feedId", "a", "d", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "mSelectFeedListLiveData", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "mDtSelectFeedMap", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAIOSendDataManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSAIOSendDataManager f82679a = new QFSAIOSendDataManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<FeedCloudMeta$StFeed>> mSelectFeedListLiveData = new MutableLiveData<>(new ArrayList());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedHashMap<String, List<String>> mDtSelectFeedMap = new LinkedHashMap<>();

    QFSAIOSendDataManager() {
    }

    public final void a(int sourceType, @NotNull String feedId) {
        String str;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (sourceType != 20108) {
            switch (sourceType) {
                case ErrorCode.ERROR_CMD_INVALID /* 20101 */:
                    str = "\u4f5c\u54c1";
                    break;
                case ErrorCode.ERROR_APPID_NOT_FOUND /* 20102 */:
                    str = "\u8d5e\u8fc7";
                    break;
                case ErrorCode.ERROR_VERIFY_FAILED /* 20103 */:
                    str = "\u63a8\u8fc7";
                    break;
                default:
                    str = "\u770b\u8fc7";
                    break;
            }
        } else {
            str = "\u6536\u85cf";
        }
        LinkedHashMap<String, List<String>> linkedHashMap = mDtSelectFeedMap;
        List<String> list = linkedHashMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
            linkedHashMap.put(str, list);
        }
        list.add(feedId);
    }

    @NotNull
    public final LinkedHashMap<String, List<String>> b() {
        return mDtSelectFeedMap;
    }

    @NotNull
    public final MutableLiveData<List<FeedCloudMeta$StFeed>> c() {
        return mSelectFeedListLiveData;
    }

    public final void d() {
        List<FeedCloudMeta$StFeed> value = mSelectFeedListLiveData.getValue();
        if (value != null) {
            value.clear();
        }
        mDtSelectFeedMap.clear();
    }

    public final void e(@NotNull final FeedCloudMeta$StFeed feed, boolean add) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        mDtSelectFeedMap.clear();
        MutableLiveData<List<FeedCloudMeta$StFeed>> mutableLiveData = mSelectFeedListLiveData;
        List<FeedCloudMeta$StFeed> value = mutableLiveData.getValue();
        if (value != null) {
            if (!add) {
                CollectionsKt__MutableCollectionsKt.removeAll((List) value, (Function1) new Function1<FeedCloudMeta$StFeed, Boolean>() { // from class: com.tencent.biz.qqcircle.aioshare.QFSAIOSendDataManager$updateSelectFeedList$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull FeedCloudMeta$StFeed it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.f398449id.get(), FeedCloudMeta$StFeed.this.f398449id.get()));
                    }
                });
            } else {
                value.add(feed);
            }
        }
        mutableLiveData.postValue(mutableLiveData.getValue());
    }
}
