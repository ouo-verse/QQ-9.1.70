package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ShareHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static String f259923g;

    /* renamed from: a, reason: collision with root package name */
    ShareActionSheet f259924a;

    /* renamed from: b, reason: collision with root package name */
    Context f259925b;

    /* renamed from: c, reason: collision with root package name */
    QQAppInterface f259926c;

    /* renamed from: d, reason: collision with root package name */
    Activity f259927d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f259928e;

    /* renamed from: f, reason: collision with root package name */
    b f259929f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass1 implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            if (ShareHelper.this.f259924a.isShowing()) {
                ShareHelper.this.f259924a.dismiss();
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
                    h.T(1, i3);
                    return;
                }
            }
            Bitmap bitmap = ShareHelper.this.f259928e;
            if (bitmap != null && !bitmap.isRecycled()) {
                ShareHelper.this.f259929f.W1(true);
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 9 || i16 == 10) {
                            ThreadManagerV2.postImmediately(new Runnable(i16) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ int f259937d;

                                {
                                    this.f259937d = i16;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                        ThreadManager.getUIHandler().post(new Runnable(ShareHelper.this.c()) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3.1
                                            static IPatchRedirector $redirector_;

                                            /* renamed from: d, reason: collision with root package name */
                                            final /* synthetic */ String f259939d;

                                            {
                                                this.f259939d = r5;
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) r5);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                if (ShareHelper.this.f259927d.isFinishing()) {
                                                    return;
                                                }
                                                ShareHelper.this.f259929f.W1(false);
                                                if (TextUtils.isEmpty(this.f259939d)) {
                                                    h.T(1, R.string.dzx);
                                                } else if (AnonymousClass3.this.f259937d == 9) {
                                                    WXShareHelper.b0().u0(this.f259939d, ShareHelper.this.f259928e, 0);
                                                } else {
                                                    WXShareHelper.b0().u0(this.f259939d, ShareHelper.this.f259928e, 1);
                                                }
                                            }
                                        });
                                    } else {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    }
                                }
                            }, null, true);
                            return;
                        }
                        return;
                    }
                    ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                ThreadManager.getUIHandler().post(new Runnable(ShareHelper.this.c()) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ String f259935d;

                                    {
                                        this.f259935d = r5;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (ShareHelper.this.f259927d.isFinishing()) {
                                            return;
                                        }
                                        ShareHelper.this.f259929f.W1(false);
                                        if (TextUtils.isEmpty(this.f259935d)) {
                                            h.T(1, R.string.dzx);
                                            return;
                                        }
                                        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                                        userInfo.qzone_uin = ShareHelper.this.f259926c.getAccount();
                                        QQAppInterface qQAppInterface = ShareHelper.this.f259926c;
                                        userInfo.nickname = ac.f(qQAppInterface, qQAppInterface.getAccount());
                                        Activity activity = ShareHelper.this.f259927d;
                                        QZoneHelper.forwardToPublishMood(activity, userInfo, this.f259935d, activity.getString(R.string.b1o), "\u5feb\u6765\u770b\u770b\u6211\u7684QQ\u4e2a\u6027\u6807\u7b7e\u5427", 1);
                                    }
                                });
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, null, true);
                    return;
                }
                ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            ThreadManager.getUIHandler().post(new Runnable(ShareHelper.this.c()) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f259932d;

                                {
                                    this.f259932d = r5;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC82391.this, (Object) r5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (ShareHelper.this.f259927d.isFinishing()) {
                                        return;
                                    }
                                    ShareHelper.this.f259929f.W1(false);
                                    if (TextUtils.isEmpty(this.f259932d)) {
                                        h.T(1, R.string.dzx);
                                        return;
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("forward_type", 1);
                                    bundle.putString(AppConstants.Key.FORWARD_FILEPATH, this.f259932d);
                                    bundle.putString(AppConstants.Key.FORWARD_THUMB, this.f259932d);
                                    bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.f259932d);
                                    bundle.putString(AppConstants.Key.FORWARD_EXTRA, this.f259932d);
                                    bundle.putInt(ForwardBaseOption.KEY_THUMB_STYLE_CENTERINSIDE, 1);
                                    Intent intent = new Intent();
                                    intent.putExtras(bundle);
                                    ForwardBaseOption.startForwardActivityForResult(ShareHelper.this.f259927d, intent, 21);
                                }
                            });
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, null, true);
                return;
            }
            h.T(1, R.string.fpb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f259941d;

        a(DialogInterface.OnDismissListener onDismissListener) {
            this.f259941d = onDismissListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareHelper.this, (Object) onDismissListener);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            DialogInterface.OnDismissListener onDismissListener = this.f259941d;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void W1(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f259923g = "https://ti.qq.com/specialtag/share.html?id=%s";
        }
    }

    public ShareHelper(Context context, QQAppInterface qQAppInterface, Activity activity, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, activity, bVar);
            return;
        }
        this.f259924a = null;
        this.f259925b = context;
        this.f259926c = qQAppInterface;
        this.f259927d = activity;
        this.f259929f = bVar;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return new ArrayList[]{arrayList};
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String c() {
        try {
            return h.P(this.f259927d, "temp_qrcode_share_" + System.currentTimeMillis() + this.f259926c.getCurrentAccountUin() + ".png", this.f259928e);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ShareHelper", 2, e16.getMessage());
            }
            return null;
        }
    }

    public void d(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.f259928e = bitmap;
        }
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onDismissListener);
            return;
        }
        if (this.f259924a == null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            a aVar = new a(onDismissListener);
            Context context = this.f259925b;
            if (context != null && (context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                intent.putExtra("big_brother_source_key", "biz_src_unknown");
            }
            ShareActionSheet create = ShareActionSheetFactory.create((Activity) this.f259925b, false);
            this.f259924a = create;
            create.setActionSheetTitle(HardCodeUtil.qqStr(R.string.hja));
            this.f259924a.setActionSheetItems(b(this.f259925b));
            this.f259924a.setItemClickListenerV2(anonymousClass1);
            this.f259924a.setOnDismissListener(aVar);
        }
        try {
            if (!this.f259924a.isShowing()) {
                this.f259924a.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }
}
