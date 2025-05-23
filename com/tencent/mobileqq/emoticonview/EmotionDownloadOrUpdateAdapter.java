package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionDownloadOrUpdateAdapter extends EmotionNeedDownloadAdapter implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_DOWNLOAD_END = 102;
    private static final int MSG_REFRESH_COVER = 100;
    private static final int MSG_REFRESH_PROGRESS = 101;
    private static final String TAG = "EmotionDownloadOrUpdateAdapter";
    public static final int TYPE_DATA = 1;
    public static final int TYPE_UPDATE = 0;
    private boolean authType;
    private int businessType;
    protected EmoticonPackage emotionPkg;
    protected EmotionDownloadOrUpdateViewHolder holder;
    protected boolean isSmallEmotion;
    protected boolean isUpdatePanel;
    private MqqHandler mUiHandler;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class EmotionDownloadOrUpdateViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        public URLImageView cover;
        public ProgressButton downloadBtn;
        public TextView name;

        public EmotionDownloadOrUpdateViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmotionDownloadOrUpdateAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18));
            return;
        }
        this.authType = true;
        this.mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.emotionPkg = emoticonPackage;
        this.isSmallEmotion = emoticonPackage.jobType == 4;
        this.businessType = i18;
    }

    private void doDownloadOpr(boolean z16) {
        if (this.emotionPkg != null && this.holder != null) {
            int i3 = 2;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doDownloadOpr epid = " + this.emotionPkg.epId);
            }
            ProgressButton progressButton = this.holder.downloadBtn;
            if (progressButton == null) {
                return;
            }
            if (z16) {
                isAuthorized();
                if (!this.authType) {
                    return;
                }
            }
            String str = this.emotionPkg.epId;
            if (str != null && str.equals("10278")) {
                ((EmoticonHandlerProxy) this.app.getBusinessHandler(EmoticonHandler.F)).reportAddEmoticonPkg(this.emotionPkg.epId, this.businessType);
                ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
            }
            setProgressDrawable(progressButton);
            EmojiManagerServiceProxy emojiManagerServiceProxy = (EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class);
            float emoticonPackageLoadingProgress = emojiManagerServiceProxy.getEmoticonPackageLoadingProgress(this.emotionPkg.epId);
            int i16 = this.downBtnStatus;
            if (i16 == 2) {
                progressButton.setText(BaseApplication.getContext().getString(R.string.f208915e0));
                progressButton.setProgress((int) emoticonPackageLoadingProgress);
                emojiManagerServiceProxy.pullEmoticonPackage(this.emotionPkg, true, this.businessType);
                this.downBtnStatus = 1;
            } else if (i16 == 1) {
                String string = BaseApplication.getContext().getString(R.string.f208965e5);
                if (this.isUpdatePanel) {
                    string = BaseApplication.getContext().getString(R.string.f209495fk);
                }
                progressButton.setText(string);
                progressButton.setProgress(0);
                this.downBtnStatus = 2;
                emojiManagerServiceProxy.stopEmoticonPackageDownload(this.emotionPkg.epId);
                this.mContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
                ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.emotionPkg.epId, i3 + "", "");
            }
            i3 = 1;
            ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.emotionPkg.epId, i3 + "", "");
        }
    }

    private void isAuthorized() {
        if (this.emotionPkg == null) {
            return;
        }
        this.authType = ((IVasEmojiManagerService) QRoute.api(IVasEmojiManagerService.class)).isAuthorized(this.app, this.emotionPkg.mobileFeetype);
    }

    private boolean isCurrentPanel() {
        EmoticonPackage emoticonPackage;
        EmotionPanelInfo emotionPanelInfo = this.curPanelInfo;
        if (emotionPanelInfo != null && emotionPanelInfo.emotionPkg != null && (emoticonPackage = this.emotionPkg) != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            if (this.emotionPkg.epId.equals(this.curPanelInfo.emotionPkg.epId)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        if (this.isUpdatePanel) {
            if (i3 == 0) {
                return 0;
            }
            return 1;
        }
        return super.getItemViewType(i3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.isUpdatePanel) {
            return 2;
        }
        return super.getViewTypeCount();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        EmoticonPackage emoticonPackage = (EmoticonPackage) message.obj;
        EmotionDownloadOrUpdateViewHolder emotionDownloadOrUpdateViewHolder = this.holder;
        if (emotionDownloadOrUpdateViewHolder != null && emotionDownloadOrUpdateViewHolder.cover != null) {
            EmoticonPackage emoticonPackage2 = this.emotionPkg;
            if (emoticonPackage2 == null || TextUtils.isEmpty(emoticonPackage2.epId) || emoticonPackage == null || !this.emotionPkg.epId.equals(emoticonPackage.epId)) {
                return true;
            }
            switch (message.what) {
                case 100:
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleMessage refreshCover epid = " + this.emotionPkg.epId);
                    }
                    Drawable m3 = com.tencent.mobileqq.emosm.e.m(2, this.emotionPkg.epId);
                    if (m3 != null) {
                        this.holder.cover.setImageDrawable(m3);
                    }
                    return true;
                case 101:
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleMessage refreshprogress epid = " + this.emotionPkg.epId);
                    }
                    int statusPercent = (int) ((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getStatusPercent(emoticonPackage.epId);
                    if (statusPercent < 0) {
                        return true;
                    }
                    this.holder.downloadBtn.setText(BaseApplication.getContext().getString(R.string.f208915e0));
                    this.downBtnStatus = 1;
                    setProgressDrawable(this.holder.downloadBtn);
                    this.holder.downloadBtn.setProgress(statusPercent);
                    return true;
                case 102:
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleMessage packageDownloadEnd epid = " + this.emotionPkg.epId);
                    }
                    if (this.isUpdatePanel) {
                        this.holder.downloadBtn.setText(BaseApplication.getContext().getString(R.string.f209495fk));
                    }
                    this.holder.downloadBtn.setText(BaseApplication.getContext().getString(R.string.f208965e5));
                    this.holder.downloadBtn.setProgress(0);
                    this.downBtnStatus = 2;
                    return true;
                default:
                    return true;
            }
        }
        QLog.e(TAG, 1, "packageDownloadEnd view is null");
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new EmotionDownloadOrUpdateViewHolder();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void onAdapterSelected() {
        ProgressButton progressButton;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        EmoticonPackage emoticonPackage = this.emotionPkg;
        if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            EmoticonPackage emoticonPackage2 = this.emotionPkg;
            int i3 = emoticonPackage2.mobileFeetype;
            if (i3 != 4 && i3 != 5) {
                if (!emoticonPackage2.valid) {
                    return;
                }
            } else {
                isAuthorized();
                if (!this.authType) {
                    return;
                }
            }
            EmojiManagerServiceProxy emojiManagerServiceProxy = (EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class);
            if (emojiManagerServiceProxy.getEmoticonPackageLoadingProgress(this.emotionPkg.epId) < 0.0f && NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "wifi auto download emotion , epid = " + this.emotionPkg.epId);
                }
                emojiManagerServiceProxy.pullEmoticonPackage(this.emotionPkg, false, this.businessType);
                EmotionDownloadOrUpdateViewHolder emotionDownloadOrUpdateViewHolder = this.holder;
                if (emotionDownloadOrUpdateViewHolder != null && (progressButton = emotionDownloadOrUpdateViewHolder.downloadBtn) != null) {
                    progressButton.setVisibility(0);
                    this.holder.downloadBtn.setText(BaseApplication.getContext().getString(R.string.f208915e0));
                    this.downBtnStatus = 1;
                }
                ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.emotionPkg.epId, "", "", "");
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "onAdapterSelected emotionpkg = null");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmoticonPackage emoticonPackage;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f164944bd3 && (emoticonPackage = this.emotionPkg) != null) {
            int i3 = emoticonPackage.mobileFeetype;
            boolean z16 = false;
            if (i3 != 4 && i3 != 5) {
                if (!emoticonPackage.valid) {
                    if (emoticonPackage.jobType == 4) {
                        z16 = true;
                    }
                    IBigEmotionService iBigEmotionService = (IBigEmotionService) QRoute.api(IBigEmotionService.class);
                    Context context = this.mContext;
                    IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
                    iBigEmotionService.openEmojiDetailPage(context, iEmoticonMainPanelApp, iEmoticonMainPanelApp.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, z16);
                }
                doDownloadOpr(false);
            } else {
                isAuthorized();
                if (!this.authType) {
                    String str2 = "mvip.g.a.bq_" + this.emotionPkg.epId;
                    if (this.emotionPkg.mobileFeetype == 5) {
                        str = "!svip";
                    } else {
                        str = "!vip";
                    }
                    String str3 = "https://mc.vip.qq.com/qqwallet/index?aid=" + str2 + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
                    if (this.mContext instanceof Activity) {
                        Intent intent = new Intent();
                        intent.putExtra("url", str3);
                        RouteUtils.startActivityForResult((Activity) this.mContext, intent, RouterConstants.UI_ROUTE_BROWSER, 4813);
                    }
                    if (!this.isSmallEmotion) {
                        ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
                    }
                }
                doDownloadOpr(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void packageDownloadEnd(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonPackage, i3);
            return;
        }
        if (i3 != 0 || emoticonPackage == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.obj = emoticonPackage;
        obtain.arg1 = i3;
        this.mUiHandler.sendMessage(obtain);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void payBack(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (i3 == 18) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "payback");
            }
            if (isCurrentPanel()) {
                doDownloadOpr(true);
                if (this.isSmallEmotion && this.emotionPkg != null) {
                    ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.emotionPkg.epId, "", "", "");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void refreashProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (emoticonPackage == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 101;
            obtain.obj = emoticonPackage;
            this.mUiHandler.sendMessage(obtain);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void refreshCover(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonPackage);
        } else {
            if (emoticonPackage == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = emoticonPackage;
            this.mUiHandler.sendMessage(obtain);
        }
    }

    public void updateDownloadUI(EmotionDownloadOrUpdateViewHolder emotionDownloadOrUpdateViewHolder) {
        EmoticonPackage emoticonPackage;
        String p16;
        URLDrawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emotionDownloadOrUpdateViewHolder);
            return;
        }
        if (emotionDownloadOrUpdateViewHolder != null && (emoticonPackage = this.emotionPkg) != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateUI epid = " + this.emotionPkg.epId);
            }
            emotionDownloadOrUpdateViewHolder.name.setText(this.emotionPkg.name);
            emotionDownloadOrUpdateViewHolder.name.setVisibility(0);
            String n3 = com.tencent.mobileqq.emosm.e.n(2, this.emotionPkg.epId);
            try {
                Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.c0i);
                Drawable drawable3 = BaseApplication.getContext().getResources().getDrawable(R.drawable.o4e);
                if (FileUtils.fileExists(n3)) {
                    drawable = URLDrawable.getDrawable(new URL("file:///" + n3), drawable2, drawable3);
                } else {
                    if (this.isSmallEmotion) {
                        p16 = com.tencent.mobileqq.emosm.e.p(19, this.emotionPkg.epId);
                    } else {
                        p16 = com.tencent.mobileqq.emosm.e.p(2, this.emotionPkg.epId);
                    }
                    drawable = URLDrawable.getDrawable(p16, drawable2, drawable3);
                }
                if (drawable != null) {
                    emotionDownloadOrUpdateViewHolder.cover.setImageDrawable(drawable);
                } else {
                    emotionDownloadOrUpdateViewHolder.cover.setImageResource(R.drawable.o4e);
                }
            } catch (OutOfMemoryError unused) {
                emotionDownloadOrUpdateViewHolder.cover.setImageResource(R.drawable.o4e);
            } catch (MalformedURLException unused2) {
                emotionDownloadOrUpdateViewHolder.cover.setImageResource(R.drawable.o4e);
            }
            emotionDownloadOrUpdateViewHolder.cover.setVisibility(0);
            float emoticonPackageLoadingProgress = ((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(this.emotionPkg.epId);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Ep id=" + this.emotionPkg.epId + ", progress=" + emoticonPackageLoadingProgress);
            }
            if (emoticonPackageLoadingProgress >= 0.0f) {
                emotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
                emotionDownloadOrUpdateViewHolder.downloadBtn.setProgress((int) (emoticonPackageLoadingProgress * 100.0f));
                emotionDownloadOrUpdateViewHolder.downloadBtn.setText(BaseApplication.getContext().getString(R.string.f208915e0));
                this.downBtnStatus = 1;
            } else {
                String string = BaseApplication.getContext().getString(R.string.f208965e5);
                if (this.isUpdatePanel) {
                    string = BaseApplication.getContext().getString(R.string.f209495fk);
                } else {
                    EmoticonPackage emoticonPackage2 = this.emotionPkg;
                    int i3 = emoticonPackage2.mobileFeetype;
                    if (i3 != 4 && i3 != 5) {
                        if (!emoticonPackage2.valid) {
                            string = BaseApplication.getContext().getString(R.string.f209515fm);
                        }
                    } else {
                        isAuthorized();
                        if (!this.authType) {
                            string = BaseApplication.getContext().getString(R.string.f209275ez);
                        }
                    }
                }
                emotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
                emotionDownloadOrUpdateViewHolder.downloadBtn.setProgress(0);
                emotionDownloadOrUpdateViewHolder.downloadBtn.setText(string);
                this.downBtnStatus = 2;
                if (isCurrentPanel()) {
                    onAdapterSelected();
                }
            }
            emotionDownloadOrUpdateViewHolder.downloadBtn.setOnClickListener(this);
            return;
        }
        QLog.e(TAG, 1, "updateUI holder is null");
    }
}
