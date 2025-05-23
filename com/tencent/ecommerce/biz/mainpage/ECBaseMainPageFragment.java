package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 '2\u00020\u0001:\u0001(B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%B\t\b\u0016\u00a2\u0006\u0004\b$\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010#\u001a\u00020\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Dh", "Eh", "Ch", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "P", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/biz/mainpage/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/mainpage/b;", "recyclerViewAdapter", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "Mh", "()Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;)V", "()V", ExifInterface.LATITUDE_SOUTH, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECBaseMainPageFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECBaseRecyclerView recyclerView;

    /* renamed from: Q, reason: from kotlin metadata */
    private b recyclerViewAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    private final ECMainPageFragmentType type;

    public ECBaseMainPageFragment(ECMainPageFragmentType eCMainPageFragmentType) {
        this.type = eCMainPageFragmentType;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Ch() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    public abstract List<ECMainPageItem> Lh();

    /* renamed from: Mh, reason: from getter */
    public ECMainPageFragmentType getType() {
        return this.type;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    public String getBusinessDescription() {
        return "ECMainPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167341cs4;
    }

    protected void initView(View rootView) {
        rootView.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
        this.recyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nx7);
        b bVar = new b(requireContext());
        this.recyclerViewAdapter = bVar;
        bVar.setData(Lh());
        ECBaseRecyclerView eCBaseRecyclerView = this.recyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        b bVar2 = this.recyclerViewAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(bVar2);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    public ECBaseMainPageFragment() {
        this(ECMainPageFragmentType.MAIN_PAGE_TYPE_OTHER);
    }
}
