package com.qzone.reborn.intimate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.block.j;
import com.qzone.reborn.feedx.part.detail.QZoneFeedxDetailAnimPart;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.reborn.intimate.part.QZoneIntimateFeedDetailBlockPart;
import com.qzone.reborn.intimate.part.bl;
import com.qzone.reborn.intimate.part.feed.QZoneIntimateFeedDetailLikeAnimPart;
import com.qzone.reborn.intimate.part.feed.i;
import com.qzone.reborn.intimate.part.feed.l;
import com.qzone.reborn.intimate.part.feed.t;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.state.report.SquareReportConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import ef.b;
import gf.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nk.aq;
import tj.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateFeedDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getPageType", "", "enableRootViewSetFitsSystemWindows", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "Lnk/aq;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/aq;", "mDetailViewModel", "Lcom/qzone/reborn/intimate/part/QZoneIntimateFeedDetailBlockPart;", "D", "Lcom/qzone/reborn/intimate/part/QZoneIntimateFeedDetailBlockPart;", "mListBlockPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateFeedDetailFragment extends QZoneBaseFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private aq mDetailViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneIntimateFeedDetailBlockPart mListBlockPart;

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        this.mDetailViewModel = (aq) getViewModel(aq.class);
    }

    private final void parseIntent(Intent intent) {
        aq aqVar = this.mDetailViewModel;
        if (aqVar != null) {
            aqVar.T1(intent);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QZoneIntimateFeedDetailBlockPart qZoneIntimateFeedDetailBlockPart = new QZoneIntimateFeedDetailBlockPart(R.id.mvs, buildBlockList());
        this.mListBlockPart = qZoneIntimateFeedDetailBlockPart;
        arrayList.add(qZoneIntimateFeedDetailBlockPart);
        arrayList.add(new bl());
        arrayList.add(new t());
        if (QZoneFeedxAnimUtils.f55700a.d()) {
            arrayList.add(new QZoneFeedxDetailAnimPart());
        }
        arrayList.add(new i());
        arrayList.add(new l());
        arrayList.add(new com.qzone.reborn.intimate.part.feed.k());
        arrayList.add(new QZoneIntimateFeedDetailLikeAnimPart());
        arrayList.add(new u());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        String str;
        MutableLiveData<UIStateData<BusinessFeedData>> R1;
        UIStateData<BusinessFeedData> value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        aq aqVar = this.mDetailViewModel;
        BusinessFeedData data = (aqVar == null || (R1 = aqVar.R1()) == null || (value = R1.getValue()) == null) ? null : value.getData();
        if (data != null) {
            CellIntimateSpaceInfo cellIntimateSpaceInfo = data.cellIntimateSpaceInfo;
            linkedHashMap.put("close_friend_space_id", cellIntimateSpaceInfo != null ? cellIntimateSpaceInfo.spaceId : null);
            CellIntimateSpaceInfo cellIntimateSpaceInfo2 = data.cellIntimateSpaceInfo;
            linkedHashMap.put("close_friend_space_type", cellIntimateSpaceInfo2 != null ? Integer.valueOf(cellIntimateSpaceInfo2.spaceType) : null);
            if (b.h(data)) {
                str = "0";
            } else {
                str = "1";
            }
            linkedHashMap.put("open_visit_state", str);
            CellUserInfo cellUserInfo = data.cellUserInfo;
            User user = cellUserInfo != null ? cellUserInfo.user : null;
            if (user != null) {
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, user.uid);
                linkedHashMap.put("touin", Long.valueOf(user.uin));
                linkedHashMap.put("framer_uin", Long.valueOf(user.uin));
            }
            linkedHashMap.put("feedid", b.a(data));
            linkedHashMap.put("appid", Integer.valueOf(data.getFeedCommInfo().appid));
            linkedHashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, Integer.valueOf(data.getFeedCommInfo().bizId));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cib;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }

    @Override // gf.k
    public int getPageType() {
        return 7;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
            Intent intent = requireActivity().getIntent();
            if (intent != null) {
                parseIntent(intent);
            }
            FragmentActivity activity2 = getActivity();
            if ((activity2 != null ? activity2.getWindow() : null) == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(34);
        }
    }

    private final List<MultiViewBlock<?>> buildBlockList() {
        List<MultiViewBlock<?>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.intimate.block.b(), new j(null));
        return mutableListOf;
    }
}
