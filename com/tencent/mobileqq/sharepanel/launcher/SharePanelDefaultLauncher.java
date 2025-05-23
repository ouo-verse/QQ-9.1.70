package com.tencent.mobileqq.sharepanel.launcher;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.selectfriend.api.IForwardFriendApi;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.action.j;
import com.tencent.mobileqq.sharepanel.e;
import com.tencent.mobileqq.sharepanel.fragment.SharePanelDialogFragment;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001+\u0018\u0000 12\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelDefaultLauncher;", "Lcom/tencent/mobileqq/sharepanel/launcher/a;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "", "o", DomainData.DOMAIN_NAME, "Lkotlin/Function0;", "block", "i", h.F, "", "", "", "modifyMap", "", "k", "j", "Lcom/tencent/mobileqq/sharepanel/action/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nodeList", "Lcom/tencent/mobileqq/sharepanel/e;", "filter", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "g", "a", "dismiss", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "modifier", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/sharepanel/fragment/SharePanelDialogFragment;", "Ljava/lang/ref/WeakReference;", "fragmentRef", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "com/tencent/mobileqq/sharepanel/launcher/SharePanelDefaultLauncher$c", "c", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelDefaultLauncher$c;", "defaultContactFilter", "<init>", "()V", "d", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelDefaultLauncher implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<SharePanelDialogFragment> fragmentRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SharePanelParam sharePanelParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c defaultContactFilter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelDefaultLauncher$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.SharePanelDefaultLauncher$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((j) t16).i()), Integer.valueOf(((j) t17).i()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/SharePanelDefaultLauncher$c", "Lcom/tencent/mobileqq/sharepanel/e;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "contact", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.e
        public boolean a(@NotNull ResultRecord contact) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(contact, "contact");
            int i3 = contact.uinType;
            if (i3 == 0 || i3 == 1 || i3 == 10027) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SharePanelDefaultLauncher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.defaultContactFilter = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SharePanelContactItem> g(List<SharedNode> nodeList, e filter) {
        List mutableListOf;
        boolean z16;
        boolean z17;
        if (nodeList != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.defaultContactFilter);
            if (filter != null) {
                mutableListOf.add(filter);
            }
            QRouteApi api = QRoute.api(IForwardFriendApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IForwardFriendApi::class.java)");
            IForwardFriendApi iForwardFriendApi = (IForwardFriendApi) api;
            ArrayList arrayList = new ArrayList();
            Iterator<SharedNode> it = nodeList.iterator();
            while (it.hasNext()) {
                ResultRecord resultRecordFromSharedNode = iForwardFriendApi.getResultRecordFromSharedNode(it.next());
                if (resultRecordFromSharedNode != null) {
                    String str = resultRecordFromSharedNode.uin;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        Iterator it5 = mutableListOf.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                if (!((e) it5.next()).a(resultRecordFromSharedNode)) {
                                    z17 = false;
                                    break;
                                }
                            } else {
                                z17 = true;
                                break;
                            }
                        }
                        if (z17) {
                            String str2 = resultRecordFromSharedNode.uin;
                            String str3 = "";
                            if (str2 == null) {
                                str2 = "";
                            }
                            int i3 = resultRecordFromSharedNode.uinType;
                            String str4 = resultRecordFromSharedNode.name;
                            if (str4 == null) {
                                str4 = "";
                            }
                            SharePanelContactItem sharePanelContactItem = new SharePanelContactItem(str2, i3, str4);
                            String str5 = resultRecordFromSharedNode.guildId;
                            if (str5 != null) {
                                Intrinsics.checkNotNullExpressionValue(str5, "record.guildId ?: \"\"");
                                str3 = str5;
                            }
                            sharePanelContactItem.k(str3);
                            arrayList.add(sharePanelContactItem);
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(SharePanelParam param) {
        List<j> sortedWith;
        com.tencent.mobileqq.sharepanel.config.biz.c b16 = com.tencent.mobileqq.sharepanel.config.biz.b.f287223a.b(param.u());
        List<String> b17 = b16.b();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = b17.iterator();
        while (it.hasNext()) {
            j a16 = com.tencent.mobileqq.sharepanel.config.c.f287231a.a((String) it.next());
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        param.k0(sortedWith);
        k(param, param.c().c());
        List<String> a17 = b16.a();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = a17.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.sharepanel.action.a a18 = com.tencent.mobileqq.sharepanel.config.a.f287209a.a((String) it5.next());
            if (a18 != null) {
                arrayList2.add(a18);
            }
        }
        param.C(arrayList2);
        j(param, param.c().b());
    }

    private final void i(SharePanelParam param, Function0<Unit> block) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "SharePanelDefaultLauncher", Boolean.FALSE, null, null, new SharePanelDefaultLauncher$dealSharePanelParam$1(param, this, block, null), 12, null);
        }
    }

    private final boolean j(SharePanelParam param, Map<String, Integer> modifyMap) {
        com.tencent.mobileqq.sharepanel.config.biz.c b16 = com.tencent.mobileqq.sharepanel.config.biz.b.f287223a.b(param.u());
        boolean z16 = false;
        if (b16.c().isEmpty()) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : modifyMap.entrySet()) {
            if (b16.c().contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        QLog.d("SharePanelDefaultLauncher", 1, "dynamicModifyAppendAction: " + modifyMap);
        Iterator<T> it = param.a().iterator();
        while (it.hasNext()) {
            if (m((com.tencent.mobileqq.sharepanel.action.a) it.next(), modifyMap)) {
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean k(SharePanelParam param, Map<String, Integer> modifyMap) {
        com.tencent.mobileqq.sharepanel.config.biz.c b16 = com.tencent.mobileqq.sharepanel.config.biz.b.f287223a.b(param.u());
        boolean z16 = false;
        if (b16.d().isEmpty()) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : modifyMap.entrySet()) {
            if (b16.d().contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        QLog.d("SharePanelDefaultLauncher", 1, "dynamicModifyShareChannel: " + modifyMap);
        Iterator<T> it = param.w().iterator();
        while (it.hasNext()) {
            if (m((j) it.next(), modifyMap)) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(Continuation<? super List<SharedNode>> continuation) {
        Continuation intercepted;
        List emptyList;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        try {
            IForwardFriendApi iForwardFriendApi = (IForwardFriendApi) QRoute.api(IForwardFriendApi.class);
            Intent intent = new Intent();
            intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 2);
            iForwardFriendApi.getFrowardAndRecent(intent, true, true, false, new Function1<List<? extends SharedNode>, Unit>(cancellableContinuationImpl) { // from class: com.tencent.mobileqq.sharepanel.launcher.SharePanelDefaultLauncher$getFrowardAndRecent$2$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellableContinuation<List<SharedNode>> $continuation;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$continuation = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends SharedNode> list) {
                    invoke2((List<SharedNode>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable List<SharedNode> list) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    CancellableContinuation<List<SharedNode>> cancellableContinuation = this.$continuation;
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    cancellableContinuation.resume(list, AnonymousClass1.INSTANCE);
                }
            });
        } catch (Exception e16) {
            QLog.e("SharePanelDefaultLauncher", 1, "getFrowardAndRecent exception: ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuationImpl.resume(emptyList, SharePanelDefaultLauncher$getFrowardAndRecent$2$3.INSTANCE);
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final boolean m(com.tencent.mobileqq.sharepanel.action.e item, Map<String, Integer> modifyMap) {
        boolean z16;
        boolean z17;
        Integer num = modifyMap.get(item.a());
        boolean z18 = false;
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if ((intValue & 1) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((intValue & 2) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (item.e() != z16) {
            item.g(z16);
            z18 = true;
        }
        if (item.b() != z17) {
            item.f(z17);
            return true;
        }
        return z18;
    }

    private final void n(FragmentActivity activity) {
        try {
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag("SharePanelDefaultLauncher");
            if (findFragmentByTag != null) {
                activity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
        } catch (Exception e16) {
            QLog.e("SharePanelDefaultLauncher", 1, "removeSharePanelFragment error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(FragmentActivity activity, SharePanelParam param) {
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            n(activity);
            SharePanelDialogFragment sharePanelDialogFragment = new SharePanelDialogFragment(param);
            try {
                activity.getSupportFragmentManager().beginTransaction().add(sharePanelDialogFragment, "SharePanelDefaultLauncher").commitAllowingStateLoss();
                this.fragmentRef = new WeakReference<>(sharePanelDialogFragment);
                QLog.i("SharePanelDefaultLauncher", 1, "showSharePanel sceneId:" + param.u());
                return;
            } catch (Exception e16) {
                QLog.e("SharePanelDefaultLauncher", 1, "showInternal error: ", e16);
                return;
            }
        }
        QLog.e("SharePanelDefaultLauncher", 1, "showInternal activity state is invalid");
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void a(@NotNull final FragmentActivity activity, @NotNull final SharePanelParam param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        this.sharePanelParam = param;
        i(param, new Function0<Unit>(activity, param) { // from class: com.tencent.mobileqq.sharepanel.launcher.SharePanelDefaultLauncher$show$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ FragmentActivity $activity;
            final /* synthetic */ SharePanelParam $param;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$activity = activity;
                this.$param = param;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SharePanelDefaultLauncher.this, activity, param);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SharePanelDefaultLauncher.this.o(this.$activity, this.$param);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void b(@NotNull ShareActionDynamicModifier modifier) {
        SharePanelDialogFragment sharePanelDialogFragment;
        SharePanelParam sharePanelParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) modifier);
            return;
        }
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        WeakReference<SharePanelDialogFragment> weakReference = this.fragmentRef;
        if (weakReference != null) {
            sharePanelDialogFragment = weakReference.get();
        } else {
            sharePanelDialogFragment = null;
        }
        if ((sharePanelDialogFragment == null || (sharePanelParam = sharePanelDialogFragment.qh()) == null) && (sharePanelParam = this.sharePanelParam) == null) {
            return;
        }
        sharePanelParam.D(modifier);
        if (k(sharePanelParam, modifier.c()) && sharePanelDialogFragment != null) {
            sharePanelDialogFragment.vh();
        }
        if (j(sharePanelParam, modifier.b()) && sharePanelDialogFragment != null) {
            sharePanelDialogFragment.uh();
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void dismiss() {
        SharePanelDialogFragment sharePanelDialogFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        WeakReference<SharePanelDialogFragment> weakReference = this.fragmentRef;
        if (weakReference != null && (sharePanelDialogFragment = weakReference.get()) != null) {
            try {
                sharePanelDialogFragment.dismissAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("SharePanelDefaultLauncher", 1, "dismiss error: ", e16);
            }
        }
        this.fragmentRef = null;
        this.sharePanelParam = null;
    }
}
