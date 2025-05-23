package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBeanV3;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQSettingMeViewListBean;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dl;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J/\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010!\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010)\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010*\u001a\u00020\u0004J\b\u0010+\u001a\u00020\u001aH\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\u0012\u00101\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeMenuPanelPartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/section/a;", "", "I9", "", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/adapter/u;", "Lkotlin/collections/ArrayList;", "Q9", "([[Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;)Ljava/util/ArrayList;", "", "G9", "bizBean", "N9", "", "bizId", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "S9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/o;", "bean", "V9", "R9", "", "H9", "J9", "event", "O9", "T9", "P9", "U9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "K9", "V6", "v", "biz", "H", "B9", "onPostThemeChanged", NodeProps.ON_CLICK, "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "menuRoot", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "menuPanel", "Lcom/tencent/mobileqq/adapter/t;", "i", "Lcom/tencent/mobileqq/adapter/t;", "listItemAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isBgDrawableValid", BdhLogUtil.LogTag.Tag_Conn, "isDefaultFinancialItemInList", "<init>", "()V", "D", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class QQSettingMeMenuPanelPartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, com.tencent.mobileqq.section.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDefaultFinancialItemInList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout menuRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView menuPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.adapter.t listItemAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isBgDrawableValid;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeMenuPanelPartV3$a;", "", "", "KEY_QQ_SETTING_ME_ENABLE_UPDATE_LIST_9710", "Ljava/lang/String;", "TAG", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeMenuPanelPartV3$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeMenuPanelPartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isBgDrawableValid = true;
        }
    }

    private final ArrayList<com.tencent.mobileqq.adapter.u> G9(List<? extends List<? extends QQSettingMeBizBean>> list) {
        ArrayList<com.tencent.mobileqq.adapter.u> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            int size2 = list.get(i3).size();
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList.add(new com.tencent.mobileqq.adapter.u(list.get(i3).get(i16)));
            }
            if (i3 != list.size() - 1) {
                arrayList.add(new com.tencent.mobileqq.adapter.u(null));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[LOOP:1: B:15:0x003d->B:22:0x0062, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean H9() {
        List<List<QQSettingMeBizBean>> list;
        boolean z16;
        boolean z17;
        boolean contains$default;
        QQSettingMeViewListBean b16 = dl.f307676a.b();
        if (b16 != null) {
            list = b16.b();
        } else {
            list = null;
        }
        List<List<QQSettingMeBizBean>> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        int size = arrayList.size();
        boolean z18 = false;
        for (int i3 = 0; i3 < size; i3++) {
            int size2 = ((List) arrayList.get(i3)).size();
            int i16 = 0;
            while (true) {
                if (i16 >= size2) {
                    break;
                }
                String n3 = ((QQSettingMeBizBean) ((List) arrayList.get(i3)).get(i16)).n();
                if (n3 != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) n3, (CharSequence) "d_financial", false, 2, (Object) null);
                    if (contains$default) {
                        z17 = true;
                        if (!z17) {
                            z18 = true;
                            break;
                        }
                        i16++;
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        return z18;
    }

    private final void I9() {
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f2();
        com.tencent.mobileqq.qqsettingme.a.d().clear();
        RFWIocAbilityProvider.g().registerGlobalIoc(getContext(), this, com.tencent.mobileqq.section.a.class);
        this.isBgDrawableValid = DrawerUtils.f306948a.a(getContext().getDrawable(R.drawable.f161886kx2));
        this.listItemAdapter = new com.tencent.mobileqq.adapter.t(new com.tencent.mobileqq.adapter.v());
        RecyclerView recyclerView = this.menuPanel;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.menuPanel;
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
        }
        RecyclerView recyclerView3 = this.menuPanel;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.listItemAdapter}));
        }
        K9();
    }

    private final void J9(QQSettingMeBizBean bizBean) {
        O9(bizBean, "imp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9(QQSettingMeBizBean bizBean) {
        HashMap<String, QQSettingMeBizBean> d16 = com.tencent.mobileqq.qqsettingme.a.d();
        Intrinsics.checkNotNullExpressionValue(d16, "getItemBeanMap()");
        d16.put(bizBean.n(), bizBean);
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).e2(bizBean.n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O9(QQSettingMeBizBean bizBean, String event) {
        boolean z16;
        CharSequence charSequence;
        Map mapOf;
        if (bizBean == null) {
            return;
        }
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(bizBean.n());
        if (g16 != null) {
            z16 = g16.hasRedTouch();
        } else {
            z16 = false;
        }
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        int i3 = z16;
        if (companion.j()) {
            TianshuRedTouch e16 = com.tencent.mobileqq.qqsettingme.a.e(bizBean.n());
            i3 = z16;
            if (e16 != null) {
                i3 = companion.c(e16);
            }
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h(bizBean.n());
        if (h16 == null) {
            return;
        }
        VideoReport.setElementId(h16, "em_bas_function_entry_list");
        VideoReport.setElementClickPolicy(h16, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(h16, ExposurePolicy.REPORT_NONE);
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("is_red_tips_em", Integer.valueOf(i3));
        QQSettingMeBizBean.b r16 = bizBean.r();
        if (r16 != null) {
            charSequence = r16.f184991a;
        } else {
            charSequence = null;
        }
        pairArr[1] = TuplesKt.to("function_name", charSequence);
        pairArr[2] = TuplesKt.to("plugin_id", bizBean.n());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent(event, h16, mapOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[LOOP:0: B:33:0x009c->B:38:0x00d0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2 A[EDGE_INSN: B:39:0x00d2->B:50:0x00d2 BREAK  A[LOOP:0: B:33:0x009c->B:38:0x00d0], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void P9(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        URLImageView uRLImageView;
        com.tencent.mobileqq.activity.qqsettingme.ac acVar;
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(bizId);
        if (g16 == null) {
            View h16 = com.tencent.mobileqq.qqsettingme.a.h(bizId);
            if (h16 != null) {
                uRLImageView = (URLImageView) h16.findViewById(R.id.umf);
            } else {
                uRLImageView = null;
            }
            if (uRLImageView == null) {
                return;
            }
            g16 = new RedTouch(getActivity(), uRLImageView).setGravity(8388661).applyTo();
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null) {
                acVar = c16.k();
            } else {
                acVar = null;
            }
            if (acVar != null) {
                acVar.g(g16);
            }
        }
        RedTouchTextView f16 = com.tencent.mobileqq.qqsettingme.a.f(bizId);
        if (f16 == null) {
            return;
        }
        if (appInfo == null) {
            if (g16.hasRedTouch()) {
                g16.parseRedTouch((BusinessInfoCheckUpdate.AppInfo) null);
                f16.setAppInfo(null);
                return;
            }
            return;
        }
        if (appInfo.iNewFlag.get() != 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
            appInfo2.set(appInfo);
            BusinessInfoCheckUpdate.AppInfo appInfo3 = new BusinessInfoCheckUpdate.AppInfo();
            appInfo3.set(appInfo);
            ArrayList arrayList = new ArrayList(appInfo3.red_display_info.red_type_info.get());
            int size = arrayList.size() - 1;
            boolean z16 = false;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo) arrayList.get(size);
                    int i16 = redTypeInfo.red_type.get();
                    if (i16 == 0) {
                        arrayList.remove(size);
                    } else if (i16 == 3 && RedTouchTextView.u(redTypeInfo, appInfo3)) {
                        RedTouchTextView.setImageRedNotShowRedPoint(redTypeInfo, appInfo);
                    } else {
                        if (i16 == 15 && RedTouchTextView.t(redTypeInfo, appInfo3)) {
                            RedTouchTextView.setDiffImageRedNotShowRedPoint(redTypeInfo, appInfo);
                        }
                        if (i3 >= 0) {
                            break;
                        } else {
                            size = i3;
                        }
                    }
                    z16 = true;
                    if (i3 >= 0) {
                    }
                }
            }
            if (arrayList.size() < 2) {
                arrayList.clear();
            }
            appInfo3.red_display_info.red_type_info.set(arrayList);
            ArrayList arrayList2 = new ArrayList();
            if (z16) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo2.red_type.set(0);
                arrayList2.add(redTypeInfo2);
            }
            appInfo2.red_display_info.red_type_info.set(arrayList2);
            g16.parseRedTouch(appInfo2);
            f16.setAppInfo(appInfo3);
            return;
        }
        if (g16.hasRedTouch()) {
            g16.parseRedTouch(appInfo);
            f16.setAppInfo(appInfo);
        }
    }

    private final ArrayList<com.tencent.mobileqq.adapter.u> Q9(QQSettingMeBizBean[][] qQSettingMeBizBeanArr) {
        ArrayList<com.tencent.mobileqq.adapter.u> arrayList = new ArrayList<>();
        int length = qQSettingMeBizBeanArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int length2 = qQSettingMeBizBeanArr[i3].length;
            for (int i16 = 0; i16 < length2; i16++) {
                arrayList.add(new com.tencent.mobileqq.adapter.u(qQSettingMeBizBeanArr[i3][i16]));
            }
            if (i3 != qQSettingMeBizBeanArr.length - 1) {
                arrayList.add(new com.tencent.mobileqq.adapter.u(null));
            }
        }
        return arrayList;
    }

    private final void R9() {
        List<com.tencent.mobileqq.adapter.u> list;
        String str;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_setting_me_enable_update_list_9170", true) || !this.isDefaultFinancialItemInList) {
            return;
        }
        if (H9()) {
            QLog.d("QQSettingMeMenuPanelPart", 1, "[updateData] hasFinancialItemFromRepo, return");
            return;
        }
        com.tencent.mobileqq.adapter.t tVar = this.listItemAdapter;
        if (tVar != null) {
            list = tVar.getItems();
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "dataList.iterator()");
        boolean z16 = false;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            QQSettingMeBizBean a16 = ((com.tencent.mobileqq.adapter.u) next).a();
            if (a16 != null) {
                str = a16.n();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "d_financial")) {
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            com.tencent.mobileqq.adapter.t tVar2 = this.listItemAdapter;
            if (tVar2 != null) {
                tVar2.setItems(arrayList);
            }
            this.isDefaultFinancialItemInList = false;
            QLog.d("QQSettingMeMenuPanelPart", 1, "[updateData] hasRemoveFinancialItem");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        View m3;
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        boolean z16 = false;
        if (c16 != null && (m3 = c16.m()) != null && m3.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        try {
            T9(bizId, appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateDrawerRedTouch error: " + bizId + ", " + e16);
        }
    }

    private final void T9(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        CharSequence charSequence;
        View m3;
        PBInt32Field pBInt32Field;
        RedTouchTextView p16;
        if (U9(bizId, appInfo)) {
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null) {
                J9(c16);
                return;
            }
            return;
        }
        P9(bizId, appInfo);
        QQSettingMeBizBean c17 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c17 != null && (p16 = c17.p()) != null) {
            charSequence = p16.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z16 = false;
        if (appInfo != null && (pBInt32Field = appInfo.iNewFlag) != null && pBInt32Field.get() == 1) {
            z16 = true;
        }
        if (z16) {
            charSequence = ((Object) charSequence) + " \u6709\u65b0\u5185\u5bb9";
        }
        QQSettingMeBizBean c18 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c18 != null && (m3 = c18.m()) != null) {
            AccessibilityUtil.c(m3, charSequence, Button.class.getName());
        }
        QQSettingMeBizBean c19 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c19 != null) {
            J9(c19);
        }
    }

    private final boolean U9(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        TianshuRedTouch l3;
        String str;
        PBStringField pBStringField;
        if (TianshuRedTouch.INSTANCE.j()) {
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null && (l3 = c16.l()) != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                l3.n0(str);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(com.tencent.mobileqq.activity.qqsettingme.bean.o bean) {
        try {
            if (!bean.f184935a.path.has()) {
                bean.f184935a.path.set("100400");
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            appInfo.set(bean.f184935a);
            if (bean.f184939e && RedTouchTextView.n(appInfo) != null) {
                ArrayList arrayList = new ArrayList();
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                arrayList.add(redTypeInfo);
                appInfo.red_display_info.red_type_info.set(arrayList);
            }
            T9("d_vip_identity", appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateSuperMemberItemView: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.B9();
            R9();
        }
    }

    @Override // com.tencent.mobileqq.section.a
    public void H(@NotNull View v3, @NotNull String biz) {
        TianshuRedTouch e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) biz);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(biz, "biz");
        com.tencent.mobileqq.part.b bVar = (com.tencent.mobileqq.part.b) getPartHost();
        if (bVar == null || !bVar.m() || FastClickUtils.isFastDoubleClick("QQSettingMeMenuPanelPart")) {
            return;
        }
        O9(com.tencent.mobileqq.qqsettingme.a.c(biz), "clck");
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(biz);
        if (g16 != null) {
            g16.hasRedTouch();
        }
        com.tencent.mobileqq.processor.b N1 = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1(biz);
        if (N1 != null) {
            N1.onClick(v3);
        }
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        if (companion.j() && (e16 = com.tencent.mobileqq.qqsettingme.a.e(biz)) != null) {
            companion.c(e16);
            e16.x();
        }
    }

    public final void K9() {
        RecyclerView recyclerView;
        List<List<QQSettingMeBizBean>> list;
        List<List<QQSettingMeBizBean>> b16;
        ArrayList<com.tencent.mobileqq.adapter.u> G9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQSettingMeBizBean[][] c16 = new QQSettingMeMenuConfigBeanV3().c();
        Intrinsics.checkNotNullExpressionValue(c16, "bean.bizBeanArr");
        ArrayList<com.tencent.mobileqq.adapter.u> Q9 = Q9(c16);
        dl dlVar = dl.f307676a;
        if (dlVar.b() != null) {
            QQSettingMeViewListBean b17 = dlVar.b();
            if (b17 != null && (b16 = b17.b()) != null && (G9 = G9(b16)) != null) {
                Q9 = G9;
            }
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateDrawerRedTouch error: " + b17);
        }
        Iterator<com.tencent.mobileqq.adapter.u> it = Q9.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            QQSettingMeBizBean a16 = it.next().a();
            if (a16 != null) {
                if (Intrinsics.areEqual(a16.n(), "d_financial")) {
                    QQSettingMeViewListBean b18 = dl.f307676a.b();
                    if (b18 != null) {
                        list = b18.b();
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        this.isDefaultFinancialItemInList = true;
                    }
                }
                N9(a16);
                i3++;
                if (!TextUtils.isEmpty(a16.J)) {
                    VasApngUtil.getApngURLDrawable(a16.J, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
                }
                if (!TextUtils.isEmpty(a16.K)) {
                    VasApngUtil.getApngURLDrawable(a16.K, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
                }
            }
        }
        com.tencent.mobileqq.adapter.t tVar = this.listItemAdapter;
        if (tVar != null) {
            tVar.setItems(Q9);
        }
        int dip2px = ViewUtils.dip2px((((r0.a().length - i3) - 2) * 56.0f) - 150);
        if (dip2px > 0 && (recyclerView = this.menuPanel) != null) {
            recyclerView.setPadding(0, 0, 0, dip2px);
        }
    }

    @Override // com.tencent.mobileqq.section.a
    public boolean V6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isBgDrawableValid;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        TianshuRedTouch x95;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("QQSettingMeMenuPanelPart") && (x95 = x9()) != null) {
            x95.x();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        RecyclerView recyclerView = null;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.um8);
        } else {
            relativeLayout = null;
        }
        this.menuRoot = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, 0, 0, Math.max(com.tencent.mobileqq.activity.qqsettingme.utils.b.b(), ex.d(58) + ScreenUtil.getNavigationBarHeight(getActivity())) + 30);
        }
        RelativeLayout relativeLayout2 = this.menuRoot;
        if (relativeLayout2 != null) {
            recyclerView = (RecyclerView) relativeLayout2.findViewById(R.id.ums);
        }
        this.menuPanel = recyclerView;
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.o> mutableLiveData = qQSettingMeViewModel.J;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.o, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.o, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeMenuPanelPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
                invoke2(oVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.o it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeMenuPanelPartV3 qQSettingMeMenuPanelPartV3 = QQSettingMeMenuPanelPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeMenuPanelPartV3.V9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPartV3.L9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.k> mutableLiveData2 = qQSettingMeViewModel.P;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final QQSettingMeMenuPanelPartV3$onPartCreate$2 qQSettingMeMenuPanelPartV3$onPartCreate$2 = new QQSettingMeMenuPanelPartV3$onPartCreate$2(this);
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPartV3.M9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.d().values()) {
            if (qQSettingMeBizBean.m() != null) {
                if (!this.isBgDrawableValid) {
                    qQSettingMeBizBean.m().setBackground(DrawerUtils.f306948a.e());
                }
                URLImageView uRLImageView = (URLImageView) qQSettingMeBizBean.m().findViewById(R.id.umf);
                if (uRLImageView != null) {
                    DrawerUtils.n(uRLImageView, qQSettingMeBizBean);
                    Boolean bool = qQSettingMeBizBean.L;
                    Intrinsics.checkNotNullExpressionValue(bool, "bizBean.needIconColorFilter");
                    if (bool.booleanValue()) {
                        uRLImageView.setColorFilter(ContextCompat.getColor(getActivity(), R.color.qui_common_icon_primary));
                    }
                }
            }
        }
    }
}
