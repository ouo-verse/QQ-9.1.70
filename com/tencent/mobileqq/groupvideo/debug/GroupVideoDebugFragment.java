package com.tencent.mobileqq.groupvideo.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoDebugApi;
import com.tencent.mobileqq.groupvideo.debug.EnvConfig;
import com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$envSwitchConfig$1;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J;\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00020\tH\u0002J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R~\u0010.\u001al\u00121\u0012/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070,\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00020\t0+0%j5\u00121\u0012/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070,\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00020\t0+`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00102\u001a\u0004\u0018\u00010/8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoDebugFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "th", "initViews", "Landroid/widget/LinearLayout;", "groupView", "", "textStr", "Lkotlin/Function1;", "Landroid/widget/Button;", "Lkotlin/ParameterName;", "name", "btn", "click", "wh", "Lcom/tencent/mobileqq/groupvideo/debug/l;", "envCtrl", "text", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "needImmersive", "needStatusTrans", "", BdhLogUtil.LogTag.Tag_Conn, "I", "itemOffset", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "envSwitchConfig", "Lkotlin/Pair;", "Lkotlin/Function0;", "E", "buttonConfig", "Lcom/tencent/mobileqq/intervideo/groupvideo/h;", "vh", "()Lcom/tencent/mobileqq/intervideo/groupvideo/h;", "iGroupVideoManager", "Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "uh", "()Lcom/tencent/mobileqq/groupvideo/api/IGroupVideoDebugApi$a;", "debugPluginManager", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoDebugFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int itemOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<EnvConfig> envSwitchConfig;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<Function0<String>, Function1<Button, Unit>>> buttonConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/GroupVideoDebugFragment$a;", "", "", "PLUGIN_APP_ID", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupVideoDebugFragment() {
        Lazy lazy;
        ArrayList<EnvConfig> arrayListOf;
        ArrayList<Pair<Function0<String>, Function1<Button, Unit>>> arrayListOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.itemOffset = x.a(20.0f);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GroupVideoDebugFragment$envSwitchConfig$1.a>() { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$envSwitchConfig$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/groupvideo/debug/GroupVideoDebugFragment$envSwitchConfig$1$a", "Lcom/tencent/mobileqq/groupvideo/debug/l;", "", "isTestEnv", "enable", "", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements l {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GroupVideoDebugFragment f213761a;

                a(GroupVideoDebugFragment groupVideoDebugFragment) {
                    this.f213761a = groupVideoDebugFragment;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupVideoDebugFragment);
                    }
                }

                @Override // com.tencent.mobileqq.groupvideo.debug.l
                public void a(boolean enable) {
                    IGroupVideoDebugApi.a uh5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, enable);
                        return;
                    }
                    if (enable != isTestEnv()) {
                        uh5 = this.f213761a.uh();
                        if (uh5 != null) {
                            uh5.enableDebug(enable);
                        }
                        if (enable) {
                            QRouteApi api = QRoute.api(IGroupVideoDebugApi.class);
                            Intrinsics.checkNotNullExpressionValue(api, "api(IGroupVideoDebugApi::class.java)");
                            Context requireContext = this.f213761a.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                            ((IGroupVideoDebugApi) api).openPluginManualApply(requireContext);
                        }
                    }
                }

                @Override // com.tencent.mobileqq.groupvideo.debug.l
                public boolean isTestEnv() {
                    IGroupVideoDebugApi.a uh5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        uh5 = this.f213761a.uh();
                        if (uh5 != null) {
                            return uh5.isDebugEnabled();
                        }
                        return false;
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupVideoDebugFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(GroupVideoDebugFragment.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(EnvConfig.BizLoginEnv.f213756c, EnvConfig.SandBoxPayEnv.f213758c, EnvConfig.SealEnv.f213759c, EnvConfig.FastestEnv.f213757c, new EnvConfig("\u672c\u5730\u8c03\u8bd5\u63d2\u4ef6\u5b89\u88c5\u529f\u80fd\u5f00\u5173", lazy));
        this.envSwitchConfig = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new Pair(GroupVideoDebugFragment$buttonConfig$1.INSTANCE, new Function1<Button, Unit>() { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$buttonConfig$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupVideoDebugFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                invoke2(button);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Button it) {
                com.tencent.mobileqq.intervideo.groupvideo.h vh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                vh5 = GroupVideoDebugFragment.this.vh();
                if (vh5 != null) {
                    vh5.c(null);
                }
            }
        }), new Pair(new Function0<String>() { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$buttonConfig$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupVideoDebugFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IGroupVideoDebugApi.a uh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                uh5 = GroupVideoDebugFragment.this.uh();
                boolean z16 = false;
                if (uh5 != null && uh5.a("GroupVideo.apk")) {
                    z16 = true;
                }
                return z16 ? "\u5220\u9664\u672c\u5730\u8c03\u8bd5\u63d2\u4ef6" : "\u672c\u5730\u8c03\u8bd5\u63d2\u4ef6\u672a\u5b89\u88c5";
            }
        }, new Function1<Button, Unit>() { // from class: com.tencent.mobileqq.groupvideo.debug.GroupVideoDebugFragment$buttonConfig$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupVideoDebugFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                invoke2(button);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
            
                if (r0.a("GroupVideo.apk") == true) goto L14;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull Button it) {
                IGroupVideoDebugApi.a uh5;
                boolean z16;
                IGroupVideoDebugApi.a uh6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                uh5 = GroupVideoDebugFragment.this.uh();
                if (uh5 != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    uh6 = GroupVideoDebugFragment.this.uh();
                    if (uh6 != null) {
                        uh6.b("GroupVideo.apk");
                    }
                    it.setText("\u672c\u5730\u8c03\u8bd5\u63d2\u4ef6\u672a\u5b89\u88c5");
                    QQToast.makeText(GroupVideoDebugFragment.this.getContext(), "\u8bf7\u6740\u8fdb\u7a0b\u91cd\u65b0\u542f\u52a8QQ", 0).show();
                }
            }
        }));
        this.buttonConfig = arrayListOf2;
    }

    private final void initViews() {
        View view = getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = new TextView(requireContext());
        textView.setText("\u5982\u679c\u5728\u624bQ\u8fd0\u884c\u671f\u95f4\u5df2\u7ecf\u542f\u52a8\u8fc7\u7fa4\u8bfe\u5802/\u7fa4\u89c6\u9891\uff0c\u8c03\u6574\u5f00\u5173\u72b6\u6001\u540e\u9700\u8981\u6740\u8fdb\u7a0b\u91cd\u65b0\u542f\u52a8\u624d\u80fd\u4fdd\u8bc1\u751f\u6548\uff1b\u53cd\u4e4b\uff0c\u5219\u4e0d\u9700\u8981\u3002");
        int i3 = this.itemOffset;
        textView.setPadding(i3, i3, i3, i3);
        linearLayout.addView(textView);
        for (EnvConfig envConfig : this.envSwitchConfig) {
            yh(linearLayout, envConfig.a().getValue(), envConfig.b());
        }
        TextView textView2 = new TextView(requireContext());
        textView2.setText("\u5728\"\u672c\u5730\u8c03\u8bd5\u63d2\u4ef6\u5b89\u88c5\u529f\u80fd\"\u6253\u5f00\u65f6\uff0c\u4f1a\u81ea\u52a8\u68c0\u67e5\u5b89\u88c5\u5982\u4e0b\u8def\u5f84\u7684\u672c\u5730\u63d2\u4ef6\uff1a\n/sdcard/Android/data/com.tencent.mobileqq/files/qshadow-plugins/GroupVideo.apk");
        textView2.setTextColor(-65281);
        int i16 = this.itemOffset;
        textView2.setPadding(i16, 0, i16, 0);
        linearLayout.addView(textView2);
        Iterator<T> it = this.buttonConfig.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            wh(linearLayout, (String) ((Function0) pair.getFirst()).invoke(), (Function1) pair.getSecond());
        }
    }

    private final void th() {
        if (ContextCompat.checkSelfPermission(requireContext(), QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            QQToast.makeText(getContext(), "\u8bf7\u5148\u53bb\u8bbe\u7f6e\u5b58\u50a8\u6743\u9650", 0).show();
            ActivityCompat.requestPermissions(requireActivity(), new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 0);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupVideoDebugApi.a uh() {
        return ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getDebugPluginManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.intervideo.groupvideo.h vh() {
        return ((IGroupVideoDebugApi) QRoute.api(IGroupVideoDebugApi.class)).getGroupVideoManager();
    }

    private final void wh(LinearLayout groupView, String textStr, final Function1<? super Button, Unit> click) {
        final Button button = new Button(groupView.getContext());
        button.setText(textStr);
        button.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = this.itemOffset;
        layoutParams.setMargins(i3, i3, i3, i3);
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.groupvideo.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupVideoDebugFragment.xh(Function1.this, button, view);
            }
        });
        groupView.addView(button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 click, Button button, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(click, "$click");
        Intrinsics.checkNotNullParameter(button, "$button");
        click.invoke(button);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void yh(LinearLayout groupView, final l envCtrl, String text) {
        FormSwitchItem formSwitchItem = new FormSwitchItem(groupView.getContext());
        formSwitchItem.setText(text);
        formSwitchItem.setChecked(envCtrl.isTestEnv());
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.groupvideo.debug.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GroupVideoDebugFragment.zh(l.this, compoundButton, z16);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.itemOffset, 0, 0);
        formSwitchItem.setLayoutParams(layoutParams);
        groupView.addView(formSwitchItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(l envCtrl, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(envCtrl, "$envCtrl");
        envCtrl.a(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            linearLayout = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            LinearLayout linearLayout2 = new LinearLayout(requireContext());
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundResource(R.drawable.bg_texture);
            linearLayout = linearLayout2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, linearLayout);
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            th();
        }
    }
}
