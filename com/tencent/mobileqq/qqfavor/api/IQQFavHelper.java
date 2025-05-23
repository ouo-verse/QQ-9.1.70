package com.tencent.mobileqq.qqfavor.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQFavHelper extends IRuntimeService {
    void addPictureToFavorite(@NonNull AppRuntime appRuntime, Activity activity, String str);

    void downloadThumb(BaseQQAppInterface baseQQAppInterface, FavFileInfo favFileInfo, int i3);

    void forwardFavFileList(BaseQQAppInterface baseQQAppInterface, List<FavFileInfo> list, String str, String str2, int i3);

    void getFavList(BaseQQAppInterface baseQQAppInterface, long j3, boolean z16, Bundle bundle);

    boolean refreshList(BaseQQAppInterface baseQQAppInterface, Bundle bundle);
}
