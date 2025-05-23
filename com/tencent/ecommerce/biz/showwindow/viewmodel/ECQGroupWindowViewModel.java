package com.tencent.ecommerce.biz.showwindow.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECQGroupWindowViewModel;", "Landroidx/lifecycle/ViewModel;", "", "groupId", "showWindowScheme", "", "S1", "R1", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lorg/json/JSONObject;", "N1", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetGroupId", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_showWindowScheme", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q1", "()Landroidx/lifecycle/MutableLiveData;", "showWindowSchemeLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQGroupWindowViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _showWindowScheme;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> showWindowSchemeLiveData;

    public ECQGroupWindowViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._showWindowScheme = mutableLiveData;
        this.showWindowSchemeLiveData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(String groupId, String showWindowScheme) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("group_id", groupId);
        jSONObject.put(ZPlanPublishSource.FROM_SCHEME, showWindowScheme);
        jSONObject.put("scheme_time", System.currentTimeMillis());
        cg0.a.b("ECQGroupWindowViewModel", "[saveShowWindowSchemeToLocal] showWindowSchemeJson = " + jSONObject);
        ECLocalConfig.f100650f.setString("show_window_scheme", jSONObject.toString(), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object N1(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONObject> continuation) {
        ECQGroupWindowViewModel$changeShowWindowScheme$1 eCQGroupWindowViewModel$changeShowWindowScheme$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECQGroupWindowViewModel$changeShowWindowScheme$1) {
            eCQGroupWindowViewModel$changeShowWindowScheme$1 = (ECQGroupWindowViewModel$changeShowWindowScheme$1) continuation;
            int i16 = eCQGroupWindowViewModel$changeShowWindowScheme$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCQGroupWindowViewModel$changeShowWindowScheme$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCQGroupWindowViewModel$changeShowWindowScheme$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCQGroupWindowViewModel$changeShowWindowScheme$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECQGroupWindowViewModel$changeShowWindowScheme$result$1 eCQGroupWindowViewModel$changeShowWindowScheme$result$1 = new ECQGroupWindowViewModel$changeShowWindowScheme$result$1(str, null);
                    eCQGroupWindowViewModel$changeShowWindowScheme$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCQGroupWindowViewModel$changeShowWindowScheme$result$1, eCQGroupWindowViewModel$changeShowWindowScheme$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((ECNetworkResponse) obj).b();
            }
        }
        eCQGroupWindowViewModel$changeShowWindowScheme$1 = new ECQGroupWindowViewModel$changeShowWindowScheme$1(this, continuation);
        Object obj2 = eCQGroupWindowViewModel$changeShowWindowScheme$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCQGroupWindowViewModel$changeShowWindowScheme$1.label;
        if (i3 != 0) {
        }
        return ((ECNetworkResponse) obj2).b();
    }

    public final String P1(String targetGroupId) {
        JSONObject jSONObject;
        String string = ECLocalConfig.f100650f.getString("show_window_scheme", "", Boolean.TRUE);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            cg0.a.b("ECQGroupWindowViewModel", "[getShowWindowSchemeFromLocal] showWindowSchemeJson = " + string);
            jSONObject = new JSONObject(string);
        } catch (JSONException unused) {
            cg0.a.b("ECQGroupWindowViewModel", "[getSchemeParameterFromLocal] convert json to map error, content = " + string);
        }
        if (!Intrinsics.areEqual(targetGroupId, jSONObject.optString("group_id", ""))) {
            return "";
        }
        long optLong = jSONObject.optLong("scheme_time", 0L);
        if (optLong > 0 && optLong - System.currentTimeMillis() < 86400000) {
            return jSONObject.optString(ZPlanPublishSource.FROM_SCHEME);
        }
        return "";
    }

    public final MutableLiveData<String> Q1() {
        return this.showWindowSchemeLiveData;
    }

    public final void R1(String groupId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECQGroupWindowViewModel$requestShowWindowScheme$1(this, groupId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object O1(ECQGroupWindowViewModel eCQGroupWindowViewModel, String str, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return eCQGroupWindowViewModel.N1(str, coroutineDispatcher, continuation);
    }
}
