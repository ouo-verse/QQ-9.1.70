package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 72\u00020\u0001:\u000289B\u0007\u00a2\u0006\u0004\b5\u00106J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\u0013\u0010\u001d\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0010R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R(\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lkotlin/coroutines/Continuation;", "", "cont", "Leipc/EIPCResultCallback;", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "liveEntryGoodsData", "", "c2", "", "getRoomId", "U1", "Z1", "X1", "", "S1", "R1", "Q1", "b2", "Landroid/content/Intent;", "intent", "W1", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "g2", "e2", "f2", "d2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "T1", "i", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "O1", "()Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "entryGoodsData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel$b;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "goodsViewObject", "D", "Z", "isFirstOpenGamePrepareLive", "E", "isEnteredRoom", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorECViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GoodsViewObject> goodsViewObject = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFirstOpenGamePrepareLive = true;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isEnteredRoom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.d roomInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQECLiveEntryGoodsData entryGoodsData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "goodsNumVisible", "b", "I", "()I", "productNum", "c", "shopProductNum", "<init>", "(ZII)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECViewModel$b, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class GoodsViewObject {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean goodsNumVisible;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int productNum;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int shopProductNum;

        public GoodsViewObject(boolean z16, int i3, int i16) {
            this.goodsNumVisible = z16;
            this.productNum = i3;
            this.shopProductNum = i16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getGoodsNumVisible() {
            return this.goodsNumVisible;
        }

        /* renamed from: b, reason: from getter */
        public final int getProductNum() {
            return this.productNum;
        }

        /* renamed from: c, reason: from getter */
        public final int getShopProductNum() {
            return this.shopProductNum;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoodsViewObject)) {
                return false;
            }
            GoodsViewObject goodsViewObject = (GoodsViewObject) other;
            if (this.goodsNumVisible == goodsViewObject.goodsNumVisible && this.productNum == goodsViewObject.productNum && this.shopProductNum == goodsViewObject.shopProductNum) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.goodsNumVisible;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.productNum) * 31) + this.shopProductNum;
        }

        @NotNull
        public String toString() {
            return "GoodsViewObject(goodsNumVisible=" + this.goodsNumVisible + ", productNum=" + this.productNum + ", shopProductNum=" + this.shopProductNum + ")";
        }
    }

    private final int Q1() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveShopGoodsNumber();
        }
        return 0;
    }

    private final int R1() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveGokGoodsNumber();
        }
        return 0;
    }

    private final int S1() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getLiveGoodsNumber();
        }
        return 0;
    }

    private final long U1() {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j3;
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null && (j3 = dVar.j()) != null) {
            return j3.f();
        }
        return 0L;
    }

    private final boolean X1() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null) {
            return qQECLiveEntryGoodsData.getIsGokSelect();
        }
        return false;
    }

    private final boolean Z1() {
        boolean z16;
        int i3;
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null && qQECLiveEntryGoodsData.getIsGokWhiteListUser()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQECLiveEntryGoodsData qQECLiveEntryGoodsData2 = this.entryGoodsData;
            if (qQECLiveEntryGoodsData2 != null) {
                i3 = qQECLiveEntryGoodsData2.getLiveGokGoodsNumber();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean b2() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData == null || !qQECLiveEntryGoodsData.getIsQShopWhiteListUser()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(QQECLiveEntryGoodsData liveEntryGoodsData) {
        boolean z16;
        AegisLogger.INSTANCE.i("Open_Live|QQLiveEcommerceViewModel", "onGoodsDataChanged", "goodsNumber=" + liveEntryGoodsData.getLiveGoodsNumber() + ", shopGoodsNumber=" + liveEntryGoodsData.getLiveShopGoodsNumber());
        MutableLiveData<GoodsViewObject> mutableLiveData = this.goodsViewObject;
        if (liveEntryGoodsData.getLiveGoodsNumber() + liveEntryGoodsData.getLiveShopGoodsNumber() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.postValue(new GoodsViewObject(z16, liveEntryGoodsData.getLiveGoodsNumber(), liveEntryGoodsData.getLiveShopGoodsNumber()));
    }

    private final long getRoomId() {
        com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
        if (dVar != null) {
            return dVar.getRoomId();
        }
        return 0L;
    }

    private final EIPCResultCallback h2(final Continuation<? super Boolean> cont) {
        return new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.g
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQLiveAnchorECViewModel.i2(Continuation.this, this, eIPCResult);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(Continuation cont, QQLiveAnchorECViewModel this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(cont, "$cont");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveEcommerceViewModel", "openGoodsPageEIPCCallback", "error, result is null");
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveEcommerceViewModel", "openGoodsPageEIPCCallback", "code=" + eIPCResult.code + ", data=" + eIPCResult.data);
        int i3 = eIPCResult.code;
        if (i3 == 0) {
            QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this$0.entryGoodsData;
            if (qQECLiveEntryGoodsData != null) {
                qQECLiveEntryGoodsData.l(eIPCResult.data.getInt("live_product_counts"));
                qQECLiveEntryGoodsData.m(eIPCResult.data.getInt("live_shop_product_counts"));
                this$0.c2(qQECLiveEntryGoodsData);
            }
            Result.Companion companion2 = Result.INSTANCE;
            cont.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
            return;
        }
        if (i3 == -102) {
            Result.Companion companion3 = Result.INSTANCE;
            cont.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    @Nullable
    /* renamed from: O1, reason: from getter */
    public final QQECLiveEntryGoodsData getEntryGoodsData() {
        return this.entryGoodsData;
    }

    @NotNull
    public final MutableLiveData<GoodsViewObject> P1() {
        return this.goodsViewObject;
    }

    public final int T1() {
        int i3;
        int i16;
        int i17 = 0;
        if (Q1() > 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (S1() > 0) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16;
        if (R1() > 0 && X1()) {
            i17 = 1;
        }
        return i18 | i17;
    }

    public final void W1(@Nullable Intent intent) {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
        if (intent != null) {
            qQECLiveEntryGoodsData = (QQECLiveEntryGoodsData) intent.getParcelableExtra("KEY_LIVE_ENTRY_GOODS_DATA");
        } else {
            qQECLiveEntryGoodsData = null;
        }
        this.entryGoodsData = qQECLiveEntryGoodsData;
    }

    public final boolean a2() {
        if ((!X1() || R1() <= 0) && S1() <= 0 && Q1() <= 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Object d2(@NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData == null) {
            AegisLogger.INSTANCE.i("Open_Live|QQLiveEcommerceViewModel", "onOpenGoodsClick", "entryGoodsData is null");
            return Boxing.boxBoolean(false);
        }
        boolean z16 = true;
        if (!qQECLiveEntryGoodsData.getIsEcomAuthenticated() && !b2()) {
            String builder = Uri.parse("mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1").buildUpon().appendQueryParameter("live_user_id", String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())).appendQueryParameter("live_room_id", String.valueOf(getRoomId())).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "parse(QQLiveEcommerceHel\u2026              .toString()");
            byte[] bytes = builder.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme("mqqapi://ecommerce/open?target=1&channel=8&src_type=internal&version=1&jump_scheme=" + Base64.encodeToString(bytes, 0), null);
            return Boxing.boxBoolean(true);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_LIVE_ROOM_ID", getRoomId());
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        bundle.putBoolean("is_xiaodian_user", b2());
        bundle.putInt("live_product_counts", S1());
        bundle.putInt("live_shop_product_counts", Q1());
        bundle.putBoolean("is_wangzhe_user", Z1());
        bundle.putBoolean("is_ecommerce_authenticated", qQECLiveEntryGoodsData.getIsEcomAuthenticated());
        if (!Z1() || (!this.isFirstOpenGamePrepareLive && !X1())) {
            z16 = false;
        }
        bundle.putBoolean("is_wangzhe_select", z16);
        this.isFirstOpenGamePrepareLive = false;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        cj4.c.f31003a.c("ACTION_CLICK_LIVE_ENTRY", bundle, h2(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void e2() {
        String str;
        String str2;
        this.isEnteredRoom = true;
        cj4.c cVar = cj4.c.f31003a;
        cVar.l(a2());
        cVar.k(true, getRoomId(), a2());
        try {
            if (a2()) {
                String valueOf = String.valueOf(U1());
                long roomId = getRoomId();
                int T1 = T1();
                com.tencent.mobileqq.qqlive.sail.model.d dVar = this.roomInfo;
                if (dVar == null || (str = dVar.getRoomName()) == null) {
                    str = "";
                }
                com.tencent.mobileqq.qqlive.sail.model.d dVar2 = this.roomInfo;
                if (dVar2 == null || (str2 = dVar2.getProgramId()) == null) {
                    str2 = "";
                }
                cVar.i(valueOf, roomId, 8, T1, str, str2, 1);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveEcommerceViewModel", "onRoomEntered", "notifyLiveOpen", e16);
        }
    }

    public final void f2() {
        if (this.isEnteredRoom) {
            cj4.c.f31003a.j(getRoomId(), a2());
        }
        this.isEnteredRoom = false;
    }

    public final void g2(@Nullable com.tencent.mobileqq.qqlive.sail.model.d roomInfo) {
        this.roomInfo = roomInfo;
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData = this.entryGoodsData;
        if (qQECLiveEntryGoodsData != null) {
            Intrinsics.checkNotNull(qQECLiveEntryGoodsData);
            c2(qQECLiveEntryGoodsData);
        } else {
            cj4.c.f31003a.m(getRoomId(), com.tencent.mobileqq.qqlive.sail.c.f272176a.G(), new Function1<QQECLiveEntryGoodsData, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECViewModel$onRoomPrepared$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQECLiveEntryGoodsData qQECLiveEntryGoodsData2) {
                    invoke2(qQECLiveEntryGoodsData2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQECLiveEntryGoodsData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    QQLiveAnchorECViewModel.this.entryGoodsData = it;
                    QQLiveAnchorECViewModel.this.c2(it);
                }
            });
        }
    }
}
