package pa0;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudPubGuideSvr$GuideResource;
import feedcloud.FeedCloudPubGuideSvr$ResourceInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0016R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lpa0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lfeedcloud/FeedCloudPubGuideSvr$ResourceInfo;", "a", "Ljava/util/List;", "getInfoList", "()Ljava/util/List;", "infoList", "b", "Z", "getShowNewerTeachGuide", "()Z", "showNewerTeachGuide", "c", "()Ljava/lang/String;", "templateIconUrl", "cameraIconUrl", "Lfeedcloud/FeedCloudPubGuideSvr$GuideResource;", "()Lfeedcloud/FeedCloudPubGuideSvr$GuideResource;", "newerPendentGuide", "<init>", "(Ljava/util/List;Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pa0.d, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PlusMenuServerData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<FeedCloudPubGuideSvr$ResourceInfo> infoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showNewerTeachGuide;

    public PlusMenuServerData(@NotNull List<FeedCloudPubGuideSvr$ResourceInfo> infoList, boolean z16) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.infoList = infoList;
        this.showNewerTeachGuide = z16;
    }

    @Nullable
    public final String a() {
        Object obj;
        PBRepeatMessageField<FeedCloudPubGuideSvr$GuideResource> pBRepeatMessageField;
        List<FeedCloudPubGuideSvr$GuideResource> list;
        Object firstOrNull;
        PBStringField pBStringField;
        boolean z16;
        Iterator<T> it = this.infoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudPubGuideSvr$ResourceInfo) obj).resource_type.get() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudPubGuideSvr$ResourceInfo feedCloudPubGuideSvr$ResourceInfo = (FeedCloudPubGuideSvr$ResourceInfo) obj;
        if (feedCloudPubGuideSvr$ResourceInfo != null && (pBRepeatMessageField = feedCloudPubGuideSvr$ResourceInfo.guide_resources) != null && (list = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            FeedCloudPubGuideSvr$GuideResource feedCloudPubGuideSvr$GuideResource = (FeedCloudPubGuideSvr$GuideResource) firstOrNull;
            if (feedCloudPubGuideSvr$GuideResource == null || (pBStringField = feedCloudPubGuideSvr$GuideResource.thumbnail_img) == null) {
                return null;
            }
            return pBStringField.get();
        }
        return null;
    }

    @Nullable
    public final FeedCloudPubGuideSvr$GuideResource b() {
        Object obj;
        PBRepeatMessageField<FeedCloudPubGuideSvr$GuideResource> pBRepeatMessageField;
        List<FeedCloudPubGuideSvr$GuideResource> list;
        Object firstOrNull;
        boolean z16;
        Iterator<T> it = this.infoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudPubGuideSvr$ResourceInfo) obj).resource_type.get() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudPubGuideSvr$ResourceInfo feedCloudPubGuideSvr$ResourceInfo = (FeedCloudPubGuideSvr$ResourceInfo) obj;
        if (feedCloudPubGuideSvr$ResourceInfo != null && (pBRepeatMessageField = feedCloudPubGuideSvr$ResourceInfo.guide_resources) != null && (list = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            return (FeedCloudPubGuideSvr$GuideResource) firstOrNull;
        }
        return null;
    }

    @Nullable
    public final String c() {
        Object obj;
        PBRepeatMessageField<FeedCloudPubGuideSvr$GuideResource> pBRepeatMessageField;
        List<FeedCloudPubGuideSvr$GuideResource> list;
        Object firstOrNull;
        PBStringField pBStringField;
        Iterator<T> it = this.infoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                boolean z16 = true;
                if (((FeedCloudPubGuideSvr$ResourceInfo) obj).resource_type.get() != 1) {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudPubGuideSvr$ResourceInfo feedCloudPubGuideSvr$ResourceInfo = (FeedCloudPubGuideSvr$ResourceInfo) obj;
        if (feedCloudPubGuideSvr$ResourceInfo != null && (pBRepeatMessageField = feedCloudPubGuideSvr$ResourceInfo.guide_resources) != null && (list = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            FeedCloudPubGuideSvr$GuideResource feedCloudPubGuideSvr$GuideResource = (FeedCloudPubGuideSvr$GuideResource) firstOrNull;
            if (feedCloudPubGuideSvr$GuideResource == null || (pBStringField = feedCloudPubGuideSvr$GuideResource.thumbnail_img) == null) {
                return null;
            }
            return pBStringField.get();
        }
        return null;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlusMenuServerData)) {
            return false;
        }
        PlusMenuServerData plusMenuServerData = (PlusMenuServerData) other;
        if (Intrinsics.areEqual(this.infoList, plusMenuServerData.infoList) && this.showNewerTeachGuide == plusMenuServerData.showNewerTeachGuide) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.infoList.hashCode() * 31;
        boolean z16 = this.showNewerTeachGuide;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "PlusMenuServerData(infoList=" + this.infoList + ", showNewerTeachGuide=" + this.showNewerTeachGuide + ")";
    }
}
