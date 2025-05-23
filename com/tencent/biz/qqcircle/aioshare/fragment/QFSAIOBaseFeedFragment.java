package com.tencent.biz.qqcircle.aioshare.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aioshare.QFSAIOSendDataManager;
import com.tencent.biz.qqcircle.aioshare.fragment.QFSAIOBaseFeedFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSCheckBoxStatus;
import com.tencent.biz.qqcircle.immersive.personal.bean.e;
import com.tencent.biz.qqcircle.immersive.personal.part.y;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.f;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000 W2\u00020\u0001:\u0001XB\u000f\u0012\u0006\u00108\u001a\u00020\r\u00a2\u0006\u0004\bV\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u0002*\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u000fH\u0004J\b\u0010\u001a\u001a\u00020\u0019H\u0016J$\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0004J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH&J\b\u0010#\u001a\u00020\u0002H\u0014J\u001c\u0010'\u001a\u00020\u00022\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u000f0$H\u0004J\u001c\u0010)\u001a\u00020\u00022\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u000f0$H\u0004J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0004J\b\u0010/\u001a\u00020\u0002H&J\b\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020\u0002H\u0016R\"\u00108\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u0002098\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010O\u001a\u00020\u00198\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020!8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b3\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006Y"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/fragment/QFSAIOBaseFeedFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "Kh", "Gh", "Jh", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/a;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "selectFeedList", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/e;", QCircleScheme.AttrDetail.FEED_INFO, "Sh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "Nh", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/QFSPersonalFeedBaseAdapter;", "wh", "position", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "itemView", "vh", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "iPartHost", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;", "xh", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "Le30/b;", "listUIStateData", "Th", "uiStateData", "Fh", "", "errorMsg", "", "retCode", "Eh", "Dh", "getPageId", "registerDaTongReportPageId", "E", "I", "Ch", "()I", "setMSourceType", "(I)V", "mSourceType", "Lcom/tencent/biz/richframework/part/BlockPart;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/richframework/part/BlockPart;", OcrConfig.CHINESE, "()Lcom/tencent/biz/richframework/part/BlockPart;", "Ph", "(Lcom/tencent/biz/richframework/part/BlockPart;)V", "mBlockPart", "Lcom/tencent/biz/qqcircle/immersive/personal/part/y;", "G", "Lcom/tencent/biz/qqcircle/immersive/personal/part/y;", "Bh", "()Lcom/tencent/biz/qqcircle/immersive/personal/part/y;", "Rh", "(Lcom/tencent/biz/qqcircle/immersive/personal/part/y;)V", "mHintViewPart", "H", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/QFSPersonalFeedBaseAdapter;", "yh", "()Lcom/tencent/biz/qqcircle/immersive/personal/adapter/QFSPersonalFeedBaseAdapter;", "Oh", "(Lcom/tencent/biz/qqcircle/immersive/personal/adapter/QFSPersonalFeedBaseAdapter;)V", "mAIOFeedAdapter", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;", "Ah", "()Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;", "Qh", "(Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/f;)V", "mFeedViewModel", "<init>", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSAIOBaseFeedFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    private int mSourceType;

    /* renamed from: F, reason: from kotlin metadata */
    protected BlockPart mBlockPart;

    /* renamed from: G, reason: from kotlin metadata */
    protected y mHintViewPart;

    /* renamed from: H, reason: from kotlin metadata */
    protected QFSPersonalFeedBaseAdapter mAIOFeedAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    protected f mFeedViewModel;

    public QFSAIOBaseFeedFragment(int i3) {
        this.mSourceType = i3;
    }

    private final void Gh() {
        yh().setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: k20.c
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSAIOBaseFeedFragment.Hh(QFSAIOBaseFeedFragment.this, loadInfo, (QFSPersonalFeedBaseAdapter) obj);
            }
        });
        yh().p0(new QFSPersonalFeedBaseAdapter.b() { // from class: k20.d
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.b
            public final void a(int i3, e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSAIOBaseFeedFragment.Ih(QFSAIOBaseFeedFragment.this, i3, eVar, qCircleBaseWidgetView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(QFSAIOBaseFeedFragment this$0, LoadInfo loadInfo, QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadInfo.isLoadMoreState()) {
            this$0.Ah().S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(QFSAIOBaseFeedFragment this$0, int i3, e feedInfo, QCircleBaseWidgetView itemView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(feedInfo, "feedInfo");
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this$0.vh(i3, feedInfo, itemView);
    }

    private final void Jh() {
        zh().getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        zh().getBlockContainer().setEnableRefresh(false);
        zh().getBlockContainer().setEnableLoadMore(true);
        zh().getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        zh().getBlockContainer().getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(requireContext()));
    }

    private final void Kh() {
        QFSAIOSendDataManager.f82679a.c().observe(this, new Observer() { // from class: k20.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAIOBaseFeedFragment.Lh(QFSAIOBaseFeedFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(QFSAIOBaseFeedFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            List<e> dataList = this$0.yh().getDataList();
            Intrinsics.checkNotNullExpressionValue(dataList, "mAIOFeedAdapter.dataList");
            for (e it : dataList) {
                QFSCheckBoxStatus qFSCheckBoxStatus = it.f88465d;
                if (qFSCheckBoxStatus != null) {
                    Intrinsics.checkNotNullExpressionValue(qFSCheckBoxStatus, "initSelectFeedObserver$l\u2026ambda$2$lambda$1$lambda$0");
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this$0.Sh(qFSCheckBoxStatus, list, it);
                }
            }
            this$0.yh().n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(QFSAIOBaseFeedFragment this$0, UIStateData listUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(listUIStateData, "listUIStateData");
        this$0.Th(listUIStateData);
    }

    private final void Sh(QFSCheckBoxStatus qFSCheckBoxStatus, List<FeedCloudMeta$StFeed> list, e eVar) {
        boolean z16;
        if (list != null) {
            int i3 = 0;
            qFSCheckBoxStatus.g(false);
            qFSCheckBoxStatus.f(-1);
            if (list.size() < 9) {
                z16 = true;
            } else {
                z16 = false;
            }
            qFSCheckBoxStatus.e(z16);
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(eVar.d(), ((FeedCloudMeta$StFeed) obj).f398449id.get())) {
                    qFSCheckBoxStatus.g(true);
                    qFSCheckBoxStatus.e(true);
                    qFSCheckBoxStatus.f(i16);
                    QFSAIOSendDataManager qFSAIOSendDataManager = QFSAIOSendDataManager.f82679a;
                    int i17 = this.mSourceType;
                    String d16 = eVar.d();
                    Intrinsics.checkNotNullExpressionValue(d16, "feedInfo.feedId");
                    qFSAIOSendDataManager.a(i17, d16);
                }
                i3 = i16;
            }
        }
    }

    @NotNull
    protected final f Ah() {
        f fVar = this.mFeedViewModel;
        if (fVar != null) {
            return fVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final y Bh() {
        y yVar = this.mHintViewPart;
        if (yVar != null) {
            return yVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHintViewPart");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Ch, reason: from getter */
    public final int getMSourceType() {
        return this.mSourceType;
    }

    public abstract void Dh();

    protected final void Eh(@NotNull String errorMsg, long retCode) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.i(getTAG(), 1, "[handleError] -> errorMsg = " + errorMsg);
        Bh().P9(errorMsg, retCode);
    }

    protected final void Fh(@NotNull UIStateData<List<b>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        QLog.i(getTAG(), 1, "[handleSuccess] -> uiStateData = " + uiStateData);
        if (uiStateData.getData() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : uiStateData.getData()) {
            if (!QCirclePluginUtil.isPrivateFeed(bVar.g())) {
                e eVar = new e(bVar);
                QFSCheckBoxStatus qFSCheckBoxStatus = new QFSCheckBoxStatus(true, false, false, 0, 14, null);
                Sh(qFSCheckBoxStatus, QFSAIOSendDataManager.f82679a.c().getValue(), eVar);
                eVar.f88465d = qFSCheckBoxStatus;
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            Dh();
        } else {
            yh().setDatas(arrayList);
            Bh().E9();
        }
    }

    @NotNull
    protected final List<MultiViewBlock<?>> Nh() {
        Oh(wh());
        Gh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(yh());
        return arrayList;
    }

    protected final void Oh(@NotNull QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter) {
        Intrinsics.checkNotNullParameter(qFSPersonalFeedBaseAdapter, "<set-?>");
        this.mAIOFeedAdapter = qFSPersonalFeedBaseAdapter;
    }

    protected final void Ph(@NotNull BlockPart blockPart) {
        Intrinsics.checkNotNullParameter(blockPart, "<set-?>");
        this.mBlockPart = blockPart;
    }

    protected final void Qh(@NotNull f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<set-?>");
        this.mFeedViewModel = fVar;
    }

    protected final void Rh(@NotNull y yVar) {
        Intrinsics.checkNotNullParameter(yVar, "<set-?>");
        this.mHintViewPart = yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void Th(@NotNull UIStateData<List<b>> listUIStateData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
        boolean isFinish = listUIStateData.getIsFinish();
        int state = listUIStateData.getState();
        int i3 = 0;
        if (state != 0) {
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state == 4) {
                            String msg2 = listUIStateData.getMsg();
                            Intrinsics.checkNotNullExpressionValue(msg2, "listUIStateData.msg");
                            Eh(msg2, listUIStateData.getRetCode());
                        }
                    } else {
                        Fh(listUIStateData);
                    }
                } else {
                    Fh(listUIStateData);
                }
            }
            z16 = false;
            yh().getLoadInfo().setFinish(isFinish);
            if (z16) {
                yh().notifyLoadingComplete(true, isFinish);
            }
            String tag = getTAG();
            int state2 = listUIStateData.getState();
            boolean isLoadMore = listUIStateData.getIsLoadMore();
            if (listUIStateData.getData() != null) {
                i3 = listUIStateData.getData().size();
            }
            QLog.i(tag, 1, "[updateData] -> state = " + state2 + ",isLoadMore = " + isLoadMore + ",isLoadingComplete = " + z16 + ",isFinish = " + isFinish + ",dataSize = " + i3);
        }
        Dh();
        z16 = true;
        yh().getLoadInfo().setFinish(isFinish);
        if (z16) {
        }
        String tag2 = getTAG();
        int state22 = listUIStateData.getState();
        boolean isLoadMore2 = listUIStateData.getIsLoadMore();
        if (listUIStateData.getData() != null) {
        }
        QLog.i(tag2, 1, "[updateData] -> state = " + state22 + ",isLoadMore = " + isLoadMore2 + ",isLoadingComplete = " + z16 + ",isFinish = " + isFinish + ",dataSize = " + i3);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        Ph(new BlockPart(R.id.vfs, Nh(), 2, 3));
        arrayList.add(zh());
        Rh(new y());
        Bh().K9(true);
        arrayList.add(Bh());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g7t;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    protected void initViewModel() {
        QLog.i(getTAG(), 1, "[initViewModel] getParentFragment() = " + getParentFragment());
        if (!(getParentFragment() instanceof IPartHost)) {
            return;
        }
        ActivityResultCaller parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.biz.richframework.part.interfaces.IPartHost");
        Qh(xh((IPartHost) parentFragment));
        Ah().setUin(r.q());
        Ah().Q1().observe(this, new Observer() { // from class: k20.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAIOBaseFeedFragment.Mh(QFSAIOBaseFeedFragment.this, (UIStateData) obj);
            }
        });
        Ah().U1(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        Jh();
        Kh();
        initViewModel();
    }

    protected final void vh(int position, @NotNull e feedInfo, @NotNull QCircleBaseWidgetView<?> itemView) {
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        QFSCheckBoxStatus qFSCheckBoxStatus = feedInfo.f88465d;
        if (qFSCheckBoxStatus != null) {
            QFSAIOSendDataManager qFSAIOSendDataManager = QFSAIOSendDataManager.f82679a;
            List<FeedCloudMeta$StFeed> value = qFSAIOSendDataManager.c().getValue();
            if (value != null && value.size() >= 9 && !qFSCheckBoxStatus.getSelected()) {
                QQToast.makeText(getContext(), RFWApplication.getApplication().getString(R.string.f1916845g, 9), 0).show();
                return;
            }
            FeedCloudMeta$StFeed b16 = feedInfo.b();
            Intrinsics.checkNotNullExpressionValue(b16, "feedInfo.feed");
            qFSAIOSendDataManager.e(b16, !qFSCheckBoxStatus.getSelected());
        }
    }

    @NotNull
    public QFSPersonalFeedBaseAdapter wh() {
        return new QFSPersonalFeedBaseAdapter(getArguments());
    }

    @NotNull
    public abstract f xh(@NotNull IPartHost iPartHost);

    @NotNull
    protected final QFSPersonalFeedBaseAdapter yh() {
        QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter = this.mAIOFeedAdapter;
        if (qFSPersonalFeedBaseAdapter != null) {
            return qFSPersonalFeedBaseAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAIOFeedAdapter");
        return null;
    }

    @NotNull
    protected final BlockPart zh() {
        BlockPart blockPart = this.mBlockPart;
        if (blockPart != null) {
            return blockPart;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBlockPart");
        return null;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
