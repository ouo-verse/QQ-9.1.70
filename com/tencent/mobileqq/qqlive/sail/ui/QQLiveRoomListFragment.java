package com.tencent.mobileqq.qqlive.sail.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2;
import com.tencent.mobileqq.qqlive.base.room.multipage.controller.VerticalViewPager;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.ForbidSwitchRoomEvent;
import com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment;
import com.tencent.mobileqq.qqlive.sail.ui.close.EndLiveAutoSwitchEvent;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomFeedsViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.initer.impl.LibraryInitManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b*\u00017\u0018\u0000 A2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00103R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveRoomListFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment2;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lqr4/b;", "launchFeed", "", "Fh", "Landroid/content/Intent;", "intent", "Eh", "Bh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onNewIntent", "onDestroyView", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel;", "E", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel;", "feedsViewModel", "Lcom/tencent/mobileqq/qqlive/base/room/multipage/controller/VerticalViewPager;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/base/room/multipage/controller/VerticalViewPager;", "viewPager", "Lcom/tencent/mobileqq/qqlive/sail/ui/h;", "G", "Lcom/tencent/mobileqq/qqlive/sail/ui/h;", "viewPagerAdapter", "", "H", "I", "currentPosition", "Z", "initialPageSelected", "J", "forbidSwitchRoom", "com/tencent/mobileqq/qqlive/sail/ui/QQLiveRoomListFragment$b", "K", "Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveRoomListFragment$b;", "pageChangeCallback", "", "Ch", "()J", "currentRoomId", "<init>", "()V", "L", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRoomListFragment extends QQLiveBaseFragment2 implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedsViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private VerticalViewPager viewPager;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private h viewPagerAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentPosition;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean initialPageSelected;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean forbidSwitchRoom;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b pageChangeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveRoomListFragment$a;", "", "", "FETCH_NEXT_PAGE_LIST_TOLERANCE", "I", "", "KEY_LAUNCH_FEED", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/QQLiveRoomListFragment$b", "Lcom/tencent/mobileqq/qqlive/base/room/multipage/controller/a;", "", "position", "", "onPageSelected", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "state", "onPageScrollStateChanged", "y0", "t1", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.mobileqq.qqlive.base.room.multipage.controller.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRoomListFragment.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), Float.valueOf(positionOffset), Integer.valueOf(positionOffsetPixels));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            long j3;
            qr4.f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Audience|QQLiveRoomListFragment", "onPageSelected", "position=" + position + ", currentPosition=" + QQLiveRoomListFragment.this.currentPosition);
            QQLiveRoomListFragment.this.currentPosition = position;
            QQLiveRoomListFragment.this.Dh().d2(position);
            h hVar = QQLiveRoomListFragment.this.viewPagerAdapter;
            if (hVar != null) {
                QQLiveRoomListFragment qQLiveRoomListFragment = QQLiveRoomListFragment.this;
                if (hVar.getF373114d() - qQLiveRoomListFragment.currentPosition <= 3) {
                    qr4.b g16 = hVar.g();
                    if (g16 != null && (fVar = g16.f429376a) != null) {
                        j3 = fVar.f429397a;
                    } else {
                        j3 = 0;
                    }
                    companion.i("Audience|QQLiveRoomListFragment", "onPageSelected", "fetch next page feeds, request roomId=" + j3);
                    qQLiveRoomListFragment.Dh().Q1(j3);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.base.room.multipage.controller.a
        public void t1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.base.room.multipage.controller.a
        public void y0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveRoomListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment$special$$inlined$viewModels$default$1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Fragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Fragment.this : (Fragment) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.feedsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RoomFeedsViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment$special$$inlined$viewModels$default$2
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Function0.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelStore) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.pageChangeCallback = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r4 != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final qr4.b Bh() {
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        HashMap<String, String> l3;
        HashMap<String, String> l16;
        HashMap<String, String> l17;
        boolean isBlank;
        HashMap<String, String> l18;
        HashMap<String, String> l19;
        Long longOrNull;
        HashMap<String, String> l26;
        HashMap<String, String> l27;
        Long longOrNull2;
        HashMap<String, String> l28;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        qr4.b bVar = new qr4.b();
        String str5 = "";
        if (c16 == null || (l28 = c16.l()) == null || (str = l28.get("platform")) == null) {
            str = "";
        }
        bVar.f429378c = str;
        qr4.f fVar = new qr4.f();
        long j16 = 0;
        if (c16 != null && (l27 = c16.l()) != null && (r6 = l27.get("roomid")) != null && longOrNull2 != null) {
            j3 = longOrNull2.longValue();
        } else {
            j3 = 0;
        }
        fVar.f429397a = j3;
        String str6 = null;
        if (c16 != null && (l26 = c16.l()) != null) {
            str2 = l26.get("cover_url");
        } else {
            str2 = null;
        }
        String decode = Uri.decode(str2);
        if (decode == null) {
            decode = "";
        }
        fVar.f429398b = decode;
        boolean z16 = false;
        fVar.f429402f = 0;
        if (c16 != null && (l19 = c16.l()) != null && (r8 = l19.get(AudienceReportConst.ANCHOR_ID)) != null && longOrNull != null) {
            j16 = longOrNull.longValue();
        }
        fVar.f429408l = j16;
        bVar.f429376a = fVar;
        qr4.g gVar = new qr4.g();
        if (Intrinsics.areEqual("huya", bVar.f429378c)) {
            if (c16 != null && (l18 = c16.l()) != null) {
                str6 = l18.get("huya_origin_url");
            }
            if (str6 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str6);
            }
            z16 = true;
            if (z16) {
                QLog.w("Audience|QQLiveRoomListFragment", 1, "buildLaunchFeed base64Url invalid");
            } else {
                byte[] decode2 = PluginBaseInfoHelper.Base64Helper.decode(str6, 2);
                Intrinsics.checkNotNullExpressionValue(decode2, "decode(base64Url, Base64Helper.NO_WRAP)");
                String decode3 = Uri.decode(new String(decode2, Charsets.UTF_8));
                if (decode3 != null) {
                    str5 = decode3;
                }
                gVar.f429420j = str5;
            }
            gVar.f429413c = true;
        } else {
            if (c16 != null && (l17 = c16.l()) != null) {
                str3 = l17.get("flv_url");
            } else {
                str3 = null;
            }
            String decode4 = Uri.decode(str3);
            if (decode4 == null) {
                decode4 = "";
            }
            gVar.f429420j = decode4;
            if (c16 != null && (l16 = c16.l()) != null) {
                str4 = l16.get("rtmp");
            } else {
                str4 = null;
            }
            String decode5 = Uri.decode(str4);
            if (decode5 != null) {
                str5 = decode5;
            }
            gVar.f429411a = str5;
            if (c16 != null && (l3 = c16.l()) != null) {
                str6 = l3.get("is_use_flv");
            }
            gVar.f429413c = Intrinsics.areEqual(str6, "1");
        }
        bVar.f429377b = gVar;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        qr4.f fVar2 = bVar.f429376a;
        companion.i("Audience|QQLiveRoomListFragment", "buildLaunchFeed", "roomId=" + fVar2.f429397a + ", coverUrl=" + fVar2.f429398b + ", flv=" + gVar.f429420j + ", rtmp=" + gVar.f429411a + ", isUseFlv=" + gVar.f429413c);
        return bVar;
    }

    private final long Ch() {
        qr4.b f16;
        qr4.f fVar;
        h hVar = this.viewPagerAdapter;
        if (hVar != null && (f16 = hVar.f(this.currentPosition)) != null && (fVar = f16.f429376a) != null) {
            return fVar.f429397a;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomFeedsViewModel Dh() {
        return (RoomFeedsViewModel) this.feedsViewModel.getValue();
    }

    private final qr4.b Eh(Intent intent) {
        byte[] bArr;
        if (intent != null) {
            bArr = intent.getByteArrayExtra("key_launch_feed_bytes");
        } else {
            bArr = null;
        }
        if (bArr != null) {
            qr4.b d16 = qr4.b.d(bArr);
            Intrinsics.checkNotNullExpressionValue(d16, "{\n            Feeds.pars\u2026(feedByteArray)\n        }");
            return d16;
        }
        return Bh();
    }

    private final void Fh(qr4.b launchFeed) {
        this.initialPageSelected = false;
        Dh().clear();
        Dh().c2(launchFeed);
        Dh().Q1(launchFeed.f429376a.f429397a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(EndLiveAutoSwitchEvent.class, ForbidSwitchRoomEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        int collectionSizeOrDefault;
        QQLiveAudienceRoomFragment qQLiveAudienceRoomFragment;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        List<Fragment> list = fragments;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (true) {
            qQLiveAudienceRoomFragment = null;
            if (!it.hasNext()) {
                break;
            }
            Fragment fragment = (Fragment) it.next();
            if (fragment instanceof QQLiveAudienceRoomFragment) {
                qQLiveAudienceRoomFragment = (QQLiveAudienceRoomFragment) fragment;
            }
            arrayList.add(qQLiveAudienceRoomFragment);
        }
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            QQLiveAudienceRoomFragment qQLiveAudienceRoomFragment2 = (QQLiveAudienceRoomFragment) next;
            if (qQLiveAudienceRoomFragment2 != null && qQLiveAudienceRoomFragment2.getPosition() == this.currentPosition) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                qQLiveAudienceRoomFragment = next;
                break;
            }
        }
        QQLiveAudienceRoomFragment qQLiveAudienceRoomFragment3 = qQLiveAudienceRoomFragment;
        if (qQLiveAudienceRoomFragment3 == null) {
            return false;
        }
        return qQLiveAudienceRoomFragment3.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        VerticalViewPager verticalViewPager = this.viewPager;
        if (verticalViewPager != null) {
            if (newConfig.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            verticalViewPager.setScrollForbidden(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        xl3.a.b(getContext());
        AppUtils.zInitGlobal(getContext());
        LiveMediaConfigManager liveMediaConfigManager = LiveMediaConfigManager.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        liveMediaConfigManager.initCameraMediaConfig(requireContext);
        mm4.b.d();
        com.tencent.mobileqq.qqlive.sail.b.f272169b.init(getContext());
        LibraryInitManager.f377186a.c();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            setStatusBarImmersive();
            rh(true);
            inflate = inflater.inflate(R.layout.h9q, container, false);
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            this.viewPagerAdapter = new h(childFragmentManager);
            VerticalViewPager verticalViewPager = (VerticalViewPager) inflate.findViewById(R.id.f61512yb);
            Intent intent = null;
            if (verticalViewPager != null) {
                verticalViewPager.setOffscreenPageLimit(1);
                verticalViewPager.setAdapter(this.viewPagerAdapter);
                verticalViewPager.setOnPageChangeListener(this.pageChangeCallback);
            } else {
                verticalViewPager = null;
            }
            this.viewPager = verticalViewPager;
            MutableLiveData<List<qr4.b>> Z1 = Dh().Z1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<List<? extends qr4.b>, Unit> function1 = new Function1<List<? extends qr4.b>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment$onCreateView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRoomListFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends qr4.b> list) {
                    invoke2((List<qr4.b>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<qr4.b> it) {
                    boolean z16;
                    boolean z17;
                    boolean z18;
                    QQLiveRoomListFragment.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    int size = it.size();
                    z16 = QQLiveRoomListFragment.this.forbidSwitchRoom;
                    companion.i("Audience|QQLiveRoomListFragment", "initData", "feeds size=" + size + " forbidSwitchRoom:" + z16);
                    z17 = QQLiveRoomListFragment.this.forbidSwitchRoom;
                    if (z17) {
                        return;
                    }
                    h hVar = QQLiveRoomListFragment.this.viewPagerAdapter;
                    if (hVar != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        hVar.d(it);
                    }
                    z18 = QQLiveRoomListFragment.this.initialPageSelected;
                    if (z18) {
                        return;
                    }
                    bVar = QQLiveRoomListFragment.this.pageChangeCallback;
                    bVar.onPageSelected(0);
                    QQLiveRoomListFragment.this.initialPageSelected = true;
                }
            };
            Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveRoomListFragment.Gh(Function1.this, obj);
                }
            });
            FragmentActivity activity = getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            }
            Fh(Eh(intent));
            SimpleEventBus.getInstance().registerReceiver(this);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        VerticalViewPager verticalViewPager = this.viewPager;
        if (verticalViewPager != null) {
            verticalViewPager.setOnPageChangeListener(null);
        }
        this.viewPager = null;
        this.viewPagerAdapter = null;
        com.tencent.mobileqq.qqlive.sail.ui.orientation.a.f272983a.h();
        com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.e();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        qr4.b Eh = Eh(intent);
        AegisLogger.INSTANCE.i("Audience|QQLiveRoomListFragment", "onNewIntent", "currentRoomId=" + Ch() + ", launchRoomId=" + Eh.f429376a.f429397a);
        if (Eh.f429376a.f429397a == Ch()) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        h hVar = new h(childFragmentManager);
        this.viewPagerAdapter = hVar;
        VerticalViewPager verticalViewPager = this.viewPager;
        if (verticalViewPager != null) {
            verticalViewPager.setAdapter(hVar);
        }
        com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.e();
        Fh(Eh);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        Resources resources;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (event instanceof EndLiveAutoSwitchEvent) {
            EndLiveAutoSwitchEvent endLiveAutoSwitchEvent = (EndLiveAutoSwitchEvent) event;
            int position = endLiveAutoSwitchEvent.getPosition();
            int i3 = this.currentPosition;
            if (position != i3) {
                AegisLogger.INSTANCE.w("Audience|QQLiveRoomListFragment", "onReceiveEvent", "invalid position, from=" + endLiveAutoSwitchEvent.getPosition() + ", current=" + this.currentPosition);
                return;
            }
            h hVar = this.viewPagerAdapter;
            if (hVar != null) {
                int i16 = i3 + 1;
                if (i16 >= hVar.getF373114d()) {
                    AegisLogger.INSTANCE.w("Audience|QQLiveRoomListFragment", "onReceiveEvent", "invalid move, moveTo=" + i16 + ", itemCount=" + hVar.getF373114d());
                    return;
                }
                VerticalViewPager verticalViewPager = this.viewPager;
                if (verticalViewPager != null) {
                    verticalViewPager.setCurrentItem(i16);
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof ForbidSwitchRoomEvent) {
            ForbidSwitchRoomEvent forbidSwitchRoomEvent = (ForbidSwitchRoomEvent) event;
            if (forbidSwitchRoomEvent.getRoomId() != 0 && forbidSwitchRoomEvent.getRoomId() == Ch()) {
                this.forbidSwitchRoom = forbidSwitchRoomEvent.getForbid();
                if (forbidSwitchRoomEvent.isSafeSwitch() && forbidSwitchRoomEvent.getForbid()) {
                    h hVar2 = this.viewPagerAdapter;
                    if (hVar2 != null) {
                        hVar2.e(this.currentPosition);
                    }
                    this.currentPosition = 0;
                    return;
                }
                if (!forbidSwitchRoomEvent.getForbid()) {
                    Context context = getContext();
                    if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        VerticalViewPager verticalViewPager2 = this.viewPager;
                        if (verticalViewPager2 != null) {
                            verticalViewPager2.setScrollForbidden(false);
                            return;
                        }
                        return;
                    }
                }
                VerticalViewPager verticalViewPager3 = this.viewPager;
                if (verticalViewPager3 != null) {
                    verticalViewPager3.setScrollForbidden(true);
                    return;
                }
                return;
            }
            QLog.w("Audience|QQLiveRoomListFragment", 2, "receiver ForbidSwitchRoomEvent but roomId invalid currentRoomId:" + Ch() + " event:" + event);
        }
    }
}
