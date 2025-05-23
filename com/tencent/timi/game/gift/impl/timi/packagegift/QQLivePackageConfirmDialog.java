package com.tencent.timi.game.gift.impl.timi.packagegift;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mt3.d;
import mt3.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wi2.c;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002.\fB\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "i", "Lmt3/d;", "rsp", h.F, "Landroid/view/View;", "g", "Landroid/widget/PopupWindow;", "a", "Landroid/widget/PopupWindow;", "popupWin", "b", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "mConfirmTv", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mDots", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mIndicatorContainer", "Landroidx/viewpager2/widget/ViewPager2;", "f", "Landroidx/viewpager2/widget/ViewPager2;", "mPackageViewPager", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/b;", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/b;", "mPackageViewPagerAdapter", "Lmt3/d;", "mCheckNewPackageRsp", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$a;", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$a;", "mListener", "<init>", "()V", "j", "Companion", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLivePackageConfirmDialog {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mConfirmTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mIndicatorContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 mPackageViewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mCheckNewPackageRsp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<View> mDots = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.timi.game.gift.impl.timi.packagegift.b mPackageViewPagerAdapter = new com.tencent.timi.game.gift.impl.timi.packagegift.b();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$Companion;", "", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog;", "dialog", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$a;", "listener", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(QQLivePackageConfirmDialog dialog, Activity activity) {
            PopupWindow popupWindow = new PopupWindow(dialog.g(activity), -1, -1);
            popupWindow.setAnimationStyle(R.style.f246468z);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setAnimationStyle(R.style.b0e);
            dialog.popupWin = popupWindow;
            popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog, T] */
        @JvmStatic
        public final void b(@NotNull final Activity activity, @NotNull final a listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(listener, "listener");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new QQLivePackageConfirmDialog();
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveCheckPackageRequest(), new Function1<QQLiveResponse<d>, Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog$Companion$show$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<d> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<d> response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    d rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        g[] gVarArr = rsp.f417548a;
                        boolean z16 = true;
                        if (gVarArr != null) {
                            if (!(gVarArr.length == 0)) {
                                z16 = false;
                            }
                        }
                        if (!z16) {
                            objectRef.element.mCheckNewPackageRsp = rsp;
                            objectRef.element.mListener = listener;
                            QQLivePackageConfirmDialog.INSTANCE.c(objectRef.element, activity);
                            return;
                        }
                        AegisLogger.INSTANCE.e("VSRequest|QQLiveCheckPackageRequest", "QQLiveCheckPackageRequest", "is empty");
                        return;
                    }
                    AegisLogger.INSTANCE.e("VSRequest|QQLiveCheckPackageRequest", "QQLiveCheckPackageRequest", "failed errorCode=" + response.getRetCode() + ",errorMsg=" + response.getErrMsg());
                }
            });
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$a;", "", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/gift/impl/timi/packagegift/QQLivePackageConfirmDialog$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f377171c;

        b(Activity activity) {
            this.f377171c = activity;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            Drawable drawable;
            Resources resources;
            Resources resources2;
            if (QQLivePackageConfirmDialog.this.mDots.size() > position) {
                Iterator it = QQLivePackageConfirmDialog.this.mDots.iterator();
                while (true) {
                    drawable = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    View view = (View) it.next();
                    Activity activity = this.f377171c;
                    if (activity != null && (resources2 = activity.getResources()) != null) {
                        drawable = resources2.getDrawable(R.drawable.lsc);
                    }
                    view.setBackground(drawable);
                }
                View view2 = (View) QQLivePackageConfirmDialog.this.mDots.get(position);
                Activity activity2 = this.f377171c;
                if (activity2 != null && (resources = activity2.getResources()) != null) {
                    drawable = resources.getDrawable(R.drawable.lsd);
                }
                view2.setBackground(drawable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(d rsp) {
        boolean z16;
        Context context;
        Context context2;
        Resources resources;
        boolean z17;
        if (rsp != null) {
            g[] gVarArr = rsp.f417548a;
            if (gVarArr != null) {
                if (gVarArr.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = false;
                    if (z16) {
                        ArrayList<g> arrayList = new ArrayList<>();
                        ArrayList<ArrayList<g>> arrayList2 = new ArrayList<>();
                        int length = rsp.f417548a.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            int i16 = i3 % 4;
                            if (i16 == 0) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(rsp.f417548a[i3]);
                            if (i16 == 3 || i3 == rsp.f417548a.length - 1) {
                                arrayList2.add(arrayList);
                            }
                        }
                        this.mPackageViewPagerAdapter.k0(arrayList2);
                        if (arrayList2.size() <= 1) {
                            return;
                        }
                        int size = arrayList2.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            LinearLayout linearLayout = this.mIndicatorContainer;
                            Drawable drawable = null;
                            if (linearLayout != null) {
                                context = linearLayout.getContext();
                            } else {
                                context = null;
                            }
                            View view = new View(context);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.b(4), c.b(4));
                            layoutParams.leftMargin = c.b(2);
                            layoutParams.rightMargin = c.b(2);
                            view.setLayoutParams(layoutParams);
                            LinearLayout linearLayout2 = this.mIndicatorContainer;
                            if (linearLayout2 != null && (context2 = linearLayout2.getContext()) != null && (resources = context2.getResources()) != null) {
                                drawable = resources.getDrawable(R.drawable.lsc);
                            }
                            view.setBackground(drawable);
                            this.mDots.add(view);
                            LinearLayout linearLayout3 = this.mIndicatorContainer;
                            if (linearLayout3 != null) {
                                linearLayout3.addView(view);
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    private final void i(Activity activity) {
        LinearLayout linearLayout;
        ViewPager2 viewPager2;
        View view = this.mRootView;
        TextView textView = null;
        if (view != null) {
            linearLayout = (LinearLayout) view.findViewById(R.id.xme);
        } else {
            linearLayout = null;
        }
        this.mIndicatorContainer = linearLayout;
        View view2 = this.mRootView;
        if (view2 != null) {
            viewPager2 = (ViewPager2) view2.findViewById(R.id.f166400zq0);
        } else {
            viewPager2 = null;
        }
        this.mPackageViewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.mPackageViewPagerAdapter);
        }
        ViewPager2 viewPager22 = this.mPackageViewPager;
        if (viewPager22 != null) {
            viewPager22.registerOnPageChangeCallback(new b(activity));
        }
        View view3 = this.mRootView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.b7p);
        }
        this.mConfirmTv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.gift.impl.timi.packagegift.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QQLivePackageConfirmDialog.j(QQLivePackageConfirmDialog.this, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final QQLivePackageConfirmDialog this$0, View view) {
        String[] strArr;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.mCheckNewPackageRsp;
        if (dVar != null) {
            strArr = dVar.f417549b;
        } else {
            strArr = null;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveAddPackageRequest(strArr), new Function1<QQLiveResponse<mt3.b>, Unit>() { // from class: com.tencent.timi.game.gift.impl.timi.packagegift.QQLivePackageConfirmDialog$initView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<mt3.b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<mt3.b> response) {
                QQLivePackageConfirmDialog.a aVar;
                Intrinsics.checkNotNullParameter(response, "response");
                mt3.b rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    aVar = QQLivePackageConfirmDialog.this.mListener;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.e("VSRequest|QQLiveCheckPackageRequest", "QQLiveAddPackageRequest", "failed errorCode=" + response.getRetCode() + ",errorMsg=" + response.getErrMsg());
            }
        });
        PopupWindow popupWindow = this$0.popupWin;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final View g(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mRootView = LayoutInflater.from(activity).inflate(R.layout.hah, (ViewGroup) null, false);
        i(activity);
        h(this.mCheckNewPackageRsp);
        View view = this.mRootView;
        Intrinsics.checkNotNull(view);
        return view;
    }
}
