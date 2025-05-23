package com.qzone.reborn.intimate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.block.QZoneIntimateFeedAdapter;
import com.qzone.reborn.intimate.block.QZoneIntimateFeedListHeaderBlock;
import com.qzone.reborn.intimate.part.bj;
import com.qzone.reborn.intimate.part.bl;
import com.qzone.reborn.intimate.part.feed.QZoneIntimateFeedListLikeAnimPart;
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
import nk.ar;
import nk.h;
import nk.i;
import nk.p;
import qj.m;
import qj.n;
import tj.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/intimate/fragment/QZoneIntimateSpaceFeedFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Lgf/k;", "Lqj/m;", "Lqj/n;", "Lqj/k;", "Landroid/content/Intent;", "intent", "", "parseIntent", "initViewModel", "initIoc", "", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "buildBlockList", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "contentView", "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getPageType", "", "fa", "W5", "c0", "enableDaTongPageRegister", "", "spaceId", "gc", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lnk/ar;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/ar;", "mFeedViewModel", "Lcom/qzone/reborn/intimate/part/bj;", "D", "Lcom/qzone/reborn/intimate/part/bj;", "mListBlockPart", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceFeedFragment extends QZoneBaseFragment implements k, m, n, qj.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ar mFeedViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private bj mListBlockPart;

    private final List<MultiViewBlock<?>> buildBlockList() {
        QZoneIntimateMainPageInitBean initBean;
        ArrayList arrayList = new ArrayList();
        ar arVar = this.mFeedViewModel;
        boolean z16 = false;
        if (arVar != null && (initBean = arVar.getInitBean()) != null && initBean.getIsMember()) {
            z16 = true;
        }
        if (z16) {
            QZoneIntimateFeedListHeaderBlock qZoneIntimateFeedListHeaderBlock = new QZoneIntimateFeedListHeaderBlock(null);
            if (qZoneIntimateFeedListHeaderBlock.q0()) {
                ViewModel outerViewModel = getOuterViewModel(h.class);
                Intrinsics.checkNotNullExpressionValue(outerViewModel, "getOuterViewModel(\n     \u2026ss.java\n                )");
                qZoneIntimateFeedListHeaderBlock.u0((h) outerViewModel);
                ViewModel outerViewModel2 = getOuterViewModel(i.class);
                Intrinsics.checkNotNullExpressionValue(outerViewModel2, "getOuterViewModel(\n     \u2026ss.java\n                )");
                qZoneIntimateFeedListHeaderBlock.v0((i) outerViewModel2);
                ViewModel outerViewModel3 = getOuterViewModel(p.class);
                Intrinsics.checkNotNullExpressionValue(outerViewModel3, "getOuterViewModel(\n     \u2026ss.java\n                )");
                qZoneIntimateFeedListHeaderBlock.w0((p) outerViewModel3);
                arrayList.add(qZoneIntimateFeedListHeaderBlock);
            }
        }
        arrayList.add(new QZoneIntimateFeedAdapter(null));
        return arrayList;
    }

    private final void initIoc() {
        registerIoc(this, k.class);
    }

    private final void initViewModel() {
        Intent intent;
        this.mFeedViewModel = (ar) getViewModel(ar.class);
        if (getActivity() == null || (intent = requireActivity().getIntent()) == null) {
            return;
        }
        parseIntent(intent);
    }

    private final void parseIntent(Intent intent) {
        ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.P1(intent);
        }
    }

    @Override // qj.m
    public void W5() {
        bj bjVar = this.mListBlockPart;
        if (bjVar != null) {
            bjVar.W5();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        bj bjVar = new bj(R.id.mvs, buildBlockList());
        this.mListBlockPart = bjVar;
        Intrinsics.checkNotNull(bjVar);
        arrayList.add(bjVar);
        arrayList.add(new bl());
        arrayList.add(new com.qzone.reborn.intimate.part.feed.n());
        arrayList.add(new com.qzone.reborn.intimate.part.feed.h());
        arrayList.add(new QZoneIntimateFeedListLikeAnimPart());
        arrayList.add(new u());
        arrayList.add(new com.qzone.reborn.intimate.part.vip.a());
        return arrayList;
    }

    @Override // qj.n
    public void c0() {
        ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.Q1();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected boolean enableDaTongPageRegister() {
        return false;
    }

    @Override // qj.m
    public boolean fa() {
        bj bjVar = this.mListBlockPart;
        if (bjVar != null) {
            return bjVar.fa();
        }
        return false;
    }

    @Override // qj.k
    public void gc(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.d2(spaceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cig;
    }

    @Override // gf.k
    public int getPageType() {
        return 6;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        super.onDestroy();
        bk.a aVar = bk.a.f28490a;
        ar arVar = this.mFeedViewModel;
        if (arVar == null || (str = arVar.getSpaceId()) == null) {
            str = "";
        }
        aVar.f(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initIoc();
    }
}
