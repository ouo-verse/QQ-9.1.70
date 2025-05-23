package com.tencent.mobileqq.troop.selectmember.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0016\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H&J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", Constants.APK_CERTIFICATE, "Lcom/tencent/mobileqq/troop/selectmember/inject/b;", "T0", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "P", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "groups", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "needRemoveItems", "A0", "datas", "j1", "K", "", SquareJSConst.Params.PARAMS_UIN_LIST, "q0", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.selectmember.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8766a {
        public static void a(@NotNull a aVar, @NotNull c data) {
            List<? extends c> listOf;
            Intrinsics.checkNotNullParameter(data, "data");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(data);
            aVar.j1(listOf);
        }

        public static void b(@NotNull a aVar, @NotNull c data) {
            List<? extends c> listOf;
            Intrinsics.checkNotNullParameter(data, "data");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(data);
            aVar.K(listOf);
        }
    }

    void A0(@NotNull List<? extends c> needRemoveItems);

    @NotNull
    TroopSelectMemberConfig G1();

    void K(@NotNull List<? extends c> datas);

    @NotNull
    LiveData<List<c>> P();

    void Q(@NotNull List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> groups);

    @NotNull
    com.tencent.mobileqq.troop.selectmember.inject.b T0();

    @Nullable
    LifecycleOwner getLifecycleOwner();

    void j1(@NotNull List<? extends c> datas);

    void q0(@NotNull List<String> uinList);
}
