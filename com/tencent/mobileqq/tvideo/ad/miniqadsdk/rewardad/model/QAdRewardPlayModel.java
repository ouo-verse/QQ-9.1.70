package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tvideo.protocol.pb.AdExtraInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayResponse;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import ev2.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.y;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0014\u0018\u001dB\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0013\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel;", "Lpv2/a;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewPlayRequest;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewPlayResponse;", "Lcom/tencent/tvideo/protocol/pb/RewardAdPlayRequestInfo;", "playRequestInfo", "d", "response", "", "g", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "listener", "", "serviceTag", "", h.F, Const.BUNDLE_KEY_REQUEST, "f", "errorCode", "e", "a", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "mListener", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "b", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "mAdLoadInfo", "<init>", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;)V", "c", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardPlayModel implements pv2.a<RewardAdNewPlayRequest, RewardAdNewPlayResponse> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b mListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b mAdLoadInfo;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "", "", "isUnlock", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "a", "Lcom/tencent/tvideo/protocol/pb/AdExtraInfo;", "c", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    public interface b {
        void a();

        void b(boolean isUnlock, @Nullable RewardAdNewUnlockInfo unlockInfo);

        @Nullable
        AdExtraInfo c();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$c;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "", "isUnlock", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "a", "Lcom/tencent/tvideo/protocol/pb/AdExtraInfo;", "c", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "mPenetrateInfo", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;", "e", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;", "mRewardAdDataInfo", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String mPenetrateInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a mRewardAdDataInfo;

        public c(@Nullable String str, @Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar) {
            this.mPenetrateInfo = str;
            this.mRewardAdDataInfo = aVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        public void a() {
            b(false, null);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        public void b(boolean isUnlock, @Nullable RewardAdNewUnlockInfo unlockInfo) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar;
            if (isUnlock && (aVar = this.mRewardAdDataInfo) != null) {
                aVar.e(true);
            }
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
        @Nullable
        public AdExtraInfo c() {
            Map<String, String> map;
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar = this.mRewardAdDataInfo;
            Map<String, String> map2 = null;
            if (aVar != null) {
                map = aVar.a();
            } else {
                map = null;
            }
            if (y.l(map)) {
                return null;
            }
            AdExtraInfo.a aVar2 = new AdExtraInfo.a();
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a aVar3 = this.mRewardAdDataInfo;
            if (aVar3 != null) {
                map2 = aVar3.a();
            }
            return aVar2.a(map2).build();
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getMPenetrateInfo() {
            return this.mPenetrateInfo;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.a getMRewardAdDataInfo() {
            return this.mRewardAdDataInfo;
        }
    }

    public QAdRewardPlayModel(@Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar) {
        this.mAdLoadInfo = bVar;
    }

    private final RewardAdNewPlayRequest d(RewardAdPlayRequestInfo playRequestInfo) {
        RewardAdSceneType rewardAdSceneType;
        dx2.c cVar = dx2.c.f395159a;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar = this.mAdLoadInfo;
        if (bVar != null) {
            rewardAdSceneType = bVar.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        dx2.a a16 = cVar.a(rewardAdSceneType);
        if (a16 == null) {
            return null;
        }
        return a16.b(this.mAdLoadInfo, playRequestInfo);
    }

    private final void g(final RewardAdNewPlayResponse response) {
        n.e("[RewardAd]QAdRewardPlayModel", "onPbResponseSucc, response = " + response);
        if (response == null) {
            n.e("[RewardAd]QAdRewardPlayModel", "no need unlock");
        } else {
            final boolean f16 = hx2.c.f406571a.f(response);
            QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel$processResponse$1
                @Override // java.lang.Runnable
                public final void run() {
                    QAdRewardPlayModel.b bVar;
                    bVar = QAdRewardPlayModel.this.mListener;
                    if (bVar != null) {
                        bVar.b(f16, response.unlocked_info);
                    }
                }
            });
        }
    }

    @Override // pv2.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(@Nullable RewardAdNewPlayRequest request, @Nullable RewardAdNewPlayResponse response, int errorCode) {
        n.e("[RewardAd]QAdRewardPlayModel", "onPbResponseFail, errorCode = " + errorCode);
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel$onPbResponseFail$1
            @Override // java.lang.Runnable
            public final void run() {
                QAdRewardPlayModel.b bVar;
                bVar = QAdRewardPlayModel.this.mListener;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
    }

    @Override // pv2.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable RewardAdNewPlayRequest request, @Nullable RewardAdNewPlayResponse response) {
        g(response);
    }

    public final int h(@Nullable b listener, @Nullable RewardAdPlayRequestInfo playRequestInfo, @NotNull String serviceTag) {
        RewardAdReportInfo rewardAdReportInfo;
        Intrinsics.checkNotNullParameter(serviceTag, "serviceTag");
        this.mListener = listener;
        RewardAdNewPlayRequest d16 = d(playRequestInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendRequest, report_info = ");
        if (playRequestInfo != null) {
            rewardAdReportInfo = playRequestInfo.report_info;
        } else {
            rewardAdReportInfo = null;
        }
        sb5.append(rewardAdReportInfo);
        n.e("[RewardAd]QAdRewardPlayModel", sb5.toString());
        return i.b(d16, this);
    }
}
