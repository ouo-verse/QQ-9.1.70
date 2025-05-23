package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopMetaDreamGameInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/TroopInfoCardGameViewModel;", "Landroidx/lifecycle/ViewModel;", "", "troopUin", "", "R1", "S1", "<set-?>", "i", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopGameInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_troopGameInfo", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopMetaDreamGameInfo;", BdhLogUtil.LogTag.Tag_Conn, "_troopMetaDreamGameInfo", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "troopGameInfo", "E", "P1", "troopMetaDreamGameInfo", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "repo", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardGameViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopMetaDreamGameInfo> _troopMetaDreamGameInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TroopGameInfo> troopGameInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TroopMetaDreamGameInfo> troopMetaDreamGameInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TroopCardRepo repo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopGameInfo> _troopGameInfo;

    public TroopInfoCardGameViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        MutableLiveData<TroopGameInfo> mutableLiveData = new MutableLiveData<>();
        this._troopGameInfo = mutableLiveData;
        MutableLiveData<TroopMetaDreamGameInfo> mutableLiveData2 = new MutableLiveData<>();
        this._troopMetaDreamGameInfo = mutableLiveData2;
        this.troopGameInfo = mutableLiveData;
        this.troopMetaDreamGameInfo = mutableLiveData2;
        this.repo = new TroopCardRepo();
    }

    @NotNull
    public final LiveData<TroopGameInfo> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopGameInfo;
    }

    @NotNull
    public final LiveData<TroopMetaDreamGameInfo> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopMetaDreamGameInfo;
    }

    @NotNull
    public final String Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void R1(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.troopUin = troopUin;
        }
    }

    public final void S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopInfoCardGameViewModel$requestTroopGameInfo$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
