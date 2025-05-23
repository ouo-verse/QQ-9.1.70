package com.tencent.mobileqq.qqlive.sail.ui.more;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.util.SingleLiveEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.sso.request.QQLiveGetBottomConfigRequest;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$BottomItem;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$GetBottomConfigRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lk4.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R1\u0010\"\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u001d*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c0\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070#0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0019R#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070#0\u001b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/MorePanelViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomId", "", "hasManageBtn", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "Lkotlin/collections/ArrayList;", "P1", "Lcom/tencent/trpcprotocol/qlive/trpc_room_global_config/trpc_room_global_config/trpcRoomGlobalConfig$BottomItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Z1", "show", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "roomType", "S1", "anchorUid", "selfUid", "T1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/trpcprotocol/qlive/trpc_room_global_config/trpc_room_global_config/trpcRoomGlobalConfig$GetBottomConfigRsp;", "i", "Landroidx/lifecycle/MutableLiveData;", "_dynamicBtnLiveData", "Landroidx/lifecycle/LiveData;", "", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "dynamicBtnLiveData", "", BdhLogUtil.LogTag.Tag_Conn, "_localBtnLiveData", "D", "W1", "localBtnLiveData", "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", "E", "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", "_showMorePanel", UserInfo.SEX_FEMALE, "X1", "showMorePanel", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MorePanelViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<h>> _localBtnLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<h>> localBtnLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SingleLiveEvent<Boolean> _showMorePanel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showMorePanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<trpcRoomGlobalConfig$GetBottomConfigRsp> _dynamicBtnLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<h>> dynamicBtnLiveData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/MorePanelViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.MorePanelViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/MorePanelViewModel$b", "Llk4/c$b;", "", "isAdmin", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements c.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f272841b;

        b(long j3) {
            this.f272841b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MorePanelViewModel.this, Long.valueOf(j3));
            }
        }

        @Override // lk4.c.b
        public void a(boolean isAdmin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isAdmin);
            } else if (isAdmin) {
                MorePanelViewModel.this._localBtnLiveData.postValue(MorePanelViewModel.this.P1(this.f272841b, true));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MorePanelViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<trpcRoomGlobalConfig$GetBottomConfigRsp> mutableLiveData = new MutableLiveData<>();
        this._dynamicBtnLiveData = mutableLiveData;
        LiveData<List<h>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.i
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List R1;
                R1 = MorePanelViewModel.R1(MorePanelViewModel.this, (trpcRoomGlobalConfig$GetBottomConfigRsp) obj);
                return R1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(_dynamicBtnLiveData)\u2026     }\n        btns\n    }");
        this.dynamicBtnLiveData = map;
        MutableLiveData<List<h>> mutableLiveData2 = new MutableLiveData<>();
        this._localBtnLiveData = mutableLiveData2;
        this.localBtnLiveData = mutableLiveData2;
        SingleLiveEvent<Boolean> singleLiveEvent = new SingleLiveEvent<>();
        this._showMorePanel = singleLiveEvent;
        this.showMorePanel = singleLiveEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<h> P1(long roomId, boolean hasManageBtn) {
        ArrayList<h> arrayList = new ArrayList<>();
        if (!BusConfigHelper.f378723a.f(16, roomId)) {
            arrayList.add(new h(R.string.zfu, R.drawable.nls, null, null, null, 0.0f, false, 124, null));
        }
        if (ht3.a.e("qqlive_task_show_hd_button", true)) {
            arrayList.add(new h(R.string.zfp, R.drawable.o6v, null, null, null, 0.0f, false, 124, null));
        }
        arrayList.add(new h(R.string.zfo, R.drawable.nlp, null, null, null, 0.0f, false, 124, null));
        arrayList.add(new h(R.string.zfr, R.drawable.o98, null, null, null, 0.0f, false, 124, null));
        if (ht3.a.e("qqlive_clear_screen_enable", true)) {
            arrayList.add(new h(R.string.zfm, R.drawable.o6t, null, null, null, 0.0f, false, 124, null));
        }
        arrayList.add(new h(R.string.zfl, R.drawable.o6w, null, null, null, 0.0f, false, 124, null));
        if (ht3.a.e("qqlive_audience_setting_enable", true)) {
            arrayList.add(new h(R.string.zft, R.drawable.o6u, null, null, null, 0.0f, false, 124, null));
        }
        if (hasManageBtn) {
            arrayList.add(new h(R.string.zfq, R.drawable.nly, null, null, null, 0.0f, false, 124, null));
        }
        return arrayList;
    }

    static /* synthetic */ ArrayList Q1(MorePanelViewModel morePanelViewModel, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return morePanelViewModel.P1(j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List R1(MorePanelViewModel this$0, trpcRoomGlobalConfig$GetBottomConfigRsp trpcroomglobalconfig_getbottomconfigrsp) {
        trpcRoomGlobalConfig$BottomItem trpcroomglobalconfig_bottomitem;
        trpcRoomGlobalConfig$BottomItem trpcroomglobalconfig_bottomitem2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        if (trpcroomglobalconfig_getbottomconfigrsp != null && (trpcroomglobalconfig_bottomitem = trpcroomglobalconfig_getbottomconfigrsp.outer_item) != null && (trpcroomglobalconfig_bottomitem2 = trpcroomglobalconfig_bottomitem.get()) != null) {
            if (this$0.Z1(trpcroomglobalconfig_bottomitem2)) {
                String str = trpcroomglobalconfig_bottomitem2.text.get();
                Intrinsics.checkNotNullExpressionValue(str, "item.text.get()");
                String str2 = trpcroomglobalconfig_bottomitem2.icon.get();
                Intrinsics.checkNotNullExpressionValue(str2, "item.icon.get()");
                String str3 = trpcroomglobalconfig_bottomitem2.url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "item.url.get()");
                arrayList.add(new h(0, 0, str, str2, str3, trpcroomglobalconfig_bottomitem2.height.get(), trpcroomglobalconfig_bottomitem2.showRedPoint.get()));
            } else {
                AegisLogger.INSTANCE.w("Audience|MorePanelViewModel", "dynamicBtnChanged", "invalid btn, " + trpcroomglobalconfig_bottomitem2.text.get() + ", " + trpcroomglobalconfig_bottomitem2.icon.get() + ", " + trpcroomglobalconfig_bottomitem2.url.get());
            }
        }
        return arrayList;
    }

    private final boolean Z1(trpcRoomGlobalConfig$BottomItem item) {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        String str = item.text.get();
        Intrinsics.checkNotNullExpressionValue(str, "item.text.get()");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            String str2 = item.icon.get();
            Intrinsics.checkNotNullExpressionValue(str2, "item.icon.get()");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                String str3 = item.url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "item.url.get()");
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                if (!isBlank3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void S1(final long roomId, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(roomId), Integer.valueOf(roomType));
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetBottomConfigRequest(roomId, roomType), new Function1<QQLiveResponse<trpcRoomGlobalConfig$GetBottomConfigRsp>, Unit>(roomId, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.MorePanelViewModel$fetchDynamicBtn$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $roomId;
                final /* synthetic */ MorePanelViewModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$roomId = roomId;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(roomId), this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<trpcRoomGlobalConfig$GetBottomConfigRsp> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<trpcRoomGlobalConfig$GetBottomConfigRsp> response) {
                    MutableLiveData mutableLiveData;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    trpcRoomGlobalConfig$GetBottomConfigRsp rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        int i3 = rsp.retcode.get();
                        if (i3 == 0) {
                            mutableLiveData = this.this$0._dynamicBtnLiveData;
                            mutableLiveData.postValue(rsp);
                            return;
                        }
                        AegisLogger.INSTANCE.w("Audience|MorePanelViewModel", "fetchPanelBtnConfig", "roomId=" + this.$roomId + ", failed, retcode=" + i3);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|MorePanelViewModel", "fetchPanelBtnConfig", "roomId=" + this.$roomId + ", failed, response=" + response);
                }
            });
        }
    }

    public final void T1(long roomId, long anchorUid, long selfUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(roomId), Long.valueOf(anchorUid), Long.valueOf(selfUid));
        } else {
            this._localBtnLiveData.postValue(Q1(this, roomId, false, 2, null));
            lk4.c.f414972a.l(true, anchorUid, selfUid, roomId, new b(roomId));
        }
    }

    @NotNull
    public final LiveData<List<h>> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dynamicBtnLiveData;
    }

    @NotNull
    public final LiveData<List<h>> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.localBtnLiveData;
    }

    @NotNull
    public final LiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showMorePanel;
    }

    public final void a2(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, show);
        } else {
            this._showMorePanel.postValue(Boolean.valueOf(show));
        }
    }
}
