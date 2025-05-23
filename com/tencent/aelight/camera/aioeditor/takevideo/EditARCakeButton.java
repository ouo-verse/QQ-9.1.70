package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.core.content.FileProvider;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditARCakeButton extends u implements View.OnClickListener {
    private static final String F;
    private static final String G;
    private static final String H;
    private static final ArrayList<ShareActionSheetBuilder.ActionSheetItem> I;
    private final DialogInterface.OnDismissListener C;
    private final IAIOShareHelper.a D;
    private final ShareActionSheet.OnItemClickListener E;

    /* renamed from: d, reason: collision with root package name */
    private View f67662d;

    /* renamed from: e, reason: collision with root package name */
    private View f67663e;

    /* renamed from: f, reason: collision with root package name */
    private View f67664f;

    /* renamed from: h, reason: collision with root package name */
    private View f67665h;

    /* renamed from: i, reason: collision with root package name */
    private pr.a f67666i;

    /* renamed from: m, reason: collision with root package name */
    private String f67667m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements IAIOShareHelper.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.a
        public void a(boolean z16, int i3, String str, pr.a aVar) {
            if (TextUtils.equals(EditARCakeButton.this.f67667m, str)) {
                if (z16) {
                    EditARCakeButton.this.C0();
                } else {
                    EditARCakeButton.this.B0();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements ShareActionSheet.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            shareActionSheet.dismiss();
            if (actionSheetItem == null) {
                ms.a.c("EditARCakeButton", "weird, handle share action, action item is null");
                return;
            }
            ms.a.f("EditARCakeButton", "handle share action, action = " + actionSheetItem.action);
            Activity activity = EditARCakeButton.this.mUi.getActivity();
            pr.a aVar = EditARCakeButton.this.f67666i;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (aVar == null) {
                ms.a.c("EditARCakeButton", "weird, handle share action, share object is null");
                return;
            }
            int i3 = actionSheetItem.action;
            if (i3 == 2) {
                ms.a.f("EditARCakeButton", "handle action send to friend");
                aVar.l(2);
                ((IAIOShareHelper) QRoute.api(IAIOShareHelper.class)).shareToQQ(activity, -1, null, aVar);
            } else if (i3 == 50) {
                ms.a.f("EditARCakeButton", "handle action send to qzone");
                ((IAIOShareHelper) QRoute.api(IAIOShareHelper.class)).shareToQZone(activity, aVar);
            } else if (i3 == 64) {
                ms.a.f("EditARCakeButton", "handle action open short video by other app");
                EditARCakeButton.this.D0(activity, aVar.c());
            } else if (i3 == 72) {
                ms.a.f("EditARCakeButton", "handle action send to specific friend");
                aVar.l(1);
                ((IAIOShareHelper) QRoute.api(IAIOShareHelper.class)).shareToQQ(activity, actionSheetItem.uinType, actionSheetItem.uin, aVar);
            } else if (i3 == 9 || i3 == 10) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handle action send to ");
                if (actionSheetItem.action == 9) {
                    str = "wechat";
                } else {
                    str = "wechat timeline";
                }
                sb5.append(str);
                ms.a.f("EditARCakeButton", sb5.toString());
                IAIOShareHelper iAIOShareHelper = (IAIOShareHelper) QRoute.api(IAIOShareHelper.class);
                int i16 = actionSheetItem.action;
                EditARCakeButton editARCakeButton = EditARCakeButton.this;
                String y06 = editARCakeButton.y0();
                editARCakeButton.f67667m = y06;
                iAIOShareHelper.shareToWX(activity, i16, y06, aVar, EditARCakeButton.this.D);
            }
            EditARCakeButton.this.f67666i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int f67675a;

        /* renamed from: b, reason: collision with root package name */
        int f67676b;

        /* renamed from: c, reason: collision with root package name */
        int f67677c;

        /* renamed from: d, reason: collision with root package name */
        String f67678d;

        d() {
        }
    }

    static {
        String str = g.a.C0559a.f65247a + "/qq_aio_share";
        F = str;
        G = str + "/qq_share_video.mp4";
        H = str + "/qq_share_video_thumb.png";
        I = new ArrayList<>();
    }

    public EditARCakeButton(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.C = new a();
        this.D = new b();
        this.E = new c();
    }

    private void A0() {
        File file = new File(F);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Activity activity, String str) {
        File file = new File(str);
        Intent intent = new Intent("android.intent.action.SEND");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(activity, "com.tencent.mobileqq.fileprovider", file));
                intent.addFlags(1);
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            }
            intent.setType("video/*");
            activity.startActivity(Intent.createChooser(intent, ""));
        } catch (Exception e16) {
            ms.a.e("EditARCakeButton", e16);
        }
    }

    private void E0(final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.5
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = EditARCakeButton.this.mUi.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                QQToast.makeText(activity, z16 ? 2 : 1, activity.getResources().getString(z16 ? R.string.y88 : R.string.y87), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.bb_));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        Intent intent;
        if (this.f67666i == null || this.mUi.getActivity() == null || this.mUi.getActivity().isFinishing()) {
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = getContext();
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        create.setOnDismissListener(this.C);
        create.setRowVisibility(0, 0, 8);
        create.setActionSheetItems(w0(), I);
        create.setItemClickListenerV2(this.E);
        Context context = getContext();
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_arvideo");
            create.setIntentForStartForwardRecentActivity(intent);
        }
        create.show();
        ms.a.f("EditARCakeButton", "share panel action sheet has shown");
    }

    private void G0() {
        this.f67665h.setEnabled(false);
        final String sourcePath = this.mParent.C.f204059i.getSourcePath();
        final boolean l06 = this.mParent.l0();
        ms.a.f("EditARCakeButton", "start share, is photo = " + l06 + ", source path = " + sourcePath);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.1
            @Override // java.lang.Runnable
            public void run() {
                EditARCakeButton.this.v0(sourcePath, l06);
                if (EditARCakeButton.this.f67666i != null) {
                    ms.a.f("EditARCakeButton", "build share object success, start open share panel");
                } else {
                    ms.a.c("EditARCakeButton", "build share object fail");
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditARCakeButton.this.f67665h.setEnabled(true);
                        EditARCakeButton.this.F0();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str, boolean z16) {
        String z06;
        ms.a.f("EditARCakeButton", "build share object");
        if (z16) {
            this.f67666i = pr.a.i(str);
            return;
        }
        pr.a aVar = null;
        try {
            A0();
            z06 = z0(str);
        } catch (IOException e16) {
            ms.a.d("EditARCakeButton", "make share video obj error", e16);
        } catch (IllegalArgumentException e17) {
            ms.a.d("EditARCakeButton", "make share video obj error", e17);
        } catch (Throwable th5) {
            ms.a.d("EditARCakeButton", "make share video obj error", th5);
        }
        if (z06 == null) {
            return;
        }
        aVar = pr.a.j(z06);
        d x06 = x0(str);
        aVar.n(x06.f67678d).m(x06.f67675a, x06.f67676b).k(x06.f67677c);
        this.f67666i = aVar;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> w0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(50));
        if (this.mParent.l0()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        } else {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(64));
        }
        return arrayList;
    }

    private d x0(String str) throws IOException {
        ms.a.f("EditARCakeButton", "start decode video meta info, path = " + str);
        d dVar = new d();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
        dVar.f67675a = Integer.parseInt(extractMetadata);
        dVar.f67676b = Integer.parseInt(extractMetadata2);
        dVar.f67677c = Integer.parseInt(extractMetadata3);
        ms.a.f("EditARCakeButton", "video width = " + dVar.f67675a + ", height = " + dVar.f67676b + ", duration = " + dVar.f67677c);
        ms.a.f("EditARCakeButton", "start decode video thumbnail");
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        dVar.f67678d = H;
        frameAtTime.compress(Bitmap.CompressFormat.PNG, 50, new FileOutputStream(new File(dVar.f67678d)));
        ms.a.f("EditARCakeButton", "decode video thumbnail success");
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y0() {
        return String.valueOf(System.currentTimeMillis());
    }

    private String z0(String str) throws IOException {
        String str2 = G;
        if (com.tencent.mobileqq.filemanager.util.q.b(new File(str), new File(str2))) {
            ms.a.f("EditARCakeButton", "save video to temp path success, path = " + str2);
            return str2;
        }
        ms.a.c("EditARCakeButton", "save video to temp path fail, path = " + str2);
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1 || i3 == 2) {
            boolean z16 = i16 == -1;
            ms.a.f("EditARCakeButton", "onActivity result: success = " + z16);
            if (z16) {
                C0();
            } else {
                B0();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.rvk) {
            this.mParent.n1();
        } else if (id5 == R.id.rp8) {
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportARVideoDownloadBtn();
            this.mParent.I0();
        } else if (id5 == R.id.rpj) {
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportARVideoShareBtn();
            G0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        ((ViewStub) findViewSure(R.id.f163795s20)).inflate();
        View findViewSure = findViewSure(R.id.rob);
        this.f67662d = findViewSure;
        View findViewById = findViewSure.findViewById(R.id.rvk);
        this.f67663e = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.f67662d.findViewById(R.id.rp8);
        this.f67664f = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = this.f67662d.findViewById(R.id.rpj);
        this.f67665h = findViewById3;
        findViewById3.setOnClickListener(this);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportARVideoExpose();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        E0(true);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
