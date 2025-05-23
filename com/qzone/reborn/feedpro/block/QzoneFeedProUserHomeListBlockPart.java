package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedpro.viewmodel.b;
import com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.MainPageControl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 h2\u00020\u0001:\u0001iB#\u0012\u0006\u0010c\u001a\u00020\u0002\u0012\u0012\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010d0\t\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J$\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u000e\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010.H\u0014J\b\u00100\u001a\u00020\u0002H\u0016R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010a\u00a8\u0006j"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart;", "Lcom/qzone/reborn/feedpro/block/d;", "", "headerState", "", "qa", "na", "pa", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "listUIStateData", "ba", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "rsp", "ca", "da", "", "errorMsg", "aa", "ha", "", "isVisible", "ga", "isFinish", "ea", "oa", "getLogTag", "P9", "Landroid/view/View;", "mRootView", "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "onRefreshListener", "Y9", "Lvd/b;", "G9", "E9", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "f", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "mLoadMoreUpBlock", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", tl.h.F, "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "mFeedOnlySelfBlock", "Lcom/qzone/reborn/feedpro/block/r;", "i", "Lcom/qzone/reborn/feedpro/block/r;", "mHeaderBlock", "Lcom/qzone/reborn/feedpro/block/t;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/block/t;", "mFeedListAdapter", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView;", "mRefreshHeader", "Lcom/qzone/reborn/feedpro/block/af;", "D", "Lcom/qzone/reborn/feedpro/block/af;", "questionBlock", "Lcom/qzone/reborn/feedpro/block/ae;", "E", "Lcom/qzone/reborn/feedpro/block/ae;", "mEmptyPageBlock", "Lcom/qzone/reborn/feedpro/viewmodel/m;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedpro/block/j;", "G", "Lcom/qzone/reborn/feedpro/block/j;", "mFeedCountBlock", "H", "Z", "mIsItemDecorationSetup", "Lcom/qzone/reborn/feedx/widget/g;", "I", "Lcom/qzone/reborn/feedx/widget/g;", "mDividerView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "mShadowMask", "Z9", "()I", "dividerBgColor", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeListBlockPart extends d {
    private static final int L = ImmersiveUtils.dpToPx(90.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProRefreshHeaderView mRefreshHeader;

    /* renamed from: D, reason: from kotlin metadata */
    private af questionBlock;

    /* renamed from: E, reason: from kotlin metadata */
    private ae mEmptyPageBlock;

    /* renamed from: F, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mUserHomeViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private j mFeedCountBlock;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    /* renamed from: I, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.widget.g mDividerView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mShadowMask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProLoadMoreUpBlock mLoadMoreUpBlock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProFeedOnlySelfBlock mFeedOnlySelfBlock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private r mHeaderBlock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private t mFeedListAdapter;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/block/QzoneFeedProUserHomeListBlockPart$b", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "", "offSet", "sumOffSet", "", "a", "", "onRelease", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneFeedxRefreshView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.feedpro.viewmodel.n f53876a;

        b(com.qzone.reborn.feedpro.viewmodel.n nVar) {
            this.f53876a = nVar;
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public boolean a(float offSet, float sumOffSet) {
            return this.f53876a.O1(offSet, sumOffSet);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            this.f53876a.P1();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeListBlockPart(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (this.mFeedListAdapter != null && this.mEmptyPageBlock != null) {
                return;
            }
            if (multiViewBlock instanceof t) {
                t tVar = (t) multiViewBlock;
                this.mFeedListAdapter = tVar;
                if (tVar != null) {
                    tVar.setHasStableIds(true);
                }
            } else if (multiViewBlock instanceof af) {
                this.questionBlock = (af) multiViewBlock;
            } else if (multiViewBlock instanceof ae) {
                this.mEmptyPageBlock = (ae) multiViewBlock;
            } else if (multiViewBlock instanceof r) {
                this.mHeaderBlock = (r) multiViewBlock;
            } else if (multiViewBlock instanceof QzoneFeedProLoadMoreUpBlock) {
                this.mLoadMoreUpBlock = (QzoneFeedProLoadMoreUpBlock) multiViewBlock;
            } else if (multiViewBlock instanceof QzoneFeedProFeedOnlySelfBlock) {
                this.mFeedOnlySelfBlock = (QzoneFeedProFeedOnlySelfBlock) multiViewBlock;
            } else if (multiViewBlock instanceof j) {
                this.mFeedCountBlock = (j) multiViewBlock;
            }
        }
    }

    private final int Z9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private final void aa(String errorMsg) {
        MutableLiveData<Boolean> o26;
        List<CommonFeed> dataList;
        t tVar = this.mFeedListAdapter;
        boolean z16 = false;
        if (!((tVar == null || (dataList = tVar.getDataList()) == null || !(dataList.isEmpty() ^ true)) ? false : true) && com.qzone.reborn.feedpro.utils.p.u(errorMsg)) {
            com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
            boolean m26 = mVar != null ? mVar.m2() : false;
            com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
            if (mVar2 != null && mVar2.q2()) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
            if (mVar3 != null && (o26 = mVar3.o2()) != null) {
                o26.postValue(Boolean.TRUE);
            }
            ae aeVar = this.mEmptyPageBlock;
            if (aeVar != null) {
                wd.e eVar = new wd.e();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                eVar.d(com.qzone.reborn.feedpro.utils.p.e(context, m26));
                eVar.e(true);
                aeVar.n0(eVar);
            }
            ae aeVar2 = this.mEmptyPageBlock;
            if (aeVar2 != null) {
                aeVar2.setBlockVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(GetMainPageHeadRsp rsp) {
        da(rsp);
    }

    private final void da(GetMainPageHeadRsp rsp) {
        t tVar;
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        UIStateData<List<CommonFeed>> value;
        List<CommonFeed> dataList;
        MutableLiveData<Boolean> p26;
        MutableLiveData<Boolean> p27;
        MainPageControl mainPageControl = rsp.mainPageControl;
        if (mainPageControl == null) {
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        List<CommonFeed> list = null;
        if (((mVar == null || mVar.m2()) ? false : true) && com.qzone.reborn.feedpro.utils.p.q(mainPageControl)) {
            com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
            if (mVar2 != null && (p27 = mVar2.p2()) != null) {
                p27.postValue(Boolean.TRUE);
            }
            t tVar2 = this.mFeedListAdapter;
            if (tVar2 != null) {
                tVar2.clearData();
            }
            j jVar = this.mFeedCountBlock;
            if (jVar != null) {
                jVar.setBlockVisible(false);
            }
            if (com.qzone.reborn.feedpro.utils.p.t(mainPageControl)) {
                af afVar = this.questionBlock;
                if (afVar != null) {
                    afVar.setBlockVisible(true);
                }
                af afVar2 = this.questionBlock;
                if (afVar2 != null) {
                    afVar2.m0(mainPageControl.questions);
                }
            } else {
                af afVar3 = this.questionBlock;
                if (afVar3 != null) {
                    afVar3.setBlockVisible(false);
                }
                af afVar4 = this.questionBlock;
                if (afVar4 != null) {
                    afVar4.m0(null);
                }
            }
            ae aeVar = this.mEmptyPageBlock;
            if (aeVar != null) {
                aeVar.setBlockVisible(true);
            }
            ae aeVar2 = this.mEmptyPageBlock;
            if (aeVar2 != null) {
                wd.g gVar = new wd.g();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                gVar.e(com.qzone.reborn.feedpro.utils.p.g(mainPageControl, context, mainPageControl.msg, mainPageControl.summary));
                gVar.f(false);
                gVar.g(com.qzone.reborn.feedpro.utils.p.t(mainPageControl));
                gVar.h(com.qzone.reborn.feedpro.utils.p.s(mainPageControl));
                aeVar2.o0(gVar);
                return;
            }
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
        if (mVar3 != null && (p26 = mVar3.p2()) != null) {
            p26.postValue(Boolean.FALSE);
        }
        j jVar2 = this.mFeedCountBlock;
        if (jVar2 != null) {
            jVar2.setBlockVisible(true);
        }
        t tVar3 = this.mFeedListAdapter;
        if (((tVar3 == null || (dataList = tVar3.getDataList()) == null || !dataList.isEmpty()) ? false : true) && (tVar = this.mFeedListAdapter) != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar4 = this.mUserHomeViewModel;
            if (mVar4 != null && (N1 = mVar4.N1()) != null && (value = N1.getValue()) != null) {
                list = value.getData();
            }
            tVar.setDatas(list);
        }
        af afVar5 = this.questionBlock;
        if (afVar5 != null) {
            afVar5.setBlockVisible(false);
        }
        ae aeVar3 = this.mEmptyPageBlock;
        if (aeVar3 != null) {
            aeVar3.setBlockVisible(false);
        }
    }

    private final void ea(UIStateData<List<CommonFeed>> listUIStateData, boolean isFinish) {
        Object lastOrNull;
        t tVar;
        if (listUIStateData.getData() != null && isFinish) {
            List<CommonFeed> data = listUIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) data);
            CommonFeed commonFeed = (CommonFeed) lastOrNull;
            boolean z16 = false;
            if (commonFeed != null && !CommonFeedExtKt.isMemorySealFeed(commonFeed)) {
                z16 = true;
            }
            if (z16 || (tVar = this.mFeedListAdapter) == null) {
                return;
            }
            Intrinsics.checkNotNull(tVar);
            if (tVar.getBlockMerger() == null) {
                return;
            }
            ImageView imageView = new ImageView(getContext());
            t tVar2 = this.mFeedListAdapter;
            Intrinsics.checkNotNull(tVar2);
            tVar2.getBlockMerger().setCustomNoMoreDataView(imageView);
        }
    }

    private final void ga(boolean isVisible) {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar != null && mVar.q2()) {
            QLog.i("QzoneFeedProUserHomeListBlockPart", 1, "is show forbidden page");
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
        if ((mVar2 != null && mVar2.getIsTimeLineClick()) && isVisible) {
            QLog.d("QzoneFeedProUserHomeListBlockPart", 1, "time line click and data is empty");
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
        boolean m26 = mVar3 != null ? mVar3.m2() : false;
        ae aeVar = this.mEmptyPageBlock;
        if (aeVar != null) {
            wd.e eVar = new wd.e();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            eVar.d(com.qzone.reborn.feedpro.utils.p.e(context, m26));
            aeVar.n0(eVar);
        }
        ae aeVar2 = this.mEmptyPageBlock;
        if (aeVar2 != null) {
            aeVar2.setBlockVisible(isVisible);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void na() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = new QzoneFeedProRefreshHeaderView(context, null, 0, 6, null);
        this.mRefreshHeader = qzoneFeedProRefreshHeaderView;
        this.mBlockContainer.setRefreshHeader(qzoneFeedProRefreshHeaderView);
        this.mBlockContainer.getRecyclerView().setItemAnimator(null);
        int m06 = QZoneConfigHelper.m0();
        QZoneBaseBlockContainer blockContainer = getBlockContainer();
        Intrinsics.checkNotNull(blockContainer);
        blockContainer.getBlockMerger().j0(m06);
    }

    private final void oa() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, d.f53896e, Z9());
        this.mDividerView = gVar;
        Intrinsics.checkNotNull(gVar);
        gVar.f(false);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        com.qzone.reborn.feedx.widget.g gVar2 = this.mDividerView;
        Intrinsics.checkNotNull(gVar2);
        recyclerView.addItemDecoration(gVar2);
    }

    private final void pa() {
        com.qzone.reborn.feedpro.viewmodel.n nVar = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        Y9(new b(nVar));
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = this.mRefreshHeader;
        if (qzoneFeedProRefreshHeaderView == null) {
            return;
        }
        qzoneFeedProRefreshHeaderView.setRefreshProgressProvider(nVar.U1());
    }

    @Override // com.qzone.reborn.feedpro.block.d
    public int E9() {
        return QZoneFeedxViewUtils.c();
    }

    @Override // com.qzone.reborn.feedpro.block.d
    protected vd.b<?> G9() {
        return this.mFeedListAdapter;
    }

    @Override // com.qzone.reborn.feedpro.block.d
    public void P9() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        boolean z16 = false;
        if (mVar != null && mVar.getIsTimeLineClick()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        super.P9();
    }

    public final void Y9(QZoneFeedxRefreshView.b onRefreshListener) {
        Intrinsics.checkNotNullParameter(onRefreshListener, "onRefreshListener");
        QzoneFeedProRefreshHeaderView qzoneFeedProRefreshHeaderView = this.mRefreshHeader;
        if (qzoneFeedProRefreshHeaderView != null) {
            qzoneFeedProRefreshHeaderView.c(onRefreshListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProUserHomeListBlockPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1;
        MutableLiveData<wd.h> d26;
        MutableLiveData<Integer> e26;
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        this.mShadowMask = (ImageView) mRootView.findViewById(R.id.nck);
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        this.mUserHomeViewModel = mVar;
        if (mVar != null && (N1 = mVar.N1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProUserHomeListBlockPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonFeed>> uIStateData) {
                    invoke2((UIStateData<List<CommonFeed>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<CommonFeed>> listUIStateData) {
                    Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
                    QzoneFeedProUserHomeListBlockPart.this.ba(listUIStateData);
                }
            };
            N1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.block.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProUserHomeListBlockPart.ia(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
        if (mVar2 != null && (e26 = mVar2.e2()) != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProUserHomeListBlockPart$onInitView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    QzoneFeedProUserHomeListBlockPart.this.qa(i3);
                }
            };
            e26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedpro.block.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProUserHomeListBlockPart.ja(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
        if (mVar3 != null && (d26 = mVar3.d2()) != null) {
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            final Function1<wd.h, Unit> function13 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProUserHomeListBlockPart$onInitView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(wd.h hVar) {
                    GetMainPageHeadRsp headRsp = hVar.getHeadRsp();
                    if (headRsp != null) {
                        QzoneFeedProUserHomeListBlockPart.this.ca(headRsp);
                    }
                }
            };
            d26.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.feedpro.block.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProUserHomeListBlockPart.la(Function1.this, obj);
                }
            });
        }
        na();
        pa();
        QzoneFeedProFeedOnlySelfBlock qzoneFeedProFeedOnlySelfBlock = this.mFeedOnlySelfBlock;
        if (qzoneFeedProFeedOnlySelfBlock != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar4 = this.mUserHomeViewModel;
            qzoneFeedProFeedOnlySelfBlock.n0(mVar4 != null ? mVar4.g2() : null);
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar5 = this.mUserHomeViewModel;
        if (mVar5 == null || (O1 = mVar5.O1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function14 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProUserHomeListBlockPart$onInitView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                QzoneFeedProLoadMoreUpBlock qzoneFeedProLoadMoreUpBlock;
                b.Companion companion = com.qzone.reborn.feedpro.viewmodel.b.INSTANCE;
                if (Intrinsics.areEqual(bVar, companion.b())) {
                    qzoneFeedProLoadMoreUpBlock = QzoneFeedProUserHomeListBlockPart.this.mLoadMoreUpBlock;
                    QzoneFeedProUserHomeListBlockPart.this.L9(bVar.getUpdateCount(), true, qzoneFeedProLoadMoreUpBlock != null ? qzoneFeedProLoadMoreUpBlock.q0() : 0);
                } else if (Intrinsics.areEqual(bVar, companion.f())) {
                    QzoneFeedProUserHomeListBlockPart.this.L9(0, true, QZoneFeedxViewUtils.c());
                }
            }
        };
        O1.observe(lifecycleOwner4, new Observer() { // from class: com.qzone.reborn.feedpro.block.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeListBlockPart.ma(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(32);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(UIStateData<List<CommonFeed>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        QLog.e("QzoneFeedProUserHomeListBlockPart", 1, "handleFeedListRsp() state" + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            QLog.e("QzoneFeedProUserHomeListBlockPart", 1, "handleFeedListRsp() return empty data");
            t tVar = this.mFeedListAdapter;
            Intrinsics.checkNotNull(tVar);
            tVar.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            t tVar2 = this.mFeedListAdapter;
            Intrinsics.checkNotNull(tVar2);
            tVar2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            ha(listUIStateData);
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QzoneFeedProUserHomeListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + listUIStateData.getRetCode() + " | msg = " + listUIStateData.getMsg());
        t tVar3 = this.mFeedListAdapter;
        Intrinsics.checkNotNull(tVar3);
        tVar3.notifyLoadingComplete(false);
        aa(listUIStateData.getMsg());
    }

    private final void ha(UIStateData<List<CommonFeed>> listUIStateData) {
        Object valueOf;
        if (listUIStateData == null) {
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        boolean z16 = false;
        if (mVar != null && mVar.q2()) {
            QLog.i("QzoneFeedProUserHomeListBlockPart", 1, "is show empty page block");
            return;
        }
        List<CommonFeed> data = listUIStateData.getData();
        boolean isFinish = listUIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
        if (mVar2 == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(mVar2 != null ? mVar2.hashCode() : 0);
        }
        QLog.d("QzoneFeedProUserHomeListBlockPart", 1, "get usr feed data  view model hashCode is " + valueOf);
        ga(data.size() == 0);
        if (this.mFeedListAdapter == null) {
            this.mFeedListAdapter = new t(null);
        }
        ea(listUIStateData, isFinish);
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
        if (mVar3 != null && mVar3.q2()) {
            z16 = true;
        }
        if (z16) {
            t tVar = this.mFeedListAdapter;
            if (tVar != null) {
                tVar.setDatas(null);
            }
        } else {
            t tVar2 = this.mFeedListAdapter;
            if (tVar2 != null) {
                tVar2.setDatas(data);
            }
        }
        oa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(int headerState) {
        boolean z16 = headerState == 1;
        r rVar = this.mHeaderBlock;
        if (rVar != null) {
            rVar.setBlockVisible(z16);
        }
        QzoneFeedProFeedOnlySelfBlock qzoneFeedProFeedOnlySelfBlock = this.mFeedOnlySelfBlock;
        if (qzoneFeedProFeedOnlySelfBlock != null) {
            qzoneFeedProFeedOnlySelfBlock.setBlockVisible(z16);
        }
        j jVar = this.mFeedCountBlock;
        if (jVar != null) {
            jVar.setBlockVisible(z16);
        }
        QzoneFeedProLoadMoreUpBlock qzoneFeedProLoadMoreUpBlock = this.mLoadMoreUpBlock;
        if (qzoneFeedProLoadMoreUpBlock != null) {
            qzoneFeedProLoadMoreUpBlock.setBlockVisible(!z16);
        }
    }
}
