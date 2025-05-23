package com.tencent.mobileqq.activity.contact.addcontact.gridentrance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/g;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/d;", "itemModel", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "entranceIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "entranceText", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends com.tencent.mobileqq.widget.gridpage.c {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView entranceIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView entranceText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/g$a;", "", "", "DT_ELEMENT_ID_ENTRANCE", "Ljava/lang/String;", "DT_ELEMENT_ID_ENTRANCE_PARAM_KEY", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.gridentrance.g$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.f165101uw1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.entrance_icon)");
        this.entranceIcon = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f165104uw4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.entrance_text)");
        this.entranceText = (TextView) findViewById2;
    }

    public final void l(@NotNull d itemModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemModel);
            return;
        }
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        this.itemView.setId(itemModel.d());
        this.entranceIcon.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), itemModel.a()));
        this.entranceText.setText(itemModel.c());
        if (AppSetting.f99565y) {
            this.entranceText.setContentDescription(itemModel.c());
        }
        VideoReport.setElementId(this.itemView, "em_find_people_pg_entrance");
        View view = this.itemView;
        HashMap hashMap = new HashMap();
        hashMap.put("search_people_entrance_id", Integer.valueOf(itemModel.b()));
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementClickPolicy(this.itemView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.itemView, EndExposurePolicy.REPORT_ALL);
    }
}
