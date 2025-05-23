package com.tencent.mobileqq.guild.forward.guildselector;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Q1", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "P1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/forward/guildselector/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_pageDataLiveData", "", "Lcom/tencent/mobileqq/guild/forward/guildselector/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "recentShareGuilds", BdhLogUtil.LogTag.Tag_Conn, "allGuilds", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "pageDataLiveData", "<init>", "()V", "D", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildSelectorViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<a>> _pageDataLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<GuildData> recentShareGuilds = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final List<GuildData> allGuilds = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1() {
        ArrayList arrayList = new ArrayList();
        if (!this.recentShareGuilds.isEmpty()) {
            arrayList.add(new SpaceData(wr0.a.f446116a.a(12.0f)));
            arrayList.add(new TitleData("\u6700\u8fd1\u8f6c\u53d1"));
            Iterator<T> it = this.recentShareGuilds.iterator();
            while (it.hasNext()) {
                arrayList.add((GuildData) it.next());
            }
        }
        arrayList.add(new SpaceData(wr0.a.f446116a.a(12.0f)));
        arrayList.add(new TitleData("\u5168\u90e8\u9891\u9053"));
        Iterator<T> it5 = this.allGuilds.iterator();
        while (it5.hasNext()) {
            arrayList.add((GuildData) it5.next());
        }
        this._pageDataLiveData.setValue(arrayList);
    }

    public final LiveData<List<a>> O1() {
        return this._pageDataLiveData;
    }

    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b P1() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildSelectorViewModel initData", null, null, Boolean.TRUE, new GuildSelectorViewModel$initData$1(this, null), 6, null);
    }
}
