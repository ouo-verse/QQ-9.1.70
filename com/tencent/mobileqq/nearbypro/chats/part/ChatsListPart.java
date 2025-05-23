package com.tencent.mobileqq.nearbypro.chats.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPart;", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "", "initViewModel", "", "name", "Lorg/json/JSONObject;", "data", "J9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartResume", "onPartPause", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "f", "Lcom/tencent/qqnt/chats/core/mvi/a;", "H9", "()Lcom/tencent/qqnt/chats/core/mvi/a;", "L9", "(Lcom/tencent/qqnt/chats/core/mvi/a;)V", "mChatsVM", "Lla2/a;", h.F, "Lla2/a;", "G9", "()Lla2/a;", "K9", "(Lla2/a;)V", "mChatsVB", "Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "i", "Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "I9", "()Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "M9", "(Lcom/tencent/qqnt/chats/core/adapter/preload/a;)V", "mainPreLoader", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasPause", "Landroid/content/BroadcastReceiver;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/BroadcastReceiver;", "kuiklyBroadcastReceiver", "<init>", "()V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatsListPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BroadcastReceiver kuiklyBroadcastReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public la2.a mChatsVB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.qqnt.chats.core.adapter.preload.a mainPreLoader;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasPause;

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(String name, JSONObject data) {
        if (Intrinsics.areEqual(name, "NEARBY_CLOSE_MSG_PAGE_EVENT")) {
            getActivity().finish();
        }
    }

    private final void initViewModel() {
        L9((com.tencent.qqnt.chats.core.mvi.a) ((IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class)).createNearbyProViewModel(z9(), B9()));
    }

    @NotNull
    public final la2.a G9() {
        la2.a aVar = this.mChatsVB;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        return null;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> H9() {
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        return null;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.adapter.preload.a I9() {
        com.tencent.qqnt.chats.core.adapter.preload.a aVar = this.mainPreLoader;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainPreLoader");
        return null;
    }

    public final void K9(@NotNull la2.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mChatsVB = aVar;
    }

    public final void L9(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mChatsVM = aVar;
    }

    public final void M9(@NotNull com.tencent.qqnt.chats.core.adapter.preload.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mainPreLoader = aVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ChatsListPart";
    }

    @Override // com.tencent.mobileqq.nearbypro.chats.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        H9().o(b.g.f355087a);
        initViewModel();
        G9().h(H9());
        H9().o(b.f.f355086a);
        RecyclerView.Adapter adapter = A9().getChatsList().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initViewModel();
        K9(new la2.a(H9(), new ia2.a()));
        la2.a G9 = G9();
        RecyclerView chatsList = A9().getChatsList();
        DragFrameLayout dragArea = A9().getDragArea();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        G9.d0(new ChatsListVB.b(chatsList, dragArea, null, context, A9().getRefreshView().getLayout(), A9().getRecyclerScroll(), null, null, 192, null));
        com.tencent.qqnt.chats.core.adapter.preload.a aVar = new com.tencent.qqnt.chats.core.adapter.preload.a();
        Intrinsics.checkNotNull(rootView);
        Context context2 = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView!!.context");
        aVar.c(context2, z9());
        M9(aVar);
        x9(G9());
        H9().o(b.c.f355083a);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListPart$onPartCreate$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                boolean z16;
                JSONObject jSONObject = null;
                if (intent != null) {
                    str = l.a(intent);
                } else {
                    str = null;
                }
                if (intent != null) {
                    jSONObject = l.b(intent);
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ChatsListPart.this.J9(str, jSONObject);
                }
            }
        };
        this.kuiklyBroadcastReceiver = broadcastReceiver;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            l.c(context, broadcastReceiver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        H9().o(b.d.f355084a);
        G9().e0();
        I9().e();
        BroadcastReceiver broadcastReceiver = this.kuiklyBroadcastReceiver;
        if (broadcastReceiver != null) {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
            this.kuiklyBroadcastReceiver = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPause = true;
        j.c().e("ChatsListPart", "onPartPause");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        H9().o(b.i.f355089a);
        if (this.hasPause) {
            G9().A0();
        }
        j.c().e("ChatsListPart", "onPartResume");
    }
}
