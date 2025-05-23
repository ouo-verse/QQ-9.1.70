package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel.QQStrangerMsgTopViewModel;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginEndEvent;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart;
import com.tencent.mobileqq.matchfriend.reborn.register.event.QQStrangerRegisterSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendItem;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u001bH\u0016R#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u001f*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/QQStrangerSurpriseMatchingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "G9", "L9", "R9", "Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;", "rsp", "K9", "T9", "", "H9", "content", "S9", "O9", "M9", "Q9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/QQStrangerSurpriseMatchingVM;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/QQStrangerSurpriseMatchingVM;", "viewModel", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/viewmodel/QQStrangerMsgTopViewModel;", "e", "I9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/viewmodel/QQStrangerMsgTopViewModel;", "msgTopViewModel", "f", "Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;", "recommendRsp", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/e;", tl.h.F, "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/e;", "matchingDialog", "", "i", "Z", "requestPending", "Ll82/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ll82/i;", "guideElement", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSurpriseMatchingPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy msgTopViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SurpriseMatchPB$RecommendRsp recommendRsp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e matchingDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean requestPending;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private l82.i guideElement;

    public QQStrangerSurpriseMatchingPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSurpriseMatchingVM>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSurpriseMatchingVM invoke() {
                return (QQStrangerSurpriseMatchingVM) QQStrangerSurpriseMatchingPart.this.getViewModel(QQStrangerSurpriseMatchingVM.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerMsgTopViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingPart$msgTopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerMsgTopViewModel invoke() {
                Object partHost = QQStrangerSurpriseMatchingPart.this.getPartHost();
                Fragment fragment = partHost instanceof Fragment ? (Fragment) partHost : null;
                ActivityResultCaller parentFragment = fragment != null ? fragment.getParentFragment() : null;
                IPartHost iPartHost = parentFragment instanceof IPartHost ? (IPartHost) parentFragment : null;
                if (iPartHost == null) {
                    iPartHost = QQStrangerSurpriseMatchingPart.this.getPartHost();
                }
                return (QQStrangerMsgTopViewModel) QQStrangerSurpriseMatchingPart.this.getViewModel(iPartHost, null, QQStrangerMsgTopViewModel.class);
            }
        });
        this.msgTopViewModel = lazy2;
    }

    private final void G9() {
        Activity activity;
        if (this.guideElement == null && (activity = getActivity()) != null) {
            l82.i iVar = new l82.i(activity);
            m82.a.f416439a.b().addElement(iVar);
            this.guideElement = iVar;
        }
        l82.i iVar2 = this.guideElement;
        if (iVar2 != null) {
            m82.a.f416439a.b().notifyGroupActivate(iVar2, RFWOrderElementManager.OrderMode.WAIT_MODE, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H9() {
        PBStringField pBStringField;
        SurpriseMatchPB$RecommendRsp surpriseMatchPB$RecommendRsp = this.recommendRsp;
        String str = (surpriseMatchPB$RecommendRsp == null || (pBStringField = surpriseMatchPB$RecommendRsp.cookies) == null) ? null : pBStringField.get();
        return str == null ? "" : str;
    }

    private final QQStrangerMsgTopViewModel I9() {
        return (QQStrangerMsgTopViewModel) this.msgTopViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSurpriseMatchingVM J9() {
        return (QQStrangerSurpriseMatchingVM) this.viewModel.getValue();
    }

    private final void L9() {
        l82.i iVar = this.guideElement;
        if (iVar != null) {
            m82.a.f416439a.b().inactivateElement(iVar);
        }
    }

    private final void M9() {
        L9();
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.i
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerSurpriseMatchingPart.N9(QQStrangerSurpriseMatchingPart.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QQStrangerSurpriseMatchingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
    }

    private final void O9() {
        L9();
        Q9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9() {
        if (I9().getHasRequest()) {
            return;
        }
        I9().Q1();
    }

    private final void R9() {
        l82.i iVar = this.guideElement;
        if (iVar != null) {
            m82.a.f416439a.b().removeElement(iVar);
            this.guideElement = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String content) {
        List<Long> list;
        PBRepeatMessageField<SurpriseMatchPB$RecommendItem> pBRepeatMessageField;
        List<SurpriseMatchPB$RecommendItem> list2;
        int collectionSizeOrDefault;
        SurpriseMatchPB$RecommendRsp surpriseMatchPB$RecommendRsp = this.recommendRsp;
        if (surpriseMatchPB$RecommendRsp == null || (pBRepeatMessageField = surpriseMatchPB$RecommendRsp.items) == null || (list2 = pBRepeatMessageField.get()) == null) {
            list = null;
        } else {
            List<SurpriseMatchPB$RecommendItem> list3 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((SurpriseMatchPB$RecommendItem) it.next()).user_info.tiny_id.get()));
            }
            list = CollectionsKt___CollectionsKt.take(arrayList, 3);
        }
        List<Long> list4 = list;
        if (list4 == null || list4.isEmpty()) {
            return;
        }
        J9().Q1(list, content);
    }

    private final void T9(SurpriseMatchPB$RecommendRsp rsp) {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        e eVar = new e(activity, rsp, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingPart$showDialog$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QQStrangerSurpriseMatchingVM J9;
                String H9;
                Intrinsics.checkNotNullParameter(it, "it");
                QQStrangerSurpriseMatchingPart.this.S9(it);
                J9 = QQStrangerSurpriseMatchingPart.this.J9();
                H9 = QQStrangerSurpriseMatchingPart.this.H9();
                J9.N1(2, H9);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        eVar.setCanceledOnTouchOutside(true);
        eVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                QQStrangerSurpriseMatchingPart.U9(QQStrangerSurpriseMatchingPart.this, dialogInterface);
            }
        });
        eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QQStrangerSurpriseMatchingPart.V9(QQStrangerSurpriseMatchingPart.this, dialogInterface);
            }
        });
        eVar.show();
        this.matchingDialog = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QQStrangerSurpriseMatchingPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9().N1(1, this$0.H9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QQStrangerSurpriseMatchingPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        MutableLiveData<SurpriseMatchPB$RecommendRsp> M1 = J9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<SurpriseMatchPB$RecommendRsp, Unit> function1 = new Function1<SurpriseMatchPB$RecommendRsp, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurpriseMatchPB$RecommendRsp surpriseMatchPB$RecommendRsp) {
                invoke2(surpriseMatchPB$RecommendRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurpriseMatchPB$RecommendRsp surpriseMatchPB$RecommendRsp) {
                QQStrangerSurpriseMatchingPart.this.K9(surpriseMatchPB$RecommendRsp);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSurpriseMatchingPart.P9(Function1.this, obj);
            }
        });
        if (!QQStrangerLoginPart.INSTANCE.a().get()) {
            this.requestPending = true;
            G9();
        } else if (QQStrangerGuestHelper.f245363a.c()) {
            G9();
            J9().P1();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        e eVar = this.matchingDialog;
        if (eVar != null && eVar.isShowing()) {
            eVar.dismiss();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("QQStrangerSurpriseMatchingPart", 1, "onReceiveEvent " + event);
        if (event instanceof QQStrangerLoginEndEvent) {
            if (this.requestPending) {
                this.requestPending = false;
                if (QQStrangerGuestHelper.f245363a.c()) {
                    J9().P1();
                    return;
                } else {
                    L9();
                    return;
                }
            }
            return;
        }
        if (event instanceof QQStrangerRegisterSuccessEvent) {
            R9();
            G9();
            J9().P1();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerLoginEndEvent.class, QQStrangerRegisterSuccessEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(SurpriseMatchPB$RecommendRsp rsp) {
        PBRepeatField<String> pBRepeatField;
        PBRepeatMessageField<SurpriseMatchPB$RecommendItem> pBRepeatMessageField;
        if (rsp != null && !rsp.items.isEmpty() && !rsp.greet_text.isEmpty()) {
            this.recommendRsp = rsp;
            T9(rsp);
            return;
        }
        Integer num = null;
        Integer valueOf = (rsp == null || (pBRepeatMessageField = rsp.items) == null) ? null : Integer.valueOf(pBRepeatMessageField.size());
        if (rsp != null && (pBRepeatField = rsp.greet_text) != null) {
            num = Integer.valueOf(pBRepeatField.size());
        }
        QLog.d("QQStrangerSurpriseMatchingPart", 1, "handleRecommend do not need show dialog, itemSize=" + valueOf + " greetSize=" + num);
        O9();
    }
}
