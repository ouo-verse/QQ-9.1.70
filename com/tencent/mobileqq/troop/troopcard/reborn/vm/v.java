package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupMedalListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupMedalListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupMedalListCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00168\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/v;", "Landroidx/lifecycle/ViewModel;", "", "troopUin", "", "R1", "N1", "i", "Ljava/lang/String;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListRsp;", "P1", "()Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListRsp;", "setMedalListRsp", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListRsp;)V", "medalListRsp", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_canShowMedalLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "canShowMedalLiveData", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMedalInfo;", "E", "_troopMedalListLiveData", UserInfo.SEX_FEMALE, "Q1", "troopMedalListLiveData", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class v extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _canShowMedalLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> canShowMedalLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GroupMedalInfo>> _troopMedalListLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<GroupMedalInfo>> troopMedalListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GetGroupMedalListRsp medalListRsp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/v$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.v$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.medalListRsp = new GetGroupMedalListRsp();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._canShowMedalLiveData = mutableLiveData;
        this.canShowMedalLiveData = mutableLiveData;
        MutableLiveData<List<GroupMedalInfo>> mutableLiveData2 = new MutableLiveData<>();
        this._troopMedalListLiveData = mutableLiveData2;
        this.troopMedalListLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(v this$0, int i3, String errMsg, GetGroupMedalListRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        QLog.i("TroopInfoCardMedalViewModel", 1, "[getMedalList] errCode = " + i3 + " errMsg = " + errMsg + " isShowMedal = " + rsp.isShowMedal + " size = " + rsp.medalInfoArray.size());
        this$0.medalListRsp = rsp;
        this$0._canShowMedalLiveData.postValue(Boolean.valueOf(rsp.isShowMedal));
        if (rsp.isShowMedal) {
            this$0._troopMedalListLiveData.postValue(rsp.medalInfoArray);
        }
    }

    @NotNull
    public final LiveData<Boolean> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.canShowMedalLiveData;
    }

    public final void N1() {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        GetGroupMedalListReq getGroupMedalListReq = new GetGroupMedalListReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            getGroupMedalListReq.groupCode = longOrNull.longValue();
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
            if (c16 != null) {
                c16.getGroupMedalList(getGroupMedalListReq, new IGetGroupMedalListCallback() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.u
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupMedalListCallback
                    public final void onResult(int i3, String str, GetGroupMedalListRsp getGroupMedalListRsp) {
                        v.O1(v.this, i3, str, getGroupMedalListRsp);
                    }
                });
            }
        }
    }

    @NotNull
    public final GetGroupMedalListRsp P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GetGroupMedalListRsp) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.medalListRsp;
    }

    @NotNull
    public final LiveData<List<GroupMedalInfo>> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.troopMedalListLiveData;
    }

    public final void R1(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.troopUin = troopUin;
        }
    }
}
