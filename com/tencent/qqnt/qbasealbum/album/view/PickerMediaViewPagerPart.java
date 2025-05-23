package com.tencent.qqnt.qbasealbum.album.view;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerTabFragment;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.event.PreviewEnterEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewExitEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.utils.AccessibilityUtils;
import com.tencent.qqnt.qbasealbum.view.NoScrollViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000278B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\nJ\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001eH\u0016R$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001ej\b\u0012\u0004\u0012\u00020\u0013`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010#\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaViewPagerPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "G9", "H9", "K9", "", "isChecked", "", "E9", "F9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "index", "Lcom/tencent/qqnt/qbasealbum/album/fragment/QAlbumPickerTabFragment;", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mediaListTabPageFragments", "Lcom/tencent/qqnt/qbasealbum/view/NoScrollViewPager;", "e", "Lcom/tencent/qqnt/qbasealbum/view/NoScrollViewPager;", "viewPager", "Landroid/widget/RadioGroup;", "f", "Landroid/widget/RadioGroup;", "tabsGroup", "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", tl.h.F, "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "onlineAssetMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/utils/AccessibilityUtils$a;", "i", "responseAccessibilityEventViewHandlers", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerMediaViewPagerPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<QAlbumPickerTabFragment> mediaListTabPageFragments;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NoScrollViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RadioGroup tabsGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.qbasealbum.online.viewmodel.a onlineAssetMediaViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<AccessibilityUtils.a> responseAccessibilityEventViewHandlers;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaViewPagerPart$a;", "", "", "TAG", "Ljava/lang/String;", "", "VIEW_PAGER_OFFSET_LIMIT", "I", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.view.PickerMediaViewPagerPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaViewPagerPart$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "<init>", "(Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaViewPagerPart;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class b extends FragmentPagerAdapter {
        static IPatchRedirector $redirector_;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b() {
            super(((Fragment) r0).getChildFragmentManager(), 1);
            Object partHost = PickerMediaViewPagerPart.this.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaViewPagerPart.this);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return PickerMediaViewPagerPart.this.mediaListTabPageFragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            Object obj = PickerMediaViewPagerPart.this.mediaListTabPageFragments.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mediaListTabPageFragments[position]");
            return (Fragment) obj;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360777a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32534);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.TAB_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.TAB_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.TAB_MEDIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f360777a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/PickerMediaViewPagerPart$d", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "onPageSelected", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerMediaViewPagerPart.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            View childAt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RadioGroup radioGroup = PickerMediaViewPagerPart.this.tabsGroup;
                if (radioGroup != null && (childAt = radioGroup.getChildAt(position)) != null) {
                    childAt.performClick();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, position);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PickerMediaViewPagerPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mediaListTabPageFragments = new ArrayList<>(3);
            this.responseAccessibilityEventViewHandlers = new ArrayList<>();
        }
    }

    private final int E9(boolean isChecked) {
        if (isChecked) {
            return ContextCompat.getColor(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), R.color.c_5);
        }
        return ContextCompat.getColor(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), R.color.c_6);
    }

    private final boolean F9() {
        if (QAlbumPickerContext.f361201a.e().e() == TabType.TAB_ALL) {
            return true;
        }
        return false;
    }

    private final void G9() {
        List<View> listOf;
        Map mapOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.viewPager);
        for (View view : listOf) {
            if (view != null) {
                ArrayList<AccessibilityUtils.a> arrayList = this.responseAccessibilityEventViewHandlers;
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.f361618a;
                Function2<Object, View, Unit> b16 = accessibilityUtils.b();
                Function2<Object, View, Unit> a16 = accessibilityUtils.a();
                WeakReference weakReference = new WeakReference(view);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(PreviewEnterEvent.class, b16), TuplesKt.to(PreviewExitEvent.class, a16));
                arrayList.add(new AccessibilityUtils.a(weakReference, mapOf));
            }
        }
    }

    private final void H9() {
        this.tabsGroup = (RadioGroup) getPartRootView().findViewById(R.id.f166210z05);
        if (!F9()) {
            RadioGroup radioGroup = this.tabsGroup;
            if (radioGroup != null) {
                radioGroup.setVisibility(8);
                return;
            }
            return;
        }
        RadioButton radioButton = (RadioButton) getPartRootView().findViewById(R.id.f916455q);
        RadioButton radioButton2 = (RadioButton) getPartRootView().findViewById(R.id.f916755t);
        RadioButton radioButton3 = (RadioButton) getPartRootView().findViewById(R.id.f919056f);
        if (radioButton != null) {
            radioButton.setTypeface(Typeface.DEFAULT_BOLD);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.r
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PickerMediaViewPagerPart.I9(PickerMediaViewPagerPart.this, compoundButton, z16);
            }
        };
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if (radioButton2 != null) {
            radioButton2.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if (radioButton3 != null) {
            radioButton3.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if (radioButton != null) {
            radioButton.setTextColor(E9(radioButton.isChecked()));
        }
        if (radioButton2 != null) {
            radioButton2.setTextColor(E9(radioButton2.isChecked()));
        }
        if (radioButton3 != null) {
            radioButton3.setTextColor(E9(radioButton3.isChecked()));
        }
        RadioGroup radioGroup2 = this.tabsGroup;
        if (radioGroup2 != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.s
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i3) {
                    PickerMediaViewPagerPart.J9(PickerMediaViewPagerPart.this, radioGroup3, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(PickerMediaViewPagerPart this$0, CompoundButton compoundButton, boolean z16) {
        Typeface typeface;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        compoundButton.setTextColor(this$0.E9(z16));
        if (z16) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        compoundButton.setTypeface(typeface);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(PickerMediaViewPagerPart this$0, RadioGroup radioGroup, int i3) {
        NoScrollViewPager noScrollViewPager;
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == R.id.f916455q) {
            NoScrollViewPager noScrollViewPager2 = this$0.viewPager;
            if (noScrollViewPager2 != null) {
                noScrollViewPager2.setCurrentItem(0);
            }
        } else if (i3 == R.id.f919056f) {
            NoScrollViewPager noScrollViewPager3 = this$0.viewPager;
            if (noScrollViewPager3 != null) {
                noScrollViewPager3.setCurrentItem(1);
            }
        } else if (i3 == R.id.f916755t && (noScrollViewPager = this$0.viewPager) != null) {
            noScrollViewPager.setCurrentItem(2);
        }
        EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
    }

    private final void K9() {
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) getPartRootView().findViewById(R.id.f166209z04);
        this.viewPager = noScrollViewPager;
        if (noScrollViewPager != null) {
            noScrollViewPager.setOffscreenPageLimit(2);
            noScrollViewPager.setAdapter(new b());
            noScrollViewPager.addOnPageChangeListener(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public final QAlbumPickerTabFragment D9(int index) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaListTabPageFragments, 0);
            return (QAlbumPickerTabFragment) orNull;
        }
        return (QAlbumPickerTabFragment) iPatchRedirector.redirect((short) 4, (Object) this, index);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(PreviewEnterEvent.class);
        arrayList.add(PreviewExitEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PickerMediaViewPagerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull final View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ArrayList<QAlbumPickerTabFragment> arrayList = this.mediaListTabPageFragments;
        arrayList.clear();
        int i3 = c.f360777a[QAlbumPickerContext.f361201a.e().e().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QAlbumPickerTabFragment.Companion companion = QAlbumPickerTabFragment.INSTANCE;
                    arrayList.add(companion.a(PageType.LOCAL_ALL));
                    arrayList.add(companion.a(PageType.LOCAL_VIDEO));
                    arrayList.add(companion.a(PageType.LOCAL_IMAGE));
                } else {
                    arrayList.add(QAlbumPickerTabFragment.INSTANCE.a(PageType.LOCAL_ALL));
                }
            } else {
                arrayList.add(QAlbumPickerTabFragment.INSTANCE.a(PageType.LOCAL_IMAGE));
            }
        } else {
            arrayList.add(QAlbumPickerTabFragment.INSTANCE.a(PageType.LOCAL_VIDEO));
        }
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            com.tencent.qqnt.qbasealbum.online.viewmodel.a e16 = com.tencent.qqnt.qbasealbum.album.b.e(a16);
            LiveData<Boolean> h26 = e16.h2();
            LifecycleOwner viewLifecycleOwner = a16.getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(rootView) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerMediaViewPagerPart$onInitView$2$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $rootView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$rootView = rootView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) rootView);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    View findViewById = this.$rootView.findViewById(R.id.yzi);
                    if (findViewById != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        findViewById.setVisibility(it.booleanValue() ? 8 : 0);
                    }
                }
            };
            h26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PickerMediaViewPagerPart.L9(Function1.this, obj);
                }
            });
            this.onlineAssetMediaViewModel = e16;
        }
        H9();
        K9();
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (F9()) {
            if (com.tencent.qqnt.qbasealbum.utils.i.f361663a.a(getContext())) {
                RadioGroup radioGroup = this.tabsGroup;
                if (radioGroup != null) {
                    radioGroup.setVisibility(0);
                    return;
                }
                return;
            }
            RadioGroup radioGroup2 = this.tabsGroup;
            if (radioGroup2 != null) {
                radioGroup2.setVisibility(4);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        Function2<Object, View, Unit> function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if (event instanceof PreviewEnterEvent) {
            z16 = true;
        } else {
            z16 = event instanceof PreviewExitEvent;
        }
        if (z16) {
            for (AccessibilityUtils.a aVar : this.responseAccessibilityEventViewHandlers) {
                View view = aVar.b().get();
                if (view != null && (function2 = aVar.a().get(event.getClass())) != null) {
                    function2.invoke(event, view);
                }
            }
        }
    }
}
