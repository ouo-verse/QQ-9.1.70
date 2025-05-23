package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.a;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$Authorization;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetVisibleRangeReply;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$GetVisibleRangeRequest;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetFriendsReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetFriendsRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetTokenReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$GetTokenRsp;
import com.tencent.mobileqq.gamecenter.ui.ForwardGameFriendFragment;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterFriendApiImpl implements IGameCenterFriendApi {
    private static final DownloadParams.DecodeHandler ROUND_FACE_DECODER = new a();
    private static final String TAG = "gameFriInfo.GameCenterFriendApiImpl";
    private final com.tencent.mobileqq.gamecenter.protocols.a mCommonReqSender = new com.tencent.mobileqq.gamecenter.protocols.a();
    private List<GameFriendSelectorSvr$Friend> mFriendInfoList = new ArrayList();
    private String mSenderId;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = com.tencent.mobileqq.utils.ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    return com.tencent.mobileqq.gamecenter.utils.k.a(bitmap, i3, i16);
                }
            }
            return com.tencent.mobileqq.gamecenter.utils.k.a(bitmap, 50, 50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGameFriendRelationRange$0(com.tencent.mobileqq.gamecenter.api.k kVar, long j3, String str, byte[] bArr) {
        if (j3 == 0 && bArr != null) {
            GameDataAuthorizeSvr$GetVisibleRangeReply gameDataAuthorizeSvr$GetVisibleRangeReply = new GameDataAuthorizeSvr$GetVisibleRangeReply();
            try {
                gameDataAuthorizeSvr$GetVisibleRangeReply.mergeFrom(bArr);
                for (GameDataAuthorizeSvr$Authorization gameDataAuthorizeSvr$Authorization : gameDataAuthorizeSvr$GetVisibleRangeReply.authoritys.get()) {
                    if (gameDataAuthorizeSvr$Authorization.type.get() == 2) {
                        kVar.onResult(Integer.valueOf(gameDataAuthorizeSvr$Authorization.range.get()));
                        return;
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "checkGameFriendRelationStatus: error: ", e16);
            }
        }
        QLog.w(TAG, 1, "checkGameFriendRelationStatus: failed: ret=" + j3 + ", msg=" + str);
        kVar.onResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getTokenForFriendChosen$1(com.tencent.mobileqq.gamecenter.api.k kVar, long j3, String str, byte[] bArr) {
        if (j3 == 0 && bArr != null) {
            GameFriendSelectorSvr$GetTokenRsp gameFriendSelectorSvr$GetTokenRsp = new GameFriendSelectorSvr$GetTokenRsp();
            try {
                gameFriendSelectorSvr$GetTokenRsp.mergeFrom(bArr);
                kVar.onResult(gameFriendSelectorSvr$GetTokenRsp.token.get());
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "getTokenForFriendChosen: error: ", e16);
            }
        }
        QLog.w(TAG, 1, "getTokenForFriendChosen: failed: ret=" + j3 + ", msg=" + str);
        kVar.onResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportChooseFriendPageExpo$2(boolean z16, String str, String str2) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        hashMap.put("ext2", str3);
        hashMap.put("ext4", "7");
        hashMap.put("ext5", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1041", "9249", "924901", "912968", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportFriendChooseResult$3(int i3, String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", String.valueOf(i3));
        hashMap.put("ext4", "20");
        hashMap.put("ext5", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1041", "9249", "924901", "912969", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFriendInfoFromSvr$4(long j3, String str, byte[] bArr) {
        if (j3 == 0 && bArr != null) {
            GameFriendSelectorSvr$GetFriendsRsp gameFriendSelectorSvr$GetFriendsRsp = new GameFriendSelectorSvr$GetFriendsRsp();
            try {
                gameFriendSelectorSvr$GetFriendsRsp.mergeFrom(bArr);
                this.mFriendInfoList = gameFriendSelectorSvr$GetFriendsRsp.friends.get();
                this.mSenderId = gameFriendSelectorSvr$GetFriendsRsp.f213220id.get();
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "requestFriendInfoFromSvr: parse failed", e16);
                return;
            }
        }
        QLog.w(TAG, 1, "[requestFriendInfoFromSvr], error! ret:" + j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public SparseArray<com.tencent.mobileqq.gamecenter.ui.w> buildIntimacyStyle(Context context) {
        Resources resources = context.getResources();
        SparseArray<com.tencent.mobileqq.gamecenter.ui.w> sparseArray = new SparseArray<>();
        sparseArray.put(1, com.tencent.mobileqq.gamecenter.ui.w.b(resources, R.string.f160911wa, R.color.bw8, R.color.f157205bw4, R.drawable.muj));
        sparseArray.put(2, com.tencent.mobileqq.gamecenter.ui.w.b(resources, R.string.f160901w_, R.color.bw7, R.color.f157204bw3, R.drawable.mui));
        sparseArray.put(3, com.tencent.mobileqq.gamecenter.ui.w.b(resources, R.string.f160921wb, R.color.bw9, R.color.bw5, R.drawable.muk));
        sparseArray.put(4, com.tencent.mobileqq.gamecenter.ui.w.b(resources, R.string.f160891w9, R.color.bw6, R.color.f157203bw2, R.drawable.muh));
        return sparseArray;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void getGameFriendRelationRange(String str, @NonNull final com.tencent.mobileqq.gamecenter.api.k<Integer> kVar) {
        GameDataAuthorizeSvr$GetVisibleRangeRequest gameDataAuthorizeSvr$GetVisibleRangeRequest = new GameDataAuthorizeSvr$GetVisibleRangeRequest();
        gameDataAuthorizeSvr$GetVisibleRangeRequest.app_id.set(str);
        this.mCommonReqSender.d("/v1/409", gameDataAuthorizeSvr$GetVisibleRangeRequest, new a.b() { // from class: com.tencent.mobileqq.gamecenter.api.impl.e
            @Override // com.tencent.mobileqq.gamecenter.protocols.a.b
            public final void a(long j3, String str2, byte[] bArr) {
                GameCenterFriendApiImpl.lambda$getGameFriendRelationRange$0(com.tencent.mobileqq.gamecenter.api.k.this, j3, str2, bArr);
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public List<GameFriendSelectorSvr$Friend> getGameFriendsInfo() {
        return this.mFriendInfoList;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public DownloadParams.DecodeHandler getRoundFaceDecoder() {
        return ROUND_FACE_DECODER;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public String getSenderID() {
        return this.mSenderId;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void getTokenForFriendChosen(String str, String str2, @NonNull final com.tencent.mobileqq.gamecenter.api.k<String> kVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GameFriendSelectorSvr$GetTokenReq gameFriendSelectorSvr$GetTokenReq = new GameFriendSelectorSvr$GetTokenReq();
            gameFriendSelectorSvr$GetTokenReq.sender_id.set(str);
            gameFriendSelectorSvr$GetTokenReq.receiver_id.set(str2);
            this.mCommonReqSender.d("/v1/818", gameFriendSelectorSvr$GetTokenReq, new a.b() { // from class: com.tencent.mobileqq.gamecenter.api.impl.g
                @Override // com.tencent.mobileqq.gamecenter.protocols.a.b
                public final void a(long j3, String str3, byte[] bArr) {
                    GameCenterFriendApiImpl.lambda$getTokenForFriendChosen$1(com.tencent.mobileqq.gamecenter.api.k.this, j3, str3, bArr);
                }
            });
            return;
        }
        kVar.onResult(null);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void onGameFriendItemSelected(Activity activity, GameFriendSelectorSvr$Friend gameFriendSelectorSvr$Friend) {
        if (activity != null && gameFriendSelectorSvr$Friend != null) {
            Intent intent = new Intent();
            intent.putExtras(activity.getIntent());
            intent.putExtra("uin", gameFriendSelectorSvr$Friend.f213219id.get());
            intent.putExtra("uintype", 10018);
            intent.putExtra("uinname", gameFriendSelectorSvr$Friend.role_name.get());
            intent.putExtra(AppConstants.Key.KEY_GC_SENDER_ID, this.mSenderId);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void openGameFriendChoosePage(@NonNull Activity activity, Bundle bundle, int i3) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, ForwardGameFriendFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void reportChooseFriendPageExpo(final String str, final boolean z16, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterFriendApiImpl.lambda$reportChooseFriendPageExpo$2(z16, str2, str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void reportFriendChooseResult(final String str, final int i3, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterFriendApiImpl.lambda$reportFriendChooseResult$3(i3, str2, str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi
    public void requestFriendInfoFromSvr(String str) {
        QLog.i(TAG, 1, "[requestFriendInfoFromSvr], appId:" + str);
        GameFriendSelectorSvr$GetFriendsReq gameFriendSelectorSvr$GetFriendsReq = new GameFriendSelectorSvr$GetFriendsReq();
        gameFriendSelectorSvr$GetFriendsReq.appid.set(str);
        this.mCommonReqSender.d("/v1/817", gameFriendSelectorSvr$GetFriendsReq, new a.b() { // from class: com.tencent.mobileqq.gamecenter.api.impl.i
            @Override // com.tencent.mobileqq.gamecenter.protocols.a.b
            public final void a(long j3, String str2, byte[] bArr) {
                GameCenterFriendApiImpl.this.lambda$requestFriendInfoFromSvr$4(j3, str2, bArr);
            }
        });
    }
}
