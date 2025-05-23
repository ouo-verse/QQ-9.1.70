package com.qzone.reborn.intimate.bean.init;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateWriteMoodInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "adId", "", "getAdId", "()Ljava/lang/String;", "setAdId", "(Ljava/lang/String;)V", "filePathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFilePathList", "()Ljava/util/ArrayList;", "setFilePathList", "(Ljava/util/ArrayList;)V", "insertSpacePage", "", "getInsertSpacePage", "()I", "setInsertSpacePage", "(I)V", "spaceId", "getSpaceId", "setSpaceId", "spaceType", "getSpaceType", "setSpaceType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateWriteMoodInitBean extends QZoneIntimateInitBean {
    private int insertSpacePage;
    private int spaceType;
    private String spaceId = "";
    private String adId = "";
    private ArrayList<String> filePathList = new ArrayList<>();

    public final String getAdId() {
        return this.adId;
    }

    public final ArrayList<String> getFilePathList() {
        return this.filePathList;
    }

    public final int getInsertSpacePage() {
        return this.insertSpacePage;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final void setAdId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void setFilePathList(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.filePathList = arrayList;
    }

    public final void setInsertSpacePage(int i3) {
        this.insertSpacePage = i3;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }
}
