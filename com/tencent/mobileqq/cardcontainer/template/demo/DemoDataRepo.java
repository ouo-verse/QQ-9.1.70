package com.tencent.mobileqq.cardcontainer.template.demo;

import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl;
import com.tencent.mobileqq.cardcontainer.framework.i;
import com.tencent.mobileqq.cardcontainer.template.demo.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u0010\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001b\u0010\u0019\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoDataRepo;", "Lcom/tencent/mobileqq/cardcontainer/framework/i;", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "g", tl.h.F, "", "type", "i", "", "now", "l", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "callback", "d", "a", "cardData", "position", "b", "c", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "mNotifyTime", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DemoDataRepo implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mNotifyTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoDataRepo$a;", "", "Lcom/tencent/mobileqq/cardcontainer/g;", "a", "", "SECONDS_PER_DAY", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.demo.DemoDataRepo$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final com.tencent.mobileqq.cardcontainer.g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.cardcontainer.g) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new CardsViewModelImpl(new DemoDataRepo());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DemoDataRepo() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(DemoDataRepo$mNotifyTime$2.INSTANCE);
            this.mNotifyTime = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ContainerData g() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 5; i3++) {
            arrayList.add(new com.tencent.mobileqq.cardcontainer.data.b(String.valueOf(i3), currentUin, null, null, null, null, "{\"birthday\":" + (m() + (86400 * i3)) + ", \"uin\":" + currentUin + "}", ""));
        }
        ContainerData g16 = com.tencent.mobileqq.cardcontainer.b.f201051a.g(new ContainerData(0, CardType.GroupMsgReminder, "", null, QzoneConfig.DefaultValue.USERHOME_BAR_NAME, "", arrayList, "{\"button\": {\"text\":\"\u4e00\u952e\u751f\u65e5\u795d\u798f\",\"iconUrl\":\"\"},\"boxSubTitle\":\"\u795d\u798f\u4f1a\u5728\u751f\u65e5\u5f53\u5929\u9001\u8fbe\",\"dataDate\":" + l(System.currentTimeMillis()) + "}", ""));
        Intrinsics.checkNotNull(g16);
        return g16;
    }

    private final ContainerData h() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 5; i3++) {
            arrayList.add(new com.tencent.mobileqq.cardcontainer.data.b(String.valueOf(i3), currentUin, null, null, null, null, null, ""));
        }
        ContainerData g16 = com.tencent.mobileqq.cardcontainer.b.f201051a.g(new ContainerData(0, CardType.SelfGroupMsgReminder, "", null, "\uff0c\u751f\u65e5\u5feb\u4e50\uff01", arrayList.size() + "\u4f4d\u597d\u53cb\u7ed9\u4f60\u53d1\u4e86\u751f\u65e5\u795d\u798f", arrayList, "{\n    \"nick\": \"Test\",\n    \"actionButtonList\": [{\n    \"text\": \"\u4e00\u952e\u7b54\u8c22\",\n    \"jumpUrl\": \"\"\n}],\n    \"headBgUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20240926/3fd3861009e6659028ae06af40b8e853.png\",\n    \"headPendantUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20240926/8205da4c89048870e7279f9695290d46.png\",\n    \"dataDate\": " + l(System.currentTimeMillis()) + "\n}", ""));
        Intrinsics.checkNotNull(g16);
        return g16;
    }

    private final ContainerData i(int type) {
        String trimIndent;
        ArrayList arrayListOf;
        MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        com.tencent.mobileqq.cardcontainer.b bVar = com.tencent.mobileqq.cardcontainer.b.f201051a;
        CardType cardType = CardType.ImageNoButton;
        trimIndent = StringsKt__IndentKt.trimIndent("\n                            {\n                                \"type\": " + type + ",\n                                \"avatar\":\"https://avatar.qpic.cn/xxxxxxxx\"\n                            }\n                        ");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("857", "", "diwei", "\u4eca\u5929\u5929\u6c14\u4e0d\u9519", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", trimIndent, ""));
        ContainerData g16 = bVar.g(new ContainerData(0, cardType, "", null, "QQ\u7a7a\u95f4", "", arrayListOf, "", ""));
        Intrinsics.checkNotNull(g16);
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback, DemoDataRepo this$0) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        List listOf;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CardType cardType = CardType.IconPlusOneBtn;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id1", "", "\u6362\u4e2a\u8eab\u4efd\n\u7ed3\u4f34\u5f00\u804a", "3\u79d2\u9047\u89c1\u5174\u8da3\u540c\u597d", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageLightUrl\": \"https://downv6.qq.com/innovate/guild/demo/avatar_icon2.png\",\n    \"imageDarkUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"bgLightUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"bgDarkUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u53bb\u804a\u5929\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        CardType cardType2 = CardType.AvatarPlusOneBtn;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id1", "", "kiki", "2\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb2\",\n    \"uin\": \"3959552880\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id2", "", "\u5c0f\u5f3a", "2\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id3", "", "\u5c0f\u660e", "3\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=3377127604", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=3377127604&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        a.Companion companion = a.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ContainerData[]{this$0.g(), this$0.h(), this$0.i(1), this$0.i(2), this$0.i(3), new com.tencent.mobileqq.cardcontainer.template.iconbtn.b(new ContainerData(99, cardType, "", "", "", "", arrayListOf, "", "")), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(100, cardType2, "", "", "", "", arrayListOf2, "", ""), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(101, cardType2, "", "", "", "", arrayListOf3, "", ""), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(102, cardType2, "", "", "", "", arrayListOf4, "", ""), companion.a(1, "card 1", SupportMenu.CATEGORY_MASK), companion.a(2, "card 2", -16711936), companion.a(3, "card 3", -16776961)});
        callback.invoke(listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 callback, DemoDataRepo this$0) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        List listOf;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CardType cardType = CardType.IconPlusOneBtn;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id1", "", "\u6362\u4e2a\u8eab\u4efd\n\u7ed3\u4f34\u5f00\u804a", "3\u79d2\u9047\u89c1\u5174\u8da3\u540c\u597d", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageLightUrl\": \"https://downv6.qq.com/innovate/guild/demo/avatar_icon2.png\",\n    \"imageDarkUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"bgLightUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"bgDarkUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u53bb\u804a\u5929\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        CardType cardType2 = CardType.AvatarPlusOneBtn;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id1", "", "momo", "1\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n     \"uin\": \"3959552880\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id2", "", "\u5c0f\u5f3a", "2\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id3", "", "\u5c0f\u660e", "3\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=3377127604", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=3377127604&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        a.Companion companion = a.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ContainerData[]{this$0.g(), this$0.h(), this$0.i(1), this$0.i(2), this$0.i(3), new com.tencent.mobileqq.cardcontainer.template.iconbtn.b(new ContainerData(99, cardType, "", "", "", "", arrayListOf, "", "")), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(104, cardType2, "", "", "", "", arrayListOf2, "", ""), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(101, cardType2, "", "", "", "", arrayListOf3, "", ""), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(102, cardType2, "", "", "", "", arrayListOf4, "", ""), companion.a(4, "card 4", -65281), companion.a(1, "card 1", -16776961), companion.a(2, "card 2", -16711936), companion.a(3, "card 3", -16776961)});
        callback.invoke(listOf);
    }

    private final int l(long now) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(now);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    private final long m() {
        return ((Number) this.mNotifyTime.getValue()).longValue();
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void a(@NotNull final Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.template.demo.f
                @Override // java.lang.Runnable
                public final void run() {
                    DemoDataRepo.k(Function1.this, this);
                }
            }, 6000L);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void b(@NotNull com.tencent.mobileqq.cardcontainer.data.a cardData, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cardData, position);
            return;
        }
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        QLog.d("DemoDataRepo", 2, "onCardDeleted: " + cardData + ", position: " + position);
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    @NotNull
    public List<com.tencent.mobileqq.cardcontainer.data.a> c() {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        List<com.tencent.mobileqq.cardcontainer.data.a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        CardType cardType = CardType.AvatarPlusOneBtn;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id1", "", "kiki", "2\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb2\",\n     \"uin\": \"3959552880\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b("id2", "", "\u5c0f\u5f3a", "2\u4e2a\u5171\u540c\u7fa4\u804a", "", "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&uin=1037032381", "{\n    \"imageUrl\": \"https://downv6.qq.com/innovate/guild/sfeed/mvp_voice_lobby_app_bg.png\",\n    \"btnText\": \"\u52a0\u597d\u53cb\",\n    \"btnScheme\": \"mqqapi://relation/addFriend?uin=1037032381&addFriendVCType=1&sourceID=2004&subSourceID=0\"\n}", ""));
        a.Companion companion = a.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ContainerData[]{i(1), i(2), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(100, cardType, "", "", "", "", arrayListOf, "", ""), new com.tencent.mobileqq.cardcontainer.template.avatarbtn.b(101, cardType, "", "", "", "", arrayListOf2, "", ""), companion.a(1, "card 1", SupportMenu.CATEGORY_MASK), companion.a(2, "card 2", -16711936)});
        return listOf;
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void d(@NotNull final Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.template.demo.g
                @Override // java.lang.Runnable
                public final void run() {
                    DemoDataRepo.j(Function1.this, this);
                }
            }, 100L);
        }
    }
}
