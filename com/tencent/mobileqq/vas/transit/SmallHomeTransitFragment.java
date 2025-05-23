package com.tencent.mobileqq.vas.transit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.v;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/SmallHomeTransitFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "finishActivity", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeTransitFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/SmallHomeTransitFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "pageInfo", "Landroid/os/Bundle;", "extBundle", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "a", "", "KEY_PAGE_INFO", "Ljava/lang/String;", "KEY_SOURCE_FROM", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.transit.SmallHomeTransitFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, TransitPageInfo pageInfo, Bundle extBundle, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            Intrinsics.checkNotNullParameter(source, "source");
            if (!TransitPageInfo.INSTANCE.a(pageInfo)) {
                v.f373305a.c(R.string.xhl, "invalid pageInfo");
                QLog.e("SmallHomeTransitFragment", 1, "invalid pageInfo");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("transit_page_info", pageInfo);
            intent.putExtra("transit_source_from", source);
            intent.putExtra("public_fragment_window_feature", 1);
            if (extBundle != null) {
                intent.putExtras(extBundle);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, SmallHomeTransitFragment.class);
        }

        Companion() {
        }
    }

    private final void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("transit_source_from") : null;
        ZootopiaSource zootopiaSource = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
        Bundle arguments2 = getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("transit_page_info") : null;
        TransitPageInfo transitPageInfo = serializable2 instanceof TransitPageInfo ? (TransitPageInfo) serializable2 : null;
        if (zootopiaSource != null && transitPageInfo != null) {
            FragmentActivity activity = getActivity();
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? activity : null;
            if (fragmentActivity == null) {
                QLog.e("SmallHomeTransitFragment", 1, "targetActivity is null");
                finishActivity();
                return;
            }
            ZplanVasSmallHomeGroupFragment a16 = ZplanVasSmallHomeGroupFragment.INSTANCE.a(transitPageInfo, zootopiaSource);
            QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "targetActivity.supportFragmentManager");
            IZootopiaC2CApi.a.a((IZootopiaC2CApi) api, supportFragmentManager, i.b(400), a16, false, 8, null);
            return;
        }
        QLog.e("SmallHomeTransitFragment", 1, "onCreate, params err");
        finishActivity();
    }
}
