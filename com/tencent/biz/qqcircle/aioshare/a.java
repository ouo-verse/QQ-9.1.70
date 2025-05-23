package com.tencent.biz.qqcircle.aioshare;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOCollectedFeedFragment;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOPraisedFeedFragment;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOProductFeedFragment;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOPushedFeedFragment;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOWatchedFeedFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l20.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mIndexPraised", BdhLogUtil.LogTag.Tag_Conn, "mIndexPushed", "D", "mIndexCollected", "E", "mIndexProduct", UserInfo.SEX_FEMALE, "mIndexWatched", "G", "mItemCount", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    private int mIndexPushed;

    /* renamed from: D, reason: from kotlin metadata */
    private int mIndexCollected;

    /* renamed from: E, reason: from kotlin metadata */
    private int mIndexProduct;

    /* renamed from: F, reason: from kotlin metadata */
    private int mIndexWatched;

    /* renamed from: G, reason: from kotlin metadata */
    private int mItemCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mIndexPraised;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mIndexPraised = -1;
        this.mIndexPushed = -1;
        this.mIndexCollected = -1;
        this.mIndexProduct = -1;
        this.mIndexWatched = -1;
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            this.mItemCount = e.INSTANCE.b().length;
            this.mIndexPraised = 0;
            this.mIndexCollected = 1;
            this.mIndexWatched = 2;
            return;
        }
        this.mItemCount = e.INSTANCE.a().length;
        this.mIndexPraised = 0;
        this.mIndexPushed = 1;
        this.mIndexCollected = 2;
        this.mIndexProduct = 3;
        this.mIndexWatched = 4;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        if (position == this.mIndexPraised) {
            return new QFSAIOPraisedFeedFragment();
        }
        if (position == this.mIndexPushed) {
            return new QFSAIOPushedFeedFragment();
        }
        if (position == this.mIndexCollected) {
            return new QFSAIOCollectedFeedFragment();
        }
        if (position == this.mIndexProduct) {
            return new QFSAIOProductFeedFragment();
        }
        return new QFSAIOWatchedFeedFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return e.INSTANCE.b().length;
        }
        return e.INSTANCE.a().length;
    }
}
