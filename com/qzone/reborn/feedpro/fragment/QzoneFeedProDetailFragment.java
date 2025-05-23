package com.qzone.reborn.feedpro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.base.b;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.block.a;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProDetailFragment;
import com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailAnimPart;
import com.qzone.reborn.feedpro.part.detail.QzoneFeedProDetailBlockPart;
import com.qzone.reborn.feedpro.part.detail.d;
import com.qzone.reborn.feedpro.part.detail.f;
import com.qzone.reborn.feedpro.part.detail.t;
import com.qzone.reborn.feedpro.part.m;
import com.qzone.reborn.feedpro.utils.QzoneFeedProAnimUtils;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.feedpro.viewmodel.i;
import com.qzone.reborn.feedx.part.aj;
import com.qzone.reborn.feedx.part.bf;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.richframework.data.base.UIStateData;
import fh.b;
import gf.e;
import gf.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jo.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0012J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/fragment/QzoneFeedProDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "getPageType", "", "enableRootViewSetFitsSystemWindows", "Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProDetailBlockPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProDetailBlockPart;", "mDetailBlockPart", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "Lfh/b;", "E", "Lfh/b;", "mFeedDaTongReporter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailFragment extends QZoneBaseFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProDetailBlockPart mDetailBlockPart;

    /* renamed from: D, reason: from kotlin metadata */
    private i mDetailViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private b mFeedDaTongReporter;

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        this.mDetailViewModel = (i) getViewModel(i.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh() {
        h.f410717a.h("page_launch_feed_detail").t("FEED_SHOW");
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QzoneFeedProDetailBlockPart qzoneFeedProDetailBlockPart = new QzoneFeedProDetailBlockPart(R.id.mwc, buildBlockList());
        this.mDetailBlockPart = qzoneFeedProDetailBlockPart;
        Intrinsics.checkNotNull(qzoneFeedProDetailBlockPart);
        arrayList.add(qzoneFeedProDetailBlockPart);
        arrayList.add(new t());
        arrayList.add(new aj());
        arrayList.add(new f());
        arrayList.add(new d());
        arrayList.add(new com.qzone.reborn.feedpro.part.i());
        if (QzoneFeedProAnimUtils.f54254a.d()) {
            arrayList.add(new QzoneFeedProDetailAnimPart());
        }
        arrayList.add(new bf());
        arrayList.add(new m("page_launch_feed_detail"));
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.c());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.b.class));
        return arrayList;
    }

    public final List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.feedpro.block.f(null));
        arrayList.add(new com.qzone.reborn.feedpro.block.h(null));
        com.qzone.reborn.feedpro.block.i iVar = new com.qzone.reborn.feedpro.block.i(null);
        arrayList.add(iVar);
        iVar.setBlockVisible(false);
        if (!g.f53821a.b().U1()) {
            a aVar = new a(null);
            aVar.setBlockVisible(false);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        MutableLiveData<UIStateData<CommonFeed>> f26;
        UIStateData<CommonFeed> value;
        CommonFeed data;
        MutableLiveData<UIStateData<CommonFeed>> f27;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i iVar = this.mDetailViewModel;
        UIStateData<CommonFeed> value2 = (iVar == null || (f27 = iVar.f2()) == null) ? null : f27.getValue();
        if (value2 != null && 4 == value2.getState()) {
            int retCode = (int) value2.getRetCode();
            if (retCode == 10014) {
                linkedHashMap.put("page_visit_state", 1);
            } else if (retCode == 10015) {
                linkedHashMap.put("page_visit_state", 3);
            } else if (retCode != 10023) {
                linkedHashMap.put("page_visit_state", Integer.valueOf(retCode));
            } else {
                linkedHashMap.put("page_visit_state", 2);
            }
        } else {
            linkedHashMap.put("page_visit_state", 0);
        }
        i iVar2 = this.mDetailViewModel;
        if (iVar2 != null && (f26 = iVar2.f2()) != null && (value = f26.getValue()) != null && (data = value.getData()) != null) {
            linkedHashMap.putAll(b.INSTANCE.b(data));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.chy;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }

    @Override // gf.k
    public int getPageType() {
        i iVar = this.mDetailViewModel;
        boolean z16 = false;
        if (iVar != null && iVar.m2()) {
            z16 = true;
        }
        return z16 ? 8 : 2;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if ((activity != null ? activity.getWindow() : null) != null) {
                boolean z16 = !QQTheme.isNowThemeIsNight();
                FragmentActivity activity2 = getActivity();
                ImmersiveUtils.setStatusTextColor(z16, activity2 != null ? activity2.getWindow() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        this.mFeedDaTongReporter = new b(getMFromDtPageId());
        RFWIocAbilityProvider.g().registerIoc(contentView, this.mFeedDaTongReporter, e.class);
        QzoneFeedProDetailBlockPart qzoneFeedProDetailBlockPart = this.mDetailBlockPart;
        if (qzoneFeedProDetailBlockPart != null) {
            Intrinsics.checkNotNull(qzoneFeedProDetailBlockPart);
            if (qzoneFeedProDetailBlockPart.getBlockContainer() != null) {
                QzoneFeedProDetailBlockPart qzoneFeedProDetailBlockPart2 = this.mDetailBlockPart;
                Intrinsics.checkNotNull(qzoneFeedProDetailBlockPart2);
                QZoneBaseBlockContainer blockContainer = qzoneFeedProDetailBlockPart2.getBlockContainer();
                Intrinsics.checkNotNull(blockContainer);
                if (blockContainer.getBlockMerger() != null) {
                    QzoneFeedProDetailBlockPart qzoneFeedProDetailBlockPart3 = this.mDetailBlockPart;
                    Intrinsics.checkNotNull(qzoneFeedProDetailBlockPart3);
                    QZoneBaseBlockContainer blockContainer2 = qzoneFeedProDetailBlockPart3.getBlockContainer();
                    Intrinsics.checkNotNull(blockContainer2);
                    blockContainer2.getBlockMerger().k0(new b.a() { // from class: ce.b
                        @Override // com.qzone.reborn.base.b.a
                        public final void S() {
                            QzoneFeedProDetailFragment.qh();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        FragmentActivity activity;
        Window window;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
        initViewModel();
        if (getActivity() != null) {
            FragmentActivity activity2 = getActivity();
            parseIntent(activity2 != null ? activity2.getIntent() : null);
        }
        if (getActivity() != null) {
            FragmentActivity activity3 = getActivity();
            if ((activity3 != null ? activity3.getWindow() : null) == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(34);
        }
    }

    private final void parseIntent(Intent intent) {
        i iVar;
        if (intent == null || (iVar = this.mDetailViewModel) == null) {
            return;
        }
        iVar.x2(intent);
    }
}
