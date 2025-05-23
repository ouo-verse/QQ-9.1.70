package com.tencent.mobileqq.wink.magicAvatar.picker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0007\u00a2\u0006\u0004\b,\u0010-J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR*\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R-\u0010(\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f0#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "W1", "map", "", "X1", "path", "style", "R1", "onCleared", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_selectEvent", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "selectEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "Lkotlin/collections/ArrayList;", "D", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_styleList", "Lkotlinx/coroutines/flow/SharedFlow;", "E", "Lkotlinx/coroutines/flow/SharedFlow;", "U1", "()Lkotlinx/coroutines/flow/SharedFlow;", "styleList", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "uploadUrlMap", "<init>", "()V", "G", "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarPickerViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> selectEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<ArrayList<MagicAvatarMaterialInfo>> _styleList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<ArrayList<MagicAvatarMaterialInfo>> styleList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, String> uploadUrlMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _selectEvent;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$b;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$c;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$d;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class b {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "a", "Ljava/lang/Exception;", "()Ljava/lang/Exception;", "e", "<init>", "(Ljava/lang/Exception;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Exception e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Exception e16) {
                super(null);
                Intrinsics.checkNotNullParameter(e16, "e");
                this.e = e16;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final Exception getE() {
                return this.e;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$b;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "a", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "()Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "info", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9056b extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final MagicAvatarGenerateInfo info;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9056b(@NotNull MagicAvatarGenerateInfo info) {
                super(null);
                Intrinsics.checkNotNullParameter(info, "info");
                this.info = info;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final MagicAvatarGenerateInfo getInfo() {
                return this.info;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$c;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f323532a = new c();

            c() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u00a2\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b$d;", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel$b;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "a", "Ljava/lang/Exception;", "getE", "()Ljava/lang/Exception;", "e", "<init>", "(Ljava/lang/Exception;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private final Exception e;

            public d(@Nullable Exception exc) {
                super(null);
                this.e = exc;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    public MagicAvatarPickerViewModel() {
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._selectEvent = mutableLiveData;
        this.selectEvent = mutableLiveData;
        MutableSharedFlow<ArrayList<MagicAvatarMaterialInfo>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._styleList = MutableSharedFlow$default;
        this.styleList = MutableSharedFlow$default;
        this.uploadUrlMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1() {
        QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, String> W1() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xsj_magic_avatar_upload_file", "-1");
        hashMap.put("xsj_magic_avatar_generate_time", "-1");
        hashMap.put("xsj_magic_avatar_download_time", "-1");
        hashMap.put("xsj_magic_avatar_get_ids", "-1");
        hashMap.put("xsj_magic_avatar_generate_whole_time", "-1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(HashMap<String, String> map) {
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportMagicAvatar(map);
    }

    public final void R1(@NotNull String path, @Nullable String style) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (style == null) {
            style = "";
        }
        if (NetworkUtil.isNetworkAvailable()) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarPickerViewModel$generateMagicAvatar$2(this, path, style, null), 3, null);
        } else {
            com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.picker.b
                @Override // java.lang.Runnable
                public final void run() {
                    MagicAvatarPickerViewModel.S1();
                }
            });
            this._selectEvent.postValue(b.c.f323532a);
        }
    }

    @NotNull
    public final LiveData<b> T1() {
        return this.selectEvent;
    }

    @NotNull
    public final SharedFlow<ArrayList<MagicAvatarMaterialInfo>> U1() {
        return this.styleList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }
}
