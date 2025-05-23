package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainFragmentRightEvent;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.qzone.util.ToastUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0#j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$`%H\u0016R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/t;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Q9", "Landroid/view/View;", "view", "", AdMetricTag.EVENT_NAME, "J9", "I9", "", "", "K9", "O9", "N9", "", "flag", "", "from", "L9", "show", "U9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/lang/String;", "TAG", "e", "Ljava/lang/Boolean;", "hasRight", "f", "Landroid/view/View;", "ivPlusBtn", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", tl.h.F, "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "mTabViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "GroupAlbumPlusMenuPart";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Boolean hasRight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View ivPlusBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private aj mTabViewModel;

    private final void L9(final boolean flag, final int from) {
        runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.o
            @Override // java.lang.Runnable
            public final void run() {
                t.M9(from, this, flag);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(int i3, t this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.hasRight = Boolean.valueOf(z16);
            com.qzone.reborn.util.i b16 = com.qzone.reborn.util.i.b();
            aj ajVar = this$0.mTabViewModel;
            if (ajVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
                ajVar = null;
            }
            b16.l("group_album_upload_right_" + ajVar.P1().getGroupId(), z16);
        }
        Boolean bool = this$0.hasRight;
        if (bool != null) {
            this$0.U9(Intrinsics.areEqual(bool, Boolean.TRUE));
        }
    }

    private final void N9() {
        aj ajVar = this.mTabViewModel;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        int mTabIndex = ajVar.getMTabIndex();
        int i3 = mTabIndex != 0 ? mTabIndex != 1 ? 0 : 2 : 1;
        aj ajVar2 = this.mTabViewModel;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar2 = null;
        }
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean = new GroupChatHistoryMediaSelectInitBean(ajVar2.P1().getGroupId(), null, i3);
        oi.c m3 = ho.i.m();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        m3.b(activity, 0, groupChatHistoryMediaSelectInitBean);
    }

    private final void O9() {
        aj ajVar = this.mTabViewModel;
        aj ajVar2 = null;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        int mTabIndex = ajVar.getMTabIndex();
        int i3 = mTabIndex != 0 ? mTabIndex != 1 ? 0 : 2 : 1;
        aj ajVar3 = this.mTabViewModel;
        if (ajVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
        } else {
            ajVar2 = ajVar3;
        }
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(ajVar2.P1().getGroupId(), 0, true, null, i3);
        oi.c m3 = ho.i.m();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m3.n(context, groupUploadAlbumInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(t this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.hasRight, Boolean.FALSE)) {
            ToastUtil.o(R.string.f133135a, 4);
        } else {
            this$0.Q9();
            fo.c.e("em_qz_publish_button_master_mode", "pg_qz_group_dynamic_tab", view, this$0.K9());
        }
    }

    private final void Q9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f132934r);
        actionSheet.addButton(R.string.f132944s);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.groupalbum.part.p
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                t.R9(ActionSheet.this, this, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.S9(ActionSheet.this, view);
            }
        });
        actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.qzone.reborn.groupalbum.part.r
            @Override // com.tencent.widget.ActionSheet.onPreShowListener
            public final void onPreShow() {
                t.T9(ActionSheet.this, this);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(ActionSheet actionSheet, t this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = actionSheet.getRootView().findViewById(R.id.f163931ct);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        if (i3 == 0) {
            this$0.I9(linearLayout.getChildAt(0), "em_qz_plus_select_local_album");
            this$0.O9();
            actionSheet.dismiss();
        } else {
            if (i3 != 1) {
                return;
            }
            this$0.I9(linearLayout.getChildAt(1), "em_qz_plus_select_chat_Import");
            this$0.N9();
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(ActionSheet actionSheet, t this$0) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = actionSheet.getRootView().findViewById(R.id.f163931ct);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this$0.J9(linearLayout.getChildAt(0), "em_qz_plus_select_local_album");
        this$0.J9(linearLayout.getChildAt(1), "em_qz_plus_select_chat_Import");
    }

    private final void U9(boolean show) {
        View view = this.ivPlusBtn;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            view = null;
        }
        if (view.getVisibility() != 0) {
            View view3 = this.ivPlusBtn;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
                view3 = null;
            }
            view3.post(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.s
                @Override // java.lang.Runnable
                public final void run() {
                    t.V9(t.this);
                }
            });
            View view4 = this.ivPlusBtn;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            } else {
                view2 = view4;
            }
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(t this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.ivPlusBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            view = null;
        }
        fo.c.g("em_qz_publish_button_master_mode", "pg_qz_group_dynamic_tab", view, this$0.K9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.n9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_publish_plus_btn)");
        this.ivPlusBtn = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
            findViewById = null;
        }
        findViewById.setVisibility(8);
        View view2 = this.ivPlusBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPlusBtn");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                t.P9(t.this, view3);
            }
        });
        ViewModel viewModel = getViewModel(aj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumM\u2026TabViewModel::class.java)");
        this.mTabViewModel = (aj) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.qzone.reborn.util.i b16 = com.qzone.reborn.util.i.b();
        aj ajVar = this.mTabViewModel;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        b16.t("group_album_upload_right_" + ajVar.P1().getGroupId());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumMainFragmentRightEvent) {
            GroupAlbumMainFragmentRightEvent groupAlbumMainFragmentRightEvent = (GroupAlbumMainFragmentRightEvent) event;
            L9(groupAlbumMainFragmentRightEvent.getHasUpLoadRight(), groupAlbumMainFragmentRightEvent.getFrom());
        }
    }

    private final Map<String, Object> K9() {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[1];
        aj ajVar = this.mTabViewModel;
        aj ajVar2 = null;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        pairArr[0] = TuplesKt.to("group_uin", ajVar.P1().getGroupId());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        aj ajVar3 = this.mTabViewModel;
        if (ajVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
        } else {
            ajVar2 = ajVar3;
        }
        if (ajVar2.getMTabIndex() == 0) {
            mutableMapOf.put("source", 0);
        } else {
            mutableMapOf.put("source", 1);
        }
        return mutableMapOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumMainFragmentRightEvent.class);
        return arrayListOf;
    }

    private final void I9(View view, String eventName) {
        if (view == null) {
            return;
        }
        fo.c.l(view, getPartRootView());
        fo.c.e(eventName, "pg_qz_group_dynamic_tab", view, K9());
    }

    private final void J9(View view, String eventName) {
        if (view == null) {
            return;
        }
        fo.c.l(view, getPartRootView());
        fo.c.g(eventName, "pg_qz_group_dynamic_tab", view, K9());
    }
}
