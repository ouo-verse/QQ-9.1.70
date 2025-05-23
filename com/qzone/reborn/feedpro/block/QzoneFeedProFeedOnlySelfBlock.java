package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.userhome.QzoneFeedProMemorySealContainerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\u000e\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fJ$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0014J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFeedProFeedOnlySelfBlock;", "Lcom/qzone/reborn/base/m;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "memory", "", "p0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroidx/lifecycle/MutableLiveData;", "sealOffMemory", "n0", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "onBindViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "mSealOffMemory", "Lcom/qzone/reborn/feedpro/widget/userhome/QzoneFeedProMemorySealContainerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/userhome/QzoneFeedProMemorySealContainerView;", "mContainerView", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProFeedOnlySelfBlock extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProMemorySealContainerView mContainerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<SealOffMemory> mSealOffMemory;

    public QzoneFeedProFeedOnlySelfBlock(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(SealOffMemory memory) {
        QzoneFeedProMemorySealContainerView qzoneFeedProMemorySealContainerView = this.mContainerView;
        if (qzoneFeedProMemorySealContainerView != null) {
            qzoneFeedProMemorySealContainerView.o0(memory);
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QzoneFeedProMemorySealContainerView qzoneFeedProMemorySealContainerView = new QzoneFeedProMemorySealContainerView(getActivity());
        qzoneFeedProMemorySealContainerView.setHostActivity(getActivity());
        qzoneFeedProMemorySealContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mContainerView = qzoneFeedProMemorySealContainerView;
        return qzoneFeedProMemorySealContainerView;
    }

    public final void n0(MutableLiveData<SealOffMemory> sealOffMemory) {
        this.mSealOffMemory = sealOffMemory;
        LifecycleOwner i06 = i0();
        if (i06 == null || sealOffMemory == null) {
            return;
        }
        final Function1<SealOffMemory, Unit> function1 = new Function1<SealOffMemory, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProFeedOnlySelfBlock$initObserve$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SealOffMemory sealOffMemory2) {
                invoke2(sealOffMemory2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SealOffMemory sealOffMemory2) {
                QzoneFeedProFeedOnlySelfBlock.this.p0(sealOffMemory2);
            }
        };
        sealOffMemory.observe(i06, new Observer() { // from class: com.qzone.reborn.feedpro.block.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProFeedOnlySelfBlock.o0(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        MutableLiveData<SealOffMemory> mutableLiveData = this.mSealOffMemory;
        p0(mutableLiveData != null ? mutableLiveData.getValue() : null);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
