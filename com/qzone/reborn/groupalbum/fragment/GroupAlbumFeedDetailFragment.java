package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.part.detail.QZoneFeedxDetailAnimPart;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.reborn.groupalbum.part.GroupAlbumFeedDetailEmptyPart;
import com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumDetailHomeBtnPart;
import com.qzone.reborn.groupalbum.part.e;
import com.qzone.reborn.groupalbum.part.feed.GroupAlbumFeedDetailBlockPart;
import com.qzone.reborn.groupalbum.part.feed.aa;
import com.qzone.reborn.groupalbum.part.feed.ad;
import com.qzone.reborn.groupalbum.part.feed.p;
import com.qzone.reborn.groupalbum.part.feed.q;
import com.qzone.reborn.groupalbum.part.feed.r;
import com.qzone.reborn.groupalbum.part.feed.y;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.reborn.groupalbum.viewmodel.x;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import ef.b;
import gf.j;
import gf.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u001eH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumFeedDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Lgf/j;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onActivityCreated", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getPageType", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "", "enableRootViewSetFitsSystemWindows", "y1", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "mDetailViewModel", "Lcom/qzone/reborn/groupalbum/viewmodel/x;", "D", "Lcom/qzone/reborn/groupalbum/viewmodel/x;", "mLikeViewModel", "Lcom/qzone/reborn/groupalbum/part/feed/GroupAlbumFeedDetailBlockPart;", "E", "Lcom/qzone/reborn/groupalbum/part/feed/GroupAlbumFeedDetailBlockPart;", "mListBlockPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedDetailFragment extends QZoneBaseFragment implements k, j {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAlbumFeedDetailViewModel mDetailViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private x mLikeViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private GroupAlbumFeedDetailBlockPart mListBlockPart;

    private final void initIoc() {
        registerIoc(this, k.class);
        registerIoc(this, j.class);
    }

    private final void initViewModel() {
        this.mDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        this.mLikeViewModel = (x) getViewModel(x.class);
    }

    private final void parseIntent(Intent intent) {
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            groupAlbumFeedDetailViewModel.u2(intent);
        }
        x xVar = this.mLikeViewModel;
        if (xVar != null) {
            xVar.P1(intent);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        GroupAlbumFeedDetailBlockPart groupAlbumFeedDetailBlockPart = new GroupAlbumFeedDetailBlockPart(R.id.mvs, buildBlockList());
        this.mListBlockPart = groupAlbumFeedDetailBlockPart;
        arrayList.add(groupAlbumFeedDetailBlockPart);
        arrayList.add(new e());
        arrayList.add(new y());
        if (QZoneFeedxAnimUtils.f55700a.d()) {
            arrayList.add(new QZoneFeedxDetailAnimPart());
        }
        arrayList.add(new p());
        arrayList.add(new r());
        arrayList.add(new q());
        arrayList.add(new com.qzone.reborn.groupalbum.layer.part.j());
        arrayList.add(new GroupAlbumFeedDetailEmptyPart());
        arrayList.add(new aa());
        arrayList.add(new ad());
        arrayList.add(new GroupAlbumDetailHomeBtnPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        MutableLiveData<UIStateData<BusinessFeedData>> i26;
        UIStateData<BusinessFeedData> value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        BusinessFeedData data = (groupAlbumFeedDetailViewModel == null || (i26 = groupAlbumFeedDetailViewModel.i2()) == null || (value = i26.getValue()) == null) ? null : value.getData();
        if (data != null) {
            CellGroupAlbumInfo cellGroupAlbumInfo = data.cellGroupAlbumInfo;
            linkedHashMap.put("group_uin", cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null);
            linkedHashMap.put("feedid", b.a(data));
            CellUserInfo cellUserInfo = data.cellUserInfo;
            User user = cellUserInfo != null ? cellUserInfo.user : null;
            if (user != null) {
                linkedHashMap.put("framer_uin", Long.valueOf(user.uin));
            }
            linkedHashMap.put("appid", Integer.valueOf(data.getFeedCommInfo().appid));
            linkedHashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, Integer.valueOf(data.getFeedCommInfo().bizId));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127781l;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_group_album_dynamic_details";
    }

    @Override // gf.k
    public int getPageType() {
        return 10;
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

    @Override // gf.j
    public boolean y1() {
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            return groupAlbumFeedDetailViewModel.getFromArk();
        }
        return false;
    }

    private final List<MultiViewBlock<?>> buildBlockList() {
        List<MultiViewBlock<?>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.qzone.reborn.groupalbum.block.b(), new com.qzone.reborn.feedx.block.j(null));
        return mutableListOf;
    }
}
