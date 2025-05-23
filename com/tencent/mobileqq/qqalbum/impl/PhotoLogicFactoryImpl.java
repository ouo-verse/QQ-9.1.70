package com.tencent.mobileqq.qqalbum.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.b;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.f;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

/* loaded from: classes16.dex */
public class PhotoLogicFactoryImpl implements IPhotoLogicFactory {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PhotoLogicFactory";

    public PhotoLogicFactoryImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoLogicFactory
    public b<? extends OtherCommonData> createAlbumListLogic(AbstractAlbumListFragment abstractAlbumListFragment, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractAlbumListFragment, (Object) intent);
        }
        if (intent != null) {
            str = intent.getStringExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME);
        } else {
            str = null;
        }
        if (str == null || str.equals("")) {
            str = AlbumListCustomizationDefault.class.getName();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createAlbumListCustomization:" + str);
        }
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(AbstractAlbumListFragment.class);
            declaredConstructor.setAccessible(true);
            return (b) declaredConstructor.newInstance(abstractAlbumListFragment);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            QLog.e(TAG, 1, "AlbumListCustomization reflection failed, use AlbumListCustomizationDefault");
            return new AlbumListCustomizationDefault(abstractAlbumListFragment);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoLogicFactory
    public f<? extends OtherCommonData> createPhotoListLogic(AbstractPhotoListActivity abstractPhotoListActivity, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) abstractPhotoListActivity, (Object) intent);
        }
        if (intent != null) {
            str = intent.getStringExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME);
        } else {
            str = null;
        }
        if (str == null || str.equals("")) {
            str = PhotoListCustomizationDefault.class.getName();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createPhotoListCustomization:" + str);
        }
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(AbstractPhotoListActivity.class);
            declaredConstructor.setAccessible(true);
            return (f) declaredConstructor.newInstance(abstractPhotoListActivity);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            QLog.e(TAG, 1, "PhotoListCustomization reflection failed, use PhotoListCustomizationDefault");
            return new PhotoListCustomizationDefault(abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoLogicFactory
    public e<? extends OtherCommonData> createPhotoPreviewLogic(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractPhotoPreviewActivity, (Object) intent);
        }
        if (intent != null) {
            str = intent.getStringExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME);
        } else {
            str = null;
        }
        if (str == null || str.equals("")) {
            str = PhotoPreviewCustomizationDefault.class.getName();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createPhotoPreviewCustomization:" + str);
        }
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(AbstractPhotoPreviewActivity.class);
            declaredConstructor.setAccessible(true);
            return (e) declaredConstructor.newInstance(abstractPhotoPreviewActivity);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            QLog.e(TAG, 1, "PhotoPreviewCustomization reflection failed, use PhotoPreviewCustomization");
            return new PhotoPreviewCustomizationDefault(abstractPhotoPreviewActivity);
        }
    }
}
