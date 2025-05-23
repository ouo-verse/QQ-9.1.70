package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.a;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00014\b\u0007\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u001f\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u001e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002J\u001e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002J\u0016\u0010\u001a\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J0\u0010!\u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\tH\u0016J(\u0010'\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010$\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u001c0(j\b\u0012\u0004\u0012\u00020\u001c`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00100R\u0016\u00103\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/k;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "v", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "u", "msgItem", HippyTKDListViewAdapter.X, "", "chatType", "w", ReportConstant.COSTREPORT_PREFIX, "y", "", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgIdList", "", "peerUid", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "k", "source", "Landroid/os/Bundle;", "extra", "b", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "removeMsgIdSet", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "lastMsgCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasSendMsg", "D", "hasC2CRecommendMsg", "com/tencent/mobileqq/aio/msglist/msgrepo/k$b", "E", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/k$b;", "actionR", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", UserInfo.SEX_FEMALE, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean hasSendMsg;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean hasC2CRecommendMsg;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b actionR;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Long> removeMsgIdSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastMsgCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.k$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/msgrepo/k$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return k.this.u(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
            return;
        }
        this.removeMsgIdSet = new HashSet<>();
        this.hasSendMsg = new AtomicBoolean(false);
        this.hasC2CRecommendMsg = new AtomicBoolean(false);
        this.actionR = new b();
    }

    private final boolean A(AIOMsgItem msgItem, List<? extends AIOMsgItem> list) {
        int collectionSizeOrDefault;
        boolean z16;
        if (((IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class)).isLittleAssistant(d().g().r().c())) {
            return false;
        }
        if (list.size() != 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((AIOMsgItem) obj).getMsgRecord().msgType == 29) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AIOMsgItem) it.next()).getMsgRecord());
            }
            if (o81.a.b(arrayList2)) {
                return false;
            }
        }
        return true;
    }

    private final void B(List<AIOMsgItem> list) {
        int collectionSizeOrDefault;
        Object first;
        int collectionSizeOrDefault2;
        boolean z16;
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AIOMsgItem) obj).getMsgRecord().msgType == 29) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        HashSet<Long> hashSet = this.removeMsgIdSet;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgRecord().msgId));
        }
        hashSet.addAll(arrayList2);
        list.removeAll(arrayList);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        AIOMsgItem aIOMsgItem = (AIOMsgItem) first;
        ArrayList<Long> arrayList3 = new ArrayList<>();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList4.add(Long.valueOf(((AIOMsgItem) it5.next()).getMsgRecord().msgId));
        }
        arrayList3.addAll(arrayList4);
        int i3 = aIOMsgItem.getMsgRecord().chatType;
        String str = aIOMsgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        q(arrayList3, i3, str);
    }

    private final void C(List<AIOMsgItem> list) {
        int collectionSizeOrDefault;
        Object first;
        Object first2;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (x((AIOMsgItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        list.removeAll(arrayList);
        ArrayList<Long> arrayList2 = new ArrayList<>();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgRecord().msgId));
        }
        arrayList2.addAll(arrayList3);
        this.removeMsgIdSet.addAll(arrayList2);
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        int i3 = ((AIOMsgItem) first).getMsgRecord().chatType;
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        iMsgService.deleteMsg(new Contact(i3, ((AIOMsgItem) first2).getMsgRecord().peerUid, ""), arrayList2, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                k.D(i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(int i3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i("PrologueMsgAbility", 4, "tryDeleteDirtyMsg(res:" + i3 + ", errMsg:" + str + ")");
        }
    }

    private final void q(ArrayList<Long> msgIdList, int chatType, String peerUid) {
        if (msgIdList.isEmpty()) {
            return;
        }
        d().e().h(new AssistedChatMsgIntent.PrologueMsgVisibilityChange(false));
        ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(chatType, peerUid, ""), msgIdList, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                k.r(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(int i3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i("PrologueMsgAbility", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str + ")");
        }
    }

    private final void s(List<AIOMsgItem> list) {
        Object first;
        int collectionSizeOrDefault;
        if (!list.isEmpty() && !this.removeMsgIdSet.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (this.removeMsgIdSet.contains(Long.valueOf(((AIOMsgItem) obj).getMsgId()))) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            list.removeAll(arrayList);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            AIOMsgItem aIOMsgItem = (AIOMsgItem) first;
            ArrayList<Long> arrayList2 = new ArrayList<>();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgRecord().msgId));
            }
            arrayList2.addAll(arrayList3);
            int i3 = aIOMsgItem.getMsgRecord().chatType;
            String str = aIOMsgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
            q(arrayList2, i3, str);
        }
    }

    private final AIOMsgItem t(List<? extends AIOMsgItem> list) {
        Object obj;
        boolean z16;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((AIOMsgItem) obj).getMsgRecord().msgType == 29) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (AIOMsgItem) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k u(MsgIntent i3) {
        if (i3 instanceof AssistedChatMsgIntent.GetCanShowPrologueMsgIntent) {
            return new a.C9452a(!this.hasSendMsg.get());
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void v(List<AIOMsgItem> list) {
        List<AIOMsgItem> takeLast;
        takeLast = CollectionsKt___CollectionsKt.takeLast(list, 5);
        boolean z16 = false;
        for (AIOMsgItem aIOMsgItem : takeLast) {
            if (aIOMsgItem.I() && com.tencent.qqnt.aio.msg.d.e(aIOMsgItem) != null) {
                z16 = true;
            }
        }
        if (z16 != this.hasC2CRecommendMsg.get()) {
            this.hasC2CRecommendMsg.set(z16);
            d().e().h(new AssistedChatMsgIntent.OnRecommendMsgChangeForC2CIntent(this.hasC2CRecommendMsg.get()));
        }
    }

    private final boolean w(int chatType) {
        if (chatType == 1 || chatType == 104 || chatType == 119) {
            return true;
        }
        return false;
    }

    private final boolean x(AIOMsgItem msgItem) {
        if (msgItem.getMsgRecord().msgType == 27 && com.tencent.qqnt.aio.msg.d.d(msgItem) != null) {
            return true;
        }
        return false;
    }

    private final void y(AIOMsgItem msgItem, List<AIOMsgItem> list) {
        int collectionSizeOrDefault;
        Object first;
        int collectionSizeOrDefault2;
        boolean z16;
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            AIOMsgItem aIOMsgItem = (AIOMsgItem) obj;
            if (aIOMsgItem.getMsgRecord().msgType == 29 && !Intrinsics.areEqual(aIOMsgItem, msgItem)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        list.removeAll(arrayList);
        HashSet<Long> hashSet = this.removeMsgIdSet;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgRecord().msgId));
        }
        hashSet.addAll(arrayList2);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        AIOMsgItem aIOMsgItem2 = (AIOMsgItem) first;
        ArrayList<Long> arrayList3 = new ArrayList<>();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList4.add(Long.valueOf(((AIOMsgItem) it5.next()).getMsgRecord().msgId));
        }
        arrayList3.addAll(arrayList4);
        int i3 = aIOMsgItem2.getMsgRecord().chatType;
        String str = aIOMsgItem2.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        q(arrayList3, i3, str);
    }

    private final boolean z(List<com.tencent.aio.data.msglist.a> list) {
        if (w(d().g().r().c().e()) && list.size() != this.lastMsgCount) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        MsgRecord msgRecord;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual(source, "get_last_db")) {
            AtomicBoolean atomicBoolean = this.hasSendMsg;
            List asMutableList = TypeIntrinsics.asMutableList(list);
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(asMutableList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator it = asMutableList.iterator();
            while (it.hasNext()) {
                arrayList.add(((AIOMsgItem) it.next()).getMsgRecord());
            }
            atomicBoolean.set(o81.a.b(arrayList));
            d().e().h(AssistedChatMsgIntent.OnLoadFirstScreenMsg.f348984d);
        }
        if (!z(list)) {
            return;
        }
        if (!this.hasSendMsg.get()) {
            AtomicBoolean atomicBoolean2 = this.hasSendMsg;
            List asMutableList2 = TypeIntrinsics.asMutableList(list);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(asMutableList2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = asMutableList2.iterator();
            while (it5.hasNext()) {
                arrayList2.add(((AIOMsgItem) it5.next()).getMsgRecord());
            }
            atomicBoolean2.set(o81.a.b(arrayList2));
        }
        this.lastMsgCount = list.size();
        v(TypeIntrinsics.asMutableList(list));
        s(TypeIntrinsics.asMutableList(list));
        C(TypeIntrinsics.asMutableList(list));
        AIOMsgItem t16 = t(list);
        Long l3 = null;
        if (t16 != null) {
            if (!A(t16, list)) {
                if (QLog.isColorLevel()) {
                    QLog.i("PrologueMsgAbility", 1, "beforeNotifyMsgChange removeAllPrologueMsg");
                }
                B(TypeIntrinsics.asMutableList(list));
            } else {
                y(t16, TypeIntrinsics.asMutableList(list));
                d().e().h(new AssistedChatMsgIntent.PrologueMsgVisibilityChange(true));
            }
        } else {
            t16 = null;
        }
        if (QLog.isColorLevel()) {
            if (t16 != null && (msgRecord = t16.getMsgRecord()) != null) {
                l3 = Long.valueOf(msgRecord.msgId);
            }
            QLog.i("PrologueMsgAbility", 2, "beforeNotifyMsgChange findFirstPrologueMsgItem: " + l3);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetCanShowPrologueMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.j();
        if (!w(d().g().r().c().e())) {
            return;
        }
        d().e().l(this, this.actionR);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.k();
            d().e().e(this);
        }
    }
}
