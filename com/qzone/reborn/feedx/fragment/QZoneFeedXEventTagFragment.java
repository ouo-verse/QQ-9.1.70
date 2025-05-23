package com.qzone.reborn.feedx.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.bean.QZoneFeedEventTagInitBean;
import com.qzone.reborn.feedx.block.QZoneFeedxEventTagListAdapter;
import com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagBlockPart;
import com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagHeadPart;
import com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagPublishMoodPart;
import com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagSharePanelPart;
import com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagTitlePart;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/fragment/QZoneFeedXEventTagFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "initViewModel", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "enableRootViewSetFitsSystemWindows", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mEventTagViewModel", "D", "Ljava/lang/String;", "mEventTagName", "E", "Z", "mIsRegisterDaTongReport", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedXEventTagFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneFeedxEventTagViewModel mEventTagViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private String mEventTagName;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsRegisterDaTongReport;

    private final List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedxEventTagListAdapter(null));
        return arrayList;
    }

    private final void initViewModel() {
        MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w26;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) getViewModel(QZoneFeedxEventTagViewModel.class);
        this.mEventTagViewModel = qZoneFeedxEventTagViewModel;
        if (qZoneFeedxEventTagViewModel == null || (w26 = qZoneFeedxEventTagViewModel.w2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit> function1 = new Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit>() { // from class: com.qzone.reborn.feedx.fragment.QZoneFeedXEventTagFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                invoke2(qZoneTagFeedList$GetTagFeedListHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                boolean z16;
                z16 = QZoneFeedXEventTagFragment.this.mIsRegisterDaTongReport;
                if (z16) {
                    return;
                }
                QZoneFeedXEventTagFragment.this.mIsRegisterDaTongReport = true;
                QZoneFeedXEventTagFragment.this.mEventTagName = qZoneTagFeedList$GetTagFeedListHeadRsp.tag_name.get();
                QZoneFeedXEventTagFragment.this.registerDaTongReportPageId();
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedXEventTagFragment.th(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedxEventTagBlockPart(R.id.mvs, buildBlockList()));
        arrayList.add(new QZoneFeedxEventTagTitlePart());
        arrayList.add(new QZoneFeedxEventTagHeadPart());
        arrayList.add(new QZoneFeedxEventTagPublishMoodPart());
        arrayList.add(new QZoneFeedxEventTagSharePanelPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        QZoneFeedEventTagInitBean v26;
        if (this.mEventTagName == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel != null && (v26 = qZoneFeedxEventTagViewModel.v2()) != null) {
            linkedHashMap.put("topic_id", v26.getEventTag());
            String str = this.mEventTagName;
            Intrinsics.checkNotNull(str);
            linkedHashMap.put("topic_name", str);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167289ci3;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_topic_aggregation";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initViewModel();
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel != null) {
            qZoneFeedxEventTagViewModel.E2(getActivity());
        }
    }
}
