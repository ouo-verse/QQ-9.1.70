package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0002\"#B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel;", "Landroidx/lifecycle/ViewModel;", "", "troopUin", "", "T1", "R1", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "i", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "repo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "cookie", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/a;", "D", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b;", "E", "Landroidx/lifecycle/MutableLiveData;", "_state", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "state", "<init>", "()V", "G", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEssenceMsgViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String cookie;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> itemList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _state;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> state;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopCardRepo repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopEssenceMsgViewModel$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b$b;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f299822a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57368);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f299822a = new a();
                }
            }

            a() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b$b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel$b;", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "", "b", "Z", "c", "()Z", "isEnd", "", "Ljava/lang/String;", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopEssenceMsgViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8797b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final List<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> itemList;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final boolean isEnd;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String jumpUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8797b(@NotNull List<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> itemList, boolean z16, @NotNull String jumpUrl) {
                super(null);
                Intrinsics.checkNotNullParameter(itemList, "itemList");
                Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, itemList, Boolean.valueOf(z16), jumpUrl);
                    return;
                }
                this.itemList = itemList;
                this.isEnd = z16;
                this.jumpUrl = jumpUrl;
            }

            @NotNull
            public final List<com.tencent.mobileqq.troop.troopcard.reborn.essence.message.a> a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (List) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.itemList;
            }

            @NotNull
            public final String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.jumpUrl;
            }

            public final boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return this.isEnd;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopEssenceMsgViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.repo = new TroopCardRepo();
        this.troopUin = "";
        this.cookie = "";
        this.itemList = new ArrayList();
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._state = mutableLiveData;
        this.state = mutableLiveData;
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d("TroopEssenceMsgViewModel", 1, "fetchEssenceMsgList");
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopEssenceMsgViewModel$fetchEssenceMsgList$1(this, null), 3, null);
        }
    }

    @NotNull
    public final LiveData<b> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.state;
    }

    public final void T1(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.troopUin = troopUin;
        }
    }
}
