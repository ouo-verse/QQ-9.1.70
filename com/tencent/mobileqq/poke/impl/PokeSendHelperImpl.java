package com.tencent.mobileqq.poke.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.PokeMsgEvent;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.poke.IPokeSendHelper;
import com.tencent.mobileqq.poke.NTPokePanel;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ;2\u00020\u0001:\u0003<=>B\u0007\u00a2\u0006\u0004\b9\u0010:JM\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J{\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2K\u0010$\u001aG\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001d0\u001fH\u0016J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J*\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R>\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b01j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`28\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl;", "Lcom/tencent/mobileqq/poke/IPokeSendHelper;", "Lcom/tencent/common/app/AppInterface;", "app", "", "curFriendUin", "", "status", "Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$a;", "aioInfo", "", "Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;", "strengthInfos", "lastIndex", "index", "", "handleStrengthInfo", "(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ILcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$a;[Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;II)Z", "Landroid/app/Activity;", "getTopActivity", "Lmqq/app/AppRuntime;", "getApp", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lkotlin/Function0;", "", "update", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "resId", "minVersion", "successCallback", "Lcom/tencent/mobileqq/app/BusinessObserver;", "vasPokeAuth", "sendPokeMsg", "type", "getStrengthStatus", "", "D_HIT_TIME_MS", "J", "getD_HIT_TIME_MS", "()J", "setD_HIT_TIME_MS", "(J)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mAioStrengthInfo", "Ljava/util/HashMap;", "getMAioStrengthInfo", "()Ljava/util/HashMap;", "setMAioStrengthInfo", "(Ljava/util/HashMap;)V", "<init>", "()V", "Companion", "a", "b", "c", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PokeSendHelperImpl implements IPokeSendHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int POKE_ANIMATION_NUM = 6;

    @NotNull
    public static final String TAG = "PokeSendHelper";
    private long D_HIT_TIME_MS;

    @NotNull
    private HashMap<String, a> mAioStrengthInfo;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$a;", "", "", "a", "I", "()I", "c", "(I)V", "lastIndex", "", "Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;", "b", "[Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;", "()[Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;", "setStrengthInfos", "([Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;)V", "strengthInfos", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private c[] strengthInfos;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.lastIndex = -1;
            c[] cVarArr = new c[6];
            for (int i3 = 0; i3 < 6; i3++) {
                cVarArr[i3] = new c();
            }
            this.strengthInfos = cVarArr;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.lastIndex;
        }

        @NotNull
        public final c[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (c[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.strengthInfos;
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.lastIndex = i3;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$b;", "", "", "POKE_ANIMATION_NUM", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.poke.impl.PokeSendHelperImpl$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/poke/impl/PokeSendHelperImpl$c;", "", "", "a", "I", "c", "()I", "f", "(I)V", "status", "b", "d", "count", "", "J", "()J", "e", "(J)V", "lastClickedTime", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int count;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long lastClickedTime;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.lastClickedTime = -1L;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.count;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.lastClickedTime;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.status;
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.count = i3;
            }
        }

        public final void e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            } else {
                this.lastClickedTime = j3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.status = i3;
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/poke/impl/PokeSendHelperImpl$d", "Lcom/tencent/mobileqq/apollo/handler/c;", "", "isSuccess", "", "data", "", "a", "Landroid/os/Bundle;", "extra", "b", "", "type", "onUpdate", "d", "I", "getPayId", "()I", "setPayId", "(I)V", "payId", "e", "getPayType", "setPayType", "payType", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.mobileqq.apollo.handler.c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int payId = -1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int payType = 1;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f259083f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ PokeSendHelperImpl f259084h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, String, Unit> f259085i;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function0<Unit> function0, PokeSendHelperImpl pokeSendHelperImpl, Function3<? super Integer, ? super String, ? super String, Unit> function3) {
            this.f259083f = function0;
            this.f259084h = pokeSendHelperImpl;
            this.f259085i = function3;
        }

        private final void a(boolean isSuccess, Object data) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle = (Bundle) data;
            int i3 = bundle.getInt(IProfileCardConst.KEY_FROM_TYPE);
            if (1 != i3) {
                QLog.d(PokeSendHelperImpl.TAG, 1, "onPokeAuth unknown from type : ", Integer.valueOf(i3));
                return;
            }
            this.f259083f.invoke();
            AppRuntime app = this.f259084h.getApp();
            if (app != null) {
                ((AppInterface) app).removeObserver(this);
            }
            int i16 = bundle.getInt("id");
            QLog.d(PokeSendHelperImpl.TAG, 1, "onPokeAuth success : ", Boolean.valueOf(isSuccess));
            if (isSuccess) {
                String string = bundle.getString("name");
                String string2 = bundle.getString("minVersion");
                Function3<Integer, String, String, Unit> function3 = this.f259085i;
                Integer valueOf = Integer.valueOf(i16);
                if (string == null) {
                    string = "";
                }
                if (string2 == null) {
                    string2 = "";
                }
                function3.invoke(valueOf, string, string2);
                return;
            }
            b(bundle, bundle);
        }

        private final void b(Bundle extra, Bundle data) {
            long j3 = extra.getLong("result");
            String string = extra.getString("msg");
            this.payId = data.getInt("id", 0);
            String qqStr = HardCodeUtil.qqStr(R.string.pae);
            QLog.d(PokeSendHelperImpl.TAG, 1, "onPokeAuth result : ", Long.valueOf(j3), " msg : ", string);
            if (j3 == 0) {
                this.payType = 1;
                if (f.N) {
                    f.N = false;
                    return;
                }
                return;
            }
            if (j3 == 4002) {
                this.payType = 2;
                string = HardCodeUtil.qqStr(R.string.pah);
            } else if (j3 == 5002) {
                this.payType = 4;
                string = HardCodeUtil.qqStr(R.string.pag);
            } else {
                this.payType = 1;
                qqStr = HardCodeUtil.qqStr(R.string.ket);
                QLog.e(PokeSendHelperImpl.TAG, 1, "vas poke auth fail, result: " + j3);
            }
            f.t(this.f259084h.getApp(), this.f259084h.getTopActivity(), string, qqStr, this.payId, this.payType, NTPokePanel.o());
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @NotNull Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (type == 23) {
                a(isSuccess, data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PokeSendHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAioStrengthInfo = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getTopActivity() {
        return Foreground.getTopActivity();
    }

    private final boolean handleStrengthInfo(AppInterface app, String curFriendUin, int status, a aioInfo, c[] strengthInfos, int lastIndex, int index) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (status != -1) {
            strengthInfos[index].f(status);
            strengthInfos[index].e(uptimeMillis);
            aioInfo.c(index);
            return true;
        }
        if (lastIndex != -1 && strengthInfos[index].b() != -1) {
            long b16 = uptimeMillis - strengthInfos[index].b();
            strengthInfos[index].e(uptimeMillis);
            if (lastIndex != index) {
                int a16 = strengthInfos[lastIndex].a();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a16);
                ReportController.o(app, "CliOper", "", curFriendUin, "0X8008914", "0X8008914", 0, 0, sb5.toString(), "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Strength click,type:" + index + ".with status " + strengthInfos[index].c() + "to 0");
                }
                aioInfo.c(index);
                strengthInfos[index].f(0);
                strengthInfos[index].d(1);
                return true;
            }
            if (b16 < this.D_HIT_TIME_MS) {
                c cVar = strengthInfos[index];
                cVar.f(cVar.c() + 1);
                c cVar2 = strengthInfos[index];
                cVar2.d(cVar2.a() + 1);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Strength click ,type:" + index + ".with status " + strengthInfos[index].c());
                }
            } else {
                int a17 = strengthInfos[lastIndex].a();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(a17);
                ReportController.o(app, "CliOper", "", curFriendUin, "0X8008914", "0X8008914", 0, 0, sb6.toString(), "", "", "");
                strengthInfos[index].f(0);
                strengthInfos[index].d(1);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Strength click,type:" + index + ".with status " + strengthInfos[index].c() + ",out of time");
                }
            }
            return false;
        }
        if (lastIndex != -1) {
            ReportController.o(app, "CliOper", "", curFriendUin, "0X8008914", "0X8008914", 0, 0, String.valueOf(strengthInfos[lastIndex].a()), "", "", "");
        }
        strengthInfos[index].e(uptimeMillis);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Strength first click,type:" + index + ".with status " + strengthInfos[index].c());
        }
        aioInfo.c(index);
        strengthInfos[index].f(0);
        strengthInfos[index].d(1);
        return true;
    }

    public final long getD_HIT_TIME_MS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.D_HIT_TIME_MS;
    }

    @NotNull
    public final HashMap<String, a> getMAioStrengthInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mAioStrengthInfo;
    }

    @Override // com.tencent.mobileqq.poke.IPokeSendHelper
    public int getStrengthStatus(@NotNull AppInterface app, @Nullable String curFriendUin, int type, int status) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, app, curFriendUin, Integer.valueOf(type), Integer.valueOf(status))).intValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Strength D_HIT_TIME_MS" + this.D_HIT_TIME_MS + "curFriendUin" + curFriendUin + "type" + type + "status" + status);
        }
        if (this.D_HIT_TIME_MS == 0) {
            long j3 = PreferenceManager.getDefaultSharedPreferences(app.getApp()).getLong(app.getAccount() + "_aio_poke_strength_rule_interval", 0L) * 1000;
            this.D_HIT_TIME_MS = j3;
            if (j3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Strength D_HIT_TIME_MS is not ready");
                }
                return 0;
            }
        }
        if (TextUtils.isEmpty(curFriendUin)) {
            return 0;
        }
        if (!this.mAioStrengthInfo.containsKey(curFriendUin) || this.mAioStrengthInfo.get(curFriendUin) == null) {
            a aVar = new a();
            HashMap<String, a> hashMap = this.mAioStrengthInfo;
            Intrinsics.checkNotNull(curFriendUin);
            hashMap.put(curFriendUin, aVar);
        }
        a aVar2 = this.mAioStrengthInfo.get(curFriendUin);
        if (aVar2 == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            String RDM_NoChangeFailCode = BaseConstants.RDM_NoChangeFailCode;
            Intrinsics.checkNotNullExpressionValue(RDM_NoChangeFailCode, "RDM_NoChangeFailCode");
            hashMap2.put(RDM_NoChangeFailCode, "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.POKE_STRENGTH_NULL_POINT, false, 0L, 0L, hashMap2, "");
            return 0;
        }
        c[] b16 = aVar2.b();
        int a16 = aVar2.a();
        int i16 = type - 1;
        if (i16 == -1) {
            i3 = 0;
        } else {
            i3 = i16;
        }
        if (i3 < 0 || i3 >= 6) {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNull(curFriendUin);
            if (handleStrengthInfo(app, curFriendUin, status, aVar2, b16, a16, i3)) {
                return b16[i3].c();
            }
            if (b16[i3].c() > 3) {
                b16[i3].f(3);
            }
            return b16[i3].c();
        }
        if (a16 != -1) {
            ReportController.o(app, "CliOper", "", curFriendUin, "0X8008914", "0X8008914", 0, 0, String.valueOf(b16[a16].a()), "", "", "");
            aVar2.c(-1);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.poke.IPokeSendHelper
    public void sendPokeMsg(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aioContext, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(item, "item");
        item.B(5);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        item.E(getStrengthStatus((AppInterface) peekAppRuntime, aioContext.g().r().c().j(), item.p(), -1));
        aioContext.e().h(new PokeMsgEvent.PokeSendEvent(item));
    }

    public final void setD_HIT_TIME_MS(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.D_HIT_TIME_MS = j3;
        }
    }

    public final void setMAioStrengthInfo(@NotNull HashMap<String, a> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
        } else {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            this.mAioStrengthInfo = hashMap;
        }
    }

    @Override // com.tencent.mobileqq.poke.IPokeSendHelper
    @NotNull
    public BusinessObserver vasPokeAuth(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item, @NotNull Function0<Unit> update, @NotNull Function3<? super Integer, ? super String, ? super String, Unit> successCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 6, this, context, aioContext, item, update, successCallback);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        d dVar = new d(update, this, successCallback);
        AppRuntime app = getApp();
        if (app != null) {
            Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) app;
            appInterface.addObserver(dVar);
            NTPokePanel.n();
            com.tencent.qqnt.pluspanel.logic.c o16 = NTPokePanel.o();
            if (o16 != null) {
                o16.d(appInterface, item.w(), item.y(), item.p(), item.x(), 1);
            }
        }
        return dVar;
    }
}
