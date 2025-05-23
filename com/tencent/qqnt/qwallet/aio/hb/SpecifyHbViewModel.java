package com.tencent.qqnt.qwallet.aio.hb;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0014R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/SpecifyHbViewModel;", "Lcom/tencent/qqnt/qwallet/aio/hb/j;", "", "uin", "", "d2", "c2", "O1", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "nickNameLiveData", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "avatarLiveData", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SpecifyHbViewModel extends j {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> nickNameLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Drawable> avatarLiveData = new MutableLiveData<>();

    private final void c2(String uin) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        this.avatarLiveData.postValue(FaceDrawable.getUserFaceDrawable(appInterface, uin, (byte) 4));
    }

    private final void d2(String uin) {
        ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(M1().i(), uin, new Function1<String, Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.SpecifyHbViewModel$updateNickName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SpecifyHbViewModel.this.b2().postValue(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.j, com.tencent.qqnt.qwallet.aio.hb.c, com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        Object firstOrNull;
        super.O1();
        QLog.d(getTAG(), 1, "onMsgParsed: viewModel " + hashCode() + " msgType " + M1().getMsgType() + ", walletElement " + M1().getTitle() + " listId " + M1().m());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) M1().j());
        Long l3 = (Long) firstOrNull;
        if (l3 != null) {
            String valueOf = String.valueOf(l3.longValue());
            d2(valueOf);
            c2(valueOf);
        }
    }

    @NotNull
    public final MutableLiveData<Drawable> a2() {
        return this.avatarLiveData;
    }

    @NotNull
    public final MutableLiveData<String> b2() {
        return this.nickNameLiveData;
    }
}
