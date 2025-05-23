package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopIntroPart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "", "P9", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "Landroid/view/View;", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "f", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "troopIntroConfig", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "introTv", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopIntroPart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> troopIntroConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView introTv;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopIntroPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopIntroPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopIntroPart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
        } else {
            this.lifecycleOwner = lifecycleOwner;
        }
    }

    private final void P9() {
        String str;
        Intent intent = new Intent();
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 2);
        intent.putExtra("edit_mode", 1);
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.bxj));
        TroopInfo g26 = C9().g2();
        if (g26 != null) {
            str = g26.mRichFingerMemo;
        } else {
            str = null;
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
        intent.putExtra("default_hint", "\u586b\u5199\u7fa4\u4ecb\u7ecd");
        intent.putExtra("max_num", 900);
        intent.putExtra("canPostNull", true);
        intent.putExtra("support_emotion", true);
        intent.putExtra("full_screen", true);
        intent.putExtra("max_limit_mode", 1);
        RouteUtils.startActivityForResult(getContext(), intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(EditTroopIntroPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(EditTroopIntroPart this$0, com.tencent.mobileqq.troop.troopsetting.customconfig.b this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this$0, this_apply.i(), "em_group_intro", null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(EditTroopIntroPart this$0, com.tencent.mobileqq.troop.troopsetting.customconfig.b this_apply, View view) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.P9();
        View i3 = this_apply.i();
        TroopInfo g26 = this$0.C9().g2();
        if (g26 != null) {
            str = g26.mRichFingerMemo;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this$0, i3, !z16, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.a
    @NotNull
    /* renamed from: O9, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.troopsetting.customconfig.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopIntroConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopIntroConfig");
            return null;
        }
        return bVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (-1 == resultCode && requestCode == 5) {
            String str2 = null;
            if (data != null) {
                str = data.getStringExtra("result");
            } else {
                str = null;
            }
            TroopInfo g26 = C9().g2();
            if (g26 != null) {
                str2 = g26.mRichFingerMemo;
            }
            if (QLog.isColorLevel()) {
                QLog.i("EditTroopInfoFragment-IntroPart", 2, "[onActivityResult] same:" + Intrinsics.areEqual(str, str2) + ", intro:" + str);
            }
            if (!Intrinsics.areEqual(str, str2) && str != null) {
                C9().t2(str, this.lifecycleOwner);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hz7, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f101675vu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id.troop_edit_intro_content)");
        TextView textView2 = (TextView) findViewById;
        this.introTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("introTv");
            textView = null;
        } else {
            textView = textView2;
        }
        TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTroopIntroPart.Q9(EditTroopIntroPart.this, view);
            }
        }, 1, null);
        final com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(inflate);
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.n
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                EditTroopIntroPart.R9(EditTroopIntroPart.this, bVar, view);
            }
        });
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTroopIntroPart.S9(EditTroopIntroPart.this, bVar, view);
            }
        });
        this.troopIntroConfig = bVar;
        LiveData<String> h26 = C9().h2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopIntroPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopIntroPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TextView textView3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                textView3 = EditTroopIntroPart.this.introTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("introTv");
                    textView3 = null;
                }
                textView3.setText(new QQText(str, 11, 16));
            }
        };
        h26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopIntroPart.T9(Function1.this, obj);
            }
        });
    }
}
