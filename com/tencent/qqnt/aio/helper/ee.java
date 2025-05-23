package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.widget.PopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper$Entrance;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troopgift.GiftPanelControllerWithGiftRepo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.reserve2.Reserve2Event;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001&\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007\u00a2\u0006\u0004\b*\u0010+J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ee;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqnt/aio/helper/bc;", "Lcom/tencent/mvi/base/route/g;", "", "isRefresh", "Landroid/content/Intent;", "data", "Lcom/tencent/mobileqq/activity/aio/helper/GiftPanelHelper$Entrance;", "from", "", "g", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "e", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "Landroid/widget/PopupWindow;", "view", "a", "b", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/troopgift/GiftPanelControllerWithGiftRepo;", "Lcom/tencent/mobileqq/troopgift/GiftPanelControllerWithGiftRepo;", "giftRepo", "com/tencent/qqnt/aio/helper/ee$b", "f", "Lcom/tencent/qqnt/aio/helper/ee$b;", "mAction1", "<init>", "()V", tl.h.F, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class ee implements com.tencent.aio.main.businesshelper.h, bc, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftPanelControllerWithGiftRepo giftRepo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ee$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/e;", "c", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "d", "Lcom/tencent/mobileqq/aio/event/NTPanelEntrance;", "from", "Lcom/tencent/mobileqq/activity/aio/helper/GiftPanelHelper$Entrance;", "b", "", "troopUin", "Landroid/content/Intent;", "data", "", "e", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.ee$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.aio.helper.ee$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public /* synthetic */ class C9480a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f350774a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63602);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[NTPanelEntrance.values().length];
                try {
                    iArr[NTPanelEntrance.TROOP_GIFT_ITEM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_GIFT_ITEM_BACK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_BIRTH_ITEM.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_PLUS_PANEL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_PROFILE_CARD.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_GIFT_EASTER_EGG.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_BIRTH_BANNER.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[NTPanelEntrance.TROOP_BIRTH_PICK_MEMBER.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                f350774a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GiftPanelHelper$Entrance b(NTPanelEntrance from) {
            int i3;
            if (from == null) {
                i3 = -1;
            } else {
                i3 = C9480a.f350774a[from.ordinal()];
            }
            switch (i3) {
                case 1:
                    return GiftPanelHelper$Entrance.TROOP_GIFT_ITEM;
                case 2:
                    return GiftPanelHelper$Entrance.TROOP_GIFT_ITEM_BACK;
                case 3:
                    return GiftPanelHelper$Entrance.TROOP_BIRTH_ITEM;
                case 4:
                    return GiftPanelHelper$Entrance.TROOP_PLUS_PANEL;
                case 5:
                    return GiftPanelHelper$Entrance.TROOP_PROFILE_CARD;
                case 6:
                    return GiftPanelHelper$Entrance.TROOP_GIFT_EASTER_EGG;
                case 7:
                    return GiftPanelHelper$Entrance.TROOP_BIRTH_BANNER;
                case 8:
                    return GiftPanelHelper$Entrance.TROOP_BIRTH_PICK_MEMBER;
                default:
                    return GiftPanelHelper$Entrance.TROOP_NONE_FROM;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final com.tencent.qqnt.aio.e c(Activity activity) {
            FragmentActivity fragmentActivity;
            if (activity instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) activity;
            } else {
                fragmentActivity = 0;
            }
            if (fragmentActivity == 0) {
                return null;
            }
            if (fragmentActivity instanceof com.tencent.qqnt.aio.e) {
                return (com.tencent.qqnt.aio.e) fragmentActivity;
            }
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "tempActivity.supportFragmentManager");
            return d(supportFragmentManager);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final com.tencent.qqnt.aio.e d(FragmentManager fragmentManager) {
            List<Fragment> fragments = fragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof com.tencent.qqnt.aio.e) {
                    return (com.tencent.qqnt.aio.e) fragment;
                }
                Companion companion = ee.INSTANCE;
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
                com.tencent.qqnt.aio.e d16 = companion.d(childFragmentManager);
                if (d16 != null) {
                    return d16;
                }
            }
            return null;
        }

        public final void e(@NotNull Activity activity, @Nullable String troopUin, @NotNull Intent data, @Nullable NTPanelEntrance from) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, troopUin, data, from);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.qqnt.aio.e c16 = c(activity);
            if (c16 == null) {
                if (troopUin == null || troopUin.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    QLog.e("TroopGiftHelper", 1, "showPanel curTroopUin is null");
                    return;
                }
                GiftPanelControllerWithGiftRepo giftPanelControllerWithGiftRepo = new GiftPanelControllerWithGiftRepo(null);
                giftPanelControllerWithGiftRepo.W(troopUin);
                giftPanelControllerWithGiftRepo.X(data, ee.INSTANCE.b(from));
                return;
            }
            c16.sendMessage(new AIOTroopGiftEvent.TroopSendGiftEvent(false, data, from));
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ee$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ee.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                ee.this.e(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ee() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction1 = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent i3) {
        GiftPanelControllerWithGiftRepo giftPanelControllerWithGiftRepo;
        if (i3 instanceof AIOTroopGiftEvent.TroopSendGiftEvent) {
            AIOTroopGiftEvent.TroopSendGiftEvent troopSendGiftEvent = (AIOTroopGiftEvent.TroopSendGiftEvent) i3;
            g(troopSendGiftEvent.c(), troopSendGiftEvent.a(), INSTANCE.b(troopSendGiftEvent.b()));
        } else if ((i3 instanceof AIOTroopGiftEvent.SelectSendFriendEvent) && (giftPanelControllerWithGiftRepo = this.giftRepo) != null) {
            AIOTroopGiftEvent.SelectSendFriendEvent selectSendFriendEvent = (AIOTroopGiftEvent.SelectSendFriendEvent) i3;
            giftPanelControllerWithGiftRepo.m(selectSendFriendEvent.b(), selectSendFriendEvent.a());
        }
    }

    private final void g(boolean isRefresh, Intent data, GiftPanelHelper$Entrance from) {
        String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (this.giftRepo == null) {
            this.giftRepo = new GiftPanelControllerWithGiftRepo(this);
        }
        GiftPanelControllerWithGiftRepo giftPanelControllerWithGiftRepo = this.giftRepo;
        if (giftPanelControllerWithGiftRepo != null) {
            giftPanelControllerWithGiftRepo.W(str);
        }
        GiftPanelControllerWithGiftRepo giftPanelControllerWithGiftRepo2 = this.giftRepo;
        if (giftPanelControllerWithGiftRepo2 != null) {
            giftPanelControllerWithGiftRepo2.X(data, from);
        }
    }

    @Override // com.tencent.qqnt.aio.helper.bc
    public void a(@NotNull PopupWindow view) {
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new Reserve2Event.PopupWindowShowAtLocation(view, 17, 0, ViewUtils.dpToPx(-100.0f)));
        }
    }

    @Override // com.tencent.qqnt.aio.helper.bc
    public void b() {
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new AIOTroopGiftEvent.RequestBirthListEvent(true));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.A;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTroopGiftEvent.TroopSendGiftEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTroopGiftEvent.SelectSendFriendEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopGiftHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 != null && (e16 = a16.e()) != null) {
            e16.f(this, this.mAction1);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        }
    }
}
