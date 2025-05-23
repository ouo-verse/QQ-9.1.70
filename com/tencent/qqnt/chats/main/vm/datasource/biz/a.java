package com.tencent.qqnt.chats.main.vm.datasource.biz;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.biz.gamebox.IGameBoxApplyPartnerApi;
import com.tencent.qqnt.chats.biz.gamebox.IGameBoxChatsHelper;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001M\u0018\u0000 )2\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010S\u001a\u00020$\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\bH\u0002JP\u0010\u0011\u001a\u00020\u00102\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\fH\u0002J8\u0010\u0012\u001a\u00020\u00102\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\fH\u0002J(\u0010\u0018\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J(\u0010\u001a\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010&\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010,\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J8\u00103\u001a\u00020\u00102\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-2\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020.\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000-H\u0016J\b\u00104\u001a\u00020\u0010H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R&\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010ER \u0010L\u001a\b\u0012\u0004\u0012\u00020H0G8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010I\u001a\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006V"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/a;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "", "w", "src", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "t", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sortedList", "changedList", "applyPartnerList", "", "u", "y", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "applyPartnerBoxInfo", "B", "newItem", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "chatUin", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "i", "g", DomainData.DOMAIN_NAME, "f", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "opChanged", "", "", "opGetPayload", "l", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "b", "Ljava/lang/Long;", "applyPartnerBoxMockFromContactId", "c", "Ljava/util/ArrayList;", "applyPartnerContactList", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "d", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "platformDataSource", "Lcom/tencent/qqnt/chats/data/converter/b;", "e", "Lcom/tencent/qqnt/chats/data/converter/b;", "mChatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "localDataSource", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "com/tencent/qqnt/chats/main/vm/datasource/biz/a$b", tl.h.F, "Lcom/tencent/qqnt/chats/main/vm/datasource/biz/a$b;", "platformListenerWrapper", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "gameBoxScene", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;I)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecentContactInfo applyPartnerBoxInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long applyPartnerBoxMockFromContactId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile ArrayList<RecentContactInfo> applyPartnerContactList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PlatformRecentContactsDataSource platformDataSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.converter.b mChatsItemConverter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalChatsCacheDataSource localDataSource;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b platformListenerWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/a$a;", "", "", "TAG", "Ljava/lang/String;", "", "WANGZHE_APP_ID", "J", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.biz.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000eH\u0016\u00a8\u0006\u001c"}, d2 = {"com/tencent/qqnt/chats/main/vm/datasource/biz/a$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "", "isGuildUpdate", "", "f", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "b", "", "uidList", "d", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "onLitterEarChange", "", "result", "errMsg", "curSpecifyInfo", "a", NotificationCompat.CATEGORY_ERROR, "msg", "e", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.chats.main.vm.datasource.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f355387a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f355388b;

        b(int i3, a aVar) {
            this.f355387a = i3;
            this.f355388b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(result), errMsg, curSpecifyInfo);
            } else {
                this.f355388b.localDataSource.a(result, errMsg, curSpecifyInfo);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void b(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> changedList, boolean isGuildUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, sortedContactList, changedList, Boolean.valueOf(isGuildUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
            Intrinsics.checkNotNullParameter(changedList, "changedList");
            if (this.f355387a == 1) {
                ArrayList arrayList = new ArrayList(changedList);
                ArrayList arrayList2 = new ArrayList(sortedContactList);
                this.f355388b.y(arrayList2, arrayList);
                this.f355388b.localDataSource.b(arrayList2, arrayList, isGuildUpdate);
                return;
            }
            this.f355388b.localDataSource.b(sortedContactList, changedList, isGuildUpdate);
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void c(@NotNull List<Long> uinList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uinList);
            } else {
                Intrinsics.checkNotNullParameter(uinList, "uinList");
                this.f355388b.localDataSource.c(uinList);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void d(@NotNull List<String> uidList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uidList);
            } else {
                Intrinsics.checkNotNullParameter(uidList, "uidList");
                this.f355388b.localDataSource.d(uidList);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void e(int err, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, err, (Object) msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                this.f355388b.localDataSource.e(err, msg2);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, info, Boolean.valueOf(isGuildUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if (this.f355387a == 1) {
                this.f355388b.v(info);
            }
            this.f355388b.localDataSource.f(info, isGuildUpdate);
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void onLitterEarChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f355388b.localDataSource.onLitterEarChange();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull LifecycleCoroutineScope scope, int i3) {
        List emptyList;
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, i3);
            return;
        }
        this.applyPartnerContactList = new ArrayList<>();
        this.platformDataSource = new PlatformRecentContactsDataSource(4);
        com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(4);
        this.mChatsItemConverter = bVar;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        LocalChatsCacheDataSource localChatsCacheDataSource = new LocalChatsCacheDataSource(bVar, emptyList, ((IGameBoxChatsHelper) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGameBoxChatsHelper.class)).getLocalChatsFilter(i3), false, 8, null);
        this.localDataSource = localChatsCacheDataSource;
        this.dataNotify = localChatsCacheDataSource.r();
        this.platformListenerWrapper = new b(i3, this);
    }

    private final void A(ArrayList<RecentContactInfo> applyPartnerList, RecentContactInfo newItem) {
        int size = applyPartnerList.size();
        while (true) {
            size--;
            if (-1 < size) {
                if (newItem.contactId == applyPartnerList.get(size).contactId) {
                    applyPartnerList.remove(size);
                }
            } else {
                applyPartnerList.add(newItem);
                return;
            }
        }
    }

    private final void B(ArrayList<RecentContactInfo> applyPartnerList, RecentContactInfo applyPartnerBoxInfo) {
        Iterator<RecentContactInfo> it = applyPartnerList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().unreadCnt;
        }
        applyPartnerBoxInfo.unreadCnt = j3;
    }

    private final TempChatGameSession t(TempChatGameSession src) {
        TempChatGameSession tempChatGameSession = new TempChatGameSession();
        tempChatGameSession.gameAppId = src.gameAppId;
        tempChatGameSession.nickname = src.nickname;
        tempChatGameSession.selfTinyId = src.selfTinyId;
        tempChatGameSession.selfRoleId = src.selfRoleId;
        tempChatGameSession.selfOpenId = src.selfOpenId;
        tempChatGameSession.peerTinyId = src.peerTinyId;
        tempChatGameSession.peerRoleId = src.peerRoleId;
        tempChatGameSession.peerOpenId = src.peerOpenId;
        tempChatGameSession.pushWindowFlag = src.pushWindowFlag;
        tempChatGameSession.sayHiType = src.sayHiType;
        tempChatGameSession.redPointSwitch = src.redPointSwitch;
        tempChatGameSession.seekingPartner = src.seekingPartner;
        return tempChatGameSession;
    }

    private final void u(ArrayList<Long> sortedList, ArrayList<RecentContactInfo> changedList, ArrayList<RecentContactInfo> applyPartnerList) {
        QLog.d("GameBoxChatsRepo", 2, "generateApplyPartnerBoxByAllChange sortedListSize=: " + sortedList.size() + ",changedListSize= " + changedList.size() + "\"");
        int size = sortedList.size();
        RecentContactInfo recentContactInfo = null;
        for (int size2 = applyPartnerList.size() + (-1); -1 < size2; size2--) {
            int indexOf = sortedList.indexOf(Long.valueOf(applyPartnerList.get(size2).contactId));
            if (indexOf < 0) {
                applyPartnerList.remove(size2);
            } else if (indexOf < size) {
                recentContactInfo = applyPartnerList.get(size2);
                size = indexOf;
            }
        }
        if (recentContactInfo == null) {
            this.applyPartnerBoxInfo = null;
            this.applyPartnerBoxMockFromContactId = null;
        } else {
            RecentContactInfo x16 = x(recentContactInfo);
            this.applyPartnerBoxInfo = x16;
            this.applyPartnerBoxMockFromContactId = Long.valueOf(x16.contactId);
            x16.contactId += System.currentTimeMillis();
            x16.topFlag = (byte) 0;
            B(applyPartnerList, x16);
            changedList.add(x16);
            sortedList.add(size, Long.valueOf(x16.contactId));
            QLog.d("GameBoxChatsRepo", 2, "generateApplyPartnerBoxByAllChange mock box id=" + x16.contactId);
        }
        QLog.d("GameBoxChatsRepo", 2, "generateApplyPartnerBoxByAllChange after sortedListSize=: " + sortedList.size() + ",changedListSize= " + changedList.size() + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(RecentContactListChangedInfo info) {
        QLog.d("GameBoxChatsRepo", 2, "generateApplyPartnerBoxByListChanged notificationType:" + info.notificationType);
        if (info.notificationType != 1) {
            ArrayList<Long> arrayList = info.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "info.sortedContactList");
            ArrayList<RecentContactInfo> arrayList2 = info.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "info.changedList");
            y(arrayList, arrayList2);
            return;
        }
        this.applyPartnerBoxInfo = null;
        this.applyPartnerBoxMockFromContactId = null;
        ArrayList<RecentContactInfo> arrayList3 = new ArrayList<>();
        Iterator<RecentContactInfo> it = info.changedList.iterator();
        while (it.hasNext()) {
            RecentContactInfo item = it.next();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (w(item)) {
                arrayList3.add(item);
                QLog.d("GameBoxChatsRepo", 2, "generateApplyPartnerBoxByListChanged ApplyPartner contact id=: " + item.contactId);
            }
        }
        ArrayList<Long> arrayList4 = info.sortedContactList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "info.sortedContactList");
        ArrayList<RecentContactInfo> arrayList5 = info.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList5, "info.changedList");
        u(arrayList4, arrayList5, arrayList3);
        z(arrayList3);
        this.applyPartnerContactList = arrayList3;
    }

    private final boolean w(RecentContactInfo contact) {
        TempChatGameSession gameSession;
        ArrayList<RecentContactExtAttr> arrayList = contact.extAttrs;
        if (arrayList == null) {
            return false;
        }
        Iterator<RecentContactExtAttr> it = arrayList.iterator();
        while (it.hasNext()) {
            RecentContactExtAttr next = it.next();
            if (next != null && (gameSession = next.gameSession) != null) {
                Intrinsics.checkNotNullExpressionValue(gameSession, "gameSession");
                Integer num = gameSession.seekingPartner;
                if (num == null || num.intValue() != 1 || gameSession.gameAppId != 1104466820) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private final RecentContactInfo x(RecentContactInfo src) {
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.f359204id = src.f359204id;
        recentContactInfo.contactId = src.contactId;
        recentContactInfo.sortField = src.sortField;
        recentContactInfo.chatType = src.chatType;
        recentContactInfo.senderUid = src.senderUid;
        recentContactInfo.senderUin = src.senderUin;
        recentContactInfo.peerUid = src.peerUid;
        recentContactInfo.peerUin = src.peerUin;
        recentContactInfo.msgSeq = src.msgSeq;
        recentContactInfo.c2cClientMsgSeq = src.c2cClientMsgSeq;
        recentContactInfo.msgUid = src.msgUid;
        recentContactInfo.msgRandom = src.msgRandom;
        recentContactInfo.msgTime = src.msgTime;
        recentContactInfo.sendRemarkName = src.sendRemarkName;
        recentContactInfo.sendMemberName = src.sendMemberName;
        recentContactInfo.sendNickName = src.sendNickName;
        recentContactInfo.peerName = src.peerName;
        recentContactInfo.remark = src.remark;
        recentContactInfo.avatarUrl = src.avatarUrl;
        recentContactInfo.avatarPath = src.avatarPath;
        recentContactInfo.abstractContent = src.abstractContent;
        recentContactInfo.sendStatus = src.sendStatus;
        recentContactInfo.topFlag = src.topFlag;
        recentContactInfo.topFlagTime = src.topFlagTime;
        recentContactInfo.draftFlag = src.draftFlag;
        recentContactInfo.draftTime = src.draftTime;
        recentContactInfo.specialCareFlag = src.specialCareFlag;
        recentContactInfo.sessionType = src.sessionType;
        recentContactInfo.shieldFlag = src.shieldFlag;
        recentContactInfo.atType = src.atType;
        recentContactInfo.draft = src.draft;
        recentContactInfo.hiddenFlag = src.hiddenFlag;
        recentContactInfo.keepHiddenFlag = src.keepHiddenFlag;
        recentContactInfo.isMsgDisturb = src.isMsgDisturb;
        recentContactInfo.nestedSortedContactList = src.nestedSortedContactList;
        recentContactInfo.nestedChangedList = src.nestedChangedList;
        recentContactInfo.unreadCnt = src.unreadCnt;
        recentContactInfo.unreadChatCnt = src.unreadChatCnt;
        recentContactInfo.unreadFlag = src.unreadFlag;
        recentContactInfo.isBeat = src.isBeat;
        recentContactInfo.isOnlineMsg = src.isOnlineMsg;
        recentContactInfo.msgId = src.msgId;
        recentContactInfo.notifiedType = src.notifiedType;
        recentContactInfo.isBlock = src.isBlock;
        recentContactInfo.listOfSpecificEventTypeInfosInMsgBox = src.listOfSpecificEventTypeInfosInMsgBox;
        recentContactInfo.guildContactInfo = src.guildContactInfo;
        recentContactInfo.vasPersonalInfo = src.vasPersonalInfo;
        recentContactInfo.vasMsgInfo = src.vasMsgInfo;
        recentContactInfo.anonymousFlag = src.anonymousFlag;
        recentContactInfo.extBuffer = null;
        recentContactInfo.extAttrs = new ArrayList<>();
        recentContactInfo.liteBusiness = src.liteBusiness;
        ArrayList<RecentContactExtAttr> arrayList = src.extAttrs;
        if (arrayList != null) {
            Iterator<RecentContactExtAttr> it = arrayList.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next.gameSession != null) {
                    RecentContactExtAttr recentContactExtAttr = new RecentContactExtAttr();
                    TempChatGameSession tempChatGameSession = next.gameSession;
                    Intrinsics.checkNotNullExpressionValue(tempChatGameSession, "attr.gameSession");
                    TempChatGameSession t16 = t(tempChatGameSession);
                    recentContactExtAttr.gameSession = t16;
                    t16.seekingPartner = 10000;
                    recentContactInfo.extAttrs.add(recentContactExtAttr);
                }
            }
        }
        return recentContactInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ArrayList<Long> sortedList, ArrayList<RecentContactInfo> changedList) {
        ArrayList<RecentContactInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.applyPartnerContactList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<RecentContactInfo> it = changedList.iterator();
        while (it.hasNext()) {
            RecentContactInfo item = it.next();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (w(item)) {
                arrayList2.add(item);
                QLog.d("GameBoxChatsRepo", 2, "refreshApplyPartnerBoxByPartChange ApplyPartner contact id=: " + item.contactId);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            RecentContactInfo item2 = (RecentContactInfo) it5.next();
            Intrinsics.checkNotNullExpressionValue(item2, "item");
            A(arrayList, item2);
        }
        u(sortedList, changedList, arrayList);
        z(arrayList);
        this.applyPartnerContactList = arrayList;
    }

    private final void z(ArrayList<RecentContactInfo> applyPartnerList) {
        ArrayList arrayList = new ArrayList();
        Iterator<RecentContactInfo> it = applyPartnerList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f359204id);
        }
        ((IGameBoxApplyPartnerApi) QRoute.api(IGameBoxApplyPartnerApi.class)).updateApplyPartnerIdList(arrayList);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.platformDataSource.o(null);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.platformDataSource.d(this.platformListenerWrapper);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return IRecentContactRepo.a.e(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.platformDataSource.y(this.platformListenerWrapper);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, gVar, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            IRecentContactRepo.a.j(this, gVar, i3, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.g(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.w(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        } else {
            this.platformDataSource.o(callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            IRecentContactRepo.a.g(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.x(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo recentContactInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) recentContactInfo, i3);
        } else {
            IRecentContactRepo.a.i(this, recentContactInfo, i3);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
        } else {
            Intrinsics.checkNotNullParameter(chatUid, "chatUid");
            this.platformDataSource.A(chatUid, chatUin, isTop, contactType, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) opChanged, (Object) opGetPayload);
            return;
        }
        Intrinsics.checkNotNullParameter(opChanged, "opChanged");
        Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        this.localDataSource.v(opChanged, opGetPayload, 1);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            IRecentContactRepo.a.o(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void n(@NotNull RecentContactInfo contact, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) contact, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(contact, "contact");
            this.platformDataSource.h(contact, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @NotNull
    public com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.data.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataNotify;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            IRecentContactRepo.a.n(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void q(@Nullable com.tencent.qqnt.chats.main.vm.datasource.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dVar);
        } else {
            IRecentContactRepo.a.p(this, dVar);
        }
    }
}
