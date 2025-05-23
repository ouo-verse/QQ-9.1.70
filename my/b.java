package my;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lmy/b;", "Lcom/tencent/biz/richframework/part/Part;", "", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mRelative", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mNoticeTxt", "<init>", "()V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mRelative;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mNoticeTxt;

    private final void x9() {
        String accountId = RFWApplication.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId()");
        if (TextUtils.isEmpty(accountId)) {
            return;
        }
        ct3.a.n("KEY_HAS_CLICK_NOTICE", Long.parseLong(accountId), true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView);
        View findViewById = rootView.findViewById(R.id.f28970kd);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        relativeLayout.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById<\u2026ity = View.GONE\n        }");
        this.mRelative = relativeLayout;
        View findViewById2 = rootView.findViewById(R.id.f28960kc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView!!.findViewById(\u2026ccount_folder_notice_txt)");
        TextView textView = (TextView) findViewById2;
        this.mNoticeTxt = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeTxt");
            textView = null;
        }
        textView.setText(QzoneConfig.getInstance().getConfig("qqsetting", QzoneConfig.SECONDARY_KEY_SERVICE_ACCOUNT_FOLDER_LIST_NOTICE_TEXT, HardCodeUtil.qqStr(R.string.f170742lv)));
        x9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }
}
