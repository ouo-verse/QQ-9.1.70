package com.qzone.reborn.groupalbum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.groupalbum.block.GroupAlbumFeedAdapter;
import com.qzone.reborn.groupalbum.part.feed.ab;
import com.qzone.reborn.groupalbum.part.feed.ag;
import com.qzone.reborn.groupalbum.part.feed.ah;
import com.qzone.reborn.groupalbum.part.feed.g;
import com.qzone.reborn.groupalbum.part.feed.j;
import com.qzone.reborn.groupalbum.part.feed.t;
import com.qzone.reborn.groupalbum.part.feed.u;
import com.qzone.reborn.groupalbum.part.i;
import com.qzone.reborn.groupalbum.viewmodel.z;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import gf.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/groupalbum/fragment/GroupAlbumFeedFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getPageType", "", "enableDaTongPageRegister", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "mFeedViewModel", "Lcom/qzone/reborn/groupalbum/part/feed/g;", "D", "Lcom/qzone/reborn/groupalbum/part/feed/g;", "mListBlockPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedFragment extends QZoneBaseFragment implements k {

    /* renamed from: C, reason: from kotlin metadata */
    private z mFeedViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private g mListBlockPart;

    private final List<MultiViewBlock<?>> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GroupAlbumFeedAdapter(null));
        return arrayList;
    }

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        this.mFeedViewModel = (z) getViewModel(z.class);
    }

    private final void parseIntent(Intent intent) {
        z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.X1(intent);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        g gVar = new g(R.id.k5v, buildBlockList());
        this.mListBlockPart = gVar;
        Intrinsics.checkNotNull(gVar);
        arrayList.add(gVar);
        arrayList.add(new u());
        arrayList.add(new j());
        arrayList.add(new i());
        arrayList.add(new com.qzone.reborn.groupalbum.layer.part.j());
        arrayList.add(new t());
        arrayList.add(new ah());
        arrayList.add(new ab());
        arrayList.add(new ag());
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected boolean enableDaTongPageRegister() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127791m;
    }

    @Override // gf.k
    public int getPageType() {
        return 9;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
        initViewModel();
        if (getActivity() == null || (intent = requireActivity().getIntent()) == null) {
            return;
        }
        parseIntent(intent);
    }
}
