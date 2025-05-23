package com.tencent.qqnt.qbasealbum.album.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.event.PreviewEnterEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewExitEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.utils.AccessibilityUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001QB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001eH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00106R\u0018\u0010G\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010:R\u0016\u0010J\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerTitleBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/qbasealbum/report/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "L9", "", "isBack", "I9", "J9", "K9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "u3", "", "duration", "onPageOut", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "d", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "albumListViewModel", "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "e", "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "onlineAssetMediaViewModel", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "topBarPart", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "titleRoot", "i", "Landroid/view/View;", "titleAlbumContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "titleAlbumName", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "titleAlbumIcon", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "titleCloseBtn", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "titleOnlineAssetAlbumBtn", UserInfo.SEX_FEMALE, "titleOnlineAssetAlbumName", "G", "titleOnlineAssetAlbumIcon", "H", "J", "impStartTime", "Lcom/tencent/qqnt/qbasealbum/utils/AccessibilityUtils$a;", "I", "Ljava/util/ArrayList;", "responseAccessibilityEventViewHandlers", "<init>", "()V", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerTitleBarPart extends Part implements com.tencent.qqnt.qbasealbum.report.b, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView titleAlbumIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout titleCloseBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout titleOnlineAssetAlbumBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView titleOnlineAssetAlbumName;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView titleOnlineAssetAlbumIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private long impStartTime;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<AccessibilityUtils.a> responseAccessibilityEventViewHandlers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AlbumListViewModel albumListViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.qbasealbum.online.viewmodel.a onlineAssetMediaViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup topBarPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout titleRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View titleAlbumContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleAlbumName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerTitleBarPart$a;", "", "", "TAG", "Ljava/lang/String;", "", "albumBtnRotateDegree", UserInfo.SEX_FEMALE, "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PickerTitleBarPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.responseAccessibilityEventViewHandlers = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(boolean isBack) {
        float f16;
        CharSequence charSequence;
        String str;
        float f17 = 180.0f;
        if (isBack) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        if (isBack) {
            f17 = 360.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, f17, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        ImageView imageView = this.titleAlbumIcon;
        if (imageView != null) {
            imageView.startAnimation(rotateAnimation);
        }
        View view = this.titleAlbumContainer;
        if (view != null) {
            TextView textView = this.titleAlbumName;
            if (textView != null) {
                charSequence = textView.getText();
            } else {
                charSequence = null;
            }
            if (isBack) {
                str = "\u6536\u8d77";
            } else {
                str = "\u5c55\u5f00";
            }
            view.setContentDescription(((Object) charSequence) + " \u5df2" + str);
        }
    }

    private final void J9() {
        boolean z16;
        TextView textView = this.titleAlbumName;
        if (textView != null && textView.isSelected()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AlbumListViewModel albumListViewModel = this.albumListViewModel;
            if (albumListViewModel != null) {
                albumListViewModel.Q1();
                return;
            }
            return;
        }
        TextView textView2 = this.titleAlbumName;
        if (textView2 != null) {
            textView2.setSelected(true);
        }
        ImageView imageView = this.titleAlbumIcon;
        if (imageView != null) {
            imageView.setSelected(true);
        }
        TextView textView3 = this.titleOnlineAssetAlbumName;
        if (textView3 != null) {
            textView3.setSelected(false);
        }
        ImageView imageView2 = this.titleOnlineAssetAlbumIcon;
        if (imageView2 != null) {
            imageView2.setSelected(false);
        }
        ImageView imageView3 = this.titleOnlineAssetAlbumIcon;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.n6b);
        }
        if (QAlbumPickerContext.f361201a.e().n().a()) {
            TextView textView4 = this.titleAlbumName;
            if (textView4 != null) {
                textView4.setTypeface(Typeface.DEFAULT_BOLD);
            }
            TextView textView5 = this.titleOnlineAssetAlbumName;
            if (textView5 != null) {
                textView5.setTypeface(Typeface.DEFAULT);
            }
        }
        com.tencent.qqnt.qbasealbum.online.viewmodel.a aVar = this.onlineAssetMediaViewModel;
        if (aVar != null) {
            aVar.j2(false);
        }
    }

    private final void K9() {
        boolean z16;
        MutableLiveData<Boolean> mutableLiveData;
        MutableLiveData<Boolean> U1;
        TextView textView = this.titleOnlineAssetAlbumName;
        boolean z17 = false;
        if (textView != null && !textView.isSelected()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        TextView textView2 = this.titleAlbumName;
        if (textView2 != null) {
            textView2.setSelected(false);
        }
        ImageView imageView = this.titleAlbumIcon;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView3 = this.titleOnlineAssetAlbumName;
        if (textView3 != null) {
            textView3.setSelected(true);
        }
        ImageView imageView2 = this.titleOnlineAssetAlbumIcon;
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
        ImageView imageView3 = this.titleOnlineAssetAlbumIcon;
        if (imageView3 != null) {
            com.tencent.qqnt.qbasealbum.ktx.d.e(imageView3, R.drawable.n66);
        }
        if (QAlbumPickerContext.f361201a.e().n().a()) {
            TextView textView4 = this.titleAlbumName;
            if (textView4 != null) {
                textView4.setTypeface(Typeface.DEFAULT);
            }
            TextView textView5 = this.titleOnlineAssetAlbumName;
            if (textView5 != null) {
                textView5.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
        AlbumListViewModel albumListViewModel = this.albumListViewModel;
        if (albumListViewModel != null && (U1 = albumListViewModel.U1()) != null) {
            z17 = Intrinsics.areEqual(U1.getValue(), Boolean.TRUE);
        }
        if (z17) {
            AlbumListViewModel albumListViewModel2 = this.albumListViewModel;
            if (albumListViewModel2 != null) {
                mutableLiveData = albumListViewModel2.U1();
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.FALSE);
            }
        }
        com.tencent.qqnt.qbasealbum.online.viewmodel.a aVar = this.onlineAssetMediaViewModel;
        if (aVar != null) {
            aVar.j2(true);
        }
    }

    private final void L9() {
        List<View> listOf;
        Map mapOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.titleAlbumContainer, this.titleCloseBtn});
        for (View view : listOf) {
            if (view != null) {
                ArrayList<AccessibilityUtils.a> arrayList = this.responseAccessibilityEventViewHandlers;
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.f361618a;
                Function2<Object, View, Unit> c16 = accessibilityUtils.c();
                Function2<Object, View, Unit> d16 = accessibilityUtils.d();
                WeakReference weakReference = new WeakReference(view);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(PreviewEnterEvent.class, c16), TuplesKt.to(PreviewExitEvent.class, d16));
                arrayList.add(new AccessibilityUtils.a(weakReference, mapOf));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final PickerTitleBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c("em_bas_album_source_selection", 2, new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onInitView$2$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerTitleBarPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                TextView textView;
                Map<String, ? extends Object> mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                textView = PickerTitleBarPart.this.titleAlbumName;
                CharSequence text = textView != null ? textView.getText() : null;
                if (text == null) {
                    text = "";
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("show_type", text));
                return mapOf;
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(PickerTitleBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this$0);
        if (a16 != null) {
            a16.onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(PickerTitleBarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(PickerTitleBarPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int a16 = com.tencent.biz.qui.quicommon.e.a(15.0f);
        com.tencent.qqnt.qbasealbum.utils.d.f361649a.d(this$0.titleCloseBtn, a16, a16, a16, a16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
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
        return "PickerTitleBarPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        com.tencent.qqnt.qbasealbum.online.viewmodel.a aVar;
        View view;
        TextView textView;
        ImageView imageView;
        MutableLiveData<Boolean> U1;
        LiveData<com.tencent.qqnt.qbasealbum.model.b> W1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            this.onlineAssetMediaViewModel = com.tencent.qqnt.qbasealbum.album.b.e(a16);
            AlbumListViewModel a17 = com.tencent.qqnt.qbasealbum.album.b.a(a16);
            this.albumListViewModel = a17;
            if (a17 != null && (W1 = a17.W1()) != null) {
                LifecycleOwner viewLifecycleOwner = a16.getViewLifecycleOwner();
                final Function1<com.tencent.qqnt.qbasealbum.model.b, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.model.b, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onInitView$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerTitleBarPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.model.b bVar) {
                        invoke2(bVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.qbasealbum.model.b bVar) {
                        TextView textView2;
                        long j3;
                        TextView textView3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                            return;
                        }
                        textView2 = PickerTitleBarPart.this.titleAlbumName;
                        if (!Intrinsics.areEqual(textView2 != null ? textView2.getText() : null, bVar.f())) {
                            long currentTimeMillis = System.currentTimeMillis();
                            j3 = PickerTitleBarPart.this.impStartTime;
                            com.tencent.qqnt.qbasealbum.report.c cVar = com.tencent.qqnt.qbasealbum.report.c.f361503a;
                            cVar.d("show_type", 2, new Function0<Map<String, ? extends Object>>(currentTimeMillis - j3) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onInitView$1$1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ long $duration;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$duration = r6;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, PickerTitleBarPart.this, Long.valueOf(r6));
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Map<String, ? extends Object> invoke() {
                                    TextView textView4;
                                    Map<String, ? extends Object> mapOf;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        return (Map) iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                    Pair[] pairArr = new Pair[2];
                                    textView4 = PickerTitleBarPart.this.titleAlbumName;
                                    CharSequence text = textView4 != null ? textView4.getText() : null;
                                    if (text == null) {
                                        text = "";
                                    }
                                    pairArr[0] = TuplesKt.to("show_type", text);
                                    pairArr[1] = TuplesKt.to("qq_element_lvtm", Long.valueOf(this.$duration));
                                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                                    return mapOf;
                                }
                            });
                            textView3 = PickerTitleBarPart.this.titleAlbumName;
                            if (textView3 != null) {
                                textView3.setText(bVar.f());
                            }
                            PickerTitleBarPart.this.impStartTime = System.currentTimeMillis();
                            cVar.e("show_type", 2, new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onInitView$1$1.2
                                static IPatchRedirector $redirector_;

                                {
                                    super(0);
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) PickerTitleBarPart.this);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Map<String, ? extends Object> invoke() {
                                    TextView textView4;
                                    Map<String, ? extends Object> mapOf;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        return (Map) iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                    textView4 = PickerTitleBarPart.this.titleAlbumName;
                                    CharSequence text = textView4 != null ? textView4.getText() : null;
                                    if (text == null) {
                                        text = "";
                                    }
                                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("show_type", text));
                                    return mapOf;
                                }
                            });
                        }
                    }
                };
                W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.t
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        PickerTitleBarPart.M9(Function1.this, obj);
                    }
                });
            }
            AlbumListViewModel albumListViewModel = this.albumListViewModel;
            if (albumListViewModel != null && (U1 = albumListViewModel.U1()) != null) {
                LifecycleOwner viewLifecycleOwner2 = a16.getViewLifecycleOwner();
                final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onInitView$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerTitleBarPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Boolean bool) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                            return;
                        }
                        PickerTitleBarPart pickerTitleBarPart = PickerTitleBarPart.this;
                        Intrinsics.checkNotNull(bool);
                        pickerTitleBarPart.I9(!bool.booleanValue());
                    }
                };
                U1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.u
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        PickerTitleBarPart.N9(Function1.this, obj);
                    }
                });
            }
        }
        this.titleRoot = (LinearLayout) rootView.findViewById(R.id.f25220a9);
        View findViewById = rootView.findViewById(R.id.f98055m2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.titleBarLayout)");
        this.topBarPart = (ViewGroup) findViewById;
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = customizationFacade.b();
        if (b16 != null) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            ViewGroup viewGroup = this.topBarPart;
            FrameLayout frameLayout = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarPart");
                viewGroup = null;
            }
            View titleView = b16.getTitleView(context, viewGroup);
            if (titleView != null) {
                ViewGroup viewGroup2 = this.topBarPart;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBarPart");
                    viewGroup2 = null;
                }
                viewGroup2.addView(titleView);
                ViewGroup viewGroup3 = this.topBarPart;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBarPart");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(0);
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b17 = customizationFacade.b();
                if (b17 != null) {
                    view = b17.getTitleAlbumContainer();
                } else {
                    view = null;
                }
                this.titleAlbumContainer = view;
                if (view != null) {
                    view.setContentDescription("\u6700\u8fd1\u7167\u7247 \u5df2\u6536\u8d77");
                }
                View view2 = this.titleAlbumContainer;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.v
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PickerTitleBarPart.O9(PickerTitleBarPart.this, view3);
                        }
                    });
                }
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b18 = customizationFacade.b();
                if (b18 != null) {
                    textView = b18.getTitleAlbumName();
                } else {
                    textView = null;
                }
                this.titleAlbumName = textView;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b19 = customizationFacade.b();
                if (b19 != null) {
                    imageView = b19.getTitleAlbumIcon();
                } else {
                    imageView = null;
                }
                this.titleAlbumIcon = imageView;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b26 = customizationFacade.b();
                if (b26 != null) {
                    frameLayout = b26.getTitleCloseBtn();
                }
                this.titleCloseBtn = frameLayout;
                if (frameLayout != null) {
                    frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.w
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PickerTitleBarPart.P9(PickerTitleBarPart.this, view3);
                        }
                    });
                }
            }
        }
        if (QAlbumPickerContext.f361201a.e().n().a()) {
            this.titleOnlineAssetAlbumName = (TextView) rootView.findViewById(R.id.f25100_x);
            this.titleOnlineAssetAlbumIcon = (ImageView) rootView.findViewById(R.id.f25090_w);
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f25180a5);
            this.titleOnlineAssetAlbumBtn = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        PickerTitleBarPart.Q9(PickerTitleBarPart.this, view3);
                    }
                });
            }
            RelativeLayout relativeLayout2 = this.titleOnlineAssetAlbumBtn;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (com.tencent.qqnt.qbasealbum.utils.i.f361663a.a(getContext()) && (aVar = this.onlineAssetMediaViewModel) != null) {
                aVar.i2(this.titleOnlineAssetAlbumName);
            }
        } else {
            RelativeLayout relativeLayout3 = this.titleOnlineAssetAlbumBtn;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
        }
        J9();
        FrameLayout frameLayout2 = this.titleCloseBtn;
        if (frameLayout2 != null) {
            frameLayout2.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    PickerTitleBarPart.R9(PickerTitleBarPart.this);
                }
            });
        }
        L9();
    }

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void onPageOut(long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, duration);
        } else {
            if (this.impStartTime == 0) {
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis() - this.impStartTime;
            com.tencent.qqnt.qbasealbum.report.c.f361503a.d("em_bas_album_source_selection", 2, new Function0<Map<String, ? extends Object>>(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onPageOut$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $myDuration;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$myDuration = currentTimeMillis;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PickerTitleBarPart.this, Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<String, ? extends Object> invoke() {
                    TextView textView;
                    Map<String, ? extends Object> mapOf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Pair[] pairArr = new Pair[2];
                    textView = PickerTitleBarPart.this.titleAlbumName;
                    CharSequence text = textView != null ? textView.getText() : null;
                    if (text == null) {
                        text = "";
                    }
                    pairArr[0] = TuplesKt.to("show_type", text);
                    pairArr[1] = TuplesKt.to("qq_element_lvtm", Long.valueOf(this.$myDuration));
                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                    return mapOf;
                }
            });
            this.impStartTime = 0L;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        LinearLayout linearLayout = this.titleRoot;
        if (linearLayout != null) {
            if (com.tencent.qqnt.qbasealbum.utils.i.f361663a.a(getContext())) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            linearLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        Function2<Object, View, Unit> function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
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

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.qqnt.qbasealbum.report.c.f361503a.e("em_bas_album_source_selection", 2, new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart$onPageIn$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerTitleBarPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<String, ? extends Object> invoke() {
                    TextView textView;
                    Map<String, ? extends Object> mapOf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    textView = PickerTitleBarPart.this.titleAlbumName;
                    CharSequence text = textView != null ? textView.getText() : null;
                    if (text == null) {
                        text = "";
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("show_type", text));
                    return mapOf;
                }
            });
            this.impStartTime = System.currentTimeMillis();
        }
    }
}
