package com.tencent.mobileqq.zplan.debug;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.zplan.utils.bb;
import fi3.ax;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Ah", "xh", "Landroid/widget/Button;", "Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType;", "resourceType", "Landroid/widget/EditText;", "exit", "", "value", "Dh", "", "needStatusTrans", "needImmersive", "isWrapContent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lfi3/ax;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "wh", "()Lfi3/ax;", "binding", "<init>", "()V", "ResourceType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanResourceFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy binding;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType;", "", "(Ljava/lang/String;I)V", "getMMKVKey", "", "SHADER", "MINI_HOME", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class ResourceType {
        public static final ResourceType SHADER = new SHADER("SHADER", 0);
        public static final ResourceType MINI_HOME = new MINI_HOME("MINI_HOME", 1);
        private static final /* synthetic */ ResourceType[] $VALUES = $values();

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType$MINI_HOME;", "Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType;", "getMMKVKey", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        static final class MINI_HOME extends ResourceType {
            @Override // com.tencent.mobileqq.zplan.debug.ZPlanResourceFragment.ResourceType
            public String getMMKVKey() {
                return "zplan_debug_mini_home_url_temp";
            }

            MINI_HOME(String str, int i3) {
                super(str, i3, null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType$SHADER;", "Lcom/tencent/mobileqq/zplan/debug/ZPlanResourceFragment$ResourceType;", "getMMKVKey", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        static final class SHADER extends ResourceType {
            @Override // com.tencent.mobileqq.zplan.debug.ZPlanResourceFragment.ResourceType
            public String getMMKVKey() {
                return "zplan_debug_lite_url_temp";
            }

            SHADER(String str, int i3) {
                super(str, i3, null);
            }
        }

        public /* synthetic */ ResourceType(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3);
        }

        public static ResourceType valueOf(String str) {
            return (ResourceType) Enum.valueOf(ResourceType.class, str);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        public abstract String getMMKVKey();

        private static final /* synthetic */ ResourceType[] $values() {
            return new ResourceType[]{SHADER, MINI_HOME};
        }

        ResourceType(String str, int i3) {
        }
    }

    public ZPlanResourceFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ax>() { // from class: com.tencent.mobileqq.zplan.debug.ZPlanResourceFragment$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ax invoke() {
                return ax.g(LayoutInflater.from(ZPlanResourceFragment.this.getContext()));
            }
        });
        this.binding = lazy;
    }

    private final void Ah() {
        final ResourceType resourceType = ResourceType.SHADER;
        final EditText editText = wh().f398972e;
        editText.setText(j74.b.f409622a.d(resourceType.getMMKVKey()));
        Intrinsics.checkNotNullExpressionValue(editText, "binding.urlTemplateConfi\u2026.getMMKVKey()))\n        }");
        final Button button = wh().f398973f;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanResourceFragment.Bh(ZPlanResourceFragment.this, button, resourceType, editText, view);
            }
        });
        final Button button2 = wh().f398974g;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanResourceFragment.Ch(ZPlanResourceFragment.this, button2, resourceType, editText, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanResourceFragment this$0, Button this_apply, ResourceType type, EditText urlTemplateEt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(urlTemplateEt, "$urlTemplateEt");
        this$0.Dh(this_apply, type, urlTemplateEt, urlTemplateEt.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZPlanResourceFragment this$0, Button this_apply, ResourceType type, EditText urlTemplateEt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(urlTemplateEt, "$urlTemplateEt");
        this$0.Dh(this_apply, type, urlTemplateEt, "");
    }

    private final void Dh(Button button, final ResourceType resourceType, final EditText editText, final String str) {
        DialogUtil.createCustomDialog(button.getContext(), 0, (String) null, "\u4f7f\u7528\u65b0\u914d\u7f6e\u5e76\u91cd\u542f\u624bQ\u751f\u6548\uff1f", HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ag
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanResourceFragment.Eh(editText, str, resourceType, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanResourceFragment.Gh(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(EditText exit, String str, ResourceType resourceType, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(exit, "$exit");
        Intrinsics.checkNotNullParameter(resourceType, "$resourceType");
        exit.setText(str);
        j74.b.f409622a.h(resourceType.getMMKVKey(), str);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.debug.ai
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanResourceFragment.Fh();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh() {
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 != null) {
            l3.exit(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final ax wh() {
        return (ax) this.binding.getValue();
    }

    private final void xh() {
        final ResourceType resourceType = ResourceType.MINI_HOME;
        final EditText editText = wh().f398969b;
        editText.setText(j74.b.f409622a.d(resourceType.getMMKVKey()));
        Intrinsics.checkNotNullExpressionValue(editText, "binding.miniHomeUrlTempl\u2026.getMMKVKey()))\n        }");
        final Button button = wh().f398970c;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanResourceFragment.yh(ZPlanResourceFragment.this, button, resourceType, editText, view);
            }
        });
        final Button button2 = wh().f398971d;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanResourceFragment.zh(ZPlanResourceFragment.this, button2, resourceType, editText, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(ZPlanResourceFragment this$0, Button this_apply, ResourceType type, EditText miniHomeUrlTemplateEt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(miniHomeUrlTemplateEt, "$miniHomeUrlTemplateEt");
        this$0.Dh(this_apply, type, miniHomeUrlTemplateEt, miniHomeUrlTemplateEt.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(ZPlanResourceFragment this$0, Button this_apply, ResourceType type, EditText miniHomeUrlTemplateEt, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(miniHomeUrlTemplateEt, "$miniHomeUrlTemplateEt");
        this$0.Dh(this_apply, type, miniHomeUrlTemplateEt, "");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Ah();
        xh();
        return wh().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}
