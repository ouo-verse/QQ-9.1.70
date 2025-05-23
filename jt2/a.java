package jt2;

import android.app.Activity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.TroopBindGuildItemAdapter;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.g;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.h;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kt2.TroopBindGuildLFooterData;
import kt2.TroopBindGuildLTitleData;
import kt2.d;
import lt2.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Ljt2/a;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lkt2/a;", "", "i0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "list", "setData", "", "isLoadingMore", "j0", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Llt2/c;", BdhLogUtil.LogTag.Tag_Conn, "Llt2/c;", "getViewModel", "()Llt2/c;", "viewModel", "Lkt2/e;", "D", "Lkt2/e;", "displayTipsData", "E", "selectTipsData", "Lkt2/b;", UserInfo.SEX_FEMALE, "Lkt2/b;", "emptyTipsData", "Lkt2/c;", "G", "Lkt2/c;", "loadingFooterData", "<init>", "(Landroid/app/Activity;Llt2/c;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends AsyncListDifferDelegationAdapter<kt2.a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TroopBindGuildLTitleData displayTipsData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TroopBindGuildLTitleData selectTipsData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final kt2.b emptyTipsData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TroopBindGuildLFooterData loadingFooterData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Activity activity, @NotNull c viewModel) {
        super(new b());
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.activity = activity;
        this.viewModel = viewModel;
        this.displayTipsData = new TroopBindGuildLTitleData(0, false);
        this.selectTipsData = new TroopBindGuildLTitleData(1, false);
        this.emptyTipsData = new kt2.b(true);
        this.loadingFooterData = new TroopBindGuildLFooterData(false);
        this.delegatesManager.addDelegate(new h(activity, viewModel)).addDelegate(new g(activity)).addDelegate(new TroopBindGuildItemAdapter(activity, viewModel)).addDelegate(new com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.a(activity, viewModel)).addDelegate(new com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter.b(activity));
        i0();
    }

    private final void i0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.displayTipsData);
        arrayList.add(new d(true, null, false, 4, null));
        arrayList.add(this.selectTipsData);
        setItems(arrayList);
    }

    public final void j0(boolean isLoadingMore) {
        List mutableList;
        List mutableList2;
        if (isLoadingMore) {
            this.loadingFooterData.d(true);
            List currentList = this.differ.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "differ.currentList");
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) currentList);
            mutableList2.add(this.loadingFooterData);
        } else {
            List currentList2 = this.differ.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList2, "differ.currentList");
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) currentList2);
            mutableList.remove(this.loadingFooterData);
        }
        setItems(this.differ.getCurrentList());
    }

    public final void setData(@NotNull List<AIOBindGuildInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        d dVar = new d(true, this.viewModel.getCurDisplayedGuild(), false, 4, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.displayTipsData);
        arrayList.add(dVar);
        if (list.isEmpty()) {
            arrayList.add(this.emptyTipsData);
        } else {
            arrayList.add(this.selectTipsData);
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                AIOBindGuildInfo aIOBindGuildInfo = (AIOBindGuildInfo) obj;
                boolean z16 = true;
                if (i3 != list.size() - 1) {
                    z16 = false;
                }
                arrayList.add(new d(false, aIOBindGuildInfo, z16));
                i3 = i16;
            }
        }
        setItems(arrayList);
    }
}
