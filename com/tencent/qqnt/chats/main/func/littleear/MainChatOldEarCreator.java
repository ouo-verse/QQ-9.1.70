package com.tencent.qqnt.chats.main.func.littleear;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b-\u0010.J6\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u001a2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001aH\u0016R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010)R\u0016\u0010,\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarCreator;", "Lcom/tencent/qqnt/chats/core/ui/third/b;", "Landroid/widget/TextView;", "tv", "Landroid/widget/ImageView;", "iv", "", "text", "", "textColor", "iconRes", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "Lpw3/a;", "view", "k", "binding", "i", "Landroid/content/Context;", "context", "", "", "extra", "Landroid/view/View;", "a", "", "b", ViewStickEventHelper.IS_SHOW, "f", "show", "c", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "d", "e", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "viewRef", "Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper;", "Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarAnimatorHelper;", "animatorHelper", "Z", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatOldEarCreator implements com.tencent.qqnt.chats.core.ui.third.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<pw3.a> viewRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MainChatOldEarAnimatorHelper animatorHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean canShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/func/littleear/MainChatOldEarCreator$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainChatOldEarCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewRef = new WeakReference<>(null);
            this.canShow = true;
        }
    }

    private final void i(pw3.a binding) {
        if (i.f355238a.a()) {
            binding.getRoot().setBackgroundResource(R.drawable.jgg);
            ImageView imageView = binding.f427791d;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = l.b(8);
            imageView.setLayoutParams(marginLayoutParams);
            ImageView imageView2 = binding.f427792e;
            ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.leftMargin = l.b(8);
            imageView2.setLayoutParams(marginLayoutParams2);
        }
    }

    private final void j() {
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper = new MainChatOldEarAnimatorHelper();
        mainChatOldEarAnimatorHelper.F(new Function0<Size>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator$createAnimatorHelper$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarCreator.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Size invoke() {
                WeakReference weakReference;
                LinearLayout root;
                int i3;
                ViewGroup viewGroup;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Size) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                weakReference = MainChatOldEarCreator.this.viewRef;
                pw3.a aVar = (pw3.a) weakReference.get();
                if (aVar != null && (root = aVar.getRoot()) != null) {
                    ViewParent parent = root.getParent();
                    boolean z16 = parent instanceof ViewGroup;
                    ViewGroup viewGroup2 = z16 ? (ViewGroup) parent : null;
                    int i16 = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    if (viewGroup2 != null) {
                        Integer valueOf = Integer.valueOf(viewGroup2.getWidth());
                        if (!(valueOf.intValue() > 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            i3 = valueOf.intValue();
                            viewGroup = !z16 ? (ViewGroup) parent : null;
                            if (viewGroup != null) {
                                Integer valueOf2 = Integer.valueOf(viewGroup.getHeight());
                                Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
                                if (num != null) {
                                    i16 = num.intValue();
                                }
                            }
                            root.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE));
                            return new Size(root.getMeasuredWidth(), root.getMeasuredHeight());
                        }
                    }
                    i3 = 1073741823;
                    if (!z16) {
                    }
                    if (viewGroup != null) {
                    }
                    root.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE));
                    return new Size(root.getMeasuredWidth(), root.getMeasuredHeight());
                }
                return new Size(0, 0);
            }
        });
        mainChatOldEarAnimatorHelper.G(new Function3<String, Integer, Integer, Size>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator$createAnimatorHelper$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarCreator.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Size invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Size invoke(@NotNull String text, int i3, int i16) {
                WeakReference weakReference;
                LinearLayout root;
                int i17;
                ViewGroup viewGroup;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Size) iPatchRedirector.redirect((short) 2, this, text, Integer.valueOf(i3), Integer.valueOf(i16));
                }
                Intrinsics.checkNotNullParameter(text, "text");
                weakReference = MainChatOldEarCreator.this.viewRef;
                pw3.a aVar = (pw3.a) weakReference.get();
                if (aVar != null && (root = aVar.getRoot()) != null) {
                    pw3.a g16 = pw3.a.g(LayoutInflater.from(root.getContext()));
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(root.context))");
                    MainChatOldEarCreator.this.n(g16.f427794g, g16.f427791d, text, i3, i16);
                    ViewParent parent = root.getParent();
                    boolean z16 = parent instanceof ViewGroup;
                    ViewGroup viewGroup2 = z16 ? (ViewGroup) parent : null;
                    int i18 = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    if (viewGroup2 != null) {
                        Integer valueOf = Integer.valueOf(viewGroup2.getWidth());
                        if (!(valueOf.intValue() > 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            i17 = valueOf.intValue();
                            viewGroup = !z16 ? (ViewGroup) parent : null;
                            if (viewGroup != null) {
                                Integer valueOf2 = Integer.valueOf(viewGroup.getHeight());
                                Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
                                if (num != null) {
                                    i18 = num.intValue();
                                }
                            }
                            g16.getRoot().measure(View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i18, Integer.MIN_VALUE));
                            return new Size(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                        }
                    }
                    i17 = 1073741823;
                    if (!z16) {
                    }
                    if (viewGroup != null) {
                    }
                    g16.getRoot().measure(View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i18, Integer.MIN_VALUE));
                    return new Size(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                }
                return new Size(0, 0);
            }
        });
        mainChatOldEarAnimatorHelper.J(new Function3<String, Integer, Integer, Unit>() { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator$createAnimatorHelper$1$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarCreator.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, Integer num2) {
                invoke(str, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String text, int i3, int i16) {
                WeakReference weakReference;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, text, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                Intrinsics.checkNotNullParameter(text, "text");
                weakReference = MainChatOldEarCreator.this.viewRef;
                pw3.a aVar = (pw3.a) weakReference.get();
                if (aVar == null) {
                    return;
                }
                MainChatOldEarCreator.this.n(aVar.f427794g, aVar.f427791d, text, i3, i16);
            }
        });
        this.animatorHelper = mainChatOldEarAnimatorHelper;
    }

    private final void k(final pw3.a view) {
        ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).setNextCallback(new Function1<RecentContactInfo, Unit>(view) { // from class: com.tencent.qqnt.chats.main.func.littleear.MainChatOldEarCreator$setChangeCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ pw3.a $view;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$view = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatOldEarCreator.this, (Object) view);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecentContactInfo it) {
                WeakReference weakReference;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isColorLevel()) {
                    QLog.i("MainChatOldEarCreator", 1, "on Next callback");
                }
                weakReference = MainChatOldEarCreator.this.viewRef;
                if (((pw3.a) weakReference.get()) != null) {
                    MainChatOldEarCreator mainChatOldEarCreator = MainChatOldEarCreator.this;
                    LinearLayout root = this.$view.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "view.root");
                    mainChatOldEarCreator.b(root, null);
                }
            }
        });
        this.viewRef = new WeakReference<>(view);
    }

    private final void l(String text, int textColor, @DrawableRes int iconRes) {
        boolean z16;
        boolean z17 = false;
        if (QLog.isColorLevel()) {
            MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper = this.animatorHelper;
            if (mainChatOldEarAnimatorHelper != null && mainChatOldEarAnimatorHelper.y()) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("MainChatOldEarCreator", 1, "showOrStartUpdateAnim hasShown:" + z16 + ", text:" + text);
        }
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper2 = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper2 != null && mainChatOldEarAnimatorHelper2.y()) {
            z17 = true;
        }
        if (z17) {
            MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper3 = this.animatorHelper;
            if (mainChatOldEarAnimatorHelper3 != null) {
                mainChatOldEarAnimatorHelper3.N(text, textColor, iconRes);
                return;
            }
            return;
        }
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper4 = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper4 != null) {
            mainChatOldEarAnimatorHelper4.T(text, textColor, iconRes);
        }
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper5 = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper5 != null) {
            mainChatOldEarAnimatorHelper5.M(this.canShow);
        }
    }

    private final void m() {
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList;
        int i3;
        boolean z16;
        QRouteApi api = QRoute.api(IMainChatEarManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMainChatEarManager::class.java)");
        IMainChatEarManager iMainChatEarManager = (IMainChatEarManager) api;
        RecentContactInfo curItem = ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).getCurItem();
        Object obj = null;
        if (curItem != null) {
            arrayList = curItem.listOfSpecificEventTypeInfosInMsgBox;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return;
        }
        IMainChatEarManager.a parseInfo = iMainChatEarManager.getParseInfo();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SpecificEventTypeInfoInMsgBox) next).eventTypeInMsgBox == 1006) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            if (i.f355238a.a()) {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                Object[] objArr = new Object[1];
                if (parseInfo != null) {
                    i3 = parseInfo.b();
                }
                objArr[0] = Integer.valueOf(i3);
                String string = mobileQQ.getString(R.string.zlj, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(\n   \u2026: 1\n                    )");
                l(string, R.color.qui_common_feedback_error, R.drawable.ms5);
                return;
            }
            MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
            Object[] objArr2 = new Object[1];
            if (parseInfo != null) {
                i3 = parseInfo.b();
            }
            objArr2[0] = Integer.valueOf(i3);
            String string2 = mobileQQ2.getString(R.string.zlj, objArr2);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(\n   \u2026: 1\n                    )");
            l(string2, MobileQQ.sMobileQQ.getColor(R.color.skin_red), R.drawable.hmz);
            return;
        }
        if (i.f355238a.a()) {
            MobileQQ mobileQQ3 = MobileQQ.sMobileQQ;
            Object[] objArr3 = new Object[1];
            if (parseInfo != null) {
                i3 = parseInfo.a();
            }
            objArr3[0] = Integer.valueOf(i3);
            String string3 = mobileQQ3.getString(R.string.zlr, objArr3);
            Intrinsics.checkNotNullExpressionValue(string3, "sMobileQQ.getString(\n   \u2026: 1\n                    )");
            l(string3, R.color.qui_common_feedback_warning, R.drawable.nv7);
            return;
        }
        MobileQQ mobileQQ4 = MobileQQ.sMobileQQ;
        Object[] objArr4 = new Object[1];
        if (parseInfo != null) {
            i3 = parseInfo.a();
        }
        objArr4[0] = Integer.valueOf(i3);
        String string4 = mobileQQ4.getString(R.string.zlr, objArr4);
        Intrinsics.checkNotNullExpressionValue(string4, "sMobileQQ.getString(\n   \u2026: 1\n                    )");
        l(string4, MobileQQ.sMobileQQ.getColor(R.color.ag5), R.drawable.bhp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(TextView tv5, ImageView iv5, String text, int textColor, @DrawableRes int iconRes) {
        if (i.f355238a.a()) {
            if (tv5 != null) {
                tv5.setText(text);
                tv5.setTextColor(ResourcesCompat.getColorStateList(tv5.getResources(), textColor, null));
            }
            if (iv5 != null) {
                iv5.setImageDrawable(ResourcesCompat.getDrawable(iv5.getResources(), iconRes, null));
                return;
            }
            return;
        }
        if (tv5 != null) {
            tv5.setText(text);
        }
        if (tv5 != null) {
            tv5.setTextColor(textColor);
        }
        if (iv5 != null) {
            iv5.setImageResource(iconRes);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    @NotNull
    public View a(@NotNull Context context, @Nullable Map<String, ? extends Object> extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) extra);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarCreator", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        }
        pw3.a h16 = pw3.a.h(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(h16, "inflate(LayoutInflater.from(context), null, false)");
        IMainChatEarManager iMainChatEarManager = (IMainChatEarManager) QRoute.api(IMainChatEarManager.class);
        if (iMainChatEarManager.getCurItem() == null) {
            iMainChatEarManager.moveToNext(false);
        }
        i(h16);
        k(h16);
        j();
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper != null) {
            LinearLayout root = h16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            TextView textView = h16.f427794g;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.recentTabNotificationBarTv");
            TextView textView2 = h16.f427793f;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.recentTabNotificationBarTempTv");
            ImageView imageView = h16.f427791d;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.recentTabNavigationBarMemIcon");
            ImageView imageView2 = h16.f427792e;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.recentTabNavigationBarMemTempIcon");
            mainChatOldEarAnimatorHelper.I(root, textView, textView2, imageView, imageView2);
        }
        LinearLayout root2 = h16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public boolean b(@NotNull View view, @Nullable Map<String, ? extends Object> extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) extra)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarCreator", 1, "bindView");
        }
        if (this.viewRef.get() == null) {
            return false;
        }
        m();
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void c(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, show);
        } else {
            this.canShow = show;
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    @NotNull
    public ThirdViewEnum d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ThirdViewEnum) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ThirdViewEnum.LITTLE_EAR;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void e(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarCreator", 1, QCircleLpReportDc05507.KEY_CLEAR);
        }
        ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).setNextCallback(null);
        this.viewRef.clear();
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper != null) {
            mainChatOldEarAnimatorHelper.H();
        }
        this.animatorHelper = null;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void f(@NotNull View view, boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Boolean.valueOf(isShow));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (QLog.isColorLevel()) {
            QLog.i("MainChatOldEarCreator", 1, "showView isShow: " + isShow);
        }
        if (isShow) {
            MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper = this.animatorHelper;
            if (mainChatOldEarAnimatorHelper != null) {
                mainChatOldEarAnimatorHelper.M(this.canShow);
                return;
            }
            return;
        }
        MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper2 = this.animatorHelper;
        if (mainChatOldEarAnimatorHelper2 != null) {
            mainChatOldEarAnimatorHelper2.B();
        }
    }
}
