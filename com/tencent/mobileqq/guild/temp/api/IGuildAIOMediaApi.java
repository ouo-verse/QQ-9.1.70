package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildAIOMediaApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(MsgRecord msgRecord, boolean z16);

        void b(MsgRecord msgRecord, int i3);

        void c(MsgRecord msgRecord, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void onError(int i3);

        void onSuccess(String str);
    }

    void compressVideo(MsgRecord msgRecord, MsgElement msgElement, Context context, AppRuntime appRuntime, boolean z16, a aVar);

    @MainThread
    void encodeVideo(Context context, String str, String str2, Long l3, String str3, b bVar);

    Boolean findCompressTask(long j3);

    Object getGuildAIOMediaProvider(int i3);

    Intent getOpenAlbumIntent(@NonNull Activity activity, ArrayList<SelectMediaInfo> arrayList, String str, String str2, Intent intent, boolean z16, boolean z17, HashMap<String, String> hashMap);

    ActivityURIRequest getPhotoPreviewFromPhotoPanelURIReq(ArrayList<String> arrayList, HashMap hashMap, ArrayList<String> arrayList2, String str, String str2, String str3, Intent intent, HashMap hashMap2);

    @Nullable
    ActivityURIRequest getPostMediaItemClickURIReq(Context context, String str, Object obj, List list);

    String getShortVideoThumbPicPath(String str, String str2);

    void initEncodeQualityParam(Intent intent);

    void openCamera(Activity activity, String str, String str2, Bundle bundle) throws Throwable;

    void removeCompressTask(long j3);

    @MainThread
    void removeEncodeVideoTask(Long l3);

    void setCompressListener(long j3, a aVar);
}
