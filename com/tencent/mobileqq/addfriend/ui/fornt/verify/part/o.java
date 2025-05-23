package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R2\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/o;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "", "ga", "ca", "ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mReportText", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/RelativeLayout;", "titleRoot", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/HashMap;", "mAddTypeMap", "<init>", "()V", "T", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView mReportText;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout titleRoot;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private HashMap<Integer, Integer> mAddTypeMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/o$a;", "", "", "ADD_FRIEND_REPORT_APP_ID", "Ljava/lang/String;", "EXTRA_APP_ID_KEY", "", "SECURE_MOBILE_TYPE", "I", "SECURE_OPEN_ID_TYPE", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.o$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o() {
        HashMap<Integer, Integer> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 1), TuplesKt.to(3, 2), TuplesKt.to(4, 3));
            this.mAddTypeMap = hashMapOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ca() {
        ea();
        TextView textView = this.mReportText;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.da(o.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("clck", this$0.mReportText, null);
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i("100864");
        bVar.n(this$0.D9());
        bVar.o(2);
        bVar.j("0");
        bVar.s(1);
        Integer P9 = this$0.P9();
        if (P9 != null && P9.intValue() == 3) {
            Bundle bundle = new Bundle();
            bundle.putInt("open_appid", Integer.parseInt(this$0.F9()));
            bVar.p(bundle);
        }
        if (this$0.G9()) {
            bVar.o(10);
        }
        if (this$0.I9() || this$0.J9() || this$0.K9()) {
            bVar.o(6);
        }
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(this$0.R9(), bVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ea() {
        TextView textView = this.mReportText;
        if (textView == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, "pg_add_user");
        HashMap hashMap = new HashMap();
        int intExtra = getIntent().getIntExtra("friend_setting", 0);
        if (this.mAddTypeMap.containsKey(Integer.valueOf(intExtra))) {
            hashMap.put("add_type", this.mAddTypeMap.get(Integer.valueOf(intExtra)));
        }
        VideoReport.setPageParams(this.titleRoot, new PageParams(hashMap));
        VideoReport.setElementId(textView, "em_add_report_user");
        VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_NONE);
    }

    private final void ga() {
        QIphoneTitleBarFragment qIphoneTitleBarFragment;
        this.mReportText = (TextView) getPartRootView().findViewById(R.id.sd8);
        IPartHost partHost = getPartHost();
        RelativeLayout relativeLayout = null;
        if (partHost instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment = (QIphoneTitleBarFragment) partHost;
        } else {
            qIphoneTitleBarFragment = null;
        }
        if (qIphoneTitleBarFragment != null) {
            relativeLayout = qIphoneTitleBarFragment.titleRoot;
        }
        this.titleRoot = relativeLayout;
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ga();
        ca();
    }
}
