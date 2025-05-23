package com.qzone.reborn.albumx.common.share;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.common.share.b;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016J\"\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/a;", "Lcom/qzone/reborn/albumx/common/share/b;", "T", "", "shareContext", "", "f", "(Lcom/qzone/reborn/albumx/common/share/b;)Z", "e", NodeProps.VISIBLE, "", "g", "(Lcom/qzone/reborn/albumx/common/share/b;Z)V", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Lcom/qzone/reborn/albumx/common/share/b;Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)V", "i", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", h.F, "Landroidx/lifecycle/ViewModel;", "d", "Landroidx/lifecycle/ViewModel;", "()Landroidx/lifecycle/ViewModel;", "j", "(Landroidx/lifecycle/ViewModel;)V", "viewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class a<T extends b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewModel viewModel;

    public abstract void a(T shareContext, ShareActionSheetBuilder.ActionSheetItem item);

    public abstract QQShareActionManager.ShareLine b();

    public abstract List<Integer> c();

    /* renamed from: d, reason: from getter */
    public final ViewModel getViewModel() {
        return this.viewModel;
    }

    public boolean e() {
        return true;
    }

    public boolean f(T shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public void g(T shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
    }

    public final void j(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void i() {
        this.viewModel = null;
    }

    public void h(int requestCode, int resultCode, Intent data) {
    }
}
