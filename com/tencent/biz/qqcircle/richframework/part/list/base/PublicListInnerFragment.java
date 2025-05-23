package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageInteractiveListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSPYMKListBlock;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class PublicListInnerFragment extends QFSBaseFragment {
    protected BlockPart E;
    protected BaseListBlock F;
    private MultiViewBlock G;
    private BaseListBlock H;
    private b I;
    private int J = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            BaseListBlock baseListBlock = PublicListInnerFragment.this.F;
            if (baseListBlock != null && baseListBlock.getDropFrameMonitorTag() != null) {
                if (i3 == 0) {
                    QCircleHostDropFrameMonitorHelper.stopMonitorScene(PublicListInnerFragment.this.F.getDropFrameMonitorTag(), false);
                } else {
                    QCircleHostDropFrameMonitorHelper.startMonitorScene(PublicListInnerFragment.this.F.getDropFrameMonitorTag());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BlockPart {
        public b(int i3, List<MultiViewBlock> list, int i16, int i17) {
            super(i3, list, i16, i17);
        }
    }

    public static PublicListInnerFragment Ah(@Nullable String str) {
        PublicListInnerFragment publicListInnerFragment = new PublicListInnerFragment();
        if (str != null) {
            Bundle bundle = new Bundle();
            bundle.putString("base_list_empty_block_clazz", str);
            publicListInnerFragment.setArguments(bundle);
        }
        return publicListInnerFragment;
    }

    private List<MultiViewBlock> Bh(String str) {
        ArrayList arrayList = new ArrayList();
        BaseListBlock wh5 = wh(str);
        this.H = wh5;
        if (wh5 instanceof QFSPYMKListBlock) {
            ((QFSPYMKListBlock) wh5).setEventKey("" + this.J);
        }
        arrayList.add(this.H);
        return arrayList;
    }

    @Nullable
    private String th() {
        if (getArguments() != null) {
            String string = getArguments().getString("base_list_empty_block_clazz");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return null;
        }
        return null;
    }

    private boolean zh() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock == null) {
            return true;
        }
        return baseListBlock.isEnableRefresh();
    }

    protected List<MultiViewBlock> Ch() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.F);
        MultiViewBlock xh5 = xh("base_list_end_block_class");
        this.G = xh5;
        if (xh5 != null) {
            arrayList.add(xh5);
        }
        return arrayList;
    }

    public void Dh() {
        BlockContainer blockContainer;
        BlockPart blockPart = this.E;
        if (blockPart != null) {
            blockContainer = blockPart.getBlockContainer();
        } else {
            blockContainer = null;
        }
        MultiViewBlock multiViewBlock = this.G;
        if (multiViewBlock != null && blockContainer != null) {
            blockContainer.registerBlock(multiViewBlock);
        }
    }

    public void Eh(BaseListBlock baseListBlock, int i3) {
        this.F = baseListBlock;
        QLog.d("PublicListInnerFragment", 1, "setBlockPart:" + i3);
        if (this.F instanceof QFSMessageInteractiveListBlock) {
            QLog.d("PublicListInnerFragment", 1, "setEventKey:" + i3);
            ((QFSMessageInteractiveListBlock) this.F).setEventKey("" + i3);
        }
        this.J = i3;
    }

    public void Fh(int i3) {
        this.J = i3;
    }

    public boolean Gh() {
        b bVar = this.I;
        if (bVar == null || bVar.getBlockContainer() == null || this.H == null) {
            return false;
        }
        QLog.d("PublicListInnerFragment", 1, "registerEmptyBlock cpv_component_view_pymk");
        this.I.getBlockContainer().setVisibility(0);
        this.I.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.E.getBlockContainer().setVisibility(4);
        return true;
    }

    public void Hh() {
        BlockContainer blockContainer;
        BlockPart blockPart = this.E;
        if (blockPart != null) {
            blockContainer = blockPart.getBlockContainer();
        } else {
            blockContainer = null;
        }
        MultiViewBlock multiViewBlock = this.G;
        if (multiViewBlock != null && blockContainer != null) {
            blockContainer.unRegisterBlock(multiViewBlock);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> customParts;
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.uaf, Ch(), 3, 1);
        this.E = blockPart;
        arrayList.add(blockPart);
        String th5 = th();
        if (th5 != null) {
            b bVar = new b(R.id.uag, Bh(th5), 3, 1);
            this.I = bVar;
            arrayList.add(bVar);
        }
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null && (customParts = baseListBlock.getCustomParts()) != null && customParts.size() > 0) {
            arrayList.addAll(customParts);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null) {
            return baseListBlock.getChildDaTongPageParams();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null && baseListBlock.getContentLayoutId() != 0) {
            return this.F.getContentLayoutId();
        }
        return R.layout.g5a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null) {
            return baseListBlock.getDaTongPageId();
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublicListInnerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null) {
            if (baseListBlock.isNeedQUIColor()) {
                return QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_standard);
            }
            return this.F.getStatusBarColor();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        yh();
    }

    protected int rh() {
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null) {
            if (baseListBlock.isNeedQUIColor()) {
                return QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_standard);
            }
            return this.F.getBackgroundColor();
        }
        return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    PublicListInnerFragment.this.registerDaTongReportPageId();
                }
            }, 100L, true);
        }
    }

    public BlockContainer sh() {
        BlockPart blockPart = this.E;
        if (blockPart != null) {
            return blockPart.getBlockContainer();
        }
        return null;
    }

    public MultiViewBlock uh() {
        return this.G;
    }

    public void vh() {
        String str;
        String str2;
        BlockPart blockPart = this.E;
        if (blockPart != null && blockPart.getBlockContainer() != null && this.H != null) {
            QLog.d("PublicListInnerFragment", 1, "unRegisterEmptyBlock");
            this.I.getBlockContainer().setVisibility(4);
            this.E.getBlockContainer().setVisibility(0);
            return;
        }
        BlockPart blockPart2 = this.E;
        String str3 = "";
        if (blockPart2 == null) {
            str = "";
        } else {
            str = blockPart2.toString();
        }
        BlockPart blockPart3 = this.E;
        if (blockPart3 == null || blockPart3.getBlockContainer() == null) {
            str2 = "";
        } else {
            str2 = this.E.getBlockContainer().toString();
        }
        BaseListBlock baseListBlock = this.H;
        if (baseListBlock != null) {
            str3 = baseListBlock.toString();
        }
        QLog.d("PublicListInnerFragment", 1, "unRegisterEmptyBlock failed " + str + " " + str2 + " " + str3);
    }

    public BaseListBlock wh(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (BaseListBlock) Class.forName(str).getConstructor(Bundle.class).newInstance(getActivity().getIntent().getExtras());
        } catch (Exception e16) {
            QLog.e("PublicListInnerFragment", 1, "initAdapterError" + e16.getMessage());
            return null;
        }
    }

    protected MultiViewBlock xh(String str) {
        Intent intent;
        String str2;
        MultiViewBlock multiViewBlock;
        if (getActivity() == null) {
            intent = null;
        } else {
            intent = getActivity().getIntent();
        }
        if (intent == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && intent.hasExtra(str)) {
            str2 = (String) RFSafeListUtils.get(intent.getStringArrayListExtra(str), this.J);
        } else {
            str2 = "";
        }
        try {
            intent.putExtra(BaseListBlock.PAGE_BLOCK_POSITION, this.J);
            if (!TextUtils.isEmpty(str2)) {
                multiViewBlock = (MultiViewBlock) Class.forName(str2).getConstructor(Bundle.class).newInstance(getActivity().getIntent().getExtras());
            } else {
                multiViewBlock = null;
            }
            if (multiViewBlock == null) {
                return null;
            }
            if (intent.hasExtra("base_list_init_data")) {
                multiViewBlock.setDatas((ArrayList) intent.getSerializableExtra("base_list_init_data"));
            }
            if (intent.hasExtra("key_bundle_common_init_bean") && (multiViewBlock instanceof BaseListBlock)) {
                ((BaseListBlock) multiViewBlock).setInitBean(intent.getSerializableExtra("key_bundle_common_init_bean"));
            }
            return multiViewBlock;
        } catch (Exception e16) {
            QLog.e("PublicListInnerFragment", 1, "initBlock error" + e16.getMessage());
            return null;
        }
    }

    protected void yh() {
        this.E.getBlockContainer().setEnableRefresh(zh());
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        this.E.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        BaseListBlock baseListBlock = this.F;
        if (baseListBlock != null && !baseListBlock.isNeedQUIBackgroundDrawable()) {
            this.E.getBlockContainer().getRecyclerView().setBackgroundColor(rh());
        }
        this.E.getBlockContainer().getRecyclerView().addOnScrollListener(new a());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    protected void pushPageScene() {
    }
}
