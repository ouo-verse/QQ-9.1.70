package com.tencent.mobileqq.font.banner;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.a;
import com.tencent.mobileqq.banner.d;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.font.banner.FontSizeChangeBannerProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/font/banner/FontSizeChangeBannerProcessor;", "Lcom/tencent/mobileqq/banner/processor/BaseBannerProcessor;", "Lcom/tencent/mobileqq/banner/a;", "banner", "Landroid/view/View;", "initBanner", "", "onAccountChanged", "Landroid/os/Message;", "msg", "updateBanner", "", "getId", "", "d", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "e", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FontSizeChangeBannerProcessor extends BaseBannerProcessor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String type;

    public FontSizeChangeBannerProcessor(QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.type = "font_banner";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FontSizeChangeBannerProcessor this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("FontSizeChangeBannerProcessor", 2, "link Text And Click-- ");
        QBaseActivity baseActivity = this$0.getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        Intent intent = new Intent(baseActivity, (Class<?>) FontSettingActivity.class);
        intent.setFlags(67108864);
        baseActivity.startActivity(intent);
        BannerManager.l().O(this$0.getId(), 0, null);
        b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(1);
        if (chatsListReport != null) {
            chatsListReport.l(this$0.type, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FontSizeChangeBannerProcessor this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BannerManager.l().O(this$0.getId(), 0, null);
        b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(1);
        if (chatsListReport != null) {
            chatsListReport.l(this$0.type, 2);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        return d.f200255h;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(a banner) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        QLog.d("FontSizeChangeBannerProcessor", 2, "init font Banner success");
        View view = QUINoticeBarManager.INSTANCE.a().h(baseActivity).f(R.string.irl, new View.OnClickListener() { // from class: sc1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FontSizeChangeBannerProcessor.g(FontSizeChangeBannerProcessor.this, view2);
            }
        }).k(new View.OnClickListener() { // from class: sc1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FontSizeChangeBannerProcessor.h(FontSizeChangeBannerProcessor.this, view2);
            }
        }).getView();
        view.setTag(DTChatsConst.f354825a.a(), this.type);
        return view;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        BannerManager.l().O(getId(), 0, null);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(a banner, Message msg2) {
        com.tencent.biz.qui.noticebar.d d16;
        if (banner == null) {
            return;
        }
        QLog.d("FontSizeChangeBannerProcessor", 2, "updateBanner msg is :", msg2);
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.INSTANCE.a().d(banner.f200243c)) == null) {
            return;
        }
        d16.setMsg(baseActivity.getString(R.string.zo5));
    }
}
