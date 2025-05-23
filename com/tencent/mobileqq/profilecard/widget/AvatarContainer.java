package com.tencent.mobileqq.profilecard.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AvatarContainer extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileEdit.AvatarContainer";
    private WeakReference<QBaseActivity> mActivity;
    private AllInOne mAllInOne;
    private BaseQQAppInterface mApp;
    private FrameLayout mAvatarLayout;
    private final com.tencent.mobileqq.avatar.observer.a mAvatarObserver;
    private final BroadcastReceiver mAvatarReceiver;
    private int mSourceFrom;
    private Uri mUploadPhotoUri;

    public AvatarContainer(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSourceFrom = 0;
        this.mAvatarObserver = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                super.onUpdateCustomHead(z16, str);
                if (z16 && Utils.p(AvatarContainer.this.mApp.getCurrentAccountUin(), str)) {
                    AvatarContainer.this.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AvatarContainer.this.updateAvatar();
                            }
                        }
                    });
                }
            }
        };
        this.mAvatarReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context2, (Object) intent);
                } else if (IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT.equals(intent.getAction())) {
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).uploadAvatar(AvatarContainer.this.mApp, AvatarContainer.this.getContext(), intent, AvatarContainer.this.mAvatarLayout);
                }
            }
        };
        init();
    }

    private void init() {
        FrameLayout createAvatarLayout = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).createAvatarLayout(getContext());
        this.mAvatarLayout = createAvatarLayout;
        addView(createAvatarLayout, 0);
    }

    public void onCreate(BaseQQAppInterface baseQQAppInterface, QBaseActivity qBaseActivity, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, baseQQAppInterface, qBaseActivity, allInOne);
            return;
        }
        this.mApp = baseQQAppInterface;
        this.mActivity = new WeakReference<>(qBaseActivity);
        this.mAllInOne = allInOne;
        this.mApp.addObserver(this.mAvatarObserver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT);
        getContext().registerReceiver(this.mAvatarReceiver, intentFilter);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mApp.removeObserver(this.mAvatarObserver);
            getContext().unregisterReceiver(this.mAvatarReceiver);
        }
    }

    public void showActionSheet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.mActivity.get();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).showAvatarActionSheet(this.mApp, qBaseActivity, ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getAvatar(this.mAvatarLayout), this.mAllInOne, new IProfileEditApi.OnTakePhotoListener() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.OnTakePhotoListener
                public void onSetSourceFrom(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                        AvatarContainer.this.mSourceFrom = i3;
                    } else {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.OnTakePhotoListener
                public void onStartTakePhoto(Uri uri) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        AvatarContainer.this.mUploadPhotoUri = uri;
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uri);
                    }
                }
            }, 2, IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT);
        }
    }

    public void startCropPhoto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startCropPhoto(this.mActivity.get(), this.mUploadPhotoUri, this.mSourceFrom, IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT);
        }
    }

    public void updateAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setAvatarDrawable(this.mApp, this.mAvatarLayout);
        }
    }

    public AvatarContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mSourceFrom = 0;
        this.mAvatarObserver = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                super.onUpdateCustomHead(z16, str);
                if (z16 && Utils.p(AvatarContainer.this.mApp.getCurrentAccountUin(), str)) {
                    AvatarContainer.this.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AvatarContainer.this.updateAvatar();
                            }
                        }
                    });
                }
            }
        };
        this.mAvatarReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context2, (Object) intent);
                } else if (IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT.equals(intent.getAction())) {
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).uploadAvatar(AvatarContainer.this.mApp, AvatarContainer.this.getContext(), intent, AvatarContainer.this.mAvatarLayout);
                }
            }
        };
        init();
    }

    public AvatarContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSourceFrom = 0;
        this.mAvatarObserver = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                super.onUpdateCustomHead(z16, str);
                if (z16 && Utils.p(AvatarContainer.this.mApp.getCurrentAccountUin(), str)) {
                    AvatarContainer.this.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AvatarContainer.this.updateAvatar();
                            }
                        }
                    });
                }
            }
        };
        this.mAvatarReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.widget.AvatarContainer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarContainer.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context2, (Object) intent);
                } else if (IProfileCardConst.ACTION_PROFILE_EDIT_AVATAR_FROM_PHOTO_EDIT.equals(intent.getAction())) {
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).uploadAvatar(AvatarContainer.this.mApp, AvatarContainer.this.getContext(), intent, AvatarContainer.this.mAvatarLayout);
                }
            }
        };
        init();
    }
}
