package com.tencent.mobileqq.troop.homework.homework.submit.vm;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.homework.submit.fragment.SubmitHomeworkFragment;
import com.tencent.mobileqq.troop.homework.homework.submit.media.SubmitHomeworkMediaManager;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.d;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R*\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "Landroidx/lifecycle/ViewModel;", "", "response", "", "f2", "", "iconType", "stringId", "d2", "Lcom/tencent/mobileqq/troop/homework/homework/submit/fragment/SubmitHomeworkFragment;", "fragment", "Landroid/os/Bundle;", "bundle", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/troop/homework/homework/submit/media/SubmitHomeworkMediaManager;", "T1", "", "R1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/collections/ArrayList;", "U1", "Z1", "g2", "b2", "c2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "setShouldFinishPage", "(Landroidx/lifecycle/MutableLiveData;)V", "shouldFinishPage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "X1", "setShouldSetResult", "shouldSetResult", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopId", "D", "homeWorkId", "E", "Ljava/util/ArrayList;", "modifyItems", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "S1", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/media/SubmitHomeworkMediaManager;", "mediaEditManager", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class SubmitHomeWorkVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String troopId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String homeWorkId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<BaseItem> modifyItems;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaEditManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> shouldFinishPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> shouldSetResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM$a;", "", "", "KEY_CURRENT_DATA", "Ljava/lang/String;", "KEY_HOMEWORK_ID", "KEY_TROOP_ID", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SubmitHomeWorkVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Boolean bool = Boolean.FALSE;
        this.shouldFinishPage = new MutableLiveData<>(bool);
        this.shouldSetResult = new MutableLiveData<>(bool);
        this.troopId = "";
        this.homeWorkId = "";
        this.modifyItems = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubmitHomeworkMediaManager>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM$mediaEditManager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubmitHomeWorkVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SubmitHomeworkMediaManager invoke() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SubmitHomeworkMediaManager) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                str = SubmitHomeWorkVM.this.troopId;
                return new SubmitHomeworkMediaManager(str, ViewModelKt.getViewModelScope(SubmitHomeWorkVM.this));
            }
        });
        this.mediaEditManager = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubmitHomeworkMediaManager S1() {
        return (SubmitHomeworkMediaManager) this.mediaEditManager.getValue();
    }

    private final void d2(final int iconType, final int stringId) {
        final BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return;
        }
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.vm.a
            @Override // java.lang.Runnable
            public final void run() {
                SubmitHomeWorkVM.e2(BaseApplication.this, iconType, stringId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(BaseApplication context, int i3, int i16) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(boolean response) {
        if (!response) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWSubmitHomeWorkVM", "solveResponse");
            d2(0, R.string.f2342079b);
        } else {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("SubmitHWSubmitHomeWorkVM", "response: success");
            d2(2, R.string.f2342379e);
        }
    }

    @NotNull
    public final String R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.homeWorkId;
    }

    @NotNull
    public final SubmitHomeworkMediaManager T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SubmitHomeworkMediaManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return S1();
    }

    @Nullable
    public final ArrayList<BaseItem> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.modifyItems;
    }

    @NotNull
    public final MutableLiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.shouldFinishPage;
    }

    @NotNull
    public final MutableLiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.shouldSetResult;
    }

    @NotNull
    public final String Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "\u63d0\u4ea4\u4f5c\u4e1a";
    }

    public final void a2(@NotNull SubmitHomeworkFragment fragment, @Nullable Bundle bundle) {
        ArrayList<BaseItem> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragment, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (bundle == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWSubmitHomeWorkVM", "init but arguments is null");
            this.shouldFinishPage.postValue(Boolean.TRUE);
            return;
        }
        String string = bundle.getString("troop_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(KEY_TROOP_ID, \"\")");
        this.troopId = string;
        String string2 = bundle.getString("hw_id", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(KEY_HOMEWORK_ID, \"\")");
        this.homeWorkId = string2;
        Serializable serializable = bundle.getSerializable("hw_data");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        this.modifyItems = arrayList;
    }

    public final boolean b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (!S1().W() || !S1().C() || !S1().T()) {
            return false;
        }
        return true;
    }

    public final boolean c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (!S1().A()) {
            return false;
        }
        return true;
    }

    public final void g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SubmitHomeWorkVM$submit$1(new d(), this, elapsedRealtime, null), 3, null);
    }
}
