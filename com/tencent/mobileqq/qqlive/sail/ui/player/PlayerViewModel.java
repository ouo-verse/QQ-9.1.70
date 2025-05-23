package com.tencent.mobileqq.qqlive.sail.ui.player;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.qqlive.sail.sso.request.GetHuYaRoomPlayRequest;
import com.tencent.mobileqq.qqlive.sail.sso.request.GetRoomPlayRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.ae;
import rt3.k;
import rt3.m;
import rt3.q;
import rt3.u;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002?@B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\rJ\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u000fH\u0016R\u0014\u0010&\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010+R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002030-8\u0006\u00a2\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b7\u00101R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Lrt3/q;", "roomInfo", "", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "O1", "Lbr4/c;", "playInfo", "P1", "", "errorCode", "", "R1", "", "T1", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "S1", "onCleared", "Q1", "X1", "", "roomId", "isHuyaRoom", "b2", "", "apn", "onNetNone2Mobile", "onNetWifi2Mobile", TPDownloadProxyEnum.USER_SSID, "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "i", "I", "maxRetryTimes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "retryTimes", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_urlChangedLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "urlChangedLiveData", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel$NetworkChangeType;", "E", "_networkChangeLiveData", UserInfo.SEX_FEMALE, "U1", "networkChangeLiveData", "G", "Z", "hasRegisteredConnectionChangeReceiver", "<init>", "()V", "H", "a", "NetworkChangeType", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayerViewModel extends com.tencent.mobileqq.qqlive.sail.base.d implements INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.qqlive.sail.model.audience.a>> _urlChangedLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.qqlive.sail.model.audience.a>> urlChangedLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<NetworkChangeType> _networkChangeLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<NetworkChangeType> networkChangeLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile boolean hasRegisteredConnectionChangeReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int maxRetryTimes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int retryTimes;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel$NetworkChangeType;", "", "(Ljava/lang/String;I)V", Global.TRACKING_WIFI, "MOBILE", "NONE", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class NetworkChangeType {
        private static final /* synthetic */ NetworkChangeType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final NetworkChangeType MOBILE;
        public static final NetworkChangeType NONE;
        public static final NetworkChangeType WIFI;

        private static final /* synthetic */ NetworkChangeType[] $values() {
            return new NetworkChangeType[]{WIFI, MOBILE, NONE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52675);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            WIFI = new NetworkChangeType(Global.TRACKING_WIFI, 0);
            MOBILE = new NetworkChangeType("MOBILE", 1);
            NONE = new NetworkChangeType("NONE", 2);
            $VALUES = $values();
        }

        NetworkChangeType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static NetworkChangeType valueOf(String str) {
            return (NetworkChangeType) Enum.valueOf(NetworkChangeType.class, str);
        }

        public static NetworkChangeType[] values() {
            return (NetworkChangeType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/PlayerViewModel$a;", "", "", "DEFAULT_RETRY_TIMES", "I", "", "ERROR_CHANGE_URL_CODES_DEFAULT", "Ljava/lang/String;", "MMKV_KEY_CAN_PLAY_IN_MOBILE_NETWORK", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.player.PlayerViewModel$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52684);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayerViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maxRetryTimes = ht3.a.b("qqlive_player_change_url_api_retry_times", 1);
        MutableLiveData<List<com.tencent.mobileqq.qqlive.sail.model.audience.a>> mutableLiveData = new MutableLiveData<>();
        this._urlChangedLiveData = mutableLiveData;
        this.urlChangedLiveData = mutableLiveData;
        MutableLiveData<NetworkChangeType> mutableLiveData2 = new MutableLiveData<>();
        this._networkChangeLiveData = mutableLiveData2;
        this.networkChangeLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.qqlive.sail.model.audience.a> O1(q roomInfo) {
        rt3.j[] jVarArr;
        Object firstOrNull;
        Object orNull;
        List<com.tencent.mobileqq.qqlive.sail.model.audience.a> emptyList;
        if (roomInfo != null) {
            jVarArr = roomInfo.f432349m;
        } else {
            jVarArr = null;
        }
        if (jVarArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        ae aeVar = new ae();
        aeVar.f432243c = 0;
        ArrayList arrayList2 = new ArrayList();
        rt3.j[] jVarArr2 = roomInfo.f432349m;
        Intrinsics.checkNotNullExpressionValue(jVarArr2, "roomInfo.flvMulti");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(jVarArr2);
        rt3.j jVar = (rt3.j) firstOrNull;
        if (jVar != null) {
            u[] uVarArr = jVar.f432315c;
            Intrinsics.checkNotNullExpressionValue(uVarArr, "flv.lineDetail");
            for (u uVar : uVarArr) {
                k kVar = new k();
                kVar.f432319c = uVar.f432358a;
                kVar.f432317a = QQLiveHuYa.f271333a.h(uVar.f432359b);
                rt3.b bVar = new rt3.b();
                bVar.f432263a = uVar.f432360c;
                bVar.f432264b = uVar.f432359b;
                bVar.f432265c = "flv";
                kVar.f432318b = new rt3.b[]{bVar};
                arrayList2.add(kVar);
            }
        }
        Object[] array = arrayList2.toArray(new k[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        k[] kVarArr = (k[]) array;
        aeVar.f432241a = kVarArr;
        if (kVarArr != null) {
            for (k kVar2 : kVarArr) {
                String name = kVar2.f432319c;
                int i3 = kVar2.f432317a;
                rt3.b[] bVarArr = kVar2.f432318b;
                Intrinsics.checkNotNullExpressionValue(bVarArr, "frame.addresses");
                orNull = ArraysKt___ArraysKt.getOrNull(bVarArr, 0);
                rt3.b bVar2 = (rt3.b) orNull;
                if (bVar2 != null) {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    StreamDefinition a16 = StreamDefinition.INSTANCE.a(i3);
                    int i16 = bVar2.f432264b;
                    String str = bVar2.f432263a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.url");
                    StreamFormat.Companion companion = StreamFormat.INSTANCE;
                    String str2 = bVar2.f432265c;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.format");
                    arrayList.add(new com.tencent.mobileqq.qqlive.sail.model.audience.a(name, a16, i16, str, companion.a(str2), null, 32, null));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.qqlive.sail.model.audience.a> P1(br4.c playInfo) {
        List<com.tencent.mobileqq.qqlive.sail.model.audience.a> emptyList;
        List<com.tencent.mobileqq.qqlive.sail.model.audience.a> listOf;
        if (playInfo == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        StreamDefinition streamDefinition = StreamDefinition.SD;
        String str = playInfo.f29023c;
        Intrinsics.checkNotNullExpressionValue(str, "it.flv360P");
        StreamFormat streamFormat = StreamFormat.FLV;
        com.tencent.mobileqq.qqlive.sail.model.audience.a aVar = new com.tencent.mobileqq.qqlive.sail.model.audience.a("", streamDefinition, 0, str, streamFormat, null, 32, null);
        StreamDefinition streamDefinition2 = StreamDefinition.HD;
        String str2 = playInfo.f29024d;
        Intrinsics.checkNotNullExpressionValue(str2, "it.flv540P");
        com.tencent.mobileqq.qqlive.sail.model.audience.a aVar2 = new com.tencent.mobileqq.qqlive.sail.model.audience.a("", streamDefinition2, 0, str2, streamFormat, null, 32, null);
        StreamDefinition streamDefinition3 = StreamDefinition.SHD;
        String str3 = playInfo.f29025e;
        Intrinsics.checkNotNullExpressionValue(str3, "it.flv720P");
        com.tencent.mobileqq.qqlive.sail.model.audience.a aVar3 = new com.tencent.mobileqq.qqlive.sail.model.audience.a("", streamDefinition3, 0, str3, streamFormat, null, 32, null);
        StreamDefinition streamDefinition4 = StreamDefinition.FHD;
        String str4 = playInfo.f29026f;
        Intrinsics.checkNotNullExpressionValue(str4, "it.flv1080P");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.qqlive.sail.model.audience.a[]{aVar, aVar2, aVar3, new com.tencent.mobileqq.qqlive.sail.model.audience.a("", streamDefinition4, 0, str4, streamFormat, null, 32, null)});
        return listOf;
    }

    private final boolean R1(int errorCode) {
        List split$default;
        String d16 = ht3.a.d("qqlive_player_auth_failed_code_list", "14020003,403,11030102,11030402");
        if (!Intrinsics.areEqual(d16, "none")) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{","}, false, 0, 6, (Object) null);
            return split$default.contains(String.valueOf(errorCode));
        }
        return false;
    }

    private final void T1() {
        if (this.hasRegisteredConnectionChangeReceiver) {
            AppNetConnInfo.unregisterNetInfoHandler(this);
            this.hasRegisteredConnectionChangeReceiver = false;
        }
    }

    public final boolean Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ct3.a.e("can_play_in_mobile_network", false);
    }

    public final void S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int connInfo = AppNetConnInfo.getConnInfo();
        if (connInfo != -1) {
            if (connInfo != 0) {
                this._networkChangeLiveData.postValue(NetworkChangeType.WIFI);
                return;
            } else {
                this._networkChangeLiveData.postValue(NetworkChangeType.MOBILE);
                return;
            }
        }
        this._networkChangeLiveData.postValue(NetworkChangeType.NONE);
    }

    @NotNull
    public final LiveData<NetworkChangeType> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.networkChangeLiveData;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.qqlive.sail.model.audience.a>> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.urlChangedLiveData;
    }

    public final void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ct3.a.o("can_play_in_mobile_network", true);
        }
    }

    public final void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.hasRegisteredConnectionChangeReceiver = true;
            AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, this);
        }
    }

    public final void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            T1();
        }
    }

    public final boolean b2(final long roomId, int errorCode, boolean isHuyaRoom) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Long.valueOf(roomId), Integer.valueOf(errorCode), Boolean.valueOf(isHuyaRoom))).booleanValue();
        }
        AegisLogger.INSTANCE.i("Audience|PlayerViewModel", "changeUrl", "roomId=" + roomId + ", errorCode=" + errorCode + ", retryTimes=" + this.retryTimes);
        if (!R1(errorCode) || (i3 = this.retryTimes) >= this.maxRetryTimes) {
            return false;
        }
        this.retryTimes = i3 + 1;
        long[] jArr = {roomId};
        if (isHuyaRoom) {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetHuYaRoomPlayRequest(roomId), new Function1<QQLiveResponse<m>, Unit>(roomId, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.PlayerViewModel$tryChangeUrl$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $roomId;
                final /* synthetic */ PlayerViewModel this$0;

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
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<m> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<m> response) {
                    MutableLiveData mutableLiveData;
                    List emptyList;
                    MutableLiveData mutableLiveData2;
                    List O1;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isFailed() && response.getRsp() != null) {
                        mutableLiveData2 = this.this$0._urlChangedLiveData;
                        PlayerViewModel playerViewModel = this.this$0;
                        m rsp = response.getRsp();
                        O1 = playerViewModel.O1(rsp != null ? rsp.f432326a : null);
                        mutableLiveData2.postValue(O1);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|PlayerViewModel", "change huya Url", "roomId=" + this.$roomId + ", response=" + response);
                    mutableLiveData = this.this$0._urlChangedLiveData;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    mutableLiveData.postValue(emptyList);
                }
            });
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetRoomPlayRequest(jArr, 0), new Function1<QQLiveResponse<br4.b>, Unit>(roomId, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.player.PlayerViewModel$tryChangeUrl$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $roomId;
                final /* synthetic */ PlayerViewModel this$0;

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
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<br4.b> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<br4.b> response) {
                    MutableLiveData mutableLiveData;
                    List emptyList;
                    MutableLiveData mutableLiveData2;
                    List P1;
                    br4.d[] dVarArr;
                    br4.d dVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isFailed() && response.getRsp() != null) {
                        br4.b rsp = response.getRsp();
                        br4.c cVar = null;
                        if (rsp != null && (dVarArr = rsp.f29020a) != null) {
                            long j3 = this.$roomId;
                            int length = dVarArr.length;
                            int i16 = 0;
                            while (true) {
                                if (i16 >= length) {
                                    dVar = null;
                                    break;
                                }
                                dVar = dVarArr[i16];
                                if (dVar.f29028a == j3) {
                                    break;
                                } else {
                                    i16++;
                                }
                            }
                            if (dVar != null) {
                                cVar = dVar.f29029b;
                            }
                        }
                        mutableLiveData2 = this.this$0._urlChangedLiveData;
                        P1 = this.this$0.P1(cVar);
                        mutableLiveData2.postValue(P1);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|PlayerViewModel", "changeUrl", "roomId=" + this.$roomId + ", response=" + response);
                    mutableLiveData = this.this$0._urlChangedLiveData;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    mutableLiveData.postValue(emptyList);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onCleared();
            T1();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.NONE);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(@Nullable String ssid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) ssid);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.WIFI);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(@Nullable String apn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) apn);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.MOBILE);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(@Nullable String ssid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) ssid);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.WIFI);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(@Nullable String apn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) apn);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.MOBILE);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this._networkChangeLiveData.postValue(NetworkChangeType.NONE);
        }
    }
}
