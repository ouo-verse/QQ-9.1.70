package com.tencent.mobileqq.troop.teamup.member.adapter;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u00f5\u0001\u00126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00126\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00126\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bRG\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rRG\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\n\u0010\rRG\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rRG\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/tencent/mobileqq/troop/teamup/member/data/e;", "data", "", "a", "Lkotlin/jvm/functions/Function2;", "e", "()Lkotlin/jvm/functions/Function2;", "itemTeamUpTypeClick", "Lcom/tencent/mobileqq/troop/teamup/member/data/c;", "b", "itemInviteTroopClick", "c", "d", "itemShowImageClick", "itemSelectClick", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "itemReloadDataClick", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.e, Unit> itemTeamUpTypeClick;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemInviteTroopClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemShowImageClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemSelectClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> itemReloadDataClick;

    public a(@NotNull Function2<? super View, ? super com.tencent.mobileqq.troop.teamup.member.data.e, Unit> itemTeamUpTypeClick, @NotNull Function2<? super View, ? super com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemInviteTroopClick, @NotNull Function2<? super View, ? super com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemShowImageClick, @NotNull Function2<? super View, ? super com.tencent.mobileqq.troop.teamup.member.data.c, Unit> itemSelectClick, @NotNull Function0<Unit> itemReloadDataClick) {
        Intrinsics.checkNotNullParameter(itemTeamUpTypeClick, "itemTeamUpTypeClick");
        Intrinsics.checkNotNullParameter(itemInviteTroopClick, "itemInviteTroopClick");
        Intrinsics.checkNotNullParameter(itemShowImageClick, "itemShowImageClick");
        Intrinsics.checkNotNullParameter(itemSelectClick, "itemSelectClick");
        Intrinsics.checkNotNullParameter(itemReloadDataClick, "itemReloadDataClick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemTeamUpTypeClick, itemInviteTroopClick, itemShowImageClick, itemSelectClick, itemReloadDataClick);
            return;
        }
        this.itemTeamUpTypeClick = itemTeamUpTypeClick;
        this.itemInviteTroopClick = itemInviteTroopClick;
        this.itemShowImageClick = itemShowImageClick;
        this.itemSelectClick = itemSelectClick;
        this.itemReloadDataClick = itemReloadDataClick;
    }

    @NotNull
    public final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.itemInviteTroopClick;
    }

    @NotNull
    public final Function0<Unit> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Function0) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.itemReloadDataClick;
    }

    @NotNull
    public final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function2) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.itemSelectClick;
    }

    @NotNull
    public final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemShowImageClick;
    }

    @NotNull
    public final Function2<View, com.tencent.mobileqq.troop.teamup.member.data.e, Unit> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function2) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemTeamUpTypeClick;
    }
}
