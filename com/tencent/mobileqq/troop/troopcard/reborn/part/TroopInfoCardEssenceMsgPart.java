package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.gcore.abase.utils.PatternUtils;
import com.google.android.material.appbar.AlwaysCanDragFlingAppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceEmptyTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceGuideTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceMessageTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssencePhotoVideoTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 F2\u00020\u0001:\u0003GHIB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0018\u00010*R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "S9", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "R9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "onPartPause", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "title", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "f", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager/widget/ViewPager;", tl.h.F, "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "i", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "toolbarLayout", "Lcom/google/android/material/appbar/AlwaysCanDragFlingAppBarLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/google/android/material/appbar/AlwaysCanDragFlingAppBarLayout;", "appBarLayout", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$b;", "adapter", "D", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "gestureLayout", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "E", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "essenceViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$TabInfo;", "G", "Ljava/util/List;", "tabBarList", "", "H", "Z", "isFileTabInitialized", "I", "isMsgTabInitialized", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "J", "a", "b", "TabInfo", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardEssenceMsgPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TopGestureLayout gestureLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopInfoCardEssenceViewModel essenceViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopBasicInfoViewModel basicInfoViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<? extends TabInfo> tabBarList;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isFileTabInitialized;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isMsgTabInitialized;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager viewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CollapsingToolbarLayout toolbarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AlwaysCanDragFlingAppBarLayout appBarLayout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$TabInfo;", "", "title", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "FILE", "PHOTO_VIDEO", "MESSAGE", PatternUtils.NO_MATCH, "GUIDE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TabInfo {
        private static final /* synthetic */ TabInfo[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TabInfo EMPTY;
        public static final TabInfo FILE;
        public static final TabInfo GUIDE;
        public static final TabInfo MESSAGE;
        public static final TabInfo PHOTO_VIDEO;

        @NotNull
        private final String title;

        private static final /* synthetic */ TabInfo[] $values() {
            return new TabInfo[]{FILE, PHOTO_VIDEO, MESSAGE, EMPTY, GUIDE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57202);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            FILE = new TabInfo("FILE", 0, "\u6587\u4ef6");
            PHOTO_VIDEO = new TabInfo("PHOTO_VIDEO", 1, "\u56fe\u7247/\u89c6\u9891");
            MESSAGE = new TabInfo("MESSAGE", 2, QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME);
            EMPTY = new TabInfo(PatternUtils.NO_MATCH, 3, "");
            GUIDE = new TabInfo("GUIDE", 4, "");
            $VALUES = $values();
        }

        TabInfo(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.title = str2;
            }
        }

        public static TabInfo valueOf(String str) {
            return (TabInfo) Enum.valueOf(TabInfo.class, str);
        }

        public static TabInfo[] values() {
            return (TabInfo[]) $VALUES.clone();
        }

        @NotNull
        public final String getTitle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J$\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0006\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b\u0007\u0010\"\"\u0004\b&\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$TabInfo;", "list", "", "isFileTabInitialized", "isMsgTabInitialized", "", "d", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "", "getItemId", "", "object", "getItemPosition", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "finishUpdate", "Ljava/util/List;", "tabList", "e", "J", "getTime", "()J", "setTime", "(J)V", "time", "f", "Z", "()Z", "setFileTabInitialized", "(Z)V", tl.h.F, "setMsgTabInitialized", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart;Landroidx/fragment/app/FragmentManager;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends FragmentPagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends TabInfo> tabList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long time;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isFileTabInitialized;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean isMsgTabInitialized;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TroopInfoCardEssenceMsgPart f299569i;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes19.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f299570a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57192);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[TabInfo.values().length];
                try {
                    iArr[TabInfo.FILE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TabInfo.PHOTO_VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TabInfo.MESSAGE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TabInfo.EMPTY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TabInfo.GUIDE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f299570a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull TroopInfoCardEssenceMsgPart troopInfoCardEssenceMsgPart, FragmentManager fragmentManager) {
            super(fragmentManager);
            List<? extends TabInfo> emptyList;
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            this.f299569i = troopInfoCardEssenceMsgPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.tabList = emptyList;
                this.time = System.currentTimeMillis();
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoCardEssenceMsgPart, (Object) fragmentManager);
        }

        public final void d(@NotNull List<? extends TabInfo> list, boolean isFileTabInitialized, boolean isMsgTabInitialized) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, list, Boolean.valueOf(isFileTabInitialized), Boolean.valueOf(isMsgTabInitialized));
                return;
            }
            Intrinsics.checkNotNullParameter(list, "list");
            this.tabList = list;
            this.time = System.currentTimeMillis();
            if (isFileTabInitialized && !this.isFileTabInitialized) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isFileTabInitialized = z16;
            if (!isMsgTabInitialized || this.isMsgTabInitialized) {
                z17 = false;
            }
            this.isMsgTabInitialized = z17;
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NotNull ViewGroup container) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) container);
                return;
            }
            Intrinsics.checkNotNullParameter(container, "container");
            try {
                super.finishUpdate(container);
            } catch (Throwable th5) {
                QLog.e("TroopInfoCardEssenceMsgPart", 1, th5.getMessage(), th5);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.tabList.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Fragment) iPatchRedirector.redirect((short) 10, (Object) this, position);
            }
            int i3 = a.f299570a[this.tabList.get(position).ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                return new TroopEssenceGuideTabFragment();
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        return new TroopEssenceEmptyTabFragment();
                    }
                    return TroopEssenceMessageTabFragment.INSTANCE.a(this.isMsgTabInitialized);
                }
                return new TroopEssencePhotoVideoTabFragment();
            }
            return TroopEssenceFileTabFragment.INSTANCE.a(this.isFileTabInitialized);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, position)).longValue();
            }
            return super.getItemId(position) + this.time;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NotNull Object object) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, object)).intValue();
            }
            Intrinsics.checkNotNullParameter(object, "object");
            return -2;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f299571a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57203);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TabInfo.values().length];
            try {
                iArr[TabInfo.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabInfo.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f299571a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardEssenceMsgPart(@NotNull AppInterface appInterface) {
        List<? extends TabInfo> emptyList;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.appInterface = appInterface;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.tabBarList = emptyList;
    }

    private final TopGestureLayout R9() {
        View decorView = getPartHost().getHostActivity().getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null && (childAt instanceof ViewGroup)) {
            viewGroup = (ViewGroup) childAt;
        }
        if (viewGroup instanceof TopGestureLayout) {
            return (TopGestureLayout) viewGroup;
        }
        return null;
    }

    private final void S9() {
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel = this.essenceViewModel;
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel2 = null;
        if (troopInfoCardEssenceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
            troopInfoCardEssenceViewModel = null;
        }
        LiveData<List<TabInfo>> S1 = troopInfoCardEssenceViewModel.S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends TabInfo>, Unit> function1 = new Function1<List<? extends TabInfo>, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardEssenceMsgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends TroopInfoCardEssenceMsgPart.TabInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
            
                if (r6 == com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart.TabInfo.EMPTY) goto L37;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(List<? extends TroopInfoCardEssenceMsgPart.TabInfo> list) {
                QUIPageTabBar qUIPageTabBar;
                QUIPageTabBar qUIPageTabBar2;
                int collectionSizeOrDefault;
                TroopInfoCardEssenceMsgPart.b bVar;
                ViewPager viewPager;
                Object first;
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                qUIPageTabBar = TroopInfoCardEssenceMsgPart.this.tabBar;
                ViewPager viewPager2 = null;
                if (qUIPageTabBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                    qUIPageTabBar = null;
                }
                qUIPageTabBar.setVisibility(8);
                TroopInfoCardEssenceMsgPart troopInfoCardEssenceMsgPart = TroopInfoCardEssenceMsgPart.this;
                Intrinsics.checkNotNullExpressionValue(list, "list");
                troopInfoCardEssenceMsgPart.tabBarList = list;
                qUIPageTabBar2 = TroopInfoCardEssenceMsgPart.this.tabBar;
                if (qUIPageTabBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                    qUIPageTabBar2 = null;
                }
                List<? extends TroopInfoCardEssenceMsgPart.TabInfo> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((TroopInfoCardEssenceMsgPart.TabInfo) it.next()).getTitle());
                }
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                qUIPageTabBar2.setTabData((String[]) array);
                int i3 = 1;
                if (list.contains(TroopInfoCardEssenceMsgPart.TabInfo.FILE)) {
                    TroopInfoCardEssenceMsgPart.this.isFileTabInitialized = true;
                }
                if (list.contains(TroopInfoCardEssenceMsgPart.TabInfo.MESSAGE)) {
                    TroopInfoCardEssenceMsgPart.this.isMsgTabInitialized = true;
                }
                bVar = TroopInfoCardEssenceMsgPart.this.adapter;
                if (bVar != null) {
                    z16 = TroopInfoCardEssenceMsgPart.this.isFileTabInitialized;
                    z17 = TroopInfoCardEssenceMsgPart.this.isMsgTabInitialized;
                    bVar.d(list, z16, z17);
                }
                viewPager = TroopInfoCardEssenceMsgPart.this.viewPager;
                if (viewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager2 = viewPager;
                }
                if (!list.isEmpty()) {
                    if (list.size() == 1) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                    }
                    viewPager2.setImportantForAccessibility(i3);
                }
                i3 = 4;
                viewPager2.setImportantForAccessibility(i3);
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardEssenceMsgPart.T9(Function1.this, obj);
            }
        });
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel3 = this.essenceViewModel;
        if (troopInfoCardEssenceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
            troopInfoCardEssenceViewModel3 = null;
        }
        LiveData<Boolean> R1 = troopInfoCardEssenceViewModel3.R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardEssenceMsgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                TextView textView;
                ViewPager viewPager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                textView = TroopInfoCardEssenceMsgPart.this.title;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                textView.setVisibility(it.booleanValue() ? 0 : 8);
                viewPager = TroopInfoCardEssenceMsgPart.this.viewPager;
                if (viewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager = null;
                }
                viewPager.setBackground(it.booleanValue() ? TroopInfoCardEssenceMsgPart.this.getContext().getDrawable(R.drawable.qui_common_fill_light_primary_bg) : null);
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardEssenceMsgPart.U9(Function1.this, obj);
            }
        });
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel4 = this.essenceViewModel;
        if (troopInfoCardEssenceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
            troopInfoCardEssenceViewModel4 = null;
        }
        MediatorLiveData<Boolean> X1 = troopInfoCardEssenceViewModel4.X1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$initObserver$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardEssenceMsgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AlwaysCanDragFlingAppBarLayout alwaysCanDragFlingAppBarLayout;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                alwaysCanDragFlingAppBarLayout = TroopInfoCardEssenceMsgPart.this.appBarLayout;
                if (alwaysCanDragFlingAppBarLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                    alwaysCanDragFlingAppBarLayout = null;
                }
                alwaysCanDragFlingAppBarLayout.setCanCollapsedAppBar(!bool.booleanValue());
            }
        };
        X1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardEssenceMsgPart.V9(Function1.this, obj);
            }
        });
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel5 = this.essenceViewModel;
        if (troopInfoCardEssenceViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
        } else {
            troopInfoCardEssenceViewModel2 = troopInfoCardEssenceViewModel5;
        }
        LiveData<Boolean> Q1 = troopInfoCardEssenceViewModel2.Q1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$initObserver$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardEssenceMsgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIPageTabBar qUIPageTabBar;
                List list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    qUIPageTabBar = TroopInfoCardEssenceMsgPart.this.tabBar;
                    if (qUIPageTabBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                        qUIPageTabBar = null;
                    }
                    list = TroopInfoCardEssenceMsgPart.this.tabBarList;
                    qUIPageTabBar.setVisibility(list.size() == 2 ? 0 : 8);
                }
            }
        };
        Q1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardEssenceMsgPart.W9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(TroopInfoCardEssenceMsgPart this$0, int i3, boolean z16) {
        Object orNull;
        int i16;
        int i17;
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.tabBarList, i3);
        TabInfo tabInfo = (TabInfo) orNull;
        if (tabInfo == null) {
            i16 = -1;
        } else {
            i16 = c.f299571a[tabInfo.ordinal()];
        }
        if (i16 != 1) {
            i17 = 2;
            if (i16 != 2) {
                i17 = 0;
            }
        } else {
            i17 = 1;
        }
        TroopCardDtHelper troopCardDtHelper = TroopCardDtHelper.f299952a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("tab_name", Integer.valueOf(i17)));
        troopCardDtHelper.C(mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.u0k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ollapsing_toolbar_layout)");
        this.toolbarLayout = (CollapsingToolbarLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.sqk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.app_bar_layout)");
        this.appBarLayout = (AlwaysCanDragFlingAppBarLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f165109ux2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.essence_title_tv)");
        this.title = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.j_7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tab_bar)");
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) findViewById4;
        this.tabBar = qUIPageTabBar;
        QUIPageTabBar qUIPageTabBar2 = null;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        qUIPageTabBar.setAccessibilityTraversalAfter(R.id.title);
        View findViewById5 = rootView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.view_pager)");
        ViewPager viewPager = (ViewPager) findViewById5;
        this.viewPager = viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        viewPager.setAccessibilityTraversalAfter(R.id.j_7);
        Object partHost = getPartHost();
        if (partHost instanceof Fragment) {
            fragment = (Fragment) partHost;
        } else {
            fragment = null;
        }
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null) {
            this.adapter = new b(this, childFragmentManager);
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            viewPager2.setAdapter(this.adapter);
            QUIPageTabBar qUIPageTabBar3 = this.tabBar;
            if (qUIPageTabBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar3 = null;
            }
            ViewPager viewPager3 = this.viewPager;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager3 = null;
            }
            qUIPageTabBar3.setViewPager(viewPager3);
        }
        QUIPageTabBar qUIPageTabBar4 = this.tabBar;
        if (qUIPageTabBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
        } else {
            qUIPageTabBar2 = qUIPageTabBar4;
        }
        qUIPageTabBar2.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.an
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                TroopInfoCardEssenceMsgPart.X9(TroopInfoCardEssenceMsgPart.this, i3, z16);
            }
        });
        S9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopInfoCardEssenceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopInfoCa\u2026nceViewModel::class.java)");
        this.essenceViewModel = (TroopInfoCardEssenceViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.basicInfoViewModel = (TroopBasicInfoViewModel) viewModel2;
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel = this.essenceViewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (troopInfoCardEssenceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
            troopInfoCardEssenceViewModel = null;
        }
        troopInfoCardEssenceViewModel.W1();
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel2;
        }
        LiveData<Boolean> t26 = troopBasicInfoViewModel.t2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardEssenceMsgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean needShowEssenceGuide) {
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel2;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel3;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel4;
                TroopBasicInfoViewModel troopBasicInfoViewModel3;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) needShowEssenceGuide);
                    return;
                }
                troopInfoCardEssenceViewModel2 = TroopInfoCardEssenceMsgPart.this.essenceViewModel;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel6 = null;
                if (troopInfoCardEssenceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
                    troopInfoCardEssenceViewModel2 = null;
                }
                if (!troopInfoCardEssenceViewModel2.P1()) {
                    troopInfoCardEssenceViewModel3 = TroopInfoCardEssenceMsgPart.this.essenceViewModel;
                    if (troopInfoCardEssenceViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
                    } else {
                        troopInfoCardEssenceViewModel6 = troopInfoCardEssenceViewModel3;
                    }
                    troopInfoCardEssenceViewModel6.W1();
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(needShowEssenceGuide, "needShowEssenceGuide");
                if (needShowEssenceGuide.booleanValue()) {
                    troopBasicInfoViewModel3 = TroopInfoCardEssenceMsgPart.this.basicInfoViewModel;
                    if (troopBasicInfoViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                        troopBasicInfoViewModel3 = null;
                    }
                    if (!troopBasicInfoViewModel3.P2()) {
                        troopInfoCardEssenceViewModel5 = TroopInfoCardEssenceMsgPart.this.essenceViewModel;
                        if (troopInfoCardEssenceViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
                        } else {
                            troopInfoCardEssenceViewModel6 = troopInfoCardEssenceViewModel5;
                        }
                        troopInfoCardEssenceViewModel6.c2();
                        return;
                    }
                }
                troopInfoCardEssenceViewModel4 = TroopInfoCardEssenceMsgPart.this.essenceViewModel;
                if (troopInfoCardEssenceViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("essenceViewModel");
                } else {
                    troopInfoCardEssenceViewModel6 = troopInfoCardEssenceViewModel4;
                }
                troopInfoCardEssenceViewModel6.init();
            }
        };
        t26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardEssenceMsgPart.Y9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        TopGestureLayout R9 = R9();
        this.gestureLayout = R9;
        if (R9 != null) {
            R9.setInterceptTouchFlag(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        TopGestureLayout R9 = R9();
        this.gestureLayout = R9;
        if (R9 != null) {
            R9.setInterceptTouchFlag(false);
        }
    }
}
