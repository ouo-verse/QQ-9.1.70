package com.tencent.mobileqq.zplan.minihome.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.zplan.minihome.GiftPopSource;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GiftRewardDesc;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qzone.QZoneHelper;
import fi3.bh;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\b\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeRewardDialog;", "Landroid/app/Dialog;", "", "e", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/mobileqq/zplan/minihome/x;", "d", "Lcom/tencent/mobileqq/zplan/minihome/x;", "rewardDesc", "Lcom/tencent/mobileqq/zplan/minihome/w;", "Lcom/tencent/mobileqq/zplan/minihome/w;", "getReportInfo", "()Lcom/tencent/mobileqq/zplan/minihome/w;", CacheTable.TABLE_NAME, "Lfi3/bh;", "f", "Lkotlin/Lazy;", "()Lfi3/bh;", "binding", "", tl.h.F, "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/minihome/x;Lcom/tencent/mobileqq/zplan/minihome/w;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeRewardDialog extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GiftRewardDesc rewardDesc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final GiftReportInfo reportInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeRewardDialog(final Context context, GiftRewardDesc rewardDesc, GiftReportInfo reportInfo) {
        super(context, R.style.f243370m);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rewardDesc, "rewardDesc");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        this.rewardDesc = rewardDesc;
        this.reportInfo = reportInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bh>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeRewardDialog$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bh invoke() {
                return bh.g(LayoutInflater.from(context));
            }
        });
        this.binding = lazy;
        this.TAG = "MiniHomeRewardDialog";
        e();
    }

    private final bh d() {
        return (bh) this.binding.getValue();
    }

    private final void e() {
        HashMap hashMapOf;
        if (this.reportInfo.getSource() == GiftPopSource.MINI_CONNECT) {
            return;
        }
        VideoReport.setPageId(d().getRoot(), "pg_user_profile_new");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(ProfileCardConst.IS_BLACK_LIST, Integer.valueOf(((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).getProfileCardBlacklistReportType(bb.f335811a.e()))));
        VideoReport.setPageContentId(d().getRoot(), QZoneHelper.QZONE_PRELOAD_FROM_FRIEND_PROFILE);
        VideoReport.setPageParams(d().getRoot(), new PageParams(hashMapOf));
        VideoReport.setElementId(d().f399095e, "em_zplan_gift_pop");
        VideoReport.setElementExposePolicy(d().f399095e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(d().f399095e, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MiniHomeRewardDialog this$0, QUIButton this_apply, View view) {
        Map mapOf;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this$0.rewardDesc.getOkButtonJumpScheme().length() > 0) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, this$0.rewardDesc.getOkButtonJumpScheme());
            this$0.dismiss();
        } else {
            this$0.dismiss();
        }
        if (this$0.reportInfo.getSource() == GiftPopSource.FRIEND_PROFILE_CARD) {
            QUIButton qUIButton = this$0.d().f399095e;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, this$0.rewardDesc.getReportData()));
            VideoReport.reportEvent("clck", qUIButton, hashMapOf);
        } else if (this$0.reportInfo.getSource() == GiftPopSource.MINI_CONNECT) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, this$0.rewardDesc.getReportData());
            pairArr[2] = TuplesKt.to("zplan_action_type", "click");
            MapMode mapMode = this$0.reportInfo.getMapMode();
            pairArr[3] = TuplesKt.to("zplan_map_state", Integer.valueOf(mapMode != null ? mapMode.getValue() + 1 : -1));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.reportEvent("ev_zplan_xiaowo_link_gift_pop", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MiniHomeRewardDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        String replace$default;
        Map mapOf;
        HashMap hashMapOf;
        super.onCreate(savedInstanceState);
        super.setContentView(d().getRoot());
        String awardBackgroundPicUrl = this.rewardDesc.getAwardBackgroundPicUrl();
        if (awardBackgroundPicUrl.length() > 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(awardBackgroundPicUrl, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(\n           \u2026          }\n            )");
            d().f399093c.setImageDrawable(drawable2);
        }
        if (this.rewardDesc.getAwardPicUrl().length() > 0) {
            String awardPicUrl = this.rewardDesc.getAwardPicUrl();
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable3 = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain2.mFailedDrawable = drawable3;
            obtain2.mLoadingDrawable = drawable3;
            URLDrawable drawable4 = URLDrawable.getDrawable(awardPicUrl, obtain2);
            Intrinsics.checkNotNullExpressionValue(drawable4, "getDrawable(\n           \u2026          }\n            )");
            d().f399094d.setImageDrawable(drawable4);
        }
        QLog.i(this.TAG, 1, "rewardDesc.awardText: " + this.rewardDesc.getAwardText());
        TextView textView = d().f399096f;
        replace$default = StringsKt__StringsJVMKt.replace$default(this.rewardDesc.getAwardText(), RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
        textView.setText(replace$default);
        final QUIButton qUIButton = d().f399095e;
        qUIButton.setText(this.rewardDesc.getOkButtonText());
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeRewardDialog.f(MiniHomeRewardDialog.this, qUIButton, view);
            }
        });
        d().f399092b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeRewardDialog.g(MiniHomeRewardDialog.this, view);
            }
        });
        if (this.reportInfo.getSource() == GiftPopSource.FRIEND_PROFILE_CARD) {
            QUIButton qUIButton2 = d().f399095e;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, this.rewardDesc.getReportData()));
            VideoReport.reportEvent("imp", qUIButton2, hashMapOf);
        } else if (this.reportInfo.getSource() == GiftPopSource.MINI_CONNECT) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_TYPE, this.rewardDesc.getReportData());
            pairArr[2] = TuplesKt.to("zplan_action_type", "imp");
            MapMode mapMode = this.reportInfo.getMapMode();
            pairArr[3] = TuplesKt.to("zplan_map_state", Integer.valueOf(mapMode != null ? mapMode.getValue() + 1 : -1));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.reportEvent("ev_zplan_xiaowo_link_gift_pop", mapOf);
        }
    }
}
