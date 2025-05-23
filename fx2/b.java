package fx2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.RewardVrReportData;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import com.tencent.tvideo.protocol.pb.RewardSwitchType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u00020\u0011\u00a2\u0006\u0004\b6\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R>\u0010-\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0'j\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 `(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b\u0003\u0010*\"\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b\u0019\u00100\"\u0004\b1\u00102R\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b4\u0010\u0016\u00a8\u00067"}, d2 = {"Lfx2/b;", "", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/c;", "a", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/c;", "f", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/c;", "setMVrReportData", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/c;)V", "mVrReportData", "b", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "setMTransferData", "(Ljava/lang/Object;)V", "mTransferData", "Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;", "c", "Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;", "()Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;", "g", "(Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;)V", "mRewardAdOriginSceneType", "Lcom/tencent/tvideo/protocol/pb/RewardSwitchType;", "d", "Lcom/tencent/tvideo/protocol/pb/RewardSwitchType;", "getMRewardAdSwitchType", "()Lcom/tencent/tvideo/protocol/pb/RewardSwitchType;", h.F, "(Lcom/tencent/tvideo/protocol/pb/RewardSwitchType;)V", "mRewardAdSwitchType", "", "Ljava/lang/String;", "getMServiceTag", "()Ljava/lang/String;", "setMServiceTag", "(Ljava/lang/String;)V", "mServiceTag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setMExtraInfo", "(Ljava/util/HashMap;)V", "mExtraInfo", "Lex2/a;", "Lex2/a;", "()Lex2/a;", "j", "(Lex2/a;)V", "mSwitchAdInnerInfo", "i", "mSceneType", "<init>", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RewardVrReportData mVrReportData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object mTransferData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RewardAdSceneType mRewardAdOriginSceneType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RewardSwitchType mRewardAdSwitchType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mServiceTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> mExtraInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ex2.a mSwitchAdInnerInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RewardAdSceneType mSceneType;

    public b(@NotNull RewardAdSceneType mSceneType) {
        Intrinsics.checkNotNullParameter(mSceneType, "mSceneType");
        this.mSceneType = mSceneType;
        this.mVrReportData = new RewardVrReportData(null, null, null, 7, null);
        this.mServiceTag = "";
        this.mExtraInfo = new HashMap<>();
    }

    @NotNull
    public final HashMap<String, String> a() {
        return this.mExtraInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final RewardAdSceneType getMRewardAdOriginSceneType() {
        return this.mRewardAdOriginSceneType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RewardAdSceneType getMSceneType() {
        return this.mSceneType;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ex2.a getMSwitchAdInnerInfo() {
        return this.mSwitchAdInnerInfo;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Object getMTransferData() {
        return this.mTransferData;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final RewardVrReportData getMVrReportData() {
        return this.mVrReportData;
    }

    public final void g(@Nullable RewardAdSceneType rewardAdSceneType) {
        this.mRewardAdOriginSceneType = rewardAdSceneType;
    }

    public final void h(@Nullable RewardSwitchType rewardSwitchType) {
        this.mRewardAdSwitchType = rewardSwitchType;
    }

    public final void i(@NotNull RewardAdSceneType rewardAdSceneType) {
        Intrinsics.checkNotNullParameter(rewardAdSceneType, "<set-?>");
        this.mSceneType = rewardAdSceneType;
    }

    public final void j(@Nullable ex2.a aVar) {
        this.mSwitchAdInnerInfo = aVar;
    }
}
