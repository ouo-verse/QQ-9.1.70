package com.qzone.reborn.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.extendsblock.SingleViewBlock;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import cooperation.qzone.util.ProcessUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0014J-\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\f*\u0004\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/base/m;", "Lcom/tencent/biz/richframework/part/extendsblock/SingleViewBlock;", "Lcom/qzone/reborn/feedx/viewmodel/c;", "", "hasFocus", "", "k0", "Landroid/content/res/Configuration;", "newConfig", "j0", "onInit", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "viewModelClass", "W", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/app/Activity;", "getActivity", "Landroidx/lifecycle/LifecycleOwner;", "i0", "Landroid/os/Bundle;", "initParams", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class m extends SingleViewBlock implements com.qzone.reborn.feedx.viewmodel.c {
    public m(Bundle bundle) {
        super(bundle);
    }

    @Override // com.qzone.reborn.feedx.viewmodel.c
    public <T extends ViewModel> T W(Class<T> viewModelClass) {
        BlockPart blockPart;
        BlockPart blockPart2;
        BlockPart blockPart3;
        BlockMerger blockMerger = getBlockMerger();
        Activity activity = null;
        T t16 = (blockMerger == null || (blockPart3 = blockMerger.getBlockPart()) == null) ? null : (T) blockPart3.getViewModel(viewModelClass);
        if (t16 == null) {
            String name = getClass().getName();
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            BlockMerger blockMerger2 = getBlockMerger();
            BlockMerger blockMerger3 = getBlockMerger();
            BlockPart blockPart4 = blockMerger3 != null ? blockMerger3.getBlockPart() : null;
            BlockMerger blockMerger4 = getBlockMerger();
            IPartHost partHost = (blockMerger4 == null || (blockPart2 = blockMerger4.getBlockPart()) == null) ? null : blockPart2.getPartHost();
            BlockMerger blockMerger5 = getBlockMerger();
            if (blockMerger5 != null && (blockPart = blockMerger5.getBlockPart()) != null) {
                activity = blockPart.getActivity();
            }
            objArr[0] = "block provideViewModel is null, blockMerger: " + blockMerger2 + "blockPart: " + blockPart4 + "partHost: " + partHost + "partActivity: " + activity + Log.getStackTraceString(new Throwable());
            RFWLog.e(name, i3, objArr);
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public Activity getActivity() {
        Activity hostActivity = super.getActivity();
        if (hostActivity == null) {
            String name = getClass().getName();
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            BlockMerger blockMerger = getBlockMerger();
            BlockContainer blockContainer = getBlockContainer();
            BlockContainer blockContainer2 = getBlockContainer();
            Fragment fragment = blockContainer2 != null ? blockContainer2.getFragment() : null;
            objArr[0] = "block activity is null, blockMerger: " + blockMerger + "blockContainer: " + blockContainer + "parentFragment: " + fragment + Log.getStackTraceString(new Throwable());
            RFWLog.e(name, i3, objArr);
            hostActivity = ProcessUtils.getTopActivity();
        }
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        return hostActivity;
    }

    public final LifecycleOwner i0() {
        if (getBlockMerger() == null || getBlockMerger().getBlockPart() == null || getBlockMerger().getBlockPart().getPartHost() == null) {
            return null;
        }
        return getBlockMerger().getBlockPart().getPartHost().getLifecycleOwner();
    }

    public void j0(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInit() {
        jo.h hVar = jo.h.f410717a;
        jo.d g16 = hVar.g("block_init");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        g16.h(simpleName);
        super.onInit();
        jo.d g17 = hVar.g("block_init");
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
        g17.b(simpleName2);
    }

    public void k0(boolean hasFocus) {
    }
}
