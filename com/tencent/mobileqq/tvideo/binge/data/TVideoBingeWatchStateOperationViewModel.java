package com.tencent.mobileqq.tvideo.binge.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import tvideo.TVideoBingeWatch$AlbumAtom;
import tvideo.TVideoBingeWatch$GetUserAlbumInfoData;
import tvideo.TVideoBingeWatch$GetUserAlbumInfoResponse;
import tvideo.TVideoBingeWatch$UpdateAlbumResponse;
import tvideo.TVideoBingeWatch$UserAlbumInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoBingeWatchStateOperationViewModel extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    private final SoftReference<e> f304362m;

    public TVideoBingeWatchStateOperationViewModel(@Nullable e eVar) {
        this.f304362m = new SoftReference<>(eVar);
    }

    private boolean N1() {
        return qx2.a.c().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoBingeWatch$GetUserAlbumInfoResponse tVideoBingeWatch$GetUserAlbumInfoResponse) {
        TVideoBingeWatch$AlbumAtom tVideoBingeWatch$AlbumAtom;
        String str2;
        int i3;
        QLog.i("TVideoBingeWatchStateOperationViewModel", 1, "requestBingeWatchState isSuccess = " + z16 + " errMsg = " + str);
        ArrayList arrayList = new ArrayList();
        if (tVideoBingeWatch$GetUserAlbumInfoResponse == null) {
            QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "requestBingeWatchState fail, rsp is null");
            Q1(arrayList, true);
            return;
        }
        TVideoBingeWatch$GetUserAlbumInfoData tVideoBingeWatch$GetUserAlbumInfoData = tVideoBingeWatch$GetUserAlbumInfoResponse.data;
        if (tVideoBingeWatch$GetUserAlbumInfoData == null) {
            QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "requestBingeWatchState fail, userAlbumInfoData is null");
            Q1(arrayList, true);
            return;
        }
        PBRepeatMessageField<TVideoBingeWatch$UserAlbumInfo> pBRepeatMessageField = tVideoBingeWatch$GetUserAlbumInfoData.user_album_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() != 0) {
            for (TVideoBingeWatch$UserAlbumInfo tVideoBingeWatch$UserAlbumInfo : pBRepeatMessageField.get()) {
                if (tVideoBingeWatch$UserAlbumInfo != null && (tVideoBingeWatch$AlbumAtom = tVideoBingeWatch$UserAlbumInfo.album_atom) != null) {
                    PBStringField pBStringField = tVideoBingeWatch$AlbumAtom.cid;
                    if (pBStringField == null) {
                        str2 = "";
                    } else {
                        str2 = pBStringField.get();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        PBBoolField pBBoolField = tVideoBingeWatch$UserAlbumInfo.opened;
                        if (pBBoolField != null && !pBBoolField.get()) {
                            i3 = -1;
                        } else {
                            PBBoolField pBBoolField2 = tVideoBingeWatch$UserAlbumInfo.is_user_album;
                            if (pBBoolField2 != null && pBBoolField2.get()) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                        }
                        arrayList.add(new TVideoBingeWatchUiData(str2, i3));
                    }
                }
            }
            Q1(arrayList, true);
            return;
        }
        QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "requestBingeWatchState fail, albumList is empty");
        Q1(arrayList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P1(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoBingeWatch$UpdateAlbumResponse tVideoBingeWatch$UpdateAlbumResponse) {
        QLog.i("TVideoBingeWatchStateOperationViewModel", 1, "updateBingeWatchState isSuccess = " + z16 + " errMsg = " + str);
    }

    private void Q1(List<TVideoBingeWatchUiData> list, boolean z16) {
        SoftReference<e> softReference = this.f304362m;
        if (softReference != null && softReference.get() != null) {
            this.f304362m.get().a(list, z16);
        }
    }

    public void R1(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "queryState fail, coverId is null");
            return;
        }
        int f16 = b.d().f(str);
        if (f16 != -2) {
            QLog.d("TVideoBingeWatchStateOperationViewModel", 4, "queryState from cache:" + f16);
            Q1(new ArrayList<TVideoBingeWatchUiData>(str, f16) { // from class: com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchStateOperationViewModel.1
                final /* synthetic */ int val$cacheUiState;
                final /* synthetic */ String val$coverId;

                {
                    this.val$coverId = str;
                    this.val$cacheUiState = f16;
                    add(new TVideoBingeWatchUiData(str, f16));
                }
            }, true);
            return;
        }
        S1(new ArrayList<String>(str) { // from class: com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchStateOperationViewModel.2
            final /* synthetic */ String val$coverId;

            {
                this.val$coverId = str;
                add(str);
            }
        });
    }

    public void S1(@NonNull List<String> list) {
        QLog.d("TVideoBingeWatchStateOperationViewModel", 4, "queryState list");
        if (list != null && list.size() != 0) {
            if (!N1()) {
                QLog.i("TVideoBingeWatchStateOperationViewModel", 1, "please enableUserBingeWatch first!");
                return;
            } else if (!zt2.e.f453199a.k()) {
                QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "queryState fail, not login");
                return;
            } else {
                sendRequest(new TVideoBingeWatchStateQueryRequest(list), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.binge.data.c
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        TVideoBingeWatchStateOperationViewModel.this.O1(baseRequest, z16, j3, str, (TVideoBingeWatch$GetUserAlbumInfoResponse) obj);
                    }
                });
                return;
            }
        }
        QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "queryState fail, coverIds is empty");
    }

    public void T1(@TVideoBingeWatchOperationType int i3, @NonNull TVideoBingeWatch$AlbumAtom tVideoBingeWatch$AlbumAtom, @NonNull String str) {
        PBStringField pBStringField;
        boolean z16;
        if (tVideoBingeWatch$AlbumAtom != null && (pBStringField = tVideoBingeWatch$AlbumAtom.cid) != null && !TextUtils.isEmpty(pBStringField.get())) {
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ArrayList<TVideoBingeWatchUiData> arrayList = new ArrayList<TVideoBingeWatchUiData>(tVideoBingeWatch$AlbumAtom, z16) { // from class: com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchStateOperationViewModel.3
                final /* synthetic */ TVideoBingeWatch$AlbumAtom val$albumAtom;
                final /* synthetic */ boolean val$isGet;

                {
                    this.val$albumAtom = tVideoBingeWatch$AlbumAtom;
                    this.val$isGet = z16;
                    add(new TVideoBingeWatchUiData(tVideoBingeWatch$AlbumAtom.cid.get(), z16 ? 1 : 0));
                }
            };
            Q1(arrayList, false);
            b.d().i(arrayList);
            if (!N1()) {
                QLog.i("TVideoBingeWatchStateOperationViewModel", 1, "please enableUserBingeWatch first!");
                return;
            }
            if (!zt2.e.f453199a.k()) {
                QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "queryState fail, not login");
                return;
            }
            QLog.d("TVideoBingeWatchStateOperationViewModel", 4, "updateBingeWatchState type = " + i3 + " , cid = " + tVideoBingeWatch$AlbumAtom.cid.get());
            sendRequest(new TVideoBingeWatchStateUpdateRequest(i3, new ArrayList<TVideoBingeWatch$AlbumAtom>(tVideoBingeWatch$AlbumAtom) { // from class: com.tencent.mobileqq.tvideo.binge.data.TVideoBingeWatchStateOperationViewModel.4
                final /* synthetic */ TVideoBingeWatch$AlbumAtom val$albumAtom;

                {
                    this.val$albumAtom = tVideoBingeWatch$AlbumAtom;
                    add(tVideoBingeWatch$AlbumAtom);
                }
            }, str), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.binge.data.d
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str2, Object obj) {
                    TVideoBingeWatchStateOperationViewModel.P1(baseRequest, z17, j3, str2, (TVideoBingeWatch$UpdateAlbumResponse) obj);
                }
            });
            return;
        }
        QLog.e("TVideoBingeWatchStateOperationViewModel", 1, "updateState fail, coverId invalidate");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoBingeWatchStateOperationViewModel";
    }
}
