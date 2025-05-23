package d70;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\n\u001a\u00020\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Ld70/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/QFSLayerBaseViewModel;", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "Lqqcircle/QQCircleDitto$StItemInfo;", "tagList", "", "Z1", "W1", "X1", "E", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", UserInfo.SEX_FEMALE, "Ljava/util/List;", "allTagList", "", "G", "I", "fromIndex", "Landroidx/lifecycle/MutableLiveData;", "", "", "H", "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "selectedTagLiveData", "U1", "()Ljava/util/Set;", "selectedTagSet", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends QFSLayerBaseViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feed;

    /* renamed from: G, reason: from kotlin metadata */
    private int fromIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<QQCircleDitto$StItemInfo> allTagList = new ArrayList();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Set<String>> selectedTagLiveData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Set<String>> T1() {
        return this.selectedTagLiveData;
    }

    @NotNull
    public final Set<String> U1() {
        Set<String> value = this.selectedTagLiveData.getValue();
        if (value == null) {
            HashSet hashSet = new HashSet();
            this.selectedTagLiveData.setValue(hashSet);
            return hashSet;
        }
        return value;
    }

    @NotNull
    public final List<QQCircleDitto$StItemInfo> W1() {
        int size = this.allTagList.size();
        if (this.fromIndex >= size) {
            this.fromIndex = 0;
        }
        int min = Math.min(this.fromIndex + 10, size);
        List<QQCircleDitto$StItemInfo> subList = this.allTagList.subList(this.fromIndex, min);
        this.fromIndex = min;
        return subList;
    }

    public final void X1() {
        this.selectedTagLiveData.setValue(new HashSet());
    }

    public final void Z1(@NotNull FeedCloudMeta$StFeed data, @NotNull List<QQCircleDitto$StItemInfo> tagList) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        if (!Intrinsics.areEqual(this.feed, data)) {
            X1();
        }
        this.feed = data;
        this.allTagList = tagList;
        this.fromIndex = 0;
    }
}
