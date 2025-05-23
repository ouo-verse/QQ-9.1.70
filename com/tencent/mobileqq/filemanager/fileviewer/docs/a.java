package com.tencent.mobileqq.filemanager.fileviewer.docs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintForQQLiteApi;
import com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private AppActivity f208288a;

    /* renamed from: b, reason: collision with root package name */
    private ForwardFileInfo f208289b;

    /* renamed from: c, reason: collision with root package name */
    private ShareActionSheet f208290c;

    /* renamed from: d, reason: collision with root package name */
    private EIPCResultCallback f208291d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f208292e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f208293f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.docs.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class DialogInterfaceOnDismissListenerC7565a implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC7565a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ImmersiveUtils.isSupporImmersive();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements ShareActionSheet.OnItemClickListener {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (actionSheetItem == null) {
                return;
            }
            a.this.f208290c.dismiss();
            a.this.b(actionSheetItem.action, actionSheetItem);
        }
    }

    public a(AppActivity appActivity, ForwardFileInfo forwardFileInfo, EIPCResultCallback eIPCResultCallback, boolean z16, View.OnClickListener onClickListener) {
        this.f208288a = appActivity;
        this.f208289b = forwardFileInfo;
        this.f208291d = eIPCResultCallback;
        this.f208292e = z16;
        this.f208293f = onClickListener;
    }

    private long g() {
        return this.f208289b.g();
    }

    private String h() {
        return this.f208289b.f();
    }

    public void b(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        boolean z16 = true;
        if (i3 != 72 && i3 != 2 && i3 != 73) {
            if (i3 == 27) {
                Bundle bundle = new Bundle();
                bundle.putLong("key_session_id", this.f208289b.n());
                bundle.putInt("key_action_in_sheet", i3);
                QIPCClientHelper.getInstance().getClient().callServer("TroopDocsShareActionModel", "action_share_file", bundle, this.f208291d);
                return;
            }
            if (i3 == 122) {
                LinkByWeiyunFragment.th(this.f208288a, this.f208289b, null, false);
                return;
            }
            if (i3 == 123) {
                LinkByWeiyunFragment.th(this.f208288a, this.f208289b, null, true);
                return;
            }
            if (i3 == 11) {
                ec1.a.f396078a.a(this.f208288a.getAppRuntime(), "100535", String.valueOf(this.f208289b.k()), String.valueOf(this.f208289b.m()), this.f208289b.e(), this.f208289b.b());
                return;
            }
            if (i3 == 121) {
                FileManagerEntity fileManagerEntity = new FileManagerEntity();
                fileManagerEntity.fileName = this.f208289b.f();
                fileManagerEntity.cloudType = this.f208289b.c();
                fileManagerEntity.Uuid = this.f208289b.s();
                fileManagerEntity.peerUin = String.valueOf(this.f208289b.k());
                fileManagerEntity.TroopUin = this.f208289b.k();
                fileManagerEntity.busId = this.f208289b.b();
                fileManagerEntity.fileIdCrc = this.f208289b.e();
                fileManagerEntity.fileSize = this.f208289b.g();
                fileManagerEntity.strFilePath = this.f208289b.l();
                ((IPrintForQQLiteApi) QRoute.api(IPrintForQQLiteApi.class)).showPrintDialog(this.f208288a, fileManagerEntity, (g) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("online_file_print"), this.f208293f, true);
                return;
            }
            return;
        }
        if (i3 != 72) {
            z16 = false;
        }
        c(z16, actionSheetItem.uin, actionSheetItem.uinType);
    }

    public void c(boolean z16, String str, int i3) {
        if (NetworkUtil.getSystemNetwork(this.f208288a) == 0) {
            AppActivity appActivity = this.f208288a;
            TroopFileError.k(appActivity, appActivity.getString(R.string.ers));
            return;
        }
        Intent j3 = j();
        if (z16 && !TextUtils.isEmpty(str) && i3 != -1) {
            j3.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            j3.putExtra("key_direct_show_uin_type", i3);
            j3.putExtra("key_direct_show_uin", str);
        }
        ForwardBaseOption.startForwardActivityForResult(this.f208288a, j3, (Class<?>) ForwardRecentTranslucentActivity.class, 103);
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem> d() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(27));
        return arrayList;
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem> e() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(122));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(123));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        if (((IPrintApi) QRoute.api(IPrintApi.class)).isSupportPrint(this.f208289b.f(), true, true)) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(121));
        }
        return arrayList;
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] f() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> d16 = d();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> e16 = e();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        if (d16 != null && !d16.isEmpty()) {
            arrayList.addAll(d16);
        }
        if (e16 != null && !e16.isEmpty()) {
            arrayList2.addAll(e16);
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    public Intent i() {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", this.f208289b);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("destroy_last_activity", true);
        intent.putExtra("forward_type", 0);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, this.f208289b.l());
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.qaz) + FileManagerUtil.cutLongName(this.f208289b.f()) + HardCodeUtil.qqStr(R.string.qba) + q.g(this.f208289b.g()) + "\u3002");
        intent.putExtra("k_favorites", true);
        return intent;
    }

    public Intent j() {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", this.f208289b);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, this.f208289b.f());
        intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        return intent;
    }

    public void k() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        if (this.f208290c == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this.f208288a;
            this.f208290c = ShareActionSheetFactory.create(param);
        }
        this.f208290c.setRowVisibility(0, 0, 0);
        this.f208290c.setOnDismissListener(new DialogInterfaceOnDismissListenerC7565a());
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] f16 = f();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (f16 != null) {
            if (f16.length == 1) {
                arrayList2 = f16[0];
                arrayList = null;
            } else if (f16.length == 2) {
                arrayList2 = f16[0];
                arrayList = f16[1];
            }
            if ((arrayList2 == null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                this.f208290c.setActionSheetTitle(h() + "(" + q.g(g()) + ")");
                Intent i3 = i();
                this.f208288a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
                if (i3 != null && !TextUtils.isEmpty("biz_src_jc_file")) {
                    this.f208290c.setIntentForStartForwardRecentActivity(i3);
                } else {
                    this.f208290c.setRowVisibility(8, 0, 0);
                }
                this.f208290c.setActionSheetItems(arrayList2, arrayList);
                this.f208290c.setItemClickListenerV2(new b());
                this.f208290c.show();
                return;
            }
            return;
        }
        arrayList = null;
        if (arrayList2 == null) {
        }
    }
}
