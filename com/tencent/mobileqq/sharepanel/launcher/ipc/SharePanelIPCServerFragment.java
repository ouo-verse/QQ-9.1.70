package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.launcher.ShareActionDynamicModifier;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.launcher.ipc.a;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020;068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00109R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Oh", "Lh", "Mh", "Hh", "Nh", "Jh", "Kh", "Ih", "showSharePanel", "", "action", "Landroid/os/Bundle;", "params", "Ah", "Ch", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "modifier", "Eh", "", "callbackId", "", "success", "Landroid/content/Intent;", "intent", "Ph", "Rh", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "clientProcess", "D", "I", "clientSeq", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "E", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/a;", "ipcParam", "", "Lcom/tencent/mobileqq/sharepanel/m;", "G", "Ljava/util/Map;", "prepareForwardCallbackMap", "Lcom/tencent/mobileqq/sharepanel/o;", "H", "shareConfirmCallbackMap", "Lcom/tencent/mobileqq/sharepanel/launcher/a;", "Lkotlin/Lazy;", "Gh", "()Lcom/tencent/mobileqq/sharepanel/launcher/a;", "sharePanelLaunch", "<init>", "()V", "J", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelIPCServerFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String clientProcess;

    /* renamed from: D, reason: from kotlin metadata */
    private int clientSeq;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private SharePanelParam sharePanelParam;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a ipcParam;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, com.tencent.mobileqq.sharepanel.m> prepareForwardCallbackMap;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, com.tencent.mobileqq.sharepanel.o> shareConfirmCallbackMap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy sharePanelLaunch;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.ipc.SharePanelIPCServerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$b", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.n {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull com.tencent.mobileqq.sharepanel.m callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetList, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int hashCode = callback.hashCode();
            SharePanelIPCServerFragment.this.prepareForwardCallbackMap.put(Integer.valueOf(hashCode), callback);
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putInt("callbackId", hashCode);
            bundle.putParcelableArrayList("selectedTarget", targetList);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("prepareForward", bundle);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$c", "Lcom/tencent/mobileqq/sharepanel/b;", "", "success", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.b
        public void a(boolean success, @NotNull List<? extends ResultRecord> targetList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(success), targetList);
                return;
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putBoolean("success", success);
            if (targetList instanceof ArrayList) {
                bundle.putParcelableArrayList("selectedTarget", (ArrayList) targetList);
            }
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onForwardResult", bundle);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$d", "Lcom/tencent/mobileqq/sharepanel/d;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "leaveMsg", "", "J", "l", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.d
        public boolean J(@NotNull List<? extends ResultRecord> targetList, @NotNull String leaveMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetList, (Object) leaveMsg)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
            boolean z16 = false;
            try {
                a aVar = SharePanelIPCServerFragment.this.ipcParam;
                if (aVar != null) {
                    if (!aVar.J(targetList, leaveMsg)) {
                        z16 = true;
                    }
                }
                return !z16;
            } catch (Exception e16) {
                QLog.e("SharePanelIPCServerFragment", 1, "interceptSend error: ", e16);
                return false;
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.d
        public boolean l(@NotNull List<? extends ResultRecord> targetList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) targetList)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            boolean z16 = false;
            try {
                a aVar = SharePanelIPCServerFragment.this.ipcParam;
                if (aVar != null) {
                    if (!aVar.l(targetList)) {
                        z16 = true;
                    }
                }
                return !z16;
            } catch (Exception e16) {
                QLog.e("SharePanelIPCServerFragment", 1, "interceptMoreFriend error: ", e16);
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$e", "Lcom/tencent/mobileqq/sharepanel/e;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "contact", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements com.tencent.mobileqq.sharepanel.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.e
        public boolean a(@NotNull ResultRecord contact) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(contact, "contact");
            try {
                a aVar = SharePanelIPCServerFragment.this.ipcParam;
                boolean z16 = false;
                if (aVar != null) {
                    if (!aVar.D4(contact)) {
                        z16 = true;
                    }
                }
                return !z16;
            } catch (Exception e16) {
                QLog.e("SharePanelIPCServerFragment", 1, "filterRecentContact error: ", e16);
                return true;
            }
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$f", "Lcom/tencent/mobileqq/sharepanel/channel/a;", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "", "channelId", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "selectedTargets", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements com.tencent.mobileqq.sharepanel.channel.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.channel.a
        public void a(@NotNull SharePanelParam sharePanelParam, @NotNull String channelId, @Nullable SharePanelContactItem contact, @Nullable ArrayList<ResultRecord> selectedTargets) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, sharePanelParam, channelId, contact, selectedTargets);
                return;
            }
            Intrinsics.checkNotNullParameter(sharePanelParam, "sharePanelParam");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("channelId", channelId);
            bundle.putBoolean("supportMulti", sharePanelParam.z());
            if (sharePanelParam.f() != null) {
                bundle.putParcelable("forwardIntent", sharePanelParam.f());
            }
            if (contact != null) {
                bundle.putParcelable("contact", contact);
            }
            if (selectedTargets != null && !selectedTargets.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                bundle.putParcelableArrayList("selectedTarget", selectedTargets);
            }
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onShareChannelHandle", bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$g", "Lcom/tencent/mobileqq/sharepanel/p;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g implements com.tencent.mobileqq.sharepanel.p {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.p
        public void a(@NotNull ShareConfirmAction action, @NotNull com.tencent.mobileqq.sharepanel.o callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, (Object) callback);
                return;
            }
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int hashCode = callback.hashCode();
            SharePanelIPCServerFragment.this.shareConfirmCallbackMap.put(Integer.valueOf(hashCode), callback);
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putInt("callbackId", hashCode);
            bundle.putParcelable("shareConfirmAction", action);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("shareConfirm", bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$h", "Lcom/tencent/mobileqq/sharepanel/l;", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class h implements com.tencent.mobileqq.sharepanel.l {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.l
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SharePanelIPCServerFragment.this.Ah("onShow", new Bundle());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$i", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class i implements com.tencent.mobileqq.sharepanel.k {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SharePanelIPCServerFragment.this.Ah("onDismiss", new Bundle());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$j", "Lcom/tencent/mobileqq/sharepanel/i;", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class j implements com.tencent.mobileqq.sharepanel.i {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.i
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SharePanelIPCServerFragment.this.Ah("onCancel", new Bundle());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$k", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class k implements com.tencent.mobileqq.sharepanel.j {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
                return;
            }
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("channelId", channelId);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onShareChannelClick", bundle);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionId);
                return;
            }
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("actionId", actionId);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onAppendActionClick", bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCServerFragment$l", "Lcom/tencent/mobileqq/sharepanel/h;", "", "channelId", "", "b", "actionId", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class l implements com.tencent.mobileqq.sharepanel.h {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelIPCServerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.h
        public void a(@NotNull String actionId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionId);
                return;
            }
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("actionId", actionId);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onDisabledAppendActionClick", bundle);
        }

        @Override // com.tencent.mobileqq.sharepanel.h
        public void b(@NotNull String channelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
                return;
            }
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            SharePanelIPCServerFragment sharePanelIPCServerFragment = SharePanelIPCServerFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("channelId", channelId);
            Unit unit = Unit.INSTANCE;
            sharePanelIPCServerFragment.Ah("onDisabledShareChannelClick", bundle);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SharePanelIPCServerFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.clientProcess = "";
        this.prepareForwardCallbackMap = new LinkedHashMap();
        this.shareConfirmCallbackMap = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(SharePanelIPCServerFragment$sharePanelLaunch$2.INSTANCE);
        this.sharePanelLaunch = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(final String action, final Bundle params) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.n
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCServerFragment.Bh(action, this, params);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(String action, SharePanelIPCServerFragment this$0, Bundle params) {
        boolean z16;
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.i("SharePanelIPCServerFragment", 1, "callClient action: " + action + " clientSeq: " + this$0.clientSeq + " clientProcess: " + this$0.clientProcess);
        if (this$0.clientSeq > 0) {
            if (this$0.clientProcess.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    params.putInt("seq", this$0.clientSeq);
                    QIPCServerHelper.getInstance().callClient(this$0.clientProcess, "SharePanelIPCClient", action, params);
                } catch (Exception e16) {
                    QLog.e("SharePanelIPCServerFragment", 1, "callClient: ", e16);
                }
            }
        }
    }

    private final void Ch() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.p
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCServerFragment.Dh(SharePanelIPCServerFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(SharePanelIPCServerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh().dismiss();
    }

    private final void Eh(final ShareActionDynamicModifier modifier) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.o
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCServerFragment.Fh(SharePanelIPCServerFragment.this, modifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(SharePanelIPCServerFragment this$0, ShareActionDynamicModifier modifier) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(modifier, "$modifier");
        this$0.Gh().b(modifier);
    }

    private final com.tencent.mobileqq.sharepanel.launcher.a Gh() {
        return (com.tencent.mobileqq.sharepanel.launcher.a) this.sharePanelLaunch.getValue();
    }

    private final void Hh() {
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam == null) {
            return;
        }
        sharePanelParam.d0(new b());
        sharePanelParam.M(new c());
    }

    private final void Ih() {
        SharePanelParam sharePanelParam;
        try {
            a aVar = this.ipcParam;
            boolean z16 = false;
            if (aVar != null && aVar.i0()) {
                z16 = true;
            }
            if (z16 && (sharePanelParam = this.sharePanelParam) != null) {
                sharePanelParam.G(new d());
            }
        } catch (Exception e16) {
            QLog.e("SharePanelIPCServerFragment", 1, "mergeForwardInterceptorIPCParam error: ", e16);
        }
    }

    private final void Jh() {
        Bitmap bitmap;
        SharePanelParam sharePanelParam;
        try {
            a aVar = this.ipcParam;
            if (aVar != null) {
                bitmap = aVar.y2();
            } else {
                bitmap = null;
            }
            if (bitmap != null && (sharePanelParam = this.sharePanelParam) != null) {
                sharePanelParam.e0(bitmap);
            }
        } catch (Exception e16) {
            QLog.e("SharePanelIPCServerFragment", 1, "mergePreviewImageIPCParam error: ", e16);
        }
    }

    private final void Kh() {
        SharePanelParam sharePanelParam;
        try {
            a aVar = this.ipcParam;
            boolean z16 = false;
            if (aVar != null && aVar.G0()) {
                z16 = true;
            }
            if (z16 && (sharePanelParam = this.sharePanelParam) != null) {
                sharePanelParam.f0(new e());
            }
        } catch (Exception e16) {
            QLog.e("SharePanelIPCServerFragment", 1, "mergeRecentContactFilterIPCParam error: ", e16);
        }
    }

    private final void Lh() {
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam == null) {
            return;
        }
        sharePanelParam.j0(new f());
    }

    private final void Mh() {
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam == null) {
            return;
        }
        sharePanelParam.l0(new g());
    }

    private final void Nh() {
        IBinder iBinder;
        Bundle arguments = getArguments();
        if (arguments != null) {
            iBinder = arguments.getBinder("binderParam");
        } else {
            iBinder = null;
        }
        if (iBinder != null) {
            try {
                this.ipcParam = a.AbstractBinderC8586a.j(iBinder);
            } catch (Exception e16) {
                QLog.e("SharePanelIPCServerFragment", 1, "mergeSharePanelIPCParam error: ", e16);
            }
        }
        Jh();
        Kh();
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh() {
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam == null) {
            return;
        }
        sharePanelParam.c0(new h());
        sharePanelParam.b0(new i());
        sharePanelParam.V(new j());
        sharePanelParam.Z(new k());
        sharePanelParam.a0(new l());
        Lh();
        Mh();
        Hh();
        Nh();
        sharePanelParam.E(true);
    }

    private final void Ph(final int callbackId, final boolean success, final Intent intent) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.r
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCServerFragment.Qh(SharePanelIPCServerFragment.this, callbackId, success, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(SharePanelIPCServerFragment this$0, int i3, boolean z16, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.sharepanel.m remove = this$0.prepareForwardCallbackMap.remove(Integer.valueOf(i3));
        if (remove == null) {
            return;
        }
        QLog.d("SharePanelIPCServerFragment", 1, "prepareForwardResult callbackId:" + i3 + " success:" + z16);
        if (z16) {
            remove.a(intent);
        } else {
            remove.onFail();
        }
    }

    private final void Rh(final int callbackId, final boolean success) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.q
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCServerFragment.Sh(SharePanelIPCServerFragment.this, callbackId, success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(SharePanelIPCServerFragment this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.sharepanel.o remove = this$0.shareConfirmCallbackMap.remove(Integer.valueOf(i3));
        if (remove == null) {
            return;
        }
        QLog.d("SharePanelIPCServerFragment", 1, "shareConfirmResult callbackId:" + i3 + " success:" + z16);
        if (z16) {
            remove.b();
        } else {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSharePanel() {
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Gh().a(activity, sharePanelParam);
        }
        SimpleEventBus.getInstance().dispatchEvent(new DismissOtherPanelEvent(this.clientProcess, this.clientSeq));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SharePanelIPCServerEvent.class, DismissOtherPanelEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("process", "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(SharePanelI\u2026nstant.PARAM_PROCESS, \"\")");
            this.clientProcess = string;
            this.clientSeq = arguments.getInt("seq");
            this.sharePanelParam = (SharePanelParam) arguments.getParcelable("showParam");
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SharePanelIPCServerFragment$onCreate$2(this, null), 3, null);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Ah(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Bundle());
        this.sharePanelParam = null;
        this.prepareForwardCallbackMap.clear();
        this.shareConfirmCallbackMap.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        ShareActionDynamicModifier shareActionDynamicModifier;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (event instanceof SharePanelIPCServerEvent) {
            SharePanelIPCServerEvent sharePanelIPCServerEvent = (SharePanelIPCServerEvent) event;
            if (Intrinsics.areEqual(sharePanelIPCServerEvent.getParams().getString("process"), this.clientProcess) && sharePanelIPCServerEvent.getParams().getInt("seq") == this.clientSeq) {
                String action = sharePanelIPCServerEvent.getAction();
                switch (action.hashCode()) {
                    case -420450978:
                        if (action.equals("shareConfirmResult")) {
                            Rh(sharePanelIPCServerEvent.getParams().getInt("callbackId"), sharePanelIPCServerEvent.getParams().getBoolean("success"));
                            return;
                        }
                        return;
                    case 326523353:
                        if (action.equals("dynamicModify") && (shareActionDynamicModifier = (ShareActionDynamicModifier) sharePanelIPCServerEvent.getParams().getParcelable("dynamicModifier")) != null) {
                            Eh(shareActionDynamicModifier);
                            return;
                        }
                        return;
                    case 418213274:
                        if (action.equals("dismissPanel")) {
                            Ch();
                            return;
                        }
                        return;
                    case 1924343163:
                        if (action.equals("prepareForwardResult")) {
                            Ph(sharePanelIPCServerEvent.getParams().getInt("callbackId"), sharePanelIPCServerEvent.getParams().getBoolean("success"), (Intent) sharePanelIPCServerEvent.getParams().getParcelable("forwardIntent"));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        if (event instanceof DismissOtherPanelEvent) {
            DismissOtherPanelEvent dismissOtherPanelEvent = (DismissOtherPanelEvent) event;
            if (!Intrinsics.areEqual(dismissOtherPanelEvent.getTopClientProcess(), this.clientProcess) || dismissOtherPanelEvent.getTopClientSeq() != this.clientSeq) {
                QLog.d("SharePanelIPCServerFragment", 1, "receive dismiss other panel event");
                Ch();
            }
        }
    }
}
