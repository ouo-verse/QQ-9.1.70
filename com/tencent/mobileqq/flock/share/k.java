package com.tencent.mobileqq.flock.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flock.share.action.FlockShareActionFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/flock/share/k;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/flock/share/e;", "shareParam", "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "params", "f", "g", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f210444a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f210444a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(Context context, e shareParam) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> a16;
        View pageView;
        View view = new View(context);
        String str = null;
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null && (pageView = pageInfo.getPageView()) != null) {
            com.tencent.mobileqq.flock.datong.c.b(view, pageView);
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("qq_eid", "em_bas_sharing_panel");
        f k3 = shareParam.k();
        if (k3 != null) {
            str = k3.b();
        }
        pairArr[1] = TuplesKt.to("qq_pgid", String.valueOf(str));
        pairArr[2] = TuplesKt.to("activity_result_id", shareParam.g().f449366a);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        f k16 = shareParam.k();
        if (k16 != null && (a16 = k16.a()) != null) {
            mutableMapOf.putAll(a16);
        }
        com.tencent.mobileqq.flock.datong.c.a("qq_imp", view, "em_bas_sharing_panel", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    private final void f(Activity activity, ShareActionSheetBuilder.ActionSheetItem item, e params) {
        com.tencent.mobileqq.flock.share.action.f a16 = FlockShareActionFactory.f210413a.a(item.action);
        if (a16 != null) {
            a16.a(activity, item, params);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(e shareParam, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        RFWLog.i("FlockShareUtil", RFWLog.USR, "share, onShow ");
        d o16 = shareParam.o();
        if (o16 != null) {
            o16.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e shareParam, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        RFWLog.i("FlockShareUtil", RFWLog.USR, "share, onDismiss ");
        d o16 = shareParam.o();
        if (o16 != null) {
            o16.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e shareParam, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        RFWLog.i("FlockShareUtil", RFWLog.USR, "share, onCancel ");
        d o16 = shareParam.o();
        if (o16 != null) {
            o16.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Activity activity, e shareParam, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        k kVar = f210444a;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        kVar.f(activity, item, shareParam);
        shareActionSheet.dismiss();
    }

    public final void g(@NotNull final Activity activity, @NotNull final e shareParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) shareParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        if (FastClickUtils.isFastDoubleClick(String.valueOf(activity.hashCode()))) {
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intent intent = activity.getIntent();
        intent.putExtra("big_brother_source_key", "biz_src_unknown");
        create.setIntentForStartForwardRecentActivity(intent);
        create.setRowVisibility(shareParam.h(), shareParam.m(), shareParam.p());
        create.setActionSheetItems(shareParam.j(), shareParam.i());
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.flock.share.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                k.h(e.this, dialogInterface);
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.flock.share.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                k.i(e.this, dialogInterface);
            }
        });
        create.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.flock.share.i
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                k.j(e.this, dialogInterface);
            }
        });
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.flock.share.j
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                k.k(activity, shareParam, actionSheetItem, shareActionSheet);
            }
        });
        shareParam.q();
        create.show();
        f210444a.e(activity, shareParam);
    }
}
