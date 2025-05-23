package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "", "title", "", HippyHeaderListViewController.VIEW_TAG, "specialTag", "Lcom/tencent/biz/qui/quitagview/QUITagType;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/biz/qui/quitagview/QUITagType;)V", "getSpecialTag", "()Lcom/tencent/biz/qui/quitagview/QUITagType;", "getTitle", "()Ljava/lang/String;", "getViewTag", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class MiniAppTagInfo {
    private final QUITagType specialTag;
    private final String title;
    private final Object viewTag;

    public MiniAppTagInfo(String title, Object obj, QUITagType qUITagType) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.viewTag = obj;
        this.specialTag = qUITagType;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getViewTag() {
        return this.viewTag;
    }

    /* renamed from: component3, reason: from getter */
    public final QUITagType getSpecialTag() {
        return this.specialTag;
    }

    public final MiniAppTagInfo copy(String title, Object viewTag, QUITagType specialTag) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new MiniAppTagInfo(title, viewTag, specialTag);
    }

    public final QUITagType getSpecialTag() {
        return this.specialTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Object getViewTag() {
        return this.viewTag;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        Object obj = this.viewTag;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        QUITagType qUITagType = this.specialTag;
        return hashCode2 + (qUITagType != null ? qUITagType.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppTagInfo(title=" + this.title + ", viewTag=" + this.viewTag + ", specialTag=" + this.specialTag + ")";
    }

    public /* synthetic */ MiniAppTagInfo(String str, Object obj, QUITagType qUITagType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i3 & 4) != 0 ? null : qUITagType);
    }

    public static /* synthetic */ MiniAppTagInfo copy$default(MiniAppTagInfo miniAppTagInfo, String str, Object obj, QUITagType qUITagType, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            str = miniAppTagInfo.title;
        }
        if ((i3 & 2) != 0) {
            obj = miniAppTagInfo.viewTag;
        }
        if ((i3 & 4) != 0) {
            qUITagType = miniAppTagInfo.specialTag;
        }
        return miniAppTagInfo.copy(str, obj, qUITagType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniAppTagInfo)) {
            return false;
        }
        MiniAppTagInfo miniAppTagInfo = (MiniAppTagInfo) other;
        return Intrinsics.areEqual(this.title, miniAppTagInfo.title) && Intrinsics.areEqual(this.viewTag, miniAppTagInfo.viewTag) && this.specialTag == miniAppTagInfo.specialTag;
    }
}
