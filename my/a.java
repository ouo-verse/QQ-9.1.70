package my;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ny.e;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lmy/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "d", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "mDragFrameLayout", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecycleView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "f", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "mSmartRefreshView", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", h.F, "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "i", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "mChatsVB", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "mRepo", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DragFrameLayout mDragFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mRecycleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SmartRefreshLayout mSmartRefreshView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ChatsListVB mChatsVB;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IRecentContactRepo mRepo;

    private final void x9() {
        this.mRepo = new e();
        IChatsViewModelCreator iChatsViewModelCreator = (IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class);
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(hostFragment);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IRecentContactRepo iRecentContactRepo = this.mRepo;
        IRecentContactRepo iRecentContactRepo2 = null;
        if (iRecentContactRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepo");
            iRecentContactRepo = null;
        }
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) iChatsViewModelCreator.createServiceAccountFolderViewModel(lifecycleScope, context, iRecentContactRepo);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        ChatsListVB chatsListVB = new ChatsListVB(aVar, new com.tencent.qqnt.chats.biz.serviceaccountfolder.b());
        this.mChatsVB = chatsListVB;
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB2 = null;
        }
        chatsListVB.o0(new c(chatsListVB2.u()));
        ChatsListVB chatsListVB3 = this.mChatsVB;
        if (chatsListVB3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB3 = null;
        }
        RecyclerView recyclerView = this.mRecycleView;
        Intrinsics.checkNotNull(recyclerView);
        DragFrameLayout dragFrameLayout = this.mDragFrameLayout;
        Intrinsics.checkNotNull(dragFrameLayout);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        chatsListVB3.d0(new ChatsListVB.b(recyclerView, dragFrameLayout, null, context2, this.mSmartRefreshView, null, null, null, 192, null));
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        ChatsListVB chatsListVB4 = this.mChatsVB;
        if (chatsListVB4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB4 = null;
        }
        aVar2.d(chatsListVB4);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        aVar3.o(b.c.f355083a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar4 = null;
        }
        ChatsListVB chatsListVB5 = this.mChatsVB;
        if (chatsListVB5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            chatsListVB5 = null;
        }
        aVar4.p(chatsListVB5.v());
        IRecentContactRepo iRecentContactRepo3 = this.mRepo;
        if (iRecentContactRepo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepo");
        } else {
            iRecentContactRepo2 = iRecentContactRepo3;
        }
        iRecentContactRepo2.create();
    }

    private final void z9(View rootView) {
        DragFrameLayout dragFrameLayout;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout = null;
        if (rootView != null) {
            dragFrameLayout = (DragFrameLayout) rootView.findViewById(R.id.evx);
        } else {
            dragFrameLayout = null;
        }
        this.mDragFrameLayout = dragFrameLayout;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.tug);
        } else {
            recyclerView = null;
        }
        this.mRecycleView = recyclerView;
        if (rootView != null) {
            smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.f72183q6);
        }
        this.mSmartRefreshView = smartRefreshLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        z9(rootView);
        x9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QLog.d("ServiceAccountFolderDataListPart", 1, "onPartDestroy------++");
        IRecentContactRepo iRecentContactRepo = this.mRepo;
        ChatsListVB chatsListVB = null;
        if (iRecentContactRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepo");
            iRecentContactRepo = null;
        }
        iRecentContactRepo.destroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            chatsListVB = chatsListVB2;
        }
        aVar2.m(chatsListVB);
        ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
        serviceAccountFolderNTManager.t();
        serviceAccountFolderNTManager.s();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        ChatsListVB chatsListVB = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            chatsListVB = chatsListVB2;
        }
        com.tencent.qqnt.chats.api.b v3 = chatsListVB.v();
        if (v3 != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            v3.u(rootView);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        ChatsListVB chatsListVB = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
        ChatsListVB chatsListVB2 = this.mChatsVB;
        if (chatsListVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            chatsListVB = chatsListVB2;
        }
        com.tencent.qqnt.chats.api.b v3 = chatsListVB.v();
        if (v3 != null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            b.C9561b.a(v3, rootView, "", 1, null, 8, null);
        }
    }
}
