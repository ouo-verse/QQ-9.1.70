package com.tencent.mobileqq.qqfavor.api.impl;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQFavHelperImpl implements IQQFavHelper {
    static IPatchRedirector $redirector_;

    public QQFavHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IQQFavHelper
    public void addPictureToFavorite(@NonNull AppRuntime appRuntime, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, activity, str);
        } else {
            QfavBuilder.e0(str).h(activity, appRuntime.getAccount());
        }
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IQQFavHelper
    public void downloadThumb(BaseQQAppInterface baseQQAppInterface, FavFileInfo favFileInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, favFileInfo, Integer.valueOf(i3));
        } else {
            QfavHelper.g(baseQQAppInterface.getApplicationContext(), favFileInfo, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IQQFavHelper
    public void forwardFavFileList(BaseQQAppInterface baseQQAppInterface, List<FavFileInfo> list, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, baseQQAppInterface, list, str, str2, Integer.valueOf(i3));
        } else {
            QfavHelper.j((QQAppInterface) baseQQAppInterface, list, str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IQQFavHelper
    public void getFavList(BaseQQAppInterface baseQQAppInterface, long j3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, Long.valueOf(j3), Boolean.valueOf(z16), bundle);
        } else {
            QfavHelper.o(baseQQAppInterface.getApplicationContext(), j3, Boolean.valueOf(z16), bundle);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IQQFavHelper
    public boolean refreshList(BaseQQAppInterface baseQQAppInterface, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) bundle)).booleanValue();
        }
        return QfavHelper.z(baseQQAppInterface.getApplicationContext(), bundle);
    }
}
