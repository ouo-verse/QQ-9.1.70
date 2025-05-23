package com.qzone.reborn.groupalbum.part.albumdetail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R#\u0010/\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumdetail/GroupAlbumAlbumDetailPlusMenuPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "hasRight", "needHide", "", "X9", "T9", "Landroid/view/View;", "view", "", AdMetricTag.EVENT_NAME, "N9", "M9", "fromArk", "Q9", "P9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "d", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "getInitBean", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "initBean", "e", "Landroid/view/View;", "btnPlus", "f", "Z", "shouldAutoJump", tl.h.F, "hasUpLoadRight", "i", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "albumDetailViewModel", "Lcom/qzone/reborn/groupalbum/viewmodel/h;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "O9", "()Lcom/qzone/reborn/groupalbum/viewmodel/h;", "operateVm", "<init>", "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumDetailPlusMenuPart extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy operateVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GroupAlbumAlbumDetailInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View btnPlus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean shouldAutoJump;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasUpLoadRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needHide;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.b albumDetailViewModel;

    public GroupAlbumAlbumDetailPlusMenuPart(GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean) {
        Lazy lazy;
        this.initBean = groupAlbumAlbumDetailInitBean;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.groupalbum.viewmodel.h>() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailPlusMenuPart$operateVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.groupalbum.viewmodel.h invoke() {
                return (com.qzone.reborn.groupalbum.viewmodel.h) GroupAlbumAlbumDetailPlusMenuPart.this.getViewModel(com.qzone.reborn.groupalbum.viewmodel.h.class);
            }
        });
        this.operateVm = lazy;
    }

    private final com.qzone.reborn.groupalbum.viewmodel.h O9() {
        return (com.qzone.reborn.groupalbum.viewmodel.h) this.operateVm.getValue();
    }

    private final void P9() {
        String str;
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumDetailViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
            bVar = null;
        }
        CommonAlbumInfo value = bVar.M1().getValue();
        if (value == null) {
            RFWLog.w("QZoneIntimateAlbumPlusMenuPart", RFWLog.USR, "albumInfo is null ");
            return;
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean == null || (str = groupAlbumAlbumDetailInitBean.getGroupId()) == null) {
            str = "";
        }
        GroupChatHistoryMediaSelectInitBean groupChatHistoryMediaSelectInitBean = new GroupChatHistoryMediaSelectInitBean(str, value, 3);
        oi.c m3 = ho.i.m();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        m3.b(activity, 0, groupChatHistoryMediaSelectInitBean);
    }

    private final void Q9(boolean fromArk) {
        String str;
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumDetailViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
            bVar = null;
        }
        CommonAlbumInfo value = bVar.M1().getValue();
        if (value == null) {
            RFWLog.w("QZoneIntimateAlbumPlusMenuPart", RFWLog.USR, "albumInfo is null ");
            return;
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean == null || (str = groupAlbumAlbumDetailInitBean.getGroupId()) == null) {
            str = "";
        }
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(str, 0, true, value, 3);
        groupUploadAlbumInitBean.setFromArk(fromArk);
        oi.c m3 = ho.i.m();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m3.n(context, groupUploadAlbumInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f132934r);
        actionSheet.addButton(R.string.f132944s);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.j
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GroupAlbumAlbumDetailPlusMenuPart.U9(ActionSheet.this, this, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAlbumAlbumDetailPlusMenuPart.V9(ActionSheet.this, view);
            }
        });
        actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.l
            @Override // com.tencent.widget.ActionSheet.onPreShowListener
            public final void onPreShow() {
                GroupAlbumAlbumDetailPlusMenuPart.W9(ActionSheet.this, this);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(ActionSheet actionSheet, GroupAlbumAlbumDetailPlusMenuPart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = actionSheet.getRootView().findViewById(R.id.f163931ct);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        if (i3 == 0) {
            this$0.M9(linearLayout.getChildAt(0), "em_qz_plus_select_local_album");
            this$0.Q9(false);
            actionSheet.dismiss();
        } else {
            if (i3 != 1) {
                return;
            }
            this$0.M9(linearLayout.getChildAt(1), "em_qz_plus_select_chat_Import");
            this$0.P9();
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(ActionSheet actionSheet, GroupAlbumAlbumDetailPlusMenuPart this$0) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = actionSheet.getRootView().findViewById(R.id.f163931ct);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this$0.N9(linearLayout.getChildAt(0), "em_qz_plus_select_local_album");
        this$0.N9(linearLayout.getChildAt(1), "em_qz_plus_select_chat_Import");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n9w) {
            if (!this.hasUpLoadRight) {
                ToastUtil.o(R.string.f133135a, 4);
            } else {
                T9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        boolean z16 = false;
        if (groupAlbumAlbumDetailInitBean != null && groupAlbumAlbumDetailInitBean.getAction() == 1) {
            z16 = true;
        }
        this.shouldAutoJump = z16;
        if (rootView != null) {
            l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, rootView, null);
            com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
            Intrinsics.checkNotNull(Ne, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.viewmodel.GroupAlbumAlbumDetailViewModel");
            this.albumDetailViewModel = (com.qzone.reborn.groupalbum.viewmodel.b) Ne;
            View findViewById = rootView.findViewById(R.id.n9w);
            findViewById.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026usMenuPart)\n            }");
            this.btnPlus = findViewById;
            findViewById.setVisibility(8);
            com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumDetailViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumDetailViewModel");
                bVar = null;
            }
            MutableLiveData<ArrayList<Integer>> T1 = bVar.T1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<ArrayList<Integer>, Unit> function1 = new Function1<ArrayList<Integer>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailPlusMenuPart$onInitView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Integer> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<Integer> arrayList) {
                    boolean z17;
                    boolean z18;
                    GroupAlbumAlbumDetailPlusMenuPart.this.hasUpLoadRight = arrayList.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
                    GroupAlbumAlbumDetailPlusMenuPart groupAlbumAlbumDetailPlusMenuPart = GroupAlbumAlbumDetailPlusMenuPart.this;
                    z17 = groupAlbumAlbumDetailPlusMenuPart.hasUpLoadRight;
                    z18 = GroupAlbumAlbumDetailPlusMenuPart.this.needHide;
                    groupAlbumAlbumDetailPlusMenuPart.X9(z17, z18);
                }
            };
            T1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumAlbumDetailPlusMenuPart.R9(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> d26 = O9().d2();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumAlbumDetailPlusMenuPart$onInitView$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    boolean z17;
                    boolean z18;
                    GroupAlbumAlbumDetailPlusMenuPart groupAlbumAlbumDetailPlusMenuPart = GroupAlbumAlbumDetailPlusMenuPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    groupAlbumAlbumDetailPlusMenuPart.needHide = it.booleanValue();
                    GroupAlbumAlbumDetailPlusMenuPart groupAlbumAlbumDetailPlusMenuPart2 = GroupAlbumAlbumDetailPlusMenuPart.this;
                    z17 = groupAlbumAlbumDetailPlusMenuPart2.hasUpLoadRight;
                    z18 = GroupAlbumAlbumDetailPlusMenuPart.this.needHide;
                    groupAlbumAlbumDetailPlusMenuPart2.X9(z17, z18);
                }
            };
            d26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumAlbumDetailPlusMenuPart.S9(Function1.this, obj);
                }
            });
            View view = this.btnPlus;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
                view = null;
            }
            fo.c.o(view, "em_qz_publish_button_master_mode", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(boolean hasRight, boolean needHide) {
        View view = null;
        if (!needHide) {
            View view2 = this.btnPlus;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.btnPlus;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPlus");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void M9(View view, String eventName) {
        if (view == null) {
            return;
        }
        fo.c.l(view, getPartRootView());
        fo.c.e(eventName, "pg_qz_group_album_details", view, null);
    }

    private final void N9(View view, String eventName) {
        if (view == null) {
            return;
        }
        fo.c.l(view, getPartRootView());
        fo.c.g(eventName, "pg_qz_group_album_details", view, null);
    }
}
