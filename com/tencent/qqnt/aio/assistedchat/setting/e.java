package com.tencent.qqnt.aio.assistedchat.setting;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ4\u0010\u0017\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\f\u001a\u00020\n2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015J:\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015J\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\rR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/setting/e;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", h.F, "", "i", "j", "g", "", "f", "switchValue", "", "t", "Lwu3/a;", "listener", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "switchList", "Lkotlin/Function1;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uin", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", DomainData.DOMAIN_NAME, "k", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "preRequestSwitchSet", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/List;", "e", "()Ljava/util/List;", "allSwitchList", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f349447a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> preRequestSwitchSet = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<wu3.a> listeners = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<AssistedChatSwitch> allSwitchList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/assistedchat/setting/e$a", "Lcom/tencent/qqnt/aio/assistedchat/setting/f;", "", "isSuccess", "", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", VideoTemplateParser.ITEM_LIST, "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<List<com.tencent.qqnt.aio.assistedchat.model.d>, Unit> f349451d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super List<com.tencent.qqnt.aio.assistedchat.model.d>, Unit> function1) {
            this.f349451d = function1;
        }

        @Override // com.tencent.qqnt.aio.assistedchat.setting.f
        public void a(boolean isSuccess, List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            Function1<List<com.tencent.qqnt.aio.assistedchat.model.d>, Unit> function1 = this.f349451d;
            if (function1 != null) {
                function1.invoke(itemList);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/setting/e$b", "Lcom/tencent/qqnt/aio/assistedchat/setting/f;", "", "isSuccess", "", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f349452d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f349452d = function1;
        }

        @Override // com.tencent.qqnt.aio.assistedchat.setting.f
        public void b(boolean isSuccess) {
            Function1<Boolean, Unit> function1 = this.f349452d;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(isSuccess));
            }
        }
    }

    static {
        List<AssistedChatSwitch> listOf;
        AssistedChatSwitchType assistedChatSwitchType = AssistedChatSwitchType.AUTO_POLISH;
        AssistedChatSwitchType assistedChatSwitchType2 = AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND;
        AssistedChatSwitchType assistedChatSwitchType3 = AssistedChatSwitchType.REPLY_SUGGESTION;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AssistedChatSwitch[]{new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0), new AssistedChatSwitch(assistedChatSwitchType, 1), new AssistedChatSwitch(assistedChatSwitchType, 104), new AssistedChatSwitch(assistedChatSwitchType, 119), new AssistedChatSwitch(assistedChatSwitchType2, 1), new AssistedChatSwitch(assistedChatSwitchType2, 104), new AssistedChatSwitch(assistedChatSwitchType2, 119), new AssistedChatSwitch(assistedChatSwitchType3, 1), new AssistedChatSwitch(assistedChatSwitchType3, 104), new AssistedChatSwitch(assistedChatSwitchType3, 119)});
        allSwitchList = listOf;
    }

    e() {
    }

    private final String h(AssistedChatSwitch r65) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        if (r65.b().getBindChatType()) {
            return "AssistedChatSwitch_" + currentAccountUin + "_" + r65.a() + "_" + r65.b();
        }
        return "AssistedChatSwitch_" + currentAccountUin + "_" + r65.b();
    }

    private final boolean i() {
        return !preRequestSwitchSet.contains(j());
    }

    private final String j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return String.valueOf(peekAppRuntime != null ? peekAppRuntime.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        e eVar = f349447a;
        if (eVar.i()) {
            QLog.d("AssistedChatSwitchManager", 1, "preRequestSwitch");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            o(eVar, currentAccountUin, allSwitchList, null, 4, null);
            eVar.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String uin, List switchList, Function1 function1) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(switchList, "$switchList");
        AssistedChatSwitchServlet.INSTANCE.a(uin, switchList, new a(function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(List switchList, int i3, Function1 function1) {
        Intrinsics.checkNotNullParameter(switchList, "$switchList");
        Iterator it = switchList.iterator();
        while (it.hasNext()) {
            f349447a.t((AssistedChatSwitch) it.next(), i3);
        }
        AssistedChatSwitchServlet.INSTANCE.b(switchList, i3, new b(function1));
    }

    public final void d(wu3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final List<AssistedChatSwitch> e() {
        return allSwitchList;
    }

    public final int f(AssistedChatSwitch r36) {
        Intrinsics.checkNotNullParameter(r36, "switch");
        return QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations").getInt(h(r36), 0);
    }

    public final boolean g(AssistedChatSwitch r36) {
        Intrinsics.checkNotNullParameter(r36, "switch");
        int f16 = f(r36);
        if (f16 != 1) {
            return f16 == 0 && r36.b().getDefValue();
        }
        return true;
    }

    public final void k() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.setting.c
            @Override // java.lang.Runnable
            public final void run() {
                e.l();
            }
        }, 16, null, true);
    }

    public final void m(wu3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void n(final String uin, final List<AssistedChatSwitch> switchList, final Function1<? super List<com.tencent.qqnt.aio.assistedchat.model.d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.setting.d
            @Override // java.lang.Runnable
            public final void run() {
                e.p(uin, switchList, callback);
            }
        }, 16, null, true);
    }

    public final void q(final List<AssistedChatSwitch> switchList, final int switchValue, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.setting.b
            @Override // java.lang.Runnable
            public final void run() {
                e.r(switchList, switchValue, callback);
            }
        }, 16, null, true);
    }

    public final void s() {
        preRequestSwitchSet.add(j());
    }

    public final void t(AssistedChatSwitch r56, int switchValue) {
        Intrinsics.checkNotNullParameter(r56, "switch");
        boolean g16 = g(r56);
        QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations").putInt(h(r56), switchValue);
        boolean z16 = true;
        if (switchValue != 1 && (switchValue != 0 || !r56.b().getDefValue())) {
            z16 = false;
        }
        if (g16 != z16) {
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                ((wu3.a) it.next()).a(new com.tencent.qqnt.aio.assistedchat.model.d(r56, z16, switchValue));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(e eVar, String str, List list, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        eVar.n(str, list, function1);
    }
}
