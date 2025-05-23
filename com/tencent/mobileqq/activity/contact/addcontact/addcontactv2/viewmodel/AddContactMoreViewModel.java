package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.AddContactItemDeleteEvent;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.i;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 @2\u00020\u0001:\u0002ABB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0005R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f0 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020&0 8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00105\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isRefresh", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "d2", "", "errCode", "", "errMsg", "W1", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "mainPageDataList", "X1", "", "b2", SemanticAttributes.DbSystemValues.H2, "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "U1", "e2", "g2", "i", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_contentList", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "contentList", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "D", "_state", "E", "c2", "state", "Ljava/util/concurrent/atomic/AtomicBoolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasRetry", "<set-?>", "G", "Z", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Z", "hasMoreData", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "H", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "sessionWrapper", "", "I", "Ljava/util/List;", "addContactMainPageList", "<init>", "(Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;)V", "J", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactMoreViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<f>> contentList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _state;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> state;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean hasRetry;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasMoreData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private i sessionWrapper;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> addContactMainPageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AddContactDataType type;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<f>> _contentList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$a;", "", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "", "REC_LAST_BUDDY_LIST_REFRESH_TIME", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$a$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7147a implements ViewModelProvider.Factory {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AddContactDataType f180982a;

            C7147a(AddContactDataType addContactDataType) {
                this.f180982a = addContactDataType;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) addContactDataType);
                }
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
                }
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                return new AddContactMoreViewModel(this.f180982a);
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

        @NotNull
        public final ViewModelProvider.Factory a(@NotNull AddContactDataType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModelProvider.Factory) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            return new C7147a(type);
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$a;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$b;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$c;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0003\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$a;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "", "a", "Z", "d", "()Z", "success", "", "b", "I", "c", "()I", "listCount", "errCode", "", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(ZIILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final boolean success;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final int listCount;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final int errCode;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String errMsg;

            public /* synthetic */ a(boolean z16, int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
                this(z16, i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? "" : str);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), defaultConstructorMarker);
            }

            public final int a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
                }
                return this.errCode;
            }

            @NotNull
            public final String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return this.errMsg;
            }

            public final int c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return this.listCount;
            }

            public final boolean d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return this.success;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z16, int i3, int i16, @NotNull String errMsg) {
                super(null);
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), errMsg);
                    return;
                }
                this.success = z16;
                this.listCount = i3;
                this.errCode = i16;
                this.errMsg = errMsg;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$b;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "", "a", "Z", "()Z", "success", "<init>", "(Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7148b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final boolean success;

            public C7148b(boolean z16) {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                } else {
                    this.success = z16;
                }
            }

            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return this.success;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$c;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b;", "", "a", "Z", "()Z", "success", "<init>", "(Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class c extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final boolean success;

            public c(boolean z16) {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                } else {
                    this.success = z16;
                }
            }

            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return this.success;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddContactMoreViewModel(@NotNull AddContactDataType type) {
        List emptyList;
        List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> mutableList;
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableLiveData<List<f>> mutableLiveData = new MutableLiveData<>(emptyList);
        this._contentList = mutableLiveData;
        this.contentList = mutableLiveData;
        MutableLiveData<b> mutableLiveData2 = new MutableLiveData<>();
        this._state = mutableLiveData2;
        this.state = mutableLiveData2;
        this.hasRetry = new AtomicBoolean(false);
        this.hasMoreData = true;
        this.sessionWrapper = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.c.a();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.a.f180891a.c(type));
        this.addContactMainPageList = mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(boolean isRefresh, boolean isLoadMore, int errCode, String errMsg) {
        if (isRefresh) {
            this._state.postValue(new b.c(false));
        } else if (isLoadMore) {
            this._state.postValue(new b.c(false));
        } else {
            this._state.postValue(new b.a(false, 0, errCode, errMsg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> X1(List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list2) {
        boolean z16;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) obj;
            List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list3 = list2;
            boolean z17 = false;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar2 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) it.next();
                    String str3 = null;
                    if (cVar.f() != null) {
                        RecommendTroopItem f16 = cVar.f();
                        if (f16 != null) {
                            str2 = f16.uin;
                        } else {
                            str2 = null;
                        }
                        RecommendTroopItem f17 = cVar2.f();
                        if (f17 != null) {
                            str3 = f17.uin;
                        }
                        z16 = Intrinsics.areEqual(str2, str3);
                    } else if (cVar.e() != null) {
                        MayKnowRecommend e16 = cVar.e();
                        if (e16 != null) {
                            str = e16.uin;
                        } else {
                            str = null;
                        }
                        MayKnowRecommend e17 = cVar2.e();
                        if (e17 != null) {
                            str3 = e17.uin;
                        }
                        z16 = Intrinsics.areEqual(str, str3);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            if (!z17) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(final boolean isRefresh, final boolean isLoadMore) {
        if (!AppNetConnInfo.isNetSupport()) {
            W1(isRefresh, isLoadMore, -1, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
        } else {
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b.f180893a.j(this.type, 0, this.sessionWrapper, new Function1<h, Unit>(isLoadMore, isRefresh) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel$loadData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isLoadMore;
                final /* synthetic */ boolean $isRefresh;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$isLoadMore = isLoadMore;
                    this.$isRefresh = isRefresh;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AddContactMoreViewModel.this, Boolean.valueOf(isLoadMore), Boolean.valueOf(isRefresh));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(h hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
                
                    r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(@NotNull h it) {
                    List list;
                    List list2;
                    List X1;
                    MutableLiveData mutableLiveData;
                    List list3;
                    MutableLiveData mutableLiveData2;
                    List list4;
                    List list5;
                    MutableLiveData mutableLiveData3;
                    MutableLiveData mutableLiveData4;
                    List arrayList;
                    List list6;
                    List X12;
                    AtomicBoolean atomicBoolean;
                    MutableLiveData mutableLiveData5;
                    MutableLiveData mutableLiveData6;
                    AtomicBoolean atomicBoolean2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    AddContactMoreViewModel.this.hasMoreData = !it.c();
                    AddContactMoreViewModel.this.sessionWrapper = it.b();
                    List<g> a16 = it.a();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it5 = a16.iterator();
                    while (it5.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((g) it5.next()).c());
                    }
                    if (this.$isLoadMore) {
                        List<f> value = AddContactMoreViewModel.this.Z1().getValue();
                        if (value == null || arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        AddContactMoreViewModel addContactMoreViewModel = AddContactMoreViewModel.this;
                        list6 = addContactMoreViewModel.addContactMainPageList;
                        X12 = addContactMoreViewModel.X1(arrayList2, list6);
                        if (!it.c() && X12.isEmpty()) {
                            atomicBoolean2 = AddContactMoreViewModel.this.hasRetry;
                            if (atomicBoolean2.compareAndSet(false, true)) {
                                QLog.i("AddContactMoreViewModel", 1, "filter data is empty, need to retry load data");
                                AddContactMoreViewModel.this.d2(false, true);
                                return;
                            }
                        }
                        atomicBoolean = AddContactMoreViewModel.this.hasRetry;
                        atomicBoolean.compareAndSet(true, false);
                        arrayList.addAll(X12);
                        mutableLiveData5 = AddContactMoreViewModel.this._contentList;
                        mutableLiveData5.postValue(arrayList);
                        mutableLiveData6 = AddContactMoreViewModel.this._state;
                        mutableLiveData6.postValue(new AddContactMoreViewModel.b.C7148b(true));
                        return;
                    }
                    if (this.$isRefresh) {
                        list5 = AddContactMoreViewModel.this.addContactMainPageList;
                        list5.clear();
                        mutableLiveData3 = AddContactMoreViewModel.this._contentList;
                        mutableLiveData3.postValue(arrayList2);
                        mutableLiveData4 = AddContactMoreViewModel.this._state;
                        mutableLiveData4.postValue(new AddContactMoreViewModel.b.c(true));
                        return;
                    }
                    list = AddContactMoreViewModel.this.addContactMainPageList;
                    AddContactMoreViewModel addContactMoreViewModel2 = AddContactMoreViewModel.this;
                    list2 = addContactMoreViewModel2.addContactMainPageList;
                    X1 = addContactMoreViewModel2.X1(arrayList2, list2);
                    list.addAll(X1);
                    mutableLiveData = AddContactMoreViewModel.this._contentList;
                    list3 = AddContactMoreViewModel.this.addContactMainPageList;
                    mutableLiveData.postValue(list3);
                    mutableLiveData2 = AddContactMoreViewModel.this._state;
                    list4 = AddContactMoreViewModel.this.addContactMainPageList;
                    mutableLiveData2.postValue(new AddContactMoreViewModel.b.a(true, list4.size(), 0, null, 12, null));
                }
            }, new Function2<Integer, String, Unit>(isRefresh, isLoadMore) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel$loadData$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isLoadMore;
                final /* synthetic */ boolean $isRefresh;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$isRefresh = isRefresh;
                    this.$isLoadMore = isLoadMore;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AddContactMoreViewModel.this, Boolean.valueOf(isRefresh), Boolean.valueOf(isLoadMore));
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) errMsg);
                    } else {
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        AddContactMoreViewModel.this.W1(this.$isRefresh, this.$isLoadMore, i3, errMsg);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void f2(AddContactMoreViewModel addContactMoreViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        addContactMoreViewModel.e2(z16);
    }

    public final void U1(@NotNull String id5, @NotNull AddContactDataType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) id5, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        List<f> value = this._contentList.getValue();
        if (value == null) {
            return;
        }
        List<f> b16 = AddContactModelHelper.f180979a.b(value, id5, type);
        this._contentList.setValue(b16);
        this._state.setValue(new b.a(true, b16.size(), 0, null, 12, null));
        SimpleEventBus.getInstance().dispatchEvent(new AddContactItemDeleteEvent(id5, type));
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b.f180893a.d(id5, com.tencent.mobileqq.troop.addcontact.model.a.a(type));
    }

    @NotNull
    public final LiveData<List<f>> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contentList;
    }

    public final boolean a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.hasMoreData;
    }

    public final long b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return com.tencent.mobileqq.troop.config.a.l(com.tencent.mobileqq.troop.config.a.f294689a, "last_buddy_list_refresh_time", 0L, false, 4, null);
    }

    @NotNull
    public final LiveData<b> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.state;
    }

    public final void e2(boolean isRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isRefresh);
        } else {
            d2(isRefresh, false);
        }
    }

    public final void g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (!this.hasMoreData) {
                return;
            }
            d2(false, true);
        }
    }

    public final void h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.troop.config.a.x(com.tencent.mobileqq.troop.config.a.f294689a, "last_buddy_list_refresh_time", System.currentTimeMillis(), false, 4, null);
        }
    }
}
