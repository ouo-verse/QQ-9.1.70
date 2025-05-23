package com.tencent.qqnt.qbasealbum.select.viewmodel;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import com.tencent.qqnt.qbasealbum.select.model.b;
import com.tencent.qqnt.qbasealbum.select.model.c;
import com.tencent.qqnt.qbasealbum.select.model.d;
import com.tencent.qqnt.qbasealbum.select.model.f;
import com.tencent.qqnt.qbasealbum.select.model.g;
import com.tencent.qqnt.qbasealbum.select.model.h;
import com.tencent.qqnt.qbasealbum.select.repository.SelectedLocalMediaRepository;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J!\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0002R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020(0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "selectMedias", "", "T1", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "toAddedMedia", "", "insertIndex", "N1", "fromPosInSelectedMediaList", "toPosInSelectedMediaList", "X1", "posInSelectedMediaList", "toRemovedMedia", "Z1", "(ILcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)Lkotlin/Unit;", "toClickMedia", "P1", "onCleared", "", "W1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/qbasealbum/select/repository/SelectedLocalMediaRepository;", "i", "Lcom/tencent/qqnt/qbasealbum/select/repository/SelectedLocalMediaRepository;", "selectedLocalMediaRepo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "_selectedMedia", BdhLogUtil.LogTag.Tag_Conn, "getSelectedMedia", "()Ljava/util/List;", "selectedMedia", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "D", "Landroidx/lifecycle/MutableLiveData;", "_selectedMediaChangedActionMutableLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "selectedMediaChangedActionLiveData", UserInfo.SEX_FEMALE, "I", "R1", "()I", "c2", "(I)V", "maxSelectMediaSize", "G", "Q1", "b2", "alreadySelectedMediaCount", "<init>", "()V", "H", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SelectedMediaViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> _selectedMediaChangedActionMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> selectedMediaChangedActionLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private int maxSelectMediaSize;

    /* renamed from: G, reason: from kotlin metadata */
    private int alreadySelectedMediaCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SelectedLocalMediaRepository selectedLocalMediaRepo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> _selectedMedia;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SelectedMediaViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.selectedLocalMediaRepo = new SelectedLocalMediaRepository();
        ArrayList arrayList = new ArrayList();
        this._selectedMedia = arrayList;
        this.selectedMedia = arrayList;
        MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> mutableLiveData = new MutableLiveData<>();
        this._selectedMediaChangedActionMutableLiveData = mutableLiveData;
        this.selectedMediaChangedActionLiveData = mutableLiveData;
        this.maxSelectMediaSize = 20;
    }

    public static /* synthetic */ void O1(SelectedMediaViewModel selectedMediaViewModel, LocalMediaInfo localMediaInfo, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        selectedMediaViewModel.N1(localMediaInfo, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void U1(SelectedMediaViewModel selectedMediaViewModel, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = QAlbumPickerContext.f361201a.e().a();
        }
        selectedMediaViewModel.T1(list);
    }

    @MainThread
    public final void N1(@NotNull final LocalMediaInfo toAddedMedia, int insertIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) toAddedMedia, insertIndex);
            return;
        }
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        final List<LocalMediaInfo> list = this._selectedMedia;
        if (!W1()) {
            return;
        }
        if (insertIndex >= 0 && insertIndex <= list.size()) {
            list.add(insertIndex, toAddedMedia);
        } else {
            list.add(toAddedMedia);
        }
        ox3.a.g("SelectedMediaViewModel", new Function0<String>(list, toAddedMedia) { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$addSelectedMedia$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List<LocalMediaInfo> $this_with;
            final /* synthetic */ LocalMediaInfo $toAddedMedia;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_with = list;
                this.$toAddedMedia = toAddedMedia;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) list, (Object) toAddedMedia);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[addSelectedMedia] size=" + this.$this_with.size() + ", path=" + this.$toAddedMedia.getPath();
            }
        });
        this._selectedMediaChangedActionMutableLiveData.setValue(new b(list.size() - 1, toAddedMedia, list));
        if (!W1()) {
            this._selectedMediaChangedActionMutableLiveData.postValue(new d());
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(toAddedMedia) && !com.tencent.qqnt.qbasealbum.ktx.b.l(toAddedMedia)) {
            com.tencent.qqnt.qbasealbum.ktx.b.k(toAddedMedia);
        }
    }

    @MainThread
    @Nullable
    public final Unit P1(int posInSelectedMediaList, @NotNull final LocalMediaInfo toClickMedia) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Unit) iPatchRedirector.redirect((short) 17, (Object) this, posInSelectedMediaList, (Object) toClickMedia);
        }
        Intrinsics.checkNotNullParameter(toClickMedia, "toClickMedia");
        final List<LocalMediaInfo> list = this._selectedMedia;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, posInSelectedMediaList);
        if (((LocalMediaInfo) orNull) != null) {
            this._selectedMediaChangedActionMutableLiveData.setValue(new c(posInSelectedMediaList, toClickMedia, list));
            ox3.a.g("SelectedMediaViewModel", new Function0<String>(list, toClickMedia) { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$clickSelectedMedia$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List<LocalMediaInfo> $this_with;
                final /* synthetic */ LocalMediaInfo $toClickMedia;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$this_with = list;
                    this.$toClickMedia = toClickMedia;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) list, (Object) toClickMedia);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "[clickSelectedMedia] size=" + this.$this_with.size() + ", path=" + this.$toClickMedia.getPath();
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    public final int Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.alreadySelectedMediaCount;
    }

    public final int R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxSelectMediaSize;
    }

    @NotNull
    public final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.selectedMediaChangedActionLiveData;
    }

    public final void T1(@NotNull List<SelectMediaInfo> selectMedias) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) selectMedias);
            return;
        }
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        ox3.a.j(SelectedMediaViewModel$initSelectedMedia$1.INSTANCE);
        ArrayList arrayList = new ArrayList();
        for (Object obj : selectMedias) {
            if (((SelectMediaInfo) obj).getPageType().isLocalMedia()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((SelectMediaInfo) it.next()).getLocalMediaPath());
        }
        this._selectedMedia.clear();
        if (arrayList2.isEmpty()) {
            this._selectedMediaChangedActionMutableLiveData.setValue(new f(this._selectedMedia));
        } else {
            this.selectedLocalMediaRepo.b(arrayList2, new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$initSelectedMedia$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$initSelectedMedia$2$1", f = "SelectedMediaViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$initSelectedMedia$2$1, reason: invalid class name */
                /* loaded from: classes25.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ List<LocalMediaInfo> $it;
                    int label;
                    final /* synthetic */ SelectedMediaViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SelectedMediaViewModel selectedMediaViewModel, List<LocalMediaInfo> list, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = selectedMediaViewModel;
                        this.$it = list;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, selectedMediaViewModel, list, continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        return new AnonymousClass1(this.this$0, this.$it, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        List list;
                        MutableLiveData mutableLiveData;
                        List list2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                list = this.this$0._selectedMedia;
                                list.addAll(this.$it);
                                mutableLiveData = this.this$0._selectedMediaChangedActionMutableLiveData;
                                list2 = this.this$0._selectedMedia;
                                mutableLiveData.setValue(new f(list2));
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectedMediaViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                    invoke2((List<LocalMediaInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<LocalMediaInfo> it5) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it5);
                    } else {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.f()), null, null, new AnonymousClass1(SelectedMediaViewModel.this, it5, null), 3, null);
                    }
                }
            });
        }
    }

    public final boolean W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (this._selectedMedia.size() + this.alreadySelectedMediaCount < this.maxSelectMediaSize) {
            return true;
        }
        return false;
    }

    @MainThread
    public final void X1(int fromPosInSelectedMediaList, int toPosInSelectedMediaList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(fromPosInSelectedMediaList), Integer.valueOf(toPosInSelectedMediaList));
            return;
        }
        List<LocalMediaInfo> list = this._selectedMedia;
        list.add(toPosInSelectedMediaList, list.remove(fromPosInSelectedMediaList));
        this._selectedMediaChangedActionMutableLiveData.postValue(new g(fromPosInSelectedMediaList, toPosInSelectedMediaList, list));
    }

    @MainThread
    @Nullable
    public final Unit Z1(int posInSelectedMediaList, @NotNull final LocalMediaInfo toRemovedMedia) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Unit) iPatchRedirector.redirect((short) 16, (Object) this, posInSelectedMediaList, (Object) toRemovedMedia);
        }
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        final List<LocalMediaInfo> list = this._selectedMedia;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, posInSelectedMediaList);
        if (((LocalMediaInfo) orNull) != null) {
            list.remove(posInSelectedMediaList);
            this._selectedMediaChangedActionMutableLiveData.setValue(new h(posInSelectedMediaList, toRemovedMedia, list));
            ox3.a.g("SelectedMediaViewModel", new Function0<String>(list, toRemovedMedia) { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel$removeSelectedMedia$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List<LocalMediaInfo> $this_with;
                final /* synthetic */ LocalMediaInfo $toRemovedMedia;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$this_with = list;
                    this.$toRemovedMedia = toRemovedMedia;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) list, (Object) toRemovedMedia);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "[removeSelectedMedia] size=" + this.$this_with.size() + ", path=" + this.$toRemovedMedia.getPath();
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    @NotNull
    public final String a2() {
        int roundToInt;
        int roundToInt2;
        long fileSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.selectedMedia.isEmpty()) {
            return "";
        }
        float f16 = 0.0f;
        for (LocalMediaInfo localMediaInfo : this.selectedMedia) {
            if (localMediaInfo.getExtIsEdit()) {
                String path = localMediaInfo.getPath();
                if (path != null) {
                    fileSize = new File(path).length();
                }
            } else {
                fileSize = localMediaInfo.getFileSize();
            }
            f16 += (float) fileSize;
        }
        if (f16 < 1024.0f) {
            return "(1K)";
        }
        float f17 = 1024;
        float f18 = 10;
        roundToInt = MathKt__MathJVMKt.roundToInt((f16 / f17) * f18);
        float f19 = roundToInt / 10.0f;
        if (f19 >= 1024.0f) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt((f19 / f17) * f18);
            return "(" + (roundToInt2 / 10.0f) + "M)";
        }
        return "(" + f19 + "K)";
    }

    public final void b2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.alreadySelectedMediaCount = i3;
        }
    }

    public final void c2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.maxSelectMediaSize = i3;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "SelectedMediaViewModel";
    }

    @NotNull
    public final List<LocalMediaInfo> getSelectedMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectedMedia;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onCleared();
            this.selectedLocalMediaRepo.c();
        }
    }
}
