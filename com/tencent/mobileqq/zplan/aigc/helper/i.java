package com.tencent.mobileqq.zplan.aigc.helper;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0002\u0014\u0017B\u0007\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bJ\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0016\u0010 \u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/i;", "", "Lcom/tencent/mobileqq/zplan/aigc/helper/i$b;", "listener", "", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "rewardType", "", "rewardItem", GetAdInfoRequest.SOURCE_FROM, tl.h.F, "", "adSequence", "rewardText", "l", "g", "j", "a", "Ljava/lang/String;", "REWARD_TEXT", "b", "BIZ_SRC", "c", "I", "mRewardType", "d", "mRewardItem", "e", "J", "mAdSequence", "", "f", "Z", "mIsFinished", "mElapsedTime", "Lcom/tencent/mobileqq/zplan/aigc/helper/i$b;", "stateListener", "<init>", "()V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String REWARD_TEXT = "\u83b7\u5f97\u6709\u6548\u5956\u52b1";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String BIZ_SRC = "biz_src_test";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mRewardType = 30;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mRewardItem = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mAdSequence;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFinished;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mElapsedTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b stateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/i$b;", "", "", "success", "", "b", "profitable", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(boolean success);

        void b(boolean success);

        void c(boolean profitable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/i$c", "Ltz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "retCode", "", "errMsg", "", "busiBuffer", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements tz2.b {
        c() {
        }

        @Override // tz2.b
        public void a(VasAdvServiceCode code, int retCode, String errMsg, byte[] busiBuffer) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            b bVar = i.this.stateListener;
            if (bVar != null) {
                bVar.a(code == VasAdvServiceCode.SUCCEED);
            }
            if (code == VasAdvServiceCode.SUCCEED) {
                QLog.i("ZPlanAIGCWatchAdHelper", 1, "reportRewardAd onResult succeed");
                return;
            }
            QLog.e("ZPlanAIGCWatchAdHelper", 1, "reportRewardAd onResult failed, code: " + code + ", errMsg: " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/i$d", "Ltz2/c;", "", "adSequence", "", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements tz2.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f330337b;

        d(Activity activity) {
            this.f330337b = activity;
        }

        @Override // tz2.c
        public void a(long adSequence) {
            QLog.i("ZPlanAIGCWatchAdHelper", 1, "requestAd onSucceed adSequence: " + adSequence);
            b bVar = i.this.stateListener;
            if (bVar != null) {
                bVar.b(true);
            }
            i.this.mAdSequence = adSequence;
            i iVar = i.this;
            iVar.l(this.f330337b, iVar.mAdSequence, i.this.REWARD_TEXT);
        }

        @Override // tz2.c
        public void b(VasAdvServiceCode code, String errMsg) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ZPlanAIGCWatchAdHelper", 1, "requestAd onError code: " + code + ", errMsg: " + errMsg);
            b bVar = i.this.stateListener;
            if (bVar != null) {
                bVar.b(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/i$e", "Ltz2/d;", "", "code", "", "profitable", "elapsedTime", "totalTime", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements tz2.d {
        e() {
        }

        @Override // tz2.d
        public void a(int code, boolean profitable, int elapsedTime, int totalTime) {
            QLog.i("ZPlanAIGCWatchAdHelper", 1, "showRewardAd onResult code: " + code + ", profitable: " + profitable + ", elapsedTime: " + elapsedTime + ", totalTime: " + totalTime);
            b bVar = i.this.stateListener;
            if (bVar != null) {
                bVar.c(profitable);
            }
            if (NetworkUtil.isNetworkAvailable()) {
                i.this.mIsFinished = profitable;
                i.this.mElapsedTime = elapsedTime;
                if (profitable) {
                    i.this.g();
                    return;
                }
                return;
            }
            QLog.i("ZPlanAIGCWatchAdHelper", 1, "Network is not available, do not report.");
        }
    }

    public final void g() {
        VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
        c11382a.d(this.mAdSequence);
        c11382a.e(this.mIsFinished);
        c11382a.h(this.mRewardType);
        c11382a.f(this.mRewardItem);
        c11382a.b(this.mElapsedTime);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).reportRewardAd(c11382a.a(), new c());
        j();
    }

    public final void h(Activity activity, int rewardType, String rewardItem, int sourceFrom) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        this.mRewardType = rewardType;
        this.mRewardItem = rewardItem;
        VasRewardAdReqParams.a aVar = new VasRewardAdReqParams.a();
        aVar.d(rewardType);
        aVar.c(rewardItem);
        aVar.e(sourceFrom);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).requestAd(aVar.a(), new d(activity));
    }

    public final void k(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListener = listener;
    }

    public final void l(Activity activity, long adSequence, String rewardText) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rewardText, "rewardText");
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).showRewardAd(activity, adSequence, rewardText, this.BIZ_SRC, new e());
    }

    public final void j() {
        this.mAdSequence = 0L;
        this.mIsFinished = false;
        this.mElapsedTime = 0;
        this.mRewardItem = "";
    }

    public static /* synthetic */ void i(i iVar, Activity activity, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        iVar.h(activity, i3, str, i16);
    }
}
