package l02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final ShareActionSheet f413588a;

    /* renamed from: b, reason: collision with root package name */
    private final List<ShareActionSheetBuilder.ActionSheetItem> f413589b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<ShareActionSheetBuilder.ActionSheetItem> f413590c = new ArrayList();

    public c(Context context) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.f413588a = create;
        create.setRowVisibility(0, 0, 0);
        create.setActionSheetTitle(context.getString(R.string.f156741l1));
        b();
        c();
    }

    private void b() {
        Bundle bundle = new Bundle();
        bundle.putString("appName", "com.tencent.qun.pro");
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "1.0.0.0");
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, "contact");
        bundle.putString(QQCustomArkDialogUtil.META_DATA, "{}");
        bundle.putFloat("scale", ViewUtils.getDensity());
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27).putExtra("is_ark_display_share", true).putExtra("forward_ark_app_name", "com.tencent.qun.pro").putExtra("forward_ark_app_view", "contact").putExtra("forward_ark_app_ver", "1.0.0.0").putExtra("forward_ark_app_prompt", "\u817e\u8baf\u9891\u9053").putExtra(ForwardRecentActivity.SELECTION_MODE, 2).putExtra("guild_share_label", true).putExtra("forward_ark_app_meta", "{}").putExtras(bundle);
        this.f413588a.setIntentForStartForwardRecentActivity(intent);
    }

    private void c() {
        Iterator it = Arrays.asList(2, 26, 9).iterator();
        while (it.hasNext()) {
            this.f413589b.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer) it.next()).intValue()));
        }
    }

    public ShareActionSheet a() {
        this.f413588a.setActionSheetItems(this.f413589b, this.f413590c);
        return this.f413588a;
    }
}
