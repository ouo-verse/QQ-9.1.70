package com.tencent.square.debugger;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.square.debugger.DemoRecordMp4Fragment;
import com.tencent.state.SquareDebug;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.Gender;
import com.tencent.state.data.Image;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.focus.FocusGroupFragment;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.map.Location;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.OpenHippyParams;
import com.tencent.state.square.api.SquareHippyConst;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.detail.MultiMotionInviteFragment;
import com.tencent.state.square.friendsetting.SettingTipsController;
import com.tencent.state.square.mayknow.VasMayKnowFragment;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.data.UserStatus;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.CircleProgressDrawable;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import com.tencent.state.view.SquareImageView;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.zplan.utils.ZPlanConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bH\u0002J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/square/debugger/SquareDemoFragment;", "Lcom/tencent/square/debugger/BaseDebugFragment;", "", "yh", "xh", "uh", "", TuxUIConstants.POP_BTN_TEXT, "editText", "", "justNum", "Lkotlin/Function1;", "Lcom/tencent/square/debugger/a;", "callback", "vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "sh", "wh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "D", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "tipsControl", "<init>", "()V", "E", "a", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class SquareDemoFragment extends BaseDebugFragment {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private SettingTipsController tipsControl = new SettingTipsController();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/square/debugger/SquareDemoFragment$a;", "", "Lcom/tencent/square/debugger/SquareDemoFragment;", "a", "", "BTN_MARGIN_H", "I", "BTN_MARGIN_V", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.square.debugger.SquareDemoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public final SquareDemoFragment a() {
            return new SquareDemoFragment();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/square/debugger/SquareDemoFragment$addEditItem$1$1$1$1", "com/tencent/square/debugger/SquareDemoFragment$$special$$inlined$apply$lambda$1", "com/tencent/square/debugger/SquareDemoFragment$$special$$inlined$apply$lambda$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout f373542d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f373543e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f373544f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function1 f373545h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f373546i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f373547m;

        b(LinearLayout linearLayout, a aVar, String str, Function1 function1, String str2, boolean z16) {
            this.f373542d = linearLayout;
            this.f373543e = aVar;
            this.f373544f = str;
            this.f373545h = function1;
            this.f373546i = str2;
            this.f373547m = z16;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f373545h.invoke(this.f373543e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = SquareDemoFragment.this.getContext();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context ?: return@addButton");
                OpenHippyParams openHippyParams = new OpenHippyParams(SquareHippyConst.SQUARE_HIPPY_BUNDLE_NAME, "vip.qq.com", "https://tq-act.vip.qq.com/index.bundle/hippyurl=/bless-detail?uin=910067435");
                ISquareHippyEngine hippyEngine = Square.INSTANCE.getConfig().getHippyEngine();
                Fragment parentFragment = SquareDemoFragment.this.getParentFragment();
                hippyEngine.openHippyPage(context, parentFragment != null ? parentFragment.getChildFragmentManager() : null, openHippyParams, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            SquareDemoFragment.this.tipsControl.remarkFlagOnlyDebug();
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon, it.getContext(), "\u91cd\u5236\u6210\u529f", 0, 4, null);
            SquareBaseKt.getSquareMMKV().clearAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                DemoRecordMp4Fragment.Companion companion = DemoRecordMp4Fragment.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(DemoRecordMp4Fragment.class, "Class.forName(\"com.tence\u2026r.DemoRecordMp4Fragment\")");
                Object newInstance = DemoRecordMp4Fragment.class.newInstance();
                if (!(newInstance instanceof Fragment)) {
                    newInstance = null;
                }
                Fragment fragment = (Fragment) newInstance;
                if (fragment != null) {
                    SquareDemoFragment.this.pushFragment(fragment);
                }
            } catch (Exception e16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), QBaseFragment.TAG, "DemoRecordMp4Activity.start thorw " + e16, null, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            xc4.a.f447783a.d(ZPlanConstant.f386195f.c());
            ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), SquareDemoFragment.this.getContext(), "\u6e05\u9664\u6210\u529f\uff0c\u8bf7\u6740\u8fdb\u7a0b\u91cd\u542f", 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SquareDemoFragment.this.pushFragment(VasMayKnowFragment.INSTANCE.newInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentManager supportFragmentManager;
            MultiMotionInviteFragment newInstance = MultiMotionInviteFragment.INSTANCE.newInstance("");
            Bundle bundle = new Bundle();
            bundle.putString("billNum", "1192309");
            Unit unit = Unit.INSTANCE;
            newInstance.setArguments(bundle);
            FragmentActivity activity = SquareDemoFragment.this.getActivity();
            FragmentTransaction beginTransaction = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.beginTransaction();
            if (beginTransaction != null) {
                beginTransaction.replace(R.id.pvw, newInstance);
            }
            if (beginTransaction != null) {
                beginTransaction.addToBackStack(null);
            }
            if (beginTransaction != null) {
                beginTransaction.commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SquareBaseKt.getSquareMMKV().clearAll();
            ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), SquareDemoFragment.this.getContext(), "\u5df2\u6e05\u9664\u6240\u6709\u6807\u8bc6\u4f4d", 0, 4, null);
        }
    }

    private final void uh() {
        StringBuilder sb5 = new StringBuilder();
        SquareDebug squareDebug = SquareDebug.INSTANCE;
        sb5.append(squareDebug.getCpuCoreNum() != -1 ? squareDebug.getCpuCoreNum() : 8);
        sb5.append('/');
        sb5.append(squareDebug.getCpuMaxFreq() != -1 ? squareDebug.getCpuMaxFreq() : 3000);
        sb5.append('/');
        sb5.append(squareDebug.getRamSize() != -1 ? squareDebug.getRamSize() : 8000);
        vh("\u8bbe\u7f6e\u914d\u7f6e\u53c2\u6570(\u6838\u6570/\u4e3b\u9891/\u5185\u5b58)", sb5.toString(), false, new Function1<a, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addConfigParams$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                String str;
                List split$default;
                Integer intOrNull;
                Integer intOrNull2;
                Integer intOrNull3;
                Editable text;
                Intrinsics.checkNotNullParameter(it, "it");
                EditText edittext = it.getEdittext();
                if (edittext == null || (text = edittext.getText()) == null || (str = text.toString()) == null) {
                    str = "8/3000/8000";
                }
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
                if (split$default.size() < 3) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), QBaseFragment.TAG, "size < 3", null, 4, null);
                    return;
                }
                SquareDebug squareDebug2 = SquareDebug.INSTANCE;
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(0));
                squareDebug2.setCpuCoreNum(intOrNull != null ? intOrNull.intValue() : 8);
                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(1));
                squareDebug2.setCpuMaxFreq(intOrNull2 != null ? intOrNull2.intValue() : 3000);
                intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(2));
                squareDebug2.setRamSize(intOrNull3 != null ? intOrNull3.intValue() : 8000);
            }
        });
    }

    private final void vh(String btnText, String editText, boolean justNum, Function1<? super a, Unit> callback) {
        a aVar = new a();
        LinearLayout mainView = getMainView();
        if (mainView != null) {
            LinearLayout linearLayout = new LinearLayout(mainView.getContext());
            aVar.c(linearLayout);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(-1);
            Button button = new Button(mainView.getContext());
            aVar.b(button);
            button.setText(btnText);
            button.setTextSize(12.0f);
            button.setIncludeFontPadding(false);
            button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            button.setOnClickListener(new b(mainView, aVar, btnText, callback, editText, justNum));
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(button);
            EditText editText2 = new EditText(mainView.getContext());
            aVar.d(editText2);
            editText2.setText(editText);
            editText2.setTextSize(12.0f);
            editText2.setIncludeFontPadding(false);
            if (justNum) {
                editText2.setInputType(2);
            }
            editText2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(editText2);
            mainView.addView(linearLayout);
        }
    }

    private final void xh() {
        vh("\u8bbe\u7f6e\u540c\u5c4f\u64ad\u653e\u6570\u91cf", String.valueOf(Square.INSTANCE.getConfig().getCommonUtils().getPlayCountIncludeMe()), true, new Function1<a, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addPlayCount$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                String str;
                Editable text;
                Intrinsics.checkNotNullParameter(it, "it");
                try {
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    EditText edittext = it.getEdittext();
                    if (edittext == null || (text = edittext.getText()) == null || (str = text.toString()) == null) {
                        str = "0";
                    }
                    commonUtils.setSquarePlayCountIncludeMe(Integer.parseInt(str));
                } catch (Exception e16) {
                    SquareBaseKt.getSquareLog().e(QBaseFragment.TAG, "addPlayCount err", e16);
                }
            }
        });
    }

    private final void yh() {
        wh();
        uh();
        ph("\u6253\u5f00\u534a\u5c4fhippy", new c());
        qh("\u64ad\u653e\u89c6\u9891\u5c55\u793a\u80cc\u666f\u5f00\u5173", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(Square.INSTANCE.getConfig().getCommonUtils().getSquareDebug());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Square.INSTANCE.getConfig().getCommonUtils().setSquareDebug(z16);
            }
        });
        qh("filament-\u8d44\u4ea7\u9875", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableFilamentDetail());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableFilamentDetail(z16);
                SquareSwitchUtils.INSTANCE.setEnableFilamentDetail(null);
            }
        });
        qh("filament-\u9996\u9875", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$6
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableFilamentIndex());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableFilamentIndex(z16);
                SquareSwitchUtils.INSTANCE.setEnableFilamentIndex(null);
            }
        });
        qh("filament-\u5ba2\u6001\u622a\u56fe", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$8
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableRecordGuest());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableRecordGuest(z16);
                SquareSwitchUtils.INSTANCE.setEnableRecordGuest(null);
            }
        });
        qh("filament-\u5730\u5757\u622a\u56fe", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$10
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableRecordLand());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableRecordLand(z16);
                SquareSwitchUtils.INSTANCE.setEnableRecordLand(null);
            }
        });
        qh("\u9996\u9875\u4f7f\u7528\u7f13\u5b58", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$12
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableIndexUseCache());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableIndexUseCache(z16);
                SquareSwitchUtils.INSTANCE.setEnableIndexUseCache(null);
            }
        });
        qh("\u5730\u5757\u4f7f\u7528\u7f13\u5b58", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$14
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableChatLandUseCache());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$15
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableChatLandUseCache(z16);
                SquareSwitchUtils.INSTANCE.setEnableChatLandUseCache(null);
            }
        });
        qh("filament-\u9996\u9875debug", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$16
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableFilamentIndexDebug());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$17
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableFilamentIndexDebug(z16);
            }
        });
        qh("\u5e7f\u573aavatar\u5f3a\u5236\u672c\u5730\u5f55\u5236", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$18
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(!SquareMedia.INSTANCE.getEnabledUseUrl());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$19
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareMedia.INSTANCE.setEnabledUseUrl(!z16);
            }
        });
        qh("\u6253\u5f00\u52a8\u6001\u6392\u5e8f\u8c03\u8bd5\u5668", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$20
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(!SquareMedia.INSTANCE.getEnabledUseUrl());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$21
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableDynamicSortDebug(z16);
            }
        });
        qh("\u6253\u5f00\u5e7f\u573aAvatar\u8c03\u8bd5\u4fe1\u606f", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$22
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(!SquareMedia.INSTANCE.getEnabledUseUrl());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$23
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableAvatarDebugInfo(z16);
            }
        });
        qh("\u662f\u5426\u771f\u6b63\u6dfb\u52a0\u5230\u5e7f\u573a", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$24
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableAddMulti());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$25
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableAddMulti(z16);
            }
        });
        qh("\u672a\u8bfb\u6d88\u606fMock", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$26
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableMockUnReadMsg());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$27
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableMockUnReadMsg(z16);
            }
        });
        ph("\u91cd\u5236sp", new d());
        qh("\u5f3a\u5236\u663e\u793a\u6dfb\u52a0\u7fa4\u5bf9\u8bdd\u6846", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$29
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getForceShowAddTroopDialog());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$30
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setForceShowAddTroopDialog(z16);
            }
        });
        qh("\u6dfb\u52a0\u7fa4\u5bf9\u8bdd\u6846\u8d85\u65f61\u5206\u949f", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$31
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getShortShowAddTroopExpireDuration());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$32
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setShortShowAddTroopExpireDuration(z16);
            }
        });
        qh("\u6d88\u606f\u76d2\u5b50\u5df2\u8bfb\u8fc7\u671f1\u5206\u949f", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$33
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getShortShowAddTroopExpireDuration());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$34
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setShortShowAddTroopExpireDuration(z16);
            }
        });
        qh("Mock\u7535\u91cf\u53d8\u5316", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$35
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getEnableBatteryMock());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$36
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setEnableBatteryMock(z16);
            }
        });
        qh("Mock\u65b0\u4eba\u5f15\u5bfc", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$37
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getMockNoviceGuide());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$38
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setMockNoviceGuide(z16);
            }
        });
        ph("\u56fe\u4e66\u9986\u81ea\u5b9a\u4e49dialog\u6d4b\u8bd5", new View.OnClickListener() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonDialog commonDialog;
                Context it12 = SquareDemoFragment.this.getContext();
                if (it12 != null) {
                    Intrinsics.checkNotNullExpressionValue(it12, "it1");
                    commonDialog = new CommonDialog(it12, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.iba), null, null, 0, 0, null, null, null, null, 510, null), "lallalal", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle("dasdasd", 0.0f, 0, false, 0, null, null, 126, null), null, false, null, false, 960, null));
                } else {
                    commonDialog = null;
                }
                if (commonDialog != null) {
                    commonDialog.show();
                }
                if (commonDialog != null) {
                    commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$39.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3) {
                            Context context = SquareDemoFragment.this.getContext();
                            if (context != null) {
                                ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), context, "\u6253\u5f00dialog", 0, 4, null);
                            }
                        }
                    });
                }
            }
        });
        ph("\u6253\u5f00\u53cc\u4eba\u4e13\u6ce8\u9875", new e());
        ph("\u6253\u5f00\u5f55\u5236\u6d4b\u8bd5\u9875\u9762", new f());
        qh("\u9752\u5c11\u5e74\u6a21\u5f0f", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$42
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getStudyMode());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$43
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setStudyMode(z16);
            }
        });
        qh("\u5c4f\u853d\u9752\u5c11\u5e74\u6a21\u5f0f", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$44
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getNeedShieldTeenager());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$45
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setNeedShieldTeenager(z16);
            }
        });
        qh("\u6253\u5f00\u56fe\u7247\u6027\u80fd\u76d1\u63a7", new Function1<FormSwitchItem, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$46
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormSwitchItem formSwitchItem) {
                invoke2(formSwitchItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormSwitchItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                item.d(SquareDebug.INSTANCE.getDrawableMonitor());
            }
        }, new Function2<View, Boolean, Unit>() { // from class: com.tencent.square.debugger.SquareDemoFragment$addSquareItem$47
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, boolean z16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                SquareDebug.INSTANCE.setDrawableMonitor(z16);
            }
        });
        ph("\u6e05\u9664\u672c\u5730\u5f55\u5236\u7f13\u5b58", new g());
        ph("\u6253\u5f00\u53ef\u80fd\u8ba4\u8bc6\u7684\u4eba", new h());
        ph("\u6253\u5f00\u597d\u53cb\u9080\u8bf7\u9875", new i());
        xh();
        ph("\u6e05\u9664\u5404\u79cd\u6807\u8bc6\u4f4d\u8bb0\u5f55", new j());
    }

    @Override // com.tencent.square.debugger.BaseDebugFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        try {
            com.tencent.square.debugger.b.f373562c.f(new com.tencent.square.debugger.e() { // from class: com.tencent.square.debugger.SquareDemoFragment$onCreateView$1
                @Override // com.tencent.square.debugger.e
                public void a(final Function0<Unit> task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.square.debugger.SquareDemoFragment$onCreateView$1$postToUIHandler$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Function0.this.invoke();
                        }
                    });
                }

                @Override // com.tencent.square.debugger.e
                public String getCurrentAccountUin() {
                    return Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
                }
            });
        } catch (Exception e16) {
            SquareBaseKt.getSquareLog().e(QBaseFragment.TAG, "DebuggerDelegate throw ", e16);
        }
        return onCreateView;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.square.debugger.b.f373562c.d();
    }

    @Override // com.tencent.square.debugger.BaseDebugFragment
    protected void sh() {
        Context context = getContext();
        if (context != null) {
            int dip = ViewExtensionsKt.dip(context, 500);
            LinearLayout mainView = getMainView();
            if (mainView != null) {
                mainView.setPadding(0, 0, 0, dip);
            }
        }
        yh();
    }

    public final void wh() {
        CircleProgressDrawable circleProgressDrawable = new CircleProgressDrawable();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        SquareImageView squareImageView = new SquareImageView(relativeLayout.getContext());
        squareImageView.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i_l));
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(squareImageView, new RelativeLayout.LayoutParams(150, 150));
        SquareImageView squareImageView2 = new SquareImageView(relativeLayout.getContext());
        squareImageView2.setBackground(circleProgressDrawable);
        relativeLayout.addView(squareImageView2, new RelativeLayout.LayoutParams(150, 150));
        LinearLayout mainView = getMainView();
        if (mainView != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 5, 20, 5);
            mainView.addView(relativeLayout, layoutParams);
        }
        circleProgressDrawable.reStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SquareDemoFragment squareDemoFragment = SquareDemoFragment.this;
            FocusGroupFragment.Companion companion = FocusGroupFragment.INSTANCE;
            Table table = new Table(1L, 1L, 1L, new Location(1, 1, 1, 1, 0, 0, 48, null), new Image("", new Size(1, 1)), new Point(1, 1), null, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null);
            Gender gender = Gender.MALE;
            UserCommon userCommon = new UserCommon(111L, "anzai", "", gender);
            UserStatus userStatus = UserStatus.STAND_UP;
            long j3 = 1000;
            squareDemoFragment.pushFragment(companion.newInstance(new FocusGroupItem(new FocusItem(table, new User("111", userCommon, "", userStatus, new SitDownInfo(1L, null, 100L, false, System.currentTimeMillis() / j3, new CommonTagInfo("", "\u5927\u8fde\u5e02\u52b3\u52a8\u5566\u5927\u4e8b"), null, 0L, null, 0L, 0, new Point(0, 0), 1792, null), null, null, null, null, null, null, 2016, null), 0L), new FocusItem(new Table(1L, 1L, 1L, new Location(1, 1, 1, 1, 0, 0, 48, null), new Image("", new Size(1, 1)), new Point(1, 1), null, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null), new User("111", new UserCommon(111L, "anzai", "", gender), "", userStatus, new SitDownInfo(1L, null, 100L, false, System.currentTimeMillis() / j3, new CommonTagInfo("", "\u5927\u8fde\u5e02\u52b3\u52a8\u5566\u5927\u4e8b"), null, 0L, null, 0L, 0, new Point(0, 0), 1792, null), null, null, null, null, null, null, 2016, null), 0L))));
        }
    }
}
