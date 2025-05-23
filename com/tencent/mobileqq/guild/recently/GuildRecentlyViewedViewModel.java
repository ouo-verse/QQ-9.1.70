package com.tencent.mobileqq.guild.recently;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.feed.GuildFeedViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIndexFeedItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIndexFeedParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecentViewedData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedViewModel;", "Lcom/tencent/mobileqq/guild/feed/GuildFeedViewModel;", "", "w2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexRsp;", "rsp", ICustomDataEditor.STRING_PARAM_2, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Lkotlin/collections/ArrayList;", "q2", QCircleLpReportDc05507.KEY_CLEAR, "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecentViewedData;", "x2", "", "P", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/ArrayList;", "mRecentViewedDataList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRecentlyViewedViewModel extends GuildFeedViewModel {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GProRecentViewedData> mRecentViewedDataList;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildRecentlyViewedViewModel() {
        super(r0);
        GProGetFeedsByIndexReq gProGetFeedsByIndexReq = new GProGetFeedsByIndexReq();
        gProGetFeedsByIndexReq.indexType = 4;
        gProGetFeedsByIndexReq.indexParam = new GProIndexFeedParam();
        this.tag = "GuildRecentlyViewedViewModel";
        this.mRecentViewedDataList = new ArrayList<>();
    }

    private final void w2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1(null), 2, null);
    }

    public final void clear() {
        S1().clear();
        this.mRecentViewedDataList.clear();
        b2();
        w2();
    }

    @Override // com.tencent.mobileqq.guild.feed.GuildFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    @NotNull
    public String getTag() {
        return this.tag;
    }

    @Override // com.tencent.mobileqq.guild.feed.GuildFeedViewModel
    @NotNull
    public ArrayList<com.tencent.mobileqq.guild.discoveryv2.content.base.h> q2(@NotNull GProGetFeedsByIndexRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ArrayList<GProIndexFeedItem> arrayList = rsp.indexItems;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.indexItems");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            this.mRecentViewedDataList.add(((GProIndexFeedItem) it.next()).recentViewData);
        }
        return super.q2(rsp);
    }

    @Override // com.tencent.mobileqq.guild.feed.GuildFeedViewModel
    public void s2(@NotNull GProGetFeedsByIndexRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mRecentViewedDataList.clear();
        ArrayList<GProIndexFeedItem> arrayList = rsp.indexItems;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.indexItems");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            this.mRecentViewedDataList.add(((GProIndexFeedItem) it.next()).recentViewData);
        }
        super.s2(rsp);
        if (rsp.indexItems.size() < 12 && !rsp.isEnd) {
            QLog.i("GuildRecentlyViewedViewModel", 1, "loadMore size=" + rsp.indexItems.size() + " ");
            B(new LoadMoreArgs(LoadMoreType.TYPE_PRE_LOAD_MORE, "GuildRecentlyViewedViewModel"));
        }
    }

    @NotNull
    public final List<GProRecentViewedData> x2() {
        return this.mRecentViewedDataList;
    }
}
