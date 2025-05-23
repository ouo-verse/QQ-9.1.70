package com.qzone.reborn.share;

import android.app.Dialog;
import android.content.Intent;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\b\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\"\u0010'\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010)\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\"J\u0006\u0010*\u001a\u00020\u0018R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00103\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/share/a;", "", "Lcom/qzone/reborn/share/e;", "shareContext", "", "j", "i", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", DomainData.DOMAIN_NAME, "", "", "leaveMsg", "e", "c", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "Lcom/tencent/mobileqq/sharepanel/o;", "d", NodeProps.VISIBLE, "", "k", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", "resId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Lcom/qzone/reborn/share/i;", "Lcom/qzone/reborn/share/i;", tl.h.F, "()Lcom/qzone/reborn/share/i;", "p", "(Lcom/qzone/reborn/share/i;)V", "viewModel", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "waitingDialog", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private i viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Dialog waitingDialog;

    public final void a() {
        try {
            Dialog dialog = this.waitingDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public abstract void b(e shareContext, b item);

    public boolean c(e shareContext, List<? extends ResultRecord> targetList) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        return false;
    }

    public boolean d(e shareContext, ShareConfirmAction action, o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return false;
    }

    public boolean e(e shareContext, List<? extends ResultRecord> targetList, String leaveMsg) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        return false;
    }

    public abstract QQShareActionManagerV2.ShareLine f();

    public abstract List<String> g();

    /* renamed from: h, reason: from getter */
    public final i getViewModel() {
        return this.viewModel;
    }

    public boolean i(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public boolean j(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public void k(e shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
    }

    public void m(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
    }

    public boolean n(e shareContext, ArrayList<ResultRecord> targetList, m callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return false;
    }

    public final void p(i iVar) {
        this.viewModel = iVar;
    }

    public final void q(e shareContext, int resId) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().isFinishing()) {
            return;
        }
        if (this.waitingDialog != null) {
            a();
        }
        this.waitingDialog = DialogUtil.showProgressDialog(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), resId);
    }

    public void o() {
        this.viewModel = null;
    }

    public void l(int requestCode, int resultCode, Intent data) {
    }
}
