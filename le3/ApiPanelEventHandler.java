package le3;

import android.view.View;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u00e4\u0001\u0012<\u0010\u0015\u001a8\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\t\u0012<\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\t\u0012\u001e\u0010\u001e\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020 0\u0019\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020 0\u0019\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003RM\u0010\u0015\u001a8\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014RM\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R2\u0010\u001e\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00198\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u001b\u0010\"R#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020 0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b%\u0010\u001dR\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010'\u001a\u0004\b\u0011\u0010(R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020 0\u00198\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b*\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lle3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "Lle3/b;", DownloadInfo.spKey_Config, "Lkotlinx/coroutines/Deferred;", "a", "Lkotlin/jvm/functions/Function2;", "d", "()Lkotlin/jvm/functions/Function2;", "onSelectAction", "b", "e", "onSelectScene", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "c", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "getSelectingScene", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "onClickDress", "Landroid/view/View$OnClickListener;", "f", "setOnClickAction", "Ljava/lang/String;", "()Ljava/lang/String;", "friendUin", "g", "setOnDismissAction", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: le3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ApiPanelEventHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function2<CoroutineScope, b, Deferred<Boolean>> onSelectAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function2<CoroutineScope, b, Deferred<Boolean>> onSelectScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<Continuation<? super Integer>, Object> getSelectingScene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function0<Unit> onClickDress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<View.OnClickListener, Unit> setOnClickAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String friendUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<View.OnClickListener, Unit> setOnDismissAction;

    /* JADX WARN: Multi-variable type inference failed */
    public ApiPanelEventHandler(@NotNull Function2<? super CoroutineScope, ? super b, ? extends Deferred<Boolean>> onSelectAction, @NotNull Function2<? super CoroutineScope, ? super b, ? extends Deferred<Boolean>> onSelectScene, @NotNull Function1<? super Continuation<? super Integer>, ? extends Object> getSelectingScene, @NotNull Function0<Unit> onClickDress, @NotNull Function1<? super View.OnClickListener, Unit> setOnClickAction, @NotNull String friendUin, @NotNull Function1<? super View.OnClickListener, Unit> setOnDismissAction) {
        Intrinsics.checkNotNullParameter(onSelectAction, "onSelectAction");
        Intrinsics.checkNotNullParameter(onSelectScene, "onSelectScene");
        Intrinsics.checkNotNullParameter(getSelectingScene, "getSelectingScene");
        Intrinsics.checkNotNullParameter(onClickDress, "onClickDress");
        Intrinsics.checkNotNullParameter(setOnClickAction, "setOnClickAction");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(setOnDismissAction, "setOnDismissAction");
        this.onSelectAction = onSelectAction;
        this.onSelectScene = onSelectScene;
        this.getSelectingScene = getSelectingScene;
        this.onClickDress = onClickDress;
        this.setOnClickAction = setOnClickAction;
        this.friendUin = friendUin;
        this.setOnDismissAction = setOnDismissAction;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFriendUin() {
        return this.friendUin;
    }

    @NotNull
    public final Function1<Continuation<? super Integer>, Object> b() {
        return this.getSelectingScene;
    }

    @NotNull
    public final Function0<Unit> c() {
        return this.onClickDress;
    }

    @NotNull
    public final Function2<CoroutineScope, b, Deferred<Boolean>> d() {
        return this.onSelectAction;
    }

    @NotNull
    public final Function2<CoroutineScope, b, Deferred<Boolean>> e() {
        return this.onSelectScene;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiPanelEventHandler)) {
            return false;
        }
        ApiPanelEventHandler apiPanelEventHandler = (ApiPanelEventHandler) other;
        if (Intrinsics.areEqual(this.onSelectAction, apiPanelEventHandler.onSelectAction) && Intrinsics.areEqual(this.onSelectScene, apiPanelEventHandler.onSelectScene) && Intrinsics.areEqual(this.getSelectingScene, apiPanelEventHandler.getSelectingScene) && Intrinsics.areEqual(this.onClickDress, apiPanelEventHandler.onClickDress) && Intrinsics.areEqual(this.setOnClickAction, apiPanelEventHandler.setOnClickAction) && Intrinsics.areEqual(this.friendUin, apiPanelEventHandler.friendUin) && Intrinsics.areEqual(this.setOnDismissAction, apiPanelEventHandler.setOnDismissAction)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Function1<View.OnClickListener, Unit> f() {
        return this.setOnClickAction;
    }

    @NotNull
    public final Function1<View.OnClickListener, Unit> g() {
        return this.setOnDismissAction;
    }

    public int hashCode() {
        return (((((((((((this.onSelectAction.hashCode() * 31) + this.onSelectScene.hashCode()) * 31) + this.getSelectingScene.hashCode()) * 31) + this.onClickDress.hashCode()) * 31) + this.setOnClickAction.hashCode()) * 31) + this.friendUin.hashCode()) * 31) + this.setOnDismissAction.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApiPanelEventHandler(onSelectAction=" + this.onSelectAction + ", onSelectScene=" + this.onSelectScene + ", getSelectingScene=" + this.getSelectingScene + ", onClickDress=" + this.onClickDress + ", setOnClickAction=" + this.setOnClickAction + ", friendUin=" + this.friendUin + ", setOnDismissAction=" + this.setOnDismissAction + ')';
    }
}
