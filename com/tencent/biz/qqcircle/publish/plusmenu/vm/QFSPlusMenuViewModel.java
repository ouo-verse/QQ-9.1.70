package com.tencent.biz.qqcircle.publish.plusmenu.vm;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightVersionInfo;
import pa0.PlusMenuIconData;
import pa0.PlusMenuNewerPendentGuideData;
import pa0.PlusMenuRegularData;
import pa0.PlusMenuServerData;
import pa0.e;
import ra0.c;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJG\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0019\u0010\t\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\u00a2\u0006\u0002\b\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R<\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u008c\u0001\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010\u00172:\u0010\u0011\u001a6\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020.0'8\u0006\u00a2\u0006\f\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002050'8\u0006\u00a2\u0006\f\n\u0004\b8\u0010*\u001a\u0004\b9\u0010,R\u0017\u0010>\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b;\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusmenu/vm/QFSPlusMenuViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "T", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MutableLiveData;", "source", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "", "N1", "", "getLogTag", "onCleared", "", "", "<set-?>", "i", "Ljava/util/Map;", "getReportBean", "()Ljava/util/Map;", "reportBean", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "which", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "getOnSelect", "()Lkotlin/jvm/functions/Function2;", "onSelect", "Lpa0/d;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_serverData", "Landroidx/lifecycle/LiveData;", "Lpa0/c;", "D", "Landroidx/lifecycle/LiveData;", "getRegularData", "()Landroidx/lifecycle/LiveData;", "regularData", "Lpa0/a;", "E", "Landroidx/lifecycle/MediatorLiveData;", "_iconData", UserInfo.SEX_FEMALE, "getIconData", "iconData", "Lpa0/b;", "G", "_newerPendentGuide", "H", "getNewerPendentGuide", "newerPendentGuide", "I", "getRegularEntranceStubId", "()I", "regularEntranceStubId", "Landroidx/lifecycle/Observer;", "J", "Landroidx/lifecycle/Observer;", "serverDataObserver", "<init>", "()V", "K", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPlusMenuViewModel extends BaseViewModel {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PlusMenuServerData> _serverData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PlusMenuRegularData> regularData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PlusMenuIconData> _iconData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PlusMenuIconData> iconData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<PlusMenuNewerPendentGuideData> _newerPendentGuide;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<PlusMenuNewerPendentGuideData> newerPendentGuide;

    /* renamed from: I, reason: from kotlin metadata */
    private final int regularEntranceStubId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Observer<PlusMenuServerData> serverDataObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Object> reportBean = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super Bundle, Unit> onSelect;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/publish/plusmenu/vm/QFSPlusMenuViewModel$a", "Landroidx/lifecycle/Observer;", "Lpa0/d;", "data", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Observer<PlusMenuServerData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull PlusMenuServerData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("QFSPlusMenuViewModel", 1, "serverDataLiveData, onChanged ");
            QFSPlusMenuViewModel.this._serverData.postValue(data);
            c.f430999a.c().removeObserver(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusmenu/vm/QFSPlusMenuViewModel$b;", "", "", "a", "()Ljava/lang/String;", "lightSdkVersion", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.publish.plusmenu.vm.QFSPlusMenuViewModel$b, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            List split$default;
            if (TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
                return LightVersionInfo.VERSION_NAME;
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) LightVersionInfo.VERSION_NAME, new String[]{"."}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length <= 3) {
                return LightVersionInfo.VERSION_NAME;
            }
            return strArr[0] + "." + strArr[1] + "." + strArr[2];
        }

        Companion() {
        }
    }

    public QFSPlusMenuViewModel() {
        Unit unit;
        MutableLiveData<PlusMenuServerData> mutableLiveData = new MutableLiveData<>();
        this._serverData = mutableLiveData;
        this.regularData = new MutableLiveData(ra0.a.f430998a.a());
        MediatorLiveData<PlusMenuIconData> mediatorLiveData = new MediatorLiveData<>();
        this._iconData = mediatorLiveData;
        this.iconData = mediatorLiveData;
        MediatorLiveData<PlusMenuNewerPendentGuideData> mediatorLiveData2 = new MediatorLiveData<>();
        this._newerPendentGuide = mediatorLiveData2;
        this.newerPendentGuide = mediatorLiveData2;
        this.regularEntranceStubId = R.id.f89364zk;
        N1(mediatorLiveData, mutableLiveData, new Function1<PlusMenuServerData, PlusMenuIconData>() { // from class: com.tencent.biz.qqcircle.publish.plusmenu.vm.QFSPlusMenuViewModel.1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PlusMenuIconData invoke(@NotNull PlusMenuServerData observeSourceData) {
                Intrinsics.checkNotNullParameter(observeSourceData, "$this$observeSourceData");
                PlusMenuIconData a16 = e.a(observeSourceData);
                if (a16 == null) {
                    return null;
                }
                QLog.d("QFSPlusMenuViewModel", 1, "iconData:" + a16);
                return a16;
            }
        });
        N1(mediatorLiveData2, mutableLiveData, new Function1<PlusMenuServerData, PlusMenuNewerPendentGuideData>() { // from class: com.tencent.biz.qqcircle.publish.plusmenu.vm.QFSPlusMenuViewModel.2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PlusMenuNewerPendentGuideData invoke(@NotNull PlusMenuServerData observeSourceData) {
                Intrinsics.checkNotNullParameter(observeSourceData, "$this$observeSourceData");
                PlusMenuNewerPendentGuideData b16 = e.b(observeSourceData);
                if (b16 == null) {
                    return null;
                }
                QLog.d("QFSPlusMenuViewModel", 1, "newerPendentGuide:" + b16);
                return b16;
            }
        });
        c cVar = c.f430999a;
        PlusMenuServerData b16 = cVar.b();
        if (b16 != null) {
            mutableLiveData.postValue(b16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d("QFSPlusMenuViewModel", 1, "init, observer serverDataLiveData ");
            LiveData<PlusMenuServerData> c16 = cVar.c();
            a aVar = new a();
            this.serverDataObserver = aVar;
            c16.observeForever(aVar);
        }
    }

    private final <T, S> void N1(final MediatorLiveData<T> mediatorLiveData, MutableLiveData<S> mutableLiveData, final Function1<? super S, ? extends T> function1) {
        final Function1<S, Unit> function12 = new Function1<S, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusmenu.vm.QFSPlusMenuViewModel$observeSourceData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((QFSPlusMenuViewModel$observeSourceData$1<S>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(S s16) {
                Object invoke;
                if (s16 == null || (invoke = function1.invoke(s16)) == null) {
                    return;
                }
                mediatorLiveData.setValue(invoke);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.biz.qqcircle.publish.plusmenu.vm.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPlusMenuViewModel.O1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPlusMenuViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.onSelect = null;
        Observer<PlusMenuServerData> observer = this.serverDataObserver;
        if (observer != null) {
            c.f430999a.c().removeObserver(observer);
        }
    }
}
