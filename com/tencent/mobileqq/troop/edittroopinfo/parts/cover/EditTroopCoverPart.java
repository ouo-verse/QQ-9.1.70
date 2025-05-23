package com.tencent.mobileqq.troop.edittroopinfo.parts.cover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\f\n\u0002\b\t*\u0001V\u0018\u0000 \\2\u00020\u0001:\u0001]B\u000f\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010%\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R.\u0010/\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u0011008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u00105R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010NR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/b;", "", "V9", "Z9", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", "coverList", "ga", "", "noCover", "ha", "Landroid/content/Context;", "context", "isFirst", "", "rightMargin", "Landroid/view/View;", "W9", "view", "isSelected", "ia", "Y9", "da", "ea", "Lcom/tencent/mobileqq/widget/listitem/Group;", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", h.F, "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "coverConfig", "i", "Landroid/view/View;", "addCoverLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "coverInfoLayout", "Landroidx/viewpager2/widget/ViewPager2;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/viewpager2/widget/ViewPager2;", "coverViewPager", "Landroidx/appcompat/widget/LinearLayoutCompat;", "D", "Landroidx/appcompat/widget/LinearLayoutCompat;", "coverDotIndicator", "E", "coverEditText", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "X9", "()Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/TroopEditCoverAdapter;", "adapter", "", "G", "Ljava/util/List;", "indicatorDotList", "H", "I", "dotRightMargin", "dotWH", "J", "Z", "coverPartIsResume", "K", "isAutoScrolling", "com/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart$autoScrollRunnable$1", "L", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart$autoScrollRunnable$1;", "autoScrollRunnable", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopCoverPart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ViewPager2 coverViewPager;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayoutCompat coverDotIndicator;

    /* renamed from: E, reason: from kotlin metadata */
    private View coverEditText;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<View> indicatorDotList;

    /* renamed from: H, reason: from kotlin metadata */
    private final int dotRightMargin;

    /* renamed from: I, reason: from kotlin metadata */
    private final int dotWH;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean coverPartIsResume;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isAutoScrolling;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final EditTroopCoverPart$autoScrollRunnable$1 autoScrollRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> coverConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View addCoverLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View coverInfoLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart$a;", "", "", "SCROLL_INTERVAL", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopCoverPart.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
                return;
            }
            super.onPageScrollStateChanged(state);
            if (EditTroopCoverPart.this.X9().getNUM_BACKGOURND_ICON() <= 1) {
                return;
            }
            if (state == 0) {
                ViewPager2 viewPager2 = EditTroopCoverPart.this.coverViewPager;
                ViewPager2 viewPager22 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    viewPager2 = null;
                }
                int currentItem = viewPager2.getCurrentItem();
                int num_backgournd_icon = EditTroopCoverPart.this.X9().getNUM_BACKGOURND_ICON() - 1;
                if (currentItem == 0) {
                    ViewPager2 viewPager23 = EditTroopCoverPart.this.coverViewPager;
                    if (viewPager23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    } else {
                        viewPager22 = viewPager23;
                    }
                    viewPager22.setCurrentItem(num_backgournd_icon - 1, false);
                } else if (currentItem == num_backgournd_icon) {
                    ViewPager2 viewPager24 = EditTroopCoverPart.this.coverViewPager;
                    if (viewPager24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    } else {
                        viewPager22 = viewPager24;
                    }
                    viewPager22.setCurrentItem(1, false);
                }
                if (!EditTroopCoverPart.this.isAutoScrolling) {
                    EditTroopCoverPart.this.da();
                    return;
                }
                return;
            }
            if (state == 1) {
                EditTroopCoverPart.this.ea();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            super.onPageSelected(position);
            int m06 = EditTroopCoverPart.this.X9().m0(position);
            List list = EditTroopCoverPart.this.indicatorDotList;
            EditTroopCoverPart editTroopCoverPart = EditTroopCoverPart.this;
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                if (i3 == m06) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                editTroopCoverPart.ia(view, z16);
                i3 = i16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart$autoScrollRunnable$1] */
    public EditTroopCoverPart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        this.configList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopEditCoverAdapter>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart$adapter$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart$adapter$2$a", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/e;", "", "b", "a", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a implements e {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ EditTroopCoverPart f295130a;

                a(EditTroopCoverPart editTroopCoverPart) {
                    this.f295130a = editTroopCoverPart;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopCoverPart);
                    }
                }

                @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.cover.e
                public void a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        this.f295130a.ea();
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.cover.e
                public void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        this.f295130a.Z9();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.cover.e
                public void c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        this.f295130a.da();
                    } else {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopCoverPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopEditCoverAdapter invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopEditCoverAdapter) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = EditTroopCoverPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new TroopEditCoverAdapter(context, new a(EditTroopCoverPart.this));
            }
        });
        this.adapter = lazy;
        this.indicatorDotList = new ArrayList();
        this.dotRightMargin = ViewUtils.dip2px(8.0f);
        this.dotWH = ViewUtils.dip2px(6.0f);
        this.autoScrollRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart$autoScrollRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopCoverPart.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (EditTroopCoverPart.this.X9().getNUM_BACKGOURND_ICON() > 1) {
                    ViewPager2 viewPager2 = EditTroopCoverPart.this.coverViewPager;
                    ViewPager2 viewPager22 = null;
                    if (viewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                        viewPager2 = null;
                    }
                    int currentItem = (viewPager2.getCurrentItem() + 1) % EditTroopCoverPart.this.X9().getNUM_BACKGOURND_ICON();
                    ViewPager2 viewPager23 = EditTroopCoverPart.this.coverViewPager;
                    if (viewPager23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                        viewPager23 = null;
                    }
                    viewPager23.setCurrentItem(currentItem, true);
                    ViewPager2 viewPager24 = EditTroopCoverPart.this.coverViewPager;
                    if (viewPager24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                    } else {
                        viewPager22 = viewPager24;
                    }
                    viewPager22.postDelayed(this, 3000L);
                }
            }
        };
    }

    private final void V9() {
        ViewPager2 viewPager2 = this.coverViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager2 = null;
        }
        viewPager2.registerOnPageChangeCallback(new b());
    }

    private final View W9(Context context, boolean isFirst, int rightMargin) {
        int i3 = this.dotWH;
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(i3, i3);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = rightMargin;
        View view = new View(context);
        view.setLayoutParams(layoutParams);
        ia(view, isFirst);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopEditCoverAdapter X9() {
        return (TroopEditCoverAdapter) this.adapter.getValue();
    }

    private final void Y9() {
        TroopInfo g26 = C9().g2();
        if (g26 == null) {
            return;
        }
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && g26.mIsFreezed == 1 && g26.isOwnerOrAdmin()) {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModifyTroopHeadFreezedByTroopInfo(g26, getContext());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_COVER", true);
        bundle.putBoolean("IS_EDIT", true);
        getPartHost().Z9(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        int i3;
        boolean z16;
        List<f> value = C9().f2().getValue();
        if (value != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        QLog.i("EditTroopInfoFragment-CoverPart", 1, "[onClickCover] coverSize:" + i3);
        if (i3 > 0) {
            Y9();
        } else {
            getPartHost().Dh(true);
        }
        View view = this.coverEditText;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverEditText");
            view = null;
        }
        View view2 = view;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this, view2, z16, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(EditTroopCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(EditTroopCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        int i3;
        List<f> value = C9().f2().getValue();
        if (value != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 1) {
            if (QLog.isDebugVersion()) {
                QLog.d("EditTroopInfoFragment-CoverPart", 4, "[startAutoScroll] size:" + i3);
                return;
            }
            return;
        }
        boolean z16 = this.isAutoScrolling;
        if (!z16 && this.coverPartIsResume) {
            QLog.i("EditTroopInfoFragment-CoverPart", 1, "[startAutoScroll] size:" + i3 + ", isAutoScrolling:" + z16);
            this.isAutoScrolling = true;
            ViewPager2 viewPager2 = this.coverViewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
                viewPager2 = null;
            }
            viewPager2.postDelayed(this.autoScrollRunnable, 3000L);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("EditTroopInfoFragment-CoverPart", 4, "[startAutoScroll] isAutoScrolling:" + this.isAutoScrolling + ", coverPartIsResume:" + this.coverPartIsResume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea() {
        if (!this.isAutoScrolling) {
            return;
        }
        QLog.i("EditTroopInfoFragment-CoverPart", 1, "[stopAutoScroll]");
        ViewPager2 viewPager2 = this.coverViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager2 = null;
        }
        viewPager2.removeCallbacks(this.autoScrollRunnable);
        this.isAutoScrolling = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(List<f> coverList) {
        boolean z16;
        int i3;
        LinearLayoutCompat linearLayoutCompat = this.coverDotIndicator;
        ViewPager2 viewPager2 = null;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverDotIndicator");
            linearLayoutCompat = null;
        }
        linearLayoutCompat.removeAllViews();
        this.indicatorDotList.clear();
        ha(coverList.isEmpty());
        if (coverList.size() > 1) {
            int size = coverList.size();
            for (int i16 = 0; i16 < size; i16++) {
                LinearLayoutCompat linearLayoutCompat2 = this.coverDotIndicator;
                if (linearLayoutCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverDotIndicator");
                    linearLayoutCompat2 = null;
                }
                Context context = linearLayoutCompat2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "coverDotIndicator.context");
                if (i16 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i16 == coverList.size() - 1) {
                    i3 = 0;
                } else {
                    i3 = this.dotRightMargin;
                }
                View W9 = W9(context, z16, i3);
                LinearLayoutCompat linearLayoutCompat3 = this.coverDotIndicator;
                if (linearLayoutCompat3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverDotIndicator");
                    linearLayoutCompat3 = null;
                }
                linearLayoutCompat3.addView(W9);
                this.indicatorDotList.add(W9);
            }
            LinearLayoutCompat linearLayoutCompat4 = this.coverDotIndicator;
            if (linearLayoutCompat4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverDotIndicator");
                linearLayoutCompat4 = null;
            }
            linearLayoutCompat4.setVisibility(0);
            da();
        } else {
            LinearLayoutCompat linearLayoutCompat5 = this.coverDotIndicator;
            if (linearLayoutCompat5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverDotIndicator");
                linearLayoutCompat5 = null;
            }
            linearLayoutCompat5.setVisibility(8);
            ea();
        }
        X9().setDataList(coverList);
        if (!coverList.isEmpty()) {
            ViewPager2 viewPager22 = this.coverViewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.setCurrentItem(0, false);
        }
    }

    private final void ha(boolean noCover) {
        View view = null;
        if (noCover) {
            View view2 = this.addCoverLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addCoverLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.coverInfoLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverInfoLayout");
            } else {
                view = view3;
            }
            view.setVisibility(8);
            return;
        }
        View view4 = this.addCoverLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCoverLayout");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.coverInfoLayout;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverInfoLayout");
        } else {
            view = view5;
        }
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(View view, boolean isSelected) {
        int i3;
        if (isSelected) {
            i3 = R.drawable.lwj;
        } else {
            i3 = R.drawable.lwi;
        }
        view.setBackgroundResource(i3);
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.b
    @NotNull
    public List<Group> I9() {
        List<Group> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        return listOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 258) {
            if (QLog.isColorLevel()) {
                QLog.i("EditTroopInfoFragment-CoverPart", 2, "[onActivityResult] updateCover");
            }
            TroopEditInfoViewModel.F2(C9(), null, 1, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hz6, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f101615vo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id\u2026t_cover_add_cover_layout)");
        this.addCoverLayout = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addCoverLayout");
            view = null;
        } else {
            view = findViewById;
        }
        TriggerRunnerKt.c(view, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                EditTroopCoverPart.aa(EditTroopCoverPart.this, view4);
            }
        }, 1, null);
        View findViewById2 = inflate.findViewById(R.id.f101645vr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layout.findViewById(R.id\u2026p_edit_cover_info_layout)");
        this.coverInfoLayout = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f101655vs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "layout.findViewById(R.id\u2026oop_edit_cover_viewpager)");
        this.coverViewPager = (ViewPager2) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f101625vp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "layout.findViewById(R.id\u2026ver_dot_indicator_layout)");
        this.coverDotIndicator = (LinearLayoutCompat) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f101635vq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "layout.findViewById(R.id\u2026oop_edit_cover_edit_text)");
        this.coverEditText = findViewById5;
        if (findViewById5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverEditText");
            view2 = null;
        } else {
            view2 = findViewById5;
        }
        TriggerRunnerKt.c(view2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                EditTroopCoverPart.ba(EditTroopCoverPart.this, view4);
            }
        }, 1, null);
        ViewPager2 viewPager2 = this.coverViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverViewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(X9());
        V9();
        LiveData<List<f>> f26 = C9().f2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<List<? extends f>, Unit> function1 = new Function1<List<? extends f>, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopCoverPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends f> list) {
                invoke2((List<f>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<f> it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                EditTroopCoverPart editTroopCoverPart = EditTroopCoverPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                editTroopCoverPart.ga(it);
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.cover.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopCoverPart.ca(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(inflate);
        bVar.M(true);
        this.coverConfig = bVar;
        this.configList.add(bVar);
        View view4 = this.coverEditText;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverEditText");
            view3 = null;
        } else {
            view3 = view4;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this, view3, "em_group_cover", null, null, null, 28, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        this.coverPartIsResume = false;
        ea();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        this.coverPartIsResume = true;
        da();
    }
}
