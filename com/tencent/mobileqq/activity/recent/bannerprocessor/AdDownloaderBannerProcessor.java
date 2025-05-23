package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/bannerprocessor/AdDownloaderBannerProcessor;", "Lcom/tencent/mobileqq/banner/processor/BaseBannerProcessor;", "Lcom/tencent/mobileqq/banner/processor/b;", "Lcom/tencent/mobileqq/banner/a;", "banner", "Landroid/view/View;", "initBanner", "Landroid/os/Message;", "msg", "", "updateBanner", "onAccountChanged", "onResume", "Lmqq/app/AppRuntime;", "appRuntime", "c", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getId", "", "d", "Ljava/lang/String;", "mAppName", "", "e", "Z", "mIsScheduleBanner", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AdDownloaderBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    private static final int f185198h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAppName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsScheduleBanner;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/bannerprocessor/AdDownloaderBannerProcessor$a;", "", "", "BANNER_ID", "I", "a", "()I", "", "EVENT_SCHEDULE_BANNER_END", "Ljava/lang/String;", "EVENT_TIPSBANNER_CLICK", "EVENT_TIPSBANNER_END", "EVENT_TIPSBANNER_EXPO", "MSG_AD_BAR_DOWNLOAD", "MSG_AD_BAR_SCHEDULE_DOWNLOAD", "SCHEDULE_TEXT_SPLIT_END", "TAG", "TEXT_SPLIT_END", "TEXT_SPLIT_START", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.bannerprocessor.AdDownloaderBannerProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AdDownloaderBannerProcessor.f185198h;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
            f185198h = com.tencent.mobileqq.banner.d.N;
        }
    }

    public AdDownloaderBannerProcessor(@Nullable QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.mAppName = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AdDownloaderBannerProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.gdtad.util.b bVar = com.tencent.gdtad.util.b.f109548a;
        bVar.e();
        BannerManager.l().O(f185198h, 0, null);
        bVar.i(this$0.mAppName);
        ((IAdApi) QRoute.api(IAdApi.class)).report("tipsbanner_click", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AdDownloaderBannerProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BannerManager.l().O(f185198h, 0, null);
        com.tencent.gdtad.util.b.f109548a.i(this$0.mAppName);
        ((IAdApi) QRoute.api(IAdApi.class)).report("tipsbanner_end", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        BannerManager.l().O(f185198h, 0, null);
        ((IAdApi) QRoute.api(IAdApi.class)).report("schedule_banner_end", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return f185198h;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    @Nullable
    public View initBanner(@NotNull com.tencent.mobileqq.banner.a banner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) banner);
        }
        Intrinsics.checkNotNullParameter(banner, "banner");
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdDownloaderBannerProcessor", 2, "initBanner");
        }
        ((IAdApi) QRoute.api(IAdApi.class)).report("tipsbanner_expo", null);
        return QUINoticeBarManager.INSTANCE.a().h(baseActivity).setMsg("\u4f60\u7684\u5e94\u7528\u5df2\u5b8c\u6210\u4e0b\u8f7d\uff0c\u5f85\u5b89\u88c5").setIcon(R.drawable.mn6).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().O(f185198h, 0, null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(@NotNull com.tencent.mobileqq.banner.a banner, @Nullable Message msg2) {
        Object obj;
        StringBuilder sb5;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) banner, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(banner, "banner");
        com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.INSTANCE.a().d(banner.f200243c);
        if (d16 == null) {
            return;
        }
        Object obj2 = null;
        if (msg2 != null) {
            obj = msg2.obj;
        } else {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 != null) {
            this.mAppName = str2;
        }
        if (banner.f200242b == 2) {
            boolean z16 = false;
            if (msg2 != null && msg2.what == 3012) {
                z16 = true;
            }
            this.mIsScheduleBanner = z16;
        }
        if (this.mIsScheduleBanner) {
            String str3 = this.mAppName;
            sb5 = new StringBuilder();
            sb5.append(str3);
            str = "\u6d3b\u52a8\u5df2\u9884\u7ea6\uff0c\u73b0\u5728\u5f00\u59cb\u4e0b\u8f7d";
        } else {
            String str4 = this.mAppName;
            sb5 = new StringBuilder();
            sb5.append("\u300a");
            sb5.append(str4);
            str = "\u300b\u5df2\u4e0b\u8f7d\u5b8c\u6210\uff0c\u5feb\u6765\u5b89\u88c5\u4f53\u9a8c\u5427";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        if (msg2 != null) {
            obj2 = msg2.obj;
        }
        if (((String) obj2) != null) {
            d16.setMsg(sb6);
            if (!this.mIsScheduleBanner) {
                d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdDownloaderBannerProcessor.i(AdDownloaderBannerProcessor.this, view);
                    }
                });
                d16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdDownloaderBannerProcessor.j(AdDownloaderBannerProcessor.this, view);
                    }
                });
            } else {
                d16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdDownloaderBannerProcessor.k(view);
                    }
                });
            }
        }
        if (banner.f200242b == 0 && !this.mIsScheduleBanner) {
            com.tencent.gdtad.util.b.f109548a.i(this.mAppName);
        }
    }
}
