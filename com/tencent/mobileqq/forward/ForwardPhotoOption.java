package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.dataline.activities.LiteActivity;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class ForwardPhotoOption extends ForwardFileBaseOption implements al {
    static IPatchRedirector $redirector_;
    List<SendMultiPictureHelper> D;
    private c E;
    private boolean F;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class PhotoRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<Activity> f210721d;

        PhotoRunnable(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            } else {
                this.f210721d = new WeakReference<>(activity);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "preload peak");
            }
            if ((this.f210721d.get() instanceof Activity) && !this.f210721d.get().isFinishing()) {
                ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this.f210721d.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ForwardBaseOption.r {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPhotoOption.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPhotoOption.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f210724a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f210725b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f210726c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f210727d;

        /* renamed from: e, reason: collision with root package name */
        public View f210728e;

        /* renamed from: f, reason: collision with root package name */
        public ProgressBar f210729f;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(Drawable drawable, boolean z16, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            if (drawable == null) {
                return;
            }
            if (z16) {
                this.f210728e.setVisibility(0);
                this.f210724a.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f210727d.setLayoutParams(layoutParams);
                if (!z17) {
                    this.f210727d.setAdjustViewBounds(true);
                    this.f210727d.setMaxHeight(ViewUtils.dip2px(140.0f));
                    this.f210727d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    this.f210727d.setAdjustViewBounds(true);
                    this.f210727d.setMaxWidth(ViewUtils.dip2px(120.0f));
                    this.f210727d.setMaxHeight(ViewUtils.dip2px(120.0f));
                    this.f210727d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                this.f210727d.setImageDrawable(drawable);
                if (i3 < 2) {
                    this.f210728e.setBackgroundDrawable(null);
                    return;
                } else if (i3 == 2) {
                    this.f210728e.setBackgroundResource(R.drawable.cmv);
                    return;
                } else {
                    this.f210728e.setBackgroundResource(R.drawable.cmw);
                    return;
                }
            }
            this.f210728e.setVisibility(8);
            this.f210724a.setVisibility(0);
            this.f210724a.setCompoundDrawablePadding(0);
            this.f210724a.setCompoundDrawables(drawable, null, null, null);
            this.f210724a.setVisibility(0);
        }
    }

    public ForwardPhotoOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.F = true;
        this.mSurpportTroopDiscussionTmpConv = true;
        this.mForwardReportType = 6;
    }

    private String C(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file")) {
            if (scheme.equals("content")) {
                try {
                    Cursor query = ContactsMonitor.query(this.mActivity.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                    query.moveToFirst();
                    String string = query.getString(columnIndexOrThrow);
                    query.close();
                    return string;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return null;
        }
        return new File(uri.getPath()).getAbsolutePath();
    }

    private File D(Parcelable parcelable) {
        File file;
        if (parcelable instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) parcelable;
            int i3 = messageForPic.imageType;
            if (i3 != 3 && i3 != 2000) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage msgPic gif.");
            }
            boolean I = I();
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage msgPic gif. isFromGuide=" + I);
            }
            return new File(messageForPic.path);
        }
        if (parcelable instanceof AIOImageData) {
            AIOImageData aIOImageData = (AIOImageData) parcelable;
            int i16 = aIOImageData.P;
            if (i16 != 3 && i16 != 2000) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
            }
            if (aIOImageData.f(2)) {
                file = aIOImageData.a(2);
            } else if (aIOImageData.f(4)) {
                file = aIOImageData.a(4);
            } else {
                file = null;
            }
            if (file == null || !file.exists()) {
                return null;
            }
            return file;
        }
        return E();
    }

    private File E() {
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        if (string == null) {
            string = this.mForwardThumb;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath p: " + string);
        }
        boolean z16 = this.mExtraData.getBoolean(SearchEmoticonFragment.U, false);
        if (string != null && string.length() > 4 && (QzoneEmotionUtils.SIGN_ICON_URL_END.equals(string.substring(string.length() - 4, string.length())) || z16)) {
            File file = new File(string);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private void F(List<ResultRecord> list, boolean z16) {
        Object obj;
        if (this.mIntent.getBooleanExtra("isFromShare", false)) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mp6));
        }
        if (list == null) {
            return;
        }
        List<SendMultiPictureHelper> B = B(list.size());
        ArrayList<String> stringArrayList = this.mExtraData.getStringArrayList("foward_key_m_p_l");
        if (stringArrayList == null && (obj = this.mExtraData.get("android.intent.extra.STREAM")) != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            stringArrayList = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String t16 = t((Uri) arrayList.get(i3), false, null);
                if (!TextUtils.isEmpty(t16)) {
                    stringArrayList.add(t16);
                }
            }
        }
        if (stringArrayList != null && stringArrayList.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                ResultRecord resultRecord = list.get(i16);
                B.get(i16).n(resultRecord.groupUin, resultRecord.uin, resultRecord.getUinType(), resultRecord.name, this.mExtraData, stringArrayList);
            }
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, this.mActivity.getResources().getString(R.string.he7), 0).show();
    }

    private void G(String str, String str2, int i3, String str3, boolean z16) {
        Object obj;
        if (this.mIntent.getBooleanExtra("isFromShare", false)) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mpc));
        }
        SendMultiPictureHelper sendMultiPictureHelper = B(1).get(0);
        ArrayList<String> stringArrayList = this.mExtraData.getStringArrayList("foward_key_m_p_l");
        if (stringArrayList == null && (obj = this.mExtraData.get("android.intent.extra.STREAM")) != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            stringArrayList = new ArrayList<>();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                String t16 = t((Uri) arrayList.get(i16), false, null);
                if (!TextUtils.isEmpty(t16)) {
                    stringArrayList.add(t16);
                }
            }
        }
        ArrayList<String> arrayList2 = stringArrayList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            sendMultiPictureHelper.n(str, str2, i3, str3, this.mExtraData, arrayList2);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, this.mActivity.getResources().getString(R.string.he7), 0).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H() {
        Rect rect;
        boolean z16;
        URL url;
        boolean z17;
        File D = D(this.mExtraData.getParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC));
        if (D == null && BaseImageUtil.isGifFile(this.mForwardThumb)) {
            D = new File(this.mForwardThumb);
        }
        Rect rect2 = null;
        URL url2 = null;
        if (D != null) {
            try {
                rect = NativeGifImage.getImageSize(D, false);
            } catch (IOException e16) {
                e = e16;
                rect = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                rect = null;
            }
            try {
                url2 = D.toURI().toURL();
                z16 = true;
            } catch (IOException e18) {
                e = e18;
                e.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize " + e.toString());
                }
                z16 = false;
                Rect rect3 = rect;
                url = url2;
                rect2 = rect3;
                z17 = z16;
                if (z17) {
                }
                if (!z17) {
                }
            } catch (OutOfMemoryError e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize oom " + e.toString());
                }
                z16 = false;
                Rect rect32 = rect;
                url = url2;
                rect2 = rect32;
                z17 = z16;
                if (z17) {
                }
                if (!z17) {
                }
            }
            Rect rect322 = rect;
            url = url2;
            rect2 = rect322;
            z17 = z16;
        } else {
            z17 = false;
            url = null;
        }
        if (z17) {
            this.mForwardReportType = 5;
        }
        if (!z17) {
            updateImageView(this.mForwardThumb, this.mConfirmDialog);
            ThreadManager.getSubThreadHandler().postDelayed(new PhotoRunnable(this.mActivity), 1000L);
            return;
        }
        if (rect2 != null && url != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath load gif start " + url.toString());
            }
            int width = rect2.width();
            int height = rect2.height();
            float f16 = this.mActivity.getResources().getDisplayMetrics().densityDpi / 160;
            int i3 = (int) (width * f16);
            int i16 = (int) (height * f16);
            try {
                this.E.a(URLDrawableHelper.getDrawable(url, i3, i16, new com.tencent.mobileqq.drawable.b(i3, i16), BaseURLDrawableHelper.getFailedDrawable(), true), true, 0, true);
                this.E.f210727d.setOnTouchListener(new b());
                return;
            } catch (OutOfMemoryError e26) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage_getDrawable oom " + e26.toString());
                    return;
                }
                return;
            }
        }
        updateImageView(this.mForwardThumb, this.mConfirmDialog);
    }

    private boolean I() {
        Intent intent = this.mIntent;
        if (intent == null || intent.getIntExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, 0) != 4) {
            return false;
        }
        return true;
    }

    private boolean J() {
        List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
        this.mExtraData.putBoolean("isBack2Root", false);
        Boolean valueOf = Boolean.valueOf(this.mIntent.getBooleanExtra("sendMultiple", false));
        boolean booleanExtra = this.mIntent.getBooleanExtra("isFromShare", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("isJumpAIO", false);
        boolean booleanExtra3 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra4 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + valueOf + "isFromShare=" + booleanExtra);
        }
        if (this.mFromSharePanelPreviewAndSend) {
            Intent intent = new Intent();
            intent.putExtras(this.mExtraData);
            return ForwardUtils.w(this.app, this.mActivity, this.mAppContext, intent, null);
        }
        if (valueOf.booleanValue()) {
            F(multiTargetWithoutDataLine, booleanExtra);
            return true;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        m3.putExtra("KEY_MSG_FORWARD_ID", this.mExtraData.getInt("KEY_MSG_FORWARD_ID", 0));
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo != null && forwardFileInfo.getType() == 10011) {
            m3.putExtras(this.mExtraData);
            ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
        } else {
            ForwardFileInfo forwardFileInfo2 = this.f210624d;
            if (forwardFileInfo2 != null && forwardFileInfo2.getType() == 10012) {
                m3.addFlags(268435456);
                m3.addFlags(67108864);
                m3.putExtras(this.mExtraData);
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            } else if (this.mExtraData.getBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, false)) {
                m3.putExtras(this.mExtraData);
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            } else {
                if (booleanExtra) {
                    this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mp9));
                    m3.addFlags(268435456);
                    m3.addFlags(67108864);
                    m3.putExtras(this.mExtraData);
                    boolean handleForwardFromFavorite = handleForwardFromFavorite(m3);
                    boolean z16 = this.mExtraData.getBoolean("isFromFavorites");
                    if (QLog.isColorLevel()) {
                        QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + z16 + "isFromAIOFav=" + handleForwardFromFavorite);
                    }
                    if (this.isFormJump) {
                        ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                    } else if (!booleanExtra2) {
                        ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                    }
                }
                this.mExtraData.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, this.mActivity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
                m3.putExtras(this.mExtraData);
                if (booleanExtra3 || booleanExtra4) {
                    m3.removeExtra(AppConstants.Key.FORWARD_FILEPATH);
                    m3.removeExtra(AppConstants.Key.FORWARD_EXTRA);
                    this.mActivity.startActivity(m3);
                }
            }
        }
        this.mActivity.setResult(-1, m3);
        return false;
    }

    public List<SendMultiPictureHelper> B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(new SendMultiPictureHelper((BaseActivity) this.mActivity));
        }
        if (!arrayList.isEmpty()) {
            if (this.D == null) {
                this.D = new ArrayList();
            }
            this.D.addAll(arrayList);
        }
        return arrayList;
    }

    boolean K() {
        Intent m3;
        String str;
        this.mExtraData.putBoolean("isBack2Root", false);
        int i3 = this.mExtraData.getInt("uintype");
        String string = this.mExtraData.getString("uin");
        String string2 = this.mExtraData.getString("uinname");
        String string3 = this.mExtraData.getString("troop_uin");
        Boolean valueOf = Boolean.valueOf(this.mIntent.getBooleanExtra("sendMultiple", false));
        boolean booleanExtra = this.mIntent.getBooleanExtra("isFromShare", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("isJumpAIO", false);
        boolean booleanExtra3 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra4 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + valueOf + "isFromShare=" + booleanExtra);
        }
        if (valueOf.booleanValue()) {
            G(string3, string, i3, string2, booleanExtra);
            return true;
        }
        if (i3 == 1008) {
            m3 = new Intent(this.mActivity, (Class<?>) ChatActivity.class);
            m3.putExtra("chat_subType", ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(string, this.app));
        } else {
            m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        }
        if (i3 == 10014 && !booleanExtra && !booleanExtra2) {
            this.mExtraData.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        }
        AutoSaveUtils.d(true, this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH));
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(string)) {
            ForwardUtils.m(this.mIntent, this.mExtraData, this.app, string3, string, i3);
            this.mExtraData.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, this.mActivity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
            m3.putExtras(this.mExtraData);
            m3.removeExtra(AppConstants.Key.FORWARD_FILEPATH);
            m3.removeExtra(AppConstants.Key.FORWARD_EXTRA);
            m3.putExtra("forward_type", Integer.MAX_VALUE);
        } else {
            ForwardFileInfo forwardFileInfo = this.f210624d;
            if (forwardFileInfo != null && forwardFileInfo.getType() == 10011) {
                m3.putExtras(this.mExtraData);
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            } else {
                ForwardFileInfo forwardFileInfo2 = this.f210624d;
                if (forwardFileInfo2 != null && forwardFileInfo2.getType() == 10012) {
                    m3.addFlags(268435456);
                    m3.addFlags(67108864);
                    m3.putExtras(this.mExtraData);
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                } else if (this.mExtraData.getBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, false)) {
                    m3.putExtras(this.mExtraData);
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                } else if (this.mExtraData.getBoolean(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT, false)) {
                    m3.putExtras(this.mExtraData);
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                } else {
                    if (booleanExtra) {
                        this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mpa));
                        m3.addFlags(268435456);
                        m3.addFlags(67108864);
                        m3.putExtras(this.mExtraData);
                        boolean handleForwardFromFavorite = handleForwardFromFavorite(m3);
                        boolean z16 = this.mExtraData.getBoolean("isFromFavorites");
                        if (QLog.isColorLevel()) {
                            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + z16 + "isFromAIOFav=" + handleForwardFromFavorite);
                        }
                        if (this.isFormJump) {
                            m3.putExtra("KEY_JUMP_FORWARD_TIME", System.currentTimeMillis());
                            this.mActivity.startActivity(m3);
                        } else if (!booleanExtra2) {
                            ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
                        }
                    }
                    this.mExtraData.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, this.mActivity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
                    m3.putExtras(this.mExtraData);
                    if (booleanExtra3 || booleanExtra4) {
                        if (i3 == 0) {
                            str = "0X8007812";
                        } else if (i3 == 1) {
                            str = "0X8007813";
                        } else if (i3 == 3000) {
                            str = "0X8007814";
                        } else {
                            str = "";
                        }
                        String str2 = str;
                        ReportController.o(this.app, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                        m3.removeExtra(AppConstants.Key.FORWARD_FILEPATH);
                        m3.removeExtra(AppConstants.Key.FORWARD_EXTRA);
                        this.mActivity.startActivity(m3);
                    }
                }
            }
        }
        this.mIntent.putExtra("is_need_show_toast", m3.getBooleanExtra("is_need_show_toast", true));
        jq3.a.g(this.mIntent);
        this.mActivity.setResult(-1, m3);
        this.mActivity.finish();
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void addOtherEditListener() {
        View.OnClickListener imageEditListener;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.E != null && (imageEditListener = getImageEditListener(new a())) != null && (imageView = this.E.f210727d) != null) {
            imageView.setOnClickListener(imageEditListener);
            this.E.f210727d.setContentDescription(HardCodeUtil.qqStr(R.string.mpb));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (!TextUtils.isEmpty(this.mForwardThumb)) {
            this.mConfirmDialog.setMessage((CharSequence) null);
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        this.mForwardAbilities.add(e.V3);
        boolean booleanExtra = this.mIntent.getBooleanExtra("k_phonecontacts", true);
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if ((forwardFileInfo == null || forwardFileInfo.getType() != 10006) && allowPhoneContactAbility() && booleanExtra) {
            this.mForwardAbilities.add(e.U3);
        }
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("k_dataline", true);
        boolean booleanExtra3 = this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_IS_SELFIE_FACE, false);
        if (booleanExtra2 && !booleanExtra3) {
            this.mForwardAbilities.add(e.S3);
            this.mForwardAbilities.add(e.X3);
            this.mForwardAbilities.add(e.f211017e4);
        }
        if (this.mIntent.getBooleanExtra("k_smartdevice", true) && allowSmartDeviceAbility()) {
            this.mForwardAbilities.add(e.W3);
        }
        if (this.mIntent.getBooleanExtra("k_qzone", false)) {
            this.mForwardAbilities.add(e.R3);
        }
        if (this.mIntent.getBooleanExtra("k_qqstory", false)) {
            this.mForwardAbilities.add(e.Z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f167851jj, (ViewGroup) null);
        c cVar = new c();
        this.E = cVar;
        cVar.f210725b = (TextView) inflate.findViewById(R.id.bqm);
        this.E.f210724a = (TextView) inflate.findViewById(R.id.fyd);
        this.E.f210727d = (ImageView) inflate.findViewById(R.id.cla);
        this.E.f210728e = inflate.findViewById(R.id.cl_);
        this.E.f210726c = (TextView) inflate.findViewById(R.id.f164981bj1);
        this.E.f210729f = (ProgressBar) inflate.findViewById(R.id.bk_);
        this.E.f210728e.setMinimumHeight(ViewUtils.dip2px(85.0f));
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            int dip2px = ViewUtils.dip2px(15.0f);
            inflate.setPadding(0, dip2px, 0, dip2px);
        }
        H();
        ArrayList<String> stringArrayList = this.mExtraData.getStringArrayList("foward_key_m_p_l");
        if (stringArrayList != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.dialogText);
            textView.setVisibility(0);
            textView.setText(HardCodeUtil.qqStr(R.string.mp_) + stringArrayList.size() + HardCodeUtil.qqStr(R.string.mp7));
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH, "");
        if (TextUtils.isEmpty(string)) {
            string = this.mForwardThumb;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new SharePublishGuildFeedParam.PhotoTypeParam(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void enterImageGallery(Bundle bundle, AIOImageProviderService aIOImageProviderService, AIORichMediaData aIORichMediaData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, bundle, aIOImageProviderService, aIORichMediaData);
            return;
        }
        if (this.mExtraData.getBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, false)) {
            bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        }
        super.enterImageGallery(bundle, aIOImageProviderService, aIORichMediaData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.forwardOnCancel();
        int i3 = getExtras().getInt("key_forward_ability_type");
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "-->getCancelListener--onClick--type = " + i3);
        }
        if (i3 == e.Z3.intValue()) {
            id0.a.n("plus_shoot", "nosend_tip", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        reportSendAction();
        boolean z16 = false;
        if (this.fromCreateDiscussion) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.fromCreateDiscussion = false;
        }
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                sendMessage2TargetOnConfirm(resultRecord.uin, resultRecord.groupUin, resultRecord.getUinType());
            }
            if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false)) {
                int i3 = this.mExtraData.getInt("KEY_MSG_FORWARD_ID", 0);
                for (ResultRecord resultRecord2 : multiTargetWithoutDataLine) {
                    z16 |= ForwardSendPicUtil.b(this.app, this.mForwardThumb, 0, resultRecord2.uin, resultRecord2.getUinType(), resultRecord2.groupUin, true, this.mActivity, i3);
                }
                if (z16) {
                    this.mActivity.setResult(-1);
                    return;
                }
                return;
            }
            forwardToTarget();
            return;
        }
        super.sendMessageOnConfirm();
        if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false)) {
            if (ForwardSendPicUtil.b(this.app, this.mForwardThumb, this.mExtraData.getInt(AppConstants.Key.FORWARD_PIC_SUB_TYPE, 0), this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), this.mExtraData.getString("troop_uin"), true, this.mActivity, this.mExtraData.getInt("KEY_MSG_FORWARD_ID", 0))) {
                this.mActivity.setResult(-1);
            }
            this.mActivity.finish();
            return;
        }
        forwardToTarget();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToDataLine(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        Bundle bundle = new Bundle();
        String str = AppConstants.DATALINE_PC_UIN;
        if (i3 == e.X3.intValue()) {
            str = AppConstants.DATALINE_IPAD_UIN;
        } else if (i3 == e.f211017e4.intValue()) {
            str = AppConstants.DATALINE_PHONE_UIN;
        }
        bundle.putAll(this.mExtraData);
        if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false)) {
            LiteActivity.C4(this.app, this.mForwardThumb, this.mActivity);
            String stringExtra = this.mIntent.getStringExtra("caller_name");
            int intExtra = this.mIntent.getIntExtra("forward_type", Integer.MAX_VALUE);
            String stringExtra2 = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            if (("QQBrowserActivity".equals(stringExtra) || "PublicAccountBrowser".equals(stringExtra)) && intExtra == 1 && !TextUtils.isEmpty(stringExtra2)) {
                this.mActivity.setResult(-1);
            } else {
                this.mActivity.setResult(-1, this.mIntent);
            }
            sendDataLineMessage(bundle, str, null);
            this.mActivity.finish();
            return;
        }
        super.forwardToDataLine(i3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void forwardToQQStory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
        ReportController.o(this.app, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
        id0.a.n("plus_shoot", "send_tip", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void forwardToQZone(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        ArrayList<String> stringArrayListExtra = this.mIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
            QZoneHelper.publishPictureMoodSilently(str, stringArrayListExtra, ShortVideoConstants.SOURCE_FROM_QUICK_SHOOT);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "content:" + str + "path:" + stringArrayListExtra);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent.setFlags(67108864);
        aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 4);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(SplashActivity.SWITCH_ANIM, true);
        aliasIntent.putExtra("forward_to_someplace_from_shoot_quick", 1002);
        this.mActivity.setResult(-1, aliasIntent);
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public Bitmap getFilePathBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        Bitmap i3 = com.tencent.mobileqq.util.j.i(str, 100, 100);
        if (i3 != null) {
            return aw.s(i3, new File(str));
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d5, code lost:
    
        if (r3.uin.equalsIgnoreCase(com.tencent.mobileqq.app.AppConstants.DATALINE_PC_UIN) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
    
        com.tencent.qphone.base.util.QLog.d("ForwardOption.ForwardPhotoOption", 2, "getForwardRecentList uin = " + r3.uin + "  | fromNewImgType = " + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fb, code lost:
    
        if (r1 != 1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fd, code lost:
    
        r0.add(r3);
     */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (this.mIntent.getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 0) == 9501) {
            return arrayList;
        }
        int intExtra = this.mIntent.getIntExtra(RichMediaBrowserConstants.KEY_TYPE_FROM_NEW_IMG_SHARE_ACTION_SHEET, 0);
        Iterator<RecentUser> it = list.iterator();
        while (it.hasNext()) {
            RecentUser next = it.next();
            if (next != null && !Utils.J(next.uin) && next.getType() != 1003 && next.getType() != 1008 && next.getType() != 1021 && next.getType() != 10004 && ((next.getType() != 1 || !isHotChat(next.uin)) && ((next.getType() != 1006 || isSupportAbility(e.U3)) && next.getType() != 7000 && next.getType() != 6004 && next.getType() != 9501 && ((next.getType() != 0 || !CrmUtils.v(this.app, next.uin, next.getType())) && ((next.getType() != 1004 && next.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv))))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isFromLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.mExtraData.getBoolean("key_allow_multiple_forward_from_limit", true);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 19001 && i16 == -1) {
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardPhotoOption", 2, "refresh forward preview,editPicPath:" + stringExtra + " :currentFile" + string);
            }
            if (!string.equals(stringExtra)) {
                this.isURLDrawablFoward = false;
                this.mExtraData.remove(AppConstants.Key.FORWARD_MSG_FOR_PIC);
                this.mExtraData.putString(AppConstants.Key.FORWARD_FILEPATH, stringExtra);
                this.mExtraData.putString(AppConstants.Key.FORWARD_EXTRA, stringExtra);
                this.mExtraData.putBoolean(AEEditorConstants.EXTRA_IS_EDITED_PIC, true);
                w(stringExtra);
                updateImageView(this.mForwardThumb, this.mConfirmDialog);
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        List<SendMultiPictureHelper> list = this.D;
        if (list != null) {
            Iterator<SendMultiPictureHelper> it = list.iterator();
            while (it.hasNext()) {
                it.next().h();
            }
            this.D.clear();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption
    protected String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String str = ForwardFileBaseOption.C;
        if (str == null) {
            return this.mAppContext.getString(R.string.f173140hj4);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        if (TextUtils.isEmpty(this.mForwardThumb)) {
            this.mForwardThumb = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (this.mIntent.getBooleanExtra("sendMultiple", false) && this.mIntent.getStringArrayListExtra("foward_key_m_p_l") == null && (obj = this.mExtraData.get("android.intent.extra.STREAM")) != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Uri uri = (Uri) arrayList.get(i3);
                if (uri != null) {
                    String t16 = t(uri, false, null);
                    if (!TextUtils.isEmpty(t16)) {
                        arrayList2.add(t16);
                    }
                }
            }
            this.mExtraData.putStringArrayList("foward_key_m_p_l", arrayList2);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (isMultiTarget2Send()) {
            return J();
        }
        return K();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0128  */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int realShareToQfav() {
        int i3;
        ForwardFileInfo forwardFileInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int i16 = 0;
        if (this.mExtraData.getBoolean("sendMultiple", false)) {
            ArrayList arrayList = (ArrayList) this.mExtraData.get("android.intent.extra.STREAM");
            QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + arrayList.size());
            int i17 = 0;
            while (true) {
                if (i17 >= arrayList.size()) {
                    break;
                }
                if (!QfavBuilder.e0(C((Uri) arrayList.get(i17))).C(this.app).e(this.mActivity, this.app.getAccount(), -1, null)) {
                    i16 = -1;
                    break;
                }
                i17++;
            }
        } else {
            QLog.i("Qfav", 1, "shareToQfav single pic");
            String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
            if (TextUtils.isEmpty(string) && (forwardFileInfo = this.f210624d) != null) {
                string = forwardFileInfo.l();
            }
            if (TextUtils.isEmpty(string)) {
                string = this.mExtraData.getString("GALLERY.FORWORD_LOCAL_PATH");
            }
            if (TextUtils.isEmpty(string)) {
                string = this.mForwardThumb;
            }
            if (TextUtils.isEmpty(string) || (!new File(string).exists() ? !QfavBuilder.f0(this.mIntent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_MD5), -1, this.mIntent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH), this.mIntent.getLongExtra(AppConstants.Key.FORWARD_PHOTO_GROUP_FILEID, 0L), this.mIntent.getStringExtra(AppConstants.Key.FORWARD_EXTRA), this.mIntent.getLongExtra(AppConstants.Key.FORWARD_FILE_SIZE, 0L)).e(this.mActivity, this.app.getAccount(), -1, null) : !QfavBuilder.e0(string).C(this.app).e(this.mActivity, this.app.getAccount(), -1, null))) {
                i3 = -1;
                if (i3 == 0) {
                    cooperation.qqfav.d.d(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
                }
                return i3;
            }
        }
        i3 = i16;
        if (i3 == 0) {
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineMultiple(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) intent);
            return;
        }
        ArrayList parcelableArrayList = this.mExtraData.getParcelableArrayList("fileinfo_array");
        ArrayList<String> arrayList = null;
        if (parcelableArrayList == null) {
            parcelableArrayList = null;
        }
        ArrayList arrayList2 = (ArrayList) this.mExtraData.get("android.intent.extra.STREAM");
        int i3 = 0;
        if (parcelableArrayList == null) {
            ArrayList<String> stringArrayList = this.mExtraData.getStringArrayList("foward_key_m_p_l");
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                stringArrayList = new ArrayList<>();
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    stringArrayList.add(ForwardFileBaseOption.r(this.mActivity, (Uri) arrayList2.get(i16)));
                }
            }
            arrayList = stringArrayList;
            intent.putStringArrayListExtra("dataline_forward_pathlist", arrayList);
        }
        if (arrayList != null && arrayList.size() >= 4) {
            int i17 = 0;
            while (i3 < arrayList.size()) {
                if (com.tencent.qqnt.aio.element.file.util.a.e(arrayList.get(i3)) == 0) {
                    i17++;
                }
                i3++;
            }
            i3 = i17;
        }
        intent.putExtra("dataline_forward_type", 101);
        intent.putExtra("sendMultiple", true);
        if (i3 >= 4) {
            this.mExtraData.putBoolean("forward_jump_to_data_line_aio", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
            return;
        }
        intent.putExtra("dataline_forward_type", 101);
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_EXTRA);
        if (string == null) {
            string = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_EXTRA);
        }
        if (string == null) {
            string = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (string == null) {
            string = this.mExtraData.getString("GALLERY.FORWORD_LOCAL_PATH");
        }
        QLog.d("ForwardOption.ForwardPhotoOption", 1, "sendDatalineSingle filePath: " + string);
        intent.putExtra("filepath_copy", this.mIntent.getBooleanExtra("filepath_copy", false));
        if (!TextUtils.isEmpty(string) && FileManagerUtil.getFileType(string) != 0) {
            String str = string + ".jpg";
            File file = new File(string);
            File file2 = new File(str);
            file.renameTo(file2);
            ThreadManagerV2.excute(new Runnable(file2, file) { // from class: com.tencent.mobileqq.forward.ForwardPhotoOption.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ File f210715d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ File f210716e;

                {
                    this.f210715d = file2;
                    this.f210716e = file;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ForwardPhotoOption.this, file2, file);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.filemanager.util.q.b(this.f210715d, this.f210716e);
                    }
                }
            }, 64, null, false);
            string = str;
        }
        intent.putExtra("dataline_forward_path", string);
        AutoSaveUtils.d(true, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        boolean sendMessage2TargetOnConfirm = super.sendMessage2TargetOnConfirm(str, str2, i3);
        boolean booleanExtra = this.mIntent.getBooleanExtra("isFromShare", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("sendMultiple", false);
        if (booleanExtra && booleanExtra2 && !sendMessage2TargetOnConfirm) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = i3;
            sessionInfo.f179557e = str;
            sessionInfo.f179559f = str2;
            String string = this.mExtraData.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
            if (string != null && !"".equals(string)) {
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, string);
            }
        }
        return sendMessage2TargetOnConfirm;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void setPreviewImage(Drawable drawable, boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawable, z16, i3) { // from class: com.tencent.mobileqq.forward.ForwardPhotoOption.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f210717d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f210718e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f210719f;

                /* renamed from: com.tencent.mobileqq.forward.ForwardPhotoOption$4$a */
                /* loaded from: classes12.dex */
                class a implements View.OnTouchListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
                        }
                        return true;
                    }
                }

                {
                    this.f210717d = drawable;
                    this.f210718e = z16;
                    this.f210719f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ForwardPhotoOption.this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ForwardBaseOption.threadChagedTime = System.currentTimeMillis();
                    long j3 = ForwardBaseOption.threadChagedTime - ForwardBaseOption.decodeRoundTime;
                    if (QLog.isColorLevel()) {
                        QLog.i(ForwardBaseOption.PERFORMANCE_TAG, 1, "changeThreadCostTime:" + j3);
                    }
                    QQCustomDialog qQCustomDialog = ForwardPhotoOption.this.mConfirmDialog;
                    if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
                        ForwardPhotoOption forwardPhotoOption = ForwardPhotoOption.this;
                        if (!forwardPhotoOption.mFromSharePanelPreviewAndSend && !forwardPhotoOption.useBottomSheetPreview()) {
                            return;
                        }
                    }
                    if (ForwardPhotoOption.this.E != null) {
                        ForwardBaseOption.threadChagedTime = System.currentTimeMillis();
                        QLog.d(ForwardBaseOption.PERFORMANCE_TAG, 1, "threadChangedTConst\uff1a" + (ForwardBaseOption.threadChagedTime - ForwardBaseOption.decodeRoundTime));
                        ForwardPhotoOption.this.E.a(this.f210717d, this.f210718e, this.f210719f, false);
                        long currentTimeMillis = System.currentTimeMillis();
                        QLog.d(ForwardBaseOption.PERFORMANCE_TAG, 1, "showPreviewImageCost\uff1a" + (currentTimeMillis - ForwardBaseOption.clickShareBeginTime) + " diplayCost:" + (currentTimeMillis - ForwardBaseOption.threadChagedTime));
                        if (ForwardPhotoOption.this.F) {
                            ForwardPhotoOption.this.addOtherEditListener();
                        } else {
                            ForwardPhotoOption.this.E.f210727d.setOnTouchListener(new a());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption
    protected void w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mForwardThumb = str;
        }
    }
}
