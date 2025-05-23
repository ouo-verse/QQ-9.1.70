package com.qzone.reborn.feedx.block;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneLoadingStateView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001#\u0018\u0000 )2\u00020\u0001:\u0001*B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0014J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock;", "Lcom/qzone/reborn/base/m;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "n0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getPageType", "()I", "setPageType", "(I)V", "pageType", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsLoadingState", "Lcom/qzone/reborn/feedx/widget/QZoneLoadingStateView;", "D", "Lcom/qzone/reborn/feedx/widget/QZoneLoadingStateView;", "mLoadingStateView", "com/qzone/reborn/feedx/block/QZoneLoadingStateBlock$mLoadingRunnable$1", "E", "Lcom/qzone/reborn/feedx/block/QZoneLoadingStateBlock$mLoadingRunnable$1;", "mLoadingRunnable", "<init>", "(Landroid/os/Bundle;I)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLoadingStateBlock extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsLoadingState;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneLoadingStateView mLoadingStateView;

    /* renamed from: E, reason: from kotlin metadata */
    private final QZoneLoadingStateBlock$mLoadingRunnable$1 mLoadingRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int pageType;

    /* JADX WARN: Type inference failed for: r1v2, types: [com.qzone.reborn.feedx.block.QZoneLoadingStateBlock$mLoadingRunnable$1] */
    public QZoneLoadingStateBlock(Bundle bundle, int i3) {
        super(bundle);
        this.pageType = i3;
        this.mIsLoadingState = true;
        this.mLoadingRunnable = new Runnable() { // from class: com.qzone.reborn.feedx.block.QZoneLoadingStateBlock$mLoadingRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                Activity activity2;
                boolean z16;
                boolean z17;
                activity = QZoneLoadingStateBlock.this.getActivity();
                if (!activity.isDestroyed()) {
                    activity2 = QZoneLoadingStateBlock.this.getActivity();
                    if (!activity2.isFinishing()) {
                        int i16 = RFWLog.USR;
                        z16 = QZoneLoadingStateBlock.this.mIsLoadingState;
                        RFWLog.i("QZoneLoadingStateBlock", i16, "load runnable loading state=" + z16);
                        z17 = QZoneLoadingStateBlock.this.mIsLoadingState;
                        if (z17) {
                            QZoneLoadingStateBlock.this.setBlockVisible(true);
                            return;
                        }
                        return;
                    }
                }
                RFWLog.e("QZoneLoadingStateBlock", RFWLog.USR, "load runnable activity isDestroyed");
            }
        };
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneLoadingStateView qZoneLoadingStateView = new QZoneLoadingStateView(context);
        this.mLoadingStateView = qZoneLoadingStateView;
        Intrinsics.checkNotNull(qZoneLoadingStateView);
        qZoneLoadingStateView.setData(Integer.valueOf(this.pageType));
        QZoneLoadingStateView qZoneLoadingStateView2 = this.mLoadingStateView;
        Intrinsics.checkNotNull(qZoneLoadingStateView2);
        return qZoneLoadingStateView2;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWThreadManager.getUIHandler().removeCallbacks(this.mLoadingRunnable);
    }

    public final void n0() {
        this.mIsLoadingState = false;
        setBlockVisible(false);
        RFWThreadManager.getUIHandler().removeCallbacks(this.mLoadingRunnable);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        setBlockVisible(false);
        RFWThreadManager.getUIHandler().postDelayed(this.mLoadingRunnable, com.qzone.reborn.configx.g.f53821a.b().r1());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
