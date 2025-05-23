package com.tencent.mobileqq.troop.appscenter.mvi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020\u000f\u00a2\u0006\u0004\b0\u00101J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001aR\u0017\u0010.\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/mvi/m;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "appInfo", "", "isAdmin", "isEdit", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "position", "", "appId", "tabName", "t", "Landroid/view/View;", "view", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "appIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "appName", "G", "appDesc", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "o", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "appBtn", "I", "r", "()Landroid/widget/TextView;", "appOrder", "J", "appDone", "K", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/View;", "appLine", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView appIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView appName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView appDesc;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QUIButton appBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView appOrder;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView appDone;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View appLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.stw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.app_rank_item_icon)");
        this.appIcon = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.sty);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.app_rank_item_name)");
        this.appName = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.stu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.app_rank_item_desc)");
        this.appDesc = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.stt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.app_rank_item_btn)");
        this.appBtn = (QUIButton) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.stz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.app_rank_item_order)");
        this.appOrder = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.stv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.app_rank_item_done)");
        this.appDone = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.stx);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.app_rank_item_line)");
        this.appLine = findViewById7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map u(int i3, String appId, String tabName, String str) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(tabName, "$tabName");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("item_index", Integer.valueOf(i3)), TuplesKt.to("appid", appId), TuplesKt.to("tab_name", tabName));
        return hashMapOf;
    }

    public final void m(@NotNull AppDetail appInfo, boolean isAdmin, boolean isEdit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInfo, Boolean.valueOf(isAdmin), Boolean.valueOf(isEdit));
            return;
        }
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.appName.setText(appInfo.name);
        this.appDesc.setText(appInfo.desc);
        if (isAdmin && isEdit && appInfo.getAdded() == 1) {
            this.appDone.setText(this.itemView.getContext().getString(R.string.bct));
            this.appBtn.setVisibility(8);
            this.appDone.setVisibility(0);
        } else if (isAdmin && isEdit && appInfo.getAdded() == 0) {
            this.appBtn.setText(this.itemView.getContext().getString(R.string.un9));
            this.appBtn.setVisibility(0);
            this.appDone.setVisibility(4);
        } else {
            this.appBtn.setText("\u4f7f\u7528");
            this.appBtn.setVisibility(0);
            this.appDone.setVisibility(4);
        }
    }

    @NotNull
    public final QUIButton o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUIButton) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appBtn;
    }

    @NotNull
    public final ImageView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appIcon;
    }

    @NotNull
    public final View q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appLine;
    }

    @NotNull
    public final TextView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appOrder;
    }

    public final void s(@NotNull View view, int position, @NotNull String appId, @NotNull String tabName) {
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(position), appId, tabName);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("item_index", Integer.valueOf(position)), TuplesKt.to("appid", appId), TuplesKt.to("tab_name", tabName));
        VideoReport.setElementId(view, "em_group_rank_item");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, hashMapOf);
    }

    public final void t(final int position, @NotNull final String appId, @NotNull final String tabName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(position), appId, tabName);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        VideoReport.setElementId(this.itemView, "em_group_rank_item");
        VideoReport.setEventDynamicParams(this.itemView, new IDynamicParams() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.l
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map u16;
                u16 = m.u(position, appId, tabName, str);
                return u16;
            }
        });
        VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.itemView, ClickPolicy.REPORT_NONE);
    }
}
