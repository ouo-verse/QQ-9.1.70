package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.gamecenter.ui.w;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterFriendApi extends QRouteApi {
    public static final String TAG_PREFIX = "gameFriInfo.";

    SparseArray<w> buildIntimacyStyle(Context context);

    @WorkerThread
    void getGameFriendRelationRange(String str, @NonNull k<Integer> kVar);

    List<GameFriendSelectorSvr$Friend> getGameFriendsInfo();

    DownloadParams.DecodeHandler getRoundFaceDecoder();

    String getSenderID();

    void getTokenForFriendChosen(String str, String str2, @NonNull k<String> kVar);

    void onGameFriendItemSelected(Activity activity, GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend);

    void openGameFriendChoosePage(@NonNull Activity activity, Bundle bundle, int i3);

    @AnyThread
    void reportChooseFriendPageExpo(String str, boolean z16, String str2);

    @AnyThread
    void reportFriendChooseResult(String str, int i3, String str2);

    void requestFriendInfoFromSvr(String str);
}
