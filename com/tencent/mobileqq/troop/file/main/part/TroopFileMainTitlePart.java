package com.tencent.mobileqq.troop.file.main.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.file.main.vm.a;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "N9", "", "id", "U9", "", "text", "V9", "K9", "F9", "G9", "L9", "q8", "", "uploadCount", "T9", "onInitView", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "J9", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "", "e", "Z", "isSelectMode", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "f", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "uploadNumBadge", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "uploadNumLayout", "I9", "()I", "from", "H9", "()Ljava/lang/String;", "folderName", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainTitlePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIBadge uploadNumBadge;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout uploadNumLayout;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/file/main/part/TroopFileMainTitlePart$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCheckable(true);
            info.setChecked(TroopFileMainTitlePart.this.isSelectMode);
        }
    }

    public TroopFileMainTitlePart(TroopFileMainVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final void F9() {
        broadcastMessage("show_popup_menu", Unit.INSTANCE);
    }

    private final void G9() {
        if (!this.isSelectMode) {
            broadcastMessage("enter_select_mode", Unit.INSTANCE);
        } else {
            broadcastMessage("exit_select_mode", Unit.INSTANCE);
        }
    }

    private final String H9() {
        return this.viewModel.T1().folderName;
    }

    private final int I9() {
        return this.viewModel.T1().from;
    }

    private final void K9() {
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.viewModel.T1().troopUinStr);
        intent.putExtra(TagName.FILE_TYPE, -1);
        ITroopFileApi iTroopFileApi = (ITroopFileApi) QRoute.api(ITroopFileApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iTroopFileApi.openTroopFileUploadPage(activity, intent);
    }

    private final void L9() {
        MutableLiveData<com.tencent.mobileqq.troop.file.main.vm.a> obtainUiState = this.viewModel.obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainTitlePart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.file.main.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.file.main.vm.a aVar) {
                if (aVar instanceof a.d) {
                    TroopFileMainTitlePart.this.T9(((a.d) aVar).getUploadCount());
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.file.main.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFileMainTitlePart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9(View rootView) {
        boolean contains;
        boolean z16 = I9() == 1000;
        contains = ArraysKt___ArraysKt.contains(new Integer[]{1000, 4000, 5000, 6000}, Integer.valueOf(I9()));
        boolean z17 = true ^ contains;
        TextView textView = (TextView) rootView.findViewById(R.id.ivTitleBtnRightText);
        Boolean valueOf = Boolean.valueOf(z16);
        textView.setVisibility(0);
        if (((View) au.a(valueOf, textView)) == null) {
            textView.setVisibility(8);
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f172815uf3));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileMainTitlePart.O9(TroopFileMainTitlePart.this, view);
            }
        });
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ivTitleBtnRightImage);
        Boolean valueOf2 = Boolean.valueOf(z17);
        imageView.setVisibility(0);
        if (((View) au.a(valueOf2, imageView)) == null) {
            imageView.setVisibility(8);
        }
        imageView.setImageResource(R.drawable.qui_transmission_file_icon_navigation_01);
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileMainTitlePart.P9(TroopFileMainTitlePart.this, view);
            }
        });
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.dsn);
        imageView2.setVisibility(0);
        Drawable f16 = cn.f(getActivity().getDrawable(R.drawable.qui_list_select));
        if (f16 != null) {
            f16.setColorFilter(new LightingColorFilter(0, getActivity().getColor(R.color.qui_common_icon_nav_primary)));
        }
        imageView2.setImageDrawable(f16);
        imageView2.setBackground(null);
        imageView2.setContentDescription(HardCodeUtil.qqStr(R.string.ufp));
        imageView2.setAccessibilityDelegate(new a());
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileMainTitlePart.Q9(TroopFileMainTitlePart.this, view);
            }
        });
        IPartHost partHost = getPartHost();
        QIphoneTitleBarFragment qIphoneTitleBarFragment = partHost instanceof QIphoneTitleBarFragment ? (QIphoneTitleBarFragment) partHost : null;
        TextView textView2 = qIphoneTitleBarFragment != null ? qIphoneTitleBarFragment.centerView : null;
        if (textView2 == null) {
            return;
        }
        textView2.setMaxWidth(com.tencent.mobileqq.util.x.c(getActivity(), 180.0f));
        imageView2.setAccessibilityTraversalAfter(textView2.getId());
        imageView.setAccessibilityTraversalAfter(imageView2.getId());
        imageView.setAccessibilityTraversalBefore(R.id.jyd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(TroopFileMainTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().setResult(-1);
        this$0.getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(TroopFileMainTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopFileMainTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(TroopFileMainTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(int[] uploadCount) {
        RelativeLayout relativeLayout = null;
        if (!(uploadCount.length == 0) && uploadCount[0] > 0) {
            RelativeLayout relativeLayout2 = this.uploadNumLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadNumLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(0);
            QUIBadge qUIBadge = this.uploadNumBadge;
            if (qUIBadge == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadNumBadge");
                qUIBadge = null;
            }
            qUIBadge.setRedNum(uploadCount[0]);
            RelativeLayout relativeLayout3 = this.uploadNumLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadNumLayout");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setContentDescription("\u4e0a\u4f20\u5217\u8868\uff0c\u6570\u91cf" + uploadCount[0]);
            return;
        }
        RelativeLayout relativeLayout4 = this.uploadNumLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadNumLayout");
        } else {
            relativeLayout = relativeLayout4;
        }
        relativeLayout.setVisibility(8);
    }

    private final void U9(int id5) {
        IPartHost partHost = getPartHost();
        QIphoneTitleBarFragment qIphoneTitleBarFragment = partHost instanceof QIphoneTitleBarFragment ? (QIphoneTitleBarFragment) partHost : null;
        if (qIphoneTitleBarFragment != null) {
            qIphoneTitleBarFragment.setLeftViewName(id5);
        }
    }

    private final void V9(String text) {
        IPartHost partHost = getPartHost();
        QIphoneTitleBarFragment qIphoneTitleBarFragment = partHost instanceof QIphoneTitleBarFragment ? (QIphoneTitleBarFragment) partHost : null;
        if (qIphoneTitleBarFragment != null) {
            qIphoneTitleBarFragment.setTitle(text);
        }
    }

    private final void q8() {
        BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainTitlePart$refreshUploadCount$1(this, null), 3, null);
    }

    /* renamed from: J9, reason: from getter */
    public final TroopFileMainVM getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "exit_select_mode")) {
            this.isSelectMode = false;
        } else if (Intrinsics.areEqual(action, "enter_select_mode")) {
            this.isSelectMode = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        q8();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        if (this.isSelectMode) {
            broadcastMessage("exit_select_mode", Unit.INSTANCE);
        }
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.gjf);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(0, R.id.dsn);
        layoutParams2.rightMargin = com.tencent.mobileqq.util.x.c(getActivity(), 0.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileMainTitlePart.S9(TroopFileMainTitlePart.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Re\u2026loadingPage() }\n        }");
        this.uploadNumLayout = relativeLayout;
        View findViewById2 = rootView.findViewById(R.id.gjh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qb_troop_upload_num)");
        QUIBadge qUIBadge = (QUIBadge) findViewById2;
        this.uploadNumBadge = qUIBadge;
        QUIBadge qUIBadge2 = null;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadNumBadge");
            qUIBadge = null;
        }
        qUIBadge.setDragType(-1);
        N9(rootView);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.gib);
        imageView.setBackgroundResource(R.drawable.qui_upload);
        V9(bc.f(this, R.string.ew9));
        U9(R.string.button_back);
        if (I9() == 2000 && !TextUtils.isEmpty(H9())) {
            V9(H9());
            U9(R.string.ew9);
            return;
        }
        if (I9() == 4000 || I9() == 6000) {
            RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.rlCommenTitle);
            relativeLayout2.findViewById(R.id.ivTitleName).setVisibility(4);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.ai8, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.title)).setText(R.string.eqz);
            TextView textView = (TextView) inflate.findViewById(R.id.title_sub);
            textView.setText(bc.f(this, R.string.ewi) + this.viewModel.T1().filterName);
            textView.setMaxWidth(com.tencent.mobileqq.util.x.c(getActivity(), 200.0f));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(13);
            relativeLayout2.addView(inflate, layoutParams3);
            imageView.setVisibility(8);
            QUIBadge qUIBadge3 = this.uploadNumBadge;
            if (qUIBadge3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uploadNumBadge");
            } else {
                qUIBadge2 = qUIBadge3;
            }
            qUIBadge2.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView == null) {
            return;
        }
        R9(rootView);
        L9();
        q8();
    }
}
