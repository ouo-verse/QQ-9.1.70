package com.qzone.reborn.intimate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.part.albumlist.QZoneIntimateAlbumListOperatePart;
import com.qzone.reborn.intimate.part.albumlist.e;
import com.qzone.reborn.intimate.part.albumlist.i;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nk.at;
import nk.z;
import qj.k;
import qj.m;
import qj.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0018H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateSpaceAlbumListFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lqj/m;", "Lqj/n;", "Lqj/k;", "", "initViewModel", "initIoc", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "fa", "W5", "c0", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "spaceId", "gc", "Lcom/qzone/reborn/intimate/part/albumlist/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/part/albumlist/e;", "mBlockPart", "Lnk/z;", "D", "Lnk/z;", "mAlbumViewModel", "Lnk/at;", "E", "Lnk/at;", "mMainTabViewModel", UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "mSpaceType", "G", "Z", "mIsRegisterDaTongReport", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceAlbumListFragment extends QZoneBaseFragment implements m, n, k {

    /* renamed from: C, reason: from kotlin metadata */
    private e mBlockPart;

    /* renamed from: D, reason: from kotlin metadata */
    private z mAlbumViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private at mMainTabViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private Integer mSpaceType;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsRegisterDaTongReport;

    private final void initIoc() {
        registerIoc(this, gf.k.class);
    }

    private final void initViewModel() {
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        this.mAlbumViewModel = (z) getViewModel(z.class);
        at atVar = (at) getOuterViewModel(at.class);
        this.mMainTabViewModel = atVar;
        if (atVar == null || (U1 = atVar.U1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceAlbumListFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                boolean z16;
                if (uIStateData.getData() != null) {
                    z16 = QZoneIntimateSpaceAlbumListFragment.this.mIsRegisterDaTongReport;
                    if (z16) {
                        return;
                    }
                    QZoneIntimateSpaceAlbumListFragment.this.mIsRegisterDaTongReport = true;
                    QZoneIntimateSpaceAlbumListFragment.this.mSpaceType = Integer.valueOf(uIStateData.getData().getSpaceType());
                    QZoneIntimateSpaceAlbumListFragment.this.registerDaTongReportPageId();
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceAlbumListFragment.th(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // qj.m
    public void W5() {
        e eVar = this.mBlockPart;
        if (eVar != null) {
            eVar.W5();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i());
        e eVar = new e();
        this.mBlockPart = eVar;
        Intrinsics.checkNotNull(eVar);
        arrayList.add(eVar);
        arrayList.add(new com.qzone.reborn.intimate.part.albumlist.k());
        arrayList.add(new QZoneIntimateAlbumListOperatePart(getMFromDtPageId()));
        return arrayList;
    }

    @Override // qj.n
    public void c0() {
        z zVar = this.mAlbumViewModel;
        if (zVar != null) {
            zVar.f2(false);
        }
        e eVar = this.mBlockPart;
        if (eVar != null) {
            eVar.W7();
        }
    }

    @Override // qj.m
    public boolean fa() {
        e eVar = this.mBlockPart;
        if (eVar != null) {
            return eVar.fa();
        }
        return false;
    }

    @Override // qj.k
    public void gc(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            return;
        }
        zVar.j2(spaceId);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        if (this.mSpaceType == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        z zVar = this.mAlbumViewModel;
        if (zVar == null || (str = zVar.getMSpaceId()) == null) {
            str = "";
        }
        hashMap.put("close_friend_space_id", str);
        Integer num = this.mSpaceType;
        if (num != null) {
            hashMap.put("close_friend_space_type", Integer.valueOf(num.intValue()));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cid;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_intimate_space_home_album_tab";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        z zVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (zVar = this.mAlbumViewModel) == null) {
            return;
        }
        zVar.d2(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
    }
}
