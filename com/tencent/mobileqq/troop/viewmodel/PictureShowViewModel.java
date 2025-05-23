package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001>B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\bH\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006\u00a2\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0006\u00a2\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowViewModel;", "Landroidx/lifecycle/ViewModel;", "", "rowKey", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/troop/viewmodel/ViewActionType;", "type", "", "f2", "numString", "P1", "c2", "d2", "e2", "b2", "onCleared", "Lcom/tencent/mobileqq/troop/viewmodel/d;", "i", "Lcom/tencent/mobileqq/troop/viewmodel/d;", "data", "Lcom/tencent/mobileqq/troop/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/viewmodel/a;", "pictureShowActionNotifier", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "_commentNum", "D", "W1", "_likeNum", "E", "Z1", "_shareNum", UserInfo.SEX_FEMALE, "X1", "_liked", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "commentNum", "H", "R1", "likeNum", "I", "T1", "shareNum", "J", "S1", "liked", "Le62/b;", "K", "Le62/b;", "mShareCallBack", "<init>", "(Lcom/tencent/mobileqq/troop/viewmodel/d;Lcom/tencent/mobileqq/troop/viewmodel/a;)V", "L", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class PictureShowViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy _commentNum;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy _likeNum;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy _shareNum;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy _liked;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> commentNum;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> likeNum;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> shareNum;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> liked;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final e62.b mShareCallBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a pictureShowActionNotifier;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowViewModel$a;", "", "", "KEY_CLICK_VIEW_TYPE", "Ljava/lang/String;", "KEY_LIKE_STATE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/viewmodel/PictureShowViewModel$b", "Le62/b;", "", "action", "", "b", "success", "", "msg", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements e62.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PictureShowViewModel.this);
            }
        }

        private final boolean b(int action) {
            if (action != 2 && action != 3 && action != 9 && action != 10 && action != 12 && action != 72 && action != 73) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e62.b
        public void a(int action, boolean success, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(action), Boolean.valueOf(success), msg2);
                return;
            }
            if (!PictureShowViewModel.this.a2(msg2) && b(action)) {
                PictureShowViewModel pictureShowViewModel = PictureShowViewModel.this;
                if (pictureShowViewModel.P1((String) pictureShowViewModel.Z1().getValue())) {
                    String str = (String) PictureShowViewModel.this.Z1().getValue();
                    if (str == null) {
                        str = "0";
                    }
                    PictureShowViewModel.this.Z1().setValue(String.valueOf(Integer.valueOf(str).intValue() + 1));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PictureShowViewModel(@NotNull d data, @NotNull a pictureShowActionNotifier) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(pictureShowActionNotifier, "pictureShowActionNotifier");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) data, (Object) pictureShowActionNotifier);
            return;
        }
        this.data = data;
        this.pictureShowActionNotifier = pictureShowActionNotifier;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<String>>() { // from class: com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel$_commentNum$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PictureShowViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<String> invoke() {
                d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MutableLiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
                dVar = PictureShowViewModel.this.data;
                mutableLiveData.setValue(dVar.a());
                return mutableLiveData;
            }
        });
        this._commentNum = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<String>>() { // from class: com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel$_likeNum$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PictureShowViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<String> invoke() {
                d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MutableLiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
                dVar = PictureShowViewModel.this.data;
                mutableLiveData.setValue(dVar.b());
                return mutableLiveData;
            }
        });
        this._likeNum = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<String>>() { // from class: com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel$_shareNum$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PictureShowViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<String> invoke() {
                d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MutableLiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
                dVar = PictureShowViewModel.this.data;
                mutableLiveData.setValue(dVar.f());
                return mutableLiveData;
            }
        });
        this._shareNum = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<Boolean>>() { // from class: com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel$_liked$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PictureShowViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<Boolean> invoke() {
                d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MutableLiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
                dVar = PictureShowViewModel.this.data;
                mutableLiveData.setValue(Boolean.valueOf(dVar.c()));
                return mutableLiveData;
            }
        });
        this._liked = lazy4;
        this.commentNum = U1();
        this.likeNum = W1();
        this.shareNum = Z1();
        this.liked = X1();
        this.mShareCallBack = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P1(String numString) {
        if (numString == null) {
            return false;
        }
        try {
            Integer num = Integer.valueOf(numString);
            Intrinsics.checkNotNullExpressionValue(num, "num");
            if (num.intValue() < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private final MutableLiveData<String> U1() {
        return (MutableLiveData) this._commentNum.getValue();
    }

    private final MutableLiveData<String> W1() {
        return (MutableLiveData) this._likeNum.getValue();
    }

    private final MutableLiveData<Boolean> X1() {
        return (MutableLiveData) this._liked.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<String> Z1() {
        return (MutableLiveData) this._shareNum.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a2(String rowKey) {
        boolean z16;
        boolean equals;
        if (this.data.d().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            equals = StringsKt__StringsJVMKt.equals(this.data.d(), rowKey, true);
            if (equals) {
                return false;
            }
        }
        return true;
    }

    private final void f2(ViewActionType type) {
        a aVar = this.pictureShowActionNotifier;
        String e16 = this.data.e();
        int value = type.getValue();
        Boolean value2 = X1().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        aVar.a(e16, value, value2.booleanValue());
    }

    @NotNull
    public final LiveData<String> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.commentNum;
    }

    @NotNull
    public final LiveData<String> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.likeNum;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.liked;
    }

    @NotNull
    public final LiveData<String> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.shareNum;
    }

    public final void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            f2(ViewActionType.ActivityClose);
        }
    }

    public final void c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f2(ViewActionType.SocialBottomBarCommentClickType);
        }
    }

    public final void d2() {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MutableLiveData<Boolean> X1 = X1();
        Boolean value = X1().getValue();
        Boolean bool = Boolean.TRUE;
        X1.setValue(Boolean.valueOf(!Intrinsics.areEqual(value, bool)));
        if (P1(W1().getValue())) {
            String str = "0";
            if (Intrinsics.areEqual(X1().getValue(), bool)) {
                String value2 = W1().getValue();
                if (value2 != null) {
                    str = value2;
                }
                intValue = Integer.valueOf(str).intValue() + 1;
            } else {
                String value3 = W1().getValue();
                if (value3 != null) {
                    str = value3;
                }
                intValue = Integer.valueOf(str).intValue() - 1;
            }
            W1().setValue(String.valueOf(intValue));
        }
        f2(ViewActionType.SocialBottomBarLikeClickType);
    }

    public final void e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            f2(ViewActionType.SocialBottomBarShareClickType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onCleared();
        }
    }
}
