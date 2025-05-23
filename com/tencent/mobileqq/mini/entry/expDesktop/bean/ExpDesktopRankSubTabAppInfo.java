package com.tencent.mobileqq.mini.entry.expDesktop.bean;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\t\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tJ\u0006\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010\u0017\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tJ\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u001d\u001a\u00020\u001b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "title", "", "moduleType", "", "rankAppInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "via", "hostScene", "isFinished", "", "(Ljava/lang/String;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V", "mHostScene", "mIsFinished", "mRankAppInfo", "mTitle", "mVia", "getHostScene", "getIsFinished", "getRankAppInfo", "getTitle", "getVia", "getViewType", "setHostScene", "", "setIsFinished", "setVia", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopRankSubTabAppInfo extends DesktopItemInfo {
    private ArrayList<String> mHostScene;
    private boolean mIsFinished;
    private ArrayList<DesktopAppInfo> mRankAppInfo;
    private String mTitle;
    private ArrayList<String> mVia;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ExpDesktopRankSubTabAppInfo(String str, int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, arrayList, r6, r7, (i16 & 32) != 0 ? false : z16);
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        if ((i16 & 8) != 0) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("", "");
            arrayList4 = arrayListOf2;
        } else {
            arrayList4 = arrayList2;
        }
        if ((i16 & 16) != 0) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
            arrayList5 = arrayListOf;
        } else {
            arrayList5 = arrayList3;
        }
    }

    public final ArrayList<String> getHostScene() {
        return this.mHostScene;
    }

    /* renamed from: getIsFinished, reason: from getter */
    public final boolean getMIsFinished() {
        return this.mIsFinished;
    }

    public final ArrayList<DesktopAppInfo> getRankAppInfo() {
        return this.mRankAppInfo;
    }

    /* renamed from: getTitle, reason: from getter */
    public final String getMTitle() {
        return this.mTitle;
    }

    public final ArrayList<String> getVia() {
        return this.mVia;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 6;
    }

    public final void setHostScene(ArrayList<String> hostScene) {
        Intrinsics.checkNotNullParameter(hostScene, "hostScene");
        this.mHostScene = hostScene;
    }

    public final void setIsFinished(boolean isFinished) {
        this.mIsFinished = isFinished;
    }

    public final void setVia(ArrayList<String> via) {
        Intrinsics.checkNotNullParameter(via, "via");
        this.mVia = via;
    }

    public ExpDesktopRankSubTabAppInfo(String title, int i3, ArrayList<DesktopAppInfo> rankAppInfo, ArrayList<String> via, ArrayList<String> hostScene, boolean z16) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(rankAppInfo, "rankAppInfo");
        Intrinsics.checkNotNullParameter(via, "via");
        Intrinsics.checkNotNullParameter(hostScene, "hostScene");
        this.mTitle = "";
        this.mRankAppInfo = new ArrayList<>();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mVia = arrayListOf;
        CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mTitle = title;
        this.mModuleType = i3;
        this.mRankAppInfo = rankAppInfo;
        this.mVia = via;
        this.mHostScene = hostScene;
        this.mIsFinished = z16;
    }
}
