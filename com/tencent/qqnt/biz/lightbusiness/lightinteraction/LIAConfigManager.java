package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.api.ILiteBusinessABTestApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.IFreesiaStringResCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionType;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J.\u0010\t\u001a\u00020\u00072$\u0010\b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0007J.\u0010\u000b\u001a\u00020\u00072$\u0010\b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0004\u0012\u00020\u00070\u0002H\u0007J,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0002J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R*\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAConfigManager;", "", "Lkotlin/Function1;", "", "", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "k", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "f", "g", "e", "j", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "scene", "i", tl.h.F, "a", "Ljava/util/Map;", "configActionMap", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "forceShowOnMsgListSet", "<init>", "()V", "c", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<LIAConfigManager> f353120d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Integer> f353121e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> configActionMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashSet<String> forceShowOnMsgListSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAConfigManager$a;", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAConfigManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAConfigManager;", "sInstance", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "DEFAULT_EMOTION_MAP", "Ljava/util/HashMap;", "", "ID_EXT_INFO_SWITCH", "Ljava/lang/String;", "TAG", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final LIAConfigManager b() {
            return (LIAConfigManager) LIAConfigManager.f353120d.getValue();
        }

        @NotNull
        public final LIAConfigManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LIAConfigManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b();
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
        Lazy<LIAConfigManager> lazy;
        HashMap<Integer, Integer> hashMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) LIAConfigManager$Companion$sInstance$2.INSTANCE);
        f353120d = lazy;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(LiteActionType.KNEWBUDDY.ordinal()), 341), TuplesKt.to(Integer.valueOf(LiteActionType.KBIRTHDAY.ordinal()), 53), TuplesKt.to(Integer.valueOf(LiteActionType.KGOODMORNING.ordinal()), 74), TuplesKt.to(Integer.valueOf(LiteActionType.KPOKE.ordinal()), 181), TuplesKt.to(Integer.valueOf(LiteActionType.KGOODNIGHT.ordinal()), 75));
        f353121e = hashMapOf;
    }

    public LIAConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LIAConfigManager this$0, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.m(callback);
    }

    private final void m(final Function1<? super Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>, Unit> callback) {
        Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> map = this.configActionMap;
        if (map != null) {
            callback.invoke(map);
        } else {
            FreesiaWrapperImpl.INSTANCE.b().g("101758", "", new IFreesiaStringResCallback() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFreesiaStringResCallback
                public final void onResult(String str) {
                    LIAConfigManager.n(LIAConfigManager.this, callback, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(LIAConfigManager this$0, Function1 callback, String json) {
        boolean z16;
        Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> emptyMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("LIAConfigManager", 1, "[initConfigAsyncInner] configRes isEmpty= " + TextUtils.isEmpty(json));
        if (json != null && json.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            this$0.configActionMap = emptyMap;
            callback.invoke(emptyMap);
            return;
        }
        LIAParseUtil lIAParseUtil = LIAParseUtil.f353136a;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        Map<Integer, List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> e16 = lIAParseUtil.e(json);
        QLog.d("LIAConfigManager", 1, "[initConfigAsyncInner] config size=" + e16.size());
        this$0.configActionMap = e16;
        callback.invoke(e16);
    }

    public final void d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String forceMsgListShowIdStr = ((ILiteBusinessABTestApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ILiteBusinessABTestApi.class)).getForceMsgListShowIdStr();
        QLog.d("LIAConfigManager", 1, "[forceUpdateABTest] str=" + forceMsgListShowIdStr);
        if (forceMsgListShowIdStr.length() > 2) {
            try {
                JSONArray jSONArray = new JSONArray(forceMsgListShowIdStr);
                HashSet<String> hashSet = new HashSet<>();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String item = jSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    if (item.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        hashSet.add(item);
                    }
                }
                this.forceShowOnMsgListSet = hashSet;
                QLog.d("LIAConfigManager", 1, "[forceUpdateABTest] parse res=" + hashSet);
            } catch (Exception e16) {
                QLog.e("LIAConfigManager", 1, "[forceUpdateABTest] parse err, ", e16);
            }
        }
    }

    @Nullable
    public final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b e(int type, int subType) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(type), Integer.valueOf(subType));
        }
        List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> g16 = g(type);
        Object obj = null;
        if (g16 == null) {
            return null;
        }
        Iterator<T> it = g16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) next).m() == subType) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) obj;
    }

    public final void f(final int type, final int subType, @NotNull final Function1<? super com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(type), Integer.valueOf(subType), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            k(new Function1<Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>, Unit>(callback, this, type, subType) { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager$getConfigActionByTypeAsync$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b, Unit> $callback;
                final /* synthetic */ int $subType;
                final /* synthetic */ int $type;
                final /* synthetic */ LIAConfigManager this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$callback = callback;
                    this.this$0 = this;
                    this.$type = type;
                    this.$subType = subType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, callback, this, Integer.valueOf(type), Integer.valueOf(subType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> map) {
                    invoke2((Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.$callback.invoke(this.this$0.e(this.$type, this.$subType));
                    }
                }
            });
        }
    }

    @Nullable
    public final List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> g(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, type);
        }
        Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> map = this.configActionMap;
        if (map != null) {
            return map.get(Integer.valueOf(type));
        }
        return null;
    }

    public final int h(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, type)).intValue();
        }
        Integer num = f353121e.get(Integer.valueOf(type));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @NotNull
    public final List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> i(int type, @NotNull LIAScene scene) {
        boolean z16;
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, type, (Object) scene);
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        ArrayList arrayList = new ArrayList();
        List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> g16 = g(type);
        if (g16 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : g16) {
                com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar = (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) obj;
                String str = bVar.n() + "_" + bVar.m();
                if (scene == LIAScene.MsgList) {
                    HashSet<String> hashSet = this.forceShowOnMsgListSet;
                    if (hashSet != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (hashSet != null) {
                        bool = Boolean.valueOf(hashSet.contains(str));
                    } else {
                        bool = null;
                    }
                    QLog.d("LIAConfigManager", 1, "key=" + str + ", set=" + z16 + ", contain=" + bool);
                }
                if (LIAHelper.f353124a.q(bVar.k(), scene)) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b j(int type, int subType) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(type), Integer.valueOf(subType));
        }
        List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> i3 = i(type, LIAScene.MsgList);
        QLog.d("LIAConfigManager", 1, "[getRandomItemForMsgList] type=" + type + ", subType=" + subType + ", find res=" + i3.size());
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar = null;
        if (!(!i3.isEmpty())) {
            return null;
        }
        if (subType != -1) {
            Iterator<T> it = i3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) next).m() == subType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    bVar = next;
                    break;
                }
            }
            bVar = bVar;
        }
        if (bVar == null) {
            return i3.get(Random.INSTANCE.nextInt(i3.size()));
        }
        return bVar;
    }

    @WorkerThread
    public final void k(@NotNull final Function1<? super Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.f
                @Override // java.lang.Runnable
                public final void run() {
                    LIAConfigManager.l(LIAConfigManager.this, callback);
                }
            }, 64, null, true);
        } else {
            m(callback);
        }
    }
}
