package com.tencent.mobileqq.guild.feed.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager;
import com.tencent.mobileqq.guild.feed.share.l;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bh;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f223386a;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.guild.feed.share.c f223390e;

    /* renamed from: g, reason: collision with root package name */
    private PartManager f223392g;

    /* renamed from: h, reason: collision with root package name */
    private GuildSharePageSource f223393h;

    /* renamed from: j, reason: collision with root package name */
    private View f223395j;

    /* renamed from: b, reason: collision with root package name */
    private final e f223387b = new e();

    /* renamed from: c, reason: collision with root package name */
    private final f f223388c = new f();

    /* renamed from: d, reason: collision with root package name */
    private final d f223389d = new d();

    /* renamed from: f, reason: collision with root package name */
    private ShareActionSheet f223391f = null;

    /* renamed from: i, reason: collision with root package name */
    private ScannerResult f223394i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements GuildFeedRichMediaDownLoadManager.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void a() {
            if (l.this.f223392g != null) {
                l.this.f223392g.broadcastMessage("rich_media_download_show", null);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onProgress(int i3) {
            if (l.this.f223392g != null) {
                l.this.f223392g.broadcastMessage("rich_meida_download_progress", Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onStatusChange(boolean z16) {
            if (l.this.f223392g != null) {
                l.this.f223392g.broadcastMessage("rich_media_download_status", Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements com.tencent.mobileqq.sharepanel.j {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Void e(String str) {
            if (l.this.f223386a.isFinishing()) {
                return null;
            }
            ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(l.this.f223386a, l.this.t(str), 21);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Void f(String str) {
            if (l.this.f223386a.isFinishing()) {
                return null;
            }
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(l.this.f223386a, l.this.t(str), 20000);
            return null;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NonNull String str) {
            QLog.i("GuildFeedPicViewerShareActionSheet", 1, "onShareChannelClick channelId:" + str);
            str.hashCode();
            if (str.equals("qqfriend")) {
                l.this.K(new zu1.c() { // from class: com.tencent.mobileqq.guild.feed.share.m
                    @Override // zu1.c
                    public final Object invoke(Object obj) {
                        Void e16;
                        e16 = l.b.this.e((String) obj);
                        return e16;
                    }
                });
            } else if (str.equals("qqchannel")) {
                l.this.K(new zu1.c() { // from class: com.tencent.mobileqq.guild.feed.share.n
                    @Override // zu1.c
                    public final Object invoke(Object obj) {
                        Void f16;
                        f16 = l.b.this.f((String) obj);
                        return f16;
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NonNull String str) {
            QLog.i("GuildFeedPicViewerShareActionSheet", 1, "onAppendActionClick actionId:" + str);
            str.hashCode();
            if (str.equals("recognize_qr_code")) {
                l.this.u();
            } else if (str.equals("save_to_phone")) {
                l.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f223398e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ zu1.c f223399f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z16, String str, zu1.c cVar) {
            super(z16);
            this.f223398e = str;
            this.f223399f = cVar;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS) {
                String c16 = com.tencent.mobileqq.guild.picload.e.a().c(option);
                QLog.i("GuildFeedPicViewerShareActionSheet", 1, "shareToQQOrChannelByPic  | url = " + this.f223398e + " | localPath = " + c16);
                l.this.F(option, c16, this.f223399f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e implements ShareActionSheet.c {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            l.this.f223391f.dismiss();
            l.this.v(view, actionSheetItem);
            com.tencent.mobileqq.guild.share.p.b(view, actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class f implements DialogInterface.OnShowListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            View decorView = l.this.f223391f.getWindow().getDecorView();
            if (decorView != null && l.this.f223395j != null) {
                VideoReport.setLogicParent(decorView, l.this.f223395j);
            }
        }
    }

    public l(@NonNull Activity activity, @NonNull com.tencent.mobileqq.guild.feed.share.c cVar, GuildSharePageSource guildSharePageSource) {
        this.f223386a = activity;
        this.f223390e = cVar;
        this.f223393h = guildSharePageSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Option option, Context context, final zu1.c cVar) {
        hj1.b.b("GuildFeedPicViewerShareActionSheet", "prepareForQrCode | path: " + com.tencent.mobileqq.guild.picload.e.a().c(option));
        this.f223394i = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + com.tencent.mobileqq.guild.picload.e.a().c(option)), context, 1, false);
        hj1.b.b("GuildFeedPicViewerShareActionSheet", "prepareForQrCode | result: " + this.f223394i);
        ScannerResult scannerResult = this.f223394i;
        if (scannerResult == null) {
            hj1.b.a("GuildFeedPicViewerShareActionSheet", "prepareForQrCode | mScannerResult is null");
        } else {
            final Boolean valueOf = Boolean.valueOf(scannerResult.l());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.i
                @Override // java.lang.Runnable
                public final void run() {
                    zu1.c.this.invoke(valueOf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void B(com.tencent.mobileqq.sharepanel.m mVar, String str) {
        if (this.f223386a.isFinishing()) {
            return null;
        }
        mVar.a(t(str));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(ArrayList arrayList, final com.tencent.mobileqq.sharepanel.m mVar) {
        K(new zu1.c() { // from class: com.tencent.mobileqq.guild.feed.share.g
            @Override // zu1.c
            public final Object invoke(Object obj) {
                Void B;
                B = l.this.B(mVar, (String) obj);
                return B;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void D(o oVar, Boolean bool) {
        if (bool.booleanValue() && !this.f223386a.isFinishing()) {
            oVar.a(ShareActionSheetBuilder.ActionSheetItem.build(55));
            oVar.f();
            return null;
        }
        return null;
    }

    private static void E(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Option option, final String str, @NonNull final zu1.c<String, Void> cVar) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.j
            @Override // java.lang.Runnable
            public final void run() {
                l.y(str, cVar);
            }
        });
    }

    private void G(final Context context, String str, @NonNull final zu1.c<Boolean, Void> cVar) {
        final Option option = new Option();
        option.setUrl(str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.f
            @Override // java.lang.Runnable
            public final void run() {
                l.this.A(option, context, cVar);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.tencent.mobileqq.guild.feed.share.b bVar = new com.tencent.mobileqq.guild.feed.share.b();
        bVar.d(this.f223386a);
        bVar.e(this.f223390e);
        bVar.p(new a());
        bVar.o();
    }

    private void J(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        GuildFeedPicViewerShareQQGuildOperation guildFeedPicViewerShareQQGuildOperation = new GuildFeedPicViewerShareQQGuildOperation();
        guildFeedPicViewerShareQQGuildOperation.d(this.f223386a);
        guildFeedPicViewerShareQQGuildOperation.f(actionSheetItem);
        guildFeedPicViewerShareQQGuildOperation.e(this.f223390e);
        guildFeedPicViewerShareQQGuildOperation.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(@NonNull zu1.c<String, Void> cVar) {
        if (this.f223390e.f() == null) {
            return;
        }
        String d16 = bm.d(this.f223390e.f());
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(d16), new c(true, d16, cVar));
    }

    private void M() {
        com.tencent.mobileqq.sharepanel.f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel((FragmentActivity) this.f223386a, "pindao_feedcomment");
        createSharePanel.k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.guild.feed.share.e
            @Override // com.tencent.mobileqq.sharepanel.n
            public final void a(ArrayList arrayList, com.tencent.mobileqq.sharepanel.m mVar) {
                l.this.C(arrayList, mVar);
            }
        });
        createSharePanel.t0(new b());
        s(createSharePanel);
        createSharePanel.d0(new com.tencent.mobileqq.guild.feed.morepanel.e(GuildSharePageSource.FEED_MEDIA_VIEWER, bh.a(this.f223390e.e()), bh.a(this.f223390e.a()), "").b());
        createSharePanel.show();
    }

    private void N() {
        final o oVar = new o(this.f223386a, this.f223390e);
        this.f223391f = oVar.b();
        if (this.f223390e.f() != null && this.f223390e.f().getImage() != null) {
            G(this.f223386a, bm.d(this.f223390e.f()), new zu1.c() { // from class: com.tencent.mobileqq.guild.feed.share.d
                @Override // zu1.c
                public final Object invoke(Object obj) {
                    Void D;
                    D = l.this.D(oVar, (Boolean) obj);
                    return D;
                }
            });
        }
        this.f223391f.setItemClickListenerV3(this.f223387b);
        this.f223391f.setOnShowListener(this.f223388c);
        this.f223391f.setOnDismissListener(this.f223389d);
        this.f223391f.show();
    }

    private void s(@NonNull final com.tencent.mobileqq.sharepanel.f fVar) {
        fVar.m0(false);
        fVar.c0("save_to_phone", true);
        if (this.f223390e.f() == null) {
            return;
        }
        G(this.f223386a, bm.d(this.f223390e.f()), new zu1.c() { // from class: com.tencent.mobileqq.guild.feed.share.h
            @Override // zu1.c
            public final Object invoke(Object obj) {
                Void w3;
                w3 = l.this.w(fVar, (Boolean) obj);
                return w3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Intent t(String str) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        String str;
        ArrayList<QBarResult> arrayList;
        if (this.f223390e.f() == null) {
            return;
        }
        Option option = new Option();
        option.setUrl(bm.d(this.f223390e.f()));
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", com.tencent.mobileqq.guild.picload.e.a().c(option));
        intent.putExtra("detectType", 1);
        intent.putExtra("fromPicQRDecode", true);
        intent.putExtra("preScanResult", this.f223394i);
        String str2 = this.f223390e.f().getImage().picUrl;
        intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, str2, null, null, null, 5));
        ScannerResult scannerResult = this.f223394i;
        if (scannerResult != null && (arrayList = scannerResult.f276520d) != null && arrayList.size() > 0 && this.f223394i.f276520d.get(0) != null) {
            str = this.f223394i.f276520d.get(0).f276508f;
        } else {
            str = null;
        }
        ax.j(intent, str2, str, String.valueOf(this.f223390e.h()), this.f223390e.e());
        RouteUtils.startActivity(this.f223386a, intent, "/qrscan/scanner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        int i3 = actionSheetItem.action;
        if (i3 != 2 && i3 != 26) {
            if (i3 != 39) {
                if (i3 != 55) {
                    if (i3 != 171 && i3 != 72 && i3 != 73) {
                        QLog.e("GuildFeedPicViewerShareActionSheet", 1, "handleShare activity null");
                        QQToast.makeText(this.f223386a, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                        return;
                    }
                } else {
                    QLog.i("GuildFeedPicViewerShareActionSheet", 1, "handleShareAction save");
                    u();
                    return;
                }
            } else {
                QLog.i("GuildFeedPicViewerShareActionSheet", 1, "handleShareAction save");
                H();
                com.tencent.mobileqq.guild.share.p.c(view, actionSheetItem, "em_sgrp_forum_viewer_save");
                return;
            }
        }
        QLog.i("GuildFeedPicViewerShareActionSheet", 1, "handleShareAction shareToQQOrChannel action = " + actionSheetItem.action);
        J(actionSheetItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void w(com.tencent.mobileqq.sharepanel.f fVar, Boolean bool) {
        if (bool.booleanValue() && !this.f223386a.isFinishing()) {
            fVar.c0("recognize_qr_code", true);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(String str, final zu1.c cVar) {
        final String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("GuildFeedPicViewerShareActionSheet", 1, "picFileShare  localPath == null");
            return;
        }
        if (str.endsWith(LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX)) {
            str2 = str.replace(LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX, ".jpg");
        } else {
            str2 = str;
        }
        QLog.i("GuildFeedPicViewerShareActionSheet", 1, "picFileShare  copyFile  result = " + FileUtils.copyFile(str, str2));
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.k
            @Override // java.lang.Runnable
            public final void run() {
                zu1.c.this.invoke(str2);
            }
        });
    }

    public void I(PartManager partManager) {
        this.f223392g = partManager;
    }

    public void L(View view) {
        E(this.f223386a);
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_feedcomment")) {
            M();
        } else {
            N();
        }
        this.f223395j = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
