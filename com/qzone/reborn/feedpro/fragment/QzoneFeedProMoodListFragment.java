package com.qzone.reborn.feedpro.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.feedpro.block.QzoneFeedProFeedOnlySelfBlock;
import com.qzone.reborn.feedpro.block.QzoneFeedProMoodListAdapter;
import com.qzone.reborn.feedpro.block.QzoneFeedProMoodListBlockPart;
import com.qzone.reborn.feedpro.block.e;
import com.qzone.reborn.feedpro.block.i;
import com.qzone.reborn.feedpro.block.n;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProMoodListFragment;
import com.qzone.reborn.feedpro.viewmodel.QzoneFeedProMoodListViewModel;
import com.qzone.reborn.feedpro.viewmodel.c;
import com.qzone.reborn.feedx.block.QZoneLoadingStateBlock;
import com.qzone.reborn.feedx.part.p;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import gf.k;
import gf.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n6.a;

@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0015J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0007J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f0\u001eH\u0014J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*`+H\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFeedProMoodListFragment;", "Lcom/qzone/reborn/feedpro/fragment/QzoneBaseFeedProFragment;", "Lgf/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "vh", "initViewModel", "event", "handleHolidayRefreshEvent", "", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedBeforePartInit", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "enableRootViewSetFitsSystemWindows", "initIoc", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "Le", "getPageType", "getReportPageId", "Lcom/qzone/reborn/base/c;", "getBlockPart", "Lcom/qzone/reborn/feedpro/block/e;", "rh", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListBlockPart;", "E", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListBlockPart;", "mListBlockPart", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "mFeedDataViewModel", "Lgf/q;", "G", "Lgf/q;", "mReadDivideLineIoc", "Lcom/qzone/reborn/feedpro/block/n;", "H", "Lcom/qzone/reborn/feedpro/block/n;", "mHeaderBlock", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListAdapter;", "I", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListAdapter;", "mFeedListAdapter", "Lcom/qzone/reborn/feedpro/block/i;", "J", "Lcom/qzone/reborn/feedpro/block/i;", "mEmptyPageBlock", "Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock;", "K", "Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock;", "mLoadingStateBlock", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "L", "Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "mFeedOnlySelfBlock", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMoodListFragment extends QzoneBaseFeedProFragment implements k, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProMoodListBlockPart mListBlockPart;

    /* renamed from: F, reason: from kotlin metadata */
    private QzoneFeedProMoodListViewModel mFeedDataViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private q mReadDivideLineIoc;

    /* renamed from: H, reason: from kotlin metadata */
    private n mHeaderBlock;

    /* renamed from: I, reason: from kotlin metadata */
    private QzoneFeedProMoodListAdapter mFeedListAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private i mEmptyPageBlock;

    /* renamed from: K, reason: from kotlin metadata */
    private QZoneLoadingStateBlock mLoadingStateBlock;

    /* renamed from: L, reason: from kotlin metadata */
    private QzoneFeedProFeedOnlySelfBlock mFeedOnlySelfBlock;

    private final void handleHolidayRefreshEvent(SimpleBaseEvent event) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel;
        RFWLog.i("QzoneFeedProMoodListFragment", RFWLog.USR, "receive holiday refresh event: " + event);
        if (this.mListBlockPart == null || (qzoneFeedProMoodListViewModel = this.mFeedDataViewModel) == null) {
            return;
        }
        Intrinsics.checkNotNull(qzoneFeedProMoodListViewModel);
        if (qzoneFeedProMoodListViewModel.d2()) {
            QzoneFeedProMoodListBlockPart qzoneFeedProMoodListBlockPart = this.mListBlockPart;
            Intrinsics.checkNotNull(qzoneFeedProMoodListBlockPart);
            qzoneFeedProMoodListBlockPart.refresh();
        }
    }

    private final void initViewModel() {
        this.mFeedDataViewModel = (QzoneFeedProMoodListViewModel) getViewModel(QzoneFeedProMoodListViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(QzoneFeedProMoodListFragment this$0, SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.handleHolidayRefreshEvent(event);
    }

    private final void vh(Bundle savedInstanceState) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel;
        FragmentActivity activity = getActivity();
        if (activity == null || (qzoneFeedProMoodListViewModel = this.mFeedDataViewModel) == null) {
            return;
        }
        qzoneFeedProMoodListViewModel.g2(activity.getIntent(), savedInstanceState);
    }

    @Override // com.qzone.reborn.feedpro.viewmodel.a
    public c Le() {
        return this.mFeedDataViewModel;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        long uin;
        ArrayList arrayList = new ArrayList();
        QzoneFeedProMoodListBlockPart qzoneFeedProMoodListBlockPart = new QzoneFeedProMoodListBlockPart(R.id.n2d, buildBlockList());
        this.mListBlockPart = qzoneFeedProMoodListBlockPart;
        Intrinsics.checkNotNull(qzoneFeedProMoodListBlockPart);
        arrayList.add(qzoneFeedProMoodListBlockPart);
        ve.i iVar = new ve.i();
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel != null) {
            uin = qzoneFeedProMoodListViewModel.getMUin();
        } else {
            uin = LoginData.getInstance().getUin();
        }
        arrayList.addAll(new kd.c().c(iVar.h(uin).e(getMFromDtPageId()).g("shuoshuoList")));
        arrayList.add(new p());
        return arrayList;
    }

    public final List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        boolean z16 = false;
        if (qzoneFeedProMoodListViewModel != null && qzoneFeedProMoodListViewModel.d2()) {
            z16 = true;
        }
        if (z16) {
            n nVar = new n(null);
            this.mHeaderBlock = nVar;
            Intrinsics.checkNotNull(nVar);
            arrayList.add(nVar);
        }
        i iVar = new i(null);
        this.mEmptyPageBlock = iVar;
        Intrinsics.checkNotNull(iVar);
        arrayList.add(iVar);
        QZoneLoadingStateBlock qZoneLoadingStateBlock = new QZoneLoadingStateBlock(null, getPageType());
        this.mLoadingStateBlock = qZoneLoadingStateBlock;
        Intrinsics.checkNotNull(qZoneLoadingStateBlock);
        arrayList.add(qZoneLoadingStateBlock);
        QzoneFeedProFeedOnlySelfBlock qzoneFeedProFeedOnlySelfBlock = new QzoneFeedProFeedOnlySelfBlock(null);
        arrayList.add(qzoneFeedProFeedOnlySelfBlock);
        this.mFeedOnlySelfBlock = qzoneFeedProFeedOnlySelfBlock;
        QzoneFeedProMoodListAdapter qzoneFeedProMoodListAdapter = new QzoneFeedProMoodListAdapter(null);
        this.mFeedListAdapter = qzoneFeedProMoodListAdapter;
        Intrinsics.checkNotNull(qzoneFeedProMoodListAdapter);
        arrayList.add(qzoneFeedProMoodListAdapter);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public com.qzone.reborn.base.c getBlockPart() {
        QzoneFeedProMoodListBlockPart qzoneFeedProMoodListBlockPart = this.mListBlockPart;
        Intrinsics.checkNotNull(qzoneFeedProMoodListBlockPart);
        return qzoneFeedProMoodListBlockPart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @Deprecated(message = "Deprecated in Java")
    public int getContentLayoutId() {
        return R.layout.f167286ci0;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_talk_about_list";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneHolidayRefreshFeedEvent.class);
        return arrayList;
    }

    @Override // gf.k
    public int getPageType() {
        return 5;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 10;
    }

    public final void initIoc() {
        a aVar = new a();
        this.mReadDivideLineIoc = aVar;
        registerIoc(aVar, q.class);
        registerIoc(this, k.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Window window;
        super.onActivityCreated(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QZoneHolidayRefreshFeedEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ce.c
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProMoodListFragment.uh(QzoneFeedProMoodListFragment.this, event);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewModel();
        vh(savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        syncLoginStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        QLog.d("QzoneFeedProMoodListFragment", 1, "contentView.getContext: " + contentView.getContext());
        initIoc();
    }

    @Override // com.qzone.reborn.feedpro.fragment.QzoneBaseFeedProFragment
    public e rh() {
        return this.mHeaderBlock;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        pairArr[0] = TuplesKt.to("open_visit_state", Integer.valueOf(((qzoneFeedProMoodListViewModel == null || !qzoneFeedProMoodListViewModel.d2()) ? 0 : 1) ^ 1));
        pairArr[1] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
