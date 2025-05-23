package com.tencent.mobileqq.relation.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationLoginAvatar;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.app.AppRuntime;

/* loaded from: classes17.dex */
public class ProfileCardUtilImpl implements IProfileCardUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardUtilImpl";

    /* loaded from: classes17.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri[] f280595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f280596b;

        a(Uri[] uriArr, Activity activity) {
            this.f280595a = uriArr;
            this.f280596b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileCardUtilImpl.this, uriArr, activity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f280595a[0] = ProfileCardUtils.enterSnapshot(this.f280596b, 5);
            }
        }
    }

    public ProfileCardUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public void decodeAvatar(String str, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) imageView);
        } else {
            ThreadManagerV2.excute(new Runnable(str, imageView) { // from class: com.tencent.mobileqq.relation.api.impl.ProfileCardUtilImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f280591d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ImageView f280592e;

                {
                    this.f280591d = str;
                    this.f280592e = imageView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileCardUtilImpl.this, str, imageView);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
                /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    BufferedInputStream bufferedInputStream;
                    Throwable th5;
                    Exception exc;
                    Bitmap bitmap;
                    Bitmap bitmap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        try {
                            File file = new File(this.f280591d);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            try {
                                options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, this.f280592e.getWidth(), this.f280592e.getHeight());
                                bufferedInputStream.close();
                                bitmap2 = j.d(this.f280591d, options);
                                if (bitmap2 != null) {
                                    bitmap2 = QQAppInterface.getCircleFaceBitmap(bitmap2, bitmap2.getWidth(), bitmap2.getHeight());
                                }
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e16) {
                                    QLog.w(ProfileCardUtilImpl.TAG, 1, e16.toString());
                                }
                            } catch (Exception e17) {
                                exc = e17;
                                bitmap = null;
                                bufferedInputStream2 = bufferedInputStream;
                                QLog.w(ProfileCardUtilImpl.TAG, 1, exc.toString());
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e18) {
                                        QLog.w(ProfileCardUtilImpl.TAG, 1, e18.toString());
                                    }
                                }
                                bitmap2 = bitmap;
                                if (bitmap2 == null) {
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e19) {
                                        QLog.w(ProfileCardUtilImpl.TAG, 1, e19.toString());
                                    }
                                }
                                throw th5;
                            }
                        } catch (Throwable th7) {
                            bufferedInputStream = bufferedInputStream2;
                            th5 = th7;
                        }
                    } catch (Exception e26) {
                        exc = e26;
                        bitmap = null;
                    }
                    if (bitmap2 == null) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(bitmap2) { // from class: com.tencent.mobileqq.relation.api.impl.ProfileCardUtilImpl.2.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Bitmap f280593d;

                            {
                                this.f280593d = bitmap2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) bitmap2);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass2.this.f280592e.setImageBitmap(this.f280593d);
                                }
                            }
                        });
                    }
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public void enterClipPage(Activity activity, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) uri);
            return;
        }
        if (activity != null && uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(activity, uri);
            Intent intent = new Intent();
            int x16 = ProfileCardUtil.x(activity);
            intent.setClass(activity, PhotoCropActivity.class);
            intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
            intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
            intent.putExtra(PeakConstants.TARGET_WIDTH, x16);
            intent.putExtra(PeakConstants.TARGET_HEIGHT, x16);
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", realPathFromContentURI);
            intent.putExtra(PeakConstants.TARGET_PATH, FaceUtil.getUploadAvatarTempPath());
            intent.putExtra("FROM_WHERE", "FROM_LOGIN_AVATAR");
            intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
            intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
            intent.putExtra(PeakConstants.REQUEST_CODE, 10024);
            intent.addFlags(603979776);
            activity.startActivityForResult(intent, 10024);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public Card findFriendCardByUin(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Card) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null) {
                return friendsManager.r(qQAppInterface.getCurrentAccountUin());
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public Card initCard(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Card) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str);
        }
        return ProfileCardUtil.I((QQAppInterface) appRuntime, str);
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public void selectPhotoFromAlum(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        int x16 = ProfileCardUtil.x(activity);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 59);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationLoginAvatar.F);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, false);
        intent.putExtra("FROM_WHERE", "FROM_LOGIN_AVATAR");
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        intent.putExtra(PeakConstants.TARGET_PATH, FaceUtil.getUploadAvatarTempPath());
        intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, 1080);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
        intent.putExtra(PeakConstants.REQUEST_CODE, 10024);
        activity.startActivityForResult(intent, 10024);
    }

    @Override // com.tencent.mobileqq.relation.api.IProfileCardUtil
    public Uri takePhoto(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Uri) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        }
        boolean z16 = true;
        Uri[] uriArr = {null};
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_CAMERA));
        if (qQPermission == null) {
            return null;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a(uriArr, activity));
            return null;
        }
        return ProfileCardUtils.enterSnapshot(activity, 5);
    }
}
