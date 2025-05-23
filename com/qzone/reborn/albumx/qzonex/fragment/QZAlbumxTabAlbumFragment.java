package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.part.albumlist.QZALbumxAlbumListTitlePart;
import com.qzone.reborn.albumx.qzonex.part.albumlist.QZAlbumxAlbumListBlockPart;
import com.qzone.reborn.albumx.qzonex.part.albumlist.l;
import com.qzone.reborn.albumx.qzonex.part.albumlist.m;
import com.qzone.reborn.albumx.qzonex.part.degrade.QZAlbumxPhotoDegradeDialogPart;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import cooperation.qzone.QZoneHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxTabAlbumFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getDaTongPageId", "", "", "getChildDaTongDynamicParams", "", "isVisibleToUser", "setUserVisibleHint", "Lnc/ae;", BdhLogUtil.LogTag.Tag_Conn, "Lnc/ae;", "mAlbumListViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxTabAlbumFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ae mAlbumListViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(QZAlbumxTabAlbumFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.registerDaTongReportPageId();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Map<String, Object> getChildDaTongDynamicParams() {
        int i3;
        ae aeVar;
        ae aeVar2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ae aeVar3 = this.mAlbumListViewModel;
        ae aeVar4 = null;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
            aeVar3 = null;
        }
        String from = aeVar3.a2().getFrom();
        if (from != null) {
            int hashCode = from.hashCode();
            if (hashCode != -1715136007) {
                if (hashCode != 695639619) {
                    if (hashCode == 2069337438 && from.equals("getMainPage")) {
                        String uinString = LoginData.getInstance().getUinString();
                        ae aeVar5 = this.mAlbumListViewModel;
                        if (aeVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
                            aeVar5 = null;
                        }
                        i3 = Intrinsics.areEqual(uinString, aeVar5.a2().getUin()) ? 3 : 4;
                    }
                } else if (from.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                    i3 = 1;
                }
            } else if (from.equals("getActiveFeeds")) {
                i3 = 2;
            }
            linkedHashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
            aeVar = this.mAlbumListViewModel;
            if (aeVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
                aeVar = null;
            }
            AlbumPageInfo pageInfo = aeVar.getPageInfo();
            linkedHashMap.put("albums_number", Integer.valueOf(pageInfo != null ? pageInfo.albumNum : 0));
            String uinString2 = LoginData.getInstance().getUinString();
            aeVar2 = this.mAlbumListViewModel;
            if (aeVar2 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
            } else {
                aeVar4 = aeVar2;
            }
            linkedHashMap.put("open_visit_state", Integer.valueOf(!Intrinsics.areEqual(uinString2, aeVar4.a2().getUin()) ? 1 : 0));
            return linkedHashMap;
        }
        i3 = 0;
        linkedHashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
        aeVar = this.mAlbumListViewModel;
        if (aeVar == null) {
        }
        AlbumPageInfo pageInfo2 = aeVar.getPageInfo();
        linkedHashMap.put("albums_number", Integer.valueOf(pageInfo2 != null ? pageInfo2.albumNum : 0));
        String uinString22 = LoginData.getInstance().getUinString();
        aeVar2 = this.mAlbumListViewModel;
        if (aeVar2 != null) {
        }
        linkedHashMap.put("open_visit_state", Integer.valueOf(!Intrinsics.areEqual(uinString22, aeVar4.a2().getUin()) ? 1 : 0));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129295o;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_space_album_list_new";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026istViewModel::class.java)");
        this.mAlbumListViewModel = (ae) viewModel;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        ae aeVar = this.mAlbumListViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListViewModel");
            aeVar = null;
        }
        aeVar.f2(intent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        QLog.d(getTAG(), 1, "[setUserVisibleHint]: " + isVisibleToUser);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxTabAlbumFragment.qh(QZAlbumxTabAlbumFragment.this);
            }
        }, 200L);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumxAlbumListBlockPart(), new QZALbumxAlbumListTitlePart(), new m(), new l(), new qb.a("qzone_albumx_album_list"), new QZAlbumxPhotoDegradeDialogPart());
        return mutableListOf;
    }
}
