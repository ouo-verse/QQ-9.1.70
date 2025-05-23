package com.tencent.mobileqq.wink.publish.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.panorama.util.PanoramaConfig;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R#\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\b\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R2\u0010,\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishFollowQCircleSeverAccountViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "S1", "U1", "", "getLogTag", "", "isAIGC", "T1", "O1", "P1", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "R1", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "isShowTips", BdhLogUtil.LogTag.Tag_Conn, "Z", "()Z", "setAIGC", "(Z)V", "", "D", "I", "getCloseThreshold", "()I", "closeThreshold", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "getCloseRecord", "()Ljava/util/ArrayList;", "setCloseRecord", "(Ljava/util/ArrayList;)V", "closeRecord", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishFollowQCircleSeverAccountViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isAIGC;

    /* renamed from: D, reason: from kotlin metadata */
    private final int closeThreshold;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Long> closeRecord;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy currentUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isShowTips;

    public PublishFollowQCircleSeverAccountViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishFollowQCircleSeverAccountViewModel$currentUin$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return com.tencent.mobileqq.wink.b.f().getCurrentAccountUin();
            }
        });
        this.currentUin = lazy;
        this.isShowTips = new MutableLiveData<>();
        this.closeThreshold = uq3.c.z2();
        this.closeRecord = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(Bundle params) {
        Intrinsics.checkNotNullParameter(params, "$params");
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_FOLLOW_PUBLISH_ACCOUNT, params);
    }

    private final String R1() {
        return (String) this.currentUin.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x009c, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r6, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S1() {
        ArrayList arrayList;
        Collection collection;
        boolean z16;
        String joinToString$default;
        List split$default;
        Long longOrNull;
        ar arVar = ar.f326685a;
        long f16 = arVar.f("PublishFollowQCircleSeverAccountViewModel_public_account_close_threshold_clear_time_" + R1(), uq3.c.y2());
        long y26 = uq3.c.y2();
        w53.b.f("PublishFollowQCircleSeverAccountViewModel", "[initCloseThreshold] closeThresholdClearTimeFromWNS:" + y26 + ", closeThresholdClearTime:" + f16);
        if (y26 != f16) {
            arVar.p("PublishFollowQCircleSeverAccountViewModel_public_account_close_threshold_clear_time_" + R1(), y26);
            ArrayList<Long> arrayList2 = this.closeRecord;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            arVar.l("_public_account_close_record_" + R1());
            return;
        }
        String i3 = arVar.i("_public_account_close_record_" + R1(), "");
        if (i3 != null && split$default != null) {
            arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull != null) {
                    arrayList.add(longOrNull);
                }
            }
        } else {
            arrayList = null;
        }
        Intrinsics.checkNotNull(arrayList);
        collection = CollectionsKt___CollectionsKt.toCollection(arrayList, new ArrayList());
        ArrayList<Long> arrayList3 = (ArrayList) collection;
        this.closeRecord = arrayList3;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        long j3 = 60;
        long j16 = y26 * 24 * j3 * j3 * 1000;
        for (int size = this.closeRecord.size() - 1; -1 < size; size--) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = this.closeRecord.get(size);
            Intrinsics.checkNotNullExpressionValue(l3, "closeRecord[i]");
            if (currentTimeMillis - l3.longValue() > j16) {
                this.closeRecord.remove(size);
            }
        }
        ar arVar2 = ar.f326685a;
        String str = "_public_account_close_record_" + R1();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.closeRecord, ",", null, null, 0, null, null, 62, null);
        arVar2.r(str, joinToString$default);
    }

    private final void U1() {
        final Bundle bundle = new Bundle();
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_TARGET_UIN, IQCircleIPCApi.QCIRCLE_SEVER_PUBLISH_ACCOUNT_UIN);
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_ACTION_TYPE, IQCircleIPCApi.BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_CHECK_IS_FOLLOW);
        final EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.j
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                PublishFollowQCircleSeverAccountViewModel.W1(PublishFollowQCircleSeverAccountViewModel.this, eIPCResult);
            }
        };
        w53.b.f("PublishFollowQCircleSeverAccountViewModel", "[initShowTips]");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.k
            @Override // java.lang.Runnable
            public final void run() {
                PublishFollowQCircleSeverAccountViewModel.X1(bundle, eIPCResultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(PublishFollowQCircleSeverAccountViewModel this$0, EIPCResult eIPCResult) {
        String str;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
            str = bundle.getString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_IS_FOLLOW);
        } else {
            str = null;
        }
        this$0.isShowTips.postValue(Boolean.valueOf(!Intrinsics.areEqual(str, "1")));
        w53.b.f("PublishFollowQCircleSeverAccountViewModel", "is follow:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Bundle params, EIPCResultCallback ipcCallback) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(ipcCallback, "$ipcCallback");
        QIPCClientHelper.getInstance().getClient().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_FOLLOW_PUBLISH_ACCOUNT, params, ipcCallback);
    }

    public final void O1() {
        String joinToString$default;
        if (this.isAIGC) {
            return;
        }
        if (this.closeRecord == null) {
            this.closeRecord = new ArrayList<>();
        }
        this.closeRecord.add(Long.valueOf(System.currentTimeMillis()));
        ar arVar = ar.f326685a;
        String str = "_public_account_close_record_" + R1();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.closeRecord, ",", null, null, 0, null, null, 62, null);
        arVar.r(str, joinToString$default);
    }

    public final void P1() {
        w53.b.f("PublishFollowQCircleSeverAccountViewModel", "[doFollowQCirclePublicAccount]");
        final Bundle bundle = new Bundle();
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_TARGET_UIN, IQCircleIPCApi.QCIRCLE_SEVER_PUBLISH_ACCOUNT_UIN);
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_ACTION_TYPE, IQCircleIPCApi.BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_DO_FOLLOW);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.l
            @Override // java.lang.Runnable
            public final void run() {
                PublishFollowQCircleSeverAccountViewModel.Q1(bundle);
            }
        });
        this.isShowTips.setValue(Boolean.FALSE);
    }

    public final void T1(boolean isAIGC) {
        boolean z16;
        this.isAIGC = isAIGC;
        S1();
        int size = this.closeRecord.size();
        int i3 = this.closeThreshold;
        if (size >= i3 && !isAIGC) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.f("PublishFollowQCircleSeverAccountViewModel", "closeThreshold:" + i3 + " closeRecord.size:" + this.closeRecord.size() + " isAIGC:" + isAIGC);
        if (!z16) {
            U1();
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        return this.isShowTips;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "PublishFollowQCircleSeverAccountViewModel";
    }
}
