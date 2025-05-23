package com.tencent.mobileqq.filemanageraux.link;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.link.a;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LinkByWeiyunFragment extends IphoneTitleBarFragment implements DialogInterface.OnClickListener, a, ShareActionSheet.OnItemClickListener, WXShareHelper.a, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final int N;
    private FileManagerEntity C;
    private FileInfo D;
    private boolean E;
    private e F;
    private c G;
    private d H;
    private QQCustomDialog I;
    private ShareActionSheet J;
    private AsyncImageView K;
    private View L;
    private String M;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            N = Color.parseColor("#00000000");
        }
    }

    public LinkByWeiyunFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void initView() {
        int i3;
        int i16;
        if (this.E) {
            i3 = R.string.f171450vv1;
        } else {
            i3 = R.string.vva;
        }
        setTitle(getString(i3));
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            i16 = R.color.f156812c1;
        } else {
            i16 = R.color.alg;
        }
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166542cc2).setBackgroundResource(i16);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ggc).setBackgroundResource(i16);
        TextView textView = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dvl);
        TextView textView2 = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dvd);
        AsyncImageView asyncImageView = (AsyncImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dvi);
        String fileName = getFileName();
        if (textView.getMeasuredWidth() <= 0) {
            textView.post(new Runnable(textView, fileName) { // from class: com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextView f209623d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f209624e;

                {
                    this.f209623d = textView;
                    this.f209624e = fileName;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, LinkByWeiyunFragment.this, textView, fileName);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        TextView textView3 = this.f209623d;
                        textView3.setText(FileManagerUtil.handleLongFileName(this.f209624e, true, textView3.getMeasuredWidth(), this.f209623d.getPaint(), 1));
                    }
                }
            });
        } else {
            textView.setText(FileManagerUtil.handleLongFileName(fileName, true, textView.getMeasuredWidth(), textView.getPaint(), 1));
        }
        textView2.setText(q.g(getFileSize()));
        asyncImageView.setImageResource(FileManagerUtil.getFileIconResId(fileName));
        int fileType = getFileType();
        if (fileType == 5 || fileType == 0) {
            String filePath = getFilePath();
            if (q.f(filePath)) {
                if (fileType == 5) {
                    asyncImageView.setApkIconAsyncImage(filePath);
                } else {
                    asyncImageView.setAsyncImage(filePath);
                }
            }
        }
    }

    private void qh() {
        this.F = new e(this, ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.duu), this.E);
        this.G = new c(this, ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ccp), this.E);
        this.H = new d(this, (ViewGroup) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.root));
    }

    private boolean rh() {
        Bundle arguments = getArguments();
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) arguments.getParcelable("fileinfo");
        if (forwardFileInfo != null) {
            AppInterface appInterface = getBaseActivity().getAppInterface();
            if (appInterface instanceof QQAppInterface) {
                this.C = ((QQAppInterface) appInterface).getFileManagerDataCenter().D(forwardFileInfo.n());
            }
        }
        String string = arguments.getString("key_local_file_path");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.D = new FileInfo(string);
            } catch (Throwable unused) {
                QLog.e("LinkByWeiyunFragment<FileAssistant>", 2, "initData : local file not fount for " + string);
            }
        }
        boolean z16 = false;
        this.E = arguments.getBoolean("key_by_qr_code", false);
        FileInfo fileInfo = this.D;
        if (fileInfo != null && fileInfo.l() > 0) {
            z16 = true;
        }
        return b.h(this.C, z16);
    }

    private void sh() {
        int i3;
        if (this.I == null) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(getBaseActivity(), R.style.qZoneInputDialog);
            this.I = qQCustomDialog;
            qQCustomDialog.setContentView(R.layout.f167856jn);
            QQCustomDialog qQCustomDialog2 = this.I;
            if (this.E) {
                i3 = R.string.vut;
            } else {
                i3 = R.string.vuu;
            }
            qQCustomDialog2.setTitle(i3);
            this.I.setMessage((CharSequence) null);
            this.I.setNegativeButton(R.string.cancel, this);
            this.I.setPositiveButton(R.string.bjz, this);
            this.I.setCancelable(true);
            this.I.setCanceledOnTouchOutside(false);
        }
        if (!this.I.isShowing()) {
            this.I.show();
        }
    }

    public static void th(Context context, ForwardFileInfo forwardFileInfo, String str, boolean z16) {
        String str2;
        String str3;
        if (context != null) {
            if (forwardFileInfo != null || !TextUtils.isEmpty(str)) {
                Intent intent = new Intent();
                intent.putExtra("fileinfo", forwardFileInfo);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("key_local_file_path", str);
                }
                intent.putExtra("key_by_qr_code", z16);
                PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, LinkByWeiyunFragment.class);
                if (forwardFileInfo != null) {
                    str2 = forwardFileInfo.f();
                } else {
                    str2 = "";
                }
                if (z16) {
                    str3 = "0X800A9D5";
                } else {
                    str3 = "0X800A9D4";
                }
                b.i(str3, b.e(str2, str), null);
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public a.C7594a A7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a.C7594a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        e eVar = this.F;
        if (eVar == null) {
            return new a.C7594a();
        }
        return eVar.b();
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public String Ce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        this.M = Long.toString(System.currentTimeMillis());
        WXShareHelper.b0().A(this);
        return this.M;
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public boolean J4(Bitmap bitmap, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, bitmap, Integer.valueOf(i3), str)).booleanValue();
        }
        if (!isAdded() || isDetached() || isRemoving()) {
            return false;
        }
        d dVar = this.H;
        if (dVar != null && dVar.j(bitmap, i3, str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public void O9() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        e eVar = this.F;
        if (eVar != null) {
            c cVar = this.G;
            if (cVar != null && cVar.t()) {
                z16 = false;
            } else {
                z16 = true;
            }
            eVar.d(z16);
        }
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public FileManagerEntity W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView();
        qh();
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public void f4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        c cVar = this.G;
        if (cVar != null) {
            cVar.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.abh;
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileName;
        }
        FileInfo fileInfo = this.D;
        if (fileInfo != null) {
            return fileInfo.j();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity != null) {
            return fileManagerEntity.getFilePath();
        }
        FileInfo fileInfo = this.D;
        if (fileInfo != null) {
            return fileInfo.k();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileSize;
        }
        FileInfo fileInfo = this.D;
        if (fileInfo != null) {
            return fileInfo.l();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public int getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity != null) {
            return fileManagerEntity.nFileType;
        }
        FileInfo fileInfo = this.D;
        if (fileInfo != null) {
            if (fileInfo.getType() == 5) {
                return 5;
            }
            return FileManagerUtil.getFileType(this.D.j());
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        c cVar = this.G;
        if (cVar != null && cVar.u()) {
            sh();
            return true;
        }
        return uh();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dialogInterface, i3);
            return;
        }
        if (dialogInterface.equals(this.I) && i3 == 1) {
            c cVar = this.G;
            if (cVar != null) {
                cVar.f();
            }
            uh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (!rh()) {
            uh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.L = null;
        AsyncImageView asyncImageView = this.K;
        if (asyncImageView != null) {
            asyncImageView.setImageDrawable(null);
            this.K = null;
        }
        ShareActionSheet shareActionSheet = this.J;
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
            this.J = null;
        }
        this.M = null;
        WXShareHelper.b0().q0(this);
        e eVar = this.F;
        if (eVar != null) {
            eVar.c();
            this.F = null;
        }
        c cVar = this.G;
        if (cVar != null) {
            cVar.v();
            this.G = null;
        }
        d dVar = this.H;
        if (dVar != null) {
            dVar.f();
            this.H = null;
        }
        QQCustomDialog qQCustomDialog = this.I;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.I = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        int i3;
        d dVar;
        String str;
        ShareActionSheet shareActionSheet2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
            return;
        }
        if (!this.E && (shareActionSheet2 = this.J) != null) {
            shareActionSheet2.dismiss();
        }
        int i16 = actionSheetItem.action;
        if (i16 == 9 || i16 == 10) {
            if (!WXShareHelper.b0().e0()) {
                i3 = R.string.f173257ih1;
            } else if (!WXShareHelper.b0().f0()) {
                i3 = R.string.f173258ih2;
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                b.j(0, i3, false);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("LinkByWeiyunFragment<FileAssistant>", 2, "onItemClick.chooseChannel: " + i16);
        }
        c cVar = this.G;
        if (cVar != null && (dVar = this.H) != null) {
            if (this.E) {
                dVar.k(actionSheetItem);
            } else {
                cVar.G(actionSheetItem);
            }
            if (this.E) {
                str = "0X800A9DB";
            } else {
                str = "0X800A9DA";
            }
            b.i(str, b.g(i16), null);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
    public void onWXShareResp(BaseResp baseResp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) baseResp);
            return;
        }
        String str = this.M;
        if (str != null && str.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
            if (i3 != 0) {
                b.j(1, R.string.hit, true);
            } else {
                b.j(2, R.string.hj9, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanageraux.link.a
    public void s9(Bitmap bitmap) {
        int i3;
        int i16;
        List<ShareActionSheetBuilder.ActionSheetItem> i17;
        List<ShareActionSheetBuilder.ActionSheetItem> h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bitmap);
            return;
        }
        if (this.G != null && this.H != null) {
            BaseActivity baseActivity = getBaseActivity();
            if (this.J == null) {
                baseActivity.getIntent().putExtra("big_brother_source_key", "biz_src_xl_weiyun");
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = baseActivity;
                param.fullScreen = false;
                this.J = ShareActionSheetFactory.create(param);
                Intent intent = new Intent();
                if (this.E) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                intent.putExtra("forward_type", i3);
                intent.putExtra(AppConstants.Key.KEY_SHARE_DATA_LINE_SUPPORT_TYPE, 1);
                this.J.setIntentForStartForwardRecentActivity(intent);
                ShareActionSheet shareActionSheet = this.J;
                if (this.E) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                shareActionSheet.setRowVisibility(0, 0, i16);
                ShareActionSheet shareActionSheet2 = this.J;
                if (this.E) {
                    i17 = this.H.b(baseActivity);
                } else {
                    i17 = this.G.i(baseActivity);
                }
                if (this.E) {
                    h16 = this.H.a(baseActivity);
                } else {
                    h16 = this.G.h(baseActivity);
                }
                shareActionSheet2.setActionSheetItems(i17, h16);
            }
            this.J.setItemClickListenerV2(this);
            if (!this.J.isShowing()) {
                this.J.show();
            }
        }
    }

    public boolean uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ShareActionSheet shareActionSheet;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else if (view == this.L && (shareActionSheet = this.J) != null) {
            shareActionSheet.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
