package com.tencent.qqnt.qwallet.aio.hb;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0014R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u001f\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00188\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00188\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u0011\u0010&\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010)\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/SkinHbViewModel;", "Lcom/tencent/qqnt/qwallet/aio/hb/j;", "", "f2", SemanticAttributes.DbSystemValues.H2, "o2", "", "m2", "O1", "", "<set-?>", "E", "I", "getSkinType", "()I", "skinType", UserInfo.SEX_FEMALE, "skinId", "", "G", "Ljava/lang/String;", "outerSkinId", "H", "skinFrom", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "k2", "()Landroidx/lifecycle/MutableLiveData;", "skinResUrl", "J", "j2", "skinOpenIconUrl", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "K", "l2", "tailLiveData", "i2", "()Ljava/lang/String;", "skinInfo", ICustomDataEditor.NUMBER_PARAM_2, "()Z", "isSpecialShape", "<init>", "()V", "L", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SkinHbViewModel extends j {

    /* renamed from: E, reason: from kotlin metadata */
    private int skinType;

    /* renamed from: F, reason: from kotlin metadata */
    private int skinId;

    /* renamed from: H, reason: from kotlin metadata */
    private int skinFrom;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String outerSkinId = "";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> skinResUrl = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> skinOpenIconUrl = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<HbSkinData.Tail> tailLiveData = new MutableLiveData<>();

    private final void f2() {
        this.skinResUrl.postValue(null);
        this.skinOpenIconUrl.postValue(null);
        this.tailLiveData.postValue(null);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.n
            @Override // java.lang.Runnable
            public final void run() {
                SkinHbViewModel.g2(SkinHbViewModel.this);
            }
        }, 160, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(SkinHbViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2();
    }

    @WorkerThread
    private final void h2() {
        if (!m2()) {
            QLog.d(getTAG(), 4, "fetchSkinInfo: invalid skin " + this.skinId + "-" + this.outerSkinId + "-" + this.skinFrom);
            o2();
            return;
        }
        ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).getSkinData(this.skinId, this.outerSkinId, this.skinFrom, new Function1<HbSkinData, Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.SkinHbViewModel$fetchSkinDataAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                int i3;
                boolean z16;
                String str;
                int i16;
                boolean z17 = false;
                if (hbSkinData != null) {
                    SkinHbViewModel skinHbViewModel = SkinHbViewModel.this;
                    int skinId = hbSkinData.getSkinId();
                    i3 = skinHbViewModel.skinId;
                    if (skinId == i3) {
                        String outerSkinId = hbSkinData.getOuterSkinId();
                        str = skinHbViewModel.outerSkinId;
                        if (Intrinsics.areEqual(outerSkinId, str)) {
                            int skinFrom = hbSkinData.getSkinFrom();
                            i16 = skinHbViewModel.skinFrom;
                            if (skinFrom == i16) {
                                z16 = true;
                                if (z16) {
                                    skinHbViewModel.k2().postValue(hbSkinData.getAioResUrl());
                                    skinHbViewModel.j2().postValue(hbSkinData.getPopOpenUrl());
                                    skinHbViewModel.l2().postValue(hbSkinData.getTail());
                                    z17 = true;
                                }
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                }
                if (z17) {
                    return;
                }
                SkinHbViewModel.this.o2();
            }
        });
    }

    private final boolean m2() {
        boolean z16;
        if (this.skinFrom == 0 && this.skinId > 0) {
            return true;
        }
        if (this.outerSkinId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2() {
        this.skinResUrl.postValue(null);
        this.skinOpenIconUrl.postValue(null);
        this.tailLiveData.postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.j, com.tencent.qqnt.qwallet.aio.hb.c, com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        super.O1();
        this.skinType = M1().k().optInt("skin_type", 0);
        QLog.d(getTAG(), 1, "onMsgParsed: vm " + hashCode() + " skinInfo " + i2() + " msgType " + M1().getMsgType());
        this.skinId = M1().l().uint32_skin_id.get();
        String stringUtf8 = M1().l().bytes_outer_skin_id.get().toStringUtf8();
        Intrinsics.checkNotNullExpressionValue(stringUtf8, "aioModel.elemResv.bytes_\u2026n_id.get().toStringUtf8()");
        this.outerSkinId = stringUtf8;
        this.skinFrom = M1().l().uint32_skin_from.get();
        f2();
    }

    @NotNull
    public final String i2() {
        return this.skinId + "-" + this.outerSkinId + "-" + this.skinFrom;
    }

    @NotNull
    public final MutableLiveData<String> j2() {
        return this.skinOpenIconUrl;
    }

    @NotNull
    public final MutableLiveData<String> k2() {
        return this.skinResUrl;
    }

    @NotNull
    public final MutableLiveData<HbSkinData.Tail> l2() {
        return this.tailLiveData;
    }

    public final boolean n2() {
        if ((this.skinType & 8) != 0) {
            return true;
        }
        return false;
    }
}
